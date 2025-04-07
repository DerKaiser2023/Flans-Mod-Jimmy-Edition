package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelBascinetOpen extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 32;

   public ModelBascinetOpen() {
      this.headModel = new ModelRendererTurbo[20];
      this.headModel[0] = new ModelRendererTurbo(this, 73, 1, this.textureX, this.textureY);
      this.headModel[1] = new ModelRendererTurbo(this, 113, 1, this.textureX, this.textureY);
      this.headModel[2] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.headModel[3] = new ModelRendererTurbo(this, 25, 17, this.textureX, this.textureY);
      this.headModel[4] = new ModelRendererTurbo(this, 41, 17, this.textureX, this.textureY);
      this.headModel[5] = new ModelRendererTurbo(this, 81, 17, this.textureX, this.textureY);
      this.headModel[6] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.headModel[7] = new ModelRendererTurbo(this, 73, 17, this.textureX, this.textureY);
      this.headModel[8] = new ModelRendererTurbo(this, 105, 9, this.textureX, this.textureY);
      this.headModel[9] = new ModelRendererTurbo(this, 105, 17, this.textureX, this.textureY);
      this.headModel[10] = new ModelRendererTurbo(this, 113, 17, this.textureX, this.textureY);
      this.headModel[11] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.headModel[12] = new ModelRendererTurbo(this, 121, 17, this.textureX, this.textureY);
      this.headModel[13] = new ModelRendererTurbo(this, 17, 25, this.textureX, this.textureY);
      this.headModel[14] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.headModel[15] = new ModelRendererTurbo(this, 105, 9, this.textureX, this.textureY);
      this.headModel[16] = new ModelRendererTurbo(this, 73, 17, this.textureX, this.textureY);
      this.headModel[17] = new ModelRendererTurbo(this, 113, 17, this.textureX, this.textureY);
      this.headModel[18] = new ModelRendererTurbo(this, 105, 17, this.textureX, this.textureY);
      this.headModel[19] = new ModelRendererTurbo(this, 105, 17, this.textureX, this.textureY);
      this.headModel[0].addShapeBox(-4.0F, -8.0F, -4.0F, 8, 3, 8, 0.0F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.5F, 0.0F, 1.0F, 0.5F, 0.0F, 1.0F, 0.5F, 0.0F, 0.7F, 0.5F, 0.0F, 0.7F);
      this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[1].addShapeBox(-4.0F, -5.0F, -4.0F, 1, 5, 6, 0.0F, 0.5F, 0.0F, 1.0F, -1.2F, 0.0F, 1.0F, -1.2F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.5F, -3.0F, -1.2F, 0.5F, -3.0F, -1.2F, 0.2F, 1.0F, 0.5F, 0.2F, 1.0F);
      this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[2].addShapeBox(-4.0F, -5.0F, 3.0F, 8, 5, 1, 0.0F, 0.5F, 0.0F, 1.0F, 0.5F, 0.0F, 1.0F, 0.5F, 0.0F, 0.7F, 0.5F, 0.0F, 0.7F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, -0.2F, 0.5F, 0.5F, -0.2F, 0.5F);
      this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[3].addShapeBox(4.7F, -5.0F, -4.0F, 1, 5, 6, 0.0F, 0.5F, 0.0F, 1.0F, -1.2F, 0.0F, 1.0F, -1.2F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.5F, -3.0F, -1.2F, 0.5F, -3.0F, -1.2F, 0.2F, 1.0F, 0.5F, 0.2F, 1.0F);
      this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[4].addShapeBox(-4.0F, -9.8F, -4.0F, 8, 1, 8, 0.0F, -1.0F, 0.0F, -2.0F, -1.0F, 0.0F, -2.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F);
      this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[5].addShapeBox(-3.0F, -10.8F, -3.0F, 6, 1, 7, 0.0F, -2.8F, 0.75F, -6.2F, -2.8F, 0.75F, -6.2F, -2.8F, 0.75F, -0.5F, -2.8F, 0.75F, -0.5F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[6].addShapeBox(-4.0F, -5.5F, -7.5F, 4, 2, 1, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 1.5F, 5.0F, 0.0F, 0.5F, 0.0F, 1.0F, 0.5F, 0.0F, 0.5F, -1.0F, 0.0F, 0.0F, -1.0F, 1.5F, 0.0F, -1.0F, -1.5F, 1.0F, -1.0F, -0.5F);
      this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[7].addShapeBox(-4.0F, -8.5F, -7.5F, 4, 3, 1, 0.0F, 0.5F, 0.0F, -2.0F, 0.0F, 0.1F, -2.0F, 0.0F, 0.1F, 1.5F, 0.7F, 0.0F, 1.5F, 0.0F, -0.7F, 0.0F, 0.0F, -1.5F, 5.0F, 0.0F, -0.7F, 0.0F, 1.0F, -0.5F, 0.0F);
      this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[8].addShapeBox(-5.2F, -4.5F, -7.0F, 1, 2, 4, 0.0F, -0.2F, 1.5F, -0.5F, -0.2F, 1.5F, -0.5F, -0.2F, 0.5F, -0.5F, -0.2F, 0.5F, -0.5F, -0.2F, -2.0F, 0.0F, -0.2F, -2.0F, 0.0F, -0.2F, -1.0F, -1.0F, -0.2F, -1.0F, -1.0F);
      this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[9].addShapeBox(-5.2F, -6.5F, -2.0F, 1, 1, 2, 0.0F, -0.5F, 1.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.5F, -0.8F, -0.5F, 0.5F, -0.8F, -0.5F, -1.0F, 1.0F, -0.2F, -1.0F, 1.0F, -0.2F, -0.5F, -1.2F, -0.5F, -0.5F, -1.2F);
      this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[10].addShapeBox(-5.2F, -8.5F, -6.0F, 1, 3, 4, 0.0F, -0.5F, 0.0F, -1.0F, -0.2F, 0.0F, -1.0F, -0.2F, -1.0F, 0.3F, -0.5F, -1.0F, 0.3F, -0.2F, -0.5F, 0.5F, -0.2F, -0.5F, 0.5F, -0.2F, 0.5F, -1.5F, -0.2F, 0.5F, -1.5F);
      this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[11].addShapeBox(0.5F, -8.5F, -9.3F, 3, 1, 1, 0.0F, 0.0F, -0.3F, -0.6F, -0.2F, -0.6F, -2.1F, -0.2F, -0.6F, 1.5F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, -0.3F, 0.0F, -2.0F, -0.3F, 0.0F, 1.5F, 0.0F, -0.3F, 0.0F);
      this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[12].addShapeBox(-3.5F, -8.5F, -9.8F, 2, 1, 1, 0.0F, -0.2F, -0.6F, -2.1F, -0.8F, -0.3F, -1.2F, -0.8F, -0.3F, 0.4F, -0.2F, -0.6F, 1.5F, -0.3F, 0.0F, -2.0F, -0.8F, -0.3F, -0.9F, -0.8F, -0.3F, 0.5F, -0.3F, 0.0F, 1.5F);
      this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[13].addShapeBox(-2.5F, -8.5F, -9.8F, 2, 1, 1, 0.0F, -0.2F, -0.3F, -1.4F, -0.2F, -0.3F, -1.1F, -0.2F, -0.3F, 0.5F, -0.2F, -0.3F, 0.4F, -0.2F, -0.3F, -0.9F, -0.3F, -0.3F, -0.7F, -0.3F, -0.3F, 0.5F, -0.2F, -0.3F, 0.5F);
      this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[14].addShapeBox(0.0F, -5.5F, -7.5F, 4, 2, 1, 0.0F, 0.0F, 1.5F, 5.0F, 0.0F, 0.7F, 0.0F, 1.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.0F, 1.5F, 0.5F, -1.0F, 0.0F, 1.0F, -1.0F, -0.5F, 0.0F, -1.0F, -1.5F);
      this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[15].addShapeBox(4.2F, -4.5F, -7.0F, 1, 2, 4, 0.0F, -0.2F, 1.5F, -0.5F, -0.2F, 1.5F, -0.5F, -0.2F, 0.5F, -0.5F, -0.2F, 0.5F, -0.5F, -0.2F, -2.0F, 0.0F, -0.2F, -2.0F, 0.0F, -0.2F, -1.0F, -1.0F, -0.2F, -1.0F, -1.0F);
      this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[16].addShapeBox(0.0F, -8.5F, -7.5F, 4, 3, 1, 0.0F, 0.0F, 0.1F, -2.0F, 0.5F, 0.0F, -2.0F, 0.7F, 0.0F, 1.5F, 0.0F, 0.1F, 1.5F, 0.0F, -1.5F, 5.0F, 0.0F, -0.7F, 0.0F, 1.0F, -0.5F, 0.0F, 0.0F, -0.7F, 0.0F);
      this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[17].addShapeBox(4.2F, -8.5F, -6.0F, 1, 3, 4, 0.0F, -0.2F, 0.0F, -1.0F, -0.5F, 0.0F, -1.0F, -0.5F, -1.0F, 0.3F, -0.2F, -1.0F, 0.3F, -0.2F, -0.5F, 0.5F, -0.2F, -0.5F, 0.5F, -0.2F, 0.5F, -1.5F, -0.2F, 0.5F, -1.5F);
      this.headModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[18].addShapeBox(-1.2F, -6.0F, -1.7F, 1, 1, 2, 0.0F, -0.5F, 1.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.5F, -0.8F, -0.5F, 0.5F, -0.8F, -0.5F, -1.0F, 1.0F, -0.2F, -1.0F, 1.0F, -0.2F, -0.5F, -1.2F, -0.5F, -0.5F, -1.2F);
      this.headModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[19].addShapeBox(4.2F, -6.5F, -2.0F, 1, 1, 2, 0.0F, -0.2F, 0.0F, 0.0F, -0.5F, 1.0F, 0.0F, -0.5F, 0.5F, -0.8F, -0.2F, 0.5F, -0.8F, -0.2F, -1.0F, 1.0F, -0.5F, -1.0F, 1.0F, -0.5F, -0.5F, -1.2F, -0.2F, -0.5F, -1.2F);
      this.headModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
