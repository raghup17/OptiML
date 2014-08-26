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

trait SparseVectorOpsBase extends Base {
  this: OptiML => 

  implicit def dist(__arg0: Rep[SparseVector[Double]],__arg1: Rep[SparseVector[Double]])(implicit __pos: SourceContext,__imp1: ROverload3): Rep[Double] = { dist(__arg0,__arg1,ABS) }

}

trait SparseVectorOps extends SparseVectorOpsBase {
  this: OptiML => 

  object SparseVector {
    def apply[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload13) = sparsevector_object_apply[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos)
    def zeros(__arg0: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[SparseVector[Double]] = { SparseVector[Double](__arg0, unit(true)) }
    def zerosf(__arg0: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[SparseVector[Float]] = { SparseVector[Float](__arg0, unit(true)) }
    def rand(length: Rep[Int],sparsity: Rep[Double])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_object_rand(length,sparsity)(__pos)
    def randf(length: Rep[Int],sparsity: Rep[Double])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_object_randf(length,sparsity)(__pos)
  }

  def __equal[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload6) = sparsevector___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload6)
  def __equal[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload7) = sparsevector___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload7)
  def __equal[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload8) = sparsevector___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload8)
  def dist(__arg0: Rep[SparseVector[Double]],__arg1: Rep[SparseVector[Double]],__arg2: DistanceMetric)(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_dist(__arg0,__arg1,__arg2)(__pos)

  implicit def repToSparseVectorSparseVectorOpsCls[T:Manifest](x: Rep[SparseVector[T]])(implicit __pos: SourceContext) = new SparseVectorSparseVectorOpsCls(x)(implicitly[Manifest[T]],__pos)
  implicit def varToSparseVectorSparseVectorOpsCls[T:Manifest](x: Var[SparseVector[T]])(implicit __pos: SourceContext) = new SparseVectorSparseVectorOpsCls(readVar(x))(implicitly[Manifest[T]],__pos)

  class SparseVectorSparseVectorOpsCls[T:Manifest](val self: Rep[SparseVector[T]])(implicit __pos: SourceContext) {
    def apply(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload11) = sparsevector_apply[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload11)
    def apply(__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload12) = sparsevector_apply[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload12)
    def update(pos: Rep[Int],e: Rep[T])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevector_update[T](self,pos,e)(implicitly[Manifest[T]],__pos,overload2)
    def update(indices: Rep[IndexVector],e: Rep[T])(implicit __pos: SourceContext,__imp1: Overload3) = sparsevector_update[T](self,indices,e)(implicitly[Manifest[T]],__pos,overload3)
    def update(indices: Rep[IndexVector],v: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload4) = sparsevector_update[T](self,indices,v)(implicitly[Manifest[T]],__pos,overload4)
    def <<=(__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_ltlteq[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload1)
    def <<=(__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevector_ltlteq[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload2)
    def -(__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload39) = sparsevector_sub[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload39)
    def -(__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload40) = sparsevector_sub[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload40)
    def -(__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload41) = sparsevector_sub[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload41)
    def *(__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload40) = sparsevector_mul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload40)
    def *(__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload41) = sparsevector_mul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload41)
    def *(__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload42) = sparsevector_mul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload42)
    def *(__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload43) = sparsevector_mul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload43)
    def /(__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload40) = sparsevector_div[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload40)
    def /(__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload41) = sparsevector_div[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload41)
    def /(__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload42) = sparsevector_div[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload42)
    def mean(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double],__imp2: Overload2) = sparsevector_mean[T](self)(implicitly[Manifest[T]],__pos,conv)
    def mapnz[R:Manifest](__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_mapnz[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
    def reducenz(__arg1: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]) = sparsevector_reducenz[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
    def filternz(__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = sparsevector_filternz[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def foreachnz(__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_foreachnz[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def findnz(__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = sparsevector_findnz[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def countnz(__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_countnz[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }


  def infix_length[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload3) = sparsevector_length[T](self)(implicitly[Manifest[T]],__pos)
  def infix_isRow[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload3) = sparsevector_isrow[T](self)(implicitly[Manifest[T]],__pos)
  def infix_nnz[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevector_nnz[T](self)(implicitly[Manifest[T]],__pos)
  def infix_nz[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevector_nz[T](self)(implicitly[Manifest[T]],__pos)
  def infix_indices[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload3) = sparsevector_indices[T](self)(implicitly[Manifest[T]],__pos)
  def infix_isEmpty[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevector_isempty[T](self)(implicitly[Manifest[T]],__pos)
  def infix_first[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevector_first[T](self)(implicitly[Manifest[T]],__pos)
  def infix_firstnz[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = sparsevector_firstnz[T](self)(implicitly[Manifest[T]],__pos)
  def infix_last[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevector_last[T](self)(implicitly[Manifest[T]],__pos)
  def infix_lastnz[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext) = sparsevector_lastnz[T](self)(implicitly[Manifest[T]],__pos)
  def infix_drop[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevector_drop[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  def infix_take[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevector_take[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  def infix_slice[T:Manifest](self: Rep[SparseVector[T]],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[SparseVector[T]] = { self(start::end) }
  def infix_contains[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload3) = sparsevector_contains[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  def infix_distinct[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevector_distinct[T](self)(implicitly[Manifest[T]],__pos)
  def infix_t[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevector_t[T](self)(implicitly[Manifest[T]],__pos)
  def infix_mt[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_mt[T](self)(implicitly[Manifest[T]],__pos)
  def infix_Clone[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload3) = sparsevector_clone[T](self)(implicitly[Manifest[T]],__pos)
  def infix_mutable[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload5) = sparsevector_mutable[T](self)(implicitly[Manifest[T]],__pos)
  def infix_toDense[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload3) = sparsevector_todense[T](self)(implicitly[Manifest[T]],__pos)
  def infix_makeString[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Stringable[T],__imp2: Overload2) = sparsevector_makestring[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_toString[T:Manifest](self: Rep[SparseVector[T]])(implicit __imp0: Overload7) = sparsevector_tostring[T](self)
  def infix_pprint[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Stringable[T],__imp2: Overload2) = sparsevector_pprint[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_<<[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload3) = sparsevector_ltlt[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload3)
  def infix_<<[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload4) = sparsevector_ltlt[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload4)
  def infix_insert[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_insert[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  def infix_insertAll[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],xs: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_insertall[T](self,pos,xs)(implicitly[Manifest[T]],__pos)
  def infix_remove[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_remove[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  def infix_removeAll[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_removeall[T](self,pos,len)(implicitly[Manifest[T]],__pos)
  def infix_copyFrom[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],xs: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_copyfrom[T](self,pos,xs)(implicitly[Manifest[T]],__pos)
  def infix_trim[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_trim[T](self)(implicitly[Manifest[T]],__pos)
  def infix_clear[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_clear[T](self)(implicitly[Manifest[T]],__pos)
  def infix_+[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload39) = sparsevector_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload39)
  def infix_+[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload40) = sparsevector_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload40)
  def infix_+[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload41) = sparsevector_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload41)
  def infix_*:*[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload5) = sparsevector_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload5)
  def infix_*:*[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload6) = sparsevector_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload6)
  def infix_**[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload5) = sparsevector_mulmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_abs[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload7) = sparsevector_abs[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_sum[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = sparsevector_sum[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_min[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload3) = sparsevector_min[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_max[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload3) = sparsevector_max[T](self)(implicitly[Manifest[T]],__pos,__imp0)

  def sparsevector_object_apply[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Boolean])(implicit __pos: SourceContext): Rep[SparseVector[T]]
  def sparsevector_object_rand(length: Rep[Int],sparsity: Rep[Double])(implicit __pos: SourceContext): Rep[SparseVector[Double]]
  def sparsevector_object_randf(length: Rep[Int],sparsity: Rep[Double])(implicit __pos: SourceContext): Rep[SparseVector[Float]]
  def sparsevector_length[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Int]
  def sparsevector_isrow[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Boolean]
  def sparsevector_nnz[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Int]
  def sparsevector_nz[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[DenseVectorView[T]]
  def sparsevector_indices[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[IndexVector]
  def sparsevector_apply[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload11): Rep[T]
  def sparsevector_apply[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload12): Rep[SparseVector[T]]
  def sparsevector_isempty[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Boolean]
  def sparsevector_first[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[T]
  def sparsevector_firstnz[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[T]
  def sparsevector_last[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[T]
  def sparsevector_lastnz[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[T]
  def sparsevector_drop[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[SparseVector[T]]
  def sparsevector_take[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[SparseVector[T]]
  def sparsevector_contains[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext): Rep[Boolean]
  def sparsevector_distinct[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[DenseVector[T]]
  def sparsevector_t[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[SparseVector[T]]
  def sparsevector_mt[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Unit]
  def sparsevector_clone[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[SparseVector[T]]
  def sparsevector_mutable[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[SparseVector[T]]
  def sparsevector_todense[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[DenseVector[T]]
  def sparsevector_makestring[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]): Rep[String]
  def sparsevector_tostring[T:Manifest](self: Rep[SparseVector[T]]): Rep[String]
  def sparsevector_pprint[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]): Rep[Unit]
  def sparsevector_update[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],e: Rep[T])(implicit __pos: SourceContext,__imp1: Overload2): Rep[Unit]
  def sparsevector_update[T:Manifest](self: Rep[SparseVector[T]],indices: Rep[IndexVector],e: Rep[T])(implicit __pos: SourceContext,__imp1: Overload3): Rep[Unit]
  def sparsevector_update[T:Manifest](self: Rep[SparseVector[T]],indices: Rep[IndexVector],v: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload4): Rep[Unit]
  def sparsevector_ltlt[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload3): Rep[SparseVector[T]]
  def sparsevector_ltlt[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload4): Rep[SparseVector[T]]
  def sparsevector_ltlteq[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload1): Rep[Unit]
  def sparsevector_ltlteq[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2): Rep[Unit]
  def sparsevector_insert[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext): Rep[Unit]
  def sparsevector_insertall[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],xs: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Unit]
  def sparsevector_remove[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def sparsevector_removeall[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def sparsevector_copyfrom[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],xs: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Unit]
  def sparsevector_trim[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Unit]
  def sparsevector_clear[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[Unit]
  def sparsevector_pl[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload39): Rep[SparseVector[T]]
  def sparsevector_pl[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload40): Rep[DenseVector[T]]
  def sparsevector_pl[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload41): Rep[DenseVector[T]]
  def sparsevector_sub[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload39): Rep[SparseVector[T]]
  def sparsevector_sub[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload40): Rep[DenseVector[T]]
  def sparsevector_sub[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload41): Rep[DenseVector[T]]
  def sparsevector_mul[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload40): Rep[SparseVector[T]]
  def sparsevector_mul[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload41): Rep[DenseVector[T]]
  def sparsevector_mul[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload42): Rep[SparseVector[T]]
  def sparsevector_mul[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload43): Rep[DenseVector[T]]
  def sparsevector_mulclnmul[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload5): Rep[T]
  def sparsevector_mulclnmul[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload6): Rep[T]
  def sparsevector_mulmul[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[DenseMatrix[T]]
  def sparsevector_div[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload40): Rep[SparseVector[T]]
  def sparsevector_div[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload41): Rep[DenseVector[T]]
  def sparsevector_div[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload42): Rep[SparseVector[T]]
  def sparsevector_abs[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[SparseVector[T]]
  def sparsevector_sum[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T]
  def sparsevector_mean[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]): Rep[Double]
  def sparsevector_min[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[T]
  def sparsevector_max[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]): Rep[T]
  def sparsevector___equal[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload6): Rep[Boolean]
  def sparsevector___equal[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload7): Rep[Boolean]
  def sparsevector___equal[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload8): Rep[Boolean]
  def sparsevector_mapnz[T:Manifest,R:Manifest](self: Rep[SparseVector[T]],__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext): Rep[SparseVector[R]]
  def sparsevector_reducenz[T:Manifest](self: Rep[SparseVector[T]],__arg1: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]): Rep[T]
  def sparsevector_filternz[T:Manifest](self: Rep[SparseVector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[SparseVector[T]]
  def sparsevector_foreachnz[T:Manifest](self: Rep[SparseVector[T]],__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit]
  def sparsevector_findnz[T:Manifest](self: Rep[SparseVector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[IndexVector]
  def sparsevector_countnz[T:Manifest](self: Rep[SparseVector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[Int]
  def sparsevector_dist(__arg0: Rep[SparseVector[Double]],__arg1: Rep[SparseVector[Double]],__arg2: DistanceMetric)(implicit __pos: SourceContext): Rep[Double]
}
trait SparseVectorCompilerOps extends SparseVectorOps {
  this: OptiML => 

  def sparsevector_alloc_raw[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Boolean],__arg2: Rep[ForgeArray[T]],__arg3: Rep[ForgeArray[Int]],__arg4: Rep[Int])(implicit __pos: SourceContext): Rep[SparseVector[T]]
  def sparsevector_fromfunc[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Boolean],__arg2: Rep[IndexVector],__arg3: (Rep[Int]) => Rep[T])(implicit __pos: SourceContext): Rep[SparseVector[T]]
  def bsearch(a: Rep[ForgeArray[Int]],_start: Rep[Int],_end: Rep[Int],pos: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def defaultValue[T:Manifest]()(implicit __pos: SourceContext): Rep[T]
  def zipUnion[A:Manifest,B:Manifest,R:Manifest](nnzInit: Rep[Int],aIdxInit: Rep[Int],annz: Rep[Int],aIndices: Rep[ForgeArray[Int]],aData: Rep[ForgeArray[A]],bIdxInit: Rep[Int],bnnz: Rep[Int],bIndices: Rep[ForgeArray[Int]],bData: Rep[ForgeArray[B]],outIndices: Rep[ForgeArray[Int]],outData: Rep[ForgeArray[R]],f: (Rep[A],Rep[B]) => Rep[R])(implicit __pos: SourceContext): Rep[Int]
  def zipIntersect[A:Manifest,B:Manifest,R:Manifest](nnzInit: Rep[Int],aIdxInit: Rep[Int],annz: Rep[Int],aIndices: Rep[ForgeArray[Int]],aData: Rep[ForgeArray[A]],bIdxInit: Rep[Int],bnnz: Rep[Int],bIndices: Rep[ForgeArray[Int]],bData: Rep[ForgeArray[B]],outIndices: Rep[ForgeArray[Int]],outData: Rep[ForgeArray[R]],f: (Rep[A],Rep[B]) => Rep[R])(implicit __pos: SourceContext): Rep[Int]
  def sparsevector_find_offset[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def sparsevector_raw_data[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[ForgeArray[T]]
  def sparsevector_raw_indices[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext): Rep[ForgeArray[Int]]
  def sparsevector_set_length[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def sparsevector_set_isrow[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Boolean])(implicit __pos: SourceContext): Rep[Unit]
  def sparsevector_set_raw_data[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[ForgeArray[T]])(implicit __pos: SourceContext): Rep[Unit]
  def sparsevector_set_raw_indices[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[ForgeArray[Int]])(implicit __pos: SourceContext): Rep[Unit]
  def sparsevector_set_nnz[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def sparsevector_insert_at_off[T:Manifest](self: Rep[SparseVector[T]],off: Rep[Int],pos: Rep[Int],e: Rep[T])(implicit __pos: SourceContext): Rep[Unit]
  def sparsevector_insertspace[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def sparsevector_ensureextra[T:Manifest](self: Rep[SparseVector[T]],extra: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def sparsevector_realloc[T:Manifest](self: Rep[SparseVector[T]],minLen: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def zipVectorUnion[T:Manifest,B:Manifest,R:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext): Rep[SparseVector[R]]
  def zipVectorIntersect[T:Manifest,B:Manifest,R:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext): Rep[SparseVector[R]]
}

