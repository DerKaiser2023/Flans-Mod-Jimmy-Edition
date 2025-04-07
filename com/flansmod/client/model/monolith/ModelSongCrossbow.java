package com.flansmod.client.model.monolith;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelSongCrossbow extends ModelGun {
   int textureX = 64;
   int textureY = 64;

   public ModelSongCrossbow() {
      this.gunModel = new ModelRendererTurbo[20];
      this.ammoModel = new ModelRendererTurbo[3];
      this.initgunModel_1();
      this.initammoModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 1, 9, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 25, 9, this.textureX, this.textureY);
      this.gunModel[5] = new ModelRendererTurbo(this, 49, 9, this.textureX, this.textureY);
      this.gunModel[6] = new ModelRendererTurbo(this, 41, 9, this.textureX, this.textureY);
      this.gunModel[7] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.gunModel[8] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.gunModel[9] = new ModelRendererTurbo(this, 17, 9, this.textureX, this.textureY);
      this.gunModel[10] = new ModelRendererTurbo(this, 9, 17, this.textureX, this.textureY);
      this.gunModel[11] = new ModelRendererTurbo(this, 33, 17, this.textureX, this.textureY);
      this.gunModel[12] = new ModelRendererTurbo(this, 25, 17, this.textureX, this.textureY);
      this.gunModel[13] = new ModelRendererTurbo(this, 49, 17, this.textureX, this.textureY);
      this.gunModel[14] = new ModelRendererTurbo(this, 1, 33, this.textureX, this.textureY);
      this.gunModel[15] = new ModelRendererTurbo(this, 17, 33, this.textureX, this.textureY);
      this.gunModel[16] = new ModelRendererTurbo(this, 1, 41, this.textureX, this.textureY);
      this.gunModel[17] = new ModelRendererTurbo(this, 1, 49, this.textureX, this.textureY);
      this.gunModel[18] = new ModelRendererTurbo(this, 49, 41, this.textureX, this.textureY);
      this.gunModel[19] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 9, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
      this.gunModel[0].func_78793_a(-2.0F, -4.0F, -1.0F);
      this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 12, 2, 2, 0.0F, 4.0F, -0.3F, -0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 4.0F, -0.3F, -0.3F, 4.0F, -1.0F, -0.3F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -1.0F, -0.3F);
      this.gunModel[1].func_78793_a(-14.0F, -4.0F, -1.0F);
      this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 7, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F);
      this.gunModel[2].func_78793_a(7.0F, -4.0F, -1.0F);
      this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F);
      this.gunModel[3].func_78793_a(0.2F, -2.5F, -0.5F);
      this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F);
      this.gunModel[4].func_78793_a(-5.8F, -1.8F, -0.5F);
      this.gunModel[4].field_78808_h = 0.05235988F;
      this.gunModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F);
      this.gunModel[5].func_78793_a(-1.8F, -4.6F, -0.5F);
      this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[6].func_78793_a(12.0F, -3.5F, 0.0F);
      this.gunModel[7].addShapeBox(0.0F, 0.0F, -3.0F, 1, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[7].func_78793_a(12.0F, -3.5F, 0.0F);
      this.gunModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[8].func_78793_a(12.0F, -3.5F, 2.7F);
      this.gunModel[8].field_78796_g = 0.05235988F;
      this.gunModel[9].addShapeBox(0.0F, 0.0F, -5.0F, 1, 1, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[9].func_78793_a(12.0F, -3.5F, -2.7F);
      this.gunModel[9].field_78796_g = -0.05235988F;
      this.gunModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[10].func_78793_a(11.8F, -3.5F, 7.3F);
      this.gunModel[10].field_78796_g = 0.34906584F;
      this.gunModel[11].addShapeBox(0.0F, 0.0F, -8.0F, 1, 1, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[11].func_78793_a(11.8F, -3.5F, -7.3F);
      this.gunModel[11].field_78796_g = -0.34906584F;
      this.gunModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
      this.gunModel[12].func_78793_a(7.5F, -3.5F, -2.0F);
      this.gunModel[13].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F, 0.2F, -0.1F, -0.2F, 0.7F, 0.2F, -0.2F, 0.7F, 0.2F, -0.2F, 0.2F, -0.1F, -0.2F, 0.2F, -0.1F, -0.2F, 0.7F, 0.2F, -0.2F, 0.7F, 0.2F, -0.2F, 0.2F, -0.1F, -0.2F);
      this.gunModel[13].func_78793_a(7.5F, -3.5F, -2.0F);
      this.gunModel[14].addShapeBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F, 0.5F, 0.2F, -0.2F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, -0.4F, 0.5F, 0.2F, -0.2F, 0.5F, 0.2F, -0.2F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, -0.4F, 0.5F, 0.2F, -0.2F);
      this.gunModel[14].func_78793_a(13.3F, -3.5F, -1.4F);
      this.gunModel[14].field_78796_g = -0.20943952F;
      this.gunModel[15].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F, 0.2F, -0.1F, -0.2F, 0.7F, 0.2F, -0.2F, 0.7F, 0.2F, -0.2F, 0.2F, -0.1F, -0.2F, 0.2F, -0.1F, -0.2F, 0.7F, 0.2F, -0.2F, 0.7F, 0.2F, -0.2F, 0.2F, -0.1F, -0.2F);
      this.gunModel[15].func_78793_a(7.5F, -3.5F, 1.0F);
      this.gunModel[16].addShapeBox(0.0F, 0.0F, 0.0F, 19, 1, 1, 0.0F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F);
      this.gunModel[16].func_78793_a(-2.0F, -4.8F, -0.5F);
      this.gunModel[16].field_78796_g = 0.89011794F;
      this.gunModel[16].field_78808_h = -0.06981317F;
      this.gunModel[17].addShapeBox(0.0F, 0.0F, 0.0F, 19, 1, 1, 0.0F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F);
      this.gunModel[17].func_78793_a(-2.6F, -4.8F, -0.1F);
      this.gunModel[17].field_78796_g = -0.89011794F;
      this.gunModel[17].field_78808_h = -0.06981317F;
      this.gunModel[18].addShapeBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F, 0.5F, 0.2F, -0.2F, 0.5F, -0.2F, -0.4F, 0.5F, -0.2F, 0.0F, 0.5F, 0.2F, -0.2F, 0.5F, 0.2F, -0.2F, 0.5F, -0.2F, -0.4F, 0.5F, -0.2F, 0.0F, 0.5F, 0.2F, -0.2F);
      this.gunModel[18].func_78793_a(13.3F, -3.5F, 0.4F);
      this.gunModel[18].field_78796_g = 0.20943952F;
      this.gunModel[19].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F);
      this.gunModel[19].func_78793_a(17.2F, -3.5F, -2.0F);
   }

   private void initammoModel_1() {
      this.ammoModel[0] = new ModelRendererTurbo(this, 33, 33, this.textureX, this.textureY);
      this.ammoModel[1] = new ModelRendererTurbo(this, 57, 9, this.textureX, this.textureY);
      this.ammoModel[2] = new ModelRendererTurbo(this, 9, 17, this.textureX, this.textureY);
      this.ammoModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 14, 1, 1, 0.0F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F);
      this.ammoModel[0].func_78793_a(-2.0F, -4.8F, -0.5F);
      this.ammoModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, -0.4F, -0.2F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -0.2F, 0.0F, -0.4F, -0.2F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -0.2F);
      this.ammoModel[1].func_78793_a(12.0F, -4.8F, -0.5F);
      this.ammoModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -0.45F, 0.0F, -0.4F, -0.45F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -0.45F, 0.0F, -0.4F, -0.45F, 0.0F, -0.4F, 0.0F);
      this.ammoModel[2].func_78793_a(13.0F, -4.8F, -0.5F);
      this.animationType = EnumAnimationType.CROSSBOW;
   }
}
