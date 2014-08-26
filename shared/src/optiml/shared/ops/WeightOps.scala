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

trait WeightOps extends Base {
  this: OptiML => 

  object Weight {
    def apply(id: Rep[Int],value: Rep[Double],isFixed: Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload11) = weight_object_apply(id,value,isFixed)(__pos)
  }

  def infix_id(self: Rep[Weight])(implicit __pos: SourceContext,__imp1: Overload1) = weight_id(self)(__pos)
  def infix_value(self: Rep[Weight])(implicit __pos: SourceContext,__imp1: Overload1) = weight_value(self)(__pos)
  def infix_isFixed(self: Rep[Weight])(implicit __pos: SourceContext) = weight_isfixed(self)(__pos)

  def weight_object_apply(id: Rep[Int],value: Rep[Double],isFixed: Rep[Boolean])(implicit __pos: SourceContext): Rep[Weight]
  def weight_id(self: Rep[Weight])(implicit __pos: SourceContext): Rep[Int]
  def weight_value(self: Rep[Weight])(implicit __pos: SourceContext): Rep[Double]
  def weight_isfixed(self: Rep[Weight])(implicit __pos: SourceContext): Rep[Boolean]
}
