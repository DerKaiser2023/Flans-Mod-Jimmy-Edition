package com.flansmod.common.network;

import com.flansmod.client.FlansModClient;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.teams.PlayerClass;
import com.flansmod.common.teams.Team;
import com.flansmod.common.teams.TeamsManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketTeamInfo extends PacketBase {
   public static String mapShortName;
   public static String map;
   public static String gametype;
   public static boolean showZombieScore;
   public static int numTeams;
   public static PacketTeamInfo.TeamData[] teamData;
   public static boolean sortedByTeam;
   public static int timeLeft;
   public static int scoreLimit;
   public static int numLines;

   public static PacketTeamInfo.PlayerScoreData getPlayerScoreData(String username) {
      PacketTeamInfo var10000 = FlansModClient.teamInfo;
      if (teamData == null) {
         return null;
      } else {
         var10000 = FlansModClient.teamInfo;
         PacketTeamInfo.TeamData[] var1 = teamData;
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            PacketTeamInfo.TeamData team = var1[var3];
            if (team == null || team.playerData == null) {
               return null;
            }

            PacketTeamInfo.PlayerScoreData[] var5 = team.playerData;
            int var6 = var5.length;

            for(int var7 = 0; var7 < var6; ++var7) {
               PacketTeamInfo.PlayerScoreData player = var5[var7];
               if (player != null && player.username != null && player.username.equals(username)) {
                  return player;
               }
            }
         }

         return null;
      }
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeBoolean(TeamsManager.canBreakGlass);
      data.writeBoolean(TeamsManager.vehiclesNeedFuel);
      data.writeBoolean(TeamsManager.driveablesBreakBlocks);
      if (TeamsManager.getInstance().currentRound == null) {
         this.writeUTF(data, "No Gametype");
         data.writeInt(0);
      } else {
         this.writeUTF(data, TeamsManager.getInstance().currentRound.gametype.name);
         data.writeBoolean(TeamsManager.getInstance().currentRound.gametype.showZombieScore());
         this.writeUTF(data, TeamsManager.getInstance().currentRound.map.name);
         this.writeUTF(data, TeamsManager.getInstance().currentRound.map.shortName);
         data.writeInt(TeamsManager.getInstance().roundTimeLeft);
         data.writeInt(TeamsManager.getInstance().currentRound.scoreLimit);
         if (TeamsManager.getInstance().currentRound.gametype.sortScoreboardByTeam()) {
            data.writeBoolean(true);
            if (TeamsManager.getInstance().currentRound.teams == null) {
               data.writeInt(0);
            } else {
               data.writeInt(TeamsManager.getInstance().currentRound.teams.length);

               for(int i = 0; i < TeamsManager.getInstance().currentRound.teams.length; ++i) {
                  Team team = TeamsManager.getInstance().currentRound.teams[i];
                  if (team == null) {
                     this.writeUTF(data, "none");
                  } else {
                     this.writeUTF(data, team.shortName);
                     data.writeInt(team.score);
                     data.writeBoolean(TeamsManager.getInstance().currentRound.gametype.teamHasWon(team));
                     team.sortPlayers();
                     data.writeInt(team.members.size());

                     for(int j = 0; j < team.members.size(); ++j) {
                        String username = (String)team.members.get(j);
                        PlayerData playerData = PlayerHandler.getPlayerData(username, Side.SERVER);
                        this.writeUTF(data, username);
                        if (playerData == null) {
                           data.writeInt(0);
                           data.writeInt(0);
                           data.writeInt(0);
                           this.writeUTF(data, "");
                        } else {
                           data.writeInt(playerData.score);
                           data.writeInt(playerData.zombieScore);
                           data.writeInt(playerData.kills);
                           data.writeInt(playerData.deaths);
                           this.writeUTF(data, playerData.playerClass.shortName);
                        }
                     }
                  }
               }
            }
         } else {
            data.writeBoolean(false);
            ArrayList<String> playerNames = new ArrayList();

            for(int i = 0; i < TeamsManager.getInstance().currentRound.teams.length; ++i) {
               Team team = TeamsManager.getInstance().currentRound.teams[i];
               if (team != null && team.members != null) {
                  playerNames.addAll(team.members);
               }
            }

            Collections.sort(playerNames, new Team.ComparatorScore());
            data.writeInt(playerNames.size());
            Iterator var10 = playerNames.iterator();

            while(var10.hasNext()) {
               String username = (String)var10.next();
               PlayerData playerData = PlayerHandler.getPlayerData(username, Side.SERVER);
               this.writeUTF(data, username);
               if (playerData == null) {
                  data.writeInt(0);
                  data.writeInt(0);
                  data.writeInt(0);
                  this.writeUTF(data, "");
               } else {
                  data.writeInt(playerData.score);
                  data.writeInt(playerData.kills);
                  data.writeInt(playerData.deaths);
                  this.writeUTF(data, playerData.playerClass.shortName);
               }
            }
         }
      }

   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      TeamsManager.canBreakGlass = data.readBoolean();
      TeamsManager.vehiclesNeedFuel = data.readBoolean();
      TeamsManager.driveablesBreakBlocks = data.readBoolean();
      gametype = this.readUTF(data);
      if (gametype.equals("No Gametype")) {
         numTeams = 0;
         teamData = new PacketTeamInfo.TeamData[0];
      } else {
         showZombieScore = data.readBoolean();
         map = this.readUTF(data);
         mapShortName = this.readUTF(data);
         timeLeft = data.readInt();
         scoreLimit = data.readInt();
         sortedByTeam = data.readBoolean();
         int i;
         if (sortedByTeam) {
            numLines = numTeams = data.readInt();
            if (numTeams == 0) {
               return;
            }

            teamData = new PacketTeamInfo.TeamData[numTeams];

            for(i = 0; i < numTeams; ++i) {
               teamData[i] = new PacketTeamInfo.TeamData();
               String teamName = this.readUTF(data);
               if (!teamName.equals("none")) {
                  teamData[i].team = Team.getTeam(teamName);
                  teamData[i].score = data.readInt();
                  teamData[i].winner = data.readBoolean();
                  teamData[i].numPlayers = data.readInt();
                  teamData[i].playerData = new PacketTeamInfo.PlayerScoreData[teamData[i].numPlayers];
                  if (teamData[i].numPlayers > numLines) {
                     numLines = teamData[i].numPlayers;
                  }

                  for(int j = 0; j < teamData[i].numPlayers; ++j) {
                     teamData[i].playerData[j] = new PacketTeamInfo.PlayerScoreData();
                     teamData[i].playerData[j].team = teamData[i];
                     teamData[i].playerData[j].username = this.readUTF(data);
                     teamData[i].playerData[j].score = data.readInt();
                     teamData[i].playerData[j].zombieScore = data.readInt();
                     teamData[i].playerData[j].kills = data.readInt();
                     teamData[i].playerData[j].deaths = data.readInt();
                     teamData[i].playerData[j].playerClass = PlayerClass.getClass(this.readUTF(data));
                  }
               }
            }
         } else {
            numLines = 0;
            teamData = new PacketTeamInfo.TeamData[]{new PacketTeamInfo.TeamData()};
            teamData[0].team = null;
            teamData[0].score = 0;
            teamData[0].numPlayers = data.readInt();
            teamData[0].playerData = new PacketTeamInfo.PlayerScoreData[teamData[0].numPlayers];
            numLines += teamData[0].numPlayers;

            for(i = 0; i < teamData[0].numPlayers; ++i) {
               teamData[0].playerData[i] = new PacketTeamInfo.PlayerScoreData();
               teamData[0].playerData[i].team = teamData[0];
               teamData[0].playerData[i].username = this.readUTF(data);
               teamData[0].playerData[i].score = data.readInt();
               teamData[0].playerData[i].kills = data.readInt();
               teamData[0].playerData[i].deaths = data.readInt();
               teamData[0].playerData[i].playerClass = PlayerClass.getClass(this.readUTF(data));
            }
         }
      }

   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      FlansModClient.teamInfo = this;
   }

   public Team getTeam(int spawnerTeamID) {
      switch(spawnerTeamID) {
      case 0:
         return null;
      case 1:
         return Team.spectators;
      default:
         return teamData.length > spawnerTeamID - 2 ? teamData[spawnerTeamID - 2].team : null;
      }
   }

   public boolean roundOver() {
      if (timeLeft == 0) {
         return true;
      } else {
         PacketTeamInfo.TeamData[] var1 = teamData;
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            PacketTeamInfo.TeamData aTeamData = var1[var3];
            if (aTeamData.score == scoreLimit) {
               return true;
            }
         }

         return false;
      }
   }

   public Team getWinner() {
      PacketTeamInfo.TeamData[] var1 = teamData;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         PacketTeamInfo.TeamData aTeamData = var1[var3];
         if (aTeamData.winner) {
            return aTeamData.team;
         }
      }

      return null;
   }

   public static class PlayerScoreData {
      public String username;
      public int score;
      public int kills;
      public int deaths;
      public int totalScore;
      public PacketTeamInfo.TeamData team;
      public PlayerClass playerClass;
      public int zombieScore;
   }

   public static class TeamData {
      public Team team;
      public int score;
      public int numPlayers;
      public PacketTeamInfo.PlayerScoreData[] playerData;
      public boolean winner;
   }
}
