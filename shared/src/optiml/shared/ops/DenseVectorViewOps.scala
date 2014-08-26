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

trait DenseVectorViewOpsBase extends Base {
  this: OptiML => 

  implicit def viewToDense[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[DenseVector[T]] = densevectorview_viewtodense[T](self)(implicitly[Manifest[T]],__pos)
  implicit def chainViewToDenseOps[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): DenseVectorDenseVectorOpsCls[T] = densevectorview_chainviewtodenseops[T](self)(implicitly[Manifest[T]],__pos)
  implicit def dist(__arg0: Rep[DenseVectorView[Double]],__arg1: Rep[DenseVectorView[Double]])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[Double] = { dist(__arg0,__arg1,ABS) }

  def densevectorview_viewtodense[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[DenseVector[T]]
  def densevectorview_chainviewtodenseops[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): DenseVectorDenseVectorOpsCls[T]
}

trait DenseVectorViewOps extends DenseVectorViewOpsBase {
  this: OptiML => 

  object DenseVectorView {
    def apply[T:Manifest](__arg0: Rep[ForgeArray[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[Int],__arg4: Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload18) = densevectorview_object_apply[T](__arg0,__arg1,__arg2,__arg3,__arg4)(implicitly[Manifest[T]],__pos)
  }

  def __equal[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload9) = densevectorview___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  def dist(__arg0: Rep[DenseVectorView[Double]],__arg1: Rep[DenseVectorView[Double]],__arg2: DistanceMetric)(implicit __pos: SourceContext,__imp1: Overload2) = densevectorview_dist(__arg0,__arg1,__arg2)(__pos)

  implicit def repToDenseVectorViewDenseVectorViewOpsCls[T:Manifest](x: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = new DenseVectorViewDenseVectorViewOpsCls(x)(implicitly[Manifest[T]],__pos)
  implicit def varToDenseVectorViewDenseVectorViewOpsCls[T:Manifest](x: Var[DenseVectorView[T]])(implicit __pos: SourceContext) = new DenseVectorViewDenseVectorViewOpsCls(readVar(x))(implicitly[Manifest[T]],__pos)

  class DenseVectorViewDenseVectorViewOpsCls[T:Manifest](val self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) {
    def apply(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload19) = densevectorview_apply[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def filter(__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext,__imp1: ROverload2) = { self.toDense.filter(__arg1) }
    def toBoolean(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Boolean],__imp2: Overload3) = densevectorview_toboolean[T](self)(implicitly[Manifest[T]],__pos,conv)
    def toDouble(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double],__imp2: Overload4) = densevectorview_todouble[T](self)(implicitly[Manifest[T]],__pos,conv)
    def toFloat(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Float],__imp2: Overload4) = densevectorview_tofloat[T](self)(implicitly[Manifest[T]],__pos,conv)
    def toInt(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Int],__imp2: Overload4) = densevectorview_toint[T](self)(implicitly[Manifest[T]],__pos,conv)
    def -(__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload47) = densevectorview_sub[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload47)
    def *(__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload49) = densevectorview_mul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload49)
    def /(__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload48) = densevectorview_div[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload48)
    def -(__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload48) = densevectorview_sub[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload48)
    def *(__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload50) = densevectorview_mul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload50)
    def /(__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload49) = densevectorview_div[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload49)
    def -(__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload49) = densevectorview_sub[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload49)
    def *(__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload51) = densevectorview_mul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload51)
    def /(__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload50) = densevectorview_div[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload50)
    def -(__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload50) = densevectorview_sub[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload50)
    def *(__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload52) = densevectorview_mul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload52)
    def /(__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload51) = densevectorview_div[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload51)
    def zip[B:Manifest,R:Manifest](__arg1: Rep[DenseVector[B]])(__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload3) = densevectorview_zip[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos,overload3)
    def zip[B:Manifest,R:Manifest](__arg1: Rep[DenseVectorView[B]])(__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload4) = densevectorview_zip[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos,overload4)
    def -(__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload51) = densevectorview_sub[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload51)
    def *(__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload53) = densevectorview_mul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload53)
    def *(__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload54) = densevectorview_mul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload54)
    def /(__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload52) = densevectorview_div[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload52)
    def mean(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double],__imp2: Overload3) = densevectorview_mean[T](self)(implicitly[Manifest[T]],__pos,conv)
    def map[R:Manifest](__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload2) = densevectorview_map[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
    def reduce(__arg1: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = densevectorview_reduce[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
    def foreach(__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext,__imp1: Overload3) = densevectorview_foreach[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def find(__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload2) = densevectorview_find[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def count(__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload2) = densevectorview_count[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def partition(pred: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload2) = densevectorview_partition[T](self,pred)(implicitly[Manifest[T]],__pos)
    def flatMap[R:Manifest](__arg1: (Rep[T]) => Rep[DenseVector[R]])(implicit __pos: SourceContext,__imp1: Overload2) = densevectorview_flatmap[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
    def scan[R:Manifest](zero: Rep[R])(__arg2: (Rep[R],Rep[T]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload2) = densevectorview_scan[T,R](self,zero,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }


  def infix_length[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload5) = densevectorview_length[T](self)(implicitly[Manifest[T]],__pos)
  def infix_isRow[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload4) = densevectorview_isrow[T](self)(implicitly[Manifest[T]],__pos)
  def infix_slice[T:Manifest](self: Rep[DenseVectorView[T]],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload4) = densevectorview_slice[T](self,start,end)(implicitly[Manifest[T]],__pos)
  def infix_Clone[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[DenseVector[T]] = { self.toDense }
  def infix_toDense[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload4) = densevectorview_todense[T](self)(implicitly[Manifest[T]],__pos)
  def infix_indices[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload4) = densevectorview_indices[T](self)(implicitly[Manifest[T]],__pos)
  def infix_isEmpty[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload3) = densevectorview_isempty[T](self)(implicitly[Manifest[T]],__pos)
  def infix_first[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload3) = densevectorview_first[T](self)(implicitly[Manifest[T]],__pos)
  def infix_last[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload3) = densevectorview_last[T](self)(implicitly[Manifest[T]],__pos)
  def infix_drop[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload3) = densevectorview_drop[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  def infix_take[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload3) = densevectorview_take[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  def infix_contains[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload7) = densevectorview_contains[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  def infix_distinct[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload3) = densevectorview_distinct[T](self)(implicitly[Manifest[T]],__pos)
  def infix_mutable[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload12) = densevectorview_mutable[T](self)(implicitly[Manifest[T]],__pos)
  def infix_replicate[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = densevectorview_replicate[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  def infix_makeString[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Stringable[T],__imp2: Overload4) = densevectorview_makestring[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_toString[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __imp0: Overload11) = densevectorview_tostring[T](self)
  def infix_pprint[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Stringable[T],__imp2: Overload4) = densevectorview_pprint[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_+[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload63) = densevectorview_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload63)
  def infix_*:*[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload7) = densevectorview_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload7)
  def infix_**[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload6) = densevectorview_mulmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload6)
  def infix_+[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload64) = densevectorview_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload64)
  def infix_*:*[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload8) = densevectorview_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload8)
  def infix_**[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload7) = densevectorview_mulmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload7)
  def infix_+[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload65) = densevectorview_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload65)
  def infix_*:*[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload9) = densevectorview_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload9)
  def infix_**[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload8) = densevectorview_mulmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload8)
  def infix_+[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload66) = densevectorview_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload66)
  def infix_*:*[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload10) = densevectorview_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload10)
  def infix_**[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload9) = densevectorview_mulmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload9)
  def infix_+[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload67) = densevectorview_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload67)
  def infix_abs[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload13) = densevectorview_abs[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_exp[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload12) = densevectorview_exp[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_log[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload12) = densevectorview_log[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_sum[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload3) = densevectorview_sum[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_prod[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = densevectorview_prod[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_min[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload4) = densevectorview_min[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_max[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload4) = densevectorview_max[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_minIndex[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp1: Arith[T],__imp3: Overload2) = densevectorview_minindex[T](self)(implicitly[Manifest[T]],__pos,__imp0,__imp1)
  def infix_maxIndex[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp1: Arith[T],__imp3: Overload2) = densevectorview_maxindex[T](self)(implicitly[Manifest[T]],__pos,__imp0,__imp1)
  def infix_prefixSum[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = densevectorview_prefixsum[T](self)(implicitly[Manifest[T]],__pos,__imp0)

  def densevectorview_object_apply[T:Manifest](__arg0: Rep[ForgeArray[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[Int],__arg4: Rep[Boolean])(implicit __pos: SourceContext): Rep[DenseVectorView[T]]
  def densevectorview_length[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[Int]
  def densevectorview_isrow[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[Boolean]
  def densevectorview_apply[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[T]
  def densevectorview_slice[T:Manifest](self: Rep[DenseVectorView[T]],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVectorView[T]]
  def densevectorview_todense[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[DenseVector[T]]
  def densevectorview___equal[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext): Rep[Boolean]
  def densevectorview_toboolean[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Boolean]): Rep[DenseVector[Boolean]]
  def densevectorview_todouble[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]): Rep[DenseVector[Double]]
  def densevectorview_tofloat[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Float]): Rep[DenseVector[Float]]
  def densevectorview_toint[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Int]): Rep[DenseVector[Int]]
  def densevectorview_indices[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[IndexVector]
  def densevectorview_isempty[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[Boolean]
  def densevectorview_first[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[T]
  def densevectorview_last[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[T]
  def densevectorview_drop[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVectorView[T]]
  def densevectorview_take[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVectorView[T]]
  def densevectorview_contains[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext): Rep[Boolean]
  def densevectorview_distinct[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[DenseVector[T]]
  def densevectorview_mutable[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[DenseVector[T]]
  def densevectorview_replicate[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext): Rep[DenseMatrix[T]]
  def densevectorview_makestring[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]): Rep[String]
  def densevectorview_tostring[T:Manifest](self: Rep[DenseVectorView[T]]): Rep[String]
  def densevectorview_pprint[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]): Rep[Unit]
  def densevectorview_pl[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload63): Rep[DenseVector[T]]
  def densevectorview_sub[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload47): Rep[DenseVector[T]]
  def densevectorview_mul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload49): Rep[DenseVector[T]]
  def densevectorview_mulclnmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload7): Rep[T]
  def densevectorview_mulmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload6): Rep[DenseMatrix[T]]
  def densevectorview_div[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload48): Rep[DenseVector[T]]
  def densevectorview_pl[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload64): Rep[DenseVector[T]]
  def densevectorview_sub[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload48): Rep[DenseVector[T]]
  def densevectorview_mul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload50): Rep[DenseVector[T]]
  def densevectorview_mulclnmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload8): Rep[T]
  def densevectorview_mulmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload7): Rep[DenseMatrix[T]]
  def densevectorview_div[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload49): Rep[DenseVector[T]]
  def densevectorview_pl[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload65): Rep[DenseVector[T]]
  def densevectorview_sub[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload49): Rep[DenseVector[T]]
  def densevectorview_mul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload51): Rep[DenseVector[T]]
  def densevectorview_mulclnmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload9): Rep[T]
  def densevectorview_mulmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload8): Rep[DenseMatrix[T]]
  def densevectorview_div[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload50): Rep[DenseVector[T]]
  def densevectorview_pl[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload66): Rep[DenseVector[T]]
  def densevectorview_sub[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload50): Rep[DenseVector[T]]
  def densevectorview_mul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload52): Rep[DenseVector[T]]
  def densevectorview_mulclnmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload10): Rep[T]
  def densevectorview_mulmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload9): Rep[DenseMatrix[T]]
  def densevectorview_div[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload51): Rep[DenseVector[T]]
  def densevectorview_zip[T:Manifest,B:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload3): Rep[DenseVector[R]]
  def densevectorview_zip[T:Manifest,B:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload4): Rep[DenseVector[R]]
  def densevectorview_pl[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload67): Rep[DenseVector[T]]
  def densevectorview_sub[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload51): Rep[DenseVector[T]]
  def densevectorview_mul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload53): Rep[DenseVector[T]]
  def densevectorview_mul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload54): Rep[DenseVector[T]]
  def densevectorview_div[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload52): Rep[DenseVector[T]]
  def densevectorview_abs[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]]
  def densevectorview_exp[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]]
  def densevectorview_log[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]]
  def densevectorview_sum[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T]
  def densevectorview_prod[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T]
  def densevectorview_mean[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]): Rep[Double]
  def densevectorview_min[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[T]
  def densevectorview_max[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[T]
  def densevectorview_minindex[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp1: Arith[T]): Rep[Int]
  def densevectorview_maxindex[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp1: Arith[T]): Rep[Int]
  def densevectorview_map[T:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]]
  def densevectorview_reduce[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T]
  def densevectorview_foreach[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit]
  def densevectorview_find[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[IndexVector]
  def densevectorview_count[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[Int]
  def densevectorview_partition[T:Manifest](self: Rep[DenseVectorView[T]],pred: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[Tup2[DenseVector[T],DenseVector[T]]]
  def densevectorview_flatmap[T:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[DenseVector[R]])(implicit __pos: SourceContext): Rep[DenseVector[R]]
  def densevectorview_scan[T:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],zero: Rep[R],__arg2: (Rep[R],Rep[T]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]]
  def densevectorview_prefixsum[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseVector[T]]
  def densevectorview_dist(__arg0: Rep[DenseVectorView[Double]],__arg1: Rep[DenseVectorView[Double]],__arg2: DistanceMetric)(implicit __pos: SourceContext): Rep[Double]
}
trait DenseVectorViewCompilerOps extends DenseVectorViewOps {
  this: OptiML => 

  def densevectorview_data[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[ForgeArray[T]]
  def densevectorview_start[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[Int]
  def densevectorview_stride[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext): Rep[Int]
  def densevectorview_illegalalloc[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Nothing]
  def densevectorview_illegalupdate[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext): Rep[Nothing]
  def densevectorview_densevector_filter_map[T:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[Boolean],__arg2: (Rep[T]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]]
}

