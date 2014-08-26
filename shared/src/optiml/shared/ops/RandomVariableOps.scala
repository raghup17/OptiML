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

trait RandomVariableOps extends Base {
  this: OptiML => 

  object RandomVariable {
    def apply(id: Rep[Int],domain: Rep[DenseVector[Double]],value: Rep[Double],isEvidence: Rep[Boolean],isQuery: Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload19) = randomvariable_object_apply(id,domain,value,isEvidence,isQuery)(__pos)
  }

  def infix_id(self: Rep[RandomVariable])(implicit __pos: SourceContext,__imp1: Overload4) = randomvariable_id(self)(__pos)
  def infix_domain(self: Rep[RandomVariable])(implicit __pos: SourceContext,__imp1: Overload2) = randomvariable_domain(self)(__pos)
  def infix_value(self: Rep[RandomVariable])(implicit __pos: SourceContext,__imp1: Overload2) = randomvariable_value(self)(__pos)
  def infix_isEvidence(self: Rep[RandomVariable])(implicit __pos: SourceContext) = randomvariable_isevidence(self)(__pos)
  def infix_isQuery(self: Rep[RandomVariable])(implicit __pos: SourceContext) = randomvariable_isquery(self)(__pos)

  def randomvariable_object_apply(id: Rep[Int],domain: Rep[DenseVector[Double]],value: Rep[Double],isEvidence: Rep[Boolean],isQuery: Rep[Boolean])(implicit __pos: SourceContext): Rep[RandomVariable]
  def randomvariable_id(self: Rep[RandomVariable])(implicit __pos: SourceContext): Rep[Int]
  def randomvariable_domain(self: Rep[RandomVariable])(implicit __pos: SourceContext): Rep[DenseVector[Double]]
  def randomvariable_value(self: Rep[RandomVariable])(implicit __pos: SourceContext): Rep[Double]
  def randomvariable_isevidence(self: Rep[RandomVariable])(implicit __pos: SourceContext): Rep[Boolean]
  def randomvariable_isquery(self: Rep[RandomVariable])(implicit __pos: SourceContext): Rep[Boolean]
}
