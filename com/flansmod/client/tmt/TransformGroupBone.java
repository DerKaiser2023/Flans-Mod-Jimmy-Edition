package com.flansmod.client.tmt;

import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class TransformGroupBone extends TransformGroup {
   protected Angle3D baseAngles;
   protected Vec3 baseVector;
   protected Bone attachedBone;
   protected double weight;

   public TransformGroupBone(Bone bone, double wght) {
      this.baseVector = bone.getPosition();
      this.baseAngles = bone.getAbsoluteAngle();
      this.attachedBone = bone;
      this.weight = wght;
   }

   public Angle3D getBaseAngles() {
      return this.baseAngles.copy();
   }

   public Angle3D getTransformAngle() {
      Angle3D returnAngle = this.attachedBone.getAbsoluteAngle().copy();
      returnAngle.angleX -= this.baseAngles.angleX;
      returnAngle.angleY -= this.baseAngles.angleY;
      returnAngle.angleZ -= this.baseAngles.angleZ;
      return returnAngle;
   }

   public Vec3 getBaseVector() {
      return Vec3.func_72443_a(this.baseVector.field_72450_a, this.baseVector.field_72448_b, this.baseVector.field_72449_c);
   }

   public Vec3 getTransformVector() {
      return this.baseVector.func_72444_a(this.attachedBone.getPosition());
   }

   public Vec3 getCurrentVector() {
      return this.attachedBone.getPosition();
   }

   public double getWeight() {
      return this.weight;
   }

   public void attachBone(Bone bone) {
      this.baseVector = bone.getPosition();
      this.baseAngles = bone.getAbsoluteAngle();
      this.attachedBone = bone;
   }

   public Vec3 doTransformation(PositionTransformVertex vertex) {
      Vec3 vector = Vec3.func_72443_a(vertex.neutralVector.field_72450_a, vertex.neutralVector.field_72448_b, vertex.neutralVector.field_72449_c);
      vector = this.getBaseVector().func_72444_a(vector);
      Angle3D angle = this.getTransformAngle();
      this.setVectorRotations(vector, angle.angleX, angle.angleY, angle.angleZ);
      return vector;
   }

   protected void setVectorRotations(Vec3 vector, float xRot, float yRot, float zRot) {
      float xC = MathHelper.func_76134_b(xRot);
      float xS = MathHelper.func_76126_a(xRot);
      float yC = MathHelper.func_76134_b(yRot);
      float yS = MathHelper.func_76126_a(yRot);
      float zC = MathHelper.func_76134_b(zRot);
      float zS = MathHelper.func_76126_a(zRot);
      double xVec = vector.field_72450_a;
      double yVec = vector.field_72448_b;
      double zVec = vector.field_72449_c;
      double xy = (double)xC * yVec - (double)xS * zVec;
      double xz = (double)xC * zVec + (double)xS * yVec;
      double yz = (double)yC * xz - (double)yS * xVec;
      double yx = (double)yC * xVec + (double)yS * xz;
      double zx = (double)zC * yx - (double)zS * xy;
      double zy = (double)zC * xy + (double)zS * yx;
      vector.field_72450_a = zx;
      vector.field_72448_b = zy;
      vector.field_72449_c = yz;
   }
}
