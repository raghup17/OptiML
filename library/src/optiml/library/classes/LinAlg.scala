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

trait LinAlgWrapper {
  this: OptiMLBase with OptiMLClasses => 

  def linsolve(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    linsolve_impl(__arg0,__arg1)(__pos)
  }
  def linalg_lu(__arg0: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext) = {
    linalg_lu_impl(__arg0)(__pos)
  }
  def linalg_chol(A: Rep[DenseMatrix[Double]],tri: Rep[String] = unit("upper"))(implicit __pos: SourceContext) = {
    linalg_chol_impl(A,tri)(__pos)
  }
  def densematrix_determinant_22[T:Arith:Numeric:Manifest](x: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = {
    densematrix_determinant_22_impl[T](x)(implicitly[Arith[T]],implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  }
  def densematrix_determinant_33[T:Arith:Numeric:Manifest](x: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = {
    densematrix_determinant_33_impl[T](x)(implicitly[Arith[T]],implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  }
  def densematrix_determinant_44[T:Arith:Numeric:Manifest](x: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = {
    densematrix_determinant_44_impl[T](x)(implicitly[Arith[T]],implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  }
  def linalg_det[T:Arith:Numeric:Manifest](x: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = {
    linalg_det_impl[T](x)(implicitly[Arith[T]],implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  }

}

