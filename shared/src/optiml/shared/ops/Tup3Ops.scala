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

trait Tup3Ops extends Base {
  this: OptiML => 

  def unpack[A:Manifest,B:Manifest,C:Manifest](t: Rep[Tup3[A,B,C]])(implicit __pos: SourceContext,__imp1: Overload6) = tup3_unpack[A,B,C](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],__pos)
  def pack[A:Manifest,B:Manifest,C:Manifest](t: Tuple3[Rep[A],Rep[B],Rep[C]])(implicit __pos: SourceContext,__imp1: Overload9) = tup3_pack[A,B,C](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],__pos)

  def infix__1[A:Manifest](__arg0: Rep[Tup3[A,_,_]])(implicit __pos: SourceContext,__imp1: Overload6) = tup3__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  def infix__2[B:Manifest](__arg0: Rep[Tup3[_,B,_]])(implicit __pos: SourceContext,__imp1: Overload6) = tup3__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  def infix__3[C:Manifest](__arg0: Rep[Tup3[_,_,C]])(implicit __pos: SourceContext,__imp1: Overload5) = tup3__3[C](__arg0)(implicitly[Manifest[C]],__pos)
  def infix_toString[A:Manifest,B:Manifest,C:Manifest](t: Rep[Tup3[A,B,C]])(implicit __imp0: Overload10) = tup3_tostring[A,B,C](t)

  def tup3__1[A:Manifest](__arg0: Rep[Tup3[A,_,_]])(implicit __pos: SourceContext): Rep[A]
  def tup3__2[B:Manifest](__arg0: Rep[Tup3[_,B,_]])(implicit __pos: SourceContext): Rep[B]
  def tup3__3[C:Manifest](__arg0: Rep[Tup3[_,_,C]])(implicit __pos: SourceContext): Rep[C]
  def tup3_unpack[A:Manifest,B:Manifest,C:Manifest](t: Rep[Tup3[A,B,C]])(implicit __pos: SourceContext): Tuple3[Rep[A],Rep[B],Rep[C]]
  def tup3_pack[A:Manifest,B:Manifest,C:Manifest](t: Tuple3[Rep[A],Rep[B],Rep[C]])(implicit __pos: SourceContext): Rep[Tup3[A,B,C]]
  def tup3_tostring[A:Manifest,B:Manifest,C:Manifest](t: Rep[Tup3[A,B,C]]): Rep[String]
}
trait Tup3CompilerOps extends Tup3Ops {
  this: OptiML => 

  def internal_pack3[A:Manifest,B:Manifest,C:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C])(implicit __pos: SourceContext): Rep[Tup3[A,B,C]]
}

