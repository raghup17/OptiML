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

trait FactorVariableWrapper {
  this: OptiMLBase with OptiMLClasses => 

class FactorVariable(___id: Int, ___isPositive: Boolean, ___domain: DenseVector[Double], ___position: Int) {
  var _id = ___id
  var _isPositive = ___isPositive
  var _domain = ___domain
  var _position = ___position

}

  def factorvariable_object_apply(id: Rep[Int],isPositive: Rep[Boolean],domain: Rep[DenseVector[Double]],position: Rep[Int])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    new FactorVariable(id,isPositive,domain,position)
  }
  def factorvariable_id(self: Rep[FactorVariable])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._id
  }
  def factorvariable_ispositive(self: Rep[FactorVariable])(implicit __pos: SourceContext) = {
    self._isPositive
  }
  def factorvariable_domain(self: Rep[FactorVariable])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._domain
  }
  def factorvariable_position(self: Rep[FactorVariable])(implicit __pos: SourceContext) = {
    self._position
  }

}

