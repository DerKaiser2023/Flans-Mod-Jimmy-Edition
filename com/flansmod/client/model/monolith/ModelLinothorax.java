package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelLinothorax extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 64;

   public ModelLinothorax() {
      this.bodyModel = new ModelRendererTurbo[13];
      this.leftArmModel = new ModelRendererTurbo[1];
      this.rightArmModel = new ModelRendererTurbo[1];
      this.leftLegModel = new ModelRendererTurbo[3];
      this.rightLegModel = new ModelRendererTurbo[3];
      this.initbodyModel_1();
      this.initleftArmModel_1();
      this.initrightArmModel_1();
      this.initleftLegModel_1();
      this.initrightLegModel_1();
   }

   private void initbodyModel_1() {
      this.bodyModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyModel[1] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.bodyModel[2] = new ModelRendererTurbo(this, 1, 9, this.textureX, this.textureY);
      this.bodyModel[3] = new ModelRendererTurbo(this, 25, 17, this.textureX, this.textureY);
      this.bodyModel[4] = new ModelRendererTurbo(this, 57, 17, this.textureX, this.textureY);
      this.bodyModel[5] = new ModelRendererTurbo(this, 89, 17, this.textureX, this.textureY);
      this.bodyModel[6] = new ModelRendererTurbo(this, 113, 1, this.textureX, this.textureY);
      this.bodyModel[7] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.bodyModel[8] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.bodyModel[9] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
      this.bodyModel[10] = new ModelRendererTurbo(this, 105, 9, this.textureX, this.textureY);
      this.bodyModel[11] = new ModelRendererTurbo(this, 25, 25, this.textureX, this.textureY);
      this.bodyModel[12] = new ModelRendererTurbo(this, 57, 25, this.textureX, this.textureY);
      this.bodyModel[0].addShapeBox(-4.0F, 9.5F, -2.0F, 8, 1, 4, 0.0F, 0.3F, 0.0F, 0.4F, 0.3F, 0.0F, 0.4F, 0.3F, 0.0F, 0.4F, 0.3F, 0.0F, 0.4F, 0.3F, 0.0F, 0.4F, 0.3F, 0.0F, 0.4F, 0.3F, 0.0F, 0.4F, 0.3F, 0.0F, 0.4F);
      this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[1].addShapeBox(-4.0F, 10.8F, -2.0F, 8, 5, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.5F, 0.1F, 0.5F, 0.5F, 0.1F, 0.5F, 0.5F, 0.1F, 0.5F, 0.5F, 0.1F, 0.5F);
      this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[2].addShapeBox(-4.0F, 2.0F, -2.0F, 8, 7, 4, 0.0F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F);
      this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[3].addShapeBox(-4.0F, 11.0F, -2.0F, 8, 2, 4, 0.0F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.6F, 0.6F, 0.6F, 0.6F, 0.6F, 0.6F, 0.6F, 0.6F, 0.6F, 0.6F, 0.6F, 0.6F);
      this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[4].addShapeBox(-4.0F, 10.5F, -2.0F, 8, 1, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.4F, -0.7F, 0.4F, 0.4F, -0.7F, 0.4F, 0.4F, -0.7F, 0.4F, 0.4F, -0.7F, 0.4F);
      this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[5].addShapeBox(-4.0F, 9.0F, -2.0F, 8, 1, 4, 0.0F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F);
      this.bodyModel[5].func_78793_a(0.0F, 0.3F, 0.0F);
      this.bodyModel[6].addShapeBox(-4.0F, 0.0F, -2.2F, 2, 2, 4, 0.0F, 0.55F, 0.3F, 0.55F, 0.55F, 0.5F, 0.55F, 0.55F, 0.5F, 0.55F, 0.55F, 0.3F, 0.55F, 0.55F, 0.3F, 0.55F, 0.55F, 0.3F, 0.55F, 0.55F, 0.3F, 0.55F, 0.55F, 0.3F, 0.55F);
      this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[7].addShapeBox(-4.0F, 0.0F, 1.0F, 8, 4, 1, 0.0F, 0.55F, 0.3F, -1.0F, 0.55F, 0.5F, -1.0F, 0.55F, 0.5F, 0.55F, 0.55F, 0.3F, 0.55F, 0.55F, 0.3F, -1.0F, 0.55F, 0.3F, -1.0F, 0.55F, 0.3F, 0.55F, 0.55F, 0.3F, 0.55F);
      this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[8].addShapeBox(-2.65F, 2.0F, -2.2F, 1, 2, 1, 0.0F, 0.5F, -0.2F, 0.55F, 0.2F, -0.2F, 0.55F, 0.2F, -0.2F, 0.55F, 0.5F, -0.2F, 0.55F, 0.5F, 0.0F, 0.55F, 0.2F, 0.0F, 0.55F, 0.2F, 0.0F, 0.55F, 0.5F, 0.0F, 0.55F);
      this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[9].addShapeBox(1.65F, 2.0F, -2.2F, 1, 2, 1, 0.0F, 0.2F, -0.2F, 0.55F, 0.5F, -0.2F, 0.55F, 0.5F, -0.2F, 0.55F, 0.2F, -0.2F, 0.55F, 0.2F, 0.0F, 0.55F, 0.5F, 0.0F, 0.55F, 0.5F, 0.0F, 0.55F, 0.2F, 0.0F, 0.55F);
      this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[10].addShapeBox(2.0F, 0.0F, -2.2F, 2, 2, 4, 0.0F, 0.55F, 0.3F, 0.55F, 0.55F, 0.5F, 0.55F, 0.55F, 0.5F, 0.55F, 0.55F, 0.3F, 0.55F, 0.55F, 0.3F, 0.55F, 0.55F, 0.3F, 0.55F, 0.55F, 0.3F, 0.55F, 0.55F, 0.3F, 0.55F);
      this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[11].addShapeBox(-4.0F, 1.0F, -2.0F, 8, 6, 4, 0.0F, 0.1F, 0.2F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, 1.1F, 0.1F, 0.1F, 1.1F, 0.1F, 0.1F, 1.1F, 0.1F, 0.1F, 1.1F, 0.1F);
      this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[12].addShapeBox(-4.0F, 2.2F, -4.6F, 8, 1, 4, 0.0F, -1.7F, -0.3F, -1.6F, -1.7F, -0.3F, -1.6F, -1.7F, -0.3F, -1.6F, -1.7F, -0.3F, -1.6F, -1.7F, -0.3F, -1.6F, -1.7F, -0.3F, -1.6F, -1.7F, -0.3F, -1.6F, -1.7F, -0.3F, -1.6F);
      this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initleftArmModel_1() {
      this.leftArmModel[0] = new ModelRendererTurbo(this, 89, 1, this.textureX, this.textureY);
      this.leftArmModel[0].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
      this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initrightArmModel_1() {
      this.rightArmModel[0] = new ModelRendererTurbo(this, 65, 1, this.textureX, this.textureY);
      this.rightArmModel[0].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
      this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initleftLegModel_1() {
      this.leftLegModel[0] = new ModelRendererTurbo(this, 89, 25, this.textureX, this.textureY);
      this.leftLegModel[1] = new ModelRendererTurbo(this, 113, 25, this.textureX, this.textureY);
      this.leftLegModel[2] = new ModelRendererTurbo(this, 65, 33, this.textureX, this.textureY);
      this.leftLegModel[0].addShapeBox(-2.0F, 11.1F, -2.0F, 4, 1, 4, 0.0F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftLegModel[1].addShapeBox(-2.0F, 5.0F, -2.0F, 2, 2, 4, 0.0F, 0.1F, 0.0F, 0.1F, 2.1F, 0.0F, 0.1F, 2.1F, 0.0F, -2.8F, 0.1F, 0.0F, -2.8F, 0.1F, 0.0F, 0.1F, 2.1F, 0.0F, 0.1F, 2.1F, 0.0F, -0.8F, 0.1F, 0.0F, -0.8F);
      this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftLegModel[2].addShapeBox(-2.0F, 7.0F, -2.0F, 2, 4, 4, 0.0F, 0.1F, 0.0F, 0.1F, 2.1F, 0.0F, 0.1F, 2.1F, 0.0F, -0.8F, 0.1F, 0.0F, -0.8F, 0.1F, 0.0F, 0.1F, 2.1F, 0.0F, 0.1F, 2.1F, 0.0F, -1.8F, 0.1F, 0.0F, -1.8F);
      this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initrightLegModel_1() {
      this.rightLegModel[0] = new ModelRendererTurbo(this, 1, 33, this.textureX, this.textureY);
      this.rightLegModel[1] = new ModelRendererTurbo(this, 49, 33, this.textureX, this.textureY);
      this.rightLegModel[2] = new ModelRendererTurbo(this, 81, 33, this.textureX, this.textureY);
      this.rightLegModel[0].addShapeBox(-2.0F, 11.1F, -2.0F, 4, 1, 4, 0.0F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightLegModel[1].addShapeBox(-2.0F, 5.0F, -2.0F, 2, 2, 4, 0.0F, 0.1F, 0.0F, 0.1F, 2.1F, 0.0F, 0.1F, 2.1F, 0.0F, -2.8F, 0.1F, 0.0F, -2.8F, 0.1F, 0.0F, 0.1F, 2.1F, 0.0F, 0.1F, 2.1F, 0.0F, -0.8F, 0.1F, 0.0F, -0.8F);
      this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightLegModel[2].addShapeBox(-2.0F, 7.0F, -2.0F, 2, 4, 4, 0.0F, 0.1F, 0.0F, 0.1F, 2.1F, 0.0F, 0.1F, 2.1F, 0.0F, -0.8F, 0.1F, 0.0F, -0.8F, 0.1F, 0.0F, 0.1F, 2.1F, 0.0F, 0.1F, 2.1F, 0.0F, -1.8F, 0.1F, 0.0F, -1.8F);
      this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
