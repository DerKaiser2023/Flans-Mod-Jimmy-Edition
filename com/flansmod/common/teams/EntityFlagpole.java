package com.flansmod.common.teams;

import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFlagpole extends Entity implements ITeamBase {
   public int defaultTeamID;
   public int currentTeamID;
   public TeamsMap map;
   public List<ITeamObject> objects;
   public String name;
   private int ID;
   private EntityFlag flag;
   public static TeamsManager teamsManager = TeamsManager.getInstance();
   private boolean uninitialized;
   private int loadDistance;

   public EntityFlagpole(World world) {
      super(world);
      this.objects = new ArrayList();
      this.name = "Default Name";
      this.uninitialized = true;
      this.loadDistance = 1;
      this.func_70105_a(1.0F, 2.0F);
      this.field_70155_l = 100.0D;
   }

   public EntityFlagpole(World world, double x, double y, double z) {
      this(world);
      this.func_70107_b(x, y, z);
      this.flag = new EntityFlag(this.field_70170_p, this);
      this.objects.add(this.flag);
      this.field_70170_p.func_72838_d(this.flag);
      if (teamsManager.maps.size() > 0) {
         this.map = (TeamsMap)teamsManager.maps.values().iterator().next();
      }

   }

   public EntityFlagpole(World world, int x, int y, int z) {
      this(world, (double)x + 0.5D, (double)y, (double)z + 0.5D);
   }

   public AxisAlignedBB func_70046_E() {
      return null;
   }

   public boolean func_70067_L() {
      return true;
   }

   protected void func_70088_a() {
   }

   protected void func_70037_a(NBTTagCompound tags) {
      this.setBaseID(tags.func_74762_e("ID"));
      this.currentTeamID = this.defaultTeamID = tags.func_74762_e("TeamID");
      this.map = (TeamsMap)teamsManager.maps.get(tags.func_74779_i("Map"));
      this.name = tags.func_74779_i("Name");
      this.setMap(this.map);
   }

   protected void func_70014_b(NBTTagCompound tags) {
      tags.func_74768_a("TeamID", this.defaultTeamID);
      tags.func_74778_a("Map", this.map == null ? "" : this.map.shortName);
      tags.func_74768_a("ID", this.getBaseID());
      tags.func_74778_a("Name", this.name);
   }

   public TeamsMap getMap() {
      return this.map;
   }

   public void setMap(TeamsMap newMap) {
      if (newMap == null) {
         FlansMod.log("Flagpole given invalid map");
      } else {
         if (this.map != null && this.map != newMap) {
            this.map.removeBase(this);
         }

         this.map = newMap;
         newMap.addBase(this);
      }
   }

   public void setMapFirstTime(TeamsMap newMap) {
      if (newMap == null) {
         FlansMod.log("Flagpole given invalid map");
      } else {
         if (this.map != null && this.map != newMap) {
            this.map.removeBase(this);
         }

         this.map = newMap;
         newMap.addBaseFirstTime(this);
      }
   }

   public List<ITeamObject> getObjects() {
      return this.objects;
   }

   public void tick() {
   }

   public void startRound() {
      this.currentTeamID = this.defaultTeamID;
   }

   public void addObject(ITeamObject object) {
      this.objects.add(object);
   }

   public String getName() {
      return this.name;
   }

   public void setName(String newName) {
      this.name = newName;
   }

   public void destroy() {
      this.func_70106_y();
   }

   public Entity getEntity() {
      return this;
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

   public World getWorld() {
      return this.field_70170_p;
   }

   public void roundCleanup() {
      if (this.flag != null) {
         this.flag.reset();
      }

   }

   public ITeamObject getFlag() {
      return this.flag;
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if (!this.field_70170_p.field_72995_K) {
         if (this.flag == null) {
            this.flag = new EntityFlag(this.field_70170_p, this);
            this.objects.add(this.flag);
         }

         if (!this.flag.field_70175_ag) {
            this.field_70170_p.func_72838_d(this.flag);
         }

         if (this.flag.isHome) {
            this.flag.func_70107_b(this.field_70165_t, this.field_70163_u + 2.0D, this.field_70161_v);
         }
      }

      if (this.field_70170_p.field_72995_K) {
         this.func_70066_B();
      }

   }

   public void func_70106_y() {
      super.func_70106_y();
   }

   public boolean func_130002_c(EntityPlayer player) {
      PlayerData data = PlayerHandler.getPlayerData(player);
      if (!this.field_70170_p.field_72995_K && data.team == null && TeamsManager.getInstance().playerIsOp(player) && (player.func_71045_bC() == null || !(player.func_71045_bC().func_77973_b() instanceof ItemOpStick))) {
         ItemOpStick.openBaseEditGUI(this, (EntityPlayerMP)player);
      }

      return false;
   }

   public ItemStack getPickedResult(MovingObjectPosition target) {
      ItemStack stack = new ItemStack(FlansMod.flag, 1, 0);
      return stack;
   }

   public void setBaseID(int i) {
      this.ID = i;
   }

   public int getBaseID() {
      return this.ID;
   }

   public int getDefaultOwnerID() {
      return this.defaultTeamID;
   }

   public void setDefaultOwnerID(int id) {
      this.currentTeamID = this.defaultTeamID = id;
      Iterator var2 = this.objects.iterator();

      while(var2.hasNext()) {
         ITeamObject object = (ITeamObject)var2.next();
         object.onBaseSet(id);
      }

   }

   public int getOwnerID() {
      return this.currentTeamID;
   }

   public void setOwnerID(int id) {
      this.currentTeamID = id;
   }

   public boolean func_70027_ad() {
      return false;
   }
}
