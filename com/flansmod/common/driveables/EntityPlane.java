package com.flansmod.common.driveables;

import com.flansmod.client.model.animation.AnimationController;
import com.flansmod.client.model.animation.AnimationPart;
import com.flansmod.common.FlansMod;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketDriveableControl;
import com.flansmod.common.network.PacketDriveableKey;
import com.flansmod.common.network.PacketParticle;
import com.flansmod.common.network.PacketPlaneAnimator;
import com.flansmod.common.network.PacketPlaneControl;
import com.flansmod.common.network.PacketPlaySound;
import com.flansmod.common.teams.TeamsManager;
import com.flansmod.common.tools.ItemTool;
import com.flansmod.common.vector.Matrix4f;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.common.FMLCommonHandler;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityPlane extends EntityDriveable {
   public float flapsYaw;
   public float flapsPitchLeft;
   public float flapsPitchRight;
   public int soundPosition;
   public int bombDelay;
   public int gunDelay;
   public int ticksSinceUsed;
   public boolean varGear;
   public boolean varDoor;
   public boolean varWing;
   public boolean doorsHaveShut;
   public int toggleTimer;
   public int carrierTimer;
   public EnumPlaneMode mode;
   public boolean combatRadar;
   public Vector3f wingPos;
   public Vector3f wingRot;
   public Vector3f wingWheelPos;
   public Vector3f wingWheelRot;
   public Vector3f coreWheelPos;
   public Vector3f coreWheelRot;
   public Vector3f tailWheelPos;
   public Vector3f tailWheelRot;
   public Vector3f doorPos;
   public Vector3f doorRot;
   public Vector3f prevWingPos;
   public Vector3f prevWingRot;
   public Vector3f prevWingWheelPos;
   public Vector3f prevWingWheelRot;
   public Vector3f prevCoreWheelPos;
   public Vector3f prevCoreWheelRot;
   public Vector3f prevTailWheelPos;
   public Vector3f prevTailWheelRot;
   public Vector3f prevDoorPos;
   public Vector3f prevDoorRot;
   public float xSpeed;
   public float ySpeed;
   public float zSpeed;
   public float rollSpeed;
   public FlightController control;
   public AnimationController anim;
   public boolean initiatedAnim;
   public boolean radarVisible;
   public boolean hasPlaneRadar;
   public float radarRange;
   public int radarPositionOffset;
   public int radarRefreshDelay;

   public EntityPlane(World world) {
      super(world);
      this.ticksSinceUsed = 0;
      this.varGear = true;
      this.varDoor = false;
      this.varWing = false;
      this.doorsHaveShut = false;
      this.toggleTimer = 0;
      this.carrierTimer = 0;
      this.combatRadar = false;
      this.wingPos = new Vector3f(0.0F, 0.0F, 0.0F);
      this.wingRot = new Vector3f(0.0F, 0.0F, 0.0F);
      this.wingWheelPos = new Vector3f(0.0F, 0.0F, 0.0F);
      this.wingWheelRot = new Vector3f(0.0F, 0.0F, 0.0F);
      this.coreWheelPos = new Vector3f(0.0F, 0.0F, 0.0F);
      this.coreWheelRot = new Vector3f(0.0F, 0.0F, 0.0F);
      this.tailWheelPos = new Vector3f(0.0F, 0.0F, 0.0F);
      this.tailWheelRot = new Vector3f(0.0F, 0.0F, 0.0F);
      this.doorPos = new Vector3f(0.0F, 0.0F, 0.0F);
      this.doorRot = new Vector3f(0.0F, 0.0F, 0.0F);
      this.prevWingPos = new Vector3f(0.0F, 0.0F, 0.0F);
      this.prevWingRot = new Vector3f(0.0F, 0.0F, 0.0F);
      this.prevWingWheelPos = new Vector3f(0.0F, 0.0F, 0.0F);
      this.prevWingWheelRot = new Vector3f(0.0F, 0.0F, 0.0F);
      this.prevCoreWheelPos = new Vector3f(0.0F, 0.0F, 0.0F);
      this.prevCoreWheelRot = new Vector3f(0.0F, 0.0F, 0.0F);
      this.prevTailWheelPos = new Vector3f(0.0F, 0.0F, 0.0F);
      this.prevTailWheelRot = new Vector3f(0.0F, 0.0F, 0.0F);
      this.prevDoorPos = new Vector3f(0.0F, 0.0F, 0.0F);
      this.prevDoorRot = new Vector3f(0.0F, 0.0F, 0.0F);
      this.xSpeed = 0.0F;
      this.ySpeed = 0.0F;
      this.zSpeed = 0.0F;
      this.rollSpeed = 0.0F;
      this.control = new FlightController();
      this.anim = new AnimationController();
      this.initiatedAnim = false;
   }

   public EntityPlane(World world, double x, double y, double z, PlaneType type, DriveableData data) {
      super(world, type, data);
      this.ticksSinceUsed = 0;
      this.varGear = true;
      this.varDoor = false;
      this.varWing = false;
      this.doorsHaveShut = false;
      this.toggleTimer = 0;
      this.carrierTimer = 0;
      this.combatRadar = false;
      this.wingPos = new Vector3f(0.0F, 0.0F, 0.0F);
      this.wingRot = new Vector3f(0.0F, 0.0F, 0.0F);
      this.wingWheelPos = new Vector3f(0.0F, 0.0F, 0.0F);
      this.wingWheelRot = new Vector3f(0.0F, 0.0F, 0.0F);
      this.coreWheelPos = new Vector3f(0.0F, 0.0F, 0.0F);
      this.coreWheelRot = new Vector3f(0.0F, 0.0F, 0.0F);
      this.tailWheelPos = new Vector3f(0.0F, 0.0F, 0.0F);
      this.tailWheelRot = new Vector3f(0.0F, 0.0F, 0.0F);
      this.doorPos = new Vector3f(0.0F, 0.0F, 0.0F);
      this.doorRot = new Vector3f(0.0F, 0.0F, 0.0F);
      this.prevWingPos = new Vector3f(0.0F, 0.0F, 0.0F);
      this.prevWingRot = new Vector3f(0.0F, 0.0F, 0.0F);
      this.prevWingWheelPos = new Vector3f(0.0F, 0.0F, 0.0F);
      this.prevWingWheelRot = new Vector3f(0.0F, 0.0F, 0.0F);
      this.prevCoreWheelPos = new Vector3f(0.0F, 0.0F, 0.0F);
      this.prevCoreWheelRot = new Vector3f(0.0F, 0.0F, 0.0F);
      this.prevTailWheelPos = new Vector3f(0.0F, 0.0F, 0.0F);
      this.prevTailWheelRot = new Vector3f(0.0F, 0.0F, 0.0F);
      this.prevDoorPos = new Vector3f(0.0F, 0.0F, 0.0F);
      this.prevDoorRot = new Vector3f(0.0F, 0.0F, 0.0F);
      this.xSpeed = 0.0F;
      this.ySpeed = 0.0F;
      this.zSpeed = 0.0F;
      this.rollSpeed = 0.0F;
      this.control = new FlightController();
      this.anim = new AnimationController();
      this.initiatedAnim = false;
      this.func_70107_b(x, y, z);
      this.field_70169_q = x;
      this.field_70167_r = y;
      this.field_70166_s = z;
      this.initType(type, false);
   }

   public EntityPlane(World world, double x, double y, double z, EntityPlayer placer, PlaneType type, DriveableData data) {
      this(world, x, y + 5.625D, z, type, data);
      this.rotateYaw(placer.field_70177_z + 90.0F);
      this.rotatePitch(type.restingPitch);
   }

   public void initType(DriveableType type, boolean clientSide) {
      this.radarVisible = type.radarVisible;
      this.hasPlaneRadar = type.hasPlaneRadar;
      this.radarRange = type.radarRange;
      this.radarPositionOffset = type.radarPositionOffset;
      this.radarRefreshDelay = type.radarRefreshDelay;
      super.initType(type, clientSide);
      this.mode = ((PlaneType)type).mode == EnumPlaneMode.HELI ? EnumPlaneMode.HELI : EnumPlaneMode.PLANE;
      if (((PlaneType)type).mode == EnumPlaneMode.VTOL) {
         this.mode = EnumPlaneMode.HELI;
      }

   }

   protected void func_70014_b(NBTTagCompound tag) {
      super.func_70014_b(tag);
      tag.func_74782_a("Pos", this.func_70087_a(new double[]{this.field_70165_t, this.field_70163_u + 1.0D, this.field_70161_v}));
      tag.func_74757_a("VarGear", this.varGear);
      tag.func_74757_a("VarDoor", this.varDoor);
      tag.func_74757_a("VarWing", this.varWing);
   }

   protected void func_70037_a(NBTTagCompound tag) {
      super.func_70037_a(tag);
      this.varGear = tag.func_74767_n("VarGear");
      this.varDoor = tag.func_74767_n("VarDoor");
      this.varWing = tag.func_74767_n("VarWing");
   }

   public void onMouseMoved(int deltaX, int deltaY) {
      if (FMLCommonHandler.instance().getSide().isClient()) {
         if (FlansMod.proxy.mouseControlEnabled()) {
            float sensitivity = 0.02F;
            this.flapsPitchLeft -= sensitivity * (float)deltaY;
            this.flapsPitchRight -= sensitivity * (float)deltaY;
            if (this.mode != EnumPlaneMode.SIXDOF) {
               this.flapsPitchLeft -= sensitivity * (float)deltaX;
               this.flapsPitchRight += sensitivity * (float)deltaX;
            } else {
               this.flapsPitchLeft -= sensitivity * (float)deltaX;
               this.flapsPitchRight += sensitivity * (float)deltaX;
            }

         }
      }
   }

   public void setPositionRotationAndMotion(double x, double y, double z, float yaw, float pitch, float roll, double motX, double motY, double motZ, float velYaw, float velPitch, float velRoll, float throt, float steeringYaw) {
      super.setPositionRotationAndMotion(x, y, z, yaw, pitch, roll, motX, motY, motZ, velYaw, velPitch, velRoll, throt, steeringYaw);
      this.flapsYaw = steeringYaw;
   }

   public void setRotorPosition(float current, float previous) {
      this.rotorAngle = current;
      this.prevRotorAngle = previous;
   }

   public void setPropPosition(float current, float previous) {
      this.propAngle = current;
      this.prevPropAngle = previous;
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
            PlaneType type = this.getPlaneType();

            for(int i = 0; i <= type.numPassengers; ++i) {
               if (this.seats[i].func_130002_c(entityplayer)) {
                  if (i == 0) {
                     this.bombDelay = type.planeBombDelay;
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
      PlaneType type = this.getPlaneType();
      if (this.field_70170_p.field_72995_K && (key == 6 || key == 8 || key == 9)) {
         FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketDriveableKey(key)));
         return true;
      } else {
         boolean canThrust = this.seats[0] != null && this.seats[0].field_70153_n instanceof EntityPlayer && ((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d || this.getDriveableData().fuelInTank > 0.0F;
         switch(key) {
         case 0:
            if (canThrust || this.throttle < 0.0F) {
               this.throttle += 0.002F;
               if (this.throttle > 1.0F) {
                  this.throttle = 1.0F;
               }

               this.xSpeed += 0.5F;
            }

            return true;
         case 1:
            if (canThrust || this.throttle > 0.0F) {
               this.throttle -= 0.005F;
               if (this.throttle < -1.0F) {
                  this.throttle = -1.0F;
               }

               if (this.throttle < 0.0F && type.maxNegativeThrottle == 0.0F) {
                  this.throttle = 0.0F;
               }

               this.xSpeed -= 0.5F;
            }

            return true;
         case 2:
            if (this.mode != EnumPlaneMode.SIXDOF) {
               --this.flapsYaw;
            }

            --this.zSpeed;
            return true;
         case 3:
            if (this.mode != EnumPlaneMode.SIXDOF) {
               ++this.flapsYaw;
            }

            ++this.zSpeed;
            return true;
         case 4:
            if (this.mode != EnumPlaneMode.SIXDOF) {
               ++this.flapsPitchLeft;
               ++this.flapsPitchRight;
            }

            ++this.ySpeed;
            return true;
         case 5:
            if (this.mode != EnumPlaneMode.SIXDOF) {
               --this.flapsPitchLeft;
               --this.flapsPitchRight;
            }

            --this.ySpeed;
            return true;
         case 6:
            if (this.seats[0].field_70153_n != null) {
               this.seats[0].field_70153_n.func_70078_a((Entity)null);
            }

            return true;
         case 7:
            if (this.field_70170_p.field_72995_K && (type.invInflight || Math.abs(this.throttle) < 0.1F && this.field_70122_E)) {
               FlansMod.proxy.openDriveableMenu((EntityPlayer)this.seats[0].field_70153_n, this.field_70170_p, this);
            }

            return true;
         case 8:
            this.func_70078_a((Entity)null);
            return true;
         case 9:
            double checkCarrierRange = 20.0D;
            List carrier = this.field_70170_p.func_72872_a(EntitySeat.class, AxisAlignedBB.func_72330_a(this.field_70165_t - checkCarrierRange, this.field_70163_u - checkCarrierRange, this.field_70161_v - checkCarrierRange, this.field_70165_t + checkCarrierRange, this.field_70163_u + checkCarrierRange, this.field_70161_v + checkCarrierRange));
            if (type.carrierLandable || type.helipadLandable) {
               if (this.field_70153_n != null && this.field_70153_n instanceof EntityPlane && !(this.field_70153_n instanceof EntityPlayer)) {
                  this.field_70153_n.func_70078_a((Entity)null);
                  return true;
               }

               Iterator var8 = carrier.iterator();

               while(true) {
                  EntitySeat carrierSpot;
                  do {
                     if (!var8.hasNext()) {
                        return true;
                     }

                     Object obj = var8.next();
                     carrierSpot = (EntitySeat)obj;
                  } while((carrierSpot.field_70153_n != null || !carrierSpot.seatInfo.carrier) && (carrierSpot.field_70153_n != null || !carrierSpot.seatInfo.helipad || !type.helipadLandable));

                  this.func_70078_a(carrierSpot);
               }
            }

            return true;
         case 10:
            FlansMod.proxy.changeControlMode((EntityPlayer)this.seats[0].field_70153_n);
            this.seats[0].playerLooking = new RotatedAxes(0.0F, 0.0F, 0.0F);
            return true;
         case 11:
            if (this.mode != EnumPlaneMode.SIXDOF) {
               ++this.flapsPitchLeft;
               --this.flapsPitchRight;
            } else {
               this.flapsYaw -= 0.25F;
            }

            return true;
         case 12:
            if (this.mode != EnumPlaneMode.SIXDOF) {
               --this.flapsPitchLeft;
               ++this.flapsPitchRight;
            } else {
               this.flapsYaw += 0.25F;
            }

            return true;
         case 13:
            if (this.toggleTimer <= 0 && this.field_70170_p.func_147437_c((int)this.field_70165_t, (int)(this.field_70163_u - 3.0D), (int)this.field_70161_v)) {
               this.varGear = !this.varGear;
               player.func_145747_a(new ChatComponentText("Landing gear " + (this.varGear ? "down" : "up")));
               this.toggleTimer = 10;
               FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketDriveableControl(this)));
            }

            return true;
         case 14:
            if (this.toggleTimer <= 0) {
               this.varDoor = !this.varDoor;
               if (type.hasDoor) {
                  player.func_145747_a(new ChatComponentText("Doors " + (this.varDoor ? "open" : "closed")));
               }

               this.toggleTimer = 10;
               FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketDriveableControl(this)));
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
            if (this.toggleTimer <= 0) {
               if (type.hasWing) {
                  this.varWing = !this.varWing;
                  player.func_145747_a(new ChatComponentText("Switching mode"));
               }

               if (type.mode == EnumPlaneMode.VTOL) {
                  if (this.mode == EnumPlaneMode.HELI) {
                     this.mode = EnumPlaneMode.PLANE;
                  } else {
                     this.mode = EnumPlaneMode.HELI;
                  }

                  player.func_145747_a(new ChatComponentText(this.mode == EnumPlaneMode.HELI ? "Entering hover mode" : "Entering plane mode"));
               }

               this.anim.changeState(this.varWing ? 0 : 1);
               this.toggleTimer = 10;
               FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketDriveableControl(this)));
            }

            return true;
         case 16:
            return true;
         case 18:
            if (type.hasFlare && this.ticksFlareUsing <= 0 && this.flareDelay <= 0) {
               this.ticksFlareUsing = type.timeFlareUsing * 20;
               this.flareDelay = type.flareDelay;
               if (this.field_70170_p.field_72995_K) {
                  FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketDriveableKey(key)));
               } else if (!type.flareSound.isEmpty()) {
                  PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, type.flareSound, false);
               }

               return true;
            }
         case 17:
         default:
            return false;
         }
      }
   }

   public void updateKeyHeldState(int key, boolean held) {
      super.updateKeyHeldState(key, held);
      if (!this.field_70170_p.field_72995_K) {
         switch(key) {
         case 8:
         case 9:
         }
      }

   }

   public void func_70071_h_() {
      super.func_70071_h_();
      this.prevWingPos = this.wingPos;
      this.prevWingRot = this.wingRot;
      this.prevWingWheelPos = this.wingWheelPos;
      this.prevWingWheelRot = this.wingWheelRot;
      this.prevCoreWheelPos = this.coreWheelPos;
      this.prevCoreWheelRot = this.coreWheelRot;
      this.prevTailWheelPos = this.tailWheelPos;
      this.prevTailWheelRot = this.tailWheelRot;
      this.prevDoorPos = this.doorPos;
      this.prevDoorRot = this.doorRot;
      if (this.getPlaneType().valkyrie) {
         if (!this.initiatedAnim) {
            this.anim.initPoses();
            this.anim.initAnim();
            this.initiatedAnim = true;
            this.anim.changeState(this.varWing ? 0 : 1);
         }

         if (this.initiatedAnim) {
            int i = this.varWing ? 0 : 1;
            this.anim.UpdateAnim(i);
         }
      }

      if (this.initiatedAnim && this.throttle > 0.2F) {
         Vector3f v = this.anim.getFullPosition(new Vector3f(151.0F, -25.0F, -24.0F), (AnimationPart)this.anim.parts.get(5));
         v = this.axes.findLocalVectorGlobally(new Vector3f(-v.x, -v.y, v.z));
         Vector3f v2 = this.anim.getFullPosition(new Vector3f(151.0F, -25.0F, 24.0F), (AnimationPart)this.anim.parts.get(8));
         v2 = this.axes.findLocalVectorGlobally(new Vector3f(-v2.x, -v2.y, v2.z));

         for(int i = 0; i < 4; ++i) {
            if (!Float.isNaN(v.x)) {
               FlansMod.getPacketHandler().sendToAllAround(new PacketParticle("flansmod.afterburn", this.field_70165_t + (double)(v2.x / 16.0F), this.field_70163_u + (double)(v2.y / 16.0F), this.field_70161_v + (double)(v2.z / 16.0F), 0.0D, 0.0D, 0.0D), this.field_70165_t + (double)(v2.x / 16.0F), this.field_70163_u + (double)(v2.y / 16.0F), this.field_70161_v + (double)(v2.z / 16.0F), 150.0F, this.field_71093_bK);
            }

            if (!Float.isNaN(v.x)) {
               FlansMod.getPacketHandler().sendToAllAround(new PacketParticle("flansmod.afterburn", this.field_70165_t + (double)(v.x / 16.0F), this.field_70163_u + (double)(v.y / 16.0F), this.field_70161_v + (double)(v.z / 16.0F), 0.0D, 0.0D, 0.0D), this.field_70165_t + (double)(v.x / 16.0F), this.field_70163_u + (double)(v.y / 16.0F), this.field_70161_v + (double)(v.z / 16.0F), 150.0F, this.field_71093_bK);
            }
         }
      }

      PlaneType type = this.getPlaneType();
      DriveableData data = this.getDriveableData();
      if (type == null) {
         FlansMod.log("Plane type null. Not ticking plane");
      } else {
         boolean thePlayerIsDrivingThis = this.field_70170_p.field_72995_K && this.seats[0] != null && this.seats[0].field_70153_n instanceof EntityPlayer && FlansMod.proxy.isThePlayer((EntityPlayer)this.seats[0].field_70153_n);
         ++this.ticksSinceUsed;
         if (!this.field_70170_p.field_72995_K && this.seats[0].field_70153_n != null) {
            this.ticksSinceUsed = 0;
         }

         if (!this.field_70170_p.field_72995_K && TeamsManager.planeLife > 0 && this.ticksSinceUsed > TeamsManager.planeLife * 20) {
            this.func_70106_y();
         }

         if (this.field_70170_p.field_72995_K && (this.varFlare || this.ticksFlareUsing > 0) && this.field_70173_aa % 5 == 0) {
            Vector3f dir = this.axes.findLocalVectorGlobally(new Vector3f(0.0F, -0.5F, 0.0F));
            FlansMod.proxy.spawnParticle("flansmod.flare", this.field_70165_t, this.field_70163_u, this.field_70161_v, (double)dir.x, (double)dir.y, (double)dir.z);
         }

         if (this.ticksFlareUsing > 0) {
            --this.ticksFlareUsing;
         }

         if (this.flareDelay > 0) {
            --this.flareDelay;
         }

         if (this.bombDelay > 0) {
            --this.bombDelay;
         }

         if (this.gunDelay > 0) {
            --this.gunDelay;
         }

         if (this.toggleTimer > 0) {
            --this.toggleTimer;
         }

         if (this.carrierTimer < 0) {
            ++this.carrierTimer;
         }

         if (!this.varWing) {
            this.wingPos = this.transformPart(this.wingPos, type.wingPos1, type.wingRate);
            this.wingRot = this.transformPart(this.wingRot, type.wingRot1, type.wingRotRate);
         } else {
            this.wingPos = this.transformPart(this.wingPos, type.wingPos2, type.wingRate);
            this.wingRot = this.transformPart(this.wingRot, type.wingRot2, type.wingRotRate);
         }

         if (this.varGear) {
            this.wingWheelPos = this.transformPart(this.wingWheelPos, type.wingWheelPos1, type.wingWheelRate);
            this.wingWheelRot = this.transformPart(this.wingWheelRot, type.wingWheelRot1, type.wingWheelRotRate);
            this.coreWheelPos = this.transformPart(this.coreWheelPos, type.bodyWheelPos1, type.bodyWheelRate);
            this.coreWheelRot = this.transformPart(this.coreWheelRot, type.bodyWheelRot1, type.bodyWheelRotRate);
            this.tailWheelPos = this.transformPart(this.tailWheelPos, type.tailWheelPos1, type.tailWheelRate);
            this.tailWheelRot = this.transformPart(this.tailWheelRot, type.tailWheelRot1, type.tailWheelRotRate);
         } else {
            this.wingWheelPos = this.transformPart(this.wingWheelPos, type.wingWheelPos2, type.wingWheelRate);
            this.wingWheelRot = this.transformPart(this.wingWheelRot, type.wingWheelRot2, type.wingWheelRotRate);
            this.coreWheelPos = this.transformPart(this.coreWheelPos, type.bodyWheelPos2, type.bodyWheelRate);
            this.coreWheelRot = this.transformPart(this.coreWheelRot, type.bodyWheelRot2, type.bodyWheelRotRate);
            this.tailWheelPos = this.transformPart(this.tailWheelPos, type.tailWheelPos2, type.tailWheelRate);
            this.tailWheelRot = this.transformPart(this.tailWheelRot, type.tailWheelRot2, type.tailWheelRotRate);
         }

         if (!this.varDoor) {
            this.doorPos = this.transformPart(this.doorPos, type.doorPos1, type.doorRate);
            this.doorRot = this.transformPart(this.doorRot, type.doorRot1, type.doorRotRate);
         } else {
            this.doorPos = this.transformPart(this.doorPos, type.doorPos2, type.doorRate);
            this.doorRot = this.transformPart(this.doorRot, type.doorRot2, type.doorRotRate);
         }

         if (!this.field_70170_p.func_147437_c((int)this.field_70165_t, (int)(this.field_70163_u - 10.0D), (int)this.field_70161_v) && (double)this.throttle <= 0.4D) {
            EntitySeat[] var31 = this.seats;
            int var5 = var31.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               EntitySeat seat = var31[var6];
               if (seat != null && !this.varGear && (EntityPlayer)this.seats[0].field_70153_n != null) {
                  ((EntityPlayer)this.seats[0].field_70153_n).func_145747_a(new ChatComponentText("Deploying landing gear"));
               }
            }

            this.varGear = true;
            if (type.foldWingForLand) {
               if (this.varWing && (EntityPlayer)this.seats[0].field_70153_n != null) {
                  ((EntityPlayer)this.seats[0].field_70153_n).func_145747_a(new ChatComponentText("Extending wings"));
               }

               this.varWing = false;
            }
         }

         if (!this.field_70170_p.func_147437_c((int)this.field_70165_t, (int)(this.field_70163_u - 3.0D), (int)this.field_70161_v) && (double)this.throttle <= 0.05D) {
            if (!this.doorsHaveShut) {
               this.varDoor = true;
            }

            this.doorsHaveShut = true;
         } else if (!type.flyWithOpenDoor) {
            this.varDoor = false;
            this.doorsHaveShut = false;
         }

         if (this.locked) {
            this.varDoor = false;
            this.doorsHaveShut = false;
         }

         if (!this.isPartIntact(EnumDriveablePart.tail) && type.spinWithoutTail) {
            this.flapsYaw = 15.0F;
         }

         this.flapsYaw *= 0.9F;
         this.flapsPitchLeft *= 0.9F;
         this.flapsPitchRight *= 0.9F;
         if (this.flapsYaw > 20.0F) {
            this.flapsYaw = 20.0F;
         }

         if (this.flapsYaw < -20.0F) {
            this.flapsYaw = -20.0F;
         }

         if (this.flapsPitchRight > 20.0F) {
            this.flapsPitchRight = 20.0F;
         }

         if (this.flapsPitchRight < -20.0F) {
            this.flapsPitchRight = -20.0F;
         }

         if (this.flapsPitchLeft > 20.0F) {
            this.flapsPitchLeft = 20.0F;
         }

         if (this.flapsPitchLeft < -20.0F) {
            this.flapsPitchLeft = -20.0F;
         }

         double motion;
         if (this.field_70170_p.field_72995_K && !thePlayerIsDrivingThis && this.serverPositionTransitionTicker > 0) {
            double x = this.field_70165_t + (this.field_70118_ct - this.field_70165_t) / (double)this.serverPositionTransitionTicker;
            motion = this.field_70163_u + (this.field_70117_cu - this.field_70163_u) / (double)this.serverPositionTransitionTicker;
            double z = this.field_70161_v + (this.field_70116_cv - this.field_70161_v) / (double)this.serverPositionTransitionTicker;
            double dYaw = MathHelper.func_76138_g(this.serverYaw - (double)this.axes.getYaw());
            double dPitch = MathHelper.func_76138_g(this.serverPitch - (double)this.axes.getPitch());
            double dRoll = MathHelper.func_76138_g(this.serverRoll - (double)this.axes.getRoll());
            this.field_70177_z = (float)((double)this.axes.getYaw() + dYaw / (double)this.serverPositionTransitionTicker);
            this.field_70125_A = (float)((double)this.axes.getPitch() + dPitch / (double)this.serverPositionTransitionTicker);
            float rotationRoll = (float)((double)this.axes.getRoll() + dRoll / (double)this.serverPositionTransitionTicker);
            --this.serverPositionTransitionTicker;
            this.func_70107_b(x, motion, z);
            this.setRotation(this.field_70177_z, this.field_70125_A, rotationRoll);
         }

         boolean canThrust = this.seats[0] != null && this.seats[0].field_70153_n instanceof EntityPlayer && ((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ.field_75098_d || data.fuelInTank > 0.0F;
         float throttlePull = 0.99F;
         if (this.seats[0] != null && this.seats[0].field_70153_n != null && this.mode == EnumPlaneMode.HELI && canThrust) {
            this.throttle = (this.throttle - 0.5F) * throttlePull + 0.5F;
         }

         this.control.fly(this);
         motion = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
         if (motion > 10.0D) {
            this.field_70159_w *= 10.0D / motion;
            this.field_70181_x *= 10.0D / motion;
            this.field_70179_y *= 10.0D / motion;
         }

         EntityWheel[] var36 = this.wheels;
         int var9 = var36.length;

         EntityWheel wheel;
         int var41;
         for(var41 = 0; var41 < var9; ++var41) {
            wheel = var36[var41];
            if (wheel != null && this.field_70170_p != null) {
               if (type.floatOnWater && this.field_70170_p.func_72953_d(this.field_70121_D)) {
                  this.field_70181_x = (double)type.buoyancy;
               }

               if (!type.floatOnWater && this.field_70170_p.func_72953_d(this.field_70121_D)) {
                  this.throttle = 0.0F;
               }
            }
         }

         var36 = this.wheels;
         var9 = var36.length;

         for(var41 = 0; var41 < var9; ++var41) {
            wheel = var36[var41];
            if (wheel != null) {
               wheel.field_70167_r = wheel.field_70163_u;
               wheel.func_70091_d(this.field_70159_w, this.onDeck ? 0.0D : this.field_70181_x, this.field_70179_y);
            }
         }

         this.correctWheelPos();

         for(int i = 0; i < 2; ++i) {
            Vector3f amountToMoveCar = new Vector3f(this.field_70159_w / 2.0D, this.onDeck ? 0.0D : this.field_70181_x / 2.0D, this.field_70179_y / 2.0D);
            EntityWheel[] var42 = this.wheels;
            int var43 = var42.length;

            for(int var45 = 0; var45 < var43; ++var45) {
               EntityWheel wheel = var42[var45];
               if (wheel != null) {
                  this.field_70122_E = true;
                  wheel.field_70122_E = true;
                  wheel.field_70177_z = this.axes.getYaw();
                  Vector3f wPos = this.getPlaneType().wheelPositions[wheel.ID].position;
                  if (type.valkyrie && this.varWing) {
                     wPos = new Vector3f(wPos.x, wPos.y + 5.625F, wPos.z);
                  }

                  Vector3f targetWheelPos = this.axes.findLocalVectorGlobally(wPos);
                  Vector3f currentWheelPos = new Vector3f(wheel.field_70165_t - this.field_70165_t, wheel.field_70163_u - this.field_70163_u, wheel.field_70161_v - this.field_70161_v);
                  float targetWheelLength = targetWheelPos.length();
                  float currentWheelLength = currentWheelPos.length();
                  float dLength = targetWheelLength - currentWheelLength;
                  float dAngle = Vector3f.angle(targetWheelPos, currentWheelPos);
                  float newLength = currentWheelLength + dLength * type.wheelSpringStrength;
                  Vector3f rotateAround = Vector3f.cross(targetWheelPos, currentWheelPos, (Vector3f)null);
                  Matrix4f mat = new Matrix4f();
                  mat.m00 = currentWheelPos.x;
                  mat.m10 = currentWheelPos.y;
                  mat.m20 = currentWheelPos.z;
                  mat.rotate(dAngle * type.wheelSpringStrength, rotateAround);
                  if (this.field_70173_aa > 5 && (!type.valkyrie || this.anim.timeSinceSwitch >= 10)) {
                     this.axes.rotateGlobal(-dAngle * type.wheelSpringStrength, rotateAround);
                  }

                  Vector3f newWheelPos = new Vector3f(mat.m00, mat.m10, mat.m20);
                  newWheelPos.normalise().scale(newLength);
                  float wheelProportion = 0.75F;
                  Vector3f amountToMoveWheel = new Vector3f();
                  amountToMoveWheel.x = (newWheelPos.x - currentWheelPos.x) * (1.0F - wheelProportion);
                  amountToMoveWheel.y = (newWheelPos.y - currentWheelPos.y) * (1.0F - wheelProportion);
                  amountToMoveWheel.z = (newWheelPos.z - currentWheelPos.z) * (1.0F - wheelProportion);
                  amountToMoveCar.x -= (newWheelPos.x - currentWheelPos.x) * (1.0F - wheelProportion);
                  amountToMoveCar.y -= (newWheelPos.y - currentWheelPos.y) * (1.0F - wheelProportion);
                  amountToMoveCar.z -= (newWheelPos.z - currentWheelPos.z) * (1.0F - wheelProportion);
                  amountToMoveCar.y = (float)((double)amountToMoveCar.y + (wheel.field_70163_u - wheel.field_70167_r - (this.onDeck ? 0.0D : this.field_70181_x)) * 0.5D / (double)this.wheels.length);
                  wheel.func_70091_d((double)amountToMoveWheel.x, (double)amountToMoveWheel.y, (double)amountToMoveWheel.z);
               }
            }

            this.func_70091_d((double)amountToMoveCar.x, (double)amountToMoveCar.y, (double)amountToMoveCar.z);
         }

         if (this.field_70154_o != null && this.field_70154_o.getClass().toString().indexOf("mcheli.aircraft.MCH_EntitySeat") > 0) {
            this.axes.setAngles(this.field_70154_o.field_70177_z + 90.0F, 0.0F, 0.0F);
         }

         this.checkForCollisions();
         if (this.throttle > 0.01F && this.throttle < 0.2F && this.soundPosition == 0) {
            PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, type.startSound, false);
            this.soundPosition = type.startSoundLength;
         }

         if (this.throttle > 0.2F && this.soundPosition == 0) {
            PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, type.engineSound, false);
            this.soundPosition = type.engineSoundLength;
         }

         if (this.soundPosition > 0) {
            --this.soundPosition;
         }

         EntitySeat[] var39 = this.seats;
         var9 = var39.length;

         for(var41 = 0; var41 < var9; ++var41) {
            EntitySeat seat = var39[var41];
            if (seat != null) {
               seat.updatePosition();
            }
         }

         if (thePlayerIsDrivingThis) {
            FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketPlaneControl(this)));
            FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketPlaneAnimator(this)));
            this.field_70118_ct = this.field_70165_t;
            this.field_70117_cu = this.field_70163_u;
            this.field_70116_cv = this.field_70161_v;
            this.serverYaw = (double)this.axes.getYaw();
         }

         float updateSpeed = 0.01F;
         if (!this.field_70170_p.field_72995_K) {
            FlansMod.getPacketHandler().sendToAllAround(new PacketPlaneControl(this), this.field_70165_t, this.field_70163_u, this.field_70161_v, 400.0F, this.field_71093_bK);
            FlansMod.getPacketHandler().sendToAllAround(new PacketPlaneAnimator(this), this.field_70165_t, this.field_70163_u, this.field_70161_v, 400.0F, this.field_71093_bK);
         }

      }
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

   public boolean gearDown() {
      return this.varGear;
   }

   public boolean attackEntityFrom(DamageSource damagesource, float i, boolean doDamage) {
      if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
         PlaneType type = PlaneType.getPlane(this.driveableType);
         if (damagesource.field_76373_n.equals("player") && damagesource.func_76346_g().field_70122_E && (this.seats[0] == null || this.seats[0].field_70153_n == null) && !this.locked) {
            ItemStack planeStack = new ItemStack(type.item, 1, this.driveableData.paintjobID);
            planeStack.field_77990_d = new NBTTagCompound();
            this.driveableData.writeToNBT(planeStack.field_77990_d);
            this.func_70099_a(planeStack, 0.5F);
            this.func_70106_y();
         }

         return super.func_70097_a(damagesource, i);
      } else {
         return true;
      }
   }

   public boolean canHitPart(EnumDriveablePart part) {
      return this.varGear || part != EnumDriveablePart.coreWheel && part != EnumDriveablePart.leftWingWheel && part != EnumDriveablePart.rightWingWheel && part != EnumDriveablePart.tailWheel;
   }

   public boolean func_70097_a(DamageSource damagesource, float i) {
      return this.attackEntityFrom(damagesource, i, true);
   }

   public PlaneType getPlaneType() {
      return PlaneType.getPlane(this.driveableType);
   }

   protected void dropItemsOnPartDeath(Vector3f midpoint, DriveablePart part) {
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

   public String getBombInventoryName() {
      return "Bombs";
   }

   public String getMissileInventoryName() {
      return "Missiles";
   }

   public boolean hasMouseControlMode() {
      return true;
   }
}
