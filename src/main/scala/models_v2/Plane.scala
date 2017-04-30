package models_v2

case class Plane(pos: Point, dir: Vector) {

  def intersection(ray: Ray): Option[Point] = {
    if( dir.dot(ray.vec.normal) == 0 ){
      None
    }else{
      val distance = (pos - ray.point).dot(dir.normal) / ray.vec.normal.dot(dir.normal)
      Some(ray.extend(distance))
    }
  }

  def reflect(ray: Ray): Option[Ray] = {
    intersection(ray).map { intersect =>
      //Ray( r, ray.dir - (dir * ray.dir.dot(dir)) * 2)
      val reflect = ray.vec - ( dir * ( 2 * ray.vec.dot(dir) ) )
      Ray(intersect,reflect)
    }
  }

}
