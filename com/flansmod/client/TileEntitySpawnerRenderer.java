package com.flansmod.client;

import com.flansmod.common.FlansMod;
import com.flansmod.common.teams.BlockSpawner;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class TileEntitySpawnerRenderer extends TileEntitySpecialRenderer {
   private RenderBlocks blockRenderer;

   public void func_147500_a(TileEntity te, double x, double y, double z, float f) {
      BlockSpawner.colouredPass = true;
      Tessellator var10 = Tessellator.field_78398_a;
      this.func_147499_a(TextureMap.field_110575_b);
      RenderHelper.func_74518_a();
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(3042);
      GL11.glDisable(2884);
      if (Minecraft.func_71379_u()) {
         GL11.glShadeModel(7425);
      } else {
         GL11.glShadeModel(7424);
      }

      var10.func_78382_b();
      var10.func_78373_b((double)((float)x - (float)te.field_145851_c), (double)((float)y - (float)te.field_145848_d), (double)((float)z - (float)te.field_145849_e));
      var10.func_78376_a(1, 1, 1);
      GL11.glColor4f(1.0F, 1.0F, 0.0F, 0.5F);
      this.blockRenderer.func_147769_a(FlansMod.spawner, te.field_145851_c, te.field_145848_d, te.field_145849_e);
      var10.func_78373_b(0.0D, 0.0D, 0.0D);
      var10.func_78381_a();
      RenderHelper.func_74519_b();
      BlockSpawner.colouredPass = false;
   }

   public void func_147496_a(World par1World) {
      this.blockRenderer = new RenderBlocks(par1World);
   }
}
