package optiml.compiler.ops

import scala.reflect.{Manifest,SourceContext}
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._
import optiml.compiler._
import optiml.compiler.ops._

/**
 * Op Impls
 */

trait LinAlgOpsImpl {
  this: OptiMLCompiler with OptiMLLift => 

  def linsolve_impl(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[DenseVector[Double]] = {
    fatal("no non-native \\ method exists")
  }

  def linalg_lu_impl(__arg0: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext): Tuple3[Rep[DenseMatrix[Double]],Rep[DenseMatrix[Double]],Rep[DenseMatrix[Int]]] = {
    (fatal("no non-native lu method exists"), fatal(""), fatal(""))
  }

  def linalg_chol_impl(A: Rep[DenseMatrix[Double]],tri: Rep[String] = unit("upper"))(implicit __pos: SourceContext): Rep[DenseMatrix[Double]] = {
    fatal("no non-native chol method exists")
  }

  def densematrix_determinant_22_impl[T:Arith:Numeric:Manifest](x: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[T] = {
    x(0,0)*x(1,1)-x(0,1)*x(1,0)
  }

  def densematrix_determinant_33_impl[T:Arith:Numeric:Manifest](x: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[T] = {
    x(0,0)*x(1,1)*x(2,2) + x(0,1)*x(1,2)*x(2,0) + x(0,2)*x(1,0)*x(2,1) -
    x(0,2)*x(1,1)*x(2,0) - x(0,1)*x(1,0)*x(2,2) - x(0,0)*x(1,2)*x(2,1)
  }

  def densematrix_determinant_44_impl[T:Arith:Numeric:Manifest](x: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[T] = {
    val two = unit(2).AsInstanceOf[T]
    
    x(0,1)*x(0,1)*x(2,3)*x(2,3)     - x(2,2)*x(3,3)*x(0,1)*x(0,1)     + two*x(3,3)*x(0,1)*x(0,2)*x(1,2) -
    two*x(0,1)*x(0,2)*x(1,3)*x(2,3) - two*x(0,1)*x(0,3)*x(1,2)*x(2,3) + two*x(2,2)*x(0,1)*x(0,3)*x(1,3) +
    x(0,2)*x(0,2)*x(1,3)*x(1,3)     - x(1,1)*x(3,3)*x(0,2)*x(0,2)     - two*x(0,2)*x(0,3)*x(1,2)*x(1,3) +
    two*x(1,1)*x(0,2)*x(0,3)*x(2,3) + x(0,3)*x(0,3)*x(1,2)*x(1,2)     - x(1,1)*x(2,2)*x(0,3)*x(0,3) -
    x(0,0)*x(3,3)*x(1,2)*x(1,2)     + two*x(0,0)*x(1,2)*x(1,3)*x(2,3) - x(0,0)*x(2,2)*x(1,3)*x(1,3) -
    x(0,0)*x(1,1)*x(2,3)*x(2,3)     + x(0,0)*x(1,1)*x(2,2)*x(3,3)
  }

  def linalg_det_impl[T:Arith:Numeric:Manifest](x: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[T] = {
    if (x.numRows == 2 && x.numCols == 2) densematrix_determinant_22(x)
    else if (x.numRows == 3 && x.numCols == 3) densematrix_determinant_33(x)
    else if (x.numRows == 4 && x.numCols == 4) densematrix_determinant_44(x)
    else {
      
      fatal("DenseMatrix determinants for matrices > 4x4 is not implemented yet")
    }
  }

}
