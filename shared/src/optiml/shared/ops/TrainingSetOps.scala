package optiml.shared.ops

import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._

/**
 * Operations
 */

trait TrainingSetOps extends Base {
  this: OptiML => 

  object TrainingSet {
    def apply[D:Manifest,L:Manifest](__arg0: Rep[DenseMatrix[D]],__arg1: Rep[DenseVector[L]])(implicit __pos: SourceContext,__imp1: Overload16) = trainingset_object_apply[D,L](__arg0,__arg1)(implicitly[Manifest[D]],implicitly[Manifest[L]],__pos)
  }

  implicit def repToTrainingSetTrainingSetOpsCls[D:Manifest,L:Manifest](x: Rep[TrainingSet[D,L]])(implicit __pos: SourceContext) = new TrainingSetTrainingSetOpsCls(x)(implicitly[Manifest[D]],implicitly[Manifest[L]],__pos)
  implicit def varToTrainingSetTrainingSetOpsCls[D:Manifest,L:Manifest](x: Var[TrainingSet[D,L]])(implicit __pos: SourceContext) = new TrainingSetTrainingSetOpsCls(readVar(x))(implicitly[Manifest[D]],implicitly[Manifest[L]],__pos)

  class TrainingSetTrainingSetOpsCls[D:Manifest,L:Manifest](val self: Rep[TrainingSet[D,L]])(implicit __pos: SourceContext) {
    def apply(__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload16) = trainingset_apply[D,L](self,__arg1,__arg2)(implicitly[Manifest[D]],implicitly[Manifest[L]],__pos,overload16)
    def apply(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload17) = trainingset_apply[D,L](self,__arg1)(implicitly[Manifest[D]],implicitly[Manifest[L]],__pos,overload17)
  }


  def infix_labels[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]])(implicit __pos: SourceContext) = trainingset_labels[D,L](self)(implicitly[Manifest[D]],implicitly[Manifest[L]],__pos)
  def infix_data[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]])(implicit __pos: SourceContext,__imp1: Overload1) = trainingset_data[D,L](self)(implicitly[Manifest[D]],implicitly[Manifest[L]],__pos)
  def infix_numSamples[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]])(implicit __pos: SourceContext) = trainingset_numsamples[D,L](self)(implicitly[Manifest[D]],implicitly[Manifest[L]],__pos)
  def infix_numFeatures[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]])(implicit __pos: SourceContext) = trainingset_numfeatures[D,L](self)(implicitly[Manifest[D]],implicitly[Manifest[L]],__pos)

  def trainingset_object_apply[D:Manifest,L:Manifest](__arg0: Rep[DenseMatrix[D]],__arg1: Rep[DenseVector[L]])(implicit __pos: SourceContext): Rep[TrainingSet[D,L]]
  def trainingset_labels[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]])(implicit __pos: SourceContext): Rep[DenseVector[L]]
  def trainingset_data[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]])(implicit __pos: SourceContext): Rep[DenseMatrix[D]]
  def trainingset_apply[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload16): Rep[D]
  def trainingset_apply[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload17): Rep[DenseVectorView[D]]
  def trainingset_numsamples[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]])(implicit __pos: SourceContext): Rep[Int]
  def trainingset_numfeatures[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]])(implicit __pos: SourceContext): Rep[Int]
}
