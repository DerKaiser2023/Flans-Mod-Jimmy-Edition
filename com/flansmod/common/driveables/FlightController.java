package com.flansmod.common.driveables;

import com.flansmod.common.vector.Vector3f;
import java.util.Iterator;

public class FlightController {
   public float throttle;
   public float yawControl;
   public float pitchControl;
   public float rollControl;
   public EnumPlaneMode mode;
   public float gravity = 1.0F;
   public float drag = 0.0F;
   public float thrust = 0.0F;
   public float lift = 0.0F;
   public Vector3f angularMomentum = new Vector3f(0.0F, 0.0F, 0.0F);
   private Object mounted;

   public void UpdateParams(EntityPlane plane) {
      this.throttle = plane.throttle;
      this.yawControl = plane.flapsYaw;
      this.pitchControl = (plane.flapsPitchLeft + plane.flapsPitchRight) / 2.0F;
      this.rollControl = (plane.flapsPitchRight - plane.flapsPitchLeft) / 2.0F;
      this.mode = plane.mode;
   }

   public void fly(EntityPlane plane) {
      PlaneType type = plane.getPlaneType();
      DriveableData data = plane.getDriveableData();
      this.UpdateParams(plane);
      this.SetAxes(plane);
      this.thrust = 0.01F * (type.maxThrottle + (data.engine == null ? 0.0F : data.engine.engineSpeed));
      this.gravity = 0.098000005F;
      this.drag = 1.0F - 0.05F * type.drag;
      switch(this.mode) {
      case PLANE:
         this.PlaneModeFly(plane);
      case HELI:
         this.HeliModeFly(plane);
      default:
      }
   }

   public void SetAxes(EntityPlane plane) {
      PlaneType type = plane.getPlaneType();
      float sensitivityAdjust = (float)plane.getSpeedXYZ() / 2.0F > 0.5F ? 1.5F - (float)plane.getSpeedXYZ() / 2.0F : 4.0F * (float)plane.getSpeedXYZ() / 2.0F - 1.0F;
      if (this.mode == EnumPlaneMode.HELI) {
         sensitivityAdjust = this.throttle > 0.5F ? 1.5F - this.throttle : 4.0F * this.throttle - 1.0F;
      }

      if ((double)((float)plane.getSpeedXYZ()) < 0.5D && sensitivityAdjust < 0.0F) {
         sensitivityAdjust = 0.0F;
      }

      float yaw = this.yawControl * (this.yawControl > 0.0F ? type.turnLeftModifier : type.turnRightModifier) * (sensitivityAdjust *= 0.125F);
      float pitch = this.pitchControl * (this.pitchControl > 0.0F ? type.lookUpModifier : type.lookDownModifier) * sensitivityAdjust;
      float roll = this.rollControl * (this.rollControl > 0.0F ? type.rollLeftModifier : type.rollRightModifier) * sensitivityAdjust;
      if (this.mode == EnumPlaneMode.PLANE) {
         if (!plane.isPartIntact(EnumDriveablePart.tail)) {
            yaw = 0.0F;
            pitch = 0.0F;
         }

         if (!plane.isPartIntact(EnumDriveablePart.nose)) {
            pitch = (float)((double)pitch - 20.0D * plane.getSpeedXZ());
         }

         if (!plane.isPartIntact(EnumDriveablePart.tail)) {
            pitch = (float)((double)pitch + 20.0D * plane.getSpeedXZ());
         }

         if (!plane.isPartIntact(EnumDriveablePart.leftWing)) {
            roll = (float)((double)roll - 20.0D * plane.getSpeedXZ());
         }

         if (!plane.isPartIntact(EnumDriveablePart.rightWing)) {
            roll = (float)((double)roll + 20.0D * plane.getSpeedXZ());
         }
      } else if (this.mode == EnumPlaneMode.HELI && !plane.isPartIntact(EnumDriveablePart.tail)) {
         yaw = 25.0F * this.throttle;
         roll = 5.0F * this.throttle;
      }

      this.angularMomentum.x = this.moveToTarget(this.angularMomentum.x, yaw, 1.0F);
      this.angularMomentum.y = this.moveToTarget(this.angularMomentum.y, pitch, 1.0F);
      this.angularMomentum.z = this.moveToTarget(this.angularMomentum.z, roll, 1.0F);
      this.LimitAngularMomentum(this.angularMomentum, 20.0F);
      plane.axes.rotateLocalYaw(this.angularMomentum.x);
      plane.axes.rotateLocalPitch(this.angularMomentum.y);
      plane.axes.rotateLocalRoll(-this.angularMomentum.z);
      this.angularMomentum.scale(0.99F);
   }

   public float moveToTarget(float current, float target, float speed) {
      float pitchToMove;
      for(pitchToMove = (float)(Math.sqrt((double)(target * target)) - Math.sqrt((double)(current * current))); pitchToMove > 180.0F; pitchToMove -= 360.0F) {
      }

      while(pitchToMove <= -180.0F) {
         pitchToMove += 360.0F;
      }

      float signDeltaY = 0.0F;
      if (pitchToMove > speed) {
         signDeltaY = 1.0F;
      } else {
         if (!(pitchToMove < -speed)) {
            signDeltaY = 0.0F;
            return target;
         }

         signDeltaY = -1.0F;
      }

      if (current > target) {
         current -= speed;
      } else if (current < target) {
         current += speed;
      }

      return current;
   }

   public void LimitAngularMomentum(Vector3f vec, float angle) {
      if (vec.x > angle) {
         vec.x = angle;
      }

      if (vec.x < -angle) {
         vec.x = -angle;
      }

      if (vec.y > angle) {
         vec.y = angle;
      }

      if (vec.y < -angle) {
         vec.y = -angle;
      }

      if (vec.z > angle) {
         vec.z = angle;
      }

      if (vec.z < -angle) {
         vec.z = -angle;
      }

   }

   public void PlaneModeFly(EntityPlane plane) {
      if (plane.mode != EnumPlaneMode.HELI) {
         PlaneType type = plane.getPlaneType();
         DriveableData data = plane.getDriveableData();
         int numPropsWorking = 0;
         int numProps = false;
         float fuelConsumptionMultiplier = 2.0F;
         float flap = this.angularMomentum.length();
         this.drag -= flap / 100.0F;
         this.throttle -= -flap / 500.0F;
         Iterator var8 = type.propellers.iterator();

         while(var8.hasNext()) {
            Propeller prop = (Propeller)var8.next();
            if (plane.isPartIntact(prop.planePart)) {
               ++numPropsWorking;
            }
         }

         int numProps = type.propellers.size();
         if (numProps != 0) {
            Vector3f forwards = (Vector3f)plane.axes.getXAxis().normalise();
            float lastTickSpeed = (float)plane.getSpeedXYZ();
            if (lastTickSpeed > 2.0F) {
               lastTickSpeed = 2.0F;
            }

            float newSpeed = lastTickSpeed + this.thrust * 2.0F;
            float proportionOfMotionToCorrect = 2.0F * this.throttle;
            if (proportionOfMotionToCorrect < 0.0F) {
               proportionOfMotionToCorrect = 0.0F;
            }

            if (proportionOfMotionToCorrect > 1.5F) {
               proportionOfMotionToCorrect = 1.5F;
            }

            int numWingsIntact = 0;
            if (plane.isPartIntact(EnumDriveablePart.airframe)) {
               ++numWingsIntact;
            }

            this.lift = (float)plane.getSpeedXYZ() * (float)plane.getSpeedXYZ() * (float)numWingsIntact / 1.0F;
            Vector3f up2 = (Vector3f)plane.axes.getYAxis().normalise();
            this.lift = (float)((double)this.lift * Math.sqrt((double)(up2.y * up2.y)));
            if (this.lift > this.gravity) {
               this.lift = this.gravity;
            }

            plane.field_70159_w *= (double)(1.0F - proportionOfMotionToCorrect);
            plane.field_70181_x *= (double)(1.0F - proportionOfMotionToCorrect);
            plane.field_70179_y *= (double)(1.0F - proportionOfMotionToCorrect);
            plane.field_70159_w += (double)(proportionOfMotionToCorrect * newSpeed * forwards.x);
            plane.field_70181_x += (double)(proportionOfMotionToCorrect * newSpeed * forwards.y);
            plane.field_70179_y += (double)(proportionOfMotionToCorrect * newSpeed * forwards.z);
            plane.field_70181_x += (double)this.lift;
            plane.field_70181_x -= (double)this.gravity;
            if (plane.axes.getPitch() <= 60.0F && plane.getSpeedXYZ() < 0.2D) {
               plane.field_70181_x -= (double)this.gravity;
            }

            if (plane.axes.getPitch() > 5.0F) {
               plane.field_70181_x *= 1.0D + 0.5D * (double)type.planeDiveFactor * (double)(plane.axes.getPitch() / 90.0F);
            }

            if (plane.field_70163_u > 0.55D * (double)type.ceiling && plane.field_70181_x > 0.0D) {
               plane.field_70181_x *= (double)type.ceiling / ((double)type.ceiling + plane.field_70163_u - 0.54D * (double)type.ceiling);
            }

            if (plane.field_70163_u > (double)type.ceiling) {
               plane.field_70181_x = -0.1D;
            }

            if (!plane.isPartIntact(EnumDriveablePart.airframe)) {
               plane.field_70181_x += -1.0D;
            }

            plane.field_70159_w *= (double)this.drag;
            if (plane.field_70163_u - plane.field_70167_r < 0.0D) {
               plane.field_70181_x *= this.drag < 1.0F ? 0.999D : 1.0D;
            } else {
               plane.field_70181_x *= (double)this.drag;
            }

            plane.field_70179_y *= (double)this.drag;
            plane.lastPos = new Vector3f(plane.field_70159_w, plane.field_70181_x, plane.field_70179_y);
            data.fuelInTank -= this.thrust * fuelConsumptionMultiplier * data.engine.fuelConsumption;
            if (plane.getSpeedXYZ() > 2.0D) {
               plane.axes.rotateLocalPitch(((float)Math.random() - 0.5F) / 4.0F);
               plane.axes.rotateLocalYaw(((float)Math.random() - 0.5F) / 4.0F);
               plane.axes.rotateLocalRoll(((float)Math.random() - 0.5F) / 4.0F);
            }

            if (!plane.isPartIntact(EnumDriveablePart.tail)) {
               plane.field_70181_x += -0.3D;
            }

            if (!plane.isPartIntact(EnumDriveablePart.leftWing)) {
               plane.field_70181_x += -0.4D;
            }

            if (!plane.isPartIntact(EnumDriveablePart.rightWing)) {
               plane.field_70181_x += -0.4D;
            }

         }
      }
   }

   public void HeliModeFly(EntityPlane plane) {
      PlaneType type = plane.getPlaneType();
      DriveableData data = plane.getDriveableData();
      int numPropsWorking = 0;
      int numProps = false;
      float fuelConsumptionMultiplier = 2.0F;
      Iterator var7 = type.heliPropellers.iterator();

      while(var7.hasNext()) {
         Propeller prop = (Propeller)var7.next();
         if (plane.isPartIntact(prop.planePart)) {
            ++numPropsWorking;
         }
      }

      int numProps = type.heliPropellers.size();
      this.gravity = 0.05F;
      if (numProps != 0) {
         Vector3f up = (Vector3f)plane.axes.getYAxis().normalise();
         this.thrust *= (float)(numPropsWorking / numProps) * 2.0F;
         float upwardsForce = this.throttle * this.thrust + (this.gravity - this.thrust / 2.0F);
         if (this.throttle < 0.5F) {
            upwardsForce = this.gravity * this.throttle * 2.0F;
         }

         if (!plane.isPartIntact(EnumDriveablePart.blades)) {
            upwardsForce = 0.04F;
         }

         if (this.throttle < 0.52F && this.throttle > 0.48F && up.y >= 0.7F) {
            upwardsForce = this.gravity / up.y;
         }

         if (plane.getPlaneType().mode != EnumPlaneMode.VTOL && up.y < 0.0F) {
            up.y *= -1.0F;
            up.x *= -1.0F;
            up.z *= -1.0F;
         }

         plane.field_70159_w += (double)(upwardsForce * up.x * 0.5F);
         plane.field_70181_x += (double)(upwardsForce * up.y - this.gravity);
         plane.field_70179_y += (double)(upwardsForce * up.z * 0.5F);
         plane.field_70159_w *= (double)(1.0F - (1.0F - this.drag) / 5.0F);
         plane.field_70181_x *= (double)this.drag;
         plane.field_70179_y *= (double)(1.0F - (1.0F - this.drag) / 5.0F);
         plane.lastPos = new Vector3f(plane.field_70159_w, plane.field_70181_x, plane.field_70179_y);
         if (plane.field_70163_u > (double)type.ceiling) {
            plane.field_70181_x = -0.1D;
         }

      }
   }
}
