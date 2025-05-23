package com.flansmod.client.model;

import com.flansmod.common.RotatedAxes;
import com.flansmod.common.vector.Vector3f;

public class AnimTrackLink {
   public Vector3f position;
   public Vector3f prevPosition;
   public float zRot = 0.0F;
   public float prevZRot;
   public float progress = 0.0F;
   public RotatedAxes rot;

   public AnimTrackLink(float prog) {
      this.progress = prog;
   }
}
