package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelBurgonetBuffe extends ModelCustomArmour {
   int textureX = 64;
   int textureY = 128;

   public ModelBurgonetBuffe() {
      this.headModel = new ModelRendererTurbo[22];
      this.initheadModel_1();
   }

   private void initheadModel_1() {
      this.headModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[1] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.headModel[2] = new ModelRendererTurbo(this, 25, 9, this.textureX, this.textureY);
      this.headModel[3] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.headModel[4] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.headModel[5] = new ModelRendererTurbo(this, 33, 25, this.textureX, this.textureY);
      this.headModel[6] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.headModel[7] = new ModelRendererTurbo(this, 49, 25, this.textureX, this.textureY);
      this.headModel[8] = new ModelRendererTurbo(this, 1, 33, this.textureX, this.textureY);
      this.headModel[9] = new ModelRendererTurbo(this, 17, 33, this.textureX, this.textureY);
      this.headModel[10] = new ModelRendererTurbo(this, 33, 33, this.textureX, this.textureY);
      this.headModel[11] = new ModelRendererTurbo(this, 49, 33, this.textureX, this.textureY);
      this.headModel[12] = new ModelRendererTurbo(this, 17, 41, this.textureX, this.textureY);
      this.headModel[13] = new ModelRendererTurbo(this, 33, 41, this.textureX, this.textureY);
      this.headModel[14] = new ModelRendererTurbo(this, 33, 49, this.textureX, this.textureY);
      this.headModel[15] = new ModelRendererTurbo(this, 1, 49, this.textureX, this.textureY);
      this.headModel[16] = new ModelRendererTurbo(this, 17, 57, this.textureX, this.textureY);
      this.headModel[17] = new ModelRendererTurbo(this, 1, 49, this.textureX, this.textureY);
      this.headModel[18] = new ModelRendererTurbo(this, 33, 57, this.textureX, this.textureY);
      this.headModel[19] = new ModelRendererTurbo(this, 41, 41, this.textureX, this.textureY);
      this.headModel[20] = new ModelRendererTurbo(this, 1, 73, this.textureX, this.textureY);
      this.headModel[21] = new ModelRendererTurbo(this, 41, 65, this.textureX, this.textureY);
      this.headModel[0].addShapeBox(-3.5F, -8.0F, -3.5F, 7, 2, 8, 0.0F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.5F, 0.2F, 0.3F, 0.5F, 0.5F, -0.5F, 1.5F, 0.5F, -0.5F, 1.5F, 0.5F, -0.5F, 1.2F, 0.5F, -0.5F, 1.2F);
      this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[1].addShapeBox(4.2F, -4.0F, 1.0F, 2, 4, 3, 0.0F, 0.5F, 0.0F, 2.5F, -1.3F, 0.0F, 2.5F, -1.2F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 1.0F, -1.2F, 0.0F, 1.0F, -1.6F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F);
      this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[2].addShapeBox(-4.5F, -9.8F, -3.0F, 9, 1, 8, 0.0F, -1.0F, 0.0F, -2.0F, -1.0F, 0.0F, -2.0F, -1.0F, 0.0F, -1.5F, -1.0F, 0.0F, -1.5F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 0.8F, 0.2F, 0.5F, 0.0F, 0.2F, 0.5F, 0.0F);
      this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[3].addShapeBox(-2.5F, -7.0F, -5.0F, 5, 3, 10, 0.0F, 0.5F, -0.5F, 0.0F, 0.5F, -0.5F, 0.0F, 0.5F, -0.5F, 0.7F, 0.5F, -0.5F, 0.7F, 0.5F, -0.5F, 0.5F, 0.5F, -0.5F, 0.5F, 0.5F, 0.0F, 0.8F, 0.5F, 0.0F, 0.8F);
      this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[4].addShapeBox(-4.5F, -4.5F, 3.8F, 9, 4, 2, 0.0F, 0.5F, -0.5F, 0.0F, 0.5F, -0.5F, 0.0F, 0.5F, -0.5F, 0.0F, 0.5F, -0.5F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.0F, 0.5F, -1.0F, -1.0F, 0.5F, -1.0F, -1.0F);
      this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[5].addShapeBox(-4.5F, -4.0F, 1.0F, 2, 4, 3, 0.0F, 0.4F, 0.0F, 2.5F, -1.2F, 0.0F, 2.5F, -1.2F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 1.0F, -1.2F, 0.0F, 1.0F, -1.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[6].addShapeBox(3.5F, -7.0F, -5.0F, 1, 3, 3, 0.0F, 0.5F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.5F, -0.5F, 0.7F, 0.5F, -0.5F, 0.7F, 0.5F, -0.5F, 0.5F, 0.0F, -0.5F, 0.3F, 0.5F, 0.0F, 0.7F, 0.5F, 0.0F, 0.7F);
      this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[7].addShapeBox(3.5F, -8.0F, -3.5F, 1, 2, 3, 0.0F, 0.2F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, -0.5F, 0.2F, 0.3F, 0.0F, 0.5F, -0.5F, 1.5F, 0.0F, -0.5F, 1.5F, 0.5F, -0.5F, -0.5F, 0.5F, -0.5F, 0.7F);
      this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[8].addShapeBox(3.5F, -7.0F, -1.0F, 1, 3, 6, 0.0F, 0.5F, -0.5F, 0.5F, 0.5F, -0.5F, 0.3F, 0.5F, -0.5F, 0.7F, 0.5F, -0.5F, 0.7F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.8F, 0.5F, 0.0F, 0.8F);
      this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[9].addShapeBox(3.5F, -8.0F, 1.0F, 1, 2, 4, 0.0F, 0.2F, 0.3F, 0.3F, 0.05F, 0.3F, 2.0F, 0.2F, 0.3F, 0.0F, 0.2F, 0.3F, 0.0F, 0.5F, -0.5F, 1.5F, 0.5F, -0.5F, 2.0F, 0.5F, -0.5F, 0.7F, 0.5F, -0.5F, 0.7F);
      this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[10].addShapeBox(-4.5F, -8.0F, -3.5F, 1, 2, 3, 0.0F, 0.0F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.0F, 0.0F, 0.3F, -0.5F, 0.0F, -0.5F, 1.5F, 0.5F, -0.5F, 1.5F, 0.5F, -0.5F, 0.7F, 0.5F, -0.5F, -0.5F);
      this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[11].addShapeBox(-4.5F, -8.0F, 1.0F, 1, 2, 4, 0.0F, 0.05F, 0.3F, 2.0F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.0F, 0.2F, 0.3F, 0.0F, 0.5F, -0.5F, 2.0F, 0.5F, -0.5F, 1.5F, 0.5F, -0.5F, 0.7F, 0.5F, -0.5F, 0.7F);
      this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[12].addShapeBox(-4.5F, -7.0F, -1.0F, 1, 3, 6, 0.0F, 0.5F, -0.5F, 0.3F, 0.5F, -0.5F, 0.5F, 0.5F, -0.5F, 0.7F, 0.5F, -0.5F, 0.7F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.8F, 0.5F, 0.0F, 0.8F);
      this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[13].addShapeBox(-4.5F, -7.0F, -5.0F, 1, 3, 3, 0.0F, 0.0F, -0.5F, 0.0F, 0.5F, -0.5F, 0.0F, 0.5F, -0.5F, 0.7F, 0.5F, -0.5F, 0.7F, 0.0F, -0.5F, 0.3F, 0.5F, -0.5F, 0.5F, 0.5F, 0.0F, 0.7F, 0.5F, 0.0F, 0.7F);
      this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[14].addShapeBox(-5.0F, 0.0F, 1.0F, 10, 2, 4, 0.0F, -0.5F, 0.0F, 2.0F, -0.5F, 0.0F, 2.0F, -0.5F, 0.0F, -1.0F, -0.5F, 0.0F, -1.0F, 0.0F, 0.2F, 0.5F, 0.0F, 0.2F, 0.5F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F);
      this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[15].addShapeBox(-0.5F, -11.8F, -4.0F, 1, 1, 9, 0.0F, -0.2F, 0.0F, -2.2F, -0.2F, 0.0F, -2.2F, -0.2F, 0.0F, -2.2F, -0.2F, 0.0F, -2.2F, -0.2F, 0.5F, 0.1F, -0.2F, 0.5F, 0.1F, -0.2F, 0.5F, 0.1F, -0.2F, 0.5F, 0.1F);
      this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[16].addShapeBox(-0.5F, -10.0F, -4.0F, 1, 4, 10, 0.0F, -0.2F, 0.3F, 0.1F, -0.2F, 0.3F, 0.1F, -0.2F, 0.3F, -0.9F, -0.2F, 0.3F, -0.9F, -0.2F, -0.5F, 0.7F, -0.2F, -0.5F, 0.7F, -0.2F, -2.5F, 0.7F, -0.2F, -2.5F, 0.7F);
      this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[17].addShapeBox(-0.5F, -9.0F, 3.0F, 1, 5, 3, 0.0F, -0.2F, -0.5F, 0.7F, -0.2F, -0.5F, 0.7F, -0.2F, -0.5F, 0.7F, -0.2F, -0.5F, 0.7F, -0.2F, 0.3F, 0.1F, -0.2F, 0.3F, 0.1F, -0.2F, 0.3F, -0.1F, -0.2F, 0.3F, -0.1F);
      this.headModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[18].addShapeBox(-5.0F, -4.5F, -7.0F, 10, 1, 4, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.2F, 0.0F, 1.5F, -0.2F, 0.0F, 1.5F, -1.0F, -0.8F, 0.0F, -1.0F, -0.8F, 0.0F, 0.0F, -0.4F, 1.5F, 0.0F, -0.4F, 1.5F);
      this.headModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[19].addShapeBox(-4.0F, -4.9F, -8.0F, 8, 1, 1, 0.0F, -3.0F, -0.3F, 0.0F, -3.0F, -0.3F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, -3.0F, -0.5F, 0.0F, -3.0F, -0.5F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F);
      this.headModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[20].addShapeBox(-5.0F, -3.5F, -3.7F, 10, 3, 4, 0.0F, -0.4F, 0.0F, 2.3F, -0.4F, 0.0F, 2.3F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -1.1F, 1.5F, 0.5F, -1.1F, 1.5F, 0.5F, -0.5F, 0.8F, 0.0F, -0.5F, 0.8F, 0.0F);
      this.headModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[21].addShapeBox(-4.0F, 0.5F, -4.0F, 8, 2, 2, 0.0F, -0.5F, 0.0F, -1.0F, -0.5F, 0.0F, -1.0F, -0.5F, 1.0F, 2.0F, -0.5F, 1.0F, 2.0F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, -0.8F, 0.5F, 0.0F, -0.8F, 0.5F);
      this.headModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
