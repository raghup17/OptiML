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

trait SparseVectorViewOpsExp extends SparseVectorViewCompilerOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class SparseVectorView2Object_Apply[T:Manifest](__arg0: Rep[SparseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[Int],__arg4: Rep[Boolean])(implicit val __pos: SourceContext) extends DeliteStruct[SparseVectorView[T]] {
    val _mT = implicitly[Manifest[T]]
    val elems = copyTransformedElems(collection.Seq(("_source",__arg0),("_start",__arg1),("_stride",__arg2),("_length",__arg3),("_isRow",__arg4)))
  }

  case class SparseVectorView1_Nz[T:Manifest](self: Rep[SparseVectorView[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[DenseVectorView[T]](reifyEffectsHere(sparsevectorview_nz_impl1[T](self)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseVectorView1_Indices[T:Manifest](self: Rep[SparseVectorView[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[IndexVector](reifyEffectsHere(sparsevectorview_indices_impl1[T](self)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseVectorView_ToSparse[T:Manifest](self: Rep[SparseVectorView[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[SparseVector[T]](reifyEffectsHere(sparsevectorview_tosparse_impl[T](self)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseVectorView2___equal[T:Manifest](self: Rep[SparseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Boolean](reifyEffectsHere(sparsevectorview___equal_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class SparseVectorView1_ToString[T:Manifest](self: Rep[SparseVectorView[T]]) extends DeliteOpSingleTask[String](reifyEffectsHere(sparsevectorview_tostring_impl1[T](self))) {
    val _mT = implicitly[Manifest[T]]
  }



  def sparsevectorview_object_apply[T:Manifest](__arg0: Rep[SparseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int],__arg3: Rep[Int],__arg4: Rep[Boolean])(implicit __pos: SourceContext) = {
    reflectPure(SparseVectorView2Object_Apply[T](__arg0,__arg1,__arg2,__arg3,__arg4)(implicitly[Manifest[T]],__pos))
  }
  def sparsevectorview_source[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    field[SparseMatrix[T]](self,"_source")
  }
  def sparsevectorview_start[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    field[Int](self,"_start")
  }
  def sparsevectorview_stride[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    field[Int](self,"_stride")
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
    field[Int](self,"_length")
  }
  def sparsevectorview_isrow[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    field[Boolean](self,"_isRow")
  }
  def sparsevectorview_apply[T:Manifest](self: Rep[SparseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    sparsevectorview_apply_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevectorview_nnz[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    sparsevectorview_nnz_impl1[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevectorview_nz[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    reflectPure(SparseVectorView1_Nz[T](self)(implicitly[Manifest[T]],__pos))
  }
  def sparsevectorview_indices[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    reflectPure(SparseVectorView1_Indices[T](self)(implicitly[Manifest[T]],__pos))
  }
  def sparsevectorview_tosparse[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    reflectPure(SparseVectorView_ToSparse[T](self)(implicitly[Manifest[T]],__pos))
  }
  def sparsevectorview___equal[T:Manifest](self: Rep[SparseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload1) = {
    sparsevectorview___equal_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def sparsevectorview___equal[T:Manifest](self: Rep[SparseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = {
    reflectPure(SparseVectorView2___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos))
  }
  def sparsevectorview_tostring[T:Manifest](self: Rep[SparseVectorView[T]]) = {
    reflectPure(SparseVectorView1_ToString[T](self))
  }
  def sparsevectorview_viewtosparse[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    sparsevectorview_viewtosparse_impl[T](self)(implicitly[Manifest[T]],__pos)
  }
  def sparsevectorview_chainviewtosparseops[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext) = {
    sparsevectorview_chainviewtosparseops_impl[T](self)(implicitly[Manifest[T]],__pos)
  }


  /**
   * Aliases / Sharing
   */
  override def aliasSyms(e: Any): List[Sym[Any]] = e match {
    case _ => super.aliasSyms(e)
  }
  override def containSyms(e: Any): List[Sym[Any]] = e match {
    case SparseVectorView1_Nz(self) => syms(self)
    case _ => super.containSyms(e)
  }
  override def extractSyms(e: Any): List[Sym[Any]] = e match {
    case _ => super.extractSyms(e)
  }
  override def copySyms(e: Any): List[Sym[Any]] = e match {
    case _ => super.copySyms(e)
  }

  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@SparseVectorView2Object_Apply(__arg0,__arg1,__arg2,__arg3,__arg4) => reflectPure(new { override val original = Some(f,mn) } with SparseVectorView2Object_Apply(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVectorView2Object_Apply(__arg0,__arg1,__arg2,__arg3,__arg4), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVectorView2Object_Apply(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVectorView1_Nz(__arg0) => reflectPure(new { override val original = Some(f,mn) } with SparseVectorView1_Nz(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVectorView1_Nz(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVectorView1_Nz(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVectorView1_Indices(__arg0) => reflectPure(new { override val original = Some(f,mn) } with SparseVectorView1_Indices(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVectorView1_Indices(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVectorView1_Indices(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVectorView_ToSparse(__arg0) => reflectPure(new { override val original = Some(f,mn) } with SparseVectorView_ToSparse(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVectorView_ToSparse(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVectorView_ToSparse(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVectorView2___equal(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with SparseVectorView2___equal(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVectorView2___equal(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVectorView2___equal(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SparseVectorView1_ToString(__arg0) => reflectPure(new { override val original = Some(f,mn) } with SparseVectorView1_ToString(f(__arg0))(mtype(mn._mT)))(mtype(manifest[A]), pos)
    case Reflect(mn@SparseVectorView1_ToString(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with SparseVectorView1_ToString(f(__arg0))(mtype(mn._mT)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[SparseVectorView[_]]) Some((classTag(m), collection.immutable.List(("_source",makeManifest(classOf[SparseMatrix[_]], List(m.typeArguments(0)))),("_start",manifest[Int]),("_stride",manifest[Int]),("_length",manifest[Int]),("_isRow",manifest[Boolean]))))
    else super.unapplyStructType(m)
  }
}

