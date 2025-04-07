package com.flansmod.common.teams;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public interface ITeamBase {
   String getName();

   void setName(String var1);

   void setBaseID(int var1);

   int getBaseID();

   int getDefaultOwnerID();

   void setDefaultOwnerID(int var1);

   int getOwnerID();

   void setOwnerID(int var1);

   void startRound();

   void roundCleanup();

   TeamsMap getMap();

   void setMap(TeamsMap var1);

   void setMapFirstTime(TeamsMap var1);

   List<ITeamObject> getObjects();

   void addObject(ITeamObject var1);

   void tick();

   void destroy();

   Entity getEntity();

   double getPosX();

   double getPosY();

   double getPosZ();

   World getWorld();

   ITeamObject getFlag();
}
