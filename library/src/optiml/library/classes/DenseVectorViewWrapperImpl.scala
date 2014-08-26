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

trait DenseVectorViewWrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def densevectorview_apply_impl19[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[T] = {
    array_apply(densevectorview_data(self), densevectorview_start(self) + __arg1*densevectorview_stride(self))
  }

  def densevectorview_slice_impl4[T:Manifest](self: Rep[DenseVectorView[T]],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVectorView[T]] = {
    DenseVectorView(densevectorview_data(self), densevectorview_start(self)+start*densevectorview_stride(self), densevectorview_stride(self), end-start, self.isRow)
  }

  def densevectorview_todense_impl4[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[DenseVector[T]] = {
    self.map(e => e)
  }

  def densevectorview___equal_impl9[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[Boolean] = {
    __arg1 == self
  }

  def densevectorview_viewtodense_impl[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[DenseVector[T]] = {
    if (Settings.verbose > 0) println("(performance warning): automatic conversion from DenseVectorView to DenseVector")
    
    self.toDense
  }

  def densevectorview_chainviewtodenseops_impl[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): DenseVectorDenseVectorOpsCls[T] = {
    repToDenseVectorDenseVectorOpsCls(viewToDense(self))
  }

  def densevectorview_illegalalloc_impl[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Nothing] = {
    fatal("DenseVectorViews cannot be allocated from a parallel op")
  }

  def densevectorview_illegalupdate_impl[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext): Rep[Nothing] = {
    fatal("DenseVectorViews cannot be updated")
  }

  def densevectorview_toboolean_impl3[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Boolean]): Rep[DenseVector[Boolean]] = {
    self.map(conv)
  }

  def densevectorview_todouble_impl4[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]): Rep[DenseVector[Double]] = {
    self.map(conv)
  }

  def densevectorview_tofloat_impl4[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Float]): Rep[DenseVector[Float]] = {
    self.map(conv)
  }

  def densevectorview_toint_impl4[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Int]): Rep[DenseVector[Int]] = {
    self.map(conv)
  }

  def densevectorview_indices_impl4[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[IndexVector] = {
    IndexVector(unit(0), self.length, self.isRow)
  }

  def densevectorview_isempty_impl3[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[Boolean] = {
    self.length == 0
  }

  def densevectorview_first_impl3[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[T] = {
    self(0)
  }

  def densevectorview_last_impl3[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[T] = {
    self(self.length - 1)
  }

  def densevectorview_drop_impl3[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVectorView[T]] = {
    self.slice(__arg1, self.length)
  }

  def densevectorview_take_impl3[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVectorView[T]] = {
    self.slice(0, __arg1)
  }

  def densevectorview_contains_impl7[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext): Rep[Boolean] = {
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

  def densevectorview_distinct_impl3[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[DenseVector[T]] = {
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

  def densevectorview_mutable_impl12[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[DenseVector[T]] = {
    val out = DenseVector[T](self.length, self.isRow)
    for (i <- 0 until out.length) {
      out(i) = self(i)
    }
    out
  }

  def densevectorview_replicate_impl2[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext): Rep[DenseMatrix[T]] = {
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

  def densevectorview_makestring_impl4[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]): Rep[String] = {
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

  def densevectorview_tostring_impl11[T:Manifest](self: Rep[DenseVectorView[T]]): Rep[String] = {
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

  def densevectorview_pprint_impl4[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]): Rep[Unit] = {
    println(self.makeStr + "\n")
  }

  def densevectorview_pl_impl63[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.zip(__arg1) { (a,b) => a+b }
  }

  def densevectorview_sub_impl47[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.zip(__arg1) { (a,b) => a-b }
  }

  def densevectorview_mul_impl49[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.zip(__arg1) { (a,b) => a*b }
  }

  def densevectorview_mulclnmul_impl7[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T] = {
    fassert(self.length == __arg1.length, "dimension mismatch: vector dot product")
    sum(self*__arg1)
  }

  def densevectorview_mulmul_impl6[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]] = {
    fassert(!self.isRow && __arg1.isRow, "dimension mismatch: vector outer product")
    val out = DenseMatrix[T](self.length, __arg1.length)
    for (i <- 0 until self.length ){
      for (j <- 0 until __arg1.length ){
        out(i,j) = self(i)*__arg1(j)
      }
    }
    out.unsafeImmutable
  }

  def densevectorview_div_impl48[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.zip(__arg1) { (a,b) => a/b }
  }

  def densevectorview_pl_impl64[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.zip(__arg1) { (a,b) => a+b }
  }

  def densevectorview_sub_impl48[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.zip(__arg1) { (a,b) => a-b }
  }

  def densevectorview_mul_impl50[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.zip(__arg1) { (a,b) => a*b }
  }

  def densevectorview_mulclnmul_impl8[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T] = {
    fassert(self.length == __arg1.length, "dimension mismatch: vector dot product")
    sum(self*__arg1)
  }

  def densevectorview_mulmul_impl7[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]] = {
    fassert(!self.isRow && __arg1.isRow, "dimension mismatch: vector outer product")
    val out = DenseMatrix[T](self.length, __arg1.length)
    for (i <- 0 until self.length ){
      for (j <- 0 until __arg1.length ){
        out(i,j) = self(i)*__arg1(j)
      }
    }
    out.unsafeImmutable
  }

  def densevectorview_div_impl49[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.zip(__arg1) { (a,b) => a/b }
  }

  def densevectorview_pl_impl65[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self + __arg1.toDense
  }

  def densevectorview_sub_impl49[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self - __arg1.toDense
  }

  def densevectorview_mul_impl51[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self * __arg1.toDense
  }

  def densevectorview_mulclnmul_impl9[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T] = {
    self *:* __arg1.toDense
  }

  def densevectorview_mulmul_impl8[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]] = {
    self ** __arg1.toDense
  }

  def densevectorview_div_impl50[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self / __arg1.toDense
  }

  def densevectorview_pl_impl66[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self + __arg1.toDense
  }

  def densevectorview_sub_impl50[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self - __arg1.toDense
  }

  def densevectorview_mul_impl52[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self * __arg1.toDense
  }

  def densevectorview_mulclnmul_impl10[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T] = {
    self *:* __arg1.toDense
  }

  def densevectorview_mulmul_impl9[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]] = {
    self ** __arg1.toDense
  }

  def densevectorview_div_impl51[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self / __arg1.toDense
  }

  def densevectorview_zip_impl3[T:Manifest,B:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]] = {
    def func: (Rep[T],Rep[B]) => Rep[R] = (a,b) => __arg2(a,b)
    val inA = self
    val inB = __arg1
    val out = densevector_dc_alloc[R,DenseVectorView[T]](inA, densevectorview_length(inA))
    var i = 0
    while (i < densevectorview_length(inA)) {
      densevector_update(out, i, func(densevectorview_apply(inA, i),densevector_apply(inB, i)))
      i += 1
    }
    out
  }

  def densevectorview_zip_impl4[T:Manifest,B:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]] = {
    def func: (Rep[T],Rep[B]) => Rep[R] = (a,b) => __arg2(a,b)
    val inA = self
    val inB = __arg1
    val out = densevector_dc_alloc[R,DenseVectorView[T]](inA, densevectorview_length(inA))
    var i = 0
    while (i < densevectorview_length(inA)) {
      densevector_update(out, i, func(densevectorview_apply(inA, i),densevectorview_apply(inB, i)))
      i += 1
    }
    out
  }

  def densevectorview_pl_impl67[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.map(e => e+__arg1)
  }

  def densevectorview_sub_impl51[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.map(e => e-__arg1)
  }

  def densevectorview_mul_impl53[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.map(e => e*__arg1)
  }

  def densevectorview_mul_impl54[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    fassert(self.isRow, "dimension mismatch: vector * matrix")
    __arg1.mapColsToVector { col => self *:* col }
  }

  def densevectorview_div_impl52[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.map(e => e/__arg1)
  }

  def densevectorview_abs_impl13[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.map(e => e.abs)
  }

  def densevectorview_exp_impl12[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.map(e => e.exp)
  }

  def densevectorview_log_impl12[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.map(e => e.log)
  }

  def densevectorview_sum_impl3[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T] = {
    self.reduce((a,b) => a+b )
  }

  def densevectorview_prod_impl2[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T] = {
    def func: (Rep[T],Rep[T]) => Rep[T] = (a,b) => a*b
    def zero: Rep[T] = unit(1.asInstanceOf[T])
    val in = self
    var acc = if (densevectorview_length(in) == 0) zero else densevectorview_apply(in, 0)
    var i = 1
    while (i < densevectorview_length(in)) {
      acc =  func(acc, densevectorview_apply(in, i))
      i += 1
    }
    acc
  }

  def densevectorview_mean_impl3[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]): Rep[Double] = {
    self.map(conv).sum / self.length
  }

  def densevectorview_min_impl4[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[T] = {
    def func: (Rep[T],Rep[T]) => Rep[T] = (a,b) => if (a < b) a else b
    def zero: Rep[T] = self(0)
    val in = self
    var acc = if (densevectorview_length(in) == 0) zero else densevectorview_apply(in, 0)
    var i = 1
    while (i < densevectorview_length(in)) {
      acc =  func(acc, densevectorview_apply(in, i))
      i += 1
    }
    acc
  }

  def densevectorview_max_impl4[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[T] = {
    def func: (Rep[T],Rep[T]) => Rep[T] = (a,b) => if (a > b) a else b
    def zero: Rep[T] = self(0)
    val in = self
    var acc = if (densevectorview_length(in) == 0) zero else densevectorview_apply(in, 0)
    var i = 1
    while (i < densevectorview_length(in)) {
      acc =  func(acc, densevectorview_apply(in, i))
      i += 1
    }
    acc
  }

  def densevectorview_minindex_impl2[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp1: Arith[T]): Rep[Int] = {
    self.indices.reduce { (a,b) => if (self(a) < self(b)) a else b }
  }

  def densevectorview_maxindex_impl2[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp1: Arith[T]): Rep[Int] = {
    self.indices.reduce { (a,b) => if (self(a) > self(b)) a else b }
  }

  def densevectorview_map_impl2[T:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]] = {
    def func: Rep[T] => Rep[R] = e => __arg1(e)
    val in = self
    val out = densevector_dc_alloc[R,DenseVectorView[T]](in, densevectorview_length(in))
    var i = 0
    while (i < densevectorview_length(in)) {
      densevector_update(out, i, func(densevectorview_apply(in, i)))
      i += 1
    }
    out
  }

  def densevectorview_reduce_impl2[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T] = {
    def func: (Rep[T],Rep[T]) => Rep[T] = (a,b) => __arg1(a,b)
    def zero: Rep[T] = implicitly[Arith[T]].zero(self(unit(0)))
    val in = self
    var acc = if (densevectorview_length(in) == 0) zero else densevectorview_apply(in, 0)
    var i = 1
    while (i < densevectorview_length(in)) {
      acc =  func(acc, densevectorview_apply(in, i))
      i += 1
    }
    acc
  }

  def densevectorview_foreach_impl3[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit] = {
    def func: Rep[T] => Rep[Unit] = e => __arg1(e)
    val in = self
    var i = 0
    while (i < densevectorview_length(in)) {
      func(densevectorview_apply(in, i))
      i += 1
    }
  }

  def densevectorview_find_impl2[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[IndexVector] = {
    IndexVector(self.indices.filter(i => __arg1(self(i))))
  }

  def densevectorview_densevector_filter_map_impl[T:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[Boolean],__arg2: (Rep[T]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]] = {
    def func: Rep[T] => Rep[R] = e => __arg2(e)
    def cond: Rep[T] => Rep[Boolean] = e => __arg1(e)
    val in = self
    val out = densevector_dc_alloc[R,DenseVectorView[T]](in,0)
    var i = 0
    while (i < densevectorview_length(in)) {
      val e = densevectorview_apply(in, i)
      if (cond(e)) {
        densevector_append(out, i, func(e))
      }
      i += 1
    }
    out
  }

  def densevectorview_count_impl2[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[Int] = {
    val x = densevectorview_densevector_filter_map(self, __arg1, (e: Rep[T]) => 1)
    if (x.length > 0) sum(x)
    else 0
  }

  def densevectorview_partition_impl2[T:Manifest](self: Rep[DenseVectorView[T]],pred: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[Tup2[DenseVector[T],DenseVector[T]]] = {
    val outT = DenseVector[T](0, self.isRow)
    val outF = DenseVector[T](0, self.isRow)
    for (i <- 0 until self.length) {
      val x = self(i)
      if (pred(x)) outT <<= x
      else outF <<= x
    }
    pack((outT.unsafeImmutable, outF.unsafeImmutable))
  }

  def densevectorview_flatmap_impl2[T:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[DenseVector[R]])(implicit __pos: SourceContext): Rep[DenseVector[R]] = {
    DenseVector.flatten(self.map(__arg1))
  }

  def densevectorview_scan_impl2[T:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],zero: Rep[R],__arg2: (Rep[R],Rep[T]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]] = {
    val out = DenseVector[R](self.length, self.isRow)
    out(0) = __arg2(zero,self(0))
    var i = 1
    while (i < self.length) {
      out(i) = __arg2(out(i-1), self(i))
      i += 1
    }
    out.unsafeImmutable
  }

  def densevectorview_prefixsum_impl2[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]] = {
    self.scan(implicitly[Arith[T]].zero(self(unit(0))))((a,b) => a+b)
  }

  def densevectorview_dist_impl2(__arg0: Rep[DenseVectorView[Double]],__arg1: Rep[DenseVectorView[Double]],__arg2: DistanceMetric)(implicit __pos: SourceContext): Rep[Double] = {
    __arg2 match {
      case ABS => sum(abs(__arg0 - __arg1))
      case SQUARE => sum(square(__arg0 - __arg1))
      case EUC => sqrt(sum(square(__arg0 - __arg1)))
    }
  }

}
