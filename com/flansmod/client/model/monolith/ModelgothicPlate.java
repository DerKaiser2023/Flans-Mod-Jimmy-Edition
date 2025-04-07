package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelgothicPlate extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 128;

   public ModelgothicPlate() {
      this.headModel = new ModelRendererTurbo[3];
      this.bodyModel = new ModelRendererTurbo[19];
      this.leftArmModel = new ModelRendererTurbo[10];
      this.rightArmModel = new ModelRendererTurbo[10];
      this.leftLegModel = new ModelRendererTurbo[6];
      this.rightLegModel = new ModelRendererTurbo[5];
      this.initheadModel_1();
      this.initbodyModel_1();
      this.initleftArmModel_1();
      this.initrightArmModel_1();
      this.initleftLegModel_1();
      this.initrightLegModel_1();
   }

   private void initheadModel_1() {
      this.headModel[0] = new ModelRendererTurbo(this, 1, 49, this.textureX, this.textureY);
      this.headModel[1] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
      this.headModel[2] = new ModelRendererTurbo(this, 105, 33, this.textureX, this.textureY);
      this.headModel[0].addShapeBox(-4.0F, -1.0F, -4.0F, 8, 1, 8, 0.0F, 0.2F, 0.2F, 0.1F, 0.2F, 0.2F, 0.1F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, 0.2F, 0.1F, 0.2F, 0.2F, 0.1F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F);
      this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[1].addShapeBox(-4.0F, -1.0F, -5.0F, 4, 1, 2, 0.0F, 0.2F, 0.2F, -0.7F, 0.0F, 0.2F, 0.1F, 0.0F, 0.2F, 1.2F, 0.2F, 0.2F, 1.2F, 0.2F, 0.2F, -0.9F, 0.0F, 0.5F, -0.2F, 0.0F, 1.8F, 2.2F, 0.2F, 0.2F, 1.2F);
      this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[2].addShapeBox(0.0F, -1.0F, -5.0F, 4, 1, 2, 0.0F, 0.0F, 0.2F, 0.1F, 0.2F, 0.2F, -0.7F, 0.2F, 0.2F, 1.2F, 0.0F, 0.2F, 1.2F, 0.0F, 0.5F, -0.2F, 0.2F, 0.2F, -0.9F, 0.2F, 0.2F, 1.2F, 0.0F, 1.8F, 2.2F);
      this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initbodyModel_1() {
      this.bodyModel[0] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.bodyModel[1] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.bodyModel[2] = new ModelRendererTurbo(this, 33, 49, this.textureX, this.textureY);
      this.bodyModel[3] = new ModelRendererTurbo(this, 57, 49, this.textureX, this.textureY);
      this.bodyModel[4] = new ModelRendererTurbo(this, 81, 49, this.textureX, this.textureY);
      this.bodyModel[5] = new ModelRendererTurbo(this, 105, 49, this.textureX, this.textureY);
      this.bodyModel[6] = new ModelRendererTurbo(this, 33, 57, this.textureX, this.textureY);
      this.bodyModel[7] = new ModelRendererTurbo(this, 57, 57, this.textureX, this.textureY);
      this.bodyModel[8] = new ModelRendererTurbo(this, 81, 57, this.textureX, this.textureY);
      this.bodyModel[9] = new ModelRendererTurbo(this, 105, 57, this.textureX, this.textureY);
      this.bodyModel[10] = new ModelRendererTurbo(this, 1, 65, this.textureX, this.textureY);
      this.bodyModel[11] = new ModelRendererTurbo(this, 89, 73, this.textureX, this.textureY);
      this.bodyModel[12] = new ModelRendererTurbo(this, 1, 81, this.textureX, this.textureY);
      this.bodyModel[13] = new ModelRendererTurbo(this, 33, 81, this.textureX, this.textureY);
      this.bodyModel[14] = new ModelRendererTurbo(this, 57, 81, this.textureX, this.textureY);
      this.bodyModel[15] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.bodyModel[16] = new ModelRendererTurbo(this, 65, 1, this.textureX, this.textureY);
      this.bodyModel[17] = new ModelRendererTurbo(this, 89, 1, this.textureX, this.textureY);
      this.bodyModel[18] = new ModelRendererTurbo(this, 17, 17, this.textureX, this.textureY);
      this.bodyModel[0].addShapeBox(-4.0F, 0.4F, -2.0F, 8, 13, 4, 0.0F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F, 0.1F, -0.6F, 0.1F, 0.1F, -0.6F, 0.1F, 0.1F, -0.6F, 0.1F, 0.1F, -0.6F, 0.1F);
      this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[1].addShapeBox(-4.0F, 6.5F, -2.0F, 4, 3, 4, 0.0F, 0.4F, 0.0F, 0.4F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.4F, 0.0F, 0.5F, 0.15F, 0.0F, 0.2F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.15F, 0.0F, 0.2F);
      this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[2].addShapeBox(-4.0F, 0.0F, -2.2F, 4, 2, 4, 0.0F, 0.0F, 0.2F, 0.5F, 0.0F, 0.2F, 0.5F, 0.0F, -0.2F, 0.5F, 0.0F, -0.2F, 0.5F, -2.0F, -0.3F, 1.0F, 0.0F, 0.2F, 1.5F, 0.0F, -0.7F, 0.5F, -2.0F, -1.0F, 0.5F);
      this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[3].addShapeBox(0.0F, 0.0F, -2.2F, 4, 2, 4, 0.0F, 0.0F, 0.2F, 0.5F, 0.0F, 0.2F, 0.5F, 0.0F, -0.2F, 0.5F, 0.0F, -0.2F, 0.5F, 0.0F, 0.2F, 1.5F, -2.0F, -0.3F, 1.0F, -2.0F, -1.0F, 0.5F, 0.0F, -0.7F, 0.5F);
      this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[4].addShapeBox(-4.0F, 3.5F, -2.0F, 4, 3, 4, 0.0F, 0.5F, 0.0F, 0.7F, 0.0F, 0.0F, 1.2F, 0.0F, 0.0F, 1.0F, 0.5F, 0.0F, 0.5F, 0.4F, 0.0F, 0.4F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.4F, 0.0F, 0.4F);
      this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[5].addShapeBox(-4.0F, 2.5F, -2.0F, 4, 1, 4, 0.0F, -0.2F, 0.5F, 0.5F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 1.0F, -0.2F, 0.5F, 0.7F, 0.4F, 0.0F, 0.7F, 0.0F, 0.0F, 1.2F, 0.0F, 0.0F, 1.0F, 0.4F, 0.0F, 0.5F);
      this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[6].addShapeBox(-4.0F, -0.5F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -0.3F, 0.3F, -1.5F, -0.3F, 1.2F, 0.0F, -0.3F, 0.8F, -0.8F, -0.3F, 0.5F, -0.2F, 0.5F, 0.5F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 1.0F, -0.2F, 0.5F, 0.7F);
      this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[7].addShapeBox(0.0F, -0.5F, -2.0F, 4, 2, 4, 0.0F, -1.5F, -0.3F, 1.2F, 0.2F, -0.3F, 0.3F, -0.8F, -0.3F, 0.5F, 0.0F, -0.3F, 0.8F, 0.0F, 0.5F, 0.8F, -0.2F, 0.5F, 0.5F, -0.2F, 0.5F, 0.7F, 0.0F, 0.5F, 1.0F);
      this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[8].addShapeBox(0.0F, 2.5F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 0.5F, 0.8F, -0.2F, 0.5F, 0.5F, -0.2F, 0.5F, 0.7F, 0.0F, 0.5F, 1.0F, 0.0F, 0.0F, 1.2F, 0.4F, 0.0F, 0.7F, 0.4F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0F);
      this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[9].addShapeBox(0.0F, 3.5F, -2.0F, 4, 3, 4, 0.0F, 0.0F, 0.0F, 1.2F, 0.5F, 0.0F, 0.7F, 0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.0F, 0.0F, 1.0F);
      this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[10].addShapeBox(0.0F, 6.5F, -2.0F, 4, 3, 4, 0.0F, 0.0F, 0.0F, 1.0F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.4F, 0.15F, 0.0F, 0.2F, 0.15F, 0.0F, 0.2F, 0.0F, 0.0F, 0.4F);
      this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[11].addShapeBox(-4.0F, 9.4F, -2.0F, 8, 1, 4, 0.0F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F);
      this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[12].addShapeBox(-4.0F, 9.8F, -2.0F, 8, 1, 4, 0.0F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F);
      this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[13].addShapeBox(-4.0F, 10.8F, -2.0F, 4, 1, 4, 0.0F, 0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 1.0F, 0.0F, 1.0F, 0.0F, 0.5F, 1.2F, 0.0F, 0.5F, 1.2F, 1.0F, 0.0F, 1.0F);
      this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[14].addShapeBox(0.0F, 10.8F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.5F, 1.2F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.5F, 1.2F);
      this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[15].addShapeBox(-4.0F, 4.7F, -3.3F, 4, 1, 1, 0.0F, 0.3F, -1.3F, -0.6F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.3F, -1.3F, 0.0F, 0.3F, 0.7F, -0.6F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.3F, 0.7F, 0.0F);
      this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[16].addShapeBox(-4.0F, 3.7F, -3.3F, 4, 1, 1, 0.0F, 0.3F, -1.3F, -0.6F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.3F, -1.3F, 0.0F, 0.3F, 0.7F, -0.6F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.3F, 0.7F, 0.0F);
      this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[17].addShapeBox(0.0F, 3.7F, -3.3F, 4, 1, 1, 0.0F, 0.0F, -0.3F, 0.0F, 0.3F, -1.3F, -0.6F, 0.3F, -1.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.3F, 0.7F, -0.6F, 0.3F, 0.7F, 0.0F, 0.0F, -0.3F, 0.0F);
      this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[18].addShapeBox(0.0F, 4.7F, -3.3F, 4, 1, 1, 0.0F, 0.0F, -0.3F, 0.0F, 0.3F, -1.3F, -0.6F, 0.3F, -1.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.3F, 0.7F, -0.6F, 0.3F, 0.7F, 0.0F, 0.0F, -0.3F, 0.0F);
      this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initleftArmModel_1() {
      this.leftArmModel[0] = new ModelRendererTurbo(this, 73, 1, this.textureX, this.textureY);
      this.leftArmModel[1] = new ModelRendererTurbo(this, 1, 41, this.textureX, this.textureY);
      this.leftArmModel[2] = new ModelRendererTurbo(this, 25, 41, this.textureX, this.textureY);
      this.leftArmModel[3] = new ModelRendererTurbo(this, 73, 41, this.textureX, this.textureY);
      this.leftArmModel[4] = new ModelRendererTurbo(this, 89, 17, this.textureX, this.textureY);
      this.leftArmModel[5] = new ModelRendererTurbo(this, 73, 65, this.textureX, this.textureY);
      this.leftArmModel[6] = new ModelRendererTurbo(this, 97, 65, this.textureX, this.textureY);
      this.leftArmModel[7] = new ModelRendererTurbo(this, 113, 65, this.textureX, this.textureY);
      this.leftArmModel[8] = new ModelRendererTurbo(this, 1, 73, this.textureX, this.textureY);
      this.leftArmModel[9] = new ModelRendererTurbo(this, 73, 73, this.textureX, this.textureY);
      this.leftArmModel[0].addShapeBox(-1.0F, -2.1F, -2.0F, 4, 8, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[1].addShapeBox(-1.0F, 8.5F, -2.0F, 4, 2, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F);
      this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[2].addShapeBox(-1.0F, 6.0F, -2.0F, 4, 3, 4, 0.0F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F);
      this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[3].addShapeBox(-1.0F, 4.9F, -2.0F, 4, 2, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F);
      this.leftArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[4].addShapeBox(2.0F, 1.4F, -2.0F, 1, 3, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F);
      this.leftArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[5].addShapeBox(-0.5F, 2.9F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -0.8F, 0.4F, 0.2F, 0.2F, 0.4F, 0.2F, 0.2F, 0.4F, 0.2F, -0.8F, 0.4F, 0.2F, -0.8F, 0.4F, 0.2F, 0.2F, 0.4F, 0.2F, 0.2F, 0.4F, 0.2F, -0.8F, 0.4F);
      this.leftArmModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[6].addShapeBox(0.0F, -2.1F, -2.0F, 3, 2, 4, 0.0F, 1.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 1.3F, 0.3F, 0.3F, 1.3F, 1.3F, 1.3F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F, 1.3F, 1.3F, 1.3F);
      this.leftArmModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[7].addShapeBox(0.0F, -1.5F, -2.0F, 3, 2, 4, 0.0F, 0.0F, 0.3F, 0.2F, 0.2F, 0.3F, 0.2F, 0.2F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F);
      this.leftArmModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[8].addShapeBox(0.0F, -0.5F, -2.0F, 3, 2, 4, 0.0F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, -0.2F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, -0.2F, 0.0F, 0.4F);
      this.leftArmModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[9].addShapeBox(0.0F, 0.5F, -2.0F, 3, 2, 4, 0.0F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, -0.2F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, -0.2F, 0.0F, 0.4F);
      this.leftArmModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initrightArmModel_1() {
      this.rightArmModel[0] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.rightArmModel[1] = new ModelRendererTurbo(this, 97, 25, this.textureX, this.textureY);
      this.rightArmModel[2] = new ModelRendererTurbo(this, 113, 25, this.textureX, this.textureY);
      this.rightArmModel[3] = new ModelRendererTurbo(this, 17, 33, this.textureX, this.textureY);
      this.rightArmModel[4] = new ModelRendererTurbo(this, 33, 33, this.textureX, this.textureY);
      this.rightArmModel[5] = new ModelRendererTurbo(this, 49, 33, this.textureX, this.textureY);
      this.rightArmModel[6] = new ModelRendererTurbo(this, 89, 33, this.textureX, this.textureY);
      this.rightArmModel[7] = new ModelRendererTurbo(this, 49, 41, this.textureX, this.textureY);
      this.rightArmModel[8] = new ModelRendererTurbo(this, 17, 9, this.textureX, this.textureY);
      this.rightArmModel[9] = new ModelRendererTurbo(this, 97, 41, this.textureX, this.textureY);
      this.rightArmModel[0].addShapeBox(-3.0F, -2.1F, -2.0F, 4, 8, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[1].addShapeBox(-3.0F, -2.1F, -2.0F, 3, 2, 4, 0.0F, 0.3F, 0.3F, 0.3F, 1.3F, 0.3F, 0.3F, 1.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.5F, 0.0F, 0.3F, 1.3F, 1.3F, 1.3F, 1.3F, 1.3F, 1.3F, 0.5F, 0.0F, 0.3F);
      this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[2].addShapeBox(-3.0F, -1.5F, -2.0F, 3, 2, 4, 0.0F, 0.2F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.2F, 0.3F, 0.2F, 0.4F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F);
      this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[3].addShapeBox(-3.0F, -0.5F, -2.0F, 3, 2, 4, 0.0F, 0.2F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.2F, 0.3F, 0.2F, 0.4F, 0.0F, 0.4F, -0.2F, 0.0F, 0.4F, -0.2F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F);
      this.rightArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[4].addShapeBox(-3.0F, 0.5F, -2.0F, 3, 2, 4, 0.0F, 0.2F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.2F, 0.3F, 0.2F, 0.4F, 0.0F, 0.4F, -0.2F, 0.0F, 0.4F, -0.2F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F);
      this.rightArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[5].addShapeBox(-3.0F, 8.5F, -2.0F, 4, 2, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F);
      this.rightArmModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[6].addShapeBox(-3.0F, 6.0F, -2.0F, 4, 3, 4, 0.0F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F);
      this.rightArmModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[7].addShapeBox(-3.0F, 4.9F, -2.0F, 4, 2, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F);
      this.rightArmModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[8].addShapeBox(-3.0F, 1.4F, -2.0F, 1, 3, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F);
      this.rightArmModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[9].addShapeBox(-3.5F, 2.9F, -2.0F, 4, 2, 4, 0.0F, 0.2F, 0.2F, 0.4F, 0.2F, -0.8F, 0.4F, 0.2F, -0.8F, 0.4F, 0.2F, 0.2F, 0.4F, 0.2F, 0.2F, 0.4F, 0.2F, -0.8F, 0.4F, 0.2F, -0.8F, 0.4F, 0.2F, 0.2F, 0.4F);
      this.rightArmModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initleftLegModel_1() {
      this.leftLegModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.leftLegModel[1] = new ModelRendererTurbo(this, 25, 17, this.textureX, this.textureY);
      this.leftLegModel[2] = new ModelRendererTurbo(this, 73, 17, this.textureX, this.textureY);
      this.leftLegModel[3] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.leftLegModel[4] = new ModelRendererTurbo(this, 57, 25, this.textureX, this.textureY);
      this.leftLegModel[5] = new ModelRendererTurbo(this, 49, 65, this.textureX, this.textureY);
      this.leftLegModel[0].addShapeBox(-2.0F, 9.1F, -2.3F, 4, 3, 5, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F);
      this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftLegModel[1].addShapeBox(-2.0F, 0.1F, -2.3F, 4, 5, 3, 0.0F, 0.2F, 0.0F, 0.0F, 0.4F, 0.5F, 0.0F, 0.4F, 0.5F, 1.6F, -2.0F, 0.0F, 1.6F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, -1.0F, 1.6F, -2.0F, -1.0F, 1.6F);
      this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftLegModel[2].addShapeBox(-2.0F, 4.1F, -2.8F, 4, 2, 3, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F);
      this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftLegModel[3].addShapeBox(-2.0F, 5.1F, -2.3F, 4, 4, 5, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, -1.0F, -0.4F, 0.2F, -1.0F, -0.4F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, -0.4F, 0.2F, 0.0F, -0.4F);
      this.leftLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftLegModel[4].addShapeBox(-2.0F, 5.1F, -2.3F, 4, 4, 3, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, -1.0F, -0.4F, 0.2F, -1.0F, -0.4F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, -0.4F, 0.2F, 0.0F, -0.4F);
      this.leftLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftLegModel[5].addShapeBox(-2.0F, 0.9F, -2.0F, 4, 8, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.leftLegModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initrightLegModel_1() {
      this.rightLegModel[0] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.rightLegModel[1] = new ModelRendererTurbo(this, 41, 17, this.textureX, this.textureY);
      this.rightLegModel[2] = new ModelRendererTurbo(this, 57, 17, this.textureX, this.textureY);
      this.rightLegModel[3] = new ModelRendererTurbo(this, 73, 25, this.textureX, this.textureY);
      this.rightLegModel[4] = new ModelRendererTurbo(this, 25, 65, this.textureX, this.textureY);
      this.rightLegModel[0].addShapeBox(-2.0F, 9.1F, -2.3F, 4, 3, 5, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F);
      this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightLegModel[1].addShapeBox(-2.0F, 0.1F, -2.3F, 4, 5, 3, 0.0F, 0.4F, 0.5F, 0.0F, 0.2F, 0.0F, 0.0F, -2.0F, 0.0F, 1.6F, 0.4F, 0.5F, 1.6F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, -2.0F, -1.0F, 1.6F, 0.2F, -1.0F, 1.6F);
      this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightLegModel[2].addShapeBox(-2.0F, 4.1F, -2.8F, 4, 2, 3, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F);
      this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightLegModel[3].addShapeBox(-2.0F, 5.1F, -2.3F, 4, 4, 5, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, -1.0F, -0.4F, 0.2F, -1.0F, -0.4F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, -0.4F, 0.2F, 0.0F, -0.4F);
      this.rightLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightLegModel[4].addShapeBox(-2.0F, 0.9F, -2.0F, 4, 8, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.rightLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
