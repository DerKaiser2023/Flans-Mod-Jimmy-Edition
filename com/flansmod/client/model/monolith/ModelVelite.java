package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelVelite extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 64;

   public ModelVelite() {
      this.headModel = new ModelRendererTurbo[15];
      this.initheadModel_1();
   }

   private void initheadModel_1() {
      this.headModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[1] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.headModel[2] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.headModel[3] = new ModelRendererTurbo(this, 65, 1, this.textureX, this.textureY);
      this.headModel[4] = new ModelRendererTurbo(this, 73, 1, this.textureX, this.textureY);
      this.headModel[5] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
      this.headModel[6] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.headModel[7] = new ModelRendererTurbo(this, 65, 9, this.textureX, this.textureY);
      this.headModel[8] = new ModelRendererTurbo(this, 25, 9, this.textureX, this.textureY);
      this.headModel[9] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.headModel[10] = new ModelRendererTurbo(this, 33, 17, this.textureX, this.textureY);
      this.headModel[11] = new ModelRendererTurbo(this, 89, 17, this.textureX, this.textureY);
      this.headModel[12] = new ModelRendererTurbo(this, 17, 17, this.textureX, this.textureY);
      this.headModel[13] = new ModelRendererTurbo(this, 65, 25, this.textureX, this.textureY);
      this.headModel[14] = new ModelRendererTurbo(this, 81, 25, this.textureX, this.textureY);
      this.headModel[0].addShapeBox(-3.0F, -11.5F, -7.5F, 6, 6, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[1].addShapeBox(-1.5F, -8.5F, -10.5F, 3, 3, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[2].addShapeBox(-3.5F, -12.0F, -4.5F, 7, 4, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F);
      this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[3].addShapeBox(-3.0F, -13.5F, -6.0F, 2, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[4].addShapeBox(1.0F, -13.5F, -6.0F, 2, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[5].addShapeBox(-3.5F, -10.0F, -0.5F, 7, 2, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F);
      this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[6].addShapeBox(-4.0F, -8.0F, -3.0F, 8, 8, 7, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 1.1F, 0.0F, 0.5F, 1.1F, 0.0F, 0.5F, 1.1F, 0.0F, 1.1F, 1.1F, 0.0F, 1.1F);
      this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[7].addShapeBox(-3.5F, -8.0F, -4.5F, 7, 4, 4, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, -2.0F, 0.0F, 1.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[8].addShapeBox(2.75F, -1.0F, -4.1F, 2, 6, 2, 0.0F, 0.0F, 0.0F, 0.0F, -0.3F, -0.5F, 0.0F, -0.3F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 5.0F, -1.0F, 0.0F, -5.5F, -0.5F, 0.0F, -5.5F, -0.5F, 0.0F, 5.0F, -1.0F, 0.0F);
      this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[9].addShapeBox(-5.25F, -1.0F, -4.0F, 2, 6, 2, 0.0F, -0.3F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3F, -0.5F, 0.0F, -5.5F, -0.5F, 0.0F, 5.0F, -1.0F, 0.0F, 5.0F, -1.0F, 0.0F, -5.5F, -0.5F, 0.0F);
      this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[10].addShapeBox(-5.0F, 0.0F, 2.0F, 10, 5, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[11].addShapeBox(-5.0F, 5.0F, 2.0F, 10, 3, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F);
      this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[12].addShapeBox(-1.0F, 7.0F, 3.0F, 2, 8, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F);
      this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[13].addShapeBox(2.0F, 6.0F, 2.8F, 2, 6, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.5F, 0.0F, 2.0F, -0.5F, 0.0F, 2.0F, -0.5F, 0.0F, -2.0F, 0.5F, 0.0F);
      this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
      this.headModel[14].addShapeBox(-4.0F, 6.0F, 2.8F, 2, 6, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, -0.5F, 0.0F, -2.0F, 0.5F, 0.0F, -2.0F, 0.5F, 0.0F, 2.0F, -0.5F, 0.0F);
      this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
