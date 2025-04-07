package com.flansmod.common.network;

import com.flansmod.api.IControllable;
import com.flansmod.common.FlansMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketDriveableKeyHeld extends PacketBase {
   public int key;
   public boolean held;

   public PacketDriveableKeyHeld() {
   }

   public PacketDriveableKeyHeld(int key, boolean held) {
      this.key = key;
      this.held = held;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeInt(this.key);
      data.writeBoolean(this.held);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.key = data.readInt();
      this.held = data.readBoolean();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      if (playerEntity.field_70154_o != null && playerEntity.field_70154_o instanceof IControllable) {
         ((IControllable)playerEntity.field_70154_o).updateKeyHeldState(this.key, this.held);
      }

   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      FlansMod.log("Driveable key packet received on client. Skipping.");
   }
}
