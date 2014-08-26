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

trait BasicMathWrapper {
  this: OptiMLBase with OptiMLClasses => 

  def basicmath_max[T:Numeric:Manifest](__arg0: Rep[T],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload1) = {
    implicitly[Numeric[T]].max(__arg0,__arg1)
  }
  def basicmath_min[T:Numeric:Manifest](__arg0: Rep[T],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload1) = {
    implicitly[Numeric[T]].min(__arg0,__arg1)
  }
  def basicmath_sigmoid(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
    basicmath_sigmoid_impl(__arg0)(__pos)
  }
  def basicmath_normpdf(x: Rep[Double],mu: Rep[Double],sigma: Rep[Double])(implicit __pos: SourceContext,__imp1: Overload1) = {
    basicmath_normpdf_impl1(x,mu,sigma)(__pos)
  }
  def basicmath_normpdf(x: Rep[DenseVector[Double]],mu: Rep[DenseVector[Double]],sigma: Rep[DenseVector[Double]])(implicit __pos: SourceContext,__imp1: Overload2) = {
    basicmath_normpdf_impl2(x,mu,sigma)(__pos)
  }
  def basicmath_normpdf(x: Rep[DenseMatrix[Double]],mu: Rep[DenseMatrix[Double]],sigma: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: Overload3) = {
    basicmath_normpdf_impl3(x,mu,sigma)(__pos)
  }
  def basicmath_square[T:Manifest](__arg0: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = {
    basicmath_square_impl2[T](__arg0)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def basicmath_square[T:Manifest](__arg0: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload3) = {
    basicmath_square_impl3[T](__arg0)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def basicmath_square(__arg0: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload4) = {
    basicmath_square_impl4(__arg0)(__pos)
  }
  def basicmath_square[T:Manifest](__arg0: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload5) = {
    basicmath_square_impl5[T](__arg0)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def basicmath_square[T:Manifest](__arg0: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload6) = {
    basicmath_square_impl6[T](__arg0)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def basicmath_square[T:Manifest](__arg0: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload7) = {
    basicmath_square_impl7[T](__arg0)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def basicmath_mean[T:Manifest](__arg0: Seq[Rep[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double],__imp2: Overload7) = {
    basicmath_mean_impl7[T](__arg0)(implicitly[Manifest[T]],__pos,conv)
  }
  def basicmath_min[T:Manifest](__arg0: Seq[Rep[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload8) = {
    basicmath_min_impl8[T](__arg0)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def basicmath_max[T:Manifest](__arg0: Seq[Rep[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload8) = {
    basicmath_max_impl8[T](__arg0)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def basicmath_median[T:Manifest](__arg0: Seq[Rep[T]])(implicit __pos: SourceContext,__imp0: Numeric[T],__imp1: Ordering[T],__imp3: Overload2) = {
    basicmath_median_impl2[T](__arg0)(implicitly[Manifest[T]],__pos,__imp0,__imp1)
  }

}

