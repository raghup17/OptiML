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

trait DenseMatrixOpsBase extends Base {
  this: OptiML => 

  implicit def dist(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload5): Rep[Double] = { dist(__arg0,__arg1,ABS) }

}

trait DenseMatrixOps extends DenseMatrixOpsBase {
  this: OptiML => 

  object DenseMatrix {
    def apply[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload20) = densematrix_object_apply[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos,overload20)
    def apply[T:Manifest](__arg0: Rep[DenseVector[DenseVector[T]]])(implicit __pos: SourceContext,__imp1: Overload21) = densematrix_object_apply[T](__arg0)(implicitly[Manifest[T]],__pos,overload21)
    def apply[T:Manifest](__arg0: Rep[DenseVector[DenseVectorView[T]]])(implicit __pos: SourceContext,__imp1: Overload22) = densematrix_object_apply[T](__arg0)(implicitly[Manifest[T]],__pos,overload22)
    def apply[T:Manifest](__arg0: Rep[DenseVector[T]]*)(implicit __pos: SourceContext,__imp1: Overload23) = densematrix_object_apply[T](__arg0)(implicitly[Manifest[T]],__pos,overload23)
    def block[T:Manifest](__arg0: Rep[DenseVector[DenseMatrix[T]]]*)(implicit __pos: SourceContext) = densematrix_object_block[T](__arg0)(implicitly[Manifest[T]],__pos)
    def diag[T:Arith:Manifest](__arg0: Rep[Int],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_object_diag[T](__arg0,__arg1)(implicitly[Arith[T]],implicitly[Manifest[T]],__pos)
    def identity(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_object_identity(__arg0,__arg1)(__pos,overload1)
    def identity(__arg0: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[DenseMatrix[Double]] = { DenseMatrix.identity(__arg0,__arg0) }
    def zeros(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_object_zeros(__arg0,__arg1)(__pos)
    def zerosf(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_object_zerosf(__arg0,__arg1)(__pos)
    def ones(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_object_ones(__arg0,__arg1)(__pos)
    def onesf(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_object_onesf(__arg0,__arg1)(__pos)
    def rand(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_object_rand(__arg0,__arg1)(__pos)
    def randf(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_object_randf(__arg0,__arg1)(__pos)
    def randn(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_object_randn(__arg0,__arg1)(__pos)
    def randnf(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_object_randnf(__arg0,__arg1)(__pos)
  }

  def diag[T:Manifest](__arg0: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[DenseVector[T]] = { __arg0.diag }
  def triu[T:Arith:Manifest](__arg0: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[DenseMatrix[T]] = { __arg0.triu }
  def tril[T:Arith:Manifest](__arg0: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[DenseMatrix[T]] = { __arg0.tril }
  def __equal[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload10) = densematrix___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload10)
  def __equal[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload11) = densematrix___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload11)
  def densematrix_raw_apply[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = densematrix_densematrix_raw_apply[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  def densematrix_raw_update[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext) = densematrix_densematrix_raw_update[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  def dist(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[DenseMatrix[Double]],__arg2: DistanceMetric)(implicit __pos: SourceContext,__imp1: Overload3) = densematrix_dist(__arg0,__arg1,__arg2)(__pos)

  implicit def repToDenseMatrixDenseMatrixOpsCls[T:Manifest](x: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = new DenseMatrixDenseMatrixOpsCls(x)(implicitly[Manifest[T]],__pos)
  implicit def varToDenseMatrixDenseMatrixOpsCls[T:Manifest](x: Var[DenseMatrix[T]])(implicit __pos: SourceContext) = new DenseMatrixDenseMatrixOpsCls(readVar(x))(implicitly[Manifest[T]],__pos)

  class DenseMatrixDenseMatrixOpsCls[T:Manifest](val self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) {
    def toBoolean(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Boolean],__imp2: Overload4) = densematrix_toboolean[T](self)(implicitly[Manifest[T]],__pos,conv)
    def toDouble(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double],__imp2: Overload5) = densematrix_todouble[T](self)(implicitly[Manifest[T]],__pos,conv)
    def toFloat(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Float],__imp2: Overload5) = densematrix_tofloat[T](self)(implicitly[Manifest[T]],__pos,conv)
    def toInt(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Int],__imp2: Overload5) = densematrix_toint[T](self)(implicitly[Manifest[T]],__pos,conv)
    def apply(__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload21) = densematrix_apply[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos,overload21)
    def apply(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload22) = { self.getRow(__arg1) }
    def apply(__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: ROverload23) = { self.getRows(__arg1) }
    def apply(__arg1: Rep[IndexVector],__arg2: IndexWildcard)(implicit __pos: SourceContext,__imp1: ROverload24) = { self.getRows(__arg1) }
    def apply(rows: Rep[IndexVector],cols: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload25) = densematrix_apply[T](self,rows,cols)(implicitly[Manifest[T]],__pos,overload25)
    def apply(__arg1: IndexWildcard,__arg2: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: ROverload26) = { self.getCols(__arg2) }
    def update(__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[T])(implicit __pos: SourceContext,__imp1: Overload7) = densematrix_update[T](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],__pos,overload7)
    def update(__arg1: Rep[Int],__arg2: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload8) = densematrix_update[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos,overload8)
    def update(__arg1: Rep[Int],__arg2: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload9) = densematrix_update[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos,overload9)
    def <<=(__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload4) = densematrix_ltlteq[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload4)
    def <<=(__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload5) = densematrix_ltlteq[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload5)
    def <<|=(__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_ltltoreq[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload2)
    def <<|=(__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload3) = densematrix_ltltoreq[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload3)
    def -(__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload58) = densematrix_sub[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload58)
    def -(__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload59) = densematrix_sub[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload59)
    def *(__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload61) = densematrix_mul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload61)
    def *(__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload62) = densematrix_matmult[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
    def *(__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload63) = densematrix_matvecmult[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
    def /(__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload59) = densematrix_div[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload59)
    def /(__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload60) = densematrix_div[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload60)
    def -(__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload60) = densematrix_sub[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload60)
    def /(__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload61) = densematrix_div[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload61)
    def mean(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double],__imp2: Overload4) = densematrix_mean[T](self)(implicitly[Manifest[T]],__pos,conv)
    def map[R:Manifest](__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload3) = densematrix_map[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
    def mapRowsToVector[R:Manifest](__arg1: (Rep[DenseVectorView[T]]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_maprowstovector[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
    def mapColsToVector[R:Manifest](__arg1: (Rep[DenseVectorView[T]]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_mapcolstovector[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
    def zip[B:Manifest,R:Manifest](__arg1: Rep[DenseMatrix[B]])(__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload5) = densematrix_zip[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos)
    def foreach(__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext,__imp1: Overload4) = densematrix_foreach[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def count(__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload3) = densematrix_count[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def findRows(__arg1: (Rep[DenseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_findrows[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def findCols(__arg1: (Rep[DenseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_findcols[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def filterRows(__arg1: (Rep[DenseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_filterrows[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def filterCols(__arg1: (Rep[DenseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_filtercols[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def foreachRow(__arg1: (Rep[DenseVectorView[T]]) => Rep[Unit])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_foreachrow[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def foreachCol(__arg1: (Rep[DenseVectorView[T]]) => Rep[Unit])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_foreachcol[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def mapRows[R:Manifest](__arg1: (Rep[DenseVectorView[T]]) => Rep[DenseVector[R]])(implicit __pos: SourceContext) = densematrix_maprows[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
    def mapCols[R:Manifest](__arg1: (Rep[DenseVectorView[T]]) => Rep[DenseVector[R]])(implicit __pos: SourceContext) = densematrix_mapcols[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
    def reduceRows(__arg1: (Rep[DenseVector[T]],Rep[DenseVector[T]]) => Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = densematrix_reducerows[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
    def reduceCols(__arg1: (Rep[DenseVector[T]],Rep[DenseVector[T]]) => Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = densematrix_reducecols[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
    def groupRowsBy[K:Manifest](__arg1: (Rep[DenseVectorView[T]]) => Rep[K])(implicit __pos: SourceContext) = densematrix_grouprowsby[T,K](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[K]],__pos)
    def groupColsBy[K:Manifest](__arg1: (Rep[DenseVectorView[T]]) => Rep[K])(implicit __pos: SourceContext) = densematrix_groupcolsby[T,K](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[K]],__pos)
  }

  implicit def repToDenseMatrixDenseMatrixIntOpsCls(x: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext) = new DenseMatrixDenseMatrixIntOpsCls(x)(__pos)
  implicit def varToDenseMatrixDenseMatrixIntOpsCls(x: Var[DenseMatrix[Int]])(implicit __pos: SourceContext) = new DenseMatrixDenseMatrixIntOpsCls(readVar(x))(__pos)

  class DenseMatrixDenseMatrixIntOpsCls(val self: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext) {
    def -(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload61) = { densematrix_sub[Int](self,__arg1) }
    def -(__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload62) = { densematrix_sub[Float](self.toFloat,__arg1) }
    def -(__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload63) = { densematrix_sub[Double](self.toDouble,__arg1) }
    def -(__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload70) = { densematrix_sub[Int](self,__arg1) }
    def -(__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload71) = { densematrix_sub[Float](self.toFloat,__arg1) }
    def -(__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload72) = { densematrix_sub[Double](self.toDouble,__arg1) }
    def *(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload73) = { densematrix_mul[Int](self,__arg1) }
    def *(__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload74) = { densematrix_mul[Float](self.toFloat,__arg1) }
    def *(__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload75) = { densematrix_mul[Double](self.toDouble,__arg1) }
    def *(__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload82) = { densematrix_matmult[Int](self,__arg1) }
    def *(__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload83) = { densematrix_matmult[Float](self.toFloat,__arg1) }
    def *(__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload84) = { densematrix_matmult[Double](self.toDouble,__arg1) }
    def *(__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: ROverload91) = { densematrix_matvecmult[Int](self,__arg1) }
    def *(__arg1: Rep[DenseVector[Float]])(implicit __pos: SourceContext,__imp1: ROverload92) = { densematrix_matvecmult[Float](self.toFloat,__arg1) }
    def *(__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext,__imp1: ROverload93) = { densematrix_matvecmult[Double](self.toDouble,__arg1) }
    def /(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload62) = { densematrix_div[Int](self,__arg1) }
    def /(__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload63) = { densematrix_div[Float](self.toFloat,__arg1) }
    def /(__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload64) = { densematrix_div[Double](self.toDouble,__arg1) }
    def /(__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload71) = { densematrix_div[Int](self,__arg1) }
    def /(__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload72) = { densematrix_div[Float](self.toFloat,__arg1) }
    def /(__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload73) = { densematrix_div[Double](self.toDouble,__arg1) }
  }

  implicit def repToDenseMatrixDenseMatrixFloatOpsCls(x: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext) = new DenseMatrixDenseMatrixFloatOpsCls(x)(__pos)
  implicit def varToDenseMatrixDenseMatrixFloatOpsCls(x: Var[DenseMatrix[Float]])(implicit __pos: SourceContext) = new DenseMatrixDenseMatrixFloatOpsCls(readVar(x))(__pos)

  class DenseMatrixDenseMatrixFloatOpsCls(val self: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext) {
    def -(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload64) = { densematrix_sub[Float](self,__arg1.toFloat) }
    def -(__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload65) = { densematrix_sub[Float](self,__arg1) }
    def -(__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload66) = { densematrix_sub[Double](self.toDouble,__arg1) }
    def -(__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload73) = { densematrix_sub[Float](self,__arg1.toFloat) }
    def -(__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload74) = { densematrix_sub[Float](self,__arg1) }
    def -(__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload75) = { densematrix_sub[Double](self.toDouble,__arg1) }
    def *(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload76) = { densematrix_mul[Float](self,__arg1.toFloat) }
    def *(__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload77) = { densematrix_mul[Float](self,__arg1) }
    def *(__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload78) = { densematrix_mul[Double](self.toDouble,__arg1) }
    def *(__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload85) = { densematrix_matmult[Float](self,__arg1.toFloat) }
    def *(__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload86) = { densematrix_matmult[Float](self,__arg1) }
    def *(__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload87) = { densematrix_matmult[Double](self.toDouble,__arg1) }
    def *(__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: ROverload94) = { densematrix_matvecmult[Float](self,__arg1.toFloat) }
    def *(__arg1: Rep[DenseVector[Float]])(implicit __pos: SourceContext,__imp1: ROverload95) = { densematrix_matvecmult[Float](self,__arg1) }
    def *(__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext,__imp1: ROverload96) = { densematrix_matvecmult[Double](self.toDouble,__arg1) }
    def /(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload65) = { densematrix_div[Float](self,__arg1.toFloat) }
    def /(__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload66) = { densematrix_div[Float](self,__arg1) }
    def /(__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload67) = { densematrix_div[Double](self.toDouble,__arg1) }
    def /(__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload74) = { densematrix_div[Float](self,__arg1.toFloat) }
    def /(__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload75) = { densematrix_div[Float](self,__arg1) }
    def /(__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload76) = { densematrix_div[Double](self.toDouble,__arg1) }
  }

  implicit def repToDenseMatrixDenseMatrixDoubleOpsCls(x: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext) = new DenseMatrixDenseMatrixDoubleOpsCls(x)(__pos)
  implicit def varToDenseMatrixDenseMatrixDoubleOpsCls(x: Var[DenseMatrix[Double]])(implicit __pos: SourceContext) = new DenseMatrixDenseMatrixDoubleOpsCls(readVar(x))(__pos)

  class DenseMatrixDenseMatrixDoubleOpsCls(val self: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext) {
    def -(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload67) = { densematrix_sub[Double](self,__arg1.toDouble) }
    def -(__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload68) = { densematrix_sub[Double](self.toDouble,__arg1) }
    def -(__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload69) = { densematrix_sub[Double](self,__arg1) }
    def -(__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload76) = { densematrix_sub[Double](self,__arg1.toDouble) }
    def -(__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload77) = { densematrix_sub[Double](self,__arg1.toDouble) }
    def -(__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload78) = { densematrix_sub[Double](self,__arg1) }
    def *(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload79) = { densematrix_mul[Double](self,__arg1.toDouble) }
    def *(__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload80) = { densematrix_mul[Double](self.toDouble,__arg1) }
    def *(__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload81) = { densematrix_mul[Double](self,__arg1) }
    def *(__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload88) = { densematrix_matmult[Double](self,__arg1.toDouble) }
    def *(__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload89) = { densematrix_matmult[Double](self,__arg1.toDouble) }
    def *(__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload90) = { densematrix_matmult[Double](self,__arg1) }
    def *(__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: ROverload97) = { densematrix_matvecmult[Double](self,__arg1.toDouble) }
    def *(__arg1: Rep[DenseVector[Float]])(implicit __pos: SourceContext,__imp1: ROverload98) = { densematrix_matvecmult[Double](self,__arg1.toDouble) }
    def *(__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext,__imp1: ROverload99) = { densematrix_matvecmult[Double](self,__arg1) }
    def /(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload68) = { densematrix_div[Double](self,__arg1.toDouble) }
    def /(__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload69) = { densematrix_div[Double](self.toDouble,__arg1) }
    def /(__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload70) = { densematrix_div[Double](self,__arg1) }
    def /(__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload77) = { densematrix_div[Double](self,__arg1.toDouble) }
    def /(__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload78) = { densematrix_div[Double](self,__arg1.toDouble) }
    def /(__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload79) = { densematrix_div[Double](self,__arg1) }
  }

  implicit def repToDenseMatrixIntOpsCls(x: Rep[Int])(implicit __pos: SourceContext) = new DenseMatrixIntOpsCls(x)(__pos)
  implicit def varToDenseMatrixIntOpsCls(x: Var[Int])(implicit __pos: SourceContext) = new DenseMatrixIntOpsCls(readVar(x))(__pos)

  class DenseMatrixIntOpsCls(val self: Rep[Int])(implicit __pos: SourceContext) {
    def *(__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload64) = { densematrix_mul[Int](__arg1,self) }
    def *(__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload65) = { densematrix_mul[Float](__arg1,self.toFloat) }
    def *(__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload66) = { densematrix_mul[Double](__arg1,self.toDouble) }
  }

  implicit def repToDenseMatrixFloatOpsCls(x: Rep[Float])(implicit __pos: SourceContext) = new DenseMatrixFloatOpsCls(x)(__pos)
  implicit def varToDenseMatrixFloatOpsCls(x: Var[Float])(implicit __pos: SourceContext) = new DenseMatrixFloatOpsCls(readVar(x))(__pos)

  class DenseMatrixFloatOpsCls(val self: Rep[Float])(implicit __pos: SourceContext) {
    def *(__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload67) = { densematrix_mul[Float](__arg1.toFloat,self) }
    def *(__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload68) = { densematrix_mul[Float](__arg1,self) }
    def *(__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload69) = { densematrix_mul[Double](__arg1,self.toDouble) }
  }

  implicit def repToDenseMatrixDoubleOpsCls(x: Rep[Double])(implicit __pos: SourceContext) = new DenseMatrixDoubleOpsCls(x)(__pos)
  implicit def varToDenseMatrixDoubleOpsCls(x: Var[Double])(implicit __pos: SourceContext) = new DenseMatrixDoubleOpsCls(readVar(x))(__pos)

  class DenseMatrixDoubleOpsCls(val self: Rep[Double])(implicit __pos: SourceContext) {
    def *(__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload70) = { densematrix_mul[Double](__arg1.toDouble,self) }
    def *(__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload71) = { densematrix_mul[Double](__arg1.toDouble,self) }
    def *(__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload72) = { densematrix_mul[Double](__arg1,self) }
  }


  def infix_flattenToVector[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = densematrix_flattentovector[T](self)(implicitly[Manifest[T]],__pos)
  def infix_numRows[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload3) = densematrix_numrows[T](self)(implicitly[Manifest[T]],__pos)
  def infix_numCols[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload3) = densematrix_numcols[T](self)(implicitly[Manifest[T]],__pos)
  def infix_size[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload13) = densematrix_size[T](self)(implicitly[Manifest[T]],__pos)
  def infix_indices[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload5) = densematrix_indices[T](self)(implicitly[Manifest[T]],__pos)
  def infix_rowIndices[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_rowindices[T](self)(implicitly[Manifest[T]],__pos)
  def infix_colIndices[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_colindices[T](self)(implicitly[Manifest[T]],__pos)
  def infix_vview[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[Int],__arg4: Rep[Boolean])(implicit __pos: SourceContext) = densematrix_vview[T](self,__arg1,__arg2,__arg3,__arg4)(implicitly[Manifest[T]],__pos)
  def infix_getRow[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_getrow[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  def infix_getRows[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_getrows[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  def infix_getCol[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_getcol[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  def infix_getCols[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_getcols[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  def infix_slice[T:Manifest](self: Rep[DenseMatrix[T]],startRow: Rep[Int],endRow: Rep[Int],startCol: Rep[Int],endCol: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload5): Rep[DenseMatrix[T]] = { self(startRow::endRow, startCol::endCol) }
  def infix_sliceRows[T:Manifest](self: Rep[DenseMatrix[T]],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[DenseMatrix[T]] = { self.getRows(start::end) }
  def infix_sliceCols[T:Manifest](self: Rep[DenseMatrix[T]],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[DenseMatrix[T]] = { self.getCols(start::end) }
  def infix_diag[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = densematrix_diag[T](self)(implicitly[Manifest[T]],__pos)
  def infix_triu[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = densematrix_triu[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_tril[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = densematrix_tril[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_pprint[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Stringable[T],__imp2: Overload5) = densematrix_pprint[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_makeString[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Stringable[T],__imp2: Overload5) = densematrix_makestring[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_toString[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __imp0: Overload14) = densematrix_tostring[T](self)
  def infix_t[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload3) = densematrix_t[T](self)(implicitly[Manifest[T]],__pos)
  def infix_Clone[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload5) = densematrix_clone[T](self)(implicitly[Manifest[T]],__pos)
  def infix_mutable[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload14) = densematrix_mutable[T](self)(implicitly[Manifest[T]],__pos)
  def infix_replicate[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload3) = densematrix_replicate[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  def infix_updateRow[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_updaterow[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos,overload1)
  def infix_updateCol[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_updatecol[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos,overload1)
  def infix_updateRow[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_updaterow[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos,overload2)
  def infix_updateCol[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_updatecol[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos,overload2)
  def infix_<<[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload5) = densematrix_ltlt[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload5)
  def infix_<<[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload6) = densematrix_ltlt[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload6)
  def infix_<<|[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_ltltor[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload1)
  def infix_<<|[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_ltltor[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload2)
  def infix_insertRow[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],y: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_insertrow[T](self,pos,y)(implicitly[Manifest[T]],__pos)
  def infix_insertAllRows[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],xs: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = densematrix_insertallrows[T](self,pos,xs)(implicitly[Manifest[T]],__pos)
  def infix_insertCol[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],y: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_insertcol[T](self,pos,y)(implicitly[Manifest[T]],__pos)
  def infix_insertAllCols[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],xs: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = densematrix_insertallcols[T](self,pos,xs)(implicitly[Manifest[T]],__pos)
  def infix_trim[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload3) = densematrix_trim[T](self)(implicitly[Manifest[T]],__pos)
  def infix_removeRow[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_removerow[T](self,pos)(implicitly[Manifest[T]],__pos)
  def infix_removeCol[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_removecol[T](self,pos)(implicitly[Manifest[T]],__pos)
  def infix_removeRows[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],num: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_removerows[T](self,pos,num)(implicitly[Manifest[T]],__pos)
  def infix_removeCols[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],num: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_removecols[T](self,pos,num)(implicitly[Manifest[T]],__pos)
  def infix_+[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload74) = densematrix_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload74)
  def infix_+[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload75) = densematrix_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload75)
  def infix_+=[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload1) = densematrix_pleq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload1)
  def infix_+=[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = densematrix_pleq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload2)
  def infix_-=[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload1) = densematrix_subeq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload1)
  def infix_-=[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = densematrix_subeq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload2)
  def infix_*:*[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload11) = densematrix_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload11)
  def infix_*=[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload1) = densematrix_muleq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload1)
  def infix_*=[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = densematrix_muleq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload2)
  def infix_/=[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload1) = densematrix_diveq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload1)
  def infix_/=[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = densematrix_diveq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload2)
  def infix_+[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload76) = densematrix_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload76)
  def infix_*:*[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload12) = densematrix_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload12)
  def infix_sum[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload4) = densematrix_sum[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_prod[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload3) = densematrix_prod[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_abs[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload20) = densematrix_abs[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_exp[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload19) = densematrix_exp[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_log[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload19) = densematrix_log[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_sumRows[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload1) = densematrix_sumrows[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_sumCols[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload1) = densematrix_sumcols[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_minRows[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload1) = densematrix_minrows[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_minCols[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload1) = densematrix_mincols[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_maxRows[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload1) = densematrix_maxrows[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_maxCols[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload1) = densematrix_maxcols[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_min[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload5) = densematrix_min[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_max[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload5) = densematrix_max[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_minIndex[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload3) = densematrix_minindex[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_maxIndex[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload3) = densematrix_maxindex[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_:>[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload1) = densematrix_clngt[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_:<[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload1) = densematrix_clnlt[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_+(__arg0: Rep[Int],__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload77): Rep[DenseMatrix[Int]] = { densematrix_pl[Int](__arg1,__arg0) }
  def infix_+(__arg0: Rep[Int],__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload78): Rep[DenseMatrix[Float]] = { densematrix_pl[Float](__arg1,__arg0.toFloat) }
  def infix_+(__arg0: Rep[Int],__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload79): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg1,__arg0.toDouble) }
  def infix_+(__arg0: Rep[Float],__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload80): Rep[DenseMatrix[Float]] = { densematrix_pl[Float](__arg1.toFloat,__arg0) }
  def infix_+(__arg0: Rep[Float],__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload81): Rep[DenseMatrix[Float]] = { densematrix_pl[Float](__arg1,__arg0) }
  def infix_+(__arg0: Rep[Float],__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload82): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg1,__arg0.toDouble) }
  def infix_+(__arg0: Rep[Double],__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload83): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg1.toDouble,__arg0) }
  def infix_+(__arg0: Rep[Double],__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload84): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg1.toDouble,__arg0) }
  def infix_+(__arg0: Rep[Double],__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload85): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg1,__arg0) }
  def infix_+(__arg0: Rep[DenseMatrix[Int]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload86): Rep[DenseMatrix[Int]] = { densematrix_pl[Int](__arg0,__arg1) }
  def infix_+(__arg0: Rep[DenseMatrix[Int]],__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload87): Rep[DenseMatrix[Float]] = { densematrix_pl[Float](__arg0.toFloat,__arg1) }
  def infix_+(__arg0: Rep[DenseMatrix[Int]],__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload88): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg0.toDouble,__arg1) }
  def infix_+(__arg0: Rep[DenseMatrix[Float]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload89): Rep[DenseMatrix[Float]] = { densematrix_pl[Float](__arg0,__arg1.toFloat) }
  def infix_+(__arg0: Rep[DenseMatrix[Float]],__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload90): Rep[DenseMatrix[Float]] = { densematrix_pl[Float](__arg0,__arg1) }
  def infix_+(__arg0: Rep[DenseMatrix[Float]],__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload91): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg0.toDouble,__arg1) }
  def infix_+(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload92): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg0,__arg1.toDouble) }
  def infix_+(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload93): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg0.toDouble,__arg1) }
  def infix_+(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload94): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg0,__arg1) }
  def infix_+(__arg0: Rep[DenseMatrix[Int]],__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload95): Rep[DenseMatrix[Int]] = { densematrix_pl[Int](__arg0,__arg1) }
  def infix_+(__arg0: Rep[DenseMatrix[Int]],__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload96): Rep[DenseMatrix[Float]] = { densematrix_pl[Float](__arg0.toFloat,__arg1) }
  def infix_+(__arg0: Rep[DenseMatrix[Int]],__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload97): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg0.toDouble,__arg1) }
  def infix_+(__arg0: Rep[DenseMatrix[Float]],__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload98): Rep[DenseMatrix[Float]] = { densematrix_pl[Float](__arg0,__arg1.toFloat) }
  def infix_+(__arg0: Rep[DenseMatrix[Float]],__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload99): Rep[DenseMatrix[Float]] = { densematrix_pl[Float](__arg0,__arg1) }
  def infix_+(__arg0: Rep[DenseMatrix[Float]],__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload100): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg0.toDouble,__arg1) }
  def infix_+(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload101): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg0,__arg1.toDouble) }
  def infix_+(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload102): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg0,__arg1.toDouble) }
  def infix_+(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload103): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg0,__arg1) }
  def infix_unary_-(__arg0: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload5): Rep[DenseMatrix[Int]] = { densematrix_mul[Int](__arg0,unit(-1)) }
  def infix_unary_-(__arg0: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload6): Rep[DenseMatrix[Float]] = { densematrix_mul[Float](__arg0,unit(-1f)) }
  def infix_unary_-(__arg0: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload7): Rep[DenseMatrix[Double]] = { densematrix_mul[Double](__arg0,unit(-1.0)) }
  def infix_*:*(__arg0: Rep[DenseMatrix[Int]],__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload13): Rep[DenseMatrix[Int]] = { densematrix_mulclnmul[Int](__arg0,__arg1) }
  def infix_*:*(__arg0: Rep[DenseMatrix[Int]],__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload14): Rep[DenseMatrix[Float]] = { densematrix_mulclnmul[Float](__arg0.toFloat,__arg1) }
  def infix_*:*(__arg0: Rep[DenseMatrix[Int]],__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload15): Rep[DenseMatrix[Double]] = { densematrix_mulclnmul[Double](__arg0.toDouble,__arg1) }
  def infix_*:*(__arg0: Rep[DenseMatrix[Float]],__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload16): Rep[DenseMatrix[Float]] = { densematrix_mulclnmul[Float](__arg0,__arg1.toFloat) }
  def infix_*:*(__arg0: Rep[DenseMatrix[Float]],__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload17): Rep[DenseMatrix[Float]] = { densematrix_mulclnmul[Float](__arg0,__arg1) }
  def infix_*:*(__arg0: Rep[DenseMatrix[Float]],__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload18): Rep[DenseMatrix[Double]] = { densematrix_mulclnmul[Double](__arg0.toDouble,__arg1) }
  def infix_*:*(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload19): Rep[DenseMatrix[Double]] = { densematrix_mulclnmul[Double](__arg0,__arg1.toDouble) }
  def infix_*:*(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload20): Rep[DenseMatrix[Double]] = { densematrix_mulclnmul[Double](__arg0,__arg1.toDouble) }
  def infix_*:*(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload21): Rep[DenseMatrix[Double]] = { densematrix_mulclnmul[Double](__arg0,__arg1) }

  def densematrix_object_apply[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload20): Rep[DenseMatrix[T]]
  def densematrix_object_apply[T:Manifest](__arg0: Rep[DenseVector[DenseVector[T]]])(implicit __pos: SourceContext,__imp1: Overload21): Rep[DenseMatrix[T]]
  def densematrix_object_apply[T:Manifest](__arg0: Rep[DenseVector[DenseVectorView[T]]])(implicit __pos: SourceContext,__imp1: Overload22): Rep[DenseMatrix[T]]
  def densematrix_object_apply[T:Manifest](__arg0: Seq[Rep[DenseVector[T]]])(implicit __pos: SourceContext,__imp1: Overload23): Rep[DenseMatrix[T]]
  def densematrix_object_block[T:Manifest](__arg0: Seq[Rep[DenseVector[DenseMatrix[T]]]])(implicit __pos: SourceContext): Rep[DenseMatrix[T]]
  def densematrix_object_diag[T:Arith:Manifest](__arg0: Rep[Int],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[DenseMatrix[T]]
  def densematrix_object_identity(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1): Rep[DenseMatrix[Double]]
  def densematrix_object_zeros(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseMatrix[Double]]
  def densematrix_object_zerosf(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseMatrix[Float]]
  def densematrix_object_ones(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseMatrix[Double]]
  def densematrix_object_onesf(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseMatrix[Float]]
  def densematrix_object_rand(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseMatrix[Double]]
  def densematrix_object_randf(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseMatrix[Float]]
  def densematrix_object_randn(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseMatrix[Double]]
  def densematrix_object_randnf(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseMatrix[Float]]
  def densematrix_toboolean[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Boolean]): Rep[DenseMatrix[Boolean]]
  def densematrix_todouble[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]): Rep[DenseMatrix[Double]]
  def densematrix_tofloat[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Float]): Rep[DenseMatrix[Float]]
  def densematrix_toint[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Int]): Rep[DenseMatrix[Int]]
  def densematrix_flattentovector[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[DenseVector[T]]
  def densematrix_numrows[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[Int]
  def densematrix_numcols[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[Int]
  def densematrix_size[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[Int]
  def densematrix_apply[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload21): Rep[T]
  def densematrix_apply[T:Manifest](self: Rep[DenseMatrix[T]],rows: Rep[IndexVector],cols: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload25): Rep[DenseMatrix[T]]
  def densematrix_indices[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[IndexVector]
  def densematrix_rowindices[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[IndexVector]
  def densematrix_colindices[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[IndexVector]
  def densematrix_vview[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[Int],__arg4: Rep[Boolean])(implicit __pos: SourceContext): Rep[DenseVectorView[T]]
  def densematrix_getrow[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVectorView[T]]
  def densematrix_getrows[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext): Rep[DenseMatrix[T]]
  def densematrix_getcol[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVectorView[T]]
  def densematrix_getcols[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext): Rep[DenseMatrix[T]]
  def densematrix_diag[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[DenseVector[T]]
  def densematrix_triu[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]]
  def densematrix_tril[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]]
  def densematrix_pprint[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]): Rep[Unit]
  def densematrix_makestring[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]): Rep[String]
  def densematrix_tostring[T:Manifest](self: Rep[DenseMatrix[T]]): Rep[String]
  def densematrix_t[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[DenseMatrix[T]]
  def densematrix_clone[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[DenseMatrix[T]]
  def densematrix_mutable[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[DenseMatrix[T]]
  def densematrix_replicate[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext): Rep[DenseMatrix[T]]
  def densematrix_update[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[T])(implicit __pos: SourceContext,__imp1: Overload7): Rep[Unit]
  def densematrix_update[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload8): Rep[Unit]
  def densematrix_updaterow[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1): Rep[Unit]
  def densematrix_updatecol[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1): Rep[Unit]
  def densematrix_update[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload9): Rep[Unit]
  def densematrix_updaterow[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload2): Rep[Unit]
  def densematrix_updatecol[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload2): Rep[Unit]
  def densematrix_ltlt[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload5): Rep[DenseMatrix[T]]
  def densematrix_ltlt[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload6): Rep[DenseMatrix[T]]
  def densematrix_ltltor[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1): Rep[DenseMatrix[T]]
  def densematrix_ltltor[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload2): Rep[DenseMatrix[T]]
  def densematrix_ltlteq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload4): Rep[Unit]
  def densematrix_ltlteq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload5): Rep[Unit]
  def densematrix_ltltoreq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2): Rep[Unit]
  def densematrix_ltltoreq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload3): Rep[Unit]
  def densematrix_insertrow[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],y: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[Unit]
  def densematrix_insertallrows[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],xs: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[Unit]
  def densematrix_insertcol[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],y: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[Unit]
  def densematrix_insertallcols[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],xs: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[Unit]
  def densematrix_trim[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[Unit]
  def densematrix_removerow[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def densematrix_removecol[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def densematrix_removerows[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],num: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def densematrix_removecols[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],num: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def densematrix_pl[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload74): Rep[DenseMatrix[T]]
  def densematrix_pl[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload75): Rep[DenseMatrix[T]]
  def densematrix_pleq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload1): Rep[Unit]
  def densematrix_pleq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2): Rep[Unit]
  def densematrix_sub[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload58): Rep[DenseMatrix[T]]
  def densematrix_sub[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload59): Rep[DenseMatrix[T]]
  def densematrix_subeq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload1): Rep[Unit]
  def densematrix_subeq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2): Rep[Unit]
  def densematrix_mulclnmul[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload11): Rep[DenseMatrix[T]]
  def densematrix_mul[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload61): Rep[DenseMatrix[T]]
  def densematrix_muleq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload1): Rep[Unit]
  def densematrix_muleq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2): Rep[Unit]
  def densematrix_matmult[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]]
  def densematrix_matvecmult[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]]
  def densematrix_div[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload59): Rep[DenseMatrix[T]]
  def densematrix_div[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload60): Rep[DenseMatrix[T]]
  def densematrix_diveq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload1): Rep[Unit]
  def densematrix_diveq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2): Rep[Unit]
  def densematrix_pl[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload76): Rep[DenseMatrix[T]]
  def densematrix_sub[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload60): Rep[DenseMatrix[T]]
  def densematrix_mulclnmul[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload12): Rep[DenseMatrix[T]]
  def densematrix_div[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload61): Rep[DenseMatrix[T]]
  def densematrix_sum[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T]
  def densematrix_prod[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T]
  def densematrix_mean[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]): Rep[Double]
  def densematrix_abs[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]]
  def densematrix_exp[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]]
  def densematrix_log[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]]
  def densematrix_sumrows[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]]
  def densematrix_sumcols[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]]
  def densematrix_minrows[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[DenseVector[T]]
  def densematrix_mincols[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[DenseVector[T]]
  def densematrix_maxrows[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[DenseVector[T]]
  def densematrix_maxcols[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[DenseVector[T]]
  def densematrix_min[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[T]
  def densematrix_max[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[T]
  def densematrix_minindex[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[Tup2[Int,Int]]
  def densematrix_maxindex[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[Tup2[Int,Int]]
  def densematrix_clngt[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[DenseMatrix[Boolean]]
  def densematrix_clnlt[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[DenseMatrix[Boolean]]
  def densematrix___equal[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload10): Rep[Boolean]
  def densematrix___equal[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload11): Rep[Boolean]
  def densematrix_map[T:Manifest,R:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseMatrix[R]]
  def densematrix_maprowstovector[T:Manifest,R:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]]
  def densematrix_mapcolstovector[T:Manifest,R:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]]
  def densematrix_zip[T:Manifest,B:Manifest,R:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseMatrix[R]]
  def densematrix_foreach[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit]
  def densematrix_count[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[Int]
  def densematrix_findrows[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[IndexVector]
  def densematrix_findcols[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[IndexVector]
  def densematrix_filterrows[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[DenseMatrix[T]]
  def densematrix_filtercols[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[DenseMatrix[T]]
  def densematrix_foreachrow[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit]
  def densematrix_foreachcol[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit]
  def densematrix_maprows[T:Manifest,R:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[DenseVector[R]])(implicit __pos: SourceContext): Rep[DenseMatrix[R]]
  def densematrix_mapcols[T:Manifest,R:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[DenseVector[R]])(implicit __pos: SourceContext): Rep[DenseMatrix[R]]
  def densematrix_reducerows[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVector[T]],Rep[DenseVector[T]]) => Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]]
  def densematrix_reducecols[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVector[T]],Rep[DenseVector[T]]) => Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]]
  def densematrix_grouprowsby[T:Manifest,K:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[K])(implicit __pos: SourceContext): Rep[ForgeHashMap[K,DenseMatrix[T]]]
  def densematrix_groupcolsby[T:Manifest,K:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[K])(implicit __pos: SourceContext): Rep[ForgeHashMap[K,DenseMatrix[T]]]
  def densematrix_densematrix_raw_apply[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[T]
  def densematrix_densematrix_raw_update[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext): Rep[Unit]
  def densematrix_dist(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[DenseMatrix[Double]],__arg2: DistanceMetric)(implicit __pos: SourceContext): Rep[Double]
}
trait DenseMatrixCompilerOps extends DenseMatrixOps {
  this: OptiML => 

  def densematrix_fromarray[T:Manifest](__arg0: Rep[ForgeArray[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext): Rep[DenseMatrix[T]]
  def densematrix_fromfunc[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Int],__arg2: (Rep[Int],Rep[Int]) => Rep[T])(implicit __pos: SourceContext): Rep[DenseMatrix[T]]
  def matrix_shapeindex(idx: Rep[Int],numCols: Rep[Int])(implicit __pos: SourceContext): Rep[Tup2[Int,Int]]
  def densematrix_grouprowsby_helper[T:Manifest,K:Manifest,V:Manifest](__arg0: Rep[IndexVector],__arg1: Rep[DenseMatrix[T]],__arg2: (Rep[DenseVectorView[T]]) => Rep[K],__arg3: (Rep[DenseVectorView[T]]) => Rep[V])(implicit __pos: SourceContext): Rep[ForgeHashMap[K,ForgeArrayBuffer[V]]]
  def densematrix_groupcolsby_helper[T:Manifest,K:Manifest,V:Manifest](__arg0: Rep[IndexVector],__arg1: Rep[DenseMatrix[T]],__arg2: (Rep[DenseVectorView[T]]) => Rep[K],__arg3: (Rep[DenseVectorView[T]]) => Rep[V])(implicit __pos: SourceContext): Rep[ForgeHashMap[K,ForgeArrayBuffer[V]]]
  def densematrix_index[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def densematrix_raw_data[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[ForgeArray[T]]
  def densematrix_set_raw_data[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[ForgeArray[T]])(implicit __pos: SourceContext): Rep[Unit]
  def densematrix_set_numrows[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def densematrix_set_numcols[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def densematrix_insertspace[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def densematrix_ensureextra[T:Manifest](self: Rep[DenseMatrix[T]],extra: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def densematrix_realloc[T:Manifest](self: Rep[DenseMatrix[T]],minLen: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def densematrix_raw_alloc[T:Manifest,R:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseMatrix[R]]
}

