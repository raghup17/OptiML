package optiml.shared.ops

import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._

/**
 * Operations
 */

trait SparseMatrixBuildableOps extends Base {
  this: OptiML => 

  implicit def repToSparseMatrixBuildableSparseMatrixBuildableOpsCls[T:Manifest](x: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = new SparseMatrixBuildableSparseMatrixBuildableOpsCls(x)(implicitly[Manifest[T]],__pos)
  implicit def varToSparseMatrixBuildableSparseMatrixBuildableOpsCls[T:Manifest](x: Var[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = new SparseMatrixBuildableSparseMatrixBuildableOpsCls(readVar(x))(implicitly[Manifest[T]],__pos)

  class SparseMatrixBuildableSparseMatrixBuildableOpsCls[T:Manifest](val self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) {
    def apply(i: Rep[Int],j: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload18) = sparsematrixbuildable_apply[T](self,i,j)(implicitly[Manifest[T]],__pos)
    def update(__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[T])(implicit __pos: SourceContext,__imp1: Overload6) = sparsematrixbuildable_update[T](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],__pos)
    def <<=(__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload3) = sparsematrixbuildable_ltlteq[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def <<|=(__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsematrixbuildable_ltltoreq[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }


  def infix_numRows[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrixbuildable_numrows[T](self)(implicitly[Manifest[T]],__pos)
  def infix_numCols[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrixbuildable_numcols[T](self)(implicitly[Manifest[T]],__pos)
  def infix_nnz[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext,__imp1: Overload3) = sparsematrixbuildable_nnz[T](self)(implicitly[Manifest[T]],__pos)
  def infix_size[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext,__imp1: Overload7) = sparsematrixbuildable_size[T](self)(implicitly[Manifest[T]],__pos)
  def infix_pprint[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext,__imp0: Stringable[T],__imp2: Overload3) = sparsematrixbuildable_pprint[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_makeString[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext,__imp0: Stringable[T],__imp2: Overload3) = sparsematrixbuildable_makestring[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_toString[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __imp0: Overload9) = sparsematrixbuildable_tostring[T](self)
  def infix_mutable[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext,__imp1: Overload8) = sparsematrixbuildable_mutable[T](self)(implicitly[Manifest[T]],__pos)
  def infix_append[T:Manifest](self: Rep[SparseMatrixBuildable[T]],i: Rep[Int],j: Rep[Int],y: Rep[T],alwaysWrite: Rep[Boolean] = unit(true))(implicit __pos: SourceContext) = sparsematrixbuildable_append[T](self,i,j,y,alwaysWrite)(implicitly[Manifest[T]],__pos)
  def infix_insertRow[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],y: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsematrixbuildable_insertrow[T](self,pos,y)(implicitly[Manifest[T]],__pos)
  def infix_insertCol[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],y: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsematrixbuildable_insertcol[T](self,pos,y)(implicitly[Manifest[T]],__pos)
  def infix_removeRow[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = sparsematrixbuildable_removerow[T](self,pos)(implicitly[Manifest[T]],__pos)
  def infix_removeCol[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = sparsematrixbuildable_removecol[T](self,pos)(implicitly[Manifest[T]],__pos)
  def infix_removeRows[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],num: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = sparsematrixbuildable_removerows[T](self,pos,num)(implicitly[Manifest[T]],__pos)
  def infix_removeCols[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],num: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = sparsematrixbuildable_removecols[T](self,pos,num)(implicitly[Manifest[T]],__pos)
  def infix_finish[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = sparsematrixbuildable_finish[T](self)(implicitly[Manifest[T]],__pos)

  def sparsematrixbuildable_numrows[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext): Rep[Int]
  def sparsematrixbuildable_numcols[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext): Rep[Int]
  def sparsematrixbuildable_nnz[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext): Rep[Int]
  def sparsematrixbuildable_size[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext): Rep[Int]
  def sparsematrixbuildable_apply[T:Manifest](self: Rep[SparseMatrixBuildable[T]],i: Rep[Int],j: Rep[Int])(implicit __pos: SourceContext): Rep[T]
  def sparsematrixbuildable_pprint[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]): Rep[Unit]
  def sparsematrixbuildable_makestring[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]): Rep[String]
  def sparsematrixbuildable_tostring[T:Manifest](self: Rep[SparseMatrixBuildable[T]]): Rep[String]
  def sparsematrixbuildable_mutable[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext): Rep[SparseMatrixBuildable[T]]
  def sparsematrixbuildable_update[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[T])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrixbuildable_append[T:Manifest](self: Rep[SparseMatrixBuildable[T]],i: Rep[Int],j: Rep[Int],y: Rep[T],alwaysWrite: Rep[Boolean] = unit(true))(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrixbuildable_ltlteq[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrixbuildable_ltltoreq[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrixbuildable_insertrow[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],y: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrixbuildable_insertcol[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],y: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrixbuildable_removerow[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrixbuildable_removecol[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrixbuildable_removerows[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],num: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrixbuildable_removecols[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],num: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrixbuildable_finish[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext): Rep[SparseMatrix[T]]
}
trait SparseMatrixBuildableCompilerOps extends SparseMatrixBuildableOps {
  this: OptiML => 

  def sparsematrix_coo_find_offset[T:Manifest](self: Rep[SparseMatrixBuildable[T]],row: Rep[Int],col: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def sparsematrix_coo_data[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext): Rep[ForgeArray[T]]
  def sparsematrix_coo_rowindices[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext): Rep[ForgeArray[Int]]
  def sparsematrix_coo_colindices[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext): Rep[ForgeArray[Int]]
  def sparsematrix_coo_set_numrows[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrix_coo_set_numcols[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrix_coo_set_data[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[ForgeArray[T]])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrix_coo_set_rowindices[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[ForgeArray[Int]])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrix_coo_set_colindices[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[ForgeArray[Int]])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrix_coo_set_nnz[T:Manifest](self: Rep[SparseMatrixBuildable[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrix_coo_ensureextra[T:Manifest](self: Rep[SparseMatrixBuildable[T]],extra: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def sparsematrix_coo_realloc[T:Manifest](self: Rep[SparseMatrixBuildable[T]],minLen: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def coo_to_csr[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext): Rep[SparseMatrix[T]]
  def coo_ordered[T:Manifest](self: Rep[SparseMatrixBuildable[T]],nnz: Rep[Int],rowIndices: Rep[ForgeArray[Int]],colIndices: Rep[ForgeArray[Int]])(implicit __pos: SourceContext): Rep[Boolean]
  def coo_to_csr_ordered[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext): Rep[SparseMatrix[T]]
  def coo_to_csr_unordered[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext): Rep[SparseMatrix[T]]
  def coo_to_csr_finalize[T:Manifest](self: Rep[SparseMatrixBuildable[T]],outData: Rep[ForgeArray[T]],outColIndices: Rep[ForgeArray[Int]],outRowPtr: Rep[ForgeArray[Int]])(implicit __pos: SourceContext): Rep[SparseMatrix[T]]
}

