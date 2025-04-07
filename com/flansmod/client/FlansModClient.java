package com.flansmod.client;

import com.flansmod.api.IControllable;
import com.flansmod.client.gui.GuiDriveableController;
import com.flansmod.client.gui.GuiTeamScores;
import com.flansmod.client.model.GunAnimations;
import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.IScope;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.network.PacketTeamInfo;
import com.flansmod.common.teams.Team;
import com.flansmod.common.types.InfoType;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.particle.EntityAuraFX;
import net.minecraft.client.particle.EntityBlockDustFX;
import net.minecraft.client.particle.EntityBreakingFX;
import net.minecraft.client.particle.EntityBubbleFX;
import net.minecraft.client.particle.EntityCloudFX;
import net.minecraft.client.particle.EntityCritFX;
import net.minecraft.client.particle.EntityDiggingFX;
import net.minecraft.client.particle.EntityDropParticleFX;
import net.minecraft.client.particle.EntityEnchantmentTableParticleFX;
import net.minecraft.client.particle.EntityExplodeFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.client.particle.EntityFishWakeFX;
import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.client.particle.EntityFootStepFX;
import net.minecraft.client.particle.EntityHeartFX;
import net.minecraft.client.particle.EntityHugeExplodeFX;
import net.minecraft.client.particle.EntityLargeExplodeFX;
import net.minecraft.client.particle.EntityLavaFX;
import net.minecraft.client.particle.EntityNoteFX;
import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.client.particle.EntityReddustFX;
import net.minecraft.client.particle.EntitySmokeFX;
import net.minecraft.client.particle.EntitySnowShovelFX;
import net.minecraft.client.particle.EntitySpellParticleFX;
import net.minecraft.client.particle.EntitySplashFX;
import net.minecraft.client.particle.EntitySuspendFX;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.RenderPlayerEvent.Pre;
import net.minecraftforge.client.event.RenderPlayerEvent.Specials.Post;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Property;
import org.lwjgl.opengl.GL11;

public class FlansModClient extends FlansMod {
   public static boolean doneTutorial = false;
   public static boolean controlModeMouse = true;
   public static int controlModeSwitchTimer = 20;
   public static int shootTimeLeft;
   public static int shootTimeRight;
   public static float playerRecoilPitch;
   public static float playerRecoilYaw;
   public static float antiRecoilPitch;
   public static float antiRecoilYaw;
   public static int scopeTime;
   public static IScope currentScope = null;
   public static float zoomProgress = 0.0F;
   public static float lastZoomProgress = 0.0F;
   public static float stanceProgress = 0.0F;
   public static float lastStanceProgress = 0.0F;
   public static float lastZoomLevel = 1.0F;
   public static float lastFOVZoomLevel = 1.0F;
   public static float originalMouseSensitivity = 0.5F;
   public static float originalFOV = 90.0F;
   public static int originalThirdPerson = 0;
   public static boolean inPlane = false;
   public static PacketTeamInfo teamInfo;
   public static int teamsScoreGUILock = 0;
   public static AimType aimType;
   public static FlanMouseButton fireButton;
   public static FlanMouseButton aimButton;
   public static float fov;
   public static Minecraft minecraft = FMLClientHandler.instance().getClient();

   public void load() {
      log("Loading Flan's mod client side.");
      MinecraftForge.EVENT_BUS.register(this);
   }

   @SubscribeEvent
   public void renderOffHandGun(Post event) {
      RenderPlayer renderer = event.renderer;
      EntityPlayer player = event.entityPlayer;
      float dt = event.partialRenderTick;
      PlayerData data = PlayerHandler.getPlayerData(player, Side.CLIENT);
      ItemStack gunStack = null;
      if (player instanceof EntityOtherPlayerMP) {
         gunStack = data.offHandGunStack;
      } else {
         ItemStack currentStack = player.func_71045_bC();
         if (currentStack == null || !(currentStack.func_77973_b() instanceof ItemGun) || !((ItemGun)currentStack.func_77973_b()).type.oneHanded || data.offHandGunSlot == 0) {
            return;
         }

         gunStack = player.field_71071_by.func_70301_a(data.offHandGunSlot - 1);
      }

      if (gunStack != null && gunStack.func_77973_b() instanceof ItemGun) {
         GunType gunType = ((ItemGun)gunStack.func_77973_b()).type;
         GL11.glPushMatrix();
         renderer.field_77109_a.field_78113_g.func_78794_c(0.0625F);
         GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
         float f2 = 1.0F;
         GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
         GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         GL11.glScalef(-f2, -f2, f2);
         int k = gunStack.func_77973_b().func_82790_a(gunStack, 0);
         float f11 = (float)(k >> 16 & 255) / 255.0F;
         float f12 = (float)(k >> 8 & 255) / 255.0F;
         float f3 = (float)(k & 255) / 255.0F;
         GL11.glColor4f(f11, f12, f3, 1.0F);
         ClientProxy.gunRenderer.renderOffHandGun(player, gunStack);
         GL11.glPopMatrix();
      }
   }

   private float interpolateRotation(float x, float y, float dT) {
      float f3;
      for(f3 = y - x; f3 < -180.0F; f3 += 360.0F) {
      }

      while(f3 >= 180.0F) {
         f3 -= 360.0F;
      }

      return x + dT * f3;
   }

   @SubscribeEvent
   public void renderLiving(Pre event) {
      PlayerData data = PlayerHandler.getPlayerData(event.entityPlayer, Side.CLIENT);
      if (FlansMod.DEBUG && data != null && data.snapshots[0] != null) {
         data.snapshots[0].renderSnapshot();
      }

      RendererLivingEntity.NAME_TAG_RANGE = 64.0F;
      RendererLivingEntity.NAME_TAG_RANGE_SNEAK = 32.0F;
      if (event.entity instanceof EntityPlayer && teamInfo != null) {
         PacketTeamInfo var10000 = teamInfo;
         if (PacketTeamInfo.gametype != null) {
            PacketTeamInfo var10001 = teamInfo;
            if (!"No Gametype".equals(PacketTeamInfo.gametype)) {
               var10000 = teamInfo;
               PacketTeamInfo.PlayerScoreData rendering = PacketTeamInfo.getPlayerScoreData(event.entity.func_70005_c_());
               var10000 = teamInfo;
               PacketTeamInfo.PlayerScoreData thePlayer = PacketTeamInfo.getPlayerScoreData(minecraft.field_71439_g.func_70005_c_());
               Team renderingTeam = rendering == null ? Team.spectators : rendering.team.team;
               Team thePlayerTeam = thePlayer == null ? Team.spectators : thePlayer.team.team;
               if (data.skin == null) {
                  data.skin = ((AbstractClientPlayer)event.entityPlayer).func_110306_p();
               }

               if (data.skin != null) {
                  ResourceLocation skin = rendering != null && rendering.playerClass != null ? FlansModResourceHandler.getTexture(rendering.playerClass) : null;
                  ((AbstractClientPlayer)event.entityPlayer).func_152121_a(Type.SKIN, skin == null ? data.skin : skin);
               }

               if (thePlayerTeam == Team.spectators) {
                  return;
               }

               if (renderingTeam == Team.spectators) {
                  event.setCanceled(true);
                  return;
               }

               if (renderingTeam != thePlayerTeam) {
                  RendererLivingEntity.NAME_TAG_RANGE = 0.0F;
                  RendererLivingEntity.NAME_TAG_RANGE_SNEAK = 0.0F;
                  return;
               }

               var10000 = teamInfo;
               if (!PacketTeamInfo.sortedByTeam) {
                  RendererLivingEntity.NAME_TAG_RANGE = 0.0F;
                  RendererLivingEntity.NAME_TAG_RANGE_SNEAK = 0.0F;
               }
            }
         }
      }

   }

   public static int shootTime(boolean left) {
      return left ? shootTimeLeft : shootTimeRight;
   }

   public static void tick() {
      if (minecraft.field_71439_g != null && minecraft.field_71441_e != null) {
         if (minecraft.field_71439_g.field_70154_o instanceof IControllable && minecraft.field_71462_r == null) {
            minecraft.func_147108_a(new GuiDriveableController((IControllable)minecraft.field_71439_g.field_70154_o));
         }

         if (teamInfo != null) {
            PacketTeamInfo var10000 = teamInfo;
            if (PacketTeamInfo.timeLeft > 0) {
               var10000 = teamInfo;
               --PacketTeamInfo.timeLeft;
            }
         }

         if (teamsScoreGUILock > 0) {
            --teamsScoreGUILock;
            if (minecraft.field_71462_r == null) {
               minecraft.func_147108_a(new GuiTeamScores());
            }
         }

         if (shootTimeLeft > 0) {
            --shootTimeLeft;
         }

         if (shootTimeRight > 0) {
            --shootTimeRight;
         }

         if (scopeTime > 0) {
            --scopeTime;
         }

         if (playerRecoilPitch > 0.0F) {
            playerRecoilPitch *= 0.8F;
         }

         EntityClientPlayerMP var11 = minecraft.field_71439_g;
         var11.field_70125_A -= playerRecoilPitch;
         var11 = minecraft.field_71439_g;
         var11.field_70177_z -= playerRecoilYaw;
         antiRecoilPitch += playerRecoilPitch;
         antiRecoilYaw += playerRecoilYaw;
         var11 = minecraft.field_71439_g;
         var11.field_70125_A += antiRecoilPitch * 0.2F;
         var11 = minecraft.field_71439_g;
         var11.field_70177_z += antiRecoilYaw * 0.2F;
         antiRecoilPitch *= 0.8F;
         antiRecoilYaw *= 0.8F;
         Iterator var0 = gunAnimationsRight.values().iterator();

         GunAnimations g;
         while(var0.hasNext()) {
            g = (GunAnimations)var0.next();
            g.update();
         }

         var0 = gunAnimationsLeft.values().iterator();

         while(var0.hasNext()) {
            g = (GunAnimations)var0.next();
            g.update();
         }

         var0 = minecraft.field_71441_e.field_73010_i.iterator();

         while(true) {
            while(true) {
               EntityPlayer player;
               ItemStack currentItem;
               do {
                  do {
                     if (!var0.hasNext()) {
                        Item itemInHand = null;
                        ItemStack itemstackInHand = minecraft.field_71439_g.field_71071_by.func_70448_g();
                        if (itemstackInHand != null) {
                           itemInHand = itemstackInHand.func_77973_b();
                        }

                        if (currentScope != null && (itemInHand == null || !(itemInHand instanceof ItemGun) || ((ItemGun)itemInHand).type.getCurrentScope(itemstackInHand) != currentScope)) {
                           currentScope = null;
                           minecraft.field_71474_y.field_74334_X = originalFOV;
                           minecraft.field_71474_y.field_74341_c = originalMouseSensitivity;
                           minecraft.field_71474_y.field_74320_O = originalThirdPerson;
                        }

                        lastZoomProgress = zoomProgress;
                        if (currentScope == null) {
                           zoomProgress *= 0.66F;
                        } else {
                           zoomProgress = 1.0F - (1.0F - zoomProgress) * 0.66F;
                        }

                        lastStanceProgress = stanceProgress;
                        if (!inPlane) {
                           stanceProgress *= 0.66F;
                        } else {
                           stanceProgress = 1.0F - (1.0F - stanceProgress) * 0.66F;
                        }

                        if (minecraft.field_71439_g.field_70154_o instanceof IControllable) {
                           inPlane = true;

                           try {
                              ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, minecraft.field_71460_t, ((IControllable)minecraft.field_71439_g.field_70154_o).getPlayerRoll(), new String[]{"camRoll", "R", "field_78495_O"});
                           } catch (Exception var7) {
                              log("I forgot to update obfuscated reflection D:");
                              throw new RuntimeException(var7);
                           }

                           if (minecraft.field_71439_g.field_70154_o instanceof IControllable) {
                              try {
                                 ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, minecraft.field_71460_t, ((IControllable)minecraft.field_71439_g.field_70154_o).getCameraDistance(), new String[]{"thirdPersonDistance", "E", "field_78490_B"});
                              } catch (Exception var6) {
                                 log("I forgot to update obfuscated reflection D:");
                                 throw new RuntimeException(var6);
                              }
                           }
                        } else if (inPlane) {
                           try {
                              ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, minecraft.field_71460_t, 0.0F, new String[]{"camRoll", "R", "field_78495_O"});
                           } catch (Exception var5) {
                              log("I forgot to update obfuscated reflection D:");
                              throw new RuntimeException(var5);
                           }

                           try {
                              ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, minecraft.field_71460_t, 4.0F, new String[]{"thirdPersonDistance", "E", "field_78490_B"});
                           } catch (Exception var4) {
                              log("I forgot to update obfuscated reflection D:");
                              throw new RuntimeException(var4);
                           }

                           inPlane = false;
                        }

                        if (controlModeSwitchTimer > 0) {
                           --controlModeSwitchTimer;
                        }

                        return;
                     }

                     Object obj = var0.next();
                     player = (EntityPlayer)obj;
                     currentItem = player.func_71045_bC();
                  } while(currentItem == null);
               } while(!(currentItem.func_77973_b() instanceof ItemGun));

               if (player == minecraft.field_71439_g && minecraft.field_71474_y.field_74320_O == 0) {
                  player.func_71041_bz();
               } else if (currentItem.func_77975_n() == EnumAction.bow || currentItem.func_77975_n() == EnumAction.block) {
                  player.func_71008_a(currentItem, 100);
               }
            }
         }
      }
   }

   public static void renderTick(float smoothing) {
      if (Math.abs(zoomProgress - lastZoomProgress) > 1.0E-4F) {
         float actualZoomProgress = lastZoomProgress + (zoomProgress - lastZoomProgress) * smoothing;
         float botchedZoomProgress = zoomProgress > 0.8F ? 1.0F : 0.0F;
         double zoomLevel = (double)(botchedZoomProgress * lastZoomLevel + (1.0F - botchedZoomProgress));
         float FOVZoomLevel = actualZoomProgress * lastFOVZoomLevel + (1.0F - actualZoomProgress);
         if (Math.abs(zoomLevel - 1.0D) < 0.009999999776482582D) {
            zoomLevel = 1.0D;
         }

         try {
            ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, minecraft.field_71460_t, zoomLevel, new String[]{"cameraZoom", "af", "field_78503_V"});
            minecraft.field_71474_y.field_74334_X = ((originalFOV * 40.0F + 70.0F) / FOVZoomLevel - 70.0F) / 40.0F;
         } catch (Exception var7) {
            log("I forgot to update obfuscated reflection D:");
            throw new RuntimeException(var7);
         }
      }

   }

   @SubscribeEvent
   public void chatMessage(ClientChatReceivedEvent event) {
      if (event.message.func_150260_c().equals("#flansmod")) {
         event.setCanceled(true);
      }

   }

   private boolean checkFileExists(File file) {
      if (!file.exists()) {
         try {
            file.createNewFile();
         } catch (Exception var3) {
            FlansMod.log("Failed to create file");
            FlansMod.log(file.getAbsolutePath());
         }

         return false;
      } else {
         return true;
      }
   }

   public static boolean flipControlMode() {
      if (controlModeSwitchTimer > 0) {
         return false;
      } else {
         controlModeMouse = !controlModeMouse;
         FMLClientHandler.instance().getClient().func_147108_a(controlModeMouse ? new GuiDriveableController((IControllable)FMLClientHandler.instance().getClient().field_71439_g.field_70154_o) : null);
         controlModeSwitchTimer = 40;
         return true;
      }
   }

   public static void reloadModels(boolean reloadSkins) {
      Iterator var1 = InfoType.infoTypes.iterator();

      while(var1.hasNext()) {
         InfoType type = (InfoType)var1.next();
         type.reloadModel();
      }

      if (reloadSkins) {
         proxy.forceReload();
      }

   }

   public static Team getTeam(int spawnerTeamID) {
      return teamInfo == null ? null : teamInfo.getTeam(spawnerTeamID);
   }

   public static boolean isCurrentMap(String map) {
      boolean var1;
      if (teamInfo != null) {
         PacketTeamInfo var10000 = teamInfo;
         if (PacketTeamInfo.mapShortName != null) {
            var10000 = teamInfo;
            if (PacketTeamInfo.mapShortName.equals(map)) {
               var1 = true;
               return var1;
            }
         }
      }

      var1 = false;
      return var1;
   }

   @SideOnly(Side.CLIENT)
   public static EntityFX getParticle(String s, World w, double x, double y, double z) {
      Minecraft mc = Minecraft.func_71410_x();
      EntityFX fx = null;
      if (s.equals("hugeexplosion")) {
         fx = new EntityHugeExplodeFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("largeexplode")) {
         fx = new EntityLargeExplodeFX(mc.field_71446_o, w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("fireworksSpark")) {
         fx = new EntityFireworkSparkFX(w, x, y, z, 0.0D, 0.0D, 0.0D, mc.field_71452_i);
      } else if (s.equals("bubble")) {
         fx = new EntityBubbleFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("suspended")) {
         fx = new EntitySuspendFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("faggot")) {
         fx = new EntityAfterburn(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("arabe")) {
         fx = new EntitySmokeBurst(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("protoFlame")) {
         fx = new EntityFMFlame(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("nuclear")) {
         fx = new EntityFMNuke(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("shipDeath")) {
         fx = new EntityshipDeath(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("tankDeath")) {
         fx = new EntitytankDeath(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("smokeShell")) {
         fx = new EntitySmokeShell(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("smallSmoke")) {
         fx = new EntitySmallSmoke(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("casing")) {
         fx = new EntityShellCasing(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("blood")) {
         fx = new Entityblood(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("depthsuspend")) {
         fx = new EntityAuraFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("townaura")) {
         fx = new EntityAuraFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("crit")) {
         fx = new EntityCritFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("magicCrit")) {
         fx = new EntityCritFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
         ((EntityFX)fx).func_70538_b(((EntityFX)fx).func_70534_d() * 0.3F, ((EntityFX)fx).func_70542_f() * 0.8F, ((EntityFX)fx).func_70535_g());
         ((EntityFX)fx).func_94053_h();
      } else if (s.equals("smoke")) {
         fx = new EntitySmokeFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("mobSpell")) {
         fx = new EntitySpellParticleFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
         ((EntityFX)fx).func_70538_b(0.0F, 0.0F, 0.0F);
      } else if (s.equals("mobSpellAmbient")) {
         fx = new EntitySpellParticleFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
         ((EntityFX)fx).func_82338_g(0.15F);
         ((EntityFX)fx).func_70538_b(0.0F, 0.0F, 0.0F);
      } else if (s.equals("spell")) {
         fx = new EntitySpellParticleFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("instantSpell")) {
         fx = new EntitySpellParticleFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
         ((EntitySpellParticleFX)fx).func_70589_b(144);
      } else if (s.equals("witchMagic")) {
         fx = new EntitySmokeFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
         ((EntitySpellParticleFX)fx).func_70589_b(144);
         float f = w.field_73012_v.nextFloat() * 0.5F + 0.35F;
         ((EntityFX)fx).func_70538_b(1.0F * f, 0.0F * f, 1.0F * f);
      } else if (s.equals("note")) {
         fx = new EntityNoteFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("portal")) {
         fx = new EntityPortalFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("enchantmenttable")) {
         fx = new EntityEnchantmentTableParticleFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("explode")) {
         fx = new EntityExplodeFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("flame")) {
         fx = new EntityFlameFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("lava")) {
         fx = new EntityLavaFX(w, x, y, z);
      } else if (s.equals("footstep")) {
         fx = new EntityFootStepFX(mc.field_71446_o, w, x, y, z);
      } else if (s.equals("splash")) {
         fx = new EntitySplashFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("wake")) {
         fx = new EntityFishWakeFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("largesmoke")) {
         fx = new EntitySmokeFX(w, x, y, z, 0.0D, 0.0D, 0.0D, 2.5F);
      } else if (s.equals("cloud")) {
         fx = new EntityCloudFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("reddust")) {
         fx = new EntityReddustFX(w, x, y, z, 0.0F, 0.0F, 0.0F);
      } else if (s.equals("snowballpoof")) {
         fx = new EntityBreakingFX(w, x, y, z, Items.field_151126_ay);
      } else if (s.equals("dripWater")) {
         fx = new EntityDropParticleFX(w, x, y, z, Material.field_151586_h);
      } else if (s.equals("dripLava")) {
         fx = new EntityDropParticleFX(w, x, y, z, Material.field_151587_i);
      } else if (s.equals("snowshovel")) {
         fx = new EntitySnowShovelFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("slime")) {
         fx = new EntityBreakingFX(w, x, y, z, Items.field_151123_aH);
      } else if (s.equals("heart")) {
         fx = new EntityHeartFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("angryVillager")) {
         fx = new EntityHeartFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
         ((EntityFX)fx).func_70536_a(81);
         ((EntityFX)fx).func_70538_b(1.0F, 1.0F, 1.0F);
      } else if (s.equals("happyVillager")) {
         fx = new EntityAuraFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
         ((EntityFX)fx).func_70536_a(82);
         ((EntityFX)fx).func_70538_b(1.0F, 1.0F, 1.0F);
      } else if (s.equals("snowshovel")) {
         fx = new EntitySnowShovelFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("snowshovel")) {
         fx = new EntitySnowShovelFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else if (s.equals("snowshovel")) {
         fx = new EntitySnowShovelFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      } else {
         String[] astring;
         int k;
         if (s.startsWith("iconcrack_")) {
            astring = s.split("_", 3);
            int j = Integer.parseInt(astring[1]);
            if (astring.length > 2) {
               k = Integer.parseInt(astring[2]);
               fx = new EntityBreakingFX(w, x, y, z, 0.0D, 0.0D, 0.0D, Item.func_150899_d(j), k);
            } else {
               fx = new EntityBreakingFX(w, x, y, z, 0.0D, 0.0D, 0.0D, Item.func_150899_d(j), 0);
            }
         } else {
            Block block;
            if (s.startsWith("blockcrack_")) {
               astring = s.split("_", 3);
               block = Block.func_149729_e(Integer.parseInt(astring[1]));
               k = Integer.parseInt(astring[2]);
               fx = (new EntityDiggingFX(w, x, y, z, 0.0D, 0.0D, 0.0D, block, k)).func_90019_g(k);
            } else if (s.startsWith("blockdust_")) {
               astring = s.split("_", 3);
               block = Block.func_149729_e(Integer.parseInt(astring[1]));
               k = Integer.parseInt(astring[2]);
               fx = (new EntityBlockDustFX(w, x, y, z, 0.0D, 0.0D, 0.0D, block, k)).func_90019_g(k);
            }
         }
      }

      if (mc.field_71474_y.field_74347_j) {
         ((EntityFX)fx).field_70155_l = 200.0D;
      }

      if (fx != null) {
         mc.field_71452_i.func_78873_a((EntityFX)fx);
      }

      return (EntityFX)fx;
   }

   public static GunAnimations getGunAnimations(EntityLivingBase living, boolean offHand) {
      GunAnimations animations = null;
      if (offHand) {
         if (gunAnimationsLeft.containsKey(living)) {
            animations = (GunAnimations)gunAnimationsLeft.get(living);
         } else {
            animations = new GunAnimations();
            gunAnimationsLeft.put(living, animations);
         }
      } else if (gunAnimationsRight.containsKey(living)) {
         animations = (GunAnimations)gunAnimationsRight.get(living);
      } else {
         animations = new GunAnimations();
         gunAnimationsRight.put(living, animations);
      }

      return animations;
   }

   public static void setAimType(AimType aimInputType) {
      Property cw = FlansMod.configFile.get("Settings", "Aim Type", "toggle", "The type of aiming that you want to use 'toggle' or 'hold'");
      cw.set(aimInputType.toString());
      FlansMod.configFile.save();
      aimType = aimInputType;
   }

   public static void setAimButton(FlanMouseButton buttonInput) {
      Property cw = FlansMod.configFile.get("Settings", "Aim Button", "left", "The mouse button used to aim a gun 'left' or 'right'");
      cw.set(buttonInput.toString());
      FlansMod.configFile.save();
      aimButton = buttonInput;
   }

   public static void setFireButton(FlanMouseButton buttonInput) {
      Property cw = FlansMod.configFile.get("Settings", "Fire Button", "right", "The mouse button used to fire a gun 'left' or 'right'");
      cw.set(buttonInput.toString());
      FlansMod.configFile.save();
      fireButton = buttonInput;
   }
}
