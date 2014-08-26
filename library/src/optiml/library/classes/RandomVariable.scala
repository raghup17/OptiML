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

trait RandomVariableWrapper {
  this: OptiMLBase with OptiMLClasses => 

class RandomVariable(___id: Int, ___domain: DenseVector[Double], ___value: Double, ___isEvidence: Boolean, ___isQuery: Boolean) {
  var _id = ___id
  var _domain = ___domain
  var _value = ___value
  var _isEvidence = ___isEvidence
  var _isQuery = ___isQuery

}

  def randomvariable_object_apply(id: Rep[Int],domain: Rep[DenseVector[Double]],value: Rep[Double],isEvidence: Rep[Boolean],isQuery: Rep[Boolean])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    new RandomVariable(id,domain,value,isEvidence,isQuery)
  }
  def randomvariable_id(self: Rep[RandomVariable])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._id
  }
  def randomvariable_domain(self: Rep[RandomVariable])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._domain
  }
  def randomvariable_value(self: Rep[RandomVariable])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._value
  }
  def randomvariable_isevidence(self: Rep[RandomVariable])(implicit __pos: SourceContext) = {
    self._isEvidence
  }
  def randomvariable_isquery(self: Rep[RandomVariable])(implicit __pos: SourceContext) = {
    self._isQuery
  }

}

