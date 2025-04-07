package com.flansmod.common.guns;

import com.flansmod.client.FlansModClient;
import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketFlak;
import com.flansmod.common.network.PacketFlashBang;
import com.flansmod.common.network.PacketPlaySound;
import com.flansmod.common.teams.ItemTeamArmour;
import com.flansmod.common.teams.Team;
import com.flansmod.common.teams.TeamsManager;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import io.netty.buffer.ByteBuf;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class EntityGrenade extends EntityShootable implements IEntityAdditionalSpawnData {
   public GrenadeType type;
   public EntityLivingBase thrower;
   public Team teamOfThrower;
   public RotatedAxes axes;
   public Vector3f angularVelocity;
   public float prevRotationRoll;
   public int smokeTime;
   public boolean smoking;
   public boolean stuck;
   public int stuckToX;
   public int stuckToY;
   public int stuckToZ;
   public boolean detonated;
   public int numUsesRemaining;
   public boolean isThisStick;
   public Entity stickedEntity;
   public int motionTime;

   public EntityGrenade(World w) {
      super(w);
      this.axes = new RotatedAxes();
      this.angularVelocity = new Vector3f(0.0F, 0.0F, 0.0F);
      this.prevRotationRoll = 0.0F;
      this.smokeTime = 0;
      this.smoking = false;
      this.stuck = false;
      this.detonated = false;
      this.numUsesRemaining = 0;
      this.isThisStick = false;
      this.motionTime = 0;
   }

   public EntityGrenade(World w, GrenadeType g, EntityLivingBase t) {
      this(w);
      this.func_70107_b(t.field_70165_t, t.field_70163_u + (double)t.func_70047_e(), t.field_70161_v);
      this.type = g;
      this.numUsesRemaining = this.type.numUses;
      this.thrower = t;
      if (this.thrower instanceof EntityPlayer && PlayerHandler.getPlayerData((EntityPlayer)this.thrower) != null) {
         this.teamOfThrower = PlayerHandler.getPlayerData((EntityPlayer)this.thrower).team;
      }

      this.func_70105_a(g.hitBoxSize, g.hitBoxSize);
      this.axes.setAngles(t.field_70177_z + 90.0F, g.spinWhenThrown ? t.field_70125_A : 0.0F, 0.0F);
      this.field_70177_z = this.field_70126_B = g.spinWhenThrown ? t.field_70177_z + 90.0F : 0.0F;
      this.field_70125_A = this.field_70127_C = t.field_70125_A;
      float speed = 0.5F * this.type.throwSpeed;
      this.field_70159_w = (double)(this.axes.getXAxis().x * speed);
      this.field_70181_x = (double)(this.axes.getXAxis().y * speed);
      this.field_70179_y = (double)(this.axes.getXAxis().z * speed);
      if (this.type.spinWhenThrown) {
         this.angularVelocity = new Vector3f(0.0F, 0.0F, 10.0F);
      }

      if (this.type.throwSound != null) {
         PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, this.type.throwSound, true);
      }

   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if (this.type == null) {
         FlansMod.log("EntityGrenade.onUpdate() Error: GrenadeType is null (" + this + ")");
         this.func_70106_y();
      } else {
         if (this.motionTime > 0) {
            --this.motionTime;
         }

         if (this.type.despawnTime > 0 && this.field_70173_aa > this.type.despawnTime) {
            this.detonated = true;
            this.func_70106_y();
         } else {
            if (this.field_70170_p.field_72995_K && this.type.trailParticles) {
               double dX = (this.field_70165_t - this.field_70169_q) / 10.0D;
               double dY = (this.field_70163_u - this.field_70167_r) / 10.0D;
               double dZ = (this.field_70161_v - this.field_70166_s) / 10.0D;

               for(int i = 0; i < 10; ++i) {
                  EntityFX particle = FlansModClient.getParticle(this.type.trailParticleType, this.field_70170_p, this.field_70169_q + dX * (double)i, this.field_70167_r + dY * (double)i, this.field_70166_s + dZ * (double)i);
                  if (particle != null && Minecraft.func_71410_x().field_71474_y.field_74347_j) {
                     particle.field_70155_l = 100.0D;
                  }
               }
            }

            List list;
            if (this.smoking) {
               FlansMod.getPacketHandler().sendToAllAround(new PacketFlak(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50, this.type.smokeParticleType), this.field_70165_t, this.field_70163_u, this.field_70161_v, 30.0F, this.field_71093_bK);
               list = this.field_70170_p.func_72872_a(EntityLivingBase.class, this.field_70121_D.func_72314_b((double)this.type.smokeRadius, (double)this.type.smokeRadius, (double)this.type.smokeRadius));
               Iterator var2 = list.iterator();

               label354:
               while(true) {
                  EntityLivingBase entity;
                  boolean smokeThem;
                  do {
                     do {
                        if (!var2.hasNext()) {
                           --this.smokeTime;
                           if (this.smokeTime == 0) {
                              this.func_70106_y();
                           }
                           break label354;
                        }

                        Object obj = var2.next();
                        entity = (EntityLivingBase)obj;
                     } while(!(entity.func_70032_d(this) < this.type.smokeRadius));

                     smokeThem = true;

                     for(int i = 0; i < 5; ++i) {
                        ItemStack stack = entity.func_71124_b(i);
                        if (stack != null && stack.func_77973_b() instanceof ItemTeamArmour && ((ItemTeamArmour)stack.func_77973_b()).type.smokeProtection) {
                           smokeThem = false;
                        }
                     }
                  } while(!smokeThem);

                  Iterator var27 = this.type.smokeEffects.iterator();

                  while(var27.hasNext()) {
                     PotionEffect effect = (PotionEffect)var27.next();
                     entity.func_70690_d(new PotionEffect(effect));
                  }
               }
            }

            List list;
            Iterator var21;
            Object obj;
            if (!this.field_70170_p.field_72995_K) {
               if (this.field_70173_aa > this.type.fuse && this.type.fuse > 0) {
                  this.detonate();
               }

               if (this.type.livingProximityTrigger > 0.0F || this.type.driveableProximityTrigger > 0.0F) {
                  label398: {
                     float checkRadius = Math.max(this.type.livingProximityTrigger, this.type.driveableProximityTrigger);
                     list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)checkRadius, (double)checkRadius, (double)checkRadius));
                     var21 = list.iterator();

                     label322:
                     do {
                        do {
                           do {
                              if (!var21.hasNext()) {
                                 break label398;
                              }

                              obj = var21.next();
                           } while(obj == this.thrower && this.field_70173_aa < 10);

                           if (obj instanceof EntityLivingBase && this.func_70032_d((Entity)obj) < this.type.livingProximityTrigger) {
                              continue label322;
                           }
                        } while(!(obj instanceof EntityDriveable) || !(this.func_70032_d((Entity)obj) < this.type.driveableProximityTrigger));

                        if (this.type.damageToTriggerer > 0.0F) {
                           ((EntityDriveable)obj).func_70097_a(this.getGrenadeDamage(), this.type.damageToTriggerer);
                        }

                        this.detonate();
                        break label398;
                     } while(TeamsManager.getInstance() != null && TeamsManager.getInstance().currentRound != null && obj instanceof EntityPlayerMP && this.thrower instanceof EntityPlayer && !TeamsManager.getInstance().currentRound.gametype.playerAttacked((EntityPlayerMP)obj, new EntityDamageSourceGun(this.type.shortName, this, (EntityPlayer)this.thrower, this.type, false)));

                     if (this.type.damageToTriggerer > 0.0F) {
                        ((EntityLivingBase)obj).func_70097_a(this.getGrenadeDamage(), this.type.damageToTriggerer);
                     }

                     this.detonate();
                  }
               }
            }

            if (this.stuck && this.field_70170_p.func_147437_c(this.stuckToX, this.stuckToY, this.stuckToZ)) {
               this.stuck = false;
            }

            Vector3f motVec;
            if (!this.stuck && !this.type.stickToThrower) {
               this.field_70126_B = this.axes.getYaw();
               this.field_70127_C = this.axes.getPitch();
               this.prevRotationRoll = this.axes.getRoll();
               if (this.angularVelocity.lengthSquared() > 1.0E-8F) {
                  this.axes.rotateLocal(this.angularVelocity.length(), this.angularVelocity.normalise((Vector3f)null));
               }

               motVec = new Vector3f(this.field_70165_t, this.field_70163_u, this.field_70161_v);
               Vector3f motVec = new Vector3f(this.field_70159_w, this.field_70181_x, this.field_70179_y);
               Vector3f nextPosVec = Vector3f.add(motVec, motVec, (Vector3f)null);
               MovingObjectPosition hit = this.field_70170_p.func_72933_a(motVec.toVec3(), nextPosVec.toVec3());
               if (hit != null && hit.field_72313_a == MovingObjectType.BLOCK) {
                  Block block = this.field_70170_p.func_147439_a(hit.field_72311_b, hit.field_72312_c, hit.field_72309_d);
                  Material mat = block.func_149688_o();
                  if (this.type.explodeOnImpact) {
                     this.detonate();
                  } else if (this.type.breaksGlass && mat == Material.field_151592_s && TeamsManager.canBreakGlass) {
                     this.field_70170_p.func_147468_f(hit.field_72311_b, hit.field_72312_c, hit.field_72309_d);
                     FlansMod.proxy.playBlockBreakSound(hit.field_72311_b, hit.field_72312_c, hit.field_72309_d, block);
                  } else if (!this.type.penetratesBlocks) {
                     Vector3f hitVec = new Vector3f(hit.field_72307_f);
                     Vector3f preHitMotVec = Vector3f.sub(hitVec, motVec, (Vector3f)null);
                     Vector3f postHitMotVec = Vector3f.sub(motVec, preHitMotVec, (Vector3f)null);
                     int sideHit = hit.field_72310_e;
                     switch(sideHit) {
                     case 0:
                     case 1:
                        postHitMotVec.setY(-postHitMotVec.getY());
                        break;
                     case 2:
                     case 3:
                        postHitMotVec.setZ(-postHitMotVec.getZ());
                        break;
                     case 4:
                     case 5:
                        postHitMotVec.setX(-postHitMotVec.getX());
                     }

                     float lambda = Math.abs(motVec.lengthSquared()) < 1.0E-8F ? 1.0F : postHitMotVec.length() / motVec.length();
                     postHitMotVec.scale(this.type.bounciness / 2.0F);
                     this.field_70165_t += (double)(preHitMotVec.x + postHitMotVec.x);
                     this.field_70163_u += (double)(preHitMotVec.y + postHitMotVec.y);
                     this.field_70161_v += (double)(preHitMotVec.z + postHitMotVec.z);
                     this.field_70159_w = (double)(postHitMotVec.x / lambda);
                     this.field_70181_x = (double)(postHitMotVec.y / lambda);
                     this.field_70179_y = (double)(postHitMotVec.z / lambda);
                     motVec = new Vector3f(this.field_70159_w, this.field_70181_x, this.field_70179_y);
                     float randomSpinner = 90.0F;
                     Vector3f.add(this.angularVelocity, new Vector3f(this.field_70146_Z.nextGaussian() * (double)randomSpinner, this.field_70146_Z.nextGaussian() * (double)randomSpinner, this.field_70146_Z.nextGaussian() * (double)randomSpinner), this.angularVelocity);
                     this.angularVelocity.scale(motVec.lengthSquared());
                     if ((double)motVec.lengthSquared() > 0.01D) {
                        this.func_85030_a(this.type.bounceSound, 1.0F, 1.2F / (this.field_70146_Z.nextFloat() * 0.2F + 0.9F));
                     }

                     if (this.type.sticky) {
                        this.field_70165_t = (double)hitVec.x;
                        this.field_70163_u = (double)hitVec.y;
                        this.field_70161_v = (double)hitVec.z;
                        this.field_70159_w = this.field_70181_x = this.field_70179_y = 0.0D;
                        this.angularVelocity.set(0.0F, 0.0F, 0.0F);
                        float yaw = this.axes.getYaw();
                        switch(hit.field_72310_e) {
                        case 0:
                           this.axes.setAngles(yaw, 180.0F, 0.0F);
                           break;
                        case 1:
                           this.axes.setAngles(yaw, 0.0F, 0.0F);
                           break;
                        case 2:
                           this.axes.setAngles(270.0F, 90.0F, 0.0F);
                           this.axes.rotateLocalYaw(yaw);
                           break;
                        case 3:
                           this.axes.setAngles(90.0F, 90.0F, 0.0F);
                           this.axes.rotateLocalYaw(yaw);
                           break;
                        case 4:
                           this.axes.setAngles(180.0F, 90.0F, 0.0F);
                           this.axes.rotateLocalYaw(yaw);
                           break;
                        case 5:
                           this.axes.setAngles(0.0F, 90.0F, 0.0F);
                           this.axes.rotateLocalYaw(yaw);
                        }

                        this.stuck = true;
                        this.stuckToX = hit.field_72311_b;
                        this.stuckToY = hit.field_72312_c;
                        this.stuckToZ = hit.field_72309_d;
                     }
                  }
               } else {
                  this.field_70165_t += this.field_70159_w;
                  this.field_70163_u += this.field_70181_x;
                  this.field_70161_v += this.field_70179_y;
               }

               this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            }

            if (this.type.stickToThrower) {
               if (this.thrower != null && !this.thrower.field_70128_L) {
                  this.func_70107_b(this.thrower.field_70165_t, this.thrower.field_70163_u, this.thrower.field_70161_v);
               } else {
                  this.func_70106_y();
               }
            }

            float yaw;
            if (this.type.stickToEntity) {
               list = this.field_70170_p.func_72839_b(this, this.field_70121_D);
               yaw = this.axes.getYaw();
               if (this.stickedEntity == null && !this.stuck) {
                  var21 = list.iterator();

                  while(var21.hasNext()) {
                     obj = var21.next();
                     if (obj instanceof Entity && obj != this.thrower && !(obj instanceof EntityGrenade)) {
                        this.stickedEntity = (Entity)obj;
                        break;
                     }
                  }
               }

               if (this.stickedEntity != null) {
                  this.func_70107_b(this.stickedEntity.field_70165_t, this.stickedEntity.field_70163_u, this.stickedEntity.field_70161_v);
                  if (this.stickedEntity.field_70128_L) {
                     this.func_70106_y();
                  }
               }
            }

            if (this.type.stickToDriveable) {
               list = this.field_70170_p.func_72839_b(this, this.field_70121_D);
               yaw = this.axes.getYaw();
               if (this.stickedEntity == null && !this.stuck) {
                  var21 = list.iterator();

                  while(var21.hasNext()) {
                     obj = var21.next();
                     if (obj instanceof Entity && obj != this.thrower && !(obj instanceof EntityGrenade) && obj instanceof EntityDriveable) {
                        this.stickedEntity = (Entity)obj;
                        break;
                     }
                  }
               }

               if (this.stickedEntity != null) {
                  this.func_70107_b(this.stickedEntity.field_70165_t, this.stickedEntity.field_70163_u, this.stickedEntity.field_70161_v);
                  if (this.stickedEntity.field_70128_L) {
                     this.func_70106_y();
                  }
               }
            }

            if (this.type.stickToEntityAfter) {
               list = this.field_70170_p.func_72839_b(this, this.field_70121_D);
               yaw = this.axes.getYaw();
               if (this.stickedEntity == null) {
                  var21 = list.iterator();

                  while(var21.hasNext()) {
                     obj = var21.next();
                     if (obj instanceof Entity && !(obj instanceof EntityGrenade) && obj != this.thrower) {
                        if (this.type.allowStickSound) {
                           PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, (double)this.type.stickSoundRange, this.field_71093_bK, this.type.stickSound, true);
                        }

                        this.stickedEntity = (Entity)obj;
                        break;
                     }
                  }
               }

               if (this.stickedEntity != null) {
                  this.func_70107_b(this.stickedEntity.field_70165_t, this.stickedEntity.field_70163_u, this.stickedEntity.field_70161_v);
                  if (this.stickedEntity.field_70128_L) {
                     this.func_70106_y();
                  }
               }
            }

            if ((this.type.damageVsLiving > 0.0F || this.type.damageVsPlayer > 0.0F) && !this.stuck) {
               motVec = new Vector3f(this.field_70159_w, this.field_70181_x, this.field_70179_y);
               list = this.field_70170_p.func_72839_b(this, this.field_70121_D);
               var21 = list.iterator();

               label221:
               while(true) {
                  do {
                     if (!var21.hasNext()) {
                        break label221;
                     }

                     obj = var21.next();
                  } while(obj == this.thrower && this.field_70173_aa < 10);

                  if (!((double)motVec.lengthSquared() < 0.01D)) {
                     if (obj instanceof EntityPlayer) {
                        ((EntityPlayer)obj).func_70097_a(this.getGrenadeDamage(), this.type.damageVsPlayer * motVec.lengthSquared() * 3.0F);
                     } else if (obj instanceof EntityLivingBase) {
                        ((EntityLivingBase)obj).func_70097_a(this.getGrenadeDamage(), this.type.damageVsLiving * motVec.lengthSquared() * 3.0F);
                     }
                  }
               }
            }

            this.field_70181_x -= 0.024525D * (double)this.type.fallSpeed;
            if (this.field_70170_p.field_72995_K) {
               this.func_70066_B();
            }

         }
      }
   }

   public boolean func_70097_a(DamageSource source, float f) {
      if (this.type.detonateWhenShot) {
         this.detonate();
      }

      return this.type.detonateWhenShot;
   }

   public void detonate() {
      if (this.field_70173_aa >= this.type.primeDelay) {
         if (!this.detonated) {
            this.detonated = true;
            PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, this.type.detonateSound, true);
            if (!this.field_70170_p.field_72995_K && this.type.explosionRadius > 0.1F) {
               if (this.thrower instanceof EntityPlayer) {
                  new FlansModExplosion(this.field_70170_p, this, (EntityPlayer)this.thrower, this.type, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.type.explosionRadius, TeamsManager.explosions && this.type.explosionBreaksBlocks, this.type.explosionDamageVsLiving, this.type.explosionDamageVsPlayer, this.type.explosionDamageVsPlane, this.type.explosionDamageVsVehicle, this.type.smokeParticleCount, this.type.debrisParticleCount);
               } else {
                  this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.type.explosionRadius, TeamsManager.explosions && this.type.explosionBreaksBlocks);
               }
            }

            if (!this.field_70170_p.field_72995_K && this.type.fireRadius > 0.1F) {
               for(float i = -this.type.fireRadius; i < this.type.fireRadius; ++i) {
                  for(float j = -this.type.fireRadius; j < this.type.fireRadius; ++j) {
                     for(float k = -this.type.fireRadius; k < this.type.fireRadius; ++k) {
                        int x = MathHelper.func_76128_c((double)i + this.field_70165_t);
                        int y = MathHelper.func_76128_c((double)j + this.field_70163_u);
                        int z = MathHelper.func_76128_c((double)k + this.field_70161_v);
                        if (i * i + j * j + k * k <= this.type.fireRadius * this.type.fireRadius && this.field_70170_p.func_147439_a(x, y, z) == Blocks.field_150350_a && this.field_70146_Z.nextBoolean()) {
                           this.field_70170_p.func_147465_d(x, y, z, Blocks.field_150480_ab, 0, 3);
                        }
                     }
                  }
               }
            }

            for(int i = 0; i < this.type.explodeParticles; ++i) {
               this.field_70170_p.func_72869_a(this.type.explodeParticleType, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70146_Z.nextGaussian(), this.field_70146_Z.nextGaussian(), this.field_70146_Z.nextGaussian());
            }

            if (!this.field_70170_p.field_72995_K && this.type.dropItemOnDetonate != null) {
               String itemName = this.type.dropItemOnDetonate;
               int damage = 0;
               if (itemName.contains(".")) {
                  damage = Integer.parseInt(itemName.split("\\.")[1]);
                  itemName = itemName.split("\\.")[0];
               }

               ItemStack dropStack = InfoType.getRecipeElement(itemName, damage);
               this.func_70099_a(dropStack, 1.0F);
            }

            if (this.type.smokeTime > 0) {
               this.smoking = true;
               this.smokeTime = this.type.smokeTime;
            } else if (!this.field_70170_p.field_72995_K) {
               this.func_70106_y();
            }

            if (this.type.flashBang && !this.field_70170_p.field_72995_K) {
               List list = this.field_70170_p.func_72872_a(EntityLivingBase.class, this.field_70121_D.func_72314_b((double)this.type.smokeRadius, (double)this.type.smokeRadius, (double)this.type.smokeRadius));
               Iterator var12 = list.iterator();

               while(var12.hasNext()) {
                  Object obj = var12.next();
                  EntityLivingBase entity = (EntityLivingBase)obj;
                  if (entity.func_70032_d(this) < (float)this.type.flashRange && this.type.flashDamageEnable) {
                     if (this.type.flashEffects) {
                        entity.func_70690_d(new PotionEffect(this.type.flashEffectsID, this.type.flashEffectsDuration, this.type.flashEffectsLevel));
                     }

                     entity.func_70097_a(this.getGrenadeDamage(), this.type.flashDamage);
                  }
               }

               FlansMod.getPacketHandler().sendToAllAround(new PacketFlak(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50, this.type.smokeParticleType), this.field_70165_t, this.field_70163_u, this.field_70161_v, 30.0F, this.field_71093_bK);
               if (this.type.flashSoundEnable) {
                  PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, (double)this.type.flashSoundRange, this.field_71093_bK, this.type.flashSound, true);
               }

               FlansMod.getPacketHandler().sendToAllAround(new PacketFlashBang(this.type.flashTime), this.field_70165_t, this.field_70163_u, this.field_70161_v, (float)this.type.flashRange, this.field_71093_bK);
               this.func_70106_y();
            }

         }
      }
   }

   public void func_70056_a(double x, double y, double z, float yaw, float pitch, int i) {
   }

   private DamageSource getGrenadeDamage() {
      return this.thrower instanceof EntityPlayer ? (new EntityDamageSourceGun(this.type.shortName, this, (EntityPlayer)this.thrower, this.type, false)).func_76349_b() : (new EntityDamageSourceIndirect(this.type.shortName, this, this.thrower)).func_76349_b();
   }

   protected void func_70088_a() {
   }

   protected void func_70037_a(NBTTagCompound tags) {
      this.type = GrenadeType.getGrenade(tags.func_74779_i("Type"));
      if (this.type == null) {
         FlansMod.log("EntityGrenade.readEntityFromNBT() Error: GrenadeType is null (" + this + ")");
         this.func_70106_y();
      } else {
         this.thrower = this.field_70170_p.func_72924_a(tags.func_74779_i("Thrower"));
         this.field_70177_z = tags.func_74760_g("RotationYaw");
         this.field_70125_A = tags.func_74760_g("RotationPitch");
         this.axes.setAngles(this.field_70177_z, this.field_70125_A, 0.0F);
      }
   }

   protected void func_70014_b(NBTTagCompound tags) {
      if (this.type == null) {
         FlansMod.log("EntityGrenade.writeEntityToNBT() Error: GrenadeType is null (" + this + ")");
         this.func_70106_y();
      } else {
         tags.func_74778_a("Type", this.type.shortName);
         if (this.thrower != null) {
            tags.func_74778_a("Thrower", this.thrower.func_70005_c_());
         }

         tags.func_74776_a("RotationYaw", this.axes.getYaw());
         tags.func_74776_a("RotationPitch", this.axes.getPitch());
      }
   }

   public void writeSpawnData(ByteBuf data) {
      ByteBufUtils.writeUTF8String(data, this.type.shortName);
      data.writeInt(this.thrower == null ? 0 : this.thrower.func_145782_y());
      data.writeFloat(this.axes.getYaw());
      data.writeFloat(this.axes.getPitch());
   }

   public void readSpawnData(ByteBuf data) {
      this.type = GrenadeType.getGrenade(ByteBufUtils.readUTF8String(data));
      this.thrower = (EntityLivingBase)this.field_70170_p.func_73045_a(data.readInt());
      this.func_70101_b(data.readFloat(), data.readFloat());
      this.field_70126_B = this.field_70177_z;
      this.field_70127_C = this.field_70125_A;
      this.axes.setAngles(this.field_70177_z, this.field_70125_A, 0.0F);
      if (this.type.spinWhenThrown) {
         this.angularVelocity = new Vector3f(0.0F, 0.0F, 10.0F);
      }

   }

   public boolean func_70027_ad() {
      return false;
   }

   public boolean func_70067_L() {
      return !this.field_70128_L && this.type.isDeployableBag;
   }

   public boolean func_130002_c(EntityPlayer player) {
      if (this.type.isDeployableBag && !this.field_70170_p.field_72995_K) {
         boolean used = false;
         if (this.type.healAmount > 0.0F && player.func_110143_aJ() < player.func_110138_aP()) {
            player.func_70691_i(this.type.healAmount);
            FlansMod.getPacketHandler().sendToAllAround((PacketBase)(new PacketFlak(player.field_70165_t, player.field_70163_u, player.field_70161_v, 5, "heart")), new TargetPoint(player.field_71093_bK, player.field_70165_t, player.field_70163_u, player.field_70161_v, 50.0D));
            used = true;
         }

         for(Iterator var3 = this.type.potionEffects.iterator(); var3.hasNext(); used = true) {
            PotionEffect effect = (PotionEffect)var3.next();
            player.func_70690_d(new PotionEffect(effect));
         }

         if (this.type.numClips > 0 && player.func_71045_bC() != null && player.func_71045_bC().func_77973_b() instanceof ItemGun) {
            GunType gun = ((ItemGun)player.func_71045_bC().func_77973_b()).type;
            if (gun.ammo.size() > 0) {
               ShootableType bulletToGive = (ShootableType)gun.ammo.get(0);
               int numToGive = Math.min(bulletToGive.maxStackSize, this.type.numClips * gun.getNumAmmoItemsInGun(player.func_71045_bC()));
               if (player.field_71071_by.func_70441_a(new ItemStack(bulletToGive.item, numToGive))) {
                  used = true;
               }
            }
         }

         if (used) {
            --this.numUsesRemaining;
            if (this.numUsesRemaining <= 0) {
               this.func_70106_y();
            }
         }
      }

      return true;
   }
}
