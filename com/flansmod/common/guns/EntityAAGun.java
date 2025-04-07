package com.flansmod.common.guns;

import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.driveables.EntityPlane;
import com.flansmod.common.driveables.EntityVehicle;
import com.flansmod.common.network.PacketAAGunAngles;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketMGFire;
import com.flansmod.common.network.PacketPlaySound;
import com.flansmod.common.teams.Team;
import com.flansmod.common.teams.TeamsManager;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import java.util.Iterator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import org.lwjgl.input.Mouse;

public class EntityAAGun extends Entity implements IEntityAdditionalSpawnData {
   private int sUpdateTime;
   private double sPosX;
   private double sPosY;
   private double sPosZ;
   private double sYaw;
   private double sPitch;
   private double field_9388_j;
   private double field_9387_k;
   private double field_9386_l;
   private int health;
   private int shootDelay;
   public float gunYaw;
   public float gunPitch;
   public float prevGunYaw;
   public float prevGunPitch;
   public float[] barrelRecoil;
   public AAGunType type;
   public Entity towedByEntity;
   public ItemStack[] ammo;
   public int reloadTimer;
   public int currentBarrel;
   public boolean mouseHeld;
   public boolean wasShooting;
   public int shootcnt;
   public int shootTimeCount;
   public EntityPlayer placer;
   public String placerName;
   public Entity target;
   public static final float targetAcquireInterval = 10.0F;
   public int ticksSinceUsed;

   public EntityAAGun(World world) {
      super(world);
      this.shootcnt = 1;
      this.shootTimeCount = 0;
      this.placer = null;
      this.placerName = null;
      this.target = null;
      this.ticksSinceUsed = 0;
      this.field_70156_m = true;
      this.func_70105_a(2.0F, 2.0F);
      this.field_70129_M = 0.0F;
      this.gunYaw = 0.0F;
      this.gunPitch = 0.0F;
      this.shootDelay = 0;
   }

   public EntityAAGun(World world, AAGunType type1, double d, double d1, double d2, EntityPlayer p) {
      this(world);
      this.placer = p;
      this.placerName = p.func_70005_c_();
      this.type = type1;
      this.initType();
      this.func_70107_b(d, d1, d2);
   }

   public void func_70107_b(double d, double d1, double d2) {
      this.field_70165_t = d;
      this.field_70163_u = d1;
      this.field_70161_v = d2;
      float f = this.field_70130_N / 2.0F;
      float f1 = this.field_70131_O;
      this.field_70121_D.func_72324_b(d - (double)f, d1 - (double)this.field_70129_M + (double)this.field_70139_V, d2 - (double)f, d + (double)f, d1 - (double)this.field_70129_M + (double)this.field_70139_V + (double)f1, d2 + (double)f);
   }

   public void func_70056_a(double d, double d1, double d2, float f, float f1, int i) {
      this.sPosX = d;
      this.sPosY = d1;
      this.sPosZ = d2;
      this.sYaw = (double)f;
      this.sPitch = (double)f1;
      this.sUpdateTime = i;
   }

   public void initType() {
      this.health = this.type.health;
      this.barrelRecoil = new float[this.type.numBarrels];
      this.ammo = new ItemStack[this.type.numBarrels];
   }

   protected void func_70088_a() {
   }

   public void func_70100_b_(EntityPlayer par1EntityPlayer) {
   }

   public void func_70108_f(Entity entity) {
   }

   public AxisAlignedBB func_70114_g(Entity entity) {
      return entity.field_70121_D;
   }

   public AxisAlignedBB func_70046_E() {
      return this.field_70121_D;
   }

   public boolean func_70104_M() {
      return false;
   }

   public double func_70042_X() {
      return 0.0D;
   }

   public void setMouseHeld(boolean held) {
      this.mouseHeld = held;
   }

   public boolean func_70097_a(DamageSource damagesource, float i) {
      if (damagesource.field_76373_n.equals("player")) {
         Entity player = damagesource.func_76346_g();
         if (player != this.field_70153_n) {
            if (this.field_70153_n != null) {
               return this.field_70153_n.func_70097_a(damagesource, i);
            }

            if (TeamsManager.canBreakGuns) {
               this.func_70106_y();
            }
         }
      } else {
         this.func_70018_K();
         this.health = (int)((float)this.health - i);
         if (!this.field_70170_p.field_72995_K && this.health <= 0) {
            this.func_70106_y();
         }
      }

      return true;
   }

   public Vec3 rotate(double x, double y, double z) {
      double cosYaw = Math.cos((double)(180.0F - this.gunYaw * 3.1415927F / 180.0F));
      double sinYaw = Math.sin((double)(180.0F - this.gunYaw * 3.1415927F / 180.0F));
      double cosPitch = Math.cos((double)(this.gunPitch * 3.1415927F / 180.0F));
      double sinPitch = Math.sin((double)(this.gunPitch * 3.1415927F / 180.0F));
      double newX = x * cosYaw + (y * sinPitch + z * cosPitch) * sinYaw;
      double newY = y * cosPitch - z * sinPitch;
      double newZ = -x * sinYaw + (y * sinPitch + z * cosPitch) * cosYaw;
      return Vec3.func_72443_a(newX, newY, newZ);
   }

   public boolean func_70067_L() {
      return !this.field_70128_L;
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if (this.type == null) {
         FlansMod.log("EntityAAGun.onUpdate() Error: AAGunType is null (" + this + ")");
         this.func_70106_y();
      } else {
         this.prevGunYaw = this.gunYaw;
         this.prevGunPitch = this.gunPitch;
         ++this.ticksSinceUsed;
         if (TeamsManager.aaLife > 0 && this.ticksSinceUsed > TeamsManager.aaLife * 20) {
            this.func_70106_y();
         }

         if (this.field_70153_n != null) {
            this.ticksSinceUsed = 0;
            this.gunYaw = this.field_70153_n.field_70177_z - 90.0F;
            this.gunPitch = this.field_70153_n.field_70125_A;
         }

         if (this.gunPitch > this.type.bottomViewLimit) {
            this.gunPitch = this.type.bottomViewLimit;
         }

         if (this.gunPitch < -this.type.topViewLimit) {
            this.gunPitch = -this.type.topViewLimit;
         }

         int j;
         for(j = 0; j < this.type.numBarrels; ++j) {
            float[] var10000 = this.barrelRecoil;
            var10000[j] *= 0.9F;
         }

         if (this.shootDelay > 0) {
            --this.shootDelay;
         }

         double d5;
         double d9;
         double d12;
         double d1;
         if (this.isSentry()) {
            if (this.target != null && this.target.field_70128_L) {
               this.target = null;
            }

            if (this.target == null && (float)this.field_70173_aa % 10.0F == 0.0F) {
               this.target = this.getValidTarget();
            }

            if (this.target != null) {
               d1 = this.target.field_70165_t - this.field_70165_t;
               d5 = this.target.field_70163_u - (this.field_70163_u + 1.5D);
               d9 = this.target.field_70161_v - this.field_70161_v;
               d12 = Math.sqrt(d1 * d1 + d5 * d5 + d9 * d9);
               if (d12 > (double)this.type.targetRange) {
                  this.target = null;
               } else {
                  float newYaw;
                  float newPitch;
                  if (!this.type.canShootHomingMissile) {
                     newYaw = 180.0F + (float)Math.atan2(d9, d1) * 180.0F / 3.14159F;
                     newPitch = -((float)Math.atan2(d5, Math.sqrt(d1 * d1 + d9 * d9))) * 180.0F / 3.14159F;
                     float turnSpeed = 0.25F;
                     this.gunYaw += (newYaw - this.gunYaw) * turnSpeed;
                     this.gunPitch += (newPitch - this.gunPitch) * turnSpeed;
                  } else {
                     newYaw = 180.0F + (float)Math.atan2(d9, d1) * 180.0F / 3.14159F;
                     newPitch = -((float)Math.atan2(d5, Math.sqrt(d1 * d1 + d9 * d9))) * 180.0F / 3.14159F;
                     this.gunYaw = newYaw;
                     this.gunPitch = newPitch;
                  }
               }
            }
         }

         if (!this.field_70122_E && !this.field_70170_p.field_72995_K) {
            this.field_70181_x -= 0.0245D;
         }

         this.field_70159_w *= 0.5D;
         this.field_70179_y *= 0.5D;
         this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
         if (this.field_70170_p.field_72995_K && this.field_70153_n != null && this.field_70153_n == FMLClientHandler.instance().getClient().field_71439_g) {
            this.checkForShooting();
         }

         if (this.field_70170_p.field_72995_K) {
            if (this.sUpdateTime > 0) {
               d1 = this.field_70165_t + (this.sPosX - this.field_70165_t) / (double)this.sUpdateTime;
               d5 = this.field_70163_u + (this.sPosY - this.field_70163_u) / (double)this.sUpdateTime;
               d9 = this.field_70161_v + (this.sPosZ - this.field_70161_v) / (double)this.sUpdateTime;

               for(d12 = this.sYaw - (double)this.field_70177_z; d12 < -180.0D; d12 += 360.0D) {
               }

               while(d12 >= 180.0D) {
                  d12 -= 360.0D;
               }

               this.field_70177_z = (float)((double)this.field_70177_z + d12 / (double)this.sUpdateTime);
               this.field_70125_A = (float)((double)this.field_70125_A + (this.sPitch - (double)this.field_70125_A) / (double)this.sUpdateTime);
               --this.sUpdateTime;
               this.func_70107_b(d1, d5, d9);
               this.func_70101_b(this.field_70177_z, this.field_70125_A);
            }

         } else {
            if (this.field_70153_n != null && this.field_70153_n.field_70128_L) {
               this.field_70153_n = null;
            }

            int ammoSlot;
            if (this.reloadTimer > 0) {
               --this.reloadTimer;
            } else {
               for(j = 0; j < this.type.numBarrels; ++j) {
                  if (this.ammo[j] != null && this.ammo[j].func_77960_j() == this.ammo[j].func_77958_k()) {
                     this.ammo[j] = null;
                  }

                  if (this.ammo[j] == null && this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer) {
                     ammoSlot = this.findAmmo((EntityPlayer)this.field_70153_n);
                     if (ammoSlot >= 0) {
                        this.ammo[j] = ((EntityPlayer)this.field_70153_n).field_71071_by.func_70301_a(ammoSlot);
                        if (!((EntityPlayer)this.field_70153_n).field_71075_bZ.field_75098_d) {
                           ((EntityPlayer)this.field_70153_n).field_71071_by.func_70298_a(ammoSlot, 1);
                        }

                        this.reloadTimer = this.type.reloadTime;
                        PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, this.type.reloadSound, true);
                     }
                  }
               }
            }

            if (this.shootcnt > 0 && this.shootcnt < 10) {
               ++this.shootcnt;
            }

            if (!this.field_70170_p.field_72995_K && this.reloadTimer <= 0 && this.shootDelay <= 0) {
               BulletType bullet;
               if (this.mouseHeld && this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer) {
                  EntityPlayer player = (EntityPlayer)this.field_70153_n;

                  for(ammoSlot = 0; ammoSlot < this.type.numBarrels; ++ammoSlot) {
                     if (this.shootDelay <= 0 && this.ammo[ammoSlot] != null && (!this.type.fireAlternately || this.type.fireAlternately && this.currentBarrel == ammoSlot)) {
                        bullet = BulletType.getBullet(this.ammo[ammoSlot].func_77973_b());
                        if (!((EntityPlayer)this.field_70153_n).field_71075_bZ.field_75098_d) {
                           this.ammo[ammoSlot].func_77972_a(1, player);
                        }

                        this.shootDelay = this.type.shootDelay;
                        this.barrelRecoil[ammoSlot] = (float)this.type.recoil;
                        this.field_70170_p.func_72838_d(((ItemBullet)this.ammo[ammoSlot].func_77973_b()).getEntity(this.field_70170_p, this.rotate((double)this.type.barrelX[this.currentBarrel] / 16.0D - (double)this.type.barrelZ[this.currentBarrel] / 16.0D, (double)this.type.barrelY[this.currentBarrel] / 16.0D, (double)this.type.barrelX[this.currentBarrel] / 16.0D + (double)this.type.barrelZ[this.currentBarrel] / 16.0D).func_72441_c(this.field_70165_t, this.field_70163_u, this.field_70161_v), this.gunYaw + 90.0F, this.gunPitch, player, (float)this.type.accuracy, (float)this.type.damage, this.ammo[ammoSlot].func_77960_j(), this.type));
                        PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, this.type.shootSound, true);
                     }
                  }

                  this.currentBarrel = (this.currentBarrel + 1) % this.type.numBarrels;
               } else if (this.target != null && this.shootcnt > 5) {
                  for(j = 0; j < this.type.numBarrels; ++j) {
                     ammoSlot = j;
                     if (this.type.shareAmmo) {
                        ammoSlot = 0;
                     }

                     if (this.shootDelay <= 0 && this.ammo[ammoSlot] != null && (!this.type.fireAlternately || this.type.fireAlternately && this.currentBarrel == ammoSlot)) {
                        bullet = BulletType.getBullet(this.ammo[ammoSlot].func_77973_b());
                        this.ammo[ammoSlot].func_77964_b(this.ammo[ammoSlot].func_77960_j() + 1);
                        this.shootDelay = this.type.shootDelay;
                        this.barrelRecoil[ammoSlot] = (float)this.type.recoil;
                        this.field_70170_p.func_72838_d(((ItemBullet)this.ammo[ammoSlot].func_77973_b()).getEntity(this.field_70170_p, this.rotate((double)this.type.barrelX[this.currentBarrel] / 16.0D - (double)this.type.barrelZ[this.currentBarrel] / 16.0D, (double)this.type.barrelY[this.currentBarrel] / 16.0D, (double)this.type.barrelX[this.currentBarrel] / 16.0D + (double)this.type.barrelZ[this.currentBarrel] / 16.0D).func_72441_c(this.field_70165_t, this.field_70163_u + 1.5D, this.field_70161_v), this.gunYaw + 90.0F, this.gunPitch, this.placer, (float)this.type.accuracy, (float)this.type.damage, this.ammo[ammoSlot].func_77960_j(), this.type));
                        PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, this.type.shootSound, true);
                        if (this.shootTimeCount >= this.type.countExplodeAfterShoot - 1 && this.type.countExplodeAfterShoot != -1 && !this.field_70170_p.field_72995_K) {
                           this.func_70106_y();
                        }

                        ++this.shootTimeCount;
                     }
                  }

                  this.currentBarrel = (this.currentBarrel + 1) % this.type.numBarrels;
               }
            }

            if (!this.field_70170_p.field_72995_K) {
               FlansMod.getPacketHandler().sendToAllAround(new PacketAAGunAngles(this), this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0F, this.field_71093_bK);
            }

         }
      }
   }

   public boolean isSentry() {
      return this.type.targetMobs || this.type.targetPlayers || this.type.targetPlanes || this.type.targetVehicles || this.type.targetMechas;
   }

   public Entity getValidTarget() {
      if (this.field_70170_p.field_72995_K) {
         return null;
      } else {
         if (this.placer == null && this.placerName != null) {
            this.placer = this.field_70170_p.func_72924_a(this.placerName);
         }

         Iterator var1 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)this.type.targetRange, (double)this.type.targetRange, (double)this.type.targetRange)).iterator();

         Entity candidateEntity;
         while(true) {
            do {
               do {
                  if (!var1.hasNext()) {
                     return null;
                  }

                  Object obj = var1.next();
                  candidateEntity = (Entity)obj;
               } while((!this.type.targetMobs || !(candidateEntity instanceof EntityMob)) && (!this.type.targetPlayers || !(candidateEntity instanceof EntityPlayer)) && (!this.type.targetPlanes || !(candidateEntity instanceof EntityPlane)) && (!this.type.targetVehicles || !(candidateEntity instanceof EntityVehicle)));
            } while(!(candidateEntity.func_70032_d(this) < this.type.targetRange));

            if (!(candidateEntity instanceof EntityPlayer)) {
               break;
            }

            if (candidateEntity != this.placer && !candidateEntity.func_70005_c_().equals(this.placerName)) {
               if (!TeamsManager.enabled || TeamsManager.getInstance().currentRound == null || this.placer == null) {
                  break;
               }

               PlayerData placerData = PlayerHandler.getPlayerData(this.placer, this.field_70170_p.field_72995_K ? Side.CLIENT : Side.SERVER);
               PlayerData candidateData = PlayerHandler.getPlayerData((EntityPlayer)candidateEntity, this.field_70170_p.field_72995_K ? Side.CLIENT : Side.SERVER);
               if (candidateData.team != Team.spectators && candidateData.team != null) {
                  EntityPlayerMP var10001 = (EntityPlayerMP)this.placer;
                  if (!TeamsManager.getInstance().currentRound.gametype.playerCanAttack(var10001, placerData.team, (EntityPlayerMP)candidateEntity, candidateData.team)) {
                     continue;
                  }
                  break;
               }
            }
         }

         return candidateEntity;
      }
   }

   @SideOnly(Side.CLIENT)
   private void checkForShooting() {
      if (Mouse.isButtonDown(0) && !this.wasShooting && !FlansMod.proxy.isScreenOpen()) {
         FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketMGFire(true)));
         this.wasShooting = true;
      } else if (!Mouse.isButtonDown(0) && this.wasShooting) {
         FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketMGFire(false)));
         this.wasShooting = false;
      }

   }

   public void func_70106_y() {
      super.func_70106_y();
      if (!this.field_70170_p.field_72995_K) {
         if (this.type.isDropThis) {
            this.func_145779_a(this.type.getItem(), 1);
         }

         ItemStack[] var1 = this.ammo;
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            ItemStack stack = var1[var3];
            if (stack != null) {
               this.func_70099_a(stack, 0.5F);
            }
         }

      }
   }

   public void func_70043_V() {
      if (this.field_70153_n != null) {
         double x = (double)this.type.gunnerX / 16.0D;
         double y = (double)this.type.gunnerY / 16.0D;
         double z = (double)this.type.gunnerZ / 16.0D;
         double cosYaw = Math.cos((double)(-this.gunYaw) / 180.0D * 3.141592653589793D);
         double sinYaw = Math.sin((double)(-this.gunYaw) / 180.0D * 3.141592653589793D);
         double cosPitch = Math.cos((double)this.gunPitch / 180.0D * 3.141592653589793D);
         double sinPitch = Math.sin((double)this.gunPitch / 180.0D * 3.141592653589793D);
         double x2 = x * cosYaw + z * sinYaw;
         double z2 = -x * sinYaw + z * cosYaw;
         this.field_70153_n.func_70107_b(this.field_70165_t + x2, this.field_70163_u + y, this.field_70161_v + z2);
      }
   }

   protected void func_70014_b(NBTTagCompound nbttagcompound) {
      if (this.type == null) {
         FlansMod.log("EntityAAGun.writeEntityToNBT() Error: AAGunType is null (" + this + ")");
         this.func_70106_y();
      } else {
         nbttagcompound.func_74778_a("Type", this.type.shortName);
         nbttagcompound.func_74768_a("Health", this.health);
         nbttagcompound.func_74776_a("RotationYaw", this.field_70177_z);
         nbttagcompound.func_74776_a("RotationPitch", this.field_70125_A);

         for(int i = 0; i < this.type.numBarrels; ++i) {
            if (this.ammo[i] != null) {
               nbttagcompound.func_74782_a("Ammo " + i, this.ammo[i].func_77955_b(new NBTTagCompound()));
            }
         }

         nbttagcompound.func_74778_a("Placer", this.placer.func_70005_c_());
      }
   }

   protected void func_70037_a(NBTTagCompound nbttagcompound) {
      this.type = AAGunType.getAAGun(nbttagcompound.func_74779_i("Type"));
      if (this.type == null) {
         FlansMod.log("EntityAAGun.readEntityFromNBT() Error: AAGunType is null (" + this + ")");
         this.func_70106_y();
      } else {
         this.initType();
         this.health = nbttagcompound.func_74762_e("Health");
         this.field_70177_z = nbttagcompound.func_74760_g("RotationYaw");
         this.field_70125_A = nbttagcompound.func_74760_g("RotationPitch");

         for(int i = 0; i < this.type.numBarrels; ++i) {
            this.ammo[i] = ItemStack.func_77949_a(nbttagcompound.func_74775_l("Ammo " + i));
         }

         this.placerName = nbttagcompound.func_74779_i("Placer");
      }
   }

   public float func_70053_R() {
      return 0.0F;
   }

   public boolean func_130002_c(EntityPlayer entityplayer) {
      if (this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer && this.field_70153_n != entityplayer) {
         return true;
      } else {
         if (!this.field_70170_p.field_72995_K) {
            if (this.field_70153_n == entityplayer) {
               entityplayer.func_70078_a((Entity)null);
               return true;
            }

            if (!this.isSentry()) {
               entityplayer.func_70078_a(this);
            }

            for(int i = 0; i < (this.type.shareAmmo ? 1 : this.type.numBarrels); ++i) {
               if (this.ammo[i] == null) {
                  int slot = this.findAmmo(entityplayer);
                  if (slot >= 0) {
                     this.ammo[i] = entityplayer.field_71071_by.func_70301_a(slot).func_77946_l();
                     this.ammo[i].field_77994_a = 1;
                     if (!entityplayer.field_71075_bZ.field_75098_d) {
                        entityplayer.field_71071_by.func_70298_a(slot, 1);
                     }

                     this.reloadTimer = this.type.reloadTime;
                     this.field_70170_p.func_72956_a(this, this.type.reloadSound, 1.0F, 1.0F / (this.field_70146_Z.nextFloat() * 0.4F + 0.8F));
                  }
               }
            }
         }

         return true;
      }
   }

   public int findAmmo(EntityPlayer player) {
      for(int i = 0; i < player.field_71071_by.func_70302_i_(); ++i) {
         ItemStack stack = player.field_71071_by.func_70301_a(i);
         if (this.type.isAmmo(stack)) {
            return i;
         }
      }

      return -1;
   }

   public void writeSpawnData(ByteBuf data) {
      ByteBufUtils.writeUTF8String(data, this.type.shortName);
   }

   public void readSpawnData(ByteBuf data) {
      try {
         this.type = AAGunType.getAAGun(ByteBufUtils.readUTF8String(data));
         this.initType();
      } catch (Exception var3) {
         FlansMod.log("Failed to retreive AA gun type from server.");
         super.func_70106_y();
         var3.printStackTrace();
      }

   }

   public boolean canRiderInteract() {
      return false;
   }

   public ItemStack getPickedResult(MovingObjectPosition target) {
      ItemStack stack = new ItemStack(this.type.item, 1, 0);
      return stack;
   }
}
