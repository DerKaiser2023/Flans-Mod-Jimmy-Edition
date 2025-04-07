package com.flansmod.client.model;

import com.flansmod.client.FlansModResourceHandler;
import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.DriveablePart;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntityVehicle;
import com.flansmod.common.driveables.EnumDriveablePart;
import com.flansmod.common.driveables.ItemVehicle;
import com.flansmod.common.driveables.ShootPoint;
import com.flansmod.common.driveables.VehicleType;
import com.flansmod.common.paintjob.Paintjob;
import com.flansmod.common.vector.Vector3f;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import org.lwjgl.opengl.GL11;

public class RenderVehicle extends Render implements IItemRenderer {
   public RenderVehicle() {
      this.field_76989_e = 1.0F;
   }

   public void render(EntityVehicle vehicle, double d, double d1, double d2, float f, float f1) {
      if (vehicle.field_70154_o == null || vehicle.field_70154_o.getClass().toString().indexOf("mcheli.aircraft.MCH_EntitySeat") <= 0) {
         this.func_110777_b(vehicle);
         VehicleType type = vehicle.getVehicleType();
         GL11.glPushMatrix();
         GL11.glTranslatef((float)d, (float)d1, (float)d2);

         float dYaw;
         for(dYaw = vehicle.axes.getYaw() - vehicle.field_70126_B; dYaw > 180.0F; dYaw -= 360.0F) {
         }

         while(dYaw <= -180.0F) {
            dYaw += 360.0F;
         }

         float dPitch;
         for(dPitch = vehicle.axes.getPitch() - vehicle.field_70127_C; dPitch > 180.0F; dPitch -= 360.0F) {
         }

         while(dPitch <= -180.0F) {
            dPitch += 360.0F;
         }

         float dRoll;
         for(dRoll = vehicle.axes.getRoll() - vehicle.prevRotationRoll; dRoll > 180.0F; dRoll -= 360.0F) {
         }

         while(dRoll <= -180.0F) {
            dRoll += 360.0F;
         }

         GL11.glRotatef(180.0F - vehicle.field_70126_B - dYaw * f1, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(vehicle.field_70127_C + dPitch * f1, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(vehicle.prevRotationRoll + dRoll * f1, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
         GL11.glPushMatrix();
         ModelVehicle modVehicle = (ModelVehicle)type.model;
         GL11.glPushMatrix();
         float yaw = (float)Math.sin(Math.toRadians((double)vehicle.recoilPos)) - (float)Math.sin(Math.toRadians((double)vehicle.lastRecoilPos));
         float recoilPos = (float)Math.sin(Math.toRadians((double)vehicle.lastRecoilPos)) + yaw * f1;
         GL11.glScalef(type.modelScale, type.modelScale, type.modelScale);
         if (modVehicle != null) {
            modVehicle.render(vehicle, f1);
         }

         int i;
         AnimTrackLink link;
         float bPitch;
         for(i = 0; i < vehicle.trackLinksLeft.length; ++i) {
            link = vehicle.trackLinksLeft[i];
            bPitch = link.zRot;
            GL11.glPushMatrix();
            GL11.glTranslatef(link.position.x / 16.0F, link.position.y / 16.0F, link.position.z / 16.0F);

            while(bPitch > 180.0F) {
               bPitch -= 360.0F;
            }

            while(bPitch <= -180.0F) {
               bPitch += 360.0F;
            }

            GL11.glRotatef(bPitch * 57.29578F, 0.0F, 0.0F, 1.0F);
            modVehicle.renderFancyTracks(vehicle, f1);
            GL11.glPopMatrix();
         }

         for(i = 0; i < vehicle.trackLinksRight.length; ++i) {
            link = vehicle.trackLinksRight[i];

            for(bPitch = link.zRot; bPitch > 180.0F; bPitch -= 360.0F) {
            }

            while(bPitch <= -180.0F) {
               bPitch += 360.0F;
            }

            GL11.glPushMatrix();
            GL11.glTranslatef(link.position.x / 16.0F, link.position.y / 16.0F, link.position.z / 16.0F);
            GL11.glRotatef(bPitch * 57.29578F, 0.0F, 0.0F, 1.0F);
            modVehicle.renderFancyTracks(vehicle, f1);
            GL11.glPopMatrix();
         }

         if (type.turretOrigin != null && vehicle.isPartIntact(EnumDriveablePart.turret) && vehicle.seats != null && vehicle.seats[0] != null) {
            dYaw = vehicle.seats[0].looking.getYaw() - vehicle.seats[0].prevLooking.getYaw();

            for(float var27 = vehicle.seats[0].looking.getPitch(); dYaw > 180.0F; dYaw -= 360.0F) {
            }

            while(dYaw <= -180.0F) {
               dYaw += 360.0F;
            }

            float yaw = vehicle.seats[0].prevLooking.getYaw() + dYaw * f1;
            GL11.glTranslatef(type.turretOrigin.x, type.turretOrigin.y, type.turretOrigin.z);
            GL11.glRotatef(-yaw, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-type.turretOrigin.x, -type.turretOrigin.y, -type.turretOrigin.z);
            if (modVehicle != null) {
               modVehicle.renderTurret(0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, vehicle, f1);
            }

            if (modVehicle != null) {
               GL11.glTranslatef(modVehicle.barrelAttach.x, modVehicle.barrelAttach.y, -modVehicle.barrelAttach.z);
               bPitch = vehicle.seats[0].looking.getPitch() - vehicle.seats[0].prevLooking.getPitch();
               float aPitch = vehicle.seats[0].prevLooking.getPitch() + bPitch * f1;
               GL11.glRotatef(-aPitch, 0.0F, 0.0F, 1.0F);
               GL11.glTranslatef(recoilPos * -0.3125F, 0.0F, 0.0F);
               modVehicle.renderAnimBarrel(0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, vehicle, f1);
            }
         }

         GL11.glPopMatrix();
         GL11.glPushMatrix();
         if (FlansMod.DEBUG && type.turretOrigin != null && vehicle.isPartIntact(EnumDriveablePart.turret) && vehicle.seats != null && vehicle.seats[0] != null) {
            for(dYaw = vehicle.seats[0].looking.getYaw() - vehicle.seats[0].prevLooking.getYaw(); dYaw > 180.0F; dYaw -= 360.0F) {
            }

            while(dYaw <= -180.0F) {
               dYaw += 360.0F;
            }

            yaw = vehicle.seats[0].prevLooking.getYaw() + dYaw * f1;
            GL11.glTranslatef(type.turretOrigin.x, type.turretOrigin.y, type.turretOrigin.z);
            GL11.glRotatef(-yaw, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-vehicle.seats[0].looking.getPitch(), 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-type.turretOrigin.x, -type.turretOrigin.y, -type.turretOrigin.z);
            GL11.glColor4f(0.0F, 0.0F, 1.0F, 0.3F);
            Iterator var24 = type.shootPointsPrimary.iterator();

            ShootPoint point;
            while(var24.hasNext()) {
               point = (ShootPoint)var24.next();
               if (point.rootPos.part == EnumDriveablePart.turret) {
                  func_76980_a(AxisAlignedBB.func_72330_a((double)(point.rootPos.position.x - 0.25F), (double)(point.rootPos.position.y - 0.25F), (double)(point.rootPos.position.z - 0.25F), (double)(point.rootPos.position.x + 0.25F), (double)(point.rootPos.position.y + 0.25F), (double)(point.rootPos.position.z + 0.25F)));
               }
            }

            GL11.glColor4f(0.0F, 1.0F, 0.0F, 0.3F);
            var24 = type.shootPointsSecondary.iterator();

            while(var24.hasNext()) {
               point = (ShootPoint)var24.next();
               if (point.rootPos.part == EnumDriveablePart.turret) {
                  func_76980_a(AxisAlignedBB.func_72330_a((double)(point.rootPos.position.x - 0.25F), (double)(point.rootPos.position.y - 0.25F), (double)(point.rootPos.position.z - 0.25F), (double)(point.rootPos.position.x + 0.25F), (double)(point.rootPos.position.y + 0.25F), (double)(point.rootPos.position.z + 0.25F)));
               }
            }
         }

         GL11.glPopMatrix();
         if (modVehicle != null) {
            GL11.glPushMatrix();
            GL11.glTranslatef(modVehicle.drillHeadOrigin.x, modVehicle.drillHeadOrigin.y, modVehicle.drillHeadOrigin.z);
            GL11.glRotatef(vehicle.harvesterAngle * 50.0F, 1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(-modVehicle.drillHeadOrigin.x, -modVehicle.drillHeadOrigin.y, -modVehicle.drillHeadOrigin.z);
            modVehicle.renderDrillBit(vehicle, f1);
            GL11.glPopMatrix();
         }

         if (modVehicle != null) {
            Vector3f newRot = this.Interpolate(vehicle.doorRot, vehicle.prevDoorRot, f1);
            Vector3f newPos = this.Interpolate(vehicle.doorPos, vehicle.prevDoorPos, f1);
            GL11.glPushMatrix();
            GL11.glTranslatef(modVehicle.doorAttach.x + newPos.x / 16.0F, modVehicle.doorAttach.y + newPos.y / 16.0F, -modVehicle.doorAttach.z + newPos.z / 16.0F);
            GL11.glRotatef(newRot.x, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-newRot.y, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(newRot.z, 0.0F, 0.0F, 1.0F);
            modVehicle.renderDoor(vehicle, 0.0625F);
            GL11.glPopMatrix();
            Vector3f newRot2 = this.Interpolate(vehicle.door2Rot, vehicle.prevDoor2Rot, f1);
            Vector3f newPos2 = this.Interpolate(vehicle.door2Pos, vehicle.prevDoor2Pos, f1);
            GL11.glPushMatrix();
            GL11.glTranslatef(modVehicle.door2Attach.x + newPos2.x / 16.0F, modVehicle.door2Attach.y + newPos2.y / 16.0F, -modVehicle.door2Attach.z + newPos2.z / 16.0F);
            GL11.glRotatef(newRot2.x, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-newRot2.y, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(newRot2.z, 0.0F, 0.0F, 1.0F);
            modVehicle.renderDoor2(vehicle, 0.0625F);
            GL11.glPopMatrix();
         }

         GL11.glPopMatrix();
         if (FlansMod.DEBUG) {
            GL11.glDisable(3553);
            GL11.glEnable(3042);
            GL11.glDisable(2929);
            GL11.glColor4f(1.0F, 0.0F, 0.0F, 0.3F);
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            Iterator var21 = vehicle.getDriveableData().parts.values().iterator();

            while(var21.hasNext()) {
               DriveablePart part = (DriveablePart)var21.next();
               if (part.box != null) {
                  func_76980_a(AxisAlignedBB.func_72330_a((double)part.box.x, (double)part.box.y, (double)part.box.z, (double)(part.box.x + part.box.w), (double)(part.box.y + part.box.h), (double)(part.box.z + part.box.d)));
               }
            }

            GL11.glColor4f(0.0F, 0.0F, 1.0F, 0.3F);
            var21 = type.shootPointsPrimary.iterator();

            ShootPoint point;
            while(var21.hasNext()) {
               point = (ShootPoint)var21.next();
               if (point.rootPos.part != EnumDriveablePart.turret) {
                  func_76980_a(AxisAlignedBB.func_72330_a((double)(point.rootPos.position.x - 0.25F), (double)(point.rootPos.position.y - 0.25F), (double)(point.rootPos.position.z - 0.25F), (double)(point.rootPos.position.x + 0.25F), (double)(point.rootPos.position.y + 0.25F), (double)(point.rootPos.position.z + 0.25F)));
               }
            }

            GL11.glColor4f(0.0F, 1.0F, 0.0F, 0.3F);
            var21 = type.shootPointsSecondary.iterator();

            while(var21.hasNext()) {
               point = (ShootPoint)var21.next();
               if (point.rootPos.part != EnumDriveablePart.turret) {
                  func_76980_a(AxisAlignedBB.func_72330_a((double)(point.rootPos.position.x - 0.25F), (double)(point.rootPos.position.y - 0.25F), (double)(point.rootPos.position.z - 0.25F), (double)(point.rootPos.position.x + 0.25F), (double)(point.rootPos.position.y + 0.25F), (double)(point.rootPos.position.z + 0.25F)));
               }
            }

            GL11.glEnable(3553);
            GL11.glEnable(2929);
            GL11.glDisable(3042);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         }

         GL11.glPopMatrix();
      }
   }

   public void func_76986_a(Entity entity, double d, double d1, double d2, float f, float f1) {
      this.render((EntityVehicle)entity, d, d1, d2, f, f1);
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      DriveableType type = ((EntityDriveable)entity).getDriveableType();
      Paintjob paintjob = type.getPaintjob(((EntityDriveable)entity).getDriveableData().paintjobID);
      return FlansModResourceHandler.getPaintjobTexture(paintjob);
   }

   public boolean handleRenderType(ItemStack item, ItemRenderType type) {
      switch(type) {
      case EQUIPPED:
      case EQUIPPED_FIRST_PERSON:
      case ENTITY:
         return Minecraft.func_71410_x().field_71474_y.field_74347_j && item != null && item.func_77973_b() instanceof ItemVehicle && ((ItemVehicle)item.func_77973_b()).type.model != null;
      default:
         return false;
      }
   }

   public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
      return false;
   }

   public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
      GL11.glPushMatrix();
      if (item != null && item.func_77973_b() instanceof ItemVehicle) {
         VehicleType vehicleType = ((ItemVehicle)item.func_77973_b()).type;
         if (vehicleType.model != null) {
            float scale = 0.5F;
            switch(type) {
            case EQUIPPED:
               GL11.glRotatef(15.0F, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(15.0F, 1.0F, 0.0F, 0.0F);
               GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
               GL11.glTranslatef(0.0F, 0.15F, -0.4F);
               scale = 1.0F;
               break;
            case EQUIPPED_FIRST_PERSON:
               GL11.glRotatef(25.0F, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(-5.0F, 0.0F, 1.0F, 0.0F);
               GL11.glTranslatef(0.15F, 0.45F, -0.6F);
               break;
            case ENTITY:
               scale = 1.5F;
               GL11.glRotatef((float)((EntityItem)data[1]).field_70173_aa, 0.0F, 1.0F, 0.0F);
            }

            GL11.glScalef(scale / vehicleType.cameraDistance, scale / vehicleType.cameraDistance, scale / vehicleType.cameraDistance);
            Minecraft.func_71410_x().field_71446_o.func_110577_a(FlansModResourceHandler.getTexture(vehicleType));
            ModelDriveable model = vehicleType.model;
            model.render(vehicleType);
         }
      }

      GL11.glPopMatrix();
   }

   public Vector3f Interpolate(Vector3f current, Vector3f prev, float f1) {
      Vector3f result = new Vector3f(prev.x + (current.x - prev.x) * f1, prev.y + (current.y - prev.y) * f1, prev.z + (current.z - prev.z) * f1);
      return result;
   }
}
