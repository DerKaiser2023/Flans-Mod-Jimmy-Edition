package com.flansmod.client.model.newBombs;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelCBU87 extends ModelBase {
   int textureX = 512;
   int textureY = 512;
   public ModelRendererTurbo[] cbu87Model = new ModelRendererTurbo[13];

   public ModelCBU87() {
      this.cbu87Model[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.cbu87Model[1] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.cbu87Model[2] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
      this.cbu87Model[3] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
      this.cbu87Model[4] = new ModelRendererTurbo(this, 105, 1, this.textureX, this.textureY);
      this.cbu87Model[5] = new ModelRendererTurbo(this, 137, 1, this.textureX, this.textureY);
      this.cbu87Model[6] = new ModelRendererTurbo(this, 161, 1, this.textureX, this.textureY);
      this.cbu87Model[7] = new ModelRendererTurbo(this, 185, 1, this.textureX, this.textureY);
      this.cbu87Model[8] = new ModelRendererTurbo(this, 217, 1, this.textureX, this.textureY);
      this.cbu87Model[9] = new ModelRendererTurbo(this, 241, 1, this.textureX, this.textureY);
      this.cbu87Model[10] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.cbu87Model[11] = new ModelRendererTurbo(this, 257, 1, this.textureX, this.textureY);
      this.cbu87Model[12] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.cbu87Model[0].addShapeBox(0.0F, 0.0F, 0.0F, 4, 35, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.cbu87Model[0].func_78793_a(-2.0F, -17.0F, -4.0F);
      this.cbu87Model[1].addShapeBox(0.0F, 0.0F, 0.0F, 2, 35, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
      this.cbu87Model[1].func_78793_a(2.0F, -17.0F, -4.0F);
      this.cbu87Model[2].addShapeBox(0.0F, 0.0F, 0.0F, 2, 35, 8, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F);
      this.cbu87Model[2].func_78793_a(-4.0F, -17.0F, -4.0F);
      this.cbu87Model[3].addShapeBox(0.0F, 0.0F, 0.0F, 2, 2, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, 1.0F, 0.0F, -3.0F);
      this.cbu87Model[3].func_78793_a(2.0F, 18.0F, -4.0F);
      this.cbu87Model[4].addShapeBox(0.0F, 0.0F, 0.0F, 4, 2, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -3.0F, -1.0F, 0.0F, -3.0F, -1.0F, 0.0F, -3.0F, -1.0F, 0.0F, -3.0F);
      this.cbu87Model[4].func_78793_a(-2.0F, 18.0F, -4.0F);
      this.cbu87Model[5].addShapeBox(0.0F, 0.0F, 0.0F, 2, 2, 8, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, -3.0F, 0.0F, -3.0F, 1.0F, 0.0F, -3.0F, 1.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F);
      this.cbu87Model[5].func_78793_a(-4.0F, 18.0F, -4.0F);
      this.cbu87Model[6].addShapeBox(0.0F, 0.0F, 0.0F, 2, 5, 8, 0.0F, 1.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, 1.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
      this.cbu87Model[6].func_78793_a(2.0F, -22.0F, -4.0F);
      this.cbu87Model[7].addShapeBox(0.0F, 0.0F, 0.0F, 4, 5, 8, 0.0F, -1.0F, 0.0F, -3.0F, -1.0F, 0.0F, -3.0F, -1.0F, 0.0F, -3.0F, -1.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.cbu87Model[7].func_78793_a(-2.0F, -22.0F, -4.0F);
      this.cbu87Model[8].addShapeBox(0.0F, 0.0F, 0.0F, 2, 5, 8, 0.0F, -3.0F, 0.0F, -3.0F, 1.0F, 0.0F, -3.0F, 1.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F);
      this.cbu87Model[8].func_78793_a(-4.0F, -22.0F, -4.0F);
      this.cbu87Model[9].addShapeBox(0.0F, 0.0F, 0.0F, 1, 5, 3, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.cbu87Model[9].func_78793_a(-0.5F, -22.0F, -4.0F);
      this.cbu87Model[10].addShapeBox(0.0F, 0.0F, 0.0F, 3, 5, 1, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.cbu87Model[10].func_78793_a(-4.0F, -22.0F, -0.5F);
      this.cbu87Model[11].addShapeBox(0.0F, 0.0F, 0.0F, 1, 5, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.cbu87Model[11].func_78793_a(-0.5F, -22.0F, 1.0F);
      this.cbu87Model[12].addShapeBox(0.0F, 0.0F, 0.0F, 3, 5, 1, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.cbu87Model[12].func_78793_a(1.0F, -22.0F, -0.5F);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      for(int i = 0; i < 13; ++i) {
         this.cbu87Model[i].func_78785_a(f5);
      }

   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
   }
}
