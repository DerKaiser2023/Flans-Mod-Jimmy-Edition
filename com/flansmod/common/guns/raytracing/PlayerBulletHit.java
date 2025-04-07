package com.flansmod.common.guns.raytracing;

public class PlayerBulletHit extends BulletHit {
   public PlayerHitbox hitbox;

   public PlayerBulletHit(PlayerHitbox box, float f) {
      super(f);
      this.hitbox = box;
   }
}
