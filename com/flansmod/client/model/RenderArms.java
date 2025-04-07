package com.flansmod.client.model;

import com.flansmod.common.vector.Vector3f;
import org.lwjgl.opengl.GL11;

public class RenderArms {
   public static void renderArmPump(ModelGun model, GunAnimations anim, float smoothing, Vector3f rotationPoint, Vector3f armPosition) {
      GL11.glTranslatef(-(armPosition.x - Math.abs(anim.lastPumped + (anim.pumped - anim.lastPumped) * smoothing) / model.pumpModifier), armPosition.y, armPosition.z);
      handleRotate(rotationPoint);
   }

   public static void renderArmCharge(ModelGun model, GunAnimations anim, float smoothing, Vector3f rotationPoint, Vector3f armPosition) {
      handleRotate(rotationPoint);
      GL11.glTranslatef(-(armPosition.x - Math.abs(anim.lastCharged + (anim.charged - anim.lastCharged) * smoothing) / model.chargeModifier.x), -(armPosition.y - Math.abs(anim.lastCharged + (anim.charged - anim.lastCharged) * smoothing) / model.chargeModifier.y), -(armPosition.z - Math.abs(anim.lastCharged + (anim.charged - anim.lastCharged) * smoothing) / model.chargeModifier.z));
   }

   public static void renderArmBolt(ModelGun model, GunAnimations anim, float smoothing, Vector3f rotationPoint, Vector3f armPosition) {
      handleRotate(rotationPoint);
      GL11.glTranslatef(armPosition.x + Math.abs(anim.lastPumped + (anim.pumped - anim.lastPumped) * smoothing) / model.chargeModifier.x, armPosition.y + Math.abs(anim.lastPumped + (anim.pumped - anim.lastPumped) * smoothing) / model.chargeModifier.y, -(armPosition.z - Math.abs(anim.lastCharged + (anim.charged - anim.lastCharged) * smoothing) / model.chargeModifier.z));
   }

   public static void renderArmDefault(ModelGun model, GunAnimations anim, float smoothing, Vector3f rotationPoint, Vector3f armPosition) {
      handleRotate(rotationPoint);
      GL11.glTranslatef(armPosition.x, armPosition.y, armPosition.z);
   }

   public static void renderArmReload(ModelGun model, GunAnimations anim, float smoothing, Vector3f rotationPoint, Vector3f armPosition) {
      handleRotate(rotationPoint);
      GL11.glTranslatef(armPosition.x, armPosition.y, armPosition.z);
   }

   private static void handleRotate(Vector3f rotationPoint) {
      GL11.glRotatef(rotationPoint.y, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(rotationPoint.z, 0.0F, 0.0F, 1.0F);
      GL11.glRotatef(rotationPoint.x, 1.0F, 0.0F, 0.0F);
   }
}
