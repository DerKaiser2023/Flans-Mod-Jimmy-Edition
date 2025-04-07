package com.flansmod.client.model;

import com.flansmod.common.teams.EntityFlag;
import com.flansmod.common.teams.EntityFlagpole;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelFlagpole extends ModelBase {
   public ModelRenderer[] poleModel = new ModelRenderer[3];
   public ModelRenderer[] flagModel;

   public ModelFlagpole() {
      this.poleModel[0] = new ModelRenderer(this, 0, 16);
      this.poleModel[1] = new ModelRenderer(this, 0, 16);
      this.poleModel[2] = new ModelRenderer(this, 0, 20);
      this.poleModel[0].func_78790_a(-48.0F, -1.0F, -1.0F, 24, 2, 2, 0.0F);
      this.poleModel[1].func_78790_a(-24.0F, -1.0F, -1.0F, 24, 2, 2, 0.0F);
      this.poleModel[2].func_78790_a(-2.0F, -2.0F, -2.0F, 4, 2, 4, 0.0F);
      this.poleModel[0].field_78808_h = 1.5707964F;
      this.poleModel[1].field_78808_h = 1.5707964F;
      this.flagModel = new ModelRenderer[1];
      this.flagModel[0] = new ModelRenderer(this, 0, 0);
      this.flagModel[0].func_78790_a(-8.0F, -16.0F, 0.0F, 16, 16, 0, 0.0F);
      this.flagModel[0].func_78793_a(8.0F, 0.0F, 0.0F);
   }

   public void renderPole(float f, float f1, float f2, float f3, float f4, float f5, EntityFlagpole entityflag) {
      ModelRenderer[] var8 = this.poleModel;
      int var9 = var8.length;

      for(int var10 = 0; var10 < var9; ++var10) {
         ModelRenderer model = var8[var10];
         model.func_78785_a(f5);
      }

   }

   public void renderFlag(float f, float f1, float f2, float f3, float f4, float f5, EntityFlag entityflag) {
      ModelRenderer[] var8 = this.flagModel;
      int var9 = var8.length;

      for(int var10 = 0; var10 < var9; ++var10) {
         ModelRenderer model = var8[var10];
         model.func_78785_a(f5);
      }

   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
   }
}
