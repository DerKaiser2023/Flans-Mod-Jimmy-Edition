package com.flansmod.common.guns;

import com.flansmod.common.FlansMod;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.types.TypeFile;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.HashMap;
import net.minecraft.client.model.ModelBase;

public abstract class ShootableType extends InfoType {
   @SideOnly(Side.CLIENT)
   public ModelBase model;
   public boolean trailParticles = false;
   public String trailParticleType = "smoke";
   public int maxStackSize = 1;
   public String dropItemOnReload = null;
   public String dropItemOnShoot = null;
   public String dropItemOnHit = null;
   public int roundsPerItem = 1;
   public float fallSpeed = 1.0F;
   public float throwSpeed = 1.0F;
   public float hitBoxSize = 0.5F;
   public float damageVsPlayer = 1.0F;
   public float damageVsEntity = 1.0F;
   public float damageVsLiving = 1.0F;
   public float damageVsVehicles = 1.0F;
   public float damageVsPlanes = 1.0F;
   public boolean readDamageVsPlayer = false;
   public boolean readDamageVsEntity = false;
   public boolean readDamageVsPlanes = false;
   public boolean missileRadarVisible = false;
   public boolean breaksGlass = false;
   public float ignoreArmorProbability = 0.0F;
   public float ignoreArmorDamageFactor = 0.0F;
   public int fuse = 0;
   public int despawnTime = 0;
   public boolean explodeOnImpact = false;
   public float fireRadius = 0.0F;
   public float explosionRadius = 0.0F;
   public float classicExplosionRadius = 0.0F;
   public boolean explosionBreaksBlocks = true;
   public float explosionDamageVsLiving = 1.0F;
   public float explosionDamageVsPlayer = 1.0F;
   public float explosionDamageVsPlane = 1.0F;
   public float explosionDamageVsVehicle = 1.0F;
   public String dropItemOnDetonate = null;
   public String detonateSound = "";
   public boolean hasSubmunitions = false;
   public String submunition = "";
   public int numSubmunitions = 0;
   public int subMunitionTimer = 0;
   public float submunitionSpread = 1.0F;
   public boolean destroyOnDeploySubmunition = false;
   public int smokeParticleCount = 0;
   public int debrisParticleCount = 0;
   public static HashMap<String, ShootableType> shootables = new HashMap();

   public ShootableType(TypeFile file) {
      super(file);
   }

   protected void preRead(TypeFile file) {
   }

   public void postRead(TypeFile file) {
      if (shootables.containsKey(this.shortName)) {
         FlansMod.log("Error : " + this.shortName + " reduplicated");
      }

      shootables.put(this.shortName, this);
      if (!this.readDamageVsPlayer) {
         this.damageVsPlayer = this.damageVsLiving;
      }

      if (!this.readDamageVsEntity) {
         this.damageVsEntity = this.damageVsVehicles;
      }

      if (!this.readDamageVsPlanes) {
         this.damageVsPlanes = this.damageVsVehicles;
      }

   }

   protected void read(String[] split, TypeFile file) {
      super.read(split, file);

      try {
         if (FMLCommonHandler.instance().getSide().isClient() && split[0].equals("Model")) {
            this.model = (ModelBase)FlansMod.proxy.loadModel(split[1], this.shortName, ModelBase.class);
         } else if (split[0].equals("Texture")) {
            this.texture = split[1];
         } else if (!split[0].equals("StackSize") && !split[0].equals("MaxStackSize")) {
            if (split[0].equals("DropItemOnShoot")) {
               this.dropItemOnShoot = split[1];
            } else if (split[0].equals("DropItemOnReload")) {
               this.dropItemOnReload = split[1];
            } else if (split[0].equals("DropItemOnHit")) {
               this.dropItemOnHit = split[1];
            } else if (split[0].equals("RoundsPerItem")) {
               this.roundsPerItem = Integer.parseInt(split[1]);
            } else if (split[0].equals("missileRadarVisible")) {
               this.missileRadarVisible = Boolean.parseBoolean(split[1]);
            } else if (split[0].equals("FallSpeed")) {
               this.fallSpeed = Float.parseFloat(split[1]);
            } else if (!split[0].equals("ThrowSpeed") && !split[0].equals("ShootSpeed")) {
               if (split[0].equals("HitBoxSize")) {
                  this.hitBoxSize = Float.parseFloat(split[1]);
               } else if (split[0].equals("DamageVsLiving")) {
                  this.damageVsLiving = Float.parseFloat(split[1]);
               } else if (split[0].equals("DamageVsPlayer")) {
                  this.damageVsPlayer = Float.parseFloat(split[1]);
                  this.readDamageVsPlayer = true;
               } else if (split[0].equals("DamageVsEntity")) {
                  this.damageVsEntity = Float.parseFloat(split[1]);
                  this.readDamageVsEntity = true;
               } else if (split[0].equals("DamageVsVehicles")) {
                  this.damageVsVehicles = Float.parseFloat(split[1]);
               } else if (split[0].equals("DamageVsPlanes")) {
                  this.damageVsPlanes = Float.parseFloat(split[1]);
                  this.readDamageVsPlanes = true;
               } else if (split[0].equals("IgnoreArmorProbability")) {
                  this.ignoreArmorProbability = Float.parseFloat(split[1]);
               } else if (split[0].equals("IgnoreArmorDamageFactor")) {
                  this.ignoreArmorDamageFactor = Float.parseFloat(split[1]);
               } else if (split[0].equals("BreaksGlass")) {
                  this.breaksGlass = Boolean.parseBoolean(split[1].toLowerCase());
               } else if (split[0].equals("Fuse")) {
                  this.fuse = Integer.parseInt(split[1]);
               } else if (split[0].equals("DespawnTime")) {
                  this.despawnTime = Integer.parseInt(split[1]);
               } else if (!split[0].equals("ExplodeOnImpact") && !split[0].equals("DetonateOnImpact")) {
                  if (!split[0].equals("FireRadius") && !split[0].equals("Fire")) {
                     if (!split[0].equals("ExplosionRadius") && !split[0].equals("Explosion")) {
                        if (!split[0].equals("classicExplosionRadius") && !split[0].equals("classicExplosion")) {
                           if (split[0].equals("ExplosionBreaksBlocks")) {
                              this.explosionBreaksBlocks = Boolean.parseBoolean(split[1].toLowerCase());
                           } else if (split[0].equals("ExplosionDamageVsLiving")) {
                              this.explosionDamageVsLiving = Float.parseFloat(split[1]);
                           } else if (split[0].equals("ExplosionDamageVsPlayer")) {
                              this.explosionDamageVsPlayer = Float.parseFloat(split[1]);
                           } else if (split[0].equals("ExplosionDamageVsPlane")) {
                              this.explosionDamageVsPlane = Float.parseFloat(split[1]);
                           } else if (split[0].equals("ExplosionDamageVsVehicle")) {
                              this.explosionDamageVsVehicle = Float.parseFloat(split[1]);
                           } else if (split[0].equals("DropItemOnDetonate")) {
                              this.dropItemOnDetonate = split[1];
                           } else if (split[0].equals("DetonateSound")) {
                              this.detonateSound = split[1];
                           } else if (split[0].equals("HasSubmunitions")) {
                              this.hasSubmunitions = Boolean.parseBoolean(split[1].toLowerCase());
                           } else if (split[0].equals("Submunition")) {
                              this.submunition = split[1];
                           } else if (split[0].equals("NumSubmunitions")) {
                              this.numSubmunitions = Integer.parseInt(split[1]);
                           } else if (split[0].equals("SubmunitionDelay")) {
                              this.subMunitionTimer = Integer.parseInt(split[1]);
                           } else if (split[0].equals("SubmunitionSpread")) {
                              this.submunitionSpread = Float.parseFloat(split[1]);
                           } else if (split[0].equals("FlareParticleCount")) {
                              this.smokeParticleCount = Integer.parseInt(split[1]);
                           } else if (split[0].equals("DebrisParticleCount")) {
                              this.debrisParticleCount = Integer.parseInt(split[1]);
                           } else if (!split[0].equals("TrailParticles") && !split[0].equals("SmokeTrail")) {
                              if (split[0].equals("TrailParticleType")) {
                                 this.trailParticleType = split[1];
                              }
                           } else {
                              this.trailParticles = Boolean.parseBoolean(split[1].toLowerCase());
                           }
                        } else {
                           this.classicExplosionRadius = Float.parseFloat(split[1]);
                        }
                     } else {
                        this.explosionRadius = Float.parseFloat(split[1]);
                     }
                  } else {
                     this.fireRadius = Float.parseFloat(split[1]);
                  }
               } else {
                  this.explodeOnImpact = Boolean.parseBoolean(split[1].toLowerCase());
               }
            } else {
               this.throwSpeed = Float.parseFloat(split[1]);
            }
         } else {
            this.maxStackSize = Integer.parseInt(split[1]);
         }
      } catch (Exception var9) {
         if (split == null) {
            System.out.println("Reading grenade file failed. " + file.name);
         } else {
            String msg = " : ";
            String[] var5 = split;
            int var6 = split.length;

            for(int var7 = 0; var7 < var6; ++var7) {
               String s = var5[var7];
               msg = msg + " " + s;
            }

            System.out.println("Reading grenade file failed. " + file.name + msg);
         }

         if (FlansMod.printStackTrace) {
            var9.printStackTrace();
         }
      }

   }

   public static ShootableType getShootableType(String string) {
      return (ShootableType)shootables.get(string);
   }

   public float GetRecommendedScale() {
      return 0.0F;
   }

   @SideOnly(Side.CLIENT)
   public ModelBase GetModel() {
      return this.model;
   }
}
