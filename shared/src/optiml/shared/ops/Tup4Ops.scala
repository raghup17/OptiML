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

trait Tup4Ops extends Base {
  this: OptiML => 

  def unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Rep[Tup4[A,B,C,D]])(implicit __pos: SourceContext,__imp1: Overload7) = tup4_unpack[A,B,C,D](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],__pos)
  def pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Tuple4[Rep[A],Rep[B],Rep[C],Rep[D]])(implicit __pos: SourceContext,__imp1: Overload10) = tup4_pack[A,B,C,D](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],__pos)

  def infix__1[A:Manifest](__arg0: Rep[Tup4[A,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload7) = tup4__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  def infix__2[B:Manifest](__arg0: Rep[Tup4[_,B,_,_]])(implicit __pos: SourceContext,__imp1: Overload7) = tup4__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  def infix__3[C:Manifest](__arg0: Rep[Tup4[_,_,C,_]])(implicit __pos: SourceContext,__imp1: Overload6) = tup4__3[C](__arg0)(implicitly[Manifest[C]],__pos)
  def infix__4[D:Manifest](__arg0: Rep[Tup4[_,_,_,D]])(implicit __pos: SourceContext,__imp1: Overload5) = tup4__4[D](__arg0)(implicitly[Manifest[D]],__pos)
  def infix_toString[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Rep[Tup4[A,B,C,D]])(implicit __imp0: Overload12) = tup4_tostring[A,B,C,D](t)

  def tup4__1[A:Manifest](__arg0: Rep[Tup4[A,_,_,_]])(implicit __pos: SourceContext): Rep[A]
  def tup4__2[B:Manifest](__arg0: Rep[Tup4[_,B,_,_]])(implicit __pos: SourceContext): Rep[B]
  def tup4__3[C:Manifest](__arg0: Rep[Tup4[_,_,C,_]])(implicit __pos: SourceContext): Rep[C]
  def tup4__4[D:Manifest](__arg0: Rep[Tup4[_,_,_,D]])(implicit __pos: SourceContext): Rep[D]
  def tup4_unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Rep[Tup4[A,B,C,D]])(implicit __pos: SourceContext): Tuple4[Rep[A],Rep[B],Rep[C],Rep[D]]
  def tup4_pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Tuple4[Rep[A],Rep[B],Rep[C],Rep[D]])(implicit __pos: SourceContext): Rep[Tup4[A,B,C,D]]
  def tup4_tostring[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Rep[Tup4[A,B,C,D]]): Rep[String]
}
trait Tup4CompilerOps extends Tup4Ops {
  this: OptiML => 

  def internal_pack4[A:Manifest,B:Manifest,C:Manifest,D:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C],__arg3: Rep[D])(implicit __pos: SourceContext): Rep[Tup4[A,B,C,D]]
}

