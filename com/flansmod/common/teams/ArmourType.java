package com.flansmod.common.teams;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.common.FlansMod;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.types.TypeFile;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.model.ModelBase;

public class ArmourType extends InfoType {
   public static ArrayList<ArmourType> armours = new ArrayList();
   public int type;
   public double defence;
   public String armourTextureName;
   public float moveSpeedModifier = 1.0F;
   public float knockbackModifier = 0.2F;
   public float jumpModifier = 1.0F;
   public boolean nightVision = false;
   public boolean invisible = false;
   public String overlay = null;
   public boolean smokeProtection = false;
   public boolean negateFallDamage = false;
   public boolean fireResistance = false;
   public boolean waterBreathing = false;
   public boolean onWaterWalking = false;
   public boolean regenerate = false;
   public boolean hunger = false;
   public boolean submarine = false;
   public int maxDamage = 9000;
   public int durability = 0;
   @SideOnly(Side.CLIENT)
   public ModelCustomArmour model;

   public ArmourType(TypeFile file) {
      super(file);
      armours.add(this);
   }

   protected void preRead(TypeFile file) {
   }

   protected void postRead(TypeFile file) {
   }

   protected void read(String[] split, TypeFile file) {
      super.read(split, file);

      try {
         if (FMLCommonHandler.instance().getSide().isClient() && split[0].equals("Model")) {
            this.model = (ModelCustomArmour)FlansMod.proxy.loadModel(split[1], this.shortName, ModelCustomArmour.class);
            this.model.type = this;
         }

         if (split[0].equals("Type")) {
            if (split[1].equals("Hat") || split[1].equals("Helmet")) {
               this.type = 0;
            }

            if (split[1].equals("Chest") || split[1].equals("Body")) {
               this.type = 1;
            }

            if (split[1].equals("Legs") || split[1].equals("Pants")) {
               this.type = 2;
            }

            if (split[1].equals("Shoes") || split[1].equals("Boots")) {
               this.type = 3;
            }
         }

         if (split[0].equals("DamageReduction") || split[0].equals("Defence")) {
            this.defence = Double.parseDouble(split[1]);
         }

         if (split[0].equals("MoveSpeedModifier") || split[0].equals("Slowness")) {
            this.moveSpeedModifier = Float.parseFloat(split[1]);
         }

         if (split[0].equals("JumpModifier")) {
            this.jumpModifier = Float.parseFloat(split[1]);
         }

         if (split[0].equals("KnockbackReduction") || split[0].equals("KnockbackModifier")) {
            this.knockbackModifier = Float.parseFloat(split[1]);
         }

         if (split[0].equals("NightVision")) {
            this.nightVision = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("Invisible")) {
            this.invisible = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("NegateFallDamage")) {
            this.negateFallDamage = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("FireResistance")) {
            this.fireResistance = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("WaterBreathing")) {
            this.waterBreathing = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("Overlay")) {
            this.overlay = split[1];
         }

         if (split[0].equals("SmokeProtection")) {
            this.smokeProtection = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("OnWaterWalking")) {
            this.onWaterWalking = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("submarine")) {
            this.submarine = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("regenerate")) {
            this.regenerate = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("hunger")) {
            this.hunger = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("Durability")) {
            this.durability = Integer.parseInt(split[1]);
         }

         if (split[0].equals("damageLimit")) {
            this.maxDamage = Integer.parseInt(split[1]);
         }

         if (split[0].equals("ArmourTexture") || split[0].equals("ArmorTexture")) {
            this.armourTextureName = split[1];
         }
      } catch (Exception var4) {
         System.out.println("Reading armour file failed.");
         if (FlansMod.printStackTrace) {
            var4.printStackTrace();
         }
      }

   }

   public static ArmourType getArmourType(String string) {
      Iterator var1 = armours.iterator();

      ArmourType armour;
      do {
         if (!var1.hasNext()) {
            return null;
         }

         armour = (ArmourType)var1.next();
      } while(!armour.shortName.equals(string));

      return armour;
   }

   public void reloadModel() {
      this.model = (ModelCustomArmour)FlansMod.proxy.loadModel(this.modelString, this.shortName, ModelCustomArmour.class);
      if (this.model != null) {
         this.model.type = this;
      }

   }

   public float GetRecommendedScale() {
      return 50.0F;
   }

   @SideOnly(Side.CLIENT)
   public ModelBase GetModel() {
      return this.model;
   }
}
