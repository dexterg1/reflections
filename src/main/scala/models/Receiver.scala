package models

import models.rays.{Vector, Point}



/*
A square receiver surface centered at pos facing dir of equal length sides. It is divided in N x N bins that record the cumulative incident intensity where N = granularity.
 */
case class Receiver(pos: Point, dir: Point, side: Double, granularity: Int) {



  def intersection(ray: Vector): Option[Point] = {
    if( dir.dot(ray.dir) == 0 ){
      None
    }else{
      val distance = (pos - ray.pos).dot(dir.normal) / ray.dir.normal.dot(dir.normal)
      Some(ray.extend(distance))
    }
  }



}