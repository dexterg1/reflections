import models.Plane
import models.rays.{Vector, Point}

object Main extends App {



  val vec = Vector(Point(0, 0, 1), Point(-1, 0, -1).normal)

  println ("Normalised "+ Point(-1, 0, -1).normal )

  val plane = Plane(Point(0, 0, 0), Point(0, 0, 1))

  val intersection = plane.intersection(vec)

  println (s"Incident ${ray}  Reflected: ${plane.reflect(vec)} ")



}
