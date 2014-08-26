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

trait SparseVectorOpsImpl {
  this: OptiMLCompiler with OptiMLLift => 

  def sparsevector_fromfunc_impl[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Boolean],__arg2: Rep[IndexVector],__arg3: (Rep[Int]) => Rep[T])(implicit __pos: SourceContext): Rep[SparseVector[T]] = {
    val sorted = __arg2.sort
    sparsevector_alloc_raw(__arg0, __arg1, densevector_raw_data(sorted.map(__arg3)), densevector_raw_data(sorted), sorted.length)
  }

  def sparsevector_object_rand_impl1(length: Rep[Int],sparsity: Rep[Double])(implicit __pos: SourceContext): Rep[SparseVector[Double]] = {
    val density = 1.0 - sparsity
    val nnz = floor(density*length)
    val indices = shuffle(0::length).take(nnz)
    sparsevector_fromfunc(length, true, indices, i => random[Double])
  }

  def sparsevector_object_randf_impl1(length: Rep[Int],sparsity: Rep[Double])(implicit __pos: SourceContext): Rep[SparseVector[Float]] = {
    val density = 1.0 - sparsity
    val nnz = floor(density*length)
    val indices = shuffle(0::length).take(nnz)
    sparsevector_fromfunc(length, true, indices, i => random[Float])
  }

  def bsearch_impl(a: Rep[ForgeArray[Int]],_start: Rep[Int],_end: Rep[Int],pos: Rep[Int])(implicit __pos: SourceContext): Rep[Int] = {
    var start = _start
    var end = _end
    var mid = (start+end)/2
    var found = false
    while (!found && (start <= end)) {
      mid = (start+end)/2
      if (pos > a(mid)) {
        start = mid + 1
      }
      else if (pos < a(mid)) {
        end = mid - 1
      }
      else {
        found = true
      }
    }
    
    if (found) mid
    else {
      
      if (_end < _start) ~(_start)
      else if (pos > a(mid)) ~(mid+1)
      else ~mid
    }
  }

  def defaultValue_impl[T:Manifest]()(implicit __pos: SourceContext): Rep[T] = {
    manifest[T] match {
      case Manifest.Boolean => unit(false).asInstanceOf[Rep[T]]
      case Manifest.Int => unit(0).asInstanceOf[Rep[T]]
      case Manifest.Long => unit(0L).asInstanceOf[Rep[T]]
      case Manifest.Float => unit(0f).asInstanceOf[Rep[T]]
      case Manifest.Double => unit(0.0).asInstanceOf[Rep[T]]
      case _ => fatal("no default value found for type: " + manifest[T])
    }
  }

  def zipUnion_impl[A:Manifest,B:Manifest,R:Manifest](nnzInit: Rep[Int],aIdxInit: Rep[Int],annz: Rep[Int],aIndices: Rep[ForgeArray[Int]],aData: Rep[ForgeArray[A]],bIdxInit: Rep[Int],bnnz: Rep[Int],bIndices: Rep[ForgeArray[Int]],bData: Rep[ForgeArray[B]],outIndices: Rep[ForgeArray[Int]],outData: Rep[ForgeArray[R]],f: (Rep[A],Rep[B]) => Rep[R])(implicit __pos: SourceContext): Rep[Int] = {
    var nnz = nnzInit
    var aIdx = aIdxInit
    var bIdx = bIdxInit
    while (aIdx < annz || bIdx < bnnz) {
      
      if (aIdx < annz && bIdx < bnnz) {
        
        if (array_apply(aIndices,aIdx) < array_apply(bIndices,bIdx)) {
    array_update(outIndices, nnz, array_apply(aIndices,aIdx))
    array_update(outData, nnz, f(array_apply(aData,aIdx),defaultValue[B]))
    aIdx += 1
        }
        else if (array_apply(aIndices,aIdx) > array_apply(bIndices,bIdx)) {
    array_update(outIndices, nnz, array_apply(bIndices,bIdx))
    array_update(outData, nnz, f(defaultValue[A], array_apply(bData,bIdx)))
    bIdx += 1
        }
        else {
    array_update(outIndices, nnz, array_apply(aIndices,aIdx)) 
    array_update(outData, nnz, f(array_apply(aData,aIdx),array_apply(bData,bIdx)))
    aIdx += 1
    bIdx += 1
        }
      }
      else if (aIdx < annz) {
        
        array_update(outIndices, nnz, array_apply(aIndices,aIdx))
        array_update(outData, nnz, f(array_apply(aData,aIdx),defaultValue[B]))
        aIdx += 1
      }
      else if (bIdx < bnnz) {
        
        array_update(outIndices, nnz, array_apply(bIndices,bIdx))
        array_update(outData, nnz, f(defaultValue[A], array_apply(bData,bIdx)))
        bIdx += 1
      }
      else {
        fatal("zipUnion should never reach here")
      }
      nnz += 1
    }
    nnz
  }

  def zipIntersect_impl[A:Manifest,B:Manifest,R:Manifest](nnzInit: Rep[Int],aIdxInit: Rep[Int],annz: Rep[Int],aIndices: Rep[ForgeArray[Int]],aData: Rep[ForgeArray[A]],bIdxInit: Rep[Int],bnnz: Rep[Int],bIndices: Rep[ForgeArray[Int]],bData: Rep[ForgeArray[B]],outIndices: Rep[ForgeArray[Int]],outData: Rep[ForgeArray[R]],f: (Rep[A],Rep[B]) => Rep[R])(implicit __pos: SourceContext): Rep[Int] = {
    var nnz = nnzInit
    var aIdx = aIdxInit
    var bIdx = bIdxInit
    while (aIdx < annz && bIdx < bnnz) {
      
      if (array_apply(aIndices,aIdx) < array_apply(bIndices,bIdx)) {
        aIdx += 1
      }
      else if (array_apply(aIndices,aIdx) > array_apply(bIndices,bIdx)) {
        bIdx += 1
      }
      else {
        array_update(outIndices, nnz, array_apply(aIndices,aIdx)) 
        array_update(outData, nnz, f(array_apply(aData,aIdx),array_apply(bData,bIdx)))
        aIdx += 1
        bIdx += 1
        nnz += 1
      }
    }
    nnz
  }

  def sparsevector_nz_impl2[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[DenseVectorView[T]] = {
    DenseVectorView[T](sparsevector_raw_data(self), 0, 1, self.nnz, self.isRow)
  }

  def sparsevector_indices_impl3[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[IndexVector] = {
    indexvector_fromarray(array_take(sparsevector_raw_indices(self), self.nnz), self.isRow)
  }

  def sparsevector_find_offset_impl[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int])(implicit __pos: SourceContext): Rep[Int] = {
    val indices = sparsevector_raw_indices(self)
    bsearch(indices, 0, self.nnz-1, pos)
  }

  def sparsevector_apply_impl11[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[T] = {
    val data = sparsevector_raw_data(self)
    val offRaw = sparsevector_find_offset(self, __arg1)
    if (offRaw > -1) array_apply(data,offRaw) else defaultValue[T]
  }

  def sparsevector_apply_impl12[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext): Rep[SparseVector[T]] = {
    val data = sparsevector_raw_data(self)
    val offsets = __arg1.map(i => sparsevector_find_offset(self,i))
    val logicalIndices = offsets.find(_ > -1) 
    val physicalIndices = logicalIndices.map(i => offsets(i))
    sparsevector_alloc_raw(__arg1.length, self.isRow, densevector_raw_data(physicalIndices.map(i => array_apply(data,i))), densevector_raw_data(logicalIndices), logicalIndices.length)
  }

  def sparsevector_isempty_impl2[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Boolean] = {
    self.nnz == 0
  }

  def sparsevector_first_impl2[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[T] = {
    self(0)
  }

  def sparsevector_firstnz_impl[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[T] = {
    self.nz.apply(0)
  }

  def sparsevector_last_impl2[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[T] = {
    self(self.length-1)
  }

  def sparsevector_lastnz_impl[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[T] = {
    self.nz.apply(self.nnz-1)
  }

  def sparsevector_drop_impl2[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[SparseVector[T]] = {
    self.slice(__arg1, self.length)
  }

  def sparsevector_take_impl2[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[SparseVector[T]] = {
    self.slice(0, __arg1)
  }

  def sparsevector_contains_impl3[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext): Rep[Boolean] = {
    if (__arg1 == defaultValue[T] && self.nnz < self.length) true
    else densevector_alloc_raw(self.nnz, true, sparsevector_raw_data(self)).contains(__arg1)
  }

  def sparsevector_distinct_impl2[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[DenseVector[T]] = {
    val data = densevector_alloc_raw(self.nnz, true, sparsevector_raw_data(self))
    val out = DenseVector[T](0, self.isRow)
    
    if (self.nnz < self.length) out <<= defaultValue[T]
    
    for (i <- 0 until self.nnz) {
      
      if (!out.contains(data(i))) out <<= data(i)
    }
    out.unsafeImmutable
  }

  def sparsevector_mt_impl1[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Unit] = {
    sparsevector_set_isrow(self, !self.isRow)
  }

  def sparsevector_todense_impl3[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[DenseVector[T]] = {
    val out = DenseVector[T](self.length, self.isRow)
    val indices = densevector_alloc_raw(self.nnz, true, sparsevector_raw_indices(self))
    val data = sparsevector_raw_data(self)
    (0::indices.length) foreach { i => out(indices(i)) = data(i) } 
    out.unsafeImmutable
  }

  def sparsevector_makestring_impl2[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]): Rep[String] = {
    val indices = sparsevector_raw_indices(self)
    val data = sparsevector_raw_data(self)
    var s = ""
    
    if (self == null) {
      s = "null"
    }
    else if (self.nnz == 0) {
      s = "[ ]"
    }
    else if (self.isRow) {
      for (i <- 0 until self.nnz-1) {
        s = s + "(" + array_apply(indices,i) + ", " + array_apply(data,i).makeStr + "), "
      }
      s = s + "(" + array_apply(indices,self.nnz-1) + ", " + array_apply(data,self.nnz-1).makeStr + ") "
    }
    else {
      for (i <- 0 until self.nnz-1) {
        s = s + "(" + array_apply(indices,i) + ", " + array_apply(data,i).makeStr + ")\n"
      }
      s = s + "(" + array_apply(indices,self.nnz-1) + ", " + array_apply(data,self.nnz-1).makeStr + ")"
    }
    s
  }

  def sparsevector_tostring_impl7[T:Manifest](self: Rep[SparseVector[T]]): Rep[String] = {
    val indices = sparsevector_raw_indices(self)
    val data = sparsevector_raw_data(self)
    var s = ""
    
    if (self == null) {
      s = "null"
    }
    else if (self.nnz == 0) {
      s = "[ ]"
    }
    else if (self.isRow) {
      for (i <- 0 until self.nnz-1) {
        s = s + "(" + array_apply(indices,i) + ", " + optila_fmt_str(array_apply(data,i)) + "), "
      }
      s = s + "(" + array_apply(indices,self.nnz-1) + ", " + optila_fmt_str(array_apply(data,self.nnz-1)) + ") "
    }
    else {
      for (i <- 0 until self.nnz-1) {
        s = s + "(" + array_apply(indices,i) + ", " + optila_fmt_str(array_apply(data,i)) + ")\n"
      }
      s = s + "(" + array_apply(indices,self.nnz-1) + ", " + optila_fmt_str(array_apply(data,self.nnz-1)) + ")"
    }
    s
  }

  def sparsevector_pprint_impl2[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]): Rep[Unit] = {
    println(self.makeStr + "\n")
  }

  def sparsevector_update_impl2[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],e: Rep[T])(implicit __pos: SourceContext): Rep[Unit] = {
    val offRaw = sparsevector_find_offset(self, pos)
    if (offRaw > -1) array_update(sparsevector_raw_data(self), offRaw, e)
    else {
      if (e != defaultValue[T]) {
        val off = ~offRaw
        sparsevector_insertspace(self, off, 1)
        array_update(sparsevector_raw_indices(self), off, pos)
        array_update(sparsevector_raw_data(self), off, e)
      }
    }
  }

  def sparsevector_update_impl3[T:Manifest](self: Rep[SparseVector[T]],indices: Rep[IndexVector],e: Rep[T])(implicit __pos: SourceContext): Rep[Unit] = {
    for (i <- 0 until indices.length) {
      fassert(indices(i) >= 0 && indices(i) < self.length, "index out of bounds: bulk vector update")
      self(indices(i)) = e
    }
  }

  def sparsevector_update_impl4[T:Manifest](self: Rep[SparseVector[T]],indices: Rep[IndexVector],v: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Unit] = {
    fassert(indices.length == v.length, "dimension mismatch: bulk vector update")
    
    for (i <- 0 until indices.length) {
      fassert(indices(i) >= 0 && indices(i) < self.length, "index out of bounds: bulk vector update")
      self(indices(i)) = v(i)
    }
  }

  def sparsevector_ltlt_impl3[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext): Rep[SparseVector[T]] = {
    val out = self.mutable
    out <<= __arg1
    out.unsafeImmutable
  }

  def sparsevector_ltlt_impl4[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[SparseVector[T]] = {
    val outIndices = array_empty[Int](self.nnz + __arg1.nnz)
    val outData = array_empty[T](self.nnz + __arg1.nnz)
    
    for (i <- 0 until self.nnz) {
      array_update(outIndices, i, array_apply(sparsevector_raw_indices(self), i))
      array_update(outData, i, array_apply(sparsevector_raw_data(self), i))
    }
    for (i <- 0 until __arg1.nnz) {
      array_update(outIndices, i+self.nnz, array_apply(sparsevector_raw_indices(__arg1), i)+self.length)
      array_update(outData, i+self.nnz, array_apply(sparsevector_raw_data(__arg1), i))
    }
    
    sparsevector_alloc_raw(self.length+__arg1.length, self.isRow, outData, outIndices, array_length(outIndices))
  }

  def sparsevector_ltlteq_impl1[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext): Rep[Unit] = {
    sparsevector_insert_at_off(self, self.nnz, self.length, __arg1)
  }

  def sparsevector_ltlteq_impl2[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Unit] = {
    self.insertAll(self.length,__arg1)
  }

  def sparsevector_insert_at_off_impl[T:Manifest](self: Rep[SparseVector[T]],off: Rep[Int],pos: Rep[Int],e: Rep[T])(implicit __pos: SourceContext): Rep[Unit] = {
    sparsevector_insertspace(self, off, 1)
    val data = sparsevector_raw_data(self)
    val indices = sparsevector_raw_indices(self)
    array_update(indices, off, pos)
    array_update(data, off, e)
    for (i <- off+1 until self.nnz) {
      array_update(indices, i, indices(i) + 1)
    }
    
    sparsevector_set_length(self, self.length + 1)
  }

  def sparsevector_insert_impl1[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext): Rep[Unit] = {
    val offRaw = sparsevector_find_offset(self, __arg1)
    val off = if (offRaw > -1) offRaw else ~offRaw
    sparsevector_insert_at_off(self, off, __arg1, __arg2)
  }

  def sparsevector_insertall_impl1[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],xs: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Unit] = {
    val offRaw = sparsevector_find_offset(self, pos)
    val off = if (offRaw > -1) offRaw else ~offRaw
    
    sparsevector_insertspace(self, off, xs.nnz)
    val data = sparsevector_raw_data(self)
    val indices = sparsevector_raw_indices(self)
    for (i <- 0 until xs.nnz) {
      array_update(indices, i+off, array_apply(sparsevector_raw_indices(xs),i)+pos)
      array_update(data, i+off, array_apply(sparsevector_raw_data(xs), i))
    }
    
    for (i <- off+xs.nnz until self.nnz) {
      array_update(indices, i, array_apply(indices, i) + xs.length)
    }
    
    sparsevector_set_length(self, self.length + xs.length)
  }

  def sparsevector_remove_impl1[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    self.removeAll(__arg1, 1)
  }

  def sparsevector_removeall_impl1[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    val data = sparsevector_raw_data(self)
    val indices = sparsevector_raw_indices(self)
    val startRaw = sparsevector_find_offset(self, pos)
    val start = if (startRaw > -1) startRaw else ~startRaw
    val endRaw = sparsevector_find_offset(self, pos+len)
    val end = if (endRaw > -1) endRaw else ~endRaw
    val remaining = self.nnz - end
    array_copy(data, end, data, start, remaining)
    array_copy(indices, end, indices, start, remaining)
    sparsevector_set_length(self, self.length - len)
    sparsevector_set_nnz(self, start+remaining)
  }

  def sparsevector_copyfrom_impl1[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],xs: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Unit] = {
    for (i <- 0 until xs.length) {
      val e = xs(i)
      
      if (e != defaultValue[T]) {
        self(pos+i) = e
      }
      
      
      else if (self(pos+i) != defaultValue[T]) {
        self(pos+i) = defaultValue[T]
      }
    }
  }

  def sparsevector_trim_impl1[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Unit] = {
    val data = sparsevector_raw_data(self)
    val indices = sparsevector_raw_indices(self)
    if (self.nnz < array_length(data)) {
      val outData = array_empty[T](self.nnz)
      val outIndices = array_empty[Int](self.nnz)
      array_copy(data, 0, outData, 0, self.nnz)
      array_copy(indices, 0, outIndices, 0, self.nnz)
      sparsevector_set_raw_data(self, outData.unsafeImmutable)
      sparsevector_set_raw_indices(self, outIndices.unsafeImmutable)
    }
  }

  def sparsevector_clear_impl1[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Unit] = {
    sparsevector_set_length(self, 0)
    sparsevector_set_nnz(self, 0)
    sparsevector_set_raw_data(self, (array_empty[T](0)).unsafeImmutable)
    sparsevector_set_raw_indices(self, (array_empty[Int](0)).unsafeImmutable)
  }

  def sparsevector_insertspace_impl[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    sparsevector_ensureextra(self,len)
    val data = sparsevector_raw_data(self)
    val indices = sparsevector_raw_indices(self)
    array_copy(data, pos, data, pos + len, self.nnz - pos)
    array_copy(indices, pos, indices, pos + len, self.nnz - pos)
    sparsevector_set_nnz(self, self.nnz + len)
  }

  def sparsevector_ensureextra_impl[T:Manifest](self: Rep[SparseVector[T]],extra: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    val data = sparsevector_raw_data(self)
    if (array_length(data) - self.nnz < extra) {
      sparsevector_realloc(self, self.nnz + extra)
    }
  }

  def sparsevector_realloc_impl[T:Manifest](self: Rep[SparseVector[T]],minLen: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    val data = sparsevector_raw_data(self)
    val indices = sparsevector_raw_indices(self)
    var n = max(4, array_length(data) * 2)
    while (n < minLen) n = n*2
    val newData = array_empty[T](n)
    val newIndices = array_empty[Int](n)
    array_copy(data, 0, newData, 0, self.nnz)
    array_copy(indices, 0, newIndices, 0, self.nnz)
    sparsevector_set_raw_data(self, newData.unsafeImmutable)
    sparsevector_set_raw_indices(self, newIndices.unsafeImmutable)
  }

  def zipVectorUnion_impl[T:Manifest,B:Manifest,R:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext): Rep[SparseVector[R]] = {
    val outIndices = array_empty[Int](self.nnz+__arg1.nnz) 
    val outData = array_empty[R](self.nnz+__arg1.nnz)
    
    val nnz = zipUnion(0, 0, self.nnz, sparsevector_raw_indices(self), sparsevector_raw_data(self), 0, __arg1.nnz, sparsevector_raw_indices(__arg1), sparsevector_raw_data(__arg1), outIndices, outData, __arg2)
    sparsevector_alloc_raw(self.length, self.isRow, outData.unsafeImmutable, outIndices.unsafeImmutable, nnz)
  }

  def zipVectorIntersect_impl[T:Manifest,B:Manifest,R:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext): Rep[SparseVector[R]] = {
    val outIndices = array_empty[Int](self.nnz) 
    val outData = array_empty[R](self.nnz)
    
    val nnz = zipIntersect(0, 0, self.nnz, sparsevector_raw_indices(self), sparsevector_raw_data(self), 0, __arg1.nnz, sparsevector_raw_indices(__arg1), sparsevector_raw_data(__arg1), outIndices, outData, __arg2)
    sparsevector_alloc_raw(self.length, self.isRow, outData.unsafeImmutable, outIndices.unsafeImmutable, nnz)
  }

  def sparsevector_pl_impl39[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseVector[T]] = {
    zipVectorUnion[T,T,T](self, __arg1, (a,b) => a+b)
  }

  def sparsevector_pl_impl40[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.toDense + __arg1
  }

  def sparsevector_pl_impl41[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.toDense + __arg1
  }

  def sparsevector_sub_impl39[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseVector[T]] = {
    zipVectorUnion[T,T,T](self, __arg1, (a,b) => a-b)
  }

  def sparsevector_sub_impl40[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.toDense - __arg1
  }

  def sparsevector_sub_impl41[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.toDense - __arg1
  }

  def sparsevector_mul_impl40[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseVector[T]] = {
    zipVectorIntersect[T,T,T](self, __arg1, (a,b) => a*b)
  }

  def sparsevector_mul_impl41[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.toDense * __arg1
  }

  def sparsevector_mul_impl42[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseVector[T]] = {
    self.mapnz(e => e*__arg1)
  }

  def sparsevector_mul_impl43[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    fassert(self.isRow, "dimension mismatch: vector * matrix")
    __arg1.t.mapRowsToVector { row => row *:* self }
  }

  def sparsevector_mulclnmul_impl5[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T] = {
    sum(self*__arg1)
  }

  def sparsevector_mulclnmul_impl6[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T] = {
    self.toDense *:* __arg1
  }

  def sparsevector_mulmul_impl5[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]] = {
    self.toDense ** __arg1
  }

  def sparsevector_div_impl40[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseVector[T]] = {
    zipVectorIntersect[T,T,T](self, __arg1, (a,b) => a/b)
  }

  def sparsevector_div_impl41[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.toDense / __arg1
  }

  def sparsevector_div_impl42[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseVector[T]] = {
    self.mapnz(e => e/__arg1)
  }

  def sparsevector_abs_impl7[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseVector[T]] = {
    self.mapnz { e => e.abs }
  }

  def sparsevector_sum_impl2[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T] = {
    self.nz.sum
  }

  def sparsevector_mean_impl2[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]): Rep[Double] = {
    self.mapnz(conv).sum / self.length
  }

  def sparsevector_min_impl3[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[T] = {
    val min = self.nz.min
    if (min > defaultValue[T]) defaultValue[T] else min
  }

  def sparsevector_max_impl3[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[T] = {
    val max = self.nz.max
    if (max < defaultValue[T]) defaultValue[T] else max
  }

  def sparsevector___equal_impl6[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[Boolean] = {
    self.toDense == __arg1
  }

  def sparsevector___equal_impl7[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): Rep[Boolean] = {
    __arg1 == self
  }

  def sparsevector___equal_impl8[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Boolean] = {
    if (self.length != __arg1.length || self.nnz != __arg1.nnz || self.isRow != __arg1.isRow) false
    else {
      val dataEqual = densevector_alloc_raw(self.nnz, true, sparsevector_raw_data(self)) == densevector_alloc_raw(__arg1.nnz, true, sparsevector_raw_data(__arg1))
      val indexEqual = densevector_alloc_raw(self.nnz, true, sparsevector_raw_indices(self)) == densevector_alloc_raw(__arg1.nnz, true, sparsevector_raw_indices(__arg1))
      dataEqual && indexEqual
    }
  }

  def sparsevector_mapnz_impl1[T:Manifest,R:Manifest](self: Rep[SparseVector[T]],__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext): Rep[SparseVector[R]] = {
    val out = self.nz.map(__arg1)
    sparsevector_alloc_raw(self.length, self.isRow, densevector_raw_data(out), sparsevector_raw_indices(self), self.nnz)
  }

  def sparsevector_reducenz_impl[T:Manifest](self: Rep[SparseVector[T]],__arg1: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T] = {
    self.nz.reduce(__arg1)
  }

  def sparsevector_filternz_impl[T:Manifest](self: Rep[SparseVector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[SparseVector[T]] = {
    val data = sparsevector_raw_data(self)
    val selected = (0::self.nnz).filter(i => __arg1(array_apply(data,i)))
    val indices = densevector_raw_data(selected)
    val removed = self.nnz - selected.length
    sparsevector_alloc_raw(self.length-removed, self.isRow, array_map[Int,T](indices, i => array_apply(data, i)), indices, selected.length)
  }

  def sparsevector_foreachnz_impl1[T:Manifest](self: Rep[SparseVector[T]],__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit] = {
    self.nz.foreach { __arg1 }
  }

  def sparsevector_findnz_impl[T:Manifest](self: Rep[SparseVector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[IndexVector] = {
    val data = sparsevector_raw_data(self)
    val indices = sparsevector_raw_indices(self)
    val selected = (0::self.nnz).filter(i => __arg1(array_apply(data, i)))
    IndexVector(selected.map(i => array_apply(indices, i)))
  }

  def sparsevector_countnz_impl1[T:Manifest](self: Rep[SparseVector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[Int] = {
    self.nz.count{__arg1}
  }

  def sparsevector_dist_impl1(__arg0: Rep[SparseVector[Double]],__arg1: Rep[SparseVector[Double]],__arg2: DistanceMetric)(implicit __pos: SourceContext): Rep[Double] = {
    __arg2 match {
      case ABS => sum(abs(__arg0 - __arg1))
      case SQUARE => sum(square(__arg0 - __arg1))
      case EUC => sqrt(sum(square(__arg0 - __arg1)))
    }
  }

}
