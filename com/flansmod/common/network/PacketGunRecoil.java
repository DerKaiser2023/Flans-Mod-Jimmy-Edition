package com.flansmod.common.network;

import com.flansmod.client.FlansModClient;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketGunRecoil extends PacketBase {
   public float recoilPitch;
   public float recoilYaw;
   public float decreaseRecoilPitch;
   public float decreaseRecoilYaw;

   public PacketGunRecoil() {
   }

   public PacketGunRecoil(float recoilPitch, float recoilYaw, float decreaseRecoilPitch, float decreaseRecoilYaw) {
      this.recoilPitch = recoilPitch;
      this.recoilYaw = recoilYaw;
      this.decreaseRecoilPitch = decreaseRecoilPitch;
      this.decreaseRecoilYaw = decreaseRecoilYaw;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeFloat(this.recoilPitch);
      data.writeFloat(this.recoilYaw);
      data.writeFloat(this.decreaseRecoilPitch);
      data.writeFloat(this.decreaseRecoilYaw);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.recoilPitch = data.readFloat();
      this.recoilYaw = data.readFloat();
      this.decreaseRecoilPitch = data.readFloat();
      this.decreaseRecoilYaw = data.readFloat();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      if (!clientPlayer.func_70093_af()) {
         FlansModClient.playerRecoilPitch += this.recoilPitch;
         FlansModClient.playerRecoilYaw += this.recoilYaw;
      } else {
         FlansModClient.playerRecoilPitch += this.recoilPitch - this.decreaseRecoilPitch;
         FlansModClient.playerRecoilYaw += this.recoilYaw / this.decreaseRecoilYaw;
      }

   }
}
