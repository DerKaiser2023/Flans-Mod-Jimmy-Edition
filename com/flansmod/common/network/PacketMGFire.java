package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.guns.EntityAAGun;
import com.flansmod.common.guns.EntityMG;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketMGFire extends PacketBase {
   public boolean held;

   public PacketMGFire() {
   }

   public PacketMGFire(boolean h) {
      this.held = h;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeBoolean(this.held);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.held = data.readBoolean();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      EntityMG mg = PlayerHandler.getPlayerData((EntityPlayer)playerEntity).mountingGun;
      if (mg != null) {
         mg.mouseHeld(this.held);
      } else if (playerEntity.field_70154_o instanceof EntityAAGun) {
         ((EntityAAGun)playerEntity.field_70154_o).setMouseHeld(this.held);
      }

   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      FlansMod.log("MG firing packet received on client. Skipping.");
   }
}
