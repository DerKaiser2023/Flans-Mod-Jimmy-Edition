package com.flansmod.client.gui;

import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.ContainerDriveableInventory;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.PilotGun;
import com.flansmod.common.driveables.Seat;
import com.flansmod.common.driveables.mechas.EntityMecha;
import com.flansmod.common.guns.BulletType;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.ShootableType;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketDriveableGUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class GuiDriveableInventory extends GuiContainer {
   private static final ResourceLocation texture = new ResourceLocation("flansmod", "gui/planeInventory.png");
   public ContainerDriveableInventory container;
   public InventoryPlayer inventory;
   public World world;
   public int scroll;
   public int numItems;
   public int maxScroll;
   public EntityDriveable driveable;
   public int screen;

   public GuiDriveableInventory(InventoryPlayer inventoryplayer, World world1, EntityDriveable entPlane, int i) {
      super(new ContainerDriveableInventory(inventoryplayer, world1, entPlane, i));
      this.driveable = entPlane;
      this.inventory = inventoryplayer;
      this.world = world1;
      this.container = (ContainerDriveableInventory)this.field_147002_h;
      this.field_147000_g = 180;
      this.screen = i;
      this.maxScroll = this.container.maxScroll;
      this.numItems = this.container.numItems;
   }

   protected void func_146979_b(int x, int y) {
      String title = " - Guns";
      if (this.screen == 1) {
         title = " - " + this.driveable.getBombInventoryName();
      }

      if (this.screen == 2) {
         title = " - Cargo";
      }

      if (this.screen == 3) {
         title = " - " + this.driveable.getMissileInventoryName();
      }

      this.field_146289_q.func_78276_b(this.driveable.getDriveableType().name + title, 6, 6, 4210752);
      this.field_146289_q.func_78276_b("Inventory", 8, this.field_147000_g - 96 + 2, 4210752);
      RenderHelper.func_74520_c();
      GL11.glColor3f(1.0F, 1.0F, 1.0F);
      List<String> listHoveringText = new ArrayList();
      int i;
      if (this.screen == 0) {
         int slotsDone = 0;

         Iterator var9;
         ShootableType ammo;
         int ai;
         for(i = 0; i < this.driveable.getDriveableType().seats.length; ++i) {
            if (slotsDone < 3 + this.scroll && this.driveable.getDriveableType().seats[i].gunType != null) {
               if (slotsDone >= this.scroll) {
                  Seat seat = this.driveable.getDriveableType().seats[i];
                  this.field_146289_q.func_78276_b(seat.gunName, 53, 29 + 19 * (slotsDone - this.scroll), 0);
                  int itemY = 25 + 19 * (slotsDone - this.scroll);
                  if (y >= this.field_147009_r + itemY && y <= this.field_147009_r + itemY + 16) {
                     if (x >= this.field_147003_i + 10 && x <= this.field_147003_i + 10 + 17) {
                        listHoveringText.add(seat.gunType.name);
                     } else if (x >= this.field_147003_i + 28 && x <= this.field_147003_i + 28 + 17) {
                        if (seat.gunType.ammo.size() > 0) {
                           listHoveringText.add("[Ammo]");
                        }

                        var9 = seat.gunType.ammo.iterator();

                        while(var9.hasNext()) {
                           ammo = (ShootableType)var9.next();
                           listHoveringText.add("> " + ammo.name);
                        }
                     }
                  }

                  for(ai = 0; ai < seat.gunType.ammo.size(); ++ai) {
                     this.drawStack(new ItemStack(((ShootableType)seat.gunType.ammo.get(ai)).getItem()), 110 + ai * 16, itemY);
                  }

                  this.drawStack(new ItemStack(seat.gunType.getItem()), 10, 25 + 19 * (slotsDone - this.scroll));
               }

               ++slotsDone;
            }
         }

         for(i = 0; i < this.driveable.getDriveableType().pilotGuns.size(); ++i) {
            if (slotsDone < 3 + this.scroll && ((PilotGun)this.driveable.getDriveableType().pilotGuns.get(i)).type != null) {
               if (slotsDone >= this.scroll) {
                  this.field_146289_q.func_78276_b("Driver's gun " + (i + 1), 53, 29 + 19 * (slotsDone - this.scroll), 0);
                  int itemY = 25 + 19 * (slotsDone - this.scroll);
                  GunType gunType = ((PilotGun)this.driveable.getDriveableType().pilotGuns.get(i)).type;
                  if (y >= this.field_147009_r + itemY && y <= this.field_147009_r + itemY + 16) {
                     if (x >= this.field_147003_i + 10 && x <= this.field_147003_i + 10 + 17) {
                        listHoveringText.add(gunType.name);
                     } else if (x >= this.field_147003_i + 28 && x <= this.field_147003_i + 28 + 17) {
                        if (gunType.ammo.size() > 0) {
                           listHoveringText.add("[Ammo]");
                        }

                        var9 = gunType.ammo.iterator();

                        while(var9.hasNext()) {
                           ammo = (ShootableType)var9.next();
                           listHoveringText.add("> " + ammo.name);
                        }
                     }
                  }

                  for(ai = 0; ai < gunType.ammo.size(); ++ai) {
                     this.drawStack(new ItemStack(((ShootableType)gunType.ammo.get(ai)).getItem()), 110 + ai * 16, itemY);
                  }

                  this.drawStack(new ItemStack(((PilotGun)this.driveable.getDriveableType().pilotGuns.get(i)).type.getItem()), 10, 25 + 19 * (slotsDone - this.scroll));
               }

               ++slotsDone;
            }
         }
      } else if (this.screen == 3 && x >= this.field_147003_i + 10 && x < this.field_147003_i + 180 - 10 && y >= this.field_147009_r + 20 && y < this.field_147009_r + 90 && this.driveable.getDriveableType().ammo.size() > 0) {
         listHoveringText.add("[Missiles]");
         Iterator var11 = this.driveable.getDriveableType().ammo.iterator();

         while(var11.hasNext()) {
            BulletType ammo = (BulletType)var11.next();
            if (ammo != null) {
               listHoveringText.add("> " + ammo.name);
            }
         }
      }

      Slot mouseOverSlot = null;

      for(i = 0; i < this.field_147002_h.field_75151_b.size(); ++i) {
         Slot slot = (Slot)this.field_147002_h.field_75151_b.get(i);
         if (this.func_146978_c(slot.field_75223_e, slot.field_75221_f, 16, 16, x, y) && slot.func_111238_b()) {
            mouseOverSlot = slot;
         }
      }

      if (mouseOverSlot == null || !mouseOverSlot.func_75216_d()) {
         this.drawHoveringText(listHoveringText, x - this.field_147003_i, y - this.field_147009_r, this.field_146289_q);
      }

      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(32826);
      RenderHelper.func_74518_a();
      GL11.glDisable(2896);
      GL11.glDisable(2929);
   }

   private void drawStack(ItemStack itemstack, int i, int j) {
      if (itemstack != null && itemstack.func_77973_b() != null) {
         field_146296_j.func_77015_a(this.field_146289_q, this.field_146297_k.field_71446_o, itemstack, i, j);
         field_146296_j.func_77021_b(this.field_146289_q, this.field_146297_k.field_71446_o, itemstack, i, j);
      }

   }

   private static String getGunSlotName(int i) {
      switch(i) {
      case 0:
         return "Left Nose Gun";
      case 1:
         return "Right Nose Gun";
      case 2:
         return "Left Wing Gun";
      case 3:
         return "Right Wing Gun";
      case 4:
         return "Tail Gun";
      case 5:
         return "Left Bay Gun";
      case 6:
         return "Right Bay Gun";
      case 7:
         return "Dorsal Gun";
      default:
         return "Not a Gun";
      }
   }

   protected void func_146976_a(float f, int i1, int j1) {
      int j;
      int k;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_146297_k.field_71446_o.func_110577_a(texture);
      j = (this.field_146294_l - this.field_146999_f) / 2;
      k = (this.field_146295_m - this.field_147000_g) / 2;
      this.func_73729_b(j, k, 0, 0, this.field_146999_f, this.field_147000_g);
      int n;
      label47:
      switch(this.screen) {
      case 0:
         n = 0;

         while(true) {
            if (n >= (this.numItems > 3 ? 3 : this.numItems)) {
               break label47;
            }

            this.func_73729_b(j + 9, k + 24 + 19 * n, 176, 0, 37, 18);
            ++n;
         }
      case 1:
      case 2:
      case 3:
         n = (this.numItems + 7) / 8;

         for(int row = 0; row < (n > 3 ? 3 : n); ++row) {
            this.func_73729_b(j + 9, k + 24 + 19 * row, 7, 97, 18 * ((row + this.scroll + 1) * 8 <= this.numItems ? 8 : this.numItems % 8), 18);
         }
      }

      if (this.scroll == 0) {
         this.func_73729_b(j + 161, k + 41, 176, 18, 10, 10);
      }

      if (this.scroll == this.maxScroll) {
         this.func_73729_b(j + 161, k + 53, 176, 28, 10, 10);
      }

   }

   protected void func_73864_a(int i, int j, int k) {
      super.func_73864_a(i, j, k);
      int m = i - (this.field_146294_l - this.field_146999_f) / 2;
      int n = j - (this.field_146295_m - this.field_147000_g) / 2;
      if (this.scroll > 0 && m > 161 && m < 171 && n > 41 && n < 51) {
         --this.scroll;
         this.container.updateScroll(this.scroll);
      }

      if (this.scroll < this.maxScroll && m > 161 && m < 171 && n > 53 && n < 63) {
         ++this.scroll;
         this.container.updateScroll(this.scroll);
      }

      if (m > 161 && m < 171 && n > 5 && n < 15) {
         if (this.driveable instanceof EntityMecha) {
            FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketDriveableGUI(4)));
            this.inventory.field_70458_d.openGui(FlansMod.INSTANCE, 10, this.world, this.driveable.field_70176_ah, this.driveable.field_70162_ai, this.driveable.field_70164_aj);
         } else {
            this.field_146297_k.func_147108_a(new GuiDriveableMenu(this.inventory, this.world, this.driveable));
         }
      }

   }

   public boolean func_73868_f() {
      return false;
   }
}
