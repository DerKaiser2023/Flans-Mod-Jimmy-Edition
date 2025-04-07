package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelJingasa extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 64;

   public ModelJingasa() {
      this.headModel = new ModelRendererTurbo[26];
      this.initheadModel_1();
   }

   private void initheadModel_1() {
      this.headModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[1] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.headModel[2] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[3] = new ModelRendererTurbo(this, 73, 1, this.textureX, this.textureY);
      this.headModel[4] = new ModelRendererTurbo(this, 73, 9, this.textureX, this.textureY);
      this.headModel[5] = new ModelRendererTurbo(this, 97, 9, this.textureX, this.textureY);
      this.headModel[6] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.headModel[7] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.headModel[8] = new ModelRendererTurbo(this, 105, 1, this.textureX, this.textureY);
      this.headModel[9] = new ModelRendererTurbo(this, 25, 17, this.textureX, this.textureY);
      this.headModel[10] = new ModelRendererTurbo(this, 41, 17, this.textureX, this.textureY);
      this.headModel[11] = new ModelRendererTurbo(this, 49, 17, this.textureX, this.textureY);
      this.headModel[12] = new ModelRendererTurbo(this, 73, 17, this.textureX, this.textureY);
      this.headModel[13] = new ModelRendererTurbo(this, 97, 25, this.textureX, this.textureY);
      this.headModel[14] = new ModelRendererTurbo(this, 121, 1, this.textureX, this.textureY);
      this.headModel[15] = new ModelRendererTurbo(this, 33, 9, this.textureX, this.textureY);
      this.headModel[16] = new ModelRendererTurbo(this, 121, 9, this.textureX, this.textureY);
      this.headModel[17] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.headModel[18] = new ModelRendererTurbo(this, 65, 17, this.textureX, this.textureY);
      this.headModel[19] = new ModelRendererTurbo(this, 73, 17, this.textureX, this.textureY);
      this.headModel[20] = new ModelRendererTurbo(this, 89, 17, this.textureX, this.textureY);
      this.headModel[21] = new ModelRendererTurbo(this, 33, 25, this.textureX, this.textureY);
      this.headModel[22] = new ModelRendererTurbo(this, 1, 33, this.textureX, this.textureY);
      this.headModel[23] = new ModelRendererTurbo(this, 41, 25, this.textureX, this.textureY);
      this.headModel[24] = new ModelRendererTurbo(this, 33, 33, this.textureX, this.textureY);
      this.headModel[25] = new ModelRendererTurbo(this, 1, 41, this.textureX, this.textureY);
      this.headModel[0].addShapeBox(-4.0F, -8.0F, -4.0F, 8, 1, 8, 0.0F, 0.2F, 0.3F, 0.0F, 0.2F, 0.3F, 0.0F, 0.2F, -0.1F, 0.1F, 0.2F, -0.1F, 0.1F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.1F, 0.9F, 0.9F, -0.1F, 0.9F);
      this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[1].addShapeBox(-4.0F, -9.8F, -4.0F, 8, 1, 8, 0.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, -0.4F, -1.8F, -2.0F, -0.4F, -1.8F, 0.2F, 0.5F, 0.0F, 0.2F, 0.5F, 0.0F, 0.2F, 0.9F, 0.1F, 0.2F, 0.9F, 0.1F);
      this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[2].addShapeBox(-0.5F, -10.8F, -0.5F, 1, 1, 1, 0.0F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 1.5F, 0.0F, 1.5F, 1.5F, 0.0F, 1.5F, 1.5F, 0.4F, 1.7F, 1.5F, 0.4F, 1.7F);
      this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[3].addShapeBox(-5.0F, -6.7F, -7.8F, 10, 2, 3, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
      this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[4].addShapeBox(-5.0F, -6.3F, 4.8F, 10, 2, 3, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
      this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[5].addShapeBox(4.9F, -6.7F, -4.8F, 3, 2, 10, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.9F, -0.3F, 0.0F, 0.4F, -0.3F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, 0.1F, -0.3F, 0.0F, 0.1F, -0.3F);
      this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[6].addShapeBox(-7.9F, -6.7F, -4.8F, 3, 2, 10, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, 0.4F, -0.3F, 0.0F, -1.9F, -0.3F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, 0.1F, -0.3F, 0.0F, 0.1F, -0.3F);
      this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[7].addShapeBox(-8.01F, -6.7F, -7.8F, 3, 2, 3, 0.0F, -1.0F, -1.5F, -1.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, -1.5F, 0.0F, -1.0F, -0.3F, -1.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
      this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[8].addShapeBox(5.01F, -6.7F, -7.8F, 3, 2, 3, 0.0F, 0.0F, -1.5F, 0.0F, -1.0F, -1.5F, -1.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, -0.3F, 0.0F, -1.0F, -0.3F, -1.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
      this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[9].addShapeBox(5.01F, -6.3F, 4.91F, 3, 2, 3, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, -1.5F, 0.0F, -1.0F, -1.5F, -1.0F, 0.0F, -1.5F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, -1.0F, -0.3F, -1.0F, 0.0F, -0.3F, 0.0F);
      this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[10].addShapeBox(-8.01F, -6.3F, 4.91F, 3, 2, 3, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, -1.5F, 0.0F, -1.0F, -1.5F, -1.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, -1.0F, -0.3F, -1.0F);
      this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[11].addShapeBox(-5.5F, -6.0F, -4.8F, 1, 6, 10, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F);
      this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[12].addShapeBox(4.5F, -6.0F, -4.8F, 1, 6, 10, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F);
      this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[13].addShapeBox(-5.5F, -5.0F, 4.8F, 11, 7, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
      this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[14].addShapeBox(-5.51F, 0.0F, -2.8F, 1, 2, 1, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, -1.8F, 0.0F, -0.3F, -1.8F, 0.0F);
      this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[15].addShapeBox(-5.5F, 0.0F, -4.81F, 1, 2, 2, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F);
      this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[16].addShapeBox(4.5F, 0.01F, -2.8F, 1, 2, 1, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, -1.8F, 0.0F, -0.3F, -1.8F, 0.0F);
      this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[17].addShapeBox(4.5F, 0.0F, -4.81F, 1, 2, 2, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F);
      this.headModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[18].addShapeBox(4.5F, 0.0F, 2.0F, 1, 2, 1, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, -1.8F, 0.0F, -0.3F, -1.8F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F);
      this.headModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[19].addShapeBox(4.51F, 0.0F, 3.0F, 1, 2, 2, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.3F, -0.3F, 0.0F, 0.3F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.3F, -0.3F, 0.0F, 0.3F);
      this.headModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[20].addShapeBox(-5.5F, 0.0F, 3.0F, 1, 2, 2, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.3F, -0.3F, 0.0F, 0.3F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.3F, -0.3F, 0.0F, 0.3F);
      this.headModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[21].addShapeBox(-5.5F, 0.0F, 2.0F, 1, 2, 1, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, -1.8F, 0.0F, -0.3F, -1.8F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F);
      this.headModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[22].addShapeBox(-5.5F, 2.0F, 4.8F, 11, 2, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -2.3F, 0.0F, -0.3F, -2.3F, 0.0F, -0.3F, -2.3F, 0.0F, -0.3F, -2.3F, 0.0F, -0.3F);
      this.headModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[23].addShapeBox(4.5F, 2.01F, 3.0F, 1, 2, 2, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.3F, -0.3F, 0.0F, 0.3F, -0.3F, -1.8F, 0.0F, -0.3F, -1.8F, 0.0F, -2.3F, 0.0F, 0.3F, 1.7F, 0.0F, 0.3F);
      this.headModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[24].addShapeBox(-5.5F, 2.01F, 3.0F, 1, 2, 2, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.3F, -0.3F, 0.0F, 0.3F, -0.3F, -1.8F, 0.0F, -0.3F, -1.8F, 0.0F, 1.7F, 0.0F, 0.3F, -2.3F, 0.0F, 0.3F);
      this.headModel[24].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[25].addShapeBox(-4.5F, -6.8F, -4.2F, 9, 7, 1, 0.0F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
      this.headModel[25].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
