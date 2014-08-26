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

trait SparseMatrixBuildableOpsExp extends SparseMatrixBuildableCompilerOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class Sparsematrix_coo_find_offset[T:Manifest](self: Rep[SparseMatrixBuildable[T]],row: Rep[Int],col: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Int](reifyEffectsHere(sparsematrix_coo_find_offset_impl[T](self,row,col)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseMatrixBuildable3_MakeString[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit val __pos: SourceContext,val __imp0: Stringable[T]) extends DeliteOpSingleTask[String](reifyEffectsHere(sparsematrixbuildable_makestring_impl3[T](self)(implicitly[Manifest[T]],__pos,__imp0))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseMatrixBuildable9_ToString[T:Manifest](self: Rep[SparseMatrixBuildable[T]]) extends DeliteOpSingleTask[String](reifyEffectsHere(sparsematrixbuildable_tostring_impl9[T](self))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseMatrixBuildable8_Mutable[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit val __pos: SourceContext) extends DeliteStruct[SparseMatrixBuildable[T]] {
    val _mT = implicitly[Manifest[T]]
    val elems = copyTransformedElems(collection.Seq(("_numRows",var_new(sparsematrixbuildable_numrows(self)).e),("_numCols",var_new(sparsematrixbuildable_numcols(self)).e),("_data",var_new(array_clone(sparsematrix_coo_data(self))).e),("_colIndices",var_new(array_clone(sparsematrix_coo_colindices(self))).e),("_rowIndices",var_new(array_clone(sparsematrix_coo_rowindices(self))).e),("_nnz",var_new(sparsematrixbuildable_nnz(self)).e)))
  }

  case class SparseMatrixBuildable_Append[T:Manifest](self: Rep[SparseMatrixBuildable[T]],i: Rep[Int],j: Rep[Int],y: Rep[T],alwaysWrite: Rep[Boolean] = unit(true))(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsematrixbuildable_append_impl[T](self,i,j,y,alwaysWrite)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseMatrixBuildable1_InsertRow[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],y: Rep[SparseVector[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsematrixbuildable_insertrow_impl1[T](self,pos,y)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseMatrixBuildable1_InsertCol[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],y: Rep[SparseVector[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsematrixbuildable_insertcol_impl1[T](self,pos,y)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseMatrixBuildable1_RemoveRows[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],num: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsematrixbuildable_removerows_impl1[T](self,pos,num)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseMatrixBuildable1_RemoveCols[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],num: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsematrixbuildable_removecols_impl1[T](self,pos,num)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Sparsematrix_coo_ensureextra[T:Manifest](self: Rep[SparseMatrixBuildable[T]],extra: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsematrix_coo_ensureextra_impl[T](self,extra)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Sparsematrix_coo_realloc[T:Manifest](self: Rep[SparseMatrixBuildable[T]],minLen: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(sparsematrix_coo_realloc_impl[T](self,minLen)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Coo_to_csr[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[SparseMatrix[T]](reifyEffectsHere(coo_to_csr_impl[T](self)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Coo_ordered[T:Manifest](self: Rep[SparseMatrixBuildable[T]],nnz: Rep[Int],rowIndices: Rep[ForgeArray[Int]],colIndices: Rep[ForgeArray[Int]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Boolean](reifyEffectsHere(coo_ordered_impl[T](self,nnz,rowIndices,colIndices)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Coo_to_csr_ordered[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[SparseMatrix[T]](reifyEffectsHere(coo_to_csr_ordered_impl[T](self)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Coo_to_csr_unordered[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[SparseMatrix[T]](reifyEffectsHere(coo_to_csr_unordered_impl[T](self)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Coo_to_csr_finalize[T:Manifest](self: Rep[SparseMatrixBuildable[T]],outData: Rep[ForgeArray[T]],outColIndices: Rep[ForgeArray[Int]],outRowPtr: Rep[ForgeArray[Int]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[SparseMatrix[T]](reifyEffectsHere(coo_to_csr_finalize_impl[T](self,outData,outColIndices,outRowPtr)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }



  def sparsematrixbuildable_numrows[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    field[Int](self,"_numRows")
  }
  def sparsematrixbuildable_numcols[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    field[Int](self,"_numCols")
  }
  def sparsematrixbuildable_nnz[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    field[Int](self,"_nnz")
  }
  def sparsematrixbuildable_size[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    sparsematrixbuildable_size_impl7[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrix_coo_find_offset[T:Manifest](self: Rep[SparseMatrixBuildable[T]],row: Rep[Int],col: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Sparsematrix_coo_find_offset[T](self,row,col)(implicitly[Manifest[T]],__pos))
  }
  def sparsematrixbuildable_apply[T:Manifest](self: Rep[SparseMatrixBuildable[T]],i: Rep[Int],j: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrixbuildable_apply_impl18[T](self,i,j)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrixbuildable_pprint[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]) = {
    sparsematrixbuildable_pprint_impl3[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def sparsematrixbuildable_makestring[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]) = {
    reflectPure(SparseMatrixBuildable3_MakeString[T](self)(implicitly[Manifest[T]],__pos,__imp0))
  }
  def sparsematrixbuildable_tostring[T:Manifest](self: Rep[SparseMatrixBuildable[T]]) = {
    reflectPure(SparseMatrixBuildable9_ToString[T](self))
  }
  def sparsematrixbuildable_mutable[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    reflectMutable(SparseMatrixBuildable8_Mutable[T](self)(implicitly[Manifest[T]],__pos))
  }
  def sparsematrix_coo_data[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    field[ForgeArray[T]](self,"_data")
  }
  def sparsematrix_coo_rowindices[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    field[ForgeArray[Int]](self,"_rowIndices")
  }
  def sparsematrix_coo_colindices[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    field[ForgeArray[Int]](self,"_colIndices")
  }
  def sparsematrix_coo_set_numrows[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    field_update[Int](self,"_numRows",__arg1)
  }
  def sparsematrix_coo_set_numcols[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    field_update[Int](self,"_numCols",__arg1)
  }
  def sparsematrix_coo_set_data[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[ForgeArray[T]])(implicit __pos: SourceContext) = {
    field_update[ForgeArray[T]](self,"_data",__arg1)
  }
  def sparsematrix_coo_set_rowindices[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[ForgeArray[Int]])(implicit __pos: SourceContext) = {
    field_update[ForgeArray[Int]](self,"_rowIndices",__arg1)
  }
  def sparsematrix_coo_set_colindices[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[ForgeArray[Int]])(implicit __pos: SourceContext) = {
    field_update[ForgeArray[Int]](self,"_colIndices",__arg1)
  }
  def sparsematrix_coo_set_nnz[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    field_update[Int](self,"_nnz",__arg1)
  }
  def sparsematrixbuildable_update[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[T])(implicit __pos: SourceContext) = {
    sparsematrixbuildable_update_impl6[T](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrixbuildable_append[T:Manifest](self: Rep[SparseMatrixBuildable[T]],i: Rep[Int],j: Rep[Int],y: Rep[T],alwaysWrite: Rep[Boolean] = unit(true))(implicit __pos: SourceContext) = {
    reflectWrite(self)(SparseMatrixBuildable_Append[T](self,i,j,y,alwaysWrite)(implicitly[Manifest[T]],__pos))
  }
  def sparsematrixbuildable_ltlteq[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsematrixbuildable_ltlteq_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrixbuildable_ltltoreq[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    sparsematrixbuildable_ltltoreq_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrixbuildable_insertrow[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],y: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    reflectWrite(self)(SparseMatrixBuildable1_InsertRow[T](self,pos,y)(implicitly[Manifest[T]],__pos))
  }
  def sparsematrixbuildable_insertcol[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],y: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
    reflectWrite(self)(SparseMatrixBuildable1_InsertCol[T](self,pos,y)(implicitly[Manifest[T]],__pos))
  }
  def sparsematrixbuildable_removerow[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrixbuildable_removerow_impl1[T](self,pos)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrixbuildable_removecol[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int])(implicit __pos: SourceContext) = {
    sparsematrixbuildable_removecol_impl1[T](self,pos)(implicitly[Manifest[T]],__pos)
  }
  def sparsematrixbuildable_removerows[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],num: Rep[Int])(implicit __pos: SourceContext) = {
    reflectWrite(self)(SparseMatrixBuildable1_RemoveRows[T](self,pos,num)(implicitly[Manifest[T]],__pos))
  }
  def sparsematrixbuildable_removecols[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],num: Rep[Int])(implicit __pos: SourceContext) = {
    reflectWrite(self)(SparseMatrixBuildable1_RemoveCols[T](self,pos,num)(implicitly[Manifest[T]],__pos))
  }
  def sparsematrix_coo_ensureextra[T:Manifest](self: Rep[SparseMatrixBuildable[T]],extra: Rep[Int])(implicit __pos: SourceContext) = {
    reflectWrite(self)(Sparsematrix_coo_ensureextra[T](self,extra)(implicitly[Manifest[T]],__pos))
  }
  def sparsematrix_coo_realloc[T:Manifest](self: Rep[SparseMatrixBuildable[T]],minLen: Rep[Int])(implicit __pos: SourceContext) = {
    reflectWrite(self)(Sparsematrix_coo_realloc[T](self,minLen)(implicitly[Manifest[T]],__pos))
  }
  def sparsematrixbuildable_finish[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    sparsematrixbuildable_finish_impl[T](self)(implicitly[Manifest[T]],__pos)
  }
  def coo_to_csr[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    reflectPure(Coo_to_csr[T](self)(implicitly[Manifest[T]],__pos))
  }
  def coo_ordered[T:Manifest](self: Rep[SparseMatrixBuildable[T]],nnz: Rep[Int],rowIndices: Rep[ForgeArray[Int]],colIndices: Rep[ForgeArray[Int]])(implicit __pos: SourceContext) = {
    reflectPure(Coo_ordered[T](self,nnz,rowIndices,colIndices)(implicitly[Manifest[T]],__pos))
  }
  def coo_to_csr_ordered[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    reflectPure(Coo_to_csr_ordered[T](self)(implicitly[Manifest[T]],__pos))
  }
  def coo_to_csr_unordered[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
    reflectPure(Coo_to_csr_unordered[T](self)(implicitly[Manifest[T]],__pos))
  }
  def coo_to_csr_finalize[T:Manifest](self: Rep[SparseMatrixBuildable[T]],outData: Rep[ForgeArray[T]],outColIndices: Rep[ForgeArray[Int]],outRowPtr: Rep[ForgeArray[Int]])(implicit __pos: SourceContext) = {
    reflectPure(Coo_to_csr_finalize[T](self,outData,outColIndices,outRowPtr)(implicitly[Manifest[T]],__pos))
  }


  /**
   * Aliases / Sharing
   */
  override def aliasSyms(e: Any): List[Sym[Any]] = e match {
    case SparseMatrixBuildable8_Mutable(self) => Nil
    case _ => super.aliasSyms(e)
  }
  override def containSyms(e: Any): List[Sym[Any]] = e match {
    case SparseMatrixBuildable8_Mutable(self) => Nil
    case _ => super.containSyms(e)
  }
  override def extractSyms(e: Any): List[Sym[Any]] = e match {
    case SparseMatrixBuildable8_Mutable(self) => Nil
    case _ => super.extractSyms(e)
  }
  override def copySyms(e: Any): List[Sym[Any]] = e match {
    case SparseMatrixBuildable8_Mutable(self) => syms(self)
    case _ => super.copySyms(e)
  }

  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Sparsematrix_coo_find_offset(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Sparsematrix_coo_find_offset(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Sparsematrix_coo_find_offset(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Sparsematrix_coo_find_offset(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseMatrixBuildable3_MakeString(__arg0) => reflectPure(new { override val original = Some(f,mn) } with SparseMatrixBuildable3_MakeString(f(__arg0))(mtype(mn._mT),mn.__pos,strtype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseMatrixBuildable3_MakeString(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseMatrixBuildable3_MakeString(f(__arg0))(mtype(mn._mT),mn.__pos,strtype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseMatrixBuildable9_ToString(__arg0) => reflectPure(new { override val original = Some(f,mn) } with SparseMatrixBuildable9_ToString(f(__arg0))(mtype(mn._mT)))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseMatrixBuildable9_ToString(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseMatrixBuildable9_ToString(f(__arg0))(mtype(mn._mT)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseMatrixBuildable8_Mutable(__arg0) => reflectPure(new { override val original = Some(f,mn) } with SparseMatrixBuildable8_Mutable(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseMatrixBuildable8_Mutable(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseMatrixBuildable8_Mutable(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseMatrixBuildable_Append(__arg0,__arg1,__arg2,__arg3,__arg4) => reflectPure(new { override val original = Some(f,mn) } with SparseMatrixBuildable_Append(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseMatrixBuildable_Append(__arg0,__arg1,__arg2,__arg3,__arg4), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseMatrixBuildable_Append(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseMatrixBuildable1_InsertRow(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with SparseMatrixBuildable1_InsertRow(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseMatrixBuildable1_InsertRow(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseMatrixBuildable1_InsertRow(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseMatrixBuildable1_InsertCol(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with SparseMatrixBuildable1_InsertCol(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseMatrixBuildable1_InsertCol(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseMatrixBuildable1_InsertCol(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseMatrixBuildable1_RemoveRows(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with SparseMatrixBuildable1_RemoveRows(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseMatrixBuildable1_RemoveRows(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseMatrixBuildable1_RemoveRows(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseMatrixBuildable1_RemoveCols(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with SparseMatrixBuildable1_RemoveCols(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseMatrixBuildable1_RemoveCols(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseMatrixBuildable1_RemoveCols(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Sparsematrix_coo_ensureextra(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with Sparsematrix_coo_ensureextra(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Sparsematrix_coo_ensureextra(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Sparsematrix_coo_ensureextra(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Sparsematrix_coo_realloc(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with Sparsematrix_coo_realloc(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Sparsematrix_coo_realloc(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Sparsematrix_coo_realloc(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Coo_to_csr(__arg0) => reflectPure(new { override val original = Some(f,mn) } with Coo_to_csr(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Coo_to_csr(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Coo_to_csr(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Coo_ordered(__arg0,__arg1,__arg2,__arg3) => reflectPure(new { override val original = Some(f,mn) } with Coo_ordered(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Coo_ordered(__arg0,__arg1,__arg2,__arg3), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Coo_ordered(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Coo_to_csr_ordered(__arg0) => reflectPure(new { override val original = Some(f,mn) } with Coo_to_csr_ordered(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Coo_to_csr_ordered(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Coo_to_csr_ordered(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Coo_to_csr_unordered(__arg0) => reflectPure(new { override val original = Some(f,mn) } with Coo_to_csr_unordered(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Coo_to_csr_unordered(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Coo_to_csr_unordered(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Coo_to_csr_finalize(__arg0,__arg1,__arg2,__arg3) => reflectPure(new { override val original = Some(f,mn) } with Coo_to_csr_finalize(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Coo_to_csr_finalize(__arg0,__arg1,__arg2,__arg3), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Coo_to_csr_finalize(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[SparseMatrixBuildable[_]]) Some((classTag(m), collection.immutable.List(("_numRows",manifest[Int]),("_numCols",manifest[Int]),("_data",makeManifest(classOf[ForgeArray[_]], List(m.typeArguments(0)))),("_colIndices",makeManifest(classOf[ForgeArray[_]], List(manifest[Int]))),("_rowIndices",makeManifest(classOf[ForgeArray[_]], List(manifest[Int]))),("_nnz",manifest[Int]))))
    else super.unapplyStructType(m)
  }
}

