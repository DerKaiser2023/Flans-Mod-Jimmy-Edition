package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import com.flansmod.common.guns.boxes.GunBoxType;
import com.flansmod.common.types.InfoType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketBuyWeapon extends PacketBase {
   public String boxShortName;
   public String itemShortName;

   public PacketBuyWeapon() {
   }

   public PacketBuyWeapon(GunBoxType box, InfoType type) {
      this.boxShortName = box.shortName;
      this.itemShortName = type.shortName;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.writeUTF(data, this.boxShortName);
      this.writeUTF(data, this.itemShortName);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.boxShortName = this.readUTF(data);
      this.itemShortName = this.readUTF(data);
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      GunBoxType box = GunBoxType.getBox(this.boxShortName);
      box.block.buyGun(InfoType.getType(this.itemShortName), playerEntity.field_71071_by, box);
   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      FlansMod.log("Received gun box purchase packet on client. Skipping.");
   }
}
