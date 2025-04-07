package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.guns.EntityAAGun;
import net.minecraft.client.model.ModelBase;

public class ModelAAGun extends ModelBase {
   public boolean oldModel = false;
   public ModelRendererTurbo[] baseModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] seatModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] gunModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[][] barrelModel = new ModelRendererTurbo[0][0];
   public ModelRendererTurbo[][] ammoModel = new ModelRendererTurbo[0][0];
   public ModelRendererTurbo[] gunsightModel = new ModelRendererTurbo[0];
   public int barrelX;
   public int barrelY;
   public int barrelZ;

   public void renderBase(float f, float f1, float f2, float f3, float f4, float f5, EntityAAGun aa) {
      ModelRendererTurbo[] var8 = this.baseModel;
      int var9 = var8.length;

      for(int var10 = 0; var10 < var9; ++var10) {
         ModelRendererTurbo aBaseModel = var8[var10];
         aBaseModel.func_78785_a(f5);
      }

   }

   public void renderGun(float f, float f1, float f2, float f3, float f4, float f5, EntityAAGun aa) {
      ModelRendererTurbo[] var8 = this.seatModel;
      int j = var8.length;

      int var10;
      ModelRendererTurbo aGunsightModel;
      for(var10 = 0; var10 < j; ++var10) {
         aGunsightModel = var8[var10];
         aGunsightModel.func_78785_a(f5);
      }

      var8 = this.gunModel;
      j = var8.length;

      for(var10 = 0; var10 < j; ++var10) {
         aGunsightModel = var8[var10];
         aGunsightModel.setPosition((float)this.barrelX, (float)this.barrelY, (float)this.barrelZ);
         aGunsightModel.field_78808_h = -aa.gunPitch / 180.0F * 3.1415927F;
         aGunsightModel.func_78785_a(f5);
      }

      var8 = this.gunsightModel;
      j = var8.length;

      for(var10 = 0; var10 < j; ++var10) {
         aGunsightModel = var8[var10];
         aGunsightModel.field_78808_h = -aa.gunPitch / 180.0F * 3.1415927F;
         aGunsightModel.func_78785_a(f5);
      }

      int i;
      for(i = 0; i < this.barrelModel.length; ++i) {
         for(j = 0; j < this.barrelModel[i].length; ++j) {
            this.barrelModel[i][j].setPosition(-aa.barrelRecoil[i] * (float)Math.cos((double)(-aa.gunPitch * 3.1415927F / 180.0F)) + (float)this.barrelX, -aa.barrelRecoil[i] * (float)Math.sin((double)(-aa.gunPitch * 3.1415927F / 180.0F)) + (float)this.barrelY, (float)this.barrelZ);
            this.barrelModel[i][j].field_78808_h = -aa.gunPitch / 180.0F * 3.1415927F;
            this.barrelModel[i][j].func_78785_a(f5);
         }
      }

      for(i = 0; i < this.ammoModel.length; ++i) {
         if (aa.ammo[i] != null) {
            for(j = 0; j < this.ammoModel[i].length; ++j) {
               this.ammoModel[i][j].setPosition((float)this.barrelX, (float)this.barrelY, (float)this.barrelZ);
               this.ammoModel[i][j].field_78808_h = -aa.gunPitch / 180.0F * 3.1415927F;
               this.ammoModel[i][j].func_78785_a(f5);
            }
         }
      }

   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
   }

   public void flipAll() {
      ModelRendererTurbo[] var1 = this.baseModel;
      int var2 = var1.length;

      int var3;
      ModelRendererTurbo aGunsightModel;
      for(var3 = 0; var3 < var2; ++var3) {
         aGunsightModel = var1[var3];
         aGunsightModel.doMirror(false, true, true);
         aGunsightModel.func_78793_a(aGunsightModel.field_78800_c, -aGunsightModel.field_78797_d, -aGunsightModel.field_78798_e);
      }

      var1 = this.seatModel;
      var2 = var1.length;

      for(var3 = 0; var3 < var2; ++var3) {
         aGunsightModel = var1[var3];
         aGunsightModel.doMirror(false, true, true);
         aGunsightModel.func_78793_a(aGunsightModel.field_78800_c, -aGunsightModel.field_78797_d, -aGunsightModel.field_78798_e);
      }

      var1 = this.gunModel;
      var2 = var1.length;

      for(var3 = 0; var3 < var2; ++var3) {
         aGunsightModel = var1[var3];
         aGunsightModel.doMirror(false, true, true);
         aGunsightModel.func_78793_a(aGunsightModel.field_78800_c, -aGunsightModel.field_78797_d, -aGunsightModel.field_78798_e);
      }

      var1 = this.gunsightModel;
      var2 = var1.length;

      for(var3 = 0; var3 < var2; ++var3) {
         aGunsightModel = var1[var3];
         aGunsightModel.doMirror(false, true, true);
         aGunsightModel.func_78793_a(aGunsightModel.field_78800_c, -aGunsightModel.field_78797_d, -aGunsightModel.field_78798_e);
      }

      ModelRendererTurbo[][] var6 = this.barrelModel;
      var2 = var6.length;

      int j;
      ModelRendererTurbo[] anAmmoModel;
      for(var3 = 0; var3 < var2; ++var3) {
         anAmmoModel = var6[var3];

         for(j = 0; j < anAmmoModel.length; ++j) {
            anAmmoModel[j].doMirror(false, true, true);
            anAmmoModel[j].func_78793_a(anAmmoModel[j].field_78800_c, -anAmmoModel[j].field_78797_d, -anAmmoModel[j].field_78798_e);
         }
      }

      var6 = this.ammoModel;
      var2 = var6.length;

      for(var3 = 0; var3 < var2; ++var3) {
         anAmmoModel = var6[var3];

         for(j = 0; j < anAmmoModel.length; ++j) {
            anAmmoModel[j].doMirror(false, true, true);
            anAmmoModel[j].func_78793_a(anAmmoModel[j].field_78800_c, -anAmmoModel[j].field_78797_d, -anAmmoModel[j].field_78798_e);
         }
      }

   }
}
