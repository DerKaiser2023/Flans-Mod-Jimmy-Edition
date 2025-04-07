package com.flansmod.common.network;

import com.flansmod.client.gui.GuiVoting;
import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.teams.TeamsManager;
import com.flansmod.common.teams.TeamsRound;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketVoting extends PacketBase {
   @SideOnly(Side.CLIENT)
   public PacketVoting.ClientTeamsRound[] clientOptions;
   public TeamsRound[] options;
   public int[] numVotes;
   public int timeLeft;

   public PacketVoting() {
   }

   public PacketVoting(TeamsManager tm) {
      this.options = tm.voteOptions;
      this.numVotes = new int[this.options.length];
      Iterator var2 = PlayerHandler.serverSideData.values().iterator();

      while(var2.hasNext()) {
         PlayerData data = (PlayerData)var2.next();
         if (data.vote > 0) {
            int var10002 = this.numVotes[data.vote - 1]++;
         }
      }

      this.timeLeft = tm.interRoundTimeLeft;
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeByte(this.options.length);

      for(int i = 0; i < this.options.length; ++i) {
         this.writeUTF(data, this.options[i].gametype.shortName);
         this.writeUTF(data, this.options[i].map.name);
         this.writeUTF(data, this.options[i].teams[0].textColour + this.options[i].teams[0].name);
         this.writeUTF(data, this.options[i].teams[1].textColour + this.options[i].teams[1].name);
         data.writeByte(this.numVotes[i]);
      }

      data.writeInt(this.timeLeft);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      int numOptions = data.readByte();
      this.clientOptions = new PacketVoting.ClientTeamsRound[numOptions];
      this.numVotes = new int[numOptions];

      for(int i = 0; i < numOptions; ++i) {
         this.clientOptions[i] = new PacketVoting.ClientTeamsRound(this.readUTF(data), this.readUTF(data), this.readUTF(data), this.readUTF(data));
         this.numVotes[i] = data.readByte();
      }

      this.timeLeft = data.readInt();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      FlansMod.log("Received vote info packet on server. Rejecting.");
   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      if (!(Minecraft.func_71410_x().field_71462_r instanceof GuiVoting)) {
         Minecraft.func_71410_x().func_147108_a(new GuiVoting(this));
      } else {
         GuiVoting.packet = this;
      }

   }

   public class ClientTeamsRound {
      public String mapName;
      public String gametype;
      public String[] teamNames;

      public ClientTeamsRound(String s, String s1, String s2, String s3) {
         this.gametype = s;
         this.mapName = s1;
         this.teamNames = new String[2];
         this.teamNames[0] = s2;
         this.teamNames[1] = s3;
      }
   }
}
