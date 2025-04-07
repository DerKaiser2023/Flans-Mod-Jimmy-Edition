package com.flansmod.common.teams;

import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.driveables.ItemPlane;
import com.flansmod.common.driveables.ItemVehicle;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.ItemAAGun;
import com.flansmod.common.guns.ItemBullet;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.guns.ItemShootable;
import com.flansmod.common.guns.ShootableType;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketRoundFinished;
import com.flansmod.common.network.PacketTeamInfo;
import com.flansmod.common.network.PacketTeamSelect;
import com.flansmod.common.network.PacketVoting;
import com.flansmod.common.types.InfoType;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldSettings.GameType;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.event.world.ChunkDataEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.event.world.WorldEvent.Load;
import net.minecraftforge.event.world.WorldEvent.Save;

public class TeamsManager {
   public static boolean enabled = true;
   public static TeamsManager instance;
   public static boolean voting = false;
   public static boolean explosions = true;
   public static boolean driveablesBreakBlocks = true;
   public static boolean bombsEnabled = true;
   public static boolean shellsEnabled = true;
   public static boolean missilesEnabled = true;
   public static boolean bulletsEnabled = true;
   public static boolean forceAdventureMode = true;
   public static boolean canBreakGuns = true;
   public static boolean canBreakGlass = true;
   public static boolean armourDrops = true;
   public static boolean vehiclesNeedFuel = true;
   public static boolean overrideHunger = true;
   public static int weaponDrops = 1;
   public static int mgLife = 0;
   public static int planeLife = 0;
   public static int vehicleLife = 0;
   public static int mechaLove = 0;
   public static int aaLife = 0;
   public static float seaLevel = 100.0F;
   public static int scoreDisplayTime = 200;
   public static int votingTime = 200;
   public TeamsRound currentRound;
   public ArrayList<TeamsRound> rounds;
   public HashMap<String, TeamsMap> maps;
   private int nextBaseID = 1;
   public ArrayList<ITeamBase> bases;
   public ArrayList<ITeamObject> objects;
   private long time;
   public int roundTimeLeft;
   public int interRoundTimeLeft;
   public TeamsRound[] voteOptions;
   public TeamsRound nextRound;
   public static boolean autoBalance;
   public static int autoBalanceInterval;
   public static int bulletSnapshotMin = 0;
   public static int bulletSnapshotDivisor = 50;

   public TeamsManager() {
      instance = this;
      MinecraftForge.EVENT_BUS.register(this);
      FMLCommonHandler.instance().bus().register(this);
      this.bases = new ArrayList();
      this.objects = new ArrayList();
      this.maps = new HashMap();
      this.rounds = new ArrayList();
      new GametypeTDM();
      new GametypeZombies();
      new GametypeDM();
      new GametypeCTF();
   }

   public void reset() {
      this.currentRound = null;
      this.bases = new ArrayList();
      this.objects = new ArrayList();
      this.maps = new HashMap();
      this.rounds = new ArrayList();
   }

   public static TeamsManager getInstance() {
      return instance;
   }

   public void tick() {
      if (this.time % 40L == 0L) {
         FlansMod var10000 = FlansMod.INSTANCE;
         FlansMod.getPacketHandler().sendToAll((PacketBase)(new PacketTeamInfo()));
         this.showTeamsMenuToAll(true);
      }

      if (enabled) {
         if (this.currentRound != null) {
            this.currentRound.gametype.tick();
         }

         ++this.time;
         Iterator var1 = this.bases.iterator();

         while(var1.hasNext()) {
            ITeamBase base = (ITeamBase)var1.next();
            base.tick();
         }

         var1 = this.objects.iterator();

         while(var1.hasNext()) {
            ITeamObject object = (ITeamObject)var1.next();
            object.tick();
         }

         int var3;
         if (overrideHunger && this.currentRound != null) {
            WorldServer[] var7 = MinecraftServer.func_71276_C().field_71305_c;
            int var10 = var7.length;

            for(var3 = 0; var3 < var10; ++var3) {
               World world = var7[var3];
               Iterator var5 = world.field_73010_i.iterator();

               while(var5.hasNext()) {
                  Object player = var5.next();
                  ((EntityPlayer)player).func_71024_bL().func_75122_a(20, 10.0F);
               }
            }
         }

         if (this.interRoundTimeLeft > 0) {
            --this.interRoundTimeLeft;
            if (voting) {
               if (this.nextRound != null) {
                  this.startNextRound();
                  this.interRoundTimeLeft = 0;
                  return;
               }

               if (this.interRoundTimeLeft == votingTime) {
                  this.pickVoteOptions();
               }

               if (this.interRoundTimeLeft <= votingTime) {
                  if (this.voteOptions == null) {
                     this.pickVoteOptions();
                  }

                  this.displayVotingGUI();
               }
            }

            if (this.interRoundTimeLeft == 0) {
               this.startNextRound();
            }
         }

         if (this.currentRound != null && this.roundTimeLeft > 0) {
            if (this.autoBalance() && this.time % (long)autoBalanceInterval == (long)(autoBalanceInterval - 200) && this.needAutobalance()) {
               messageAll("§fAutobalancing teams...");
            }

            if (this.autoBalance() && this.time % (long)autoBalanceInterval == 0L && this.needAutobalance()) {
               this.autobalance();
            }

            --this.roundTimeLeft;
            boolean roundEnded = this.roundTimeLeft == 0;
            if (roundEnded) {
               messageAll(this.randomTimeOutString());
            }

            Team[] var11 = this.currentRound.teams;
            var3 = var11.length;

            for(int var12 = 0; var12 < var3; ++var12) {
               Team team = var11[var12];
               if (this.currentRound.gametype.teamHasWon(team)) {
                  roundEnded = true;
                  messageAll(team.name + " won the round!");
               }
            }

            if (roundEnded) {
               this.roundTimeLeft = 0;
               this.interRoundTimeLeft = voting ? votingTime + scoreDisplayTime : scoreDisplayTime;
               this.displayScoreboardGUI();
               this.currentRound.gametype.roundEnd();
               PlayerHandler.roundEnded();
            }
         }

      }
   }

   public boolean needAutobalance() {
      if (this.autoBalance() && this.currentRound != null && this.currentRound.teams.length == 2) {
         int membersTeamA = this.currentRound.teams[0].members.size();
         int membersTeamB = this.currentRound.teams[1].members.size();
         return Math.abs(membersTeamA - membersTeamB) > 1;
      } else {
         return false;
      }
   }

   public void autobalance() {
      if (this.autoBalance() && this.currentRound != null && this.currentRound.teams.length == 2) {
         int membersTeamA = this.currentRound.teams[0].members.size();
         int membersTeamB = this.currentRound.teams[1].members.size();
         int i;
         EntityPlayerMP playerToKick;
         if (membersTeamA - membersTeamB > 1) {
            for(i = 0; i < (membersTeamA - membersTeamB) / 2; ++i) {
               playerToKick = this.getPlayer(this.currentRound.teams[1].addPlayer(this.currentRound.teams[0].removeWorstPlayer()));
               messagePlayer(playerToKick, "You were moved to the other team by the autobalancer.");
               this.sendClassMenuToPlayer(playerToKick);
            }
         }

         if (membersTeamB - membersTeamA > 1) {
            for(i = 0; i < (membersTeamB - membersTeamA) / 2; ++i) {
               playerToKick = this.getPlayer(this.currentRound.teams[0].addPlayer(this.currentRound.teams[1].removeWorstPlayer()));
               messagePlayer(playerToKick, "You were moved to the other team by the autobalancer.");
               this.sendClassMenuToPlayer(playerToKick);
            }
         }

      }
   }

   public String randomTimeOutString() {
      switch(Gametype.rand.nextInt(4)) {
      case 0:
         return "That's time!";
      case 1:
         return "How dull; a tie...";
      case 2:
         return "Everybody's a loser but the clock.";
      default:
         return "Time up.";
      }
   }

   public void displayScoreboardGUI() {
      Iterator var1 = getPlayers().iterator();

      while(var1.hasNext()) {
         EntityPlayer player = (EntityPlayer)var1.next();
         PlayerData data = PlayerHandler.getPlayerData(player);
         if (!data.builder) {
            sendPacketToPlayer(new PacketRoundFinished(scoreDisplayTime), (EntityPlayerMP)player);
         }
      }

   }

   public void displayVotingGUI() {
      Iterator var1 = getPlayers().iterator();

      while(var1.hasNext()) {
         EntityPlayer player = (EntityPlayer)var1.next();
         PlayerData data = PlayerHandler.getPlayerData(player);
         if (!data.builder) {
            sendPacketToPlayer(new PacketVoting(this), (EntityPlayerMP)player);
         }
      }

   }

   public void pickVoteOptions() {
      Collections.sort(this.rounds);
      this.voteOptions = new TeamsRound[Math.min(5, this.rounds.size())];

      for(int i = 0; i < this.voteOptions.length; ++i) {
         this.voteOptions[i] = (TeamsRound)this.rounds.get(i);
      }

      this.voteOptions[Gametype.rand.nextInt(this.voteOptions.length)] = (TeamsRound)this.rounds.get(Gametype.rand.nextInt(this.rounds.size()));
   }

   public void start() {
      if (enabled && this.rounds.size() != 0) {
         if (this.currentRound != null) {
            this.currentRound.gametype.roundCleanup();
            this.resetScores();
         }

         this.currentRound = (TeamsRound)this.rounds.get(0);
         this.startRound();
      }
   }

   public void startNextRound() {
      if (enabled && this.rounds.size() != 0) {
         if (this.nextRound == null) {
            int winner;
            int mostVotes;
            if (voting) {
               winner = 0;
               mostVotes = 0;
               int[] numVotes = new int[this.voteOptions.length];
               Iterator var4 = PlayerHandler.serverSideData.values().iterator();

               PlayerData data;
               while(var4.hasNext()) {
                  data = (PlayerData)var4.next();
                  if (data.vote > 0) {
                     ++numVotes[data.vote - 1];
                  }
               }

               int i;
               for(i = 0; i < this.voteOptions.length; ++i) {
                  if (numVotes[i] > mostVotes) {
                     mostVotes = numVotes[i];
                     winner = i;
                  }
               }

               this.nextRound = this.voteOptions[winner];

               TeamsRound round;
               for(var4 = this.rounds.iterator(); var4.hasNext(); ++round.roundsSincePlayed) {
                  round = (TeamsRound)var4.next();
               }

               for(i = 0; i < this.voteOptions.length; ++i) {
                  if (i == winner) {
                     this.voteOptions[i].popularity = 1.0F - (1.0F - this.voteOptions[i].popularity) * 0.8F;
                     this.voteOptions[i].roundsSincePlayed = 0;
                  } else {
                     TeamsRound var10000 = this.voteOptions[i];
                     var10000.popularity *= 0.9F;
                     var10000 = this.voteOptions[i];
                     var10000.popularity += 0.01F;
                  }
               }

               for(var4 = PlayerHandler.serverSideData.values().iterator(); var4.hasNext(); data.vote = 0) {
                  data = (PlayerData)var4.next();
               }
            } else {
               winner = this.rounds.indexOf(this.currentRound);
               ++winner;
               mostVotes = winner % this.rounds.size();
               this.nextRound = (TeamsRound)this.rounds.get(mostVotes);
            }
         }

         if (this.currentRound != null) {
            Iterator var6 = this.currentRound.map.bases.iterator();

            while(var6.hasNext()) {
               ITeamBase base = (ITeamBase)var6.next();
               base.roundCleanup();
            }

            this.currentRound.gametype.roundCleanup();
         }

         this.resetScores();
         if (this.nextRound != null) {
            this.currentRound = this.nextRound;
         }

         this.startRound();
         this.nextRound = null;
      }
   }

   private void startRound() {
      this.currentRound.gametype.roundStart();
      this.roundTimeLeft = this.currentRound.timeLimit * 60 * 20;
      Iterator var1 = this.bases.iterator();

      while(var1.hasNext()) {
         ITeamBase base = (ITeamBase)var1.next();
         base.startRound();
      }

      var1 = getPlayers().iterator();

      while(var1.hasNext()) {
         EntityPlayer player = (EntityPlayer)var1.next();
         this.forceRespawn((EntityPlayerMP)player);
      }

      this.showTeamsMenuToAll();
      messageAll("§fA new round has started!");
   }

   public void showTeamsMenuToAll() {
      this.showTeamsMenuToAll(false);
   }

   public void showTeamsMenuToAll(boolean info) {
      Iterator var2 = getPlayers().iterator();

      while(true) {
         EntityPlayer player;
         PlayerData data;
         do {
            do {
               if (!var2.hasNext()) {
                  return;
               }

               player = (EntityPlayer)var2.next();
               data = PlayerHandler.getPlayerData(player);
            } while(data == null);
         } while(data.builder && this.playerIsOp(player));

         this.sendTeamsMenuToPlayer((EntityPlayerMP)player, info);
      }
   }

   @SubscribeEvent
   public void onPlayerInteract(EntityInteractEvent event) {
      if (event.entityPlayer.field_71071_by.func_70448_g() != null && event.entityPlayer.field_71071_by.func_70448_g().func_77973_b() instanceof ItemOpStick) {
         ((ItemOpStick)event.entityPlayer.field_71071_by.func_70448_g().func_77973_b()).clickedEntity(event.entityPlayer.field_70170_p, event.entityPlayer, event.target);
      }

   }

   @SubscribeEvent
   public void onEntityHurt(LivingAttackEvent event) {
      if (enabled && this.currentRound != null) {
         if (event.entity instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP)event.entity;
            PlayerData data = PlayerHandler.getPlayerData((EntityPlayer)player);
            DamageSource source = event.source;
            if (data.team == Team.spectators && source != DamageSource.field_76377_j) {
               event.setCanceled(true);
               return;
            }

            if (source instanceof EntityDamageSource && source.func_76346_g() instanceof EntityPlayerMP) {
               EntityPlayerMP attacker = (EntityPlayerMP)source.func_76346_g();
               PlayerData attackerData = PlayerHandler.getPlayerData((EntityPlayer)attacker);
               if (attackerData == null) {
                  return;
               }

               if (attacker == player) {
                  return;
               }

               if (attackerData.team == Team.spectators) {
                  event.setCanceled(true);
                  return;
               }

               if (attackerData.team == null && data.team != null || attackerData.team != null && data.team == null) {
                  event.setCanceled(true);
                  return;
               }

               if (attackerData.team != null && data.team != null && this.roundTimeLeft > 0 && !this.currentRound.gametype.playerCanAttack(attacker, attackerData.team, player, data.team)) {
                  event.setCanceled(true);
               }
            }
         }

      }
   }

   @SubscribeEvent
   public void onEntityKilled(LivingDeathEvent event) {
      if (enabled) {
         if (this.currentRound != null) {
            this.currentRound.gametype.entityKilled(event.entity, event.source);
            if (event.entity instanceof EntityPlayerMP) {
               this.currentRound.gametype.playerKilled((EntityPlayerMP)event.entity, event.source);
            }
         }

      }
   }

   @SubscribeEvent
   public void entityJoinedWorld(EntityJoinWorldEvent event) {
      if (event.entity instanceof ITeamBase) {
         this.registerBase((ITeamBase)event.entity);
      }

      if (event.entity instanceof ITeamObject) {
         this.objects.add((ITeamObject)event.entity);
      }

   }

   @SubscribeEvent
   public void playerUseEntity(EntityInteractEvent event) {
      if (enabled) {
         if (!event.entityPlayer.field_70170_p.field_72995_K) {
            ItemStack currentItem = event.entityPlayer.func_71045_bC();
            if (currentItem != null && currentItem.func_77973_b() != null && currentItem.func_77973_b() instanceof ItemOpStick) {
               if (event.target instanceof ITeamObject) {
                  ((ItemOpStick)currentItem.func_77973_b()).clickedObject(event.entityPlayer.field_70170_p, (EntityPlayerMP)event.entityPlayer, (ITeamObject)event.target);
               }

               if (event.target instanceof ITeamBase) {
                  ((ItemOpStick)currentItem.func_77973_b()).clickedBase(event.entityPlayer.field_70170_p, (EntityPlayerMP)event.entityPlayer, (ITeamBase)event.target);
               }
            } else if (this.currentRound != null) {
               if (event.target instanceof ITeamObject) {
                  this.currentRound.gametype.objectClickedByPlayer((ITeamObject)event.target, (EntityPlayerMP)event.entityPlayer);
               }

               if (event.target instanceof ITeamBase) {
                  this.currentRound.gametype.baseClickedByPlayer((ITeamBase)event.target, (EntityPlayerMP)event.entityPlayer);
               }
            }

         }
      }
   }

   @SubscribeEvent
   public void playerInteracted(PlayerInteractEvent event) {
      if (enabled) {
         if (event.action == Action.LEFT_CLICK_BLOCK && !event.entityPlayer.field_71075_bZ.field_75099_e && !event.entityPlayer.field_71075_bZ.field_75098_d) {
            event.setCanceled(true);
         } else if (!event.entityPlayer.field_70170_p.field_72995_K) {
            TileEntity te = event.entityPlayer.field_70170_p.func_147438_o(event.x, event.y, event.z);
            if (te != null) {
               ItemStack currentItem = event.entityPlayer.func_71045_bC();
               if (currentItem != null && currentItem.func_77973_b() != null && currentItem.func_77973_b() instanceof ItemOpStick) {
                  if (te instanceof ITeamObject) {
                     ((ItemOpStick)currentItem.func_77973_b()).clickedObject(event.entityPlayer.field_70170_p, (EntityPlayerMP)event.entityPlayer, (ITeamObject)te);
                  }

                  if (te instanceof ITeamBase) {
                     ((ItemOpStick)currentItem.func_77973_b()).clickedBase(event.entityPlayer.field_70170_p, (EntityPlayerMP)event.entityPlayer, (ITeamBase)te);
                  }
               } else if (this.currentRound != null) {
                  if (te instanceof ITeamObject) {
                     this.currentRound.gametype.objectClickedByPlayer((ITeamObject)te, (EntityPlayerMP)event.entityPlayer);
                  }

                  if (te instanceof ITeamBase) {
                     this.currentRound.gametype.baseClickedByPlayer((ITeamBase)te, (EntityPlayerMP)event.entityPlayer);
                  }
               }
            }

         }
      }
   }

   @SubscribeEvent
   public void playerDrops(PlayerDropsEvent event) {
      ArrayList<EntityItem> dropsToThrow = new ArrayList();
      Iterator var3;
      EntityItem entity;
      ItemStack stack;
      if (weaponDrops == 2) {
         var3 = event.drops.iterator();

         label108:
         while(true) {
            do {
               do {
                  do {
                     if (!var3.hasNext()) {
                        break label108;
                     }

                     entity = (EntityItem)var3.next();
                     stack = entity.func_92059_d();
                  } while(stack == null);
               } while(stack.func_77973_b() == null);
            } while(!(stack.func_77973_b() instanceof ItemGun));

            EntityGunItem gunEntity = new EntityGunItem(entity);
            stack.field_77994_a = 0;
            boolean alreadyAdded = false;
            Iterator var8 = dropsToThrow.iterator();

            while(var8.hasNext()) {
               EntityItem check = (EntityItem)var8.next();
               if (((ItemGun)stack.func_77973_b()).type == ((ItemGun)check.func_92059_d().func_77973_b()).type) {
                  alreadyAdded = true;
               }
            }

            if (!alreadyAdded) {
               event.entityPlayer.field_70170_p.func_72838_d(gunEntity);
               dropsToThrow.add(gunEntity);
            }
         }
      }

      var3 = dropsToThrow.iterator();

      while(var3.hasNext()) {
         entity = (EntityItem)var3.next();
         EntityGunItem gunEntity = (EntityGunItem)entity;
         GunType gunType = ((ItemGun)gunEntity.func_92059_d().func_77973_b()).type;
         Iterator var13 = event.drops.iterator();

         while(var13.hasNext()) {
            EntityItem ammoEntity = (EntityItem)var13.next();
            ItemStack ammoItemstack = ammoEntity.func_92059_d();
            if (ammoItemstack != null && ammoItemstack.func_77973_b() instanceof ItemShootable) {
               ShootableType bulletType = ((ItemShootable)ammoItemstack.func_77973_b()).type;
               if (gunType.isAmmo(bulletType)) {
                  gunEntity.ammoStacks.add(ammoItemstack.func_77946_l());
                  ammoItemstack.field_77994_a = 0;
               }
            }
         }
      }

      var3 = event.drops.iterator();

      while(true) {
         while(true) {
            do {
               do {
                  do {
                     if (!var3.hasNext()) {
                        event.drops.removeAll(dropsToThrow);
                        return;
                     }

                     entity = (EntityItem)var3.next();
                     stack = entity.func_92059_d();
                  } while(stack == null);
               } while(stack.func_77973_b() == null);
            } while(stack.field_77994_a <= 0);

            if (!(stack.func_77973_b() instanceof ItemGun) && !(stack.func_77973_b() instanceof ItemPlane) && !(stack.func_77973_b() instanceof ItemVehicle) && !(stack.func_77973_b() instanceof ItemAAGun) && !(stack.func_77973_b() instanceof ItemBullet)) {
               if (stack.func_77973_b() instanceof ItemTeamArmour && !armourDrops) {
                  dropsToThrow.add(entity);
               }
            } else if (weaponDrops != 1) {
               dropsToThrow.add(entity);
            }
         }
      }
   }

   @SubscribeEvent
   public void playerLoot(EntityItemPickupEvent event) {
      if (event.entity instanceof EntityPlayer) {
         ItemStack itemStack = event.item.func_92059_d();
         PlayerData data = PlayerHandler.getPlayerData(event.entityPlayer);
         if (enabled && this.currentRound != null && data != null && (data.team == Team.spectators || !this.currentRound.gametype.playerCanLoot(itemStack, InfoType.getType(itemStack), event.entityPlayer, data.team))) {
            event.setCanceled(true);
         }
      }

   }

   @SubscribeEvent
   public void onPlayerRespawn(PlayerEvent event) {
      if (event instanceof PlayerRespawnEvent) {
         this.respawnPlayer(event.player, false);
      }

      if (event instanceof PlayerLoggedOutEvent) {
         this.onPlayerLogout(event.player);
      }

      if (event instanceof PlayerLoggedInEvent) {
         this.onPlayerLogin(event.player);
      }

   }

   public void onPlayerLogin(EntityPlayer player) {
      if (enabled && this.currentRound != null) {
         if (player instanceof EntityPlayerMP) {
            EntityPlayerMP playerMP = (EntityPlayerMP)player;
            this.sendTeamsMenuToPlayer(playerMP);
            this.currentRound.gametype.playerJoined(playerMP);
         }

      }
   }

   public void onPlayerLogout(EntityPlayer player) {
      Iterator var2 = Team.teams.iterator();

      while(var2.hasNext()) {
         Team team = (Team)var2.next();
         team.removePlayer(player);
      }

   }

   public void respawnPlayer(EntityPlayer player, boolean firstSpawn) {
      if (!player.field_70170_p.field_72995_K) {
         if (enabled && this.currentRound != null) {
            EntityPlayerMP playerMP = (EntityPlayerMP)player;
            PlayerData data = PlayerHandler.getPlayerData((EntityPlayer)playerMP);
            if (data != null && (!data.builder || !this.playerIsOp(playerMP))) {
               if (firstSpawn) {
                  Vec3 spawnPoint = this.currentRound.gametype.getSpawnPoint(playerMP);
                  if (spawnPoint != null) {
                     player.func_70634_a(spawnPoint.field_72450_a, spawnPoint.field_72448_b, spawnPoint.field_72449_c);
                  }
               }

               this.setPlayersNextSpawnpoint(playerMP);
               if (forceAdventureMode) {
                  player.func_71033_a(GameType.ADVENTURE);
               }

               this.resetInventory(player);
               this.currentRound.gametype.playerRespawned((EntityPlayerMP)player);
            }
         }
      }
   }

   private void setPlayersNextSpawnpoint(EntityPlayerMP player, ChunkCoordinates coords) {
      player.func_71063_a(coords, true);
   }

   private void setPlayersNextSpawnpoint(EntityPlayerMP player) {
      if (enabled && this.currentRound != null) {
         PlayerData data = PlayerHandler.getPlayerData((EntityPlayer)player);
         Vec3 spawnPoint = this.currentRound.gametype.getSpawnPoint(player);
         if (spawnPoint != null) {
            this.setPlayersNextSpawnpoint(player, new ChunkCoordinates(MathHelper.func_76128_c(spawnPoint.field_72450_a), MathHelper.func_76128_c(spawnPoint.field_72448_b) + 1, MathHelper.func_76128_c(spawnPoint.field_72449_c)));
         } else {
            FlansMod.log("Could not find spawn point for " + player.getDisplayName() + " on team " + (data.newTeam == null ? "null" : data.newTeam.name));
         }

      }
   }

   public void forceRespawn(EntityPlayerMP player) {
      if (!this.playerIsOp(player) || !PlayerHandler.getPlayerData((EntityPlayer)player).builder) {
         player.field_71071_by.field_70460_b = new ItemStack[4];
         player.field_71071_by.field_70462_a = new ItemStack[36];
         player.func_70691_i(9001.0F);
         if (forceAdventureMode) {
            player.func_71033_a(GameType.ADVENTURE);
         }

         this.respawnPlayer(player, true);
      }
   }

   public void sendTeamsMenuToPlayer(EntityPlayerMP player) {
      this.sendTeamsMenuToPlayer(player, false);
   }

   public void sendTeamsMenuToPlayer(EntityPlayerMP player, boolean info) {
      if (enabled && this.currentRound != null && this.currentRound.teams != null) {
         Team[] availableTeams = this.currentRound.gametype.getTeamsCanSpawnAs(this.currentRound, player);
         boolean playerIsOp = MinecraftServer.func_71276_C().func_71203_ab().func_152596_g(player.func_146103_bH());
         Team[] allAvailableTeams = new Team[availableTeams.length + (playerIsOp ? 2 : 1)];
         System.arraycopy(availableTeams, 0, allAvailableTeams, 0, availableTeams.length);
         allAvailableTeams[availableTeams.length] = Team.spectators;
         sendPacketToPlayer(new PacketTeamSelect(allAvailableTeams, info), player);
      }
   }

   public void sendClassMenuToPlayer(EntityPlayerMP player) {
      Team team = PlayerHandler.getPlayerData((EntityPlayer)player).newTeam;
      if (team == null) {
         this.sendTeamsMenuToPlayer(player);
      } else if (team != Team.spectators && team.classes.size() > 0) {
         sendPacketToPlayer(new PacketTeamSelect((PlayerClass[])team.classes.toArray(new PlayerClass[team.classes.size()])), player);
      }

   }

   public boolean playerIsOp(EntityPlayer player) {
      return MinecraftServer.func_71276_C().func_71203_ab().func_152596_g(player.func_146103_bH());
   }

   public boolean autoBalance() {
      return (this.currentRound == null || this.currentRound.gametype.shouldAutobalance()) && autoBalance;
   }

   public void playerSelectedTeam(EntityPlayerMP player, String teamName) {
      if (enabled && this.currentRound != null) {
         PlayerData data = PlayerHandler.getPlayerData((EntityPlayer)player);
         data.builder = false;
         if (teamName.equals("null")) {
            if (this.playerIsOp(player)) {
               data.team = null;
               data.builder = true;
               return;
            }

            teamName = "spectators";
         }

         Team selectedTeam = Team.getTeam(teamName);
         if (selectedTeam == null) {
            selectedTeam = Team.spectators;
         }

         boolean isValid = selectedTeam == Team.spectators;
         Team[] validTeams = this.currentRound.gametype.getTeamsCanSpawnAs(this.currentRound, player);
         Team[] var7 = validTeams;
         int var8 = validTeams.length;

         for(int var9 = 0; var9 < var8; ++var9) {
            Team validTeam = var7[var9];
            if (selectedTeam == validTeam) {
               isValid = true;
            }
         }

         if (!isValid) {
            player.func_145747_a(new ChatComponentText("You may not join " + selectedTeam.name + " for it is invalid. Please try again"));
            FlansMod.log(player.func_70005_c_() + " tried to spawn on an invalid team : " + selectedTeam.name);
            selectedTeam = Team.spectators;
         }

         if (selectedTeam == Team.spectators) {
            messageAll(player.func_70005_c_() + " joined §" + selectedTeam.textColour + selectedTeam.name);
            if (data.team != null) {
               data.team.removePlayer((EntityPlayer)player);
            }

            data.newTeam = data.team = Team.spectators;
            player.field_71071_by.field_70460_b = new ItemStack[4];
            player.field_71071_by.field_70462_a = new ItemStack[36];
            data.team.addPlayer((EntityPlayer)player);
            player.func_70691_i(9001.0F);
            this.respawnPlayer(player, true);
         } else {
            Team otherTeam = this.currentRound.getOtherTeam(selectedTeam);
            if (this.autoBalance() && selectedTeam.members.size() > otherTeam.members.size() + 1) {
               player.func_145747_a(new ChatComponentText("You may not join " + selectedTeam.name + " due to imbalance. Please try again"));
               this.sendTeamsMenuToPlayer(player);
               return;
            }

            data.newTeam = selectedTeam;
            this.sendClassMenuToPlayer(player);
         }

         this.currentRound.gametype.playerChoseTeam(player, data.team, selectedTeam);
      }
   }

   public void playerSelectedClass(EntityPlayerMP player, String className) {
      if (enabled && this.currentRound != null) {
         PlayerData data = PlayerHandler.getPlayerData((EntityPlayer)player);
         PlayerClass playerClass = PlayerClass.getClass(className);
         if (!data.newTeam.classes.contains(playerClass)) {
            player.func_145747_a(new ChatComponentText("You may not select " + playerClass.name + ". Please try again"));
            FlansMod.log(player.func_70005_c_() + " tried to pick an invalid class : " + playerClass.name);
         } else {
            if (data.team == data.newTeam && data.playerClass != playerClass) {
               this.currentRound.gametype.playerChoseNewClass(player, playerClass);
               data.newPlayerClass = playerClass;
               player.func_145747_a(new ChatComponentText("You will respawn with the " + playerClass.name + " class"));
            } else if (data.team != null && data.team != data.newTeam) {
               messageAll(player.func_70005_c_() + " switched to §" + data.newTeam.textColour + data.newTeam.name);
               this.currentRound.gametype.playerDefected(player, data.team, data.newTeam);
               this.setPlayersNextSpawnpoint(player);
               player.func_70097_a(DamageSource.field_76377_j, 10000.0F);
               if (data.team != null) {
                  data.team.removePlayer((EntityPlayer)player);
               }

               data.newTeam.addPlayer((EntityPlayer)player);
               data.team = data.newTeam;
               data.newPlayerClass = playerClass;
            } else if (data.team == null) {
               messageAll(player.func_70005_c_() + " joined §" + data.newTeam.textColour + data.newTeam.name);
               this.currentRound.gametype.playerEnteredTheGame(player, data.newTeam, playerClass);
               data.newTeam.addPlayer((EntityPlayer)player);
               data.team = data.newTeam;
               data.newPlayerClass = playerClass;
               this.currentRound.gametype.playerChoseNewClass(player, playerClass);
               this.respawnPlayer(player, true);
            }

         }
      }
   }

   public void resetInventory(EntityPlayer player) {
      Team team = PlayerHandler.getPlayerData(player).team;
      PlayerClass playerClass = PlayerHandler.getPlayerData(player).getPlayerClass();
      if (team != null) {
         player.field_71071_by.field_70460_b = new ItemStack[4];
         player.field_71071_by.field_70462_a = new ItemStack[36];
         if (team.hat != null) {
            player.field_71071_by.field_70460_b[3] = team.hat.func_77946_l();
         }

         if (team.chest != null) {
            player.field_71071_by.field_70460_b[2] = team.chest.func_77946_l();
         }

         if (team.legs != null) {
            player.field_71071_by.field_70460_b[1] = team.legs.func_77946_l();
         }

         if (team.shoes != null) {
            player.field_71071_by.field_70460_b[0] = team.shoes.func_77946_l();
         }

         if (playerClass != null) {
            if (playerClass.hat != null) {
               player.field_71071_by.field_70460_b[3] = playerClass.hat.func_77946_l();
            }

            if (playerClass.chest != null) {
               player.field_71071_by.field_70460_b[2] = playerClass.chest.func_77946_l();
            }

            if (playerClass.legs != null) {
               player.field_71071_by.field_70460_b[1] = playerClass.legs.func_77946_l();
            }

            if (playerClass.shoes != null) {
               player.field_71071_by.field_70460_b[0] = playerClass.shoes.func_77946_l();
            }

            Iterator var4 = playerClass.startingItems.iterator();

            ItemStack stack;
            while(var4.hasNext()) {
               stack = (ItemStack)var4.next();
               player.field_71071_by.func_70441_a(stack.func_77946_l());
            }

            for(int i = 0; i < player.field_71071_by.func_70302_i_(); ++i) {
               stack = player.field_71071_by.func_70301_a(i);
               if (stack != null && stack.func_77973_b() instanceof ItemGun) {
                  ((ItemGun)stack.func_77973_b()).reload(stack, ((ItemGun)stack.func_77973_b()).type, player.field_70170_p, player, true, false);
               }
            }

         }
      }
   }

   @SubscribeEvent
   public void chunkLoaded(ChunkDataEvent event) {
      Chunk chunk = event.getChunk();
      List[] var3 = chunk.field_76645_j;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         List<Entity> list = var3[var5];
         Iterator var7 = list.iterator();

         while(var7.hasNext()) {
            Entity entity = (Entity)var7.next();
            if (entity instanceof ITeamBase) {
               this.bases.add((ITeamBase)entity);
               if (((ITeamBase)entity).getBaseID() > this.nextBaseID) {
                  FlansMod.log("Loaded base with ID higher than the supposed highest ID. Adjusted highest ID");
                  this.nextBaseID = ((ITeamBase)entity).getBaseID();
               }
            }

            if (entity instanceof ITeamObject) {
               this.objects.add((ITeamObject)entity);
            }
         }
      }

   }

   @SubscribeEvent
   public void worldData(WorldEvent event) {
      if (!event.world.field_72995_K) {
         if (event instanceof Load) {
            this.loadPerWorldData(event, event.world);
            this.savePerWorldData(event, event.world);
         }

         if (event instanceof Save) {
            this.savePerWorldData(event, event.world);
         }

      }
   }

   private void loadPerWorldData(Event event, World world) {
      this.reset();
      File file = new File(world.func_72860_G().func_75765_b(), "teams_" + world.field_73011_w.func_80007_l() + ".dat");
      if (this.checkFileExists(file)) {
         try {
            NBTTagCompound tags = CompressedStreamTools.func_74794_a(new DataInputStream(new FileInputStream(file)));
            this.nextBaseID = tags.func_74762_e("NextBaseID");

            int i;
            for(i = 0; i < tags.func_74762_e("NumberOfMaps"); ++i) {
               TeamsMap map = new TeamsMap(world, tags.func_74775_l("Map_" + i));
               this.maps.put(map.shortName, map);
            }

            if (this.maps.size() == 0) {
               this.maps.put("default" + world.func_72912_H().func_76076_i(), new TeamsMap(world, "default" + world.func_72912_H().func_76076_i(), "Default " + world.func_72912_H().func_76065_j()));
            }

            for(i = 0; i < tags.func_74762_e("RoundsSize"); ++i) {
               TeamsRound round = new TeamsRound(tags.func_74775_l("Round_" + i));
               this.rounds.add(round);
            }

            enabled = tags.func_74767_n("Enabled");
            voting = tags.func_74767_n("Voting");
            votingTime = tags.func_74762_e("VotingTime");
            scoreDisplayTime = tags.func_74762_e("ScoreTime");
            bombsEnabled = tags.func_74767_n("Bombs");
            bulletsEnabled = tags.func_74767_n("Bullets");
            explosions = tags.func_74767_n("Explosions");
            forceAdventureMode = tags.func_74767_n("ForceAdventure");
            canBreakGuns = tags.func_74767_n("CanBreakGuns");
            canBreakGlass = tags.func_74767_n("CanBreakGlass");
            armourDrops = tags.func_74767_n("ArmourDrops");
            weaponDrops = tags.func_74762_e("WeaponDrops");
            vehiclesNeedFuel = tags.func_74767_n("NeedFuel");
            mgLife = tags.func_74762_e("MGLife");
            aaLife = tags.func_74762_e("AALife");
            vehicleLife = tags.func_74762_e("VehicleLife");
            seaLevel = tags.func_74760_g("SeaLevel");
            mechaLove = tags.func_74762_e("MechaLove");
            planeLife = tags.func_74762_e("PlaneLife");
            driveablesBreakBlocks = tags.func_74767_n("BreakBlocks");
            if (enabled && this.rounds.size() > 0) {
               this.start();
            }
         } catch (Exception var7) {
            FlansMod.log("Failed to load from teams.dat");
            var7.printStackTrace();
         }

         Iterator var8 = InfoType.infoTypes.iterator();

         while(var8.hasNext()) {
            InfoType type = (InfoType)var8.next();
            type.onWorldLoad(world);
         }

      }
   }

   private void savePerWorldData(Event event, World world) {
      File file = new File(world.func_72860_G().func_75765_b(), "teams_" + world.field_73011_w.func_80007_l() + ".dat");
      this.checkFileExists(file);

      try {
         NBTTagCompound tags = new NBTTagCompound();
         tags.func_74768_a("NextBaseID", this.nextBaseID);
         tags.func_74768_a("NumberOfMaps", this.maps.size());
         int i;
         if (this.maps != null) {
            i = 0;

            for(Iterator var6 = this.maps.values().iterator(); var6.hasNext(); ++i) {
               TeamsMap map = (TeamsMap)var6.next();
               NBTTagCompound mapTags = new NBTTagCompound();
               map.writeToNBT(mapTags);
               tags.func_74782_a("Map_" + i, mapTags);
            }
         }

         if (this.rounds != null) {
            tags.func_74768_a("RoundsSize", this.rounds.size());

            for(i = 0; i < this.rounds.size(); ++i) {
               TeamsRound entry = (TeamsRound)this.rounds.get(i);
               if (entry != null) {
                  NBTTagCompound roundTags = new NBTTagCompound();
                  entry.writeToNBT(roundTags);
                  tags.func_74782_a("Round_" + i, roundTags);
               }
            }
         } else {
            tags.func_74768_a("RoundsSize", 0);
         }

         if (this.currentRound != null) {
            tags.func_74768_a("CurrentRound", this.rounds.indexOf(this.currentRound));
         }

         Iterator var11 = Gametype.gametypes.values().iterator();

         while(var11.hasNext()) {
            Gametype gametype = (Gametype)var11.next();
            gametype.saveToNBT(tags);
         }

         tags.func_74757_a("Enabled", enabled);
         tags.func_74757_a("Voting", voting);
         tags.func_74768_a("VotingTime", votingTime);
         tags.func_74768_a("ScoreTime", scoreDisplayTime);
         tags.func_74757_a("Bombs", bombsEnabled);
         tags.func_74757_a("Bullets", bulletsEnabled);
         tags.func_74757_a("Explosions", explosions);
         tags.func_74757_a("ForceAdventure", forceAdventureMode);
         tags.func_74757_a("CanBreakGuns", canBreakGuns);
         tags.func_74757_a("CanBreakGlass", canBreakGlass);
         tags.func_74757_a("ArmourDrops", armourDrops);
         tags.func_74768_a("WeaponDrops", weaponDrops);
         tags.func_74757_a("NeedFuel", vehiclesNeedFuel);
         tags.func_74768_a("MGLife", mgLife);
         tags.func_74768_a("AALife", aaLife);
         tags.func_74768_a("VehicleLife", vehicleLife);
         tags.func_74776_a("SeaLevel", seaLevel);
         tags.func_74768_a("MechaLove", mechaLove);
         tags.func_74768_a("PlaneLife", planeLife);
         tags.func_74757_a("BreakBlocks", driveablesBreakBlocks);
         CompressedStreamTools.func_74800_a(tags, new DataOutputStream(new FileOutputStream(file)));
      } catch (Exception var9) {
         FlansMod.log("Failed to save to teams.dat");
         var9.printStackTrace();
      }

   }

   private boolean checkFileExists(File file) {
      if (!file.exists()) {
         try {
            file.createNewFile();
            FlansMod.log("Created new file");
         } catch (Exception var3) {
            FlansMod.log("Failed to create file");
            FlansMod.log(file.getAbsolutePath());
            var3.printStackTrace();
         }

         return false;
      } else {
         return true;
      }
   }

   public void resetScores() {
      Iterator var1 = Team.teams.iterator();

      while(var1.hasNext()) {
         Team team = (Team)var1.next();
         team.score = 0;
         team.members.clear();
      }

      var1 = getPlayers().iterator();

      while(var1.hasNext()) {
         EntityPlayer player = (EntityPlayer)var1.next();
         if (PlayerHandler.getPlayerData(player) != null) {
            PlayerHandler.getPlayerData(player).resetScore();
         }
      }

   }

   public ITeamBase getBase(int ID) {
      Iterator var2 = this.bases.iterator();

      ITeamBase base;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         base = (ITeamBase)var2.next();
      } while(base.getBaseID() != ID);

      return base;
   }

   public void registerBase(ITeamBase base) {
      if (base.getBaseID() == 0) {
         base.setBaseID(this.nextBaseID++);
      }

      this.bases.add(base);
   }

   public void registerObject(ITeamObject obj) {
      this.objects.add(obj);
   }

   public EntityPlayerMP getPlayer(String username) {
      return MinecraftServer.func_71276_C().func_71203_ab().func_152612_a(username);
   }

   public static void log(String s) {
      FlansMod.log("Teams Info : " + s);
   }

   public static void messagePlayer(EntityPlayerMP player, String s) {
      player.func_146105_b(new ChatComponentText(s));
   }

   public static void messageAll(String s) {
      FlansMod.log("Teams Announcement : " + s);
      Iterator var1 = MinecraftServer.func_71276_C().func_71203_ab().field_72404_b.iterator();

      while(var1.hasNext()) {
         EntityPlayerMP player = (EntityPlayerMP)var1.next();
         player.func_146105_b(new ChatComponentText(s));
      }

   }

   public static void sendPacketToPlayer(PacketBase packet, EntityPlayerMP player) {
      FlansMod.getPacketHandler().sendTo(packet, player);
   }

   public static List<EntityPlayer> getPlayers() {
      return MinecraftServer.func_71276_C().func_71203_ab().field_72404_b;
   }

   public Team getTeam(int spawnerTeamID) {
      if (enabled && this.currentRound != null && spawnerTeamID != 0) {
         return spawnerTeamID == 1 ? Team.spectators : this.currentRound.teams[spawnerTeamID - 2];
      } else {
         return null;
      }
   }

   public TeamsMap getMapFromFullName(String string) {
      Iterator var2 = this.maps.values().iterator();

      TeamsMap map;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         map = (TeamsMap)var2.next();
      } while(!map.name.equals(string));

      return map;
   }
}
