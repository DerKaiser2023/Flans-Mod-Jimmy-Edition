package com.flansmod.client.gui;

import com.flansmod.common.guns.boxes.ContainerGunBox;
import com.flansmod.common.guns.boxes.GunBoxEntry;
import com.flansmod.common.guns.boxes.GunBoxType;
import com.flansmod.common.guns.boxes.GunPage;
import cpw.mods.fml.client.FMLClientHandler;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiGunBox extends GuiContainer {
   private ResourceLocation texture = new ResourceLocation("flansmod", "gui/weaponBoxDefault.png");
   private static RenderItem itemRenderer = new RenderItem();
   private InventoryPlayer inventory;
   private Minecraft mc = FMLClientHandler.instance().getClient();
   private GunPage currentPage;
   private GunBoxType type;
   private String recipeTooltip = null;
   private int mouseX;
   private int mouseY;
   private boolean tabToAmmo = false;
   private int hoverOver = -1;
   private int selectedItem = -1;
   private int selectedAmmoitem = -1;
   private int pageIndex = 0;
   private boolean craftHighlight = false;
   private boolean nextHighlight = false;
   private boolean backHighlight = false;

   public GuiGunBox(InventoryPlayer playerinventory, GunBoxType type, World w) {
      super(new ContainerGunBox(playerinventory, w));
      this.type = type;
      this.inventory = playerinventory;
      this.field_146999_f = 273;
      this.field_147000_g = 233;
      this.currentPage = (GunPage)type.gunPages.get(this.pageIndex);
   }

   protected void func_146979_b(int x, int y) {
      GunBoxEntry[] entries = this.currentPage.gunList;
      this.field_146289_q.func_78276_b(this.type.name, 7, 6, this.hexColor(this.type.gunBoxTextColor));
      this.field_146289_q.func_78261_a(this.currentPage.pageName, 62 - this.field_146289_q.func_78256_a(this.currentPage.pageName) / 2, 26, this.hexColor(this.type.pageTextColor));

      for(int i = 0; i < entries.length && i < 8; ++i) {
         if (entries[i] != null) {
            String label = entries[i].type.name;
            if (this.field_146289_q.func_78256_a(label) > 97) {
               label = label.substring(0, Math.min(label.length(), 15)) + "...";
            }

            this.field_146289_q.func_78276_b(label, 19, 46 + i * 12, this.hexColor(this.type.itemListTextColor));
         }
      }

      if (this.selectedItem != -1) {
         GunBoxEntry entry = entries[this.selectedItem];
         this.drawSlotInventory(new ItemStack(entry.type.getItem()), 127, 26);
         if (!entry.isAmmoNullOrEmpty()) {
            for(int i = 0; i < entry.ammoEntryList.size(); ++i) {
               this.drawSlotInventory(new ItemStack(((GunBoxEntry)entry.ammoEntryList.get(i)).type.getItem()), 155 + i * 22, 26);
            }
         }

         if (!this.tabToAmmo) {
            this.field_146289_q.func_78276_b(entry.type.name, 127, 52, this.hexColor(this.type.itemTextColor));
            this.drawRecipe(entry.requiredParts);
         } else if (!entry.isAmmoNullOrEmpty()) {
            this.field_146289_q.func_78276_b(((GunBoxEntry)entry.ammoEntryList.get(this.selectedAmmoitem)).type.name, 127, 52, this.hexColor(this.type.itemTextColor));
            this.drawRecipe(((GunBoxEntry)entry.ammoEntryList.get(this.selectedAmmoitem)).requiredParts);
         }

         if (this.craftHighlight) {
            this.field_146289_q.func_78261_a("Craft", 158 - this.field_146289_q.func_78256_a("Craft") / 2, 117, this.hexColor(this.type.buttonTextHoverColor));
         } else {
            this.field_146289_q.func_78261_a("Craft", 158 - this.field_146289_q.func_78256_a("Craft") / 2, 117, this.hexColor(this.type.buttonTextColor));
         }
      }

      if (this.nextHighlight) {
         this.field_146289_q.func_78261_a(">", 107 - this.field_146289_q.func_78256_a(">") / 2, 26, this.hexColor(this.type.buttonTextHoverColor));
      } else {
         this.field_146289_q.func_78261_a(">", 107 - this.field_146289_q.func_78256_a(">") / 2, 26, this.hexColor(this.type.buttonTextColor));
      }

      if (this.backHighlight) {
         this.field_146289_q.func_78261_a("<", 17 - this.field_146289_q.func_78256_a("<") / 2, 26, this.hexColor(this.type.buttonTextHoverColor));
      } else {
         this.field_146289_q.func_78261_a("<", 17 - this.field_146289_q.func_78256_a("<") / 2, 26, this.hexColor(this.type.buttonTextColor));
      }

      if (this.recipeTooltip != null) {
         this.drawHoveringText(Collections.singletonList(this.recipeTooltip), this.mouseX - this.field_147003_i, this.mouseY - this.field_147009_r, this.field_146289_q);
      }

   }

   protected void func_146976_a(float f, int i, int j) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      int xOrigin = (this.field_146294_l - this.field_146999_f) / 2;
      int yOrigin = (this.field_146295_m - this.field_147000_g) / 2;
      if (this.type.guiTexturePath != null) {
         this.texture = new ResourceLocation("flansmod", this.type.guiTexturePath + ".png");
      }

      this.mc.field_71446_o.func_110577_a(this.texture);
      this.func_73729_b(xOrigin, yOrigin, 0, 0, this.field_146999_f, this.field_147000_g);
      if (this.hoverOver != -1) {
         this.func_73729_b(xOrigin + 8, yOrigin + 43 + this.hoverOver * 12, 383, 5, 108, 12);
      }

      if (this.selectedItem != -1) {
         GunBoxEntry entry = this.currentPage.gunList[this.selectedItem];
         this.func_73729_b(xOrigin + 8, yOrigin + 43 + this.selectedItem * 12, 275, 5, 108, 12);
         this.func_73729_b(xOrigin + 121, yOrigin + 20, 275, 207, 144, 25);
         if (!this.tabToAmmo) {
            this.func_73729_b(xOrigin + 121, yOrigin + 45, 275, 17, 144, 95);
            this.func_73729_b(xOrigin + 127, yOrigin + 26, 419, 33, 16, 16);
         } else {
            this.func_73729_b(xOrigin + 121, yOrigin + 45, 275, 112, 144, 95);
         }

         if (!entry.isAmmoNullOrEmpty()) {
            for(int k = 0; k < entry.ammoEntryList.size(); ++k) {
               this.func_73729_b(xOrigin + 154 + k * 22, yOrigin + 25, 435, 17, 18, 18);
            }
         }

         if (this.craftHighlight) {
            this.func_73729_b(xOrigin + 126, yOrigin + 111, 419, 85, 64, 20);
         } else {
            this.func_73729_b(xOrigin + 126, yOrigin + 111, 419, 65, 64, 20);
         }
      }

      if (this.tabToAmmo && this.selectedAmmoitem != -1) {
         this.func_73729_b(xOrigin + 155 + this.selectedAmmoitem * 22, yOrigin + 26, 419, 17, 16, 16);
      }

      if (this.nextHighlight) {
         this.func_73729_b(xOrigin + 97, yOrigin + 20, 439, 105, 20, 20);
      } else {
         this.func_73729_b(xOrigin + 97, yOrigin + 20, 419, 105, 20, 20);
      }

      if (this.backHighlight) {
         this.func_73729_b(xOrigin + 7, yOrigin + 20, 439, 105, 20, 20);
      } else {
         this.func_73729_b(xOrigin + 7, yOrigin + 20, 419, 105, 20, 20);
      }

   }

   public void func_73729_b(int par1, int par2, int par3, int par4, int par5, int par6) {
      float f = 0.001953125F;
      float f1 = 0.00390625F;
      Tessellator tessellator = Tessellator.field_78398_a;
      tessellator.func_78382_b();
      tessellator.func_78374_a((double)par1, (double)(par2 + par6), (double)this.field_73735_i, (double)((float)par3 * f), (double)((float)(par4 + par6) * f1));
      tessellator.func_78374_a((double)(par1 + par5), (double)(par2 + par6), (double)this.field_73735_i, (double)((float)(par3 + par5) * f), (double)((float)(par4 + par6) * f1));
      tessellator.func_78374_a((double)(par1 + par5), (double)par2, (double)this.field_73735_i, (double)((float)(par3 + par5) * f), (double)((float)par4 * f1));
      tessellator.func_78374_a((double)par1, (double)par2, (double)this.field_73735_i, (double)((float)par3 * f), (double)((float)par4 * f1));
      tessellator.func_78381_a();
   }

   public void func_146274_d() {
      super.func_146274_d();
      this.mouseX = Mouse.getEventX() * this.field_146294_l / this.mc.field_71443_c;
      this.mouseY = this.field_146295_m - Mouse.getEventY() * this.field_146295_m / this.mc.field_71440_d - 1;
      int mouseXInGUI = this.mouseX - this.field_147003_i;
      int mouseYInGUI = this.mouseY - this.field_147009_r;
      this.hoverOver = -1;
      int sectionX = 8;

      int count;
      for(int i = 0; i < this.currentPage.gunList.length && i < 8; ++i) {
         count = 43 + i * 12;
         if (mouseXInGUI >= sectionX && mouseXInGUI < sectionX + 108 && mouseYInGUI >= count && mouseYInGUI < count + 12) {
            this.hoverOver = i;
         }
      }

      this.craftHighlight = mouseXInGUI >= 126 && mouseXInGUI < 189 && mouseYInGUI >= 111 && mouseYInGUI < 130;
      this.nextHighlight = mouseXInGUI >= 97 && mouseXInGUI < 116 && mouseYInGUI >= 20 && mouseYInGUI < 39;
      this.backHighlight = mouseXInGUI >= 7 && mouseXInGUI < 26 && mouseYInGUI >= 20 && mouseYInGUI < 39;
      this.recipeTooltip = null;
      if (this.selectedItem != -1) {
         GunBoxEntry entry = this.currentPage.gunList[this.selectedItem];
         count = !this.tabToAmmo ? entry.requiredParts.size() : ((GunBoxEntry)entry.ammoEntryList.get(this.selectedAmmoitem)).requiredParts.size();

         for(int i = 0; i < count; ++i) {
            int itemX = 127 + i * 19;
            int itemY = 68;
            if (i >= 4) {
               itemX = 127;
               itemY = 87;
            }

            if (mouseXInGUI >= itemX && mouseXInGUI < itemX + 16 && mouseYInGUI >= itemY && mouseYInGUI < itemY + 16) {
               this.recipeTooltip = !this.tabToAmmo ? ((ItemStack)entry.requiredParts.get(i)).func_82833_r() : ((ItemStack)((GunBoxEntry)entry.ammoEntryList.get(this.selectedAmmoitem)).requiredParts.get(i)).func_82833_r();
            }
         }
      }

   }

   protected void func_73864_a(int x, int y, int button) {
      int xOrigin = (this.field_146294_l - this.field_146999_f) / 2;
      int yOrigin = (this.field_146295_m - this.field_147000_g) / 2;
      super.func_73864_a(x, y, button);
      int m = x - xOrigin;
      int n = y - yOrigin;
      if (button == 0 || button == 1) {
         if (this.hoverOver != -1 && this.hoverOver < this.currentPage.gunList.length) {
            this.selectedItem = this.hoverOver;
            this.selectedAmmoitem = -1;
            this.tabToAmmo = false;
         }

         if (m >= 121 && m <= 148 && n >= 20 && n <= 44) {
            this.tabToAmmo = false;
         }

         if (this.backHighlight && this.type.gunPages.size() > 1) {
            if (this.pageIndex == 0) {
               this.pageIndex = this.type.gunPages.size() - 1;
            } else {
               --this.pageIndex;
            }

            this.resetAndSwapPages();
         }

         if (this.nextHighlight && this.type.gunPages.size() > 1) {
            if (this.pageIndex == this.type.gunPages.size() - 1) {
               this.pageIndex = 0;
            } else {
               ++this.pageIndex;
            }

            this.resetAndSwapPages();
         }

         if (this.selectedItem != -1 && !this.currentPage.gunList[this.selectedItem].isAmmoNullOrEmpty()) {
            for(int i = 0; i < this.currentPage.gunList[this.selectedItem].ammoEntryList.size(); ++i) {
               if (m >= 152 + i * 22 && m <= 173 + i * 22 && n >= 23 && n <= 44) {
                  this.tabToAmmo = true;
                  this.selectedAmmoitem = i;
               }
            }
         }

         if (this.craftHighlight) {
            if (this.selectedItem != -1 && !this.tabToAmmo) {
               this.type.block.buyGun(this.currentPage.gunList[this.selectedItem].type, this.inventory, this.type);
            }

            if (this.tabToAmmo && this.selectedAmmoitem != -1) {
               this.type.block.buyGun(((GunBoxEntry)this.currentPage.gunList[this.selectedItem].ammoEntryList.get(this.selectedAmmoitem)).type, this.inventory, this.type);
            }
         }
      }

      if (button == 0) {
         ;
      }
   }

   private void resetAndSwapPages() {
      this.selectedItem = -1;
      this.selectedAmmoitem = -1;
      this.tabToAmmo = false;
      this.currentPage = (GunPage)this.type.gunPages.get(this.pageIndex);
   }

   private void drawSlotInventory(ItemStack itemstack, int i, int j) {
      if (itemstack != null && itemstack.func_77973_b() != null) {
         RenderHelper.func_74520_c();
         itemRenderer.func_77015_a(this.field_146289_q, this.mc.field_71446_o, itemstack, i, j);
         itemRenderer.func_77021_b(this.field_146289_q, this.mc.field_71446_o, itemstack, i, j);
         GL11.glDisable(2896);
         GL11.glDisable(2929);
      }
   }

   private void drawRecipe(List<ItemStack> parts) {
      int i = 0;

      for(Iterator var3 = parts.iterator(); var3.hasNext(); ++i) {
         ItemStack stack = (ItemStack)var3.next();
         if (i < 4) {
            this.drawSlotInventory(stack, 127 + i * 19, 68);
         } else {
            this.drawSlotInventory(stack, 127 + (i - 4) * 19, 87);
         }
      }

   }

   private int hexColor(String color) {
      return Integer.parseInt(color, 16);
   }

   protected void func_73869_a(char c, int i) {
      if (i == 1 || i == this.mc.field_71474_y.field_151445_Q.func_151463_i()) {
         this.mc.field_71439_g.func_71053_j();
      }

   }

   public boolean func_73868_f() {
      return false;
   }
}
