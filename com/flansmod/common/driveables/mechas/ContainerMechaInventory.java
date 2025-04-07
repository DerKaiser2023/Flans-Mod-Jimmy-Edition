package com.flansmod.common.driveables.mechas;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerMechaInventory extends Container {
   public InventoryPlayer inventory;
   public World world;
   public EntityMecha mecha;
   public int numItems;
   public int maxScroll;
   public int scroll;

   public ContainerMechaInventory(InventoryPlayer inv, World w, EntityMecha em) {
      this.inventory = inv;
      this.world = w;
      this.mecha = em;
      this.numItems = this.mecha.getDriveableType().numCargoSlots;
      int numRows = (this.numItems + 7) / 8;
      this.maxScroll = numRows > 3 ? numRows - 3 : 0;
      int startSlot = this.mecha.driveableData.getCargoInventoryStart();

      int col;
      int col;
      for(col = 0; col < numRows; ++col) {
         col = -1000;
         if (col < 3 + this.scroll && col >= this.scroll) {
            col = 25 + 19 * (col - this.scroll);
         }

         for(int col = 0; col < ((col + this.scroll + 1) * 8 <= this.numItems ? 8 : this.numItems % 8); ++col) {
            this.func_75146_a(new Slot(this.mecha.driveableData, startSlot + col * 8 + col, 186 + 18 * col, col));
         }
      }

      this.func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.legs, 84, 128));
      this.func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.hips, 60, 128));
      this.func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.leftArm, 36, 80));
      this.func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.leftTool, 36, 56));
      this.func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.leftShoulder, 60, 32));
      this.func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.head, 84, 32));
      this.func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.feet, 108, 128));
      this.func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.rightArm, 132, 80));
      this.func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.rightTool, 132, 56));
      this.func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.rightShoulder, 108, 32));
      this.func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.u1, 10, 32));
      this.func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.u2, 10, 56));
      this.func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.u3, 10, 80));
      this.func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.u4, 10, 104));
      this.func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.u5, 10, 128));

      for(col = 0; col < 3; ++col) {
         for(col = 0; col < 9; ++col) {
            this.func_75146_a(new Slot(this.inventory, col + col * 9 + 9, 182 + col * 18, 98 + col * 18));
         }
      }

      for(col = 0; col < 9; ++col) {
         this.func_75146_a(new Slot(this.inventory, col, 182 + col * 18, 156));
      }

   }

   public void func_75134_a(EntityPlayer par1EntityPlayer) {
      super.func_75134_a(par1EntityPlayer);
      this.mecha.couldNotFindFuel = false;
   }

   public void updateScroll(int scrololol) {
      this.scroll = scrololol;
      int m = (this.numItems + 7) / 8;

      for(int row = 0; row < m; ++row) {
         int yPos = -1000;
         if (row < 3 + this.scroll && row >= this.scroll) {
            yPos = 25 + 19 * (row - this.scroll);
         }

         for(int col = 0; col < ((row + 1) * 8 < this.numItems ? 8 : this.numItems % 8); ++col) {
            ((Slot)this.field_75151_b.get(row * 8 + col)).field_75221_f = yPos;
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
