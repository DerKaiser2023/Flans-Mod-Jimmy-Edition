package com.flansmod.common.network;

import com.flansmod.common.guns.EntityAAGun;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketAAGunAngles extends PacketBase {
   public int entityID;
   public float gunYaw;
   public float gunPitch;

   public PacketAAGunAngles() {
   }

   public PacketAAGunAngles(EntityAAGun entity) {
      this.entityID = entity.func_145782_y();
      this.gunYaw = entity.gunYaw;
      this.gunPitch = entity.gunPitch;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeInt(this.entityID);
      data.writeFloat(this.gunYaw);
      data.writeFloat(this.gunPitch);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.entityID = data.readInt();
      this.gunYaw = data.readFloat();
      this.gunPitch = data.readFloat();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
   }

   public void handleClientSide(EntityPlayer clientPlayer) {
      Entity entity = clientPlayer.field_70170_p.func_73045_a(this.entityID);
      if (entity instanceof EntityAAGun) {
         EntityAAGun aa = (EntityAAGun)entity;
         aa.prevGunYaw = aa.gunYaw;
         aa.prevGunPitch = aa.gunPitch;
         aa.gunYaw = this.gunYaw;
         aa.gunPitch = this.gunPitch;
      }

   }
}
