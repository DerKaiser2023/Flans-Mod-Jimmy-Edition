package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.FMLOutboundHandler.OutboundTarget;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.handler.codec.MessageToMessageCodec;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.Packet;
import net.minecraft.server.MinecraftServer;

@Sharable
public class PacketHandler extends MessageToMessageCodec<FMLProxyPacket, PacketBase> {
   private EnumMap<Side, FMLEmbeddedChannel> channels;
   private LinkedList<Class<? extends PacketBase>> packets = new LinkedList();
   private boolean modInitialised = false;

   public boolean registerPacket(Class<? extends PacketBase> cl) {
      if (this.packets.size() > 256) {
         FlansMod.log("Packet limit exceeded in Flan's Mod packet handler by packet " + cl.getCanonicalName() + ".");
         return false;
      } else if (this.packets.contains(cl)) {
         FlansMod.log("Tried to register " + cl.getCanonicalName() + " packet class twice.");
         return false;
      } else if (this.modInitialised) {
         FlansMod.log("Tried to register packet " + cl.getCanonicalName() + " after mod initialisation.");
         return false;
      } else {
         this.packets.add(cl);
         return true;
      }
   }

   protected void encode(ChannelHandlerContext ctx, PacketBase msg, List<Object> out) throws Exception {
      ByteBuf encodedData = Unpooled.buffer();
      Class<? extends PacketBase> cl = msg.getClass();
      if (!this.packets.contains(cl)) {
         throw new NullPointerException("Packet not registered : " + cl.getCanonicalName());
      } else {
         byte discriminator = (byte)this.packets.indexOf(cl);
         encodedData.writeByte(discriminator);
         msg.encodeInto(ctx, encodedData);
         FMLProxyPacket proxyPacket = new FMLProxyPacket(encodedData.copy(), (String)ctx.channel().attr(NetworkRegistry.FML_CHANNEL).get());
         out.add(proxyPacket);
      }
   }

   protected void decode(ChannelHandlerContext ctx, FMLProxyPacket msg, List<Object> out) throws Exception {
      ByteBuf encodedData = msg.payload();
      byte discriminator = encodedData.readByte();
      Class<? extends PacketBase> cl = (Class)this.packets.get(discriminator);
      if (cl == null) {
         throw new NullPointerException("Packet not registered for discriminator : " + discriminator);
      } else {
         PacketBase packet = (PacketBase)cl.newInstance();
         packet.decodeInto(ctx, encodedData.slice());
         switch(FMLCommonHandler.instance().getEffectiveSide()) {
         case CLIENT:
            packet.handleClientSide(this.getClientPlayer());
            break;
         case SERVER:
            INetHandler netHandler = (INetHandler)ctx.channel().attr(NetworkRegistry.NET_HANDLER).get();
            packet.handleServerSide(((NetHandlerPlayServer)netHandler).field_147369_b);
         }

      }
   }

   public void initialise() {
      this.channels = NetworkRegistry.INSTANCE.newChannel("FlansMod", new ChannelHandler[]{this});
      this.registerPacket(PacketAAGunAngles.class);
      this.registerPacket(PacketBaseEdit.class);
      this.registerPacket(PacketBreakSound.class);
      this.registerPacket(PacketBuyArmour.class);
      this.registerPacket(PacketBuyWeapon.class);
      this.registerPacket(PacketCraftDriveable.class);
      this.registerPacket(PacketDriveableControl.class);
      this.registerPacket(PacketDriveableDamage.class);
      this.registerPacket(PacketDriveableGUI.class);
      this.registerPacket(PacketDriveableKey.class);
      this.registerPacket(PacketDriveableKeyHeld.class);
      this.registerPacket(PacketFlak.class);
      this.registerPacket(PacketExplosion.class);
      this.registerPacket(PacketGunFire.class);
      this.registerPacket(PacketGunMode.class);
      this.registerPacket(PacketGunPaint.class);
      this.registerPacket(PacketGunSpread.class);
      this.registerPacket(PacketKillMessage.class);
      this.registerPacket(PacketMechaControl.class);
      this.registerPacket(PacketMGFire.class);
      this.registerPacket(PacketMGMount.class);
      this.registerPacket(PacketOffHandGunInfo.class);
      this.registerPacket(PacketParticle.class);
      this.registerPacket(PacketPlaneControl.class);
      this.registerPacket(PacketPlaySound.class);
      this.registerPacket(PacketReload.class);
      this.registerPacket(PacketRepairDriveable.class);
      this.registerPacket(PacketRoundFinished.class);
      this.registerPacket(PacketSeatUpdates.class);
      this.registerPacket(PacketSeatCheck.class);
      this.registerPacket(PacketSelectOffHandGun.class);
      this.registerPacket(PacketTeamInfo.class);
      this.registerPacket(PacketTeamSelect.class);
      this.registerPacket(PacketVehicleControl.class);
      this.registerPacket(PacketVoteCast.class);
      this.registerPacket(PacketVoting.class);
      this.registerPacket(PacketRequestDebug.class);
      this.registerPacket(PacketFlashBang.class);
      this.registerPacket(PacketImpactPoint.class);
      this.registerPacket(PacketModConfig.class);
      this.registerPacket(PacketGunRecoil.class);
      this.registerPacket(PacketGunState.class);
   }

   public void postInitialise() {
      if (!this.modInitialised) {
         this.modInitialised = true;
         Collections.sort(this.packets, new Comparator<Class<? extends PacketBase>>() {
            public int compare(Class<? extends PacketBase> c1, Class<? extends PacketBase> c2) {
               int com = String.CASE_INSENSITIVE_ORDER.compare(c1.getCanonicalName(), c2.getCanonicalName());
               if (com == 0) {
                  com = c1.getCanonicalName().compareTo(c2.getCanonicalName());
               }

               return com;
            }
         });
      }
   }

   @SideOnly(Side.CLIENT)
   private EntityPlayer getClientPlayer() {
      return Minecraft.func_71410_x().field_71439_g;
   }

   public void sendToAll(PacketBase packet) {
      ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(OutboundTarget.ALL);
      ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).writeAndFlush(packet);
   }

   public void sendTo(PacketBase packet, EntityPlayerMP player) {
      ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(OutboundTarget.PLAYER);
      ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
      ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).writeAndFlush(packet);
   }

   public void sendToAllAround(PacketBase packet, TargetPoint point) {
      ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(OutboundTarget.ALLAROUNDPOINT);
      ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(point);
      ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).writeAndFlush(packet);
   }

   public void sendToDimension(PacketBase packet, int dimensionID) {
      ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(OutboundTarget.DIMENSION);
      ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(dimensionID);
      ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).writeAndFlush(packet);
   }

   public void sendToServer(PacketBase packet) {
      ((FMLEmbeddedChannel)this.channels.get(Side.CLIENT)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(OutboundTarget.TOSERVER);
      ((FMLEmbeddedChannel)this.channels.get(Side.CLIENT)).writeAndFlush(packet);
   }

   public void sendToAll(Packet packet) {
      MinecraftServer.func_71276_C().func_71203_ab().func_148540_a(packet);
   }

   public void sendTo(Packet packet, EntityPlayerMP player) {
      player.field_71135_a.func_147359_a(packet);
   }

   public void sendToAllAround(Packet packet, TargetPoint point) {
      MinecraftServer.func_71276_C().func_71203_ab().func_148541_a(point.x, point.y, point.z, point.range, point.dimension, packet);
   }

   public void sendToDimension(Packet packet, int dimensionID) {
      MinecraftServer.func_71276_C().func_71203_ab().func_148537_a(packet, dimensionID);
   }

   public void sendToServer(Packet packet) {
      Minecraft.func_71410_x().field_71439_g.field_71174_a.func_147297_a(packet);
   }

   public void sendToAllAround(PacketBase packet, double x, double y, double z, float range, int dimension) {
      this.sendToAllAround(packet, new TargetPoint(dimension, x, y, z, (double)range));
   }
}
