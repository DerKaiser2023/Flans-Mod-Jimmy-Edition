package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import com.flansmod.common.teams.ArmourBoxType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketBuyArmour extends PacketBase {
   public String boxShortName;
   public String armourShortName;
   public int piece;

   public PacketBuyArmour() {
   }

   public PacketBuyArmour(String box, String armour, int i) {
      this.boxShortName = box;
      this.armourShortName = armour;
      this.piece = i;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.writeUTF(data, this.boxShortName);
      this.writeUTF(data, this.armourShortName);
      data.writeByte((byte)this.piece);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.boxShortName = this.readUTF(data);
      this.armourShortName = this.readUTF(data);
      this.piece = data.readByte();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      ArmourBoxType box = ArmourBoxType.getBox(this.boxShortName);
      box.block.buyArmour(this.armourShortName, this.piece, playerEntity.field_71071_by);
   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      FlansMod.log("Received armour box purchase packet on client. Skipping.");
   }
}
