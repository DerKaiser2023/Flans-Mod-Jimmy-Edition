package com.flansmod.common.network;

import com.flansmod.client.FlansModClient;
import com.flansmod.common.FlansMod;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketFlashBang extends PacketBase {
   public int time = 10;

   public PacketFlashBang() {
   }

   public PacketFlashBang(int flashTime) {
      this.time = flashTime;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeInt(this.time);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.time = data.readInt();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      FlansMod.log("Received flashBang packet on server. Disregarding.");
   }

   public void handleClientSide(EntityPlayer clientPlayer) {
      if (FlansMod.proxy.isThePlayer(clientPlayer)) {
         FlansModClient.isInFlash = true;
      }

      FlansModClient.flashTime = this.time;
   }
}
