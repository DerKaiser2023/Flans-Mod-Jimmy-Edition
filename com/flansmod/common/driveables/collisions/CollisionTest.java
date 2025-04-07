package com.flansmod.common.driveables.collisions;

import com.flansmod.common.driveables.EnumDriveablePart;
import com.flansmod.common.vector.Vector3f;

public class CollisionTest {
   public Vector3f eRad;
   public Vector3f R3Velocity;
   public Vector3f R3Position;
   public Vector3f velocity;
   public Vector3f normalisedVelocity;
   public Vector3f basePoint;
   public boolean didCollide;
   public double nearestDistance;
   public Vector3f intersectionPoint;
   public int collisionRecursiveDepth;
   public boolean isOnTop = false;
   public Vector3f collisionPlaneNormal;
   public EnumDriveablePart part;

   public CollisionTest(Vector3f ellipsoid, Vector3f origin, Vector3f motion) {
      this.eRad = ellipsoid;
      this.R3Velocity = motion;
      this.R3Position = origin;
      this.velocity = this.ConvertR3ToESpace(motion);
      this.normalisedVelocity = this.velocity.normalise(this.normalisedVelocity);
      this.basePoint = origin;
   }

   public void checkTriangle(CollisionTest test, Vector3f p1, Vector3f p2, Vector3f p3) {
      CollisionPlane trianglePlane = new CollisionPlane(p1, p2, p3);
      if (trianglePlane.isFrontFacingTo(test.normalisedVelocity)) {
         boolean embeddedInPlane = false;
         double signedDistToTrianglePlane = trianglePlane.signedDistanceTo(test.basePoint);
         float normalDotVelocity = Vector3f.dot(trianglePlane.normal, test.velocity);
         double t0;
         double t1;
         if (normalDotVelocity == 0.0F) {
            if (Math.abs(signedDistToTrianglePlane) >= 1.0D) {
               return;
            }

            embeddedInPlane = true;
            t0 = 0.0D;
            t1 = 1.0D;
         } else {
            t0 = (-1.0D - signedDistToTrianglePlane) / (double)normalDotVelocity;
            t1 = (1.0D - signedDistToTrianglePlane) / (double)normalDotVelocity;
            if (t0 > t1) {
               double temp = t1;
               t1 = t0;
               t0 = temp;
            }

            if (t0 > 1.0D || t1 < 0.0D) {
               return;
            }

            if (t0 < 0.0D) {
               t0 = 0.0D;
            }

            if (t1 < 0.0D) {
               t1 = 0.0D;
            }

            if (t0 > 1.0D) {
               t0 = 1.0D;
            }

            if (t1 > 1.0D) {
               t1 = 1.0D;
            }
         }

         Vector3f collisionPoint = new Vector3f(0.0F, 0.0F, 0.0F);
         boolean foundCollision = false;
         float t = 1.0F;
         Vector3f velocity;
         Vector3f base;
         if (!embeddedInPlane) {
            velocity = Vector3f.sub(this.basePoint, trianglePlane.normal, (Vector3f)null);
            base = Vector3f.add(velocity, new Vector3f(t0 * (double)test.velocity.x, t0 * (double)test.velocity.y, t0 * (double)test.velocity.z), (Vector3f)null);
            if (this.checkPointInTriangle(base, p1, p2, p3)) {
               foundCollision = true;
               t = (float)t0;
               collisionPoint = base;
            }
         }

         if (!foundCollision) {
            velocity = test.velocity;
            base = test.basePoint;
            float velocitySquaredLength = velocity.lengthSquared();
            Vector3f baseSubP1 = Vector3f.sub(base, p1, (Vector3f)null);
            float b = 2.0F * Vector3f.dot(velocity, baseSubP1);
            float c = baseSubP1.lengthSquared() - 1.0F;
            if (this.getLowestRoot(velocitySquaredLength, b, c, t) != 1.23456792E8F) {
               t = this.getLowestRoot(velocitySquaredLength, b, c, t);
               foundCollision = true;
               collisionPoint = p1;
            }

            Vector3f baseSubP2 = Vector3f.sub(base, p2, (Vector3f)null);
            b = 2.0F * Vector3f.dot(velocity, baseSubP2);
            c = baseSubP2.lengthSquared();
            if (this.getLowestRoot(velocitySquaredLength, b, c, t) != 1.23456792E8F) {
               t = this.getLowestRoot(velocitySquaredLength, b, c, t);
               foundCollision = true;
               collisionPoint = p2;
            }

            Vector3f baseSubP3 = Vector3f.sub(base, p3, (Vector3f)null);
            b = 2.0F * Vector3f.dot(velocity, baseSubP3);
            c = baseSubP3.lengthSquared();
            if (this.getLowestRoot(velocitySquaredLength, b, c, t) != 1.23456792E8F) {
               t = this.getLowestRoot(velocitySquaredLength, b, c, t);
               foundCollision = true;
               collisionPoint = p3;
            }

            Vector3f edge = Vector3f.sub(p2, p1, (Vector3f)null);
            Vector3f baseToVertex = Vector3f.sub(p1, base, (Vector3f)null);
            float edgeSquaredLength = edge.lengthSquared();
            float edgeDotVelocity = Vector3f.dot(edge, velocity);
            float edgeDotBaseToVertex = Vector3f.dot(edge, baseToVertex);
            float a = edgeSquaredLength * -velocitySquaredLength + edgeDotVelocity * edgeDotVelocity;
            b = edgeSquaredLength * 2.0F * Vector3f.dot(velocity, baseToVertex) - 2.0F * edgeDotVelocity * edgeDotBaseToVertex;
            c = edgeSquaredLength * (1.0F - baseToVertex.lengthSquared()) + edgeDotBaseToVertex * edgeDotBaseToVertex;
            float newT;
            float f;
            if (this.getLowestRoot(a, b, c, t) != 1.23456792E8F) {
               newT = this.getLowestRoot(a, b, c, t);
               f = (edgeDotVelocity * newT - edgeDotBaseToVertex) / edgeSquaredLength;
               if ((double)f >= 0.0D && (double)f <= 1.0D) {
                  t = newT;
                  foundCollision = true;
                  collisionPoint = Vector3f.add(p1, new Vector3f(f * edge.x, f * edge.y, f * edge.z), (Vector3f)null);
               }
            }

            edge = Vector3f.sub(p3, p2, (Vector3f)null);
            baseToVertex = Vector3f.sub(p2, base, (Vector3f)null);
            edgeSquaredLength = edge.lengthSquared();
            edgeDotVelocity = Vector3f.dot(edge, velocity);
            edgeDotBaseToVertex = Vector3f.dot(edge, baseToVertex);
            a = edgeSquaredLength * -velocitySquaredLength + edgeDotVelocity * edgeDotVelocity;
            b = edgeSquaredLength * 2.0F * Vector3f.dot(velocity, baseToVertex) - 2.0F * edgeDotVelocity * edgeDotBaseToVertex;
            c = edgeSquaredLength * (1.0F - baseToVertex.lengthSquared()) + edgeDotBaseToVertex * edgeDotBaseToVertex;
            if (this.getLowestRoot(a, b, c, t) != 1.23456792E8F) {
               newT = this.getLowestRoot(a, b, c, t);
               f = (edgeDotVelocity * newT - edgeDotBaseToVertex) / edgeSquaredLength;
               if ((double)f >= 0.0D && (double)f <= 1.0D) {
                  t = newT;
                  foundCollision = true;
                  collisionPoint = Vector3f.add(p2, new Vector3f(f * edge.x, f * edge.y, f * edge.z), (Vector3f)null);
               }
            }

            edge = Vector3f.sub(p1, p3, (Vector3f)null);
            baseToVertex = Vector3f.sub(p3, base, (Vector3f)null);
            edgeSquaredLength = edge.lengthSquared();
            edgeDotVelocity = Vector3f.dot(edge, velocity);
            edgeDotBaseToVertex = Vector3f.dot(edge, baseToVertex);
            a = edgeSquaredLength * -velocitySquaredLength + edgeDotVelocity * edgeDotVelocity;
            b = edgeSquaredLength * 2.0F * Vector3f.dot(velocity, baseToVertex) - 2.0F * edgeDotVelocity * edgeDotBaseToVertex;
            c = edgeSquaredLength * (1.0F - baseToVertex.lengthSquared()) + edgeDotBaseToVertex * edgeDotBaseToVertex;
            if (this.getLowestRoot(a, b, c, t) != 1.23456792E8F) {
               newT = this.getLowestRoot(a, b, c, t);
               f = (edgeDotVelocity * newT - edgeDotBaseToVertex) / edgeSquaredLength;
               if ((double)f >= 0.0D && (double)f <= 1.0D) {
                  t = newT;
                  foundCollision = true;
                  collisionPoint = Vector3f.add(p3, new Vector3f(f * edge.x, f * edge.y, f * edge.z), (Vector3f)null);
               }
            }
         }

         if (foundCollision) {
            float distToCollision = t * test.velocity.length();
            if (!test.didCollide || (double)distToCollision < test.nearestDistance) {
               test.nearestDistance = (double)distToCollision;
               test.intersectionPoint = collisionPoint;
               test.didCollide = true;
            }
         }
      }

   }

   public float getLowestRoot(float a, float b, float c, float maxR) {
      float determinant = b * b - 4.0F * a * c;
      if (determinant < 0.0F) {
         return 1.23456792E8F;
      } else {
         float sqrtD = (float)Math.sqrt((double)determinant);
         float r1 = (-b - sqrtD) / (2.0F * a);
         float r2 = (-b + sqrtD) / (2.0F * a);
         if (r1 > r2) {
            float temp = r2;
            r2 = r1;
            r1 = temp;
         }

         if (r1 > 0.0F && r1 < maxR) {
            return r1;
         } else {
            return r2 > 0.0F && r2 < maxR ? r2 : 1.23456792E8F;
         }
      }
   }

   public boolean checkPointInTriangle(Vector3f point, Vector3f p1, Vector3f p2, Vector3f p3) {
      Vector3f edge1 = Vector3f.sub(p2, p1, (Vector3f)null);
      Vector3f edge2 = Vector3f.sub(p3, p1, (Vector3f)null);
      float a = Vector3f.dot(edge1, edge1);
      float b = Vector3f.dot(edge1, edge2);
      float c = Vector3f.dot(edge2, edge2);
      float acSUBbb = a * c - b * b;
      Vector3f vp = new Vector3f(point.x - p1.x, point.y - p1.y, point.z - p1.z);
      float d = Vector3f.dot(vp, edge1);
      float e = Vector3f.dot(vp, edge2);
      float x = d * c - e * b;
      float y = e * a - d * b;
      float z = x + y - acSUBbb;
      return z < 0.0F && x >= 0.0F && y >= 0.0F;
   }

   public Vector3f ConvertR3ToESpace(Vector3f r3) {
      return new Vector3f(1.0F / this.eRad.x * r3.x, 1.0F / this.eRad.y * r3.y, 1.0F / this.eRad.z * r3.z);
   }

   public Vector3f ConvertESpaceToR3(Vector3f esp) {
      return new Vector3f(esp.x / (1.0F / this.eRad.x), esp.y / (1.0F / this.eRad.y), esp.z / (1.0F / this.eRad.z));
   }
}
