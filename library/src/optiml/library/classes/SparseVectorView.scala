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

trait SparseVectorViewWrapper {
  this: OptiMLBase with OptiMLClasses => 

class SparseVectorView[T:Manifest](___source: SparseMatrix[T], ___start: Int, ___stride: Int, ___length: Int, ___isRow: Boolean) {
  var _source = ___source
  var _start = ___start
  var _stride = ___stride
  var _length = ___length
  var _isRow = ___isRow

  override def toString() = {
    val self = this
    sparsevectorview_tostring_impl1[T](self)
  }
}

  def sparsevectorview_object_apply[T:Manifest](__arg0: Rep[SparseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[Int],__arg4: Rep[Boolean])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    new SparseVectorView[T](__arg0,__arg1,__arg2,__arg3,__arg4)
  }
  def sparsevectorview_source[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    self._source
  }
  def sparsevectorview_start[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    self._start
  }
  def sparsevectorview_stride[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    self._stride
  }
  def sparsevectorview_calc_offsets_all[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    sparsevectorview_calc_offsets_all_impl[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevectorview_calc_offsets[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    sparsevectorview_calc_offsets_impl[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevectorview_includeoffset[T:Manifest](self: Rep[SparseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    sparsevectorview_includeoffset_impl[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevectorview_length[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._length
  }
  def sparsevectorview_isrow[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._isRow
  }
  def sparsevectorview_apply[T:Manifest](self: Rep[SparseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    sparsevectorview_apply_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevectorview_nnz[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    sparsevectorview_nnz_impl1[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevectorview_nz[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    sparsevectorview_nz_impl1[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevectorview_indices[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    sparsevectorview_indices_impl1[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevectorview_tosparse[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    sparsevectorview_tosparse_impl[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevectorview___equal[T:Manifest](self: Rep[SparseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload1) = {
    sparsevectorview___equal_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevectorview___equal[T:Manifest](self: Rep[SparseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = {
    sparsevectorview___equal_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevectorview_tostring[T:Manifest](self: Rep[SparseVectorView[T]]) = {
    sparsevectorview_tostring_impl1[T](self)
  }
  def sparsevectorview_viewtosparse[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    sparsevectorview_viewtosparse_impl[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevectorview_chainviewtosparseops[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    sparsevectorview_chainviewtosparseops_impl[T](self)(implicitly[Manifest[T]],__pos)
  }

}

