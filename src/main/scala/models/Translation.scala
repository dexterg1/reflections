package models

import models.rays.Point


sealed trait Axis {
  def name: String
  override def toString(): String = name
}

case object X extends Axis { override val name = "X-Axis" }
case object Y extends Axis { override val name = "Y-Axis" }
case object Z extends Axis { override val name = "Z-Axis" }






case class Matrix private(val rows: Seq[Seq[Int]]){



  def * (translationMatrix: Matrix): Option[Matrix]
}

//trait TranslationMatrix{
//  def * (translationMatrix: TranslationMatrix): TranslationMatrix
//  def * ()
//  def apply(point: Point): Point
//}



case class Rotation(angle: Double, axis: Axis) {

}

case class Position(x: Double, y: Double, z: Double) {

}