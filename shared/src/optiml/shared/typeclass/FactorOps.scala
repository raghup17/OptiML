package optiml.shared.typeclass

import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._

trait FactorOps extends Base with scala.math.Numeric.ExtraImplicits {
  this: OptiML => 

  /**
   * Type class
   */
  trait Factor[T] {
    def vars(__arg0: Rep[T])(implicit __pos: SourceContext): Rep[DenseVector[FactorVariable]]
    def valueOfAssignment(__arg0: Rep[T],__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[Double]
    def weightId(__arg0: Rep[T])(implicit __pos: SourceContext): Rep[Double]
  }

  def facttype[A,B](x: Factor[A]) = x.asInstanceOf[Factor[B]]

  /**
   * Type class instances
   */

  implicit def canFactorFunctionFactor: Factor[FunctionFactor] = new Factor[FunctionFactor] {
    def vars(__arg0: Rep[FunctionFactor])(implicit __pos: SourceContext) = {
      __arg0.vars
    }
    def valueOfAssignment(__arg0: Rep[FunctionFactor],__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
      __arg0.evaluate(__arg1)
    }
    def weightId(__arg0: Rep[FunctionFactor])(implicit __pos: SourceContext) = {
      __arg0.weightId
    }
  }

  implicit def canFactorTableFactor: Factor[TableFactor] = new Factor[TableFactor] {
    def vars(__arg0: Rep[TableFactor])(implicit __pos: SourceContext) = {
      __arg0.vars
    }
    def valueOfAssignment(__arg0: Rep[TableFactor],__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
      val assignment = __arg0.vars.map(_.domain).zip(__arg1) { (domain, value) => domain.find(_ == value).first }
      val index = assignmentToIndex(assignment)
      __arg0.vals.apply(index)
    }
    def weightId(__arg0: Rep[TableFactor])(implicit __pos: SourceContext) = {
      unit(0.0)
    }
  }


  /**
   * Forwarders - these allow infix notation to be used when the type class is available
   */
  implicit class Factor2FactorOps[T:Manifest:Factor](self: Rep[T]) {
    def vars()(implicit __pos: SourceContext) = factor_vars[T](self)
    def valueOfAssignment(__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = factor_valueofassignment[T](self,__arg1)
    def weightId()(implicit __pos: SourceContext) = factor_weightid[T](self)
  }

  def factor_vars[T:Manifest:Factor](__arg0: Rep[T])(implicit __pos: SourceContext): Rep[DenseVector[FactorVariable]] = implicitly[Factor[T]].vars(__arg0)
  def factor_valueofassignment[T:Manifest:Factor](__arg0: Rep[T],__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext): Rep[Double] = implicitly[Factor[T]].valueOfAssignment(__arg0,__arg1)
  def factor_weightid[T:Manifest:Factor](__arg0: Rep[T])(implicit __pos: SourceContext): Rep[Double] = implicitly[Factor[T]].weightId(__arg0)
}
