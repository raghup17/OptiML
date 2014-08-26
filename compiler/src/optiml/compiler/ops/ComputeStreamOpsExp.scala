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

trait ComputeStreamOpsExp extends ComputeStreamCompilerOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class ComputeStream15Object_Apply[T:Manifest](numRows: Rep[Int],numCols: Rep[Int],func: (Rep[Int],Rep[Int]) => Rep[T])(implicit val __pos: SourceContext) extends DeliteStruct[ComputeStream[T]] {
    val _mT = implicitly[Manifest[T]]
    val elems = copyTransformedElems(collection.Seq(("_numRows",numRows),("_numCols",numCols),("_func",doLambda((t: Rep[Tup2[Int,Int]]) => func(t._1, t._2)))))
  }



  def computestream_object_apply[T:Manifest](numRows: Rep[Int],numCols: Rep[Int],func: (Rep[Int],Rep[Int]) => Rep[T])(implicit __pos: SourceContext) = {
    reflectPure(ComputeStream15Object_Apply[T](numRows,numCols,func)(implicitly[Manifest[T]],__pos))
  }
  def computestream_numrows[T:Manifest](self: Rep[ComputeStream[T]])(implicit __pos: SourceContext) = {
    field[Int](self,"_numRows")
  }
  def computestream_numcols[T:Manifest](self: Rep[ComputeStream[T]])(implicit __pos: SourceContext) = {
    field[Int](self,"_numCols")
  }
  def stream_func[T:Manifest](self: Rep[ComputeStream[T]])(implicit __pos: SourceContext) = {
    field[Function1[Tup2[Int,Int],T]](self,"_func")
  }
  def computestream_apply[T:Manifest](self: Rep[ComputeStream[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext) = {
    computestream_apply_impl14[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def computestream_foreach[T:Manifest](self: Rep[ComputeStream[T]],__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext) = {
    computestream_foreach_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def computestream_foreachrow[T:Manifest](self: Rep[ComputeStream[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[Unit])(implicit __pos: SourceContext) = {
    computestream_foreachrow_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
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
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@ComputeStream15Object_Apply(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with ComputeStream15Object_Apply(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@ComputeStream15Object_Apply(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with ComputeStream15Object_Apply(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[ComputeStream[_]]) Some((classTag(m), collection.immutable.List(("_numRows",manifest[Int]),("_numCols",manifest[Int]),("_func",makeManifest(classOf[Function1[_,_]], List(manifest[Tup2[Int,Int]],m.typeArguments(0)))))))
    else super.unapplyStructType(m)
  }
}

