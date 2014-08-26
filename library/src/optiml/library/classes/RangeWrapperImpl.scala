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

trait RangeWrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def infix_foreach_impl(__arg0: Rep[Range],__arg1: (Rep[Int]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit] = {
    range_foreach(range_start(__arg0), range_end(__arg0), 1, __arg1)
  }

}
