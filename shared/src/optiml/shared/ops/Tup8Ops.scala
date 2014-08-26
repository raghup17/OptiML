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

trait Tup8Ops extends Base {
  this: OptiML => 

  def unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](t: Rep[Tup8[A,B,C,D,E,F,G,H]])(implicit __pos: SourceContext,__imp1: Overload3) = tup8_unpack[A,B,C,D,E,F,G,H](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],implicitly[Manifest[H]],__pos)
  def pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](t: Tuple8[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G],Rep[H]])(implicit __pos: SourceContext,__imp1: Overload6) = tup8_pack[A,B,C,D,E,F,G,H](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],implicitly[Manifest[H]],__pos)

  def infix__1[A:Manifest](__arg0: Rep[Tup8[A,_,_,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload3) = tup8__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  def infix__2[B:Manifest](__arg0: Rep[Tup8[_,B,_,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload3) = tup8__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  def infix__3[C:Manifest](__arg0: Rep[Tup8[_,_,C,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload2) = tup8__3[C](__arg0)(implicitly[Manifest[C]],__pos)
  def infix__4[D:Manifest](__arg0: Rep[Tup8[_,_,_,D,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload2) = tup8__4[D](__arg0)(implicitly[Manifest[D]],__pos)
  def infix__5[E:Manifest](__arg0: Rep[Tup8[_,_,_,_,E,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload2) = tup8__5[E](__arg0)(implicitly[Manifest[E]],__pos)
  def infix__6[F:Manifest](__arg0: Rep[Tup8[_,_,_,_,_,F,_,_]])(implicit __pos: SourceContext,__imp1: Overload2) = tup8__6[F](__arg0)(implicitly[Manifest[F]],__pos)
  def infix__7[G:Manifest](__arg0: Rep[Tup8[_,_,_,_,_,_,G,_]])(implicit __pos: SourceContext,__imp1: Overload2) = tup8__7[G](__arg0)(implicitly[Manifest[G]],__pos)
  def infix__8[H:Manifest](__arg0: Rep[Tup8[_,_,_,_,_,_,_,H]])(implicit __pos: SourceContext,__imp1: Overload2) = tup8__8[H](__arg0)(implicitly[Manifest[H]],__pos)
  def infix_toString[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](t: Rep[Tup8[A,B,C,D,E,F,G,H]])(implicit __imp0: Overload4) = tup8_tostring[A,B,C,D,E,F,G,H](t)

  def tup8__1[A:Manifest](__arg0: Rep[Tup8[A,_,_,_,_,_,_,_]])(implicit __pos: SourceContext): Rep[A]
  def tup8__2[B:Manifest](__arg0: Rep[Tup8[_,B,_,_,_,_,_,_]])(implicit __pos: SourceContext): Rep[B]
  def tup8__3[C:Manifest](__arg0: Rep[Tup8[_,_,C,_,_,_,_,_]])(implicit __pos: SourceContext): Rep[C]
  def tup8__4[D:Manifest](__arg0: Rep[Tup8[_,_,_,D,_,_,_,_]])(implicit __pos: SourceContext): Rep[D]
  def tup8__5[E:Manifest](__arg0: Rep[Tup8[_,_,_,_,E,_,_,_]])(implicit __pos: SourceContext): Rep[E]
  def tup8__6[F:Manifest](__arg0: Rep[Tup8[_,_,_,_,_,F,_,_]])(implicit __pos: SourceContext): Rep[F]
  def tup8__7[G:Manifest](__arg0: Rep[Tup8[_,_,_,_,_,_,G,_]])(implicit __pos: SourceContext): Rep[G]
  def tup8__8[H:Manifest](__arg0: Rep[Tup8[_,_,_,_,_,_,_,H]])(implicit __pos: SourceContext): Rep[H]
  def tup8_unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](t: Rep[Tup8[A,B,C,D,E,F,G,H]])(implicit __pos: SourceContext): Tuple8[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G],Rep[H]]
  def tup8_pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](t: Tuple8[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G],Rep[H]])(implicit __pos: SourceContext): Rep[Tup8[A,B,C,D,E,F,G,H]]
  def tup8_tostring[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](t: Rep[Tup8[A,B,C,D,E,F,G,H]]): Rep[String]
}
trait Tup8CompilerOps extends Tup8Ops {
  this: OptiML => 

  def internal_pack8[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C],__arg3: Rep[D],__arg4: Rep[E],__arg5: Rep[F],__arg6: Rep[G],__arg7: Rep[H])(implicit __pos: SourceContext): Rep[Tup8[A,B,C,D,E,F,G,H]]
}

