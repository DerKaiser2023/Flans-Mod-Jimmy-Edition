package com.flansmod.client.tmt;

public class Angle3D {
   public float angleX;
   public float angleY;
   public float angleZ;

   public Angle3D(float x, float y, float z) {
      this.angleX = x;
      this.angleY = y;
      this.angleZ = z;
   }

   public void addAngles(float x, float y, float z) {
      this.angleX += x;
      this.angleY += y;
      this.angleZ += z;
   }

   public void addAngles(Angle3D angles) {
      this.angleX += angles.angleX;
      this.angleY += angles.angleY;
      this.angleZ += angles.angleZ;
   }

   public void multiplyAngles(float x, float y, float z) {
      this.angleX *= x;
      this.angleY *= y;
      this.angleZ *= z;
   }

   public void multiplyAngles(Angle3D angles) {
      this.angleX *= angles.angleX;
      this.angleY *= angles.angleY;
      this.angleZ *= angles.angleZ;
   }

   public static Angle3D getCenter(Angle3D angles1, Angle3D angles2) {
      Angle3D angles = new Angle3D(0.0F, 0.0F, 0.0F);
      angles.addAngles(angles1);
      angles.addAngles(angles2);
      angles.multiplyAngles(0.5F, 0.5F, 0.5F);
      return angles;
   }

   public Angle3D copy() {
      return new Angle3D(this.angleX, this.angleY, this.angleZ);
   }
}
