package com.flansmod.common.guns.boxes;

import com.flansmod.common.types.InfoType;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.item.ItemStack;

public class GunBoxEntry {
   public InfoType type;
   public List<ItemStack> requiredParts;
   public List<GunBoxEntry> ammoEntryList;

   public GunBoxEntry(InfoType aType, List<ItemStack> aParts) {
      this.type = aType;
      this.requiredParts = aParts;
   }

   public void addAmmoEntry(GunBoxEntry ammo) {
      if (this.ammoEntryList == null) {
         this.ammoEntryList = new ArrayList();
      }

      this.ammoEntryList.add(ammo);
   }

   public boolean isAmmoNullOrEmpty() {
      return this.ammoEntryList == null || this.ammoEntryList.isEmpty();
   }
}
