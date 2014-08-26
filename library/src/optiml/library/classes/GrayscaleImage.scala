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

trait GrayscaleImageWrapper {
  this: OptiMLBase with OptiMLClasses => 

class GrayscaleImage(___data: DenseMatrix[Double]) {
  var _data = ___data

}

  def grayscaleimage_object_apply(__arg0: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    new GrayscaleImage(__arg0)
  }
  def grayscaleimage_data(self: Rep[GrayscaleImage])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._data
  }
  def grayscaleimage_downsample(self: Rep[GrayscaleImage],rowFactor: Rep[Int],colFactor: Rep[Int],sample: (Rep[GrayscaleImage]) => Rep[Double])(implicit __pos: SourceContext) = {
    grayscaleimage_downsample_impl(self,rowFactor,colFactor,sample)(__pos)
  }
  def grayscaleimage_convolve(self: Rep[GrayscaleImage],kernel: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext) = {
    grayscaleimage_convolve_impl(self,kernel)(__pos)
  }
  def grayscaleimage_windowedfilter(self: Rep[GrayscaleImage],rowDim: Rep[Int],colDim: Rep[Int],block: (Rep[GrayscaleImage]) => Rep[Double])(implicit __pos: SourceContext) = {
    grayscaleimage_windowedfilter_impl(self,rowDim,colDim,block)(__pos)
  }
  def grayscaleimage_histogram(self: Rep[GrayscaleImage])(implicit __pos: SourceContext) = {
    grayscaleimage_histogram_impl(self)(__pos)
  }

}

