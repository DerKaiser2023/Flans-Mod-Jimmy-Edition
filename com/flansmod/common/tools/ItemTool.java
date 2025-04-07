package com.flansmod.common.tools;

import com.flansmod.client.debug.EntityDebugVector;
import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.driveables.DriveablePart;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.guns.EntityGrenade;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketFlak;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemTool extends ItemFood {
   public ToolType type;
   private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
   private static final int RANDOM_STRING_LENGTH = 10;

   public ItemTool(ToolType t) {
      super(t.foodness, false);
      this.field_77777_bU = 1;
      this.type = t;
      this.type.item = this;
      this.func_77656_e(this.type.toolLife);
      if (this.type.foodness == 0) {
         this.func_77637_a(FlansMod.tabFlanParts);
         if (this.type.remote) {
            this.func_77637_a(FlansMod.tabFlanGuns);
         }

         if (this.type.healDriveables) {
            this.func_77637_a(FlansMod.tabFlanDriveables);
         }
      }

      GameRegistry.registerItem(this, this.type.shortName, "flansmod");
   }

   public void func_77624_a(ItemStack stack, EntityPlayer player, List lines, boolean b) {
      if (!this.type.packName.isEmpty()) {
         lines.add(this.type.packName);
      }

      if (this.type.description != null) {
         Collections.addAll(lines, this.type.description.split("_"));
      }

      if (stack.field_77990_d != null) {
         lines.add(stack.field_77990_d.func_74779_i("key"));
      }

   }

   public void func_77622_d(ItemStack itemStack, World world, EntityPlayer player) {
      itemStack.field_77990_d = new NBTTagCompound();
      itemStack.field_77990_d.func_74778_a("key", this.generateRandomString());
   }

   @SideOnly(Side.CLIENT)
   public int func_82790_a(ItemStack par1ItemStack, int par2) {
      return this.type.colour;
   }

   @SideOnly(Side.CLIENT)
   public void func_94581_a(IIconRegister icon) {
      this.field_77791_bV = icon.func_94245_a("FlansMod:" + this.type.iconPath);
   }

   public ItemStack func_77659_a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
      if (this.type.foodness > 0) {
         super.func_77659_a(itemstack, world, entityplayer);
      } else {
         if (this.type.parachute) {
            if (EntityParachute.canUseParachute(entityplayer)) {
               if (!world.field_72995_K) {
                  EntityParachute parachute = new EntityParachute(world, this.type, entityplayer);
                  if (!parachute.field_70128_L) {
                     world.func_72838_d(parachute);
                     entityplayer.func_70078_a(parachute);
                  }
               }

               if (!entityplayer.field_71075_bZ.field_75098_d && this.type.toolLife > 0) {
                  itemstack.func_77964_b(itemstack.func_77960_j() + 1);
               }

               if (this.type.toolLife > 0 && this.type.destroyOnEmpty && itemstack.func_77960_j() == itemstack.func_77958_k()) {
                  --itemstack.field_77994_a;
               }
            }

            return itemstack;
         }

         if (this.type.remote) {
            PlayerData data = PlayerHandler.getPlayerData(entityplayer, world.field_72995_K ? Side.CLIENT : Side.SERVER);
            Iterator i = data.remoteExplosives.iterator();

            while(i.hasNext()) {
               EntityGrenade grenade = (EntityGrenade)i.next();
               if (grenade.field_70128_L) {
                  i.remove();
               }
            }

            if (data.remoteExplosives.size() > 0) {
               ((EntityGrenade)data.remoteExplosives.get(0)).detonate();
               if (((EntityGrenade)data.remoteExplosives.get(0)).detonated) {
                  data.remoteExplosives.remove(0);
               }

               if (!entityplayer.field_71075_bZ.field_75098_d && this.type.toolLife > 0) {
                  itemstack.func_77964_b(itemstack.func_77960_j() + 1);
               }

               if (this.type.toolLife > 0 && this.type.destroyOnEmpty && itemstack.func_77960_j() == itemstack.func_77958_k()) {
                  --itemstack.field_77994_a;
               }

               return itemstack;
            }
         } else {
            float cosYaw = MathHelper.func_76134_b(-entityplayer.field_70177_z * 0.01745329F);
            float sinYaw = MathHelper.func_76126_a(-entityplayer.field_70177_z * 0.01745329F);
            float cosPitch = -MathHelper.func_76134_b(entityplayer.field_70125_A * 0.01745329F);
            float sinPitch = MathHelper.func_76126_a(entityplayer.field_70125_A * 0.01745329F);
            double length = -5.0D;
            Vec3 posVec = Vec3.func_72443_a(entityplayer.field_70165_t, entityplayer.field_70163_u + 1.62D - (double)entityplayer.field_70129_M, entityplayer.field_70161_v);
            Vec3 lookVec = posVec.func_72441_c((double)(sinYaw * cosPitch) * length, (double)sinPitch * length, (double)(cosYaw * cosPitch) * length);
            if (world.field_72995_K && FlansMod.DEBUG) {
               world.func_72838_d(new EntityDebugVector(world, new Vector3f(posVec), new Vector3f(posVec.func_72444_a(lookVec)), 100));
            }

            int i;
            Object obj;
            EntityDriveable driveable;
            DriveablePart part;
            if (this.type.healDriveables) {
               for(i = 0; i < world.field_72996_f.size(); ++i) {
                  obj = world.field_72996_f.get(i);
                  if (obj instanceof EntityDriveable) {
                     driveable = (EntityDriveable)obj;
                     part = driveable.raytraceParts(new Vector3f(posVec), Vector3f.sub(new Vector3f(lookVec), new Vector3f(posVec), (Vector3f)null));
                     if (part != null && part.maxHealth > 0 && part.health < part.maxHealth && (this.type.toolLife == 0 || itemstack.func_77960_j() < itemstack.func_77958_k())) {
                        part.health += this.type.healAmount;
                        if (part.health > part.maxHealth) {
                           part.health = part.maxHealth;
                        }

                        if (!entityplayer.field_71075_bZ.field_75098_d && this.type.toolLife > 0) {
                           itemstack.func_77964_b(itemstack.func_77960_j() + 1);
                        }

                        if (this.type.toolLife > 0 && this.type.destroyOnEmpty && itemstack.func_77960_j() == itemstack.func_77958_k()) {
                           --itemstack.field_77994_a;
                        }

                        return itemstack;
                     }
                  }
               }
            }

            if (!world.field_72995_K && this.type.healPlayers) {
               EntityLivingBase hitLiving = entityplayer;
               List list = world.func_72872_a(EntityLivingBase.class, AxisAlignedBB.func_72330_a(Math.min(posVec.field_72450_a, lookVec.field_72450_a), Math.min(posVec.field_72448_b, lookVec.field_72448_b), Math.min(posVec.field_72449_c, lookVec.field_72449_c), Math.max(posVec.field_72450_a, lookVec.field_72450_a), Math.max(posVec.field_72448_b, lookVec.field_72448_b), Math.max(posVec.field_72449_c, lookVec.field_72449_c)));
               Iterator var24 = list.iterator();

               while(var24.hasNext()) {
                  Object aList = var24.next();
                  if (aList instanceof EntityLivingBase) {
                     EntityLivingBase checkEntity = (EntityLivingBase)aList;
                     if (checkEntity != entityplayer) {
                        MovingObjectPosition hit = checkEntity.field_70121_D.func_72327_a(posVec, lookVec);
                        if (hit != null) {
                           hitLiving = checkEntity;
                        }
                     }
                  }
               }

               if (hitLiving != null) {
                  if (itemstack.func_77960_j() >= itemstack.func_77958_k() && this.type.toolLife > 0) {
                     return itemstack;
                  }

                  ((EntityLivingBase)hitLiving).func_70690_d(new PotionEffect(Potion.field_76428_l.field_76415_H, this.type.healAmount, this.type.healStrength));
                  FlansMod.getPacketHandler().sendToAllAround((PacketBase)(new PacketFlak(((EntityLivingBase)hitLiving).field_70165_t, ((EntityLivingBase)hitLiving).field_70163_u, ((EntityLivingBase)hitLiving).field_70161_v, 5, "heart")), new TargetPoint(((EntityLivingBase)hitLiving).field_71093_bK, ((EntityLivingBase)hitLiving).field_70165_t, ((EntityLivingBase)hitLiving).field_70163_u, ((EntityLivingBase)hitLiving).field_70161_v, 50.0D));
                  if (!entityplayer.field_71075_bZ.field_75098_d && this.type.toolLife > 0) {
                     itemstack.func_77964_b(itemstack.func_77960_j() + 1);
                  }

                  if (this.type.toolLife > 0 && this.type.destroyOnEmpty && itemstack.func_77960_j() >= itemstack.func_77958_k()) {
                     --itemstack.field_77994_a;
                  }
               }
            }

            if (!world.field_72995_K && this.type.key) {
               for(i = 0; i < world.field_72996_f.size(); ++i) {
                  obj = world.field_72996_f.get(i);
                  if (obj instanceof EntityDriveable) {
                     driveable = (EntityDriveable)obj;
                     part = driveable.raytraceParts(new Vector3f(posVec), Vector3f.sub(new Vector3f(lookVec), new Vector3f(posVec), (Vector3f)null));
                     if (part != null && part.maxHealth > 0) {
                        if (part.owner.locked) {
                           if (itemstack.field_77990_d == null) {
                              itemstack.field_77990_d = new NBTTagCompound();
                              itemstack.field_77990_d.func_74778_a("key", this.generateRandomString());
                           }

                           part.owner.unlock(itemstack.field_77990_d.func_74779_i("key"), entityplayer);
                        } else if (!part.owner.locked) {
                           if (itemstack.field_77990_d == null) {
                              itemstack.field_77990_d = new NBTTagCompound();
                              itemstack.field_77990_d.func_74778_a("key", this.generateRandomString());
                           }

                           part.owner.lock(itemstack.field_77990_d.func_74779_i("key"), entityplayer);
                        }
                     }
                  }
               }
            }
         }
      }

      return itemstack;
   }

   public String generateRandomString() {
      StringBuffer randStr = new StringBuffer();

      for(int i = 0; i < 10; ++i) {
         int number = this.getRandomNumber();
         char ch = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".charAt(number);
         randStr.append(ch);
      }

      return randStr.toString();
   }

   private int getRandomNumber() {
      int randomInt = false;
      Random randomGenerator = new Random();
      int randomInt = randomGenerator.nextInt("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".length());
      return randomInt - 1 == -1 ? randomInt : randomInt - 1;
   }

   public String toString() {
      return this.type == null ? this.func_77658_a() : this.type.name;
   }
}
