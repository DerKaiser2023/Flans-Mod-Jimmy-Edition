package com.flansmod.client.debug;

import com.flansmod.common.vector.Vector3f;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityDebugAABB extends Entity {
   public Vector3f vector;
   public int life;
   public float red;
   public float green;
   public float blue;
   public float rotationRoll;
   public Vector3f offset;

   public EntityDebugAABB(World w, Vector3f u, Vector3f v, int i, float r, float g, float b, float yaw, float pitch, float roll, Vector3f offset) {
      super(w);
      this.red = 1.0F;
      this.green = 1.0F;
      this.blue = 1.0F;
      this.func_70107_b((double)u.x, (double)u.y, (double)u.z);
      this.field_70177_z = yaw;
      this.field_70125_A = pitch;
      this.rotationRoll = roll;
      this.vector = v;
      this.life = i;
      this.red = r;
      this.green = g;
      this.blue = b;
      this.offset = offset;
   }

   public EntityDebugAABB(World w, Vector3f u, Vector3f v, int i, float r, float g, float b, float yaw, float pitch, float roll) {
      this(w, u, v, i, r, g, b, yaw, pitch, roll, new Vector3f());
   }

   public EntityDebugAABB(World w, Vector3f u, Vector3f v, int i, float r, float g, float b) {
      this(w, u, v, i, r, g, b, 0.0F, 0.0F, 0.0F);
   }

   public EntityDebugAABB(World w, Vector3f u, Vector3f v, int i) {
      this(w, u, v, i, 1.0F, 1.0F, 1.0F);
   }

   public void func_70071_h_() {
      --this.life;
      if (this.life <= 0) {
         this.func_70106_y();
      }

   }

   public AxisAlignedBB func_70046_E() {
      return null;
   }

   protected void func_70088_a() {
   }

   protected void func_70037_a(NBTTagCompound nbttagcompound) {
   }

   protected void func_70014_b(NBTTagCompound nbttagcompound) {
   }
}
