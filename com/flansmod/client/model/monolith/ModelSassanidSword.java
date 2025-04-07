package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelSassanidSword extends ModelGun {
   int textureX = 32;
   int textureY = 32;

   public ModelSassanidSword() {
      this.gunModel = new ModelRendererTurbo[5];
      this.initgunModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 1, 9, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[0].addShapeBox(0.0F, 0.0F, -0.8F, 1, 1, 1, 0.0F, -0.2F, -0.5F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, -0.5F, 0.5F, -0.2F, -0.5F, 0.5F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F);
      this.gunModel[0].func_78793_a(0.2F, -3.0F, 0.5F);
      this.gunModel[0].field_78796_g = -1.0471976F;
      this.gunModel[1].addShapeBox(0.0F, 0.0F, -1.0F, 1, 13, 2, 0.0F, -0.4F, 0.0F, -0.45F, -0.4F, 0.0F, -0.45F, -0.4F, -0.3F, -0.45F, -0.4F, -0.3F, -0.45F, -0.4F, 0.5F, -0.45F, -0.4F, 0.5F, -0.45F, -0.4F, 0.5F, -0.45F, -0.4F, 0.5F, -0.45F);
      this.gunModel[1].func_78793_a(0.2F, -16.0F, 0.5F);
      this.gunModel[1].field_78796_g = -1.0471976F;
      this.gunModel[2].addShapeBox(0.0F, 0.0F, -1.0F, 1, 1, 2, 0.0F, -0.45F, 0.0F, -0.8F, -0.45F, 0.0F, -0.8F, -0.45F, 0.0F, -1.1F, -0.45F, 0.0F, -1.1F, -0.4F, 0.0F, -0.45F, -0.4F, 0.0F, -0.45F, -0.4F, 0.3F, -0.45F, -0.4F, 0.3F, -0.45F);
      this.gunModel[2].func_78793_a(0.2F, -17.0F, 0.5F);
      this.gunModel[2].field_78796_g = -1.0471976F;
      this.gunModel[3].addShapeBox(0.0F, 0.0F, -0.7F, 1, 4, 1, 0.0F, -0.15F, 0.2F, -0.15F, -0.15F, 0.2F, -0.15F, -0.15F, 0.2F, -0.15F, -0.15F, 0.2F, -0.15F, -0.15F, 0.2F, -0.15F, -0.15F, 0.2F, -0.15F, -0.15F, 0.2F, -0.15F, -0.15F, 0.2F, -0.15F);
      this.gunModel[3].func_78793_a(0.2F, -2.0F, 0.5F);
      this.gunModel[3].field_78796_g = -1.0471976F;
      this.gunModel[4].addShapeBox(0.0F, 0.0F, -0.7F, 1, 1, 1, 0.0F, -0.15F, 0.2F, -0.15F, -0.15F, 0.2F, -0.15F, -0.15F, -0.2F, -0.1F, -0.15F, -0.2F, -0.1F, -0.15F, 0.0F, -0.15F, -0.15F, 0.0F, -0.15F, -0.15F, 0.5F, 0.1F, -0.15F, 0.5F, 0.1F);
      this.gunModel[4].func_78793_a(0.2F, 2.0F, 0.5F);
      this.gunModel[4].field_78796_g = -1.0471976F;
   }
}
