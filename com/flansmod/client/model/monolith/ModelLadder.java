package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelLadder extends ModelVehicle {
   int textureX = 32;
   int textureY = 256;

   public ModelLadder() {
      this.bodyModel = new ModelRendererTurbo[18];
      this.initbodyModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initbodyModel_1() {
      this.bodyModel[0] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.bodyModel[1] = new ModelRendererTurbo(this, 9, 25, this.textureX, this.textureY);
      this.bodyModel[2] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyModel[3] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyModel[4] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyModel[5] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyModel[6] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyModel[7] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyModel[8] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyModel[9] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyModel[10] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyModel[11] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyModel[12] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyModel[13] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyModel[14] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyModel[15] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyModel[16] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyModel[17] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyModel[0].addShapeBox(-0.5F, 0.0F, -0.5F, 1, 141, 1, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
      this.bodyModel[0].func_78793_a(5.0F, -130.0F, -8.0F);
      this.bodyModel[0].field_78808_h = -0.08726646F;
      this.bodyModel[1].addShapeBox(-0.5F, 0.0F, -0.5F, 1, 141, 1, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
      this.bodyModel[1].func_78793_a(5.0F, -130.0F, 8.0F);
      this.bodyModel[1].field_78808_h = -0.08726646F;
      this.bodyModel[2].addShapeBox(-0.5F, 8.0F, 0.5F, 1, 1, 15, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[2].func_78793_a(5.0F, -130.0F, -8.0F);
      this.bodyModel[2].field_78808_h = -0.08726646F;
      this.bodyModel[3].addShapeBox(-0.5F, 16.0F, 0.5F, 1, 1, 15, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[3].func_78793_a(5.0F, -130.0F, -8.0F);
      this.bodyModel[3].field_78808_h = -0.08726646F;
      this.bodyModel[4].addShapeBox(-0.5F, 24.0F, 0.5F, 1, 1, 15, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[4].func_78793_a(5.0F, -130.0F, -8.0F);
      this.bodyModel[4].field_78808_h = -0.08726646F;
      this.bodyModel[5].addShapeBox(-0.5F, 32.0F, 0.5F, 1, 1, 15, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[5].func_78793_a(5.0F, -130.0F, -8.0F);
      this.bodyModel[5].field_78808_h = -0.08726646F;
      this.bodyModel[6].addShapeBox(-0.5F, 40.0F, 0.5F, 1, 1, 15, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[6].func_78793_a(5.0F, -130.0F, -8.0F);
      this.bodyModel[6].field_78808_h = -0.08726646F;
      this.bodyModel[7].addShapeBox(-0.5F, 48.0F, 0.5F, 1, 1, 15, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[7].func_78793_a(5.0F, -130.0F, -8.0F);
      this.bodyModel[7].field_78808_h = -0.08726646F;
      this.bodyModel[8].addShapeBox(-0.5F, 56.0F, 0.5F, 1, 1, 15, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[8].func_78793_a(5.0F, -130.0F, -8.0F);
      this.bodyModel[8].field_78808_h = -0.08726646F;
      this.bodyModel[9].addShapeBox(-0.5F, 64.0F, 0.5F, 1, 1, 15, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[9].func_78793_a(5.0F, -130.0F, -8.0F);
      this.bodyModel[9].field_78808_h = -0.08726646F;
      this.bodyModel[10].addShapeBox(-0.5F, 72.0F, 0.5F, 1, 1, 15, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[10].func_78793_a(5.0F, -130.0F, -8.0F);
      this.bodyModel[10].field_78808_h = -0.08726646F;
      this.bodyModel[11].addShapeBox(-0.5F, 80.0F, 0.5F, 1, 1, 15, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[11].func_78793_a(5.0F, -130.0F, -8.0F);
      this.bodyModel[11].field_78808_h = -0.08726646F;
      this.bodyModel[12].addShapeBox(-0.5F, 88.0F, 0.5F, 1, 1, 15, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[12].func_78793_a(5.0F, -130.0F, -8.0F);
      this.bodyModel[12].field_78808_h = -0.08726646F;
      this.bodyModel[13].addShapeBox(-0.5F, 96.0F, 0.5F, 1, 1, 15, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[13].func_78793_a(5.0F, -130.0F, -8.0F);
      this.bodyModel[13].field_78808_h = -0.08726646F;
      this.bodyModel[14].addShapeBox(-0.5F, 104.0F, 0.5F, 1, 1, 15, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[14].func_78793_a(5.0F, -130.0F, -8.0F);
      this.bodyModel[14].field_78808_h = -0.08726646F;
      this.bodyModel[15].addShapeBox(-0.5F, 112.0F, 0.5F, 1, 1, 15, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[15].func_78793_a(5.0F, -130.0F, -8.0F);
      this.bodyModel[15].field_78808_h = -0.08726646F;
      this.bodyModel[16].addShapeBox(-0.5F, 120.0F, 0.5F, 1, 1, 15, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[16].func_78793_a(5.0F, -130.0F, -8.0F);
      this.bodyModel[16].field_78808_h = -0.08726646F;
      this.bodyModel[17].addShapeBox(-0.5F, 128.0F, 0.5F, 1, 1, 15, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[17].func_78793_a(5.0F, -130.0F, -8.0F);
      this.bodyModel[17].field_78808_h = -0.08726646F;
   }
}
