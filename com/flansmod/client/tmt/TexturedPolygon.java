package com.flansmod.client.tmt;

import java.util.ArrayList;
import net.minecraft.util.Vec3;

public class TexturedPolygon {
   public PositionTextureVertex[] vertexPositions;
   public int nVertices;
   private boolean invertNormal;
   private float[] normals;
   private ArrayList<Vec3> iNormals;

   public TexturedPolygon(PositionTextureVertex[] apositionTexturevertex) {
      this.invertNormal = false;
      this.vertexPositions = apositionTexturevertex;
      this.nVertices = apositionTexturevertex.length;
      this.iNormals = new ArrayList();
      this.normals = new float[0];
   }

   public TexturedPolygon(PositionTextureVertex[] apositionTexturevertex, int par2, int par3, int par4, int par5, float par6, float par7) {
      this(apositionTexturevertex);
      float var8 = 0.0F / par6;
      float var9 = 0.0F / par7;
      apositionTexturevertex[0] = apositionTexturevertex[0].setTexturePosition((float)par4 / par6 - var8, (float)par3 / par7 + var9);
      apositionTexturevertex[1] = apositionTexturevertex[1].setTexturePosition((float)par2 / par6 + var8, (float)par3 / par7 + var9);
      apositionTexturevertex[2] = apositionTexturevertex[2].setTexturePosition((float)par2 / par6 + var8, (float)par5 / par7 - var9);
      apositionTexturevertex[3] = apositionTexturevertex[3].setTexturePosition((float)par4 / par6 - var8, (float)par5 / par7 - var9);
   }

   public void setInvertNormal(boolean isSet) {
      this.invertNormal = isSet;
   }

   public void setNormals(float x, float y, float z) {
      this.normals = new float[]{x, y, z};
   }

   public void flipFace() {
      PositionTextureVertex[] var1 = new PositionTextureVertex[this.vertexPositions.length];

      for(int var2 = 0; var2 < this.vertexPositions.length; ++var2) {
         var1[var2] = this.vertexPositions[this.vertexPositions.length - var2 - 1];
      }

      this.vertexPositions = var1;
   }

   public void setNormals(ArrayList<Vec3> vec) {
      this.iNormals = vec;
   }

   public void draw(TmtTessellator tessellator, float f) {
      if (this.nVertices == 3) {
         tessellator.func_78371_b(4);
      } else if (this.nVertices == 4) {
         tessellator.func_78382_b();
      } else {
         tessellator.func_78371_b(9);
      }

      if (this.iNormals.size() == 0) {
         if (this.normals.length == 3) {
            if (this.invertNormal) {
               tessellator.func_78375_b(-this.normals[0], -this.normals[1], -this.normals[2]);
            } else {
               tessellator.func_78375_b(this.normals[0], this.normals[1], this.normals[2]);
            }
         } else {
            if (this.vertexPositions.length < 3) {
               return;
            }

            Vec3 Vec3 = this.vertexPositions[1].field_78243_a.func_72444_a(this.vertexPositions[0].field_78243_a);
            Vec3 Vec31 = this.vertexPositions[1].field_78243_a.func_72444_a(this.vertexPositions[2].field_78243_a);
            Vec3 Vec32 = Vec31.func_72431_c(Vec3).func_72432_b();
            if (this.invertNormal) {
               tessellator.func_78375_b(-((float)Vec32.field_72450_a), -((float)Vec32.field_72448_b), -((float)Vec32.field_72449_c));
            } else {
               tessellator.func_78375_b((float)Vec32.field_72450_a, (float)Vec32.field_72448_b, (float)Vec32.field_72449_c);
            }
         }
      }

      for(int i = 0; i < this.nVertices; ++i) {
         PositionTextureVertex positionTexturevertex = this.vertexPositions[i];
         if (positionTexturevertex instanceof PositionTransformVertex) {
            ((PositionTransformVertex)positionTexturevertex).setTransformation();
         }

         if (i < this.iNormals.size()) {
            if (this.invertNormal) {
               tessellator.func_78375_b(-((float)((Vec3)this.iNormals.get(i)).field_72450_a), -((float)((Vec3)this.iNormals.get(i)).field_72448_b), -((float)((Vec3)this.iNormals.get(i)).field_72449_c));
            } else {
               tessellator.func_78375_b((float)((Vec3)this.iNormals.get(i)).field_72450_a, (float)((Vec3)this.iNormals.get(i)).field_72448_b, (float)((Vec3)this.iNormals.get(i)).field_72449_c);
            }
         }

         tessellator.addVertexWithUVW((double)((float)positionTexturevertex.field_78243_a.field_72450_a * f), (double)((float)positionTexturevertex.field_78243_a.field_72448_b * f), (double)((float)positionTexturevertex.field_78243_a.field_72449_c * f), (double)positionTexturevertex.field_78241_b, (double)positionTexturevertex.field_78242_c, (double)positionTexturevertex.texturePositionW);
      }

      tessellator.func_78381_a();
   }
}
