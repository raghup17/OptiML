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

trait BinaryFeatureOps extends Base {
  this: OptiML => 

  object BinaryFeature {
    def apply()(implicit __pos: SourceContext,__imp1: Overload10) = binaryfeature_object_apply()(__pos)
  }

  implicit def repToBinaryFeatureBinaryFeatureOpsCls(x: Rep[BinaryFeature])(implicit __pos: SourceContext) = new BinaryFeatureBinaryFeatureOpsCls(x)(__pos)
  implicit def varToBinaryFeatureBinaryFeatureOpsCls(x: Var[BinaryFeature])(implicit __pos: SourceContext) = new BinaryFeatureBinaryFeatureOpsCls(readVar(x))(__pos)

  class BinaryFeatureBinaryFeatureOpsCls(val self: Rep[BinaryFeature])(implicit __pos: SourceContext) {
    def apply(__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: Overload10) = binaryfeature_apply(self,__arg1)(__pos)
  }



  def binaryfeature_object_apply()(implicit __pos: SourceContext): Rep[BinaryFeature]
  def binaryfeature_apply(self: Rep[BinaryFeature],__arg1: Rep[String])(implicit __pos: SourceContext): Rep[Int]
}
