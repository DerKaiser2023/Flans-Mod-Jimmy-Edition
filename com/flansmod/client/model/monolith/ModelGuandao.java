package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelGuandao extends ModelGun {
   int textureX = 32;
   int textureY = 64;

   public ModelGuandao() {
      this.gunModel = new ModelRendererTurbo[7];
      this.initgunModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 9, 1, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 9, 9, this.textureX, this.textureY);
      this.gunModel[5] = new ModelRendererTurbo(this, 17, 9, this.textureX, this.textureY);
      this.gunModel[6] = new ModelRendererTurbo(this, 9, 9, this.textureX, this.textureY);
      this.gunModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 1, 36, 1, 0.0F);
      this.gunModel[0].func_78793_a(-1.5F, -25.0F, 0.0F);
      this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.05F, 0.0F, 0.0F, -0.4F, 0.0F, -0.25F, -0.4F, 0.0F, -0.25F, 0.05F, 0.0F, 0.0F, 0.05F, -0.5F, 2.7755576E-17F, -0.4F, -0.5F, -0.25F, -0.4F, -0.5F, -0.25F, 0.05F, -0.5F, 2.7755576E-17F);
      this.gunModel[1].func_78793_a(-0.5F, -25.0F, 0.0F);
      this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.4F, 0.0F, -0.25F, 0.05F, 0.0F, 0.0F, 0.05F, 0.0F, 0.0F, -0.4F, 0.0F, -0.25F, -0.4F, -0.5F, -0.25F, 0.05F, -0.5F, 2.7755576E-17F, 0.05F, -0.5F, 2.7755576E-17F, -0.4F, -0.5F, -0.25F);
      this.gunModel[2].func_78793_a(-2.5F, -25.0F, 0.0F);
      this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F, -0.05F, 0.0F, -0.25F, 0.45F, 0.0F, -0.35F, 0.45F, 0.0F, -0.35F, -0.05F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.35F, 0.0F, 0.0F, -0.35F, 0.0F, 0.0F, -0.25F);
      this.gunModel[3].func_78793_a(-1.5F, -29.0F, 0.0F);
      this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F, 0.25F, 0.0F, -0.25F, 0.2F, 0.0F, -0.35F, 0.2F, 0.0F, -0.35F, 0.25F, 0.0F, -0.25F, -0.05F, 0.0F, -0.25F, 0.45F, 0.0F, -0.35F, 0.45F, 0.0F, -0.35F, -0.05F, 0.0F, -0.25F);
      this.gunModel[4].func_78793_a(-1.5F, -35.0F, 0.0F);
      this.gunModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F, 1.0F, 0.5F, -0.35F, -0.75F, -0.25F, -0.45F, -0.75F, -0.25F, -0.45F, 1.0F, 0.5F, -0.35F, 0.25F, 0.0F, -0.25F, 0.2F, 0.0F, -0.35F, 0.2F, 0.0F, -0.35F, 0.25F, 0.0F, -0.25F);
      this.gunModel[5].func_78793_a(-1.5F, -38.0F, 0.0F);
      this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F, -0.1F, 0.0F, -0.35F, -0.85F, 0.0F, -0.35F, -0.85F, 0.0F, -0.35F, -0.1F, 0.0F, -0.35F, -1.1F, 0.0F, -0.35F, 0.9F, 0.0F, -0.35F, 0.9F, 0.0F, -0.35F, -1.1F, 0.0F, -0.35F);
      this.gunModel[6].func_78793_a(-2.5F, -33.0F, 0.0F);
   }
}
