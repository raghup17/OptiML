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

trait SparseMatrixOpsImpl {
  this: OptiMLCompiler with OptiMLLift => 

  def sparsematrix_object_diag_impl2[T:Arith:Manifest](__arg0: Rep[Int],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[SparseMatrix[T]] = {
    val out = SparseMatrix[T](__arg0,__arg0)
    
    for (i <- 0 until __arg0) {
      out(i,i) = __arg1(i)
    }
    out.finish
  }

  def sparsematrix_object_identity_impl3(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[SparseMatrix[Double]] = {
    val out = SparseMatrix[Double](__arg0,__arg0)
    for (i <- 0 until __arg0) {
      out(i,i) = 1.0
    }
    out.finish
  }

  def sparsematrix_object_zeros_impl4(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[SparseMatrix[Double]] = {
    sparsematrix_csr_alloc_raw(__arg0, __arg1, array_empty[Double](unit(0)), array_empty[Int](unit(0)), array_empty[Int](__arg0+unit(1)), unit(0))
  }

  def sparsematrix_object_zerosf_impl4(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[SparseMatrix[Float]] = {
    sparsematrix_csr_alloc_raw(__arg0, __arg1, array_empty[Float](unit(0)), array_empty[Int](unit(0)), array_empty[Int](__arg0+unit(1)), unit(0))
  }

  def sparsematrix_rand_impl[T:Manifest](numRows: Rep[Int],numCols: Rep[Int],sparsity: Rep[Double],gen: (Rep[Int]) => Rep[T])(implicit __pos: SourceContext): Rep[SparseMatrix[T]] = {
    val density = 1.0 - sparsity
    val size = numRows*numCols
    val nnz = floor(density*size)
    val indices = shuffle(0::size).take(nnz)
    
    val out = SparseMatrix[T](numRows,numCols)
    for (i <- indices) {
      
      
      val t: Rep[Tup2[Int,Int]] = matrix_shapeindex(i,numCols)
      val rowIndex: Rep[Int] = t._1
      val colIndex: Rep[Int] = t._2
      out(rowIndex,colIndex) = gen(i)
    }
    out.finish
  }

  def sparsematrix_object_rand_impl4(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Double])(implicit __pos: SourceContext): Rep[SparseMatrix[Double]] = {
    sparsematrix_rand[Double](__arg0, __arg1, __arg2, i => random[Double])
  }

  def sparsematrix_object_randf_impl4(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Double])(implicit __pos: SourceContext): Rep[SparseMatrix[Float]] = {
    sparsematrix_rand[Float](__arg0, __arg1, __arg2, i => random[Float])
  }

  def sparsematrix_object_randn_impl2(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Double])(implicit __pos: SourceContext): Rep[SparseMatrix[Double]] = {
    sparsematrix_rand[Double](__arg0, __arg1, __arg2, i => randomGaussian)
  }

  def sparsematrix_object_randnf_impl2(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Double])(implicit __pos: SourceContext): Rep[SparseMatrix[Float]] = {
    sparsematrix_rand[Float](__arg0, __arg1, __arg2, i => randomGaussian.toFloat)
  }

  def sparsematrix_size_impl15[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[Int] = {
    self.numRows*self.numCols
  }

  def sparsematrix_nz_impl3[T:Manifest](self: Rep[SparseMatrix[T]],asRow: Rep[Boolean] = unit(true))(implicit __pos: SourceContext): Rep[DenseVector[T]] = {
    densevector_alloc_raw(self.nnz, asRow, sparsematrix_csr_data(self))
  }

  def sparsematrix_csr_find_offset_impl[T:Manifest](self: Rep[SparseMatrix[T]],row: Rep[Int],col: Rep[Int])(implicit __pos: SourceContext): Rep[Int] = {
    val rowPtr = sparsematrix_csr_rowptr(self)
    val colIndices = sparsematrix_csr_colindices(self)
    
    bsearch(colIndices, rowPtr(row), rowPtr(row+1)-1, col)
  }

  def sparsematrix_apply_impl29[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext): Rep[T] = {
    val data = sparsematrix_csr_data(self)
    val offRaw = sparsematrix_csr_find_offset(self, __arg1, __arg2)
    if (offRaw > -1) data(offRaw) else defaultValue[T]
  }

  def sparsematrix_apply_impl33[T:Manifest](self: Rep[SparseMatrix[T]],rows: Rep[IndexVector],cols: Rep[IndexVector])(implicit __pos: SourceContext): Rep[SparseMatrix[T]] = {
    val out = SparseMatrix[T](rows.length, cols.length)
    for (i <- 0 until rows.length) {
      
      val row: Rep[SparseVectorView[T]] = self(rows(i))
      for (j <- 0 until cols.length) {
        val col = cols(j)
        if (row(col) != defaultValue[T]) {
          out(i,j) = row(col)
        }
      }
    }
    out.finish
  }

  def sparsematrix_rowindices_impl2[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[IndexVector] = {
    val rowPtr = sparsematrix_csr_rowptr(self)
    val nnz = rowPtr(array_length(rowPtr)-1)
    val rows = array_empty[Int](nnz)
    var i = 0
    var oldRow = rowPtr(0)
    while (i < array_length(rowPtr)) {
      val nextRow = rowPtr(i)
      if (nextRow != oldRow) {
        for (j <- oldRow until nextRow) {
          rows(j) = i-1
        }
      }
      oldRow = nextRow
      i += 1
    }
    indexvector_fromarray(rows.unsafeImmutable, false)
  }

  def sparsematrix_colindices_impl2[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[IndexVector] = {
    IndexVector(indexvector_fromarray(sparsematrix_csr_colindices(self), true).distinct)
  }

  def sparsematrix_vview_impl[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[Int],__arg4: Rep[Boolean])(implicit __pos: SourceContext): Rep[SparseVectorView[T]] = {
    SparseVectorView[T](self, __arg1, __arg2, __arg3, __arg4)
  }

  def sparsematrix_getrow_impl2[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[SparseVectorView[T]] = {
    sparsematrix_vview(self, __arg1*self.numCols, 1, self.numCols, true)
  }

  def sparsematrix_getrows_impl2[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext): Rep[SparseMatrix[T]] = {
    val out = SparseMatrix[T](__arg1.length, self.numCols)
    for (i <- 0 until __arg1.length) {
      
      val row: Rep[SparseVectorView[T]] = self(__arg1(i))
      val rowData = row.nz
      val rowIndices = row.indices
      for (j <- 0 until rowData.length) {
        out(i,rowIndices(j)) = rowData(j)
      }
    }
    out.finish
  }

  def sparsematrix_getcol_impl2[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[SparseVectorView[T]] = {
    sparsematrix_vview(self, __arg1, self.numCols, self.numRows, false)
  }

  def sparsematrix_getcols_impl2[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext): Rep[SparseMatrix[T]] = {
    val out = SparseMatrix[T](self.numRows, __arg1.length)
    for (j <- 0 until __arg1.length) {
      val col = self.getCol(__arg1(j))
      val colData = col.nz
      val colIndices = col.indices
      for (i <- 0 until colData.length) {
        out(colIndices(i),j) = colData(i)
      }
    }
    out.finish
  }

  def sparsematrix_t_impl5[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[SparseMatrix[T]] = {
    val out = SparseMatrix[T](self.numCols, self.numRows)
    val rowPtr = sparsematrix_csr_rowptr(self)
    val colIndices = sparsematrix_csr_colindices(self)
    val data = sparsematrix_csr_data(self)
    
    
    for (i <- self.rowIndices) {
      for (j <- rowPtr(i) until rowPtr(i+1)) {
        out(colIndices(j),i) = data(j)
      }
    }
    out.finish
  }

  def sparsematrix_clone_impl7[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[SparseMatrix[T]] = {
    self.mapnz(e =>e)
  }

  def sparsematrix_mutable_impl17[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[SparseMatrixBuildable[T]] = {
    val out = SparseMatrix[T](self.numRows, self.numCols)
    val rowPtr = sparsematrix_csr_rowptr(self)
    val colIndices = sparsematrix_csr_colindices(self)
    val data = sparsematrix_csr_data(self)
    
    
    for (i <- self.rowIndices) {
      for (j <- rowPtr(i) until rowPtr(i+1)) {
        out(i,colIndices(j)) = data(j)
      }
    }
    out
  }

  def sparsematrix_todense_impl5[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[DenseMatrix[T]] = {
    val out = DenseMatrix[T](self.numRows, self.numCols)
    val rowPtr = sparsematrix_csr_rowptr(self)
    val colIndices = sparsematrix_csr_colindices(self)
    val data = sparsematrix_csr_data(self)
    
    
    out.rowIndices.foreach { i =>
      for (j <- rowPtr(i) until rowPtr(i+1)) {
        out(i,colIndices(j)) = data(j)
      }
    }
    
    out.unsafeImmutable
  }

  def sparsematrix_pprint_impl7[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]): Rep[Unit] = {
    println(self.makeStr + "\n")
  }

  def sparsematrix_makestring_impl7[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]): Rep[String] = {
    val rowPtr = sparsematrix_csr_rowptr(self)
    val colIndices = sparsematrix_csr_colindices(self)
    val data = sparsematrix_csr_data(self)
    var s = ""
    
    if (self == null) {
      s = "null"
    }
    else if (self.nnz < 1) {
      s = "[ ]"
    }
    else {
      for (i <- 0 until self.numRows) {
        val nnz = rowPtr(i+1) - rowPtr(i)
        if (nnz > 0) {
          s = s + "(" + i + "): "
          for (j <- rowPtr(i) until rowPtr(i+1)-1) {
    s = s + "(" + colIndices(j) + ", " + data(j).makeStr + "), "
          }
          val lineEnd = if (i == self.numRows-1) "" else "\n"
          s = s + "(" + colIndices(rowPtr(i+1)-1) + ", " + data(rowPtr(i+1)-1).makeStr + ")" + lineEnd
        }
      }
      s
    }
    s
  }

  def sparsematrix_tostring_impl16[T:Manifest](self: Rep[SparseMatrix[T]]): Rep[String] = {
    val rowPtr = sparsematrix_csr_rowptr(self)
    val colIndices = sparsematrix_csr_colindices(self)
    val data = sparsematrix_csr_data(self)
    var s = ""
    
    if (self == null) {
      s = "null"
    }
    else if (self.nnz < 1) {
      s = "[ ]"
    }
    else {
      for (i <- 0 until self.numRows) {
        val nnz = rowPtr(i+1) - rowPtr(i)
        if (nnz > 0) {
          s = s + "(" + i + "): "
          for (j <- rowPtr(i) until rowPtr(i+1)-1) {
    s = s + "(" + colIndices(j) + ", " + optila_fmt_str(data(j)) + "), "
          }
          val lineEnd = if (i == self.numRows-1) "" else "\n"
          s = s + "(" + colIndices(rowPtr(i+1)-1) + ", " + optila_fmt_str(data(rowPtr(i+1)-1)) + ")" + lineEnd
        }
      }
    }
    s
  }

  def sparematrix_csr_update_impl[T:Manifest](self: Rep[SparseMatrix[T]],i: Rep[Int],j: Rep[Int],y: Rep[T])(implicit __pos: SourceContext): Rep[Unit] = {
    if (Settings.verbose > 0) println("(performance warning): writing to a sparse matrix CSR representation")
    
    val offRaw = sparsematrix_csr_find_offset(self,i,j)
    if (offRaw > -1) array_update(sparsematrix_csr_data(self), offRaw, y)
    else {
      if (y != defaultValue[T]) {
        val off = ~offRaw
        sparsematrix_csr_insertspace(self, off, 1)
        array_update(sparsematrix_csr_colindices(self), off, j)
        array_update(sparsematrix_csr_data(self), off, y)
        val rowPtr = sparsematrix_csr_rowptr(self)
        
        for (row <- i+1 until array_length(rowPtr)) {
          array_update(rowPtr,row,rowPtr(row)+1)
        }
      }
    }
  }

  def sparsematrix_csr_ensureextra_impl[T:Manifest](self: Rep[SparseMatrix[T]],extra: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    if (array_length(sparsematrix_csr_data(self)) - self.nnz < extra) {
      sparsematrix_csr_realloc(self,self.nnz + extra)
    }
  }

  def sparsematrix_csr_realloc_impl[T:Manifest](self: Rep[SparseMatrix[T]],minLen: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    val data = sparsematrix_csr_data(self)
    val colIndices = sparsematrix_csr_colindices(self)
    var n = max(4, array_length(data) * 2)
    while (n < minLen) n = n*2
    val outData = array_empty[T](n)
    val outColIndices = array_empty[Int](n)
    array_copy(data, 0, outData, 0, self.nnz)
    array_copy(colIndices, 0, outColIndices, 0, self.nnz)
    sparsematrix_csr_set_data(self, outData.unsafeImmutable)
    sparsematrix_csr_set_colindices(self, outColIndices.unsafeImmutable)
  }

  def sparsematrix_csr_insertspace_impl[T:Manifest](self: Rep[SparseMatrix[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    sparsematrix_csr_ensureextra(self,len)
    val data = sparsematrix_csr_data(self)
    val colIndices = sparsematrix_csr_colindices(self)
    array_copy(data, pos, data, pos + len, self.nnz - pos)
    array_copy(colIndices, pos, colIndices, pos + len, self.nnz - pos)
    sparsematrix_csr_set_nnz(self, self.nnz + len)
  }

  def zipMatrixUnion_impl[T:Manifest,B:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext): Rep[SparseMatrix[R]] = {
    val aData = sparsematrix_csr_data(self)
    val aColIndices = sparsematrix_csr_colindices(self)
    val aRowPtr = sparsematrix_csr_rowptr(self)
    val bData = sparsematrix_csr_data(__arg1)
    val bColIndices = sparsematrix_csr_colindices(__arg1)
    val bRowPtr = sparsematrix_csr_rowptr(__arg1)
    
    val outRowPtr = array_empty[Int](self.numRows+1)
    val outColIndices = array_empty[Int](self.nnz + __arg1.nnz) 
    val outData = array_empty[R](self.nnz + __arg1.nnz)
    
    var aOldRow = aRowPtr(0)
    var bOldRow = bRowPtr(0)
    var nnz = 0
    var i = 0
    
    while (i < self.numRows+1) {
      
      if (aRowPtr(i) != aOldRow || bRowPtr(i) != bOldRow) {
        nnz = zipUnion(nnz, aOldRow, aRowPtr(i), aColIndices, aData, bOldRow, bRowPtr(i), bColIndices, bData, outColIndices, outData, __arg2)
      }
      outRowPtr(i) = nnz
      aOldRow = aRowPtr(i)
      bOldRow = bRowPtr(i)
      i += 1
    }
    
    sparsematrix_csr_alloc_raw[R](self.numRows, self.numCols, outData.unsafeImmutable, outColIndices.unsafeImmutable, outRowPtr.unsafeImmutable, nnz)
  }

  def zipMatrixIntersect_impl[T:Manifest,B:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext): Rep[SparseMatrix[R]] = {
    val aData = sparsematrix_csr_data(self)
    val aColIndices = sparsematrix_csr_colindices(self)
    val aRowPtr = sparsematrix_csr_rowptr(self)
    val bData = sparsematrix_csr_data(__arg1)
    val bColIndices = sparsematrix_csr_colindices(__arg1)
    val bRowPtr = sparsematrix_csr_rowptr(__arg1)
    
    val outRowPtr = array_empty[Int](self.numRows+1)
    val outColIndices = array_empty[Int](self.nnz + __arg1.nnz) 
    val outData = array_empty[R](self.nnz + __arg1.nnz)
    
    var aOldRow = aRowPtr(0)
    var bOldRow = bRowPtr(0)
    var nnz = 0
    var i = 0
    
    while (i < self.numRows+1) {
      
      if (aRowPtr(i) != aOldRow || bRowPtr(i) != bOldRow) {
        nnz = zipIntersect(nnz, aOldRow, aRowPtr(i), aColIndices, aData, bOldRow, bRowPtr(i), bColIndices, bData, outColIndices, outData, __arg2)
      }
      outRowPtr(i) = nnz
      aOldRow = aRowPtr(i)
      bOldRow = bRowPtr(i)
      i += 1
    }
    
    sparsematrix_csr_alloc_raw[R](self.numRows, self.numCols, outData.unsafeImmutable, outColIndices.unsafeImmutable, outRowPtr.unsafeImmutable, nnz)
  }

  def sparsematrix_pl_impl136[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseMatrix[T]] = {
    zipMatrixUnion[T,T,T](self, __arg1, (a,b) => a+b)
  }

  def sparsematrix_pl_impl137[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]] = {
    self.toDense + __arg1
  }

  def sparsematrix_pl_impl138[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]] = {
    self.toDense + __arg1
  }

  def sparsematrix_sub_impl102[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseMatrix[T]] = {
    zipMatrixUnion[T,T,T](self, __arg1, (a,b) => a-b)
  }

  def sparsematrix_sub_impl103[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]] = {
    self.toDense - __arg1
  }

  def sparsematrix_sub_impl104[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]] = {
    self.toDense - __arg1
  }

  def sparsematrix_mulclnmul_impl26[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseMatrix[T]] = {
    zipMatrixIntersect[T,T,T](self, __arg1, (a,b) => a*b)
  }

  def sparsematrix_mulclnmul_impl27[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]] = {
    self.toDense * __arg1
  }

  def sparsematrix_mul_impl142[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseMatrix[T]] = {
    self.mapnz(e => e*__arg1)
  }

  def sparsematrix_div_impl103[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseMatrix[T]] = {
    zipMatrixIntersect[T,T,T](self, __arg1, (a,b) => a/b)
  }

  def sparsematrix_div_impl104[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]] = {
    self.toDense / __arg1
  }

  def sparsematrix_div_impl105[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseMatrix[T]] = {
    self.mapnz(e => e/__arg1)
  }

  def sparsematrix_sum_impl6[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T] = {
    self.nz.sum
  }

  def sparsematrix_mean_impl6[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]): Rep[Double] = {
    self.mapnz(conv).sum / self.size
  }

  def sparsematrix_abs_impl22[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseMatrix[T]] = {
    self.mapnz { e => e.abs }
  }

  def sparsematrix_sumrows_impl2[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseVector[T]] = {
    self.mapRowsToVector { row => sum(row) }
  }

  def sparsematrix_sumcols_impl2[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseVector[T]] = {
    self.mapColsToVector { col => sum(col) }
  }

  def sparsematrix_min_impl7[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[T] = {
    val min = self.nz.min
    if (min > defaultValue[T]) defaultValue[T] else min
  }

  def sparsematrix_max_impl7[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[T] = {
    val max = self.nz.max
    if (max < defaultValue[T]) defaultValue[T] else max
  }

  def sparsematrix_minrows_impl2[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[SparseVector[T]] = {
    self.mapRowsToVector { row => min(row.toSparse) }
  }

  def sparsematrix_mincols_impl2[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[SparseVector[T]] = {
    self.mapColsToVector { col => min(col.toSparse) }
  }

  def sparsematrix_maxrows_impl2[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[SparseVector[T]] = {
    self.mapRowsToVector { row => max(row.toSparse) }
  }

  def sparsematrix_maxcols_impl2[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[SparseVector[T]] = {
    self.mapColsToVector { col => max(col.toSparse) }
  }

  def sparsematrix___equal_impl16[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext): Rep[Boolean] = {
    if (self.numRows != __arg1.numRows || self.numCols != __arg1.numCols) false
    else {
      val dataEqual = densevector_alloc_raw(self.nnz, true, sparsematrix_csr_data(self)) == densevector_alloc_raw(__arg1.nnz, true, sparsematrix_csr_data(__arg1))
      val colIndexEqual = densevector_alloc_raw(self.nnz, true, sparsematrix_csr_colindices(self)) == densevector_alloc_raw(__arg1.nnz, true, sparsematrix_csr_colindices(__arg1))
      val rowPtrEqual = densevector_alloc_raw(self.numRows+1, true, sparsematrix_csr_rowptr(self)) == densevector_alloc_raw(__arg1.numRows+1, true, sparsematrix_csr_rowptr(__arg1))
      dataEqual && colIndexEqual && rowPtrEqual
    }
  }

  def sparsematrix___equal_impl17[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext): Rep[Boolean] = {
    self.toDense == __arg1
  }

  def sparsematrix_mapnz_impl2[T:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext): Rep[SparseMatrix[R]] = {
    val out = self.nz.map(__arg1)
    sparsematrix_csr_alloc_raw(self.numRows, self.numCols, densevector_raw_data(out), sparsematrix_csr_colindices(self), sparsematrix_csr_rowptr(self), self.nnz)
  }

  def sparsematrix_foreachnz_impl2[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit] = {
    self.nz.foreach(__arg1)
  }

  def sparsematrix_countnz_impl2[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[Int] = {
    self.nz.count(__arg1)
  }

  def sparsematrix_maprowstovector_impl2[T:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[R])(implicit __pos: SourceContext): Rep[SparseVector[R]] = {
    sparsevector_fromfunc(self.numRows, false, self.nzRows, i => __arg1(self(i)))
  }

  def sparsematrix_mapcolstovector_impl2[T:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[R])(implicit __pos: SourceContext): Rep[SparseVector[R]] = {
    sparsevector_fromfunc(self.numCols, true, self.nzCols, i => __arg1(self.getCol(i)))
  }

  def sparsematrix_findrows_impl2[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[IndexVector] = {
    IndexVector(self.nzRows.filter(i => __arg1(self(i))))
  }

  def sparsematrix_findcols_impl2[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[IndexVector] = {
    IndexVector(self.nzCols.filter(i => __arg1(self.getCol(i))))
  }

  def sparsematrix_filterrows_impl2[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[SparseMatrix[T]] = {
    self(self.findRows(__arg1))
  }

  def sparsematrix_filtercols_impl2[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[SparseMatrix[T]] = {
    self.getCols(self.findCols(__arg1))
  }

  def sparsematrix_foreachrow_impl3[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit] = {
    self.nzRows foreach { i => __arg1(self(i)) }
  }

  def sparsematrix_foreachcol_impl2[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit] = {
    self.nzCols foreach { i => __arg1(self.getCol(i)) }
  }

}
