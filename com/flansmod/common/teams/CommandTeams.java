package com.flansmod.common.teams;

import com.flansmod.common.FlansMod;
import java.util.Iterator;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class CommandTeams extends CommandBase {
   public static TeamsManager teamsManager = TeamsManager.getInstance();

   public String func_71517_b() {
      return "teams";
   }

   public void func_71515_b(ICommandSender sender, String[] split) {
      if (teamsManager == null) {
         sender.func_145747_a(new ChatComponentText("Teams mod is broken. You will need to look at the server side logs to see what's wrong"));
      } else if (split != null && split.length != 0 && !split[0].equals("help") && !split[0].equals("?")) {
         TeamsManager var10000;
         if (split[0].equals("off")) {
            teamsManager.currentRound = null;
            var10000 = teamsManager;
            TeamsManager.enabled = false;
            TeamsManager.messageAll("Flan's Teams Mod disabled");
         } else if (split[0].equals("on")) {
            var10000 = teamsManager;
            TeamsManager.enabled = true;
            TeamsManager.messageAll("Flan's Teams Mod enabled");
         } else {
            var10000 = teamsManager;
            if (!TeamsManager.enabled) {
               sender.func_145747_a(new ChatComponentText("Teams mod is disabled. Try /teams on"));
            } else if (split[0].equals("survival")) {
               var10000 = teamsManager;
               TeamsManager.explosions = true;
               var10000 = teamsManager;
               TeamsManager.driveablesBreakBlocks = true;
               var10000 = teamsManager;
               TeamsManager.bombsEnabled = true;
               var10000 = teamsManager;
               TeamsManager.bulletsEnabled = true;
               var10000 = teamsManager;
               TeamsManager.forceAdventureMode = false;
               var10000 = teamsManager;
               TeamsManager.overrideHunger = false;
               var10000 = teamsManager;
               TeamsManager.canBreakGuns = true;
               var10000 = teamsManager;
               TeamsManager.canBreakGlass = true;
               var10000 = teamsManager;
               TeamsManager.armourDrops = true;
               var10000 = teamsManager;
               TeamsManager.weaponDrops = 1;
               var10000 = teamsManager;
               TeamsManager.vehiclesNeedFuel = true;
               var10000 = teamsManager;
               var10000 = teamsManager;
               var10000 = teamsManager;
               var10000 = teamsManager;
               var10000 = teamsManager;
               TeamsManager.mechaLove = 0;
               TeamsManager.aaLife = 0;
               TeamsManager.vehicleLife = 0;
               TeamsManager.planeLife = 0;
               TeamsManager.mgLife = 0;
               var10000 = teamsManager;
               TeamsManager.messageAll("Flan's Mod switching to survival presets");
            } else if (split[0].equals("arena")) {
               var10000 = teamsManager;
               TeamsManager.explosions = false;
               var10000 = teamsManager;
               TeamsManager.driveablesBreakBlocks = false;
               var10000 = teamsManager;
               TeamsManager.bombsEnabled = true;
               var10000 = teamsManager;
               TeamsManager.bulletsEnabled = true;
               var10000 = teamsManager;
               TeamsManager.forceAdventureMode = true;
               var10000 = teamsManager;
               TeamsManager.overrideHunger = true;
               var10000 = teamsManager;
               TeamsManager.canBreakGuns = true;
               var10000 = teamsManager;
               TeamsManager.canBreakGlass = false;
               var10000 = teamsManager;
               TeamsManager.armourDrops = false;
               var10000 = teamsManager;
               TeamsManager.weaponDrops = 2;
               var10000 = teamsManager;
               TeamsManager.vehiclesNeedFuel = false;
               var10000 = teamsManager;
               var10000 = teamsManager;
               var10000 = teamsManager;
               var10000 = teamsManager;
               var10000 = teamsManager;
               TeamsManager.mechaLove = 120;
               TeamsManager.aaLife = 120;
               TeamsManager.vehicleLife = 120;
               TeamsManager.planeLife = 120;
               TeamsManager.mgLife = 120;
               TeamsManager.messageAll("Flan's Mod switching to arena mode presets");
            } else {
               Iterator var3;
               Gametype gametype;
               if (split[0].equals("listGametypes")) {
                  sender.func_145747_a(new ChatComponentText("§2Showing all avaliable gametypes"));
                  sender.func_145747_a(new ChatComponentText("§2To pick a gametype, use \"/teams setGametype <gametype>\" with the name in brackets"));
                  var3 = Gametype.gametypes.values().iterator();

                  while(var3.hasNext()) {
                     gametype = (Gametype)var3.next();
                     sender.func_145747_a(new ChatComponentText("§f" + gametype.name + " (" + gametype.shortName + ")"));
                  }

               } else if (split[0].equals("listMaps")) {
                  if (teamsManager.maps == null) {
                     sender.func_145747_a(new ChatComponentText("The map list is null"));
                  } else {
                     sender.func_145747_a(new ChatComponentText("§2Listing maps"));
                     var3 = teamsManager.maps.values().iterator();

                     while(var3.hasNext()) {
                        TeamsMap map = (TeamsMap)var3.next();
                        sender.func_145747_a(new ChatComponentText((teamsManager.currentRound != null && map == teamsManager.currentRound.map ? "§4" : "") + map.name + " (" + map.shortName + ")"));
                     }

                  }
               } else if (split[0].equals("addMap")) {
                  if (split.length < 3) {
                     sender.func_145747_a(new ChatComponentText("You need to specify a map name"));
                  } else {
                     String shortName = split[1];
                     String name = split[2];

                     for(int i = 3; i < split.length; ++i) {
                        name = name + " " + split[i];
                     }

                     teamsManager.maps.put(shortName, new TeamsMap(sender.func_130014_f_(), shortName, name));
                     sender.func_145747_a(new ChatComponentText("Added new map : " + name + " (" + shortName + ")"));
                  }
               } else if (split[0].equals("removeMap")) {
                  if (split.length != 2) {
                     sender.func_145747_a(new ChatComponentText("You need to specify a map's short name"));
                  } else {
                     if (teamsManager.maps.containsKey(split[1])) {
                        teamsManager.maps.remove(split[1]);
                        sender.func_145747_a(new ChatComponentText("Removed map " + split[1]));
                     } else {
                        sender.func_145747_a(new ChatComponentText("Map (" + split[1] + ") not found"));
                     }

                  }
               } else if (split[0].equals("setRound")) {
                  if (split.length != 2) {
                     sender.func_145747_a(new ChatComponentText("You need to specify the round index (see /teams listRounds)"));
                  } else {
                     TeamsRound round = (TeamsRound)teamsManager.rounds.get(Integer.parseInt(split[1]));
                     if (round != null) {
                        teamsManager.nextRound = round;
                        TeamsManager.messageAll("§2Next round will be " + round.gametype.shortName + " in " + round.map.name);
                     }

                  }
               } else if (!split[0].equals("listTeams") && !split[0].equals("listAllTeams")) {
                  if (!split[0].equals("getSticks") && !split[0].equals("getOpSticks") && !split[0].equals("getOpKit")) {
                     if (split[0].toLowerCase().equals("autobalance")) {
                        if (split.length != 2) {
                           sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <true/false>"));
                        } else {
                           TeamsManager.autoBalance = Boolean.parseBoolean(split[1]);
                           sender.func_145747_a(new ChatComponentText("Autobalance is now " + (TeamsManager.autoBalance ? "enabled" : "disabled")));
                        }
                     } else if (split[0].equals("useRotation")) {
                        if (split.length != 2) {
                           sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <true/false>"));
                        } else {
                           TeamsManager.voting = !Boolean.parseBoolean(split[1]);
                           sender.func_145747_a(new ChatComponentText("Voting is now " + (TeamsManager.voting ? "enabled" : "disabled")));
                        }
                     } else if (split[0].equals("voting")) {
                        if (split.length != 2) {
                           sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <true/false>"));
                        } else {
                           TeamsManager.voting = Boolean.parseBoolean(split[1]);
                           sender.func_145747_a(new ChatComponentText("Voting is now " + (TeamsManager.voting ? "enabled" : "disabled")));
                        }
                     } else {
                        int i;
                        int bmn;
                        if (!split[0].equals("listRounds") && !split[0].equals("listRotation")) {
                           if (!split[0].equals("removeRound") && !split[0].equals("removeMapFromRotation") && !split[0].equals("removeFromRotation") && !split[0].equals("removeRotation")) {
                              if (!split[0].equals("addMapToRotation") && !split[0].equals("addToRotation") && !split[0].equals("addRotation") && !split[0].equals("addRound")) {
                                 if (!split[0].equals("start") && !split[0].equals("begin")) {
                                    if (!split[0].equals("nextMap") && !split[0].equals("next") && !split[0].equals("nextRound")) {
                                       if (!split[0].equals("forceAdventure") && !split[0].equals("forceAdventureMode")) {
                                          if (!split[0].equals("overrideHunger") && !split[0].equals("noHunger")) {
                                             if (split[0].equals("explosions")) {
                                                if (split.length != 2) {
                                                   sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <true/false>"));
                                                } else {
                                                   TeamsManager.explosions = Boolean.parseBoolean(split[1]);
                                                   sender.func_145747_a(new ChatComponentText("Expolsions are now " + (TeamsManager.explosions ? "enabled" : "disabled")));
                                                }
                                             } else if (!split[0].equals("bombs") && !split[0].equals("allowBombs")) {
                                                if (!split[0].equals("bullets") && !split[0].equals("bulletsEnabled")) {
                                                   if (split[0].equals("canBreakGuns")) {
                                                      if (split.length != 2) {
                                                         sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <true/false>"));
                                                      } else {
                                                         TeamsManager.canBreakGuns = Boolean.parseBoolean(split[1]);
                                                         sender.func_145747_a(new ChatComponentText("AAGuns and MGs can " + (TeamsManager.canBreakGuns ? "now" : "no longer") + " be broken"));
                                                      }
                                                   } else if (split[0].equals("canBreakGlass")) {
                                                      if (split.length != 2) {
                                                         sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <true/false>"));
                                                      } else {
                                                         TeamsManager.canBreakGlass = Boolean.parseBoolean(split[1]);
                                                         sender.func_145747_a(new ChatComponentText("Glass and glowstone can " + (TeamsManager.canBreakGlass ? "now" : "no longer") + " be broken"));
                                                      }
                                                   } else if (!split[0].equals("armourDrops") && !split[0].equals("armorDrops")) {
                                                      if (split[0].equals("weaponDrops")) {
                                                         if (split.length != 2) {
                                                            sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <on/off/smart>"));
                                                         } else {
                                                            if (split[1].toLowerCase().equals("on")) {
                                                               TeamsManager.weaponDrops = 1;
                                                               sender.func_145747_a(new ChatComponentText("Weapons will be dropped normally"));
                                                            } else if (split[1].toLowerCase().equals("off")) {
                                                               TeamsManager.weaponDrops = 0;
                                                               sender.func_145747_a(new ChatComponentText("Weapons will be not be dropped"));
                                                            } else if (split[1].toLowerCase().equals("smart")) {
                                                               TeamsManager.weaponDrops = 2;
                                                               sender.func_145747_a(new ChatComponentText("Smart drops enabled"));
                                                            }

                                                         }
                                                      } else if (split[0].equals("fuelNeeded")) {
                                                         if (split.length != 2) {
                                                            sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <true/false>"));
                                                         } else {
                                                            TeamsManager.vehiclesNeedFuel = Boolean.parseBoolean(split[1]);
                                                            sender.func_145747_a(new ChatComponentText("Vehicles will " + (TeamsManager.vehiclesNeedFuel ? "now" : "no longer") + " require fuel"));
                                                         }
                                                      } else if (split[0].equals("mgLife")) {
                                                         if (split.length != 2) {
                                                            sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <time>"));
                                                         } else {
                                                            TeamsManager.mgLife = Integer.parseInt(split[1]);
                                                            if (TeamsManager.mgLife > 0) {
                                                               sender.func_145747_a(new ChatComponentText("MGs will despawn after " + TeamsManager.mgLife + " seconds"));
                                                            } else {
                                                               sender.func_145747_a(new ChatComponentText("MGs will not despawn"));
                                                            }

                                                         }
                                                      } else if (split[0].equals("planeLife")) {
                                                         if (split.length != 2) {
                                                            sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <time>"));
                                                         } else {
                                                            TeamsManager.planeLife = Integer.parseInt(split[1]);
                                                            if (TeamsManager.planeLife > 0) {
                                                               sender.func_145747_a(new ChatComponentText("Planes will despawn after " + TeamsManager.planeLife + " seconds"));
                                                            } else {
                                                               sender.func_145747_a(new ChatComponentText("Planes will not despawn"));
                                                            }

                                                         }
                                                      } else if (split[0].equals("vehicleLife")) {
                                                         if (split.length != 2) {
                                                            sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <time>"));
                                                         } else {
                                                            TeamsManager.vehicleLife = Integer.parseInt(split[1]);
                                                            if (TeamsManager.vehicleLife > 0) {
                                                               sender.func_145747_a(new ChatComponentText("Vehicles will despawn after " + TeamsManager.vehicleLife + " seconds"));
                                                            } else {
                                                               sender.func_145747_a(new ChatComponentText("Vehicles will not despawn"));
                                                            }

                                                         }
                                                      } else if (split[0].equals("mechaLife")) {
                                                         if (split.length != 2) {
                                                            sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <time>"));
                                                         } else {
                                                            TeamsManager.mechaLove = Integer.parseInt(split[1]);
                                                            if (TeamsManager.mechaLove > 0) {
                                                               sender.func_145747_a(new ChatComponentText("Mechas will despawn after " + TeamsManager.mechaLove + " seconds"));
                                                            } else {
                                                               sender.func_145747_a(new ChatComponentText("Mechas will not despawn"));
                                                            }

                                                         }
                                                      } else if (split[0].equals("aaLife")) {
                                                         if (split.length != 2) {
                                                            sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <time>"));
                                                         } else {
                                                            TeamsManager.aaLife = Integer.parseInt(split[1]);
                                                            if (TeamsManager.aaLife > 0) {
                                                               sender.func_145747_a(new ChatComponentText("AA Guns will despawn after " + TeamsManager.aaLife + " seconds"));
                                                            } else {
                                                               sender.func_145747_a(new ChatComponentText("AA Guns will not despawn"));
                                                            }

                                                         }
                                                      } else if (split[0].equals("vehiclesBreakBlocks")) {
                                                         if (split.length != 2) {
                                                            sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <true/false>"));
                                                         } else {
                                                            TeamsManager.driveablesBreakBlocks = Boolean.parseBoolean(split[1]);
                                                            sender.func_145747_a(new ChatComponentText("Vehicles will " + (TeamsManager.driveablesBreakBlocks ? "now" : "no longer") + " break blocks"));
                                                         }
                                                      } else if (split[0].equals("vehiclesCanZoom") && split.length != 2) {
                                                         sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <true/false>"));
                                                      } else if (split[0].equals("scoreDisplayTime")) {
                                                         if (split.length != 2) {
                                                            sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <time>"));
                                                         } else {
                                                            TeamsManager.scoreDisplayTime = Integer.parseInt(split[1]) * 20;
                                                            sender.func_145747_a(new ChatComponentText("Score summary menu will appear for " + TeamsManager.scoreDisplayTime / 20 + " seconds"));
                                                         }
                                                      } else if (split[0].equals("votingTime")) {
                                                         if (split.length != 2) {
                                                            sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <time>"));
                                                         } else {
                                                            TeamsManager.votingTime = Integer.parseInt(split[1]) * 20;
                                                            sender.func_145747_a(new ChatComponentText("Voting menu will appear for " + TeamsManager.votingTime / 20 + " seconds"));
                                                         }
                                                      } else if (split[0].toLowerCase().equals("autobalancetime")) {
                                                         if (split.length != 2) {
                                                            sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <time>"));
                                                         } else {
                                                            TeamsManager.autoBalanceInterval = Integer.parseInt(split[1]) * 20;
                                                            sender.func_145747_a(new ChatComponentText("Autobalance will now occur every " + TeamsManager.autoBalanceInterval / 20 + " seconds"));
                                                         }
                                                      } else if (split[0].equals("setVariable")) {
                                                         if (TeamsManager.getInstance().currentRound == null) {
                                                            sender.func_145747_a(new ChatComponentText("There is no gametype to set variables for"));
                                                         } else if (split.length != 3) {
                                                            sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams setVariable <variable> <value>"));
                                                         } else {
                                                            if (TeamsManager.getInstance().currentRound.gametype.setVariable(split[1], split[2])) {
                                                               sender.func_145747_a(new ChatComponentText("Set variable " + split[1] + " in gametype " + TeamsManager.getInstance().currentRound.gametype.shortName + " to " + split[2]));
                                                            } else {
                                                               sender.func_145747_a(new ChatComponentText("Variable " + split[1] + " did not exist in gametype " + TeamsManager.getInstance().currentRound.gametype.shortName));
                                                            }

                                                         }
                                                      } else {
                                                         int bdv;
                                                         if (split[0].equals("ping")) {
                                                            bmn = 0;
                                                            bdv = 0;
                                                            List<EntityPlayer> list = TeamsManager.getPlayers();
                                                            Iterator var17 = list.iterator();

                                                            while(var17.hasNext()) {
                                                               EntityPlayer player = (EntityPlayer)var17.next();
                                                               if (player instanceof EntityPlayerMP) {
                                                                  EntityPlayerMP pm = (EntityPlayerMP)player;
                                                                  sender.func_145747_a(new ChatComponentText("[Ping] " + pm.field_71138_i + " : " + pm.getDisplayName()));
                                                                  if (pm.field_71138_i > 0) {
                                                                     bmn += pm.field_71138_i;
                                                                     ++bdv;
                                                                  }
                                                               }
                                                            }

                                                            if (bdv > 0) {
                                                               sender.func_145747_a(new ChatComponentText("[PingAverage] " + String.format("%.1f", (double)bmn / (double)bdv)));
                                                            }

                                                         } else if (split[0].equals("bltss")) {
                                                            if (split.length != 3) {
                                                               sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams bltss <0 ... 100> <0 ... 1000>"));
                                                               sender.func_145747_a(new ChatComponentText("Bullet use player snapshot = Min[default=0] + (Ping / Divisor[default=50])"));
                                                            } else {
                                                               bmn = Integer.parseInt(split[1]);
                                                               bdv = Integer.parseInt(split[2]);
                                                               if (bmn < 0) {
                                                                  bmn = 0;
                                                               }

                                                               if (bmn > 100) {
                                                                  bmn = 100;
                                                               }

                                                               if (bdv < 0) {
                                                                  bdv = 0;
                                                               }

                                                               if (bdv > 1000) {
                                                                  bdv = 1000;
                                                               }

                                                               sender.func_145747_a(new ChatComponentText("[BulletDelay] Min=" + bmn + " : Divisor=" + bdv));
                                                            }
                                                         } else {
                                                            sender.func_145747_a(new ChatComponentText(split[0] + " is not a valid teams command. Try /teams help"));
                                                         }
                                                      }
                                                   } else if (split.length != 2) {
                                                      sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <true/false>"));
                                                   } else {
                                                      TeamsManager.armourDrops = Boolean.parseBoolean(split[1]);
                                                      sender.func_145747_a(new ChatComponentText("Armour will " + (TeamsManager.armourDrops ? "now" : "no longer") + " be dropped"));
                                                   }
                                                } else if (split.length != 2) {
                                                   sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <true/false>"));
                                                } else {
                                                   TeamsManager.bulletsEnabled = Boolean.parseBoolean(split[1]);
                                                   sender.func_145747_a(new ChatComponentText("Bullets are now " + (TeamsManager.bulletsEnabled ? "enabled" : "disabled")));
                                                }
                                             } else if (split.length != 2) {
                                                sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <true/false>"));
                                             } else {
                                                TeamsManager.bombsEnabled = Boolean.parseBoolean(split[1]);
                                                sender.func_145747_a(new ChatComponentText("Bombs are now " + (TeamsManager.bombsEnabled ? "enabled" : "disabled")));
                                             }
                                          } else if (split.length != 2) {
                                             sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <true/false>"));
                                          } else {
                                             TeamsManager.overrideHunger = Boolean.parseBoolean(split[1]);
                                             sender.func_145747_a(new ChatComponentText("Players will " + (TeamsManager.overrideHunger ? "no longer" : "now") + " get hungry during rounds"));
                                          }
                                       } else if (split.length != 2) {
                                          sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <true/false>"));
                                       } else {
                                          TeamsManager.forceAdventureMode = Boolean.parseBoolean(split[1]);
                                          sender.func_145747_a(new ChatComponentText("Adventure mode will " + (TeamsManager.forceAdventureMode ? "now" : "no longer") + " be forced"));
                                       }
                                    } else {
                                       teamsManager.roundTimeLeft = 1;
                                    }
                                 } else {
                                    teamsManager.start();
                                    sender.func_145747_a(new ChatComponentText("Started teams map rotation"));
                                 }
                              } else if (split.length < 8) {
                                 sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <Map> <Gametype> <Team1> <Team2> ... <TimeLimit> <ScoreLimit> <isNextRoundOn true/false>"));
                              } else {
                                 TeamsMap map = (TeamsMap)TeamsManager.getInstance().maps.get(split[1]);
                                 if (map == null) {
                                    sender.func_145747_a(new ChatComponentText("Could not find map : " + split[1]));
                                 } else {
                                    gametype = Gametype.getGametype(split[2]);
                                    if (gametype == null) {
                                       sender.func_145747_a(new ChatComponentText("Could not find gametype : " + split[2]));
                                    } else if (split.length != 6 + gametype.numTeamsRequired) {
                                       sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <Map> <Gametype> <Team1> <Team2> ... <ScoreLimit> <TimeLimit> <isNextRoundOn true/false>"));
                                    } else {
                                       Team[] teams = new Team[gametype.numTeamsRequired];

                                       for(i = 0; i < teams.length; ++i) {
                                          teams[i] = Team.getTeam(split[3 + i]);
                                       }

                                       sender.func_145747_a(new ChatComponentText("Added map (" + map.shortName + ") to rotation"));
                                       TeamsManager.getInstance().rounds.add(new TeamsRound(map, gametype, teams, Integer.parseInt(split[3 + gametype.numTeamsRequired]), Integer.parseInt(split[4 + gametype.numTeamsRequired]), Boolean.getBoolean(split[5 + gametype.numTeamsRequired])));
                                    }
                                 }
                              }
                           } else if (split.length != 2) {
                              sender.func_145747_a(new ChatComponentText("Incorrect Usage : Should be /teams " + split[0] + " <ID>"));
                           } else {
                              bmn = Integer.parseInt(split[1]);
                              sender.func_145747_a(new ChatComponentText("Removed map " + bmn + " (" + ((TeamsRound)TeamsManager.getInstance().rounds.get(bmn)).map.shortName + ") from rotation"));
                              TeamsManager.getInstance().rounds.remove(bmn);
                           }
                        } else {
                           sender.func_145747_a(new ChatComponentText("§2Current Round List"));

                           for(bmn = 0; bmn < TeamsManager.getInstance().rounds.size(); ++bmn) {
                              TeamsRound entry = (TeamsRound)TeamsManager.getInstance().rounds.get(bmn);
                              if (entry.map == null) {
                                 sender.func_145747_a(new ChatComponentText("Round had null map"));
                                 return;
                              }

                              if (entry.gametype == null) {
                                 sender.func_145747_a(new ChatComponentText("Round had null gametype"));
                                 return;
                              }

                              String s = bmn + ". " + entry.map.shortName + ", " + entry.gametype.shortName;
                              if (entry == TeamsManager.getInstance().currentRound) {
                                 s = "§4" + s;
                              }

                              for(i = 0; i < entry.teams.length; ++i) {
                                 s = s + ", " + entry.teams[i].shortName;
                              }

                              s = s + ", " + entry.timeLimit;
                              s = s + ", " + entry.scoreLimit;
                              s = s + ", Pop : " + (int)(entry.popularity * 100.0F) + "%";
                              sender.func_145747_a(new ChatComponentText(s));
                           }

                        }
                     }
                  } else {
                     EntityPlayerMP player = this.getPlayer(sender.func_70005_c_());
                     if (player != null) {
                        player.field_71071_by.func_70441_a(new ItemStack(FlansMod.opStick, 1, 0));
                        player.field_71071_by.func_70441_a(new ItemStack(FlansMod.opStick, 1, 1));
                        player.field_71071_by.func_70441_a(new ItemStack(FlansMod.opStick, 1, 2));
                        player.field_71071_by.func_70441_a(new ItemStack(FlansMod.opStick, 1, 3));
                        sender.func_145747_a(new ChatComponentText("§2Enjoy your op sticks."));
                        sender.func_145747_a(new ChatComponentText("§7The Stick of Connecting connects objects (spawners, banners etc) to bases (flagpoles etc)"));
                        sender.func_145747_a(new ChatComponentText("§7The Stick of Ownership sets the team that currently owns a base"));
                        sender.func_145747_a(new ChatComponentText("§7The Stick of Mapping sets the map that a base is currently associated with"));
                        sender.func_145747_a(new ChatComponentText("§7The Stick of Destruction deletes bases and team objects"));
                     }

                  }
               } else if (Team.teams.size() == 0) {
                  sender.func_145747_a(new ChatComponentText("§4No teams available. You need a content pack that has some teams with it"));
               } else {
                  sender.func_145747_a(new ChatComponentText("§2Showing all avaliable teams"));
                  sender.func_145747_a(new ChatComponentText("§2To pick these teams, use /teams setTeams <team1> <team2> with the names in brackets"));
                  var3 = Team.teams.iterator();

                  while(var3.hasNext()) {
                     Team team = (Team)var3.next();
                     sender.func_145747_a(new ChatComponentText("§" + team.textColour + team.name + " (" + team.shortName + ")"));
                  }

               }
            }
         }
      } else {
         if (split.length == 2) {
            this.sendHelpInformation(sender, Integer.parseInt(split[1]));
         } else {
            this.sendHelpInformation(sender, 1);
         }

      }
   }

   public List func_71516_a(ICommandSender sender, String[] prm) {
      return prm.length <= 1 ? func_71530_a(prm, new String[]{"help", "off", "arena", "survival", "getSticks", "listGametypes", "setGametype", "listAllTeams", "listTeams", "setTeams", "addMap", "listMaps", "removeMap", "setMap", "useRotation", "voting", "addRound", "listRounds", "removeRound", "nextMap", "goToMap", "votingTime", "scoreDisplayTime", "setVariable", "forceAdventure", "overrideHunger", "explosions", "canBreakGuns", "canBreakGlass", "armourDrops", "weaponDrops", "fuelNeeded", "mgLife", "planeLife", "vehicleLife", "aaLife", "vehiclesBreakBlocks", "ping", "bltss", "showbltss", "vehiclesCanZoom"}) : null;
   }

   public void sendHelpInformation(ICommandSender sender, int page) {
      if (page <= 4 && page >= 1) {
         sender.func_145747_a(new ChatComponentText("§2Listing teams commands §f[Page " + page + " of 4]"));
         switch(page) {
         case 1:
            sender.func_145747_a(new ChatComponentText("/teams help [page]"));
            sender.func_145747_a(new ChatComponentText("/teams off"));
            sender.func_145747_a(new ChatComponentText("/teams arena"));
            sender.func_145747_a(new ChatComponentText("/teams survival"));
            sender.func_145747_a(new ChatComponentText("/teams getSticks"));
            sender.func_145747_a(new ChatComponentText("/teams listGametypes"));
            sender.func_145747_a(new ChatComponentText("/teams listTeams"));
            sender.func_145747_a(new ChatComponentText("/teams addMap <shortName> <longName>"));
            sender.func_145747_a(new ChatComponentText("/teams listMaps"));
            sender.func_145747_a(new ChatComponentText("/teams removeMap <shortName>"));
            break;
         case 2:
            sender.func_145747_a(new ChatComponentText("/teams useRotation <true / false>"));
            sender.func_145747_a(new ChatComponentText("/teams voting <true / false>"));
            sender.func_145747_a(new ChatComponentText("/teams addRound <map> <gametype> <team1> <team2> <TimeLimit> <ScoreLimit> <isNextRoundOn true/false>"));
            sender.func_145747_a(new ChatComponentText("/teams listRounds"));
            sender.func_145747_a(new ChatComponentText("/teams removeRound <ID>"));
            sender.func_145747_a(new ChatComponentText("/teams nextMap"));
            sender.func_145747_a(new ChatComponentText("/teams votingTime <time>"));
            sender.func_145747_a(new ChatComponentText("/teams scoreDisplayTime <time>"));
            break;
         case 3:
            sender.func_145747_a(new ChatComponentText("/teams setVariable <variable> <value>"));
            sender.func_145747_a(new ChatComponentText("/teams forceAdventure <true / false>"));
            sender.func_145747_a(new ChatComponentText("/teams overrideHunger <true / false>"));
            sender.func_145747_a(new ChatComponentText("/teams explosions <true / false>"));
            sender.func_145747_a(new ChatComponentText("/teams canBreakGuns <true / false>"));
            sender.func_145747_a(new ChatComponentText("/teams canBreakGlass <true / false>"));
            sender.func_145747_a(new ChatComponentText("/teams armourDrops <true / false>"));
            sender.func_145747_a(new ChatComponentText("/teams weaponDrops <off / on / smart>"));
            sender.func_145747_a(new ChatComponentText("/teams fuelNeeded <true / false>"));
            sender.func_145747_a(new ChatComponentText("/teams mgLife <time>"));
            sender.func_145747_a(new ChatComponentText("/teams planeLife <time>"));
            sender.func_145747_a(new ChatComponentText("/teams vehicleLife <time>"));
            sender.func_145747_a(new ChatComponentText("/teams aaLife <time>"));
            sender.func_145747_a(new ChatComponentText("/teams vehiclesBreakBlocks <true / false>"));
            break;
         case 4:
            sender.func_145747_a(new ChatComponentText("/teams ping <PlayerName>"));
            sender.func_145747_a(new ChatComponentText("/teams bltss <0 ... 100> <0 ... 1000>"));
            sender.func_145747_a(new ChatComponentText("/teams showbltss"));
            sender.func_145747_a(new ChatComponentText("/teams vehiclesCanZoom <true / false>"));
         }

      } else {
         ChatComponentText text = new ChatComponentText("Invalid help page, should be in the range (1-4)");
         text.func_150256_b().func_150238_a(EnumChatFormatting.RED);
         sender.func_145747_a(text);
      }
   }

   public EntityPlayerMP getPlayer(String name) {
      return MinecraftServer.func_71276_C().func_71203_ab().func_152612_a(name);
   }

   public String func_71518_a(ICommandSender icommandsender) {
      return "Try \"/teams help\"";
   }
}
