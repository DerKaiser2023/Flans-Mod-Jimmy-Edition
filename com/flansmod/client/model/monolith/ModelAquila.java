package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelAquila extends ModelGun {
   int textureX = 32;
   int textureY = 64;

   public ModelAquila() {
      this.gunModel = new ModelRendererTurbo[19];
      this.initgunModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 9, 49, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 17, 9, this.textureX, this.textureY);
      this.gunModel[5] = new ModelRendererTurbo(this, 25, 9, this.textureX, this.textureY);
      this.gunModel[6] = new ModelRendererTurbo(this, 17, 17, this.textureX, this.textureY);
      this.gunModel[7] = new ModelRendererTurbo(this, 25, 17, this.textureX, this.textureY);
      this.gunModel[8] = new ModelRendererTurbo(this, 17, 25, this.textureX, this.textureY);
      this.gunModel[9] = new ModelRendererTurbo(this, 25, 25, this.textureX, this.textureY);
      this.gunModel[10] = new ModelRendererTurbo(this, 17, 33, this.textureX, this.textureY);
      this.gunModel[11] = new ModelRendererTurbo(this, 25, 33, this.textureX, this.textureY);
      this.gunModel[12] = new ModelRendererTurbo(this, 17, 41, this.textureX, this.textureY);
      this.gunModel[13] = new ModelRendererTurbo(this, 25, 41, this.textureX, this.textureY);
      this.gunModel[14] = new ModelRendererTurbo(this, 25, 49, this.textureX, this.textureY);
      this.gunModel[15] = new ModelRendererTurbo(this, 1, 57, this.textureX, this.textureY);
      this.gunModel[16] = new ModelRendererTurbo(this, 25, 57, this.textureX, this.textureY);
      this.gunModel[17] = new ModelRendererTurbo(this, 11, 0, this.textureX, this.textureY);
      this.gunModel[18] = new ModelRendererTurbo(this, 4, 18, this.textureX, this.textureY);
      this.gunModel[0].addShapeBox(0.0F, 0.0F, -1.0F, 2, 13, 2, 0.0F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 37.0F, -0.25F, -0.25F, 37.0F, -0.25F, -0.25F, 37.0F, -0.25F, -0.25F, 37.0F, -0.25F);
      this.gunModel[0].func_78793_a(0.0F, -28.0F, 0.0F);
      this.gunModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 2, 2, 6, 0.0F);
      this.gunModel[1].func_78793_a(0.0F, -29.0F, -3.0F);
      this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F);
      this.gunModel[2].func_78793_a(0.5F, -31.0F, -1.0F);
      this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F);
      this.gunModel[3].func_78793_a(0.5F, -31.0F, 0.0F);
      this.gunModel[4].func_78790_a(0.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F);
      this.gunModel[4].func_78793_a(0.5F, -34.0F, -1.0F);
      this.gunModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F, 0.0F, 0.5F, -0.5F, 0.0F, 0.5F, -0.5F, 0.0F, 0.5F, -0.5F, 0.0F, 0.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[5].func_78793_a(0.5F, -35.0F, -1.0F);
      this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F, 0.0F, 0.75F, -1.0F, 0.0F, 0.75F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -1.0F, 0.0F, -0.5F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[6].func_78793_a(0.5F, -34.0F, -3.0F);
      this.gunModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 1, 4, 2, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 1.5F, -1.0F, 0.0F, 1.5F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F);
      this.gunModel[7].func_78793_a(0.5F, -34.0F, -5.0F);
      this.gunModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F, 0.0F, 1.5F, 1.0F, 0.0F, 1.5F, 1.0F, 0.0F, 0.75F, 0.0F, 0.0F, 0.75F, 0.0F, 0.0F, -1.1F, 0.7F, 0.0F, -1.1F, 0.7F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F);
      this.gunModel[8].func_78793_a(0.5F, -34.0F, -3.0F);
      this.gunModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 1.5F, -1.0F, 0.0F, 1.5F, -1.0F, 0.0F, -1.25F, -1.0F, 0.0F, -1.25F, -1.0F, 0.0F, -2.5F, 0.0F, 0.0F, -2.5F, 0.0F);
      this.gunModel[9].func_78793_a(0.5F, -32.0F, -5.0F);
      this.gunModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.75F, -1.0F, 0.0F, 0.75F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -1.0F, 0.0F, -0.5F, -1.0F);
      this.gunModel[10].func_78793_a(0.5F, -34.0F, 1.0F);
      this.gunModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F, 0.0F, 0.75F, 0.0F, 0.0F, 0.75F, 0.0F, 0.0F, 1.5F, 1.0F, 0.0F, 1.5F, 1.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.1F, 0.7F, 0.0F, -1.1F, 0.7F);
      this.gunModel[11].func_78793_a(0.5F, -34.0F, 2.0F);
      this.gunModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 1, 4, 2, 0.0F, 0.0F, 1.5F, -1.0F, 0.0F, 1.5F, -1.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[12].func_78793_a(0.5F, -34.0F, 3.0F);
      this.gunModel[13].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F, 0.0F, 1.5F, -1.0F, 0.0F, 1.5F, -1.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.5F, 0.0F, 0.0F, -2.5F, 0.0F, 0.0F, -1.25F, -1.0F, 0.0F, -1.25F, -1.0F);
      this.gunModel[13].func_78793_a(0.5F, -32.0F, 3.0F);
      this.gunModel[14].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, -0.6F, -0.25F, 0.0F, -0.6F, -0.25F, 0.0F, -0.6F, -0.25F, 0.0F, -0.6F, -0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[14].func_78793_a(0.5F, -36.5F, -0.5F);
      this.gunModel[15].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F, 0.0F, -0.6F, 0.25F, 0.0F, -0.6F, 0.25F, 0.0F, -0.9F, -0.75F, 0.0F, -0.9F, -0.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F);
      this.gunModel[15].func_78793_a(0.5F, -36.25F, 0.5F);
      this.gunModel[16].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, -0.6F, 0.25F, 0.0F, -0.6F, 0.25F, 0.0F, -1.0F, -0.5F, 0.0F, -1.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F);
      this.gunModel[16].func_78793_a(0.5F, -36.5F, 0.5F);
      this.gunModel[17].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F, -0.6F, 0.25F, 0.0F, -0.6F, 0.25F, 0.0F, -0.9F, -0.75F, 0.0F, -0.9F, -0.75F);
      this.gunModel[17].func_78793_a(0.5F, -35.25F, 0.5F);
      this.gunModel[18].func_78790_a(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
      this.gunModel[18].func_78793_a(0.0F, -27.0F, -1.0F);
   }
}
