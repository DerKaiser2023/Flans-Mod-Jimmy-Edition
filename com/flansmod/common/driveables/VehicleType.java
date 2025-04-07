package com.flansmod.common.driveables;

import com.flansmod.client.model.ModelDriveable;
import com.flansmod.client.model.ModelVehicle;
import com.flansmod.common.FlansMod;
import com.flansmod.common.types.TypeFile;
import com.flansmod.common.vector.Vector3f;
import java.util.ArrayList;
import java.util.Iterator;

public class VehicleType extends DriveableType {
   public float turnLeftModifier = 1.0F;
   public float boostLimit = 3.0F;
   public float decelModifier = 1.0F;
   public float accelModifier = 1.0F;
   public float brakeModifier = 1.0F;
   public float turnRightModifier = 1.0F;
   public float diveSpeed = 1.0F;
   public float surfaceSpeed = 1.0F;
   public boolean squashMobs = false;
   public boolean fourWheelDrive = false;
   public boolean rotateWheels = false;
   public boolean tank = false;
   public int vehicleShootDelay;
   public int vehicleShellDelay;
   public boolean hasDoor = false;
   public boolean canDabOnEntity = false;
   public boolean airship = false;
   public float maxAltitude = 269.0F;
   public float seaLevel = 40.0F;
   public Vector3f doorPos1 = new Vector3f(0.0F, 0.0F, 0.0F);
   public Vector3f doorPos2 = new Vector3f(0.0F, 0.0F, 0.0F);
   public Vector3f doorRot1 = new Vector3f(0.0F, 0.0F, 0.0F);
   public Vector3f doorRot2 = new Vector3f(0.0F, 0.0F, 0.0F);
   public Vector3f doorRate = new Vector3f(0.0F, 0.0F, 0.0F);
   public Vector3f doorRotRate = new Vector3f(0.0F, 0.0F, 0.0F);
   public Vector3f door2Pos1 = new Vector3f(0.0F, 0.0F, 0.0F);
   public Vector3f door2Pos2 = new Vector3f(0.0F, 0.0F, 0.0F);
   public Vector3f door2Rot1 = new Vector3f(0.0F, 0.0F, 0.0F);
   public Vector3f door2Rot2 = new Vector3f(0.0F, 0.0F, 0.0F);
   public Vector3f door2Rate = new Vector3f(0.0F, 0.0F, 0.0F);
   public Vector3f door2RotRate = new Vector3f(0.0F, 0.0F, 0.0F);
   public boolean shootWithOpenDoor = false;
   public int trackLinkFix = 5;
   public boolean flipLinkFix = false;
   public String driftSound = "";
   public int driftSoundLength;
   public ArrayList<VehicleType.SmokePoint> smokers = new ArrayList();
   public float Zoom;
   public static ArrayList<VehicleType> types = new ArrayList();

   public VehicleType(TypeFile file) {
      super(file);
      types.add(this);
   }

   public void preRead(TypeFile file) {
      super.preRead(file);
      this.wheelPositions = new DriveablePosition[4];
   }

   public void postRead(TypeFile file) {
      super.postRead(file);
   }

   protected void read(String[] split, TypeFile file) {
      super.read(split, file);

      try {
         if (split[0].equals("TurnLeftSpeed")) {
            this.turnLeftModifier = Float.parseFloat(split[1]);
         }

         if (split[0].equals("maxAltitude")) {
            this.maxAltitude = Float.parseFloat(split[1]);
         }

         if (split[0].equals("seaLevel")) {
            this.seaLevel = Float.parseFloat(split[1]);
         }

         if (split[0].equals("TurnRightSpeed")) {
            this.turnRightModifier = Float.parseFloat(split[1]);
         }

         if (split[0].equals("SquashMobs")) {
            this.squashMobs = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("FourWheelDrive")) {
            this.fourWheelDrive = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("Tank") || split[0].equals("TankMode")) {
            this.tank = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("AccelerationSpeed")) {
            this.accelModifier = Float.parseFloat(split[1]);
         }

         if (split[0].equals("DiveSpeed")) {
            this.diveSpeed = Float.parseFloat(split[1]);
         }

         if (split[0].equals("SurfaceSpeed")) {
            this.surfaceSpeed = Float.parseFloat(split[1]);
         }

         if (split[0].equals("BrakeMultiplier")) {
            this.brakeModifier = Float.parseFloat(split[1]);
         }

         if (split[0].equals("BoostLimit")) {
            this.boostLimit = Float.parseFloat(split[1]);
         }

         if (split[0].equals("DecelerationSpeed")) {
            this.decelModifier = Float.parseFloat(split[1]);
         }

         if (split[0].equals("canDabOnEntity")) {
            this.canDabOnEntity = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("HasDoor")) {
            this.hasDoor = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("ShootWithOpenDoor")) {
            this.shootWithOpenDoor = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("canDive")) {
            this.canDive = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("airship")) {
            this.airship = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("RotateWheels")) {
            this.rotateWheels = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("FixTrackLink")) {
            this.trackLinkFix = Integer.parseInt(split[1].toLowerCase());
         }

         if (split[0].equals("FlipLinkFix")) {
            this.flipLinkFix = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("DoorPosition1")) {
            this.doorPos1 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("DoorPosition2")) {
            this.doorPos2 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("DoorRotation1")) {
            this.doorRot1 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("DoorRotation2")) {
            this.doorRot2 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("DoorRate")) {
            this.doorRate = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("DoorRotRate")) {
            this.doorRotRate = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("Door2Position1")) {
            this.door2Pos1 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("Door2Position2")) {
            this.door2Pos2 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("Door2Rotation1")) {
            this.door2Rot1 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("Door2Rotation2")) {
            this.door2Rot2 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("Door2Rate")) {
            this.door2Rate = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("Door2RotRate")) {
            this.door2RotRate = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("ShootDelay")) {
            this.vehicleShootDelay = Integer.parseInt(split[1]);
         }

         if (split[0].equals("ShellDelay")) {
            this.vehicleShellDelay = Integer.parseInt(split[1]);
         }

         if (split[0].equals("ShootSound")) {
            this.shootSoundPrimary = split[1];
            FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
         }

         if (split[0].equals("ShellSound")) {
            this.shootSoundSecondary = split[1];
            FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
         } else if (split[0].equals("DriftSoundLength")) {
            this.driftSoundLength = Integer.parseInt(split[1]);
         } else if (split[0].equals("DriftSound")) {
            this.driftSound = split[1];
            FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
         }

         if (split[0].equalsIgnoreCase("AddSmokePoint") || split[0].equalsIgnoreCase("AddSmokeDispenser")) {
            VehicleType.SmokePoint smoke = new VehicleType.SmokePoint();
            smoke.position = new Vector3f(split[1], this.shortName);
            smoke.direction = new Vector3f(split[2], this.shortName);
            smoke.detTime = Integer.parseInt(split[3]);
            smoke.part = split[4];
            this.smokers.add(smoke);
         }
      } catch (Exception var4) {
      }

   }

   public static VehicleType getVehicle(String find) {
      Iterator var1 = types.iterator();

      VehicleType type;
      do {
         if (!var1.hasNext()) {
            return null;
         }

         type = (VehicleType)var1.next();
      } while(!type.shortName.equals(find));

      return type;
   }

   public void reloadModel() {
      this.model = (ModelDriveable)FlansMod.proxy.loadModel(this.modelString, this.shortName, ModelVehicle.class);
   }

   public class SmokePoint {
      public Vector3f position;
      public Vector3f direction;
      public int detTime;
      public String part;
   }
}
