package com.flansmod.client.model.newBombs;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class Modelbomb1000kg extends ModelBase {
   int textureX = 512;
   int textureY = 512;
   public ModelRendererTurbo[] bomb1000kgModel = new ModelRendererTurbo[44];

   public Modelbomb1000kg() {
      this.bomb1000kgModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bomb1000kgModel[1] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.bomb1000kgModel[2] = new ModelRendererTurbo(this, 65, 1, this.textureX, this.textureY);
      this.bomb1000kgModel[3] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.bomb1000kgModel[4] = new ModelRendererTurbo(this, 129, 1, this.textureX, this.textureY);
      this.bomb1000kgModel[5] = new ModelRendererTurbo(this, 161, 1, this.textureX, this.textureY);
      this.bomb1000kgModel[6] = new ModelRendererTurbo(this, 193, 1, this.textureX, this.textureY);
      this.bomb1000kgModel[7] = new ModelRendererTurbo(this, 225, 1, this.textureX, this.textureY);
      this.bomb1000kgModel[8] = new ModelRendererTurbo(this, 257, 1, this.textureX, this.textureY);
      this.bomb1000kgModel[9] = new ModelRendererTurbo(this, 289, 1, this.textureX, this.textureY);
      this.bomb1000kgModel[10] = new ModelRendererTurbo(this, 321, 1, this.textureX, this.textureY);
      this.bomb1000kgModel[11] = new ModelRendererTurbo(this, 353, 1, this.textureX, this.textureY);
      this.bomb1000kgModel[12] = new ModelRendererTurbo(this, 385, 1, this.textureX, this.textureY);
      this.bomb1000kgModel[13] = new ModelRendererTurbo(this, 417, 1, this.textureX, this.textureY);
      this.bomb1000kgModel[14] = new ModelRendererTurbo(this, 449, 1, this.textureX, this.textureY);
      this.bomb1000kgModel[15] = new ModelRendererTurbo(this, 481, 1, this.textureX, this.textureY);
      this.bomb1000kgModel[16] = new ModelRendererTurbo(this, 257, 25, this.textureX, this.textureY);
      this.bomb1000kgModel[17] = new ModelRendererTurbo(this, 289, 25, this.textureX, this.textureY);
      this.bomb1000kgModel[18] = new ModelRendererTurbo(this, 321, 25, this.textureX, this.textureY);
      this.bomb1000kgModel[19] = new ModelRendererTurbo(this, 353, 25, this.textureX, this.textureY);
      this.bomb1000kgModel[20] = new ModelRendererTurbo(this, 385, 25, this.textureX, this.textureY);
      this.bomb1000kgModel[21] = new ModelRendererTurbo(this, 417, 25, this.textureX, this.textureY);
      this.bomb1000kgModel[22] = new ModelRendererTurbo(this, 449, 25, this.textureX, this.textureY);
      this.bomb1000kgModel[23] = new ModelRendererTurbo(this, 481, 25, this.textureX, this.textureY);
      this.bomb1000kgModel[24] = new ModelRendererTurbo(this, 1, 41, this.textureX, this.textureY);
      this.bomb1000kgModel[25] = new ModelRendererTurbo(this, 49, 25, this.textureX, this.textureY);
      this.bomb1000kgModel[26] = new ModelRendererTurbo(this, 81, 25, this.textureX, this.textureY);
      this.bomb1000kgModel[27] = new ModelRendererTurbo(this, 25, 41, this.textureX, this.textureY);
      this.bomb1000kgModel[28] = new ModelRendererTurbo(this, 105, 41, this.textureX, this.textureY);
      this.bomb1000kgModel[29] = new ModelRendererTurbo(this, 121, 41, this.textureX, this.textureY);
      this.bomb1000kgModel[30] = new ModelRendererTurbo(this, 137, 41, this.textureX, this.textureY);
      this.bomb1000kgModel[31] = new ModelRendererTurbo(this, 153, 41, this.textureX, this.textureY);
      this.bomb1000kgModel[32] = new ModelRendererTurbo(this, 281, 17, this.textureX, this.textureY);
      this.bomb1000kgModel[33] = new ModelRendererTurbo(this, 73, 41, this.textureX, this.textureY);
      this.bomb1000kgModel[34] = new ModelRendererTurbo(this, 169, 41, this.textureX, this.textureY);
      this.bomb1000kgModel[35] = new ModelRendererTurbo(this, 185, 41, this.textureX, this.textureY);
      this.bomb1000kgModel[36] = new ModelRendererTurbo(this, 313, 17, this.textureX, this.textureY);
      this.bomb1000kgModel[37] = new ModelRendererTurbo(this, 193, 41, this.textureX, this.textureY);
      this.bomb1000kgModel[38] = new ModelRendererTurbo(this, 209, 41, this.textureX, this.textureY);
      this.bomb1000kgModel[39] = new ModelRendererTurbo(this, 345, 17, this.textureX, this.textureY);
      this.bomb1000kgModel[40] = new ModelRendererTurbo(this, 377, 17, this.textureX, this.textureY);
      this.bomb1000kgModel[41] = new ModelRendererTurbo(this, 217, 41, this.textureX, this.textureY);
      this.bomb1000kgModel[42] = new ModelRendererTurbo(this, 225, 41, this.textureX, this.textureY);
      this.bomb1000kgModel[43] = new ModelRendererTurbo(this, 241, 41, this.textureX, this.textureY);
      this.bomb1000kgModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 6, 27, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[0].func_78793_a(0.0F, -23.0F, 6.0F);
      this.bomb1000kgModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 6, 27, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[1].func_78793_a(0.0F, -23.0F, -6.0F);
      this.bomb1000kgModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 6, 27, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[2].func_78793_a(6.0F, -23.0F, 0.0F);
      this.bomb1000kgModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 6, 27, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[3].func_78793_a(-6.0F, -23.0F, 0.0F);
      this.bomb1000kgModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 6, 27, 6, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[4].func_78793_a(-6.0F, -23.0F, -6.0F);
      this.bomb1000kgModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 6, 27, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F);
      this.bomb1000kgModel[5].func_78793_a(-6.0F, -23.0F, 6.0F);
      this.bomb1000kgModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 6, 27, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[6].func_78793_a(6.0F, -23.0F, 6.0F);
      this.bomb1000kgModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 6, 27, 6, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[7].func_78793_a(6.0F, -23.0F, -6.0F);
      this.bomb1000kgModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 6, 11, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 3.0F, -2.0F, 0.0F, 3.0F, -2.0F, 0.0F, -8.0F, -2.0F, 0.0F, -8.0F);
      this.bomb1000kgModel[8].func_78793_a(0.0F, 4.0F, 6.0F);
      this.bomb1000kgModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 6, 11, 6, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -8.0F, 0.0F, -8.0F, 2.0F, 0.0F, -8.0F, 2.0F, 0.0F, 2.0F, -8.0F, 0.0F, 2.0F);
      this.bomb1000kgModel[9].func_78793_a(-6.0F, 4.0F, -6.0F);
      this.bomb1000kgModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 6, 11, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, -8.0F, 0.0F, 2.0F, 2.0F, 0.0F, 2.0F, 2.0F, 0.0F, -8.0F, -8.0F, 0.0F, -8.0F);
      this.bomb1000kgModel[10].func_78793_a(-6.0F, 4.0F, 6.0F);
      this.bomb1000kgModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 6, 11, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -8.0F, -2.0F, 0.0F, -8.0F, -2.0F, 0.0F, 3.0F, -2.0F, 0.0F, 3.0F);
      this.bomb1000kgModel[11].func_78793_a(0.0F, 4.0F, -6.0F);
      this.bomb1000kgModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 6, 11, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -8.0F, 0.0F, -2.0F, 3.0F, 0.0F, -2.0F, 3.0F, 0.0F, -2.0F, -8.0F, 0.0F, -2.0F);
      this.bomb1000kgModel[12].func_78793_a(-6.0F, 4.0F, 0.0F);
      this.bomb1000kgModel[13].addShapeBox(0.0F, 0.0F, 0.0F, 6, 11, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 0.0F, -2.0F, -8.0F, 0.0F, -2.0F, -8.0F, 0.0F, -2.0F, 3.0F, 0.0F, -2.0F);
      this.bomb1000kgModel[13].func_78793_a(6.0F, 4.0F, 0.0F);
      this.bomb1000kgModel[14].addShapeBox(0.0F, 0.0F, 0.0F, 6, 11, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, -8.0F, 0.0F, 2.0F, -8.0F, 0.0F, -8.0F, 2.0F, 0.0F, -8.0F);
      this.bomb1000kgModel[14].func_78793_a(6.0F, 4.0F, 6.0F);
      this.bomb1000kgModel[15].addShapeBox(0.0F, 0.0F, 0.0F, 6, 11, 6, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, -8.0F, -8.0F, 0.0F, -8.0F, -8.0F, 0.0F, 2.0F, 2.0F, 0.0F, 2.0F);
      this.bomb1000kgModel[15].func_78793_a(6.0F, 4.0F, -6.0F);
      this.bomb1000kgModel[16].addShapeBox(0.0F, 0.0F, 0.0F, 6, 25, 6, 0.0F, 2.0F, 0.0F, 2.0F, -8.0F, 0.0F, 2.0F, -8.0F, 0.0F, -8.0F, 2.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[16].func_78793_a(6.0F, -48.0F, 6.0F);
      this.bomb1000kgModel[17].addShapeBox(0.0F, 0.0F, 0.0F, 6, 25, 6, 0.0F, 2.0F, 0.0F, -8.0F, -8.0F, 0.0F, -8.0F, -8.0F, 0.0F, 2.0F, 2.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[17].func_78793_a(6.0F, -48.0F, -6.0F);
      this.bomb1000kgModel[18].addShapeBox(0.0F, 0.0F, 0.0F, 6, 25, 6, 0.0F, -2.0F, 0.0F, 3.0F, -2.0F, 0.0F, 3.0F, -2.0F, 0.0F, -8.0F, -2.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[18].func_78793_a(0.0F, -48.0F, 6.0F);
      this.bomb1000kgModel[19].addShapeBox(0.0F, 0.0F, 0.0F, 6, 25, 6, 0.0F, 3.0F, 0.0F, -2.0F, -8.0F, 0.0F, -2.0F, -8.0F, 0.0F, -2.0F, 3.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[19].func_78793_a(6.0F, -48.0F, 0.0F);
      this.bomb1000kgModel[20].addShapeBox(0.0F, 0.0F, 0.0F, 6, 25, 6, 0.0F, -8.0F, 0.0F, 2.0F, 2.0F, 0.0F, 2.0F, 2.0F, 0.0F, -8.0F, -8.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F);
      this.bomb1000kgModel[20].func_78793_a(-6.0F, -48.0F, 6.0F);
      this.bomb1000kgModel[21].addShapeBox(0.0F, 0.0F, 0.0F, 6, 25, 6, 0.0F, -8.0F, 0.0F, -2.0F, 3.0F, 0.0F, -2.0F, 3.0F, 0.0F, -2.0F, -8.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[21].func_78793_a(-6.0F, -48.0F, 0.0F);
      this.bomb1000kgModel[22].addShapeBox(0.0F, 0.0F, 0.0F, 6, 25, 6, 0.0F, -8.0F, 0.0F, -8.0F, 2.0F, 0.0F, -8.0F, 2.0F, 0.0F, 2.0F, -8.0F, 0.0F, 2.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[22].func_78793_a(-6.0F, -48.0F, -6.0F);
      this.bomb1000kgModel[23].addShapeBox(0.0F, 0.0F, 0.0F, 6, 25, 6, 0.0F, -2.0F, 0.0F, -8.0F, -2.0F, 0.0F, -8.0F, -2.0F, 0.0F, 3.0F, -2.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[23].func_78793_a(0.0F, -48.0F, -6.0F);
      this.bomb1000kgModel[24].addShapeBox(0.0F, 0.0F, 0.0F, 10, 30, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 0.0F, 0.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[24].func_78793_a(-7.0F, -55.0F, 2.5F);
      this.bomb1000kgModel[25].addShapeBox(0.0F, 0.0F, 0.0F, 1, 30, 10, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 0.0F, 0.0F, 6.0F, 0.0F);
      this.bomb1000kgModel[25].func_78793_a(2.5F, -55.0F, -7.0F);
      this.bomb1000kgModel[26].addShapeBox(0.0F, 0.0F, 0.0F, 1, 30, 10, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 0.0F, 0.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[26].func_78793_a(2.5F, -55.0F, 3.0F);
      this.bomb1000kgModel[27].addShapeBox(0.0F, 0.0F, 0.0F, 10, 30, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 0.0F);
      this.bomb1000kgModel[27].func_78793_a(3.0F, -55.0F, 2.5F);
      this.bomb1000kgModel[28].addShapeBox(0.0F, 0.0F, 0.0F, 6, 6, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[28].func_78793_a(0.0F, -58.0F, -7.0F);
      this.bomb1000kgModel[29].addShapeBox(0.0F, 0.0F, 0.0F, 4, 6, 1, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F);
      this.bomb1000kgModel[29].func_78793_a(-4.0F, -58.0F, -7.0F);
      this.bomb1000kgModel[30].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[30].func_78793_a(-7.0F, -58.0F, 0.0F);
      this.bomb1000kgModel[31].addShapeBox(0.0F, 0.0F, 0.0F, 6, 6, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[31].func_78793_a(0.0F, -58.0F, 12.0F);
      this.bomb1000kgModel[32].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 4, 0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[32].func_78793_a(-7.0F, -58.0F, -4.0F);
      this.bomb1000kgModel[33].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[33].func_78793_a(-5.0F, -58.0F, -5.0F);
      this.bomb1000kgModel[34].addShapeBox(0.0F, 0.0F, 0.0F, 4, 6, 1, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F);
      this.bomb1000kgModel[34].func_78793_a(-4.0F, -58.0F, 12.0F);
      this.bomb1000kgModel[35].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[35].func_78793_a(-5.0F, -58.0F, 10.0F);
      this.bomb1000kgModel[36].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[36].func_78793_a(-7.0F, -58.0F, 6.0F);
      this.bomb1000kgModel[37].addShapeBox(0.0F, 0.0F, 0.0F, 4, 6, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[37].func_78793_a(6.0F, -58.0F, 12.0F);
      this.bomb1000kgModel[38].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[38].func_78793_a(10.0F, -58.0F, 10.0F);
      this.bomb1000kgModel[39].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[39].func_78793_a(12.0F, -58.0F, 6.0F);
      this.bomb1000kgModel[40].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 4, 0.0F, 2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[40].func_78793_a(12.0F, -58.0F, -4.0F);
      this.bomb1000kgModel[41].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[41].func_78793_a(10.0F, -58.0F, -5.0F);
      this.bomb1000kgModel[42].addShapeBox(0.0F, 0.0F, 0.0F, 4, 6, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[42].func_78793_a(6.0F, -58.0F, -7.0F);
      this.bomb1000kgModel[43].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.bomb1000kgModel[43].func_78793_a(12.0F, -58.0F, 0.0F);
   }

   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      for(int i = 0; i < 44; ++i) {
         this.bomb1000kgModel[i].func_78785_a(f5);
      }

   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
   }
}
