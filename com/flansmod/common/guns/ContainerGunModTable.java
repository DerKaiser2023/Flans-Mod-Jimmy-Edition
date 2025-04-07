package com.flansmod.common.guns;

import com.flansmod.common.paintjob.Paintjob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerGunModTable extends Container {
   private InventoryGunModTable inventory;
   public InventoryPlayer playerInv;
   public World world;

   public ContainerGunModTable(InventoryPlayer i, World w) {
      this.playerInv = i;
      this.inventory = new InventoryGunModTable();
      this.world = w;
      SlotGun gunSlot = new SlotGun(this.inventory, 0, 184, 37, (SlotGun)null);
      this.func_75146_a(gunSlot);

      int col;
      for(col = 0; col < 8; ++col) {
         this.func_75146_a(new SlotGun(this.inventory, col + 1, 17 + col * 18, 89, gunSlot));
      }

      for(col = 0; col < 8; ++col) {
         this.func_75146_a(new SlotGun(this.inventory, 9 + col, 17 + col * 18, 115 + col * 18, gunSlot));
      }

      for(col = 0; col < 3; ++col) {
         for(int col = 0; col < 9; ++col) {
            this.func_75146_a(new Slot(this.playerInv, col + col * 9 + 9, 8 + col * 18, 154 + col * 18));
         }
      }

      for(col = 0; col < 9; ++col) {
         this.func_75146_a(new Slot(this.playerInv, col, 8 + col * 18, 212));
      }

   }

   public void func_75134_a(EntityPlayer player) {
      if (this.inventory.func_70301_a(0) != null) {
         player.func_71019_a(this.inventory.func_70301_a(0), false);
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
         if (slotID >= 17) {
            return null;
         }

         if (!this.func_75135_a(slotStack, 17, this.field_75151_b.size(), true)) {
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

   public void clickPaintjob(int id) {
      ItemStack gunStack = this.inventory.func_70301_a(0);
      if (gunStack != null && gunStack.func_77973_b() instanceof ItemGun) {
         GunType gunType = ((ItemGun)gunStack.func_77973_b()).type;
         this.clickPaintjob(gunType.getPaintjob(id));
      }

   }

   public void clickPaintjob(Paintjob paintjob) {
      ItemStack gunStack = this.inventory.func_70301_a(0);
      if (gunStack != null && gunStack.func_77973_b() instanceof ItemGun) {
         GunType gunType = ((ItemGun)gunStack.func_77973_b()).type;
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

         gunStack.func_77964_b(paintjob.ID);
      }

   }
}
