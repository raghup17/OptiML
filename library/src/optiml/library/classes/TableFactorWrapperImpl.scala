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

trait TableFactorWrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def tablefactor_assignmenttoindex_impl(__arg0: Rep[DenseVector[Int]])(implicit __pos: SourceContext): Rep[Int] = {
    fatal("TBD")
  }

  def tablefactor_indextoassignment_impl(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    fatal("TBD")
  }

}
