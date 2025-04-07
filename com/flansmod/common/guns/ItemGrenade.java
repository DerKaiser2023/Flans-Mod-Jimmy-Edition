package com.flansmod.common.guns;

import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.types.IFlanItem;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.vector.Vector3f;
import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemGrenade extends ItemShootable implements IFlanItem {
   public GrenadeType type;

   public ItemGrenade(GrenadeType t) {
      super(t);
      this.type = t;
      this.type.item = this;
      this.func_77637_a(FlansMod.tabFlanGuns);
   }

   public Multimap getAttributeModifiers(ItemStack stack) {
      Multimap multimap = super.getAttributeModifiers(stack);
      multimap.put(SharedMonsterAttributes.field_111264_e.func_111108_a(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.type.meleeDamage, 0));
      return multimap;
   }

   public boolean func_77662_d() {
      return true;
   }

   public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
      return this.type.meleeDamage == 0;
   }

   public ItemStack func_77659_a(ItemStack stack, World world, EntityPlayer player) {
      PlayerData data = PlayerHandler.getPlayerData(player, world.field_72995_K ? Side.CLIENT : Side.SERVER);
      if (this.type.canThrow && data != null && data.shootTimeRight <= 0 && data.shootTimeLeft <= 0) {
         data.shootTimeRight = this.type.throwDelay;
         EntityGrenade grenade = new EntityGrenade(world, this.type, player);
         if (!world.field_72995_K) {
            world.func_72838_d(grenade);
         }

         if (this.type.remote) {
            data.remoteExplosives.add(grenade);
         }

         if (!player.field_71075_bZ.field_75098_d) {
            --stack.field_77994_a;
         }

         if (this.type.dropItemOnThrow != null) {
            String itemName = this.type.dropItemOnDetonate;
            int damage = 0;
            if (itemName.contains(".")) {
               damage = Integer.parseInt(itemName.split("\\.")[1]);
               itemName = itemName.split("\\.")[0];
            }

            ItemStack dropStack = InfoType.getRecipeElement(itemName, damage);
            world.func_72838_d(new EntityItem(world, player.field_70165_t, player.field_70163_u, player.field_70161_v, dropStack));
         }
      }

      return stack;
   }

   @SideOnly(Side.CLIENT)
   public int func_82790_a(ItemStack par1ItemStack, int par2) {
      return this.type.colour;
   }

   @SideOnly(Side.CLIENT)
   public void func_94581_a(IIconRegister icon) {
      this.field_77791_bV = icon.func_94245_a("FlansMod:" + this.type.iconPath);
   }

   public InfoType getInfoType() {
      return this.type;
   }

   public EntityShootable getEntity(World worldObj, Vec3 origin, float yaw, float pitch, double motionX, double motionY, double motionZ, EntityLivingBase shooter, float gunDamage, int itemDamage, InfoType shotFrom) {
      return null;
   }

   public EntityShootable getEntity(World worldObj, Vector3f origin, Vector3f direction, EntityLivingBase thrower, float spread, float damage, float speed, int itemDamage, InfoType shotFrom) {
      return this.getGrenade(worldObj, thrower);
   }

   public EntityShootable getEntity(World worldObj, Vec3 origin, float yaw, float pitch, EntityLivingBase shooter, float spread, float damage, int itemDamage, InfoType shotFrom) {
      return null;
   }

   public EntityShootable getEntity(World worldObj, EntityLivingBase player, float bulletSpread, float damage, float bulletSpeed, boolean b, int itemDamage, InfoType shotFrom) {
      return this.getGrenade(worldObj, player);
   }

   public EntityGrenade getGrenade(World world, EntityLivingBase thrower) {
      EntityGrenade grenade = new EntityGrenade(world, this.type, thrower);
      if (this.type.remote && thrower instanceof EntityPlayer) {
         PlayerHandler.getPlayerData((EntityPlayer)thrower).remoteExplosives.add(grenade);
      }

      return grenade;
   }
}
