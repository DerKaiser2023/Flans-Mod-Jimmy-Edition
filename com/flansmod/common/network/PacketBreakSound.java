package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.block.Block;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;

public class PacketBreakSound extends PacketBase {
   public int x;
   public int y;
   public int z;
   public int blockID;

   public PacketBreakSound() {
   }

   public PacketBreakSound(int x, int y, int z, Block block) {
      this.x = x;
      this.y = y;
      this.z = z;
      this.blockID = Block.func_149682_b(block);
   }

   public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      data.writeInt(this.x);
      data.writeInt(this.y);
      data.writeInt(this.z);
      data.writeInt(this.blockID);
   }

   public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
      this.x = data.readInt();
      this.y = data.readInt();
      this.z = data.readInt();
      this.blockID = data.readInt();
   }

   public void handleServerSide(EntityPlayerMP playerEntity) {
      FlansMod.log("Received block break sound packet on server. Skipping.");
   }

   @SideOnly(Side.CLIENT)
   public void handleClientSide(EntityPlayer clientPlayer) {
      Block block = Block.func_149729_e(this.blockID);
      FMLClientHandler.instance().getClient().field_71452_i.func_78867_a(this.x, this.y, this.z, 1);
      FMLClientHandler.instance().getClient().func_147118_V().func_147682_a(new PositionedSoundRecord(new ResourceLocation(block.field_149762_H.func_150495_a()), (float)this.x + 0.5F, (float)this.y + 0.5F, (float)this.z + 0.5F, (block.field_149762_H.func_150497_c() + 1.0F) / 2.0F, block.field_149762_H.func_150494_d() * 0.8F));
   }
}
