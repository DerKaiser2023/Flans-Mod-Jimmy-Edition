package com.flansmod.client.model.monolith;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelShitBow extends ModelGun {
   int textureX = 64;
   int textureY = 64;

   public ModelShitBow() {
      this.gunModel = new ModelRendererTurbo[5];
      this.ammoModel = new ModelRendererTurbo[3];
      this.slideModel = new ModelRendererTurbo[1];
      this.initgunModel_1();
      this.initammoModel_1();
      this.initslideModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 1, 9, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 9, 9, this.textureX, this.textureY);
      this.gunModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F);
      this.gunModel[0].func_78793_a(1.0F, -5.0F, 0.0F);
      this.gunModel[1].func_78790_a(-1.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
      this.gunModel[1].func_78793_a(2.0F, 1.0F, 0.0F);
      this.gunModel[1].field_78808_h = -0.17453294F;
      this.gunModel[2].addShapeBox(-1.0F, 5.0F, 0.0F, 1, 7, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F);
      this.gunModel[2].func_78793_a(2.0F, 1.0F, 0.0F);
      this.gunModel[2].field_78808_h = -0.17453294F;
      this.gunModel[3].func_78790_a(-1.0F, -5.0F, 0.0F, 1, 5, 1, 0.0F);
      this.gunModel[3].func_78793_a(2.0F, -5.0F, 0.0F);
      this.gunModel[3].field_78808_h = 0.17453294F;
      this.gunModel[4].addShapeBox(-3.0F, -12.0F, 0.0F, 1, 7, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F);
      this.gunModel[4].func_78793_a(2.0F, -5.0F, 0.0F);
      this.gunModel[4].field_78808_h = 0.17453294F;
   }

   private void initammoModel_1() {
      this.ammoModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.ammoModel[1] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.ammoModel[2] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.ammoModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 8, 1, 1, 0.0F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F);
      this.ammoModel[0].func_78793_a(-3.0F, -2.8F, 0.5F);
      this.ammoModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, -0.4F, -0.2F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -0.2F, 0.0F, -0.4F, -0.2F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -0.2F);
      this.ammoModel[1].func_78793_a(5.0F, -2.8F, 0.5F);
      this.ammoModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -0.45F, 0.0F, -0.4F, -0.45F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -0.45F, 0.0F, -0.4F, -0.45F, 0.0F, -0.4F, 0.0F);
      this.ammoModel[2].func_78793_a(6.0F, -2.8F, 0.5F);
   }

   private void initslideModel_1() {
      this.slideModel[0] = new ModelRendererTurbo(this, 17, 9, this.textureX, this.textureY);
      this.slideModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 28, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, 0.7F, 0.0F, -0.3F, -1.3F, 0.0F, -0.3F, -1.3F, 0.0F, -0.3F, 0.7F, 0.0F, -0.3F);
      this.slideModel[0].func_78793_a(-2.0F, -16.0F, 1.0F);
      this.slideModel[0].field_78796_g = 3.1415927F;
      this.animationType = EnumAnimationType.END_LOADED;
   }
}
