package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelLandsknecht extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 64;

   public ModelLandsknecht() {
      this.headModel = new ModelRendererTurbo[11];
      this.initheadModel_1();
   }

   private void initheadModel_1() {
      this.headModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[1] = new ModelRendererTurbo(this, 65, 1, this.textureX, this.textureY);
      this.headModel[2] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.headModel[3] = new ModelRendererTurbo(this, 49, 25, this.textureX, this.textureY);
      this.headModel[4] = new ModelRendererTurbo(this, 89, 25, this.textureX, this.textureY);
      this.headModel[5] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.headModel[6] = new ModelRendererTurbo(this, 49, 9, this.textureX, this.textureY);
      this.headModel[7] = new ModelRendererTurbo(this, 65, 41, this.textureX, this.textureY);
      this.headModel[8] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[9] = new ModelRendererTurbo(this, 97, 41, this.textureX, this.textureY);
      this.headModel[10] = new ModelRendererTurbo(this, 113, 1, this.textureX, this.textureY);
      this.headModel[0].addShapeBox(-7.0F, -7.5F, -7.0F, 14, 2, 15, 0.0F, 0.9F, 1.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -2.2F, 0.3F, 0.9F, -0.2F, 0.3F, 0.9F, -1.7F, 0.9F, 0.9F, 0.3F, 0.9F, 0.9F, 2.3F, -0.1F, 0.9F, 0.3F, -0.1F);
      this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[1].addShapeBox(-7.0F, -9.5F, -7.0F, 14, 2, 15, 0.0F, 0.5F, 0.0F, 0.4F, 0.5F, -2.0F, 0.4F, 0.5F, -3.7F, 0.0F, 0.5F, -1.7F, 0.0F, 0.9F, -1.5F, 0.9F, 0.9F, 0.5F, 0.9F, 0.9F, 2.2F, 0.3F, 0.9F, 0.2F, 0.3F);
      this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[2].addShapeBox(-7.0F, -5.5F, -7.0F, 14, 1, 15, 0.0F, 0.9F, 1.7F, 0.9F, 0.9F, -0.3F, 0.9F, 0.9F, -2.3F, -0.1F, 0.9F, -0.3F, -0.1F, 0.4F, -2.2F, 0.4F, 0.4F, -0.2F, 0.4F, 0.4F, 1.8F, -0.6F, 0.4F, -0.2F, -0.6F);
      this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[3].addShapeBox(-4.0F, -11.0F, -3.5F, 8, 2, 8, 0.0F, 0.5F, -0.5F, 0.4F, 0.5F, -1.5F, 0.4F, 0.5F, -2.7F, 0.0F, 0.5F, -1.7F, 0.0F, 0.9F, -1.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 1.2F, 0.3F, 0.9F, 0.2F, 0.3F);
      this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[4].addShapeBox(-4.0F, -9.0F, -3.5F, 8, 2, 8, 0.0F, 0.9F, 1.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, -1.2F, 0.3F, 0.9F, -0.2F, 0.3F, 0.9F, -1.7F, 0.9F, 0.9F, 0.3F, 0.9F, 0.9F, 2.3F, -0.1F, 0.9F, 0.3F, -0.1F);
      this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[5].addShapeBox(-9.0F, -12.0F, -0.5F, 11, 3, 1, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[6].addShapeBox(-17.0F, -12.0F, -0.5F, 8, 3, 1, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, -2.0F, 0.0F, -3.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 2.0F, 0.0F);
      this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[7].addShapeBox(-9.0F, -12.0F, 0.5F, 11, 3, 1, 0.0F, 0.0F, 2.5F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 2.5F, 2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F);
      this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[8].addShapeBox(-15.0F, -12.0F, 0.5F, 6, 3, 1, 0.0F, 0.0F, -1.0F, -3.0F, 0.0F, 2.5F, -2.0F, 0.0F, 2.5F, 2.0F, 0.0F, -1.0F, 3.0F, -3.0F, 2.0F, -3.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 2.0F, -3.0F, 2.0F, 3.0F);
      this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[9].addShapeBox(-9.0F, -11.0F, -1.5F, 11, 1, 1, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 2.0F, -2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, -2.0F);
      this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[10].addShapeBox(-15.0F, -11.0F, -1.5F, 6, 1, 1, 0.0F, 0.0F, -1.0F, 3.0F, 0.0F, 2.0F, 2.0F, 0.0F, 2.0F, -2.0F, 0.0F, -1.0F, -3.0F, -3.0F, 2.0F, 3.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, -2.0F, -3.0F, 2.0F, -3.0F);
      this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
