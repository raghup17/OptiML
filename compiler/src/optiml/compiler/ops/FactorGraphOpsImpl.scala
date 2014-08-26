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

trait FactorGraphOpsImpl {
  this: OptiMLCompiler with OptiMLLift => 

  def factorgraph_getvariablevalue_impl[F:Factor:Manifest](self: Rep[FactorGraph[F]],id: Rep[Int],isPositive: Rep[Boolean] = unit(true))(implicit __pos: SourceContext): Rep[Double] = {
    if (isPositive) self.variableValues.apply(id) else 1.0 - self.variableValues.apply(id)
  }

  def factorgraph_getweightvalue_impl[F:Factor:Manifest](self: Rep[FactorGraph[F]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Double] = {
    self.weightsValues.apply(__arg1)
  }

  def factorgraph_updatevariablevalue_impl[F:Factor:Manifest](self: Rep[FactorGraph[F]],id: Rep[Int],newValue: Rep[Double])(implicit __pos: SourceContext): Rep[Unit] = {
    self.variableValues(id) = newValue
  }

  def factorgraph_updatevariablevalues_impl[F:Factor:Manifest](self: Rep[FactorGraph[F]],ids: Rep[DenseVector[Int]],newValues: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[Unit] = {
    for (i <- ids.indices) {
      self.updateVariableValue(ids(i), newValues(i))
    }
  }

  def factorgraph_updateweightvalue_impl[F:Factor:Manifest](self: Rep[FactorGraph[F]],id: Rep[Int],newValue: Rep[Double])(implicit __pos: SourceContext): Rep[Unit] = {
    self.weightsValues(id) = newValue
  }

  def factorgraph_updateweightvalues_impl[F:Factor:Manifest](self: Rep[FactorGraph[F]],ids: Rep[DenseVector[Int]],newValues: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[Unit] = {
    for (i <- ids.indices) {
      self.updateWeightValue(ids(i), newValues(i))
    }
  }

}
