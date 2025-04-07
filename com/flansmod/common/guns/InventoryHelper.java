package com.flansmod.common.guns;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class InventoryHelper {
   public static boolean addItemStackToInventory(IInventory inventory, ItemStack stack, boolean creative) {
      if (stack == null) {
         return false;
      } else if (stack.field_77994_a == 0) {
         return false;
      } else {
         try {
            int i;
            if (stack.func_77951_h()) {
               i = getFirstEmptyStack(inventory);
               if (i >= 0) {
                  ItemStack stackToAdd = ItemStack.func_77944_b(stack);
                  stackToAdd.field_77992_b = 5;
                  inventory.func_70299_a(i, stackToAdd);
                  stack.field_77994_a = 0;
                  return true;
               } else if (creative) {
                  stack.field_77994_a = 0;
                  return true;
               } else {
                  return false;
               }
            } else {
               do {
                  i = stack.field_77994_a;
                  stack.field_77994_a = storePartialItemStack(inventory, stack);
               } while(stack.field_77994_a > 0 && stack.field_77994_a < i);

               if (stack.field_77994_a == i && creative) {
                  stack.field_77994_a = 0;
                  return true;
               } else {
                  return stack.field_77994_a < i;
               }
            }
         } catch (Throwable var5) {
            var5.printStackTrace();
            return false;
         }
      }
   }

   public static int storeItemStack(IInventory inventory, ItemStack stack) {
      for(int i = 0; i < inventory.func_70302_i_(); ++i) {
         ItemStack oldStack = inventory.func_70301_a(i);
         if (oldStack != null && oldStack.func_77973_b() == stack.func_77973_b() && oldStack.func_77985_e() && oldStack.field_77994_a < oldStack.func_77976_d() && oldStack.field_77994_a < inventory.func_70297_j_() && (!oldStack.func_77981_g() || oldStack.func_77960_j() == stack.func_77960_j()) && ItemStack.func_77970_a(oldStack, stack)) {
            return i;
         }
      }

      return -1;
   }

   public static int storePartialItemStack(IInventory inventory, ItemStack stack) {
      Item item = stack.func_77973_b();
      int j = stack.field_77994_a;
      int k;
      if (stack.func_77976_d() == 1) {
         k = getFirstEmptyStack(inventory);
         if (k < 0) {
            return j;
         } else {
            if (inventory.func_70301_a(k) == null) {
               inventory.func_70299_a(k, ItemStack.func_77944_b(stack));
            }

            return 0;
         }
      } else {
         k = storeItemStack(inventory, stack);
         if (k < 0) {
            k = getFirstEmptyStack(inventory);
         }

         if (k < 0) {
            return j;
         } else {
            ItemStack oldStack = inventory.func_70301_a(k);
            if (oldStack == null) {
               oldStack = new ItemStack(item, 0, stack.func_77960_j());
               if (stack.func_77942_o()) {
                  oldStack.func_77982_d((NBTTagCompound)stack.func_77978_p().func_74737_b());
               }

               inventory.func_70299_a(k, oldStack);
            }

            int l = j;
            if (j > oldStack.func_77976_d() - oldStack.field_77994_a) {
               l = oldStack.func_77976_d() - oldStack.field_77994_a;
            }

            if (l > inventory.func_70297_j_() - oldStack.field_77994_a) {
               l = inventory.func_70297_j_() - oldStack.field_77994_a;
            }

            if (l == 0) {
               return j;
            } else {
               j -= l;
               oldStack.field_77994_a += l;
               oldStack.field_77992_b = 5;
               return j;
            }
         }
      }
   }

   public static int getFirstEmptyStack(IInventory inventory) {
      for(int i = 0; i < inventory.func_70302_i_(); ++i) {
         if (inventory.func_70301_a(i) == null) {
            return i;
         }
      }

      return -1;
   }

   public static void dropInventoryItems(World worldIn, int x, int y, int z, IInventory tileentity) {
   }
}
