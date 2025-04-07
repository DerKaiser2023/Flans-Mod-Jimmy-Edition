package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

public class PacketOffHandGunInfo extends PacketBase {
   public int entityID;
   public ItemStack gunStack;

   public PacketOffHandGunInfo() {
   }

   public PacketOffHandGunInfo(EntityPlayerMP playerEntity, int slot) {
      this.entityID = playerEntity.func_145782_y();
      if (slot == 0) {
         this.gunStack = null;
      } else {
         this.gunStack = playerEntity.field_71071_by.func_70301_a(slot - 1);
      }

   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeInt(this.entityID);
      ByteBufUtils.writeItemStack(data, this.gunStack);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.entityID = data.readInt();
      this.gunStack = ByteBufUtils.readItemStack(data);
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      FlansMod.log("Received off hand gun info packet on server. Skipping. Did you mean to send a PacketSelectOffHandGun?");
   }

   public void handleClientSide(EntityPlayer clientPlayer) {
      Entity entity = clientPlayer.field_70170_p.func_73045_a(this.entityID);
      if (entity instanceof EntityPlayer && entity != clientPlayer) {
         PlayerData data = PlayerHandler.getPlayerData((EntityPlayer)entity, Side.CLIENT);
         data.offHandGunStack = this.gunStack;
      }

   }
}
