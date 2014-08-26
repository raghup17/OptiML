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

trait Ordering2Wrapper {
  this: OptiMLBase with OptiMLClasses => 

  def ordering2___equal[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext,__imp1: Overload18) = {
    __arg0 == __arg1
  }
  def ordering2_bangeq[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext,__imp1: Overload1) = {
    __arg0 != __arg1
  }
  def ordering2_min[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    __arg0 min __arg1
  }
  def ordering2_max[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    __arg0 max __arg1
  }
  def ordering2_lt[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    __arg0 < __arg1
  }
  def ordering2_lteq[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    __arg0 <= __arg1
  }
  def ordering2_gt[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    __arg0 > __arg1
  }
  def ordering2_gteq[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    __arg0 >= __arg1
  }

}

