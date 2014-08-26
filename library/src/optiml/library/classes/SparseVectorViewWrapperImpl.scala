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

trait SparseVectorViewWrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def sparsevectorview_calc_offsets_all_impl[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): Rep[Tup6[Int,Int,Int,Int,Int,Int]] = {
    val numCols = sparsevectorview_source(self).numCols
    val (startRow,startCol) = unpack(matrix_shapeindex(sparsevectorview_start(self), numCols))
    val (endRow,endCol) = unpack(matrix_shapeindex(sparsevectorview_start(self)+sparsevectorview_stride(self)*self.length, numCols))
    val rowPtr = sparsematrix_csr_rowptr(sparsevectorview_source(self))
    pack(startRow,endRow,startCol,endCol,rowPtr(startRow),rowPtr(endRow))
  }

  def sparsevectorview_calc_offsets_impl[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): Rep[Tup2[Int,Int]] = {
    val (startRow,endRow,startCol,endCol,startOffset,endOffset) = unpack(sparsevectorview_calc_offsets_all(self))
    pack(startOffset,endOffset)
  }

  def sparsevectorview_includeoffset_impl[T:Manifest](self: Rep[SparseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Boolean] = {
    val srcIndices = sparsematrix_csr_colindices(sparsevectorview_source(self))
    (sparsevectorview_stride(self) == 1) || ((srcIndices(__arg1) % sparsevectorview_stride(self)) == sparsevectorview_start(self))
  }

  def sparsevectorview_apply_impl1[T:Manifest](self: Rep[SparseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[T] = {
    val flatIdx = sparsevectorview_start(self) + sparsevectorview_stride(self)*__arg1
    val src = sparsevectorview_source(self)
    val (rowIdx, colIdx) = unpack(matrix_shapeindex(flatIdx, src.numCols))
    src(rowIdx, colIdx)
  }

  def sparsevectorview_nnz_impl1[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): Rep[Int] = {
    val (startOffset, endOffset) = unpack(sparsevectorview_calc_offsets(self))
    val src = sparsevectorview_source(self)
    val srcIndices = sparsematrix_csr_colindices(src)
    var nnz = 0
    for (i <- startOffset until endOffset) {
      if (sparsevectorview_includeoffset(self,i)) {
        nnz += 1
      }
    }
    nnz
  }

  def sparsevectorview_nz_impl1[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): Rep[DenseVectorView[T]] = {
    if (sparsevectorview_stride(self) == 1) {
      val src = sparsevectorview_source(self)
      val (startOffset, endOffset) = unpack(sparsevectorview_calc_offsets(self))
      DenseVectorView[T](sparsematrix_csr_data(src), startOffset, 1, endOffset - startOffset, self.isRow)
    }
    else {
      
      self.toSparse.nz
    }
  }

  def sparsevectorview_indices_impl1[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): Rep[IndexVector] = {
    if (sparsevectorview_stride(self) == 1) {
      
      val (startOffset, endOffset) = unpack(sparsevectorview_calc_offsets(self))
      val nnz = endOffset - startOffset
      val srcIndices = sparsematrix_csr_colindices(sparsevectorview_source(self))
      val outIndices = array_empty[Int](nnz)
      for (i <- 0 until nnz) {
        outIndices(i) = srcIndices(i + startOffset)
      }
      indexvector_fromarray(outIndices, self.isRow)
    }
    else {
      self.toSparse.indices
    }
  }

  def sparsevectorview_tosparse_impl[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): Rep[SparseVector[T]] = {
    val (startRow, endRow, startCol, endCol, startOffset, endOffset) = unpack(sparsevectorview_calc_offsets_all(self))
    val nnz = endOffset - startOffset 
    val src = sparsevectorview_source(self)
    val srcIndices = sparsematrix_csr_colindices(src)
    val srcData = sparsematrix_csr_data(src)
    val rowPtr = sparsematrix_csr_rowptr(src)
    var rowIndex = startRow
    val outIndices = array_empty[Int](nnz)
    val outData = array_empty[T](nnz)
    var outNnz = 0
    
    for (i <- startOffset until endOffset) {
      while (i == rowPtr(rowIndex+1) - rowPtr(startRow)) {
        rowIndex += 1
      }
      if (sparsevectorview_includeoffset(self,i)) {
        outData(outNnz) = srcData(i)
        val idx = if (self.isRow) srcIndices(i) else rowIndex
        outIndices(outNnz) = idx
        outNnz += 1
      }
    }
    
    sparsevector_alloc_raw(self.length, self.isRow, outData.unsafeImmutable, outIndices.unsafeImmutable, outNnz)
  }

  def sparsevectorview___equal_impl1[T:Manifest](self: Rep[SparseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): Rep[Boolean] = {
    self.length == __arg1.length &&
    self.isRow == __arg1.isRow &&
    sparsevectorview_start(self) == sparsevectorview_start(__arg1) &&
    sparsevectorview_stride(self) == sparsevectorview_stride(__arg1) &&
    sparsevectorview_source(self) == sparsevectorview_source(__arg1)
  }

  def sparsevectorview___equal_impl2[T:Manifest](self: Rep[SparseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Boolean] = {
    if (self.length != __arg1.length || self.nnz != __arg1.nnz || self.isRow != __arg1.isRow) false
    else {
      val (startOffset, endOffset) = unpack(sparsevectorview_calc_offsets(self))
      val nnz = endOffset - startOffset
      val src = sparsevectorview_source(self)
      val matIndices = sparsematrix_csr_colindices(src)
      val matData = sparsematrix_csr_data(src)
      val vecIndices = sparsevector_raw_indices(__arg1)
      val vecData = sparsevector_raw_data(__arg1)
      var matIdx = 0
      var vecIdx = 0
      var equal = true
    
      while (equal && matIdx < nnz) {
        if (sparsevectorview_includeoffset(self,matIndices(matIdx))) {
          if (matIndices(startOffset+matIdx) != vecIndices(vecIdx) || matData(startOffset+matIdx) != vecData(vecIdx)) {
    equal = false
          }
          vecIdx += 1
        }
        matIdx += 1
      }
      equal
    }
  }

  def sparsevectorview_tostring_impl1[T:Manifest](self: Rep[SparseVectorView[T]]): Rep[String] = {
    self.toSparse.toString
  }

  def sparsevectorview_viewtosparse_impl[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): Rep[SparseVector[T]] = {
    if (Settings.verbose > 0) println("(performance warning): automatic conversion from SparseVectorView to SparseVector")
    
    self.toSparse
  }

  def sparsevectorview_chainviewtosparseops_impl[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): SparseVectorSparseVectorOpsCls[T] = {
    repToSparseVectorSparseVectorOpsCls(viewToSparse(self))
  }

}
