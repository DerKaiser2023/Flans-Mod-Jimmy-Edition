package com.flansmod.common.guns;

import com.flansmod.common.types.InfoType;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class ItemShootable extends Item {
   public ShootableType type;

   public ItemShootable(ShootableType t) {
      this.type = t;
      this.field_77777_bU = this.type.maxStackSize;
      this.func_77656_e(this.type.roundsPerItem);
      GameRegistry.registerItem(this, this.type.shortName, "flansmod");
   }

   public abstract EntityShootable getEntity(World var1, Vec3 var2, float var3, float var4, double var5, double var7, double var9, EntityLivingBase var11, float var12, int var13, InfoType var14);

   public abstract EntityShootable getEntity(World var1, Vector3f var2, Vector3f var3, EntityLivingBase var4, float var5, float var6, float var7, int var8, InfoType var9);

   public abstract EntityShootable getEntity(World var1, Vec3 var2, float var3, float var4, EntityLivingBase var5, float var6, float var7, int var8, InfoType var9);

   public abstract EntityShootable getEntity(World var1, EntityLivingBase var2, float var3, float var4, float var5, boolean var6, int var7, InfoType var8);
}
