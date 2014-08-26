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

trait FactorGraphWrapper {
  this: OptiMLBase with OptiMLClasses => 

class FactorGraph[F:Factor:Manifest](___factors: DenseVector[F], ___variables: DenseVector[RandomVariable], ___weights: DenseVector[Weight], ___variablesToFactors: DenseVector[DenseVector[Int]], ___variableValues: DenseVector[Double], ___weightValues: DenseVector[Double]) {
  var _factors = ___factors
  var _variables = ___variables
  var _weights = ___weights
  var _variablesToFactors = ___variablesToFactors
  var _variableValues = ___variableValues
  var _weightValues = ___weightValues

}

  def factorgraph_object_apply[F:Factor:Manifest](factors: Rep[DenseVector[F]],variables: Rep[DenseVector[RandomVariable]],weights: Rep[DenseVector[Weight]],variablesToFactors: Rep[DenseVector[DenseVector[Int]]],variableValues: Rep[DenseVector[Double]],weightValues: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    new FactorGraph[F](factors,variables,weights,variablesToFactors,variableValues,weightValues)
  }
  def factorgraph_factors[F:Factor:Manifest](self: Rep[FactorGraph[F]])(implicit __pos: SourceContext) = {
    self._factors
  }
  def factorgraph_variables[F:Factor:Manifest](self: Rep[FactorGraph[F]])(implicit __pos: SourceContext) = {
    self._variables
  }
  def factorgraph_weights[F:Factor:Manifest](self: Rep[FactorGraph[F]])(implicit __pos: SourceContext) = {
    self._weights
  }
  def factorgraph_variablestofactors[F:Factor:Manifest](self: Rep[FactorGraph[F]])(implicit __pos: SourceContext) = {
    self._variablesToFactors
  }
  def infix_variableValues[F:Factor:Manifest](self: Rep[FactorGraph[F]])(implicit __pos: SourceContext) = {
    self._variableValues
  }
  def infix_weightsValues[F:Factor:Manifest](self: Rep[FactorGraph[F]])(implicit __pos: SourceContext) = {
    self._weightValues
  }
  def factorgraph_getvariablevalue[F:Factor:Manifest](self: Rep[FactorGraph[F]],id: Rep[Int],isPositive: Rep[Boolean] = unit(true))(implicit __pos: SourceContext) = {
    factorgraph_getvariablevalue_impl[F](self,id,isPositive)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)
  }
  def factorgraph_getweightvalue[F:Factor:Manifest](self: Rep[FactorGraph[F]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    factorgraph_getweightvalue_impl[F](self,__arg1)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)
  }
  def factorgraph_updatevariablevalue[F:Factor:Manifest](self: Rep[FactorGraph[F]],id: Rep[Int],newValue: Rep[Double])(implicit __pos: SourceContext) = {
    factorgraph_updatevariablevalue_impl[F](self,id,newValue)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)
  }
  def factorgraph_updatevariablevalues[F:Factor:Manifest](self: Rep[FactorGraph[F]],ids: Rep[DenseVector[Int]],newValues: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    factorgraph_updatevariablevalues_impl[F](self,ids,newValues)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)
  }
  def factorgraph_updateweightvalue[F:Factor:Manifest](self: Rep[FactorGraph[F]],id: Rep[Int],newValue: Rep[Double])(implicit __pos: SourceContext) = {
    factorgraph_updateweightvalue_impl[F](self,id,newValue)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)
  }
  def factorgraph_updateweightvalues[F:Factor:Manifest](self: Rep[FactorGraph[F]],ids: Rep[DenseVector[Int]],newValues: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    factorgraph_updateweightvalues_impl[F](self,ids,newValues)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)
  }

}

