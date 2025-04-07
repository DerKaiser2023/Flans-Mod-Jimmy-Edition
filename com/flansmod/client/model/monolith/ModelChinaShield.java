package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelChinaShield extends ModelGun {
   int textureX = 64;
   int textureY = 32;

   public ModelChinaShield() {
      this.gunModel = new ModelRendererTurbo[5];
      this.initgunModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 5, 10, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F);
      this.gunModel[0].func_78793_a(0.5F, 0.0F, -5.0F);
      this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 5, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F);
      this.gunModel[1].func_78793_a(0.5F, -5.0F, 0.0F);
      this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 12, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F);
      this.gunModel[2].func_78793_a(0.5F, 5.0F, -6.0F);
      this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 5, 5, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[3].func_78793_a(0.5F, -5.0F, -5.0F);
      this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[4].func_78793_a(0.5F, -5.5F, -1.0F);
   }
}
