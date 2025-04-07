package com.flansmod.common.driveables;

import com.flansmod.common.guns.GunType;
import com.flansmod.common.vector.Vector3f;

public class PilotGun extends DriveablePosition {
   public GunType type;

   public PilotGun(String[] split) {
      super(new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F), EnumDriveablePart.getPart(split[4]));
      this.type = GunType.getGun(split[5]);
   }
}
