package com.flansmod.client.model.yoshi;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelPollaxe extends ModelGun {
   int textureX = 64;
   int textureY = 64;

   public ModelPollaxe() {
      this.gunModel = new ModelRendererTurbo[12];
      this.initgunModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 9, 1, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.gunModel[5] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.gunModel[6] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.gunModel[7] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
      this.gunModel[8] = new ModelRendererTurbo(this, 17, 9, this.textureX, this.textureY);
      this.gunModel[9] = new ModelRendererTurbo(this, 25, 9, this.textureX, this.textureY);
      this.gunModel[10] = new ModelRendererTurbo(this, 41, 9, this.textureX, this.textureY);
      this.gunModel[11] = new ModelRendererTurbo(this, 57, 9, this.textureX, this.textureY);
      this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 40, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[0].func_78793_a(0.0F, -23.0F, 0.0F);
      this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 15, 1, 0.0F, -0.1F, 0.0F, 0.1F, -0.1F, 0.0F, 0.1F, -0.1F, 0.0F, 0.1F, -0.1F, 0.0F, 0.1F, -0.1F, 0.0F, 0.1F, -0.1F, 0.0F, 0.1F, -0.1F, 0.0F, 0.1F, -0.1F, 0.0F, 0.1F);
      this.gunModel[1].func_78793_a(0.0F, -23.0F, 0.0F);
      this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.1F, 0.0F, 0.1F, -0.1F, 0.0F, 0.1F, -0.1F, 0.0F, 0.1F, -0.1F, 0.0F, 0.1F, -0.1F, 0.0F, 0.1F, -0.1F, 0.0F, 0.1F, -0.1F, 0.0F, 0.1F, -0.1F, 0.0F, 0.1F);
      this.gunModel[2].func_78793_a(0.0F, -24.0F, 0.0F);
      this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.1F, 0.0F, -0.3F, 0.3F, 0.0F, -0.1F, 0.3F, 0.0F, -0.1F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, 0.3F, 0.0F, -0.2F, 0.3F, 0.0F, -0.2F, -0.1F, 0.0F, -0.3F);
      this.gunModel[3].func_78793_a(-1.2F, -24.0F, 0.0F);
      this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F, -0.5F, 0.0F, -0.1F, 0.3F, 0.0F, -0.1F, 0.3F, 0.0F, -0.1F, -0.5F, 0.0F, -0.1F, -0.5F, 0.0F, -0.1F, 0.3F, 0.0F, -0.1F, 0.3F, 0.0F, -0.1F, -0.5F, 0.0F, -0.1F);
      this.gunModel[4].func_78793_a(-2.2F, -25.0F, -0.5F);
      this.gunModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.3F, 0.0F, -0.1F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, 0.3F, 0.0F, -0.1F, 0.3F, 0.0F, -0.1F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, 0.3F, 0.0F, -0.1F);
      this.gunModel[5].func_78793_a(1.2F, -24.0F, 0.0F);
      this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.1F, 0.0F, -0.3F, -0.1F, 1.6F, -0.3F, -0.1F, 1.6F, -0.3F, 0.1F, 0.0F, -0.3F, 0.1F, 0.0F, -0.3F, -0.1F, 1.2F, -0.3F, -0.1F, 1.2F, -0.3F, 0.1F, 0.0F, -0.3F);
      this.gunModel[6].func_78793_a(2.2F, -24.0F, 0.0F);
      this.gunModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.1F, 1.6F, -0.3F, -0.1F, 3.4F, -0.3F, -0.1F, 3.4F, -0.3F, 0.1F, 1.6F, -0.3F, 0.1F, 1.2F, -0.3F, -0.1F, 2.8F, -0.3F, -0.1F, 2.8F, -0.3F, 0.1F, 1.2F, -0.3F);
      this.gunModel[7].func_78793_a(3.2F, -24.0F, 0.0F);
      this.gunModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.1F, 3.4F, -0.3F, -0.5F, 4.0F, -0.5F, -0.5F, 4.0F, -0.5F, 0.1F, 3.4F, -0.3F, 0.1F, 2.8F, -0.3F, -0.6F, 3.7F, -0.5F, -0.6F, 3.7F, -0.5F, 0.1F, 2.8F, -0.3F);
      this.gunModel[8].func_78793_a(4.2F, -24.0F, 0.0F);
      this.gunModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F, -0.5F, -0.4F, -1.9428903E-16F, -0.5F, -0.4F, 0.0F, -0.1F, -0.4F, 0.0F, -0.5F, -2.7755576E-17F, -8.326673E-17F, -0.5F, -0.6F, 1.0269563E-15F, -0.5F, -0.6F, 2.7755576E-17F, -0.5F, -0.3F, 0.1F, -0.1F, -0.6F, 0.1F);
      this.gunModel[9].func_78793_a(0.0F, -24.0F, -3.0F);
      this.gunModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F, -0.5F, -2.7755576E-17F, -8.326673E-17F, -0.1F, -0.4F, 0.0F, -0.5F, -0.4F, 0.0F, -0.5F, -0.4F, -1.9428903E-16F, -0.1F, -0.6F, 0.1F, -0.5F, -0.3F, 0.1F, -0.5F, -0.6F, 2.7755576E-17F, -0.5F, -0.6F, 1.0269563E-15F);
      this.gunModel[10].func_78793_a(0.0F, -24.0F, 1.0F);
      this.gunModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F);
      this.gunModel[11].func_78793_a(0.0F, -29.0F, 0.0F);
   }
}
