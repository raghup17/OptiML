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

trait Tup5Wrapper {
  this: OptiMLBase with OptiMLClasses => 

case class Tup5[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](___1: A, ___2: B, ___3: C, ___4: D, ___5: E) {
  var _1 = ___1
  var _2 = ___2
  var _3 = ___3
  var _4 = ___4
  var _5 = ___5

  override def toString() = {
    val t = this
    tup5_tostring_impl13[A,B,C,D,E](t)
  }
}

  def tup5__1[A:Manifest](__arg0: Rep[Tup5[A,_,_,_,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._1
  }
  def tup5__2[B:Manifest](__arg0: Rep[Tup5[_,B,_,_,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._2
  }
  def tup5__3[C:Manifest](__arg0: Rep[Tup5[_,_,C,_,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._3
  }
  def tup5__4[D:Manifest](__arg0: Rep[Tup5[_,_,_,D,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._4
  }
  def tup5__5[E:Manifest](__arg0: Rep[Tup5[_,_,_,_,E]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._5
  }
  def tup5_unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Rep[Tup5[A,B,C,D,E]])(implicit __pos: SourceContext) = {
    tup5_unpack_impl8[A,B,C,D,E](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],__pos)
  }
  def tup5_pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Tuple5[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E]])(implicit __pos: SourceContext) = {
    tup5_pack_impl11[A,B,C,D,E](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],__pos)
  }
  def internal_pack5[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C],__arg3: Rep[D],__arg4: Rep[E])(implicit __pos: SourceContext) = {
    new Tup5[A,B,C,D,E](__arg0,__arg1,__arg2,__arg3,__arg4)
  }
  def tup5_tostring[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Rep[Tup5[A,B,C,D,E]]) = {
    tup5_tostring_impl13[A,B,C,D,E](t)
  }

}

