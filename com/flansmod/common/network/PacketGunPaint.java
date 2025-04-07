package com.flansmod.common.network;

import com.flansmod.common.guns.ContainerGunModTable;
import com.flansmod.common.paintjob.ContainerPaintjobTable;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketGunPaint extends PacketBase {
   private int paintjobID;

   public PacketGunPaint() {
   }

   public PacketGunPaint(int i) {
      this.paintjobID = i;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeInt(this.paintjobID);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.paintjobID = data.readInt();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      if (playerEntity.field_71070_bA instanceof ContainerGunModTable) {
         ContainerGunModTable gunModTable = (ContainerGunModTable)playerEntity.field_71070_bA;
         gunModTable.clickPaintjob(this.paintjobID);
      } else if (playerEntity.field_71070_bA instanceof ContainerPaintjobTable) {
         ContainerPaintjobTable paintjobTable = (ContainerPaintjobTable)playerEntity.field_71070_bA;
         paintjobTable.clickPaintjob(this.paintjobID);
      }

   }

   public void handleClientSide(EntityPlayer clientPlayer) {
   }
}
