package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelPersianVeiledHelm extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 64;

   public ModelPersianVeiledHelm() {
      this.headModel = new ModelRendererTurbo[40];
      this.initheadModel_1();
   }

   private void initheadModel_1() {
      this.headModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[1] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.headModel[2] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
      this.headModel[3] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[4] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.headModel[5] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.headModel[6] = new ModelRendererTurbo(this, 105, 1, this.textureX, this.textureY);
      this.headModel[7] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.headModel[8] = new ModelRendererTurbo(this, 73, 1, this.textureX, this.textureY);
      this.headModel[9] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
      this.headModel[10] = new ModelRendererTurbo(this, 25, 9, this.textureX, this.textureY);
      this.headModel[11] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.headModel[12] = new ModelRendererTurbo(this, 105, 1, this.textureX, this.textureY);
      this.headModel[13] = new ModelRendererTurbo(this, 121, 1, this.textureX, this.textureY);
      this.headModel[14] = new ModelRendererTurbo(this, 49, 17, this.textureX, this.textureY);
      this.headModel[15] = new ModelRendererTurbo(this, 73, 17, this.textureX, this.textureY);
      this.headModel[16] = new ModelRendererTurbo(this, 73, 9, this.textureX, this.textureY);
      this.headModel[17] = new ModelRendererTurbo(this, 97, 9, this.textureX, this.textureY);
      this.headModel[18] = new ModelRendererTurbo(this, 97, 17, this.textureX, this.textureY);
      this.headModel[19] = new ModelRendererTurbo(this, 33, 25, this.textureX, this.textureY);
      this.headModel[20] = new ModelRendererTurbo(this, 57, 25, this.textureX, this.textureY);
      this.headModel[21] = new ModelRendererTurbo(this, 113, 17, this.textureX, this.textureY);
      this.headModel[22] = new ModelRendererTurbo(this, 81, 25, this.textureX, this.textureY);
      this.headModel[23] = new ModelRendererTurbo(this, 97, 17, this.textureX, this.textureY);
      this.headModel[24] = new ModelRendererTurbo(this, 1, 33, this.textureX, this.textureY);
      this.headModel[25] = new ModelRendererTurbo(this, 17, 33, this.textureX, this.textureY);
      this.headModel[26] = new ModelRendererTurbo(this, 33, 33, this.textureX, this.textureY);
      this.headModel[27] = new ModelRendererTurbo(this, 49, 33, this.textureX, this.textureY);
      this.headModel[28] = new ModelRendererTurbo(this, 65, 33, this.textureX, this.textureY);
      this.headModel[29] = new ModelRendererTurbo(this, 81, 33, this.textureX, this.textureY);
      this.headModel[30] = new ModelRendererTurbo(this, 97, 33, this.textureX, this.textureY);
      this.headModel[31] = new ModelRendererTurbo(this, 113, 33, this.textureX, this.textureY);
      this.headModel[32] = new ModelRendererTurbo(this, 1, 41, this.textureX, this.textureY);
      this.headModel[33] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.headModel[34] = new ModelRendererTurbo(this, 121, 17, this.textureX, this.textureY);
      this.headModel[35] = new ModelRendererTurbo(this, 121, 25, this.textureX, this.textureY);
      this.headModel[36] = new ModelRendererTurbo(this, 89, 25, this.textureX, this.textureY);
      this.headModel[37] = new ModelRendererTurbo(this, 17, 41, this.textureX, this.textureY);
      this.headModel[38] = new ModelRendererTurbo(this, 25, 41, this.textureX, this.textureY);
      this.headModel[39] = new ModelRendererTurbo(this, 33, 41, this.textureX, this.textureY);
      this.headModel[0].addShapeBox(-4.0F, -8.0F, -4.0F, 8, 3, 8, 0.0F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F);
      this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[1].addShapeBox(-4.0F, -9.8F, -4.0F, 8, 1, 8, 0.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F);
      this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[2].addShapeBox(-4.0F, -6.0F, -4.0F, 1, 2, 8, 0.0F, 0.9F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F);
      this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[3].addShapeBox(-1.0F, -4.7F, -4.5F, 2, 1, 1, 0.0F, 0.5F, -0.2F, 0.7F, 0.5F, -0.2F, 0.7F, 0.5F, -0.2F, -0.7F, 0.5F, -0.2F, -0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, -0.7F, 0.0F, 0.0F, -0.7F);
      this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[4].addShapeBox(-3.0F, -4.9F, -4.5F, 2, 1, 1, 0.0F, -0.3F, -0.2F, 0.7F, -0.3F, -0.2F, 0.7F, -0.3F, -0.2F, -0.7F, -0.3F, -0.2F, -0.7F, 0.5F, -0.2F, 0.7F, 0.5F, -0.2F, 0.7F, 0.5F, -0.2F, -0.7F, 0.5F, -0.2F, -0.7F);
      this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[5].addShapeBox(-4.0F, -4.7F, -4.5F, 1, 1, 1, 0.0F, 0.5F, -0.2F, 0.7F, 0.5F, -0.4F, 0.7F, 0.5F, -0.4F, -0.7F, 0.5F, -0.2F, -0.7F, -0.3F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, -0.7F, -0.3F, 0.0F, -0.7F);
      this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[6].addShapeBox(3.0F, -6.0F, -4.0F, 1, 2, 8, 0.0F, 0.0F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F);
      this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[7].addShapeBox(-3.0F, -6.0F, -4.0F, 6, 2, 8, 0.0F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.4F, 0.9F, 0.9F, -0.4F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F);
      this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[8].addShapeBox(1.0F, -4.9F, -4.5F, 2, 1, 1, 0.0F, -0.3F, -0.2F, 0.7F, -0.3F, -0.2F, 0.7F, -0.3F, -0.2F, -0.7F, -0.3F, -0.2F, -0.7F, 0.5F, -0.2F, 0.7F, 0.5F, -0.2F, 0.7F, 0.5F, -0.2F, -0.7F, 0.5F, -0.2F, -0.7F);
      this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[9].addShapeBox(3.0F, -4.7F, -4.5F, 1, 1, 1, 0.0F, 0.5F, -0.4F, 0.7F, 0.5F, -0.2F, 0.7F, 0.5F, -0.2F, -0.7F, 0.5F, -0.4F, -0.7F, 0.0F, 0.0F, 0.7F, -0.3F, 0.0F, 0.7F, -0.3F, 0.0F, -0.7F, 0.0F, 0.0F, -0.7F);
      this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[10].addShapeBox(-5.4F, -4.0F, -5.0F, 1, 3, 10, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F);
      this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[11].addShapeBox(-1.0F, -3.7F, -5.6F, 2, 1, 1, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.2F, 0.0F, -0.4F, 0.2F, 0.0F, -0.4F, 0.2F, 0.0F, -0.4F, 0.2F, 0.0F, -0.4F);
      this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[12].addShapeBox(-5.0F, -4.0F, -5.6F, 2, 1, 1, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.3F, -0.4F, 0.2F, 0.3F, -0.4F, 0.2F, 0.3F, -0.4F, 0.0F, 0.3F, -0.4F);
      this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[13].addShapeBox(3.0F, -4.0F, -5.6F, 2, 1, 1, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.2F, 0.3F, -0.4F, 0.0F, 0.3F, -0.4F, 0.0F, 0.3F, -0.4F, 0.2F, 0.3F, -0.4F);
      this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[14].addShapeBox(-5.0F, -2.7F, -5.6F, 10, 4, 1, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F);
      this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[15].addShapeBox(-5.0F, 1.3F, -5.6F, 10, 3, 1, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -2.0F, 0.0F, -0.4F, -2.0F, 0.0F, -0.4F, -2.0F, 0.0F, -0.4F, -2.0F, 0.0F, -0.4F);
      this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[16].addShapeBox(-5.4F, -1.0F, -2.0F, 1, 1, 4, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F);
      this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[17].addShapeBox(-5.4F, -1.0F, -5.0F, 1, 1, 3, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F);
      this.headModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[18].addShapeBox(-5.4F, -1.0F, 2.0F, 1, 1, 3, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F);
      this.headModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[19].addShapeBox(-5.0F, -4.0F, 4.5F, 10, 5, 1, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.3F, -0.4F, 0.0F, 0.3F, -0.4F, 0.0F, 0.3F, -0.4F, 0.0F, 0.3F, -0.4F);
      this.headModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[20].addShapeBox(-5.0F, 1.3F, 4.5F, 10, 3, 1, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -2.0F, 0.0F, -0.4F, -2.0F, 0.0F, -0.4F, -2.0F, 0.0F, -0.4F, -2.0F, 0.0F, -0.4F);
      this.headModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[21].addShapeBox(-5.4F, 0.0F, -5.0F, 1, 1, 3, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F);
      this.headModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[22].addShapeBox(-5.4F, 1.3F, -5.0F, 1, 3, 3, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -2.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F, 0.6F, -1.0F, 0.0F, -1.4F, -1.0F, 0.0F);
      this.headModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[23].addShapeBox(4.4F, -4.0F, -5.0F, 1, 3, 10, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F);
      this.headModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[24].addShapeBox(4.4F, -1.0F, 2.0F, 1, 1, 3, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F);
      this.headModel[24].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[25].addShapeBox(4.4F, -1.0F, -2.0F, 1, 1, 4, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F);
      this.headModel[25].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[26].addShapeBox(4.4F, -1.0F, -5.0F, 1, 1, 3, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F);
      this.headModel[26].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[27].addShapeBox(4.4F, 0.0F, -5.0F, 1, 1, 3, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F);
      this.headModel[27].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[28].addShapeBox(4.4F, 1.3F, -5.0F, 1, 3, 3, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F, -2.4F, 0.0F, 0.0F, -1.4F, -1.0F, 0.0F, 0.6F, -1.0F, 0.0F);
      this.headModel[28].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[29].addShapeBox(-5.4F, 0.0F, 1.9F, 1, 1, 3, 0.0F, 1.6F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F);
      this.headModel[29].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[30].addShapeBox(-5.4F, 1.3F, 1.9F, 1, 3, 3, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -1.4F, -1.0F, 0.0F, 0.6F, -1.0F, 0.0F, 1.6F, 0.0F, 0.0F, -2.4F, 0.0F, 0.0F);
      this.headModel[30].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[31].addShapeBox(4.4F, 0.0F, 1.9F, 1, 1, 3, 0.0F, -0.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F);
      this.headModel[31].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[32].addShapeBox(4.4F, 1.3F, 1.9F, 1, 3, 3, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.6F, -1.0F, 0.0F, -1.4F, -1.0F, 0.0F, -2.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F);
      this.headModel[32].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[33].addShapeBox(-0.5F, -10.8F, -0.5F, 1, 1, 1, 0.0F, 0.3F, 0.3F, 0.3F, 0.2F, 0.3F, 0.2F, 0.2F, 0.3F, 0.2F, 0.3F, 0.3F, 0.3F, 0.3F, 0.0F, 0.3F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.3F, 0.0F, 0.3F);
      this.headModel[33].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[34].addShapeBox(-0.5F, -11.8F, -0.5F, 1, 1, 1, 0.0F, 0.3F, 0.5F, -0.7F, 0.3F, 0.5F, -0.7F, 0.3F, -0.3F, 1.3F, 0.3F, -0.3F, 1.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.headModel[34].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[35].addShapeBox(-0.5F, -12.5F, 0.5F, 1, 1, 2, 0.0F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F);
      this.headModel[35].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[36].addShapeBox(-0.5F, -11.8F, 2.5F, 1, 1, 1, 0.0F, 0.3F, -0.3F, 1.3F, 0.3F, -0.3F, 1.3F, 0.3F, 0.8F, -1.0F, 0.3F, 0.8F, -1.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, -1.0F, 0.0F, 0.5F, -1.0F, 0.0F);
      this.headModel[36].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[37].addShapeBox(-0.5F, -11.8F, 2.5F, 1, 3, 1, 0.0F, 0.5F, -0.5F, 0.5F, 0.5F, -0.5F, 0.5F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.8F, 0.0F, -2.0F, 0.8F, 0.0F, -2.0F, 0.8F, 0.0F, 2.5F, 0.8F, 0.0F, 2.5F);
      this.headModel[37].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[38].addShapeBox(-0.5F, -8.8F, 4.5F, 1, 3, 1, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 0.9F, 0.3F, -1.0F, 0.9F, 0.3F, -1.0F, 0.9F, 0.0F, 1.5F, 0.9F, 0.0F, 1.5F);
      this.headModel[38].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[39].addShapeBox(-0.5F, -5.8F, 5.5F, 1, 4, 1, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 0.2F, 0.3F, 0.0F, 0.2F, 0.3F, 0.0F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F);
      this.headModel[39].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
