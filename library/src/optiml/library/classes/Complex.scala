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

trait ComplexWrapper {
  this: OptiMLBase with OptiMLClasses => 

class Complex(___real: Double, ___imag: Double) {
  var _real = ___real
  var _imag = ___imag

}

  def complex_object_apply(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    new Complex(__arg0,__arg1)
  }
  def complex_real(self: Rep[Complex])(implicit __pos: SourceContext) = {
    self._real
  }
  def complex_imag(self: Rep[Complex])(implicit __pos: SourceContext) = {
    self._imag
  }
  def complex_conj(self: Rep[Complex])(implicit __pos: SourceContext) = {
    complex_conj_impl(self)(__pos)
  }
  def complex_pl(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext) = {
    complex_pl_impl1(self,__arg1)(__pos)
  }
  def complex_sub(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext) = {
    complex_sub_impl1(self,__arg1)(__pos)
  }
  def complex_mul(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext) = {
    complex_mul_impl1(self,__arg1)(__pos)
  }
  def complex_div(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext) = {
    complex_div_impl1(self,__arg1)(__pos)
  }
  def complex_abs(self: Rep[Complex])(implicit __pos: SourceContext) = {
    complex_abs_impl1(self)(__pos)
  }
  def complex_exp(self: Rep[Complex])(implicit __pos: SourceContext) = {
    complex_exp_impl1(self)(__pos)
  }
  def complex_log(self: Rep[Complex])(implicit __pos: SourceContext) = {
    complex_log_impl1(self)(__pos)
  }
  def complex___equal(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext) = {
    complex___equal_impl3(self,__arg1)(__pos)
  }

}

