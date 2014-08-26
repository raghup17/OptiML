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

trait GrayscaleImageOps extends Base {
  this: OptiML => 

  object GrayscaleImage {
    def apply(__arg0: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: Overload26) = grayscaleimage_object_apply(__arg0)(__pos)
  }

  implicit def repToGrayscaleImageGrayscaleImageOpsCls(x: Rep[GrayscaleImage])(implicit __pos: SourceContext) = new GrayscaleImageGrayscaleImageOpsCls(x)(__pos)
  implicit def varToGrayscaleImageGrayscaleImageOpsCls(x: Var[GrayscaleImage])(implicit __pos: SourceContext) = new GrayscaleImageGrayscaleImageOpsCls(readVar(x))(__pos)

  class GrayscaleImageGrayscaleImageOpsCls(val self: Rep[GrayscaleImage])(implicit __pos: SourceContext) {
    def downsample(rowFactor: Rep[Int],colFactor: Rep[Int])(sample: (Rep[GrayscaleImage]) => Rep[Double])(implicit __pos: SourceContext) = grayscaleimage_downsample(self,rowFactor,colFactor,sample)(__pos)
    def windowedFilter(rowDim: Rep[Int],colDim: Rep[Int])(block: (Rep[GrayscaleImage]) => Rep[Double])(implicit __pos: SourceContext) = grayscaleimage_windowedfilter(self,rowDim,colDim,block)(__pos)
  }


  def infix_data(self: Rep[GrayscaleImage])(implicit __pos: SourceContext,__imp1: Overload2) = grayscaleimage_data(self)(__pos)
  def infix_numRows(self: Rep[GrayscaleImage])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[Int] = { self.data.numRows }
  def infix_numCols(self: Rep[GrayscaleImage])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[Int] = { self.data.numCols }
  def infix_convolve(self: Rep[GrayscaleImage],kernel: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext) = grayscaleimage_convolve(self,kernel)(__pos)
  def infix_histogram(self: Rep[GrayscaleImage])(implicit __pos: SourceContext) = grayscaleimage_histogram(self)(__pos)

  def grayscaleimage_object_apply(__arg0: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext): Rep[GrayscaleImage]
  def grayscaleimage_data(self: Rep[GrayscaleImage])(implicit __pos: SourceContext): Rep[DenseMatrix[Double]]
  def grayscaleimage_downsample(self: Rep[GrayscaleImage],rowFactor: Rep[Int],colFactor: Rep[Int],sample: (Rep[GrayscaleImage]) => Rep[Double])(implicit __pos: SourceContext): Rep[GrayscaleImage]
  def grayscaleimage_convolve(self: Rep[GrayscaleImage],kernel: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext): Rep[GrayscaleImage]
  def grayscaleimage_windowedfilter(self: Rep[GrayscaleImage],rowDim: Rep[Int],colDim: Rep[Int],block: (Rep[GrayscaleImage]) => Rep[Double])(implicit __pos: SourceContext): Rep[GrayscaleImage]
  def grayscaleimage_histogram(self: Rep[GrayscaleImage])(implicit __pos: SourceContext): Rep[DenseVector[Int]]
}
