package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelCasing extends ModelBase {
   public ModelRendererTurbo[] casingModel = new ModelRendererTurbo[0];

   public void renderCasing(float f) {
      ModelRendererTurbo[] var2 = this.casingModel;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         ModelRendererTurbo model = var2[var4];
         if (model != null) {
            model.func_78785_a(f);
         }
      }

   }

   protected void flipAll() {
      ModelRendererTurbo[] var1 = this.casingModel;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         ModelRendererTurbo casing = var1[var3];
         casing.doMirror(false, true, true);
         casing.func_78793_a(casing.field_78800_c, -casing.field_78797_d, -casing.field_78798_e);
      }

   }
}
