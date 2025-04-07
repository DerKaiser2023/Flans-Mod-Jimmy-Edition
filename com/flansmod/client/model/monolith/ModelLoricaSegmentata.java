package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelLoricaSegmentata extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 64;

   public ModelLoricaSegmentata() {
      this.bodyModel = new ModelRendererTurbo[40];
      this.leftArmModel = new ModelRendererTurbo[5];
      this.rightArmModel = new ModelRendererTurbo[5];
      this.leftLegModel = new ModelRendererTurbo[1];
      this.rightLegModel = new ModelRendererTurbo[1];
      this.initbodyModel_1();
      this.initleftArmModel_1();
      this.initrightArmModel_1();
      this.initleftLegModel_1();
      this.initrightLegModel_1();
   }

   private void initbodyModel_1() {
      this.bodyModel[0] = new ModelRendererTurbo(this, 65, 1, this.textureX, this.textureY);
      this.bodyModel[1] = new ModelRendererTurbo(this, 1, 9, this.textureX, this.textureY);
      this.bodyModel[2] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyModel[3] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.bodyModel[4] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.bodyModel[5] = new ModelRendererTurbo(this, 105, 1, this.textureX, this.textureY);
      this.bodyModel[6] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
      this.bodyModel[7] = new ModelRendererTurbo(this, 113, 1, this.textureX, this.textureY);
      this.bodyModel[8] = new ModelRendererTurbo(this, 89, 1, this.textureX, this.textureY);
      this.bodyModel[9] = new ModelRendererTurbo(this, 121, 1, this.textureX, this.textureY);
      this.bodyModel[10] = new ModelRendererTurbo(this, 25, 25, this.textureX, this.textureY);
      this.bodyModel[11] = new ModelRendererTurbo(this, 65, 9, this.textureX, this.textureY);
      this.bodyModel[12] = new ModelRendererTurbo(this, 105, 9, this.textureX, this.textureY);
      this.bodyModel[13] = new ModelRendererTurbo(this, 73, 17, this.textureX, this.textureY);
      this.bodyModel[14] = new ModelRendererTurbo(this, 97, 17, this.textureX, this.textureY);
      this.bodyModel[15] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.bodyModel[16] = new ModelRendererTurbo(this, 89, 9, this.textureX, this.textureY);
      this.bodyModel[17] = new ModelRendererTurbo(this, 65, 25, this.textureX, this.textureY);
      this.bodyModel[18] = new ModelRendererTurbo(this, 1, 41, this.textureX, this.textureY);
      this.bodyModel[19] = new ModelRendererTurbo(this, 17, 41, this.textureX, this.textureY);
      this.bodyModel[20] = new ModelRendererTurbo(this, 0, 1, this.textureX, this.textureY);
      this.bodyModel[21] = new ModelRendererTurbo(this, 0, 1, this.textureX, this.textureY);
      this.bodyModel[22] = new ModelRendererTurbo(this, 0, 1, this.textureX, this.textureY);
      this.bodyModel[23] = new ModelRendererTurbo(this, 0, 1, this.textureX, this.textureY);
      this.bodyModel[24] = new ModelRendererTurbo(this, 0, 1, this.textureX, this.textureY);
      this.bodyModel[25] = new ModelRendererTurbo(this, 10, 1, this.textureX, this.textureY);
      this.bodyModel[26] = new ModelRendererTurbo(this, 10, 1, this.textureX, this.textureY);
      this.bodyModel[27] = new ModelRendererTurbo(this, 10, 1, this.textureX, this.textureY);
      this.bodyModel[28] = new ModelRendererTurbo(this, 10, 1, this.textureX, this.textureY);
      this.bodyModel[29] = new ModelRendererTurbo(this, 10, 1, this.textureX, this.textureY);
      this.bodyModel[30] = new ModelRendererTurbo(this, 10, 1, this.textureX, this.textureY);
      this.bodyModel[31] = new ModelRendererTurbo(this, 10, 1, this.textureX, this.textureY);
      this.bodyModel[32] = new ModelRendererTurbo(this, 10, 1, this.textureX, this.textureY);
      this.bodyModel[33] = new ModelRendererTurbo(this, 10, 1, this.textureX, this.textureY);
      this.bodyModel[34] = new ModelRendererTurbo(this, 10, 1, this.textureX, this.textureY);
      this.bodyModel[35] = new ModelRendererTurbo(this, 10, 1, this.textureX, this.textureY);
      this.bodyModel[36] = new ModelRendererTurbo(this, 10, 1, this.textureX, this.textureY);
      this.bodyModel[37] = new ModelRendererTurbo(this, 10, 1, this.textureX, this.textureY);
      this.bodyModel[38] = new ModelRendererTurbo(this, 10, 1, this.textureX, this.textureY);
      this.bodyModel[39] = new ModelRendererTurbo(this, 10, 1, this.textureX, this.textureY);
      this.bodyModel[0].addShapeBox(-4.0F, 8.5F, -2.0F, 8, 1, 4, 0.0F, 0.5F, 0.0F, 0.55F, 0.5F, 0.0F, 0.55F, 0.5F, 0.0F, 0.55F, 0.5F, 0.0F, 0.55F, 0.5F, 0.0F, 0.55F, 0.5F, 0.0F, 0.55F, 0.5F, 0.0F, 0.55F, 0.5F, 0.0F, 0.55F);
      this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[1].addShapeBox(-4.0F, 9.8F, -2.0F, 8, 6, 4, 0.0F, 0.2F, 0.3F, 0.2F, 0.2F, 0.3F, 0.2F, 0.2F, 0.3F, 0.2F, 0.2F, 0.3F, 0.2F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F);
      this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[2].addShapeBox(0.0F, 8.5F, -2.5F, 1, 1, 1, 0.0F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F);
      this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[3].addShapeBox(0.0F, 9.5F, -2.5F, 1, 5, 1, 0.0F, -0.15F, 0.0F, 0.3F, -0.15F, 0.0F, 0.3F, -0.15F, 0.0F, -0.7F, -0.15F, 0.0F, -0.7F, -0.15F, 0.0F, 0.6F, -0.15F, 0.0F, 0.6F, -0.15F, 0.0F, -0.9F, -0.15F, 0.0F, -0.9F);
      this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[4].addShapeBox(1.0F, 8.5F, -2.5F, 1, 1, 1, 0.0F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F);
      this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[5].addShapeBox(1.0F, 9.5F, -2.5F, 1, 5, 1, 0.0F, -0.15F, 0.0F, 0.3F, -0.15F, 0.0F, 0.3F, -0.15F, 0.0F, -0.7F, -0.15F, 0.0F, -0.7F, -0.15F, 0.0F, 0.6F, -0.15F, 0.0F, 0.6F, -0.15F, 0.0F, -0.9F, -0.15F, 0.0F, -0.9F);
      this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[6].addShapeBox(-1.0F, 8.5F, -2.5F, 1, 1, 1, 0.0F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F);
      this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[7].addShapeBox(-1.0F, 9.5F, -2.5F, 1, 5, 1, 0.0F, -0.15F, 0.0F, 0.3F, -0.15F, 0.0F, 0.3F, -0.15F, 0.0F, -0.7F, -0.15F, 0.0F, -0.7F, -0.15F, 0.0F, 0.6F, -0.15F, 0.0F, 0.6F, -0.15F, 0.0F, -0.9F, -0.15F, 0.0F, -0.9F);
      this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[8].addShapeBox(-2.0F, 8.5F, -2.5F, 1, 1, 1, 0.0F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F, -0.1F, 0.1F, 0.4F);
      this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[9].addShapeBox(-2.0F, 9.5F, -2.5F, 1, 5, 1, 0.0F, -0.15F, 0.0F, 0.3F, -0.15F, 0.0F, 0.3F, -0.15F, 0.0F, -0.7F, -0.15F, 0.0F, -0.7F, -0.15F, 0.0F, 0.6F, -0.15F, 0.0F, 0.6F, -0.15F, 0.0F, -0.9F, -0.15F, 0.0F, -0.9F);
      this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[10].addShapeBox(-4.0F, 1.0F, -2.0F, 8, 7, 4, 0.0F, 0.1F, 0.2F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, 1.1F, 0.1F, 0.1F, 1.1F, 0.1F, 0.1F, 1.1F, 0.1F, 0.1F, 1.1F, 0.1F);
      this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[11].addShapeBox(-4.0F, 7.5F, -2.0F, 4, 1, 4, 0.0F, 0.4F, 0.1F, 0.4F, 0.5F, 0.1F, 0.45F, 0.5F, 0.1F, 0.45F, 0.4F, 0.1F, 0.4F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F);
      this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[12].addShapeBox(-4.0F, 6.5F, -2.0F, 4, 1, 4, 0.0F, 0.4F, 0.1F, 0.4F, 0.5F, 0.1F, 0.45F, 0.5F, 0.1F, 0.45F, 0.4F, 0.1F, 0.4F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F);
      this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[13].addShapeBox(-4.0F, 5.5F, -2.0F, 4, 1, 4, 0.0F, 0.4F, 0.1F, 0.4F, 0.5F, 0.1F, 0.45F, 0.5F, 0.1F, 0.45F, 0.4F, 0.1F, 0.4F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F);
      this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[14].addShapeBox(-4.0F, 4.5F, -2.0F, 4, 1, 4, 0.0F, 0.4F, 0.1F, 0.4F, 0.5F, 0.1F, 0.45F, 0.5F, 0.1F, 0.45F, 0.4F, 0.1F, 0.4F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F);
      this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[15].addShapeBox(-4.0F, 3.5F, -2.0F, 4, 1, 4, 0.0F, 0.4F, 0.1F, 0.4F, 0.5F, 0.1F, 0.45F, 0.5F, 0.1F, 0.45F, 0.4F, 0.1F, 0.4F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F);
      this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[16].addShapeBox(-2.5F, 1.0F, -2.0F, 2, 2, 4, 0.0F, 1.5F, 1.1F, 0.5F, 0.5F, 0.1F, 0.65F, 0.5F, 1.1F, 0.65F, 1.5F, 1.1F, 0.5F, 0.0F, 1.0F, 0.5F, 0.5F, 0.5F, 0.7F, 0.5F, 0.5F, 0.6F, 0.0F, 1.5F, 0.5F);
      this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[17].addShapeBox(-4.0F, 0.0F, -2.0F, 3, 4, 4, 0.0F, 1.0F, 0.5F, 0.8F, -1.2F, 0.7F, 0.8F, -1.2F, 0.7F, 0.8F, 1.0F, 0.5F, 0.8F, 0.3F, -0.5F, 0.8F, -0.8F, -0.5F, 0.8F, -0.8F, -0.5F, 0.8F, 0.3F, -0.5F, 0.8F);
      this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[18].addShapeBox(0.5F, 1.0F, -2.0F, 2, 2, 4, 0.0F, 0.5F, 0.1F, 0.65F, 1.5F, 1.1F, 0.5F, 1.5F, 1.1F, 0.5F, 0.5F, 1.1F, 0.65F, 0.7F, 0.5F, 0.8F, 0.0F, 1.0F, 0.7F, 0.0F, 1.5F, 0.5F, 0.5F, 0.5F, 0.6F);
      this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[19].addShapeBox(1.0F, 0.0F, -2.0F, 3, 4, 4, 0.0F, -1.2F, 0.7F, 0.8F, 1.0F, 0.5F, 0.8F, 1.0F, 0.5F, 0.8F, -1.2F, 0.7F, 0.8F, -0.8F, -0.5F, 0.8F, 0.3F, -0.5F, 0.8F, 0.3F, -0.5F, 0.8F, -0.8F, -0.5F, 0.8F);
      this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[20].addShapeBox(0.0F, 3.5F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 0.1F, 0.5F, 0.4F, 0.1F, 0.5F, 0.4F, 0.1F, 0.5F, 0.0F, 0.1F, 0.5F, 0.0F, 0.0F, 0.6F, 0.5F, 0.0F, 0.6F, 0.5F, 0.0F, 0.6F, 0.0F, 0.0F, 0.6F);
      this.bodyModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[21].addShapeBox(0.0F, 4.5F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 0.1F, 0.5F, 0.4F, 0.1F, 0.5F, 0.4F, 0.1F, 0.5F, 0.0F, 0.1F, 0.5F, 0.0F, 0.0F, 0.6F, 0.5F, 0.0F, 0.6F, 0.5F, 0.0F, 0.6F, 0.0F, 0.0F, 0.6F);
      this.bodyModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[22].addShapeBox(0.0F, 5.5F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 0.1F, 0.5F, 0.4F, 0.1F, 0.5F, 0.4F, 0.1F, 0.5F, 0.0F, 0.1F, 0.5F, 0.0F, 0.0F, 0.6F, 0.5F, 0.0F, 0.6F, 0.5F, 0.0F, 0.6F, 0.0F, 0.0F, 0.6F);
      this.bodyModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[23].addShapeBox(0.0F, 6.5F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 0.1F, 0.5F, 0.4F, 0.1F, 0.5F, 0.4F, 0.1F, 0.5F, 0.0F, 0.1F, 0.5F, 0.0F, 0.0F, 0.6F, 0.5F, 0.0F, 0.6F, 0.5F, 0.0F, 0.6F, 0.0F, 0.0F, 0.6F);
      this.bodyModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[24].addShapeBox(0.0F, 7.5F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 0.1F, 0.5F, 0.4F, 0.1F, 0.5F, 0.4F, 0.1F, 0.5F, 0.0F, 0.1F, 0.5F, 0.0F, 0.0F, 0.6F, 0.5F, 0.0F, 0.6F, 0.5F, 0.0F, 0.6F, 0.0F, 0.0F, 0.6F);
      this.bodyModel[24].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[25].addShapeBox(-1.3F, 7.65F, -2.0F, 1, 1, 1, 0.0F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F);
      this.bodyModel[25].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[26].addShapeBox(-1.3F, 6.65F, -2.0F, 1, 1, 1, 0.0F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F);
      this.bodyModel[26].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[27].addShapeBox(-1.3F, 5.65F, -2.0F, 1, 1, 1, 0.0F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F);
      this.bodyModel[27].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[28].addShapeBox(-1.3F, 4.65F, -2.0F, 1, 1, 1, 0.0F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F);
      this.bodyModel[28].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[29].addShapeBox(-1.3F, 3.65F, -2.0F, 1, 1, 1, 0.0F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F);
      this.bodyModel[29].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[30].addShapeBox(0.2F, 3.65F, -2.0F, 1, 1, 1, 0.0F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F);
      this.bodyModel[30].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[31].addShapeBox(0.2F, 4.65F, -2.0F, 1, 1, 1, 0.0F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F);
      this.bodyModel[31].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[32].addShapeBox(0.2F, 5.65F, -2.0F, 1, 1, 1, 0.0F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F);
      this.bodyModel[32].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[33].addShapeBox(0.2F, 6.65F, -2.0F, 1, 1, 1, 0.0F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F);
      this.bodyModel[33].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[34].addShapeBox(0.2F, 7.65F, -2.0F, 1, 1, 1, 0.0F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F, -0.2F, -0.3F, 0.65F);
      this.bodyModel[34].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[35].addShapeBox(-0.6F, 3.65F, -2.0F, 1, 1, 1, 0.0F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F);
      this.bodyModel[35].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[36].addShapeBox(-0.6F, 4.65F, -2.0F, 1, 1, 1, 0.0F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F);
      this.bodyModel[36].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[37].addShapeBox(-0.6F, 5.65F, -2.0F, 1, 1, 1, 0.0F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F);
      this.bodyModel[37].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[38].addShapeBox(-0.6F, 6.65F, -2.0F, 1, 1, 1, 0.0F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F);
      this.bodyModel[38].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[39].addShapeBox(-0.6F, 7.65F, -2.0F, 1, 1, 1, 0.0F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F, 0.0F, -0.42F, 0.67F);
      this.bodyModel[39].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initleftArmModel_1() {
      this.leftArmModel[0] = new ModelRendererTurbo(this, 49, 17, this.textureX, this.textureY);
      this.leftArmModel[1] = new ModelRendererTurbo(this, 49, 33, this.textureX, this.textureY);
      this.leftArmModel[2] = new ModelRendererTurbo(this, 81, 33, this.textureX, this.textureY);
      this.leftArmModel[3] = new ModelRendererTurbo(this, 97, 33, this.textureX, this.textureY);
      this.leftArmModel[4] = new ModelRendererTurbo(this, 113, 33, this.textureX, this.textureY);
      this.leftArmModel[0].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
      this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[1].addShapeBox(-0.8F, -2.0F, -2.0F, 2, 3, 4, 0.0F, 0.0F, 0.4F, 0.6F, 0.5F, 0.4F, 0.6F, 0.5F, 0.4F, 0.6F, 0.0F, 0.4F, 0.6F, 0.0F, -0.2F, 0.6F, -0.3F, -0.2F, 0.6F, -0.3F, -0.2F, 0.6F, 0.0F, -0.2F, 0.6F);
      this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[2].addShapeBox(0.5F, -2.0F, -2.0F, 2, 3, 4, 0.0F, 0.0F, 0.3F, 0.5F, 0.9F, 0.3F, 0.5F, 0.9F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, -0.5F, 0.5F, -0.5F, 0.0F, 0.5F, -0.5F, 0.0F, 0.5F, 0.0F, -0.5F, 0.5F);
      this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[3].addShapeBox(1.0F, -2.0F, -2.0F, 2, 2, 4, 0.0F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, -1.0F, 0.8F, 0.4F, 0.5F, 0.0F, 0.4F, 0.5F, 0.0F, 0.4F, -1.0F, 0.8F, 0.4F);
      this.leftArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[4].addShapeBox(1.0F, 0.0F, -2.0F, 2, 1, 4, 0.0F, -0.7F, 0.2F, 0.2F, 0.3F, 0.2F, 0.2F, 0.3F, 0.2F, 0.2F, -0.7F, 0.2F, 0.2F, -1.0F, 0.8F, 0.4F, 0.5F, 0.0F, 0.4F, 0.5F, 0.0F, 0.4F, -1.0F, 0.8F, 0.4F);
      this.leftArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initrightArmModel_1() {
      this.rightArmModel[0] = new ModelRendererTurbo(this, 33, 9, this.textureX, this.textureY);
      this.rightArmModel[1] = new ModelRendererTurbo(this, 81, 25, this.textureX, this.textureY);
      this.rightArmModel[2] = new ModelRendererTurbo(this, 97, 25, this.textureX, this.textureY);
      this.rightArmModel[3] = new ModelRendererTurbo(this, 113, 25, this.textureX, this.textureY);
      this.rightArmModel[4] = new ModelRendererTurbo(this, 1, 33, this.textureX, this.textureY);
      this.rightArmModel[0].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
      this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[1].addShapeBox(-1.3F, -2.0F, -2.0F, 2, 3, 4, 0.0F, 0.5F, 0.4F, 0.6F, 0.0F, 0.4F, 0.6F, 0.0F, 0.4F, 0.6F, 0.5F, 0.4F, 0.6F, -0.3F, -0.2F, 0.6F, 0.0F, -0.2F, 0.6F, 0.0F, -0.2F, 0.6F, -0.3F, -0.2F, 0.6F);
      this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[2].addShapeBox(-2.5F, -2.0F, -2.0F, 2, 3, 4, 0.0F, 0.9F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, 0.9F, 0.3F, 0.5F, -0.5F, 0.0F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F, 0.5F, -0.5F, 0.0F, 0.5F);
      this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[3].addShapeBox(-3.0F, -2.0F, -2.0F, 2, 2, 4, 0.0F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.5F, 0.0F, 0.4F, -1.0F, 0.8F, 0.4F, -1.0F, 0.8F, 0.4F, 0.5F, 0.0F, 0.4F);
      this.rightArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[4].addShapeBox(-3.0F, 0.0F, -2.0F, 2, 1, 4, 0.0F, 0.3F, 0.2F, 0.2F, -0.7F, 0.2F, 0.2F, -0.7F, 0.2F, 0.2F, 0.3F, 0.2F, 0.2F, 0.5F, 0.0F, 0.4F, -1.0F, 0.8F, 0.4F, -1.0F, 0.8F, 0.4F, 0.5F, 0.0F, 0.4F);
      this.rightArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initleftLegModel_1() {
      this.leftLegModel[0] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
      this.leftLegModel[0].addShapeBox(-2.0F, 10.1F, -2.0F, 4, 2, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initrightLegModel_1() {
      this.rightLegModel[0] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.rightLegModel[0].addShapeBox(-2.0F, 10.1F, -2.0F, 4, 2, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
