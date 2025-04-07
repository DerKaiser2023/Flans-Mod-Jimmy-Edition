package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelYoroi extends ModelCustomArmour {
   int textureX = 256;
   int textureY = 128;

   public ModelYoroi() {
      this.bodyModel = new ModelRendererTurbo[47];
      this.leftArmModel = new ModelRendererTurbo[10];
      this.rightArmModel = new ModelRendererTurbo[10];
      this.leftLegModel = new ModelRendererTurbo[5];
      this.rightLegModel = new ModelRendererTurbo[5];
      this.skirtFrontModel = new ModelRendererTurbo[7];
      this.skirtRearModel = new ModelRendererTurbo[7];
      this.initbodyModel_1();
      this.initleftArmModel_1();
      this.initrightArmModel_1();
      this.initleftLegModel_1();
      this.initrightLegModel_1();
      this.initskirtFrontModel_1();
      this.initskirtRearModel_1();
   }

   private void initbodyModel_1() {
      this.bodyModel[0] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.bodyModel[1] = new ModelRendererTurbo(this, 193, 9, this.textureX, this.textureY);
      this.bodyModel[2] = new ModelRendererTurbo(this, 169, 9, this.textureX, this.textureY);
      this.bodyModel[3] = new ModelRendererTurbo(this, 217, 9, this.textureX, this.textureY);
      this.bodyModel[4] = new ModelRendererTurbo(this, 241, 9, this.textureX, this.textureY);
      this.bodyModel[5] = new ModelRendererTurbo(this, 17, 17, this.textureX, this.textureY);
      this.bodyModel[6] = new ModelRendererTurbo(this, 33, 17, this.textureX, this.textureY);
      this.bodyModel[7] = new ModelRendererTurbo(this, 49, 17, this.textureX, this.textureY);
      this.bodyModel[8] = new ModelRendererTurbo(this, 65, 17, this.textureX, this.textureY);
      this.bodyModel[9] = new ModelRendererTurbo(this, 81, 17, this.textureX, this.textureY);
      this.bodyModel[10] = new ModelRendererTurbo(this, 145, 17, this.textureX, this.textureY);
      this.bodyModel[11] = new ModelRendererTurbo(this, 161, 17, this.textureX, this.textureY);
      this.bodyModel[12] = new ModelRendererTurbo(this, 185, 17, this.textureX, this.textureY);
      this.bodyModel[13] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
      this.bodyModel[14] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.bodyModel[15] = new ModelRendererTurbo(this, 241, 1, this.textureX, this.textureY);
      this.bodyModel[16] = new ModelRendererTurbo(this, 17, 25, this.textureX, this.textureY);
      this.bodyModel[17] = new ModelRendererTurbo(this, 41, 25, this.textureX, this.textureY);
      this.bodyModel[18] = new ModelRendererTurbo(this, 65, 25, this.textureX, this.textureY);
      this.bodyModel[19] = new ModelRendererTurbo(this, 89, 25, this.textureX, this.textureY);
      this.bodyModel[20] = new ModelRendererTurbo(this, 113, 25, this.textureX, this.textureY);
      this.bodyModel[21] = new ModelRendererTurbo(this, 177, 25, this.textureX, this.textureY);
      this.bodyModel[22] = new ModelRendererTurbo(this, 193, 25, this.textureX, this.textureY);
      this.bodyModel[23] = new ModelRendererTurbo(this, 217, 25, this.textureX, this.textureY);
      this.bodyModel[24] = new ModelRendererTurbo(this, 241, 25, this.textureX, this.textureY);
      this.bodyModel[25] = new ModelRendererTurbo(this, 17, 33, this.textureX, this.textureY);
      this.bodyModel[26] = new ModelRendererTurbo(this, 41, 33, this.textureX, this.textureY);
      this.bodyModel[27] = new ModelRendererTurbo(this, 81, 33, this.textureX, this.textureY);
      this.bodyModel[28] = new ModelRendererTurbo(this, 217, 41, this.textureX, this.textureY);
      this.bodyModel[29] = new ModelRendererTurbo(this, 105, 33, this.textureX, this.textureY);
      this.bodyModel[30] = new ModelRendererTurbo(this, 129, 33, this.textureX, this.textureY);
      this.bodyModel[31] = new ModelRendererTurbo(this, 169, 33, this.textureX, this.textureY);
      this.bodyModel[32] = new ModelRendererTurbo(this, 193, 33, this.textureX, this.textureY);
      this.bodyModel[33] = new ModelRendererTurbo(this, 217, 33, this.textureX, this.textureY);
      this.bodyModel[34] = new ModelRendererTurbo(this, 241, 33, this.textureX, this.textureY);
      this.bodyModel[35] = new ModelRendererTurbo(this, 17, 41, this.textureX, this.textureY);
      this.bodyModel[36] = new ModelRendererTurbo(this, 41, 41, this.textureX, this.textureY);
      this.bodyModel[37] = new ModelRendererTurbo(this, 233, 49, this.textureX, this.textureY);
      this.bodyModel[38] = new ModelRendererTurbo(this, 1, 57, this.textureX, this.textureY);
      this.bodyModel[39] = new ModelRendererTurbo(this, 57, 57, this.textureX, this.textureY);
      this.bodyModel[40] = new ModelRendererTurbo(this, 121, 57, this.textureX, this.textureY);
      this.bodyModel[41] = new ModelRendererTurbo(this, 49, 41, this.textureX, this.textureY);
      this.bodyModel[42] = new ModelRendererTurbo(this, 241, 41, this.textureX, this.textureY);
      this.bodyModel[43] = new ModelRendererTurbo(this, 217, 57, this.textureX, this.textureY);
      this.bodyModel[44] = new ModelRendererTurbo(this, 1, 65, this.textureX, this.textureY);
      this.bodyModel[45] = new ModelRendererTurbo(this, 25, 65, this.textureX, this.textureY);
      this.bodyModel[46] = new ModelRendererTurbo(this, 49, 65, this.textureX, this.textureY);
      this.bodyModel[0].addShapeBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F);
      this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[1].addShapeBox(-3.0F, 4.0F, -2.1F, 6, 6, 4, 0.0F, 0.8F, 0.8F, 1.0F, 0.8F, 0.8F, 1.0F, 0.8F, 0.8F, 0.8F, 0.8F, 0.8F, 0.8F, 0.8F, 0.3F, 1.0F, 0.8F, 0.3F, 1.0F, 0.8F, 0.3F, 0.8F, 0.8F, 0.3F, 0.8F);
      this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[2].addShapeBox(-3.0F, 1.5F, -3.2F, 1, 5, 5, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F);
      this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[3].addShapeBox(2.0F, 1.5F, -3.2F, 1, 5, 5, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F);
      this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[4].addShapeBox(-4.0F, 7.0F, -2.0F, 1, 3, 4, 0.0F, 0.8F, 0.3F, 0.8F, -0.8F, 0.3F, 0.8F, -0.8F, 0.3F, 0.8F, 0.8F, 0.3F, 0.8F, 0.8F, 0.3F, 0.8F, -0.8F, 0.3F, 0.8F, -0.8F, 0.3F, 0.8F, 0.8F, 0.3F, 0.8F);
      this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[5].addShapeBox(-4.0F, 5.0F, -2.0F, 1, 2, 4, 0.0F, 1.0F, -0.7F, 0.8F, -0.8F, 0.0F, 0.8F, -0.8F, 0.0F, 0.8F, 1.0F, -0.7F, 0.8F, 0.8F, -0.3F, 0.8F, -0.8F, -0.3F, 0.8F, -0.8F, -0.3F, 0.8F, 0.8F, -0.3F, 0.8F);
      this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[6].addShapeBox(-3.0F, -0.5F, -3.0F, 1, 1, 6, 0.0F, -0.1F, 0.3F, -0.2F, -0.1F, 0.3F, -0.2F, -0.1F, 0.3F, -0.2F, -0.1F, 0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F);
      this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[7].addShapeBox(2.0F, -0.5F, -3.0F, 1, 1, 6, 0.0F, -0.1F, 0.3F, -0.2F, -0.1F, 0.3F, -0.2F, -0.1F, 0.3F, -0.2F, -0.1F, 0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F);
      this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[8].addShapeBox(-3.0F, 0.5F, -3.0F, 1, 1, 6, 0.0F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F);
      this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[9].addShapeBox(2.0F, 0.5F, -3.0F, 1, 1, 6, 0.0F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F);
      this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[10].addShapeBox(3.0F, 5.0F, -2.0F, 1, 2, 4, 0.0F, -0.8F, 0.0F, 0.8F, 1.0F, -0.7F, 0.8F, 1.0F, -0.7F, 0.8F, -0.8F, 0.0F, 0.8F, -0.8F, -0.3F, 0.8F, 0.8F, -0.3F, 0.8F, 0.8F, -0.3F, 0.8F, -0.8F, -0.3F, 0.8F);
      this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[11].addShapeBox(3.0F, 7.0F, -2.0F, 1, 3, 4, 0.0F, -0.8F, 0.3F, 0.8F, 0.8F, 0.3F, 0.8F, 0.8F, 0.3F, 0.8F, -0.8F, 0.3F, 0.8F, -0.8F, 0.3F, 0.8F, 0.8F, 0.3F, 0.8F, 0.8F, 0.3F, 0.8F, -0.8F, 0.3F, 0.8F);
      this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[12].addShapeBox(-4.5F, 10.5F, -2.0F, 1, 7, 4, 0.0F, 0.0F, 0.3F, 0.8F, -0.5F, 0.3F, 0.8F, -0.5F, 0.3F, 0.8F, 0.0F, 0.3F, 0.8F, 1.0F, 0.3F, 1.8F, -1.5F, 0.3F, 1.8F, -1.5F, 0.3F, 1.8F, 1.0F, 0.3F, 1.8F);
      this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[13].addShapeBox(-3.0F, 0.5F, 2.0F, 1, 2, 1, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 1.0F, 0.3F, 0.0F, 1.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F);
      this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[14].addShapeBox(2.0F, 0.5F, 2.0F, 1, 2, 1, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 1.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 1.0F, 0.3F, 0.0F);
      this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[15].addShapeBox(-3.0F, 3.1F, 2.0F, 6, 1, 1, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F);
      this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[16].addShapeBox(-4.5F, 15.5F, -2.0F, 1, 1, 4, 0.0F, 0.8F, -0.1F, 1.4F, -0.5F, -0.1F, 1.4F, -0.5F, -0.1F, 1.4F, 0.8F, -0.1F, 1.4F, 1.0F, -0.1F, 1.5F, -1.5F, -0.1F, 1.5F, -1.5F, -0.1F, 1.5F, 1.0F, -0.1F, 1.5F);
      this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[17].addShapeBox(-4.3F, 14.5F, -2.0F, 1, 1, 4, 0.0F, 0.8F, -0.1F, 1.3F, -0.5F, -0.1F, 1.3F, -0.5F, -0.1F, 1.3F, 0.8F, -0.1F, 1.3F, 1.0F, -0.1F, 1.4F, -1.5F, -0.1F, 1.4F, -1.5F, -0.1F, 1.4F, 1.0F, -0.1F, 1.4F);
      this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[18].addShapeBox(-4.15F, 13.5F, -2.0F, 1, 1, 4, 0.0F, 0.8F, -0.1F, 1.2F, -0.5F, -0.1F, 1.2F, -0.5F, -0.1F, 1.2F, 0.8F, -0.1F, 1.2F, 1.0F, -0.1F, 1.3F, -1.5F, -0.1F, 1.3F, -1.5F, -0.1F, 1.3F, 1.0F, -0.1F, 1.3F);
      this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[19].addShapeBox(-4.05F, 12.5F, -2.0F, 1, 1, 4, 0.0F, 0.8F, -0.1F, 1.1F, -0.5F, -0.1F, 1.1F, -0.5F, -0.1F, 1.1F, 0.8F, -0.1F, 1.1F, 1.0F, -0.1F, 1.2F, -1.5F, -0.1F, 1.2F, -1.5F, -0.1F, 1.2F, 1.0F, -0.1F, 1.2F);
      this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[20].addShapeBox(-3.9F, 11.5F, -2.0F, 1, 1, 4, 0.0F, 0.8F, -0.1F, 1.0F, -0.5F, -0.1F, 1.0F, -0.5F, -0.1F, 1.0F, 0.8F, -0.1F, 1.0F, 1.0F, -0.1F, 1.1F, -1.5F, -0.1F, 1.1F, -1.5F, -0.1F, 1.1F, 1.0F, -0.1F, 1.1F);
      this.bodyModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[21].addShapeBox(-3.8F, 10.5F, -2.0F, 1, 1, 4, 0.0F, 0.8F, -0.1F, 0.9F, -0.5F, -0.1F, 0.9F, -0.5F, -0.1F, 0.9F, 0.8F, -0.1F, 0.9F, 1.0F, -0.1F, 1.0F, -1.5F, -0.1F, 1.0F, -1.5F, -0.1F, 1.0F, 1.0F, -0.1F, 1.0F);
      this.bodyModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[22].addShapeBox(2.8F, 10.5F, -2.0F, 1, 1, 4, 0.0F, -0.5F, -0.1F, 0.9F, 0.8F, -0.1F, 0.9F, 0.8F, -0.1F, 0.9F, -0.5F, -0.1F, 0.9F, -1.5F, -0.1F, 1.0F, 1.0F, -0.1F, 1.0F, 1.0F, -0.1F, 1.0F, -1.5F, -0.1F, 1.0F);
      this.bodyModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[23].addShapeBox(2.9F, 11.5F, -2.0F, 1, 1, 4, 0.0F, -0.5F, -0.1F, 1.0F, 0.8F, -0.1F, 1.0F, 0.8F, -0.1F, 1.0F, -0.5F, -0.1F, 1.0F, -1.5F, -0.1F, 1.1F, 1.0F, -0.1F, 1.1F, 1.0F, -0.1F, 1.1F, -1.5F, -0.1F, 1.1F);
      this.bodyModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[24].addShapeBox(3.05F, 12.5F, -2.0F, 1, 1, 4, 0.0F, -0.5F, -0.1F, 1.1F, 0.8F, -0.1F, 1.1F, 0.8F, -0.1F, 1.1F, -0.5F, -0.1F, 1.1F, -1.5F, -0.1F, 1.2F, 1.0F, -0.1F, 1.2F, 1.0F, -0.1F, 1.2F, -1.5F, -0.1F, 1.2F);
      this.bodyModel[24].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[25].addShapeBox(3.25F, 13.5F, -2.0F, 1, 1, 4, 0.0F, -0.5F, -0.1F, 1.2F, 0.8F, -0.1F, 1.2F, 0.8F, -0.1F, 1.2F, -0.5F, -0.1F, 1.2F, -1.5F, -0.1F, 1.3F, 1.0F, -0.1F, 1.3F, 1.0F, -0.1F, 1.3F, -1.5F, -0.1F, 1.3F);
      this.bodyModel[25].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[26].addShapeBox(3.3F, 14.5F, -2.0F, 1, 1, 4, 0.0F, -0.5F, -0.1F, 1.3F, 0.8F, -0.1F, 1.3F, 0.8F, -0.1F, 1.3F, -0.5F, -0.1F, 1.3F, -1.5F, -0.1F, 1.4F, 1.0F, -0.1F, 1.4F, 1.0F, -0.1F, 1.4F, -1.5F, -0.1F, 1.4F);
      this.bodyModel[26].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[27].addShapeBox(3.5F, 15.5F, -2.0F, 1, 1, 4, 0.0F, -0.5F, -0.1F, 1.4F, 0.8F, -0.1F, 1.4F, 0.8F, -0.1F, 1.4F, -0.5F, -0.1F, 1.4F, -1.5F, -0.1F, 1.5F, 1.0F, -0.1F, 1.5F, 1.0F, -0.1F, 1.5F, -1.5F, -0.1F, 1.5F);
      this.bodyModel[27].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[28].addShapeBox(3.5F, 10.5F, -2.0F, 1, 7, 4, 0.0F, -0.5F, 0.3F, 0.8F, 0.0F, 0.3F, 0.8F, 0.0F, 0.3F, 0.8F, -0.5F, 0.3F, 0.8F, -1.5F, 0.3F, 1.8F, 1.0F, 0.3F, 1.8F, 1.0F, 0.3F, 1.8F, -1.5F, 0.3F, 1.8F);
      this.bodyModel[28].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[29].addShapeBox(-4.0F, 9.3F, -2.0F, 1, 1, 4, 0.0F, 0.8F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F);
      this.bodyModel[29].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[30].addShapeBox(-4.0F, 8.3F, -2.0F, 1, 1, 4, 0.0F, 0.8F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F);
      this.bodyModel[30].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[31].addShapeBox(-4.0F, 7.3F, -2.0F, 1, 1, 4, 0.0F, 0.8F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F);
      this.bodyModel[31].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[32].addShapeBox(-4.0F, 6.3F, -2.0F, 1, 1, 4, 0.0F, 0.8F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F);
      this.bodyModel[32].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[33].addShapeBox(3.0F, 6.3F, -2.0F, 1, 1, 4, 0.0F, -0.5F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F);
      this.bodyModel[33].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[34].addShapeBox(3.0F, 7.3F, -2.0F, 1, 1, 4, 0.0F, -0.5F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F);
      this.bodyModel[34].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[35].addShapeBox(3.0F, 8.3F, -2.0F, 1, 1, 4, 0.0F, -0.5F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F);
      this.bodyModel[35].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[36].addShapeBox(3.0F, 9.3F, -2.0F, 1, 1, 4, 0.0F, -0.5F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F);
      this.bodyModel[36].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[37].addShapeBox(-4.0F, 6.3F, 1.0F, 8, 1, 1, 0.0F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F);
      this.bodyModel[37].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[38].addShapeBox(-4.0F, 7.3F, 1.0F, 8, 1, 1, 0.0F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F);
      this.bodyModel[38].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[39].addShapeBox(-4.0F, 8.3F, 1.0F, 8, 1, 1, 0.0F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F);
      this.bodyModel[39].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[40].addShapeBox(-4.0F, 9.3F, 1.0F, 8, 1, 1, 0.0F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F);
      this.bodyModel[40].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[41].addShapeBox(-3.0F, 5.3F, 1.0F, 6, 1, 1, 0.0F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F);
      this.bodyModel[41].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[42].addShapeBox(-3.0F, 4.3F, 1.0F, 6, 1, 1, 0.0F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F);
      this.bodyModel[42].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[43].addShapeBox(-4.0F, 6.3F, -2.0F, 8, 1, 1, 0.0F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F);
      this.bodyModel[43].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[44].addShapeBox(-4.0F, 7.3F, -2.0F, 8, 1, 1, 0.0F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F);
      this.bodyModel[44].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[45].addShapeBox(-4.0F, 8.3F, -2.0F, 8, 1, 1, 0.0F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F);
      this.bodyModel[45].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[46].addShapeBox(-4.0F, 9.3F, -2.0F, 8, 1, 1, 0.0F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F);
      this.bodyModel[46].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initleftArmModel_1() {
      this.leftArmModel[0] = new ModelRendererTurbo(this, 73, 1, this.textureX, this.textureY);
      this.leftArmModel[1] = new ModelRendererTurbo(this, 65, 33, this.textureX, this.textureY);
      this.leftArmModel[2] = new ModelRendererTurbo(this, 89, 33, this.textureX, this.textureY);
      this.leftArmModel[3] = new ModelRendererTurbo(this, 113, 33, this.textureX, this.textureY);
      this.leftArmModel[4] = new ModelRendererTurbo(this, 153, 33, this.textureX, this.textureY);
      this.leftArmModel[5] = new ModelRendererTurbo(this, 177, 33, this.textureX, this.textureY);
      this.leftArmModel[6] = new ModelRendererTurbo(this, 201, 33, this.textureX, this.textureY);
      this.leftArmModel[7] = new ModelRendererTurbo(this, 225, 33, this.textureX, this.textureY);
      this.leftArmModel[8] = new ModelRendererTurbo(this, 1, 41, this.textureX, this.textureY);
      this.leftArmModel[9] = new ModelRendererTurbo(this, 65, 65, this.textureX, this.textureY);
      this.leftArmModel[0].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 10, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F);
      this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[1].addShapeBox(2.8F, -2.5F, -3.5F, 1, 9, 7, 0.0F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, -0.5F, 0.2F, -0.2F, -0.5F, 0.2F, -0.2F, -0.5F, 0.2F, -0.2F, -0.5F, 0.2F);
      this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[2].addShapeBox(2.9F, -0.6F, -3.5F, 1, 1, 7, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F);
      this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[3].addShapeBox(2.9F, -1.6F, -3.5F, 1, 1, 7, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F);
      this.leftArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[4].addShapeBox(2.9F, -2.6F, -3.5F, 1, 1, 7, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F);
      this.leftArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[5].addShapeBox(2.9F, 0.4F, -3.5F, 1, 1, 7, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F);
      this.leftArmModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[6].addShapeBox(2.9F, 1.4F, -3.5F, 1, 1, 7, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F);
      this.leftArmModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[7].addShapeBox(2.9F, 2.4F, -3.5F, 1, 1, 7, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F);
      this.leftArmModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[8].addShapeBox(2.9F, 3.4F, -3.5F, 1, 1, 7, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F);
      this.leftArmModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[9].addShapeBox(2.9F, 4.4F, -3.5F, 1, 1, 7, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F);
      this.leftArmModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initrightArmModel_1() {
      this.rightArmModel[0] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.rightArmModel[1] = new ModelRendererTurbo(this, 25, 41, this.textureX, this.textureY);
      this.rightArmModel[2] = new ModelRendererTurbo(this, 129, 41, this.textureX, this.textureY);
      this.rightArmModel[3] = new ModelRendererTurbo(this, 41, 49, this.textureX, this.textureY);
      this.rightArmModel[4] = new ModelRendererTurbo(this, 81, 49, this.textureX, this.textureY);
      this.rightArmModel[5] = new ModelRendererTurbo(this, 105, 49, this.textureX, this.textureY);
      this.rightArmModel[6] = new ModelRendererTurbo(this, 145, 49, this.textureX, this.textureY);
      this.rightArmModel[7] = new ModelRendererTurbo(this, 169, 49, this.textureX, this.textureY);
      this.rightArmModel[8] = new ModelRendererTurbo(this, 193, 49, this.textureX, this.textureY);
      this.rightArmModel[9] = new ModelRendererTurbo(this, 233, 57, this.textureX, this.textureY);
      this.rightArmModel[0].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 10, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F);
      this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[1].addShapeBox(-4.0F, 3.4F, -3.5F, 1, 1, 7, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F);
      this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[2].addShapeBox(-4.0F, -2.6F, -3.5F, 1, 1, 7, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F);
      this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[3].addShapeBox(-4.0F, -1.6F, -3.5F, 1, 1, 7, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F);
      this.rightArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[4].addShapeBox(-4.0F, -0.6F, -3.5F, 1, 1, 7, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F);
      this.rightArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[5].addShapeBox(-4.0F, 0.4F, -3.5F, 1, 1, 7, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F);
      this.rightArmModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[6].addShapeBox(-4.0F, 1.4F, -3.5F, 1, 1, 7, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F);
      this.rightArmModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[7].addShapeBox(-4.0F, 2.4F, -3.5F, 1, 1, 7, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F);
      this.rightArmModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[8].addShapeBox(-3.9F, -2.5F, -3.5F, 1, 9, 7, 0.0F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, -0.5F, 0.2F, -0.2F, -0.5F, 0.2F, -0.2F, -0.5F, 0.2F, -0.2F, -0.5F, 0.2F);
      this.rightArmModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[9].addShapeBox(-4.0F, 4.4F, -3.5F, 1, 1, 7, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.15F, -0.1F, 0.0F);
      this.rightArmModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initleftLegModel_1() {
      this.leftLegModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.leftLegModel[1] = new ModelRendererTurbo(this, 177, 1, this.textureX, this.textureY);
      this.leftLegModel[2] = new ModelRendererTurbo(this, 201, 1, this.textureX, this.textureY);
      this.leftLegModel[3] = new ModelRendererTurbo(this, 1, 9, this.textureX, this.textureY);
      this.leftLegModel[4] = new ModelRendererTurbo(this, 25, 9, this.textureX, this.textureY);
      this.leftLegModel[0].addShapeBox(-2.0F, 0.0F, -2.0F, 4, 1, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F);
      this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftLegModel[1].addShapeBox(-2.0F, 1.0F, -2.0F, 4, 5, 4, 0.0F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F);
      this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftLegModel[2].addShapeBox(-2.0F, 6.0F, -2.0F, 4, 1, 4, 0.0F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftLegModel[3].addShapeBox(-2.0F, 7.0F, -2.0F, 4, 4, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
      this.leftLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftLegModel[4].addShapeBox(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F, 0.1F, -0.5F, 0.4F, 0.1F, -0.5F, 0.4F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, 0.0F, 0.4F, 0.1F, 0.0F, 0.4F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.leftLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initrightLegModel_1() {
      this.rightLegModel[0] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.rightLegModel[1] = new ModelRendererTurbo(this, 129, 1, this.textureX, this.textureY);
      this.rightLegModel[2] = new ModelRendererTurbo(this, 153, 1, this.textureX, this.textureY);
      this.rightLegModel[3] = new ModelRendererTurbo(this, 225, 1, this.textureX, this.textureY);
      this.rightLegModel[4] = new ModelRendererTurbo(this, 145, 9, this.textureX, this.textureY);
      this.rightLegModel[0].addShapeBox(-2.0F, 0.0F, -2.0F, 4, 1, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F);
      this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightLegModel[1].addShapeBox(-2.0F, 1.0F, -2.0F, 4, 5, 4, 0.0F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F);
      this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightLegModel[2].addShapeBox(-2.0F, 6.0F, -2.0F, 4, 1, 4, 0.0F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightLegModel[3].addShapeBox(-2.0F, 7.0F, -2.0F, 4, 4, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
      this.rightLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightLegModel[4].addShapeBox(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F, 0.1F, -0.5F, 0.4F, 0.1F, -0.5F, 0.4F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, 0.0F, 0.4F, 0.1F, 0.0F, 0.4F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.rightLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initskirtFrontModel_1() {
      this.skirtFrontModel[0] = new ModelRendererTurbo(this, 121, 17, this.textureX, this.textureY);
      this.skirtFrontModel[1] = new ModelRendererTurbo(this, 233, 17, this.textureX, this.textureY);
      this.skirtFrontModel[2] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.skirtFrontModel[3] = new ModelRendererTurbo(this, 25, 25, this.textureX, this.textureY);
      this.skirtFrontModel[4] = new ModelRendererTurbo(this, 49, 25, this.textureX, this.textureY);
      this.skirtFrontModel[5] = new ModelRendererTurbo(this, 73, 25, this.textureX, this.textureY);
      this.skirtFrontModel[6] = new ModelRendererTurbo(this, 97, 25, this.textureX, this.textureY);
      this.skirtFrontModel[0].addShapeBox(-3.5F, -1.5F, -3.0F, 7, 7, 1, 0.0F, 0.8F, 0.3F, 0.0F, 0.8F, 0.3F, 0.0F, 0.8F, 0.3F, -0.5F, 0.8F, 0.3F, -0.5F, 1.8F, 0.3F, 1.0F, 1.8F, 0.3F, 1.0F, 1.8F, 0.3F, -1.5F, 1.8F, 0.3F, -1.5F);
      this.skirtFrontModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtFrontModel[1].addShapeBox(-4.0F, 3.5F, -4.0F, 8, 1, 1, 0.0F, 0.9F, -0.1F, -0.2F, 0.9F, -0.1F, -0.2F, 0.9F, -0.1F, -0.3F, 0.9F, -0.1F, -0.3F, 0.9F, -0.1F, 0.0F, 0.9F, -0.1F, 0.0F, 0.9F, -0.1F, -0.3F, 0.9F, -0.1F, -0.3F);
      this.skirtFrontModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtFrontModel[2].addShapeBox(-4.0F, 2.5F, -3.9F, 8, 1, 1, 0.0F, 0.8F, -0.1F, -0.2F, 0.8F, -0.1F, -0.2F, 0.8F, -0.1F, -0.3F, 0.8F, -0.1F, -0.3F, 0.8F, -0.1F, 0.0F, 0.8F, -0.1F, 0.0F, 0.8F, -0.1F, -0.3F, 0.8F, -0.1F, -0.3F);
      this.skirtFrontModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtFrontModel[3].addShapeBox(-4.0F, 1.5F, -3.8F, 8, 1, 1, 0.0F, 0.7F, -0.1F, -0.2F, 0.7F, -0.1F, -0.2F, 0.7F, -0.1F, -0.3F, 0.7F, -0.1F, -0.3F, 0.7F, -0.1F, 0.0F, 0.7F, -0.1F, 0.0F, 0.7F, -0.1F, -0.3F, 0.7F, -0.1F, -0.3F);
      this.skirtFrontModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtFrontModel[4].addShapeBox(-4.0F, 0.5F, -3.7F, 8, 1, 1, 0.0F, 0.6F, -0.1F, -0.2F, 0.6F, -0.1F, -0.2F, 0.6F, -0.1F, -0.3F, 0.6F, -0.1F, -0.3F, 0.6F, -0.1F, 0.0F, 0.6F, -0.1F, 0.0F, 0.6F, -0.1F, -0.3F, 0.6F, -0.1F, -0.3F);
      this.skirtFrontModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtFrontModel[5].addShapeBox(-4.0F, -0.5F, -3.6F, 8, 1, 1, 0.0F, 0.5F, -0.1F, -0.2F, 0.5F, -0.1F, -0.2F, 0.5F, -0.1F, -0.3F, 0.5F, -0.1F, -0.3F, 0.5F, -0.1F, 0.0F, 0.5F, -0.1F, 0.0F, 0.5F, -0.1F, -0.3F, 0.5F, -0.1F, -0.3F);
      this.skirtFrontModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtFrontModel[6].addShapeBox(-4.0F, -1.5F, -3.5F, 8, 1, 1, 0.0F, 0.4F, -0.1F, -0.2F, 0.4F, -0.1F, -0.2F, 0.4F, -0.1F, -0.3F, 0.4F, -0.1F, -0.3F, 0.4F, -0.1F, 0.0F, 0.4F, -0.1F, 0.0F, 0.4F, -0.1F, -0.3F, 0.4F, -0.1F, -0.3F);
      this.skirtFrontModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initskirtRearModel_1() {
      this.skirtRearModel[0] = new ModelRendererTurbo(this, 137, 25, this.textureX, this.textureY);
      this.skirtRearModel[1] = new ModelRendererTurbo(this, 161, 25, this.textureX, this.textureY);
      this.skirtRearModel[2] = new ModelRendererTurbo(this, 201, 25, this.textureX, this.textureY);
      this.skirtRearModel[3] = new ModelRendererTurbo(this, 225, 25, this.textureX, this.textureY);
      this.skirtRearModel[4] = new ModelRendererTurbo(this, 1, 33, this.textureX, this.textureY);
      this.skirtRearModel[5] = new ModelRendererTurbo(this, 25, 33, this.textureX, this.textureY);
      this.skirtRearModel[6] = new ModelRendererTurbo(this, 49, 33, this.textureX, this.textureY);
      this.skirtRearModel[0].addShapeBox(-3.5F, -1.5F, 2.0F, 7, 7, 1, 0.0F, 0.8F, 0.3F, -0.5F, 0.8F, 0.3F, -0.5F, 0.8F, 0.3F, 0.0F, 0.8F, 0.3F, 0.0F, 1.8F, 0.3F, -1.5F, 1.8F, 0.3F, -1.5F, 1.8F, 0.3F, 1.0F, 1.8F, 0.3F, 1.0F);
      this.skirtRearModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtRearModel[1].addShapeBox(-4.0F, -1.5F, 2.5F, 8, 1, 1, 0.0F, 0.4F, -0.1F, -0.3F, 0.4F, -0.1F, -0.3F, 0.4F, -0.1F, -0.2F, 0.4F, -0.1F, -0.2F, 0.4F, -0.1F, -0.3F, 0.4F, -0.1F, -0.3F, 0.4F, -0.1F, 0.0F, 0.4F, -0.1F, 0.0F);
      this.skirtRearModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtRearModel[2].addShapeBox(-4.0F, -0.5F, 2.6F, 8, 1, 1, 0.0F, 0.5F, -0.1F, -0.3F, 0.5F, -0.1F, -0.3F, 0.5F, -0.1F, -0.2F, 0.5F, -0.1F, -0.2F, 0.5F, -0.1F, -0.3F, 0.5F, -0.1F, -0.3F, 0.5F, -0.1F, 0.0F, 0.5F, -0.1F, 0.0F);
      this.skirtRearModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtRearModel[3].addShapeBox(-4.0F, 0.5F, 2.7F, 8, 1, 1, 0.0F, 0.6F, -0.1F, -0.3F, 0.6F, -0.1F, -0.3F, 0.6F, -0.1F, -0.2F, 0.6F, -0.1F, -0.2F, 0.6F, -0.1F, -0.3F, 0.6F, -0.1F, -0.3F, 0.6F, -0.1F, 0.0F, 0.6F, -0.1F, 0.0F);
      this.skirtRearModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtRearModel[4].addShapeBox(-4.0F, 1.5F, 2.8F, 8, 1, 1, 0.0F, 0.7F, -0.1F, -0.3F, 0.7F, -0.1F, -0.3F, 0.7F, -0.1F, -0.2F, 0.7F, -0.1F, -0.2F, 0.7F, -0.1F, -0.3F, 0.7F, -0.1F, -0.3F, 0.7F, -0.1F, 0.0F, 0.7F, -0.1F, 0.0F);
      this.skirtRearModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtRearModel[5].addShapeBox(-4.0F, 2.5F, 2.9F, 8, 1, 1, 0.0F, 0.8F, -0.1F, -0.3F, 0.8F, -0.1F, -0.3F, 0.8F, -0.1F, -0.2F, 0.8F, -0.1F, -0.2F, 0.8F, -0.1F, -0.3F, 0.8F, -0.1F, -0.3F, 0.8F, -0.1F, 0.0F, 0.8F, -0.1F, 0.0F);
      this.skirtRearModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtRearModel[6].addShapeBox(-4.0F, 3.5F, 3.0F, 8, 1, 1, 0.0F, 0.9F, -0.1F, -0.3F, 0.9F, -0.1F, -0.3F, 0.9F, -0.1F, -0.2F, 0.9F, -0.1F, -0.2F, 0.9F, -0.1F, -0.3F, 0.9F, -0.1F, -0.3F, 0.9F, -0.1F, 0.0F, 0.9F, -0.1F, 0.0F);
      this.skirtRearModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
