package com.flansmod.common;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class CommonGuiHandler implements IGuiHandler {
   public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
      return FlansMod.proxy.getServerGui(ID, player, world, x, y, z);
   }

   public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
      return FlansMod.proxy.getClientGui(ID, player, world, x, y, z);
   }
}
