package com.flansmod.common.guns;

import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketKillMessage;
import com.flansmod.common.teams.Team;
import com.flansmod.common.types.InfoType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.IChatComponent;

public class EntityDamageSourceGun extends EntityDamageSourceIndirect {
   public InfoType weapon;
   public EntityPlayer shooter;
   public boolean headshot;

   public EntityDamageSourceGun(String s, Entity entity, EntityPlayer player, InfoType wep, boolean head) {
      super(s, entity, player);
      this.weapon = wep;
      this.shooter = player;
      this.headshot = head;
   }

   public Entity getDamageSourceEntity() {
      return this.field_76386_o;
   }

   public IChatComponent func_151519_b(EntityLivingBase living) {
      if (living instanceof EntityPlayer && this.shooter != null && PlayerHandler.getPlayerData(this.shooter) != null) {
         EntityPlayer player = (EntityPlayer)living;
         Team killedTeam = PlayerHandler.getPlayerData(player).team;
         Team killerTeam = PlayerHandler.getPlayerData(this.shooter).team;
         FlansMod.getPacketHandler().sendToDimension((PacketBase)(new PacketKillMessage(this.headshot, this.weapon, (killedTeam == null ? "f" : killedTeam.textColour) + player.func_70005_c_(), (killerTeam == null ? "f" : killerTeam.textColour) + this.shooter.func_70005_c_())), living.field_71093_bK);
         return new ChatComponentText("#flansmod");
      } else {
         return super.func_151519_b(living);
      }
   }
}
