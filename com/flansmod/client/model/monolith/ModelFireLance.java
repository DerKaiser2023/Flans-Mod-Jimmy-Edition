package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelFireLance extends ModelGun {
   int textureX = 256;
   int textureY = 32;

   public ModelFireLance() {
      this.gunModel = new ModelRendererTurbo[5];
      this.initgunModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 217, 1, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 225, 1, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 241, 1, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 1, 9, this.textureX, this.textureY);
      this.gunModel[0].func_78790_a(-25.0F, 0.0F, -3.0F, 106, 1, 1, 0.0F);
      this.gunModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.gunModel[1].addShapeBox(0.0F, 0.0F, -3.0F, 2, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[1].func_78793_a(81.0F, 0.0F, 0.0F);
      this.gunModel[2].addShapeBox(0.0F, 0.0F, -3.0F, 5, 1, 1, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, 1.0F, 0.0F);
      this.gunModel[2].func_78793_a(83.0F, 0.0F, 0.0F);
      this.gunModel[3].addShapeBox(-1.0F, 0.0F, -3.0F, 2, 1, 1, 0.0F, 0.0F, -0.25F, -0.25F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.25F, -0.25F);
      this.gunModel[3].func_78793_a(89.0F, 0.0F, 0.0F);
      this.gunModel[4].func_78790_a(-31.0F, -2.0F, -2.0F, 20, 3, 3, 0.0F);
      this.gunModel[4].func_78793_a(86.0F, 0.0F, 0.0F);
   }
}
