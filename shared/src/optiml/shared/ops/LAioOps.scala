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

trait LAioOps extends Base {
  this: OptiML => 

  def readVector(path: Rep[String])(implicit __pos: SourceContext,__imp1: Overload1) = laio_readvector(path)(__pos,overload1)
  def readMatrix(path: Rep[String])(implicit __pos: SourceContext,__imp1: Overload1) = laio_readmatrix(path)(__pos,overload1)
  def readMatrix(path: Rep[String],delim: Rep[String])(implicit __pos: SourceContext,__imp1: Overload2) = laio_readmatrix(path,delim)(__pos,overload2)
  def readVector[Elem:Manifest](path: Rep[String],schemaBldr: (Rep[DenseVector[String]]) => Rep[Elem],delim: Rep[String] = unit("\\s+"))(implicit __pos: SourceContext,__imp1: Overload2) = laio_readvector[Elem](path,schemaBldr,delim)(implicitly[Manifest[Elem]],__pos,overload2)
  def readMatrix[Elem:Manifest](path: Rep[String],schemaBldr: (Rep[String]) => Rep[Elem],delim: Rep[String] = unit("\\s+"))(implicit __pos: SourceContext,__imp1: Overload3) = laio_readmatrix[Elem](path,schemaBldr,delim)(implicitly[Manifest[Elem]],__pos,overload3)
  def writeVector[Elem:Stringable:Manifest](v: Rep[DenseVector[Elem]],path: Rep[String])(implicit __pos: SourceContext) = laio_writevector[Elem](v,path)(implicitly[Stringable[Elem]],implicitly[Manifest[Elem]],__pos)
  def writeMatrix[Elem:Stringable:Manifest](m: Rep[DenseMatrix[Elem]],path: Rep[String],delim: Rep[String] = unit("    "))(implicit __pos: SourceContext) = laio_writematrix[Elem](m,path,delim)(implicitly[Stringable[Elem]],implicitly[Manifest[Elem]],__pos)
  def deleteFile(__arg0: Rep[String])(implicit __pos: SourceContext) = laio_deletefile(__arg0)(__pos)


  def laio_readvector(path: Rep[String])(implicit __pos: SourceContext,__imp1: Overload1): Rep[DenseVector[Double]]
  def laio_readmatrix(path: Rep[String])(implicit __pos: SourceContext,__imp1: Overload1): Rep[DenseMatrix[Double]]
  def laio_readmatrix(path: Rep[String],delim: Rep[String])(implicit __pos: SourceContext,__imp1: Overload2): Rep[DenseMatrix[Double]]
  def laio_readvector[Elem:Manifest](path: Rep[String],schemaBldr: (Rep[DenseVector[String]]) => Rep[Elem],delim: Rep[String] = unit("\\s+"))(implicit __pos: SourceContext,__imp1: Overload2): Rep[DenseVector[Elem]]
  def laio_readmatrix[Elem:Manifest](path: Rep[String],schemaBldr: (Rep[String]) => Rep[Elem],delim: Rep[String] = unit("\\s+"))(implicit __pos: SourceContext,__imp1: Overload3): Rep[DenseMatrix[Elem]]
  def laio_writevector[Elem:Stringable:Manifest](v: Rep[DenseVector[Elem]],path: Rep[String])(implicit __pos: SourceContext): Rep[Unit]
  def laio_writematrix[Elem:Stringable:Manifest](m: Rep[DenseMatrix[Elem]],path: Rep[String],delim: Rep[String] = unit("    "))(implicit __pos: SourceContext): Rep[Unit]
  def laio_deletefile(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[Unit]
}
trait LAioCompilerOps extends LAioOps {
  this: OptiML => 

  def optila_todouble(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[Double]
  def readFirstLine(path: Rep[String])(implicit __pos: SourceContext): Rep[String]
  def write_vector_helper(path: Rep[String],data: Rep[ForgeArray[String]],length: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def write_matrix_helper(path: Rep[String],data: Rep[ForgeArray[String]],numRows: Rep[Int],numCols: Rep[Int],delim: Rep[String])(implicit __pos: SourceContext): Rep[Unit]
}

