package models
import models.rays.{Vector, Point}

case class Plane(pos: Point, dir: Point) {

  def intersection(vec: Vector): Option[Point] = {
      if( dir.dot(vec.dir) == 0 ){
        None
      }else{
        val distance = (pos - vec.pos).dot(dir.normal) / vec.dir.normal.dot(dir.normal)
        Some(vec.extend(distance))
      }
  }

  def reflect(vec: Vector): Option[Vector] = {
    intersection(vec).map { intersect =>
      //Ray( r, ray.dir - (dir * ray.dir.dot(dir)) * 2)
      val reflect = vec.dir - ( dir * ( 2 * vec.dir.dot(dir) ) )
      Vector(intersect,reflect)
    }
  }

}

