package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketSelectOffHandGun extends PacketBase {
   public int slot;
   public int entityID;

   public PacketSelectOffHandGun() {
   }

   public PacketSelectOffHandGun(int i) {
      this.slot = i;
   }

   public PacketSelectOffHandGun(EntityPlayer player, int i) {
      this.entityID = player.func_145782_y();
      this.slot = i;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeByte(this.slot);
      data.writeInt(this.entityID);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.slot = data.readByte();
      this.entityID = data.readInt();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      PlayerData data = PlayerHandler.getPlayerData((EntityPlayer)playerEntity, Side.SERVER);
      data.offHandGunSlot = this.slot;
      FlansMod.getPacketHandler().sendToAllAround(new PacketOffHandGunInfo(playerEntity, this.slot), playerEntity.field_70165_t, playerEntity.field_70163_u, playerEntity.field_70161_v, 50.0F, playerEntity.field_71093_bK);
   }

   public void handleClientSide(EntityPlayer clientPlayer) {
      FlansMod.log("Received off hand gun select packet on client. Skipping. Did you mean to send a PacketOffHandGunInfo?");
   }
}
