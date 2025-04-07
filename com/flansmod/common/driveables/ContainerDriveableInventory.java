package com.flansmod.common.driveables;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerDriveableInventory extends Container {
   public InventoryPlayer inventory;
   public World world;
   public EntityDriveable plane;
   public int numItems;
   public int screen;
   public int maxScroll;
   public int scroll;

   public ContainerDriveableInventory(InventoryPlayer inventoryplayer, World worldy, EntityDriveable entPlane, int i) {
      this.inventory = inventoryplayer;
      this.world = worldy;
      this.plane = entPlane;
      this.screen = i;
      this.numItems = 0;
      switch(i) {
      case 0:
         this.numItems = this.plane.driveableData.numGuns;
         this.maxScroll = this.numItems > 3 ? this.numItems - 3 : 0;
         break;
      case 1:
         this.numItems = this.plane.getDriveableType().numBombSlots;
         this.maxScroll = (this.numItems + 7) / 8 > 3 ? (this.numItems + 7) / 8 - 3 : 0;
         break;
      case 2:
         this.numItems = this.plane.getDriveableType().numCargoSlots;
         this.maxScroll = (this.numItems + 7) / 8 > 3 ? (this.numItems + 7) / 8 - 3 : 0;
         break;
      case 3:
         this.numItems = this.plane.getDriveableType().numMissileSlots;
         this.maxScroll = (this.numItems + 7) / 8 > 3 ? (this.numItems + 7) / 8 - 3 : 0;
      }

      int startSlot;
      int m;
      int row;
      label111:
      switch(this.screen) {
      case 0:
         startSlot = 0;
         m = 0;

         while(true) {
            if (m >= this.plane.driveableData.numGuns) {
               break label111;
            }

            row = -1000;
            if (startSlot < 3 + this.scroll && startSlot >= this.scroll) {
               row = 25 + 19 * startSlot;
            }

            this.func_75146_a(new Slot(this.plane.driveableData, m, 29, row));
            ++startSlot;
            ++m;
         }
      case 1:
      case 2:
      case 3:
         startSlot = this.plane.driveableData.getBombInventoryStart();
         if (this.screen == 2) {
            startSlot = this.plane.driveableData.getCargoInventoryStart();
         }

         if (this.screen == 3) {
            startSlot = this.plane.driveableData.getMissileInventoryStart();
         }

         m = (this.numItems + 7) / 8;

         for(row = 0; row < m; ++row) {
            int yPos = -1000;
            if (row < 3 + this.scroll && row >= this.scroll) {
               yPos = 25 + 19 * (row - this.scroll);
            }

            for(int col = 0; col < ((row + this.scroll + 1) * 8 <= this.numItems ? 8 : this.numItems % 8); ++col) {
               this.func_75146_a(new Slot(this.plane.driveableData, startSlot + row * 8 + col, 10 + 18 * col, yPos));
            }
         }
      }

      for(startSlot = 0; startSlot < 3; ++startSlot) {
         for(m = 0; m < 9; ++m) {
            this.func_75146_a(new Slot(inventoryplayer, m + startSlot * 9 + 9, 8 + m * 18, 98 + startSlot * 18));
         }
      }

      for(startSlot = 0; startSlot < 9; ++startSlot) {
         this.func_75146_a(new Slot(inventoryplayer, startSlot, 8 + startSlot * 18, 156));
      }

   }

   public void updateScroll(int scrololol) {
      this.scroll = scrololol;
      int slotsDone;
      int row;
      int yPos;
      switch(this.screen) {
      case 0:
         slotsDone = 0;

         for(row = 0; row < this.plane.driveableData.numGuns; ++row) {
            yPos = -1000;
            if (slotsDone < 3 + this.scroll && slotsDone >= this.scroll) {
               yPos = 25 + 19 * (slotsDone - this.scroll);
            }

            ((Slot)this.field_75151_b.get(slotsDone)).field_75221_f = yPos;
            ++slotsDone;
         }

         return;
      case 1:
      case 2:
      case 3:
         slotsDone = (this.numItems + 7) / 8;

         for(row = 0; row < slotsDone; ++row) {
            yPos = -1000;
            if (row < 3 + this.scroll && row >= this.scroll) {
               yPos = 25 + 19 * (row - this.scroll);
            }

            for(int col = 0; col < ((row + 1) * 8 <= this.numItems ? 8 : this.numItems % 8); ++col) {
               ((Slot)this.field_75151_b.get(row * 8 + col)).field_75221_f = yPos;
            }
         }
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
         if (slotID >= this.numItems) {
            if (!this.func_75135_a(slotStack, 0, this.numItems, false)) {
               return null;
            }
         } else if (!this.func_75135_a(slotStack, this.numItems, this.field_75151_b.size(), true)) {
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
