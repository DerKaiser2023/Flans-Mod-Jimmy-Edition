package com.flansmod.client.model.newBombs;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelAIR2 extends ModelBase {
   int textureX = 512;
   int textureY = 512;
   public ModelRendererTurbo[] air2Model = new ModelRendererTurbo[25];

   public ModelAIR2() {
      this.air2Model[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.air2Model[1] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.air2Model[2] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
      this.air2Model[3] = new ModelRendererTurbo(this, 121, 1, this.textureX, this.textureY);
      this.air2Model[4] = new ModelRendererTurbo(this, 161, 1, this.textureX, this.textureY);
      this.air2Model[5] = new ModelRendererTurbo(this, 201, 1, this.textureX, this.textureY);
      this.air2Model[6] = new ModelRendererTurbo(this, 241, 1, this.textureX, this.textureY);
      this.air2Model[7] = new ModelRendererTurbo(this, 281, 1, this.textureX, this.textureY);
      this.air2Model[8] = new ModelRendererTurbo(this, 321, 1, this.textureX, this.textureY);
      this.air2Model[9] = new ModelRendererTurbo(this, 361, 1, this.textureX, this.textureY);
      this.air2Model[10] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.air2Model[11] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.air2Model[12] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.air2Model[13] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.air2Model[14] = new ModelRendererTurbo(this, 385, 1, this.textureX, this.textureY);
      this.air2Model[15] = new ModelRendererTurbo(this, 65, 1, this.textureX, this.textureY);
      this.air2Model[16] = new ModelRendererTurbo(this, 73, 1, this.textureX, this.textureY);
      this.air2Model[17] = new ModelRendererTurbo(this, 409, 1, this.textureX, this.textureY);
      this.air2Model[18] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
      this.air2Model[19] = new ModelRendererTurbo(this, 105, 1, this.textureX, this.textureY);
      this.air2Model[20] = new ModelRendererTurbo(this, 113, 1, this.textureX, this.textureY);
      this.air2Model[21] = new ModelRendererTurbo(this, 433, 1, this.textureX, this.textureY);
      this.air2Model[22] = new ModelRendererTurbo(this, 121, 1, this.textureX, this.textureY);
      this.air2Model[23] = new ModelRendererTurbo(this, 145, 1, this.textureX, this.textureY);
      this.air2Model[24] = new ModelRendererTurbo(this, 153, 1, this.textureX, this.textureY);
      this.air2Model[0].addShapeBox(0.0F, 0.0F, 0.0F, 4, 37, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.air2Model[0].func_78793_a(-2.0F, -27.0F, -6.0F);
      this.air2Model[1].addShapeBox(0.0F, 0.0F, 0.0F, 4, 37, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F);
      this.air2Model[1].func_78793_a(2.0F, -27.0F, -6.0F);
      this.air2Model[2].addShapeBox(0.0F, 0.0F, 0.0F, 4, 37, 12, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F);
      this.air2Model[2].func_78793_a(-6.0F, -27.0F, -6.0F);
      this.air2Model[3].addShapeBox(0.0F, 0.0F, 0.0F, 4, 12, 12, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, -5.0F, 0.0F, -5.0F, 1.0F, 0.0F, -5.0F, 1.0F, 0.0F, -5.0F, -5.0F, 0.0F, -5.0F);
      this.air2Model[3].func_78793_a(-6.0F, 10.0F, -6.0F);
      this.air2Model[4].addShapeBox(0.0F, 0.0F, 0.0F, 4, 12, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -5.0F, -1.0F, 0.0F, -5.0F, -1.0F, 0.0F, -5.0F, -1.0F, 0.0F, -5.0F);
      this.air2Model[4].func_78793_a(-2.0F, 10.0F, -6.0F);
      this.air2Model[5].addShapeBox(0.0F, 0.0F, 0.0F, 4, 12, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, -5.0F, -5.0F, 0.0F, -5.0F, -5.0F, 0.0F, -5.0F, 1.0F, 0.0F, -5.0F);
      this.air2Model[5].func_78793_a(2.0F, 10.0F, -6.0F);
      this.air2Model[6].addShapeBox(0.0F, 0.0F, 0.0F, 4, 16, 12, 0.0F, -3.0F, 0.0F, -5.0F, 1.0F, 0.0F, -3.0F, 1.0F, 0.0F, -3.0F, -3.0F, 0.0F, -5.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F);
      this.air2Model[6].func_78793_a(-6.0F, -43.0F, -6.0F);
      this.air2Model[7].addShapeBox(0.0F, 0.0F, 0.0F, 4, 16, 12, 0.0F, -1.0F, 0.0F, -3.0F, -1.0F, 0.0F, -3.0F, -1.0F, 0.0F, -3.0F, -1.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.air2Model[7].func_78793_a(-2.0F, -43.0F, -6.0F);
      this.air2Model[8].addShapeBox(0.0F, 0.0F, 0.0F, 4, 16, 12, 0.0F, 1.0F, 0.0F, -3.0F, -3.0F, 0.0F, -5.0F, -3.0F, 0.0F, -5.0F, 1.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F);
      this.air2Model[8].func_78793_a(2.0F, -43.0F, -6.0F);
      this.air2Model[9].addShapeBox(0.0F, 0.0F, 0.0F, 1, 24, 7, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -19.0F, 0.0F, 0.0F, -19.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.air2Model[9].func_78793_a(-0.5F, -44.0F, -10.0F);
      this.air2Model[10].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.air2Model[10].func_78793_a(-0.5F, -50.0F, -10.0F);
      this.air2Model[11].addShapeBox(0.0F, 0.0F, 0.0F, 1, 4, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.air2Model[11].func_78793_a(-0.5F, -48.0F, -7.0F);
      this.air2Model[12].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.air2Model[12].func_78793_a(-0.5F, -46.0F, -4.0F);
      this.air2Model[13].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.air2Model[13].func_78793_a(-0.5F, -46.0F, 3.0F);
      this.air2Model[14].addShapeBox(0.0F, 0.0F, 0.0F, 1, 24, 7, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -19.0F, 0.0F, 0.0F, -19.0F, 0.0F);
      this.air2Model[14].func_78793_a(-0.5F, -44.0F, 3.0F);
      this.air2Model[15].addShapeBox(0.0F, 0.0F, 0.0F, 1, 4, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.air2Model[15].func_78793_a(-0.5F, -48.0F, 5.0F);
      this.air2Model[16].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.air2Model[16].func_78793_a(-0.5F, -50.0F, 8.0F);
      this.air2Model[17].addShapeBox(0.0F, 0.0F, 0.0F, 7, 24, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -19.0F, 0.0F, 0.0F, -19.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.air2Model[17].func_78793_a(3.0F, -44.0F, -0.5F);
      this.air2Model[18].addShapeBox(0.0F, 0.0F, 0.0F, 2, 6, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.air2Model[18].func_78793_a(8.0F, -50.0F, -0.5F);
      this.air2Model[19].addShapeBox(0.0F, 0.0F, 0.0F, 2, 4, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.air2Model[19].func_78793_a(5.0F, -48.0F, -0.5F);
      this.air2Model[20].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.air2Model[20].func_78793_a(3.0F, -46.0F, -0.5F);
      this.air2Model[21].addShapeBox(0.0F, 0.0F, 0.0F, 7, 24, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -19.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -19.0F, 0.0F);
      this.air2Model[21].func_78793_a(-10.0F, -44.0F, -0.5F);
      this.air2Model[22].addShapeBox(0.0F, 0.0F, 0.0F, 2, 6, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.air2Model[22].func_78793_a(-10.0F, -50.0F, -0.5F);
      this.air2Model[23].addShapeBox(0.0F, 0.0F, 0.0F, 2, 4, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.air2Model[23].func_78793_a(-7.0F, -48.0F, -0.5F);
      this.air2Model[24].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.air2Model[24].func_78793_a(-4.0F, -46.0F, -0.5F);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      for(int i = 0; i < 25; ++i) {
         this.air2Model[i].func_78785_a(f5);
      }

   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
   }
}
