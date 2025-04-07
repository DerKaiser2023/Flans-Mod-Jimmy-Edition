package com.flansmod.common.driveables.collisions;

import com.flansmod.common.vector.Vector3f;

public class CollisionShapeBox {
   public Vector3f pos;
   public Vector3f size;
   public Vector3f p1;
   public Vector3f p2;
   public Vector3f p3;
   public Vector3f p4;
   public Vector3f p5;
   public Vector3f p6;
   public Vector3f p7;
   public Vector3f p8;
   public String part;

   public CollisionShapeBox(Vector3f position, Vector3f boxsize, Vector3f p1mod, Vector3f p2mod, Vector3f p3mod, Vector3f p4mod, Vector3f p5mod, Vector3f p6mod, Vector3f p7mod, Vector3f p8mod, String driveablePart) {
      this.pos = new Vector3f(position.x / 16.0F, -position.y / 16.0F - 0.625F, position.z / 16.0F);
      this.size = new Vector3f(boxsize.x / 16.0F, boxsize.y / 16.0F, boxsize.z / 16.0F);
      this.p1 = new Vector3f(p1mod.x / 16.0F, p1mod.y / 16.0F, p1mod.z / 16.0F);
      this.p2 = new Vector3f(p2mod.x / 16.0F, p2mod.y / 16.0F, p2mod.z / 16.0F);
      this.p3 = new Vector3f(p3mod.x / 16.0F, p3mod.y / 16.0F, p3mod.z / 16.0F);
      this.p4 = new Vector3f(p4mod.x / 16.0F, p4mod.y / 16.0F, p4mod.z / 16.0F);
      this.p5 = new Vector3f(p5mod.x / 16.0F, p5mod.y / 16.0F, p5mod.z / 16.0F);
      this.p6 = new Vector3f(p6mod.x / 16.0F, p6mod.y / 16.0F, p6mod.z / 16.0F);
      this.p7 = new Vector3f(p7mod.x / 16.0F, p7mod.y / 16.0F, p7mod.z / 16.0F);
      this.p8 = new Vector3f(p8mod.x / 16.0F, p8mod.y / 16.0F, p8mod.z / 16.0F);
      this.part = driveablePart;
   }
}
