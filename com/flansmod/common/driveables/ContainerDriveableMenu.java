package com.flansmod.common.driveables;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerDriveableMenu extends Container {
   public EntityDriveable plane;
   public boolean isFuel;
   public InventoryPlayer inventory;
   public World world;

   public ContainerDriveableMenu(InventoryPlayer inventoryplayer, World worldy) {
      this(inventoryplayer, worldy, false, (EntityDriveable)null);
   }

   public ContainerDriveableMenu(InventoryPlayer inventoryplayer, World worldy, boolean fuel, EntityDriveable planey) {
      this.inventory = inventoryplayer;
      this.world = worldy;
      this.plane = planey;
      this.isFuel = fuel;
      if (this.isFuel) {
         this.func_75146_a(new Slot(this.plane.driveableData, this.plane.driveableData.getFuelSlot(), 35, 44));
      }

      int col;
      for(col = 0; col < 3; ++col) {
         for(int col = 0; col < 9; ++col) {
            this.func_75146_a(new Slot(inventoryplayer, col + col * 9 + 9, 8 + col * 18, 79 + (this.isFuel ? 0 : 19) + col * 18));
         }
      }

      for(col = 0; col < 9; ++col) {
         this.func_75146_a(new Slot(inventoryplayer, col, 8 + col * 18, 137 + (this.isFuel ? 0 : 19)));
      }

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

   public boolean func_75145_c(EntityPlayer entityplayer) {
      return true;
   }
}
