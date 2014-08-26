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

trait Tup5Ops extends Base {
  this: OptiML => 

  def unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Rep[Tup5[A,B,C,D,E]])(implicit __pos: SourceContext,__imp1: Overload8) = tup5_unpack[A,B,C,D,E](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],__pos)
  def pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Tuple5[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E]])(implicit __pos: SourceContext,__imp1: Overload11) = tup5_pack[A,B,C,D,E](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],__pos)

  def infix__1[A:Manifest](__arg0: Rep[Tup5[A,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload8) = tup5__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  def infix__2[B:Manifest](__arg0: Rep[Tup5[_,B,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload8) = tup5__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  def infix__3[C:Manifest](__arg0: Rep[Tup5[_,_,C,_,_]])(implicit __pos: SourceContext,__imp1: Overload7) = tup5__3[C](__arg0)(implicitly[Manifest[C]],__pos)
  def infix__4[D:Manifest](__arg0: Rep[Tup5[_,_,_,D,_]])(implicit __pos: SourceContext,__imp1: Overload6) = tup5__4[D](__arg0)(implicitly[Manifest[D]],__pos)
  def infix__5[E:Manifest](__arg0: Rep[Tup5[_,_,_,_,E]])(implicit __pos: SourceContext,__imp1: Overload5) = tup5__5[E](__arg0)(implicitly[Manifest[E]],__pos)
  def infix_toString[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Rep[Tup5[A,B,C,D,E]])(implicit __imp0: Overload13) = tup5_tostring[A,B,C,D,E](t)

  def tup5__1[A:Manifest](__arg0: Rep[Tup5[A,_,_,_,_]])(implicit __pos: SourceContext): Rep[A]
  def tup5__2[B:Manifest](__arg0: Rep[Tup5[_,B,_,_,_]])(implicit __pos: SourceContext): Rep[B]
  def tup5__3[C:Manifest](__arg0: Rep[Tup5[_,_,C,_,_]])(implicit __pos: SourceContext): Rep[C]
  def tup5__4[D:Manifest](__arg0: Rep[Tup5[_,_,_,D,_]])(implicit __pos: SourceContext): Rep[D]
  def tup5__5[E:Manifest](__arg0: Rep[Tup5[_,_,_,_,E]])(implicit __pos: SourceContext): Rep[E]
  def tup5_unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Rep[Tup5[A,B,C,D,E]])(implicit __pos: SourceContext): Tuple5[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E]]
  def tup5_pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Tuple5[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E]])(implicit __pos: SourceContext): Rep[Tup5[A,B,C,D,E]]
  def tup5_tostring[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Rep[Tup5[A,B,C,D,E]]): Rep[String]
}
trait Tup5CompilerOps extends Tup5Ops {
  this: OptiML => 

  def internal_pack5[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C],__arg3: Rep[D],__arg4: Rep[E])(implicit __pos: SourceContext): Rep[Tup5[A,B,C,D,E]]
}

