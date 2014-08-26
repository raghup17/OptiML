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

trait Tup7Wrapper {
  this: OptiMLBase with OptiMLClasses => 

case class Tup7[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest](___1: A, ___2: B, ___3: C, ___4: D, ___5: E, ___6: F, ___7: G) {
  var _1 = ___1
  var _2 = ___2
  var _3 = ___3
  var _4 = ___4
  var _5 = ___5
  var _6 = ___6
  var _7 = ___7

  override def toString() = {
    val t = this
    tup7_tostring_impl6[A,B,C,D,E,F,G](t)
  }
}

  def tup7__1[A:Manifest](__arg0: Rep[Tup7[A,_,_,_,_,_,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._1
  }
  def tup7__2[B:Manifest](__arg0: Rep[Tup7[_,B,_,_,_,_,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._2
  }
  def tup7__3[C:Manifest](__arg0: Rep[Tup7[_,_,C,_,_,_,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._3
  }
  def tup7__4[D:Manifest](__arg0: Rep[Tup7[_,_,_,D,_,_,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._4
  }
  def tup7__5[E:Manifest](__arg0: Rep[Tup7[_,_,_,_,E,_,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._5
  }
  def tup7__6[F:Manifest](__arg0: Rep[Tup7[_,_,_,_,_,F,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._6
  }
  def tup7__7[G:Manifest](__arg0: Rep[Tup7[_,_,_,_,_,_,G]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._7
  }
  def tup7_unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest](t: Rep[Tup7[A,B,C,D,E,F,G]])(implicit __pos: SourceContext) = {
    tup7_unpack_impl4[A,B,C,D,E,F,G](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],__pos)
  }
  def tup7_pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest](t: Tuple7[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G]])(implicit __pos: SourceContext) = {
    tup7_pack_impl7[A,B,C,D,E,F,G](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],__pos)
  }
  def internal_pack7[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C],__arg3: Rep[D],__arg4: Rep[E],__arg5: Rep[F],__arg6: Rep[G])(implicit __pos: SourceContext) = {
    new Tup7[A,B,C,D,E,F,G](__arg0,__arg1,__arg2,__arg3,__arg4,__arg5,__arg6)
  }
  def tup7_tostring[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest](t: Rep[Tup7[A,B,C,D,E,F,G]]) = {
    tup7_tostring_impl6[A,B,C,D,E,F,G](t)
  }

}

