package com.flansmod.client.model.monolith;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelArquebusMatchlock extends ModelGun {
   int textureX = 64;
   int textureY = 64;

   public ModelArquebusMatchlock() {
      this.gunModel = new ModelRendererTurbo[21];
      this.ammoModel = new ModelRendererTurbo[1];
      this.initgunModel_1();
      this.initammoModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 1, 9, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
      this.gunModel[5] = new ModelRendererTurbo(this, 33, 9, this.textureX, this.textureY);
      this.gunModel[6] = new ModelRendererTurbo(this, 49, 9, this.textureX, this.textureY);
      this.gunModel[7] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.gunModel[8] = new ModelRendererTurbo(this, 25, 25, this.textureX, this.textureY);
      this.gunModel[9] = new ModelRendererTurbo(this, 49, 17, this.textureX, this.textureY);
      this.gunModel[10] = new ModelRendererTurbo(this, 1, 33, this.textureX, this.textureY);
      this.gunModel[11] = new ModelRendererTurbo(this, 57, 17, this.textureX, this.textureY);
      this.gunModel[12] = new ModelRendererTurbo(this, 49, 25, this.textureX, this.textureY);
      this.gunModel[13] = new ModelRendererTurbo(this, 57, 25, this.textureX, this.textureY);
      this.gunModel[14] = new ModelRendererTurbo(this, 25, 33, this.textureX, this.textureY);
      this.gunModel[15] = new ModelRendererTurbo(this, 33, 33, this.textureX, this.textureY);
      this.gunModel[16] = new ModelRendererTurbo(this, 41, 33, this.textureX, this.textureY);
      this.gunModel[17] = new ModelRendererTurbo(this, 1, 41, this.textureX, this.textureY);
      this.gunModel[18] = new ModelRendererTurbo(this, 9, 41, this.textureX, this.textureY);
      this.gunModel[19] = new ModelRendererTurbo(this, 17, 41, this.textureX, this.textureY);
      this.gunModel[20] = new ModelRendererTurbo(this, 25, 41, this.textureX, this.textureY);
      this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 11, 1, 2, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, 0.0F, 0.0F);
      this.gunModel[0].func_78793_a(5.0F, -3.5F, -1.0F);
      this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 8, 2, 2, 0.0F, 0.3F, -3.3F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3F, -3.3F, 0.2F, 0.0F, 4.5F, 0.2F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 4.5F, 0.2F);
      this.gunModel[1].func_78793_a(-14.0F, -4.0F, -1.0F);
      this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 7, 1, 2, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[2].func_78793_a(-2.0F, -3.0F, -1.0F);
      this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 20, 1, 1, 0.0F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F);
      this.gunModel[3].func_78793_a(2.0F, -4.9F, -0.5F);
      this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.0F, 0.0F);
      this.gunModel[4].func_78793_a(22.0F, -4.9F, -0.5F);
      this.gunModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F);
      this.gunModel[5].func_78793_a(-6.0F, -4.0F, -1.0F);
      this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 2, 0.0F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, -0.4F, 0.0F, 0.5F, -0.4F, 0.0F, 0.5F, -0.2F, 0.0F, -0.8F, -0.3F, 0.0F, -1.0F, -0.5F, 0.0F, -1.0F, -0.5F, 0.0F, -0.8F, -0.3F);
      this.gunModel[6].func_78793_a(16.0F, -3.5F, -1.0F);
      this.gunModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 8, 1, 1, 0.0F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F);
      this.gunModel[7].func_78793_a(16.0F, -3.8F, -0.5F);
      this.gunModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 7, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[8].func_78793_a(-3.0F, -3.5F, -1.2F);
      this.gunModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F);
      this.gunModel[9].func_78793_a(0.2F, -2.5F, -0.5F);
      this.gunModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F);
      this.gunModel[10].func_78793_a(-5.8F, -4.440892E-16F, -0.5F);
      this.gunModel[10].field_78808_h = 0.27925268F;
      this.gunModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
      this.gunModel[11].func_78793_a(3.0F, -4.3F, -1.9F);
      this.gunModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F);
      this.gunModel[12].func_78793_a(3.5F, -5.6F, -1.9F);
      this.gunModel[13].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F);
      this.gunModel[13].func_78793_a(3.2F, -4.7F, -1.9F);
      this.gunModel[14].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F);
      this.gunModel[14].func_78793_a(3.0F, -6.4F, -1.9F);
      this.gunModel[15].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F);
      this.gunModel[15].func_78793_a(2.7F, -6.4F, -1.4F);
      this.gunModel[16].addShapeBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.1F, 0.4F, 0.0F, 0.1F, 0.4F, 0.0F, 0.1F, 0.4F, 0.0F, 0.1F, 0.4F);
      this.gunModel[16].func_78793_a(-2.0F, -4.9F, -0.5F);
      this.gunModel[17].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F);
      this.gunModel[17].func_78793_a(-1.5F, -5.6F, -1.4F);
      this.gunModel[18].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F);
      this.gunModel[18].func_78793_a(2.7F, -6.2F, -1.2F);
      this.gunModel[19].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F);
      this.gunModel[19].func_78793_a(4.5F, -6.2F, -1.2F);
      this.gunModel[19].field_78796_g = -0.54105204F;
      this.gunModel[19].field_78808_h = -0.7679449F;
      this.gunModel[20].addShapeBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F);
      this.gunModel[20].func_78793_a(5.0F, -5.0F, -1.7F);
      this.gunModel[20].field_78796_g = -0.27925268F;
   }

   private void initammoModel_1() {
      this.ammoModel[0] = new ModelRendererTurbo(this, 25, 9, this.textureX, this.textureY);
      this.ammoModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F);
      this.ammoModel[0].func_78793_a(23.0F, -4.8F, -0.5F);
      this.animationType = EnumAnimationType.END_LOADED;
   }
}
