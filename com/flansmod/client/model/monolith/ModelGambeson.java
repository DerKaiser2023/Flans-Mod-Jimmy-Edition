package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelGambeson extends ModelCustomArmour {
   int textureX = 64;
   int textureY = 128;

   public ModelGambeson() {
      this.bodyModel = new ModelRendererTurbo[7];
      this.leftArmModel = new ModelRendererTurbo[2];
      this.rightArmModel = new ModelRendererTurbo[2];
      this.leftLegModel = new ModelRendererTurbo[2];
      this.rightLegModel = new ModelRendererTurbo[2];
      this.initbodyModel_1();
      this.initleftArmModel_1();
      this.initrightArmModel_1();
      this.initleftLegModel_1();
      this.initrightLegModel_1();
   }

   private void initbodyModel_1() {
      this.bodyModel[0] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.bodyModel[1] = new ModelRendererTurbo(this, 33, 17, this.textureX, this.textureY);
      this.bodyModel[2] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.bodyModel[3] = new ModelRendererTurbo(this, 49, 33, this.textureX, this.textureY);
      this.bodyModel[4] = new ModelRendererTurbo(this, 33, 57, this.textureX, this.textureY);
      this.bodyModel[5] = new ModelRendererTurbo(this, 1, 65, this.textureX, this.textureY);
      this.bodyModel[6] = new ModelRendererTurbo(this, 1, 73, this.textureX, this.textureY);
      this.bodyModel[0].addShapeBox(-4.0F, 9.5F, -2.0F, 8, 1, 4, 0.0F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F);
      this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[1].addShapeBox(-4.0F, 11.3F, -2.0F, 8, 5, 4, 0.0F, 0.3F, 0.1F, 0.3F, 0.3F, 0.1F, 0.3F, 0.3F, 0.1F, 0.3F, 0.3F, 0.1F, 0.3F, 0.8F, 0.7F, 0.8F, 0.8F, 0.7F, 0.8F, 0.8F, 0.7F, 0.8F, 0.8F, 0.7F, 0.8F);
      this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[2].addShapeBox(-2.0F, 0.0F, -2.2F, 2, 4, 4, 0.0F, 0.1F, 0.2F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.2F, 0.4F, -1.9F, 0.2F, 0.4F, 0.1F, 0.2F, 0.4F, 0.1F, 0.2F, 0.4F, -1.9F, 0.2F, 0.4F);
      this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[3].addShapeBox(0.0F, 0.0F, -2.2F, 2, 4, 4, 0.0F, 0.1F, 0.4F, 0.4F, 0.1F, 0.2F, 0.4F, 0.1F, 0.2F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.2F, 0.4F, -1.9F, 0.2F, 0.4F, -1.9F, 0.2F, 0.4F, 0.1F, 0.2F, 0.4F);
      this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[4].addShapeBox(-4.0F, 0.0F, -2.0F, 8, 9, 4, 0.0F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F);
      this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[5].addShapeBox(-4.0F, 9.0F, -2.0F, 8, 1, 4, 0.0F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F);
      this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[6].addShapeBox(-4.0F, 10.3F, -2.0F, 8, 1, 4, 0.0F, 0.1F, -0.1F, 0.1F, 0.1F, -0.1F, 0.1F, 0.1F, -0.1F, 0.1F, 0.1F, -0.1F, 0.1F, 0.3F, -0.1F, 0.3F, 0.3F, -0.1F, 0.3F, 0.3F, -0.1F, 0.3F, 0.3F, -0.1F, 0.3F);
      this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initleftArmModel_1() {
      this.leftArmModel[0] = new ModelRendererTurbo(this, 25, 9, this.textureX, this.textureY);
      this.leftArmModel[1] = new ModelRendererTurbo(this, 25, 33, this.textureX, this.textureY);
      this.leftArmModel[0].addShapeBox(-1.0F, 6.6F, -2.0F, 4, 2, 4, 0.0F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F);
      this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[1].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 9, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
      this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initrightArmModel_1() {
      this.rightArmModel[0] = new ModelRendererTurbo(this, 1, 9, this.textureX, this.textureY);
      this.rightArmModel[1] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.rightArmModel[0].addShapeBox(-3.0F, 6.6F, -2.0F, 4, 2, 4, 0.0F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F);
      this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[1].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 9, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
      this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initleftLegModel_1() {
      this.leftLegModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.leftLegModel[1] = new ModelRendererTurbo(this, 17, 49, this.textureX, this.textureY);
      this.leftLegModel[0].addShapeBox(-2.0F, 10.1F, -2.3F, 4, 2, 5, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F);
      this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftLegModel[1].addShapeBox(-2.0F, 3.0F, -2.0F, 4, 7, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F);
      this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initrightLegModel_1() {
      this.rightLegModel[0] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.rightLegModel[1] = new ModelRendererTurbo(this, 1, 41, this.textureX, this.textureY);
      this.rightLegModel[0].addShapeBox(-2.0F, 10.1F, -2.3F, 4, 2, 5, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F);
      this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightLegModel[1].addShapeBox(-2.0F, 3.0F, -2.0F, 4, 7, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
      this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
