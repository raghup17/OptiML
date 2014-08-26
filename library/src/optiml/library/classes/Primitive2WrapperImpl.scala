package optiml.library.classes

import scala.reflect.{Manifest,SourceContext}
import scala.math.Ordering.Implicits._
import scala.math.Numeric.Implicits._
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._
import optiml.library._
import optiml.library.classes._

/**
 * SingleTask and Composite Impls
 */

trait Primitive2WrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def primitive2_repint2torepdouble_impl(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[Double] = {
    __arg0.toDouble
  }

  def primitive2_repint2torepfloat_impl(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[Float] = {
    __arg0.toFloat
  }

  def primitive2_repfloat2torepdouble_impl(__arg0: Rep[Float])(implicit __pos: SourceContext): Rep[Double] = {
    __arg0.toDouble
  }

  def primitive2_dist_impl1(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Double] = {
    abs(__arg0-__arg1)
  }

  def primitive2_dist_impl2(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext): Rep[Double] = {
    abs(__arg0-__arg1)
  }

}
