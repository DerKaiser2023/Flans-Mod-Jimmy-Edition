package com.flansmod.client.model.newBombs;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class Modelbomb50kg extends ModelBase {
   int textureX = 64;
   int textureY = 64;
   public ModelRendererTurbo[] bomb50kgModel = new ModelRendererTurbo[13];

   public Modelbomb50kg() {
      this.bomb50kgModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bomb50kgModel[1] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
      this.bomb50kgModel[2] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.bomb50kgModel[3] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.bomb50kgModel[4] = new ModelRendererTurbo(this, 9, 9, this.textureX, this.textureY);
      this.bomb50kgModel[5] = new ModelRendererTurbo(this, 25, 9, this.textureX, this.textureY);
      this.bomb50kgModel[6] = new ModelRendererTurbo(this, 41, 9, this.textureX, this.textureY);
      this.bomb50kgModel[7] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.bomb50kgModel[8] = new ModelRendererTurbo(this, 17, 17, this.textureX, this.textureY);
      this.bomb50kgModel[9] = new ModelRendererTurbo(this, 57, 9, this.textureX, this.textureY);
      this.bomb50kgModel[10] = new ModelRendererTurbo(this, 33, 17, this.textureX, this.textureY);
      this.bomb50kgModel[11] = new ModelRendererTurbo(this, 41, 17, this.textureX, this.textureY);
      this.bomb50kgModel[12] = new ModelRendererTurbo(this, 49, 17, this.textureX, this.textureY);
      this.bomb50kgModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 1, 6, 3, 0.0F);
      this.bomb50kgModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
      this.bomb50kgModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
      this.bomb50kgModel[1].func_78793_a(1.0F, 0.0F, 0.0F);
      this.bomb50kgModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 3, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F);
      this.bomb50kgModel[2].func_78793_a(-1.0F, 0.0F, 0.0F);
      this.bomb50kgModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 5, 3, 0.0F, -0.5F, 0.0F, -1.5F, -0.5F, 0.0F, -1.5F, -0.5F, 0.0F, -1.5F, -0.5F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb50kgModel[3].func_78793_a(0.0F, -5.0F, 0.0F);
      this.bomb50kgModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 5, 3, 0.0F, 0.5F, 0.0F, -1.5F, -1.5F, 0.0F, -1.5F, -1.5F, 0.0F, -1.5F, 0.5F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
      this.bomb50kgModel[4].func_78793_a(1.0F, -5.0F, 0.0F);
      this.bomb50kgModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 5, 3, 0.0F, -1.5F, 0.0F, -1.5F, 0.5F, 0.0F, -1.5F, 0.5F, 0.0F, -1.5F, -1.5F, 0.0F, -1.5F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F);
      this.bomb50kgModel[5].func_78793_a(-1.0F, -5.0F, 0.0F);
      this.bomb50kgModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F);
      this.bomb50kgModel[6].func_78793_a(1.0F, 6.0F, 0.0F);
      this.bomb50kgModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F);
      this.bomb50kgModel[7].func_78793_a(0.0F, 6.0F, 0.0F);
      this.bomb50kgModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F);
      this.bomb50kgModel[8].func_78793_a(-1.0F, 6.0F, 0.0F);
      this.bomb50kgModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 2, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 2.0F, 0.0F, -0.4F, 2.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F);
      this.bomb50kgModel[9].func_78793_a(0.0F, -7.0F, 1.5F);
      this.bomb50kgModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 2, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 2.0F, 0.0F, -0.4F, 2.0F, 0.0F);
      this.bomb50kgModel[10].func_78793_a(0.0F, -7.0F, -0.5F);
      this.bomb50kgModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 2, 6, 1, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 2.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 2.0F, -0.4F);
      this.bomb50kgModel[11].func_78793_a(0.5F, -7.0F, 1.0F);
      this.bomb50kgModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 2, 6, 1, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 2.0F, -0.4F, 0.0F, 2.0F, -0.4F, 0.0F, 0.0F, -0.4F);
      this.bomb50kgModel[12].func_78793_a(-1.5F, -7.0F, 1.0F);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      for(int i = 0; i < 13; ++i) {
         this.bomb50kgModel[i].func_78785_a(f5);
      }

   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
   }
}
