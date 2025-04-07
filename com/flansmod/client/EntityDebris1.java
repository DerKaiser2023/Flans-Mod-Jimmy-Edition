package com.flansmod.client;

import com.flansmod.common.FlansMod;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public class EntityDebris1 extends EntityFX {
   public EntityDebris1(World w, double px, double py, double pz, double mx, double my, double mz) {
      super(w, px, py, pz, mx, my, mz);
      this.field_70547_e *= 5;
      this.field_70545_g = 1.0F;
      this.field_70159_w = mx;
      this.field_70181_x = my;
      this.field_70179_y = mz;
   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      if (this.field_70546_d++ >= this.field_70547_e) {
         this.func_70106_y();
      }

      this.field_70181_x -= 0.04D * (double)this.field_70545_g;
      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
      this.field_70159_w *= 0.99D;
      this.field_70181_x *= 0.99D;
      this.field_70179_y *= 0.99D;
      if (this.field_70163_u < 0.0D) {
         this.func_70106_y();
      }

      int NUM = 5;

      for(int i = 0; i < NUM; ++i) {
         double dx = (this.field_70165_t - this.field_70169_q) / (double)NUM;
         double dy = (this.field_70163_u - this.field_70167_r) / (double)NUM;
         double dz = (this.field_70161_v - this.field_70166_s) / (double)NUM;
         if (this.field_70546_d < 10) {
            FlansMod.proxy.spawnParticle("flame", this.field_70169_q + dx * (double)i, this.field_70167_r + dy * (double)i, this.field_70166_s + dz * (double)i, 0.0D, 0.0D, 0.0D);
         }

         FlansMod.proxy.spawnParticle("largesmoke", this.field_70169_q + dx * (double)i, this.field_70167_r + dy * (double)i * 2.0D, this.field_70166_s + dz * (double)i, 0.0D, 0.0D, 0.0D);
      }

      if (this.field_70122_E) {
         this.func_70106_y();
      }

   }
}
