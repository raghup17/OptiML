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

trait ComplexOps extends Base {
  this: OptiML => 

  object Complex {
    def apply(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: Overload3) = complex_object_apply(__arg0,__arg1)(__pos)
  }

  def __equal(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext,__imp1: Overload3) = complex___equal(self,__arg1)(__pos)

  implicit def repToComplexComplexOpsCls(x: Rep[Complex])(implicit __pos: SourceContext) = new ComplexComplexOpsCls(x)(__pos)
  implicit def varToComplexComplexOpsCls(x: Var[Complex])(implicit __pos: SourceContext) = new ComplexComplexOpsCls(readVar(x))(__pos)

  class ComplexComplexOpsCls(val self: Rep[Complex])(implicit __pos: SourceContext) {
    def -(__arg1: Rep[Complex])(implicit __pos: SourceContext,__imp1: Overload1) = complex_sub(self,__arg1)(__pos)
    def *(__arg1: Rep[Complex])(implicit __pos: SourceContext,__imp1: Overload1) = complex_mul(self,__arg1)(__pos)
    def /(__arg1: Rep[Complex])(implicit __pos: SourceContext,__imp1: Overload1) = complex_div(self,__arg1)(__pos)
  }


  def infix_real(self: Rep[Complex])(implicit __pos: SourceContext) = complex_real(self)(__pos)
  def infix_imag(self: Rep[Complex])(implicit __pos: SourceContext) = complex_imag(self)(__pos)
  def infix_conj(self: Rep[Complex])(implicit __pos: SourceContext) = complex_conj(self)(__pos)
  def infix_+(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext,__imp1: Overload1) = complex_pl(self,__arg1)(__pos)
  def infix_abs(self: Rep[Complex])(implicit __pos: SourceContext,__imp1: Overload1) = complex_abs(self)(__pos)
  def infix_exp(self: Rep[Complex])(implicit __pos: SourceContext,__imp1: Overload1) = complex_exp(self)(__pos)
  def infix_log(self: Rep[Complex])(implicit __pos: SourceContext,__imp1: Overload1) = complex_log(self)(__pos)

  def complex_object_apply(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext): Rep[Complex]
  def complex_real(self: Rep[Complex])(implicit __pos: SourceContext): Rep[Double]
  def complex_imag(self: Rep[Complex])(implicit __pos: SourceContext): Rep[Double]
  def complex_conj(self: Rep[Complex])(implicit __pos: SourceContext): Rep[Complex]
  def complex_pl(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext): Rep[Complex]
  def complex_sub(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext): Rep[Complex]
  def complex_mul(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext): Rep[Complex]
  def complex_div(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext): Rep[Complex]
  def complex_abs(self: Rep[Complex])(implicit __pos: SourceContext): Rep[Complex]
  def complex_exp(self: Rep[Complex])(implicit __pos: SourceContext): Rep[Complex]
  def complex_log(self: Rep[Complex])(implicit __pos: SourceContext): Rep[Complex]
  def complex___equal(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext): Rep[Boolean]
}
