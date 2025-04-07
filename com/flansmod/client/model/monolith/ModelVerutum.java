package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelVerutum extends ModelGun {
   int textureX = 64;
   int textureY = 32;

   public ModelVerutum() {
      this.gunModel = new ModelRendererTurbo[3];
      this.initgunModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 1, 9, this.textureX, this.textureY);
      this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 15, 1, 1, 0.0F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F);
      this.gunModel[0].func_78793_a(-13.0F, -2.8F, 0.0F);
      this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F, 0.0F, -0.3F, -0.3F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.3F, -0.3F);
      this.gunModel[1].func_78793_a(2.0F, -2.8F, 0.0F);
      this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, 0.0F, -0.3F, -0.3F, 0.0F, -0.45F, -0.45F, 0.0F, -0.45F, -0.45F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.45F, -0.45F, 0.0F, -0.45F, -0.45F, 0.0F, -0.3F, -0.3F);
      this.gunModel[2].func_78793_a(8.0F, -2.8F, 0.0F);
   }
}
