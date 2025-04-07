package com.flansmod.common.network;

import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.ItemGun;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

public class PacketGunSpread extends PacketBase {
   private float spread = 0.0F;

   public PacketGunSpread() {
   }

   public PacketGunSpread(ItemStack stack, float amount) {
      if (stack != null && stack.func_77973_b() instanceof ItemGun) {
         this.spread = amount;
      }

   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeFloat(this.spread);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.spread = data.readFloat();
   }

   public void handleServerSide(EntityPlayerMP player) {
      ItemStack stack = player.field_71071_by.func_70448_g();
      if (stack != null && stack.func_77973_b() instanceof ItemGun) {
         GunType type = ((ItemGun)stack.func_77973_b()).type;
         if (type.getGrip(stack) != null && type.getSecondaryFire(stack)) {
            ((ItemGun)stack.func_77973_b()).type.getGrip(stack).secondarySpread = this.spread;
         } else {
            ((ItemGun)stack.func_77973_b()).type.bulletSpread = this.spread;
         }
      }

   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer client) {
   }
}
