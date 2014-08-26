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

trait IndexVectorOpsExp extends IndexVectorCompilerOps with DeliteCollectionOpsExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class IndexVector7Object_Apply(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Boolean])(implicit val __pos: SourceContext) extends DeliteStruct[IndexVector] {
    val elems = copyTransformedElems(collection.Seq(("_data",array_empty_imm[Int](unit(0))),("_start",__arg0),("_end",__arg1),("_isRow",__arg2),("_isRange",unit(true))))
  }

  case class IndexVector9Object_Apply(__arg0: Rep[DenseVector[Int]],__arg1: Rep[Boolean])(implicit val __pos: SourceContext) extends DeliteStruct[IndexVector] {
    val elems = copyTransformedElems(collection.Seq(("_data",indexvector_copyarray(__arg0)),("_start",unit(0)),("_end",unit(0)),("_isRow",__arg1),("_isRange",unit(false))))
  }

  case class Indexvector_fromarray(__arg0: Rep[ForgeArray[Int]],__arg1: Rep[Boolean])(implicit val __pos: SourceContext) extends DeliteStruct[IndexVector] {
    val elems = copyTransformedElems(collection.Seq(("_data",__arg0),("_start",unit(0)),("_end",unit(0)),("_isRow",__arg1),("_isRange",unit(false))))
  }

  case class IndexVector1_T(self: Rep[IndexVector])(implicit val __pos: SourceContext) extends DeliteStruct[IndexVector] {
    val elems = copyTransformedElems(collection.Seq(("_data",indexvector_raw_data(self)),("_start",indexvector_start(self)),("_end",indexvector_end(self)),("_isRow",!(indexvector_isrow(self))),("_isRange",indexvector_is_range(self))))
  }

  case class IndexVector2_Contains(self: Rep[IndexVector],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Boolean](reifyEffectsHere(indexvector_contains_impl2(self,__arg1)(__pos))) {
  }

  case class IndexVector1_Distinct(self: Rep[IndexVector])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[DenseVector[Int]](reifyEffectsHere(indexvector_distinct_impl1(self)(__pos))) {
  }

  case class IndexVector3_Mutable(self: Rep[IndexVector])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[DenseVector[Int]](reifyEffectsHere(indexvector_mutable_impl3(self)(__pos))) {
  }

  case class IndexVector1_Zip[B:Manifest,R:Manifest](self: Rep[IndexVector],__arg1: Rep[DenseVector[B]],__arg2: (Rep[Int],Rep[B]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpZipWith[Int,B,R,DenseVector[R]] {
    val _mB = implicitly[Manifest[B]]
    val _mR = implicitly[Manifest[R]]

    val inA = self
    val inB = __arg1
    def func = indexvector_zip_impl1_zip[B,R](self,__arg1,__arg2)(implicitly[Manifest[B]],implicitly[Manifest[R]],__pos)
    override def alloc(len: Exp[Int]) = densevector_dc_alloc[R,IndexVector](inA, len)
    val size = copyTransformedOrElse(_.size)(indexvector_length(inA))
    override val numDynamicChunks = 0
  }

  case class IndexVector2_Zip[B:Manifest,R:Manifest](self: Rep[IndexVector],__arg1: Rep[DenseVectorView[B]],__arg2: (Rep[Int],Rep[B]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpZipWith[Int,B,R,DenseVector[R]] {
    val _mB = implicitly[Manifest[B]]
    val _mR = implicitly[Manifest[R]]

    val inA = self
    val inB = __arg1
    def func = indexvector_zip_impl2_zip[B,R](self,__arg1,__arg2)(implicitly[Manifest[B]],implicitly[Manifest[R]],__pos)
    override def alloc(len: Exp[Int]) = densevector_dc_alloc[R,IndexVector](inA, len)
    val size = copyTransformedOrElse(_.size)(indexvector_length(inA))
    override val numDynamicChunks = 0
  }

  case class IndexVector1_Prod(self: Rep[IndexVector])(implicit val __pos: SourceContext) extends DeliteOpReduce[Int] {

    val in = self
    def func = indexvector_prod_impl1_reduce(self)(__pos)
    def zero = indexvector_prod_impl1_zero(self)(__pos)
    val size = copyTransformedOrElse(_.size)(indexvector_length(self)(__pos))
    override val numDynamicChunks = 0
  }

  case class IndexVector2_Min(self: Rep[IndexVector])(implicit val __pos: SourceContext) extends DeliteOpReduce[Int] {

    val in = self
    def func = indexvector_min_impl2_reduce(self)(__pos)
    def zero = indexvector_min_impl2_zero(self)(__pos)
    val size = copyTransformedOrElse(_.size)(indexvector_length(self)(__pos))
    override val numDynamicChunks = 0
  }

  case class IndexVector2_Max(self: Rep[IndexVector])(implicit val __pos: SourceContext) extends DeliteOpReduce[Int] {

    val in = self
    def func = indexvector_max_impl2_reduce(self)(__pos)
    def zero = indexvector_max_impl2_zero(self)(__pos)
    val size = copyTransformedOrElse(_.size)(indexvector_length(self)(__pos))
    override val numDynamicChunks = 0
  }

  case class IndexVector1_Map[R:Manifest](self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpMap[Int,R,DenseVector[R]] {
    val _mR = implicitly[Manifest[R]]

    val in = self
    def func = indexvector_map_impl1_map[R](self,__arg1)(implicitly[Manifest[R]],__pos)
    override def alloc(len: Exp[Int]) = densevector_dc_alloc[R,IndexVector](in, len)
    val size = copyTransformedOrElse(_.size)(indexvector_length(in))
    override val numDynamicChunks = 0
  }

  case class IndexVector1_Reduce(self: Rep[IndexVector],__arg1: (Rep[Int],Rep[Int]) => Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpReduce[Int] {

    val in = self
    def func = indexvector_reduce_impl1_reduce(self,__arg1)(__pos)
    def zero = indexvector_reduce_impl1_zero(self,__arg1)(__pos)
    val size = copyTransformedOrElse(_.size)(indexvector_length(self)(__pos))
    override val numDynamicChunks = 0
  }

  case class IndexVector1_Foreach(self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[Unit])(implicit val __pos: SourceContext) extends DeliteOpForeach[Int] {

    val in = self
    def func = indexvector_foreach_impl1_func(self,__arg1)(__pos)
    def sync = n => unit(List())
    val size = copyTransformedOrElse(_.size)(indexvector_length(self)(__pos))
    override val numDynamicChunks = 0
  }

  case class Indexvector_densevector_filter_map[R:Manifest](self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[Boolean],__arg2: (Rep[Int]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpFilter[Int,R,DenseVector[R]] {
    val _mR = implicitly[Manifest[R]]

    val in = self
    def cond = indexvector_densevector_filter_map_impl_cond[R](self,__arg1,__arg2)(implicitly[Manifest[R]],__pos)
    def func = indexvector_densevector_filter_map_impl_map[R](self,__arg1,__arg2)(implicitly[Manifest[R]],__pos)
    override def alloc(len: Exp[Int]) = densevector_dc_alloc[R,IndexVector](in, len)
    val size = copyTransformedOrElse(_.size)(indexvector_length(in))
    override val numDynamicChunks = 0
  }

  case class IndexVector1_Scan[R:Manifest](self: Rep[IndexVector],zero: Rep[R],__arg2: (Rep[R],Rep[Int]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[DenseVector[R]](reifyEffectsHere(indexvector_scan_impl1[R](self,zero,__arg2)(implicitly[Manifest[R]],__pos))) {
    val _mR = implicitly[Manifest[R]]
  }



  def indexvector_object_apply(__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload7) = {
    reflectPure(IndexVector7Object_Apply(__arg0,__arg1,__arg2)(__pos))
  }
  def indexvector_object_apply(__arg0: Rep[DenseVector[Int]],__arg1: Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload9) = {
    reflectPure(IndexVector9Object_Apply(__arg0,__arg1)(__pos))
  }
  def indexvector_fromarray(__arg0: Rep[ForgeArray[Int]],__arg1: Rep[Boolean])(implicit __pos: SourceContext) = {
    reflectPure(Indexvector_fromarray(__arg0,__arg1)(__pos))
  }
  def indexvector_copyarray(__arg0: Rep[DenseVector[Int]])(implicit __pos: SourceContext) = {
    indexvector_copyarray_impl(__arg0)(__pos)
  }
  def indexvector_start(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    field[Int](self,"_start")
  }
  def indexvector_end(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    field[Int](self,"_end")
  }
  def indexvector_raw_data(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    field[ForgeArray[Int]](self,"_data")
  }
  def indexvector_is_range(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    field[Boolean](self,"_isRange")
  }
  def indexvector_length(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_length_impl2(self)(__pos)
  }
  def indexvector_isrow(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    field[Boolean](self,"_isRow")
  }
  def indexvector_apply(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload5) = {
    indexvector_apply_impl5(self,__arg1)(__pos)
  }
  def indexvector_slice(self: Rep[IndexVector],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext) = {
    indexvector_slice_impl1(self,start,end)(__pos)
  }
  def indexvector_t(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    reflectPure(IndexVector1_T(self)(__pos))
  }
  def indexvector_clone(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_clone_impl2(self)(__pos)
  }
  def indexvector_todense(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_todense_impl2(self)(__pos)
  }
  def indexvector___equal(self: Rep[IndexVector],__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload4) = {
    indexvector___equal_impl4(self,__arg1)(__pos)
  }
  def indexvector___equal(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload5) = {
    indexvector___equal_impl5(self,__arg1)(__pos)
  }
  def indexvector_filter(self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    indexvector_filter_impl1(self,__arg1)(__pos)
  }
  def indexvector_indextodense(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_indextodense_impl(self)(__pos)
  }
  def indexvector_chainindextodenseops(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_chainindextodenseops_impl(self)(__pos)
  }
  def indexvector_chainindextodenseintops(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_chainindextodenseintops_impl(self)(__pos)
  }
  def indexvector_illegalalloc(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    indexvector_illegalalloc_impl(self,__arg1)(__pos)
  }
  def indexvector_illegalupdate(self: Rep[IndexVector],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext) = {
    indexvector_illegalupdate_impl(self,__arg1,__arg2)(__pos)
  }
  def zeroT()(implicit __pos: SourceContext) = {
    zeroT_impl()(__pos)
  }
  def indexvector_toboolean(self: Rep[IndexVector])(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Boolean]) = {
    indexvector_toboolean_impl1(self)(__pos,conv)
  }
  def indexvector_todouble(self: Rep[IndexVector])(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Double]) = {
    indexvector_todouble_impl2(self)(__pos,conv)
  }
  def indexvector_tofloat(self: Rep[IndexVector])(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Float]) = {
    indexvector_tofloat_impl2(self)(__pos,conv)
  }
  def indexvector_toint(self: Rep[IndexVector])(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Int]) = {
    indexvector_toint_impl2(self)(__pos,conv)
  }
  def indexvector_indices(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_indices_impl2(self)(__pos)
  }
  def indexvector_isempty(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_isempty_impl1(self)(__pos)
  }
  def indexvector_first(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_first_impl1(self)(__pos)
  }
  def indexvector_last(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_last_impl1(self)(__pos)
  }
  def indexvector_drop(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    indexvector_drop_impl1(self,__arg1)(__pos)
  }
  def indexvector_take(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    indexvector_take_impl1(self,__arg1)(__pos)
  }
  def indexvector_contains(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(IndexVector2_Contains(self,__arg1)(__pos))
  }
  def indexvector_distinct(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    reflectPure(IndexVector1_Distinct(self)(__pos))
  }
  def indexvector_mutable(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    reflectMutable(IndexVector3_Mutable(self)(__pos))
  }
  def indexvector_replicate(self: Rep[IndexVector],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext) = {
    indexvector_replicate_impl1(self,__arg1,__arg2)(__pos)
  }
  def indexvector_makestring(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_makestring_impl1(self)(__pos)
  }
  def indexvector_tostring(self: Rep[IndexVector]) = {
    indexvector_tostring_impl5(self)
  }
  def indexvector_pprint(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_pprint_impl1(self)(__pos)
  }
  def indexvector_pl(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload33) = {
    indexvector_pl_impl33(self,__arg1)(__pos)
  }
  def indexvector_sub(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload33) = {
    indexvector_sub_impl33(self,__arg1)(__pos)
  }
  def indexvector_mul(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload33) = {
    indexvector_mul_impl33(self,__arg1)(__pos)
  }
  def indexvector_mulclnmul(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload1) = {
    indexvector_mulclnmul_impl1(self,__arg1)(__pos)
  }
  def indexvector_mulmul(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload1) = {
    indexvector_mulmul_impl1(self,__arg1)(__pos)
  }
  def indexvector_div(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload34) = {
    indexvector_div_impl34(self,__arg1)(__pos)
  }
  def indexvector_pl(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload34) = {
    indexvector_pl_impl34(self,__arg1)(__pos)
  }
  def indexvector_sub(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload34) = {
    indexvector_sub_impl34(self,__arg1)(__pos)
  }
  def indexvector_mul(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload34) = {
    indexvector_mul_impl34(self,__arg1)(__pos)
  }
  def indexvector_mulclnmul(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload2) = {
    indexvector_mulclnmul_impl2(self,__arg1)(__pos)
  }
  def indexvector_mulmul(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload2) = {
    indexvector_mulmul_impl2(self,__arg1)(__pos)
  }
  def indexvector_div(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload35) = {
    indexvector_div_impl35(self,__arg1)(__pos)
  }
  def indexvector_pl(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload35) = {
    indexvector_pl_impl35(self,__arg1)(__pos)
  }
  def indexvector_sub(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload35) = {
    indexvector_sub_impl35(self,__arg1)(__pos)
  }
  def indexvector_mul(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload35) = {
    indexvector_mul_impl35(self,__arg1)(__pos)
  }
  def indexvector_mulclnmul(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload3) = {
    indexvector_mulclnmul_impl3(self,__arg1)(__pos)
  }
  def indexvector_mulmul(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload3) = {
    indexvector_mulmul_impl3(self,__arg1)(__pos)
  }
  def indexvector_div(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload36) = {
    indexvector_div_impl36(self,__arg1)(__pos)
  }
  def indexvector_pl(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload36) = {
    indexvector_pl_impl36(self,__arg1)(__pos)
  }
  def indexvector_sub(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload36) = {
    indexvector_sub_impl36(self,__arg1)(__pos)
  }
  def indexvector_mul(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload36) = {
    indexvector_mul_impl36(self,__arg1)(__pos)
  }
  def indexvector_mulclnmul(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload4) = {
    indexvector_mulclnmul_impl4(self,__arg1)(__pos)
  }
  def indexvector_mulmul(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload4) = {
    indexvector_mulmul_impl4(self,__arg1)(__pos)
  }
  def indexvector_div(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload37) = {
    indexvector_div_impl37(self,__arg1)(__pos)
  }
  def indexvector_zip[B:Manifest,R:Manifest](self: Rep[IndexVector],__arg1: Rep[DenseVector[B]],__arg2: (Rep[Int],Rep[B]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload1) = {
    reflectPure(IndexVector1_Zip[B,R](self,__arg1,__arg2)(implicitly[Manifest[B]],implicitly[Manifest[R]],__pos))
  }
  def indexvector_zip[B:Manifest,R:Manifest](self: Rep[IndexVector],__arg1: Rep[DenseVectorView[B]],__arg2: (Rep[Int],Rep[B]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload2) = {
    reflectPure(IndexVector2_Zip[B,R](self,__arg1,__arg2)(implicitly[Manifest[B]],implicitly[Manifest[R]],__pos))
  }
  def indexvector_pl(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload37) = {
    indexvector_pl_impl37(self,__arg1)(__pos)
  }
  def indexvector_sub(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload37) = {
    indexvector_sub_impl37(self,__arg1)(__pos)
  }
  def indexvector_mul(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload37) = {
    indexvector_mul_impl37(self,__arg1)(__pos)
  }
  def indexvector_mul(self: Rep[IndexVector],__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: Overload38) = {
    indexvector_mul_impl38(self,__arg1)(__pos)
  }
  def indexvector_div(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload38) = {
    indexvector_div_impl38(self,__arg1)(__pos)
  }
  def indexvector_abs(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_abs_impl5(self)(__pos)
  }
  def indexvector_exp(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_exp_impl5(self)(__pos)
  }
  def indexvector_log(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_log_impl5(self)(__pos)
  }
  def indexvector_sum(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_sum_impl1(self)(__pos)
  }
  def indexvector_prod(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    reflectPure(IndexVector1_Prod(self)(__pos))
  }
  def indexvector_mean(self: Rep[IndexVector])(implicit __pos: SourceContext,conv: (Rep[Int]) => Rep[Double]) = {
    indexvector_mean_impl1(self)(__pos,conv)
  }
  def indexvector_min(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    reflectPure(IndexVector2_Min(self)(__pos))
  }
  def indexvector_max(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    reflectPure(IndexVector2_Max(self)(__pos))
  }
  def indexvector_minindex(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_minindex_impl1(self)(__pos)
  }
  def indexvector_maxindex(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_maxindex_impl1(self)(__pos)
  }
  def indexvector_map[R:Manifest](self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[R])(implicit __pos: SourceContext) = {
    reflectPure(IndexVector1_Map[R](self,__arg1)(implicitly[Manifest[R]],__pos))
  }
  def indexvector_reduce(self: Rep[IndexVector],__arg1: (Rep[Int],Rep[Int]) => Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(IndexVector1_Reduce(self,__arg1)(__pos))
  }
  def indexvector_foreach(self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[Unit])(implicit __pos: SourceContext) = {
    reflectPure(IndexVector1_Foreach(self,__arg1)(__pos))
  }
  def indexvector_find(self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    indexvector_find_impl1(self,__arg1)(__pos)
  }
  def indexvector_densevector_filter_map[R:Manifest](self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[Boolean],__arg2: (Rep[Int]) => Rep[R])(implicit __pos: SourceContext) = {
    reflectPure(Indexvector_densevector_filter_map[R](self,__arg1,__arg2)(implicitly[Manifest[R]],__pos))
  }
  def indexvector_count(self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    indexvector_count_impl1(self,__arg1)(__pos)
  }
  def indexvector_partition(self: Rep[IndexVector],pred: (Rep[Int]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    indexvector_partition_impl1(self,pred)(__pos)
  }
  def indexvector_flatmap[R:Manifest](self: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[DenseVector[R]])(implicit __pos: SourceContext) = {
    indexvector_flatmap_impl1[R](self,__arg1)(implicitly[Manifest[R]],__pos)
  }
  def indexvector_scan[R:Manifest](self: Rep[IndexVector],zero: Rep[R],__arg2: (Rep[R],Rep[Int]) => Rep[R])(implicit __pos: SourceContext) = {
    reflectPure(IndexVector1_Scan[R](self,zero,__arg2)(implicitly[Manifest[R]],__pos))
  }
  def indexvector_prefixsum(self: Rep[IndexVector])(implicit __pos: SourceContext) = {
    indexvector_prefixsum_impl1(self)(__pos)
  }
  def indexvector_clncln(end: Rep[Int],start: Rep[Int]) = {
    indexvector_clncln_impl(end,start)
  }
  def indexvector_apply[T:Manifest](__arg0: Rep[IndexVector],__arg1: (Rep[Int]) => Rep[T])(implicit __pos: SourceContext,__imp1: Overload6) = {
    indexvector_apply_impl6[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def indexvector_apply[T:Manifest](__arg0: Tuple2[Rep[IndexVector],Rep[IndexVector]],__arg1: (Rep[Int],Rep[Int]) => Rep[T])(implicit __pos: SourceContext,__imp1: Overload7) = {
    indexvector_apply_impl7[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def indexvector_apply[T:Manifest](__arg0: Tuple2[Rep[IndexVector],IndexWildcard],__arg1: (Rep[Int]) => Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload8) = {
    indexvector_apply_impl8[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def indexvector_apply[T:Manifest](__arg0: Tuple2[IndexWildcard,Rep[IndexVector]],__arg1: (Rep[Int]) => Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload9) = {
    indexvector_apply_impl9[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos)
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
    case IndexVector3_Mutable(self) => Nil
    case _ => super.aliasSyms(e)
  }
  override def containSyms(e: Any): List[Sym[Any]] = e match {
    case IndexVector3_Mutable(self) => Nil
    case _ => super.containSyms(e)
  }
  override def extractSyms(e: Any): List[Sym[Any]] = e match {
    case IndexVector3_Mutable(self) => Nil
    case _ => super.extractSyms(e)
  }
  override def copySyms(e: Any): List[Sym[Any]] = e match {
    case IndexVector3_Mutable(self) => syms(self)
    case _ => super.copySyms(e)
  }

  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@IndexVector7Object_Apply(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with IndexVector7Object_Apply(f(__arg0),f(__arg1),f(__arg2))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@IndexVector7Object_Apply(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with IndexVector7Object_Apply(f(__arg0),f(__arg1),f(__arg2))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@IndexVector9Object_Apply(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with IndexVector9Object_Apply(f(__arg0),f(__arg1))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@IndexVector9Object_Apply(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with IndexVector9Object_Apply(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Indexvector_fromarray(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with Indexvector_fromarray(f(__arg0),f(__arg1))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Indexvector_fromarray(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Indexvector_fromarray(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@IndexVector1_T(__arg0) => reflectPure(new { override val original = Some(f,mn) } with IndexVector1_T(f(__arg0))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@IndexVector1_T(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with IndexVector1_T(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@IndexVector2_Contains(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with IndexVector2_Contains(f(__arg0),f(__arg1))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@IndexVector2_Contains(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with IndexVector2_Contains(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@IndexVector1_Distinct(__arg0) => reflectPure(new { override val original = Some(f,mn) } with IndexVector1_Distinct(f(__arg0))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@IndexVector1_Distinct(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with IndexVector1_Distinct(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@IndexVector3_Mutable(__arg0) => reflectPure(new { override val original = Some(f,mn) } with IndexVector3_Mutable(f(__arg0))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@IndexVector3_Mutable(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with IndexVector3_Mutable(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@IndexVector1_Zip(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with IndexVector1_Zip(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mB),mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@IndexVector1_Zip(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with IndexVector1_Zip(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mB),mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@IndexVector2_Zip(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with IndexVector2_Zip(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mB),mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@IndexVector2_Zip(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with IndexVector2_Zip(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mB),mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@IndexVector1_Prod(__arg0) => reflectPure(new { override val original = Some(f,mn) } with IndexVector1_Prod(f(__arg0))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@IndexVector1_Prod(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with IndexVector1_Prod(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@IndexVector2_Min(__arg0) => reflectPure(new { override val original = Some(f,mn) } with IndexVector2_Min(f(__arg0))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@IndexVector2_Min(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with IndexVector2_Min(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@IndexVector2_Max(__arg0) => reflectPure(new { override val original = Some(f,mn) } with IndexVector2_Max(f(__arg0))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@IndexVector2_Max(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with IndexVector2_Max(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@IndexVector1_Map(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with IndexVector1_Map(f(__arg0),f(__arg1))(mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@IndexVector1_Map(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with IndexVector1_Map(f(__arg0),f(__arg1))(mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@IndexVector1_Reduce(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with IndexVector1_Reduce(f(__arg0),f(__arg1))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@IndexVector1_Reduce(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with IndexVector1_Reduce(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@IndexVector1_Foreach(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with IndexVector1_Foreach(f(__arg0),f(__arg1))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@IndexVector1_Foreach(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with IndexVector1_Foreach(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Indexvector_densevector_filter_map(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Indexvector_densevector_filter_map(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Indexvector_densevector_filter_map(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Indexvector_densevector_filter_map(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@IndexVector1_Scan(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with IndexVector1_Scan(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@IndexVector1_Scan(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with IndexVector1_Scan(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]

  /**
   * Delite collection
   */
  def isIndexVector[A](x: Exp[DeliteCollection[A]])(implicit ctx: SourceContext) = isSubtype(x.tp.erasure,classOf[IndexVector])
  def asIndexVector[A](x: Exp[DeliteCollection[A]])(implicit ctx: SourceContext) = x.asInstanceOf[Exp[IndexVector]]

  override def dc_size[A:Manifest](x: Exp[DeliteCollection[A]])(implicit ctx: SourceContext) = {
    if (isIndexVector(x)) indexvector_length(asIndexVector(x))
    else super.dc_size(x)
  }

  override def dc_apply[A:Manifest](x: Exp[DeliteCollection[A]], n: Exp[Int])(implicit ctx: SourceContext) = {
    if (isIndexVector(x)) indexvector_apply(asIndexVector(x), n).asInstanceOf[Exp[A]]
    else super.dc_apply(x,n)
  }

  override def dc_update[A:Manifest](x: Exp[DeliteCollection[A]], n: Exp[Int], y: Exp[A])(implicit ctx: SourceContext) = {
    if (isIndexVector(x)) indexvector_illegalupdate(asIndexVector(x), n, y.asInstanceOf[Exp[Int]])
    else super.dc_update(x,n,y)
  }


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[IndexVector]) Some((classTag(m), collection.immutable.List(("_data",makeManifest(classOf[ForgeArray[_]], List(manifest[Int]))),("_start",manifest[Int]),("_end",manifest[Int]),("_isRow",manifest[Boolean]),("_isRange",manifest[Boolean]))))
    else super.unapplyStructType(m)
  }
  override def dc_data_field[A:Manifest](x: Exp[DeliteCollection[A]]) = {
    if (isIndexVector(x)) "_data"
    else super.dc_data_field(x)
  }

  override def dc_size_field[A:Manifest](x: Exp[DeliteCollection[A]]) = {
    if (isIndexVector(x)) "None"
    else super.dc_size_field(x)
  }
}

