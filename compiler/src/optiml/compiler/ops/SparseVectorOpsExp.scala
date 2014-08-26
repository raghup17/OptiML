package optiml.compiler.ops

import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import ppl.delite.framework.ops.DeliteCollection
import ppl.delite.framework.datastructures._
import ppl.delite.framework.ops.{DeliteOpsExp, DeliteCollectionOpsExp}
import ppl.delite.framework.Util._
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._
import optiml.compiler._
import optiml.compiler.ops._

/**
 * IR Definitions
 */

trait SparseVectorOpsExp extends SparseVectorCompilerOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class SparseVector13Object_Apply[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Boolean])(implicit val __pos: SourceContext) extends DeliteStruct[SparseVector[T]] {
    val _mT = implicitly[Manifest[T]]
    val elems = copyTransformedElems(collection.Seq(("_length",var_new(__arg0).e),("_isRow",var_new(__arg1).e),("_data",var_new(array_empty[T](unit(32))).e),("_indices",var_new(array_empty[Int](unit(32))).e),("_nnz",var_new(unit(0)).e)))
  }

  case class Sparsevector_alloc_raw[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Boolean],__arg2: Rep[ForgeArray[T]],__arg3: Rep[ForgeArray[Int]],__arg4: Rep[Int])(implicit val __pos: SourceContext) extends DeliteStruct[SparseVector[T]] {
    val _mT = implicitly[Manifest[T]]
    val elems = copyTransformedElems(collection.Seq(("_length",__arg0),("_isRow",__arg1),("_data",__arg2),("_indices",__arg3),("_nnz",__arg4)))
  }

  case class Bsearch(a: Rep[ForgeArray[Int]],_start: Rep[Int],_end: Rep[Int],pos: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Int](reifyEffectsHere(bsearch_impl(a,_start,_end,pos)(__pos))) {
  }

  case class ZipUnion[A:Manifest,B:Manifest,R:Manifest](nnzInit: Rep[Int],aIdxInit: Rep[Int],annz: Rep[Int],aIndices: Rep[ForgeArray[Int]],aData: Rep[ForgeArray[A]],bIdxInit: Rep[Int],bnnz: Rep[Int],bIndices: Rep[ForgeArray[Int]],bData: Rep[ForgeArray[B]],outIndices: Rep[ForgeArray[Int]],outData: Rep[ForgeArray[R]],f: (Rep[A],Rep[B]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Int](reifyEffectsHere(zipUnion_impl[A,B,R](nnzInit,aIdxInit,annz,aIndices,aData,bIdxInit,bnnz,bIndices,bData,outIndices,outData,f)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos))) {
    val _mA = implicitly[Manifest[A]]
    val _mB = implicitly[Manifest[B]]
    val _mR = implicitly[Manifest[R]]
  }

  case class ZipIntersect[A:Manifest,B:Manifest,R:Manifest](nnzInit: Rep[Int],aIdxInit: Rep[Int],annz: Rep[Int],aIndices: Rep[ForgeArray[Int]],aData: Rep[ForgeArray[A]],bIdxInit: Rep[Int],bnnz: Rep[Int],bIndices: Rep[ForgeArray[Int]],bData: Rep[ForgeArray[B]],outIndices: Rep[ForgeArray[Int]],outData: Rep[ForgeArray[R]],f: (Rep[A],Rep[B]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Int](reifyEffectsHere(zipIntersect_impl[A,B,R](nnzInit,aIdxInit,annz,aIndices,aData,bIdxInit,bnnz,bIndices,bData,outIndices,outData,f)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos))) {
    val _mA = implicitly[Manifest[A]]
    val _mB = implicitly[Manifest[B]]
    val _mR = implicitly[Manifest[R]]
  }

  case class SparseVector2_Nz[T:Manifest](self: Rep[SparseVector[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[DenseVectorView[T]](reifyEffectsHere(sparsevector_nz_impl2[T](self)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseVector2_IsEmpty[T:Manifest](self: Rep[SparseVector[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Boolean](reifyEffectsHere(sparsevector_isempty_impl2[T](self)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseVector2_T[T:Manifest](self: Rep[SparseVector[T]])(implicit val __pos: SourceContext) extends DeliteStruct[SparseVector[T]] {
    val _mT = implicitly[Manifest[T]]
    val elems = copyTransformedElems(collection.Seq(("_length",sparsevector_length(self)),("_isRow",!(sparsevector_isrow(self))),("_data",array_clone(sparsevector_raw_data(self))),("_indices",array_clone(sparsevector_raw_indices(self))),("_nnz",sparsevector_nnz(self))))
  }

  case class SparseVector3_Clone[T:Manifest](self: Rep[SparseVector[T]])(implicit val __pos: SourceContext) extends DeliteStruct[SparseVector[T]] {
    val _mT = implicitly[Manifest[T]]
    val elems = copyTransformedElems(collection.Seq(("_length",sparsevector_length(self)),("_isRow",sparsevector_isrow(self)),("_data",array_clone(sparsevector_raw_data(self))),("_indices",array_clone(sparsevector_raw_indices(self))),("_nnz",sparsevector_nnz(self))))
  }

  case class SparseVector5_Mutable[T:Manifest](self: Rep[SparseVector[T]])(implicit val __pos: SourceContext) extends DeliteStruct[SparseVector[T]] {
    val _mT = implicitly[Manifest[T]]
    val elems = copyTransformedElems(collection.Seq(("_length",var_new(sparsevector_length(self)).e),("_isRow",var_new(sparsevector_isrow(self)).e),("_data",var_new(array_clone(sparsevector_raw_data(self))).e),("_indices",var_new(array_clone(sparsevector_raw_indices(self))).e),("_nnz",var_new(sparsevector_nnz(self)).e)))
  }

  case class SparseVector2_MakeString[T:Manifest](self: Rep[SparseVector[T]])(implicit val __pos: SourceContext,val __imp0: Stringable[T]) extends DeliteOpSingleTask[String](reifyEffectsHere(sparsevector_makestring_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseVector7_ToString[T:Manifest](self: Rep[SparseVector[T]]) extends DeliteOpSingleTask[String](reifyEffectsHere(sparsevector_tostring_impl7[T](self))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseVector2_Update[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],e: Rep[T])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsevector_update_impl2[T](self,pos,e)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseVector3_Update[T:Manifest](self: Rep[SparseVector[T]],indices: Rep[IndexVector],e: Rep[T])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsevector_update_impl3[T](self,indices,e)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseVector4_Update[T:Manifest](self: Rep[SparseVector[T]],indices: Rep[IndexVector],v: Rep[SparseVector[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsevector_update_impl4[T](self,indices,v)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseVector3_Ltlt[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[SparseVector[T]](reifyEffectsHere(sparsevector_ltlt_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseVector4_Ltlt[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[SparseVector[T]](reifyEffectsHere(sparsevector_ltlt_impl4[T](self,__arg1)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Sparsevector_insert_at_off[T:Manifest](self: Rep[SparseVector[T]],off: Rep[Int],pos: Rep[Int],e: Rep[T])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsevector_insert_at_off_impl[T](self,off,pos,e)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseVector1_Insert[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsevector_insert_impl1[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseVector1_InsertAll[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],xs: Rep[SparseVector[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsevector_insertall_impl1[T](self,pos,xs)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseVector1_RemoveAll[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],len: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsevector_removeall_impl1[T](self,pos,len)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseVector1_CopyFrom[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],xs: Rep[SparseVector[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsevector_copyfrom_impl1[T](self,pos,xs)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseVector1_Trim[T:Manifest](self: Rep[SparseVector[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsevector_trim_impl1[T](self)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseVector1_Clear[T:Manifest](self: Rep[SparseVector[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsevector_clear_impl1[T](self)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Sparsevector_insertspace[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],len: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsevector_insertspace_impl[T](self,pos,len)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Sparsevector_ensureextra[T:Manifest](self: Rep[SparseVector[T]],extra: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsevector_ensureextra_impl[T](self,extra)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Sparsevector_realloc[T:Manifest](self: Rep[SparseVector[T]],minLen: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsevector_realloc_impl[T](self,minLen)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class ZipVectorUnion[T:Manifest,B:Manifest,R:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[SparseVector[R]](reifyEffectsHere(zipVectorUnion_impl[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos))) {
    val _mT = implicitly[Manifest[T]]
    val _mB = implicitly[Manifest[B]]
    val _mR = implicitly[Manifest[R]]
  }

  case class ZipVectorIntersect[T:Manifest,B:Manifest,R:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[SparseVector[R]](reifyEffectsHere(zipVectorIntersect_impl[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos))) {
    val _mT = implicitly[Manifest[T]]
    val _mB = implicitly[Manifest[B]]
    val _mR = implicitly[Manifest[R]]
  }



  def sparsevector_object_apply[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Boolean])(implicit __pos: SourceContext) = {
    reflectMutable(SparseVector13Object_Apply[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos))
  }
  def sparsevector_alloc_raw[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Boolean],__arg2: Rep[ForgeArray[T]],__arg3: Rep[ForgeArray[Int]],__arg4: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Sparsevector_alloc_raw[T](__arg0,__arg1,__arg2,__arg3,__arg4)(implicitly[Manifest[T]],__pos))
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
    reflectPure(Bsearch(a,_start,_end,pos)(__pos))
  }
  def defaultValue[T:Manifest]()(implicit __pos: SourceContext) = {
    defaultValue_impl[T]()(implicitly[Manifest[T]],__pos)
  }
  def zipUnion[A:Manifest,B:Manifest,R:Manifest](nnzInit: Rep[Int],aIdxInit: Rep[Int],annz: Rep[Int],aIndices: Rep[ForgeArray[Int]],aData: Rep[ForgeArray[A]],bIdxInit: Rep[Int],bnnz: Rep[Int],bIndices: Rep[ForgeArray[Int]],bData: Rep[ForgeArray[B]],outIndices: Rep[ForgeArray[Int]],outData: Rep[ForgeArray[R]],f: (Rep[A],Rep[B]) => Rep[R])(implicit __pos: SourceContext) = {
    reflectWrite(outIndices,outData)(ZipUnion[A,B,R](nnzInit,aIdxInit,annz,aIndices,aData,bIdxInit,bnnz,bIndices,bData,outIndices,outData,f)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos))
  }
  def zipIntersect[A:Manifest,B:Manifest,R:Manifest](nnzInit: Rep[Int],aIdxInit: Rep[Int],annz: Rep[Int],aIndices: Rep[ForgeArray[Int]],aData: Rep[ForgeArray[A]],bIdxInit: Rep[Int],bnnz: Rep[Int],bIndices: Rep[ForgeArray[Int]],bData: Rep[ForgeArray[B]],outIndices: Rep[ForgeArray[Int]],outData: Rep[ForgeArray[R]],f: (Rep[A],Rep[B]) => Rep[R])(implicit __pos: SourceContext) = {
    reflectWrite(outIndices,outData)(ZipIntersect[A,B,R](nnzInit,aIdxInit,annz,aIndices,aData,bIdxInit,bnnz,bIndices,bData,outIndices,outData,f)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos))
  }
  def sparsevector_length[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    field[Int](self,"_length")
  }
  def sparsevector_isrow[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    field[Boolean](self,"_isRow")
  }
  def sparsevector_nnz[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    field[Int](self,"_nnz")
  }
  def sparsevector_nz[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    reflectPure(SparseVector2_Nz[T](self)(implicitly[Manifest[T]],__pos))
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
    reflectPure(SparseVector2_IsEmpty[T](self)(implicitly[Manifest[T]],__pos))
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
    reflectPure(SparseVector2_T[T](self)(implicitly[Manifest[T]],__pos))
  }
  def sparsevector_mt[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsevector_mt_impl1[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_clone[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    reflectPure(SparseVector3_Clone[T](self)(implicitly[Manifest[T]],__pos))
  }
  def sparsevector_mutable[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    reflectMutable(SparseVector5_Mutable[T](self)(implicitly[Manifest[T]],__pos))
  }
  def sparsevector_todense[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsevector_todense_impl3[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_makestring[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]) = {
    reflectPure(SparseVector2_MakeString[T](self)(implicitly[Manifest[T]],__pos,__imp0))
  }
  def sparsevector_tostring[T:Manifest](self: Rep[SparseVector[T]]) = {
    reflectPure(SparseVector7_ToString[T](self))
  }
  def sparsevector_pprint[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]) = {
    sparsevector_pprint_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsevector_raw_data[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    field[ForgeArray[T]](self,"_data")
  }
  def sparsevector_raw_indices[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    field[ForgeArray[Int]](self,"_indices")
  }
  def sparsevector_set_length[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    field_update[Int](self,"_length",__arg1)
  }
  def sparsevector_set_isrow[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Boolean])(implicit __pos: SourceContext) = {
    field_update[Boolean](self,"_isRow",__arg1)
  }
  def sparsevector_set_raw_data[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[ForgeArray[T]])(implicit __pos: SourceContext) = {
    field_update[ForgeArray[T]](self,"_data",__arg1)
  }
  def sparsevector_set_raw_indices[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[ForgeArray[Int]])(implicit __pos: SourceContext) = {
    field_update[ForgeArray[Int]](self,"_indices",__arg1)
  }
  def sparsevector_set_nnz[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    field_update[Int](self,"_nnz",__arg1)
  }
  def sparsevector_update[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],e: Rep[T])(implicit __pos: SourceContext,__imp1: Overload2) = {
    reflectWrite(self)(SparseVector2_Update[T](self,pos,e)(implicitly[Manifest[T]],__pos))
  }
  def sparsevector_update[T:Manifest](self: Rep[SparseVector[T]],indices: Rep[IndexVector],e: Rep[T])(implicit __pos: SourceContext,__imp1: Overload3) = {
    reflectWrite(self)(SparseVector3_Update[T](self,indices,e)(implicitly[Manifest[T]],__pos))
  }
  def sparsevector_update[T:Manifest](self: Rep[SparseVector[T]],indices: Rep[IndexVector],v: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload4) = {
    reflectWrite(self)(SparseVector4_Update[T](self,indices,v)(implicitly[Manifest[T]],__pos))
  }
  def sparsevector_ltlt[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload3) = {
    reflectPure(SparseVector3_Ltlt[T](self,__arg1)(implicitly[Manifest[T]],__pos))
  }
  def sparsevector_ltlt[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload4) = {
    reflectPure(SparseVector4_Ltlt[T](self,__arg1)(implicitly[Manifest[T]],__pos))
  }
  def sparsevector_ltlteq[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload1) = {
    sparsevector_ltlteq_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_ltlteq[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = {
    sparsevector_ltlteq_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_insert_at_off[T:Manifest](self: Rep[SparseVector[T]],off: Rep[Int],pos: Rep[Int],e: Rep[T])(implicit __pos: SourceContext) = {
    reflectWrite(self)(Sparsevector_insert_at_off[T](self,off,pos,e)(implicitly[Manifest[T]],__pos))
  }
  def sparsevector_insert[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext) = {
    reflectWrite(self)(SparseVector1_Insert[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos))
  }
  def sparsevector_insertall[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],xs: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    reflectWrite(self)(SparseVector1_InsertAll[T](self,pos,xs)(implicitly[Manifest[T]],__pos))
  }
  def sparsevector_remove[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    sparsevector_remove_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevector_removeall[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext) = {
    reflectWrite(self)(SparseVector1_RemoveAll[T](self,pos,len)(implicitly[Manifest[T]],__pos))
  }
  def sparsevector_copyfrom[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],xs: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    reflectWrite(self)(SparseVector1_CopyFrom[T](self,pos,xs)(implicitly[Manifest[T]],__pos))
  }
  def sparsevector_trim[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    reflectWrite(self)(SparseVector1_Trim[T](self)(implicitly[Manifest[T]],__pos))
  }
  def sparsevector_clear[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    reflectWrite(self)(SparseVector1_Clear[T](self)(implicitly[Manifest[T]],__pos))
  }
  def sparsevector_insertspace[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext) = {
    reflectWrite(self)(Sparsevector_insertspace[T](self,pos,len)(implicitly[Manifest[T]],__pos))
  }
  def sparsevector_ensureextra[T:Manifest](self: Rep[SparseVector[T]],extra: Rep[Int])(implicit __pos: SourceContext) = {
    reflectWrite(self)(Sparsevector_ensureextra[T](self,extra)(implicitly[Manifest[T]],__pos))
  }
  def sparsevector_realloc[T:Manifest](self: Rep[SparseVector[T]],minLen: Rep[Int])(implicit __pos: SourceContext) = {
    reflectWrite(self)(Sparsevector_realloc[T](self,minLen)(implicitly[Manifest[T]],__pos))
  }
  def zipVectorUnion[T:Manifest,B:Manifest,R:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext) = {
    reflectPure(ZipVectorUnion[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos))
  }
  def zipVectorIntersect[T:Manifest,B:Manifest,R:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext) = {
    reflectPure(ZipVectorIntersect[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos))
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

  /**
   * Syms
   */
  override def syms(e: Any): List[Sym[Any]] = e match {
    case _ => super.syms(e)
  }
  override def boundSyms(e: Any): List[Sym[Any]] = e match {
    case _ => super.boundSyms(e)
  }
  override def symsFreq(e: Any): List[(Sym[Any], Double)] = e match {
    case _ => super.symsFreq(e)
  }

  /**
   * Aliases / Sharing
   */
  override def aliasSyms(e: Any): List[Sym[Any]] = e match {
    case SparseVector3_Clone(self) => Nil
    case SparseVector5_Mutable(self) => Nil
    case _ => super.aliasSyms(e)
  }
  override def containSyms(e: Any): List[Sym[Any]] = e match {
    case SparseVector2_Nz(self) => syms(self)
    case SparseVector3_Clone(self) => Nil
    case SparseVector5_Mutable(self) => Nil
    case _ => super.containSyms(e)
  }
  override def extractSyms(e: Any): List[Sym[Any]] = e match {
    case SparseVector3_Clone(self) => Nil
    case SparseVector5_Mutable(self) => Nil
    case _ => super.extractSyms(e)
  }
  override def copySyms(e: Any): List[Sym[Any]] = e match {
    case SparseVector3_Clone(self) => syms(self)
    case SparseVector5_Mutable(self) => syms(self)
    case _ => super.copySyms(e)
  }

  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@SparseVector13Object_Apply(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with SparseVector13Object_Apply(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVector13Object_Apply(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVector13Object_Apply(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Sparsevector_alloc_raw(__arg0,__arg1,__arg2,__arg3,__arg4) => reflectPure(new { override val original = Some(f,mn) } with Sparsevector_alloc_raw(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Sparsevector_alloc_raw(__arg0,__arg1,__arg2,__arg3,__arg4), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Sparsevector_alloc_raw(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Bsearch(__arg0,__arg1,__arg2,__arg3) => reflectPure(new { override val original = Some(f,mn) } with Bsearch(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Bsearch(__arg0,__arg1,__arg2,__arg3), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Bsearch(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@ZipUnion(__arg0,__arg1,__arg2,__arg3,__arg4,__arg5,__arg6,__arg7,__arg8,__arg9,__arg10,__arg11) => reflectPure(new { override val original = Some(f,mn) } with ZipUnion(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4),f(__arg5),f(__arg6),f(__arg7),f(__arg8),f(__arg9),f(__arg10),f(__arg11))(mtype(mn._mA),mtype(mn._mB),mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@ZipUnion(__arg0,__arg1,__arg2,__arg3,__arg4,__arg5,__arg6,__arg7,__arg8,__arg9,__arg10,__arg11), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with ZipUnion(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4),f(__arg5),f(__arg6),f(__arg7),f(__arg8),f(__arg9),f(__arg10),f(__arg11))(mtype(mn._mA),mtype(mn._mB),mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@ZipIntersect(__arg0,__arg1,__arg2,__arg3,__arg4,__arg5,__arg6,__arg7,__arg8,__arg9,__arg10,__arg11) => reflectPure(new { override val original = Some(f,mn) } with ZipIntersect(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4),f(__arg5),f(__arg6),f(__arg7),f(__arg8),f(__arg9),f(__arg10),f(__arg11))(mtype(mn._mA),mtype(mn._mB),mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@ZipIntersect(__arg0,__arg1,__arg2,__arg3,__arg4,__arg5,__arg6,__arg7,__arg8,__arg9,__arg10,__arg11), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with ZipIntersect(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4),f(__arg5),f(__arg6),f(__arg7),f(__arg8),f(__arg9),f(__arg10),f(__arg11))(mtype(mn._mA),mtype(mn._mB),mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVector2_Nz(__arg0) => reflectPure(new { override val original = Some(f,mn) } with SparseVector2_Nz(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVector2_Nz(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVector2_Nz(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVector2_IsEmpty(__arg0) => reflectPure(new { override val original = Some(f,mn) } with SparseVector2_IsEmpty(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVector2_IsEmpty(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVector2_IsEmpty(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVector2_T(__arg0) => reflectPure(new { override val original = Some(f,mn) } with SparseVector2_T(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVector2_T(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVector2_T(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVector3_Clone(__arg0) => reflectPure(new { override val original = Some(f,mn) } with SparseVector3_Clone(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVector3_Clone(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVector3_Clone(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVector5_Mutable(__arg0) => reflectPure(new { override val original = Some(f,mn) } with SparseVector5_Mutable(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVector5_Mutable(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVector5_Mutable(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVector2_MakeString(__arg0) => reflectPure(new { override val original = Some(f,mn) } with SparseVector2_MakeString(f(__arg0))(mtype(mn._mT),mn.__pos,strtype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVector2_MakeString(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVector2_MakeString(f(__arg0))(mtype(mn._mT),mn.__pos,strtype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVector7_ToString(__arg0) => reflectPure(new { override val original = Some(f,mn) } with SparseVector7_ToString(f(__arg0))(mtype(mn._mT)))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVector7_ToString(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVector7_ToString(f(__arg0))(mtype(mn._mT)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVector2_Update(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with SparseVector2_Update(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVector2_Update(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVector2_Update(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVector3_Update(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with SparseVector3_Update(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVector3_Update(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVector3_Update(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVector4_Update(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with SparseVector4_Update(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVector4_Update(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVector4_Update(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVector3_Ltlt(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with SparseVector3_Ltlt(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVector3_Ltlt(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVector3_Ltlt(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVector4_Ltlt(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with SparseVector4_Ltlt(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVector4_Ltlt(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVector4_Ltlt(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Sparsevector_insert_at_off(__arg0,__arg1,__arg2,__arg3) => reflectPure(new { override val original = Some(f,mn) } with Sparsevector_insert_at_off(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Sparsevector_insert_at_off(__arg0,__arg1,__arg2,__arg3), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Sparsevector_insert_at_off(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVector1_Insert(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with SparseVector1_Insert(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVector1_Insert(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVector1_Insert(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVector1_InsertAll(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with SparseVector1_InsertAll(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVector1_InsertAll(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVector1_InsertAll(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVector1_RemoveAll(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with SparseVector1_RemoveAll(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVector1_RemoveAll(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVector1_RemoveAll(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVector1_CopyFrom(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with SparseVector1_CopyFrom(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVector1_CopyFrom(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVector1_CopyFrom(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVector1_Trim(__arg0) => reflectPure(new { override val original = Some(f,mn) } with SparseVector1_Trim(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVector1_Trim(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVector1_Trim(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVector1_Clear(__arg0) => reflectPure(new { override val original = Some(f,mn) } with SparseVector1_Clear(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVector1_Clear(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVector1_Clear(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Sparsevector_insertspace(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Sparsevector_insertspace(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Sparsevector_insertspace(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Sparsevector_insertspace(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Sparsevector_ensureextra(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with Sparsevector_ensureextra(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Sparsevector_ensureextra(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Sparsevector_ensureextra(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Sparsevector_realloc(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with Sparsevector_realloc(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Sparsevector_realloc(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Sparsevector_realloc(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@ZipVectorUnion(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with ZipVectorUnion(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mB),mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@ZipVectorUnion(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with ZipVectorUnion(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mB),mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@ZipVectorIntersect(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with ZipVectorIntersect(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mB),mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@ZipVectorIntersect(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with ZipVectorIntersect(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mB),mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[SparseVector[_]]) Some((classTag(m), collection.immutable.List(("_length",manifest[Int]),("_isRow",manifest[Boolean]),("_data",makeManifest(classOf[ForgeArray[_]], List(m.typeArguments(0)))),("_indices",makeManifest(classOf[ForgeArray[_]], List(manifest[Int]))),("_nnz",manifest[Int]))))
    else super.unapplyStructType(m)
  }
}

