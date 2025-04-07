package com.flansmod.common.driveables;

import com.flansmod.common.vector.Vector3f;

public class CollisionBox {
   public float x;
   public float y;
   public float z;
   public float w;
   public float h;
   public float d;
   public int health;
   public EnumDriveablePart part;

   public CollisionBox(int health, int x, int y, int z, int w, int h, int d) {
      this.health = health;
      this.x = (float)x / 16.0F;
      this.y = (float)y / 16.0F;
      this.z = (float)z / 16.0F;
      this.w = (float)w / 16.0F;
      this.h = (float)h / 16.0F;
      this.d = (float)d / 16.0F;
   }

   public Vector3f getCentre() {
      return new Vector3f(this.x + this.w / 2.0F, this.y + this.h / 2.0F, this.z + this.d / 2.0F);
   }
}
