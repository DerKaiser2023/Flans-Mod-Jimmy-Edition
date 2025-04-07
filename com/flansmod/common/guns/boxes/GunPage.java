package com.flansmod.common.guns.boxes;

public class GunPage {
   public String pageName;
   public GunBoxEntry[] gunList;

   public GunPage(String n) {
      this.pageName = n;
   }

   public void addGunList(GunBoxEntry[] list) {
      this.gunList = list;
   }

   public int getSize() {
      return this.gunList.length;
   }

   public boolean isPageEmpty() {
      return this.gunList.length == 0;
   }

   public void setPageName(String name) {
      this.pageName = name;
   }
}
