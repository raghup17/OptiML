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

trait ContinuousFeatureWrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def continuousfeature_apply_impl2(self: Rep[ContinuousFeature],__arg1: Rep[String])(implicit __pos: SourceContext): Rep[Double] = {
    val num = __arg1.toDouble
    if (num < self.min) { self.min }
    else if (num > self.max) { self.max }
    else num
  }

}
