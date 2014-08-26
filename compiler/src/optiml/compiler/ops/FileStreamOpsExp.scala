package optiml.compiler.ops

import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import ppl.delite.framework.ops.DeliteCollection
import ppl.delite.framework.datastructures._
import ppl.delite.framework.ops.{DeliteOpsExp, DeliteCollectionOpsExp}
import ppl.delite.framework.Util._
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._
import optiml.compiler._
import optiml.compiler.ops._

/**
 * IR Definitions
 */

trait FileStreamOpsExp extends FileStreamCompilerOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class FileStream28Object_Apply(__arg0: Rep[String])(implicit val __pos: SourceContext) extends DeliteStruct[FileStream] {
    val elems = copyTransformedElems(collection.Seq(("_path",__arg0)))
  }

  case class Open_reader(__arg0: Rep[String])(implicit val __pos: SourceContext) extends Def[java.io.BufferedReader] {
  }

  case class Close_reader(__arg0: Rep[java.io.BufferedReader])(implicit val __pos: SourceContext) extends Def[Unit] {
  }

  case class Read_line(__arg0: Rep[java.io.BufferedReader])(implicit val __pos: SourceContext) extends Def[String] {
  }

  case class Open_writer(__arg0: Rep[String])(implicit val __pos: SourceContext) extends Def[java.io.BufferedWriter] {
  }

  case class Close_writer(__arg0: Rep[java.io.BufferedWriter])(implicit val __pos: SourceContext) extends Def[Unit] {
  }

  case class Write_line(__arg0: Rep[java.io.BufferedWriter],__arg1: Rep[String])(implicit val __pos: SourceContext) extends Def[Unit] {
  }

  case class FileStream6_Foreach(self: Rep[FileStream],__arg1: (Rep[String]) => Rep[Unit])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(filestream_foreach_impl6(self,__arg1)(__pos))) {
  }



  def filestream_object_apply(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FileStream28Object_Apply(__arg0)(__pos))
  }
  def open_reader(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    reflectEffect(Open_reader(__arg0)(__pos))
  }
  def close_reader(__arg0: Rep[java.io.BufferedReader])(implicit __pos: SourceContext) = {
    reflectEffect(Close_reader(__arg0)(__pos))
  }
  def read_line(__arg0: Rep[java.io.BufferedReader])(implicit __pos: SourceContext) = {
    reflectEffect(Read_line(__arg0)(__pos))
  }
  def open_writer(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    reflectEffect(Open_writer(__arg0)(__pos))
  }
  def close_writer(__arg0: Rep[java.io.BufferedWriter])(implicit __pos: SourceContext) = {
    reflectEffect(Close_writer(__arg0)(__pos))
  }
  def write_line(__arg0: Rep[java.io.BufferedWriter],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    reflectEffect(Write_line(__arg0,__arg1)(__pos))
  }
  def filestream_path(self: Rep[FileStream])(implicit __pos: SourceContext) = {
    field[String](self,"_path")
  }
  def filestream_foreach(self: Rep[FileStream],__arg1: (Rep[String]) => Rep[Unit])(implicit __pos: SourceContext) = {
    reflectPure(FileStream6_Foreach(self,__arg1)(__pos))
  }
  def filestream_map(self: Rep[FileStream],outFile: Rep[String],func: (Rep[String]) => Rep[String])(implicit __pos: SourceContext) = {
    filestream_map_impl5(self,outFile,func)(__pos)
  }
  def filestream_reduce[T:Manifest](self: Rep[FileStream],init: Rep[T],func: (Rep[T],Rep[String]) => Rep[T])(implicit __pos: SourceContext) = {
    filestream_reduce_impl4[T](self,init,func)(implicitly[Manifest[T]],__pos)
  }

  /**
   * Syms
   */
  override def syms(e: Any): List[Sym[Any]] = e match {
    case _ => super.syms(e)
  }
  override def boundSyms(e: Any): List[Sym[Any]] = e match {
    case _ => super.boundSyms(e)
  }
  override def symsFreq(e: Any): List[(Sym[Any], Double)] = e match {
    case _ => super.symsFreq(e)
  }


  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@FileStream28Object_Apply(__arg0) => reflectPure(new { override val original = Some(f,mn) } with FileStream28Object_Apply(f(__arg0))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@FileStream28Object_Apply(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with FileStream28Object_Apply(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Open_reader(__arg0) => open_reader(f(__arg0))(mn.__pos)
    case Reflect(mn@Open_reader(__arg0), u, es) => reflectMirrored(Reflect(Open_reader(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Close_reader(__arg0) => close_reader(f(__arg0))(mn.__pos)
    case Reflect(mn@Close_reader(__arg0), u, es) => reflectMirrored(Reflect(Close_reader(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Read_line(__arg0) => read_line(f(__arg0))(mn.__pos)
    case Reflect(mn@Read_line(__arg0), u, es) => reflectMirrored(Reflect(Read_line(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Open_writer(__arg0) => open_writer(f(__arg0))(mn.__pos)
    case Reflect(mn@Open_writer(__arg0), u, es) => reflectMirrored(Reflect(Open_writer(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Close_writer(__arg0) => close_writer(f(__arg0))(mn.__pos)
    case Reflect(mn@Close_writer(__arg0), u, es) => reflectMirrored(Reflect(Close_writer(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Write_line(__arg0,__arg1) => write_line(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Write_line(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Write_line(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FileStream6_Foreach(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with FileStream6_Foreach(f(__arg0),f(__arg1))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@FileStream6_Foreach(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with FileStream6_Foreach(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[FileStream]) Some((classTag(m), collection.immutable.List(("_path",manifest[String]))))
    else super.unapplyStructType(m)
  }
}

/**
 * Code generators
 */

trait ScalaGenFileStreamOps extends ScalaGenFat {
  val IR: FileStreamOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Open_reader(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("new java.io.BufferedReader(new java.io.FileReader("+quote(__arg0)+"))")
      stream.println("}")

    case mn@Close_reader(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".close()")
      stream.println("}")

    case mn@Read_line(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".readLine()")
      stream.println("}")

    case mn@Open_writer(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("new java.io.BufferedWriter(new java.io.FileWriter("+quote(__arg0)+"))")
      stream.println("}")

    case mn@Close_writer(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".close()")
      stream.println("}")

    case mn@Write_line(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".write("+quote(__arg1)+", 0, "+quote(__arg1)+".length)\n"+quote(__arg0)+".newLine()")
      stream.println("}")

    case _ => super.emitNode(sym, rhs)
  }
}
