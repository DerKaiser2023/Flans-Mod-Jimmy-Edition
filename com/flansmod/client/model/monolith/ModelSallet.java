package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelSallet extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 32;

   public ModelSallet() {
      this.headModel = new ModelRendererTurbo[17];
      this.initheadModel_1();
   }

   private void initheadModel_1() {
      this.headModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[1] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.headModel[2] = new ModelRendererTurbo(this, 65, 1, this.textureX, this.textureY);
      this.headModel[3] = new ModelRendererTurbo(this, 89, 1, this.textureX, this.textureY);
      this.headModel[4] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.headModel[5] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[6] = new ModelRendererTurbo(this, 33, 17, this.textureX, this.textureY);
      this.headModel[7] = new ModelRendererTurbo(this, 57, 17, this.textureX, this.textureY);
      this.headModel[8] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.headModel[9] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.headModel[10] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
      this.headModel[11] = new ModelRendererTurbo(this, 81, 9, this.textureX, this.textureY);
      this.headModel[12] = new ModelRendererTurbo(this, 97, 17, this.textureX, this.textureY);
      this.headModel[13] = new ModelRendererTurbo(this, 49, 17, this.textureX, this.textureY);
      this.headModel[14] = new ModelRendererTurbo(this, 65, 1, this.textureX, this.textureY);
      this.headModel[15] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
      this.headModel[16] = new ModelRendererTurbo(this, 65, 25, this.textureX, this.textureY);
      this.headModel[0].addShapeBox(-4.0F, -8.0F, -4.0F, 8, 2, 8, 0.0F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.0F, 0.2F, 0.3F, 0.0F, 0.5F, -0.5F, 1.5F, 0.5F, -0.5F, 1.5F, 0.5F, -0.5F, 0.7F, 0.5F, -0.5F, 0.7F);
      this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[1].addShapeBox(-4.0F, -4.0F, -3.0F, 1, 4, 7, 0.0F, 0.5F, 0.0F, 0.0F, -1.2F, 0.0F, 0.0F, -1.2F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, -0.5F, -2.0F, -1.2F, -0.5F, -2.0F, -1.2F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F);
      this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[2].addShapeBox(4.7F, -4.0F, -3.0F, 1, 4, 7, 0.0F, 0.5F, 0.0F, 0.0F, -1.2F, 0.0F, 0.0F, -1.2F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, -0.5F, -2.0F, -1.2F, -0.5F, -2.0F, -1.2F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F);
      this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[3].addShapeBox(-4.0F, -9.8F, -4.0F, 8, 1, 8, 0.0F, -1.0F, 0.0F, -2.0F, -1.0F, 0.0F, -2.0F, -1.0F, 0.0F, -1.5F, -1.0F, 0.0F, -1.5F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.0F, 0.2F, 0.5F, 0.0F);
      this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[4].addShapeBox(-4.0F, -7.0F, -5.0F, 8, 3, 9, 0.0F, 0.5F, -0.5F, 0.5F, 0.5F, -0.5F, 0.5F, 0.5F, -0.5F, 0.7F, 0.5F, -0.5F, 0.7F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.7F, 0.5F, 0.0F, 0.7F);
      this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[5].addShapeBox(4.2F, -6.0F, -0.5F, 1, 3, 1, 0.0F, -0.2F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, 0.0F, 3.0F, -0.5F, 0.0F, 3.0F, -0.5F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F);
      this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[6].addShapeBox(-4.0F, -4.0F, 3.0F, 8, 2, 1, 0.0F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.7F, 0.5F, 0.0F, 0.7F, 0.5F, -1.0F, -0.5F, 0.5F, -1.0F, -0.5F, 0.5F, 0.0F, 1.5F, 0.5F, 0.0F, 1.5F);
      this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[7].addShapeBox(-4.5F, -2.0F, 5.5F, 9, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.5F, -1.0F, -1.0F, -2.5F, -1.0F, -1.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, -1.0F, -2.0F, 1.0F, 0.0F, -2.0F, 1.0F, 0.0F);
      this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[8].addShapeBox(4.7F, -2.0F, 4.0F, 1, 2, 1, 0.0F, 0.5F, 1.0F, 0.0F, -1.2F, 1.0F, 0.0F, -1.2F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.0F, -1.2F, 0.0F, 0.0F, -1.2F, 0.0F, 1.5F, 0.5F, 0.0F, 1.5F);
      this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[9].addShapeBox(-4.0F, -2.0F, 4.0F, 1, 2, 1, 0.0F, 0.5F, 1.0F, 0.0F, -1.2F, 1.0F, 0.0F, -1.2F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.0F, -1.2F, 0.0F, 0.0F, -1.2F, 0.0F, 1.5F, 0.5F, 0.0F, 1.5F);
      this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[10].addShapeBox(4.2F, -4.0F, -3.5F, 1, 1, 2, 0.0F, -0.2F, 0.2F, 0.0F, -0.5F, 0.2F, -0.2F, -0.5F, 0.7F, 0.0F, -0.2F, 0.7F, 0.0F, -0.2F, 0.0F, 0.0F, -0.5F, 0.0F, -0.2F, -0.5F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F);
      this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[11].addShapeBox(4.2F, -3.0F, -5.0F, 1, 3, 5, 0.0F, -0.2F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, -0.3F, 0.5F, -0.2F, -0.3F, 0.5F);
      this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[12].addShapeBox(-4.8F, -3.0F, -6.0F, 10, 1, 1, 0.0F, -1.6F, 0.2F, 0.5F, -2.0F, 0.2F, 0.5F, -0.5F, 0.2F, 0.0F, -0.1F, 0.2F, 0.0F, -1.6F, -0.2F, 0.0F, -2.0F, -0.2F, 0.0F, -0.4F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F);
      this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[13].addShapeBox(-4.9F, -3.0F, -5.0F, 1, 3, 5, 0.0F, -0.2F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, 0.1F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, -0.3F, 0.5F, 0.3F, -0.3F, 0.5F);
      this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[14].addShapeBox(-4.9F, -6.0F, -0.5F, 1, 3, 1, 0.0F, -0.2F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, 0.0F, 3.0F, -0.5F, 0.0F, 3.0F, -0.5F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F);
      this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[15].addShapeBox(-4.9F, -4.0F, -3.5F, 1, 1, 2, 0.0F, -0.2F, 0.2F, -0.2F, -0.5F, 0.2F, 0.0F, -0.5F, 0.7F, 0.0F, -0.2F, 0.7F, 0.0F, -0.2F, 0.0F, -0.2F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F);
      this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[16].addShapeBox(-4.8F, -2.0F, -6.0F, 10, 2, 1, 0.0F, -1.6F, 0.2F, 0.0F, -2.0F, 0.2F, 0.0F, -0.4F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, -1.6F, 0.0F, 0.2F, -2.0F, 0.0F, 0.2F, -0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F);
      this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
