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

trait FunctionFactorWrapper {
  this: OptiMLBase with OptiMLClasses => 

class FunctionFactor(___id: Int, ___vars: DenseVector[FactorVariable], ___weightId: Int, ___funcId: Int) {
  var _id = ___id
  var _vars = ___vars
  var _weightId = ___weightId
  var _funcId = ___funcId

}

  def functionfactor_object_apply(id: Rep[Int],vars: Rep[DenseVector[FactorVariable]],weightId: Rep[Int],func: Rep[Int])(implicit __pos: SourceContext) = {
    functionfactor_object_apply_impl14(id,vars,weightId,func)(__pos)
  }
  def function_factor_alloc_helper(id: Rep[Int],vars: Rep[DenseVector[FactorVariable]],weightId: Rep[Int],funcId: Rep[Int])(implicit __pos: SourceContext) = {
    new FunctionFactor(id,vars,weightId,funcId)
  }
  def or_factor_func(__arg0: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    or_factor_func_impl(__arg0)(__pos)
  }
  def and_factor_func(__arg0: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    and_factor_func_impl(__arg0)(__pos)
  }
  def imply_factor_func(__arg0: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    imply_factor_func_impl(__arg0)(__pos)
  }
  def equal_factor_func(__arg0: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    equal_factor_func_impl(__arg0)(__pos)
  }
  def istrue_factor_func(__arg0: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    istrue_factor_func_impl(__arg0)(__pos)
  }
  def factor_func_to_int(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    factor_func_to_int_impl(__arg0)(__pos)
  }
  def evaluate_factor_func(funcId: Rep[Int],vals: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    evaluate_factor_func_impl(funcId,vals)(__pos)
  }
  def functionfactor_id(self: Rep[FunctionFactor])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._id
  }
  def functionfactor_vars(self: Rep[FunctionFactor])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._vars
  }
  def functionfactor_weightid(self: Rep[FunctionFactor])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._weightId
  }
  def functionfactor_funcid(self: Rep[FunctionFactor])(implicit __pos: SourceContext) = {
    self._funcId
  }
  def functionfactor_evaluate(self: Rep[FunctionFactor],__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    functionfactor_evaluate_impl(self,__arg1)(__pos)
  }

}

