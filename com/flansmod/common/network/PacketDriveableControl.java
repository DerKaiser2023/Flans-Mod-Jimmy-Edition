package com.flansmod.common.network;

import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntityPlane;
import com.flansmod.common.driveables.EntityVehicle;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.util.Iterator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketDriveableControl extends PacketBase {
   public int entityId;
   public double posX;
   public double posY;
   public double posZ;
   public double prevPosX;
   public double prevPosY;
   public double prevPosZ;
   public float yaw;
   public float pitch;
   public float roll;
   public double motX;
   public double motY;
   public double motZ;
   public float avelx;
   public float avely;
   public float avelz;
   public float throttle;
   public float fuelInTank;
   public float steeringYaw;
   public float recoilPos;
   public float lastRecoilPos;
   public float propAngle;
   public float prevPropAngle;
   public float rotorAngle;
   public float prevRotorAngle;
   public boolean flare;
   public boolean canFire;
   public boolean reload;
   public int stage;
   public int stageDelay;
   public String key;

   public PacketDriveableControl() {
   }

   public PacketDriveableControl(EntityDriveable driveable) {
      this.entityId = driveable.func_145782_y();
      this.posX = driveable.field_70165_t;
      this.posY = driveable.field_70163_u;
      this.posZ = driveable.field_70161_v;
      this.prevPosX = driveable.field_70169_q;
      this.prevPosY = driveable.field_70167_r;
      this.prevPosZ = driveable.field_70166_s;
      this.yaw = driveable.axes.getYaw();
      this.pitch = driveable.axes.getPitch();
      this.roll = driveable.axes.getRoll();
      this.motX = driveable.field_70159_w;
      this.motY = driveable.field_70181_x;
      this.motZ = driveable.field_70179_y;
      this.avelx = driveable.angularVelocity.x;
      this.avely = driveable.angularVelocity.y;
      this.avelz = driveable.angularVelocity.z;
      this.throttle = driveable.throttle;
      this.fuelInTank = driveable.driveableData.fuelInTank;
      this.recoilPos = driveable.recoilPos;
      this.lastRecoilPos = driveable.lastRecoilPos;
      this.flare = driveable.ticksFlareUsing > 0;
      if (driveable instanceof EntityVehicle) {
         EntityVehicle veh = (EntityVehicle)driveable;
         this.steeringYaw = veh.wheelsYaw;
      } else if (driveable instanceof EntityPlane) {
         EntityPlane plane = (EntityPlane)driveable;
         this.steeringYaw = plane.flapsYaw;
      }

      this.propAngle = driveable.propAngle;
      this.prevPropAngle = driveable.prevPropAngle;
      this.rotorAngle = driveable.rotorAngle;
      this.prevRotorAngle = driveable.prevRotorAngle;
      this.stage = driveable.stage;
      this.stageDelay = driveable.reloadAnimTime;
      this.canFire = driveable.canFireIT1;
      this.reload = driveable.reloadingDrakon;
      this.key = driveable.key;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeInt(this.entityId);
      data.writeDouble(this.posX);
      data.writeDouble(this.posY);
      data.writeDouble(this.posZ);
      data.writeDouble(this.prevPosX);
      data.writeDouble(this.prevPosY);
      data.writeDouble(this.prevPosZ);
      data.writeFloat(this.yaw);
      data.writeFloat(this.pitch);
      data.writeFloat(this.roll);
      data.writeDouble(this.motX);
      data.writeDouble(this.motY);
      data.writeDouble(this.motZ);
      data.writeFloat(this.avelx);
      data.writeFloat(this.avely);
      data.writeFloat(this.avelz);
      data.writeFloat(this.throttle);
      data.writeFloat(this.fuelInTank);
      data.writeFloat(this.steeringYaw);
      data.writeFloat(this.recoilPos);
      data.writeFloat(this.lastRecoilPos);
      data.writeFloat(this.propAngle);
      data.writeFloat(this.prevPropAngle);
      data.writeFloat(this.rotorAngle);
      data.writeFloat(this.prevRotorAngle);
      data.writeBoolean(this.flare);
      data.writeInt(this.stage);
      data.writeInt(this.stageDelay);
      data.writeBoolean(this.canFire);
      data.writeBoolean(this.reload);
      this.writeUTF(data, this.key);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.entityId = data.readInt();
      this.posX = data.readDouble();
      this.posY = data.readDouble();
      this.posZ = data.readDouble();
      this.prevPosX = data.readDouble();
      this.prevPosY = data.readDouble();
      this.prevPosZ = data.readDouble();
      this.yaw = data.readFloat();
      this.pitch = data.readFloat();
      this.roll = data.readFloat();
      this.motX = data.readDouble();
      this.motY = data.readDouble();
      this.motZ = data.readDouble();
      this.avelx = data.readFloat();
      this.avely = data.readFloat();
      this.avelz = data.readFloat();
      this.throttle = data.readFloat();
      this.fuelInTank = data.readFloat();
      this.steeringYaw = data.readFloat();
      this.recoilPos = data.readFloat();
      this.lastRecoilPos = data.readFloat();
      this.propAngle = data.readFloat();
      this.prevPropAngle = data.readFloat();
      this.rotorAngle = data.readFloat();
      this.prevRotorAngle = data.readFloat();
      this.flare = data.readBoolean();
      this.stage = data.readInt();
      this.stageDelay = data.readInt();
      this.canFire = data.readBoolean();
      this.reload = data.readBoolean();
      this.key = this.readUTF(data);
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      EntityDriveable driveable = null;
      Iterator var3 = playerEntity.field_70170_p.field_72996_f.iterator();

      while(var3.hasNext()) {
         Object obj = var3.next();
         if (obj instanceof EntityDriveable && ((Entity)obj).func_145782_y() == this.entityId) {
            driveable = (EntityDriveable)obj;
            break;
         }
      }

      if (driveable != null) {
         this.updateDriveable(driveable, false);
      }

   }

   protected void updateDriveable(EntityDriveable driveable, boolean clientSide) {
      driveable.setPositionRotationAndMotion(this.posX, this.posY, this.posZ, this.yaw, this.pitch, this.roll, this.motX, this.motY, this.motZ, this.avelx, this.avely, this.avelz, this.throttle, this.steeringYaw);
      driveable.field_70169_q = this.prevPosX;
      driveable.field_70167_r = this.prevPosY;
      driveable.field_70166_s = this.prevPosZ;
      driveable.driveableData.fuelInTank = this.fuelInTank;
      driveable.recoilPos = this.recoilPos;
      driveable.lastRecoilPos = this.lastRecoilPos;
      driveable.propAngle = this.propAngle;
      driveable.prevPropAngle = this.propAngle;
      driveable.rotorAngle = this.rotorAngle;
      driveable.prevRotorAngle = this.prevRotorAngle;
      driveable.varFlare = this.flare;
      driveable.key = this.key;
      if (driveable.getDriveableType().IT1) {
         driveable.setIT1(this.canFire, this.reload, this.stage, this.stageDelay);
      }

   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      if (clientPlayer != null && clientPlayer.field_70170_p != null) {
         EntityDriveable driveable = null;
         Iterator var3 = clientPlayer.field_70170_p.field_72996_f.iterator();

         while(var3.hasNext()) {
            Object obj = var3.next();
            if (obj instanceof EntityDriveable && ((Entity)obj).func_145782_y() == this.entityId) {
               driveable = (EntityDriveable)obj;
               driveable.driveableData.fuelInTank = this.fuelInTank;
               if (driveable.seats[0] != null && driveable.seats[0].field_70153_n == clientPlayer) {
                  return;
               }
               break;
            }
         }

         if (driveable != null) {
            this.updateDriveable(driveable, true);
         }

      }
   }
}
