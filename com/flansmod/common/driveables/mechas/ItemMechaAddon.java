package com.flansmod.common.driveables.mechas;

import com.flansmod.common.FlansMod;
import com.flansmod.common.types.IFlanItem;
import com.flansmod.common.types.InfoType;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemMechaAddon extends Item implements IFlanItem {
   public MechaItemType type;

   public ItemMechaAddon(MechaItemType type1) {
      this.type = type1;
      this.func_77625_d(1);
      this.type.item = this;
      this.func_77637_a(FlansMod.tabFlanMechas);
      GameRegistry.registerItem(this, this.type.shortName, "flansmod");
   }

   public void func_77624_a(ItemStack stack, EntityPlayer player, List list, boolean b) {
      if (!this.type.packName.isEmpty()) {
         list.add(this.type.packName);
      }

      if (this.type.description != null) {
         Collections.addAll(list, this.type.description.split("_"));
      }

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
