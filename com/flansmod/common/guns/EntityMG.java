package com.flansmod.common.guns;

import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketMGFire;
import com.flansmod.common.network.PacketMGMount;
import com.flansmod.common.network.PacketPlaySound;
import com.flansmod.common.teams.EntityGunItem;
import com.flansmod.common.teams.Team;
import com.flansmod.common.teams.TeamsManager;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import org.lwjgl.input.Mouse;

public class EntityMG extends Entity implements IEntityAdditionalSpawnData {
   public int blockX;
   public int blockY;
   public int blockZ;
   public int direction;
   public GunType type;
   public ItemStack ammo;
   public int reloadTimer;
   public int soundDelay;
   public int shootDelay;
   public static List<EntityMG> mgs = new ArrayList();
   public EntityPlayer gunner;
   public boolean isShooting;
   public boolean wasShooting = false;
   public int ticksSinceUsed = 0;

   public EntityMG(World world) {
      super(world);
      this.func_70105_a(1.0F, 1.0F);
      this.field_70158_ak = true;
   }

   public EntityMG(World world, int x, int y, int z, int dir, GunType gunType) {
      super(world);
      this.func_70105_a(1.0F, 1.0F);
      this.blockX = x;
      this.blockY = y;
      this.blockZ = z;
      this.field_70169_q = (double)x + 0.5D;
      this.field_70167_r = (double)y;
      this.field_70166_s = (double)z + 0.5D;
      this.func_70107_b((double)x + 0.5D, (double)y, (double)z + 0.5D);
      this.direction = dir;
      this.field_70177_z = 0.0F;
      this.field_70125_A = -60.0F;
      this.type = gunType;
      this.field_70158_ak = true;
      mgs.add(this);
   }

   public boolean func_70067_L() {
      return !this.field_70128_L;
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if (this.type == null) {
         FlansMod.log("EntityMG.onUpdate() Error: GunType is null (" + this + ")");
         this.func_70106_y();
      } else {
         ++this.ticksSinceUsed;
         if (TeamsManager.mgLife > 0 && this.ticksSinceUsed > TeamsManager.mgLife * 20) {
            this.func_70106_y();
         }

         if (this.field_70170_p.func_147439_a(this.blockX, this.blockY - 1, this.blockZ) == null && !this.field_70170_p.field_72995_K) {
            this.func_70106_y();
         }

         this.field_70126_B = this.field_70177_z;
         this.field_70127_C = this.field_70125_A;
         if (this.gunner != null) {
            this.ticksSinceUsed = 0;

            for(this.field_70177_z = this.gunner.field_70177_z - (float)(this.direction * 90); this.field_70177_z < -180.0F; this.field_70177_z += 360.0F) {
            }

            while(this.field_70177_z > 180.0F) {
               this.field_70177_z -= 360.0F;
            }

            this.field_70125_A = this.gunner.field_70125_A;
            if (this.field_70177_z > this.type.sideViewLimit) {
               this.field_70126_B = this.field_70177_z = this.type.sideViewLimit;
            }

            if (this.field_70177_z < -this.type.sideViewLimit) {
               this.field_70126_B = this.field_70177_z = -this.type.sideViewLimit;
            }

            float angle = (float)this.direction * 90.0F + this.field_70177_z;
            double dX = (double)this.type.standBackDist * Math.sin((double)(angle * 3.1415927F / 180.0F));
            double dZ = -((double)this.type.standBackDist * Math.cos((double)(angle * 3.1415927F / 180.0F)));
            this.gunner.func_70107_b((double)this.blockX + 0.5D + dX, (double)this.blockY + this.gunner.func_70033_W() - 0.5D, (double)this.blockZ + 0.5D + dZ);
         } else {
            --this.field_70125_A;
         }

         if (this.field_70125_A < this.type.topViewLimit) {
            this.field_70125_A = this.type.topViewLimit;
         }

         if (this.field_70125_A > this.type.bottomViewLimit) {
            this.field_70125_A = this.type.bottomViewLimit;
         }

         if (this.shootDelay > 0) {
            --this.shootDelay;
         }

         if (this.reloadTimer > 0) {
            --this.reloadTimer;
         }

         if (this.ammo != null && this.ammo.func_77960_j() == this.ammo.func_77958_k()) {
            this.ammo = null;
         }

         if (this.ammo == null && this.gunner != null) {
            int slot = this.findAmmo(this.gunner);
            if (slot >= 0) {
               this.ammo = this.gunner.field_71071_by.func_70301_a(slot);
               if (!this.gunner.field_71075_bZ.field_75098_d) {
                  this.gunner.field_71071_by.func_70299_a(slot, (ItemStack)null);
               }

               this.reloadTimer = this.type.reloadTime;
               PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, this.type.reloadSound, false);
            }
         }

         if (this.field_70170_p.field_72995_K && this.gunner != null && this.gunner == FMLClientHandler.instance().getClient().field_71439_g && this.type.mode == EnumFireMode.FULLAUTO) {
            this.checkForShooting();
         }

         if (!this.field_70170_p.field_72995_K && this.isShooting) {
            if (this.gunner == null || this.gunner.field_70128_L) {
               this.isShooting = false;
            }

            if (this.ammo == null || this.reloadTimer > 0 || this.shootDelay > 0) {
               return;
            }

            BulletType bullet = BulletType.getBullet(this.ammo.func_77973_b());
            if (this.gunner != null && !this.gunner.field_71075_bZ.field_75098_d) {
               this.ammo.func_77972_a(1, this.gunner);
            }

            this.shootDelay = this.type.shootDelay;
            this.field_70170_p.func_72838_d(((ItemBullet)this.ammo.func_77973_b()).getEntity(this.field_70170_p, Vec3.func_72443_a((double)this.blockX + 0.5D, (double)((float)this.blockY + this.type.pivotHeight), (double)this.blockZ + 0.5D), (float)this.direction * 90.0F + this.field_70177_z, this.field_70125_A, this.gunner, this.type.bulletSpread, this.type.damage, this.ammo.func_77960_j(), this.type));
            if (this.soundDelay <= 0) {
               this.soundDelay = this.type.shootSoundLength;
               PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, this.type.shootSound, this.type.distortSound);
            }
         }

         if (this.soundDelay > 0) {
            --this.soundDelay;
         }

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

   public void mouseHeld(boolean held) {
      this.isShooting = held;
   }

   public boolean func_70097_a(DamageSource damagesource, float i) {
      if (damagesource.field_76373_n.equals("player")) {
         Entity player = damagesource.func_76346_g();
         if (player == this.gunner) {
            if (this.type.mode == EnumFireMode.FULLAUTO) {
               return true;
            }

            if (this.ammo == null || this.reloadTimer > 0 || this.shootDelay > 0) {
               return true;
            }

            BulletType bullet = BulletType.getBullet(this.ammo.func_77973_b());
            if (this.gunner != null && !this.gunner.field_71075_bZ.field_75098_d) {
               this.ammo.func_77972_a(1, (EntityLiving)player);
            }

            this.shootDelay = this.type.shootDelay;
            if (!this.field_70170_p.field_72995_K) {
               this.field_70170_p.func_72838_d(((ItemBullet)this.ammo.func_77973_b()).getEntity(this.field_70170_p, (EntityLivingBase)player, this.type.bulletSpread, this.type.damage, this.type.bulletSpeed, false, this.ammo.func_77960_j(), this.type));
            }

            if (this.soundDelay <= 0) {
               float var10000;
               if (this.type.distortSound) {
                  var10000 = 1.0F / (this.field_70146_Z.nextFloat() * 0.4F + 0.8F);
               } else {
                  var10000 = 1.0F;
               }

               PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, this.type.shootSound, this.type.distortSound);
               this.soundDelay = this.type.shootSoundLength;
            }
         } else {
            if (this.gunner != null) {
               return this.gunner.func_70097_a(damagesource, i);
            }

            if (TeamsManager.canBreakGuns) {
               this.func_70106_y();
            }
         }
      }

      return true;
   }

   public boolean func_130002_c(EntityPlayer player) {
      if (this.gunner != null && this.gunner instanceof EntityPlayer && this.gunner != player) {
         return true;
      } else {
         if (!this.field_70170_p.field_72995_K) {
            if (this.gunner == player) {
               this.mountGun(player, false);
               FlansMod.getPacketHandler().sendToAllAround(new PacketMGMount(player, this, false), this.field_70165_t, this.field_70163_u, this.field_70161_v, 400.0F, this.field_71093_bK);
               return true;
            }

            if (PlayerHandler.getPlayerData(player).mountingGun != null && !PlayerHandler.getPlayerData(player).mountingGun.field_70128_L) {
               PlayerHandler.getPlayerData(player).mountingGun.mountGun(player, false);
               return true;
            }

            if (TeamsManager.instance.currentRound != null && PlayerHandler.getPlayerData(player).team == Team.spectators) {
               return true;
            }

            this.mountGun(player, true);
            FlansMod.getPacketHandler().sendToAllAround(new PacketMGMount(player, this, true), this.field_70165_t, this.field_70163_u, this.field_70161_v, 400.0F, this.field_71093_bK);
            if (this.ammo == null) {
               int slot = this.findAmmo(player);
               if (slot >= 0) {
                  this.ammo = player.field_71071_by.func_70301_a(slot);
                  player.field_71071_by.func_70299_a(slot, (ItemStack)null);
                  this.reloadTimer = this.type.reloadTime;
                  this.field_70170_p.func_72956_a(this, this.type.reloadSound, 1.0F, 1.0F / (this.field_70146_Z.nextFloat() * 0.4F + 0.8F));
               }
            }
         }

         return true;
      }
   }

   public void mountGun(EntityPlayer player, boolean mounting) {
      if (player != null) {
         Side side = this.field_70170_p.field_72995_K ? Side.CLIENT : Side.SERVER;
         if (PlayerHandler.getPlayerData(player, side) != null) {
            if (mounting) {
               this.gunner = player;
               PlayerHandler.getPlayerData(player, side).mountingGun = this;
            } else {
               PlayerHandler.getPlayerData(player, side).mountingGun = null;
               this.gunner = null;
            }

         }
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

   public void func_70106_y() {
      try {
         if (!this.field_70170_p.field_72995_K) {
            if (TeamsManager.weaponDrops == 2) {
               EntityGunItem gunEntity = new EntityGunItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, new ItemStack(this.type.getItem()), Arrays.asList(this.ammo));
               this.field_70170_p.func_72838_d(gunEntity);
            } else if (TeamsManager.weaponDrops == 1) {
               this.func_145779_a(this.type.getItem(), 1);
               if (this.ammo != null) {
                  this.func_70099_a(this.ammo, 0.5F);
               }
            }
         }

         if (this.gunner != null && PlayerHandler.getPlayerData(this.gunner) != null) {
            PlayerHandler.getPlayerData(this.gunner).mountingGun = null;
         }
      } catch (Exception var2) {
         if (FlansMod.printStackTrace) {
            var2.printStackTrace();
         }
      }

      super.func_70106_y();
   }

   protected void func_70014_b(NBTTagCompound nbttagcompound) {
      if (this.type == null) {
         FlansMod.log("EntityMG.writeEntityToNBT() Error: GunType is null (" + this + ")");
         this.func_70106_y();
      } else {
         nbttagcompound.func_74778_a("Type", this.type.shortName);
         if (this.ammo != null) {
            nbttagcompound.func_74782_a("Ammo", this.ammo.func_77955_b(new NBTTagCompound()));
         }

         nbttagcompound.func_74768_a("BlockX", this.blockX);
         nbttagcompound.func_74768_a("BlockY", this.blockY);
         nbttagcompound.func_74768_a("BlockZ", this.blockZ);
         nbttagcompound.func_74774_a("Dir", (byte)this.direction);
      }
   }

   protected void func_70037_a(NBTTagCompound nbttagcompound) {
      this.type = GunType.getGun(nbttagcompound.func_74779_i("Type"));
      if (this.type == null) {
         FlansMod.log("EntityMG.readEntityFromNBT() Error: GunType is null (" + this + ")");
         this.func_70106_y();
      } else {
         this.blockX = nbttagcompound.func_74762_e("BlockX");
         this.blockY = nbttagcompound.func_74762_e("BlockY");
         this.blockZ = nbttagcompound.func_74762_e("BlockZ");
         this.direction = nbttagcompound.func_74771_c("Dir");
         this.ammo = ItemStack.func_77949_a(nbttagcompound.func_74775_l("Ammo"));
      }
   }

   protected void func_70088_a() {
   }

   public void writeSpawnData(ByteBuf data) {
      ByteBufUtils.writeUTF8String(data, this.type.shortName);
      data.writeInt(this.direction);
      data.writeInt(this.blockX);
      data.writeInt(this.blockY);
      data.writeInt(this.blockZ);
      ByteBufUtils.writeItemStack(data, this.ammo);
   }

   public void readSpawnData(ByteBuf data) {
      try {
         this.type = GunType.getGun(ByteBufUtils.readUTF8String(data));
         this.direction = data.readInt();
         this.blockX = data.readInt();
         this.blockY = data.readInt();
         this.blockZ = data.readInt();
         this.ammo = ByteBufUtils.readItemStack(data);
      } catch (Exception var3) {
         FlansMod.log("Failed to retreive gun type from server.");
         super.func_70106_y();
         var3.printStackTrace();
      }

   }

   public ItemStack getPickedResult(MovingObjectPosition target) {
      ItemStack stack = new ItemStack(this.type.item, 1, 0);
      return stack;
   }
}
