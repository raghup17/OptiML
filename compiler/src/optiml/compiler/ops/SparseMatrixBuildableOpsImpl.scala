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

trait SparseMatrixBuildableOpsImpl {
  this: OptiMLCompiler with OptiMLLift => 

  def sparsematrixbuildable_size_impl7[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext): Rep[Int] = {
    self.numRows*self.numCols
  }

  def sparsematrix_coo_find_offset_impl[T:Manifest](self: Rep[SparseMatrixBuildable[T]],row: Rep[Int],col: Rep[Int])(implicit __pos: SourceContext): Rep[Int] = {
    val rowIndices = sparsematrix_coo_rowindices(self)
    val colIndices = sparsematrix_coo_colindices(self)
    
    
    var i = 0
    var foundAtIndex = -1
    while (i < self.nnz) {
      if (rowIndices(i) == row && colIndices(i) == col)
        foundAtIndex = i
      i += 1
    }
    
    foundAtIndex
  }

  def sparsematrixbuildable_apply_impl18[T:Manifest](self: Rep[SparseMatrixBuildable[T]],i: Rep[Int],j: Rep[Int])(implicit __pos: SourceContext): Rep[T] = {
    println("[optila warning]: possible performance problem - reading from a sparse matrix COO representation")
    
    val data = sparsematrix_coo_data(self)
    val offRaw = sparsematrix_coo_find_offset(self,i,j)
    if (offRaw > -1) data(offRaw)
    else defaultValue[T]
  }

  def sparsematrixbuildable_pprint_impl3[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]): Rep[Unit] = {
    println(self.makeStr + "\n")
  }

  def sparsematrixbuildable_makestring_impl3[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]): Rep[String] = {
    val rowIndices = sparsematrix_coo_rowindices(self)
    val colIndices = sparsematrix_coo_colindices(self)
    val data = sparsematrix_coo_data(self)
    var s = ""
    
    if (self == null) {
      s = "null"
    }
    else if (self.nnz == 0) {
      s = "[ ]"
    }
    else {
      
      for (i <- 0 until self.nnz-1) {
        if (rowIndices(i) > -1)
          s = s + "((" + rowIndices(i) + ", " + colIndices(i) + "), " + data(i).makeStr + ")\n"
      }
      s = s + "((" + rowIndices(self.nnz-1) + ", " + colIndices(self.nnz-1) + "), " + data(self.nnz-1).makeStr + ")\n"
    }
    s
  }

  def sparsematrixbuildable_tostring_impl9[T:Manifest](self: Rep[SparseMatrixBuildable[T]]): Rep[String] = {
    val rowIndices = sparsematrix_coo_rowindices(self)
    val colIndices = sparsematrix_coo_colindices(self)
    val data = sparsematrix_coo_data(self)
    var s = ""
    
    if (self == null) {
      s = "null"
    }
    else if (self.nnz == 0) {
      s = "[ ]"
    }
    else {
      
      for (i <- 0 until self.nnz-1) {
        if (rowIndices(i) > -1)
          s = s + "((" + rowIndices(i) + ", " + colIndices(i) + "), " + optila_fmt_str(data(i)) + ")\n"
      }
      s = s + "((" + rowIndices(self.nnz-1) + ", " + colIndices(self.nnz-1) + "), " + optila_fmt_str(data(self.nnz-1)) + ")\n"
    }
    s
  }

  def sparsematrixbuildable_update_impl6[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[T])(implicit __pos: SourceContext): Rep[Unit] = {
    self.append(__arg1,__arg2,__arg3,true)
  }

  def sparsematrixbuildable_append_impl[T:Manifest](self: Rep[SparseMatrixBuildable[T]],i: Rep[Int],j: Rep[Int],y: Rep[T],alwaysWrite: Rep[Boolean] = unit(true))(implicit __pos: SourceContext): Rep[Unit] = {
    val shouldAppend = alwaysWrite || (y != defaultValue[T])  
    if (shouldAppend) {
      sparsematrix_coo_ensureextra(self, 1)
      array_update(sparsematrix_coo_data(self), self.nnz, y)
      array_update(sparsematrix_coo_rowindices(self), self.nnz, i)
      array_update(sparsematrix_coo_colindices(self), self.nnz, j)
      sparsematrix_coo_set_nnz(self, self.nnz+1)
    }
  }

  def sparsematrixbuildable_ltlteq_impl3[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Unit] = {
    self.insertRow(self.numRows, __arg1)
  }

  def sparsematrixbuildable_ltltoreq_impl1[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Unit] = {
    self.insertCol(self.numCols, __arg1)
  }

  def sparsematrixbuildable_insertrow_impl1[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],y: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Unit] = {
    if (self.size == 0) sparsematrix_coo_set_numcols(self, y.length)
    val rowIndices = sparsematrix_coo_rowindices(self)
    for (i <- 0 until self.nnz) {
      if (rowIndices(i) >= pos)
        array_update(rowIndices, i, rowIndices(i)+1)
    }
    for (j <- 0 until y.nnz) {
      self.append(pos, sparsevector_raw_indices(y).apply(j), sparsevector_raw_data(y).apply(j))
    }
    sparsematrix_coo_set_numrows(self, self.numRows+1)
  }

  def sparsematrixbuildable_insertcol_impl1[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],y: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Unit] = {
    if (self.size == 0) sparsematrix_coo_set_numrows(self, y.length)
    val colIndices = sparsematrix_coo_colindices(self)
    for (i <- 0 until self.nnz) {
      if (colIndices(i) >= pos)
        array_update(colIndices, i, colIndices(i)+1)
    }
    for (i <- 0 until y.nnz) {
      self.append(sparsevector_raw_indices(y).apply(i), pos, sparsevector_raw_data(y).apply(i))
    }
    sparsematrix_coo_set_numcols(self, self.numCols+1)
  }

  def sparsematrixbuildable_removerow_impl1[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    self.removeRows(pos, 1)
  }

  def sparsematrixbuildable_removecol_impl1[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    self.removeCols(pos, 1)
  }

  def sparsematrixbuildable_removerows_impl1[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],num: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    val rowIndices = sparsematrix_coo_rowindices(self)
    for (i <- 0 until self.nnz) {
      if (rowIndices(i) >= pos && rowIndices(i) < pos+num) {
        
        array_update(rowIndices, i, -1)
        array_update(sparsematrix_coo_colindices(self), i, -1)
        
      }
      else if (rowIndices(i) >= pos+num)
        array_update(rowIndices, i, rowIndices(i)-num)
    }
    sparsematrix_coo_set_numrows(self, self.numRows-num)
  }

  def sparsematrixbuildable_removecols_impl1[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],num: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    val colIndices = sparsematrix_coo_colindices(self)
    for (i <- 0 until self.nnz) {
      if (colIndices(i) >= pos && colIndices(i) < pos+num) {
        
        array_update(colIndices, i, -1)
        array_update(sparsematrix_coo_rowindices(self), i, -1)
        
      }
      else if (colIndices(i) >= pos+num)
        array_update(colIndices, i, colIndices(i)-num)
    }
    sparsematrix_coo_set_numcols(self, self.numCols-num)
  }

  def sparsematrix_coo_ensureextra_impl[T:Manifest](self: Rep[SparseMatrixBuildable[T]],extra: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    if (array_length(sparsematrix_coo_data(self)) - self.nnz < extra) {
      sparsematrix_coo_realloc(self, self.nnz + extra)
    }
  }

  def sparsematrix_coo_realloc_impl[T:Manifest](self: Rep[SparseMatrixBuildable[T]],minLen: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    val data = sparsematrix_coo_data(self)
    val rowIndices = sparsematrix_coo_rowindices(self)
    val colIndices = sparsematrix_coo_colindices(self)
    var n = max(4, array_length(data) * 2)
    while (n < minLen) n = n*2
    val outData = array_empty[T](n)
    val outRowIndices = array_empty[Int](n)
    val outColIndices = array_empty[Int](n)
    array_copy(data, 0, outData, 0, self.nnz)
    array_copy(rowIndices, 0, outRowIndices, 0, self.nnz)
    array_copy(colIndices, 0, outColIndices, 0, self.nnz)
    sparsematrix_coo_set_data(self, outData.unsafeImmutable)
    sparsematrix_coo_set_rowindices(self, outRowIndices.unsafeImmutable)
    sparsematrix_coo_set_colindices(self, outColIndices.unsafeImmutable)
  }

  def sparsematrixbuildable_finish_impl[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext): Rep[SparseMatrix[T]] = {
    coo_to_csr(self)
  }

  def coo_to_csr_impl[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext): Rep[SparseMatrix[T]] = {
    if (coo_ordered(self, self.nnz, sparsematrix_coo_rowindices(self),sparsematrix_coo_colindices(self)))
      coo_to_csr_ordered(self)
    else
      coo_to_csr_unordered(self)
  }

  def coo_ordered_impl[T:Manifest](self: Rep[SparseMatrixBuildable[T]],nnz: Rep[Int],rowIndices: Rep[ForgeArray[Int]],colIndices: Rep[ForgeArray[Int]])(implicit __pos: SourceContext): Rep[Boolean] = {
    var i = 0
    var lastRow = 0
    var lastCol = 0
    var outOfOrder = false
    while (i < nnz && !outOfOrder) {
      if (rowIndices(i) < lastRow)
        outOfOrder = true
      if (rowIndices(i) == lastRow && colIndices(i) < lastCol)
        outOfOrder = true
      lastRow = rowIndices(i)
      lastCol = colIndices(i)
      i += 1
    }
    !outOfOrder
  }

  def coo_to_csr_ordered_impl[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext): Rep[SparseMatrix[T]] = {
    val data = sparsematrix_coo_data(self)
    val rowIndices = sparsematrix_coo_rowindices(self)
    val colIndices = sparsematrix_coo_colindices(self)
    
    val outData = array_empty[T](self.nnz)
    val outColIndices = array_empty[Int](self.nnz)
    val outRowPtr = array_empty[Int](self.numRows+1)
    
    var i = 0
    while (i < self.nnz) {
      array_update(outColIndices, i, colIndices(i))
      array_update(outData, i, data(i))
      array_update(outRowPtr, rowIndices(i)+1, outRowPtr(rowIndices(i)+1)+1)
      i += 1
    }
    
    coo_to_csr_finalize(self,outData,outColIndices,outRowPtr)
  }

  def coo_to_csr_unordered_impl[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext): Rep[SparseMatrix[T]] = {
    val data = sparsematrix_coo_data(self)
    val rowIndices = sparsematrix_coo_rowindices(self)
    val colIndices = sparsematrix_coo_colindices(self)
    
    
    
    
    val elems = SHashMap[Long,T]()
    
    
    var i = 0
    while (i < self.nnz) {
      if (rowIndices(i) >= 0) {  
        val key = (rowIndices(i).toLong << 32) + colIndices(i).toLong
        elems(key) = data(i)
      }
      i += 1
    }
    val indices = array_sort(elems.keys)
    val outData = array_empty[T](array_length(indices))
    val outColIndices = array_empty[Int](array_length(indices))
    val outRowPtr = array_empty[Int](self.numRows+1)
    
    
    
    i = 0
    while (i < array_length(indices)) {
      val colIdx = (indices(i) & unit(0x00000000ffffffffL)).toInt
      array_update(outColIndices, i, colIdx)
      array_update(outData, i, elems(indices(i)))
    
      val rowIdx = (indices(i) >>> 32).toInt
      array_update(outRowPtr, rowIdx+1, outRowPtr(rowIdx+1)+1)
      i += 1
    }
    
    coo_to_csr_finalize(self,outData,outColIndices,outRowPtr)
  }

  def coo_to_csr_finalize_impl[T:Manifest](self: Rep[SparseMatrixBuildable[T]],outData: Rep[ForgeArray[T]],outColIndices: Rep[ForgeArray[Int]],outRowPtr: Rep[ForgeArray[Int]])(implicit __pos: SourceContext): Rep[SparseMatrix[T]] = {
    var i = 0
    var acc = 0
    while (i < self.numRows) {
      acc += outRowPtr(i)
      array_update(outRowPtr, i, acc)
      i += 1
    }
    array_update(outRowPtr, self.numRows, array_length(outData))
    
    
    
    
    
    
    
    
    
    
    
    
    sparsematrix_csr_alloc_raw[T](self.numRows,self.numCols,outData.unsafeImmutable,outColIndices.unsafeImmutable,outRowPtr.unsafeImmutable,array_length(outData))
  }

}
