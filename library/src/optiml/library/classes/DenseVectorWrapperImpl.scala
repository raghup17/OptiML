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

trait DenseVectorWrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def densevector_fromfunc_impl[T:Manifest](__arg0: Rep[Int],__arg1: (Rep[Int]) => Rep[T])(implicit __pos: SourceContext): Rep[DenseVector[T]] = {
    (0::__arg0) { i => __arg1(i) }
  }

  def densevector_object_zeros_impl3(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVector[Double]] = {
    densevector_fromfunc(__arg0, i => 0.0 )
  }

  def densevector_object_zerosf_impl3(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVector[Float]] = {
    densevector_fromfunc(__arg0, i => 0f )
  }

  def densevector_object_ones_impl2(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVector[Double]] = {
    densevector_fromfunc(__arg0, i => 1.0)
  }

  def densevector_object_onesf_impl2(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVector[Float]] = {
    densevector_fromfunc(__arg0, i => 1f)
  }

  def densevector_object_rand_impl3(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVector[Double]] = {
    densevector_fromfunc(__arg0, i => random[Double])
  }

  def densevector_object_randf_impl3(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVector[Float]] = {
    densevector_fromfunc(__arg0, i => random[Float])
  }

  def densevector_object_uniform_impl(start: Rep[Int],step_size: Rep[Double],end: Rep[Int],isRow: Rep[Boolean] = unit(true))(implicit __pos: SourceContext): Rep[DenseVector[Double]] = {
    val length = ceil((end-start)/step_size)
    densevector_fromfunc(length, i => step_size*i + start)
  }

  def densevector_object_flatten_impl[T:Manifest](pieces: Rep[DenseVector[DenseVector[T]]])(implicit __pos: SourceContext): Rep[DenseVector[T]] = {
    if (pieces.length == 0){
      DenseVector[T](0, pieces.isRow).unsafeImmutable
    }
    else {
      val sizes = pieces map { e => e.length }
      val (total,begins) = unpack(densevector_precumulate[Int](sizes, 0, (_: Rep[Int]) + (_: Rep[Int])))
      val result = DenseVector[T](total, pieces.isRow)
      for (i <- 0 until pieces.length) {
        result.copyFrom(begins(i), pieces(i))
      }
      result.unsafeImmutable
    }
  }

  def densevector_precumulate_impl[T:Manifest](v: Rep[DenseVector[T]],identity: Rep[T],func: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext): Rep[Tup2[T,DenseVector[T]]] = {
    if (v.length == 0) {
      pack((identity,DenseVector[T](0,v.isRow).unsafeImmutable))
    }
    else {
      val result = DenseVector[T](0, v.isRow)
      var accum = identity
      for (i <- 0 until v.length) {
        result <<= accum
        accum = func(accum, v(i))
      }
      pack((accum,result.unsafeImmutable))
    }
  }

  def densevector_dc_alloc_impl[R:Manifest,CR:Manifest](__arg0: Rep[CR],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVector[R]] = {
    val simpleName = manifest[CR].erasure.getSimpleName
    val isRow = simpleName match {
      case s if s.startsWith("IndexVector") => indexvector_isrow(__arg0.asInstanceOf[Rep[IndexVector]])
      case s if s.startsWith("DenseVectorView") => densevectorview_isrow(__arg0.asInstanceOf[Rep[DenseVectorView[Any]]])
      case s if s.startsWith("DenseVector") => densevector_isrow(__arg0.asInstanceOf[Rep[DenseVector[Any]]])
    }
    DenseVector[R](__arg1, isRow)
  }

  def densevector_groupby_helper_impl[T:Manifest,K:Manifest,V:Manifest](__arg0: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit __pos: SourceContext): Rep[ForgeHashMap[K,ForgeArrayBuffer[V]]] = {
    def key: Rep[T] => Rep[K] = e => __arg1(e)
    def map: Rep[T] => Rep[V] = e => __arg2(e)
    val in = __arg0
    val out = SHashMap[K,ForgeArrayBuffer[V]]()
    var i = 0
    while (i < densevector_length(in)) {
      val e = densevector_apply(in, i)
        val k = key(e)
        if (!out.contains(k)) {
          val bucket = array_buffer_raw_alloc[V](null.asInstanceOf[Rep[ForgeArrayBuffer[V]]],0)
          array_buffer_dcappend(bucket, 0, map(e))
          out(k) = bucket
        }
        else {
          val bucket = out(k)
          array_buffer_dcappend(bucket, array_buffer_length(bucket), map(e))
        }
      i += 1
    }
    fhashmap_from_shashmap(out)
  }

  def densevector_tovector_impl[T:Manifest,R:Manifest](__arg0: Rep[ForgeHashMap[T,R]])(implicit __pos: SourceContext): Rep[DenseVector[R]] = {
    densevector_fromarray(fhashmap_values(__arg0), true)
  }

  def densevector_apply_impl27[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[T] = {
    array_apply(densevector_raw_data(self), __arg1)
  }

  def densevector_apply_impl28[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext): Rep[DenseVector[T]] = {
    val out = __arg1.map(i => self(i))
    if (self.isRow != __arg1.isRow) out.t else out
  }

  def densevector_mt_impl2[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[Unit] = {
    densevector_set_isrow(self, !self.isRow)
  }

  def densevector_tomat_impl[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[DenseMatrix[T]] = {
    if (self.isRow) {
      DenseMatrix(self)
    }
    else {
      DenseMatrix[T](0,0) <<| self
    }
  }

  def densevector_clone_impl6[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[DenseVector[T]] = {
    def func: Rep[T] => Rep[T] = e => e
    val in = self
    val out = densevector_dc_alloc[T,DenseVector[T]](in, densevector_length(in))
    var i = 0
    while (i < densevector_length(in)) {
      densevector_update(out, i, func(densevector_apply(in, i)))
      i += 1
    }
    out
  }

  def densevector_update_impl10[T:Manifest](self: Rep[DenseVector[T]],i: Rep[Int],e: Rep[T])(implicit __pos: SourceContext): Rep[Unit] = {
    array_update(densevector_raw_data(self), i, e)
  }

  def densevector_update_impl11[T:Manifest](self: Rep[DenseVector[T]],indices: Rep[IndexVector],e: Rep[T])(implicit __pos: SourceContext): Rep[Unit] = {
    (0::indices.length) foreach { i =>
      fassert(indices(i) >= 0 && indices(i) < self.length, "index out of bounds: bulk vector update")
      array_update(densevector_raw_data(self), indices(i), e)
    }
  }

  def densevector_update_impl12[T:Manifest](self: Rep[DenseVector[T]],indices: Rep[IndexVector],v: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[Unit] = {
    fassert(indices.length == v.length, "dimension mismatch: bulk vector update")
    
    
    
    (0::indices.length) foreach { i =>
      fassert(indices(i) >= 0 && indices(i) < self.length, "index out of bounds: bulk vector update")
      array_update(densevector_raw_data(self), indices(i), v(i))
    }
  }

  def densevector_ltlt_impl7[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext): Rep[DenseVector[T]] = {
    val out = self.mutable
    out <<= __arg1
    out.unsafeImmutable
  }

  def densevector_ltlt_impl8[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[DenseVector[T]] = {
    val out = DenseVector[T](self.length+__arg1.length, self.isRow)
    for (i <- 0 until self.length){
      out(i) = self(i)
    }
    for (i <- 0 until __arg1.length){
      out(i+self.length) = __arg1(i)
    }
    out.unsafeImmutable
  }

  def densevector_ltlteq_impl6[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext): Rep[Unit] = {
    self.insert(self.length,__arg1)
  }

  def densevector_ltlteq_impl7[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[Unit] = {
    self.insertAll(self.length,__arg1)
  }

  def densevector_insert_impl2[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext): Rep[Unit] = {
    densevector_insertspace(self,__arg1,1)
    self(__arg1) = __arg2
  }

  def densevector_insertall_impl2[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[Unit] = {
    densevector_insertspace(self, __arg1, __arg2.length)
    self.copyFrom(__arg1, __arg2)
  }

  def densevector_remove_impl2[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    self.removeAll(__arg1, 1)
  }

  def densevector_removeall_impl2[T:Manifest](self: Rep[DenseVector[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    val data = densevector_raw_data(self)
    array_copy(data, pos + len, data, pos, self.length - (pos + len))
    densevector_set_length(self, self.length - len)
  }

  def densevector_copyfrom_impl2[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[Unit] = {
    val d = densevector_raw_data(self)
    for (i <- 0 until __arg2.length) {
      array_update(d,__arg1+i,__arg2(i))
    }
  }

  def densevector_trim_impl4[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[Unit] = {
    val data = densevector_raw_data(self)
    if (self.length < array_length(data)) {
      val d = array_empty[T](self.length)
      array_copy(data, 0, d, 0, self.length)
      densevector_set_raw_data(self, d.unsafeImmutable)
    }
  }

  def densevector_clear_impl2[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[Unit] = {
    densevector_set_length(self, 0)
    densevector_set_raw_data(self, (array_empty[T](0)).unsafeImmutable)
  }

  def densevector_insertspace_impl[T:Manifest](self: Rep[DenseVector[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    densevector_ensureextra(self,len)
    val data = densevector_raw_data(self)
    array_copy(data,pos,data,pos+len,self.length-pos)
    densevector_set_length(self,self.length+len)
  }

  def densevector_ensureextra_impl[T:Manifest](self: Rep[DenseVector[T]],extra: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    val data = densevector_raw_data(self)
    if (array_length(data) - self.length < extra) {
      densevector_realloc(self, self.length+extra)
    }
  }

  def densevector_realloc_impl[T:Manifest](self: Rep[DenseVector[T]],minLen: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    val data = densevector_raw_data(self)
    var n = max(4, array_length(data)*2)
    while (n < minLen) n = n*2
    val d = array_empty[T](n)
    array_copy(data, 0, d, 0, self.length)
    densevector_set_raw_data(self, d.unsafeImmutable)
  }

  def densevector_pleq_impl3[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[Unit] = {
    self.indices.foreach { i => self(i) = self(i) + __arg1(i) }
  }

  def densevector_pleq_impl4[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[Unit] = {
    self.indices.foreach { i => self(i) = self(i) + __arg1 }
  }

  def densevector_pleq_impl5[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[Unit] = {
    self.indices.foreach { i => self(i) = self(i) + __arg1(i) }
  }

  def densevector_muleq_impl3[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[Unit] = {
    self.indices.foreach { i => self(i) = self(i) * __arg1(i) }
  }

  def densevector_muleq_impl4[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[Unit] = {
    self.indices.foreach { i => self(i) = self(i) * __arg1 }
  }

  def densevector_muleq_impl5[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[Unit] = {
    self.indices.foreach { i => self(i) = self(i) * __arg1(i) }
  }

  def densevector_subeq_impl3[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[Unit] = {
    self.indices.foreach { i => self(i) = self(i) - __arg1(i) }
  }

  def densevector_subeq_impl4[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[Unit] = {
    self.indices.foreach { i => self(i) = self(i) - __arg1 }
  }

  def densevector_subeq_impl5[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[Unit] = {
    self.indices.foreach { i => self(i) = self(i) - __arg1(i) }
  }

  def densevector_diveq_impl3[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[Unit] = {
    self.indices.foreach { i => self(i) = self(i) / __arg1(i) }
  }

  def densevector_diveq_impl4[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[Unit] = {
    self.indices.foreach { i => self(i) = self(i) / __arg1 }
  }

  def densevector_diveq_impl5[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[Unit] = {
    self.indices.foreach { i => self(i) = self(i) / __arg1(i) }
  }

  def densevector_sort_impl[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[DenseVector[T]] = {
    val v2 = self.mutable
    v2.trim()
    val a = array_sort(densevector_raw_data(v2))
    densevector_fromarray(a, self.isRow)
  }

  def densevector_sortby_impl[T:Manifest,B:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[B])(implicit __pos: SourceContext,__imp0: Ordering[B]): Rep[DenseVector[T]] = {
    val sortedIndicesRaw = densevector_sortindex_helper(0, self.length, densevector_raw_data(self.map(__arg1)))
    val sortedIndices = IndexVector(densevector_fromarray(sortedIndicesRaw,self.isRow))
    self(sortedIndices)
  }

  def densevector_sortwithindex_impl[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Tuple2[Rep[DenseVector[T]],Rep[IndexVector]] = {
    val sortedIndicesRaw = densevector_sortindex_helper(0, self.length, densevector_raw_data(self))
    val sortedIndices = IndexVector(densevector_fromarray(sortedIndicesRaw,self.isRow))
    (self(sortedIndices),sortedIndices)
  }

  def densevector_median_impl[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Numeric[T],__imp1: Ordering[T]): Rep[T] = {
    val x = self.sort
    val mid = x.length / 2
    if (x.length % 2 == 0) {
      ((x(mid).AsInstanceOf[Double] + x(mid-1).AsInstanceOf[Double]) / 2).AsInstanceOf[T]
    }
    else x(mid)
  }

  def densevector_clngt_impl2[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[DenseVector[Boolean]] = {
    def func: (Rep[T],Rep[T]) => Rep[Boolean] = (a,b) => a > b
    val inA = self
    val inB = __arg1
    val out = densevector_dc_alloc[Boolean,DenseVector[T]](inA, densevector_length(inA))
    var i = 0
    while (i < densevector_length(inA)) {
      densevector_update(out, i, func(densevector_apply(inA, i),densevector_apply(inB, i)))
      i += 1
    }
    out
  }

  def densevector_clnlt_impl2[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[DenseVector[Boolean]] = {
    def func: (Rep[T],Rep[T]) => Rep[Boolean] = (a,b) => a < b
    val inA = self
    val inB = __arg1
    val out = densevector_dc_alloc[Boolean,DenseVector[T]](inA, densevector_length(inA))
    var i = 0
    while (i < densevector_length(inA)) {
      densevector_update(out, i, func(densevector_apply(inA, i),densevector_apply(inB, i)))
      i += 1
    }
    out
  }

  def densevector___equal_impl12[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[Boolean] = {
    if (self.length != __arg1.length || self.isRow != __arg1.isRow) false
    else {
      val c = self.indices.count(i => self(i) != __arg1(i))
      c == 0
    }
  }

  def densevector___equal_impl13[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[Boolean] = {
    if (self.length != __arg1.length || self.isRow != __arg1.isRow) false
    else {
      val c = self.indices.count(i => self(i) != __arg1(i))
      c == 0
    }
  }

  def densevector___equal_impl14[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Boolean] = {
    if (self.length != __arg1.length || self.isRow != __arg1.isRow) false
    else {
      val c = self.indices.count(i => self(i) != __arg1(i))
      c == 0
    }
  }

  def densevector___equal_impl15[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Boolean] = {
    self == __arg1.toDense
  }

  def densevector_groupbyreduce_impl[T:Manifest,K:Manifest,V:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V],__arg3: (Rep[V],Rep[V]) => Rep[V])(implicit __pos: SourceContext,__imp0: Arith[V]): Rep[ForgeHashMap[K,V]] = {
    def key: Rep[T] => Rep[K] = e => __arg1(e)
    def map: Rep[T] => Rep[V] = e => __arg2(e)
    def reduce: (Rep[V],Rep[V]) => Rep[V] = (a,b) => __arg3(a,b)
    val in = self
    val out = SHashMap[K,V]()
    var i = 0
    while (i < densevector_length(in)) {
      val e = densevector_apply(in, i)
        val k = key(e)
        if (!out.contains(k)) {
          out(k) = map(e)
        }
        else {
          out(k) = reduce(out(k), map(e))
        }
      i += 1
    }
    fhashmap_from_shashmap(out)
  }

  def densevector_groupby_impl[T:Manifest,K:Manifest,V:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit __pos: SourceContext): Rep[ForgeHashMap[K,DenseVector[V]]] = {
    val hash = densevector_groupby_helper(self,__arg1,__arg2)
    val vals = fhashmap_values(hash).map(ab => densevector_fromarray(array_buffer_result(ab), true))
    fhashmap_from_arrays(fhashmap_keys(hash), vals)
  }

  def densevector_filter_impl3[T:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[DenseVector[T]] = {
    def func: Rep[T] => Rep[T] = e => e
    def cond: Rep[T] => Rep[Boolean] = e => __arg1(e)
    val in = self
    val out = densevector_dc_alloc[T,DenseVector[T]](in,0)
    var i = 0
    while (i < densevector_length(in)) {
      val e = densevector_apply(in, i)
      if (cond(e)) {
        densevector_append(out, i, func(e))
      }
      i += 1
    }
    out
  }

  def densevector_appendable_impl[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext): Rep[Boolean] = {
    true
  }

  def densevector_append_impl[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext): Rep[Unit] = {
    self.insert(self.length, __arg2)
  }

  def densevector_copy_impl[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]],__arg3: Rep[Int],__arg4: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    val src = densevector_raw_data(self)
    val dest = densevector_raw_data(__arg2)
    array_copy(src, __arg1, dest, __arg3, __arg4)
  }

  def densevector_toboolean_impl5[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Boolean]): Rep[DenseVector[Boolean]] = {
    self.map(conv)
  }

  def densevector_todouble_impl6[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]): Rep[DenseVector[Double]] = {
    self.map(conv)
  }

  def densevector_tofloat_impl6[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Float]): Rep[DenseVector[Float]] = {
    self.map(conv)
  }

  def densevector_toint_impl6[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Int]): Rep[DenseVector[Int]] = {
    self.map(conv)
  }

  def densevector_indices_impl6[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[IndexVector] = {
    IndexVector(unit(0), self.length, self.isRow)
  }

  def densevector_isempty_impl4[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[Boolean] = {
    self.length == 0
  }

  def densevector_first_impl4[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[T] = {
    self(0)
  }

  def densevector_last_impl4[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[T] = {
    self(self.length - 1)
  }

  def densevector_drop_impl4[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVector[T]] = {
    self.slice(__arg1, self.length)
  }

  def densevector_take_impl4[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVector[T]] = {
    self.slice(0, __arg1)
  }

  def densevector_contains_impl9[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext): Rep[Boolean] = {
    var found = false
    var i = 0
    while (i < self.length && !found) {
      if (self(i) == __arg1) {
        found = true
      }
      i += 1
    }
    found
  }

  def densevector_distinct_impl4[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[DenseVector[T]] = {
    val set = SHashMap[T,Int]()
    val out = DenseVector[T](0, self.isRow)
    for (i <- 0 until self.length) {
      if (!set.contains(self(i))) {
        set(self(i)) = 1
        out <<= self(i)
      }
    }
    out.unsafeImmutable
  }

  def densevector_mutable_impl15[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[DenseVector[T]] = {
    val out = DenseVector[T](self.length, self.isRow)
    for (i <- 0 until out.length) {
      out(i) = self(i)
    }
    out
  }

  def densevector_replicate_impl4[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext): Rep[DenseMatrix[T]] = {
    if (self.isRow) {
      val out = DenseMatrix[T](__arg1, __arg2*self.length)
      for (col <- 0 until __arg2*self.length){
        val colToJ = col % self.length
        for (rI <- 0 until __arg1) {
          out(rI, col) = self(colToJ)
        }
      }
      out.unsafeImmutable
    }
    else {
      val out = DenseMatrix[T](__arg1*self.length, __arg2)
      for (row <- 0 until __arg1*self.length){
        val rowToI = row % self.length
        for (cI <- 0 until __arg2) {
          out(row, cI) = self(rowToI)
        }
      }
      out.unsafeImmutable
    }
  }

  def densevector_makestring_impl6[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]): Rep[String] = {
    var s = ""
    if (self.length == 0) {
      s = "[ ]"
    }
    else if (self.isRow) {
      for (i <- 0 until self.length - 1) {
        s = s + optila_padspace(self(i).makeStr)
      }
      s = s + optila_padspace(self(self.length-1).makeStr)
    }
    else {
      for (i <- 0 until self.length - 1) {
        s = s + optila_padspace(self(i).makeStr) + "\n"
      }
      s = s + optila_padspace(self(self.length-1).makeStr)
    }
    s
  }

  def densevector_tostring_impl15[T:Manifest](self: Rep[DenseVector[T]]): Rep[String] = {
    var s = ""
    if (self.length == 0) {
      s = "[ ]"
    }
    else if (self.isRow) {
      for (i <- 0 until self.length - 1) {
        s = s + optila_padspace(optila_fmt_str(self(i)))
      }
      s = s + optila_padspace(optila_fmt_str(self(self.length-1)))
    }
    else {
      for (i <- 0 until self.length - 1) {
        s = s + optila_padspace(optila_fmt_str(self(i))) + "\n"
      }
      s = s + optila_padspace(optila_fmt_str(self(self.length-1)))
    }
    s
  }

  def densevector_pprint_impl6[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]): Rep[Unit] = {
    println(self.makeStr + "\n")
  }

  def densevector_pl_impl131[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.zip(__arg1) { (a,b) => a+b }
  }

  def densevector_sub_impl97[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.zip(__arg1) { (a,b) => a-b }
  }

  def densevector_mul_impl136[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.zip(__arg1) { (a,b) => a*b }
  }

  def densevector_mulclnmul_impl22[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T] = {
    fassert(self.length == __arg1.length, "dimension mismatch: vector dot product")
    sum(self*__arg1)
  }

  def densevector_mulmul_impl10[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]] = {
    fassert(!self.isRow && __arg1.isRow, "dimension mismatch: vector outer product")
    val out = DenseMatrix[T](self.length, __arg1.length)
    for (i <- 0 until self.length ){
      for (j <- 0 until __arg1.length ){
        out(i,j) = self(i)*__arg1(j)
      }
    }
    out.unsafeImmutable
  }

  def densevector_div_impl98[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.zip(__arg1) { (a,b) => a/b }
  }

  def densevector_pl_impl132[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.zip(__arg1) { (a,b) => a+b }
  }

  def densevector_sub_impl98[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.zip(__arg1) { (a,b) => a-b }
  }

  def densevector_mul_impl137[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.zip(__arg1) { (a,b) => a*b }
  }

  def densevector_dot_densevectorview_impl23[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T] = {
    fassert(self.length == __arg1.length, "dimension mismatch: vector dot product")
    sum(self*__arg1)
  }

  def densevector_mulmul_impl11[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]] = {
    fassert(!self.isRow && __arg1.isRow, "dimension mismatch: vector outer product")
    val out = DenseMatrix[T](self.length, __arg1.length)
    for (i <- 0 until self.length ){
      for (j <- 0 until __arg1.length ){
        out(i,j) = self(i)*__arg1(j)
      }
    }
    out.unsafeImmutable
  }

  def densevector_div_impl99[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.zip(__arg1) { (a,b) => a/b }
  }

  def densevector_pl_impl133[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self + __arg1.toDense
  }

  def densevector_sub_impl99[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self - __arg1.toDense
  }

  def densevector_mul_impl138[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self * __arg1.toDense
  }

  def densevector_mulclnmul_impl24[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T] = {
    self *:* __arg1.toDense
  }

  def densevector_mulmul_impl12[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]] = {
    self ** __arg1.toDense
  }

  def densevector_div_impl100[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self / __arg1.toDense
  }

  def densevector_pl_impl134[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self + __arg1.toDense
  }

  def densevector_sub_impl100[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self - __arg1.toDense
  }

  def densevector_mul_impl139[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self * __arg1.toDense
  }

  def densevector_mulclnmul_impl25[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T] = {
    self *:* __arg1.toDense
  }

  def densevector_mulmul_impl13[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]] = {
    self ** __arg1.toDense
  }

  def densevector_div_impl101[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self / __arg1.toDense
  }

  def densevector_zip_impl6[T:Manifest,B:Manifest,R:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]] = {
    def func: (Rep[T],Rep[B]) => Rep[R] = (a,b) => __arg2(a,b)
    val inA = self
    val inB = __arg1
    val out = densevector_dc_alloc[R,DenseVector[T]](inA, densevector_length(inA))
    var i = 0
    while (i < densevector_length(inA)) {
      densevector_update(out, i, func(densevector_apply(inA, i),densevector_apply(inB, i)))
      i += 1
    }
    out
  }

  def densevector_zip_impl7[T:Manifest,B:Manifest,R:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]] = {
    def func: (Rep[T],Rep[B]) => Rep[R] = (a,b) => __arg2(a,b)
    val inA = self
    val inB = __arg1
    val out = densevector_dc_alloc[R,DenseVector[T]](inA, densevector_length(inA))
    var i = 0
    while (i < densevector_length(inA)) {
      densevector_update(out, i, func(densevector_apply(inA, i),densevectorview_apply(inB, i)))
      i += 1
    }
    out
  }

  def densevector_pl_impl135[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.map(e => e+__arg1)
  }

  def densevector_sub_impl101[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.map(e => e-__arg1)
  }

  def densevector_mul_impl140[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.map(e => e*__arg1)
  }

  def densevector_mul_impl141[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    fassert(self.isRow, "dimension mismatch: vector * matrix")
    __arg1.mapColsToVector { col => self *:* col }
  }

  def densevector_div_impl102[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.map(e => e/__arg1)
  }

  def densevector_abs_impl21[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.map(e => e.abs)
  }

  def densevector_exp_impl20[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.map(e => e.exp)
  }

  def densevector_log_impl20[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.map(e => e.log)
  }

  def densevector_sum_impl5[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T] = {
    self.reduce((a,b) => a+b )
  }

  def densevector_prod_impl4[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T] = {
    def func: (Rep[T],Rep[T]) => Rep[T] = (a,b) => a*b
    def zero: Rep[T] = unit(1.asInstanceOf[T])
    val in = self
    var acc = if (densevector_length(in) == 0) zero else densevector_apply(in, 0)
    var i = 1
    while (i < densevector_length(in)) {
      acc =  func(acc, densevector_apply(in, i))
      i += 1
    }
    acc
  }

  def densevector_mean_impl5[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]): Rep[Double] = {
    self.map(conv).sum / self.length
  }

  def densevector_min_impl6[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[T] = {
    def func: (Rep[T],Rep[T]) => Rep[T] = (a,b) => if (a < b) a else b
    def zero: Rep[T] = self(0)
    val in = self
    var acc = if (densevector_length(in) == 0) zero else densevector_apply(in, 0)
    var i = 1
    while (i < densevector_length(in)) {
      acc =  func(acc, densevector_apply(in, i))
      i += 1
    }
    acc
  }

  def densevector_max_impl6[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[T] = {
    def func: (Rep[T],Rep[T]) => Rep[T] = (a,b) => if (a > b) a else b
    def zero: Rep[T] = self(0)
    val in = self
    var acc = if (densevector_length(in) == 0) zero else densevector_apply(in, 0)
    var i = 1
    while (i < densevector_length(in)) {
      acc =  func(acc, densevector_apply(in, i))
      i += 1
    }
    acc
  }

  def densevector_minindex_impl4[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp1: Arith[T]): Rep[Int] = {
    self.indices.reduce { (a,b) => if (self(a) < self(b)) a else b }
  }

  def densevector_maxindex_impl4[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp1: Arith[T]): Rep[Int] = {
    self.indices.reduce { (a,b) => if (self(a) > self(b)) a else b }
  }

  def densevector_map_impl4[T:Manifest,R:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]] = {
    def func: Rep[T] => Rep[R] = e => __arg1(e)
    val in = self
    val out = densevector_dc_alloc[R,DenseVector[T]](in, densevector_length(in))
    var i = 0
    while (i < densevector_length(in)) {
      densevector_update(out, i, func(densevector_apply(in, i)))
      i += 1
    }
    out
  }

  def densevector_reduce_impl3[T:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T] = {
    def func: (Rep[T],Rep[T]) => Rep[T] = (a,b) => __arg1(a,b)
    def zero: Rep[T] = implicitly[Arith[T]].zero(self(unit(0)))
    val in = self
    var acc = if (densevector_length(in) == 0) zero else densevector_apply(in, 0)
    var i = 1
    while (i < densevector_length(in)) {
      acc =  func(acc, densevector_apply(in, i))
      i += 1
    }
    acc
  }

  def densevector_foreach_impl5[T:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit] = {
    def func: Rep[T] => Rep[Unit] = e => __arg1(e)
    val in = self
    var i = 0
    while (i < densevector_length(in)) {
      func(densevector_apply(in, i))
      i += 1
    }
  }

  def densevector_find_impl3[T:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[IndexVector] = {
    IndexVector(self.indices.filter(i => __arg1(self(i))))
  }

  def densevector_densevector_filter_map_impl[T:Manifest,R:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[Boolean],__arg2: (Rep[T]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]] = {
    def func: Rep[T] => Rep[R] = e => __arg2(e)
    def cond: Rep[T] => Rep[Boolean] = e => __arg1(e)
    val in = self
    val out = densevector_dc_alloc[R,DenseVector[T]](in,0)
    var i = 0
    while (i < densevector_length(in)) {
      val e = densevector_apply(in, i)
      if (cond(e)) {
        densevector_append(out, i, func(e))
      }
      i += 1
    }
    out
  }

  def densevector_count_impl4[T:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[Int] = {
    val x = densevector_densevector_filter_map(self, __arg1, (e: Rep[T]) => 1)
    if (x.length > 0) sum(x)
    else 0
  }

  def densevector_partition_impl3[T:Manifest](self: Rep[DenseVector[T]],pred: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[Tup2[DenseVector[T],DenseVector[T]]] = {
    val outT = DenseVector[T](0, self.isRow)
    val outF = DenseVector[T](0, self.isRow)
    for (i <- 0 until self.length) {
      val x = self(i)
      if (pred(x)) outT <<= x
      else outF <<= x
    }
    pack((outT.unsafeImmutable, outF.unsafeImmutable))
  }

  def densevector_flatmap_impl3[T:Manifest,R:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[DenseVector[R]])(implicit __pos: SourceContext): Rep[DenseVector[R]] = {
    DenseVector.flatten(self.map(__arg1))
  }

  def densevector_scan_impl3[T:Manifest,R:Manifest](self: Rep[DenseVector[T]],zero: Rep[R],__arg2: (Rep[R],Rep[T]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]] = {
    val out = DenseVector[R](self.length, self.isRow)
    out(0) = __arg2(zero,self(0))
    var i = 1
    while (i < self.length) {
      out(i) = __arg2(out(i-1), self(i))
      i += 1
    }
    out.unsafeImmutable
  }

  def densevector_prefixsum_impl3[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.scan(implicitly[Arith[T]].zero(self(unit(0))))((a,b) => a+b)
  }

  def densevector_dist_impl4(__arg0: Rep[DenseVector[Double]],__arg1: Rep[DenseVector[Double]],__arg2: DistanceMetric)(implicit __pos: SourceContext): Rep[Double] = {
    __arg2 match {
      case ABS => sum(abs(__arg0 - __arg1))
      case SQUARE => sum(square(__arg0 - __arg1))
      case EUC => sqrt(sum(square(__arg0 - __arg1)))
    }
  }

}
