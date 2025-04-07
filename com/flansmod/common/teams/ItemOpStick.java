package com.flansmod.common.teams;

import com.flansmod.common.FlansMod;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketBaseEdit;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemOpStick extends Item {
   public static final String[] teamNames = new String[]{"No Team", "Spectators", "Team 1", "Team 2"};
   public static final String[] stickNames = new String[]{"opStick_ownership", "opStick_connecting", "opStick_mapping", "opStick_destruction"};
   @SideOnly(Side.CLIENT)
   private IIcon[] icons;

   public ItemOpStick() {
      this.func_77655_b("opStick");
      this.func_77627_a(true);
   }

   public boolean func_77629_n_() {
      return true;
   }

   public boolean func_77662_d() {
      return true;
   }

   public void clickedEntity(World world, EntityPlayer player, Entity clicked) {
      if (player instanceof EntityPlayerMP) {
         if (clicked instanceof ITeamBase) {
            this.clickedBase(world, (EntityPlayerMP)player, (ITeamBase)clicked);
         }

         if (clicked instanceof ITeamObject) {
            this.clickedObject(world, (EntityPlayerMP)player, (ITeamObject)clicked);
         }

      }
   }

   public static void openBaseEditGUI(ITeamBase base, EntityPlayerMP player) {
      String[] maps = new String[TeamsManager.getInstance().maps.values().size()];
      if (maps.length == 0) {
         TeamsManager.messagePlayer(player, "Maps are not yet set up. Use /teams help");
      } else {
         int currentMapID = -1;
         int i = 0;

         for(Iterator var5 = TeamsManager.getInstance().maps.values().iterator(); var5.hasNext(); ++i) {
            TeamsMap map = (TeamsMap)var5.next();
            maps[i] = map.name;
            if (map == base.getMap()) {
               currentMapID = i;
            }
         }

         FlansMod.getPacketHandler().sendTo((PacketBase)(new PacketBaseEdit(base.getBaseID(), base.getName(), maps, currentMapID, base.getDefaultOwnerID())), player);
      }
   }

   public void clickedBase(World world, EntityPlayerMP player, ITeamBase base) {
      int damage = player.field_71071_by.func_70448_g().func_77960_j();
      TeamsManager teamsManager = TeamsManager.getInstance();
      switch(damage) {
      case 0:
         int currentOwnerID = base.getDefaultOwnerID();
         ++currentOwnerID;
         currentOwnerID %= 4;
         base.setDefaultOwnerID(currentOwnerID);
         base.setOwnerID(currentOwnerID);
         Iterator var10 = base.getObjects().iterator();

         while(var10.hasNext()) {
            ITeamObject object = (ITeamObject)var10.next();
            object.onBaseSet(currentOwnerID);
         }

         TeamsManager.messagePlayer(player, "Base owner changed to " + teamNames[currentOwnerID]);
         break;
      case 1:
         EntityConnectingLine line;
         if (player.field_71104_cf == null) {
            line = new EntityConnectingLine(world, player, base);
            world.func_72838_d(line);
         } else if (player.field_71104_cf instanceof EntityConnectingLine) {
            line = (EntityConnectingLine)player.field_71104_cf;
            if (line.connectedTo instanceof ITeamObject) {
               ITeamObject object = (ITeamObject)line.connectedTo;
               object.setBase(base);
               base.addObject(object);
               line.func_70106_y();
               player.field_71104_cf = null;
               TeamsManager.messagePlayer(player, "Successfully connected.");
            } else {
               TeamsManager.messagePlayer(player, "Cannot connect bases to bases.");
            }
         }
         break;
      case 2:
         openBaseEditGUI(base, player);
         break;
      case 3:
         base.destroy();
      }

   }

   public void clickedObject(World world, EntityPlayerMP player, ITeamObject object) {
      int damage = player.field_71071_by.func_70448_g().func_77960_j();
      TeamsManager teamsManager = TeamsManager.getInstance();
      switch(damage) {
      case 0:
      case 2:
      default:
         break;
      case 1:
         EntityConnectingLine line;
         if (player.field_71104_cf == null) {
            line = new EntityConnectingLine(world, player, object);
            world.func_72838_d(line);
         } else if (player.field_71104_cf instanceof EntityConnectingLine) {
            line = (EntityConnectingLine)player.field_71104_cf;
            if (line.connectedTo instanceof ITeamBase) {
               ITeamBase base = (ITeamBase)line.connectedTo;
               object.setBase(base);
               base.addObject(object);
               TeamsManager.messagePlayer(player, "Successfully connected.");
            } else {
               TeamsManager.messagePlayer(player, "Cannot connect objects to objects.");
            }
         }
         break;
      case 3:
         object.destroy();
      }

   }

   @SideOnly(Side.CLIENT)
   public void func_94581_a(IIconRegister register) {
      this.icons = new IIcon[stickNames.length];

      for(int i = 0; i < stickNames.length; ++i) {
         this.icons[i] = register.func_94245_a("FlansMod:" + stickNames[i]);
         this.field_77791_bV = this.icons[i];
      }

   }

   public IIcon func_77617_a(int damage) {
      int j = MathHelper.func_76125_a(damage, 0, 15);
      return this.icons[j];
   }

   public String func_77667_c(ItemStack stack) {
      return super.func_77658_a() + "." + stack.func_77960_j();
   }
}
