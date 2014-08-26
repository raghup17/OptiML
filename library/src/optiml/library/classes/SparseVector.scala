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

trait SparseVectorWrapper {
  this: OptiMLBase with OptiMLClasses => 

class SparseVector[T:Manifest](___length: Int, ___isRow: Boolean, ___data: ForgeArray[T], ___indices: ForgeArray[Int], ___nnz: Int) {
  var _length = ___length
  var _isRow = ___isRow
  var _data = ___data
  var _indices = ___indices
  var _nnz = ___nnz

  override def toString() = {
    val self = this
    sparsevector_tostring_impl7[T](self)
  }
}

  def sparsevector_object_apply[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Boolean])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    new SparseVector[T](__arg0,__arg1,array_empty[T](unit(32)),array_empty[Int](unit(32)),unit(0))
  }
  def sparsevector_alloc_raw[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Boolean],__arg2: Rep[ForgeArray[T]],__arg3: Rep[ForgeArray[Int]],__arg4: Rep[Int])(implicit __pos: SourceContext) = {
    new SparseVector[T](__arg0,__arg1,__arg2,__arg3,__arg4)
  }
  def sparsevector_fromfunc[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Boolean],__arg2: Rep[IndexVector],__arg3: (Rep[Int]) => Rep[T])(implicit __pos: SourceContext) = {
    sparsevector_fromfunc_impl[T](__arg0,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_object_rand(length: Rep[Int],sparsity: Rep[Double])(implicit __pos: SourceContext) = {
    sparsevector_object_rand_impl1(length,sparsity)(__pos)
  }
  def sparsevector_object_randf(length: Rep[Int],sparsity: Rep[Double])(implicit __pos: SourceContext) = {
    sparsevector_object_randf_impl1(length,sparsity)(__pos)
  }
  def bsearch(a: Rep[ForgeArray[Int]],_start: Rep[Int],_end: Rep[Int],pos: Rep[Int])(implicit __pos: SourceContext) = {
    bsearch_impl(a,_start,_end,pos)(__pos)
  }
  def defaultValue[T:Manifest]()(implicit __pos: SourceContext) = {
    defaultValue_impl[T]()(implicitly[Manifest[T]],__pos)
  }
  def zipUnion[A:Manifest,B:Manifest,R:Manifest](nnzInit: Rep[Int],aIdxInit: Rep[Int],annz: Rep[Int],aIndices: Rep[ForgeArray[Int]],aData: Rep[ForgeArray[A]],bIdxInit: Rep[Int],bnnz: Rep[Int],bIndices: Rep[ForgeArray[Int]],bData: Rep[ForgeArray[B]],outIndices: Rep[ForgeArray[Int]],outData: Rep[ForgeArray[R]],f: (Rep[A],Rep[B]) => Rep[R])(implicit __pos: SourceContext) = {
    zipUnion_impl[A,B,R](nnzInit,aIdxInit,annz,aIndices,aData,bIdxInit,bnnz,bIndices,bData,outIndices,outData,f)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos)
  }
  def zipIntersect[A:Manifest,B:Manifest,R:Manifest](nnzInit: Rep[Int],aIdxInit: Rep[Int],annz: Rep[Int],aIndices: Rep[ForgeArray[Int]],aData: Rep[ForgeArray[A]],bIdxInit: Rep[Int],bnnz: Rep[Int],bIndices: Rep[ForgeArray[Int]],bData: Rep[ForgeArray[B]],outIndices: Rep[ForgeArray[Int]],outData: Rep[ForgeArray[R]],f: (Rep[A],Rep[B]) => Rep[R])(implicit __pos: SourceContext) = {
    zipIntersect_impl[A,B,R](nnzInit,aIdxInit,annz,aIndices,aData,bIdxInit,bnnz,bIndices,bData,outIndices,outData,f)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos)
  }
  def sparsevector_length[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._length
  }
  def sparsevector_isrow[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._isRow
  }
  def sparsevector_nnz[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._nnz
  }
  def sparsevector_nz[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsevector_nz_impl2[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_indices[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsevector_indices_impl3[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_find_offset[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int])(implicit __pos: SourceContext) = {
    sparsevector_find_offset_impl[T](self,pos)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_apply[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload11) = {
    sparsevector_apply_impl11[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_apply[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload12) = {
    sparsevector_apply_impl12[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_isempty[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsevector_isempty_impl2[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_first[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsevector_first_impl2[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_firstnz[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsevector_firstnz_impl[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_last[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsevector_last_impl2[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_lastnz[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsevector_lastnz_impl[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_drop[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    sparsevector_drop_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_take[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    sparsevector_take_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_contains[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext) = {
    sparsevector_contains_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_distinct[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsevector_distinct_impl2[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_t[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    new SparseVector[T](sparsevector_length(self),!(sparsevector_isrow(self)),array_clone(sparsevector_raw_data(self)),array_clone(sparsevector_raw_indices(self)),sparsevector_nnz(self))
  }
  def sparsevector_mt[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsevector_mt_impl1[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_clone[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    new SparseVector[T](sparsevector_length(self),sparsevector_isrow(self),array_clone(sparsevector_raw_data(self)),array_clone(sparsevector_raw_indices(self)),sparsevector_nnz(self))
  }
  def sparsevector_mutable[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    new SparseVector[T](sparsevector_length(self),sparsevector_isrow(self),array_clone(sparsevector_raw_data(self)),array_clone(sparsevector_raw_indices(self)),sparsevector_nnz(self))
  }
  def sparsevector_todense[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsevector_todense_impl3[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_makestring[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]) = {
    sparsevector_makestring_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_tostring[T:Manifest](self: Rep[SparseVector[T]]) = {
    sparsevector_tostring_impl7[T](self)
  }
  def sparsevector_pprint[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]) = {
    sparsevector_pprint_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_raw_data[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    self._data
  }
  def sparsevector_raw_indices[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    self._indices
  }
  def sparsevector_set_length[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    self._length = __arg1
  }
  def sparsevector_set_isrow[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Boolean])(implicit __pos: SourceContext) = {
    self._isRow = __arg1
  }
  def sparsevector_set_raw_data[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[ForgeArray[T]])(implicit __pos: SourceContext) = {
    self._data = __arg1
  }
  def sparsevector_set_raw_indices[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[ForgeArray[Int]])(implicit __pos: SourceContext) = {
    self._indices = __arg1
  }
  def sparsevector_set_nnz[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    self._nnz = __arg1
  }
  def sparsevector_update[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],e: Rep[T])(implicit __pos: SourceContext,__imp1: Overload2) = {
    sparsevector_update_impl2[T](self,pos,e)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_update[T:Manifest](self: Rep[SparseVector[T]],indices: Rep[IndexVector],e: Rep[T])(implicit __pos: SourceContext,__imp1: Overload3) = {
    sparsevector_update_impl3[T](self,indices,e)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_update[T:Manifest](self: Rep[SparseVector[T]],indices: Rep[IndexVector],v: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload4) = {
    sparsevector_update_impl4[T](self,indices,v)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_ltlt[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload3) = {
    sparsevector_ltlt_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_ltlt[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload4) = {
    sparsevector_ltlt_impl4[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_ltlteq[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload1) = {
    sparsevector_ltlteq_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_ltlteq[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = {
    sparsevector_ltlteq_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_insert_at_off[T:Manifest](self: Rep[SparseVector[T]],off: Rep[Int],pos: Rep[Int],e: Rep[T])(implicit __pos: SourceContext) = {
    sparsevector_insert_at_off_impl[T](self,off,pos,e)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_insert[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext) = {
    sparsevector_insert_impl1[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_insertall[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],xs: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsevector_insertall_impl1[T](self,pos,xs)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_remove[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    sparsevector_remove_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_removeall[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext) = {
    sparsevector_removeall_impl1[T](self,pos,len)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_copyfrom[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],xs: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsevector_copyfrom_impl1[T](self,pos,xs)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_trim[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsevector_trim_impl1[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_clear[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsevector_clear_impl1[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_insertspace[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext) = {
    sparsevector_insertspace_impl[T](self,pos,len)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_ensureextra[T:Manifest](self: Rep[SparseVector[T]],extra: Rep[Int])(implicit __pos: SourceContext) = {
    sparsevector_ensureextra_impl[T](self,extra)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_realloc[T:Manifest](self: Rep[SparseVector[T]],minLen: Rep[Int])(implicit __pos: SourceContext) = {
    sparsevector_realloc_impl[T](self,minLen)(implicitly[Manifest[T]],__pos)
  }
  def zipVectorUnion[T:Manifest,B:Manifest,R:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext) = {
    zipVectorUnion_impl[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos)
  }
  def zipVectorIntersect[T:Manifest,B:Manifest,R:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext) = {
    zipVectorIntersect_impl[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos)
  }
  def sparsevector_pl[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload39) = {
    sparsevector_pl_impl39[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_pl[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload40) = {
    sparsevector_pl_impl40[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_pl[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload41) = {
    sparsevector_pl_impl41[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_sub[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload39) = {
    sparsevector_sub_impl39[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_sub[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload40) = {
    sparsevector_sub_impl40[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_sub[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload41) = {
    sparsevector_sub_impl41[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_mul[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload40) = {
    sparsevector_mul_impl40[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_mul[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload41) = {
    sparsevector_mul_impl41[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_mul[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload42) = {
    sparsevector_mul_impl42[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_mul[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload43) = {
    sparsevector_mul_impl43[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_mulclnmul[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload5) = {
    sparsevector_mulclnmul_impl5[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_mulclnmul[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload6) = {
    sparsevector_mulclnmul_impl6[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_mulmul[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    sparsevector_mulmul_impl5[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_div[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload40) = {
    sparsevector_div_impl40[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_div[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload41) = {
    sparsevector_div_impl41[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_div[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload42) = {
    sparsevector_div_impl42[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_abs[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    sparsevector_abs_impl7[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_sum[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    sparsevector_sum_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_mean[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]) = {
    sparsevector_mean_impl2[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def sparsevector_min[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    sparsevector_min_impl3[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_max[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    sparsevector_max_impl3[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector___equal[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload6) = {
    sparsevector___equal_impl6[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector___equal[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload7) = {
    sparsevector___equal_impl7[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector___equal[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload8) = {
    sparsevector___equal_impl8[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_mapnz[T:Manifest,R:Manifest](self: Rep[SparseVector[T]],__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext) = {
    sparsevector_mapnz_impl1[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def sparsevector_reducenz[T:Manifest](self: Rep[SparseVector[T]],__arg1: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    sparsevector_reducenz_impl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_filternz[T:Manifest](self: Rep[SparseVector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    sparsevector_filternz_impl[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_foreachnz[T:Manifest](self: Rep[SparseVector[T]],__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext) = {
    sparsevector_foreachnz_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_findnz[T:Manifest](self: Rep[SparseVector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    sparsevector_findnz_impl[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_countnz[T:Manifest](self: Rep[SparseVector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    sparsevector_countnz_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_dist(__arg0: Rep[SparseVector[Double]],__arg1: Rep[SparseVector[Double]],__arg2: DistanceMetric)(implicit __pos: SourceContext) = {
    sparsevector_dist_impl1(__arg0,__arg1,__arg2)(__pos)
  }

}

