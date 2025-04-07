package com.flansmod.common.network;

import com.flansmod.client.gui.GuiTeamSelect;
import com.flansmod.common.FlansMod;
import com.flansmod.common.teams.PlayerClass;
import com.flansmod.common.teams.Team;
import com.flansmod.common.teams.TeamsManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketTeamSelect extends PacketBase {
   public boolean selectionPacket;
   public String selection;
   public boolean classChoicesPacket;
   public Team[] teams;
   public PlayerClass[] playerClasses;
   public boolean info;

   public PacketTeamSelect() {
      this.selectionPacket = false;
      this.classChoicesPacket = false;
      this.info = false;
   }

   public PacketTeamSelect(Team[] t, boolean i) {
      this.selectionPacket = false;
      this.classChoicesPacket = false;
      this.info = false;
      this.selectionPacket = false;
      this.classChoicesPacket = false;
      this.teams = t;
      this.info = i;
   }

   public PacketTeamSelect(Team[] t) {
      this(t, false);
   }

   public PacketTeamSelect(PlayerClass[] c) {
      this.selectionPacket = false;
      this.classChoicesPacket = false;
      this.info = false;
      this.selectionPacket = false;
      this.classChoicesPacket = true;
      this.playerClasses = c;
   }

   public PacketTeamSelect(String shortName, boolean classPacket) {
      this.selectionPacket = false;
      this.classChoicesPacket = false;
      this.info = false;
      this.selectionPacket = true;
      this.classChoicesPacket = classPacket;
      this.selection = shortName;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeBoolean(this.selectionPacket);
      data.writeBoolean(this.classChoicesPacket);
      data.writeBoolean(this.info);
      if (this.selectionPacket) {
         this.writeUTF(data, this.selection);
      } else {
         int var4;
         int var5;
         if (this.classChoicesPacket) {
            data.writeByte(this.playerClasses.length);
            PlayerClass[] var3 = this.playerClasses;
            var4 = var3.length;

            for(var5 = 0; var5 < var4; ++var5) {
               PlayerClass playerClass = var3[var5];
               this.writeUTF(data, playerClass.shortName);
            }
         } else {
            data.writeByte(this.teams.length);
            Team[] var7 = this.teams;
            var4 = var7.length;

            for(var5 = 0; var5 < var4; ++var5) {
               Team team = var7[var5];
               this.writeUTF(data, team == null ? "null" : team.shortName);
            }
         }
      }

   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.selectionPacket = data.readBoolean();
      this.classChoicesPacket = data.readBoolean();
      this.info = data.readBoolean();
      if (this.selectionPacket) {
         this.selection = this.readUTF(data);
      } else {
         byte numClasses;
         int i;
         if (this.classChoicesPacket) {
            numClasses = data.readByte();
            this.playerClasses = new PlayerClass[numClasses];

            for(i = 0; i < numClasses; ++i) {
               this.playerClasses[i] = PlayerClass.getClass(this.readUTF(data));
            }
         } else {
            numClasses = data.readByte();
            this.teams = new Team[numClasses];

            for(i = 0; i < numClasses; ++i) {
               this.teams[i] = Team.getTeam(this.readUTF(data));
            }
         }
      }

   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      if (!this.selectionPacket) {
         FlansMod.log("Class / Team listing packet received on server. Rejecting.");
      } else {
         if (this.classChoicesPacket) {
            TeamsManager.getInstance().playerSelectedClass(playerEntity, this.selection);
         } else {
            TeamsManager.getInstance().playerSelectedTeam(playerEntity, this.selection);
         }

      }
   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      if (this.selectionPacket) {
         FlansMod.log("Class / Team selection packet received on client. Rejecting.");
      } else {
         if (this.classChoicesPacket) {
            Minecraft.func_71410_x().func_147108_a(new GuiTeamSelect(this.playerClasses));
         } else if (this.info) {
            GuiTeamSelect.teamChoices = this.teams;
         } else {
            Minecraft.func_71410_x().func_147108_a(new GuiTeamSelect(this.teams));
         }

      }
   }
}
