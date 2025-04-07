package com.flansmod.client.model.newBombs;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class Modelbomb500kg extends ModelBase {
   int textureX = 128;
   int textureY = 128;
   public ModelRendererTurbo[] bomb500kgModel = new ModelRendererTurbo[14];

   public Modelbomb500kg() {
      this.bomb500kgModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bomb500kgModel[1] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.bomb500kgModel[2] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.bomb500kgModel[3] = new ModelRendererTurbo(this, 73, 1, this.textureX, this.textureY);
      this.bomb500kgModel[4] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.bomb500kgModel[5] = new ModelRendererTurbo(this, 65, 17, this.textureX, this.textureY);
      this.bomb500kgModel[6] = new ModelRendererTurbo(this, 89, 17, this.textureX, this.textureY);
      this.bomb500kgModel[7] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.bomb500kgModel[8] = new ModelRendererTurbo(this, 25, 25, this.textureX, this.textureY);
      this.bomb500kgModel[9] = new ModelRendererTurbo(this, 113, 17, this.textureX, this.textureY);
      this.bomb500kgModel[10] = new ModelRendererTurbo(this, 49, 25, this.textureX, this.textureY);
      this.bomb500kgModel[11] = new ModelRendererTurbo(this, 65, 33, this.textureX, this.textureY);
      this.bomb500kgModel[12] = new ModelRendererTurbo(this, 81, 33, this.textureX, this.textureY);
      this.bomb500kgModel[13] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.bomb500kgModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 5, 17, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb500kgModel[0].func_78793_a(0.0F, 0.0F, 0.5F);
      this.bomb500kgModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 2, 17, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
      this.bomb500kgModel[1].func_78793_a(5.0F, 0.0F, 0.5F);
      this.bomb500kgModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 2, 17, 9, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F);
      this.bomb500kgModel[2].func_78793_a(-2.0F, 0.0F, 0.5F);
      this.bomb500kgModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 2, 5, 9, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, -3.0F, 0.0F, -3.0F, 1.0F, 0.0F, -3.0F, 1.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F);
      this.bomb500kgModel[3].func_78793_a(-2.0F, 17.0F, 0.5F);
      this.bomb500kgModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 5, 5, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -3.0F, -1.0F, 0.0F, -3.0F, -1.0F, 0.0F, -3.0F, -1.0F, 0.0F, -3.0F);
      this.bomb500kgModel[4].func_78793_a(0.0F, 17.0F, 0.5F);
      this.bomb500kgModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 2, 5, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, 1.0F, 0.0F, -3.0F);
      this.bomb500kgModel[5].func_78793_a(5.0F, 17.0F, 0.5F);
      this.bomb500kgModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 2, 8, 9, 0.0F, 2.0F, 0.0F, -4.0F, -4.0F, 0.0F, -4.0F, -4.0F, 0.0F, -4.0F, 2.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
      this.bomb500kgModel[6].func_78793_a(5.0F, -8.0F, 0.5F);
      this.bomb500kgModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 5, 8, 9, 0.0F, -2.0F, 0.0F, -4.0F, -2.0F, 0.0F, -4.0F, -2.0F, 0.0F, -4.0F, -2.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb500kgModel[7].func_78793_a(0.0F, -8.0F, 0.5F);
      this.bomb500kgModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 2, 8, 9, 0.0F, -3.0F, 0.0F, -4.0F, 2.0F, 0.0F, -4.0F, 2.0F, 0.0F, -4.0F, -4.0F, 0.0F, -4.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F);
      this.bomb500kgModel[8].func_78793_a(-2.0F, -8.0F, 0.5F);
      this.bomb500kgModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 1, 12, 6, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 4.0F, 0.0F, -0.25F, 4.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F);
      this.bomb500kgModel[9].func_78793_a(2.0F, -14.0F, 5.0F);
      this.bomb500kgModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 1, 12, 6, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 4.0F, 0.0F, -0.25F, 4.0F, 0.0F);
      this.bomb500kgModel[10].func_78793_a(2.0F, -14.0F, -1.0F);
      this.bomb500kgModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 6, 12, 1, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 4.0F, -0.25F, 0.0F, 4.0F, -0.25F, 0.0F, 0.0F, -0.25F);
      this.bomb500kgModel[11].func_78793_a(-3.5F, -14.0F, 4.5F);
      this.bomb500kgModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 6, 12, 1, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 4.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 4.0F, -0.25F);
      this.bomb500kgModel[12].func_78793_a(2.5F, -14.0F, 4.5F);
      this.bomb500kgModel[13].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, -1.5F, -1.5F, 0.0F, -1.5F, -1.5F, 0.0F, -1.5F, -1.5F, 0.0F, -1.5F);
      this.bomb500kgModel[13].func_78793_a(1.0F, 22.0F, 3.5F);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      for(int i = 0; i < 14; ++i) {
         this.bomb500kgModel[i].func_78785_a(f5);
      }

   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
   }
}
