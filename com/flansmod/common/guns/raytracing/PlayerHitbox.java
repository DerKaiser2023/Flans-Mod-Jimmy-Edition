package com.flansmod.common.guns.raytracing;

import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.guns.EntityBullet;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.teams.TeamsManager;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class PlayerHitbox {
   public EntityPlayer player;
   public RotatedAxes axes;
   public Vector3f rP;
   public Vector3f o;
   public Vector3f d;
   public EnumHitboxType type;

   public PlayerHitbox(EntityPlayer player, RotatedAxes axes, Vector3f rotationPoint, Vector3f origin, Vector3f dimensions, EnumHitboxType type) {
      this.player = player;
      this.axes = axes;
      this.o = origin;
      this.d = dimensions;
      this.type = type;
      this.rP = rotationPoint;
   }

   @SideOnly(Side.CLIENT)
   public void renderHitbox(World world, Vector3f pos) {
   }

   public PlayerBulletHit raytrace(Vector3f origin, Vector3f motion) {
      origin = Vector3f.sub(origin, this.rP, (Vector3f)null);
      origin = this.axes.findGlobalVectorLocally(origin);
      motion = this.axes.findGlobalVectorLocally(motion);
      float intersectTime;
      float intersectX;
      float intersectZ;
      if (motion.x != 0.0F) {
         if (origin.x < this.o.x) {
            intersectTime = (this.o.x - origin.x) / motion.x;
            intersectX = origin.y + motion.y * intersectTime;
            intersectZ = origin.z + motion.z * intersectTime;
            if (intersectX >= this.o.y && intersectX <= this.o.y + this.d.y && intersectZ >= this.o.z && intersectZ <= this.o.z + this.d.z) {
               return new PlayerBulletHit(this, intersectTime);
            }
         } else if (origin.x > this.o.x + this.d.x) {
            intersectTime = (this.o.x + this.d.x - origin.x) / motion.x;
            intersectX = origin.y + motion.y * intersectTime;
            intersectZ = origin.z + motion.z * intersectTime;
            if (intersectX >= this.o.y && intersectX <= this.o.y + this.d.y && intersectZ >= this.o.z && intersectZ <= this.o.z + this.d.z) {
               return new PlayerBulletHit(this, intersectTime);
            }
         }
      }

      if (motion.z != 0.0F) {
         if (origin.z < this.o.z) {
            intersectTime = (this.o.z - origin.z) / motion.z;
            intersectX = origin.x + motion.x * intersectTime;
            intersectZ = origin.y + motion.y * intersectTime;
            if (intersectX >= this.o.x && intersectX <= this.o.x + this.d.x && intersectZ >= this.o.y && intersectZ <= this.o.y + this.d.y) {
               return new PlayerBulletHit(this, intersectTime);
            }
         } else if (origin.z > this.o.z + this.d.z) {
            intersectTime = (this.o.z + this.d.z - origin.z) / motion.z;
            intersectX = origin.x + motion.x * intersectTime;
            intersectZ = origin.y + motion.y * intersectTime;
            if (intersectX >= this.o.x && intersectX <= this.o.x + this.d.x && intersectZ >= this.o.y && intersectZ <= this.o.y + this.d.y) {
               return new PlayerBulletHit(this, intersectTime);
            }
         }
      }

      if (motion.y != 0.0F) {
         if (origin.y < this.o.y) {
            intersectTime = (this.o.y - origin.y) / motion.y;
            intersectX = origin.x + motion.x * intersectTime;
            intersectZ = origin.z + motion.z * intersectTime;
            if (intersectX >= this.o.x && intersectX <= this.o.x + this.d.x && intersectZ >= this.o.z && intersectZ <= this.o.z + this.d.z) {
               return new PlayerBulletHit(this, intersectTime);
            }
         } else if (origin.y > this.o.y + this.d.y) {
            intersectTime = (this.o.y + this.d.y - origin.y) / motion.y;
            intersectX = origin.x + motion.x * intersectTime;
            intersectZ = origin.z + motion.z * intersectTime;
            if (intersectX >= this.o.x && intersectX <= this.o.x + this.d.x && intersectZ >= this.o.z && intersectZ <= this.o.z + this.d.z) {
               return new PlayerBulletHit(this, intersectTime);
            }
         }
      }

      return null;
   }

   public float hitByBullet(EntityBullet bullet, float penetratingPower) {
      if (bullet.type.setEntitiesOnFire) {
         this.player.func_70015_d(20);
      }

      Iterator var3 = bullet.type.hitEffects.iterator();

      while(var3.hasNext()) {
         PotionEffect effect = (PotionEffect)var3.next();
         this.player.func_70690_d(new PotionEffect(effect));
      }

      float damageModifier = bullet.type.penetratingPower < 0.1F ? penetratingPower / bullet.type.penetratingPower : 1.0F;
      switch(this.type) {
      case BODY:
      case LEFTITEM:
      case RIGHTITEM:
      default:
         break;
      case HEAD:
         damageModifier *= 2.0F;
         break;
      case LEFTARM:
         damageModifier *= 0.6F;
         break;
      case RIGHTARM:
         damageModifier *= 0.6F;
      }

      GunType gunType;
      switch(this.type) {
      case BODY:
      case HEAD:
      case LEFTARM:
      case RIGHTARM:
         float hitDamage = bullet.damage * bullet.type.damageVsPlayer * damageModifier;
         DamageSource damagesource = bullet.owner == null ? DamageSource.field_76377_j : bullet.getBulletDamage(this.type == EnumHitboxType.HEAD);
         if (!this.player.field_70170_p.field_72995_K && hitDamage == 0.0F && TeamsManager.getInstance().currentRound != null) {
            EntityPlayerMP var10001 = (EntityPlayerMP)this.player;
            TeamsManager.getInstance().currentRound.gametype.playerAttacked(var10001, damagesource);
         }

         if (this.player.func_70097_a(damagesource, hitDamage)) {
            ++this.player.field_70720_be;
            this.player.field_70172_ad = this.player.field_70771_an / 2;
         }

         return penetratingPower - 1.0F;
      case LEFTITEM:
         PlayerData data = PlayerHandler.getPlayerData(this.player);
         if (data.offHandGunSlot != 0) {
            gunType = null;
            ItemStack leftHandStack;
            if (this.player.field_70170_p.field_72995_K && !FlansMod.proxy.isThePlayer(this.player)) {
               leftHandStack = data.offHandGunStack;
            } else {
               leftHandStack = this.player.field_71071_by.func_70301_a(data.offHandGunSlot - 1);
            }

            if (leftHandStack != null && leftHandStack.func_77973_b() instanceof ItemGun) {
               GunType leftGunType = ((ItemGun)leftHandStack.func_77973_b()).type;
               return penetratingPower - leftGunType.shieldDamageAbsorption;
            }
         }
      default:
         return penetratingPower;
      case RIGHTITEM:
         ItemStack currentStack = this.player.func_71045_bC();
         if (currentStack != null && currentStack.func_77973_b() instanceof ItemGun) {
            gunType = ((ItemGun)currentStack.func_77973_b()).type;
            return penetratingPower - gunType.shieldDamageAbsorption;
         } else {
            return penetratingPower;
         }
      }
   }
}
