package com.flansmod.common;

import com.flansmod.client.AimType;
import com.flansmod.client.FlanMouseButton;
import com.flansmod.client.FlansModClient;
import com.flansmod.client.model.GunAnimations;
import com.flansmod.common.driveables.EntityPlane;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.driveables.EntityVehicle;
import com.flansmod.common.driveables.EntityWheel;
import com.flansmod.common.driveables.ItemPlane;
import com.flansmod.common.driveables.ItemVehicle;
import com.flansmod.common.driveables.PlaneType;
import com.flansmod.common.driveables.VehicleType;
import com.flansmod.common.driveables.mechas.EntityMecha;
import com.flansmod.common.driveables.mechas.ItemMecha;
import com.flansmod.common.driveables.mechas.ItemMechaAddon;
import com.flansmod.common.driveables.mechas.MechaItemType;
import com.flansmod.common.driveables.mechas.MechaType;
import com.flansmod.common.eventhandlers.PlayerDeathEventListener;
import com.flansmod.common.eventhandlers.PlayerLoginEventListener;
import com.flansmod.common.eventhandlers.ServerTickEvent;
import com.flansmod.common.guns.AAGunType;
import com.flansmod.common.guns.AttachmentType;
import com.flansmod.common.guns.BulletType;
import com.flansmod.common.guns.EntityAAGun;
import com.flansmod.common.guns.EntityBullet;
import com.flansmod.common.guns.EntityGrenade;
import com.flansmod.common.guns.EntityMG;
import com.flansmod.common.guns.GrenadeType;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.ItemAAGun;
import com.flansmod.common.guns.ItemAttachment;
import com.flansmod.common.guns.ItemBullet;
import com.flansmod.common.guns.ItemGrenade;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.guns.boxes.BlockGunBox;
import com.flansmod.common.guns.boxes.GunBoxType;
import com.flansmod.common.network.PacketHandler;
import com.flansmod.common.paintjob.BlockPaintjobTable;
import com.flansmod.common.paintjob.TileEntityPaintjobTable;
import com.flansmod.common.parts.ItemPart;
import com.flansmod.common.parts.PartType;
import com.flansmod.common.teams.ArmourBoxType;
import com.flansmod.common.teams.ArmourType;
import com.flansmod.common.teams.BlockArmourBox;
import com.flansmod.common.teams.BlockSpawner;
import com.flansmod.common.teams.ChunkLoadingHandler;
import com.flansmod.common.teams.CommandTeams;
import com.flansmod.common.teams.EntityFlag;
import com.flansmod.common.teams.EntityFlagpole;
import com.flansmod.common.teams.EntityGunItem;
import com.flansmod.common.teams.EntityTeamItem;
import com.flansmod.common.teams.ItemFlagpole;
import com.flansmod.common.teams.ItemOpStick;
import com.flansmod.common.teams.ItemTeamArmour;
import com.flansmod.common.teams.Team;
import com.flansmod.common.teams.TeamsManager;
import com.flansmod.common.teams.TileEntitySpawner;
import com.flansmod.common.tools.EntityParachute;
import com.flansmod.common.tools.ItemTool;
import com.flansmod.common.tools.ToolType;
import com.flansmod.common.types.EnumType;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.types.TypeFile;
import cpw.mods.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import net.minecraft.block.material.Material;
import net.minecraft.command.CommandHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent.CheckSpawn;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import com.flantechtree.common.data.TechTreeManager;

@Mod(
   modid = "flansmod",
   name = "Flan's Mod LabJac Edition",
   version = "LabJac Mod Mark 5 - May 2019 modified by Der Kaiser April 6 2025",
   acceptableRemoteVersions = "1.7.10"
)
public class FlansMod {

   @Mod.EventHandler
   public void postInit(FMLPostInitializationEvent event) {
      ...
      TechTreeManager.loadAllTrees(); // Custom tech trees
   }
   public static boolean DEBUG = false;
   public static Configuration configFile;
   public static final String MODID = "flansmod";
   public static final String VERSION = "LabJac Mod Mark 5 - May 2019";
   @Instance("flansmod")
   public static FlansMod INSTANCE;
   public static int generalConfigInteger = 32;
   public static String generalConfigString = "Hello!";
   public static boolean printDebugLog = true;
   public static boolean printStackTrace = false;
   public static int noticeSpawnKillTime = 10;
   public static boolean gunCarryLimitEnable = false;
   public static int gunCarryLimit = 3;
   public static int armorDurability = 1;
   public static boolean armsEnable = true;
   public static boolean casingEnable = true;
   public static boolean crosshairEnable = false;
   public static boolean hitCrossHairEnable = true;
   public static boolean hdHitCrosshair = false;
   public static boolean bulletGuiEnable = true;
   public static float[] hitCrossHairColor = new float[]{1.0F, 1.0F, 1.0F, 1.0F};
   public static boolean addGunpowderRecipe = true;
   public static boolean addAllPaintjobsToCreative = true;
   public static int teamsConfigInteger = 32;
   public static String teamsConfigString = "Hello!";
   public static boolean teamsConfigBoolean = false;
   @SidedProxy(
      clientSide = "com.flansmod.client.ClientProxy",
      serverSide = "com.flansmod.common.CommonProxy"
   )
   public static CommonProxy proxy;
   public static int ticker = 0;
   public static long lastTime;
   public static File flanDir;
   public static final float soundRange = 50.0F;
   public static final float driveableUpdateRange = 400.0F;
   public static final int numPlayerSnapshots = 20;
   public static int armourSpawnRate = 20;
   public static Team spectators = new Team("spectators", "Spectators", 4210752, '7');
   public static final PacketHandler packetHandler = new PacketHandler();
   public static final PlayerHandler playerHandler = new PlayerHandler();
   public static final TeamsManager teamsManager = new TeamsManager();
   public static final CommonTickHandler tickHandler = new CommonTickHandler();
   public static FlansHooks hooks = new FlansHooks();
   public static boolean isInFlash = false;
   public static int flashTime = 10;
   public static BlockFlansWorkbench workbench;
   public static BlockPaintjobTable paintjobTable;
   public static BlockSpawner spawner;
   public static ItemOpStick opStick;
   public static ItemFlagpole flag;
   public static ArrayList<BlockGunBox> gunBoxBlocks = new ArrayList();
   public static ArrayList<ItemBullet> bulletItems = new ArrayList();
   public static ArrayList<ItemGun> gunItems = new ArrayList();
   public static ArrayList<ItemAttachment> attachmentItems = new ArrayList();
   public static ArrayList<ItemPart> partItems = new ArrayList();
   public static ArrayList<ItemPlane> planeItems = new ArrayList();
   public static ArrayList<ItemVehicle> vehicleItems = new ArrayList();
   public static ArrayList<ItemMechaAddon> mechaToolItems = new ArrayList();
   public static ArrayList<ItemMecha> mechaItems = new ArrayList();
   public static ArrayList<ItemAAGun> aaGunItems = new ArrayList();
   public static ArrayList<ItemGrenade> grenadeItems = new ArrayList();
   public static ArrayList<ItemTool> toolItems = new ArrayList();
   public static ArrayList<ItemTeamArmour> armourItems = new ArrayList();
   public static ArrayList<BlockArmourBox> armourBoxBlocks = new ArrayList();
   public static CreativeTabFlan tabFlanGuns = new CreativeTabFlan(0);
   public static CreativeTabFlan tabFlanDriveables = new CreativeTabFlan(1);
   public static CreativeTabFlan tabFlanParts = new CreativeTabFlan(2);
   public static CreativeTabFlan tabFlanTeams = new CreativeTabFlan(3);
   public static CreativeTabFlan tabFlanMechas = new CreativeTabFlan(4);
   public static HashMap<EntityLivingBase, GunAnimations> gunAnimationsRight = new HashMap();
   public static HashMap<EntityLivingBase, GunAnimations> gunAnimationsLeft = new HashMap();
   public static boolean debugMode = true;

   @EventHandler
   public void preInit(FMLPreInitializationEvent event) {
      log("Preinitialising Flan's mod.");
      configFile = new Configuration(event.getSuggestedConfigurationFile());
      syncConfig(event.getSide());
      flanDir = new File(event.getModConfigurationDirectory().getParentFile(), "/Flan/");
      if (!flanDir.exists()) {
         log("Flan folder not found. Creating empty folder.");
         log("You should get some content packs and put them in the Flan folder.");
         flanDir.mkdirs();
         flanDir.mkdir();
      }

      workbench = (BlockFlansWorkbench)((BlockFlansWorkbench)(new BlockFlansWorkbench(1, 0)).func_149663_c("flansWorkbench").func_149658_d("flansWorkbench"));
      GameRegistry.registerBlock(workbench, ItemBlockManyNames.class, "flansWorkbench");
      GameRegistry.addRecipe(new ItemStack(workbench, 1, 0), new Object[]{"BBB", "III", "III", 'B', Items.field_151054_z, 'I', Items.field_151042_j});
      GameRegistry.addRecipe(new ItemStack(workbench, 1, 1), new Object[]{"ICI", "III", 'C', Items.field_151066_bu, 'I', Items.field_151042_j});
      opStick = new ItemOpStick();
      GameRegistry.registerItem(opStick, "opStick", "flansmod");
      flag = (ItemFlagpole)((ItemFlagpole)(new ItemFlagpole()).func_77655_b("flagpole"));
      GameRegistry.registerItem(flag, "flagpole", "flansmod");
      spawner = (BlockSpawner)((BlockSpawner)(new BlockSpawner(Material.field_151573_f)).func_149663_c("teamsSpawner").func_149722_s().func_149752_b(1000000.0F));
      GameRegistry.registerBlock(spawner, ItemBlockManyNames.class, "teamsSpawner");
      GameRegistry.registerTileEntity(TileEntitySpawner.class, "teamsSpawner");
      paintjobTable = new BlockPaintjobTable();
      GameRegistry.registerBlock(paintjobTable, "paintjobTable");
      GameRegistry.registerTileEntity(TileEntityPaintjobTable.class, "flansmod");
      proxy.registerRenderers();
      this.readContentPacks(event);
      if (gunItems.size() >= 1) {
         MinecraftForge.EVENT_BUS.register(gunItems.get(0));
      }

      proxy.load();
      proxy.forceReload();
      log("Preinitializing complete.");
   }

   @EventHandler
   public void init(FMLInitializationEvent event) {
      log("Initialising Flan's Mod.");
      packetHandler.initialise();
      NetworkRegistry.INSTANCE.registerGuiHandler(this, new CommonGuiHandler());
      Iterator var2 = InfoType.infoTypes.iterator();

      while(var2.hasNext()) {
         InfoType type = (InfoType)var2.next();
         type.addRecipe();
      }

      if (addGunpowderRecipe) {
         ItemStack charcoal = new ItemStack(Items.field_151044_h, 1, 1);
         GameRegistry.addShapelessRecipe(new ItemStack(Items.field_151016_H), new Object[]{charcoal, charcoal, charcoal, new ItemStack(Items.field_151114_aO)});
      }

      log("Loaded recipes.");
      EntityRegistry.registerGlobalEntityID(EntityFlagpole.class, "Flagpole", EntityRegistry.findGlobalUniqueEntityId());
      EntityRegistry.registerModEntity(EntityFlagpole.class, "Flagpole", 93, this, 40, 5, true);
      EntityRegistry.registerGlobalEntityID(EntityFlag.class, "Flag", EntityRegistry.findGlobalUniqueEntityId());
      EntityRegistry.registerModEntity(EntityFlag.class, "Flag", 94, this, 40, 5, true);
      EntityRegistry.registerGlobalEntityID(EntityTeamItem.class, "TeamsItem", EntityRegistry.findGlobalUniqueEntityId());
      EntityRegistry.registerModEntity(EntityTeamItem.class, "TeamsItem", 97, this, 100, 10000, true);
      EntityRegistry.registerGlobalEntityID(EntityGunItem.class, "GunItem", EntityRegistry.findGlobalUniqueEntityId());
      EntityRegistry.registerModEntity(EntityGunItem.class, "GunItem", 98, this, 100, 20, true);
      EntityRegistry.registerGlobalEntityID(EntityPlane.class, "Plane", EntityRegistry.findGlobalUniqueEntityId());
      EntityRegistry.registerModEntity(EntityPlane.class, "Plane", 90, this, 200, 3, true);
      EntityRegistry.registerGlobalEntityID(EntityVehicle.class, "Vehicle", EntityRegistry.findGlobalUniqueEntityId());
      EntityRegistry.registerModEntity(EntityVehicle.class, "Vehicle", 95, this, 400, 10, true);
      EntityRegistry.registerGlobalEntityID(EntitySeat.class, "Seat", EntityRegistry.findGlobalUniqueEntityId());
      EntityRegistry.registerModEntity(EntitySeat.class, "Seat", 99, this, 250, 10, true);
      EntityRegistry.registerGlobalEntityID(EntityWheel.class, "Wheel", EntityRegistry.findGlobalUniqueEntityId());
      EntityRegistry.registerModEntity(EntityWheel.class, "Wheel", 103, this, 200, 20, true);
      EntityRegistry.registerGlobalEntityID(EntityParachute.class, "Parachute", EntityRegistry.findGlobalUniqueEntityId());
      EntityRegistry.registerModEntity(EntityParachute.class, "Parachute", 101, this, 40, 20, false);
      EntityRegistry.registerGlobalEntityID(EntityMecha.class, "Mecha", EntityRegistry.findGlobalUniqueEntityId());
      EntityRegistry.registerModEntity(EntityMecha.class, "Mecha", 102, this, 250, 20, false);
      EntityRegistry.registerGlobalEntityID(EntityBullet.class, "Bullet", EntityRegistry.findGlobalUniqueEntityId());
      EntityRegistry.registerModEntity(EntityBullet.class, "Bullet", 96, this, 200, 20, false);
      EntityRegistry.registerGlobalEntityID(EntityGrenade.class, "Grenade", EntityRegistry.findGlobalUniqueEntityId());
      EntityRegistry.registerModEntity(EntityGrenade.class, "Grenade", 100, this, 40, 100, true);
      EntityRegistry.registerGlobalEntityID(EntityMG.class, "MG", EntityRegistry.findGlobalUniqueEntityId());
      EntityRegistry.registerModEntity(EntityMG.class, "MG", 91, this, 40, 5, true);
      EntityRegistry.registerGlobalEntityID(EntityAAGun.class, "AAGun", EntityRegistry.findGlobalUniqueEntityId());
      EntityRegistry.registerModEntity(EntityAAGun.class, "AAGun", 92, this, 40, 500, false);
      ForgeChunkManager.setForcedChunkLoadingCallback(this, new ChunkLoadingHandler());
      FMLCommonHandler.instance().bus().register(INSTANCE);
      new PlayerDeathEventListener();
      new PlayerLoginEventListener();
      new ServerTickEvent();
      log("Loading complete.");
   }

   @EventHandler
   public void postInit(FMLPostInitializationEvent event) {
      packetHandler.postInitialise();
      hooks.hook();
   }

   @SubscribeEvent
   public void playerDrops(PlayerDropsEvent event) {
      for(int i = event.drops.size() - 1; i >= 0; --i) {
         EntityItem ent = (EntityItem)event.drops.get(i);
         InfoType type = InfoType.getType(ent.func_92059_d());
         if (type != null && !type.canDrop) {
            event.drops.remove(i);
         }
      }

   }

   @SubscribeEvent
   public void playerDrops(ItemTossEvent event) {
      InfoType type = InfoType.getType(event.entityItem.func_92059_d());
      if (type != null && !type.canDrop) {
         event.setCanceled(true);
      }

   }

   @EventHandler
   public void registerCommand(FMLServerStartedEvent e) {
      CommandHandler handler = (CommandHandler)FMLCommonHandler.instance().getSidedDelegate().getServer().func_71187_D();
      handler.func_71560_a(new CommandTeams());
   }

   @SubscribeEvent
   public void onConfigChanged(OnConfigChangedEvent eventArgs) {
      if (eventArgs.modID.equals("flansmod")) {
         syncConfig();
      }

   }

   @SubscribeEvent
   public void onLivingSpecialSpawn(CheckSpawn event) {
      int chance = event.world.field_73012_v.nextInt(101);
      if (chance < armourSpawnRate && (event.entityLiving instanceof EntityZombie || event.entityLiving instanceof EntitySkeleton)) {
         if (event.world.field_73012_v.nextBoolean() && ArmourType.armours.size() > 0) {
            ArmourType armour = (ArmourType)ArmourType.armours.get(event.world.field_73012_v.nextInt(ArmourType.armours.size()));
            if (armour != null && armour.type != 2) {
               event.entityLiving.func_70062_b(armour.type + 1, new ItemStack(armour.item));
            }
         } else if (Team.teams.size() > 0) {
            Team team = (Team)Team.teams.get(event.world.field_73012_v.nextInt(Team.teams.size()));
            if (team.hat != null) {
               event.entityLiving.func_70062_b(1, team.hat.func_77946_l());
            }

            if (team.chest != null) {
               event.entityLiving.func_70062_b(2, team.chest.func_77946_l());
            }

            if (team.shoes != null) {
               event.entityLiving.func_70062_b(4, team.shoes.func_77946_l());
            }
         }
      }

   }

   private void getTypeFiles(List<File> contentPacks) {
      Iterator var2 = contentPacks.iterator();

      while(true) {
         while(var2.hasNext()) {
            File contentPack = (File)var2.next();
            int var10;
            int var11;
            if (contentPack.isDirectory()) {
               EnumType[] var23 = EnumType.values();
               int var24 = var23.length;

               for(int var25 = 0; var25 < var24; ++var25) {
                  EnumType typeToCheckFor = var23[var25];
                  File typesDir = new File(contentPack, "/" + typeToCheckFor.folderName + "/");
                  if (typesDir.exists()) {
                     File[] var29 = typesDir.listFiles();
                     var10 = var29.length;

                     for(var11 = 0; var11 < var10; ++var11) {
                        File file = var29[var11];

                        try {
                           BufferedReader reader = new BufferedReader(new FileReader(file));
                           String[] splitName = file.getName().split("/");
                           TypeFile typeFile = new TypeFile(typeToCheckFor, splitName[splitName.length - 1].split("\\.")[0], contentPack.getName());

                           while(true) {
                              String line = null;

                              try {
                                 line = reader.readLine();
                              } catch (Exception var20) {
                                 break;
                              }

                              if (line == null) {
                                 break;
                              }

                              typeFile.lines.add(line);
                           }

                           reader.close();
                        } catch (FileNotFoundException var21) {
                           var21.printStackTrace();
                        } catch (IOException var22) {
                           var22.printStackTrace();
                        }
                     }
                  }
               }
            } else {
               try {
                  ZipFile zip = new ZipFile(contentPack);
                  ZipInputStream zipStream = new ZipInputStream(new FileInputStream(contentPack));
                  BufferedReader reader = new BufferedReader(new InputStreamReader(zipStream));
                  ZipEntry zipEntry = zipStream.getNextEntry();

                  do {
                     zipEntry = zipStream.getNextEntry();
                     if (zipEntry != null) {
                        TypeFile typeFile = null;
                        EnumType[] var9 = EnumType.values();
                        var10 = var9.length;

                        for(var11 = 0; var11 < var10; ++var11) {
                           EnumType type = var9[var11];
                           if (zipEntry.getName().startsWith(type.folderName + "/") && zipEntry.getName().split(type.folderName + "/").length > 1 && zipEntry.getName().split(type.folderName + "/")[1].length() > 0) {
                              String[] splitName = zipEntry.getName().split("/");
                              typeFile = new TypeFile(type, splitName[splitName.length - 1].split("\\.")[0], contentPack.getName());
                           }
                        }

                        if (typeFile != null) {
                           while(true) {
                              var9 = null;

                              String line;
                              try {
                                 line = reader.readLine();
                              } catch (Exception var18) {
                                 break;
                              }

                              if (line == null) {
                                 break;
                              }

                              typeFile.lines.add(line);
                           }
                        }
                     }
                  } while(zipEntry != null);

                  reader.close();
                  zip.close();
                  zipStream.close();
               } catch (IOException var19) {
                  var19.printStackTrace();
               }
            }
         }

         return;
      }
   }

   private void readContentPacks(FMLPreInitializationEvent event) {
      ClassLoader classloader = MinecraftServer.class.getClassLoader();
      Method method = null;

      try {
         method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
         method.setAccessible(true);
      } catch (Exception var14) {
         log("Failed to get class loader. All content loading will now fail.");
         if (printStackTrace) {
            var14.printStackTrace();
         }
      }

      List<File> contentPacks = proxy.getContentList(method, classloader);
      if (!event.getSide().equals(Side.CLIENT)) {
      }

      this.getTypeFiles(contentPacks);
      EnumType[] var5 = EnumType.values();
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         EnumType type = var5[var7];
         Class<? extends InfoType> typeClass = type.getTypeClass();
         Iterator var10 = ((ArrayList)TypeFile.files.get(type)).iterator();

         while(var10.hasNext()) {
            TypeFile typeFile = (TypeFile)var10.next();

            try {
               InfoType infoType = (InfoType)typeClass.getConstructor(TypeFile.class).newInstance(typeFile);
               infoType.read(typeFile);
               switch(type) {
               case bullet:
                  bulletItems.add((ItemBullet)(new ItemBullet((BulletType)infoType)).func_77655_b(infoType.shortName));
                  break;
               case attachment:
                  attachmentItems.add((ItemAttachment)(new ItemAttachment((AttachmentType)infoType)).func_77655_b(infoType.shortName));
                  break;
               case gun:
                  gunItems.add((ItemGun)(new ItemGun((GunType)infoType)).func_77655_b(infoType.shortName));
                  break;
               case grenade:
                  grenadeItems.add((ItemGrenade)(new ItemGrenade((GrenadeType)infoType)).func_77655_b(infoType.shortName));
                  break;
               case part:
                  partItems.add((ItemPart)(new ItemPart((PartType)infoType)).func_77655_b(infoType.shortName));
                  break;
               case plane:
                  planeItems.add((ItemPlane)(new ItemPlane((PlaneType)infoType)).func_77655_b(infoType.shortName));
                  break;
               case vehicle:
                  vehicleItems.add((ItemVehicle)(new ItemVehicle((VehicleType)infoType)).func_77655_b(infoType.shortName));
                  break;
               case aa:
                  aaGunItems.add((ItemAAGun)(new ItemAAGun((AAGunType)infoType)).func_77655_b(infoType.shortName));
                  break;
               case mechaItem:
                  mechaToolItems.add((ItemMechaAddon)(new ItemMechaAddon((MechaItemType)infoType)).func_77655_b(infoType.shortName));
                  break;
               case mecha:
                  mechaItems.add((ItemMecha)(new ItemMecha((MechaType)infoType)).func_77655_b(infoType.shortName));
                  break;
               case tool:
                  toolItems.add((ItemTool)(new ItemTool((ToolType)infoType)).func_77655_b(infoType.shortName));
                  break;
               case box:
                  gunBoxBlocks.add((BlockGunBox)(new BlockGunBox((GunBoxType)infoType)).func_149663_c(infoType.shortName));
                  break;
               case armour:
                  armourItems.add((ItemTeamArmour)(new ItemTeamArmour((ArmourType)infoType)).func_77655_b(infoType.shortName));
                  break;
               case armourBox:
                  armourBoxBlocks.add((BlockArmourBox)(new BlockArmourBox((ArmourBoxType)infoType)).func_149663_c(infoType.shortName));
               case playerClass:
               case team:
                  break;
               default:
                  log("Unrecognised type for " + infoType.shortName);
               }
            } catch (Exception var13) {
               log("Failed to add " + type.name() + " : " + typeFile.name);
               if (printStackTrace) {
                  var13.printStackTrace();
               }
            }
         }

         log("Loaded " + type.name() + ".");
      }

      Team.spectators = spectators;
   }

   public static PacketHandler getPacketHandler() {
      FlansMod var10000 = INSTANCE;
      return packetHandler;
   }

   public static void syncConfig() {
      printDebugLog = configFile.getBoolean("Print Debug Log", "general", printDebugLog, "");
      printStackTrace = configFile.getBoolean("Print Stack Trace", "general", printStackTrace, "");
      addGunpowderRecipe = configFile.getBoolean("Gunpowder Recipe", "general", addGunpowderRecipe, "Whether or not to add the extra gunpowder recipe (3 charcoal + 1 lightstone)");
      addAllPaintjobsToCreative = configFile.getBoolean("Add All Paintjobs To Creative", "general", addAllPaintjobsToCreative, "Whether to list all available paintjobs in the Creative menu");
      armourSpawnRate = configFile.getInt("ArmourSpawnRate", "general", 20, 0, 100, "The rate of Zombie or Skeleton to spawn equipped with armor. [0=0%, 100=100%]");
      noticeSpawnKillTime = configFile.getInt("NoticeSpawnKillTime", "general", 10, 0, 600, "Min(default=10)");
      gunCarryLimitEnable = configFile.getBoolean("gunCarryLimitEnable", "general", gunCarryLimitEnable, "Enable a soft limit to hotbar weapons, applies slowness++ when >= limit");
      gunCarryLimit = configFile.getInt("gunCarryLimit", "general", 3, 2, 9, "Set the soft carry limit for guns(2-9)");
      armsEnable = configFile.getBoolean("Enable Arms", "general", armsEnable, "Enable arms rendering default=true");
      casingEnable = configFile.getBoolean("Enable casings", "general", casingEnable, "Enable bullet casing ejections default=true");
      crosshairEnable = configFile.getBoolean("Enable crosshairs", "general", crosshairEnable, "Enable default crosshair default=false");
      bulletGuiEnable = configFile.getBoolean("Enable bullet HUD", "general", bulletGuiEnable, "Enable bullet gui default=true");
      hitCrossHairEnable = configFile.getBoolean("Enable hitmarkers", "general", hitCrossHairEnable, "");
      hdHitCrosshair = configFile.getBoolean("Enable HD hit marker", "general", hdHitCrosshair, "");

      for(int i = 0; i < hitCrossHairColor.length; ++i) {
         String[] COLOR = new String[]{"Alpha", "Red", "Green", "Blue"};
         hitCrossHairColor[i] = configFile.getFloat("HitCrossHairColor" + COLOR[i], "general", hitCrossHairColor[i], 0.0F, 1.0F, "Hit cross hair color " + COLOR[i] + "(default=1.0)");
      }

      if (configFile.hasChanged()) {
         configFile.save();
      }

   }

   public static void syncConfig(Side side) {
      printDebugLog = configFile.getBoolean("Print Debug Log", "general", printDebugLog, "");
      printStackTrace = configFile.getBoolean("Print Stack Trace", "general", printStackTrace, "");
      addGunpowderRecipe = configFile.getBoolean("Gunpowder Recipe", "general", addGunpowderRecipe, "Whether or not to add the extra gunpowder recipe (3 charcoal + 1 lightstone)");
      addAllPaintjobsToCreative = configFile.getBoolean("Add All Paintjobs To Creative", "general", addAllPaintjobsToCreative, "Whether to list all available paintjobs in the Creative menu");
      armourSpawnRate = configFile.getInt("ArmourSpawnRate", "general", 20, 0, 100, "The rate of Zombie or Skeleton to spawn equipped with armor. [0=0%, 100=100%]");
      noticeSpawnKillTime = configFile.getInt("NoticeSpawnKillTime", "general", 10, 0, 600, "Min(default=10)");
      gunCarryLimitEnable = configFile.getBoolean("gunCarryLimitEnable", "general", gunCarryLimitEnable, "Enable a soft limit to hotbar weapons, applies slowness++ when >= limit");
      gunCarryLimit = configFile.getInt("gunCarryLimit", "general", 3, 2, 9, "Set the soft carry limit for guns(2-9)");
      armsEnable = configFile.getBoolean("Enable Arms", "general", armsEnable, "Enable arms rendering default=true");
      casingEnable = configFile.getBoolean("Enable casings", "general", casingEnable, "Enable bullet casing ejections default=true");
      crosshairEnable = configFile.getBoolean("Enable crosshairs", "general", crosshairEnable, "Enable default crosshair default=false");
      bulletGuiEnable = configFile.getBoolean("Enable bullet HUD", "general", bulletGuiEnable, "Enable bullet gui default=true");
      hitCrossHairEnable = configFile.getBoolean("Enable hitmarkers", "general", hitCrossHairEnable, "");
      hdHitCrosshair = configFile.getBoolean("Enable HD hit marker", "general", hdHitCrosshair, "");

      for(int i = 0; i < hitCrossHairColor.length; ++i) {
         String[] COLOR = new String[]{"Alpha", "Red", "Green", "Blue"};
         hitCrossHairColor[i] = configFile.getFloat("HitCrossHairColor" + COLOR[i], "general", hitCrossHairColor[i], 0.0F, 1.0F, "Hit cross hair color " + COLOR[i] + "(default=1.0)");
      }

      if (side.isClient()) {
         String aimTypeInput = configFile.getString("Aim Type", "Settings", "toggle", "The type of aiming that you want to use 'toggle' or 'hold'");
         AimType aimType = AimType.fromString(aimTypeInput);
         if (aimType != null) {
            FlansModClient.aimType = aimType;
         } else {
            log(String.format("The aim type '%s' does not exist.", aimTypeInput));
            FlansModClient.aimType = AimType.TOGGLE;
         }

         String aimButtonInput = configFile.getString("Aim Button", "Settings", "left", "The mouse button used to aim a gun 'left' or 'right'");
         FlanMouseButton aimButtonType = FlanMouseButton.fromString(aimButtonInput);
         if (aimButtonType != null) {
            FlansModClient.aimButton = aimButtonType;
         } else {
            log(String.format("The aim button type '%s' does not exist.", aimTypeInput));
            FlansModClient.aimButton = FlanMouseButton.LEFT;
         }

         String shootButtonInput = configFile.getString("Fire Button", "Settings", "right", "The mouse button used to fire a gun 'left' or 'right'");
         FlanMouseButton shootButtonType = FlanMouseButton.fromString(shootButtonInput);
         if (shootButtonType != null) {
            FlansModClient.fireButton = shootButtonType;
         } else {
            log(String.format("The fire button type '%s' does not exist.", aimTypeInput));
            FlansModClient.fireButton = FlanMouseButton.RIGHT;
         }
      }

      if (configFile.hasChanged()) {
         configFile.save();
      }

   }

   public static void updateBltssConfig(int min, int divisor) {
      ConfigCategory category = configFile.getCategory("general");
      if (category != null) {
         if (category.containsKey("BltSS_Min")) {
            category.get("BltSS_Min").set(min);
         }

         if (category.containsKey("BltSS_Divisor")) {
            category.get("BltSS_Divisor").set(divisor);
         }

         configFile.save();
      }
   }

   public static void log(String string) {
      if (printDebugLog) {
         System.out.println("[Flan's Mod] " + string);
      }

   }

   public static void log(String format, Object... args) {
      log(String.format(format, args));
   }
}
