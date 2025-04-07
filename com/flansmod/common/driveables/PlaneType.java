package com.flansmod.common.driveables;

import com.flansmod.client.model.ModelDriveable;
import com.flansmod.client.model.ModelPlane;
import com.flansmod.common.FlansMod;
import com.flansmod.common.parts.PartType;
import com.flansmod.common.types.TypeFile;
import com.flansmod.common.vector.Vector3f;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.item.ItemStack;

public class PlaneType extends DriveableType {
   public EnumPlaneMode mode;
   public float lookDownModifier;
   public float lookUpModifier;
   public float rollLeftModifier;
   public float rollRightModifier;
   public float turnLeftModifier;
   public float turnRightModifier;
   public float lift;
   public Vector3f bombPosition;
   public int planeShootDelay;
   public int planeBombDelay;
   public float ceiling;
   public Vector3f wingPos1;
   public Vector3f wingPos2;
   public Vector3f wingRot1;
   public Vector3f wingRot2;
   public Vector3f wingRate;
   public Vector3f wingRotRate;
   public Vector3f wingWheelPos1;
   public Vector3f wingWheelPos2;
   public Vector3f wingWheelRot1;
   public Vector3f wingWheelRot2;
   public Vector3f wingWheelRate;
   public Vector3f wingWheelRotRate;
   public Vector3f bodyWheelPos1;
   public Vector3f bodyWheelPos2;
   public Vector3f bodyWheelRot1;
   public Vector3f bodyWheelRot2;
   public Vector3f bodyWheelRate;
   public Vector3f bodyWheelRotRate;
   public Vector3f tailWheelPos1;
   public Vector3f tailWheelPos2;
   public Vector3f tailWheelRot1;
   public Vector3f tailWheelRot2;
   public Vector3f tailWheelRate;
   public Vector3f tailWheelRotRate;
   public Vector3f doorPos1;
   public Vector3f doorPos2;
   public Vector3f doorRot1;
   public Vector3f doorRot2;
   public Vector3f doorRate;
   public Vector3f doorRotRate;
   public ArrayList<Propeller> propellers;
   public ArrayList<Propeller> heliPropellers;
   public ArrayList<Propeller> heliTailPropellers;
   public boolean hasGear;
   public boolean hasDoor;
   public boolean hasWing;
   public boolean foldWingForLand;
   public boolean flyWithOpenDoor;
   public float restingPitch;
   public boolean spinWithoutTail;
   public boolean valkyrie;
   public boolean carrierLandable;
   public boolean helipadLandable;
   public float planeDiveFactor;
   public boolean invInflight;
   public static ArrayList<PlaneType> types = new ArrayList();

   public PlaneType(TypeFile file) {
      super(file);
      this.mode = EnumPlaneMode.PLANE;
      this.lookDownModifier = 1.0F;
      this.lookUpModifier = 1.0F;
      this.rollLeftModifier = 1.0F;
      this.rollRightModifier = 1.0F;
      this.turnLeftModifier = 1.0F;
      this.turnRightModifier = 1.0F;
      this.lift = 1.0F;
      this.ceiling = 800.0F;
      this.wingPos1 = new Vector3f(0.0F, 0.0F, 0.0F);
      this.wingPos2 = new Vector3f(0.0F, 0.0F, 0.0F);
      this.wingRot1 = new Vector3f(0.0F, 0.0F, 0.0F);
      this.wingRot2 = new Vector3f(0.0F, 0.0F, 0.0F);
      this.wingRate = new Vector3f(0.0F, 0.0F, 0.0F);
      this.wingRotRate = new Vector3f(0.0F, 0.0F, 0.0F);
      this.wingWheelPos1 = new Vector3f(0.0F, 0.0F, 0.0F);
      this.wingWheelPos2 = new Vector3f(0.0F, 0.0F, 0.0F);
      this.wingWheelRot1 = new Vector3f(0.0F, 0.0F, 0.0F);
      this.wingWheelRot2 = new Vector3f(0.0F, 0.0F, 0.0F);
      this.wingWheelRate = new Vector3f(0.0F, 0.0F, 0.0F);
      this.wingWheelRotRate = new Vector3f(0.0F, 0.0F, 0.0F);
      this.bodyWheelPos1 = new Vector3f(0.0F, 0.0F, 0.0F);
      this.bodyWheelPos2 = new Vector3f(0.0F, 0.0F, 0.0F);
      this.bodyWheelRot1 = new Vector3f(0.0F, 0.0F, 0.0F);
      this.bodyWheelRot2 = new Vector3f(0.0F, 0.0F, 0.0F);
      this.bodyWheelRate = new Vector3f(0.0F, 0.0F, 0.0F);
      this.bodyWheelRotRate = new Vector3f(0.0F, 0.0F, 0.0F);
      this.tailWheelPos1 = new Vector3f(0.0F, 0.0F, 0.0F);
      this.tailWheelPos2 = new Vector3f(0.0F, 0.0F, 0.0F);
      this.tailWheelRot1 = new Vector3f(0.0F, 0.0F, 0.0F);
      this.tailWheelRot2 = new Vector3f(0.0F, 0.0F, 0.0F);
      this.tailWheelRate = new Vector3f(0.0F, 0.0F, 0.0F);
      this.tailWheelRotRate = new Vector3f(0.0F, 0.0F, 0.0F);
      this.doorPos1 = new Vector3f(0.0F, 0.0F, 0.0F);
      this.doorPos2 = new Vector3f(0.0F, 0.0F, 0.0F);
      this.doorRot1 = new Vector3f(0.0F, 0.0F, 0.0F);
      this.doorRot2 = new Vector3f(0.0F, 0.0F, 0.0F);
      this.doorRate = new Vector3f(0.0F, 0.0F, 0.0F);
      this.doorRotRate = new Vector3f(0.0F, 0.0F, 0.0F);
      this.propellers = new ArrayList();
      this.heliPropellers = new ArrayList();
      this.heliTailPropellers = new ArrayList();
      this.hasGear = false;
      this.hasDoor = false;
      this.hasWing = false;
      this.foldWingForLand = false;
      this.flyWithOpenDoor = false;
      this.restingPitch = 0.0F;
      this.spinWithoutTail = false;
      this.valkyrie = false;
      this.carrierLandable = false;
      this.helipadLandable = false;
      this.planeDiveFactor = 0.5F;
      this.invInflight = true;
      types.add(this);
   }

   public void preRead(TypeFile file) {
      super.preRead(file);
   }

   protected void read(String[] split, TypeFile file) {
      super.read(split, file);

      try {
         if (split[0].equals("Mode")) {
            this.mode = EnumPlaneMode.getMode(split[1]);
         }

         if (split[0].equals("TurnLeftSpeed")) {
            this.turnLeftModifier = Float.parseFloat(split[1]);
         }

         if (split[0].equals("TurnRightSpeed")) {
            this.turnRightModifier = Float.parseFloat(split[1]);
         }

         if (split[0].equals("LookUpSpeed")) {
            this.lookUpModifier = Float.parseFloat(split[1]);
         }

         if (split[0].equals("LookDownSpeed")) {
            this.lookDownModifier = Float.parseFloat(split[1]);
         }

         if (split[0].equals("RollLeftSpeed")) {
            this.rollLeftModifier = Float.parseFloat(split[1]);
         }

         if (split[0].equals("RollRightSpeed")) {
            this.rollRightModifier = Float.parseFloat(split[1]);
         }

         if (split[0].equals("Lift")) {
            this.lift = Float.parseFloat(split[1]);
         }

         if (split[0].equals("ShootDelay")) {
            this.planeShootDelay = Integer.parseInt(split[1]);
         }

         if (split[0].equals("BombDelay")) {
            this.planeBombDelay = Integer.parseInt(split[1]);
         }

         if (split[0].equals("flightCeiling")) {
            this.ceiling = Float.parseFloat(split[1]);
         }

         if (split[0].equals("planeDiveFactor")) {
            this.planeDiveFactor = Float.parseFloat(split[1]);
         }

         if (split[0].equals("carrierLandable")) {
            this.carrierLandable = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("helipadLandable")) {
            this.helipadLandable = Boolean.parseBoolean(split[1]);
         }

         Propeller propeller;
         if (split[0].equals("Propeller")) {
            propeller = new Propeller(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), EnumDriveablePart.getPart(split[5]), PartType.getPart(split[6]));
            this.propellers.add(propeller);
            this.driveableRecipe.add(new ItemStack(propeller.itemType.item));
         }

         if (split[0].equals("HeliPropeller")) {
            propeller = new Propeller(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), EnumDriveablePart.getPart(split[5]), PartType.getPart(split[6]));
            this.heliPropellers.add(propeller);
            this.driveableRecipe.add(new ItemStack(propeller.itemType.item));
         }

         if (split[0].equals("HeliTailPropeller")) {
            propeller = new Propeller(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), EnumDriveablePart.getPart(split[5]), PartType.getPart(split[6]));
            this.heliTailPropellers.add(propeller);
            this.driveableRecipe.add(new ItemStack(propeller.itemType.item));
         }

         if (split[0].equals("HasFlare")) {
            this.hasFlare = split[1].equals("True");
         }

         if (split[0].equals("FlareDelay")) {
            this.flareDelay = Integer.parseInt(split[1]);
            if (this.flareDelay <= 0) {
               this.flareDelay = 1;
            }
         }

         if (split[0].equals("TimeFlareUsing")) {
            this.timeFlareUsing = Integer.parseInt(split[1]);
            if (this.timeFlareUsing <= 0) {
               this.timeFlareUsing = 1;
            }
         }

         if (split[0].equals("PropSoundLength")) {
            this.engineSoundLength = Integer.parseInt(split[1]);
         }

         if (split[0].equals("PropSound")) {
            this.engineSound = split[1];
            FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
         }

         if (split[0].equals("ShootSound")) {
            this.shootSoundPrimary = split[1];
            FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
         }

         if (split[0].equals("BombSound")) {
            this.shootSoundSecondary = split[1];
            FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
         }

         if (split[0].equals("HasGear")) {
            this.hasGear = split[1].equals("True");
         }

         if (split[0].equals("HasDoor")) {
            this.hasDoor = split[1].equals("True");
         }

         if (split[0].equals("HasWing")) {
            this.hasWing = split[1].equals("True");
         }

         if (split[0].equals("FoldWingForLand")) {
            this.foldWingForLand = split[1].equals("True");
         }

         if (split[0].equals("FlyWithOpenDoor")) {
            this.flyWithOpenDoor = split[1].equals("True");
         }

         if (split[0].equals("RestingPitch")) {
            this.restingPitch = Float.parseFloat(split[1]);
         }

         if (split[0].equals("SpinWithoutTail")) {
            this.spinWithoutTail = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("Valkyrie")) {
            this.valkyrie = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("WingPosition1")) {
            this.wingPos1 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("WingPosition2")) {
            this.wingPos2 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("WingRotation1")) {
            this.wingRot1 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("WingRotation2")) {
            this.wingRot2 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("WingRate")) {
            this.wingRate = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("WingRotRate")) {
            this.wingRotRate = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("WingWheelPosition1")) {
            this.wingWheelPos1 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("WingWheelPosition2")) {
            this.wingWheelPos2 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("WingWheelRotation1")) {
            this.wingWheelRot1 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("WingWheelRotation2")) {
            this.wingWheelRot2 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("WingWheelRate")) {
            this.wingWheelRate = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("WingWheelRotRate")) {
            this.wingWheelRotRate = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("BodyWheelPosition1")) {
            this.bodyWheelPos1 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("BodyWheelPosition2")) {
            this.bodyWheelPos2 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("BodyWheelRotation1")) {
            this.bodyWheelRot1 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("BodyWheelRotation2")) {
            this.bodyWheelRot2 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("BodyWheelRate")) {
            this.bodyWheelRate = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("BodyWheelRotRate")) {
            this.bodyWheelRotRate = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("TailWheelPosition1")) {
            this.tailWheelPos1 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("TailWheelPosition2")) {
            this.tailWheelPos2 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("TailWheelRotation1")) {
            this.tailWheelRot1 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("TailWheelRotation2")) {
            this.tailWheelRot2 = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("TailWheelRate")) {
            this.tailWheelRate = new Vector3f(split[1], this.shortName);
         }

         if (split[0].equals("TailWheelRotRate")) {
            this.tailWheelRotRate = new Vector3f(split[1], this.shortName);
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

         if (split[0].equals("InflightInventory")) {
            this.invInflight = split[1].equals("False");
         }
      } catch (Exception var4) {
      }

   }

   public int numEngines() {
      switch(this.mode) {
      case VTOL:
         return Math.max(this.propellers.size(), this.heliPropellers.size());
      case PLANE:
         return this.propellers.size();
      case HELI:
         return this.heliPropellers.size();
      default:
         return 1;
      }
   }

   public ArrayList<ItemStack> getItemsRequired(DriveablePart part, PartType engine) {
      ArrayList<ItemStack> stacks = super.getItemsRequired(part, engine);
      Iterator var4 = this.propellers.iterator();

      while(var4.hasNext()) {
         Propeller propeller = (Propeller)var4.next();
         if (propeller.planePart == part.type) {
            stacks.add(new ItemStack(propeller.itemType.item));
            stacks.add(new ItemStack(engine.item));
         }
      }

      return stacks;
   }

   public static PlaneType getPlane(String find) {
      Iterator var1 = types.iterator();

      PlaneType type;
      do {
         if (!var1.hasNext()) {
            return null;
         }

         type = (PlaneType)var1.next();
      } while(!type.shortName.equals(find));

      return type;
   }

   public void reloadModel() {
      this.model = (ModelDriveable)FlansMod.proxy.loadModel(this.modelString, this.shortName, ModelPlane.class);
   }
}
