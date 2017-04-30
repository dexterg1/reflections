

object Main extends App {
//Added by lenovo
//  import models.Plane
//  import models.rays.{Vector, Point}
//
//  val vec = Vector(Point(0, 0, 1), Point(-1, 0, -1).normal)
//
//  println ("Normalised "+ Point(-1, 0, -1).normal )
//
//  val plane = Plane(Point(0, 0, 0), Point(0, 0, 1))
//
//  val intersection = plane.intersection(vec)
//
//  println (s"Incident ${vec}  Reflected: ${plane.reflect(vec)} ")


  import models_v2.Plane
  import models_v2._

  val vec = Vector(0,0,2)

  val plane = Plane(Point(100, 1, 0), Vector(0, 0, 1).normal)

  val ray = Ray(Point(0,0,1),Vector(-1,0,-1))

  println(plane.intersection(ray))

  println(plane.reflect(ray))

}
