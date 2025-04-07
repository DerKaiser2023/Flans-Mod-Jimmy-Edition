package com.flansmod.client.tmt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class Bone {
   protected Angle3D neutralAngles;
   public Angle3D relativeAngles;
   protected Angle3D absoluteAngles;
   private Vec3 positionVector;
   private float length;
   private Bone parentNode;
   protected ArrayList<Bone> childNodes;
   private ArrayList<ModelRenderer> models;
   private Map<ModelRenderer, Angle3D> modelBaseRot;
   private float offsetX;
   private float offsetY;
   private float offsetZ;

   public Bone(float x, float y, float z, float l) {
      this.neutralAngles = new Angle3D(x, y, z);
      this.relativeAngles = new Angle3D(0.0F, 0.0F, 0.0F);
      this.absoluteAngles = new Angle3D(0.0F, 0.0F, 0.0F);
      this.positionVector = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);
      this.length = l;
      this.childNodes = new ArrayList();
      this.models = new ArrayList();
      this.modelBaseRot = new HashMap();
      this.parentNode = null;
      this.offsetX = 0.0F;
      this.offsetY = 0.0F;
      this.offsetZ = 0.0F;
      this.positionVector = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);
   }

   public Bone(float xOrig, float yOrig, float zOrig, float xRot, float yRot, float zRot, float l) {
      this(xRot, yRot, zRot, l);
      this.positionVector = this.setOffset(xOrig, yOrig, zOrig);
   }

   public Bone(float x, float y, float z, float l, Bone parent) {
      this(x, y, z, l);
      this.attachBone(parent);
   }

   public void detachBone() {
      this.parentNode.childNodes.remove(this);
      this.parentNode = null;
   }

   public void attachBone(Bone parent) {
      if (this.parentNode != null) {
         this.detachBone();
      }

      this.parentNode = parent;
      parent.addChildBone(this);
      this.offsetX = parent.offsetX;
      this.offsetY = parent.offsetY;
      this.offsetZ = parent.offsetZ;
      this.resetOffset();
   }

   public Vec3 setOffset(float x, float y, float z) {
      if (this.parentNode != null) {
         Vec3 vector = this.parentNode.setOffset(x, y, z);
         this.offsetX = (float)vector.field_72450_a;
         this.offsetY = (float)vector.field_72448_b;
         this.offsetZ = (float)vector.field_72449_c;
         return vector;
      } else {
         this.offsetX = x;
         this.offsetY = y;
         this.offsetZ = z;
         this.resetOffset(true);
         return Vec3.func_72443_a((double)x, (double)y, (double)z);
      }
   }

   public void resetOffset() {
      this.resetOffset(false);
   }

   public void resetOffset(boolean doRecursive) {
      if (this.parentNode != null) {
         this.positionVector = Vec3.func_72443_a(0.0D, 0.0D, (double)this.parentNode.length);
         this.parentNode.setVectorRotations(this.positionVector);
         Vec3 var10000 = this.positionVector;
         var10000.field_72450_a += this.parentNode.positionVector.field_72450_a;
         var10000 = this.positionVector;
         var10000.field_72448_b += this.parentNode.positionVector.field_72448_b;
         var10000 = this.positionVector;
         var10000.field_72449_c += this.parentNode.positionVector.field_72449_c;
      }

      if (doRecursive && !this.childNodes.isEmpty()) {
         Iterator var2 = this.childNodes.iterator();

         while(var2.hasNext()) {
            Bone childNode = (Bone)var2.next();
            childNode.resetOffset(doRecursive);
         }
      }

   }

   public void setNeutralRotation(float x, float y, float z) {
      this.neutralAngles.angleX = x;
      this.neutralAngles.angleY = y;
      this.neutralAngles.angleZ = z;
   }

   public Bone getRootParent() {
      return this.parentNode == null ? this : this.parentNode.getRootParent();
   }

   public void addModel(ModelRenderer model) {
      this.addModel(model, false);
   }

   public void addModel(ModelRenderer model, boolean inherit) {
      this.addModel(model, 0.0F, 0.0F, 0.0F, inherit);
   }

   public void addModel(ModelRenderer model, boolean inherit, boolean isUpright) {
      this.addModel(model, 0.0F, 0.0F, 0.0F, inherit, isUpright);
   }

   public void addModel(ModelRenderer model, float x, float y, float z) {
      this.addModel(model, x, y, z, false);
   }

   public void addModel(ModelRenderer model, float x, float y, float z, boolean inherit) {
      this.addModel(model, x, y, z, inherit, false);
   }

   public void addModel(ModelRenderer model, float x, float y, float z, boolean inherit, boolean isUpright) {
      if (inherit) {
         x += this.neutralAngles.angleX + (isUpright ? 1.5707964F : 0.0F);
         y += this.neutralAngles.angleY;
         z += this.neutralAngles.angleZ;
      }

      this.models.add(model);
      this.modelBaseRot.put(model, new Angle3D(x, y, z));
   }

   public void removeModel(ModelRenderer model) {
      this.models.remove(model);
      this.modelBaseRot.remove(model);
   }

   public Angle3D getAbsoluteAngle() {
      return new Angle3D(this.absoluteAngles.angleX, this.absoluteAngles.angleY, this.absoluteAngles.angleZ);
   }

   public Vec3 getPosition() {
      return Vec3.func_72443_a(this.positionVector.field_72450_a, this.positionVector.field_72448_b, this.positionVector.field_72449_c);
   }

   protected void addChildBone(Bone bone) {
      this.childNodes.add(bone);
   }

   public void prepareDraw() {
      if (this.parentNode != null) {
         this.parentNode.prepareDraw();
      } else {
         this.setAbsoluteRotations();
         this.setVectors();
      }

   }

   public void setRotations(float x, float y, float z) {
      this.relativeAngles.angleX = x;
      this.relativeAngles.angleY = y;
      this.relativeAngles.angleZ = z;
   }

   protected void setAbsoluteRotations() {
      this.absoluteAngles.angleX = this.relativeAngles.angleX;
      this.absoluteAngles.angleY = this.relativeAngles.angleY;
      this.absoluteAngles.angleZ = this.relativeAngles.angleZ;
      Iterator var1 = this.childNodes.iterator();

      while(var1.hasNext()) {
         Bone childNode = (Bone)var1.next();
         childNode.setAbsoluteRotations(this.absoluteAngles.angleX, this.absoluteAngles.angleY, this.absoluteAngles.angleZ);
      }

   }

   protected void setAbsoluteRotations(float x, float y, float z) {
      this.absoluteAngles.angleX = this.relativeAngles.angleX + x;
      this.absoluteAngles.angleY = this.relativeAngles.angleY + y;
      this.absoluteAngles.angleZ = this.relativeAngles.angleZ + z;
      Iterator var4 = this.childNodes.iterator();

      while(var4.hasNext()) {
         Bone childNode = (Bone)var4.next();
         childNode.setAbsoluteRotations(this.absoluteAngles.angleX, this.absoluteAngles.angleY, this.absoluteAngles.angleZ);
      }

   }

   protected void setVectorRotations(Vec3 vector) {
      float x = this.neutralAngles.angleX + this.absoluteAngles.angleX;
      float y = this.neutralAngles.angleY + this.absoluteAngles.angleY;
      float z = this.neutralAngles.angleZ + this.absoluteAngles.angleZ;
      this.setVectorRotations(vector, x, y, z);
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

   public void setParent(Bone parent) {
      this.attachBone(parent);
   }

   protected void addVector(Vec3 destVec, Vec3 srcVec) {
      destVec.field_72450_a += srcVec.field_72450_a;
      destVec.field_72448_b += srcVec.field_72448_b;
      destVec.field_72449_c += srcVec.field_72449_c;
   }

   protected void setVectors() {
      Vec3 tempVec = Vec3.func_72443_a(0.0D, 0.0D, (double)this.length);
      this.positionVector = Vec3.func_72443_a((double)this.offsetX, (double)this.offsetY, (double)this.offsetZ);
      this.addVector(tempVec, this.positionVector);
      this.setVectorRotations(tempVec);
      Iterator var2 = this.childNodes.iterator();

      while(var2.hasNext()) {
         Bone childNode = (Bone)var2.next();
         childNode.setVectors(tempVec);
      }

   }

   protected void setVectors(Vec3 vector) {
      this.positionVector = vector;
      Vec3 tempVec = Vec3.func_72443_a(0.0D, 0.0D, (double)this.length);
      this.setVectorRotations(tempVec);
      this.addVector(tempVec, vector);
      Iterator var3 = this.childNodes.iterator();

      while(var3.hasNext()) {
         Bone childNode = (Bone)var3.next();
         childNode.setVectors(tempVec);
      }

   }

   public void setAnglesToModels() {
      Iterator var1;
      ModelRenderer currentModel;
      for(var1 = this.models.iterator(); var1.hasNext(); currentModel.field_78798_e = (float)this.positionVector.field_72449_c) {
         currentModel = (ModelRenderer)var1.next();
         Angle3D baseAngles = (Angle3D)this.modelBaseRot.get(currentModel);
         currentModel.field_78795_f = baseAngles.angleX + this.absoluteAngles.angleX;
         currentModel.field_78796_g = baseAngles.angleY + this.absoluteAngles.angleY;
         currentModel.field_78808_h = baseAngles.angleZ + this.absoluteAngles.angleZ;
         currentModel.field_78800_c = (float)this.positionVector.field_72450_a;
         currentModel.field_78797_d = (float)this.positionVector.field_72448_b;
      }

      var1 = this.childNodes.iterator();

      while(var1.hasNext()) {
         Bone childNode = (Bone)var1.next();
         childNode.setAnglesToModels();
      }

   }
}
