package com.flansmod.common.teams;

import com.flansmod.common.CraftingInstance;
import com.flansmod.common.FlansMod;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockArmourBox extends Block {
   public ArmourBoxType type;

   public BlockArmourBox(ArmourBoxType t) throws Exception {
      super(Material.field_151575_d);
      this.type = t;
      this.func_149663_c(this.type.shortName);
      this.func_149711_c(2.0F);
      this.func_149752_b(4.0F);
      Block block = Block.func_149684_b("flansmod:armorBox." + this.type.shortName);
      if (block != null) {
         throw new Exception("Caught an exception during block registration");
      } else {
         GameRegistry.registerBlock(this, "armorBox." + this.type.shortName);
         this.func_149647_a(FlansMod.tabFlanTeams);
         this.type.block = this;
         this.type.item = Item.func_150898_a(this);
      }
   }

   public void buyArmour(String shortName, int piece, InventoryPlayer inventory) {
      if (FMLCommonHandler.instance().getEffectiveSide().isClient()) {
         FlansMod.proxy.buyArmour(shortName, piece, this.type);
      }

      ArmourBoxType.ArmourBoxEntry entryPicked = null;
      Iterator var5 = this.type.pages.iterator();

      while(var5.hasNext()) {
         ArmourBoxType.ArmourBoxEntry page = (ArmourBoxType.ArmourBoxEntry)var5.next();
         if (page.shortName.equals(shortName)) {
            entryPicked = page;
         }
      }

      ItemStack resultStack = new ItemStack(entryPicked.armours[piece].item);
      CraftingInstance crafting = new CraftingInstance(inventory, entryPicked.requiredStacks[piece], resultStack);
      if (crafting.canCraft()) {
         crafting.craft(inventory.field_70458_d);
      }

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

   @SideOnly(Side.CLIENT)
   public void func_149651_a(IIconRegister register) {
      this.type.top = register.func_94245_a("FlansMod:" + this.type.topTexturePath);
      this.type.side = register.func_94245_a("FlansMod:" + this.type.sideTexturePath);
      this.type.bottom = register.func_94245_a("FlansMod:" + this.type.bottomTexturePath);
   }

   public boolean func_149727_a(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {
      if (entityplayer.func_70093_af()) {
         return false;
      } else {
         entityplayer.openGui(FlansMod.INSTANCE, 11, world, i, j, k);
         return true;
      }
   }
}
