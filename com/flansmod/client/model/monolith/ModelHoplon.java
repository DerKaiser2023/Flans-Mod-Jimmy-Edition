package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelHoplon extends ModelGun {
   int textureX = 64;
   int textureY = 32;

   public ModelHoplon() {
      this.gunModel = new ModelRendererTurbo[16];
      this.initgunModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 32, 0, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 42, 0, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 44, 11, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 17, 11, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 52, 0, this.textureX, this.textureY);
      this.gunModel[5] = new ModelRendererTurbo(this, 54, 11, this.textureX, this.textureY);
      this.gunModel[6] = new ModelRendererTurbo(this, 34, 11, this.textureX, this.textureY);
      this.gunModel[7] = new ModelRendererTurbo(this, 10, 0, this.textureX, this.textureY);
      this.gunModel[8] = new ModelRendererTurbo(this, 10, 16, this.textureX, this.textureY);
      this.gunModel[9] = new ModelRendererTurbo(this, 20, 8, this.textureX, this.textureY);
      this.gunModel[10] = new ModelRendererTurbo(this, 20, 0, this.textureX, this.textureY);
      this.gunModel[11] = new ModelRendererTurbo(this, 20, 16, this.textureX, this.textureY);
      this.gunModel[12] = new ModelRendererTurbo(this, 0, 16, this.textureX, this.textureY);
      this.gunModel[13] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
      this.gunModel[14] = new ModelRendererTurbo(this, 0, 8, this.textureX, this.textureY);
      this.gunModel[15] = new ModelRendererTurbo(this, 10, 8, this.textureX, this.textureY);
      this.gunModel[0].addShapeBox(1.0F, -3.0F, -6.0F, 1, 4, 4, 0.0F, 0.0F, -1.8F, -1.8F, 0.0F, -1.8F, -1.8F, 0.0F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.91F, 0.0F, 0.91F, 0.91F);
      this.gunModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[1].addShapeBox(1.0F, -3.0F, -1.09F, 1, 4, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.18F, 0.0F, 0.0F, 0.18F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.18F, 0.0F, 0.91F, 0.18F);
      this.gunModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[2].addShapeBox(1.0F, 7.0F, -1.09F, 1, 4, 4, 0.0F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.18F, 0.0F, 0.91F, 0.18F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.18F, 0.0F, 0.0F, 0.18F);
      this.gunModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[3].addShapeBox(1.0F, 1.91F, -6.0F, 1, 4, 14, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.18F, 0.0F, 0.0F, 0.18F, 0.0F, 0.0F, 0.18F, 0.0F, 0.0F, 0.18F, 0.0F);
      this.gunModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[4].addShapeBox(1.0F, -3.0F, 4.0F, 1, 4, 4, 0.0F, 0.0F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.0F, -1.8F, -1.8F, 0.0F, -1.8F, -1.8F, 0.0F, 0.91F, 0.91F, 0.0F, 0.91F, 0.91F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.0F);
      this.gunModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[5].addShapeBox(1.0F, 7.0F, 4.0F, 1, 4, 4, 0.0F, 0.0F, 0.91F, 0.91F, 0.0F, 0.91F, 0.91F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.0F, 0.0F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.0F, -1.8F, -1.8F, 0.0F, -1.8F, -1.8F);
      this.gunModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[6].addShapeBox(1.0F, 7.0F, -6.0F, 1, 4, 4, 0.0F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F, 0.91F, 0.0F, 0.91F, 0.91F, 0.0F, -1.8F, -1.8F, 0.0F, -1.8F, -1.8F, 0.0F, 0.0F, 0.91F, 0.0F, 0.0F, 0.91F);
      this.gunModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[7].addShapeBox(2.05F, -3.0F, -1.09F, 1, 4, 4, 0.0F, 0.2F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.18F, 0.2F, -1.0F, 0.18F, 0.2F, 0.91F, 0.0F, 0.2F, 0.91F, 0.0F, 0.2F, 0.91F, 0.18F, 0.2F, 0.91F, 0.18F);
      this.gunModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[8].addShapeBox(2.05F, 7.0F, -1.09F, 1, 4, 4, 0.0F, 0.2F, 0.91F, 0.0F, 0.2F, 0.91F, 0.0F, 0.2F, 0.91F, 0.18F, 0.2F, 0.91F, 0.18F, 0.2F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.18F, 0.2F, -1.0F, 0.18F);
      this.gunModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[9].addShapeBox(2.05F, 1.91F, 3.0F, 1, 4, 4, 0.0F, 0.2F, 0.0F, -0.09F, 0.2F, 0.0F, -0.09F, -1.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.18F, -0.09F, 0.2F, 0.18F, -0.09F, -1.0F, 0.18F, 0.0F, 0.2F, 0.18F, 0.0F);
      this.gunModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[10].addShapeBox(2.05F, -3.0F, 4.0F, 1, 4, 4, 0.0F, 0.2F, -1.0F, 0.91F, -1.0F, -1.0F, 0.91F, -1.0F, -2.35F, -2.35F, 0.2F, -2.35F, -2.35F, 0.2F, 0.91F, 0.91F, 0.2F, 0.91F, 0.91F, -1.0F, 0.91F, -1.0F, 0.2F, 0.91F, -1.0F);
      this.gunModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[11].addShapeBox(2.05F, 7.0F, 4.0F, 1, 4, 4, 0.0F, 0.2F, 0.91F, 0.91F, 0.2F, 0.91F, 0.91F, -1.0F, 0.91F, -1.0F, 0.2F, 0.91F, -1.0F, 0.2F, -1.0F, 0.91F, -1.0F, -1.0F, 0.91F, -1.0F, -2.35F, -2.35F, 0.2F, -2.35F, -2.35F);
      this.gunModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[12].addShapeBox(2.05F, 7.0F, -6.0F, 1, 4, 4, 0.0F, 0.2F, 0.91F, -1.0F, -1.0F, 0.91F, -1.0F, 0.2F, 0.91F, 0.91F, 0.2F, 0.91F, 0.91F, 0.2F, -2.35F, -2.35F, -1.0F, -2.35F, -2.35F, -1.0F, -1.0F, 0.91F, 0.2F, -1.0F, 0.91F);
      this.gunModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[13].addShapeBox(2.05F, -3.0F, -6.0F, 1, 4, 4, 0.0F, 0.2F, -2.35F, -2.35F, -1.0F, -2.35F, -2.35F, -1.0F, -1.0F, 0.91F, 0.2F, -1.0F, 0.91F, 0.2F, 0.91F, -1.0F, -1.0F, 0.91F, -1.0F, 0.2F, 0.91F, 0.91F, 0.2F, 0.91F, 0.91F);
      this.gunModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[14].addShapeBox(2.05F, 1.91F, -5.0F, 1, 4, 4, 0.0F, 0.2F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.2F, 0.0F, -0.09F, 0.2F, 0.0F, -0.09F, 0.2F, 0.18F, 0.0F, -1.0F, 0.18F, 0.0F, 0.2F, 0.18F, -0.09F, 0.2F, 0.18F, -0.09F);
      this.gunModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[15].addShapeBox(2.05F, 1.91F, -1.0F, 1, 4, 4, 0.0F, 0.2F, 0.0F, 0.09F, 0.2F, 0.0F, 0.09F, 0.2F, 0.0F, 0.09F, 0.2F, 0.0F, 0.09F, 0.2F, 0.18F, 0.09F, 0.2F, 0.18F, 0.09F, 0.2F, 0.18F, 0.09F, 0.2F, 0.18F, 0.09F);
      this.gunModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
