package com.flansmod.common.driveables;

public enum EnumPlaneMode {
   PLANE,
   VTOL,
   HELI,
   SIXDOF;

   public static EnumPlaneMode getMode(String s) {
      if (s.toLowerCase().equals("vtol")) {
         return VTOL;
      } else {
         return s.toLowerCase().equals("heli") ? HELI : PLANE;
      }
   }
}
