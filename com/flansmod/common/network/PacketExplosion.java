package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import com.flansmod.common.guns.FlansModExplosion;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketExplosion extends PacketBase {
   public double explosionX;
   public double explosionY;
   public double explosionZ;
   public float explosionSize;

   public PacketExplosion() {
   }

   public PacketExplosion(double x1, double y1, double z1, float s) {
      this.explosionX = x1;
      this.explosionY = y1;
      this.explosionZ = z1;
      this.explosionSize = s;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeDouble(this.explosionX);
      data.writeDouble(this.explosionY);
      data.writeDouble(this.explosionZ);
      data.writeFloat(this.explosionSize);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.explosionX = data.readDouble();
      this.explosionY = data.readDouble();
      this.explosionZ = data.readDouble();
      this.explosionSize = data.readFloat();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      FlansMod.log("Received Explosion packet on server. Disregarding.");
   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      FlansModExplosion.clientExplosion(clientPlayer.field_70170_p, this.explosionSize, this.explosionX, this.explosionY, this.explosionZ);
   }
}
