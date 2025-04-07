package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelMaul extends ModelGun {
   int textureX = 32;
   int textureY = 32;

   public ModelMaul() {
      this.gunModel = new ModelRendererTurbo[5];
      this.initgunModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 9, 1, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 9, 9, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.gunModel[0].addShapeBox(0.0F, 0.0F, -0.65F, 1, 14, 1, 0.0F, -0.15F, 0.2F, -0.15F, -0.15F, 0.2F, -0.15F, -0.15F, 0.2F, -0.15F, -0.15F, 0.2F, -0.15F, -0.15F, 0.2F, -0.15F, -0.15F, 0.2F, -0.15F, -0.15F, 0.2F, -0.15F, -0.15F, 0.2F, -0.15F);
      this.gunModel[0].func_78793_a(0.3F, -7.0F, 0.5F);
      this.gunModel[1].addShapeBox(0.0F, 0.0F, -0.65F, 1, 3, 1, 0.0F, -0.35F, 0.2F, -0.35F, -0.35F, 0.2F, -0.35F, -0.35F, 0.2F, -0.35F, -0.35F, 0.2F, -0.35F, -0.15F, 0.2F, -0.15F, -0.15F, 0.2F, -0.15F, -0.15F, 0.2F, -0.15F, -0.15F, 0.2F, -0.15F);
      this.gunModel[1].func_78793_a(0.3F, -15.0F, 0.5F);
      this.gunModel[2].addShapeBox(0.0F, 0.0F, -0.65F, 6, 1, 4, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F);
      this.gunModel[2].func_78793_a(-2.2F, -10.0F, -1.0F);
      this.gunModel[3].addShapeBox(0.0F, 0.0F, -0.65F, 6, 1, 4, 0.0F, 0.0F, 0.0F, -1.25F, 0.0F, 0.0F, -1.25F, 0.0F, 0.0F, -1.25F, 0.0F, 0.0F, -1.25F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F);
      this.gunModel[3].func_78793_a(-2.2F, -11.75F, -1.0F);
      this.gunModel[4].addShapeBox(0.0F, 0.0F, -0.65F, 6, 1, 4, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.0F, -1.25F, 0.0F, 0.0F, -1.25F, 0.0F, 0.0F, -1.25F, 0.0F, 0.0F, -1.25F);
      this.gunModel[4].func_78793_a(-2.2F, -8.25F, -1.0F);
   }
}
