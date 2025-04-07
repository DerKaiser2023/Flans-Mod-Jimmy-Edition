package com.flansmod.common.guns;

public enum EnumAttachmentType {
   barrel,
   sights,
   stock,
   grip,
   gadget,
   slide,
   pump,
   accessory,
   generic;

   public static EnumAttachmentType get(String s) {
      EnumAttachmentType[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         EnumAttachmentType type = var1[var3];
         if (type.toString().equals(s)) {
            return type;
         }
      }

      return generic;
   }
}
