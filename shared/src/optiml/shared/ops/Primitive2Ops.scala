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
 * Lift
 */

trait LiftPrimitive2 {
  this: OptiML => 

  implicit def Primitive2BooleanToRep(x: Boolean) = unit(x)
  implicit def Primitive2ShortToRep(x: Short) = unit(x)
  implicit def Primitive2IntToRep(x: Int) = unit(x)
  implicit def Primitive2LongToRep(x: Long) = unit(x)
  implicit def Primitive2FloatToRep(x: Float) = unit(x)
  implicit def Primitive2DoubleToRep(x: Double) = unit(x)
}

/**
 * Operations
 */

trait Primitive2OpsBase extends Base {
  this: OptiML => 

  implicit def repInt2ToRepDouble(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[Double] = primitive2_repint2torepdouble(__arg0)(__pos)
  implicit def repInt2ToRepFloat(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[Float] = primitive2_repint2torepfloat(__arg0)(__pos)
  implicit def repFloat2ToRepDouble(__arg0: Rep[Float])(implicit __pos: SourceContext): Rep[Double] = primitive2_repfloat2torepdouble(__arg0)(__pos)
  implicit def dist(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1): Rep[Double] = primitive2_dist(__arg0,__arg1)(__pos,overload1)
  implicit def dist(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: Overload2): Rep[Double] = primitive2_dist(__arg0,__arg1)(__pos,overload2)

  def primitive2_repint2torepdouble(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[Double]
  def primitive2_repint2torepfloat(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[Float]
  def primitive2_repfloat2torepdouble(__arg0: Rep[Float])(implicit __pos: SourceContext): Rep[Double]
  def primitive2_dist(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1): Rep[Double]
  def primitive2_dist(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: Overload2): Rep[Double]
}

trait Primitive2Ops extends Primitive2OpsBase {
  this: OptiML => 

  def forge_int_plus(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive2_forge_int_plus(__arg0,__arg1)(__pos)
  def forge_int_minus(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive2_forge_int_minus(__arg0,__arg1)(__pos)
  def forge_int_times(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive2_forge_int_times(__arg0,__arg1)(__pos)
  def forge_int_divide(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive2_forge_int_divide(__arg0,__arg1)(__pos)
  def forge_int_shift_left(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive2_forge_int_shift_left(__arg0,__arg1)(__pos)
  def forge_int_shift_right_unsigned(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive2_forge_int_shift_right_unsigned(__arg0,__arg1)(__pos)
  def forge_int_and(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive2_forge_int_and(__arg0,__arg1)(__pos)
  def forge_int_or(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive2_forge_int_or(__arg0,__arg1)(__pos)
  def forge_int_shift_right(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive2_forge_int_shift_right(__arg0,__arg1)(__pos)
  def forge_float_plus(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = primitive2_forge_float_plus(__arg0,__arg1)(__pos)
  def forge_float_minus(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = primitive2_forge_float_minus(__arg0,__arg1)(__pos)
  def forge_float_times(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = primitive2_forge_float_times(__arg0,__arg1)(__pos)
  def forge_float_divide(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = primitive2_forge_float_divide(__arg0,__arg1)(__pos)
  def forge_double_plus(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = primitive2_forge_double_plus(__arg0,__arg1)(__pos)
  def forge_double_minus(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = primitive2_forge_double_minus(__arg0,__arg1)(__pos)
  def forge_double_times(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = primitive2_forge_double_times(__arg0,__arg1)(__pos)
  def forge_double_divide(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = primitive2_forge_double_divide(__arg0,__arg1)(__pos)
  def forge_long_plus(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = primitive2_forge_long_plus(__arg0,__arg1)(__pos)
  def forge_long_minus(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = primitive2_forge_long_minus(__arg0,__arg1)(__pos)
  def forge_long_times(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = primitive2_forge_long_times(__arg0,__arg1)(__pos)
  def forge_long_divide(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = primitive2_forge_long_divide(__arg0,__arg1)(__pos)
  def forge_long_divide_double(__arg0: Rep[Long],__arg1: Rep[Double])(implicit __pos: SourceContext) = primitive2_forge_long_divide_double(__arg0,__arg1)(__pos)
  def forge_long_and(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = primitive2_forge_long_and(__arg0,__arg1)(__pos)
  def forge_long_or(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = primitive2_forge_long_or(__arg0,__arg1)(__pos)
  def forge_long_xor(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = primitive2_forge_long_xor(__arg0,__arg1)(__pos)
  def forge_long_shift_right_unsigned(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive2_forge_long_shift_right_unsigned(__arg0,__arg1)(__pos)
  def forge_long_shift_right(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive2_forge_long_shift_right(__arg0,__arg1)(__pos)
  def forge_long_shift_left(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive2_forge_long_shift_left(__arg0,__arg1)(__pos)

  implicit def repToPrimitive2IntOpsCls(x: Rep[Int])(implicit __pos: SourceContext) = new Primitive2IntOpsCls(x)(__pos)
  implicit def liftToPrimitive2IntOpsCls(x: Int)(implicit __pos: SourceContext) = new Primitive2IntOpsCls(unit(x))(__pos)
  implicit def varToPrimitive2IntOpsCls(x: Var[Int])(implicit __pos: SourceContext) = new Primitive2IntOpsCls(readVar(x))(__pos)

  class Primitive2IntOpsCls(val self: Rep[Int])(implicit __pos: SourceContext) {
    def -(__arg1: Int)(implicit __pos: SourceContext,__imp1: ROverload12) = { forge_int_minus(self,unit(__arg1)) }
    def -(__arg1: Float)(implicit __pos: SourceContext,__imp1: ROverload13) = { forge_float_minus(self.toFloat,unit(__arg1)) }
    def -(__arg1: Double)(implicit __pos: SourceContext,__imp1: ROverload14) = { forge_double_minus(self.toDouble,unit(__arg1)) }
    def -(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload21) = { forge_int_minus(self,__arg1) }
    def -(__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload22) = { forge_float_minus(self.toFloat,__arg1) }
    def -(__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload23) = { forge_double_minus(self.toDouble,__arg1) }
    def *(__arg1: Int)(implicit __pos: SourceContext,__imp1: ROverload12) = { forge_int_times(self,unit(__arg1)) }
    def *(__arg1: Float)(implicit __pos: SourceContext,__imp1: ROverload13) = { forge_float_times(self.toFloat,unit(__arg1)) }
    def *(__arg1: Double)(implicit __pos: SourceContext,__imp1: ROverload14) = { forge_double_times(self.toDouble,unit(__arg1)) }
    def *(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload21) = { forge_int_times(self,__arg1) }
    def *(__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload22) = { forge_float_times(self.toFloat,__arg1) }
    def *(__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload23) = { forge_double_times(self.toDouble,__arg1) }
    def /(__arg1: Int)(implicit __pos: SourceContext,__imp1: ROverload12) = { forge_int_divide(self,unit(__arg1)) }
    def /(__arg1: Float)(implicit __pos: SourceContext,__imp1: ROverload13) = { forge_float_divide(self.toFloat,unit(__arg1)) }
    def /(__arg1: Double)(implicit __pos: SourceContext,__imp1: ROverload14) = { forge_double_divide(self.toDouble,unit(__arg1)) }
    def /(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload21) = { forge_int_divide(self,__arg1) }
    def /(__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload22) = { forge_float_divide(self.toFloat,__arg1) }
    def /(__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload23) = { forge_double_divide(self.toDouble,__arg1) }
  }

  implicit def repToPrimitive2FloatOpsCls(x: Rep[Float])(implicit __pos: SourceContext) = new Primitive2FloatOpsCls(x)(__pos)
  implicit def liftToPrimitive2FloatOpsCls(x: Float)(implicit __pos: SourceContext) = new Primitive2FloatOpsCls(unit(x))(__pos)
  implicit def varToPrimitive2FloatOpsCls(x: Var[Float])(implicit __pos: SourceContext) = new Primitive2FloatOpsCls(readVar(x))(__pos)

  class Primitive2FloatOpsCls(val self: Rep[Float])(implicit __pos: SourceContext) {
    def -(__arg1: Int)(implicit __pos: SourceContext,__imp1: ROverload15) = { forge_float_minus(self,unit(__arg1.toFloat)) }
    def -(__arg1: Float)(implicit __pos: SourceContext,__imp1: ROverload16) = { forge_float_minus(self,unit(__arg1)) }
    def -(__arg1: Double)(implicit __pos: SourceContext,__imp1: ROverload17) = { forge_double_minus(self.toDouble,unit(__arg1)) }
    def -(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload24) = { forge_float_minus(self,__arg1.toFloat) }
    def -(__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload25) = { forge_float_minus(self,__arg1) }
    def -(__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload26) = { forge_double_minus(self.toDouble,__arg1) }
    def *(__arg1: Int)(implicit __pos: SourceContext,__imp1: ROverload15) = { forge_float_times(self,unit(__arg1.toFloat)) }
    def *(__arg1: Float)(implicit __pos: SourceContext,__imp1: ROverload16) = { forge_float_times(self,unit(__arg1)) }
    def *(__arg1: Double)(implicit __pos: SourceContext,__imp1: ROverload17) = { forge_double_times(self.toDouble,unit(__arg1)) }
    def *(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload24) = { forge_float_times(self,__arg1.toFloat) }
    def *(__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload25) = { forge_float_times(self,__arg1) }
    def *(__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload26) = { forge_double_times(self.toDouble,__arg1) }
    def /(__arg1: Int)(implicit __pos: SourceContext,__imp1: ROverload15) = { forge_float_divide(self,unit(__arg1.toFloat)) }
    def /(__arg1: Float)(implicit __pos: SourceContext,__imp1: ROverload16) = { forge_float_divide(self,unit(__arg1)) }
    def /(__arg1: Double)(implicit __pos: SourceContext,__imp1: ROverload17) = { forge_double_divide(self.toDouble,unit(__arg1)) }
    def /(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload24) = { forge_float_divide(self,__arg1.toFloat) }
    def /(__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload25) = { forge_float_divide(self,__arg1) }
    def /(__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload26) = { forge_double_divide(self.toDouble,__arg1) }
  }

  implicit def repToPrimitive2DoubleOpsCls(x: Rep[Double])(implicit __pos: SourceContext) = new Primitive2DoubleOpsCls(x)(__pos)
  implicit def liftToPrimitive2DoubleOpsCls(x: Double)(implicit __pos: SourceContext) = new Primitive2DoubleOpsCls(unit(x))(__pos)
  implicit def varToPrimitive2DoubleOpsCls(x: Var[Double])(implicit __pos: SourceContext) = new Primitive2DoubleOpsCls(readVar(x))(__pos)

  class Primitive2DoubleOpsCls(val self: Rep[Double])(implicit __pos: SourceContext) {
    def -(__arg1: Int)(implicit __pos: SourceContext,__imp1: ROverload18) = { forge_double_minus(self,unit(__arg1.toDouble)) }
    def -(__arg1: Float)(implicit __pos: SourceContext,__imp1: ROverload19) = { forge_double_minus(self.toDouble,unit(__arg1)) }
    def -(__arg1: Double)(implicit __pos: SourceContext,__imp1: ROverload20) = { forge_double_minus(self,unit(__arg1)) }
    def -(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload27) = { forge_double_minus(self,__arg1.toDouble) }
    def -(__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload28) = { forge_double_minus(self,__arg1.toDouble) }
    def -(__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload29) = { forge_double_minus(self,__arg1) }
    def *(__arg1: Int)(implicit __pos: SourceContext,__imp1: ROverload18) = { forge_double_times(self,unit(__arg1.toDouble)) }
    def *(__arg1: Float)(implicit __pos: SourceContext,__imp1: ROverload19) = { forge_double_times(self.toDouble,unit(__arg1)) }
    def *(__arg1: Double)(implicit __pos: SourceContext,__imp1: ROverload20) = { forge_double_times(self,unit(__arg1)) }
    def *(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload27) = { forge_double_times(self,__arg1.toDouble) }
    def *(__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload28) = { forge_double_times(self,__arg1.toDouble) }
    def *(__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload29) = { forge_double_times(self,__arg1) }
    def /(__arg1: Int)(implicit __pos: SourceContext,__imp1: ROverload18) = { forge_double_divide(self,unit(__arg1.toDouble)) }
    def /(__arg1: Float)(implicit __pos: SourceContext,__imp1: ROverload19) = { forge_double_divide(self.toDouble,unit(__arg1)) }
    def /(__arg1: Double)(implicit __pos: SourceContext,__imp1: ROverload20) = { forge_double_divide(self,unit(__arg1)) }
    def /(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload27) = { forge_double_divide(self,__arg1.toDouble) }
    def /(__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload28) = { forge_double_divide(self,__arg1.toDouble) }
    def /(__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload29) = { forge_double_divide(self,__arg1) }
  }

  implicit def repToPrimitive2LongOpsCls(x: Rep[Long])(implicit __pos: SourceContext) = new Primitive2LongOpsCls(x)(__pos)
  implicit def varToPrimitive2LongOpsCls(x: Var[Long])(implicit __pos: SourceContext) = new Primitive2LongOpsCls(readVar(x))(__pos)

  class Primitive2LongOpsCls(val self: Rep[Long])(implicit __pos: SourceContext) {
    def -(__arg1: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload30) = { forge_long_minus(self,__arg1) }
    def *(__arg1: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload30) = { forge_long_times(self,__arg1) }
    def /(__arg1: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload30) = { forge_long_divide(self,__arg1) }
    def /(__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload31) = { forge_long_divide_double(self,__arg1) }
  }


  def infix_unary_!(__arg0: Rep[Boolean])(implicit __pos: SourceContext) = primitive2_unary_bang(__arg0)(__pos)
  def infix_||(__arg0: Rep[Boolean],__arg1: Rep[Boolean])(implicit __pos: SourceContext) = primitive2_oror(__arg0,__arg1)(__pos)
  def infix_&&(__arg0: Rep[Boolean],__arg1: Rep[Boolean])(implicit __pos: SourceContext) = primitive2_andand(__arg0,__arg1)(__pos)
  def infix_toInt[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext,__imp1: Overload1) = primitive2_toint[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  def infix_toFloat[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext,__imp1: Overload1) = primitive2_tofloat[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  def infix_toDouble[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext,__imp1: Overload1) = primitive2_todouble[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  def infix_toLong[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext,__imp1: Overload1) = primitive2_tolong[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  def infix_%(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive2_%(__arg0,__arg1)(__pos)
  def infix_unary_~(__arg0: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = primitive2_unary_~(__arg0)(__pos,overload1)
  def infix_unary_~(__arg0: Rep[Long])(implicit __pos: SourceContext,__imp1: Overload2) = primitive2_unary_~(__arg0)(__pos,overload2)
  def infix_+(__arg0: Int,__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload3): Rep[Int] = { forge_int_plus(unit(__arg0),__arg1) }
  def infix_+(__arg0: Int,__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[Float] = { forge_float_plus(unit(__arg0.toFloat),__arg1) }
  def infix_+(__arg0: Int,__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload5): Rep[Double] = { forge_double_plus(unit(__arg0.toDouble),__arg1) }
  def infix_+(__arg0: Float,__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload6): Rep[Float] = { forge_float_plus(unit(__arg0),__arg1.toFloat) }
  def infix_+(__arg0: Float,__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload7): Rep[Float] = { forge_float_plus(unit(__arg0),__arg1) }
  def infix_+(__arg0: Float,__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload8): Rep[Double] = { forge_double_plus(unit(__arg0.toDouble),__arg1) }
  def infix_+(__arg0: Double,__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload9): Rep[Double] = { forge_double_plus(unit(__arg0),__arg1.toDouble) }
  def infix_+(__arg0: Double,__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload10): Rep[Double] = { forge_double_plus(unit(__arg0),__arg1.toDouble) }
  def infix_+(__arg0: Double,__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload11): Rep[Double] = { forge_double_plus(unit(__arg0),__arg1) }
  def infix_+(__arg0: Rep[Int],__arg1: Int)(implicit __pos: SourceContext,__imp1: ROverload12): Rep[Int] = { forge_int_plus(__arg0,unit(__arg1)) }
  def infix_+(__arg0: Rep[Int],__arg1: Float)(implicit __pos: SourceContext,__imp1: ROverload13): Rep[Float] = { forge_float_plus(__arg0.toFloat,unit(__arg1)) }
  def infix_+(__arg0: Rep[Int],__arg1: Double)(implicit __pos: SourceContext,__imp1: ROverload14): Rep[Double] = { forge_double_plus(__arg0.toDouble,unit(__arg1)) }
  def infix_+(__arg0: Rep[Float],__arg1: Int)(implicit __pos: SourceContext,__imp1: ROverload15): Rep[Float] = { forge_float_plus(__arg0,unit(__arg1.toFloat)) }
  def infix_+(__arg0: Rep[Float],__arg1: Float)(implicit __pos: SourceContext,__imp1: ROverload16): Rep[Float] = { forge_float_plus(__arg0,unit(__arg1)) }
  def infix_+(__arg0: Rep[Float],__arg1: Double)(implicit __pos: SourceContext,__imp1: ROverload17): Rep[Double] = { forge_double_plus(__arg0.toDouble,unit(__arg1)) }
  def infix_+(__arg0: Rep[Double],__arg1: Int)(implicit __pos: SourceContext,__imp1: ROverload18): Rep[Double] = { forge_double_plus(__arg0,unit(__arg1.toDouble)) }
  def infix_+(__arg0: Rep[Double],__arg1: Float)(implicit __pos: SourceContext,__imp1: ROverload19): Rep[Double] = { forge_double_plus(__arg0.toDouble,unit(__arg1)) }
  def infix_+(__arg0: Rep[Double],__arg1: Double)(implicit __pos: SourceContext,__imp1: ROverload20): Rep[Double] = { forge_double_plus(__arg0,unit(__arg1)) }
  def infix_+(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload21): Rep[Int] = { forge_int_plus(__arg0,__arg1) }
  def infix_+(__arg0: Rep[Int],__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload22): Rep[Float] = { forge_float_plus(__arg0.toFloat,__arg1) }
  def infix_+(__arg0: Rep[Int],__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload23): Rep[Double] = { forge_double_plus(__arg0.toDouble,__arg1) }
  def infix_+(__arg0: Rep[Float],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload24): Rep[Float] = { forge_float_plus(__arg0,__arg1.toFloat) }
  def infix_+(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload25): Rep[Float] = { forge_float_plus(__arg0,__arg1) }
  def infix_+(__arg0: Rep[Float],__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload26): Rep[Double] = { forge_double_plus(__arg0.toDouble,__arg1) }
  def infix_+(__arg0: Rep[Double],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload27): Rep[Double] = { forge_double_plus(__arg0,__arg1.toDouble) }
  def infix_+(__arg0: Rep[Double],__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload28): Rep[Double] = { forge_double_plus(__arg0,__arg1.toDouble) }
  def infix_+(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload29): Rep[Double] = { forge_double_plus(__arg0,__arg1) }
  def infix_unary_-(__arg0: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { unit(-1)*__arg0 }
  def infix_unary_-(__arg0: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { unit(-1L)*__arg0 }
  def infix_unary_-(__arg0: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload3): Rep[Float] = { unit(-1f)*__arg0 }
  def infix_unary_-(__arg0: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[Double] = { unit(-1)*__arg0 }
  def infix_+(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload30): Rep[Long] = { forge_long_plus(__arg0,__arg1) }
  def infix_<<(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { forge_int_shift_left(__arg0,__arg1) }
  def infix_>>(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { forge_int_shift_right(__arg0,__arg1) }
  def infix_>>>(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { forge_int_shift_right_unsigned(__arg0,__arg1) }
  def infix_&(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { forge_int_and(__arg0,__arg1) }
  def infix_|(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { forge_int_or(__arg0,__arg1) }
  def infix_&(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { forge_long_and(__arg0,__arg1) }
  def infix_|(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { forge_long_or(__arg0,__arg1) }
  def infix_^(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext): Rep[Long] = { forge_long_xor(__arg0,__arg1) }
  def infix_>>>(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { forge_long_shift_right_unsigned(__arg0,__arg1) }
  def infix_<<(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { forge_long_shift_left(__arg0,__arg1) }
  def infix_>>(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { forge_long_shift_right(__arg0,__arg1) }

  def primitive2_unary_bang(__arg0: Rep[Boolean])(implicit __pos: SourceContext): Rep[Boolean]
  def primitive2_oror(__arg0: Rep[Boolean],__arg1: Rep[Boolean])(implicit __pos: SourceContext): Rep[Boolean]
  def primitive2_andand(__arg0: Rep[Boolean],__arg1: Rep[Boolean])(implicit __pos: SourceContext): Rep[Boolean]
  def primitive2_toint[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext): Rep[Int]
  def primitive2_tofloat[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext): Rep[Float]
  def primitive2_todouble[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext): Rep[Double]
  def primitive2_tolong[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext): Rep[Long]
  def primitive2_forge_int_plus(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def primitive2_forge_int_minus(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def primitive2_forge_int_times(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def primitive2_forge_int_divide(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def primitive2_forge_int_shift_left(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def primitive2_forge_int_shift_right_unsigned(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def primitive2_forge_int_and(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def primitive2_forge_int_or(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def primitive2_forge_int_shift_right(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def primitive2_%(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def primitive2_unary_~(__arg0: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1): Rep[Int]
  def primitive2_forge_float_plus(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext): Rep[Float]
  def primitive2_forge_float_minus(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext): Rep[Float]
  def primitive2_forge_float_times(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext): Rep[Float]
  def primitive2_forge_float_divide(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext): Rep[Float]
  def primitive2_forge_double_plus(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext): Rep[Double]
  def primitive2_forge_double_minus(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext): Rep[Double]
  def primitive2_forge_double_times(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext): Rep[Double]
  def primitive2_forge_double_divide(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext): Rep[Double]
  def primitive2_forge_long_plus(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext): Rep[Long]
  def primitive2_forge_long_minus(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext): Rep[Long]
  def primitive2_forge_long_times(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext): Rep[Long]
  def primitive2_forge_long_divide(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext): Rep[Long]
  def primitive2_forge_long_divide_double(__arg0: Rep[Long],__arg1: Rep[Double])(implicit __pos: SourceContext): Rep[Double]
  def primitive2_forge_long_and(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext): Rep[Long]
  def primitive2_forge_long_or(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext): Rep[Long]
  def primitive2_forge_long_xor(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext): Rep[Long]
  def primitive2_forge_long_shift_right_unsigned(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Long]
  def primitive2_forge_long_shift_right(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Long]
  def primitive2_forge_long_shift_left(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Long]
  def primitive2_unary_~(__arg0: Rep[Long])(implicit __pos: SourceContext,__imp1: Overload2): Rep[Long]
}
