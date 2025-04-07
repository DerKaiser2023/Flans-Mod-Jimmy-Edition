package com.flansmod.client.model;

import com.flansmod.client.FlansModResourceHandler;
import com.flansmod.common.tools.EntityParachute;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderParachute extends Render {
   public RenderParachute() {
      this.field_76989_e = 2.0F;
   }

   public void func_76986_a(Entity entity, double d0, double d1, double d2, float f, float f1) {
      this.func_110777_b(entity);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)d0, (float)d1, (float)d2);
      GL11.glRotatef(-f, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-entity.field_70127_C - (entity.field_70125_A - entity.field_70127_C) * f1, 1.0F, 0.0F, 0.0F);
      ModelBase model = ((EntityParachute)entity).type.model;
      model.func_78088_a(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
      GL11.glPopMatrix();
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return FlansModResourceHandler.getTexture(((EntityParachute)entity).type);
   }
}
