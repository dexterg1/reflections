package models_v2

import scala.math._

case class Vector(x: Double, y: Double, z: Double) {

  lazy val magnitude: Double = sqrt(pow(x, 2) + pow(y, 2) + pow(z, 2))

  lazy val normalised: Vector = this * (1.0 / magnitude)

  def dot(b: Vector): Double = (this.x * b.x) + (this.y * b.y) + (this.z * b.z)

  def *(value: Double) = Vector(x * value, y * value, z * value)

  def +(b: Vector) = Vector(this.x + b.x, this.y + b.y, this.z + b.z)

  def -(b: Vector) = Vector(this.x - b.x, this.y - b.y, this.z - b.z)

}

