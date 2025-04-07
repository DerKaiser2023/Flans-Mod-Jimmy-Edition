package com.flansmod.common.driveables.mechas;

import com.flansmod.client.debug.EntityDebugVector;
import com.flansmod.client.gui.GuiDriveableController;
import com.flansmod.client.model.GunAnimations;
import com.flansmod.common.FlansMod;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.driveables.DriveableData;
import com.flansmod.common.driveables.DriveablePart;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.driveables.EnumDriveablePart;
import com.flansmod.common.guns.BulletType;
import com.flansmod.common.guns.EnumFireMode;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.InventoryHelper;
import com.flansmod.common.guns.ItemBullet;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketDriveableDamage;
import com.flansmod.common.network.PacketDriveableGUI;
import com.flansmod.common.network.PacketDriveableKey;
import com.flansmod.common.network.PacketMechaControl;
import com.flansmod.common.network.PacketPlaySound;
import com.flansmod.common.teams.TeamsManager;
import com.flansmod.common.tools.ItemTool;
import com.flansmod.common.vector.Vector3f;
import com.flansmod.common.vector.Vector3i;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings.GameType;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

public class EntityMecha extends EntityDriveable {
   private int ticksSinceUsed;
   public int toggleTimer;
   private float moveX;
   private float moveZ;
   public RotatedAxes legAxes;
   public float prevLegsYaw;
   private int jumpDelay;
   public MechaInventory inventory;
   public float legSwing;
   public int shootDelayLeft;
   public int shootDelayRight;
   public int soundDelayLeft;
   public int soundDelayRight;
   public Vector3i breakingBlock;
   public float breakingProgress;
   private float rocketTimer;
   private int diamondTimer;
   public int legAnimTimer;
   public int legAnimMax;
   public int animState;
   public int targetLeftUpper;
   public int targetLeftLower;
   public int targetLeftFoot;
   public int targetLeftUpperSpeed;
   public int targetLeftLowerSpeed;
   public int targetLeftFootSpeed;
   int targetRightUpper;
   int targetRightLower;
   int targetRightFoot;
   int targetRightUpperSpeed;
   int targetRightLowerSpeed;
   int targetRightFootSpeed;
   public float leftLegUpperAngle;
   public float leftLegLowerAngle;
   public float leftFootAngle;
   public float rightLegUpperAngle;
   public float rightLegLowerAngle;
   public float rightFootAngle;
   public float prevLeftLegUpperAngle;
   public float prevLeftLegLowerAngle;
   public float prevLeftFootAngle;
   public float prevRightLegUpperAngle;
   public float prevRightLegLowerAngle;
   public float prevRightFootAngle;
   public float legPosition;
   public int stompDelay;
   public GunAnimations leftAnimations;
   public GunAnimations rightAnimations;
   boolean couldNotFindFuel;

   public EntityMecha(World world) {
      super(world);
      this.toggleTimer = 0;
      this.moveX = 0.0F;
      this.moveZ = 0.0F;
      this.prevLegsYaw = 0.0F;
      this.jumpDelay = 0;
      this.legSwing = 0.0F;
      this.shootDelayLeft = 0;
      this.shootDelayRight = 0;
      this.soundDelayLeft = 0;
      this.soundDelayRight = 0;
      this.breakingBlock = null;
      this.breakingProgress = 0.0F;
      this.rocketTimer = 0.0F;
      this.diamondTimer = 0;
      this.legAnimTimer = 1;
      this.legAnimMax = 1;
      this.targetLeftUpper = 0;
      this.targetLeftLower = 0;
      this.targetLeftFoot = 0;
      this.targetLeftUpperSpeed = 1;
      this.targetLeftLowerSpeed = 1;
      this.targetLeftFootSpeed = 1;
      this.targetRightUpper = 0;
      this.targetRightLower = 0;
      this.targetRightFoot = 0;
      this.targetRightUpperSpeed = 1;
      this.targetRightLowerSpeed = 1;
      this.targetRightFootSpeed = 1;
      this.leftLegUpperAngle = 0.0F;
      this.leftLegLowerAngle = 0.0F;
      this.leftFootAngle = 0.0F;
      this.rightLegUpperAngle = 0.0F;
      this.rightLegLowerAngle = 0.0F;
      this.rightFootAngle = 0.0F;
      this.prevLeftLegUpperAngle = 0.0F;
      this.prevLeftLegLowerAngle = 0.0F;
      this.prevLeftFootAngle = 0.0F;
      this.prevRightLegUpperAngle = 0.0F;
      this.prevRightLegLowerAngle = 0.0F;
      this.prevRightFootAngle = 0.0F;
      this.legPosition = 0.0F;
      this.leftAnimations = new GunAnimations();
      this.rightAnimations = new GunAnimations();
      this.func_70105_a(2.0F, 3.0F);
      this.field_70138_W = 3.0F;
      this.legAxes = new RotatedAxes();
      this.inventory = new MechaInventory(this);
      this.isMecha = true;
   }

   public EntityMecha(World world, double x, double y, double z, MechaType type, DriveableData data, NBTTagCompound tags) {
      super(world, type, data);
      this.toggleTimer = 0;
      this.moveX = 0.0F;
      this.moveZ = 0.0F;
      this.prevLegsYaw = 0.0F;
      this.jumpDelay = 0;
      this.legSwing = 0.0F;
      this.shootDelayLeft = 0;
      this.shootDelayRight = 0;
      this.soundDelayLeft = 0;
      this.soundDelayRight = 0;
      this.breakingBlock = null;
      this.breakingProgress = 0.0F;
      this.rocketTimer = 0.0F;
      this.diamondTimer = 0;
      this.legAnimTimer = 1;
      this.legAnimMax = 1;
      this.targetLeftUpper = 0;
      this.targetLeftLower = 0;
      this.targetLeftFoot = 0;
      this.targetLeftUpperSpeed = 1;
      this.targetLeftLowerSpeed = 1;
      this.targetLeftFootSpeed = 1;
      this.targetRightUpper = 0;
      this.targetRightLower = 0;
      this.targetRightFoot = 0;
      this.targetRightUpperSpeed = 1;
      this.targetRightLowerSpeed = 1;
      this.targetRightFootSpeed = 1;
      this.leftLegUpperAngle = 0.0F;
      this.leftLegLowerAngle = 0.0F;
      this.leftFootAngle = 0.0F;
      this.rightLegUpperAngle = 0.0F;
      this.rightLegLowerAngle = 0.0F;
      this.rightFootAngle = 0.0F;
      this.prevLeftLegUpperAngle = 0.0F;
      this.prevLeftLegLowerAngle = 0.0F;
      this.prevLeftFootAngle = 0.0F;
      this.prevRightLegUpperAngle = 0.0F;
      this.prevRightLegLowerAngle = 0.0F;
      this.prevRightFootAngle = 0.0F;
      this.legPosition = 0.0F;
      this.leftAnimations = new GunAnimations();
      this.rightAnimations = new GunAnimations();
      this.legAxes = new RotatedAxes();
      this.func_70105_a(2.0F, 3.0F);
      this.field_70138_W = 3.0F;
      this.func_70107_b(x, y, z);
      this.initType(type, false);
      this.inventory = new MechaInventory(this, tags);
      this.isMecha = true;
   }

   public EntityMecha(World world, double x, double y, double z, EntityPlayer placer, MechaType type, DriveableData data, NBTTagCompound tags) {
      this(world, x, y, z, type, data, tags);
      this.rotateYaw(placer.field_70177_z + 90.0F);
      this.legAxes.rotateGlobalYaw(placer.field_70177_z + 90.0F);
      this.prevLegsYaw = this.legAxes.getYaw();
      this.isMecha = true;
   }

   protected void initType(DriveableType type, boolean clientSide) {
      super.initType(type, clientSide);
      this.func_70105_a(((MechaType)type).width, ((MechaType)type).height);
      this.field_70138_W = (float)((MechaType)type).stepHeight;
      this.isMecha = true;
   }

   protected void func_70014_b(NBTTagCompound tag) {
      super.func_70014_b(tag);
      tag.func_74776_a("LegsYaw", this.legAxes.getYaw());
      tag.func_74782_a("Inventory", this.inventory.writeToNBT(new NBTTagCompound()));
      this.isMecha = true;
   }

   protected void func_70037_a(NBTTagCompound tag) {
      super.func_70037_a(tag);
      this.legAxes.setAngles(tag.func_74760_g("LegsYaw"), 0.0F, 0.0F);
      this.inventory.readFromNBT(tag.func_74775_l("Inventory"));
      this.isMecha = true;
   }

   public void writeSpawnData(ByteBuf data) {
      super.writeSpawnData(data);
      ByteBufUtils.writeTag(data, this.inventory.writeToNBT(new NBTTagCompound()));
      this.isMecha = true;
   }

   public void readSpawnData(ByteBuf data) {
      super.readSpawnData(data);
      this.legAxes.rotateGlobalYaw(this.axes.getYaw());
      this.prevLegsYaw = this.legAxes.getYaw();
      this.inventory.readFromNBT(ByteBufUtils.readTag(data));
      this.isMecha = true;
   }

   public void onMouseMoved(int deltaX, int deltaY) {
   }

   public boolean func_130002_c(EntityPlayer entityplayer) {
      if (this.field_70128_L) {
         return false;
      } else if (this.field_70170_p.field_72995_K) {
         return false;
      } else {
         ItemStack currentItem = entityplayer.func_71045_bC();
         if (currentItem != null && currentItem.func_77973_b() instanceof ItemTool && ((ItemTool)currentItem.func_77973_b()).type.healDriveables) {
            return true;
         } else {
            MechaType type = this.getMechaType();

            for(int i = 0; i <= type.numPassengers; ++i) {
               if (this.seats[i].func_130002_c(entityplayer)) {
                  return true;
               }
            }

            return false;
         }
      }
   }

   public MechaType getMechaType() {
      return MechaType.getMecha(this.driveableType);
   }

   public boolean pressKey(int key, EntityPlayer player) {
      MechaType type = this.getMechaType();
      DriveableData data = this.getDriveableData();
      if (!this.field_70170_p.field_72995_K || key != 6 && key != 8 && key != 9) {
         switch(key) {
         case 0:
            return true;
         case 1:
            return true;
         case 2:
            return true;
         case 3:
            return true;
         case 4:
            boolean canThrustCreatively = this.seats != null && this.seats[0] != null && this.seats[0].field_70153_n instanceof EntityPlayer && ((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d;
            if (this.field_70122_E && this.jumpDelay == 0 && (canThrustCreatively || data.fuelInTank > data.engine.fuelConsumption) && this.isPartIntact(EnumDriveablePart.hips)) {
               this.jumpDelay = 20;
               this.field_70181_x += (double)type.jumpVelocity;
               if (!canThrustCreatively) {
                  data.fuelInTank -= data.engine.fuelConsumption;
               }
            }

            return true;
         case 5:
            return true;
         case 6:
            this.seats[0].field_70153_n.func_70078_a((Entity)null);
            return true;
         case 7:
            FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketDriveableGUI(4)));
            ((EntityPlayer)this.seats[0].field_70153_n).openGui(FlansMod.INSTANCE, 10, this.field_70170_p, this.field_70176_ah, this.field_70162_ai, this.field_70164_aj);
            return true;
         case 8:
            return true;
         case 9:
            return true;
         case 10:
            return true;
         case 11:
            return true;
         case 12:
            return true;
         case 13:
            return true;
         case 14:
            return true;
         case 15:
            return true;
         case 16:
            return true;
         case 17:
            return true;
         default:
            return false;
         }
      } else {
         FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketDriveableKey(key)));
         return true;
      }
   }

   private boolean useItem(boolean left) {
      if (left) {
         if (!this.isPartIntact(EnumDriveablePart.leftArm)) {
            return true;
         }
      } else if (!this.isPartIntact(EnumDriveablePart.rightArm)) {
         return true;
      }

      boolean creative = !(this.seats[0].field_70153_n instanceof EntityPlayer) || ((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d;
      ItemStack heldStack = left ? this.inventory.getStackInSlot(EnumMechaSlotType.leftTool) : this.inventory.getStackInSlot(EnumMechaSlotType.rightTool);
      if (heldStack == null) {
         return false;
      } else {
         Item heldItem = heldStack.func_77973_b();
         MechaType mechaType = this.getMechaType();
         if (heldItem instanceof ItemMechaAddon) {
            MechaItemType toolType = ((ItemMechaAddon)heldItem).type;
            float reach = toolType.reach * mechaType.reach;
            Vector3f lookOrigin = new Vector3f((double)((float)mechaType.seats[0].x / 16.0F), (double)((float)mechaType.seats[0].y / 16.0F) + this.seats[0].field_70153_n.func_70042_X(), (double)((float)mechaType.seats[0].z / 16.0F));
            lookOrigin = this.axes.findLocalVectorGlobally(lookOrigin);
            Vector3f.add(lookOrigin, new Vector3f(this.field_70165_t, this.field_70163_u, this.field_70161_v), lookOrigin);
            Vector3f lookVector = this.axes.findLocalVectorGlobally(this.seats[0].looking.findLocalVectorGlobally(new Vector3f(reach, 0.0F, 0.0F)));
            this.field_70170_p.func_72838_d(new EntityDebugVector(this.field_70170_p, lookOrigin, lookVector, 20));
            Vector3f lookTarget = Vector3f.add(lookVector, lookOrigin, (Vector3f)null);
            MovingObjectPosition hit = this.field_70170_p.func_72933_a(lookOrigin.toVec3(), lookTarget.toVec3());
            if (hit != null && hit.field_72313_a == MovingObjectType.BLOCK) {
               if (this.breakingBlock == null || this.breakingBlock.x != hit.field_72311_b || this.breakingBlock.y != hit.field_72312_c || this.breakingBlock.z != hit.field_72309_d) {
                  this.breakingProgress = 0.0F;
               }

               this.breakingBlock = new Vector3i(hit.field_72311_b, hit.field_72312_c, hit.field_72309_d);
            }
         } else if (heldItem instanceof ItemGun) {
            ItemGun gunItem = (ItemGun)heldItem;
            GunType gunType = gunItem.type;
            if (heldStack.field_77990_d.func_74764_b("secondaryAmmo") && gunType.getSecondaryFire(heldStack)) {
               gunType.setSecondaryFire(heldStack, false);
            }

            int delay = left ? this.shootDelayLeft : this.shootDelayRight;
            if (delay <= 0) {
               int bulletID = 0;

               ItemStack bulletStack;
               for(bulletStack = null; bulletID < gunType.getNumAmmoItemsInGun(heldStack); ++bulletID) {
                  ItemStack checkingStack = gunItem.getBulletItemStack(heldStack, bulletID);
                  if (checkingStack != null && checkingStack.func_77973_b() != null && checkingStack.func_77960_j() < checkingStack.func_77958_k()) {
                     bulletStack = checkingStack;
                     break;
                  }
               }

               if (bulletStack == null) {
                  gunItem.reload(heldStack, gunType, this.field_70170_p, this, this.driveableData, this.infiniteAmmo() || creative, false);
               } else if (bulletStack.func_77973_b() instanceof ItemBullet) {
                  this.shoot(heldStack, gunType, bulletStack, creative, left);
                  if (this.field_70170_p.field_72995_K) {
                     int pumpDelay = gunType.model == null ? 0 : gunType.model.pumpDelay;
                     int pumpTime = gunType.model == null ? 1 : gunType.model.pumpTime;
                     int hammerDelay = gunType.model == null ? 0 : gunType.model.hammerDelay;
                     int casingDelay = gunType.model == null ? 0 : gunType.model.casingDelay;
                     float hammerAngle = gunType.model == null ? 0.0F : gunType.model.hammerAngle;
                     float althammerAngle = gunType.model == null ? 0.0F : gunType.model.althammerAngle;
                     if (left) {
                        this.leftAnimations.doShoot(pumpDelay, pumpTime, hammerDelay, hammerAngle, althammerAngle, casingDelay);
                     } else {
                        this.rightAnimations.doShoot(pumpDelay, pumpTime, hammerDelay, hammerAngle, althammerAngle, casingDelay);
                     }
                  }

                  bulletStack.func_77964_b(bulletStack.func_77960_j() + 1);
                  gunItem.setBulletItemStack(heldStack, bulletStack, bulletID);
               }
            }
         }

         return true;
      }
   }

   private void shoot(ItemStack stack, GunType gunType, ItemStack bulletStack, boolean creative, boolean left) {
      MechaType mechaType = this.getMechaType();
      BulletType bulletType = ((ItemBullet)bulletStack.func_77973_b()).type;
      RotatedAxes a = new RotatedAxes();
      Vector3f armVector = new Vector3f(mechaType.armLength, 0.0F, 0.0F);
      Vector3f gunVector = new Vector3f(mechaType.armLength + 1.2F * mechaType.heldItemScale, 0.5F * mechaType.heldItemScale, 0.0F);
      Vector3f armOrigin = left ? mechaType.leftArmOrigin : mechaType.rightArmOrigin;
      a.rotateGlobalYaw(this.axes.getYaw());
      armOrigin = a.findLocalVectorGlobally(armOrigin);
      a.rotateLocalPitch(-this.seats[0].looking.getPitch());
      gunVector = a.findLocalVectorGlobally(gunVector);
      armVector = a.findLocalVectorGlobally(armVector);
      Vector3f bulletOrigin = Vector3f.add(armOrigin, gunVector, (Vector3f)null);
      bulletOrigin = Vector3f.add(new Vector3f(this.field_70165_t, this.field_70163_u, this.field_70161_v), bulletOrigin, (Vector3f)null);
      if (!this.field_70170_p.field_72995_K) {
         for(int k = 0; k < gunType.numBullets; ++k) {
            this.field_70170_p.func_72838_d(((ItemBullet)bulletStack.func_77973_b()).getEntity(this.field_70170_p, bulletOrigin, armVector, (EntityLivingBase)((EntityLivingBase)this.seats[0].field_70153_n), gunType.getSpread(stack) / 2.0F, gunType.getDamage(stack), gunType.getBulletSpeed(stack), bulletStack.func_77960_j(), mechaType));
         }
      }

      if (left) {
         this.shootDelayLeft = gunType.mode == EnumFireMode.SEMIAUTO ? Math.max(gunType.shootDelay, 5) : gunType.shootDelay;
      } else {
         this.shootDelayRight = gunType.mode == EnumFireMode.SEMIAUTO ? Math.max(gunType.shootDelay, 5) : gunType.shootDelay;
      }

      if (bulletType.dropItemOnShoot != null && !creative) {
         ItemGun.dropItem(this.field_70170_p, this, bulletType.dropItemOnShoot);
      }

      if ((left ? this.soundDelayLeft : this.soundDelayRight) <= 0 && gunType.shootSound != null) {
         PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, gunType.shootSound, gunType.distortSound);
         if (left) {
            this.soundDelayLeft = gunType.shootSoundLength;
         } else {
            this.soundDelayRight = gunType.shootSoundLength;
         }
      }

   }

   private boolean driverIsCreative() {
      return this.seats != null && this.seats[0] != null && this.seats[0].field_70153_n instanceof EntityPlayer && ((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d;
   }

   protected void func_70069_a(float f) {
      this.func_70097_a(DamageSource.field_76379_h, f);
   }

   public void setLegAngles(float LLU, float pLLU, float RLU, float pRLU, float LLL, float pLLL, float RLL, float pRLL, float LLF, float pLLF, float RLF, float pRLF) {
      this.leftLegUpperAngle = LLU;
      this.leftLegLowerAngle = LLL;
      this.leftFootAngle = LLF;
      this.rightLegUpperAngle = RLU;
      this.rightLegLowerAngle = RLL;
      this.rightFootAngle = RLF;
      this.prevLeftLegUpperAngle = pLLU;
      this.prevLeftLegLowerAngle = pLLL;
      this.prevLeftFootAngle = pLLF;
      this.prevRightLegUpperAngle = pRLU;
      this.prevRightLegLowerAngle = pRLL;
      this.prevRightFootAngle = pRLF;
   }

   public boolean func_70097_a(DamageSource damagesource, float i) {
      if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
         MechaType type = this.getMechaType();
         if (damagesource.func_76355_l().equals("fall")) {
            boolean takeFallDamage = type.takeFallDamage && !this.stopFallDamage();
            boolean damageBlocksFromFalling = type.damageBlocksFromFalling || this.breakBlocksUponFalling();
            byte wouldBeNegativeDamage;
            if (i * type.fallDamageMultiplier * this.vulnerability() - 2.0F < 0.0F) {
               wouldBeNegativeDamage = 0;
            } else {
               wouldBeNegativeDamage = 1;
            }

            float damageToInflict = takeFallDamage ? i * type.fallDamageMultiplier * this.vulnerability() * (float)wouldBeNegativeDamage : 0.0F;
            float blockDamageFromFalling = damageBlocksFromFalling ? i * type.blockDamageFromFalling / 10.0F : 0.0F;
            ((DriveablePart)this.driveableData.parts.get(EnumDriveablePart.hips)).attack(damageToInflict, false);
            this.checkParts();
            FlansMod.getPacketHandler().sendToAllAround(new PacketDriveableDamage(this), this.field_70165_t, this.field_70163_u, this.field_70161_v, 400.0F, this.field_71093_bK);
            if (blockDamageFromFalling > 1.0F) {
               this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, blockDamageFromFalling, TeamsManager.explosions);
            }
         } else if (damagesource.field_76373_n.equals("player") && damagesource.func_76346_g().field_70122_E && (this.seats[0] == null || this.seats[0].field_70153_n == null) && !this.locked) {
            ItemStack mechaStack = new ItemStack(type.item, 1, this.driveableData.paintjobID);
            mechaStack.field_77990_d = new NBTTagCompound();
            this.driveableData.writeToNBT(mechaStack.field_77990_d);
            this.inventory.writeToNBT(mechaStack.field_77990_d);
            this.func_70099_a(mechaStack, 0.5F);
            this.func_70106_y();
         } else {
            ((DriveablePart)this.driveableData.parts.get(EnumDriveablePart.core)).attack(i * this.vulnerability(), damagesource.func_76347_k());
         }

         return true;
      } else {
         return true;
      }
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      boolean legDir = true;
      if (this.legPosition > 1.0F) {
         this.legPosition = 0.0F;
      }

      this.prevLeftLegUpperAngle = this.leftLegUpperAngle;
      this.prevLeftLegLowerAngle = this.leftLegLowerAngle;
      this.prevLeftFootAngle = this.leftFootAngle;
      this.prevRightLegUpperAngle = this.rightLegUpperAngle;
      this.prevRightLegLowerAngle = this.rightLegLowerAngle;
      this.prevRightFootAngle = this.rightFootAngle;
      Iterator var2 = this.getMechaType().legNodes.iterator();

      while(var2.hasNext()) {
         MechaType.LegNode node = (MechaType.LegNode)var2.next();
         if (this.legPosition >= node.lowerBound && this.legPosition <= node.upperBound) {
            if (node.legPart == 1) {
               this.targetLeftUpper = node.rotation;
               this.targetLeftUpperSpeed = node.speed;
            } else if (node.legPart == 2) {
               this.targetLeftLower = node.rotation;
               this.targetLeftLowerSpeed = node.speed;
            } else if (node.legPart == 3) {
               this.targetLeftFoot = node.rotation;
               this.targetLeftFootSpeed = node.speed;
            } else if (node.legPart == 4) {
               this.targetRightUpper = node.rotation;
               this.targetRightUpperSpeed = node.speed;
            } else if (node.legPart == 5) {
               this.targetRightLower = node.rotation;
               this.targetRightLowerSpeed = node.speed;
            } else if (node.legPart == 6) {
               this.targetRightFoot = node.rotation;
               this.targetRightFootSpeed = node.speed;
            }
         }
      }

      if (this.leftLegUpperAngle < (float)this.targetLeftUpper) {
         this.leftLegUpperAngle += (float)this.targetLeftUpperSpeed;
      } else if (this.leftLegUpperAngle > (float)this.targetLeftUpper) {
         this.leftLegUpperAngle -= (float)this.targetLeftUpperSpeed;
      }

      if ((float)Math.sqrt((double)((this.leftLegUpperAngle - (float)this.targetLeftUpper) * (this.leftLegUpperAngle - (float)this.targetLeftUpper))) <= (float)(this.targetLeftUpperSpeed / 2)) {
         this.leftLegUpperAngle = (float)this.targetLeftUpper;
      }

      if (this.rightLegUpperAngle < (float)this.targetRightUpper) {
         this.rightLegUpperAngle += (float)this.targetRightUpperSpeed;
      } else if (this.rightLegUpperAngle > (float)this.targetRightUpper) {
         this.rightLegUpperAngle -= (float)this.targetRightUpperSpeed;
      }

      if ((float)Math.sqrt((double)((this.rightLegUpperAngle - (float)this.targetRightUpper) * (this.rightLegUpperAngle - (float)this.targetRightUpper))) <= (float)(this.targetRightUpperSpeed / 2)) {
         this.rightLegUpperAngle = (float)this.targetRightUpper;
      }

      if (this.leftLegLowerAngle < (float)this.targetLeftLower) {
         this.leftLegLowerAngle += (float)this.targetLeftLowerSpeed;
      } else if (this.leftLegLowerAngle > (float)this.targetLeftLower) {
         this.leftLegLowerAngle -= (float)this.targetRightLowerSpeed;
      }

      if (this.rightLegLowerAngle < (float)this.targetRightLower) {
         this.rightLegLowerAngle += (float)this.targetRightLowerSpeed;
      } else if (this.rightLegLowerAngle > (float)this.targetRightLower) {
         this.rightLegLowerAngle -= (float)this.targetRightLowerSpeed;
      }

      if ((float)Math.sqrt((double)((this.leftLegLowerAngle - (float)this.targetLeftLower) * (this.leftLegLowerAngle - (float)this.targetLeftLower))) <= (float)(this.targetLeftLowerSpeed / 2)) {
         this.leftLegLowerAngle = (float)this.targetLeftLower;
      }

      if ((float)Math.sqrt((double)((this.rightLegLowerAngle - (float)this.targetRightLower) * (this.rightLegLowerAngle - (float)this.targetRightLower))) <= (float)(this.targetRightLowerSpeed / 2)) {
         this.rightLegLowerAngle = (float)this.targetRightLower;
      }

      if (this.leftFootAngle < (float)this.targetLeftFoot) {
         this.leftFootAngle += (float)this.targetLeftFootSpeed;
      } else if (this.leftFootAngle > (float)this.targetLeftFoot) {
         this.leftFootAngle -= (float)this.targetLeftFootSpeed;
      }

      if (this.rightFootAngle < (float)this.targetRightFoot) {
         this.rightFootAngle += (float)this.targetRightFootSpeed;
      } else if (this.rightFootAngle > (float)this.targetRightFoot) {
         this.rightFootAngle -= (float)this.targetRightFootSpeed;
      }

      if ((float)Math.sqrt((double)((this.rightFootAngle - (float)this.targetRightFoot) * (this.rightFootAngle - (float)this.targetRightFoot))) <= (float)(this.targetRightFootSpeed / 2)) {
         this.rightFootAngle = (float)this.targetRightFoot;
      }

      if ((float)Math.sqrt((double)((this.leftFootAngle - (float)this.targetLeftFoot) * (this.leftFootAngle - (float)this.targetLeftFoot))) <= (float)(this.targetLeftFootSpeed / 2)) {
         this.leftFootAngle = (float)this.targetLeftFoot;
      }

      if (this.jumpDelay > 0) {
         --this.jumpDelay;
      }

      if (this.shootDelayLeft > 0) {
         --this.shootDelayLeft;
      }

      if (this.shootDelayRight > 0) {
         --this.shootDelayRight;
      }

      if (this.soundDelayLeft > 0) {
         --this.soundDelayLeft;
      }

      if (this.soundDelayRight > 0) {
         --this.soundDelayRight;
      }

      if (!this.field_70170_p.field_72995_K && (this.seats[0] == null || this.seats[0].field_70153_n == null)) {
         this.rightMouseHeld = this.leftMouseHeld = false;
      }

      this.leftAnimations.update();
      this.rightAnimations.update();
      MechaType type = this.getMechaType();
      DriveableData data = this.getDriveableData();
      if (type == null) {
         FlansMod.log("Mecha type null. Not ticking mecha");
      } else {
         if (this.stompDelay > 0) {
            --this.stompDelay;
         }

         this.prevLegsYaw = this.legAxes.getYaw();
         boolean driverIsCreative;
         if (this.toggleTimer == 0 && this.autoRepair()) {
            EnumDriveablePart[] var4 = EnumDriveablePart.values();
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               EnumDriveablePart part = var4[var6];
               DriveablePart thisPart = (DriveablePart)data.parts.get(part);
               driverIsCreative = this.seats != null && this.seats[0] != null && this.seats[0].field_70153_n instanceof EntityPlayer && ((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d;
               if (thisPart != null && thisPart.health != 0 && thisPart.health < thisPart.maxHealth && (driverIsCreative || data.fuelInTank >= 10.0F)) {
                  ++thisPart.health;
                  if (!driverIsCreative) {
                     data.fuelInTank -= 10.0F;
                  }
               }
            }

            this.toggleTimer = 20;
         }

         int z;
         float jetPack;
         float axesBody;
         int y;
         if (this.diamondDetect() != null && this.diamondTimer == 0 && this.field_70170_p.field_72995_K && this.seats[0] != null && this.seats[0].field_70153_n instanceof EntityPlayer && FlansMod.proxy.isThePlayer((EntityPlayer)this.seats[0].field_70153_n)) {
            float sqDistance = 901.0F;

            for(float i = -30.0F; i <= 30.0F; ++i) {
               for(jetPack = -30.0F; jetPack <= 30.0F; ++jetPack) {
                  for(axesBody = -30.0F; axesBody <= 30.0F; ++axesBody) {
                     int x = MathHelper.func_76128_c((double)i + this.field_70165_t);
                     y = MathHelper.func_76128_c((double)jetPack + this.field_70163_u);
                     z = MathHelper.func_76128_c((double)axesBody + this.field_70161_v);
                     if (i * i + jetPack * jetPack + axesBody * axesBody < sqDistance && this.field_70170_p.func_147439_a(x, y, z) == Blocks.field_150482_ag) {
                        sqDistance = i * i + jetPack * jetPack + axesBody * axesBody;
                     }
                  }
               }
            }

            if (sqDistance < 901.0F) {
               PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, this.diamondDetect().detectSound, false);
               this.diamondTimer = 1 + 2 * MathHelper.func_76141_d(MathHelper.func_76129_c(sqDistance));
            }
         }

         if (this.diamondTimer > 0) {
            --this.diamondTimer;
         }

         if (this.isPartIntact(EnumDriveablePart.hips)) {
            this.func_70105_a(type.width, type.height);
            this.field_70129_M = type.yOffset;
         } else {
            this.func_70105_a(type.width, type.height - type.chassisHeight);
            this.field_70129_M = type.yOffset - type.chassisHeight;
         }

         boolean thePlayerIsDrivingThis = this.field_70170_p.field_72995_K && this.seats[0] != null && this.seats[0].field_70153_n instanceof EntityPlayer && FlansMod.proxy.isThePlayer((EntityPlayer)this.seats[0].field_70153_n);
         boolean driverIsLiving = this.seats[0] != null && this.seats[0].field_70153_n instanceof EntityLivingBase;
         ++this.ticksSinceUsed;
         if (!this.field_70170_p.field_72995_K && this.seats[0].field_70153_n != null) {
            this.ticksSinceUsed = 0;
         }

         if (!this.field_70170_p.field_72995_K && TeamsManager.mechaLove > 0 && this.ticksSinceUsed > TeamsManager.mechaLove * 20) {
            this.func_70106_y();
         }

         if (this.toggleTimer > 0) {
            --this.toggleTimer;
         }

         double dYaw;
         if (this.field_70170_p.field_72995_K && !thePlayerIsDrivingThis && this.serverPositionTransitionTicker > 0) {
            double x = this.field_70165_t + (this.field_70118_ct - this.field_70165_t) / (double)this.serverPositionTransitionTicker;
            dYaw = this.field_70163_u + (this.field_70117_cu - this.field_70163_u) / (double)this.serverPositionTransitionTicker;
            double z = this.field_70161_v + (this.field_70116_cv - this.field_70161_v) / (double)this.serverPositionTransitionTicker;
            double dYaw = MathHelper.func_76138_g(this.serverYaw - (double)this.axes.getYaw());
            double dPitch = MathHelper.func_76138_g(this.serverPitch - (double)this.axes.getPitch());
            double dRoll = MathHelper.func_76138_g(this.serverRoll - (double)this.axes.getRoll());
            this.field_70177_z = (float)((double)this.axes.getYaw() + dYaw / (double)this.serverPositionTransitionTicker);
            this.field_70125_A = (float)((double)this.axes.getPitch() + dPitch / (double)this.serverPositionTransitionTicker);
            float rotationRoll = (float)((double)this.axes.getRoll() + dRoll / (double)this.serverPositionTransitionTicker);
            --this.serverPositionTransitionTicker;
            this.func_70107_b(x, dYaw, z);
            this.setRotation(this.field_70177_z, this.field_70125_A, rotationRoll);
         }

         if (this.seats[0] != null) {
            if (this.seats[0].field_70153_n instanceof EntityLivingBase && !(this.seats[0].field_70153_n instanceof EntityPlayer)) {
               this.axes.setAngles(((EntityLivingBase)this.seats[0].field_70153_n).field_70761_aq + 90.0F, 0.0F, 0.0F);
            } else {
               if (type.limitHeadTurn) {
                  jetPack = this.legAxes.getYaw();
                  axesBody = this.axes.getYaw();
                  dYaw = (double)(axesBody - jetPack);
                  if (dYaw > 180.0D) {
                     axesBody -= 360.0F;
                  }

                  if (dYaw < -180.0D) {
                     axesBody += 360.0F;
                  }

                  if (jetPack + type.limitHeadTurnValue < axesBody) {
                     this.axes.setAngles(jetPack + type.limitHeadTurnValue, 0.0F, 0.0F);
                  }

                  if (jetPack - type.limitHeadTurnValue > axesBody) {
                     this.axes.setAngles(jetPack - type.limitHeadTurnValue, 0.0F, 0.0F);
                  }
               }

               jetPack = this.seats[0].looking.getYaw() - this.seats[0].prevLooking.getYaw();
               this.axes.rotateGlobalYaw(jetPack);
               this.seats[0].looking.rotateGlobalYaw(-jetPack);
               this.seats[0].playerLooking.rotateGlobalYaw(-jetPack);
            }
         }

         this.moveX = 0.0F;
         this.moveZ = 0.0F;
         jetPack = this.jetPackPower();
         if (!this.field_70122_E && thePlayerIsDrivingThis && Minecraft.func_71410_x().field_71462_r instanceof GuiDriveableController && FlansMod.proxy.isKeyDown(4) && this.shouldFly() && (((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d || data.fuelInTank >= 10.0F * jetPack)) {
            this.field_70181_x *= 0.95D;
            this.field_70181_x += 0.07D * (double)jetPack;
            this.field_70143_R = 0.0F;
            if (!((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d) {
               data.fuelInTank -= 10.0F * jetPack;
            }

            if (this.rocketTimer <= 0.0F && this.rocketPack().soundEffect != null) {
               PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, this.rocketPack().soundEffect, false);
               this.rocketTimer = this.rocketPack().soundTime;
            }
         } else if (this.func_70090_H() && this.shouldFloat()) {
            this.field_70181_x *= 0.89D;
            this.field_70181_x += 0.1D;
         }

         if (this.rocketTimer != 0.0F) {
            --this.rocketTimer;
         }

         Vector3f actualMotion = new Vector3f(0.0D, this.field_70181_x - 0.03999999910593033D, 0.0D);
         if (driverIsLiving) {
            EntityLivingBase entity = (EntityLivingBase)this.seats[0].field_70153_n;
            driverIsCreative = entity instanceof EntityPlayer && ((EntityPlayer)entity).field_71075_bZ.field_75098_d;
            if (thePlayerIsDrivingThis && Minecraft.func_71410_x().field_71462_r instanceof GuiDriveableController) {
               if (FlansMod.proxy.isKeyDown(0)) {
                  this.moveX = 1.0F;
               }

               if (FlansMod.proxy.isKeyDown(1)) {
                  this.moveX = -1.0F;
               }

               if (FlansMod.proxy.isKeyDown(2)) {
                  this.moveZ = -1.0F;
               }

               if (FlansMod.proxy.isKeyDown(3)) {
                  this.moveZ = 1.0F;
               }
            } else if (this.seats[0].field_70153_n instanceof EntityLiving && !(this.seats[0].field_70153_n instanceof EntityPlayer)) {
               this.moveZ = 1.0F;
            }

            Vector3f intent = new Vector3f(this.moveX, 0.0F, this.moveZ);
            if (!((double)Math.abs(intent.lengthSquared()) > 0.1D)) {
               this.legPosition = 0.0F;
            } else {
               intent.normalise();
               ++this.legSwing;
               this.legPosition += this.getMechaType().legAnimSpeed;
               if (this.stompDelay == 0 && this.legPosition >= this.getMechaType().stompRangeLower && this.legPosition <= this.getMechaType().stompRangeUpper) {
                  PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, this.getMechaType().stompSound, false);
                  this.stompDelay = this.getMechaType().stompSoundLength;
               }

               intent = this.axes.findLocalVectorGlobally(intent);
               this.legAxes.findGlobalVectorLocally(intent);
               float intentAngle = (float)Math.atan2((double)intent.z, (double)intent.x) * 180.0F / 3.1415927F;
               float angleBetween = intentAngle - this.legAxes.getYaw();
               if (angleBetween > 180.0F) {
                  angleBetween -= 360.0F;
               }

               if (angleBetween < -180.0F) {
                  angleBetween += 360.0F;
               }

               float signBetween = Math.signum(angleBetween);
               angleBetween = Math.abs(angleBetween);
               if ((double)angleBetween > 0.1D) {
                  this.legAxes.rotateGlobalYaw(Math.min(angleBetween, type.rotateSpeed) * signBetween);
               }

               intent.scale(type.moveSpeed * data.engine.engineSpeed * this.speedMultiplier() * 0.215F);
               boolean canThrustCreatively = this.seats != null && this.seats[0] != null && this.seats[0].field_70153_n instanceof EntityPlayer && ((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d;
               if ((canThrustCreatively || data.fuelInTank > data.engine.fuelConsumption) && this.isPartIntact(EnumDriveablePart.hips)) {
                  if (!this.field_70122_E && this.shouldFly() && (canThrustCreatively || data.fuelInTank > 10.0F * jetPack + data.engine.fuelConsumption)) {
                     intent.scale(jetPack);
                     if (!canThrustCreatively) {
                        data.fuelInTank -= 10.0F * jetPack;
                     }
                  }

                  Vector3f.add(actualMotion, intent, actualMotion);
                  if (!canThrustCreatively) {
                     data.fuelInTank -= data.engine.fuelConsumption;
                  }
               }
            }

            if (!this.field_70170_p.field_72995_K) {
               if (this.leftMouseHeld) {
                  this.useItem(true);
               }

               if (this.rightMouseHeld) {
                  this.useItem(false);
               }

               if (this.breakingBlock != null) {
                  Block blockHit = this.field_70170_p.func_147439_a(this.breakingBlock.x, this.breakingBlock.y, this.breakingBlock.z);
                  int metadata = this.field_70170_p.func_72805_g(this.breakingBlock.x, this.breakingBlock.y, this.breakingBlock.z);
                  Material material = blockHit.func_149688_o();
                  ItemStack leftStack = this.inventory.getStackInSlot(EnumMechaSlotType.leftTool);
                  ItemStack rightStack = this.inventory.getStackInSlot(EnumMechaSlotType.rightTool);
                  boolean leftStackIsTool = leftStack != null && leftStack.func_77973_b() instanceof ItemMechaAddon;
                  boolean rightStackIsTool = rightStack != null && rightStack.func_77973_b() instanceof ItemMechaAddon;
                  boolean breakingBlocks = this.leftMouseHeld && leftStackIsTool || this.rightMouseHeld && rightStackIsTool;
                  if (blockHit != null && breakingBlocks) {
                     float blockHardness = blockHit.func_149712_f(this.field_70170_p, this.breakingBlock.x, this.breakingBlock.y, this.breakingBlock.z);
                     float mineSpeed = 1.0F;
                     boolean atLeastOneEffectiveTool = false;
                     MechaItemType rightType;
                     if (leftStackIsTool) {
                        rightType = ((ItemMechaAddon)leftStack.func_77973_b()).type;
                        if (rightType.function.effectiveAgainst(material) && rightType.toolHardness > blockHardness) {
                           mineSpeed *= rightType.speed;
                           atLeastOneEffectiveTool = true;
                        }
                     }

                     if (rightStackIsTool) {
                        rightType = ((ItemMechaAddon)rightStack.func_77973_b()).type;
                        if (rightType.function.effectiveAgainst(material) && rightType.toolHardness > blockHardness) {
                           mineSpeed *= rightType.speed;
                           atLeastOneEffectiveTool = true;
                        }
                     }

                     if (blockHardness < -0.01F) {
                        mineSpeed = 0.0F;
                     } else if (Math.abs(blockHardness) < 0.01F) {
                        mineSpeed = 9001.0F;
                     } else {
                        mineSpeed /= blockHit.func_149712_f(this.field_70170_p, this.breakingBlock.x, this.breakingBlock.y, this.breakingBlock.z);
                     }

                     this.breakingProgress += 0.1F * mineSpeed;
                     if (this.breakingProgress >= 1.0F) {
                        boolean cancelled = false;
                        if (entity instanceof EntityPlayerMP) {
                           BreakEvent event = ForgeHooks.onBlockBreakEvent(this.field_70170_p, ((EntityPlayerMP)entity).field_71075_bZ.field_75098_d ? GameType.CREATIVE : (((EntityPlayerMP)entity).field_71075_bZ.field_75099_e ? GameType.SURVIVAL : GameType.ADVENTURE), (EntityPlayerMP)this.seats[0].field_70153_n, this.breakingBlock.x, this.breakingBlock.y, this.breakingBlock.z);
                           cancelled = event.isCanceled();
                        }

                        if (!cancelled) {
                           boolean vacuumItems = this.vacuumItems();
                           if (vacuumItems) {
                              Iterator var24 = blockHit.getDrops(this.field_70170_p, this.breakingBlock.x, this.breakingBlock.y, this.breakingBlock.z, metadata, 0).iterator();

                              while(var24.hasNext()) {
                                 ItemStack stack = (ItemStack)var24.next();
                                 boolean fuelCheck = data.fuelInTank >= 5.0F || ((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d;
                                 if (fuelCheck && this.refineIron() && stack.func_77973_b() instanceof ItemBlock && ((ItemBlock)stack.func_77973_b()).field_150939_a == Blocks.field_150366_p) {
                                    stack = new ItemStack(Items.field_151042_j, 1, 0);
                                    if (!((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d) {
                                       data.fuelInTank -= 5.0F;
                                    }
                                 }

                                 fuelCheck = data.fuelInTank >= 0.1F || ((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d;
                                 if (fuelCheck && this.wasteCompact() && stack.func_77973_b() instanceof ItemBlock && (((ItemBlock)stack.func_77973_b()).field_150939_a == Blocks.field_150347_e || ((ItemBlock)stack.func_77973_b()).field_150939_a == Blocks.field_150346_d || ((ItemBlock)stack.func_77973_b()).field_150939_a == Blocks.field_150354_m)) {
                                    stack.field_77994_a = 0;
                                    if (!((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d) {
                                       data.fuelInTank -= 0.1F;
                                    }
                                 }

                                 fuelCheck = data.fuelInTank >= 3.0F * this.diamondMultiplier() || ((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d;
                                 float multiplier;
                                 if (fuelCheck && stack.func_77973_b() == Items.field_151045_i) {
                                    multiplier = this.diamondMultiplier();
                                    stack.field_77994_a *= MathHelper.func_76141_d(multiplier) + (this.field_70146_Z.nextFloat() < this.tailFloat(multiplier) ? 1 : 0);
                                    if (!((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d) {
                                       data.fuelInTank -= 3.0F * this.diamondMultiplier();
                                    }
                                 }

                                 fuelCheck = data.fuelInTank >= 2.0F * this.redstoneMultiplier() || ((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d;
                                 if (fuelCheck && stack.func_77973_b() == Items.field_151137_ax) {
                                    multiplier = this.redstoneMultiplier();
                                    stack.field_77994_a *= MathHelper.func_76141_d(multiplier) + (this.field_70146_Z.nextFloat() < this.tailFloat(multiplier) ? 1 : 0);
                                    if (!((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d) {
                                       data.fuelInTank -= 2.0F * this.redstoneMultiplier();
                                    }
                                 }

                                 fuelCheck = data.fuelInTank >= 2.0F * this.coalMultiplier() || ((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d;
                                 if (fuelCheck && stack.func_77973_b() == Items.field_151044_h) {
                                    multiplier = this.coalMultiplier();
                                    stack.field_77994_a *= MathHelper.func_76141_d(multiplier) + (this.field_70146_Z.nextFloat() < this.tailFloat(multiplier) ? 1 : 0);
                                    if (!((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d) {
                                       data.fuelInTank -= 2.0F * this.coalMultiplier();
                                    }
                                 }

                                 fuelCheck = data.fuelInTank >= 2.0F * this.emeraldMultiplier() || ((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d;
                                 if (fuelCheck && stack.func_77973_b() == Items.field_151166_bC) {
                                    multiplier = this.emeraldMultiplier();
                                    stack.field_77994_a *= MathHelper.func_76141_d(multiplier) + (this.field_70146_Z.nextFloat() < this.tailFloat(multiplier) ? 1 : 0);
                                    if (!((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d) {
                                       data.fuelInTank -= 2.0F * this.emeraldMultiplier();
                                    }
                                 }

                                 fuelCheck = data.fuelInTank >= 2.0F * this.ironMultiplier() || ((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d;
                                 if (fuelCheck && stack.func_77973_b() == Items.field_151042_j && this.refineIron()) {
                                    multiplier = this.ironMultiplier();
                                    stack.field_77994_a *= MathHelper.func_76141_d(multiplier) + (this.field_70146_Z.nextFloat() < this.tailFloat(multiplier) ? 1 : 0);
                                    if (!((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d) {
                                       data.fuelInTank -= 2.0F * this.ironMultiplier();
                                    }
                                 }

                                 if (this.autoCoal() && stack.func_77973_b() == Items.field_151044_h && data.fuelInTank + 250.0F < (float)type.fuelTankSize) {
                                    data.fuelInTank = Math.min(data.fuelInTank + 1000.0F, (float)type.fuelTankSize);
                                    this.couldNotFindFuel = false;
                                    stack.field_77994_a = 0;
                                 }

                                 if (!InventoryHelper.addItemStackToInventory(this.driveableData, stack, driverIsCreative) && !this.field_70170_p.field_72995_K && this.field_70170_p.func_82736_K().func_82766_b("doTileDrops")) {
                                    this.field_70170_p.func_72838_d(new EntityItem(this.field_70170_p, (double)((float)this.breakingBlock.x + 0.5F), (double)((float)this.breakingBlock.y + 0.5F), (double)((float)this.breakingBlock.z + 0.5F), stack));
                                 }
                              }
                           }

                           this.field_70170_p.func_147480_a(this.breakingBlock.x, this.breakingBlock.y, this.breakingBlock.z, atLeastOneEffectiveTool && !vacuumItems);
                        }
                     }
                  } else {
                     this.breakingBlock = null;
                  }
               }
            }
         }

         this.field_70181_x = (double)actualMotion.y;
         this.func_70091_d((double)actualMotion.x, (double)actualMotion.y, (double)actualMotion.z);
         this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         if (thePlayerIsDrivingThis) {
            FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketMechaControl(this)));
            this.field_70118_ct = this.field_70165_t;
            this.field_70117_cu = this.field_70163_u;
            this.field_70116_cv = this.field_70161_v;
            this.serverYaw = (double)this.axes.getYaw();
         }

         if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 5 == 0) {
            FlansMod.getPacketHandler().sendToAllAround(new PacketMechaControl(this), this.field_70165_t, this.field_70163_u, this.field_70161_v, 400.0F, this.field_71093_bK);
         }

         EntitySeat[] var42 = this.seats;
         y = var42.length;

         for(z = 0; z < y; ++z) {
            EntitySeat seat = var42[z];
            if (seat != null) {
               seat.updatePosition();
            }
         }

         if (!driverIsLiving || thePlayerIsDrivingThis) {
            this.legSwing /= type.legSwingLimit;
         }

      }
   }

   private float tailFloat(float f) {
      return f - (float)MathHelper.func_76141_d(f);
   }

   public boolean stopFallDamage() {
      Iterator var1 = this.getUpgradeTypes().iterator();

      MechaItemType type;
      do {
         if (!var1.hasNext()) {
            return false;
         }

         type = (MechaItemType)var1.next();
      } while(!type.stopMechaFallDamage);

      return true;
   }

   public boolean breakBlocksUponFalling() {
      Iterator var1 = this.getUpgradeTypes().iterator();

      MechaItemType type;
      do {
         if (!var1.hasNext()) {
            return false;
         }

         type = (MechaItemType)var1.next();
      } while(!type.forceBlockFallDamage);

      return true;
   }

   public boolean vacuumItems() {
      Iterator var1 = this.getUpgradeTypes().iterator();

      MechaItemType type;
      do {
         if (!var1.hasNext()) {
            return false;
         }

         type = (MechaItemType)var1.next();
      } while(!type.vacuumItems);

      return true;
   }

   public boolean refineIron() {
      Iterator var1 = this.getUpgradeTypes().iterator();

      MechaItemType type;
      do {
         if (!var1.hasNext()) {
            return false;
         }

         type = (MechaItemType)var1.next();
      } while(!type.refineIron);

      return true;
   }

   public MechaItemType diamondDetect() {
      Iterator var1 = this.getUpgradeTypes().iterator();

      MechaItemType type;
      do {
         if (!var1.hasNext()) {
            return null;
         }

         type = (MechaItemType)var1.next();
      } while(!type.diamondDetect);

      return type;
   }

   public Boolean wasteCompact() {
      Iterator var1 = this.getUpgradeTypes().iterator();

      MechaItemType type;
      do {
         if (!var1.hasNext()) {
            return false;
         }

         type = (MechaItemType)var1.next();
      } while(!type.wasteCompact);

      return true;
   }

   public float diamondMultiplier() {
      float multiplier = 1.0F;

      MechaItemType type;
      for(Iterator var2 = this.getUpgradeTypes().iterator(); var2.hasNext(); multiplier *= type.fortuneDiamond) {
         type = (MechaItemType)var2.next();
      }

      return multiplier;
   }

   public float speedMultiplier() {
      float multiplier = 1.0F;

      MechaItemType type;
      for(Iterator var2 = this.getUpgradeTypes().iterator(); var2.hasNext(); multiplier *= type.speedMultiplier) {
         type = (MechaItemType)var2.next();
      }

      return multiplier;
   }

   public float coalMultiplier() {
      float multiplier = 1.0F;

      MechaItemType type;
      for(Iterator var2 = this.getUpgradeTypes().iterator(); var2.hasNext(); multiplier *= type.fortuneCoal) {
         type = (MechaItemType)var2.next();
      }

      return multiplier;
   }

   public float redstoneMultiplier() {
      float multiplier = 1.0F;

      MechaItemType type;
      for(Iterator var2 = this.getUpgradeTypes().iterator(); var2.hasNext(); multiplier *= type.fortuneRedstone) {
         type = (MechaItemType)var2.next();
      }

      return multiplier;
   }

   public float vulnerability() {
      float multiplier = 1.0F;

      MechaItemType type;
      for(Iterator var2 = this.getUpgradeTypes().iterator(); var2.hasNext(); multiplier *= 1.0F - type.damageResistance) {
         type = (MechaItemType)var2.next();
      }

      return multiplier;
   }

   public float emeraldMultiplier() {
      float multiplier = 1.0F;

      MechaItemType type;
      for(Iterator var2 = this.getUpgradeTypes().iterator(); var2.hasNext(); multiplier *= type.fortuneEmerald) {
         type = (MechaItemType)var2.next();
      }

      return multiplier;
   }

   public float ironMultiplier() {
      float multiplier = 1.0F;

      MechaItemType type;
      for(Iterator var2 = this.getUpgradeTypes().iterator(); var2.hasNext(); multiplier *= type.fortuneIron) {
         type = (MechaItemType)var2.next();
      }

      return multiplier;
   }

   public int lightLevel() {
      int level = 0;

      MechaItemType type;
      for(Iterator var2 = this.getUpgradeTypes().iterator(); var2.hasNext(); level = Math.max(level, type.lightLevel)) {
         type = (MechaItemType)var2.next();
      }

      return level;
   }

   public boolean forceDark() {
      Iterator var1 = this.getUpgradeTypes().iterator();

      MechaItemType type;
      do {
         if (!var1.hasNext()) {
            return false;
         }

         type = (MechaItemType)var1.next();
      } while(!type.forceDark);

      return true;
   }

   public boolean autoCoal() {
      Iterator var1 = this.getUpgradeTypes().iterator();

      MechaItemType type;
      do {
         if (!var1.hasNext()) {
            return false;
         }

         type = (MechaItemType)var1.next();
      } while(!type.autoCoal);

      return true;
   }

   public boolean autoRepair() {
      Iterator var1 = this.getUpgradeTypes().iterator();

      MechaItemType type;
      do {
         if (!var1.hasNext()) {
            return false;
         }

         type = (MechaItemType)var1.next();
      } while(!type.autoRepair);

      return true;
   }

   public boolean shouldFloat() {
      Iterator var1 = this.getUpgradeTypes().iterator();

      MechaItemType type;
      do {
         if (!var1.hasNext()) {
            return false;
         }

         type = (MechaItemType)var1.next();
      } while(!type.floater);

      return true;
   }

   public boolean infiniteAmmo() {
      Iterator var1 = this.getUpgradeTypes().iterator();

      MechaItemType type;
      do {
         if (!var1.hasNext()) {
            return false;
         }

         type = (MechaItemType)var1.next();
      } while(!type.infiniteAmmo);

      return true;
   }

   public MechaItemType rocketPack() {
      Iterator var1 = this.getUpgradeTypes().iterator();

      MechaItemType type;
      do {
         if (!var1.hasNext()) {
            return null;
         }

         type = (MechaItemType)var1.next();
      } while(!type.rocketPack);

      return type;
   }

   public boolean shouldFly() {
      return this.rocketPack() != null;
   }

   public float jetPackPower() {
      float multiplier = 1.0F;

      MechaItemType type;
      for(Iterator var2 = this.getUpgradeTypes().iterator(); var2.hasNext(); multiplier *= type.rocketPower) {
         type = (MechaItemType)var2.next();
      }

      return multiplier;
   }

   public ArrayList<MechaItemType> getUpgradeTypes() {
      ArrayList<MechaItemType> types = new ArrayList();
      Iterator var2 = this.inventory.stacks.values().iterator();

      while(var2.hasNext()) {
         ItemStack stack = (ItemStack)var2.next();
         if (stack != null && stack.func_77973_b() instanceof ItemMechaAddon) {
            types.add(((ItemMechaAddon)stack.func_77973_b()).type);
         }
      }

      return types;
   }

   @SideOnly(Side.CLIENT)
   public boolean showInventory(int seat) {
      return seat != 0;
   }

   protected void dropItemsOnPartDeath(Vector3f midpoint, DriveablePart part) {
   }

   public boolean hasMouseControlMode() {
      return false;
   }

   public String getBombInventoryName() {
      return "";
   }

   public String getMissileInventoryName() {
      return "";
   }

   @SideOnly(Side.CLIENT)
   public EntityLivingBase getCamera() {
      return null;
   }
}
