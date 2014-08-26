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

trait LAioWrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def optila_todouble_impl(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[Double] = {
    if (__arg0 == "Inf") INF
    else if (__arg0 == "-Inf") nINF
    else __arg0.toDouble
  }

  def laio_readvector_impl1(path: Rep[String])(implicit __pos: SourceContext): Rep[DenseVector[Double]] = {
    readVector[Double](path, v => optila_todouble(v(0)))
  }

  def laio_readmatrix_impl1(path: Rep[String])(implicit __pos: SourceContext): Rep[DenseMatrix[Double]] = {
    readMatrix[Double](path, s => optila_todouble(s))
  }

  def laio_readmatrix_impl2(path: Rep[String],delim: Rep[String])(implicit __pos: SourceContext): Rep[DenseMatrix[Double]] = {
    readMatrix[Double](path, s => optila_todouble(s), delim)
  }

  def laio_readvector_impl2[Elem:Manifest](path: Rep[String],schemaBldr: (Rep[DenseVector[String]]) => Rep[Elem],delim: Rep[String] = unit("\\s+"))(implicit __pos: SourceContext): Rep[DenseVector[Elem]] = {
    val a = ForgeFileReader.readLines(path){ line =>
      val tokens = line.trim.fsplit(delim)
      val tokenVector = (0::array_length(tokens)) { i => tokens(i) }
      schemaBldr(tokenVector)
    }
    densevector_fromarray(a, true)
  }

  def laio_readmatrix_impl3[Elem:Manifest](path: Rep[String],schemaBldr: (Rep[String]) => Rep[Elem],delim: Rep[String] = unit("\\s+"))(implicit __pos: SourceContext): Rep[DenseMatrix[Elem]] = {
    val a = ForgeFileReader.readLinesFlattened(path){ line:Rep[String] =>
      val tokens = line.trim.fsplit(delim)
      array_fromfunction(array_length(tokens), i => schemaBldr(tokens(i)))
    }
    val numCols = array_length(readFirstLine(path).trim.fsplit(delim))
    densematrix_fromarray(a, array_length(a) / numCols, numCols).unsafeImmutable
  }

  def laio_writevector_impl[Elem:Stringable:Manifest](v: Rep[DenseVector[Elem]],path: Rep[String])(implicit __pos: SourceContext): Rep[Unit] = {
    write_vector_helper(path, densevector_raw_data(v.map(_.makeStr)), v.length)
  }

  def laio_writematrix_impl[Elem:Stringable:Manifest](m: Rep[DenseMatrix[Elem]],path: Rep[String],delim: Rep[String] = unit("    "))(implicit __pos: SourceContext): Rep[Unit] = {
    write_matrix_helper(path, densematrix_raw_data(m.map(_.makeStr)), m.numRows, m.numCols, delim)
  }

}
