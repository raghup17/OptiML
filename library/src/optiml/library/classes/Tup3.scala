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

trait Tup3Wrapper {
  this: OptiMLBase with OptiMLClasses => 

case class Tup3[A:Manifest,B:Manifest,C:Manifest](___1: A, ___2: B, ___3: C) {
  var _1 = ___1
  var _2 = ___2
  var _3 = ___3

  override def toString() = {
    val t = this
    tup3_tostring_impl10[A,B,C](t)
  }
}

  def tup3__1[A:Manifest](__arg0: Rep[Tup3[A,_,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._1
  }
  def tup3__2[B:Manifest](__arg0: Rep[Tup3[_,B,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._2
  }
  def tup3__3[C:Manifest](__arg0: Rep[Tup3[_,_,C]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._3
  }
  def tup3_unpack[A:Manifest,B:Manifest,C:Manifest](t: Rep[Tup3[A,B,C]])(implicit __pos: SourceContext) = {
    tup3_unpack_impl6[A,B,C](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],__pos)
  }
  def tup3_pack[A:Manifest,B:Manifest,C:Manifest](t: Tuple3[Rep[A],Rep[B],Rep[C]])(implicit __pos: SourceContext) = {
    tup3_pack_impl9[A,B,C](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],__pos)
  }
  def internal_pack3[A:Manifest,B:Manifest,C:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C])(implicit __pos: SourceContext) = {
    new Tup3[A,B,C](__arg0,__arg1,__arg2)
  }
  def tup3_tostring[A:Manifest,B:Manifest,C:Manifest](t: Rep[Tup3[A,B,C]]) = {
    tup3_tostring_impl10[A,B,C](t)
  }

}

