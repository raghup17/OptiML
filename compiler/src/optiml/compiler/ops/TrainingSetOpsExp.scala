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

trait TrainingSetOpsExp extends TrainingSetOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class TrainingSet16Object_Apply[D:Manifest,L:Manifest](__arg0: Rep[DenseMatrix[D]],__arg1: Rep[DenseVector[L]])(implicit val __pos: SourceContext) extends DeliteStruct[TrainingSet[D,L]] {
    val _mD = implicitly[Manifest[D]]
    val _mL = implicitly[Manifest[L]]
    val elems = copyTransformedElems(collection.Seq(("_data",__arg0),("_labels",__arg1)))
  }



  def trainingset_object_apply[D:Manifest,L:Manifest](__arg0: Rep[DenseMatrix[D]],__arg1: Rep[DenseVector[L]])(implicit __pos: SourceContext) = {
    reflectPure(TrainingSet16Object_Apply[D,L](__arg0,__arg1)(implicitly[Manifest[D]],implicitly[Manifest[L]],__pos))
  }
  def trainingset_labels[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]])(implicit __pos: SourceContext) = {
    field[DenseVector[L]](self,"_labels")
  }
  def trainingset_data[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]])(implicit __pos: SourceContext) = {
    field[DenseMatrix[D]](self,"_data")
  }
  def trainingset_apply[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload16) = {
    trainingset_apply_impl16[D,L](self,__arg1,__arg2)(implicitly[Manifest[D]],implicitly[Manifest[L]],__pos)
  }
  def trainingset_apply[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload17) = {
    trainingset_apply_impl17[D,L](self,__arg1)(implicitly[Manifest[D]],implicitly[Manifest[L]],__pos)
  }
  def trainingset_numsamples[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]])(implicit __pos: SourceContext) = {
    trainingset_numsamples_impl[D,L](self)(implicitly[Manifest[D]],implicitly[Manifest[L]],__pos)
  }
  def trainingset_numfeatures[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]])(implicit __pos: SourceContext) = {
    trainingset_numfeatures_impl[D,L](self)(implicitly[Manifest[D]],implicitly[Manifest[L]],__pos)
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@TrainingSet16Object_Apply(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with TrainingSet16Object_Apply(f(__arg0),f(__arg1))(mtype(mn._mD),mtype(mn._mL),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@TrainingSet16Object_Apply(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with TrainingSet16Object_Apply(f(__arg0),f(__arg1))(mtype(mn._mD),mtype(mn._mL),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[TrainingSet[_,_]]) Some((classTag(m), collection.immutable.List(("_data",makeManifest(classOf[DenseMatrix[_]], List(m.typeArguments(0)))),("_labels",makeManifest(classOf[DenseVector[_]], List(m.typeArguments(0)))))))
    else super.unapplyStructType(m)
  }
}

