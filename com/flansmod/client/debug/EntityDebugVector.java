package com.flansmod.client.debug;

import com.flansmod.common.vector.Vector3f;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityDebugVector extends Entity {
   public Vector3f vector;
   public int life;
   public float red = 1.0F;
   public float green = 1.0F;
   public float blue = 1.0F;

   public EntityDebugVector(World w) {
      super(w);
   }

   public EntityDebugVector(World w, Vector3f u, Vector3f v, int i, float r, float g, float b) {
      super(w);
      this.func_70107_b((double)u.x, (double)u.y, (double)u.z);
      this.vector = v;
      this.life = i;
      this.red = r;
      this.green = g;
      this.blue = b;
   }

   public EntityDebugVector(World w, Vector3f u, Vector3f v, int i) {
      super(w);
      this.func_70107_b((double)u.x, (double)u.y, (double)u.z);
      this.vector = v;
      this.life = i;
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
