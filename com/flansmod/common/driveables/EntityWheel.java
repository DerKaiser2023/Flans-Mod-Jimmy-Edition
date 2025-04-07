package com.flansmod.common.driveables;

import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityWheel extends Entity implements IEntityAdditionalSpawnData {
   public EntityDriveable vehicle;
   public int ID;
   @SideOnly(Side.CLIENT)
   public boolean foundVehicle;
   private int vehicleID;
   public boolean onDeck;
   private int invulnerableUnmountCount;
   public int timeLimitDriveableNull;

   public EntityWheel(World world) {
      super(world);
      this.onDeck = false;
      this.timeLimitDriveableNull = 0;
      this.func_70105_a(1.0F, 1.0F);
      this.field_70138_W = 1.0F;
      this.invulnerableUnmountCount = 0;
   }

   public EntityWheel(World world, EntityDriveable entity, int i) {
      this(world);
      this.vehicle = entity;
      this.vehicleID = entity.func_145782_y();
      this.ID = i;
      this.initPosition();
   }

   public void initPosition() {
      Vector3f wheelVector = this.vehicle.axes.findLocalVectorGlobally(this.vehicle.getDriveableType().wheelPositions[this.ID].position);
      this.func_70107_b(this.vehicle.field_70165_t + (double)wheelVector.x, this.vehicle.field_70163_u + (double)wheelVector.y, this.vehicle.field_70161_v + (double)wheelVector.z);
      this.field_70138_W = this.vehicle.getDriveableType().wheelStepHeight;
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
   }

   protected void func_70069_a(float k) {
   }

   protected void func_70088_a() {
   }

   protected void func_70037_a(NBTTagCompound tags) {
      this.func_70106_y();
   }

   protected void func_70014_b(NBTTagCompound tags) {
   }

   public void func_70071_h_() {
      if (this.field_70154_o != null) {
         this.invulnerableUnmountCount = 80;
      } else if (this.invulnerableUnmountCount > 0) {
         --this.invulnerableUnmountCount;
      }

      if (this.field_70170_p.field_72995_K && !this.foundVehicle) {
         this.vehicle = (EntityDriveable)this.field_70170_p.func_73045_a(this.vehicleID);
         if (this.vehicle == null) {
            return;
         }

         this.foundVehicle = true;
         this.vehicle.wheels[this.ID] = this;
      }

      if (this.vehicle != null) {
         EntityDriveable entD = (EntityDriveable)this.field_70170_p.func_73045_a(this.vehicleID);
         if (entD == null) {
            ++this.timeLimitDriveableNull;
         } else {
            this.timeLimitDriveableNull = 0;
         }

         if (this.timeLimitDriveableNull > 1200) {
            this.func_70106_y();
         }

         if (!this.field_70175_ag) {
            this.field_70170_p.func_72838_d(this);
         }

      }
   }

   public double getSpeedXZ() {
      return Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
   }

   public double getSpeedXYZ() {
      return Math.cbrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y + this.field_70181_x * this.field_70181_x);
   }

   public void func_70056_a(double d, double d1, double d2, float f, float f1, int i) {
   }

   public void writeSpawnData(ByteBuf data) {
      data.writeInt(this.vehicleID);
      data.writeInt(this.ID);
   }

   public void readSpawnData(ByteBuf data) {
      this.vehicleID = data.readInt();
      this.ID = data.readInt();
      this.vehicle = (EntityDriveable)this.field_70170_p.func_73045_a(this.vehicleID);
      if (this.vehicle != null) {
         this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      }

   }
}
