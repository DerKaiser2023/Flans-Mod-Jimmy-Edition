package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelAshigaruArmor extends ModelCustomArmour {
   int textureX = 256;
   int textureY = 64;

   public ModelAshigaruArmor() {
      this.bodyModel = new ModelRendererTurbo[31];
      this.leftArmModel = new ModelRendererTurbo[4];
      this.rightArmModel = new ModelRendererTurbo[4];
      this.leftLegModel = new ModelRendererTurbo[5];
      this.rightLegModel = new ModelRendererTurbo[5];
      this.skirtFrontModel = new ModelRendererTurbo[12];
      this.skirtRearModel = new ModelRendererTurbo[12];
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
      this.bodyModel[2] = new ModelRendererTurbo(this, 209, 9, this.textureX, this.textureY);
      this.bodyModel[3] = new ModelRendererTurbo(this, 241, 9, this.textureX, this.textureY);
      this.bodyModel[4] = new ModelRendererTurbo(this, 17, 17, this.textureX, this.textureY);
      this.bodyModel[5] = new ModelRendererTurbo(this, 49, 17, this.textureX, this.textureY);
      this.bodyModel[6] = new ModelRendererTurbo(this, 73, 17, this.textureX, this.textureY);
      this.bodyModel[7] = new ModelRendererTurbo(this, 121, 17, this.textureX, this.textureY);
      this.bodyModel[8] = new ModelRendererTurbo(this, 145, 17, this.textureX, this.textureY);
      this.bodyModel[9] = new ModelRendererTurbo(this, 169, 17, this.textureX, this.textureY);
      this.bodyModel[10] = new ModelRendererTurbo(this, 193, 17, this.textureX, this.textureY);
      this.bodyModel[11] = new ModelRendererTurbo(this, 209, 9, this.textureX, this.textureY);
      this.bodyModel[12] = new ModelRendererTurbo(this, 241, 9, this.textureX, this.textureY);
      this.bodyModel[13] = new ModelRendererTurbo(this, 17, 17, this.textureX, this.textureY);
      this.bodyModel[14] = new ModelRendererTurbo(this, 33, 17, this.textureX, this.textureY);
      this.bodyModel[15] = new ModelRendererTurbo(this, 49, 17, this.textureX, this.textureY);
      this.bodyModel[16] = new ModelRendererTurbo(this, 121, 17, this.textureX, this.textureY);
      this.bodyModel[17] = new ModelRendererTurbo(this, 249, 25, this.textureX, this.textureY);
      this.bodyModel[18] = new ModelRendererTurbo(this, 33, 33, this.textureX, this.textureY);
      this.bodyModel[19] = new ModelRendererTurbo(this, 49, 33, this.textureX, this.textureY);
      this.bodyModel[20] = new ModelRendererTurbo(this, 65, 33, this.textureX, this.textureY);
      this.bodyModel[21] = new ModelRendererTurbo(this, 81, 33, this.textureX, this.textureY);
      this.bodyModel[22] = new ModelRendererTurbo(this, 97, 33, this.textureX, this.textureY);
      this.bodyModel[23] = new ModelRendererTurbo(this, 113, 33, this.textureX, this.textureY);
      this.bodyModel[24] = new ModelRendererTurbo(this, 129, 33, this.textureX, this.textureY);
      this.bodyModel[25] = new ModelRendererTurbo(this, 145, 33, this.textureX, this.textureY);
      this.bodyModel[26] = new ModelRendererTurbo(this, 161, 33, this.textureX, this.textureY);
      this.bodyModel[27] = new ModelRendererTurbo(this, 241, 33, this.textureX, this.textureY);
      this.bodyModel[28] = new ModelRendererTurbo(this, 249, 33, this.textureX, this.textureY);
      this.bodyModel[29] = new ModelRendererTurbo(this, 1, 41, this.textureX, this.textureY);
      this.bodyModel[30] = new ModelRendererTurbo(this, 9, 41, this.textureX, this.textureY);
      this.bodyModel[0].addShapeBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F);
      this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[1].addShapeBox(-3.0F, -0.5F, -3.0F, 1, 1, 6, 0.0F, -0.1F, 0.3F, -0.2F, -0.1F, 0.3F, -0.2F, -0.1F, 0.3F, -0.2F, -0.1F, 0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F);
      this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[2].addShapeBox(2.0F, -0.5F, -3.0F, 1, 1, 6, 0.0F, -0.1F, 0.3F, -0.2F, -0.1F, 0.3F, -0.2F, -0.1F, 0.3F, -0.2F, -0.1F, 0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F);
      this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[3].addShapeBox(-3.0F, 0.5F, -3.0F, 1, 2, 6, 0.0F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F);
      this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[4].addShapeBox(2.0F, 0.5F, -3.0F, 1, 2, 6, 0.0F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F);
      this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[5].addShapeBox(-4.0F, 6.5F, -2.4F, 4, 3, 5, 0.0F, 0.6F, 0.0F, 0.7F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.6F, 0.0F, 0.5F, 0.2F, 0.0F, 0.3F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.4F, 0.5F, 0.0F, 0.2F);
      this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[6].addShapeBox(-4.0F, 3.5F, -2.4F, 4, 3, 5, 0.0F, 0.6F, 0.0F, 0.7F, 0.0F, 0.0F, 1.2F, 0.0F, 0.0F, 1.0F, 0.6F, 0.0F, 0.5F, 0.6F, 0.0F, 0.7F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.6F, 0.0F, 0.4F);
      this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[7].addShapeBox(-4.0F, 1.5F, -2.4F, 4, 2, 5, 0.0F, -0.2F, 0.5F, 0.5F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 0.4F, -0.2F, 0.5F, 0.2F, 0.6F, 0.0F, 0.7F, 0.0F, 0.0F, 1.2F, 0.0F, 0.0F, 1.0F, 0.6F, 0.0F, 0.5F);
      this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[8].addShapeBox(0.0F, 1.5F, -2.4F, 4, 2, 5, 0.0F, 0.0F, 0.5F, 0.8F, -0.2F, 0.5F, 0.5F, -0.2F, 0.5F, 0.2F, 0.0F, 0.5F, 0.4F, 0.0F, 0.0F, 1.2F, 0.6F, 0.0F, 0.7F, 0.6F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0F);
      this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[9].addShapeBox(0.0F, 3.5F, -2.4F, 4, 3, 5, 0.0F, 0.0F, 0.0F, 1.2F, 0.6F, 0.0F, 0.7F, 0.6F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.6F, 0.0F, 0.7F, 0.6F, 0.0F, 0.4F, 0.0F, 0.0F, 1.0F);
      this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[10].addShapeBox(0.0F, 6.5F, -2.4F, 4, 3, 5, 0.0F, 0.0F, 0.0F, 1.0F, 0.46F, 0.0F, 0.7F, 0.6F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.5F, 0.2F, 0.0F, 0.3F, 0.5F, 0.0F, 0.2F, 0.0F, 0.0F, 0.4F);
      this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[11].addShapeBox(-1.0F, 8.7F, -3.4F, 1, 3, 1, 0.0F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.5F);
      this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[12].addShapeBox(0.0F, 8.7F, -3.4F, 1, 3, 1, 0.0F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.5F);
      this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[13].addShapeBox(0.8F, 8.7F, -3.4F, 1, 3, 1, 0.0F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.5F);
      this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[14].addShapeBox(-1.8F, 8.7F, -3.4F, 1, 3, 1, 0.0F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.5F);
      this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[15].addShapeBox(3.6F, 8.7F, -3.1F, 1, 3, 1, 0.0F, 0.0F, -0.4F, -0.3F, -0.6F, -0.4F, -0.3F, -0.6F, -0.4F, -0.3F, 0.0F, -0.4F, -0.3F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.5F);
      this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[16].addShapeBox(2.7F, 8.7F, -3.2F, 1, 3, 1, 0.0F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.5F);
      this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[17].addShapeBox(2.0F, 8.7F, -3.2F, 1, 3, 1, 0.0F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.5F);
      this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[18].addShapeBox(-4.6F, 8.7F, -3.1F, 1, 3, 1, 0.0F, -0.6F, -0.4F, -0.3F, 0.0F, -0.4F, -0.3F, 0.0F, -0.4F, -0.3F, -0.6F, -0.4F, -0.3F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.5F);
      this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[19].addShapeBox(-3.0F, 8.7F, -3.2F, 1, 3, 1, 0.0F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.5F);
      this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[20].addShapeBox(-3.7F, 8.7F, -3.2F, 1, 3, 1, 0.0F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.5F);
      this.bodyModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[21].addShapeBox(3.6F, 8.7F, 2.1F, 1, 3, 1, 0.0F, 0.0F, -0.4F, -0.3F, -0.6F, -0.4F, -0.3F, -0.6F, -0.4F, -0.3F, 0.0F, -0.4F, -0.3F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.1F);
      this.bodyModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[22].addShapeBox(2.7F, 8.7F, 2.0F, 1, 3, 1, 0.0F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.1F);
      this.bodyModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[23].addShapeBox(2.0F, 8.7F, 2.0F, 1, 3, 1, 0.0F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.1F);
      this.bodyModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[24].addShapeBox(0.8F, 8.7F, 2.1F, 1, 3, 1, 0.0F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.1F);
      this.bodyModel[24].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[25].addShapeBox(0.0F, 8.7F, 2.1F, 1, 3, 1, 0.0F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.1F);
      this.bodyModel[25].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[26].addShapeBox(-1.0F, 8.7F, 2.1F, 1, 3, 1, 0.0F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.1F);
      this.bodyModel[26].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[27].addShapeBox(-1.8F, 8.7F, 2.1F, 1, 3, 1, 0.0F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.1F);
      this.bodyModel[27].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[28].addShapeBox(-3.0F, 8.7F, 2.1F, 1, 3, 1, 0.0F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.1F);
      this.bodyModel[28].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[29].addShapeBox(-3.7F, 8.7F, 2.1F, 1, 3, 1, 0.0F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.3F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.1F);
      this.bodyModel[29].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[30].addShapeBox(-4.6F, 8.7F, 2.1F, 1, 3, 1, 0.0F, -0.6F, -0.4F, -0.3F, 0.0F, -0.4F, -0.3F, 0.0F, -0.4F, -0.3F, -0.6F, -0.4F, -0.3F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.5F, -0.3F, -0.4F, -0.1F, -0.3F, -0.4F, -0.1F);
      this.bodyModel[30].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initleftArmModel_1() {
      this.leftArmModel[0] = new ModelRendererTurbo(this, 73, 1, this.textureX, this.textureY);
      this.leftArmModel[1] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.leftArmModel[2] = new ModelRendererTurbo(this, 89, 25, this.textureX, this.textureY);
      this.leftArmModel[3] = new ModelRendererTurbo(this, 137, 25, this.textureX, this.textureY);
      this.leftArmModel[0].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 5, 4, 0.0F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F);
      this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[1].addShapeBox(-1.0F, 4.0F, -2.0F, 4, 5, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F);
      this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[2].addShapeBox(-1.0F, 3.5F, -2.0F, 4, 1, 4, 0.0F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F);
      this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[3].addShapeBox(-1.0F, 8.6F, -2.0F, 4, 2, 4, 0.0F, 0.25F, 0.2F, 0.25F, 0.25F, 0.2F, 0.25F, 0.25F, 0.2F, 0.25F, 0.25F, 0.2F, 0.25F, 0.25F, -0.5F, 0.25F, 0.25F, -0.5F, 0.25F, 0.25F, -0.5F, 0.25F, 0.25F, -0.5F, 0.25F);
      this.leftArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initrightArmModel_1() {
      this.rightArmModel[0] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.rightArmModel[1] = new ModelRendererTurbo(this, 217, 17, this.textureX, this.textureY);
      this.rightArmModel[2] = new ModelRendererTurbo(this, 33, 25, this.textureX, this.textureY);
      this.rightArmModel[3] = new ModelRendererTurbo(this, 113, 25, this.textureX, this.textureY);
      this.rightArmModel[0].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 5, 4, 0.0F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F);
      this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[1].addShapeBox(-3.0F, 4.0F, -2.0F, 4, 5, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F);
      this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[2].addShapeBox(-3.0F, 3.5F, -2.0F, 4, 1, 4, 0.0F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F);
      this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[3].addShapeBox(-3.0F, 8.6F, -2.0F, 4, 2, 4, 0.0F, 0.25F, 0.2F, 0.25F, 0.25F, 0.2F, 0.25F, 0.25F, 0.2F, 0.25F, 0.25F, 0.2F, 0.25F, 0.25F, -0.5F, 0.25F, 0.25F, -0.5F, 0.25F, 0.25F, -0.5F, 0.25F, 0.25F, -0.5F, 0.25F);
      this.rightArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
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
      this.leftLegModel[3].addShapeBox(-2.0F, 7.0F, -2.0F, 4, 4, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
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
      this.rightLegModel[3].addShapeBox(-2.0F, 7.0F, -2.0F, 4, 4, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.rightLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightLegModel[4].addShapeBox(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F, 0.1F, -0.5F, 0.4F, 0.1F, -0.5F, 0.4F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, 0.0F, 0.4F, 0.1F, 0.0F, 0.4F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.rightLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initskirtFrontModel_1() {
      this.skirtFrontModel[0] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
      this.skirtFrontModel[1] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.skirtFrontModel[2] = new ModelRendererTurbo(this, 65, 1, this.textureX, this.textureY);
      this.skirtFrontModel[3] = new ModelRendererTurbo(this, 89, 1, this.textureX, this.textureY);
      this.skirtFrontModel[4] = new ModelRendererTurbo(this, 121, 1, this.textureX, this.textureY);
      this.skirtFrontModel[5] = new ModelRendererTurbo(this, 145, 1, this.textureX, this.textureY);
      this.skirtFrontModel[6] = new ModelRendererTurbo(this, 169, 1, this.textureX, this.textureY);
      this.skirtFrontModel[7] = new ModelRendererTurbo(this, 193, 1, this.textureX, this.textureY);
      this.skirtFrontModel[8] = new ModelRendererTurbo(this, 217, 1, this.textureX, this.textureY);
      this.skirtFrontModel[9] = new ModelRendererTurbo(this, 241, 1, this.textureX, this.textureY);
      this.skirtFrontModel[10] = new ModelRendererTurbo(this, 17, 9, this.textureX, this.textureY);
      this.skirtFrontModel[11] = new ModelRendererTurbo(this, 161, 9, this.textureX, this.textureY);
      this.skirtFrontModel[0].addShapeBox(-2.0F, -1.0F, -3.6F, 4, 2, 1, 0.0F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F);
      this.skirtFrontModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtFrontModel[1].addShapeBox(-2.0F, 0.0F, -4.1F, 4, 2, 1, 0.0F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F);
      this.skirtFrontModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtFrontModel[2].addShapeBox(-2.0F, 1.0F, -4.5F, 4, 2, 1, 0.0F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F);
      this.skirtFrontModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtFrontModel[3].addShapeBox(-2.0F, 2.0F, -5.0F, 4, 2, 1, 0.0F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F);
      this.skirtFrontModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtFrontModel[4].addShapeBox(2.0F, -1.0F, -3.5F, 3, 2, 1, 0.0F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, 0.2F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.4F, 0.2F, 0.0F, 0.1F, -0.2F, 0.0F, -0.5F);
      this.skirtFrontModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtFrontModel[5].addShapeBox(2.2F, 0.0F, -4.0F, 3, 2, 1, 0.0F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.8F, 0.2F, 0.0F, 0.5F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.7F, 0.2F, 0.0F, 0.4F, -0.2F, 0.0F, -0.5F);
      this.skirtFrontModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtFrontModel[6].addShapeBox(2.4F, 1.0F, -4.5F, 3, 2, 1, 0.0F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -1.0F, 0.2F, 0.0F, 0.7F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.9F, 0.2F, 0.0F, 0.6F, -0.2F, 0.0F, -0.5F);
      this.skirtFrontModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtFrontModel[7].addShapeBox(2.6F, 2.0F, -5.0F, 3, 2, 1, 0.0F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -1.3F, 0.2F, 0.0F, 1.0F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -1.2F, 0.2F, 0.0F, 0.9F, -0.2F, 0.0F, -0.5F);
      this.skirtFrontModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtFrontModel[8].addShapeBox(-5.0F, -1.0F, -3.5F, 3, 2, 1, 0.0F, 0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, -0.4F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.5F, 0.2F, 0.0F, 0.1F);
      this.skirtFrontModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtFrontModel[9].addShapeBox(-5.2F, 0.0F, -4.0F, 3, 2, 1, 0.0F, 0.2F, 0.0F, -0.8F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, -0.7F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.5F, 0.2F, 0.0F, 0.4F);
      this.skirtFrontModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtFrontModel[10].addShapeBox(-5.4F, 1.0F, -4.5F, 3, 2, 1, 0.0F, 0.2F, 0.0F, -1.0F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, 0.7F, 0.2F, 0.0F, -0.9F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.5F, 0.2F, 0.0F, 0.6F);
      this.skirtFrontModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtFrontModel[11].addShapeBox(-5.6F, 2.0F, -5.0F, 3, 2, 1, 0.0F, 0.2F, 0.0F, -1.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, 1.0F, 0.2F, 0.0F, -1.2F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.5F, 0.2F, 0.0F, 0.9F);
      this.skirtFrontModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initskirtRearModel_1() {
      this.skirtRearModel[0] = new ModelRendererTurbo(this, 65, 17, this.textureX, this.textureY);
      this.skirtRearModel[1] = new ModelRendererTurbo(this, 89, 17, this.textureX, this.textureY);
      this.skirtRearModel[2] = new ModelRendererTurbo(this, 137, 17, this.textureX, this.textureY);
      this.skirtRearModel[3] = new ModelRendererTurbo(this, 161, 17, this.textureX, this.textureY);
      this.skirtRearModel[4] = new ModelRendererTurbo(this, 185, 17, this.textureX, this.textureY);
      this.skirtRearModel[5] = new ModelRendererTurbo(this, 209, 17, this.textureX, this.textureY);
      this.skirtRearModel[6] = new ModelRendererTurbo(this, 105, 25, this.textureX, this.textureY);
      this.skirtRearModel[7] = new ModelRendererTurbo(this, 129, 25, this.textureX, this.textureY);
      this.skirtRearModel[8] = new ModelRendererTurbo(this, 233, 17, this.textureX, this.textureY);
      this.skirtRearModel[9] = new ModelRendererTurbo(this, 153, 25, this.textureX, this.textureY);
      this.skirtRearModel[10] = new ModelRendererTurbo(this, 177, 33, this.textureX, this.textureY);
      this.skirtRearModel[11] = new ModelRendererTurbo(this, 193, 33, this.textureX, this.textureY);
      this.skirtRearModel[0].addShapeBox(2.6F, 2.0F, 3.7F, 3, 2, 1, 0.0F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, 1.0F, 0.2F, 0.0F, -1.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.5F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, -1.2F, -0.2F, 0.0F, -0.3F);
      this.skirtRearModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtRearModel[1].addShapeBox(2.0F, -1.0F, 2.2F, 3, 2, 1, 0.0F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.5F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, -0.4F, -0.2F, 0.0F, -0.3F);
      this.skirtRearModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtRearModel[2].addShapeBox(2.4F, 1.0F, 3.2F, 3, 2, 1, 0.0F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, 0.7F, 0.2F, 0.0F, -1.0F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.5F, 0.2F, 0.0F, 0.6F, 0.2F, 0.0F, -0.9F, -0.2F, 0.0F, -0.3F);
      this.skirtRearModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtRearModel[3].addShapeBox(2.2F, 0.0F, 2.7F, 3, 2, 1, 0.0F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, -0.8F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.5F, 0.2F, 0.0F, 0.4F, 0.2F, 0.0F, -0.7F, -0.2F, 0.0F, -0.3F);
      this.skirtRearModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtRearModel[4].addShapeBox(-2.0F, -1.0F, 2.5F, 4, 2, 1, 0.0F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F, -0.1F);
      this.skirtRearModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtRearModel[5].addShapeBox(-2.0F, 0.0F, 3.0F, 4, 2, 1, 0.0F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F, -0.1F);
      this.skirtRearModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtRearModel[6].addShapeBox(-2.0F, 1.0F, 3.6F, 4, 2, 1, 0.0F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F, -0.1F);
      this.skirtRearModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtRearModel[7].addShapeBox(-2.0F, 2.0F, 4.1F, 4, 2, 1, 0.0F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F);
      this.skirtRearModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtRearModel[8].addShapeBox(-5.0F, -1.0F, 2.2F, 3, 2, 1, 0.0F, 0.2F, 0.0F, 0.2F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, 0.1F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.4F);
      this.skirtRearModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtRearModel[9].addShapeBox(-5.2F, 0.0F, 2.7F, 3, 2, 1, 0.0F, 0.2F, 0.0F, 0.5F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.8F, 0.2F, 0.0F, 0.4F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.7F);
      this.skirtRearModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtRearModel[10].addShapeBox(-5.4F, 1.0F, 3.2F, 3, 2, 1, 0.0F, 0.2F, 0.0F, 0.7F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -1.0F, 0.2F, 0.0F, 0.6F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.9F);
      this.skirtRearModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.skirtRearModel[11].addShapeBox(-5.6F, 2.0F, 3.7F, 3, 2, 1, 0.0F, 0.2F, 0.0F, 1.0F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -1.3F, 0.2F, 0.0F, 0.9F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -1.2F);
      this.skirtRearModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
