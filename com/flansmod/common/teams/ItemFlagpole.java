package com.flansmod.common.teams;

import com.flansmod.common.FlansMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class ItemFlagpole extends Item {
   public ItemFlagpole() {
      this.func_77637_a(FlansMod.tabFlanTeams);
   }

   public ItemStack func_77659_a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
      float f = 1.0F;
      float f1 = entityplayer.field_70127_C + (entityplayer.field_70125_A - entityplayer.field_70127_C) * f;
      float f2 = entityplayer.field_70126_B + (entityplayer.field_70177_z - entityplayer.field_70126_B) * f;
      double d = entityplayer.field_70169_q + (entityplayer.field_70165_t - entityplayer.field_70169_q) * (double)f;
      double d1 = entityplayer.field_70167_r + (entityplayer.field_70163_u - entityplayer.field_70167_r) * (double)f + 1.62D - (double)entityplayer.field_70129_M;
      double d2 = entityplayer.field_70166_s + (entityplayer.field_70161_v - entityplayer.field_70166_s) * (double)f;
      Vec3 vec3d = Vec3.func_72443_a(d, d1, d2);
      float f3 = MathHelper.func_76134_b(-f2 * 0.01745329F - 3.141593F);
      float f4 = MathHelper.func_76126_a(-f2 * 0.01745329F - 3.141593F);
      float f5 = -MathHelper.func_76134_b(-f1 * 0.01745329F);
      float f6 = MathHelper.func_76126_a(-f1 * 0.01745329F);
      float f7 = f4 * f5;
      float f9 = f3 * f5;
      double d3 = 5.0D;
      Vec3 vec3d1 = vec3d.func_72441_c((double)f7 * d3, (double)f6 * d3, (double)f9 * d3);
      MovingObjectPosition movingobjectposition = world.func_72901_a(vec3d, vec3d1, true);
      if (movingobjectposition == null) {
         return itemstack;
      } else {
         if (movingobjectposition.field_72313_a == MovingObjectType.BLOCK) {
            int i = movingobjectposition.field_72311_b;
            int j = movingobjectposition.field_72312_c;
            int k = movingobjectposition.field_72309_d;
            if (!world.field_72995_K) {
               if (world.func_147439_a(i, j, k) == Blocks.field_150433_aE) {
                  --j;
               }

               if (this.isSolid(world, i, j, k)) {
                  world.func_72838_d(new EntityFlagpole(world, i, j + 1, k));
               }
            }
         }

         return itemstack;
      }
   }

   private boolean isSolid(World world, int i, int j, int k) {
      Block block = world.func_147439_a(i, j, k);
      return block != null && block.func_149688_o().func_76220_a() && block.func_149662_c();
   }

   @SideOnly(Side.CLIENT)
   public void func_94581_a(IIconRegister icon) {
      this.field_77791_bV = icon.func_94245_a("FlansMod:flagpole");
   }
}
