package com.flansmod.common.guns;

import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntityPlane;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.driveables.EntityVehicle;
import com.flansmod.common.driveables.EntityWheel;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketExplosion;
import com.flansmod.common.network.PacketParticle;
import com.flansmod.common.types.InfoType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class FlansModExplosion extends Explosion {
   private static final int boomRadius = 16;
   private static final Random explosionRNG = new Random();
   private HashMap<EntityPlayer, Vec3> playerLocations = new HashMap();
   private World worldObj;
   public InfoType type;
   public EntityPlayer player;
   private float radius;
   private final float damageVsLiving;
   private final float damageVsPlayer;
   private final float damageVsPlane;
   private final float damageVsVehicle;
   public boolean breakBlocks;

   public FlansModExplosion(World w, Entity e, EntityPlayer p, InfoType t, double x, double y, double z, float r, boolean breakBlocks, float damageLiving, float damagePlayer, float damagePlane, float damageVehicle, int smokeCount, int debrisCount) {
      super(w, e, x, y, z, r);
      this.radius = r;
      this.worldObj = w;
      this.type = t;
      this.player = p;
      this.field_77286_a = false;
      this.field_82755_b = true;
      this.breakBlocks = breakBlocks;
      this.damageVsPlayer = damagePlayer;
      this.damageVsLiving = damageLiving;
      this.damageVsPlane = damagePlane;
      this.damageVsVehicle = damageVehicle;
      this.func_77278_a();
      this.func_77279_a(true);
      this.spawnParticle(smokeCount, debrisCount);
      if (!this.worldObj.field_72995_K) {
         Iterator var19 = this.worldObj.field_73010_i.iterator();

         while(var19.hasNext()) {
            Object playerEntity = var19.next();
            if (playerEntity instanceof EntityPlayerMP) {
               EntityPlayerMP entityplayer = (EntityPlayerMP)playerEntity;
               if (entityplayer.func_70092_e(x, y, z) < 4096.0D) {
                  FlansMod.getPacketHandler().sendTo((PacketBase)(new PacketExplosion(x, y, z, r)), entityplayer);
               }
            }
         }
      }

   }

   public void func_77278_a() {
      float f = this.field_77280_f;
      HashSet hashset = new HashSet();

      double d0;
      double d1;
      double d2;
      int i;
      int j;
      int k;
      for(i = 0; i < 16; ++i) {
         for(j = 0; j < 16; ++j) {
            for(k = 0; k < 16; ++k) {
               if (i == 0 || i == 15 || j == 0 || j == 15 || k == 0 || k == 15) {
                  double d3 = (double)((float)i / 15.0F * 2.0F - 1.0F);
                  double d4 = (double)((float)j / 15.0F * 2.0F - 1.0F);
                  double d5 = (double)((float)k / 15.0F * 2.0F - 1.0F);
                  double d6 = Math.sqrt(d3 * d3 + d4 * d4 + d5 * d5);
                  d3 /= d6;
                  d4 /= d6;
                  d5 /= d6;
                  float f1 = this.field_77280_f * (0.7F + this.worldObj.field_73012_v.nextFloat() * 0.6F);
                  d0 = this.field_77284_b;
                  d1 = this.field_77285_c;
                  d2 = this.field_77282_d;

                  for(float f2 = 0.3F; f1 > 0.0F; f1 -= f2 * 0.75F) {
                     int l = MathHelper.func_76128_c(d0);
                     int i1 = MathHelper.func_76128_c(d1);
                     int j1 = MathHelper.func_76128_c(d2);
                     Block block = this.worldObj.func_147439_a(l, i1, j1);
                     float f3 = this.field_77283_e != null ? this.field_77283_e.func_145772_a(this, this.worldObj, l, i1, j1, block) : block.getExplosionResistance(this.field_77283_e, this.worldObj, l, i1, j1, this.field_77284_b, this.field_77285_c, this.field_77282_d);
                     f1 -= (f3 + 0.3F) * f2;
                     if (f1 > 0.0F && (this.field_77283_e == null || this.field_77283_e.func_145774_a(this, this.worldObj, l, i1, j1, block, f1))) {
                        hashset.add(new ChunkPosition(l, i1, j1));
                     }

                     d0 += d3 * (double)f2;
                     d1 += d4 * (double)f2;
                     d2 += d5 * (double)f2;
                  }
               }
            }
         }
      }

      this.field_77281_g.addAll(hashset);
      this.field_77280_f *= 2.0F;
      i = MathHelper.func_76128_c(this.field_77284_b - (double)this.field_77280_f - 1.0D);
      j = MathHelper.func_76128_c(this.field_77284_b + (double)this.field_77280_f + 1.0D);
      k = MathHelper.func_76128_c(this.field_77285_c - (double)this.field_77280_f - 1.0D);
      int l1 = MathHelper.func_76128_c(this.field_77285_c + (double)this.field_77280_f + 1.0D);
      int i2 = MathHelper.func_76128_c(this.field_77282_d - (double)this.field_77280_f - 1.0D);
      int j2 = MathHelper.func_76128_c(this.field_77282_d + (double)this.field_77280_f + 1.0D);
      List list = this.worldObj.func_72839_b(this.field_77283_e, AxisAlignedBB.func_72330_a((double)i, (double)k, (double)i2, (double)j, (double)l1, (double)j2));
      Vec3 vec3 = Vec3.func_72443_a(this.field_77284_b, this.field_77285_c, this.field_77282_d);
      Iterator var17 = list.iterator();

      while(true) {
         Entity entity;
         double d7;
         double d8;
         do {
            do {
               if (!var17.hasNext()) {
                  this.field_77280_f = f;
                  return;
               }

               Object aList = var17.next();
               entity = (Entity)aList;
               d7 = entity.func_70011_f(this.field_77284_b, this.field_77285_c, this.field_77282_d) / (double)this.field_77280_f;
            } while(!(d7 <= 1.0D));

            d0 = entity.field_70165_t - this.field_77284_b;
            d1 = entity.field_70163_u + (double)entity.func_70047_e() - this.field_77285_c;
            d2 = entity.field_70161_v - this.field_77282_d;
            d8 = (double)MathHelper.func_76133_a(d0 * d0 + d1 * d1 + d2 * d2);
         } while(d8 == 0.0D);

         d0 /= d8;
         d1 /= d8;
         d2 /= d8;
         double d9 = (double)this.getBlockDensity(vec3, entity.field_70121_D);
         double d10 = (1.0D - d7) * d9;
         EntityDriveable entityDriveable = null;
         float damage = (float)((d10 * d10 + d10) / 2.0D * 8.0D * (double)this.field_77280_f + 1.0D);
         if (entity instanceof EntityPlayer) {
            damage *= this.damageVsPlayer;
         } else if (entity instanceof EntityLivingBase) {
            damage *= this.damageVsLiving;
         } else if (entity instanceof EntityPlane) {
            damage *= this.damageVsPlane;
         } else if (entity instanceof EntityVehicle) {
            damage *= this.damageVsVehicle;
         } else if (entity instanceof EntityWheel) {
            entityDriveable = ((EntityWheel)entity).vehicle;
         } else if (entity instanceof EntitySeat) {
            entityDriveable = ((EntitySeat)entity).driveable;
         }

         if (entityDriveable instanceof EntityPlane) {
            damage *= this.damageVsPlane;
         }

         if (entityDriveable instanceof EntityVehicle) {
            damage *= this.damageVsVehicle;
         }

         if (damage > 0.5F) {
            boolean b = entity.func_70097_a((DamageSource)(this.player != null && this.type != null ? new EntityDamageSourceGun(this.type.shortName, entity, this.player, this.type, false) : DamageSource.func_94539_a(this)), damage);
            if (b) {
               EntityBullet.hitCrossHair = true;
            }

            double d11 = EnchantmentProtection.func_92092_a(entity, d10);
            entity.field_70159_w += d0 * d11;
            entity.field_70181_x += d1 * d11;
            entity.field_70179_y += d2 * d11;
         }

         if (entity instanceof EntityPlayer) {
            this.playerLocations.put((EntityPlayer)entity, Vec3.func_72443_a(d0 * d10, d1 * d10, d2 * d10));
         }
      }
   }

   public void spawnParticle(int numSmoke, int numDebris) {
      float mod = this.radius * 0.1F;

      int debris;
      float smokeRand;
      for(debris = 0; debris < numSmoke; ++debris) {
         smokeRand = (float)Math.random();
         if ((double)smokeRand < 0.25D) {
            FlansMod.getPacketHandler().sendToAllAround(new PacketParticle("flansmod.flare", this.field_77284_b, this.field_77285_c, this.field_77282_d, (double)((float)Math.random() * mod), (double)((float)Math.random() * mod), (double)((float)Math.random() * mod)), this.field_77284_b, this.field_77285_c, this.field_77282_d, 150.0F, this.worldObj.field_73011_w.field_76574_g);
         } else if ((double)smokeRand > 0.25D && (double)smokeRand < 0.5D) {
            FlansMod.getPacketHandler().sendToAllAround(new PacketParticle("flansmod.flare", this.field_77284_b, this.field_77285_c, this.field_77282_d, (double)((float)Math.random() * mod), (double)((float)Math.random() * mod), (double)(-((float)Math.random()) * mod)), this.field_77284_b, this.field_77285_c, this.field_77282_d, 150.0F, this.worldObj.field_73011_w.field_76574_g);
         } else if ((double)smokeRand > 0.5D && (double)smokeRand < 0.75D) {
            FlansMod.getPacketHandler().sendToAllAround(new PacketParticle("flansmod.flare", this.field_77284_b, this.field_77285_c, this.field_77282_d, (double)(-((float)Math.random()) * mod), (double)((float)Math.random() * mod), (double)(-((float)Math.random()) * mod)), this.field_77284_b, this.field_77285_c, this.field_77282_d, 150.0F, this.worldObj.field_73011_w.field_76574_g);
         } else if ((double)smokeRand > 0.75D) {
            FlansMod.getPacketHandler().sendToAllAround(new PacketParticle("flansmod.flare", this.field_77284_b, this.field_77285_c, this.field_77282_d, (double)(-((float)Math.random()) * mod), (double)((float)Math.random() * mod), (double)((float)Math.random() * mod)), this.field_77284_b, this.field_77285_c, this.field_77282_d, 150.0F, this.worldObj.field_73011_w.field_76574_g);
         }
      }

      for(debris = 0; debris < numDebris; ++debris) {
         smokeRand = (float)Math.random();
         if ((double)smokeRand < 0.25D) {
            FlansMod.getPacketHandler().sendToAllAround(new PacketParticle("flansmod.debris1", this.field_77284_b, this.field_77285_c, this.field_77282_d, (double)((float)Math.random() * mod), (double)((float)Math.random() * mod), (double)((float)Math.random() * mod)), this.field_77284_b, this.field_77285_c, this.field_77282_d, 150.0F, this.worldObj.field_73011_w.field_76574_g);
         } else if ((double)smokeRand > 0.25D && (double)smokeRand < 0.5D) {
            FlansMod.getPacketHandler().sendToAllAround(new PacketParticle("flansmod.debris1", this.field_77284_b, this.field_77285_c, this.field_77282_d, (double)((float)Math.random() * mod), (double)((float)Math.random() * mod), (double)(-((float)Math.random()) * mod)), this.field_77284_b, this.field_77285_c, this.field_77282_d, 150.0F, this.worldObj.field_73011_w.field_76574_g);
         } else if ((double)smokeRand > 0.5D && (double)smokeRand < 0.75D) {
            FlansMod.getPacketHandler().sendToAllAround(new PacketParticle("flansmod.debris1", this.field_77284_b, this.field_77285_c, this.field_77282_d, (double)(-((float)Math.random()) * mod), (double)((float)Math.random() * mod), (double)((float)Math.random() * mod)), this.field_77284_b, this.field_77285_c, this.field_77282_d, 150.0F, this.worldObj.field_73011_w.field_76574_g);
         } else if ((double)smokeRand > 0.75D) {
            FlansMod.getPacketHandler().sendToAllAround(new PacketParticle("flansmod.debris1", this.field_77284_b, this.field_77285_c, this.field_77282_d, (double)(-((float)Math.random()) * mod), (double)((float)Math.random() * mod), (double)(-((float)Math.random()) * mod)), this.field_77284_b, this.field_77285_c, this.field_77282_d, 150.0F, this.worldObj.field_73011_w.field_76574_g);
         }
      }

   }

   public float getBlockDensity(Vec3 p_72842_1_, AxisAlignedBB p_72842_2_) {
      double d0 = 1.0D / ((p_72842_2_.field_72336_d - p_72842_2_.field_72340_a) * 2.0D + 1.0D);
      double d1 = 1.0D / ((p_72842_2_.field_72337_e - p_72842_2_.field_72338_b) * 2.0D + 1.0D);
      double d2 = 1.0D / ((p_72842_2_.field_72334_f - p_72842_2_.field_72339_c) * 2.0D + 1.0D);
      if (d0 >= 0.0D && d1 >= 0.0D && d2 >= 0.0D) {
         int i = 0;
         int j = 0;

         for(float f = 0.0F; f <= 1.0F; f = (float)((double)f + d0)) {
            for(float f1 = 0.0F; f1 <= 1.0F; f1 = (float)((double)f1 + d1)) {
               for(float f2 = 0.0F; f2 <= 1.0F; f2 = (float)((double)f2 + d2)) {
                  double d3 = p_72842_2_.field_72340_a + (p_72842_2_.field_72336_d - p_72842_2_.field_72340_a) * (double)f;
                  double d4 = p_72842_2_.field_72338_b + (p_72842_2_.field_72337_e - p_72842_2_.field_72338_b) * (double)f1;
                  double d5 = p_72842_2_.field_72339_c + (p_72842_2_.field_72334_f - p_72842_2_.field_72339_c) * (double)f2;
                  if (this.worldObj.func_147447_a(Vec3.func_72443_a(d3, d4, d5), p_72842_1_, false, true, false) == null) {
                     ++i;
                  }

                  ++j;
               }
            }
         }

         return (float)i / (float)j;
      } else {
         return 0.0F;
      }
   }

   public void func_77279_a(boolean par1) {
      this.worldObj.func_72908_a(this.field_77284_b, this.field_77285_c, this.field_77282_d, "random.explode", 4.0F, (1.0F + (this.worldObj.field_73012_v.nextFloat() - this.worldObj.field_73012_v.nextFloat()) * 0.2F) * 0.7F);
      if (!this.worldObj.field_72995_K && this.breakBlocks) {
         this.worldObj.func_72876_a((Entity)null, this.field_77284_b, this.field_77285_c, this.field_77282_d, this.radius, true);
      }

      if (!this.worldObj.field_72995_K && this.field_77286_a) {
         Iterator iterator = this.field_77281_g.iterator();

         while(iterator.hasNext()) {
            ChunkPosition chunkposition = (ChunkPosition)iterator.next();
            int i = chunkposition.field_151329_a;
            int j = chunkposition.field_151327_b;
            int k = chunkposition.field_151328_c;
            Block block = this.worldObj.func_147439_a(i, j, k);
            Block blockBelow = this.worldObj.func_147439_a(i, j - 1, k);
            if (block == null && blockBelow.func_149662_c() && explosionRNG.nextInt(3) == 0) {
               this.worldObj.func_147449_b(i, j, k, Blocks.field_150480_ab);
            }
         }
      }

   }

   public Map func_77277_b() {
      return this.playerLocations;
   }

   public EntityLivingBase func_94613_c() {
      return this.field_77283_e == null ? null : (this.field_77283_e instanceof EntityTNTPrimed ? ((EntityTNTPrimed)this.field_77283_e).func_94083_c() : (this.field_77283_e instanceof EntityLivingBase ? (EntityLivingBase)this.field_77283_e : null));
   }

   public static void clientExplosion(World worldObj, float explosionSize, double explosionX, double explosionY, double explosionZ) {
      List affectedBlockPositions = new ArrayList();
      Entity exploder = null;
      Explosion explosion = new Explosion(worldObj, (Entity)exploder, explosionX, explosionY, explosionZ, explosionSize);
      if (explosionSize < 2.0F) {
         explosionX += (double)(explosionRNG.nextFloat() - 0.5F);
         explosionZ += (double)(explosionRNG.nextFloat() - 0.5F);
      }

      boolean isSmoking = true;
      float f = explosionSize;
      HashSet hashset = new HashSet();

      int i;
      int i;
      int j;
      double d5;
      double d0;
      double d1;
      double d2;
      double d3;
      double d4;
      double d5;
      for(i = 0; i < 16; ++i) {
         for(i = 0; i < 16; ++i) {
            for(j = 0; j < 16; ++j) {
               if (i == 0 || i == 15 || i == 0 || i == 15 || j == 0 || j == 15) {
                  d2 = (double)((float)i / 15.0F * 2.0F - 1.0F);
                  d3 = (double)((float)i / 15.0F * 2.0F - 1.0F);
                  d4 = (double)((float)j / 15.0F * 2.0F - 1.0F);
                  d5 = Math.sqrt(d2 * d2 + d3 * d3 + d4 * d4);
                  d2 /= d5;
                  d3 /= d5;
                  d4 /= d5;
                  float f1 = explosionSize * (0.7F + worldObj.field_73012_v.nextFloat() * 0.6F);
                  d5 = explosionX;
                  d0 = explosionY;
                  d1 = explosionZ;

                  for(float f2 = 0.3F; f1 > 0.0F; f1 -= f2 * 0.75F) {
                     int j1 = MathHelper.func_76128_c(d5);
                     int k1 = MathHelper.func_76128_c(d0);
                     int l1 = MathHelper.func_76128_c(d1);
                     Block block = worldObj.func_147439_a(j1, k1, l1);
                     float f3 = 0.0F;
                     f1 -= (f3 + 0.3F) * f2;
                     if (f1 > 0.0F && (exploder == null || ((Entity)exploder).func_145774_a(explosion, worldObj, j1, k1, l1, block, f1))) {
                        hashset.add(new ChunkPosition(j1, k1, l1));
                     }

                     d5 += d2 * (double)f2;
                     d0 += d3 * (double)f2;
                     d1 += d4 * (double)f2;
                  }
               }
            }
         }
      }

      affectedBlockPositions.addAll(hashset);
      explosionSize *= 2.0F;
      i = MathHelper.func_76128_c(explosionX - (double)explosionSize - 1.0D);
      i = MathHelper.func_76128_c(explosionX + (double)explosionSize + 1.0D);
      j = MathHelper.func_76128_c(explosionY - (double)explosionSize - 1.0D);
      int i2 = MathHelper.func_76128_c(explosionY + (double)explosionSize + 1.0D);
      int l = MathHelper.func_76128_c(explosionZ - (double)explosionSize - 1.0D);
      int j2 = MathHelper.func_76128_c(explosionZ + (double)explosionSize + 1.0D);
      List list = worldObj.func_72839_b((Entity)exploder, AxisAlignedBB.func_72330_a((double)i, (double)j, (double)l, (double)i, (double)i2, (double)j2));
      Vec3 vec3 = Vec3.func_72443_a(explosionX, explosionY, explosionZ);

      for(int i1 = 0; i1 < list.size(); ++i1) {
         Entity entity = (Entity)list.get(i1);
         double d4 = entity.func_70011_f(explosionX, explosionY, explosionZ) / (double)explosionSize;
         if (d4 <= 1.0D) {
            d5 = entity.field_70165_t - explosionX;
            d0 = entity.field_70163_u + (double)entity.func_70047_e() - explosionY;
            d1 = entity.field_70161_v - explosionZ;
            double d9 = (double)MathHelper.func_76133_a(d5 * d5 + d0 * d0 + d1 * d1);
            if (d9 != 0.0D) {
               d5 /= d9;
               d0 /= d9;
               d1 /= d9;
               double d10 = (double)worldObj.func_72842_a(vec3, entity.field_70121_D);
               double d11 = (1.0D - d4) * d10;
               double d8 = EnchantmentProtection.func_92092_a(entity, d11);
               entity.field_70159_w += d5 * d8;
               entity.field_70181_x += d0 * d8;
               entity.field_70179_y += d1 * d8;
            }
         }
      }

      explosionSize = f;
      if (f >= 2.0F && isSmoking) {
         worldObj.func_72869_a("hugeexplosion", explosionX, explosionY, explosionZ, 1.0D, 0.0D, 0.0D);
      } else {
         worldObj.func_72869_a("largeexplode", explosionX, explosionY, explosionZ, 1.0D, 0.0D, 0.0D);
      }

      Iterator iterator = affectedBlockPositions.iterator();
      int cnt = 0;

      while(iterator.hasNext()) {
         ++cnt;
         ChunkPosition chunkposition = (ChunkPosition)iterator.next();
         i = chunkposition.field_151329_a;
         j = chunkposition.field_151327_b;
         int k = chunkposition.field_151328_c;
         worldObj.func_147439_a(i, j, k);
         d0 = (double)((float)i + worldObj.field_73012_v.nextFloat());
         d1 = (double)((float)j + worldObj.field_73012_v.nextFloat());
         d2 = (double)((float)k + worldObj.field_73012_v.nextFloat());
         d3 = d0 - explosionX;
         d4 = d1 - explosionY;
         d5 = d2 - explosionZ;
         double d6 = (double)MathHelper.func_76133_a(d3 * d3 + d4 * d4 + d5 * d5);
         d3 /= d6;
         d4 /= d6;
         d5 /= d6;
         double d7 = 0.5D / (d6 / (double)explosionSize + 0.1D);
         d7 *= (double)(worldObj.field_73012_v.nextFloat() * worldObj.field_73012_v.nextFloat() + 0.3F);
         d3 *= d7;
         d4 *= d7;
         d5 *= d7;
         if (explosionSize <= 1.0F && cnt % 4 == 0 || explosionSize > 1.0F) {
            FlansMod.proxy.spawnParticle("explode", (d0 + explosionX * 1.0D) / 2.0D, (d1 + explosionY * 1.0D) / 2.0D, (d2 + explosionZ * 1.0D) / 2.0D, d3, d4, d5);
         }

         Block block = Blocks.field_150350_a;
         if (explosionSize <= 2.0F) {
            if (cnt % 8 == 0) {
               block = getNearBlock(worldObj, i, j, k);
            }
         } else {
            block = getNearBlock(worldObj, i, j, k);
         }

         if (block != Blocks.field_150350_a) {
            float m;
            if (explosionSize <= 1.0F) {
               m = explosionSize * 2.0F;
            } else {
               m = explosionSize * 0.5F;
            }

            String pname = "blockdust_" + Block.func_149682_b(block) + "_" + worldObj.func_72805_g(i, j, k);
            FlansMod.proxy.spawnParticle(pname, (d0 + explosionX * 1.0D) / 2.0D, (d1 + explosionY * 1.0D) / 2.0D, (d2 + explosionZ * 1.0D) / 2.0D, d3 * (double)m, d4 * (double)m, d5 * (double)m);
         }
      }

   }

   public static Block getNearBlock(World w, int x, int y, int z) {
      int[][] offset = new int[][]{{0, -1, 0}, {1, 0, 0}, {-1, 0, 0}, {0, 0, 1}, {0, 0, -1}};

      for(int i = 0; i < offset.length; ++i) {
         if (y > 1 || offset[i][1] == 0) {
            Block block = w.func_147439_a(x + offset[i][0], y + offset[i][1], z + offset[i][2]);
            if (block != Blocks.field_150350_a) {
               return block;
            }
         }
      }

      return Blocks.field_150350_a;
   }
}
