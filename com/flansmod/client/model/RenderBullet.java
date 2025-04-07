package com.flansmod.client.model;

import com.flansmod.client.FlansModResourceHandler;
import com.flansmod.common.guns.EntityBullet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderBullet extends Render {
   public RenderBullet() {
      this.field_76989_e = 0.0F;
   }

   public void render(EntityBullet bullet, double d, double d1, double d2, float f, float f1) {
      if (bullet.owner != Minecraft.func_71410_x().field_71439_g || bullet.field_70173_aa >= 1) {
         this.func_110777_b(bullet);
         GL11.glPushMatrix();
         GL11.glTranslatef((float)d, (float)d1, (float)d2);
         GL11.glRotatef(f, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(90.0F - bullet.field_70127_C - (bullet.field_70125_A - bullet.field_70127_C) * f1, 1.0F, 0.0F, 0.0F);
         ModelBase model = bullet.type.model;
         if (model != null) {
            model.func_78088_a(bullet, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
         }

         GL11.glPopMatrix();
      }
   }

   public void func_76986_a(Entity entity, double d, double d1, double d2, float f, float f1) {
      this.render((EntityBullet)entity, d, d1, d2, f, f1);
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return FlansModResourceHandler.getTexture(((EntityBullet)entity).type);
   }
}
