package com.flansmod.common.teams;

import com.flansmod.common.FlansMod;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.ForgeChunkManager.Ticket;
import net.minecraftforge.common.ForgeChunkManager.Type;

public class TeamsMap {
   public String shortName;
   public String name;
   public Ticket chunkLoadingTicket;
   public ArrayList<ITeamBase> bases = new ArrayList();
   public int minPlayers = 0;
   public int maxPlayers = 1000000;

   public TeamsMap(World world, String sn, String n) {
      this.shortName = sn;
      this.name = n;
      this.chunkLoadingTicket = ForgeChunkManager.requestTicket(FlansMod.INSTANCE, world, Type.NORMAL);
      if (this.chunkLoadingTicket == null) {
         FlansMod.log("Failed to add chunk loading ticket as Flan's Mod has run out");
      } else {
         this.chunkLoadingTicket.getModData().func_74778_a("ShortName", this.shortName);
      }
   }

   public ArrayList<ITeamBase> getBasesPerTeam(int teamID) {
      ArrayList<ITeamBase> basesForThisTeam = new ArrayList();
      Iterator var3 = this.bases.iterator();

      while(var3.hasNext()) {
         ITeamBase base = (ITeamBase)var3.next();
         if (base.getOwnerID() == teamID) {
            basesForThisTeam.add(base);
         }
      }

      return basesForThisTeam;
   }

   public void addBase(ITeamBase base) {
      this.bases.add(base);
   }

   public void addBaseFirstTime(ITeamBase base) {
      this.addBase(base);
      ForgeChunkManager.forceChunk(this.chunkLoadingTicket, new ChunkCoordIntPair((int)base.getPosX() >> 4, (int)base.getPosZ() >> 4));
      FlansMod.log("Added chunk at " + ((int)base.getPosX() >> 4) + ",  " + ((int)base.getPosZ() >> 4) + " to chunk loading ticket for base " + this.name);
   }

   public void removeBase(ITeamBase base) {
      if (this.bases == null) {
         FlansMod.log("Base array for map " + this.name + " null");
      } else {
         this.bases.remove(base);
         ForgeChunkManager.unforceChunk(this.chunkLoadingTicket, new ChunkCoordIntPair((int)base.getPosX() >> 4, (int)base.getPosZ() >> 4));
         FlansMod.log("Removed chunk at " + ((int)base.getPosX() >> 4) + ",  " + ((int)base.getPosZ() >> 4) + " from chunk loading ticket for base " + this.name);
      }
   }

   public void addObject(ITeamObject object) {
   }

   public void addObjectFirstTime(ITeamObject object) {
      if (object.forceChunkLoading()) {
         ForgeChunkManager.forceChunk(this.chunkLoadingTicket, new ChunkCoordIntPair((int)object.getPosX() >> 4, (int)object.getPosZ() >> 4));
      }

   }

   public TeamsMap(World world, NBTTagCompound tags) {
      this.shortName = tags.func_74779_i("ShortName");
      this.name = tags.func_74779_i("Name");
      this.minPlayers = tags.func_74762_e("MinPlayers");
      this.maxPlayers = tags.func_74762_e("MaxPlayers");
   }

   public void writeToNBT(NBTTagCompound tags) {
      tags.func_74778_a("ShortName", this.shortName);
      tags.func_74778_a("Name", this.name);
      tags.func_74768_a("MinPlayers", this.minPlayers);
      tags.func_74768_a("MaxPlayers", this.maxPlayers);
   }

   public void forceChunkLoading(Ticket ticket) {
      UnmodifiableIterator var2 = ticket.getChunkList().iterator();

      while(var2.hasNext()) {
         ChunkCoordIntPair coord = (ChunkCoordIntPair)var2.next();
         FlansMod.log("Loading chunk at " + coord.field_77276_a + ", " + coord.field_77275_b + " for map : " + this.name);
         ForgeChunkManager.forceChunk(ticket, coord);
      }

   }

   public void deleteMap() {
      ForgeChunkManager.releaseTicket(this.chunkLoadingTicket);
   }
}
