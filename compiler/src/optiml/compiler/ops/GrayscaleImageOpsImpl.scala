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

trait GrayscaleImageOpsImpl {
  this: OptiMLCompiler with OptiMLLift => 

  def grayscaleimage_downsample_impl(self: Rep[GrayscaleImage],rowFactor: Rep[Int],colFactor: Rep[Int],sample: (Rep[GrayscaleImage]) => Rep[Double])(implicit __pos: SourceContext): Rep[GrayscaleImage] = {
    val sampledData = (0::(self.numRows / rowFactor), 0::(self.numCols / colFactor))  { (i,j) =>  
      sample(GrayscaleImage(self.data.slice(rowFactor * i, rowFactor*i + rowFactor, colFactor*j, colFactor*j + colFactor)))
    }
    GrayscaleImage(sampledData)
  }

  def grayscaleimage_convolve_impl(self: Rep[GrayscaleImage],kernel: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext): Rep[GrayscaleImage] = {
    self.windowedFilter(kernel.numRows, kernel.numCols) { slice => (slice.data *:* kernel).sum }
  }

  def grayscaleimage_windowedfilter_impl(self: Rep[GrayscaleImage],rowDim: Rep[Int],colDim: Rep[Int],block: (Rep[GrayscaleImage]) => Rep[Double])(implicit __pos: SourceContext): Rep[GrayscaleImage] = {
    val rowOffset = (rowDim - 1) / 2
    val colOffset = (colDim - 1) / 2
    
    val out = (0::self.numRows, 0::self.numCols) { (i,j) =>
      val window = (i-rowOffset::i+rowOffset+1, j-colOffset::j+colOffset+1) { (ii, jj) =>
        
        if (ii < 0 || ii >= self.numRows || jj < 0 || jj >= self.numCols) {
          0.0
        }
        else {
          self.data.apply(ii,jj)
        }
      }
      block(GrayscaleImage(window))
    }
    GrayscaleImage(out)
  }

  def grayscaleimage_histogram_impl(self: Rep[GrayscaleImage])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    val buckets = self.data.flattenToVector.groupByReduce(e => e.toInt, e => 1, (a: Rep[Int],b: Rep[Int]) => a+b)
    (0::256) { i => if (buckets.contains(i)) buckets(i) else 0 }
  }

}
