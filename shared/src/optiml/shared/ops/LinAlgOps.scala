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

trait LinAlgOps extends Base {
  this: OptiML => 

  def lu(__arg0: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext) = linalg_lu(__arg0)(__pos)
  def chol(A: Rep[DenseMatrix[Double]],tri: Rep[String] = unit("upper"))(implicit __pos: SourceContext) = linalg_chol(A,tri)(__pos)
  def det[T:Arith:Numeric:Manifest](x: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = linalg_det[T](x)(implicitly[Arith[T]],implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)

  def infix_\(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = linsolve(__arg0,__arg1)(__pos)

  def linsolve(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[DenseVector[Double]]
  def linalg_lu(__arg0: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext): Tuple3[Rep[DenseMatrix[Double]],Rep[DenseMatrix[Double]],Rep[DenseMatrix[Int]]]
  def linalg_chol(A: Rep[DenseMatrix[Double]],tri: Rep[String] = unit("upper"))(implicit __pos: SourceContext): Rep[DenseMatrix[Double]]
  def linalg_det[T:Arith:Numeric:Manifest](x: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[T]
}
trait LinAlgCompilerOps extends LinAlgOps {
  this: OptiML => 

  def densematrix_determinant_22[T:Arith:Numeric:Manifest](x: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[T]
  def densematrix_determinant_33[T:Arith:Numeric:Manifest](x: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[T]
  def densematrix_determinant_44[T:Arith:Numeric:Manifest](x: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[T]
}

