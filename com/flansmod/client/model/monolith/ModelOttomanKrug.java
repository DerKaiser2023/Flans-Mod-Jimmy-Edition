package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelOttomanKrug extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 128;

   public ModelOttomanKrug() {
      this.bodyModel = new ModelRendererTurbo[23];
      this.leftArmModel = new ModelRendererTurbo[3];
      this.rightArmModel = new ModelRendererTurbo[3];
      this.leftLegModel = new ModelRendererTurbo[7];
      this.rightLegModel = new ModelRendererTurbo[7];
      this.initbodyModel_1();
      this.initleftArmModel_1();
      this.initrightArmModel_1();
      this.initleftLegModel_1();
      this.initrightLegModel_1();
   }

   private void initbodyModel_1() {
      this.bodyModel[0] = new ModelRendererTurbo(this, 25, 17, this.textureX, this.textureY);
      this.bodyModel[1] = new ModelRendererTurbo(this, 57, 17, this.textureX, this.textureY);
      this.bodyModel[2] = new ModelRendererTurbo(this, 81, 17, this.textureX, this.textureY);
      this.bodyModel[3] = new ModelRendererTurbo(this, 81, 25, this.textureX, this.textureY);
      this.bodyModel[4] = new ModelRendererTurbo(this, 1, 33, this.textureX, this.textureY);
      this.bodyModel[5] = new ModelRendererTurbo(this, 25, 33, this.textureX, this.textureY);
      this.bodyModel[6] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
      this.bodyModel[7] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.bodyModel[8] = new ModelRendererTurbo(this, 65, 1, this.textureX, this.textureY);
      this.bodyModel[9] = new ModelRendererTurbo(this, 89, 1, this.textureX, this.textureY);
      this.bodyModel[10] = new ModelRendererTurbo(this, 73, 33, this.textureX, this.textureY);
      this.bodyModel[11] = new ModelRendererTurbo(this, 89, 33, this.textureX, this.textureY);
      this.bodyModel[12] = new ModelRendererTurbo(this, 1, 41, this.textureX, this.textureY);
      this.bodyModel[13] = new ModelRendererTurbo(this, 25, 41, this.textureX, this.textureY);
      this.bodyModel[14] = new ModelRendererTurbo(this, 49, 33, this.textureX, this.textureY);
      this.bodyModel[15] = new ModelRendererTurbo(this, 113, 1, this.textureX, this.textureY);
      this.bodyModel[16] = new ModelRendererTurbo(this, 121, 1, this.textureX, this.textureY);
      this.bodyModel[17] = new ModelRendererTurbo(this, 17, 17, this.textureX, this.textureY);
      this.bodyModel[18] = new ModelRendererTurbo(this, 121, 9, this.textureX, this.textureY);
      this.bodyModel[19] = new ModelRendererTurbo(this, 49, 17, this.textureX, this.textureY);
      this.bodyModel[20] = new ModelRendererTurbo(this, 73, 17, this.textureX, this.textureY);
      this.bodyModel[21] = new ModelRendererTurbo(this, 97, 17, this.textureX, this.textureY);
      this.bodyModel[22] = new ModelRendererTurbo(this, 113, 33, this.textureX, this.textureY);
      this.bodyModel[0].addShapeBox(-4.0F, 1.9F, -2.0F, 8, 10, 4, 0.0F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F, 0.3F, 1.1F, 0.3F, 0.3F, 1.1F, 0.3F, 0.3F, 1.1F, 0.3F, 0.3F, 1.1F, 0.3F);
      this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[1].addShapeBox(-4.0F, -0.1F, -2.0F, 4, 2, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, -0.5F, 0.1F, 0.0F, -0.5F, 0.1F, 0.0F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F);
      this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[2].addShapeBox(0.0F, -0.1F, -2.0F, 4, 2, 4, 0.0F, 0.0F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.0F, -0.5F, 0.1F);
      this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[3].addShapeBox(-4.5F, 6.4F, -2.0F, 9, 3, 1, 0.0F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F);
      this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[4].addShapeBox(-4.5F, 3.4F, -2.0F, 9, 3, 1, 0.0F, -3.0F, 0.0F, 0.4F, -3.0F, 0.0F, 0.4F, -3.0F, 0.0F, 0.4F, -3.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F);
      this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[5].addShapeBox(-4.5F, 9.4F, -2.0F, 9, 3, 1, 0.0F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, -3.0F, 0.0F, 0.4F, -3.0F, 0.0F, 0.4F, -3.0F, 0.0F, 0.4F, -3.0F, 0.0F, 0.4F);
      this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[6].addShapeBox(-1.5F, 6.4F, -2.2F, 3, 3, 1, 0.0F, -0.2F, -0.2F, 0.4F, -0.2F, -0.2F, 0.4F, -0.2F, -0.2F, 0.4F, -0.2F, -0.2F, 0.4F, -0.2F, -0.2F, 0.4F, -0.2F, -0.2F, 0.4F, -0.2F, -0.2F, 0.4F, -0.2F, -0.2F, 0.4F);
      this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[7].addShapeBox(-1.5F, 0.9F, -2.0F, 3, 2, 1, 0.0F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F);
      this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[8].addShapeBox(-3.5F, 0.9F, -2.0F, 2, 2, 1, 0.0F, -0.3F, -0.8F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, -0.3F, -0.8F, 0.4F, -0.5F, 1.4F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, -0.5F, 1.4F, 0.4F);
      this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[9].addShapeBox(1.5F, 0.9F, -2.0F, 2, 2, 1, 0.0F, 0.0F, 0.0F, 0.4F, -0.3F, -0.8F, 0.4F, -0.3F, -0.8F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, -0.5F, 1.4F, 0.4F, -0.5F, 1.4F, 0.4F, 0.0F, 0.0F, 0.4F);
      this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[10].addShapeBox(-4.0F, -0.4F, -2.0F, 2, 1, 4, 0.0F, -0.3F, -0.2F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, -0.3F, -0.2F, 0.4F, -0.8F, 0.8F, 0.4F, 0.0F, 0.3F, 0.4F, 0.0F, 0.3F, 0.4F, -0.8F, 0.8F, 0.4F);
      this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[11].addShapeBox(-4.5F, 9.4F, 1.0F, 9, 3, 1, 0.0F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, -3.0F, 0.0F, 0.4F, -3.0F, 0.0F, 0.4F, -3.0F, 0.0F, 0.4F, -3.0F, 0.0F, 0.4F);
      this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[12].addShapeBox(-4.5F, 3.4F, 1.0F, 9, 3, 1, 0.0F, -3.0F, 0.0F, 0.4F, -3.0F, 0.0F, 0.4F, -3.0F, 0.0F, 0.4F, -3.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F);
      this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[13].addShapeBox(-4.5F, 6.4F, 1.0F, 9, 3, 1, 0.0F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F);
      this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[14].addShapeBox(-1.5F, 6.4F, 1.2F, 3, 3, 1, 0.0F, -0.2F, -0.2F, 0.4F, -0.2F, -0.2F, 0.4F, -0.2F, -0.2F, 0.4F, -0.2F, -0.2F, 0.4F, -0.2F, -0.2F, 0.4F, -0.2F, -0.2F, 0.4F, -0.2F, -0.2F, 0.4F, -0.2F, -0.2F, 0.4F);
      this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[15].addShapeBox(-3.5F, 0.9F, 1.0F, 2, 2, 1, 0.0F, -0.3F, -0.8F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, -0.3F, -0.8F, 0.4F, -0.5F, 1.4F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, -0.5F, 1.4F, 0.4F);
      this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[16].addShapeBox(1.5F, 0.9F, 1.0F, 2, 2, 1, 0.0F, 0.0F, 0.0F, 0.4F, -0.3F, -0.8F, 0.4F, -0.3F, -0.8F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, -0.5F, 1.4F, 0.4F, -0.5F, 1.4F, 0.4F, 0.0F, 0.0F, 0.4F);
      this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[17].addShapeBox(-1.5F, 0.9F, 1.0F, 3, 2, 1, 0.0F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F);
      this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[18].addShapeBox(-5.0F, 6.7F, -1.0F, 1, 1, 2, 0.0F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F);
      this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[19].addShapeBox(-5.0F, 8.3F, -1.0F, 1, 1, 2, 0.0F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F);
      this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[20].addShapeBox(4.0F, 8.3F, -1.0F, 1, 1, 2, 0.0F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F);
      this.bodyModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[21].addShapeBox(4.0F, 6.7F, -1.0F, 1, 1, 2, 0.0F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F, -0.2F, -0.2F, 0.3F);
      this.bodyModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[22].addShapeBox(2.0F, -0.4F, -2.0F, 2, 1, 4, 0.0F, 0.0F, 0.0F, 0.4F, -0.3F, -0.2F, 0.4F, -0.3F, -0.2F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.3F, 0.4F, -0.8F, 0.8F, 0.4F, -0.8F, 0.8F, 0.4F, 0.0F, 0.3F, 0.4F);
      this.bodyModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initleftArmModel_1() {
      this.leftArmModel[0] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.leftArmModel[1] = new ModelRendererTurbo(this, 57, 25, this.textureX, this.textureY);
      this.leftArmModel[2] = new ModelRendererTurbo(this, 73, 57, this.textureX, this.textureY);
      this.leftArmModel[0].addShapeBox(-1.0F, -2.1F, -2.0F, 4, 9, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 3.4F, 0.1F, 0.1F, 3.4F, 0.1F, 0.1F, 3.4F, 0.1F, 0.1F, 3.4F, 0.1F);
      this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[1].addShapeBox(-1.0F, 4.6F, -2.0F, 4, 4, 4, 0.0F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F);
      this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[2].addShapeBox(1.0F, -2.4F, -2.0F, 2, 4, 4, 0.0F, 0.8F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.8F, 0.0F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, 0.5F, 0.15F, 0.15F, 0.5F, 0.15F, 0.15F, -0.5F, 0.15F);
      this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initrightArmModel_1() {
      this.rightArmModel[0] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.rightArmModel[1] = new ModelRendererTurbo(this, 105, 17, this.textureX, this.textureY);
      this.rightArmModel[2] = new ModelRendererTurbo(this, 89, 57, this.textureX, this.textureY);
      this.rightArmModel[0].addShapeBox(-3.0F, -2.1F, -2.0F, 4, 9, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 3.4F, 0.1F, 0.1F, 3.4F, 0.1F, 0.1F, 3.4F, 0.1F, 0.1F, 3.4F, 0.1F);
      this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[1].addShapeBox(-3.0F, 4.6F, -2.0F, 4, 4, 4, 0.0F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F);
      this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[2].addShapeBox(-3.0F, -2.4F, -2.0F, 2, 4, 4, 0.0F, 0.15F, 0.0F, 0.15F, 0.8F, 0.0F, 0.15F, 0.8F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, 0.5F, 0.15F);
      this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initleftLegModel_1() {
      this.leftLegModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.leftLegModel[1] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.leftLegModel[2] = new ModelRendererTurbo(this, 73, 41, this.textureX, this.textureY);
      this.leftLegModel[3] = new ModelRendererTurbo(this, 97, 41, this.textureX, this.textureY);
      this.leftLegModel[4] = new ModelRendererTurbo(this, 1, 49, this.textureX, this.textureY);
      this.leftLegModel[5] = new ModelRendererTurbo(this, 25, 49, this.textureX, this.textureY);
      this.leftLegModel[6] = new ModelRendererTurbo(this, 49, 57, this.textureX, this.textureY);
      this.leftLegModel[0].addShapeBox(-2.0F, 8.1F, -2.3F, 4, 4, 5, 0.0F, 0.4F, -1.0F, 0.0F, 0.4F, -1.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F);
      this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftLegModel[1].addShapeBox(-2.0F, -0.1F, -2.0F, 4, 10, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftLegModel[2].addShapeBox(-2.0F, 1.1F, -2.0F, 4, 1, 4, 0.0F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F);
      this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftLegModel[3].addShapeBox(-2.0F, 2.1F, -2.0F, 4, 1, 4, 0.0F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F);
      this.leftLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftLegModel[4].addShapeBox(-2.0F, 3.1F, -2.0F, 4, 1, 4, 0.0F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F);
      this.leftLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftLegModel[5].addShapeBox(-2.0F, 4.1F, -2.0F, 4, 1, 4, 0.0F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F);
      this.leftLegModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftLegModel[6].addShapeBox(-2.0F, 5.0F, -2.3F, 4, 3, 5, 0.0F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, -1.2F, -0.4F, 0.4F, -1.2F, -0.4F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, -1.2F, -0.4F, 0.4F, -1.2F, -0.4F);
      this.leftLegModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initrightLegModel_1() {
      this.rightLegModel[0] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.rightLegModel[1] = new ModelRendererTurbo(this, 73, 1, this.textureX, this.textureY);
      this.rightLegModel[2] = new ModelRendererTurbo(this, 49, 49, this.textureX, this.textureY);
      this.rightLegModel[3] = new ModelRendererTurbo(this, 73, 49, this.textureX, this.textureY);
      this.rightLegModel[4] = new ModelRendererTurbo(this, 97, 49, this.textureX, this.textureY);
      this.rightLegModel[5] = new ModelRendererTurbo(this, 1, 57, this.textureX, this.textureY);
      this.rightLegModel[6] = new ModelRendererTurbo(this, 25, 57, this.textureX, this.textureY);
      this.rightLegModel[0].addShapeBox(-2.0F, 8.1F, -2.3F, 4, 4, 5, 0.0F, 0.4F, -1.0F, 0.0F, 0.4F, -1.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F);
      this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightLegModel[1].addShapeBox(-2.0F, -0.1F, -2.0F, 4, 10, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightLegModel[2].addShapeBox(-2.0F, 4.1F, -2.0F, 4, 1, 4, 0.0F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F);
      this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightLegModel[3].addShapeBox(-2.0F, 1.1F, -2.0F, 4, 1, 4, 0.0F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F);
      this.rightLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightLegModel[4].addShapeBox(-2.0F, 3.1F, -2.0F, 4, 1, 4, 0.0F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F);
      this.rightLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightLegModel[5].addShapeBox(-2.0F, 2.1F, -2.0F, 4, 1, 4, 0.0F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F, 0.2F, -0.05F, 0.2F);
      this.rightLegModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightLegModel[6].addShapeBox(-2.0F, 5.0F, -2.3F, 4, 3, 5, 0.0F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, -1.2F, -0.4F, 0.4F, -1.2F, -0.4F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, -1.2F, -0.4F, 0.4F, -1.2F, -0.4F);
      this.rightLegModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
