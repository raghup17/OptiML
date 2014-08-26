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

trait ContinuousFeatureOps extends Base {
  this: OptiML => 

  object ContinuousFeature {
    def apply(min: Rep[Double] = math_ninf(),max: Rep[Double] = math_inf())(implicit __pos: SourceContext,__imp1: Overload4) = continuousfeature_object_apply(min,max)(__pos)
  }

  implicit def repToContinuousFeatureContinuousFeatureOpsCls(x: Rep[ContinuousFeature])(implicit __pos: SourceContext) = new ContinuousFeatureContinuousFeatureOpsCls(x)(__pos)
  implicit def varToContinuousFeatureContinuousFeatureOpsCls(x: Var[ContinuousFeature])(implicit __pos: SourceContext) = new ContinuousFeatureContinuousFeatureOpsCls(readVar(x))(__pos)

  class ContinuousFeatureContinuousFeatureOpsCls(val self: Rep[ContinuousFeature])(implicit __pos: SourceContext) {
    def apply(__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: Overload2) = continuousfeature_apply(self,__arg1)(__pos)
  }


  def infix_min(self: Rep[ContinuousFeature])(implicit __pos: SourceContext,__imp1: Overload1) = continuousfeature_min(self)(__pos)
  def infix_max(self: Rep[ContinuousFeature])(implicit __pos: SourceContext,__imp1: Overload1) = continuousfeature_max(self)(__pos)

  def continuousfeature_object_apply(min: Rep[Double] = math_ninf(),max: Rep[Double] = math_inf())(implicit __pos: SourceContext): Rep[ContinuousFeature]
  def continuousfeature_min(self: Rep[ContinuousFeature])(implicit __pos: SourceContext): Rep[Double]
  def continuousfeature_max(self: Rep[ContinuousFeature])(implicit __pos: SourceContext): Rep[Double]
  def continuousfeature_apply(self: Rep[ContinuousFeature],__arg1: Rep[String])(implicit __pos: SourceContext): Rep[Double]
}
