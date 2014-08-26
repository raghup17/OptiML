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

trait RangeOpsImpl {
  this: OptiMLCompiler with OptiMLLift => 

  def infix_foreach_impl(__arg0: Rep[Range], step: Int, __arg1: (Rep[Int]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit] = {
    range_foreach(range_start(__arg0), range_end(__arg0), step, __arg1)
  }

}
