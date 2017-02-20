
package models

import java.util.Random

import models.rays.Vector
import models.rays.Point


trait Source {

  def emit(): Vector

}


case class RectangleSource (width: Double, length: Double, vec: Vector) extends Source{
  val currentTime = System.currentTimeMillis()
  val rand = new Random(currentTime)

  override def emit() = {
    val rx = length * ( 2 * rand.nextDouble() - 1 ) / 2
    val ry = width * ( 2 * rand.nextDouble() - 1 ) / 2

    //TODO tie to translation and rotation applied to source. pos and dir to be superceded

    Vector( vec.pos + Point(length, width, 0), vec.dir )

  }

}


