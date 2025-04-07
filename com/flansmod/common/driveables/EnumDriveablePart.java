package com.flansmod.common.driveables;

import java.util.ArrayList;

public enum EnumDriveablePart {
   tailWheel(new EnumDriveablePart[0], "tailWheel", "Wheel (Tail)"),
   tail(new EnumDriveablePart[]{tailWheel}, "tail", "Tail"),
   bay(new EnumDriveablePart[]{tail}, "bay", "Bay"),
   topWing(new EnumDriveablePart[0], "topWing", "Top Wing"),
   leftWingWheel(new EnumDriveablePart[0], "leftWingWheel", "Wheel (Left Wing)"),
   leftWing(new EnumDriveablePart[]{topWing, leftWingWheel}, "leftWing", "Left Wing"),
   rightWingWheel(new EnumDriveablePart[0], "rightWingWheel", "Wheel (Right Wing)"),
   rightWing(new EnumDriveablePart[]{topWing, rightWingWheel}, "rightWing", "Right Wing"),
   nose(new EnumDriveablePart[0], "nose", "Nose"),
   coreWheel(new EnumDriveablePart[0], "coreWheel", "Wheel (Core)"),
   skids(new EnumDriveablePart[0], "skids", "Skids"),
   blades(new EnumDriveablePart[0], "blades", "Blades"),
   turret(new EnumDriveablePart[0], "turret", "Turret"),
   backWheel(new EnumDriveablePart[0], "backWheel", "Back Wheel"),
   frontWheel(new EnumDriveablePart[0], "frontWheel", "Front Wheel"),
   backLeftWheel(new EnumDriveablePart[0], "backLeftWheel", "Back Left Wheel"),
   frontLeftWheel(new EnumDriveablePart[0], "frontLeftWheel", "Front Left Wheel"),
   backRightWheel(new EnumDriveablePart[0], "backRightWheel", "Back Right Wheel"),
   frontRightWheel(new EnumDriveablePart[0], "frontRightWheel", "Front Right Wheel"),
   leftTrack(new EnumDriveablePart[0], "leftTrack", "Left Track"),
   rightTrack(new EnumDriveablePart[0], "rightTrack", "Right Track"),
   trailer(new EnumDriveablePart[0], "trailer", "AdditionArmor"),
   harvester(new EnumDriveablePart[0], "harvester", "Harvester"),
   frontalArmor(new EnumDriveablePart[0], "frontalArmor", "Frontal Armor"),
   leftsideArmor(new EnumDriveablePart[0], "leftsideArmor", "Left Side Armor"),
   rightsideArmor(new EnumDriveablePart[0], "rightsideArmor", "Right Side Armor"),
   additionalArmor(new EnumDriveablePart[0], "additionalArmor", "Additional Armor"),
   ERA(new EnumDriveablePart[0], "ERA", "ERA"),
   APS(new EnumDriveablePart[0], "APS", "APS"),
   ADS(new EnumDriveablePart[0], "ADS", "ADS"),
   composite(new EnumDriveablePart[0], "composite", "Composite Armor Layer"),
   composite2(new EnumDriveablePart[0], "composite2", "Additional Composite Armor Layer"),
   spaced(new EnumDriveablePart[0], "spaced", "Spaced Armor"),
   compositeL(new EnumDriveablePart[0], "compositeL", "Left Composite Armor Layer"),
   compositeR(new EnumDriveablePart[0], "compositeR", "Right Composite Armor Layer"),
   generic0(new EnumDriveablePart[0], "generic0", "Extra Armor"),
   generic1(new EnumDriveablePart[0], "generic1", "Extra Armor 1"),
   generic2(new EnumDriveablePart[0], "generic2", "Extra Armor 2"),
   generic3(new EnumDriveablePart[0], "generic3", "Extra Armor 3"),
   generic4(new EnumDriveablePart[0], "generic4", "Extra Armor 4"),
   generic5(new EnumDriveablePart[0], "generic5", "Extra Armor 5"),
   generic6(new EnumDriveablePart[0], "generic6", "Extra Armor 6"),
   generic7(new EnumDriveablePart[0], "generic7", "Extra Armor 7"),
   generic8(new EnumDriveablePart[0], "generic8", "Extra Armor 8"),
   generic9(new EnumDriveablePart[0], "generic9", "Extra Armor 9"),
   bias(new EnumDriveablePart[0], "russianBias", "Stalinium"),
   bulge(new EnumDriveablePart[0], "bulge", "Torpedo Bulge"),
   bulgel(new EnumDriveablePart[0], "bulgel", "Left Torpedo Bulge"),
   bulger(new EnumDriveablePart[0], "bulger", "Right Torpedo Bulge"),
   superstructure(new EnumDriveablePart[0], "superstructure", "Super Structure"),
   bow(new EnumDriveablePart[0], "bow", "Bow"),
   stern(new EnumDriveablePart[0], "stern", "Stern"),
   midsection(new EnumDriveablePart[0], "midsection", "Midsection"),
   citadel(new EnumDriveablePart[0], "citadel", "Citadel"),
   belt(new EnumDriveablePart[0], "belt", "Armor Belt"),
   beltl(new EnumDriveablePart[0], "beltl", "Left Armor Belt"),
   beltr(new EnumDriveablePart[0], "beltr", "Right Armor Belt"),
   deck(new EnumDriveablePart[0], "deck", "Deck"),
   ERA2(new EnumDriveablePart[0], "ERA2", "More ERA"),
   ERA3(new EnumDriveablePart[0], "ERA3", "Even More ERA"),
   infantry(new EnumDriveablePart[0], "infantry", "Meat Shield"),
   turretarmor(new EnumDriveablePart[0], "turretarmor", "Turret Armor"),
   moreturretarmor(new EnumDriveablePart[0], "moreturretarmor", "Turret Composite Armor"),
   airframe(new EnumDriveablePart[0], "airframe", "Air Frame"),
   gasbag(new EnumDriveablePart[0], "gasbag", "Gas Bag"),
   leftArm(new EnumDriveablePart[0], "leftArm", "Left Arm"),
   rightArm(new EnumDriveablePart[0], "rightArm", "Right Arm"),
   head(new EnumDriveablePart[0], "head", "Head"),
   hips(new EnumDriveablePart[0], "hips", "Hips"),
   barrel(new EnumDriveablePart[0], "barrel", "Barrel"),
   core(new EnumDriveablePart[]{bay, leftWing, rightWing, nose, turret, coreWheel, leftArm, rightArm, head, hips, blades, skids, backWheel, frontWheel, backLeftWheel, frontLeftWheel, backRightWheel, frontRightWheel, leftTrack, rightTrack, trailer, harvester, infantry}, "core", "Core");

   private String shortName;
   private String name;
   private EnumDriveablePart[] children;

   private EnumDriveablePart(EnumDriveablePart[] parts, String s, String s2) {
      this.children = parts;
      this.shortName = s;
      this.name = s2;
   }

   public EnumDriveablePart[] getChildren() {
      return this.children;
   }

   public EnumDriveablePart[] getParents() {
      ArrayList<EnumDriveablePart> parents = new ArrayList();
      EnumDriveablePart[] var2 = values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         EnumDriveablePart part = var2[var4];
         EnumDriveablePart[] var6 = part.getChildren();
         int var7 = var6.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            EnumDriveablePart childPart = var6[var8];
            if (childPart == this) {
               parents.add(part);
            }
         }
      }

      return (EnumDriveablePart[])parents.toArray(new EnumDriveablePart[parents.size()]);
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getName() {
      return this.name;
   }

   public static EnumDriveablePart getPart(String s) {
      EnumDriveablePart[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         EnumDriveablePart part = var1[var3];
         if (part.getShortName().equals(s)) {
            return part;
         }
      }

      return null;
   }

   public static boolean isWheel(EnumDriveablePart part) {
      return part == coreWheel || part == tailWheel || part == leftWingWheel || part == rightWingWheel;
   }
}
