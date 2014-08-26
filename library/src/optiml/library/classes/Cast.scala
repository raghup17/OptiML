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

trait CastWrapper {
  this: OptiMLBase with OptiMLClasses => 

  def cast_asinstanceof[A:Manifest,B:Manifest](__arg0: Rep[A])(implicit __pos: SourceContext) = {
    __arg0.asInstanceOf[B]
  }
  def cast_isinstanceof[A:Manifest,B:Manifest](__arg0: Rep[A])(implicit __pos: SourceContext) = {
    __arg0.isInstanceOf[B]
  }

}

