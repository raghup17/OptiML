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

trait BinaryFeatureOpsExp extends BinaryFeatureOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class BinaryFeature10Object_Apply()(implicit val __pos: SourceContext) extends DeliteStruct[BinaryFeature] {
    val elems = copyTransformedElems(collection.Seq())
  }



  def binaryfeature_object_apply()(implicit __pos: SourceContext) = {
    reflectPure(BinaryFeature10Object_Apply()(__pos))
  }
  def binaryfeature_apply(self: Rep[BinaryFeature],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    binaryfeature_apply_impl10(self,__arg1)(__pos)
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@BinaryFeature10Object_Apply() => reflectPure(new { override val original = Some(f,mn) } with BinaryFeature10Object_Apply()(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@BinaryFeature10Object_Apply(), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with BinaryFeature10Object_Apply()(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[BinaryFeature]) Some((classTag(m), collection.immutable.List()))
    else super.unapplyStructType(m)
  }
}

