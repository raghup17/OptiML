package optiml.library.classes

import scala.reflect.{Manifest,SourceContext}
import scala.math.Ordering.Implicits._
import scala.math.Numeric.Implicits._
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._
import optiml.library._
import optiml.library.classes._

trait TrainingSetWrapper {
  this: OptiMLBase with OptiMLClasses => 

class TrainingSet[D:Manifest,L:Manifest](___data: DenseMatrix[D], ___labels: DenseVector[L]) {
  var _data = ___data
  var _labels = ___labels

}

  def trainingset_object_apply[D:Manifest,L:Manifest](__arg0: Rep[DenseMatrix[D]],__arg1: Rep[DenseVector[L]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    new TrainingSet[D,L](__arg0,__arg1)
  }
  def trainingset_labels[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]])(implicit __pos: SourceContext) = {
    self._labels
  }
  def trainingset_data[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._data
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

}

