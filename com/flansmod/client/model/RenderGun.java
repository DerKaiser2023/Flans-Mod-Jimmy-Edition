package com.flansmod.client.model;

import com.flansmod.client.FlansModClient;
import com.flansmod.client.FlansModResourceHandler;
import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.guns.AttachmentType;
import com.flansmod.common.guns.EnumFireMode;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.IScope;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.guns.ItemShootable;
import com.flansmod.common.paintjob.Paintjob;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.relauncher.Side;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import org.lwjgl.opengl.GL11;

public class RenderGun implements IItemRenderer {
   private static TextureManager renderEngine;
   public static float smoothing;

   public boolean handleRenderType(ItemStack item, ItemRenderType type) {
      switch(type) {
      case ENTITY:
         if (!Minecraft.func_71410_x().field_71474_y.field_74347_j) {
            return false;
         }
      case EQUIPPED:
      case EQUIPPED_FIRST_PERSON:
         break;
      default:
         return false;
      }

      return item != null && item.func_77973_b() instanceof ItemGun && ((ItemGun)item.func_77973_b()).type.model != null;
   }

   public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
      return false;
   }

   public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
      if (item.func_77973_b() instanceof ItemGun) {
         RenderBlocks renderBlocks = (RenderBlocks)data[0];
         GunType gunType = ((ItemGun)item.func_77973_b()).type;
         if (gunType != null) {
            ModelGun model = gunType.model;
            if (model != null) {
               GunAnimations animations = type == ItemRenderType.ENTITY ? new GunAnimations() : FlansModClient.getGunAnimations((EntityLivingBase)data[1], false);
               this.renderGun(type, item, gunType, animations, false, data);
               if (gunType.oneHanded && type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
                  EntityLivingBase entity = (EntityLivingBase)data[1];
                  if (entity instanceof EntityPlayer) {
                     EntityPlayer player = (EntityPlayer)entity;
                     PlayerData playerData = PlayerHandler.getPlayerData(player, Side.CLIENT);
                     if (playerData.offHandGunSlot != 0) {
                        GunAnimations animations = (GunAnimations)FlansModClient.gunAnimationsLeft.get(data[1]);
                        if (animations == null) {
                           animations = new GunAnimations();
                           FlansModClient.gunAnimationsLeft.put((EntityLivingBase)data[1], animations);
                        }

                        ItemStack offHandItem = player.field_71071_by.func_70301_a(playerData.offHandGunSlot - 1);
                        if (offHandItem == null || !(offHandItem.func_77973_b() instanceof ItemGun)) {
                           return;
                        }

                        GunType offHandGunType = ((ItemGun)offHandItem.func_77973_b()).type;
                        if (!offHandGunType.oneHanded) {
                           return;
                        }

                        this.renderGun(type, offHandItem, offHandGunType, animations, true, data);
                     }
                  }
               }

            }
         }
      }
   }

   public void renderOffHandGun(EntityPlayer player, ItemStack offHandItemStack) {
      GunAnimations animations = (GunAnimations)FlansModClient.gunAnimationsLeft.get(player);
      if (animations == null) {
         animations = new GunAnimations();
         FlansModClient.gunAnimationsLeft.put(player, animations);
      }

      GunType offHandGunType = ((ItemGun)offHandItemStack.func_77973_b()).type;
      if (offHandGunType.oneHanded) {
         this.renderGun(ItemRenderType.EQUIPPED, offHandItemStack, offHandGunType, animations, true, player);
      }
   }

   private void renderGun(ItemRenderType type, ItemStack item, GunType gunType, GunAnimations animations, boolean offHand, Object... data) {
      float f = 0.0625F;
      ModelGun model = gunType.model;
      int flip = offHand ? -1 : 1;
      GL11.glPushMatrix();
      float reloadRotate = 0.0F;
      switch(type) {
      case ENTITY:
         EntityItem entity = (EntityItem)data[1];
         GL11.glRotatef((float)entity.field_70292_b + (entity.field_70292_b == 0 ? 0.0F : smoothing), 0.0F, 1.0F, 0.0F);
         GL11.glTranslatef(-0.2F + model.itemFrameOffset.x, 0.2F + model.itemFrameOffset.y, 0.1F + model.itemFrameOffset.z);
         break;
      case EQUIPPED:
         if (offHand) {
            GL11.glRotatef(-70.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(48.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(105.0F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-0.1F, -0.22F, -0.15F);
         } else {
            GL11.glRotatef(35.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-5.0F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.75F, -0.22F, -0.08F);
            GL11.glScalef(1.0F, 1.0F, -1.0F);
         }

         GL11.glTranslatef(model.thirdPersonOffset.x, model.thirdPersonOffset.y, model.thirdPersonOffset.z);
         break;
      case EQUIPPED_FIRST_PERSON:
         IScope scope = gunType.getCurrentScope(item);
         if (FlansModClient.zoomProgress > 0.9F && scope.hasZoomOverlay()) {
            GL11.glPopMatrix();
            return;
         }

         float adsSwitch = FlansModClient.lastZoomProgress + (FlansModClient.zoomProgress - FlansModClient.lastZoomProgress) * smoothing;
         if (offHand) {
            GL11.glTranslatef(0.0F, 0.03F, -0.76F);
            GL11.glRotatef(23.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-4.0F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.15F, 0.2F, -0.6F);
         } else if (FlansModClient.zoomProgress + 0.1F > 0.9F && ItemGun.crouching && !animations.reloading) {
            GL11.glRotatef(25.0F - 5.0F * adsSwitch, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-5.0F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.15F, 0.2F + 0.175F * adsSwitch, -0.6F - 0.405F * adsSwitch);
            if (gunType.hasScopeOverlay) {
               GL11.glTranslatef(-0.3F * adsSwitch, 0.0F, 0.0F);
            }

            GL11.glRotatef(4.5F * adsSwitch, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(model.crouchZoom, -0.03F * adsSwitch, 0.0F);
         } else if (FlansModClient.zoomProgress + 0.1F < 0.2F && ItemGun.sprinting && !animations.reloading && !ItemGun.shooting && model.fancyStance) {
            GL11.glRotatef(25.0F - 5.0F * adsSwitch + model.stanceRotate.z, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-5.0F + model.stanceRotate.x, 0.0F + model.stanceRotate.y, 1.0F, -0.0F);
            GL11.glTranslatef(0.15F, 0.2F + 0.175F * adsSwitch, -0.6F - 0.405F * adsSwitch);
            if (gunType.hasScopeOverlay) {
               GL11.glTranslatef(-0.3F * adsSwitch, 0.0F, 0.0F);
            }

            GL11.glRotatef(4.5F * adsSwitch, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(0.0F + model.stanceTranslate.x, -0.03F * adsSwitch + model.stanceTranslate.y, 0.0F + model.stanceTranslate.z);
         } else {
            GL11.glRotatef(25.0F - 5.0F * adsSwitch, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-5.0F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.15F, 0.2F + 0.175F * adsSwitch, -0.6F - 0.405F * adsSwitch);
            if (gunType.hasScopeOverlay) {
               GL11.glTranslatef(-0.3F * adsSwitch, 0.0F, 0.0F);
            }

            GL11.glRotatef(4.5F * adsSwitch, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-0.0F, -0.03F * adsSwitch, 0.0F);
         }

         Vector3f meleeDownPos;
         Vector3f nextMeleePos;
         Vector3f meleeDownAngles;
         Vector3f nextMeleeAngles;
         if (animations.meleeAnimationProgress > 0 && animations.meleeAnimationProgress < gunType.meleePath.size()) {
            meleeDownPos = (Vector3f)gunType.meleePath.get(animations.meleeAnimationProgress);
            nextMeleePos = animations.meleeAnimationProgress + 1 < gunType.meleePath.size() ? (Vector3f)gunType.meleePath.get(animations.meleeAnimationProgress + 1) : new Vector3f();
            GL11.glTranslatef(meleeDownPos.x + (nextMeleePos.x - meleeDownPos.x) * smoothing, meleeDownPos.y + (nextMeleePos.y - meleeDownPos.y) * smoothing, meleeDownPos.z + (nextMeleePos.z - meleeDownPos.z) * smoothing);
            meleeDownAngles = (Vector3f)gunType.meleePathAngles.get(animations.meleeAnimationProgress);
            nextMeleeAngles = animations.meleeAnimationProgress + 1 < gunType.meleePathAngles.size() ? (Vector3f)gunType.meleePathAngles.get(animations.meleeAnimationProgress + 1) : new Vector3f();
            GL11.glRotatef(meleeDownAngles.y + (nextMeleeAngles.y - meleeDownAngles.y) * smoothing, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(meleeDownAngles.z + (nextMeleeAngles.z - meleeDownAngles.z) * smoothing, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(meleeDownAngles.x + (nextMeleeAngles.x - meleeDownAngles.x) * smoothing, 1.0F, 0.0F, 0.0F);
         }

         if (animations.meleeLeftAnimationProgress > 0 && animations.meleeLeftAnimationProgress < gunType.meleeLeftPath.size()) {
            meleeDownPos = (Vector3f)gunType.meleeLeftPath.get(animations.meleeLeftAnimationProgress);
            nextMeleePos = animations.meleeLeftAnimationProgress + 1 < gunType.meleeLeftPath.size() ? (Vector3f)gunType.meleeLeftPath.get(animations.meleeLeftAnimationProgress + 1) : new Vector3f();
            GL11.glTranslatef(meleeDownPos.x + (nextMeleePos.x - meleeDownPos.x) * smoothing, meleeDownPos.y + (nextMeleePos.y - meleeDownPos.y) * smoothing, meleeDownPos.z + (nextMeleePos.z - meleeDownPos.z) * smoothing);
            meleeDownAngles = (Vector3f)gunType.meleeLeftPathAngles.get(animations.meleeLeftAnimationProgress);
            nextMeleeAngles = animations.meleeLeftAnimationProgress + 1 < gunType.meleeLeftPathAngles.size() ? (Vector3f)gunType.meleeLeftPathAngles.get(animations.meleeLeftAnimationProgress + 1) : new Vector3f();
            GL11.glRotatef(meleeDownAngles.y + (nextMeleeAngles.y - meleeDownAngles.y) * smoothing, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(meleeDownAngles.z + (nextMeleeAngles.z - meleeDownAngles.z) * smoothing, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(meleeDownAngles.x + (nextMeleeAngles.x - meleeDownAngles.x) * smoothing, 1.0F, 0.0F, 0.0F);
         } else if (animations.meleeRightAnimationProgress > 0 && animations.meleeRightAnimationProgress < gunType.meleeRightPath.size()) {
            meleeDownPos = (Vector3f)gunType.meleeRightPath.get(animations.meleeRightAnimationProgress);
            nextMeleePos = animations.meleeRightAnimationProgress + 1 < gunType.meleeRightPath.size() ? (Vector3f)gunType.meleeRightPath.get(animations.meleeRightAnimationProgress + 1) : new Vector3f();
            GL11.glTranslatef(meleeDownPos.x + (nextMeleePos.x - meleeDownPos.x) * smoothing, meleeDownPos.y + (nextMeleePos.y - meleeDownPos.y) * smoothing, meleeDownPos.z + (nextMeleePos.z - meleeDownPos.z) * smoothing);
            meleeDownAngles = (Vector3f)gunType.meleeRightPathAngles.get(animations.meleeRightAnimationProgress);
            nextMeleeAngles = animations.meleeRightAnimationProgress + 1 < gunType.meleeRightPathAngles.size() ? (Vector3f)gunType.meleeRightPathAngles.get(animations.meleeRightAnimationProgress + 1) : new Vector3f();
            GL11.glRotatef(meleeDownAngles.y + (nextMeleeAngles.y - meleeDownAngles.y) * smoothing, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(meleeDownAngles.z + (nextMeleeAngles.z - meleeDownAngles.z) * smoothing, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(meleeDownAngles.x + (nextMeleeAngles.x - meleeDownAngles.x) * smoothing, 1.0F, 0.0F, 0.0F);
         } else if (animations.meleeDownAnimationProgress > 0 && animations.meleeDownAnimationProgress < gunType.meleeDownPath.size()) {
            meleeDownPos = (Vector3f)gunType.meleeDownPath.get(animations.meleeDownAnimationProgress);
            nextMeleePos = animations.meleeDownAnimationProgress + 1 < gunType.meleeDownPath.size() ? (Vector3f)gunType.meleeDownPath.get(animations.meleeDownAnimationProgress + 1) : new Vector3f();
            GL11.glTranslatef(meleeDownPos.x + (nextMeleePos.x - meleeDownPos.x) * smoothing, meleeDownPos.y + (nextMeleePos.y - meleeDownPos.y) * smoothing, meleeDownPos.z + (nextMeleePos.z - meleeDownPos.z) * smoothing);
            meleeDownAngles = (Vector3f)gunType.meleeDownPathAngles.get(animations.meleeDownAnimationProgress);
            nextMeleeAngles = animations.meleeDownAnimationProgress + 1 < gunType.meleeDownPathAngles.size() ? (Vector3f)gunType.meleeDownPathAngles.get(animations.meleeDownAnimationProgress + 1) : new Vector3f();
            GL11.glRotatef(meleeDownAngles.y + (nextMeleeAngles.y - meleeDownAngles.y) * smoothing, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(meleeDownAngles.z + (nextMeleeAngles.z - meleeDownAngles.z) * smoothing, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(meleeDownAngles.x + (nextMeleeAngles.x - meleeDownAngles.x) * smoothing, 1.0F, 0.0F, 0.0F);
         }

         if (model.spinningCocking) {
            GL11.glTranslatef(model.spinPoint.x, model.spinPoint.y, model.spinPoint.z);
            float pumped = animations.lastPumped + (animations.pumped - animations.lastPumped) * smoothing;
            GL11.glRotatef(pumped * 180.0F + 180.0F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-model.spinPoint.x, -model.spinPoint.y, -model.spinPoint.z);
         }

         if (animations.reloading) {
            EnumAnimationType anim = model.animationType;
            if (gunType.getGrip(item) != null && gunType.getSecondaryFire(item)) {
               anim = gunType.getGrip(item).model.secondaryAnimType;
            }

            float effectiveReloadAnimationProgress = animations.lastReloadAnimationProgress + (animations.reloadAnimationProgress - animations.lastReloadAnimationProgress) * smoothing;
            reloadRotate = 1.0F;
            if (effectiveReloadAnimationProgress < model.tiltGunTime) {
               reloadRotate = effectiveReloadAnimationProgress / model.tiltGunTime;
            }

            if (effectiveReloadAnimationProgress > model.tiltGunTime + model.unloadClipTime + model.loadClipTime) {
               reloadRotate = 1.0F - (effectiveReloadAnimationProgress - (model.tiltGunTime + model.unloadClipTime + model.loadClipTime)) / model.untiltGunTime;
            }

            switch(anim) {
            case BOTTOM_CLIP:
            case PISTOL_CLIP:
            case SHOTGUN:
            case END_LOADED:
               GL11.glRotatef(60.0F * reloadRotate, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(30.0F * reloadRotate * (float)flip, 1.0F, 0.0F, 0.0F);
               GL11.glTranslatef(0.25F * reloadRotate, 0.0F, 0.0F);
               break;
            case CROSSBOW:
               GL11.glRotatef(60.0F * reloadRotate, 0.0F, 0.0F, -1.0F);
               GL11.glTranslatef(0.25F * reloadRotate, 0.0F, 0.0F);
               break;
            case CUSTOMBOTTOM_CLIP:
            case CUSTOMPISTOL_CLIP:
            case CUSTOMSHOTGUN:
            case CUSTOMEND_LOADED:
               GL11.glRotatef(model.rotateGunVertical * reloadRotate, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(model.rotateGunHorizontal * reloadRotate, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(model.tiltGun * reloadRotate, 1.0F, 0.0F, 0.0F);
               GL11.glTranslatef(model.translateGun.x * reloadRotate, model.translateGun.y * reloadRotate, model.translateGun.z * reloadRotate);
               break;
            case BACK_LOADED:
               GL11.glRotatef(-75.0F * reloadRotate, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(-30.0F * reloadRotate * (float)flip, 1.0F, 0.0F, 0.0F);
               GL11.glTranslatef(0.5F * reloadRotate, 0.0F, 0.0F);
               break;
            case CUSTOMBACK_LOADED:
               GL11.glRotatef(model.rotateGunVertical * reloadRotate, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(model.rotateGunHorizontal * reloadRotate, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(model.tiltGun * reloadRotate, 1.0F, 0.0F, 0.0F);
               GL11.glTranslatef(model.translateGun.x * reloadRotate, model.translateGun.y * reloadRotate, model.translateGun.z * reloadRotate);
               break;
            case BULLPUP:
               GL11.glRotatef(70.0F * reloadRotate, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(10.0F * reloadRotate * (float)flip, 1.0F, 0.0F, 0.0F);
               GL11.glTranslatef(0.5F * reloadRotate, -0.2F * reloadRotate, 0.0F);
               break;
            case CUSTOMBULLPUP:
               GL11.glRotatef(model.rotateGunVertical * reloadRotate, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(model.rotateGunHorizontal * reloadRotate, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(model.tiltGun * reloadRotate, 1.0F, 0.0F, 0.0F);
               GL11.glTranslatef(model.translateGun.x * reloadRotate, model.translateGun.y * reloadRotate, model.translateGun.z * reloadRotate);
               break;
            case RIFLE:
               GL11.glRotatef(30.0F * reloadRotate, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(-30.0F * reloadRotate * (float)flip, 1.0F, 0.0F, 0.0F);
               GL11.glTranslatef(0.5F * reloadRotate, 0.0F, -0.5F * reloadRotate);
               break;
            case CUSTOMRIFLE:
               GL11.glRotatef(model.rotateGunVertical * reloadRotate, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(model.rotateGunHorizontal * reloadRotate, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(model.tiltGun * reloadRotate, 1.0F, 0.0F, 0.0F);
               GL11.glTranslatef(model.translateGun.x * reloadRotate, model.translateGun.y * reloadRotate, model.translateGun.z * reloadRotate);
               break;
            case RIFLE_TOP:
            case REVOLVER:
               GL11.glRotatef(30.0F * reloadRotate, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(10.0F * reloadRotate, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-10.0F * reloadRotate * (float)flip, 1.0F, 0.0F, 0.0F);
               GL11.glTranslatef(0.1F * reloadRotate, -0.2F * reloadRotate, -0.1F * reloadRotate);
               break;
            case CUSTOMRIFLE_TOP:
            case CUSTOMREVOLVER:
               GL11.glRotatef(model.rotateGunVertical * reloadRotate, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(model.rotateGunHorizontal * reloadRotate, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(model.tiltGun * reloadRotate, 1.0F, 0.0F, 0.0F);
               GL11.glTranslatef(model.translateGun.x * reloadRotate, model.translateGun.y * reloadRotate, model.translateGun.z * reloadRotate);
               break;
            case REVOLVER2:
               GL11.glRotatef(20.0F * reloadRotate, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(-10.0F * reloadRotate * (float)flip, 1.0F, 0.0F, 0.0F);
               break;
            case CUSTOMREVOLVER2:
               GL11.glRotatef(model.rotateGunVertical * reloadRotate, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(model.rotateGunHorizontal * reloadRotate, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(model.tiltGun * reloadRotate, 1.0F, 0.0F, 0.0F);
               GL11.glTranslatef(model.translateGun.x * reloadRotate, model.translateGun.y * reloadRotate, model.translateGun.z * reloadRotate);
               break;
            case ALT_PISTOL_CLIP:
               GL11.glRotatef(60.0F * reloadRotate * (float)flip, 0.0F, 1.0F, 0.0F);
               GL11.glTranslatef(0.15F * reloadRotate, 0.25F * reloadRotate, 0.0F);
               break;
            case CUSTOMALT_PISTOL_CLIP:
               GL11.glRotatef(model.rotateGunVertical * reloadRotate, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(model.rotateGunHorizontal * reloadRotate, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(model.tiltGun * reloadRotate, 1.0F, 0.0F, 0.0F);
               GL11.glTranslatef(model.translateGun.x * reloadRotate, model.translateGun.y * reloadRotate, model.translateGun.z * reloadRotate);
               break;
            case STRIKER:
               GL11.glRotatef(-35.0F * reloadRotate * (float)flip, 1.0F, 0.0F, 0.0F);
               GL11.glTranslatef(0.2F * reloadRotate, 0.0F, -0.1F * reloadRotate);
               break;
            case CUSTOMSTRIKER:
               GL11.glRotatef(model.rotateGunVertical * reloadRotate, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(model.rotateGunHorizontal * reloadRotate, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(model.tiltGun * reloadRotate, 1.0F, 0.0F, 0.0F);
               GL11.glTranslatef(model.translateGun.x * reloadRotate, model.translateGun.y * reloadRotate, model.translateGun.z * reloadRotate);
               break;
            case GENERIC:
               GL11.glRotatef(45.0F * reloadRotate, 0.0F, 0.0F, 1.0F);
               GL11.glTranslatef(-0.2F * reloadRotate, -0.5F * reloadRotate, 0.0F);
               break;
            case CUSTOMGENERIC:
               GL11.glRotatef(model.rotateGunVertical * reloadRotate, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(model.rotateGunHorizontal * reloadRotate, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(model.tiltGun * reloadRotate, 1.0F, 0.0F, 0.0F);
               GL11.glTranslatef(model.translateGun.x * reloadRotate, model.translateGun.y * reloadRotate, model.translateGun.z * reloadRotate);
               break;
            case CUSTOM:
               GL11.glRotatef(model.rotateGunVertical * reloadRotate, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(model.rotateGunHorizontal * reloadRotate, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(model.tiltGun * reloadRotate, 1.0F, 0.0F, 0.0F);
               GL11.glTranslatef(model.translateGun.x * reloadRotate, model.translateGun.y * reloadRotate, model.translateGun.z * reloadRotate);
            }
         }
      }

      this.renderGun(item, gunType, f, model, animations, reloadRotate, type);
      GL11.glPopMatrix();
   }

   public void renderGun(ItemStack item, GunType type, float f, ModelGun model, GunAnimations animations, float reloadRotate, ItemRenderType rtype) {
      float min = -1.5F;
      float max = 1.5F;
      float randomNum = (new Random()).nextFloat();
      float result = min + randomNum * (max - min);
      if (renderEngine == null) {
         renderEngine = Minecraft.func_71410_x().field_71446_o;
      }

      if (animations == null) {
         animations = GunAnimations.defaults;
      }

      AttachmentType scopeAttachment = type.getScope(item);
      AttachmentType barrelAttachment = type.getBarrel(item);
      AttachmentType stockAttachment = type.getStock(item);
      AttachmentType gripAttachment = type.getGrip(item);
      AttachmentType gadgetAttachment = type.getGadget(item);
      AttachmentType slideAttachment = type.getSlide(item);
      AttachmentType pumpAttachment = type.getPump(item);
      AttachmentType accessoryAttachment = type.getAccessory(item);
      ItemStack scopeItemStack = type.getScopeItemStack(item);
      ItemStack barrelItemStack = type.getBarrelItemStack(item);
      ItemStack stockItemStack = type.getStockItemStack(item);
      ItemStack gripItemStack = type.getGripItemStack(item);
      ItemStack gadgetItemStack = type.getGadgetItemStack(item);
      ItemStack slideItemStack = type.getSlideItemStack(item);
      ItemStack pumpItemStack = type.getPumpItemStack(item);
      ItemStack accessoryItemStack = type.getAccessoryItemStack(item);
      animations.recoilAmount = model.recoilAmount;
      GL11.glPushMatrix();
      if (rtype == ItemRenderType.EQUIPPED_FIRST_PERSON) {
         GL11.glTranslatef(0.0F, 0.0F, 0.0F);
         GL11.glTranslatef(-(animations.lastGunRecoil + (animations.gunRecoil - animations.lastGunRecoil) * smoothing) * this.getRecoilDistance(gripAttachment, type, item), 0.0F, 0.0F);
         GL11.glRotatef(-(animations.lastGunRecoil + (animations.gunRecoil - animations.lastGunRecoil) * smoothing) * this.getRecoilAngle(gripAttachment, type, item), 0.0F, 0.0F, 1.0F);
         GL11.glRotatef((-animations.lastGunRecoil + (animations.gunRecoil - animations.lastGunRecoil) * smoothing) * result * smoothing * model.ShakeDistance, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef((-animations.lastGunRecoil + (animations.gunRecoil - animations.lastGunRecoil) * smoothing) * result * smoothing * model.ShakeDistance, 1.0F, 0.0F, 0.0F);
         if (model.animationType == EnumAnimationType.SHOTGUN && !animations.reloading) {
            GL11.glRotatef(-(1.0F - Math.abs(animations.lastPumped + (animations.pumped - animations.lastPumped) * smoothing)) * -5.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-(1.0F - Math.abs(animations.lastPumped + (animations.pumped - animations.lastPumped) * smoothing)) * 5.0F, 1.0F, 0.0F, 0.0F);
         }

         if (model.isSingleAction) {
            GL11.glRotatef(-(1.0F - Math.abs(animations.lastGunPullback + (animations.gunPullback - animations.lastGunPullback) * smoothing)) * -5.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-(1.0F - Math.abs(animations.lastGunPullback + (animations.gunPullback - animations.lastGunPullback) * smoothing)) * 2.5F, 1.0F, 0.0F, 0.0F);
         }
      }

      ItemStack[] bulletStacks = new ItemStack[type.getNumAmmoItemsInGun(item)];
      boolean empty = true;
      int numRounds = 0;

      for(int i = 0; i < type.getNumAmmoItemsInGun(item); ++i) {
         bulletStacks[i] = ((ItemGun)item.func_77973_b()).getBulletItemStack(item, i);
         if (bulletStacks[i] != null && bulletStacks[i].func_77973_b() instanceof ItemShootable && bulletStacks[i].func_77960_j() < bulletStacks[i].func_77958_k()) {
            empty = false;
            numRounds += bulletStacks[i].func_77958_k() - bulletStacks[i].func_77960_j();
         }
      }

      if (model.slideLockOnEmpty) {
         if (empty) {
            animations.onGunEmpty(true);
         } else if (!empty && !animations.reloading) {
            animations.onGunEmpty(false);
         }
      }

      if (rtype == ItemRenderType.EQUIPPED_FIRST_PERSON && model.hasArms && FlansMod.armsEnable) {
         Minecraft mc = Minecraft.func_71410_x();
         this.renderFirstPersonArm(mc.field_71439_g, model, animations);
      }

      renderEngine.func_110577_a(FlansModResourceHandler.getPaintjobTexture(type.getPaintjob(item.func_77960_j())));
      if (scopeAttachment != null && model.gunOffset != 0.0F) {
         GL11.glTranslatef(0.0F, -scopeAttachment.model.renderOffset + model.gunOffset / 16.0F, 0.0F);
      }

      GL11.glPushMatrix();
      GL11.glScalef(type.modelScale, type.modelScale, type.modelScale);
      model.renderGun(f);
      if (scopeAttachment == null && !model.scopeIsOnSlide && !model.scopeIsOnBreakAction) {
         model.renderDefaultScope(f);
      }

      if (barrelAttachment == null) {
         model.renderDefaultBarrel(f);
      }

      if (stockAttachment == null) {
         model.renderDefaultStock(f);
      }

      if (gripAttachment == null && !model.gripIsOnPump) {
         model.renderDefaultGrip(f);
      }

      if (gadgetAttachment == null && !model.gadgetIsOnPump) {
         model.renderDefaultGadget(f);
      }

      GL11.glPushMatrix();
      if (model.isBulletCounterActive) {
         model.renderBulletCounter(f, numRounds);
      }

      GL11.glPopMatrix();
      GL11.glPushMatrix();
      if (model.isAdvBulletCounterActive) {
         model.renderAdvBulletCounter(f, numRounds, model.countOnRightHandSide);
      }

      GL11.glPopMatrix();
      boolean isFlashEnabled = true;
      if (barrelAttachment != null && barrelAttachment.disableMuzzleFlash) {
         isFlashEnabled = false;
      }

      if (isFlashEnabled && animations.muzzleFlashTime > 0 && type.flashModel != null && !type.getSecondaryFire(item)) {
         GL11.glPushMatrix();
         ModelFlash flash = type.flashModel;
         GL11.glScalef(model.flashScale, model.flashScale, model.flashScale);
         if (barrelAttachment != null) {
            GL11.glTranslatef(model.muzzleFlashPoint.x + barrelAttachment.model.attachmentFlashOffset.x, model.muzzleFlashPoint.y + barrelAttachment.model.attachmentFlashOffset.y, model.muzzleFlashPoint.z + barrelAttachment.model.attachmentFlashOffset.z);
         } else {
            GL11.glTranslatef(model.muzzleFlashPoint.x + model.defaultBarrelFlashPoint.x, model.muzzleFlashPoint.y + model.defaultBarrelFlashPoint.y, model.muzzleFlashPoint.z + model.defaultBarrelFlashPoint.z);
         }

         renderEngine.func_110577_a(FlansModResourceHandler.getAuxiliaryTexture(type.flashTexture));
         ModelGun.glowOn();
         flash.renderFlash(f, animations.flashInt);
         ModelGun.glowOff();
         renderEngine.func_110577_a(FlansModResourceHandler.getPaintjobTexture(type.getPaintjob(item.func_77960_j())));
         GL11.glPopMatrix();
      }

      if (slideAttachment == null && !type.getSecondaryFire(item)) {
         GL11.glPushMatrix();
         GL11.glTranslatef(-(animations.lastGunSlide + (animations.gunSlide - animations.lastGunSlide) * smoothing) * model.gunSlideDistance, 0.0F, 0.0F);
         GL11.glTranslatef(-(1.0F - Math.abs(animations.lastCharged + (animations.charged - animations.lastCharged) * smoothing)) * model.chargeHandleDistance, 0.0F, 0.0F);
         model.renderSlide(f);
         if (scopeAttachment == null && model.scopeIsOnSlide) {
            model.renderDefaultScope(f);
         }

         GL11.glPopMatrix();
      }

      if (slideAttachment == null && !type.getSecondaryFire(item)) {
         GL11.glPushMatrix();
         GL11.glTranslatef(-(animations.lastGunSlide + (animations.gunSlide - animations.lastGunSlide) * smoothing) * model.altgunSlideDistance, 0.0F, 0.0F);
         model.renderaltSlide(f);
         GL11.glPopMatrix();
      }

      GL11.glPushMatrix();
      GL11.glTranslatef(model.barrelBreakPoint.x, model.barrelBreakPoint.y, model.barrelBreakPoint.z);
      GL11.glRotatef(reloadRotate * -model.breakAngle, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(-model.barrelBreakPoint.x, -model.barrelBreakPoint.y, -model.barrelBreakPoint.z);
      model.renderBreakAction(f);
      if (scopeAttachment == null && model.scopeIsOnBreakAction) {
         model.renderDefaultScope(f);
      }

      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(model.altbarrelBreakPoint.x, model.altbarrelBreakPoint.y, model.altbarrelBreakPoint.z);
      GL11.glRotatef(reloadRotate * -model.altbreakAngle, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(-model.altbarrelBreakPoint.x, -model.altbarrelBreakPoint.y, -model.altbarrelBreakPoint.z);
      model.renderaltBreakAction(f);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(model.hammerSpinPoint.x, model.hammerSpinPoint.y, model.hammerSpinPoint.z);
      GL11.glRotatef(-animations.hammerRotation, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(-model.hammerSpinPoint.x, -model.hammerSpinPoint.y, -model.hammerSpinPoint.z);
      model.renderHammer(f);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(model.althammerSpinPoint.x, model.althammerSpinPoint.y, model.althammerSpinPoint.z);
      GL11.glRotatef(-animations.althammerRotation, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(-model.althammerSpinPoint.x, -model.althammerSpinPoint.y, -model.althammerSpinPoint.z);
      model.renderaltHammer(f);
      GL11.glPopMatrix();
      if (pumpAttachment == null) {
         GL11.glPushMatrix();
         GL11.glTranslatef(-(animations.lastGunSlide + (animations.gunSlide - animations.lastGunSlide) * smoothing) * model.gunSlideDistance, 0.0F, 0.0F);
         GL11.glTranslatef(-(1.0F - Math.abs(animations.lastPumped + (animations.pumped - animations.lastPumped) * smoothing)) * model.pumpHandleDistance, 0.0F, 0.0F);
         model.renderPump(f);
         if (gripAttachment == null && model.gripIsOnPump) {
            model.renderDefaultGrip(f);
         }

         if (gadgetAttachment == null && model.gadgetIsOnPump) {
            model.renderDefaultGadget(f);
         }

         GL11.glPopMatrix();
      }

      if (pumpAttachment == null) {
         GL11.glPushMatrix();
         GL11.glTranslatef(-(1.0F - Math.abs(animations.lastPumped + (animations.pumped - animations.lastPumped) * smoothing)) * model.pumpHandleDistance, 0.0F, 0.0F);
         float var10000 = animations.lastPumped + (animations.pumped - animations.lastPumped) * smoothing;
         model.renderaltPump(f);
         if (gripAttachment == null && model.gripIsOnPump) {
            model.renderDefaultGrip(f);
         }

         if (gadgetAttachment == null && model.gadgetIsOnPump) {
            model.renderDefaultGadget(f);
         }

         GL11.glPopMatrix();
      }

      if (model.chargeHandleDistance != 0.0F) {
         GL11.glPushMatrix();
         GL11.glTranslatef(-(1.0F - Math.abs(animations.lastCharged + (animations.charged - animations.lastCharged) * smoothing)) * model.chargeHandleDistance, 0.0F, 0.0F);
         model.renderCharge(f);
         GL11.glPopMatrix();
      }

      if (type.mode == EnumFireMode.MINIGUN) {
         GL11.glPushMatrix();
         GL11.glTranslatef(model.minigunBarrelOrigin.x, model.minigunBarrelOrigin.y, model.minigunBarrelOrigin.z);
         GL11.glRotatef(animations.minigunBarrelRotation, 1.0F, 0.0F, 0.0F);
         GL11.glTranslatef(-model.minigunBarrelOrigin.x, -model.minigunBarrelOrigin.y, -model.minigunBarrelOrigin.z);
         model.renderMinigunBarrel(f);
         GL11.glPopMatrix();
      }

      GL11.glPushMatrix();
      GL11.glTranslatef(model.revolverFlipPoint.x, model.revolverFlipPoint.y, model.revolverFlipPoint.z);
      GL11.glRotatef(reloadRotate * model.revolverFlipAngle, 1.0F, 0.0F, 0.0F);
      GL11.glTranslatef(-model.revolverFlipPoint.x, -model.revolverFlipPoint.y, -model.revolverFlipPoint.z);
      model.renderRevolverBarrel(f);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(model.revolverFlipPoint.x, model.revolverFlipPoint.y, model.revolverFlipPoint.z);
      GL11.glRotatef(reloadRotate * model.revolverFlipAngle, -1.0F, 0.0F, 0.0F);
      GL11.glTranslatef(-model.revolverFlipPoint.x, -model.revolverFlipPoint.y, -model.revolverFlipPoint.z);
      model.renderRevolver2Barrel(f);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      boolean shouldRender = true;
      EnumAnimationType anim = model.animationType;
      if (gripAttachment != null && type.getSecondaryFire(item)) {
         anim = gripAttachment.model.secondaryAnimType;
      }

      float moveX = model.tiltGunTime;
      float moveY = model.unloadClipTime;
      float moveZ = model.loadClipTime;
      if (gripAttachment != null && type.getSecondaryFire(item)) {
         moveX = gripAttachment.model.tiltGunTime;
         moveY = gripAttachment.model.unloadClipTime;
         moveZ = gripAttachment.model.loadClipTime;
      }

      switch(anim) {
      case END_LOADED:
      case CROSSBOW:
      case BACK_LOADED:
         if (empty) {
            shouldRender = false;
         }
      }

      float effectiveReloadAnimationProgress;
      if (shouldRender && animations.reloading && Minecraft.func_71410_x().field_71474_y.field_74320_O == 0) {
         effectiveReloadAnimationProgress = animations.lastReloadAnimationProgress + (animations.reloadAnimationProgress - animations.lastReloadAnimationProgress) * smoothing;
         float clipPosition = 0.0F;
         if (effectiveReloadAnimationProgress > moveX && effectiveReloadAnimationProgress < moveX + moveY) {
            clipPosition = (effectiveReloadAnimationProgress - moveX) / moveY;
         }

         if (effectiveReloadAnimationProgress >= moveX + moveY && effectiveReloadAnimationProgress < moveX + moveY + moveZ) {
            clipPosition = 1.0F - (effectiveReloadAnimationProgress - (moveX + moveY)) / moveZ;
         }

         float loadOnlyClipPosition = Math.max(0.0F, Math.min(1.0F, 1.0F - (effectiveReloadAnimationProgress - moveX) / (moveY + moveZ)));
         float thing;
         int bulletNum;
         float bulletProgress;
         float xDisplacement;
         switch(anim) {
         case BOTTOM_CLIP:
         case CUSTOMBOTTOM_CLIP:
            GL11.glRotatef(-180.0F * clipPosition, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(60.0F * clipPosition, 1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(0.5F * clipPosition * 1.0F / type.modelScale, 0.0F, 0.0F);
            break;
         case PISTOL_CLIP:
         case CUSTOMPISTOL_CLIP:
            GL11.glRotatef(-90.0F * clipPosition * clipPosition, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(0.0F, -1.0F * clipPosition * 1.0F / type.modelScale, 0.0F);
            break;
         case SHOTGUN:
         case CUSTOMSHOTGUN:
         case STRIKER:
         case CUSTOMSTRIKER:
            thing = clipPosition * this.getNumBulletsInReload(gripAttachment, type, item);
            bulletNum = MathHelper.func_76141_d(thing);
            bulletProgress = thing - (float)bulletNum;
            GL11.glRotatef(bulletProgress * -30.0F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(bulletProgress * -0.5F * 1.0F / type.modelScale, bulletProgress * -1.0F * 1.0F / type.modelScale, 0.0F);
            break;
         case END_LOADED:
         case CUSTOMEND_LOADED:
            thing = loadOnlyClipPosition > 0.5F ? loadOnlyClipPosition * 2.0F - 1.0F : 0.0F;
            GL11.glRotatef(-45.0F * thing, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-this.getEndLoadedDistance(gripAttachment, type, item) * thing, -0.5F * thing, 0.0F);
            xDisplacement = loadOnlyClipPosition < 0.5F ? loadOnlyClipPosition * 2.0F : 1.0F;
            GL11.glTranslatef(this.getEndLoadedDistance(gripAttachment, type, item) * xDisplacement, 0.0F, 0.0F);
            break;
         case CROSSBOW:
            thing = loadOnlyClipPosition > 0.5F ? loadOnlyClipPosition * 2.0F - 1.0F : 0.0F;
            GL11.glRotatef(45.0F * thing, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-this.getEndLoadedDistance(gripAttachment, type, item) * thing, 0.5F * thing, 0.0F);
            xDisplacement = loadOnlyClipPosition < 0.5F ? loadOnlyClipPosition * 2.0F : 1.0F;
            GL11.glTranslatef(this.getEndLoadedDistance(gripAttachment, type, item) * xDisplacement, 0.0F, 0.0F);
            break;
         case BACK_LOADED:
         case CUSTOMBACK_LOADED:
            thing = loadOnlyClipPosition > 0.5F ? loadOnlyClipPosition * 2.0F - 1.0F : 0.0F;
            GL11.glTranslatef(this.getEndLoadedDistance(gripAttachment, type, item) * thing, -0.5F * thing, 0.0F);
            xDisplacement = loadOnlyClipPosition < 0.5F ? loadOnlyClipPosition * 2.0F : 1.0F;
            GL11.glTranslatef(-this.getEndLoadedDistance(gripAttachment, type, item) * xDisplacement, 0.0F, 0.0F);
            break;
         case BULLPUP:
         case CUSTOMBULLPUP:
            GL11.glRotatef(-150.0F * clipPosition, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(60.0F * clipPosition, 1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(1.0F * clipPosition * 1.0F / type.modelScale, -0.5F * clipPosition * 1.0F / type.modelScale, 0.0F);
            break;
         case RIFLE:
            thing = clipPosition * this.getNumBulletsInReload(gripAttachment, type, item);
            bulletNum = MathHelper.func_76141_d(thing);
            bulletProgress = thing - (float)bulletNum;
            GL11.glRotatef(bulletProgress * 15.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(bulletProgress * 15.0F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(bulletProgress * -1.0F * 1.0F / type.modelScale, 0.0F, bulletProgress * 0.5F * 1.0F / type.modelScale);
            break;
         case CUSTOMRIFLE:
            thing = clipPosition * this.getNumBulletsInReload(gripAttachment, type, item);
            bulletNum = MathHelper.func_76141_d(thing);
            bulletProgress = thing - (float)bulletNum;
            GL11.glRotatef(bulletProgress * model.rotateClipVertical, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(bulletProgress * model.rotateClipHorizontal, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(bulletProgress * model.tiltClip, 1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(bulletProgress * model.translateClip.x / type.modelScale, bulletProgress * model.translateClip.y / type.modelScale, bulletProgress * model.translateClip.z / type.modelScale);
            break;
         case RIFLE_TOP:
         case CUSTOMRIFLE_TOP:
            thing = clipPosition * this.getNumBulletsInReload(gripAttachment, type, item);
            bulletNum = MathHelper.func_76141_d(thing);
            bulletProgress = thing - (float)bulletNum;
            GL11.glRotatef(bulletProgress * 55.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(bulletProgress * 95.0F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(bulletProgress * -0.1F * 1.0F / type.modelScale, bulletProgress * 1.0F * 1.0F / type.modelScale, bulletProgress * 0.5F * 1.0F / type.modelScale);
            break;
         case REVOLVER:
         case CUSTOMREVOLVER:
            GL11.glTranslatef(model.revolverFlipPoint.x, model.revolverFlipPoint.y, model.revolverFlipPoint.z);
            GL11.glRotatef(reloadRotate * model.revolverFlipAngle, 1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(-model.revolverFlipPoint.x, -model.revolverFlipPoint.y, -model.revolverFlipPoint.z);
            GL11.glTranslatef(-1.0F * clipPosition * 1.0F / type.modelScale, 0.0F, 0.0F);
            break;
         case REVOLVER2:
         case CUSTOMREVOLVER2:
            GL11.glTranslatef(model.revolver2FlipPoint.x, model.revolver2FlipPoint.y, model.revolver2FlipPoint.z);
            GL11.glRotatef(reloadRotate * model.revolver2FlipAngle, -1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(-model.revolver2FlipPoint.x, -model.revolver2FlipPoint.y, -model.revolver2FlipPoint.z);
            GL11.glTranslatef(-1.0F * clipPosition * 1.0F / type.modelScale, 0.0F, 0.0F);
            break;
         case ALT_PISTOL_CLIP:
         case CUSTOMALT_PISTOL_CLIP:
            GL11.glRotatef(5.0F * clipPosition, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(0.0F, -3.0F * clipPosition * 1.0F / type.modelScale, 0.0F);
         case GENERIC:
         case CUSTOMGENERIC:
         default:
            break;
         case CUSTOM:
            if ((double)effectiveReloadAnimationProgress < 0.5D && model.stagedReload) {
               GL11.glRotatef(model.rotateClipVertical * clipPosition, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(model.rotateClipHorizontal * clipPosition, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(model.tiltClip * clipPosition, 1.0F, 0.0F, 0.0F);
               GL11.glTranslatef(model.translateClip.x * clipPosition * 1.0F / type.modelScale, model.translateClip.y * clipPosition * 1.0F / type.modelScale, model.translateClip.z * clipPosition * 1.0F / type.modelScale);
            } else if ((double)effectiveReloadAnimationProgress > 0.5D && model.stagedReload) {
               GL11.glRotatef(model.stagedrotateClipVertical * clipPosition, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(model.stagedrotateClipHorizontal * clipPosition, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(model.stagedtiltClip * clipPosition, 1.0F, 0.0F, 0.0F);
               GL11.glTranslatef(model.stagedtranslateClip.x * clipPosition * 1.0F / type.modelScale, model.stagedtranslateClip.y * clipPosition * 1.0F / type.modelScale, model.stagedtranslateClip.z * clipPosition * 1.0F / type.modelScale);
            } else {
               GL11.glRotatef(model.rotateClipVertical * clipPosition, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(model.rotateClipHorizontal * clipPosition, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(model.tiltClip * clipPosition, 1.0F, 0.0F, 0.0F);
               GL11.glTranslatef(model.translateClip.x * clipPosition * 1.0F / type.modelScale, model.translateClip.y * clipPosition * 1.0F / type.modelScale, model.translateClip.z * clipPosition * 1.0F / type.modelScale);
            }
            break;
         case BREAK_ACTION:
         case CUSTOMBREAK_ACTION:
            GL11.glTranslatef(model.barrelBreakPoint.x, model.barrelBreakPoint.y, model.barrelBreakPoint.z);
            GL11.glRotatef(reloadRotate * -model.breakAngle, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-model.barrelBreakPoint.x, -model.barrelBreakPoint.y, -model.barrelBreakPoint.z);
            GL11.glTranslatef(-model.breakActionAmmoDistance * clipPosition * 1.0F / type.modelScale, 0.0F, 0.0F);
            break;
         case SIDE_CLIP:
         case CUSTOMSIDE_CLIP:
            GL11.glRotatef(180.0F * clipPosition, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(60.0F * clipPosition, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.5F * clipPosition * 1.0F / type.modelScale, 0.0F, 0.0F);
            break;
         case P90:
         case CUSTOMP90:
            GL11.glRotatef(-15.0F * reloadRotate * reloadRotate, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(0.0F, 0.075F * reloadRotate, 0.0F);
            GL11.glTranslatef(-2.0F * clipPosition * 1.0F / type.modelScale, -0.3F * clipPosition * 1.0F / type.modelScale, 0.5F * clipPosition * 1.0F / type.modelScale);
         }
      }

      if (rtype == ItemRenderType.EQUIPPED_FIRST_PERSON && model.hasArms && FlansMod.armsEnable) {
         Minecraft mc = Minecraft.func_71410_x();
         this.renderAnimArm(mc.field_71439_g, model, type, animations);
      }

      renderEngine.func_110577_a(FlansModResourceHandler.getPaintjobTexture(type.getPaintjob(item.func_77960_j())));
      if (shouldRender) {
         if (gripAttachment != null && type.getSecondaryFire(item)) {
            this.renderAttachmentAmmo(f, gripAttachment, model, gripAttachment.getPaintjob(gripItemStack.func_77960_j()), type.getPaintjob(item.func_77960_j()));
         } else {
            model.renderAmmo(f);
         }
      }

      effectiveReloadAnimationProgress = animations.lastReloadAnimationProgress + (animations.reloadAnimationProgress - animations.lastReloadAnimationProgress) * smoothing;
      reloadRotate = 1.0F;
      if ((double)effectiveReloadAnimationProgress > 0.5D) {
         model.renderfullAmmo(f);
      }

      GL11.glPopMatrix();
      GL11.glPushMatrix();
      if (type.getSecondaryFire(item)) {
         model.renderAmmo(f);
      } else if (gripAttachment != null && !type.getSecondaryFire(item)) {
         this.renderAttachmentAmmo(f, gripAttachment, model, gripAttachment.getPaintjob(gripItemStack.func_77960_j()), type.getPaintjob(item.func_77960_j()));
      }

      GL11.glPopMatrix();
      if (rtype == ItemRenderType.EQUIPPED_FIRST_PERSON && FlansMod.casingEnable && type.casingModel != null && !type.getSecondaryFire(item)) {
         ModelCasing casing = type.casingModel;
         GL11.glPushMatrix();
         float casingProg = ((float)animations.lastCasingStage + (float)(animations.casingStage - animations.lastCasingStage) * smoothing) / (float)model.casingAnimTime;
         if (casingProg >= 1.0F) {
            casingProg = 0.0F;
         }

         moveX = model.casingAnimDistance.x + animations.casingRandom.x * model.casingAnimSpread.x;
         moveY = model.casingAnimDistance.y + animations.casingRandom.y * model.casingAnimSpread.y;
         moveZ = model.casingAnimDistance.z + animations.casingRandom.z * model.casingAnimSpread.z;
         GL11.glScalef(model.caseScale, model.caseScale, model.caseScale);
         GL11.glTranslatef(model.casingAttachPoint.x + casingProg * moveX, model.casingAttachPoint.y + casingProg * moveY, model.casingAttachPoint.z + casingProg * moveZ);
         GL11.glRotatef(casingProg * 180.0F, model.casingRotateVector.x, model.casingRotateVector.y, model.casingRotateVector.z);
         renderEngine.func_110577_a(FlansModResourceHandler.getAuxiliaryTexture(type.casingTexture));
         casing.renderCasing(f);
         renderEngine.func_110577_a(FlansModResourceHandler.getPaintjobTexture(type.getPaintjob(item.func_77960_j())));
         GL11.glPopMatrix();
      }

      GL11.glPopMatrix();
      if (scopeAttachment != null) {
         GL11.glPushMatrix();
         this.preRenderAttachment(scopeAttachment, scopeItemStack, model.scopeAttachPoint, type);
         if (model.scopeIsOnBreakAction) {
            GL11.glTranslatef(model.barrelBreakPoint.x, model.barrelBreakPoint.y, model.barrelBreakPoint.z);
            GL11.glRotatef(reloadRotate * -model.breakAngle, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-model.barrelBreakPoint.x, -model.barrelBreakPoint.y, -model.barrelBreakPoint.z);
         }

         if (model.scopeIsOnSlide) {
            GL11.glTranslatef(-(animations.lastGunSlide + (animations.gunSlide - animations.lastGunSlide) * smoothing) * model.gunSlideDistance, 0.0F, 0.0F);
         }

         this.postRenderAttachment(scopeAttachment, scopeItemStack, f);
         GL11.glPopMatrix();
      }

      if (gripAttachment != null) {
         GL11.glPushMatrix();
         this.preRenderAttachment(gripAttachment, gripItemStack, model.gripAttachPoint, type);
         if (model.gripIsOnPump) {
            GL11.glTranslatef(-(1.0F - Math.abs(animations.lastPumped + (animations.pumped - animations.lastPumped) * smoothing)) * model.pumpHandleDistance, 0.0F, 0.0F);
         }

         this.postRenderAttachment(gripAttachment, gripItemStack, f);
         GL11.glPopMatrix();
      }

      if (barrelAttachment != null) {
         GL11.glPushMatrix();
         this.preRenderAttachment(barrelAttachment, barrelItemStack, model.barrelAttachPoint, type);
         this.postRenderAttachment(barrelAttachment, barrelItemStack, f);
         GL11.glPopMatrix();
      }

      if (stockAttachment != null) {
         GL11.glPushMatrix();
         this.preRenderAttachment(stockAttachment, stockItemStack, model.stockAttachPoint, type);
         this.postRenderAttachment(stockAttachment, stockItemStack, f);
         GL11.glPopMatrix();
      }

      if (slideAttachment != null && !type.getSecondaryFire(item)) {
         GL11.glPushMatrix();
         this.preRenderAttachment(slideAttachment, slideItemStack, model.slideAttachPoint, type);
         GL11.glTranslatef(-(animations.lastGunSlide + (animations.gunSlide - animations.lastGunSlide) * smoothing) * model.gunSlideDistance, 0.0F, 0.0F);
         this.postRenderAttachment(slideAttachment, slideItemStack, f);
         GL11.glPopMatrix();
      }

      if (gadgetAttachment != null) {
         GL11.glPushMatrix();
         this.preRenderAttachment(gadgetAttachment, gadgetItemStack, model.gadgetAttachPoint, type);
         if (model.gadgetIsOnPump) {
            GL11.glTranslatef(-(1.0F - Math.abs(animations.lastPumped + (animations.pumped - animations.lastPumped) * smoothing)) * model.pumpHandleDistance, 0.0F, 0.0F);
         }

         this.postRenderAttachment(gadgetAttachment, gadgetItemStack, f);
         GL11.glPopMatrix();
      }

      if (accessoryAttachment != null) {
         GL11.glPushMatrix();
         this.preRenderAttachment(accessoryAttachment, accessoryItemStack, model.accessoryAttachPoint, type);
         this.postRenderAttachment(accessoryAttachment, accessoryItemStack, f);
         GL11.glPopMatrix();
      }

      if (pumpAttachment != null) {
         GL11.glPushMatrix();
         this.preRenderAttachment(pumpAttachment, pumpItemStack, model.pumpAttachPoint, type);
         GL11.glTranslatef(-(1.0F - Math.abs(animations.lastPumped + (animations.pumped - animations.lastPumped) * smoothing)) * model.pumpHandleDistance, 0.0F, 0.0F);
         this.postRenderAttachment(pumpAttachment, pumpItemStack, f);
         GL11.glPopMatrix();
      }

      GL11.glPopMatrix();
   }

   private void preRenderAttachment(AttachmentType attachment, ItemStack stack, Vector3f model, GunType type) {
      Paintjob paintjob = attachment.getPaintjob(stack.func_77960_j());
      renderEngine.func_110577_a(FlansModResourceHandler.getPaintjobTexture(paintjob));
      GL11.glTranslatef(model.x * type.modelScale, model.y * type.modelScale, model.z * type.modelScale);
      GL11.glScalef(attachment.modelScale, attachment.modelScale, attachment.modelScale);
   }

   private void postRenderAttachment(AttachmentType attachment, ItemStack stack, float f) {
      Paintjob paintjob = attachment.getPaintjob(stack.func_77960_j());
      ModelAttachment model = attachment.model;
      if (model != null) {
         model.renderAttachment(f);
      }

      renderEngine.func_110577_a(FlansModResourceHandler.getPaintjobTexture(paintjob));
   }

   private void renderAttachmentAmmo(float f, AttachmentType grip, ModelGun model, Paintjob ammo, Paintjob otherAmmo) {
      renderEngine.func_110577_a(FlansModResourceHandler.getPaintjobTexture(ammo));
      GL11.glTranslatef(model.gripAttachPoint.x, model.gripAttachPoint.y, model.gripAttachPoint.z);
      grip.model.renderAttachmentAmmo(f);
      renderEngine.func_110577_a(FlansModResourceHandler.getPaintjobTexture(otherAmmo));
   }

   private void renderArms(EntityPlayer player, ModelGun model, GunType type, GunAnimations anim) {
   }

   private void renderFirstPersonArm(EntityPlayer player, ModelGun model, GunAnimations anim) {
      Minecraft mc = Minecraft.func_71410_x();
      ModelBiped modelBipedMain = new ModelBiped(0.0F);
      mc.field_71446_o.func_110577_a(mc.field_71439_g.func_110306_p());
      float f = 1.0F;
      GL11.glColor3f(f, f, f);
      modelBipedMain.field_78095_p = 0.0F;
      GL11.glPushMatrix();
      if (!anim.reloading && model.righthandPump) {
         RenderArms.renderArmPump(model, anim, smoothing, model.rightArmRot, model.rightArmPos);
      } else if ((double)anim.charged < 0.9D && model.leftHandAmmo && model.rightHandCharge && anim.charged != -1.0F) {
         RenderArms.renderArmCharge(model, anim, smoothing, model.rightArmChargeRot, model.rightArmChargePos);
      } else if ((double)anim.pumped < 0.9D && model.rightHandBolt && model.leftHandAmmo) {
         RenderArms.renderArmBolt(model, anim, smoothing, model.rightArmChargeRot, model.rightArmChargePos);
      } else if (!anim.reloading && !model.righthandPump) {
         RenderArms.renderArmDefault(model, anim, smoothing, model.rightArmRot, model.rightArmPos);
      } else {
         RenderArms.renderArmReload(model, anim, smoothing, model.rightArmRot, model.rightArmPos);
      }

      GL11.glScalef(model.rightArmScale.x, model.rightArmScale.y, model.rightArmScale.z);
      modelBipedMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, player);
      modelBipedMain.field_78112_f.field_82908_p = 0.0F;
      if (!model.rightHandAmmo) {
         modelBipedMain.field_78112_f.func_78785_a(0.0625F);
      }

      GL11.glPopMatrix();
      GL11.glPushMatrix();
      if (!anim.reloading && model.lefthandPump) {
         RenderArms.renderArmPump(model, anim, smoothing, model.leftArmRot, model.leftArmPos);
      } else if ((double)anim.charged < 0.9D && model.rightHandCharge && model.leftHandAmmo && anim.charged != -1.0F) {
         RenderArms.renderArmCharge(model, anim, smoothing, model.leftArmChargeRot, model.leftArmChargePos);
      } else if ((double)anim.pumped < 0.9D && model.rightHandBolt && model.leftHandAmmo) {
         RenderArms.renderArmBolt(model, anim, smoothing, model.leftArmChargeRot, model.leftArmChargePos);
      } else if (!anim.reloading && !model.lefthandPump) {
         RenderArms.renderArmDefault(model, anim, smoothing, model.leftArmRot, model.leftArmPos);
      } else {
         RenderArms.renderArmReload(model, anim, smoothing, model.leftArmRot, model.leftArmPos);
      }

      GL11.glScalef(model.leftArmScale.x, model.leftArmScale.y, model.leftArmScale.z);
      modelBipedMain.field_78113_g.field_82908_p = 0.0F;
      if (!model.leftHandAmmo) {
         modelBipedMain.field_78113_g.func_78785_a(0.0625F);
      }

      GL11.glPopMatrix();
   }

   private void renderAnimArm(EntityPlayer player, ModelGun model, GunType type, GunAnimations anim) {
      Minecraft mc = Minecraft.func_71410_x();
      ModelBiped modelBipedMain = new ModelBiped(0.0F);
      mc.field_71446_o.func_110577_a(mc.field_71439_g.func_110306_p());
      GL11.glPushMatrix();
      GL11.glScalef(1.0F / type.modelScale, 1.0F / type.modelScale, 1.0F / type.modelScale);
      float f = 1.0F;
      GL11.glColor3f(f, f, f);
      modelBipedMain.field_78095_p = 0.0F;
      GL11.glPushMatrix();
      float effectiveReloadAnimationProgress = anim.lastReloadAnimationProgress + (anim.reloadAnimationProgress - anim.lastReloadAnimationProgress) * smoothing;
      if ((double)anim.charged < 0.9D && model.rightHandCharge && model.rightHandAmmo && anim.charged != -1.0F) {
         RenderArms.renderArmPump(model, anim, smoothing, model.rightArmRot, model.rightArmPos);
      } else if ((double)anim.pumped < 0.9D && model.rightHandBolt && model.rightHandAmmo) {
         RenderArms.renderArmBolt(model, anim, smoothing, model.rightArmChargeRot, model.rightArmChargePos);
      } else if (!anim.reloading) {
         RenderArms.renderArmDefault(model, anim, smoothing, model.rightArmRot, model.rightArmPos);
      } else {
         RenderArms.renderArmReload(model, anim, smoothing, model.rightArmRot, model.rightArmPos);
      }

      GL11.glScalef(model.rightArmScale.x, model.rightArmScale.y, model.rightArmScale.z);
      modelBipedMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, player);
      modelBipedMain.field_78112_f.field_82908_p = 0.0F;
      if (model.rightHandAmmo) {
         modelBipedMain.field_78112_f.func_78785_a(0.0625F);
      }

      GL11.glPopMatrix();
      GL11.glPushMatrix();
      if ((double)anim.charged < 0.9D && model.leftHandCharge && model.leftHandAmmo && anim.charged != -1.0F) {
         RenderArms.renderArmCharge(model, anim, smoothing, model.leftArmChargeRot, model.leftArmChargePos);
      } else if (!anim.reloading && model.lefthandPump) {
         RenderArms.renderArmPump(model, anim, smoothing, model.leftArmRot, model.leftArmPos);
      } else if (!anim.reloading) {
         RenderArms.renderArmDefault(model, anim, smoothing, model.leftArmRot, model.leftArmPos);
      } else if ((double)effectiveReloadAnimationProgress < 0.5D && model.stagedleftArmReloadPos.x != 0.0F) {
         RenderArms.renderArmReload(model, anim, smoothing, model.leftArmReloadRot, model.leftArmReloadPos);
      } else if ((double)effectiveReloadAnimationProgress > 0.5D && model.stagedleftArmReloadPos.x != 0.0F) {
         RenderArms.renderArmReload(model, anim, smoothing, model.stagedleftArmReloadRot, model.stagedleftArmReloadPos);
      } else {
         RenderArms.renderArmReload(model, anim, smoothing, model.leftArmReloadRot, model.leftArmReloadPos);
      }

      GL11.glScalef(model.leftArmScale.x, model.leftArmScale.y, model.leftArmScale.z);
      modelBipedMain.field_78113_g.field_82908_p = 0.0F;
      if (model.leftHandAmmo) {
         modelBipedMain.field_78113_g.func_78785_a(0.0625F);
      }

      GL11.glPopMatrix();
      GL11.glPopMatrix();
   }

   private float getEndLoadedDistance(AttachmentType grip, GunType gun, ItemStack gunStack) {
      return grip != null && gun.getSecondaryFire(gunStack) ? grip.model.endLoadedAmmoDistance : gun.model.endLoadedAmmoDistance;
   }

   private float getNumBulletsInReload(AttachmentType grip, GunType gun, ItemStack gunStack) {
      return grip != null && gun.getSecondaryFire(gunStack) ? grip.model.numBulletsInReloadAnimation : gun.model.numBulletsInReloadAnimation;
   }

   private float getRecoilDistance(AttachmentType grip, GunType gun, ItemStack gunStack) {
      return grip != null && gun.getSecondaryFire(gunStack) ? grip.model.recoilDistance : gun.model.RecoilSlideDistance;
   }

   private float getRecoilAngle(AttachmentType grip, GunType gun, ItemStack gunStack) {
      return grip != null && gun.getSecondaryFire(gunStack) ? grip.model.recoilAngle : gun.model.RotateSlideDistance;
   }
}
