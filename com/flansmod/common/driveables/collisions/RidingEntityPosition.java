package com.flansmod.common.driveables.collisions;

import com.flansmod.common.driveables.EnumDriveablePart;
import com.flansmod.common.vector.Vector3f;

public class RidingEntityPosition {
   public Vector3f contactPos;
   public int contactSurface;
   public float distance;
   public EnumDriveablePart part;

   public RidingEntityPosition(float hitX, float hitY, float hitZ, int surface, double length, EnumDriveablePart type) {
      this.contactPos = new Vector3f(hitX, hitY, hitZ);
      this.contactSurface = surface;
      this.distance = (float)length;
   }

   public float length(Vector3f pos1, Vector3f pos2) {
      float result = (float)Math.sqrt((double)((pos1.x - pos2.x) * (pos1.x - pos2.x) + (pos1.y - pos2.y) * (pos1.y - pos2.y) + (pos1.z - pos2.z) * (pos1.z - pos2.z)));
      return result;
   }
}
