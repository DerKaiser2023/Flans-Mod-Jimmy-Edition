package com.flansmod.common.guns;

import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.EnumWeaponType;
import com.flansmod.common.types.TypeFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;

public class BulletType extends ShootableType {
   public int flak = 0;
   public String flakParticles = "largesmoke";
   public boolean setEntitiesOnFire = false;
   public float livingProximityTrigger = -1.0F;
   public float driveableProximityTrigger = -1.0F;
   public float damageToTriggerer = 0.0F;
   public int primeDelay = 0;
   public int explodeParticles = 0;
   public String explodeParticleType = "largesmoke";
   public EnumWeaponType weaponType;
   public String hitSound;
   public float hitSoundRange;
   public boolean hitSoundEnable;
   public boolean entityHitSoundEnable;
   public boolean hasLight;
   public float penetratingPower;
   public boolean lockOnToPlanes;
   public boolean lockOnToVehicles;
   public boolean lockOnToMechas;
   public boolean lockOnToPlayers;
   public boolean lockOnToLivings;
   public float maxLockOnAngle;
   public float lockOnForce;
   public int maxDegreeOfMissile;
   public int tickStartHoming;
   public boolean enableSACLOS;
   public int maxDegreeOfSACLOS;
   public int maxRangeOfMissile;
   public boolean manualGuidance;
   public int lockOnFuse;
   public ArrayList<PotionEffect> hitEffects;
   public int numBullets;
   public float bulletSpread;
   public float dragInAir;
   public float dragInWater;
   public boolean canSpotEntityDriveable;
   public int maxRange;
   public boolean shootForSettingPos;
   public int shootForSettingPosHeight;
   public boolean isDoTopAttack;
   public int smokeTime;
   public String smokeParticleType;
   public ArrayList<PotionEffect> smokeEffects;
   public float smokeRadius;
   public boolean TVguide;
   public boolean VLS;
   public int VLSTime;
   public boolean fixedDirection;
   public float turnRadius;
   public String boostPhaseParticle;
   public float trackPhaseSpeed;
   public float trackPhaseTurn;
   public boolean CIWSable;
   public boolean torpedo;
   public static List<BulletType> bullets = new ArrayList();

   public BulletType(TypeFile file) {
      super(file);
      this.weaponType = EnumWeaponType.NONE;
      this.hitSoundEnable = false;
      this.entityHitSoundEnable = false;
      this.hasLight = false;
      this.penetratingPower = 1.0F;
      this.lockOnToPlanes = false;
      this.lockOnToVehicles = false;
      this.lockOnToMechas = false;
      this.lockOnToPlayers = false;
      this.lockOnToLivings = false;
      this.maxLockOnAngle = 45.0F;
      this.lockOnForce = 1.0F;
      this.maxDegreeOfMissile = 70;
      this.tickStartHoming = 5;
      this.enableSACLOS = false;
      this.maxDegreeOfSACLOS = 5;
      this.maxRangeOfMissile = 300;
      this.manualGuidance = false;
      this.lockOnFuse = 10;
      this.hitEffects = new ArrayList();
      this.numBullets = -1;
      this.bulletSpread = -1.0F;
      this.dragInAir = 0.99F;
      this.dragInWater = 0.8F;
      this.canSpotEntityDriveable = false;
      this.maxRange = -1;
      this.shootForSettingPos = false;
      this.shootForSettingPosHeight = 100;
      this.isDoTopAttack = false;
      this.smokeTime = 0;
      this.smokeParticleType = "explode";
      this.smokeEffects = new ArrayList();
      this.smokeRadius = 5.0F;
      this.TVguide = true;
      this.VLS = false;
      this.VLSTime = 0;
      this.fixedDirection = false;
      this.turnRadius = 3.0F;
      this.trackPhaseSpeed = 2.0F;
      this.trackPhaseTurn = 0.2F;
      this.CIWSable = false;
      this.torpedo = false;
      this.texture = "defaultBullet";
      bullets.add(this);
   }

   protected void read(String[] split, TypeFile file) {
      super.read(split, file);

      try {
         if (split[0].equals("FlakParticles")) {
            this.flak = Integer.parseInt(split[1]);
         } else if (split[0].equals("FlakParticleType")) {
            this.flakParticles = split[1];
         } else if (split[0].equals("SetEntitiesOnFire")) {
            this.setEntitiesOnFire = Boolean.parseBoolean(split[1]);
         } else if (split[0].equals("CIWSable")) {
            this.CIWSable = Boolean.parseBoolean(split[1]);
         } else if (split[0].equals("HitSoundEnable")) {
            this.hitSoundEnable = Boolean.parseBoolean(split[1]);
         } else if (split[0].equals("EntityHitSoundEnable")) {
            this.entityHitSoundEnable = Boolean.parseBoolean(split[1]);
         } else if (split[0].equals("HitSound")) {
            this.hitSound = split[1];
            FlansMod.proxy.loadSound(this.contentPack, "sound", split[1]);
         } else if (split[0].equals("HitSoundRange")) {
            this.hitSoundRange = Float.parseFloat(split[1]);
         } else if (split[0].equals("Penetrates")) {
            this.penetratingPower = Boolean.parseBoolean(split[1].toLowerCase()) ? 1.0F : 0.25F;
         } else if (!split[0].equals("Penetration") && !split[0].equals("PenetratingPower")) {
            if (split[0].equals("DragInAir")) {
               this.dragInAir = Float.parseFloat(split[1]);
               this.dragInAir = this.dragInAir < 0.0F ? 0.0F : (this.dragInAir > 1.0F ? 1.0F : this.dragInAir);
            } else if (split[0].equals("DragInWater")) {
               this.dragInWater = Float.parseFloat(split[1]);
               this.dragInWater = this.dragInWater < 0.0F ? 0.0F : (this.dragInWater > 1.0F ? 1.0F : this.dragInWater);
            } else if (split[0].equals("NumBullets")) {
               this.numBullets = Integer.parseInt(split[1]);
            } else if (!split[0].equals("Accuracy") && !split[0].equals("Spread")) {
               if (split[0].equals("LivingProximityTrigger")) {
                  this.livingProximityTrigger = Float.parseFloat(split[1]);
               } else if (split[0].equals("VehicleProximityTrigger")) {
                  this.driveableProximityTrigger = Float.parseFloat(split[1]);
               } else if (split[0].equals("DamageToTriggerer")) {
                  this.damageToTriggerer = Float.parseFloat(split[1]);
               } else if (!split[0].equals("PrimeDelay") && !split[0].equals("TriggerDelay")) {
                  if (split[0].equals("NumExplodeParticles")) {
                     this.explodeParticles = Integer.parseInt(split[1]);
                  } else if (split[0].equals("ExplodeParticles")) {
                     this.explodeParticleType = split[1];
                  } else if (split[0].equals("SmokeTime")) {
                     this.smokeTime = Integer.parseInt(split[1]);
                  } else if (split[0].equals("SmokeParticles")) {
                     this.smokeParticleType = split[1];
                  } else if (split[0].equals("SmokeEffect")) {
                     this.smokeEffects.add(getPotionEffect(split));
                  } else if (split[0].equals("SmokeRadius")) {
                     this.smokeRadius = Float.parseFloat(split[1]);
                  } else if (!split[0].equals("VLS") && !split[0].equals("HasDeadZone")) {
                     if (!split[0].equals("VLSTime") && !split[0].equals("DeadZoneTime")) {
                        if (split[0].equals("FixedTrackDirection")) {
                           this.fixedDirection = Boolean.parseBoolean(split[1]);
                        } else if (split[0].equals("GuidedTurnRadius")) {
                           this.turnRadius = Float.parseFloat(split[1]);
                        } else if (split[0].equals("GuidedPhaseSpeed")) {
                           this.trackPhaseSpeed = Float.parseFloat(split[1]);
                        } else if (split[0].equals("GuidedPhaseTurnSpeed")) {
                           this.trackPhaseTurn = Float.parseFloat(split[1]);
                        } else if (split[0].equals("BoostParticle")) {
                           this.boostPhaseParticle = split[1];
                        } else if (split[0].equals("Torpedo")) {
                           this.torpedo = Boolean.parseBoolean(split[1]);
                        } else if (split[0].equals("Bomb")) {
                           this.weaponType = EnumWeaponType.BOMB;
                        } else if (split[0].equals("Shell")) {
                           this.weaponType = EnumWeaponType.SHELL;
                        } else if (split[0].equals("Missile")) {
                           this.weaponType = EnumWeaponType.MISSILE;
                        } else if (split[0].equals("WeaponType")) {
                           this.weaponType = EnumWeaponType.valueOf(split[1].toUpperCase());
                        } else if (split[0].equals("HasLight")) {
                           this.hasLight = Boolean.parseBoolean(split[1].toLowerCase());
                        } else if (split[0].equals("LockOnToDriveables")) {
                           this.lockOnToPlanes = this.lockOnToVehicles = this.lockOnToMechas = Boolean.parseBoolean(split[1].toLowerCase());
                        } else if (split[0].equals("LockOnToVehicles")) {
                           this.lockOnToVehicles = Boolean.parseBoolean(split[1].toLowerCase());
                        } else if (split[0].equals("LockOnToPlanes")) {
                           this.lockOnToPlanes = Boolean.parseBoolean(split[1].toLowerCase());
                        } else if (split[0].equals("LockOnToMechas")) {
                           this.lockOnToMechas = Boolean.parseBoolean(split[1].toLowerCase());
                        } else if (split[0].equals("LockOnToPlayers")) {
                           this.lockOnToPlayers = Boolean.parseBoolean(split[1].toLowerCase());
                        } else if (split[0].equals("LockOnToLivings")) {
                           this.lockOnToLivings = Boolean.parseBoolean(split[1].toLowerCase());
                        } else if (split[0].equals("MaxLockOnAngle")) {
                           this.maxLockOnAngle = Float.parseFloat(split[1]);
                        } else if (!split[0].equals("LockOnForce") && !split[0].equals("TurningForce")) {
                           if (split[0].equals("MaxDegreeOfLockOnMissile")) {
                              this.maxDegreeOfMissile = Integer.parseInt(split[1]);
                           } else if (split[0].equals("TickStartHoming")) {
                              this.tickStartHoming = Integer.parseInt(split[1]);
                           } else if (split[0].equals("EnableSACLOS")) {
                              this.enableSACLOS = Boolean.parseBoolean(split[1]);
                           } else if (split[0].equals("EnableSACLOS")) {
                              this.enableSACLOS = Boolean.parseBoolean(split[1]);
                           } else if (split[0].equals("MaxRangeOfMissile")) {
                              this.maxRangeOfMissile = Integer.parseInt(split[1]);
                           } else if (split[0].equals("CanSpotEntityDriveable")) {
                              this.canSpotEntityDriveable = Boolean.parseBoolean(split[1].toLowerCase());
                           } else if (split[0].equals("ShootForSettingPos")) {
                              this.shootForSettingPos = Boolean.parseBoolean(split[1].toLowerCase());
                           } else if (split[0].equals("ShootForSettingPosHeight")) {
                              this.shootForSettingPosHeight = Integer.parseInt(split[1]);
                           } else if (split[0].equals("IsDoTopAttack")) {
                              this.isDoTopAttack = Boolean.parseBoolean(split[1].toLowerCase());
                           } else if (split[0].equals("PotionEffect")) {
                              this.hitEffects.add(getPotionEffect(split));
                           } else if (split[0].equals("ManualGuidance")) {
                              this.manualGuidance = Boolean.parseBoolean(split[1].toLowerCase());
                           } else if (split[0].equals("LockOnFuse")) {
                              this.lockOnFuse = Integer.parseInt(split[1]);
                           } else if (split[0].equals("MaxRange")) {
                              this.maxRange = Integer.parseInt(split[1]);
                           }
                        } else {
                           this.lockOnForce = Float.parseFloat(split[1]);
                        }
                     } else {
                        this.VLSTime = Integer.parseInt(split[1]);
                     }
                  } else {
                     this.VLS = Boolean.parseBoolean(split[1]);
                  }
               } else {
                  this.primeDelay = Integer.parseInt(split[1]);
               }
            } else {
               this.bulletSpread = Float.parseFloat(split[1]);
            }
         } else {
            this.penetratingPower = Float.parseFloat(split[1]);
         }
      } catch (Exception var4) {
         System.out.println("Reading bullet file failed.");
         if (FlansMod.printStackTrace) {
            var4.printStackTrace();
         }
      }

   }

   public static BulletType getBullet(String s) {
      Iterator var1 = bullets.iterator();

      BulletType bullet;
      do {
         if (!var1.hasNext()) {
            return null;
         }

         bullet = (BulletType)var1.next();
      } while(!bullet.shortName.equals(s));

      return bullet;
   }

   public static BulletType getBullet(Item item) {
      Iterator var1 = bullets.iterator();

      BulletType bullet;
      do {
         if (!var1.hasNext()) {
            return null;
         }

         bullet = (BulletType)var1.next();
      } while(bullet.item != item);

      return bullet;
   }

   public void reloadModel() {
      this.model = (ModelBase)FlansMod.proxy.loadModel(this.modelString, this.shortName, ModelBase.class);
   }
}
