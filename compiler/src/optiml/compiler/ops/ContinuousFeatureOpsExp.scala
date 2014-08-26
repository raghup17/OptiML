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

trait ContinuousFeatureOpsExp extends ContinuousFeatureOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class ContinuousFeature4Object_Apply(min: Rep[Double] = math_ninf(),max: Rep[Double] = math_inf())(implicit val __pos: SourceContext) extends DeliteStruct[ContinuousFeature] {
    val elems = copyTransformedElems(collection.Seq(("_min",min),("_max",max)))
  }



  def continuousfeature_object_apply(min: Rep[Double] = math_ninf(),max: Rep[Double] = math_inf())(implicit __pos: SourceContext) = {
    reflectPure(ContinuousFeature4Object_Apply(min,max)(__pos))
  }
  def continuousfeature_min(self: Rep[ContinuousFeature])(implicit __pos: SourceContext) = {
    field[Double](self,"_min")
  }
  def continuousfeature_max(self: Rep[ContinuousFeature])(implicit __pos: SourceContext) = {
    field[Double](self,"_max")
  }
  def continuousfeature_apply(self: Rep[ContinuousFeature],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    continuousfeature_apply_impl2(self,__arg1)(__pos)
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@ContinuousFeature4Object_Apply(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with ContinuousFeature4Object_Apply(f(__arg0),f(__arg1))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@ContinuousFeature4Object_Apply(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with ContinuousFeature4Object_Apply(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[ContinuousFeature]) Some((classTag(m), collection.immutable.List(("_min",manifest[Double]),("_max",manifest[Double]))))
    else super.unapplyStructType(m)
  }
}

