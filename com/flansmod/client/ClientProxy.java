package com.flansmod.client;

import com.flansmod.client.debug.EntityDebugAABB;
import com.flansmod.client.debug.EntityDebugDot;
import com.flansmod.client.debug.EntityDebugVector;
import com.flansmod.client.debug.RenderDebugAABB;
import com.flansmod.client.debug.RenderDebugDot;
import com.flansmod.client.debug.RenderDebugVector;
import com.flansmod.client.gui.GuiArmourBox;
import com.flansmod.client.gui.GuiDriveableCrafting;
import com.flansmod.client.gui.GuiDriveableFuel;
import com.flansmod.client.gui.GuiDriveableInventory;
import com.flansmod.client.gui.GuiDriveableMenu;
import com.flansmod.client.gui.GuiDriveableRepair;
import com.flansmod.client.gui.GuiGunBox;
import com.flansmod.client.gui.GuiGunModTable;
import com.flansmod.client.gui.GuiMechaInventory;
import com.flansmod.client.gui.GuiPaintjobTable;
import com.flansmod.client.model.RenderAAGun;
import com.flansmod.client.model.RenderBullet;
import com.flansmod.client.model.RenderFlag;
import com.flansmod.client.model.RenderFlagpole;
import com.flansmod.client.model.RenderGrenade;
import com.flansmod.client.model.RenderGun;
import com.flansmod.client.model.RenderMG;
import com.flansmod.client.model.RenderMecha;
import com.flansmod.client.model.RenderNull;
import com.flansmod.client.model.RenderParachute;
import com.flansmod.client.model.RenderPlane;
import com.flansmod.client.model.RenderVehicle;
import com.flansmod.common.CommonProxy;
import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.DriveablePart;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntityPlane;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.driveables.EntityVehicle;
import com.flansmod.common.driveables.EntityWheel;
import com.flansmod.common.driveables.EnumPlaneMode;
import com.flansmod.common.driveables.PlaneType;
import com.flansmod.common.driveables.VehicleType;
import com.flansmod.common.driveables.mechas.EntityMecha;
import com.flansmod.common.driveables.mechas.MechaType;
import com.flansmod.common.guns.EntityAAGun;
import com.flansmod.common.guns.EntityBullet;
import com.flansmod.common.guns.EntityGrenade;
import com.flansmod.common.guns.EntityMG;
import com.flansmod.common.guns.GrenadeType;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.boxes.BlockGunBox;
import com.flansmod.common.guns.boxes.GunBoxType;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketBuyArmour;
import com.flansmod.common.network.PacketBuyWeapon;
import com.flansmod.common.network.PacketCraftDriveable;
import com.flansmod.common.network.PacketGiveItem;
import com.flansmod.common.network.PacketRepairDriveable;
import com.flansmod.common.paintjob.TileEntityPaintjobTable;
import com.flansmod.common.teams.ArmourBoxType;
import com.flansmod.common.teams.BlockArmourBox;
import com.flansmod.common.teams.EntityFlag;
import com.flansmod.common.teams.EntityFlagpole;
import com.flansmod.common.teams.TileEntitySpawner;
import com.flansmod.common.tools.EntityParachute;
import com.flansmod.common.types.InfoType;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLModContainer;
import cpw.mods.fml.common.MetadataCollection;
import cpw.mods.fml.common.discovery.ContainerType;
import cpw.mods.fml.common.discovery.ModCandidate;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityAuraFX;
import net.minecraft.client.particle.EntityBlockDustFX;
import net.minecraft.client.particle.EntityBreakingFX;
import net.minecraft.client.particle.EntityBubbleFX;
import net.minecraft.client.particle.EntityCloudFX;
import net.minecraft.client.particle.EntityCritFX;
import net.minecraft.client.particle.EntityDiggingFX;
import net.minecraft.client.particle.EntityDropParticleFX;
import net.minecraft.client.particle.EntityEnchantmentTableParticleFX;
import net.minecraft.client.particle.EntityExplodeFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.client.particle.EntityFishWakeFX;
import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.client.particle.EntityFootStepFX;
import net.minecraft.client.particle.EntityHeartFX;
import net.minecraft.client.particle.EntityHugeExplodeFX;
import net.minecraft.client.particle.EntityLargeExplodeFX;
import net.minecraft.client.particle.EntityLavaFX;
import net.minecraft.client.particle.EntityNoteFX;
import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.client.particle.EntityReddustFX;
import net.minecraft.client.particle.EntitySmokeFX;
import net.minecraft.client.particle.EntitySnowShovelFX;
import net.minecraft.client.particle.EntitySpellParticleFX;
import net.minecraft.client.particle.EntitySplashFX;
import net.minecraft.client.particle.EntitySuspendFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class ClientProxy extends CommonProxy {
   public static String modelDir = "com.flansmod.client.model.";
   public static RenderGun gunRenderer;
   public static RenderGrenade grenadeRenderer;
   public static RenderPlane planeRenderer;
   public static RenderVehicle vehicleRenderer;
   public static RenderMecha mechaRenderer;
   public List<File> contentPacks;

   public void load() {
      (new FlansModClient()).load();
      gunRenderer = new RenderGun();
      grenadeRenderer = new RenderGrenade();
      planeRenderer = new RenderPlane();
      vehicleRenderer = new RenderVehicle();
      mechaRenderer = new RenderMecha();
      Iterator var1 = GunType.guns.values().iterator();

      while(var1.hasNext()) {
         GunType gunType = (GunType)var1.next();
         MinecraftForgeClient.registerItemRenderer(gunType.item, gunRenderer);
      }

      var1 = GrenadeType.grenades.iterator();

      while(var1.hasNext()) {
         GrenadeType grenadeType = (GrenadeType)var1.next();
         MinecraftForgeClient.registerItemRenderer(grenadeType.item, grenadeRenderer);
      }

      var1 = PlaneType.types.iterator();

      while(var1.hasNext()) {
         PlaneType planeType = (PlaneType)var1.next();
         MinecraftForgeClient.registerItemRenderer(planeType.item, planeRenderer);
      }

      var1 = VehicleType.types.iterator();

      while(var1.hasNext()) {
         VehicleType vehicleType = (VehicleType)var1.next();
         MinecraftForgeClient.registerItemRenderer(vehicleType.item, vehicleRenderer);
      }

      var1 = MechaType.types.iterator();

      while(var1.hasNext()) {
         MechaType mechaType = (MechaType)var1.next();
         MinecraftForgeClient.registerItemRenderer(mechaType.item, mechaRenderer);
      }

      FMLCommonHandler.instance().bus().register(new KeyInputHandler());
      new TickHandlerClient();
   }

   public void forceReload() {
      Minecraft.func_71410_x().func_110436_a();
   }

   public List<File> getContentList(Method method, ClassLoader classloader) {
      this.contentPacks = new ArrayList();
      File[] var3 = FlansMod.flanDir.listFiles();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         File file = var3[var5];
         if (file.isDirectory() || zipJar.matcher(file.getName()).matches()) {
            try {
               method.invoke(classloader, file.toURI().toURL());
               HashMap<String, Object> map = new HashMap();
               map.put("modid", "FlansMod");
               map.put("name", "Flan's Mod : " + file.getName());
               map.put("version", "1");
               FMLModContainer container = new FMLModContainer("com.flansmod.common.FlansMod", new ModCandidate(file, file, file.isDirectory() ? ContainerType.DIR : ContainerType.JAR), map);
               container.bindMetadata(MetadataCollection.from((InputStream)null, ""));
               FMLClientHandler.instance().addModAsResource(container);
            } catch (Exception var9) {
               FlansMod.log("Failed to load images for content pack : " + file.getName());
               var9.printStackTrace();
            }

            FlansMod.log("Loaded content pack : " + file.getName());
            this.contentPacks.add(file);
         }
      }

      FlansMod.log("Loaded textures and models.");
      return this.contentPacks;
   }

   public void registerRenderers() {
      RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet());
      RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderGrenade());
      RenderingRegistry.registerEntityRenderingHandler(EntityPlane.class, new RenderPlane());
      RenderingRegistry.registerEntityRenderingHandler(EntityVehicle.class, new RenderVehicle());
      RenderingRegistry.registerEntityRenderingHandler(EntityAAGun.class, new RenderAAGun());
      RenderingRegistry.registerEntityRenderingHandler(EntityFlagpole.class, new RenderFlagpole());
      RenderingRegistry.registerEntityRenderingHandler(EntityFlag.class, new RenderFlag());
      RenderingRegistry.registerEntityRenderingHandler(EntitySeat.class, new RenderNull());
      RenderingRegistry.registerEntityRenderingHandler(EntityWheel.class, new RenderNull());
      RenderingRegistry.registerEntityRenderingHandler(EntityMG.class, new RenderMG());
      RenderingRegistry.registerEntityRenderingHandler(EntityParachute.class, new RenderParachute());
      RenderingRegistry.registerEntityRenderingHandler(EntityDebugDot.class, new RenderDebugDot());
      RenderingRegistry.registerEntityRenderingHandler(EntityDebugVector.class, new RenderDebugVector());
      RenderingRegistry.registerEntityRenderingHandler(EntityDebugAABB.class, new RenderDebugAABB());
      RenderingRegistry.registerEntityRenderingHandler(EntityMecha.class, new RenderMecha());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySpawner.class, new TileEntitySpawnerRenderer());
   }

   public void doTutorialStuff(EntityPlayer player, EntityDriveable entityType) {
      if (!FlansModClient.doneTutorial) {
         FlansModClient.doneTutorial = false;
         player.func_146105_b(new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.inventoryKey.func_151463_i()) + " to open the menu"));
         player.func_146105_b(new ChatComponentText("Press " + Keyboard.getKeyName(Minecraft.func_71410_x().field_71474_y.field_74311_E.func_151463_i()) + " to get out"));
         if (entityType instanceof EntityPlane) {
            player.func_146105_b(new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.controlSwitchKey.func_151463_i()) + " for mouse control mode"));
            if (PlaneType.getPlane(((EntityPlane)entityType).driveableType).hasGear) {
               player.func_146105_b(new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.gearKey.func_151463_i()) + " to switch the gear"));
            }

            if (PlaneType.getPlane(((EntityPlane)entityType).driveableType).hasDoor) {
               player.func_146105_b(new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.doorKey.func_151463_i()) + " to switch the doors"));
            }

            if (PlaneType.getPlane(((EntityPlane)entityType).driveableType).mode == EnumPlaneMode.VTOL) {
               player.func_146105_b(new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.modeKey.func_151463_i()) + " to switch VTOL mode"));
            }
         }

         if (entityType instanceof EntityVehicle) {
            player.func_146105_b(new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.leftRollKey.func_151463_i()) + " to lock a tank turret / cannon"));
            player.func_146105_b(new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.rightRollKey.func_151463_i()) + " to unlock a tank turret / cannon"));
            player.func_146105_b(new ChatComponentText("Press the spacebar to brake"));
         }
      }

   }

   public void changeControlMode(EntityPlayer player) {
      if (FlansModClient.flipControlMode()) {
         player.func_146105_b(new ChatComponentText("Mouse Control mode is now set to " + FlansModClient.controlModeMouse));
      }

   }

   public boolean mouseControlEnabled() {
      return FlansModClient.controlModeMouse;
   }

   public Object getClientGui(int ID, EntityPlayer player, World world, int x, int y, int z) {
      if ((ID >= 6 && ID <= 10 || ID == 12) && player.field_70154_o == null) {
         return null;
      } else {
         switch(ID) {
         case 0:
            return new GuiDriveableCrafting(player.field_71071_by, world, x, y, z);
         case 1:
            return new GuiDriveableRepair(player);
         case 2:
            return new GuiGunModTable(player.field_71071_by, world);
         case 3:
         case 4:
         default:
            return null;
         case 5:
            return new GuiGunBox(player.field_71071_by, ((BlockGunBox)world.func_147439_a(x, y, z)).type, world);
         case 6:
            return new GuiDriveableInventory(player.field_71071_by, world, ((EntitySeat)player.field_70154_o).driveable, 0);
         case 7:
            return new GuiDriveableInventory(player.field_71071_by, world, ((EntitySeat)player.field_70154_o).driveable, 1);
         case 8:
            return new GuiDriveableFuel(player.field_71071_by, world, ((EntitySeat)player.field_70154_o).driveable);
         case 9:
            return new GuiDriveableInventory(player.field_71071_by, world, ((EntitySeat)player.field_70154_o).driveable, 2);
         case 10:
            return new GuiMechaInventory(player.field_71071_by, world, (EntityMecha)((EntitySeat)player.field_70154_o).driveable);
         case 11:
            return new GuiArmourBox(player.field_71071_by, ((BlockArmourBox)world.func_147439_a(x, y, z)).type);
         case 12:
            return new GuiDriveableInventory(player.field_71071_by, world, ((EntitySeat)player.field_70154_o).driveable, 3);
         case 13:
            return new GuiPaintjobTable(player.field_71071_by, world, (TileEntityPaintjobTable)world.func_147438_o(x, y, z));
         }
      }
   }

   public void openDriveableMenu(EntityPlayer player, World world, EntityDriveable driveable) {
      FMLClientHandler.instance().getClient().func_147108_a(new GuiDriveableMenu(player.field_71071_by, world, driveable));
   }

   private String getModelName(String in) {
      String[] split = in.split("\\.");
      if (split.length == 1) {
         return "Model" + in;
      } else if (split.length <= 1) {
         return in;
      } else {
         String out = "Model" + split[split.length - 1];

         for(int i = split.length - 2; i >= 0; --i) {
            out = split[i] + "." + out;
         }

         return out;
      }
   }

   public <T> T loadModel(String s, String shortName, Class<T> typeClass) {
      if (s != null && shortName != null) {
         try {
            return typeClass.cast(Class.forName(modelDir + this.getModelName(s)).getConstructor().newInstance());
         } catch (Exception var5) {
            FlansMod.log("Failed to load model : " + shortName + " (" + s + ")");
            if (FlansMod.printStackTrace) {
               var5.printStackTrace();
            }

            return null;
         }
      } else {
         return null;
      }
   }

   public void loadSound(String contentPack, String type, String sound) {
      FlansModResourceHandler.getSound(sound);
   }

   public boolean isThePlayer(EntityPlayer player) {
      return player == FMLClientHandler.instance().getClient().field_71439_g;
   }

   public EntityPlayer getThePlayer() {
      return FMLClientHandler.instance().getClient().field_71439_g;
   }

   public boolean isOnSameTeamClientPlayer(EntityLivingBase entity) {
      return FMLClientHandler.instance().getClient().field_71439_g.func_142014_c(entity);
   }

   public void buyGun(GunBoxType type, InfoType gun) {
      FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketBuyWeapon(type, gun)));
      FlansModClient.shootTimeRight = 10;
      FlansModClient.shootTimeLeft = 10;
   }

   public void buyArmour(String shortName, int piece, ArmourBoxType box) {
      FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketBuyArmour(box.shortName, shortName, piece)));
      FlansModClient.shootTimeRight = 10;
      FlansModClient.shootTimeLeft = 10;
   }

   public void addItem(EntityPlayer player, int id) {
      super.addItem(player, id);
      if (player.field_70170_p.field_72995_K) {
         FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketGiveItem(57)));
      }

   }

   public void craftDriveable(EntityPlayer player, DriveableType type) {
      super.craftDriveable(player, type);
      if (player.field_70170_p.field_72995_K) {
         FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketCraftDriveable(type.shortName)));
      }

   }

   public void repairDriveable(EntityPlayer driver, EntityDriveable driving, DriveablePart part) {
      super.repairDriveable(driver, driving, part);
      if (driver.field_70170_p.field_72995_K) {
         FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketRepairDriveable(part.type)));
      }

   }

   public boolean isScreenOpen() {
      return Minecraft.func_71410_x().field_71462_r != null;
   }

   public boolean isKeyDown(int key) {
      switch(key) {
      case 0:
         return this.keyDown(Minecraft.func_71410_x().field_71474_y.field_74351_w.func_151463_i());
      case 1:
         return this.keyDown(Minecraft.func_71410_x().field_71474_y.field_74368_y.func_151463_i());
      case 2:
         return this.keyDown(Minecraft.func_71410_x().field_71474_y.field_74370_x.func_151463_i());
      case 3:
         return this.keyDown(Minecraft.func_71410_x().field_71474_y.field_74366_z.func_151463_i());
      case 4:
         return this.keyDown(Minecraft.func_71410_x().field_71474_y.field_74314_A.func_151463_i());
      default:
         return false;
      }
   }

   public boolean keyDown(int keyCode) {
      boolean state = keyCode < 0 ? Mouse.isButtonDown(keyCode + 100) : Keyboard.isKeyDown(keyCode);
      return state;
   }

   public void spawnParticle(String s, double x, double y, double z, double mx, double my, double mz) {
      try {
         doSpawnParticle(s, x, y, z, mx, my, mz);
      } catch (Throwable var15) {
         var15.printStackTrace();
      }

   }

   private static EntityFX doSpawnParticle(String p_72726_1_, double p_72726_2_, double p_72726_4_, double p_72726_6_, double p_72726_8_, double p_72726_10_, double p_72726_12_) {
      Minecraft mc = Minecraft.func_71410_x();
      World theWorld = mc.field_71441_e;
      if (mc != null && mc.field_71451_h != null && mc.field_71452_i != null) {
         int i = mc.field_71474_y.field_74362_aa;
         if (i == 1 && theWorld.field_73012_v.nextInt(3) == 0) {
            i = 2;
         }

         double d6 = mc.field_71451_h.field_70165_t - p_72726_2_;
         double d7 = mc.field_71451_h.field_70163_u - p_72726_4_;
         double d8 = mc.field_71451_h.field_70161_v - p_72726_6_;
         EntityFX entityfx = null;
         if (p_72726_1_.equals("hugeexplosion")) {
            mc.field_71452_i.func_78873_a((EntityFX)(entityfx = new EntityHugeExplodeFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_)));
         } else if (p_72726_1_.equals("largeexplode")) {
            mc.field_71452_i.func_78873_a((EntityFX)(entityfx = new EntityLargeExplodeFX(mc.field_71446_o, theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_)));
         } else if (p_72726_1_.equals("fireworksSpark")) {
            mc.field_71452_i.func_78873_a((EntityFX)(entityfx = new EntityFireworkSparkFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, mc.field_71452_i)));
         }

         if (entityfx != null) {
            return (EntityFX)entityfx;
         } else {
            double d9 = 160.0D;
            if (d6 * d6 + d7 * d7 + d8 * d8 > d9 * d9) {
               return null;
            } else if (i > 1) {
               return null;
            } else {
               if (p_72726_1_.equals("flansmod.flare")) {
                  entityfx = new EntityFlare(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               }

               if (p_72726_1_.equals("flansmod.smokeShell")) {
                  entityfx = new EntitySmokeShell(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               }

               if (p_72726_1_.equals("flansmod.gunSmoke")) {
                  entityfx = new EntitySmallSmoke(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               }

               if (p_72726_1_.equals("flansmod.blood")) {
                  entityfx = new Entityblood(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               }

               if (p_72726_1_.equals("flansmod.FMNuke")) {
                  entityfx = new EntityFMNuke(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               }

               if (p_72726_1_.equals("flansmod.shipDeath")) {
                  entityfx = new EntityshipDeath(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               }

               if (p_72726_1_.equals("flansmod.tankDeath")) {
                  entityfx = new EntitytankDeath(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               }

               if (p_72726_1_.equals("flansmod.smoker")) {
                  entityfx = new EntitySmokeGrenade(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               }

               if (p_72726_1_.equals("flansmod.flash")) {
                  entityfx = new EntityFlash(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               }

               if (p_72726_1_.equals("flansmod.smokeburst")) {
                  entityfx = new EntitySmokeBurst(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               }

               if (p_72726_1_.equals("flansmod.bigsmoke")) {
                  entityfx = new EntityBigSmoke(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               }

               if (p_72726_1_.equals("flansmod.debris1")) {
                  entityfx = new EntityDebris1(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               }

               if (p_72726_1_.equals("flansmod.fmflame")) {
                  entityfx = new EntityFMFlame(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               }

               if (p_72726_1_.equals("flansmod.fmtracer")) {
                  entityfx = new EntityFMTracer(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               }

               if (p_72726_1_.equals("flansmod.fmtracergreen")) {
                  entityfx = new EntityFMTracerGreen(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               }

               if (p_72726_1_.equals("flansmod.fmtracerred")) {
                  entityfx = new EntityFMTracerRed(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               }

               if (p_72726_1_.equals("flansmod.afterburn")) {
                  entityfx = new EntityAfterburn(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               }

               if (p_72726_1_.equals("flansmod.fmsmoke")) {
                  entityfx = new EntityFMSmoke(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               }

               if (p_72726_1_.equals("flansmod.rocketexhaust")) {
                  entityfx = new EntityRocketexhaust(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               }

               if (p_72726_1_.equals("bubble")) {
                  entityfx = new EntityBubbleFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if (p_72726_1_.equals("suspended")) {
                  entityfx = new EntitySuspendFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if (p_72726_1_.equals("depthsuspend")) {
                  entityfx = new EntityAuraFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if (p_72726_1_.equals("townaura")) {
                  entityfx = new EntityAuraFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if (p_72726_1_.equals("crit")) {
                  entityfx = new EntityCritFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if (p_72726_1_.equals("magicCrit")) {
                  entityfx = new EntityCritFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
                  ((EntityFX)entityfx).func_70538_b(((EntityFX)entityfx).func_70534_d() * 0.3F, ((EntityFX)entityfx).func_70542_f() * 0.8F, ((EntityFX)entityfx).func_70535_g());
                  ((EntityFX)entityfx).func_94053_h();
               } else if (p_72726_1_.equals("smoke")) {
                  entityfx = new EntitySmokeFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if (p_72726_1_.equals("mobSpell")) {
                  entityfx = new EntitySpellParticleFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, 0.0D, 0.0D, 0.0D);
                  ((EntityFX)entityfx).func_70538_b((float)p_72726_8_, (float)p_72726_10_, (float)p_72726_12_);
               } else if (p_72726_1_.equals("mobSpellAmbient")) {
                  entityfx = new EntitySpellParticleFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, 0.0D, 0.0D, 0.0D);
                  ((EntityFX)entityfx).func_82338_g(0.15F);
                  ((EntityFX)entityfx).func_70538_b((float)p_72726_8_, (float)p_72726_10_, (float)p_72726_12_);
               } else if (p_72726_1_.equals("spell")) {
                  entityfx = new EntitySpellParticleFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if (p_72726_1_.equals("instantSpell")) {
                  entityfx = new EntitySpellParticleFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
                  ((EntitySpellParticleFX)entityfx).func_70589_b(144);
               } else if (p_72726_1_.equals("witchMagic")) {
                  entityfx = new EntitySpellParticleFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
                  ((EntitySpellParticleFX)entityfx).func_70589_b(144);
                  float f = theWorld.field_73012_v.nextFloat() * 0.5F + 0.35F;
                  ((EntityFX)entityfx).func_70538_b(1.0F * f, 0.0F * f, 1.0F * f);
               } else if (p_72726_1_.equals("note")) {
                  entityfx = new EntityNoteFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if (p_72726_1_.equals("portal")) {
                  entityfx = new EntityPortalFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if (p_72726_1_.equals("enchantmenttable")) {
                  entityfx = new EntityEnchantmentTableParticleFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if (p_72726_1_.equals("explode")) {
                  entityfx = new EntityExplodeFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if (p_72726_1_.equals("flame")) {
                  entityfx = new EntityFlameFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if (p_72726_1_.equals("lava")) {
                  entityfx = new EntityLavaFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_);
               } else if (p_72726_1_.equals("footstep")) {
                  entityfx = new EntityFootStepFX(mc.field_71446_o, theWorld, p_72726_2_, p_72726_4_, p_72726_6_);
               } else if (p_72726_1_.equals("splash")) {
                  entityfx = new EntitySplashFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if (p_72726_1_.equals("wake")) {
                  entityfx = new EntityFishWakeFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if (p_72726_1_.equals("largesmoke")) {
                  entityfx = new EntitySmokeFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, 2.5F);
               } else if (p_72726_1_.equals("cloud")) {
                  entityfx = new EntityCloudFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if (p_72726_1_.equals("reddust")) {
                  entityfx = new EntityReddustFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, (float)p_72726_8_, (float)p_72726_10_, (float)p_72726_12_);
               } else if (p_72726_1_.equals("snowballpoof")) {
                  entityfx = new EntityBreakingFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, Items.field_151126_ay);
               } else if (p_72726_1_.equals("dripWater")) {
                  entityfx = new EntityDropParticleFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, Material.field_151586_h);
               } else if (p_72726_1_.equals("dripLava")) {
                  entityfx = new EntityDropParticleFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, Material.field_151587_i);
               } else if (p_72726_1_.equals("snowshovel")) {
                  entityfx = new EntitySnowShovelFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if (p_72726_1_.equals("slime")) {
                  entityfx = new EntityBreakingFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, Items.field_151123_aH);
               } else if (p_72726_1_.equals("heart")) {
                  entityfx = new EntityHeartFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if (p_72726_1_.equals("angryVillager")) {
                  entityfx = new EntityHeartFX(theWorld, p_72726_2_, p_72726_4_ + 0.5D, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
                  ((EntityFX)entityfx).func_70536_a(81);
                  ((EntityFX)entityfx).func_70538_b(1.0F, 1.0F, 1.0F);
               } else if (p_72726_1_.equals("happyVillager")) {
                  entityfx = new EntityAuraFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
                  ((EntityFX)entityfx).func_70536_a(82);
                  ((EntityFX)entityfx).func_70538_b(1.0F, 1.0F, 1.0F);
               } else {
                  String[] astring;
                  int k;
                  if (p_72726_1_.startsWith("iconcrack_")) {
                     astring = p_72726_1_.split("_", 3);
                     int j = Integer.parseInt(astring[1]);
                     if (astring.length > 2) {
                        k = Integer.parseInt(astring[2]);
                        entityfx = new EntityBreakingFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, Item.func_150899_d(j), k);
                     } else {
                        entityfx = new EntityBreakingFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, Item.func_150899_d(j), 0);
                     }
                  } else {
                     Block block;
                     if (p_72726_1_.startsWith("blockcrack_")) {
                        astring = p_72726_1_.split("_", 3);
                        block = Block.func_149729_e(Integer.parseInt(astring[1]));
                        k = Integer.parseInt(astring[2]);
                        entityfx = (new EntityDiggingFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, block, k)).func_90019_g(k);
                     } else if (p_72726_1_.startsWith("blockdust_")) {
                        astring = p_72726_1_.split("_", 3);
                        block = Block.func_149729_e(Integer.parseInt(astring[1]));
                        k = Integer.parseInt(astring[2]);
                        entityfx = (new EntityBlockDustFX(theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, block, k)).func_90019_g(k);
                     }
                  }
               }

               if (entityfx != null) {
                  mc.field_71452_i.func_78873_a((EntityFX)entityfx);
               }

               return (EntityFX)entityfx;
            }
         }
      } else {
         return null;
      }
   }

   public float getMouseSensitivity() {
      return Minecraft.func_71410_x().field_71474_y.field_74341_c;
   }
}
