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

trait LAioWrapper {
  this: OptiMLBase with OptiMLClasses => 

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
    laio_readmatrix_impl3[Elem](path,schemaBldr,delim)(implicitly[Manifest[Elem]],__pos)
  }
  def readFirstLine(path: Rep[String])(implicit __pos: SourceContext) = {
    val xfs = new java.io.BufferedReader(new java.io.FileReader(path))
    val line = xfs.readLine()
    xfs.close()
    line
  }
  def laio_writevector[Elem:Stringable:Manifest](v: Rep[DenseVector[Elem]],path: Rep[String])(implicit __pos: SourceContext) = {
    laio_writevector_impl[Elem](v,path)(implicitly[Stringable[Elem]],implicitly[Manifest[Elem]],__pos)
  }
  def write_vector_helper(path: Rep[String],data: Rep[ForgeArray[String]],length: Rep[Int])(implicit __pos: SourceContext) = {
    val xfs = new java.io.BufferedWriter(new java.io.FileWriter(path))
    for (i <- 0 until length) {
      xfs.write(data(i) + "\n")
    }
    xfs.close()
  }
  def laio_writematrix[Elem:Stringable:Manifest](m: Rep[DenseMatrix[Elem]],path: Rep[String],delim: Rep[String] = unit("    "))(implicit __pos: SourceContext) = {
    laio_writematrix_impl[Elem](m,path,delim)(implicitly[Stringable[Elem]],implicitly[Manifest[Elem]],__pos)
  }
  def write_matrix_helper(path: Rep[String],data: Rep[ForgeArray[String]],numRows: Rep[Int],numCols: Rep[Int],delim: Rep[String])(implicit __pos: SourceContext) = {
    val xfs = new java.io.BufferedWriter(new java.io.FileWriter(path))
    for (i <- 0 until numRows) {
      for (j <- 0 until numCols) {
        xfs.write(data(i*numCols+j) + delim)
      }
      xfs.write("\n")
    }
    xfs.close()
  }
  def laio_deletefile(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    val f = new java.io.File(__arg0)
    if (f.exists) f.delete()
    ()
  }

}

