package com.flansmod.client.gui;

import com.flansmod.api.IControllable;
import com.flansmod.client.FlansModClient;
import com.flansmod.client.KeyInputHandler;
import com.flansmod.common.FlansMod;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class GuiDriveableController extends GuiScreen {
   private IControllable plane;
   private boolean leftMouseHeld;
   private boolean rightMouseHeld;

   public GuiDriveableController(IControllable thePlane) {
      this.plane = thePlane;
   }

   public void func_73866_w_() {
      if (this.field_146297_k.field_71474_y.field_74320_O == 1) {
         this.field_146297_k.field_71451_h = (EntityLivingBase)(this.plane.getCamera() == null ? this.field_146297_k.field_71439_g : this.plane.getCamera());
      }

   }

   public void func_146281_b() {
      this.field_146297_k.field_71417_B.func_74373_b();
      this.field_146297_k.field_71451_h = this.field_146297_k.field_71439_g;
   }

   public void func_146274_d() {
      EntityPlayer player = (EntityPlayer)this.plane.getControllingEntity();
      if (player != this.field_146297_k.field_71439_g) {
         this.field_146297_k.func_147108_a((GuiScreen)null);
      } else {
         int dWheel = Mouse.getDWheel();
         if (dWheel != 0) {
            player.field_71071_by.func_70453_c(dWheel);
         }

         if (Mouse.isButtonDown(1)) {
            this.plane.pressKey(8, player);
         }

         if (!this.leftMouseHeld && Mouse.isButtonDown(0)) {
            this.leftMouseHeld = true;
            this.plane.updateKeyHeldState(9, true);
         }

         if (this.leftMouseHeld && !Mouse.isButtonDown(0)) {
            this.leftMouseHeld = false;
            this.plane.updateKeyHeldState(9, false);
         }

         if (!this.rightMouseHeld && Mouse.isButtonDown(1)) {
            this.rightMouseHeld = true;
            this.plane.updateKeyHeldState(8, true);
         }

         if (this.rightMouseHeld && !Mouse.isButtonDown(1)) {
            this.rightMouseHeld = false;
            this.plane.updateKeyHeldState(8, false);
         }

      }
   }

   protected void func_73869_a(char c, int i) {
      if (i == 1) {
         this.field_146297_k.func_147108_a((GuiScreen)null);
         this.field_146297_k.func_71385_j();
      }

      if (i == 59) {
         this.field_146297_k.field_71474_y.field_74319_N = !this.field_146297_k.field_71474_y.field_74319_N;
      }

      if (i == 61) {
         this.field_146297_k.field_71474_y.field_74330_P = !this.field_146297_k.field_71474_y.field_74330_P;
      }

      if (i == 63) {
         this.field_146297_k.field_71474_y.field_74320_O = (this.field_146297_k.field_71474_y.field_74320_O + 1) % 3;
         if (this.field_146297_k.field_71474_y.field_74320_O == 1) {
            this.field_146297_k.field_71451_h = (EntityLivingBase)(this.plane.getCamera() == null ? this.field_146297_k.field_71439_g : this.plane.getCamera());
         } else {
            this.field_146297_k.field_71451_h = this.field_146297_k.field_71439_g;
         }
      }

      if (i == 66) {
         this.field_146297_k.field_71474_y.field_74326_T = !this.field_146297_k.field_71474_y.field_74326_T;
      }

      if (i == this.field_146297_k.field_71474_y.field_151445_Q.func_151463_i()) {
         this.field_146297_k.func_147108_a(new GuiInventory(this.field_146297_k.field_71439_g));
      }

      if (i == this.field_146297_k.field_71474_y.field_74316_C.func_151463_i()) {
      }

      if (i == this.field_146297_k.field_71474_y.field_74310_D.func_151463_i()) {
         this.field_146297_k.func_147108_a(new GuiChat());
      }

      if (i == this.field_146297_k.field_71474_y.field_74323_J.func_151463_i()) {
         this.field_146297_k.func_147108_a(new GuiChat("/"));
      }

      if (i == KeyInputHandler.reloadModelsKey.func_151463_i()) {
         FlansModClient.reloadModels(false);
      }

   }

   public void func_73876_c() {
      if (this.field_146297_k.field_71474_y.field_74320_O == 1) {
         this.field_146297_k.field_71451_h = (EntityLivingBase)(this.plane.getCamera() == null ? this.field_146297_k.field_71439_g : this.plane.getCamera());
      } else {
         this.field_146297_k.field_71451_h = this.field_146297_k.field_71439_g;
      }

   }

   public void func_146269_k() {
      EntityPlayer player = (EntityPlayer)this.plane.getControllingEntity();
      if (player != this.field_146297_k.field_71439_g) {
         this.field_146297_k.func_147108_a((GuiScreen)null);
      } else {
         if (!Mouse.isGrabbed()) {
            this.field_146297_k.field_71417_B.func_74372_a();
         }

         this.func_146274_d();

         while(Keyboard.next()) {
            this.func_146282_l();
         }

         int l = Mouse.getDX();
         int m = Mouse.getDY();
         this.plane.onMouseMoved(l, m);
         if (this.plane != null && !this.plane.isDead() && this.plane.getControllingEntity() != null && this.plane.getControllingEntity() instanceof EntityPlayer) {
            if (FlansMod.proxy.keyDown(this.field_146297_k.field_71474_y.field_74351_w.func_151463_i())) {
               this.plane.pressKey(0, player);
            }

            if (FlansMod.proxy.keyDown(this.field_146297_k.field_71474_y.field_74368_y.func_151463_i())) {
               this.plane.pressKey(1, player);
            }

            if (FlansMod.proxy.keyDown(this.field_146297_k.field_71474_y.field_74370_x.func_151463_i())) {
               this.plane.pressKey(2, player);
            }

            if (FlansMod.proxy.keyDown(this.field_146297_k.field_71474_y.field_74366_z.func_151463_i())) {
               this.plane.pressKey(3, player);
            }

            if (FlansMod.proxy.keyDown(this.field_146297_k.field_71474_y.field_74314_A.func_151463_i())) {
               this.plane.pressKey(4, player);
            }

            if (FlansMod.proxy.keyDown(KeyInputHandler.downKey.func_151463_i())) {
               this.plane.pressKey(5, player);
            }

            if (FlansMod.proxy.keyDown(this.field_146297_k.field_71474_y.field_74311_E.func_151463_i())) {
               this.plane.pressKey(6, player);
            }

            if (FlansMod.proxy.keyDown(KeyInputHandler.inventoryKey.func_151463_i())) {
               this.plane.pressKey(7, player);
            }

            if (FlansMod.proxy.keyDown(KeyInputHandler.bombKey.func_151463_i())) {
               this.plane.pressKey(8, player);
            }

            if (FlansMod.proxy.keyDown(KeyInputHandler.gunKey.func_151463_i())) {
               this.plane.pressKey(9, player);
            }

            if (FlansMod.proxy.keyDown(KeyInputHandler.controlSwitchKey.func_151463_i())) {
               this.plane.pressKey(10, player);
            }

            if (FlansMod.proxy.keyDown(KeyInputHandler.leftRollKey.func_151463_i())) {
               this.plane.pressKey(11, player);
            }

            if (FlansMod.proxy.keyDown(KeyInputHandler.rightRollKey.func_151463_i())) {
               this.plane.pressKey(12, player);
            }

            if (FlansMod.proxy.keyDown(KeyInputHandler.gearKey.func_151463_i())) {
               this.plane.pressKey(13, player);
            }

            if (FlansMod.proxy.keyDown(KeyInputHandler.doorKey.func_151463_i())) {
               this.plane.pressKey(14, player);
            }

            if (FlansMod.proxy.keyDown(KeyInputHandler.modeKey.func_151463_i())) {
               this.plane.pressKey(15, player);
            }

            if (FlansMod.proxy.keyDown(KeyInputHandler.flareKey.func_151463_i())) {
               this.plane.pressKey(18, player);
            }
         } else {
            this.field_146297_k.func_147108_a((GuiScreen)null);
         }

      }
   }

   public void func_146278_c(int i) {
   }

   public boolean func_73868_f() {
      return false;
   }
}
