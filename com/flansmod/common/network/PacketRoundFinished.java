package com.flansmod.common.network;

import com.flansmod.client.FlansModClient;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketRoundFinished extends PacketBase {
   public int showScoresFor;

   public PacketRoundFinished() {
   }

   public PacketRoundFinished(int i) {
      this.showScoresFor = i;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeInt(this.showScoresFor);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.showScoresFor = data.readInt();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      FlansModClient.teamsScoreGUILock = this.showScoresFor;
   }
}
