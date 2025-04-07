package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketParticle extends PacketBase {
   public float x;
   public float y;
   public float z;
   public float mx;
   public float my;
   public float mz;
   public String particleType;

   public PacketParticle() {
   }

   public PacketParticle(String s, double x1, double y1, double z1, double x2, double y2, double z2) {
      this.x = (float)x1;
      this.y = (float)y1;
      this.z = (float)z1;
      this.mx = (float)x2;
      this.my = (float)y2;
      this.mz = (float)z2;
      this.particleType = s;
   }

   public PacketParticle(String s, double x1, double y1, double z1, double x2, double y2, double z2, int time) {
      this.x = (float)x1;
      this.y = (float)y1;
      this.z = (float)z1;
      this.mx = (float)x2;
      this.my = (float)y2;
      this.mz = (float)z2;
      this.particleType = s;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeFloat(this.x);
      data.writeFloat(this.y);
      data.writeFloat(this.z);
      data.writeFloat(this.mx);
      data.writeFloat(this.my);
      data.writeFloat(this.mz);
      this.writeUTF(data, this.particleType);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.x = data.readFloat();
      this.y = data.readFloat();
      this.z = data.readFloat();
      this.mx = data.readFloat();
      this.my = data.readFloat();
      this.mz = data.readFloat();
      this.particleType = this.readUTF(data);
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      FlansMod.log("Received particle packet on server. Disregarding.");
   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      FlansMod.proxy.spawnParticle(this.particleType, (double)this.x, (double)this.y, (double)this.z, (double)this.mx, (double)this.my, (double)this.mz);
   }
}
