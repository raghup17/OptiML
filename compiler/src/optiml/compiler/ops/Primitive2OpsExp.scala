package optiml.compiler.ops

import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import ppl.delite.framework.ops.DeliteCollection
import ppl.delite.framework.datastructures._
import ppl.delite.framework.ops.{DeliteOpsExp, DeliteCollectionOpsExp}
import ppl.delite.framework.Util._
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._
import optiml.compiler._
import optiml.compiler.ops._

/**
 * IR Definitions
 */

trait Primitive2OpsExp extends Primitive2Ops with BaseFatExp with EffectExp {
  this: OptiMLExp => 

  case class Primitive2_Unary_bang(__arg0: Rep[Boolean])(implicit val __pos: SourceContext) extends Def[Boolean] {
  }

  case class Primitive2_Oror(__arg0: Rep[Boolean],__arg1: Rep[Boolean])(implicit val __pos: SourceContext) extends Def[Boolean] {
  }

  case class Primitive2_Andand(__arg0: Rep[Boolean],__arg1: Rep[Boolean])(implicit val __pos: SourceContext) extends Def[Boolean] {
  }

  case class Primitive21_ToInt[T:Numeric:Manifest](__arg0: Rep[T])(implicit val __pos: SourceContext) extends Def[Int] {
    val _numT = implicitly[Numeric[T]]
    val _mT = implicitly[Manifest[T]]
  }

  case class Primitive21_ToFloat[T:Numeric:Manifest](__arg0: Rep[T])(implicit val __pos: SourceContext) extends Def[Float] {
    val _numT = implicitly[Numeric[T]]
    val _mT = implicitly[Manifest[T]]
  }

  case class Primitive21_ToDouble[T:Numeric:Manifest](__arg0: Rep[T])(implicit val __pos: SourceContext) extends Def[Double] {
    val _numT = implicitly[Numeric[T]]
    val _mT = implicitly[Manifest[T]]
  }

  case class Primitive21_ToLong[T:Numeric:Manifest](__arg0: Rep[T])(implicit val __pos: SourceContext) extends Def[Long] {
    val _numT = implicitly[Numeric[T]]
    val _mT = implicitly[Manifest[T]]
  }

  case class Primitive2_Forge_int_plus(__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Primitive2_Forge_int_minus(__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Primitive2_Forge_int_times(__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Primitive2_Forge_int_divide(__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Primitive2_Forge_int_shift_left(__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Primitive2_Forge_int_shift_right_unsigned(__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Primitive2_Forge_int_and(__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Primitive2_Forge_int_or(__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Primitive2_Forge_int_shift_right(__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Primitive2_%(__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Primitive21_Unary_~(__arg0: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Primitive2_Forge_float_plus(__arg0: Rep[Float],__arg1: Rep[Float])(implicit val __pos: SourceContext) extends Def[Float] {
  }

  case class Primitive2_Forge_float_minus(__arg0: Rep[Float],__arg1: Rep[Float])(implicit val __pos: SourceContext) extends Def[Float] {
  }

  case class Primitive2_Forge_float_times(__arg0: Rep[Float],__arg1: Rep[Float])(implicit val __pos: SourceContext) extends Def[Float] {
  }

  case class Primitive2_Forge_float_divide(__arg0: Rep[Float],__arg1: Rep[Float])(implicit val __pos: SourceContext) extends Def[Float] {
  }

  case class Primitive2_Forge_double_plus(__arg0: Rep[Double],__arg1: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class Primitive2_Forge_double_minus(__arg0: Rep[Double],__arg1: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class Primitive2_Forge_double_times(__arg0: Rep[Double],__arg1: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class Primitive2_Forge_double_divide(__arg0: Rep[Double],__arg1: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class Primitive2_Forge_long_plus(__arg0: Rep[Long],__arg1: Rep[Long])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class Primitive2_Forge_long_minus(__arg0: Rep[Long],__arg1: Rep[Long])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class Primitive2_Forge_long_times(__arg0: Rep[Long],__arg1: Rep[Long])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class Primitive2_Forge_long_divide(__arg0: Rep[Long],__arg1: Rep[Long])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class Primitive2_Forge_long_divide_double(__arg0: Rep[Long],__arg1: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class Primitive2_Forge_long_and(__arg0: Rep[Long],__arg1: Rep[Long])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class Primitive2_Forge_long_or(__arg0: Rep[Long],__arg1: Rep[Long])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class Primitive2_Forge_long_xor(__arg0: Rep[Long],__arg1: Rep[Long])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class Primitive2_Forge_long_shift_right_unsigned(__arg0: Rep[Long],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class Primitive2_Forge_long_shift_right(__arg0: Rep[Long],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class Primitive2_Forge_long_shift_left(__arg0: Rep[Long],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class Primitive22_Unary_~(__arg0: Rep[Long])(implicit val __pos: SourceContext) extends Def[Long] {
  }



  def primitive2_unary_bang(__arg0: Rep[Boolean])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Unary_bang(__arg0)(__pos))
  }
  def primitive2_oror(__arg0: Rep[Boolean],__arg1: Rep[Boolean])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Oror(__arg0,__arg1)(__pos))
  }
  def primitive2_andand(__arg0: Rep[Boolean],__arg1: Rep[Boolean])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Andand(__arg0,__arg1)(__pos))
  }
  def primitive2_toint[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = {
    reflectPure(Primitive21_ToInt[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos))
  }
  def primitive2_tofloat[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = {
    reflectPure(Primitive21_ToFloat[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos))
  }
  def primitive2_todouble[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = {
    reflectPure(Primitive21_ToDouble[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos))
  }
  def primitive2_tolong[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = {
    reflectPure(Primitive21_ToLong[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos))
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
    reflectPure(Primitive2_Forge_int_plus(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_int_minus(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_int_minus(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_int_times(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_int_times(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_int_divide(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_int_divide(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_int_shift_left(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_int_shift_left(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_int_shift_right_unsigned(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_int_shift_right_unsigned(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_int_and(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_int_and(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_int_or(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_int_or(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_int_shift_right(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_int_shift_right(__arg0,__arg1)(__pos))
  }
  def primitive2_%(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_%(__arg0,__arg1)(__pos))
  }
  def primitive2_unary_~(__arg0: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = {
    reflectPure(Primitive21_Unary_~(__arg0)(__pos))
  }
  def primitive2_forge_float_plus(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_float_plus(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_float_minus(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_float_minus(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_float_times(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_float_times(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_float_divide(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_float_divide(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_double_plus(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_double_plus(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_double_minus(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_double_minus(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_double_times(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_double_times(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_double_divide(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_double_divide(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_long_plus(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_long_plus(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_long_minus(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_long_minus(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_long_times(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_long_times(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_long_divide(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_long_divide(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_long_divide_double(__arg0: Rep[Long],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_long_divide_double(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_long_and(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_long_and(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_long_or(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_long_or(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_long_xor(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_long_xor(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_long_shift_right_unsigned(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_long_shift_right_unsigned(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_long_shift_right(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_long_shift_right(__arg0,__arg1)(__pos))
  }
  def primitive2_forge_long_shift_left(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_Forge_long_shift_left(__arg0,__arg1)(__pos))
  }
  def primitive2_unary_~(__arg0: Rep[Long])(implicit __pos: SourceContext,__imp1: Overload2) = {
    reflectPure(Primitive22_Unary_~(__arg0)(__pos))
  }
  def primitive2_dist(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = {
    primitive2_dist_impl1(__arg0,__arg1)(__pos)
  }
  def primitive2_dist(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: Overload2) = {
    primitive2_dist_impl2(__arg0,__arg1)(__pos)
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Primitive2_Unary_bang(__arg0) => primitive2_unary_bang(f(__arg0))(mn.__pos)
    case Reflect(mn@Primitive2_Unary_bang(__arg0), u, es) => reflectMirrored(Reflect(Primitive2_Unary_bang(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Oror(__arg0,__arg1) => primitive2_oror(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Oror(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Oror(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Andand(__arg0,__arg1) => primitive2_andand(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Andand(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Andand(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive21_ToInt(__arg0) => primitive2_toint(f(__arg0))(ntype(mn._numT),mtype(mn._mT),mn.__pos)
    case Reflect(mn@Primitive21_ToInt(__arg0), u, es) => reflectMirrored(Reflect(Primitive21_ToInt(f(__arg0))(ntype(mn._numT),mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive21_ToFloat(__arg0) => primitive2_tofloat(f(__arg0))(ntype(mn._numT),mtype(mn._mT),mn.__pos)
    case Reflect(mn@Primitive21_ToFloat(__arg0), u, es) => reflectMirrored(Reflect(Primitive21_ToFloat(f(__arg0))(ntype(mn._numT),mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive21_ToDouble(__arg0) => primitive2_todouble(f(__arg0))(ntype(mn._numT),mtype(mn._mT),mn.__pos)
    case Reflect(mn@Primitive21_ToDouble(__arg0), u, es) => reflectMirrored(Reflect(Primitive21_ToDouble(f(__arg0))(ntype(mn._numT),mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive21_ToLong(__arg0) => primitive2_tolong(f(__arg0))(ntype(mn._numT),mtype(mn._mT),mn.__pos)
    case Reflect(mn@Primitive21_ToLong(__arg0), u, es) => reflectMirrored(Reflect(Primitive21_ToLong(f(__arg0))(ntype(mn._numT),mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_int_plus(__arg0,__arg1) => primitive2_forge_int_plus(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_int_plus(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_int_plus(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_int_minus(__arg0,__arg1) => primitive2_forge_int_minus(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_int_minus(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_int_minus(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_int_times(__arg0,__arg1) => primitive2_forge_int_times(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_int_times(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_int_times(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_int_divide(__arg0,__arg1) => primitive2_forge_int_divide(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_int_divide(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_int_divide(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_int_shift_left(__arg0,__arg1) => primitive2_forge_int_shift_left(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_int_shift_left(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_int_shift_left(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_int_shift_right_unsigned(__arg0,__arg1) => primitive2_forge_int_shift_right_unsigned(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_int_shift_right_unsigned(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_int_shift_right_unsigned(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_int_and(__arg0,__arg1) => primitive2_forge_int_and(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_int_and(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_int_and(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_int_or(__arg0,__arg1) => primitive2_forge_int_or(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_int_or(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_int_or(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_int_shift_right(__arg0,__arg1) => primitive2_forge_int_shift_right(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_int_shift_right(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_int_shift_right(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_%(__arg0,__arg1) => primitive2_%(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_%(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_%(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive21_Unary_~(__arg0) => primitive2_unary_~(f(__arg0))(mn.__pos,overload1)
    case Reflect(mn@Primitive21_Unary_~(__arg0), u, es) => reflectMirrored(Reflect(Primitive21_Unary_~(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_float_plus(__arg0,__arg1) => primitive2_forge_float_plus(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_float_plus(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_float_plus(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_float_minus(__arg0,__arg1) => primitive2_forge_float_minus(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_float_minus(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_float_minus(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_float_times(__arg0,__arg1) => primitive2_forge_float_times(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_float_times(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_float_times(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_float_divide(__arg0,__arg1) => primitive2_forge_float_divide(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_float_divide(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_float_divide(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_double_plus(__arg0,__arg1) => primitive2_forge_double_plus(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_double_plus(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_double_plus(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_double_minus(__arg0,__arg1) => primitive2_forge_double_minus(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_double_minus(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_double_minus(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_double_times(__arg0,__arg1) => primitive2_forge_double_times(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_double_times(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_double_times(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_double_divide(__arg0,__arg1) => primitive2_forge_double_divide(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_double_divide(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_double_divide(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_long_plus(__arg0,__arg1) => primitive2_forge_long_plus(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_long_plus(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_long_plus(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_long_minus(__arg0,__arg1) => primitive2_forge_long_minus(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_long_minus(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_long_minus(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_long_times(__arg0,__arg1) => primitive2_forge_long_times(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_long_times(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_long_times(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_long_divide(__arg0,__arg1) => primitive2_forge_long_divide(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_long_divide(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_long_divide(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_long_divide_double(__arg0,__arg1) => primitive2_forge_long_divide_double(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_long_divide_double(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_long_divide_double(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_long_and(__arg0,__arg1) => primitive2_forge_long_and(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_long_and(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_long_and(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_long_or(__arg0,__arg1) => primitive2_forge_long_or(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_long_or(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_long_or(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_long_xor(__arg0,__arg1) => primitive2_forge_long_xor(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_long_xor(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_long_xor(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_long_shift_right_unsigned(__arg0,__arg1) => primitive2_forge_long_shift_right_unsigned(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_long_shift_right_unsigned(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_long_shift_right_unsigned(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_long_shift_right(__arg0,__arg1) => primitive2_forge_long_shift_right(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_long_shift_right(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_long_shift_right(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Forge_long_shift_left(__arg0,__arg1) => primitive2_forge_long_shift_left(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive2_Forge_long_shift_left(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_Forge_long_shift_left(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive22_Unary_~(__arg0) => primitive2_unary_~(f(__arg0))(mn.__pos,overload2)
    case Reflect(mn@Primitive22_Unary_~(__arg0), u, es) => reflectMirrored(Reflect(Primitive22_Unary_~(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


}

/**
 * Code generators
 */

trait ScalaGenPrimitive2Ops extends ScalaGenFat {
  val IR: Primitive2OpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Primitive2_Unary_bang(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("!"+quote(__arg0)+"")
      stream.println("}")

    case mn@Primitive2_Oror(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" || "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Andand(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" && "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive21_ToInt(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toInt")
      stream.println("}")

    case mn@Primitive21_ToFloat(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toFloat")
      stream.println("}")

    case mn@Primitive21_ToDouble(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toDouble")
      stream.println("}")

    case mn@Primitive21_ToLong(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toLong")
      stream.println("}")

    case mn@Primitive2_Forge_int_plus(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_int_minus(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_int_times(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_int_divide(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_int_shift_left(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" << "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_int_shift_right_unsigned(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" >>> "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_int_and(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" & "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_int_or(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" | "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_int_shift_right(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" >> "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_%(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" % "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive21_Unary_~(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("~"+quote(__arg0)+"")
      stream.println("}")

    case mn@Primitive2_Forge_float_plus(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_float_minus(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_float_times(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_float_divide(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_double_plus(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_double_minus(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_double_times(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_double_divide(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_long_plus(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_long_minus(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_long_times(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_long_divide(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_long_divide_double(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_long_and(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" & "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_long_or(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" | "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_long_xor(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" ^ "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_long_shift_right_unsigned(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" >>> "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_long_shift_right(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" >> "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Forge_long_shift_left(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" << "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive22_Unary_~(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("~"+quote(__arg0)+"")
      stream.println("}")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CudaGenPrimitive2Ops extends CudaGenFat {
  val IR: Primitive2OpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Primitive2_Unary_bang(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("!"+quote(__arg0)+"")
      stream.println(";")

    case mn@Primitive2_Oror(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" || "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Andand(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" && "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive21_ToInt(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("(int) "+quote(__arg0)+"")
      stream.println(";")

    case mn@Primitive21_ToFloat(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("(float) "+quote(__arg0)+"")
      stream.println(";")

    case mn@Primitive21_ToDouble(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("(double) "+quote(__arg0)+"")
      stream.println(";")

    case mn@Primitive21_ToLong(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("(long) "+quote(__arg0)+"")
      stream.println(";")

    case mn@Primitive2_Forge_int_plus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Forge_int_minus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Forge_int_times(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Forge_int_divide(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Forge_int_shift_left(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" << "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Forge_int_and(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" & "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Forge_int_or(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" | "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Forge_int_shift_right(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" >> "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_%(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" % "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive21_Unary_~(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("~"+quote(__arg0)+"")
      stream.println(";")

    case mn@Primitive2_Forge_float_plus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Forge_float_minus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Forge_float_times(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Forge_float_divide(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Forge_double_plus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Forge_double_minus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Forge_double_times(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Forge_double_divide(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Forge_long_plus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Forge_long_minus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Forge_long_times(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Forge_long_divide(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Forge_long_divide_double(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Forge_long_and(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" & "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Forge_long_or(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" | "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Forge_long_xor(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" ^ "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive22_Unary_~(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("~"+quote(__arg0)+"")
      stream.println(";")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CGenPrimitive2Ops extends CGenFat {
  val IR: Primitive2OpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = {
      rhs match {
      case mn@Primitive2_Unary_bang(__arg0) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Unary_bang")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("!"+quote(__arg0)+"")
        stream.println(";")

      case mn@Primitive2_Oror(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Oror")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" || "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Andand(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Andand")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" && "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive21_ToInt(__arg0) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive21_ToInt")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("(int) "+quote(__arg0)+"")
        stream.println(";")

      case mn@Primitive21_ToFloat(__arg0) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive21_ToFloat")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("(float) "+quote(__arg0)+"")
        stream.println(";")

      case mn@Primitive21_ToDouble(__arg0) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive21_ToDouble")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("(double) "+quote(__arg0)+"")
        stream.println(";")

      case mn@Primitive21_ToLong(__arg0) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive21_ToLong")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("(long) "+quote(__arg0)+"")
        stream.println(";")

      case mn@Primitive2_Forge_int_plus(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_int_plus")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Forge_int_minus(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_int_minus")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Forge_int_times(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_int_times")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Forge_int_divide(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_int_divide")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Forge_int_shift_left(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_int_shift_left")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" << "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Forge_int_and(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_int_and")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" & "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Forge_int_or(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_int_or")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" | "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Forge_int_shift_right(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_int_shift_right")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" >> "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_%(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_%")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" % "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive21_Unary_~(__arg0) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive21_Unary_~")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("~"+quote(__arg0)+"")
        stream.println(";")

      case mn@Primitive2_Forge_float_plus(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_float_plus")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Forge_float_minus(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_float_minus")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Forge_float_times(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_float_times")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Forge_float_divide(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_float_divide")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Forge_double_plus(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_double_plus")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Forge_double_minus(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_double_minus")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Forge_double_times(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_double_times")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Forge_double_divide(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_double_divide")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Forge_long_plus(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_long_plus")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Forge_long_minus(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_long_minus")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Forge_long_times(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_long_times")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Forge_long_divide(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_long_divide")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Forge_long_divide_double(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_long_divide_double")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Forge_long_and(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_long_and")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" & "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Forge_long_or(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_long_or")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" | "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive2_Forge_long_xor(__arg0,__arg1) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive2_Forge_long_xor")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+" ^ "+quote(__arg1)+"")
        stream.println(";")

      case mn@Primitive22_Unary_~(__arg0) => 
        Console.println("CGenPrimitive2Ops::emitNode::Primitive22_Unary_~")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("~"+quote(__arg0)+"")
        stream.println(";")

      case _ => 
        Console.println("CGenPrimitive2Ops::emitNode - going elsewhere")
        super.emitNode(sym, rhs)
    }
  }
}
