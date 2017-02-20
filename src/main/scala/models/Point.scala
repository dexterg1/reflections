package models.rays


import scala.math._

case class Point(x: Double, y: Double, z: Double) {

  lazy val magnitude: Double = sqrt(pow(x, 2) + pow(y, 2) + pow(z, 2))

  lazy val normal = Point(x / magnitude, y / magnitude, z / magnitude)

  def *(b: Double) = applyAll(b, (a, b) => a * b)

  def +(b: Point) = Point(this.x + b.x, this.y + b.y, this.z + b.z)

  def -(b: Point) = Point(this.x - b.x, this.y - b.y, this.z - b.z)

  def dot(b: Point): Double = (this.x * b.x) + (this.y * b.y) + (this.z * b.z)

  def applyAll(value: Double, fn: (Double, Double) => Double) = Point(fn(value, x), fn(value, y), fn(value, z))

}

case class Vector(pos: Point, dir: Point) {
 def extend(distance: Double) = (dir.normal * distance) + pos
}