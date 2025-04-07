package com.flansmod.client.model;

import com.flansmod.common.vector.Vector3f;
import java.util.ArrayList;

public class AnimTankTrack {
   public ArrayList<Vector3f> points = new ArrayList();
   public float trackLinkLength = 0.0F;

   public AnimTankTrack(ArrayList<Vector3f> trackPoints, float linkLength) {
      this.points = trackPoints;
      this.trackLinkLength = linkLength;
   }

   public void setLinkLength(float length) {
      this.trackLinkLength = length;
   }

   public float distBetweenPoints(Vector3f p1, Vector3f p2) {
      float x = p1.x - p2.x;
      float y = p1.y - p2.y;
      float distance = (float)Math.sqrt((double)(x * x + y * y));
      return distance;
   }

   public float getTrackLength() {
      float length = 0.0F;

      for(int i = 0; i < this.points.size(); ++i) {
         length += this.distBetweenPoints((Vector3f)this.points.get(i), (Vector3f)this.points.get(i == 0 ? this.points.size() - 1 : i - 1));
      }

      return length;
   }

   public int getTrackPart(float distance) {
      float length = 0.0F;

      for(int i = 0; i < this.points.size(); ++i) {
         if (length >= distance) {
            return i;
         }

         length += this.distBetweenPoints((Vector3f)this.points.get(i), (Vector3f)this.points.get(i == this.points.size() - 1 ? 0 : i + 1));
      }

      return 0;
   }

   public float getProgressAlongTrackPart(float distance, int trackPart) {
      float length = 0.0F;
      float lastLength = 0.0F;

      for(int i = 0; i < trackPart + 1; ++i) {
         if (i != 0) {
            length += this.distBetweenPoints((Vector3f)this.points.get(i - 1), (Vector3f)this.points.get(i));
         }
      }

      return length;
   }

   public Vector3f getPositionOnTrack(float distance) {
      int trackPart = this.getTrackPart(distance);
      Vector3f p2 = (Vector3f)this.points.get(trackPart == 0 ? this.points.size() - 1 : trackPart - 1);
      Vector3f p1 = (Vector3f)this.points.get(trackPart);
      float partLength = this.distBetweenPoints(p2, p1);
      float prog = distance - this.getProgressAlongTrackPart(distance, trackPart == 0 ? this.points.size() - 1 : trackPart - 1);
      float progress = prog / partLength;
      Vector3f finalPos = new Vector3f(this.lerp(p2.x, p1.x, progress), this.lerp(p2.y, p1.y, progress), this.lerp(p2.z, p1.z, progress));
      return finalPos;
   }

   public float lerp(float a, float b, float f) {
      float result = a + f * (b - a);
      return result;
   }
}
