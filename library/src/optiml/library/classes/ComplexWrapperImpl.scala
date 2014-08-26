package optiml.library.classes

import scala.reflect.{Manifest,SourceContext}
import scala.math.Ordering.Implicits._
import scala.math.Numeric.Implicits._
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._
import optiml.library._
import optiml.library.classes._

/**
 * SingleTask and Composite Impls
 */

trait ComplexWrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def complex_conj_impl(self: Rep[Complex])(implicit __pos: SourceContext): Rep[Complex] = {
    Complex(self.real, -self.imag)
  }

  def complex_pl_impl1(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext): Rep[Complex] = {
    Complex(self.real+__arg1.real, self.imag+__arg1.imag)
  }

  def complex_sub_impl1(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext): Rep[Complex] = {
    Complex(self.real-__arg1.real, self.imag-__arg1.imag)
  }

  def complex_mul_impl1(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext): Rep[Complex] = {
    Complex(self.real*__arg1.real - self.imag*__arg1.imag, self.real*__arg1.imag+self.imag*__arg1.real)
  }

  def complex_div_impl1(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext): Rep[Complex] = {
    Complex((self.real*__arg1.real+self.imag*__arg1.imag)/(square(__arg1.real)+square(__arg1.imag)), (self.imag*__arg1.real-self.real*__arg1.imag)/(square(__arg1.real)+square(__arg1.imag)))
  }

  def complex_abs_impl1(self: Rep[Complex])(implicit __pos: SourceContext): Rep[Complex] = {
    Complex(sqrt(square(self.real)+square(self.imag)), unit(0.0))
  }

  def complex_exp_impl1(self: Rep[Complex])(implicit __pos: SourceContext): Rep[Complex] = {
    Complex(exp(self.real)*cos(self.imag), exp(self.real)*sin(self.imag))
  }

  def complex_log_impl1(self: Rep[Complex])(implicit __pos: SourceContext): Rep[Complex] = {
    Complex(log(sqrt(square(self.real)+square(self.imag))), atan2(self.imag, self.real))
  }

  def complex___equal_impl3(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext): Rep[Boolean] = {
    self.real == __arg1.real && self.imag == __arg1.imag
  }

}
