package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelTabar extends ModelGun {
   int textureX = 64;
   int textureY = 32;

   public ModelTabar() {
      this.gunModel = new ModelRendererTurbo[10];
      this.gunModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 9, 1, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.gunModel[5] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.gunModel[6] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.gunModel[7] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
      this.gunModel[8] = new ModelRendererTurbo(this, 9, 9, this.textureX, this.textureY);
      this.gunModel[9] = new ModelRendererTurbo(this, 17, 9, this.textureX, this.textureY);
      this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 26, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[0].func_78793_a(1.0F, -12.0F, 0.0F);
      this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.gunModel[1].func_78793_a(1.0F, -11.5F, 0.0F);
      this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, 0.3F, 0.0F, -0.1F, 0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.3F, 0.3F, 0.0F, -0.1F, 0.3F, 0.0F, -0.1F, 0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.3F, 0.3F, 0.0F, -0.1F);
      this.gunModel[2].func_78793_a(2.2F, -11.5F, 0.0F);
      this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.1F, 0.4F, -0.3F, -0.1F, 2.2F, -0.3F, -0.1F, 2.2F, -0.3F, -0.1F, 0.4F, -0.3F, -0.1F, 0.4F, -0.3F, -0.1F, 2.2F, -0.3F, -0.1F, 2.2F, -0.3F, -0.1F, 0.4F, -0.3F);
      this.gunModel[3].func_78793_a(3.2F, -11.0F, 0.0F);
      this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, 0.1F, 4.0F, -0.3F, 0.9F, 2.5F, -0.3F, 0.9F, 2.5F, -0.3F, 0.1F, 4.0F, -0.3F, 0.1F, 4.0F, -0.3F, 0.9F, 2.5F, -0.3F, 0.9F, 2.5F, -0.3F, 0.1F, 4.0F, -0.3F);
      this.gunModel[4].func_78793_a(4.2F, -11.5F, 0.0F);
      this.gunModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.9F, 2.5F, -0.3F, 1.5F, 0.5F, -0.5F, 1.5F, 0.5F, -0.5F, -0.9F, 2.5F, -0.3F, -0.9F, 0.0F, -0.3F, 1.7F, 0.0F, -0.5F, 1.7F, 0.0F, -0.5F, -0.9F, 0.0F, -0.3F);
      this.gunModel[5].func_78793_a(5.2F, -11.5F, 0.0F);
      this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
      this.gunModel[6].func_78793_a(1.0F, -13.0F, 0.0F);
      this.gunModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F, -0.45F, 0.0F, -0.45F, -0.45F, 0.0F, -0.45F, -0.45F, 0.0F, -0.45F, -0.45F, 0.0F, -0.45F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[7].func_78793_a(1.0F, -18.0F, 0.0F);
      this.gunModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.9F, 0.0F, -0.3F, 1.7F, 0.0F, -0.5F, 1.7F, 0.0F, -0.5F, -0.9F, 0.0F, -0.3F, -0.9F, 2.5F, -0.3F, 1.5F, 0.5F, -0.5F, 1.5F, 0.5F, -0.5F, -0.9F, 2.5F, -0.3F);
      this.gunModel[8].func_78793_a(5.2F, -10.51F, 0.0F);
      this.gunModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F, 0.2F, 1.0F, -0.1F, 0.3F, 0.0F, -0.1F, 0.3F, 0.0F, -0.1F, 0.2F, 1.0F, -0.1F, 0.2F, 1.0F, -0.1F, 0.3F, 0.0F, -0.1F, 0.3F, 0.0F, -0.1F, 0.2F, 1.0F, -0.1F);
      this.gunModel[9].func_78793_a(-1.3F, -11.5F, 0.0F);
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }
}
