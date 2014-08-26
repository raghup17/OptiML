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

trait FileStreamWrapper {
  this: OptiMLBase with OptiMLClasses => 

class FileStream(___path: String) {
  var _path = ___path

}

  def filestream_object_apply(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    new FileStream(__arg0)
  }
  def open_reader(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    new java.io.BufferedReader(new java.io.FileReader(__arg0))
  }
  def close_reader(__arg0: Rep[java.io.BufferedReader])(implicit __pos: SourceContext) = {
    __arg0.close()
  }
  def read_line(__arg0: Rep[java.io.BufferedReader])(implicit __pos: SourceContext) = {
    __arg0.readLine()
  }
  def open_writer(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    new java.io.BufferedWriter(new java.io.FileWriter(__arg0))
  }
  def close_writer(__arg0: Rep[java.io.BufferedWriter])(implicit __pos: SourceContext) = {
    __arg0.close()
  }
  def write_line(__arg0: Rep[java.io.BufferedWriter],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.write(__arg1, 0, __arg1.length)
    __arg0.newLine()
  }
  def filestream_path(self: Rep[FileStream])(implicit __pos: SourceContext) = {
    self._path
  }
  def filestream_foreach(self: Rep[FileStream],__arg1: (Rep[String]) => Rep[Unit])(implicit __pos: SourceContext) = {
    filestream_foreach_impl6(self,__arg1)(__pos)
  }
  def filestream_map(self: Rep[FileStream],outFile: Rep[String],func: (Rep[String]) => Rep[String])(implicit __pos: SourceContext) = {
    filestream_map_impl5(self,outFile,func)(__pos)
  }
  def filestream_reduce[T:Manifest](self: Rep[FileStream],init: Rep[T],func: (Rep[T],Rep[String]) => Rep[T])(implicit __pos: SourceContext) = {
    filestream_reduce_impl4[T](self,init,func)(implicitly[Manifest[T]],__pos)
  }

}

