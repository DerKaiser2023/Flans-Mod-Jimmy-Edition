package com.flansmod.client.model.monolith;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelOldChukonu extends ModelGun {
   int textureX = 64;
   int textureY = 64;

   public ModelOldChukonu() {
      this.gunModel = new ModelRendererTurbo[11];
      this.ammoModel = new ModelRendererTurbo[4];
      this.slideModel = new ModelRendererTurbo[1];
      this.initgunModel_1();
      this.initammoModel_1();
      this.initslideModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 1, 9, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.gunModel[5] = new ModelRendererTurbo(this, 25, 9, this.textureX, this.textureY);
      this.gunModel[6] = new ModelRendererTurbo(this, 25, 9, this.textureX, this.textureY);
      this.gunModel[7] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.gunModel[8] = new ModelRendererTurbo(this, 41, 9, this.textureX, this.textureY);
      this.gunModel[9] = new ModelRendererTurbo(this, 49, 9, this.textureX, this.textureY);
      this.gunModel[10] = new ModelRendererTurbo(this, 57, 9, this.textureX, this.textureY);
      this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 10, 2, 3, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F);
      this.gunModel[0].func_78793_a(-8.0F, -2.0F, -1.5F);
      this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 7, 1, 3, 0.0F, -1.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, -1.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[1].func_78793_a(-4.8F, -3.0F, -1.5F);
      this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 7, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[2].func_78793_a(-4.8F, -2.0F, -1.5F);
      this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, -0.2F, 0.0F, 0.3F, -0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F);
      this.gunModel[3].func_78793_a(0.5F, -1.0F, -0.5F);
      this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, -0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F);
      this.gunModel[4].func_78793_a(0.1F, 1.0F, -0.5F);
      this.gunModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, -0.5F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, -0.5F, 0.0F, 0.3F);
      this.gunModel[5].func_78793_a(0.1F, 2.0F, -0.5F);
      this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 7, 0.0F, -0.3F, -0.2F, -0.4F, -0.3F, -0.2F, -0.4F, -1.3F, -0.2F, -0.4F, 0.7F, -0.2F, -0.4F, -0.3F, -0.2F, -0.4F, -0.3F, -0.2F, -0.4F, -1.3F, -0.2F, -0.4F, 0.7F, -0.2F, -0.4F);
      this.gunModel[6].func_78793_a(1.5F, -1.2F, 0.5F);
      this.gunModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 7, 0.0F, 0.7F, -0.2F, -0.4F, -1.3F, -0.2F, -0.4F, -0.3F, -0.2F, -0.4F, -0.3F, -0.2F, -0.4F, 0.7F, -0.2F, -0.4F, -1.3F, -0.2F, -0.4F, -0.3F, -0.2F, -0.4F, -0.3F, -0.2F, -0.4F);
      this.gunModel[7].func_78793_a(1.5F, -1.2F, -7.5F);
      this.gunModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F);
      this.gunModel[8].func_78793_a(1.5F, -1.2F, 0.0F);
      this.gunModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F);
      this.gunModel[9].func_78793_a(1.5F, -1.2F, -2.0F);
      this.gunModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.2F, -0.5F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, -0.5F, 0.3F, 0.2F, 0.0F, 0.3F, -0.5F, 0.0F, 0.3F, -0.5F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F);
      this.gunModel[10].func_78793_a(1.1F, 2.0F, -0.5F);
   }

   private void initammoModel_1() {
      this.ammoModel[0] = new ModelRendererTurbo(this, 41, 17, this.textureX, this.textureY);
      this.ammoModel[1] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.ammoModel[2] = new ModelRendererTurbo(this, 49, 25, this.textureX, this.textureY);
      this.ammoModel[3] = new ModelRendererTurbo(this, 17, 17, this.textureX, this.textureY);
      this.ammoModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F);
      this.ammoModel[0].func_78793_a(-3.8F, -3.0F, -0.5F);
      this.ammoModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.2F, -0.3F, -0.3F, -0.2F, -0.49F, -0.49F, -0.2F, -0.49F, -0.49F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.49F, -0.49F, -0.2F, -0.49F, -0.49F, -0.2F, -0.3F, -0.3F);
      this.ammoModel[1].func_78793_a(0.8F, -3.0F, -0.5F);
      this.ammoModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F);
      this.ammoModel[2].func_78793_a(-3.8F, -3.2F, 0.1F);
      this.ammoModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.2F, -0.3F, -0.3F, -0.2F, -0.49F, -0.49F, -0.2F, -0.49F, -0.49F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.49F, -0.49F, -0.2F, -0.49F, -0.49F, -0.2F, -0.3F, -0.3F);
      this.ammoModel[3].func_78793_a(0.8F, -3.2F, 0.1F);
   }

   private void initslideModel_1() {
      this.slideModel[0] = new ModelRendererTurbo(this, 17, 25, this.textureX, this.textureY);
      this.slideModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 11, 1, 2, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F);
      this.slideModel[0].func_78793_a(-10.0F, -1.5F, -1.0F);
      this.gunSlideDistance = 1.0F;
      this.gunSlideDistance = 0.5F;
      this.animationType = EnumAnimationType.RIFLE;
      this.numBulletsInReloadAnimation = 5.0F;
      this.tiltGunTime = 0.279F;
      this.unloadClipTime = 0.0F;
      this.loadClipTime = 0.558F;
      this.untiltGunTime = 0.163F;
   }
}
