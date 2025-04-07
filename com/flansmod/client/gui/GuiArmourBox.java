package com.flansmod.client.gui;

import com.flansmod.common.teams.ArmourBoxType;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiArmourBox extends GuiScreen {
   private static final ResourceLocation texture = new ResourceLocation("flansmod", "gui/armourBox.png");
   private InventoryPlayer inventory;
   private Minecraft mc;
   private static RenderItem itemRenderer = new RenderItem();
   private ArmourBoxType type;
   private int page;
   private int guiOriginX;
   private int guiOriginY;
   private int scroll;

   public GuiArmourBox(InventoryPlayer playerinventory, ArmourBoxType type) {
      this.inventory = playerinventory;
      this.mc = FMLClientHandler.instance().getClient();
      this.type = type;
      this.page = 0;
   }

   public void func_73876_c() {
      super.func_73876_c();
      ++this.scroll;
   }

   public void func_73863_a(int i, int j, float f) {
      ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
      int k = scaledresolution.func_78326_a();
      int l = scaledresolution.func_78328_b();
      FontRenderer fontrenderer = this.mc.field_71466_p;
      this.func_146276_q_();
      GL11.glEnable(3042);
      this.mc.field_71446_o.func_110577_a(texture);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      int m = this.guiOriginX = k / 2 - 88;
      int n = this.guiOriginY = l / 2 - 91;
      this.func_73729_b(m, n, 0, 0, 176, 182);
      this.func_73732_a(this.field_146289_q, this.type.name, k / 2, n + 5, 16777215);
      this.mc.field_71446_o.func_110577_a(texture);
      if (this.page == 0) {
         this.func_73729_b(m + 77, n + 87, 176, 0, 10, 10);
      }

      if (this.page >= this.type.pages.size() - 1) {
         this.func_73729_b(m + 89, n + 87, 186, 0, 10, 10);
      }

      RenderHelper.func_74520_c();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glEnable(32826);
      OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0F, 240.0F);
      this.drawRecipe(fontrenderer, m, n, this.page);

      int col;
      for(col = 0; col < 3; ++col) {
         for(int col = 0; col < 9; ++col) {
            this.drawSlotInventory(this.inventory.func_70301_a(col + (col + 1) * 9), m + 8 + col * 18, n + 100 + col * 18);
         }
      }

      for(col = 0; col < 9; ++col) {
         this.drawSlotInventory(this.inventory.func_70301_a(col), m + 8 + col * 18, n + 158);
      }

      GL11.glDisable(3042);
   }

   private void drawRecipe(FontRenderer fontrenderer, int m, int n, int q) {
      ArmourBoxType.ArmourBoxEntry page = (ArmourBoxType.ArmourBoxEntry)this.type.pages.get(q);
      if (page != null) {
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

         for(int i = 0; i < 2; ++i) {
            for(int j = 0; j < 2; ++j) {
               this.drawSlotInventory(new ItemStack(page.armours[i * 2 + j].item), m + 9 + 83 * i, n + 44 + 22 * j);
               int numParts = page.requiredStacks[i * 2 + j].size();
               int startPart = 0;
               if (numParts >= 4) {
                  startPart = this.scroll / 40 % (numParts - 2);
               }

               for(int p = 0; p < (numParts < 3 ? numParts : 3); ++p) {
                  this.drawSlotInventory((ItemStack)page.requiredStacks[i * 2 + j].get(startPart + p), m + 30 + p * 19 + 83 * i, n + 44 + 22 * j);
               }
            }
         }

         RenderHelper.func_74518_a();
         this.func_73732_a(fontrenderer, page.name, m + 87, n + 25, 16777215);
         RenderHelper.func_74520_c();
      }

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

   protected void func_73864_a(int i, int j, int k) {
      super.func_73864_a(i, j, k);
      int m = i - this.guiOriginX;
      int n = j - this.guiOriginY;
      if (k == 0 || k == 1) {
         if (m > 77 && m < 87 && n > 87 && n < 97 && this.page > 0) {
            --this.page;
         }

         if (m > 89 && m < 99 && n > 87 && n < 97 && this.page < this.type.pages.size() - 1) {
            ++this.page;
         }

         for(int x = 0; x < 2; ++x) {
            for(int y = 0; y < 2; ++y) {
               if (((ArmourBoxType.ArmourBoxEntry)this.type.pages.get(this.page)).armours[x * 2 + y] != null && m > 7 + 83 * x && m < 27 + 83 * x && n > 42 + 22 * y && n < 62 + 22 * y) {
                  this.type.block.buyArmour(((ArmourBoxType.ArmourBoxEntry)this.type.pages.get(this.page)).shortName, x * 2 + y, this.inventory);
               }
            }
         }
      }

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
