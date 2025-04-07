package com.flansmod.api;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public interface IControllable {
   void onMouseMoved(int var1, int var2);

   boolean pressKey(int var1, EntityPlayer var2);

   void updateKeyHeldState(int var1, boolean var2);

   Entity getControllingEntity();

   boolean isDead();

   float getPlayerRoll();

   float getCameraDistance();

   @SideOnly(Side.CLIENT)
   EntityLivingBase getCamera();
}
