package com.flansmod.common.guns.boxes;

import com.flansmod.common.FlansMod;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.types.TypeFile;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class GunBoxType extends InfoType {
   public BlockGunBox block;
   public String topTexturePath;
   public String sideTexturePath;
   public String bottomTexturePath;
   @SideOnly(Side.CLIENT)
   public IIcon top;
   @SideOnly(Side.CLIENT)
   public IIcon side;
   @SideOnly(Side.CLIENT)
   public IIcon bottom;
   public int nextGun = -1;
   public GunBoxEntry[] gunEntries;
   public List<GunPage> gunPages = new ArrayList();
   public GunPage currentPage;
   public String guiTexturePath;
   public String gunBoxTextColor = "404040";
   public String itemListTextColor = "404040";
   public String itemTextColor = "404040";
   public String pageTextColor = "FFFFFF";
   public String buttonTextColor = "FFFFFF";
   public String buttonTextHoverColor = "FFFFA0";
   private static int lastIconIndex = 2;
   public static HashMap<String, GunBoxType> gunBoxMap = new HashMap();

   public GunBoxType(TypeFile file) {
      super(file);
   }

   public void preRead(TypeFile file) {
      this.gunEntries = new GunBoxEntry[8];
      this.currentPage = new GunPage("default");
   }

   public void postRead(TypeFile file) {
      this.currentPage.addGunList((GunBoxEntry[])Arrays.copyOf(this.gunEntries, this.nextGun + 1));
      this.gunPages.add(this.currentPage);
      gunBoxMap.put(this.shortName, this);
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

         if (split[0].equals("Page") || split[0].equals("SetPage")) {
            String pageName = String.join(" ", (CharSequence[])Arrays.copyOfRange(split, 1, split.length));
            if (this.gunEntries[0] != null) {
               this.currentPage.addGunList((GunBoxEntry[])Arrays.copyOf(this.gunEntries, this.nextGun + 1));
               this.iteratePage(pageName);
            } else {
               this.currentPage.setPageName(pageName);
            }
         }

         if (split[0].equals("AddGun")) {
            ++this.nextGun;
            if (this.nextGun > this.gunEntries.length - 1) {
               this.currentPage.addGunList((GunBoxEntry[])Arrays.copyOf(this.gunEntries, this.nextGun));
               this.iteratePage("default " + (this.gunPages.size() + 2));
               ++this.nextGun;
            }

            this.gunEntries[this.nextGun] = new GunBoxEntry(InfoType.getType(split[1]), this.getRecipe(split));
         }

         if (split[0].equals("AddAmmo") || split[0].equals("AddAltAmmo") || split[0].equals("AddAlternateAmmo")) {
            this.gunEntries[this.nextGun].addAmmoEntry(new GunBoxEntry(InfoType.getType(split[1]), this.getRecipe(split)));
         }

         if (split[0].equals("GuiTexture")) {
            this.guiTexturePath = split[1];
         }

         if (split[0].equals("GunBoxNameColor")) {
            this.gunBoxTextColor = split[1];
         }

         if (split[0].equals("PageTextColor")) {
            this.pageTextColor = split[1];
         }

         if (split[0].equals("ListTextColor")) {
            this.itemListTextColor = split[1];
         }

         if (split[0].equals("ItemTextColor")) {
            this.itemTextColor = split[1];
         }

         if (split[0].equals("ButtonTextColor")) {
            this.buttonTextColor = split[1];
         }

         if (split[0].equals("ButtonTextHighlight")) {
            this.buttonTextHoverColor = split[1];
         }
      } catch (Exception var4) {
         FlansMod.log("Reading gun box file failed : " + this.shortName);
         var4.printStackTrace();
      }

   }

   public void iteratePage(String s) {
      this.gunPages.add(this.currentPage);
      this.gunEntries = new GunBoxEntry[8];
      this.nextGun = -1;
      this.currentPage = new GunPage(s);
   }

   public static GunBoxType getBox(String s) {
      return (GunBoxType)gunBoxMap.get(s);
   }

   public static GunBoxType getBox(Block block) {
      Iterator var1 = gunBoxMap.values().iterator();

      GunBoxType type;
      do {
         if (!var1.hasNext()) {
            return null;
         }

         type = (GunBoxType)var1.next();
      } while(type.block != block);

      return type;
   }

   public List<ItemStack> getRecipe(String[] split) {
      List<ItemStack> recipe = new ArrayList();

      for(int i = 0; i < (split.length - 2) / 2; ++i) {
         if (split[i * 2 + 3].contains(".")) {
            recipe.add(getRecipeElement(split[i * 2 + 3].split("\\.")[0], Integer.parseInt(split[i * 2 + 2]), Integer.valueOf(split[i * 2 + 3].split("\\.")[1]), this.shortName));
         } else {
            recipe.add(getRecipeElement(split[i * 2 + 3], Integer.parseInt(split[i * 2 + 2]), 0, this.shortName));
         }
      }

      return recipe;
   }

   public void addRecipe(Item par1Item) {
      if (this.smeltableFrom != null) {
         GameRegistry.addSmelting(getRecipeElement(this.smeltableFrom, 0), new ItemStack(this.item), 0.0F);
      }

      if (this.recipeLine != null) {
         Object[] newRecipe;
         try {
            int rows;
            if (!this.shapeless) {
               rows = 3;
               int i;
               if (((String)this.recipe[0]).charAt(0) == ' ' && ((String)this.recipe[1]).charAt(0) == ' ' && ((String)this.recipe[2]).charAt(0) == ' ') {
                  for(i = 0; i < 3; ++i) {
                     this.recipe[i] = ((String)this.recipe[i]).substring(1);
                  }

                  if (((String)this.recipe[0]).charAt(0) == ' ' && ((String)this.recipe[1]).charAt(0) == ' ' && ((String)this.recipe[2]).charAt(0) == ' ') {
                     for(i = 0; i < 3; ++i) {
                        this.recipe[i] = ((String)this.recipe[i]).substring(1);
                     }
                  }
               }

               i = ((String)this.recipe[0]).length() - 1;
               int i;
               if (((String)this.recipe[0]).charAt(i) == ' ' && ((String)this.recipe[1]).charAt(i) == ' ' && ((String)this.recipe[2]).charAt(i) == ' ') {
                  for(i = 0; i < 3; ++i) {
                     this.recipe[i] = ((String)this.recipe[i]).substring(0, i);
                  }

                  --i;
                  if (((String)this.recipe[0]).charAt(i) == ' ' && ((String)this.recipe[1]).charAt(i) == ' ' && ((String)this.recipe[2]).charAt(i) == ' ') {
                     for(i = 0; i < 3; ++i) {
                        this.recipe[i] = ((String)this.recipe[i]).substring(0, 0);
                     }
                  }
               }

               Object[] newRecipe1;
               if (this.recipe[0].equals(" ") || this.recipe[0].equals("  ") || this.recipe[0].equals("   ")) {
                  newRecipe = new Object[this.recipe.length - 1];
                  newRecipe[0] = this.recipe[1];
                  newRecipe[1] = this.recipe[2];
                  this.recipe = newRecipe;
                  --rows;
                  if (this.recipe[0].equals(" ") || this.recipe[0].equals("  ") || this.recipe[0].equals("   ")) {
                     newRecipe1 = new Object[this.recipe.length - 1];
                     newRecipe1[0] = this.recipe[1];
                     this.recipe = newRecipe1;
                     --rows;
                  }
               }

               if (this.recipe[rows - 1].equals(" ") || this.recipe[rows - 1].equals("  ") || this.recipe[rows - 1].equals("   ")) {
                  newRecipe = new Object[this.recipe.length - 1];
                  newRecipe[0] = this.recipe[0];
                  newRecipe[1] = this.recipe[1];
                  this.recipe = newRecipe;
                  --rows;
                  if (this.recipe[rows - 1].equals(" ") || this.recipe[rows - 1].equals("  ") || this.recipe[rows - 1].equals("   ")) {
                     newRecipe1 = new Object[this.recipe.length - 1];
                     newRecipe1[0] = this.recipe[0];
                     this.recipe = newRecipe1;
                     --rows;
                  }
               }

               for(i = 0; i < (this.recipeLine.length - 1) / 2; ++i) {
                  this.recipe[i * 2 + rows] = this.recipeLine[i * 2 + 1].charAt(0);
                  if (this.recipeLine[i * 2 + 2].contains(".")) {
                     this.recipe[i * 2 + rows + 1] = getRecipeElement(this.recipeLine[i * 2 + 2].split("\\.")[0], Integer.valueOf(this.recipeLine[i * 2 + 2].split("\\.")[1]));
                  } else {
                     this.recipe[i * 2 + rows + 1] = getRecipeElement(this.recipeLine[i * 2 + 2], 0);
                  }
               }

               GameRegistry.addRecipe(new ItemStack(this.block, this.recipeOutput, 0), this.recipe);
            } else {
               this.recipe = new Object[this.recipeLine.length - 1];

               for(rows = 0; rows < this.recipeLine.length - 1; ++rows) {
                  if (this.recipeLine[rows + 1].contains(".")) {
                     this.recipe[rows] = getRecipeElement(this.recipeLine[rows + 1].split("\\.")[0], Integer.valueOf(this.recipeLine[rows + 1].split("\\.")[1]));
                  } else {
                     this.recipe[rows] = getRecipeElement(this.recipeLine[rows + 1], 0);
                  }
               }

               GameRegistry.addShapelessRecipe(new ItemStack(this.block, this.recipeOutput, 0), this.recipe);
            }
         } catch (Exception var8) {
            if (this.recipe == null) {
               FlansMod.log("Failed to add recipe for : " + this.shortName);
            } else {
               String msg = " : ";
               newRecipe = this.recipe;
               int var5 = newRecipe.length;

               for(int var6 = 0; var6 < var5; ++var6) {
                  Object o = newRecipe[var6];
                  msg = msg + " " + o;
               }

               FlansMod.log("Failed to add recipe for : " + this.shortName + msg);
            }

            if (FlansMod.printStackTrace) {
               var8.printStackTrace();
            }
         }

      }
   }

   public float GetRecommendedScale() {
      return 50.0F;
   }

   @SideOnly(Side.CLIENT)
   public ModelBase GetModel() {
      return null;
   }
}
