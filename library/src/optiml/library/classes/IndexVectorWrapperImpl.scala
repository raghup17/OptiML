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

trait IndexVectorWrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def indexvector_copyarray_impl(__arg0: Rep[DenseVector[Int]])(implicit __pos: SourceContext): Rep[ForgeArray[Int]] = {
    val d = array_empty[Int](__arg0.length)
    __arg0.indices foreach { i => d(i) = __arg0(i) }
    d.unsafeImmutable
  }

  def indexvector_length_impl2(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Int] = {
    if (indexvector_is_range(self)) {
      indexvector_end(self) - indexvector_start(self)
    }
    else {
      array_length(indexvector_raw_data(self))
    }
  }

  def indexvector_apply_impl5(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Int] = {
    if (indexvector_is_range(self)) {
      indexvector_start(self) + __arg1
    }
    else {
      indexvector_raw_data(self).apply(__arg1)
    }
  }

  def indexvector_slice_impl1(self: Rep[IndexVector],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext): Rep[IndexVector] = {
    if (indexvector_is_range(self)) {
      fassert(start >= indexvector_start(self) && end <= indexvector_end(self), "IndexVector slice (" + start + "," + end + ") out of bounds (" + indexvector_start(self) + "," + indexvector_end(self) + ")")
      IndexVector(start, end, self.isRow)
    }
    else {
      IndexVector(self.toDense.slice(start, end))
    }
  }

  def indexvector_clone_impl2(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[IndexVector] = {
    if (indexvector_is_range(self)) {
      IndexVector(indexvector_start(self),indexvector_end(self),self.isRow)
    }
    else {  
      indexvector_fromarray(array_clone(indexvector_raw_data(self)), self.isRow)
    }
  }

  def indexvector_todense_impl2(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    if (indexvector_is_range(self)) { self.map(e => e) }
    else {
      
      densevector_fromarray(indexvector_raw_data(self), self.isRow)
    }
  }

  def indexvector___equal_impl4(self: Rep[IndexVector],__arg1: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Boolean] = {
    self.toDense == __arg1
  }

  def indexvector___equal_impl5(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext): Rep[Boolean] = {
    __arg1 == self
  }

  def indexvector_filter_impl1(self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[IndexVector] = {
    IndexVector(self.toDense.filter(__arg1))
  }

  def indexvector_indextodense_impl(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    if (Settings.verbose > 0) println("(performance warning): automatic conversion from IndexVector to DenseVector")
    self.toDense
  }

  def indexvector_chainindextodenseops_impl(self: Rep[IndexVector])(implicit __pos: SourceContext): DenseVectorDenseVectorOpsCls[Int] = {
    repToDenseVectorDenseVectorOpsCls(indexToDense(self))
  }

  def indexvector_chainindextodenseintops_impl(self: Rep[IndexVector])(implicit __pos: SourceContext): DenseVectorDenseVectorIntOpsCls = {
    repToDenseVectorDenseVectorIntOpsCls(indexToDense(self))
  }

  def indexvector_illegalalloc_impl(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Nothing] = {
    fatal("IndexVectors cannot be allocated from a parallel op")
  }

  def indexvector_illegalupdate_impl(self: Rep[IndexVector],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext): Rep[Nothing] = {
    fatal("IndexVectors cannot be updated")
  }

  def zeroT_impl()(implicit __pos: SourceContext): Rep[Int] = {
    0.asInstanceOf[Int]
  }

  def indexvector_toboolean_impl1(self: Rep[IndexVector])(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Boolean]): Rep[DenseVector[Boolean]] = {
    self.map(conv)
  }

  def indexvector_todouble_impl2(self: Rep[IndexVector])(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Double]): Rep[DenseVector[Double]] = {
    self.map(conv)
  }

  def indexvector_tofloat_impl2(self: Rep[IndexVector])(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Float]): Rep[DenseVector[Float]] = {
    self.map(conv)
  }

  def indexvector_toint_impl2(self: Rep[IndexVector])(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Int]): Rep[DenseVector[Int]] = {
    self.map(conv)
  }

  def indexvector_indices_impl2(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[IndexVector] = {
    IndexVector(unit(0), self.length, self.isRow)
  }

  def indexvector_isempty_impl1(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Boolean] = {
    self.length == 0
  }

  def indexvector_first_impl1(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Int] = {
    self(0)
  }

  def indexvector_last_impl1(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Int] = {
    self(self.length - 1)
  }

  def indexvector_drop_impl1(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[IndexVector] = {
    self.slice(__arg1, self.length)
  }

  def indexvector_take_impl1(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[IndexVector] = {
    self.slice(0, __arg1)
  }

  def indexvector_contains_impl2(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Boolean] = {
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

  def indexvector_distinct_impl1(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    val set = SHashMap[Int,Int]()
    val out = DenseVector[Int](0, self.isRow)
    for (i <- 0 until self.length) {
      if (!set.contains(self(i))) {
        set(self(i)) = 1
        out <<= self(i)
      }
    }
    out.unsafeImmutable
  }

  def indexvector_mutable_impl3(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    val out = DenseVector[Int](self.length, self.isRow)
    for (i <- 0 until out.length) {
      out(i) = self(i)
    }
    out
  }

  def indexvector_replicate_impl1(self: Rep[IndexVector],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext): Rep[DenseMatrix[Int]] = {
    if (self.isRow) {
      val out = DenseMatrix[Int](__arg1, __arg2*self.length)
      for (col <- 0 until __arg2*self.length){
        val colToJ = col % self.length
        for (rI <- 0 until __arg1) {
          out(rI, col) = self(colToJ)
        }
      }
      out.unsafeImmutable
    }
    else {
      val out = DenseMatrix[Int](__arg1*self.length, __arg2)
      for (row <- 0 until __arg1*self.length){
        val rowToI = row % self.length
        for (cI <- 0 until __arg2) {
          out(row, cI) = self(rowToI)
        }
      }
      out.unsafeImmutable
    }
  }

  def indexvector_makestring_impl1(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[String] = {
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

  def indexvector_tostring_impl5(self: Rep[IndexVector]): Rep[String] = {
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

  def indexvector_pprint_impl1(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Unit] = {
    println(self.makeStr + "\n")
  }

  def indexvector_pl_impl33(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self.zip(__arg1) { (a,b) => a+b }
  }

  def indexvector_sub_impl33(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self.zip(__arg1) { (a,b) => a-b }
  }

  def indexvector_mul_impl33(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self.zip(__arg1) { (a,b) => a*b }
  }

  def indexvector_mulclnmul_impl1(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext): Rep[Int] = {
    fassert(self.length == __arg1.length, "dimension mismatch: vector dot product")
    sum(self*__arg1)
  }

  def indexvector_mulmul_impl1(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext): Rep[DenseMatrix[Int]] = {
    fassert(!self.isRow && __arg1.isRow, "dimension mismatch: vector outer product")
    val out = DenseMatrix[Int](self.length, __arg1.length)
    for (i <- 0 until self.length ){
      for (j <- 0 until __arg1.length ){
        out(i,j) = self(i)*__arg1(j)
      }
    }
    out.unsafeImmutable
  }

  def indexvector_div_impl34(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self.zip(__arg1) { (a,b) => a/b }
  }

  def indexvector_pl_impl34(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self.zip(__arg1) { (a,b) => a+b }
  }

  def indexvector_sub_impl34(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self.zip(__arg1) { (a,b) => a-b }
  }

  def indexvector_mul_impl34(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self.zip(__arg1) { (a,b) => a*b }
  }

  def indexvector_mulclnmul_impl2(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext): Rep[Int] = {
    fassert(self.length == __arg1.length, "dimension mismatch: vector dot product")
    sum(self*__arg1)
  }

  def indexvector_mulmul_impl2(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext): Rep[DenseMatrix[Int]] = {
    fassert(!self.isRow && __arg1.isRow, "dimension mismatch: vector outer product")
    val out = DenseMatrix[Int](self.length, __arg1.length)
    for (i <- 0 until self.length ){
      for (j <- 0 until __arg1.length ){
        out(i,j) = self(i)*__arg1(j)
      }
    }
    out.unsafeImmutable
  }

  def indexvector_div_impl35(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self.zip(__arg1) { (a,b) => a/b }
  }

  def indexvector_pl_impl35(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self + __arg1.toDense
  }

  def indexvector_sub_impl35(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self - __arg1.toDense
  }

  def indexvector_mul_impl35(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self * __arg1.toDense
  }

  def indexvector_mulclnmul_impl3(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext): Rep[Int] = {
    self *:* __arg1.toDense
  }

  def indexvector_mulmul_impl3(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext): Rep[DenseMatrix[Int]] = {
    self ** __arg1.toDense
  }

  def indexvector_div_impl36(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self / __arg1.toDense
  }

  def indexvector_pl_impl36(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self + __arg1.toDense
  }

  def indexvector_sub_impl36(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self - __arg1.toDense
  }

  def indexvector_mul_impl36(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self * __arg1.toDense
  }

  def indexvector_mulclnmul_impl4(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext): Rep[Int] = {
    self *:* __arg1.toDense
  }

  def indexvector_mulmul_impl4(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext): Rep[DenseMatrix[Int]] = {
    self ** __arg1.toDense
  }

  def indexvector_div_impl37(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self / __arg1.toDense
  }

  def indexvector_zip_impl1[B:Manifest,R:Manifest](self: Rep[IndexVector],__arg1: Rep[DenseVector[B]],__arg2: (Rep[Int],Rep[B]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]] = {
    def func: (Rep[Int],Rep[B]) => Rep[R] = (a,b) => __arg2(a,b)
    val inA = self
    val inB = __arg1
    val out = densevector_dc_alloc[R,IndexVector](inA, indexvector_length(inA))
    var i = 0
    while (i < indexvector_length(inA)) {
      densevector_update(out, i, func(indexvector_apply(inA, i),densevector_apply(inB, i)))
      i += 1
    }
    out
  }

  def indexvector_zip_impl2[B:Manifest,R:Manifest](self: Rep[IndexVector],__arg1: Rep[DenseVectorView[B]],__arg2: (Rep[Int],Rep[B]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]] = {
    def func: (Rep[Int],Rep[B]) => Rep[R] = (a,b) => __arg2(a,b)
    val inA = self
    val inB = __arg1
    val out = densevector_dc_alloc[R,IndexVector](inA, indexvector_length(inA))
    var i = 0
    while (i < indexvector_length(inA)) {
      densevector_update(out, i, func(indexvector_apply(inA, i),densevectorview_apply(inB, i)))
      i += 1
    }
    out
  }

  def indexvector_pl_impl37(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self.map(e => e+__arg1)
  }

  def indexvector_sub_impl37(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self.map(e => e-__arg1)
  }

  def indexvector_mul_impl37(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self.map(e => e*__arg1)
  }

  def indexvector_mul_impl38(self: Rep[IndexVector],__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    fassert(self.isRow, "dimension mismatch: vector * matrix")
    __arg1.mapColsToVector { col => self *:* col }
  }

  def indexvector_div_impl38(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self.map(e => e/__arg1)
  }

  def indexvector_abs_impl5(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self.map(e => e.abs)
  }

  def indexvector_exp_impl5(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self.map(e => e.exp)
  }

  def indexvector_log_impl5(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self.map(e => e.log)
  }

  def indexvector_sum_impl1(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Int] = {
    self.reduce((a,b) => a+b )
  }

  def indexvector_prod_impl1(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Int] = {
    def func: (Rep[Int],Rep[Int]) => Rep[Int] = (a,b) => a*b
    def zero: Rep[Int] = unit(1.asInstanceOf[Int])
    val in = self
    var acc = if (indexvector_length(in) == 0) zero else indexvector_apply(in, 0)
    var i = 1
    while (i < indexvector_length(in)) {
      acc =  func(acc, indexvector_apply(in, i))
      i += 1
    }
    acc
  }

  def indexvector_mean_impl1(self: Rep[IndexVector])(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Double]): Rep[Double] = {
    self.map(conv).sum / self.length
  }

  def indexvector_min_impl2(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Int] = {
    def func: (Rep[Int],Rep[Int]) => Rep[Int] = (a,b) => if (a < b) a else b
    def zero: Rep[Int] = self(0)
    val in = self
    var acc = if (indexvector_length(in) == 0) zero else indexvector_apply(in, 0)
    var i = 1
    while (i < indexvector_length(in)) {
      acc =  func(acc, indexvector_apply(in, i))
      i += 1
    }
    acc
  }

  def indexvector_max_impl2(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Int] = {
    def func: (Rep[Int],Rep[Int]) => Rep[Int] = (a,b) => if (a > b) a else b
    def zero: Rep[Int] = self(0)
    val in = self
    var acc = if (indexvector_length(in) == 0) zero else indexvector_apply(in, 0)
    var i = 1
    while (i < indexvector_length(in)) {
      acc =  func(acc, indexvector_apply(in, i))
      i += 1
    }
    acc
  }

  def indexvector_minindex_impl1(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Int] = {
    self.indices.reduce { (a,b) => if (self(a) < self(b)) a else b }
  }

  def indexvector_maxindex_impl1(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Int] = {
    self.indices.reduce { (a,b) => if (self(a) > self(b)) a else b }
  }

  def indexvector_map_impl1[R:Manifest](self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]] = {
    def func: Rep[Int] => Rep[R] = e => __arg1(e)
    val in = self
    val out = densevector_dc_alloc[R,IndexVector](in, indexvector_length(in))
    var i = 0
    while (i < indexvector_length(in)) {
      densevector_update(out, i, func(indexvector_apply(in, i)))
      i += 1
    }
    out
  }

  def indexvector_reduce_impl1(self: Rep[IndexVector],__arg1: (Rep[Int],Rep[Int]) => Rep[Int])(implicit __pos: SourceContext): Rep[Int] = {
    def func: (Rep[Int],Rep[Int]) => Rep[Int] = (a,b) => __arg1(a,b)
    def zero: Rep[Int] = zeroT
    val in = self
    var acc = if (indexvector_length(in) == 0) zero else indexvector_apply(in, 0)
    var i = 1
    while (i < indexvector_length(in)) {
      acc =  func(acc, indexvector_apply(in, i))
      i += 1
    }
    acc
  }

  def indexvector_foreach_impl1(self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit] = {
    def func: Rep[Int] => Rep[Unit] = e => __arg1(e)
    val in = self
    var i = 0
    while (i < indexvector_length(in)) {
      func(indexvector_apply(in, i))
      i += 1
    }
  }

  def indexvector_find_impl1(self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[IndexVector] = {
    IndexVector(self.indices.filter(i => __arg1(self(i))))
  }

  def indexvector_densevector_filter_map_impl[R:Manifest](self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[Boolean],__arg2: (Rep[Int]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]] = {
    def func: Rep[Int] => Rep[R] = e => __arg2(e)
    def cond: Rep[Int] => Rep[Boolean] = e => __arg1(e)
    val in = self
    val out = densevector_dc_alloc[R,IndexVector](in,0)
    var i = 0
    while (i < indexvector_length(in)) {
      val e = indexvector_apply(in, i)
      if (cond(e)) {
        densevector_append(out, i, func(e))
      }
      i += 1
    }
    out
  }

  def indexvector_count_impl1(self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[Int] = {
    val x = indexvector_densevector_filter_map(self, __arg1, (e: Rep[Int]) => 1)
    if (x.length > 0) sum(x)
    else 0
  }

  def indexvector_partition_impl1(self: Rep[IndexVector],pred: (Rep[Int]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[Tup2[DenseVector[Int],DenseVector[Int]]] = {
    val outT = DenseVector[Int](0, self.isRow)
    val outF = DenseVector[Int](0, self.isRow)
    for (i <- 0 until self.length) {
      val x = self(i)
      if (pred(x)) outT <<= x
      else outF <<= x
    }
    pack((outT.unsafeImmutable, outF.unsafeImmutable))
  }

  def indexvector_flatmap_impl1[R:Manifest](self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[DenseVector[R]])(implicit __pos: SourceContext): Rep[DenseVector[R]] = {
    DenseVector.flatten(self.map(__arg1))
  }

  def indexvector_scan_impl1[R:Manifest](self: Rep[IndexVector],zero: Rep[R],__arg2: (Rep[R],Rep[Int]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]] = {
    val out = DenseVector[R](self.length, self.isRow)
    out(0) = __arg2(zero,self(0))
    var i = 1
    while (i < self.length) {
      out(i) = __arg2(out(i-1), self(i))
      i += 1
    }
    out.unsafeImmutable
  }

  def indexvector_prefixsum_impl1(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    self.scan(zeroT)((a,b) => a+b)
  }

  def indexvector_clncln_impl(end: Rep[Int],start: Rep[Int]): Rep[IndexVector] = {
    IndexVector(start, end)
  }

  def indexvector_apply_impl6[T:Manifest](__arg0: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[T])(implicit __pos: SourceContext): Rep[DenseVector[T]] = {
    __arg0.map(__arg1)
  }

  def indexvector_apply_impl7[T:Manifest](__arg0: Tuple2[Rep[IndexVector],Rep[IndexVector]],__arg1: (Rep[Int],Rep[Int]) => Rep[T])(implicit __pos: SourceContext): Rep[DenseMatrix[T]] = {
    val (rowIndices,colIndices) = __arg0
    
    
    val v = (0::(rowIndices.length*colIndices.length)).toDense
    val indices = densematrix_fromarray(densevector_raw_data(v),rowIndices.length,colIndices.length)
    indices map { i =>
      val (rowIndex, colIndex) = unpack(matrix_shapeindex(i, colIndices.length))
      __arg1(rowIndices(rowIndex),colIndices(colIndex))
    }
  }

  def indexvector_apply_impl8[T:Manifest](__arg0: Tuple2[Rep[IndexVector],IndexWildcard],__arg1: (Rep[Int]) => Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[DenseMatrix[T]] = {
    val rowIndices = __arg0._1
    val first = __arg1(rowIndices(0)) 
    val out = DenseMatrix[T](rowIndices.length,first.length)
    (0::rowIndices.length) foreach { i =>
      out(i) = __arg1(rowIndices(i))
    }
    out.unsafeImmutable
  }

  def indexvector_apply_impl9[T:Manifest](__arg0: Tuple2[IndexWildcard,Rep[IndexVector]],__arg1: (Rep[Int]) => Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[DenseMatrix[T]] = {
    val colIndices = __arg0._2
    val first = __arg1(colIndices(0)) 
    val out = DenseMatrix[T](first.length, colIndices.length)
    (0::colIndices.length) foreach { j =>
      out.updateCol(j, __arg1(colIndices(j)))
    }
    out.unsafeImmutable
  }

}
