package com.flansmod.client.debug;

import com.flansmod.common.FlansMod;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderDebugAABB extends Render {
   public void func_76986_a(Entity entity, double d0, double d1, double d2, float f, float f1) {
      if (FlansMod.DEBUG) {
         EntityDebugAABB ent = (EntityDebugAABB)entity;
         GL11.glDisable(3553);
         GL11.glEnable(3042);
         GL11.glColor4f(ent.red, ent.green, ent.blue, 0.2F);
         GL11.glPushMatrix();
         GL11.glTranslatef((float)d0, (float)d1, (float)d2);
         GL11.glRotatef(-ent.field_70177_z, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(ent.field_70125_A, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(ent.rotationRoll, 0.0F, 0.0F, 1.0F);
         func_76980_a(AxisAlignedBB.func_72330_a((double)ent.offset.x, (double)ent.offset.y, (double)ent.offset.z, (double)(ent.offset.x + ent.vector.x), (double)(ent.offset.y + ent.vector.y), (double)(ent.offset.z + ent.vector.z)));
         GL11.glPopMatrix();
         GL11.glDisable(3042);
         GL11.glEnable(3553);
         GL11.glEnable(2929);
      }
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
