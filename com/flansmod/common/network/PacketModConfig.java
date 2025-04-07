package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketModConfig extends PacketBase {
   public boolean hitCrossHairEnable;
   public boolean bulletGuiEnable;
   public boolean crosshairEnable;
   public boolean gunCarryLimitEnable;
   public int gunCarryLimit;

   public PacketModConfig() {
      this.hitCrossHairEnable = FlansMod.hitCrossHairEnable;
      this.bulletGuiEnable = FlansMod.bulletGuiEnable;
      this.crosshairEnable = FlansMod.crosshairEnable;
      this.gunCarryLimitEnable = FlansMod.gunCarryLimitEnable;
      this.gunCarryLimit = FlansMod.gunCarryLimit;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeBoolean(this.hitCrossHairEnable);
      data.writeBoolean(this.bulletGuiEnable);
      data.writeBoolean(this.crosshairEnable);
      data.writeBoolean(this.gunCarryLimitEnable);
      data.writeInt(this.gunCarryLimit);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.hitCrossHairEnable = data.readBoolean();
      this.bulletGuiEnable = data.readBoolean();
      this.crosshairEnable = data.readBoolean();
      this.gunCarryLimitEnable = data.readBoolean();
      this.gunCarryLimit = data.readInt();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      FlansMod.hitCrossHairEnable = this.hitCrossHairEnable;
      FlansMod.bulletGuiEnable = this.bulletGuiEnable;
      FlansMod.crosshairEnable = this.crosshairEnable;
      FlansMod.gunCarryLimitEnable = this.gunCarryLimitEnable;
      FlansMod.gunCarryLimit = this.gunCarryLimit;
      FlansMod.log("Config synced successfully");
   }
}
