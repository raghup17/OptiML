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

trait DenseMatrixWrapper {
  this: OptiMLBase with OptiMLClasses => 

class DenseMatrix[T:Manifest](___numRows: Int, ___numCols: Int, ___data: ForgeArray[T]) {
  var _numRows = ___numRows
  var _numCols = ___numCols
  var _data = ___data

  override def toString() = {
    val self = this
    densematrix_tostring_impl14[T](self)
  }
}

  def densematrix_object_apply[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload20) = {
    def __imp1 = ()
    new DenseMatrix[T](__arg0,__arg1,array_empty[T](__arg0*__arg1))
  }
  def densematrix_object_apply[T:Manifest](__arg0: Rep[DenseVector[DenseVector[T]]])(implicit __pos: SourceContext,__imp1: Overload21) = {
    densematrix_object_apply_impl21[T](__arg0)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_object_apply[T:Manifest](__arg0: Rep[DenseVector[DenseVectorView[T]]])(implicit __pos: SourceContext,__imp1: Overload22) = {
    densematrix_object_apply_impl22[T](__arg0)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_object_apply[T:Manifest](__arg0: Seq[Rep[DenseVector[T]]])(implicit __pos: SourceContext,__imp1: Overload23) = {
    densematrix_object_apply_impl23[T](__arg0)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_object_block[T:Manifest](__arg0: Seq[Rep[DenseVector[DenseMatrix[T]]]])(implicit __pos: SourceContext) = {
    densematrix_object_block_impl[T](__arg0)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_object_diag[T:Arith:Manifest](__arg0: Rep[Int],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densematrix_object_diag_impl1[T](__arg0,__arg1)(implicitly[Arith[T]],implicitly[Manifest[T]],__pos)
  }
  def densematrix_object_identity(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = {
    densematrix_object_identity_impl1(__arg0,__arg1)(__pos)
  }
  def densematrix_fromarray[T:Manifest](__arg0: Rep[ForgeArray[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext) = {
    new DenseMatrix[T](__arg1,__arg2,__arg0)
  }
  def densematrix_fromfunc[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Int],__arg2: (Rep[Int],Rep[Int]) => Rep[T])(implicit __pos: SourceContext) = {
    densematrix_fromfunc_impl[T](__arg0,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def matrix_shapeindex(idx: Rep[Int],numCols: Rep[Int])(implicit __pos: SourceContext) = {
    matrix_shapeindex_impl(idx,numCols)(__pos)
  }
  def densematrix_grouprowsby_helper[T:Manifest,K:Manifest,V:Manifest](__arg0: Rep[IndexVector],__arg1: Rep[DenseMatrix[T]],__arg2: (Rep[DenseVectorView[T]]) => Rep[K],__arg3: (Rep[DenseVectorView[T]]) => Rep[V])(implicit __pos: SourceContext) = {
    densematrix_grouprowsby_helper_impl[T,K,V](__arg0,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  }
  def densematrix_groupcolsby_helper[T:Manifest,K:Manifest,V:Manifest](__arg0: Rep[IndexVector],__arg1: Rep[DenseMatrix[T]],__arg2: (Rep[DenseVectorView[T]]) => Rep[K],__arg3: (Rep[DenseVectorView[T]]) => Rep[V])(implicit __pos: SourceContext) = {
    densematrix_groupcolsby_helper_impl[T,K,V](__arg0,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  }
  def densematrix_object_zeros(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densematrix_object_zeros_impl2(__arg0,__arg1)(__pos)
  }
  def densematrix_object_zerosf(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densematrix_object_zerosf_impl2(__arg0,__arg1)(__pos)
  }
  def densematrix_object_ones(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densematrix_object_ones_impl1(__arg0,__arg1)(__pos)
  }
  def densematrix_object_onesf(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densematrix_object_onesf_impl1(__arg0,__arg1)(__pos)
  }
  def densematrix_object_rand(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densematrix_object_rand_impl2(__arg0,__arg1)(__pos)
  }
  def densematrix_object_randf(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densematrix_object_randf_impl2(__arg0,__arg1)(__pos)
  }
  def densematrix_object_randn(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densematrix_object_randn_impl1(__arg0,__arg1)(__pos)
  }
  def densematrix_object_randnf(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densematrix_object_randnf_impl1(__arg0,__arg1)(__pos)
  }
  def densematrix_toboolean[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Boolean]) = {
    densematrix_toboolean_impl4[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densematrix_todouble[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]) = {
    densematrix_todouble_impl5[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densematrix_tofloat[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Float]) = {
    densematrix_tofloat_impl5[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densematrix_toint[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Int]) = {
    densematrix_toint_impl5[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densematrix_flattentovector[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = {
    densematrix_flattentovector_impl[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_numrows[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._numRows
  }
  def densematrix_numcols[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._numCols
  }
  def densematrix_size[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = {
    densematrix_size_impl13[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_index[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext) = {
    densematrix_index_impl[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_apply[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload21) = {
    densematrix_apply_impl21[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_apply[T:Manifest](self: Rep[DenseMatrix[T]],rows: Rep[IndexVector],cols: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload25) = {
    densematrix_apply_impl25[T](self,rows,cols)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_indices[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = {
    densematrix_indices_impl5[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_rowindices[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = {
    densematrix_rowindices_impl1[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_colindices[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = {
    densematrix_colindices_impl1[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_vview[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[Int],__arg4: Rep[Boolean])(implicit __pos: SourceContext) = {
    densematrix_vview_impl[T](self,__arg1,__arg2,__arg3,__arg4)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_getrow[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densematrix_getrow_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_getrows[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext) = {
    densematrix_getrows_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_getcol[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densematrix_getcol_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_getcols[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext) = {
    densematrix_getcols_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_diag[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = {
    densematrix_diag_impl[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_triu[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densematrix_triu_impl[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_tril[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densematrix_tril_impl[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_pprint[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]) = {
    densematrix_pprint_impl5[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_makestring[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]) = {
    densematrix_makestring_impl5[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_tostring[T:Manifest](self: Rep[DenseMatrix[T]]) = {
    densematrix_tostring_impl14[T](self)
  }
  def densematrix_t[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = {
    densematrix_t_impl3[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_clone[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = {
    densematrix_clone_impl5[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_mutable[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = {
    densematrix_mutable_impl14[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_replicate[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext) = {
    densematrix_replicate_impl3[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_raw_data[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = {
    self._data
  }
  def densematrix_set_raw_data[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[ForgeArray[T]])(implicit __pos: SourceContext) = {
    self._data = __arg1
  }
  def densematrix_set_numrows[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    self._numRows = __arg1
  }
  def densematrix_set_numcols[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    self._numCols = __arg1
  }
  def densematrix_update[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[T])(implicit __pos: SourceContext,__imp1: Overload7) = {
    densematrix_update_impl7[T](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_update[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload8) = {
    densematrix_update_impl8[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_updaterow[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = {
    densematrix_updaterow_impl1[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_updatecol[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = {
    densematrix_updatecol_impl1[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_update[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload9) = {
    densematrix_update_impl9[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_updaterow[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload2) = {
    densematrix_updaterow_impl2[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_updatecol[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload2) = {
    densematrix_updatecol_impl2[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_ltlt[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload5) = {
    densematrix_ltlt_impl5[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_ltlt[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload6) = {
    densematrix_ltlt_impl6[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_ltltor[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = {
    densematrix_ltltor_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_ltltor[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload2) = {
    densematrix_ltltor_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_ltlteq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload4) = {
    densematrix_ltlteq_impl4[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_ltlteq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload5) = {
    densematrix_ltlteq_impl5[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_ltltoreq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = {
    densematrix_ltltoreq_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_ltltoreq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload3) = {
    densematrix_ltltoreq_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_insertrow[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],y: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densematrix_insertrow_impl2[T](self,pos,y)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_insertallrows[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],xs: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = {
    densematrix_insertallrows_impl[T](self,pos,xs)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_insertcol[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],y: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densematrix_insertcol_impl2[T](self,pos,y)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_insertallcols[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],xs: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = {
    densematrix_insertallcols_impl[T](self,pos,xs)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_trim[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = {
    densematrix_trim_impl3[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_removerow[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int])(implicit __pos: SourceContext) = {
    densematrix_removerow_impl2[T](self,pos)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_removecol[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int])(implicit __pos: SourceContext) = {
    densematrix_removecol_impl2[T](self,pos)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_removerows[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],num: Rep[Int])(implicit __pos: SourceContext) = {
    densematrix_removerows_impl2[T](self,pos,num)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_removecols[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],num: Rep[Int])(implicit __pos: SourceContext) = {
    densematrix_removecols_impl2[T](self,pos,num)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_insertspace[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext) = {
    densematrix_insertspace_impl[T](self,pos,len)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_ensureextra[T:Manifest](self: Rep[DenseMatrix[T]],extra: Rep[Int])(implicit __pos: SourceContext) = {
    densematrix_ensureextra_impl[T](self,extra)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_realloc[T:Manifest](self: Rep[DenseMatrix[T]],minLen: Rep[Int])(implicit __pos: SourceContext) = {
    densematrix_realloc_impl[T](self,minLen)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_pl[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload74) = {
    densematrix_pl_impl74[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_pl[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload75) = {
    densematrix_pl_impl75[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_pleq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload1) = {
    densematrix_pleq_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_pleq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = {
    densematrix_pleq_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_sub[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload58) = {
    densematrix_sub_impl58[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_sub[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload59) = {
    densematrix_sub_impl59[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_subeq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload1) = {
    densematrix_subeq_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_subeq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = {
    densematrix_subeq_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_mulclnmul[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload11) = {
    densematrix_mulclnmul_impl11[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_mul[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload61) = {
    densematrix_mul_impl61[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_muleq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload1) = {
    densematrix_muleq_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_muleq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = {
    densematrix_muleq_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_matmult[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densematrix_matmult_impl62[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_matvecmult[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densematrix_matvecmult_impl63[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_div[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload59) = {
    densematrix_div_impl59[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_div[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload60) = {
    densematrix_div_impl60[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_diveq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload1) = {
    densematrix_diveq_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_diveq[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = {
    densematrix_diveq_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_pl[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload76) = {
    densematrix_pl_impl76[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_sub[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload60) = {
    densematrix_sub_impl60[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_mulclnmul[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload12) = {
    densematrix_mulclnmul_impl12[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_div[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload61) = {
    densematrix_div_impl61[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_sum[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densematrix_sum_impl4[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_prod[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densematrix_prod_impl3[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_mean[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]) = {
    densematrix_mean_impl4[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densematrix_abs[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densematrix_abs_impl20[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_exp[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densematrix_exp_impl19[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_log[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densematrix_log_impl19[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_sumrows[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densematrix_sumrows_impl1[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_sumcols[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densematrix_sumcols_impl1[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_minrows[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    densematrix_minrows_impl1[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_mincols[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    densematrix_mincols_impl1[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_maxrows[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    densematrix_maxrows_impl1[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_maxcols[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    densematrix_maxcols_impl1[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_min[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    densematrix_min_impl5[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_max[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    densematrix_max_impl5[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_minindex[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    densematrix_minindex_impl3[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_maxindex[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    densematrix_maxindex_impl3[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_clngt[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    densematrix_clngt_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_clnlt[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    densematrix_clnlt_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix___equal[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload10) = {
    densematrix___equal_impl10[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix___equal[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload11) = {
    densematrix___equal_impl11[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_map[T:Manifest,R:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext) = {
    densematrix_map_impl3[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def densematrix_maprowstovector[T:Manifest,R:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[R])(implicit __pos: SourceContext) = {
    densematrix_maprowstovector_impl1[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def densematrix_mapcolstovector[T:Manifest,R:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[R])(implicit __pos: SourceContext) = {
    densematrix_mapcolstovector_impl1[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def densematrix_zip[T:Manifest,B:Manifest,R:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext) = {
    densematrix_zip_impl5[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos)
  }
  def densematrix_foreach[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext) = {
    densematrix_foreach_impl4[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_count[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    densematrix_count_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_findrows[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    densematrix_findrows_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_findcols[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    densematrix_findcols_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_filterrows[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    densematrix_filterrows_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_filtercols[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    densematrix_filtercols_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_foreachrow[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[Unit])(implicit __pos: SourceContext) = {
    densematrix_foreachrow_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_foreachcol[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[Unit])(implicit __pos: SourceContext) = {
    densematrix_foreachcol_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_maprows[T:Manifest,R:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[DenseVector[R]])(implicit __pos: SourceContext) = {
    densematrix_maprows_impl[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def densematrix_mapcols[T:Manifest,R:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[DenseVector[R]])(implicit __pos: SourceContext) = {
    densematrix_mapcols_impl[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def densematrix_reducerows[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVector[T]],Rep[DenseVector[T]]) => Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densematrix_reducerows_impl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_reducecols[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVector[T]],Rep[DenseVector[T]]) => Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densematrix_reducecols_impl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densematrix_grouprowsby[T:Manifest,K:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[K])(implicit __pos: SourceContext) = {
    densematrix_grouprowsby_impl[T,K](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[K]],__pos)
  }
  def densematrix_groupcolsby[T:Manifest,K:Manifest](self: Rep[DenseMatrix[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[K])(implicit __pos: SourceContext) = {
    densematrix_groupcolsby_impl[T,K](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[K]],__pos)
  }
  def densematrix_raw_alloc[T:Manifest,R:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densematrix_raw_alloc_impl[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def densematrix_densematrix_raw_apply[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densematrix_densematrix_raw_apply_impl[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_densematrix_raw_update[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext) = {
    densematrix_densematrix_raw_update_impl[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densematrix_dist(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[DenseMatrix[Double]],__arg2: DistanceMetric)(implicit __pos: SourceContext) = {
    densematrix_dist_impl3(__arg0,__arg1,__arg2)(__pos)
  }

}

