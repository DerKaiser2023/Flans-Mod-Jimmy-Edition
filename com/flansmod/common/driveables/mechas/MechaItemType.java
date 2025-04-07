package com.flansmod.common.driveables.mechas;

import com.flansmod.client.model.ModelMechaTool;
import com.flansmod.common.FlansMod;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.types.TypeFile;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.model.ModelBase;

public class MechaItemType extends InfoType {
   public static ArrayList<MechaItemType> types = new ArrayList();
   public EnumMechaItemType type;
   public EnumMechaToolType function;
   public float speed;
   public float toolHardness;
   public float reach;
   public boolean floater;
   public float speedMultiplier;
   public float damageResistance;
   public String soundEffect;
   public String detectSound;
   public float soundTime;
   public int energyShield;
   public int lightLevel;
   public boolean stopMechaFallDamage;
   public boolean forceBlockFallDamage;
   public boolean vacuumItems;
   public boolean refineIron;
   public boolean autoCoal;
   public boolean autoRepair;
   public boolean rocketPack;
   public boolean diamondDetect;
   public boolean infiniteAmmo;
   public boolean forceDark;
   public boolean wasteCompact;
   public boolean flameBurst;
   public float fortuneDiamond;
   public float fortuneRedstone;
   public float fortuneCoal;
   public float fortuneEmerald;
   public float fortuneIron;
   public float rocketPower;
   @SideOnly(Side.CLIENT)
   public ModelMechaTool model;

   public MechaItemType(TypeFile file) {
      super(file);
      this.function = EnumMechaToolType.sword;
      this.speed = 1.0F;
      this.toolHardness = 1.0F;
      this.reach = 1.0F;
      this.floater = false;
      this.speedMultiplier = 1.0F;
      this.damageResistance = 0.0F;
      this.soundEffect = "";
      this.detectSound = "";
      this.soundTime = 0.0F;
      this.energyShield = 0;
      this.lightLevel = 0;
      this.stopMechaFallDamage = false;
      this.forceBlockFallDamage = false;
      this.vacuumItems = false;
      this.refineIron = false;
      this.autoCoal = false;
      this.autoRepair = false;
      this.rocketPack = false;
      this.diamondDetect = false;
      this.infiniteAmmo = false;
      this.forceDark = false;
      this.wasteCompact = false;
      this.flameBurst = false;
      this.fortuneDiamond = 1.0F;
      this.fortuneRedstone = 1.0F;
      this.fortuneCoal = 1.0F;
      this.fortuneEmerald = 1.0F;
      this.fortuneIron = 1.0F;
      this.rocketPower = 1.0F;
   }

   protected void preRead(TypeFile file) {
   }

   protected void postRead(TypeFile file) {
   }

   protected void read(String[] split, TypeFile file) {
      super.read(split, file);

      try {
         if (FMLCommonHandler.instance().getSide().isClient() && split[0].equals("Model")) {
            this.model = (ModelMechaTool)FlansMod.proxy.loadModel(split[1], this.shortName, ModelMechaTool.class);
         }

         if (split[0].equals("Texture")) {
            this.texture = split[1];
         }

         if (split[0].equals("Type")) {
            this.type = EnumMechaItemType.getToolType(split[1]);
         }

         if (split[0].equals("ToolType")) {
            this.function = EnumMechaToolType.getToolType(split[1]);
         }

         if (split[0].equals("Speed")) {
            this.speed = Float.parseFloat(split[1]);
         }

         if (split[0].equals("ToolHardness")) {
            this.toolHardness = Float.parseFloat(split[1]);
         }

         if (split[0].equals("Reach")) {
            this.reach = Float.parseFloat(split[1]);
         }

         if (split[0].equals("AutoFuel")) {
            this.autoCoal = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("Armour")) {
            this.damageResistance = Float.parseFloat(split[1]);
         }

         if (split[0].equals("CoalMultiplier")) {
            this.fortuneCoal = Float.parseFloat(split[1]);
         }

         if (split[0].equals("DetectSound")) {
            this.detectSound = split[1];
         }

         if (split[0].equals("DiamondDetect")) {
            this.diamondDetect = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("DiamondMultiplier")) {
            this.fortuneDiamond = Float.parseFloat(split[1]);
         }

         if (split[0].equals("EmeraldMultiplier")) {
            this.fortuneEmerald = Float.parseFloat(split[1]);
         }

         if (split[0].equals("FlameBurst")) {
            this.flameBurst = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("Floatation")) {
            this.floater = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("ForceBlockFallDamage")) {
            this.forceBlockFallDamage = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("ForceDark")) {
            this.forceDark = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("InfiniteAmmo")) {
            this.infiniteAmmo = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("IronMultiplier")) {
            this.fortuneIron = Float.parseFloat(split[1]);
         }

         if (split[0].equals("IronRefine")) {
            this.refineIron = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("ItemVacuum")) {
            this.vacuumItems = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("LightLevel")) {
            this.lightLevel = Integer.parseInt(split[1]);
         }

         if (split[0].equals("Nanorepair")) {
            this.autoRepair = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("RedstoneMultiplier")) {
            this.fortuneRedstone = Float.parseFloat(split[1]);
         }

         if (split[0].equals("RocketPack")) {
            this.rocketPack = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("RocketPower")) {
            this.rocketPower = Float.parseFloat(split[1]);
         }

         if (split[0].equals("SoundEffect")) {
            this.soundEffect = split[1];
         }

         if (split[0].equals("SoundTime")) {
            this.soundTime = Float.parseFloat(split[1]);
         }

         if (split[0].equals("SpeedMultiplier")) {
            this.speedMultiplier = Float.parseFloat(split[1]);
         }

         if (split[0].equals("StopMechaFallDamage")) {
            this.stopMechaFallDamage = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("WasteCompact")) {
            this.wasteCompact = Boolean.parseBoolean(split[1].toLowerCase());
         }
      } catch (Exception var4) {
      }

   }

   public static MechaItemType getTool(String find) {
      Iterator var1 = types.iterator();

      MechaItemType type;
      do {
         if (!var1.hasNext()) {
            return null;
         }

         type = (MechaItemType)var1.next();
      } while(!type.shortName.equals(find));

      return type;
   }

   public void reloadModel() {
      if (this.modelString != null) {
         this.model = (ModelMechaTool)FlansMod.proxy.loadModel(this.modelString, this.shortName, ModelMechaTool.class);
      }

   }

   public float GetRecommendedScale() {
      return 0.0F;
   }

   @SideOnly(Side.CLIENT)
   public ModelBase GetModel() {
      return null;
   }
}
