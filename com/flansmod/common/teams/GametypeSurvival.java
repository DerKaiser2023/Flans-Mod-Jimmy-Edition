package com.flansmod.common.teams;

import com.flansmod.common.PlayerData;
import com.flansmod.common.types.InfoType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;

public class GametypeSurvival extends Gametype {
   public boolean friendlyFire = false;
   public int humanPrepTime = 600;

   public GametypeSurvival() {
      super("Survival", "SRV", 2);
   }

   public void roundStart() {
   }

   public void roundEnd() {
   }

   public void roundCleanup() {
   }

   public void tick() {
      TeamsManager var10000;
      if (teamsManager.roundTimeLeft + this.humanPrepTime - 200 == teamsManager.currentRound.timeLimit * 20 * 60) {
         var10000 = teamsManager;
         TeamsManager.messageAll("§cIf you all die, you lose!");
      }

      if (teamsManager.roundTimeLeft + this.humanPrepTime == teamsManager.currentRound.timeLimit * 20 * 60) {
         var10000 = teamsManager;
         TeamsManager.messageAll("§cGood luck!");
      }

   }

   public Team[] getTeamsCanSpawnAs(TeamsRound currentRound, EntityPlayer player) {
      return teamsManager.roundTimeLeft + this.humanPrepTime > teamsManager.currentRound.timeLimit * 20 * 60 ? new Team[]{currentRound.teams[0]} : new Team[]{currentRound.teams[1]};
   }

   public boolean playerAttacked(EntityPlayerMP player, DamageSource source) {
      if (getPlayerData(player) != null && getPlayerData(player).team != null) {
         EntityPlayerMP attacker = getPlayerFromDamageSource(source);
         if (attacker != null) {
            if (getPlayerData(attacker) == null || getPlayerData(attacker).team == null) {
               return false;
            }

            if (getPlayerData(player).team == getPlayerData(attacker).team) {
               return this.friendlyFire;
            }
         }

         return getPlayerData(player).team != Team.spectators;
      } else {
         return false;
      }
   }

   public boolean playerCanAttack(EntityPlayerMP attacker, Team attackerTeam, EntityPlayerMP victim, Team victimTeam) {
      return attackerTeam != victimTeam || this.friendlyFire;
   }

   public void playerKilled(EntityPlayerMP player, DamageSource source) {
      PlayerData playerData = getPlayerData(player);
      EntityPlayerMP attacker = getPlayerFromDamageSource(source);
      if (attacker != null) {
         PlayerData attackerData = getPlayerData(attacker);
         if (attacker != player) {
            if (attackerData.team == playerData.team) {
               if (this.isHuman(attackerData.team)) {
                  ++attackerData.score;
               } else {
                  --attackerData.zombieScore;
               }
            } else {
               if (this.isHuman(attackerData.team)) {
                  ++attackerData.score;
               } else if (this.isZombie(attackerData.team)) {
                  ++attackerData.zombieScore;
               }

               ++attackerData.kills;
            }
         }
      }

      ++playerData.deaths;
      if (teamsManager.roundTimeLeft + this.humanPrepTime <= teamsManager.currentRound.timeLimit * 20 * 60) {
         if (playerData.team != null) {
            playerData.team.removePlayer((EntityPlayer)player);
         }

         playerData.team = playerData.newTeam = teamsManager.currentRound.teams[1];
         playerData.team.addPlayer((EntityPlayer)player);
         teamsManager.sendClassMenuToPlayer(player);
      }

   }

   public boolean teamHasWon(Team team) {
      if (this.isHuman(team)) {
         return teamsManager.roundTimeLeft == 1 && team.members.size() > 0;
      } else if (!this.isZombie(team)) {
         return false;
      } else {
         return teamsManager.roundTimeLeft + this.humanPrepTime <= teamsManager.currentRound.timeLimit * 20 * 60 && teamsManager.currentRound.teams[0].members.size() == 0;
      }
   }

   public boolean isHuman(Team team) {
      return team == teamsManager.currentRound.teams[0];
   }

   public boolean isZombie(Team team) {
      return team == teamsManager.currentRound.teams[1];
   }

   public Vec3 getSpawnPoint(EntityPlayerMP player) {
      if (teamsManager.currentRound == null) {
         return null;
      } else {
         PlayerData data = getPlayerData(player);
         List<ITeamObject> validSpawnPoints = new ArrayList();
         if (data.newTeam == null) {
            return null;
         } else {
            if (data.newTeam == Team.spectators) {
               ArrayList<ITeamBase> bases = teamsManager.currentRound.map.getBasesPerTeam(1);
               Iterator var5 = bases.iterator();

               label75:
               while(true) {
                  ITeamBase base;
                  do {
                     if (!var5.hasNext()) {
                        break label75;
                     }

                     base = (ITeamBase)var5.next();
                  } while(base.getMap() != teamsManager.currentRound.map);

                  for(int i = 0; i < base.getObjects().size(); ++i) {
                     if (((ITeamObject)base.getObjects().get(i)).isSpawnPoint()) {
                        validSpawnPoints.add(base.getObjects().get(i));
                     }
                  }
               }
            } else {
               label61:
               for(int k = 2; k < 4; ++k) {
                  ArrayList<ITeamBase> bases = teamsManager.currentRound.map.getBasesPerTeam(k);
                  Iterator var12 = bases.iterator();

                  while(true) {
                     ITeamBase base;
                     do {
                        if (!var12.hasNext()) {
                           continue label61;
                        }

                        base = (ITeamBase)var12.next();
                     } while(base.getMap() != teamsManager.currentRound.map);

                     for(int i = 0; i < base.getObjects().size(); ++i) {
                        if (((ITeamObject)base.getObjects().get(i)).isSpawnPoint()) {
                           validSpawnPoints.add(base.getObjects().get(i));
                        }
                     }
                  }
               }
            }

            if (validSpawnPoints.size() > 0) {
               ITeamObject spawnPoint = (ITeamObject)validSpawnPoints.get(rand.nextInt(validSpawnPoints.size()));
               return Vec3.func_72443_a(spawnPoint.getPosX(), spawnPoint.getPosY(), spawnPoint.getPosZ());
            } else {
               return null;
            }
         }
      }
   }

   public boolean showZombieScore() {
      return true;
   }

   public boolean playerCanLoot(ItemStack stack, InfoType infoType, EntityPlayer player, Team playerTeam) {
      return playerTeam != teamsManager.currentRound.teams[1];
   }

   public void readFromNBT(NBTTagCompound tags) {
      this.humanPrepTime = tags.func_74762_e("ZOMPrepTime");
   }

   public void saveToNBT(NBTTagCompound tags) {
      tags.func_74768_a("ZOMPrepTime", this.humanPrepTime);
   }

   public boolean setVariable(String variable, String value) {
      if (variable.toLowerCase().equals("humanpreptime")) {
         this.humanPrepTime = Integer.parseInt(value) * 20;
         return true;
      } else {
         return false;
      }
   }
}
