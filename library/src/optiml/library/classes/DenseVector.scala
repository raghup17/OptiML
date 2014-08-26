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

trait DenseVectorWrapper {
  this: OptiMLBase with OptiMLClasses => 

class DenseVector[T:Manifest](___length: Int, ___isRow: Boolean, ___data: ForgeArray[T]) {
  var _length = ___length
  var _isRow = ___isRow
  var _data = ___data

  override def toString() = {
    val self = this
    densevector_tostring_impl15[T](self)
  }
}

  def densevector_object_apply[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload24) = {
    def __imp1 = ()
    new DenseVector[T](__arg0,__arg1,array_empty[T](__arg0))
  }
  def densevector_object_apply[T:Manifest](__arg0: Seq[Rep[T]])(implicit __pos: SourceContext,__imp1: Overload25) = {
    def __imp1 = ()
    new DenseVector[T](unit(__arg0.length),unit(true),array_fromseq(__arg0))
  }
  def densevector_alloc_raw[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Boolean],__arg2: Rep[ForgeArray[T]])(implicit __pos: SourceContext) = {
    new DenseVector[T](__arg0,__arg1,__arg2)
  }
  def densevector_fromarray[T:Manifest](__arg0: Rep[ForgeArray[T]],__arg1: Rep[Boolean])(implicit __pos: SourceContext) = {
    new DenseVector[T](array_length(__arg0),__arg1,__arg0)
  }
  def densevector_fromfunc[T:Manifest](__arg0: Rep[Int],__arg1: (Rep[Int]) => Rep[T])(implicit __pos: SourceContext) = {
    densevector_fromfunc_impl[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_object_zeros(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_object_zeros_impl3(__arg0)(__pos)
  }
  def densevector_object_zerosf(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_object_zerosf_impl3(__arg0)(__pos)
  }
  def densevector_object_ones(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_object_ones_impl2(__arg0)(__pos)
  }
  def densevector_object_onesf(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_object_onesf_impl2(__arg0)(__pos)
  }
  def densevector_object_rand(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_object_rand_impl3(__arg0)(__pos)
  }
  def densevector_object_randf(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_object_randf_impl3(__arg0)(__pos)
  }
  def densevector_object_uniform(start: Rep[Int],step_size: Rep[Double],end: Rep[Int],isRow: Rep[Boolean] = unit(true))(implicit __pos: SourceContext) = {
    densevector_object_uniform_impl(start,step_size,end,isRow)(__pos)
  }
  def densevector_object_flatten[T:Manifest](pieces: Rep[DenseVector[DenseVector[T]]])(implicit __pos: SourceContext) = {
    densevector_object_flatten_impl[T](pieces)(implicitly[Manifest[T]],__pos)
  }
  def densevector_precumulate[T:Manifest](v: Rep[DenseVector[T]],identity: Rep[T],func: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext) = {
    densevector_precumulate_impl[T](v,identity,func)(implicitly[Manifest[T]],__pos)
  }
  def densevector_dc_alloc[R:Manifest,CR:Manifest](__arg0: Rep[CR],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_dc_alloc_impl[R,CR](__arg0,__arg1)(implicitly[Manifest[R]],implicitly[Manifest[CR]],__pos)
  }
  def densevector_sortindex_helper[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[ForgeArray[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    (__arg0 until __arg1: scala.Range).toArray.sortWith((a,b) => __arg2(a) < __arg2(b))
  }
  def densevector_groupby_helper[T:Manifest,K:Manifest,V:Manifest](__arg0: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit __pos: SourceContext) = {
    densevector_groupby_helper_impl[T,K,V](__arg0,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  }
  def densevector_tovector[T:Manifest,R:Manifest](__arg0: Rep[ForgeHashMap[T,R]])(implicit __pos: SourceContext) = {
    densevector_tovector_impl[T,R](__arg0)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def densevector_length[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._length
  }
  def densevector_isrow[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._isRow
  }
  def densevector_apply[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload27) = {
    densevector_apply_impl27[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_apply[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload28) = {
    densevector_apply_impl28[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_t[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    new DenseVector[T](densevector_length(self),!(densevector_isrow(self)),array_clone(densevector_raw_data(self)))
  }
  def densevector_mt[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densevector_mt_impl2[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevector_tomat[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densevector_tomat_impl[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevector_clone[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densevector_clone_impl6[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevector_raw_data[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    self._data
  }
  def densevector_set_raw_data[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[ForgeArray[T]])(implicit __pos: SourceContext) = {
    self._data = __arg1
  }
  def densevector_set_length[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    self._length = __arg1
  }
  def densevector_set_isrow[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Boolean])(implicit __pos: SourceContext) = {
    self._isRow = __arg1
  }
  def densevector_update[T:Manifest](self: Rep[DenseVector[T]],i: Rep[Int],e: Rep[T])(implicit __pos: SourceContext,__imp1: Overload10) = {
    densevector_update_impl10[T](self,i,e)(implicitly[Manifest[T]],__pos)
  }
  def densevector_update[T:Manifest](self: Rep[DenseVector[T]],indices: Rep[IndexVector],e: Rep[T])(implicit __pos: SourceContext,__imp1: Overload11) = {
    densevector_update_impl11[T](self,indices,e)(implicitly[Manifest[T]],__pos)
  }
  def densevector_update[T:Manifest](self: Rep[DenseVector[T]],indices: Rep[IndexVector],v: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload12) = {
    densevector_update_impl12[T](self,indices,v)(implicitly[Manifest[T]],__pos)
  }
  def densevector_ltlt[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload7) = {
    densevector_ltlt_impl7[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_ltlt[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload8) = {
    densevector_ltlt_impl8[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_ltlteq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload6) = {
    densevector_ltlteq_impl6[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_ltlteq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload7) = {
    densevector_ltlteq_impl7[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_insert[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext) = {
    densevector_insert_impl2[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densevector_insertall[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densevector_insertall_impl2[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densevector_remove[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_remove_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_removeall[T:Manifest](self: Rep[DenseVector[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_removeall_impl2[T](self,pos,len)(implicitly[Manifest[T]],__pos)
  }
  def densevector_copyfrom[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densevector_copyfrom_impl2[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densevector_trim[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densevector_trim_impl4[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevector_clear[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densevector_clear_impl2[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevector_insertspace[T:Manifest](self: Rep[DenseVector[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_insertspace_impl[T](self,pos,len)(implicitly[Manifest[T]],__pos)
  }
  def densevector_ensureextra[T:Manifest](self: Rep[DenseVector[T]],extra: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_ensureextra_impl[T](self,extra)(implicitly[Manifest[T]],__pos)
  }
  def densevector_realloc[T:Manifest](self: Rep[DenseVector[T]],minLen: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_realloc_impl[T](self,minLen)(implicitly[Manifest[T]],__pos)
  }
  def densevector_pleq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload3) = {
    densevector_pleq_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_pleq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload4) = {
    densevector_pleq_impl4[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_pleq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload5) = {
    densevector_pleq_impl5[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_muleq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload3) = {
    densevector_muleq_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_muleq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload4) = {
    densevector_muleq_impl4[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_muleq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload5) = {
    densevector_muleq_impl5[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_subeq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload3) = {
    densevector_subeq_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_subeq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload4) = {
    densevector_subeq_impl4[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_subeq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload5) = {
    densevector_subeq_impl5[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_diveq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload3) = {
    densevector_diveq_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_diveq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload4) = {
    densevector_diveq_impl4[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_diveq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload5) = {
    densevector_diveq_impl5[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_sort[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    densevector_sort_impl[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_sortby[T:Manifest,B:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[B])(implicit __pos: SourceContext,__imp0: Ordering[B]) = {
    densevector_sortby_impl[T,B](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[B]],__pos,__imp0)
  }
  def densevector_sortwithindex[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    densevector_sortwithindex_impl[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_median[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Numeric[T],__imp1: Ordering[T]) = {
    densevector_median_impl[T](self)(implicitly[Manifest[T]],__pos,__imp0,__imp1)
  }
  def densevector_clngt[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    densevector_clngt_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_clnlt[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    densevector_clnlt_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector___equal[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload12) = {
    densevector___equal_impl12[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector___equal[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload13) = {
    densevector___equal_impl13[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector___equal[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload14) = {
    densevector___equal_impl14[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector___equal[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload15) = {
    densevector___equal_impl15[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_groupbyreduce[T:Manifest,K:Manifest,V:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V],__arg3: (Rep[V],Rep[V]) => Rep[V])(implicit __pos: SourceContext,__imp0: Arith[V]) = {
    densevector_groupbyreduce_impl[T,K,V](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos,__imp0)
  }
  def densevector_groupby[T:Manifest,K:Manifest,V:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit __pos: SourceContext) = {
    densevector_groupby_impl[T,K,V](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  }
  def densevector_filter[T:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    densevector_filter_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_appendable[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext) = {
    densevector_appendable_impl[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densevector_append[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext) = {
    densevector_append_impl[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densevector_copy[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]],__arg3: Rep[Int],__arg4: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_copy_impl[T](self,__arg1,__arg2,__arg3,__arg4)(implicitly[Manifest[T]],__pos)
  }
  def densevector_toboolean[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Boolean]) = {
    densevector_toboolean_impl5[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densevector_todouble[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]) = {
    densevector_todouble_impl6[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densevector_tofloat[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Float]) = {
    densevector_tofloat_impl6[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densevector_toint[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Int]) = {
    densevector_toint_impl6[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densevector_indices[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densevector_indices_impl6[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevector_isempty[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densevector_isempty_impl4[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevector_first[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densevector_first_impl4[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevector_last[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densevector_last_impl4[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevector_drop[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_drop_impl4[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_take[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_take_impl4[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_contains[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext) = {
    densevector_contains_impl9[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_distinct[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densevector_distinct_impl4[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevector_mutable[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densevector_mutable_impl15[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevector_replicate[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_replicate_impl4[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densevector_makestring[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]) = {
    densevector_makestring_impl6[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_tostring[T:Manifest](self: Rep[DenseVector[T]]) = {
    densevector_tostring_impl15[T](self)
  }
  def densevector_pprint[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]) = {
    densevector_pprint_impl6[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_pl[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload131) = {
    densevector_pl_impl131[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_sub[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload97) = {
    densevector_sub_impl97[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload136) = {
    densevector_mul_impl136[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mulclnmul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload22) = {
    densevector_mulclnmul_impl22[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mulmul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload10) = {
    densevector_mulmul_impl10[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_div[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload98) = {
    densevector_div_impl98[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_pl[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload132) = {
    densevector_pl_impl132[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_sub[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload98) = {
    densevector_sub_impl98[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload137) = {
    densevector_mul_impl137[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_dot_densevectorview[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevector_dot_densevectorview_impl23[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mulmul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload11) = {
    densevector_mulmul_impl11[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_div[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload99) = {
    densevector_div_impl99[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_pl[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload133) = {
    densevector_pl_impl133[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_sub[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload99) = {
    densevector_sub_impl99[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload138) = {
    densevector_mul_impl138[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mulclnmul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload24) = {
    densevector_mulclnmul_impl24[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mulmul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload12) = {
    densevector_mulmul_impl12[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_div[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload100) = {
    densevector_div_impl100[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_pl[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload134) = {
    densevector_pl_impl134[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_sub[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload100) = {
    densevector_sub_impl100[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload139) = {
    densevector_mul_impl139[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mulclnmul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload25) = {
    densevector_mulclnmul_impl25[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mulmul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload13) = {
    densevector_mulmul_impl13[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_div[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload101) = {
    densevector_div_impl101[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_zip[T:Manifest,B:Manifest,R:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload6) = {
    densevector_zip_impl6[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos)
  }
  def densevector_zip[T:Manifest,B:Manifest,R:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload7) = {
    densevector_zip_impl7[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos)
  }
  def densevector_pl[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload135) = {
    densevector_pl_impl135[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_sub[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload101) = {
    densevector_sub_impl101[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload140) = {
    densevector_mul_impl140[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload141) = {
    densevector_mul_impl141[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_div[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload102) = {
    densevector_div_impl102[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_abs[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevector_abs_impl21[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_exp[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevector_exp_impl20[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_log[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevector_log_impl20[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_sum[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevector_sum_impl5[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_prod[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevector_prod_impl4[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mean[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]) = {
    densevector_mean_impl5[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densevector_min[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    densevector_min_impl6[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_max[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    densevector_max_impl6[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_minindex[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp1: Arith[T]) = {
    densevector_minindex_impl4[T](self)(implicitly[Manifest[T]],__pos,__imp0,__imp1)
  }
  def densevector_maxindex[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp1: Arith[T]) = {
    densevector_maxindex_impl4[T](self)(implicitly[Manifest[T]],__pos,__imp0,__imp1)
  }
  def densevector_map[T:Manifest,R:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext) = {
    densevector_map_impl4[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def densevector_reduce[T:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevector_reduce_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_foreach[T:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext) = {
    densevector_foreach_impl5[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_find[T:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    densevector_find_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_densevector_filter_map[T:Manifest,R:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[Boolean],__arg2: (Rep[T]) => Rep[R])(implicit __pos: SourceContext) = {
    densevector_densevector_filter_map_impl[T,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def densevector_count[T:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    densevector_count_impl4[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_partition[T:Manifest](self: Rep[DenseVector[T]],pred: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    densevector_partition_impl3[T](self,pred)(implicitly[Manifest[T]],__pos)
  }
  def densevector_flatmap[T:Manifest,R:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[DenseVector[R]])(implicit __pos: SourceContext) = {
    densevector_flatmap_impl3[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def densevector_scan[T:Manifest,R:Manifest](self: Rep[DenseVector[T]],zero: Rep[R],__arg2: (Rep[R],Rep[T]) => Rep[R])(implicit __pos: SourceContext) = {
    densevector_scan_impl3[T,R](self,zero,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def densevector_prefixsum[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevector_prefixsum_impl3[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_dist(__arg0: Rep[DenseVector[Double]],__arg1: Rep[DenseVector[Double]],__arg2: DistanceMetric)(implicit __pos: SourceContext) = {
    densevector_dist_impl4(__arg0,__arg1,__arg2)(__pos)
  }

}

