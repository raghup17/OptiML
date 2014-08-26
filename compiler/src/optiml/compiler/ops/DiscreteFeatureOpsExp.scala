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

trait DiscreteFeatureOpsExp extends DiscreteFeatureCompilerOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class Discrete_feature_alloc(__arg0: Rep[ForgeHashMap[String,Int]])(implicit val __pos: SourceContext) extends DeliteStruct[DiscreteFeature] {
    val elems = copyTransformedElems(collection.Seq(("_features",__arg0)))
  }

  case class DiscreteFeature5Object_Apply(__arg0: Seq[Rep[String]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[DiscreteFeature](reifyEffectsHere(discretefeature_object_apply_impl5(__arg0)(__pos))) {
  }



  def discrete_feature_alloc(__arg0: Rep[ForgeHashMap[String,Int]])(implicit __pos: SourceContext) = {
    reflectPure(Discrete_feature_alloc(__arg0)(__pos))
  }
  def discretefeature_object_apply(__arg0: Seq[Rep[String]])(implicit __pos: SourceContext) = {
    reflectPure(DiscreteFeature5Object_Apply(__arg0)(__pos))
  }
  def getFeatures(self: Rep[DiscreteFeature])(implicit __pos: SourceContext) = {
    field[ForgeHashMap[String,Int]](self,"_features")
  }
  def discretefeature_apply(self: Rep[DiscreteFeature],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    discretefeature_apply_impl3(self,__arg1)(__pos)
  }
  def discretefeature_indicator(self: Rep[DiscreteFeature],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    discretefeature_indicator_impl(self,__arg1)(__pos)
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Discrete_feature_alloc(__arg0) => reflectPure(new { override val original = Some(f,mn) } with Discrete_feature_alloc(f(__arg0))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Discrete_feature_alloc(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Discrete_feature_alloc(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@DiscreteFeature5Object_Apply(__arg0) => reflectPure(new { override val original = Some(f,mn) } with DiscreteFeature5Object_Apply(f(__arg0))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@DiscreteFeature5Object_Apply(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with DiscreteFeature5Object_Apply(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[DiscreteFeature]) Some((classTag(m), collection.immutable.List(("_features",makeManifest(classOf[ForgeHashMap[_,_]], List(manifest[String],manifest[Int]))))))
    else super.unapplyStructType(m)
  }
}

