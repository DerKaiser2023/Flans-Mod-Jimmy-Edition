package com.flansmod.common.paintjob;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerPaintjobTable extends Container {
   public InventoryPlayer playerInv;
   public TileEntityPaintjobTable table;
   public World world;

   public ContainerPaintjobTable(InventoryPlayer i, World w, TileEntityPaintjobTable te) {
      this.playerInv = i;
      this.world = w;
      this.table = te;
      this.func_75146_a(new Slot(this.table, 0, 187, 139));
      this.func_75146_a(new Slot(this.table, 1, 187, 193));

      int col;
      for(col = 0; col < 3; ++col) {
         for(int col = 0; col < 9; ++col) {
            this.func_75146_a(new Slot(this.playerInv, col + col * 9 + 9, 8 + col * 18, 184 + col * 18));
         }
      }

      for(col = 0; col < 9; ++col) {
         this.func_75146_a(new Slot(this.playerInv, col, 8 + col * 18, 242));
      }

   }

   public void func_75134_a(EntityPlayer player) {
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
         if (slotID >= 1) {
            return null;
         }

         if (!this.func_75135_a(slotStack, 1, this.field_75151_b.size(), true)) {
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

   public void pressButton(boolean paint, boolean left) {
   }

   public void clickPaintjob(int i) {
      ItemStack paintableStack = this.table.getPaintableStack();
      if (paintableStack != null && paintableStack.func_77973_b() instanceof IPaintableItem) {
         PaintableType paintableType = ((IPaintableItem)paintableStack.func_77973_b()).GetPaintableType();
         this.clickPaintjob(paintableType.getPaintjob(i));
      }

   }

   public void clickPaintjob(Paintjob paintjob) {
      ItemStack paintableStack = this.table.getPaintableStack();
      if (paintableStack != null && paintableStack.func_77973_b() instanceof IPaintableItem) {
         PaintableType paintableType = ((IPaintableItem)paintableStack.func_77973_b()).GetPaintableType();
         int numDyes = paintjob.dyesNeeded.length;
         if (!this.playerInv.field_70458_d.field_71075_bZ.field_75098_d) {
            int n = 0;

            label65:
            while(true) {
               int amountNeeded;
               int s;
               ItemStack stack;
               if (n >= numDyes) {
                  n = 0;

                  while(true) {
                     if (n >= numDyes) {
                        break label65;
                     }

                     amountNeeded = paintjob.dyesNeeded[n].field_77994_a;

                     for(s = 0; s < this.playerInv.func_70302_i_(); ++s) {
                        if (amountNeeded > 0) {
                           stack = this.playerInv.func_70301_a(s);
                           if (stack != null && stack.func_77973_b() == Items.field_151100_aR && stack.func_77960_j() == paintjob.dyesNeeded[n].func_77960_j()) {
                              ItemStack consumed = this.playerInv.func_70298_a(s, amountNeeded);
                              amountNeeded -= consumed.field_77994_a;
                           }
                        }
                     }

                     ++n;
                  }
               }

               amountNeeded = paintjob.dyesNeeded[n].field_77994_a;

               for(s = 0; s < this.playerInv.func_70302_i_(); ++s) {
                  stack = this.playerInv.func_70301_a(s);
                  if (stack != null && stack.func_77973_b() == Items.field_151100_aR && stack.func_77960_j() == paintjob.dyesNeeded[n].func_77960_j()) {
                     amountNeeded -= stack.field_77994_a;
                  }
               }

               if (amountNeeded > 0) {
                  return;
               }

               ++n;
            }
         }

         paintableStack.func_77964_b(paintjob.ID);
      }

   }
}
