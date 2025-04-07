package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelDaneAxe extends ModelGun {
   int textureX = 64;
   int textureY = 64;

   public ModelDaneAxe() {
      this.gunModel = new ModelRendererTurbo[7];
      this.initgunModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
      this.gunModel[5] = new ModelRendererTurbo(this, 17, 9, this.textureX, this.textureY);
      this.gunModel[6] = new ModelRendererTurbo(this, 17, 9, this.textureX, this.textureY);
      this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 30, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[0].func_78793_a(0.0F, -17.0F, 0.0F);
      this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, -0.1F, 0.0F, 0.1F, -0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, -0.1F, 0.0F, 0.1F);
      this.gunModel[1].func_78793_a(0.0F, -16.5F, 0.0F);
      this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.3F, 0.0F, -0.1F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, 0.3F, 0.0F, -0.1F, 0.3F, 0.0F, -0.1F, -0.1F, 0.4F, -0.3F, -0.1F, 0.4F, -0.3F, 0.3F, 0.0F, -0.1F);
      this.gunModel[2].func_78793_a(1.2F, -16.5F, 0.0F);
      this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.1F, 0.4F, -0.3F, -0.1F, 0.7F, -0.3F, -0.1F, 0.7F, -0.3F, 0.1F, 0.4F, -0.3F, 0.1F, 0.0F, -0.3F, -0.1F, 1.2F, -0.3F, -0.1F, 1.2F, -0.3F, 0.1F, 0.0F, -0.3F);
      this.gunModel[3].func_78793_a(2.2F, -16.0F, 0.0F);
      this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.1F, 0.7F, -0.3F, 0.9F, 1.5F, -0.3F, 0.9F, 1.5F, -0.3F, 0.1F, 0.7F, -0.3F, 0.1F, 1.2F, -0.3F, -0.299F, 2.1F, -0.3F, -0.299F, 2.1F, -0.3F, 0.1F, 1.2F, -0.3F);
      this.gunModel[4].func_78793_a(3.2F, -16.0F, 0.0F);
      this.gunModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.9F, 0.5F, -0.3F, 1.5F, 1.5F, -0.5F, 1.5F, 1.5F, -0.5F, -0.9F, 0.5F, -0.3F, -0.35F, 0.0F, -0.3F, 0.8F, 1.0F, -0.5F, 0.8F, 1.0F, -0.5F, -0.35F, 0.0F, -0.3F);
      this.gunModel[5].func_78793_a(4.2F, -17.0F, 0.0F);
      this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.35F, 0.0F, -0.3F, 0.8F, -1.0F, -0.5F, 0.8F, -1.0F, -0.5F, -0.35F, 0.0F, -0.3F, 0.3F, 2.1F, -0.3F, -0.6F, 2.8F, -0.5F, -0.6F, 2.8F, -0.5F, 0.3F, 2.1F, -0.3F);
      this.gunModel[6].func_78793_a(4.2F, -16.0F, 0.0F);
   }
}
