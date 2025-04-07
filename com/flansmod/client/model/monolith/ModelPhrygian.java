package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelPhrygian extends ModelCustomArmour {
   int textureX = 64;
   int textureY = 64;

   public ModelPhrygian() {
      this.headModel = new ModelRendererTurbo[14];
      this.initheadModel_1();
   }

   private void initheadModel_1() {
      this.headModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[1] = new ModelRendererTurbo(this, 33, 9, this.textureX, this.textureY);
      this.headModel[2] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.headModel[3] = new ModelRendererTurbo(this, 1, 33, this.textureX, this.textureY);
      this.headModel[4] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[5] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.headModel[6] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.headModel[7] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.headModel[8] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
      this.headModel[9] = new ModelRendererTurbo(this, 57, 9, this.textureX, this.textureY);
      this.headModel[10] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.headModel[11] = new ModelRendererTurbo(this, 33, 25, this.textureX, this.textureY);
      this.headModel[12] = new ModelRendererTurbo(this, 41, 25, this.textureX, this.textureY);
      this.headModel[13] = new ModelRendererTurbo(this, 33, 33, this.textureX, this.textureY);
      this.headModel[0].addShapeBox(-4.0F, -9.0F, -4.0F, 8, 3, 8, 0.0F, 0.2F, 0.3F, -0.2F, 0.2F, 0.3F, -0.2F, 0.2F, 0.3F, -0.7F, 0.2F, 0.3F, -0.7F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F);
      this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[1].addShapeBox(-4.0F, -11.8F, -4.0F, 8, 2, 7, 0.0F, -2.5F, -1.0F, -1.0F, -2.5F, -1.0F, -1.0F, -2.5F, 0.0F, -3.0F, -2.5F, 0.0F, -3.0F, 0.2F, 0.5F, -0.2F, 0.2F, 0.5F, -0.2F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F);
      this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[2].addShapeBox(-4.0F, -5.0F, -4.0F, 8, 1, 8, 0.0F, 1.0F, 0.1F, 1.0F, 1.0F, 0.1F, 1.0F, 1.0F, -0.3F, 1.0F, 1.0F, -0.3F, 1.0F, 1.0F, -0.4F, 2.5F, 1.0F, -0.4F, 2.5F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F);
      this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[3].addShapeBox(-4.0F, -6.5F, -4.0F, 8, 2, 8, 0.0F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.1F, 0.9F, 0.9F, -0.1F, 0.9F);
      this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[4].addShapeBox(3.85F, -4.5F, -4.0F, 1, 1, 2, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F);
      this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[5].addShapeBox(3.85F, -3.5F, -4.0F, 1, 2, 2, 0.0F, 0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.7F, -0.5F, 0.5F, -0.3F, -0.5F, 0.5F, 0.0F, -0.5F, 1.0F, 0.7F, -0.5F, 1.0F);
      this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[6].addShapeBox(3.85F, -2.0F, -4.0F, 1, 2, 2, 0.0F, 0.7F, 0.0F, 0.5F, -0.3F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0F, 0.7F, 0.0F, 1.0F, 1.3F, -0.5F, 0.8F, -0.8F, -0.5F, 0.8F, -0.2F, -0.5F, 0.8F, 0.7F, -0.5F, 0.8F);
      this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[7].addShapeBox(3.85F, -1.0F, -4.0F, 1, 2, 2, 0.0F, 1.3F, -0.5F, 0.8F, -0.8F, -0.5F, 0.8F, -0.2F, -0.5F, 0.8F, 0.7F, -0.5F, 0.8F, 1.0F, -0.3F, 0.5F, -1.5F, -0.3F, 0.5F, -1.0F, -0.3F, 0.0F, 0.7F, -0.3F, 0.0F);
      this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[8].addShapeBox(-4.85F, -1.0F, -4.0F, 1, 2, 2, 0.0F, -0.8F, -0.5F, 0.8F, 1.3F, -0.5F, 0.8F, 0.7F, -0.5F, 0.8F, -0.2F, -0.5F, 0.8F, -1.5F, -0.3F, 0.5F, 1.0F, -0.3F, 0.5F, 0.7F, -0.3F, 0.0F, -1.0F, -0.3F, 0.0F);
      this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[9].addShapeBox(-4.85F, -2.0F, -4.0F, 1, 2, 2, 0.0F, -0.3F, 0.0F, 0.5F, 0.7F, 0.0F, 0.5F, 0.7F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, -0.8F, -0.5F, 0.8F, 1.3F, -0.5F, 0.8F, 0.7F, -0.5F, 0.8F, -0.2F, -0.5F, 0.8F);
      this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[10].addShapeBox(-4.85F, -3.5F, -4.0F, 1, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.2F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, -0.3F, -0.5F, 0.5F, 0.7F, -0.5F, 0.5F, 0.7F, -0.5F, 1.0F, 0.0F, -0.5F, 1.0F);
      this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[11].addShapeBox(-4.85F, -4.5F, -4.0F, 1, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.2F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F);
      this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[12].addShapeBox(-1.5F, -13.8F, -3.0F, 3, 2, 3, 0.0F, -0.5F, -2.5F, 0.5F, -0.5F, -2.5F, 0.5F, -0.5F, -0.5F, -3.0F, -0.5F, -0.5F, -3.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[13].addShapeBox(-1.0F, -13.3F, -6.0F, 2, 2, 3, 0.0F, 0.0F, -0.5F, -0.7F, 0.0F, -0.5F, -0.7F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, -1.5F, 0.0F, 0.5F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
