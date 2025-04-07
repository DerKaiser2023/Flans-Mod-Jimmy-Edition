package com.flansmod.common;

import com.flansmod.common.vector.Matrix4f;
import com.flansmod.common.vector.Vector3f;

public class RotatedAxes {
   private float rotationYaw;
   private float rotationPitch;
   private float rotationRoll;
   private Matrix4f rotationMatrix;

   public RotatedAxes() {
      this.rotationMatrix = new Matrix4f();
   }

   public RotatedAxes(Matrix4f mat) {
      this.rotationMatrix = mat;
      this.convertMatrixToAngles();
   }

   public RotatedAxes(float yaw, float pitch, float roll) {
      this.setAngles(yaw, pitch, roll);
   }

   public RotatedAxes clone() {
      RotatedAxes newAxes = new RotatedAxes();
      newAxes.rotationMatrix.load(this.getMatrix());
      newAxes.convertMatrixToAngles();
      return newAxes;
   }

   public void setAngles(float yaw, float pitch, float roll) {
      this.rotationYaw = yaw;
      this.rotationPitch = pitch;
      this.rotationRoll = roll;
      this.convertAnglesToMatrix();
   }

   public float getYaw() {
      return this.rotationYaw;
   }

   public float getPitch() {
      return this.rotationPitch;
   }

   public float getRoll() {
      return this.rotationRoll;
   }

   public Vector3f getXAxis() {
      return new Vector3f(this.rotationMatrix.m00, this.rotationMatrix.m10, this.rotationMatrix.m20);
   }

   public Vector3f getYAxis() {
      return new Vector3f(this.rotationMatrix.m01, this.rotationMatrix.m11, this.rotationMatrix.m21);
   }

   public Vector3f getZAxis() {
      return new Vector3f(-this.rotationMatrix.m02, -this.rotationMatrix.m12, -this.rotationMatrix.m22);
   }

   public Matrix4f getMatrix() {
      return this.rotationMatrix;
   }

   public void rotateLocalYaw(float rotateBy) {
      this.rotationMatrix.rotate(rotateBy * 3.1415927F / 180.0F, this.getYAxis().normalise((Vector3f)null));
      this.convertMatrixToAngles();
   }

   public void rotateLocalPitch(float rotateBy) {
      this.rotationMatrix.rotate(rotateBy * 3.1415927F / 180.0F, this.getZAxis().normalise((Vector3f)null));
      this.convertMatrixToAngles();
   }

   public void rotateLocalRoll(float rotateBy) {
      this.rotationMatrix.rotate(rotateBy * 3.1415927F / 180.0F, this.getXAxis().normalise((Vector3f)null));
      this.convertMatrixToAngles();
   }

   public RotatedAxes rotateGlobalYaw(float rotateBy) {
      this.rotationMatrix.rotate(rotateBy * 3.1415927F / 180.0F, new Vector3f(0.0F, 1.0F, 0.0F));
      this.convertMatrixToAngles();
      return this;
   }

   public RotatedAxes rotateGlobalPitch(float rotateBy) {
      this.rotationMatrix.rotate(rotateBy * 3.1415927F / 180.0F, new Vector3f(0.0F, 0.0F, 1.0F));
      this.convertMatrixToAngles();
      return this;
   }

   public RotatedAxes rotateGlobalRoll(float rotateBy) {
      this.rotationMatrix.rotate(rotateBy * 3.1415927F / 180.0F, new Vector3f(1.0F, 0.0F, 0.0F));
      this.convertMatrixToAngles();
      return this;
   }

   public RotatedAxes rotateGlobalYawInRads(float rotateBy) {
      this.rotationMatrix.rotate(rotateBy, new Vector3f(0.0F, 1.0F, 0.0F));
      this.convertMatrixToAngles();
      return this;
   }

   public RotatedAxes rotateGlobalPitchInRads(float rotateBy) {
      this.rotationMatrix.rotate(rotateBy, new Vector3f(0.0F, 0.0F, 1.0F));
      this.convertMatrixToAngles();
      return this;
   }

   public RotatedAxes rotateGlobalRollInRads(float rotateBy) {
      this.rotationMatrix.rotate(rotateBy, new Vector3f(1.0F, 0.0F, 0.0F));
      this.convertMatrixToAngles();
      return this;
   }

   public void rotateLocal(float rotateBy, Vector3f rotateAround) {
      this.rotationMatrix.rotate(rotateBy * 3.1415927F / 180.0F, this.findLocalVectorGlobally(rotateAround));
      this.convertMatrixToAngles();
   }

   public void rotateGlobal(float rotateBy, Vector3f rotateAround) {
      this.rotationMatrix.rotate(rotateBy * 3.1415927F / 180.0F, rotateAround);
      this.convertMatrixToAngles();
   }

   public Vector3f findGlobalVectorLocally(Vector3f in) {
      Matrix4f mat = new Matrix4f();
      mat.m00 = in.x;
      mat.m10 = in.y;
      mat.m20 = in.z;
      mat.rotate(-this.rotationYaw * 3.1415927F / 180.0F, new Vector3f(0.0F, 1.0F, 0.0F));
      mat.rotate(-this.rotationPitch * 3.1415927F / 180.0F, new Vector3f(0.0F, 0.0F, 1.0F));
      mat.rotate(-this.rotationRoll * 3.1415927F / 180.0F, new Vector3f(1.0F, 0.0F, 0.0F));
      return new Vector3f(mat.m00, mat.m10, mat.m20);
   }

   public Vector3f findLocalVectorGlobally(Vector3f in) {
      Matrix4f mat = new Matrix4f();
      mat.m00 = in.x;
      mat.m10 = in.y;
      mat.m20 = in.z;
      mat.rotate(this.rotationRoll * 3.1415927F / 180.0F, new Vector3f(1.0F, 0.0F, 0.0F));
      mat.rotate(this.rotationPitch * 3.1415927F / 180.0F, new Vector3f(0.0F, 0.0F, 1.0F));
      mat.rotate(this.rotationYaw * 3.1415927F / 180.0F, new Vector3f(0.0F, 1.0F, 0.0F));
      return new Vector3f(mat.m00, mat.m10, mat.m20);
   }

   public Vector3f findLocalVectorGloballyYaw(Vector3f in) {
      Matrix4f mat = new Matrix4f();
      mat.m00 = in.x;
      mat.m10 = in.y;
      mat.m20 = in.z;
      mat.rotate(this.rotationYaw * 3.1415927F / 180.0F, new Vector3f(0.0F, 1.0F, 0.0F));
      return new Vector3f(mat.m00, mat.m10, mat.m20);
   }

   private void convertAnglesToMatrix() {
      this.rotationMatrix = new Matrix4f();
      this.rotationMatrix.rotate(this.rotationRoll * 3.1415927F / 180.0F, new Vector3f(1.0F, 0.0F, 0.0F));
      this.rotationMatrix.rotate(this.rotationPitch * 3.1415927F / 180.0F, new Vector3f(0.0F, 0.0F, 1.0F));
      this.rotationMatrix.rotate(this.rotationYaw * 3.1415927F / 180.0F, new Vector3f(0.0F, 1.0F, 0.0F));
      this.convertMatrixToAngles();
   }

   private void convertMatrixToAngles() {
      this.rotationYaw = (float)Math.atan2((double)this.rotationMatrix.m20, (double)this.rotationMatrix.m00) * 180.0F / 3.1415927F;
      this.rotationPitch = (float)Math.atan2((double)(-this.rotationMatrix.m10), Math.sqrt((double)(this.rotationMatrix.m12 * this.rotationMatrix.m12 + this.rotationMatrix.m11 * this.rotationMatrix.m11))) * 180.0F / 3.1415927F;
      this.rotationRoll = (float)Math.atan2((double)this.rotationMatrix.m12, (double)this.rotationMatrix.m11) * 180.0F / 3.1415927F;
   }

   public RotatedAxes findLocalAxesGlobally(RotatedAxes in) {
      Matrix4f mat = new Matrix4f();
      mat.load(in.getMatrix());
      mat.rotate(this.rotationRoll * 3.1415927F / 180.0F, new Vector3f(1.0F, 0.0F, 0.0F));
      mat.rotate(this.rotationPitch * 3.1415927F / 180.0F, new Vector3f(0.0F, 0.0F, 1.0F));
      mat.rotate(this.rotationYaw * 3.1415927F / 180.0F, new Vector3f(0.0F, 1.0F, 0.0F));
      return new RotatedAxes(mat);
   }

   public String toString() {
      return "RotatedAxes[Yaw = " + this.getYaw() + ", Pitch = " + this.getPitch() + ", Roll = " + this.getRoll() + "]";
   }
}
