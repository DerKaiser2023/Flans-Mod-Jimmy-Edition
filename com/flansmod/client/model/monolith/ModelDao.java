package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelDao extends ModelGun {
   int textureX = 32;
   int textureY = 32;

   public ModelDao() {
      this.gunModel = new ModelRendererTurbo[11];
      this.initgunModel_1();
      this.translateAll(0.0F, 0.0F, 0.0F);
      this.flipAll();
   }

   private void initgunModel_1() {
      this.gunModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 9, 1, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 1, 9, this.textureX, this.textureY);
      this.gunModel[5] = new ModelRendererTurbo(this, 17, 9, this.textureX, this.textureY);
      this.gunModel[6] = new ModelRendererTurbo(this, 25, 9, this.textureX, this.textureY);
      this.gunModel[7] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.gunModel[8] = new ModelRendererTurbo(this, 9, 17, this.textureX, this.textureY);
      this.gunModel[9] = new ModelRendererTurbo(this, 17, 17, this.textureX, this.textureY);
      this.gunModel[10] = new ModelRendererTurbo(this, 25, 17, this.textureX, this.textureY);
      this.gunModel[0].addShapeBox(0.0F, 0.0F, -0.65F, 1, 1, 1, 0.0F, 0.0F, -0.25F, 0.5F, 0.0F, -0.25F, 0.5F, 0.0F, -0.1F, -0.5F, 0.0F, -0.1F, -0.5F, 0.0F, -0.25F, 0.5F, 0.0F, -0.25F, 0.5F, 0.0F, -0.15F, -0.5F, 0.0F, -0.15F, -0.5F);
      this.gunModel[0].func_78793_a(0.2F, -3.0F, 0.5F);
      this.gunModel[0].field_78796_g = -1.0471976F;
      this.gunModel[1].addShapeBox(0.0F, 0.0F, -1.15F, 1, 6, 2, 0.0F, -0.45F, 0.5F, -0.5F, -0.45F, 0.5F, -0.5F, -0.45F, 0.5F, -0.5F, -0.45F, 0.5F, -0.5F, -0.45F, 6.0F, -0.5F, -0.45F, 6.0F, -0.5F, -0.45F, 6.0F, -0.5F, -0.45F, 6.0F, -0.5F);
      this.gunModel[1].func_78793_a(0.2F, -14.5F, 0.5F);
      this.gunModel[1].field_78796_g = -1.0471976F;
      this.gunModel[2].addShapeBox(0.0F, 0.0F, -1.15F, 1, 1, 2, 0.0F, -0.45F, -0.2F, -0.45F, -0.45F, -0.2F, -0.45F, -0.45F, -0.2F, -1.5F, -0.45F, -0.2F, -1.5F, -0.45F, 1.0F, -0.5F, -0.45F, 1.0F, -0.5F, -0.45F, 1.0F, -0.5F, -0.45F, 1.0F, -0.5F);
      this.gunModel[2].func_78793_a(0.2F, -17.0F, 0.5F);
      this.gunModel[2].field_78796_g = -1.0471976F;
      this.gunModel[3].addShapeBox(0.0F, 0.0F, -0.65F, 1, 4, 1, 0.0F, -0.1F, 0.2F, -0.1F, -0.1F, 0.2F, -0.1F, -0.1F, 0.2F, -0.1F, -0.1F, 0.2F, -0.1F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F);
      this.gunModel[3].func_78793_a(0.2F, -2.5F, 0.5F);
      this.gunModel[3].field_78796_g = -1.0471976F;
      this.gunModel[4].addShapeBox(0.0F, 0.0F, -0.65F, 1, 1, 1, 0.0F, 0.0F, -0.1F, -0.5F, 0.0F, -0.1F, -0.5F, 0.0F, -0.25F, 0.5F, 0.0F, -0.25F, 0.5F, 0.0F, -0.15F, -0.5F, 0.0F, -0.15F, -0.5F, 0.0F, -0.25F, 0.5F, 0.0F, -0.25F, 0.5F);
      this.gunModel[4].func_78793_a(0.2F, -3.0F, 0.5F);
      this.gunModel[4].field_78796_g = -1.0471976F;
      this.gunModel[5].addShapeBox(0.0F, 1.5F, -0.65F, 1, 1, 1, 0.0F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F);
      this.gunModel[5].func_78793_a(0.2F, 0.5F, 0.5F);
      this.gunModel[5].field_78796_g = -1.0471976F;
      this.gunModel[6].addShapeBox(0.0F, 1.6F, -0.1F, 1, 1, 1, 0.0F, -0.2F, -0.4F, -0.25F, -0.2F, -0.4F, -0.25F, -0.2F, 0.0F, -0.25F, -0.2F, 0.0F, -0.25F, -0.2F, -0.4F, -0.25F, -0.2F, -0.4F, -0.25F, -0.2F, -0.8F, -0.25F, -0.2F, -0.8F, -0.25F);
      this.gunModel[6].func_78793_a(0.2F, 0.4F, 0.5F);
      this.gunModel[6].field_78796_g = -1.0471976F;
      this.gunModel[7].addShapeBox(0.0F, 1.0F, -0.1F, 1, 1, 1, 0.0F, -0.2F, 0.0F, -0.25F, -0.2F, 0.0F, -0.25F, -0.2F, -0.4F, -0.25F, -0.2F, -0.4F, -0.25F, -0.2F, -0.8F, -0.25F, -0.2F, -0.8F, -0.25F, -0.2F, -0.4F, -0.25F, -0.2F, -0.4F, -0.25F);
      this.gunModel[7].func_78793_a(0.2F, 0.5F, 0.5F);
      this.gunModel[7].field_78796_g = -1.0471976F;
      this.gunModel[8].addShapeBox(0.0F, 1.0F, -1.2F, 1, 1, 1, 0.0F, -0.2F, -0.4F, -0.25F, -0.2F, -0.4F, -0.25F, -0.2F, 0.0F, -0.25F, -0.2F, 0.0F, -0.25F, -0.2F, -0.4F, -0.25F, -0.2F, -0.4F, -0.25F, -0.2F, -0.8F, -0.25F, -0.2F, -0.8F, -0.25F);
      this.gunModel[8].func_78793_a(0.2F, 0.5F, 0.5F);
      this.gunModel[8].field_78796_g = -1.0471976F;
      this.gunModel[9].addShapeBox(0.0F, 1.6F, -1.2F, 1, 1, 1, 0.0F, -0.2F, 0.0F, -0.25F, -0.2F, 0.0F, -0.25F, -0.2F, -0.4F, -0.25F, -0.2F, -0.4F, -0.25F, -0.2F, -0.8F, -0.25F, -0.2F, -0.8F, -0.25F, -0.2F, -0.4F, -0.25F, -0.2F, -0.4F, -0.25F);
      this.gunModel[9].func_78793_a(0.2F, 0.4F, 0.5F);
      this.gunModel[9].field_78796_g = -1.0471976F;
      this.gunModel[10].addShapeBox(0.0F, 0.6F, -0.65F, 1, 1, 1, 0.0F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F);
      this.gunModel[10].func_78793_a(0.2F, 0.5F, 0.5F);
      this.gunModel[10].field_78796_g = -1.0471976F;
   }
}
