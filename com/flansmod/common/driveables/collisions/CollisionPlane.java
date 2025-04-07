package com.flansmod.common.driveables.collisions;

import com.flansmod.common.vector.Vector3f;

public class CollisionPlane {
   public float[] equation;
   public Vector3f normal;
   public Vector3f origin;

   public CollisionPlane(Vector3f origin, Vector3f normal) {
      this.origin = origin;
      this.normal = normal;
      this.equation = new float[4];
      this.equation[0] = normal.x;
      this.equation[1] = normal.y;
      this.equation[2] = normal.z;
      this.equation[3] = -(normal.x * origin.x + normal.y * origin.y + normal.z * origin.z);
   }

   public CollisionPlane(Vector3f p1, Vector3f p2, Vector3f p3) {
      Vector3f edge1 = Vector3f.sub(p2, p1, (Vector3f)null);
      Vector3f edge2 = Vector3f.sub(p3, p1, (Vector3f)null);
      this.normal = Vector3f.cross(edge1, edge2, (Vector3f)null);
      this.normal.normalise();
      this.origin = p1;
      this.equation = new float[4];
      this.equation[0] = this.normal.x;
      this.equation[1] = this.normal.y;
      this.equation[2] = this.normal.z;
      this.equation[3] = -(this.normal.x * this.origin.x + this.normal.y * this.origin.y + this.normal.z * this.origin.z);
   }

   public boolean isFrontFacingTo(Vector3f direction) {
      double dot = (double)Vector3f.dot(this.normal, direction);
      return dot <= 0.0D;
   }

   public double signedDistanceTo(Vector3f point) {
      return (double)(Vector3f.dot(point, this.normal) + this.equation[3]);
   }
}
