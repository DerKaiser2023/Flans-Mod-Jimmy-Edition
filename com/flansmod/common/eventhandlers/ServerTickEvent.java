package com.flansmod.common.eventhandlers;

import com.flansmod.common.guns.AttachmentType;
import com.flansmod.common.guns.ItemGun;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

public class ServerTickEvent {
   public static ArrayList<EntityPlayerMP> nightVisionPlayers = new ArrayList();
   int tickCount = 0;

   public ServerTickEvent() {
      FMLCommonHandler.instance().bus().register(this);
   }

   @SubscribeEvent
   public void tick(cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent event) {
      switch(event.phase) {
      case END:
         if (this.tickCount >= 20) {
            ArrayList<EntityPlayerMP> playersToRemove = new ArrayList();
            Iterator var3 = nightVisionPlayers.iterator();

            label46:
            while(true) {
               EntityPlayerMP player;
               AttachmentType scope;
               label44:
               do {
                  while(var3.hasNext()) {
                     player = (EntityPlayerMP)var3.next();
                     if (player.func_71045_bC() != null && player.func_71045_bC().func_77973_b() instanceof ItemGun) {
                        ItemGun itemGun = (ItemGun)player.func_71045_bC().func_77973_b();
                        ItemStack itemstack = player.func_71045_bC();
                        scope = itemGun.type.getScope(itemstack);
                        System.out.println("est");
                        continue label44;
                     }

                     player.func_82170_o(Potion.field_76439_r.field_76415_H);
                     playersToRemove.add(player);
                  }

                  this.tickCount = 0;
                  var3 = playersToRemove.iterator();

                  while(true) {
                     if (!var3.hasNext()) {
                        break label46;
                     }

                     player = (EntityPlayerMP)var3.next();
                     nightVisionPlayers.remove(player);
                  }
               } while(scope != null && (scope == null || scope.hasNightVision));

               player.func_82170_o(Potion.field_76439_r.field_76415_H);
               playersToRemove.add(player);
            }
         }

         ++this.tickCount;
      case START:
      default:
      }
   }
}
