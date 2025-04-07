package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.teams.ArmourType;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class ModelCustomArmour extends ModelBiped {
   public ArmourType type;
   public ModelRendererTurbo[] headModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] bodyModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] leftArmModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] rightArmModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] leftLegModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] rightLegModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] skirtFrontModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] skirtRearModel = new ModelRendererTurbo[0];

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      GL11.glPushMatrix();
      GL11.glScalef(this.type.modelScale, this.type.modelScale, this.type.modelScale);
      this.field_78117_n = entity.func_70093_af();
      ItemStack itemstack = ((EntityLivingBase)entity).func_71124_b(0);
      this.field_78120_m = itemstack != null ? 1 : 0;
      this.field_78118_o = false;
      if (itemstack != null && entity instanceof EntityPlayer && ((EntityPlayer)entity).func_71052_bv() > 0) {
         EnumAction enumaction = itemstack.func_77975_n();
         if (enumaction == EnumAction.block) {
            this.field_78120_m = 3;
         } else if (enumaction == EnumAction.bow) {
            this.field_78118_o = true;
         }
      }

      this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
      this.render(this.headModel, this.field_78116_c, f5, this.type.modelScale);
      this.render(this.bodyModel, this.field_78115_e, f5, this.type.modelScale);
      this.render(this.leftArmModel, this.field_78113_g, f5, this.type.modelScale);
      this.render(this.rightArmModel, this.field_78112_f, f5, this.type.modelScale);
      this.render(this.leftLegModel, this.field_78124_i, f5, this.type.modelScale);
      this.render(this.rightLegModel, this.field_78123_h, f5, this.type.modelScale);
      ModelRendererTurbo[] var13 = this.skirtFrontModel;
      int var10 = var13.length;

      int var11;
      ModelRendererTurbo mod;
      for(var11 = 0; var11 < var10; ++var11) {
         mod = var13[var11];
         mod.field_78800_c = (this.field_78124_i.field_78800_c + this.field_78123_h.field_78800_c) / 2.0F / this.type.modelScale;
         mod.field_78797_d = (this.field_78124_i.field_78797_d + this.field_78123_h.field_78797_d) / 2.0F / this.type.modelScale;
         mod.field_78798_e = (this.field_78124_i.field_78798_e + this.field_78123_h.field_78798_e) / 2.0F / this.type.modelScale;
         mod.field_78795_f = Math.min(this.field_78124_i.field_78795_f, this.field_78123_h.field_78795_f);
         mod.field_78796_g = this.field_78124_i.field_78796_g;
         mod.field_78808_h = this.field_78124_i.field_78808_h;
         mod.func_78785_a(f5);
      }

      var13 = this.skirtRearModel;
      var10 = var13.length;

      for(var11 = 0; var11 < var10; ++var11) {
         mod = var13[var11];
         mod.field_78800_c = (this.field_78124_i.field_78800_c + this.field_78123_h.field_78800_c) / 2.0F / this.type.modelScale;
         mod.field_78797_d = (this.field_78124_i.field_78797_d + this.field_78123_h.field_78797_d) / 2.0F / this.type.modelScale;
         mod.field_78798_e = (this.field_78124_i.field_78798_e + this.field_78123_h.field_78798_e) / 2.0F / this.type.modelScale;
         mod.field_78795_f = Math.max(this.field_78124_i.field_78795_f, this.field_78123_h.field_78795_f);
         mod.field_78796_g = this.field_78124_i.field_78796_g;
         mod.field_78808_h = this.field_78124_i.field_78808_h;
         mod.func_78785_a(f5);
      }

      GL11.glPopMatrix();
   }

   public void render(ModelRendererTurbo[] models, ModelRenderer bodyPart, float f5, float scale) {
      this.setBodyPart(models, bodyPart, scale);
      ModelRendererTurbo[] var5 = models;
      int var6 = models.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         ModelRendererTurbo mod = var5[var7];
         mod.field_78795_f = bodyPart.field_78795_f;
         mod.field_78796_g = bodyPart.field_78796_g;
         mod.field_78808_h = bodyPart.field_78808_h;
         mod.func_78785_a(f5);
      }

   }

   public void setBodyPart(ModelRendererTurbo[] models, ModelRenderer bodyPart, float scale) {
      ModelRendererTurbo[] var4 = models;
      int var5 = models.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ModelRendererTurbo mod = var4[var6];
         mod.field_78800_c = bodyPart.field_78800_c / scale;
         mod.field_78797_d = bodyPart.field_78797_d / scale;
         mod.field_78798_e = bodyPart.field_78798_e / scale;
      }

   }
}
