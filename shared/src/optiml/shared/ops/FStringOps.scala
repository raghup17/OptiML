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

trait LiftFString {
  this: OptiML => 

  implicit def FStringStringToRep(x: String) = unit(x)
}

/**
 * Operations
 */

trait FStringOps extends Base {
  this: OptiML => 

  def optila_fmt_str[T:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = fstring_optila_fmt_str[T](__arg0)(implicitly[Manifest[T]],__pos)

  def infix_toInt(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload3) = fstring_toint(__arg0)(__pos)
  def infix_toLong(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload2) = fstring_tolong(__arg0)(__pos)
  def infix_toFloat(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload3) = fstring_tofloat(__arg0)(__pos)
  def infix_toDouble(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload3) = fstring_todouble(__arg0)(__pos)
  def infix_toBoolean(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload2) = fstring_toboolean(__arg0)(__pos)
  def infix_trim(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload2) = fstring_trim(__arg0)(__pos)
  def infix_fcharAt(__arg0: Rep[String],__arg1: Rep[Int])(implicit __pos: SourceContext) = fstring_fcharat(__arg0,__arg1)(__pos)
  def infix_startsWith(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext) = fstring_startswith(__arg0,__arg1)(__pos)
  def infix_slice(__arg0: Rep[String],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload3) = fstring_slice(__arg0,__arg1,__arg2)(__pos)
  def infix_length(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload4) = fstring_length(__arg0)(__pos)
  def infix_endsWith(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext) = fstring_endswith(__arg0,__arg1)(__pos)
  def infix_contains(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: Overload5) = fstring_contains(__arg0,__arg1)(__pos)
  def infix_substring(__arg0: Rep[String],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = fstring_substring(__arg0,__arg1)(__pos,overload1)
  def infix_substring(__arg0: Rep[String],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = fstring_substring(__arg0,__arg1,__arg2)(__pos,overload2)
  def infix_fsplit(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext) = fstring_fsplit(__arg0,__arg1)(__pos)
  def infix_+[T:Manifest](__arg0: String,__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload43) = fstring_pl[T](unit(__arg0),__arg1)(implicitly[Manifest[T]],__pos,overload43)
  def infix_+[T:Manifest](__arg0: Rep[String],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload44) = fstring_pl[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos,overload43)
  def infix_+[T:Manifest](__arg0: String,__arg1: Var[T])(implicit __pos: SourceContext,__imp1: Overload45) = fstring_pl[T](unit(__arg0),__arg1)(implicitly[Manifest[T]],__pos,overload43)
  def infix_+[T:Manifest](__arg0: Rep[String],__arg1: Var[T])(implicit __pos: SourceContext,__imp1: Overload46) = fstring_pl[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos,overload43)
  def infix_+[T:Manifest](__arg0: Var[String],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload47) = fstring_pl[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos,overload43)
  def infix_+[T:Manifest](__arg0: Var[String],__arg1: Var[T])(implicit __pos: SourceContext,__imp1: Overload48) = fstring_pl[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos,overload43)
  def infix_+[T:Manifest](__arg0: Rep[T],__arg1: String)(implicit __pos: SourceContext,__imp1: Overload49) = fstring_pl[T](__arg0,unit(__arg1))(implicitly[Manifest[T]],__pos,overload49)
  def infix_+[T:Manifest](__arg0: Rep[T],__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: Overload50) = fstring_pl[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos,overload49)
  def infix_+[T:Manifest](__arg0: Var[T],__arg1: String)(implicit __pos: SourceContext,__imp1: Overload51) = fstring_pl[T](__arg0,unit(__arg1))(implicitly[Manifest[T]],__pos,overload49)
  def infix_+[T:Manifest](__arg0: Var[T],__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: Overload52) = fstring_pl[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos,overload49)
  def infix_+[T:Manifest](__arg0: Var[T],__arg1: Var[String])(implicit __pos: SourceContext,__imp1: Overload53) = fstring_pl[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos,overload49)
  def infix_+(__arg0: String,__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: Overload54) = fstring_pl(unit(__arg0),__arg1)(__pos,overload54)
  def infix_+(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: Overload55) = fstring_pl(__arg0,__arg1)(__pos,overload54)
  def infix_+(__arg0: Rep[String],__arg1: Var[String])(implicit __pos: SourceContext,__imp1: Overload56) = fstring_pl(__arg0,__arg1)(__pos,overload54)
  def infix_+(__arg0: Var[String],__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: Overload57) = fstring_pl(__arg0,__arg1)(__pos,overload54)
  def infix_+(__arg0: Var[String],__arg1: Var[String])(implicit __pos: SourceContext,__imp1: Overload58) = fstring_pl(__arg0,__arg1)(__pos,overload54)

  def fstring_toint(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[Int]
  def fstring_tolong(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[Long]
  def fstring_tofloat(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[Float]
  def fstring_todouble(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[Double]
  def fstring_toboolean(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[Boolean]
  def fstring_trim(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[String]
  def fstring_fcharat(__arg0: Rep[String],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Char]
  def fstring_startswith(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext): Rep[Boolean]
  def fstring_slice(__arg0: Rep[String],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext): Rep[String]
  def fstring_length(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[Int]
  def fstring_endswith(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext): Rep[Boolean]
  def fstring_contains(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext): Rep[Boolean]
  def fstring_substring(__arg0: Rep[String],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1): Rep[String]
  def fstring_substring(__arg0: Rep[String],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2): Rep[String]
  def fstring_fsplit(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext): Rep[ForgeArray[String]]
  def fstring_pl[T:Manifest](__arg0: Rep[String],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload43): Rep[String]
  def fstring_pl[T:Manifest](__arg0: Rep[T],__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: Overload49): Rep[String]
  def fstring_pl(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: Overload54): Rep[String]
  def fstring_optila_fmt_str[T:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext): Rep[String]
}
trait FStringCompilerOps extends FStringOps {
  this: OptiML => 

  def optila_padspace(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[String]
}

