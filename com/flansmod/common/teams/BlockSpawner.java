package com.flansmod.common.teams;

import com.flansmod.client.FlansModClient;
import com.flansmod.common.FlansMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSpawner extends BlockContainer {
   public static boolean colouredPass = false;
   public IIcon[][] icons;

   public BlockSpawner(Material material) {
      super(material);
      this.func_149647_a(FlansMod.tabFlanTeams);
   }

   public void func_149666_a(Item item, CreativeTabs tab, List list) {
      if (tab == FlansMod.tabFlanTeams) {
         list.add(new ItemStack(item, 1, 0));
         list.add(new ItemStack(item, 1, 1));
         list.add(new ItemStack(item, 1, 2));
      }

   }

   public IIcon func_149691_a(int i, int j) {
      if (j > 2) {
         j = 2;
      }

      return this.icons[colouredPass ? 1 : 0][j];
   }

   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
      return null;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149655_b(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
      return true;
   }

   public boolean func_149742_c(World par1World, int par2, int par3, int par4) {
      return World.func_147466_a(par1World, par2, par3 - 1, par4) || BlockFence.func_149825_a(par1World.func_147439_a(par2, par3 - 1, par4));
   }

   public void func_149670_a(World par1World, int par2, int par3, int par4, Entity par5Entity) {
      if (!par1World.field_72995_K && par1World.func_72805_g(par2, par3, par4) != 1) {
      }

   }

   public void func_149719_a(IBlockAccess access, int i, int j, int k) {
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.03125F, 1.0F);
   }

   public void func_149683_g() {
      float var1 = 0.5F;
      float var2 = 0.015625F;
      float var3 = 0.5F;
      this.func_149676_a(0.0F, 0.5F - var2, 0.0F, 1.0F, 0.5F + var2, 1.0F);
   }

   public int func_149656_h() {
      return 1;
   }

   public TileEntity func_149915_a(World var1, int i) {
      return new TileEntitySpawner();
   }

   public int func_149720_d(IBlockAccess access, int x, int y, int z) {
      if (!colouredPass) {
         return 16777215;
      } else {
         try {
            TileEntitySpawner spawner = (TileEntitySpawner)access.func_147438_o(x, y, z);
            int spawnerTeamID = spawner.getTeamID();
            Team spawnerTeam = FlansModClient.getTeam(spawnerTeamID);
            boolean currentMap = FlansModClient.isCurrentMap(spawner.map);
            if (spawnerTeam == null || !currentMap) {
               switch(spawnerTeamID) {
               case 0:
                  return 8421504;
               case 1:
                  return 4210752;
               case 2:
                  return 10584063;
               case 3:
                  return 16744374;
               }
            }

            return spawnerTeam.teamColour;
         } catch (Exception var9) {
            return 16777215;
         }
      }
   }

   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int side, float par7, float par8, float par9) {
      if (world.field_72995_K) {
         return true;
      } else {
         if (MinecraftServer.func_71276_C().func_71203_ab().func_152596_g(player.func_146103_bH())) {
            TileEntitySpawner spawner = (TileEntitySpawner)world.func_147438_o(x, y, z);
            ItemStack item = player.func_71045_bC();
            if (item != null && item.func_77973_b() != null) {
               if (!(item.func_77973_b() instanceof ItemOpStick)) {
                  spawner.stacksToSpawn.add(item.func_77946_l());
                  Iterator var12 = spawner.itemEntities.iterator();

                  while(var12.hasNext()) {
                     Entity entity = (Entity)var12.next();
                     entity.func_70106_y();
                  }

                  spawner.currentDelay = 10;
               }
            } else {
               spawner.spawnDelay = (spawner.spawnDelay + 200) % 6000;
               player.func_145747_a(new ChatComponentText("Set spawn delay to " + spawner.spawnDelay / 20));
            }
         }

         return true;
      }
   }

   @SideOnly(Side.CLIENT)
   public void func_149651_a(IIconRegister register) {
      this.icons = new IIcon[2][3];

      for(int i = 0; i < 2; ++i) {
         this.icons[i][0] = register.func_94245_a("FlansMod:spawner_item_" + (i + 1));
         this.icons[i][1] = register.func_94245_a("FlansMod:spawner_player_" + (i + 1));
         this.icons[i][2] = register.func_94245_a("FlansMod:spawner_vehicle_" + (i + 1));
      }

   }
}
