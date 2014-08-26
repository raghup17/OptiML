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

trait FactorGraphOps extends Base {
  this: OptiML => 

  object FactorGraph {
    def apply[F:Factor:Manifest](factors: Rep[DenseVector[F]],variables: Rep[DenseVector[RandomVariable]],weights: Rep[DenseVector[Weight]],variablesToFactors: Rep[DenseVector[DenseVector[Int]]],variableValues: Rep[DenseVector[Double]],weightValues: Rep[DenseVector[Double]])(implicit __pos: SourceContext,__imp1: Overload12) = factorgraph_object_apply[F](factors,variables,weights,variablesToFactors,variableValues,weightValues)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)
  }

  def infix_factors[F:Factor:Manifest](self: Rep[FactorGraph[F]])(implicit __pos: SourceContext) = factorgraph_factors[F](self)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)
  def infix_variables[F:Factor:Manifest](self: Rep[FactorGraph[F]])(implicit __pos: SourceContext) = factorgraph_variables[F](self)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)
  def infix_weights[F:Factor:Manifest](self: Rep[FactorGraph[F]])(implicit __pos: SourceContext) = factorgraph_weights[F](self)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)
  def infix_variablesToFactors[F:Factor:Manifest](self: Rep[FactorGraph[F]])(implicit __pos: SourceContext) = factorgraph_variablestofactors[F](self)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)
  def infix_getVariableValue[F:Factor:Manifest](self: Rep[FactorGraph[F]],id: Rep[Int],isPositive: Rep[Boolean] = unit(true))(implicit __pos: SourceContext) = factorgraph_getvariablevalue[F](self,id,isPositive)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)
  def infix_getWeightValue[F:Factor:Manifest](self: Rep[FactorGraph[F]],__arg1: Rep[Int])(implicit __pos: SourceContext) = factorgraph_getweightvalue[F](self,__arg1)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)
  def infix_updateVariableValue[F:Factor:Manifest](self: Rep[FactorGraph[F]],id: Rep[Int],newValue: Rep[Double])(implicit __pos: SourceContext) = factorgraph_updatevariablevalue[F](self,id,newValue)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)
  def infix_updateVariableValues[F:Factor:Manifest](self: Rep[FactorGraph[F]],ids: Rep[DenseVector[Int]],newValues: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = factorgraph_updatevariablevalues[F](self,ids,newValues)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)
  def infix_updateWeightValue[F:Factor:Manifest](self: Rep[FactorGraph[F]],id: Rep[Int],newValue: Rep[Double])(implicit __pos: SourceContext) = factorgraph_updateweightvalue[F](self,id,newValue)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)
  def infix_updateWeightValues[F:Factor:Manifest](self: Rep[FactorGraph[F]],ids: Rep[DenseVector[Int]],newValues: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = factorgraph_updateweightvalues[F](self,ids,newValues)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)

  def factorgraph_object_apply[F:Factor:Manifest](factors: Rep[DenseVector[F]],variables: Rep[DenseVector[RandomVariable]],weights: Rep[DenseVector[Weight]],variablesToFactors: Rep[DenseVector[DenseVector[Int]]],variableValues: Rep[DenseVector[Double]],weightValues: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[FactorGraph[F]]
  def factorgraph_factors[F:Factor:Manifest](self: Rep[FactorGraph[F]])(implicit __pos: SourceContext): Rep[DenseVector[F]]
  def factorgraph_variables[F:Factor:Manifest](self: Rep[FactorGraph[F]])(implicit __pos: SourceContext): Rep[DenseVector[RandomVariable]]
  def factorgraph_weights[F:Factor:Manifest](self: Rep[FactorGraph[F]])(implicit __pos: SourceContext): Rep[DenseVector[Weight]]
  def factorgraph_variablestofactors[F:Factor:Manifest](self: Rep[FactorGraph[F]])(implicit __pos: SourceContext): Rep[DenseVector[DenseVector[Int]]]
  def factorgraph_getvariablevalue[F:Factor:Manifest](self: Rep[FactorGraph[F]],id: Rep[Int],isPositive: Rep[Boolean] = unit(true))(implicit __pos: SourceContext): Rep[Double]
  def factorgraph_getweightvalue[F:Factor:Manifest](self: Rep[FactorGraph[F]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Double]
  def factorgraph_updatevariablevalue[F:Factor:Manifest](self: Rep[FactorGraph[F]],id: Rep[Int],newValue: Rep[Double])(implicit __pos: SourceContext): Rep[Unit]
  def factorgraph_updatevariablevalues[F:Factor:Manifest](self: Rep[FactorGraph[F]],ids: Rep[DenseVector[Int]],newValues: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[Unit]
  def factorgraph_updateweightvalue[F:Factor:Manifest](self: Rep[FactorGraph[F]],id: Rep[Int],newValue: Rep[Double])(implicit __pos: SourceContext): Rep[Unit]
  def factorgraph_updateweightvalues[F:Factor:Manifest](self: Rep[FactorGraph[F]],ids: Rep[DenseVector[Int]],newValues: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[Unit]
}
trait FactorGraphCompilerOps extends FactorGraphOps {
  this: OptiML => 

  def infix_variableValues[F:Factor:Manifest](self: Rep[FactorGraph[F]])(implicit __pos: SourceContext): Rep[DenseVector[Double]]
  def infix_weightsValues[F:Factor:Manifest](self: Rep[FactorGraph[F]])(implicit __pos: SourceContext): Rep[DenseVector[Double]]
}

