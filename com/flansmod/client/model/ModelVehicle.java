package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.driveables.EntityVehicle;
import com.flansmod.common.driveables.EnumDriveablePart;
import com.flansmod.common.driveables.VehicleType;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class ModelVehicle extends ModelDriveable {
   public ModelRendererTurbo[] turretModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] barrelModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[][] ammoModel = new ModelRendererTurbo[0][0];
   public ModelRendererTurbo[] frontWheelModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] backWheelModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] leftFrontWheelModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] rightFrontWheelModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] leftBackWheelModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] rightBackWheelModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] rightTrackModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] leftTrackModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] rightTrackWheelModels = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] leftTrackWheelModels = new ModelRendererTurbo[0];
   public ModelRendererTurbo[][] leftAnimTrackModel = new ModelRendererTurbo[0][0];
   public ModelRendererTurbo[][] rightAnimTrackModel = new ModelRendererTurbo[0][0];
   public ModelRendererTurbo[] fancyTrackModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] rightAnimTrackModel1 = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] leftAnimTrackModel1 = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] rightAnimTrackModel2 = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] leftAnimTrackModel2 = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] rightAnimTrackModel3 = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] leftAnimTrackModel3 = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] bodyDoorOpenModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] bodyDoorCloseModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] trailerModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] steeringWheelModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] drillHeadModel = new ModelRendererTurbo[0];
   public Vector3f drillHeadOrigin = new Vector3f();
   public ModelRendererTurbo[] barrelSpecModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] animBarrelModel = new ModelRendererTurbo[0];
   public Vector3f barrelAttach = new Vector3f();
   public ModelRendererTurbo[] doorAnimModel = new ModelRendererTurbo[0];
   public Vector3f doorAttach = new Vector3f();
   public ModelRendererTurbo[] door2AnimModel = new ModelRendererTurbo[0];
   public Vector3f door2Attach = new Vector3f();
   public ModelRendererTurbo[] drakonModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] drakonReloadModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] drakonArmModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] drakonRailModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] drakonDoorModel = new ModelRendererTurbo[0];
   public Vector3f drakonArmAttach = new Vector3f(0.0F, 0.0F, 0.0F);
   public Vector3f drakonRailAttach = new Vector3f(0.0F, 0.0F, 0.0F);
   public Vector3f drakonDoorAttach = new Vector3f(0.0F, 0.0F, 0.0F);
   public float animFrameLeft = 0.0F;
   public float animFrameRight = 0.0F;
   public Vector3f turretScale = new Vector3f(1.0F, 1.0F, 1.0F);
   public Vector3f turretTrans = new Vector3f(0.0F, 0.0F, 0.0F);
   public boolean fancyTurret = false;
   public String turretName;

   public void render(EntityDriveable driveable, float f1) {
      this.render(0.0625F, (EntityVehicle)driveable, f1);
   }

   public void render(DriveableType type) {
      super.render(type);
      this.renderPart(this.leftBackWheelModel);
      this.renderPart(this.rightBackWheelModel);
      this.renderPart(this.leftFrontWheelModel);
      this.renderPart(this.rightFrontWheelModel);
      this.renderPart(this.rightTrackModel);
      this.renderPart(this.leftTrackModel);
      this.renderPart(this.rightTrackWheelModels);
      this.renderPart(this.leftTrackWheelModels);
      this.renderPart(this.bodyDoorCloseModel);
      this.renderPart(this.trailerModel);
      GL11.glPushMatrix();
      GL11.glScalef(this.turretScale.x, this.turretScale.y, this.turretScale.z);
      GL11.glTranslatef(this.turretTrans.x, this.turretTrans.y, this.turretTrans.z);
      this.renderPart(this.turretModel);
      this.renderPart(this.barrelModel);
      GL11.glPopMatrix();
      this.renderPart(this.drillHeadModel);
      ModelRendererTurbo[][] var2 = this.ammoModel;
      int var3 = var2.length;

      int var4;
      ModelRendererTurbo[] ratm;
      for(var4 = 0; var4 < var3; ++var4) {
         ratm = var2[var4];
         this.renderPart(ratm);
      }

      var2 = this.leftAnimTrackModel;
      var3 = var2.length;

      for(var4 = 0; var4 < var3; ++var4) {
         ratm = var2[var4];
         this.renderPart(ratm);
      }

      var2 = this.rightAnimTrackModel;
      var3 = var2.length;

      for(var4 = 0; var4 < var3; ++var4) {
         ratm = var2[var4];
         this.renderPart(ratm);
      }

      this.renderPart(this.rightAnimTrackModel1);
      this.renderPart(this.leftAnimTrackModel1);
      this.renderPart(this.rightAnimTrackModel2);
      this.renderPart(this.leftAnimTrackModel2);
      this.renderPart(this.rightAnimTrackModel3);
      this.renderPart(this.leftAnimTrackModel3);
      this.renderPart(this.steeringWheelModel);
      this.renderPart(this.steeringWheelModel);
      this.renderPart(this.barrelSpecModel);
      this.renderTrackInGUI(type);
      GL11.glPushMatrix();
      GL11.glTranslatef(this.barrelAttach.x, this.barrelAttach.y, -this.barrelAttach.z);
      this.renderPart(this.animBarrelModel);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(this.doorAttach.x, this.doorAttach.y, -this.doorAttach.z);
      this.renderPart(this.doorAnimModel);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(this.door2Attach.x, this.door2Attach.y, -this.door2Attach.z);
      this.renderPart(this.door2AnimModel);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(this.drakonArmAttach.x, this.drakonArmAttach.y, this.drakonArmAttach.z);
      this.renderPart(this.drakonArmModel);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(this.drakonRailAttach.x, this.drakonRailAttach.y, this.drakonRailAttach.z);
      this.renderPart(this.drakonRailModel);
      this.renderPart(this.drakonModel);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(this.drakonDoorAttach.x, this.drakonDoorAttach.y, this.drakonDoorAttach.z);
      this.renderPart(this.drakonDoorModel);
      GL11.glPopMatrix();
   }

   public void renderTrackInGUI(DriveableType type) {
      AnimTankTrack rightTrack = new AnimTankTrack(type.rightTrackPoints, type.trackLinkLength);
      AnimTankTrack leftTrack = new AnimTankTrack(type.leftTrackPoints, type.trackLinkLength);
      AnimTrackLink[] trackLinksLeft = new AnimTrackLink[0];
      AnimTrackLink[] trackLinksRight = new AnimTrackLink[0];
      int numLinks = Math.round(rightTrack.getTrackLength() / type.trackLinkLength);
      trackLinksLeft = new AnimTrackLink[numLinks];
      trackLinksRight = new AnimTrackLink[numLinks];

      int i;
      for(i = 0; i < numLinks; ++i) {
         float progress = 0.01F + type.trackLinkLength * (float)i;
         int trackPart = leftTrack.getTrackPart(progress);
         trackLinksLeft[i] = new AnimTrackLink(progress);
         trackLinksRight[i] = new AnimTrackLink(progress);
         trackLinksLeft[i].position = leftTrack.getPositionOnTrack(progress);
         trackLinksRight[i].position = rightTrack.getPositionOnTrack(progress);
         trackLinksLeft[i].rot = new RotatedAxes(0.0F, 0.0F, this.rotateTowards((Vector3f)leftTrack.points.get(trackPart == 0 ? leftTrack.points.size() - 1 : trackPart - 1), trackLinksLeft[i].position));
         trackLinksRight[i].rot = new RotatedAxes(0.0F, 0.0F, this.rotateTowards((Vector3f)rightTrack.points.get(trackPart == 0 ? rightTrack.points.size() - 1 : trackPart - 1), trackLinksRight[i].position));
         trackLinksLeft[i].zRot = this.rotateTowards((Vector3f)leftTrack.points.get(trackPart == 0 ? leftTrack.points.size() - 1 : trackPart - 1), trackLinksLeft[i].position);
         trackLinksRight[i].zRot = this.rotateTowards((Vector3f)rightTrack.points.get(trackPart == 0 ? rightTrack.points.size() - 1 : trackPart - 1), trackLinksRight[i].position);
      }

      AnimTrackLink link;
      float rotZ;
      for(i = 0; i < trackLinksLeft.length; ++i) {
         link = trackLinksLeft[i];
         rotZ = link.zRot;
         GL11.glPushMatrix();
         GL11.glTranslatef(link.position.x / 16.0F, link.position.y / 16.0F, link.position.z / 16.0F);

         while(rotZ > 180.0F) {
            rotZ -= 360.0F;
         }

         while(rotZ <= -180.0F) {
            rotZ += 360.0F;
         }

         GL11.glRotatef(rotZ * 57.29578F, 0.0F, 0.0F, 1.0F);
         this.renderPart(this.fancyTrackModel);
         GL11.glPopMatrix();
      }

      for(i = 0; i < trackLinksRight.length; ++i) {
         link = trackLinksRight[i];

         for(rotZ = link.zRot; rotZ > 180.0F; rotZ -= 360.0F) {
         }

         while(rotZ <= -180.0F) {
            rotZ += 360.0F;
         }

         GL11.glPushMatrix();
         GL11.glTranslatef(link.position.x / 16.0F, link.position.y / 16.0F, link.position.z / 16.0F);
         GL11.glRotatef(rotZ * 57.29578F, 0.0F, 0.0F, 1.0F);
         this.renderPart(this.fancyTrackModel);
         GL11.glPopMatrix();
      }

   }

   public float rotateTowards(Vector3f point, Vector3f original) {
      float angle = (float)Math.atan2((double)(point.y - original.y), (double)(point.x - original.x));
      return angle;
   }

   public void render(float f5, EntityVehicle vehicle, float f) {
      boolean rotateWheels = vehicle.getVehicleType().rotateWheels;
      this.animFrameLeft = (float)vehicle.animFrameLeft;
      this.animFrameRight = (float)vehicle.animFrameRight;
      ModelRendererTurbo[] var5;
      int var6;
      int var7;
      ModelRendererTurbo aRightTrackModel3;
      if (vehicle.isPartIntact(EnumDriveablePart.core)) {
         var5 = this.bodyModel;
         var6 = var5.length;

         for(var7 = 0; var7 < var6; ++var7) {
            aRightTrackModel3 = var5[var7];
            aRightTrackModel3.render(f5, this.oldRotateOrder);
         }

         var5 = this.bodyDoorOpenModel;
         var6 = var5.length;

         for(var7 = 0; var7 < var6; ++var7) {
            aRightTrackModel3 = var5[var7];
            if (vehicle.varDoor) {
               aRightTrackModel3.render(f5, this.oldRotateOrder);
            }
         }

         var5 = this.bodyDoorCloseModel;
         var6 = var5.length;

         for(var7 = 0; var7 < var6; ++var7) {
            aRightTrackModel3 = var5[var7];
            if (!vehicle.varDoor) {
               aRightTrackModel3.render(f5, this.oldRotateOrder);
            }
         }

         var5 = this.steeringWheelModel;
         var6 = var5.length;

         for(var7 = 0; var7 < var6; ++var7) {
            aRightTrackModel3 = var5[var7];
            if (!vehicle.hugeBoat) {
               aRightTrackModel3.field_78795_f = vehicle.wheelsYaw * 3.1415927F / 180.0F * 3.0F;
            } else {
               aRightTrackModel3.field_78795_f = -vehicle.wheelsYaw * 3.1415927F / 180.0F * 3.0F;
            }

            aRightTrackModel3.render(f5, this.oldRotateOrder);
         }
      }

      if (vehicle.isPartIntact(EnumDriveablePart.backLeftWheel)) {
         var5 = this.leftBackWheelModel;
         var6 = var5.length;

         for(var7 = 0; var7 < var6; ++var7) {
            aRightTrackModel3 = var5[var7];
            aRightTrackModel3.field_78808_h = rotateWheels ? -vehicle.wheelsAngle : 0.0F;
            aRightTrackModel3.render(f5, this.oldRotateOrder);
         }
      }

      if (vehicle.isPartIntact(EnumDriveablePart.backRightWheel)) {
         var5 = this.rightBackWheelModel;
         var6 = var5.length;

         for(var7 = 0; var7 < var6; ++var7) {
            aRightTrackModel3 = var5[var7];
            aRightTrackModel3.field_78808_h = rotateWheels ? -vehicle.wheelsAngle : 0.0F;
            aRightTrackModel3.render(f5, this.oldRotateOrder);
         }
      }

      if (vehicle.isPartIntact(EnumDriveablePart.frontLeftWheel)) {
         var5 = this.leftFrontWheelModel;
         var6 = var5.length;

         for(var7 = 0; var7 < var6; ++var7) {
            aRightTrackModel3 = var5[var7];
            aRightTrackModel3.field_78808_h = rotateWheels ? -vehicle.wheelsAngle : 0.0F;
            aRightTrackModel3.field_78796_g = -vehicle.wheelsYaw * 3.1415927F / 180.0F * 3.0F;
            aRightTrackModel3.render(f5, this.oldRotateOrder);
         }
      }

      if (vehicle.isPartIntact(EnumDriveablePart.frontRightWheel)) {
         var5 = this.rightFrontWheelModel;
         var6 = var5.length;

         for(var7 = 0; var7 < var6; ++var7) {
            aRightTrackModel3 = var5[var7];
            aRightTrackModel3.field_78808_h = rotateWheels ? -vehicle.wheelsAngle : 0.0F;
            aRightTrackModel3.field_78796_g = -vehicle.wheelsYaw * 3.1415927F / 180.0F * 3.0F;
            aRightTrackModel3.render(f5, this.oldRotateOrder);
         }
      }

      if (vehicle.isPartIntact(EnumDriveablePart.frontWheel)) {
         var5 = this.frontWheelModel;
         var6 = var5.length;

         for(var7 = 0; var7 < var6; ++var7) {
            aRightTrackModel3 = var5[var7];
            aRightTrackModel3.field_78808_h = rotateWheels ? -vehicle.wheelsAngle : 0.0F;
            aRightTrackModel3.field_78796_g = -vehicle.wheelsYaw * 3.1415927F / 180.0F * 3.0F;
            aRightTrackModel3.render(f5, this.oldRotateOrder);
         }
      }

      if (vehicle.isPartIntact(EnumDriveablePart.backWheel)) {
         var5 = this.backWheelModel;
         var6 = var5.length;

         for(var7 = 0; var7 < var6; ++var7) {
            aRightTrackModel3 = var5[var7];
            aRightTrackModel3.field_78808_h = rotateWheels ? -vehicle.wheelsAngle : 0.0F;
            aRightTrackModel3.render(f5, this.oldRotateOrder);
         }
      }

      ModelRendererTurbo aRightAnimTrackModel;
      int i;
      ModelRendererTurbo[] var18;
      int var19;
      if (vehicle.isPartIntact(EnumDriveablePart.leftTrack)) {
         var5 = this.leftTrackModel;
         var6 = var5.length;

         for(var7 = 0; var7 < var6; ++var7) {
            aRightTrackModel3 = var5[var7];
            aRightTrackModel3.render(f5, this.oldRotateOrder);
         }

         var5 = this.leftTrackWheelModels;
         var6 = var5.length;

         for(var7 = 0; var7 < var6; ++var7) {
            aRightTrackModel3 = var5[var7];
            aRightTrackModel3.field_78808_h = rotateWheels ? -vehicle.wheelsAngle : 0.0F;
            aRightTrackModel3.render(f5, this.oldRotateOrder);
         }

         if (vehicle.animFrameLeft == 0) {
            var5 = this.leftAnimTrackModel1;
            var6 = var5.length;

            for(var7 = 0; var7 < var6; ++var7) {
               aRightTrackModel3 = var5[var7];
               aRightTrackModel3.render(f5, this.oldRotateOrder);
            }
         } else if (vehicle.animFrameLeft == 1) {
            var5 = this.leftAnimTrackModel2;
            var6 = var5.length;

            for(var7 = 0; var7 < var6; ++var7) {
               aRightTrackModel3 = var5[var7];
               aRightTrackModel3.render(f5, this.oldRotateOrder);
            }
         } else if (vehicle.animFrameLeft == 2) {
            var5 = this.leftAnimTrackModel3;
            var6 = var5.length;

            for(var7 = 0; var7 < var6; ++var7) {
               aRightTrackModel3 = var5[var7];
               aRightTrackModel3.render(f5, this.oldRotateOrder);
            }
         }

         for(i = 0; i < this.leftAnimTrackModel.length; ++i) {
            if ((float)i == this.animFrameLeft) {
               var18 = this.leftAnimTrackModel[i];
               var7 = var18.length;

               for(var19 = 0; var19 < var7; ++var19) {
                  aRightAnimTrackModel = var18[var19];
                  aRightAnimTrackModel.render(f5, this.oldRotateOrder);
               }
            }
         }
      }

      if (vehicle.isPartIntact(EnumDriveablePart.rightTrack)) {
         var5 = this.rightTrackModel;
         var6 = var5.length;

         for(var7 = 0; var7 < var6; ++var7) {
            aRightTrackModel3 = var5[var7];
            aRightTrackModel3.render(f5, this.oldRotateOrder);
         }

         var5 = this.rightTrackWheelModels;
         var6 = var5.length;

         for(var7 = 0; var7 < var6; ++var7) {
            aRightTrackModel3 = var5[var7];
            aRightTrackModel3.field_78808_h = rotateWheels ? -vehicle.wheelsAngle : 0.0F;
            aRightTrackModel3.render(f5, this.oldRotateOrder);
         }

         if (vehicle.animFrameRight == 0) {
            var5 = this.rightAnimTrackModel1;
            var6 = var5.length;

            for(var7 = 0; var7 < var6; ++var7) {
               aRightTrackModel3 = var5[var7];
               aRightTrackModel3.render(f5, this.oldRotateOrder);
            }
         } else if (vehicle.animFrameRight == 1) {
            var5 = this.rightAnimTrackModel2;
            var6 = var5.length;

            for(var7 = 0; var7 < var6; ++var7) {
               aRightTrackModel3 = var5[var7];
               aRightTrackModel3.render(f5, this.oldRotateOrder);
            }
         } else if (vehicle.animFrameRight == 2) {
            var5 = this.rightAnimTrackModel3;
            var6 = var5.length;

            for(var7 = 0; var7 < var6; ++var7) {
               aRightTrackModel3 = var5[var7];
               aRightTrackModel3.render(f5, this.oldRotateOrder);
            }
         }

         for(i = 0; i < this.rightAnimTrackModel.length; ++i) {
            if ((float)i == this.animFrameRight) {
               var18 = this.rightAnimTrackModel[i];
               var7 = var18.length;

               for(var19 = 0; var19 < var7; ++var19) {
                  aRightAnimTrackModel = var18[var19];
                  aRightAnimTrackModel.render(f5, this.oldRotateOrder);
               }
            }
         }
      }

      if (vehicle.isPartIntact(EnumDriveablePart.trailer)) {
         var5 = this.trailerModel;
         var6 = var5.length;

         for(var7 = 0; var7 < var6; ++var7) {
            aRightTrackModel3 = var5[var7];
            aRightTrackModel3.render(f5, this.oldRotateOrder);
         }
      }

      EntitySeat[] var20 = vehicle.seats;
      var6 = var20.length;

      for(var7 = 0; var7 < var6; ++var7) {
         EntitySeat seat = var20[var7];
         if (seat != null && seat.seatInfo != null && seat.seatInfo.gunName != null && this.gunModels.get(seat.seatInfo.gunName) != null && vehicle.isPartIntact(seat.seatInfo.part) && !vehicle.rotateWithTurret(seat.seatInfo)) {
            float yaw = seat.prevLooking.getYaw() + (seat.looking.getYaw() - seat.prevLooking.getYaw()) * f;
            float pitch = seat.prevLooking.getPitch() + (seat.looking.getPitch() - seat.prevLooking.getPitch()) * f;
            ModelRendererTurbo[][] gunModel = (ModelRendererTurbo[][])this.gunModels.get(seat.seatInfo.gunName);
            ModelRendererTurbo[] var12 = gunModel[0];
            int var13 = var12.length;

            int var14;
            ModelRendererTurbo gunModelPart;
            for(var14 = 0; var14 < var13; ++var14) {
               gunModelPart = var12[var14];
               GL11.glPushMatrix();
               GL11.glScalef(vehicle.getVehicleType().vehicleGunModelScale, vehicle.getVehicleType().vehicleGunModelScale, vehicle.getVehicleType().vehicleGunModelScale);
               gunModelPart.field_78796_g = -yaw * 3.1415927F / 180.0F;
               gunModelPart.func_78785_a(f5);
               GL11.glPopMatrix();
            }

            GL11.glPushMatrix();
            GL11.glScalef(vehicle.getVehicleType().vehicleGunModelScale, vehicle.getVehicleType().vehicleGunModelScale, vehicle.getVehicleType().vehicleGunModelScale);
            var12 = gunModel[1];
            var13 = var12.length;

            for(var14 = 0; var14 < var13; ++var14) {
               gunModelPart = var12[var14];
               gunModelPart.field_78796_g = -yaw * 3.1415927F / 180.0F;
               gunModelPart.field_78808_h = -pitch * 3.1415927F / 180.0F;
               gunModelPart.func_78785_a(f5);
            }

            var12 = gunModel[2];
            var13 = var12.length;

            for(var14 = 0; var14 < var13; ++var14) {
               gunModelPart = var12[var14];
               gunModelPart.field_78796_g = -yaw * 3.1415927F / 180.0F;
               gunModelPart.field_78808_h = -pitch * 3.1415927F / 180.0F;
               gunModelPart.func_78785_a(f5);
            }

            GL11.glPopMatrix();
         }
      }

   }

   public void renderDoor(EntityVehicle vehicle, float f5) {
      if (vehicle.isPartIntact(EnumDriveablePart.core)) {
         ModelRendererTurbo[] var3 = this.doorAnimModel;
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            ModelRendererTurbo aDoorAnimModel = var3[var5];
            aDoorAnimModel.func_78785_a(f5);
         }
      }

   }

   public void renderDoor2(EntityVehicle vehicle, float f5) {
      if (vehicle.isPartIntact(EnumDriveablePart.core)) {
         ModelRendererTurbo[] var3 = this.door2AnimModel;
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            ModelRendererTurbo aDoor2AnimModel = var3[var5];
            aDoor2AnimModel.func_78785_a(f5);
         }
      }

   }

   public void renderTurret(float f, float f1, float f2, float f3, float f4, float f5, EntityVehicle vehicle, float dt) {
      VehicleType type = vehicle.getVehicleType();
      GL11.glPushMatrix();
      GL11.glScalef(this.turretScale.x, this.turretScale.y, this.turretScale.z);
      GL11.glTranslatef(this.turretTrans.x, this.turretTrans.y, this.turretTrans.z);
      float yaw;
      if (this.fancyTurret) {
         ResourceLocation turretobj = new ResourceLocation("flansmod", "models/" + this.turretName);
         IModelCustom model = AdvancedModelLoader.loadModel(turretobj);
         GL11.glPushMatrix();
         yaw = 1.0F;
         model.renderAll();
         GL11.glPopMatrix();
      }

      yaw = vehicle.seats[0].looking.getYaw();
      float pitch = vehicle.seats[0].looking.getPitch();
      float dPitch = vehicle.seats[0].looking.getPitch() - vehicle.seats[0].prevLooking.getPitch();
      float aPitch = vehicle.seats[0].prevLooking.getPitch() + dPitch * dt;
      ModelRendererTurbo[] var16 = this.turretModel;
      int j = var16.length;

      int var18;
      ModelRendererTurbo aBarrelModel;
      for(var18 = 0; var18 < j; ++var18) {
         aBarrelModel = var16[var18];
         aBarrelModel.render(f5, this.oldRotateOrder);
      }

      var16 = this.barrelModel;
      j = var16.length;

      for(var18 = 0; var18 < j; ++var18) {
         aBarrelModel = var16[var18];
         aBarrelModel.field_78808_h = -(aPitch * 3.1415927F / 180.0F);
         aBarrelModel.render(f5, this.oldRotateOrder);
      }

      GL11.glPushMatrix();
      GL11.glTranslatef(this.barrelAttach.x, this.barrelAttach.y, -this.barrelAttach.z);
      GL11.glRotatef(-aPitch, 0.0F, 0.0F, 1.0F);
      var16 = this.barrelSpecModel;
      j = var16.length;

      for(var18 = 0; var18 < j; ++var18) {
         aBarrelModel = var16[var18];
         aBarrelModel.render(f5, this.oldRotateOrder);
      }

      GL11.glPopMatrix();

      for(int i = 0; i < this.ammoModel.length; ++i) {
         if (i >= type.numMissileSlots || vehicle.getDriveableData().missiles[i] != null) {
            for(j = 0; j < this.ammoModel[i].length; ++j) {
               this.ammoModel[i][j].field_78808_h = -pitch * 3.1415927F / 180.0F;
               this.ammoModel[i][j].render(f5, this.oldRotateOrder);
            }
         }
      }

      float armAngle = vehicle.drakonArmAngle;

      float driverYaw;
      for(driverYaw = vehicle.drakonArmAngle - vehicle.prevDrakonArmAngle; driverYaw > 180.0F; driverYaw -= 360.0F) {
      }

      while(driverYaw <= -180.0F) {
         driverYaw += 360.0F;
      }

      float yaw = vehicle.prevDrakonArmAngle + driverYaw * dt;
      float pitch = vehicle.drakonRailAngle;

      float effectiveYaw;
      for(effectiveYaw = vehicle.drakonRailAngle - vehicle.prevDrakonRailAngle; effectiveYaw > 180.0F; effectiveYaw -= 360.0F) {
      }

      while(effectiveYaw <= -180.0F) {
         effectiveYaw += 360.0F;
      }

      float drakonRailAngle = vehicle.prevDrakonRailAngle + effectiveYaw * dt;
      float doorAngle = vehicle.drakonDoorAngle;

      float dDoorAngle;
      for(dDoorAngle = vehicle.drakonDoorAngle - vehicle.prevDrakonDoorAngle; dDoorAngle > 180.0F; dDoorAngle -= 360.0F) {
      }

      while(dDoorAngle <= -180.0F) {
         dDoorAngle += 360.0F;
      }

      float drakonDoorAngle = vehicle.prevDrakonDoorAngle + dDoorAngle * dt;
      GL11.glPushMatrix();
      GL11.glTranslatef(this.drakonArmAttach.x, this.drakonArmAttach.y, this.drakonArmAttach.z);
      GL11.glRotatef(yaw, 0.0F, 0.0F, 1.0F);
      ModelRendererTurbo[] var25 = this.drakonArmModel;
      int var26 = var25.length;

      int var27;
      ModelRendererTurbo aDoorModel;
      for(var27 = 0; var27 < var26; ++var27) {
         aDoorModel = var25[var27];
         aDoorModel.render(f5, this.oldRotateOrder);
      }

      GL11.glTranslatef(this.drakonRailAttach.x - this.drakonArmAttach.x, this.drakonRailAttach.y - this.drakonArmAttach.y, this.drakonRailAttach.z - this.drakonArmAttach.z);
      GL11.glRotatef(drakonRailAngle, 0.0F, 0.0F, 1.0F);
      var25 = this.drakonRailModel;
      var26 = var25.length;

      for(var27 = 0; var27 < var26; ++var27) {
         aDoorModel = var25[var27];
         aDoorModel.render(f5, this.oldRotateOrder);
      }

      if (vehicle.canFireIT1) {
         var25 = this.drakonModel;
         var26 = var25.length;

         for(var27 = 0; var27 < var26; ++var27) {
            aDoorModel = var25[var27];
            aDoorModel.render(f5, this.oldRotateOrder);
         }
      }

      if (vehicle.reloadingDrakon && !vehicle.canFireIT1) {
         var25 = this.drakonReloadModel;
         var26 = var25.length;

         for(var27 = 0; var27 < var26; ++var27) {
            aDoorModel = var25[var27];
            aDoorModel.render(f5, this.oldRotateOrder);
         }
      }

      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(this.drakonDoorAttach.x, this.drakonDoorAttach.y, this.drakonDoorAttach.z);
      GL11.glRotatef(drakonDoorAngle, 1.0F, 0.0F, 0.0F);
      var25 = this.drakonDoorModel;
      var26 = var25.length;

      for(var27 = 0; var27 < var26; ++var27) {
         aDoorModel = var25[var27];
         aDoorModel.render(f5, this.oldRotateOrder);
      }

      GL11.glPopMatrix();
      EntitySeat[] var29 = vehicle.seats;
      int var30 = var29.length;

      for(int var31 = 0; var31 < var30; ++var31) {
         EntitySeat seat = var29[var31];
         if (seat != null && seat.seatInfo != null && seat.seatInfo.gunName != null && this.gunModels.get(seat.seatInfo.gunName) != null && vehicle.isPartIntact(seat.seatInfo.part) && vehicle.rotateWithTurret(seat.seatInfo)) {
            EntitySeat driverSeat = vehicle.seats[0];
            driverYaw = driverSeat.prevLooking.getYaw() + (driverSeat.looking.getYaw() - driverSeat.prevLooking.getYaw()) * dt;
            yaw = seat.prevLooking.getYaw() + (seat.looking.getYaw() - seat.prevLooking.getYaw()) * dt;
            pitch = seat.prevLooking.getPitch() + (seat.looking.getPitch() - seat.prevLooking.getPitch()) * dt;
            effectiveYaw = yaw - driverYaw;
            ModelRendererTurbo[][] gunModel = (ModelRendererTurbo[][])this.gunModels.get(seat.seatInfo.gunName);
            ModelRendererTurbo[] var40 = gunModel[0];
            int var41 = var40.length;

            int var42;
            ModelRendererTurbo gunModelPart;
            for(var42 = 0; var42 < var41; ++var42) {
               gunModelPart = var40[var42];
               gunModelPart.field_78796_g = -effectiveYaw * 3.1415927F / 180.0F;
               gunModelPart.render(f5, this.oldRotateOrder);
            }

            var40 = gunModel[1];
            var41 = var40.length;

            for(var42 = 0; var42 < var41; ++var42) {
               gunModelPart = var40[var42];
               gunModelPart.field_78796_g = -effectiveYaw * 3.1415927F / 180.0F;
               gunModelPart.field_78808_h = -pitch * 3.1415927F / 180.0F;
               gunModelPart.render(f5, this.oldRotateOrder);
            }

            var40 = gunModel[2];
            var41 = var40.length;

            for(var42 = 0; var42 < var41; ++var42) {
               gunModelPart = var40[var42];
               gunModelPart.field_78796_g = -effectiveYaw * 3.1415927F / 180.0F;
               gunModelPart.field_78808_h = -pitch * 3.1415927F / 180.0F;
               gunModelPart.render(f5, this.oldRotateOrder);
            }
         }
      }

      GL11.glPopMatrix();
   }

   public void renderAnimBarrel(float f, float f1, float f2, float f3, float f4, float f5, EntityVehicle vehicle, float dt) {
      if (vehicle.isPartIntact(EnumDriveablePart.turret)) {
         ModelRendererTurbo[] var9 = this.animBarrelModel;
         int var10 = var9.length;

         for(int var11 = 0; var11 < var10; ++var11) {
            ModelRendererTurbo aAnimBarrelModel = var9[var11];
            aAnimBarrelModel.render(f5, this.oldRotateOrder);
         }
      }

   }

   public void renderDrillBit(EntityVehicle vehicle, float f) {
      if (vehicle.isPartIntact(EnumDriveablePart.harvester)) {
         ModelRendererTurbo[] var3 = this.drillHeadModel;
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            ModelRendererTurbo adrillHeadModel = var3[var5];
            adrillHeadModel.render(0.0625F, this.oldRotateOrder);
         }
      }

   }

   public void renderFancyTracks(EntityVehicle vehicle, float f) {
      ModelRendererTurbo[] var3 = this.fancyTrackModel;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         ModelRendererTurbo adrillHeadModel = var3[var5];
         adrillHeadModel.render(0.0625F, this.oldRotateOrder);
      }

   }

   public void flipAll() {
      super.flipAll();
      this.flip(this.bodyDoorOpenModel);
      this.flip(this.bodyDoorCloseModel);
      this.flip(this.turretModel);
      this.flip(this.barrelModel);
      this.flip(this.barrelSpecModel);
      this.flip(this.animBarrelModel);
      this.flip(this.leftFrontWheelModel);
      this.flip(this.rightFrontWheelModel);
      this.flip(this.leftBackWheelModel);
      this.flip(this.rightBackWheelModel);
      this.flip(this.rightTrackModel);
      this.flip(this.leftTrackModel);
      this.flip(this.rightTrackWheelModels);
      this.flip(this.leftTrackWheelModels);
      this.flip(this.trailerModel);
      this.flip(this.steeringWheelModel);
      this.flip(this.frontWheelModel);
      this.flip(this.backWheelModel);
      this.flip(this.drillHeadModel);
      this.flip(this.rightAnimTrackModel1);
      this.flip(this.leftAnimTrackModel1);
      this.flip(this.rightAnimTrackModel2);
      this.flip(this.leftAnimTrackModel2);
      this.flip(this.rightAnimTrackModel3);
      this.flip(this.leftAnimTrackModel3);
      this.flip(this.drakonArmModel);
      this.flip(this.drakonRailModel);
      this.flip(this.drakonDoorModel);
      this.flip(this.drakonModel);
      this.flip(this.drakonReloadModel);
      ModelRendererTurbo[][] var1 = this.leftAnimTrackModel;
      int var2 = var1.length;

      int var3;
      ModelRendererTurbo[] ratm;
      for(var3 = 0; var3 < var2; ++var3) {
         ratm = var1[var3];
         this.flip(ratm);
      }

      var1 = this.rightAnimTrackModel;
      var2 = var1.length;

      for(var3 = 0; var3 < var2; ++var3) {
         ratm = var1[var3];
         this.flip(ratm);
      }

      this.flip(this.doorAnimModel);
      this.flip(this.door2AnimModel);
      this.flip(this.fancyTrackModel);
   }

   public void translateAll(float x, float y, float z) {
      super.translateAll(x, y, z);
      this.translate(this.bodyDoorOpenModel, x, y, z);
      this.translate(this.bodyDoorCloseModel, x, y, z);
      this.translate(this.turretModel, x, y, z);
      this.translate(this.barrelModel, x, y, z);
      this.translate(this.barrelSpecModel, x, y, z);
      this.translate(this.animBarrelModel, x, y, z);
      this.translate(this.leftFrontWheelModel, x, y, z);
      this.translate(this.rightFrontWheelModel, x, y, z);
      this.translate(this.leftBackWheelModel, x, y, z);
      this.translate(this.rightBackWheelModel, x, y, z);
      this.translate(this.rightTrackModel, x, y, z);
      this.translate(this.leftTrackModel, x, y, z);
      this.translate(this.rightTrackWheelModels, x, y, z);
      this.translate(this.leftTrackWheelModels, x, y, z);
      this.translate(this.trailerModel, x, y, z);
      this.translate(this.steeringWheelModel, x, y, z);
      this.translate(this.frontWheelModel, x, y, z);
      this.translate(this.backWheelModel, x, y, z);
      this.translate(this.drillHeadModel, x, y, z);
      this.translate(this.rightAnimTrackModel1, x, y, z);
      this.translate(this.leftAnimTrackModel1, x, y, z);
      this.translate(this.rightAnimTrackModel2, x, y, z);
      this.translate(this.leftAnimTrackModel2, x, y, z);
      this.translate(this.rightAnimTrackModel3, x, y, z);
      this.translate(this.leftAnimTrackModel3, x, y, z);
      ModelRendererTurbo[][] var4 = this.leftAnimTrackModel;
      int var5 = var4.length;

      int var6;
      ModelRendererTurbo[] ratm;
      for(var6 = 0; var6 < var5; ++var6) {
         ratm = var4[var6];
         this.translate(ratm, x, y, z);
      }

      var4 = this.rightAnimTrackModel;
      var5 = var4.length;

      for(var6 = 0; var6 < var5; ++var6) {
         ratm = var4[var6];
         this.translate(ratm, x, y, z);
      }

      this.translate(this.doorAnimModel, x, y, z);
      this.translate(this.door2AnimModel, x, y, z);
      this.translate(this.drakonArmModel, x, y, z);
      this.translate(this.drakonRailModel, x, y, z);
      this.translate(this.drakonDoorModel, x, y, z);
      this.translate(this.drakonReloadModel, x, y, z);
      this.translate(this.drakonModel, x, y, z);
      this.translate(this.fancyTrackModel, x, y, z);
   }
}
