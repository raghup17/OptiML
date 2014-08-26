package optiml.compiler.ops

import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import ppl.delite.framework.ops.DeliteCollection
import ppl.delite.framework.datastructures._
import ppl.delite.framework.ops.{DeliteOpsExp, DeliteCollectionOpsExp}
import ppl.delite.framework.Util._
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._
import optiml.compiler._
import optiml.compiler.ops._

/**
 * IR Definitions
 */

trait LinAlgOpsExp extends LinAlgCompilerOps with BaseFatExp with EffectExp {
  this: OptiMLExp => 



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



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


}

