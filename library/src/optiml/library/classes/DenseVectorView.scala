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

trait DenseVectorViewWrapper {
  this: OptiMLBase with OptiMLClasses => 

class DenseVectorView[T:Manifest](___data: ForgeArray[T], ___start: Int, ___stride: Int, ___length: Int, ___isRow: Boolean) {
  var _data = ___data
  var _start = ___start
  var _stride = ___stride
  var _length = ___length
  var _isRow = ___isRow

  override def toString() = {
    val self = this
    densevectorview_tostring_impl11[T](self)
  }
}

  def densevectorview_object_apply[T:Manifest](__arg0: Rep[ForgeArray[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[Int],__arg4: Rep[Boolean])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    new DenseVectorView[T](__arg0,__arg1,__arg2,__arg3,__arg4)
  }
  def densevectorview_data[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    self._data
  }
  def densevectorview_start[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    self._start
  }
  def densevectorview_stride[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    self._stride
  }
  def densevectorview_length[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._length
  }
  def densevectorview_isrow[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._isRow
  }
  def densevectorview_apply[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densevectorview_apply_impl19[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_slice[T:Manifest](self: Rep[DenseVectorView[T]],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext) = {
    densevectorview_slice_impl4[T](self,start,end)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_todense[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    densevectorview_todense_impl4[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview___equal[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densevectorview___equal_impl9[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_viewtodense[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    densevectorview_viewtodense_impl[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_chainviewtodenseops[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    densevectorview_chainviewtodenseops_impl[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_illegalalloc[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densevectorview_illegalalloc_impl[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_illegalupdate[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext) = {
    densevectorview_illegalupdate_impl[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_toboolean[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Boolean]) = {
    densevectorview_toboolean_impl3[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densevectorview_todouble[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]) = {
    densevectorview_todouble_impl4[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densevectorview_tofloat[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Float]) = {
    densevectorview_tofloat_impl4[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densevectorview_toint[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Int]) = {
    densevectorview_toint_impl4[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densevectorview_indices[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    densevectorview_indices_impl4[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_isempty[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    densevectorview_isempty_impl3[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_first[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    densevectorview_first_impl3[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_last[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    densevectorview_last_impl3[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_drop[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densevectorview_drop_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_take[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densevectorview_take_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_contains[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext) = {
    densevectorview_contains_impl7[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_distinct[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    densevectorview_distinct_impl3[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_mutable[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    densevectorview_mutable_impl12[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_replicate[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext) = {
    densevectorview_replicate_impl2[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_makestring[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]) = {
    densevectorview_makestring_impl4[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_tostring[T:Manifest](self: Rep[DenseVectorView[T]]) = {
    densevectorview_tostring_impl11[T](self)
  }
  def densevectorview_pprint[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]) = {
    densevectorview_pprint_impl4[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_pl[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload63) = {
    densevectorview_pl_impl63[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_sub[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload47) = {
    densevectorview_sub_impl47[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload49) = {
    densevectorview_mul_impl49[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mulclnmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload7) = {
    densevectorview_mulclnmul_impl7[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mulmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload6) = {
    densevectorview_mulmul_impl6[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_div[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload48) = {
    densevectorview_div_impl48[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_pl[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload64) = {
    densevectorview_pl_impl64[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_sub[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload48) = {
    densevectorview_sub_impl48[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload50) = {
    densevectorview_mul_impl50[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mulclnmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload8) = {
    densevectorview_mulclnmul_impl8[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mulmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload7) = {
    densevectorview_mulmul_impl7[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_div[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload49) = {
    densevectorview_div_impl49[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_pl[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload65) = {
    densevectorview_pl_impl65[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_sub[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload49) = {
    densevectorview_sub_impl49[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload51) = {
    densevectorview_mul_impl51[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mulclnmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload9) = {
    densevectorview_mulclnmul_impl9[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mulmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload8) = {
    densevectorview_mulmul_impl8[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_div[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload50) = {
    densevectorview_div_impl50[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_pl[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload66) = {
    densevectorview_pl_impl66[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_sub[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload50) = {
    densevectorview_sub_impl50[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload52) = {
    densevectorview_mul_impl52[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mulclnmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload10) = {
    densevectorview_mulclnmul_impl10[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mulmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload9) = {
    densevectorview_mulmul_impl9[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_div[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload51) = {
    densevectorview_div_impl51[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_zip[T:Manifest,B:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload3) = {
    densevectorview_zip_impl3[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos)
  }
  def densevectorview_zip[T:Manifest,B:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload4) = {
    densevectorview_zip_impl4[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos)
  }
  def densevectorview_pl[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload67) = {
    densevectorview_pl_impl67[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_sub[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload51) = {
    densevectorview_sub_impl51[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload53) = {
    densevectorview_mul_impl53[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload54) = {
    densevectorview_mul_impl54[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_div[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload52) = {
    densevectorview_div_impl52[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_abs[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevectorview_abs_impl13[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_exp[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevectorview_exp_impl12[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_log[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevectorview_log_impl12[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_sum[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevectorview_sum_impl3[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_prod[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevectorview_prod_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mean[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]) = {
    densevectorview_mean_impl3[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densevectorview_min[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    densevectorview_min_impl4[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_max[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    densevectorview_max_impl4[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_minindex[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp1: Arith[T]) = {
    densevectorview_minindex_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0,__imp1)
  }
  def densevectorview_maxindex[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp1: Arith[T]) = {
    densevectorview_maxindex_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0,__imp1)
  }
  def densevectorview_map[T:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext) = {
    densevectorview_map_impl2[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def densevectorview_reduce[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevectorview_reduce_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_foreach[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext) = {
    densevectorview_foreach_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_find[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    densevectorview_find_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_densevector_filter_map[T:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[Boolean],__arg2: (Rep[T]) => Rep[R])(implicit __pos: SourceContext) = {
    densevectorview_densevector_filter_map_impl[T,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def densevectorview_count[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    densevectorview_count_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_partition[T:Manifest](self: Rep[DenseVectorView[T]],pred: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    densevectorview_partition_impl2[T](self,pred)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_flatmap[T:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[DenseVector[R]])(implicit __pos: SourceContext) = {
    densevectorview_flatmap_impl2[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def densevectorview_scan[T:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],zero: Rep[R],__arg2: (Rep[R],Rep[T]) => Rep[R])(implicit __pos: SourceContext) = {
    densevectorview_scan_impl2[T,R](self,zero,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def densevectorview_prefixsum[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevectorview_prefixsum_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_dist(__arg0: Rep[DenseVectorView[Double]],__arg1: Rep[DenseVectorView[Double]],__arg2: DistanceMetric)(implicit __pos: SourceContext) = {
    densevectorview_dist_impl2(__arg0,__arg1,__arg2)(__pos)
  }

}

