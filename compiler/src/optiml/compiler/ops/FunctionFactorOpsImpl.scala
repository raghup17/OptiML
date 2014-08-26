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

trait FunctionFactorOpsImpl {
  this: OptiMLCompiler with OptiMLLift => 

  def functionfactor_object_apply_impl14(id: Rep[Int],vars: Rep[DenseVector[FactorVariable]],weightId: Rep[Int],func: Rep[Int])(implicit __pos: SourceContext): Rep[FunctionFactor] = {
    function_factor_alloc_helper(id, vars, weightId, func)
  }

  def or_factor_func_impl(__arg0: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[Double] = {
    if (__arg0.length == 0 || __arg0.filter(_ == 1.0).length > 0) 1.0 else 0.0
  }

  def and_factor_func_impl(__arg0: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[Double] = {
    if (__arg0.length == 0 || __arg0.filter(_ == 1.0).length == __arg0.length) 1.0 else 0.0
  }

  def imply_factor_func_impl(__arg0: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[Double] = {
    if (__arg0.length == 1) {
      __arg0(0)
    }
    else if (__arg0.take(__arg0.length - 1).contains(0.0)) {
      1.0
    }
    else if (__arg0.last == 0.0) {
      0.0
    }
    else {
      1.0
    }
  }

  def equal_factor_func_impl(__arg0: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[Double] = {
    if (__arg0.length == 2) {
      if (__arg0(0) == __arg0(1)) 1.0
      else 0.0
    }
    else {
      fatal("cannot evaluate equality between more than 2 variables")
    }
  }

  def istrue_factor_func_impl(__arg0: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[Double] = {
    if (__arg0.length == 1) __arg0.first
    else fatal("cannot evaluate isTrue for more than 1 variable")
  }

  def factor_func_to_int_impl(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[Int] = {
    if (__arg0 == "ImplyFactorFunction") 0
    else if (__arg0 == "OrFactorFunction") 1
    else if (__arg0 == "AndFactorFunction") 2
    else if (__arg0 == "EqualFactorFunction") 3
    else if (__arg0 == "IsTrueFactorFunction") 4
    else fatal("no factor function of type " + __arg0 + " found")
  }

  def evaluate_factor_func_impl(funcId: Rep[Int],vals: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[Double] = {
    if (funcId == 0) {
      imply_factor_func(vals)
    }
    else if (funcId == 1) {
      or_factor_func(vals)
    }
    else if (funcId == 2) {
      and_factor_func(vals)
    }
    else if (funcId == 3) {
      equal_factor_func(vals)
    }
    else if (funcId == 4) {
      istrue_factor_func(vals)
    }
    else {
      fatal("no factor func with id " + funcId + " found")
    }
  }

  def functionfactor_evaluate_impl(self: Rep[FunctionFactor],__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[Double] = {
    evaluate_factor_func(self.funcId, __arg1)
  }

}
