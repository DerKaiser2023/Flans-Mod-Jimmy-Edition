package com.flansmod.common.types;

import com.flansmod.common.driveables.EntityPlane;
import com.flansmod.common.driveables.EntityVehicle;
import com.flansmod.common.driveables.ItemPlane;
import com.flansmod.common.driveables.ItemVehicle;
import com.flansmod.common.driveables.PlaneType;
import com.flansmod.common.driveables.VehicleType;
import com.flansmod.common.driveables.mechas.EntityMecha;
import com.flansmod.common.driveables.mechas.ItemMecha;
import com.flansmod.common.driveables.mechas.ItemMechaAddon;
import com.flansmod.common.driveables.mechas.MechaItemType;
import com.flansmod.common.driveables.mechas.MechaType;
import com.flansmod.common.guns.AAGunType;
import com.flansmod.common.guns.AttachmentType;
import com.flansmod.common.guns.BulletType;
import com.flansmod.common.guns.EntityAAGun;
import com.flansmod.common.guns.EntityBullet;
import com.flansmod.common.guns.EntityGrenade;
import com.flansmod.common.guns.EntityMG;
import com.flansmod.common.guns.GrenadeType;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.ItemAAGun;
import com.flansmod.common.guns.ItemAttachment;
import com.flansmod.common.guns.ItemBullet;
import com.flansmod.common.guns.ItemGrenade;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.guns.boxes.BlockGunBox;
import com.flansmod.common.guns.boxes.GunBoxType;
import com.flansmod.common.parts.ItemPart;
import com.flansmod.common.parts.PartType;
import com.flansmod.common.teams.ArmourBoxType;
import com.flansmod.common.teams.ArmourType;
import com.flansmod.common.teams.BlockArmourBox;
import com.flansmod.common.teams.ItemTeamArmour;
import com.flansmod.common.teams.PlayerClass;
import com.flansmod.common.teams.Team;
import com.flansmod.common.tools.ItemTool;
import com.flansmod.common.tools.ToolType;

public enum EnumType {
   part("parts"),
   bullet("bullets"),
   attachment("attachments"),
   grenade("grenades"),
   gun("guns"),
   aa("aaguns"),
   vehicle("vehicles"),
   plane("planes"),
   mechaItem("mechaItems"),
   mecha("mechas"),
   tool("tools"),
   armour("armorFiles"),
   armourBox("armorBoxes"),
   box("boxes"),
   playerClass("classes"),
   team("teams"),
   itemHolder("itemHolders");

   public String folderName;

   private EnumType(String s) {
      this.folderName = s;
   }

   public static EnumType get(String s) {
      EnumType[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         EnumType e = var1[var3];
         if (e.folderName.equals(s)) {
            return e;
         }
      }

      return null;
   }

   public Class<? extends InfoType> getTypeClass() {
      switch(this) {
      case bullet:
         return BulletType.class;
      case aa:
         return AAGunType.class;
      case vehicle:
         return VehicleType.class;
      case plane:
         return PlaneType.class;
      case mechaItem:
         return MechaItemType.class;
      case mecha:
         return MechaType.class;
      case attachment:
         return AttachmentType.class;
      case gun:
         return GunType.class;
      case grenade:
         return GrenadeType.class;
      case tool:
         return ToolType.class;
      case armour:
         return ArmourType.class;
      case armourBox:
         return ArmourBoxType.class;
      case playerClass:
         return PlayerClass.class;
      case team:
         return Team.class;
      case box:
         return GunBoxType.class;
      case part:
         return PartType.class;
      default:
         return InfoType.class;
      }
   }

   public static EnumType getFromObject(Object o) {
      if (!(o instanceof MechaType) && !(o instanceof ItemMecha) && !(o instanceof EntityMecha)) {
         if (!(o instanceof PlaneType) && !(o instanceof ItemPlane) && !(o instanceof EntityPlane)) {
            if (!(o instanceof VehicleType) && !(o instanceof ItemVehicle) && !(o instanceof EntityVehicle)) {
               if (!(o instanceof BulletType) && !(o instanceof ItemBullet) && !(o instanceof EntityBullet)) {
                  if (!(o instanceof AAGunType) && !(o instanceof ItemAAGun) && !(o instanceof EntityAAGun)) {
                     if (!(o instanceof MechaItemType) && !(o instanceof ItemMechaAddon)) {
                        if (!(o instanceof AttachmentType) && !(o instanceof ItemAttachment)) {
                           if (!(o instanceof GunType) && !(o instanceof ItemGun) && !(o instanceof EntityMG)) {
                              if (!(o instanceof GrenadeType) && !(o instanceof ItemGrenade) && !(o instanceof EntityGrenade)) {
                                 if (!(o instanceof ToolType) && !(o instanceof ItemTool)) {
                                    if (!(o instanceof ArmourType) && !(o instanceof ItemTeamArmour)) {
                                       if (!(o instanceof ArmourBoxType) && !(o instanceof BlockArmourBox)) {
                                          if (o instanceof PlayerClass) {
                                             return playerClass;
                                          } else if (o instanceof Team) {
                                             return team;
                                          } else if (!(o instanceof GunBoxType) && !(o instanceof BlockGunBox)) {
                                             return !(o instanceof PartType) && !(o instanceof ItemPart) ? null : part;
                                          } else {
                                             return box;
                                          }
                                       } else {
                                          return armourBox;
                                       }
                                    } else {
                                       return armour;
                                    }
                                 } else {
                                    return tool;
                                 }
                              } else {
                                 return grenade;
                              }
                           } else {
                              return gun;
                           }
                        } else {
                           return attachment;
                        }
                     } else {
                        return mechaItem;
                     }
                  } else {
                     return aa;
                  }
               } else {
                  return bullet;
               }
            } else {
               return vehicle;
            }
         } else {
            return plane;
         }
      } else {
         return mecha;
      }
   }
}
