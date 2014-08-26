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

trait TableFactorOpsImpl {
  this: OptiMLCompiler with OptiMLLift => 

  def tablefactor_assignmenttoindex_impl(__arg0: Rep[DenseVector[Int]])(implicit __pos: SourceContext): Rep[Int] = {
    fatal("TBD")
  }

  def tablefactor_indextoassignment_impl(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    fatal("TBD")
  }

}
