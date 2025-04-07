package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.DriveablePart;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EnumDriveablePart;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.util.Iterator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketDriveableDamage extends PacketBase {
   public int entityId;
   public short[] health;
   public boolean[] onFire;

   public PacketDriveableDamage() {
      this.health = new short[EnumDriveablePart.values().length];
      this.onFire = new boolean[EnumDriveablePart.values().length];
   }

   public PacketDriveableDamage(EntityDriveable driveable) {
      this.entityId = driveable.func_145782_y();
      this.health = new short[EnumDriveablePart.values().length];
      this.onFire = new boolean[EnumDriveablePart.values().length];

      for(int i = 0; i < EnumDriveablePart.values().length; ++i) {
         EnumDriveablePart ep = EnumDriveablePart.values()[i];
         DriveablePart part = (DriveablePart)driveable.getDriveableData().parts.get(ep);
         this.health[i] = (short)part.health;
         this.onFire[i] = part.onFire;
      }

   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeInt(this.entityId);

      for(int i = 0; i < EnumDriveablePart.values().length; ++i) {
         data.writeShort(this.health[i]);
         data.writeBoolean(this.onFire[i]);
      }

   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.entityId = data.readInt();

      for(int i = 0; i < EnumDriveablePart.values().length; ++i) {
         this.health[i] = data.readShort();
         this.onFire[i] = data.readBoolean();
      }

   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      FlansMod.log("Driveable damage packet received on server. Skipping.");
   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      EntityDriveable driveable = null;
      Iterator var3 = clientPlayer.field_70170_p.field_72996_f.iterator();

      while(var3.hasNext()) {
         Object obj = var3.next();
         if (obj instanceof EntityDriveable && ((Entity)obj).func_145782_y() == this.entityId) {
            driveable = (EntityDriveable)obj;
            break;
         }
      }

      if (driveable != null) {
         for(int i = 0; i < EnumDriveablePart.values().length; ++i) {
            EnumDriveablePart ep = EnumDriveablePart.values()[i];
            DriveablePart part = (DriveablePart)driveable.getDriveableData().parts.get(ep);
            part.health = this.health[i];
            part.onFire = this.onFire[i];
         }
      }

   }
}
