package models_v2

case class Point(x: Double, y: Double, z: Double) {
  def -(b: Point): Vector = Vector(this.x - b.x, this.y - b.y, this.z - b.z)
  def distance(b: Point): Double = (this - b).magnitude
}

