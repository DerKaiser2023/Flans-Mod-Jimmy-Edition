package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import com.flansmod.common.guns.ItemGun;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketImpactPoint extends PacketBase {
   public int x;
   public int y;
   public int z;
   public int entityId;

   public PacketImpactPoint() {
   }

   public PacketImpactPoint(int x, int y, int z, int entityId) {
      this.x = x;
      this.y = y;
      this.z = z;
      this.entityId = entityId;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeInt(this.x);
      data.writeInt(this.y);
      data.writeInt(this.z);
      data.writeInt(this.entityId);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.x = data.readInt();
      this.y = data.readInt();
      this.z = data.readInt();
      this.entityId = data.readInt();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      if (playerEntity.func_71045_bC() != null && playerEntity.func_71045_bC().func_77973_b() instanceof ItemGun) {
         ItemGun itemGun = (ItemGun)playerEntity.func_71045_bC().func_77973_b();
         itemGun.impactX = this.x;
         itemGun.impactY = this.y;
         itemGun.impactZ = this.z;
      }

   }

   public void handleClientSide(EntityPlayer clientPlayer) {
      FlansMod.log("Received impactpoint packet on client. Disregarding.");
   }
}
