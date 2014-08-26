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

trait FileStreamWrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def filestream_foreach_impl6(self: Rep[FileStream],__arg1: (Rep[String]) => Rep[Unit])(implicit __pos: SourceContext): Rep[Unit] = {
    val f = open_reader(self.path)
    var line = read_line(f)
    while (line != null) {
      __arg1(line)
      line = read_line(f)
    }
    close_reader(f)
  }

  def filestream_map_impl5(self: Rep[FileStream],outFile: Rep[String],func: (Rep[String]) => Rep[String])(implicit __pos: SourceContext): Rep[Unit] = {
    val out = open_writer(outFile)
    
    
    self.foreach { line: Rep[String] => 
      write_line(out, func(line)) 
    }
    close_writer(out)
  }

  def filestream_reduce_impl4[T:Manifest](self: Rep[FileStream],init: Rep[T],func: (Rep[T],Rep[String]) => Rep[T])(implicit __pos: SourceContext): Rep[T] = {
    var acc = init
    
    self.foreach { line: Rep[String] => 
      acc = func(acc, line)
    }
    acc
  }

}
