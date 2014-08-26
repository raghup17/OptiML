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

trait Tup8Wrapper {
  this: OptiMLBase with OptiMLClasses => 

case class Tup8[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](___1: A, ___2: B, ___3: C, ___4: D, ___5: E, ___6: F, ___7: G, ___8: H) {
  var _1 = ___1
  var _2 = ___2
  var _3 = ___3
  var _4 = ___4
  var _5 = ___5
  var _6 = ___6
  var _7 = ___7
  var _8 = ___8

  override def toString() = {
    val t = this
    tup8_tostring_impl4[A,B,C,D,E,F,G,H](t)
  }
}

  def tup8__1[A:Manifest](__arg0: Rep[Tup8[A,_,_,_,_,_,_,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._1
  }
  def tup8__2[B:Manifest](__arg0: Rep[Tup8[_,B,_,_,_,_,_,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._2
  }
  def tup8__3[C:Manifest](__arg0: Rep[Tup8[_,_,C,_,_,_,_,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._3
  }
  def tup8__4[D:Manifest](__arg0: Rep[Tup8[_,_,_,D,_,_,_,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._4
  }
  def tup8__5[E:Manifest](__arg0: Rep[Tup8[_,_,_,_,E,_,_,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._5
  }
  def tup8__6[F:Manifest](__arg0: Rep[Tup8[_,_,_,_,_,F,_,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._6
  }
  def tup8__7[G:Manifest](__arg0: Rep[Tup8[_,_,_,_,_,_,G,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._7
  }
  def tup8__8[H:Manifest](__arg0: Rep[Tup8[_,_,_,_,_,_,_,H]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._8
  }
  def tup8_unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](t: Rep[Tup8[A,B,C,D,E,F,G,H]])(implicit __pos: SourceContext) = {
    tup8_unpack_impl3[A,B,C,D,E,F,G,H](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],implicitly[Manifest[H]],__pos)
  }
  def tup8_pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](t: Tuple8[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G],Rep[H]])(implicit __pos: SourceContext) = {
    tup8_pack_impl6[A,B,C,D,E,F,G,H](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],implicitly[Manifest[H]],__pos)
  }
  def internal_pack8[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C],__arg3: Rep[D],__arg4: Rep[E],__arg5: Rep[F],__arg6: Rep[G],__arg7: Rep[H])(implicit __pos: SourceContext) = {
    new Tup8[A,B,C,D,E,F,G,H](__arg0,__arg1,__arg2,__arg3,__arg4,__arg5,__arg6,__arg7)
  }
  def tup8_tostring[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](t: Rep[Tup8[A,B,C,D,E,F,G,H]]) = {
    tup8_tostring_impl4[A,B,C,D,E,F,G,H](t)
  }

}

