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

trait Tup2Wrapper {
  this: OptiMLBase with OptiMLClasses => 

case class Tup2[A:Manifest,B:Manifest](___1: A, ___2: B) {
  var _1 = ___1
  var _2 = ___2

  override def toString() = {
    val t = this
    tup2_tostring_impl2[A,B](t)
  }
}

  def tup2__1[A:Manifest](__arg0: Rep[Tup2[A,_]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._1
  }
  def tup2__2[B:Manifest](__arg0: Rep[Tup2[_,B]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    __arg0._2
  }
  def tup2_unpack[A:Manifest,B:Manifest](t: Rep[Tup2[A,B]])(implicit __pos: SourceContext) = {
    tup2_unpack_impl1[A,B](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos)
  }
  def tup2_pack[A:Manifest,B:Manifest](t: Tuple2[Rep[A],Rep[B]])(implicit __pos: SourceContext,__imp1: Overload1) = {
    tup2_pack_impl1[A,B](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos)
  }
  def internal_pack2[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext) = {
    new Tup2[A,B](__arg0,__arg1)
  }
  def tup2_tostring[A:Manifest,B:Manifest](t: Rep[Tup2[A,B]]) = {
    tup2_tostring_impl2[A,B](t)
  }

}

