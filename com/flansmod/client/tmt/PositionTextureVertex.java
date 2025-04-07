package com.flansmod.client.tmt;

import net.minecraft.util.Vec3;

public class PositionTextureVertex extends net.minecraft.client.model.PositionTextureVertex {
   public float texturePositionW;

   public PositionTextureVertex(float par1, float par2, float par3, float par4, float par5) {
      this(par1, par2, par3, par4, par5, 1.0F);
   }

   public PositionTextureVertex(float par1, float par2, float par3, float par4, float par5, float par6) {
      this(Vec3.func_72443_a((double)par1, (double)par2, (double)par3), par4, par5);
   }

   public PositionTextureVertex setTexturePosition(float par1, float par2) {
      return new PositionTextureVertex(this, par1, par2, 1.0F);
   }

   public PositionTextureVertex setTexturePosition(float par1, float par2, float q) {
      return new PositionTextureVertex(this, par1, par2, q);
   }

   public PositionTextureVertex(PositionTextureVertex par1PositionTextureVertex, float par2, float par3) {
      this(par1PositionTextureVertex, par2, par3, 1.0F);
   }

   public PositionTextureVertex(PositionTextureVertex par1PositionTextureVertex, float par2, float par3, float q) {
      super(par1PositionTextureVertex, par2, par3);
      this.texturePositionW = 1.0F;
      this.texturePositionW = q;
   }

   public PositionTextureVertex(Vec3 par1Vec3, float par2, float par3) {
      this(par1Vec3, par2, par3, 1.0F);
   }

   public PositionTextureVertex(Vec3 par1Vec3, float par2, float par3, float par4) {
      super(par1Vec3, par2, par3);
      this.texturePositionW = 1.0F;
      this.texturePositionW = par4;
   }
}
