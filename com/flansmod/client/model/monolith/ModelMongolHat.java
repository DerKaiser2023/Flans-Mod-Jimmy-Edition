package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelMongolHat extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 64;

   public ModelMongolHat() {
      this.headModel = new ModelRendererTurbo[7];
      this.initheadModel_1();
   }

   private void initheadModel_1() {
      this.headModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[1] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.headModel[2] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[3] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
      this.headModel[4] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.headModel[5] = new ModelRendererTurbo(this, 49, 17, this.textureX, this.textureY);
      this.headModel[6] = new ModelRendererTurbo(this, 81, 25, this.textureX, this.textureY);
      this.headModel[0].addShapeBox(-4.0F, -8.0F, -4.0F, 8, 3, 8, 0.0F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.9F, -1.5F, 1.7F, 0.9F, -1.5F, 1.7F, 0.9F, 0.0F, 1.5F, 0.9F, 0.0F, 1.5F);
      this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[1].addShapeBox(-4.0F, -10.3F, -4.0F, 8, 2, 8, 0.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -1.5F, -3.0F, 0.0F, -1.5F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F);
      this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[2].addShapeBox(-0.5F, -11.3F, -0.5F, 1, 1, 1, 0.0F, -0.3F, -0.2F, -1.3F, -0.3F, -0.2F, -1.3F, -0.3F, -0.2F, 0.7F, -0.3F, -0.2F, 0.7F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 2.0F, 0.5F, 0.0F, 2.0F);
      this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[3].addShapeBox(-4.0F, -6.0F, -4.0F, 8, 2, 8, 0.0F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.7F, 0.9F, 0.9F, -0.7F, 0.9F, 0.9F, -0.3F, 0.9F, 0.9F, -0.3F, 0.9F);
      this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[4].addShapeBox(-5.0F, -6.5F, -5.0F, 10, 2, 11, 0.0F, 0.9F, 0.5F, 0.9F, 0.9F, 0.5F, 0.9F, 0.9F, -1.2F, 0.3F, 0.9F, -1.2F, 0.3F, 0.9F, -0.7F, 0.9F, 0.9F, -0.7F, 0.9F, 0.9F, 1.3F, -0.1F, 0.9F, 1.3F, -0.1F);
      this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[5].addShapeBox(-5.0F, -8.5F, -5.0F, 10, 1, 11, 0.0F, 0.6F, -0.9F, 0.6F, 0.6F, -0.9F, 0.6F, 0.6F, -2.7F, 0.0F, 0.6F, -2.7F, 0.0F, 0.9F, 0.5F, 0.9F, 0.9F, 0.5F, 0.9F, 0.9F, 2.2F, 0.3F, 0.9F, 2.2F, 0.3F);
      this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[6].addShapeBox(-5.0F, -3.7F, -5.0F, 10, 1, 11, 0.0F, 0.9F, 1.5F, 0.9F, 0.9F, 1.5F, 0.9F, 0.9F, -0.5F, -0.1F, 0.9F, -0.5F, -0.1F, 0.6F, -2.0F, 0.6F, 0.6F, -2.0F, 0.6F, 0.6F, 0.1F, -0.4F, 0.6F, 0.1F, -0.4F);
      this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
