package com.flansmod.common.driveables;

import cofh.api.energy.IEnergyContainerItem;
import com.flansmod.api.IControllable;
import com.flansmod.api.IExplodeable;
import com.flansmod.client.EntityCamera;
import com.flansmod.client.FlansModClient;
import com.flansmod.client.debug.EntityDebugVector;
import com.flansmod.common.FlansMod;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.driveables.collisions.CollisionPlane;
import com.flansmod.common.driveables.collisions.CollisionShapeBox;
import com.flansmod.common.driveables.collisions.CollisionTest;
import com.flansmod.common.driveables.mechas.EntityMecha;
import com.flansmod.common.guns.EntityBullet;
import com.flansmod.common.guns.EntityDamageSourceGun;
import com.flansmod.common.guns.EntityShootable;
import com.flansmod.common.guns.EnumFireMode;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.InventoryHelper;
import com.flansmod.common.guns.ItemBullet;
import com.flansmod.common.guns.ItemShootable;
import com.flansmod.common.guns.ShootableType;
import com.flansmod.common.guns.raytracing.BulletHit;
import com.flansmod.common.guns.raytracing.DriveableHit;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketDriveableDamage;
import com.flansmod.common.network.PacketDriveableKeyHeld;
import com.flansmod.common.network.PacketParticle;
import com.flansmod.common.network.PacketPlaySound;
import com.flansmod.common.parts.ItemPart;
import com.flansmod.common.parts.PartType;
import com.flansmod.common.teams.Gametype;
import com.flansmod.common.teams.Team;
import com.flansmod.common.teams.TeamsManager;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public abstract class EntityDriveable extends Entity implements IControllable, IExplodeable, IEntityAdditionalSpawnData {
   public boolean syncFromServer;
   public boolean crushed;
   public int crushTimer;
   public boolean aiming;
   public int serverPositionTransitionTicker;
   public double field_70118_ct;
   public double field_70117_cu;
   public double field_70116_cv;
   public double serverYaw;
   public double serverPitch;
   public double serverRoll;
   public DriveableData driveableData;
   public String driveableType;
   public float throttle;
   public float oxygenMeter;
   public float divingFactor;
   public EntityWheel[] wheels;
   public boolean fuelling;
   public float prevRotationRoll;
   public Vector3f angularVelocity;
   public boolean leftMouseHeld;
   public boolean rightMouseHeld;
   private boolean suicide;
   public int shootDelayPrimary;
   public int shootDelaySecondary;
   public float minigunSpeedPrimary;
   public float minigunSpeedSecondary;
   public int currentGunPrimary;
   public int currentGunSecondary;
   public float harvesterAngle;
   public RotatedAxes prevAxes;
   public RotatedAxes axes;
   public EntitySeat[] seats;
   private int foundFuel;
   public boolean couldNotFindFuel;
   public boolean isAmmoPlaced;
   public int lockOnSoundDelay;
   private int[] emitterTimers;
   public int animCountLeft;
   public int animFrameLeft;
   public int animCountRight;
   public int animFrameRight;
   public boolean leftTurnHeld;
   public boolean rightTurnHeld;
   public boolean isShowedPosition;
   public int tickCount;
   public int impactX;
   public int impactY;
   public int impactZ;
   public boolean locked;
   public boolean neverLocked;
   public String key;
   private String lastKey;
   public boolean isRecoil;
   public float recoilPos;
   public float lastRecoilPos;
   public int recoilTimer;
   public Vector3f lastPos;
   public boolean hugeBoat;
   public boolean onDeck;
   public double deckHeight;
   public int deckCheck;
   public int prevDeckCheck;
   public boolean isMecha;
   public boolean disabled;
   public float propAngle;
   public float prevPropAngle;
   public float rotorAngle;
   public float prevRotorAngle;
   public int flareDelay;
   public int ticksFlareUsing;
   public boolean varFlare;
   public float drakonDoorAngle;
   public float drakonArmAngle;
   public float drakonRailAngle;
   public float prevDrakonDoorAngle;
   public float prevDrakonArmAngle;
   public float prevDrakonRailAngle;
   public boolean reloadingDrakon;
   public boolean canFireIT1;
   public int stage;
   public int reloadAnimTime;
   public boolean toDeactivate;
   public int timeTillDeactivate;
   public boolean canFire;
   @SideOnly(Side.CLIENT)
   public EntityLivingBase camera;
   protected int invulnerableUnmountCount;
   private ItemStack[][] prevInventoryItems;
   public Entity lastAtkEntity;
   DriveableType type;

   public EntityDriveable(World world) {
      super(world);
      this.syncFromServer = true;
      this.crushed = false;
      this.crushTimer = 40;
      this.aiming = false;
      this.divingFactor = 0.0F;
      this.angularVelocity = new Vector3f(0.0F, 0.0F, 0.0F);
      this.leftMouseHeld = false;
      this.rightMouseHeld = false;
      this.suicide = false;
      this.foundFuel = -1;
      this.couldNotFindFuel = false;
      this.isAmmoPlaced = false;
      this.animCountLeft = 0;
      this.animFrameLeft = 0;
      this.animCountRight = 0;
      this.animFrameRight = 0;
      this.leftTurnHeld = false;
      this.rightTurnHeld = false;
      this.isShowedPosition = false;
      this.tickCount = 0;
      this.neverLocked = true;
      this.key = "ChangeMe";
      this.isRecoil = false;
      this.recoilPos = 0.0F;
      this.lastRecoilPos = 0.0F;
      this.recoilTimer = 0;
      this.lastPos = new Vector3f(0.0F, 0.0F, 0.0F);
      this.hugeBoat = false;
      this.onDeck = false;
      this.deckHeight = 0.0D;
      this.deckCheck = 0;
      this.prevDeckCheck = 0;
      this.isMecha = false;
      this.disabled = false;
      this.propAngle = 0.0F;
      this.prevPropAngle = 0.0F;
      this.rotorAngle = 0.0F;
      this.prevRotorAngle = 0.0F;
      this.flareDelay = 0;
      this.ticksFlareUsing = 0;
      this.drakonDoorAngle = 0.0F;
      this.drakonArmAngle = 0.0F;
      this.drakonRailAngle = 0.0F;
      this.prevDrakonDoorAngle = 0.0F;
      this.prevDrakonArmAngle = 0.0F;
      this.prevDrakonRailAngle = 0.0F;
      this.reloadingDrakon = false;
      this.canFireIT1 = true;
      this.stage = 1;
      this.reloadAnimTime = 0;
      this.toDeactivate = false;
      this.timeTillDeactivate = 0;
      this.canFire = true;
      this.prevInventoryItems = new ItemStack[][]{null, null};
      this.lastAtkEntity = null;
      this.type = this.getDriveableType();
      this.axes = new RotatedAxes();
      this.prevAxes = new RotatedAxes();
      this.field_70156_m = true;
      this.func_70105_a(1.0F, 1.0F);
      this.field_70129_M = 0.375F;
      this.field_70158_ak = true;
      this.field_70155_l = 200.0D;
      this.locked = false;
   }

   public EntityDriveable(World world, DriveableType t, DriveableData d) {
      this(world);
      this.driveableType = t.shortName;
      this.driveableData = d;
   }

   protected void initType(DriveableType type, boolean clientSide) {
      this.seats = new EntitySeat[type.numPassengers + 1];

      int ps;
      for(ps = 0; ps < type.numPassengers + 1; ++ps) {
         if (!clientSide) {
            this.seats[ps] = new EntitySeat(this.field_70170_p, this, ps);
            this.field_70170_p.func_72838_d(this.seats[ps]);
         }
      }

      this.wheels = new EntityWheel[type.wheelPositions.length];

      for(ps = 0; ps < this.wheels.length; ++ps) {
         if (!clientSide) {
            this.wheels[ps] = new EntityWheel(this.field_70170_p, this, ps);
            this.field_70170_p.func_72838_d(this.wheels[ps]);
         }
      }

      this.field_70138_W = type.wheelStepHeight;
      this.field_70129_M = type.yOffset;
      this.emitterTimers = new int[type.emitters.size()];

      for(ps = 0; ps < type.emitters.size(); ++ps) {
         this.emitterTimers[ps] = this.field_70146_Z.nextInt(((DriveableType.ParticleEmitter)type.emitters.get(ps)).emitRate);
      }

      this.getEntityData().func_74757_a("CanMountEntity", type.canMountEntity);

      for(ps = 0; ps < 2; ++ps) {
         EnumWeaponType weaponType = ps == 0 ? type.primary : type.secondary;
         if (weaponType == EnumWeaponType.GUN) {
            weaponType = EnumWeaponType.NONE;
         }

         int istart = this.getInventoryStart(weaponType);
         if (istart == this.driveableData.getAmmoInventoryStart()) {
            istart += type.numPassengerGunners;
         }

         int isize = this.getInventorySize(weaponType);
         if (istart >= 0 || isize > 0) {
            this.prevInventoryItems[ps] = new ItemStack[isize];

            for(int i = 0; i < isize; ++i) {
               this.prevInventoryItems[ps][i] = this.driveableData.func_70301_a(istart + i);
            }
         }
      }

   }

   protected void func_70014_b(NBTTagCompound tag) {
      this.driveableData.writeToNBT(tag);
      tag.func_74778_a("Type", this.driveableType);
      tag.func_74776_a("RotationYaw", this.axes.getYaw());
      tag.func_74776_a("RotationPitch", this.axes.getPitch());
      tag.func_74776_a("RotationRoll", this.axes.getRoll());
      if (this.key != null) {
         tag.func_74778_a("key", this.key);
      }

      tag.func_74757_a("locked", this.locked);
   }

   protected void func_70037_a(NBTTagCompound tag) {
      this.driveableType = tag.func_74779_i("Type");
      this.driveableData = new DriveableData(tag);
      this.initType(DriveableType.getDriveable(this.driveableType), false);
      this.field_70126_B = tag.func_74760_g("RotationYaw");
      this.field_70127_C = tag.func_74760_g("RotationPitch");
      this.prevRotationRoll = tag.func_74760_g("RotationRoll");
      this.locked = tag.func_74767_n("locked");
      this.key = tag.func_74779_i("key");
      this.axes = new RotatedAxes(this.field_70126_B, this.field_70127_C, this.prevRotationRoll);
   }

   public void writeSpawnData(ByteBuf data) {
      ByteBufUtils.writeUTF8String(data, this.driveableType);
      NBTTagCompound tag = new NBTTagCompound();
      this.driveableData.writeToNBT(tag);
      ByteBufUtils.writeTag(data, tag);
      data.writeFloat(this.axes.getYaw());
      data.writeFloat(this.axes.getPitch());
      data.writeFloat(this.axes.getRoll());
      EnumDriveablePart[] var3 = EnumDriveablePart.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         EnumDriveablePart ep = var3[var5];
         DriveablePart part = (DriveablePart)this.getDriveableData().parts.get(ep);
         data.writeShort((short)part.health);
         data.writeBoolean(part.onFire);
      }

      if (this.key != null) {
         ByteBufUtils.writeUTF8String(data, this.key);
      }

   }

   public void readSpawnData(ByteBuf data) {
      try {
         this.driveableType = ByteBufUtils.readUTF8String(data);
         this.driveableData = new DriveableData(ByteBufUtils.readTag(data));
         this.initType(this.getDriveableType(), true);
         this.axes.setAngles(data.readFloat(), data.readFloat(), data.readFloat());
         this.field_70126_B = this.axes.getYaw();
         this.field_70127_C = this.axes.getPitch();
         this.prevRotationRoll = this.axes.getRoll();
         EnumDriveablePart[] var2 = EnumDriveablePart.values();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            EnumDriveablePart ep = var2[var4];
            DriveablePart part = (DriveablePart)this.getDriveableData().parts.get(ep);
            part.health = data.readShort();
            part.onFire = data.readBoolean();
         }

         this.key = ByteBufUtils.readUTF8String(data);
      } catch (Exception var7) {
         FlansMod.log("Failed to retreive plane type from server.");
         super.func_70106_y();
         var7.printStackTrace();
      }

      this.camera = new EntityCamera(this.field_70170_p, this);
      this.field_70170_p.func_72838_d(this.camera);
   }

   public abstract void onMouseMoved(int var1, int var2);

   @SideOnly(Side.CLIENT)
   public EntityLivingBase getCamera() {
      return this.camera;
   }

   protected boolean canSit(int seat) {
      return this.getDriveableType().numPassengers >= seat && this.seats[seat].field_70153_n == null;
   }

   protected boolean func_70041_e_() {
      return false;
   }

   protected void func_70088_a() {
   }

   public AxisAlignedBB func_70114_g(Entity entity) {
      if (this.getDriveableType().collisionDamageEnable && this.throttle > this.getDriveableType().collisionDamageThrottle) {
         if (entity instanceof EntityLiving) {
            entity.func_70097_a(DamageSource.field_76377_j, this.throttle * this.getDriveableType().collisionDamageTimes);
         } else if (entity instanceof EntityPlayer) {
            entity.func_70097_a(DamageSource.field_76377_j, this.throttle * this.getDriveableType().collisionDamageTimes);
         }
      }

      return this.field_70121_D;
   }

   public AxisAlignedBB func_70046_E() {
      return this.field_70121_D;
   }

   public boolean func_70104_M() {
      return false;
   }

   public double func_70042_X() {
      return -0.3D;
   }

   public boolean func_70097_a(DamageSource damagesource, float i) {
      if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
         if (this.isMountedEntity(damagesource.func_76346_g())) {
            return false;
         } else {
            this.attackPart(EnumDriveablePart.core, damagesource, i);
            if (i > 0.0F) {
               this.checkPartsWhenAttacked();
               FlansMod.getPacketHandler().sendToAllAround(new PacketDriveableDamage(this), this.field_70165_t, this.field_70163_u, this.field_70161_v, 100.0F, this.field_71093_bK);
            }

            return true;
         }
      } else {
         return true;
      }
   }

   public boolean isMountedEntity(Entity entity) {
      if (entity != null) {
         Entity entity2 = this.field_70170_p.func_73045_a(entity.func_145782_y());
         EntitySeat[] var3 = this.seats;
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            Entity seat = var3[var5];
            if (seat.field_70153_n != null && (seat.field_70153_n == entity || seat.field_70153_n == entity2)) {
               return true;
            }
         }
      }

      return false;
   }

   public void func_70106_y() {
      super.func_70106_y();
      if (this.field_70170_p.field_72995_K) {
         this.camera.func_70106_y();
      }

      EntitySeat[] var1 = this.seats;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         EntitySeat seat = var1[var3];
         if (seat != null) {
            seat.func_70106_y();
         }
      }

   }

   public void func_70100_b_(EntityPlayer par1EntityPlayer) {
   }

   public boolean func_70067_L() {
      return true;
   }

   public void func_70108_f(Entity entity) {
   }

   public void func_70056_a(double d, double d1, double d2, float f, float f1, int i) {
      if (this.field_70173_aa <= 1) {
         if (!(this.field_70153_n instanceof EntityPlayer) || !FlansMod.proxy.isThePlayer((EntityPlayer)this.field_70153_n)) {
            if (this.syncFromServer) {
               this.serverPositionTransitionTicker = i + 5;
            } else {
               double var10 = d - this.field_70165_t;
               double var12 = d1 - this.field_70163_u;
               double var14 = d2 - this.field_70161_v;
               double var16 = var10 * var10 + var12 * var12 + var14 * var14;
               if (var16 <= 1.0D) {
                  return;
               }

               this.serverPositionTransitionTicker = 3;
            }

            this.field_70118_ct = d;
            this.field_70117_cu = d1;
            this.field_70116_cv = d2;
            this.serverYaw = (double)f;
            this.serverPitch = (double)f1;
         }

      }
   }

   public void setIT1(boolean canFire, boolean reloading, int stag, int stageTime) {
      if (this.field_70170_p.field_72995_K && this.field_70173_aa % 5 == 0) {
         this.canFireIT1 = canFire;
         this.reloadingDrakon = reloading;
         this.stage = stag;
         this.reloadAnimTime = stageTime;
      }

   }

   public void setPositionRotationAndMotion(double x, double y, double z, float yaw, float pitch, float roll, double motX, double motY, double motZ, float velYaw, float velPitch, float velRoll, float throt, float steeringYaw) {
      if (this.field_70170_p.field_72995_K) {
         this.field_70118_ct = x;
         this.field_70117_cu = y;
         this.field_70116_cv = z;
         this.serverYaw = (double)yaw;
         this.serverPitch = (double)pitch;
         this.serverRoll = (double)roll;
         this.serverPositionTransitionTicker = 5;
      } else {
         this.func_70107_b(x, y, z);
         this.field_70126_B = yaw;
         this.field_70127_C = pitch;
         this.prevRotationRoll = roll;
         this.setRotation(yaw, pitch, roll);
      }

      this.field_70159_w = motX;
      this.field_70181_x = motY;
      this.field_70179_y = motZ;
      this.angularVelocity = new Vector3f(velYaw, velPitch, velRoll);
      this.throttle = throt;
   }

   public void func_70016_h(double d, double d1, double d2) {
      this.field_70159_w = d;
      this.field_70181_x = d1;
      this.field_70179_y = d2;
   }

   public boolean pressKey(int key, EntityPlayer player) {
      if (!this.field_70170_p.field_72995_K && key == 9 && this.getDriveableType().modePrimary == EnumFireMode.SEMIAUTO) {
         this.shoot(false);
         return true;
      } else if (!this.field_70170_p.field_72995_K && key == 8 && this.getDriveableType().modeSecondary == EnumFireMode.SEMIAUTO) {
         this.shoot(true);
         return true;
      } else {
         return false;
      }
   }

   public void updateKeyHeldState(int key, boolean held) {
      if (this.field_70170_p.field_72995_K) {
         FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketDriveableKeyHeld(key, held)));
         if (key == 2) {
            this.leftTurnHeld = true;
            this.rightTurnHeld = false;
         } else if (key == 3) {
            this.rightTurnHeld = true;
            this.leftTurnHeld = false;
         } else {
            this.leftTurnHeld = false;
            this.rightTurnHeld = false;
         }
      }

      switch(key) {
      case 8:
         this.rightMouseHeld = held;
         this.suicide = true;
         break;
      case 9:
         this.leftMouseHeld = held;
      }

   }

   public void shoot(boolean secondary) {
      DriveableType type = this.getDriveableType();
      if (this.seats[0] != null) {
         if (!type.IT1 || this.canFireIT1 || type.weaponType(secondary) != EnumWeaponType.MISSILE) {
            if (this.canFire) {
               if (this.getShootDelay(secondary) <= 0) {
                  ArrayList<ShootPoint> shootPoints = type.shootPoints(secondary);
                  EnumWeaponType weaponType = type.weaponType(secondary);
                  if (shootPoints.size() == 0) {
                     return;
                  }

                  int currentGun = this.getCurrentGun(secondary);
                  if (type.alternate(secondary)) {
                     currentGun = (currentGun + 1) % shootPoints.size();
                     this.setCurrentGun(currentGun, secondary);
                     this.shootEach(type, (ShootPoint)shootPoints.get(currentGun), currentGun, secondary, weaponType);
                  } else {
                     for(int i = 0; i < shootPoints.size(); ++i) {
                        this.shootEach(type, (ShootPoint)shootPoints.get(i), i, secondary, weaponType);
                     }
                  }
               }

            }
         }
      }
   }

   private boolean driverIsCreative() {
      return this.seats != null && this.seats[0] != null && this.seats[0].field_70153_n instanceof EntityPlayer && ((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d;
   }

   public void spawnParticle(ArrayList<DriveableType.ShootParticle> list, ShootPoint shootPoint, Vector3f v) {
      float bkz;
      for(Iterator var4 = list.iterator(); var4.hasNext(); shootPoint.rootPos.position.z = bkz) {
         DriveableType.ShootParticle s = (DriveableType.ShootParticle)var4.next();
         float bkx = shootPoint.rootPos.position.x;
         float bky = shootPoint.rootPos.position.y;
         bkz = shootPoint.rootPos.position.z;
         Vector3f velocity = new Vector3f(s.x, s.y, s.z);
         Vector3f vv = this.lastPos;
         velocity = this.getDirection(shootPoint, velocity);
         if (shootPoint.rootPos.part == EnumDriveablePart.core) {
            Vector3f v2 = this.axes.findLocalVectorGlobally(shootPoint.rootPos.position);
            Vector3f v3 = this.rotate(this.seats[0].looking.findLocalVectorGlobally(shootPoint.offPos));
            Vector3f.add(v2, v3, v);
         }

         FlansMod.getPacketHandler().sendToAllAround(new PacketParticle(s.name, this.field_70165_t + (double)v.x, this.field_70163_u + (double)v.y, this.field_70161_v + (double)v.z, (double)velocity.x, (double)velocity.y, (double)velocity.z), this.field_70165_t + (double)v.x, this.field_70163_u + (double)v.y, this.field_70161_v + (double)v.z, 150.0F, this.field_71093_bK);
         shootPoint.rootPos.position.x = bkx;
         shootPoint.rootPos.position.y = bky;
      }

   }

   public void shootEach(DriveableType type, ShootPoint shootPoint, int currentGun, boolean secondary, EnumWeaponType weaponType) {
      Vector3f gunVec = this.getFiringPosition(shootPoint);
      Vector3f lookVector = this.getLookVector(shootPoint);
      if (!secondary && type.fixedPrimaryFire) {
         lookVector = this.axes.findLocalVectorGlobally(type.primaryFireAngle);
         if (shootPoint.rootPos.part == EnumDriveablePart.turret) {
            lookVector = this.getPositionOnTurret(type.primaryFireAngle, false);
         }

         if (shootPoint.rootPos.part == EnumDriveablePart.barrel) {
            lookVector = this.getPositionOnTurret(type.primaryFireAngle, true);
         }
      }

      if (secondary && type.fixedSecondaryFire) {
         lookVector = this.axes.findLocalVectorGlobally(type.secondaryFireAngle);
         if (shootPoint.rootPos.part == EnumDriveablePart.turret) {
            lookVector = this.getPositionOnTurret(type.secondaryFireAngle, false);
         }

         if (shootPoint.rootPos.part == EnumDriveablePart.barrel) {
            lookVector = this.getPositionOnTurret(type.secondaryFireAngle, true);
         }
      }

      if (weaponType == EnumWeaponType.SHELL) {
         this.isRecoil = true;
      }

      if (shootPoint.rootPos.part != null) {
         if (this.isPartIntact(shootPoint.rootPos.part)) {
            if (!this.disabled) {
               float spread;
               if (shootPoint.rootPos instanceof PilotGun) {
                  PilotGun pilotGun = (PilotGun)shootPoint.rootPos;
                  GunType gunType = pilotGun.type;
                  spread = gunType.bulletSpeed;
                  if (type.rangingGun) {
                     spread = type.bulletSpeed;
                  }

                  ItemStack bulletItemStack = this.driveableData.ammo[this.getDriveableType().numPassengerGunners + currentGun];
                  if (gunType != null && bulletItemStack != null && bulletItemStack.func_77973_b() instanceof ItemShootable && TeamsManager.bulletsEnabled) {
                     ShootableType bullet = ((ItemShootable)bulletItemStack.func_77973_b()).type;
                     if (gunType.isAmmo(bullet)) {
                        this.spawnParticle(type.shootParticle(secondary), shootPoint, gunVec);
                        this.field_70170_p.func_72838_d(((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(new Vector3f(this.field_70165_t, this.field_70163_u, this.field_70161_v), gunVec, (Vector3f)null), lookVector, (EntityLivingBase)this.seats[0].field_70153_n, gunType.bulletSpread / 2.0F, gunType.damage, spread, bulletItemStack.func_77960_j(), type));
                        PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, type.shootSound(secondary), false);
                        int damage = bulletItemStack.func_77960_j();
                        bulletItemStack.func_77964_b(damage + 1);
                        if (damage + 1 == bulletItemStack.func_77958_k()) {
                           bulletItemStack.func_77964_b(0);
                           if (!this.driverIsCreative()) {
                              --bulletItemStack.field_77994_a;
                              if (bulletItemStack.field_77994_a <= 0) {
                                 this.onWeaponInventoryChanged(secondary);
                                 bulletItemStack = null;
                              }

                              this.driveableData.func_70299_a(this.getDriveableType().numPassengerGunners + currentGun, bulletItemStack);
                           }
                        }

                        this.setShootDelay(type.shootDelay(secondary), secondary);
                     }
                  }
               } else {
                  EntityShootable bulletEntity;
                  int slot;
                  int i;
                  ItemStack shell;
                  float shellSpeed;
                  ItemStack bulletStack;
                  ItemBullet bulletItem;
                  switch(weaponType) {
                  case BOMB:
                     if (TeamsManager.bombsEnabled) {
                        slot = -1;

                        for(i = this.driveableData.getBombInventoryStart(); i < this.driveableData.getBombInventoryStart() + type.numBombSlots; ++i) {
                           shell = this.driveableData.func_70301_a(i);
                           if (shell != null && shell.func_77973_b() instanceof ItemBullet && type.isValidAmmo(((ItemBullet)shell.func_77973_b()).type, weaponType)) {
                              slot = i;
                           }
                        }

                        if (slot != -1) {
                           int spread = false;
                           int damageMultiplier = 1;
                           shellSpeed = 0.0F;
                           bulletStack = this.driveableData.func_70301_a(slot);
                           bulletItem = (ItemBullet)bulletStack.func_77973_b();
                           if (shootPoint.rootPos instanceof PilotGun) {
                              PilotGun pilotGun = (PilotGun)shootPoint.rootPos;
                              GunType var15 = pilotGun.type;
                           }

                           bulletEntity = bulletItem.getEntity(this.field_70170_p, Vec3.func_72443_a((double)gunVec.x + this.field_70165_t, (double)gunVec.y + this.field_70163_u, (double)gunVec.z + this.field_70161_v), this.axes.getYaw(), this.axes.getPitch(), this.field_70159_w, this.field_70181_x, this.field_70179_y, (EntityLivingBase)this.seats[0].field_70153_n, (float)damageMultiplier, this.driveableData.func_70301_a(slot).func_77960_j(), type);
                           this.field_70170_p.func_72838_d(bulletEntity);
                           this.spawnParticle(type.shootParticle(secondary), shootPoint, gunVec);
                           if (type.shootSound(secondary) != null) {
                              PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, type.shootSound(secondary), false);
                           }

                           if (!this.driverIsCreative()) {
                              bulletStack.func_77964_b(bulletStack.func_77960_j() + 1);
                              if (bulletStack.func_77960_j() == bulletStack.func_77958_k()) {
                                 bulletStack.func_77964_b(0);
                                 --bulletStack.field_77994_a;
                                 if (bulletStack.field_77994_a == 0) {
                                    this.onWeaponInventoryChanged(secondary);
                                    bulletStack = null;
                                 }
                              }

                              this.driveableData.func_70299_a(slot, bulletStack);
                           }

                           this.setShootDelay(type.shootDelay(secondary), secondary);
                        }
                     }
                     break;
                  case MISSILE:
                  case SHELL:
                     this.tryRecoil();
                     if (TeamsManager.shellsEnabled) {
                        slot = -1;

                        for(i = this.driveableData.getMissileInventoryStart(); i < this.driveableData.getMissileInventoryStart() + type.numMissileSlots; ++i) {
                           shell = this.driveableData.func_70301_a(i);
                           if (shell != null && shell.func_77973_b() instanceof ItemBullet && type.isValidAmmo(((ItemBullet)shell.func_77973_b()).type, weaponType)) {
                              slot = i;
                           }
                        }

                        if (slot != -1) {
                           int damageMultiplier = 1;
                           spread = type.bulletSpread;
                           shellSpeed = type.bulletSpeed;
                           bulletStack = this.driveableData.func_70301_a(slot);
                           bulletItem = (ItemBullet)bulletStack.func_77973_b();
                           bulletEntity = bulletItem.getEntity(this.field_70170_p, Vector3f.add(gunVec, new Vector3f(this.field_70165_t, this.field_70163_u, this.field_70161_v), (Vector3f)null), lookVector, (EntityLivingBase)this.seats[0].field_70153_n, spread, (float)damageMultiplier, shellSpeed, this.driveableData.func_70301_a(slot).func_77960_j(), type);
                           this.field_70170_p.func_72838_d(bulletEntity);
                           this.spawnParticle(type.shootParticle(secondary), shootPoint, gunVec);
                           this.isRecoil = true;
                           if (type.shootSound(secondary) != null) {
                              PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, type.shootSound(secondary), false);
                           }

                           if (!this.driverIsCreative()) {
                              bulletStack.func_77964_b(bulletStack.func_77960_j() + 1);
                              if (bulletStack.func_77960_j() == bulletStack.func_77958_k()) {
                                 bulletStack.func_77964_b(0);
                                 --bulletStack.field_77994_a;
                                 if (bulletStack.field_77994_a == 0) {
                                    this.onWeaponInventoryChanged(secondary);
                                    bulletStack = null;
                                 }
                              }

                              this.driveableData.func_70299_a(slot, bulletStack);
                           }

                           this.setShootDelay(type.shootDelay(secondary), secondary);
                           this.canFireIT1 = false;
                        }
                     }
                  case GUN:
                  case MINE:
                  case NONE:
                  }
               }

            }
         }
      }
   }

   public Vector3f getOrigin(ShootPoint dp) {
      Vector3f localGunVec = new Vector3f(dp.rootPos.position);
      if (dp.rootPos.part == EnumDriveablePart.turret) {
         Vector3f.sub(localGunVec, this.getDriveableType().turretOrigin, localGunVec);
         localGunVec = this.seats[0].looking.findLocalVectorGlobally(localGunVec);
         Vector3f.add(localGunVec, this.getDriveableType().turretOrigin, localGunVec);
      }

      return this.rotate(localGunVec);
   }

   public Vector3f getPositionOnTurret(Vector3f vecIn, boolean barrel) {
      RotatedAxes yawOnlyLooking = new RotatedAxes(this.seats[0].looking.getYaw(), 0.0F, 0.0F);
      if (barrel) {
         yawOnlyLooking = this.seats[0].looking;
      }

      Vector3f.sub(vecIn, this.getDriveableType().turretOrigin, vecIn);
      Vector3f transform = yawOnlyLooking.findLocalVectorGlobally(vecIn);
      Vector3f.add(transform, this.getDriveableType().turretOrigin, transform);
      Vector3f turretOriginOffset = new Vector3f(this.getDriveableType().turretOriginOffset);
      turretOriginOffset = yawOnlyLooking.findLocalVectorGloballyYaw(turretOriginOffset);
      Vector3f.add(transform, turretOriginOffset, transform);
      return this.rotate(transform);
   }

   public Vector3f getDirection(ShootPoint dp, Vector3f vIn) {
      Vector3f localGunVec = new Vector3f(vIn);
      localGunVec = this.seats[0].looking.findLocalVectorGlobally(localGunVec);
      return this.rotate(localGunVec);
   }

   public Vector3f getLookVector(ShootPoint dp) {
      return this.axes.getXAxis();
   }

   public Vector3f getFiringPosition(ShootPoint dp) {
      Vector3f rootVector = new Vector3f(dp.rootPos.position);
      Vector3f offsetVector = new Vector3f(dp.offPos);
      Vector3f localGunVec = new Vector3f(dp.rootPos.position);
      if (dp.rootPos.part == EnumDriveablePart.turret) {
         if (offsetVector.x == 0.0F && offsetVector.y == 0.0F && offsetVector.z == 0.0F) {
            Vector3f.sub(localGunVec, this.getDriveableType().turretOrigin, localGunVec);
            localGunVec = this.seats[0].looking.findLocalVectorGlobally(localGunVec);
            Vector3f.add(localGunVec, this.getDriveableType().turretOrigin, localGunVec);
         } else {
            RotatedAxes yawOnlyLooking = new RotatedAxes(this.seats[0].looking.getYaw(), 0.0F, 0.0F);
            Vector3f.sub(rootVector, this.getDriveableType().turretOrigin, rootVector);
            rootVector = yawOnlyLooking.findLocalVectorGlobally(rootVector);
            Vector3f.add(rootVector, this.getDriveableType().turretOrigin, rootVector);
            Vector3f.sub(offsetVector, this.getDriveableType().turretOrigin, offsetVector);
            offsetVector = this.seats[0].looking.findLocalVectorGlobally(offsetVector);
            Vector3f.add(rootVector, offsetVector, localGunVec);
         }
      }

      return this.rotate(localGunVec);
   }

   public void correctWheelPos() {
      if (this.field_70173_aa % 200 == 0) {
         EntityWheel[] var1 = this.wheels;
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            EntityWheel wheel = var1[var3];
            if (wheel != null) {
               Vector3f target = this.axes.findLocalVectorGlobally(this.getDriveableType().wheelPositions[wheel.ID].position);
               target.x = (float)((double)target.x + this.field_70165_t);
               target.y = (float)((double)target.y + this.field_70163_u);
               target.z = (float)((double)target.z + this.field_70161_v);
               int tf = 1;
               int cf = 1;
               int range = 5;
               if (MathHelper.func_76135_e(target.x - (float)wheel.field_70165_t) > (float)range) {
                  wheel.field_70165_t = (double)((target.x * (float)tf + (float)wheel.field_70165_t * (float)cf) / (float)(tf + cf));
               }

               if (MathHelper.func_76135_e(target.y - (float)wheel.field_70163_u) > (float)range) {
                  wheel.field_70163_u = (double)((target.y * (float)tf + (float)wheel.field_70163_u * (float)cf) / (float)(tf + cf));
               }

               if (MathHelper.func_76135_e(target.z - (float)wheel.field_70161_v) > (float)range) {
                  wheel.field_70161_v = (double)((target.z * (float)tf + (float)wheel.field_70161_v * (float)cf) / (float)(tf + cf));
               }
            }
         }
      }

   }

   public void func_70071_h_() {
      super.func_70071_h_();
      DriveableType type = this.getDriveableType();
      DriveableData data = this.getDriveableData();
      this.hugeBoat = this.getDriveableType().floatOnWater && this.getDriveableType().wheelStepHeight == 0.0F || this.getDriveableType().solid;
      int i;
      if (this.hugeBoat) {
         for(i = 0; i < this.field_70170_p.field_72996_f.size(); ++i) {
            Object obj = this.field_70170_p.field_72996_f.get(i);
            if (obj instanceof EntityPlayer && !this.isPartOfThis((Entity)obj)) {
               this.moveRiders((Entity)obj);
            }

            if (obj instanceof EntityWheel && !this.isPartOfThis((Entity)obj) && this.func_70032_d((Entity)obj) <= this.getDriveableType().bulletDetectionRadius) {
            }

            if (obj instanceof EntityDriveable && !this.isPartOfThis((Entity)obj) && this.func_70032_d((Entity)obj) <= this.getDriveableType().bulletDetectionRadius) {
            }
         }
      }

      if (this.deckCheck != this.prevDeckCheck) {
         this.onDeck = true;
      } else {
         this.onDeck = false;
      }

      boolean canThrust;
      if (type.IT1 && !this.disabled) {
         canThrust = false;
         if (type.weaponType(false) == EnumWeaponType.MISSILE) {
            canThrust = this.leftMouseHeld;
         }

         if (type.weaponType(true) == EnumWeaponType.MISSILE) {
            canThrust = this.rightMouseHeld;
         }

         this.prevDrakonDoorAngle = this.drakonDoorAngle;
         this.prevDrakonArmAngle = this.drakonArmAngle;
         this.prevDrakonRailAngle = this.drakonRailAngle;
         if (this.canFireIT1) {
            this.reloadingDrakon = false;
         }

         if (this.stage == 0) {
            this.stage = 1;
         }

         if (this.stage == 8 && canThrust) {
            this.stage = 1;
            this.timeTillDeactivate = 5;
            this.toDeactivate = true;
         }

         if (this.timeTillDeactivate <= 0 && this.toDeactivate) {
            this.canFireIT1 = false;
            this.toDeactivate = false;
         }

         if (this.reloadAnimTime <= 0) {
            this.IT1Reload();
         }

         --this.reloadAnimTime;
         --this.timeTillDeactivate;
      }

      this.prevPropAngle = this.propAngle;
      this.prevRotorAngle = this.rotorAngle;
      if (this.throttle != 0.0F) {
         this.propAngle = (float)((double)this.propAngle + Math.pow((double)this.throttle, 0.4D) * 1.5D);
         this.rotorAngle += this.throttle / 7.0F;
      }

      if (this.leftMouseHeld && !this.disabled) {
         this.tryRecoil();
         this.setRecoilTimer();
      }

      this.lastRecoilPos = this.recoilPos;
      if (this.recoilPos > 180.0F - 180.0F / type.recoilTime) {
         this.recoilPos = 0.0F;
         this.isRecoil = false;
      }

      if (this.isRecoil) {
         this.recoilPos += 180.0F / type.recoilTime;
      }

      if (this.recoilTimer >= 0) {
         --this.recoilTimer;
      }

      this.checkInventoryChanged();
      if (this.field_70170_p.func_72953_d(this.field_70121_D) && !this.hugeBoat) {
         if (this.throttle >= type.maxThrottleInWater) {
            this.throttle = type.maxThrottleInWater;
         }

         if (this.throttle <= -type.maxThrottleInWater) {
            this.throttle = -type.maxThrottleInWater;
         }

         if (this.field_70170_p.func_72953_d(this.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)type.maxDepth, 0.0D))) {
            this.throttle = 0.0F;
            this.disabled = true;
         }
      } else {
         this.disabled = false;
      }

      Vector3f pos;
      Vector3f pos;
      if ((type.lockOnToLivings || type.lockOnToMechas || type.lockOnToPlanes || type.lockOnToPlayers || type.lockOnToVehicles) && !this.field_70170_p.field_72995_K && this.seats.length > 0 && this.lockOnSoundDelay <= 0 && this.seats[0] != null && this.seats[0].field_70153_n instanceof EntityPlayer) {
         i = this.getCurrentGun(false);
         pos = this.getOrigin((ShootPoint)type.shootPoints(false).get(i));
         Iterator var5 = this.field_70170_p.field_72996_f.iterator();

         label569:
         while(true) {
            Entity entity;
            do {
               if (!var5.hasNext()) {
                  break label569;
               }

               Object obj = var5.next();
               entity = (Entity)obj;
            } while((!type.lockOnToMechas || !(entity instanceof EntityMecha)) && (!type.lockOnToVehicles || !(entity instanceof EntityVehicle)) && (!type.lockOnToPlanes || !(entity instanceof EntityPlane)) && (!type.lockOnToPlayers || !(entity instanceof EntityPlayer)) && (!type.lockOnToLivings || !(entity instanceof EntityLivingBase)));

            double dXYZ = (double)this.func_70032_d(entity);
            if (this.func_70068_e(entity) < (double)(type.maxRangeLockOn * type.maxRangeLockOn)) {
               pos = new Vector3f(entity.field_70165_t - this.field_70165_t, entity.field_70163_u - this.field_70163_u, entity.field_70161_v - this.field_70161_v);
               float angle = Math.abs(Vector3f.angle(pos, pos));
               if ((double)angle < Math.toRadians((double)type.canLockOnAngle)) {
                  PacketPlaySound.sendSoundPacket(this.seats[0].field_70165_t, this.seats[0].field_70163_u, this.seats[0].field_70161_v, 10.0D, this.field_71093_bK, type.lockOnSound, false);
                  if (entity instanceof EntityDriveable) {
                     PacketPlaySound.sendSoundPacket(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, (double)((EntityDriveable)entity).getDriveableType().lockedOnSoundRange, entity.field_71093_bK, ((EntityDriveable)entity).getDriveableType().lockingOnSound, false);
                  }

                  this.lockOnSoundDelay = type.lockOnSoundTime;
                  break;
               }
            }
         }
      }

      if (this.lockOnSoundDelay > 0) {
         --this.lockOnSoundDelay;
      }

      if (this.field_70154_o != null) {
         this.invulnerableUnmountCount = 80;
      } else if (this.invulnerableUnmountCount > 0) {
         --this.invulnerableUnmountCount;
      }

      if (!this.field_70170_p.field_72995_K) {
         for(i = 0; i < this.getDriveableType().numPassengers + 1; ++i) {
            if (this.seats[i] == null || !this.seats[i].field_70175_ag) {
               this.seats[i] = new EntitySeat(this.field_70170_p, this, i);
               this.field_70170_p.func_72838_d(this.seats[i]);
            }
         }

         for(i = 0; i < type.wheelPositions.length; ++i) {
            if (this.wheels[i] == null || !this.wheels[i].field_70175_ag) {
               this.wheels[i] = new EntityWheel(this.field_70170_p, this, i);
               this.field_70170_p.func_72838_d(this.wheels[i]);
            }
         }
      }

      if (this.hasEnoughFuel()) {
         this.harvesterAngle += this.throttle / 5.0F;
      }

      int damage;
      if (type.harvestBlocks && type.harvestBoxSize != null && type.harvestBoxPos != null && TeamsManager.driveablesBreakBlocks) {
         Vector3f size = new Vector3f(type.harvestBoxSize.x / 16.0F, type.harvestBoxSize.y / 16.0F, type.harvestBoxSize.z / 16.0F);
         pos = new Vector3f(type.harvestBoxPos.x / 16.0F, type.harvestBoxPos.y / 16.0F, type.harvestBoxPos.z / 16.0F);

         for(float x = pos.x; x <= pos.x + size.x; ++x) {
            for(float y = pos.y; y <= pos.y + size.y; ++y) {
               for(float z = pos.z; z <= pos.z + size.z; ++z) {
                  Vector3f v = this.axes.findLocalVectorGlobally(new Vector3f(x, y, z));
                  damage = (int)Math.round(this.field_70165_t + (double)v.x);
                  int blockY = (int)Math.round(this.field_70163_u + (double)v.y);
                  int blockZ = (int)Math.round(this.field_70161_v + (double)v.z);
                  Block block = this.field_70170_p.func_147439_a(damage, blockY, blockZ);
                  if (type.materialsHarvested.contains(block.func_149688_o()) && block.func_149712_f(this.field_70170_p, damage, blockY, blockZ) >= 0.0F) {
                     ArrayList stacks;
                     int i;
                     ItemStack stack;
                     if (type.collectHarvest) {
                        stacks = block.getDrops(this.field_70170_p, damage, blockY, blockZ, this.field_70170_p.func_72805_g(damage, blockY, blockZ), 0);

                        for(i = 0; i < stacks.size(); ++i) {
                           stack = (ItemStack)stacks.get(i);
                           FlansMod.log("");
                           if (!InventoryHelper.addItemStackToInventory(this.driveableData, stack, this.driverIsCreative()) && !this.field_70170_p.field_72995_K && this.field_70170_p.func_82736_K().func_82766_b("doTileDrops")) {
                              this.field_70170_p.func_72838_d(new EntityItem(this.field_70170_p, (double)((float)damage + 0.5F), (double)((float)blockY + 0.5F), (double)((float)blockZ + 0.5F), stack));
                           }
                        }
                     } else if (type.dropHarvest) {
                        stacks = block.getDrops(this.field_70170_p, damage, blockY, blockZ, this.field_70170_p.func_72805_g(damage, blockY, blockZ), 0);

                        for(i = 0; i < stacks.size(); ++i) {
                           stack = (ItemStack)stacks.get(i);
                           this.field_70170_p.func_72838_d(new EntityItem(this.field_70170_p, (double)((float)damage + 0.5F), (double)((float)blockY + 0.5F), (double)((float)blockZ + 0.5F), stack));
                        }
                     }

                     this.field_70170_p.func_147480_a(damage, blockY, blockZ, false);
                  }
               }
            }
         }
      }

      Iterator var25 = this.getDriveableData().parts.values().iterator();

      while(var25.hasNext()) {
         DriveablePart part = (DriveablePart)var25.next();
         if (part.box != null) {
            part.update(this);
            Vector3f pos;
            if (this.field_70170_p.field_72995_K) {
               if (part.onFire) {
                  pos = this.axes.findLocalVectorGlobally(new Vector3f(part.box.x + this.field_70146_Z.nextFloat() * part.box.w, part.box.y + this.field_70146_Z.nextFloat() * part.box.h, part.box.z + this.field_70146_Z.nextFloat() * part.box.d));
                  this.field_70170_p.func_72869_a("flame", this.field_70165_t + (double)pos.x, this.field_70163_u + (double)pos.y, this.field_70161_v + (double)pos.z, 0.0D, 0.0D, 0.0D);
               }

               if (part.health > 0 && part.health < part.maxHealth / 2) {
                  pos = this.axes.findLocalVectorGlobally(new Vector3f(part.box.x + this.field_70146_Z.nextFloat() * part.box.w, part.box.y + this.field_70146_Z.nextFloat() * part.box.h, part.box.z + this.field_70146_Z.nextFloat() * part.box.d));
                  this.field_70170_p.func_72869_a(part.health < part.maxHealth / 4 ? "largesmoke" : "smoke", this.field_70165_t + (double)pos.x, this.field_70163_u + (double)pos.y, this.field_70161_v + (double)pos.z, 0.0D, 0.0D, 0.0D);
               }
            }

            if (part.onFire) {
               if (this.field_70170_p.func_72896_J() && this.field_70146_Z.nextInt(40) == 0) {
                  part.onFire = false;
               }

               pos = this.axes.findLocalVectorGlobally(new Vector3f(part.box.x + part.box.w / 2.0F, part.box.y + part.box.h / 2.0F, part.box.z + part.box.d / 2.0F));
               if (this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t + (double)pos.x), MathHelper.func_76128_c(this.field_70163_u + (double)pos.y), MathHelper.func_76128_c(this.field_70161_v + (double)pos.z)).func_149688_o() == Material.field_151586_h) {
                  part.onFire = false;
               }
            } else {
               pos = this.axes.findLocalVectorGlobally(new Vector3f(part.box.x / 16.0F + part.box.w / 32.0F, part.box.y / 16.0F + part.box.h / 32.0F, part.box.z / 16.0F + part.box.d / 32.0F));
               if (this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t + (double)pos.x), MathHelper.func_76128_c(this.field_70163_u + (double)pos.y), MathHelper.func_76128_c(this.field_70161_v + (double)pos.z)).func_149688_o() == Material.field_151587_i) {
                  part.onFire = true;
               }
            }
         }
      }

      for(i = 0; i < type.emitters.size(); ++i) {
         DriveableType.ParticleEmitter emitter = (DriveableType.ParticleEmitter)type.emitters.get(i);
         int var10002 = this.emitterTimers[i]--;
         boolean canEmit = false;
         boolean inThrottle = false;
         DriveablePart part = (DriveablePart)this.getDriveableData().parts.get(EnumDriveablePart.getPart(emitter.part));
         float healthPercentage = (float)part.health / (float)part.maxHealth;
         if (this.isPartIntact(EnumDriveablePart.getPart(emitter.part)) && healthPercentage >= emitter.minHealth && healthPercentage <= emitter.maxHealth) {
            canEmit = true;
         } else {
            canEmit = false;
         }

         if (this.throttle >= emitter.minThrottle && this.throttle <= emitter.maxThrottle) {
            inThrottle = true;
         }

         if (this.isMecha) {
            inThrottle = true;
         }

         if (this.emitterTimers[i] <= 0) {
            if (inThrottle && canEmit) {
               Vector3f velocity = new Vector3f(0.0F, 0.0F, 0.0F);
               pos = new Vector3f(0.0F, 0.0F, 0.0F);
               if (this.seats != null && this.seats[0] != null) {
                  Vector3f localPosition2;
                  if (EnumDriveablePart.getPart(emitter.part) != EnumDriveablePart.turret && EnumDriveablePart.getPart(emitter.part) != EnumDriveablePart.barrel) {
                     localPosition2 = new Vector3f(emitter.origin.x + this.field_70146_Z.nextFloat() * emitter.extents.x - emitter.extents.x * 0.5F, emitter.origin.y + this.field_70146_Z.nextFloat() * emitter.extents.y - emitter.extents.y * 0.5F, emitter.origin.z + this.field_70146_Z.nextFloat() * emitter.extents.z - emitter.extents.z * 0.5F);
                     pos = this.axes.findLocalVectorGlobally(localPosition2);
                     velocity = this.axes.findLocalVectorGlobally(emitter.velocity);
                  } else if (EnumDriveablePart.getPart(emitter.part) != EnumDriveablePart.turret && (EnumDriveablePart.getPart(emitter.part) != EnumDriveablePart.head || emitter.part == "barrel")) {
                     if (EnumDriveablePart.getPart(emitter.part) == EnumDriveablePart.barrel) {
                        localPosition2 = new Vector3f(emitter.origin.x + this.field_70146_Z.nextFloat() * emitter.extents.x - emitter.extents.x * 0.5F, emitter.origin.y + this.field_70146_Z.nextFloat() * emitter.extents.y - emitter.extents.y * 0.5F, emitter.origin.z + this.field_70146_Z.nextFloat() * emitter.extents.z - emitter.extents.z * 0.5F);
                        pos = this.getPositionOnTurret(localPosition2, true);
                        velocity = this.getPositionOnTurret(emitter.velocity, true);
                     }
                  } else {
                     localPosition2 = new Vector3f(emitter.origin.x + this.field_70146_Z.nextFloat() * emitter.extents.x - emitter.extents.x * 0.5F, emitter.origin.y + this.field_70146_Z.nextFloat() * emitter.extents.y - emitter.extents.y * 0.5F, emitter.origin.z + this.field_70146_Z.nextFloat() * emitter.extents.z - emitter.extents.z * 0.5F);
                     pos = this.getPositionOnTurret(localPosition2, false);
                     velocity = this.getPositionOnTurret(emitter.velocity, false);
                  }

                  FlansMod.getPacketHandler().sendToAllAround(new PacketParticle(emitter.effectType, this.field_70165_t + (double)pos.x, this.field_70163_u + (double)pos.y, this.field_70161_v + (double)pos.z, (double)velocity.x, (double)velocity.y, (double)velocity.z), this.field_70165_t + (double)pos.x, this.field_70163_u + (double)pos.y, this.field_70161_v + (double)pos.z, 150.0F, this.field_71093_bK);
               }
            }

            this.emitterTimers[i] = emitter.emitRate;
         }
      }

      this.checkParts();
      this.field_70126_B = this.axes.getYaw();
      this.field_70127_C = this.axes.getPitch();
      this.prevRotationRoll = this.axes.getRoll();
      this.prevAxes = this.axes.clone();
      if (this.field_70153_n != null && this.field_70153_n.field_70128_L) {
         this.field_70153_n = null;
      }

      if (this.field_70153_n != null && this.field_70128_L) {
         this.field_70153_n.func_70078_a((Entity)null);
      }

      if (this.field_70153_n != null) {
         this.field_70153_n.field_70143_R = 0.0F;
      }

      canThrust = this.driverIsCreative() || this.driveableData.fuelInTank > 0.0F;
      if (this.seats[0] != null && this.seats[0].field_70153_n == null || !canThrust && this.getDriveableType().maxThrottle != 0.0F && this.getDriveableType().maxNegativeThrottle != 0.0F) {
         this.throttle *= 0.99F;
      }

      if (this.seats[0] != null && this.seats[0].field_70153_n == null) {
         this.rightMouseHeld = this.leftMouseHeld = false;
      }

      if (this.shootDelayPrimary > 0) {
         --this.shootDelayPrimary;
      }

      if (this.shootDelaySecondary > 0) {
         --this.shootDelaySecondary;
      }

      if (data.fakeReloadShell > 0.0F) {
      }

      --data.fakeReloadShell;
      if (data.fakeReloadMissile > 0.0F) {
      }

      --data.fakeReloadMissile;
      if (this.getDriveableType().reloadSoundTick != 15214541 && this.shootDelayPrimary == this.getDriveableType().reloadSoundTick) {
         PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, type.shootReloadSound, false);
      }

      if (this.field_70173_aa == 1) {
         this.setShootDelay(this.getDriveableType().placeTimePrimary, false);
         this.setShootDelay(this.getDriveableType().placeTimeSecondary, true);
         data.fakeReloadShell = (float)this.getDriveableType().placeTimePrimary;
         data.fakeReloadMissile = (float)this.getDriveableType().placeTimeSecondary;
         if (!this.field_70170_p.field_72995_K) {
            if (!this.getDriveableType().placeSoundPrimary.isEmpty()) {
               PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, this.getDriveableType().placeSoundPrimary, false);
            }

            if (!this.getDriveableType().placeSoundSecondary.isEmpty()) {
               PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, this.getDriveableType().placeSoundSecondary, false);
            }
         }
      }

      if (!this.field_70170_p.field_72995_K) {
         if (this.leftMouseHeld && this.getDriveableType().modePrimary == EnumFireMode.FULLAUTO && !this.getDriveableType().needsThrottle) {
            this.shoot(false);
         }

         if (this.leftMouseHeld && this.getDriveableType().modePrimary == EnumFireMode.FULLAUTO && this.getDriveableType().needsThrottle && (double)this.throttle > 0.7D) {
            this.shoot(false);
         }

         if (this.rightMouseHeld && this.getDriveableType().modeSecondary == EnumFireMode.FULLAUTO) {
            this.shoot(true);
         }

         this.minigunSpeedPrimary *= 0.9F;
         this.minigunSpeedSecondary *= 0.9F;
         if (this.leftMouseHeld && this.getDriveableType().modePrimary == EnumFireMode.MINIGUN) {
            this.minigunSpeedPrimary += 0.1F;
            if (this.minigunSpeedPrimary > 1.0F) {
               this.shoot(false);
            }
         }

         if (this.rightMouseHeld && this.getDriveableType().modeSecondary == EnumFireMode.MINIGUN) {
            this.minigunSpeedSecondary += 0.1F;
            if (this.minigunSpeedSecondary > 1.0F) {
               this.shoot(true);
            }
         }
      }

      this.prevDeckCheck = this.deckCheck;
      int fuelMultiplier = 2;
      if (!(data.fuelInTank >= (float)type.fuelTankSize)) {
         for(int i = 0; i < data.func_70302_i_(); ++i) {
            ItemStack stack = data.func_70301_a(i);
            if (stack != null && stack.field_77994_a > 0) {
               Item item = stack.func_77973_b();
               if (data.engine.useRFPower) {
                  if (item instanceof IEnergyContainerItem) {
                     IEnergyContainerItem energy = (IEnergyContainerItem)item;
                     data.fuelInTank += (float)(fuelMultiplier * energy.extractEnergy(stack, data.engine.RFDrawRate, false) / data.engine.RFDrawRate);
                  }
               } else {
                  if (item instanceof ItemPart) {
                     PartType part = ((ItemPart)item).type;
                     if (part.category == 9) {
                        data.fuelInTank += (float)fuelMultiplier;
                        damage = stack.func_77960_j();
                        stack.func_77964_b(damage + 1);
                        if (damage >= stack.func_77958_k()) {
                           stack.func_77964_b(0);
                           --stack.field_77994_a;
                           if (stack.field_77994_a <= 0) {
                              data.func_70299_a(i, (ItemStack)null);
                           }
                        }
                        break;
                     }
                  } else if (FlansMod.hooks.BuildCraftLoaded && stack.func_77969_a(FlansMod.hooks.BuildCraftOilBucket) && data.fuelInTank + (float)(1000 * fuelMultiplier) <= (float)type.fuelTankSize) {
                     data.fuelInTank += (float)(1000 * fuelMultiplier);
                     data.func_70299_a(i, new ItemStack(Items.field_151133_ar));
                  } else if (FlansMod.hooks.BuildCraftLoaded && stack.func_77969_a(FlansMod.hooks.BuildCraftFuelBucket) && data.fuelInTank + (float)(2000 * fuelMultiplier) <= (float)type.fuelTankSize) {
                     data.fuelInTank += (float)(2000 * fuelMultiplier);
                     data.func_70299_a(i, new ItemStack(Items.field_151133_ar));
                  }

                  this.field_70169_q = this.field_70165_t;
                  this.field_70167_r = this.field_70163_u;
                  this.field_70166_s = this.field_70161_v;
               }
            }
         }

      }
   }

   public void checkInventoryChanged() {
      DriveableType type = this.getDriveableType();
      if (type != null) {
         if (!this.field_70170_p.field_72995_K) {
            if (this.driveableData.inventoryChanged) {
               this.driveableData.inventoryChanged = false;

               try {
                  for(int ps = 0; ps < 2; ++ps) {
                     EnumWeaponType weaponType = ps == 0 ? type.primary : type.secondary;
                     if (weaponType == EnumWeaponType.GUN) {
                        weaponType = EnumWeaponType.NONE;
                     }

                     int istart = this.getInventoryStart(weaponType);
                     if (istart == this.driveableData.getAmmoInventoryStart()) {
                        istart += type.numPassengerGunners;
                     }

                     int isize = this.getInventorySize(weaponType);
                     if (istart >= 0 || isize > 0) {
                        if (this.prevInventoryItems[ps] == null) {
                           this.prevInventoryItems[ps] = new ItemStack[isize];
                        }

                        int i;
                        for(i = 0; i < isize; ++i) {
                           ItemStack itemStack = this.driveableData.func_70301_a(istart + i);
                           if (itemStack != null && itemStack.func_77973_b() instanceof ItemBullet && (this.prevInventoryItems[ps][i] == null || !ItemStack.func_77989_b(itemStack, this.prevInventoryItems[ps][i])) && type.isValidAmmo(((ItemBullet)itemStack.func_77973_b()).type, weaponType)) {
                              this.onWeaponInventoryChanged(ps == 1);
                              break;
                           }
                        }

                        for(i = 0; i < isize; ++i) {
                           this.prevInventoryItems[ps][i] = this.driveableData.func_70301_a(istart + i);
                        }
                     }
                  }
               } catch (Exception var8) {
                  var8.printStackTrace();
               }

            }
         }
      }
   }

   public void onWeaponInventoryChanged(boolean secondary) {
      DriveableType type = this.getDriveableType();
      if (!secondary) {
         if (type.reloadTimePrimary > 0 && this.getShootDelay(secondary) <= 0) {
            FlansMod.log("EntityDriveable Reload Primary " + type.reloadTimePrimary + " tick");
            this.setShootDelay(type.reloadTimePrimary, secondary);
            PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, this.getDriveableType().reloadSoundPrimary, false);
         }
      } else if (type.reloadTimeSecondary > 0 && this.getShootDelay(secondary) <= 0) {
         FlansMod.log("EntityDriveable Reload Secondary " + type.reloadTimeSecondary + " tick");
         this.setShootDelay(type.reloadTimeSecondary, secondary);
         PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, this.getDriveableType().reloadSoundSecondary, false);
      }

   }

   public int getInventoryStart(EnumWeaponType wt) {
      switch(wt) {
      case BOMB:
      case MINE:
         return this.driveableData.getBombInventoryStart();
      case MISSILE:
      case SHELL:
         return this.driveableData.getMissileInventoryStart();
      case GUN:
      case NONE:
         return this.driveableData.getAmmoInventoryStart();
      default:
         return -1;
      }
   }

   public int getInventorySize(EnumWeaponType wt) {
      switch(wt) {
      case BOMB:
      case MINE:
         return this.driveableData.bombs.length;
      case MISSILE:
      case SHELL:
         return this.driveableData.missiles.length;
      case GUN:
      case NONE:
         return this.driveableData.ammo.length;
      default:
         return -1;
      }
   }

   public void checkForCollisions() {
      boolean damagePart = false;
      boolean crashInWater = false;
      double speed = this.getSpeedXYZ();
      Iterator var5 = this.getDriveableType().collisionPoints.iterator();

      while(true) {
         while(true) {
            DriveablePosition p;
            Vec3 currentPos;
            MovingObjectPosition hit;
            do {
               do {
                  do {
                     if (!var5.hasNext()) {
                        if (damagePart && !this.field_70170_p.field_72995_K) {
                           FlansMod.getPacketHandler().sendToAllAround(new PacketDriveableDamage(this), this.field_70165_t, this.field_70163_u, this.field_70161_v, 100.0F, this.field_71093_bK);
                        }

                        return;
                     }

                     p = (DriveablePosition)var5.next();
                  } while(((DriveablePart)this.driveableData.parts.get(p.part)).dead);

                  Vector3f lastRelPos = this.prevAxes.findLocalVectorGlobally(p.position);
                  Vec3 lastPos = Vec3.func_72443_a(this.field_70169_q + (double)lastRelPos.x, this.field_70167_r + (double)lastRelPos.y, this.field_70166_s + (double)lastRelPos.z);
                  Vector3f currentRelPos = this.axes.findLocalVectorGlobally(p.position);
                  currentPos = Vec3.func_72443_a(this.field_70165_t + (double)currentRelPos.x, this.field_70163_u + (double)currentRelPos.y, this.field_70161_v + (double)currentRelPos.z);
                  if (FlansMod.DEBUG && this.field_70170_p.field_72995_K) {
                     this.field_70170_p.func_72838_d(new EntityDebugVector(this.field_70170_p, new Vector3f(lastPos), Vector3f.sub(currentRelPos, lastRelPos, (Vector3f)null), 10, 1.0F, 0.0F, 0.0F));
                  }

                  hit = this.field_70170_p.func_72901_a(lastPos, currentPos, crashInWater);
               } while(hit == null);
            } while(hit.field_72313_a != MovingObjectType.BLOCK);

            int x = hit.field_72311_b;
            int y = hit.field_72312_c;
            int z = hit.field_72309_d;
            Block blockHit = this.field_70170_p.func_147439_a(x, y, z);
            int meta = this.field_70170_p.func_72805_g(x, y, z);
            float blockHardness = blockHit.func_149712_f(this.field_70170_p, x, y, z);
            float damage = blockHardness * blockHardness * (float)speed;
            if (null == blockHit.func_149668_a(this.field_70170_p, x, y, z)) {
               damage = 0.0F;
            }

            if (damage > 0.0F) {
               damagePart = true;
            }

            if (!this.attackPart(p.part, DamageSource.field_76368_d, damage) && TeamsManager.driveablesBreakBlocks) {
               this.field_70170_p.func_72889_a((EntityPlayer)null, 2001, x, y, z, Block.func_149682_b(blockHit) + (meta << 12));
               if (!this.field_70170_p.field_72995_K) {
                  blockHit.func_149697_b(this.field_70170_p, x, y, z, meta, 1);
                  this.field_70170_p.func_147468_f(x, y, z);
               }
            } else {
               this.field_70170_p.func_72876_a(this, currentPos.field_72450_a, currentPos.field_72448_b, currentPos.field_72449_c, 1.0F, false);
            }
         }
      }
   }

   protected void func_70069_a(float k) {
      double fallDist = (this.field_70163_u - this.field_70167_r + this.field_70181_x) / 2.0D;
      float damage = (float)(fallDist < -0.3D ? -fallDist * 50.0D : 0.0D);
      boolean no_damage = true;
      if (damage > 0.0F && this.invulnerableUnmountCount == 0 && this.field_70173_aa > 20 && !no_damage) {
         DriveableType type = this.getDriveableType();
         damage = (float)((int)(damage * type.fallDamageFactor));
         this.attackPart(EnumDriveablePart.core, DamageSource.field_76379_h, damage);
         if (type.wheelPositions.length > 0) {
            this.attackPart(type.wheelPositions[0].part, DamageSource.field_76379_h, damage / 5.0F);
         }

         no_damage = false;
      }

   }

   public boolean attackPart(EnumDriveablePart ep, DamageSource source, float damage) {
      if (ep == EnumDriveablePart.core) {
         if (source.func_76364_f() instanceof EntityLivingBase) {
            this.lastAtkEntity = source.func_76364_f();
         } else if (source.func_76346_g() instanceof EntityLivingBase) {
            this.lastAtkEntity = source.func_76346_g();
         } else {
            this.lastAtkEntity = null;
         }
      }

      DriveablePart part = (DriveablePart)this.driveableData.parts.get(ep);
      return part.attack(damage, source.func_76347_k());
   }

   public Vector3f rotate(Vector3f inVec) {
      return this.axes.findLocalVectorGlobally(inVec);
   }

   public Vector3f rotate(Vec3 inVec) {
      return this.rotate(inVec.field_72450_a, inVec.field_72448_b, inVec.field_72449_c);
   }

   public Vector3f rotate(double x, double y, double z) {
      return this.rotate(new Vector3f((float)x, (float)y, (float)z));
   }

   public void rotateYaw(float rotateBy) {
      if (!(Math.abs(rotateBy) < 0.01F)) {
         this.axes.rotateLocalYaw(rotateBy);
         this.updatePrevAngles();
      }
   }

   public void rotatePitch(float rotateBy) {
      if (!(Math.abs(rotateBy) < 0.01F)) {
         this.axes.rotateLocalPitch(rotateBy);
         this.updatePrevAngles();
      }
   }

   public void rotateRoll(float rotateBy) {
      if (!(Math.abs(rotateBy) < 0.01F)) {
         this.axes.rotateLocalRoll(rotateBy);
         this.updatePrevAngles();
      }
   }

   public void updatePrevAngles() {
      double dYaw = (double)(this.axes.getYaw() - this.field_70126_B);
      if (dYaw > 180.0D) {
         this.field_70126_B += 360.0F;
      }

      if (dYaw < -180.0D) {
         this.field_70126_B -= 360.0F;
      }

      double dPitch = (double)(this.axes.getPitch() - this.field_70127_C);
      if (dPitch > 180.0D) {
         this.field_70127_C += 360.0F;
      }

      if (dPitch < -180.0D) {
         this.field_70127_C -= 360.0F;
      }

      double dRoll = (double)(this.axes.getRoll() - this.prevRotationRoll);
      if (dRoll > 180.0D) {
         this.prevRotationRoll += 360.0F;
      }

      if (dRoll < -180.0D) {
         this.prevRotationRoll -= 360.0F;
      }

   }

   public void setRotation(float rotYaw, float rotPitch, float rotRoll) {
      this.axes.setAngles(rotYaw, rotPitch, rotRoll);
   }

   public boolean isPartOfThis(Entity ent) {
      EntitySeat[] var2 = this.seats;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         EntitySeat seat = var2[var4];
         if (seat != null) {
            if (ent == seat) {
               return true;
            }

            if (seat.field_70153_n == ent) {
               return true;
            }
         }
      }

      return ent == this;
   }

   public float func_70053_R() {
      return 0.0F;
   }

   public DriveableType getDriveableType() {
      return DriveableType.getDriveable(this.driveableType);
   }

   public DriveableData getDriveableData() {
      return this.driveableData;
   }

   public boolean isDead() {
      return this.field_70128_L;
   }

   public Entity getControllingEntity() {
      return this.seats[0].getControllingEntity();
   }

   public ItemStack getPickedResult(MovingObjectPosition target) {
      ItemStack stack = new ItemStack(this.getDriveableType().item, 1, 0);
      stack.field_77990_d = new NBTTagCompound();
      this.driveableData.writeToNBT(stack.field_77990_d);
      return stack;
   }

   public boolean hasFuel() {
      if (this.seats != null && this.seats[0] != null && this.seats[0].field_70153_n != null) {
         return this.driverIsCreative() || this.driveableData.fuelInTank > 0.0F;
      } else {
         return false;
      }
   }

   public boolean hasEnoughFuel() {
      return this.driverIsCreative() || this.driveableData.fuelInTank > this.driveableData.engine.fuelConsumption * this.throttle;
   }

   public double getSpeedXYZ() {
      return Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
   }

   public double getSpeedXZ() {
      return Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
   }

   public boolean landVehicle() {
      return false;
   }

   public boolean gearDown() {
      return true;
   }

   public boolean onGround() {
      return this.field_70122_E;
   }

   public void moveRiders(Entity rider) {
      if (!this.isPartOfThis(rider)) {
         boolean isHuman = false;
         boolean isDriveable = false;
         if (rider instanceof EntityPlayer) {
            Vector3f riderPos = new Vector3f(rider.field_70165_t, rider.field_70163_u, rider.field_70161_v);
            Vector3f riderMotion = new Vector3f(rider.field_70159_w, rider.field_70181_x, rider.field_70181_x);
            new Vector3f(this.field_70165_t - (double)this.lastPos.x, this.field_70163_u - (double)this.lastPos.y, this.field_70161_v - (double)this.lastPos.z);
            if (rider instanceof EntityVehicle) {
               Vector3f var6 = ((EntityVehicle)rider).lastPos;
            }

            Vector3f vehiclePos = new Vector3f(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            Vector3f relativePos = Vector3f.sub(riderPos, vehiclePos, (Vector3f)null);
            if (rider instanceof EntityPlayer) {
               isHuman = true;
            }

            if (rider instanceof EntityDriveable) {
               isDriveable = true;
            }

            relativePos = new Vector3f(relativePos.x, relativePos.y - (isHuman ? 0.55F : 0.0F), relativePos.z);
            this.axes.findGlobalVectorLocally(relativePos);
            this.axes.findGlobalVectorLocally(riderMotion);
            Vector3f ellipsoid = new Vector3f(rider.field_70130_N / 2.0F, rider.field_70131_O, rider.field_70130_N / 2.0F);
            CollisionTest test = new CollisionTest(ellipsoid, new Vector3f(relativePos.x, relativePos.y, relativePos.z), riderMotion);
            test.collisionRecursiveDepth = 0;
            Vector3f eSpacePosition = test.ConvertR3ToESpace(test.R3Position);
            Vector3f eSpaceVelocity = test.velocity;
            DriveableType type = this.getDriveableType();
            Iterator var16;
            if (type.fancyCollision) {
               var16 = type.collisionBox.iterator();

               while(var16.hasNext()) {
                  CollisionShapeBox sbox = (CollisionShapeBox)var16.next();
                  this.checkCollision(test, sbox);
               }
            } else {
               var16 = this.getDriveableData().parts.values().iterator();

               while(var16.hasNext()) {
                  DriveablePart ppart = (DriveablePart)var16.next();
                  ppart.rayTraceRider(this, test);
               }
            }

            if (test.didCollide) {
               Vector3f finalPos = this.collideWithDriveable(test, eSpacePosition, eSpaceVelocity);
               if (finalPos == null) {
                  finalPos = new Vector3f(0.0F, 0.0F, 0.0F);
                  if (FlansMod.debugMode) {
                     FlansMod.log("EntityDriveable.java moveRiders> finalPos is null [1]");
                  }
               }

               if (rider instanceof EntityAnimal) {
                  return;
               }

               Vector3f velocity = Vector3f.sub(finalPos, test.basePoint, (Vector3f)null);
               test.ConvertESpaceToR3(velocity);
               finalPos = new Vector3f(finalPos.x * test.eRad.x, finalPos.y * test.eRad.y, finalPos.z * test.eRad.z);
               if (finalPos == null) {
                  finalPos = new Vector3f(0.0F, 0.0F, 0.0F);
                  if (FlansMod.debugMode) {
                     FlansMod.log("EntityDriveable.java moveRiders> finalPos is null [2]");
                  }
               }

               Vector3f.sub(finalPos, vehiclePos, (Vector3f)null);
               if (rider.field_70122_E && this.field_70163_u + (double)finalPos.y + 0.625D < (double)riderPos.y) {
               }

               boolean stationary = this.throttle == 0.0F;
               test.ConvertESpaceToR3(finalPos);
               boolean onTop = test.collisionPlaneNormal.y >= 0.5F;
               if (this.field_70163_u + (double)finalPos.y + 0.625D < (double)riderPos.y) {
                  finalPos.y = riderPos.y - (float)this.field_70163_u - 0.625F;
               }

               if (!this.hugeBoat) {
                  rider.func_70107_b(!onTop ? (double)(riderPos.x + finalPos.x / (48.0F * Math.abs(relativePos.x))) : (double)riderPos.x, onTop ? this.field_70163_u + (double)finalPos.y + 0.625D : (double)riderPos.y, !onTop ? (double)(riderPos.z + finalPos.z / (48.0F * Math.abs(relativePos.z))) : (double)riderPos.z);
               }

               if (this.hugeBoat && !stationary) {
                  rider.func_70107_b((double)riderPos.x, this.field_70163_u + (double)finalPos.y + 0.59375D, (double)riderPos.z);
               } else if (this.hugeBoat && stationary) {
                  rider.func_70107_b((double)riderPos.x, this.field_70163_u + (double)finalPos.y + 0.625D, (double)riderPos.z);
               }

               finalPos = Vector3f.sub(finalPos, riderPos, (Vector3f)null);
               finalPos.normalise();
               rider.field_70181_x = 0.0D;
               this.updateRiderPos(rider, test, finalPos, riderMotion);
               EntitySeat[] var21 = this.seats;
               int var22 = var21.length;

               for(int var23 = 0; var23 < var22; ++var23) {
                  EntitySeat seat = var21[var23];
                  if (this.getDriveableType().collisionDamageEnable && !test.isOnTop && this.throttle > this.getDriveableType().collisionDamageThrottle) {
                     boolean canDamage = true;
                     if (seat != null && TeamsManager.getInstance() != null && TeamsManager.getInstance().currentRound != null && rider instanceof EntityPlayerMP && this.seats[0].field_70153_n instanceof EntityPlayer) {
                        EntityPlayerMP attacker = (EntityPlayerMP)this.seats[0].field_70153_n;
                        EntityPlayerMP player = (EntityPlayerMP)rider;
                        Gametype var10000 = TeamsManager.getInstance().currentRound.gametype;
                        if (Gametype.getPlayerData(attacker) != null) {
                           var10000 = TeamsManager.getInstance().currentRound.gametype;
                           if (Gametype.getPlayerData(attacker).team != null) {
                              var10000 = TeamsManager.getInstance().currentRound.gametype;
                              if (Gametype.getPlayerData(player) != null) {
                                 var10000 = TeamsManager.getInstance().currentRound.gametype;
                                 if (Gametype.getPlayerData(player).team != null) {
                                    var10000 = TeamsManager.getInstance().currentRound.gametype;
                                    Team var31 = Gametype.getPlayerData(player).team;
                                    Gametype var10001 = TeamsManager.getInstance().currentRound.gametype;
                                    if (var31 == Gametype.getPlayerData(attacker).team) {
                                       canDamage = false;
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if (rider == seat.lastRiddenByEntity) {
                        canDamage = false;
                     }

                     if (canDamage) {
                        if (rider instanceof EntityLiving) {
                           rider.func_70097_a(DamageSource.field_76377_j, this.throttle * this.getDriveableType().collisionDamageTimes);
                        } else if (rider instanceof EntityPlayer) {
                           rider.func_70097_a(DamageSource.field_76377_j, this.throttle * this.getDriveableType().collisionDamageTimes);
                        }
                     }
                  }
               }

               if (rider instanceof EntityPlayer) {
                  EntityPlayer player = (EntityPlayer)rider;
                  player.field_70122_E = true;
                  player.field_70160_al = false;
                  player.field_70143_R = 0.0F;
               }
            } else if (rider instanceof EntityDriveable) {
               ((EntityDriveable)rider).deckHeight = 0.0D;
            }

         }
      }
   }

   public DamageSource getBulletDamage(boolean headshot) {
      DriveableType type = this.getDriveableType();
      EntityLivingBase owner = (EntityLivingBase)this.seats[0].field_70153_n;
      return owner instanceof EntityPlayer ? (new EntityDamageSourceGun(this.getDriveableType().shortName, this, (EntityPlayer)owner, type, headshot)).func_76349_b() : (new EntityDamageSourceIndirect(type.shortName, this, owner)).func_76349_b();
   }

   public void checkCollision(CollisionTest tester, CollisionShapeBox box) {
      double distance = tester.nearestDistance;
      new Vector3f(0.0F, 0.0F, 0.0F);
      int surface = 0;
      Vector3f pos = new Vector3f(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      RotatedAxes shift = this.axes;
      float var10000 = box.pos.x + box.size.x;
      float f5 = -box.pos.y + box.size.y;
      var10000 = box.pos.z + box.size.z;
      box.pos = new Vector3f(box.pos.x, box.pos.y, box.pos.z);
      Vector3f p1 = new Vector3f(box.pos.x - box.p1.x, box.pos.y + box.size.y + box.p1.y - box.size.y + 0.625F, box.pos.z - box.p1.z);
      Vector3f p2 = new Vector3f(box.pos.x + box.size.x + box.p2.x, box.pos.y + box.size.y + box.p2.y - box.size.y + 0.625F, box.pos.z - box.p2.z);
      Vector3f p3 = new Vector3f(box.pos.x + box.size.x + box.p3.x, box.pos.y + box.size.y + box.p3.y - box.size.y + 0.625F, box.pos.z + box.size.z + box.p3.z);
      Vector3f p4 = new Vector3f(box.pos.x - box.p4.x, box.pos.y + box.size.y + box.p4.y - box.size.y + 0.625F, box.pos.z + box.size.z + box.p4.z);
      Vector3f p5 = new Vector3f(box.pos.x - box.p5.x, box.pos.y - box.p5.y - box.size.y + 0.625F, box.pos.z - box.p5.z);
      Vector3f p6 = new Vector3f(box.pos.x + box.size.x + box.p6.x, box.pos.y - box.p6.y - box.size.y + 0.625F, box.pos.z - box.p6.z);
      Vector3f p7 = new Vector3f(box.pos.x + box.size.x + box.p7.x, box.pos.y - box.p7.y - box.size.y + 0.625F, box.pos.z + box.size.z + box.p7.z);
      Vector3f p8 = new Vector3f(box.pos.x - box.p8.x, box.pos.y - box.p8.y - box.size.y + 0.625F, box.pos.z + box.size.z + box.p8.z);
      if (EnumDriveablePart.getPart(box.part) == EnumDriveablePart.turret && this.seats[0] != null) {
         p1 = this.getPositionOnTurret(p1, false);
         p2 = this.getPositionOnTurret(p2, false);
         p3 = this.getPositionOnTurret(p3, false);
         p4 = this.getPositionOnTurret(p4, false);
         p5 = this.getPositionOnTurret(p5, false);
         p6 = this.getPositionOnTurret(p6, false);
         p7 = this.getPositionOnTurret(p7, false);
         p8 = this.getPositionOnTurret(p8, false);
      } else {
         p1 = shift.findLocalVectorGlobally(p1);
         p2 = shift.findLocalVectorGlobally(p2);
         p3 = shift.findLocalVectorGlobally(p3);
         p4 = shift.findLocalVectorGlobally(p4);
         p5 = shift.findLocalVectorGlobally(p5);
         p6 = shift.findLocalVectorGlobally(p6);
         p7 = shift.findLocalVectorGlobally(p7);
         p8 = shift.findLocalVectorGlobally(p8);
      }

      double topFaceDist = 100.0D;
      tester.checkTriangle(tester, p3, p2, p1);
      Vector3f collisionPoint;
      if (tester.didCollide && tester.nearestDistance < distance) {
         collisionPoint = tester.intersectionPoint;
         surface = 1;
         tester.part = EnumDriveablePart.getPart(box.part);
      }

      tester.checkTriangle(tester, p4, p3, p1);
      if (tester.didCollide && tester.nearestDistance < distance) {
         collisionPoint = tester.intersectionPoint;
         surface = 1;
         tester.part = EnumDriveablePart.getPart(box.part);
      }

      if (tester.didCollide) {
         tester.isOnTop = true;
         topFaceDist = tester.nearestDistance;
      }

      tester.checkTriangle(tester, p6, p7, p3);
      if (tester.didCollide && tester.nearestDistance < distance) {
         distance = tester.nearestDistance;
         collisionPoint = tester.intersectionPoint;
         surface = 2;
         tester.part = EnumDriveablePart.getPart(box.part);
      }

      tester.checkTriangle(tester, p3, p2, p6);
      if (tester.didCollide && tester.nearestDistance < distance) {
         distance = tester.nearestDistance;
         collisionPoint = tester.intersectionPoint;
         surface = 2;
         tester.part = EnumDriveablePart.getPart(box.part);
      }

      tester.checkTriangle(tester, p4, p1, p5);
      if (tester.didCollide && tester.nearestDistance < distance) {
         distance = tester.nearestDistance;
         collisionPoint = tester.intersectionPoint;
         surface = 3;
         tester.part = EnumDriveablePart.getPart(box.part);
      }

      tester.checkTriangle(tester, p5, p8, p4);
      if (tester.didCollide && tester.nearestDistance < distance) {
         distance = tester.nearestDistance;
         collisionPoint = tester.intersectionPoint;
         surface = 3;
         tester.part = EnumDriveablePart.getPart(box.part);
      }

      tester.checkTriangle(tester, p6, p5, p1);
      if (tester.didCollide && tester.nearestDistance < distance) {
         distance = tester.nearestDistance;
         collisionPoint = tester.intersectionPoint;
         surface = 4;
         tester.part = EnumDriveablePart.getPart(box.part);
      }

      tester.checkTriangle(tester, p1, p2, p6);
      if (tester.didCollide && tester.nearestDistance < distance) {
         distance = tester.nearestDistance;
         collisionPoint = tester.intersectionPoint;
         surface = 4;
         tester.part = EnumDriveablePart.getPart(box.part);
      }

      tester.checkTriangle(tester, p8, p7, p3);
      if (tester.didCollide && tester.nearestDistance < distance) {
         distance = tester.nearestDistance;
         collisionPoint = tester.intersectionPoint;
         surface = 5;
         tester.part = EnumDriveablePart.getPart(box.part);
      }

      tester.checkTriangle(tester, p3, p4, p8);
      if (tester.didCollide && tester.nearestDistance < distance) {
         distance = tester.nearestDistance;
         collisionPoint = tester.intersectionPoint;
         surface = 5;
         tester.part = EnumDriveablePart.getPart(box.part);
      }

      tester.checkTriangle(tester, p5, p6, p7);
      if (tester.didCollide && tester.nearestDistance < distance) {
         collisionPoint = tester.intersectionPoint;
         surface = 1;
         tester.part = EnumDriveablePart.getPart(box.part);
      }

      tester.checkTriangle(tester, p8, p7, p5);
      if (tester.didCollide && tester.nearestDistance < distance) {
         collisionPoint = tester.intersectionPoint;
         surface = 1;
         tester.part = EnumDriveablePart.getPart(box.part);
      }

      if (tester.didCollide) {
         tester.isOnTop = true;
         topFaceDist = tester.nearestDistance;
      }

      Vector3f.add(p1, pos, p1);
      Vector3f.add(p2, pos, p2);
      Vector3f.add(p3, pos, p3);
      Vector3f.add(p4, pos, p4);
      Vector3f.add(p5, pos, p5);
      Vector3f.add(p6, pos, p6);
      Vector3f.add(p7, pos, p7);
      Vector3f.add(p8, pos, p8);
      boolean muff = true;
      String wank = "crit";
      if (tester.nearestDistance < topFaceDist) {
         tester.isOnTop = false;
      }

      if (surface == 1) {
         tester.isOnTop = true;
      }

   }

   public void renderTri(Vector3f p1, Vector3f p2, Vector3f p3) {
      Vector3f pos = new Vector3f(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      Vector3f p1a = Vector3f.add(p1, pos, (Vector3f)null);
      Vector3f p2a = Vector3f.add(p2, pos, (Vector3f)null);
      Vector3f p3a = Vector3f.add(p3, pos, (Vector3f)null);
      this.renderLine(p1a, p2a);
      this.renderLine(p2a, p3a);
      this.renderLine(p3a, p1a);
   }

   public void renderLine(Vector3f in, Vector3f out) {
      float dx = out.x - in.x;
      float dy = out.y - in.y;
      float dz = out.z - in.z;
      Vector3f diff = Vector3f.sub(out, in, (Vector3f)null);
      diff.normalise();
      float distance = (float)Math.sqrt((double)(dx * dx + dy * dy + dz * dz));

      for(int i = 0; i < 10; ++i) {
         float dist2 = distance / 10.0F * (float)i;
         Vector3f newVec = new Vector3f(in.x + dist2 * diff.x, in.y + dist2 * diff.y, in.z + dist2 * diff.z);
         FlansMod.proxy.spawnParticle("reddust", (double)newVec.x, (double)newVec.y, (double)newVec.z, 0.0D, 0.0D, 0.0D);
      }

   }

   public Vector3f collideWithDriveable(CollisionTest tester, Vector3f Pos, Vector3f vel) {
      float unitScale = 0.0625F;
      float veryCloseDistance = 0.005F * unitScale;
      if (tester.collisionRecursiveDepth > 2) {
         return Pos;
      } else {
         tester.basePoint = Pos;
         tester.didCollide = false;
         Iterator var6;
         if (this.getDriveableType().fancyCollision) {
            var6 = this.getDriveableType().collisionBox.iterator();

            while(var6.hasNext()) {
               CollisionShapeBox sbox = (CollisionShapeBox)var6.next();
               this.checkCollision(tester, sbox);
            }
         } else {
            var6 = this.getDriveableData().parts.values().iterator();

            while(var6.hasNext()) {
               DriveablePart ppart = (DriveablePart)var6.next();
               ppart.rayTraceRider(this, tester);
            }
         }

         if (tester.didCollide = false) {
            return Vector3f.add(Pos, vel, (Vector3f)null);
         } else {
            Vector3f destinationPoint = Vector3f.add(Pos, vel, (Vector3f)null);
            Vector3f newBasePoint = Pos;
            if (tester.nearestDistance >= (double)veryCloseDistance) {
               vel.normalise();
               vel.scale((float)(tester.nearestDistance - (double)veryCloseDistance));
               newBasePoint = Vector3f.add(tester.basePoint, vel, (Vector3f)null);
               if (vel.normalise() == new Vector3f(0.0F, 0.0F, 0.0F)) {
                  return Vector3f.add(Pos, vel, (Vector3f)null);
               }

               vel.normalise();
               Vector3f.sub(tester.intersectionPoint, new Vector3f(vel.x * veryCloseDistance, vel.y * veryCloseDistance, vel.z * veryCloseDistance), tester.intersectionPoint);
            }

            Vector3f slidePlaneOrigin = tester.intersectionPoint;
            if (tester.intersectionPoint == null) {
               return Vector3f.add(Pos, vel, (Vector3f)null);
            } else {
               Vector3f slidePlaneNormal = Vector3f.sub(newBasePoint, tester.intersectionPoint, (Vector3f)null);
               slidePlaneNormal.normalise();
               tester.collisionPlaneNormal = slidePlaneNormal;
               CollisionPlane plane = new CollisionPlane(slidePlaneOrigin, slidePlaneNormal);
               double sDV = plane.signedDistanceTo(destinationPoint);
               Vector3f scaledNormal = new Vector3f((double)slidePlaneNormal.x * sDV, (double)slidePlaneNormal.y * sDV, (double)slidePlaneNormal.z * sDV);
               Vector3f newDestPoint = Vector3f.sub(destinationPoint, scaledNormal, (Vector3f)null);
               Vector3f newVelocityVector = Vector3f.sub(newDestPoint, tester.intersectionPoint, (Vector3f)null);
               if (newVelocityVector.length() < veryCloseDistance) {
                  return newBasePoint;
               } else {
                  ++tester.collisionRecursiveDepth;
                  return this.collideWithDriveable(tester, newBasePoint, newVelocityVector);
               }
            }
         }
      }
   }

   public void updateRiderPos(Entity rider, CollisionTest test, Vector3f pos, Vector3f motion) {
      boolean isDriveable = false;
      if (rider instanceof EntityDriveable) {
         isDriveable = true;
      }

      Vector3f vehicleMotion = this.lastPos;
      Vector3f riderMountPoint = new Vector3f(rider.field_70165_t - this.field_70165_t, rider.field_70163_u - this.field_70163_u, rider.field_70161_v - this.field_70161_v);
      float yawDiff = this.axes.getYaw() - this.prevAxes.getYaw();
      float pitchDiff = this.axes.getPitch() - this.prevAxes.getPitch();
      float rollDiff = this.axes.getRoll() - this.prevAxes.getRoll();
      RotatedAxes velAxes = new RotatedAxes(this.axes.getYaw() + yawDiff, this.axes.getPitch() + pitchDiff, this.axes.getRoll() + rollDiff);
      Vector3f currentLocalPos = this.axes.findGlobalVectorLocally(riderMountPoint);
      Vector3f nextGlobalPos = velAxes.findLocalVectorGlobally(currentLocalPos);
      Vector3f diff = new Vector3f(0.0F, 0.0F, 0.0F);
      if (nextGlobalPos == null) {
         nextGlobalPos = new Vector3f(0.0F, 0.0F, 0.0F);
      }

      if (diff == null) {
         diff = new Vector3f(0.0F, 0.0F, 0.0F);
         if (FlansMod.debugMode) {
            FlansMod.log("EntityDriveable.java updateRidarPos> diff is null [1]");
         }
      }

      Vector3f.add(vehicleMotion, diff, diff);
      rider.func_70107_b((double)nextGlobalPos.x + this.field_70165_t + (this.hugeBoat ? (double)diff.x / 1.5D : 0.0D), !isDriveable ? rider.field_70163_u : ((EntityDriveable)rider).deckHeight, (double)nextGlobalPos.z + this.field_70161_v + (this.hugeBoat ? (double)diff.z / 1.5D : 0.0D));
      if (this.hugeBoat) {
         if (this.lastPos.x == 0.0F && this.lastPos.y == 0.0F && this.lastPos.z == 0.0F) {
            rider.field_70159_w = rider.field_70159_w;
            rider.field_70181_x = rider.field_70181_x;
            rider.field_70179_y = rider.field_70179_y;
            if (rider.field_70181_x < 0.0D) {
               rider.field_70181_x = 0.0D;
            }
         }
      } else if (this.lastPos.x == 0.0F && this.lastPos.y == 0.0F && this.lastPos.z == 0.0F) {
         rider.field_70159_w = rider.field_70159_w;
         rider.field_70181_x = rider.field_70181_x;
         rider.field_70179_y = rider.field_70179_y;
      } else {
         rider.field_70159_w = (double)diff.x;
         rider.field_70181_x = (double)diff.y;
         rider.field_70179_y = (double)diff.z;
      }

   }

   public void handleVehicleCollision(EntityDriveable collided, CollisionTest test, Vector3f finalPos, boolean hugeBoat) {
   }

   public ArrayList<BulletHit> attackFromBullet(Vector3f origin, Vector3f motion) {
      ArrayList<BulletHit> hits = new ArrayList();
      Vector3f relativePosVector = Vector3f.sub(origin, new Vector3f((float)this.field_70165_t, (float)this.field_70163_u, (float)this.field_70161_v), (Vector3f)null);
      Vector3f rotatedPosVector = this.axes.findGlobalVectorLocally(relativePosVector);
      Vector3f rotatedMotVector = this.axes.findGlobalVectorLocally(motion);
      Iterator var7 = this.getDriveableData().parts.values().iterator();

      while(var7.hasNext()) {
         DriveablePart part = (DriveablePart)var7.next();
         DriveableHit hit = part.rayTrace(this, rotatedPosVector, rotatedMotVector);
         if (hit != null) {
            hits.add(hit);
         }
      }

      return hits;
   }

   public ArrayList<BulletHit> attackFromBulletButBetter(Vector3f origin, Vector3f motion, float size) {
      ArrayList<BulletHit> hits = new ArrayList();
      new Vector3f(this.field_70165_t - (double)this.lastPos.x, this.field_70163_u - (double)this.lastPos.y, this.field_70161_v - (double)this.lastPos.z);
      Vector3f vehiclePos = new Vector3f(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      Vector3f relativePos = Vector3f.sub(origin, vehiclePos, (Vector3f)null);
      this.axes.findGlobalVectorLocally(relativePos);
      this.axes.findGlobalVectorLocally(motion);
      Vector3f ellipsoid = new Vector3f(size, size, size);
      CollisionTest test = new CollisionTest(ellipsoid, new Vector3f(relativePos.x, relativePos.y, relativePos.z), motion);
      test.collisionRecursiveDepth = 0;
      Vector3f eSpacePosition = test.ConvertR3ToESpace(test.R3Position);
      Vector3f eSpaceVelocity = test.velocity;
      Iterator var14 = this.getDriveableData().parts.values().iterator();

      while(var14.hasNext()) {
         DriveablePart ppart = (DriveablePart)var14.next();
         ppart.rayTraceRider(this, test);
      }

      if (test.didCollide) {
         Vector3f hitPos = new Vector3f(0.0F, 0.0F, 0.0F);
         Vector3f intersect2 = new Vector3f(test.ConvertESpaceToR3(test.intersectionPoint));
         Vector3f.sub(origin, intersect2, hitPos);
         float f = hitPos.length() / motion.length();
         DriveableHit hit = new DriveableHit(this, test.part, f);
         hits.add(hit);
      }

      return hits;
   }

   public float bulletHit(EntityBullet bullet, DriveableHit hit, float penetratingPower) {
      DriveablePart part = (DriveablePart)this.getDriveableData().parts.get(hit.part);
      if (bullet != null && hit != null) {
         part.hitByBullet(bullet, hit);
      }

      if (!this.field_70170_p.field_72995_K) {
         this.checkParts();
         FlansMod.getPacketHandler().sendToAllAround(new PacketDriveableDamage(this), this.field_70165_t, this.field_70163_u, this.field_70161_v, 100.0F, this.field_71093_bK);
      }

      return penetratingPower - 5.0F;
   }

   public DriveablePart raytraceParts(Vector3f origin, Vector3f motion) {
      Vector3f relativePosVector = Vector3f.sub(origin, new Vector3f((float)this.field_70165_t, (float)this.field_70163_u, (float)this.field_70161_v), (Vector3f)null);
      Vector3f rotatedPosVector = this.axes.findGlobalVectorLocally(relativePosVector);
      Vector3f rotatedMotVector = this.axes.findGlobalVectorLocally(motion);
      Iterator var6 = this.getDriveableData().parts.values().iterator();

      DriveablePart part;
      do {
         if (!var6.hasNext()) {
            return null;
         }

         part = (DriveablePart)var6.next();
      } while(part.rayTrace(this, rotatedPosVector, rotatedMotVector) == null);

      return part;
   }

   public boolean canHitPart(EnumDriveablePart part) {
      return true;
   }

   public void checkParts() {
      Iterator var1 = this.getDriveableData().parts.values().iterator();

      while(var1.hasNext()) {
         DriveablePart part = (DriveablePart)var1.next();
         if (part != null && !part.dead && part.health <= 0 && part.maxHealth > 0) {
            this.killPart(part);
         }
      }

      EntitySeat[] var10 = this.seats;
      int var12 = var10.length;

      int seatNum;
      for(seatNum = 0; seatNum < var12; ++seatNum) {
         EntitySeat var10000 = var10[seatNum];
      }

      DriveableData data = this.getDriveableData();
      DriveableType type = this.getDriveableType();
      if (data.depth / -type.maxDepth > 1.0F) {
         this.crushed = true;
      }

      int i;
      if (((DriveablePart)this.getDriveableData().parts.get(EnumDriveablePart.core)).dead && !type.inshallah) {
         seatNum = this.seats.length;
         if (!this.field_70170_p.field_72995_K) {
            for(i = 0; i < seatNum; ++i) {
               if (this.seats[i].field_70153_n != null && this.seats[i].field_70153_n instanceof EntityPlayer) {
                  Entity entity = this.seats[i].field_70153_n;
                  this.seats[i].field_70153_n.func_70078_a((Entity)null);
                  if (this.lastAtkEntity instanceof EntityPlayer) {
                     entity.func_70097_a(DamageSource.func_76365_a((EntityPlayer)this.lastAtkEntity), 1.0E7F);
                  } else if (this.lastAtkEntity instanceof EntityLivingBase) {
                     entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this.lastAtkEntity), 1.0E7F);
                  }
               }
            }

            if (type.isExplosionWhenDestroyed && type.isExplosionWhenDestroyedRadius == 0.0F) {
               this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 4.0F, false);
            } else if (type.isExplosionWhenDestroyedRadius > 0.0F) {
               this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, type.isExplosionWhenDestroyedRadius, false);
            }

            if (type.nuclearDeath) {
               FlansMod.proxy.spawnParticle("flansmod.FMNuke", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D);
               PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 250.0D, this.field_71093_bK, "YamatoGun", false);
            }

            if (type.bigDeath) {
               FlansMod.proxy.spawnParticle("flansmod.shipDeath", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D);
               PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 250.0D, this.field_71093_bK, "BattleshipGun", false);
            }

            if (type.Death) {
               FlansMod.proxy.spawnParticle("flansmod.tankDeath", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D);
               PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 250.0D, this.field_71093_bK, "explcls6", false);
            }

            Iterator var15 = this.driveableData.parts.values().iterator();

            while(var15.hasNext()) {
               DriveablePart part = (DriveablePart)var15.next();
               if (part.health > 0 && !part.dead) {
                  this.killPart(part);
               }
            }
         }

         data.depth = -9000.0F;
         this.func_70106_y();
      }

      EntitySeat[] var14 = this.seats;
      i = var14.length;

      for(int var17 = 0; var17 < i; ++var17) {
         EntitySeat seat = var14[var17];
         if (((DriveablePart)this.getDriveableData().parts.get(EnumDriveablePart.core)).dead && seat != null && type.inshallah || ((DriveablePart)this.getDriveableData().parts.get(EnumDriveablePart.core)).dead && seat != null && type.canDive || this.suicide && seat != null && type.inshallah) {
            if (seat != null && (seat != null && this.seats[0].field_70153_n != null && this.seats[0].field_70153_n instanceof EntityPlayer && type.inshallah || seat != null && this.seats[0].field_70153_n != null && this.seats[0].field_70153_n instanceof EntityPlayer && type.canDive)) {
               ((EntityPlayer)this.seats[0].field_70153_n).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5));
            }

            int seatNum = this.seats.length;
            if (!this.field_70170_p.field_72995_K) {
               for(int i = 0; i < seatNum; ++i) {
                  if (this.seats[i].field_70153_n != null && this.seats[i].field_70153_n instanceof EntityPlayer) {
                     Entity entity = this.seats[i].field_70153_n;
                     this.seats[i].field_70153_n.func_70078_a((Entity)null);
                     if (this.lastAtkEntity instanceof EntityPlayer) {
                        entity.func_70097_a(DamageSource.func_76365_a((EntityPlayer)this.lastAtkEntity), 1.0E7F);
                     } else if (this.lastAtkEntity instanceof EntityLivingBase) {
                        entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this.lastAtkEntity), 1.0E7F);
                     }
                  }
               }

               if (type.isExplosionWhenDestroyed && type.isExplosionWhenDestroyedRadius == 0.0F) {
                  this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 4.0F, false);
               } else if (type.isExplosionWhenDestroyedRadius > 0.0F) {
                  this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, type.isExplosionWhenDestroyedRadius, false);
               }

               if (type.nuclearDeath) {
                  FlansMod.proxy.spawnParticle("flansmod.FMNuke", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D);
                  PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 250.0D, this.field_71093_bK, "YamatoGun", false);
               }

               if (type.bigDeath) {
                  FlansMod.proxy.spawnParticle("flansmod.shipDeath", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D);
                  PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 250.0D, this.field_71093_bK, "BattleshipGun", false);
               }

               if (type.Death) {
                  FlansMod.proxy.spawnParticle("flansmod.tankDeath", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D);
                  PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 250.0D, this.field_71093_bK, "explcls6", false);
               }

               Iterator var18 = this.driveableData.parts.values().iterator();

               while(var18.hasNext()) {
                  DriveablePart part = (DriveablePart)var18.next();
                  if (part.health > 0 && !part.dead) {
                     this.killPart(part);
                  }
               }
            }

            data.depth = -9000.0F;
            if (seat != null) {
               this.func_70106_y();
            }
         }
      }

   }

   public void checkPartsWhenAttacked() {
      Iterator var1 = this.getDriveableData().parts.values().iterator();

      while(var1.hasNext()) {
         DriveablePart part = (DriveablePart)var1.next();
         if (part != null && !part.dead && part.health <= 0 && part.maxHealth > 0) {
            this.killPart(part);
         }
      }

   }

   private void killPart(DriveablePart part) {
      if (!part.dead) {
         part.health = 0;
         part.dead = true;
         FlansMod.proxy.spawnParticle("largeexplode", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D);
         DriveableType type = this.getDriveableType();
         int i;
         if (!this.field_70170_p.field_72995_K) {
            Vector3f pos = new Vector3f(0.0F, 0.0F, 0.0F);
            if (part.box != null) {
               pos = this.axes.findLocalVectorGlobally(new Vector3f(part.box.x / 16.0F + part.box.w / 32.0F, part.box.y / 16.0F + part.box.h / 32.0F, part.box.z / 16.0F + part.box.d / 32.0F));
            }

            ArrayList<ItemStack> drops = type.getItemsRequired(part, this.getDriveableData().engine);
            ItemStack stack;
            if (drops != null) {
               for(Iterator var5 = drops.iterator(); var5.hasNext(); stack = (ItemStack)var5.next()) {
               }
            }

            this.dropItemsOnPartDeath(pos, part);
            if (part.type == EnumDriveablePart.core) {
               for(i = 0; i < this.getDriveableData().func_70302_i_(); ++i) {
                  stack = this.getDriveableData().func_70301_a(i);
                  if (stack != null) {
                     this.field_70170_p.func_72838_d(new EntityItem(this.field_70170_p, this.field_70165_t + this.field_70146_Z.nextGaussian(), this.field_70163_u + this.field_70146_Z.nextGaussian(), this.field_70161_v + this.field_70146_Z.nextGaussian(), stack));
                  }
               }
            }
         }

         EnumDriveablePart[] var7 = part.type.getChildren();
         int var8 = var7.length;

         for(i = 0; i < var8; ++i) {
            EnumDriveablePart child = var7[i];
            this.killPart((DriveablePart)this.getDriveableData().parts.get(child));
         }

      }
   }

   protected abstract void dropItemsOnPartDeath(Vector3f var1, DriveablePart var2);

   public float getPlayerRoll() {
      return this.axes.getRoll();
   }

   public void explode() {
   }

   public float getCameraDistance() {
      return this.getDriveableType().cameraDistance;
   }

   public boolean isPartIntact(EnumDriveablePart part) {
      DriveablePart thisPart = (DriveablePart)this.getDriveableData().parts.get(part);
      return thisPart.maxHealth == 0 || thisPart.health > 0;
   }

   public float healthPercent(EnumDriveablePart part) {
      DriveablePart thisPart = (DriveablePart)this.getDriveableData().parts.get(part);
      return thisPart.maxHealth == 0 ? 1.0F : (float)(thisPart.health / thisPart.maxHealth);
   }

   public abstract boolean hasMouseControlMode();

   public abstract String getBombInventoryName();

   public abstract String getMissileInventoryName();

   public boolean rotateWithTurret(Seat seat) {
      return seat.part == EnumDriveablePart.turret;
   }

   public String func_70005_c_() {
      return this.getDriveableType().name;
   }

   @SideOnly(Side.CLIENT)
   public boolean showInventory(int seat) {
      return seat != 0 || !FlansModClient.controlModeMouse;
   }

   public int getShootDelay(boolean secondary) {
      return secondary ? this.shootDelaySecondary : this.shootDelayPrimary;
   }

   public boolean canLaunchIT1() {
      return this.canFireIT1;
   }

   public float getMinigunSpeed(boolean secondary) {
      return secondary ? this.minigunSpeedSecondary : this.minigunSpeedPrimary;
   }

   public int getCurrentGun(boolean secondary) {
      return secondary ? this.currentGunSecondary : this.currentGunPrimary;
   }

   public void setShootDelay(int i, boolean secondary) {
      this.setRecoilTimer();
      if (secondary) {
         this.shootDelaySecondary = i > this.shootDelaySecondary ? i : this.shootDelaySecondary;
      } else {
         this.shootDelayPrimary = i > this.shootDelayPrimary ? i : this.shootDelayPrimary;
      }

   }

   public void setMinigunSpeed(float f, boolean secondary) {
      if (secondary) {
         this.minigunSpeedSecondary = f;
      } else {
         this.minigunSpeedPrimary = f;
      }

   }

   public void setCurrentGun(int i, boolean secondary) {
      if (secondary) {
         this.currentGunSecondary = i;
      } else {
         this.currentGunPrimary = i;
      }

   }

   public void setEntityMarker(int tick) {
      this.isShowedPosition = true;
      this.tickCount = tick;
   }

   public void lock(String tool, EntityPlayer player) {
      if (this.key == "ChangeMe") {
         this.key = tool;
         player.func_145747_a(new ChatComponentText("Registered key"));
      } else if (tool == this.key) {
         this.locked = true;
         player.func_145747_a(new ChatComponentText("Locked"));
      } else {
         player.func_145747_a(new ChatComponentText(this.key));
      }

   }

   public void IT1Reload() {
      DriveableType type = this.getDriveableType();
      if (this.stage == 1) {
         this.drakonDoorAngle = this.moveToTarget(this.drakonDoorAngle, 0.0F, 5.0F);
         this.drakonArmAngle = this.moveToTarget(this.drakonArmAngle, 0.0F, 3.0F);
         this.drakonRailAngle = this.moveToTarget(this.drakonRailAngle, -10.0F, 5.0F);
         if (this.drakonRailAngle == -10.0F) {
            ++this.stage;
         }
      }

      if (this.stage == 2) {
         this.drakonDoorAngle = this.moveToTarget(this.drakonDoorAngle, -90.0F, 5.0F);
         this.drakonArmAngle = this.moveToTarget(this.drakonArmAngle, 0.0F, 3.0F);
         this.drakonRailAngle = this.moveToTarget(this.drakonRailAngle, -10.0F, 1.0F);
         if (this.drakonDoorAngle == -90.0F) {
            ++this.stage;
         }
      }

      if (this.stage == 3) {
         this.drakonDoorAngle = this.moveToTarget(this.drakonDoorAngle, -90.0F, 5.0F);
         this.drakonArmAngle = this.moveToTarget(this.drakonArmAngle, 179.0F, 3.0F);
         this.drakonRailAngle = this.moveToTarget(this.drakonRailAngle, -10.0F, 1.0F);
         if (this.drakonArmAngle == 179.0F) {
            ++this.stage;
         }
      }

      if (this.stage == 4) {
         this.drakonDoorAngle = this.moveToTarget(this.drakonDoorAngle, 0.0F, 10.0F);
         this.drakonArmAngle = this.moveToTarget(this.drakonArmAngle, 180.0F, 3.0F);
         this.drakonRailAngle = this.moveToTarget(this.drakonRailAngle, -10.0F, 1.0F);
         if (this.drakonDoorAngle == 0.0F && this.IT1Loaded()) {
            ++this.stage;
            this.reloadAnimTime = 60;
         }
      }

      if (this.stage == 5) {
         this.drakonDoorAngle = this.moveToTarget(this.drakonDoorAngle, -90.0F, 10.0F);
         this.drakonArmAngle = this.moveToTarget(this.drakonArmAngle, 180.0F, 3.0F);
         this.drakonRailAngle = this.moveToTarget(this.drakonRailAngle, -10.0F, 1.0F);
         this.reloadingDrakon = true;
         if (this.drakonDoorAngle == -90.0F) {
            ++this.stage;
         }
      }

      if (this.stage == 6) {
         this.drakonDoorAngle = this.moveToTarget(this.drakonDoorAngle, -90.0F, 5.0F);
         this.drakonArmAngle = this.moveToTarget(this.drakonArmAngle, 0.0F, 3.0F);
         this.drakonRailAngle = this.moveToTarget(this.drakonRailAngle, -10.0F, 1.0F);
         if (this.drakonArmAngle == 0.0F) {
            ++this.stage;
         }
      }

      if (this.stage == 7) {
         this.drakonDoorAngle = this.moveToTarget(this.drakonDoorAngle, 0.0F, 10.0F);
         this.drakonArmAngle = this.moveToTarget(this.drakonArmAngle, 0.0F, 3.0F);
         this.drakonRailAngle = this.moveToTarget(this.drakonRailAngle, 0.0F, 1.0F);
         if (this.drakonRailAngle == 0.0F && this.drakonDoorAngle == 0.0F) {
            ++this.stage;
            this.canFireIT1 = true;
            this.reloadingDrakon = false;
         }
      }

      if (this.stage == 8) {
         this.drakonDoorAngle = this.moveToTarget(this.drakonDoorAngle, 0.0F, 10.0F);
         this.drakonArmAngle = this.moveToTarget(this.drakonArmAngle, 0.0F, 3.0F);
         if (this.field_70170_p.field_72995_K && this.field_70173_aa > 2) {
            this.drakonRailAngle = this.moveToTarget(this.drakonRailAngle, -this.seats[0].looking.getPitch(), this.seats[0].seatInfo.aimingSpeed.y);
         }

         if (!this.IT1Loaded()) {
            this.stage = 1;
            this.canFireIT1 = false;
         }
      }

   }

   public float moveToTarget(float current, float target, float speed) {
      float pitchToMove;
      for(pitchToMove = (float)(Math.sqrt((double)(target * target)) - Math.sqrt((double)(current * current))); pitchToMove > 180.0F; pitchToMove -= 360.0F) {
      }

      while(pitchToMove <= -180.0F) {
         pitchToMove += 360.0F;
      }

      float signDeltaY = 0.0F;
      if (pitchToMove > speed) {
         signDeltaY = 1.0F;
      } else {
         if (!(pitchToMove < -speed)) {
            signDeltaY = 0.0F;
            return target;
         }

         signDeltaY = -1.0F;
      }

      if (current > target) {
         current -= speed;
      } else if (current < target) {
         current += speed;
      }

      return current;
   }

   public boolean IT1Loaded() {
      DriveableType type = this.getDriveableType();
      boolean loaded = false;

      for(int i = this.driveableData.getMissileInventoryStart(); i < this.driveableData.getMissileInventoryStart() + type.numMissileSlots; ++i) {
         ItemStack shell = this.driveableData.func_70301_a(i);
         if (shell != null && shell.func_77973_b() instanceof ItemBullet && type.isValidAmmo(((ItemBullet)shell.func_77973_b()).type, EnumWeaponType.MISSILE)) {
            loaded = true;
         }
      }

      return loaded;
   }

   public void tryRecoil() {
      int slot = -1;
      DriveableType type = this.getDriveableType();

      for(int i = this.driveableData.getMissileInventoryStart(); i < this.driveableData.getMissileInventoryStart() + type.numMissileSlots; ++i) {
         ItemStack shell = this.driveableData.func_70301_a(i);
         if (shell != null && shell.func_77973_b() instanceof ItemBullet && type.isValidAmmo(((ItemBullet)shell.func_77973_b()).type, EnumWeaponType.SHELL)) {
            slot = i;
         }
      }

      if (this.recoilTimer <= 0 && slot != -1) {
         this.isRecoil = true;
      }

   }

   public void setRecoilTimer() {
      int slot = -1;
      DriveableType type = this.getDriveableType();

      for(int i = this.driveableData.getMissileInventoryStart(); i < this.driveableData.getMissileInventoryStart() + type.numMissileSlots; ++i) {
         ItemStack shell = this.driveableData.func_70301_a(i);
         if (shell != null && shell.func_77973_b() instanceof ItemBullet && type.isValidAmmo(((ItemBullet)shell.func_77973_b()).type, EnumWeaponType.SHELL)) {
            slot = i;
         }
      }

      if (this.recoilTimer <= 0 && slot != -1) {
         this.recoilTimer = this.getDriveableType().shootDelayPrimary;
      }

   }

   public void unlock(String tool, EntityPlayer player) {
      if (this.key == "ChangeMe") {
         this.key = tool;
         player.func_145747_a(new ChatComponentText("Registered key"));
      } else if (tool == this.key) {
         this.locked = false;
         player.func_145747_a(new ChatComponentText("Unlocked"));
      } else {
         player.func_145747_a(new ChatComponentText(this.key));
      }

   }
}
