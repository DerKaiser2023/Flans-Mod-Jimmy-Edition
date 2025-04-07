package com.flansmod.common.driveables;

import com.flansmod.common.vector.Vector3f;

public class CollisionSurface {
   public Vector3f localisedOrigin;
   public Vector3f u;
   public Vector3f v;

   public CollisionSurface(Vector3f o, Vector3f u1, Vector3f v1) {
      this.localisedOrigin = o;
      this.u = u1;
      this.v = v1;
   }
}
