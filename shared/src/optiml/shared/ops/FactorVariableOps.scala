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

trait FactorVariableOps extends Base {
  this: OptiML => 

  object FactorVariable {
    def apply(id: Rep[Int],isPositive: Rep[Boolean],domain: Rep[DenseVector[Double]],position: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload17) = factorvariable_object_apply(id,isPositive,domain,position)(__pos)
  }

  def infix_id(self: Rep[FactorVariable])(implicit __pos: SourceContext,__imp1: Overload3) = factorvariable_id(self)(__pos)
  def infix_isPositive(self: Rep[FactorVariable])(implicit __pos: SourceContext) = factorvariable_ispositive(self)(__pos)
  def infix_domain(self: Rep[FactorVariable])(implicit __pos: SourceContext,__imp1: Overload1) = factorvariable_domain(self)(__pos)
  def infix_position(self: Rep[FactorVariable])(implicit __pos: SourceContext) = factorvariable_position(self)(__pos)

  def factorvariable_object_apply(id: Rep[Int],isPositive: Rep[Boolean],domain: Rep[DenseVector[Double]],position: Rep[Int])(implicit __pos: SourceContext): Rep[FactorVariable]
  def factorvariable_id(self: Rep[FactorVariable])(implicit __pos: SourceContext): Rep[Int]
  def factorvariable_ispositive(self: Rep[FactorVariable])(implicit __pos: SourceContext): Rep[Boolean]
  def factorvariable_domain(self: Rep[FactorVariable])(implicit __pos: SourceContext): Rep[DenseVector[Double]]
  def factorvariable_position(self: Rep[FactorVariable])(implicit __pos: SourceContext): Rep[Int]
}
