package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntitySeat;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketDriveableGUI extends PacketBase {
   public int guiID;

   public PacketDriveableGUI() {
   }

   public PacketDriveableGUI(int i) {
      this.guiID = i;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeInt(this.guiID);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.guiID = data.readInt();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      if (playerEntity.field_70154_o != null && playerEntity.field_70154_o instanceof EntitySeat) {
         EntityDriveable d = ((EntitySeat)playerEntity.field_70154_o).driveable;
         switch(this.guiID) {
         case 0:
            playerEntity.openGui(FlansMod.INSTANCE, 6, playerEntity.field_70170_p, d.field_70176_ah, d.field_70162_ai, d.field_70164_aj);
            break;
         case 1:
            playerEntity.openGui(FlansMod.INSTANCE, 7, playerEntity.field_70170_p, d.field_70176_ah, d.field_70162_ai, d.field_70164_aj);
            break;
         case 2:
            playerEntity.openGui(FlansMod.INSTANCE, 8, playerEntity.field_70170_p, d.field_70176_ah, d.field_70162_ai, d.field_70164_aj);
            break;
         case 3:
            playerEntity.openGui(FlansMod.INSTANCE, 9, playerEntity.field_70170_p, d.field_70176_ah, d.field_70162_ai, d.field_70164_aj);
            break;
         case 4:
            playerEntity.openGui(FlansMod.INSTANCE, 10, playerEntity.field_70170_p, d.field_70176_ah, d.field_70162_ai, d.field_70164_aj);
            break;
         case 5:
            playerEntity.openGui(FlansMod.INSTANCE, 12, playerEntity.field_70170_p, d.field_70176_ah, d.field_70162_ai, d.field_70164_aj);
         }
      }

   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      FlansMod.log("Received GUI open packet on client. Skipping.");
   }
}
