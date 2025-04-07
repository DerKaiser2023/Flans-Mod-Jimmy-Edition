package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class PacketRequestDebug extends PacketBase {
   private boolean debug;

   public PacketRequestDebug() {
   }

   public PacketRequestDebug(boolean debug) {
      this.debug = debug;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeByte(this.debug ? 1 : 0);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.debug = data.readByte() != 0;
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      if (MinecraftServer.func_71276_C().func_71203_ab().func_152596_g(playerEntity.func_146103_bH())) {
         FlansMod.packetHandler.sendTo((PacketBase)(new PacketRequestDebug(true)), playerEntity);
      }

   }

   public void handleClientSide(EntityPlayer clientPlayer) {
      FlansMod.DEBUG = this.debug;
   }
}
