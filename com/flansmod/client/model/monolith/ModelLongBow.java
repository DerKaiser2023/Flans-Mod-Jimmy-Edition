package com.flansmod.client.model.monolith;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelLongBow extends ModelGun {
   int textureX = 64;
   int textureY = 64;

   public ModelLongBow() {
      this.gunModel = new ModelRendererTurbo[6];
      this.ammoModel = new ModelRendererTurbo[3];
      this.slideModel = new ModelRendererTurbo[2];
      this.initgunModel_1();
      this.initammoModel_1();
      this.initslideModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 1, 9, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 9, 9, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 17, 9, this.textureX, this.textureY);
      this.gunModel[5] = new ModelRendererTurbo(this, 33, 9, this.textureX, this.textureY);
      this.gunModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 1, 9, 1, 0.0F);
      this.gunModel[0].func_78793_a(0.0F, -10.0F, 0.0F);
      this.gunModel[0].field_78808_h = 0.12217305F;
      this.gunModel[1].func_78790_a(-1.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
      this.gunModel[1].func_78793_a(-0.2F, 5.7F, 0.0F);
      this.gunModel[1].field_78808_h = -0.5934119F;
      this.gunModel[2].addShapeBox(-1.0F, 5.0F, 0.0F, 1, 7, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F);
      this.gunModel[2].func_78793_a(-2.5F, 4.5F, 0.0F);
      this.gunModel[2].field_78808_h = -0.08726646F;
      this.gunModel[3].func_78790_a(-1.0F, -12.0F, 0.0F, 1, 12, 1, 0.0F);
      this.gunModel[3].func_78793_a(1.0F, -10.0F, 0.0F);
      this.gunModel[3].field_78808_h = 0.61086524F;
      this.gunModel[4].addShapeBox(-3.0F, -18.0F, 0.0F, 1, 5, 1, 0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F);
      this.gunModel[4].func_78793_a(1.6F, -9.0F, 0.0F);
      this.gunModel[4].field_78808_h = 0.61086524F;
      this.gunModel[5].func_78790_a(-1.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
      this.gunModel[5].func_78793_a(2.0F, -1.0F, 0.0F);
      this.gunModel[5].field_78808_h = -0.31415927F;
   }

   private void initammoModel_1() {
      this.ammoModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.ammoModel[1] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.ammoModel[2] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.ammoModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 11, 1, 1, 0.0F, 2.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 2.0F, -0.3F, -0.3F, 2.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 2.0F, -0.3F, -0.3F);
      this.ammoModel[0].func_78793_a(-9.0F, -2.8F, 0.5F);
      this.ammoModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, -0.4F, -0.2F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -0.2F, 0.0F, -0.4F, -0.2F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -0.2F);
      this.ammoModel[1].func_78793_a(2.0F, -2.8F, 0.5F);
      this.ammoModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -0.45F, 0.0F, -0.4F, -0.45F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -0.45F, 0.0F, -0.4F, -0.45F, 0.0F, -0.4F, 0.0F);
      this.ammoModel[2].func_78793_a(3.0F, -2.8F, 0.5F);
   }

   private void initslideModel_1() {
      this.slideModel[0] = new ModelRendererTurbo(this, 25, 9, this.textureX, this.textureY);
      this.slideModel[1] = new ModelRendererTurbo(this, 25, 9, this.textureX, this.textureY);
      this.slideModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 20, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -3.3F, 0.0F, -0.3F, 2.7F, 0.0F, -0.3F, 2.7F, 0.0F, -0.3F, -3.3F, 0.0F, -0.3F);
      this.slideModel[0].func_78793_a(-7.5F, -23.0F, 1.0F);
      this.slideModel[0].field_78796_g = 3.1415927F;
      this.slideModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 19, 1, 0.0F, -3.3F, 0.0F, -0.3F, 2.7F, 0.0F, -0.3F, 2.7F, 0.0F, -0.3F, -3.3F, 0.0F, -0.3F, 2.7F, 0.0F, -0.3F, -3.3F, 0.0F, -0.3F, -3.3F, 0.0F, -0.3F, 2.7F, 0.0F, -0.3F);
      this.slideModel[1].func_78793_a(-7.5F, -3.0F, 1.0F);
      this.slideModel[1].field_78796_g = 3.1415927F;
      this.animationType = EnumAnimationType.END_LOADED;
   }
}
