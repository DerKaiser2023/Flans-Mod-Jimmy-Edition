package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelNasalHelm extends ModelCustomArmour {
   int textureX = 64;
   int textureY = 64;

   public ModelNasalHelm() {
      this.headModel = new ModelRendererTurbo[8];
      this.initheadModel_1();
   }

   private void initheadModel_1() {
      this.headModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[1] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.headModel[2] = new ModelRendererTurbo(this, 1, 33, this.textureX, this.textureY);
      this.headModel[3] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[4] = new ModelRendererTurbo(this, 1, 49, this.textureX, this.textureY);
      this.headModel[5] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.headModel[6] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.headModel[7] = new ModelRendererTurbo(this, 41, 9, this.textureX, this.textureY);
      this.headModel[0].addShapeBox(-4.0F, -8.0F, -4.0F, 8, 3, 8, 0.0F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 0.8F, -0.5F, 0.8F, 0.8F, -0.5F, 0.8F, 0.8F, -0.2F, 0.8F, 0.8F, -0.2F, 0.8F);
      this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[1].addShapeBox(-4.0F, -5.0F, -4.0F, 8, 1, 8, 0.0F, 1.0F, -0.4F, 1.0F, 1.0F, -0.4F, 1.0F, 1.0F, -0.8F, 1.0F, 1.0F, -0.8F, 1.0F, 1.0F, -0.4F, 1.0F, 1.0F, -0.4F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F);
      this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[2].addShapeBox(-4.0F, -5.5F, -4.0F, 8, 1, 8, 0.0F, 0.95F, 0.0F, 0.95F, 0.95F, 0.0F, 0.95F, 0.95F, -0.3F, 0.95F, 0.95F, -0.3F, 0.95F, 0.95F, 0.0F, 0.95F, 0.95F, 0.0F, 0.95F, 0.95F, 0.4F, 0.95F, 0.95F, 0.4F, 0.95F);
      this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[3].addShapeBox(0.0F, -5.8F, -5.5F, 1, 4, 1, 0.0F, 0.0F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, 0.2F, -0.4F, -0.3F, -0.4F, -0.4F, -0.3F, -0.4F, 0.0F, 0.0F, 0.2F, 0.0F);
      this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[4].addShapeBox(-4.0F, -10.3F, -4.0F, 8, 2, 8, 0.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, 0.3F, 0.5F, 0.3F, 0.3F, 0.5F, 0.3F, 0.3F, 0.5F, 0.3F, 0.3F, 0.5F, 0.3F);
      this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[5].addShapeBox(-0.5F, -11.0F, -0.5F, 1, 1, 1, 0.0F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, 0.5F, -0.3F, 0.5F, 0.5F, -0.3F, 0.5F, 0.5F, -0.3F, 0.5F, 0.5F, -0.3F, 0.5F);
      this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[6].addShapeBox(-1.0F, -5.8F, -5.5F, 1, 4, 1, 0.0F, -0.3F, -0.3F, -0.4F, 0.0F, -0.3F, -0.4F, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.4F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, 0.2F, 0.0F, -0.3F, -0.4F, 0.0F);
      this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[7].addShapeBox(-5.0F, -5.0F, -1.0F, 10, 5, 1, 0.0F, -0.3F, 0.0F, -1.0F, -0.3F, 0.0F, -1.0F, -0.3F, 0.0F, 2.0F, -0.3F, 0.0F, 2.0F, -0.7F, 0.25F, 2.7F, -0.7F, 0.25F, 2.7F, -0.7F, 0.25F, -3.0F, -0.7F, 0.25F, -3.0F);
      this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
