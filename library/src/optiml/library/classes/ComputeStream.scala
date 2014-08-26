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

trait ComputeStreamWrapper {
  this: OptiMLBase with OptiMLClasses => 

class ComputeStream[T:Manifest](___numRows: Int, ___numCols: Int, ___func: Function1[Tup2[Int,Int],T]) {
  var _numRows = ___numRows
  var _numCols = ___numCols
  var _func = ___func

}

  def computestream_object_apply[T:Manifest](numRows: Rep[Int],numCols: Rep[Int],func: (Rep[Int],Rep[Int]) => Rep[T])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    new ComputeStream[T](numRows,numCols,doLambda((t: Rep[Tup2[Int,Int]]) => func(t._1, t._2)))
  }
  def computestream_numrows[T:Manifest](self: Rep[ComputeStream[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._numRows
  }
  def computestream_numcols[T:Manifest](self: Rep[ComputeStream[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._numCols
  }
  def stream_func[T:Manifest](self: Rep[ComputeStream[T]])(implicit __pos: SourceContext) = {
    self._func
  }
  def computestream_apply[T:Manifest](self: Rep[ComputeStream[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext) = {
    computestream_apply_impl14[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def computestream_foreach[T:Manifest](self: Rep[ComputeStream[T]],__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext) = {
    computestream_foreach_impl2[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def computestream_foreachrow[T:Manifest](self: Rep[ComputeStream[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[Unit])(implicit __pos: SourceContext) = {
    computestream_foreachrow_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }

}

