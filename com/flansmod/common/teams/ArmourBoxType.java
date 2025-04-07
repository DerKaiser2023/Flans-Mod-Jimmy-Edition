package com.flansmod.common.teams;

import com.flansmod.common.FlansMod;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.types.TypeFile;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashMap;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ArmourBoxType extends InfoType {
   public String topTexturePath;
   public String sideTexturePath;
   public String bottomTexturePath;
   @SideOnly(Side.CLIENT)
   public IIcon top;
   @SideOnly(Side.CLIENT)
   public IIcon side;
   @SideOnly(Side.CLIENT)
   public IIcon bottom;
   public BlockArmourBox block;
   public ArrayList<ArmourBoxType.ArmourBoxEntry> pages = new ArrayList();
   public static HashMap<String, ArmourBoxType> boxes = new HashMap();

   public ArmourBoxType(TypeFile file) {
      super(file);
   }

   public void preRead(TypeFile file) {
   }

   public void postRead(TypeFile file) {
      boxes.put(this.shortName, this);
   }

   protected void read(String[] split, TypeFile file) {
      super.read(split, file);

      try {
         if (split[0].equals("TopTexture")) {
            this.topTexturePath = split[1];
         }

         if (split[0].equals("BottomTexture")) {
            this.bottomTexturePath = split[1];
         }

         if (split[0].equals("SideTexture")) {
            this.sideTexturePath = split[1];
         }

         if (split[0].toLowerCase().equals("addarmour") || split[0].toLowerCase().equals("addarmor")) {
            String name = split[2];

            for(int i = 3; i < split.length; ++i) {
               name = name + " " + split[i];
            }

            ArmourBoxType.ArmourBoxEntry entry = new ArmourBoxType.ArmourBoxEntry(split[1], name);

            for(int i = 0; i < 4; ++i) {
               String line = null;
               line = file.readLine();
               if (line != null) {
                  if (line.startsWith("//")) {
                     --i;
                  } else {
                     String[] lineSplit = line.split(" ");
                     entry.armours[i] = ArmourType.getArmourType(lineSplit[0]);

                     for(int j = 0; j < (lineSplit.length - 1) / 2; ++j) {
                        ItemStack stack = null;
                        if (lineSplit[j * 2 + 1].contains(".")) {
                           stack = getRecipeElement(lineSplit[j * 2 + 1].split("\\.")[0], Integer.valueOf(lineSplit[j * 2 + 2]), Integer.valueOf(lineSplit[j * 2 + 1].split("\\.")[1]), this.shortName);
                        } else {
                           stack = getRecipeElement(lineSplit[j * 2 + 1], Integer.valueOf(lineSplit[j * 2 + 2]), 0, this.shortName);
                        }

                        if (stack != null) {
                           entry.requiredStacks[i].add(stack);
                        }
                     }
                  }
               }
            }

            this.pages.add(entry);
         }
      } catch (Exception var10) {
         FlansMod.log("Reading gun box file failed : " + this.shortName);
         var10.printStackTrace();
      }

   }

   public static ArmourBoxType getBox(String boxShortName) {
      return (ArmourBoxType)boxes.get(boxShortName);
   }

   public float GetRecommendedScale() {
      return 50.0F;
   }

   @SideOnly(Side.CLIENT)
   public ModelBase GetModel() {
      return null;
   }

   public class ArmourBoxEntry {
      public String shortName;
      public String name = "";
      public ArmourType[] armours;
      public ArrayList<ItemStack>[] requiredStacks;

      public ArmourBoxEntry(String s, String s1) {
         this.shortName = s;
         this.name = s1;
         this.armours = new ArmourType[4];
         this.requiredStacks = new ArrayList[4];

         for(int i = 0; i < 4; ++i) {
            this.requiredStacks[i] = new ArrayList();
         }

      }
   }
}
