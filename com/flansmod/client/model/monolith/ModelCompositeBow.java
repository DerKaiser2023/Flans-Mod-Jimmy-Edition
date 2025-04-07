package com.flansmod.client.model.monolith;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelCompositeBow extends ModelGun {
   int textureX = 32;
   int textureY = 64;

   public ModelCompositeBow() {
      this.gunModel = new ModelRendererTurbo[10];
      this.ammoModel = new ModelRendererTurbo[3];
      this.slideModel = new ModelRendererTurbo[2];
      this.initgunModel_1();
      this.initammoModel_1();
      this.initslideModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 9, 9, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 17, 9, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 25, 9, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 9, 17, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 17, 17, this.textureX, this.textureY);
      this.gunModel[5] = new ModelRendererTurbo(this, 25, 17, this.textureX, this.textureY);
      this.gunModel[6] = new ModelRendererTurbo(this, 9, 25, this.textureX, this.textureY);
      this.gunModel[7] = new ModelRendererTurbo(this, 17, 25, this.textureX, this.textureY);
      this.gunModel[8] = new ModelRendererTurbo(this, 25, 25, this.textureX, this.textureY);
      this.gunModel[9] = new ModelRendererTurbo(this, 9, 33, this.textureX, this.textureY);
      this.gunModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
      this.gunModel[0].func_78793_a(2.0F, -5.0F, 0.0F);
      this.gunModel[0].field_78808_h = -0.4537856F;
      this.gunModel[1].func_78790_a(-1.0F, -3.0F, 0.0F, 1, 3, 1, 0.0F);
      this.gunModel[1].func_78793_a(3.0F, -4.5F, 0.0F);
      this.gunModel[1].field_78808_h = -0.20943952F;
      this.gunModel[2].addShapeBox(-3.0F, -12.0F, 0.0F, 1, 4, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F);
      this.gunModel[2].func_78793_a(5.5F, -3.7F, 0.0F);
      this.gunModel[2].field_78808_h = 0.29670596F;
      this.gunModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
      this.gunModel[3].func_78793_a(1.0F, -2.0F, 0.0F);
      this.gunModel[3].field_78808_h = 0.4537856F;
      this.gunModel[4].func_78790_a(-1.0F, -4.0F, 0.0F, 1, 4, 1, 0.0F);
      this.gunModel[4].func_78793_a(3.7F, -7.5F, 0.0F);
      this.gunModel[4].field_78808_h = 0.13962634F;
      this.gunModel[5].addShapeBox(-3.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F);
      this.gunModel[5].func_78793_a(0.5F, -18.0F, 0.0F);
      this.gunModel[5].field_78808_h = -0.03490659F;
      this.gunModel[6].func_78790_a(-1.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
      this.gunModel[6].func_78793_a(3.2F, 0.2F, 0.0F);
      this.gunModel[6].field_78808_h = 0.20943952F;
      this.gunModel[7].func_78790_a(-1.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
      this.gunModel[7].func_78793_a(3.8F, 3.0F, 0.0F);
      this.gunModel[7].field_78808_h = -0.13962634F;
      this.gunModel[8].addShapeBox(-3.0F, 11.8F, 0.0F, 1, 4, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F);
      this.gunModel[8].func_78793_a(8.5F, -3.7F, 0.0F);
      this.gunModel[8].field_78808_h = -0.29670596F;
      this.gunModel[9].addShapeBox(-3.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F);
      this.gunModel[9].func_78793_a(2.1F, 10.0F, 0.0F);
      this.gunModel[9].field_78808_h = 0.03490659F;
   }

   private void initammoModel_1() {
      this.ammoModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.ammoModel[1] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.ammoModel[2] = new ModelRendererTurbo(this, 1, 9, this.textureX, this.textureY);
      this.ammoModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 8, 1, 1, 0.0F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F);
      this.ammoModel[0].func_78793_a(-4.0F, -2.8F, 0.5F);
      this.ammoModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, -0.4F, -0.2F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -0.2F, 0.0F, -0.4F, -0.2F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -0.2F);
      this.ammoModel[1].func_78793_a(4.0F, -2.8F, 0.5F);
      this.ammoModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -0.45F, 0.0F, -0.4F, -0.45F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -0.45F, 0.0F, -0.4F, -0.45F, 0.0F, -0.4F, 0.0F);
      this.ammoModel[2].func_78793_a(5.0F, -2.8F, 0.5F);
   }

   private void initslideModel_1() {
      this.slideModel[0] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.slideModel[1] = new ModelRendererTurbo(this, 17, 33, this.textureX, this.textureY);
      this.slideModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 16, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -2.3F, 0.0F, -0.3F, 1.7F, 0.0F, -0.3F, 1.7F, 0.0F, -0.3F, -2.3F, 0.0F, -0.3F);
      this.slideModel[0].func_78793_a(-1.5F, -18.0F, 1.0F);
      this.slideModel[0].field_78796_g = 3.1415927F;
      this.slideModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 16, 1, 0.0F, -2.3F, 0.0F, -0.3F, 1.7F, 0.0F, -0.3F, 1.7F, 0.0F, -0.3F, -2.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
      this.slideModel[1].func_78793_a(-1.5F, -2.0F, 1.0F);
      this.slideModel[1].field_78796_g = 3.1415927F;
      this.animationType = EnumAnimationType.END_LOADED;
   }
}
