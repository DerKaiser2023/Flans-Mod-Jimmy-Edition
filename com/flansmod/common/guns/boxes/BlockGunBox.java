package com.flansmod.common.guns.boxes;

import com.flansmod.common.FlansMod;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.types.InfoType;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockGunBox extends Block {
   public GunBoxType type;

   public BlockGunBox(GunBoxType t) throws Exception {
      super(Material.field_151575_d);
      this.func_149711_c(2.0F);
      this.func_149752_b(4.0F);
      this.type = t;
      this.func_149663_c(this.type.shortName);
      Block block = Block.func_149684_b("flansmod:gunBox." + this.type.shortName);
      if (block != null) {
         throw new Exception("Caught an exception during block registration");
      } else {
         GameRegistry.registerBlock(this, "gunBox." + this.type.shortName);
         this.func_149647_a(FlansMod.tabFlanGuns);
         this.type.block = this;
         this.type.item = Item.func_150898_a(this);
      }
   }

   public void buyGun(InfoType item, InventoryPlayer inventory, GunBoxType type) {
      if (FMLCommonHandler.instance().getEffectiveSide().isClient()) {
         FlansMod.proxy.buyGun(type, item);
      }

      GunBoxEntry entry = this.searchFor(item);
      if (entry != null) {
         boolean canBuy = true;
         Iterator var6 = entry.requiredParts.iterator();

         ItemStack remove;
         int amountLeft;
         int j;
         ItemStack stack;
         while(var6.hasNext()) {
            remove = (ItemStack)var6.next();
            amountLeft = 0;

            for(j = 0; j < inventory.func_70302_i_(); ++j) {
               stack = inventory.func_70301_a(j);
               if (stack != null && stack.func_77973_b() == remove.func_77973_b() && stack.func_77960_j() == remove.func_77960_j()) {
                  amountLeft += stack.field_77994_a;
               }
            }

            if (amountLeft < remove.field_77994_a) {
               canBuy = false;
            }
         }

         if (canBuy) {
            var6 = entry.requiredParts.iterator();

            while(var6.hasNext()) {
               remove = (ItemStack)var6.next();
               amountLeft = remove.field_77994_a;

               for(j = 0; j < inventory.func_70302_i_(); ++j) {
                  stack = inventory.func_70301_a(j);
                  if (amountLeft > 0 && stack != null && stack.func_77973_b() == remove.func_77973_b() && stack.func_77960_j() == remove.func_77960_j()) {
                     amountLeft -= inventory.func_70298_a(j, amountLeft).field_77994_a;
                  }
               }
            }

            ItemStack gunStack = new ItemStack(entry.type.getItem());
            if (entry.type instanceof GunType) {
               GunType gunType = (GunType)entry.type;
               NBTTagCompound tags = new NBTTagCompound();
               tags.func_74778_a("Paint", gunType.defaultPaintjob.iconName);
               NBTTagList ammoTagsList = new NBTTagList();

               for(int j = 0; j < gunType.numPrimaryAmmoItems; ++j) {
                  ammoTagsList.func_74742_a(new NBTTagCompound());
               }

               tags.func_74782_a("ammo", ammoTagsList);
               gunStack.field_77990_d = tags;
            }

            if (!inventory.func_70441_a(gunStack)) {
               inventory.field_70458_d.func_71019_a(gunStack, false);
            }
         }
      }

   }

   private GunBoxEntry searchFor(InfoType item) {
      Iterator var2 = this.type.gunPages.iterator();

      while(var2.hasNext()) {
         GunPage page = (GunPage)var2.next();
         GunBoxEntry[] var4 = page.gunList;
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            GunBoxEntry entry = var4[var6];
            if (entry.type == item) {
               return entry;
            }

            if (!entry.isAmmoNullOrEmpty()) {
               Iterator var8 = entry.ammoEntryList.iterator();

               while(var8.hasNext()) {
                  GunBoxEntry ammoEntry = (GunBoxEntry)var8.next();
                  if (ammoEntry.type == item) {
                     return ammoEntry;
                  }
               }
            }
         }
      }

      return null;
   }

   @SideOnly(Side.CLIENT)
   public IIcon func_149691_a(int side, int metadata) {
      if (this.type == null) {
         return null;
      } else if (side == 1) {
         return this.type.top;
      } else {
         return side == 0 ? this.type.bottom : this.type.side;
      }
   }

   public boolean func_149727_a(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {
      if (entityplayer.func_70093_af()) {
         return false;
      } else {
         entityplayer.openGui(FlansMod.INSTANCE, 5, world, i, j, k);
         return true;
      }
   }

   public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
      ArrayList<ItemStack> ret = new ArrayList();
      ret.add(new ItemStack(this, 1, 0));
      return ret;
   }

   public void func_149749_a(World world, int x, int y, int z, Block block, int metadata) {
      super.func_149749_a(world, x, y, z, block, metadata);
   }

   @SideOnly(Side.CLIENT)
   public void func_149651_a(IIconRegister register) {
      this.type.top = register.func_94245_a("FlansMod:" + this.type.topTexturePath);
      this.type.side = register.func_94245_a("FlansMod:" + this.type.sideTexturePath);
      this.type.bottom = register.func_94245_a("FlansMod:" + this.type.bottomTexturePath);
   }
}
