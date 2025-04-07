package com.flansmod.common.teams;

import net.minecraft.nbt.NBTTagCompound;

public class TeamsRound implements Comparable<TeamsRound> {
   public Gametype gametype;
   public TeamsMap map;
   public Team[] teams;
   public int timeLimit;
   public int scoreLimit;
   public float popularity;
   public int roundsSincePlayed;
   public boolean isNextRoundOn = false;

   public TeamsRound(TeamsMap map2, Gametype gametype2, Team[] teams2, int timeLimit, int scoreLimit, boolean isNext) {
      this.map = map2;
      this.gametype = gametype2;
      this.teams = teams2;
      this.timeLimit = timeLimit;
      this.scoreLimit = scoreLimit;
      this.popularity = 0.5F;
      this.isNextRoundOn = isNext;
   }

   public TeamsRound(NBTTagCompound tags) {
      this.map = (TeamsMap)TeamsManager.getInstance().maps.get(tags.func_74779_i("Map"));
      this.gametype = Gametype.getGametype(tags.func_74779_i("Gametype"));
      this.timeLimit = tags.func_74762_e("TimeLimit");
      this.scoreLimit = tags.func_74762_e("ScoreLimit");
      this.teams = new Team[tags.func_74762_e("NumTeams")];

      for(int i = 0; i < this.teams.length; ++i) {
         this.teams[i] = Team.getTeam(tags.func_74779_i("Team_" + i));
      }

      this.popularity = tags.func_74760_g("Pop");
      this.isNextRoundOn = tags.func_74767_n("NextRound");
   }

   public void writeToNBT(NBTTagCompound tags) {
      tags.func_74778_a("Map", this.map.shortName);
      tags.func_74778_a("Gametype", this.gametype.shortName);
      tags.func_74768_a("TimeLimit", this.timeLimit);
      tags.func_74768_a("ScoreLimit", this.scoreLimit);
      tags.func_74768_a("NumTeams", this.teams.length);

      for(int i = 0; i < this.teams.length; ++i) {
         tags.func_74778_a("Team_" + i, this.teams[i].shortName);
      }

      tags.func_74776_a("Pop", this.popularity);
      tags.func_74757_a("NextRound", this.isNextRoundOn);
   }

   public int getTeamID(Team team) {
      if (team == Team.spectators) {
         return 1;
      } else if (team == this.teams[0]) {
         return 2;
      } else {
         return team == this.teams[1] ? 3 : 0;
      }
   }

   public Team getTeam(int id) {
      switch(id) {
      case 0:
         return null;
      case 1:
         return Team.spectators;
      default:
         return this.teams[id - 2];
      }
   }

   public Team getOtherTeam(Team team) {
      if (team != Team.spectators && team != null && this.teams.length == 2) {
         return team == this.teams[0] ? this.teams[1] : this.teams[0];
      } else {
         return team;
      }
   }

   public float getWeight() {
      return this.popularity * 4.0F + (float)this.roundsSincePlayed;
   }

   public int compareTo(TeamsRound o) {
      if (this.getWeight() < o.getWeight()) {
         return 1;
      } else {
         return this.getWeight() > o.getWeight() ? -1 : 0;
      }
   }
}
