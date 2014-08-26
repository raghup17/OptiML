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

trait Primitive2Wrapper {
  this: OptiMLBase with OptiMLClasses => 

  def primitive2_unary_bang(__arg0: Rep[Boolean])(implicit __pos: SourceContext) = {
    !__arg0
  }
  def primitive2_oror(__arg0: Rep[Boolean],__arg1: Rep[Boolean])(implicit __pos: SourceContext) = {
    __arg0 || __arg1
  }
  def primitive2_andand(__arg0: Rep[Boolean],__arg1: Rep[Boolean])(implicit __pos: SourceContext) = {
    __arg0 && __arg1
  }
  def primitive2_toint[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = {
    __arg0.toInt
  }
  def primitive2_tofloat[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = {
    __arg0.toFloat
  }
  def primitive2_todouble[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = {
    __arg0.toDouble
  }
  def primitive2_tolong[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = {
    __arg0.toLong
  }
  def primitive2_repint2torepdouble(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    primitive2_repint2torepdouble_impl(__arg0)(__pos)
  }
  def primitive2_repint2torepfloat(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    primitive2_repint2torepfloat_impl(__arg0)(__pos)
  }
  def primitive2_repfloat2torepdouble(__arg0: Rep[Float])(implicit __pos: SourceContext) = {
    primitive2_repfloat2torepdouble_impl(__arg0)(__pos)
  }
  def primitive2_forge_int_plus(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 + __arg1
  }
  def primitive2_forge_int_minus(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 - __arg1
  }
  def primitive2_forge_int_times(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 * __arg1
  }
  def primitive2_forge_int_divide(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 / __arg1
  }
  def primitive2_forge_int_shift_left(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 << __arg1
  }
  def primitive2_forge_int_shift_right_unsigned(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 >>> __arg1
  }
  def primitive2_forge_int_and(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 & __arg1
  }
  def primitive2_forge_int_or(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 | __arg1
  }
  def primitive2_forge_int_shift_right(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 >> __arg1
  }
  def primitive2_%(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 % __arg1
  }
  def primitive2_unary_~(__arg0: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = {
    ~__arg0
  }
  def primitive2_forge_float_plus(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = {
    __arg0 + __arg1
  }
  def primitive2_forge_float_minus(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = {
    __arg0 - __arg1
  }
  def primitive2_forge_float_times(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = {
    __arg0 * __arg1
  }
  def primitive2_forge_float_divide(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = {
    __arg0 / __arg1
  }
  def primitive2_forge_double_plus(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    __arg0 + __arg1
  }
  def primitive2_forge_double_minus(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    __arg0 - __arg1
  }
  def primitive2_forge_double_times(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    __arg0 * __arg1
  }
  def primitive2_forge_double_divide(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    __arg0 / __arg1
  }
  def primitive2_forge_long_plus(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    __arg0 + __arg1
  }
  def primitive2_forge_long_minus(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    __arg0 - __arg1
  }
  def primitive2_forge_long_times(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    __arg0 * __arg1
  }
  def primitive2_forge_long_divide(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    __arg0 / __arg1
  }
  def primitive2_forge_long_divide_double(__arg0: Rep[Long],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    __arg0 / __arg1
  }
  def primitive2_forge_long_and(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    __arg0 & __arg1
  }
  def primitive2_forge_long_or(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    __arg0 | __arg1
  }
  def primitive2_forge_long_xor(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    __arg0 ^ __arg1
  }
  def primitive2_forge_long_shift_right_unsigned(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 >>> __arg1
  }
  def primitive2_forge_long_shift_right(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 >> __arg1
  }
  def primitive2_forge_long_shift_left(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 << __arg1
  }
  def primitive2_unary_~(__arg0: Rep[Long])(implicit __pos: SourceContext,__imp1: Overload2) = {
    ~__arg0
  }
  def primitive2_dist(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = {
    primitive2_dist_impl1(__arg0,__arg1)(__pos)
  }
  def primitive2_dist(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: Overload2) = {
    primitive2_dist_impl2(__arg0,__arg1)(__pos)
  }

}

