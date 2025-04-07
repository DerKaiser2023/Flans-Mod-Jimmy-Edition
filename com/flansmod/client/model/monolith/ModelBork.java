package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelBork extends ModelCustomArmour {
   int textureX = 64;
   int textureY = 64;

   public ModelBork() {
      this.headModel = new ModelRendererTurbo[6];
      this.initheadModel_1();
   }

   private void initheadModel_1() {
      this.headModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[1] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.headModel[2] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.headModel[3] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.headModel[4] = new ModelRendererTurbo(this, 33, 25, this.textureX, this.textureY);
      this.headModel[5] = new ModelRendererTurbo(this, 1, 33, this.textureX, this.textureY);
      this.headModel[0].addShapeBox(-4.0F, -8.5F, -4.0F, 8, 4, 8, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, -0.3F, 0.95F, 0.3F, -0.3F, 0.95F, 0.05F, 0.0F, 0.2F, 0.05F, 0.0F, 0.2F, 0.05F, 0.4F, 0.2F, 0.05F, 0.4F, 0.2F);
      this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[1].addShapeBox(0.0F, -14.0F, -5.5F, 1, 10, 1, 0.0F, 0.0F, 0.2F, -0.4F, -0.1F, -0.4F, -0.4F, -0.1F, -0.4F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, -0.3F, -0.6F, -0.3F, -0.3F, -0.6F, -0.3F, -0.3F, 0.2F, 0.0F, -0.3F, 0.2F);
      this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[2].addShapeBox(-1.0F, -14.0F, -5.5F, 1, 10, 1, 0.0F, -0.1F, -0.4F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, 0.2F, 0.0F, -0.1F, -0.4F, 0.0F, -0.3F, -0.3F, -0.6F, 0.0F, -0.3F, -0.6F, 0.0F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F);
      this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[3].addShapeBox(-4.0F, -9.5F, -4.0F, 8, 1, 8, 0.0F, 0.05F, -0.2F, -0.4F, 0.05F, -0.2F, -0.4F, 0.05F, -0.4F, 0.2F, 0.05F, -0.4F, 0.2F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.3F, 0.95F, 0.3F, 0.3F, 0.95F);
      this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[4].addShapeBox(-3.0F, -13.0F, -2.5F, 6, 4, 6, 0.0F, 0.8F, -0.5F, 0.3F, 0.8F, -0.5F, 0.3F, 3.0F, 0.8F, 2.95F, 3.0F, 0.8F, 2.95F, 0.55F, 0.0F, 0.7F, 0.55F, 0.0F, 0.7F, 0.55F, 0.4F, 0.2F, 0.55F, 0.4F, 0.2F);
      this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[5].addShapeBox(-4.5F, -13.8F, 4.5F, 9, 16, 2, 0.0F, 0.4F, -1.0F, 1.0F, 0.4F, -1.0F, 1.0F, 1.4F, 0.0F, 0.0F, 1.4F, 0.0F, 0.0F, 1.4F, 0.5F, -1.0F, 1.4F, 0.5F, -1.0F, 2.4F, 0.0F, 1.0F, 2.4F, 0.0F, 1.0F);
      this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
