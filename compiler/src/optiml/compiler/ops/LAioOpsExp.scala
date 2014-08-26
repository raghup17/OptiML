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

trait LAioOpsExp extends LAioCompilerOps with BaseFatExp with EffectExp {
  this: OptiMLExp => 

  case class LAio3_ReadMatrix[Elem:Manifest](path: Rep[String],schemaBldr: (Rep[String]) => Rep[Elem],delim: Rep[String] = unit("\\s+"))(implicit val __pos: SourceContext) extends DeliteOpSingleTask[DenseMatrix[Elem]](reifyEffectsHere(laio_readmatrix_impl3[Elem](path,schemaBldr,delim)(implicitly[Manifest[Elem]],__pos))) {
    val _mElem = implicitly[Manifest[Elem]]
  }

  case class ReadFirstLine(path: Rep[String])(implicit val __pos: SourceContext) extends Def[String] {
  }

  case class Write_vector_helper(path: Rep[String],data: Rep[ForgeArray[String]],length: Rep[Int])(implicit val __pos: SourceContext) extends Def[Unit] {
  }

  case class Write_matrix_helper(path: Rep[String],data: Rep[ForgeArray[String]],numRows: Rep[Int],numCols: Rep[Int],delim: Rep[String])(implicit val __pos: SourceContext) extends Def[Unit] {
  }

  case class LAio_DeleteFile(__arg0: Rep[String])(implicit val __pos: SourceContext) extends Def[Unit] {
  }



  def optila_todouble(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    optila_todouble_impl(__arg0)(__pos)
  }
  def laio_readvector(path: Rep[String])(implicit __pos: SourceContext,__imp1: Overload1) = {
    laio_readvector_impl1(path)(__pos)
  }
  def laio_readmatrix(path: Rep[String])(implicit __pos: SourceContext,__imp1: Overload1) = {
    laio_readmatrix_impl1(path)(__pos)
  }
  def laio_readmatrix(path: Rep[String],delim: Rep[String])(implicit __pos: SourceContext,__imp1: Overload2) = {
    laio_readmatrix_impl2(path,delim)(__pos)
  }
  def laio_readvector[Elem:Manifest](path: Rep[String],schemaBldr: (Rep[DenseVector[String]]) => Rep[Elem],delim: Rep[String] = unit("\\s+"))(implicit __pos: SourceContext,__imp1: Overload2) = {
    laio_readvector_impl2[Elem](path,schemaBldr,delim)(implicitly[Manifest[Elem]],__pos)
  }
  def laio_readmatrix[Elem:Manifest](path: Rep[String],schemaBldr: (Rep[String]) => Rep[Elem],delim: Rep[String] = unit("\\s+"))(implicit __pos: SourceContext,__imp1: Overload3) = {
    reflectEffect(LAio3_ReadMatrix[Elem](path,schemaBldr,delim)(implicitly[Manifest[Elem]],__pos))
  }
  def readFirstLine(path: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(ReadFirstLine(path)(__pos))
  }
  def laio_writevector[Elem:Stringable:Manifest](v: Rep[DenseVector[Elem]],path: Rep[String])(implicit __pos: SourceContext) = {
    laio_writevector_impl[Elem](v,path)(implicitly[Stringable[Elem]],implicitly[Manifest[Elem]],__pos)
  }
  def write_vector_helper(path: Rep[String],data: Rep[ForgeArray[String]],length: Rep[Int])(implicit __pos: SourceContext) = {
    reflectEffect(Write_vector_helper(path,data,length)(__pos))
  }
  def laio_writematrix[Elem:Stringable:Manifest](m: Rep[DenseMatrix[Elem]],path: Rep[String],delim: Rep[String] = unit("    "))(implicit __pos: SourceContext) = {
    laio_writematrix_impl[Elem](m,path,delim)(implicitly[Stringable[Elem]],implicitly[Manifest[Elem]],__pos)
  }
  def write_matrix_helper(path: Rep[String],data: Rep[ForgeArray[String]],numRows: Rep[Int],numCols: Rep[Int],delim: Rep[String])(implicit __pos: SourceContext) = {
    reflectEffect(Write_matrix_helper(path,data,numRows,numCols,delim)(__pos))
  }
  def laio_deletefile(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    reflectEffect(LAio_DeleteFile(__arg0)(__pos))
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
    case mn@LAio3_ReadMatrix(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with LAio3_ReadMatrix(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mElem),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@LAio3_ReadMatrix(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with LAio3_ReadMatrix(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mElem),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@ReadFirstLine(__arg0) => readFirstLine(f(__arg0))(mn.__pos)
    case Reflect(mn@ReadFirstLine(__arg0), u, es) => reflectMirrored(Reflect(ReadFirstLine(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Write_vector_helper(__arg0,__arg1,__arg2) => write_vector_helper(f(__arg0),f(__arg1),f(__arg2))(mn.__pos)
    case Reflect(mn@Write_vector_helper(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(Write_vector_helper(f(__arg0),f(__arg1),f(__arg2))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Write_matrix_helper(__arg0,__arg1,__arg2,__arg3,__arg4) => write_matrix_helper(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4))(mn.__pos)
    case Reflect(mn@Write_matrix_helper(__arg0,__arg1,__arg2,__arg3,__arg4), u, es) => reflectMirrored(Reflect(Write_matrix_helper(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@LAio_DeleteFile(__arg0) => laio_deletefile(f(__arg0))(mn.__pos)
    case Reflect(mn@LAio_DeleteFile(__arg0), u, es) => reflectMirrored(Reflect(LAio_DeleteFile(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


}

/**
 * Code generators
 */

trait ScalaGenLAioOps extends ScalaGenFat {
  val IR: LAioOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@ReadFirstLine(path) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("val xfs = new java.io.BufferedReader(new java.io.FileReader("+quote(path)+"))\nval line = xfs.readLine()\nxfs.close()\nline")
      stream.println("}")

    case mn@Write_vector_helper(path,data,length) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("val xfs = new java.io.BufferedWriter(new java.io.FileWriter("+quote(path)+"))\nfor (i <- 0 until "+quote(length)+") {\n  xfs.write("+quote(data)+"(i) + \"\\n\")\n}\nxfs.close()")
      stream.println("}")

    case mn@Write_matrix_helper(path,data,numRows,numCols,delim) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("val xfs = new java.io.BufferedWriter(new java.io.FileWriter("+quote(path)+"))\nfor (i <- 0 until "+quote(numRows)+") {\n  for (j <- 0 until "+quote(numCols)+") {\n    xfs.write("+quote(data)+"(i*"+quote(numCols)+"+j) + "+quote(delim)+")\n  }\n  xfs.write(\"\\n\")\n}\nxfs.close()")
      stream.println("}")

    case mn@LAio_DeleteFile(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("val f = new java.io.File("+quote(__arg0)+")\nif (f.exists) f.delete()\n()")
      stream.println("}")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CGenLAioOps extends CGenFat {
  val IR: LAioOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@ReadFirstLine(path) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("readFirstLineFile("+quote(path)+")")
      stream.println(";")

    case _ => super.emitNode(sym, rhs)
  }
}
