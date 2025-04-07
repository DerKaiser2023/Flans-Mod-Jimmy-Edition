package com.flansmod.client.gui;

import com.flansmod.client.FlansModResourceHandler;
import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.mechas.MechaType;
import com.flansmod.common.parts.ItemPart;
import com.flansmod.common.parts.PartType;
import com.flansmod.common.types.EnumType;
import cpw.mods.fml.client.FMLClientHandler;
import java.util.HashMap;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class GuiDriveableCrafting extends GuiScreen {
   private static final ResourceLocation texture = new ResourceLocation("flansmod", "gui/driveableCrafting.png");
   private InventoryPlayer inventory;
   private Minecraft mc;
   private World world;
   private int x;
   private int y;
   private int z;
   private static RenderItem itemRenderer = new RenderItem();
   private int guiOriginX;
   private int guiOriginY;
   private static int blueprintsScroll = 0;
   private int recipeScroll = 0;
   private static int selectedBlueprint = 0;
   private float spinner = 0.0F;
   private boolean canCraft = false;

   public GuiDriveableCrafting(InventoryPlayer playerinventory, World w, int i, int j, int k) {
      this.inventory = playerinventory;
      this.mc = FMLClientHandler.instance().getClient();
      this.world = w;
      this.x = i;
      this.y = j;
      this.z = k;
   }

   public void func_73866_w_() {
      super.func_73866_w_();
      this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 + 22, this.field_146295_m / 2 + 63, 40, 20, "Craft"));
   }

   protected void func_146284_a(GuiButton button) {
      if (button.field_146127_k == 0) {
         FlansMod.proxy.craftDriveable(this.inventory.field_70458_d, (DriveableType)DriveableType.types.get(selectedBlueprint));
      }

   }

   public void func_73863_a(int i, int j, float f) {
      ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
      int w = scaledresolution.func_78326_a();
      int h = scaledresolution.func_78328_b();
      this.func_146276_q_();
      GL11.glEnable(3042);
      this.mc.field_71446_o.func_110577_a(texture);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.guiOriginX = w / 2 - 88;
      this.guiOriginY = h / 2 - 99;
      this.func_73729_b(this.guiOriginX, this.guiOriginY, 0, 0, 176, 198);
      this.func_73731_b(this.field_146289_q, "Vehicle Crafting", this.guiOriginX + 6, this.guiOriginY + 6, 16777215);
      this.func_73731_b(this.field_146289_q, "Requires", this.guiOriginX + 6, this.guiOriginY + 125, 16777215);
      this.func_73731_b(this.field_146289_q, "Engine", this.guiOriginX + 114, this.guiOriginY + 141, 16777215);

      int r;
      for(int m = 0; m < 2; ++m) {
         for(int n = 0; n < 8; ++n) {
            r = blueprintsScroll * 8 + 8 * m + n;
            if (r == selectedBlueprint) {
               this.mc.field_71446_o.func_110577_a(texture);
               this.func_73729_b(this.guiOriginX + 8 + n * 18, this.guiOriginY + 18 + m * 18, 213, 11, 16, 16);
            }

            if (r < DriveableType.types.size()) {
               DriveableType type = (DriveableType)DriveableType.types.get(r);
               this.drawSlotInventory(new ItemStack(type.item), this.guiOriginX + 8 + n * 18, this.guiOriginY + 18 + m * 18);
            }
         }
      }

      ++this.spinner;
      if (selectedBlueprint < DriveableType.types.size()) {
         this.canCraft = true;
         DriveableType selectedType = (DriveableType)DriveableType.types.get(selectedBlueprint);
         if (selectedType != null) {
            GL11.glPushMatrix();
            GL11.glEnable(2929);
            GL11.glEnable(3008);
            GL11.glTranslatef((float)(w / 2 - 46), (float)(h / 2 - 10), 100.0F);
            if (selectedType instanceof MechaType) {
               GL11.glTranslatef(0.0F, 15.0F, 0.0F);
            }

            GL11.glScalef(-50.0F * selectedType.modelScale / selectedType.cameraDistance, 50.0F * selectedType.modelScale / selectedType.cameraDistance, 50.0F * selectedType.modelScale / selectedType.cameraDistance);
            GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(30.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(this.spinner / 5.0F, 0.0F, 1.0F, 0.0F);
            this.mc.field_71446_o.func_110577_a(FlansModResourceHandler.getTexture(selectedType));
            if (selectedType.model != null) {
               selectedType.model.render(selectedType);
            }

            GL11.glDisable(2929);
            GL11.glDisable(3008);
            GL11.glPopMatrix();
            if (selectedType.model == null) {
               this.func_73731_b(this.field_146289_q, "Model not found.", this.guiOriginX + 12, this.guiOriginY + 84, 16777215);
            }

            String recipeName = selectedType.name;
            if (recipeName.length() > 16) {
               recipeName = recipeName.substring(0, 15) + "...";
            }

            this.func_73731_b(this.field_146289_q, recipeName, this.guiOriginX + 82, this.guiOriginY + 64, 16777215);
            this.func_73731_b(this.field_146289_q, "Cargo Slots : " + selectedType.numCargoSlots, this.guiOriginX + 82, this.guiOriginY + 74, 16777215);
            this.func_73731_b(this.field_146289_q, "Bomb Slots : " + selectedType.numBombSlots, this.guiOriginX + 82, this.guiOriginY + 84, 16777215);
            this.func_73731_b(this.field_146289_q, "Passengers : " + selectedType.numPassengers, this.guiOriginX + 82, this.guiOriginY + 94, 16777215);
            this.func_73731_b(this.field_146289_q, "Guns : " + selectedType.ammoSlots(), this.guiOriginX + 82, this.guiOriginY + 104, 16777215);
            this.func_73731_b(this.field_146289_q, selectedType.numEngines() + "x", this.guiOriginX + 100, this.guiOriginY + 141, 16777215);
            InventoryPlayer temporaryInventory = new InventoryPlayer((EntityPlayer)null);
            temporaryInventory.func_70455_b(this.inventory);

            int c;
            for(r = 0; r < 3; ++r) {
               for(c = 0; c < 4; ++c) {
                  int recipeItemNumber = this.recipeScroll * 4 + r * 4 + c;
                  if (recipeItemNumber < selectedType.driveableRecipe.size()) {
                     ItemStack recipeStack = (ItemStack)selectedType.driveableRecipe.get(recipeItemNumber);
                     int totalAmountFound = 0;

                     for(int n = 0; n < temporaryInventory.func_70302_i_(); ++n) {
                        ItemStack stackInSlot = temporaryInventory.func_70301_a(n);
                        if (stackInSlot != null && recipeStack != null && stackInSlot.func_77973_b() == recipeStack.func_77973_b() && stackInSlot.func_77960_j() == recipeStack.func_77960_j()) {
                           int amountFound = Math.min(stackInSlot.field_77994_a, recipeStack.field_77994_a - totalAmountFound);
                           stackInSlot.field_77994_a -= amountFound;
                           if (stackInSlot.field_77994_a <= 0) {
                              stackInSlot = null;
                           }

                           temporaryInventory.func_70299_a(n, stackInSlot);
                           totalAmountFound += amountFound;
                           if (totalAmountFound == recipeStack.field_77994_a) {
                              break;
                           }
                        }
                     }

                     if (totalAmountFound < recipeStack.field_77994_a) {
                        this.mc.field_71446_o.func_110577_a(texture);
                        this.func_73729_b(this.guiOriginX + 8 + c * 18, this.guiOriginY + 138 + r * 18, 195, 11, 16, 16);
                        this.canCraft = false;
                     }

                     this.drawSlotInventory(recipeStack, this.guiOriginX + 8 + c * 18, this.guiOriginY + 138 + r * 18);
                  }
               }
            }

            HashMap<PartType, ItemStack> engines = new HashMap();

            ItemStack stackInSlot;
            for(c = 0; c < temporaryInventory.func_70302_i_(); ++c) {
               stackInSlot = temporaryInventory.func_70301_a(c);
               if (stackInSlot != null && stackInSlot.func_77973_b() instanceof ItemPart) {
                  PartType partType = ((ItemPart)stackInSlot.func_77973_b()).type;
                  if (partType.category == 2 && partType.worksWith.contains(EnumType.getFromObject(selectedType))) {
                     if (engines.containsKey(partType)) {
                        ItemStack var10000 = (ItemStack)engines.get(partType);
                        var10000.field_77994_a += stackInSlot.field_77994_a;
                     } else {
                        engines.put(partType, stackInSlot);
                     }
                  }
               }
            }

            float bestEngineSpeed = -1.0F;
            stackInSlot = null;
            Iterator var25 = engines.keySet().iterator();

            while(var25.hasNext()) {
               PartType part = (PartType)var25.next();
               if (part.engineSpeed > bestEngineSpeed && ((ItemStack)engines.get(part)).field_77994_a >= selectedType.numEngines()) {
                  bestEngineSpeed = part.engineSpeed;
                  stackInSlot = (ItemStack)engines.get(part);
               }
            }

            this.mc.field_71446_o.func_110577_a(texture);
            if (stackInSlot == null) {
               this.func_73729_b(this.guiOriginX + 152, this.guiOriginY + 138, 195, 11, 16, 16);
               this.canCraft = false;
            } else {
               this.drawSlotInventory(stackInSlot, this.guiOriginX + 152, this.guiOriginY + 138);
            }
         }

         if (!this.canCraft) {
            this.mc.field_71446_o.func_110577_a(texture);
            this.func_73729_b(this.guiOriginX + 108, this.guiOriginY + 160, 176, 28, 44, 24);
            this.func_73731_b(this.field_146289_q, "Craft", this.guiOriginX + 116, this.guiOriginY + 168, 10526880);
         } else {
            super.func_73863_a(i, j, f);
         }

      }
   }

   private void drawSlotInventory(ItemStack itemstack, int i, int j) {
      if (itemstack != null && itemstack.func_77973_b() != null) {
         itemRenderer.func_77015_a(this.field_146289_q, this.mc.field_71446_o, itemstack, i, j);
         itemRenderer.func_77021_b(this.field_146289_q, this.mc.field_71446_o, itemstack, i, j);
         GL11.glDisable(2896);
         GL11.glDisable(2929);
      }
   }

   protected void func_73869_a(char c, int i) {
      if (i == 1 || i == this.mc.field_71474_y.field_151445_Q.func_151463_i()) {
         this.mc.field_71439_g.func_71053_j();
      }

   }

   protected void func_73864_a(int i, int j, int k) {
      super.func_73864_a(i, j, k);
      int x = i - this.guiOriginX;
      int y = j - this.guiOriginY;
      if (k == 0 || k == 1) {
         for(int m = 0; m < 2; ++m) {
            for(int n = 0; n < 8; ++n) {
               if (x >= 8 + n * 18 && x <= 26 + n * 18 && y >= 18 + 18 * m && y <= 42 + 18 * m) {
                  selectedBlueprint = blueprintsScroll * 8 + m * 8 + n;
               }
            }
         }

         if (x >= 157 && x <= 167 && y >= 21 && y <= 31 && blueprintsScroll > 0) {
            --blueprintsScroll;
         }

         if (x >= 157 && x <= 167 && y >= 39 && y <= 49 && blueprintsScroll * 8 + 16 < DriveableType.types.size()) {
            ++blueprintsScroll;
         }

         if (selectedBlueprint >= DriveableType.types.size()) {
            return;
         }

         if (x >= 83 && x <= 93 && y >= 141 && y <= 151 && this.recipeScroll > 0) {
            --this.recipeScroll;
         }

         if (x >= 83 && x <= 93 && y >= 177 && y <= 187) {
            DriveableType selectedType = (DriveableType)DriveableType.types.get(selectedBlueprint);
            if (selectedType != null && this.recipeScroll * 4 + 12 < selectedType.driveableRecipe.size()) {
               ++this.recipeScroll;
            }
         }
      }

   }

   public boolean func_73868_f() {
      return false;
   }
}
