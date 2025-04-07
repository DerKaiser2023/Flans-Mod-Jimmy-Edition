package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.EntitySeat;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class PacketSeatCheck extends PacketBase {
   public int entityId;
   public int checkCount;

   public PacketSeatCheck() {
   }

   public PacketSeatCheck(EntitySeat seat) {
      this.entityId = seat.func_145782_y();
      this.checkCount = 3;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeInt(this.entityId);
      data.writeInt(this.checkCount);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.entityId = data.readInt();
      this.checkCount = data.readInt();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      this.log("handleServerSide", playerEntity);
      if (this.checkCount <= 0) {
         ChatComponentText cct1 = new ChatComponentText("[FlansMod] " + playerEntity.getDisplayName() + " was recovering from a fall. id=" + this.entityId);
         cct1.func_150256_b().func_150238_a(EnumChatFormatting.YELLOW);
         ChatComponentText cct2 = new ChatComponentText("[FlansMod]================================================");
         cct2.func_150256_b().func_150238_a(EnumChatFormatting.RED);
      } else {
         if (playerEntity.field_70154_o instanceof EntitySeat) {
            this.entityId = playerEntity.field_70154_o.func_145782_y();
         } else {
            this.entityId = -1;
         }

         FlansMod.getPacketHandler().sendTo((PacketBase)this, playerEntity);
      }

   }

   private void log(String s, EntityPlayer player) {
      Entity re = player.field_70154_o;
      System.out.println(s + " :" + player.getDisplayName() + " : rideEntity=" + (re != null ? re.getClass().getName() : re) + " : seatEntityId=" + this.entityId + " : check=" + this.checkCount);
   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      this.log("handleClientSide", clientPlayer);
      if (clientPlayer.field_70154_o == null && this.entityId != -1) {
         if (this.checkCount > 1) {
            --this.checkCount;
         } else {
            --this.checkCount;
            Entity entity = clientPlayer.field_70170_p.func_73045_a(this.entityId);
            if (entity instanceof EntitySeat) {
               System.out.println("mount seat :" + clientPlayer.getDisplayName() + " : seatEntityId=" + this.entityId + " : check=" + this.checkCount);
               clientPlayer.func_70078_a(entity);
            }
         }

         FlansMod.getPacketHandler().sendToServer((PacketBase)this);
      }

   }
}
