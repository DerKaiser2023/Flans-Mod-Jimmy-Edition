package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelSipahiHelmet extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 64;

   public ModelSipahiHelmet() {
      this.headModel = new ModelRendererTurbo[21];
      this.initheadModel_1();
   }

   private void initheadModel_1() {
      this.headModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[1] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.headModel[2] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
      this.headModel[3] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.headModel[4] = new ModelRendererTurbo(this, 17, 17, this.textureX, this.textureY);
      this.headModel[5] = new ModelRendererTurbo(this, 41, 17, this.textureX, this.textureY);
      this.headModel[6] = new ModelRendererTurbo(this, 57, 17, this.textureX, this.textureY);
      this.headModel[7] = new ModelRendererTurbo(this, 81, 17, this.textureX, this.textureY);
      this.headModel[8] = new ModelRendererTurbo(this, 97, 17, this.textureX, this.textureY);
      this.headModel[9] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.headModel[10] = new ModelRendererTurbo(this, 65, 25, this.textureX, this.textureY);
      this.headModel[11] = new ModelRendererTurbo(this, 25, 33, this.textureX, this.textureY);
      this.headModel[12] = new ModelRendererTurbo(this, 49, 33, this.textureX, this.textureY);
      this.headModel[13] = new ModelRendererTurbo(this, 121, 1, this.textureX, this.textureY);
      this.headModel[14] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.headModel[15] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[16] = new ModelRendererTurbo(this, 65, 33, this.textureX, this.textureY);
      this.headModel[17] = new ModelRendererTurbo(this, 73, 1, this.textureX, this.textureY);
      this.headModel[18] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
      this.headModel[19] = new ModelRendererTurbo(this, 33, 17, this.textureX, this.textureY);
      this.headModel[20] = new ModelRendererTurbo(this, 113, 1, this.textureX, this.textureY);
      this.headModel[0].addShapeBox(-4.0F, -8.0F, -4.0F, 8, 2, 8, 0.0F, 0.5F, 0.3F, 0.5F, 0.5F, 0.3F, 0.5F, 0.5F, 0.3F, 0.5F, 0.5F, 0.3F, 0.5F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F);
      this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[1].addShapeBox(-4.0F, -5.0F, -4.0F, 8, 1, 8, 0.0F, 1.0F, -0.4F, 1.0F, 1.0F, -0.4F, 1.0F, 1.0F, -0.8F, 1.0F, 1.0F, -0.8F, 1.0F, 1.0F, -0.4F, 1.0F, 1.0F, -0.4F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F);
      this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[2].addShapeBox(-4.0F, -6.5F, -4.0F, 8, 2, 8, 0.0F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.4F, 0.9F, 0.9F, 0.4F, 0.9F);
      this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[3].addShapeBox(-5.0F, -5.3F, -5.0F, 10, 1, 1, 0.0F, 0.3F, -0.3F, 0.3F, 0.3F, -0.3F, 0.3F, 0.3F, -0.3F, 0.3F, 0.3F, -0.3F, 0.3F, 0.3F, -0.3F, 0.3F, 0.3F, -0.3F, 0.3F, 0.3F, -0.3F, 0.3F, 0.3F, -0.3F, 0.3F);
      this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[4].addShapeBox(3.85F, -5.0F, -4.0F, 1, 3, 7, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F);
      this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[5].addShapeBox(-4.85F, -5.0F, -4.0F, 1, 3, 7, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F);
      this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[6].addShapeBox(-5.0F, -5.0F, -8.0F, 10, 1, 3, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, -1.0F, -0.8F, 0.0F, -1.0F, -0.8F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F);
      this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[7].addShapeBox(-4.0F, -5.4F, -9.0F, 8, 1, 1, 0.0F, -3.0F, -0.3F, 0.0F, -3.0F, -0.3F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, -3.0F, -0.5F, 0.0F, -3.0F, -0.5F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F);
      this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[8].addShapeBox(3.85F, -2.0F, -4.0F, 1, 2, 7, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, -2.0F, -0.2F, 0.0F, -2.0F, -0.2F, 0.0F, -1.5F, -0.2F, 0.0F, -1.5F);
      this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[9].addShapeBox(-4.85F, -2.0F, -4.0F, 1, 2, 7, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, -2.0F, -0.2F, 0.0F, -2.0F, -0.2F, 0.0F, -1.5F, -0.2F, 0.0F, -1.5F);
      this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[10].addShapeBox(-4.0F, -4.5F, 4.0F, 8, 2, 1, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, -0.2F, 0.5F, 0.0F, -0.2F, 0.5F, 0.0F, 0.2F, 0.5F, 0.0F, 0.2F);
      this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[11].addShapeBox(-4.0F, -2.5F, 4.3F, 8, 2, 1, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, -0.5F, -0.4F, 0.5F, -0.5F, -0.4F, 0.5F, -0.5F, 0.4F, 0.5F, -0.5F, 0.4F);
      this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[12].addShapeBox(-4.0F, -1.0F, 4.8F, 8, 2, 1, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, -0.5F, -0.7F, 0.5F, -0.5F, -0.7F, 0.5F, -0.5F, 0.7F, 0.5F, -0.5F, 0.7F);
      this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[13].addShapeBox(-0.5F, -9.3F, -5.5F, 1, 7, 1, 0.0F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, -0.3F, -0.2F, 0.2F, -0.3F, -0.2F, 0.2F, -0.3F, -0.2F, 0.2F, -0.3F, -0.2F);
      this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[14].addShapeBox(-2.0F, -2.7F, -5.5F, 4, 2, 1, 0.0F, 1.3F, 0.0F, -0.2F, 1.3F, 0.0F, -0.2F, 1.3F, 0.0F, -0.2F, 1.3F, 0.0F, -0.2F, 0.4F, 0.0F, -0.2F, 0.4F, 0.0F, -0.2F, 0.4F, 0.0F, -0.2F, 0.4F, 0.0F, -0.2F);
      this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[15].addShapeBox(-0.5F, -0.7F, -5.5F, 1, 1, 1, 0.0F, 1.3F, 0.0F, -0.2F, 1.3F, 0.0F, -0.2F, 1.3F, 0.0F, -0.2F, 1.3F, 0.0F, -0.2F, 0.4F, 0.0F, -0.2F, 0.4F, 0.0F, -0.2F, 0.4F, 0.0F, -0.2F, 0.4F, 0.0F, -0.2F);
      this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[16].addShapeBox(-4.0F, -11.3F, -4.0F, 8, 3, 8, 0.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F);
      this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[17].addShapeBox(-0.5F, -12.0F, -0.5F, 1, 1, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, 0.5F, -0.3F, 0.5F, 0.5F, -0.3F, 0.5F, 0.5F, -0.3F, 0.5F, 0.5F, -0.3F, 0.5F);
      this.headModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[18].addShapeBox(-0.5F, -13.0F, -0.5F, 1, 1, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
      this.headModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[19].addShapeBox(-1.5F, -10.7F, -5.5F, 3, 2, 1, 0.0F, 0.4F, 0.0F, -0.2F, 0.4F, 0.0F, -0.2F, 0.4F, 0.0F, -0.2F, 0.4F, 0.0F, -0.2F, 1.3F, -0.4F, -0.2F, 1.3F, -0.4F, -0.2F, 1.3F, -0.4F, -0.2F, 1.3F, -0.4F, -0.2F);
      this.headModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[20].addShapeBox(-0.5F, -11.7F, -5.5F, 1, 1, 1, 0.0F, 0.2F, -0.3F, -0.2F, 0.2F, -0.3F, -0.2F, 0.2F, -0.3F, -0.2F, 0.2F, -0.3F, -0.2F, 1.0F, 0.0F, -0.2F, 1.0F, 0.0F, -0.2F, 1.0F, 0.0F, -0.2F, 1.0F, 0.0F, -0.2F);
      this.headModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
