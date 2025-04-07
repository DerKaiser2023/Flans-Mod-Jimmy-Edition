package com.flansmod.client.model.animation;

import com.flansmod.common.vector.Vector3f;
import java.util.ArrayList;
import java.util.Iterator;

public class AnimationPose {
   ArrayList<PoseComponent> parts = new ArrayList();

   public PoseComponent getComponentWithName(String name) {
      PoseComponent part = new PoseComponent("nope", (Vector3f)null, (Vector3f)null, 0, 0, false);
      Iterator var3 = this.parts.iterator();

      while(var3.hasNext()) {
         PoseComponent p = (PoseComponent)var3.next();
         if (p.name.equals(name)) {
            part = p;
         }
      }

      return part;
   }
}
