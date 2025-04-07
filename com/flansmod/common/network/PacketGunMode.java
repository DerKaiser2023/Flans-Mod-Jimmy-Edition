package com.flansmod.common.network;

import com.flansmod.client.FlansModClient;
import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.guns.AttachmentType;
import com.flansmod.common.guns.EnumFireMode;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.ItemGun;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

public class PacketGunMode extends PacketBase {
   private int handle;
   public EnumFireMode mode;
   public boolean isInSecondary;

   public PacketGunMode() {
      this.mode = EnumFireMode.SEMIAUTO;
   }

   public PacketGunMode(int aHandle) {
      this.mode = EnumFireMode.SEMIAUTO;
      this.handle = aHandle;
   }

   public PacketGunMode(EnumFireMode md) {
      this.mode = EnumFireMode.SEMIAUTO;
      this.mode = md;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeByte(this.mode.ordinal());
      data.writeByte(this.handle);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      int i = data.readByte();
      if (i < EnumFireMode.values().length) {
         this.mode = EnumFireMode.values()[i];
      }

      this.handle = data.readByte();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      ItemStack itemStack = playerEntity.field_71071_by.func_70448_g();
      if (this.handle == 1) {
         if (itemStack != null && itemStack.func_77973_b() instanceof ItemGun) {
            ItemGun gun = (ItemGun)itemStack.func_77973_b();
            EnumFireMode currentMode = gun.type.getFireMode(itemStack);
            EnumFireMode nextMode = currentMode;
            EnumFireMode[] submode = gun.type.submode;

            for(int i = 0; i < submode.length; ++i) {
               if (currentMode == submode[i]) {
                  nextMode = submode[(i + 1) % submode.length];
                  break;
               }
            }

            if (currentMode != nextMode) {
               gun.type.setFireMode(itemStack, nextMode.ordinal());
               FlansMod.getPacketHandler().sendTo((PacketBase)(new PacketGunMode(nextMode)), playerEntity);
            }
         }
      } else {
         PlayerData data = PlayerHandler.getPlayerData((EntityPlayer)playerEntity);
         if (data.shootTimeLeft <= 0 && itemStack != null && itemStack.func_77973_b() instanceof ItemGun) {
            GunType type = ((ItemGun)itemStack.func_77973_b()).type;
            AttachmentType attachment = type.getGrip(itemStack);
            if (attachment != null && attachment.secondaryFire) {
               boolean mode = type.getSecondaryFire(itemStack);
               ((ItemGun)itemStack.func_77973_b()).type.setSecondaryFire(itemStack, !mode);
               if (attachment.toggleSound != null) {
                  PacketPlaySound.sendSoundPacket(playerEntity.field_70165_t, playerEntity.field_70163_u, playerEntity.field_70161_v, (double)type.reloadSoundRange, playerEntity.field_71093_bK, attachment.toggleSound, true);
               }
            }
         }
      }

   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      ItemStack itemStack = clientPlayer.field_71071_by.func_70448_g();
      if (this.handle == 1) {
         if (itemStack != null && itemStack.func_77973_b() instanceof ItemGun) {
            ((ItemGun)itemStack.func_77973_b()).type.setFireMode(itemStack, this.mode.ordinal());
         }
      } else if (FlansModClient.shootTimeLeft <= 0) {
         GunType type = ((ItemGun)itemStack.func_77973_b()).type;
         AttachmentType attachment = type.getGrip(itemStack);
         if (attachment != null && attachment.secondaryFire) {
            boolean mode = type.getSecondaryFire(itemStack);
            ((ItemGun)itemStack.func_77973_b()).type.setSecondaryFire(itemStack, !mode);
         }
      }

   }
}
