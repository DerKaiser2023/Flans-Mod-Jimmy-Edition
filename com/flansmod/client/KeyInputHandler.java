package com.flansmod.client;

import com.flansmod.api.IControllable;
import com.flansmod.client.gui.GuiTeamScores;
import com.flansmod.client.gui.GuiTeamSelect;
import com.flansmod.common.FlansMod;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketGunMode;
import com.flansmod.common.network.PacketReload;
import com.flansmod.common.network.PacketRequestDebug;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class KeyInputHandler {
   public static KeyBinding downKey = new KeyBinding("Down key / Gunsight", 29, "Flan's Mod");
   public static KeyBinding inventoryKey = new KeyBinding("Inventory key", 19, "Flan's Mod");
   public static KeyBinding gunKey = new KeyBinding("Docking Key", 48, "Flan's Mod");
   public static KeyBinding controlSwitchKey = new KeyBinding("Surface key / Control Switch key", 46, "Flan's Mod");
   public static KeyBinding bombKey = new KeyBinding("Undocking Key", 36, "Flan's Mod");
   public static KeyBinding reloadKey = new KeyBinding("Reload key", 19, "Flan's Mod");
   public static KeyBinding gunModeKey = new KeyBinding("Gun Mode", 33, "Flan's Mod");
   public static KeyBinding teamsMenuKey = new KeyBinding("Teams Menu Key", 34, "Flan's Mod");
   public static KeyBinding teamsScoresKey = new KeyBinding("Teams Scores Key", 35, "Flan's Mod");
   public static KeyBinding leftRollKey = new KeyBinding("Roll Left / Turret Lock", 44, "Flan's Mod");
   public static KeyBinding rightRollKey = new KeyBinding("Roll Right / Turret Unlock", 45, "Flan's Mod");
   public static KeyBinding gearKey = new KeyBinding("Gear Up / Down Key", 38, "Flan's Mod");
   public static KeyBinding doorKey = new KeyBinding("Radar Range / Door Toggle Key", 37, "Flan's Mod");
   public static KeyBinding modeKey = new KeyBinding("Dive Key", 47, "Flan's Mod");
   public static KeyBinding flareKey = new KeyBinding("Flare Key", 49, "Flan's Mod");
   public static KeyBinding debugKey = new KeyBinding("Debug Key", 68, "Flan's Mod");
   public static KeyBinding reloadModelsKey = new KeyBinding("Reload Models Key", 67, "Flan's Mod");
   public static KeyBinding secondaryKey = new KeyBinding("Select Gun Underbarrel", 37, "Flan's Mod");
   Minecraft mc;

   public KeyInputHandler() {
      ClientRegistry.registerKeyBinding(downKey);
      ClientRegistry.registerKeyBinding(inventoryKey);
      ClientRegistry.registerKeyBinding(gunKey);
      ClientRegistry.registerKeyBinding(controlSwitchKey);
      ClientRegistry.registerKeyBinding(bombKey);
      ClientRegistry.registerKeyBinding(reloadKey);
      ClientRegistry.registerKeyBinding(gunModeKey);
      ClientRegistry.registerKeyBinding(teamsMenuKey);
      ClientRegistry.registerKeyBinding(teamsScoresKey);
      ClientRegistry.registerKeyBinding(leftRollKey);
      ClientRegistry.registerKeyBinding(rightRollKey);
      ClientRegistry.registerKeyBinding(gearKey);
      ClientRegistry.registerKeyBinding(doorKey);
      ClientRegistry.registerKeyBinding(modeKey);
      ClientRegistry.registerKeyBinding(flareKey);
      ClientRegistry.registerKeyBinding(debugKey);
      ClientRegistry.registerKeyBinding(reloadModelsKey);
      ClientRegistry.registerKeyBinding(secondaryKey);
      this.mc = Minecraft.func_71410_x();
   }

   @SubscribeEvent
   public void onKeyInput(KeyInputEvent event) {
      if (!FMLClientHandler.instance().isGUIOpen(GuiChat.class) && this.mc.field_71462_r == null) {
         EntityPlayer player = this.mc.field_71439_g;
         Entity ridingEntity = player.field_70154_o;
         if (teamsMenuKey.func_151468_f()) {
            this.mc.func_147108_a(new GuiTeamSelect());
         } else if (teamsScoresKey.func_151468_f()) {
            this.mc.func_147108_a(new GuiTeamScores());
         } else if (reloadKey.func_151468_f() && FlansModClient.shootTime(false) <= 0) {
            FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketReload(false)));
         } else if (gunModeKey.func_151468_f()) {
            FlansMod.getPacketHandler().sendToServer((PacketBase)(new PacketGunMode(1)));
         } else {
            if (debugKey.func_151468_f()) {
               if (FlansMod.DEBUG) {
                  FlansMod.DEBUG = false;
               } else {
                  FlansMod.packetHandler.sendToServer((PacketBase)(new PacketRequestDebug()));
               }
            }

            if (reloadModelsKey.func_151468_f()) {
               FlansModClient.reloadModels(Keyboard.isKeyDown(42));
            }

            if (ridingEntity instanceof IControllable) {
               IControllable riding = (IControllable)ridingEntity;
               if (this.mc.field_71474_y.field_74351_w.func_151468_f()) {
                  riding.pressKey(0, player);
               }

               if (this.mc.field_71474_y.field_74368_y.func_151468_f()) {
                  riding.pressKey(1, player);
               }

               if (this.mc.field_71474_y.field_74370_x.func_151468_f()) {
                  riding.pressKey(2, player);
               }

               if (this.mc.field_71474_y.field_74366_z.func_151468_f()) {
                  riding.pressKey(3, player);
               }

               if (this.mc.field_71474_y.field_74314_A.func_151468_f()) {
                  riding.pressKey(4, player);
               }

               if (downKey.func_151468_f()) {
                  riding.pressKey(5, player);
               }

               if (this.mc.field_71474_y.field_74311_E.func_151468_f()) {
                  riding.pressKey(6, player);
               }

               if (this.mc.field_71474_y.field_151445_Q.func_151468_f() || inventoryKey.func_151468_f()) {
                  riding.pressKey(7, player);
               }

               if (bombKey.func_151468_f()) {
                  riding.pressKey(8, player);
               }

               if (gunKey.func_151468_f()) {
                  riding.pressKey(9, player);
               }

               if (controlSwitchKey.func_151468_f()) {
                  riding.pressKey(10, player);
               }

               if (leftRollKey.func_151468_f()) {
                  riding.pressKey(11, player);
               }

               if (rightRollKey.func_151468_f()) {
                  riding.pressKey(12, player);
               }

               if (gearKey.func_151468_f()) {
                  riding.pressKey(13, player);
               }

               if (doorKey.func_151468_f()) {
                  riding.pressKey(14, player);
               }

               if (modeKey.func_151468_f()) {
                  riding.pressKey(15, player);
               }

               riding.pressKey(16, player);
               if (flareKey.func_151468_f()) {
                  riding.pressKey(18, player);
               }
            }

         }
      }
   }
}
