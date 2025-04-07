package com.flansmod.client;

import com.flansmod.common.FlansMod;
import net.minecraft.client.particle.EntityExplodeFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

public class EntityBigSmoke extends EntityExplodeFX {
   public int disTime;

   public EntityBigSmoke(World w, double px, double py, double pz, double mx, double my, double mz) {
      super(w, px, py, pz, mx, my, mz);
      this.field_70547_e = 300;
      this.field_70545_g = 1.0F;
      this.field_70159_w = mx;
      this.field_70181_x = my;
      this.field_70179_y = mz;
      this.field_70544_f = 0.0F;
      this.disTime = 10;
   }

   public int func_70537_b() {
      return 1;
   }

   public float getEntityBrightness(float f) {
      return 1.0F;
   }

   public void func_70539_a(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7) {
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
      --this.disTime;
      int NUM = 1;
      if (this.disTime < 0) {
         double dx = (this.field_70165_t - this.field_70169_q) / (double)NUM;
         double dy = (this.field_70163_u - this.field_70167_r) / (double)NUM;
         double dz = (this.field_70161_v - this.field_70166_s) / (double)NUM;
         FlansMod.proxy.spawnParticle("flansmod.rocketexhaust", this.field_70169_q + dx * 1.0D + 5.0D * Math.random(), this.field_70167_r + dy * 1.0D + 7.0D * Math.random(), this.field_70166_s + dz * 1.0D + 5.0D * Math.random(), 0.0D, 0.0D, 0.0D);
         this.disTime = 2;
      } else if (this.func_70090_H()) {
         this.field_70181_x *= 0.89D;
         this.field_70181_x += 0.1D;
      }

   }
}
