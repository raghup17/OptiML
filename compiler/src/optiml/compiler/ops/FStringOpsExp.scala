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

trait FStringOpsExp extends FStringCompilerOps with BaseFatExp with EffectExp {
  this: OptiMLExp => 

  case class FString3_ToInt(__arg0: Rep[String])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class FString2_ToLong(__arg0: Rep[String])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class FString3_ToFloat(__arg0: Rep[String])(implicit val __pos: SourceContext) extends Def[Float] {
  }

  case class FString3_ToDouble(__arg0: Rep[String])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class FString2_ToBoolean(__arg0: Rep[String])(implicit val __pos: SourceContext) extends Def[Boolean] {
  }

  case class FString2_Trim(__arg0: Rep[String])(implicit val __pos: SourceContext) extends Def[String] {
  }

  case class FString_FcharAt(__arg0: Rep[String],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Char] {
  }

  case class FString_StartsWith(__arg0: Rep[String],__arg1: Rep[String])(implicit val __pos: SourceContext) extends Def[Boolean] {
  }

  case class FString3_Slice(__arg0: Rep[String],__arg1: Rep[Int],__arg2: Rep[Int])(implicit val __pos: SourceContext) extends Def[String] {
  }

  case class FString4_Length(__arg0: Rep[String])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class FString_EndsWith(__arg0: Rep[String],__arg1: Rep[String])(implicit val __pos: SourceContext) extends Def[Boolean] {
  }

  case class FString5_Contains(__arg0: Rep[String],__arg1: Rep[String])(implicit val __pos: SourceContext) extends Def[Boolean] {
  }

  case class FString1_Substring(__arg0: Rep[String],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[String] {
  }

  case class FString2_Substring(__arg0: Rep[String],__arg1: Rep[Int],__arg2: Rep[Int])(implicit val __pos: SourceContext) extends Def[String] {
  }

  case class FString43_Pl[T:Manifest](__arg0: Rep[String],__arg1: Rep[T])(implicit val __pos: SourceContext) extends Def[String] {
    val _mT = implicitly[Manifest[T]]
  }

  case class FString49_Pl[T:Manifest](__arg0: Rep[T],__arg1: Rep[String])(implicit val __pos: SourceContext) extends Def[String] {
    val _mT = implicitly[Manifest[T]]
  }

  case class FString54_Pl(__arg0: Rep[String],__arg1: Rep[String])(implicit val __pos: SourceContext) extends Def[String] {
  }

  case class FString_Optila_fmt_str[T:Manifest](__arg0: Rep[T])(implicit val __pos: SourceContext) extends Def[String] {
    val _mT = implicitly[Manifest[T]]
  }



  def fstring_toint(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString3_ToInt(__arg0)(__pos))
  }
  def fstring_tolong(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString2_ToLong(__arg0)(__pos))
  }
  def fstring_tofloat(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString3_ToFloat(__arg0)(__pos))
  }
  def fstring_todouble(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString3_ToDouble(__arg0)(__pos))
  }
  def fstring_toboolean(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString2_ToBoolean(__arg0)(__pos))
  }
  def fstring_trim(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString2_Trim(__arg0)(__pos))
  }
  def fstring_fcharat(__arg0: Rep[String],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(FString_FcharAt(__arg0,__arg1)(__pos))
  }
  def fstring_startswith(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString_StartsWith(__arg0,__arg1)(__pos))
  }
  def fstring_slice(__arg0: Rep[String],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(FString3_Slice(__arg0,__arg1,__arg2)(__pos))
  }
  def fstring_length(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString4_Length(__arg0)(__pos))
  }
  def fstring_endswith(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString_EndsWith(__arg0,__arg1)(__pos))
  }
  def fstring_contains(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString5_Contains(__arg0,__arg1)(__pos))
  }
  def fstring_substring(__arg0: Rep[String],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = {
    reflectPure(FString1_Substring(__arg0,__arg1)(__pos))
  }
  def fstring_substring(__arg0: Rep[String],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = {
    reflectPure(FString2_Substring(__arg0,__arg1,__arg2)(__pos))
  }
  def fstring_fsplit(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    fstring_fsplit_impl(__arg0,__arg1)(__pos)
  }
  def fstring_pl[T:Manifest](__arg0: Rep[String],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload43) = {
    reflectPure(FString43_Pl[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos))
  }
  def fstring_pl[T:Manifest](__arg0: Rep[T],__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: Overload49) = {
    reflectPure(FString49_Pl[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos))
  }
  def fstring_pl(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: Overload54) = {
    reflectPure(FString54_Pl(__arg0,__arg1)(__pos))
  }
  def fstring_optila_fmt_str[T:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = {
    reflectPure(FString_Optila_fmt_str[T](__arg0)(implicitly[Manifest[T]],__pos))
  }
  def optila_padspace(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    optila_padspace_impl(__arg0)(__pos)
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@FString3_ToInt(__arg0) => fstring_toint(f(__arg0))(mn.__pos)
    case Reflect(mn@FString3_ToInt(__arg0), u, es) => reflectMirrored(Reflect(FString3_ToInt(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString2_ToLong(__arg0) => fstring_tolong(f(__arg0))(mn.__pos)
    case Reflect(mn@FString2_ToLong(__arg0), u, es) => reflectMirrored(Reflect(FString2_ToLong(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString3_ToFloat(__arg0) => fstring_tofloat(f(__arg0))(mn.__pos)
    case Reflect(mn@FString3_ToFloat(__arg0), u, es) => reflectMirrored(Reflect(FString3_ToFloat(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString3_ToDouble(__arg0) => fstring_todouble(f(__arg0))(mn.__pos)
    case Reflect(mn@FString3_ToDouble(__arg0), u, es) => reflectMirrored(Reflect(FString3_ToDouble(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString2_ToBoolean(__arg0) => fstring_toboolean(f(__arg0))(mn.__pos)
    case Reflect(mn@FString2_ToBoolean(__arg0), u, es) => reflectMirrored(Reflect(FString2_ToBoolean(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString2_Trim(__arg0) => fstring_trim(f(__arg0))(mn.__pos)
    case Reflect(mn@FString2_Trim(__arg0), u, es) => reflectMirrored(Reflect(FString2_Trim(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString_FcharAt(__arg0,__arg1) => fstring_fcharat(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@FString_FcharAt(__arg0,__arg1), u, es) => reflectMirrored(Reflect(FString_FcharAt(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString_StartsWith(__arg0,__arg1) => fstring_startswith(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@FString_StartsWith(__arg0,__arg1), u, es) => reflectMirrored(Reflect(FString_StartsWith(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString3_Slice(__arg0,__arg1,__arg2) => fstring_slice(f(__arg0),f(__arg1),f(__arg2))(mn.__pos)
    case Reflect(mn@FString3_Slice(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(FString3_Slice(f(__arg0),f(__arg1),f(__arg2))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString4_Length(__arg0) => fstring_length(f(__arg0))(mn.__pos)
    case Reflect(mn@FString4_Length(__arg0), u, es) => reflectMirrored(Reflect(FString4_Length(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString_EndsWith(__arg0,__arg1) => fstring_endswith(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@FString_EndsWith(__arg0,__arg1), u, es) => reflectMirrored(Reflect(FString_EndsWith(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString5_Contains(__arg0,__arg1) => fstring_contains(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@FString5_Contains(__arg0,__arg1), u, es) => reflectMirrored(Reflect(FString5_Contains(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString1_Substring(__arg0,__arg1) => fstring_substring(f(__arg0),f(__arg1))(mn.__pos,overload1)
    case Reflect(mn@FString1_Substring(__arg0,__arg1), u, es) => reflectMirrored(Reflect(FString1_Substring(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString2_Substring(__arg0,__arg1,__arg2) => fstring_substring(f(__arg0),f(__arg1),f(__arg2))(mn.__pos,overload2)
    case Reflect(mn@FString2_Substring(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(FString2_Substring(f(__arg0),f(__arg1),f(__arg2))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString43_Pl(__arg0,__arg1) => fstring_pl(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos,overload43)
    case Reflect(mn@FString43_Pl(__arg0,__arg1), u, es) => reflectMirrored(Reflect(FString43_Pl(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString49_Pl(__arg0,__arg1) => fstring_pl(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos,overload49)
    case Reflect(mn@FString49_Pl(__arg0,__arg1), u, es) => reflectMirrored(Reflect(FString49_Pl(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString54_Pl(__arg0,__arg1) => fstring_pl(f(__arg0),f(__arg1))(mn.__pos,overload54)
    case Reflect(mn@FString54_Pl(__arg0,__arg1), u, es) => reflectMirrored(Reflect(FString54_Pl(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString_Optila_fmt_str(__arg0) => fstring_optila_fmt_str(f(__arg0))(mtype(mn._mT),mn.__pos)
    case Reflect(mn@FString_Optila_fmt_str(__arg0), u, es) => reflectMirrored(Reflect(FString_Optila_fmt_str(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


}

/**
 * Code generators
 */

trait ScalaGenFStringOps extends ScalaGenFat {
  val IR: FStringOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@FString3_ToInt(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toInt")
      stream.println("}")

    case mn@FString2_ToLong(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toLong")
      stream.println("}")

    case mn@FString3_ToFloat(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toFloat")
      stream.println("}")

    case mn@FString3_ToDouble(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toDouble")
      stream.println("}")

    case mn@FString2_ToBoolean(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toBoolean")
      stream.println("}")

    case mn@FString2_Trim(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".trim")
      stream.println("}")

    case mn@FString_FcharAt(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".charAt("+quote(__arg1)+")")
      stream.println("}")

    case mn@FString_StartsWith(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".startsWith("+quote(__arg1)+")")
      stream.println("}")

    case mn@FString3_Slice(__arg0,__arg1,__arg2) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".slice("+quote(__arg1)+","+quote(__arg2)+")")
      stream.println("}")

    case mn@FString4_Length(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".length")
      stream.println("}")

    case mn@FString_EndsWith(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".endsWith("+quote(__arg1)+")")
      stream.println("}")

    case mn@FString5_Contains(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".contains("+quote(__arg1)+")")
      stream.println("}")

    case mn@FString1_Substring(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".substring("+quote(__arg1)+")")
      stream.println("}")

    case mn@FString2_Substring(__arg0,__arg1,__arg2) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".substring("+quote(__arg1)+","+quote(__arg2)+")")
      stream.println("}")

    case mn@FString43_Pl(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toString + "+quote(__arg1)+".toString")
      stream.println("}")

    case mn@FString49_Pl(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toString + "+quote(__arg1)+".toString")
      stream.println("}")

    case mn@FString54_Pl(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toString + "+quote(__arg1)+".toString")
      stream.println("}")

    case mn@FString_Optila_fmt_str(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("\ndef numericStr[A](x: A) = {\n  val s = (\"% .\"+Global.numericPrecision+\"g\").format(x)\n  val padPrefix = (Global.numericPrecision+6) - s.length\n  if (padPrefix > 0) \" \"*padPrefix + s else s\n}\nif ("+quote(__arg0)+".isInstanceOf[Double] || "+quote(__arg0)+".isInstanceOf[Float]) numericStr("+quote(__arg0)+") else (\"\" + "+quote(__arg0)+")\n")
      stream.println("}")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CGenFStringOps extends CGenFat {
  val IR: FStringOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@FString3_ToInt(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_toInt("+quote(__arg0)+")")
      stream.println(";")

    case mn@FString2_ToLong(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_toLong("+quote(__arg0)+")")
      stream.println(";")

    case mn@FString3_ToFloat(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_toFloat("+quote(__arg0)+")")
      stream.println(";")

    case mn@FString3_ToDouble(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_toDouble("+quote(__arg0)+")")
      stream.println(";")

    case mn@FString2_ToBoolean(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_toBoolean("+quote(__arg0)+")")
      stream.println(";")

    case mn@FString2_Trim(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_trim("+quote(__arg0)+")")
      stream.println(";")

    case mn@FString_FcharAt(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_charAt("+quote(__arg0)+","+quote(__arg1)+")")
      stream.println(";")

    case mn@FString_StartsWith(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_startsWith("+quote(__arg0)+","+quote(__arg1)+")")
      stream.println(";")

    case mn@FString3_Slice(__arg0,__arg1,__arg2) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_substr("+quote(__arg0)+","+quote(__arg1)+","+quote(__arg2)+")")
      stream.println(";")

    case mn@FString4_Length(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_length("+quote(__arg0)+")")
      stream.println(";")

    case mn@FString_EndsWith(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_endsWith("+quote(__arg0)+","+quote(__arg1)+")")
      stream.println(";")

    case mn@FString5_Contains(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_contains("+quote(__arg0)+","+quote(__arg1)+")")
      stream.println(";")

    case mn@FString1_Substring(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_substr("+quote(__arg0)+","+quote(__arg1)+")")
      stream.println(";")

    case mn@FString2_Substring(__arg0,__arg1,__arg2) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_substr("+quote(__arg0)+","+quote(__arg1)+","+quote(__arg2)+")")
      stream.println(";")

    case mn@FString43_Pl(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_plus( convert_to_string< "+remapWithRef(__arg0.tp)+">("+quote(__arg0)+"), convert_to_string< "+remapWithRef(__arg1.tp)+">("+quote(__arg1)+"))")
      stream.println(";")

    case mn@FString49_Pl(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_plus( convert_to_string< "+remapWithRef(__arg0.tp)+">("+quote(__arg0)+"), convert_to_string< "+remapWithRef(__arg1.tp)+">("+quote(__arg1)+"))")
      stream.println(";")

    case mn@FString54_Pl(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_plus( convert_to_string< "+remapWithRef(__arg0.tp)+">("+quote(__arg0)+"), convert_to_string< "+remapWithRef(__arg1.tp)+">("+quote(__arg1)+"))")
      stream.println(";")

    case mn@FString_Optila_fmt_str(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("convert_to_string<"+remapWithRef(__arg0.tp)+" >("+quote(__arg0)+")")
      stream.println(";")

    case _ => super.emitNode(sym, rhs)
  }
}
