package com.flansmod.client.tmt;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.ARBBufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

@SideOnly(Side.CLIENT)
public class TmtTessellator extends Tessellator {
   private static int nativeBufferSize = 2097152;
   private static int trivertsInBuffer;
   public static boolean renderingWorldRenderer;
   public boolean defaultTexture = false;
   private int rawBufferSize = 0;
   public int textureID = 0;
   private static boolean convertQuadsToTriangles;
   private static boolean tryVBO;
   private static ByteBuffer byteBuffer;
   private static IntBuffer intBuffer;
   private static FloatBuffer floatBuffer;
   private static ShortBuffer shortBuffer;
   private int[] rawBuffer;
   private int vertexCount = 0;
   private double textureU;
   private double textureV;
   private double textureW;
   private int brightness;
   private int color;
   private boolean hasColor = false;
   private boolean hasTexture = false;
   private boolean hasBrightness = false;
   private boolean hasNormals = false;
   private int rawBufferIndex = 0;
   private int addedVertices = 0;
   private boolean isColorDisabled = false;
   public int field_78409_u;
   public double field_78408_v;
   public double field_78407_w;
   public double field_78417_x;
   private int normal;
   public static TmtTessellator instance;
   public boolean field_78415_z = false;
   private static boolean useVBO;
   private static IntBuffer vertexBuffers;
   private int vboIndex = 0;
   private static int vboCount;
   private int bufferSize;

   private TmtTessellator(int par1) {
   }

   public TmtTessellator() {
   }

   public int func_78381_a() {
      if (!this.field_78415_z) {
         throw new IllegalStateException("Not tesselating!");
      } else {
         this.field_78415_z = false;
         int offs = 0;

         int vtc;
         while(offs < this.vertexCount) {
            int vtc = false;
            if (this.field_78409_u == 7 && convertQuadsToTriangles) {
               vtc = Math.min(this.vertexCount - offs, trivertsInBuffer);
            } else {
               vtc = Math.min(this.vertexCount - offs, nativeBufferSize >> 5);
            }

            intBuffer.clear();
            intBuffer.put(this.rawBuffer, offs * 10, vtc * 10);
            byteBuffer.position(0);
            byteBuffer.limit(vtc * 40);
            offs += vtc;
            if (useVBO) {
               this.vboIndex = (this.vboIndex + 1) % vboCount;
               ARBBufferObject.glBindBufferARB(34962, vertexBuffers.get(this.vboIndex));
               ARBBufferObject.glBufferDataARB(34962, byteBuffer, 35040);
            }

            if (this.hasTexture) {
               if (useVBO) {
                  GL11.glTexCoordPointer(4, 5126, 40, 12L);
               } else {
                  floatBuffer.position(3);
                  GL11.glTexCoordPointer(4, 40, floatBuffer);
               }

               GL11.glEnableClientState(32888);
            }

            if (this.hasBrightness) {
               OpenGlHelper.func_77472_b(OpenGlHelper.field_77476_b);
               if (useVBO) {
                  GL11.glTexCoordPointer(2, 5122, 40, 36L);
               } else {
                  shortBuffer.position(18);
                  GL11.glTexCoordPointer(2, 40, shortBuffer);
               }

               GL11.glEnableClientState(32888);
               OpenGlHelper.func_77472_b(OpenGlHelper.field_77478_a);
            }

            if (this.hasColor) {
               if (useVBO) {
                  GL11.glColorPointer(4, 5121, 40, 28L);
               } else {
                  byteBuffer.position(28);
                  GL11.glColorPointer(4, true, 40, byteBuffer);
               }

               GL11.glEnableClientState(32886);
            }

            if (this.hasNormals) {
               if (useVBO) {
                  GL11.glNormalPointer(5121, 40, 32L);
               } else {
                  byteBuffer.position(32);
                  GL11.glNormalPointer(40, byteBuffer);
               }

               GL11.glEnableClientState(32885);
            }

            if (useVBO) {
               GL11.glVertexPointer(3, 5126, 40, 0L);
            } else {
               floatBuffer.position(0);
               GL11.glVertexPointer(3, 40, floatBuffer);
            }

            GL11.glEnableClientState(32884);
            if (this.field_78409_u == 7 && convertQuadsToTriangles) {
               GL11.glDrawArrays(4, 0, vtc);
            } else {
               GL11.glDrawArrays(this.field_78409_u, 0, vtc);
            }

            GL11.glDisableClientState(32884);
            if (this.hasTexture) {
               GL11.glDisableClientState(32888);
            }

            if (this.hasBrightness) {
               OpenGlHelper.func_77472_b(OpenGlHelper.field_77476_b);
               GL11.glDisableClientState(32888);
               OpenGlHelper.func_77472_b(OpenGlHelper.field_77478_a);
            }

            if (this.hasColor) {
               GL11.glDisableClientState(32886);
            }

            if (this.hasNormals) {
               GL11.glDisableClientState(32885);
            }
         }

         if (this.rawBufferSize > 131072 && this.rawBufferIndex < this.rawBufferSize << 3) {
            this.rawBufferSize = 0;
            this.rawBuffer = null;
         }

         vtc = this.rawBufferIndex * 4;
         this.reset();
         return vtc;
      }
   }

   private void reset() {
      this.vertexCount = 0;
      byteBuffer.clear();
      this.rawBufferIndex = 0;
      this.addedVertices = 0;
   }

   public void func_78382_b() {
      this.func_78371_b(7);
   }

   public void func_78371_b(int par1) {
      if (this.field_78415_z) {
         throw new IllegalStateException("Already tesselating!");
      } else {
         this.field_78415_z = true;
         this.reset();
         this.field_78409_u = par1;
         this.hasNormals = false;
         this.hasColor = false;
         this.hasTexture = false;
         this.hasBrightness = false;
         this.isColorDisabled = false;
      }
   }

   public void func_78385_a(double par1, double par3) {
      this.hasTexture = true;
      this.textureU = par1;
      this.textureV = par3;
      this.textureW = 1.0D;
   }

   public void setTextureUVW(double par1, double par3, double par4) {
      this.hasTexture = true;
      this.textureU = par1;
      this.textureV = par3;
      this.textureW = par4;
   }

   public void func_78380_c(int par1) {
      this.hasBrightness = true;
      this.brightness = par1;
   }

   public void func_78386_a(float par1, float par2, float par3) {
      this.func_78376_a((int)(par1 * 255.0F), (int)(par2 * 255.0F), (int)(par3 * 255.0F));
   }

   public void func_78369_a(float par1, float par2, float par3, float par4) {
      this.func_78370_a((int)(par1 * 255.0F), (int)(par2 * 255.0F), (int)(par3 * 255.0F), (int)(par4 * 255.0F));
   }

   public void func_78376_a(int par1, int par2, int par3) {
      this.func_78370_a(par1, par2, par3, 255);
   }

   public void func_78370_a(int par1, int par2, int par3, int par4) {
      if (!this.isColorDisabled) {
         if (par1 > 255) {
            par1 = 255;
         }

         if (par2 > 255) {
            par2 = 255;
         }

         if (par3 > 255) {
            par3 = 255;
         }

         if (par4 > 255) {
            par4 = 255;
         }

         if (par1 < 0) {
            par1 = 0;
         }

         if (par2 < 0) {
            par2 = 0;
         }

         if (par3 < 0) {
            par3 = 0;
         }

         if (par4 < 0) {
            par4 = 0;
         }

         this.hasColor = true;
         if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            this.color = par4 << 24 | par3 << 16 | par2 << 8 | par1;
         } else {
            this.color = par1 << 24 | par2 << 16 | par3 << 8 | par4;
         }
      }

   }

   public void func_78374_a(double par1, double par3, double par5, double par7, double par9) {
      this.func_78385_a(par7, par9);
      this.func_78377_a(par1, par3, par5);
   }

   public void addVertexWithUVW(double par1, double par3, double par5, double par7, double par9, double par10) {
      this.setTextureUVW(par7, par9, par10);
      this.func_78377_a(par1, par3, par5);
   }

   public void func_78377_a(double par1, double par3, double par5) {
      if (this.rawBufferIndex >= this.rawBufferSize - 40) {
         if (this.rawBufferSize == 0) {
            this.rawBufferSize = 65536;
            this.rawBuffer = new int[this.rawBufferSize];
         } else {
            this.rawBufferSize *= 2;
            this.rawBuffer = Arrays.copyOf(this.rawBuffer, this.rawBufferSize);
         }
      }

      ++this.addedVertices;
      if (this.field_78409_u == 7 && convertQuadsToTriangles && this.addedVertices % 4 == 0) {
         for(int var7 = 0; var7 < 2; ++var7) {
            int var8 = 10 * (3 - var7);
            if (this.hasTexture) {
               this.rawBuffer[this.rawBufferIndex + 3] = this.rawBuffer[this.rawBufferIndex - var8 + 3];
               this.rawBuffer[this.rawBufferIndex + 4] = this.rawBuffer[this.rawBufferIndex - var8 + 4];
               this.rawBuffer[this.rawBufferIndex + 5] = this.rawBuffer[this.rawBufferIndex - var8 + 5];
               this.rawBuffer[this.rawBufferIndex + 6] = this.rawBuffer[this.rawBufferIndex - var8 + 6];
            }

            if (this.hasBrightness) {
               this.rawBuffer[this.rawBufferIndex + 9] = this.rawBuffer[this.rawBufferIndex - var8 + 9];
            }

            if (this.hasColor) {
               this.rawBuffer[this.rawBufferIndex + 7] = this.rawBuffer[this.rawBufferIndex - var8 + 7];
            }

            this.rawBuffer[this.rawBufferIndex] = this.rawBuffer[this.rawBufferIndex - var8];
            this.rawBuffer[this.rawBufferIndex + 1] = this.rawBuffer[this.rawBufferIndex - var8 + 1];
            this.rawBuffer[this.rawBufferIndex + 2] = this.rawBuffer[this.rawBufferIndex - var8 + 2];
            ++this.vertexCount;
            this.rawBufferIndex += 10;
         }
      }

      if (this.hasTexture) {
         this.rawBuffer[this.rawBufferIndex + 3] = Float.floatToRawIntBits((float)this.textureU);
         this.rawBuffer[this.rawBufferIndex + 4] = Float.floatToRawIntBits((float)this.textureV);
         this.rawBuffer[this.rawBufferIndex + 5] = Float.floatToRawIntBits(0.0F);
         this.rawBuffer[this.rawBufferIndex + 6] = Float.floatToRawIntBits((float)this.textureW);
      }

      if (this.hasBrightness) {
         this.rawBuffer[this.rawBufferIndex + 9] = this.brightness;
      }

      if (this.hasColor) {
         this.rawBuffer[this.rawBufferIndex + 7] = this.color;
      }

      if (this.hasNormals) {
         this.rawBuffer[this.rawBufferIndex + 8] = this.normal;
      }

      this.rawBuffer[this.rawBufferIndex] = Float.floatToRawIntBits((float)(par1 + this.field_78408_v));
      this.rawBuffer[this.rawBufferIndex + 1] = Float.floatToRawIntBits((float)(par3 + this.field_78407_w));
      this.rawBuffer[this.rawBufferIndex + 2] = Float.floatToRawIntBits((float)(par5 + this.field_78417_x));
      this.rawBufferIndex += 10;
      ++this.vertexCount;
   }

   public void func_78378_d(int par1) {
      int j = par1 >> 16 & 255;
      int k = par1 >> 8 & 255;
      int l = par1 & 255;
      this.func_78376_a(j, k, l);
   }

   public void func_78384_a(int par1, int par2) {
      int k = par1 >> 16 & 255;
      int l = par1 >> 8 & 255;
      int i1 = par1 & 255;
      this.func_78370_a(k, l, i1, par2);
   }

   public void func_78383_c() {
      this.isColorDisabled = true;
   }

   public void func_78375_b(float par1, float par2, float par3) {
      this.hasNormals = true;
      byte b0 = (byte)((int)(par1 * 127.0F));
      byte b1 = (byte)((int)(par2 * 127.0F));
      byte b2 = (byte)((int)(par3 * 127.0F));
      this.normal = b0 & 255 | (b1 & 255) << 8 | (b2 & 255) << 16;
   }

   public void func_78373_b(double par1, double par3, double par5) {
      this.field_78408_v = par1;
      this.field_78407_w = par3;
      this.field_78417_x = par5;
   }

   public void func_78372_c(float par1, float par2, float par3) {
      this.field_78408_v += (double)par1;
      this.field_78407_w += (double)par2;
      this.field_78417_x += (double)par3;
   }

   static {
      trivertsInBuffer = nativeBufferSize / 48 * 6;
      renderingWorldRenderer = false;
      convertQuadsToTriangles = false;
      tryVBO = false;
      byteBuffer = GLAllocation.func_74524_c(nativeBufferSize * 4);
      intBuffer = byteBuffer.asIntBuffer();
      floatBuffer = byteBuffer.asFloatBuffer();
      shortBuffer = byteBuffer.asShortBuffer();
      instance = new TmtTessellator(2097152);
      useVBO = false;
      vboCount = 10;
      instance.defaultTexture = true;
      useVBO = tryVBO && GLContext.getCapabilities().GL_ARB_vertex_buffer_object;
      if (useVBO) {
         vertexBuffers = GLAllocation.func_74527_f(vboCount);
         ARBBufferObject.glGenBuffersARB(vertexBuffers);
      }

   }
}
