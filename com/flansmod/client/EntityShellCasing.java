package com.flansmod.client;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class EntityShellCasing extends EntityFX {
   public static ResourceLocation icon = new ResourceLocation("flansmod", "particle/Boom1.png");

   public EntityShellCasing(World w, double px, double py, double pz, double mx, double my, double mz) {
      super(w, px, py, pz, mx, my, mz);
      this.field_70547_e = 100;
      this.field_70545_g = 5.0F;
      this.field_70159_w = mx;
      this.field_70181_x = my;
      this.field_70179_y = mz;
      icon = new ResourceLocation("flansmod", "particle/Casing1.png");
   }

   public int func_70537_b() {
      return 3;
   }

   public float getEntityBrightness(float f) {
      return 1.0F;
   }

   public void func_70539_a(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7) {
      GL11.glPushMatrix();
      par1Tessellator.func_78382_b();
      GL11.glAlphaFunc(516, 0.001F);
      GL11.glEnable(3042);
      int srcBlend = GL11.glGetInteger(3041);
      int dstBlend = GL11.glGetInteger(3040);
      GL11.glBlendFunc(1, 771);
      GL11.glDepthMask(false);
      FMLClientHandler.instance().getClient().field_71446_o.func_110577_a(icon);
      float scale = 0.1F;
      float xPos = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * (double)par2 - field_70556_an);
      float yPos = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)par2 - field_70554_ao);
      float zPos = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * (double)par2 - field_70555_ap);
      float colorIntensity = 1.0F;
      par1Tessellator.func_78386_a(this.field_70552_h * colorIntensity, this.field_70553_i * colorIntensity, this.field_70551_j * colorIntensity);
      par1Tessellator.func_78374_a((double)(xPos - par3 * scale - par6 * scale), (double)(yPos - par4 * scale), (double)(zPos - par5 * scale - par7 * scale), 0.0D, 1.0D);
      par1Tessellator.func_78374_a((double)(xPos - par3 * scale + par6 * scale), (double)(yPos + par4 * scale), (double)(zPos - par5 * scale + par7 * scale), 1.0D, 1.0D);
      par1Tessellator.func_78374_a((double)(xPos + par3 * scale + par6 * scale), (double)(yPos + par4 * scale), (double)(zPos + par5 * scale + par7 * scale), 1.0D, 0.0D);
      par1Tessellator.func_78374_a((double)(xPos + par3 * scale - par6 * scale), (double)(yPos - par4 * scale), (double)(zPos + par5 * scale - par7 * scale), 0.0D, 0.0D);
      par1Tessellator.func_78381_a();
      GL11.glBlendFunc(srcBlend, dstBlend);
      GL11.glDisable(3042);
      GL11.glDepthMask(true);
      GL11.glPopMatrix();
   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      if (this.field_70546_d++ >= this.field_70547_e) {
         this.func_70106_y();
      }

      if (this.field_70122_E) {
         this.func_70106_y();
      }

      if (this.field_70546_d == 1) {
         icon = new ResourceLocation("flansmod", "particle/Casing2.png");
      }

      if (this.field_70546_d == 2) {
         icon = new ResourceLocation("flansmod", "particle/Casing3.png");
      }

      if (this.field_70546_d == 3) {
         icon = new ResourceLocation("flansmod", "particle/Casing4.png");
      }

      if (this.field_70546_d == 4) {
         icon = new ResourceLocation("flansmod", "particle/Casing5.png");
      }

      if (this.field_70546_d == 5) {
         icon = new ResourceLocation("flansmod", "particle/Casing6.png");
      }

      if (this.field_70546_d == 6) {
         icon = new ResourceLocation("flansmod", "particle/Casing1.png");
      }

      if (this.field_70546_d == 7) {
         icon = new ResourceLocation("flansmod", "particle/Casing2.png");
      }

      if (this.field_70546_d == 8) {
         icon = new ResourceLocation("flansmod", "particle/Casing3.png");
      }

      if (this.field_70546_d == 9) {
         icon = new ResourceLocation("flansmod", "particle/Casing4.png");
      }

      if (this.field_70546_d == 10) {
         icon = new ResourceLocation("flansmod", "particle/Casing5.png");
      }

      if (this.field_70546_d == 11) {
         icon = new ResourceLocation("flansmod", "particle/Casing6.png");
      }

      if (this.field_70546_d == 12) {
         icon = new ResourceLocation("flansmod", "particle/Casing1.png");
      }

      if (this.field_70546_d == 13) {
         icon = new ResourceLocation("flansmod", "particle/Casing2.png");
      }

      if (this.field_70546_d == 14) {
         icon = new ResourceLocation("flansmod", "particle/Casing3.png");
      }

      if (this.field_70546_d == 15) {
         icon = new ResourceLocation("flansmod", "particle/Casing4.png");
      }

      if (this.field_70546_d == 16) {
         icon = new ResourceLocation("flansmod", "particle/Casing5.png");
      }

      if (this.field_70546_d == 17) {
         icon = new ResourceLocation("flansmod", "particle/Casing6.png");
      }

      if (this.field_70546_d == 18) {
         icon = new ResourceLocation("flansmod", "particle/Casing1.png");
      }

      if (this.field_70546_d == 19) {
         icon = new ResourceLocation("flansmod", "particle/Casing2.png");
      }

      if (this.field_70546_d == 20) {
         icon = new ResourceLocation("flansmod", "particle/Casing3.png");
      }

      if (this.field_70546_d == 21) {
         icon = new ResourceLocation("flansmod", "particle/Casing4.png");
      }

      if (this.field_70546_d == 22) {
         icon = new ResourceLocation("flansmod", "particle/Casing5.png");
      }

      if (this.field_70546_d == 23) {
         icon = new ResourceLocation("flansmod", "particle/Casing6.png");
      }

      if (this.field_70546_d == 24) {
         icon = new ResourceLocation("flansmod", "particle/Casing1.png");
      }

      if (this.field_70546_d == 25) {
         icon = new ResourceLocation("flansmod", "particle/Casing2.png");
      }

      if (this.field_70546_d == 20) {
         icon = new ResourceLocation("flansmod", "particle/Casing3.png");
      }

      if (this.field_70546_d == 26) {
         icon = new ResourceLocation("flansmod", "particle/Casing4.png");
      }

      if (this.field_70546_d == 27) {
         icon = new ResourceLocation("flansmod", "particle/Casing5.png");
      }

      if (this.field_70546_d == 28) {
         icon = new ResourceLocation("flansmod", "particle/Casing6.png");
      }

      if (this.field_70546_d == 29) {
         icon = new ResourceLocation("flansmod", "particle/Casing1.png");
      }

      if (this.field_70546_d == 30) {
         icon = new ResourceLocation("flansmod", "particle/Casing2.png");
      }

      if (this.field_70546_d == 31) {
         icon = new ResourceLocation("flansmod", "particle/Casing3.png");
      }

      if (this.field_70546_d == 32) {
         icon = new ResourceLocation("flansmod", "particle/Casing4.png");
      }

      if (this.field_70546_d == 33) {
         icon = new ResourceLocation("flansmod", "particle/Casing5.png");
      }

      if (this.field_70546_d == 34) {
         icon = new ResourceLocation("flansmod", "particle/Casing6.png");
      }

      if (this.field_70546_d == 35) {
         icon = new ResourceLocation("flansmod", "particle/Casing1.png");
      }

      if (this.field_70546_d == 36) {
         icon = new ResourceLocation("flansmod", "particle/Casing2.png");
      }

      if (this.field_70546_d == 37) {
         icon = new ResourceLocation("flansmod", "particle/Casing3.png");
      }

      if (this.field_70546_d == 38) {
         icon = new ResourceLocation("flansmod", "particle/Casing4.png");
      }

      if (this.field_70546_d == 39) {
         icon = new ResourceLocation("flansmod", "particle/Casing5.png");
      }

      if (this.field_70546_d == 40) {
         icon = new ResourceLocation("flansmod", "particle/Casing6.png");
      }

      if (this.field_70546_d == 41) {
         icon = new ResourceLocation("flansmod", "particle/Casing1.png");
      }

      if (this.field_70546_d == 42) {
         icon = new ResourceLocation("flansmod", "particle/Casing2.png");
      }

      if (this.field_70546_d == 43) {
         icon = new ResourceLocation("flansmod", "particle/Casing3.png");
      }

      if (this.field_70546_d == 44) {
         icon = new ResourceLocation("flansmod", "particle/Casing4.png");
      }

      if (this.field_70546_d == 45) {
         icon = new ResourceLocation("flansmod", "particle/Casing5.png");
      }

      if (this.field_70546_d == 46) {
         icon = new ResourceLocation("flansmod", "particle/Casing6.png");
      }

      if (this.field_70546_d == 47) {
         icon = new ResourceLocation("flansmod", "particle/Casing1.png");
      }

      if (this.field_70546_d == 48) {
         icon = new ResourceLocation("flansmod", "particle/Casing2.png");
      }

      if (this.field_70546_d == 49) {
         icon = new ResourceLocation("flansmod", "particle/Casing3.png");
      }

      if (this.field_70546_d == 50) {
         icon = new ResourceLocation("flansmod", "particle/Casing4.png");
      }

      if (this.field_70546_d == 51) {
         icon = new ResourceLocation("flansmod", "particle/Casing5.png");
      }

      if (this.field_70546_d == 52) {
         icon = new ResourceLocation("flansmod", "particle/Casing6.png");
      }

      if (this.field_70546_d == 53) {
         icon = new ResourceLocation("flansmod", "particle/Casing1.png");
      }

      if (this.field_70546_d == 54) {
         icon = new ResourceLocation("flansmod", "particle/Casing2.png");
      }

      if (this.field_70546_d == 55) {
         icon = new ResourceLocation("flansmod", "particle/Casing3.png");
      }

      if (this.field_70546_d == 56) {
         icon = new ResourceLocation("flansmod", "particle/Casing4.png");
      }

      if (this.field_70546_d == 57) {
         icon = new ResourceLocation("flansmod", "particle/Casing5.png");
      }

      if (this.field_70546_d == 58) {
         icon = new ResourceLocation("flansmod", "particle/Casing6.png");
      }

      if (this.field_70546_d == 59) {
         icon = new ResourceLocation("flansmod", "particle/Casing1.png");
      }

      if (this.field_70546_d == 60) {
         icon = new ResourceLocation("flansmod", "particle/Casing2.png");
      }

      if (this.field_70546_d == 61) {
         icon = new ResourceLocation("flansmod", "particle/Casing3.png");
      }

      if (this.field_70546_d == 62) {
         icon = new ResourceLocation("flansmod", "particle/Casing5.png");
      }

      if (this.field_70546_d == 63) {
         icon = new ResourceLocation("flansmod", "particle/Casing6.png");
      }

      if (this.field_70546_d == 64) {
         icon = new ResourceLocation("flansmod", "particle/Casing1.png");
      }

      if (this.field_70546_d == 65) {
         icon = new ResourceLocation("flansmod", "particle/Casing2.png");
      }

      if (this.field_70546_d == 66) {
         icon = new ResourceLocation("flansmod", "particle/Casing4.png");
      }

      if (this.field_70546_d == 67) {
         icon = new ResourceLocation("flansmod", "particle/Casing5.png");
      }

      if (this.field_70546_d == 68) {
         icon = new ResourceLocation("flansmod", "particle/Casing6.png");
      }

      if (this.field_70546_d == 69) {
         icon = new ResourceLocation("flansmod", "particle/Casing1.png");
      }

      if (this.field_70546_d == 70) {
         icon = new ResourceLocation("flansmod", "particle/Casing2.png");
      }

      if (this.field_70546_d == 71) {
         icon = new ResourceLocation("flansmod", "particle/Casing3.png");
      }

      if (this.field_70546_d == 72) {
         icon = new ResourceLocation("flansmod", "particle/Casing4.png");
      }

      if (this.field_70546_d == 73) {
         icon = new ResourceLocation("flansmod", "particle/Casing5.png");
      }

      if (this.field_70546_d == 74) {
         icon = new ResourceLocation("flansmod", "particle/Casing6.png");
      }

      if (this.field_70546_d == 75) {
         icon = new ResourceLocation("flansmod", "particle/Casing1.png");
      }

      if (this.field_70546_d == 76) {
         icon = new ResourceLocation("flansmod", "particle/Casing2.png");
      }

      if (this.field_70546_d == 77) {
         icon = new ResourceLocation("flansmod", "particle/Casing3.png");
      }

      if (this.field_70546_d == 78) {
         icon = new ResourceLocation("flansmod", "particle/Casing4.png");
      }

      if (this.field_70546_d == 79) {
         icon = new ResourceLocation("flansmod", "particle/Casing5.png");
      }

      if (this.field_70546_d == 80) {
         icon = new ResourceLocation("flansmod", "particle/Casing6.png");
      }

      if (this.field_70546_d == 81) {
         icon = new ResourceLocation("flansmod", "particle/Casing1.png");
      }

      if (this.field_70546_d == 82) {
         icon = new ResourceLocation("flansmod", "particle/Casing2.png");
      }

      if (this.field_70546_d == 83) {
         icon = new ResourceLocation("flansmod", "particle/Casing3.png");
      }

      if (this.field_70546_d == 84) {
         icon = new ResourceLocation("flansmod", "particle/Casing4.png");
      }

      if (this.field_70546_d == 85) {
         icon = new ResourceLocation("flansmod", "particle/Casing5.png");
      }

      if (this.field_70546_d == 86) {
         icon = new ResourceLocation("flansmod", "particle/Casing6.png");
      }

      if (this.field_70546_d == 87) {
         icon = new ResourceLocation("flansmod", "particle/Casing1.png");
      }

      if (this.field_70546_d == 88) {
         icon = new ResourceLocation("flansmod", "particle/Casing2.png");
      }

      if (this.field_70546_d == 89) {
         icon = new ResourceLocation("flansmod", "particle/Casing3.png");
      }

      if (this.field_70546_d == 90) {
         icon = new ResourceLocation("flansmod", "particle/Casing4.png");
      }

      if (this.field_70546_d == 91) {
         icon = new ResourceLocation("flansmod", "particle/Casing5.png");
      }

      if (this.field_70546_d == 92) {
         icon = new ResourceLocation("flansmod", "particle/Casing6.png");
      }

      if (this.field_70546_d == 93) {
         icon = new ResourceLocation("flansmod", "particle/Casing1.png");
      }

      if (this.field_70546_d == 94) {
         icon = new ResourceLocation("flansmod", "particle/Casing2.png");
      }

      if (this.field_70546_d == 95) {
         icon = new ResourceLocation("flansmod", "particle/Casing3.png");
      }

      if (this.field_70546_d == 96) {
         icon = new ResourceLocation("flansmod", "particle/Casing4.png");
      }

      if (this.field_70546_d == 97) {
         icon = new ResourceLocation("flansmod", "particle/Casing5.png");
      }

      if (this.field_70546_d == 98) {
         icon = new ResourceLocation("flansmod", "particle/Casing6.png");
      }

      if (this.field_70546_d == 99) {
         icon = new ResourceLocation("flansmod", "particle/Casing1.png");
      }

      if (this.field_70546_d == 100) {
         icon = new ResourceLocation("flansmod", "particle/Casing2.png");
      }

      FMLClientHandler.instance().getClient().field_71446_o.func_110577_a(icon);
   }
}
