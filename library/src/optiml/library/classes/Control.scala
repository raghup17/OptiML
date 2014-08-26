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

trait ControlWrapper {
  this: OptiMLBase with OptiMLClasses => 

  def control_untilconverged[T:Manifest](x: Rep[T],tol: Rep[Double] = unit(.001),minIter: Rep[Int] = unit(1),maxIter: Rep[Int] = unit(1000),block: (Rep[T]) => Rep[T])(implicit __pos: SourceContext,diff: (Rep[T],Rep[T]) => Rep[Double]) = {
    control_untilconverged_impl[T](x,tol,minIter,maxIter,block)(implicitly[Manifest[T]],__pos,diff)
  }
  def control_untilconverged_buffered[T:Bufferable:Manifest](x: Rep[T],tol: Rep[Double] = unit(.001),minIter: Rep[Int] = unit(1),maxIter: Rep[Int] = unit(1000),block: (Rep[T]) => Rep[T])(implicit __pos: SourceContext,diff: (Rep[T],Rep[T]) => Rep[Double]) = {
    control_untilconverged_buffered_impl[T](x,tol,minIter,maxIter,block)(implicitly[Bufferable[T]],implicitly[Manifest[T]],__pos,diff)
  }

}

