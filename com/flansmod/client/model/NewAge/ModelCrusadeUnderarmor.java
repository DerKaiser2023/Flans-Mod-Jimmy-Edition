package com.flansmod.client.model.NewAge;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelCrusadeUnderarmor extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 128;

   public ModelCrusadeUnderarmor() {
      this.headModel = new ModelRendererTurbo[4];
      this.bodyModel = new ModelRendererTurbo[5];
      this.leftArmModel = new ModelRendererTurbo[2];
      this.rightArmModel = new ModelRendererTurbo[2];
      this.leftLegModel = new ModelRendererTurbo[2];
      this.rightLegModel = new ModelRendererTurbo[2];
      this.initheadModel_1();
      this.initbodyModel_1();
      this.initleftArmModel_1();
      this.initrightArmModel_1();
      this.initleftLegModel_1();
      this.initrightLegModel_1();
   }

   private void initheadModel_1() {
      this.headModel[0] = new ModelRendererTurbo(this, 1, 33, this.textureX, this.textureY);
      this.headModel[1] = new ModelRendererTurbo(this, 81, 25, this.textureX, this.textureY);
      this.headModel[2] = new ModelRendererTurbo(this, 33, 41, this.textureX, this.textureY);
      this.headModel[3] = new ModelRendererTurbo(this, 33, 33, this.textureX, this.textureY);
      this.headModel[0].addShapeBox(-4.0F, -1.0F, -4.0F, 8, 1, 8, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
      this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[1].addShapeBox(-4.0F, -5.0F, -1.0F, 8, 4, 5, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
      this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[2].addShapeBox(-4.0F, -8.0F, -4.0F, 8, 3, 8, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[3].addShapeBox(-4.0F, -5.0F, -3.0F, 8, 4, 2, 0.0F, 0.1F, 0.0F, -0.9F, 0.1F, 0.0F, -0.9F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.1F, 1.1F, 0.1F, 0.1F, 1.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
      this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initbodyModel_1() {
      this.bodyModel[0] = new ModelRendererTurbo(this, 25, 17, this.textureX, this.textureY);
      this.bodyModel[1] = new ModelRendererTurbo(this, 57, 17, this.textureX, this.textureY);
      this.bodyModel[2] = new ModelRendererTurbo(this, 81, 17, this.textureX, this.textureY);
      this.bodyModel[3] = new ModelRendererTurbo(this, 97, 41, this.textureX, this.textureY);
      this.bodyModel[4] = new ModelRendererTurbo(this, 121, 1, this.textureX, this.textureY);
      this.bodyModel[0].addShapeBox(-4.0F, 1.9F, -2.0F, 8, 10, 4, 0.0F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
      this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[1].addShapeBox(-4.0F, -0.1F, -2.0F, 4, 2, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, -0.5F, 0.1F, 0.0F, -0.5F, 0.1F, 0.0F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F);
      this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[2].addShapeBox(0.0F, -0.1F, -2.0F, 4, 2, 4, 0.0F, 0.0F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.0F, -0.5F, 0.1F);
      this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[3].addShapeBox(-4.0F, 8.5F, -2.0F, 8, 1, 4, 0.0F, 0.5F, -0.9F, 0.5F, 0.5F, -3.5F, 0.5F, 0.5F, -3.5F, 0.5F, 0.5F, -0.9F, 0.5F, 0.5F, 1.1F, 0.5F, 0.5F, 3.5F, 0.5F, 0.5F, 3.5F, 0.5F, 0.5F, 1.1F, 0.5F);
      this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[4].addShapeBox(4.5F, 9.0F, 0.0F, 1, 13, 1, 0.0F, 0.0F, -0.5F, 4.0F, 0.0F, -0.5F, 4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F, 0.0F, -1.0F, 1.0F, 0.0F, -1.0F, 1.0F);
      this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initleftArmModel_1() {
      this.leftArmModel[0] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.leftArmModel[1] = new ModelRendererTurbo(this, 57, 25, this.textureX, this.textureY);
      this.leftArmModel[0].addShapeBox(-1.0F, -2.1F, -2.0F, 4, 9, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[1].addShapeBox(-1.0F, 6.6F, -2.0F, 4, 4, 4, 0.0F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F);
      this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initrightArmModel_1() {
      this.rightArmModel[0] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.rightArmModel[1] = new ModelRendererTurbo(this, 105, 17, this.textureX, this.textureY);
      this.rightArmModel[0].addShapeBox(-3.0F, -2.1F, -2.0F, 4, 9, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[1].addShapeBox(-3.0F, 6.6F, -2.0F, 4, 4, 4, 0.0F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F);
      this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initleftLegModel_1() {
      this.leftLegModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.leftLegModel[1] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.leftLegModel[0].addShapeBox(-2.0F, 8.1F, -2.3F, 4, 4, 5, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F);
      this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftLegModel[1].addShapeBox(-2.0F, -0.1F, -2.0F, 4, 10, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initrightLegModel_1() {
      this.rightLegModel[0] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.rightLegModel[1] = new ModelRendererTurbo(this, 73, 1, this.textureX, this.textureY);
      this.rightLegModel[0].addShapeBox(-2.0F, 8.1F, -2.3F, 4, 4, 5, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F);
      this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightLegModel[1].addShapeBox(-2.0F, -0.1F, -2.0F, 4, 10, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
