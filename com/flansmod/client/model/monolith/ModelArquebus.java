package com.flansmod.client.model.monolith;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelArquebus extends ModelGun {
   int textureX = 64;
   int textureY = 64;

   public ModelArquebus() {
      this.gunModel = new ModelRendererTurbo[12];
      this.ammoModel = new ModelRendererTurbo[2];
      this.initgunModel_1();
      this.initammoModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 1, 9, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 33, 9, this.textureX, this.textureY);
      this.gunModel[5] = new ModelRendererTurbo(this, 41, 9, this.textureX, this.textureY);
      this.gunModel[6] = new ModelRendererTurbo(this, 49, 9, this.textureX, this.textureY);
      this.gunModel[7] = new ModelRendererTurbo(this, 57, 9, this.textureX, this.textureY);
      this.gunModel[8] = new ModelRendererTurbo(this, 57, 17, this.textureX, this.textureY);
      this.gunModel[9] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.gunModel[10] = new ModelRendererTurbo(this, 9, 25, this.textureX, this.textureY);
      this.gunModel[11] = new ModelRendererTurbo(this, 17, 25, this.textureX, this.textureY);
      this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 18, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, 0.0F, 0.0F);
      this.gunModel[0].func_78793_a(0.0F, -1.5F, 1.0F);
      this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 11, 2, 2, 0.0F, 0.3F, -5.3F, -0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3F, -5.3F, -0.3F, 0.0F, 4.5F, -0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 4.5F, -0.3F);
      this.gunModel[1].func_78793_a(-14.0F, -2.0F, 1.0F);
      this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 3, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[2].func_78793_a(-3.0F, -2.0F, 1.0F);
      this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 24, 1, 1, 0.0F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F);
      this.gunModel[3].func_78793_a(0.0F, -2.5F, 1.5F);
      this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, 0.2F, 0.2F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.2F, 0.2F);
      this.gunModel[4].func_78793_a(24.0F, -2.5F, 1.5F);
      this.gunModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F);
      this.gunModel[5].func_78793_a(4.0F, -2.6F, 1.0F);
      this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F);
      this.gunModel[6].func_78793_a(16.0F, -2.6F, 1.0F);
      this.gunModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F);
      this.gunModel[7].func_78793_a(16.0F, -1.6F, 0.0F);
      this.gunModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F);
      this.gunModel[8].func_78793_a(16.0F, -1.6F, 3.0F);
      this.gunModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F);
      this.gunModel[9].func_78793_a(16.0F, 1.2F, 3.0F);
      this.gunModel[9].field_78795_f = -0.5235988F;
      this.gunModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F);
      this.gunModel[10].func_78793_a(16.0F, 1.6F, 0.2F);
      this.gunModel[10].field_78795_f = 0.5235988F;
      this.gunModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 1, 19, 1, 0.0F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F);
      this.gunModel[11].func_78793_a(16.0F, 3.6F, 1.5F);
   }

   private void initammoModel_1() {
      this.ammoModel[0] = new ModelRendererTurbo(this, 25, 25, this.textureX, this.textureY);
      this.ammoModel[1] = new ModelRendererTurbo(this, 33, 25, this.textureX, this.textureY);
      this.ammoModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 11, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
      this.ammoModel[0].func_78793_a(0.5F, -3.0F, 0.0F);
      this.ammoModel[0].field_78796_g = -1.5707964F;
      this.ammoModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F);
      this.ammoModel[1].func_78793_a(23.5F, -2.5F, 1.5F);
      this.animationType = EnumAnimationType.END_LOADED;
      this.translateAll(0.0F, -1.0F, -2.0F);
   }
}
