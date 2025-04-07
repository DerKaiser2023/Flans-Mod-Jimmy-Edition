package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import com.flansmod.common.guns.EntityMG;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketMGMount extends PacketBase {
   public int playerEntityId;
   public int mgEntityId;
   public boolean mounting;

   public PacketMGMount() {
   }

   public PacketMGMount(EntityPlayer player, EntityMG mg, boolean mounting) {
      this.playerEntityId = player.func_145782_y();
      this.mgEntityId = mg.func_145782_y();
      this.mounting = mounting;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeInt(this.playerEntityId);
      data.writeInt(this.mgEntityId);
      data.writeBoolean(this.mounting);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.playerEntityId = data.readInt();
      this.mgEntityId = data.readInt();
      this.mounting = data.readBoolean();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      FlansMod.log("Received MG mount packet on server. Skipping.");
   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      EntityPlayer player = (EntityPlayer)clientPlayer.field_70170_p.func_73045_a(this.playerEntityId);
      EntityMG mg = (EntityMG)clientPlayer.field_70170_p.func_73045_a(this.mgEntityId);
      if (mg != null && player != null) {
         mg.mountGun(player, this.mounting);
      }

   }
}
