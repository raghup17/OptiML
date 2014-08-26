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

trait SparseMatrixOps extends Base {
  this: OptiML => 

  object SparseMatrix {
    def apply[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload27) = sparsematrix_object_apply[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos)
    def diag[T:Arith:Manifest](__arg0: Rep[Int],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_object_diag[T](__arg0,__arg1)(implicitly[Arith[T]],implicitly[Manifest[T]],__pos)
    def identity(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload3) = sparsematrix_object_identity(__arg0,__arg1)(__pos,overload3)
    def identity(__arg0: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[SparseMatrix[Double]] = { SparseMatrix.identity(__arg0,__arg0) }
    def zeros(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload4) = sparsematrix_object_zeros(__arg0,__arg1)(__pos)
    def zerosf(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload4) = sparsematrix_object_zerosf(__arg0,__arg1)(__pos)
    def rand(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Double])(implicit __pos: SourceContext,__imp1: Overload4) = sparsematrix_object_rand(__arg0,__arg1,__arg2)(__pos)
    def randf(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Double])(implicit __pos: SourceContext,__imp1: Overload4) = sparsematrix_object_randf(__arg0,__arg1,__arg2)(__pos)
    def randn(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Double])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_object_randn(__arg0,__arg1,__arg2)(__pos)
    def randnf(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Double])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_object_randnf(__arg0,__arg1,__arg2)(__pos)
  }

  def __equal[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload16) = sparsematrix___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload16)
  def __equal[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload17) = sparsematrix___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload17)

  implicit def repToSparseMatrixSparseMatrixOpsCls[T:Manifest](x: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = new SparseMatrixSparseMatrixOpsCls(x)(implicitly[Manifest[T]],__pos)
  implicit def varToSparseMatrixSparseMatrixOpsCls[T:Manifest](x: Var[SparseMatrix[T]])(implicit __pos: SourceContext) = new SparseMatrixSparseMatrixOpsCls(readVar(x))(implicitly[Manifest[T]],__pos)

  class SparseMatrixSparseMatrixOpsCls[T:Manifest](val self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) {
    def apply(__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload29) = sparsematrix_apply[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos,overload29)
    def apply(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload30) = { self.getRow(__arg1) }
    def apply(__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: ROverload31) = { self.getRows(__arg1) }
    def apply(__arg1: Rep[IndexVector],__arg2: IndexWildcard)(implicit __pos: SourceContext,__imp1: ROverload32) = { self.getRows(__arg1) }
    def apply(rows: Rep[IndexVector],cols: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload33) = sparsematrix_apply[T](self,rows,cols)(implicitly[Manifest[T]],__pos,overload33)
    def apply(__arg1: IndexWildcard,__arg2: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: ROverload34) = { self.getCols(__arg2) }
    def -(__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload102) = sparsematrix_sub[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload102)
    def -(__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload103) = sparsematrix_sub[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload103)
    def -(__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload104) = sparsematrix_sub[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload104)
    def *(__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload142) = sparsematrix_mul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
    def /(__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload103) = sparsematrix_div[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload103)
    def /(__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload104) = sparsematrix_div[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload104)
    def /(__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload105) = sparsematrix_div[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload105)
    def mean(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double],__imp2: Overload6) = sparsematrix_mean[T](self)(implicitly[Manifest[T]],__pos,conv)
    def mapnz[R:Manifest](__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_mapnz[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
    def foreachnz(__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_foreachnz[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def countnz(__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_countnz[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def mapRowsToVector[R:Manifest](__arg1: (Rep[SparseVectorView[T]]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_maprowstovector[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
    def mapColsToVector[R:Manifest](__arg1: (Rep[SparseVectorView[T]]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_mapcolstovector[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
    def findRows(__arg1: (Rep[SparseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_findrows[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def findCols(__arg1: (Rep[SparseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_findcols[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def filterRows(__arg1: (Rep[SparseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_filterrows[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def filterCols(__arg1: (Rep[SparseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_filtercols[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def foreachRow(__arg1: (Rep[SparseVectorView[T]]) => Rep[Unit])(implicit __pos: SourceContext,__imp1: Overload3) = sparsematrix_foreachrow[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def foreachCol(__arg1: (Rep[SparseVectorView[T]]) => Rep[Unit])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_foreachcol[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }


  def infix_numRows[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload5) = sparsematrix_numrows[T](self)(implicitly[Manifest[T]],__pos)
  def infix_numCols[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload5) = sparsematrix_numcols[T](self)(implicitly[Manifest[T]],__pos)
  def infix_size[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload15) = sparsematrix_size[T](self)(implicitly[Manifest[T]],__pos)
  def infix_nnz[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload4) = sparsematrix_nnz[T](self)(implicitly[Manifest[T]],__pos)
  def infix_nz[T:Manifest](self: Rep[SparseMatrix[T]],asRow: Rep[Boolean] = unit(true))(implicit __pos: SourceContext,__imp1: Overload3) = sparsematrix_nz[T](self,asRow)(implicitly[Manifest[T]],__pos)
  def infix_rowIndices[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_rowindices[T](self)(implicitly[Manifest[T]],__pos)
  def infix_colIndices[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_colindices[T](self)(implicitly[Manifest[T]],__pos)
  def infix_nzRows[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[IndexVector] = { IndexVector(self.rowIndices.distinct) }
  def infix_nzCols[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[IndexVector] = { IndexVector(self.colIndices.distinct) }
  def infix_getRow[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_getrow[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  def infix_getRows[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_getrows[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  def infix_getCol[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_getcol[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  def infix_getCols[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_getcols[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  def infix_slice[T:Manifest](self: Rep[SparseMatrix[T]],startRow: Rep[Int],endRow: Rep[Int],startCol: Rep[Int],endCol: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload7): Rep[SparseMatrix[T]] = { self(startRow::endRow, startCol::endCol) }
  def infix_sliceRows[T:Manifest](self: Rep[SparseMatrix[T]],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[SparseMatrix[T]] = { self.getRows(start::end) }
  def infix_sliceCols[T:Manifest](self: Rep[SparseMatrix[T]],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[SparseMatrix[T]] = { self.getCols(start::end) }
  def infix_t[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload5) = sparsematrix_t[T](self)(implicitly[Manifest[T]],__pos)
  def infix_Clone[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload7) = sparsematrix_clone[T](self)(implicitly[Manifest[T]],__pos)
  def infix_mutable[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload17) = sparsematrix_mutable[T](self)(implicitly[Manifest[T]],__pos)
  def infix_toDense[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload5) = sparsematrix_todense[T](self)(implicitly[Manifest[T]],__pos)
  def infix_pprint[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Stringable[T],__imp2: Overload7) = sparsematrix_pprint[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_makeString[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Stringable[T],__imp2: Overload7) = sparsematrix_makestring[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_toString[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __imp0: Overload16) = sparsematrix_tostring[T](self)
  def infix_+[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload136) = sparsematrix_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload136)
  def infix_+[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload137) = sparsematrix_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload137)
  def infix_+[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload138) = sparsematrix_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload138)
  def infix_*:*[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload26) = sparsematrix_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload26)
  def infix_*:*[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload27) = sparsematrix_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload27)
  def infix_sum[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload6) = sparsematrix_sum[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_abs[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload22) = sparsematrix_abs[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_sumRows[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = sparsematrix_sumrows[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_sumCols[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = sparsematrix_sumcols[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_min[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload7) = sparsematrix_min[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_max[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload7) = sparsematrix_max[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_minRows[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload2) = sparsematrix_minrows[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_minCols[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload2) = sparsematrix_mincols[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_maxRows[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload2) = sparsematrix_maxrows[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_maxCols[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload2) = sparsematrix_maxcols[T](self)(implicitly[Manifest[T]],__pos,__imp0)

  def sparsematrix_object_apply[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[SparseMatrixBuildable[T]]
  def sparsematrix_object_diag[T:Arith:Manifest](__arg0: Rep[Int],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[SparseMatrix[T]]
  def sparsematrix_object_identity(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload3): Rep[SparseMatrix[Double]]
  def sparsematrix_object_zeros(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[SparseMatrix[Double]]
  def sparsematrix_object_zerosf(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[SparseMatrix[Float]]
  def sparsematrix_object_rand(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Double])(implicit __pos: SourceContext): Rep[SparseMatrix[Double]]
  def sparsematrix_object_randf(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Double])(implicit __pos: SourceContext): Rep[SparseMatrix[Float]]
  def sparsematrix_object_randn(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Double])(implicit __pos: SourceContext): Rep[SparseMatrix[Double]]
  def sparsematrix_object_randnf(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Double])(implicit __pos: SourceContext): Rep[SparseMatrix[Float]]
  def sparsematrix_numrows[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[Int]
  def sparsematrix_numcols[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[Int]
  def sparsematrix_size[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[Int]
  def sparsematrix_nnz[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[Int]
  def sparsematrix_nz[T:Manifest](self: Rep[SparseMatrix[T]],asRow: Rep[Boolean] = unit(true))(implicit __pos: SourceContext): Rep[DenseVector[T]]
  def sparsematrix_apply[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload29): Rep[T]
  def sparsematrix_apply[T:Manifest](self: Rep[SparseMatrix[T]],rows: Rep[IndexVector],cols: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload33): Rep[SparseMatrix[T]]
  def sparsematrix_rowindices[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[IndexVector]
  def sparsematrix_colindices[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[IndexVector]
  def sparsematrix_getrow[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[SparseVectorView[T]]
  def sparsematrix_getrows[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext): Rep[SparseMatrix[T]]
  def sparsematrix_getcol[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[SparseVectorView[T]]
  def sparsematrix_getcols[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext): Rep[SparseMatrix[T]]
  def sparsematrix_t[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[SparseMatrix[T]]
  def sparsematrix_clone[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[SparseMatrix[T]]
  def sparsematrix_mutable[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[SparseMatrixBuildable[T]]
  def sparsematrix_todense[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[DenseMatrix[T]]
  def sparsematrix_pprint[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]): Rep[Unit]
  def sparsematrix_makestring[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]): Rep[String]
  def sparsematrix_tostring[T:Manifest](self: Rep[SparseMatrix[T]]): Rep[String]
  def sparsematrix_pl[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload136): Rep[SparseMatrix[T]]
  def sparsematrix_pl[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload137): Rep[DenseMatrix[T]]
  def sparsematrix_pl[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload138): Rep[DenseMatrix[T]]
  def sparsematrix_sub[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload102): Rep[SparseMatrix[T]]
  def sparsematrix_sub[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload103): Rep[DenseMatrix[T]]
  def sparsematrix_sub[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload104): Rep[DenseMatrix[T]]
  def sparsematrix_mulclnmul[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload26): Rep[SparseMatrix[T]]
  def sparsematrix_mulclnmul[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload27): Rep[DenseMatrix[T]]
  def sparsematrix_mul[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseMatrix[T]]
  def sparsematrix_div[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload103): Rep[SparseMatrix[T]]
  def sparsematrix_div[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload104): Rep[DenseMatrix[T]]
  def sparsematrix_div[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload105): Rep[SparseMatrix[T]]
  def sparsematrix_sum[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T]
  def sparsematrix_mean[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]): Rep[Double]
  def sparsematrix_abs[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseMatrix[T]]
  def sparsematrix_sumrows[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseVector[T]]
  def sparsematrix_sumcols[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseVector[T]]
  def sparsematrix_min[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[T]
  def sparsematrix_max[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[T]
  def sparsematrix_minrows[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[SparseVector[T]]
  def sparsematrix_mincols[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[SparseVector[T]]
  def sparsematrix_maxrows[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[SparseVector[T]]
  def sparsematrix_maxcols[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[SparseVector[T]]
  def sparsematrix___equal[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload16): Rep[Boolean]
  def sparsematrix___equal[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload17): Rep[Boolean]
  def sparsematrix_mapnz[T:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext): Rep[SparseMatrix[R]]
  def sparsematrix_foreachnz[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrix_countnz[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[Int]
  def sparsematrix_maprowstovector[T:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[R])(implicit __pos: SourceContext): Rep[SparseVector[R]]
  def sparsematrix_mapcolstovector[T:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[R])(implicit __pos: SourceContext): Rep[SparseVector[R]]
  def sparsematrix_findrows[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[IndexVector]
  def sparsematrix_findcols[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[IndexVector]
  def sparsematrix_filterrows[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[SparseMatrix[T]]
  def sparsematrix_filtercols[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[SparseMatrix[T]]
  def sparsematrix_foreachrow[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrix_foreachcol[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit]
}
trait SparseMatrixCompilerOps extends SparseMatrixOps {
  this: OptiML => 

  def sparsematrix_csr_alloc_raw[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[ForgeArray[T]],__arg3: Rep[ForgeArray[Int]],__arg4: Rep[ForgeArray[Int]],__arg5: Rep[Int])(implicit __pos: SourceContext): Rep[SparseMatrix[T]]
  def sparsematrix_rand[T:Manifest](numRows: Rep[Int],numCols: Rep[Int],sparsity: Rep[Double],gen: (Rep[Int]) => Rep[T])(implicit __pos: SourceContext): Rep[SparseMatrix[T]]
  def sparsematrix_csr_find_offset[T:Manifest](self: Rep[SparseMatrix[T]],row: Rep[Int],col: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def sparsematrix_vview[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[Int],__arg4: Rep[Boolean])(implicit __pos: SourceContext): Rep[SparseVectorView[T]]
  def sparsematrix_csr_data[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[ForgeArray[T]]
  def sparsematrix_csr_rowptr[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[ForgeArray[Int]]
  def sparsematrix_csr_colindices[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[ForgeArray[Int]]
  def sparsematrix_csr_set_numrows[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrix_csr_set_numcols[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrix_csr_set_data[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[ForgeArray[T]])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrix_csr_set_rowptr[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[ForgeArray[Int]])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrix_csr_set_colindices[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[ForgeArray[Int]])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrix_csr_set_nnz[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def sparematrix_csr_update[T:Manifest](self: Rep[SparseMatrix[T]],i: Rep[Int],j: Rep[Int],y: Rep[T])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrix_csr_ensureextra[T:Manifest](self: Rep[SparseMatrix[T]],extra: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrix_csr_realloc[T:Manifest](self: Rep[SparseMatrix[T]],minLen: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrix_csr_insertspace[T:Manifest](self: Rep[SparseMatrix[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def zipMatrixUnion[T:Manifest,B:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext): Rep[SparseMatrix[R]]
  def zipMatrixIntersect[T:Manifest,B:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext): Rep[SparseMatrix[R]]
}

