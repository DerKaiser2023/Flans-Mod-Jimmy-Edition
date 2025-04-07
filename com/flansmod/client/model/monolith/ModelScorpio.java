package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelScorpio extends ModelVehicle {
   int textureX = 128;
   int textureY = 64;

   public ModelScorpio() {
      this.bodyModel = new ModelRendererTurbo[7];
      this.barrelModel = new ModelRendererTurbo[15];
      this.initbodyModel_1();
      this.initbarrelModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initbodyModel_1() {
      this.bodyModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bodyModel[1] = new ModelRendererTurbo(this, 9, 1, this.textureX, this.textureY);
      this.bodyModel[2] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.bodyModel[3] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.bodyModel[4] = new ModelRendererTurbo(this, 65, 1, this.textureX, this.textureY);
      this.bodyModel[5] = new ModelRendererTurbo(this, 89, 1, this.textureX, this.textureY);
      this.bodyModel[6] = new ModelRendererTurbo(this, 1, 9, this.textureX, this.textureY);
      this.bodyModel[0].func_78790_a(-0.5F, 0.0F, -0.5F, 1, 15, 1, 0.0F);
      this.bodyModel[0].func_78793_a(0.0F, -5.0F, 0.0F);
      this.bodyModel[1].func_78790_a(-0.5F, 0.0F, -0.5F, 13, 1, 1, 0.0F);
      this.bodyModel[1].func_78793_a(-6.0F, 9.0F, 0.0F);
      this.bodyModel[2].func_78790_a(-0.5F, 0.0F, -0.5F, 1, 1, 13, 0.0F);
      this.bodyModel[2].func_78793_a(0.0F, 9.0F, -6.0F);
      this.bodyModel[3].addShapeBox(-0.5F, 0.0F, 0.5F, 1, 1, 9, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F);
      this.bodyModel[3].func_78793_a(0.0F, 3.0F, 0.0F);
      this.bodyModel[3].field_78795_f = -0.80285144F;
      this.bodyModel[4].addShapeBox(-0.5F, 0.0F, 0.5F, 1, 1, 9, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F);
      this.bodyModel[4].func_78793_a(0.0F, 3.0F, 0.0F);
      this.bodyModel[4].field_78795_f = -0.80285144F;
      this.bodyModel[4].field_78796_g = -1.5707964F;
      this.bodyModel[5].addShapeBox(-0.5F, 0.0F, 0.5F, 1, 1, 9, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F);
      this.bodyModel[5].func_78793_a(0.0F, 3.0F, 0.0F);
      this.bodyModel[5].field_78795_f = -0.80285144F;
      this.bodyModel[5].field_78796_g = -3.1415927F;
      this.bodyModel[6].addShapeBox(-0.5F, 0.0F, 0.5F, 1, 1, 9, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F);
      this.bodyModel[6].func_78793_a(0.0F, 3.0F, 0.0F);
      this.bodyModel[6].field_78795_f = -0.80285144F;
      this.bodyModel[6].field_78796_g = -4.712389F;
   }

   private void initbarrelModel_1() {
      this.barrelModel[0] = new ModelRendererTurbo(this, 25, 17, this.textureX, this.textureY);
      this.barrelModel[1] = new ModelRendererTurbo(this, 113, 1, this.textureX, this.textureY);
      this.barrelModel[2] = new ModelRendererTurbo(this, 97, 17, this.textureX, this.textureY);
      this.barrelModel[3] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.barrelModel[4] = new ModelRendererTurbo(this, 33, 25, this.textureX, this.textureY);
      this.barrelModel[5] = new ModelRendererTurbo(this, 65, 25, this.textureX, this.textureY);
      this.barrelModel[6] = new ModelRendererTurbo(this, 97, 25, this.textureX, this.textureY);
      this.barrelModel[7] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
      this.barrelModel[8] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
      this.barrelModel[9] = new ModelRendererTurbo(this, 113, 17, this.textureX, this.textureY);
      this.barrelModel[10] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.barrelModel[11] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
      this.barrelModel[12] = new ModelRendererTurbo(this, 25, 25, this.textureX, this.textureY);
      this.barrelModel[13] = new ModelRendererTurbo(this, 1, 41, this.textureX, this.textureY);
      this.barrelModel[14] = new ModelRendererTurbo(this, 9, 41, this.textureX, this.textureY);
      this.barrelModel[0].func_78790_a(-22.5F, -3.0F, -1.0F, 32, 3, 2, 0.0F);
      this.barrelModel[0].func_78793_a(0.0F, -5.0F, 0.0F);
      this.barrelModel[1].addShapeBox(4.5F, -11.0F, 7.0F, 2, 13, 2, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
      this.barrelModel[1].func_78793_a(0.0F, -5.0F, 0.0F);
      this.barrelModel[2].addShapeBox(4.5F, -11.0F, -9.0F, 2, 13, 2, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
      this.barrelModel[2].func_78793_a(0.0F, -5.0F, 0.0F);
      this.barrelModel[3].addShapeBox(4.0F, -1.5F, 0.0F, 3, 2, 10, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, -1.0F, 0.2F, 0.2F, -1.0F, 0.2F);
      this.barrelModel[3].func_78793_a(0.0F, -5.0F, 0.0F);
      this.barrelModel[4].addShapeBox(4.0F, -1.5F, -10.0F, 3, 2, 10, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, -1.0F, 0.2F, 0.2F, -1.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
      this.barrelModel[4].func_78793_a(0.0F, -5.0F, 0.0F);
      this.barrelModel[5].addShapeBox(4.5F, -3.5F, 7.5F, 1, 1, 11, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, -5.8F, 0.0F, 0.2F, 6.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, -5.8F, 0.0F, 0.2F, 6.2F, 0.0F, 0.2F);
      this.barrelModel[5].func_78793_a(0.0F, -5.0F, 0.0F);
      this.barrelModel[6].addShapeBox(4.5F, -3.5F, -18.5F, 1, 1, 11, 0.0F, 6.2F, 0.0F, 0.2F, -5.8F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 6.2F, 0.0F, 0.2F, -5.8F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
      this.barrelModel[6].func_78793_a(0.0F, -5.0F, 0.0F);
      this.barrelModel[7].addShapeBox(5.0F, -7.5F, 2.0F, 1, 1, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.barrelModel[7].func_78793_a(0.0F, -5.0F, 0.0F);
      this.barrelModel[8].addShapeBox(5.0F, -7.5F, -8.0F, 1, 1, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.barrelModel[8].func_78793_a(0.0F, -5.0F, 0.0F);
      this.barrelModel[9].addShapeBox(5.0F, -9.5F, -2.0F, 1, 1, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.barrelModel[9].func_78793_a(0.0F, -5.0F, 0.0F);
      this.barrelModel[10].addShapeBox(5.0F, -8.5F, -2.99F, 1, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.barrelModel[10].func_78793_a(0.0F, -5.0F, 0.0F);
      this.barrelModel[11].addShapeBox(5.0F, -8.5F, 2.01F, 1, 1, 1, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.barrelModel[11].func_78793_a(0.0F, -5.0F, 0.0F);
      this.barrelModel[12].func_78790_a(-21.5F, -3.5F, -3.0F, 4, 4, 2, 0.0F);
      this.barrelModel[12].func_78793_a(0.0F, -5.0F, 0.0F);
      this.barrelModel[13].func_78790_a(-20.0F, -8.5F, -2.5F, 1, 14, 1, 0.0F);
      this.barrelModel[13].func_78793_a(0.0F, -5.0F, 0.0F);
      this.barrelModel[14].func_78790_a(-26.5F, -2.0F, -2.5F, 14, 1, 1, 0.0F);
      this.barrelModel[14].func_78793_a(0.0F, -5.0F, 0.0F);
   }
}
