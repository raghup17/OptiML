package optiml.shared.ops

import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._

/**
 * Operations
 */

trait TableFactorOps extends Base {
  this: OptiML => 

  object TableFactor {
    def apply(vars: Rep[DenseVector[FactorVariable]],vals: Rep[DenseVector[Double]])(implicit __pos: SourceContext,__imp1: Overload1) = tablefactor_object_apply(vars,vals)(__pos)
  }

  def assignmentToIndex(__arg0: Rep[DenseVector[Int]])(implicit __pos: SourceContext) = tablefactor_assignmenttoindex(__arg0)(__pos)
  def indexToAssignment(__arg0: Rep[Int])(implicit __pos: SourceContext) = tablefactor_indextoassignment(__arg0)(__pos)

  def infix_vars(self: Rep[TableFactor])(implicit __pos: SourceContext,__imp1: Overload1) = tablefactor_vars(self)(__pos)
  def infix_vals(self: Rep[TableFactor])(implicit __pos: SourceContext) = tablefactor_vals(self)(__pos)

  def tablefactor_object_apply(vars: Rep[DenseVector[FactorVariable]],vals: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[TableFactor]
  def tablefactor_assignmenttoindex(__arg0: Rep[DenseVector[Int]])(implicit __pos: SourceContext): Rep[Int]
  def tablefactor_indextoassignment(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVector[Int]]
  def tablefactor_vars(self: Rep[TableFactor])(implicit __pos: SourceContext): Rep[DenseVector[FactorVariable]]
  def tablefactor_vals(self: Rep[TableFactor])(implicit __pos: SourceContext): Rep[DenseVector[Double]]
}
