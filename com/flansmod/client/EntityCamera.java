package com.flansmod.client;

import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityCamera extends EntityLivingBase {
   public EntityDriveable driveable;

   public EntityCamera(World world) {
      super(world);
      this.func_70105_a(0.0F, 0.0F);
   }

   public EntityCamera(World world, EntityDriveable d) {
      this(world);
      this.driveable = d;
      this.func_70107_b(d.field_70165_t, d.field_70163_u, d.field_70161_v);
   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      Vector3f cameraPosition = new Vector3f();
      cameraPosition = this.driveable.axes.findLocalVectorGlobally(cameraPosition);
      double dX = this.driveable.field_70165_t + (double)cameraPosition.x - this.field_70165_t;
      double dY = this.driveable.field_70163_u + (double)cameraPosition.y - this.field_70163_u;
      double dZ = this.driveable.field_70161_v + (double)cameraPosition.z - this.field_70161_v;
      float lerpAmount = 0.1F;
      this.func_70107_b(this.field_70165_t + dX * (double)lerpAmount, this.field_70163_u + dY * (double)lerpAmount, this.field_70161_v + dZ * (double)lerpAmount);
      if (FlansMod.proxy.mouseControlEnabled()) {
         this.field_70177_z = this.driveable.axes.getYaw() - 90.0F;
         this.field_70125_A = this.driveable.axes.getPitch();
      } else {
         Entity player = FlansMod.proxy.getThePlayer();
         if (player != null) {
            this.field_70177_z = player.field_70177_z;
            this.field_70125_A = player.field_70125_A;
         }
      }

      while(this.field_70177_z - this.field_70126_B >= 180.0F) {
         this.field_70177_z -= 360.0F;
      }

      while(this.field_70177_z - this.field_70126_B < -180.0F) {
         this.field_70177_z += 360.0F;
      }

   }

   public ItemStack func_70694_bm() {
      return null;
   }

   public ItemStack func_71124_b(int p_71124_1_) {
      return null;
   }

   public void func_70062_b(int p_70062_1_, ItemStack p_70062_2_) {
   }

   public ItemStack[] func_70035_c() {
      return null;
   }
}
