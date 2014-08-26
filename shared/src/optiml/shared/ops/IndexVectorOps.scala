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

trait IndexVectorOpsBase extends Base {
  this: OptiML => 

  implicit def indexToDense(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = indexvector_indextodense(self)(__pos)
  implicit def chainIndexToDenseOps(self: Rep[IndexVector])(implicit __pos: SourceContext): DenseVectorDenseVectorOpsCls[Int] = indexvector_chainindextodenseops(self)(__pos)
  implicit def chainIndexToDenseIntOps(self: Rep[IndexVector])(implicit __pos: SourceContext): DenseVectorDenseVectorIntOpsCls = indexvector_chainindextodenseintops(self)(__pos)

  def indexvector_indextodense(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[DenseVector[Int]]
  def indexvector_chainindextodenseops(self: Rep[IndexVector])(implicit __pos: SourceContext): DenseVectorDenseVectorOpsCls[Int]
  def indexvector_chainindextodenseintops(self: Rep[IndexVector])(implicit __pos: SourceContext): DenseVectorDenseVectorIntOpsCls
}

trait IndexVectorOps extends IndexVectorOpsBase {
  this: OptiML => 

  object IndexVector {
    def apply(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload6): Rep[IndexVector] = { IndexVector(__arg0,__arg1,unit(true)) }
    def apply(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload7) = indexvector_object_apply(__arg0,__arg1,__arg2)(__pos,overload7)
    def apply(__arg0: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: ROverload8): Rep[IndexVector] = { IndexVector(__arg0,__arg0.isRow) }
    def apply(__arg0: Rep[DenseVector[Int]],__arg1: Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload9) = indexvector_object_apply(__arg0,__arg1)(__pos,overload9)
  }

  def flatten(inds: Tuple2[Rep[Int],Rep[Int]],dims: Tuple2[Rep[Int],Rep[Int]])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { inds._1*dims._2*1 + inds._2*1 }
  def unflatten(i: Rep[Int],dims: Tuple2[Rep[Int],Rep[Int]])(implicit __pos: SourceContext,__imp1: ROverload1): Tuple2[Rep[Int],Rep[Int]] = { ((i / (dims._2*1)) % dims._1,(i / (1)) % dims._2) }
  def flatten(inds: Tuple3[Rep[Int],Rep[Int],Rep[Int]],dims: Tuple3[Rep[Int],Rep[Int],Rep[Int]])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Int] = { inds._1*dims._2*dims._3*1 + inds._2*dims._3*1 + inds._3*1 }
  def unflatten(i: Rep[Int],dims: Tuple3[Rep[Int],Rep[Int],Rep[Int]])(implicit __pos: SourceContext,__imp1: ROverload2): Tuple3[Rep[Int],Rep[Int],Rep[Int]] = { ((i / (dims._2*dims._3*1)) % dims._1,(i / (dims._3*1)) % dims._2,(i / (1)) % dims._3) }
  def flatten(inds: Tuple4[Rep[Int],Rep[Int],Rep[Int],Rep[Int]],dims: Tuple4[Rep[Int],Rep[Int],Rep[Int],Rep[Int]])(implicit __pos: SourceContext,__imp1: ROverload3): Rep[Int] = { inds._1*dims._2*dims._3*dims._4*1 + inds._2*dims._3*dims._4*1 + inds._3*dims._4*1 + inds._4*1 }
  def unflatten(i: Rep[Int],dims: Tuple4[Rep[Int],Rep[Int],Rep[Int],Rep[Int]])(implicit __pos: SourceContext,__imp1: ROverload3): Tuple4[Rep[Int],Rep[Int],Rep[Int],Rep[Int]] = { ((i / (dims._2*dims._3*dims._4*1)) % dims._1,(i / (dims._3*dims._4*1)) % dims._2,(i / (dims._4*1)) % dims._3,(i / (1)) % dims._4) }
  def flatten(inds: Tuple5[Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int]],dims: Tuple5[Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int]])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[Int] = { inds._1*dims._2*dims._3*dims._4*dims._5*1 + inds._2*dims._3*dims._4*dims._5*1 + inds._3*dims._4*dims._5*1 + inds._4*dims._5*1 + inds._5*1 }
  def unflatten(i: Rep[Int],dims: Tuple5[Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int]])(implicit __pos: SourceContext,__imp1: ROverload4): Tuple5[Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int]] = { ((i / (dims._2*dims._3*dims._4*dims._5*1)) % dims._1,(i / (dims._3*dims._4*dims._5*1)) % dims._2,(i / (dims._4*dims._5*1)) % dims._3,(i / (dims._5*1)) % dims._4,(i / (1)) % dims._5) }
  def flatten(inds: Tuple6[Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int]],dims: Tuple6[Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int]])(implicit __pos: SourceContext,__imp1: ROverload5): Rep[Int] = { inds._1*dims._2*dims._3*dims._4*dims._5*dims._6*1 + inds._2*dims._3*dims._4*dims._5*dims._6*1 + inds._3*dims._4*dims._5*dims._6*1 + inds._4*dims._5*dims._6*1 + inds._5*dims._6*1 + inds._6*1 }
  def unflatten(i: Rep[Int],dims: Tuple6[Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int]])(implicit __pos: SourceContext,__imp1: ROverload5): Tuple6[Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int]] = { ((i / (dims._2*dims._3*dims._4*dims._5*dims._6*1)) % dims._1,(i / (dims._3*dims._4*dims._5*dims._6*1)) % dims._2,(i / (dims._4*dims._5*dims._6*1)) % dims._3,(i / (dims._5*dims._6*1)) % dims._4,(i / (dims._6*1)) % dims._5,(i / (1)) % dims._6) }
  def __equal(self: Rep[IndexVector],__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload4) = indexvector___equal(self,__arg1)(__pos,overload4)
  def __equal(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload5) = indexvector___equal(self,__arg1)(__pos,overload5)

  implicit def repToIndexVectorIndexVectorOpsCls(x: Rep[IndexVector])(implicit __pos: SourceContext) = new IndexVectorIndexVectorOpsCls(x)(__pos)
  implicit def varToIndexVectorIndexVectorOpsCls(x: Var[IndexVector])(implicit __pos: SourceContext) = new IndexVectorIndexVectorOpsCls(readVar(x))(__pos)

  class IndexVectorIndexVectorOpsCls(val self: Rep[IndexVector])(implicit __pos: SourceContext) {
    def apply(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload5) = indexvector_apply(self,__arg1)(__pos,overload5)
    def filter(__arg1: (Rep[Int]) => Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_filter(self,__arg1)(__pos)
    def toBoolean(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Boolean],__imp2: Overload1) = indexvector_toboolean(self)(__pos,conv)
    def toDouble(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Double],__imp2: Overload2) = indexvector_todouble(self)(__pos,conv)
    def toFloat(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Float],__imp2: Overload2) = indexvector_tofloat(self)(__pos,conv)
    def toInt(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Int],__imp2: Overload2) = indexvector_toint(self)(__pos,conv)
    def -(__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload33) = indexvector_sub(self,__arg1)(__pos,overload33)
    def *(__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload33) = indexvector_mul(self,__arg1)(__pos,overload33)
    def /(__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload34) = indexvector_div(self,__arg1)(__pos,overload34)
    def -(__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload34) = indexvector_sub(self,__arg1)(__pos,overload34)
    def *(__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload34) = indexvector_mul(self,__arg1)(__pos,overload34)
    def /(__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload35) = indexvector_div(self,__arg1)(__pos,overload35)
    def -(__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload35) = indexvector_sub(self,__arg1)(__pos,overload35)
    def *(__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload35) = indexvector_mul(self,__arg1)(__pos,overload35)
    def /(__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload36) = indexvector_div(self,__arg1)(__pos,overload36)
    def -(__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload36) = indexvector_sub(self,__arg1)(__pos,overload36)
    def *(__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload36) = indexvector_mul(self,__arg1)(__pos,overload36)
    def /(__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload37) = indexvector_div(self,__arg1)(__pos,overload37)
    def zip[B:Manifest,R:Manifest](__arg1: Rep[DenseVector[B]])(__arg2: (Rep[Int],Rep[B]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_zip[B,R](self,__arg1,__arg2)(implicitly[Manifest[B]],implicitly[Manifest[R]],__pos,overload1)
    def zip[B:Manifest,R:Manifest](__arg1: Rep[DenseVectorView[B]])(__arg2: (Rep[Int],Rep[B]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload2) = indexvector_zip[B,R](self,__arg1,__arg2)(implicitly[Manifest[B]],implicitly[Manifest[R]],__pos,overload2)
    def -(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload37) = indexvector_sub(self,__arg1)(__pos,overload37)
    def *(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload37) = indexvector_mul(self,__arg1)(__pos,overload37)
    def *(__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: Overload38) = indexvector_mul(self,__arg1)(__pos,overload38)
    def /(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload38) = indexvector_div(self,__arg1)(__pos,overload38)
    def mean(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Double],__imp2: Overload1) = indexvector_mean(self)(__pos,conv)
    def map[R:Manifest](__arg1: (Rep[Int]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_map[R](self,__arg1)(implicitly[Manifest[R]],__pos)
    def reduce(__arg1: (Rep[Int],Rep[Int]) => Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_reduce(self,__arg1)(__pos)
    def foreach(__arg1: (Rep[Int]) => Rep[Unit])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_foreach(self,__arg1)(__pos)
    def find(__arg1: (Rep[Int]) => Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_find(self,__arg1)(__pos)
    def count(__arg1: (Rep[Int]) => Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_count(self,__arg1)(__pos)
    def partition(pred: (Rep[Int]) => Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_partition(self,pred)(__pos)
    def flatMap[R:Manifest](__arg1: (Rep[Int]) => Rep[DenseVector[R]])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_flatmap[R](self,__arg1)(implicitly[Manifest[R]],__pos)
    def scan[R:Manifest](zero: Rep[R])(__arg2: (Rep[R],Rep[Int]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_scan[R](self,zero,__arg2)(implicitly[Manifest[R]],__pos)
    def apply[T:Manifest](__arg1: (Rep[Int]) => Rep[T])(implicit __pos: SourceContext,__imp1: Overload6) = indexvector_apply[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload6)
  }

  implicit def liftToIndexVectorTuple2IndexVectorIndexVectorOpsCls(x: Tuple2[Rep[IndexVector],Rep[IndexVector]])(implicit __pos: SourceContext) = new IndexVectorTuple2IndexVectorIndexVectorOpsCls(x)(__pos)

  class IndexVectorTuple2IndexVectorIndexVectorOpsCls(val self: Tuple2[Rep[IndexVector],Rep[IndexVector]])(implicit __pos: SourceContext) {
    def apply[T:Manifest](__arg1: (Rep[Int],Rep[Int]) => Rep[T])(implicit __pos: SourceContext,__imp1: Overload7) = indexvector_apply[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload7)
  }

  implicit def liftToIndexVectorTuple2IndexVectorIndexWildcardOpsCls(x: Tuple2[Rep[IndexVector],IndexWildcard])(implicit __pos: SourceContext) = new IndexVectorTuple2IndexVectorIndexWildcardOpsCls(x)(__pos)

  class IndexVectorTuple2IndexVectorIndexWildcardOpsCls(val self: Tuple2[Rep[IndexVector],IndexWildcard])(implicit __pos: SourceContext) {
    def apply[T:Manifest](__arg1: (Rep[Int]) => Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload8) = indexvector_apply[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload8)
  }

  implicit def liftToIndexVectorTuple2IndexWildcardIndexVectorOpsCls(x: Tuple2[IndexWildcard,Rep[IndexVector]])(implicit __pos: SourceContext) = new IndexVectorTuple2IndexWildcardIndexVectorOpsCls(x)(__pos)

  class IndexVectorTuple2IndexWildcardIndexVectorOpsCls(val self: Tuple2[IndexWildcard,Rep[IndexVector]])(implicit __pos: SourceContext) {
    def apply[T:Manifest](__arg1: (Rep[Int]) => Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload9) = indexvector_apply[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload9)
  }


  def infix_length(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload2) = indexvector_length(self)(__pos)
  def infix_isRow(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload2) = indexvector_isrow(self)(__pos)
  def infix_slice(self: Rep[IndexVector],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_slice(self,start,end)(__pos)
  def infix_t(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_t(self)(__pos)
  def infix_Clone(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload2) = indexvector_clone(self)(__pos)
  def infix_toDense(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload2) = indexvector_todense(self)(__pos)
  def infix_indices(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload2) = indexvector_indices(self)(__pos)
  def infix_isEmpty(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_isempty(self)(__pos)
  def infix_first(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_first(self)(__pos)
  def infix_last(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_last(self)(__pos)
  def infix_drop(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_drop(self,__arg1)(__pos)
  def infix_take(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_take(self,__arg1)(__pos)
  def infix_contains(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = indexvector_contains(self,__arg1)(__pos)
  def infix_distinct(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_distinct(self)(__pos)
  def infix_mutable(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload3) = indexvector_mutable(self)(__pos)
  def infix_replicate(self: Rep[IndexVector],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_replicate(self,__arg1,__arg2)(__pos)
  def infix_makeString(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_makestring(self)(__pos)
  def infix_toString(self: Rep[IndexVector])(implicit __imp0: Overload5) = indexvector_tostring(self)
  def infix_pprint(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_pprint(self)(__pos)
  def infix_+(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload33) = indexvector_pl(self,__arg1)(__pos,overload33)
  def infix_*:*(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_mulclnmul(self,__arg1)(__pos,overload1)
  def infix_**(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_mulmul(self,__arg1)(__pos,overload1)
  def infix_+(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload34) = indexvector_pl(self,__arg1)(__pos,overload34)
  def infix_*:*(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload2) = indexvector_mulclnmul(self,__arg1)(__pos,overload2)
  def infix_**(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload2) = indexvector_mulmul(self,__arg1)(__pos,overload2)
  def infix_+(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload35) = indexvector_pl(self,__arg1)(__pos,overload35)
  def infix_*:*(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload3) = indexvector_mulclnmul(self,__arg1)(__pos,overload3)
  def infix_**(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload3) = indexvector_mulmul(self,__arg1)(__pos,overload3)
  def infix_+(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload36) = indexvector_pl(self,__arg1)(__pos,overload36)
  def infix_*:*(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload4) = indexvector_mulclnmul(self,__arg1)(__pos,overload4)
  def infix_**(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload4) = indexvector_mulmul(self,__arg1)(__pos,overload4)
  def infix_+(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload37) = indexvector_pl(self,__arg1)(__pos,overload37)
  def infix_abs(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload5) = indexvector_abs(self)(__pos)
  def infix_exp(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload5) = indexvector_exp(self)(__pos)
  def infix_log(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload5) = indexvector_log(self)(__pos)
  def infix_sum(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_sum(self)(__pos)
  def infix_prod(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_prod(self)(__pos)
  def infix_min(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload2) = indexvector_min(self)(__pos)
  def infix_max(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload2) = indexvector_max(self)(__pos)
  def infix_minIndex(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_minindex(self)(__pos)
  def infix_maxIndex(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_maxindex(self)(__pos)
  def infix_prefixSum(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_prefixsum(self)(__pos)
  def infix_::(end: Rep[Int],start: Rep[Int]) = indexvector_clncln(end,start)

  def indexvector_object_apply(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload7): Rep[IndexVector]
  def indexvector_object_apply(__arg0: Rep[DenseVector[Int]],__arg1: Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload9): Rep[IndexVector]
  def indexvector_length(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Int]
  def indexvector_isrow(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Boolean]
  def indexvector_apply(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload5): Rep[Int]
  def indexvector_slice(self: Rep[IndexVector],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext): Rep[IndexVector]
  def indexvector_t(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[IndexVector]
  def indexvector_clone(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[IndexVector]
  def indexvector_todense(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[DenseVector[Int]]
  def indexvector___equal(self: Rep[IndexVector],__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload4): Rep[Boolean]
  def indexvector___equal(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload5): Rep[Boolean]
  def indexvector_filter(self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[IndexVector]
  def indexvector_toboolean(self: Rep[IndexVector])(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Boolean]): Rep[DenseVector[Boolean]]
  def indexvector_todouble(self: Rep[IndexVector])(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Double]): Rep[DenseVector[Double]]
  def indexvector_tofloat(self: Rep[IndexVector])(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Float]): Rep[DenseVector[Float]]
  def indexvector_toint(self: Rep[IndexVector])(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Int]): Rep[DenseVector[Int]]
  def indexvector_indices(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[IndexVector]
  def indexvector_isempty(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Boolean]
  def indexvector_first(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Int]
  def indexvector_last(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Int]
  def indexvector_drop(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[IndexVector]
  def indexvector_take(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[IndexVector]
  def indexvector_contains(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Boolean]
  def indexvector_distinct(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[DenseVector[Int]]
  def indexvector_mutable(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[DenseVector[Int]]
  def indexvector_replicate(self: Rep[IndexVector],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext): Rep[DenseMatrix[Int]]
  def indexvector_makestring(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[String]
  def indexvector_tostring(self: Rep[IndexVector]): Rep[String]
  def indexvector_pprint(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Unit]
  def indexvector_pl(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload33): Rep[DenseVector[Int]]
  def indexvector_sub(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload33): Rep[DenseVector[Int]]
  def indexvector_mul(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload33): Rep[DenseVector[Int]]
  def indexvector_mulclnmul(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload1): Rep[Int]
  def indexvector_mulmul(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload1): Rep[DenseMatrix[Int]]
  def indexvector_div(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload34): Rep[DenseVector[Int]]
  def indexvector_pl(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload34): Rep[DenseVector[Int]]
  def indexvector_sub(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload34): Rep[DenseVector[Int]]
  def indexvector_mul(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload34): Rep[DenseVector[Int]]
  def indexvector_mulclnmul(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload2): Rep[Int]
  def indexvector_mulmul(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload2): Rep[DenseMatrix[Int]]
  def indexvector_div(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload35): Rep[DenseVector[Int]]
  def indexvector_pl(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload35): Rep[DenseVector[Int]]
  def indexvector_sub(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload35): Rep[DenseVector[Int]]
  def indexvector_mul(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload35): Rep[DenseVector[Int]]
  def indexvector_mulclnmul(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload3): Rep[Int]
  def indexvector_mulmul(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload3): Rep[DenseMatrix[Int]]
  def indexvector_div(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload36): Rep[DenseVector[Int]]
  def indexvector_pl(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload36): Rep[DenseVector[Int]]
  def indexvector_sub(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload36): Rep[DenseVector[Int]]
  def indexvector_mul(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload36): Rep[DenseVector[Int]]
  def indexvector_mulclnmul(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload4): Rep[Int]
  def indexvector_mulmul(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload4): Rep[DenseMatrix[Int]]
  def indexvector_div(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload37): Rep[DenseVector[Int]]
  def indexvector_zip[B:Manifest,R:Manifest](self: Rep[IndexVector],__arg1: Rep[DenseVector[B]],__arg2: (Rep[Int],Rep[B]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload1): Rep[DenseVector[R]]
  def indexvector_zip[B:Manifest,R:Manifest](self: Rep[IndexVector],__arg1: Rep[DenseVectorView[B]],__arg2: (Rep[Int],Rep[B]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload2): Rep[DenseVector[R]]
  def indexvector_pl(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload37): Rep[DenseVector[Int]]
  def indexvector_sub(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload37): Rep[DenseVector[Int]]
  def indexvector_mul(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload37): Rep[DenseVector[Int]]
  def indexvector_mul(self: Rep[IndexVector],__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: Overload38): Rep[DenseVector[Int]]
  def indexvector_div(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload38): Rep[DenseVector[Int]]
  def indexvector_abs(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[DenseVector[Int]]
  def indexvector_exp(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[DenseVector[Int]]
  def indexvector_log(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[DenseVector[Int]]
  def indexvector_sum(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Int]
  def indexvector_prod(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Int]
  def indexvector_mean(self: Rep[IndexVector])(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Double]): Rep[Double]
  def indexvector_min(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Int]
  def indexvector_max(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Int]
  def indexvector_minindex(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Int]
  def indexvector_maxindex(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Int]
  def indexvector_map[R:Manifest](self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]]
  def indexvector_reduce(self: Rep[IndexVector],__arg1: (Rep[Int],Rep[Int]) => Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def indexvector_foreach(self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit]
  def indexvector_find(self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[IndexVector]
  def indexvector_count(self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[Int]
  def indexvector_partition(self: Rep[IndexVector],pred: (Rep[Int]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[Tup2[DenseVector[Int],DenseVector[Int]]]
  def indexvector_flatmap[R:Manifest](self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[DenseVector[R]])(implicit __pos: SourceContext): Rep[DenseVector[R]]
  def indexvector_scan[R:Manifest](self: Rep[IndexVector],zero: Rep[R],__arg2: (Rep[R],Rep[Int]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]]
  def indexvector_prefixsum(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[DenseVector[Int]]
  def indexvector_clncln(end: Rep[Int],start: Rep[Int]): Rep[IndexVector]
  def indexvector_apply[T:Manifest](__arg0: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[T])(implicit __pos: SourceContext,__imp1: Overload6): Rep[DenseVector[T]]
  def indexvector_apply[T:Manifest](__arg0: Tuple2[Rep[IndexVector],Rep[IndexVector]],__arg1: (Rep[Int],Rep[Int]) => Rep[T])(implicit __pos: SourceContext,__imp1: Overload7): Rep[DenseMatrix[T]]
  def indexvector_apply[T:Manifest](__arg0: Tuple2[Rep[IndexVector],IndexWildcard],__arg1: (Rep[Int]) => Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload8): Rep[DenseMatrix[T]]
  def indexvector_apply[T:Manifest](__arg0: Tuple2[IndexWildcard,Rep[IndexVector]],__arg1: (Rep[Int]) => Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload9): Rep[DenseMatrix[T]]
}
trait IndexVectorCompilerOps extends IndexVectorOps {
  this: OptiML => 

  def indexvector_fromarray(__arg0: Rep[ForgeArray[Int]],__arg1: Rep[Boolean])(implicit __pos: SourceContext): Rep[IndexVector]
  def indexvector_copyarray(__arg0: Rep[DenseVector[Int]])(implicit __pos: SourceContext): Rep[ForgeArray[Int]]
  def indexvector_start(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Int]
  def indexvector_end(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Int]
  def indexvector_raw_data(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[ForgeArray[Int]]
  def indexvector_is_range(self: Rep[IndexVector])(implicit __pos: SourceContext): Rep[Boolean]
  def indexvector_illegalalloc(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Nothing]
  def indexvector_illegalupdate(self: Rep[IndexVector],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext): Rep[Nothing]
  def zeroT()(implicit __pos: SourceContext): Rep[Int]
  def indexvector_densevector_filter_map[R:Manifest](self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[Boolean],__arg2: (Rep[Int]) => Rep[R])(implicit __pos: SourceContext): Rep[DenseVector[R]]
}

