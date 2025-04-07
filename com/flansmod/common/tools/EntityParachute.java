package com.flansmod.common.tools;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import io.netty.buffer.ByteBuf;
import java.util.List;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityParachute extends Entity implements IEntityAdditionalSpawnData {
   public ToolType type;

   public EntityParachute(World w) {
      super(w);
      this.field_70158_ak = true;
      System.out.println(w.field_72995_K ? "Client paraspawn" : "Server paraspawn");
   }

   public EntityParachute(World w, ToolType t, EntityPlayer player) {
      this(w);
      this.type = t;
      if (canUseParachute(player)) {
         --player.field_70163_u;
         this.func_70107_b(player.field_70165_t, player.field_70163_u - 1.5D, player.field_70161_v);
      } else {
         this.func_70106_y();
      }

   }

   public static boolean canUseParachute(Entity player) {
      List list = player.field_70170_p.func_72945_a(player, player.field_70121_D.func_72314_b(0.0D, 3.0D, 0.0D));
      return list.size() == 0;
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if (!this.field_70170_p.field_72995_K && (this.field_70153_n == null || this.field_70153_n.field_70154_o != this)) {
         this.func_70106_y();
      }

      if (this.field_70153_n != null) {
         this.field_70153_n.field_70143_R = 0.0F;
      }

      this.field_70181_x = -0.3D;
      if (this.field_70153_n != null && this.field_70153_n instanceof EntityLivingBase) {
         float speedMultiplier = 0.025F;
         double moveForwards = (double)((EntityLivingBase)this.field_70153_n).field_70701_bs;
         double moveStrafing = (double)((EntityLivingBase)this.field_70153_n).field_70702_br;
         double sinYaw = -Math.sin((double)(this.field_70153_n.field_70177_z * 3.1415927F / 180.0F));
         double cosYaw = Math.cos((double)(this.field_70153_n.field_70177_z * 3.1415927F / 180.0F));
         this.field_70159_w += (moveForwards * sinYaw + moveStrafing * cosYaw) * (double)speedMultiplier;
         this.field_70179_y += (moveForwards * cosYaw - moveStrafing * sinYaw) * (double)speedMultiplier;
         this.field_70126_B = this.field_70177_z;
         this.field_70177_z = this.field_70153_n.field_70177_z;
      }

      this.field_70159_w *= 0.9300000071525574D;
      this.field_70179_y *= 0.9300000071525574D;
      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
      if (this.field_70122_E || this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)).func_149688_o() == Material.field_151586_h) {
         this.func_70106_y();
      }

   }

   protected void func_70069_a(float par1) {
   }

   public boolean func_70097_a(DamageSource source, float f) {
      this.func_70106_y();
      return true;
   }

   protected void func_70088_a() {
   }

   protected void func_70037_a(NBTTagCompound tags) {
      this.type = ToolType.getType(tags.func_74779_i("Type"));
   }

   protected void func_70014_b(NBTTagCompound tags) {
      tags.func_74778_a("Type", this.type.shortName);
   }

   public ItemStack getPickedResult(MovingObjectPosition target) {
      ItemStack stack = new ItemStack(this.type.item, 1, 0);
      return stack;
   }

   public void writeSpawnData(ByteBuf buffer) {
      ByteBufUtils.writeUTF8String(buffer, this.type.shortName);
   }

   public void readSpawnData(ByteBuf additionalData) {
      this.type = ToolType.getType(ByteBufUtils.readUTF8String(additionalData));
   }
}
