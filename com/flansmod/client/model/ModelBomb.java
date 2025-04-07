package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelBomb extends ModelBase {
   public ModelRendererTurbo[] bombModel = new ModelRendererTurbo[4];

   public ModelBomb() {
      this.bombModel[0] = new ModelRendererTurbo(this, 104, 0, 128, 64);
      this.bombModel[1] = new ModelRendererTurbo(this, 104, 0, 128, 64);
      this.bombModel[2] = new ModelRendererTurbo(this, 56, 8, 128, 64);
      this.bombModel[3] = new ModelRendererTurbo(this, 56, 8, 128, 64);
      this.bombModel[0].addTrapezoid(-2.0F, 0.0F, -2.0F, 4, 1, 4, 0.0F, 1.0F, 4);
      this.bombModel[1].func_78790_a(-2.0F, 1.0F, -2.0F, 4, 6, 4, 0.0F);
      this.bombModel[2].addTrapezoid(-2.0F, 7.0F, -2.0F, 4, 1, 4, 0.0F, 1.0F, 5);
      this.bombModel[3].func_78790_a(-2.0F, 8.0F, -2.0F, 4, 2, 4, 0.0F);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      for(int i = 0; i < 4; ++i) {
         this.bombModel[i].func_78785_a(f5);
      }

   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
   }
}
