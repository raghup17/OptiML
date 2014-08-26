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

trait RangeWrapper {
  this: OptiMLBase with OptiMLClasses => 

class Range(__start: Int, __end: Int, __step: Int) {
  var start = __start
  var end = __end
  var step = __step
  
}

  def range_start(__arg0: Rep[Range])(implicit __pos: SourceContext) = {
    __arg0.start
  }
  def range_end(__arg0: Rep[Range])(implicit __pos: SourceContext) = {
    __arg0.end
  }
  def infix_until(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    new Range(__arg0,__arg1, 1)
  }

  def infix_by(__arg0: Rep[Range],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    throw new Exception("Not implemented yet")
    new Range(10,20, __arg1)
  }

  def infix_foreach(__arg0: Rep[Range],__arg1: (Rep[Int]) => Rep[Unit])(implicit __pos: SourceContext) = {
    infix_foreach_impl(__arg0,__arg1)(__pos)
  }
  def range_foreach(start: Rep[Int],end: Rep[Int], step: Int, func: (Rep[Int]) => Rep[Unit])(implicit __pos: SourceContext) = {
    var i = start
    while (i < end) {
      func(i)
      i += 1
    }
  }

}

