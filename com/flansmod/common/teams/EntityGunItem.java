package com.flansmod.common.teams;

import com.flansmod.common.PlayerHandler;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.ItemBullet;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.guns.ItemShootable;
import com.flansmod.common.guns.ShootableType;
import cpw.mods.fml.common.FMLCommonHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public class EntityGunItem extends EntityItem {
   public List<ItemStack> ammoStacks;

   public EntityGunItem(World w) {
      super(w);
   }

   public EntityGunItem(EntityItem entity) {
      super(entity.field_70170_p, entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, entity.func_92059_d().func_77946_l());
      this.func_70105_a(1.0F, 1.0F);
      this.ammoStacks = new ArrayList();
   }

   public EntityGunItem(World w, double x, double y, double z, ItemStack stack, List<ItemStack> stacks) {
      super(w, x, y, z, stack);
      this.func_70105_a(1.0F, 1.0F);
      this.ammoStacks = new ArrayList();
      Iterator var10 = stacks.iterator();

      while(var10.hasNext()) {
         ItemStack ammoStack = (ItemStack)var10.next();
         if (ammoStack != null && ammoStack.func_77973_b() != null && ammoStack.func_77973_b() instanceof ItemBullet) {
            this.ammoStacks.add(ammoStack);
         }
      }

   }

   public EntityGunItem(World w, double x, double y, double z) {
      super(w, x, y, z);
   }

   public boolean func_70067_L() {
      return true;
   }

   protected boolean func_70041_e_() {
      return true;
   }

   public AxisAlignedBB func_70046_E() {
      return null;
   }

   public void func_70071_h_() {
      this.func_70030_z();
      if (this.func_92059_d() == null || this.func_92059_d().func_77973_b() == null || !(this.func_92059_d().func_77973_b() instanceof ItemGun)) {
         this.func_70106_y();
      }

      if (!this.field_70170_p.field_72995_K && this.ammoStacks == null) {
         this.func_70106_y();
      }

      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      this.field_70181_x -= 0.03999999910593033D;
      this.func_145771_j(this.field_70165_t, (this.field_70121_D.field_72338_b + this.field_70121_D.field_72337_e) / 2.0D, this.field_70161_v);
      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
      float var2 = 0.98F;
      if (this.field_70122_E) {
         var2 = 0.58800006F;
         Block block = this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(this.field_70161_v));
         if (block != null) {
            var2 = block.field_149765_K * 0.98F;
         }
      }

      this.field_70159_w *= (double)var2;
      this.field_70181_x *= 0.9800000190734863D;
      this.field_70179_y *= (double)var2;
      if (this.field_70122_E) {
         this.field_70181_x *= -0.5D;
      }

      ++this.field_70292_b;
      ItemStack item = this.func_70096_w().func_82710_f(10);
      if (!this.field_70170_p.field_72995_K && this.field_70292_b >= this.lifespan) {
         if (item != null) {
            ItemExpireEvent event = new ItemExpireEvent(this, item.func_77973_b() == null ? 6000 : item.func_77973_b().getEntityLifespan(item, this.field_70170_p));
            if (MinecraftForge.EVENT_BUS.post(event)) {
               this.lifespan += event.extraLife;
            } else {
               this.func_70106_y();
            }
         } else {
            this.func_70106_y();
         }
      }

      if (item != null && item.field_77994_a <= 0) {
         this.func_70106_y();
      }

      if (this.field_70170_p.field_72995_K) {
         this.func_70066_B();
      }

   }

   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
      return false;
   }

   public void func_70100_b_(EntityPlayer player) {
      if (!this.field_70170_p.field_72995_K && this.ammoStacks != null && this.ammoStacks.size() > 0) {
         for(int i = 0; i < player.field_71071_by.func_70302_i_(); ++i) {
            ItemStack stack = player.field_71071_by.func_70301_a(i);
            if (stack != null && stack.func_77973_b() != null && stack.func_77973_b() instanceof ItemGun) {
               GunType type = ((ItemGun)stack.func_77973_b()).type;

               for(int j = this.ammoStacks.size() - 1; j >= 0; --j) {
                  ItemStack ammoStack = (ItemStack)this.ammoStacks.get(j);
                  if (type.isAmmo(((ItemShootable)ammoStack.func_77973_b()).type, stack) && player.field_71071_by.func_70441_a(ammoStack)) {
                     FMLCommonHandler.instance().firePlayerItemPickupEvent(player, this);
                     this.func_85030_a("random.pop", 0.2F, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                     this.ammoStacks.remove(j);
                  }
               }

               if (this.ammoStacks.size() == 0) {
                  this.func_70106_y();
               }
            }
         }
      }

   }

   public boolean func_130002_c(EntityPlayer player) {
      if (this.field_70170_p.field_72995_K) {
         return true;
      } else {
         EntityItemPickupEvent event = new EntityItemPickupEvent(player, this);
         TeamsManager.getInstance().playerLoot(event);
         if (!event.isCanceled()) {
            ItemStack currentItem = player.func_71045_bC();
            if (currentItem != null && currentItem.func_77973_b() instanceof ItemGun) {
               GunType gunType = ((ItemGun)currentItem.func_77973_b()).type;
               List<ItemStack> newAmmoStacks = new ArrayList();

               for(int i = 0; i < player.field_71071_by.func_70302_i_(); ++i) {
                  ItemStack stack = player.field_71071_by.func_70301_a(i);
                  if (stack != null && stack.func_77973_b() instanceof ItemShootable) {
                     ShootableType bulletType = ((ItemShootable)stack.func_77973_b()).type;
                     if (gunType.isAmmo(bulletType, currentItem)) {
                        newAmmoStacks.add(stack.func_77946_l());
                        player.field_71071_by.func_70299_a(i, (ItemStack)null);
                     }
                  }
               }

               EntityGunItem newGunItem = new EntityGunItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, currentItem.func_77946_l(), newAmmoStacks);
               this.field_70170_p.func_72838_d(newGunItem);
               player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, this.func_92059_d());
               Iterator var10 = this.ammoStacks.iterator();

               while(var10.hasNext()) {
                  ItemStack stack = (ItemStack)var10.next();
                  player.field_71071_by.func_70441_a(stack);
               }

               this.func_70106_y();
               PlayerHandler.getPlayerData(player).shootClickDelay = 10;
               PlayerHandler.getPlayerData(player).isShootingRight = false;
               return true;
            }
         }

         return false;
      }
   }

   public boolean func_70075_an() {
      return false;
   }

   public boolean func_70027_ad() {
      return false;
   }
}
