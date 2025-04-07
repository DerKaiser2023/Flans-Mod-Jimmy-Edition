package com.flansmod.common.vector;

import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class Matrix3f {
   float[][] matrix = new float[3][3];

   public Matrix3f(float[][] Matrix) {
      for(int i = 0; i < 3; ++i) {
         System.arraycopy(Matrix[i], 0, this.matrix[i], 0, 3);
      }

   }

   public Matrix3f(float m11, float m12, float m13, float m21, float m22, float m23, float m31, float m32, float m33) {
      this.matrix[0][0] = m11;
      this.matrix[0][1] = m12;
      this.matrix[0][2] = m13;
      this.matrix[1][0] = m21;
      this.matrix[1][1] = m22;
      this.matrix[1][2] = m23;
      this.matrix[2][0] = m31;
      this.matrix[2][1] = m32;
      this.matrix[2][2] = m33;
   }

   public Matrix3f mult(Matrix3f m) {
      return multMatrix(this, m);
   }

   public Vec3 mult(Vec3 v) {
      return multVec(this, v);
   }

   public static Matrix3f getMatrixRotX(float r) {
      float sn = MathHelper.func_76126_a(r);
      float cs = MathHelper.func_76134_b(r);
      return new Matrix3f(new float[][]{{1.0F, 0.0F, 0.0F}, {0.0F, cs, -sn}, {0.0F, sn, cs}});
   }

   public static Matrix3f getMatrixRotY(float r) {
      float sn = MathHelper.func_76126_a(r);
      float cs = MathHelper.func_76134_b(r);
      return new Matrix3f(new float[][]{{cs, 0.0F, sn}, {0.0F, 1.0F, 0.0F}, {-sn, 0.0F, cs}});
   }

   public static Matrix3f getMatrixRotZ(float r) {
      float sn = MathHelper.func_76126_a(r);
      float cs = MathHelper.func_76134_b(r);
      return new Matrix3f(new float[][]{{cs, -sn, 0.0F}, {sn, cs, 0.0F}, {0.0F, 0.0F, 1.0F}});
   }

   public static Vec3 multVec(Matrix3f m, Vec3 vec) {
      float[][] retMat = new float[3][3];
      float[] retVec = new float[3];

      for(int i = 0; i < 3; ++i) {
         float[] row = new float[]{m.matrix[i][0], m.matrix[i][1], m.matrix[i][2]};
         float[] column = new float[]{(float)vec.field_72450_a, (float)vec.field_72448_b, (float)vec.field_72449_c};

         for(int sm = 0; sm < 3; ++sm) {
            retVec[i] += row[sm] * column[sm];
         }
      }

      return Vec3.func_72443_a((double)retVec[0], (double)retVec[1], (double)retVec[2]);
   }

   public static Matrix3f multMatrix(Matrix3f m1, Matrix3f m2) {
      Matrix3f retMat = new Matrix3f(new float[3][3]);

      for(int i = 0; i < 3; ++i) {
         float[] row = new float[]{m1.matrix[i][0], m1.matrix[i][1], m1.matrix[i][2]};

         for(int j = 0; j < 3; ++j) {
            float[] column = new float[]{m2.matrix[0][j], m2.matrix[1][j], m2.matrix[2][j]};

            for(int sm = 0; sm < 3; ++sm) {
               float[] var10000 = retMat.matrix[i];
               var10000[j] += row[sm] * column[sm];
            }
         }
      }

      return retMat;
   }
}
