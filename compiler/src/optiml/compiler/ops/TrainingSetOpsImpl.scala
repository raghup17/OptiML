package optiml.compiler.ops

import scala.reflect.{Manifest,SourceContext}
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._
import optiml.compiler._
import optiml.compiler.ops._

/**
 * Op Impls
 */

trait TrainingSetOpsImpl {
  this: OptiMLCompiler with OptiMLLift => 

  def trainingset_apply_impl16[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext): Rep[D] = {
    self.data.apply(__arg1,__arg2)
  }

  def trainingset_apply_impl17[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[DenseVectorView[D]] = {
    self.data.apply(__arg1)
  }

  def trainingset_numsamples_impl[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]])(implicit __pos: SourceContext): Rep[Int] = {
    self.data.numRows
  }

  def trainingset_numfeatures_impl[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]])(implicit __pos: SourceContext): Rep[Int] = {
    self.data.numCols
  }

}
