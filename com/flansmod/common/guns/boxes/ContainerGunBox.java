package com.flansmod.common.guns.boxes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerGunBox extends Container {
   public InventoryPlayer playerInv;
   public World world;

   public ContainerGunBox(InventoryPlayer i, World w) {
      this.playerInv = i;
      this.world = w;

      int col;
      for(col = 0; col < 3; ++col) {
         for(int col = 0; col < 9; ++col) {
            this.func_75146_a(new Slot(i, col + col * 9 + 9, 57 + col * 18, 151 + col * 18));
         }
      }

      for(col = 0; col < 9; ++col) {
         this.func_75146_a(new Slot(i, col, 57 + col * 18, 209));
      }

   }

   public boolean func_75145_c(EntityPlayer entityplayer) {
      return true;
   }

   public ItemStack func_82846_b(EntityPlayer player, int slotID) {
      ItemStack stack = null;
      Slot currentSlot = (Slot)this.field_75151_b.get(slotID);
      if (currentSlot != null && currentSlot.func_75216_d()) {
         ItemStack slotStack = currentSlot.func_75211_c();
         stack = slotStack.func_77946_l();
         if (slotID != 0) {
            if (!this.func_75135_a(slotStack, 0, 1, false)) {
               return null;
            }
         } else if (!this.func_75135_a(slotStack, 1, this.field_75151_b.size(), true)) {
            return null;
         }

         if (slotStack.field_77994_a == 0) {
            currentSlot.func_75215_d((ItemStack)null);
         } else {
            currentSlot.func_75218_e();
         }

         if (slotStack.field_77994_a == stack.field_77994_a) {
            return null;
         }

         currentSlot.func_82870_a(player, slotStack);
      }

      return stack;
   }
}
