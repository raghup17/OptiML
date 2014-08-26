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

trait ContinuousFeatureWrapper {
  this: OptiMLBase with OptiMLClasses => 

class ContinuousFeature(___min: Double, ___max: Double) {
  var _min = ___min
  var _max = ___max

}

  def continuousfeature_object_apply(min: Rep[Double] = math_ninf(),max: Rep[Double] = math_inf())(implicit __pos: SourceContext) = {
    def __imp1 = ()
    new ContinuousFeature(min,max)
  }
  def continuousfeature_min(self: Rep[ContinuousFeature])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._min
  }
  def continuousfeature_max(self: Rep[ContinuousFeature])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._max
  }
  def continuousfeature_apply(self: Rep[ContinuousFeature],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    continuousfeature_apply_impl2(self,__arg1)(__pos)
  }

}

