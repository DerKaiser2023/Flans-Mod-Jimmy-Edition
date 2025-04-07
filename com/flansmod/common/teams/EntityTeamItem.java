package com.flansmod.common.teams;

import com.flansmod.common.PlayerHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public class EntityTeamItem extends EntityItem implements IEntityAdditionalSpawnData {
   public TileEntitySpawner spawner;
   public double angle;
   public int xCoord;
   public int yCoord;
   public int zCoord;

   public EntityTeamItem(TileEntitySpawner te, int i) {
      super(te.func_145831_w(), (double)((float)te.field_145851_c + 0.5F), (double)((float)te.field_145848_d + 0.5F), (double)((float)te.field_145849_e + 0.5F), ((ItemStack)te.stacksToSpawn.get(i)).func_77946_l());
      te.itemEntities.add(this);
      this.angle = (double)i * 3.141592653589793D * 2.0D / (double)te.stacksToSpawn.size();
      this.field_70159_w = this.field_70181_x = this.field_70179_y = 0.0D;
      this.lifespan = 1000000000;
      this.spawner = te;
   }

   public EntityTeamItem(World world) {
      super(world);
   }

   public void func_70056_a(double x, double y, double z, float yaw, float pitch, int i) {
   }

   public void func_70071_h_() {
      ++this.field_70173_aa;
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      this.field_70126_B = this.field_70177_z;
      ++this.field_70292_b;
      if (this.field_70170_p.field_72995_K) {
         this.angle += 0.05D;
         this.func_70107_b((double)((float)this.xCoord + 0.5F) + Math.cos(this.angle) * 0.30000001192092896D, (double)((float)this.yCoord + 0.5F), (double)((float)this.zCoord + 0.5F) + Math.sin(this.angle) * 0.30000001192092896D);
      }

      if (this.field_70170_p.field_72995_K) {
         this.func_70066_B();
      }

   }

   public boolean attackEntityFrom(DamageSource par1DamageSource, int par2) {
      return false;
   }

   public void func_70100_b_(EntityPlayer player) {
      if (!this.field_70170_p.field_72995_K) {
         EntityItemPickupEvent event = new EntityItemPickupEvent(player, this);
         if (MinecraftForge.EVENT_BUS.post(event)) {
            return;
         }

         int spawnerTeamID = this.spawner.getTeamID();
         Team spawnerTeam = TeamsManager.getInstance().getTeam(spawnerTeamID);
         Team playerTeam = PlayerHandler.getPlayerData(player).team;
         if (spawnerTeam != null && playerTeam != spawnerTeam) {
            return;
         }

         int var2 = this.func_92059_d().field_77994_a;
         if (event.getResult() == Result.ALLOW || var2 <= 0 || player.field_71071_by.func_70441_a(this.func_92059_d())) {
            FMLCommonHandler.instance().firePlayerItemPickupEvent(player, this);
            this.func_85030_a("random.pop", 0.2F, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            player.func_71001_a(this, var2);
            if (this.func_92059_d().field_77994_a <= 0) {
               this.spawner.itemEntities.remove(this);
               this.func_70106_y();
            }
         }
      }

   }

   public void writeSpawnData(ByteBuf data) {
      if (this.spawner == null) {
         data.writeInt(0);
         data.writeInt(0);
         data.writeInt(0);
      } else {
         data.writeInt(this.spawner.field_145851_c);
         data.writeInt(this.spawner.field_145848_d);
         data.writeInt(this.spawner.field_145849_e);
      }

      data.writeDouble(this.angle);
      NBTTagCompound tags = new NBTTagCompound();
      this.func_92059_d().func_77955_b(tags);
      ByteBufUtils.writeTag(data, tags);
   }

   public void readSpawnData(ByteBuf data) {
      this.xCoord = data.readInt();
      this.yCoord = data.readInt();
      this.zCoord = data.readInt();
      this.angle = data.readDouble();
      this.func_92058_a(ItemStack.func_77949_a(ByteBufUtils.readTag(data)));
   }

   public void func_70037_a(NBTTagCompound tags) {
      this.func_70106_y();
   }

   public boolean func_70075_an() {
      return false;
   }

   public boolean func_70027_ad() {
      return false;
   }
}
