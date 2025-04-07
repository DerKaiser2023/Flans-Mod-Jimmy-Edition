package com.flansmod.common.network;

import com.flansmod.client.FlansModResourceHandler;
import com.flansmod.common.FlansMod;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.util.Random;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketPlaySound extends PacketBase {
   public static Random rand = new Random();
   public float posX;
   public float posY;
   public float posZ;
   public String sound;
   public boolean distort;
   public boolean silenced;

   public PacketPlaySound() {
   }

   public static void sendSoundPacket(double x, double y, double z, double range, int dimension, String s, boolean distort) {
      sendSoundPacket(x, y, z, range, dimension, s, distort, false);
   }

   public static void sendSoundPacket(double x, double y, double z, double range, int dimension, String s, boolean distort, boolean silenced) {
      if (s != null && !s.isEmpty()) {
         FlansMod.getPacketHandler().sendToAllAround(new PacketPlaySound(x, y, z, s, distort, silenced), x, y, z, (float)range, dimension);
      }

   }

   public PacketPlaySound(double x, double y, double z, String s) {
      this(x, y, z, s, false);
   }

   public PacketPlaySound(double x, double y, double z, String s, boolean distort) {
      this(x, y, z, s, distort, false);
   }

   public PacketPlaySound(double x, double y, double z, String s, boolean distort, boolean silenced) {
      this.posX = (float)x;
      this.posY = (float)y;
      this.posZ = (float)z;
      this.sound = s;
      this.distort = distort;
      this.silenced = silenced;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeFloat(this.posX);
      data.writeFloat(this.posY);
      data.writeFloat(this.posZ);
      this.writeUTF(data, this.sound);
      data.writeBoolean(this.distort);
      data.writeBoolean(this.silenced);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.posX = data.readFloat();
      this.posY = data.readFloat();
      this.posZ = data.readFloat();
      this.sound = this.readUTF(data);
      this.distort = data.readBoolean();
      this.silenced = data.readBoolean();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      FlansMod.log("Received play sound packet on server. Skipping.");
   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      FMLClientHandler.instance().getClient().func_147118_V().func_147682_a(new PositionedSoundRecord(FlansModResourceHandler.getSound(this.sound), this.silenced ? 5.0F : 10.0F, (this.distort ? 1.0F / (rand.nextFloat() * 0.4F + 0.8F) : 1.0F) * (this.silenced ? 2.0F : 1.0F), this.posX, this.posY, this.posZ));
   }
}
