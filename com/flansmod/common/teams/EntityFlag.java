package com.flansmod.common.teams;

import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFlag extends Entity implements ITeamObject {
   public int baseID;
   public EntityFlagpole base;
   public boolean isHome;
   public int timeUntilReturn;

   public EntityFlag(World world) {
      super(world);
      this.isHome = true;
      this.func_70105_a(1.0F, 1.0F);
      this.field_70155_l = 100.0D;
      this.field_70158_ak = true;
   }

   public EntityFlag(World world, EntityFlagpole pole) {
      this(world);
      this.func_70107_b(pole.field_70165_t, pole.field_70163_u + 2.0D, pole.field_70161_v);
      this.setBase(pole);
   }

   public boolean func_70067_L() {
      return true;
   }

   protected void func_70088_a() {
      this.field_70180_af.func_75682_a(2, (byte)0);
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if (this.base == null && !this.field_70170_p.field_72995_K) {
         this.setBase(TeamsManager.getInstance().getBase(this.baseID));
      }

      if (this.field_70154_o != null && this.field_70154_o.field_70128_L) {
         if (this.field_70154_o instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP)this.field_70154_o;
            Team team = PlayerHandler.getPlayerData(player.func_70005_c_()).team;
            TeamsManager.getInstance();
            TeamsManager.messageAll("§f" + player.func_70005_c_() + " dropped the §" + team.textColour + team.name + "§f flag");
         }

         this.func_70078_a((Entity)null);
      }

      if (!this.field_70175_ag) {
         this.field_70170_p.func_72838_d(this);
      }

      if (this.timeUntilReturn > 0) {
         if (this.field_70154_o == null && !this.isHome) {
            --this.timeUntilReturn;
            if (this.timeUntilReturn == 0) {
               this.reset();
               Team flagTeam = TeamsManager.getInstance().getTeam(this.getBase().getOwnerID());
               TeamsManager.messageAll("§fThe §" + flagTeam.textColour + flagTeam.name + "§f flag returned itself");
            }
         } else {
            this.timeUntilReturn = 0;
         }
      }

      if (this.field_70170_p.field_72995_K) {
         this.func_70066_B();
      }

   }

   public void func_70078_a(Entity entity) {
      if (entity == null) {
         if (TeamsManager.getInstance().currentRound != null && TeamsManager.getInstance().currentRound.gametype instanceof GametypeCTF) {
            this.timeUntilReturn = ((GametypeCTF)TeamsManager.getInstance().currentRound.gametype).flagReturnTime * 20;
         } else {
            this.timeUntilReturn = 600;
         }
      }

      super.func_70078_a(entity);
   }

   public void reset() {
      this.func_70078_a((Entity)null);
      this.func_70107_b(this.base.field_70165_t, this.base.field_70163_u + 2.0D, this.base.field_70161_v);
      this.isHome = true;
   }

   public boolean func_70039_c(NBTTagCompound tags) {
      return false;
   }

   protected void func_70037_a(NBTTagCompound tags) {
   }

   protected void func_70014_b(NBTTagCompound tags) {
   }

   public ITeamBase getBase() {
      return this.base;
   }

   public void onBaseSet(int newTeamID) {
      this.field_70180_af.func_75692_b(2, (byte)newTeamID);
      this.func_70107_b(this.base.field_70165_t, this.base.field_70163_u + 2.0D, this.base.field_70161_v);
   }

   public void onBaseCapture(int newTeamID) {
      this.onBaseSet(newTeamID);
   }

   public void tick() {
   }

   public void setBase(ITeamBase b) {
      this.base = (EntityFlagpole)b;
      if (this.base != null) {
         this.base.addObject(this);
         this.onBaseSet(this.base.getOwnerID());
      }

   }

   public void destroy() {
      this.func_70106_y();
   }

   public double getPosX() {
      return this.field_70165_t;
   }

   public double getPosY() {
      return this.field_70163_u;
   }

   public double getPosZ() {
      return this.field_70161_v;
   }

   public int getTeamID() {
      return this.field_70180_af.func_75683_a(2);
   }

   public boolean isSpawnPoint() {
      return false;
   }

   public boolean func_130002_c(EntityPlayer player) {
      return false;
   }

   public ItemStack getPickedResult(MovingObjectPosition target) {
      ItemStack stack = new ItemStack(FlansMod.flag, 1, 0);
      return stack;
   }

   public boolean forceChunkLoading() {
      return false;
   }

   public boolean func_70027_ad() {
      return false;
   }
}
