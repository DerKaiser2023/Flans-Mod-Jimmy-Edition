package com.flansmod.client.model;

import com.flansmod.client.FlansModResourceHandler;
import com.flansmod.common.guns.EntityGrenade;
import com.flansmod.common.guns.GrenadeType;
import com.flansmod.common.guns.ItemGrenade;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import org.lwjgl.opengl.GL11;

public class RenderGrenade extends Render implements IItemRenderer {
   public RenderGrenade() {
      this.field_76989_e = 0.1F;
   }

   public void render(EntityGrenade grenade, double d, double d1, double d2, float f, float f1) {
      this.func_110777_b(grenade);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)d, (float)d1, (float)d2);
      if (grenade.stuck) {
         GL11.glRotatef(180.0F - grenade.axes.getYaw(), 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(grenade.axes.getPitch(), 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(grenade.axes.getRoll(), 1.0F, 0.0F, 0.0F);
      } else {
         float dYaw;
         for(dYaw = grenade.axes.getYaw() - grenade.field_70126_B; dYaw > 180.0F; dYaw -= 360.0F) {
         }

         while(dYaw <= -180.0F) {
            dYaw += 360.0F;
         }

         float dPitch;
         for(dPitch = grenade.axes.getPitch() - grenade.field_70127_C; dPitch > 180.0F; dPitch -= 360.0F) {
         }

         while(dPitch <= -180.0F) {
            dPitch += 360.0F;
         }

         float dRoll;
         for(dRoll = grenade.axes.getRoll() - grenade.prevRotationRoll; dRoll > 180.0F; dRoll -= 360.0F) {
         }

         while(dRoll <= -180.0F) {
            dRoll += 360.0F;
         }

         GL11.glRotatef(180.0F - grenade.field_70126_B - dYaw * f1, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(grenade.field_70127_C + dPitch * f1, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(grenade.prevRotationRoll + dRoll * f1, 1.0F, 0.0F, 0.0F);
      }

      ModelBase model = grenade.type.model;
      if (model != null) {
         model.func_78088_a(grenade, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
      }

      GL11.glPopMatrix();
   }

   public void func_76986_a(Entity entity, double d, double d1, double d2, float f, float f1) {
      this.render((EntityGrenade)entity, d, d1, d2, f, f1);
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      ResourceLocation texture = FlansModResourceHandler.getTexture(((EntityGrenade)entity).type);
      return texture == null ? FlansModResourceHandler.getIcon(((EntityGrenade)entity).type) : texture;
   }

   public boolean handleRenderType(ItemStack item, ItemRenderType type) {
      switch(type) {
      case EQUIPPED:
      case EQUIPPED_FIRST_PERSON:
         return item != null && item.func_77973_b() instanceof ItemGrenade && ((ItemGrenade)item.func_77973_b()).type.model != null;
      default:
         return false;
      }
   }

   public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
      return false;
   }

   public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
      GL11.glPushMatrix();
      if (item != null && item.func_77973_b() instanceof ItemGrenade) {
         GrenadeType grenadeType = ((ItemGrenade)item.func_77973_b()).type;
         if (grenadeType.model != null) {
            switch(type) {
            case EQUIPPED:
               GL11.glRotatef(35.0F, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(-5.0F, 0.0F, 1.0F, 0.0F);
               GL11.glTranslatef(0.75F, -0.22F, -0.08F);
               GL11.glTranslatef(0.0F, 0.25F, 0.0F);
               break;
            case EQUIPPED_FIRST_PERSON:
               GL11.glRotatef(25.0F, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(-5.0F, 0.0F, 1.0F, 0.0F);
               GL11.glTranslatef(0.15F, 0.2F, -0.6F);
               GL11.glTranslatef(0.0F, 0.25F, 0.0F);
            }

            Minecraft.func_71410_x().field_71446_o.func_110577_a(FlansModResourceHandler.getTexture(grenadeType));
            ModelBase model = grenadeType.model;
            model.func_78088_a((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
         }
      }

      GL11.glPopMatrix();
   }
}
