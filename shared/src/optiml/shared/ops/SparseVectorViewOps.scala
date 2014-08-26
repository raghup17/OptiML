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

trait SparseVectorViewOpsBase extends Base {
  this: OptiML => 

  implicit def viewToSparse[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): Rep[SparseVector[T]] = sparsevectorview_viewtosparse[T](self)(implicitly[Manifest[T]],__pos)
  implicit def chainViewToSparseOps[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): SparseVectorSparseVectorOpsCls[T] = sparsevectorview_chainviewtosparseops[T](self)(implicitly[Manifest[T]],__pos)

  def sparsevectorview_viewtosparse[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): Rep[SparseVector[T]]
  def sparsevectorview_chainviewtosparseops[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): SparseVectorSparseVectorOpsCls[T]
}

trait SparseVectorViewOps extends SparseVectorViewOpsBase {
  this: OptiML => 

  object SparseVectorView {
    def apply[T:Manifest](__arg0: Rep[SparseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[Int],__arg4: Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevectorview_object_apply[T](__arg0,__arg1,__arg2,__arg3,__arg4)(implicitly[Manifest[T]],__pos)
  }

  def __equal[T:Manifest](self: Rep[SparseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevectorview___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload1)
  def __equal[T:Manifest](self: Rep[SparseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevectorview___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload2)

  implicit def repToSparseVectorViewSparseVectorViewOpsCls[T:Manifest](x: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = new SparseVectorViewSparseVectorViewOpsCls(x)(implicitly[Manifest[T]],__pos)
  implicit def varToSparseVectorViewSparseVectorViewOpsCls[T:Manifest](x: Var[SparseVectorView[T]])(implicit __pos: SourceContext) = new SparseVectorViewSparseVectorViewOpsCls(readVar(x))(implicitly[Manifest[T]],__pos)

  class SparseVectorViewSparseVectorViewOpsCls[T:Manifest](val self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) {
    def apply(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevectorview_apply[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }


  def infix_length[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevectorview_length[T](self)(implicitly[Manifest[T]],__pos)
  def infix_isRow[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevectorview_isrow[T](self)(implicitly[Manifest[T]],__pos)
  def infix_nnz[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevectorview_nnz[T](self)(implicitly[Manifest[T]],__pos)
  def infix_nz[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevectorview_nz[T](self)(implicitly[Manifest[T]],__pos)
  def infix_indices[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevectorview_indices[T](self)(implicitly[Manifest[T]],__pos)
  def infix_Clone[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[SparseVector[T]] = { self.toSparse }
  def infix_toDense[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[DenseVector[T]] = { self.toSparse.toDense }
  def infix_toSparse[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = sparsevectorview_tosparse[T](self)(implicitly[Manifest[T]],__pos)
  def infix_toString[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __imp0: Overload1) = sparsevectorview_tostring[T](self)

  def sparsevectorview_object_apply[T:Manifest](__arg0: Rep[SparseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[Int],__arg4: Rep[Boolean])(implicit __pos: SourceContext): Rep[SparseVectorView[T]]
  def sparsevectorview_length[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): Rep[Int]
  def sparsevectorview_isrow[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): Rep[Boolean]
  def sparsevectorview_apply[T:Manifest](self: Rep[SparseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[T]
  def sparsevectorview_nnz[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): Rep[Int]
  def sparsevectorview_nz[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): Rep[DenseVectorView[T]]
  def sparsevectorview_indices[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): Rep[IndexVector]
  def sparsevectorview_tosparse[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): Rep[SparseVector[T]]
  def sparsevectorview___equal[T:Manifest](self: Rep[SparseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload1): Rep[Boolean]
  def sparsevectorview___equal[T:Manifest](self: Rep[SparseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2): Rep[Boolean]
  def sparsevectorview_tostring[T:Manifest](self: Rep[SparseVectorView[T]]): Rep[String]
}
trait SparseVectorViewCompilerOps extends SparseVectorViewOps {
  this: OptiML => 

  def sparsevectorview_source[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): Rep[SparseMatrix[T]]
  def sparsevectorview_start[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): Rep[Int]
  def sparsevectorview_stride[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): Rep[Int]
  def sparsevectorview_calc_offsets_all[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): Rep[Tup6[Int,Int,Int,Int,Int,Int]]
  def sparsevectorview_calc_offsets[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext): Rep[Tup2[Int,Int]]
  def sparsevectorview_includeoffset[T:Manifest](self: Rep[SparseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Boolean]
}

