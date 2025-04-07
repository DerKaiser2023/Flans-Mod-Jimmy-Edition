package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelKalkan extends ModelGun {
   int textureX = 64;
   int textureY = 32;

   public ModelKalkan() {
      this.gunModel = new ModelRendererTurbo[20];
      this.initgunModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 9, 9, this.textureX, this.textureY);
      this.gunModel[5] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.gunModel[6] = new ModelRendererTurbo(this, 17, 17, this.textureX, this.textureY);
      this.gunModel[7] = new ModelRendererTurbo(this, 10, 0, this.textureX, this.textureY);
      this.gunModel[8] = new ModelRendererTurbo(this, 10, 16, this.textureX, this.textureY);
      this.gunModel[9] = new ModelRendererTurbo(this, 20, 8, this.textureX, this.textureY);
      this.gunModel[10] = new ModelRendererTurbo(this, 20, 0, this.textureX, this.textureY);
      this.gunModel[11] = new ModelRendererTurbo(this, 20, 16, this.textureX, this.textureY);
      this.gunModel[12] = new ModelRendererTurbo(this, 0, 16, this.textureX, this.textureY);
      this.gunModel[13] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
      this.gunModel[14] = new ModelRendererTurbo(this, 0, 8, this.textureX, this.textureY);
      this.gunModel[15] = new ModelRendererTurbo(this, 10, 8, this.textureX, this.textureY);
      this.gunModel[16] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
      this.gunModel[17] = new ModelRendererTurbo(this, 57, 9, this.textureX, this.textureY);
      this.gunModel[18] = new ModelRendererTurbo(this, 33, 25, this.textureX, this.textureY);
      this.gunModel[19] = new ModelRendererTurbo(this, 41, 25, this.textureX, this.textureY);
      this.gunModel[0].addShapeBox(1.0F, -6.0F, -6.0F, 1, 4, 4, 0.0F, 0.0F, -1.8F, -1.8F, 0.0F, -1.8F, -1.8F, 0.0F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.91F, 0.0F, 0.91F, 0.91F);
      this.gunModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[1].addShapeBox(1.0F, -6.0F, -1.09F, 1, 4, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.18F, 0.0F, 0.0F, 0.18F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.18F, 0.0F, 0.91F, 0.18F);
      this.gunModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[2].addShapeBox(1.0F, 4.0F, -1.09F, 1, 4, 4, 0.0F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.18F, 0.0F, 0.91F, 0.18F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.18F, 0.0F, 0.0F, 0.18F);
      this.gunModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[3].addShapeBox(1.0F, -1.09F, -6.0F, 1, 4, 14, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.18F, 0.0F, 0.0F, 0.18F, 0.0F, 0.0F, 0.18F, 0.0F, 0.0F, 0.18F, 0.0F);
      this.gunModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[4].addShapeBox(1.0F, -6.0F, 4.0F, 1, 4, 4, 0.0F, 0.0F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.0F, -1.8F, -1.8F, 0.0F, -1.8F, -1.8F, 0.0F, 0.91F, 0.91F, 0.0F, 0.91F, 0.91F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.0F);
      this.gunModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[5].addShapeBox(1.0F, 4.0F, 4.0F, 1, 4, 4, 0.0F, 0.0F, 0.91F, 0.91F, 0.0F, 0.91F, 0.91F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.0F, 0.0F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.0F, -1.8F, -1.8F, 0.0F, -1.8F, -1.8F);
      this.gunModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[6].addShapeBox(1.0F, 4.0F, -6.0F, 1, 4, 4, 0.0F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.91F, 0.0F, 0.91F, 0.91F, 0.0F, -1.8F, -1.8F, 0.0F, -1.8F, -1.8F, 0.0F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F);
      this.gunModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[7].addShapeBox(2.05F, -6.0F, -1.09F, 1, 4, 4, 0.0F, 0.2F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.18F, 0.2F, -1.0F, 0.18F, 0.2F, 0.91F, 0.0F, 0.2F, 0.91F, 0.0F, 0.2F, 0.91F, 0.18F, 0.2F, 0.91F, 0.18F);
      this.gunModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[8].addShapeBox(2.05F, 4.0F, -1.09F, 1, 4, 4, 0.0F, 0.2F, 0.91F, 0.0F, 0.2F, 0.91F, 0.0F, 0.2F, 0.91F, 0.18F, 0.2F, 0.91F, 0.18F, 0.2F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.18F, 0.2F, -1.0F, 0.18F);
      this.gunModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[9].addShapeBox(2.05F, -1.09F, 3.0F, 1, 4, 4, 0.0F, 0.2F, 0.0F, -0.09F, 0.2F, 0.0F, -0.09F, -1.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.18F, -0.09F, 0.2F, 0.18F, -0.09F, -1.0F, 0.18F, 0.0F, 0.2F, 0.18F, 0.0F);
      this.gunModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[10].addShapeBox(2.05F, -6.0F, 4.0F, 1, 4, 4, 0.0F, 0.2F, -1.0F, 0.91F, -1.0F, -1.0F, 0.91F, -1.0F, -2.35F, -2.35F, 0.2F, -2.35F, -2.35F, 0.2F, 0.91F, 0.91F, 0.2F, 0.91F, 0.91F, -1.0F, 0.91F, -1.0F, 0.2F, 0.91F, -1.0F);
      this.gunModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[11].addShapeBox(2.05F, 4.0F, 4.0F, 1, 4, 4, 0.0F, 0.2F, 0.91F, 0.91F, 0.2F, 0.91F, 0.91F, -1.0F, 0.91F, -1.0F, 0.2F, 0.91F, -1.0F, 0.2F, -1.0F, 0.91F, -1.0F, -1.0F, 0.91F, -1.0F, -2.35F, -2.35F, 0.2F, -2.35F, -2.35F);
      this.gunModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[12].addShapeBox(2.05F, 4.0F, -6.0F, 1, 4, 4, 0.0F, 0.2F, 0.91F, -1.0F, -1.0F, 0.91F, -1.0F, 0.2F, 0.91F, 0.91F, 0.2F, 0.91F, 0.91F, 0.2F, -2.35F, -2.35F, -1.0F, -2.35F, -2.35F, -1.0F, -1.0F, 0.91F, 0.2F, -1.0F, 0.91F);
      this.gunModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[13].addShapeBox(2.05F, -6.0F, -6.0F, 1, 4, 4, 0.0F, 0.2F, -2.35F, -2.35F, -1.0F, -2.35F, -2.35F, -1.0F, -1.0F, 0.91F, 0.2F, -1.0F, 0.91F, 0.2F, 0.91F, -1.0F, -1.0F, 0.91F, -1.0F, 0.2F, 0.91F, 0.91F, 0.2F, 0.91F, 0.91F);
      this.gunModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[14].addShapeBox(2.05F, -1.09F, -5.0F, 1, 4, 4, 0.0F, 0.2F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.2F, 0.0F, -0.09F, 0.2F, 0.0F, -0.09F, 0.2F, 0.18F, 0.0F, -1.0F, 0.18F, 0.0F, 0.2F, 0.18F, -0.09F, 0.2F, 0.18F, -0.09F);
      this.gunModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[15].addShapeBox(2.05F, -1.09F, -1.0F, 1, 4, 4, 0.0F, 0.2F, 0.0F, 0.09F, 0.2F, 0.0F, 0.09F, 0.2F, 0.0F, 0.09F, 0.2F, 0.0F, 0.09F, 0.2F, 0.18F, 0.09F, 0.2F, 0.18F, 0.09F, 0.2F, 0.18F, 0.09F, 0.2F, 0.18F, 0.09F);
      this.gunModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[16].addShapeBox(2.5F, -3.09F, 0.0F, 1, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[17].addShapeBox(2.5F, 2.91F, 0.0F, 1, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[18].addShapeBox(2.5F, -0.09F, 3.0F, 1, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[19].addShapeBox(2.5F, -0.09F, -1.0F, 1, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[19].func_78793_a(0.0F, 0.0F, -2.0F);
   }
}
