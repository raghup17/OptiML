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

trait DiscreteFeatureOps extends Base {
  this: OptiML => 

  object DiscreteFeature {
    def apply(__arg0: Rep[String]*)(implicit __pos: SourceContext,__imp1: Overload5) = discretefeature_object_apply(__arg0)(__pos)
  }

  implicit def repToDiscreteFeatureDiscreteFeatureOpsCls(x: Rep[DiscreteFeature])(implicit __pos: SourceContext) = new DiscreteFeatureDiscreteFeatureOpsCls(x)(__pos)
  implicit def varToDiscreteFeatureDiscreteFeatureOpsCls(x: Var[DiscreteFeature])(implicit __pos: SourceContext) = new DiscreteFeatureDiscreteFeatureOpsCls(readVar(x))(__pos)

  class DiscreteFeatureDiscreteFeatureOpsCls(val self: Rep[DiscreteFeature])(implicit __pos: SourceContext) {
    def apply(__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: Overload3) = discretefeature_apply(self,__arg1)(__pos)
  }


  def infix_indicator(self: Rep[DiscreteFeature],__arg1: Rep[String])(implicit __pos: SourceContext) = discretefeature_indicator(self,__arg1)(__pos)

  def discretefeature_object_apply(__arg0: Seq[Rep[String]])(implicit __pos: SourceContext): Rep[DiscreteFeature]
  def discretefeature_apply(self: Rep[DiscreteFeature],__arg1: Rep[String])(implicit __pos: SourceContext): Rep[Int]
  def discretefeature_indicator(self: Rep[DiscreteFeature],__arg1: Rep[String])(implicit __pos: SourceContext): Rep[DenseVector[Int]]
}
trait DiscreteFeatureCompilerOps extends DiscreteFeatureOps {
  this: OptiML => 

  def discrete_feature_alloc(__arg0: Rep[ForgeHashMap[String,Int]])(implicit __pos: SourceContext): Rep[DiscreteFeature]
  def getFeatures(self: Rep[DiscreteFeature])(implicit __pos: SourceContext): Rep[ForgeHashMap[String,Int]]
}

