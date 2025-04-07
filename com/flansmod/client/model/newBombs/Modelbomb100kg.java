package com.flansmod.client.model.newBombs;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class Modelbomb100kg extends ModelBase {
   int textureX = 128;
   int textureY = 128;
   public ModelRendererTurbo[] bomb100kgModel = new ModelRendererTurbo[13];

   public Modelbomb100kg() {
      this.bomb100kgModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bomb100kgModel[1] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.bomb100kgModel[2] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.bomb100kgModel[3] = new ModelRendererTurbo(this, 73, 1, this.textureX, this.textureY);
      this.bomb100kgModel[4] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.bomb100kgModel[5] = new ModelRendererTurbo(this, 65, 17, this.textureX, this.textureY);
      this.bomb100kgModel[6] = new ModelRendererTurbo(this, 89, 17, this.textureX, this.textureY);
      this.bomb100kgModel[7] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.bomb100kgModel[8] = new ModelRendererTurbo(this, 25, 25, this.textureX, this.textureY);
      this.bomb100kgModel[9] = new ModelRendererTurbo(this, 113, 17, this.textureX, this.textureY);
      this.bomb100kgModel[10] = new ModelRendererTurbo(this, 49, 25, this.textureX, this.textureY);
      this.bomb100kgModel[11] = new ModelRendererTurbo(this, 65, 33, this.textureX, this.textureY);
      this.bomb100kgModel[12] = new ModelRendererTurbo(this, 81, 33, this.textureX, this.textureY);
      this.bomb100kgModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 2, 11, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb100kgModel[0].func_78793_a(0.0F, 0.0F, 0.5F);
      this.bomb100kgModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 2, 11, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
      this.bomb100kgModel[1].func_78793_a(2.0F, 0.0F, 0.5F);
      this.bomb100kgModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 2, 11, 6, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F);
      this.bomb100kgModel[2].func_78793_a(-2.0F, 0.0F, 0.5F);
      this.bomb100kgModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 2, 3, 6, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F);
      this.bomb100kgModel[3].func_78793_a(-2.0F, 11.0F, 0.5F);
      this.bomb100kgModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 2, 3, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F);
      this.bomb100kgModel[4].func_78793_a(0.0F, 11.0F, 0.5F);
      this.bomb100kgModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 2, 3, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F);
      this.bomb100kgModel[5].func_78793_a(2.0F, 11.0F, 0.5F);
      this.bomb100kgModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 2, 8, 6, 0.0F, 1.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, 1.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
      this.bomb100kgModel[6].func_78793_a(2.0F, -8.0F, 0.5F);
      this.bomb100kgModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 2, 8, 6, 0.0F, -1.0F, 0.0F, -3.0F, -1.0F, 0.0F, -3.0F, -1.0F, 0.0F, -3.0F, -1.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb100kgModel[7].func_78793_a(0.0F, -8.0F, 0.5F);
      this.bomb100kgModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 2, 8, 6, 0.0F, -3.0F, 0.0F, -3.0F, 1.0F, 0.0F, -3.0F, 1.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F);
      this.bomb100kgModel[8].func_78793_a(-2.0F, -8.0F, 0.5F);
      this.bomb100kgModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 1, 9, 3, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 2.0F, 0.0F, -0.25F, 2.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F);
      this.bomb100kgModel[9].func_78793_a(0.5F, -11.0F, 3.5F);
      this.bomb100kgModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 1, 9, 3, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 2.0F, 0.0F, -0.25F, 2.0F, 0.0F);
      this.bomb100kgModel[10].func_78793_a(0.5F, -11.0F, 0.5F);
      this.bomb100kgModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 3, 9, 1, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 2.0F, -0.25F, 0.0F, 2.0F, -0.25F, 0.0F, 0.0F, -0.25F);
      this.bomb100kgModel[11].func_78793_a(-2.0F, -11.0F, 3.0F);
      this.bomb100kgModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 3, 9, 1, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 2.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 2.0F, -0.25F);
      this.bomb100kgModel[12].func_78793_a(1.0F, -11.0F, 3.0F);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      for(int i = 0; i < 13; ++i) {
         this.bomb100kgModel[i].func_78785_a(f5);
      }

   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
   }
}
