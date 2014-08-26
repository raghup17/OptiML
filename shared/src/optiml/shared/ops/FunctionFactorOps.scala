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

trait FunctionFactorOps extends Base {
  this: OptiML => 

  object FunctionFactor {
    def apply(id: Rep[Int],vars: Rep[DenseVector[FactorVariable]],weightId: Rep[Int],func: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload14) = functionfactor_object_apply(id,vars,weightId,func)(__pos)
  }

  def infix_id(self: Rep[FunctionFactor])(implicit __pos: SourceContext,__imp1: Overload2) = functionfactor_id(self)(__pos)
  def infix_vars(self: Rep[FunctionFactor])(implicit __pos: SourceContext,__imp1: Overload2) = functionfactor_vars(self)(__pos)
  def infix_weightId(self: Rep[FunctionFactor])(implicit __pos: SourceContext,__imp1: Overload1) = functionfactor_weightid(self)(__pos)
  def infix_funcId(self: Rep[FunctionFactor])(implicit __pos: SourceContext) = functionfactor_funcid(self)(__pos)
  def infix_evaluate(self: Rep[FunctionFactor],__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = functionfactor_evaluate(self,__arg1)(__pos)

  def functionfactor_object_apply(id: Rep[Int],vars: Rep[DenseVector[FactorVariable]],weightId: Rep[Int],func: Rep[Int])(implicit __pos: SourceContext): Rep[FunctionFactor]
  def functionfactor_id(self: Rep[FunctionFactor])(implicit __pos: SourceContext): Rep[Int]
  def functionfactor_vars(self: Rep[FunctionFactor])(implicit __pos: SourceContext): Rep[DenseVector[FactorVariable]]
  def functionfactor_weightid(self: Rep[FunctionFactor])(implicit __pos: SourceContext): Rep[Int]
  def functionfactor_funcid(self: Rep[FunctionFactor])(implicit __pos: SourceContext): Rep[Int]
  def functionfactor_evaluate(self: Rep[FunctionFactor],__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[Double]
}
trait FunctionFactorCompilerOps extends FunctionFactorOps {
  this: OptiML => 

  def function_factor_alloc_helper(id: Rep[Int],vars: Rep[DenseVector[FactorVariable]],weightId: Rep[Int],funcId: Rep[Int])(implicit __pos: SourceContext): Rep[FunctionFactor]
  def or_factor_func(__arg0: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[Double]
  def and_factor_func(__arg0: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[Double]
  def imply_factor_func(__arg0: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[Double]
  def equal_factor_func(__arg0: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[Double]
  def istrue_factor_func(__arg0: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[Double]
  def factor_func_to_int(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[Int]
  def evaluate_factor_func(funcId: Rep[Int],vals: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[Double]
}

