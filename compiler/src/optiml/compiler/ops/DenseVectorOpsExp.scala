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

trait DenseVectorOpsExp extends DenseVectorCompilerOps with DeliteCollectionOpsExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class DenseVector24Object_Apply[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Boolean])(implicit val __pos: SourceContext) extends DeliteStruct[DenseVector[T]] {
    val _mT = implicitly[Manifest[T]]
    val elems = copyTransformedElems(collection.Seq(("_length",var_new(__arg0).e),("_isRow",var_new(__arg1).e),("_data",var_new(array_empty[T](__arg0)).e)))
  }

  case class DenseVector25Object_Apply[T:Manifest](__arg0: Seq[Rep[T]])(implicit val __pos: SourceContext) extends DeliteStruct[DenseVector[T]] {
    val _mT = implicitly[Manifest[T]]
    val elems = copyTransformedElems(collection.Seq(("_length",unit(__arg0.length)),("_isRow",unit(true)),("_data",array_fromseq(__arg0))))
  }

  case class Densevector_alloc_raw[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Boolean],__arg2: Rep[ForgeArray[T]])(implicit val __pos: SourceContext) extends DeliteStruct[DenseVector[T]] {
    val _mT = implicitly[Manifest[T]]
    val elems = copyTransformedElems(collection.Seq(("_length",__arg0),("_isRow",__arg1),("_data",__arg2)))
  }

  case class Densevector_fromarray[T:Manifest](__arg0: Rep[ForgeArray[T]],__arg1: Rep[Boolean])(implicit val __pos: SourceContext) extends DeliteStruct[DenseVector[T]] {
    val _mT = implicitly[Manifest[T]]
    val elems = copyTransformedElems(collection.Seq(("_length",array_length(__arg0)),("_isRow",__arg1),("_data",__arg0)))
  }

  case class DenseVectorObject_Flatten[T:Manifest](pieces: Rep[DenseVector[DenseVector[T]]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[DenseVector[T]](reifyEffectsHere(densevector_object_flatten_impl[T](pieces)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Densevector_sortindex_helper[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[ForgeArray[T]])(implicit val __pos: SourceContext,val __imp0: Ordering[T]) extends Def[ForgeArray[Int]] {
    val _mT = implicitly[Manifest[T]]
  }

  case class DenseVector4_T[T:Manifest](self: Rep[DenseVector[T]])(implicit val __pos: SourceContext) extends DeliteStruct[DenseVector[T]] {
    val _mT = implicitly[Manifest[T]]
    val elems = copyTransformedElems(collection.Seq(("_length",densevector_length(self)),("_isRow",!(densevector_isrow(self))),("_data",array_clone(densevector_raw_data(self)))))
  }

  case class DenseVector6_Clone[T:Manifest](self: Rep[DenseVector[T]])(implicit val __pos: SourceContext) extends DeliteOpMap[T,T,DenseVector[T]] {
    val _mT = implicitly[Manifest[T]]

    val in = self
    def func = densevector_clone_impl6_map[T](self)(implicitly[Manifest[T]],__pos)
    override def alloc(len: Exp[Int]) = densevector_dc_alloc[T,DenseVector[T]](in, len)
    val size = copyTransformedOrElse(_.size)(densevector_length(in))
    override val numDynamicChunks = 0
  }

  case class DenseVector12_Update[T:Manifest](self: Rep[DenseVector[T]],indices: Rep[IndexVector],v: Rep[DenseVector[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(densevector_update_impl12[T](self,indices,v)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class DenseVector2_Insert[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(densevector_insert_impl2[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class DenseVector2_InsertAll[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(densevector_insertall_impl2[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class DenseVector2_RemoveAll[T:Manifest](self: Rep[DenseVector[T]],pos: Rep[Int],len: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(densevector_removeall_impl2[T](self,pos,len)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class DenseVector2_CopyFrom[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(densevector_copyfrom_impl2[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class DenseVector4_Trim[T:Manifest](self: Rep[DenseVector[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(densevector_trim_impl4[T](self)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class DenseVector2_Clear[T:Manifest](self: Rep[DenseVector[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(densevector_clear_impl2[T](self)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Densevector_insertspace[T:Manifest](self: Rep[DenseVector[T]],pos: Rep[Int],len: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(densevector_insertspace_impl[T](self,pos,len)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Densevector_ensureextra[T:Manifest](self: Rep[DenseVector[T]],extra: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(densevector_ensureextra_impl[T](self,extra)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Densevector_realloc[T:Manifest](self: Rep[DenseVector[T]],minLen: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(densevector_realloc_impl[T](self,minLen)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class DenseVector2_Clngt[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit val __pos: SourceContext,val __imp0: Ordering[T]) extends DeliteOpZipWith[T,T,Boolean,DenseVector[Boolean]] {
    val _mT = implicitly[Manifest[T]]

    val inA = self
    val inB = __arg1
    def func = densevector_clngt_impl2_zip[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
    override def alloc(len: Exp[Int]) = densevector_dc_alloc[Boolean,DenseVector[T]](inA, len)
    val size = copyTransformedOrElse(_.size)(densevector_length(inA))
    override val numDynamicChunks = 0
  }

  case class DenseVector2_Clnlt[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit val __pos: SourceContext,val __imp0: Ordering[T]) extends DeliteOpZipWith[T,T,Boolean,DenseVector[Boolean]] {
    val _mT = implicitly[Manifest[T]]

    val inA = self
    val inB = __arg1
    def func = densevector_clnlt_impl2_zip[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
    override def alloc(len: Exp[Int]) = densevector_dc_alloc[Boolean,DenseVector[T]](inA, len)
    val size = copyTransformedOrElse(_.size)(densevector_length(inA))
    override val numDynamicChunks = 0
  }

  case class DenseVector3_Filter[T:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit val __pos: SourceContext) extends DeliteOpFilter[T,T,DenseVector[T]] {
    val _mT = implicitly[Manifest[T]]

    val in = self
    def cond = densevector_filter_impl3_cond[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def func = densevector_filter_impl3_map[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    override def alloc(len: Exp[Int]) = densevector_dc_alloc[T,DenseVector[T]](in, len)
    val size = copyTransformedOrElse(_.size)(densevector_length(in))
    override val numDynamicChunks = 0
  }

  case class DenseVector9_Contains[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Boolean](reifyEffectsHere(densevector_contains_impl9[T](self,__arg1)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class DenseVector4_Distinct[T:Manifest](self: Rep[DenseVector[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[DenseVector[T]](reifyEffectsHere(densevector_distinct_impl4[T](self)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class DenseVector15_Mutable[T:Manifest](self: Rep[DenseVector[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[DenseVector[T]](reifyEffectsHere(densevector_mutable_impl15[T](self)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class DenseVector6_Zip[T:Manifest,B:Manifest,R:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpZipWith[T,B,R,DenseVector[R]] {
    val _mT = implicitly[Manifest[T]]
    val _mB = implicitly[Manifest[B]]
    val _mR = implicitly[Manifest[R]]

    val inA = self
    val inB = __arg1
    def func = densevector_zip_impl6_zip[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos)
    override def alloc(len: Exp[Int]) = densevector_dc_alloc[R,DenseVector[T]](inA, len)
    val size = copyTransformedOrElse(_.size)(densevector_length(inA))
    override val numDynamicChunks = 0
  }

  case class DenseVector7_Zip[T:Manifest,B:Manifest,R:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpZipWith[T,B,R,DenseVector[R]] {
    val _mT = implicitly[Manifest[T]]
    val _mB = implicitly[Manifest[B]]
    val _mR = implicitly[Manifest[R]]

    val inA = self
    val inB = __arg1
    def func = densevector_zip_impl7_zip[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos)
    override def alloc(len: Exp[Int]) = densevector_dc_alloc[R,DenseVector[T]](inA, len)
    val size = copyTransformedOrElse(_.size)(densevector_length(inA))
    override val numDynamicChunks = 0
  }

  case class DenseVector4_Prod[T:Manifest](self: Rep[DenseVector[T]])(implicit val __pos: SourceContext,val __imp0: Arith[T]) extends DeliteOpReduce[T] {
    val _mT = implicitly[Manifest[T]]

    val in = self
    def func = densevector_prod_impl4_reduce[T](self)(implicitly[Manifest[T]],__pos,__imp0)
    def zero = densevector_prod_impl4_zero[T](self)(implicitly[Manifest[T]],__pos,__imp0)
    val size = copyTransformedOrElse(_.size)(densevector_length[T](self)(implicitly[Manifest[T]],__pos))
    override val numDynamicChunks = 0
  }

  case class DenseVector6_Min[T:Manifest](self: Rep[DenseVector[T]])(implicit val __pos: SourceContext,val __imp0: Ordering[T]) extends DeliteOpReduce[T] {
    val _mT = implicitly[Manifest[T]]

    val in = self
    def func = densevector_min_impl6_reduce[T](self)(implicitly[Manifest[T]],__pos,__imp0)
    def zero = densevector_min_impl6_zero[T](self)(implicitly[Manifest[T]],__pos,__imp0)
    val size = copyTransformedOrElse(_.size)(densevector_length[T](self)(implicitly[Manifest[T]],__pos))
    override val numDynamicChunks = 0
  }

  case class DenseVector6_Max[T:Manifest](self: Rep[DenseVector[T]])(implicit val __pos: SourceContext,val __imp0: Ordering[T]) extends DeliteOpReduce[T] {
    val _mT = implicitly[Manifest[T]]

    val in = self
    def func = densevector_max_impl6_reduce[T](self)(implicitly[Manifest[T]],__pos,__imp0)
    def zero = densevector_max_impl6_zero[T](self)(implicitly[Manifest[T]],__pos,__imp0)
    val size = copyTransformedOrElse(_.size)(densevector_length[T](self)(implicitly[Manifest[T]],__pos))
    override val numDynamicChunks = 0
  }

  case class DenseVector4_Map[T:Manifest,R:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpMap[T,R,DenseVector[R]] {
    val _mT = implicitly[Manifest[T]]
    val _mR = implicitly[Manifest[R]]

    val in = self
    def func = densevector_map_impl4_map[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
    override def alloc(len: Exp[Int]) = densevector_dc_alloc[R,DenseVector[T]](in, len)
    val size = copyTransformedOrElse(_.size)(densevector_length(in))
    override val numDynamicChunks = 0
  }

  case class DenseVector3_Reduce[T:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T],Rep[T]) => Rep[T])(implicit val __pos: SourceContext,val __imp0: Arith[T]) extends DeliteOpReduce[T] {
    val _mT = implicitly[Manifest[T]]

    val in = self
    def func = densevector_reduce_impl3_reduce[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
    def zero = densevector_reduce_impl3_zero[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
    val size = copyTransformedOrElse(_.size)(densevector_length[T](self)(implicitly[Manifest[T]],__pos))
    override val numDynamicChunks = 0
  }

  case class DenseVector5_Foreach[T:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[Unit])(implicit val __pos: SourceContext) extends DeliteOpForeach[T] {
    val _mT = implicitly[Manifest[T]]

    val in = self
    def func = densevector_foreach_impl5_func[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def sync = n => unit(List())
    val size = copyTransformedOrElse(_.size)(densevector_length[T](self)(implicitly[Manifest[T]],__pos))
    override val numDynamicChunks = 0
  }

  case class Densevector_densevector_filter_map[T:Manifest,R:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[Boolean],__arg2: (Rep[T]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpFilter[T,R,DenseVector[R]] {
    val _mT = implicitly[Manifest[T]]
    val _mR = implicitly[Manifest[R]]

    val in = self
    def cond = densevector_densevector_filter_map_impl_cond[T,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
    def func = densevector_densevector_filter_map_impl_map[T,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
    override def alloc(len: Exp[Int]) = densevector_dc_alloc[R,DenseVector[T]](in, len)
    val size = copyTransformedOrElse(_.size)(densevector_length(in))
    override val numDynamicChunks = 0
  }

  case class DenseVector3_Scan[T:Manifest,R:Manifest](self: Rep[DenseVector[T]],zero: Rep[R],__arg2: (Rep[R],Rep[T]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[DenseVector[R]](reifyEffectsHere(densevector_scan_impl3[T,R](self,zero,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos))) {
    val _mT = implicitly[Manifest[T]]
    val _mR = implicitly[Manifest[R]]
  }

  case class Densevector_groupby_helperKeys[T:Manifest,K:Manifest,V:Manifest](__arg0: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit val __pos: SourceContext) extends DeliteOpFilteredGroupByReduce[T,K,K,ForgeArray[K]] {
    val _mT = implicitly[Manifest[T]]
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]

    val in = __arg0
    def cond: Exp[T] => Exp[Boolean] = null
    val size = copyTransformedOrElse(_.size)(densevector_length(in))
    def keyFunc = densevector_groupby_helper_impl_key[T,K,V](__arg0,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
    def valFunc = keyFunc
    def reduceFunc = (a,b) => a
    def zero = unit(null).asInstanceOf[Rep[K]]
    override def alloc(len: Exp[Int]) = array_raw_alloc[K](null.asInstanceOf[Rep[ForgeArray[K]]], len)
  }

  case class Densevector_groupby_helperIndex[T:Manifest,K:Manifest,V:Manifest](__arg0: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit val __pos: SourceContext) extends DeliteOpBuildIndex[T,K,DeliteIndex[K]] {
    val _mT = implicitly[Manifest[T]]
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]

    val in = __arg0
    def cond: Exp[T] => Exp[Boolean] = null
    val size = copyTransformedOrElse(_.size)(densevector_length(in))
    def keyFunc = densevector_groupby_helper_impl_key[T,K,V](__arg0,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  }

  case class Densevector_groupby_helper[T:Manifest,K:Manifest,V:Manifest](__arg0: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit val __pos: SourceContext) extends DeliteOpFilteredGroupBy[T,K,V,ForgeArrayBuffer[V],ForgeArray[ForgeArrayBuffer[V]]] {
    val _mT = implicitly[Manifest[T]]
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]

    val in = __arg0
    def cond: Exp[T] => Exp[Boolean] = null
    val size = copyTransformedOrElse(_.size)(densevector_length(in))
    def keyFunc = densevector_groupby_helper_impl_key[T,K,V](__arg0,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
    def valFunc = densevector_groupby_helper_impl_map[T,K,V](__arg0,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
    override def allocI(len: Exp[Int]) = array_buffer_raw_alloc[V](null.asInstanceOf[Rep[ForgeArrayBuffer[V]]], len)
    override def alloc(len: Exp[Int]) = array_raw_alloc[ForgeArrayBuffer[V]](null.asInstanceOf[Rep[ForgeArray[ForgeArrayBuffer[V]]]], len)
  }

  case class DenseVector_GroupByReduceKeys[T:Manifest,K:Manifest,V:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V],__arg3: (Rep[V],Rep[V]) => Rep[V])(implicit val __pos: SourceContext,val __imp0: Arith[V]) extends DeliteOpFilteredGroupByReduce[T,K,K,ForgeArray[K]] {
    val _mT = implicitly[Manifest[T]]
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]

    val in = self
    def cond: Exp[T] => Exp[Boolean] = null
    val size = copyTransformedOrElse(_.size)(densevector_length(in))
    def keyFunc = densevector_groupbyreduce_impl_key[T,K,V](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos,__imp0)
    def valFunc = keyFunc
    def reduceFunc = (a,b) => a
    def zero = unit(null).asInstanceOf[Rep[K]]
    override def alloc(len: Exp[Int]) = array_raw_alloc[K](null.asInstanceOf[Rep[ForgeArray[K]]], len)
  }

  case class DenseVector_GroupByReduceIndex[T:Manifest,K:Manifest,V:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V],__arg3: (Rep[V],Rep[V]) => Rep[V])(implicit val __pos: SourceContext,val __imp0: Arith[V]) extends DeliteOpBuildIndex[T,K,DeliteIndex[K]] {
    val _mT = implicitly[Manifest[T]]
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]

    val in = self
    def cond: Exp[T] => Exp[Boolean] = null
    val size = copyTransformedOrElse(_.size)(densevector_length(in))
    def keyFunc = densevector_groupbyreduce_impl_key[T,K,V](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos,__imp0)
  }

  case class DenseVector_GroupByReduce[T:Manifest,K:Manifest,V:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V],__arg3: (Rep[V],Rep[V]) => Rep[V])(implicit val __pos: SourceContext,val __imp0: Arith[V]) extends DeliteOpFilteredGroupByReduce[T,K,V,ForgeArray[V]] {
    val _mT = implicitly[Manifest[T]]
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]

    val in = self
    def cond: Exp[T] => Exp[Boolean] = null
    val size = copyTransformedOrElse(_.size)(densevector_length(in))
    def keyFunc = densevector_groupbyreduce_impl_key[T,K,V](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos,__imp0)
    def valFunc = densevector_groupbyreduce_impl_map[T,K,V](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos,__imp0)
    def zero = densevector_groupbyreduce_impl_zero[T,K,V](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos,__imp0)
    def reduceFunc = densevector_groupbyreduce_impl_reduce[T,K,V](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos,__imp0)
    override def alloc(len: Exp[Int]) = array_raw_alloc[V](null.asInstanceOf[Rep[ForgeArray[V]]], len)
  }



  def densevector_object_apply[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Boolean])(implicit __pos: SourceContext,__imp1: Overload24) = {
    reflectMutable(DenseVector24Object_Apply[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos))
  }
  def densevector_object_apply[T:Manifest](__arg0: Seq[Rep[T]])(implicit __pos: SourceContext,__imp1: Overload25) = {
    reflectPure(DenseVector25Object_Apply[T](__arg0)(implicitly[Manifest[T]],__pos))
  }
  def densevector_alloc_raw[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Boolean],__arg2: Rep[ForgeArray[T]])(implicit __pos: SourceContext) = {
    reflectPure(Densevector_alloc_raw[T](__arg0,__arg1,__arg2)(implicitly[Manifest[T]],__pos))
  }
  def densevector_fromarray[T:Manifest](__arg0: Rep[ForgeArray[T]],__arg1: Rep[Boolean])(implicit __pos: SourceContext) = {
    reflectPure(Densevector_fromarray[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos))
  }
  def densevector_fromfunc[T:Manifest](__arg0: Rep[Int],__arg1: (Rep[Int]) => Rep[T])(implicit __pos: SourceContext) = {
    densevector_fromfunc_impl[T](__arg0,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_object_zeros(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_object_zeros_impl3(__arg0)(__pos)
  }
  def densevector_object_zerosf(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_object_zerosf_impl3(__arg0)(__pos)
  }
  def densevector_object_ones(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_object_ones_impl2(__arg0)(__pos)
  }
  def densevector_object_onesf(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_object_onesf_impl2(__arg0)(__pos)
  }
  def densevector_object_rand(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_object_rand_impl3(__arg0)(__pos)
  }
  def densevector_object_randf(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_object_randf_impl3(__arg0)(__pos)
  }
  def densevector_object_uniform(start: Rep[Int],step_size: Rep[Double],end: Rep[Int],isRow: Rep[Boolean] = unit(true))(implicit __pos: SourceContext) = {
    densevector_object_uniform_impl(start,step_size,end,isRow)(__pos)
  }
  def densevector_object_flatten[T:Manifest](pieces: Rep[DenseVector[DenseVector[T]]])(implicit __pos: SourceContext) = {
    reflectPure(DenseVectorObject_Flatten[T](pieces)(implicitly[Manifest[T]],__pos))
  }
  def densevector_precumulate[T:Manifest](v: Rep[DenseVector[T]],identity: Rep[T],func: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext) = {
    densevector_precumulate_impl[T](v,identity,func)(implicitly[Manifest[T]],__pos)
  }
  def densevector_dc_alloc[R:Manifest,CR:Manifest](__arg0: Rep[CR],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_dc_alloc_impl[R,CR](__arg0,__arg1)(implicitly[Manifest[R]],implicitly[Manifest[CR]],__pos)
  }
  def densevector_sortindex_helper[T:Manifest](__arg0: Rep[Int],__arg1: Rep[Int],__arg2: Rep[ForgeArray[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    reflectPure(Densevector_sortindex_helper[T](__arg0,__arg1,__arg2)(implicitly[Manifest[T]],__pos,__imp0))
  }
  def densevector_groupby_helper[T:Manifest,K:Manifest,V:Manifest](__arg0: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit __pos: SourceContext) = {
    val keys = reflectPure(Densevector_groupby_helperKeys[T,K,V](__arg0,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos))
    val index = reflectPure(Densevector_groupby_helperIndex[T,K,V](__arg0,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos))
    val values = reflectPure(Densevector_groupby_helper[T,K,V](__arg0,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos))
    reflectPure(DeliteMapNewImm(keys, values, index, darray_length(values)))
  }
  def densevector_tovector[T:Manifest,R:Manifest](__arg0: Rep[ForgeHashMap[T,R]])(implicit __pos: SourceContext) = {
    densevector_tovector_impl[T,R](__arg0)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def densevector_length[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    field[Int](self,"_length")
  }
  def densevector_isrow[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    field[Boolean](self,"_isRow")
  }
  def densevector_apply[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload27) = {
    densevector_apply_impl27[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_apply[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload28) = {
    densevector_apply_impl28[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_t[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    reflectPure(DenseVector4_T[T](self)(implicitly[Manifest[T]],__pos))
  }
  def densevector_mt[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densevector_mt_impl2[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevector_tomat[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densevector_tomat_impl[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevector_clone[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    reflectPure(DenseVector6_Clone[T](self)(implicitly[Manifest[T]],__pos))
  }
  def densevector_raw_data[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    field[ForgeArray[T]](self,"_data")
  }
  def densevector_set_raw_data[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[ForgeArray[T]])(implicit __pos: SourceContext) = {
    field_update[ForgeArray[T]](self,"_data",__arg1)
  }
  def densevector_set_length[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    field_update[Int](self,"_length",__arg1)
  }
  def densevector_set_isrow[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Boolean])(implicit __pos: SourceContext) = {
    field_update[Boolean](self,"_isRow",__arg1)
  }
  def densevector_update[T:Manifest](self: Rep[DenseVector[T]],i: Rep[Int],e: Rep[T])(implicit __pos: SourceContext,__imp1: Overload10) = {
    densevector_update_impl10[T](self,i,e)(implicitly[Manifest[T]],__pos)
  }
  def densevector_update[T:Manifest](self: Rep[DenseVector[T]],indices: Rep[IndexVector],e: Rep[T])(implicit __pos: SourceContext,__imp1: Overload11) = {
    densevector_update_impl11[T](self,indices,e)(implicitly[Manifest[T]],__pos)
  }
  def densevector_update[T:Manifest](self: Rep[DenseVector[T]],indices: Rep[IndexVector],v: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload12) = {
    reflectWrite(self)(DenseVector12_Update[T](self,indices,v)(implicitly[Manifest[T]],__pos))
  }
  def densevector_ltlt[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload7) = {
    densevector_ltlt_impl7[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_ltlt[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload8) = {
    densevector_ltlt_impl8[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_ltlteq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload6) = {
    densevector_ltlteq_impl6[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_ltlteq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload7) = {
    densevector_ltlteq_impl7[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_insert[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext) = {
    reflectWrite(self)(DenseVector2_Insert[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos))
  }
  def densevector_insertall[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    reflectWrite(self)(DenseVector2_InsertAll[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos))
  }
  def densevector_remove[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_remove_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_removeall[T:Manifest](self: Rep[DenseVector[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext) = {
    reflectWrite(self)(DenseVector2_RemoveAll[T](self,pos,len)(implicitly[Manifest[T]],__pos))
  }
  def densevector_copyfrom[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    reflectWrite(self)(DenseVector2_CopyFrom[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos))
  }
  def densevector_trim[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    reflectWrite(self)(DenseVector4_Trim[T](self)(implicitly[Manifest[T]],__pos))
  }
  def densevector_clear[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    reflectWrite(self)(DenseVector2_Clear[T](self)(implicitly[Manifest[T]],__pos))
  }
  def densevector_insertspace[T:Manifest](self: Rep[DenseVector[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext) = {
    reflectWrite(self)(Densevector_insertspace[T](self,pos,len)(implicitly[Manifest[T]],__pos))
  }
  def densevector_ensureextra[T:Manifest](self: Rep[DenseVector[T]],extra: Rep[Int])(implicit __pos: SourceContext) = {
    reflectWrite(self)(Densevector_ensureextra[T](self,extra)(implicitly[Manifest[T]],__pos))
  }
  def densevector_realloc[T:Manifest](self: Rep[DenseVector[T]],minLen: Rep[Int])(implicit __pos: SourceContext) = {
    reflectWrite(self)(Densevector_realloc[T](self,minLen)(implicitly[Manifest[T]],__pos))
  }
  def densevector_pleq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload3) = {
    densevector_pleq_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_pleq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload4) = {
    densevector_pleq_impl4[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_pleq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload5) = {
    densevector_pleq_impl5[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_muleq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload3) = {
    densevector_muleq_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_muleq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload4) = {
    densevector_muleq_impl4[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_muleq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload5) = {
    densevector_muleq_impl5[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_subeq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload3) = {
    densevector_subeq_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_subeq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload4) = {
    densevector_subeq_impl4[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_subeq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload5) = {
    densevector_subeq_impl5[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_diveq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload3) = {
    densevector_diveq_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_diveq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload4) = {
    densevector_diveq_impl4[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_diveq[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload5) = {
    densevector_diveq_impl5[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_sort[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    densevector_sort_impl[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_sortby[T:Manifest,B:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[B])(implicit __pos: SourceContext,__imp0: Ordering[B]) = {
    densevector_sortby_impl[T,B](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[B]],__pos,__imp0)
  }
  def densevector_sortwithindex[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    densevector_sortwithindex_impl[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_median[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Numeric[T],__imp1: Ordering[T]) = {
    densevector_median_impl[T](self)(implicitly[Manifest[T]],__pos,__imp0,__imp1)
  }
  def densevector_clngt[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    reflectPure(DenseVector2_Clngt[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0))
  }
  def densevector_clnlt[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    reflectPure(DenseVector2_Clnlt[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0))
  }
  def densevector___equal[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload12) = {
    densevector___equal_impl12[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector___equal[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload13) = {
    densevector___equal_impl13[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector___equal[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload14) = {
    densevector___equal_impl14[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector___equal[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload15) = {
    densevector___equal_impl15[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_groupbyreduce[T:Manifest,K:Manifest,V:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V],__arg3: (Rep[V],Rep[V]) => Rep[V])(implicit __pos: SourceContext,__imp0: Arith[V]) = {
    val keys = reflectPure(DenseVector_GroupByReduceKeys[T,K,V](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos,__imp0))
    val index = reflectPure(DenseVector_GroupByReduceIndex[T,K,V](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos,__imp0))
    val values = reflectPure(DenseVector_GroupByReduce[T,K,V](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos,__imp0))
    reflectPure(DeliteMapNewImm(keys, values, index, darray_length(values)))
  }
  def densevector_groupby[T:Manifest,K:Manifest,V:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit __pos: SourceContext) = {
    densevector_groupby_impl[T,K,V](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  }
  def densevector_filter[T:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    reflectPure(DenseVector3_Filter[T](self,__arg1)(implicitly[Manifest[T]],__pos))
  }
  def densevector_appendable[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext) = {
    densevector_appendable_impl[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densevector_append[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext) = {
    densevector_append_impl[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densevector_copy[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]],__arg3: Rep[Int],__arg4: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_copy_impl[T](self,__arg1,__arg2,__arg3,__arg4)(implicitly[Manifest[T]],__pos)
  }
  def densevector_toboolean[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Boolean]) = {
    densevector_toboolean_impl5[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densevector_todouble[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]) = {
    densevector_todouble_impl6[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densevector_tofloat[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Float]) = {
    densevector_tofloat_impl6[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densevector_toint[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Int]) = {
    densevector_toint_impl6[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densevector_indices[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densevector_indices_impl6[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevector_isempty[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densevector_isempty_impl4[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevector_first[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densevector_first_impl4[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevector_last[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    densevector_last_impl4[T](self)(implicitly[Manifest[T]],__pos)
  }
  def densevector_drop[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_drop_impl4[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_take[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_take_impl4[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_contains[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext) = {
    reflectPure(DenseVector9_Contains[T](self,__arg1)(implicitly[Manifest[T]],__pos))
  }
  def densevector_distinct[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    reflectPure(DenseVector4_Distinct[T](self)(implicitly[Manifest[T]],__pos))
  }
  def densevector_mutable[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
    reflectMutable(DenseVector15_Mutable[T](self)(implicitly[Manifest[T]],__pos))
  }
  def densevector_replicate[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext) = {
    densevector_replicate_impl4[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def densevector_makestring[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]) = {
    densevector_makestring_impl6[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_tostring[T:Manifest](self: Rep[DenseVector[T]]) = {
    densevector_tostring_impl15[T](self)
  }
  def densevector_pprint[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Stringable[T]) = {
    densevector_pprint_impl6[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_pl[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload131) = {
    densevector_pl_impl131[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_sub[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload97) = {
    densevector_sub_impl97[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload136) = {
    densevector_mul_impl136[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mulclnmul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload22) = {
    densevector_mulclnmul_impl22[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mulmul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload10) = {
    densevector_mulmul_impl10[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_div[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload98) = {
    densevector_div_impl98[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_pl[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload132) = {
    densevector_pl_impl132[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_sub[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload98) = {
    densevector_sub_impl98[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload137) = {
    densevector_mul_impl137[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_dot_densevectorview[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevector_dot_densevectorview_impl23[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mulmul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload11) = {
    densevector_mulmul_impl11[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_div[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload99) = {
    densevector_div_impl99[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_pl[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload133) = {
    densevector_pl_impl133[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_sub[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload99) = {
    densevector_sub_impl99[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload138) = {
    densevector_mul_impl138[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mulclnmul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload24) = {
    densevector_mulclnmul_impl24[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mulmul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload12) = {
    densevector_mulmul_impl12[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_div[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload100) = {
    densevector_div_impl100[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_pl[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload134) = {
    densevector_pl_impl134[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_sub[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload100) = {
    densevector_sub_impl100[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload139) = {
    densevector_mul_impl139[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mulclnmul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload25) = {
    densevector_mulclnmul_impl25[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mulmul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload13) = {
    densevector_mulmul_impl13[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_div[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload101) = {
    densevector_div_impl101[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_zip[T:Manifest,B:Manifest,R:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload6) = {
    reflectPure(DenseVector6_Zip[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos))
  }
  def densevector_zip[T:Manifest,B:Manifest,R:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[B]],__arg2: (Rep[T],Rep[B]) => Rep[R])(implicit __pos: SourceContext,__imp1: Overload7) = {
    reflectPure(DenseVector7_Zip[T,B,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[B]],implicitly[Manifest[R]],__pos))
  }
  def densevector_pl[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload135) = {
    densevector_pl_impl135[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_sub[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload101) = {
    densevector_sub_impl101[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload140) = {
    densevector_mul_impl140[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_mul[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload141) = {
    densevector_mul_impl141[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_div[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload102) = {
    densevector_div_impl102[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_abs[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevector_abs_impl21[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_exp[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevector_exp_impl20[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_log[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevector_log_impl20[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_sum[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevector_sum_impl5[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_prod[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    reflectPure(DenseVector4_Prod[T](self)(implicitly[Manifest[T]],__pos,__imp0))
  }
  def densevector_mean[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double]) = {
    densevector_mean_impl5[T](self)(implicitly[Manifest[T]],__pos,conv)
  }
  def densevector_min[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    reflectPure(DenseVector6_Min[T](self)(implicitly[Manifest[T]],__pos,__imp0))
  }
  def densevector_max[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T]) = {
    reflectPure(DenseVector6_Max[T](self)(implicitly[Manifest[T]],__pos,__imp0))
  }
  def densevector_minindex[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp1: Arith[T]) = {
    densevector_minindex_impl4[T](self)(implicitly[Manifest[T]],__pos,__imp0,__imp1)
  }
  def densevector_maxindex[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp1: Arith[T]) = {
    densevector_maxindex_impl4[T](self)(implicitly[Manifest[T]],__pos,__imp0,__imp1)
  }
  def densevector_map[T:Manifest,R:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext) = {
    reflectPure(DenseVector4_Map[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos))
  }
  def densevector_reduce[T:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    reflectPure(DenseVector3_Reduce[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0))
  }
  def densevector_foreach[T:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext) = {
    reflectPure(DenseVector5_Foreach[T](self,__arg1)(implicitly[Manifest[T]],__pos))
  }
  def densevector_find[T:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    densevector_find_impl3[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_densevector_filter_map[T:Manifest,R:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[Boolean],__arg2: (Rep[T]) => Rep[R])(implicit __pos: SourceContext) = {
    reflectPure(Densevector_densevector_filter_map[T,R](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos))
  }
  def densevector_count[T:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    densevector_count_impl4[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def densevector_partition[T:Manifest](self: Rep[DenseVector[T]],pred: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    densevector_partition_impl3[T](self,pred)(implicitly[Manifest[T]],__pos)
  }
  def densevector_flatmap[T:Manifest,R:Manifest](self: Rep[DenseVector[T]],__arg1: (Rep[T]) => Rep[DenseVector[R]])(implicit __pos: SourceContext) = {
    densevector_flatmap_impl3[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def densevector_scan[T:Manifest,R:Manifest](self: Rep[DenseVector[T]],zero: Rep[R],__arg2: (Rep[R],Rep[T]) => Rep[R])(implicit __pos: SourceContext) = {
    reflectPure(DenseVector3_Scan[T,R](self,zero,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos))
  }
  def densevector_prefixsum[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T]) = {
    densevector_prefixsum_impl3[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def densevector_dist(__arg0: Rep[DenseVector[Double]],__arg1: Rep[DenseVector[Double]],__arg2: DistanceMetric)(implicit __pos: SourceContext) = {
    densevector_dist_impl4(__arg0,__arg1,__arg2)(__pos)
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
    case DenseVector6_Clone(self) => Nil
    case DenseVector15_Mutable(self) => Nil
    case _ => super.aliasSyms(e)
  }
  override def containSyms(e: Any): List[Sym[Any]] = e match {
    case DenseVector6_Clone(self) => Nil
    case DenseVector15_Mutable(self) => Nil
    case _ => super.containSyms(e)
  }
  override def extractSyms(e: Any): List[Sym[Any]] = e match {
    case DenseVector6_Clone(self) => Nil
    case DenseVector15_Mutable(self) => Nil
    case _ => super.extractSyms(e)
  }
  override def copySyms(e: Any): List[Sym[Any]] = e match {
    case DenseVector6_Clone(self) => syms(self)
    case DenseVector15_Mutable(self) => syms(self)
    case _ => super.copySyms(e)
  }

  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@DenseVector24Object_Apply(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with DenseVector24Object_Apply(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector24Object_Apply(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector24Object_Apply(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector25Object_Apply(__arg0) => reflectPure(new { override val original = Some(f,mn) } with DenseVector25Object_Apply(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector25Object_Apply(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector25Object_Apply(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Densevector_alloc_raw(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Densevector_alloc_raw(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Densevector_alloc_raw(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Densevector_alloc_raw(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Densevector_fromarray(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with Densevector_fromarray(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Densevector_fromarray(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Densevector_fromarray(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVectorObject_Flatten(__arg0) => reflectPure(new { override val original = Some(f,mn) } with DenseVectorObject_Flatten(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVectorObject_Flatten(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVectorObject_Flatten(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Densevector_sortindex_helper(__arg0,__arg1,__arg2) => densevector_sortindex_helper(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos,otype(mn.__imp0))
    case Reflect(mn@Densevector_sortindex_helper(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(Densevector_sortindex_helper(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos,otype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Densevector_groupby_helperKeys(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Densevector_groupby_helperKeys(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Densevector_groupby_helperKeys(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Densevector_groupby_helperKeys(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Densevector_groupby_helperIndex(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Densevector_groupby_helperIndex(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Densevector_groupby_helperIndex(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Densevector_groupby_helperIndex(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Densevector_groupby_helper(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Densevector_groupby_helper(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Densevector_groupby_helper(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Densevector_groupby_helper(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector4_T(__arg0) => reflectPure(new { override val original = Some(f,mn) } with DenseVector4_T(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector4_T(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector4_T(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector6_Clone(__arg0) => reflectPure(new { override val original = Some(f,mn) } with DenseVector6_Clone(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector6_Clone(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector6_Clone(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector12_Update(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with DenseVector12_Update(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector12_Update(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector12_Update(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector2_Insert(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with DenseVector2_Insert(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector2_Insert(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector2_Insert(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector2_InsertAll(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with DenseVector2_InsertAll(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector2_InsertAll(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector2_InsertAll(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector2_RemoveAll(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with DenseVector2_RemoveAll(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector2_RemoveAll(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector2_RemoveAll(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector2_CopyFrom(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with DenseVector2_CopyFrom(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector2_CopyFrom(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector2_CopyFrom(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector4_Trim(__arg0) => reflectPure(new { override val original = Some(f,mn) } with DenseVector4_Trim(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector4_Trim(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector4_Trim(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector2_Clear(__arg0) => reflectPure(new { override val original = Some(f,mn) } with DenseVector2_Clear(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector2_Clear(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector2_Clear(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Densevector_insertspace(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Densevector_insertspace(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Densevector_insertspace(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Densevector_insertspace(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Densevector_ensureextra(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with Densevector_ensureextra(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Densevector_ensureextra(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Densevector_ensureextra(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Densevector_realloc(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with Densevector_realloc(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Densevector_realloc(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Densevector_realloc(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector2_Clngt(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with DenseVector2_Clngt(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos,otype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector2_Clngt(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector2_Clngt(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos,otype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector2_Clnlt(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with DenseVector2_Clnlt(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos,otype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector2_Clnlt(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector2_Clnlt(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos,otype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector_GroupByReduceKeys(__arg0,__arg1,__arg2,__arg3) => reflectPure(new { override val original = Some(f,mn) } with DenseVector_GroupByReduceKeys(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos,atype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector_GroupByReduceKeys(__arg0,__arg1,__arg2,__arg3), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector_GroupByReduceKeys(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos,atype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector_GroupByReduceIndex(__arg0,__arg1,__arg2,__arg3) => reflectPure(new { override val original = Some(f,mn) } with DenseVector_GroupByReduceIndex(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos,atype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector_GroupByReduceIndex(__arg0,__arg1,__arg2,__arg3), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector_GroupByReduceIndex(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos,atype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector_GroupByReduce(__arg0,__arg1,__arg2,__arg3) => reflectPure(new { override val original = Some(f,mn) } with DenseVector_GroupByReduce(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos,atype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector_GroupByReduce(__arg0,__arg1,__arg2,__arg3), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector_GroupByReduce(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos,atype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector3_Filter(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with DenseVector3_Filter(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector3_Filter(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector3_Filter(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector9_Contains(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with DenseVector9_Contains(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector9_Contains(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector9_Contains(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector4_Distinct(__arg0) => reflectPure(new { override val original = Some(f,mn) } with DenseVector4_Distinct(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector4_Distinct(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector4_Distinct(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector15_Mutable(__arg0) => reflectPure(new { override val original = Some(f,mn) } with DenseVector15_Mutable(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector15_Mutable(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector15_Mutable(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector6_Zip(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with DenseVector6_Zip(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mB),mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector6_Zip(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector6_Zip(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mB),mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector7_Zip(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with DenseVector7_Zip(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mB),mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector7_Zip(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector7_Zip(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mB),mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector4_Prod(__arg0) => reflectPure(new { override val original = Some(f,mn) } with DenseVector4_Prod(f(__arg0.asInstanceOf[Rep[DenseVector[A]]]))(mtype(mn._mT),mn.__pos,atype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector4_Prod(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector4_Prod(f(__arg0.asInstanceOf[Rep[DenseVector[A]]]))(mtype(mn._mT),mn.__pos,atype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector6_Min(__arg0) => reflectPure(new { override val original = Some(f,mn) } with DenseVector6_Min(f(__arg0.asInstanceOf[Rep[DenseVector[A]]]))(mtype(mn._mT),mn.__pos,otype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector6_Min(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector6_Min(f(__arg0.asInstanceOf[Rep[DenseVector[A]]]))(mtype(mn._mT),mn.__pos,otype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector6_Max(__arg0) => reflectPure(new { override val original = Some(f,mn) } with DenseVector6_Max(f(__arg0.asInstanceOf[Rep[DenseVector[A]]]))(mtype(mn._mT),mn.__pos,otype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector6_Max(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector6_Max(f(__arg0.asInstanceOf[Rep[DenseVector[A]]]))(mtype(mn._mT),mn.__pos,otype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector4_Map(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with DenseVector4_Map(f(__arg0),f(__arg1))(mtype(mn._mT),mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector4_Map(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector4_Map(f(__arg0),f(__arg1))(mtype(mn._mT),mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector3_Reduce(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with DenseVector3_Reduce(f(__arg0.asInstanceOf[Rep[DenseVector[A]]]),f(__arg1.asInstanceOf[(Rep[A],Rep[A]) => Rep[A]]))(mtype(mn._mT),mn.__pos,atype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector3_Reduce(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector3_Reduce(f(__arg0.asInstanceOf[Rep[DenseVector[A]]]),f(__arg1.asInstanceOf[(Rep[A],Rep[A]) => Rep[A]]))(mtype(mn._mT),mn.__pos,atype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector5_Foreach(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with DenseVector5_Foreach(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector5_Foreach(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector5_Foreach(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Densevector_densevector_filter_map(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Densevector_densevector_filter_map(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Densevector_densevector_filter_map(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Densevector_densevector_filter_map(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DenseVector3_Scan(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with DenseVector3_Scan(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DenseVector3_Scan(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DenseVector3_Scan(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]

  /**
   * Delite collection
   */
  def isDenseVector[A](x: Exp[DeliteCollection[A]])(implicit ctx: SourceContext) = isSubtype(x.tp.erasure,classOf[DenseVector[A]])
  def asDenseVector[A](x: Exp[DeliteCollection[A]])(implicit ctx: SourceContext) = x.asInstanceOf[Exp[DenseVector[A]]]

  override def dc_size[A:Manifest](x: Exp[DeliteCollection[A]])(implicit ctx: SourceContext) = {
    if (isDenseVector(x)) densevector_length(asDenseVector(x))
    else super.dc_size(x)
  }

  override def dc_apply[A:Manifest](x: Exp[DeliteCollection[A]], n: Exp[Int])(implicit ctx: SourceContext) = {
    if (isDenseVector(x)) densevector_apply(asDenseVector(x), n).asInstanceOf[Exp[A]]
    else super.dc_apply(x,n)
  }

  override def dc_update[A:Manifest](x: Exp[DeliteCollection[A]], n: Exp[Int], y: Exp[A])(implicit ctx: SourceContext) = {
    if (isDenseVector(x)) densevector_update(asDenseVector(x), n, y.asInstanceOf[Exp[A]])
    else super.dc_update(x,n,y)
  }

  override def dc_parallelization[A:Manifest](x: Exp[DeliteCollection[A]], hasConditions: Boolean)(implicit ctx: SourceContext) = {
    if (isDenseVector(x)) { if (hasConditions) ParSimpleBuffer else ParFlat } // TODO: always generating this right now
    else super.dc_parallelization(x, hasConditions)
  }

  override def dc_set_logical_size[A:Manifest](x: Exp[DeliteCollection[A]], y: Exp[Int])(implicit ctx: SourceContext) = {
    if (isDenseVector(x)) densevector_set_length(asDenseVector(x), y)
    else super.dc_set_logical_size(x,y)
  }

  override def dc_appendable[A:Manifest](x: Exp[DeliteCollection[A]], i: Exp[Int], y: Exp[A])(implicit ctx: SourceContext) = {
    if (isDenseVector(x)) densevector_appendable(asDenseVector(x), i, y)
    else super.dc_appendable(x,i,y)
  }

  override def dc_append[A:Manifest](x: Exp[DeliteCollection[A]], i: Exp[Int], y: Exp[A])(implicit ctx: SourceContext) = {
    if (isDenseVector(x)) densevector_append(asDenseVector(x), i, y)
    else super.dc_append(x,i,y)
  }

  override def dc_alloc[A:Manifest,CA<:DeliteCollection[A]:Manifest](x: Exp[CA], size: Exp[Int])(implicit ctx: SourceContext) = {
    if (isDenseVector(x)) densevector_dc_alloc[A,DenseVector[A]](asDenseVector(x), size).asInstanceOf[Exp[CA]]
    else super.dc_alloc[A,CA](x,size)
  }

  override def dc_copy[A:Manifest](src: Exp[DeliteCollection[A]], srcPos: Exp[Int], dst: Exp[DeliteCollection[A]], dstPos: Exp[Int], size: Exp[Int])(implicit ctx: SourceContext) = {
    if (isDenseVector(src) && isDenseVector(dst)) densevector_copy(asDenseVector(src), srcPos, asDenseVector(dst), dstPos, size)
    else super.dc_copy(src,srcPos,dst,dstPos,size)
  }

  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[DenseVector[_]]) Some((classTag(m), collection.immutable.List(("_length",manifest[Int]),("_isRow",manifest[Boolean]),("_data",makeManifest(classOf[ForgeArray[_]], List(m.typeArguments(0)))))))
    else super.unapplyStructType(m)
  }
  override def dc_data_field[A:Manifest](x: Exp[DeliteCollection[A]]) = {
    if (isDenseVector(x)) "_data"
    else super.dc_data_field(x)
  }

  override def dc_size_field[A:Manifest](x: Exp[DeliteCollection[A]]) = {
    if (isDenseVector(x)) "_length"
    else super.dc_size_field(x)
  }
}

/**
 * Code generators
 */

trait ScalaGenDenseVectorOps extends ScalaGenFat {
  val IR: DenseVectorOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Densevector_sortindex_helper(__arg0,__arg1,__arg2) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("("+quote(__arg0)+" until "+quote(__arg1)+": scala.Range).toArray.sortWith((a,b) => "+quote(__arg2)+"(a) < "+quote(__arg2)+"(b))")
      stream.println("}")

    case _ => super.emitNode(sym, rhs)
  }
}
