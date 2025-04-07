package com.flansmod.common;

import com.flansmod.client.FlansModClient;
import com.flansmod.common.guns.EntityGrenade;
import com.flansmod.common.guns.EntityMG;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.guns.raytracing.PlayerSnapshot;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketSelectOffHandGun;
import com.flansmod.common.teams.PlayerClass;
import com.flansmod.common.teams.Team;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class PlayerData {
   public String username;
   public float prevRotationRoll;
   public float rotationRoll;
   public PlayerSnapshot[] snapshots;
   public int offHandGunSlot = 0;
   @SideOnly(Side.CLIENT)
   public ItemStack offHandGunStack;
   public EntityMG mountingGun;
   public int shootTimeRight;
   public int shootTimeLeft;
   public int shootClickDelay;
   public boolean isShootingRight;
   public boolean isShootingLeft;
   public float minigunSpeed = 0.0F;
   public boolean reloadingRight;
   public boolean reloadingLeft;
   public ArrayList<EntityGrenade> remoteExplosives = new ArrayList();
   public int loopedSoundDelay;
   public boolean shouldPlayCooldownSound;
   public boolean shouldPlayWarmupSound;
   public int meleeProgress;
   public int meleeLength;
   public int burstRoundsRemainingLeft = 0;
   public int burstRoundsRemainingRight = 0;
   public boolean isAmmoEmpty;
   public Vector3f[] lastMeleePositions;
   public Vector3f[] lastMeleeLeftPositions;
   public Vector3f[] lastMeleeRightPositions;
   public Vector3f[] lastMeleeDownPositions;
   public int meleeProgressLeft;
   public int meleeLengthLeft;
   public int meleeLeftLength;
   public int meleeProgressRight;
   public int meleeLengthRight;
   public int meleeRightLength;
   public int meleeProgressDown;
   public int meleeLengthDown;
   public int meleeDownLength;
   public int score;
   public int kills;
   public int deaths;
   public int shekels;
   public int totalScore;
   public int zombieScore;
   public boolean out;
   public int vote;
   public Team team;
   public Team newTeam;
   public PlayerClass playerClass;
   public PlayerClass newPlayerClass;
   public boolean builder;
   @SideOnly(Side.CLIENT)
   public ResourceLocation skin;

   public PlayerData(String name) {
      this.username = name;
      this.snapshots = new PlayerSnapshot[20];
   }

   public void tick(EntityPlayer player) {
      if (player.field_70170_p.field_72995_K) {
         this.clientTick(player);
      }

      if (this.shootTimeRight > 0) {
         --this.shootTimeRight;
      }

      if (this.shootTimeRight == 0) {
         this.reloadingRight = false;
      }

      if (this.shootTimeLeft > 0) {
         --this.shootTimeLeft;
      }

      if (this.shootTimeLeft == 0) {
         this.reloadingLeft = false;
      }

      if (this.shootClickDelay > 0) {
         --this.shootClickDelay;
      }

      if (this.isShootingRight && !this.reloadingRight) {
         this.minigunSpeed += 2.0F;
      }

      this.minigunSpeed *= 0.9F;
      if (this.loopedSoundDelay > 0) {
         --this.loopedSoundDelay;
         if (this.loopedSoundDelay == 0 && !this.isShootingRight) {
            this.shouldPlayCooldownSound = true;
         }
      }

      System.arraycopy(this.snapshots, 0, this.snapshots, 1, this.snapshots.length - 2 + 1);
      this.snapshots[0] = new PlayerSnapshot(player);
   }

   public void clientTick(EntityPlayer player) {
      if (player.func_71045_bC() == null || !(player.func_71045_bC().func_77973_b() instanceof ItemGun) || ((ItemGun)player.func_71045_bC().func_77973_b()).type.oneHanded || player.func_71045_bC() == this.offHandGunStack) {
         this.offHandGunStack = null;
      }

   }

   public PlayerClass getPlayerClass() {
      if (this.playerClass != this.newPlayerClass) {
         this.playerClass = this.newPlayerClass;
      }

      return this.playerClass;
   }

   public void resetScore() {
      this.score = this.zombieScore = this.kills = this.deaths = 0;
      this.team = this.newTeam = null;
      this.playerClass = this.newPlayerClass = null;
   }

   public void playerKilled() {
      this.mountingGun = null;
      this.isShootingRight = this.isShootingLeft = false;
      this.snapshots = new PlayerSnapshot[20];
   }

   public void selectOffHandWeapon(EntityPlayer player, int slot) {
      if (this.isValidOffHandWeapon(player, slot)) {
         this.offHandGunSlot = slot;
      }

   }

   public boolean isValidOffHandWeapon(EntityPlayer player, int slot) {
      if (slot == 0) {
         return true;
      } else if (slot - 1 == player.field_71071_by.field_70461_c) {
         return false;
      } else {
         ItemStack stackInSlot = player.field_71071_by.func_70301_a(slot - 1);
         if (stackInSlot == null) {
            return false;
         } else {
            if (stackInSlot.func_77973_b() instanceof ItemGun) {
               ItemGun item = (ItemGun)stackInSlot.func_77973_b();
               if (item.type.oneHanded) {
                  return true;
               }
            }

            return false;
         }
      }
   }

   public void cycleOffHandItem(EntityPlayer player, int dWheel) {
      if (dWheel < 0) {
         for(this.offHandGunSlot = (this.offHandGunSlot + 1) % 10; !this.isValidOffHandWeapon(player, this.offHandGunSlot); this.offHandGunSlot = (this.offHandGunSlot + 1) % 10) {
         }
      } else if (dWheel > 0) {
         for(this.offHandGunSlot = (this.offHandGunSlot + 9) % 10; !this.isValidOffHandWeapon(player, this.offHandGunSlot); this.offHandGunSlot = (this.offHandGunSlot + 9) % 10) {
         }
      }

      FlansModClient.currentScope = null;
      FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketSelectOffHandGun(this.offHandGunSlot)));
   }

   public void doMelee(EntityPlayer player, int meleeTime, GunType type) {
      this.meleeLength = meleeTime;
      this.lastMeleePositions = new Vector3f[type.meleePath.size()];

      for(int k = 0; k < type.meleeDamagePoints.size(); ++k) {
         Vector3f meleeDamagePoint = (Vector3f)type.meleeDamagePoints.get(k);
         Vector3f nextPos = (Vector3f)type.meleePath.get(0);
         Vector3f nextAngles = (Vector3f)type.meleePathAngles.get(0);
         RotatedAxes nextAxes = new RotatedAxes(-nextAngles.y, -nextAngles.z, nextAngles.x);
         Vector3f nextPosInPlayerCoords = (new RotatedAxes(player.field_70177_z + 90.0F, player.field_70125_A, 0.0F)).findLocalVectorGlobally(nextAxes.findLocalVectorGlobally(meleeDamagePoint));
         Vector3f.add(nextPos, nextPosInPlayerCoords, nextPosInPlayerCoords);
         if (!FlansMod.proxy.isThePlayer(player)) {
            ++nextPosInPlayerCoords.y;
         }

         this.lastMeleePositions[k] = new Vector3f(player.field_70165_t + (double)nextPosInPlayerCoords.x, player.field_70163_u + (double)nextPosInPlayerCoords.y, player.field_70161_v + (double)nextPosInPlayerCoords.z);
      }

   }

   public void doMeleeLeft(EntityPlayer player, int meleeLeftTime, GunType type) {
      this.meleeLeftLength = meleeLeftTime;
      this.lastMeleeLeftPositions = new Vector3f[type.meleeLeftPath.size()];

      for(int k = 0; k < type.meleeLeftDamagePoints.size(); ++k) {
         Vector3f meleeDamagePoint = (Vector3f)type.meleeLeftDamagePoints.get(k);
         Vector3f nextPos = (Vector3f)type.meleeLeftPath.get(0);
         Vector3f nextAngles = (Vector3f)type.meleeLeftPathAngles.get(0);
         RotatedAxes nextAxes = new RotatedAxes(-nextAngles.y, -nextAngles.z, nextAngles.x);
         Vector3f nextPosInPlayerCoordsLeft = (new RotatedAxes(player.field_70177_z + 90.0F, player.field_70125_A, 0.0F)).findLocalVectorGlobally(nextAxes.findLocalVectorGlobally(meleeDamagePoint));
         Vector3f.add(nextPos, nextPosInPlayerCoordsLeft, nextPosInPlayerCoordsLeft);
         if (!FlansMod.proxy.isThePlayer(player)) {
            ++nextPosInPlayerCoordsLeft.y;
         }

         this.lastMeleeLeftPositions[k] = new Vector3f(player.field_70165_t + (double)nextPosInPlayerCoordsLeft.x, player.field_70163_u + (double)nextPosInPlayerCoordsLeft.y, player.field_70161_v + (double)nextPosInPlayerCoordsLeft.z);
      }

   }

   public void doMeleeRight(EntityPlayer player, int meleeRightTime, GunType type) {
      this.meleeRightLength = meleeRightTime;
      this.lastMeleeRightPositions = new Vector3f[type.meleeRightPath.size()];

      for(int k = 0; k < type.meleeRightDamagePoints.size(); ++k) {
         Vector3f meleeDamagePoint = (Vector3f)type.meleeRightDamagePoints.get(k);
         Vector3f nextPos = (Vector3f)type.meleeRightPath.get(0);
         Vector3f nextAngles = (Vector3f)type.meleeRightPathAngles.get(0);
         RotatedAxes nextAxes = new RotatedAxes(-nextAngles.y, -nextAngles.z, nextAngles.x);
         Vector3f nextPosInPlayerCoords = (new RotatedAxes(player.field_70177_z + 90.0F, player.field_70125_A, 0.0F)).findLocalVectorGlobally(nextAxes.findLocalVectorGlobally(meleeDamagePoint));
         Vector3f.add(nextPos, nextPosInPlayerCoords, nextPosInPlayerCoords);
         if (!FlansMod.proxy.isThePlayer(player)) {
            ++nextPosInPlayerCoords.y;
         }

         this.lastMeleeRightPositions[k] = new Vector3f(player.field_70165_t + (double)nextPosInPlayerCoords.x, player.field_70163_u + (double)nextPosInPlayerCoords.y, player.field_70161_v + (double)nextPosInPlayerCoords.z);
      }

   }

   public void doMeleeDown(EntityPlayer player, int meleeDownTime, GunType type) {
      this.meleeDownLength = meleeDownTime;
      this.lastMeleeDownPositions = new Vector3f[type.meleeDownPath.size()];

      for(int k = 0; k < type.meleeDownDamagePoints.size(); ++k) {
         Vector3f meleeDamagePointDown = (Vector3f)type.meleeDownDamagePoints.get(k);
         Vector3f nextPosDown = (Vector3f)type.meleeDownPath.get(0);
         Vector3f nextAnglesDown = (Vector3f)type.meleeDownPathAngles.get(0);
         RotatedAxes nextAxesDown = new RotatedAxes(-nextAnglesDown.y, -nextAnglesDown.z, nextAnglesDown.x);
         Vector3f nextPosInPlayerCoordsDown = (new RotatedAxes(player.field_70177_z + 90.0F, player.field_70125_A, 0.0F)).findLocalVectorGlobally(nextAxesDown.findLocalVectorGlobally(meleeDamagePointDown));
         Vector3f.add(nextPosDown, nextPosInPlayerCoordsDown, nextPosInPlayerCoordsDown);
         if (!FlansMod.proxy.isThePlayer(player)) {
            ++nextPosInPlayerCoordsDown.y;
         }

         this.lastMeleeDownPositions[k] = new Vector3f(player.field_70165_t + (double)nextPosInPlayerCoordsDown.x, player.field_70163_u + (double)nextPosInPlayerCoordsDown.y, player.field_70161_v + (double)nextPosInPlayerCoordsDown.z);
      }

   }
}
