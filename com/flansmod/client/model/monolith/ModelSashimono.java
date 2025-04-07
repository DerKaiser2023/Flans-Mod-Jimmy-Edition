package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelSashimono extends ModelCustomArmour {
   int textureX = 64;
   int textureY = 128;

   public ModelSashimono() {
      this.bodyModel = new ModelRendererTurbo[4];
      this.initbodyModel_1();
   }

   private void initbodyModel_1() {
      this.bodyModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyModel[1] = new ModelRendererTurbo(this, 9, 1, this.textureX, this.textureY);
      this.bodyModel[2] = new ModelRendererTurbo(this, 9, 1, this.textureX, this.textureY);
      this.bodyModel[3] = new ModelRendererTurbo(this, 9, 17, this.textureX, this.textureY);
      this.bodyModel[0].addShapeBox(-0.5F, -31.5F, 4.5F, 1, 40, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[1].addShapeBox(-0.5F, -31.5F, 5.5F, 1, 1, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[2].addShapeBox(-0.5F, 0.0F, 1.5F, 1, 1, 4, 0.0F, 3.3F, 0.0F, 0.3F, 3.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 3.3F, 0.0F, 0.3F, 3.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F);
      this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[3].addShapeBox(-0.5F, -30.5F, 5.5F, 1, 64, 24, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, -12.0F, -0.3F, 0.0F, -12.0F, -0.3F, -34.0F, 0.0F, -0.3F, -34.0F, 0.0F, -0.3F, -34.0F, -12.0F, -0.3F, -34.0F, -12.0F);
      this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
