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

trait FStringWrapper {
  this: OptiMLBase with OptiMLClasses => 

  def fstring_toint(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.toInt
  }
  def fstring_tolong(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.toLong
  }
  def fstring_tofloat(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.toFloat
  }
  def fstring_todouble(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.toDouble
  }
  def fstring_toboolean(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.toBoolean
  }
  def fstring_trim(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.trim
  }
  def fstring_fcharat(__arg0: Rep[String],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0.charAt(__arg1)
  }
  def fstring_startswith(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.startsWith(__arg1)
  }
  def fstring_slice(__arg0: Rep[String],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0.slice(__arg1,__arg2)
  }
  def fstring_length(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.length
  }
  def fstring_endswith(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.endsWith(__arg1)
  }
  def fstring_contains(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.contains(__arg1)
  }
  def fstring_substring(__arg0: Rep[String],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = {
    __arg0.substring(__arg1)
  }
  def fstring_substring(__arg0: Rep[String],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = {
    __arg0.substring(__arg1,__arg2)
  }
  def fstring_fsplit(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    fstring_fsplit_impl(__arg0,__arg1)(__pos)
  }
  def fstring_pl[T:Manifest](__arg0: Rep[String],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload43) = {
    __arg0.toString + __arg1.toString
  }
  def fstring_pl[T:Manifest](__arg0: Rep[T],__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: Overload49) = {
    __arg0.toString + __arg1.toString
  }
  def fstring_pl(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: Overload54) = {
    __arg0.toString + __arg1.toString
  }
  def fstring_optila_fmt_str[T:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = {
    
    def numericStr[A](x: A) = {
      val s = ("% ."+Global.numericPrecision+"g").format(x)
      val padPrefix = (Global.numericPrecision+6) - s.length
      if (padPrefix > 0) " "*padPrefix + s else s
    }
    if (__arg0.isInstanceOf[Double] || __arg0.isInstanceOf[Float]) numericStr(__arg0) else ("" + __arg0)
  }
  def optila_padspace(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    optila_padspace_impl(__arg0)(__pos)
  }

}

