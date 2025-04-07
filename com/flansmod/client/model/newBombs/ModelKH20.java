package com.flansmod.client.model.newBombs;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelKH20 extends ModelBase {
   int textureX = 512;
   int textureY = 512;
   public ModelRendererTurbo[] kh20Model = new ModelRendererTurbo[34];

   public ModelKH20() {
      this.kh20Model[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.kh20Model[1] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.kh20Model[2] = new ModelRendererTurbo(this, 65, 1, this.textureX, this.textureY);
      this.kh20Model[3] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.kh20Model[4] = new ModelRendererTurbo(this, 129, 1, this.textureX, this.textureY);
      this.kh20Model[5] = new ModelRendererTurbo(this, 161, 1, this.textureX, this.textureY);
      this.kh20Model[6] = new ModelRendererTurbo(this, 193, 1, this.textureX, this.textureY);
      this.kh20Model[7] = new ModelRendererTurbo(this, 225, 1, this.textureX, this.textureY);
      this.kh20Model[8] = new ModelRendererTurbo(this, 257, 1, this.textureX, this.textureY);
      this.kh20Model[9] = new ModelRendererTurbo(this, 289, 1, this.textureX, this.textureY);
      this.kh20Model[10] = new ModelRendererTurbo(this, 321, 1, this.textureX, this.textureY);
      this.kh20Model[11] = new ModelRendererTurbo(this, 353, 1, this.textureX, this.textureY);
      this.kh20Model[12] = new ModelRendererTurbo(this, 385, 1, this.textureX, this.textureY);
      this.kh20Model[13] = new ModelRendererTurbo(this, 417, 1, this.textureX, this.textureY);
      this.kh20Model[14] = new ModelRendererTurbo(this, 449, 1, this.textureX, this.textureY);
      this.kh20Model[15] = new ModelRendererTurbo(this, 481, 1, this.textureX, this.textureY);
      this.kh20Model[16] = new ModelRendererTurbo(this, 257, 25, this.textureX, this.textureY);
      this.kh20Model[17] = new ModelRendererTurbo(this, 289, 25, this.textureX, this.textureY);
      this.kh20Model[18] = new ModelRendererTurbo(this, 321, 25, this.textureX, this.textureY);
      this.kh20Model[19] = new ModelRendererTurbo(this, 353, 25, this.textureX, this.textureY);
      this.kh20Model[20] = new ModelRendererTurbo(this, 385, 25, this.textureX, this.textureY);
      this.kh20Model[21] = new ModelRendererTurbo(this, 417, 25, this.textureX, this.textureY);
      this.kh20Model[22] = new ModelRendererTurbo(this, 449, 25, this.textureX, this.textureY);
      this.kh20Model[23] = new ModelRendererTurbo(this, 481, 25, this.textureX, this.textureY);
      this.kh20Model[24] = new ModelRendererTurbo(this, 257, 49, this.textureX, this.textureY);
      this.kh20Model[25] = new ModelRendererTurbo(this, 1, 57, this.textureX, this.textureY);
      this.kh20Model[26] = new ModelRendererTurbo(this, 33, 57, this.textureX, this.textureY);
      this.kh20Model[27] = new ModelRendererTurbo(this, 33, 57, this.textureX, this.textureY);
      this.kh20Model[28] = new ModelRendererTurbo(this, 153, 65, this.textureX, this.textureY);
      this.kh20Model[29] = new ModelRendererTurbo(this, 97, 33, this.textureX, this.textureY);
      this.kh20Model[30] = new ModelRendererTurbo(this, 65, 57, this.textureX, this.textureY);
      this.kh20Model[31] = new ModelRendererTurbo(this, 289, 73, this.textureX, this.textureY);
      this.kh20Model[32] = new ModelRendererTurbo(this, 161, 57, this.textureX, this.textureY);
      this.kh20Model[33] = new ModelRendererTurbo(this, 177, 57, this.textureX, this.textureY);
      this.kh20Model[0].addShapeBox(0.0F, 0.0F, 0.0F, 6, 49, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[0].func_78793_a(0.0F, -45.0F, 6.0F);
      this.kh20Model[1].addShapeBox(0.0F, 0.0F, 0.0F, 6, 49, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[1].func_78793_a(0.0F, -45.0F, -6.0F);
      this.kh20Model[2].addShapeBox(0.0F, 0.0F, 0.0F, 6, 49, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[2].func_78793_a(6.0F, -45.0F, 0.0F);
      this.kh20Model[3].addShapeBox(0.0F, 0.0F, 0.0F, 6, 49, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[3].func_78793_a(-6.0F, -45.0F, 0.0F);
      this.kh20Model[4].addShapeBox(0.0F, 0.0F, 0.0F, 6, 49, 6, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[4].func_78793_a(-6.0F, -45.0F, -6.0F);
      this.kh20Model[5].addShapeBox(0.0F, 0.0F, 0.0F, 6, 49, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F);
      this.kh20Model[5].func_78793_a(-6.0F, -45.0F, 6.0F);
      this.kh20Model[6].addShapeBox(0.0F, 0.0F, 0.0F, 6, 49, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[6].func_78793_a(6.0F, -45.0F, 6.0F);
      this.kh20Model[7].addShapeBox(0.0F, 0.0F, 0.0F, 6, 49, 6, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[7].func_78793_a(6.0F, -45.0F, -6.0F);
      this.kh20Model[8].addShapeBox(0.0F, 0.0F, 0.0F, 6, 17, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F);
      this.kh20Model[8].func_78793_a(0.0F, 4.0F, 6.0F);
      this.kh20Model[9].addShapeBox(0.0F, 0.0F, 0.0F, 6, 17, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, -5.5F, 0.0F, -5.5F);
      this.kh20Model[9].func_78793_a(-6.0F, 4.0F, 6.0F);
      this.kh20Model[10].addShapeBox(0.0F, 0.0F, 0.0F, 6, 17, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.5F, 0.0F, -5.5F, 0.0F, 0.0F, -5.0F);
      this.kh20Model[10].func_78793_a(6.0F, 4.0F, 6.0F);
      this.kh20Model[11].addShapeBox(0.0F, 0.0F, 0.0F, 6, 17, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[11].func_78793_a(0.0F, 4.0F, -6.0F);
      this.kh20Model[12].addShapeBox(0.0F, 0.0F, 0.0F, 6, 17, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[12].func_78793_a(6.0F, 4.0F, 0.0F);
      this.kh20Model[13].addShapeBox(0.0F, 0.0F, 0.0F, 6, 17, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F);
      this.kh20Model[13].func_78793_a(-6.0F, 4.0F, 0.0F);
      this.kh20Model[14].addShapeBox(0.0F, 0.0F, 0.0F, 6, 17, 6, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.5F, 0.0F, -5.5F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F);
      this.kh20Model[14].func_78793_a(-6.0F, 4.0F, -6.0F);
      this.kh20Model[15].addShapeBox(0.0F, 0.0F, 0.0F, 6, 17, 6, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, -5.5F, 0.0F, -5.5F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[15].func_78793_a(6.0F, 4.0F, -6.0F);
      this.kh20Model[16].addShapeBox(0.0F, 0.0F, 0.0F, 6, 11, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F);
      this.kh20Model[16].func_78793_a(0.0F, 15.0F, 0.0F);
      this.kh20Model[17].addShapeBox(0.0F, 0.0F, 0.0F, 6, 35, 6, 0.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[17].func_78793_a(0.0F, -102.0F, 0.0F);
      this.kh20Model[18].addShapeBox(0.0F, 0.0F, 0.0F, 6, 62, 6, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.5F, 0.0F, -5.5F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[18].func_78793_a(6.0F, -107.0F, 6.0F);
      this.kh20Model[19].addShapeBox(0.0F, 0.0F, 0.0F, 6, 62, 6, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[19].func_78793_a(6.0F, -107.0F, 0.0F);
      this.kh20Model[20].addShapeBox(0.0F, 0.0F, 0.0F, 6, 62, 6, 0.0F, 0.0F, 0.0F, -5.0F, -5.5F, 0.0F, -5.5F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[20].func_78793_a(6.0F, -107.0F, -6.0F);
      this.kh20Model[21].addShapeBox(0.0F, 0.0F, 0.0F, 6, 62, 6, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[21].func_78793_a(0.0F, -107.0F, -6.0F);
      this.kh20Model[22].addShapeBox(0.0F, 0.0F, 0.0F, 6, 62, 6, 0.0F, -5.5F, 0.0F, -5.5F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[22].func_78793_a(-6.0F, -107.0F, -6.0F);
      this.kh20Model[23].addShapeBox(0.0F, 0.0F, 0.0F, 6, 62, 6, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[23].func_78793_a(-6.0F, -107.0F, 0.0F);
      this.kh20Model[24].addShapeBox(0.0F, 0.0F, 0.0F, 6, 62, 6, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, -5.5F, 0.0F, -5.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F);
      this.kh20Model[24].func_78793_a(-6.0F, -107.0F, 6.0F);
      this.kh20Model[25].addShapeBox(0.0F, 0.0F, 0.0F, 6, 62, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[25].func_78793_a(0.0F, -107.0F, 6.0F);
      this.kh20Model[26].addShapeBox(0.0F, 0.0F, 0.0F, 6, 8, 6, 0.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[26].func_78793_a(0.0F, -88.0F, 0.0F);
      this.kh20Model[27].addShapeBox(0.0F, 0.0F, 0.0F, 1, 35, 55, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 28.0F, 0.0F, 0.0F, 28.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -52.0F, 0.0F, 0.0F, -52.0F, 0.0F);
      this.kh20Model[27].func_78793_a(2.0F, -31.0F, 12.0F);
      this.kh20Model[28].addShapeBox(0.0F, 0.0F, 0.0F, 1, 35, 55, 0.0F, 0.0F, 28.0F, 0.0F, 0.0F, 28.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -52.0F, 0.0F, 0.0F, -52.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[28].func_78793_a(2.0F, -31.0F, -61.0F);
      this.kh20Model[29].addShapeBox(0.0F, 0.0F, 0.0F, 1, 24, 28, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 11.0F, 0.0F, 0.0F, 11.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -25.0F, 0.0F, 0.0F, -25.0F, 0.0F);
      this.kh20Model[29].func_78793_a(1.0F, -94.0F, 7.0F);
      this.kh20Model[30].addShapeBox(0.0F, 0.0F, 0.0F, 2, 18, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[30].func_78793_a(0.5F, -105.0F, 34.0F);
      this.kh20Model[31].addShapeBox(0.0F, 0.0F, 0.0F, 1, 24, 28, 0.0F, 0.0F, 11.0F, 0.0F, 0.0F, 11.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -25.0F, 0.0F, 0.0F, -25.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[31].func_78793_a(1.0F, -94.0F, -29.0F);
      this.kh20Model[32].addShapeBox(0.0F, 0.0F, 0.0F, 2, 18, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.kh20Model[32].func_78793_a(0.5F, -105.0F, -30.0F);
      this.kh20Model[33].addShapeBox(0.0F, 0.0F, 0.0F, 11, 24, 1, 0.0F, 0.0F, 11.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 11.0F, 0.0F, 0.0F, -25.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -25.0F, 0.0F);
      this.kh20Model[33].func_78793_a(-13.0F, -94.0F, 2.5F);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      for(int i = 0; i < 34; ++i) {
         this.kh20Model[i].func_78785_a(f5);
      }

   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
   }
}
