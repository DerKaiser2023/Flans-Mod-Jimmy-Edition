package com.flansmod.common.driveables.mechas;

import com.flansmod.common.guns.ItemGun;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotMecha extends Slot {
   private EnumMechaSlotType slotType;

   public SlotMecha(IInventory inv, EnumMechaSlotType e, int x, int y) {
      super(inv, e.ordinal(), x, y);
      this.slotType = e;
   }

   public boolean func_75214_a(ItemStack stack) {
      if (stack != null && stack.func_77973_b() != null) {
         EnumMechaItemType itemType = null;
         Item item = stack.func_77973_b();
         if (item instanceof ItemGun && ((ItemGun)item).type.usableByMechas) {
            itemType = EnumMechaItemType.tool;
         } else {
            if (!(item instanceof ItemMechaAddon)) {
               return false;
            }

            itemType = ((ItemMechaAddon)item).type.type;
         }

         return this.slotType.accepts(itemType);
      } else {
         return true;
      }
   }

   public void func_75215_d(ItemStack stack) {
      if (this.func_75214_a(stack)) {
         this.field_75224_c.func_70299_a(this.slotType.ordinal(), stack);
         this.func_75218_e();
      }
   }
}
