package com.flansmod.common;

import com.flansmod.client.model.GunAnimations;
import com.flansmod.common.driveables.CollisionBox;
import com.flansmod.common.driveables.ContainerDriveableInventory;
import com.flansmod.common.driveables.ContainerDriveableMenu;
import com.flansmod.common.driveables.DriveablePart;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.driveables.EnumDriveablePart;
import com.flansmod.common.driveables.mechas.ContainerMechaInventory;
import com.flansmod.common.driveables.mechas.EntityMecha;
import com.flansmod.common.guns.ContainerGunModTable;
import com.flansmod.common.guns.boxes.ContainerGunBox;
import com.flansmod.common.guns.boxes.GunBoxType;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketBreakSound;
import com.flansmod.common.paintjob.ContainerPaintjobTable;
import com.flansmod.common.paintjob.TileEntityPaintjobTable;
import com.flansmod.common.parts.ItemPart;
import com.flansmod.common.parts.PartType;
import com.flansmod.common.teams.ArmourBoxType;
import com.flansmod.common.types.EnumType;
import com.flansmod.common.types.InfoType;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class CommonProxy {
   protected static Pattern zipJar = Pattern.compile("(.+).(zip|jar)$");

   public List<File> getContentList(Method method, ClassLoader classloader) {
      List<File> contentPacks = new ArrayList();
      File[] var4 = FlansMod.flanDir.listFiles();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         File file = var4[var6];
         if (file.isDirectory() || zipJar.matcher(file.getName()).matches()) {
            FlansMod.log("Loaded content pack : " + file.getName());
            contentPacks.add(file);
         }
      }

      FlansMod.log("Loaded content pack list server side.");
      return contentPacks;
   }

   public void load() {
   }

   public void forceReload() {
   }

   public void registerRenderers() {
   }

   public void doTutorialStuff(EntityPlayer player, EntityDriveable entityType) {
   }

   public void changeControlMode(EntityPlayer player) {
   }

   public boolean mouseControlEnabled() {
      return false;
   }

   public void openDriveableMenu(EntityPlayer player, World world, EntityDriveable driveable) {
   }

   public <T> T loadModel(String s, String shortName, Class<T> typeClass) {
      return null;
   }

   public void loadSound(String contentPack, String type, String sound) {
   }

   public boolean isThePlayer(EntityPlayer player) {
      return false;
   }

   public EntityPlayer getThePlayer() {
      return null;
   }

   public boolean isOnSameTeamClientPlayer(EntityLivingBase entity) {
      return false;
   }

   public void buyGun(GunBoxType type, InfoType gun) {
   }

   public void buyAmmo(GunBoxType box, int ammo, int type) {
   }

   public Object getClientGui(int ID, EntityPlayer player, World world, int x, int y, int z) {
      return null;
   }

   public HashMap<EntityLivingBase, GunAnimations> getAnimations(boolean left) {
      return left ? FlansMod.gunAnimationsLeft : FlansMod.gunAnimationsRight;
   }

   public Container getServerGui(int ID, EntityPlayer player, World world, int x, int y, int z) {
      switch(ID) {
      case 0:
         return null;
      case 1:
         return null;
      case 2:
         return new ContainerGunModTable(player.field_71071_by, world);
      case 3:
         return new ContainerDriveableMenu(player.field_71071_by, world);
      case 4:
         return new ContainerDriveableMenu(player.field_71071_by, world, true, ((EntitySeat)player.field_70154_o).driveable);
      case 5:
         return new ContainerGunBox(player.field_71071_by, world);
      case 6:
         return new ContainerDriveableInventory(player.field_71071_by, world, ((EntitySeat)player.field_70154_o).driveable, 0);
      case 7:
         return new ContainerDriveableInventory(player.field_71071_by, world, ((EntitySeat)player.field_70154_o).driveable, 1);
      case 8:
         return new ContainerDriveableMenu(player.field_71071_by, world, true, ((EntitySeat)player.field_70154_o).driveable);
      case 9:
         return new ContainerDriveableInventory(player.field_71071_by, world, ((EntitySeat)player.field_70154_o).driveable, 2);
      case 10:
         return new ContainerMechaInventory(player.field_71071_by, world, (EntityMecha)((EntitySeat)player.field_70154_o).driveable);
      case 11:
         return null;
      case 12:
         return new ContainerDriveableInventory(player.field_71071_by, world, ((EntitySeat)player.field_70154_o).driveable, 3);
      case 13:
         return new ContainerPaintjobTable(player.field_71071_by, world, (TileEntityPaintjobTable)world.func_147438_o(x, y, z));
      default:
         return null;
      }
   }

   public void playBlockBreakSound(int x, int y, int z, Block blockHit) {
      FlansMod.packetHandler.sendToAll((PacketBase)(new PacketBreakSound(x, y, z, blockHit)));
   }

   public void addItem(EntityPlayer player, int id) {
      ItemStack item = new ItemStack(Item.func_150899_d(id), 1, 4);
      player.field_71071_by.func_70441_a(item);
      ArrayList<ItemStack> dirts = new ArrayList();
      dirts.add(0, new ItemStack(Item.func_150899_d(3)));
      CraftingInstance crafting = new CraftingInstance(player.field_71071_by, dirts, new ItemStack(Item.func_150899_d(id)));
      if (crafting.canCraft()) {
         crafting.craft(player.field_71071_by.field_70458_d);
      }

   }

   public void craftDriveable(EntityPlayer player, DriveableType type) {
      InventoryPlayer temporaryInventory = new InventoryPlayer((EntityPlayer)null);
      temporaryInventory.func_70455_b(player.field_71071_by);
      boolean canCraft = true;
      Iterator var5 = type.driveableRecipe.iterator();

      int numEnginesAcquired;
      ItemStack driveableStack;
      while(var5.hasNext()) {
         ItemStack recipeStack = (ItemStack)var5.next();
         int totalAmountFound = 0;

         for(numEnginesAcquired = 0; numEnginesAcquired < player.field_71071_by.func_70302_i_(); ++numEnginesAcquired) {
            driveableStack = player.field_71071_by.func_70301_a(numEnginesAcquired);
            if (driveableStack != null && driveableStack.func_77973_b() == recipeStack.func_77973_b() && driveableStack.func_77960_j() == recipeStack.func_77960_j()) {
               int amountFound = Math.min(driveableStack.field_77994_a, recipeStack.field_77994_a - totalAmountFound);
               driveableStack.field_77994_a -= amountFound;
               if (driveableStack.field_77994_a <= 0) {
                  driveableStack = null;
               }

               player.field_71071_by.func_70299_a(numEnginesAcquired, driveableStack);
               totalAmountFound += amountFound;
               if (totalAmountFound == recipeStack.field_77994_a) {
                  break;
               }
            }
         }

         if (totalAmountFound < recipeStack.field_77994_a) {
            canCraft = false;
            break;
         }
      }

      if (!canCraft) {
         player.field_71071_by.func_70455_b(temporaryInventory);
      } else {
         HashMap<PartType, ItemStack> engines = new HashMap();

         ItemStack bestEngineStack;
         for(int n = 0; n < temporaryInventory.func_70302_i_(); ++n) {
            bestEngineStack = temporaryInventory.func_70301_a(n);
            if (bestEngineStack != null && bestEngineStack.func_77973_b() instanceof ItemPart) {
               PartType partType = ((ItemPart)bestEngineStack.func_77973_b()).type;
               if (partType.category == 2 && partType.worksWith.contains(EnumType.getFromObject(type))) {
                  if (engines.containsKey(partType)) {
                     ItemStack var10000 = (ItemStack)engines.get(partType);
                     var10000.field_77994_a += bestEngineStack.field_77994_a;
                  } else {
                     engines.put(partType, bestEngineStack);
                  }
               }
            }
         }

         float bestEngineSpeed = -1.0F;
         bestEngineStack = null;
         Iterator var20 = engines.keySet().iterator();

         while(var20.hasNext()) {
            PartType part = (PartType)var20.next();
            if (part.engineSpeed > bestEngineSpeed && ((ItemStack)engines.get(part)).field_77994_a >= type.numEngines()) {
               bestEngineSpeed = part.engineSpeed;
               bestEngineStack = (ItemStack)engines.get(part);
            }
         }

         if (bestEngineStack == null) {
            player.field_71071_by.func_70455_b(temporaryInventory);
         } else {
            numEnginesAcquired = 0;

            for(int n = 0; n < player.field_71071_by.func_70302_i_(); ++n) {
               ItemStack stackInSlot = player.field_71071_by.func_70301_a(n);
               if (stackInSlot != null && stackInSlot.func_77973_b() == bestEngineStack.func_77973_b()) {
                  int amountFound = Math.min(stackInSlot.field_77994_a, type.numEngines() - numEnginesAcquired);
                  stackInSlot.field_77994_a -= amountFound;
                  if (stackInSlot.field_77994_a <= 0) {
                     stackInSlot = null;
                  }

                  player.field_71071_by.func_70299_a(n, stackInSlot);
                  numEnginesAcquired += amountFound;
                  if (numEnginesAcquired == type.numEngines()) {
                     break;
                  }
               }
            }

            driveableStack = new ItemStack(type.item);
            NBTTagCompound tags = new NBTTagCompound();
            tags.func_74778_a("Engine", ((ItemPart)bestEngineStack.func_77973_b()).type.shortName);
            tags.func_74778_a("Type", type.shortName);
            EnumDriveablePart[] var25 = EnumDriveablePart.values();
            int var12 = var25.length;

            for(int var13 = 0; var13 < var12; ++var13) {
               EnumDriveablePart part = var25[var13];
               tags.func_74768_a(part.getShortName() + "_Health", type.health.get(part) == null ? 0 : ((CollisionBox)type.health.get(part)).health);
               tags.func_74757_a(part.getShortName() + "_Fire", false);
            }

            driveableStack.field_77990_d = tags;
            if (!player.field_71071_by.func_70441_a(driveableStack)) {
               player.func_71019_a(driveableStack, false);
            }

         }
      }
   }

   public void repairDriveable(EntityPlayer driver, EntityDriveable driving, DriveablePart part) {
      EnumDriveablePart[] var4 = part.type.getParents();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         EnumDriveablePart parent = var4[var6];
         if (!driving.isPartIntact(parent)) {
            return;
         }
      }

      InventoryPlayer temporaryInventory = new InventoryPlayer((EntityPlayer)null);
      temporaryInventory.func_70455_b(driver.field_71071_by);
      boolean canRepair = true;
      ArrayList<ItemStack> stacksNeeded = driving.getDriveableType().getItemsRequired(part, driving.getDriveableData().engine);
      Iterator var16 = stacksNeeded.iterator();

      while(var16.hasNext()) {
         ItemStack stackNeeded = (ItemStack)var16.next();
         int totalAmountFound = 0;

         for(int m = 0; m < temporaryInventory.func_70302_i_(); ++m) {
            ItemStack stackInSlot = temporaryInventory.func_70301_a(m);
            if (stackInSlot != null && stackInSlot.func_77973_b() == stackNeeded.func_77973_b() && stackInSlot.func_77960_j() == stackNeeded.func_77960_j()) {
               int amountFound = Math.min(stackInSlot.field_77994_a, stackNeeded.field_77994_a - totalAmountFound);
               stackInSlot.field_77994_a -= amountFound;
               if (stackInSlot.field_77994_a <= 0) {
                  stackInSlot = null;
               }

               temporaryInventory.func_70299_a(m, stackInSlot);
               totalAmountFound += amountFound;
               if (totalAmountFound == stackNeeded.field_77994_a) {
                  break;
               }
            }
         }

         if (totalAmountFound < stackNeeded.field_77994_a) {
            canRepair = false;
         }
      }

      if (canRepair) {
         driver.field_71071_by.func_70455_b(temporaryInventory);
         part.health = Math.max(1, part.maxHealth / 10);
         part.onFire = false;
         part.dead = false;
         driving.checkParts();
      }

   }

   public boolean isScreenOpen() {
      return false;
   }

   public boolean isKeyDown(int key) {
      return false;
   }

   public boolean keyDown(int keycode) {
      return false;
   }

   public void buyArmour(String shortName, int piece, ArmourBoxType type) {
   }

   public void spawnParticle(String p_72869_1_, double p_72869_2_, double p_72869_4_, double p_72869_6_, double p_72869_8_, double p_72869_10_, double p_72869_12_) {
   }

   public float getMouseSensitivity() {
      return 0.5F;
   }
}
