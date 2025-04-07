package com.flansmod.common.teams;

public interface ITeamObject {
   ITeamBase getBase();

   void onBaseSet(int var1);

   void onBaseCapture(int var1);

   void setBase(ITeamBase var1);

   void tick();

   void destroy();

   double getPosX();

   double getPosY();

   double getPosZ();

   boolean isSpawnPoint();

   boolean forceChunkLoading();
}
