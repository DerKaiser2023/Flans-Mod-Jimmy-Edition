package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelPilum extends ModelGun {
   int textureX = 32;
   int textureY = 32;

   public ModelPilum() {
      this.gunModel = new ModelRendererTurbo[4];
      this.initgunModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 1, 9, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 26, 8, this.textureX, this.textureY);
      this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 30, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[0].func_78793_a(-28.0F, -3.0F, 0.0F);
      this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.5F);
      this.gunModel[1].func_78793_a(2.0F, -3.0F, 0.0F);
      this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 11, 1, 1, 0.0F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F);
      this.gunModel[2].func_78793_a(6.0F, -3.0F, 0.0F);
      this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, 0.0F, -0.2F, -0.2F, 0.0F, -0.45F, -0.45F, 0.0F, -0.45F, -0.45F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.45F, -0.45F, 0.0F, -0.45F, -0.45F, 0.0F, -0.2F, -0.2F);
      this.gunModel[3].func_78793_a(17.0F, -3.0F, 0.0F);
   }
}
