package com.flansmod.common.driveables;

import com.flansmod.common.FlansMod;
import com.flansmod.common.paintjob.IPaintableItem;
import com.flansmod.common.paintjob.PaintableType;
import com.flansmod.common.paintjob.Paintjob;
import com.flansmod.common.parts.PartType;
import com.flansmod.common.types.EnumType;
import com.flansmod.common.types.InfoType;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.block.BlockSponge;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class ItemPlane extends Item implements IPaintableItem {
   public PlaneType type;
   public IIcon[] icons;

   public ItemPlane(PlaneType type1) {
      this.field_77777_bU = 1;
      this.type = type1;
      this.type.item = this;
      this.func_77637_a(FlansMod.tabFlanDriveables);
      GameRegistry.registerItem(this, this.type.shortName, "flansmod");
   }

   public boolean func_77651_p() {
      return true;
   }

   private NBTTagCompound getTagCompound(ItemStack stack, World world) {
      if (stack.field_77990_d == null) {
         if (!world.field_72995_K && stack.func_77960_j() != 0) {
            stack.field_77990_d = this.getOldTagCompound(stack, world);
         }

         if (stack.field_77990_d == null) {
            stack.field_77990_d = new NBTTagCompound();
            stack.field_77990_d.func_74778_a("Type", this.type.shortName);
            stack.field_77990_d.func_74778_a("Engine", ((PartType)PartType.defaultEngines.get(EnumType.plane)).shortName);
         }
      }

      return stack.field_77990_d;
   }

   private NBTTagCompound getOldTagCompound(ItemStack stack, World world) {
      try {
         File file1 = world.func_72860_G().func_75758_b("plane_" + stack.func_77960_j());
         if (file1 != null && file1.exists()) {
            FileInputStream fileinputstream = new FileInputStream(file1);
            NBTTagCompound tags = CompressedStreamTools.func_74796_a(fileinputstream).func_74775_l("data");
            EnumDriveablePart[] var6 = EnumDriveablePart.values();
            int var7 = var6.length;

            for(int var8 = 0; var8 < var7; ++var8) {
               EnumDriveablePart part = var6[var8];
               tags.func_74768_a(part.getShortName() + "_Health", this.type.health.get(part) == null ? 0 : ((CollisionBox)this.type.health.get(part)).health);
               tags.func_74757_a(part.getShortName() + "_Fire", false);
            }

            fileinputstream.close();
            return tags;
         }
      } catch (IOException var10) {
         FlansMod.log("Failed to read old vehicle file");
         var10.printStackTrace();
      }

      return null;
   }

   public void func_77624_a(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
      if (!this.type.getPaintjob(stack.func_77960_j()).displayName.equals("default")) {
         lines.add("§b§o" + this.type.getPaintjob(stack.func_77960_j()).displayName);
      }

      if (!this.type.packName.isEmpty()) {
         lines.add("§o" + this.type.packName);
      }

      if (this.type.description != null) {
         Collections.addAll(lines, this.type.description.split("_"));
      }

      lines.add("");
      NBTTagCompound tags = this.getTagCompound(stack, player.field_70170_p);
      PartType engine = PartType.getPart(tags.func_74779_i("Engine"));
      if (engine != null) {
         lines.add("§9Engine§7: " + engine.name);
      }

   }

   public ItemStack func_77659_a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
      float cosYaw = MathHelper.func_76134_b(-entityplayer.field_70177_z * 0.01745329F - 3.141593F);
      float sinYaw = MathHelper.func_76126_a(-entityplayer.field_70177_z * 0.01745329F - 3.141593F);
      float cosPitch = -MathHelper.func_76134_b(-entityplayer.field_70125_A * 0.01745329F);
      float sinPitch = MathHelper.func_76126_a(-entityplayer.field_70125_A * 0.01745329F);
      double length = 5.0D;
      Vec3 posVec = Vec3.func_72443_a(entityplayer.field_70165_t, entityplayer.field_70163_u + 1.62D - (double)entityplayer.field_70129_M, entityplayer.field_70161_v);
      Vec3 lookVec = posVec.func_72441_c((double)(sinYaw * cosPitch) * length, (double)sinPitch * length, (double)(cosYaw * cosPitch) * length);
      MovingObjectPosition movingobjectposition = world.func_72901_a(posVec, lookVec, this.type.placeableOnWater);
      if (movingobjectposition == null) {
         return itemstack;
      } else {
         if (movingobjectposition.field_72313_a == MovingObjectType.BLOCK) {
            int i = movingobjectposition.field_72311_b;
            int j = movingobjectposition.field_72312_c;
            int k = movingobjectposition.field_72309_d;
            Block block = world.func_147439_a(i, j, k);
            DriveableData data;
            if (this.type.placeableOnLand || block instanceof BlockLiquid) {
               if (!world.field_72995_K) {
                  data = this.getPlaneData(itemstack, world);
                  if (data != null) {
                     world.func_72838_d(new EntityPlane(world, (double)i + 0.5D, (double)j + 2.5D, (double)k + 0.5D, entityplayer, this.type, data));
                  }
               }

               if (!entityplayer.field_71075_bZ.field_75098_d) {
                  --itemstack.field_77994_a;
               }
            }

            if (!this.type.placeableOnLand && this.type.placeableOnSponge && block instanceof BlockSponge) {
               if (!world.field_72995_K) {
                  data = this.getPlaneData(itemstack, world);
                  if (data != null) {
                     world.func_72838_d(new EntityPlane(world, (double)i + 0.5D, (double)j + 2.5D, (double)k + 0.5D, entityplayer, this.type, data));
                  }
               }

               if (!entityplayer.field_71075_bZ.field_75098_d) {
                  --itemstack.field_77994_a;
               }
            }

            if (!this.type.placeableOnLand && this.type.placeableOnPumpkin && block instanceof BlockPumpkin) {
               if (!world.field_72995_K) {
                  data = this.getPlaneData(itemstack, world);
                  if (data != null) {
                     world.func_72838_d(new EntityPlane(world, (double)i + 0.5D, (double)j + 2.5D, (double)k + 0.5D, entityplayer, this.type, data));
                  }
               }

               if (!entityplayer.field_71075_bZ.field_75098_d) {
                  --itemstack.field_77994_a;
               }
            }
         }

         return itemstack;
      }
   }

   public Entity spawnPlane(World world, double x, double y, double z, ItemStack stack) {
      DriveableData data = this.getPlaneData(stack, world);
      if (data != null) {
         Entity entity = new EntityPlane(world, x, y, z, this.type, data);
         if (!world.field_72995_K) {
            world.func_72838_d(entity);
         }

         return entity;
      } else {
         return null;
      }
   }

   public DriveableData getPlaneData(ItemStack itemstack, World world) {
      return new DriveableData(this.getTagCompound(itemstack, world), itemstack.func_77960_j());
   }

   @SideOnly(Side.CLIENT)
   public int func_82790_a(ItemStack par1ItemStack, int par2) {
      return this.type.colour;
   }

   @SideOnly(Side.CLIENT)
   public void func_94581_a(IIconRegister icon) {
      this.icons = new IIcon[this.type.paintjobs.size()];
      this.field_77791_bV = icon.func_94245_a("FlansMod:" + this.type.iconPath);

      for(int i = 0; i < this.type.paintjobs.size(); ++i) {
         this.icons[i] = icon.func_94245_a("FlansMod:" + ((Paintjob)this.type.paintjobs.get(i)).iconName);
      }

   }

   @SideOnly(Side.CLIENT)
   public IIcon func_77650_f(ItemStack stack) {
      return this.icons[stack.func_77960_j()];
   }

   public void func_150895_a(Item item, CreativeTabs tabs, List list) {
      ItemStack planeStack = new ItemStack(item, 1, 0);
      NBTTagCompound tags = new NBTTagCompound();
      tags.func_74778_a("Type", this.type.shortName);
      if (PartType.defaultEngines.containsKey(EnumType.plane)) {
         tags.func_74778_a("Engine", ((PartType)PartType.defaultEngines.get(EnumType.plane)).shortName);
      }

      EnumDriveablePart[] var6 = EnumDriveablePart.values();
      int var7 = var6.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         EnumDriveablePart part = var6[var8];
         tags.func_74768_a(part.getShortName() + "_Health", this.type.health.get(part) == null ? 0 : ((CollisionBox)this.type.health.get(part)).health);
         tags.func_74757_a(part.getShortName() + "_Fire", false);
      }

      planeStack.field_77990_d = tags;
      list.add(planeStack);
   }

   public InfoType getInfoType() {
      return this.type;
   }

   public PaintableType GetPaintableType() {
      return this.type;
   }
}
