package com.flansmod.common.vector;

import java.nio.FloatBuffer;
import net.minecraft.util.Vec3;

public class Vector3i extends Vector {
   private static final long serialVersionUID = 1L;
   public int x;
   public int y;
   public int z;

   public Vector3i() {
   }

   public Vector3i(int x, int y, int z) {
      this.set(x, y, z);
   }

   public Vector3i(Vec3 vec) {
      this((int)vec.field_72450_a, (int)vec.field_72448_b, (int)vec.field_72449_c);
   }

   public Vector3i(double x, double y, double z) {
      this((int)x, (int)y, (int)z);
   }

   public Vector3i(Vector3i v) {
      this(v.x, v.y, v.z);
   }

   public Vec3 toVec3() {
      return Vec3.func_72443_a((double)this.x, (double)this.y, (double)this.z);
   }

   public void set(int x, int y, int z) {
      this.x = x;
      this.y = y;
      this.z = z;
   }

   public float lengthSquared() {
      return (float)(this.x * this.x + this.y * this.y + this.z * this.z);
   }

   public Vector3i translate(int x, int y, int z) {
      this.x += x;
      this.y += y;
      this.z += z;
      return this;
   }

   public static Vector3i add(Vector3i left, Vector3i right, Vector3i dest) {
      if (dest == null) {
         return new Vector3i(left.x + right.x, left.y + right.y, left.z + right.z);
      } else {
         dest.set(left.x + right.x, left.y + right.y, left.z + right.z);
         return dest;
      }
   }

   public static Vector3i sub(Vector3i left, Vector3i right, Vector3i dest) {
      if (dest == null) {
         return new Vector3i(left.x - right.x, left.y - right.y, left.z - right.z);
      } else {
         dest.set(left.x - right.x, left.y - right.y, left.z - right.z);
         return dest;
      }
   }

   public static Vector3i cross(Vector3i left, Vector3i right, Vector3i dest) {
      if (dest == null) {
         dest = new Vector3i();
      }

      dest.set(left.y * right.z - left.z * right.y, right.x * left.z - right.z * left.x, left.x * right.y - left.y * right.x);
      return dest;
   }

   public Vector negate() {
      this.x = -this.x;
      this.y = -this.y;
      this.z = -this.z;
      return this;
   }

   public Vector3i negate(Vector3i dest) {
      if (dest == null) {
         dest = new Vector3i();
      }

      dest.x = -this.x;
      dest.y = -this.y;
      dest.z = -this.z;
      return dest;
   }

   public Vector3i normalise(Vector3i dest) {
      float l = this.length();
      if (dest == null) {
         dest = new Vector3i((double)((float)this.x / l), (double)((float)this.y / l), (double)((float)this.z / l));
      } else {
         dest.set((int)((float)this.x / l), (int)((float)this.y / l), (int)((float)this.z / l));
      }

      return dest;
   }

   public static float dot(Vector3i left, Vector3i right) {
      return (float)(left.x * right.x + left.y * right.y + left.z * right.z);
   }

   public static float angle(Vector3i a, Vector3i b) {
      float dls = dot(a, b) / (a.length() * b.length());
      if (dls < -1.0F) {
         dls = -1.0F;
      } else if (dls > 1.0F) {
         dls = 1.0F;
      }

      return (float)Math.acos((double)dls);
   }

   public Vector load(FloatBuffer buf) {
      this.x = (int)buf.get();
      this.y = (int)buf.get();
      this.z = (int)buf.get();
      return this;
   }

   public Vector scale(float scale) {
      this.x = (int)((float)this.x * scale);
      this.y = (int)((float)this.y * scale);
      this.z = (int)((float)this.z * scale);
      return this;
   }

   public Vector store(FloatBuffer buf) {
      buf.put((float)this.x);
      buf.put((float)this.y);
      buf.put((float)this.z);
      return this;
   }

   public String toString() {
      return "Vector3i[" + this.x + ", " + this.y + ", " + this.z + ']';
   }

   public final int getX() {
      return this.x;
   }

   public final int getY() {
      return this.y;
   }

   public final void setX(int x) {
      this.x = x;
   }

   public final void setY(int y) {
      this.y = y;
   }

   public void setZ(int z) {
      this.z = z;
   }

   public int getZ() {
      return this.z;
   }
}
