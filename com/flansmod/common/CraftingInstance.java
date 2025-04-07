package com.flansmod.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class CraftingInstance {
   public IInventory inventory;
   public List<ItemStack> requiredStacks;
   public List<ItemStack> outputStacks;
   public boolean craftingSuccessful;

   public CraftingInstance(IInventory i, List<ItemStack> in, List<ItemStack> out) {
      this.inventory = i;
      this.requiredStacks = in;
      this.outputStacks = out;
   }

   public CraftingInstance(IInventory i, ArrayList<ItemStack> in, ItemStack out) {
      this(i, (List)in, (List)Arrays.asList(out));
   }

   public boolean canCraft() {
      this.craftingSuccessful = true;
      Iterator var1 = this.requiredStacks.iterator();

      while(var1.hasNext()) {
         ItemStack check = (ItemStack)var1.next();
         int numMatchingStuff = 0;

         for(int j = 0; j < this.inventory.func_70302_i_(); ++j) {
            ItemStack stack = this.inventory.func_70301_a(j);
            if (stack != null && stack.func_77973_b() == check.func_77973_b() && stack.func_77960_j() == check.func_77960_j()) {
               numMatchingStuff += stack.field_77994_a;
            }
         }

         if (numMatchingStuff < check.field_77994_a) {
            this.craftingSuccessful = false;
         }
      }

      return this.craftingSuccessful;
   }

   public void craft(EntityPlayer player) {
      if (this.craftingSuccessful) {
         Iterator var2 = this.requiredStacks.iterator();

         ItemStack stack;
         while(var2.hasNext()) {
            stack = (ItemStack)var2.next();
            int amountLeft = stack.field_77994_a;

            for(int j = 0; j < this.inventory.func_70302_i_(); ++j) {
               ItemStack stack = this.inventory.func_70301_a(j);
               if (amountLeft > 0 && stack != null && stack.func_77973_b() == stack.func_77973_b() && stack.func_77960_j() == stack.func_77960_j()) {
                  amountLeft -= this.inventory.func_70298_a(j, amountLeft).field_77994_a;
               }
            }
         }

         var2 = this.outputStacks.iterator();

         while(var2.hasNext()) {
            stack = (ItemStack)var2.next();
            if (!player.field_71071_by.func_70441_a(stack)) {
               player.func_71019_a(stack, false);
            }
         }

      }
   }
}
