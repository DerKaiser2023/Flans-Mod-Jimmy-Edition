package com.flansmod.client;

import com.flansmod.client.gui.GuiDriveableController;
import com.flansmod.client.gui.GuiTeamScores;
import com.flansmod.client.model.RenderFlag;
import com.flansmod.client.model.RenderGun;
import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.driveables.DriveableData;
import com.flansmod.common.driveables.DriveablePart;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntityPlane;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.driveables.EntityVehicle;
import com.flansmod.common.driveables.EnumDriveablePart;
import com.flansmod.common.driveables.mechas.EntityMecha;
import com.flansmod.common.guns.AttachmentType;
import com.flansmod.common.guns.EntityBullet;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.network.PacketTeamInfo;
import com.flansmod.common.teams.ItemTeamArmour;
import com.flansmod.common.teams.TeamsManager;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.vector.Vector3f;
import com.flansmod.common.vector.Vector3i;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import cpw.mods.fml.relauncher.Side;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MouseHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.EnumSkyBlock;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class TickHandlerClient {
   public static final ResourceLocation offHand = new ResourceLocation("flansmod", "gui/offHand.png");
   public static ArrayList<Vector3i> blockLightOverrides = new ArrayList();
   public static ArrayList<Vector3i> vehicleLightOverrides = new ArrayList();
   public static int lightOverrideRefreshRate = 5;
   public static int vehicleLightOverrideRefreshRate = 1;
   int tickcount = 0;
   int tickcountflash = 0;
   int tickcountWounded = 0;
   boolean isInFlash;
   int flashTime;
   EntityPlayer entityPlayerFlash;
   private static GuiScreen guiDriveableController = null;
   private static RenderItem itemRenderer = new RenderItem();
   private static List<TickHandlerClient.KillMessage> killMessages = new ArrayList();

   public TickHandlerClient() {
      FMLCommonHandler.instance().bus().register(this);
      MinecraftForge.EVENT_BUS.register(this);
   }

   @SubscribeEvent
   public void eventHandler(MouseEvent event) {
      EntityPlayer player = Minecraft.func_71410_x().field_71439_g;
      if (player.func_71045_bC() != null && player.func_71045_bC().func_77973_b() instanceof ItemGun && ((ItemGun)player.func_71045_bC().func_77973_b()).type.oneHanded && Keyboard.isKeyDown(Minecraft.func_71410_x().field_71474_y.field_74311_E.func_151463_i()) && Math.abs(event.dwheel) > 0) {
         event.setCanceled(true);
      }

   }

   @SubscribeEvent
   public void eventHandler(RenderGameOverlayEvent event) {
      Minecraft mc = Minecraft.func_71410_x();
      if (Keyboard.isKeyDown(Minecraft.func_71410_x().field_71474_y.field_74311_E.func_151463_i())) {
         ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, FMLClientHandler.instance().getClient().field_71460_t, 1, new String[]{"cameraZoom", "af", "field_78503_V"});
      }

      if (event.type == ElementType.CROSSHAIRS && mc.field_71439_g != null && mc.field_71439_g.func_70694_bm() != null && mc.field_71439_g.func_70694_bm().func_77973_b() instanceof ItemGun && (!((ItemGun)mc.field_71439_g.func_70694_bm().func_77973_b()).type.showCrosshair || FlansModClient.currentScope != null)) {
         event.setCanceled(true);
      } else {
         ScaledResolution scaledresolution = new ScaledResolution(FlansModClient.minecraft, FlansModClient.minecraft.field_71443_c, FlansModClient.minecraft.field_71440_d);
         int i = scaledresolution.func_78326_a();
         int j = scaledresolution.func_78328_b();
         Tessellator tessellator = Tessellator.field_78398_a;
         ItemStack currentStack;
         if (!event.isCancelable() && event.type == ElementType.HELMET) {
            String overlayTexture = null;
            if (FlansModClient.currentScope != null && FlansModClient.currentScope.hasZoomOverlay() && FMLClientHandler.instance().getClient().field_71462_r == null && FlansModClient.zoomProgress > 0.8F) {
               overlayTexture = FlansModClient.currentScope.getZoomOverlay();
            } else if (mc.field_71439_g != null) {
               currentStack = mc.field_71439_g.field_71071_by.field_70460_b[3];
               if (currentStack != null && currentStack.func_77973_b() instanceof ItemTeamArmour) {
                  overlayTexture = ((ItemTeamArmour)currentStack.func_77973_b()).type.overlay;
               }
            }

            if (overlayTexture != null) {
               FlansModClient.minecraft.field_71460_t.func_78478_c();
               GL11.glEnable(3042);
               GL11.glDisable(2929);
               GL11.glDepthMask(false);
               GL11.glBlendFunc(770, 771);
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               GL11.glDisable(3008);
               mc.field_71446_o.func_110577_a(FlansModResourceHandler.getScope(overlayTexture));
               tessellator.func_78382_b();
               tessellator.func_78374_a((double)(i / 2 - 2 * j), (double)j, -90.0D, 0.0D, 1.0D);
               tessellator.func_78374_a((double)(i / 2 + 2 * j), (double)j, -90.0D, 1.0D, 1.0D);
               tessellator.func_78374_a((double)(i / 2 + 2 * j), 0.0D, -90.0D, 1.0D, 0.0D);
               tessellator.func_78374_a((double)(i / 2 - 2 * j), 0.0D, -90.0D, 0.0D, 0.0D);
               tessellator.func_78381_a();
               GL11.glDepthMask(true);
               GL11.glEnable(2929);
               GL11.glEnable(3008);
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            }
         }

         if (!event.isCancelable() && event.type == ElementType.HOTBAR && FlansMod.bulletGuiEnable) {
            int x;
            ItemStack offHandStack;
            int healthP;
            if (mc.field_71439_g != null) {
               ItemStack stack = mc.field_71439_g.field_71071_by.func_70448_g();
               if (stack != null && stack.func_77973_b() instanceof ItemGun) {
                  ItemGun gunItem = (ItemGun)stack.func_77973_b();
                  GunType gunType = gunItem.type;
                  x = 0;

                  for(int n = 0; n < gunType.getNumAmmoItemsInGun(stack); ++n) {
                     offHandStack = ((ItemGun)stack.func_77973_b()).getBulletItemStack(stack, n);
                     if (offHandStack != null && offHandStack.func_77973_b() != null && offHandStack.func_77960_j() < offHandStack.func_77958_k()) {
                        RenderHelper.func_74520_c();
                        GL11.glEnable(32826);
                        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0F, 240.0F);
                        this.drawSlotInventory(mc.field_71466_p, offHandStack, i / 2 + 16 + x, j - 65);
                        GL11.glDisable(32826);
                        RenderHelper.func_74518_a();
                        String s = offHandStack.func_77958_k() - offHandStack.func_77960_j() + "/" + offHandStack.func_77958_k();
                        if (gunType.submode.length >= 2) {
                           s = s + "[" + gunType.getFireMode(stack) + "]";
                        }

                        if (offHandStack.func_77958_k() == 1) {
                           s = "";
                        }

                        mc.field_71466_p.func_78276_b(s, i / 2 + 32 + x, j - 59, 0);
                        mc.field_71466_p.func_78276_b(s, i / 2 + 33 + x, j - 60, 16777215);
                        x += 16 + mc.field_71466_p.func_78256_a(s);
                     }
                  }

                  PlayerData data = PlayerHandler.getPlayerData((EntityPlayer)mc.field_71439_g, Side.CLIENT);
                  if (gunType.oneHanded && data.offHandGunSlot != 0) {
                     offHandStack = mc.field_71439_g.field_71071_by.func_70301_a(data.offHandGunSlot - 1);
                     if (offHandStack != null && offHandStack.func_77973_b() instanceof ItemGun) {
                        GunType offHandGunType = ((ItemGun)offHandStack.func_77973_b()).type;
                        x = 0;

                        for(healthP = 0; healthP < offHandGunType.getNumAmmoItemsInGun(offHandStack); ++healthP) {
                           ItemStack bulletStack = ((ItemGun)offHandStack.func_77973_b()).getBulletItemStack(offHandStack, healthP);
                           if (bulletStack != null && bulletStack.func_77973_b() != null && bulletStack.func_77960_j() < bulletStack.func_77958_k()) {
                              String s = bulletStack.func_77958_k() - bulletStack.func_77960_j() + "/" + bulletStack.func_77958_k();
                              if (gunType.submode.length >= 2) {
                                 s = s + "[" + gunType.getFireMode(offHandStack) + "]";
                              }

                              if (bulletStack.func_77958_k() == 1) {
                                 s = "";
                              }

                              RenderHelper.func_74520_c();
                              GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                              GL11.glEnable(32826);
                              OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0F, 240.0F);
                              this.drawSlotInventory(mc.field_71466_p, bulletStack, i / 2 - 32 - x, j - 65);
                              x += 16 + mc.field_71466_p.func_78256_a(s);
                              GL11.glDisable(32826);
                              RenderHelper.func_74518_a();
                              mc.field_71466_p.func_78276_b(s, i / 2 - 16 - x, j - 59, 0);
                              mc.field_71466_p.func_78276_b(s, i / 2 - 17 - x, j - 60, 16777215);
                           }
                        }
                     }
                  }
               }
            }

            PacketTeamInfo teamInfo = FlansModClient.teamInfo;
            if (teamInfo != null && FlansModClient.minecraft.field_71439_g != null && (PacketTeamInfo.numTeams > 0 || !PacketTeamInfo.sortedByTeam) && PacketTeamInfo.getPlayerScoreData(FlansModClient.minecraft.field_71439_g.func_70005_c_()) != null) {
               GL11.glEnable(3042);
               GL11.glDisable(2929);
               GL11.glDepthMask(false);
               GL11.glBlendFunc(770, 771);
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               GL11.glDisable(3008);
               mc.field_71446_o.func_110577_a(GuiTeamScores.texture);
               tessellator.func_78382_b();
               tessellator.func_78374_a((double)(i / 2 - 43), 27.0D, -90.0D, 0.33203125D, 0.10546875D);
               tessellator.func_78374_a((double)(i / 2 + 43), 27.0D, -90.0D, 0.66796875D, 0.10546875D);
               tessellator.func_78374_a((double)(i / 2 + 43), 0.0D, -90.0D, 0.66796875D, 0.0D);
               tessellator.func_78374_a((double)(i / 2 - 43), 0.0D, -90.0D, 0.33203125D, 0.0D);
               tessellator.func_78381_a();
               int secondsLeft;
               if (PacketTeamInfo.numTeams == 2 && PacketTeamInfo.sortedByTeam) {
                  secondsLeft = PacketTeamInfo.teamData[0].team.teamColour;
                  GL11.glColor4f((float)(secondsLeft >> 16 & 255) / 256.0F, (float)(secondsLeft >> 8 & 255) / 256.0F, (float)(secondsLeft & 255) / 256.0F, 1.0F);
                  tessellator.func_78382_b();
                  tessellator.func_78374_a((double)(i / 2 - 43), 27.0D, -90.0D, 0.0D, 0.48828125D);
                  tessellator.func_78374_a((double)(i / 2 - 19), 27.0D, -90.0D, 0.09375D, 0.48828125D);
                  tessellator.func_78374_a((double)(i / 2 - 19), 0.0D, -90.0D, 0.09375D, 0.3828125D);
                  tessellator.func_78374_a((double)(i / 2 - 43), 0.0D, -90.0D, 0.0D, 0.3828125D);
                  tessellator.func_78381_a();
                  secondsLeft = PacketTeamInfo.teamData[1].team.teamColour;
                  GL11.glColor4f((float)(secondsLeft >> 16 & 255) / 256.0F, (float)(secondsLeft >> 8 & 255) / 256.0F, (float)(secondsLeft & 255) / 256.0F, 1.0F);
                  tessellator.func_78382_b();
                  tessellator.func_78374_a((double)(i / 2 + 19), 27.0D, -90.0D, 0.2421875D, 0.48828125D);
                  tessellator.func_78374_a((double)(i / 2 + 43), 27.0D, -90.0D, 0.3359375D, 0.48828125D);
                  tessellator.func_78374_a((double)(i / 2 + 43), 0.0D, -90.0D, 0.3359375D, 0.3828125D);
                  tessellator.func_78374_a((double)(i / 2 + 19), 0.0D, -90.0D, 0.2421875D, 0.3828125D);
                  tessellator.func_78381_a();
                  GL11.glDepthMask(true);
                  GL11.glEnable(2929);
                  GL11.glEnable(3008);
                  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                  mc.field_71466_p.func_78276_b(PacketTeamInfo.teamData[0].score + "", i / 2 - 35, 9, 0);
                  mc.field_71466_p.func_78276_b(PacketTeamInfo.teamData[0].score + "", i / 2 - 36, 8, 16777215);
                  mc.field_71466_p.func_78276_b(PacketTeamInfo.teamData[1].score + "", i / 2 + 35 - mc.field_71466_p.func_78256_a(PacketTeamInfo.teamData[1].score + ""), 9, 0);
                  mc.field_71466_p.func_78276_b(PacketTeamInfo.teamData[1].score + "", i / 2 + 34 - mc.field_71466_p.func_78256_a(PacketTeamInfo.teamData[1].score + ""), 8, 16777215);
               }

               mc.field_71466_p.func_78276_b(PacketTeamInfo.gametype + "", i / 2 + 48, 9, 0);
               mc.field_71466_p.func_78276_b(PacketTeamInfo.gametype + "", i / 2 + 47, 8, 16777215);
               mc.field_71466_p.func_78276_b(PacketTeamInfo.map + "", i / 2 - 47 - mc.field_71466_p.func_78256_a(PacketTeamInfo.map + ""), 9, 0);
               mc.field_71466_p.func_78276_b(PacketTeamInfo.map + "", i / 2 - 48 - mc.field_71466_p.func_78256_a(PacketTeamInfo.map + ""), 8, 16777215);
               secondsLeft = PacketTeamInfo.timeLeft / 20;
               int minutesLeft = secondsLeft / 60;
               secondsLeft %= 60;
               String timeLeft = minutesLeft + ":" + (secondsLeft < 10 ? "0" + secondsLeft : secondsLeft);
               mc.field_71466_p.func_78276_b(timeLeft, i / 2 - mc.field_71466_p.func_78256_a(timeLeft) / 2 - 1, 29, 0);
               mc.field_71466_p.func_78276_b(timeLeft, i / 2 - mc.field_71466_p.func_78256_a(timeLeft) / 2, 30, 16777215);
               GL11.glDepthMask(true);
               GL11.glEnable(2929);
               GL11.glEnable(3008);
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               String playerUsername = FlansModClient.minecraft.field_71439_g.func_70005_c_();
               mc.field_71466_p.func_78276_b(PacketTeamInfo.getPlayerScoreData(playerUsername).score + "", i / 2 - 7, 1, 0);
               mc.field_71466_p.func_78276_b(PacketTeamInfo.getPlayerScoreData(playerUsername).kills + "", i / 2 - 7, 9, 0);
               mc.field_71466_p.func_78276_b(PacketTeamInfo.getPlayerScoreData(playerUsername).deaths + "", i / 2 - 7, 17, 0);
            }

            Iterator var27 = killMessages.iterator();

            TickHandlerClient.KillMessage killMessage;
            while(var27.hasNext()) {
               killMessage = (TickHandlerClient.KillMessage)var27.next();
               mc.field_71466_p.func_78276_b("§" + killMessage.killerName + "     §" + killMessage.killedName, i - mc.field_71466_p.func_78256_a(killMessage.killerName + "     " + killMessage.killedName) - 6, j - 32 - killMessage.line * 16, 16777215);
            }

            RenderHelper.func_74520_c();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(32826);
            OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0F, 240.0F);
            var27 = killMessages.iterator();

            while(var27.hasNext()) {
               killMessage = (TickHandlerClient.KillMessage)var27.next();
               this.drawSlotInventory(mc.field_71466_p, new ItemStack(killMessage.weapon.item), i - mc.field_71466_p.func_78256_a("     " + killMessage.killedName) - 12, j - 36 - killMessage.line * 16);
            }

            GL11.glDisable(3042);
            RenderHelper.func_74518_a();
            mc.field_71446_o.func_110577_a(offHand);
            currentStack = mc.field_71439_g.field_71071_by.func_70448_g();
            PlayerData data = PlayerHandler.getPlayerData((EntityPlayer)mc.field_71439_g, Side.CLIENT);
            if (currentStack != null && currentStack.func_77973_b() instanceof ItemGun && ((ItemGun)currentStack.func_77973_b()).type.oneHanded) {
               for(x = 0; x < 9; ++x) {
                  if (data.offHandGunSlot == x + 1) {
                     tessellator.func_78382_b();
                     tessellator.func_78374_a((double)(i / 2 - 88 + 20 * x), (double)(j - 3), -90.0D, 0.25D, 0.5D);
                     tessellator.func_78374_a((double)(i / 2 - 72 + 20 * x), (double)(j - 3), -90.0D, 0.5D, 0.5D);
                     tessellator.func_78374_a((double)(i / 2 - 72 + 20 * x), (double)(j - 19), -90.0D, 0.5D, 0.0D);
                     tessellator.func_78374_a((double)(i / 2 - 88 + 20 * x), (double)(j - 19), -90.0D, 0.25D, 0.0D);
                     tessellator.func_78381_a();
                  } else if (data.isValidOffHandWeapon(mc.field_71439_g, x + 1)) {
                     tessellator.func_78382_b();
                     tessellator.func_78374_a((double)(i / 2 - 88 + 20 * x), (double)(j - 3), -90.0D, 0.0D, 0.5D);
                     tessellator.func_78374_a((double)(i / 2 - 72 + 20 * x), (double)(j - 3), -90.0D, 0.25D, 0.5D);
                     tessellator.func_78374_a((double)(i / 2 - 72 + 20 * x), (double)(j - 19), -90.0D, 0.25D, 0.0D);
                     tessellator.func_78374_a((double)(i / 2 - 88 + 20 * x), (double)(j - 19), -90.0D, 0.0D, 0.0D);
                     tessellator.func_78381_a();
                  }
               }
            }

            if (EntityBullet.hitCrossHair) {
               this.tickcount = 20;
               EntityBullet.hitCrossHair = false;
            }

            EntityPlayer player = Minecraft.func_71410_x().field_71439_g;
            ItemStack currentHeldItem = player.func_71045_bC();
            if (this.tickcount > 0 && FlansMod.hitCrossHairEnable && currentHeldItem != null && currentHeldItem.func_77973_b() instanceof ItemGun) {
               offHandStack = mc.field_71439_g.field_71071_by.func_70448_g();
               ItemGun gunItem = (ItemGun)offHandStack.func_77973_b();
               GunType gunType = gunItem.type;
               FlansModClient.minecraft.field_71460_t.func_78478_c();
               GL11.glEnable(3042);
               GL11.glDisable(2929);
               GL11.glDepthMask(false);
               GL11.glBlendFunc(770, 771);
               GL11.glColor4f(FlansMod.hitCrossHairColor[1], FlansMod.hitCrossHairColor[2], FlansMod.hitCrossHairColor[3], FlansMod.hitCrossHairColor[0] * (float)this.tickcount / 20.0F);
               GL11.glDisable(3008);
               if (gunType.hitTexture != null) {
                  mc.field_71446_o.func_110577_a(FlansModResourceHandler.getAuxiliaryTexture(gunType.hitTexture));
               } else if (FlansMod.hdHitCrosshair) {
                  mc.field_71446_o.func_110577_a(new ResourceLocation("flansmod", "gui/HDCrossHair.png"));
               } else {
                  mc.field_71446_o.func_110577_a(new ResourceLocation("flansmod", "gui/CrossHair.png"));
               }

               tessellator.func_78382_b();
               tessellator.func_78374_a((double)(i / 2 - 2 * j), (double)j, -90.0D, 0.0D, 1.0D);
               tessellator.func_78374_a((double)(i / 2 + 2 * j), (double)j, -90.0D, 1.0D, 1.0D);
               tessellator.func_78374_a((double)(i / 2 + 2 * j), 0.0D, -90.0D, 1.0D, 0.0D);
               tessellator.func_78374_a((double)(i / 2 - 2 * j), 0.0D, -90.0D, 0.0D, 0.0D);
               tessellator.func_78381_a();
               GL11.glDepthMask(true);
               GL11.glEnable(2929);
               GL11.glEnable(3008);
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            }

            if (mc.field_71439_g.field_70737_aN > 0) {
               this.tickcountWounded = 40;
            }

            if (this.tickcountWounded > 0) {
               FlansModClient.minecraft.field_71460_t.func_78478_c();
               GL11.glEnable(3042);
               GL11.glDisable(2929);
               GL11.glDepthMask(false);
               GL11.glBlendFunc(770, 771);
               GL11.glColor4f(FlansMod.hitCrossHairColor[1], FlansMod.hitCrossHairColor[2], FlansMod.hitCrossHairColor[3], FlansMod.hitCrossHairColor[0] * (float)this.tickcountWounded / 20.0F);
               GL11.glDisable(3008);
               mc.field_71446_o.func_110577_a(new ResourceLocation("flansmod", "gui/Blood.png"));
               tessellator.func_78382_b();
               tessellator.func_78374_a((double)(i / 2 - 2 * j), (double)j, -90.0D, 0.0D, 1.0D);
               tessellator.func_78374_a((double)(i / 2 + 2 * j), (double)j, -90.0D, 1.0D, 1.0D);
               tessellator.func_78374_a((double)(i / 2 + 2 * j), 0.0D, -90.0D, 1.0D, 0.0D);
               tessellator.func_78374_a((double)(i / 2 - 2 * j), 0.0D, -90.0D, 0.0D, 0.0D);
               tessellator.func_78381_a();
               GL11.glDepthMask(true);
               GL11.glEnable(2929);
               GL11.glEnable(3008);
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            }

            if (mc.field_71439_g.field_70154_o instanceof EntitySeat) {
               EntityDriveable ent = ((EntitySeat)mc.field_71439_g.field_70154_o).driveable;
               float speed = (float)(ent.field_70159_w * ent.field_70159_w + ent.field_70181_x * ent.field_70181_x + ent.field_70179_y * ent.field_70179_y);
               healthP = (int)((float)((DriveablePart)ent.getDriveableData().parts.get(EnumDriveablePart.core)).health / (float)((DriveablePart)ent.getDriveableData().parts.get(EnumDriveablePart.core)).maxHealth * 100.0F);
               int colour = false;
               int colour;
               if (healthP > 75) {
                  colour = 16777215;
               } else if (healthP < 75 && healthP > 50) {
                  colour = 65280;
               } else if (healthP < 50 && healthP > 25) {
                  colour = 14329120;
               } else {
                  colour = 16711680;
               }

               mc.field_71466_p.func_78276_b(String.format("Throttle : %.0f%%", ent.throttle * 100.0F), 2, 2, 16777215);
               mc.field_71466_p.func_78276_b("Health : " + healthP + "%", 2, 12, colour);
               mc.field_71466_p.func_78276_b(String.format("Speed : %.2f", Math.sqrt((double)speed)), 2, 22, 16777215);
               mc.field_71466_p.func_78276_b(String.format("Diving Throttle : %.0f%%", ent.divingFactor * 100.0F), 2, 32, 16777215);
               mc.field_71466_p.func_78276_b(String.format("Yaw : %.0f%%", ((EntitySeat)mc.field_71439_g.field_70154_o).looking.getYaw()), 122, 2, 16777215);
               mc.field_71466_p.func_78276_b(String.format("Gun Pitch : %.0f%%", ((EntitySeat)mc.field_71439_g.field_70154_o).looking.getPitch()), 122, 12, 16777215);
               if (ent instanceof EntityPlane) {
                  if (ent.getDriveableType().hasFlare) {
                     if (ent.ticksFlareUsing <= 0 && ent.flareDelay <= 0) {
                        mc.field_71466_p.func_78276_b("Flare : READY", 2, 42, 65280);
                     }

                     if (ent.ticksFlareUsing > 0) {
                        mc.field_71466_p.func_78276_b("Flare : Deploying", 2, 52, 16711680);
                     }

                     if (ent.flareDelay > 0) {
                        mc.field_71466_p.func_78276_b("Flare : Reloading", 2, 62, 14329120);
                     }
                  }

                  Vector3f up2 = (Vector3f)ent.axes.getYAxis().normalise();
                  mc.field_71466_p.func_78276_b(String.format("Plane Pitch : " + -1.0F * ent.axes.getPitch()), 122, 22, 16777215);
                  mc.field_71466_p.func_78276_b(String.format("Altitude : " + ((EntitySeat)mc.field_71439_g.field_70154_o).field_70163_u), 122, 32, 16777215);
               }

               if (ent instanceof EntityVehicle) {
                  DriveableData datavehicle = ((EntityVehicle)ent).getDriveableData();
                  if (ent.getDriveableType().hasFlare) {
                     if (ent.ticksFlareUsing <= 0 && ent.flareDelay <= 0) {
                        mc.field_71466_p.func_78276_b("Smoke : READY", 2, 32, 65280);
                     }

                     if (ent.ticksFlareUsing > 0) {
                        mc.field_71466_p.func_78276_b("Smoke : Deploying", 2, 42, 16711680);
                     }

                     if (ent.flareDelay > 0) {
                        mc.field_71466_p.func_78276_b("Smoke : Reloading", 2, 52, 14329120);
                     }
                  }

                  DriveableType allah = ((EntityVehicle)ent).getVehicleType();
                  if (mc.field_71439_g != null) {
                     ItemStack stack = mc.field_71439_g.field_71071_by.field_70460_b[3];
                     String overlayTexture = null;
                     if (allah.hasScope && ent.aiming) {
                        overlayTexture = allah.overlay;
                        ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, FMLClientHandler.instance().getClient().field_71460_t, allah.gunsightZoom, new String[]{"cameraZoom", "af", "field_78503_V"});
                        if (allah.nightScope) {
                           player.func_70690_d(new PotionEffect(Potion.field_76439_r.field_76415_H, 60));
                        }
                     }

                     if (allah.hasScope && !ent.aiming) {
                        overlayTexture = null;
                        ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, FMLClientHandler.instance().getClient().field_71460_t, 1, new String[]{"cameraZoom", "af", "field_78503_V"});
                     }

                     if (overlayTexture != null) {
                        FlansModClient.minecraft.field_71460_t.func_78478_c();
                        GL11.glEnable(3042);
                        GL11.glDisable(2929);
                        GL11.glDepthMask(false);
                        GL11.glBlendFunc(770, 771);
                        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                        GL11.glDisable(3008);
                        mc.field_71446_o.func_110577_a(FlansModResourceHandler.getScope(overlayTexture));
                        tessellator.func_78382_b();
                        tessellator.func_78374_a((double)(i / 2 - 2 * j), (double)j, -90.0D, 0.0D, 1.0D);
                        tessellator.func_78374_a((double)(i / 2 + 2 * j), (double)j, -90.0D, 1.0D, 1.0D);
                        tessellator.func_78374_a((double)(i / 2 + 2 * j), 0.0D, -90.0D, 1.0D, 0.0D);
                        tessellator.func_78374_a((double)(i / 2 - 2 * j), 0.0D, -90.0D, 0.0D, 0.0D);
                        tessellator.func_78381_a();
                        GL11.glDepthMask(true);
                        GL11.glEnable(2929);
                        GL11.glEnable(3008);
                        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                     }
                  }

                  if (((EntityVehicle)ent).getVehicleType().canDive) {
                     if (!((EntityVehicle)ent).getVehicleType().unlimitedOxygen) {
                        mc.field_71466_p.func_78276_b("Oxygen (Seconds) : " + ent.oxygenMeter / 160.0F, 2, 42, colour);
                     }

                     if (((EntityVehicle)ent).getVehicleType().unlimitedOxygen) {
                        mc.field_71466_p.func_78276_b("Unlimited Oxygen", 2, 42, colour);
                     }

                     mc.field_71466_p.func_78276_b("Depth : " + datavehicle.depth, 2, 52, colour);
                     if ((double)(datavehicle.depth / -allah.maxDepth) > 0.7D) {
                        mc.field_71466_p.func_78276_b("WARNING : Aproaching Max Depth", 2, 62, 14329120);
                     }

                     if ((double)(datavehicle.depth / -allah.maxDepth) > 0.9D) {
                        mc.field_71466_p.func_78276_b("DANGER : COLLAPSE IMMINENT", 2, 72, 16711680);
                     }
                  }

                  if (((EntityVehicle)ent).getDriveableType().showReload) {
                     if (datavehicle.fakeReloadShell > 40.0F) {
                        mc.field_71466_p.func_78276_b("First Shot Delay (Seconds) : " + (datavehicle.fakeReloadShell - 20.0F) / 20.0F, 2, 62, 14329120);
                     }

                     if (datavehicle.fakeReloadMissile > 40.0F) {
                        mc.field_71466_p.func_78276_b("First Shot Delay (Seconds) : " + (datavehicle.fakeReloadMissile - 20.0F) / 20.0F, 2, 72, 14329120);
                     }
                  }

                  if (((EntityVehicle)ent).getVehicleType().shootWithOpenDoor) {
                     if (((EntityVehicle)ent).varDoor) {
                        mc.field_71466_p.func_78276_b("Weapon : READY", 2, 62, 65280);
                        mc.field_71466_p.func_78276_b("[" + Keyboard.getKeyName(KeyInputHandler.doorKey.func_151463_i()) + " to disable]", 100, 62, 65280);
                     }

                     if (!((EntityVehicle)ent).varDoor) {
                        mc.field_71466_p.func_78276_b("Weapon : DISABLED", 2, 62, 16711680);
                        mc.field_71466_p.func_78276_b("[" + Keyboard.getKeyName(KeyInputHandler.doorKey.func_151463_i()) + " to activate]", 100, 62, 16711680);
                     }
                  }
               }

               if (FlansMod.DEBUG) {
                  mc.field_71466_p.func_78276_b("MotionX : " + ent.field_70159_w, 2, 32, 16777215);
                  mc.field_71466_p.func_78276_b("MotionY : " + ent.field_70181_x, 2, 42, 16777215);
                  mc.field_71466_p.func_78276_b("MotionZ : " + ent.field_70179_y, 2, 52, 16777215);
                  mc.field_71466_p.func_78276_b("Break Blocks : " + TeamsManager.driveablesBreakBlocks, 2, 62, 16777215);
               }
            }
         }

      }
   }

   @SubscribeEvent
   public void renderTick(RenderTickEvent event) {
      switch(event.phase) {
      case START:
         RenderGun.smoothing = event.renderTickTime;
         this.renderTickStart(Minecraft.func_71410_x(), event.renderTickTime);
         break;
      case END:
         this.renderTickEnd(Minecraft.func_71410_x());
      }

   }

   @SubscribeEvent
   public void clientTick(ClientTickEvent event) {
      switch(event.phase) {
      case START:
         this.clientTickStart(Minecraft.func_71410_x());
         break;
      case END:
         this.clientTickEnd(Minecraft.func_71410_x());
      }

   }

   public void clientTickStart(Minecraft mc) {
      if (this.tickcount > 0) {
         --this.tickcount;
      }

      if (this.tickcountWounded > 0) {
         --this.tickcountWounded;
      }

      Iterator var2;
      Vector3i v;
      if (FlansMod.ticker % lightOverrideRefreshRate == 0 && mc.field_71441_e != null) {
         lightOverrideRefreshRate = mc.field_71474_y.field_74347_j ? 10 : 20;
         var2 = blockLightOverrides.iterator();

         while(var2.hasNext()) {
            v = (Vector3i)var2.next();
            mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, v.x, v.y, v.z);
         }

         blockLightOverrides.clear();
         var2 = mc.field_71441_e.field_73010_i.iterator();

         label177:
         while(true) {
            EntityPlayer player;
            GunType type;
            int i;
            MovingObjectPosition ray;
            int k;
            int xd;
            int yd;
            int zd;
            do {
               ItemStack currentHeldItem;
               do {
                  do {
                     Object obj;
                     if (!var2.hasNext()) {
                        var2 = mc.field_71441_e.field_72996_f.iterator();

                        while(true) {
                           EntityBullet bullet;
                           do {
                              while(true) {
                                 if (!var2.hasNext()) {
                                    break label177;
                                 }

                                 obj = var2.next();
                                 if (obj instanceof EntityBullet) {
                                    bullet = (EntityBullet)obj;
                                    break;
                                 }

                                 if (obj instanceof EntityMecha) {
                                    EntityMecha mecha = (EntityMecha)obj;
                                    int x = MathHelper.func_76128_c(mecha.field_70165_t);
                                    int y = MathHelper.func_76128_c(mecha.field_70163_u);
                                    int z = MathHelper.func_76128_c(mecha.field_70161_v);
                                    if (mecha.lightLevel() > 0) {
                                       blockLightOverrides.add(new Vector3i(x, y, z));
                                       mc.field_71441_e.func_72915_b(EnumSkyBlock.Block, x, y, z, Math.max(mc.field_71441_e.func_72957_l(x, y, z), mecha.lightLevel()));
                                       mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x + 1, y, z);
                                       mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x - 1, y + 1, z);
                                       mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x, y + 1, z);
                                       mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x, y - 1, z);
                                       mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x, y, z + 1);
                                       mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x, y, z - 1);
                                    }

                                    if (mecha.forceDark()) {
                                       for(i = -3; i <= 3; ++i) {
                                          for(int j = -3; j <= 3; ++j) {
                                             for(k = -3; k <= 3; ++k) {
                                                xd = i + x;
                                                yd = j + y;
                                                zd = k + z;
                                                blockLightOverrides.add(new Vector3i(xd, yd, zd));
                                                mc.field_71441_e.func_72915_b(EnumSkyBlock.Sky, xd, yd, zd, Math.abs(i) + Math.abs(j) + Math.abs(k));
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           } while(!bullet.field_70128_L && bullet.type.hasLight);

                           if (bullet.field_70128_L && bullet.type.hasLight) {
                           }
                        }
                     }

                     obj = var2.next();
                     player = (EntityPlayer)obj;
                     currentHeldItem = player.func_71045_bC();
                  } while(currentHeldItem == null);
               } while(!(currentHeldItem.func_77973_b() instanceof ItemGun));

               type = ((ItemGun)currentHeldItem.func_77973_b()).type;
               AttachmentType grip = type.getGrip(currentHeldItem);
               if (grip != null && grip.flashlight) {
                  for(i = 0; i < 2; ++i) {
                     ray = player.func_70614_a((double)(grip.flashlightRange / 2.0F * (float)(i + 1)), 1.0F);
                     if (ray != null) {
                        k = ray.field_72311_b;
                        xd = ray.field_72312_c;
                        yd = ray.field_72309_d;
                        zd = ray.field_72310_e;
                        switch(zd) {
                        case 0:
                           --xd;
                           break;
                        case 1:
                           ++xd;
                           break;
                        case 2:
                           --yd;
                           break;
                        case 3:
                           ++yd;
                           break;
                        case 4:
                           --k;
                           break;
                        case 5:
                           ++k;
                        }

                        blockLightOverrides.add(new Vector3i(k, xd, yd));
                        mc.field_71441_e.func_72915_b(EnumSkyBlock.Block, k, xd, yd, 12);
                        mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, k, xd + 1, yd);
                        mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, k, xd - 1, yd);
                        mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, k + 1, xd, yd);
                        mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, k - 1, xd, yd);
                        mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, k, xd, yd + 1);
                        mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, k, xd, yd - 1);
                     }
                  }
               }
            } while(!type.matchlock);

            for(i = 0; i < 2; ++i) {
               ray = player.func_70614_a((double)(2.0F * (float)(i + 1)), 1.0F);
               if (ray != null) {
                  k = ray.field_72311_b;
                  xd = ray.field_72312_c;
                  yd = ray.field_72309_d;
                  zd = ray.field_72310_e;
                  switch(zd) {
                  case 0:
                     --xd;
                     break;
                  case 1:
                     ++xd;
                     break;
                  case 2:
                     --yd;
                     break;
                  case 3:
                     ++yd;
                     break;
                  case 4:
                     --k;
                     break;
                  case 5:
                     ++k;
                  }

                  blockLightOverrides.add(new Vector3i(k, xd, yd));
                  mc.field_71441_e.func_72915_b(EnumSkyBlock.Block, k, xd, yd, 12);
                  mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, k, xd + 1, yd);
                  mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, k, xd - 1, yd);
                  mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, k + 1, xd, yd);
                  mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, k - 1, xd, yd);
                  mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, k, xd, yd + 1);
                  mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, k, xd, yd - 1);
               }
            }
         }
      }

      if (FlansMod.ticker % vehicleLightOverrideRefreshRate == 0 && mc.field_71441_e != null) {
         vehicleLightOverrideRefreshRate = mc.field_71474_y.field_74347_j ? 1 : 2;
         var2 = vehicleLightOverrides.iterator();

         while(var2.hasNext()) {
            v = (Vector3i)var2.next();
            mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, v.x, v.y, v.z);
         }

         vehicleLightOverrides.clear();
      }

   }

   public void clientTickEnd(Minecraft minecraft) {
      for(int i = 0; i < killMessages.size(); ++i) {
         --((TickHandlerClient.KillMessage)killMessages.get(i)).timer;
         if (((TickHandlerClient.KillMessage)killMessages.get(i)).timer == 0) {
            killMessages.remove(i);
         }
      }

      RenderFlag.angle += 2.0F;
      FlansModClient.tick();
   }

   public void renderTickStart(Minecraft mc, float smoothing) {
      if (mc.field_71462_r == null && FlansModClient.controlModeMouse) {
         MouseHelper mouse = mc.field_71417_B;
         Entity ridden = mc.field_71439_g.field_70154_o;
         if (ridden instanceof EntityDriveable) {
            EntityDriveable entity = (EntityDriveable)ridden;
            entity.onMouseMoved(mouse.field_74377_a, mouse.field_74375_b);
         }
      }

      FlansModClient.renderTick(smoothing);
      if (mc.field_71462_r instanceof GuiDriveableController) {
         guiDriveableController = mc.field_71462_r;
         mc.field_71462_r = null;
      } else {
         guiDriveableController = null;
      }

   }

   public void renderTickEnd(Minecraft mc) {
      if (mc.field_71462_r == null && guiDriveableController != null) {
         mc.field_71462_r = guiDriveableController;
         guiDriveableController = null;
      }

      Tessellator tessellator = Tessellator.field_78398_a;
      ScaledResolution scaledresolution = new ScaledResolution(FlansModClient.minecraft, FlansModClient.minecraft.field_71443_c, FlansModClient.minecraft.field_71440_d);
      int i = scaledresolution.func_78326_a();
      int j = scaledresolution.func_78328_b();
      if (FlansModClient.isInFlash) {
         this.isInFlash = true;
         this.flashTime = FlansModClient.flashTime;
         this.tickcountflash = 0;
         FlansModClient.isInFlash = false;
         FlansModClient.flashTime = 0;
      }

      if (this.isInFlash && this.tickcountflash < this.flashTime) {
         FlansModClient.minecraft.field_71460_t.func_78478_c();
         GL11.glEnable(3042);
         GL11.glDisable(2929);
         GL11.glDepthMask(false);
         GL11.glBlendFunc(770, 771);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glDisable(3008);
         mc.field_71446_o.func_110577_a(new ResourceLocation("flansmod", "gui/flash.png"));
         tessellator.func_78382_b();
         tessellator.func_78374_a((double)(i / 2 - 2 * j), (double)j, -90.0D, 0.0D, 1.0D);
         tessellator.func_78374_a((double)(i / 2 + 2 * j), (double)j, -90.0D, 1.0D, 1.0D);
         tessellator.func_78374_a((double)(i / 2 + 2 * j), 0.0D, -90.0D, 1.0D, 0.0D);
         tessellator.func_78374_a((double)(i / 2 - 2 * j), 0.0D, -90.0D, 0.0D, 0.0D);
         tessellator.func_78381_a();
         GL11.glDepthMask(true);
         GL11.glEnable(2929);
         GL11.glEnable(3008);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         ++this.tickcountflash;
      } else {
         this.isInFlash = false;
         this.flashTime = 0;
         this.tickcountflash = 0;
      }

   }

   private void drawSlotInventory(FontRenderer fontRenderer, ItemStack itemstack, int i, int j) {
      if (itemstack != null && itemstack.func_77973_b() != null) {
         itemRenderer.func_77015_a(fontRenderer, FlansModClient.minecraft.field_71446_o, itemstack, i, j);
         itemRenderer.func_77021_b(fontRenderer, FlansModClient.minecraft.field_71446_o, itemstack, i, j);
      }
   }

   public static void addKillMessage(boolean headshot, InfoType infoType, String killer, String killed) {
      Iterator var4 = killMessages.iterator();

      while(var4.hasNext()) {
         TickHandlerClient.KillMessage killMessage = (TickHandlerClient.KillMessage)var4.next();
         ++killMessage.line;
         if (killMessage.line > 10) {
            killMessage.timer = 0;
         }
      }

      killMessages.add(new TickHandlerClient.KillMessage(headshot, infoType, killer, killed));
   }

   private static class KillMessage {
      public String killerName;
      public String killedName;
      public InfoType weapon;
      public int timer;
      public int line;
      public boolean headshot;

      public KillMessage(boolean head, InfoType infoType, String killer, String killed) {
         this.headshot = head;
         this.killerName = killer;
         this.killedName = killed;
         this.weapon = infoType;
         this.line = 0;
         this.timer = 200;
      }
   }
}
