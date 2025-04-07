package com.flansmod.client.model.newBombs;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class Modelbomb250kg extends ModelBase {
   int textureX = 128;
   int textureY = 128;
   public ModelRendererTurbo[] bomb250kgModel = new ModelRendererTurbo[13];

   public Modelbomb250kg() {
      this.bomb250kgModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bomb250kgModel[1] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.bomb250kgModel[2] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
      this.bomb250kgModel[3] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
      this.bomb250kgModel[4] = new ModelRendererTurbo(this, 97, 9, this.textureX, this.textureY);
      this.bomb250kgModel[5] = new ModelRendererTurbo(this, 81, 17, this.textureX, this.textureY);
      this.bomb250kgModel[6] = new ModelRendererTurbo(this, 97, 25, this.textureX, this.textureY);
      this.bomb250kgModel[7] = new ModelRendererTurbo(this, 1, 33, this.textureX, this.textureY);
      this.bomb250kgModel[8] = new ModelRendererTurbo(this, 33, 33, this.textureX, this.textureY);
      this.bomb250kgModel[9] = new ModelRendererTurbo(this, 57, 33, this.textureX, this.textureY);
      this.bomb250kgModel[10] = new ModelRendererTurbo(this, 73, 33, this.textureX, this.textureY);
      this.bomb250kgModel[11] = new ModelRendererTurbo(this, 89, 49, this.textureX, this.textureY);
      this.bomb250kgModel[12] = new ModelRendererTurbo(this, 105, 49, this.textureX, this.textureY);
      this.bomb250kgModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 5, 17, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb250kgModel[0].func_78793_a(0.0F, 0.0F, 0.5F);
      this.bomb250kgModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 2, 17, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
      this.bomb250kgModel[1].func_78793_a(5.0F, 0.0F, 0.5F);
      this.bomb250kgModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 2, 17, 9, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F);
      this.bomb250kgModel[2].func_78793_a(-2.0F, 0.0F, 0.5F);
      this.bomb250kgModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 2, 3, 9, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, -3.0F, 0.0F, -3.0F, 1.0F, 0.0F, -3.0F, 1.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F);
      this.bomb250kgModel[3].func_78793_a(-2.0F, 17.0F, 0.5F);
      this.bomb250kgModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 5, 3, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -3.0F, -1.0F, 0.0F, -3.0F, -1.0F, 0.0F, -3.0F, -1.0F, 0.0F, -3.0F);
      this.bomb250kgModel[4].func_78793_a(0.0F, 17.0F, 0.5F);
      this.bomb250kgModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 2, 3, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, 1.0F, 0.0F, -3.0F);
      this.bomb250kgModel[5].func_78793_a(5.0F, 17.0F, 0.5F);
      this.bomb250kgModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 2, 8, 9, 0.0F, 2.0F, 0.0F, -4.0F, -4.0F, 0.0F, -4.0F, -4.0F, 0.0F, -4.0F, 2.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
      this.bomb250kgModel[6].func_78793_a(5.0F, -8.0F, 0.5F);
      this.bomb250kgModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 5, 8, 9, 0.0F, -2.0F, 0.0F, -4.0F, -2.0F, 0.0F, -4.0F, -2.0F, 0.0F, -4.0F, -2.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb250kgModel[7].func_78793_a(0.0F, -8.0F, 0.5F);
      this.bomb250kgModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 2, 8, 9, 0.0F, -4.0F, 0.0F, -4.0F, 2.0F, 0.0F, -4.0F, 2.0F, 0.0F, -4.0F, -4.0F, 0.0F, -4.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F);
      this.bomb250kgModel[8].func_78793_a(-2.0F, -8.0F, 0.5F);
      this.bomb250kgModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 1, 12, 6, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 4.0F, 0.0F, -0.25F, 4.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F);
      this.bomb250kgModel[9].func_78793_a(2.0F, -14.0F, 5.0F);
      this.bomb250kgModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 1, 12, 6, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 4.0F, 0.0F, -0.25F, 4.0F, 0.0F);
      this.bomb250kgModel[10].func_78793_a(2.0F, -14.0F, -1.0F);
      this.bomb250kgModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 6, 12, 1, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 4.0F, -0.25F, 0.0F, 4.0F, -0.25F, 0.0F, 0.0F, -0.25F);
      this.bomb250kgModel[11].func_78793_a(-3.5F, -14.0F, 4.5F);
      this.bomb250kgModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 6, 12, 1, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 4.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 4.0F, -0.25F);
      this.bomb250kgModel[12].func_78793_a(2.5F, -14.0F, 4.5F);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      for(int i = 0; i < 13; ++i) {
         this.bomb250kgModel[i].func_78785_a(f5);
      }

   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
   }
}
