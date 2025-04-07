package com.flansmod.common.guns;

import com.flansmod.client.AimType;
import com.flansmod.client.FlansModClient;
import com.flansmod.client.debug.EntityDebugDot;
import com.flansmod.client.debug.EntityDebugVector;
import com.flansmod.client.model.GunAnimations;
import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntityPlane;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.driveables.EntityVehicle;
import com.flansmod.common.driveables.mechas.EntityMecha;
import com.flansmod.common.guns.raytracing.BulletHit;
import com.flansmod.common.guns.raytracing.EntityHit;
import com.flansmod.common.guns.raytracing.EnumHitboxType;
import com.flansmod.common.guns.raytracing.PlayerBulletHit;
import com.flansmod.common.guns.raytracing.PlayerHitbox;
import com.flansmod.common.guns.raytracing.PlayerSnapshot;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketGunFire;
import com.flansmod.common.network.PacketGunRecoil;
import com.flansmod.common.network.PacketGunSpread;
import com.flansmod.common.network.PacketGunState;
import com.flansmod.common.network.PacketPlaySound;
import com.flansmod.common.network.PacketReload;
import com.flansmod.common.network.PacketSelectOffHandGun;
import com.flansmod.common.paintjob.IPaintableItem;
import com.flansmod.common.paintjob.PaintableType;
import com.flansmod.common.paintjob.Paintjob;
import com.flansmod.common.teams.EntityFlag;
import com.flansmod.common.teams.EntityFlagpole;
import com.flansmod.common.teams.EntityGunItem;
import com.flansmod.common.teams.Team;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.vector.Vector3f;
import com.google.common.collect.Multimap;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class ItemGun extends Item implements IPaintableItem {
   public GunType type;
   public static boolean rightMouseHeld;
   private static boolean lastRightMouseHeld;
   private static boolean leftMouseHeld;
   private static boolean lastLeftMouseHeld;
   public static boolean DHeld;
   private static boolean lastDHeld;
   public static boolean AHeld;
   private static boolean lastAHeld;
   public static boolean WHeld;
   private static boolean lastWHeld;
   public boolean blocking = false;
   public static boolean crouching = false;
   public static boolean sprinting = false;
   public static boolean mounted = false;
   public static boolean shooting = false;
   public int soundDelay;
   public int lockOnSoundDelay;
   public static boolean sliceCrossHair;
   public int impactX = 0;
   public int impactY = 0;
   public int impactZ = 0;
   public IIcon[] icons;
   public IIcon defaultIcon;
   boolean canClick = true;

   public InfoType getInfoType() {
      return this.type;
   }

   public PaintableType GetPaintableType() {
      return this.type;
   }

   public ItemGun(GunType gun) {
      this.field_77777_bU = 1;
      this.type = gun;
      this.type.item = this;
      this.func_77627_a(true);
      this.func_77637_a(FlansMod.tabFlanGuns);
      GameRegistry.registerItem(this, this.type.shortName, "flansmod");
   }

   public boolean func_77651_p() {
      return true;
   }

   public ItemStack getBulletItemStack(ItemStack gun, int id) {
      if (!gun.func_77942_o()) {
         gun.field_77990_d = new NBTTagCompound();
         return null;
      } else {
         String s;
         if (this.type.getSecondaryFire(gun)) {
            s = "secondaryAmmo";
         } else {
            s = "ammo";
         }

         NBTTagList ammoTagsList;
         if (gun.field_77990_d.func_74764_b(s)) {
            ammoTagsList = gun.field_77990_d.func_150295_c(s, 10);
            NBTTagCompound ammoTags = ammoTagsList.func_150305_b(id);
            return ItemStack.func_77949_a(ammoTags);
         } else {
            ammoTagsList = new NBTTagList();

            for(int i = 0; i < this.type.getNumAmmoItemsInGun(gun); ++i) {
               ammoTagsList.func_74742_a(new NBTTagCompound());
            }

            gun.field_77990_d.func_74782_a(s, ammoTagsList);
            return null;
         }
      }
   }

   public void setBulletItemStack(ItemStack gun, ItemStack bullet, int id) {
      if (!gun.func_77942_o()) {
         gun.field_77990_d = new NBTTagCompound();
      }

      String s;
      if (this.type.getSecondaryFire(gun)) {
         s = "secondaryAmmo";
      } else {
         s = "ammo";
      }

      NBTTagList ammoTagsList;
      if (!gun.field_77990_d.func_74764_b(s)) {
         ammoTagsList = new NBTTagList();

         for(int i = 0; i < this.type.getNumAmmoItemsInGun(gun); ++i) {
            ammoTagsList.func_74742_a(new NBTTagCompound());
         }

         gun.field_77990_d.func_74782_a(s, ammoTagsList);
      }

      ammoTagsList = gun.field_77990_d.func_150295_c(s, 10);
      NBTTagCompound ammoTags = ammoTagsList.func_150305_b(id);
      if (bullet == null) {
         ammoTags = new NBTTagCompound();
      }

      bullet.func_77955_b(ammoTags);
   }

   public void func_77624_a(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
      KeyBinding shift = Minecraft.func_71410_x().field_71474_y.field_74311_E;
      if (!this.type.getPaintjob(stack.func_77960_j()).displayName.equals("default")) {
         lines.add("§b§o" + this.type.getPaintjob(stack.func_77960_j()).displayName);
      }

      if (!this.type.packName.isEmpty()) {
         lines.add("§o" + this.type.packName);
      }

      if (this.type.description != null) {
         Collections.addAll(lines, this.type.description.split("_"));
      }

      if (!GameSettings.func_100015_a(shift)) {
         for(int i = 0; i < this.type.getNumAmmoItemsInGun(stack); ++i) {
            ItemStack bulletStack = this.getBulletItemStack(stack, i);
            if (bulletStack != null && bulletStack.func_77973_b() instanceof ItemBullet) {
               BulletType bulletType = ((ItemBullet)bulletStack.func_77973_b()).type;
               String line = bulletType.name + " " + (bulletStack.func_77958_k() - bulletStack.func_77960_j()) + "/" + bulletStack.func_77958_k();
               lines.add(line);
            }
         }

         lines.add("Hold §b§o" + GameSettings.func_74298_c(shift.func_151463_i()) + "§r§7 for details");
      } else {
         lines.add("");
         AttachmentType barrel = this.type.getBarrel(stack);
         if (barrel != null && barrel.silencer) {
            lines.add("§e[Suppressed]");
         }

         if (this.type.getSecondaryFire(stack)) {
            lines.add("§e[Underbarrel]");
         }

         lines.add("§9Damage§7: " + roundFloat(this.type.getDamage(stack), 2));
         lines.add("§9Recoil§7: " + roundFloat(this.type.getRecoilPitch(stack), 2));
         lines.add("§9Accuracy§7: " + roundFloat(this.type.getSpread(stack), 2));
         lines.add("§9Reload Time§7: " + roundFloat(this.type.getReloadTime(stack) / 20.0F, 2) + "s");
         lines.add("§9Mode§7: §f" + this.type.getFireMode(stack).toString().toLowerCase());
         lines.add("");
         lines.add("§eAttachments");
         boolean empty = true;
         Iterator var13 = this.type.getCurrentAttachments(stack).iterator();

         while(var13.hasNext()) {
            AttachmentType attachment = (AttachmentType)var13.next();
            String line = attachment.name;
            lines.add(line);
            if (line != null) {
               empty = false;
            }
         }

         if (empty) {
            lines.add("None");
         }
      }

   }

   @SideOnly(Side.CLIENT)
   public void onUpdateClient(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
      if (entity instanceof EntityPlayer && ((EntityPlayer)entity).field_71071_by.func_70448_g() == itemstack) {
         Minecraft mc = Minecraft.func_71410_x();
         EntityPlayer player = (EntityPlayer)entity;
         PlayerData data = PlayerHandler.getPlayerData(player, Side.CLIENT);
         if (this.soundDelay <= 0 && this.type.idleSound != null) {
            PacketPlaySound.sendSoundPacket(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, (double)this.type.idleSoundRange, entity.field_71093_bK, this.type.idleSound, false);
            this.soundDelay = this.type.idleSoundLength;
         }

         crouching = player.func_70093_af();
         sprinting = player.func_70051_ag();
         mounted = player.func_70115_ae();
         if (this.type.deployable) {
            return;
         }

         GameSettings gameSettings = FMLClientHandler.instance().getClient().field_71474_y;
         if (FMLClientHandler.instance().getClient().field_71462_r != null) {
            if (FlansModClient.currentScope != null) {
               FlansModClient.currentScope = null;
               gameSettings.field_74341_c = FlansModClient.originalMouseSensitivity;
               gameSettings.field_74320_O = FlansModClient.originalThirdPerson;
               gameSettings.field_74334_X = FlansModClient.originalFOV;
               FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketGunSpread(itemstack, this.type.getDefaultSpread(itemstack))));
            }
         } else if (mc.field_71476_x == null || !(mc.field_71476_x.field_72308_g instanceof EntityFlagpole) && !(mc.field_71476_x.field_72308_g instanceof EntityFlag) && !(mc.field_71476_x.field_72308_g instanceof EntityGunItem) && (!(mc.field_71476_x.field_72308_g instanceof EntityGrenade) || !((EntityGrenade)mc.field_71476_x.field_72308_g).type.isDeployableBag)) {
            lastRightMouseHeld = rightMouseHeld;
            lastLeftMouseHeld = leftMouseHeld;
            rightMouseHeld = Mouse.isButtonDown(FlansModClient.fireButton.getButton());
            leftMouseHeld = Mouse.isButtonDown(FlansModClient.aimButton.getButton());
            lastAHeld = AHeld;
            lastWHeld = WHeld;
            lastDHeld = DHeld;
            AHeld = GameSettings.func_100015_a(Minecraft.func_71410_x().field_71474_y.field_74370_x);
            WHeld = GameSettings.func_100015_a(Minecraft.func_71410_x().field_71474_y.field_74351_w);
            DHeld = GameSettings.func_100015_a(Minecraft.func_71410_x().field_71474_y.field_74366_z);
            boolean offHandFull = false;
            if (this.type.oneHanded) {
               if (data.offHandGunSlot == player.field_71071_by.field_70461_c + 1) {
                  data.offHandGunSlot = 0;
               }

               int dWheel = Mouse.getDWheel();
               if (Keyboard.isKeyDown(mc.field_71474_y.field_74311_E.func_151463_i()) && dWheel != 0) {
                  data.cycleOffHandItem(player, dWheel);
               }

               if (data.offHandGunSlot != 0) {
                  offHandFull = true;
                  ItemStack offHandGunStack = player.field_71071_by.func_70301_a(data.offHandGunSlot - 1);
                  if (offHandGunStack != null && offHandGunStack.func_77973_b() instanceof ItemGun) {
                     GunType offHandGunType = ((ItemGun)offHandGunStack.func_77973_b()).type;
                     if (offHandGunType.usableByPlayers) {
                        if (offHandGunType.getFireMode(offHandGunStack) == EnumFireMode.BURST && data.burstRoundsRemainingLeft > 0) {
                           if (this.clientSideShoot(player, offHandGunStack, offHandGunType, true)) {
                              player.field_71071_by.func_70299_a(data.offHandGunSlot - 1, (ItemStack)null);
                           }
                        } else {
                           if (leftMouseHeld && !lastLeftMouseHeld) {
                              FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketGunFire(true, true, player.field_70177_z, player.field_70125_A)));
                              if (this.clientSideShoot(player, offHandGunStack, offHandGunType, true)) {
                                 player.field_71071_by.func_70299_a(data.offHandGunSlot - 1, (ItemStack)null);
                              }
                           }

                           if ((offHandGunType.getFireMode(offHandGunStack) == EnumFireMode.FULLAUTO || offHandGunType.getFireMode(offHandGunStack) == EnumFireMode.MINIGUN) && !leftMouseHeld && lastLeftMouseHeld) {
                              FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketGunFire(true, false, player.field_70177_z, player.field_70125_A)));
                           }

                           if ((offHandGunType.getFireMode(offHandGunStack) == EnumFireMode.FULLAUTO || offHandGunType.getFireMode(offHandGunStack) == EnumFireMode.MINIGUN) && leftMouseHeld && this.clientSideShoot(player, offHandGunStack, offHandGunType, true)) {
                              player.field_71071_by.func_70299_a(data.offHandGunSlot - 1, (ItemStack)null);
                           }
                        }
                     }
                  } else {
                     data.offHandGunSlot = 0;
                  }
               }
            }

            if (this.type.usableByPlayers) {
               if (this.type.getFireMode(itemstack) == EnumFireMode.BURST && data.burstRoundsRemainingRight > 0) {
                  if (this.clientSideShoot(player, itemstack, this.type, false)) {
                     player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, (ItemStack)null);
                  }
               } else {
                  if (rightMouseHeld && !lastRightMouseHeld) {
                     FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketGunFire(false, true, player.field_70177_z, player.field_70125_A)));
                     if (this.clientSideShoot(player, itemstack, this.type, false)) {
                        player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, (ItemStack)null);
                     }
                  }

                  if ((this.type.getFireMode(itemstack) == EnumFireMode.FULLAUTO || this.type.getFireMode(itemstack) == EnumFireMode.MINIGUN) && !rightMouseHeld && lastRightMouseHeld) {
                     FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketGunFire(false, false, player.field_70177_z, player.field_70125_A)));
                  }

                  if ((this.type.getFireMode(itemstack) == EnumFireMode.FULLAUTO || this.type.getFireMode(itemstack) == EnumFireMode.MINIGUN) && rightMouseHeld && this.clientSideShoot(player, itemstack, this.type, false)) {
                     player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, (ItemStack)null);
                  }
               }
            }

            IScope currentScope = this.type.getCurrentScope(itemstack);
            if (rightMouseHeld && this.type.secondaryFunctionWhenShoot == EnumSecondaryFunction.CUSTOM_MELEE && this.type.canBlock) {
               this.blocking = true;
            }

            float f;
            if (FlansModClient.aimType == AimType.TOGGLE) {
               if (!offHandFull && (this.type.secondaryFunction == EnumSecondaryFunction.ADS_ZOOM || this.type.secondaryFunction == EnumSecondaryFunction.ZOOM) && Mouse.isButtonDown(FlansModClient.aimButton.getButton()) && FlansModClient.scopeTime <= 0 && FMLClientHandler.instance().getClient().field_71462_r == null) {
                  if (FlansModClient.currentScope == null) {
                     FlansModClient.currentScope = currentScope;
                     FlansModClient.lastZoomLevel = currentScope.getZoomFactor();
                     FlansModClient.lastFOVZoomLevel = currentScope.getFOVFactor();
                     f = FlansModClient.originalMouseSensitivity = gameSettings.field_74341_c;
                     gameSettings.field_74341_c = f / (float)Math.sqrt((double)currentScope.getZoomFactor());
                     FlansModClient.originalThirdPerson = gameSettings.field_74320_O;
                     gameSettings.field_74320_O = 0;
                     FlansModClient.originalFOV = gameSettings.field_74334_X;
                     this.sendSpreadToServer(itemstack);
                     FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketGunState(FlansModClient.currentScope != null)));
                  } else {
                     FlansModClient.currentScope = null;
                     gameSettings.field_74341_c = FlansModClient.originalMouseSensitivity;
                     gameSettings.field_74320_O = FlansModClient.originalThirdPerson;
                     gameSettings.field_74334_X = FlansModClient.originalFOV;
                     FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketGunSpread(itemstack, this.type.getDefaultSpread(itemstack))));
                     FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketGunState(FlansModClient.currentScope != null)));
                  }

                  FlansModClient.scopeTime = 10;
               }
            } else if (!offHandFull && (this.type.secondaryFunction == EnumSecondaryFunction.ADS_ZOOM || this.type.secondaryFunction == EnumSecondaryFunction.ZOOM) && Mouse.isButtonDown(FlansModClient.aimButton.getButton()) && FMLClientHandler.instance().getClient().field_71462_r == null) {
               if (FlansModClient.currentScope == null) {
                  FlansModClient.currentScope = currentScope;
                  FlansModClient.lastZoomLevel = currentScope.getZoomFactor();
                  FlansModClient.lastFOVZoomLevel = currentScope.getFOVFactor();
                  f = FlansModClient.originalMouseSensitivity = gameSettings.field_74341_c;
                  gameSettings.field_74341_c = f / (float)Math.sqrt((double)currentScope.getZoomFactor());
                  FlansModClient.originalThirdPerson = gameSettings.field_74320_O;
                  gameSettings.field_74320_O = 0;
                  this.sendSpreadToServer(itemstack);
                  FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketGunState(FlansModClient.currentScope != null)));
               }

               FlansModClient.scopeTime = 10;
            } else if (!Mouse.isButtonDown(FlansModClient.aimButton.getButton()) && FlansModClient.currentScope != null) {
               FlansModClient.currentScope = null;
               gameSettings.field_74341_c = FlansModClient.originalMouseSensitivity;
               gameSettings.field_74320_O = FlansModClient.originalThirdPerson;
               gameSettings.field_74334_X = FlansModClient.originalFOV;
               FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketGunSpread(itemstack, this.type.getDefaultSpread(itemstack))));
               FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketGunState(FlansModClient.currentScope != null)));
            }
         }
      }

      if (this.soundDelay > 0) {
         --this.soundDelay;
      }

   }

   public void sendSpreadToServer(ItemStack stack) {
      float f = this.type.numBullets == 1 ? 0.2F : 0.8F;
      FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketGunSpread(stack, this.type.getSpread(stack) * f)));
   }

   public boolean clientSideShoot(EntityPlayer player, ItemStack stack, GunType gunType, boolean left) {
      PlayerData data = PlayerHandler.getPlayerData(player);
      if (this.type.meleeSound != null) {
         PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, (double)this.type.meleeSoundRange, player.field_71093_bK, this.type.meleeSound, true);
      }

      if (this.type.secondaryFunctionWhenShoot != null) {
         GunAnimations animations;
         PlayerData whenshootdata;
         if (this.type.secondaryFunctionWhenShoot == EnumSecondaryFunction.CUSTOM_MELEE && !this.blocking && this.type.meleeLeft && AHeld) {
            if (player.field_70170_p.field_72995_K) {
               animations = FlansModClient.getGunAnimations(player, false);
               animations.doMeleeLeft(this.type.meleeLeftTime);
            }

            if (player instanceof EntityPlayer) {
               whenshootdata = PlayerHandler.getPlayerData(player);
               data.doMeleeLeft(player, this.type.meleeLeftTime, this.type);
            }
         } else if (this.type.secondaryFunctionWhenShoot == EnumSecondaryFunction.CUSTOM_MELEE && !this.blocking && this.type.meleeRight && DHeld) {
            if (player.field_70170_p.field_72995_K) {
               animations = FlansModClient.getGunAnimations(player, false);
               animations.doMeleeRight(this.type.meleeRightTime);
            }

            if (player instanceof EntityPlayer) {
               whenshootdata = PlayerHandler.getPlayerData(player);
               data.doMeleeRight(player, this.type.meleeRightTime, this.type);
            }
         } else if (this.type.secondaryFunctionWhenShoot == EnumSecondaryFunction.CUSTOM_MELEE && !this.blocking && this.type.meleeDown && WHeld) {
            if (player.field_70170_p.field_72995_K) {
               animations = FlansModClient.getGunAnimations(player, false);
               animations.doMeleeDown(this.type.meleeDownTime);
            }

            if (player instanceof EntityPlayer) {
               whenshootdata = PlayerHandler.getPlayerData(player);
               data.doMeleeDown(player, this.type.meleeDownTime, this.type);
            }
         } else if (this.type.secondaryFunctionWhenShoot == EnumSecondaryFunction.CUSTOM_MELEE && !this.blocking) {
            if (player.field_70170_p.field_72995_K) {
               animations = FlansModClient.getGunAnimations(player, false);
               animations.doMelee(this.type.meleeTime);
            }

            if (player instanceof EntityPlayer) {
               whenshootdata = PlayerHandler.getPlayerData(player);
               data.doMelee(player, this.type.meleeTime, this.type);
            }
         }
      }

      if (FlansModClient.shootTime(left) <= 0 && sprinting && FlansModClient.zoomProgress > 0.5F || FlansModClient.shootTime(left) <= 0 && !sprinting) {
         boolean onLastBullet = false;
         boolean hasAmmo = false;

         for(int i = 0; i < gunType.getNumAmmoItemsInGun(stack); ++i) {
            ItemStack bulletStack = this.getBulletItemStack(stack, i);
            if (bulletStack != null && bulletStack.func_77973_b() != null && bulletStack.func_77960_j() < bulletStack.func_77958_k()) {
               if (bulletStack.func_77958_k() - bulletStack.func_77960_j() == 1 && gunType.model.slideLockOnEmpty) {
                  onLastBullet = true;
               }

               hasAmmo = true;
               break;
            }
         }

         if (hasAmmo) {
            GunAnimations animations = null;
            if (left) {
               if (FlansModClient.gunAnimationsLeft.containsKey(player)) {
                  animations = (GunAnimations)FlansModClient.gunAnimationsLeft.get(player);
               } else {
                  animations = new GunAnimations();
                  FlansModClient.gunAnimationsLeft.put(player, animations);
               }
            } else if (FlansModClient.gunAnimationsRight.containsKey(player)) {
               animations = (GunAnimations)FlansModClient.gunAnimationsRight.get(player);
            } else {
               animations = new GunAnimations();
               FlansModClient.gunAnimationsRight.put(player, animations);
            }

            int pumpDelay = gunType.model == null ? 0 : gunType.model.pumpDelay;
            int pumpTime = gunType.model == null ? 1 : gunType.model.pumpTime;
            int hammerDelay = gunType.model == null ? 0 : gunType.model.hammerDelay;
            int casingDelay = gunType.model == null ? 0 : gunType.model.casingDelay;
            float hammerAngle = gunType.model == null ? 0.0F : gunType.model.hammerAngle;
            float althammerAngle = gunType.model == null ? 0.0F : gunType.model.althammerAngle;
            animations.onGunEmpty(onLastBullet);
            animations.doShoot(pumpDelay, pumpTime, hammerDelay, hammerAngle, althammerAngle, casingDelay);
            if (left) {
               FlansModClient.shootTimeLeft = gunType.getShootDelay(stack);
            } else {
               FlansModClient.shootTimeRight = gunType.getShootDelay(stack);
            }

            if (gunType.consumeGunUponUse) {
               return true;
            }
         }

         if (gunType.getFireMode(stack) == EnumFireMode.BURST) {
            if (left) {
               if (data.burstRoundsRemainingLeft > 0) {
                  --data.burstRoundsRemainingLeft;
               } else {
                  data.burstRoundsRemainingLeft = gunType.numBurstRounds;
               }
            } else if (data.burstRoundsRemainingRight > 0) {
               --data.burstRoundsRemainingRight;
            } else {
               data.burstRoundsRemainingRight = gunType.numBurstRounds;
            }
         }
      }

      return false;
   }

   public void onUpdateServer(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
      if (itemstack.func_77978_p() == null) {
         GunType gunType = this.type;
         NBTTagCompound tags = new NBTTagCompound();
         tags.func_74778_a("Paint", gunType.defaultPaintjob.iconName);
         NBTTagList ammoTagsList = new NBTTagList();

         for(int j = 0; j < gunType.getNumAmmoItemsInGun(itemstack); ++j) {
            ammoTagsList.func_74742_a(new NBTTagCompound());
         }

         tags.func_74782_a("ammo", ammoTagsList);
         itemstack.field_77990_d = tags;
      }

      if (entity instanceof EntityPlayerMP) {
         EntityPlayerMP player = (EntityPlayerMP)entity;
         PlayerData data = PlayerHandler.getPlayerData((EntityPlayer)player);
         if (data == null) {
            return;
         }

         if (player.field_71071_by.func_70448_g() != itemstack) {
            if (player.field_71071_by.func_70448_g() == null || player.field_71071_by.func_70448_g().func_77973_b() == null || !(player.field_71071_by.func_70448_g().func_77973_b() instanceof ItemGun)) {
               data.isShootingRight = data.isShootingLeft = false;
               data.offHandGunSlot = 0;
               (new PacketSelectOffHandGun(0)).handleServerSide(player);
            }

            return;
         }

         if (this.type.getFireMode(itemstack) == EnumFireMode.BURST && data.burstRoundsRemainingRight > 0) {
            player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, this.tryToShoot(itemstack, this.type, world, player, false));
         }

         if (data.isShootingRight) {
            if (this.type.getFireMode(itemstack) == EnumFireMode.FULLAUTO) {
               player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, this.tryToShoot(itemstack, this.type, world, player, false));
            }

            if (this.type.useLoopingSounds && data.loopedSoundDelay <= 0 && data.minigunSpeed > 0.1F && !data.reloadingRight) {
               data.loopedSoundDelay = data.shouldPlayWarmupSound ? this.type.warmupSoundLength : this.type.loopedSoundLength;
               PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, 50.0D, player.field_71093_bK, data.shouldPlayWarmupSound ? this.type.warmupSound : this.type.loopedSound, false);
               data.shouldPlayWarmupSound = false;
            }

            if (this.type.getFireMode(itemstack) == EnumFireMode.MINIGUN && data.minigunSpeed > this.type.minigunStartSpeed) {
               player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, this.tryToShoot(itemstack, this.type, world, player, false));
            }
         } else if (this.type.useLoopingSounds && data.shouldPlayCooldownSound) {
            PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, 50.0D, player.field_71093_bK, this.type.cooldownSound, false);
            data.shouldPlayCooldownSound = false;
         }

         if (this.type.oneHanded && data.offHandGunSlot != 0) {
            ItemStack offHandGunStack = player.field_71071_by.func_70301_a(data.offHandGunSlot - 1);
            if (offHandGunStack != null && offHandGunStack.func_77973_b() instanceof ItemGun) {
               GunType offHandGunType = ((ItemGun)offHandGunStack.func_77973_b()).type;
               if (offHandGunType.getFireMode(offHandGunStack) == EnumFireMode.BURST && data.burstRoundsRemainingLeft > 0) {
                  player.field_71071_by.func_70299_a(data.offHandGunSlot - 1, this.tryToShoot(offHandGunStack, offHandGunType, world, player, true));
               }

               if (data.isShootingLeft) {
                  if (offHandGunType.getFireMode(offHandGunStack) == EnumFireMode.FULLAUTO) {
                     player.field_71071_by.func_70299_a(data.offHandGunSlot - 1, this.tryToShoot(offHandGunStack, offHandGunType, world, player, true));
                  }

                  if (offHandGunType.useLoopingSounds && data.loopedSoundDelay <= 0 && data.minigunSpeed > 0.1F && !data.reloadingLeft) {
                     data.loopedSoundDelay = data.shouldPlayWarmupSound ? offHandGunType.warmupSoundLength : offHandGunType.loopedSoundLength;
                     PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, 50.0D, player.field_71093_bK, data.shouldPlayWarmupSound ? offHandGunType.warmupSound : offHandGunType.loopedSound, false);
                     data.shouldPlayWarmupSound = false;
                  }

                  if (offHandGunType.getFireMode(offHandGunStack) == EnumFireMode.MINIGUN && data.minigunSpeed > offHandGunType.minigunStartSpeed) {
                     player.field_71071_by.func_70299_a(data.offHandGunSlot - 1, this.tryToShoot(offHandGunStack, offHandGunType, world, player, true));
                  }
               } else if (offHandGunType.useLoopingSounds && data.shouldPlayCooldownSound) {
                  PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, 50.0D, player.field_71093_bK, offHandGunType.cooldownSound, false);
                  data.shouldPlayCooldownSound = false;
               }
            }
         }
      }

   }

   public void func_77663_a(ItemStack itemstack, World world, Entity pEnt, int i, boolean flag) {
      if (world.field_72995_K) {
         this.onUpdateClient(itemstack, world, pEnt, i, flag);
      } else {
         this.onUpdateServer(itemstack, world, pEnt, i, flag);
      }

      if (pEnt instanceof EntityPlayer) {
         EntityPlayer player = (EntityPlayer)pEnt;
         PlayerData data = PlayerHandler.getPlayerData(player);
         if (data == null) {
            return;
         }

         if (!this.type.canSetPosition) {
            this.impactX = this.impactY = this.impactZ = 0;
         }

         if (this.lockOnSoundDelay > 0) {
            --this.lockOnSoundDelay;
         }

         Entity closestEntity = null;
         Vector3f nextPosInPlayerCoords;
         Vector3f nextPosInWorldCoords;
         if (this.type.lockOnToLivings || this.type.lockOnToMechas || this.type.lockOnToPlanes || this.type.lockOnToPlayers || this.type.lockOnToVehicles) {
            Iterator var9 = player.field_70170_p.field_72996_f.iterator();

            label843:
            while(true) {
               Entity entity;
               String etype;
               do {
                  double dXYZ;
                  float angle;
                  do {
                     do {
                        if (!var9.hasNext()) {
                           if (closestEntity != null) {
                              closestEntity.getEntityData().func_74757_a("LockOn", true);
                           }

                           if (closestEntity != null && this.lockOnSoundDelay <= 0 && !player.field_70170_p.field_72995_K && player.func_71045_bC() != null && player.func_71045_bC().func_77973_b() instanceof ItemGun) {
                              ItemGun itemGun = (ItemGun)player.func_71045_bC().func_77973_b();
                              PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, 10.0D, player.field_71093_bK, itemGun.type.lockOnSound, false);
                              this.lockOnSoundDelay = this.type.lockOnSoundTime;
                              if (closestEntity instanceof EntityDriveable && ((EntityDriveable)closestEntity).getDriveableType().hasFlare) {
                                 EntityDriveable entityDriveable = (EntityDriveable)closestEntity;
                                 PacketPlaySound.sendSoundPacket(closestEntity.field_70165_t, closestEntity.field_70163_u, closestEntity.field_70161_v, (double)entityDriveable.getDriveableType().lockedOnSoundRange, closestEntity.field_71093_bK, entityDriveable.getDriveableType().lockingOnSound, false);
                              }
                           }
                           break label843;
                        }

                        Object obj = var9.next();
                        entity = (Entity)obj;
                        Vec3 playerVec = player.func_70040_Z();
                        dXYZ = Math.sqrt((entity.field_70165_t - player.field_70165_t) * (entity.field_70165_t - player.field_70165_t) + (entity.field_70163_u - player.field_70163_u) * (entity.field_70163_u - player.field_70163_u) + (entity.field_70161_v - player.field_70161_v) * (entity.field_70161_v - player.field_70161_v));
                        nextPosInPlayerCoords = new Vector3f(entity.field_70165_t - player.field_70165_t, entity.field_70163_u - player.field_70163_u, entity.field_70161_v - player.field_70161_v);
                        nextPosInWorldCoords = new Vector3f(playerVec.field_72450_a, playerVec.field_72448_b, playerVec.field_72449_c);
                        angle = Math.abs(Vector3f.angle(nextPosInWorldCoords, nextPosInPlayerCoords));
                     } while(!((double)angle < Math.toRadians((double)this.type.canLockOnAngle)));
                  } while(!(dXYZ < (double)this.type.maxRangeLockOn));

                  etype = entity.getEntityData().func_74779_i("EntityType");
               } while((!this.type.lockOnToMechas || !(entity instanceof EntityMecha)) && (!this.type.lockOnToVehicles || !(entity instanceof EntityVehicle)) && (!this.type.lockOnToVehicles || !etype.equals("Vehicle")) && (!this.type.lockOnToPlanes || !(entity instanceof EntityPlane)) && (!this.type.lockOnToPlanes || !etype.equals("Plane")) && (!this.type.lockOnToPlayers || !(entity instanceof EntityPlayer)) && (!this.type.lockOnToLivings || !(entity instanceof EntityLivingBase)));

               if (!data.reloadingRight) {
                  closestEntity = entity;
               }
            }
         }

         Vector3f nextPosInGunCoords;
         int j;
         Object obj;
         Entity entity;
         MovingObjectPosition mop;
         Vector3f hitPoint;
         float hitLambda;
         PlayerSnapshot snapshot;
         ArrayList playerHits;
         int k;
         Vector3f meleeDamagePoint;
         Vector3f nextPos;
         Vector3f nextAngles;
         RotatedAxes nextAxes;
         Vector3f dPos;
         ArrayList hits;
         float swingDistance;
         Iterator var37;
         EntityPlayer otherPlayer;
         BulletHit bulletHit;
         PlayerData otherData;
         PlayerBulletHit playerHit;
         EntityHit entityHit;
         boolean shouldDoNormalHitDetect;
         float damageMultiplier;
         EntityLivingBase living;
         Vector3f hitPoint;
         int snapshotToTry;
         float hitLambda;
         MovingObjectPosition mop;
         if (data.meleeDownLength > 0 && this.type.meleeDownPath.size() > 0 && player.field_71071_by.func_70448_g() == itemstack && this.type.meleeDown && data.meleeProgressDown != data.meleeDownLength) {
            for(k = 0; k < this.type.meleeDamagePoints.size(); ++k) {
               meleeDamagePoint = (Vector3f)this.type.meleeDownDamagePoints.get(k);
               nextPos = (Vector3f)this.type.meleeDownPath.get((data.meleeProgressDown + 1) % this.type.meleeDownPath.size());
               nextAngles = (Vector3f)this.type.meleeDownPathAngles.get((data.meleeProgressDown + 1) % this.type.meleeDownPathAngles.size());
               nextAxes = (new RotatedAxes()).rotateGlobalRoll(-nextAngles.x).rotateGlobalPitch(-nextAngles.z).rotateGlobalYaw(-nextAngles.y);
               nextPosInGunCoords = nextAxes.findLocalVectorGlobally(meleeDamagePoint);
               Vector3f.add(nextPos, nextPosInGunCoords, nextPosInGunCoords);
               Vector3f.add(new Vector3f(0.0F, 0.0F, 0.0F), nextPosInGunCoords, nextPosInGunCoords);
               nextPosInPlayerCoords = (new RotatedAxes(player.field_70177_z + 90.0F, player.field_70125_A, 0.0F)).findLocalVectorGlobally(nextPosInGunCoords);
               if (!FlansMod.proxy.isThePlayer(player)) {
                  ++nextPosInPlayerCoords.y;
               }

               nextPosInWorldCoords = new Vector3f(player.field_70165_t + (double)nextPosInPlayerCoords.x, player.field_70163_u + (double)nextPosInPlayerCoords.y, player.field_70161_v + (double)nextPosInPlayerCoords.z);
               dPos = data.lastMeleeDownPositions[k] == null ? new Vector3f() : Vector3f.sub(nextPosInWorldCoords, data.lastMeleeDownPositions[k], (Vector3f)null);
               if (player.field_70170_p.field_72995_K && FlansMod.DEBUG) {
                  player.field_70170_p.func_72838_d(new EntityDebugVector(player.field_70170_p, data.lastMeleeDownPositions[k], dPos, 200, 1.0F, 0.0F, 0.0F));
               }

               hits = new ArrayList();

               for(j = 0; j < world.field_72996_f.size(); ++j) {
                  obj = world.field_72996_f.get(j);
                  if (obj instanceof EntityPlayer) {
                     otherPlayer = (EntityPlayer)obj;
                     otherData = PlayerHandler.getPlayerData(otherPlayer);
                     shouldDoNormalHitDetect = false;
                     if (otherPlayer != player) {
                        if (otherData != null) {
                           if (otherPlayer.field_70128_L || otherData.team == Team.spectators) {
                              continue;
                           }

                           snapshotToTry = player instanceof EntityPlayerMP ? ((EntityPlayerMP)player).field_71138_i / 50 : 0;
                           if (snapshotToTry >= otherData.snapshots.length) {
                              snapshotToTry = otherData.snapshots.length - 1;
                           }

                           snapshot = otherData.snapshots[snapshotToTry];
                           if (snapshot == null) {
                              snapshot = otherData.snapshots[0];
                           }

                           if (snapshot == null) {
                              shouldDoNormalHitDetect = true;
                           } else {
                              playerHits = snapshot.raytrace(data.lastMeleeDownPositions[k] == null ? nextPosInWorldCoords : data.lastMeleeDownPositions[k], dPos);
                              hits.addAll(playerHits);
                           }
                        }

                        if (otherData == null || shouldDoNormalHitDetect) {
                           mop = data.lastMeleeDownPositions[k] == null ? player.field_70121_D.func_72327_a(nextPosInWorldCoords.toVec3(), Vec3.func_72443_a(0.0D, 0.0D, 0.0D)) : player.field_70121_D.func_72327_a(data.lastMeleeDownPositions[k].toVec3(), nextPosInWorldCoords.toVec3());
                           if (mop != null) {
                              hitPoint = new Vector3f(mop.field_72307_f.field_72450_a - (double)data.lastMeleeDownPositions[k].x, mop.field_72307_f.field_72448_b - (double)data.lastMeleeDownPositions[k].y, mop.field_72307_f.field_72449_c - (double)data.lastMeleeDownPositions[k].z);
                              hitLambda = 1.0F;
                              if (dPos.x != 0.0F) {
                                 hitLambda = hitPoint.x / dPos.x;
                              } else if (dPos.y != 0.0F) {
                                 hitLambda = hitPoint.y / dPos.y;
                              } else if (dPos.z != 0.0F) {
                                 hitLambda = hitPoint.z / dPos.z;
                              }

                              if (hitLambda < 0.0F) {
                                 hitLambda = -hitLambda;
                              }

                              hits.add(new PlayerBulletHit(new PlayerHitbox(otherPlayer, new RotatedAxes(), new Vector3f(), new Vector3f(), new Vector3f(), EnumHitboxType.BODY), hitLambda));
                           }
                        }
                     }
                  } else {
                     entity = (Entity)obj;
                     if (entity != player && !entity.field_70128_L && (entity instanceof EntityLivingBase || entity instanceof EntityAAGun)) {
                        mop = entity.field_70121_D.func_72327_a(data.lastMeleeDownPositions[k].toVec3(), nextPosInWorldCoords.toVec3());
                        if (mop != null) {
                           hitPoint = new Vector3f(mop.field_72307_f.field_72450_a - (double)data.lastMeleeDownPositions[k].x, mop.field_72307_f.field_72448_b - (double)data.lastMeleeDownPositions[k].y, mop.field_72307_f.field_72449_c - (double)data.lastMeleeDownPositions[k].z);
                           hitLambda = 1.0F;
                           if (dPos.x != 0.0F) {
                              hitLambda = hitPoint.x / dPos.x;
                           } else if (dPos.y != 0.0F) {
                              hitLambda = hitPoint.y / dPos.y;
                           } else if (dPos.z != 0.0F) {
                              hitLambda = hitPoint.z / dPos.z;
                           }

                           if (hitLambda < 0.0F) {
                              hitLambda = -hitLambda;
                           }

                           hits.add(new EntityHit(entity, hitLambda));
                        }
                     }
                  }
               }

               if (!hits.isEmpty()) {
                  Collections.sort(hits);
                  swingDistance = dPos.length();
                  var37 = hits.iterator();

                  while(var37.hasNext()) {
                     bulletHit = (BulletHit)var37.next();
                     if (bulletHit instanceof PlayerBulletHit) {
                        playerHit = (PlayerBulletHit)bulletHit;
                        damageMultiplier = 1.0F;
                        switch(playerHit.hitbox.type) {
                        case LEFTITEM:
                        case RIGHTITEM:
                           PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, (double)this.type.meleeSoundRange, player.field_71093_bK, this.type.ShieldHitSound, true);
                           data.meleeProgressDown = data.meleeDownLength = 0;
                           return;
                        case HEAD:
                           damageMultiplier = 2.0F;
                           break;
                        case RIGHTARM:
                        case LEFTARM:
                           damageMultiplier = 0.6F;
                        }

                        if (playerHit.hitbox.player.func_70097_a(this.getMeleeDamage(player), swingDistance * this.type.meleeDamage)) {
                           ++playerHit.hitbox.player.field_70720_be;
                           playerHit.hitbox.player.field_70172_ad = playerHit.hitbox.player.field_70771_an / 2;
                           PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, (double)this.type.meleeSoundRange, player.field_71093_bK, this.type.meleeHitSound, true);
                           sliceCrossHair = true;
                        }

                        if (FlansMod.DEBUG) {
                           world.func_72838_d(new EntityDebugDot(world, new Vector3f(data.lastMeleeDownPositions[k].x + dPos.x * playerHit.intersectTime, data.lastMeleeDownPositions[k].y + dPos.y * playerHit.intersectTime, data.lastMeleeDownPositions[k].z + dPos.z * playerHit.intersectTime), 1000, 1.0F, 0.0F, 0.0F));
                        }
                     } else if (bulletHit instanceof EntityHit) {
                        entityHit = (EntityHit)bulletHit;
                        if (entityHit.entity.func_70097_a(DamageSource.func_76365_a(player), swingDistance * this.type.meleeDamage) && entityHit.entity instanceof EntityLivingBase) {
                           living = (EntityLivingBase)entityHit.entity;
                           ++living.field_70720_be;
                           living.field_70172_ad = living.field_70771_an / 2;
                           PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, (double)this.type.meleeSoundRange, player.field_71093_bK, this.type.meleeHitSound, true);
                        }

                        if (FlansMod.DEBUG) {
                           world.func_72838_d(new EntityDebugDot(world, new Vector3f(data.lastMeleeDownPositions[k].x + dPos.x * entityHit.intersectTime, data.lastMeleeDownPositions[k].y + dPos.y * entityHit.intersectTime, data.lastMeleeDownPositions[k].z + dPos.z * entityHit.intersectTime), 1000, 1.0F, 0.0F, 0.0F));
                        }
                     }
                  }
               }

               data.lastMeleeDownPositions[k] = nextPosInWorldCoords;
            }

            ++data.meleeProgressDown;
            if (data.meleeProgressDown == data.meleeDownLength) {
               data.meleeProgressDown = data.meleeDownLength = 0;
            }
         } else if (data.meleeLeftLength > 0 && this.type.meleeLeftPath.size() > 0 && player.field_71071_by.func_70448_g() == itemstack && this.type.meleeLeft && data.meleeProgressLeft != data.meleeLeftLength) {
            for(k = 0; k < this.type.meleeDamagePoints.size(); ++k) {
               meleeDamagePoint = (Vector3f)this.type.meleeLeftDamagePoints.get(k);
               nextPos = (Vector3f)this.type.meleeLeftPath.get((data.meleeProgressLeft + 1) % this.type.meleeLeftPath.size());
               nextAngles = (Vector3f)this.type.meleeLeftPathAngles.get((data.meleeProgressLeft + 1) % this.type.meleeLeftPathAngles.size());
               nextAxes = (new RotatedAxes()).rotateGlobalRoll(-nextAngles.x).rotateGlobalPitch(-nextAngles.z).rotateGlobalYaw(-nextAngles.y);
               nextPosInGunCoords = nextAxes.findLocalVectorGlobally(meleeDamagePoint);
               Vector3f.add(nextPos, nextPosInGunCoords, nextPosInGunCoords);
               Vector3f.add(new Vector3f(0.0F, 0.0F, 0.0F), nextPosInGunCoords, nextPosInGunCoords);
               nextPosInPlayerCoords = (new RotatedAxes(player.field_70177_z + 90.0F, player.field_70125_A, 0.0F)).findLocalVectorGlobally(nextPosInGunCoords);
               if (!FlansMod.proxy.isThePlayer(player)) {
                  ++nextPosInPlayerCoords.y;
               }

               nextPosInWorldCoords = new Vector3f(player.field_70165_t + (double)nextPosInPlayerCoords.x, player.field_70163_u + (double)nextPosInPlayerCoords.y, player.field_70161_v + (double)nextPosInPlayerCoords.z);
               dPos = data.lastMeleeLeftPositions[k] == null ? new Vector3f() : Vector3f.sub(nextPosInWorldCoords, data.lastMeleeLeftPositions[k], (Vector3f)null);
               if (player.field_70170_p.field_72995_K && FlansMod.DEBUG) {
                  player.field_70170_p.func_72838_d(new EntityDebugVector(player.field_70170_p, data.lastMeleeLeftPositions[k], dPos, 200, 1.0F, 0.0F, 0.0F));
               }

               hits = new ArrayList();

               for(j = 0; j < world.field_72996_f.size(); ++j) {
                  obj = world.field_72996_f.get(j);
                  if (obj instanceof EntityPlayer) {
                     otherPlayer = (EntityPlayer)obj;
                     otherData = PlayerHandler.getPlayerData(otherPlayer);
                     shouldDoNormalHitDetect = false;
                     if (otherPlayer != player) {
                        if (otherData != null) {
                           if (otherPlayer.field_70128_L || otherData.team == Team.spectators) {
                              continue;
                           }

                           snapshotToTry = player instanceof EntityPlayerMP ? ((EntityPlayerMP)player).field_71138_i / 50 : 0;
                           if (snapshotToTry >= otherData.snapshots.length) {
                              snapshotToTry = otherData.snapshots.length - 1;
                           }

                           snapshot = otherData.snapshots[snapshotToTry];
                           if (snapshot == null) {
                              snapshot = otherData.snapshots[0];
                           }

                           if (snapshot == null) {
                              shouldDoNormalHitDetect = true;
                           } else {
                              playerHits = snapshot.raytrace(data.lastMeleeLeftPositions[k] == null ? nextPosInWorldCoords : data.lastMeleeLeftPositions[k], dPos);
                              hits.addAll(playerHits);
                           }
                        }

                        if (otherData == null || shouldDoNormalHitDetect) {
                           mop = data.lastMeleeLeftPositions[k] == null ? player.field_70121_D.func_72327_a(nextPosInWorldCoords.toVec3(), Vec3.func_72443_a(0.0D, 0.0D, 0.0D)) : player.field_70121_D.func_72327_a(data.lastMeleeLeftPositions[k].toVec3(), nextPosInWorldCoords.toVec3());
                           if (mop != null) {
                              hitPoint = new Vector3f(mop.field_72307_f.field_72450_a - (double)data.lastMeleeLeftPositions[k].x, mop.field_72307_f.field_72448_b - (double)data.lastMeleeLeftPositions[k].y, mop.field_72307_f.field_72449_c - (double)data.lastMeleeLeftPositions[k].z);
                              hitLambda = 1.0F;
                              if (dPos.x != 0.0F) {
                                 hitLambda = hitPoint.x / dPos.x;
                              } else if (dPos.y != 0.0F) {
                                 hitLambda = hitPoint.y / dPos.y;
                              } else if (dPos.z != 0.0F) {
                                 hitLambda = hitPoint.z / dPos.z;
                              }

                              if (hitLambda < 0.0F) {
                                 hitLambda = -hitLambda;
                              }

                              hits.add(new PlayerBulletHit(new PlayerHitbox(otherPlayer, new RotatedAxes(), new Vector3f(), new Vector3f(), new Vector3f(), EnumHitboxType.BODY), hitLambda));
                           }
                        }
                     }
                  } else {
                     entity = (Entity)obj;
                     if (entity != player && !entity.field_70128_L && (entity instanceof EntityLivingBase || entity instanceof EntityAAGun)) {
                        mop = entity.field_70121_D.func_72327_a(data.lastMeleeLeftPositions[k].toVec3(), nextPosInWorldCoords.toVec3());
                        if (mop != null) {
                           hitPoint = new Vector3f(mop.field_72307_f.field_72450_a - (double)data.lastMeleeLeftPositions[k].x, mop.field_72307_f.field_72448_b - (double)data.lastMeleeLeftPositions[k].y, mop.field_72307_f.field_72449_c - (double)data.lastMeleeLeftPositions[k].z);
                           hitLambda = 1.0F;
                           if (dPos.x != 0.0F) {
                              hitLambda = hitPoint.x / dPos.x;
                           } else if (dPos.y != 0.0F) {
                              hitLambda = hitPoint.y / dPos.y;
                           } else if (dPos.z != 0.0F) {
                              hitLambda = hitPoint.z / dPos.z;
                           }

                           if (hitLambda < 0.0F) {
                              hitLambda = -hitLambda;
                           }

                           hits.add(new EntityHit(entity, hitLambda));
                        }
                     }
                  }
               }

               if (!hits.isEmpty()) {
                  Collections.sort(hits);
                  swingDistance = dPos.length();
                  var37 = hits.iterator();

                  while(var37.hasNext()) {
                     bulletHit = (BulletHit)var37.next();
                     if (bulletHit instanceof PlayerBulletHit) {
                        playerHit = (PlayerBulletHit)bulletHit;
                        damageMultiplier = 1.0F;
                        switch(playerHit.hitbox.type) {
                        case LEFTITEM:
                        case RIGHTITEM:
                           PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, (double)this.type.meleeSoundRange, player.field_71093_bK, this.type.ShieldHitSound, true);
                           data.meleeProgressLeft = data.meleeLeftLength = 0;
                           return;
                        case HEAD:
                           damageMultiplier = 2.0F;
                           break;
                        case RIGHTARM:
                        case LEFTARM:
                           damageMultiplier = 0.6F;
                        }

                        if (playerHit.hitbox.player.func_70097_a(this.getMeleeDamage(player), swingDistance * this.type.meleeDamage)) {
                           PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, (double)this.type.meleeSoundRange, player.field_71093_bK, this.type.meleeHitSound, true);
                           ++playerHit.hitbox.player.field_70720_be;
                           playerHit.hitbox.player.field_70172_ad = playerHit.hitbox.player.field_70771_an / 2;
                           sliceCrossHair = true;
                        }

                        if (FlansMod.DEBUG) {
                           world.func_72838_d(new EntityDebugDot(world, new Vector3f(data.lastMeleeLeftPositions[k].x + dPos.x * playerHit.intersectTime, data.lastMeleeLeftPositions[k].y + dPos.y * playerHit.intersectTime, data.lastMeleeLeftPositions[k].z + dPos.z * playerHit.intersectTime), 1000, 1.0F, 0.0F, 0.0F));
                        }
                     } else if (bulletHit instanceof EntityHit) {
                        entityHit = (EntityHit)bulletHit;
                        if (entityHit.entity.func_70097_a(DamageSource.func_76365_a(player), swingDistance * this.type.meleeDamage) && entityHit.entity instanceof EntityLivingBase) {
                           living = (EntityLivingBase)entityHit.entity;
                           PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, (double)this.type.meleeSoundRange, player.field_71093_bK, this.type.meleeHitSound, true);
                           ++living.field_70720_be;
                           living.field_70172_ad = living.field_70771_an / 2;
                        }

                        if (FlansMod.DEBUG) {
                           world.func_72838_d(new EntityDebugDot(world, new Vector3f(data.lastMeleeLeftPositions[k].x + dPos.x * entityHit.intersectTime, data.lastMeleeLeftPositions[k].y + dPos.y * entityHit.intersectTime, data.lastMeleeLeftPositions[k].z + dPos.z * entityHit.intersectTime), 1000, 1.0F, 0.0F, 0.0F));
                        }
                     }
                  }
               }

               data.lastMeleeLeftPositions[k] = nextPosInWorldCoords;
            }

            ++data.meleeProgressLeft;
            if (data.meleeProgressLeft == data.meleeLeftLength) {
               data.meleeProgressLeft = data.meleeLeftLength = 0;
            }
         } else if (data.meleeRightLength > 0 && this.type.meleeRightPath.size() > 0 && player.field_71071_by.func_70448_g() == itemstack && this.type.meleeRight && data.meleeProgressRight != data.meleeRightLength) {
            for(k = 0; k < this.type.meleeRightDamagePoints.size(); ++k) {
               meleeDamagePoint = (Vector3f)this.type.meleeRightDamagePoints.get(k);
               nextPos = (Vector3f)this.type.meleeRightPath.get((data.meleeProgressRight + 1) % this.type.meleeRightPath.size());
               nextAngles = (Vector3f)this.type.meleeRightPathAngles.get((data.meleeProgressRight + 1) % this.type.meleeRightPathAngles.size());
               nextAxes = (new RotatedAxes()).rotateGlobalRoll(-nextAngles.x).rotateGlobalPitch(-nextAngles.z).rotateGlobalYaw(-nextAngles.y);
               nextPosInGunCoords = nextAxes.findLocalVectorGlobally(meleeDamagePoint);
               Vector3f.add(nextPos, nextPosInGunCoords, nextPosInGunCoords);
               Vector3f.add(new Vector3f(0.0F, 0.0F, 0.0F), nextPosInGunCoords, nextPosInGunCoords);
               nextPosInPlayerCoords = (new RotatedAxes(player.field_70177_z + 90.0F, player.field_70125_A, 0.0F)).findLocalVectorGlobally(nextPosInGunCoords);
               if (!FlansMod.proxy.isThePlayer(player)) {
                  ++nextPosInPlayerCoords.y;
               }

               nextPosInWorldCoords = new Vector3f(player.field_70165_t + (double)nextPosInPlayerCoords.x, player.field_70163_u + (double)nextPosInPlayerCoords.y, player.field_70161_v + (double)nextPosInPlayerCoords.z);
               dPos = data.lastMeleeRightPositions[k] == null ? new Vector3f() : Vector3f.sub(nextPosInWorldCoords, data.lastMeleeRightPositions[k], (Vector3f)null);
               if (player.field_70170_p.field_72995_K && FlansMod.DEBUG) {
                  player.field_70170_p.func_72838_d(new EntityDebugVector(player.field_70170_p, data.lastMeleeRightPositions[k], dPos, 200, 1.0F, 0.0F, 0.0F));
               }

               hits = new ArrayList();

               for(j = 0; j < world.field_72996_f.size(); ++j) {
                  obj = world.field_72996_f.get(j);
                  if (obj instanceof EntityPlayer) {
                     otherPlayer = (EntityPlayer)obj;
                     otherData = PlayerHandler.getPlayerData(otherPlayer);
                     shouldDoNormalHitDetect = false;
                     if (otherPlayer != player) {
                        if (otherData != null) {
                           if (otherPlayer.field_70128_L || otherData.team == Team.spectators) {
                              continue;
                           }

                           snapshotToTry = player instanceof EntityPlayerMP ? ((EntityPlayerMP)player).field_71138_i / 50 : 0;
                           if (snapshotToTry >= otherData.snapshots.length) {
                              snapshotToTry = otherData.snapshots.length - 1;
                           }

                           snapshot = otherData.snapshots[snapshotToTry];
                           if (snapshot == null) {
                              snapshot = otherData.snapshots[0];
                           }

                           if (snapshot == null) {
                              shouldDoNormalHitDetect = true;
                           } else {
                              playerHits = snapshot.raytrace(data.lastMeleeRightPositions[k] == null ? nextPosInWorldCoords : data.lastMeleeRightPositions[k], dPos);
                              hits.addAll(playerHits);
                           }
                        }

                        if (otherData == null || shouldDoNormalHitDetect) {
                           mop = data.lastMeleeRightPositions[k] == null ? player.field_70121_D.func_72327_a(nextPosInWorldCoords.toVec3(), Vec3.func_72443_a(0.0D, 0.0D, 0.0D)) : player.field_70121_D.func_72327_a(data.lastMeleeRightPositions[k].toVec3(), nextPosInWorldCoords.toVec3());
                           if (mop != null) {
                              hitPoint = new Vector3f(mop.field_72307_f.field_72450_a - (double)data.lastMeleeRightPositions[k].x, mop.field_72307_f.field_72448_b - (double)data.lastMeleeRightPositions[k].y, mop.field_72307_f.field_72449_c - (double)data.lastMeleeRightPositions[k].z);
                              hitLambda = 1.0F;
                              if (dPos.x != 0.0F) {
                                 hitLambda = hitPoint.x / dPos.x;
                              } else if (dPos.y != 0.0F) {
                                 hitLambda = hitPoint.y / dPos.y;
                              } else if (dPos.z != 0.0F) {
                                 hitLambda = hitPoint.z / dPos.z;
                              }

                              if (hitLambda < 0.0F) {
                                 hitLambda = -hitLambda;
                              }

                              hits.add(new PlayerBulletHit(new PlayerHitbox(otherPlayer, new RotatedAxes(), new Vector3f(), new Vector3f(), new Vector3f(), EnumHitboxType.BODY), hitLambda));
                           }
                        }
                     }
                  } else {
                     entity = (Entity)obj;
                     if (entity != player && !entity.field_70128_L && (entity instanceof EntityLivingBase || entity instanceof EntityAAGun)) {
                        mop = entity.field_70121_D.func_72327_a(data.lastMeleeRightPositions[k].toVec3(), nextPosInWorldCoords.toVec3());
                        if (mop != null) {
                           hitPoint = new Vector3f(mop.field_72307_f.field_72450_a - (double)data.lastMeleeRightPositions[k].x, mop.field_72307_f.field_72448_b - (double)data.lastMeleeRightPositions[k].y, mop.field_72307_f.field_72449_c - (double)data.lastMeleeRightPositions[k].z);
                           hitLambda = 1.0F;
                           if (dPos.x != 0.0F) {
                              hitLambda = hitPoint.x / dPos.x;
                           } else if (dPos.y != 0.0F) {
                              hitLambda = hitPoint.y / dPos.y;
                           } else if (dPos.z != 0.0F) {
                              hitLambda = hitPoint.z / dPos.z;
                           }

                           if (hitLambda < 0.0F) {
                              hitLambda = -hitLambda;
                           }

                           hits.add(new EntityHit(entity, hitLambda));
                        }
                     }
                  }
               }

               if (!hits.isEmpty()) {
                  Collections.sort(hits);
                  swingDistance = dPos.length();
                  var37 = hits.iterator();

                  while(var37.hasNext()) {
                     bulletHit = (BulletHit)var37.next();
                     if (bulletHit instanceof PlayerBulletHit) {
                        playerHit = (PlayerBulletHit)bulletHit;
                        damageMultiplier = 1.0F;
                        switch(playerHit.hitbox.type) {
                        case LEFTITEM:
                        case RIGHTITEM:
                           PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, (double)this.type.meleeSoundRange, player.field_71093_bK, this.type.ShieldHitSound, true);
                           data.meleeProgressRight = data.meleeRightLength = 0;
                           return;
                        case HEAD:
                           damageMultiplier = 2.0F;
                           break;
                        case RIGHTARM:
                        case LEFTARM:
                           damageMultiplier = 0.6F;
                        }

                        if (playerHit.hitbox.player.func_70097_a(this.getMeleeDamage(player), swingDistance * this.type.meleeDamage)) {
                           PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, (double)this.type.meleeSoundRange, player.field_71093_bK, this.type.meleeHitSound, true);
                           ++playerHit.hitbox.player.field_70720_be;
                           playerHit.hitbox.player.field_70172_ad = playerHit.hitbox.player.field_70771_an / 2;
                           sliceCrossHair = true;
                        }

                        if (FlansMod.DEBUG) {
                           world.func_72838_d(new EntityDebugDot(world, new Vector3f(data.lastMeleeRightPositions[k].x + dPos.x * playerHit.intersectTime, data.lastMeleeRightPositions[k].y + dPos.y * playerHit.intersectTime, data.lastMeleeRightPositions[k].z + dPos.z * playerHit.intersectTime), 1000, 1.0F, 0.0F, 0.0F));
                        }
                     } else if (bulletHit instanceof EntityHit) {
                        entityHit = (EntityHit)bulletHit;
                        if (entityHit.entity.func_70097_a(DamageSource.func_76365_a(player), swingDistance * this.type.meleeDamage) && entityHit.entity instanceof EntityLivingBase) {
                           living = (EntityLivingBase)entityHit.entity;
                           PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, (double)this.type.meleeSoundRange, player.field_71093_bK, this.type.meleeHitSound, true);
                           ++living.field_70720_be;
                           living.field_70172_ad = living.field_70771_an / 2;
                        }

                        if (FlansMod.DEBUG) {
                           world.func_72838_d(new EntityDebugDot(world, new Vector3f(data.lastMeleeRightPositions[k].x + dPos.x * entityHit.intersectTime, data.lastMeleeRightPositions[k].y + dPos.y * entityHit.intersectTime, data.lastMeleeRightPositions[k].z + dPos.z * entityHit.intersectTime), 1000, 1.0F, 0.0F, 0.0F));
                        }
                     }
                  }
               }

               data.lastMeleeRightPositions[k] = nextPosInWorldCoords;
            }

            ++data.meleeProgressRight;
            if (data.meleeProgressRight == data.meleeRightLength) {
               data.meleeProgressRight = data.meleeRightLength = 0;
            }
         } else if (data.meleeLength > 0 && this.type.meleePath.size() > 0 && player.field_71071_by.func_70448_g() == itemstack) {
            for(k = 0; k < this.type.meleeDamagePoints.size(); ++k) {
               meleeDamagePoint = (Vector3f)this.type.meleeDamagePoints.get(k);
               nextPos = (Vector3f)this.type.meleePath.get((data.meleeProgress + 1) % this.type.meleePath.size());
               nextAngles = (Vector3f)this.type.meleePathAngles.get((data.meleeProgress + 1) % this.type.meleePathAngles.size());
               nextAxes = (new RotatedAxes()).rotateGlobalRoll(-nextAngles.x).rotateGlobalPitch(-nextAngles.z).rotateGlobalYaw(-nextAngles.y);
               nextPosInGunCoords = nextAxes.findLocalVectorGlobally(meleeDamagePoint);
               Vector3f.add(nextPos, nextPosInGunCoords, nextPosInGunCoords);
               Vector3f.add(new Vector3f(0.0F, 0.0F, 0.0F), nextPosInGunCoords, nextPosInGunCoords);
               nextPosInPlayerCoords = (new RotatedAxes(player.field_70177_z + 90.0F, player.field_70125_A, 0.0F)).findLocalVectorGlobally(nextPosInGunCoords);
               if (!FlansMod.proxy.isThePlayer(player)) {
                  ++nextPosInPlayerCoords.y;
               }

               nextPosInWorldCoords = new Vector3f(player.field_70165_t + (double)nextPosInPlayerCoords.x, player.field_70163_u + (double)nextPosInPlayerCoords.y, player.field_70161_v + (double)nextPosInPlayerCoords.z);
               dPos = data.lastMeleePositions[k] == null ? new Vector3f() : Vector3f.sub(nextPosInWorldCoords, data.lastMeleePositions[k], (Vector3f)null);
               if (player.field_70170_p.field_72995_K && FlansMod.DEBUG) {
                  player.field_70170_p.func_72838_d(new EntityDebugVector(player.field_70170_p, data.lastMeleePositions[k], dPos, 200, 1.0F, 0.0F, 0.0F));
               }

               hits = new ArrayList();

               for(j = 0; j < world.field_72996_f.size(); ++j) {
                  obj = world.field_72996_f.get(j);
                  if (obj instanceof EntityPlayer) {
                     otherPlayer = (EntityPlayer)obj;
                     otherData = PlayerHandler.getPlayerData(otherPlayer);
                     shouldDoNormalHitDetect = false;
                     if (otherPlayer != player) {
                        if (otherData != null) {
                           if (otherPlayer.field_70128_L || otherData.team == Team.spectators) {
                              continue;
                           }

                           snapshotToTry = player instanceof EntityPlayerMP ? ((EntityPlayerMP)player).field_71138_i / 50 : 0;
                           if (snapshotToTry >= otherData.snapshots.length) {
                              snapshotToTry = otherData.snapshots.length - 1;
                           }

                           snapshot = otherData.snapshots[snapshotToTry];
                           if (snapshot == null) {
                              snapshot = otherData.snapshots[0];
                           }

                           if (snapshot == null) {
                              shouldDoNormalHitDetect = true;
                           } else {
                              playerHits = snapshot.raytrace(data.lastMeleePositions[k] == null ? nextPosInWorldCoords : data.lastMeleePositions[k], dPos);
                              hits.addAll(playerHits);
                           }
                        }

                        if (otherData == null || shouldDoNormalHitDetect) {
                           mop = data.lastMeleePositions[k] == null ? player.field_70121_D.func_72327_a(nextPosInWorldCoords.toVec3(), Vec3.func_72443_a(0.0D, 0.0D, 0.0D)) : player.field_70121_D.func_72327_a(data.lastMeleePositions[k].toVec3(), nextPosInWorldCoords.toVec3());
                           if (mop != null) {
                              hitPoint = new Vector3f(mop.field_72307_f.field_72450_a - (double)data.lastMeleePositions[k].x, mop.field_72307_f.field_72448_b - (double)data.lastMeleePositions[k].y, mop.field_72307_f.field_72449_c - (double)data.lastMeleePositions[k].z);
                              hitLambda = 1.0F;
                              if (dPos.x != 0.0F) {
                                 hitLambda = hitPoint.x / dPos.x;
                              } else if (dPos.y != 0.0F) {
                                 hitLambda = hitPoint.y / dPos.y;
                              } else if (dPos.z != 0.0F) {
                                 hitLambda = hitPoint.z / dPos.z;
                              }

                              if (hitLambda < 0.0F) {
                                 hitLambda = -hitLambda;
                              }

                              hits.add(new PlayerBulletHit(new PlayerHitbox(otherPlayer, new RotatedAxes(), new Vector3f(), new Vector3f(), new Vector3f(), EnumHitboxType.BODY), hitLambda));
                           }
                        }
                     }
                  } else {
                     entity = (Entity)obj;
                     if (entity != player && !entity.field_70128_L && (entity instanceof EntityLivingBase || entity instanceof EntityAAGun)) {
                        mop = entity.field_70121_D.func_72327_a(data.lastMeleePositions[k].toVec3(), nextPosInWorldCoords.toVec3());
                        if (mop != null) {
                           hitPoint = new Vector3f(mop.field_72307_f.field_72450_a - (double)data.lastMeleePositions[k].x, mop.field_72307_f.field_72448_b - (double)data.lastMeleePositions[k].y, mop.field_72307_f.field_72449_c - (double)data.lastMeleePositions[k].z);
                           hitLambda = 1.0F;
                           if (dPos.x != 0.0F) {
                              hitLambda = hitPoint.x / dPos.x;
                           } else if (dPos.y != 0.0F) {
                              hitLambda = hitPoint.y / dPos.y;
                           } else if (dPos.z != 0.0F) {
                              hitLambda = hitPoint.z / dPos.z;
                           }

                           if (hitLambda < 0.0F) {
                              hitLambda = -hitLambda;
                           }

                           hits.add(new EntityHit(entity, hitLambda));
                        }
                     }
                  }
               }

               if (!hits.isEmpty()) {
                  Collections.sort(hits);
                  swingDistance = dPos.length();
                  var37 = hits.iterator();

                  while(var37.hasNext()) {
                     bulletHit = (BulletHit)var37.next();
                     if (bulletHit instanceof PlayerBulletHit) {
                        playerHit = (PlayerBulletHit)bulletHit;
                        damageMultiplier = 1.0F;
                        switch(playerHit.hitbox.type) {
                        case LEFTITEM:
                        case RIGHTITEM:
                           PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, (double)this.type.meleeSoundRange, player.field_71093_bK, this.type.ShieldHitSound, true);
                           data.meleeProgress = data.meleeLength = 0;
                           return;
                        case HEAD:
                           damageMultiplier = 2.0F;
                           break;
                        case RIGHTARM:
                        case LEFTARM:
                           damageMultiplier = 0.6F;
                        }

                        if (playerHit.hitbox.player.func_70097_a(this.getMeleeDamage(player), swingDistance * this.type.meleeDamage)) {
                           PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, (double)this.type.meleeSoundRange, player.field_71093_bK, this.type.meleeHitSound, true);
                           ++playerHit.hitbox.player.field_70720_be;
                           playerHit.hitbox.player.field_70172_ad = playerHit.hitbox.player.field_70771_an / 2;
                           sliceCrossHair = true;
                        }

                        if (FlansMod.DEBUG) {
                           world.func_72838_d(new EntityDebugDot(world, new Vector3f(data.lastMeleePositions[k].x + dPos.x * playerHit.intersectTime, data.lastMeleePositions[k].y + dPos.y * playerHit.intersectTime, data.lastMeleePositions[k].z + dPos.z * playerHit.intersectTime), 1000, 1.0F, 0.0F, 0.0F));
                        }
                     } else if (bulletHit instanceof EntityHit) {
                        entityHit = (EntityHit)bulletHit;
                        if (entityHit.entity.func_70097_a(DamageSource.func_76365_a(player), swingDistance * this.type.meleeDamage) && entityHit.entity instanceof EntityLivingBase) {
                           living = (EntityLivingBase)entityHit.entity;
                           PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, (double)this.type.meleeSoundRange, player.field_71093_bK, this.type.meleeHitSound, true);
                           ++living.field_70720_be;
                           living.field_70172_ad = living.field_70771_an / 2;
                        }

                        if (FlansMod.DEBUG) {
                           world.func_72838_d(new EntityDebugDot(world, new Vector3f(data.lastMeleePositions[k].x + dPos.x * entityHit.intersectTime, data.lastMeleePositions[k].y + dPos.y * entityHit.intersectTime, data.lastMeleePositions[k].z + dPos.z * entityHit.intersectTime), 1000, 1.0F, 0.0F, 0.0F));
                        }
                     }
                  }
               }

               data.lastMeleePositions[k] = nextPosInWorldCoords;
            }

            ++data.meleeProgress;
            if (data.meleeProgress == data.meleeLength) {
               data.meleeProgress = data.meleeLength = 0;
            }
         }
      }

   }

   public DamageSource getMeleeDamage(EntityPlayer attacker) {
      return new EntityDamageSourceGun(this.type.shortName, attacker, attacker, this.type, false);
   }

   public void onMouseHeld(ItemStack stack, World world, EntityPlayerMP player, boolean left, boolean isShooting) {
      PlayerData data = PlayerHandler.getPlayerData((EntityPlayer)player);
      if (data != null && data.shootClickDelay == 0) {
         if (player.field_70154_o instanceof EntitySeat && !((EntitySeat)player.field_70154_o).seatInfo.canSmallArms) {
            return;
         }

         if (left && data.offHandGunSlot != 0) {
            ItemStack offHandGunStack = player.field_71071_by.func_70301_a(data.offHandGunSlot - 1);
            GunType gunType = ((ItemGun)offHandGunStack.func_77973_b()).type;
            data.isShootingLeft = isShooting;
            if (gunType.getFireMode(offHandGunStack) == EnumFireMode.SEMIAUTO && isShooting) {
               data.isShootingLeft = false;
               player.field_71071_by.func_70299_a(data.offHandGunSlot - 1, this.tryToShoot(offHandGunStack, gunType, world, player, true));
            }

            if (gunType.getFireMode(offHandGunStack) == EnumFireMode.BURST && isShooting && data.burstRoundsRemainingLeft == 0) {
               data.isShootingLeft = false;
               data.burstRoundsRemainingLeft = gunType.numBurstRounds;
               player.field_71071_by.func_70299_a(data.offHandGunSlot - 1, this.tryToShoot(offHandGunStack, gunType, world, player, true));
            }
         } else {
            data.isShootingRight = isShooting;
            if (this.type.getFireMode(stack) == EnumFireMode.SEMIAUTO && isShooting) {
               data.isShootingRight = false;
               player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, this.tryToShoot(stack, this.type, world, player, false));
            }

            if (this.type.getFireMode(stack) == EnumFireMode.BURST && isShooting && data.burstRoundsRemainingRight == 0) {
               data.isShootingRight = false;
               data.burstRoundsRemainingRight = this.type.numBurstRounds;
               player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, this.tryToShoot(stack, this.type, world, player, false));
            }
         }

         if (this.type.useLoopingSounds && isShooting) {
            data.shouldPlayWarmupSound = true;
         }
      }

   }

   public ItemStack tryToShoot(ItemStack gunStack, GunType gunType, World world, EntityPlayerMP entityplayer, boolean left) {
      if (this.type.deployable) {
         return gunStack;
      } else {
         PlayerData data = PlayerHandler.getPlayerData((EntityPlayer)entityplayer);
         if (left && data.shootTimeLeft <= 0 || !left && data.shootTimeRight <= 0) {
            int bulletID = 0;

            ItemStack bulletStack;
            for(bulletStack = null; bulletID < gunType.getNumAmmoItemsInGun(gunStack); ++bulletID) {
               ItemStack checkingStack = this.getBulletItemStack(gunStack, bulletID);
               if (checkingStack != null && checkingStack.func_77973_b() != null && checkingStack.func_77960_j() < checkingStack.func_77958_k()) {
                  bulletStack = checkingStack;
                  break;
               }
            }

            if (bulletStack == null) {
               if (this.reload(gunStack, gunType, world, entityplayer, false, left)) {
                  data.shootTimeRight = data.shootTimeLeft = (int)gunType.getReloadTime(gunStack);
                  if (left) {
                     data.reloadingLeft = true;
                     data.burstRoundsRemainingLeft = 0;
                  } else {
                     data.reloadingRight = true;
                     data.burstRoundsRemainingRight = 0;
                  }

                  FlansMod.getPacketHandler().sendTo((PacketBase)(new PacketReload(left)), entityplayer);
                  String soundToPlay = null;
                  AttachmentType grip = gunType.getGrip(gunStack);
                  if (gunType.getSecondaryFire(gunStack) && grip != null && grip.secondaryReloadSound != null) {
                     soundToPlay = grip.secondaryReloadSound;
                  } else if (gunType.reloadSoundOnEmpty != null) {
                     soundToPlay = gunType.reloadSoundOnEmpty;
                  } else if (gunType.reloadSound != null) {
                     soundToPlay = gunType.reloadSound;
                  }

                  if (soundToPlay != null) {
                     PacketPlaySound.sendSoundPacket(entityplayer.field_70165_t, entityplayer.field_70163_u, entityplayer.field_70161_v, (double)this.type.reloadSoundRange, entityplayer.field_71093_bK, soundToPlay, true);
                  }
               } else if (gunType.clickSoundOnEmpty != null && this.canClick) {
                  System.out.println("Playing sound");
                  PacketPlaySound.sendSoundPacket(entityplayer.field_70165_t, entityplayer.field_70163_u, entityplayer.field_70161_v, (double)this.type.reloadSoundRange, entityplayer.field_71093_bK, gunType.clickSoundOnEmpty, true);
                  this.canClick = false;
               }
            } else if (bulletStack.func_77973_b() instanceof ItemShootable && sprinting && FlansModClient.zoomProgress > 0.5F || bulletStack.func_77973_b() instanceof ItemShootable && !sprinting) {
               this.shoot(gunStack, gunType, world, bulletStack, entityplayer, left);
               this.canClick = true;
               bulletStack.func_77964_b(bulletStack.func_77960_j() + 1);
               this.setBulletItemStack(gunStack, bulletStack, bulletID);
               if (gunType.getFireMode(gunStack) == EnumFireMode.BURST) {
                  if (left && data.burstRoundsRemainingLeft > 0) {
                     --data.burstRoundsRemainingLeft;
                  }

                  if (!left && data.burstRoundsRemainingRight > 0) {
                     --data.burstRoundsRemainingRight;
                  }
               }

               if (gunType.consumeGunUponUse) {
                  return null;
               }
            }
         }

         return gunStack;
      }
   }

   public boolean reload(ItemStack gunStack, GunType gunType, World world, EntityPlayer player, boolean forceReload, boolean left) {
      return this.reload(gunStack, gunType, world, player, player.field_71071_by, player.field_71075_bZ.field_75098_d, forceReload);
   }

   public boolean reload(ItemStack gunStack, GunType gunType, World world, Entity entity, IInventory inventory, boolean creative, boolean forceReload) {
      if (gunType.deployable) {
         return false;
      } else if (forceReload && !gunType.canForceReload) {
         return false;
      } else {
         boolean reloadedSomething = false;

         for(int i = 0; i < gunType.getNumAmmoItemsInGun(gunStack); ++i) {
            ItemStack bulletStack = this.getBulletItemStack(gunStack, i);
            if (bulletStack == null || bulletStack.func_77960_j() == bulletStack.func_77958_k() || forceReload) {
               int bestSlot = -1;
               int bulletsInBestSlot = 0;

               for(int j = 0; j < inventory.func_70302_i_(); ++j) {
                  ItemStack item = inventory.func_70301_a(j);
                  if (item != null && item.func_77973_b() instanceof ItemShootable && gunType.isAmmo(((ItemShootable)((ItemShootable)item.func_77973_b())).type, gunStack)) {
                     int bulletsInThisSlot = item.func_77958_k() - item.func_77960_j();
                     if (bulletsInThisSlot > bulletsInBestSlot) {
                        bestSlot = j;
                        bulletsInBestSlot = bulletsInThisSlot;
                     }
                  }
               }

               if (bestSlot != -1) {
                  ItemStack newBulletStack = inventory.func_70301_a(bestSlot);
                  ShootableType newBulletType = ((ItemShootable)newBulletStack.func_77973_b()).type;
                  if (bulletStack != null && bulletStack.func_77973_b() instanceof ItemShootable && ((ItemShootable)bulletStack.func_77973_b()).type.dropItemOnReload != null && !creative && bulletStack.func_77960_j() == bulletStack.func_77958_k()) {
                     dropItem(world, entity, ((ItemShootable)bulletStack.func_77973_b()).type.dropItemOnReload);
                  }

                  if (bulletStack != null && bulletStack.func_77960_j() < bulletStack.func_77958_k() && !InventoryHelper.addItemStackToInventory(inventory, bulletStack, creative)) {
                     entity.func_70099_a(bulletStack, 0.5F);
                  }

                  ItemStack stackToLoad = newBulletStack.func_77946_l();
                  stackToLoad.field_77994_a = 1;
                  this.setBulletItemStack(gunStack, stackToLoad, i);
                  if (!creative) {
                     --newBulletStack.field_77994_a;
                  }

                  if (newBulletStack.field_77994_a <= 0) {
                     newBulletStack = null;
                  }

                  inventory.func_70299_a(bestSlot, newBulletStack);
                  reloadedSomething = true;
               }
            }
         }

         return reloadedSomething;
      }
   }

   public static void dropItem(World world, Entity entity, String itemName) {
      if (itemName != null) {
         int damage = 0;
         if (itemName.contains(".")) {
            damage = Integer.parseInt(itemName.split("\\.")[1]);
            itemName = itemName.split("\\.")[0];
         }

         ItemStack dropStack = InfoType.getRecipeElement(itemName, damage);
         entity.func_70099_a(dropStack, 0.5F);
      }

   }

   private void shoot(ItemStack stack, GunType gunType, World world, ItemStack bulletStack, EntityPlayer entityPlayer, boolean left) {
      ShootableType bullet = ((ItemShootable)bulletStack.func_77973_b()).type;
      boolean lastBullet = false;
      ItemStack[] bulletStacks = new ItemStack[this.type.getNumAmmoItemsInGun(stack)];

      for(int i = 0; i < this.type.getNumAmmoItemsInGun(stack); ++i) {
         bulletStacks[i] = ((ItemGun)stack.func_77973_b()).getBulletItemStack(stack, i);
         if (bulletStacks[i] != null && bulletStacks[i].func_77973_b() instanceof ItemBullet && bulletStacks[i].func_77958_k() - bulletStacks[i].func_77960_j() == 1) {
            lastBullet = true;
         }
      }

      if (this.soundDelay <= 0 && gunType.shootSound != null) {
         AttachmentType barrel = gunType.getBarrel(stack);
         AttachmentType grip = gunType.getGrip(stack);
         boolean silenced = barrel != null && barrel.silencer && !gunType.getSecondaryFire(stack);
         String soundToPlay = null;
         if (gunType.getSecondaryFire(stack) && grip != null && grip.secondaryShootSound != null) {
            soundToPlay = grip.secondaryShootSound;
         } else if (lastBullet && gunType.lastShootSound != null) {
            soundToPlay = gunType.lastShootSound;
         } else if (silenced && gunType.suppressedShootSound != null) {
            soundToPlay = gunType.suppressedShootSound;
         } else if (gunType.shootSound != null) {
            soundToPlay = gunType.shootSound;
         }

         if (soundToPlay != null) {
            PacketPlaySound.sendSoundPacket(entityPlayer.field_70165_t, entityPlayer.field_70163_u, entityPlayer.field_70161_v, (double)this.type.gunSoundRange, entityPlayer.field_71093_bK, soundToPlay, gunType.distortSound, silenced);
         }

         this.soundDelay = gunType.shootSoundLength;
      }

      if (!world.field_72995_K && bulletStack.func_77973_b() instanceof ItemShootable) {
         ItemShootable itemShootable = (ItemShootable)bulletStack.func_77973_b();
         ShootableType shootableType = itemShootable.type;
         int numBullets = -1;
         float spread = -1.0F;
         if (shootableType instanceof BulletType) {
            if (gunType.allowNumBulletsByBulletType) {
               numBullets = ((BulletType)shootableType).numBullets;
            }

            if (gunType.allowSpreadByBullet) {
               spread = ((BulletType)shootableType).bulletSpread;
            }
         }

         if (numBullets <= 0) {
            numBullets = gunType.getNumBullets(stack);
         }

         if (spread <= 0.0F) {
            float result = gunType.getSpread(stack);
            if (entityPlayer.func_70093_af()) {
               result *= 0.9F;
            }

            if (entityPlayer.func_70051_ag()) {
               result *= 1.75F;
            }

            spread = result;
         }

         for(int k = 0; k < numBullets; ++k) {
            world.func_72838_d(itemShootable.getEntity(world, entityPlayer, (entityPlayer.func_70093_af() ? 0.7F : 1.0F) * spread, gunType.getDamage(stack), gunType.getBulletSpeed(stack), numBullets > 1, bulletStack.func_77960_j(), gunType));
         }

         FlansMod.packetHandler.sendTo((PacketBase)(new PacketGunRecoil(gunType.getRecoilPitch(stack), gunType.getRecoilYaw(stack), gunType.decreaseRecoilPitch, gunType.decreaseRecoilYaw)), (EntityPlayerMP)entityPlayer);
         if (bullet.dropItemOnShoot != null && !entityPlayer.field_71075_bZ.field_75098_d) {
            dropItem(world, entityPlayer, bullet.dropItemOnShoot);
         }

         if (gunType.dropItemOnShoot != null) {
            dropItem(world, entityPlayer, gunType.dropItemOnShoot);
         }
      }

      if (left) {
         PlayerHandler.getPlayerData(entityPlayer).shootTimeLeft = gunType.getShootDelay(stack);
      } else {
         PlayerHandler.getPlayerData(entityPlayer).shootTimeRight = gunType.getShootDelay(stack);
      }

      if (gunType.knockback > 0.0F) {
      }

   }

   public ItemStack func_77659_a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
      if (this.type.deployable) {
         float cosYaw = MathHelper.func_76134_b(-entityplayer.field_70177_z * 0.01745329F - 3.141593F);
         float sinYaw = MathHelper.func_76126_a(-entityplayer.field_70177_z * 0.01745329F - 3.141593F);
         float cosPitch = -MathHelper.func_76134_b(-entityplayer.field_70125_A * 0.01745329F);
         float sinPitch = MathHelper.func_76126_a(-entityplayer.field_70125_A * 0.01745329F);
         double length = 5.0D;
         Vec3 posVec = Vec3.func_72443_a(entityplayer.field_70165_t, entityplayer.field_70163_u + 1.62D - (double)entityplayer.field_70129_M, entityplayer.field_70161_v);
         Vec3 lookVec = posVec.func_72441_c((double)(sinYaw * cosPitch) * length, (double)sinPitch * length, (double)(cosYaw * cosPitch) * length);
         MovingObjectPosition look = world.func_72901_a(posVec, lookVec, true);
         if (look != null && look.field_72313_a == MovingObjectType.BLOCK && look.field_72310_e == 1) {
            int playerDir = MathHelper.func_76128_c((double)(entityplayer.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3;
            int i = look.field_72311_b;
            int j = look.field_72312_c;
            int k = look.field_72309_d;
            if (!world.field_72995_K) {
               if (world.func_147439_a(i, j, k) == Blocks.field_150433_aE) {
                  --j;
               }

               if (this.isSolid(world, i, j, k) && (world.func_147439_a(i, j + 1, k) == Blocks.field_150350_a || world.func_147439_a(i, j + 1, k) == Blocks.field_150433_aE) && world.func_147439_a(i + (playerDir == 1 ? 1 : 0) - (playerDir == 3 ? 1 : 0), j + 1, k - (playerDir == 0 ? 1 : 0) + (playerDir == 2 ? 1 : 0)) == Blocks.field_150350_a && (world.func_147439_a(i + (playerDir == 1 ? 1 : 0) - (playerDir == 3 ? 1 : 0), j, k - (playerDir == 0 ? 1 : 0) + (playerDir == 2 ? 1 : 0)) == Blocks.field_150350_a || world.func_147439_a(i + (playerDir == 1 ? 1 : 0) - (playerDir == 3 ? 1 : 0), j, k - (playerDir == 0 ? 1 : 0) + (playerDir == 2 ? 1 : 0)) == Blocks.field_150433_aE)) {
                  Iterator var17 = EntityMG.mgs.iterator();

                  while(var17.hasNext()) {
                     EntityMG mg = (EntityMG)var17.next();
                     if (mg.blockX == i && mg.blockY == j + 1 && mg.blockZ == k && !mg.field_70128_L) {
                        return itemstack;
                     }
                  }

                  if (!world.field_72995_K) {
                     world.func_72838_d(new EntityMG(world, i, j + 1, k, playerDir, this.type));
                  }

                  if (!entityplayer.field_71075_bZ.field_75098_d) {
                     itemstack.field_77994_a = 0;
                  }
               }
            }
         }
      }

      if (world.field_72995_K) {
         for(int i = 0; i < 3; ++i) {
            Minecraft.func_71410_x().field_71460_t.field_78516_c.func_78441_a();
         }
      }

      return itemstack;
   }

   private boolean isSolid(World world, int i, int j, int k) {
      Block block = world.func_147439_a(i, j, k);
      return block != null && block.func_149688_o().func_76220_a() && block.func_149662_c();
   }

   public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
      return this.type.secondaryFunction != EnumSecondaryFunction.MELEE;
   }

   public boolean func_77662_d() {
      return true;
   }

   public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
      if (this.type.meleeSound != null) {
         PacketPlaySound.sendSoundPacket(entityLiving.field_70165_t, entityLiving.field_70163_u, entityLiving.field_70161_v, (double)this.type.meleeSoundRange, entityLiving.field_71093_bK, this.type.meleeSound, true);
      }

      GunAnimations animations;
      PlayerData data;
      if (this.type.secondaryFunction == EnumSecondaryFunction.CUSTOM_MELEE && !this.blocking && this.type.meleeLeft && AHeld) {
         if (entityLiving.field_70170_p.field_72995_K) {
            animations = FlansModClient.getGunAnimations(entityLiving, false);
            animations.doMeleeLeft(this.type.meleeTime);
         }

         if (entityLiving instanceof EntityPlayer) {
            data = PlayerHandler.getPlayerData((EntityPlayer)entityLiving);
            data.doMeleeLeft((EntityPlayer)entityLiving, this.type.meleeTime, this.type);
         }
      } else if (this.type.secondaryFunction == EnumSecondaryFunction.CUSTOM_MELEE && !this.blocking && this.type.meleeRight && DHeld) {
         if (entityLiving.field_70170_p.field_72995_K) {
            animations = FlansModClient.getGunAnimations(entityLiving, false);
            animations.doMeleeRight(this.type.meleeTime);
         }

         if (entityLiving instanceof EntityPlayer) {
            data = PlayerHandler.getPlayerData((EntityPlayer)entityLiving);
            data.doMeleeRight((EntityPlayer)entityLiving, this.type.meleeTime, this.type);
         }
      } else if (this.type.secondaryFunction == EnumSecondaryFunction.CUSTOM_MELEE && !this.blocking && this.type.meleeDown && WHeld) {
         if (entityLiving.field_70170_p.field_72995_K) {
            animations = FlansModClient.getGunAnimations(entityLiving, false);
            animations.doMeleeDown(this.type.meleeTime);
         }

         if (entityLiving instanceof EntityPlayer) {
            data = PlayerHandler.getPlayerData((EntityPlayer)entityLiving);
            data.doMeleeDown((EntityPlayer)entityLiving, this.type.meleeTime, this.type);
         }
      } else if (this.type.secondaryFunction == EnumSecondaryFunction.CUSTOM_MELEE && !this.blocking && !this.type.lance || this.type.secondaryFunction == EnumSecondaryFunction.CUSTOM_MELEE && !this.blocking && this.type.lance && WHeld) {
         if (entityLiving.field_70170_p.field_72995_K) {
            animations = FlansModClient.getGunAnimations(entityLiving, false);
            animations.doMelee(this.type.meleeTime);
         }

         if (entityLiving instanceof EntityPlayer) {
            data = PlayerHandler.getPlayerData((EntityPlayer)entityLiving);
            data.doMelee((EntityPlayer)entityLiving, this.type.meleeTime, this.type);
         }
      }

      return this.type.secondaryFunction != EnumSecondaryFunction.MELEE;
   }

   public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z, EntityPlayer player) {
      return true;
   }

   public boolean func_150897_b(Block p_150897_1_) {
      return false;
   }

   @SubscribeEvent
   public void onEventBlockBreak(BreakEvent event) {
      EntityPlayer player = event.getPlayer();
      if (player != null && player.func_70694_bm() != null && player.func_70694_bm().func_77973_b() instanceof ItemGun) {
         event.setCanceled(true);
      }

   }

   @SideOnly(Side.CLIENT)
   public int func_82790_a(ItemStack par1ItemStack, int par2) {
      return this.type.colour;
   }

   public boolean isItemStackDamageable() {
      return true;
   }

   public void func_150895_a(Item item, CreativeTabs tabs, List list) {
      PaintableType type = ((IPaintableItem)item).GetPaintableType();
      if (FlansMod.addAllPaintjobsToCreative) {
         Iterator var5 = type.paintjobs.iterator();

         while(var5.hasNext()) {
            Paintjob paintjob = (Paintjob)var5.next();
            this.addPaintjobToList(item, type, paintjob, list);
         }
      } else {
         this.addPaintjobToList(item, type, type.defaultPaintjob, list);
      }

   }

   private void addPaintjobToList(Item item, PaintableType type, Paintjob paintjob, List list) {
      ItemStack paintableStack = new ItemStack(item, 1, paintjob.ID);
      NBTTagCompound tags = new NBTTagCompound();
      paintableStack.func_77982_d(tags);
      list.add(paintableStack);
   }

   @SideOnly(Side.CLIENT)
   public void func_94581_a(IIconRegister icon) {
      this.icons = new IIcon[this.type.paintjobs.size()];
      this.defaultIcon = icon.func_94245_a("flansmod:null");
      this.field_77791_bV = icon.func_94245_a("FlansMod:" + this.type.iconPath);

      for(int i = 0; i < this.type.paintjobs.size(); ++i) {
         this.icons[i] = icon.func_94245_a("FlansMod:" + ((Paintjob)this.type.paintjobs.get(i)).iconName);
      }

   }

   @SideOnly(Side.CLIENT)
   public IIcon func_77650_f(ItemStack stack) {
      return this.icons != null ? this.icons[stack.func_77960_j()] : this.defaultIcon;
   }

   public int func_77626_a(ItemStack par1ItemStack) {
      return 100;
   }

   public EnumAction func_77661_b(ItemStack par1ItemStack) {
      return this.type != null ? this.type.itemUseAction : EnumAction.bow;
   }

   public Multimap getAttributeModifiers(ItemStack stack) {
      Multimap map = super.getAttributeModifiers(stack);
      map.put(SharedMonsterAttributes.field_111266_c.func_111108_a(), new AttributeModifier(field_111210_e, "KnockbackResist", (double)this.type.knockbackModifier, 0));
      map.put(SharedMonsterAttributes.field_111263_d.func_111108_a(), new AttributeModifier(field_111210_e, "MovementSpeed", (double)(this.type.getMovementSpeed(stack) - 1.0F), 2));
      if (this.type.secondaryFunction == EnumSecondaryFunction.MELEE) {
         map.put(SharedMonsterAttributes.field_111264_e.func_111108_a(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.type.meleeDamage, 0));
      }

      return map;
   }

   public static float roundFloat(float value, int points) {
      int pow = 10;

      for(int i = 1; i < points; ++i) {
         pow *= 10;
      }

      float result = value * (float)pow;
      return (float)((int)(result - (float)((int)result) >= 0.5F ? result + 1.0F : result)) / (float)pow;
   }
}
