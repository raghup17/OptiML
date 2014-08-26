package optiml.library.classes

import scala.reflect.{Manifest,SourceContext}
import scala.math.Ordering.Implicits._
import scala.math.Numeric.Implicits._
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._
import optiml.library._
import optiml.library.classes._

/**
 * SingleTask and Composite Impls
 */

trait ComputeStreamWrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def computestream_apply_impl14[T:Manifest](self: Rep[ComputeStream[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext): Rep[T] = {
    val lambda = stream_func(self)
    doApply(lambda, pack((__arg1,__arg2)))
  }

  def computestream_foreach_impl2[T:Manifest](self: Rep[ComputeStream[T]],__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit] = {
    (0::self.numRows) foreach { i =>
      
      
      IndexVector(0, self.numCols) foreach { j =>
        __arg1(self(i,j))      
      }
    }
  }

  def computestream_foreachrow_impl1[T:Manifest](self: Rep[ComputeStream[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit] = {
    val chunkSize = ceil(1000000/self.numCols) 
    val buf = DenseMatrix[T](chunkSize, self.numCols)
    val numChunks = ceil(self.numRows / chunkSize.toDouble)
    
    var chunkIdx = 0
    while (chunkIdx < numChunks) {
      val remainingRows = self.numRows - chunkIdx*chunkSize
      val leftover = if (remainingRows < 0) self.numRows else remainingRows 
      val rowsToProcess = min(chunkSize, leftover)
      (0::rowsToProcess) foreach { i =>
        
        IndexVector(0, self.numCols) foreach { j =>    
          buf(i,j) = self(i,j)
        }    
        __arg1(buf(i))
      }  
    
      chunkIdx += 1
    }
  }

}
