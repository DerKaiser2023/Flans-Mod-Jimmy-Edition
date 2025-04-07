package com.flansmod.common.driveables.mechas;

import net.minecraft.block.material.Material;

public enum EnumMechaToolType {
   pickaxe,
   axe,
   shovel,
   shears,
   sword;

   public static EnumMechaToolType getToolType(String s) {
      EnumMechaToolType[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         EnumMechaToolType type = var1[var3];
         if (type.toString().equals(s)) {
            return type;
         }
      }

      return sword;
   }

   public boolean effectiveAgainst(Material material) {
      switch(this) {
      case pickaxe:
         return material == Material.field_151573_f || material == Material.field_151574_g || material == Material.field_151576_e || material == Material.field_151588_w;
      case axe:
         return material == Material.field_151575_d || material == Material.field_151585_k || material == Material.field_151582_l;
      case shovel:
         return material == Material.field_151577_b || material == Material.field_151578_c || material == Material.field_151583_m || material == Material.field_151595_p || material == Material.field_151597_y || material == Material.field_151596_z || material == Material.field_151571_B;
      case shears:
         return material == Material.field_151584_j || material == Material.field_151582_l || material == Material.field_151580_n || material == Material.field_151593_r;
      case sword:
         return material == Material.field_151569_G;
      default:
         return false;
      }
   }
}
