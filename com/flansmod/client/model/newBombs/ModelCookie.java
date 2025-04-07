package com.flansmod.client.model.newBombs;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelCookie extends ModelBase {
   int textureX = 512;
   int textureY = 512;
   public ModelRendererTurbo[] cookieModel = new ModelRendererTurbo[9];

   public ModelCookie() {
      this.cookieModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.cookieModel[1] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.cookieModel[2] = new ModelRendererTurbo(this, 65, 1, this.textureX, this.textureY);
      this.cookieModel[3] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.cookieModel[4] = new ModelRendererTurbo(this, 129, 1, this.textureX, this.textureY);
      this.cookieModel[5] = new ModelRendererTurbo(this, 161, 1, this.textureX, this.textureY);
      this.cookieModel[6] = new ModelRendererTurbo(this, 193, 1, this.textureX, this.textureY);
      this.cookieModel[7] = new ModelRendererTurbo(this, 225, 1, this.textureX, this.textureY);
      this.cookieModel[8] = new ModelRendererTurbo(this, 257, 1, this.textureX, this.textureY);
      this.cookieModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 6, 40, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.cookieModel[0].func_78793_a(0.0F, -49.0F, 6.0F);
      this.cookieModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 6, 40, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.cookieModel[1].func_78793_a(0.0F, -49.0F, -6.0F);
      this.cookieModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 6, 40, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.cookieModel[2].func_78793_a(6.0F, -49.0F, 0.0F);
      this.cookieModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 6, 40, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.cookieModel[3].func_78793_a(-6.0F, -49.0F, 0.0F);
      this.cookieModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 6, 40, 6, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.cookieModel[4].func_78793_a(-6.0F, -49.0F, -6.0F);
      this.cookieModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 6, 40, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F);
      this.cookieModel[5].func_78793_a(-6.0F, -49.0F, 6.0F);
      this.cookieModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 6, 40, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
      this.cookieModel[6].func_78793_a(6.0F, -49.0F, 6.0F);
      this.cookieModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 6, 40, 6, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.cookieModel[7].func_78793_a(6.0F, -49.0F, -6.0F);
      this.cookieModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 6, 40, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.cookieModel[8].func_78793_a(0.0F, -49.0F, 0.0F);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      for(int i = 0; i < 9; ++i) {
         this.cookieModel[i].func_78785_a(f5);
      }

   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
   }
}
