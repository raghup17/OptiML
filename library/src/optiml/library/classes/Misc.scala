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

trait MiscWrapper {
  this: OptiMLBase with OptiMLClasses => 

  def misc_exit(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    sys.exit(__arg0)
  }
  def misc_print(__arg0: Rep[Any])(implicit __pos: SourceContext) = {
    print(__arg0)
  }
  def misc_fatal(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    throw new Exception(__arg0)
  }
  def misc_println(__arg0: Rep[Any])(implicit __pos: SourceContext,__imp1: Overload1) = {
    println(__arg0)
  }
  def misc_println()(implicit __pos: SourceContext,__imp1: Overload2) = {
    println()
  }
  def misc___whiledo(__arg0:  => Rep[Boolean],__arg1:  => Rep[Unit])(implicit __pos: SourceContext) = {
    while (__arg0) {
      __arg1
    }
  }
  def misc___ifthenelse[T:Manifest](__arg0:  => Rep[Boolean],__arg1:  => Rep[T],__arg2:  => Rep[T])(implicit __pos: SourceContext) = {
    if (__arg0) {
      __arg1
    }
    else {
      __arg2
    }
  }
  def misc_unsafeimmutable[T:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = {
    __arg0 // unsafe immutable
  }
  def misc_unsafemutable[T:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = {
    __arg0 // unsafe mutable
  }

}

