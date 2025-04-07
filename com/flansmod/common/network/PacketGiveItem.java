package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketGiveItem extends PacketBase {
   public int id;

   public PacketGiveItem() {
   }

   public PacketGiveItem(int i) {
      this.id = i;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeInt(this.id);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.id = data.readInt();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      FlansMod.proxy.addItem(playerEntity, this.id);
   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      FlansMod.log("Received armour box purchase packet on client. Skipping.");
   }
}
