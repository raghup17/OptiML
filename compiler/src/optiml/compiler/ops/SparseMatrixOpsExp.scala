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

trait SparseMatrixOpsExp extends SparseMatrixCompilerOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class SparseMatrix27Object_Apply[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends DeliteStruct[SparseMatrixBuildable[T]] {
    val _mT = implicitly[Manifest[T]]
    val elems = copyTransformedElems(collection.Seq(("_numRows",var_new(__arg0).e),("_numCols",var_new(__arg1).e),("_data",var_new(array_empty[T](unit(32))).e),("_colIndices",var_new(array_empty[Int](unit(32))).e),("_rowIndices",var_new(array_empty[Int](unit(32))).e),("_nnz",var_new(unit(0)).e)))
  }

  case class SparseMatrix2Object_Diag[T:Arith:Manifest](__arg0: Rep[Int],__arg1: Rep[SparseVector[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[SparseMatrix[T]](reifyEffectsHere(sparsematrix_object_diag_impl2[T](__arg0,__arg1)(implicitly[Arith[T]],implicitly[Manifest[T]],__pos))) {
    val _aT = implicitly[Arith[T]]
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseMatrix3Object_Identity(__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[SparseMatrix[Double]](reifyEffectsHere(sparsematrix_object_identity_impl3(__arg0,__arg1)(__pos))) {
  }

  case class Sparsematrix_csr_alloc_raw[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[ForgeArray[T]],__arg3: Rep[ForgeArray[Int]],__arg4: Rep[ForgeArray[Int]],__arg5: Rep[Int])(implicit val __pos: SourceContext) extends DeliteStruct[SparseMatrix[T]] {
    val _mT = implicitly[Manifest[T]]
    val elems = copyTransformedElems(collection.Seq(("_numRows",__arg0),("_numCols",__arg1),("_data",__arg2),("_colIndices",__arg3),("_rowPtr",__arg4),("_nnz",__arg5)))
  }

  case class Sparsematrix_rand[T:Manifest](numRows: Rep[Int],numCols: Rep[Int],sparsity: Rep[Double],gen: (Rep[Int]) => Rep[T])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[SparseMatrix[T]](reifyEffectsHere(sparsematrix_rand_impl[T](numRows,numCols,sparsity,gen)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Sparsematrix_csr_find_offset[T:Manifest](self: Rep[SparseMatrix[T]],row: Rep[Int],col: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Int](reifyEffectsHere(sparsematrix_csr_find_offset_impl[T](self,row,col)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseMatrix2_RowIndices[T:Manifest](self: Rep[SparseMatrix[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[IndexVector](reifyEffectsHere(sparsematrix_rowindices_impl2[T](self)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseMatrix2_ColIndices[T:Manifest](self: Rep[SparseMatrix[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[IndexVector](reifyEffectsHere(sparsematrix_colindices_impl2[T](self)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Sparsematrix_vview[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[Int],__arg4: Rep[Boolean])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[SparseVectorView[T]](reifyEffectsHere(sparsematrix_vview_impl[T](self,__arg1,__arg2,__arg3,__arg4)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseMatrix2_GetRows[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[IndexVector])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[SparseMatrix[T]](reifyEffectsHere(sparsematrix_getrows_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseMatrix5_T[T:Manifest](self: Rep[SparseMatrix[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[SparseMatrix[T]](reifyEffectsHere(sparsematrix_t_impl5[T](self)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseMatrix17_Mutable[T:Manifest](self: Rep[SparseMatrix[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[SparseMatrixBuildable[T]](reifyEffectsHere(sparsematrix_mutable_impl17[T](self)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseMatrix7_MakeString[T:Manifest](self: Rep[SparseMatrix[T]])(implicit val __pos: SourceContext,val __imp0: Stringable[T]) extends DeliteOpSingleTask[String](reifyEffectsHere(sparsematrix_makestring_impl7[T](self)(implicitly[Manifest[T]],__pos,__imp0))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseMatrix16_ToString[T:Manifest](self: Rep[SparseMatrix[T]]) extends DeliteOpSingleTask[String](reifyEffectsHere(sparsematrix_tostring_impl16[T](self))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Sparematrix_csr_update[T:Manifest](self: Rep[SparseMatrix[T]],i: Rep[Int],j: Rep[Int],y: Rep[T])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparematrix_csr_update_impl[T](self,i,j,y)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Sparsematrix_csr_ensureextra[T:Manifest](self: Rep[SparseMatrix[T]],extra: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsematrix_csr_ensureextra_impl[T](self,extra)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Sparsematrix_csr_realloc[T:Manifest](self: Rep[SparseMatrix[T]],minLen: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsematrix_csr_realloc_impl[T](self,minLen)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Sparsematrix_csr_insertspace[T:Manifest](self: Rep[SparseMatrix[T]],pos: Rep[Int],len: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsematrix_csr_insertspace_impl[T](self,pos,len)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class ZipMatrixUnion[T:Manifest,B:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[SparseMatrix[R]](reifyEffectsHere(zipMatrixUnion_impl[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos))) {
    val _mT = implicitly[Manifest[T]]
    val _mB = implicitly[Manifest[B]]
    val _mR = implicitly[Manifest[R]]
  }

  case class ZipMatrixIntersect[T:Manifest,B:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[SparseMatrix[R]](reifyEffectsHere(zipMatrixIntersect_impl[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos))) {
    val _mT = implicitly[Manifest[T]]
    val _mB = implicitly[Manifest[B]]
    val _mR = implicitly[Manifest[R]]
  }

  case class SparseMatrix2_MapRowsToVector[T:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[SparseVector[R]](reifyEffectsHere(sparsematrix_maprowstovector_impl2[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos))) {
    val _mT = implicitly[Manifest[T]]
    val _mR = implicitly[Manifest[R]]
  }

  case class SparseMatrix2_MapColsToVector[T:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[SparseVector[R]](reifyEffectsHere(sparsematrix_mapcolstovector_impl2[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos))) {
    val _mT = implicitly[Manifest[T]]
    val _mR = implicitly[Manifest[R]]
  }



  def sparsematrix_object_apply[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectMutable(SparseMatrix27Object_Apply[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos))
  }
  def sparsematrix_object_diag[T:Arith:Manifest](__arg0: Rep[Int],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    reflectPure(SparseMatrix2Object_Diag[T](__arg0,__arg1)(implicitly[Arith[T]],implicitly[Manifest[T]],__pos))
  }
  def sparsematrix_object_identity(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload3) = {
    reflectPure(SparseMatrix3Object_Identity(__arg0,__arg1)(__pos))
  }
  def sparsematrix_csr_alloc_raw[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[ForgeArray[T]],__arg3: Rep[ForgeArray[Int]],__arg4: Rep[ForgeArray[Int]],__arg5: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Sparsematrix_csr_alloc_raw[T](__arg0,__arg1,__arg2,__arg3,__arg4,__arg5)(implicitly[Manifest[T]],__pos))
  }
  def sparsematrix_object_zeros(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrix_object_zeros_impl4(__arg0,__arg1)(__pos)
  }
  def sparsematrix_object_zerosf(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrix_object_zerosf_impl4(__arg0,__arg1)(__pos)
  }
  def sparsematrix_rand[T:Manifest](numRows: Rep[Int],numCols: Rep[Int],sparsity: Rep[Double],gen: (Rep[Int]) => Rep[T])(implicit __pos: SourceContext) = {
    reflectPure(Sparsematrix_rand[T](numRows,numCols,sparsity,gen)(implicitly[Manifest[T]],__pos))
  }
  def sparsematrix_object_rand(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Double])(implicit __pos: SourceContext) = {
    sparsematrix_object_rand_impl4(__arg0,__arg1,__arg2)(__pos)
  }
  def sparsematrix_object_randf(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Double])(implicit __pos: SourceContext) = {
    sparsematrix_object_randf_impl4(__arg0,__arg1,__arg2)(__pos)
  }
  def sparsematrix_object_randn(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Double])(implicit __pos: SourceContext) = {
    sparsematrix_object_randn_impl2(__arg0,__arg1,__arg2)(__pos)
  }
  def sparsematrix_object_randnf(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Double])(implicit __pos: SourceContext) = {
    sparsematrix_object_randnf_impl2(__arg0,__arg1,__arg2)(__pos)
  }
  def sparsematrix_numrows[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    field[Int](self,"_numRows")
  }
  def sparsematrix_numcols[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    field[Int](self,"_numCols")
  }
  def sparsematrix_size[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    sparsematrix_size_impl15[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_nnz[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    field[Int](self,"_nnz")
  }
  def sparsematrix_nz[T:Manifest](self: Rep[SparseMatrix[T]],asRow: Rep[Boolean] = unit(true))(implicit __pos: SourceContext) = {
    sparsematrix_nz_impl3[T](self,asRow)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_csr_find_offset[T:Manifest](self: Rep[SparseMatrix[T]],row: Rep[Int],col: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Sparsematrix_csr_find_offset[T](self,row,col)(implicitly[Manifest[T]],__pos))
  }
  def sparsematrix_apply[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload29) = {
    sparsematrix_apply_impl29[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_apply[T:Manifest](self: Rep[SparseMatrix[T]],rows: Rep[IndexVector],cols: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload33) = {
    sparsematrix_apply_impl33[T](self,rows,cols)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_rowindices[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    reflectPure(SparseMatrix2_RowIndices[T](self)(implicitly[Manifest[T]],__pos))
  }
  def sparsematrix_colindices[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    reflectPure(SparseMatrix2_ColIndices[T](self)(implicitly[Manifest[T]],__pos))
  }
  def sparsematrix_vview[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[Int],__arg4: Rep[Boolean])(implicit __pos: SourceContext) = {
    reflectPure(Sparsematrix_vview[T](self,__arg1,__arg2,__arg3,__arg4)(implicitly[Manifest[T]],__pos))
  }
  def sparsematrix_getrow[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrix_getrow_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_getrows[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext) = {
    reflectPure(SparseMatrix2_GetRows[T](self,__arg1)(implicitly[Manifest[T]],__pos))
  }
  def sparsematrix_getcol[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrix_getcol_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_getcols[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext) = {
    sparsematrix_getcols_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_t[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    reflectPure(SparseMatrix5_T[T](self)(implicitly[Manifest[T]],__pos))
  }
  def sparsematrix_clone[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    sparsematrix_clone_impl7[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_mutable[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    reflectMutable(SparseMatrix17_Mutable[T](self)(implicitly[Manifest[T]],__pos))
  }
  def sparsematrix_todense[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    sparsematrix_todense_impl5[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_pprint[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]) = {
    sparsematrix_pprint_impl7[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_makestring[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]) = {
    reflectPure(SparseMatrix7_MakeString[T](self)(implicitly[Manifest[T]],__pos,__imp0))
  }
  def sparsematrix_tostring[T:Manifest](self: Rep[SparseMatrix[T]]) = {
    reflectPure(SparseMatrix16_ToString[T](self))
  }
  def sparsematrix_csr_data[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    field[ForgeArray[T]](self,"_data")
  }
  def sparsematrix_csr_rowptr[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    field[ForgeArray[Int]](self,"_rowPtr")
  }
  def sparsematrix_csr_colindices[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
    field[ForgeArray[Int]](self,"_colIndices")
  }
  def sparsematrix_csr_set_numrows[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    field_update[Int](self,"_numRows",__arg1)
  }
  def sparsematrix_csr_set_numcols[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    field_update[Int](self,"_numCols",__arg1)
  }
  def sparsematrix_csr_set_data[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[ForgeArray[T]])(implicit __pos: SourceContext) = {
    field_update[ForgeArray[T]](self,"_data",__arg1)
  }
  def sparsematrix_csr_set_rowptr[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[ForgeArray[Int]])(implicit __pos: SourceContext) = {
    field_update[ForgeArray[Int]](self,"_rowPtr",__arg1)
  }
  def sparsematrix_csr_set_colindices[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[ForgeArray[Int]])(implicit __pos: SourceContext) = {
    field_update[ForgeArray[Int]](self,"_colIndices",__arg1)
  }
  def sparsematrix_csr_set_nnz[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    field_update[Int](self,"_nnz",__arg1)
  }
  def sparematrix_csr_update[T:Manifest](self: Rep[SparseMatrix[T]],i: Rep[Int],j: Rep[Int],y: Rep[T])(implicit __pos: SourceContext) = {
    reflectWrite(self)(Sparematrix_csr_update[T](self,i,j,y)(implicitly[Manifest[T]],__pos))
  }
  def sparsematrix_csr_ensureextra[T:Manifest](self: Rep[SparseMatrix[T]],extra: Rep[Int])(implicit __pos: SourceContext) = {
    reflectWrite(self)(Sparsematrix_csr_ensureextra[T](self,extra)(implicitly[Manifest[T]],__pos))
  }
  def sparsematrix_csr_realloc[T:Manifest](self: Rep[SparseMatrix[T]],minLen: Rep[Int])(implicit __pos: SourceContext) = {
    reflectWrite(self)(Sparsematrix_csr_realloc[T](self,minLen)(implicitly[Manifest[T]],__pos))
  }
  def sparsematrix_csr_insertspace[T:Manifest](self: Rep[SparseMatrix[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext) = {
    reflectWrite(self)(Sparsematrix_csr_insertspace[T](self,pos,len)(implicitly[Manifest[T]],__pos))
  }
  def zipMatrixUnion[T:Manifest,B:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext) = {
    reflectPure(ZipMatrixUnion[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos))
  }
  def zipMatrixIntersect[T:Manifest,B:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext) = {
    reflectPure(ZipMatrixIntersect[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos))
  }
  def sparsematrix_pl[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload136) = {
    sparsematrix_pl_impl136[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_pl[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload137) = {
    sparsematrix_pl_impl137[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_pl[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload138) = {
    sparsematrix_pl_impl138[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_sub[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload102) = {
    sparsematrix_sub_impl102[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_sub[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload103) = {
    sparsematrix_sub_impl103[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_sub[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload104) = {
    sparsematrix_sub_impl104[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_mulclnmul[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload26) = {
    sparsematrix_mulclnmul_impl26[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_mulclnmul[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload27) = {
    sparsematrix_mulclnmul_impl27[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_mul[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    sparsematrix_mul_impl142[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_div[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload103) = {
    sparsematrix_div_impl103[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_div[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload104) = {
    sparsematrix_div_impl104[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_div[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload105) = {
    sparsematrix_div_impl105[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_sum[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    sparsematrix_sum_impl6[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_mean[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]) = {
    sparsematrix_mean_impl6[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def sparsematrix_abs[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    sparsematrix_abs_impl22[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_sumrows[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    sparsematrix_sumrows_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_sumcols[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    sparsematrix_sumcols_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_min[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    sparsematrix_min_impl7[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_max[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    sparsematrix_max_impl7[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_minrows[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    sparsematrix_minrows_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_mincols[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    sparsematrix_mincols_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_maxrows[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    sparsematrix_maxrows_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix_maxcols[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    sparsematrix_maxcols_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrix___equal[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload16) = {
    sparsematrix___equal_impl16[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix___equal[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload17) = {
    sparsematrix___equal_impl17[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_mapnz[T:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext) = {
    sparsematrix_mapnz_impl2[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def sparsematrix_foreachnz[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext) = {
    sparsematrix_foreachnz_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_countnz[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    sparsematrix_countnz_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_maprowstovector[T:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[R])(implicit __pos: SourceContext) = {
    reflectPure(SparseMatrix2_MapRowsToVector[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos))
  }
  def sparsematrix_mapcolstovector[T:Manifest,R:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[R])(implicit __pos: SourceContext) = {
    reflectPure(SparseMatrix2_MapColsToVector[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos))
  }
  def sparsematrix_findrows[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    sparsematrix_findrows_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_findcols[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    sparsematrix_findcols_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_filterrows[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    sparsematrix_filterrows_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_filtercols[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    sparsematrix_filtercols_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_foreachrow[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Unit])(implicit __pos: SourceContext) = {
    sparsematrix_foreachrow_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_foreachcol[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: (Rep[SparseVectorView[T]]) => Rep[Unit])(implicit __pos: SourceContext) = {
    sparsematrix_foreachcol_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
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
    case SparseMatrix17_Mutable(self) => Nil
    case _ => super.aliasSyms(e)
  }
  override def containSyms(e: Any): List[Sym[Any]] = e match {
    case Sparsematrix_vview(self,__arg1,__arg2,__arg3,__arg4) => syms(self)
    case SparseMatrix17_Mutable(self) => Nil
    case _ => super.containSyms(e)
  }
  override def extractSyms(e: Any): List[Sym[Any]] = e match {
    case SparseMatrix17_Mutable(self) => Nil
    case _ => super.extractSyms(e)
  }
  override def copySyms(e: Any): List[Sym[Any]] = e match {
    case SparseMatrix17_Mutable(self) => syms(self)
    case _ => super.copySyms(e)
  }

  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@SparseMatrix27Object_Apply(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with SparseMatrix27Object_Apply(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseMatrix27Object_Apply(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseMatrix27Object_Apply(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseMatrix2Object_Diag(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with SparseMatrix2Object_Diag(f(__arg0),f(__arg1))(atype(mn._aT),mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseMatrix2Object_Diag(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseMatrix2Object_Diag(f(__arg0),f(__arg1))(atype(mn._aT),mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseMatrix3Object_Identity(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with SparseMatrix3Object_Identity(f(__arg0),f(__arg1))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseMatrix3Object_Identity(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseMatrix3Object_Identity(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Sparsematrix_csr_alloc_raw(__arg0,__arg1,__arg2,__arg3,__arg4,__arg5) => reflectPure(new { override val original = Some(f,mn) } with Sparsematrix_csr_alloc_raw(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4),f(__arg5))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Sparsematrix_csr_alloc_raw(__arg0,__arg1,__arg2,__arg3,__arg4,__arg5), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Sparsematrix_csr_alloc_raw(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4),f(__arg5))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Sparsematrix_rand(__arg0,__arg1,__arg2,__arg3) => reflectPure(new { override val original = Some(f,mn) } with Sparsematrix_rand(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Sparsematrix_rand(__arg0,__arg1,__arg2,__arg3), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Sparsematrix_rand(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Sparsematrix_csr_find_offset(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Sparsematrix_csr_find_offset(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Sparsematrix_csr_find_offset(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Sparsematrix_csr_find_offset(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseMatrix2_RowIndices(__arg0) => reflectPure(new { override val original = Some(f,mn) } with SparseMatrix2_RowIndices(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseMatrix2_RowIndices(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseMatrix2_RowIndices(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseMatrix2_ColIndices(__arg0) => reflectPure(new { override val original = Some(f,mn) } with SparseMatrix2_ColIndices(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseMatrix2_ColIndices(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseMatrix2_ColIndices(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Sparsematrix_vview(__arg0,__arg1,__arg2,__arg3,__arg4) => reflectPure(new { override val original = Some(f,mn) } with Sparsematrix_vview(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Sparsematrix_vview(__arg0,__arg1,__arg2,__arg3,__arg4), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Sparsematrix_vview(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseMatrix2_GetRows(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with SparseMatrix2_GetRows(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseMatrix2_GetRows(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseMatrix2_GetRows(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseMatrix5_T(__arg0) => reflectPure(new { override val original = Some(f,mn) } with SparseMatrix5_T(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseMatrix5_T(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseMatrix5_T(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseMatrix17_Mutable(__arg0) => reflectPure(new { override val original = Some(f,mn) } with SparseMatrix17_Mutable(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseMatrix17_Mutable(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseMatrix17_Mutable(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseMatrix7_MakeString(__arg0) => reflectPure(new { override val original = Some(f,mn) } with SparseMatrix7_MakeString(f(__arg0))(mtype(mn._mT),mn.__pos,strtype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseMatrix7_MakeString(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseMatrix7_MakeString(f(__arg0))(mtype(mn._mT),mn.__pos,strtype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseMatrix16_ToString(__arg0) => reflectPure(new { override val original = Some(f,mn) } with SparseMatrix16_ToString(f(__arg0))(mtype(mn._mT)))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseMatrix16_ToString(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseMatrix16_ToString(f(__arg0))(mtype(mn._mT)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Sparematrix_csr_update(__arg0,__arg1,__arg2,__arg3) => reflectPure(new { override val original = Some(f,mn) } with Sparematrix_csr_update(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Sparematrix_csr_update(__arg0,__arg1,__arg2,__arg3), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Sparematrix_csr_update(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Sparsematrix_csr_ensureextra(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with Sparsematrix_csr_ensureextra(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Sparsematrix_csr_ensureextra(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Sparsematrix_csr_ensureextra(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Sparsematrix_csr_realloc(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with Sparsematrix_csr_realloc(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Sparsematrix_csr_realloc(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Sparsematrix_csr_realloc(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Sparsematrix_csr_insertspace(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Sparsematrix_csr_insertspace(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Sparsematrix_csr_insertspace(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Sparsematrix_csr_insertspace(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@ZipMatrixUnion(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with ZipMatrixUnion(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mB),mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@ZipMatrixUnion(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with ZipMatrixUnion(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mB),mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@ZipMatrixIntersect(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with ZipMatrixIntersect(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mB),mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@ZipMatrixIntersect(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with ZipMatrixIntersect(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mB),mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseMatrix2_MapRowsToVector(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with SparseMatrix2_MapRowsToVector(f(__arg0),f(__arg1))(mtype(mn._mT),mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseMatrix2_MapRowsToVector(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseMatrix2_MapRowsToVector(f(__arg0),f(__arg1))(mtype(mn._mT),mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseMatrix2_MapColsToVector(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with SparseMatrix2_MapColsToVector(f(__arg0),f(__arg1))(mtype(mn._mT),mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseMatrix2_MapColsToVector(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseMatrix2_MapColsToVector(f(__arg0),f(__arg1))(mtype(mn._mT),mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[SparseMatrix[_]]) Some((classTag(m), collection.immutable.List(("_numRows",manifest[Int]),("_numCols",manifest[Int]),("_data",makeManifest(classOf[ForgeArray[_]], List(m.typeArguments(0)))),("_colIndices",makeManifest(classOf[ForgeArray[_]], List(manifest[Int]))),("_rowPtr",makeManifest(classOf[ForgeArray[_]], List(manifest[Int]))),("_nnz",manifest[Int]))))
    else super.unapplyStructType(m)
  }
}

