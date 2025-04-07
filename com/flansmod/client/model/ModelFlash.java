package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelFlash extends ModelBase {
   public ModelRendererTurbo[][] flashModel = new ModelRendererTurbo[0][0];

   public void renderFlash(float f, int i) {
      if (this.flashModel[i] != null) {
         this.render(this.flashModel[i], f);
      }

   }

   public void render(ModelRendererTurbo[] flash, float f) {
      ModelRendererTurbo[] var3 = flash;
      int var4 = flash.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         ModelRendererTurbo model = var3[var5];
         if (model != null) {
            model.func_78785_a(f);
         }
      }

   }

   protected void flipAll() {
      ModelRendererTurbo[][] var1 = this.flashModel;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         ModelRendererTurbo[] model = var1[var3];
         ModelRendererTurbo[] var5 = model;
         int var6 = model.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            ModelRendererTurbo flash = var5[var7];
            flash.doMirror(false, true, true);
            flash.func_78793_a(flash.field_78800_c, -flash.field_78797_d, -flash.field_78798_e);
         }
      }

   }
}
