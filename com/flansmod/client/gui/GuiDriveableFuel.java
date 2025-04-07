package com.flansmod.client.gui;

import com.flansmod.common.driveables.ContainerDriveableMenu;
import com.flansmod.common.driveables.EntityDriveable;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class GuiDriveableFuel extends GuiContainer {
   private static final ResourceLocation texture = new ResourceLocation("flansmod", "gui/planeFuel.png");
   public World world;
   public InventoryPlayer inventory;
   public EntityDriveable plane;
   private int anim = 0;
   private long lastTime;

   public GuiDriveableFuel(InventoryPlayer inventoryplayer, World world1, EntityDriveable entPlane) {
      super(new ContainerDriveableMenu(inventoryplayer, world1, true, entPlane));
      this.plane = entPlane;
      this.field_147000_g = 161;
      this.world = world1;
      this.inventory = inventoryplayer;
   }

   protected void func_146979_b(int i, int j) {
      this.field_146289_q.func_78276_b(this.plane.getDriveableType().name + " - Fuel", 6, 6, 4210752);
      this.field_146289_q.func_78276_b("Inventory", 8, this.field_147000_g - 96 + 2, 4210752);
   }

   protected void func_146976_a(float f, int i1, int j1) {
      long newTime = this.field_146297_k.field_71441_e.func_72912_H().func_76073_f();
      if (newTime > this.lastTime) {
         this.lastTime = newTime;
         if (newTime % 5L == 0L) {
            ++this.anim;
         }
      }

      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_146297_k.field_71446_o.func_110577_a(texture);
      int j = (this.field_146294_l - this.field_146999_f) / 2;
      int k = (this.field_146295_m - this.field_147000_g) / 2;
      this.func_73729_b(j, k, 0, 0, this.field_146999_f, this.field_147000_g);
      int fuelTankSize = this.plane.getDriveableType().fuelTankSize;
      float fuelInTank = this.plane.driveableData.fuelInTank;
      if (this.plane.fuelling) {
         this.func_73729_b(j + 15, k + 44, 176 + 15 * (this.anim % 4), 0, 15, 16);
      }

      if (fuelInTank < (float)(fuelTankSize / 8) && this.anim % 4 > 1) {
         this.func_73729_b(j + 16, k + 25, 176, 16, 6, 6);
      }

      if (fuelInTank > 0.0F) {
         this.func_73729_b(j + 26, k + 21, 0, 161, (int)(129.0F * fuelInTank / (float)fuelTankSize), 15);
      }

   }

   protected void func_73864_a(int i, int j, int k) {
      super.func_73864_a(i, j, k);
      int m = i - (this.field_146294_l - this.field_146999_f) / 2;
      int n = j - (this.field_146295_m - this.field_147000_g) / 2;
      if (m > 161 && m < 171 && n > 5 && n < 15) {
         this.field_146297_k.func_147108_a(new GuiDriveableMenu(this.inventory, this.world, this.plane));
      }

   }
}
