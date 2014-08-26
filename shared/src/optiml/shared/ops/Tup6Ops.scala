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

trait Tup6Ops extends Base {
  this: OptiML => 

  def unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Rep[Tup6[A,B,C,D,E,F]])(implicit __pos: SourceContext,__imp1: Overload5) = tup6_unpack[A,B,C,D,E,F](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],__pos)
  def pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Tuple6[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F]])(implicit __pos: SourceContext,__imp1: Overload8) = tup6_pack[A,B,C,D,E,F](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],__pos)

  def infix__1[A:Manifest](__arg0: Rep[Tup6[A,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload5) = tup6__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  def infix__2[B:Manifest](__arg0: Rep[Tup6[_,B,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload5) = tup6__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  def infix__3[C:Manifest](__arg0: Rep[Tup6[_,_,C,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload4) = tup6__3[C](__arg0)(implicitly[Manifest[C]],__pos)
  def infix__4[D:Manifest](__arg0: Rep[Tup6[_,_,_,D,_,_]])(implicit __pos: SourceContext,__imp1: Overload4) = tup6__4[D](__arg0)(implicitly[Manifest[D]],__pos)
  def infix__5[E:Manifest](__arg0: Rep[Tup6[_,_,_,_,E,_]])(implicit __pos: SourceContext,__imp1: Overload4) = tup6__5[E](__arg0)(implicitly[Manifest[E]],__pos)
  def infix__6[F:Manifest](__arg0: Rep[Tup6[_,_,_,_,_,F]])(implicit __pos: SourceContext,__imp1: Overload4) = tup6__6[F](__arg0)(implicitly[Manifest[F]],__pos)
  def infix_toString[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Rep[Tup6[A,B,C,D,E,F]])(implicit __imp0: Overload8) = tup6_tostring[A,B,C,D,E,F](t)

  def tup6__1[A:Manifest](__arg0: Rep[Tup6[A,_,_,_,_,_]])(implicit __pos: SourceContext): Rep[A]
  def tup6__2[B:Manifest](__arg0: Rep[Tup6[_,B,_,_,_,_]])(implicit __pos: SourceContext): Rep[B]
  def tup6__3[C:Manifest](__arg0: Rep[Tup6[_,_,C,_,_,_]])(implicit __pos: SourceContext): Rep[C]
  def tup6__4[D:Manifest](__arg0: Rep[Tup6[_,_,_,D,_,_]])(implicit __pos: SourceContext): Rep[D]
  def tup6__5[E:Manifest](__arg0: Rep[Tup6[_,_,_,_,E,_]])(implicit __pos: SourceContext): Rep[E]
  def tup6__6[F:Manifest](__arg0: Rep[Tup6[_,_,_,_,_,F]])(implicit __pos: SourceContext): Rep[F]
  def tup6_unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Rep[Tup6[A,B,C,D,E,F]])(implicit __pos: SourceContext): Tuple6[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F]]
  def tup6_pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Tuple6[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F]])(implicit __pos: SourceContext): Rep[Tup6[A,B,C,D,E,F]]
  def tup6_tostring[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Rep[Tup6[A,B,C,D,E,F]]): Rep[String]
}
trait Tup6CompilerOps extends Tup6Ops {
  this: OptiML => 

  def internal_pack6[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C],__arg3: Rep[D],__arg4: Rep[E],__arg5: Rep[F])(implicit __pos: SourceContext): Rep[Tup6[A,B,C,D,E,F]]
}

