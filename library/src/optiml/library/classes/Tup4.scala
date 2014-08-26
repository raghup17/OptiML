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

trait Tup4Wrapper {
  this: OptiMLBase with OptiMLClasses => 

case class Tup4[A:Manifest,B:Manifest,C:Manifest,D:Manifest](___1: A, ___2: B, ___3: C, ___4: D) {
  var _1 = ___1
  var _2 = ___2
  var _3 = ___3
  var _4 = ___4

  override def toString() = {
    val t = this
    tup4_tostring_impl12[A,B,C,D](t)
  }
}

  def tup4__1[A:Manifest](__arg0: Rep[Tup4[A,_,_,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._1
  }
  def tup4__2[B:Manifest](__arg0: Rep[Tup4[_,B,_,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._2
  }
  def tup4__3[C:Manifest](__arg0: Rep[Tup4[_,_,C,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._3
  }
  def tup4__4[D:Manifest](__arg0: Rep[Tup4[_,_,_,D]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._4
  }
  def tup4_unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Rep[Tup4[A,B,C,D]])(implicit __pos: SourceContext) = {
    tup4_unpack_impl7[A,B,C,D](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],__pos)
  }
  def tup4_pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Tuple4[Rep[A],Rep[B],Rep[C],Rep[D]])(implicit __pos: SourceContext) = {
    tup4_pack_impl10[A,B,C,D](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],__pos)
  }
  def internal_pack4[A:Manifest,B:Manifest,C:Manifest,D:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C],__arg3: Rep[D])(implicit __pos: SourceContext) = {
    new Tup4[A,B,C,D](__arg0,__arg1,__arg2,__arg3)
  }
  def tup4_tostring[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Rep[Tup4[A,B,C,D]]) = {
    tup4_tostring_impl12[A,B,C,D](t)
  }

}

