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

trait BinaryFeatureOpsImpl {
  this: OptiMLCompiler with OptiMLLift => 

  def binaryfeature_apply_impl10(self: Rep[BinaryFeature],__arg1: Rep[String])(implicit __pos: SourceContext): Rep[Int] = {
    fassert(__arg1.toInt == 0 || __arg1.toInt == 1, "illegal input to binary feature")
    __arg1.toInt
  }

}
