package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelAttachment extends ModelBase {
   public ModelRendererTurbo[] attachmentModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] ammoModel = new ModelRendererTurbo[0];
   public EnumAnimationType secondaryAnimType;
   public float tiltGunTime;
   public float unloadClipTime;
   public float loadClipTime;
   public float untiltGunTime;
   public float numBulletsInReloadAnimation;
   public float endLoadedAmmoDistance;
   public float renderOffset;
   public float recoilDistance;
   public float recoilAngle;
   public Vector3f attachmentFlashOffset;

   public ModelAttachment() {
      this.secondaryAnimType = EnumAnimationType.NONE;
      this.tiltGunTime = 0.15F;
      this.unloadClipTime = 0.35F;
      this.loadClipTime = 0.35F;
      this.untiltGunTime = 0.15F;
      this.numBulletsInReloadAnimation = 1.0F;
      this.endLoadedAmmoDistance = 1.0F;
      this.renderOffset = 0.0F;
      this.recoilDistance = 0.125F;
      this.recoilAngle = -8.0F;
      this.attachmentFlashOffset = new Vector3f(0.0F, 0.0F, 0.0F);
   }

   public void renderAttachment(float f) {
      ModelRendererTurbo[] var2 = this.attachmentModel;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         ModelRendererTurbo model = var2[var4];
         if (model != null) {
            model.func_78785_a(f);
         }
      }

   }

   public void renderAttachmentAmmo(float f) {
      ModelRendererTurbo[] var2 = this.ammoModel;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         ModelRendererTurbo model = var2[var4];
         if (model != null) {
            model.func_78785_a(f);
         }
      }

   }

   public void flipAll() {
      ModelRendererTurbo[] var1 = this.attachmentModel;
      int var2 = var1.length;

      int var3;
      ModelRendererTurbo anAmmoModel;
      for(var3 = 0; var3 < var2; ++var3) {
         anAmmoModel = var1[var3];
         anAmmoModel.doMirror(false, true, true);
         anAmmoModel.func_78793_a(anAmmoModel.field_78800_c, -anAmmoModel.field_78797_d, -anAmmoModel.field_78798_e);
      }

      var1 = this.ammoModel;
      var2 = var1.length;

      for(var3 = 0; var3 < var2; ++var3) {
         anAmmoModel = var1[var3];
         anAmmoModel.doMirror(false, true, true);
         anAmmoModel.func_78793_a(anAmmoModel.field_78800_c, -anAmmoModel.field_78797_d, -anAmmoModel.field_78798_e);
      }

   }
}
