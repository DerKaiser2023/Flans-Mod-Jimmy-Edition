package com.flansmod.client.model;

import com.flansmod.client.FlansModResourceHandler;
import com.flansmod.client.model.animation.AnimationController;
import com.flansmod.client.model.animation.AnimationPart;
import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.DriveablePart;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntityPlane;
import com.flansmod.common.driveables.ItemPlane;
import com.flansmod.common.driveables.PlaneType;
import com.flansmod.common.driveables.Propeller;
import com.flansmod.common.driveables.ShootPoint;
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

public class RenderPlane extends Render implements IItemRenderer {
   public RenderPlane() {
      this.field_76989_e = 1.0F;
   }

   public void render(EntityPlane entityPlane, double d, double d1, double d2, float f, float f1) {
      if (entityPlane.field_70154_o == null || entityPlane.field_70154_o.getClass().toString().indexOf("mcheli.aircraft.MCH_EntitySeat") <= 0) {
         this.func_110777_b(entityPlane);
         PlaneType type = entityPlane.getPlaneType();
         GL11.glPushMatrix();
         GL11.glTranslatef((float)d, (float)d1, (float)d2);

         float dYaw;
         for(dYaw = entityPlane.axes.getYaw() - entityPlane.field_70126_B; dYaw > 180.0F; dYaw -= 360.0F) {
         }

         while(dYaw <= -180.0F) {
            dYaw += 360.0F;
         }

         float dPitch;
         for(dPitch = entityPlane.axes.getPitch() - entityPlane.field_70127_C; dPitch > 180.0F; dPitch -= 360.0F) {
         }

         while(dPitch <= -180.0F) {
            dPitch += 360.0F;
         }

         float dRoll;
         for(dRoll = entityPlane.axes.getRoll() - entityPlane.prevRotationRoll; dRoll > 180.0F; dRoll -= 360.0F) {
         }

         while(dRoll <= -180.0F) {
            dRoll += 360.0F;
         }

         GL11.glRotatef(180.0F - entityPlane.field_70126_B - dYaw * f1, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(entityPlane.field_70127_C + dPitch * f1, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(entityPlane.prevRotationRoll + dRoll * f1, 1.0F, 0.0F, 0.0F);
         ModelPlane model = (ModelPlane)type.model;
         if (model != null) {
            GL11.glPushMatrix();
            GL11.glScalef(type.modelScale, type.modelScale, type.modelScale);
            model.render(entityPlane, f1);
            float dRotorAngle = entityPlane.rotorAngle - entityPlane.prevRotorAngle;
            float var10000 = entityPlane.prevRotorAngle + dRotorAngle * f1;

            int i;
            for(i = 0; i < model.heliMainRotorModels.length; ++i) {
               GL11.glPushMatrix();
               GL11.glTranslatef(model.heliMainRotorOrigins[i].x, model.heliMainRotorOrigins[i].y, model.heliMainRotorOrigins[i].z);
               GL11.glRotatef((entityPlane.rotorAngle + f1 * entityPlane.throttle / 7.0F) * model.heliRotorSpeeds[i] * 1440.0F / 3.1415927F, 0.0F, 1.0F, 0.0F);
               GL11.glTranslatef(-model.heliMainRotorOrigins[i].x, -model.heliMainRotorOrigins[i].y, -model.heliMainRotorOrigins[i].z);
               model.renderRotor(entityPlane, 0.0625F, i);
               GL11.glPopMatrix();
            }

            for(i = 0; i < model.heliTailRotorModels.length; ++i) {
               GL11.glPushMatrix();
               GL11.glTranslatef(model.heliTailRotorOrigins[i].x, model.heliTailRotorOrigins[i].y, model.heliTailRotorOrigins[i].z);
               GL11.glRotatef((entityPlane.rotorAngle + f1 * entityPlane.throttle / 7.0F) * 1440.0F / 3.1415927F, 0.0F, 0.0F, 1.0F);
               GL11.glTranslatef(-model.heliTailRotorOrigins[i].x, -model.heliTailRotorOrigins[i].y, -model.heliTailRotorOrigins[i].z);
               model.renderTailRotor(entityPlane, 0.0625F, i);
               GL11.glPopMatrix();
            }

            Vector3f wingPos = this.getRenderPosition(entityPlane.wingPos, entityPlane.prevWingPos, f1);
            Vector3f wingRot = this.getRenderPosition(entityPlane.wingRot, entityPlane.prevWingRot, f1);
            if (entityPlane.initiatedAnim) {
               AnimationController cont = entityPlane.anim;
               AnimationPart p = cont.getCorePart();
               this.renderAnimPart(p, new Vector3f(0.0F, 0.0F, 0.0F), model, entityPlane, 0.0625F, f1);
            }

            GL11.glPushMatrix();
            GL11.glTranslatef(model.leftWingAttach.x + wingPos.x / 16.0F, model.leftWingAttach.y + wingPos.y / 16.0F, -model.leftWingAttach.z + wingPos.z / 16.0F);
            GL11.glRotatef(wingRot.x, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(wingRot.y, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(wingRot.z, 0.0F, 0.0F, 1.0F);
            model.renderLeftWing(entityPlane, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslatef(model.rightWingAttach.x + wingPos.x / 16.0F, model.rightWingAttach.y + wingPos.y / 16.0F, -model.rightWingAttach.z + wingPos.z / 16.0F);
            GL11.glRotatef(-wingRot.x, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-wingRot.y, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(wingRot.z, 0.0F, 0.0F, 1.0F);
            model.renderRightWing(entityPlane, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslatef(model.leftWingWheelAttach.x + entityPlane.wingWheelPos.x / 16.0F, model.leftWingWheelAttach.y + entityPlane.wingWheelPos.y / 16.0F, -model.leftWingWheelAttach.z + entityPlane.wingWheelPos.z / 16.0F);
            GL11.glRotatef(entityPlane.wingWheelRot.x, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(entityPlane.wingWheelRot.y, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(entityPlane.wingWheelRot.z, 0.0F, 0.0F, 1.0F);
            model.renderLeftWingWheel(entityPlane, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslatef(model.rightWingWheelAttach.x + entityPlane.wingWheelPos.x / 16.0F, model.rightWingWheelAttach.y + entityPlane.wingWheelPos.y / 16.0F, -model.rightWingWheelAttach.z + entityPlane.wingWheelPos.z / 16.0F);
            GL11.glRotatef(-entityPlane.wingWheelRot.x, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-entityPlane.wingWheelRot.y, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(entityPlane.wingWheelRot.z, 0.0F, 0.0F, 1.0F);
            model.renderRightWingWheel(entityPlane, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslatef(model.bodyWheelAttach.x + entityPlane.coreWheelPos.x / 16.0F, model.bodyWheelAttach.y + entityPlane.coreWheelPos.y / 16.0F, model.bodyWheelAttach.z + entityPlane.coreWheelPos.z / 16.0F);
            GL11.glRotatef(entityPlane.coreWheelRot.x, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(entityPlane.coreWheelRot.y, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(entityPlane.coreWheelRot.z, 0.0F, 0.0F, 1.0F);
            model.renderCoreWheel(entityPlane, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslatef(model.tailWheelAttach.x + entityPlane.tailWheelPos.x / 16.0F, model.tailWheelAttach.y + entityPlane.tailWheelPos.y / 16.0F, model.tailWheelAttach.z + entityPlane.tailWheelPos.z / 16.0F);
            GL11.glRotatef(entityPlane.tailWheelRot.x, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(entityPlane.tailWheelRot.y, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(entityPlane.tailWheelRot.z, 0.0F, 0.0F, 1.0F);
            model.renderTailWheel(entityPlane, 0.0625F);
            GL11.glPopMatrix();
            Vector3f doorPos = this.getRenderPosition(entityPlane.doorPos, entityPlane.prevDoorPos, f1);
            Vector3f doorRot = this.getRenderPosition(entityPlane.doorRot, entityPlane.prevDoorRot, f1);
            GL11.glPushMatrix();
            GL11.glTranslatef(model.doorAttach.x + doorPos.x / 16.0F, model.doorAttach.y + doorPos.y / 16.0F, model.doorAttach.z + doorPos.z / 16.0F);
            GL11.glRotatef(doorRot.x, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(doorRot.y, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(doorRot.z, 0.0F, 0.0F, 1.0F);
            model.renderDoor(entityPlane, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPopMatrix();
         }

         if (FlansMod.DEBUG) {
            GL11.glDisable(3553);
            GL11.glEnable(3042);
            GL11.glDisable(2929);
            GL11.glColor4f(1.0F, 0.0F, 0.0F, 0.3F);
            GL11.glScalef(-1.0F, 1.0F, -1.0F);
            Iterator var21 = entityPlane.getDriveableData().parts.values().iterator();

            while(var21.hasNext()) {
               DriveablePart part = (DriveablePart)var21.next();
               if (part.box != null) {
                  GL11.glColor4f(1.0F, entityPlane.isPartIntact(part.type) ? 1.0F : 0.0F, 0.0F, 0.3F);
                  func_76980_a(AxisAlignedBB.func_72330_a((double)part.box.x, (double)part.box.y, (double)part.box.z, (double)(part.box.x + part.box.w), (double)(part.box.y + part.box.h), (double)(part.box.z + part.box.d)));
               }
            }

            GL11.glColor4f(1.0F, 1.0F, 0.0F, 0.3F);
            var21 = type.propellers.iterator();

            while(var21.hasNext()) {
               Propeller prop = (Propeller)var21.next();
               func_76980_a(AxisAlignedBB.func_72330_a((double)((float)prop.x / 16.0F - 0.25F), (double)((float)prop.y / 16.0F - 0.25F), (double)((float)prop.z / 16.0F - 0.25F), (double)((float)prop.x / 16.0F + 0.25F), (double)((float)prop.y / 16.0F + 0.25F), (double)((float)prop.z / 16.0F + 0.25F)));
            }

            GL11.glColor4f(1.0F, 0.0F, 1.0F, 0.3F);
            var21 = type.shootPointsPrimary.iterator();

            ShootPoint point;
            while(var21.hasNext()) {
               point = (ShootPoint)var21.next();
               func_76980_a(AxisAlignedBB.func_72330_a((double)(point.rootPos.position.x - 0.25F), (double)(point.rootPos.position.y - 0.25F), (double)(point.rootPos.position.z - 0.25F), (double)(point.rootPos.position.x + 0.25F), (double)(point.rootPos.position.y + 0.25F), (double)(point.rootPos.position.z + 0.25F)));
            }

            GL11.glColor4f(0.0F, 1.0F, 0.0F, 0.3F);
            var21 = type.shootPointsSecondary.iterator();

            while(var21.hasNext()) {
               point = (ShootPoint)var21.next();
               func_76980_a(AxisAlignedBB.func_72330_a((double)(point.rootPos.position.x - 0.25F), (double)(point.rootPos.position.y - 0.25F), (double)(point.rootPos.position.z - 0.25F), (double)(point.rootPos.position.x + 0.25F), (double)(point.rootPos.position.y + 0.25F), (double)(point.rootPos.position.z + 0.25F)));
            }

            GL11.glEnable(3553);
            GL11.glEnable(2929);
            GL11.glDisable(3042);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         }

         GL11.glPopMatrix();
      }
   }

   public Vector3f getRenderPosition(Vector3f current, Vector3f previous, float f) {
      Vector3f diff = new Vector3f(current.x - previous.x, current.y - previous.y, current.z - previous.z);
      Vector3f corrected = new Vector3f(previous.x + diff.x * f, previous.y + diff.y * f, previous.z + diff.z * f);
      return corrected;
   }

   public void func_76986_a(Entity entity, double d, double d1, double d2, float f, float f1) {
      this.render((EntityPlane)entity, d, d1, d2, f, f1);
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
         return Minecraft.func_71410_x().field_71474_y.field_74347_j && item != null && item.func_77973_b() instanceof ItemPlane && ((ItemPlane)item.func_77973_b()).type.model != null;
      default:
         return false;
      }
   }

   public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
      return false;
   }

   public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
      GL11.glPushMatrix();
      if (item != null && item.func_77973_b() instanceof ItemPlane) {
         PlaneType planeType = ((ItemPlane)item.func_77973_b()).type;
         if (planeType.model != null) {
            float scale = 0.5F;
            switch(type) {
            case EQUIPPED:
               GL11.glRotatef(15.0F, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(15.0F, 1.0F, 0.0F, 0.0F);
               GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
               GL11.glTranslatef(0.0F, 0.2F, 0.4F);
               scale = 1.0F;
               break;
            case EQUIPPED_FIRST_PERSON:
               GL11.glRotatef(25.0F, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(-5.0F, 0.0F, 1.0F, 0.0F);
               GL11.glTranslatef(0.15F, 0.45F, -0.6F);
               GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
               break;
            case ENTITY:
               scale = 1.5F;
               GL11.glRotatef((float)((EntityItem)data[1]).field_70173_aa, 0.0F, 1.0F, 0.0F);
            }

            GL11.glScalef(scale / planeType.cameraDistance, scale / planeType.cameraDistance, scale / planeType.cameraDistance);
            Minecraft.func_71410_x().field_71446_o.func_110577_a(FlansModResourceHandler.getTexture(planeType));
            ModelDriveable model = planeType.model;
            model.render(planeType);
         }
      }

      GL11.glPopMatrix();
   }

   public int getPartId(int i) {
      return i;
   }

   public void renderAnimPart(AnimationPart p, Vector3f parent, ModelPlane mod, EntityPlane plane, float f5, float f1) {
      Vector3f pos = Vector3f.sub(p.position, parent, (Vector3f)null);
      Vector3f offset = this.Interpolate(p.offset, p.prevOff, f1);
      Vector3f rotation = this.Interpolate(p.rotation, p.prevRot, f1);
      GL11.glPushMatrix();
      GL11.glTranslatef(pos.x / 16.0F, -pos.y / 16.0F, -pos.z / 16.0F);
      GL11.glRotatef(rotation.x, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(rotation.y, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(rotation.z, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(offset.x / 16.0F, offset.y / 16.0F, offset.z / 16.0F);
      int i = this.getPartId(p.type);
      mod.renderValk(plane, f5, i);
      if (p.hasChildren) {
         Iterator var11 = p.children.iterator();

         while(var11.hasNext()) {
            AnimationPart p2 = (AnimationPart)var11.next();
            this.renderAnimPart(p2, p.position, mod, plane, f5, f1);
         }
      }

      GL11.glPopMatrix();
   }

   public Vector3f Interpolate(Vector3f current, Vector3f prev, float f1) {
      Vector3f result = new Vector3f(prev.x + (current.x - prev.x) * f1, prev.y + (current.y - prev.y) * f1, prev.z + (current.z - prev.z) * f1);
      return result;
   }
}
