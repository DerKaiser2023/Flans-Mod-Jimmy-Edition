package com.flansmod.common.network;

import com.flansmod.api.IControllable;
import com.flansmod.common.FlansMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketDriveableKey extends PacketBase {
   public int key;

   public PacketDriveableKey() {
   }

   public PacketDriveableKey(int k) {
      this.key = k;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeInt(this.key);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.key = data.readInt();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      if (playerEntity.field_70154_o != null && playerEntity.field_70154_o instanceof IControllable) {
         ((IControllable)playerEntity.field_70154_o).pressKey(this.key, playerEntity);
      }

   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      FlansMod.log("Driveable keypress packet received on client. Skipping.");
   }
}
