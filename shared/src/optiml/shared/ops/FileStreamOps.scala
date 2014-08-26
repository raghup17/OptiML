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

trait FileStreamOps extends Base {
  this: OptiML => 

  object FileStream {
    def apply(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload28) = filestream_object_apply(__arg0)(__pos)
  }

  implicit def repToFileStreamFileStreamOpsCls(x: Rep[FileStream])(implicit __pos: SourceContext) = new FileStreamFileStreamOpsCls(x)(__pos)
  implicit def varToFileStreamFileStreamOpsCls(x: Var[FileStream])(implicit __pos: SourceContext) = new FileStreamFileStreamOpsCls(readVar(x))(__pos)

  class FileStreamFileStreamOpsCls(val self: Rep[FileStream])(implicit __pos: SourceContext) {
    def foreach(__arg1: (Rep[String]) => Rep[Unit])(implicit __pos: SourceContext,__imp1: Overload6) = filestream_foreach(self,__arg1)(__pos)
    def map(outFile: Rep[String])(func: (Rep[String]) => Rep[String])(implicit __pos: SourceContext,__imp1: Overload5) = filestream_map(self,outFile,func)(__pos)
    def reduce[T:Manifest](init: Rep[T])(func: (Rep[T],Rep[String]) => Rep[T])(implicit __pos: SourceContext,__imp1: Overload4) = filestream_reduce[T](self,init,func)(implicitly[Manifest[T]],__pos)
  }


  def infix_path(self: Rep[FileStream])(implicit __pos: SourceContext) = filestream_path(self)(__pos)

  def filestream_object_apply(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[FileStream]
  def filestream_path(self: Rep[FileStream])(implicit __pos: SourceContext): Rep[String]
  def filestream_foreach(self: Rep[FileStream],__arg1: (Rep[String]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit]
  def filestream_map(self: Rep[FileStream],outFile: Rep[String],func: (Rep[String]) => Rep[String])(implicit __pos: SourceContext): Rep[Unit]
  def filestream_reduce[T:Manifest](self: Rep[FileStream],init: Rep[T],func: (Rep[T],Rep[String]) => Rep[T])(implicit __pos: SourceContext): Rep[T]
}
trait FileStreamCompilerOps extends FileStreamOps {
  this: OptiML => 

  def open_reader(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[java.io.BufferedReader]
  def close_reader(__arg0: Rep[java.io.BufferedReader])(implicit __pos: SourceContext): Rep[Unit]
  def read_line(__arg0: Rep[java.io.BufferedReader])(implicit __pos: SourceContext): Rep[String]
  def open_writer(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[java.io.BufferedWriter]
  def close_writer(__arg0: Rep[java.io.BufferedWriter])(implicit __pos: SourceContext): Rep[Unit]
  def write_line(__arg0: Rep[java.io.BufferedWriter],__arg1: Rep[String])(implicit __pos: SourceContext): Rep[Unit]
}

