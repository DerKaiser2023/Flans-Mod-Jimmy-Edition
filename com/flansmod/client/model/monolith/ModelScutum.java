package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelScutum extends ModelGun {
   int textureX = 64;
   int textureY = 64;

   public ModelScutum() {
      this.gunModel = new ModelRendererTurbo[12];
      this.initgunModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 41, 9, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 41, 17, this.textureX, this.textureY);
      this.gunModel[5] = new ModelRendererTurbo(this, 17, 33, this.textureX, this.textureY);
      this.gunModel[6] = new ModelRendererTurbo(this, 1, 41, this.textureX, this.textureY);
      this.gunModel[7] = new ModelRendererTurbo(this, 17, 41, this.textureX, this.textureY);
      this.gunModel[8] = new ModelRendererTurbo(this, 1, 49, this.textureX, this.textureY);
      this.gunModel[9] = new ModelRendererTurbo(this, 17, 49, this.textureX, this.textureY);
      this.gunModel[10] = new ModelRendererTurbo(this, 33, 49, this.textureX, this.textureY);
      this.gunModel[11] = new ModelRendererTurbo(this, 49, 49, this.textureX, this.textureY);
      this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 26, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[0].func_78793_a(1.0F, -6.0F, -2.0F);
      this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 24, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F);
      this.gunModel[1].func_78793_a(1.0F, -5.0F, 6.0F);
      this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -1.0F, 0.5F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F);
      this.gunModel[2].func_78793_a(1.0F, -6.0F, 6.0F);
      this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -1.0F, 0.5F, 0.0F, -1.0F);
      this.gunModel[3].func_78793_a(1.0F, 19.0F, 6.0F);
      this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 24, 4, 0.0F, 0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[4].func_78793_a(1.0F, -5.0F, -6.0F);
      this.gunModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F, 0.5F, 0.0F, -1.0F, -0.5F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[5].func_78793_a(1.0F, -6.0F, -6.0F);
      this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F, 0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, -1.0F, -0.5F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[6].func_78793_a(1.0F, 19.0F, -6.0F);
      this.gunModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 4, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[7].func_78793_a(1.3F, 3.5F, 0.0F);
      this.gunModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F);
      this.gunModel[8].func_78793_a(1.3F, 6.5F, 0.0F);
      this.gunModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[9].func_78793_a(2.3F, 6.0F, 0.5F);
      this.gunModel[10].addShapeBox(0.0F, -1.0F, 0.0F, 1, 1, 3, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -0.95F, -1.0F, 0.0F, -0.95F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[10].func_78793_a(2.3F, 6.01F, 0.5F);
      this.gunModel[11].addShapeBox(0.0F, -1.0F, 0.0F, 1, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -0.95F, -1.0F, 0.0F, -0.95F, -1.0F, 0.0F, 0.0F, -1.0F);
      this.gunModel[11].func_78793_a(2.3F, 8.01F, 0.5F);
   }
}
