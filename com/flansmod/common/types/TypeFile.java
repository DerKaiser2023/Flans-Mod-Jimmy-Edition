package com.flansmod.common.types;

import java.util.ArrayList;
import java.util.HashMap;

public class TypeFile {
   public EnumType type;
   public String name;
   public final String pack;
   public ArrayList<String> lines;
   public static HashMap<EnumType, ArrayList<TypeFile>> files = new HashMap();
   private int readerPosition;

   public TypeFile(EnumType t, String s, String packName) {
      this(t, s, packName, true);
   }

   public TypeFile(EnumType t, String s, String packName, boolean addToTypeFileList) {
      this.readerPosition = 0;
      this.type = t;
      this.name = s;
      this.pack = packName;
      this.lines = new ArrayList();
      if (addToTypeFileList) {
         ((ArrayList)files.get(this.type)).add(this);
      }

   }

   public String readLine() {
      return this.readerPosition == this.lines.size() ? null : (String)this.lines.get(this.readerPosition++);
   }

   static {
      EnumType[] var0 = EnumType.values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         EnumType type = var0[var2];
         files.put(type, new ArrayList());
      }

   }
}
