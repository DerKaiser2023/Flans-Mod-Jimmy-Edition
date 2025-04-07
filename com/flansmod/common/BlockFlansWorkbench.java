package com.flansmod.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockFlansWorkbench extends Block {
   private IIcon side;
   private IIcon[] top;

   public BlockFlansWorkbench(int j, int k) {
      super(Material.field_151573_f);
      this.func_149711_c(3.0F);
      this.func_149752_b(6.0F);
      this.func_149647_a(FlansMod.tabFlanDriveables);
   }

   public void func_149666_a(Item item, CreativeTabs tab, List par3List) {
      if (tab == FlansMod.tabFlanDriveables) {
         par3List.add(new ItemStack(item, 1, 0));
      } else if (tab == FlansMod.tabFlanGuns) {
         par3List.add(new ItemStack(item, 1, 1));
      } else if (tab == FlansMod.tabFlanParts) {
         par3List.add(new ItemStack(item, 1, 2));
      }

   }

   public IIcon func_149691_a(int i, int j) {
      return i == 1 ? this.top[j] : this.side;
   }

   public boolean func_149727_a(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {
      switch(world.func_72805_g(i, j, k)) {
      case 0:
         if (world.field_72995_K) {
            entityplayer.openGui(FlansMod.INSTANCE, 0, world, i, j, k);
         }
         break;
      case 1:
         if (!world.field_72995_K) {
            entityplayer.openGui(FlansMod.INSTANCE, 2, world, i, j, k);
         }
      }

      return true;
   }

   @SideOnly(Side.CLIENT)
   public void func_149651_a(IIconRegister register) {
      this.top = new IIcon[3];
      this.top[0] = register.func_94245_a("FlansMod:planeCraftingTableSmall");
      this.top[1] = register.func_94245_a("FlansMod:planeCraftingTableLarge");
      this.top[2] = register.func_94245_a("FlansMod:vehicleCraftingTable");
      this.side = register.func_94245_a("FlansMod:planeCraftingTableSide");
   }

   public int func_149692_a(int par1) {
      return par1;
   }
}
