package com.flansmod.client.debug;

import com.flansmod.common.FlansMod;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderDebugVector extends Render {
   public void func_76986_a(Entity entity, double d0, double d1, double d2, float f, float f1) {
      if (FlansMod.DEBUG) {
         EntityDebugVector ent = (EntityDebugVector)entity;
         GL11.glDisable(3553);
         GL11.glDisable(2929);
         GL11.glColor3f(ent.red, ent.green, ent.blue);
         GL11.glPushMatrix();
         GL11.glTranslatef((float)d0, (float)d1, (float)d2);
         GL11.glLineWidth(5.0F);
         GL11.glBegin(3);
         GL11.glVertex3f(0.0F, 0.0F, 0.0F);
         GL11.glVertex3f(ent.vector.x, ent.vector.y, ent.vector.z);
         GL11.glEnd();
         GL11.glPopMatrix();
         GL11.glEnable(3553);
         GL11.glEnable(2929);
      }
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
