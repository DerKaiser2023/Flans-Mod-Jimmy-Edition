package com.flansmod.client.model.newBombs;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelMark90 extends ModelBase {
   int textureX = 512;
   int textureY = 512;
   public ModelRendererTurbo[] mark90Model = new ModelRendererTurbo[37];

   public ModelMark90() {
      this.mark90Model[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.mark90Model[1] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.mark90Model[2] = new ModelRendererTurbo(this, 65, 1, this.textureX, this.textureY);
      this.mark90Model[3] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.mark90Model[4] = new ModelRendererTurbo(this, 129, 1, this.textureX, this.textureY);
      this.mark90Model[5] = new ModelRendererTurbo(this, 161, 1, this.textureX, this.textureY);
      this.mark90Model[6] = new ModelRendererTurbo(this, 193, 1, this.textureX, this.textureY);
      this.mark90Model[7] = new ModelRendererTurbo(this, 225, 1, this.textureX, this.textureY);
      this.mark90Model[8] = new ModelRendererTurbo(this, 257, 1, this.textureX, this.textureY);
      this.mark90Model[9] = new ModelRendererTurbo(this, 289, 1, this.textureX, this.textureY);
      this.mark90Model[10] = new ModelRendererTurbo(this, 321, 1, this.textureX, this.textureY);
      this.mark90Model[11] = new ModelRendererTurbo(this, 353, 1, this.textureX, this.textureY);
      this.mark90Model[12] = new ModelRendererTurbo(this, 385, 1, this.textureX, this.textureY);
      this.mark90Model[13] = new ModelRendererTurbo(this, 417, 1, this.textureX, this.textureY);
      this.mark90Model[14] = new ModelRendererTurbo(this, 449, 1, this.textureX, this.textureY);
      this.mark90Model[15] = new ModelRendererTurbo(this, 481, 1, this.textureX, this.textureY);
      this.mark90Model[16] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.mark90Model[17] = new ModelRendererTurbo(this, 33, 25, this.textureX, this.textureY);
      this.mark90Model[18] = new ModelRendererTurbo(this, 65, 25, this.textureX, this.textureY);
      this.mark90Model[19] = new ModelRendererTurbo(this, 97, 25, this.textureX, this.textureY);
      this.mark90Model[20] = new ModelRendererTurbo(this, 129, 25, this.textureX, this.textureY);
      this.mark90Model[21] = new ModelRendererTurbo(this, 161, 25, this.textureX, this.textureY);
      this.mark90Model[22] = new ModelRendererTurbo(this, 193, 25, this.textureX, this.textureY);
      this.mark90Model[23] = new ModelRendererTurbo(this, 225, 25, this.textureX, this.textureY);
      this.mark90Model[24] = new ModelRendererTurbo(this, 257, 25, this.textureX, this.textureY);
      this.mark90Model[25] = new ModelRendererTurbo(this, 305, 17, this.textureX, this.textureY);
      this.mark90Model[26] = new ModelRendererTurbo(this, 337, 17, this.textureX, this.textureY);
      this.mark90Model[27] = new ModelRendererTurbo(this, 281, 25, this.textureX, this.textureY);
      this.mark90Model[28] = new ModelRendererTurbo(this, 361, 25, this.textureX, this.textureY);
      this.mark90Model[29] = new ModelRendererTurbo(this, 393, 25, this.textureX, this.textureY);
      this.mark90Model[30] = new ModelRendererTurbo(this, 425, 25, this.textureX, this.textureY);
      this.mark90Model[31] = new ModelRendererTurbo(this, 457, 25, this.textureX, this.textureY);
      this.mark90Model[32] = new ModelRendererTurbo(this, 481, 33, this.textureX, this.textureY);
      this.mark90Model[33] = new ModelRendererTurbo(this, 353, 41, this.textureX, this.textureY);
      this.mark90Model[34] = new ModelRendererTurbo(this, 385, 41, this.textureX, this.textureY);
      this.mark90Model[35] = new ModelRendererTurbo(this, 417, 41, this.textureX, this.textureY);
      this.mark90Model[36] = new ModelRendererTurbo(this, 449, 41, this.textureX, this.textureY);
      this.mark90Model[0].addShapeBox(0.0F, 0.0F, 0.0F, 6, 16, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[0].func_78793_a(0.0F, -23.0F, 6.0F);
      this.mark90Model[1].addShapeBox(0.0F, 0.0F, 0.0F, 6, 16, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[1].func_78793_a(0.0F, -23.0F, -6.0F);
      this.mark90Model[2].addShapeBox(0.0F, 0.0F, 0.0F, 6, 16, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[2].func_78793_a(6.0F, -23.0F, 0.0F);
      this.mark90Model[3].addShapeBox(0.0F, 0.0F, 0.0F, 6, 16, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[3].func_78793_a(-6.0F, -23.0F, 0.0F);
      this.mark90Model[4].addShapeBox(0.0F, 0.0F, 0.0F, 6, 16, 6, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[4].func_78793_a(-6.0F, -23.0F, -6.0F);
      this.mark90Model[5].addShapeBox(0.0F, 0.0F, 0.0F, 6, 16, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F);
      this.mark90Model[5].func_78793_a(-6.0F, -23.0F, 6.0F);
      this.mark90Model[6].addShapeBox(0.0F, 0.0F, 0.0F, 6, 16, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[6].func_78793_a(6.0F, -23.0F, 6.0F);
      this.mark90Model[7].addShapeBox(0.0F, 0.0F, 0.0F, 6, 16, 6, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[7].func_78793_a(6.0F, -23.0F, -6.0F);
      this.mark90Model[8].addShapeBox(0.0F, 0.0F, 0.0F, 6, 11, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 3.0F, -2.0F, 0.0F, 3.0F, -2.0F, 0.0F, -8.0F, -2.0F, 0.0F, -8.0F);
      this.mark90Model[8].func_78793_a(0.0F, -7.0F, 6.0F);
      this.mark90Model[9].addShapeBox(0.0F, 0.0F, 0.0F, 6, 11, 6, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -8.0F, 0.0F, -8.0F, 2.0F, 0.0F, -8.0F, 2.0F, 0.0F, 2.0F, -8.0F, 0.0F, 2.0F);
      this.mark90Model[9].func_78793_a(-6.0F, -7.0F, -6.0F);
      this.mark90Model[10].addShapeBox(0.0F, 0.0F, 0.0F, 6, 11, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, -8.0F, 0.0F, 2.0F, 2.0F, 0.0F, 2.0F, 2.0F, 0.0F, -8.0F, -8.0F, 0.0F, -8.0F);
      this.mark90Model[10].func_78793_a(-6.0F, -7.0F, 6.0F);
      this.mark90Model[11].addShapeBox(0.0F, 0.0F, 0.0F, 6, 11, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -8.0F, -2.0F, 0.0F, -8.0F, -2.0F, 0.0F, 3.0F, -2.0F, 0.0F, 3.0F);
      this.mark90Model[11].func_78793_a(0.0F, -7.0F, -6.0F);
      this.mark90Model[12].addShapeBox(0.0F, 0.0F, 0.0F, 6, 11, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -8.0F, 0.0F, -2.0F, 3.0F, 0.0F, -2.0F, 3.0F, 0.0F, -2.0F, -8.0F, 0.0F, -2.0F);
      this.mark90Model[12].func_78793_a(-6.0F, -7.0F, 0.0F);
      this.mark90Model[13].addShapeBox(0.0F, 0.0F, 0.0F, 6, 11, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 0.0F, -2.0F, -8.0F, 0.0F, -2.0F, -8.0F, 0.0F, -2.0F, 3.0F, 0.0F, -2.0F);
      this.mark90Model[13].func_78793_a(6.0F, -7.0F, 0.0F);
      this.mark90Model[14].addShapeBox(0.0F, 0.0F, 0.0F, 6, 11, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, -8.0F, 0.0F, 2.0F, -8.0F, 0.0F, -8.0F, 2.0F, 0.0F, -8.0F);
      this.mark90Model[14].func_78793_a(6.0F, -7.0F, 6.0F);
      this.mark90Model[15].addShapeBox(0.0F, 0.0F, 0.0F, 6, 11, 6, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, -8.0F, -8.0F, 0.0F, -8.0F, -8.0F, 0.0F, 2.0F, 2.0F, 0.0F, 2.0F);
      this.mark90Model[15].func_78793_a(6.0F, -7.0F, -6.0F);
      this.mark90Model[16].addShapeBox(0.0F, 0.0F, 0.0F, 6, 22, 6, 0.0F, 2.0F, 0.0F, 2.0F, -8.0F, 0.0F, 2.0F, -8.0F, 0.0F, -8.0F, 2.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[16].func_78793_a(6.0F, -45.0F, 6.0F);
      this.mark90Model[17].addShapeBox(0.0F, 0.0F, 0.0F, 6, 22, 6, 0.0F, 2.0F, 0.0F, -8.0F, -8.0F, 0.0F, -8.0F, -8.0F, 0.0F, 2.0F, 2.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[17].func_78793_a(6.0F, -45.0F, -6.0F);
      this.mark90Model[18].addShapeBox(0.0F, 0.0F, 0.0F, 6, 22, 6, 0.0F, -2.0F, 0.0F, 3.0F, -2.0F, 0.0F, 3.0F, -2.0F, 0.0F, -8.0F, -2.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[18].func_78793_a(0.0F, -45.0F, 6.0F);
      this.mark90Model[19].addShapeBox(0.0F, 0.0F, 0.0F, 6, 22, 6, 0.0F, 3.0F, 0.0F, -2.0F, -8.0F, 0.0F, -2.0F, -8.0F, 0.0F, -2.0F, 3.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[19].func_78793_a(6.0F, -45.0F, 0.0F);
      this.mark90Model[20].addShapeBox(0.0F, 0.0F, 0.0F, 6, 22, 6, 0.0F, -8.0F, 0.0F, 2.0F, 2.0F, 0.0F, 2.0F, 2.0F, 0.0F, -8.0F, -8.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F);
      this.mark90Model[20].func_78793_a(-6.0F, -45.0F, 6.0F);
      this.mark90Model[21].addShapeBox(0.0F, 0.0F, 0.0F, 6, 22, 6, 0.0F, -8.0F, 0.0F, -2.0F, 3.0F, 0.0F, -2.0F, 3.0F, 0.0F, -2.0F, -8.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[21].func_78793_a(-6.0F, -45.0F, 0.0F);
      this.mark90Model[22].addShapeBox(0.0F, 0.0F, 0.0F, 6, 22, 6, 0.0F, -8.0F, 0.0F, -8.0F, 2.0F, 0.0F, -8.0F, 2.0F, 0.0F, 2.0F, -8.0F, 0.0F, 2.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[22].func_78793_a(-6.0F, -45.0F, -6.0F);
      this.mark90Model[23].addShapeBox(0.0F, 0.0F, 0.0F, 6, 22, 6, 0.0F, -2.0F, 0.0F, -8.0F, -2.0F, 0.0F, -8.0F, -2.0F, 0.0F, 3.0F, -2.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[23].func_78793_a(0.0F, -45.0F, -6.0F);
      this.mark90Model[24].addShapeBox(0.0F, 0.0F, 0.0F, 9, 20, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 0.0F, 0.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[24].func_78793_a(-6.0F, -45.0F, 2.5F);
      this.mark90Model[25].addShapeBox(0.0F, 0.0F, 0.0F, 1, 20, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 0.0F, 0.0F, 6.0F, 0.0F);
      this.mark90Model[25].func_78793_a(2.5F, -45.0F, -6.0F);
      this.mark90Model[26].addShapeBox(0.0F, 0.0F, 0.0F, 1, 20, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 0.0F, 0.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[26].func_78793_a(2.5F, -45.0F, 3.0F);
      this.mark90Model[27].addShapeBox(0.0F, 0.0F, 0.0F, 9, 20, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 0.0F);
      this.mark90Model[27].func_78793_a(3.0F, -45.0F, 2.5F);
      this.mark90Model[28].addShapeBox(0.0F, 0.0F, 0.0F, 6, 5, 6, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[28].func_78793_a(6.0F, -45.0F, -6.0F);
      this.mark90Model[29].addShapeBox(0.0F, 0.0F, 0.0F, 6, 5, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[29].func_78793_a(0.0F, -45.0F, -6.0F);
      this.mark90Model[30].addShapeBox(0.0F, 0.0F, 0.0F, 6, 5, 6, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[30].func_78793_a(-6.0F, -45.0F, -6.0F);
      this.mark90Model[31].addShapeBox(0.0F, 0.0F, 0.0F, 6, 5, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[31].func_78793_a(-6.0F, -45.0F, 0.0F);
      this.mark90Model[32].addShapeBox(0.0F, 0.0F, 0.0F, 6, 5, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F);
      this.mark90Model[32].func_78793_a(-6.0F, -45.0F, 6.0F);
      this.mark90Model[33].addShapeBox(0.0F, 0.0F, 0.0F, 6, 5, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[33].func_78793_a(6.0F, -45.0F, 6.0F);
      this.mark90Model[34].addShapeBox(0.0F, 0.0F, 0.0F, 6, 5, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[34].func_78793_a(0.0F, -45.0F, 6.0F);
      this.mark90Model[35].addShapeBox(0.0F, 0.0F, 0.0F, 6, 5, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[35].func_78793_a(6.0F, -45.0F, 0.0F);
      this.mark90Model[36].addShapeBox(0.0F, 0.0F, 0.0F, 6, 5, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.mark90Model[36].func_78793_a(0.0F, -45.0F, 0.0F);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      for(int i = 0; i < 37; ++i) {
         this.mark90Model[i].func_78785_a(f5);
      }

   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
   }
}
