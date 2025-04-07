package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelMongolHelm extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 64;

   public ModelMongolHelm() {
      this.headModel = new ModelRendererTurbo[28];
      this.initheadModel_1();
   }

   private void initheadModel_1() {
      this.headModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[1] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.headModel[2] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[3] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.headModel[4] = new ModelRendererTurbo(this, 73, 1, this.textureX, this.textureY);
      this.headModel[5] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.headModel[6] = new ModelRendererTurbo(this, 89, 1, this.textureX, this.textureY);
      this.headModel[7] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.headModel[8] = new ModelRendererTurbo(this, 105, 1, this.textureX, this.textureY);
      this.headModel[9] = new ModelRendererTurbo(this, 81, 9, this.textureX, this.textureY);
      this.headModel[10] = new ModelRendererTurbo(this, 105, 9, this.textureX, this.textureY);
      this.headModel[11] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.headModel[12] = new ModelRendererTurbo(this, 25, 17, this.textureX, this.textureY);
      this.headModel[13] = new ModelRendererTurbo(this, 49, 17, this.textureX, this.textureY);
      this.headModel[14] = new ModelRendererTurbo(this, 65, 17, this.textureX, this.textureY);
      this.headModel[15] = new ModelRendererTurbo(this, 89, 17, this.textureX, this.textureY);
      this.headModel[16] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.headModel[17] = new ModelRendererTurbo(this, 25, 25, this.textureX, this.textureY);
      this.headModel[18] = new ModelRendererTurbo(this, 49, 25, this.textureX, this.textureY);
      this.headModel[19] = new ModelRendererTurbo(this, 105, 25, this.textureX, this.textureY);
      this.headModel[20] = new ModelRendererTurbo(this, 65, 33, this.textureX, this.textureY);
      this.headModel[21] = new ModelRendererTurbo(this, 89, 33, this.textureX, this.textureY);
      this.headModel[22] = new ModelRendererTurbo(this, 113, 1, this.textureX, this.textureY);
      this.headModel[23] = new ModelRendererTurbo(this, 81, 17, this.textureX, this.textureY);
      this.headModel[24] = new ModelRendererTurbo(this, 1, 41, this.textureX, this.textureY);
      this.headModel[25] = new ModelRendererTurbo(this, 89, 17, this.textureX, this.textureY);
      this.headModel[26] = new ModelRendererTurbo(this, 105, 17, this.textureX, this.textureY);
      this.headModel[27] = new ModelRendererTurbo(this, 113, 17, this.textureX, this.textureY);
      this.headModel[0].addShapeBox(-4.0F, -8.0F, -4.0F, 8, 3, 8, 0.0F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F);
      this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[1].addShapeBox(-4.0F, -9.8F, -4.0F, 8, 1, 8, 0.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F);
      this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[2].addShapeBox(-0.5F, -10.8F, -0.5F, 1, 1, 1, 0.0F, 0.3F, 0.3F, 0.3F, 0.2F, 0.3F, 0.2F, 0.2F, 0.3F, 0.2F, 0.3F, 0.3F, 0.3F, 1.3F, 0.0F, 1.3F, 1.2F, 0.0F, 1.2F, 1.2F, 0.0F, 1.2F, 1.3F, 0.0F, 1.3F);
      this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[3].addShapeBox(-0.5F, -11.8F, -0.5F, 1, 1, 1, 0.0F, 0.3F, 0.5F, 0.3F, 0.3F, 0.5F, 0.3F, 0.3F, 0.5F, 0.3F, 0.3F, 0.5F, 0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[4].addShapeBox(-0.5F, -13.0F, 0.0F, 1, 1, 3, 0.0F, 0.2F, -0.3F, -0.7F, 0.2F, -0.3F, -0.7F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F);
      this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[5].addShapeBox(-0.5F, -12.3F, 3.0F, 1, 1, 1, 0.0F, 0.3F, -0.3F, 1.3F, 0.3F, -0.3F, 1.3F, 0.3F, 0.8F, -1.0F, 0.3F, 0.8F, -1.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, -1.0F, 0.0F, 0.5F, -1.0F, 0.0F);
      this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[6].addShapeBox(-0.5F, -12.3F, 3.0F, 1, 3, 1, 0.0F, 0.5F, -0.5F, 0.5F, 0.5F, -0.5F, 0.5F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.8F, 0.0F, -2.0F, 0.8F, 0.0F, -2.0F, 0.8F, 0.0F, 2.5F, 0.8F, 0.0F, 2.5F);
      this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[7].addShapeBox(-0.5F, -9.3F, 5.0F, 1, 3, 1, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 0.9F, 0.3F, -1.0F, 0.9F, 0.3F, -1.0F, 0.9F, 0.0F, 1.5F, 0.9F, 0.0F, 1.5F);
      this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[8].addShapeBox(-0.5F, -6.3F, 6.0F, 1, 4, 1, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 0.2F, 0.3F, 0.0F, 0.2F, 0.3F, 0.0F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F);
      this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[9].addShapeBox(-4.0F, -6.0F, -4.0F, 8, 2, 1, 0.0F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.7F, 0.9F, 0.9F, -0.7F, 0.9F, 0.9F, -0.3F, 0.9F, 0.9F, -0.3F, 0.9F);
      this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[10].addShapeBox(-4.0F, -5.0F, 4.7F, 8, 2, 1, 0.0F, 0.9F, -0.2F, 0.0F, 0.9F, -0.2F, 0.0F, 0.9F, -0.2F, -0.6F, 0.9F, -0.2F, -0.6F, 0.9F, -0.2F, -0.3F, 0.9F, -0.2F, -0.3F, 0.9F, -0.2F, -0.3F, 0.9F, -0.2F, -0.3F);
      this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[11].addShapeBox(-4.0F, -4.0F, 5.1F, 8, 2, 1, 0.0F, 1.3F, -0.2F, 0.0F, 1.3F, -0.2F, 0.0F, 1.3F, -0.2F, -0.6F, 1.3F, -0.2F, -0.6F, 1.3F, -0.2F, -0.3F, 1.3F, -0.2F, -0.3F, 1.3F, -0.2F, -0.3F, 1.3F, -0.2F, -0.3F);
      this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[12].addShapeBox(-4.0F, -3.0F, 5.5F, 8, 2, 1, 0.0F, 1.7F, -0.2F, 0.0F, 1.7F, -0.2F, 0.0F, 1.7F, -0.2F, -0.6F, 1.7F, -0.2F, -0.6F, 1.7F, -0.2F, -0.3F, 1.7F, -0.2F, -0.3F, 1.7F, -0.2F, -0.3F, 1.7F, -0.2F, -0.3F);
      this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[13].addShapeBox(-4.0F, -1.7F, 5.9F, 8, 2, 1, 0.0F, 2.1F, -0.2F, 0.0F, 2.1F, -0.2F, 0.0F, 2.1F, -0.2F, -0.6F, 2.1F, -0.2F, -0.6F, 2.1F, -0.2F, -0.3F, 2.1F, -0.2F, -0.3F, 2.1F, -0.2F, -0.3F, 2.1F, -0.2F, -0.3F);
      this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[14].addShapeBox(-5.5F, -5.0F, -4.0F, 1, 2, 9, 0.0F, -0.6F, -0.2F, 0.1F, 0.0F, -0.2F, 0.1F, 0.0F, -0.2F, 0.0F, -0.6F, -0.2F, 0.0F, -0.3F, -0.2F, 0.1F, -0.3F, -0.2F, 0.1F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F);
      this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[15].addShapeBox(-5.9F, -4.0F, -4.0F, 1, 2, 9, 0.0F, -0.6F, -0.2F, 0.1F, 0.0F, -0.2F, 0.1F, 0.0F, -0.2F, 0.4F, -0.6F, -0.2F, 0.4F, -0.3F, -0.2F, 0.1F, -0.3F, -0.2F, 0.1F, -0.3F, -0.2F, 0.4F, -0.3F, -0.2F, 0.4F);
      this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[16].addShapeBox(-6.3F, -3.0F, -4.0F, 1, 2, 9, 0.0F, -0.6F, -0.2F, 0.1F, 0.0F, -0.2F, 0.1F, 0.0F, -0.2F, 0.8F, -0.6F, -0.2F, 0.8F, -0.3F, -0.2F, 0.1F, -0.3F, -0.2F, 0.1F, -0.3F, -0.2F, 0.8F, -0.3F, -0.2F, 0.8F);
      this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[17].addShapeBox(-6.7F, -1.8F, -4.0F, 1, 2, 10, 0.0F, -0.6F, -0.2F, 0.1F, 0.0F, -0.2F, 0.1F, 0.0F, -0.2F, 0.0F, -0.6F, -0.2F, 0.0F, 0.0F, -0.2F, 0.1F, -0.6F, -0.2F, 0.1F, -0.6F, -0.2F, 0.5F, 0.0F, -0.2F, 0.5F);
      this.headModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[18].addShapeBox(4.5F, -5.0F, -4.0F, 1, 2, 9, 0.0F, 0.0F, -0.2F, 0.1F, -0.6F, -0.2F, 0.1F, -0.6F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, -0.3F, -0.2F, 0.1F, -0.3F, -0.2F, 0.1F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F);
      this.headModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[19].addShapeBox(4.9F, -4.0F, -4.0F, 1, 2, 9, 0.0F, 0.0F, -0.2F, 0.1F, -0.6F, -0.2F, 0.1F, -0.6F, -0.2F, 0.4F, 0.0F, -0.2F, 0.4F, -0.3F, -0.2F, 0.1F, -0.3F, -0.2F, 0.1F, -0.3F, -0.2F, 0.4F, -0.3F, -0.2F, 0.4F);
      this.headModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[20].addShapeBox(5.3F, -3.0F, -4.0F, 1, 2, 9, 0.0F, 0.0F, -0.2F, 0.1F, -0.6F, -0.2F, 0.1F, -0.6F, -0.2F, 0.8F, 0.0F, -0.2F, 0.8F, -0.3F, -0.2F, 0.1F, -0.3F, -0.2F, 0.1F, -0.3F, -0.2F, 0.8F, -0.3F, -0.2F, 0.8F);
      this.headModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[21].addShapeBox(5.7F, -1.8F, -4.0F, 1, 2, 10, 0.0F, 0.0F, -0.2F, 0.1F, -0.6F, -0.2F, 0.1F, -0.6F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, -0.6F, -0.2F, 0.1F, 0.0F, -0.2F, 0.1F, 0.0F, -0.2F, 0.5F, -0.6F, -0.2F, 0.5F);
      this.headModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[22].addShapeBox(-4.0F, -6.2F, -7.0F, 4, 1, 3, 0.0F, -3.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.8F, 0.0F, -0.8F);
      this.headModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[23].addShapeBox(-1.0F, -5.3F, -4.0F, 2, 2, 1, 0.0F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, -0.5F, -0.7F, 0.9F, -0.5F, -0.7F, 0.9F, -0.5F, -0.3F, 0.9F, -0.5F, -0.3F, 0.9F);
      this.headModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[24].addShapeBox(-4.0F, -6.0F, -2.0F, 8, 3, 6, 0.0F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.7F, 0.9F, 0.9F, -0.7F, 0.9F, 0.9F, -0.3F, 0.9F, 0.9F, -0.3F, 0.9F);
      this.headModel[24].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[25].addShapeBox(-5.0F, -5.3F, -4.0F, 2, 2, 1, 0.0F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, -0.5F, -0.5F, 0.9F, -0.5F, -0.1F, 0.9F, 0.0F, -0.1F, 0.9F);
      this.headModel[25].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[26].addShapeBox(3.0F, -5.3F, -4.0F, 2, 2, 1, 0.0F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, -0.5F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.1F, 0.9F, -0.5F, -0.1F, 0.9F);
      this.headModel[26].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[27].addShapeBox(0.0F, -6.2F, -7.0F, 4, 1, 3, 0.0F, 0.0F, 0.0F, -1.0F, -3.0F, 0.0F, -1.5F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.8F, 0.0F, -0.8F, 0.0F, 0.0F, 0.0F);
      this.headModel[27].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
