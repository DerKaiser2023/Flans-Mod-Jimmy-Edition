package com.flansmod.client.model.animation;

import com.flansmod.common.RotatedAxes;
import com.flansmod.common.vector.Vector3f;
import java.util.ArrayList;
import java.util.Iterator;

public class AnimationController {
   public ArrayList<AnimationPart> parts = new ArrayList();
   public int state = 0;
   int animStage = 1;
   ArrayList<AnimationPose> poses = new ArrayList();
   AnimationPose pose;
   public int timeSinceSwitch = 0;

   public void initAnim() {
      this.addPartToSkeleton(new AnimationPart(0, new Vector3f(11.0D, -34.5D, 0.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), -1);
      this.addPartToSkeleton(new AnimationPart(1, new Vector3f(6.0D, -34.5D, 0.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 0);
      this.addPartToSkeleton(new AnimationPart(2, new Vector3f(-25.0D, -34.5D, 0.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 1);
      this.addPartToSkeleton(new AnimationPart(3, new Vector3f(-9.0D, -25.0D, -13.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 0);
      this.addPartToSkeleton(new AnimationPart(4, new Vector3f(6.0D, -23.0D, -21.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 3);
      this.addPartToSkeleton(new AnimationPart(5, new Vector3f(34.0D, -21.5D, -21.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 4);
      this.addPartToSkeleton(new AnimationPart(6, new Vector3f(-9.0D, -25.0D, 13.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 0);
      this.addPartToSkeleton(new AnimationPart(7, new Vector3f(6.0D, -23.0D, 21.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 6);
      this.addPartToSkeleton(new AnimationPart(8, new Vector3f(34.0D, -21.5D, 21.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 7);
      this.addPartToSkeleton(new AnimationPart(9, new Vector3f(6.0F, -33.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 0);
      this.addPartToSkeleton(new AnimationPart(10, new Vector3f(43.0D, -38.5D, 0.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 9);
      this.addPartToSkeleton(new AnimationPart(11, new Vector3f(60.0D, -40.0D, -14.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 10);
      this.addPartToSkeleton(new AnimationPart(12, new Vector3f(60.0D, -40.0D, 14.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 10);
      this.addPartToSkeleton(new AnimationPart(13, new Vector3f(10.0D, -36.5D, -17.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 9);
      this.addPartToSkeleton(new AnimationPart(14, new Vector3f(10.0D, -36.5D, 17.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 9);
      this.addPartToSkeleton(new AnimationPart(15, new Vector3f(39.0D, -13.0D, -21.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 5);
      this.addPartToSkeleton(new AnimationPart(16, new Vector3f(119.0D, -23.0D, -21.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 5);
      this.addPartToSkeleton(new AnimationPart(17, new Vector3f(119.0D, -23.0D, -21.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 5);
      this.addPartToSkeleton(new AnimationPart(18, new Vector3f(39.0D, -13.0D, 21.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 8);
      this.addPartToSkeleton(new AnimationPart(19, new Vector3f(119.0D, -23.0D, 21.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 8);
      this.addPartToSkeleton(new AnimationPart(20, new Vector3f(119.0D, -23.0D, 21.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 8);
      this.addPartToSkeleton(new AnimationPart(21, new Vector3f(-17.0F, -33.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 2);
      this.addPartToSkeleton(new AnimationPart(22, new Vector3f(-15.0F, -23.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 21);
      this.addPartToSkeleton(new AnimationPart(23, new Vector3f(17.0F, -31.0F, -7.0F), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 0);
      this.addPartToSkeleton(new AnimationPart(24, new Vector3f(22.0D, -20.5D, -7.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 23);
      this.addPartToSkeleton(new AnimationPart(25, new Vector3f(33.0D, -20.5D, -7.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 24);
      this.addPartToSkeleton(new AnimationPart(26, new Vector3f(68.0D, -19.5D, -7.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 25);
      this.addPartToSkeleton(new AnimationPart(27, new Vector3f(69.0D, -21.5D, -7.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 26);
      this.addPartToSkeleton(new AnimationPart(28, new Vector3f(17.0F, -31.0F, 7.0F), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 0);
      this.addPartToSkeleton(new AnimationPart(29, new Vector3f(22.0D, -20.5D, 7.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 28);
      this.addPartToSkeleton(new AnimationPart(30, new Vector3f(33.0D, -20.5D, 7.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 29);
      this.addPartToSkeleton(new AnimationPart(31, new Vector3f(68.0D, -19.5D, 7.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 30);
      this.addPartToSkeleton(new AnimationPart(32, new Vector3f(69.0D, -21.5D, 7.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 31);
   }

   public void initPoses() {
      this.addDefaultPose();
      this.addGERWALKPose();
   }

   public void addDefaultPose() {
      AnimationPose pose = new AnimationPose();
      pose.parts.add(new PoseComponent("core", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("midfront", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("nose", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftlegtop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftlegmid", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftlegshin", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 4, false));
      pose.parts.add(new PoseComponent("rightlegtop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightlegmid", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightlegshin", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 4, false));
      pose.parts.add(new PoseComponent("rearbody", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("tailmid", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 12, false));
      pose.parts.add(new PoseComponent("finleft", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 4, false));
      pose.parts.add(new PoseComponent("finright", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 4, false));
      pose.parts.add(new PoseComponent("leftwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 30.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, -30.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("head", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("headguns", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftshoulder", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 5, 5, false));
      pose.parts.add(new PoseComponent("leftshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 5, 5, false));
      pose.parts.add(new PoseComponent("leftupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 5, 5, false));
      pose.parts.add(new PoseComponent("leftlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 5, 5, false));
      pose.parts.add(new PoseComponent("lefthand", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 5, 5, false));
      pose.parts.add(new PoseComponent("rightshoulder", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 5, 5, false));
      pose.parts.add(new PoseComponent("rightshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 5, 5, false));
      pose.parts.add(new PoseComponent("rightupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 5, 5, false));
      pose.parts.add(new PoseComponent("rightlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 5, 5, false));
      pose.parts.add(new PoseComponent("righthand", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 5, 5, false));
      this.poses.add(pose);
   }

   public void addGERWALKPose() {
      AnimationPose pose = new AnimationPose();
      pose.parts.add(new PoseComponent("core", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("midfront", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("nose", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftlegtop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftlegmid", new Vector3f(5.0F, 0.0F, 0.0F), new Vector3f(-20.0F, 0.0F, -50.0F), 2, 8, false));
      pose.parts.add(new PoseComponent("leftlegshin", new Vector3f(5.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -100.0F), 2, 16, false));
      pose.parts.add(new PoseComponent("rightlegtop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightlegmid", new Vector3f(5.0F, 0.0F, 0.0F), new Vector3f(20.0F, 0.0F, -50.0F), 2, 8, false));
      pose.parts.add(new PoseComponent("rightlegshin", new Vector3f(5.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -100.0F), 2, 16, false));
      pose.parts.add(new PoseComponent("rearbody", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("tailmid", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 160.0F), 2, 12, false));
      pose.parts.add(new PoseComponent("finleft", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(-100.0F, 0.0F, 0.0F), 2, 14, false));
      pose.parts.add(new PoseComponent("finright", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(100.0F, 0.0F, 0.0F), 2, 14, false));
      pose.parts.add(new PoseComponent("leftwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 90.0F), 2, 25, false));
      pose.parts.add(new PoseComponent("leftfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 45.0F), 2, 25, false));
      pose.parts.add(new PoseComponent("leftfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -45.0F), 2, 25, false));
      pose.parts.add(new PoseComponent("rightknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 90.0F), 2, 25, false));
      pose.parts.add(new PoseComponent("rightfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 45.0F), 2, 25, false));
      pose.parts.add(new PoseComponent("rightfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -45.0F), 2, 25, false));
      pose.parts.add(new PoseComponent("head", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("headguns", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftshoulder", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("lefthand", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightshoulder", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("righthand", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      this.poses.add(pose);
      this.addGERWALK2();
   }

   public void addGERWALK2() {
      AnimationPose pose = new AnimationPose();
      pose.parts.add(new PoseComponent("core", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("midfront", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("nose", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftlegtop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftlegmid", new Vector3f(10.0F, 0.0F, 0.0F), new Vector3f(-20.0F, 0.0F, -35.0F), 2, 3, false));
      pose.parts.add(new PoseComponent("leftlegshin", new Vector3f(5.0F, 5.0F, 0.0F), new Vector3f(0.0F, 0.0F, -75.0F), 2, 6, false));
      pose.parts.add(new PoseComponent("rightlegtop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightlegmid", new Vector3f(10.0F, 0.0F, 0.0F), new Vector3f(20.0F, 0.0F, -35.0F), 2, 3, false));
      pose.parts.add(new PoseComponent("rightlegshin", new Vector3f(5.0F, 5.0F, 0.0F), new Vector3f(0.0F, 0.0F, -75.0F), 2, 6, false));
      pose.parts.add(new PoseComponent("rearbody", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("tailmid", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 160.0F), 2, 12, false));
      pose.parts.add(new PoseComponent("finleft", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(-100.0F, 0.0F, 0.0F), 2, 14, false));
      pose.parts.add(new PoseComponent("finright", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(100.0F, 0.0F, 0.0F), 2, 14, false));
      pose.parts.add(new PoseComponent("leftwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 110.0F), 2, 25, false));
      pose.parts.add(new PoseComponent("leftfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 60.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -30.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 110.0F), 2, 25, false));
      pose.parts.add(new PoseComponent("rightfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 60.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -30.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("head", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("headguns", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 20.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftshoulder", new Vector3f(15.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("lefthand", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightshoulder", new Vector3f(15.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("righthand", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      this.poses.add(pose);
      this.addGERWALK3();
   }

   public void addGERWALK3() {
      AnimationPose pose = new AnimationPose();
      pose.parts.add(new PoseComponent("core", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("midfront", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("nose", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftlegtop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftlegmid", new Vector3f(10.0F, 0.0F, 0.0F), new Vector3f(-20.0F, 0.0F, -35.0F), 2, 3, false));
      pose.parts.add(new PoseComponent("leftlegshin", new Vector3f(5.0F, 5.0F, 0.0F), new Vector3f(0.0F, 0.0F, -75.0F), 2, 6, false));
      pose.parts.add(new PoseComponent("rightlegtop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightlegmid", new Vector3f(10.0F, 0.0F, 0.0F), new Vector3f(20.0F, 0.0F, -35.0F), 2, 3, false));
      pose.parts.add(new PoseComponent("rightlegshin", new Vector3f(5.0F, 5.0F, 0.0F), new Vector3f(0.0F, 0.0F, -75.0F), 2, 6, false));
      pose.parts.add(new PoseComponent("rearbody", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("tailmid", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 160.0F), 2, 12, false));
      pose.parts.add(new PoseComponent("finleft", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(-100.0F, 0.0F, 0.0F), 2, 14, false));
      pose.parts.add(new PoseComponent("finright", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(100.0F, 0.0F, 0.0F), 2, 14, false));
      pose.parts.add(new PoseComponent("leftwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 110.0F), 2, 25, false));
      pose.parts.add(new PoseComponent("leftfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 60.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -30.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 110.0F), 2, 25, false));
      pose.parts.add(new PoseComponent("rightfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 60.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -30.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("head", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("headguns", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 20.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftshoulder", new Vector3f(15.0F, -25.0F, 0.0F), new Vector3f(-90.0F, 0.0F, 0.0F), 6, 12, false));
      pose.parts.add(new PoseComponent("leftshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("lefthand", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightshoulder", new Vector3f(15.0F, -25.0F, 0.0F), new Vector3f(90.0F, 0.0F, 0.0F), 6, 12, false));
      pose.parts.add(new PoseComponent("rightshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("righthand", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      this.poses.add(pose);
      this.addGERWALK4();
   }

   public void addGERWALK4() {
      AnimationPose pose = new AnimationPose();
      pose.parts.add(new PoseComponent("core", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("midfront", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("nose", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftlegtop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftlegmid", new Vector3f(10.0F, 0.0F, 0.0F), new Vector3f(-20.0F, 0.0F, -35.0F), 2, 3, false));
      pose.parts.add(new PoseComponent("leftlegshin", new Vector3f(5.0F, 5.0F, 0.0F), new Vector3f(0.0F, 0.0F, -75.0F), 2, 6, false));
      pose.parts.add(new PoseComponent("rightlegtop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightlegmid", new Vector3f(10.0F, 0.0F, 0.0F), new Vector3f(20.0F, 0.0F, -35.0F), 2, 3, false));
      pose.parts.add(new PoseComponent("rightlegshin", new Vector3f(5.0F, 5.0F, 0.0F), new Vector3f(0.0F, 0.0F, -75.0F), 2, 6, false));
      pose.parts.add(new PoseComponent("rearbody", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("tailmid", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 160.0F), 2, 12, false));
      pose.parts.add(new PoseComponent("finleft", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(-100.0F, 0.0F, 0.0F), 2, 14, false));
      pose.parts.add(new PoseComponent("finright", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(100.0F, 0.0F, 0.0F), 2, 14, false));
      pose.parts.add(new PoseComponent("leftwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 110.0F), 2, 25, false));
      pose.parts.add(new PoseComponent("leftfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 60.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -30.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 110.0F), 2, 25, false));
      pose.parts.add(new PoseComponent("rightfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 60.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -30.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("head", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("headguns", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 20.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftshoulder", new Vector3f(10.0F, -25.0F, -10.0F), new Vector3f(-90.0F, 90.0F, 0.0F), 4, 6, false));
      pose.parts.add(new PoseComponent("leftshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -80.0F), 2, 6, false));
      pose.parts.add(new PoseComponent("leftupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(-90.0F, 0.0F, 0.0F), 2, 6, false));
      pose.parts.add(new PoseComponent("leftlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 50.0F), 2, 12, false));
      pose.parts.add(new PoseComponent("lefthand", new Vector3f(23.0F, 0.0F, 0.0F), new Vector3f(180.0F, 0.0F, 0.0F), 2, 20, false));
      pose.parts.add(new PoseComponent("rightshoulder", new Vector3f(10.0F, -25.0F, 10.0F), new Vector3f(90.0F, -90.0F, 0.0F), 4, 6, false));
      pose.parts.add(new PoseComponent("rightshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -80.0F), 2, 6, false));
      pose.parts.add(new PoseComponent("rightupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(90.0F, 0.0F, 0.0F), 2, 6, false));
      pose.parts.add(new PoseComponent("rightlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 50.0F), 2, 12, false));
      pose.parts.add(new PoseComponent("righthand", new Vector3f(23.0F, 0.0F, 0.0F), new Vector3f(180.0F, 0.0F, 0.0F), 2, 20, false));
      this.poses.add(pose);
      this.addGERWALK5();
   }

   public void addGERWALK5() {
      AnimationPose pose = new AnimationPose();
      pose.parts.add(new PoseComponent("core", new Vector3f(120.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 90.0F), 2, 4, false));
      pose.parts.add(new PoseComponent("midfront", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 4, false));
      pose.parts.add(new PoseComponent("nose", new Vector3f(20.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftlegtop", new Vector3f(60.0F, 0.0F, -5.0F), new Vector3f(0.0F, 0.0F, -180.0F), 2, 8, false));
      pose.parts.add(new PoseComponent("leftlegmid", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -30.0F), 2, 3, false));
      pose.parts.add(new PoseComponent("leftlegshin", new Vector3f(5.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 60.0F), 2, 6, false));
      pose.parts.add(new PoseComponent("rightlegtop", new Vector3f(60.0F, 0.0F, 5.0F), new Vector3f(0.0F, 0.0F, -180.0F), 2, 8, false));
      pose.parts.add(new PoseComponent("rightlegmid", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 3, false));
      pose.parts.add(new PoseComponent("rightlegshin", new Vector3f(5.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 6, false));
      pose.parts.add(new PoseComponent("rearbody", new Vector3f(20.0F, 5.0F, 0.0F), new Vector3f(0.0F, 0.0F, -170.0F), 2, 8, false));
      pose.parts.add(new PoseComponent("tailmid", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 160.0F), 2, 12, false));
      pose.parts.add(new PoseComponent("finleft", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(-100.0F, 0.0F, 0.0F), 2, 14, false));
      pose.parts.add(new PoseComponent("finright", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(100.0F, 0.0F, 0.0F), 2, 14, false));
      pose.parts.add(new PoseComponent("leftwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 20.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, -20.0F, 0.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 25, false));
      pose.parts.add(new PoseComponent("leftfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 45.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -45.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 25, false));
      pose.parts.add(new PoseComponent("rightfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 45.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("rightfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -45.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("head", new Vector3f(0.0F, 6.0F, 0.0F), new Vector3f(180.0F, 0.0F, 90.0F), 2, 8, false));
      pose.parts.add(new PoseComponent("headguns", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 130.0F), 2, 2, false));
      pose.parts.add(new PoseComponent("leftshoulder", new Vector3f(25.0F, -30.0F, 0.0F), new Vector3f(-90.0F, 180.0F, 0.0F), 4, 6, false));
      pose.parts.add(new PoseComponent("leftshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -30.0F), 2, 6, false));
      pose.parts.add(new PoseComponent("leftupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(-60.0F, 0.0F, 0.0F), 2, 6, false));
      pose.parts.add(new PoseComponent("leftlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 60.0F), 2, 12, false));
      pose.parts.add(new PoseComponent("lefthand", new Vector3f(23.0F, 0.0F, 0.0F), new Vector3f(180.0F, 0.0F, 0.0F), 2, 20, false));
      pose.parts.add(new PoseComponent("rightshoulder", new Vector3f(25.0F, -30.0F, 0.0F), new Vector3f(90.0F, -180.0F, 0.0F), 4, 6, false));
      pose.parts.add(new PoseComponent("rightshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 6, false));
      pose.parts.add(new PoseComponent("rightupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(90.0F, 0.0F, 0.0F), 2, 6, false));
      pose.parts.add(new PoseComponent("rightlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 10.0F), 2, 12, false));
      pose.parts.add(new PoseComponent("righthand", new Vector3f(23.0F, 0.0F, 0.0F), new Vector3f(180.0F, 0.0F, 0.0F), 2, 20, false));
      this.poses.add(pose);
   }

   public void addPartToSkeleton(AnimationPart p, int parent) {
      this.parts.add(p);
      if (parent >= 0) {
         AnimationPart part = (AnimationPart)this.parts.get(parent);
         part.hasChildren = true;
         part.children.add(p);
         p.parent = parent;
      }

   }

   public AnimationPart getCorePart() {
      AnimationPart part = (AnimationPart)this.parts.get(0);
      return part;
   }

   public void UpdateAnim(int stat) {
      switch(this.state) {
      case 0:
         this.pose = (AnimationPose)this.poses.get(0);
         this.animStage = 1;
         this.timeSinceSwitch = 0;
         break;
      case 1:
         if (this.animStage == 1) {
            this.pose = (AnimationPose)this.poses.get(1);
         } else if (this.animStage == 2) {
            this.pose = (AnimationPose)this.poses.get(2);
         } else if (this.animStage == 3) {
            this.pose = (AnimationPose)this.poses.get(3);
         } else if (this.animStage == 4) {
            this.pose = (AnimationPose)this.poses.get(4);
         }
      }

      boolean animHasFinished = true;
      Iterator var3 = this.parts.iterator();

      while(var3.hasNext()) {
         AnimationPart p = (AnimationPart)var3.next();
         p.prevOff = new Vector3f(p.offset.x, p.offset.y, p.offset.z);
         p.prevRot = new Vector3f(p.rotation.x, p.rotation.y, p.rotation.z);
         if (this.pose != null) {
            PoseComponent q = (PoseComponent)this.pose.parts.get(p.type);
            if (!this.checkIfFinished(p.offset, q.position)) {
               p.offset = this.transformPart(p.offset, q.position, new Vector3f((float)q.speed1, (float)q.speed1, (float)q.speed1));
            }

            if (animHasFinished) {
               animHasFinished = this.checkIfFinished(p.offset, q.position);
            }

            if (!this.checkIfFinished(p.rotation, q.rotation)) {
               p.rotation = this.transformPart(p.rotation, q.rotation, new Vector3f((float)q.speed2, (float)q.speed2, (float)q.speed2));
            }

            if (animHasFinished) {
               animHasFinished = this.checkIfFinished(p.rotation, q.rotation);
            }
         }
      }

      if (animHasFinished && this.timeSinceSwitch > 2) {
         ++this.animStage;
      }

      ++this.timeSinceSwitch;
   }

   public void changeState(int i) {
      this.state = i;
      this.animStage = 1;
      this.timeSinceSwitch = 0;
   }

   public boolean checkIfFinished(Vector3f a, Vector3f b) {
      boolean c = true;
      float d = a.lengthSquared();
      float e = b.lengthSquared();
      float f = d - e;
      f = (float)Math.sqrt((double)(f * f));
      if (f > 0.0F) {
         c = false;
      }

      return c;
   }

   public int getNumberOfStages() {
      int i = 0;
      switch(this.state) {
      case 0:
         i = 1;
         break;
      case 1:
         i = 4;
      }

      return i;
   }

   public Vector3f getPositionOnPart(Vector3f in, AnimationPart p, RotatedAxes rot) {
      Vector3f p1 = p.position;
      p.rotateToPartAxis(rot);
      Vector3f trans = new Vector3f(in.x - p1.x, in.y - p1.y, in.z - p1.z);
      trans = rot.findLocalVectorGlobally(trans);
      return trans;
   }

   public Vector3f getFullPosition(Vector3f in, AnimationPart p) {
      AnimationPart core = this.getCorePart();
      Vector3f pos = new Vector3f(0.0F, 0.0F, 0.0F);
      Vector3f.add(pos, new Vector3f(core.position.x, core.position.y, core.position.z), pos);
      RotatedAxes rot = new RotatedAxes(0.0F, 0.0F, 0.0F);
      ArrayList<Integer> chain = new ArrayList();
      chain = this.generateChain(p, chain);

      for(int i = chain.size() - 1; i > 0; --i) {
         AnimationPart child = (AnimationPart)this.parts.get((Integer)chain.get(i - 1));
         AnimationPart part = (AnimationPart)this.parts.get((Integer)chain.get(i));
         Vector3f tPos = this.getPositionOnPart(Vector3f.add(child.position, new Vector3f(child.offset.x, -child.offset.y, child.offset.z), (Vector3f)null), part, rot);
         Vector3f.add(tPos, pos, pos);
      }

      Vector3f tPos = this.getPositionOnPart(in, p, rot);
      Vector3f.add(tPos, pos, pos);
      return pos;
   }

   public ArrayList<Integer> generateChain(AnimationPart p, ArrayList<Integer> i) {
      i.add(p.type);
      if (p.parent >= 0) {
         this.generateChain((AnimationPart)this.parts.get(p.parent), i);
      }

      return i;
   }

   public Vector3f transformPart(Vector3f current, Vector3f target, Vector3f rate) {
      if (Math.sqrt((double)((current.x - target.x) * (current.x - target.x))) > (double)(rate.x / 2.0F)) {
         if (current.x > target.x) {
            current.x -= rate.x;
         } else if (current.x < target.x) {
            current.x += rate.x;
         }
      } else {
         current.x = target.x;
      }

      if (Math.sqrt((double)((current.y - target.y) * (current.y - target.y))) > (double)(rate.y / 2.0F)) {
         if (current.y > target.y) {
            current.y -= rate.y;
         } else if (current.y < target.y) {
            current.y += rate.y;
         }
      } else {
         current.y = target.y;
      }

      if (Math.sqrt((double)((current.z - target.z) * (current.z - target.z))) > (double)(rate.z / 2.0F)) {
         if (current.z > target.z) {
            current.z -= rate.z;
         } else if (current.z < target.z) {
            current.z += rate.z;
         }
      } else {
         current.z = target.z;
      }

      return current;
   }
}
