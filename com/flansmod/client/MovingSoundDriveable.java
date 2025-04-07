package com.flansmod.client;

import com.flansmod.common.driveables.EntityDriveable;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class MovingSoundDriveable extends MovingSound {
   private final EntityDriveable driveable;
   private float field_147669_l = 0.0F;

   public MovingSoundDriveable(ResourceLocation sound, EntityDriveable driveable) {
      super(sound);
      this.driveable = driveable;
      this.field_147659_g = true;
      this.field_147665_h = 0;
   }

   public void func_73660_a() {
      if (this.driveable.field_70128_L) {
         this.field_147668_j = true;
      } else {
         this.field_147660_d = (float)this.driveable.field_70165_t;
         this.field_147661_e = (float)this.driveable.field_70163_u;
         this.field_147658_f = (float)this.driveable.field_70161_v;
         float f = MathHelper.func_76133_a(this.driveable.field_70159_w * this.driveable.field_70159_w + this.driveable.field_70179_y * this.driveable.field_70179_y);
         if ((double)f >= 0.01D) {
            this.field_147669_l = MathHelper.func_76131_a(this.field_147669_l + 0.0025F, 0.0F, 1.0F);
            this.field_147662_b = 0.0F + MathHelper.func_76131_a(f, 0.0F, 0.5F) * 0.7F;
         } else {
            this.field_147669_l = 0.0F;
            this.field_147662_b = 0.0F;
         }
      }

   }
}
