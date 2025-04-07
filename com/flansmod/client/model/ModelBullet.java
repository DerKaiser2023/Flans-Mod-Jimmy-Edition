package com.flansmod.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelBullet extends ModelBase {
   public ModelRenderer bulletModel = new ModelRenderer(this, 0, 0);

   public ModelBullet() {
      this.bulletModel.func_78789_a(-0.5F, -1.5F, -0.5F, 1, 3, 1);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      GL11.glTranslatef(-0.0F, 2.0F, 0.0F);
      this.bulletModel.func_78785_a(f5);
   }
}
