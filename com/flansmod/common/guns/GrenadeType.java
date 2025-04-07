package com.flansmod.common.guns;

import com.flansmod.common.FlansMod;
import com.flansmod.common.types.TypeFile;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.model.ModelBase;
import net.minecraft.potion.PotionEffect;

public class GrenadeType extends ShootableType {
   public static ArrayList<GrenadeType> grenades = new ArrayList();
   public int meleeDamage = 1;
   public int throwDelay = 0;
   public String throwSound = "";
   public String dropItemOnThrow = null;
   public boolean canThrow = true;
   public float bounciness = 0.9F;
   public boolean penetratesEntities = false;
   public boolean penetratesBlocks = false;
   public String bounceSound = "";
   public boolean sticky = false;
   public boolean stickToThrower = false;
   public boolean stickToEntity = false;
   public boolean stickToDriveable = false;
   public boolean stickToEntityAfter = false;
   public boolean allowStickSound = false;
   public int stickSoundRange = 10;
   public String stickSound;
   public boolean flashBang = false;
   public int flashTime = 200;
   public int flashRange = 8;
   public boolean flashSoundEnable = false;
   public int flashSoundRange = 16;
   public String flashSound;
   public boolean flashDamageEnable = false;
   public float flashDamage;
   public boolean flashEffects = false;
   public int flashEffectsID;
   public int flashEffectsDuration;
   public int flashEffectsLevel;
   public boolean motionSensor = false;
   public float motionSensorRange = 5.0F;
   public float motionSoundRange = 20.0F;
   public String motionSound;
   public int motionTime = 20;
   public float livingProximityTrigger = -1.0F;
   public float driveableProximityTrigger = -1.0F;
   public boolean detonateWhenShot = false;
   public boolean remote = false;
   public float damageToTriggerer = 0.0F;
   public int primeDelay = 0;
   public int explodeParticles = 0;
   public String explodeParticleType = "largesmoke";
   public boolean spinWhenThrown = true;
   public int smokeTime = 0;
   public String smokeParticleType = "explode";
   public ArrayList<PotionEffect> smokeEffects = new ArrayList();
   public float smokeRadius = 5.0F;
   public boolean isDeployableBag = false;
   public int numUses = 1;
   public float healAmount = 0.0F;
   public ArrayList<PotionEffect> potionEffects = new ArrayList();
   public int numClips = 0;

   public GrenadeType(TypeFile file) {
      super(file);
      grenades.add(this);
   }

   protected void preRead(TypeFile file) {
      super.preRead(file);
   }

   protected void read(String[] split, TypeFile file) {
      super.read(split, file);

      try {
         if (split[0].equals("MeleeDamage")) {
            this.meleeDamage = Integer.parseInt(split[1]);
         } else if (split[0].equals("ThrowDelay")) {
            this.throwDelay = Integer.parseInt(split[1]);
         } else if (split[0].equals("ThrowSound")) {
            this.throwSound = split[1];
         } else if (split[0].equals("DropItemOnThrow")) {
            this.dropItemOnThrow = split[1];
         } else if (split[0].equals("CanThrow")) {
            this.canThrow = Boolean.parseBoolean(split[1]);
         } else if (split[0].equals("Bounciness")) {
            this.bounciness = Float.parseFloat(split[1]);
         } else if (split[0].equals("PenetratesEntities")) {
            this.penetratesEntities = Boolean.parseBoolean(split[1].toLowerCase());
         } else if (split[0].equals("PenetratesBlocks")) {
            this.penetratesBlocks = Boolean.parseBoolean(split[1].toLowerCase());
         } else if (split[0].equals("BounceSound")) {
            this.bounceSound = split[1];
         } else if (split[0].equals("Sticky")) {
            this.sticky = Boolean.parseBoolean(split[1]);
         } else if (split[0].equals("LivingProximityTrigger")) {
            this.livingProximityTrigger = Float.parseFloat(split[1]);
         } else if (split[0].equals("VehicleProximityTrigger")) {
            this.driveableProximityTrigger = Float.parseFloat(split[1]);
         } else if (split[0].equals("DamageToTriggerer")) {
            this.damageToTriggerer = Float.parseFloat(split[1]);
         } else if (split[0].equals("DetonateWhenShot")) {
            this.detonateWhenShot = Boolean.parseBoolean(split[1].toLowerCase());
         } else if (!split[0].equals("PrimeDelay") && !split[0].equals("TriggerDelay")) {
            if (split[0].equals("StickToThrower")) {
               this.stickToThrower = Boolean.parseBoolean(split[1]);
            } else if (split[0].equals("StickToEntity")) {
               this.stickToEntity = Boolean.parseBoolean(split[1]);
            } else if (split[0].equals("StickToDriveable")) {
               this.stickToDriveable = Boolean.parseBoolean(split[1]);
            } else if (split[0].equals("StickToEntityAfter")) {
               this.stickToEntityAfter = Boolean.parseBoolean(split[1]);
            } else if (split[0].equals("AllowStickSound")) {
               this.allowStickSound = Boolean.parseBoolean(split[1]);
            } else if (split[0].equals("StickSoundRange")) {
               this.stickSoundRange = Integer.parseInt(split[1]);
            } else if (split[0].equals("StickSound")) {
               this.stickSound = split[1];
               FlansMod.proxy.loadSound(this.contentPack, "sound", split[1]);
            } else if (split[0].equals("NumExplodeParticles")) {
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
            } else if (split[0].equals("SpinWhenThrown")) {
               this.spinWhenThrown = Boolean.parseBoolean(split[1].toLowerCase());
            } else if (split[0].equals("Remote")) {
               this.remote = Boolean.parseBoolean(split[1].toLowerCase());
            } else if (split[0].equals("FlashBang")) {
               this.flashBang = Boolean.parseBoolean(split[1]);
            } else if (split[0].equals("FlashTime")) {
               this.flashTime = Integer.parseInt(split[1]);
            } else if (split[0].equals("FlashRange")) {
               this.flashRange = Integer.parseInt(split[1]);
            } else if (split[0].equals("FlashSoundEnable")) {
               this.flashSoundEnable = Boolean.parseBoolean(split[1]);
            } else if (split[0].equals("FlashSoundRange")) {
               this.flashSoundRange = Integer.parseInt(split[1]);
            } else if (split[0].equals("FlashSound")) {
               this.flashSound = split[1];
               FlansMod.proxy.loadSound(this.contentPack, "sound", split[1]);
            } else if (split[0].equals("FlashDamageEnable")) {
               this.flashDamageEnable = Boolean.parseBoolean(split[1]);
            } else if (split[0].equals("FlashDamage")) {
               this.flashDamage = Float.parseFloat(split[1]);
            } else if (split[0].equals("FlashEffects")) {
               this.flashEffects = Boolean.parseBoolean(split[1]);
            } else if (split[0].equals("FlashEffectsID")) {
               this.flashEffectsID = Integer.parseInt(split[1]);
            } else if (split[0].equals("FlashEffectsDuration")) {
               this.flashEffectsDuration = Integer.parseInt(split[1]);
            } else if (split[0].equals("FlashEffectsLevel")) {
               this.flashEffectsLevel = Integer.parseInt(split[1]);
            } else if (split[0].equals("MotionSensor")) {
               this.motionSensor = Boolean.parseBoolean(split[1]);
            } else if (split[0].equals("MotionSensorRange")) {
               this.motionSensorRange = Float.parseFloat(split[1]);
            } else if (split[0].equals("MotionSoundRange")) {
               this.motionSoundRange = Float.parseFloat(split[1]);
            } else if (split[0].equals("MotionSound")) {
               this.motionSound = split[1];
               FlansMod.proxy.loadSound(this.contentPack, "sound", split[1]);
            } else if (split[0].equals("MotionTime")) {
               this.motionTime = Integer.parseInt(split[1]);
            } else if (split[0].equals("DeployableBag")) {
               this.isDeployableBag = true;
            } else if (split[0].equals("NumUses")) {
               this.numUses = Integer.parseInt(split[1]);
            } else if (split[0].equals("HealAmount")) {
               this.healAmount = Float.parseFloat(split[1]);
            } else if (!split[0].equals("AddPotionEffect") && !split[0].equals("PotionEffect")) {
               if (split[0].equals("NumClips")) {
                  this.numClips = Integer.parseInt(split[1]);
               }
            } else {
               this.potionEffects.add(getPotionEffect(split));
            }
         } else {
            this.primeDelay = Integer.parseInt(split[1]);
         }
      } catch (Exception var4) {
         System.out.println("Reading grenade file failed.");
         var4.printStackTrace();
      }

   }

   public static GrenadeType getGrenade(String s) {
      Iterator var1 = grenades.iterator();

      GrenadeType grenade;
      do {
         if (!var1.hasNext()) {
            return null;
         }

         grenade = (GrenadeType)var1.next();
      } while(!grenade.shortName.equals(s));

      return grenade;
   }

   public void reloadModel() {
      this.model = (ModelBase)FlansMod.proxy.loadModel(this.modelString, this.shortName, ModelBase.class);
   }
}
