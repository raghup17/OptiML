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

trait TableFactorWrapper {
  this: OptiMLBase with OptiMLClasses => 

class TableFactor(___vars: DenseVector[FactorVariable], ___vals: DenseVector[Double]) {
  var _vars = ___vars
  var _vals = ___vals

}

  def tablefactor_object_apply(vars: Rep[DenseVector[FactorVariable]],vals: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    new TableFactor(vars,vals)
  }
  def tablefactor_assignmenttoindex(__arg0: Rep[DenseVector[Int]])(implicit __pos: SourceContext) = {
    tablefactor_assignmenttoindex_impl(__arg0)(__pos)
  }
  def tablefactor_indextoassignment(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    tablefactor_indextoassignment_impl(__arg0)(__pos)
  }
  def tablefactor_vars(self: Rep[TableFactor])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._vars
  }
  def tablefactor_vals(self: Rep[TableFactor])(implicit __pos: SourceContext) = {
    self._vals
  }

}

