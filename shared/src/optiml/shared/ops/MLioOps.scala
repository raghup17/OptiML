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

trait MLioOps extends Base {
  this: OptiML => 

  def readFactorGraph(factorsPath: Rep[String],variablesPath: Rep[String],weightsPath: Rep[String],edgesPath: Rep[String],delim: Rep[String] = unit("\\t"))(implicit __pos: SourceContext) = mlio_readfactorgraph(factorsPath,variablesPath,weightsPath,edgesPath,delim)(__pos)
  def readARFF[Row:Manifest](path: Rep[String],schemaBldr: (Rep[DenseVector[String]]) => Rep[Row])(implicit __pos: SourceContext) = mlio_readarff[Row](path,schemaBldr)(implicitly[Manifest[Row]],__pos)

  def infix_available(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext) = mlio_available(__arg0)(__pos)
  def infix_fclose(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext) = mlio_fclose(__arg0)(__pos)
  def infix_readShort(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext) = mlio_readshort(__arg0)(__pos)
  def infix_readInt(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext) = mlio_readint(__arg0)(__pos)
  def infix_readLong(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext) = mlio_readlong(__arg0)(__pos)
  def infix_readDouble(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext) = mlio_readdouble(__arg0)(__pos)
  def infix_readBoolean(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext) = mlio_readboolean(__arg0)(__pos)

  def mlio_available(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext): Rep[Int]
  def mlio_fclose(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext): Rep[Unit]
  def mlio_readshort(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext): Rep[Short]
  def mlio_readint(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext): Rep[Int]
  def mlio_readlong(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext): Rep[Long]
  def mlio_readdouble(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext): Rep[Double]
  def mlio_readboolean(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext): Rep[Boolean]
  def mlio_readfactorgraph(factorsPath: Rep[String],variablesPath: Rep[String],weightsPath: Rep[String],edgesPath: Rep[String],delim: Rep[String] = unit("\\t"))(implicit __pos: SourceContext): Rep[FactorGraph[FunctionFactor]]
  def mlio_readarff[Row:Manifest](path: Rep[String],schemaBldr: (Rep[DenseVector[String]]) => Rep[Row])(implicit __pos: SourceContext): Rep[DenseVector[Row]]
}
trait MLioCompilerOps extends MLioOps {
  this: OptiML => 

  def datainputstream_new(path: Rep[String])(implicit __pos: SourceContext): Rep[java.io.DataInputStream]
  def fg_read_weights(path: Rep[String])(implicit __pos: SourceContext): Rep[DenseVector[Weight]]
  def fg_read_variables(path: Rep[String])(implicit __pos: SourceContext): Rep[DenseVector[RandomVariable]]
  def fg_read_edges(path: Rep[String])(implicit __pos: SourceContext): Rep[DenseVector[Tup4[Int,Int,Boolean,Int]]]
  def fg_read_factors(path: Rep[String])(implicit __pos: SourceContext): Rep[DenseVector[Tup3[Int,Int,Int]]]
  def build_variable_factors(variables: Rep[DenseVector[RandomVariable]],factors: Rep[DenseVector[FunctionFactor]])(implicit __pos: SourceContext): Rep[DenseVector[DenseVector[Int]]]
}

