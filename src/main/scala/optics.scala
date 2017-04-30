import models_v2._

import org.apache.commons.math3.fitting.{GaussianFitter,PolynomialCurveFitter,WeightedObservedPoints}
import org.apache.commons.math3.optim.nonlinear.vector.jacobian.LevenbergMarquardtOptimizer
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction
object Main extends App {

  val p2 = Plane.fromPointAndVector(Point(0,0,0), Vector(0,1,1))

  val rays: Seq[Ray] = for { i <- -1 to 1 by 1} yield ( Ray.fromPointAndVec(Point(0, i, 100), Vector(0,0,-1)) )
  rays.map( r => p2.reflect(r)).foreach(println)


  val fitter = new GaussianFitter(
    new LevenbergMarquardtOptimizer());

  fitter.addObservedPoint(1, 2);
  fitter.addObservedPoint(2, 4);
  fitter.addObservedPoint(3, 6);
  fitter.addObservedPoint(4, 8);
  fitter.addObservedPoint(5, 10);
  fitter.addObservedPoint(6, 12);
  fitter.addObservedPoint(7, 14);

  val f1: Array[Double]  = fitter.fit()

  println(f1.toSeq.mkString(", "))



  val fit2 = PolynomialCurveFitter.create(10)

  val obs = new WeightedObservedPoints();


  for{n <- 0.0 to 5.0 by 0.01} yield ( obs.add(n,n*2) )

  val f2 = fit2.fit(obs.toList())

  println(f2.toSeq.mkString(", "))

  val pf = new PolynomialFunction(f2)




  println( pf.value(2.5))
  println( pf.value(2.75))
  println( pf.value(3.0))

}
