package com.flansmod.common.vector;

import java.io.Serializable;
import java.nio.FloatBuffer;
import net.minecraft.util.Vec3;

public class Vector3f extends Vector implements Serializable, ReadableVector3f, WritableVector3f {
   private static final long serialVersionUID = 1L;
   public float x;
   public float y;
   public float z;

   public Vector3f() {
   }

   public Vector3f(String input, String typeName) {
      String noBrackets = input.substring(1, input.length() - 1);
      String[] split = noBrackets.split(",");
      if (split.length == 3) {
         this.x = Float.parseFloat(split[0]);
         this.y = Float.parseFloat(split[1]);
         this.z = Float.parseFloat(split[2]);
      }

   }

   public Vector3f(ReadableVector3f src) {
      this.set(src);
   }

   public Vector3f(float x, float y, float z) {
      this.set(x, y, z);
   }

   public Vector3f(Vec3 vec) {
      this((float)vec.field_72450_a, (float)vec.field_72448_b, (float)vec.field_72449_c);
   }

   public Vector3f(double x, double y, double z) {
      this((float)x, (float)y, (float)z);
   }

   public Vec3 toVec3() {
      return Vec3.func_72443_a((double)this.x, (double)this.y, (double)this.z);
   }

   public void set(float x, float y) {
      this.x = x;
      this.y = y;
   }

   public void set(float x, float y, float z) {
      this.x = x;
      this.y = y;
      this.z = z;
   }

   public Vector3f set(ReadableVector3f src) {
      this.x = src.getX();
      this.y = src.getY();
      this.z = src.getZ();
      return this;
   }

   public float lengthSquared() {
      return this.x * this.x + this.y * this.y + this.z * this.z;
   }

   public Vector3f translate(float x, float y, float z) {
      this.x += x;
      this.y += y;
      this.z += z;
      return this;
   }

   public static Vector3f add(Vector3f left, Vector3f right, Vector3f dest) {
      if (dest == null) {
         return new Vector3f(left.x + right.x, left.y + right.y, left.z + right.z);
      } else {
         dest.set(left.x + right.x, left.y + right.y, left.z + right.z);
         return dest;
      }
   }

   public static Vector3f sub(Vector3f left, Vector3f right, Vector3f dest) {
      if (dest == null) {
         return new Vector3f(left.x - right.x, left.y - right.y, left.z - right.z);
      } else {
         dest.set(left.x - right.x, left.y - right.y, left.z - right.z);
         return dest;
      }
   }

   public static Vector3f cross(Vector3f left, Vector3f right, Vector3f dest) {
      if (dest == null) {
         dest = new Vector3f();
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

   public Vector3f negate(Vector3f dest) {
      if (dest == null) {
         dest = new Vector3f();
      }

      dest.x = -this.x;
      dest.y = -this.y;
      dest.z = -this.z;
      return dest;
   }

   public Vector3f normalise(Vector3f dest) {
      float l = this.length();
      if (dest == null) {
         dest = new Vector3f(this.x / l, this.y / l, this.z / l);
      } else {
         dest.set(this.x / l, this.y / l, this.z / l);
      }

      return dest;
   }

   public static float dot(Vector3f left, Vector3f right) {
      return left.x * right.x + left.y * right.y + left.z * right.z;
   }

   public static float angle(Vector3f a, Vector3f b) {
      float dls = dot(a, b) / (a.length() * b.length());
      if (dls < -1.0F) {
         dls = -1.0F;
      } else if (dls > 1.0F) {
         dls = 1.0F;
      }

      return (float)Math.acos((double)dls);
   }

   public Vector load(FloatBuffer buf) {
      this.x = buf.get();
      this.y = buf.get();
      this.z = buf.get();
      return this;
   }

   public Vector scale(float scale) {
      this.x *= scale;
      this.y *= scale;
      this.z *= scale;
      return this;
   }

   public Vector store(FloatBuffer buf) {
      buf.put(this.x);
      buf.put(this.y);
      buf.put(this.z);
      return this;
   }

   public String toString() {
      return "Vector3f[" + this.x + ", " + this.y + ", " + this.z + ']';
   }

   public final float getX() {
      return this.x;
   }

   public final float getY() {
      return this.y;
   }

   public final void setX(float x) {
      this.x = x;
   }

   public final void setY(float y) {
      this.y = y;
   }

   public void setZ(float z) {
      this.z = z;
   }

   public float getZ() {
      return this.z;
   }
}
