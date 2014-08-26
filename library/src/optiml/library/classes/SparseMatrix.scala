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

trait SparseMatrixWrapper {
  this: OptiMLBase with OptiMLClasses => 

class SparseMatrix[T:Manifest](___numRows: Int, ___numCols: Int, ___data: ForgeArray[T], ___colIndices: ForgeArray[Int], ___rowPtr: ForgeArray[Int], ___nnz: Int) {
  var _numRows = ___numRows
  var _numCols = ___numCols
  var _data = ___data
  var _colIndices = ___colIndices
  var _rowPtr = ___rowPtr
  var _nnz = ___nnz

  override def toString() = {
    val self = this
    sparsematrix_tostring_impl16[T](self)
  }
}

  def sparsematrix_object_apply[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    new SparseMatrixBuildable[T](__arg0,__arg1,array_empty[T](unit(32)),array_empty[Int](unit(32)),array_empty[Int](unit(32)),unit(0))
  }
  def sparsematrix_object_diag[T:Arith:Manifest](__arg0: Rep[Int],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsematrix_object_diag_impl2[T](__arg0,__arg1)(implicitly[Arith[T]],implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_object_identity(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload3) = {
    sparsematrix_object_identity_impl3(__arg0,__arg1)(__pos)
  }
  def sparsematrix_csr_alloc_raw[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[ForgeArray[T]],__arg3: Rep[ForgeArray[Int]],__arg4: Rep[ForgeArray[Int]],__arg5: Rep[Int])(implicit __pos: SourceContext) = {
    new SparseMatrix[T](__arg0,__arg1,__arg2,__arg3,__arg4,__arg5)
  }
  def sparsematrix_object_zeros(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrix_object_zeros_impl4(__arg0,__arg1)(__pos)
  }
  def sparsematrix_object_zerosf(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrix_object_zerosf_impl4(__arg0,__arg1)(__pos)
  }
  def sparsematrix_rand[T:Manifest](numRows: Rep[Int],numCols: Rep[Int],sparsity: Rep[Double],gen: (Rep[Int]) => Rep[T])(implicit __pos: SourceContext) = {
    sparsematrix_rand_impl[T](numRows,numCols,sparsity,gen)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_object_rand(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Double])(implicit __pos: SourceContext) = {
    sparsematrix_object_rand_impl4(__arg0,__arg1,__arg2)(__pos)
  }
  def sparsematrix_object_randf(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Double])(implicit __pos: SourceContext) = {
    sparsematrix_object_randf_impl4(__arg0,__arg1,__arg2)(__pos)
  }
  def sparsematrix_object_randn(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Double])(implicit __pos: SourceContext) = {
    sparsematrix_object_randn_impl2(__arg0,__arg1,__arg2)(__pos)
  }
  def sparsematrix_object_randnf(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Double])(implicit __pos: SourceContext) = {
    sparsematrix_object_randnf_impl2(__arg0,__arg1,__arg2)(__pos)
  }
  def sparsematrix_numrows[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._numRows
  }
  def sparsematrix_numcols[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._numCols
  }
  def sparsematrix_size[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    sparsematrix_size_impl15[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_nnz[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._nnz
  }
  def sparsematrix_nz[T:Manifest](self: Rep[SparseMatrix[T]],asRow: Rep[Boolean] = unit(true))(implicit __pos: SourceContext) = {
    sparsematrix_nz_impl3[T](self,asRow)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_csr_find_offset[T:Manifest](self: Rep[SparseMatrix[T]],row: Rep[Int],col: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrix_csr_find_offset_impl[T](self,row,col)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_apply[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload29) = {
    sparsematrix_apply_impl29[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_apply[T:Manifest](self: Rep[SparseMatrix[T]],rows: Rep[IndexVector],cols: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload33) = {
    sparsematrix_apply_impl33[T](self,rows,cols)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_rowindices[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    sparsematrix_rowindices_impl2[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_colindices[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    sparsematrix_colindices_impl2[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_vview[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[Int],__arg4: Rep[Boolean])(implicit __pos: SourceContext) = {
    sparsematrix_vview_impl[T](self,__arg1,__arg2,__arg3,__arg4)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_getrow[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrix_getrow_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_getrows[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext) = {
    sparsematrix_getrows_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_getcol[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrix_getcol_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_getcols[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext) = {
    sparsematrix_getcols_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_t[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    sparsematrix_t_impl5[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_clone[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    sparsematrix_clone_impl7[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_mutable[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    sparsematrix_mutable_impl17[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_todense[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    sparsematrix_todense_impl5[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_pprint[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]) = {
    sparsematrix_pprint_impl7[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_makestring[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]) = {
    sparsematrix_makestring_impl7[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_tostring[T:Manifest](self: Rep[SparseMatrix[T]]) = {
    sparsematrix_tostring_impl16[T](self)
  }
  def sparsematrix_csr_data[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    self._data
  }
  def sparsematrix_csr_rowptr[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    self._rowPtr
  }
  def sparsematrix_csr_colindices[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    self._colIndices
  }
  def sparsematrix_csr_set_numrows[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    self._numRows = __arg1
  }
  def sparsematrix_csr_set_numcols[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    self._numCols = __arg1
  }
  def sparsematrix_csr_set_data[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[ForgeArray[T]])(implicit __pos: SourceContext) = {
    self._data = __arg1
  }
  def sparsematrix_csr_set_rowptr[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[ForgeArray[Int]])(implicit __pos: SourceContext) = {
    self._rowPtr = __arg1
  }
  def sparsematrix_csr_set_colindices[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[ForgeArray[Int]])(implicit __pos: SourceContext) = {
    self._colIndices = __arg1
  }
  def sparsematrix_csr_set_nnz[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    self._nnz = __arg1
  }
  def sparematrix_csr_update[T:Manifest](self: Rep[SparseMatrix[T]],i: Rep[Int],j: Rep[Int],y: Rep[T])(implicit __pos: SourceContext) = {
    sparematrix_csr_update_impl[T](self,i,j,y)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_csr_ensureextra[T:Manifest](self: Rep[SparseMatrix[T]],extra: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrix_csr_ensureextra_impl[T](self,extra)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_csr_realloc[T:Manifest](self: Rep[SparseMatrix[T]],minLen: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrix_csr_realloc_impl[T](self,minLen)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_csr_insertspace[T:Manifest](self: Rep[SparseMatrix[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrix_csr_insertspace_impl[T](self,pos,len)(implicitly[Manifest[T]],__pos)
  }
  def zipMatrixUnion[T:Manifest,B:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext) = {
    zipMatrixUnion_impl[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos)
  }
  def zipMatrixIntersect[T:Manifest,B:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext) = {
    zipMatrixIntersect_impl[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos)
  }
  def sparsematrix_pl[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload136) = {
    sparsematrix_pl_impl136[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_pl[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload137) = {
    sparsematrix_pl_impl137[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_pl[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload138) = {
    sparsematrix_pl_impl138[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_sub[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload102) = {
    sparsematrix_sub_impl102[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_sub[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload103) = {
    sparsematrix_sub_impl103[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_sub[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload104) = {
    sparsematrix_sub_impl104[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_mulclnmul[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload26) = {
    sparsematrix_mulclnmul_impl26[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_mulclnmul[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload27) = {
    sparsematrix_mulclnmul_impl27[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_mul[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    sparsematrix_mul_impl142[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_div[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload103) = {
    sparsematrix_div_impl103[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_div[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload104) = {
    sparsematrix_div_impl104[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_div[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload105) = {
    sparsematrix_div_impl105[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_sum[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    sparsematrix_sum_impl6[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_mean[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]) = {
    sparsematrix_mean_impl6[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def sparsematrix_abs[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    sparsematrix_abs_impl22[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_sumrows[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    sparsematrix_sumrows_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_sumcols[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    sparsematrix_sumcols_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_min[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    sparsematrix_min_impl7[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_max[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    sparsematrix_max_impl7[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_minrows[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    sparsematrix_minrows_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_mincols[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    sparsematrix_mincols_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_maxrows[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    sparsematrix_maxrows_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_maxcols[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    sparsematrix_maxcols_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix___equal[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload16) = {
    sparsematrix___equal_impl16[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix___equal[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload17) = {
    sparsematrix___equal_impl17[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_mapnz[T:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext) = {
    sparsematrix_mapnz_impl2[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def sparsematrix_foreachnz[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext) = {
    sparsematrix_foreachnz_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_countnz[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    sparsematrix_countnz_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_maprowstovector[T:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[R])(implicit __pos: SourceContext) = {
    sparsematrix_maprowstovector_impl2[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def sparsematrix_mapcolstovector[T:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[R])(implicit __pos: SourceContext) = {
    sparsematrix_mapcolstovector_impl2[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def sparsematrix_findrows[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    sparsematrix_findrows_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_findcols[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    sparsematrix_findcols_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_filterrows[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    sparsematrix_filterrows_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_filtercols[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    sparsematrix_filtercols_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_foreachrow[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Unit])(implicit __pos: SourceContext) = {
    sparsematrix_foreachrow_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_foreachcol[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Unit])(implicit __pos: SourceContext) = {
    sparsematrix_foreachcol_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }

}

