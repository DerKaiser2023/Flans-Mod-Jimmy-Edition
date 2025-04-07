package com.flansmod.client;

import net.minecraft.util.StatCollector;

public enum AimType {
   HOLD,
   TOGGLE;

   public String getName() {
      return StatCollector.func_74838_a(String.format("aimtype.%s.name", this.name().toLowerCase()));
   }

   public static AimType fromString(String input) {
      AimType[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         AimType aimType = var1[var3];
         if (aimType.name().equalsIgnoreCase(input)) {
            return aimType;
         }
      }

      return null;
   }

   public String toString() {
      return this.name().toLowerCase();
   }
}
