package com.flansmod.common.guns;

public enum EnumFireMode {
   SEMIAUTO,
   FULLAUTO,
   MINIGUN,
   BURST;

   public static EnumFireMode getFireMode(String s) {
      s = s.toLowerCase();
      if (s.equals("fullauto")) {
         return FULLAUTO;
      } else if (s.equals("minigun")) {
         return MINIGUN;
      } else {
         return s.equals("burst") ? BURST : SEMIAUTO;
      }
   }
}
