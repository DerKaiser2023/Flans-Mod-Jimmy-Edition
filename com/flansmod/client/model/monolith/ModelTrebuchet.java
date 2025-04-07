package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelTrebuchet extends ModelVehicle {
   int textureX = 256;
   int textureY = 128;

   public ModelTrebuchet() {
      this.bodyModel = new ModelRendererTurbo[23];
      this.bodyDoorOpenModel = new ModelRendererTurbo[10];
      this.bodyDoorCloseModel = new ModelRendererTurbo[11];
      this.initbodyModel_1();
      this.initbodyDoorOpenModel_1();
      this.initbodyDoorCloseModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initbodyModel_1() {
      this.bodyModel[0] = new ModelRendererTurbo(this, 33, 41, this.textureX, this.textureY);
      this.bodyModel[1] = new ModelRendererTurbo(this, 233, 1, this.textureX, this.textureY);
      this.bodyModel[2] = new ModelRendererTurbo(this, 81, 41, this.textureX, this.textureY);
      this.bodyModel[3] = new ModelRendererTurbo(this, 105, 41, this.textureX, this.textureY);
      this.bodyModel[4] = new ModelRendererTurbo(this, 121, 41, this.textureX, this.textureY);
      this.bodyModel[5] = new ModelRendererTurbo(this, 137, 41, this.textureX, this.textureY);
      this.bodyModel[6] = new ModelRendererTurbo(this, 153, 41, this.textureX, this.textureY);
      this.bodyModel[7] = new ModelRendererTurbo(this, 1, 49, this.textureX, this.textureY);
      this.bodyModel[8] = new ModelRendererTurbo(this, 17, 49, this.textureX, this.textureY);
      this.bodyModel[9] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
      this.bodyModel[10] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
      this.bodyModel[11] = new ModelRendererTurbo(this, 169, 49, this.textureX, this.textureY);
      this.bodyModel[12] = new ModelRendererTurbo(this, 193, 49, this.textureX, this.textureY);
      this.bodyModel[13] = new ModelRendererTurbo(this, 185, 49, this.textureX, this.textureY);
      this.bodyModel[14] = new ModelRendererTurbo(this, 9, 17, this.textureX, this.textureY);
      this.bodyModel[15] = new ModelRendererTurbo(this, 33, 17, this.textureX, this.textureY);
      this.bodyModel[16] = new ModelRendererTurbo(this, 41, 17, this.textureX, this.textureY);
      this.bodyModel[17] = new ModelRendererTurbo(this, 129, 17, this.textureX, this.textureY);
      this.bodyModel[18] = new ModelRendererTurbo(this, 57, 17, this.textureX, this.textureY);
      this.bodyModel[19] = new ModelRendererTurbo(this, 145, 17, this.textureX, this.textureY);
      this.bodyModel[20] = new ModelRendererTurbo(this, 177, 17, this.textureX, this.textureY);
      this.bodyModel[21] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.bodyModel[22] = new ModelRendererTurbo(this, 33, 65, this.textureX, this.textureY);
      this.bodyModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 2, 2, 18, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F);
      this.bodyModel[0].func_78793_a(1.5F, -50.0F, -9.0F);
      this.bodyModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 4, 72, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[1].func_78793_a(0.5F, -61.0F, -13.0F);
      this.bodyModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 4, 72, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[2].func_78793_a(0.5F, -61.0F, 9.0F);
      this.bodyModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 3, 62, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -18.0F, 0.0F, 0.0F, 18.0F, 0.0F, 0.0F, 18.0F, 0.0F, 0.0F, -18.0F, 0.0F, 0.0F);
      this.bodyModel[3].func_78793_a(0.5F, -51.0F, -13.0F);
      this.bodyModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 3, 62, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -18.0F, 0.0F, 0.0F, 18.0F, 0.0F, 0.0F, 18.0F, 0.0F, 0.0F, -18.0F, 0.0F, 0.0F);
      this.bodyModel[4].func_78793_a(0.5F, -51.0F, 9.0F);
      this.bodyModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 3, 62, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 18.0F, 0.0F, 0.0F, -18.0F, 0.0F, 0.0F, -18.0F, 0.0F, 0.0F, 18.0F, 0.0F, 0.0F);
      this.bodyModel[5].func_78793_a(1.0F, -51.0F, -13.0F);
      this.bodyModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 3, 62, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 18.0F, 0.0F, 0.0F, -18.0F, 0.0F, 0.0F, -18.0F, 0.0F, 0.0F, 18.0F, 0.0F, 0.0F);
      this.bodyModel[6].func_78793_a(0.5F, -51.0F, 9.0F);
      this.bodyModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 3, 62, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 18.0F, 0.0F, 0.0F, 18.0F, 0.0F, 0.0F, -18.0F, 0.0F, 0.0F, -18.0F);
      this.bodyModel[7].func_78793_a(1.0F, -51.0F, -13.0F);
      this.bodyModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 3, 62, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -18.0F, 0.0F, 0.0F, -18.0F, 0.0F, 0.0F, 18.0F, 0.0F, 0.0F, 18.0F);
      this.bodyModel[8].func_78793_a(1.0F, -51.0F, 10.0F);
      this.bodyModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 106, 4, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[9].func_78793_a(-62.5F, 7.0F, -13.5F);
      this.bodyModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 106, 4, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[10].func_78793_a(-62.5F, 7.0F, 8.5F);
      this.bodyModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 4, 14, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[11].func_78793_a(-49.5F, -7.0F, -13.5F);
      this.bodyModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 4, 14, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[12].func_78793_a(-49.5F, -7.0F, 8.5F);
      this.bodyModel[13].addShapeBox(0.0F, 0.0F, 0.0F, 2, 2, 32, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[13].func_78793_a(-48.5F, -6.0F, -16.0F);
      this.bodyModel[14].addShapeBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[14].func_78793_a(-48.0F, -11.0F, -15.5F);
      this.bodyModel[15].addShapeBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[15].func_78793_a(-48.0F, -4.0F, -15.5F);
      this.bodyModel[16].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[16].func_78793_a(-46.5F, -5.5F, -15.5F);
      this.bodyModel[17].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[17].func_78793_a(-53.5F, -5.5F, -15.5F);
      this.bodyModel[18].addShapeBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[18].func_78793_a(-48.0F, -11.0F, 14.5F);
      this.bodyModel[19].addShapeBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[19].func_78793_a(-48.0F, -4.0F, 14.5F);
      this.bodyModel[20].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[20].func_78793_a(-46.5F, -5.5F, 14.5F);
      this.bodyModel[21].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[21].func_78793_a(-53.5F, -5.5F, 14.5F);
      this.bodyModel[22].addShapeBox(0.0F, 0.0F, 0.0F, 3, 3, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyModel[22].func_78793_a(-49.0F, -6.5F, -6.0F);
   }

   private void initbodyDoorOpenModel_1() {
      this.bodyDoorOpenModel[0] = new ModelRendererTurbo(this, 145, 17, this.textureX, this.textureY);
      this.bodyDoorOpenModel[1] = new ModelRendererTurbo(this, 49, 17, this.textureX, this.textureY);
      this.bodyDoorOpenModel[2] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.bodyDoorOpenModel[3] = new ModelRendererTurbo(this, 193, 100, this.textureX, this.textureY);
      this.bodyDoorOpenModel[4] = new ModelRendererTurbo(this, 209, 100, this.textureX, this.textureY);
      this.bodyDoorOpenModel[5] = new ModelRendererTurbo(this, 177, 25, this.textureX, this.textureY);
      this.bodyDoorOpenModel[6] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyDoorOpenModel[7] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.bodyDoorOpenModel[8] = new ModelRendererTurbo(this, 185, 9, this.textureX, this.textureY);
      this.bodyDoorOpenModel[9] = new ModelRendererTurbo(this, 225, 1, this.textureX, this.textureY);
      this.bodyDoorOpenModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 7, 5, 14, 0.0F, 12.0F, 0.0F, 0.0F, 12.0F, 0.0F, 0.0F, 12.0F, 0.0F, 0.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyDoorOpenModel[0].func_78793_a(-1.5F, -4.0F, -7.0F);
      this.bodyDoorOpenModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 31, 9, 14, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyDoorOpenModel[1].func_78793_a(-13.5F, -13.0F, -7.0F);
      this.bodyDoorOpenModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 7, 12, 14, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 12.0F, 0.0F, 0.0F, 12.0F, 0.0F, 0.0F, 12.0F, 0.0F, 0.0F, 12.0F, 0.0F, 0.0F);
      this.bodyDoorOpenModel[2].func_78793_a(-1.5F, -25.0F, -7.0F);
      this.bodyDoorOpenModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 3, 21, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyDoorOpenModel[3].func_78793_a(0.5F, -42.0F, -8.0F);
      this.bodyDoorOpenModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 3, 21, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyDoorOpenModel[4].func_78793_a(0.5F, -42.0F, 7.0F);
      this.bodyDoorOpenModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 11, 2, 14, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F);
      this.bodyDoorOpenModel[5].func_78793_a(1.5F, -50.0F, -7.0F);
      this.bodyDoorOpenModel[5].field_78808_h = -1.3962634F;
      this.bodyDoorOpenModel[6].addShapeBox(-75.0F, -11.0F, 0.0F, 88, 4, 4, 0.0F, 0.0F, -1.0F, -1.0F, 0.0F, -12.0F, 0.0F, 0.0F, -12.0F, 0.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 12.0F, 0.0F, 0.0F, 12.0F, 0.0F, 0.0F, -1.0F, -1.0F);
      this.bodyDoorOpenModel[6].func_78793_a(4.0F, -52.0F, -2.0F);
      this.bodyDoorOpenModel[6].field_78808_h = -1.4137167F;
      this.bodyDoorOpenModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F, 3.0F, 0.0F, 3.0F, 3.0F, 0.0F, 3.0F, 3.0F, 0.0F, 3.0F, 3.0F, 0.0F, 3.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F);
      this.bodyDoorOpenModel[7].func_78793_a(0.5F, -152.0F, -0.5F);
      this.bodyDoorOpenModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 3.0F, 0.0F, 3.0F, 3.0F, 0.0F, 3.0F, 3.0F, 0.0F, 3.0F, 3.0F, 0.0F, 3.0F);
      this.bodyDoorOpenModel[8].func_78793_a(0.5F, -156.0F, -0.5F);
      this.bodyDoorOpenModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 1, 22, 1, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyDoorOpenModel[9].func_78793_a(0.5F, -148.0F, -0.5F);
   }

   private void initbodyDoorCloseModel_1() {
      this.bodyDoorCloseModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyDoorCloseModel[1] = new ModelRendererTurbo(this, 193, 100, this.textureX, this.textureY);
      this.bodyDoorCloseModel[2] = new ModelRendererTurbo(this, 209, 100, this.textureX, this.textureY);
      this.bodyDoorCloseModel[3] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.bodyDoorCloseModel[4] = new ModelRendererTurbo(this, 49, 17, this.textureX, this.textureY);
      this.bodyDoorCloseModel[5] = new ModelRendererTurbo(this, 145, 17, this.textureX, this.textureY);
      this.bodyDoorCloseModel[6] = new ModelRendererTurbo(this, 177, 25, this.textureX, this.textureY);
      this.bodyDoorCloseModel[7] = new ModelRendererTurbo(this, 225, 1, this.textureX, this.textureY);
      this.bodyDoorCloseModel[8] = new ModelRendererTurbo(this, 185, 9, this.textureX, this.textureY);
      this.bodyDoorCloseModel[9] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.bodyDoorCloseModel[10] = new ModelRendererTurbo(this, 65, 65, this.textureX, this.textureY);
      this.bodyDoorCloseModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 88, 4, 4, 0.0F, 0.0F, -1.0F, -1.0F, 0.0F, -12.0F, 0.0F, 0.0F, -12.0F, 0.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 12.0F, 0.0F, 0.0F, 12.0F, 0.0F, 0.0F, -1.0F, -1.0F);
      this.bodyDoorCloseModel[0].func_78793_a(-73.0F, -63.0F, -2.0F);
      this.bodyDoorCloseModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 3, 21, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyDoorCloseModel[1].func_78793_a(9.5F, -53.0F, -8.0F);
      this.bodyDoorCloseModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 3, 21, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyDoorCloseModel[2].func_78793_a(9.5F, -53.0F, 7.0F);
      this.bodyDoorCloseModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 7, 12, 14, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 12.0F, 0.0F, 0.0F, 12.0F, 0.0F, 0.0F, 12.0F, 0.0F, 0.0F, 12.0F, 0.0F, 0.0F);
      this.bodyDoorCloseModel[3].func_78793_a(7.5F, -36.0F, -7.0F);
      this.bodyDoorCloseModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 31, 9, 14, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyDoorCloseModel[4].func_78793_a(-4.5F, -24.0F, -7.0F);
      this.bodyDoorCloseModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 7, 5, 14, 0.0F, 12.0F, 0.0F, 0.0F, 12.0F, 0.0F, 0.0F, 12.0F, 0.0F, 0.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bodyDoorCloseModel[5].func_78793_a(7.5F, -15.0F, -7.0F);
      this.bodyDoorCloseModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 11, 2, 14, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F);
      this.bodyDoorCloseModel[6].func_78793_a(1.5F, -50.0F, -7.0F);
      this.bodyDoorCloseModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 1, 22, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F);
      this.bodyDoorCloseModel[7].func_78793_a(-72.0F, -60.0F, -0.5F);
      this.bodyDoorCloseModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 3.0F, 0.0F, 3.0F, 3.0F, 0.0F, 3.0F, 3.0F, 0.0F, 3.0F, 3.0F, 0.0F, 3.0F);
      this.bodyDoorCloseModel[8].func_78793_a(-72.0F, -38.0F, -0.5F);
      this.bodyDoorCloseModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F, 3.0F, 0.0F, 3.0F, 3.0F, 0.0F, 3.0F, 3.0F, 0.0F, 3.0F, 3.0F, 0.0F, 3.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F);
      this.bodyDoorCloseModel[9].func_78793_a(-72.0F, -34.0F, -0.5F);
      this.bodyDoorCloseModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 1, 52, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
      this.bodyDoorCloseModel[10].func_78793_a(-47.0F, -6.5F, -0.5F);
      this.bodyDoorCloseModel[10].field_78808_h = 3.3161256F;
   }
}
