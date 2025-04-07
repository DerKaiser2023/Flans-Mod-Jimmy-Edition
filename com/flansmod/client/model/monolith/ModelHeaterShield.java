package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelHeaterShield extends ModelGun {
   int textureX = 64;
   int textureY = 64;

   public ModelHeaterShield() {
      this.gunModel = new ModelRendererTurbo[8];
      this.initgunModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.gunModel[5] = new ModelRendererTurbo(this, 17, 17, this.textureX, this.textureY);
      this.gunModel[6] = new ModelRendererTurbo(this, 33, 17, this.textureX, this.textureY);
      this.gunModel[7] = new ModelRendererTurbo(this, 49, 17, this.textureX, this.textureY);
      this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 4, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[0].func_78793_a(1.0F, -1.5F, -6.0F);
      this.gunModel[1].addShapeBox(0.0F, -5.0F, 0.0F, 1, 3, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[1].func_78793_a(1.0F, 0.49F, -6.0F);
      this.gunModel[2].addShapeBox(0.0F, -4.0F, 0.0F, 1, 5, 6, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[2].func_78793_a(1.0F, 6.49F, -6.0F);
      this.gunModel[3].addShapeBox(0.0F, -4.0F, 0.0F, 1, 3, 6, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.5F, 0.0F, 0.0F, -5.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[3].func_78793_a(1.0F, 11.5F, -6.0F);
      this.gunModel[4].addShapeBox(0.0F, -4.0F, 0.0F, 1, 3, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.5F, 0.0F, 0.0F, -5.5F);
      this.gunModel[4].func_78793_a(0.99F, 11.49F, 0.0F);
      this.gunModel[5].addShapeBox(0.0F, -4.0F, 0.0F, 1, 5, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F);
      this.gunModel[5].func_78793_a(0.99F, 6.5F, 0.0F);
      this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 1, 4, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F);
      this.gunModel[6].func_78793_a(0.99F, -1.51F, 0.0F);
      this.gunModel[7].addShapeBox(0.0F, -5.0F, 0.0F, 1, 3, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[7].func_78793_a(0.99F, 0.5F, 0.0F);
   }
}
