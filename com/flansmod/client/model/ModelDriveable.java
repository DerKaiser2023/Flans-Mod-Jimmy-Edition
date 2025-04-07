package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EntityDriveable;
import java.util.HashMap;
import java.util.Iterator;
import net.minecraft.client.model.ModelBase;

public class ModelDriveable extends ModelBase {
   public static final float pi = 3.1415927F;
   public static final float tau = 6.2831855F;
   public HashMap<String, ModelRendererTurbo[][]> gunModels = new HashMap();
   public ModelRendererTurbo[] bodyModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] bodyDoorOpenModel = new ModelRendererTurbo[0];
   public ModelRendererTurbo[] bodyDoorCloseModel = new ModelRendererTurbo[0];
   public boolean oldRotateOrder = false;

   public void render(EntityDriveable driveable, float f1) {
   }

   public void render(DriveableType type) {
      this.renderPart(this.bodyModel);
      this.renderPart(this.bodyDoorCloseModel);
      Iterator var2 = this.gunModels.values().iterator();

      while(var2.hasNext()) {
         ModelRendererTurbo[][] gun = (ModelRendererTurbo[][])var2.next();
         ModelRendererTurbo[][] var4 = gun;
         int var5 = gun.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            ModelRendererTurbo[] gunPart = var4[var6];
            this.renderPart(gunPart);
         }
      }

   }

   public void renderPart(ModelRendererTurbo[] part) {
      ModelRendererTurbo[] var2 = part;
      int var3 = part.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         ModelRendererTurbo bit = var2[var4];
         bit.render(0.0625F, this.oldRotateOrder);
      }

   }

   public void registerGunModel(String name, ModelRendererTurbo[][] gunModel) {
      this.gunModels.put(name, gunModel);
   }

   protected void flip(ModelRendererTurbo[] model) {
      ModelRendererTurbo[] var2 = model;
      int var3 = model.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         ModelRendererTurbo part = var2[var4];
         part.doMirror(false, true, true);
         part.func_78793_a(part.field_78800_c, -part.field_78797_d, -part.field_78798_e);
      }

   }

   public void flipAll() {
      this.flip(this.bodyModel);
      this.flip(this.bodyDoorOpenModel);
      this.flip(this.bodyDoorCloseModel);
      Iterator var1 = this.gunModels.values().iterator();

      while(var1.hasNext()) {
         ModelRendererTurbo[][] modsOfMods = (ModelRendererTurbo[][])var1.next();
         ModelRendererTurbo[][] var3 = modsOfMods;
         int var4 = modsOfMods.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            ModelRendererTurbo[] mods = var3[var5];
            this.flip(mods);
         }
      }

   }

   protected void translate(ModelRendererTurbo[] model, float x, float y, float z) {
      ModelRendererTurbo[] var5 = model;
      int var6 = model.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         ModelRendererTurbo mod = var5[var7];
         mod.field_78800_c += x;
         mod.field_78797_d += y;
         mod.field_78798_e += z;
      }

   }

   public void translateAll(float x, float y, float z) {
      this.translate(this.bodyModel, x, y, z);
      this.translate(this.bodyDoorOpenModel, x, y, z);
      this.translate(this.bodyDoorCloseModel, x, y, z);
      Iterator var4 = this.gunModels.values().iterator();

      while(var4.hasNext()) {
         ModelRendererTurbo[][] modsOfMods = (ModelRendererTurbo[][])var4.next();
         ModelRendererTurbo[][] var6 = modsOfMods;
         int var7 = modsOfMods.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            ModelRendererTurbo[] mods = var6[var8];
            this.translate(mods, x, y, z);
         }
      }

   }

   public void translateAll(int x, int y, int z) {
      this.translateAll((float)x, (float)y, (float)z);
   }
}
