package com.flansmod.client.model.monolith;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelHandCannon extends ModelGun {
   int textureX = 64;
   int textureY = 64;

   public ModelHandCannon() {
      this.gunModel = new ModelRendererTurbo[4];
      this.ammoModel = new ModelRendererTurbo[2];
      this.initgunModel_1();
      this.initammoModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 33, 9, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 4, 17, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 33, 9, this.textureX, this.textureY);
      this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 12, 1, 1, 0.0F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F);
      this.gunModel[0].func_78793_a(1.0F, -2.5F, 1.5F);
      this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, 0.2F, 0.2F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.2F, 0.2F);
      this.gunModel[1].func_78793_a(13.0F, -2.5F, 1.5F);
      this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 12, 1, 1, 0.0F, 2.0F, -0.3F, -0.3F, 2.0F, -0.3F, -0.3F, 2.0F, -0.3F, -0.3F, 2.0F, -0.3F, -0.3F, 2.0F, -0.3F, -0.3F, 2.0F, -0.3F, -0.3F, 2.0F, -0.3F, -0.3F, 2.0F, -0.3F, -0.3F);
      this.gunModel[2].func_78793_a(-14.0F, -2.5F, 1.5F);
      this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, -0.3F, -0.3F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, -0.3F, -0.3F);
      this.gunModel[3].func_78793_a(0.0F, -2.5F, 1.5F);
   }

   private void initammoModel_1() {
      this.ammoModel[0] = new ModelRendererTurbo(this, 25, 25, this.textureX, this.textureY);
      this.ammoModel[1] = new ModelRendererTurbo(this, 33, 25, this.textureX, this.textureY);
      this.ammoModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 11, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
      this.ammoModel[0].func_78793_a(0.5F, -3.0F, 0.0F);
      this.ammoModel[0].field_78796_g = -1.5707964F;
      this.ammoModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F);
      this.ammoModel[1].func_78793_a(12.5F, -2.5F, 1.5F);
      this.animationType = EnumAnimationType.END_LOADED;
   }
}
