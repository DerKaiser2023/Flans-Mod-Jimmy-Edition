package com.flansmod.common.driveables;

import net.minecraft.util.EntityDamageSource;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ChatComponentText;

public class EntityDamageSourceCollision extends EntityDamageSource {
    public final EntityDriveable sourceDriveable;

    public EntityDamageSourceCollision(EntityDriveable driveable) {
        super(driveable.getDriveableType().shortName, driveable);
        this.sourceDriveable = driveable;
        this.setDamageBypassesArmor();
    }

    @Override
    public IChatComponent func_151519_b(EntityLivingBase victim) {
        String tankName = sourceDriveable.getDriveableType().name;
        String msg = victim.getCommandSenderName() + " was pancaked by a " + tankName;
        return new ChatComponentText(msg);
    }
}