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

trait RangeOps extends Base {
  this: OptiML => 


}
trait RangeCompilerOps extends RangeOps {
  this: OptiML => 

  def range_start(__arg0: Rep[Range])(implicit __pos: SourceContext): Rep[Int]
  def range_end(__arg0: Rep[Range])(implicit __pos: SourceContext): Rep[Int]
  def infix_until(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Range]
  def infix_by(__arg0: Rep[Range], __arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Range]
  def infix_foreach(__arg0: Rep[Range],__arg1: (Rep[Int]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit]
  def range_foreach(start: Rep[Int],end: Rep[Int],step: Int, func: (Rep[Int]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit]
}

