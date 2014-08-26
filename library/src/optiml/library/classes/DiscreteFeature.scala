package optiml.library.classes

import scala.reflect.{Manifest,SourceContext}
import scala.math.Ordering.Implicits._
import scala.math.Numeric.Implicits._
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._
import optiml.library._
import optiml.library.classes._

trait DiscreteFeatureWrapper {
  this: OptiMLBase with OptiMLClasses => 

class DiscreteFeature(___features: ForgeHashMap[String,Int]) {
  var _features = ___features

}

  def discrete_feature_alloc(__arg0: Rep[ForgeHashMap[String,Int]])(implicit __pos: SourceContext) = {
    new DiscreteFeature(__arg0)
  }
  def discretefeature_object_apply(__arg0: Seq[Rep[String]])(implicit __pos: SourceContext) = {
    discretefeature_object_apply_impl5(__arg0)(__pos)
  }
  def getFeatures(self: Rep[DiscreteFeature])(implicit __pos: SourceContext) = {
    self._features
  }
  def discretefeature_apply(self: Rep[DiscreteFeature],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    discretefeature_apply_impl3(self,__arg1)(__pos)
  }
  def discretefeature_indicator(self: Rep[DiscreteFeature],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    discretefeature_indicator_impl(self,__arg1)(__pos)
  }

}

