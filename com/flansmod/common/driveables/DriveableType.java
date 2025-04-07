package com.flansmod.common.driveables;

import com.flansmod.client.model.ModelDriveable;
import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.collisions.CollisionShapeBox;
import com.flansmod.common.guns.BulletType;
import com.flansmod.common.guns.EnumFireMode;
import com.flansmod.common.paintjob.PaintableType;
import com.flansmod.common.parts.PartType;
import com.flansmod.common.types.TypeFile;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;

public class DriveableType extends PaintableType {
   @SideOnly(Side.CLIENT)
   public ModelDriveable model;
   public String overlay = null;
   public boolean hasScope = false;
   public HashMap<EnumDriveablePart, CollisionBox> health = new HashMap();
   public HashMap<EnumDriveablePart, ItemStack[]> partwiseRecipe = new HashMap();
   public ArrayList<ItemStack> driveableRecipe = new ArrayList();
   public boolean acceptAllAmmo = true;
   public List<BulletType> ammo = new ArrayList();
   public boolean harvestBlocks = false;
   public ArrayList<Material> materialsHarvested = new ArrayList();
   public boolean collectHarvest = false;
   public boolean dropHarvest = false;
   public boolean needsThrottle = false;
   public Vector3f harvestBoxSize = new Vector3f(0.0F, 0.0F, 0.0F);
   public Vector3f harvestBoxPos = new Vector3f(0.0F, 0.0F, 0.0F);
   public int reloadSoundTick = 15214541;
   public float fallDamageFactor = 1.0F;
   public String Gunsight = null;
   public float gunsightZoom = 1.0F;
   public boolean nightScope = false;
   public boolean unlimitedOxygen = false;
   public boolean radarVisible = true;
   public boolean hasRadar = false;
   public boolean hasPlaneRadar = false;
   public float radarRange = 69.0F;
   public int radarPositionOffset = 0;
   public int radarRefreshDelay = 0;
   public boolean showReload = true;
   public boolean solid = false;
   public EnumWeaponType primary;
   public EnumWeaponType secondary;
   public boolean alternatePrimary;
   public boolean alternateSecondary;
   public int shootDelayPrimary;
   public int shootDelaySecondary;
   public EnumFireMode modePrimary;
   public EnumFireMode modeSecondary;
   public String shootSoundPrimary;
   public String shootSoundSecondary;
   public String shootReloadSound;
   public ArrayList<ShootPoint> shootPointsPrimary;
   public ArrayList<ShootPoint> shootPointsSecondary;
   public ArrayList<PilotGun> pilotGuns;
   public int reloadTimePrimary;
   public int reloadTimeSecondary;
   public String reloadSoundPrimary;
   public String reloadSoundSecondary;
   public int placeTimePrimary;
   public int placeTimeSecondary;
   public String placeSoundPrimary;
   public String placeSoundSecondary;
   public int numPassengers;
   public Seat[] seats;
   public int numPassengerGunners;
   public float vehicleGunModelScale;
   public ArrayList<DriveableType.ShootParticle> shootParticlesPrimary;
   public ArrayList<DriveableType.ShootParticle> shootParticlesSecondary;
   public int numCargoSlots;
   public int numBombSlots;
   public int numMissileSlots;
   public int fuelTankSize;
   public float yOffset;
   public float cameraDistance;
   public ArrayList<DriveableType.ParticleEmitter> emitters;
   public float maxThrottle;
   public float maxNegativeThrottle;
   public float ClutchBrake;
   public Vector3f turretOrigin;
   public Vector3f turretOriginOffset;
   public DriveablePosition[] wheelPositions;
   public float wheelSpringStrength;
   public float wheelStepHeight;
   public boolean canRoll;
   public ArrayList<DriveablePosition> collisionPoints;
   public float drag;
   public boolean floatOnWater;
   public boolean placeableOnLand;
   public boolean placeableOnWater;
   public boolean placeableOnSponge;
   public boolean placeableOnPumpkin;
   public float buoyancy;
   public float floatOffset;
   public float bulletDetectionRadius;
   public boolean onRadar;
   public int animFrames;
   public int startSoundRange;
   public String startSound;
   public int startSoundLength;
   public int engineSoundRange;
   public String engineSound;
   public int engineSoundLength;
   public int backSoundRange;
   public String idleSound;
   public int idleSoundLength;
   public String backSound;
   public int backSoundLength;
   public boolean collisionDamageEnable;
   public boolean pushOnCollision;
   public float collisionDamageThrottle;
   public float collisionDamageTimes;
   public boolean enableReloadTime;
   public boolean canMountEntity;
   public boolean inshallah;
   public float bulletSpread;
   public float bulletSpeed;
   public boolean rangingGun;
   public boolean isExplosionWhenDestroyed;
   public boolean nuclearDeath;
   public boolean bigDeath;
   public boolean Death;
   public float isExplosionWhenDestroyedRadius;
   public String lockedOnSound;
   public int soundTime;
   public int canLockOnAngle;
   public int lockOnSoundTime;
   public String lockOnSound;
   public int maxRangeLockOn;
   public int lockedOnSoundRange;
   public String lockingOnSound;
   public boolean lockOnToPlanes;
   public boolean lockOnToVehicles;
   public boolean lockOnToMechas;
   public boolean lockOnToPlayers;
   public boolean lockOnToLivings;
   public boolean hasFlare;
   public int flareDelay;
   public String flareSound;
   public int timeFlareUsing;
   public int radarDetectableAltitude;
   public boolean stealth;
   public float recoilDist;
   public float recoilTime;
   public boolean fixedPrimaryFire;
   public Vector3f primaryFireAngle;
   public boolean fixedSecondaryFire;
   public Vector3f secondaryFireAngle;
   public float gunLength;
   public boolean setPlayerInvisible;
   public boolean invinciblePilotType;
   public float maxThrottleInWater;
   public ArrayList<Vector3f> leftTrackPoints;
   public ArrayList<Vector3f> rightTrackPoints;
   public float trackLinkLength;
   public boolean IT1;
   public static ArrayList<DriveableType> types = new ArrayList();
   public ArrayList<CollisionShapeBox> collisionBox;
   public boolean fancyCollision;
   public CollisionShapeBox colbox;
   public float maxDepth;
   public float maxOxygen;
   public float oxygen;
   public boolean canDive;

   public DriveableType(TypeFile file) {
      super(file);
      this.primary = EnumWeaponType.NONE;
      this.secondary = EnumWeaponType.NONE;
      this.alternatePrimary = false;
      this.alternateSecondary = false;
      this.shootDelayPrimary = 1;
      this.shootDelaySecondary = 1;
      this.modePrimary = EnumFireMode.FULLAUTO;
      this.modeSecondary = EnumFireMode.FULLAUTO;
      this.shootPointsPrimary = new ArrayList();
      this.shootPointsSecondary = new ArrayList();
      this.pilotGuns = new ArrayList();
      this.reloadTimePrimary = 0;
      this.reloadTimeSecondary = 0;
      this.reloadSoundPrimary = "";
      this.reloadSoundSecondary = "";
      this.placeTimePrimary = 5;
      this.placeTimeSecondary = 5;
      this.placeSoundPrimary = "";
      this.placeSoundSecondary = "";
      this.numPassengers = 0;
      this.numPassengerGunners = 0;
      this.vehicleGunModelScale = 1.0F;
      this.shootParticlesPrimary = new ArrayList();
      this.shootParticlesSecondary = new ArrayList();
      this.fuelTankSize = 100;
      this.yOffset = 0.625F;
      this.cameraDistance = 5.0F;
      this.emitters = new ArrayList();
      this.maxThrottle = 1.0F;
      this.maxNegativeThrottle = 0.0F;
      this.ClutchBrake = 0.0F;
      this.turretOrigin = new Vector3f();
      this.turretOriginOffset = new Vector3f();
      this.wheelPositions = new DriveablePosition[0];
      this.wheelSpringStrength = 0.5F;
      this.wheelStepHeight = 1.0F;
      this.canRoll = true;
      this.collisionPoints = new ArrayList();
      this.drag = 1.0F;
      this.floatOnWater = false;
      this.placeableOnLand = true;
      this.placeableOnWater = false;
      this.placeableOnSponge = false;
      this.placeableOnPumpkin = false;
      this.buoyancy = 0.0165F;
      this.floatOffset = 0.0F;
      this.bulletDetectionRadius = 5.0F;
      this.onRadar = false;
      this.animFrames = 2;
      this.startSoundRange = 50;
      this.startSound = "";
      this.engineSoundRange = 50;
      this.engineSound = "";
      this.backSoundRange = 50;
      this.idleSound = "";
      this.idleSoundLength = 50;
      this.backSound = "";
      this.collisionDamageEnable = false;
      this.pushOnCollision = true;
      this.collisionDamageThrottle = 0.0F;
      this.collisionDamageTimes = 0.0F;
      this.enableReloadTime = false;
      this.canMountEntity = false;
      this.inshallah = false;
      this.bulletSpread = 0.0F;
      this.bulletSpeed = 3.0F;
      this.rangingGun = false;
      this.isExplosionWhenDestroyed = false;
      this.nuclearDeath = false;
      this.bigDeath = false;
      this.Death = false;
      this.isExplosionWhenDestroyedRadius = 0.0F;
      this.lockedOnSound = "";
      this.soundTime = 0;
      this.canLockOnAngle = 10;
      this.lockOnSoundTime = 60;
      this.lockOnSound = "";
      this.maxRangeLockOn = 500;
      this.lockedOnSoundRange = 5;
      this.lockingOnSound = "";
      this.lockOnToPlanes = false;
      this.lockOnToVehicles = false;
      this.lockOnToMechas = false;
      this.lockOnToPlayers = false;
      this.lockOnToLivings = false;
      this.hasFlare = false;
      this.flareDelay = 200;
      this.flareSound = "";
      this.timeFlareUsing = 1;
      this.radarDetectableAltitude = -1;
      this.stealth = false;
      this.recoilDist = 5.0F;
      this.recoilTime = 5.0F;
      this.fixedPrimaryFire = false;
      this.primaryFireAngle = new Vector3f(0.0F, 0.0F, 0.0F);
      this.fixedSecondaryFire = false;
      this.secondaryFireAngle = new Vector3f(0.0F, 0.0F, 0.0F);
      this.gunLength = 0.0F;
      this.setPlayerInvisible = false;
      this.invinciblePilotType = true;
      this.maxThrottleInWater = 0.5F;
      this.leftTrackPoints = new ArrayList();
      this.rightTrackPoints = new ArrayList();
      this.trackLinkLength = 0.0F;
      this.IT1 = false;
      this.collisionBox = new ArrayList();
      this.fancyCollision = false;
      this.maxDepth = 40.0F;
      this.maxOxygen = 9001.0F;
      this.oxygen = 9001.0F;
      this.canDive = false;
   }

   public void preRead(TypeFile file) {
      super.preRead(file);
      Iterator var2 = file.lines.iterator();

      String line;
      String[] split;
      while(var2.hasNext()) {
         line = (String)var2.next();
         if (line == null) {
            break;
         }

         if (!line.startsWith("//")) {
            split = line.split(" ");
            if (split.length >= 2 && split[0].equals("Passengers")) {
               this.numPassengers = Integer.parseInt(split[1]);
               this.seats = new Seat[this.numPassengers + 1];
               break;
            }
         }
      }

      var2 = file.lines.iterator();

      while(var2.hasNext()) {
         line = (String)var2.next();
         if (line == null) {
            break;
         }

         if (!line.startsWith("//")) {
            split = line.split(" ");
            if (split.length >= 2 && split[0].equals("NumWheels")) {
               this.wheelPositions = new DriveablePosition[Integer.parseInt(split[1])];
               break;
            }
         }
      }

      types.add(this);
   }

   public void postRead(TypeFile file) {
      super.postRead(file);
   }

   protected void read(String[] split, TypeFile file) {
      super.read(split, file);

      String[] gun;
      int amount;
      String itemName;
      try {
         if (split[0].equals("VehicleGunModelScale")) {
            this.vehicleGunModelScale = Float.parseFloat(split[1]);
         }

         if (FMLCommonHandler.instance().getSide().isClient() && split[0].equals("Model")) {
            this.model = (ModelDriveable)FlansMod.proxy.loadModel(split[1], this.shortName, ModelDriveable.class);
         } else if (split[0].equals("VehicleGunReloadTick")) {
            this.reloadSoundTick = Integer.parseInt(split[1]);
         } else if (split[0].equals("Texture")) {
            this.texture = split[1];
         } else if (split[0].equals("IsExplosionWhenDestroyed")) {
            this.isExplosionWhenDestroyed = Boolean.parseBoolean(split[1]);
         } else if (split[0].equals("isExplosionWhenDestroyedRadius")) {
            this.isExplosionWhenDestroyedRadius = Float.parseFloat(split[1]);
         } else if (split[0].equals("FallDamageFactor")) {
            this.fallDamageFactor = Float.parseFloat(split[1]);
         } else if (split[0].equals("MaxThrottle")) {
            this.maxThrottle = Float.parseFloat(split[1]);
         } else if (split[0].equals("MaxNegativeThrottle")) {
            this.maxNegativeThrottle = Float.parseFloat(split[1]);
         } else if (split[0].equals("ClutchBrake")) {
            this.ClutchBrake = Float.parseFloat(split[1]);
         } else if (split[0].equals("MaxThrottleInWater")) {
            this.maxThrottleInWater = Float.parseFloat(split[1]);
         } else if (split[0].equals("MaxDepth")) {
            this.maxDepth = (float)Integer.parseInt(split[1]);
         } else if (split[0].equals("oxygen")) {
            this.oxygen = (float)Integer.parseInt(split[1]);
         } else if (split[0].equals("maxOxygen")) {
            this.maxOxygen = (float)Integer.parseInt(split[1]);
         }

         if (split[0].equals("Gunsight")) {
            this.overlay = split[1];
         } else if (split[0].equals("hasScope")) {
            this.hasScope = Boolean.parseBoolean(split[1]);
         } else if (split[0].equals("nightScope")) {
            this.nightScope = Boolean.parseBoolean(split[1]);
         } else if (split[0].equals("gunsightZoom")) {
            this.gunsightZoom = Float.parseFloat(split[1]);
         } else if (split[0].equals("Drag")) {
            this.drag = Float.parseFloat(split[1]);
         } else if (split[0].equals("TurretOrigin")) {
            this.turretOrigin = new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F);
         } else if (split[0].equals("TurretOriginOffset")) {
            this.turretOriginOffset = new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F);
         } else if (!split[0].equals("CollisionPoint") && !split[0].equals("AddCollisionPoint")) {
            if (split[0].equals("CollisionDamageEnable")) {
               this.collisionDamageEnable = Boolean.parseBoolean(split[1]);
            } else if (split[0].equals("unlimitedOxygen")) {
               this.unlimitedOxygen = Boolean.parseBoolean(split[1]);
            } else if (split[0].equals("CollisionDamageThrottle")) {
               this.collisionDamageThrottle = Float.parseFloat(split[1]);
            } else if (split[0].equals("CollisionDamageTimes")) {
               this.collisionDamageTimes = Float.parseFloat(split[1]);
            } else if (split[0].equals("CanLockAngle")) {
               this.canLockOnAngle = Integer.parseInt(split[1]);
            } else if (split[0].equals("LockOnSoundTime")) {
               this.lockOnSoundTime = Integer.parseInt(split[1]);
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
            } else if (split[0].equals("LockedOnSoundRange")) {
               this.lockedOnSoundRange = Integer.parseInt(split[1]);
            } else if (split[0].equals("CanRoll")) {
               this.canRoll = Boolean.parseBoolean(split[1]);
            }
         } else {
            this.collisionPoints.add(new DriveablePosition(split));
         }

         if (split[0].equals("HasFlare")) {
            this.hasFlare = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("FlareDelay")) {
            this.flareDelay = Integer.parseInt(split[1]);
            if (this.flareDelay <= 0) {
               this.flareDelay = 1;
            }
         }

         if (split[0].equals("TimeFlareUsing")) {
            this.timeFlareUsing = Integer.parseInt(split[1]);
            if (this.timeFlareUsing <= 0) {
               this.timeFlareUsing = 1;
            }
         }

         if (split[0].equals("nuclearDeath")) {
            this.nuclearDeath = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("bigDeath")) {
            this.bigDeath = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("Death")) {
            this.Death = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("radarVisible")) {
            this.radarVisible = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("hasRadar")) {
            this.hasRadar = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("hasPlaneRadar")) {
            this.hasPlaneRadar = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("radarRange")) {
            this.radarRange = Float.parseFloat(split[1]);
         }

         if (split[0].equals("radarPositionOffset")) {
            this.radarPositionOffset = Integer.parseInt(split[1]);
         }

         if (split[0].equals("radarRefreshDelay")) {
            this.radarRefreshDelay = Integer.parseInt(split[1]);
         }

         if (split[0].equals("solid")) {
            this.solid = Boolean.parseBoolean(split[1]);
         } else if (split[0].equals("showReload")) {
            this.showReload = Boolean.parseBoolean(split[1]);
         } else if (split[0].equals("PlaceableOnLand")) {
            this.placeableOnLand = Boolean.parseBoolean(split[1]);
         } else if (split[0].equals("PlaceableOnWater")) {
            this.placeableOnWater = Boolean.parseBoolean(split[1]);
         } else if (split[0].equals("PlaceableOnSponge")) {
            this.placeableOnSponge = Boolean.parseBoolean(split[1]);
         } else if (split[0].equals("placeableOnPumpkin")) {
            this.placeableOnPumpkin = Boolean.parseBoolean(split[1]);
         } else if (split[0].equals("FloatOnWater")) {
            this.floatOnWater = Boolean.parseBoolean(split[1]);
         } else if (split[0].equals("Boat")) {
            this.placeableOnLand = false;
            this.placeableOnWater = true;
            this.floatOnWater = true;
            this.wheelStepHeight = 0.0F;
         } else if (split[0].equals("Buoyancy")) {
            this.buoyancy = Float.parseFloat(split[1]);
         } else if (split[0].equals("FloatOffset")) {
            this.floatOffset = Float.parseFloat(split[1]);
         } else if (split[0].equals("CanMountEntity")) {
            this.canMountEntity = Boolean.parseBoolean(split[1]);
         } else if (split[0].equals("InshaAllah")) {
            this.inshallah = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("needsThrottle")) {
            this.needsThrottle = Boolean.parseBoolean(split[1].toLowerCase());
         }

         Vector3f offPos;
         ShootPoint sPoint;
         if (split[0].equals("Gunsight")) {
            this.Gunsight = split[1];
         } else if (!split[0].equals("Wheel") && !split[0].equals("WheelPosition")) {
            if (!split[0].equals("WheelRadius") && !split[0].equals("WheelStepHeight")) {
               if (!split[0].equals("WheelSpringStrength") && !split[0].equals("SpringStrength")) {
                  if (split[0].equals("TrackFrames")) {
                     this.animFrames = Integer.parseInt(split[1]) - 1;
                  } else if (split[0].equals("Harvester")) {
                     this.harvestBlocks = Boolean.parseBoolean(split[1]);
                  } else if (split[0].equals("CollectHarvest")) {
                     this.collectHarvest = Boolean.parseBoolean(split[1]);
                  } else if (split[0].equals("DropHarvest")) {
                     this.dropHarvest = Boolean.parseBoolean(split[1]);
                  } else if (split[0].equals("HarvestBox")) {
                     this.harvestBoxSize = new Vector3f(split[1], this.shortName);
                     this.harvestBoxPos = new Vector3f(split[2], this.shortName);
                  } else if (split[0].equals("HarvestMaterial")) {
                     this.materialsHarvested.add(getMaterial(split[1]));
                  } else if (split[0].equals("HarvestToolType")) {
                     if (split[1].equals("Axe")) {
                        this.materialsHarvested.add(Material.field_151575_d);
                        this.materialsHarvested.add(Material.field_151585_k);
                        this.materialsHarvested.add(Material.field_151582_l);
                     } else if (!split[1].equals("Pickaxe") && !split[1].equals("Drill")) {
                        if (!split[1].equals("Spade") && !split[1].equals("Shovel") && !split[1].equals("Excavator")) {
                           if (!split[1].equals("Hoe") && !split[1].equals("Combine")) {
                              if (split[1].equals("Tank")) {
                                 this.materialsHarvested.add(Material.field_151584_j);
                                 this.materialsHarvested.add(Material.field_151570_A);
                                 this.materialsHarvested.add(Material.field_151575_d);
                                 this.materialsHarvested.add(Material.field_151585_k);
                              }
                           } else {
                              this.materialsHarvested.add(Material.field_151585_k);
                              this.materialsHarvested.add(Material.field_151584_j);
                              this.materialsHarvested.add(Material.field_151582_l);
                              this.materialsHarvested.add(Material.field_151570_A);
                              this.materialsHarvested.add(Material.field_151572_C);
                           }
                        } else {
                           this.materialsHarvested.add(Material.field_151578_c);
                           this.materialsHarvested.add(Material.field_151577_b);
                           this.materialsHarvested.add(Material.field_151595_p);
                           this.materialsHarvested.add(Material.field_151597_y);
                           this.materialsHarvested.add(Material.field_151571_B);
                        }
                     } else {
                        this.materialsHarvested.add(Material.field_151573_f);
                        this.materialsHarvested.add(Material.field_151574_g);
                        this.materialsHarvested.add(Material.field_151576_e);
                     }
                  } else if (split[0].equals("CargoSlots")) {
                     this.numCargoSlots = Integer.parseInt(split[1]);
                  } else if (!split[0].equals("BombSlots") && !split[0].equals("MineSlots")) {
                     if (!split[0].equals("MissileSlots") && !split[0].equals("ShellSlots")) {
                        if (split[0].equals("FuelTankSize")) {
                           this.fuelTankSize = Integer.parseInt(split[1]);
                        } else if (split[0].equals("BulletDetection")) {
                           this.bulletDetectionRadius = (float)Integer.parseInt(split[1]);
                        } else if (split[0].equals("AddAmmo")) {
                           this.ammo.add(BulletType.getBullet(split[1]));
                        } else if (!split[0].equals("AllowAllAmmo") && !split[0].equals("AcceptAllAmmo")) {
                           if (split[0].equals("Primary")) {
                              this.primary = EnumWeaponType.valueOf(split[1].toUpperCase());
                           } else if (split[0].equals("Secondary")) {
                              this.secondary = EnumWeaponType.valueOf(split[1].toUpperCase());
                           } else if (split[0].equals("ShootDelayPrimary")) {
                              this.shootDelayPrimary = Integer.parseInt(split[1]);
                           } else if (split[0].equals("ShootDelaySecondary")) {
                              this.shootDelaySecondary = Integer.parseInt(split[1]);
                           } else if (split[0].equals("PlaceTimePrimary")) {
                              this.placeTimePrimary = Integer.parseInt(split[1]);
                           } else if (split[0].equals("PlaceTimeSecondary")) {
                              this.placeTimeSecondary = Integer.parseInt(split[1]);
                           } else if (split[0].equals("ReloadTimePrimary")) {
                              this.reloadTimePrimary = Integer.parseInt(split[1]);
                           } else if (split[0].equals("ReloadTimeSecondary")) {
                              this.reloadTimeSecondary = Integer.parseInt(split[1]);
                           } else if (split[0].equals("AlternatePrimary")) {
                              this.alternatePrimary = Boolean.parseBoolean(split[1]);
                           } else if (split[0].equals("AlternateSecondary")) {
                              this.alternateSecondary = Boolean.parseBoolean(split[1]);
                           } else if (split[0].equals("ModePrimary")) {
                              this.modePrimary = EnumFireMode.valueOf(split[1].toUpperCase());
                           } else if (split[0].equals("ModeSecondary")) {
                              this.modeSecondary = EnumFireMode.valueOf(split[1].toUpperCase());
                           } else if (split[0].equals("BulletSpeed")) {
                              this.bulletSpeed = Float.parseFloat(split[1]);
                           } else if (split[0].equals("BulletSpread")) {
                              this.bulletSpread = Float.parseFloat(split[1]);
                           } else if (split[0].equals("RangingGun")) {
                              this.rangingGun = Boolean.parseBoolean(split[1]);
                           } else if (split[0].equals("GunLength")) {
                              this.gunLength = Float.parseFloat(split[1]);
                           } else if (split[0].equals("RecoilDistance")) {
                              this.recoilDist = Float.parseFloat(split[1]);
                           } else if (split[0].equals("RecoilTime")) {
                              this.recoilTime = Float.parseFloat(split[1]);
                           } else {
                              DriveablePosition rootPos;
                              if (split[0].equals("ShootPointPrimary")) {
                                 if (split.length == 9) {
                                    gun = new String[]{split[0], split[1], split[2], split[3], split[4], split[5]};
                                    offPos = new Vector3f(Float.parseFloat(split[6]) / 16.0F, Float.parseFloat(split[7]) / 16.0F, Float.parseFloat(split[8]) / 16.0F);
                                 } else if (split.length == 8) {
                                    gun = new String[]{split[0], split[1], split[2], split[3], split[4]};
                                    offPos = new Vector3f(Float.parseFloat(split[5]) / 16.0F, Float.parseFloat(split[6]) / 16.0F, Float.parseFloat(split[7]) / 16.0F);
                                 } else {
                                    gun = split;
                                    offPos = new Vector3f(0.0F, 0.0F, 0.0F);
                                 }

                                 rootPos = this.getShootPoint(gun);
                                 sPoint = new ShootPoint(rootPos, offPos);
                                 this.shootPointsPrimary.add(sPoint);
                                 if (rootPos instanceof PilotGun) {
                                    this.pilotGuns.add((PilotGun)sPoint.rootPos);
                                 }
                              } else if (split[0].equals("ShootPointSecondary")) {
                                 if (split.length == 9) {
                                    gun = new String[]{split[0], split[1], split[2], split[3], split[4], split[5]};
                                    offPos = new Vector3f(Float.parseFloat(split[6]) / 16.0F, Float.parseFloat(split[7]) / 16.0F, Float.parseFloat(split[8]) / 16.0F);
                                 } else if (split.length == 8) {
                                    gun = new String[]{split[0], split[1], split[2], split[3], split[4]};
                                    offPos = new Vector3f(Float.parseFloat(split[5]) / 16.0F, Float.parseFloat(split[6]) / 16.0F, Float.parseFloat(split[7]) / 16.0F);
                                 } else {
                                    gun = split;
                                    offPos = new Vector3f(0.0F, 0.0F, 0.0F);
                                 }

                                 rootPos = this.getShootPoint(gun);
                                 sPoint = new ShootPoint(rootPos, offPos);
                                 this.shootPointsSecondary.add(sPoint);
                                 if (rootPos instanceof PilotGun) {
                                    this.pilotGuns.add((PilotGun)sPoint.rootPos);
                                 }
                              } else if (split[0].equals("EnableReloadTime")) {
                                 this.enableReloadTime = Boolean.parseBoolean(split[1]);
                              } else if (split[0].equals("ShootParticlesPrimary")) {
                                 this.shootParticlesPrimary.add(new DriveableType.ShootParticle(split[1], Float.valueOf(split[2]), Float.valueOf(split[3]), Float.valueOf(split[4])));
                              } else if (split[0].equals("ShootParticlesSecondary")) {
                                 this.shootParticlesSecondary.add(new DriveableType.ShootParticle(split[1], Float.valueOf(split[2]), Float.valueOf(split[3]), Float.valueOf(split[4])));
                              }
                           }
                        } else {
                           this.acceptAllAmmo = Boolean.parseBoolean(split[1]);
                        }
                     } else {
                        this.numMissileSlots = Integer.parseInt(split[1]);
                     }
                  } else {
                     this.numBombSlots = Integer.parseInt(split[1]);
                  }
               } else {
                  this.wheelSpringStrength = Float.parseFloat(split[1]);
               }
            } else {
               this.wheelStepHeight = Float.parseFloat(split[1]);
            }
         } else {
            this.wheelPositions[Integer.parseInt(split[1])] = new DriveablePosition(new Vector3f(Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F, Float.parseFloat(split[4]) / 16.0F), split.length > 5 ? EnumDriveablePart.getPart(split[5]) : EnumDriveablePart.coreWheel);
         }

         if (split[0].equals("SetPlayerInvisible")) {
            this.setPlayerInvisible = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("IT1")) {
            this.IT1 = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("FixedPrimary")) {
            this.fixedPrimaryFire = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("PrimaryAngle")) {
            this.primaryFireAngle = new Vector3f(Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3]));
         }

         if (split[0].equals("FixedSecondary")) {
            this.fixedSecondaryFire = Boolean.parseBoolean(split[1].toLowerCase());
         }

         if (split[0].equals("SecondaryAngle")) {
            this.secondaryFireAngle = new Vector3f(Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3]));
         } else if (split[0].equals("AddGun")) {
            this.secondary = EnumWeaponType.GUN;
            PilotGun rootPos;
            PilotGun pilotGun;
            if (split.length == 6) {
               rootPos = (PilotGun)this.getShootPoint(split);
               offPos = new Vector3f(0.0F, 0.0F, 0.0F);
               pilotGun = (PilotGun)this.getShootPoint(split);
            } else {
               String[] gun = new String[]{split[0], split[1], split[2], split[3], split[4], split[5]};
               rootPos = (PilotGun)this.getShootPoint(gun);
               pilotGun = (PilotGun)this.getShootPoint(gun);
               offPos = new Vector3f(Float.parseFloat(split[6]) / 16.0F, Float.parseFloat(split[7]) / 16.0F, Float.parseFloat(split[8]) / 16.0F);
            }

            sPoint = new ShootPoint(rootPos, offPos);
            this.shootPointsSecondary.add(sPoint);
            this.pilotGuns.add(pilotGun);
            this.driveableRecipe.add(new ItemStack(pilotGun.type.item));
         } else if (split[0].equals("BombPosition")) {
            this.primary = EnumWeaponType.BOMB;
            if (split.length == 4) {
               this.shootPointsPrimary.add(new ShootPoint(new DriveablePosition(new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F), EnumDriveablePart.core), new Vector3f(0.0F, 0.0F, 0.0F)));
            } else if (split.length == 7) {
               this.shootPointsPrimary.add(new ShootPoint(new DriveablePosition(new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F), EnumDriveablePart.core), new Vector3f(Float.parseFloat(split[4]) / 16.0F, Float.parseFloat(split[5]) / 16.0F, Float.parseFloat(split[6]) / 16.0F)));
            }
         } else if (split[0].equals("BarrelPosition")) {
            this.primary = EnumWeaponType.SHELL;
            if (split.length == 4) {
               this.shootPointsPrimary.add(new ShootPoint(new DriveablePosition(new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F), EnumDriveablePart.turret), new Vector3f(0.0F, 0.0F, 0.0F)));
            } else if (split.length == 7) {
               this.shootPointsPrimary.add(new ShootPoint(new DriveablePosition(new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F), EnumDriveablePart.turret), new Vector3f(Float.parseFloat(split[4]) / 16.0F, Float.parseFloat(split[5]) / 16.0F, Float.parseFloat(split[6]) / 16.0F)));
            }
         } else if (split[0].equals("ShootDelay")) {
            this.shootDelaySecondary = Integer.parseInt(split[1]);
         } else if (!split[0].equals("ShellDelay") && !split[0].equals("BombDelay")) {
            EnumDriveablePart part;
            int i;
            if (split[0].equals("AddRecipeParts")) {
               part = EnumDriveablePart.getPart(split[1]);
               ItemStack[] stacks = new ItemStack[(split.length - 2) / 2];

               for(i = 0; i < (split.length - 2) / 2; ++i) {
                  amount = Integer.parseInt(split[2 * i + 2]);
                  boolean damaged = split[2 * i + 3].contains(".");
                  itemName = damaged ? split[2 * i + 3].split("\\.")[0] : split[2 * i + 3];
                  int damage = damaged ? Integer.parseInt(split[2 * i + 3].split("\\.")[1]) : 0;
                  stacks[i] = getRecipeElement(itemName, amount, damage, this.shortName);
                  this.driveableRecipe.add(stacks[i]);
               }

               this.partwiseRecipe.put(part, stacks);
            } else if (!split[0].equals("AddDye")) {
               if (split[0].equals("SetupPart")) {
                  part = EnumDriveablePart.getPart(split[1]);
                  CollisionBox box = new CollisionBox(Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[6]), Integer.parseInt(split[7]), Integer.parseInt(split[8]));
                  this.health.put(part, box);
               } else if (!split[0].equals("Driver") && !split[0].equals("Pilot")) {
                  if (split[0].equals("DriverPart")) {
                     this.seats[0].part = EnumDriveablePart.getPart(split[1]);
                  } else if (!split[0].equals("DriverGun") && !split[0].equals("PilotGun")) {
                     if (split[0].equals("DriverGunOrigin")) {
                        this.seats[0].gunOrigin = new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F);
                     } else if (split[0].equals("RotatedDriverOffset")) {
                        this.seats[0].rotatedOffset = new Vector3f((float)Integer.parseInt(split[1]) / 16.0F, (float)Integer.parseInt(split[2]) / 16.0F, (float)Integer.parseInt(split[3]) / 16.0F);
                     } else if (split[0].equals("RotatedPassengerOffset")) {
                        this.seats[Integer.parseInt(split[1])].rotatedOffset = new Vector3f((float)Integer.parseInt(split[2]) / 16.0F, (float)Integer.parseInt(split[3]) / 16.0F, (float)Integer.parseInt(split[4]) / 16.0F);
                     } else if (split[0].equals("DriverAimSpeed")) {
                        this.seats[0].aimingSpeed = new Vector3f(Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3]));
                        this.seats[0].aimingSpeedBackup = new Vector3f(Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3]));
                     } else if (split[0].equals("PassengerAimSpeed")) {
                        this.seats[Integer.parseInt(split[1])].aimingSpeed = new Vector3f(Float.parseFloat(split[2]), Float.parseFloat(split[3]), Float.parseFloat(split[4]));
                     } else if (split[0].equals("carrier")) {
                        this.seats[Integer.parseInt(split[1])].carrier = Boolean.parseBoolean(split[2]);
                     } else if (split[0].equals("parkingSpot")) {
                        this.seats[Integer.parseInt(split[1])].parkingSpot = Boolean.parseBoolean(split[2]);
                     } else if (split[0].equals("helipad")) {
                        this.seats[Integer.parseInt(split[1])].helipad = Boolean.parseBoolean(split[2]);
                     } else if (split[0].equals("canSmallArms")) {
                        this.seats[Integer.parseInt(split[1])].canSmallArms = Boolean.parseBoolean(split[2]);
                     } else if (split[0].equals("invincible")) {
                        this.seats[Integer.parseInt(split[1])].invincible = Boolean.parseBoolean(split[2]);
                     }
                  } else {
                     this.seats[0].gunName = split[2];
                  }
               } else if (split.length > 4) {
                  this.seats[0] = new Seat(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Float.parseFloat(split[4]), Float.parseFloat(split[5]), Float.parseFloat(split[6]), Float.parseFloat(split[7]));
               } else {
                  this.seats[0] = new Seat(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
               }
            } else {
               int amount = Integer.parseInt(split[1]);
               int damage = -1;

               for(i = 0; i < ItemDye.field_150923_a.length; ++i) {
                  if (ItemDye.field_150923_a[i].equals(split[2])) {
                     damage = i;
                  }
               }

               if (damage == -1) {
                  FlansMod.log("Failed to find dye colour : " + split[2] + " while adding " + file.name);
                  return;
               }

               this.driveableRecipe.add(new ItemStack(Items.field_151100_aR, amount, damage));
            }
         } else {
            this.shootDelayPrimary = Integer.parseInt(split[1]);
         }

         if (split[0].equals("SetDriverInvincible")) {
            this.invinciblePilotType = Boolean.parseBoolean(split[1].toLowerCase());
         } else if (split[0].equals("DriverLegacyAiming")) {
            this.seats[0].legacyAiming = Boolean.parseBoolean(split[1]);
         } else if (split[0].equals("PassengerLegacyAiming")) {
            this.seats[Integer.parseInt(split[1])].legacyAiming = Boolean.parseBoolean(split[2]);
         } else if (split[0].equals("DriverYawBeforePitch")) {
            this.seats[0].yawBeforePitch = Boolean.parseBoolean(split[1]);
         } else if (split[0].equals("PassengerYawBeforePitch")) {
            this.seats[Integer.parseInt(split[1])].yawBeforePitch = Boolean.parseBoolean(split[2]);
         } else if (split[0].equals("DriverLatePitch")) {
            this.seats[0].latePitch = Boolean.parseBoolean(split[1]);
         } else if (split[0].equals("PassengerLatePitch")) {
            this.seats[Integer.parseInt(split[1])].latePitch = Boolean.parseBoolean(split[2]);
         } else if (split[0].equals("DriverTraverseSounds")) {
            this.seats[0].traverseSounds = Boolean.parseBoolean(split[1]);
         } else if (split[0].equals("PassengerTraverseSounds")) {
            this.seats[Integer.parseInt(split[1])].traverseSounds = Boolean.parseBoolean(split[2]);
         } else if (split[0].equals("Passenger")) {
            Seat seat = new Seat(split);
            this.seats[seat.id] = seat;
            if (seat.gunType != null) {
               seat.gunnerID = this.numPassengerGunners++;
               this.driveableRecipe.add(new ItemStack(seat.gunType.item));
            }
         } else if (split[0].equals("GunOrigin")) {
            this.seats[Integer.parseInt(split[1])].gunOrigin = new Vector3f(Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F, Float.parseFloat(split[4]) / 16.0F);
         } else if (split[0].equals("YOffset")) {
            this.yOffset = Float.parseFloat(split[1]);
         } else if (split[0].equals("CameraDistance")) {
            this.cameraDistance = Float.parseFloat(split[1]);
         } else if (split[0].equals("StartSoundRange")) {
            this.startSoundRange = Integer.parseInt(split[1]);
         } else if (split[0].equals("StartSoundLength")) {
            this.startSoundLength = Integer.parseInt(split[1]);
         } else if (split[0].equals("EngineSoundRange")) {
            this.engineSoundRange = Integer.parseInt(split[1]);
         } else if (split[0].equals("EngineSoundLength")) {
            this.engineSoundLength = Integer.parseInt(split[1]);
         } else if (split[0].equals("IdleSoundLength")) {
            this.idleSoundLength = Integer.parseInt(split[1]);
         } else if (split[0].equals("BackSoundRange")) {
            this.backSoundRange = Integer.parseInt(split[1]);
         } else if (split[0].equals("BackSoundLength")) {
            this.backSoundLength = Integer.parseInt(split[1]);
         } else if (split[0].equals("SoundTime")) {
            this.soundTime = Integer.parseInt(split[1]);
         } else if (split[0].equals("YawSoundLength")) {
            this.seats[0].yawSoundLength = Integer.parseInt(split[1]);
         } else if (split[0].equals("PitchSoundLength")) {
            this.seats[0].pitchSoundLength = Integer.parseInt(split[1]);
         } else if (split[0].equals("PassengerYawSoundLength")) {
            this.seats[Integer.parseInt(split[1])].yawSoundLength = Integer.parseInt(split[2]);
         } else if (split[0].equals("PassengerPitchSoundLength")) {
            this.seats[Integer.parseInt(split[1])].pitchSoundLength = Integer.parseInt(split[2]);
         } else if (split[0].equals("StartSound")) {
            this.startSound = split[1];
            FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
         } else if (split[0].equals("EngineSound")) {
            this.engineSound = split[1];
            FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
         } else if (split[0].equals("IdleSound")) {
            this.idleSound = split[1];
            FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
         } else if (split[0].equals("BackSound")) {
            this.backSound = split[1];
            FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
         } else if (split[0].equals("YawSound")) {
            this.seats[0].yawSound = split[1];
            FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
         } else if (split[0].equals("PitchSound")) {
            this.seats[0].pitchSound = split[1];
            FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
         } else if (split[0].equals("PassengerYawSound")) {
            this.seats[Integer.parseInt(split[1])].yawSound = split[2];
            FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
         } else if (split[0].equals("PassengerPitchSound")) {
            this.seats[Integer.parseInt(split[1])].pitchSound = split[2];
            FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
         } else if (!split[0].equals("ShootMainSound") && !split[0].equals("ShootSoundPrimary") && !split[0].equals("ShellSound") && !split[0].equals("BombSound")) {
            if (split[0].equals("ShootReloadSound")) {
               this.shootReloadSound = split[1];
               FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
            } else if (!split[0].equals("ShootSecondarySound") && !split[0].equals("ShootSoundSecondary")) {
               if (split[0].equals("PlaceSoundPrimary")) {
                  this.placeSoundPrimary = split[1];
                  FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
               } else if (split[0].equals("PlaceSoundSecondary")) {
                  this.placeSoundSecondary = split[1];
                  FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
               } else if (split[0].equals("ReloadSoundPrimary")) {
                  this.reloadSoundPrimary = split[1];
                  FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
               } else if (split[0].equals("ReloadSoundSecondary")) {
                  this.reloadSoundSecondary = split[1];
                  FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
               } else if (split[0].equals("LockedOnSound")) {
                  this.lockedOnSound = split[1];
                  FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
               } else if (split[0].equals("LockOnSound")) {
                  this.lockOnSound = split[1];
                  FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
               } else if (split[0].equals("LockingOnSound")) {
                  this.lockingOnSound = split[1];
                  FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
               }
            } else {
               this.shootSoundSecondary = split[1];
               FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
            }
         } else {
            this.shootSoundPrimary = split[1];
            FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
         }

         if (split[0].equals("FlareSound")) {
            this.flareSound = split[1];
            FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
         }

         if (split[0].equals("FancyCollision")) {
            this.fancyCollision = Boolean.parseBoolean(split[1]);
         }

         CollisionShapeBox box;
         if (split[0].equals("AddCollisionMesh")) {
            box = new CollisionShapeBox(new Vector3f(split[1], this.shortName), new Vector3f(split[2], this.shortName), new Vector3f(split[3], this.shortName), new Vector3f(split[4], this.shortName), new Vector3f(split[5], this.shortName), new Vector3f(split[6], this.shortName), new Vector3f(split[7], this.shortName), new Vector3f(split[8], this.shortName), new Vector3f(split[9], this.shortName), new Vector3f(split[10], this.shortName), "core");
            this.collisionBox.add(box);
         }

         Vector3f p6;
         Vector3f p7;
         Vector3f p8;
         CollisionShapeBox box;
         Vector3f pos;
         Vector3f p2;
         Vector3f p3;
         Vector3f p4;
         Vector3f p5;
         Vector3f p1;
         if (split[0].equals("AddCollisionMeshRaw")) {
            pos = new Vector3f(Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3]));
            offPos = new Vector3f(Float.parseFloat(split[4]), Float.parseFloat(split[5]), Float.parseFloat(split[6]));
            p1 = new Vector3f(Float.parseFloat(split[8]), Float.parseFloat(split[9]), Float.parseFloat(split[10]));
            p2 = new Vector3f(Float.parseFloat(split[11]), Float.parseFloat(split[12]), Float.parseFloat(split[13]));
            p3 = new Vector3f(Float.parseFloat(split[14]), Float.parseFloat(split[15]), Float.parseFloat(split[16]));
            p4 = new Vector3f(Float.parseFloat(split[17]), Float.parseFloat(split[18]), Float.parseFloat(split[19]));
            p5 = new Vector3f(Float.parseFloat(split[20]), Float.parseFloat(split[21]), Float.parseFloat(split[22]));
            p6 = new Vector3f(Float.parseFloat(split[23]), Float.parseFloat(split[24]), Float.parseFloat(split[25]));
            p7 = new Vector3f(Float.parseFloat(split[26]), Float.parseFloat(split[27]), Float.parseFloat(split[28]));
            p8 = new Vector3f(Float.parseFloat(split[29]), Float.parseFloat(split[30]), Float.parseFloat(split[31]));
            box = new CollisionShapeBox(pos, offPos, p1, p2, p3, p4, p5, p6, p7, p8, "core");
            this.collisionBox.add(box);
         }

         if (split[0].equals("AddTurretCollisionMesh")) {
            box = new CollisionShapeBox(new Vector3f(split[1], this.shortName), new Vector3f(split[2], this.shortName), new Vector3f(split[3], this.shortName), new Vector3f(split[4], this.shortName), new Vector3f(split[5], this.shortName), new Vector3f(split[6], this.shortName), new Vector3f(split[7], this.shortName), new Vector3f(split[8], this.shortName), new Vector3f(split[9], this.shortName), new Vector3f(split[10], this.shortName), "turret");
            this.collisionBox.add(box);
         }

         if (split[0].equals("AddTurretCollisionMeshRaw")) {
            pos = new Vector3f(Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3]));
            offPos = new Vector3f(Float.parseFloat(split[4]), Float.parseFloat(split[5]), Float.parseFloat(split[6]));
            p1 = new Vector3f(Float.parseFloat(split[8]), Float.parseFloat(split[9]), Float.parseFloat(split[10]));
            p2 = new Vector3f(Float.parseFloat(split[11]), Float.parseFloat(split[12]), Float.parseFloat(split[13]));
            p3 = new Vector3f(Float.parseFloat(split[14]), Float.parseFloat(split[15]), Float.parseFloat(split[16]));
            p4 = new Vector3f(Float.parseFloat(split[17]), Float.parseFloat(split[18]), Float.parseFloat(split[19]));
            p5 = new Vector3f(Float.parseFloat(split[20]), Float.parseFloat(split[21]), Float.parseFloat(split[22]));
            p6 = new Vector3f(Float.parseFloat(split[23]), Float.parseFloat(split[24]), Float.parseFloat(split[25]));
            p7 = new Vector3f(Float.parseFloat(split[26]), Float.parseFloat(split[27]), Float.parseFloat(split[28]));
            p8 = new Vector3f(Float.parseFloat(split[29]), Float.parseFloat(split[30]), Float.parseFloat(split[31]));
            box = new CollisionShapeBox(pos, offPos, p1, p2, p3, p4, p5, p6, p7, p8, "turret");
            this.collisionBox.add(box);
         }

         if (split[0].equals("LeftLinkPoint")) {
            this.leftTrackPoints.add(new Vector3f(split[1], this.shortName));
         }

         if (split[0].equals("RightLinkPoint")) {
            this.rightTrackPoints.add(new Vector3f(split[1], this.shortName));
         }

         if (split[0].equals("TrackLinkLength")) {
            this.trackLinkLength = Float.parseFloat(split[1]);
         } else if (split[0].equals("OnRadar")) {
            this.onRadar = split[1].equals("True");
         } else if (!split[0].equalsIgnoreCase("AddParticle") && !split[0].equalsIgnoreCase("AddEmitter")) {
            if (split[0].equals("RadarDetectableAltitude")) {
               this.radarDetectableAltitude = Integer.parseInt(split[1]);
            } else if (split[0].equals("Stealth")) {
               this.stealth = split[1].equals("True");
            }
         } else {
            DriveableType.ParticleEmitter emitter = new DriveableType.ParticleEmitter();
            emitter.effectType = split[1];
            emitter.emitRate = Integer.parseInt(split[2]);
            emitter.origin = new Vector3f(split[3], this.shortName);
            emitter.extents = new Vector3f(split[4], this.shortName);
            emitter.velocity = new Vector3f(split[5], this.shortName);
            emitter.minThrottle = Float.parseFloat(split[6]);
            emitter.maxThrottle = Float.parseFloat(split[7]);
            emitter.minHealth = Float.parseFloat(split[8]);
            emitter.maxHealth = Float.parseFloat(split[9]);
            emitter.part = split[10];
            emitter.origin.scale(0.0625F);
            emitter.extents.scale(0.0625F);
            emitter.velocity.scale(0.0625F);
            this.emitters.add(emitter);
         }
      } catch (Exception var14) {
         if (split == null) {
            FlansMod.log("Errored reading " + file.name);
         } else {
            String msg = " : ";
            gun = split;
            amount = split.length;

            for(int var7 = 0; var7 < amount; ++var7) {
               itemName = gun[var7];
               msg = msg + " " + itemName;
            }

            FlansMod.log("Errored reading " + file.name + "");
         }

         if (FlansMod.printStackTrace) {
            var14.printStackTrace();
         }
      }

   }

   private DriveablePosition getShootPoint(String[] split) {
      if (split.length == 6) {
         return new PilotGun(split);
      } else {
         return split.length == 5 ? new DriveablePosition(split) : new DriveablePosition(new Vector3f(), EnumDriveablePart.core);
      }
   }

   public ArrayList<ShootPoint> shootPoints(boolean s) {
      return s ? this.shootPointsSecondary : this.shootPointsPrimary;
   }

   public boolean alternate(boolean s) {
      return s ? this.alternateSecondary : this.alternatePrimary;
   }

   public EnumWeaponType weaponType(boolean s) {
      return s ? this.secondary : this.primary;
   }

   public int shootDelay(boolean s) {
      return s ? this.shootDelaySecondary : this.shootDelayPrimary;
   }

   public String shootSound(boolean s) {
      return s ? this.shootSoundSecondary : this.shootSoundPrimary;
   }

   public ArrayList<DriveableType.ShootParticle> shootParticle(boolean s) {
      return s ? this.shootParticlesSecondary : this.shootParticlesPrimary;
   }

   public int numEngines() {
      return 1;
   }

   public int ammoSlots() {
      return this.numPassengerGunners + this.pilotGuns.size();
   }

   public boolean isValidAmmo(BulletType bulletType, EnumWeaponType weaponType) {
      return (this.acceptAllAmmo || this.ammo.contains(bulletType)) && bulletType.weaponType == weaponType;
   }

   public ArrayList<ItemStack> getItemsRequired(DriveablePart part, PartType engine) {
      ArrayList<ItemStack> stacks = new ArrayList();
      int var5;
      int var6;
      if (this.partwiseRecipe.get(part.type) != null) {
         ItemStack[] var4 = (ItemStack[])this.partwiseRecipe.get(part.type);
         var5 = var4.length;

         for(var6 = 0; var6 < var5; ++var6) {
            ItemStack stack = var4[var6];
            stacks.add(stack.func_77946_l());
         }
      }

      Iterator var8 = this.pilotGuns.iterator();

      while(var8.hasNext()) {
         PilotGun gun = (PilotGun)var8.next();
         if (gun.part == part.type) {
            stacks.add(new ItemStack(gun.type.item));
         }
      }

      Seat[] var9 = this.seats;
      var5 = var9.length;

      for(var6 = 0; var6 < var5; ++var6) {
         Seat seat = var9[var6];
         if (seat != null && seat.part == part.type && seat.gunType != null) {
            stacks.add(new ItemStack(seat.gunType.item));
         }
      }

      return stacks;
   }

   public static DriveableType getDriveable(String find) {
      Iterator var1 = types.iterator();

      DriveableType type;
      do {
         if (!var1.hasNext()) {
            return null;
         }

         type = (DriveableType)var1.next();
      } while(!type.shortName.equals(find));

      return type;
   }

   public float GetRecommendedScale() {
      return 100.0F / this.cameraDistance;
   }

   @SideOnly(Side.CLIENT)
   public ModelBase GetModel() {
      return this.model;
   }

   public class ParticleEmitter {
      public String effectType;
      public int emitRate;
      public Vector3f origin;
      public Vector3f extents;
      public Vector3f velocity;
      public float minThrottle;
      public float maxThrottle;
      public String part;
      public float minHealth;
      public float maxHealth;
   }

   public class ShootParticle {
      float x = 0.0F;
      float y = 0.0F;
      float z = 0.0F;
      String name;

      public ShootParticle(String s, float x1, float y1, float z1) {
         this.x = x1;
         this.y = y1;
         this.z = z1;
         this.name = s;
      }
   }
}
