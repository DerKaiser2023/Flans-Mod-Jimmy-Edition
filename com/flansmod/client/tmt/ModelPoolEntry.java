package com.flansmod.client.tmt;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class ModelPoolEntry {
   public String name;
   public PositionTransformVertex[] vertices;
   public TexturedPolygon[] faces;
   public Map<String, TransformGroupBone> groups;
   public Map<String, TextureGroup> textures;
   protected TransformGroupBone group;
   protected TextureGroup texture;
   protected String[] fileExtensions;

   public File checkValidPath(String path) {
      File file = null;

      for(int index = 0; index < this.fileExtensions.length && (file == null || !file.exists()); ++index) {
         String absPath = path;
         if (!path.endsWith("." + this.fileExtensions[index])) {
            absPath = path + "." + this.fileExtensions[index];
         }

         file = new File(absPath);
      }

      return file != null && file.exists() ? file : null;
   }

   public abstract void getModel(File var1);

   protected void setGroup(String groupName) {
      this.setGroup(groupName, new Bone(0.0F, 0.0F, 0.0F, 0.0F), 1.0D);
   }

   protected void setGroup(String groupName, Bone bone, double weight) {
      if (this.groups.size() == 0 || !this.groups.containsKey(groupName)) {
         this.groups.put(groupName, new TransformGroupBone(bone, weight));
      }

      this.group = (TransformGroupBone)this.groups.get(groupName);
   }

   protected void setTextureGroup(String groupName) {
      if (this.textures.size() == 0 || !this.textures.containsKey(groupName)) {
         this.textures.put(groupName, new TextureGroup());
      }

      this.texture = (TextureGroup)this.textures.get(groupName);
   }

   protected void applyGroups(Map<String, TransformGroup> groupsMap, Map<String, TextureGroup> texturesMap) {
      Set<String> groupsCol = this.groups.keySet();
      Collection<String> texturesCol = this.textures.keySet();
      Iterator<String> groupsItr = groupsCol.iterator();
      Iterator texturesItr = texturesCol.iterator();

      int nameIdx;
      String groupKey;
      String currentGroup;
      while(groupsItr.hasNext()) {
         nameIdx = 0;
         groupKey = (String)groupsItr.next();

         for(currentGroup = this.name + "_" + nameIdx + ":" + groupKey; groupsMap.size() > 0 && groupsMap.containsKey(currentGroup); currentGroup = this.name + "_" + nameIdx + ":" + groupKey) {
            ++nameIdx;
         }

         groupsMap.put(currentGroup, this.groups.get(groupKey));
      }

      while(texturesItr.hasNext()) {
         nameIdx = 0;
         groupKey = (String)texturesItr.next();

         for(currentGroup = this.name + "_" + nameIdx + ":" + groupKey; groupsMap.size() > 0 && texturesMap.containsKey(currentGroup); currentGroup = this.name + "_" + nameIdx + ":" + groupKey) {
            ++nameIdx;
         }

         texturesMap.put(currentGroup, this.textures.get(groupKey));
      }

   }
}
