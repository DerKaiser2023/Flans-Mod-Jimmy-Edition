package com.flansmod.common.driveables;

import com.flansmod.api.IExplodeable;
import com.flansmod.client.model.AnimTankTrack;
import com.flansmod.client.model.AnimTrackLink;
import com.flansmod.common.FlansMod;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketDriveableKey;
import com.flansmod.common.network.PacketParticle;
import com.flansmod.common.network.PacketPlaySound;
import com.flansmod.common.network.PacketVehicleControl;
import com.flansmod.common.teams.TeamsManager;
import com.flansmod.common.tools.ItemTool;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityVehicle extends EntityDriveable implements IExplodeable {
   public int shellDelay;
   public int gunDelay;
   public int soundPosition;
   public int idlePosition;
   public float wheelsYaw;
   private int ticksSinceUsed = 0;
   public boolean varDoor;
   public boolean combatRadar = false;
   public float wheelsAngle;
   public int toggleTimer = 0;
   public float yaw = 0.0F;
   public float pitch = 0.0F;
   public float roll = 0.0F;
   public float yawSpeed = 0.0F;
   public boolean leftTurnHeld = false;
   public boolean rightTurnHeld = false;
   public boolean allWheelsOnGround;
   public boolean tooDeep = false;
   boolean lockTurretForward = false;
   public Vector3f doorPos = new Vector3f(0.0F, 0.0F, 0.0F);
   public Vector3f doorRot = new Vector3f(0.0F, 0.0F, 0.0F);
   public Vector3f door2Pos = new Vector3f(0.0F, 0.0F, 0.0F);
   public Vector3f door2Rot = new Vector3f(0.0F, 0.0F, 0.0F);
   public Vector3f prevDoorPos = new Vector3f(0.0F, 0.0F, 0.0F);
   public Vector3f prevDoorRot = new Vector3f(0.0F, 0.0F, 0.0F);
   public Vector3f prevDoor2Pos = new Vector3f(0.0F, 0.0F, 0.0F);
   public Vector3f prevDoor2Rot = new Vector3f(0.0F, 0.0F, 0.0F);
   public int yawDelay = 0;
   public int pitchDelay = 0;
   public boolean turretYawing;
   public boolean turretPitching;
   public boolean deployedSmoke = false;
   public AnimTankTrack rightTrack;
   public AnimTankTrack leftTrack;
   public AnimTrackLink[] trackLinksLeft = new AnimTrackLink[0];
   public AnimTrackLink[] trackLinksRight = new AnimTrackLink[0];
   public boolean radarVisible;
   public boolean hasRadar;
   public float radarRange;
   public int radarPositionOffset;
   public int radarRefreshDelay;

   public EntityVehicle(World world) {
      super(world);
      this.field_70138_W = 1.0F;
   }

   public EntityVehicle(World world, double x, double y, double z, VehicleType type, DriveableData data) {
      super(world, type, data);
      this.field_70138_W = 1.0F;
      this.func_70107_b(x, y, z);
      this.initType(type, false);
   }

   public EntityVehicle(World world, double x, double y, double z, EntityPlayer placer, VehicleType type, DriveableData data) {
      super(world, type, data);
      this.field_70138_W = 1.0F;
      this.func_70107_b(x, y, z);
      this.rotateYaw(placer.field_70177_z + 90.0F);
      this.initType(type, false);
      this.setupTracks(type);
   }

   public void setupTracks(DriveableType type) {
      this.rightTrack = new AnimTankTrack(type.rightTrackPoints, type.trackLinkLength);
      this.leftTrack = new AnimTankTrack(type.leftTrackPoints, type.trackLinkLength);
      int numLinks = Math.round(this.rightTrack.getTrackLength() / type.trackLinkLength);
      this.trackLinksLeft = new AnimTrackLink[numLinks];
      this.trackLinksRight = new AnimTrackLink[numLinks];

      for(int i = 0; i < numLinks; ++i) {
         float progress = 0.01F + type.trackLinkLength * (float)i;
         int trackPart = this.leftTrack.getTrackPart(progress);
         this.trackLinksLeft[i] = new AnimTrackLink(progress);
         this.trackLinksRight[i] = new AnimTrackLink(progress);
         this.trackLinksLeft[i].position = this.leftTrack.getPositionOnTrack(progress);
         this.trackLinksRight[i].position = this.rightTrack.getPositionOnTrack(progress);
         this.trackLinksLeft[i].rot = new RotatedAxes(0.0F, 0.0F, this.rotateTowards((Vector3f)this.leftTrack.points.get(trackPart == 0 ? this.leftTrack.points.size() - 1 : trackPart - 1), this.trackLinksLeft[i].position));
         this.trackLinksRight[i].rot = new RotatedAxes(0.0F, 0.0F, this.rotateTowards((Vector3f)this.rightTrack.points.get(trackPart == 0 ? this.rightTrack.points.size() - 1 : trackPart - 1), this.trackLinksRight[i].position));
         this.trackLinksLeft[i].zRot = this.rotateTowards((Vector3f)this.leftTrack.points.get(trackPart == 0 ? this.leftTrack.points.size() - 1 : trackPart - 1), this.trackLinksLeft[i].position);
         this.trackLinksRight[i].zRot = this.rotateTowards((Vector3f)this.rightTrack.points.get(trackPart == 0 ? this.rightTrack.points.size() - 1 : trackPart - 1), this.trackLinksRight[i].position);
      }

   }

   protected void initType(DriveableType type, boolean clientSide) {
      this.radarVisible = type.radarVisible;
      this.hasRadar = type.hasRadar;
      this.radarRange = type.radarRange;
      this.radarPositionOffset = type.radarPositionOffset;
      this.radarRefreshDelay = type.radarRefreshDelay;
      super.initType(type, clientSide);
      this.setupTracks(type);
   }

   public void readSpawnData(ByteBuf data) {
      super.readSpawnData(data);
   }

   protected void func_70014_b(NBTTagCompound tag) {
      super.func_70014_b(tag);
      tag.func_74757_a("VarDoor", this.varDoor);
   }

   protected void func_70037_a(NBTTagCompound tag) {
      super.func_70037_a(tag);
      this.varDoor = tag.func_74767_n("VarDoor");
   }

   public boolean func_70112_a(double d) {
      double d1 = 400.0D;
      return d < d1 * d1;
   }

   public void onMouseMoved(int deltaX, int deltaY) {
   }

   public void setPositionRotationAndMotion(double x, double y, double z, float yaw, float pitch, float roll, double motX, double motY, double motZ, float velYaw, float velPitch, float velRoll, float throt, float steeringYaw) {
      super.setPositionRotationAndMotion(x, y, z, yaw, pitch, roll, motX, motY, motZ, velYaw, velPitch, velRoll, throt, steeringYaw);
      this.wheelsYaw = steeringYaw;
   }

   public boolean func_130002_c(EntityPlayer entityplayer) {
      if (this.field_70128_L) {
         return false;
      } else if (this.field_70170_p.field_72995_K) {
         return false;
      } else {
         ItemStack currentItem = entityplayer.func_71045_bC();
         if (currentItem != null && currentItem.func_77973_b() instanceof ItemTool && ((ItemTool)currentItem.func_77973_b()).type.healDriveables) {
            return true;
         } else {
            VehicleType type = this.getVehicleType();

            for(int i = 0; i <= type.numPassengers; ++i) {
               if (this.seats[i].func_130002_c(entityplayer)) {
                  if (i == 0) {
                     this.shellDelay = type.vehicleShellDelay;
                     FlansMod.proxy.doTutorialStuff(entityplayer, this);
                  }

                  return true;
               }
            }

            return false;
         }
      }
   }

   public boolean pressKey(int key, EntityPlayer player) {
      VehicleType type = this.getVehicleType();
      if (this.field_70170_p.field_72995_K && (key == 6 || key == 9)) {
         FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketDriveableKey(key)));
         return true;
      } else {
         switch(key) {
         case 0:
            this.throttle += type.accelModifier * 0.01F;
            if (this.throttle > 1.0F) {
               this.throttle = 1.0F;
            }

            return true;
         case 1:
            this.throttle -= type.decelModifier * 0.01F;
            if (this.throttle < -1.0F) {
               this.throttle = -1.0F;
            }

            if (this.throttle < 0.0F && type.maxNegativeThrottle == 0.0F) {
               this.throttle = 0.0F;
            }

            return true;
         case 2:
            --this.wheelsYaw;
            this.leftTurnHeld = true;
            return true;
         case 3:
            ++this.wheelsYaw;
            this.leftTurnHeld = true;
            return true;
         case 4:
            if (this.getVehicleType().canDive && this.oxygenMeter > 0.1F || this.getVehicleType().airship) {
               this.divingFactor *= 0.7F * type.brakeModifier;
            }

            if (this.getVehicleType().canDive && this.oxygenMeter < 0.1F) {
               this.divingFactor += 0.01F;
               if (this.divingFactor > 1.0F) {
                  this.divingFactor = 1.0F;
               }
            }

            this.throttle *= 0.8F * type.brakeModifier;
            if (this.throttle > type.boostLimit) {
               this.throttle = 0.0F;
            }

            return true;
         case 5:
            if (this.toggleTimer <= 0) {
               this.aiming = !this.aiming;
               this.toggleTimer = 10;
            }

            return true;
         case 6:
            this.seats[0].field_70153_n.func_82142_c(false);
            this.seats[0].field_70153_n.func_70078_a((Entity)null);
            return true;
         case 7:
            if (this.field_70170_p.field_72995_K) {
               FlansMod.proxy.openDriveableMenu((EntityPlayer)this.seats[0].field_70153_n, this.field_70170_p, this);
            }

            return true;
         case 8:
            this.func_70078_a((Entity)null);
            return true;
         case 9:
            double checkCarrierRange = 20.0D;
            List carrier = this.field_70170_p.func_72872_a(EntitySeat.class, AxisAlignedBB.func_72330_a(this.field_70165_t - checkCarrierRange, this.field_70163_u - checkCarrierRange, this.field_70161_v - checkCarrierRange, this.field_70165_t + checkCarrierRange, this.field_70163_u + checkCarrierRange, this.field_70161_v + checkCarrierRange));
            if (type.canDabOnEntity) {
               if (this.field_70153_n != null && this.field_70153_n instanceof EntityVehicle && !(this.field_70153_n instanceof EntityPlayer)) {
                  this.field_70153_n.func_70078_a((Entity)null);
                  return true;
               }

               Iterator var7 = carrier.iterator();

               while(var7.hasNext()) {
                  Object obj = var7.next();
                  EntitySeat carrierSpot = (EntitySeat)obj;
                  if (carrierSpot.field_70153_n == null && carrierSpot.seatInfo.parkingSpot) {
                     this.func_70078_a(carrierSpot);
                  }
               }
            }

            return true;
         case 10:
            if (this.getVehicleType().canDive || this.getVehicleType().airship) {
               this.divingFactor += 0.01F;
            }

            if (this.divingFactor > 1.0F) {
               this.divingFactor = 1.0F;
            }

            return true;
         case 11:
            this.seats[0].seatInfo.aimingSpeed = new Vector3f(0.0F, 0.0F, 0.0F);
            return true;
         case 12:
            this.seats[0].seatInfo.aimingSpeed = this.seats[0].seatInfo.aimingSpeedBackup;
            return true;
         case 13:
            return true;
         case 14:
            if (this.toggleTimer <= 0) {
               this.varDoor = !this.varDoor;
               if (type.hasDoor) {
                  player.func_145747_a(new ChatComponentText("Doors " + (this.varDoor ? "open" : "closed")));
               }

               this.toggleTimer = 10;
               FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketVehicleControl(this)));
            }

            if (this.toggleTimer <= 0) {
               this.combatRadar = !this.combatRadar;
               if (type.hasRadar) {
                  player.func_145747_a(new ChatComponentText("Radar set to " + (this.combatRadar ? "combat range" : "long range")));
               }

               this.toggleTimer = 10;
            }

            return true;
         case 15:
            if (this.getVehicleType().canDive && this.oxygenMeter > 0.1F || this.getVehicleType().airship) {
               this.divingFactor -= 0.01F;
            }

            if (this.divingFactor < -1.0F) {
               this.divingFactor = -1.0F;
            }

            if (this.getVehicleType().canDive && this.oxygenMeter < 0.1F) {
               this.divingFactor += 0.01F;
               if (this.divingFactor > 1.0F) {
                  this.divingFactor = 1.0F;
               }
            }

            return true;
         case 16:
            return true;
         case 18:
            if (type.hasFlare && this.ticksFlareUsing <= 0 && this.flareDelay <= 0) {
               this.ticksFlareUsing = type.timeFlareUsing * 20;
               this.flareDelay = type.flareDelay;
               this.dischargeSmoke();
               if (this.field_70170_p.field_72995_K) {
                  FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketDriveableKey(key)));
               } else {
                  this.dischargeSmoke();
                  if (!type.flareSound.isEmpty()) {
                     PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, type.flareSound, false);
                  }
               }

               return true;
            }
         case 17:
         default:
            return false;
         }
      }
   }

   public Vector3f getLookVector(ShootPoint dp) {
      return this.rotate(this.seats[0].looking.getXAxis());
   }

   public void func_70071_h_() {
      double bkPrevPosY = this.field_70167_r;
      super.func_70071_h_();
      this.field_70155_l = 4000.0D;
      Iterator var3 = this.findEntitiesWithinbounds().iterator();

      while(var3.hasNext()) {
         Entity e = (Entity)var3.next();
         if (e != this) {
            this.moveRiders(e);
         }
      }

      VehicleType type = this.getVehicleType();
      DriveableData data = this.getDriveableData();
      if (type == null) {
         FlansMod.log("Vehicle type null. Not ticking vehicle");
      } else {
         if ((double)this.throttle > 0.7D && this.getDriveableType().needsThrottle && this.leftMouseHeld && this.ticksFlareUsing <= 0) {
            this.ticksFlareUsing = 20;
         }

         boolean thePlayerIsDrivingThis = this.field_70170_p.field_72995_K && this.seats[0] != null && this.seats[0].field_70153_n instanceof EntityPlayer && FlansMod.proxy.isThePlayer((EntityPlayer)this.seats[0].field_70153_n);
         ++this.ticksSinceUsed;
         if (!this.field_70170_p.field_72995_K && this.seats[0].field_70153_n != null) {
            this.ticksSinceUsed = 0;
         }

         if (!this.field_70170_p.field_72995_K && TeamsManager.vehicleLife > 0 && this.ticksSinceUsed > TeamsManager.vehicleLife * 20) {
            this.func_70106_y();
         }

         if (this.field_70170_p.field_72995_K && (this.varFlare || this.ticksFlareUsing > type.timeFlareUsing * 20 - 5) && this.field_70173_aa % 5 == 0) {
            this.deployedSmoke = true;
         }

         if (type.setPlayerInvisible && !this.field_70170_p.field_72995_K && this.seats[0].field_70153_n != null) {
            this.seats[0].field_70153_n.func_82142_c(true);
         }

         if (this.ticksFlareUsing <= 0) {
            this.deployedSmoke = false;
         }

         if (this.ticksFlareUsing > 0) {
            --this.ticksFlareUsing;
            if (this.getDriveableType().needsThrottle) {
               this.throttle = (float)(this.ticksFlareUsing * this.ticksFlareUsing * this.ticksFlareUsing) * 1.25E-4F - 0.1F;
            }
         }

         if (this.flareDelay > 0) {
            --this.flareDelay;
         }

         if (this.shellDelay > 0) {
            --this.shellDelay;
         }

         if (this.gunDelay > 0) {
            --this.gunDelay;
         }

         if (this.toggleTimer > 0) {
            --this.toggleTimer;
         }

         if (this.soundPosition > 0) {
            --this.soundPosition;
         }

         if (this.idlePosition > 0) {
            --this.idlePosition;
         }

         if (type.tank && !this.hasBothTracks()) {
            this.throttle = 0.0F;
         }

         if (this.disabled) {
            this.wheelsYaw = 0.0F;
         }

         if (this.hasEnoughFuel()) {
            this.wheelsAngle += this.throttle / 7.0F;
         }

         if (!this.varDoor) {
            this.doorPos = this.transformPart(this.doorPos, type.doorPos1, type.doorRate);
            this.doorRot = this.transformPart(this.doorRot, type.doorRot1, type.doorRotRate);
         } else {
            this.doorPos = this.transformPart(this.doorPos, type.doorPos2, type.doorRate);
            this.doorRot = this.transformPart(this.doorRot, type.doorRot2, type.doorRotRate);
         }

         this.wheelsYaw *= 0.9F;
         if (this.wheelsYaw > 20.0F) {
            this.wheelsYaw = 20.0F;
         }

         if (this.wheelsYaw < -20.0F) {
            this.wheelsYaw = -20.0F;
         }

         float velocityScale;
         if (this.field_70170_p.field_72995_K && !thePlayerIsDrivingThis && this.serverPositionTransitionTicker > 0) {
            double x = this.field_70165_t + (this.field_70118_ct - this.field_70165_t) / (double)this.serverPositionTransitionTicker;
            double y = this.field_70163_u + (this.field_70117_cu - this.field_70163_u) / (double)this.serverPositionTransitionTicker;
            double z = this.field_70161_v + (this.field_70116_cv - this.field_70161_v) / (double)this.serverPositionTransitionTicker;
            double dYaw = MathHelper.func_76138_g(this.serverYaw - (double)this.axes.getYaw());
            double dPitch = MathHelper.func_76138_g(this.serverPitch - (double)this.axes.getPitch());
            double dRoll = MathHelper.func_76138_g(this.serverRoll - (double)this.axes.getRoll());
            this.field_70177_z = (float)((double)this.axes.getYaw() + dYaw / (double)this.serverPositionTransitionTicker);
            this.field_70125_A = (float)((double)this.axes.getPitch() + dPitch / (double)this.serverPositionTransitionTicker);
            velocityScale = (float)((double)this.axes.getRoll() + dRoll / (double)this.serverPositionTransitionTicker);
            --this.serverPositionTransitionTicker;
            this.func_70107_b(x, y, z);
            this.setRotation(this.field_70177_z, this.field_70125_A, velocityScale);
         }

         this.correctWheelPos();
         Vector3f amountToMoveCar = new Vector3f();
         EntityWheel[] var7 = this.wheels;
         int var31 = var7.length;

         float turningDrag;
         float avgWheelHeight;
         float gas;
         float velocityScale;
         for(int var9 = 0; var9 < var31; ++var9) {
            EntityWheel wheel = var7[var9];
            if (wheel != null) {
               double prevPosYWheel = wheel.field_70163_u;
               this.field_70122_E = true;
               wheel.field_70122_E = true;
               List<Entity> shipsCheck = this.field_70170_p.func_72872_a(Entity.class, wheel.field_70121_D);
               boolean onShip = false;
               Iterator var15 = shipsCheck.iterator();

               while(var15.hasNext()) {
                  Entity ship = (Entity)var15.next();
                  if (this.getClass().toString().indexOf("cuchaz.ships.EntityShip") > 0) {
                     wheel.field_70122_E = true;
                     onShip = true;
                  }
               }

               wheel.field_70177_z = this.axes.getYaw();
               if (!type.tank && (wheel.ID == 2 || wheel.ID == 3)) {
                  wheel.field_70177_z += this.wheelsYaw;
               }

               wheel.field_70159_w *= 0.8999999761581421D;
               wheel.field_70181_x *= this.field_70163_u - bkPrevPosY < 0.0D ? 0.9990000128746033D : 0.8999999761581421D;
               wheel.field_70179_y *= 0.8999999761581421D;
               boolean canThrustCreatively = !TeamsManager.vehiclesNeedFuel || this.seats != null && this.seats[0] != null && this.seats[0].field_70153_n instanceof EntityPlayer && ((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d;
               if (canThrustCreatively || data.fuelInTank > data.engine.fuelConsumption * this.throttle) {
                  if (this.getVehicleType().tank) {
                     boolean left = wheel.ID == 0 || wheel.ID == 3;
                     turningDrag = 0.02F;
                     wheel.field_70159_w *= (double)(1.0F - Math.abs(this.wheelsYaw) * turningDrag);
                     wheel.field_70179_y *= (double)(1.0F - Math.abs(this.wheelsYaw) * turningDrag);
                     velocityScale = 0.04F * (this.throttle > 0.0F ? type.maxThrottle : type.maxNegativeThrottle) * data.engine.engineSpeed;
                     avgWheelHeight = 0.1F * (this.wheelsYaw > 0.0F ? type.turnLeftModifier : type.turnRightModifier);
                     gas = (this.throttle + this.wheelsYaw * (float)(left ? 1 : -1) * avgWheelHeight) * velocityScale;
                     wheel.field_70159_w += (double)gas * Math.cos((double)(wheel.field_70177_z * 3.1415927F / 180.0F));
                     wheel.field_70179_y += (double)gas * Math.sin((double)(wheel.field_70177_z * 3.1415927F / 180.0F));
                     this.yawSpeed = (float)((double)this.yawSpeed + (double)gas * Math.sin((double)(wheel.field_70177_z * 3.1415927F / 180.0F)));
                  } else {
                     velocityScale = 0.1F * this.throttle * (this.throttle > 0.0F ? type.maxThrottle : type.maxNegativeThrottle) * data.engine.engineSpeed;
                     wheel.field_70159_w += Math.cos((double)(wheel.field_70177_z * 3.1415927F / 180.0F)) * (double)velocityScale;
                     wheel.field_70179_y += Math.sin((double)(wheel.field_70177_z * 3.1415927F / 180.0F)) * (double)velocityScale;
                     if (wheel.ID != 2 && wheel.ID != 3) {
                        wheel.field_70159_w *= 0.8999999761581421D;
                        wheel.field_70179_y *= 0.8999999761581421D;
                     } else {
                        velocityScale = 0.01F * (this.wheelsYaw > 0.0F ? type.turnLeftModifier : type.turnRightModifier) * (float)(this.throttle > 0.0F ? 1 : -1);
                        wheel.field_70159_w -= wheel.getSpeedXZ() * Math.sin((double)(wheel.field_70177_z * 3.1415927F / 180.0F)) * (double)velocityScale * (double)this.wheelsYaw;
                        wheel.field_70179_y += wheel.getSpeedXZ() * Math.cos((double)(wheel.field_70177_z * 3.1415927F / 180.0F)) * (double)velocityScale * (double)this.wheelsYaw;
                     }
                  }
               }

               wheel.func_70091_d(wheel.field_70159_w, wheel.field_70181_x, wheel.field_70179_y);
               Vector3f targetWheelPos = this.axes.findLocalVectorGlobally(this.getVehicleType().wheelPositions[wheel.ID].position);
               Vector3f currentWheelPos = new Vector3f(wheel.field_70165_t - this.field_70165_t, wheel.field_70163_u - this.field_70163_u, wheel.field_70161_v - this.field_70161_v);
               Vector3f dPos = (Vector3f)Vector3f.sub(targetWheelPos, currentWheelPos, (Vector3f)null).scale(type.wheelSpringStrength);
               if (dPos.length() > 0.001F) {
                  wheel.func_70091_d((double)dPos.x, (double)dPos.y, (double)dPos.z);
                  dPos.scale(0.5F);
                  Vector3f.sub(amountToMoveCar, dPos, amountToMoveCar);
               }

               avgWheelHeight = 0.0F;
               if (this.wheels[0] != null && this.wheels[1] != null && this.wheels[2] != null && this.wheels[3] != null) {
                  avgWheelHeight = (float)(this.wheels[0].field_70165_t + this.wheels[1].field_70165_t + this.wheels[2].field_70165_t + this.wheels[3].field_70165_t) / 4.0F;
                  if (!this.wheels[0].field_70122_E && !this.wheels[1].field_70122_E && !this.wheels[2].field_70122_E && !this.wheels[3].field_70122_E) {
                     this.allWheelsOnGround = false;
                  } else {
                     this.allWheelsOnGround = true;
                  }
               }

               gas = (float)((DriveablePart)this.getDriveableData().parts.get(EnumDriveablePart.gasbag)).health / (float)((DriveablePart)this.getDriveableData().parts.get(EnumDriveablePart.gasbag)).maxHealth * 1.0F;
               if (((DriveablePart)this.getDriveableData().parts.get(EnumDriveablePart.gasbag)).maxHealth == 0) {
                  gas = 1.0F;
               }

               if ((double)data.depth > 0.01D && (float)((DriveablePart)this.getDriveableData().parts.get(EnumDriveablePart.core)).health > 0.0F) {
                  data.depth = 0.0F;
               }

               if ((double)type.seaLevel - this.field_70163_u > 2.0D) {
                  if (!type.unlimitedOxygen) {
                     --this.oxygenMeter;
                  }

                  if (this.oxygenMeter < 0.0F) {
                     this.oxygenMeter = 0.0F;
                  }
               }

               if ((double)type.seaLevel - this.field_70163_u < 2.0D && (float)((DriveablePart)this.getDriveableData().parts.get(EnumDriveablePart.core)).health > 0.0F) {
                  this.oxygenMeter += 15.0F;
                  if (this.oxygenMeter > type.maxOxygen) {
                     this.oxygenMeter = type.maxOxygen;
                  }
               }

               if ((double)type.seaLevel - this.field_70163_u > (double)type.maxDepth && type.canDive) {
                  this.attackPart(EnumDriveablePart.core, DamageSource.field_76367_g, 10.0F);
               }

               if (this.allWheelsOnGround && (!type.floatOnWater || !this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(-type.floatOffset), 0.0D))) && !wheel.onDeck && !type.canDive && !type.airship) {
                  wheel.func_70091_d(0.0D, !this.onDeck ? -0.19600000977516174D : 0.0D, 0.0D);
               } else if (type.floatOnWater && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(-type.floatOffset), 0.0D)) && !type.canDive && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(1.0F - type.floatOffset), 0.0D)) && !wheel.onDeck && (float)((DriveablePart)this.getDriveableData().parts.get(EnumDriveablePart.core)).health > 0.0F) {
                  wheel.func_70091_d(0.0D, 0.5D, 0.0D);
                  data.depth = 0.0F;
               } else if (type.floatOnWater && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(-type.floatOffset), 0.0D)) && type.canDive && !type.airship && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(1.0F - type.floatOffset), 0.0D)) && this.divingFactor > 0.0F && this.seats[0].field_70153_n instanceof EntityPlayer && this.oxygenMeter > 0.1F) {
                  wheel.func_70091_d(0.0D, (double)type.surfaceSpeed * 0.5D * (double)this.divingFactor, 0.0D);
                  data.depth = (float)((double)data.depth + (double)type.surfaceSpeed * 0.5D * (double)this.divingFactor * 0.16666D);
               } else if (type.floatOnWater && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(-type.floatOffset), 0.0D)) && type.canDive && !type.airship && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(1.0F - type.floatOffset), 0.0D)) && this.divingFactor > 0.0F && this.seats[0].field_70153_n instanceof EntityPlayer && this.oxygenMeter < 0.1F) {
                  wheel.func_70091_d(0.0D, (double)type.surfaceSpeed * 0.5D * 1.0D, 0.0D);
                  data.depth = (float)((double)data.depth + (double)type.surfaceSpeed * 0.5D * 1.0D * 0.16666D);
               } else if (type.floatOnWater && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(-type.floatOffset), 0.0D)) && type.canDive && !type.airship && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(1.0F - type.floatOffset), 0.0D)) && this.divingFactor < 0.0F && this.seats[0].field_70153_n instanceof EntityPlayer && this.oxygenMeter > 0.1F) {
                  wheel.func_70091_d(0.0D, (double)type.diveSpeed * 0.5D * (double)this.divingFactor, 0.0D);
                  data.depth = (float)((double)data.depth + (double)type.diveSpeed * 0.5D * (double)this.divingFactor * 0.16666D);
               } else if (type.floatOnWater && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(-type.floatOffset), 0.0D)) && type.canDive && !type.airship && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(1.0F - type.floatOffset), 0.0D)) && this.divingFactor < 0.0F && this.seats[0].field_70153_n instanceof EntityPlayer && this.oxygenMeter < 0.1F) {
                  wheel.func_70091_d(0.0D, (double)type.diveSpeed * 0.5D * 1.0D, 0.0D);
                  data.depth = (float)((double)data.depth + (double)type.diveSpeed * 0.5D * 1.0D * 0.16666D);
               } else if (!this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(-type.floatOffset), 0.0D)) && !type.canDive && type.airship && !this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(1.0F - type.floatOffset), 0.0D)) && (double)this.divingFactor > 0.1D && this.field_70163_u < (double)type.maxAltitude && this.seats[0].field_70153_n instanceof EntityPlayer) {
                  wheel.func_70091_d(0.0D, (double)this.divingFactor * (double)type.surfaceSpeed * 0.5D * (double)(2.0F * gas - 1.0F), 0.0D);
               } else if (!this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(-type.floatOffset), 0.0D)) && !type.canDive && type.airship && !this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(1.0F - type.floatOffset), 0.0D)) && (double)this.divingFactor < -0.1D && this.seats[0].field_70153_n instanceof EntityPlayer) {
                  wheel.func_70091_d(0.0D, (double)this.divingFactor * (double)type.diveSpeed * 0.5D * (double)(2.0F - gas * 1.0F), 0.0D);
               } else if (!this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(-type.floatOffset), 0.0D)) && !type.canDive && type.airship && !this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(1.0F - type.floatOffset), 0.0D)) && (double)this.divingFactor > -0.1D && (double)this.divingFactor < 0.1D) {
                  wheel.func_70091_d(0.0D, 0.5D * (double)(gas - 1.0F), 0.0D);
               } else if (type.floatOnWater && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(-type.floatOffset), 0.0D)) && type.canDive && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(1.0F - type.floatOffset), 0.0D)) && this.oxygenMeter > 0.1F) {
                  wheel.func_70091_d(0.0D, 0.0D, 0.0D);
               } else if (type.floatOnWater && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(-type.floatOffset), 0.0D)) && type.canDive && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(1.0F - type.floatOffset), 0.0D)) && this.oxygenMeter < 0.1F) {
                  wheel.func_70091_d(0.0D, (double)type.surfaceSpeed * 0.6D * 1.0D, 0.0D);
               } else if ((!type.floatOnWater || !this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(-type.floatOffset), 0.0D)) || this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (double)(1.0F - type.floatOffset), 0.0D)) || type.canDive) && (!wheel.onDeck || type.canDive)) {
                  if (wheel.onDeck && type.canDive && this.divingFactor < 0.0F && (float)((DriveablePart)this.getDriveableData().parts.get(EnumDriveablePart.core)).health > 0.0F) {
                     this.divingFactor = -0.3F;
                     data.depth = 0.0F;
                     this.roll = 0.0F;
                     this.pitch = 0.0F;
                  } else {
                     wheel.func_70091_d(0.0D, !this.onDeck ? -0.9800000190734863D : 0.0D, 0.0D);
                  }
               } else {
                  wheel.func_70091_d(0.0D, 0.0D, 0.0D);
               }

               if (((double)this.throttle >= 1.1D || (double)this.throttle <= -1.1D) && wheel.getSpeedXYZ() <= (double)(this.getAvgWheelSpeedXYZ() / 1.0F)) {
                  this.throttle = 1.0F;
               }
            }
         }

         if (this.wheels[0] != null && this.wheels[1] != null && this.wheels[2] != null && this.wheels[3] != null) {
            this.lastPos.x = (float)(this.wheels[0].field_70159_w + this.wheels[1].field_70159_w + this.wheels[2].field_70159_w + this.wheels[3].field_70159_w) / 4.0F;
            this.lastPos.y = (float)(this.wheels[0].field_70181_x + this.wheels[1].field_70181_x + this.wheels[2].field_70181_x + this.wheels[3].field_70181_x) / 4.0F;
            this.lastPos.z = (float)(this.wheels[0].field_70179_y + this.wheels[1].field_70179_y + this.wheels[2].field_70179_y + this.wheels[3].field_70179_y) / 4.0F;
         }

         double bmy = this.field_70181_x;
         this.field_70181_x = (double)amountToMoveCar.y;
         this.func_70091_d((double)amountToMoveCar.x, (double)amountToMoveCar.y, (double)amountToMoveCar.z);
         this.field_70181_x = bmy;
         if (this.wheels[0] != null && this.wheels[1] != null && this.wheels[2] != null && this.wheels[3] != null) {
            Vector3f frontAxleCentre = new Vector3f((this.wheels[2].field_70165_t + this.wheels[3].field_70165_t) / 2.0D, (this.wheels[2].field_70163_u + this.wheels[3].field_70163_u) / 2.0D, (this.wheels[2].field_70161_v + this.wheels[3].field_70161_v) / 2.0D);
            Vector3f backAxleCentre = new Vector3f((this.wheels[0].field_70165_t + this.wheels[1].field_70165_t) / 2.0D, (this.wheels[0].field_70163_u + this.wheels[1].field_70163_u) / 2.0D, (this.wheels[0].field_70161_v + this.wheels[1].field_70161_v) / 2.0D);
            Vector3f leftSideCentre = new Vector3f((this.wheels[0].field_70165_t + this.wheels[3].field_70165_t) / 2.0D, (this.wheels[0].field_70163_u + this.wheels[3].field_70163_u) / 2.0D, (this.wheels[0].field_70161_v + this.wheels[3].field_70161_v) / 2.0D);
            Vector3f rightSideCentre = new Vector3f((this.wheels[1].field_70165_t + this.wheels[2].field_70165_t) / 2.0D, (this.wheels[1].field_70163_u + this.wheels[2].field_70163_u) / 2.0D, (this.wheels[1].field_70161_v + this.wheels[2].field_70161_v) / 2.0D);
            float dx = frontAxleCentre.x - backAxleCentre.x;
            float dy = frontAxleCentre.y - backAxleCentre.y;
            float dz = frontAxleCentre.z - backAxleCentre.z;
            velocityScale = leftSideCentre.x - rightSideCentre.x;
            turningDrag = leftSideCentre.y - rightSideCentre.y;
            velocityScale = leftSideCentre.z - rightSideCentre.z;
            avgWheelHeight = (float)Math.sqrt((double)(dx * dx + dz * dz));
            gas = (float)Math.sqrt((double)(velocityScale * velocityScale + velocityScale * velocityScale));
            float tyaw = (float)Math.atan2((double)dz, (double)dx);
            float tpitch = -((float)Math.atan2((double)dy, (double)avgWheelHeight));
            float troll = 0.0F;
            if (type.canRoll) {
               troll = -((float)Math.atan2((double)turningDrag, (double)gas));
            }

            this.yaw = tyaw;
            this.pitch = this.Lerp(this.pitch, tpitch, 0.2F);
            this.roll = this.Lerp(this.roll, troll, 0.2F);
            float velocityScale;
            float steeringScale;
            float effectiveWheelSpeed;
            if (type.tank) {
               velocityScale = 0.04F * (this.throttle > 0.0F ? type.maxThrottle : type.maxNegativeThrottle) * data.engine.engineSpeed;
               steeringScale = 0.1F * (this.wheelsYaw > 0.0F ? type.turnLeftModifier : type.turnRightModifier);
               effectiveWheelSpeed = this.wheelsYaw * steeringScale * velocityScale;
               this.yaw = this.axes.getYaw() / 180.0F * 3.14159F + effectiveWheelSpeed;
            } else {
               velocityScale = 0.1F * this.throttle * (this.throttle > 0.0F ? type.maxThrottle : type.maxNegativeThrottle) * data.engine.engineSpeed;
               steeringScale = 0.1F * (this.wheelsYaw > 0.0F ? type.turnLeftModifier : type.turnRightModifier);
               effectiveWheelSpeed = this.wheelsYaw * steeringScale * velocityScale;
               this.yaw = this.axes.getYaw() / 180.0F * 3.14159F + effectiveWheelSpeed;
            }

            this.axes.setAngles(this.yaw * 180.0F / 3.14159F, this.pitch * 180.0F / 3.14159F, this.roll * 180.0F / 3.14159F);
         }

         if (this.field_70154_o != null && this.field_70154_o.getClass().toString().indexOf("mcheli.aircraft.MCH_EntitySeat") > 0) {
            this.axes.setAngles(this.field_70154_o.field_70177_z + 90.0F, 0.0F, 0.0F);
         }

         this.checkForCollisions();
         if (Math.abs(this.throttle) > 0.01F && Math.abs(this.throttle) < 0.2F && this.soundPosition == 0 && this.hasEnoughFuel()) {
            PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, (double)type.startSoundRange, this.field_71093_bK, type.startSound, false);
            this.soundPosition = type.startSoundLength;
         }

         if (this.throttle >= 0.2F && this.soundPosition == 0 && this.hasEnoughFuel()) {
            PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, (double)type.engineSoundRange, this.field_71093_bK, type.engineSound, false);
            this.soundPosition = type.engineSoundLength;
         }

         if (this.seats[0] != null && this.throttle <= 0.01F && this.throttle >= -0.2F && this.seats[0].field_70153_n != null && this.idlePosition == 0) {
            PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, (double)type.engineSoundRange, this.field_71093_bK, type.idleSound, false);
            this.idlePosition = type.idleSoundLength;
         }

         if (this.throttle <= -0.2F && this.soundPosition == 0 && this.hasEnoughFuel()) {
            PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, (double)type.backSoundRange, this.field_71093_bK, type.backSound, false);
            this.soundPosition = type.backSoundLength;
         }

         EntitySeat[] var33 = this.seats;
         int var37 = var33.length;

         for(int var40 = 0; var40 < var37; ++var40) {
            EntitySeat seat = var33[var40];
            if (seat != null) {
               seat.updatePosition();
            }
         }

         if (thePlayerIsDrivingThis) {
            FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketVehicleControl(this)));
            this.field_70118_ct = this.field_70165_t;
            this.field_70117_cu = this.field_70163_u;
            this.field_70116_cv = this.field_70161_v;
            this.serverYaw = (double)this.axes.getYaw();
         }

         if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 5 == 0) {
            FlansMod.getPacketHandler().sendToAllAround(new PacketVehicleControl(this), this.field_70165_t, this.field_70163_u, this.field_70161_v, 400.0F, this.field_71093_bK);
         }

         int animSpeed = 4;
         if ((!((double)this.throttle > 0.05D) || !((double)this.throttle <= 0.33D)) && (!((double)this.throttle < -0.05D) || !((double)this.throttle >= -0.33D))) {
            if ((!((double)this.throttle > 0.33D) || !((double)this.throttle <= 0.66D)) && (!((double)this.throttle < -0.33D) || !((double)this.throttle >= -0.66D))) {
               if ((double)this.throttle > 0.66D && (double)this.throttle <= 0.9D || (double)this.throttle < -0.66D && (double)this.throttle >= -0.9D) {
                  animSpeed = 1;
               } else if ((double)this.throttle > 0.9D && this.throttle <= 1.0F || (double)this.throttle < -0.9D && this.throttle >= -1.0F) {
                  animSpeed = 0;
               }
            } else {
               animSpeed = 2;
            }
         } else {
            animSpeed = 3;
         }

         boolean turningLeft = false;
         boolean turningRight = false;
         if ((double)this.throttle > 0.05D) {
            --this.animCountLeft;
            --this.animCountRight;
         } else if ((double)this.throttle < -0.05D) {
            ++this.animCountLeft;
            ++this.animCountRight;
         } else if (this.wheelsYaw < -1.0F) {
            turningLeft = true;
            ++this.animCountLeft;
            --this.animCountRight;
            animSpeed = 1;
            if (this.soundPosition == 0 && this.hasEnoughFuel() && type.tank) {
               PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, (double)type.engineSoundRange, this.field_71093_bK, type.engineSound, false);
               this.soundPosition = type.engineSoundLength;
            }
         } else if (this.wheelsYaw > 1.0F) {
            turningRight = true;
            --this.animCountLeft;
            ++this.animCountRight;
            animSpeed = 1;
            if (this.soundPosition == 0 && this.hasEnoughFuel() && type.tank) {
               PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, (double)type.engineSoundRange, this.field_71093_bK, type.engineSound, false);
               this.soundPosition = type.engineSoundLength;
            }
         } else {
            turningLeft = false;
            turningRight = false;
         }

         if (this.animCountLeft <= 0) {
            this.animCountLeft = animSpeed;
            ++this.animFrameLeft;
         }

         if (this.animCountRight <= 0) {
            this.animCountRight = animSpeed;
            ++this.animFrameRight;
         }

         if ((this.throttle < 0.0F || turningLeft) && this.animCountLeft >= animSpeed) {
            this.animCountLeft = 0;
            --this.animFrameLeft;
         }

         if ((this.throttle < 0.0F || turningRight) && this.animCountRight >= animSpeed) {
            this.animCountRight = 0;
            --this.animFrameRight;
         }

         if (this.animFrameLeft > type.animFrames) {
            this.animFrameLeft = 0;
         }

         if (this.animFrameLeft < 0) {
            this.animFrameLeft = type.animFrames;
         }

         if (this.animFrameRight > type.animFrames) {
            this.animFrameRight = 0;
         }

         if (this.animFrameRight < 0) {
            this.animFrameRight = type.animFrames;
         }

      }
   }

   private void interrupt(float f) {
   }

   public void animateFancyTracks() {
      float funkypart = (float)this.getVehicleType().trackLinkFix;
      boolean funk = true;
      float funk2 = 0.0F;

      AnimTrackLink var10000;
      int i;
      float speed;
      float newAngle;
      int part;
      for(i = 0; i < this.trackLinksLeft.length; ++i) {
         this.trackLinksLeft[i].prevPosition = this.trackLinksLeft[i].position;
         this.trackLinksLeft[i].prevZRot = this.trackLinksLeft[i].zRot;
         speed = this.throttle * 1.5F - this.wheelsYaw / 12.0F;
         var10000 = this.trackLinksLeft[i];
         var10000.progress += speed;
         if (this.trackLinksLeft[i].progress > this.leftTrack.getTrackLength()) {
            var10000 = this.trackLinksLeft[i];
            var10000.progress -= this.leftTrack.getTrackLength();
         }

         if (this.trackLinksLeft[i].progress < 0.0F) {
            var10000 = this.trackLinksLeft[i];
            var10000.progress += this.leftTrack.getTrackLength();
         }

         for(this.trackLinksLeft[i].position = this.leftTrack.getPositionOnTrack(this.trackLinksLeft[i].progress); this.trackLinksLeft[i].zRot > 180.0F; var10000.zRot -= 360.0F) {
            var10000 = this.trackLinksLeft[i];
         }

         while(this.trackLinksLeft[i].zRot <= -180.0F) {
            var10000 = this.trackLinksLeft[i];
            var10000.zRot += 360.0F;
         }

         newAngle = this.rotateTowards((Vector3f)this.leftTrack.points.get(this.leftTrack.getTrackPart(this.trackLinksLeft[i].progress)), this.trackLinksLeft[i].position);
         part = this.leftTrack.getTrackPart(this.trackLinksLeft[i].progress);
         if (funk) {
            funk2 = speed < 0.0F ? 0.0F : 1.0F;
         } else {
            funk2 = speed < 0.0F ? -1.0F : 0.0F;
         }

         this.trackLinksLeft[i].zRot = this.Lerp(this.trackLinksLeft[i].zRot, newAngle, (float)part != funkypart + funk2 ? 0.5F : 1.0F);
      }

      for(i = 0; i < this.trackLinksRight.length; ++i) {
         this.trackLinksRight[i].prevPosition = this.trackLinksRight[i].position;
         this.trackLinksRight[i].prevZRot = this.trackLinksRight[i].zRot;
         speed = this.throttle * 1.5F + this.wheelsYaw / 12.0F;
         var10000 = this.trackLinksRight[i];
         var10000.progress += speed;
         if (this.trackLinksRight[i].progress > this.rightTrack.getTrackLength()) {
            var10000 = this.trackLinksRight[i];
            var10000.progress -= this.leftTrack.getTrackLength();
         }

         if (this.trackLinksRight[i].progress < 0.0F) {
            var10000 = this.trackLinksRight[i];
            var10000.progress += this.rightTrack.getTrackLength();
         }

         this.trackLinksRight[i].position = this.rightTrack.getPositionOnTrack(this.trackLinksRight[i].progress);
         newAngle = this.rotateTowards((Vector3f)this.rightTrack.points.get(this.rightTrack.getTrackPart(this.trackLinksRight[i].progress)), this.trackLinksRight[i].position);
         part = this.rightTrack.getTrackPart(this.trackLinksRight[i].progress);
         if (funk) {
            funk2 = speed < 0.0F ? 0.0F : 1.0F;
         } else {
            funk2 = speed < 0.0F ? -1.0F : 0.0F;
         }

         this.trackLinksRight[i].zRot = this.Lerp(this.trackLinksRight[i].zRot, newAngle, (float)part != funkypart + funk2 ? 0.5F : 1.0F);
      }

   }

   public float rotateTowards(Vector3f point, Vector3f original) {
      float angle = (float)Math.atan2((double)(point.y - original.y), (double)(point.x - original.x));
      return angle;
   }

   public void dischargeSmoke() {
      VehicleType type = this.getVehicleType();

      for(int i = 0; i < type.smokers.size(); ++i) {
         VehicleType.SmokePoint smoker = (VehicleType.SmokePoint)type.smokers.get(i);
         Vector3f dir = smoker.direction;
         Vector3f pos = smoker.position;
         int time = smoker.detTime;
         dir = this.axes.findLocalVectorGlobally(dir);
         pos = this.axes.findLocalVectorGlobally(pos);
         if (EnumDriveablePart.getPart(smoker.part) == EnumDriveablePart.turret) {
            dir = this.rotate(this.seats[0].looking.findLocalVectorGlobally(smoker.direction));
            pos = this.getPositionOnTurret(smoker.position, false);
         }

         FlansMod.getPacketHandler().sendToAllAround(new PacketParticle("flansmod.smoker", this.field_70165_t + (double)(pos.x / 16.0F), this.field_70163_u + (double)(pos.y / 16.0F), this.field_70161_v + (double)(pos.z / 16.0F), (double)dir.x, (double)dir.y, (double)dir.z), this.field_70165_t, this.field_70163_u, this.field_70161_v, 150.0F, this.field_71093_bK);
      }

   }

   public float Lerp(float start, float end, float percent) {
      float result = start + percent * (end - start);
      return result;
   }

   public static float Clamp(float val, float min, float max) {
      return Math.max(min, Math.min(max, val));
   }

   public List<Entity> findEntitiesWithinbounds() {
      VehicleType type = this.getVehicleType();
      AxisAlignedBB initialBox = this.field_70121_D.func_72329_c();
      List<Entity> riddenEntities = this.field_70170_p.func_72872_a(Entity.class, initialBox);
      Vector3f size = new Vector3f(type.harvestBoxSize.x / 8.0F, type.harvestBoxSize.y / 8.0F, type.harvestBoxSize.z / 8.0F);
      Vector3f pos = new Vector3f(type.harvestBoxPos.x / 8.0F, type.harvestBoxPos.y / 8.0F, type.harvestBoxPos.z / 8.0F);

      for(float x = pos.x; x <= pos.x + size.x; ++x) {
         for(float y = pos.y; y <= pos.y + size.y; ++y) {
            for(float z = pos.z; z <= pos.z + size.z; ++z) {
               Vector3f v = this.axes.findLocalVectorGlobally(new Vector3f(x, y, z));
               double var10000 = this.field_70165_t + (double)v.x;
               var10000 = this.field_70163_u + (double)v.y;
               var10000 = this.field_70161_v + (double)v.z;
               AxisAlignedBB checkBox = this.field_70121_D.func_72329_c().func_72317_d((double)v.x, (double)v.y, (double)v.z);
               List<Entity> entityhere = this.field_70170_p.func_72872_a(Entity.class, checkBox);

               for(int i = 0; i < entityhere.size(); ++i) {
                  if (entityhere.get(i) instanceof EntityLivingBase) {
                     riddenEntities.add(entityhere.get(i));
                  }
               }
            }
         }
      }

      return riddenEntities;
   }

   public Vector3f transformPart(Vector3f current, Vector3f target, Vector3f rate) {
      if (Math.sqrt((double)((current.x - target.x) * (current.x - target.x))) > (double)(rate.x / 2.0F)) {
         if (current.x > target.x) {
            current.x -= rate.x;
         } else if (current.x < target.x) {
            current.x += rate.x;
         }
      } else {
         current.x = target.x;
      }

      if (Math.sqrt((double)((current.y - target.y) * (current.y - target.y))) > (double)(rate.y / 2.0F)) {
         if (current.y > target.y) {
            current.y -= rate.y;
         } else if (current.y < target.y) {
            current.y += rate.y;
         }
      } else {
         current.y = target.y;
      }

      if (Math.sqrt((double)((current.z - target.z) * (current.z - target.z))) > (double)(rate.z / 2.0F)) {
         if (current.z > target.z) {
            current.z -= rate.z;
         } else if (current.z < target.z) {
            current.z += rate.z;
         }
      } else {
         current.z = target.z;
      }

      return current;
   }

   protected void func_70069_a(float k) {
      if (!(k <= 10.0F)) {
         float damage = (float)(MathHelper.func_76123_f(k) * 2);
         boolean no_damage = true;
         if (damage > 0.0F && this.invulnerableUnmountCount == 0 && this.field_70173_aa > 20) {
            DriveableType type = this.getDriveableType();
            damage = (float)((int)(damage * type.fallDamageFactor));
            this.attackPart(EnumDriveablePart.core, DamageSource.field_76379_h, damage);
            if (type.wheelPositions.length > 0) {
               this.attackPart(type.wheelPositions[0].part, DamageSource.field_76379_h, damage / 5.0F);
            }

            no_damage = false;
         }

      }
   }

   private float averageAngles(float a, float b) {
      FlansMod.log("Pre  " + a + " " + b);

      float pi;
      for(pi = 3.1415927F; a > b + pi; a -= 2.0F * pi) {
      }

      while(a < b - pi) {
         a += 2.0F * pi;
      }

      float avg;
      for(avg = (a + b) / 2.0F; avg > pi; avg -= 2.0F * pi) {
      }

      while(avg < -pi) {
         avg += 2.0F * pi;
      }

      FlansMod.log("Post " + a + " " + b + " " + avg);
      return avg;
   }

   private Vec3 subtract(Vec3 a, Vec3 b) {
      return Vec3.func_72443_a(a.field_72450_a - b.field_72450_a, a.field_72448_b - b.field_72448_b, a.field_72449_c - b.field_72449_c);
   }

   private Vec3 crossProduct(Vec3 a, Vec3 b) {
      return Vec3.func_72443_a(a.field_72448_b * b.field_72449_c - a.field_72449_c * b.field_72448_b, a.field_72449_c * b.field_72450_a - a.field_72450_a * b.field_72449_c, a.field_72450_a * b.field_72448_b - a.field_72448_b * b.field_72450_a);
   }

   public boolean landVehicle() {
      return true;
   }

   public boolean func_70097_a(DamageSource damagesource, float i) {
      if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
         VehicleType type = this.getVehicleType();
         if (damagesource.field_76373_n.equals("player") && damagesource.func_76346_g().field_70122_E && (this.seats[0] == null || this.seats[0].field_70153_n == null) && !this.locked) {
            ItemStack vehicleStack = new ItemStack(type.item, 1, 0);
            vehicleStack.field_77990_d = new NBTTagCompound();
            this.driveableData.writeToNBT(vehicleStack.field_77990_d);
            this.func_70099_a(vehicleStack, 0.5F);
            this.func_70106_y();
         }

         return super.func_70097_a(damagesource, i);
      } else {
         return true;
      }
   }

   public VehicleType getVehicleType() {
      return VehicleType.getVehicle(this.driveableType);
   }

   public float getPlayerRoll() {
      return this.axes.getRoll();
   }

   public float getAvgWheelSpeedXYZ() {
      float speed = (float)(this.wheels[0].getSpeedXYZ() + this.wheels[1].getSpeedXYZ() + this.wheels[2].getSpeedXYZ() + this.wheels[3].getSpeedXYZ()) / 4.0F;
      return speed;
   }

   public void Recoil() {
   }

   protected void dropItemsOnPartDeath(Vector3f midpoint, DriveablePart part) {
   }

   public String getBombInventoryName() {
      return "Mines";
   }

   public String getMissileInventoryName() {
      return "Shells";
   }

   public boolean hasMouseControlMode() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public EntityLivingBase getCamera() {
      return null;
   }

   public boolean hasBothTracks() {
      boolean tracks = true;
      if (!this.isPartIntact(EnumDriveablePart.leftTrack)) {
         tracks = false;
      }

      if (!this.isPartIntact(EnumDriveablePart.rightTrack)) {
         tracks = false;
      }

      return tracks;
   }

   public void func_70106_y() {
      super.func_70106_y();
      EntityWheel[] var1 = this.wheels;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         EntityWheel wheel = var1[var3];
         if (wheel != null) {
            wheel.func_70106_y();
         }
      }

   }
}
