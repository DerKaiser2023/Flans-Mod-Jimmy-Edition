package com.flansmod.common.network;

import com.flansmod.client.gui.GuiBaseEditor;
import com.flansmod.common.FlansMod;
import com.flansmod.common.teams.ITeamBase;
import com.flansmod.common.teams.TeamsManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class PacketBaseEdit extends PacketBase {
   public int baseID;
   public String baseName;
   public String[] maps;
   public int mapID;
   public int teamID;
   public boolean destroy;

   public PacketBaseEdit() {
   }

   public PacketBaseEdit(int baseID, String baseName, String[] maps, int mapID, int teamID) {
      this(baseID, baseName, maps, mapID, teamID, false);
   }

   public PacketBaseEdit(int baseID, String baseName, String[] maps, int mapID, int teamID, boolean destroy) {
      this.baseID = baseID;
      this.baseName = baseName;
      this.maps = maps;
      this.mapID = mapID;
      this.teamID = teamID;
      this.destroy = destroy;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeInt(this.baseID);
      this.writeUTF(data, this.baseName);
      data.writeInt(this.maps.length);
      String[] var3 = this.maps;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         String map = var3[var5];
         this.writeUTF(data, map);
      }

      data.writeInt(this.mapID);
      data.writeByte((byte)this.teamID);
      data.writeBoolean(this.destroy);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.baseID = data.readInt();
      this.baseName = this.readUTF(data);
      int mapsLength = data.readInt();
      this.maps = new String[mapsLength];

      for(int i = 0; i < mapsLength; ++i) {
         this.maps[i] = this.readUTF(data);
      }

      this.mapID = data.readInt();
      this.teamID = data.readByte();
      this.destroy = data.readBoolean();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      if (MinecraftServer.func_71276_C().func_71203_ab().func_152596_g(playerEntity.func_146103_bH())) {
         ITeamBase base = TeamsManager.getInstance().getBase(this.baseID);
         if (this.destroy) {
            base.destroy();
         } else {
            base.setDefaultOwnerID(this.teamID);
            base.setOwnerID(this.teamID);
            if (this.mapID != -1) {
               base.setMapFirstTime(TeamsManager.getInstance().getMapFromFullName(this.maps[this.mapID]));
            }

            base.setName(this.baseName);
            FlansMod.log(playerEntity.func_70005_c_() + " modified attributes of base " + this.baseID);
         }
      }
   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      Minecraft.func_71410_x().func_147108_a(new GuiBaseEditor(this));
   }
}
