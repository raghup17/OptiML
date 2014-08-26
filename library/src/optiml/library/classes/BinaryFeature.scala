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

trait BinaryFeatureWrapper {
  this: OptiMLBase with OptiMLClasses => 

class BinaryFeature() {

}

  def binaryfeature_object_apply()(implicit __pos: SourceContext) = {
    def __imp1 = ()
    new BinaryFeature()
  }
  def binaryfeature_apply(self: Rep[BinaryFeature],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    binaryfeature_apply_impl10(self,__arg1)(__pos)
  }

}

