package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import com.flansmod.common.guns.ItemGun;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

public class PacketGunFire extends PacketBase {
   public boolean held;
   public boolean left;
   public float yaw;
   public float pitch;

   public PacketGunFire() {
   }

   public PacketGunFire(boolean l, boolean h, float y, float p) {
      this.left = l;
      this.held = h;
      this.yaw = y;
      this.pitch = p;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeBoolean(this.held);
      data.writeBoolean(this.left);
      data.writeFloat(this.yaw);
      data.writeFloat(this.pitch);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.held = data.readBoolean();
      this.left = data.readBoolean();
      this.yaw = data.readFloat();
      this.pitch = data.readFloat();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      ItemStack currentItem = playerEntity.field_71071_by.func_70448_g();
      if (currentItem != null && currentItem.func_77973_b() != null && currentItem.func_77973_b() instanceof ItemGun) {
         float bkYaw = playerEntity.field_70177_z;
         float bkPitch = playerEntity.field_70125_A;
         playerEntity.field_70177_z = this.yaw;
         playerEntity.field_70125_A = this.pitch;
         ((ItemGun)currentItem.func_77973_b()).onMouseHeld(currentItem, playerEntity.field_70170_p, playerEntity, this.left, this.held);
         playerEntity.field_70177_z = bkYaw;
         playerEntity.field_70125_A = bkPitch;
      }

   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      FlansMod.log("Received gun button packet on client. Skipping.");
      ItemStack currentItem = clientPlayer.field_71071_by.func_70448_g();
   }
}
