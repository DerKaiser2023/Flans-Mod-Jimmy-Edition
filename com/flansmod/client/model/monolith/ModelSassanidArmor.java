package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelSassanidArmor extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 128;

   public ModelSassanidArmor() {
      this.bodyModel = new ModelRendererTurbo[15];
      this.leftArmModel = new ModelRendererTurbo[3];
      this.rightArmModel = new ModelRendererTurbo[3];
      this.leftLegModel = new ModelRendererTurbo[2];
      this.rightLegModel = new ModelRendererTurbo[2];
      this.initbodyModel_1();
      this.initleftArmModel_1();
      this.initrightArmModel_1();
      this.initleftLegModel_1();
      this.initrightLegModel_1();
   }

   private void initbodyModel_1() {
      this.bodyModel[0] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.bodyModel[1] = new ModelRendererTurbo(this, 89, 9, this.textureX, this.textureY);
      this.bodyModel[2] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.bodyModel[3] = new ModelRendererTurbo(this, 1, 33, this.textureX, this.textureY);
      this.bodyModel[4] = new ModelRendererTurbo(this, 33, 33, this.textureX, this.textureY);
      this.bodyModel[5] = new ModelRendererTurbo(this, 49, 33, this.textureX, this.textureY);
      this.bodyModel[6] = new ModelRendererTurbo(this, 65, 41, this.textureX, this.textureY);
      this.bodyModel[7] = new ModelRendererTurbo(this, 65, 33, this.textureX, this.textureY);
      this.bodyModel[8] = new ModelRendererTurbo(this, 97, 41, this.textureX, this.textureY);
      this.bodyModel[9] = new ModelRendererTurbo(this, 49, 49, this.textureX, this.textureY);
      this.bodyModel[10] = new ModelRendererTurbo(this, 81, 49, this.textureX, this.textureY);
      this.bodyModel[11] = new ModelRendererTurbo(this, 105, 49, this.textureX, this.textureY);
      this.bodyModel[12] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
      this.bodyModel[13] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.bodyModel[14] = new ModelRendererTurbo(this, 65, 1, this.textureX, this.textureY);
      this.bodyModel[0].addShapeBox(-4.0F, 8.5F, -2.0F, 8, 1, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
      this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[1].addShapeBox(-4.0F, 0.0F, -2.0F, 8, 9, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
      this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[2].addShapeBox(-4.0F, 9.8F, -2.0F, 8, 6, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.5F, 0.1F, 0.5F, 0.5F, 0.1F, 0.5F, 0.5F, 0.1F, 0.5F, 0.5F, 0.1F, 0.5F);
      this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[3].addShapeBox(-4.0F, 0.0F, -2.0F, 8, 8, 4, 0.0F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F);
      this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[4].addShapeBox(-4.0F, 10.0F, -2.0F, 3, 5, 4, 0.0F, 0.4F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.6F, 0.1F, 0.6F, -0.4F, 0.1F, 0.6F, -0.4F, 0.1F, 0.6F, 0.6F, 0.1F, 0.6F);
      this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[5].addShapeBox(1.0F, 10.0F, -2.0F, 3, 5, 4, 0.0F, 0.0F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, -0.4F, 0.1F, 0.6F, 0.6F, 0.1F, 0.6F, 0.6F, 0.1F, 0.6F, -0.4F, 0.1F, 0.6F);
      this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[6].addShapeBox(-4.0F, 9.5F, -2.0F, 8, 1, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.4F, -0.7F, 0.4F, 0.4F, -0.7F, 0.4F, 0.4F, -0.7F, 0.4F, 0.4F, -0.7F, 0.4F);
      this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[7].addShapeBox(-1.5F, 10.0F, -2.0F, 3, 1, 4, 0.0F, 0.0F, 0.2F, 0.3F, 0.0F, 0.2F, 0.3F, 0.0F, 0.2F, 0.3F, 0.0F, 0.2F, 0.3F, 0.0F, 0.1F, 0.3F, 0.0F, 0.1F, 0.3F, 0.0F, 0.1F, 0.3F, 0.0F, 0.1F, 0.3F);
      this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[8].addShapeBox(-4.0F, 8.0F, -2.0F, 8, 1, 4, 0.0F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.2F, -0.7F, 0.2F, 0.2F, -0.7F, 0.2F, 0.2F, -0.7F, 0.2F, 0.2F, -0.7F, 0.2F);
      this.bodyModel[8].func_78793_a(0.0F, 0.3F, 0.0F);
      this.bodyModel[9].addShapeBox(-4.0F, 3.5F, -2.0F, 8, 1, 4, 0.0F, 0.45F, 0.1F, 0.45F, 0.45F, 0.1F, 0.45F, 0.45F, 0.1F, 0.45F, 0.45F, 0.1F, 0.45F, 0.45F, 0.1F, 0.45F, 0.45F, 0.1F, 0.45F, 0.45F, 0.1F, 0.45F, 0.45F, 0.1F, 0.45F);
      this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[10].addShapeBox(-4.0F, 3.0F, -2.0F, 4, 1, 4, 0.0F, -0.55F, 3.4F, 0.45F, 0.45F, -0.4F, 0.45F, 0.45F, -0.4F, 0.45F, -0.55F, 3.4F, 0.45F, 0.45F, -4.2F, 0.45F, 0.45F, 0.6F, 0.45F, 0.45F, 0.6F, 0.45F, 0.45F, -4.2F, 0.45F);
      this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[11].addShapeBox(0.0F, 3.0F, -2.0F, 4, 1, 4, 0.0F, 0.45F, -0.4F, 0.45F, -0.55F, 3.4F, 0.45F, -0.55F, 3.4F, 0.45F, 0.45F, -0.4F, 0.45F, 0.45F, 0.6F, 0.45F, 0.45F, -4.2F, 0.45F, 0.45F, -4.2F, 0.45F, 0.45F, 0.6F, 0.45F);
      this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[12].addShapeBox(-1.5F, 3.0F, -2.5F, 3, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[13].addShapeBox(-1.5F, 2.0F, -2.5F, 3, 1, 1, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[14].addShapeBox(-1.5F, 4.0F, -2.5F, 3, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
      this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initleftArmModel_1() {
      this.leftArmModel[0] = new ModelRendererTurbo(this, 73, 1, this.textureX, this.textureY);
      this.leftArmModel[1] = new ModelRendererTurbo(this, 57, 17, this.textureX, this.textureY);
      this.leftArmModel[2] = new ModelRendererTurbo(this, 25, 49, this.textureX, this.textureY);
      this.leftArmModel[0].addShapeBox(-1.0F, 6.6F, -2.0F, 4, 4, 4, 0.0F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F);
      this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[1].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 9, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
      this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[2].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 7, 4, 0.0F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F);
      this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initrightArmModel_1() {
      this.rightArmModel[0] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.rightArmModel[1] = new ModelRendererTurbo(this, 33, 17, this.textureX, this.textureY);
      this.rightArmModel[2] = new ModelRendererTurbo(this, 1, 49, this.textureX, this.textureY);
      this.rightArmModel[0].addShapeBox(-3.0F, 6.6F, -2.0F, 4, 4, 4, 0.0F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F);
      this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[1].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 9, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
      this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[2].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 7, 4, 0.0F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F);
      this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initleftLegModel_1() {
      this.leftLegModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.leftLegModel[1] = new ModelRendererTurbo(this, 105, 25, this.textureX, this.textureY);
      this.leftLegModel[0].addShapeBox(-2.0F, 8.1F, -2.3F, 4, 4, 5, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F);
      this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftLegModel[1].addShapeBox(-2.0F, 3.0F, -2.0F, 4, 5, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
   }

   private void initrightLegModel_1() {
      this.rightLegModel[0] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.rightLegModel[1] = new ModelRendererTurbo(this, 81, 25, this.textureX, this.textureY);
      this.rightLegModel[0].addShapeBox(-2.0F, 8.1F, -2.3F, 4, 4, 5, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, -0.4F, 0.4F, 0.0F, -0.4F);
      this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightLegModel[1].addShapeBox(-2.0F, 3.0F, -2.0F, 4, 5, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
