package com.flansmod.common.guns;

import com.flansmod.client.model.ModelAAGun;
import com.flansmod.common.FlansMod;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.types.TypeFile;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.ItemStack;

public class AAGunType extends InfoType {
   public List<BulletType> ammo = new ArrayList();
   public int reloadTime;
   public int recoil = 5;
   public int accuracy;
   public int damage;
   public int shootDelay;
   public int numBarrels;
   public boolean fireAlternately;
   public int health;
   public int gunnerX;
   public int gunnerY;
   public int gunnerZ;
   public String shootSound;
   public String reloadSound;
   public ModelAAGun model;
   public float topViewLimit = 75.0F;
   public float bottomViewLimit = 0.0F;
   public int[] barrelX;
   public int[] barrelY;
   public int[] barrelZ;
   public boolean targetMobs = false;
   public boolean targetPlayers = false;
   public boolean targetVehicles = false;
   public boolean targetPlanes = false;
   public boolean targetMechas = false;
   public float targetRange = 10.0F;
   public boolean shareAmmo = false;
   public boolean canShootHomingMissile = false;
   public int countExplodeAfterShoot = -1;
   public boolean isDropThis = true;
   public static List<AAGunType> infoTypes = new ArrayList();

   public AAGunType(TypeFile file) {
      super(file);
      infoTypes.add(this);
   }

   protected void preRead(TypeFile file) {
   }

   protected void postRead(TypeFile file) {
   }

   protected void read(String[] split, TypeFile file) {
      super.read(split, file);

      try {
         if (FMLCommonHandler.instance().getSide().isClient() && split[0].equals("Model")) {
            this.model = (ModelAAGun)FlansMod.proxy.loadModel(split[1], this.shortName, ModelAAGun.class);
         }

         if (split[0].equals("Texture")) {
            this.texture = split[1];
         }

         if (split[0].equals("Damage")) {
            this.damage = Integer.parseInt(split[1]);
         }

         if (split[0].equals("ReloadTime")) {
            this.reloadTime = Integer.parseInt(split[1]);
         }

         if (split[0].equals("Recoil")) {
            this.recoil = Integer.parseInt(split[1]);
         }

         if (split[0].equals("Accuracy")) {
            this.accuracy = Integer.parseInt(split[1]);
         }

         if (split[0].equals("ShootDelay")) {
            this.shootDelay = Integer.parseInt(split[1]);
         }

         if (split[0].equals("ShootSound")) {
            this.shootSound = split[1];
            FlansMod.proxy.loadSound(this.contentPack, "aaguns", split[1]);
         }

         if (split[0].equals("ReloadSound")) {
            this.reloadSound = split[1];
            FlansMod.proxy.loadSound(this.contentPack, "aaguns", split[1]);
         }

         if (split[0].equals("FireAlternately")) {
            this.fireAlternately = split[1].equals("True");
         }

         if (split[0].equals("NumBarrels")) {
            this.numBarrels = Integer.parseInt(split[1]);
            this.barrelX = new int[this.numBarrels];
            this.barrelY = new int[this.numBarrels];
            this.barrelZ = new int[this.numBarrels];
         }

         if (split[0].equals("Barrel")) {
            int id = Integer.parseInt(split[1]);
            this.barrelX[id] = Integer.parseInt(split[2]);
            this.barrelY[id] = Integer.parseInt(split[3]);
            this.barrelZ[id] = Integer.parseInt(split[4]);
         }

         if (split[0].equals("Health")) {
            this.health = Integer.parseInt(split[1]);
         }

         if (split[0].equals("TopViewLimit")) {
            this.topViewLimit = Float.parseFloat(split[1]);
         }

         if (split[0].equals("BottomViewLimit")) {
            this.bottomViewLimit = Float.parseFloat(split[1]);
         }

         if (split[0].equals("Ammo")) {
            BulletType type = BulletType.getBullet(split[1]);
            if (type != null) {
               this.ammo.add(type);
            }
         }

         if (split[0].equals("GunnerPos")) {
            this.gunnerX = Integer.parseInt(split[1]);
            this.gunnerY = Integer.parseInt(split[2]);
            this.gunnerZ = Integer.parseInt(split[3]);
         }

         if (split[0].equals("TargetMobs")) {
            this.targetMobs = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("TargetPlayers")) {
            this.targetPlayers = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("TargetVehicles")) {
            this.targetVehicles = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("TargetPlanes")) {
            this.targetPlanes = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("TargetMechas")) {
            this.targetMechas = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("TargetDriveables")) {
            this.targetMechas = this.targetPlanes = this.targetVehicles = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("ShareAmmo")) {
            this.shareAmmo = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("TargetRange")) {
            this.targetRange = Float.parseFloat(split[1]);
         }

         if (split[0].equals("CanShootHomingMissile")) {
            this.canShootHomingMissile = Boolean.parseBoolean(split[1]);
         }

         if (split[0].equals("CountExplodeAfterShoot")) {
            this.countExplodeAfterShoot = Integer.parseInt(split[1]);
         }

         if (split[0].equals("IsDropThis")) {
            this.isDropThis = Boolean.parseBoolean(split[1]);
         }
      } catch (Exception var4) {
         FlansMod.log("" + var4);
      }

   }

   public boolean isAmmo(BulletType type) {
      return this.ammo.contains(type);
   }

   public boolean isAmmo(ItemStack stack) {
      if (stack == null) {
         return false;
      } else {
         return stack.func_77973_b() instanceof ItemBullet && this.isAmmo(((ItemBullet)stack.func_77973_b()).type);
      }
   }

   public static AAGunType getAAGun(String s) {
      Iterator var1 = infoTypes.iterator();

      AAGunType gun;
      do {
         if (!var1.hasNext()) {
            return null;
         }

         gun = (AAGunType)var1.next();
      } while(!gun.shortName.equals(s));

      return gun;
   }

   public void reloadModel() {
      this.model = (ModelAAGun)FlansMod.proxy.loadModel(this.modelString, this.shortName, ModelAAGun.class);
   }

   public float GetRecommendedScale() {
      return 50.0F;
   }

   @SideOnly(Side.CLIENT)
   public ModelBase GetModel() {
      return this.model;
   }
}
