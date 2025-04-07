package com.flansmod.client.model.newBombs;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelLittleboy extends ModelBase {
   int textureX = 128;
   int textureY = 128;
   public ModelRendererTurbo[] littleboyModel = new ModelRendererTurbo[19];

   public ModelLittleboy() {
      this.littleboyModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.littleboyModel[1] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.littleboyModel[2] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
      this.littleboyModel[3] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
      this.littleboyModel[4] = new ModelRendererTurbo(this, 97, 9, this.textureX, this.textureY);
      this.littleboyModel[5] = new ModelRendererTurbo(this, 81, 17, this.textureX, this.textureY);
      this.littleboyModel[6] = new ModelRendererTurbo(this, 97, 25, this.textureX, this.textureY);
      this.littleboyModel[7] = new ModelRendererTurbo(this, 1, 41, this.textureX, this.textureY);
      this.littleboyModel[8] = new ModelRendererTurbo(this, 73, 33, this.textureX, this.textureY);
      this.littleboyModel[9] = new ModelRendererTurbo(this, 33, 41, this.textureX, this.textureY);
      this.littleboyModel[10] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.littleboyModel[11] = new ModelRendererTurbo(this, 41, 41, this.textureX, this.textureY);
      this.littleboyModel[12] = new ModelRendererTurbo(this, 97, 49, this.textureX, this.textureY);
      this.littleboyModel[13] = new ModelRendererTurbo(this, 57, 49, this.textureX, this.textureY);
      this.littleboyModel[14] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.littleboyModel[15] = new ModelRendererTurbo(this, 57, 41, this.textureX, this.textureY);
      this.littleboyModel[16] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.littleboyModel[17] = new ModelRendererTurbo(this, 33, 57, this.textureX, this.textureY);
      this.littleboyModel[18] = new ModelRendererTurbo(this, 81, 57, this.textureX, this.textureY);
      this.littleboyModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 5, 25, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.littleboyModel[0].func_78793_a(0.0F, -8.0F, 0.5F);
      this.littleboyModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 2, 25, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
      this.littleboyModel[1].func_78793_a(5.0F, -8.0F, 0.5F);
      this.littleboyModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 2, 25, 9, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F);
      this.littleboyModel[2].func_78793_a(-2.0F, -8.0F, 0.5F);
      this.littleboyModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 2, 2, 9, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, -3.0F, 0.0F, -3.0F, 1.0F, 0.0F, -3.0F, 1.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F);
      this.littleboyModel[3].func_78793_a(-2.0F, 17.0F, 0.5F);
      this.littleboyModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 5, 2, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -3.0F, -1.0F, 0.0F, -3.0F, -1.0F, 0.0F, -3.0F, -1.0F, 0.0F, -3.0F);
      this.littleboyModel[4].func_78793_a(0.0F, 17.0F, 0.5F);
      this.littleboyModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 2, 2, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, 1.0F, 0.0F, -3.0F);
      this.littleboyModel[5].func_78793_a(5.0F, 17.0F, 0.5F);
      this.littleboyModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 2, 8, 9, 0.0F, 2.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, 2.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
      this.littleboyModel[6].func_78793_a(5.0F, -16.0F, 0.5F);
      this.littleboyModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 5, 8, 9, 0.0F, -2.0F, 0.0F, -3.0F, -2.0F, 0.0F, -3.0F, -2.0F, 0.0F, -3.0F, -2.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.littleboyModel[7].func_78793_a(0.0F, -16.0F, 0.5F);
      this.littleboyModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 2, 8, 9, 0.0F, -3.0F, 0.0F, -3.0F, 2.0F, 0.0F, -3.0F, 2.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F);
      this.littleboyModel[8].func_78793_a(-2.0F, -16.0F, 0.5F);
      this.littleboyModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 3, 7, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.littleboyModel[9].func_78793_a(1.0F, -23.0F, 3.5F);
      this.littleboyModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 12, 5, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.littleboyModel[10].func_78793_a(-4.0F, -27.0F, 10.0F);
      this.littleboyModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 1, 5, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.littleboyModel[11].func_78793_a(-4.0F, -27.0F, -1.0F);
      this.littleboyModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 12, 5, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.littleboyModel[12].func_78793_a(-4.0F, -27.0F, -1.0F);
      this.littleboyModel[13].addShapeBox(0.0F, 0.0F, 0.0F, 1, 5, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.littleboyModel[13].func_78793_a(7.0F, -27.0F, -1.0F);
      this.littleboyModel[14].addShapeBox(0.0F, 0.0F, 0.0F, 2, 7, 1, 0.0F, 0.0F, 0.0F, -0.5F, 0.5F, 4.0F, 3.5F, 1.0F, 4.0F, -4.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.5F, -6.0F, 3.5F, 1.0F, -6.0F, -4.0F, -0.5F, 0.0F, 0.0F);
      this.littleboyModel[14].func_78793_a(3.5F, -23.0F, 3.0F);
      this.littleboyModel[15].addShapeBox(0.0F, 0.0F, 0.0F, 1, 7, 4, 0.0F, 3.5F, 4.0F, 0.5F, -4.0F, 4.0F, 1.0F, 0.0F, 0.0F, -0.5F, -0.5F, 0.0F, 0.0F, 3.5F, -6.0F, 0.5F, -4.0F, -6.0F, 1.0F, 0.0F, 0.0F, -0.5F, -0.5F, 0.0F, 0.0F);
      this.littleboyModel[15].func_78793_a(0.5F, -23.0F, 0.0F);
      this.littleboyModel[16].addShapeBox(0.0F, 0.0F, 0.0F, 2, 7, 1, 0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 4.0F, -4.0F, 0.5F, 4.0F, 3.5F, 0.0F, 0.0F, -0.5F, -0.5F, 0.0F, 0.0F, 1.0F, -6.0F, -4.0F, 0.5F, -6.0F, 3.5F, 0.0F, 0.0F, -0.5F);
      this.littleboyModel[16].func_78793_a(3.5F, -23.0F, 6.0F);
      this.littleboyModel[17].addShapeBox(0.0F, 0.0F, 0.0F, 1, 7, 4, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -4.0F, 4.0F, 1.0F, 3.5F, 4.0F, 0.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -4.0F, -6.0F, 1.0F, 3.5F, -6.0F, 0.5F);
      this.littleboyModel[17].func_78793_a(0.5F, -23.0F, 6.0F);
      this.littleboyModel[18].addShapeBox(0.0F, 0.0F, 0.0F, 10, 1, 10, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.littleboyModel[18].func_78793_a(-3.0F, -27.0F, 0.0F);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      for(int i = 0; i < 19; ++i) {
         this.littleboyModel[i].func_78785_a(f5);
      }

   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
   }
}
