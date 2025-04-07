package com.flansmod.common.driveables;

import com.flansmod.common.RotatedAxes;
import com.flansmod.common.driveables.collisions.CollisionTest;
import com.flansmod.common.driveables.collisions.RidingEntityPosition;
import com.flansmod.common.guns.EntityBullet;
import com.flansmod.common.guns.raytracing.DriveableHit;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.nbt.NBTTagCompound;

public class DriveablePart {
   public EnumDriveablePart type;
   public CollisionBox box;
   public int maxHealth;
   public int health;
   public int fireTime;
   public boolean onFire;
   public boolean dead;
   public EntityDriveable owner;

   public DriveablePart(EnumDriveablePart e, CollisionBox b) {
      this.type = e;
      this.box = b;
      this.health = this.maxHealth = b == null ? 0 : b.health;
   }

   public void update(EntityDriveable driveable) {
      if (this.fireTime > 0) {
         --this.fireTime;
      }

      if (this.fireTime == 0) {
         this.onFire = false;
      }

      if (this.onFire) {
         --this.health;
      }

      if (this.health <= 0 && this.maxHealth > 0) {
         this.dead = true;
      }

      this.owner = driveable;
   }

   public void writeToNBT(NBTTagCompound tags) {
      tags.func_74768_a(this.type.getShortName() + "_Health", this.health);
      tags.func_74757_a(this.type.getShortName() + "_Fire", this.onFire);
   }

   public void readFromNBT(NBTTagCompound tags) {
      if (!tags.func_74764_b(this.type.getShortName() + "_Health")) {
         this.health = this.maxHealth;
         this.onFire = false;
      } else {
         this.health = tags.func_74762_e(this.type.getShortName() + "_Health");
         this.onFire = tags.func_74767_n(this.type.getShortName() + "_Fire");
      }
   }

   public float smashIntoGround(EntityDriveable driveable, float damage) {
      if (this.box != null && !this.dead) {
         if (!driveable.canHitPart(this.type)) {
            return 0.0F;
         } else if (this.maxHealth == 0) {
            return damage;
         } else {
            this.health -= (int)(damage / 2.0F);
            return damage / 2.0F;
         }
      } else {
         return 0.0F;
      }
   }

   public DriveableHit rayTrace(EntityDriveable driveable, Vector3f origin, Vector3f motion) {
      if (this.box != null && this.health > 0 && !this.dead) {
         if (!driveable.canHitPart(this.type)) {
            return null;
         } else {
            float intersectTime;
            float intersectX;
            float intersectZ;
            if (motion.x != 0.0F) {
               if (origin.x < this.box.x) {
                  intersectTime = (this.box.x - origin.x) / motion.x;
                  intersectX = origin.y + motion.y * intersectTime;
                  intersectZ = origin.z + motion.z * intersectTime;
                  if (intersectX >= this.box.y && intersectX <= this.box.y + this.box.h && intersectZ >= this.box.z && intersectZ <= this.box.z + this.box.d) {
                     return new DriveableHit(driveable, this.type, intersectTime);
                  }
               } else if (origin.x > this.box.x + this.box.w) {
                  intersectTime = (this.box.x + this.box.w - origin.x) / motion.x;
                  intersectX = origin.y + motion.y * intersectTime;
                  intersectZ = origin.z + motion.z * intersectTime;
                  if (intersectX >= this.box.y && intersectX <= this.box.y + this.box.h && intersectZ >= this.box.z && intersectZ <= this.box.z + this.box.d) {
                     return new DriveableHit(driveable, this.type, intersectTime);
                  }
               }
            }

            if (motion.z != 0.0F) {
               if (origin.z < this.box.z) {
                  intersectTime = (this.box.z - origin.z) / motion.z;
                  intersectX = origin.x + motion.x * intersectTime;
                  intersectZ = origin.y + motion.y * intersectTime;
                  if (intersectX >= this.box.x && intersectX <= this.box.x + this.box.w && intersectZ >= this.box.y && intersectZ <= this.box.y + this.box.h) {
                     return new DriveableHit(driveable, this.type, intersectTime);
                  }
               } else if (origin.z > this.box.z + this.box.d) {
                  intersectTime = (this.box.z + this.box.d - origin.z) / motion.z;
                  intersectX = origin.x + motion.x * intersectTime;
                  intersectZ = origin.y + motion.y * intersectTime;
                  if (intersectX >= this.box.x && intersectX <= this.box.x + this.box.w && intersectZ >= this.box.y && intersectZ <= this.box.y + this.box.h) {
                     return new DriveableHit(driveable, this.type, intersectTime);
                  }
               }
            }

            if (motion.y != 0.0F) {
               if (origin.y < this.box.y) {
                  intersectTime = this.box.y - origin.y;
                  intersectX = origin.x * intersectTime;
                  intersectZ = origin.z * intersectTime;
                  if (intersectX >= this.box.x && intersectX <= this.box.x + this.box.w && intersectZ >= this.box.z && intersectZ <= this.box.z + this.box.d) {
                     return new DriveableHit(driveable, this.type, intersectTime);
                  }
               } else if (origin.y > this.box.y + this.box.h) {
                  intersectTime = this.box.y + this.box.h - origin.y;
                  intersectX = origin.x * intersectTime;
                  intersectZ = origin.z * intersectTime;
                  if (intersectX >= this.box.x && intersectX <= this.box.x + this.box.w && intersectZ >= this.box.z && intersectZ <= this.box.z + this.box.d) {
                     return new DriveableHit(driveable, this.type, intersectTime);
                  }
               }
            }

            return null;
         }
      } else {
         return null;
      }
   }

   public RidingEntityPosition rayTraceRider(EntityDriveable driveable, CollisionTest tester) {
      if (this.box != null && this.health > 0 && !this.dead) {
         if (!driveable.canHitPart(this.type)) {
            return null;
         } else {
            double distance = 10.0D;
            Vector3f collisionPoint = new Vector3f(0.0F, 0.0F, 0.0F);
            int surface = 0;
            new Vector3f(driveable.field_70165_t, driveable.field_70163_u, driveable.field_70161_v);
            RotatedAxes shift = driveable.axes;
            Vector3f p1 = shift.findLocalVectorGlobally(new Vector3f(this.box.x + this.box.w, this.box.y + this.box.h, this.box.z));
            Vector3f p2 = shift.findLocalVectorGlobally(new Vector3f(this.box.x + this.box.w, this.box.y + this.box.h, this.box.z + this.box.d));
            Vector3f p3 = shift.findLocalVectorGlobally(new Vector3f(this.box.x, this.box.y + this.box.h, this.box.z + this.box.d));
            Vector3f p4 = shift.findLocalVectorGlobally(new Vector3f(this.box.x, this.box.y + this.box.h, this.box.z));
            Vector3f p5 = shift.findLocalVectorGlobally(new Vector3f(this.box.x + this.box.w, this.box.y, this.box.z));
            Vector3f p6 = shift.findLocalVectorGlobally(new Vector3f(this.box.x + this.box.w, this.box.y, this.box.z + this.box.d));
            Vector3f p7 = shift.findLocalVectorGlobally(new Vector3f(this.box.x, this.box.y, this.box.z + this.box.d));
            Vector3f p8 = shift.findLocalVectorGlobally(new Vector3f(this.box.x, this.box.y, this.box.z));
            if (this.type == EnumDriveablePart.turret && driveable.seats[0] != null) {
               p1 = driveable.getPositionOnTurret(new Vector3f(this.box.x + this.box.w, this.box.y + this.box.h, this.box.z), false);
               p2 = driveable.getPositionOnTurret(new Vector3f(this.box.x + this.box.w, this.box.y + this.box.h, this.box.z + this.box.d), false);
               p3 = driveable.getPositionOnTurret(new Vector3f(this.box.x, this.box.y + this.box.h, this.box.z + this.box.d), false);
               p4 = driveable.getPositionOnTurret(new Vector3f(this.box.x, this.box.y + this.box.h, this.box.z), false);
               p5 = driveable.getPositionOnTurret(new Vector3f(this.box.x + this.box.w, this.box.y, this.box.z), false);
               p6 = driveable.getPositionOnTurret(new Vector3f(this.box.x + this.box.w, this.box.y, this.box.z + this.box.d), false);
               p7 = driveable.getPositionOnTurret(new Vector3f(this.box.x, this.box.y, this.box.z + this.box.d), false);
               p8 = driveable.getPositionOnTurret(new Vector3f(this.box.x, this.box.y, this.box.z), false);
            }

            double topFaceDist = 100.0D;
            tester.checkTriangle(tester, p3, p2, p1);
            if (tester.didCollide && tester.nearestDistance < distance) {
               collisionPoint = tester.intersectionPoint;
               surface = 1;
               tester.part = this.type;
            }

            tester.checkTriangle(tester, p4, p3, p1);
            if (tester.didCollide && tester.nearestDistance < distance) {
               collisionPoint = tester.intersectionPoint;
               surface = 1;
               tester.part = this.type;
            }

            if (tester.didCollide) {
               tester.isOnTop = true;
               topFaceDist = tester.nearestDistance;
            }

            tester.checkTriangle(tester, p1, p2, p6);
            if (tester.didCollide && tester.nearestDistance < distance) {
               distance = tester.nearestDistance;
               collisionPoint = tester.intersectionPoint;
               surface = 2;
               tester.part = this.type;
            }

            tester.checkTriangle(tester, p1, p6, p5);
            if (tester.didCollide && tester.nearestDistance < distance) {
               distance = tester.nearestDistance;
               collisionPoint = tester.intersectionPoint;
               surface = 2;
               tester.part = this.type;
            }

            tester.checkTriangle(tester, p3, p4, p8);
            if (tester.didCollide && tester.nearestDistance < distance) {
               distance = tester.nearestDistance;
               collisionPoint = tester.intersectionPoint;
               surface = 3;
               tester.part = this.type;
            }

            tester.checkTriangle(tester, p4, p8, p7);
            if (tester.didCollide && tester.nearestDistance < distance) {
               distance = tester.nearestDistance;
               collisionPoint = tester.intersectionPoint;
               surface = 3;
               tester.part = this.type;
            }

            tester.checkTriangle(tester, p4, p1, p5);
            if (tester.didCollide && tester.nearestDistance < distance) {
               distance = tester.nearestDistance;
               collisionPoint = tester.intersectionPoint;
               surface = 4;
               tester.part = this.type;
            }

            tester.checkTriangle(tester, p1, p5, p8);
            if (tester.didCollide && tester.nearestDistance < distance) {
               distance = tester.nearestDistance;
               collisionPoint = tester.intersectionPoint;
               surface = 4;
               tester.part = this.type;
            }

            tester.checkTriangle(tester, p2, p3, p7);
            if (tester.didCollide && tester.nearestDistance < distance) {
               distance = tester.nearestDistance;
               collisionPoint = tester.intersectionPoint;
               surface = 5;
               tester.part = this.type;
            }

            tester.checkTriangle(tester, p3, p7, p6);
            if (tester.didCollide && tester.nearestDistance < distance) {
               distance = tester.nearestDistance;
               collisionPoint = tester.intersectionPoint;
               surface = 5;
               tester.part = this.type;
            }

            if (tester.nearestDistance < topFaceDist) {
               tester.isOnTop = false;
            }

            if (surface == 1) {
               tester.isOnTop = true;
            }

            return tester.didCollide ? new RidingEntityPosition(collisionPoint.x, collisionPoint.y, collisionPoint.z, 1, distance, this.type) : null;
         }
      } else {
         return null;
      }
   }

   public void hitByBullet(EntityBullet bullet, DriveableHit hit) {
      if (bullet != null) {
         if (hit.driveable instanceof EntityPlane) {
            this.health = (int)((float)this.health - bullet.damage * bullet.type.damageVsPlanes);
         } else {
            this.health = (int)((float)this.health - bullet.damage * bullet.type.damageVsVehicles);
         }

         if (bullet.type.setEntitiesOnFire) {
            this.fireTime = 20;
            this.onFire = true;
         }
      }

   }

   private boolean coordIsEntering(float start, float end, float min, float max) {
      if (start < min && end >= min) {
         return true;
      } else {
         return start > max && end <= max;
      }
   }

   private boolean coordIsIn(float start, float end, float min, float max) {
      if (start >= min && start <= max) {
         return true;
      } else if (end >= min && end <= max) {
         return true;
      } else if (start < min && end > max) {
         return true;
      } else {
         return end < min && start > max;
      }
   }

   public boolean attack(float damage, boolean fireDamage) {
      this.health = (int)((float)this.health - damage);
      if (fireDamage) {
         this.fireTime = 20;
         this.onFire = true;
      }

      if (this.health < 0) {
         this.health = 0;
      }

      return this.health <= 0;
   }
}
