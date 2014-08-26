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

trait SparseMatrixBuildableWrapper {
  this: OptiMLBase with OptiMLClasses => 

class SparseMatrixBuildable[T:Manifest](___numRows: Int, ___numCols: Int, ___data: ForgeArray[T], ___colIndices: ForgeArray[Int], ___rowIndices: ForgeArray[Int], ___nnz: Int) {
  var _numRows = ___numRows
  var _numCols = ___numCols
  var _data = ___data
  var _colIndices = ___colIndices
  var _rowIndices = ___rowIndices
  var _nnz = ___nnz

  override def toString() = {
    val self = this
    sparsematrixbuildable_tostring_impl9[T](self)
  }
}

  def sparsematrixbuildable_numrows[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._numRows
  }
  def sparsematrixbuildable_numcols[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._numCols
  }
  def sparsematrixbuildable_nnz[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._nnz
  }
  def sparsematrixbuildable_size[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    sparsematrixbuildable_size_impl7[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_coo_find_offset[T:Manifest](self: Rep[SparseMatrixBuildable[T]],row: Rep[Int],col: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrix_coo_find_offset_impl[T](self,row,col)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrixbuildable_apply[T:Manifest](self: Rep[SparseMatrixBuildable[T]],i: Rep[Int],j: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrixbuildable_apply_impl18[T](self,i,j)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrixbuildable_pprint[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]) = {
    sparsematrixbuildable_pprint_impl3[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrixbuildable_makestring[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]) = {
    sparsematrixbuildable_makestring_impl3[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrixbuildable_tostring[T:Manifest](self: Rep[SparseMatrixBuildable[T]]) = {
    sparsematrixbuildable_tostring_impl9[T](self)
  }
  def sparsematrixbuildable_mutable[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    new SparseMatrixBuildable[T](sparsematrixbuildable_numrows(self),sparsematrixbuildable_numcols(self),array_clone(sparsematrix_coo_data(self)),array_clone(sparsematrix_coo_colindices(self)),array_clone(sparsematrix_coo_rowindices(self)),sparsematrixbuildable_nnz(self))
  }
  def sparsematrix_coo_data[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    self._data
  }
  def sparsematrix_coo_rowindices[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    self._rowIndices
  }
  def sparsematrix_coo_colindices[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    self._colIndices
  }
  def sparsematrix_coo_set_numrows[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    self._numRows = __arg1
  }
  def sparsematrix_coo_set_numcols[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    self._numCols = __arg1
  }
  def sparsematrix_coo_set_data[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[ForgeArray[T]])(implicit __pos: SourceContext) = {
    self._data = __arg1
  }
  def sparsematrix_coo_set_rowindices[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[ForgeArray[Int]])(implicit __pos: SourceContext) = {
    self._rowIndices = __arg1
  }
  def sparsematrix_coo_set_colindices[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[ForgeArray[Int]])(implicit __pos: SourceContext) = {
    self._colIndices = __arg1
  }
  def sparsematrix_coo_set_nnz[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    self._nnz = __arg1
  }
  def sparsematrixbuildable_update[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[T])(implicit __pos: SourceContext) = {
    sparsematrixbuildable_update_impl6[T](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrixbuildable_append[T:Manifest](self: Rep[SparseMatrixBuildable[T]],i: Rep[Int],j: Rep[Int],y: Rep[T],alwaysWrite: Rep[Boolean] = unit(true))(implicit __pos: SourceContext) = {
    sparsematrixbuildable_append_impl[T](self,i,j,y,alwaysWrite)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrixbuildable_ltlteq[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsematrixbuildable_ltlteq_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrixbuildable_ltltoreq[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsematrixbuildable_ltltoreq_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrixbuildable_insertrow[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],y: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsematrixbuildable_insertrow_impl1[T](self,pos,y)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrixbuildable_insertcol[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],y: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsematrixbuildable_insertcol_impl1[T](self,pos,y)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrixbuildable_removerow[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrixbuildable_removerow_impl1[T](self,pos)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrixbuildable_removecol[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrixbuildable_removecol_impl1[T](self,pos)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrixbuildable_removerows[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],num: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrixbuildable_removerows_impl1[T](self,pos,num)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrixbuildable_removecols[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],num: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrixbuildable_removecols_impl1[T](self,pos,num)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_coo_ensureextra[T:Manifest](self: Rep[SparseMatrixBuildable[T]],extra: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrix_coo_ensureextra_impl[T](self,extra)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_coo_realloc[T:Manifest](self: Rep[SparseMatrixBuildable[T]],minLen: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrix_coo_realloc_impl[T](self,minLen)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrixbuildable_finish[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    sparsematrixbuildable_finish_impl[T](self)(implicitly[Manifest[T]],__pos)
  }
  def coo_to_csr[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    coo_to_csr_impl[T](self)(implicitly[Manifest[T]],__pos)
  }
  def coo_ordered[T:Manifest](self: Rep[SparseMatrixBuildable[T]],nnz: Rep[Int],rowIndices: Rep[ForgeArray[Int]],colIndices: Rep[ForgeArray[Int]])(implicit __pos: SourceContext) = {
    coo_ordered_impl[T](self,nnz,rowIndices,colIndices)(implicitly[Manifest[T]],__pos)
  }
  def coo_to_csr_ordered[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    coo_to_csr_ordered_impl[T](self)(implicitly[Manifest[T]],__pos)
  }
  def coo_to_csr_unordered[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    coo_to_csr_unordered_impl[T](self)(implicitly[Manifest[T]],__pos)
  }
  def coo_to_csr_finalize[T:Manifest](self: Rep[SparseMatrixBuildable[T]],outData: Rep[ForgeArray[T]],outColIndices: Rep[ForgeArray[Int]],outRowPtr: Rep[ForgeArray[Int]])(implicit __pos: SourceContext) = {
    coo_to_csr_finalize_impl[T](self,outData,outColIndices,outRowPtr)(implicitly[Manifest[T]],__pos)
  }

}

