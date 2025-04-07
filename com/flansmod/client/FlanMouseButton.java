package com.flansmod.client;

import net.minecraft.util.StatCollector;

public enum FlanMouseButton {
   LEFT(0),
   RIGHT(1);

   private int buttonNumber;

   private FlanMouseButton(int button) {
      this.buttonNumber = button;
   }

   public String getName() {
      return StatCollector.func_74838_a(String.format("firebutton.%s.name", this.name().toLowerCase()));
   }

   public int getButton() {
      return this.buttonNumber;
   }

   public static FlanMouseButton fromString(String input) {
      FlanMouseButton[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         FlanMouseButton buttonType = var1[var3];
         if (buttonType.name().equalsIgnoreCase(input)) {
            return buttonType;
         }
      }

      return null;
   }

   public String toString() {
      return this.name().toLowerCase();
   }
}
