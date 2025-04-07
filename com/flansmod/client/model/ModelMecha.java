package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EnumDriveablePart;
import com.flansmod.common.driveables.mechas.EntityMecha;
import com.flansmod.common.driveables.mechas.MechaType;
import com.flansmod.common.vector.Vector3f;
import org.lwjgl.opengl.GL11;

public class ModelMecha extends ModelDriveable {
   public ModelRendererTurbo[] leftArmModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] rightArmModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] leftHandModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] rightHandModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] hipsModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] leftLegModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] rightLegModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] leftFootModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] rightFootModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] headModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] barrelModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] leftAnimLegUpperModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] rightAnimLegUpperModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] leftAnimLegLowerModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] rightAnimLegLowerModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] leftAnimFootModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] rightAnimFootModel = new ModelRendererTurbo[0];
   public Vector3f hipsAttachmentPoint = new Vector3f();
   public Vector3f legsOrigin = new Vector3f();
   public Vector3f leftLegUpperOrigin = new Vector3f();
   public Vector3f leftLegLowerOrigin = new Vector3f();
   public Vector3f rightLegUpperOrigin = new Vector3f();
   public Vector3f rightLegLowerOrigin = new Vector3f();
   public Vector3f rightFootOrigin = new Vector3f();
   public Vector3f leftFootOrigin = new Vector3f();

   public void render(EntityDriveable driveable, float f1) {
      this.render(0.0625F, (EntityMecha)driveable, f1);
   }

   public void render(DriveableType type) {
      super.render(type);
      MechaType mechaType = (MechaType)type;
      this.renderPart(this.hipsModel);
      this.renderPart(this.leftLegModel);
      this.renderPart(this.rightLegModel);
      this.renderPart(this.leftFootModel);
      this.renderPart(this.rightFootModel);
      GL11.glPushMatrix();
      this.renderPart(this.leftAnimLegUpperModel);
      this.renderPart(this.rightAnimLegUpperModel);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(this.leftLegLowerOrigin.x, this.leftLegLowerOrigin.y, this.leftLegLowerOrigin.z);
      this.renderPart(this.leftAnimLegLowerModel);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(this.rightLegLowerOrigin.x, this.rightLegLowerOrigin.y, this.rightLegLowerOrigin.z);
      this.renderPart(this.rightAnimLegLowerModel);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(this.leftFootOrigin.x, this.leftFootOrigin.y, -this.leftFootOrigin.z);
      this.renderPart(this.leftAnimFootModel);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(this.rightFootOrigin.x, this.rightFootOrigin.y, -this.rightFootOrigin.z);
      this.renderPart(this.rightAnimFootModel);
      GL11.glPopMatrix();
      this.renderPart(this.barrelModel);
      this.renderPart(this.headModel);
      GL11.glPushMatrix();
      GL11.glTranslatef(mechaType.leftArmOrigin.x / mechaType.modelScale, mechaType.leftArmOrigin.y / mechaType.modelScale, mechaType.leftArmOrigin.z / mechaType.modelScale);
      this.renderPart(this.leftArmModel);
      this.renderPart(this.leftHandModel);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(mechaType.rightArmOrigin.x / mechaType.modelScale, mechaType.rightArmOrigin.y / mechaType.modelScale, mechaType.rightArmOrigin.z / mechaType.modelScale);
      this.renderPart(this.rightArmModel);
      this.renderPart(this.rightHandModel);
      GL11.glPopMatrix();
   }

   public void render(float f5, EntityMecha mecha, float f) {
      ModelRendererTurbo[] var4;
      int var5;
      int var6;
      ModelRendererTurbo model;
      if (mecha.isPartIntact(EnumDriveablePart.core)) {
         var4 = this.bodyModel;
         var5 = var4.length;

         for(var6 = 0; var6 < var5; ++var6) {
            model = var4[var6];
            model.func_78785_a(f5);
         }
      }

      if (mecha.isPartIntact(EnumDriveablePart.head)) {
         var4 = this.headModel;
         var5 = var4.length;

         for(var6 = 0; var6 < var5; ++var6) {
            model = var4[var6];
            model.func_78785_a(f5);
         }
      }

      float pitch = 0.0F;
      if (mecha.seats[0].looking != null) {
         pitch = mecha.seats[0].looking.getPitch();
      }

      float dPitch = mecha.seats[0].looking.getPitch() - mecha.seats[0].prevLooking.getPitch();
      float aPitch = mecha.seats[0].prevLooking.getPitch() + dPitch * f;
      if (mecha.isPartIntact(EnumDriveablePart.barrel)) {
         ModelRendererTurbo[] var14 = this.barrelModel;
         int var8 = var14.length;

         for(int var9 = 0; var9 < var8; ++var9) {
            ModelRendererTurbo aBarrelModel = var14[var9];
            aBarrelModel.field_78808_h = -(pitch * 3.1415927F / 180.0F);
            aBarrelModel.render(f5, this.oldRotateOrder);
         }
      }

   }

   public void renderLeftArm(float f5, EntityMecha mecha, float f) {
      ModelRendererTurbo[] var4 = this.leftArmModel;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ModelRendererTurbo model = var4[var6];
         model.func_78785_a(f5);
      }

   }

   public void renderLeftHand(float f5, EntityMecha mecha, float f) {
      ModelRendererTurbo[] var4 = this.leftHandModel;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ModelRendererTurbo model = var4[var6];
         model.func_78785_a(f5);
      }

   }

   public void renderRightArm(float f5, EntityMecha mecha, float f) {
      ModelRendererTurbo[] var4 = this.rightArmModel;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ModelRendererTurbo model = var4[var6];
         model.func_78785_a(f5);
      }

   }

   public void renderRightHand(float f5, EntityMecha mecha, float f) {
      ModelRendererTurbo[] var4 = this.rightHandModel;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ModelRendererTurbo model = var4[var6];
         model.func_78785_a(f5);
      }

   }

   public void renderRightFoot(float f5, EntityMecha mecha, float f) {
      ModelRendererTurbo[] var4 = this.rightFootModel;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ModelRendererTurbo model = var4[var6];
         model.func_78785_a(f5);
      }

   }

   public void renderLeftFoot(float f5, EntityMecha mecha, float f) {
      ModelRendererTurbo[] var4 = this.leftFootModel;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ModelRendererTurbo model = var4[var6];
         model.func_78785_a(f5);
      }

   }

   public void renderRightLeg(float f5, EntityMecha mecha, float f) {
      ModelRendererTurbo[] var4 = this.rightLegModel;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ModelRendererTurbo model = var4[var6];
         model.func_78785_a(f5);
      }

   }

   public void renderRightAnimLegUpper(float f5, EntityMecha mecha, float f) {
      ModelRendererTurbo[] var4 = this.rightAnimLegUpperModel;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ModelRendererTurbo model = var4[var6];
         model.func_78785_a(f5);
      }

   }

   public void renderRightAnimLegLower(float f5, EntityMecha mecha, float f) {
      ModelRendererTurbo[] var4 = this.rightAnimLegLowerModel;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ModelRendererTurbo model = var4[var6];
         model.func_78785_a(f5);
      }

   }

   public void renderRightAnimFoot(float f5, EntityMecha mecha, float f) {
      ModelRendererTurbo[] var4 = this.rightAnimFootModel;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ModelRendererTurbo model = var4[var6];
         model.func_78785_a(f5);
      }

   }

   public void renderLeftAnimLegUpper(float f5, EntityMecha mecha, float f) {
      ModelRendererTurbo[] var4 = this.leftAnimLegUpperModel;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ModelRendererTurbo model = var4[var6];
         model.func_78785_a(f5);
      }

   }

   public void renderLeftAnimLegLower(float f5, EntityMecha mecha, float f) {
      ModelRendererTurbo[] var4 = this.leftAnimLegLowerModel;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ModelRendererTurbo model = var4[var6];
         model.func_78785_a(f5);
      }

   }

   public void renderLeftAnimFoot(float f5, EntityMecha mecha, float f) {
      ModelRendererTurbo[] var4 = this.leftAnimFootModel;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ModelRendererTurbo model = var4[var6];
         model.func_78785_a(f5);
      }

   }

   public void renderLeftLeg(float f5, EntityMecha mecha, float f) {
      ModelRendererTurbo[] var4 = this.leftLegModel;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ModelRendererTurbo model = var4[var6];
         model.func_78785_a(f5);
      }

   }

   public void renderHips(float f5, EntityMecha mecha, float f) {
      ModelRendererTurbo[] var4 = this.hipsModel;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ModelRendererTurbo model = var4[var6];
         model.func_78785_a(f5);
      }

   }

   public void flipAll() {
      super.flipAll();
      this.flip(this.leftArmModel);
      this.flip(this.rightArmModel);
      this.flip(this.leftHandModel);
      this.flip(this.rightHandModel);
      this.flip(this.hipsModel);
      this.flip(this.leftLegModel);
      this.flip(this.rightLegModel);
      this.flip(this.leftAnimLegUpperModel);
      this.flip(this.rightAnimLegUpperModel);
      this.flip(this.leftAnimLegLowerModel);
      this.flip(this.rightAnimLegLowerModel);
      this.flip(this.leftAnimFootModel);
      this.flip(this.rightAnimFootModel);
      this.flip(this.leftFootModel);
      this.flip(this.rightFootModel);
      this.flip(this.headModel);
      this.flip(this.barrelModel);
   }

   public void translateAll(float x, float y, float z) {
      super.translateAll(x, y, z);
      this.translate(this.leftArmModel, x, y, z);
      this.translate(this.rightArmModel, x, y, z);
      this.translate(this.leftHandModel, x, y, z);
      this.translate(this.rightHandModel, x, y, z);
      this.translate(this.hipsModel, x, y, z);
      this.translate(this.leftLegModel, x, y, z);
      this.translate(this.rightLegModel, x, y, z);
      this.translate(this.leftFootModel, x, y, z);
      this.translate(this.rightFootModel, x, y, z);
      this.translate(this.leftAnimLegUpperModel, x, y, z);
      this.translate(this.rightAnimLegUpperModel, x, y, z);
      this.translate(this.leftAnimLegLowerModel, x, y, z);
      this.translate(this.rightAnimLegLowerModel, x, y, z);
      this.translate(this.leftAnimFootModel, x, y, z);
      this.translate(this.rightAnimFootModel, x, y, z);
      this.translate(this.headModel, x, y, z);
      this.translate(this.barrelModel, x, y, z);
   }
}
