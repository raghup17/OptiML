package optiml.library.classes

import scala.reflect.{Manifest,SourceContext}
import scala.math.Ordering.Implicits._
import scala.math.Numeric.Implicits._
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._
import optiml.library._
import optiml.library.classes._

/**
 * SingleTask and Composite Impls
 */

trait BasicMathWrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def basicmath_sigmoid_impl(__arg0: Rep[Double])(implicit __pos: SourceContext): Rep[Double] = {
    1.0 / (1.0 + exp(-__arg0))
  }

  def basicmath_normpdf_impl1(x: Rep[Double],mu: Rep[Double],sigma: Rep[Double])(implicit __pos: SourceContext): Rep[Double] = {
    (1.0 / (sigma * sqrt(2.0*Pi))) * exp(-((x-mu)*(x-mu)) / (2.0*sigma*sigma))
  }

  def basicmath_normpdf_impl2(x: Rep[DenseVector[Double]],mu: Rep[DenseVector[Double]],sigma: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[DenseVector[Double]] = {
    (0::x.length) { i => normpdf(x(i), mu(i), sigma(i)) }
  }

  def basicmath_normpdf_impl3(x: Rep[DenseMatrix[Double]],mu: Rep[DenseMatrix[Double]],sigma: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext): Rep[DenseMatrix[Double]] = {
    (0::x.numRows, 0::x.numCols) { (i,j) => normpdf(x(i,j), mu(i,j), sigma(i,j)) }
  }

  def basicmath_square_impl2[T:Manifest](__arg0: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    __arg0.map(e => e*e)
  }

  def basicmath_square_impl3[T:Manifest](__arg0: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    __arg0.map(e => e*e)
  }

  def basicmath_square_impl4(__arg0: Rep[IndexVector])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    __arg0.map(e => e*e)
  }

  def basicmath_square_impl5[T:Manifest](__arg0: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]] = {
    __arg0.map(e => e*e)
  }

  def basicmath_square_impl6[T:Manifest](__arg0: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseVector[T]] = {
    __arg0.mapnz(e => e*e)
  }

  def basicmath_square_impl7[T:Manifest](__arg0: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseMatrix[T]] = {
    __arg0.mapnz(e => e*e)
  }

  def basicmath_mean_impl7[T:Manifest](__arg0: Seq[Rep[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]): Rep[Double] = {
    densevector_fromarray(array_fromseq(__arg0),true).mean
  }

  def basicmath_min_impl8[T:Manifest](__arg0: Seq[Rep[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[T] = {
    densevector_fromarray(array_fromseq(__arg0),true).min
  }

  def basicmath_max_impl8[T:Manifest](__arg0: Seq[Rep[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[T] = {
    densevector_fromarray(array_fromseq(__arg0),true).max
  }

  def basicmath_median_impl2[T:Manifest](__arg0: Seq[Rep[T]])(implicit __pos: SourceContext,__imp0: Numeric[T],__imp1: Ordering[T]): Rep[T] = {
    densevector_fromarray(array_fromseq(__arg0),true).median
  }

}
