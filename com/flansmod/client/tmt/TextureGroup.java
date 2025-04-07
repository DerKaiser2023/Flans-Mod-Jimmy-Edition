package com.flansmod.client.tmt;

import java.util.ArrayList;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;

public class TextureGroup {
   public ArrayList<TexturedPolygon> poly = new ArrayList();
   public String texture = "";

   public void addPoly(TexturedPolygon polygon) {
      this.poly.add(polygon);
   }

   public void loadTexture() {
      this.loadTexture(-1);
   }

   public void loadTexture(int defaultTexture) {
      if (!this.texture.equals("")) {
         TextureManager renderengine = RenderManager.field_78727_a.field_78724_e;
         renderengine.func_110577_a(new ResourceLocation("", this.texture));
      } else if (defaultTexture > -1) {
         RenderManager.field_78727_a.field_78724_e.func_110577_a(new ResourceLocation("", ""));
      }

   }
}
