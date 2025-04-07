package com.flansmod.common.network;

import com.flansmod.client.FlansModClient;
import com.flansmod.client.model.GunAnimations;
import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.guns.AttachmentType;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.guns.ItemShootable;
import com.flansmod.common.guns.ShootableType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

public class PacketReload extends PacketBase {
   public boolean left;

   public PacketReload() {
   }

   public PacketReload(boolean l) {
      this.left = l;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeBoolean(this.left);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.left = data.readBoolean();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      PlayerData data = PlayerHandler.getPlayerData((EntityPlayer)playerEntity);
      ItemStack stack = playerEntity.func_71045_bC();
      if (this.left && data.offHandGunSlot != 0) {
         stack = playerEntity.field_71071_by.func_70301_a(data.offHandGunSlot - 1);
      }

      if (data != null && stack != null && stack.func_77973_b() instanceof ItemGun) {
         GunType type = ((ItemGun)stack.func_77973_b()).type;
         boolean empty = true;

         for(int i = 0; i < type.getNumAmmoItemsInGun(stack); ++i) {
            ItemStack bulletStack = ((ItemGun)stack.func_77973_b()).getBulletItemStack(stack, i);
            if (bulletStack != null && bulletStack.func_77973_b() != null && bulletStack.func_77960_j() < bulletStack.func_77958_k()) {
               empty = false;
               break;
            }
         }

         if (((ItemGun)stack.func_77973_b()).reload(stack, type, playerEntity.field_70170_p, playerEntity, true, this.left)) {
            data.shootTimeRight = data.shootTimeLeft = type.reloadTime;
            if (this.left) {
               data.reloadingLeft = true;
            } else {
               data.reloadingRight = true;
            }

            FlansMod.getPacketHandler().sendTo((PacketBase)(new PacketReload(this.left)), playerEntity);
            String soundToPlay = null;
            AttachmentType grip = type.getGrip(stack);
            if (type.getSecondaryFire(stack) && grip != null && grip.secondaryReloadSound != null) {
               soundToPlay = grip.secondaryReloadSound;
            } else if (empty && type.reloadSoundOnEmpty != null) {
               soundToPlay = type.reloadSoundOnEmpty;
            } else if (type.reloadSound != null) {
               soundToPlay = type.reloadSound;
            }

            if (soundToPlay != null) {
               PacketPlaySound.sendSoundPacket(playerEntity.field_70165_t, playerEntity.field_70163_u, playerEntity.field_70161_v, (double)type.reloadSoundRange, playerEntity.field_71093_bK, soundToPlay, true);
            }
         }
      }

   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      ItemStack stack = clientPlayer.func_71045_bC();
      PlayerData data = PlayerHandler.getPlayerData(clientPlayer, Side.CLIENT);
      if (this.left) {
         stack = clientPlayer.field_71071_by.func_70301_a(data.offHandGunSlot - 1);
      }

      if (stack != null && stack.func_77973_b() instanceof ItemGun) {
         GunType type = ((ItemGun)stack.func_77973_b()).type;
         if (this.left) {
            FlansModClient.shootTimeLeft = (int)type.getReloadTime(stack);
         } else {
            FlansModClient.shootTimeRight = (int)type.getReloadTime(stack);
         }

         GunAnimations animations = null;
         if (this.left) {
            if (FlansModClient.gunAnimationsLeft.containsKey(clientPlayer)) {
               animations = (GunAnimations)FlansModClient.gunAnimationsLeft.get(clientPlayer);
            } else {
               animations = new GunAnimations();
               FlansModClient.gunAnimationsLeft.put(clientPlayer, animations);
            }
         } else if (FlansModClient.gunAnimationsRight.containsKey(clientPlayer)) {
            animations = (GunAnimations)FlansModClient.gunAnimationsRight.get(clientPlayer);
         } else {
            animations = new GunAnimations();
            FlansModClient.gunAnimationsRight.put(clientPlayer, animations);
         }

         int pumpDelay = type.model == null ? 0 : type.model.pumpDelayAfterReload;
         int pumpTime = type.model == null ? 1 : type.model.pumpTime;
         int chargeDelay = type.model == null ? 0 : type.model.chargeDelayAfterReload;
         int chargeTime = type.model == null ? 1 : type.model.chargeTime;
         animations.doReload((int)type.getReloadTime(stack), pumpDelay, pumpTime, chargeDelay, chargeTime);
         int bestSlot = -1;
         int bulletsInBestSlot = 0;

         for(int j = 0; j < clientPlayer.field_71071_by.func_70302_i_(); ++j) {
            ItemStack item = clientPlayer.field_71071_by.func_70301_a(j);
            if (item != null && item.func_77973_b() instanceof ItemShootable && type.isAmmo(((ItemShootable)((ItemShootable)item.func_77973_b())).type, stack)) {
               int bulletsInThisSlot = item.func_77958_k() - item.func_77960_j();
               if (bulletsInThisSlot > bulletsInBestSlot) {
                  bestSlot = j;
                  bulletsInBestSlot = bulletsInThisSlot;
               }
            }
         }

         if (bestSlot != -1) {
            ItemStack newBulletStack = clientPlayer.field_71071_by.func_70301_a(bestSlot);
            ShootableType newBulletType = ((ItemShootable)newBulletStack.func_77973_b()).type;
            if (!clientPlayer.field_71075_bZ.field_75098_d) {
               --newBulletStack.field_77994_a;
            }

            if (newBulletStack.field_77994_a <= 0) {
               newBulletStack = null;
            }

            clientPlayer.field_71071_by.func_70299_a(bestSlot, newBulletStack);
         }
      }

   }
}
