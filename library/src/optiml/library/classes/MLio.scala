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

trait MLioWrapper {
  this: OptiMLBase with OptiMLClasses => 

  def datainputstream_new(path: Rep[String])(implicit __pos: SourceContext) = {
    new java.io.DataInputStream(new java.io.FileInputStream(path))
  }
  def mlio_available(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext) = {
    __arg0.available()
  }
  def mlio_fclose(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext) = {
    __arg0.close()
  }
  def mlio_readshort(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext) = {
    __arg0.readShort()
  }
  def mlio_readint(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext) = {
    __arg0.readInt()
  }
  def mlio_readlong(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext) = {
    __arg0.readLong()
  }
  def mlio_readdouble(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext) = {
    __arg0.readDouble()
  }
  def mlio_readboolean(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext) = {
    __arg0.readBoolean()
  }
  def fg_read_weights(path: Rep[String])(implicit __pos: SourceContext) = {
    fg_read_weights_impl(path)(__pos)
  }
  def fg_read_variables(path: Rep[String])(implicit __pos: SourceContext) = {
    fg_read_variables_impl(path)(__pos)
  }
  def fg_read_edges(path: Rep[String])(implicit __pos: SourceContext) = {
    fg_read_edges_impl(path)(__pos)
  }
  def fg_read_factors(path: Rep[String])(implicit __pos: SourceContext) = {
    fg_read_factors_impl(path)(__pos)
  }
  def mlio_readfactorgraph(factorsPath: Rep[String],variablesPath: Rep[String],weightsPath: Rep[String],edgesPath: Rep[String],delim: Rep[String] = unit("\\t"))(implicit __pos: SourceContext) = {
    mlio_readfactorgraph_impl(factorsPath,variablesPath,weightsPath,edgesPath,delim)(__pos)
  }
  def build_variable_factors(variables: Rep[DenseVector[RandomVariable]],factors: Rep[DenseVector[FunctionFactor]])(implicit __pos: SourceContext) = {
    build_variable_factors_impl(variables,factors)(__pos)
  }
  def mlio_readarff[Row:Manifest](path: Rep[String],schemaBldr: (Rep[DenseVector[String]]) => Rep[Row])(implicit __pos: SourceContext) = {
    mlio_readarff_impl[Row](path,schemaBldr)(implicitly[Manifest[Row]],__pos)
  }

}

