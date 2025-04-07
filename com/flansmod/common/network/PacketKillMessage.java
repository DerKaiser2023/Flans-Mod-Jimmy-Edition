package com.flansmod.common.network;

import com.flansmod.client.TickHandlerClient;
import com.flansmod.common.FlansMod;
import com.flansmod.common.types.InfoType;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketKillMessage extends PacketBase {
   public InfoType killedBy;
   public String killerName;
   public String killedName;
   public boolean headshot;

   public PacketKillMessage() {
   }

   public PacketKillMessage(boolean head, InfoType weapon, String victim, String murderer) {
      this.killedBy = weapon;
      this.killerName = murderer;
      this.killedName = victim;
      this.headshot = head;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeBoolean(this.headshot);
      this.writeUTF(data, this.killedBy.shortName);
      this.writeUTF(data, this.killerName);
      this.writeUTF(data, this.killedName);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.headshot = data.readBoolean();
      this.killedBy = InfoType.getType(this.readUTF(data));
      this.killerName = this.readUTF(data);
      this.killedName = this.readUTF(data);
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      FlansMod.log("Received kill message packet on the server. Skipping.");
   }

   public void handleClientSide(EntityPlayer clientPlayer) {
      TickHandlerClient.addKillMessage(this.headshot, this.killedBy, this.killerName, this.killedName);
   }
}
