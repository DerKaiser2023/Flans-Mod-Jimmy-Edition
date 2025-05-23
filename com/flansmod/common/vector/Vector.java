package com.flansmod.common.vector;

import java.io.Serializable;
import java.nio.FloatBuffer;

public abstract class Vector implements Serializable, ReadableVector {
   protected Vector() {
   }

   public final float length() {
      return (float)Math.sqrt((double)this.lengthSquared());
   }

   public abstract float lengthSquared();

   public abstract Vector load(FloatBuffer var1);

   public abstract Vector negate();

   public final Vector normalise() {
      float len = this.length();
      if (len != 0.0F) {
         float l = 1.0F / len;
         return this.scale(l);
      } else {
         return this.scale(0.0F);
      }
   }

   public abstract Vector store(FloatBuffer var1);

   public abstract Vector scale(float var1);
}
