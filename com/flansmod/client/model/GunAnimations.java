package com.flansmod.client.model;

import com.flansmod.common.vector.Vector3f;
import java.util.Random;

public class GunAnimations {
   public static GunAnimations defaults = new GunAnimations();
   public boolean isGunEmpty;
   public float gunRecoil = 0.0F;
   public float lastGunRecoil = 0.0F;
   public float recoilAmount = 0.33F;
   public float gunSlide = 0.0F;
   public float lastGunSlide = 0.0F;
   public int timeUntilPump = 0;
   public int timeToPumpFor = 0;
   public float pumped = -1.0F;
   public float lastPumped = -1.0F;
   public boolean pumping = false;
   public int timeUntilCharge = 0;
   public int timeToChargeFor = 0;
   public float charged = -1.0F;
   public float lastCharged = -1.0F;
   public boolean charging = false;
   public boolean reloading = false;
   public float reloadAnimationTime = 0.0F;
   public float reloadAnimationProgress = 0.0F;
   public float lastReloadAnimationProgress = 0.0F;
   public float minigunBarrelRotation = 0.0F;
   public float minigunBarrelRotationSpeed = 0.0F;
   public int muzzleFlashTime = 0;
   public int flashInt = 0;
   public int timeUntilCasing = 0;
   public int casingStage = 0;
   public int lastCasingStage = 0;
   public float hammerRotation = 0.0F;
   public float althammerRotation = 0.0F;
   public int timeUntilPullback = 0;
   public float gunPullback = -1.0F;
   public float lastGunPullback = -1.0F;
   public boolean isFired = false;
   public Vector3f casingRandom = new Vector3f(0.0F, 0.0F, 0.0F);
   public int meleeAnimationProgress = 0;
   public int meleeAnimationLength = 0;
   public int meleeLeftAnimationProgress = 0;
   public int meleeLeftAnimationLength = 0;
   public int meleeRightAnimationProgress = 0;
   public int meleeRightAnimationLength = 0;
   public int meleeDownAnimationProgress = 0;
   public int meleeDownAnimationLength = 0;

   public void update() {
      this.lastPumped = this.pumped;
      this.lastCharged = this.charged;
      this.lastGunPullback = this.gunPullback;
      this.lastCasingStage = this.casingStage;
      if (this.timeUntilPump > 0) {
         --this.timeUntilPump;
         if (this.timeUntilPump == 0) {
            this.pumping = true;
            this.lastPumped = this.pumped = -1.0F;
         }
      }

      if (this.timeUntilCharge > 0) {
         --this.timeUntilCharge;
         if (this.timeUntilCharge == 0) {
            this.charging = true;
            this.lastCharged = this.charged = -1.0F;
         }
      }

      if (this.timeUntilPullback > 0) {
         --this.timeUntilPullback;
         if (this.timeUntilPullback == 0) {
            this.isFired = true;
            this.lastGunPullback = this.gunPullback = -1.0F;
         }
      } else {
         this.hammerRotation *= 0.6F;
         this.althammerRotation *= 0.6F;
      }

      if (this.timeUntilCasing > 0) {
         --this.timeUntilCasing;
         if (this.timeUntilCasing == 0) {
            ++this.casingStage;
         }
      } else {
         ++this.casingStage;
      }

      if (this.muzzleFlashTime > 0) {
         --this.muzzleFlashTime;
      }

      if (this.pumping) {
         this.pumped += 2.0F / (float)this.timeToPumpFor;
         if (this.pumped >= 0.999F) {
            this.pumping = false;
         }
      }

      if (this.charging) {
         this.charged += 2.0F / (float)this.timeToChargeFor;
         if (this.charged >= 0.999F) {
            this.charging = false;
         }
      }

      if (this.isFired) {
         this.gunPullback += 0.5F;
         if (this.gunPullback >= 0.999F) {
            this.isFired = false;
         }
      }

      this.lastGunRecoil = this.gunRecoil;
      if (this.gunRecoil > 0.0F) {
         this.gunRecoil *= 0.7F;
      }

      this.lastGunSlide = this.gunSlide;
      if (this.isGunEmpty) {
         this.lastGunSlide = this.gunSlide = 0.5F;
      }

      if (!this.isGunEmpty && (double)this.gunSlide > 0.9D) {
         this.gunSlide -= 0.1F;
      } else if (this.gunSlide > 0.0F && !this.isGunEmpty) {
         this.gunSlide *= 0.5F;
      }

      this.lastReloadAnimationProgress = this.reloadAnimationProgress;
      if (this.reloading) {
         this.reloadAnimationProgress += 1.0F / this.reloadAnimationTime;
      }

      if (this.reloading && this.reloadAnimationProgress >= 0.9F) {
         this.isGunEmpty = false;
      }

      if (this.reloading && this.reloadAnimationProgress >= 1.0F) {
         this.reloading = false;
      }

      this.minigunBarrelRotation += this.minigunBarrelRotationSpeed;
      this.minigunBarrelRotationSpeed *= 0.9F;
      if (this.meleeAnimationLength > 0) {
         ++this.meleeAnimationProgress;
         if (this.meleeAnimationProgress == this.meleeAnimationLength) {
            this.meleeAnimationProgress = this.meleeAnimationLength = 0;
         }
      }

      if (this.meleeLeftAnimationLength > 0) {
         ++this.meleeLeftAnimationProgress;
         if (this.meleeLeftAnimationProgress == this.meleeLeftAnimationLength) {
            this.meleeLeftAnimationProgress = this.meleeLeftAnimationLength = 0;
         }
      }

      if (this.meleeRightAnimationLength > 0) {
         ++this.meleeRightAnimationProgress;
         if (this.meleeRightAnimationProgress == this.meleeRightAnimationLength) {
            this.meleeRightAnimationProgress = this.meleeRightAnimationLength = 0;
         }
      }

      if (this.meleeDownAnimationLength > 0) {
         ++this.meleeDownAnimationProgress;
         if (this.meleeDownAnimationProgress == this.meleeDownAnimationLength) {
            this.meleeDownAnimationProgress = this.meleeDownAnimationLength = 0;
         }
      }

   }

   public void onGunEmpty(boolean atLastBullet) {
      this.isGunEmpty = atLastBullet;
   }

   public void doShoot(int pumpDelay, int pumpTime, int hammerDelay, float hammerAngle, float althammerAngle, int casingDelay) {
      Random r = new Random();
      this.lastGunRecoil = this.gunRecoil += this.recoilAmount;
      this.minigunBarrelRotationSpeed += 2.0F;
      this.lastGunSlide = this.gunSlide = 1.0F;
      this.timeUntilPump = pumpDelay;
      this.timeToPumpFor = pumpTime;
      this.timeUntilPullback = hammerDelay;
      this.timeUntilCasing = casingDelay;
      this.hammerRotation = hammerAngle;
      this.althammerRotation = althammerAngle;
      this.muzzleFlashTime = 2;
      int Low = -1;
      int High = 3;
      int result = r.nextInt(High - Low) + Low;
      if (result == -1) {
         result = 0;
      }

      if (result == 3) {
         result = 2;
      }

      this.flashInt = result;
      this.casingRandom.x = r.nextFloat() * 2.0F - 1.0F;
      this.casingRandom.y = r.nextFloat() * 2.0F - 1.0F;
      this.casingRandom.z = r.nextFloat() * 2.0F - 1.0F;
      this.casingStage = 0;
   }

   public void doReload(int reloadTime, int pumpDelay, int pumpTime, int chargeDelay, int chargeTime) {
      this.reloading = true;
      this.lastReloadAnimationProgress = this.reloadAnimationProgress = 0.0F;
      this.reloadAnimationTime = (float)reloadTime;
      this.timeUntilPump = pumpDelay;
      this.timeToPumpFor = pumpTime;
      this.timeUntilCharge = chargeDelay;
      this.timeToChargeFor = chargeTime;
   }

   public void doMelee(int meleeTime) {
      if (this.meleeRightAnimationLength == 0 && this.meleeLeftAnimationLength == 0 && this.meleeDownAnimationLength == 0) {
      }

      this.meleeAnimationLength = meleeTime;
   }

   public void doMeleeLeft(int meleeLeftTime) {
      if (this.meleeAnimationLength == 0 && this.meleeRightAnimationLength == 0 && this.meleeDownAnimationLength == 0) {
      }

      this.meleeLeftAnimationLength = meleeLeftTime;
   }

   public void doMeleeRight(int meleeRightTime) {
      if (this.meleeAnimationLength == 0 && this.meleeLeftAnimationLength == 0 && this.meleeDownAnimationLength == 0) {
      }

      this.meleeRightAnimationLength = meleeRightTime;
   }

   public void doMeleeDown(int meleeDownTime) {
      if (this.meleeAnimationLength == 0 && this.meleeLeftAnimationLength == 0 && this.meleeRightAnimationLength == 0) {
      }

      this.meleeDownAnimationLength = meleeDownTime;
   }
}
