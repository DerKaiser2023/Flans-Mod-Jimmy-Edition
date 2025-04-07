package com.flansmod.common.driveables;

import com.flansmod.common.guns.ItemBullet;
import com.flansmod.common.parts.ItemPart;
import com.flansmod.common.parts.PartType;
import java.util.HashMap;
import java.util.Iterator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class DriveableData implements IInventory {
   public String type;
   public int numGuns;
   public int numBombs;
   public int numMissiles;
   public int numCargo;
   public ItemStack[] ammo;
   public ItemStack[] bombs;
   public ItemStack[] missiles;
   public ItemStack[] cargo;
   public PartType engine;
   public ItemStack fuel;
   public float fuelInTank;
   public float depth;
   public float fakeReloadShell;
   public float fakeReloadMissile;
   public HashMap<EnumDriveablePart, DriveablePart> parts;
   public boolean inventoryChanged;
   public int paintjobID;

   public DriveableData(NBTTagCompound tags, int paintjobID) {
      this(tags);
      this.paintjobID = paintjobID;
   }

   public DriveableData(NBTTagCompound tags) {
      this.inventoryChanged = false;
      this.parts = new HashMap();
      this.readFromNBT(tags);
   }

   public void readFromNBT(NBTTagCompound tag) {
      if (tag != null) {
         if (tag.func_74764_b("Type")) {
            this.type = tag.func_74779_i("Type");
            DriveableType dType = DriveableType.getDriveable(this.type);
            this.numBombs = dType.numBombSlots;
            this.numCargo = dType.numCargoSlots;
            this.numMissiles = dType.numMissileSlots;
            this.numGuns = dType.ammoSlots();
            this.engine = PartType.getPart(tag.func_74779_i("Engine"));
            this.paintjobID = tag.func_74762_e("Paint");
            this.ammo = new ItemStack[this.numGuns];
            this.bombs = new ItemStack[this.numBombs];
            this.missiles = new ItemStack[this.numMissiles];
            this.cargo = new ItemStack[this.numCargo];

            int i;
            for(i = 0; i < this.numGuns; ++i) {
               this.ammo[i] = ItemStack.func_77949_a(tag.func_74775_l("Ammo " + i));
            }

            for(i = 0; i < this.numBombs; ++i) {
               this.bombs[i] = ItemStack.func_77949_a(tag.func_74775_l("Bombs " + i));
            }

            for(i = 0; i < this.numMissiles; ++i) {
               this.missiles[i] = ItemStack.func_77949_a(tag.func_74775_l("Missiles " + i));
            }

            for(i = 0; i < this.numCargo; ++i) {
               this.cargo[i] = ItemStack.func_77949_a(tag.func_74775_l("Cargo " + i));
            }

            this.fuel = ItemStack.func_77949_a(tag.func_74775_l("Fuel"));
            this.fuelInTank = (float)tag.func_74762_e("FuelInTank");
            EnumDriveablePart[] var8 = EnumDriveablePart.values();
            int var4 = var8.length;

            for(int var5 = 0; var5 < var4; ++var5) {
               EnumDriveablePart part = var8[var5];
               this.parts.put(part, new DriveablePart(part, (CollisionBox)dType.health.get(part)));
            }

            Iterator var9 = this.parts.values().iterator();

            while(var9.hasNext()) {
               DriveablePart part = (DriveablePart)var9.next();
               part.readFromNBT(tag);
            }

         }
      }
   }

   public void writeToNBT(NBTTagCompound tag) {
      tag.func_74778_a("Type", this.type);
      tag.func_74778_a("Engine", this.engine.shortName);
      tag.func_74768_a("Paint", this.paintjobID);

      int i;
      for(i = 0; i < this.ammo.length; ++i) {
         if (this.ammo[i] != null) {
            tag.func_74782_a("Ammo " + i, this.ammo[i].func_77955_b(new NBTTagCompound()));
         }
      }

      for(i = 0; i < this.bombs.length; ++i) {
         if (this.bombs[i] != null) {
            tag.func_74782_a("Bombs " + i, this.bombs[i].func_77955_b(new NBTTagCompound()));
         }
      }

      for(i = 0; i < this.missiles.length; ++i) {
         if (this.missiles[i] != null) {
            tag.func_74782_a("Missiles " + i, this.missiles[i].func_77955_b(new NBTTagCompound()));
         }
      }

      for(i = 0; i < this.cargo.length; ++i) {
         if (this.cargo[i] != null) {
            tag.func_74782_a("Cargo " + i, this.cargo[i].func_77955_b(new NBTTagCompound()));
         }
      }

      if (this.fuel != null) {
         tag.func_74782_a("Fuel", this.fuel.func_77955_b(new NBTTagCompound()));
      }

      tag.func_74768_a("FuelInTank", (int)this.fuelInTank);
      Iterator var4 = this.parts.values().iterator();

      while(var4.hasNext()) {
         DriveablePart part = (DriveablePart)var4.next();
         part.writeToNBT(tag);
      }

   }

   public int func_70302_i_() {
      return this.getFuelSlot() + 1;
   }

   public ItemStack func_70301_a(int i) {
      ItemStack[] inv = this.ammo;
      if (i >= this.ammo.length) {
         i -= this.ammo.length;
         inv = this.bombs;
         if (i >= this.bombs.length) {
            i -= this.bombs.length;
            inv = this.missiles;
            if (i >= this.missiles.length) {
               i -= this.missiles.length;
               inv = this.cargo;
               if (i >= this.cargo.length) {
                  return this.fuel;
               }
            }
         }
      }

      return inv[i];
   }

   public ItemStack func_70298_a(int i, int j) {
      ItemStack[] inv = this.ammo;
      if (i >= this.ammo.length) {
         i -= this.ammo.length;
         inv = this.bombs;
         if (i >= this.bombs.length) {
            i -= this.bombs.length;
            inv = this.missiles;
            if (i >= this.missiles.length) {
               i -= this.missiles.length;
               inv = this.cargo;
               if (i >= this.cargo.length) {
                  i -= this.cargo.length;
                  inv = new ItemStack[]{this.fuel};
                  this.func_70299_a(this.getFuelSlot(), (ItemStack)null);
               }
            }
         }
      }

      if (inv[i] != null) {
         ItemStack itemstack1;
         if (inv[i].field_77994_a <= j) {
            itemstack1 = inv[i];
            inv[i] = null;
            return itemstack1;
         } else {
            itemstack1 = inv[i].func_77979_a(j);
            if (inv[i].field_77994_a <= 0) {
               inv[i] = null;
            }

            return itemstack1;
         }
      } else {
         return null;
      }
   }

   public ItemStack func_70304_b(int i) {
      return this.func_70301_a(i);
   }

   public void func_70299_a(int i, ItemStack stack) {
      if (stack != null) {
         this.inventoryChanged = true;
      }

      ItemStack[] inv = this.ammo;
      if (i >= this.ammo.length) {
         i -= this.ammo.length;
         inv = this.bombs;
         if (i >= this.bombs.length) {
            i -= this.bombs.length;
            inv = this.missiles;
            if (i >= this.missiles.length) {
               i -= this.missiles.length;
               inv = this.cargo;
               if (i >= this.cargo.length) {
                  this.fuel = stack;
                  return;
               }
            }
         }
      }

      inv[i] = stack;
   }

   public String func_145825_b() {
      return "Flan's Secret Data";
   }

   public int func_70297_j_() {
      return 64;
   }

   public void func_70296_d() {
   }

   public boolean func_70300_a(EntityPlayer player) {
      return true;
   }

   public void func_70295_k_() {
   }

   public void func_70305_f() {
   }

   public int getAmmoInventoryStart() {
      return 0;
   }

   public int getBombInventoryStart() {
      return this.ammo.length;
   }

   public int getMissileInventoryStart() {
      return this.ammo.length + this.bombs.length;
   }

   public int getCargoInventoryStart() {
      return this.ammo.length + this.bombs.length + this.missiles.length;
   }

   public int getFuelSlot() {
      return this.ammo.length + this.bombs.length + this.missiles.length + this.cargo.length;
   }

   public boolean func_145818_k_() {
      return false;
   }

   public boolean func_94041_b(int i, ItemStack itemstack) {
      if (i < this.getBombInventoryStart() && itemstack != null && itemstack.func_77973_b() instanceof ItemBullet) {
         return true;
      } else if (i >= this.getBombInventoryStart() && i < this.getMissileInventoryStart() && itemstack != null && itemstack.func_77973_b() instanceof ItemBullet) {
         return true;
      } else if (i >= this.getMissileInventoryStart() && i < this.getCargoInventoryStart() && itemstack != null && itemstack.func_77973_b() instanceof ItemBullet) {
         return true;
      } else if (i >= this.getCargoInventoryStart() && i < this.getFuelSlot()) {
         return true;
      } else {
         return i == this.getFuelSlot() && itemstack != null && itemstack.func_77973_b() instanceof ItemPart && ((ItemPart)itemstack.func_77973_b()).type.category == 9;
      }
   }
}
