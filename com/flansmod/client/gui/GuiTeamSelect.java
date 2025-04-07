package com.flansmod.client.gui;

import com.flansmod.common.FlansMod;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketTeamSelect;
import com.flansmod.common.teams.PlayerClass;
import com.flansmod.common.teams.Team;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiTeamSelect extends GuiScreen {
   private static final ResourceLocation texture = new ResourceLocation("flansmod", "gui/teams.png");
   private static RenderItem itemRenderer = new RenderItem();
   private boolean classMenu;
   public static Team[] teamChoices;
   private PlayerClass[] classChoices;
   private int guiHeight;

   public GuiTeamSelect() {
      if (teamChoices == null) {
         FMLClientHandler.instance().getClient().func_147108_a((GuiScreen)null);
      } else {
         this.classMenu = false;
         this.guiHeight = 29 + 24 * teamChoices.length;
      }
   }

   public GuiTeamSelect(Team[] teams) {
      this.classMenu = false;
      teamChoices = teams;
      this.guiHeight = 29 + 24 * teams.length;
   }

   public GuiTeamSelect(PlayerClass[] classes) {
      this.classMenu = true;
      this.classChoices = classes;
      this.guiHeight = 29 + 24 * classes.length;
   }

   public void func_73866_w_() {
      super.func_73866_w_();
      int i;
      if (this.classMenu) {
         for(i = 0; i < this.classChoices.length; ++i) {
            if (this.classChoices[i] != null) {
               this.field_146292_n.add(new GuiButton(i, this.field_146294_l / 2 - 128 + 9, this.field_146295_m / 2 - this.guiHeight / 2 + 24 + 24 * i, 73, 20, this.classChoices[i].name));
            }
         }
      } else {
         if (teamChoices == null) {
            FMLClientHandler.instance().getClient().func_147108_a((GuiScreen)null);
            return;
         }

         for(i = 0; i < teamChoices.length; ++i) {
            if (teamChoices[i] != null) {
               this.field_146292_n.add(new GuiButton(i, this.field_146294_l / 2 - 128 + 10, this.field_146295_m / 2 - this.guiHeight / 2 + 24 + 24 * i, 236, 20, "§" + teamChoices[i].textColour + teamChoices[i].name));
            } else {
               this.field_146292_n.add(new GuiButton(i, this.field_146294_l / 2 - 128 + 10, this.field_146295_m / 2 - this.guiHeight / 2 + 24 + 24 * i, 236, 20, "No Team / Builder"));
            }
         }
      }

   }

   public void func_73863_a(int i, int j, float f) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_146297_k.field_71446_o.func_110577_a(texture);
      this.func_73729_b(this.field_146294_l / 2 - 128, this.field_146295_m / 2 - this.guiHeight / 2, 0, 0, 256, 22);
      this.func_73729_b(this.field_146294_l / 2 - 128, this.field_146295_m / 2 + this.guiHeight / 2 - 6, 0, 73, 256, 7);
      int n;
      if (this.classMenu) {
         for(n = 0; n < this.classChoices.length; ++n) {
            this.func_73729_b(this.field_146294_l / 2 - 128, this.field_146295_m / 2 - this.guiHeight / 2 + 22 + 24 * n, 0, 23, 256, 24);
         }
      } else {
         for(n = 0; n < teamChoices.length; ++n) {
            this.func_73729_b(this.field_146294_l / 2 - 128, this.field_146295_m / 2 - this.guiHeight / 2 + 22 + 24 * n, 0, 48, 256, 24);
         }
      }

      this.field_146289_q.func_78261_a(this.classMenu ? "Choose a Class" : "Choose a Team", this.field_146294_l / 2 - 120, this.field_146295_m / 2 - this.guiHeight / 2 + 8, 16777215);
      super.func_73863_a(i, j, f);
      if (this.classMenu) {
         for(n = 0; n < this.classChoices.length; ++n) {
            for(int m = 0; m < this.classChoices[n].startingItems.size(); ++m) {
               this.drawSlotInventory((ItemStack)this.classChoices[n].startingItems.get(m), this.field_146294_l / 2 - 128 + 85 + 18 * m, this.field_146295_m / 2 - this.guiHeight / 2 + 26 + 24 * n);
            }
         }
      }

   }

   protected void func_146284_a(GuiButton button) {
      if (this.classMenu) {
         FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketTeamSelect(this.classChoices[button.field_146127_k].shortName, true)));
      } else {
         FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketTeamSelect(teamChoices[button.field_146127_k] == null ? "null" : teamChoices[button.field_146127_k].shortName, false)));
      }

      Minecraft.func_71410_x().func_147108_a((GuiScreen)null);
   }

   private void drawSlotInventory(ItemStack itemstack, int i, int j) {
      itemRenderer.func_77015_a(this.field_146289_q, this.field_146297_k.field_71446_o, itemstack, i, j);
      itemRenderer.func_77021_b(this.field_146289_q, this.field_146297_k.field_71446_o, itemstack, i, j);
   }

   public boolean func_73868_f() {
      return false;
   }

   protected void func_73869_a(char c, int i) {
      if (i == 1 || i == this.field_146297_k.field_71474_y.field_151445_Q.func_151463_i()) {
         this.field_146297_k.field_71439_g.func_71053_j();
         if (this.classMenu) {
            if (this.classChoices != null && this.classChoices.length > 0) {
               FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketTeamSelect(this.classChoices[0].shortName, true)));
            }
         } else {
            FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketTeamSelect(Team.spectators.shortName, false)));
         }
      }

   }

   public void func_146281_b() {
   }
}
