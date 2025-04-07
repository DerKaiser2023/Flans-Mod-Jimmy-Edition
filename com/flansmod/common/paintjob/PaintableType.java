package com.flansmod.common.paintjob;

import com.flansmod.common.FlansMod;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.types.TypeFile;
import java.util.ArrayList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public abstract class PaintableType extends InfoType {
   public ArrayList<Paintjob> paintjobs = new ArrayList();
   public Paintjob defaultPaintjob;
   private int nextPaintjobID = 1;
   private String paintjobName;

   public PaintableType(TypeFile file) {
      super(file);
   }

   public void preRead(TypeFile file) {
   }

   public void postRead(TypeFile file) {
      this.defaultPaintjob = new Paintjob(0, "default", this.iconPath, this.texture, new ItemStack[0]);
      ArrayList<Paintjob> newPaintjobList = new ArrayList();
      newPaintjobList.add(this.defaultPaintjob);
      newPaintjobList.addAll(this.paintjobs);
      this.paintjobs = newPaintjobList;
   }

   protected void read(String[] split, TypeFile file) {
      super.read(split, file);

      try {
         if (split[0].toLowerCase().equals("paintjob")) {
            ItemStack[] dyeStacks = new ItemStack[(split.length - 4) / 2];

            for(int i = 0; i < (split.length - 4) / 2; ++i) {
               dyeStacks[i] = new ItemStack(Items.field_151100_aR, Integer.parseInt(split[i * 2 + 5]), this.getDyeDamageValue(split[i * 2 + 4]));
            }

            this.paintjobs.add(new Paintjob(this.nextPaintjobID++, split[1], split[2], split[3], dyeStacks));
         }
      } catch (Exception var5) {
         FlansMod.log("Reading file failed : " + this.shortName);
         var5.printStackTrace();
      }

   }

   public Paintjob getPaintjob(int i) {
      return (Paintjob)this.paintjobs.get(i);
   }

   public float GetRecommendedScale() {
      return 50.0F;
   }
}
