package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class Modelcuirass extends ModelCustomArmour {
   int textureX = 64;
   int textureY = 64;

   public Modelcuirass() {
      this.bodyModel = new ModelRendererTurbo[14];
      this.initbodyModel_1();
   }

   private void initbodyModel_1() {
      this.bodyModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyModel[1] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.bodyModel[2] = new ModelRendererTurbo(this, 1, 9, this.textureX, this.textureY);
      this.bodyModel[3] = new ModelRendererTurbo(this, 25, 9, this.textureX, this.textureY);
      this.bodyModel[4] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.bodyModel[5] = new ModelRendererTurbo(this, 25, 17, this.textureX, this.textureY);
      this.bodyModel[6] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.bodyModel[7] = new ModelRendererTurbo(this, 25, 25, this.textureX, this.textureY);
      this.bodyModel[8] = new ModelRendererTurbo(this, 1, 33, this.textureX, this.textureY);
      this.bodyModel[9] = new ModelRendererTurbo(this, 25, 33, this.textureX, this.textureY);
      this.bodyModel[10] = new ModelRendererTurbo(this, 1, 41, this.textureX, this.textureY);
      this.bodyModel[11] = new ModelRendererTurbo(this, 33, 41, this.textureX, this.textureY);
      this.bodyModel[12] = new ModelRendererTurbo(this, 1, 49, this.textureX, this.textureY);
      this.bodyModel[13] = new ModelRendererTurbo(this, 25, 49, this.textureX, this.textureY);
      this.bodyModel[0].addShapeBox(-4.0F, 6.5F, -2.0F, 4, 3, 4, 0.0F, 0.6F, 0.0F, 0.4F, 0.0F, -0.5F, 1.5F, 0.0F, 0.0F, 1.0F, 0.6F, 0.0F, 0.5F, 0.15F, 0.0F, 0.2F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.15F, 0.0F, 0.2F);
      this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[1].addShapeBox(-4.0F, 0.0F, -2.2F, 4, 2, 4, 0.0F, -1.0F, 0.4F, 0.5F, 0.0F, 0.8F, 0.5F, 0.0F, 0.8F, 0.5F, -1.0F, 0.4F, 0.5F, -2.0F, -0.3F, 1.0F, 0.0F, 0.2F, 1.5F, 0.0F, -0.7F, 0.5F, -2.0F, -1.0F, 0.5F);
      this.bodyModel[1].func_78793_a(0.0F, -3.0F, 0.0F);
      this.bodyModel[2].addShapeBox(0.0F, 0.0F, -2.2F, 4, 2, 4, 0.0F, 0.0F, 0.8F, 0.5F, -1.0F, 0.4F, 0.5F, -1.0F, 0.4F, 0.5F, 0.0F, 0.8F, 0.5F, 0.0F, 0.2F, 1.5F, -2.0F, -0.3F, 1.0F, -2.0F, -1.0F, 0.5F, 0.0F, -0.7F, 0.5F);
      this.bodyModel[2].func_78793_a(0.0F, -3.0F, 0.0F);
      this.bodyModel[3].addShapeBox(-4.0F, 3.5F, -2.0F, 4, 3, 4, 0.0F, 0.5F, 0.0F, 0.4F, 0.0F, 0.0F, 1.2F, 0.0F, 0.0F, 1.0F, 0.5F, 0.0F, 0.5F, 0.6F, 0.0F, 0.4F, 0.0F, 0.49F, 1.49F, 0.0F, 0.0F, 1.0F, 0.6F, 0.0F, 0.4F);
      this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[4].addShapeBox(-4.0F, 1.5F, -2.0F, 4, 2, 4, 0.0F, -0.2F, 0.5F, 0.5F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 1.0F, -0.2F, 0.5F, 0.7F, 0.4F, 0.0F, 0.4F, 0.0F, 0.0F, 1.2F, 0.0F, 0.0F, 1.0F, 0.4F, 0.0F, 0.5F);
      this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[5].addShapeBox(-4.0F, -0.5F, -2.0F, 4, 1, 4, 0.0F, -1.0F, -0.3F, 0.3F, -1.5F, -0.3F, 0.2F, 0.0F, -0.3F, 0.8F, -1.0F, -0.3F, 0.5F, -0.2F, 0.5F, 0.5F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 1.0F, -0.2F, 0.5F, 0.7F);
      this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[6].addShapeBox(0.0F, -0.5F, -2.0F, 4, 1, 4, 0.0F, -1.5F, -0.3F, 0.2F, -1.0F, -0.3F, 0.3F, -1.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.8F, 0.0F, 0.5F, 0.8F, -0.2F, 0.5F, 0.5F, -0.2F, 0.5F, 0.7F, 0.0F, 0.5F, 1.0F);
      this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[7].addShapeBox(0.0F, 1.5F, -2.0F, 4, 2, 4, 0.0F, 0.0F, 0.5F, 0.8F, -0.2F, 0.5F, 0.5F, -0.2F, 0.5F, 0.7F, 0.0F, 0.5F, 1.0F, 0.0F, 0.0F, 1.2F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0F);
      this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[8].addShapeBox(0.0F, 3.5F, -2.0F, 4, 3, 4, 0.0F, 0.0F, 0.0F, 1.2F, 0.5F, 0.0F, 0.4F, 0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 0.51F, 1.51F, 0.6F, 0.0F, 0.4F, 0.6F, 0.0F, 0.4F, 0.0F, 0.0F, 1.0F);
      this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[9].addShapeBox(0.0F, 6.5F, -2.0F, 4, 3, 4, 0.0F, 0.0F, -0.5F, 1.5F, 0.6F, 0.0F, 0.4F, 0.6F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.4F, 0.15F, 0.0F, 0.2F, 0.15F, 0.0F, 0.2F, 0.0F, 0.0F, 0.4F);
      this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[10].addShapeBox(-4.0F, 9.3F, -2.0F, 8, 1, 4, 0.0F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F);
      this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[11].addShapeBox(-4.0F, 9.8F, -2.0F, 8, 1, 4, 0.0F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.25F, -0.2F, 0.25F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F);
      this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[12].addShapeBox(-4.0F, 10.8F, -2.0F, 4, 1, 4, 0.0F, 0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 1.0F, 0.0F, 1.0F, 0.0F, 0.5F, 1.2F, 0.0F, 0.5F, 1.2F, 1.0F, 0.0F, 1.0F);
      this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bodyModel[13].addShapeBox(0.0F, 10.8F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.5F, 1.2F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.5F, 1.2F);
      this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
   }
}
