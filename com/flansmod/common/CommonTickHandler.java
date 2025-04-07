package com.flansmod.common;

import com.flansmod.common.teams.TeamsManager;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;

public class CommonTickHandler {
   public CommonTickHandler() {
      FMLCommonHandler.instance().bus().register(this);
   }

   @SubscribeEvent
   public void tick(ClientTickEvent event) {
      switch(event.phase) {
      case END:
         FlansMod.playerHandler.clientTick();
      case START:
      default:
      }
   }

   @SubscribeEvent
   public void tick(ServerTickEvent event) {
      switch(event.phase) {
      case END:
         TeamsManager.getInstance().tick();
         FlansMod.playerHandler.serverTick();
         ++FlansMod.ticker;
      case START:
      default:
      }
   }
}
