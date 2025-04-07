package com.flansmod.common.network;

import com.flansmod.common.driveables.EntityPlane;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.util.Iterator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketPlaneAnimator extends PacketBase {
   public int entityId;
   public float wingPosx;
   public float wingPosy;
   public float wingPosz;
   public float wingRotx;
   public float wingRoty;
   public float wingRotz;
   public float wingWheelPosx;
   public float wingWheelPosy;
   public float wingWheelPosz;
   public float wingWheelRotx;
   public float wingWheelRoty;
   public float wingWheelRotz;
   public float coreWheelPosx;
   public float coreWheelPosy;
   public float coreWheelPosz;
   public float coreWheelRotx;
   public float coreWheelRoty;
   public float coreWheelRotz;
   public float tailWheelPosx;
   public float tailWheelPosy;
   public float tailWheelPosz;
   public float tailWheelRotx;
   public float tailWheelRoty;
   public float tailWheelRotz;
   public float doorPosx;
   public float doorPosy;
   public float doorPosz;
   public float doorRotx;
   public float doorRoty;
   public float doorRotz;

   public PacketPlaneAnimator() {
   }

   public PacketPlaneAnimator(EntityPlane plane) {
      this.entityId = plane.func_145782_y();
      this.wingPosx = plane.wingPos.x;
      this.wingRotx = plane.wingRot.x;
      this.wingWheelPosx = plane.wingWheelPos.x;
      this.wingWheelRotx = plane.wingWheelRot.x;
      this.coreWheelPosx = plane.coreWheelPos.x;
      this.coreWheelRotx = plane.coreWheelRot.x;
      this.tailWheelPosx = plane.tailWheelPos.x;
      this.tailWheelRotx = plane.tailWheelRot.x;
      this.doorPosx = plane.doorPos.x;
      this.doorRotx = plane.doorRot.x;
      this.wingPosy = plane.wingPos.y;
      this.wingRoty = plane.wingRot.y;
      this.wingWheelPosy = plane.wingWheelPos.y;
      this.wingWheelRoty = plane.wingWheelRot.y;
      this.coreWheelPosy = plane.coreWheelPos.y;
      this.coreWheelRoty = plane.coreWheelRot.y;
      this.tailWheelPosy = plane.tailWheelPos.y;
      this.tailWheelRoty = plane.tailWheelRot.y;
      this.doorPosy = plane.doorPos.y;
      this.doorRoty = plane.doorRot.y;
      this.wingPosz = plane.wingPos.z;
      this.wingRotz = plane.wingRot.z;
      this.wingWheelPosz = plane.wingWheelPos.z;
      this.wingWheelRotz = plane.wingWheelRot.z;
      this.coreWheelPosz = plane.coreWheelPos.z;
      this.coreWheelRotz = plane.coreWheelRot.z;
      this.tailWheelPosz = plane.tailWheelPos.z;
      this.tailWheelRotz = plane.tailWheelRot.z;
      this.doorPosz = plane.doorPos.z;
      this.doorRotz = plane.doorRot.z;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeInt(this.entityId);
      data.writeFloat(this.wingPosx);
      data.writeFloat(this.wingPosy);
      data.writeFloat(this.wingPosz);
      data.writeFloat(this.wingRotx);
      data.writeFloat(this.wingRoty);
      data.writeFloat(this.wingRotz);
      data.writeFloat(this.wingWheelPosx);
      data.writeFloat(this.wingWheelPosy);
      data.writeFloat(this.wingWheelPosz);
      data.writeFloat(this.wingWheelRotx);
      data.writeFloat(this.wingWheelRoty);
      data.writeFloat(this.wingWheelRotz);
      data.writeFloat(this.coreWheelPosx);
      data.writeFloat(this.coreWheelPosy);
      data.writeFloat(this.coreWheelPosz);
      data.writeFloat(this.coreWheelRotx);
      data.writeFloat(this.coreWheelRoty);
      data.writeFloat(this.coreWheelRotz);
      data.writeFloat(this.tailWheelPosx);
      data.writeFloat(this.tailWheelPosy);
      data.writeFloat(this.tailWheelPosz);
      data.writeFloat(this.tailWheelRotx);
      data.writeFloat(this.tailWheelRoty);
      data.writeFloat(this.tailWheelRotz);
      data.writeFloat(this.doorPosx);
      data.writeFloat(this.doorPosy);
      data.writeFloat(this.doorPosz);
      data.writeFloat(this.doorRotx);
      data.writeFloat(this.doorRoty);
      data.writeFloat(this.doorRotz);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.entityId = data.readInt();
      this.wingPosx = data.readFloat();
      this.wingPosy = data.readFloat();
      this.wingPosz = data.readFloat();
      this.wingRotx = data.readFloat();
      this.wingRoty = data.readFloat();
      this.wingRotz = data.readFloat();
      this.wingWheelPosx = data.readFloat();
      this.wingWheelPosy = data.readFloat();
      this.wingWheelPosz = data.readFloat();
      this.wingWheelRotx = data.readFloat();
      this.wingWheelRoty = data.readFloat();
      this.wingWheelRotz = data.readFloat();
      this.coreWheelPosx = data.readFloat();
      this.coreWheelPosy = data.readFloat();
      this.coreWheelPosz = data.readFloat();
      this.coreWheelRotx = data.readFloat();
      this.coreWheelRoty = data.readFloat();
      this.coreWheelRotz = data.readFloat();
      this.tailWheelPosx = data.readFloat();
      this.tailWheelPosy = data.readFloat();
      this.tailWheelPosz = data.readFloat();
      this.tailWheelRotx = data.readFloat();
      this.tailWheelRoty = data.readFloat();
      this.tailWheelRotz = data.readFloat();
      this.doorPosx = data.readFloat();
      this.doorPosy = data.readFloat();
      this.doorPosz = data.readFloat();
      this.doorRotx = data.readFloat();
      this.doorRoty = data.readFloat();
      this.doorRotz = data.readFloat();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      EntityPlane plane = null;
      Iterator var3 = playerEntity.field_70170_p.field_72996_f.iterator();

      while(var3.hasNext()) {
         Object obj = var3.next();
         if (obj instanceof EntityPlane && ((Entity)obj).func_145782_y() == this.entityId) {
            plane = (EntityPlane)obj;
            break;
         }
      }

      if (plane != null) {
         this.updateDriveable(plane, false);
      }

   }

   protected void updateDriveable(EntityPlane plane, boolean clientSide) {
      plane.wingPos = new Vector3f(this.wingPosx, this.wingPosy, this.wingPosz);
      plane.wingRot = new Vector3f(this.wingRotx, this.wingRoty, this.wingRotz);
      plane.wingWheelPos = new Vector3f(this.wingWheelPosx, this.wingWheelPosy, this.wingWheelPosz);
      plane.wingWheelRot = new Vector3f(this.wingWheelRotx, this.wingWheelRoty, this.wingWheelRotz);
      plane.coreWheelPos = new Vector3f(this.coreWheelPosx, this.coreWheelPosy, this.coreWheelPosz);
      plane.coreWheelRot = new Vector3f(this.coreWheelRotx, this.coreWheelRoty, this.coreWheelRotz);
      plane.tailWheelPos = new Vector3f(this.tailWheelPosx, this.tailWheelPosy, this.tailWheelPosz);
      plane.tailWheelRot = new Vector3f(this.tailWheelRotx, this.tailWheelRoty, this.tailWheelRotz);
      plane.doorPos = new Vector3f(this.doorPosx, this.doorPosy, this.doorPosz);
      plane.doorRot = new Vector3f(this.doorRotx, this.doorRoty, this.doorRotz);
   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      if (clientPlayer != null && clientPlayer.field_70170_p != null) {
         EntityPlane plane = null;
         Iterator var3 = clientPlayer.field_70170_p.field_72996_f.iterator();

         while(var3.hasNext()) {
            Object obj = var3.next();
            if (obj instanceof EntityPlane && ((Entity)obj).func_145782_y() == this.entityId) {
               plane = (EntityPlane)obj;
               if (plane.seats[0] != null && plane.seats[0].field_70153_n == clientPlayer) {
                  return;
               }
               break;
            }
         }

         if (plane != null) {
            this.updateDriveable(plane, true);
         }

      }
   }
}
