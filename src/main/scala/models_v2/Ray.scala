package models_v2

case class Ray(point: Point, vec: Vector) {
  require(vec.magnitude < Error.magMax && vec.magnitude > Error.magMin)
  def extend(distance: Double): Point = Point(point.x + (vec.normalised.x * distance), point.y + (vec.normalised.y * distance), point.z + (vec.normalised.z * distance))
}

object Ray{
  def fromPointAndVec(point: Point, vec: Vector): Ray = {
    Ray(point, vec.normalised)
  }
}