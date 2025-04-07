package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.DriveableType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketCraftDriveable extends PacketBase {
   public String shortName;

   public PacketCraftDriveable() {
   }

   public PacketCraftDriveable(String s) {
      this.shortName = s;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.writeUTF(data, this.shortName);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.shortName = this.readUTF(data);
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      DriveableType type = DriveableType.getDriveable(this.shortName);
      FlansMod.proxy.craftDriveable(playerEntity, type);
   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      FlansMod.log("Received driveable repair packet on client side. Skipping.");
   }
}
