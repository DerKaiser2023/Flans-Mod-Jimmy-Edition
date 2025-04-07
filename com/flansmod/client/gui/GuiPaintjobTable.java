package com.flansmod.client.gui;

import com.flansmod.client.ClientProxy;
import com.flansmod.client.FlansModResourceHandler;
import com.flansmod.client.model.GunAnimations;
import com.flansmod.client.model.ModelAttachment;
import com.flansmod.client.model.ModelDriveable;
import com.flansmod.client.model.RenderGun;
import com.flansmod.common.FlansMod;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.guns.AttachmentType;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketGunPaint;
import com.flansmod.common.paintjob.ContainerPaintjobTable;
import com.flansmod.common.paintjob.IPaintableItem;
import com.flansmod.common.paintjob.PaintableType;
import com.flansmod.common.paintjob.Paintjob;
import com.flansmod.common.paintjob.TileEntityPaintjobTable;
import com.flansmod.common.types.EnumType;
import com.flansmod.common.vector.Vector3f;
import java.util.Random;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiPaintjobTable extends GuiContainer {
   private static final ResourceLocation texture = new ResourceLocation("flansmod", "gui/paintjobTable.png");
   private static final Random rand = new Random();
   private static final int paletteSizeX = 18;
   private static final int paletteSizeY = 4;
   private static final float componentBarLength = 68.0F;
   private Paintjob hoveringOver = null;
   private int mouseX;
   private int mouseY;
   private InventoryPlayer inventory;
   private boolean inCustomMode;
   private float customModeTransitionTimer = 0.0F;
   private float transitionSpeed = 0.9F;
   private int prevMainPageX;
   private RotatedAxes modelAxes = new RotatedAxes();
   private RotatedAxes prevModelAxes = new RotatedAxes();
   private static int[][] paletteColours = new int[18][4];
   private static int[] baseColours = new int[]{0, 16777215, 16711680, 16733440, 16755200, 16776960, 11206400, 5635840, 65280, 65365, 65450, 65535, 43775, 22015, 255, 5570815, 11141375, 16711935};
   private static int currentColour;

   private static void ResetPalette() {
      for(int x = 0; x < 18; ++x) {
         for(int y = 0; y < 4; ++y) {
            int red = baseColours[x] >> 16 & 255;
            int green = baseColours[x] >> 8 & 255;
            int blue = baseColours[x] >> 0 & 255;
            if (x == 0) {
               red = green = blue = 255 * y / 7;
            } else if (x == 1) {
               red = green = blue = 255 * (y + 4) / 7;
            } else {
               if (y == 3) {
                  red /= 2;
                  green /= 2;
                  blue /= 2;
               }

               if (y == 1) {
                  red = 255 - (255 - red) / 2;
                  green = 255 - (255 - green) / 2;
                  blue = 255 - (255 - blue) / 2;
               }

               if (y == 0) {
                  red = 255 - (255 - red) / 4;
                  green = 255 - (255 - green) / 4;
                  blue = 255 - (255 - blue) / 4;
               }
            }

            paletteColours[x][y] = (red << 16) + (green << 8) + blue;
         }
      }

   }

   public GuiPaintjobTable(InventoryPlayer inv, World w, TileEntityPaintjobTable te) {
      super(new ContainerPaintjobTable(inv, w, te));
      this.inventory = inv;
      this.field_146999_f = 224;
      this.field_147000_g = 264;
   }

   public void func_73876_c() {
      super.func_73876_c();
      this.prevModelAxes = this.modelAxes.clone();
      if (this.inCustomMode) {
         this.customModeTransitionTimer = 1.0F - (1.0F - this.customModeTransitionTimer) * this.transitionSpeed;
      } else {
         this.customModeTransitionTimer *= this.transitionSpeed;
         this.modelAxes.rotateLocalYaw(2.5F);
      }

      int xPos = this.GetMainPageX();
      int dPos = xPos - this.prevMainPageX;

      for(int i = 0; i < 38; ++i) {
         Slot var10000 = this.field_147002_h.func_75139_a(i);
         var10000.field_75223_e += dPos;
      }

      this.prevMainPageX = xPos;
   }

   private int GetMainPageX() {
      return (int)(-500.0F * this.customModeTransitionTimer);
   }

   private int GetMainPageY() {
      return 0;
   }

   private int GetCustomPageX() {
      return (int)(500.0F * (1.0F - this.customModeTransitionTimer));
   }

   private int GetCustomPageY() {
      return 0;
   }

   private Vector3f GetRenderOrigin() {
      Vector3f mainPagePosition = new Vector3f(100.0F, 64.0F, 100.0F);
      return mainPagePosition;
   }

   protected void func_146979_b(int x, int y) {
      if (this.customModeTransitionTimer <= 0.999F) {
         int xOrigin = (this.field_146294_l - this.field_146999_f) / 2 + this.GetMainPageX();
         int yOrigin = (this.field_146295_m - this.field_147000_g) / 2 + this.GetMainPageY();
         this.field_146289_q.func_78276_b("Inventory", this.GetMainPageX() + 8, this.GetMainPageY() + (this.field_147000_g - 94) + 2, 4210752);
         this.field_146289_q.func_78276_b("Paintjob Table", this.GetMainPageX() + 8, this.GetMainPageY() + 6, 4210752);
      }

      Vector3f renderOrigin = this.GetRenderOrigin();
      ItemStack paintableStack = this.field_147002_h.func_75139_a(0).func_75211_c();
      if (paintableStack != null && paintableStack.func_77973_b() instanceof IPaintableItem) {
         ItemStack tempStack = paintableStack.func_77946_l();
         if (this.hoveringOver != null) {
            tempStack.func_77964_b(this.hoveringOver.ID);
         }

         PaintableType paintableType = ((IPaintableItem)paintableStack.func_77973_b()).GetPaintableType();
         EnumType eType = EnumType.getFromObject(paintableType);
         if (paintableType.GetModel() != null) {
            GL11.glPushMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(2896);
            GL11.glPushMatrix();
            GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
            RenderHelper.func_74519_b();
            GL11.glPopMatrix();
            GL11.glEnable(2977);
            GL11.glTranslatef(renderOrigin.x, renderOrigin.y, renderOrigin.z);
            GL11.glRotatef(160.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(20.0F, 0.0F, 1.0F, 0.0F);
            float scale = paintableType.GetRecommendedScale();
            GL11.glScalef(-scale, scale, scale);

            float dYaw;
            for(dYaw = this.modelAxes.getYaw() - this.prevModelAxes.getYaw(); dYaw > 180.0F; dYaw -= 360.0F) {
            }

            while(dYaw < -180.0F) {
               dYaw += 360.0F;
            }

            GL11.glRotatef(this.prevModelAxes.getYaw() + dYaw * RenderGun.smoothing, 0.0F, 1.0F, 0.0F);
            Paintjob paintjob = (Paintjob)paintableType.paintjobs.get(tempStack.func_77960_j());
            switch(eType) {
            case gun:
               GunType gunType = (GunType)paintableType;
               ClientProxy.gunRenderer.renderGun(tempStack, gunType, 0.0625F, gunType.model, GunAnimations.defaults, 0.0F, ItemRenderType.ENTITY);
               break;
            case attachment:
               this.field_146297_k.field_71446_o.func_110577_a(FlansModResourceHandler.getPaintjobTexture(paintjob));
               AttachmentType model = (AttachmentType)paintableType;
               GL11.glScalef(model.modelScale, model.modelScale, model.modelScale);
               ((ModelAttachment)paintableType.GetModel()).renderAttachment(0.0625F);
               break;
            case plane:
            case vehicle:
            case mecha:
               this.field_146297_k.field_71446_o.func_110577_a(FlansModResourceHandler.getPaintjobTexture(paintjob));
               ((ModelDriveable)paintableType.GetModel()).render((DriveableType)paintableType);
            }

            GL11.glPopMatrix();
         }
      }

   }

   private void drawModalRectWithCustomSizedTexture(int a, int b, int c, int d, int e, int f, int g, int h) {
      func_146110_a(a, b, (float)c, (float)d, e, f, (float)g, (float)h);
   }

   protected void func_146976_a(float f, int i, int j) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(2929);
      this.field_146297_k.field_71446_o.func_110577_a(texture);
      int textureX = 512;
      int textureY = 256;
      int xOrigin;
      int yOrigin;
      int numPaintjobs;
      int originY;
      int numDyes;
      if (this.customModeTransitionTimer <= 0.999F) {
         xOrigin = (this.field_146294_l - this.field_146999_f) / 2 + this.GetMainPageX();
         yOrigin = (this.field_146295_m - this.field_147000_g) / 2 + this.GetMainPageY();
         this.drawModalRectWithCustomSizedTexture(xOrigin, yOrigin, 0, 0, this.field_146999_f, 114, textureX, textureY);
         this.drawModalRectWithCustomSizedTexture(xOrigin, yOrigin + 122, 0, 114, this.field_146999_f, 142, textureX, textureY);
         ItemStack gunStack = this.field_147002_h.func_75139_a(0).func_75211_c();
         int originX;
         int s;
         if (gunStack != null && gunStack.func_77973_b() instanceof IPaintableItem) {
            PaintableType gunType = ((IPaintableItem)gunStack.func_77973_b()).GetPaintableType();
            numPaintjobs = gunType.paintjobs.size();
            originX = numPaintjobs / 9 + 1;

            for(originY = 0; originY < originX; ++originY) {
               for(s = 0; s < 9; ++s) {
                  if (9 * originY + s < numPaintjobs) {
                     Paintjob paintjob = (Paintjob)gunType.paintjobs.get(9 * originY + s);
                     ItemStack stack = gunStack.func_77946_l();
                     stack.func_77964_b(paintjob.ID);
                     field_146296_j.func_77015_a(this.field_146297_k.field_71466_p, this.field_146297_k.func_110434_K(), stack, xOrigin + 8 + s * 18, yOrigin + 130 + originY * 18);
                  }
               }
            }
         }

         if (this.hoveringOver != null) {
            numDyes = this.hoveringOver.dyesNeeded.length;
            if (numDyes != 0 && !this.inventory.field_70458_d.field_71075_bZ.field_75098_d) {
               boolean[] haveDyes = new boolean[numDyes];

               for(originX = 0; originX < numDyes; ++originX) {
                  originY = this.hoveringOver.dyesNeeded[originX].field_77994_a;

                  for(s = 0; s < this.inventory.func_70302_i_(); ++s) {
                     ItemStack stack = this.inventory.func_70301_a(s);
                     if (stack != null && stack.func_77973_b() == Items.field_151100_aR && stack.func_77960_j() == this.hoveringOver.dyesNeeded[originX].func_77960_j()) {
                        originY -= stack.field_77994_a;
                     }
                  }

                  if (originY <= 0) {
                     haveDyes[originX] = true;
                  }
               }

               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               GL11.glDisable(2896);
               this.field_146297_k.field_71446_o.func_110577_a(texture);
               originX = this.mouseX + 6;
               originY = this.mouseY - 20;
               if (numDyes == 1) {
                  this.drawModalRectWithCustomSizedTexture(originX, originY, haveDyes[0] ? 379 : 356, 0, 22, 22, textureX, textureY);
               } else {
                  this.drawModalRectWithCustomSizedTexture(originX, originY, 256, haveDyes[0] ? 23 : 0, 20, 22, textureX, textureY);

                  for(s = 1; s < numDyes - 1; ++s) {
                     this.drawModalRectWithCustomSizedTexture(originX + 2 + 18 * s, originY, 277, haveDyes[s] ? 23 : 0, 18, 22, textureX, textureY);
                  }

                  this.drawModalRectWithCustomSizedTexture(originX + 2 + 18 * (numDyes - 1), originY, 296, haveDyes[numDyes - 1] ? 23 : 0, 20, 22, textureX, textureY);
               }

               for(s = 0; s < numDyes; ++s) {
                  field_146296_j.func_77015_a(this.field_146297_k.field_71466_p, this.field_146297_k.func_110434_K(), this.hoveringOver.dyesNeeded[s], originX + 3 + s * 18, originY + 3);
                  field_146296_j.func_94148_a(this.field_146297_k.field_71466_p, this.field_146297_k.func_110434_K(), this.hoveringOver.dyesNeeded[s], originX + 3 + s * 18, originY + 3, (String)null);
               }
            }
         }
      }

      if (this.customModeTransitionTimer >= 0.001F) {
         this.field_146297_k.field_71446_o.func_110577_a(texture);
         xOrigin = (this.field_146294_l - this.field_146999_f) / 2 + this.GetCustomPageX() - 32;
         yOrigin = (this.field_146295_m - this.field_147000_g) / 2 + this.GetCustomPageY();
         this.drawModalRectWithCustomSizedTexture(xOrigin, yOrigin + 200, 224, 206, 288, 50, textureX, textureY);
         GL11.glDisable(3553);

         float blue;
         for(int x = 0; x < 18; ++x) {
            for(numDyes = 0; numDyes < 4; ++numDyes) {
               numPaintjobs = paletteColours[x][numDyes];
               blue = 0.00390625F;
               GL11.glColor3f(blue * (float)(numPaintjobs >> 16 & 255), blue * (float)(numPaintjobs >> 8 & 255), blue * (float)(numPaintjobs >> 0 & 255));
               this.drawModalRectWithCustomSizedTexture(xOrigin + 8 + 9 * x, yOrigin + 200 + 8 + 9 * numDyes, 0, 0, 7, 7, textureX, textureY);
            }
         }

         float scale = 0.00390625F;
         float red = scale * (float)(currentColour >> 16 & 255);
         float green = scale * (float)(currentColour >> 8 & 255);
         blue = scale * (float)(currentColour >> 0 & 255);
         GL11.glColor3f(red, green, blue);
         this.drawModalRectWithCustomSizedTexture(xOrigin + 172, yOrigin + 208, 0, 0, 34, 34, textureX, textureY);

         for(originY = 0; (float)originY < 68.0F; ++originY) {
            GL11.glColor3f((float)originY / 68.0F, green, blue);
            this.drawModalRectWithCustomSizedTexture(xOrigin + 212 + originY, yOrigin + 208, 0, 0, 1, 10, textureX, textureY);
         }

         for(originY = 0; (float)originY < 68.0F; ++originY) {
            GL11.glColor3f(red, (float)originY / 68.0F, blue);
            this.drawModalRectWithCustomSizedTexture(xOrigin + 212 + originY, yOrigin + 220, 0, 0, 1, 10, textureX, textureY);
         }

         for(originY = 0; (float)originY < 68.0F; ++originY) {
            GL11.glColor3f(red, green, (float)originY / 68.0F);
            this.drawModalRectWithCustomSizedTexture(xOrigin + 212 + originY, yOrigin + 232, 0, 0, 1, 10, textureX, textureY);
         }

         GL11.glEnable(3553);
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
         this.drawModalRectWithCustomSizedTexture(xOrigin + 212 + (int)(red * 68.0F), yOrigin + 207, 317, 21, 3, 12, textureX, textureY);
         this.drawModalRectWithCustomSizedTexture(xOrigin + 212 + (int)(green * 68.0F), yOrigin + 219, 317, 21, 3, 12, textureX, textureY);
         this.drawModalRectWithCustomSizedTexture(xOrigin + 212 + (int)(blue * 68.0F), yOrigin + 231, 317, 21, 3, 12, textureX, textureY);
      }

      GL11.glEnable(2929);
   }

   public void func_146274_d() {
      super.func_146274_d();
      this.mouseX = Mouse.getEventX() * this.field_146294_l / this.field_146297_k.field_71443_c;
      this.mouseY = this.field_146295_m - Mouse.getEventY() * this.field_146295_m / this.field_146297_k.field_71440_d - 1;
      int mouseXInGUI = this.mouseX - this.field_147003_i;
      int mouseYInGUI = this.mouseY - this.field_147009_r;
      this.hoveringOver = null;
      int blue;
      int y;
      if (this.inCustomMode) {
         int xOrigin = this.GetCustomPageX() - 32;
         int yOrigin = this.GetCustomPageY();

         for(blue = 0; blue < 18; ++blue) {
            for(y = 0; y < 4; ++y) {
               if (mouseXInGUI >= xOrigin + 8 + 9 * blue && mouseXInGUI < xOrigin + 15 + 9 * blue && mouseYInGUI >= yOrigin + 208 + 9 * y && mouseYInGUI < yOrigin + 215 + 9 * y) {
                  switch(Mouse.getEventButton()) {
                  case 0:
                     currentColour = paletteColours[blue][y];
                     break;
                  case 1:
                     paletteColours[blue][y] = currentColour;
                  }
               }
            }
         }

         if (Mouse.getEventButton() == 0 && Mouse.getEventButtonState()) {
            if (mouseXInGUI >= xOrigin + 212 && (float)mouseXInGUI < (float)(xOrigin + 212) + 68.0F && mouseYInGUI >= yOrigin + 208 && mouseYInGUI < yOrigin + 218) {
               blue = (int)((float)((mouseXInGUI - (xOrigin + 212)) * 255) / 68.0F);
               currentColour &= 65535;
               currentColour |= blue << 16;
            }

            if (mouseXInGUI >= xOrigin + 212 && (float)mouseXInGUI < (float)(xOrigin + 212) + 68.0F && mouseYInGUI >= yOrigin + 220 && mouseYInGUI < yOrigin + 230) {
               blue = (int)((float)((mouseXInGUI - (xOrigin + 212)) * 255) / 68.0F);
               currentColour &= 16711935;
               currentColour |= blue << 8;
            }

            if (mouseXInGUI >= xOrigin + 212 && (float)mouseXInGUI < (float)(xOrigin + 212) + 68.0F && mouseYInGUI >= yOrigin + 232 && mouseYInGUI < yOrigin + 242) {
               blue = (int)((float)((mouseXInGUI - (xOrigin + 212)) * 255) / 68.0F);
               currentColour &= 16776960;
               currentColour |= blue << 0;
            }
         }
      } else {
         ItemStack gunStack = this.field_147002_h.func_75139_a(0).func_75211_c();
         if (gunStack != null && gunStack.func_77973_b() instanceof IPaintableItem) {
            PaintableType paintableType = ((IPaintableItem)gunStack.func_77973_b()).GetPaintableType();
            blue = paintableType.paintjobs.size();
            y = blue / 9 + 1;

            for(int j = 0; j < y; ++j) {
               for(int i = 0; i < 9; ++i) {
                  if (9 * j + i < blue) {
                     Paintjob paintjob = (Paintjob)paintableType.paintjobs.get(9 * j + i);
                     ItemStack stack = gunStack.func_77946_l();

                     try {
                        stack.func_77978_p().func_74778_a("Paint", paintjob.iconName);
                     } catch (NullPointerException var13) {
                     }

                     int slotX = 7 + i * 18;
                     int slotY = 129 + j * 18;
                     if (mouseXInGUI >= slotX && mouseXInGUI < slotX + 18 && mouseYInGUI >= slotY && mouseYInGUI < slotY + 18) {
                        this.hoveringOver = paintjob;
                     }
                  }
               }
            }
         }
      }

   }

   protected void func_73864_a(int x, int y, int button) {
      super.func_73864_a(x, y, button);
      if (button == 0) {
         if (this.hoveringOver != null) {
            FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketGunPaint(this.hoveringOver.ID)));
            ((ContainerPaintjobTable)this.field_147002_h).clickPaintjob(this.hoveringOver.ID);
         }
      }
   }

   static {
      ResetPalette();
   }
}
