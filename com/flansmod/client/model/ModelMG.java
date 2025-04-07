package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.guns.EntityMG;
import net.minecraft.client.model.ModelBase;

public class ModelMG extends ModelBase {
   public ModelRendererTurbo[] bipodModel;
   public ModelRendererTurbo[] gunModel;
   public ModelRendererTurbo[] ammoModel;
   public ModelRendererTurbo[] ammoBoxModel = new ModelRendererTurbo[0];

   public void renderBipod(float f, float f1, float f2, float f3, float f4, float f5, EntityMG mg) {
      ModelRendererTurbo[] var8 = this.bipodModel;
      int var9 = var8.length;

      int var10;
      ModelRendererTurbo ammoBoxPart;
      for(var10 = 0; var10 < var9; ++var10) {
         ammoBoxPart = var8[var10];
         ammoBoxPart.func_78785_a(f5);
      }

      if (mg.reloadTimer <= 0 && mg.ammo != null) {
         var8 = this.ammoBoxModel;
         var9 = var8.length;

         for(var10 = 0; var10 < var9; ++var10) {
            ammoBoxPart = var8[var10];
            ammoBoxPart.func_78785_a(f5);
         }

      }
   }

   public void renderGun(float f, float f1, float f2, float f3, float f4, float f5, float f6, EntityMG mg) {
      ModelRendererTurbo[] var9 = this.gunModel;
      int var10 = var9.length;

      int var11;
      ModelRendererTurbo ammoPart;
      for(var11 = 0; var11 < var10; ++var11) {
         ammoPart = var9[var11];
         ammoPart.field_78795_f = -(mg.field_70127_C + (mg.field_70125_A - mg.field_70127_C) * f6) / 180.0F * 3.1415927F;
         ammoPart.func_78785_a(f5);
      }

      if (mg.reloadTimer <= 0 && mg.ammo != null) {
         var9 = this.ammoModel;
         var10 = var9.length;

         for(var11 = 0; var11 < var10; ++var11) {
            ammoPart = var9[var11];
            ammoPart.field_78795_f = -(mg.field_70127_C + (mg.field_70125_A - mg.field_70127_C) * f6) / 180.0F * 3.1415927F;
            ammoPart.func_78785_a(f5);
         }

      }
   }

   public void flipAll() {
      ModelRendererTurbo[] var1 = this.bipodModel;
      int var2 = var1.length;

      int var3;
      ModelRendererTurbo anAmmoBoxModel;
      for(var3 = 0; var3 < var2; ++var3) {
         anAmmoBoxModel = var1[var3];
         anAmmoBoxModel.doMirror(false, true, true);
         anAmmoBoxModel.func_78793_a(anAmmoBoxModel.field_78800_c, -anAmmoBoxModel.field_78797_d, -anAmmoBoxModel.field_78798_e);
      }

      var1 = this.gunModel;
      var2 = var1.length;

      for(var3 = 0; var3 < var2; ++var3) {
         anAmmoBoxModel = var1[var3];
         anAmmoBoxModel.doMirror(false, true, true);
         anAmmoBoxModel.func_78793_a(anAmmoBoxModel.field_78800_c, -anAmmoBoxModel.field_78797_d, -anAmmoBoxModel.field_78798_e);
      }

      var1 = this.ammoModel;
      var2 = var1.length;

      for(var3 = 0; var3 < var2; ++var3) {
         anAmmoBoxModel = var1[var3];
         anAmmoBoxModel.doMirror(false, true, true);
         anAmmoBoxModel.func_78793_a(anAmmoBoxModel.field_78800_c, -anAmmoBoxModel.field_78797_d, -anAmmoBoxModel.field_78798_e);
      }

      var1 = this.ammoBoxModel;
      var2 = var1.length;

      for(var3 = 0; var3 < var2; ++var3) {
         anAmmoBoxModel = var1[var3];
         anAmmoBoxModel.doMirror(false, true, true);
         anAmmoBoxModel.func_78793_a(anAmmoBoxModel.field_78800_c, -anAmmoBoxModel.field_78797_d, -anAmmoBoxModel.field_78798_e);
      }

   }
}
