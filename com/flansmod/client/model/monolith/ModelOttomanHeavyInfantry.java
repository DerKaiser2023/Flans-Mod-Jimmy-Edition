package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelOttomanHeavyInfantry extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 64;

   public ModelOttomanHeavyInfantry() {
      this.headModel = new ModelRendererTurbo[21];
      this.initheadModel_1();
   }

   private void initheadModel_1() {
      this.headModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[1] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.headModel[2] = new ModelRendererTurbo(this, 65, 1, this.textureX, this.textureY);
      this.headModel[3] = new ModelRendererTurbo(this, 89, 1, this.textureX, this.textureY);
      this.headModel[4] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[5] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.headModel[6] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.headModel[7] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.headModel[8] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
      this.headModel[9] = new ModelRendererTurbo(this, 65, 1, this.textureX, this.textureY);
      this.headModel[10] = new ModelRendererTurbo(this, 33, 17, this.textureX, this.textureY);
      this.headModel[11] = new ModelRendererTurbo(this, 57, 17, this.textureX, this.textureY);
      this.headModel[12] = new ModelRendererTurbo(this, 73, 17, this.textureX, this.textureY);
      this.headModel[13] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
      this.headModel[14] = new ModelRendererTurbo(this, 41, 25, this.textureX, this.textureY);
      this.headModel[15] = new ModelRendererTurbo(this, 105, 25, this.textureX, this.textureY);
      this.headModel[16] = new ModelRendererTurbo(this, 1, 33, this.textureX, this.textureY);
      this.headModel[17] = new ModelRendererTurbo(this, 25, 33, this.textureX, this.textureY);
      this.headModel[18] = new ModelRendererTurbo(this, 105, 17, this.textureX, this.textureY);
      this.headModel[19] = new ModelRendererTurbo(this, 65, 33, this.textureX, this.textureY);
      this.headModel[20] = new ModelRendererTurbo(this, 49, 41, this.textureX, this.textureY);
      this.headModel[0].addShapeBox(-4.0F, -11.3F, -4.0F, 8, 3, 8, 0.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F);
      this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[1].addShapeBox(-4.0F, -6.0F, -4.0F, 1, 2, 8, 0.0F, 0.9F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F);
      this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[2].addShapeBox(3.0F, -6.0F, -4.0F, 1, 2, 8, 0.0F, 0.0F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F);
      this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[3].addShapeBox(-3.0F, -6.0F, -4.0F, 6, 2, 8, 0.0F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.2F, 0.9F, 0.9F, -0.2F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F);
      this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[4].addShapeBox(-0.5F, -12.0F, -0.5F, 1, 1, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, 0.5F, -0.3F, 0.5F, 0.5F, -0.3F, 0.5F, 0.5F, -0.3F, 0.5F, 0.5F, -0.3F, 0.5F);
      this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[5].addShapeBox(-5.0F, -7.0F, -5.0F, 10, 1, 10, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F);
      this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[6].addShapeBox(-0.5F, -13.0F, -0.5F, 1, 1, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
      this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[7].addShapeBox(-0.5F, -5.0F, -5.7F, 1, 1, 1, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F);
      this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[8].addShapeBox(-0.5F, -7.0F, -5.7F, 1, 3, 1, 0.0F, -0.3F, -0.1F, 0.1F, -0.3F, -0.1F, 0.1F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.5F, -0.1F, -0.3F, -0.5F, -0.1F, -0.3F, -0.5F, -0.1F, -0.3F, -0.5F, -0.1F);
      this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[9].addShapeBox(-0.5F, -5.0F, -5.7F, 1, 4, 1, 0.0F, -0.3F, -0.5F, -0.1F, -0.3F, -0.5F, -0.1F, -0.3F, -0.5F, -0.1F, -0.3F, -0.5F, -0.1F, -0.1F, 0.1F, 0.1F, -0.1F, 0.1F, 0.1F, -0.1F, 0.1F, -0.3F, -0.1F, 0.1F, -0.3F);
      this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[10].addShapeBox(-5.0F, -4.5F, -7.5F, 10, 1, 3, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, -1.0F, -0.8F, 0.0F, -1.0F, -0.8F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F);
      this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[11].addShapeBox(-4.0F, -4.9F, -8.5F, 8, 1, 1, 0.0F, -3.0F, -0.3F, 0.0F, -3.0F, -0.3F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, -3.0F, -0.5F, 0.0F, -3.0F, -0.5F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F);
      this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[12].addShapeBox(-4.0F, -8.0F, -4.0F, 8, 2, 8, 0.0F, 0.5F, 0.3F, 0.5F, 0.5F, 0.3F, 0.5F, 0.5F, 0.3F, 0.5F, 0.5F, 0.3F, 0.5F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F);
      this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[13].addShapeBox(-1.0F, -7.5F, -6.0F, 2, 2, 1, 0.0F, 0.4F, 0.0F, -0.2F, 0.4F, 0.0F, -0.2F, 0.4F, 0.0F, -0.2F, 0.4F, 0.0F, -0.2F, 1.3F, -0.4F, -0.2F, 1.3F, -0.4F, -0.2F, 1.3F, -0.4F, -0.2F, 1.3F, -0.4F, -0.2F);
      this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[14].addShapeBox(3.85F, -5.0F, -4.0F, 1, 3, 7, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F);
      this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[15].addShapeBox(-4.85F, -5.0F, -4.0F, 1, 3, 7, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F);
      this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[16].addShapeBox(3.85F, -2.0F, -4.0F, 1, 2, 7, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, -2.0F, -0.2F, 0.0F, -2.0F, -0.2F, 0.0F, -1.5F, -0.2F, 0.0F, -1.5F);
      this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[17].addShapeBox(-4.85F, -2.0F, -4.0F, 1, 2, 7, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, -2.0F, -0.2F, 0.0F, -2.0F, -0.2F, 0.0F, -1.5F, -0.2F, 0.0F, -1.5F);
      this.headModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[18].addShapeBox(-4.0F, -4.5F, 4.0F, 8, 2, 1, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, -0.2F, 0.5F, 0.0F, -0.2F, 0.5F, 0.0F, 0.2F, 0.5F, 0.0F, 0.2F);
      this.headModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[19].addShapeBox(-4.0F, -2.5F, 4.3F, 8, 2, 1, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, -0.5F, -0.4F, 0.5F, -0.5F, -0.4F, 0.5F, -0.5F, 0.4F, 0.5F, -0.5F, 0.4F);
      this.headModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[20].addShapeBox(-4.0F, -1.0F, 4.8F, 8, 2, 1, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, -0.5F, -0.7F, 0.5F, -0.5F, -0.7F, 0.5F, -0.5F, 0.7F, 0.5F, -0.5F, 0.7F);
      this.headModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
