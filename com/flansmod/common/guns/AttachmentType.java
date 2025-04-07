package com.flansmod.common.guns;

import com.flansmod.client.model.ModelAttachment;
import com.flansmod.common.FlansMod;
import com.flansmod.common.paintjob.PaintableType;
import com.flansmod.common.types.TypeFile;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class AttachmentType extends PaintableType implements IScope {
   public static ArrayList<AttachmentType> attachments = new ArrayList();
   public EnumAttachmentType type;
   public boolean silencer;
   public boolean flashlight;
   public float flashlightRange;
   public int flashlightStrength;
   public boolean disableMuzzleFlash;
   public float spreadMultiplier;
   public float recoilMultiplier;
   public float damageMultiplier;
   public float meleeDamageMultiplier;
   public float bulletSpeedMultiplier;
   public float reloadTimeMultiplier;
   public float moveSpeedMultiplier;
   public EnumFireMode modeOverride;
   public boolean secondaryFire;
   public List<String> secondaryAmmo;
   public float secondaryDamage;
   public float secondarySpread;
   public float secondarySpeed;
   public int secondaryReloadTime;
   public int secondaryShootDelay;
   public String secondaryShootSound;
   public String secondaryReloadSound;
   public EnumFireMode secondaryFireMode;
   public String toggleSound;
   public int secondaryNumBullets;
   public int numSecAmmoItems;
   public float zoomLevel;
   public float FOVZoomLevel;
   public String zoomOverlay;
   public boolean hasScopeOverlay;
   public boolean hasNightVision;
   @SideOnly(Side.CLIENT)
   public ModelAttachment model;
   public float modelScale;
   public int maxStackSize;
   public float secondaryDefaultSpread;

   public AttachmentType(TypeFile file) {
      super(file);
      this.type = EnumAttachmentType.generic;
      this.silencer = false;
      this.flashlight = false;
      this.flashlightRange = 10.0F;
      this.flashlightStrength = 12;
      this.disableMuzzleFlash = false;
      this.spreadMultiplier = 1.0F;
      this.recoilMultiplier = 1.0F;
      this.damageMultiplier = 1.0F;
      this.meleeDamageMultiplier = 1.0F;
      this.bulletSpeedMultiplier = 1.0F;
      this.reloadTimeMultiplier = 1.0F;
      this.moveSpeedMultiplier = 1.0F;
      this.modeOverride = null;
      this.secondaryFire = false;
      this.secondaryAmmo = new ArrayList();
      this.secondaryDamage = 1.0F;
      this.secondarySpread = 1.0F;
      this.secondarySpeed = 5.0F;
      this.secondaryReloadTime = 1;
      this.secondaryShootDelay = 1;
      this.secondaryFireMode = EnumFireMode.SEMIAUTO;
      this.secondaryNumBullets = 1;
      this.numSecAmmoItems = 1;
      this.zoomLevel = 1.0F;
      this.FOVZoomLevel = 1.0F;
      this.hasScopeOverlay = false;
      this.hasNightVision = false;
      this.modelScale = 1.0F;
      this.maxStackSize = 1;
      this.secondaryDefaultSpread = 0.0F;
      attachments.add(this);
   }

   protected void read(String[] split, TypeFile file) {
      super.read(split, file);

      try {
         if (split[0].equals("AttachmentType")) {
            this.type = EnumAttachmentType.get(split[1]);
         } else if (FMLCommonHandler.instance().getSide().isClient() && split[0].equals("Model")) {
            this.model = (ModelAttachment)FlansMod.proxy.loadModel(split[1], this.shortName, ModelAttachment.class);
         } else if (split[0].equals("ModelScale")) {
            this.modelScale = Float.parseFloat(split[1]);
         } else if (split[0].equals("Texture")) {
            this.texture = split[1];
         } else if (split[0].equals("Silencer")) {
            this.silencer = Boolean.parseBoolean(split[1].toLowerCase());
         } else if (!split[0].equals("DisableMuzzleFlash") && !split[0].equals("DisableFlash")) {
            if (split[0].equals("Flashlight")) {
               this.flashlight = Boolean.parseBoolean(split[1].toLowerCase());
            } else if (split[0].equals("FlashlightRange")) {
               this.flashlightRange = Float.parseFloat(split[1]);
            } else if (split[0].equals("FlashlightStrength")) {
               this.flashlightStrength = Integer.parseInt(split[1]);
            } else if (split[0].equals("ModeOverride")) {
               this.modeOverride = EnumFireMode.getFireMode(split[1]);
            } else if (split[0].equals("SecondaryMode")) {
               this.secondaryFire = Boolean.parseBoolean(split[1].toLowerCase());
            } else if (split[0].equals("SecondaryAmmo")) {
               this.secondaryAmmo.add(split[1]);
            } else if (split[0].equals("SecondaryDamage")) {
               this.secondaryDamage = Float.parseFloat(split[1]);
            } else if (!split[0].equals("SecondarySpread") && !split[0].equals("SecondaryAccuracy")) {
               if (split[0].equals("SecondaryBulletSpeed")) {
                  this.secondarySpeed = Float.parseFloat(split[1]);
               } else if (split[0].equals("SecondaryShootDelay")) {
                  this.secondaryShootDelay = Integer.parseInt(split[1]);
               } else if (split[0].equals("SecondaryReloadTime")) {
                  this.secondaryReloadTime = Integer.parseInt(split[1]);
               } else if (split[0].equals("SecondaryShootDelay")) {
                  this.secondaryShootDelay = Integer.parseInt(split[1]);
               } else if (split[0].equals("SecondaryNumBullets")) {
                  this.secondaryNumBullets = Integer.parseInt(split[1]);
               } else if (split[0].equals("LoadSecondaryIntoGun")) {
                  this.numSecAmmoItems = Integer.parseInt(split[1]);
               } else if (split[0].equals("SecondaryFireMode")) {
                  this.secondaryFireMode = EnumFireMode.getFireMode(split[1]);
               } else if (split[0].equals("SecondaryShootSound")) {
                  this.secondaryShootSound = split[1];
                  FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
               } else if (split[0].equals("SecondaryReloadSound")) {
                  this.secondaryReloadSound = split[1];
                  FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
               } else if (split[0].equals("ModeSwitchSound")) {
                  this.toggleSound = split[1];
                  FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
               } else if (split[0].equals("MeleeDamageMultiplier")) {
                  this.meleeDamageMultiplier = Float.parseFloat(split[1]);
               } else if (split[0].equals("DamageMultiplier")) {
                  this.damageMultiplier = Float.parseFloat(split[1]);
               } else if (split[0].equals("SpreadMultiplier")) {
                  this.spreadMultiplier = Float.parseFloat(split[1]);
               } else if (split[0].equals("RecoilMultiplier")) {
                  this.recoilMultiplier = Float.parseFloat(split[1]);
               } else if (split[0].equals("BulletSpeedMultiplier")) {
                  this.bulletSpeedMultiplier = Float.parseFloat(split[1]);
               } else if (split[0].equals("ReloadTimeMultiplier")) {
                  this.reloadTimeMultiplier = Float.parseFloat(split[1]);
               } else if (split[0].equals("MovementSpeedMultiplier")) {
                  this.moveSpeedMultiplier = Float.parseFloat(split[1]);
               } else if (split[0].equals("ZoomLevel")) {
                  this.zoomLevel = Float.parseFloat(split[1]);
               } else if (split[0].equals("FOVZoomLevel")) {
                  this.FOVZoomLevel = Float.parseFloat(split[1]);
               } else if (split[0].equals("ZoomOverlay")) {
                  this.hasScopeOverlay = true;
                  if (split[1].equals("None")) {
                     this.hasScopeOverlay = false;
                  } else {
                     this.zoomOverlay = split[1];
                  }
               } else if (split[0].equals("HasNightVision")) {
                  this.hasNightVision = Boolean.parseBoolean(split[1].toLowerCase());
               }
            } else {
               this.secondarySpread = this.secondaryDefaultSpread = Float.parseFloat(split[1]);
            }
         } else {
            this.disableMuzzleFlash = Boolean.parseBoolean(split[1].toLowerCase());
         }
      } catch (Exception var4) {
         System.out.println("Reading attachment file failed.");
         if (FlansMod.printStackTrace) {
            var4.printStackTrace();
         }
      }

   }

   public void reloadModel() {
      this.model = (ModelAttachment)FlansMod.proxy.loadModel(this.modelString, this.shortName, ModelAttachment.class);
   }

   public static AttachmentType getFromNBT(NBTTagCompound tags) {
      ItemStack stack = ItemStack.func_77949_a(tags);
      return stack != null && stack.func_77973_b() instanceof ItemAttachment ? ((ItemAttachment)stack.func_77973_b()).type : null;
   }

   public float getZoomFactor() {
      return this.zoomLevel;
   }

   public boolean hasZoomOverlay() {
      return this.hasScopeOverlay;
   }

   public String getZoomOverlay() {
      return this.zoomOverlay;
   }

   public float getFOVFactor() {
      return this.FOVZoomLevel;
   }

   public static AttachmentType getAttachment(String s) {
      Iterator var1 = attachments.iterator();

      AttachmentType attachment;
      do {
         if (!var1.hasNext()) {
            return null;
         }

         attachment = (AttachmentType)var1.next();
      } while(!attachment.shortName.equals(s));

      return attachment;
   }

   public float GetRecommendedScale() {
      return 100.0F;
   }

   @SideOnly(Side.CLIENT)
   public ModelBase GetModel() {
      return this.model;
   }
}
