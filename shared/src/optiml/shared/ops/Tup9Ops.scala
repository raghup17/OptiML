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

trait Tup9Ops extends Base {
  this: OptiML => 

  def unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest](t: Rep[Tup9[A,B,C,D,E,F,G,H,I]])(implicit __pos: SourceContext,__imp1: Overload2) = tup9_unpack[A,B,C,D,E,F,G,H,I](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],implicitly[Manifest[H]],implicitly[Manifest[I]],__pos)
  def pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest](t: Tuple9[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G],Rep[H],Rep[I]])(implicit __pos: SourceContext,__imp1: Overload5) = tup9_pack[A,B,C,D,E,F,G,H,I](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],implicitly[Manifest[H]],implicitly[Manifest[I]],__pos)

  def infix__1[A:Manifest](__arg0: Rep[Tup9[A,_,_,_,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload2) = tup9__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  def infix__2[B:Manifest](__arg0: Rep[Tup9[_,B,_,_,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload2) = tup9__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  def infix__3[C:Manifest](__arg0: Rep[Tup9[_,_,C,_,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload1) = tup9__3[C](__arg0)(implicitly[Manifest[C]],__pos)
  def infix__4[D:Manifest](__arg0: Rep[Tup9[_,_,_,D,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload1) = tup9__4[D](__arg0)(implicitly[Manifest[D]],__pos)
  def infix__5[E:Manifest](__arg0: Rep[Tup9[_,_,_,_,E,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload1) = tup9__5[E](__arg0)(implicitly[Manifest[E]],__pos)
  def infix__6[F:Manifest](__arg0: Rep[Tup9[_,_,_,_,_,F,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload1) = tup9__6[F](__arg0)(implicitly[Manifest[F]],__pos)
  def infix__7[G:Manifest](__arg0: Rep[Tup9[_,_,_,_,_,_,G,_,_]])(implicit __pos: SourceContext,__imp1: Overload1) = tup9__7[G](__arg0)(implicitly[Manifest[G]],__pos)
  def infix__8[H:Manifest](__arg0: Rep[Tup9[_,_,_,_,_,_,_,H,_]])(implicit __pos: SourceContext,__imp1: Overload1) = tup9__8[H](__arg0)(implicitly[Manifest[H]],__pos)
  def infix__9[I:Manifest](__arg0: Rep[Tup9[_,_,_,_,_,_,_,_,I]])(implicit __pos: SourceContext) = tup9__9[I](__arg0)(implicitly[Manifest[I]],__pos)
  def infix_toString[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest](t: Rep[Tup9[A,B,C,D,E,F,G,H,I]])(implicit __imp0: Overload3) = tup9_tostring[A,B,C,D,E,F,G,H,I](t)

  def tup9__1[A:Manifest](__arg0: Rep[Tup9[A,_,_,_,_,_,_,_,_]])(implicit __pos: SourceContext): Rep[A]
  def tup9__2[B:Manifest](__arg0: Rep[Tup9[_,B,_,_,_,_,_,_,_]])(implicit __pos: SourceContext): Rep[B]
  def tup9__3[C:Manifest](__arg0: Rep[Tup9[_,_,C,_,_,_,_,_,_]])(implicit __pos: SourceContext): Rep[C]
  def tup9__4[D:Manifest](__arg0: Rep[Tup9[_,_,_,D,_,_,_,_,_]])(implicit __pos: SourceContext): Rep[D]
  def tup9__5[E:Manifest](__arg0: Rep[Tup9[_,_,_,_,E,_,_,_,_]])(implicit __pos: SourceContext): Rep[E]
  def tup9__6[F:Manifest](__arg0: Rep[Tup9[_,_,_,_,_,F,_,_,_]])(implicit __pos: SourceContext): Rep[F]
  def tup9__7[G:Manifest](__arg0: Rep[Tup9[_,_,_,_,_,_,G,_,_]])(implicit __pos: SourceContext): Rep[G]
  def tup9__8[H:Manifest](__arg0: Rep[Tup9[_,_,_,_,_,_,_,H,_]])(implicit __pos: SourceContext): Rep[H]
  def tup9__9[I:Manifest](__arg0: Rep[Tup9[_,_,_,_,_,_,_,_,I]])(implicit __pos: SourceContext): Rep[I]
  def tup9_unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest](t: Rep[Tup9[A,B,C,D,E,F,G,H,I]])(implicit __pos: SourceContext): Tuple9[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G],Rep[H],Rep[I]]
  def tup9_pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest](t: Tuple9[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G],Rep[H],Rep[I]])(implicit __pos: SourceContext): Rep[Tup9[A,B,C,D,E,F,G,H,I]]
  def tup9_tostring[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest](t: Rep[Tup9[A,B,C,D,E,F,G,H,I]]): Rep[String]
}
trait Tup9CompilerOps extends Tup9Ops {
  this: OptiML => 

  def internal_pack9[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C],__arg3: Rep[D],__arg4: Rep[E],__arg5: Rep[F],__arg6: Rep[G],__arg7: Rep[H],__arg8: Rep[I])(implicit __pos: SourceContext): Rep[Tup9[A,B,C,D,E,F,G,H,I]]
}

