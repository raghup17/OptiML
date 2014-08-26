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

trait Tup7Ops extends Base {
  this: OptiML => 

  def unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest](t: Rep[Tup7[A,B,C,D,E,F,G]])(implicit __pos: SourceContext,__imp1: Overload4) = tup7_unpack[A,B,C,D,E,F,G](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],__pos)
  def pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest](t: Tuple7[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G]])(implicit __pos: SourceContext,__imp1: Overload7) = tup7_pack[A,B,C,D,E,F,G](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],__pos)

  def infix__1[A:Manifest](__arg0: Rep[Tup7[A,_,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload4) = tup7__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  def infix__2[B:Manifest](__arg0: Rep[Tup7[_,B,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload4) = tup7__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  def infix__3[C:Manifest](__arg0: Rep[Tup7[_,_,C,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload3) = tup7__3[C](__arg0)(implicitly[Manifest[C]],__pos)
  def infix__4[D:Manifest](__arg0: Rep[Tup7[_,_,_,D,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload3) = tup7__4[D](__arg0)(implicitly[Manifest[D]],__pos)
  def infix__5[E:Manifest](__arg0: Rep[Tup7[_,_,_,_,E,_,_]])(implicit __pos: SourceContext,__imp1: Overload3) = tup7__5[E](__arg0)(implicitly[Manifest[E]],__pos)
  def infix__6[F:Manifest](__arg0: Rep[Tup7[_,_,_,_,_,F,_]])(implicit __pos: SourceContext,__imp1: Overload3) = tup7__6[F](__arg0)(implicitly[Manifest[F]],__pos)
  def infix__7[G:Manifest](__arg0: Rep[Tup7[_,_,_,_,_,_,G]])(implicit __pos: SourceContext,__imp1: Overload3) = tup7__7[G](__arg0)(implicitly[Manifest[G]],__pos)
  def infix_toString[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest](t: Rep[Tup7[A,B,C,D,E,F,G]])(implicit __imp0: Overload6) = tup7_tostring[A,B,C,D,E,F,G](t)

  def tup7__1[A:Manifest](__arg0: Rep[Tup7[A,_,_,_,_,_,_]])(implicit __pos: SourceContext): Rep[A]
  def tup7__2[B:Manifest](__arg0: Rep[Tup7[_,B,_,_,_,_,_]])(implicit __pos: SourceContext): Rep[B]
  def tup7__3[C:Manifest](__arg0: Rep[Tup7[_,_,C,_,_,_,_]])(implicit __pos: SourceContext): Rep[C]
  def tup7__4[D:Manifest](__arg0: Rep[Tup7[_,_,_,D,_,_,_]])(implicit __pos: SourceContext): Rep[D]
  def tup7__5[E:Manifest](__arg0: Rep[Tup7[_,_,_,_,E,_,_]])(implicit __pos: SourceContext): Rep[E]
  def tup7__6[F:Manifest](__arg0: Rep[Tup7[_,_,_,_,_,F,_]])(implicit __pos: SourceContext): Rep[F]
  def tup7__7[G:Manifest](__arg0: Rep[Tup7[_,_,_,_,_,_,G]])(implicit __pos: SourceContext): Rep[G]
  def tup7_unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest](t: Rep[Tup7[A,B,C,D,E,F,G]])(implicit __pos: SourceContext): Tuple7[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G]]
  def tup7_pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest](t: Tuple7[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G]])(implicit __pos: SourceContext): Rep[Tup7[A,B,C,D,E,F,G]]
  def tup7_tostring[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest](t: Rep[Tup7[A,B,C,D,E,F,G]]): Rep[String]
}
trait Tup7CompilerOps extends Tup7Ops {
  this: OptiML => 

  def internal_pack7[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C],__arg3: Rep[D],__arg4: Rep[E],__arg5: Rep[F],__arg6: Rep[G])(implicit __pos: SourceContext): Rep[Tup7[A,B,C,D,E,F,G]]
}

