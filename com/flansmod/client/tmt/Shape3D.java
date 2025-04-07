package com.flansmod.client.tmt;

public class Shape3D {
   public PositionTransformVertex[] vertices;
   public TexturedPolygon[] faces;

   public Shape3D(PositionTransformVertex[] verts, TexturedPolygon[] poly) {
      this.vertices = verts;
      this.faces = poly;
   }
}
