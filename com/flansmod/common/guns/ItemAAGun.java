package com.flansmod.common.guns;

import com.flansmod.common.FlansMod;
import com.flansmod.common.types.IFlanItem;
import com.flansmod.common.types.InfoType;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemAAGun extends Item implements IFlanItem {
   public static final ArrayList<String> names = new ArrayList();
   @SideOnly(Side.CLIENT)
   private ArrayList<IIcon> icons;
   public AAGunType type;

   public ItemAAGun(AAGunType type1) {
      this.field_77777_bU = 1;
      this.type = type1;
      this.type.item = this;
      this.func_77637_a(FlansMod.tabFlanGuns);
      GameRegistry.registerItem(this, this.type.shortName, "flansmod");
   }

   public ItemStack func_77659_a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
      float cosYaw = MathHelper.func_76134_b(-entityplayer.field_70177_z * 0.01745329F - 3.141593F);
      float sinYaw = MathHelper.func_76126_a(-entityplayer.field_70177_z * 0.01745329F - 3.141593F);
      float cosPitch = -MathHelper.func_76134_b(-entityplayer.field_70125_A * 0.01745329F);
      float sinPitch = MathHelper.func_76126_a(-entityplayer.field_70125_A * 0.01745329F);
      double length = 5.0D;
      Vec3 posVec = Vec3.func_72443_a(entityplayer.field_70165_t, entityplayer.field_70163_u + 1.62D - (double)entityplayer.field_70129_M, entityplayer.field_70161_v);
      Vec3 lookVec = posVec.func_72441_c((double)(sinYaw * cosPitch) * length, (double)sinPitch * length, (double)(cosYaw * cosPitch) * length);
      MovingObjectPosition movingobjectposition = world.func_72901_a(posVec, lookVec, true);
      if (movingobjectposition == null) {
         return itemstack;
      } else {
         if (movingobjectposition.field_72313_a == MovingObjectType.BLOCK) {
            int i = movingobjectposition.field_72311_b;
            int j = movingobjectposition.field_72312_c;
            int k = movingobjectposition.field_72309_d;
            if (!world.field_72995_K && world.isSideSolid(i, j, k, ForgeDirection.UP)) {
               world.func_72838_d(new EntityAAGun(world, this.type, (double)i + 0.5D, (double)j + 1.0D, (double)k + 0.5D, entityplayer));
            }

            if (!entityplayer.field_71075_bZ.field_75098_d) {
               --itemstack.field_77994_a;
            }
         }

         return itemstack;
      }
   }

   public Entity spawnAAGun(World world, double x, double y, double z, ItemStack stack) {
      Entity entity = new EntityAAGun(world, this.type, x, y, z, (EntityPlayer)null);
      if (!world.field_72995_K) {
         world.func_72838_d(entity);
      }

      return entity;
   }

   @SideOnly(Side.CLIENT)
   public int func_82790_a(ItemStack par1ItemStack, int par2) {
      return this.type.colour;
   }

   @SideOnly(Side.CLIENT)
   public void func_94581_a(IIconRegister icon) {
      this.field_77791_bV = icon.func_94245_a("FlansMod:" + this.type.iconPath);
   }

   public InfoType getInfoType() {
      return this.type;
   }
}
