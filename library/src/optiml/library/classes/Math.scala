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

trait MathWrapper {
  this: OptiMLBase with OptiMLClasses => 

  def math_inf()(implicit __pos: SourceContext) = {
    Double.PositiveInfinity
  }
  def math_ninf()(implicit __pos: SourceContext) = {
    Double.NegativeInfinity
  }
  def math_object_bitcount(__arg0: Rep[Long])(implicit __pos: SourceContext) = {
    java.lang.Long.bitCount(__arg0)
  }
  def math_object_abs(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    java.lang.Math.abs(__arg0)
  }
  def math_object_exp(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    java.lang.Math.exp(__arg0)
  }
  def math_object_log(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    java.lang.Math.log(__arg0)
  }
  def math_object_log10(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    java.lang.Math.log10(__arg0)
  }
  def math_object_sqrt(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    java.lang.Math.sqrt(__arg0)
  }
  def math_object_ceil(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    java.lang.Math.ceil(__arg0)
  }
  def math_object_floor(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    java.lang.Math.floor(__arg0)
  }
  def math_object_round(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    java.lang.Math.round(__arg0)
  }
  def math_object_sin(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    java.lang.Math.sin(__arg0)
  }
  def math_object_sinh(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    java.lang.Math.sinh(__arg0)
  }
  def math_object_asin(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    java.lang.Math.asin(__arg0)
  }
  def math_object_cos(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    java.lang.Math.cos(__arg0)
  }
  def math_object_cosh(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    java.lang.Math.cosh(__arg0)
  }
  def math_object_acos(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    java.lang.Math.acos(__arg0)
  }
  def math_object_tan(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    java.lang.Math.tan(__arg0)
  }
  def math_object_tanh(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    java.lang.Math.tanh(__arg0)
  }
  def math_object_atan(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    java.lang.Math.atan(__arg0)
  }
  def math_object_atan2(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    java.lang.Math.atan2(__arg0, __arg1)
  }
  def math_object_pow(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    java.lang.Math.pow(__arg0, __arg1)
  }
  def math_object_max(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    java.lang.Math.max(__arg0, __arg1)
  }
  def math_object_min(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    java.lang.Math.min(__arg0, __arg1)
  }

}

