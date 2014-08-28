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

trait MathOpsExp extends MathOps with BaseFatExp with EffectExp {
  this: OptiMLExp => 

  case class Math_INF()(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class Math_NINF()(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class MathObject_Bitcount(__arg0: Rep[Long])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class MathObject_Abs(__arg0: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class MathObject_Exp(__arg0: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class MathObject_Log(__arg0: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class MathObject_Log10(__arg0: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class MathObject_Sqrt(__arg0: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class MathObject_Ceil(__arg0: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class MathObject_Floor(__arg0: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class MathObject_Round(__arg0: Rep[Double])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class MathObject_Sin(__arg0: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class MathObject_Sinh(__arg0: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class MathObject_Asin(__arg0: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class MathObject_Cos(__arg0: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class MathObject_Cosh(__arg0: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class MathObject_Acos(__arg0: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class MathObject_Tan(__arg0: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class MathObject_Tanh(__arg0: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class MathObject_Atan(__arg0: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class MathObject_Atan2(__arg0: Rep[Double],__arg1: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class MathObject_Pow(__arg0: Rep[Double],__arg1: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class MathObject_Max(__arg0: Rep[Double],__arg1: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class MathObject_Min(__arg0: Rep[Double],__arg1: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }



  def math_inf()(implicit __pos: SourceContext) = {
    reflectPure(Math_INF()(__pos))
  }
  def math_ninf()(implicit __pos: SourceContext) = {
    reflectPure(Math_NINF()(__pos))
  }
  def math_object_bitcount(__arg0: Rep[Long])(implicit __pos: SourceContext) = {
    reflectPure(MathObject_Bitcount(__arg0)(__pos))
  }
  def math_object_abs(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(MathObject_Abs(__arg0)(__pos))
  }
  def math_object_exp(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(MathObject_Exp(__arg0)(__pos))
  }
  def math_object_log(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(MathObject_Log(__arg0)(__pos))
  }
  def math_object_log10(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(MathObject_Log10(__arg0)(__pos))
  }
  def math_object_sqrt(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(MathObject_Sqrt(__arg0)(__pos))
  }
  def math_object_ceil(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(MathObject_Ceil(__arg0)(__pos))
  }
  def math_object_floor(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(MathObject_Floor(__arg0)(__pos))
  }
  def math_object_round(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(MathObject_Round(__arg0)(__pos))
  }
  def math_object_sin(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(MathObject_Sin(__arg0)(__pos))
  }
  def math_object_sinh(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(MathObject_Sinh(__arg0)(__pos))
  }
  def math_object_asin(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(MathObject_Asin(__arg0)(__pos))
  }
  def math_object_cos(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(MathObject_Cos(__arg0)(__pos))
  }
  def math_object_cosh(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(MathObject_Cosh(__arg0)(__pos))
  }
  def math_object_acos(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(MathObject_Acos(__arg0)(__pos))
  }
  def math_object_tan(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(MathObject_Tan(__arg0)(__pos))
  }
  def math_object_tanh(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(MathObject_Tanh(__arg0)(__pos))
  }
  def math_object_atan(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(MathObject_Atan(__arg0)(__pos))
  }
  def math_object_atan2(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(MathObject_Atan2(__arg0,__arg1)(__pos))
  }
  def math_object_pow(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(MathObject_Pow(__arg0,__arg1)(__pos))
  }
  def math_object_max(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(MathObject_Max(__arg0,__arg1)(__pos))
  }
  def math_object_min(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(MathObject_Min(__arg0,__arg1)(__pos))
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Math_INF() => math_inf()(mn.__pos)
    case Reflect(mn@Math_INF(), u, es) => reflectMirrored(Reflect(Math_INF()(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Math_NINF() => math_ninf()(mn.__pos)
    case Reflect(mn@Math_NINF(), u, es) => reflectMirrored(Reflect(Math_NINF()(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MathObject_Bitcount(__arg0) => math_object_bitcount(f(__arg0))(mn.__pos)
    case Reflect(mn@MathObject_Bitcount(__arg0), u, es) => reflectMirrored(Reflect(MathObject_Bitcount(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MathObject_Abs(__arg0) => math_object_abs(f(__arg0))(mn.__pos)
    case Reflect(mn@MathObject_Abs(__arg0), u, es) => reflectMirrored(Reflect(MathObject_Abs(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MathObject_Exp(__arg0) => math_object_exp(f(__arg0))(mn.__pos)
    case Reflect(mn@MathObject_Exp(__arg0), u, es) => reflectMirrored(Reflect(MathObject_Exp(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MathObject_Log(__arg0) => math_object_log(f(__arg0))(mn.__pos)
    case Reflect(mn@MathObject_Log(__arg0), u, es) => reflectMirrored(Reflect(MathObject_Log(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MathObject_Log10(__arg0) => math_object_log10(f(__arg0))(mn.__pos)
    case Reflect(mn@MathObject_Log10(__arg0), u, es) => reflectMirrored(Reflect(MathObject_Log10(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MathObject_Sqrt(__arg0) => math_object_sqrt(f(__arg0))(mn.__pos)
    case Reflect(mn@MathObject_Sqrt(__arg0), u, es) => reflectMirrored(Reflect(MathObject_Sqrt(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MathObject_Ceil(__arg0) => math_object_ceil(f(__arg0))(mn.__pos)
    case Reflect(mn@MathObject_Ceil(__arg0), u, es) => reflectMirrored(Reflect(MathObject_Ceil(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MathObject_Floor(__arg0) => math_object_floor(f(__arg0))(mn.__pos)
    case Reflect(mn@MathObject_Floor(__arg0), u, es) => reflectMirrored(Reflect(MathObject_Floor(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MathObject_Round(__arg0) => math_object_round(f(__arg0))(mn.__pos)
    case Reflect(mn@MathObject_Round(__arg0), u, es) => reflectMirrored(Reflect(MathObject_Round(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MathObject_Sin(__arg0) => math_object_sin(f(__arg0))(mn.__pos)
    case Reflect(mn@MathObject_Sin(__arg0), u, es) => reflectMirrored(Reflect(MathObject_Sin(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MathObject_Sinh(__arg0) => math_object_sinh(f(__arg0))(mn.__pos)
    case Reflect(mn@MathObject_Sinh(__arg0), u, es) => reflectMirrored(Reflect(MathObject_Sinh(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MathObject_Asin(__arg0) => math_object_asin(f(__arg0))(mn.__pos)
    case Reflect(mn@MathObject_Asin(__arg0), u, es) => reflectMirrored(Reflect(MathObject_Asin(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MathObject_Cos(__arg0) => math_object_cos(f(__arg0))(mn.__pos)
    case Reflect(mn@MathObject_Cos(__arg0), u, es) => reflectMirrored(Reflect(MathObject_Cos(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MathObject_Cosh(__arg0) => math_object_cosh(f(__arg0))(mn.__pos)
    case Reflect(mn@MathObject_Cosh(__arg0), u, es) => reflectMirrored(Reflect(MathObject_Cosh(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MathObject_Acos(__arg0) => math_object_acos(f(__arg0))(mn.__pos)
    case Reflect(mn@MathObject_Acos(__arg0), u, es) => reflectMirrored(Reflect(MathObject_Acos(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MathObject_Tan(__arg0) => math_object_tan(f(__arg0))(mn.__pos)
    case Reflect(mn@MathObject_Tan(__arg0), u, es) => reflectMirrored(Reflect(MathObject_Tan(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MathObject_Tanh(__arg0) => math_object_tanh(f(__arg0))(mn.__pos)
    case Reflect(mn@MathObject_Tanh(__arg0), u, es) => reflectMirrored(Reflect(MathObject_Tanh(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MathObject_Atan(__arg0) => math_object_atan(f(__arg0))(mn.__pos)
    case Reflect(mn@MathObject_Atan(__arg0), u, es) => reflectMirrored(Reflect(MathObject_Atan(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MathObject_Atan2(__arg0,__arg1) => math_object_atan2(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@MathObject_Atan2(__arg0,__arg1), u, es) => reflectMirrored(Reflect(MathObject_Atan2(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MathObject_Pow(__arg0,__arg1) => math_object_pow(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@MathObject_Pow(__arg0,__arg1), u, es) => reflectMirrored(Reflect(MathObject_Pow(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MathObject_Max(__arg0,__arg1) => math_object_max(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@MathObject_Max(__arg0,__arg1), u, es) => reflectMirrored(Reflect(MathObject_Max(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MathObject_Min(__arg0,__arg1) => math_object_min(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@MathObject_Min(__arg0,__arg1), u, es) => reflectMirrored(Reflect(MathObject_Min(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


}

/**
 * Code generators
 */

trait ScalaGenMathOps extends ScalaGenFat {
  val IR: MathOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Math_INF() => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("Double.PositiveInfinity")
      stream.println("}")

    case mn@Math_NINF() => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("Double.NegativeInfinity")
      stream.println("}")

    case mn@MathObject_Bitcount(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.lang.Long.bitCount("+quote(__arg0)+")")
      stream.println("}")

    case mn@MathObject_Abs(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.lang.Math.abs("+quote(__arg0)+")")
      stream.println("}")

    case mn@MathObject_Exp(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.lang.Math.exp("+quote(__arg0)+")")
      stream.println("}")

    case mn@MathObject_Log(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.lang.Math.log("+quote(__arg0)+")")
      stream.println("}")

    case mn@MathObject_Log10(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.lang.Math.log10("+quote(__arg0)+")")
      stream.println("}")

    case mn@MathObject_Sqrt(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.lang.Math.sqrt("+quote(__arg0)+")")
      stream.println("}")

    case mn@MathObject_Ceil(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.lang.Math.ceil("+quote(__arg0)+")")
      stream.println("}")

    case mn@MathObject_Floor(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.lang.Math.floor("+quote(__arg0)+")")
      stream.println("}")

    case mn@MathObject_Round(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.lang.Math.round("+quote(__arg0)+")")
      stream.println("}")

    case mn@MathObject_Sin(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.lang.Math.sin("+quote(__arg0)+")")
      stream.println("}")

    case mn@MathObject_Sinh(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.lang.Math.sinh("+quote(__arg0)+")")
      stream.println("}")

    case mn@MathObject_Asin(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.lang.Math.asin("+quote(__arg0)+")")
      stream.println("}")

    case mn@MathObject_Cos(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.lang.Math.cos("+quote(__arg0)+")")
      stream.println("}")

    case mn@MathObject_Cosh(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.lang.Math.cosh("+quote(__arg0)+")")
      stream.println("}")

    case mn@MathObject_Acos(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.lang.Math.acos("+quote(__arg0)+")")
      stream.println("}")

    case mn@MathObject_Tan(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.lang.Math.tan("+quote(__arg0)+")")
      stream.println("}")

    case mn@MathObject_Tanh(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.lang.Math.tanh("+quote(__arg0)+")")
      stream.println("}")

    case mn@MathObject_Atan(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.lang.Math.atan("+quote(__arg0)+")")
      stream.println("}")

    case mn@MathObject_Atan2(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.lang.Math.atan2("+quote(__arg0)+", "+quote(__arg1)+")")
      stream.println("}")

    case mn@MathObject_Pow(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.lang.Math.pow("+quote(__arg0)+", "+quote(__arg1)+")")
      stream.println("}")

    case mn@MathObject_Max(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.lang.Math.max("+quote(__arg0)+", "+quote(__arg1)+")")
      stream.println("}")

    case mn@MathObject_Min(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.lang.Math.min("+quote(__arg0)+", "+quote(__arg1)+")")
      stream.println("}")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CudaGenMathOps extends CudaGenFat {
  val IR: MathOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Math_INF() => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("__longlong_as_double(0x7ff0000000000000ULL)")
      stream.println(";")

    case mn@Math_NINF() => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("__longlong_as_double(0xfff0000000000000ULL)")
      stream.println(";")

    case mn@MathObject_Abs(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("fabs("+quote(__arg0)+")")
      stream.println(";")

    case mn@MathObject_Exp(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("exp("+quote(__arg0)+")")
      stream.println(";")

    case mn@MathObject_Log(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("log("+quote(__arg0)+")")
      stream.println(";")

    case mn@MathObject_Log10(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("log10("+quote(__arg0)+")")
      stream.println(";")

    case mn@MathObject_Sqrt(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("sqrt("+quote(__arg0)+")")
      stream.println(";")

    case mn@MathObject_Ceil(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("ceil("+quote(__arg0)+")")
      stream.println(";")

    case mn@MathObject_Floor(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("floor("+quote(__arg0)+")")
      stream.println(";")

    case mn@MathObject_Round(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("(long) round("+quote(__arg0)+")")
      stream.println(";")

    case mn@MathObject_Sin(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("sin("+quote(__arg0)+")")
      stream.println(";")

    case mn@MathObject_Sinh(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("sinh("+quote(__arg0)+")")
      stream.println(";")

    case mn@MathObject_Asin(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("asin("+quote(__arg0)+")")
      stream.println(";")

    case mn@MathObject_Cos(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("cos("+quote(__arg0)+")")
      stream.println(";")

    case mn@MathObject_Cosh(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("cosh("+quote(__arg0)+")")
      stream.println(";")

    case mn@MathObject_Acos(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("acos("+quote(__arg0)+")")
      stream.println(";")

    case mn@MathObject_Tan(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("tan("+quote(__arg0)+")")
      stream.println(";")

    case mn@MathObject_Tanh(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("tan("+quote(__arg0)+")")
      stream.println(";")

    case mn@MathObject_Atan(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("atan("+quote(__arg0)+")")
      stream.println(";")

    case mn@MathObject_Atan2(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("atan2("+quote(__arg0)+", "+quote(__arg1)+")")
      stream.println(";")

    case mn@MathObject_Pow(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("pow("+quote(__arg0)+", "+quote(__arg1)+")")
      stream.println(";")

    case mn@MathObject_Max(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("fmax("+quote(__arg0)+", "+quote(__arg1)+")")
      stream.println(";")

    case mn@MathObject_Min(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("fmin("+quote(__arg0)+", "+quote(__arg1)+")")
      stream.println(";")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CGenMathOps extends CGenFat {
  val IR: MathOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = {
      rhs match {
      case mn@Math_INF() => 
        Console.println("CGenMathOps::emitNode::Math_INF")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("std::numeric_limits<double>::max()")
        stream.println(";")

      case mn@Math_NINF() => 
        Console.println("CGenMathOps::emitNode::Math_NINF")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("std::numeric_limits<double>::min()")
        stream.println(";")

      case mn@MathObject_Abs(__arg0) => 
        Console.println("CGenMathOps::emitNode::MathObject_Abs")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("fabs("+quote(__arg0)+")")
        stream.println(";")

      case mn@MathObject_Exp(__arg0) => 
        Console.println("CGenMathOps::emitNode::MathObject_Exp")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("exp("+quote(__arg0)+")")
        stream.println(";")

      case mn@MathObject_Log(__arg0) => 
        Console.println("CGenMathOps::emitNode::MathObject_Log")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("log("+quote(__arg0)+")")
        stream.println(";")

      case mn@MathObject_Log10(__arg0) => 
        Console.println("CGenMathOps::emitNode::MathObject_Log10")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("log10("+quote(__arg0)+")")
        stream.println(";")

      case mn@MathObject_Sqrt(__arg0) => 
        Console.println("CGenMathOps::emitNode::MathObject_Sqrt")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("sqrt("+quote(__arg0)+")")
        stream.println(";")

      case mn@MathObject_Ceil(__arg0) => 
        Console.println("CGenMathOps::emitNode::MathObject_Ceil")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("ceil("+quote(__arg0)+")")
        stream.println(";")

      case mn@MathObject_Floor(__arg0) => 
        Console.println("CGenMathOps::emitNode::MathObject_Floor")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("floor("+quote(__arg0)+")")
        stream.println(";")

      case mn@MathObject_Round(__arg0) => 
        Console.println("CGenMathOps::emitNode::MathObject_Round")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("(long) round("+quote(__arg0)+")")
        stream.println(";")

      case mn@MathObject_Sin(__arg0) => 
        Console.println("CGenMathOps::emitNode::MathObject_Sin")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("sin("+quote(__arg0)+")")
        stream.println(";")

      case mn@MathObject_Sinh(__arg0) => 
        Console.println("CGenMathOps::emitNode::MathObject_Sinh")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("sinh("+quote(__arg0)+")")
        stream.println(";")

      case mn@MathObject_Asin(__arg0) => 
        Console.println("CGenMathOps::emitNode::MathObject_Asin")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("asin("+quote(__arg0)+")")
        stream.println(";")

      case mn@MathObject_Cos(__arg0) => 
        Console.println("CGenMathOps::emitNode::MathObject_Cos")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("cos("+quote(__arg0)+")")
        stream.println(";")

      case mn@MathObject_Cosh(__arg0) => 
        Console.println("CGenMathOps::emitNode::MathObject_Cosh")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("cosh("+quote(__arg0)+")")
        stream.println(";")

      case mn@MathObject_Acos(__arg0) => 
        Console.println("CGenMathOps::emitNode::MathObject_Acos")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("acos("+quote(__arg0)+")")
        stream.println(";")

      case mn@MathObject_Tan(__arg0) => 
        Console.println("CGenMathOps::emitNode::MathObject_Tan")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("tan("+quote(__arg0)+")")
        stream.println(";")

      case mn@MathObject_Tanh(__arg0) => 
        Console.println("CGenMathOps::emitNode::MathObject_Tanh")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("tan("+quote(__arg0)+")")
        stream.println(";")

      case mn@MathObject_Atan(__arg0) => 
        Console.println("CGenMathOps::emitNode::MathObject_Atan")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("atan("+quote(__arg0)+")")
        stream.println(";")

      case mn@MathObject_Atan2(__arg0,__arg1) => 
        Console.println("CGenMathOps::emitNode::MathObject_Atan2")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("atan2("+quote(__arg0)+", "+quote(__arg1)+")")
        stream.println(";")

      case mn@MathObject_Pow(__arg0,__arg1) => 
        Console.println("CGenMathOps::emitNode::MathObject_Pow")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("pow("+quote(__arg0)+", "+quote(__arg1)+")")
        stream.println(";")

      case mn@MathObject_Max(__arg0,__arg1) => 
        Console.println("CGenMathOps::emitNode::MathObject_Max")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("fmax("+quote(__arg0)+", "+quote(__arg1)+")")
        stream.println(";")

      case mn@MathObject_Min(__arg0,__arg1) => 
        Console.println("CGenMathOps::emitNode::MathObject_Min")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print("fmin("+quote(__arg0)+", "+quote(__arg1)+")")
        stream.println(";")

      case _ => 
        Console.println("CGenMathOps::emitNode - going elsewhere")
        super.emitNode(sym, rhs)
    }
  }
}
