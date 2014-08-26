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

trait IndexVectorWrapper {
  this: OptiMLBase with OptiMLClasses => 

class IndexVector(___data: ForgeArray[Int], ___start: Int, ___end: Int, ___isRow: Boolean, ___isRange: Boolean) {
  var _data = ___data
  var _start = ___start
  var _end = ___end
  var _isRow = ___isRow
  var _isRange = ___isRange

  override def toString() = {
    val self = this
    indexvector_tostring_impl5(self)
  }
}

  def indexvector_object_apply(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload7) = {
    def __imp1 = ()
    new IndexVector(array_empty_imm[Int](unit(0)),__arg0,__arg1,__arg2,unit(true))
  }
  def indexvector_object_apply(__arg0: Rep[DenseVector[Int]],__arg1: Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload9) = {
    def __imp1 = ()
    new IndexVector(indexvector_copyarray(__arg0),unit(0),unit(0),__arg1,unit(false))
  }
  def indexvector_fromarray(__arg0: Rep[ForgeArray[Int]],__arg1: Rep[Boolean])(implicit __pos: SourceContext) = {
    new IndexVector(__arg0,unit(0),unit(0),__arg1,unit(false))
  }
  def indexvector_copyarray(__arg0: Rep[DenseVector[Int]])(implicit __pos: SourceContext) = {
    indexvector_copyarray_impl(__arg0)(__pos)
  }
  def indexvector_start(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    self._start
  }
  def indexvector_end(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    self._end
  }
  def indexvector_raw_data(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    self._data
  }
  def indexvector_is_range(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    self._isRange
  }
  def indexvector_length(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_length_impl2(self)(__pos)
  }
  def indexvector_isrow(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._isRow
  }
  def indexvector_apply(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload5) = {
    indexvector_apply_impl5(self,__arg1)(__pos)
  }
  def indexvector_slice(self: Rep[IndexVector],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext) = {
    indexvector_slice_impl1(self,start,end)(__pos)
  }
  def indexvector_t(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    new IndexVector(indexvector_raw_data(self),indexvector_start(self),indexvector_end(self),!(indexvector_isrow(self)),indexvector_is_range(self))
  }
  def indexvector_clone(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_clone_impl2(self)(__pos)
  }
  def indexvector_todense(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_todense_impl2(self)(__pos)
  }
  def indexvector___equal(self: Rep[IndexVector],__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload4) = {
    indexvector___equal_impl4(self,__arg1)(__pos)
  }
  def indexvector___equal(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload5) = {
    indexvector___equal_impl5(self,__arg1)(__pos)
  }
  def indexvector_filter(self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    indexvector_filter_impl1(self,__arg1)(__pos)
  }
  def indexvector_indextodense(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_indextodense_impl(self)(__pos)
  }
  def indexvector_chainindextodenseops(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_chainindextodenseops_impl(self)(__pos)
  }
  def indexvector_chainindextodenseintops(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_chainindextodenseintops_impl(self)(__pos)
  }
  def indexvector_illegalalloc(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    indexvector_illegalalloc_impl(self,__arg1)(__pos)
  }
  def indexvector_illegalupdate(self: Rep[IndexVector],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext) = {
    indexvector_illegalupdate_impl(self,__arg1,__arg2)(__pos)
  }
  def zeroT()(implicit __pos: SourceContext) = {
    zeroT_impl()(__pos)
  }
  def indexvector_toboolean(self: Rep[IndexVector])(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Boolean]) = {
    indexvector_toboolean_impl1(self)(__pos,conv)
  }
  def indexvector_todouble(self: Rep[IndexVector])(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Double]) = {
    indexvector_todouble_impl2(self)(__pos,conv)
  }
  def indexvector_tofloat(self: Rep[IndexVector])(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Float]) = {
    indexvector_tofloat_impl2(self)(__pos,conv)
  }
  def indexvector_toint(self: Rep[IndexVector])(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Int]) = {
    indexvector_toint_impl2(self)(__pos,conv)
  }
  def indexvector_indices(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_indices_impl2(self)(__pos)
  }
  def indexvector_isempty(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_isempty_impl1(self)(__pos)
  }
  def indexvector_first(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_first_impl1(self)(__pos)
  }
  def indexvector_last(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_last_impl1(self)(__pos)
  }
  def indexvector_drop(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    indexvector_drop_impl1(self,__arg1)(__pos)
  }
  def indexvector_take(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    indexvector_take_impl1(self,__arg1)(__pos)
  }
  def indexvector_contains(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    indexvector_contains_impl2(self,__arg1)(__pos)
  }
  def indexvector_distinct(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_distinct_impl1(self)(__pos)
  }
  def indexvector_mutable(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_mutable_impl3(self)(__pos)
  }
  def indexvector_replicate(self: Rep[IndexVector],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext) = {
    indexvector_replicate_impl1(self,__arg1,__arg2)(__pos)
  }
  def indexvector_makestring(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_makestring_impl1(self)(__pos)
  }
  def indexvector_tostring(self: Rep[IndexVector]) = {
    indexvector_tostring_impl5(self)
  }
  def indexvector_pprint(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_pprint_impl1(self)(__pos)
  }
  def indexvector_pl(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload33) = {
    indexvector_pl_impl33(self,__arg1)(__pos)
  }
  def indexvector_sub(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload33) = {
    indexvector_sub_impl33(self,__arg1)(__pos)
  }
  def indexvector_mul(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload33) = {
    indexvector_mul_impl33(self,__arg1)(__pos)
  }
  def indexvector_mulclnmul(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload1) = {
    indexvector_mulclnmul_impl1(self,__arg1)(__pos)
  }
  def indexvector_mulmul(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload1) = {
    indexvector_mulmul_impl1(self,__arg1)(__pos)
  }
  def indexvector_div(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload34) = {
    indexvector_div_impl34(self,__arg1)(__pos)
  }
  def indexvector_pl(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload34) = {
    indexvector_pl_impl34(self,__arg1)(__pos)
  }
  def indexvector_sub(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload34) = {
    indexvector_sub_impl34(self,__arg1)(__pos)
  }
  def indexvector_mul(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload34) = {
    indexvector_mul_impl34(self,__arg1)(__pos)
  }
  def indexvector_mulclnmul(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload2) = {
    indexvector_mulclnmul_impl2(self,__arg1)(__pos)
  }
  def indexvector_mulmul(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload2) = {
    indexvector_mulmul_impl2(self,__arg1)(__pos)
  }
  def indexvector_div(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload35) = {
    indexvector_div_impl35(self,__arg1)(__pos)
  }
  def indexvector_pl(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload35) = {
    indexvector_pl_impl35(self,__arg1)(__pos)
  }
  def indexvector_sub(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload35) = {
    indexvector_sub_impl35(self,__arg1)(__pos)
  }
  def indexvector_mul(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload35) = {
    indexvector_mul_impl35(self,__arg1)(__pos)
  }
  def indexvector_mulclnmul(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload3) = {
    indexvector_mulclnmul_impl3(self,__arg1)(__pos)
  }
  def indexvector_mulmul(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload3) = {
    indexvector_mulmul_impl3(self,__arg1)(__pos)
  }
  def indexvector_div(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload36) = {
    indexvector_div_impl36(self,__arg1)(__pos)
  }
  def indexvector_pl(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload36) = {
    indexvector_pl_impl36(self,__arg1)(__pos)
  }
  def indexvector_sub(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload36) = {
    indexvector_sub_impl36(self,__arg1)(__pos)
  }
  def indexvector_mul(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload36) = {
    indexvector_mul_impl36(self,__arg1)(__pos)
  }
  def indexvector_mulclnmul(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload4) = {
    indexvector_mulclnmul_impl4(self,__arg1)(__pos)
  }
  def indexvector_mulmul(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload4) = {
    indexvector_mulmul_impl4(self,__arg1)(__pos)
  }
  def indexvector_div(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload37) = {
    indexvector_div_impl37(self,__arg1)(__pos)
  }
  def indexvector_zip[B:Manifest,R:Manifest](self: Rep[IndexVector],__arg1: Rep[DenseVector[B]],__arg2: (Rep[Int],Rep[B]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload1) = {
    indexvector_zip_impl1[B,R](self,__arg1,__arg2)(implicitly[Manifest[B]],implicitly[Manifest[R]],__pos)
  }
  def indexvector_zip[B:Manifest,R:Manifest](self: Rep[IndexVector],__arg1: Rep[DenseVectorView[B]],__arg2: (Rep[Int],Rep[B]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload2) = {
    indexvector_zip_impl2[B,R](self,__arg1,__arg2)(implicitly[Manifest[B]],implicitly[Manifest[R]],__pos)
  }
  def indexvector_pl(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload37) = {
    indexvector_pl_impl37(self,__arg1)(__pos)
  }
  def indexvector_sub(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload37) = {
    indexvector_sub_impl37(self,__arg1)(__pos)
  }
  def indexvector_mul(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload37) = {
    indexvector_mul_impl37(self,__arg1)(__pos)
  }
  def indexvector_mul(self: Rep[IndexVector],__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: Overload38) = {
    indexvector_mul_impl38(self,__arg1)(__pos)
  }
  def indexvector_div(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload38) = {
    indexvector_div_impl38(self,__arg1)(__pos)
  }
  def indexvector_abs(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_abs_impl5(self)(__pos)
  }
  def indexvector_exp(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_exp_impl5(self)(__pos)
  }
  def indexvector_log(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_log_impl5(self)(__pos)
  }
  def indexvector_sum(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_sum_impl1(self)(__pos)
  }
  def indexvector_prod(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_prod_impl1(self)(__pos)
  }
  def indexvector_mean(self: Rep[IndexVector])(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Double]) = {
    indexvector_mean_impl1(self)(__pos,conv)
  }
  def indexvector_min(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_min_impl2(self)(__pos)
  }
  def indexvector_max(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_max_impl2(self)(__pos)
  }
  def indexvector_minindex(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_minindex_impl1(self)(__pos)
  }
  def indexvector_maxindex(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_maxindex_impl1(self)(__pos)
  }
  def indexvector_map[R:Manifest](self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[R])(implicit __pos: SourceContext) = {
    indexvector_map_impl1[R](self,__arg1)(implicitly[Manifest[R]],__pos)
  }
  def indexvector_reduce(self: Rep[IndexVector],__arg1: (Rep[Int],Rep[Int]) => Rep[Int])(implicit __pos: SourceContext) = {
    indexvector_reduce_impl1(self,__arg1)(__pos)
  }
  def indexvector_foreach(self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[Unit])(implicit __pos: SourceContext) = {
    indexvector_foreach_impl1(self,__arg1)(__pos)
  }
  def indexvector_find(self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    indexvector_find_impl1(self,__arg1)(__pos)
  }
  def indexvector_densevector_filter_map[R:Manifest](self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[Boolean],__arg2: (Rep[Int]) => Rep[R])(implicit __pos: SourceContext) = {
    indexvector_densevector_filter_map_impl[R](self,__arg1,__arg2)(implicitly[Manifest[R]],__pos)
  }
  def indexvector_count(self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    indexvector_count_impl1(self,__arg1)(__pos)
  }
  def indexvector_partition(self: Rep[IndexVector],pred: (Rep[Int]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    indexvector_partition_impl1(self,pred)(__pos)
  }
  def indexvector_flatmap[R:Manifest](self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[DenseVector[R]])(implicit __pos: SourceContext) = {
    indexvector_flatmap_impl1[R](self,__arg1)(implicitly[Manifest[R]],__pos)
  }
  def indexvector_scan[R:Manifest](self: Rep[IndexVector],zero: Rep[R],__arg2: (Rep[R],Rep[Int]) => Rep[R])(implicit __pos: SourceContext) = {
    indexvector_scan_impl1[R](self,zero,__arg2)(implicitly[Manifest[R]],__pos)
  }
  def indexvector_prefixsum(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_prefixsum_impl1(self)(__pos)
  }
  def indexvector_clncln(end: Rep[Int],start: Rep[Int]) = {
    indexvector_clncln_impl(end,start)
  }
  def indexvector_apply[T:Manifest](__arg0: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[T])(implicit __pos: SourceContext,__imp1: Overload6) = {
    indexvector_apply_impl6[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def indexvector_apply[T:Manifest](__arg0: Tuple2[Rep[IndexVector],Rep[IndexVector]],__arg1: (Rep[Int],Rep[Int]) => Rep[T])(implicit __pos: SourceContext,__imp1: Overload7) = {
    indexvector_apply_impl7[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def indexvector_apply[T:Manifest](__arg0: Tuple2[Rep[IndexVector],IndexWildcard],__arg1: (Rep[Int]) => Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload8) = {
    indexvector_apply_impl8[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def indexvector_apply[T:Manifest](__arg0: Tuple2[IndexWildcard,Rep[IndexVector]],__arg1: (Rep[Int]) => Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload9) = {
    indexvector_apply_impl9[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos)
  }

}

