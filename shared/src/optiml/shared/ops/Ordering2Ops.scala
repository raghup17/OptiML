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

trait Ordering2Ops extends Base {
  this: OptiML => 

  def __equal[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext,__imp1: Overload18) = ordering2___equal[A,B](__arg0,__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos,overload18)
  def __equal[A:Manifest,B:Manifest](__arg0: Var[A],__arg1: Rep[B])(implicit __pos: SourceContext,__imp1: Overload19) = ordering2___equal[A,B](__arg0,__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos,overload18)
  def __equal[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Var[B])(implicit __pos: SourceContext,__imp1: Overload20) = ordering2___equal[A,B](__arg0,__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos,overload18)
  def __equal[A:Manifest,B:Manifest](__arg0: Var[A],__arg1: Var[B])(implicit __pos: SourceContext,__imp1: Overload21) = ordering2___equal[A,B](__arg0,__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos,overload18)
  def __equal[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: B)(implicit __pos: SourceContext,__imp1: Overload22) = ordering2___equal[A,B](__arg0,unit(__arg1))(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos,overload18)
  def __equal[A:Manifest,B:Manifest](__arg0: Var[A],__arg1: B)(implicit __pos: SourceContext,__imp1: Overload23) = ordering2___equal[A,B](__arg0,unit(__arg1))(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos,overload18)
  def __equal[A:Manifest,B:Manifest](__arg0: A,__arg1: Rep[B])(implicit __pos: SourceContext,__imp1: Overload24) = ordering2___equal[A,B](unit(__arg0),__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos,overload18)
  def __equal[A:Manifest,B:Manifest](__arg0: A,__arg1: Var[B])(implicit __pos: SourceContext,__imp1: Overload25) = ordering2___equal[A,B](unit(__arg0),__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos,overload18)

  implicit def repToOrdering2AOpsCls[A:Manifest](x: Rep[A])(implicit __pos: SourceContext) = new Ordering2AOpsCls(x)(implicitly[Manifest[A]],__pos)
  implicit def varToOrdering2AOpsCls[A:Manifest](x: Var[A])(implicit __pos: SourceContext) = new Ordering2AOpsCls(readVar(x))(implicitly[Manifest[A]],__pos)

  class Ordering2AOpsCls[A:Manifest](val self: Rep[A])(implicit __pos: SourceContext) {
    def <(__arg1: Rep[A])(implicit __pos: SourceContext,__imp1: Ordering[A]) = ordering2_lt[A](self,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos)
    def <=(__arg1: Rep[A])(implicit __pos: SourceContext,__imp1: Ordering[A]) = ordering2_lteq[A](self,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos)
    def >(__arg1: Rep[A])(implicit __pos: SourceContext,__imp1: Ordering[A]) = ordering2_gt[A](self,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos)
    def >=(__arg1: Rep[A])(implicit __pos: SourceContext,__imp1: Ordering[A]) = ordering2_gteq[A](self,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos)
  }


  def infix_!=[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext,__imp1: Overload1) = ordering2_bangeq[A,B](__arg0,__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos,overload1)
  def infix_!=[A:Manifest,B:Manifest](__arg0: Var[A],__arg1: Rep[B])(implicit __pos: SourceContext,__imp1: Overload2) = ordering2_bangeq[A,B](__arg0,__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos,overload1)
  def infix_!=[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Var[B])(implicit __pos: SourceContext,__imp1: Overload3) = ordering2_bangeq[A,B](__arg0,__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos,overload1)
  def infix_!=[A:Manifest,B:Manifest](__arg0: Var[A],__arg1: Var[B])(implicit __pos: SourceContext,__imp1: Overload4) = ordering2_bangeq[A,B](__arg0,__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos,overload1)
  def infix_!=[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: B)(implicit __pos: SourceContext,__imp1: Overload5) = ordering2_bangeq[A,B](__arg0,unit(__arg1))(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos,overload1)
  def infix_!=[A:Manifest,B:Manifest](__arg0: Var[A],__arg1: B)(implicit __pos: SourceContext,__imp1: Overload6) = ordering2_bangeq[A,B](__arg0,unit(__arg1))(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos,overload1)
  def infix_!=[A:Manifest,B:Manifest](__arg0: A,__arg1: Rep[B])(implicit __pos: SourceContext,__imp1: Overload7) = ordering2_bangeq[A,B](unit(__arg0),__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos,overload1)
  def infix_!=[A:Manifest,B:Manifest](__arg0: A,__arg1: Var[B])(implicit __pos: SourceContext,__imp1: Overload8) = ordering2_bangeq[A,B](unit(__arg0),__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos,overload1)
  def infix_min[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext,__imp1: Overload8) = ordering2_min[A](__arg0,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos)
  def infix_max[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext,__imp1: Overload8) = ordering2_max[A](__arg0,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos)

  def ordering2___equal[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext,__imp1: Overload18): Rep[Boolean]
  def ordering2_bangeq[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext,__imp1: Overload1): Rep[Boolean]
  def ordering2_min[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext): Rep[A]
  def ordering2_max[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext): Rep[A]
  def ordering2_lt[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext): Rep[Boolean]
  def ordering2_lteq[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext): Rep[Boolean]
  def ordering2_gt[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext): Rep[Boolean]
  def ordering2_gteq[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext): Rep[Boolean]
}
