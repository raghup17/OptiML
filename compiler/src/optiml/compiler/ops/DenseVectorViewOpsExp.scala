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

trait DenseVectorViewOpsExp extends DenseVectorViewCompilerOps with DeliteCollectionOpsExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class DenseVectorView18Object_Apply[T:Manifest](__arg0: Rep[ForgeArray[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[Int],__arg4: Rep[Boolean])(implicit val __pos: SourceContext) extends DeliteStruct[DenseVectorView[T]] {
    val _mT = implicitly[Manifest[T]]
    val elems = copyTransformedElems(collection.Seq(("_data",__arg0),("_start",__arg1),("_stride",__arg2),("_length",__arg3),("_isRow",__arg4)))
  }

  case class DenseVectorView7_Contains[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Boolean](reifyEffectsHere(densevectorview_contains_impl7[T](self,__arg1)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class DenseVectorView3_Distinct[T:Manifest](self: Rep[DenseVectorView[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[DenseVector[T]](reifyEffectsHere(densevectorview_distinct_impl3[T](self)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class DenseVectorView12_Mutable[T:Manifest](self: Rep[DenseVectorView[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[DenseVector[T]](reifyEffectsHere(densevectorview_mutable_impl12[T](self)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class DenseVectorView3_Zip[T:Manifest,B:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpZipWith[T,B,R,DenseVector[R]] {
    val _mT = implicitly[Manifest[T]]
    val _mB = implicitly[Manifest[B]]
    val _mR = implicitly[Manifest[R]]

    val inA = self
    val inB = __arg1
    def func = densevectorview_zip_impl3_zip[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos)
    override def alloc(len: Exp[Int]) = densevector_dc_alloc[R,DenseVectorView[T]](inA, len)
    val size = copyTransformedOrElse(_.size)(densevectorview_length(inA))
    override val numDynamicChunks = 0
  }

  case class DenseVectorView4_Zip[T:Manifest,B:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpZipWith[T,B,R,DenseVector[R]] {
    val _mT = implicitly[Manifest[T]]
    val _mB = implicitly[Manifest[B]]
    val _mR = implicitly[Manifest[R]]

    val inA = self
    val inB = __arg1
    def func = densevectorview_zip_impl4_zip[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos)
    override def alloc(len: Exp[Int]) = densevector_dc_alloc[R,DenseVectorView[T]](inA, len)
    val size = copyTransformedOrElse(_.size)(densevectorview_length(inA))
    override val numDynamicChunks = 0
  }

  case class DenseVectorView2_Prod[T:Manifest](self: Rep[DenseVectorView[T]])(implicit val __pos: SourceContext,val __imp0: Arith[T]) extends DeliteOpReduce[T] {
    val _mT = implicitly[Manifest[T]]

    val in = self
    def func = densevectorview_prod_impl2_reduce[T](self)(implicitly[Manifest[T]],__pos,__imp0)
    def zero = densevectorview_prod_impl2_zero[T](self)(implicitly[Manifest[T]],__pos,__imp0)
    val size = copyTransformedOrElse(_.size)(densevectorview_length[T](self)(implicitly[Manifest[T]],__pos))
    override val numDynamicChunks = 0
  }

  case class DenseVectorView4_Min[T:Manifest](self: Rep[DenseVectorView[T]])(implicit val __pos: SourceContext,val __imp0: Ordering[T]) extends DeliteOpReduce[T] {
    val _mT = implicitly[Manifest[T]]

    val in = self
    def func = densevectorview_min_impl4_reduce[T](self)(implicitly[Manifest[T]],__pos,__imp0)
    def zero = densevectorview_min_impl4_zero[T](self)(implicitly[Manifest[T]],__pos,__imp0)
    val size = copyTransformedOrElse(_.size)(densevectorview_length[T](self)(implicitly[Manifest[T]],__pos))
    override val numDynamicChunks = 0
  }

  case class DenseVectorView4_Max[T:Manifest](self: Rep[DenseVectorView[T]])(implicit val __pos: SourceContext,val __imp0: Ordering[T]) extends DeliteOpReduce[T] {
    val _mT = implicitly[Manifest[T]]

    val in = self
    def func = densevectorview_max_impl4_reduce[T](self)(implicitly[Manifest[T]],__pos,__imp0)
    def zero = densevectorview_max_impl4_zero[T](self)(implicitly[Manifest[T]],__pos,__imp0)
    val size = copyTransformedOrElse(_.size)(densevectorview_length[T](self)(implicitly[Manifest[T]],__pos))
    override val numDynamicChunks = 0
  }

  case class DenseVectorView2_Map[T:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpMap[T,R,DenseVector[R]] {
    val _mT = implicitly[Manifest[T]]
    val _mR = implicitly[Manifest[R]]

    val in = self
    def func = densevectorview_map_impl2_map[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
    override def alloc(len: Exp[Int]) = densevector_dc_alloc[R,DenseVectorView[T]](in, len)
    val size = copyTransformedOrElse(_.size)(densevectorview_length(in))
    override val numDynamicChunks = 0
  }

  case class DenseVectorView2_Reduce[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T],Rep[T]) => Rep[T])(implicit val __pos: SourceContext,val __imp0: Arith[T]) extends DeliteOpReduce[T] {
    val _mT = implicitly[Manifest[T]]

    val in = self
    def func = densevectorview_reduce_impl2_reduce[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
    def zero = densevectorview_reduce_impl2_zero[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
    val size = copyTransformedOrElse(_.size)(densevectorview_length[T](self)(implicitly[Manifest[T]],__pos))
    override val numDynamicChunks = 0
  }

  case class DenseVectorView3_Foreach[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[Unit])(implicit val __pos: SourceContext) extends DeliteOpForeach[T] {
    val _mT = implicitly[Manifest[T]]

    val in = self
    def func = densevectorview_foreach_impl3_func[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def sync = n => unit(List())
    val size = copyTransformedOrElse(_.size)(densevectorview_length[T](self)(implicitly[Manifest[T]],__pos))
    override val numDynamicChunks = 0
  }

  case class Densevectorview_densevector_filter_map[T:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[Boolean],__arg2: (Rep[T]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpFilter[T,R,DenseVector[R]] {
    val _mT = implicitly[Manifest[T]]
    val _mR = implicitly[Manifest[R]]

    val in = self
    def cond = densevectorview_densevector_filter_map_impl_cond[T,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
    def func = densevectorview_densevector_filter_map_impl_map[T,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
    override def alloc(len: Exp[Int]) = densevector_dc_alloc[R,DenseVectorView[T]](in, len)
    val size = copyTransformedOrElse(_.size)(densevectorview_length(in))
    override val numDynamicChunks = 0
  }

  case class DenseVectorView2_Scan[T:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],zero: Rep[R],__arg2: (Rep[R],Rep[T]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[DenseVector[R]](reifyEffectsHere(densevectorview_scan_impl2[T,R](self,zero,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos))) {
    val _mT = implicitly[Manifest[T]]
    val _mR = implicitly[Manifest[R]]
  }



  def densevectorview_object_apply[T:Manifest](__arg0: Rep[ForgeArray[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[Int],__arg4: Rep[Boolean])(implicit __pos: SourceContext) = {
    reflectPure(DenseVectorView18Object_Apply[T](__arg0,__arg1,__arg2,__arg3,__arg4)(implicitly[Manifest[T]],__pos))
  }
  def densevectorview_data[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    field[ForgeArray[T]](self,"_data")
  }
  def densevectorview_start[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    field[Int](self,"_start")
  }
  def densevectorview_stride[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    field[Int](self,"_stride")
  }
  def densevectorview_length[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    field[Int](self,"_length")
  }
  def densevectorview_isrow[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    field[Boolean](self,"_isRow")
  }
  def densevectorview_apply[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densevectorview_apply_impl19[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_slice[T:Manifest](self: Rep[DenseVectorView[T]],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext) = {
    densevectorview_slice_impl4[T](self,start,end)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_todense[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    densevectorview_todense_impl4[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview___equal[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densevectorview___equal_impl9[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_viewtodense[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    densevectorview_viewtodense_impl[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_chainviewtodenseops[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    densevectorview_chainviewtodenseops_impl[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_illegalalloc[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densevectorview_illegalalloc_impl[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_illegalupdate[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext) = {
    densevectorview_illegalupdate_impl[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_toboolean[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Boolean]) = {
    densevectorview_toboolean_impl3[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densevectorview_todouble[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]) = {
    densevectorview_todouble_impl4[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densevectorview_tofloat[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Float]) = {
    densevectorview_tofloat_impl4[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densevectorview_toint[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Int]) = {
    densevectorview_toint_impl4[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densevectorview_indices[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    densevectorview_indices_impl4[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_isempty[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    densevectorview_isempty_impl3[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_first[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    densevectorview_first_impl3[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_last[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    densevectorview_last_impl3[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_drop[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densevectorview_drop_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_take[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densevectorview_take_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_contains[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext) = {
    reflectPure(DenseVectorView7_Contains[T](self,__arg1)(implicitly[Manifest[T]],__pos))
  }
  def densevectorview_distinct[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    reflectPure(DenseVectorView3_Distinct[T](self)(implicitly[Manifest[T]],__pos))
  }
  def densevectorview_mutable[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
    reflectMutable(DenseVectorView12_Mutable[T](self)(implicitly[Manifest[T]],__pos))
  }
  def densevectorview_replicate[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext) = {
    densevectorview_replicate_impl2[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_makestring[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]) = {
    densevectorview_makestring_impl4[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_tostring[T:Manifest](self: Rep[DenseVectorView[T]]) = {
    densevectorview_tostring_impl11[T](self)
  }
  def densevectorview_pprint[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]) = {
    densevectorview_pprint_impl4[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_pl[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload63) = {
    densevectorview_pl_impl63[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_sub[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload47) = {
    densevectorview_sub_impl47[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload49) = {
    densevectorview_mul_impl49[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mulclnmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload7) = {
    densevectorview_mulclnmul_impl7[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mulmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload6) = {
    densevectorview_mulmul_impl6[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_div[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload48) = {
    densevectorview_div_impl48[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_pl[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload64) = {
    densevectorview_pl_impl64[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_sub[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload48) = {
    densevectorview_sub_impl48[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload50) = {
    densevectorview_mul_impl50[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mulclnmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload8) = {
    densevectorview_mulclnmul_impl8[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mulmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload7) = {
    densevectorview_mulmul_impl7[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_div[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload49) = {
    densevectorview_div_impl49[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_pl[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload65) = {
    densevectorview_pl_impl65[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_sub[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload49) = {
    densevectorview_sub_impl49[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload51) = {
    densevectorview_mul_impl51[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mulclnmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload9) = {
    densevectorview_mulclnmul_impl9[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mulmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload8) = {
    densevectorview_mulmul_impl8[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_div[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload50) = {
    densevectorview_div_impl50[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_pl[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload66) = {
    densevectorview_pl_impl66[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_sub[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload50) = {
    densevectorview_sub_impl50[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload52) = {
    densevectorview_mul_impl52[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mulclnmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload10) = {
    densevectorview_mulclnmul_impl10[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mulmul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload9) = {
    densevectorview_mulmul_impl9[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_div[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload51) = {
    densevectorview_div_impl51[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_zip[T:Manifest,B:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload3) = {
    reflectPure(DenseVectorView3_Zip[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos))
  }
  def densevectorview_zip[T:Manifest,B:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload4) = {
    reflectPure(DenseVectorView4_Zip[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos))
  }
  def densevectorview_pl[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload67) = {
    densevectorview_pl_impl67[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_sub[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload51) = {
    densevectorview_sub_impl51[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload53) = {
    densevectorview_mul_impl53[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_mul[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload54) = {
    densevectorview_mul_impl54[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_div[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload52) = {
    densevectorview_div_impl52[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_abs[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevectorview_abs_impl13[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_exp[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevectorview_exp_impl12[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_log[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevectorview_log_impl12[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_sum[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevectorview_sum_impl3[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_prod[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    reflectPure(DenseVectorView2_Prod[T](self)(implicitly[Manifest[T]],__pos,__imp0))
  }
  def densevectorview_mean[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]) = {
    densevectorview_mean_impl3[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densevectorview_min[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    reflectPure(DenseVectorView4_Min[T](self)(implicitly[Manifest[T]],__pos,__imp0))
  }
  def densevectorview_max[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    reflectPure(DenseVectorView4_Max[T](self)(implicitly[Manifest[T]],__pos,__imp0))
  }
  def densevectorview_minindex[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp1: Arith[T]) = {
    densevectorview_minindex_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0,__imp1)
  }
  def densevectorview_maxindex[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp1: Arith[T]) = {
    densevectorview_maxindex_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0,__imp1)
  }
  def densevectorview_map[T:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext) = {
    reflectPure(DenseVectorView2_Map[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos))
  }
  def densevectorview_reduce[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    reflectPure(DenseVectorView2_Reduce[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0))
  }
  def densevectorview_foreach[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext) = {
    reflectPure(DenseVectorView3_Foreach[T](self,__arg1)(implicitly[Manifest[T]],__pos))
  }
  def densevectorview_find[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    densevectorview_find_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_densevector_filter_map[T:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[Boolean],__arg2: (Rep[T]) => Rep[R])(implicit __pos: SourceContext) = {
    reflectPure(Densevectorview_densevector_filter_map[T,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos))
  }
  def densevectorview_count[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    densevectorview_count_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_partition[T:Manifest](self: Rep[DenseVectorView[T]],pred: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    densevectorview_partition_impl2[T](self,pred)(implicitly[Manifest[T]],__pos)
  }
  def densevectorview_flatmap[T:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],__arg1: (Rep[T]) => Rep[DenseVector[R]])(implicit __pos: SourceContext) = {
    densevectorview_flatmap_impl2[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def densevectorview_scan[T:Manifest,R:Manifest](self: Rep[DenseVectorView[T]],zero: Rep[R],__arg2: (Rep[R],Rep[T]) => Rep[R])(implicit __pos: SourceContext) = {
    reflectPure(DenseVectorView2_Scan[T,R](self,zero,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos))
  }
  def densevectorview_prefixsum[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevectorview_prefixsum_impl2[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevectorview_dist(__arg0: Rep[DenseVectorView[Double]],__arg1: Rep[DenseVectorView[Double]],__arg2: DistanceMetric)(implicit __pos: SourceContext) = {
    densevectorview_dist_impl2(__arg0,__arg1,__arg2)(__pos)
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
    case DenseVectorView12_Mutable(self) => Nil
    case _ => super.aliasSyms(e)
  }
  override def containSyms(e: Any): List[Sym[Any]] = e match {
    case DenseVectorView12_Mutable(self) => Nil
    case _ => super.containSyms(e)
  }
  override def extractSyms(e: Any): List[Sym[Any]] = e match {
    case DenseVectorView12_Mutable(self) => Nil
    case _ => super.extractSyms(e)
  }
  override def copySyms(e: Any): List[Sym[Any]] = e match {
    case DenseVectorView12_Mutable(self) => syms(self)
    case _ => super.copySyms(e)
  }

  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@DenseVectorView18Object_Apply(__arg0,__arg1,__arg2,__arg3,__arg4) => reflectPure(new { override val original = Some(f,mn) } with DenseVectorView18Object_Apply(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVectorView18Object_Apply(__arg0,__arg1,__arg2,__arg3,__arg4), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVectorView18Object_Apply(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVectorView7_Contains(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with DenseVectorView7_Contains(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVectorView7_Contains(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVectorView7_Contains(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVectorView3_Distinct(__arg0) => reflectPure(new { override val original = Some(f,mn) } with DenseVectorView3_Distinct(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVectorView3_Distinct(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVectorView3_Distinct(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVectorView12_Mutable(__arg0) => reflectPure(new { override val original = Some(f,mn) } with DenseVectorView12_Mutable(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVectorView12_Mutable(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVectorView12_Mutable(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVectorView3_Zip(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with DenseVectorView3_Zip(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mB),mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVectorView3_Zip(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVectorView3_Zip(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mB),mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVectorView4_Zip(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with DenseVectorView4_Zip(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mB),mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVectorView4_Zip(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVectorView4_Zip(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mB),mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVectorView2_Prod(__arg0) => reflectPure(new { override val original = Some(f,mn) } with DenseVectorView2_Prod(f(__arg0.asInstanceOf[Rep[DenseVectorView[A]]]))(mtype(mn._mT),mn.__pos,atype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVectorView2_Prod(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVectorView2_Prod(f(__arg0.asInstanceOf[Rep[DenseVectorView[A]]]))(mtype(mn._mT),mn.__pos,atype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVectorView4_Min(__arg0) => reflectPure(new { override val original = Some(f,mn) } with DenseVectorView4_Min(f(__arg0.asInstanceOf[Rep[DenseVectorView[A]]]))(mtype(mn._mT),mn.__pos,otype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVectorView4_Min(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVectorView4_Min(f(__arg0.asInstanceOf[Rep[DenseVectorView[A]]]))(mtype(mn._mT),mn.__pos,otype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVectorView4_Max(__arg0) => reflectPure(new { override val original = Some(f,mn) } with DenseVectorView4_Max(f(__arg0.asInstanceOf[Rep[DenseVectorView[A]]]))(mtype(mn._mT),mn.__pos,otype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVectorView4_Max(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVectorView4_Max(f(__arg0.asInstanceOf[Rep[DenseVectorView[A]]]))(mtype(mn._mT),mn.__pos,otype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVectorView2_Map(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with DenseVectorView2_Map(f(__arg0),f(__arg1))(mtype(mn._mT),mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVectorView2_Map(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVectorView2_Map(f(__arg0),f(__arg1))(mtype(mn._mT),mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVectorView2_Reduce(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with DenseVectorView2_Reduce(f(__arg0.asInstanceOf[Rep[DenseVectorView[A]]]),f(__arg1.asInstanceOf[(Rep[A],Rep[A]) => Rep[A]]))(mtype(mn._mT),mn.__pos,atype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVectorView2_Reduce(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVectorView2_Reduce(f(__arg0.asInstanceOf[Rep[DenseVectorView[A]]]),f(__arg1.asInstanceOf[(Rep[A],Rep[A]) => Rep[A]]))(mtype(mn._mT),mn.__pos,atype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVectorView3_Foreach(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with DenseVectorView3_Foreach(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVectorView3_Foreach(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVectorView3_Foreach(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Densevectorview_densevector_filter_map(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Densevectorview_densevector_filter_map(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Densevectorview_densevector_filter_map(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Densevectorview_densevector_filter_map(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVectorView2_Scan(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with DenseVectorView2_Scan(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVectorView2_Scan(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVectorView2_Scan(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]

  /**
   * Delite collection
   */
  def isDenseVectorView[A](x: Exp[DeliteCollection[A]])(implicit ctx: SourceContext) = isSubtype(x.tp.erasure,classOf[DenseVectorView[A]])
  def asDenseVectorView[A](x: Exp[DeliteCollection[A]])(implicit ctx: SourceContext) = x.asInstanceOf[Exp[DenseVectorView[A]]]

  override def dc_size[A:Manifest](x: Exp[DeliteCollection[A]])(implicit ctx: SourceContext) = {
    if (isDenseVectorView(x)) densevectorview_length(asDenseVectorView(x))
    else super.dc_size(x)
  }

  override def dc_apply[A:Manifest](x: Exp[DeliteCollection[A]], n: Exp[Int])(implicit ctx: SourceContext) = {
    if (isDenseVectorView(x)) densevectorview_apply(asDenseVectorView(x), n).asInstanceOf[Exp[A]]
    else super.dc_apply(x,n)
  }

  override def dc_update[A:Manifest](x: Exp[DeliteCollection[A]], n: Exp[Int], y: Exp[A])(implicit ctx: SourceContext) = {
    if (isDenseVectorView(x)) densevectorview_illegalupdate(asDenseVectorView(x), n, y.asInstanceOf[Exp[A]])
    else super.dc_update(x,n,y)
  }


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[DenseVectorView[_]]) Some((classTag(m), collection.immutable.List(("_data",makeManifest(classOf[ForgeArray[_]], List(m.typeArguments(0)))),("_start",manifest[Int]),("_stride",manifest[Int]),("_length",manifest[Int]),("_isRow",manifest[Boolean]))))
    else super.unapplyStructType(m)
  }
  override def dc_data_field[A:Manifest](x: Exp[DeliteCollection[A]]) = {
    if (isDenseVectorView(x)) "_data"
    else super.dc_data_field(x)
  }

  override def dc_size_field[A:Manifest](x: Exp[DeliteCollection[A]]) = {
    if (isDenseVectorView(x)) "_length"
    else super.dc_size_field(x)
  }
}

