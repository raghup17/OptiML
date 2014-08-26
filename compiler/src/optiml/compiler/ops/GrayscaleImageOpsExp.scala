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

trait GrayscaleImageOpsExp extends GrayscaleImageOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class GrayscaleImage26Object_Apply(__arg0: Rep[DenseMatrix[Double]])(implicit val __pos: SourceContext) extends DeliteStruct[GrayscaleImage] {
    val elems = copyTransformedElems(collection.Seq(("_data",__arg0)))
  }



  def grayscaleimage_object_apply(__arg0: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext) = {
    reflectPure(GrayscaleImage26Object_Apply(__arg0)(__pos))
  }
  def grayscaleimage_data(self: Rep[GrayscaleImage])(implicit __pos: SourceContext) = {
    field[DenseMatrix[Double]](self,"_data")
  }
  def grayscaleimage_downsample(self: Rep[GrayscaleImage],rowFactor: Rep[Int],colFactor: Rep[Int],sample: (Rep[GrayscaleImage]) => Rep[Double])(implicit __pos: SourceContext) = {
    grayscaleimage_downsample_impl(self,rowFactor,colFactor,sample)(__pos)
  }
  def grayscaleimage_convolve(self: Rep[GrayscaleImage],kernel: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext) = {
    grayscaleimage_convolve_impl(self,kernel)(__pos)
  }
  def grayscaleimage_windowedfilter(self: Rep[GrayscaleImage],rowDim: Rep[Int],colDim: Rep[Int],block: (Rep[GrayscaleImage]) => Rep[Double])(implicit __pos: SourceContext) = {
    grayscaleimage_windowedfilter_impl(self,rowDim,colDim,block)(__pos)
  }
  def grayscaleimage_histogram(self: Rep[GrayscaleImage])(implicit __pos: SourceContext) = {
    grayscaleimage_histogram_impl(self)(__pos)
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
    case mn@GrayscaleImage26Object_Apply(__arg0) => reflectPure(new { override val original = Some(f,mn) } with GrayscaleImage26Object_Apply(f(__arg0))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@GrayscaleImage26Object_Apply(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with GrayscaleImage26Object_Apply(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[GrayscaleImage]) Some((classTag(m), collection.immutable.List(("_data",makeManifest(classOf[DenseMatrix[_]], List(manifest[Double]))))))
    else super.unapplyStructType(m)
  }
}

