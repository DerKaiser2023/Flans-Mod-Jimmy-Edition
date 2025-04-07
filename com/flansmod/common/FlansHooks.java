package com.flansmod.common;

import cpw.mods.fml.common.Loader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FlansHooks {
   public Class BuildCraftEnergy;
   public ItemStack BuildCraftFuelBucket;
   public ItemStack BuildCraftOilBucket;
   public boolean BuildCraftLoaded;

   public void hook() {
      if (Loader.isModLoaded("BuildCraft|Energy")) {
         this.BuildCraftFuelBucket = this.getBuildCraftItem("bucketFuel");
         this.BuildCraftOilBucket = this.getBuildCraftItem("bucketOil");
         System.out.println("[Flan] BuildCraft integration loaded.");
         this.BuildCraftLoaded = true;
      }

   }

   public ItemStack getBuildCraftItem(String name) {
      try {
         if (this.BuildCraftEnergy == null) {
            this.BuildCraftEnergy = Class.forName("buildcraft.BuildCraftEnergy");
         }

         if (this.BuildCraftEnergy == null) {
            this.BuildCraftEnergy = Class.forName("net.minecraft.src.buildcraft.BuildCraftEnergy");
         }

         Object ret = this.BuildCraftEnergy.getField(name).get((Object)null);
         if (ret instanceof Item) {
            return new ItemStack((Item)ret);
         } else {
            throw new Exception();
         }
      } catch (Exception var3) {
         System.out.println("[Flan] Unable to retrieve BuildCraft item " + name + ".");
         return null;
      }
   }
}
