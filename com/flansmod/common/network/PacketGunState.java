package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import com.flansmod.common.eventhandlers.ServerTickEvent;
import com.flansmod.common.guns.AttachmentType;
import com.flansmod.common.guns.ItemGun;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class PacketGunState extends PacketBase {
   boolean isScoped;

   public PacketGunState() {
   }

   public PacketGunState(boolean isScoped) {
      this.isScoped = isScoped;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeBoolean(this.isScoped);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.isScoped = data.readBoolean();
   }

   public void handleServerSide(EntityPlayerMP player) {
      FlansMod.log("Gun state packet received + isScoped; " + this.isScoped);
      if (player.func_71045_bC() != null && player.func_71045_bC().func_77973_b() instanceof ItemGun) {
         ItemGun itemGun = (ItemGun)player.func_71045_bC().func_77973_b();
         ItemStack itemstack = player.func_71045_bC();
         AttachmentType scope = itemGun.type.getScope(itemstack);
         System.out.println("est");
         if (scope != null && scope.hasNightVision && this.isScoped) {
            System.out.println("sdas");
            player.func_70690_d(new PotionEffect(Potion.field_76439_r.field_76415_H, 2400, 0));
            ServerTickEvent.nightVisionPlayers.add(player);
         } else if (scope != null && scope.hasNightVision && !this.isScoped) {
            player.func_82170_o(Potion.field_76439_r.field_76415_H);
            ServerTickEvent.nightVisionPlayers.remove(player);
         }
      }

   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
   }
}
