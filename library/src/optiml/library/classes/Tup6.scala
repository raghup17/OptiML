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

trait Tup6Wrapper {
  this: OptiMLBase with OptiMLClasses => 

case class Tup6[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](___1: A, ___2: B, ___3: C, ___4: D, ___5: E, ___6: F) {
  var _1 = ___1
  var _2 = ___2
  var _3 = ___3
  var _4 = ___4
  var _5 = ___5
  var _6 = ___6

  override def toString() = {
    val t = this
    tup6_tostring_impl8[A,B,C,D,E,F](t)
  }
}

  def tup6__1[A:Manifest](__arg0: Rep[Tup6[A,_,_,_,_,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._1
  }
  def tup6__2[B:Manifest](__arg0: Rep[Tup6[_,B,_,_,_,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._2
  }
  def tup6__3[C:Manifest](__arg0: Rep[Tup6[_,_,C,_,_,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._3
  }
  def tup6__4[D:Manifest](__arg0: Rep[Tup6[_,_,_,D,_,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._4
  }
  def tup6__5[E:Manifest](__arg0: Rep[Tup6[_,_,_,_,E,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._5
  }
  def tup6__6[F:Manifest](__arg0: Rep[Tup6[_,_,_,_,_,F]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._6
  }
  def tup6_unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Rep[Tup6[A,B,C,D,E,F]])(implicit __pos: SourceContext) = {
    tup6_unpack_impl5[A,B,C,D,E,F](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],__pos)
  }
  def tup6_pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Tuple6[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F]])(implicit __pos: SourceContext) = {
    tup6_pack_impl8[A,B,C,D,E,F](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],__pos)
  }
  def internal_pack6[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C],__arg3: Rep[D],__arg4: Rep[E],__arg5: Rep[F])(implicit __pos: SourceContext) = {
    new Tup6[A,B,C,D,E,F](__arg0,__arg1,__arg2,__arg3,__arg4,__arg5)
  }
  def tup6_tostring[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Rep[Tup6[A,B,C,D,E,F]]) = {
    tup6_tostring_impl8[A,B,C,D,E,F](t)
  }

}

