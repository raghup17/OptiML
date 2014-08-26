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

trait WeightWrapper {
  this: OptiMLBase with OptiMLClasses => 

class Weight(___id: Int, ___value: Double, ___isFixed: Boolean) {
  var _id = ___id
  var _value = ___value
  var _isFixed = ___isFixed

}

  def weight_object_apply(id: Rep[Int],value: Rep[Double],isFixed: Rep[Boolean])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    new Weight(id,value,isFixed)
  }
  def weight_id(self: Rep[Weight])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._id
  }
  def weight_value(self: Rep[Weight])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._value
  }
  def weight_isfixed(self: Rep[Weight])(implicit __pos: SourceContext) = {
    self._isFixed
  }

}

