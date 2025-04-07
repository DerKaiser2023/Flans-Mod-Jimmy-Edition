package com.flansmod.client.model;

import com.flansmod.client.FlansModResourceHandler;
import com.flansmod.common.guns.EntityMG;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderMG extends Render {
   public RenderMG() {
      this.field_76989_e = 0.5F;
   }

   public void render(EntityMG mg, double d, double d1, double d2, float f, float f1) {
      this.func_110777_b(mg);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)d, (float)d1, (float)d2);
      GL11.glRotatef(180.0F - (float)mg.direction * 90.0F, 0.0F, 1.0F, 0.0F);
      ModelMG model = mg.type.deployableModel;
      if (model != null) {
         model.renderBipod(0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, mg);
         GL11.glRotatef(-(mg.field_70126_B + (mg.field_70177_z - mg.field_70126_B) * f1), 0.0F, 1.0F, 0.0F);
         model.renderGun(0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, f1, mg);
      }

      GL11.glPopMatrix();
   }

   public void func_76986_a(Entity entity, double d, double d1, double d2, float f, float f1) {
      this.render((EntityMG)entity, d, d1, d2, f, f1);
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return FlansModResourceHandler.getDeployableTexture(((EntityMG)entity).type);
   }
}
