package optiml.compiler.ops

import scala.reflect.{Manifest,SourceContext}
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._
import optiml.compiler._
import optiml.compiler.ops._

/**
 * Op Impls
 */

trait ContinuousFeatureOpsImpl {
  this: OptiMLCompiler with OptiMLLift => 

  def continuousfeature_apply_impl2(self: Rep[ContinuousFeature],__arg1: Rep[String])(implicit __pos: SourceContext): Rep[Double] = {
    val num = __arg1.toDouble
    if (num < self.min) { self.min }
    else if (num > self.max) { self.max }
    else num
  }

}
