package com.flansmod.common.teams;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityConnectingLine extends EntityFishHook {
   public Object connectedTo;

   public EntityConnectingLine(World world) {
      super(world);
   }

   public EntityConnectingLine(World world, EntityPlayer player, ITeamBase base) {
      super(world);
      this.field_146043_c = this;
      this.field_70158_ak = true;
      this.field_146042_b = player;
      this.field_146042_b.field_71104_cf = this;
      this.func_70105_a(0.25F, 0.25F);
      this.func_70107_b(base.getPosX(), base.getPosY(), base.getPosZ());
      this.field_70129_M = 0.0F;
      this.field_70159_w = 0.0D;
      this.field_70179_y = 0.0D;
      this.field_70181_x = 0.0D;
      this.connectedTo = base;
   }

   public EntityConnectingLine(World world, EntityPlayer player, ITeamObject object) {
      super(world);
      this.field_146043_c = this;
      this.field_70158_ak = true;
      this.field_146042_b = player;
      this.field_146042_b.field_71104_cf = this;
      this.func_70105_a(0.25F, 0.25F);
      this.func_70107_b(object.getPosX(), object.getPosY(), object.getPosZ());
      this.field_70129_M = 0.0F;
      this.field_70159_w = 0.0D;
      this.field_70179_y = 0.0D;
      this.field_70181_x = 0.0D;
      this.connectedTo = object;
   }

   public void func_70071_h_() {
      ItemStack currentItemstack = this.field_146042_b.field_71071_by.func_70448_g();
      if (currentItemstack == null || !(currentItemstack.func_77973_b() instanceof ItemOpStick) || currentItemstack.func_77960_j() != 1) {
         this.func_70106_y();
         this.field_146042_b.field_71104_cf = null;
      }

   }
}
