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

trait ComputeStreamOps extends Base {
  this: OptiML => 

  object ComputeStream {
    def apply[T:Manifest](numRows: Rep[Int],numCols: Rep[Int])(func: (Rep[Int],Rep[Int]) => Rep[T])(implicit __pos: SourceContext,__imp1: Overload15) = computestream_object_apply[T](numRows,numCols,func)(implicitly[Manifest[T]],__pos)
  }

  implicit def repToComputeStreamComputeStreamOpsCls[T:Manifest](x: Rep[ComputeStream[T]])(implicit __pos: SourceContext) = new ComputeStreamComputeStreamOpsCls(x)(implicitly[Manifest[T]],__pos)
  implicit def varToComputeStreamComputeStreamOpsCls[T:Manifest](x: Var[ComputeStream[T]])(implicit __pos: SourceContext) = new ComputeStreamComputeStreamOpsCls(readVar(x))(implicitly[Manifest[T]],__pos)

  class ComputeStreamComputeStreamOpsCls[T:Manifest](val self: Rep[ComputeStream[T]])(implicit __pos: SourceContext) {
    def apply(__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload14) = computestream_apply[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
    def foreach(__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext,__imp1: Overload2) = computestream_foreach[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def foreachRow(__arg1: (Rep[DenseVectorView[T]]) => Rep[Unit])(implicit __pos: SourceContext,__imp1: Overload1) = computestream_foreachrow[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }


  def infix_numRows[T:Manifest](self: Rep[ComputeStream[T]])(implicit __pos: SourceContext,__imp1: Overload1) = computestream_numrows[T](self)(implicitly[Manifest[T]],__pos)
  def infix_numCols[T:Manifest](self: Rep[ComputeStream[T]])(implicit __pos: SourceContext,__imp1: Overload1) = computestream_numcols[T](self)(implicitly[Manifest[T]],__pos)

  def computestream_object_apply[T:Manifest](numRows: Rep[Int],numCols: Rep[Int],func: (Rep[Int],Rep[Int]) => Rep[T])(implicit __pos: SourceContext): Rep[ComputeStream[T]]
  def computestream_numrows[T:Manifest](self: Rep[ComputeStream[T]])(implicit __pos: SourceContext): Rep[Int]
  def computestream_numcols[T:Manifest](self: Rep[ComputeStream[T]])(implicit __pos: SourceContext): Rep[Int]
  def computestream_apply[T:Manifest](self: Rep[ComputeStream[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext): Rep[T]
  def computestream_foreach[T:Manifest](self: Rep[ComputeStream[T]],__arg1: (Rep[T]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit]
  def computestream_foreachrow[T:Manifest](self: Rep[ComputeStream[T]],__arg1: (Rep[DenseVectorView[T]]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit]
}
trait ComputeStreamCompilerOps extends ComputeStreamOps {
  this: OptiML => 

  def stream_func[T:Manifest](self: Rep[ComputeStream[T]])(implicit __pos: SourceContext): Rep[Function1[Tup2[Int,Int],T]]
}

