package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelArabeHelm extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 64;

   public ModelArabeHelm() {
      this.headModel = new ModelRendererTurbo[11];
      this.initheadModel_1();
   }

   private void initheadModel_1() {
      this.headModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[1] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.headModel[2] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[3] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
      this.headModel[4] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.headModel[5] = new ModelRendererTurbo(this, 41, 17, this.textureX, this.textureY);
      this.headModel[6] = new ModelRendererTurbo(this, 81, 17, this.textureX, this.textureY);
      this.headModel[7] = new ModelRendererTurbo(this, 1, 33, this.textureX, this.textureY);
      this.headModel[8] = new ModelRendererTurbo(this, 41, 33, this.textureX, this.textureY);
      this.headModel[9] = new ModelRendererTurbo(this, 81, 33, this.textureX, this.textureY);
      this.headModel[10] = new ModelRendererTurbo(this, 1, 49, this.textureX, this.textureY);
      this.headModel[0].addShapeBox(-4.0F, -8.0F, -4.0F, 8, 3, 8, 0.0F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F);
      this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[1].addShapeBox(-4.0F, -10.3F, -4.0F, 8, 2, 8, 0.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F);
      this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[2].addShapeBox(-0.5F, -11.3F, -0.5F, 1, 1, 1, 0.0F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F);
      this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[3].addShapeBox(-4.0F, -6.0F, -4.0F, 8, 2, 8, 0.0F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.7F, 0.9F, 0.9F, -0.7F, 0.9F, 0.9F, -0.3F, 0.9F, 0.9F, -0.3F, 0.9F);
      this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[4].addShapeBox(-4.5F, -6.0F, -4.5F, 9, 2, 9, 0.0F, 0.9F, 0.5F, 0.9F, 0.9F, 0.5F, 0.9F, 0.9F, -0.2F, 0.9F, 0.9F, -0.2F, 0.9F, 0.9F, -0.7F, 0.9F, 0.9F, -0.7F, 0.9F, 0.9F, 0.3F, 0.9F, 0.9F, 0.3F, 0.9F);
      this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[5].addShapeBox(-4.5F, -8.0F, -4.5F, 9, 1, 9, 0.0F, 0.6F, -0.9F, 0.6F, 0.6F, -0.9F, 0.6F, 0.6F, -1.7F, 0.6F, 0.6F, -1.7F, 0.6F, 0.9F, 0.5F, 0.9F, 0.9F, 0.5F, 0.9F, 0.9F, 1.2F, 0.9F, 0.9F, 1.2F, 0.9F);
      this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[6].addShapeBox(-4.5F, -3.2F, -4.5F, 9, 1, 9, 0.0F, 0.9F, 1.5F, 0.9F, 0.9F, 1.5F, 0.9F, 0.9F, 0.5F, 0.9F, 0.9F, 0.5F, 0.9F, 0.6F, -2.0F, 0.6F, 0.6F, -2.0F, 0.6F, 0.6F, -0.9F, 0.6F, 0.6F, -0.9F, 0.6F);
      this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[7].addShapeBox(-4.0F, -2.5F, -4.0F, 8, 2, 8, 0.0F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 1.0F, 0.5F, 0.5F, 1.0F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F);
      this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[8].addShapeBox(-4.0F, -3.2F, -4.0F, 8, 1, 8, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.5F, -0.3F, 0.5F, 0.5F, -0.3F, 0.5F, 0.5F, -1.3F, 0.5F, 0.5F, -1.3F, 0.5F);
      this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[9].addShapeBox(-4.0F, 0.0F, -4.0F, 4, 1, 8, 0.0F, 0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, -1.5F, -0.3F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -1.5F, -0.3F, 0.25F);
      this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[10].addShapeBox(0.0F, 0.0F, -4.0F, 4, 1, 8, 0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.5F, -1.5F, -0.3F, 0.0F, -1.5F, -0.3F, 0.25F, 0.0F, 0.0F, 0.0F);
      this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
