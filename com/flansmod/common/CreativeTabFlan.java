package com.flansmod.common;

import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EnumPlaneMode;
import com.flansmod.common.driveables.ItemPlane;
import com.flansmod.common.driveables.ItemVehicle;
import com.flansmod.common.guns.ItemAAGun;
import com.flansmod.common.guns.ItemAttachment;
import com.flansmod.common.guns.ItemBullet;
import com.flansmod.common.guns.ItemGrenade;
import com.flansmod.common.types.IFlanItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class CreativeTabFlan extends CreativeTabs {
   public int type;
   public int icon;
   public int time = 0;

   public CreativeTabFlan(int i) {
      super("tabFlan" + i);
      this.type = i;
   }

   public Item func_78016_d() {
      return null;
   }

   public ItemStack func_151244_d() {
      return new ItemStack(FlansMod.workbench);
   }

   @SideOnly(Side.CLIENT)
   public void func_78018_a(List list) {
      super.func_78018_a(list);
      Comparator cmp = new Comparator<ItemStack>() {
         public int compare(ItemStack is1, ItemStack is2) {
            String s1 = is1.func_77977_a();
            String s2 = is2.func_77977_a();
            Item i1 = is1.func_77973_b();
            Item i2 = is2.func_77973_b();
            if (i1 instanceof IFlanItem && i2 instanceof IFlanItem) {
               String it1 = ((IFlanItem)i1).getInfoType().packName;
               String it2 = ((IFlanItem)i2).getInfoType().packName;
               int cmp = it1.compareTo(it2);
               if (cmp != 0) {
                  return cmp;
               }
            }

            if (i1 instanceof ItemBlockManyNames && !(i2 instanceof ItemBlockManyNames)) {
               return -1;
            } else if (!(i1 instanceof ItemBlockManyNames) && i2 instanceof ItemBlockManyNames) {
               return 1;
            } else if (i1 instanceof ItemBlock && !(i2 instanceof ItemBlock)) {
               return -1;
            } else if (!(i1 instanceof ItemBlock) && i2 instanceof ItemBlock) {
               return 1;
            } else if (i1 instanceof ItemAttachment && !(i2 instanceof ItemAttachment)) {
               return -1;
            } else if (!(i1 instanceof ItemAttachment) && i2 instanceof ItemAttachment) {
               return 1;
            } else if (i1 instanceof ItemAAGun && !(i2 instanceof ItemAAGun)) {
               return -1;
            } else if (!(i1 instanceof ItemAAGun) && i2 instanceof ItemAAGun) {
               return 1;
            } else if (i1 instanceof ItemVehicle && i2 instanceof ItemBullet) {
               return 1;
            } else if (i1 instanceof ItemBullet && i2 instanceof ItemVehicle) {
               return -1;
            } else if (i1 instanceof ItemPlane && i2 instanceof ItemBullet) {
               return 1;
            } else if (i1 instanceof ItemBullet && i2 instanceof ItemPlane) {
               return -1;
            } else {
               DriveableType dt1 = null;
               DriveableType dt2 = null;
               if (i1 instanceof ItemVehicle) {
                  dt1 = ((ItemVehicle)i1).type;
               }

               if (i2 instanceof ItemVehicle) {
                  dt2 = ((ItemVehicle)i2).type;
               }

               if (i1 instanceof ItemPlane) {
                  dt1 = ((ItemPlane)i1).type;
               }

               if (i2 instanceof ItemPlane) {
                  dt2 = ((ItemPlane)i2).type;
               }

               if (dt1 != null && dt2 != null) {
                  String ct1 = "";
                  String ct2 = "";
                  if (((DriveableType)dt1).modelString.indexOf(".") >= 1) {
                     ct1 = ((DriveableType)dt1).modelString.substring(0, ((DriveableType)dt1).modelString.indexOf(".") - 1);
                  }

                  if (((DriveableType)dt2).modelString.indexOf(".") >= 1) {
                     ct1 = ((DriveableType)dt2).modelString.substring(0, ((DriveableType)dt2).modelString.indexOf(".") - 1);
                  }

                  if (!ct1.equals(ct2)) {
                     return ct1.compareTo(ct2);
                  }
               }

               if (i1 instanceof ItemVehicle && !(i2 instanceof ItemVehicle)) {
                  return -1;
               } else if (!(i1 instanceof ItemVehicle) && i2 instanceof ItemVehicle) {
                  return 1;
               } else if (i1 instanceof ItemPlane && !(i2 instanceof ItemPlane)) {
                  return -1;
               } else if (!(i1 instanceof ItemPlane) && i2 instanceof ItemPlane) {
                  return 1;
               } else if (i1 instanceof ItemPlane && i2 instanceof ItemPlane) {
                  EnumPlaneMode epm1 = ((ItemPlane)i1).type.mode;
                  EnumPlaneMode epm2 = ((ItemPlane)i2).type.mode;
                  return epm1.compareTo(epm2);
               } else if (!(i1 instanceof ItemGrenade) && i2 instanceof ItemGrenade) {
                  return -1;
               } else {
                  return i1 instanceof ItemGrenade && !(i2 instanceof ItemGrenade) ? 1 : s1.compareTo(s2);
               }
            }
         }
      };

      try {
         Collections.sort(list, cmp);
      } catch (Exception var4) {
      }

   }
}
