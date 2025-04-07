package com.flansmod.client.model;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class RenderSpawnerBlock implements ISimpleBlockRenderingHandler {
   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
   }

   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
      renderer.func_147769_a(block, x, y, z);
      return false;
   }

   public boolean shouldRender3DInInventory(int i) {
      return false;
   }

   public int getRenderId() {
      return 0;
   }
}
