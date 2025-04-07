package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelJi extends ModelGun {
   int textureX = 32;
   int textureY = 64;

   public ModelJi() {
      this.gunModel = new ModelRendererTurbo[9];
      this.initgunModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 9, 1, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 9, 9, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 9, 17, this.textureX, this.textureY);
      this.gunModel[5] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.gunModel[6] = new ModelRendererTurbo(this, 25, 9, this.textureX, this.textureY);
      this.gunModel[7] = new ModelRendererTurbo(this, 25, 17, this.textureX, this.textureY);
      this.gunModel[8] = new ModelRendererTurbo(this, 9, 25, this.textureX, this.textureY);
      this.gunModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 1, 36, 1, 0.0F);
      this.gunModel[0].func_78793_a(0.0F, -20.0F, 0.0F);
      this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F);
      this.gunModel[1].func_78793_a(-1.0F, -19.0F, 0.0F);
      this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F);
      this.gunModel[2].func_78793_a(1.0F, -19.0F, 0.0F);
      this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.25F, -0.25F, 0.0F, 0.25F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, -0.25F, -0.35F, 0.0F, -0.25F, -0.35F, 0.0F, 0.0F, -0.25F);
      this.gunModel[3].func_78793_a(2.0F, -19.0F, 0.0F);
      this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F, 0.0F, 0.25F, -0.25F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.25F, -0.25F, 0.0F, -0.25F, -0.35F, -0.25F, -0.5F, -0.5F, -0.25F, -0.5F, -0.5F, 0.0F, -0.25F, -0.35F);
      this.gunModel[4].func_78793_a(5.0F, -19.0F, 0.0F);
      this.gunModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.05F, 0.3F, 0.05F, 0.05F, 0.3F, 0.05F, 0.05F, 0.3F, 0.05F, 0.05F, 0.3F, 0.05F, 0.05F, 0.3F, 0.05F, 0.05F, 0.3F, 0.05F, 0.05F, 0.3F, 0.05F, 0.05F, 0.3F, 0.05F);
      this.gunModel[5].func_78793_a(0.0F, -21.0F, 0.0F);
      this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F);
      this.gunModel[6].func_78793_a(0.0F, -22.0F, 0.0F);
      this.gunModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.3F, 0.0F, -0.35F, 0.3F, 0.0F, -0.35F, 0.3F, 0.0F, -0.35F, 0.3F, 0.0F, -0.35F, -0.1F, -0.3F, -0.35F, -0.1F, -0.3F, -0.35F, -0.1F, -0.3F, -0.35F, -0.1F, -0.3F, -0.35F);
      this.gunModel[7].func_78793_a(0.0F, -22.5F, 0.0F);
      this.gunModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F, -0.4F, -0.3F, -0.45F, -0.4F, -0.3F, -0.45F, -0.4F, -0.3F, -0.45F, -0.4F, -0.3F, -0.35F, 0.3F, 0.0F, -0.35F, 0.3F, 0.0F, -0.35F, 0.3F, 0.0F, -0.35F, 0.3F, 0.0F, -0.35F);
      this.gunModel[8].func_78793_a(0.0F, -25.5F, 0.0F);
   }
}
