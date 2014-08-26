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

trait MiscOps extends Base {
  this: OptiML => 

  def exit(__arg0: Rep[Int])(implicit __pos: SourceContext) = misc_exit(__arg0)(__pos)
  def print(__arg0: Rep[Any])(implicit __pos: SourceContext) = misc_print(__arg0)(__pos)
  def fatal(__arg0: Rep[String])(implicit __pos: SourceContext) = misc_fatal(__arg0)(__pos)
  def println(__arg0: Rep[Any])(implicit __pos: SourceContext,__imp1: Overload1) = misc_println(__arg0)(__pos,overload1)
  def println()(implicit __pos: SourceContext,__imp1: Overload2) = misc_println()(__pos,overload2)
  def __whileDo(__arg0:  => Rep[Boolean],__arg1:  => Rep[Unit])(implicit __pos: SourceContext) = misc___whiledo(__arg0,__arg1)(__pos)
  def __ifThenElse[T:Manifest](__arg0:  => Rep[Boolean],__arg1:  => Rep[T],__arg2:  => Rep[T])(implicit __pos: SourceContext) = misc___ifthenelse[T](__arg0,__arg1,__arg2)(implicitly[Manifest[T]],__pos)

  def infix_unsafeImmutable[T:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = misc_unsafeimmutable[T](__arg0)(implicitly[Manifest[T]],__pos)
  def infix_unsafeMutable[T:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = misc_unsafemutable[T](__arg0)(implicitly[Manifest[T]],__pos)

  def misc_exit(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def misc_print(__arg0: Rep[Any])(implicit __pos: SourceContext): Rep[Unit]
  def misc_fatal(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[Nothing]
  def misc_println(__arg0: Rep[Any])(implicit __pos: SourceContext,__imp1: Overload1): Rep[Unit]
  def misc_println()(implicit __pos: SourceContext,__imp1: Overload2): Rep[Unit]
  def misc___whiledo(__arg0:  => Rep[Boolean],__arg1:  => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit]
  def misc___ifthenelse[T:Manifest](__arg0:  => Rep[Boolean],__arg1:  => Rep[T],__arg2:  => Rep[T])(implicit __pos: SourceContext): Rep[T]
  def misc_unsafeimmutable[T:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext): Rep[T]
  def misc_unsafemutable[T:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext): Rep[T]
}
