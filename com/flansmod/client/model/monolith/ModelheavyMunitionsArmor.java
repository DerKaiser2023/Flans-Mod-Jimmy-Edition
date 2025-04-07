package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelheavyMunitionsArmor extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 128;

   public ModelheavyMunitionsArmor() {
      this.bodyModel = new ModelRendererTurbo[27];
      this.leftArmModel = new ModelRendererTurbo[10];
      this.rightArmModel = new ModelRendererTurbo[10];
      this.initbodyModel_1();
      this.initleftArmModel_1();
      this.initrightArmModel_1();
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
      this.bodyModel[15] = new ModelRendererTurbo(this, 81, 49, this.textureX, this.textureY);
      this.bodyModel[16] = new ModelRendererTurbo(this, 81, 49, this.textureX, this.textureY);
      this.bodyModel[17] = new ModelRendererTurbo(this, 33, 81, this.textureX, this.textureY);
      this.bodyModel[18] = new ModelRendererTurbo(this, 33, 81, this.textureX, this.textureY);
      this.bodyModel[19] = new ModelRendererTurbo(this, 33, 81, this.textureX, this.textureY);
      this.bodyModel[20] = new ModelRendererTurbo(this, 33, 81, this.textureX, this.textureY);
      this.bodyModel[21] = new ModelRendererTurbo(this, 33, 81, this.textureX, this.textureY);
      this.bodyModel[22] = new ModelRendererTurbo(this, 33, 81, this.textureX, this.textureY);
      this.bodyModel[23] = new ModelRendererTurbo(this, 33, 81, this.textureX, this.textureY);
      this.bodyModel[24] = new ModelRendererTurbo(this, 33, 81, this.textureX, this.textureY);
      this.bodyModel[25] = new ModelRendererTurbo(this, 33, 81, this.textureX, this.textureY);
      this.bodyModel[26] = new ModelRendererTurbo(this, 33, 81, this.textureX, this.textureY);
      this.bodyModel[0].addShapeBox(-4.0F, 0.4F, -2.0F, 8, 13, 4, 0.0F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F, 0.1F, -0.6F, 0.1F, 0.1F, -0.6F, 0.1F, 0.1F, -0.6F, 0.1F, 0.1F, -0.6F, 0.1F);
      this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[1].addShapeBox(-4.0F, 6.5F, -2.0F, 4, 3, 4, 0.0F, 0.6F, 0.0F, 0.4F, 0.0F, -0.5F, 1.5F, 0.0F, 0.0F, 1.0F, 0.6F, 0.0F, 0.5F, 0.15F, 0.0F, 0.2F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.15F, 0.0F, 0.2F);
      this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[2].addShapeBox(-4.0F, 0.0F, -2.2F, 4, 2, 4, 0.0F, -1.0F, 0.4F, 0.5F, 0.0F, 0.8F, 0.5F, 0.0F, 0.8F, 0.5F, -1.0F, 0.4F, 0.5F, -2.0F, -0.3F, 1.0F, 0.0F, 0.2F, 1.5F, 0.0F, -0.7F, 0.5F, -2.0F, -1.0F, 0.5F);
      this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[3].addShapeBox(0.0F, 0.0F, -2.2F, 4, 2, 4, 0.0F, 0.0F, 0.8F, 0.5F, -1.0F, 0.4F, 0.5F, -1.0F, 0.4F, 0.5F, 0.0F, 0.8F, 0.5F, 0.0F, 0.2F, 1.5F, -2.0F, -0.3F, 1.0F, -2.0F, -1.0F, 0.5F, 0.0F, -0.7F, 0.5F);
      this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[4].addShapeBox(-4.0F, 3.5F, -2.0F, 4, 3, 4, 0.0F, 0.5F, 0.0F, 0.4F, 0.0F, 0.0F, 1.2F, 0.0F, 0.0F, 1.0F, 0.5F, 0.0F, 0.5F, 0.6F, 0.0F, 0.4F, 0.0F, 0.49F, 1.49F, 0.0F, 0.0F, 1.0F, 0.6F, 0.0F, 0.4F);
      this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[5].addShapeBox(-4.0F, 2.5F, -2.0F, 4, 1, 4, 0.0F, -0.2F, 0.5F, 0.5F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 1.0F, -0.2F, 0.5F, 0.7F, 0.4F, 0.0F, 0.4F, 0.0F, 0.0F, 1.2F, 0.0F, 0.0F, 1.0F, 0.4F, 0.0F, 0.5F);
      this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[6].addShapeBox(-4.0F, -0.5F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -0.3F, 0.3F, -1.5F, -0.3F, 0.2F, 0.0F, -0.3F, 0.8F, 0.2F, -0.3F, 0.5F, -0.2F, 0.5F, 0.5F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 1.0F, -0.2F, 0.5F, 0.7F);
      this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[7].addShapeBox(0.0F, -0.5F, -2.0F, 4, 2, 4, 0.0F, -1.5F, -0.3F, 0.2F, 0.2F, -0.3F, 0.3F, 0.2F, -0.3F, 0.5F, 0.0F, -0.3F, 0.8F, 0.0F, 0.5F, 0.8F, -0.2F, 0.5F, 0.5F, -0.2F, 0.5F, 0.7F, 0.0F, 0.5F, 1.0F);
      this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[8].addShapeBox(0.0F, 2.5F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 0.5F, 0.8F, -0.2F, 0.5F, 0.5F, -0.2F, 0.5F, 0.7F, 0.0F, 0.5F, 1.0F, 0.0F, 0.0F, 1.2F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0F);
      this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[9].addShapeBox(0.0F, 3.5F, -2.0F, 4, 3, 4, 0.0F, 0.0F, 0.0F, 1.2F, 0.5F, 0.0F, 0.4F, 0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 0.51F, 1.51F, 0.6F, 0.0F, 0.4F, 0.6F, 0.0F, 0.4F, 0.0F, 0.0F, 1.0F);
      this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[10].addShapeBox(0.0F, 6.5F, -2.0F, 4, 3, 4, 0.0F, 0.0F, -0.5F, 1.5F, 0.6F, 0.0F, 0.4F, 0.6F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.4F, 0.15F, 0.0F, 0.2F, 0.15F, 0.0F, 0.2F, 0.0F, 0.0F, 0.4F);
      this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[11].addShapeBox(-4.0F, 9.4F, -2.0F, 8, 1, 4, 0.0F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F);
      this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[12].addShapeBox(-4.0F, 9.8F, -2.0F, 8, 1, 4, 0.0F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F);
      this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[13].addShapeBox(-4.0F, 10.8F, -2.0F, 4, 1, 4, 0.0F, 0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 1.0F, 0.0F, 1.0F, 0.0F, 0.5F, 1.2F, 0.0F, 0.5F, 1.2F, 1.0F, 0.0F, 1.0F);
      this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[14].addShapeBox(0.0F, 10.8F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.5F, 1.2F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.5F, 1.2F);
      this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[15].addShapeBox(-4.0F, 0.5F, -2.0F, 3, 3, 4, 0.0F, 1.5F, 0.0F, 0.4F, -1.0F, 0.0F, 0.7F, -1.0F, 0.0F, 1.0F, 1.5F, 0.0F, 0.5F, 0.6F, 0.0F, 0.4F, -0.5F, 1.0F, 1.5F, 0.0F, 1.0F, 1.0F, 0.6F, 0.0F, 0.4F);
      this.bodyModel[15].func_78793_a(-1.0F, 0.0F, 0.0F);
      this.bodyModel[16].addShapeBox(3.0F, 0.5F, -2.0F, 3, 3, 4, 0.0F, -1.0F, 0.0F, 0.7F, 1.5F, 0.0F, 0.4F, 1.5F, 0.0F, 0.5F, -1.0F, 0.0F, 1.0F, -0.5F, 1.0F, 1.5F, 0.6F, 0.0F, 0.4F, 0.6F, 0.0F, 0.4F, 0.0F, 1.0F, 1.0F);
      this.bodyModel[16].func_78793_a(-1.0F, 0.0F, 0.0F);
      this.bodyModel[17].addShapeBox(-5.0F, 12.2F, -2.0F, 4, 1, 4, 0.0F, -0.2F, 0.5F, 1.0F, 1.0F, 0.0F, 0.8F, 1.0F, 0.0F, 0.8F, -0.2F, 0.5F, 1.0F, 0.3F, -0.3F, 1.0F, 0.5F, 0.0F, 1.2F, 0.5F, 0.0F, 1.2F, 0.3F, -0.3F, 1.0F);
      this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[18].addShapeBox(-5.1F, 13.2F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 0.3F, 0.9F, 0.4F, 0.0F, 0.9F, 0.4F, 0.0F, 0.9F, 0.0F, 0.3F, 0.9F, 0.3F, 0.0F, 1.1F, 0.2F, 0.2F, 1.1F, 0.2F, 0.2F, 1.1F, 0.3F, 0.0F, 1.1F);
      this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[19].addShapeBox(-5.1F, 14.2F, -2.0F, 4, 1, 4, 0.0F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 0.9F, 0.4F, 0.0F, 1.1F, 0.2F, 0.2F, 1.1F, 0.2F, 0.2F, 1.1F, 0.4F, 0.0F, 1.1F);
      this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[20].addShapeBox(-5.1F, 15.2F, -2.0F, 4, 1, 4, 0.0F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 0.9F, 0.4F, 0.0F, 1.1F, 0.2F, 0.2F, 1.1F, 0.2F, 0.2F, 1.1F, 0.4F, 0.0F, 1.1F);
      this.bodyModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[21].addShapeBox(-5.1F, 16.2F, -2.0F, 4, 1, 4, 0.0F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 0.9F, 0.4F, 0.0F, 0.9F, -0.2F, 0.2F, 0.9F, -0.2F, 0.2F, 0.9F, 0.4F, 0.0F, 0.9F);
      this.bodyModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[22].addShapeBox(1.0F, 12.2F, -2.0F, 4, 1, 4, 0.0F, 1.0F, 0.0F, 0.8F, -0.2F, 0.5F, 1.0F, -0.2F, 0.5F, 1.0F, 1.0F, 0.0F, 0.8F, 0.5F, 0.0F, 1.2F, 0.3F, -0.3F, 1.0F, 0.3F, -0.3F, 1.0F, 0.5F, 0.0F, 1.2F);
      this.bodyModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[23].addShapeBox(0.9F, 13.2F, -2.0F, 4, 1, 4, 0.0F, 0.4F, 0.0F, 0.9F, 0.0F, 0.3F, 0.9F, 0.0F, 0.3F, 0.9F, 0.4F, 0.0F, 0.9F, 0.2F, 0.2F, 1.1F, 0.3F, 0.0F, 1.1F, 0.3F, 0.0F, 1.1F, 0.2F, 0.2F, 1.1F);
      this.bodyModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[24].addShapeBox(0.9F, 14.2F, -2.0F, 4, 1, 4, 0.0F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 1.1F, 0.4F, 0.0F, 1.1F, 0.4F, 0.0F, 1.1F, 0.2F, 0.0F, 1.1F);
      this.bodyModel[24].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[25].addShapeBox(0.9F, 15.2F, -2.0F, 4, 1, 4, 0.0F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 1.1F, 0.4F, 0.0F, 1.1F, 0.4F, 0.0F, 1.1F, 0.2F, 0.0F, 1.1F);
      this.bodyModel[25].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[26].addShapeBox(0.9F, 16.2F, -2.0F, 4, 1, 4, 0.0F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 0.9F, -0.2F, 0.0F, 0.9F, 0.4F, 0.0F, 0.9F, 0.4F, 0.0F, 0.9F, -0.2F, 0.0F, 0.9F);
      this.bodyModel[26].func_78793_a(0.0F, 0.0F, 0.0F);
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
      this.leftArmModel[1].addShapeBox(-1.0F, 9.5F, -2.0F, 4, 2, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F);
      this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[2].addShapeBox(-1.0F, 7.0F, -2.0F, 4, 3, 4, 0.0F, 0.5F, -0.8F, 0.5F, 0.5F, -0.8F, 0.5F, 0.5F, -0.8F, 0.5F, 0.5F, -0.8F, 0.5F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F);
      this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[3].addShapeBox(-1.0F, 4.9F, -2.0F, 4, 2, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 1.2F, 0.2F, 0.2F, 1.2F, 0.2F, 0.2F, 1.2F, 0.2F, 0.2F, 1.2F, 0.2F);
      this.leftArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[4].addShapeBox(2.0F, 1.4F, -2.0F, 1, 3, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F);
      this.leftArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[5].addShapeBox(-0.5F, 2.9F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -0.8F, 0.4F, 0.2F, 0.2F, 0.4F, 0.2F, 0.2F, 0.4F, 0.2F, -0.8F, 0.4F, 0.2F, -0.8F, 0.4F, 0.2F, 0.2F, 0.4F, 0.2F, 0.2F, 0.4F, 0.2F, -0.8F, 0.4F);
      this.leftArmModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.leftArmModel[6].addShapeBox(0.0F, -2.1F, -2.0F, 3, 2, 4, 0.0F, 1.3F, 0.6F, 0.8F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 1.3F, 0.6F, 0.8F, 1.3F, 1.3F, 1.8F, 0.5F, 0.0F, 0.8F, 0.5F, 0.0F, 0.8F, 1.3F, 1.3F, 1.8F);
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
      this.rightArmModel[1].addShapeBox(-3.0F, -2.1F, -2.0F, 3, 2, 4, 0.0F, 0.3F, 0.3F, 0.3F, 1.3F, 0.6F, 0.8F, 1.3F, 0.6F, 0.8F, 0.3F, 0.3F, 0.3F, 0.5F, 0.0F, 0.8F, 1.3F, 1.3F, 1.8F, 1.3F, 1.3F, 1.8F, 0.5F, 0.0F, 0.8F);
      this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[2].addShapeBox(-3.0F, -1.5F, -2.0F, 3, 2, 4, 0.0F, 0.2F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.2F, 0.3F, 0.2F, 0.4F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F);
      this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[3].addShapeBox(-3.0F, -0.5F, -2.0F, 3, 2, 4, 0.0F, 0.2F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.2F, 0.3F, 0.2F, 0.4F, 0.0F, 0.4F, -0.2F, 0.0F, 0.4F, -0.2F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F);
      this.rightArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[4].addShapeBox(-3.0F, 0.5F, -2.0F, 3, 2, 4, 0.0F, 0.2F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.2F, 0.3F, 0.2F, 0.4F, 0.0F, 0.4F, -0.2F, 0.0F, 0.4F, -0.2F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F);
      this.rightArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[5].addShapeBox(-3.0F, 9.5F, -2.0F, 4, 2, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F);
      this.rightArmModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[6].addShapeBox(-3.0F, 7.0F, -2.0F, 4, 3, 4, 0.0F, 0.5F, -0.8F, 0.5F, 0.5F, -0.8F, 0.5F, 0.5F, -0.8F, 0.5F, 0.5F, -0.8F, 0.5F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F);
      this.rightArmModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[7].addShapeBox(-3.0F, 4.9F, -2.0F, 4, 2, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 1.2F, 0.2F, 0.2F, 1.2F, 0.2F, 0.2F, 1.2F, 0.2F, 0.2F, 1.2F, 0.2F);
      this.rightArmModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[8].addShapeBox(-3.0F, 1.4F, -2.0F, 1, 3, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F);
      this.rightArmModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.rightArmModel[9].addShapeBox(-3.5F, 2.9F, -2.0F, 4, 2, 4, 0.0F, 0.2F, 0.2F, 0.4F, 0.2F, -0.8F, 0.4F, 0.2F, -0.8F, 0.4F, 0.2F, 0.2F, 0.4F, 0.2F, 0.2F, 0.4F, 0.2F, -0.8F, 0.4F, 0.2F, -0.8F, 0.4F, 0.2F, 0.2F, 0.4F);
      this.rightArmModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
