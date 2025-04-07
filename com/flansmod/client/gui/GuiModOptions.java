package com.flansmod.client.gui;

import com.flansmod.client.AimType;
import com.flansmod.client.FlanMouseButton;
import com.flansmod.client.FlansModClient;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiModOptions extends GuiScreen {
   public void func_73866_w_() {
      this.addButtons(0, 0);
   }

   public void func_73863_a(int var1, int var2, float var3) {
      this.func_146270_b(0);
      FontRenderer fontRenderer = this.field_146297_k.field_71466_p;
      fontRenderer.func_78261_a("Flan's Options", this.field_146294_l / 2 - fontRenderer.func_78256_a("Flan's Options") / 2, 10, 16777215);
      super.func_73863_a(var1, var2, var3);
   }

   private void addButtons(int var1, int var2) {
      FontRenderer fontRenderer = this.field_146297_k.field_71466_p;
      int fireButtonWidth = 132;
      this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - fireButtonWidth / 2, 60, fireButtonWidth, 20, "Fire Button: " + FlansModClient.fireButton.getName()));
      this.field_146292_n.add(new GuiButton(2, this.field_146294_l / 2 - fireButtonWidth / 2, 90, fireButtonWidth, 20, "Aim Button: " + FlansModClient.aimButton.getName()));
      this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - fireButtonWidth / 2, 30, fireButtonWidth, 20, "Aim Type: " + FlansModClient.aimType.getName()));
   }

   protected void func_146284_a(GuiButton button) {
      if (button.field_146127_k == 0) {
         if (FlansModClient.aimType == AimType.HOLD) {
            FlansModClient.setAimType(AimType.TOGGLE);
         } else {
            FlansModClient.setAimType(AimType.HOLD);
         }

         this.field_146292_n.clear();
         this.addButtons(0, 0);
      }

      if (button.field_146127_k == 1) {
         if (FlansModClient.fireButton == FlanMouseButton.LEFT) {
            FlansModClient.setFireButton(FlanMouseButton.RIGHT);
         } else {
            FlansModClient.setFireButton(FlanMouseButton.LEFT);
         }

         this.field_146292_n.clear();
         this.addButtons(0, 0);
      }

      if (button.field_146127_k == 2) {
         if (FlansModClient.aimButton == FlanMouseButton.LEFT) {
            FlansModClient.setAimButton(FlanMouseButton.RIGHT);
         } else {
            FlansModClient.setAimButton(FlanMouseButton.LEFT);
         }

         this.field_146292_n.clear();
         this.addButtons(0, 0);
      }

   }

   public boolean func_73868_f() {
      return false;
   }
}
