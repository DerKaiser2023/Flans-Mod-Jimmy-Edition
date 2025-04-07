package com.flansmod.common.paintjob;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPaintjobTable extends TileEntity implements IInventory, IUpdatePlayerListBox {
   private ItemStack[] inventoryStacks = new ItemStack[2];

   public int func_70302_i_() {
      return 2;
   }

   public ItemStack func_70301_a(int index) {
      return this.inventoryStacks[index];
   }

   public ItemStack func_70298_a(int index, int count) {
      if (this.func_70301_a(index) != null) {
         ItemStack returnStack;
         if (count >= this.func_70301_a(index).field_77994_a) {
            returnStack = this.func_70301_a(index);
            this.func_70299_a(index, (ItemStack)null);
            return returnStack;
         } else {
            returnStack = this.func_70301_a(index).func_77979_a(count);
            return returnStack;
         }
      } else {
         return null;
      }
   }

   public ItemStack func_70304_b(int index) {
      ItemStack returnStack = this.func_70301_a(index);
      this.func_70299_a(index, (ItemStack)null);
      return returnStack;
   }

   public void func_70299_a(int index, ItemStack stack) {
      this.inventoryStacks[index] = stack;
   }

   public int func_70297_j_() {
      return 64;
   }

   public boolean func_70300_a(EntityPlayer player) {
      return true;
   }

   public boolean func_94041_b(int index, ItemStack stack) {
      return true;
   }

   public void func_145841_b(NBTTagCompound nbt) {
      super.func_145841_b(nbt);

      for(int i = 0; i < this.inventoryStacks.length; ++i) {
         NBTTagCompound stackNBT = new NBTTagCompound();
         if (this.func_70301_a(i) != null) {
            this.func_70301_a(i).func_77955_b(stackNBT);
         }

         nbt.func_74782_a("stack_" + i, stackNBT);
      }

   }

   public void func_145839_a(NBTTagCompound nbt) {
      super.func_145839_a(nbt);

      for(int i = 0; i < this.inventoryStacks.length; ++i) {
         this.func_70299_a(i, ItemStack.func_77949_a(nbt.func_74775_l("stack_" + i)));
      }

   }

   public void func_73660_a() {
   }

   public Packet func_145844_m() {
      NBTTagCompound nbt = new NBTTagCompound();
      this.func_145841_b(nbt);
      return new S35PacketUpdateTileEntity(this.field_145851_c, this.field_145848_d, this.field_145849_e, this.func_145832_p(), nbt);
   }

   public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
      this.func_145839_a(packet.func_148857_g());
   }

   public ItemStack getPaintableStack() {
      return this.inventoryStacks[0];
   }

   public void setPaintableStack(ItemStack stack) {
      this.inventoryStacks[0] = stack;
   }

   public ItemStack getPaintCans() {
      return this.inventoryStacks[1];
   }

   public String func_145825_b() {
      return "PaintjobTable";
   }

   public boolean func_145818_k_() {
      return false;
   }

   public void func_70295_k_() {
   }

   public void func_70305_f() {
   }
}
