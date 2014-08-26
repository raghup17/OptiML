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

trait BinaryFeatureWrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def binaryfeature_apply_impl10(self: Rep[BinaryFeature],__arg1: Rep[String])(implicit __pos: SourceContext): Rep[Int] = {
    fassert(__arg1.toInt == 0 || __arg1.toInt == 1, "illegal input to binary feature")
    __arg1.toInt
  }

}
