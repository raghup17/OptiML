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

trait MLioOpsExp extends MLioCompilerOps with BaseFatExp with EffectExp {
  this: OptiMLExp => 

  case class Datainputstream_new(path: Rep[String])(implicit val __pos: SourceContext) extends Def[java.io.DataInputStream] {
  }

  case class MLio_Available(__arg0: Rep[java.io.DataInputStream])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class MLio_Fclose(__arg0: Rep[java.io.DataInputStream])(implicit val __pos: SourceContext) extends Def[Unit] {
  }

  case class MLio_ReadShort(__arg0: Rep[java.io.DataInputStream])(implicit val __pos: SourceContext) extends Def[Short] {
  }

  case class MLio_ReadInt(__arg0: Rep[java.io.DataInputStream])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class MLio_ReadLong(__arg0: Rep[java.io.DataInputStream])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class MLio_ReadDouble(__arg0: Rep[java.io.DataInputStream])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class MLio_ReadBoolean(__arg0: Rep[java.io.DataInputStream])(implicit val __pos: SourceContext) extends Def[Boolean] {
  }

  case class Fg_read_weights(path: Rep[String])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[DenseVector[Weight]](reifyEffectsHere(fg_read_weights_impl(path)(__pos))) {
  }

  case class Fg_read_variables(path: Rep[String])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[DenseVector[RandomVariable]](reifyEffectsHere(fg_read_variables_impl(path)(__pos))) {
  }

  case class Fg_read_edges(path: Rep[String])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[DenseVector[Tup4[Int,Int,Boolean,Int]]](reifyEffectsHere(fg_read_edges_impl(path)(__pos))) {
  }

  case class Fg_read_factors(path: Rep[String])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[DenseVector[Tup3[Int,Int,Int]]](reifyEffectsHere(fg_read_factors_impl(path)(__pos))) {
  }



  def datainputstream_new(path: Rep[String])(implicit __pos: SourceContext) = {
    reflectEffect(Datainputstream_new(path)(__pos))
  }
  def mlio_available(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext) = {
    reflectEffect(MLio_Available(__arg0)(__pos))
  }
  def mlio_fclose(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext) = {
    reflectEffect(MLio_Fclose(__arg0)(__pos))
  }
  def mlio_readshort(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext) = {
    reflectEffect(MLio_ReadShort(__arg0)(__pos))
  }
  def mlio_readint(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext) = {
    reflectEffect(MLio_ReadInt(__arg0)(__pos))
  }
  def mlio_readlong(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext) = {
    reflectEffect(MLio_ReadLong(__arg0)(__pos))
  }
  def mlio_readdouble(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext) = {
    reflectEffect(MLio_ReadDouble(__arg0)(__pos))
  }
  def mlio_readboolean(__arg0: Rep[java.io.DataInputStream])(implicit __pos: SourceContext) = {
    reflectEffect(MLio_ReadBoolean(__arg0)(__pos))
  }
  def fg_read_weights(path: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(Fg_read_weights(path)(__pos))
  }
  def fg_read_variables(path: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(Fg_read_variables(path)(__pos))
  }
  def fg_read_edges(path: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(Fg_read_edges(path)(__pos))
  }
  def fg_read_factors(path: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(Fg_read_factors(path)(__pos))
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
    case mn@Datainputstream_new(__arg0) => datainputstream_new(f(__arg0))(mn.__pos)
    case Reflect(mn@Datainputstream_new(__arg0), u, es) => reflectMirrored(Reflect(Datainputstream_new(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MLio_Available(__arg0) => mlio_available(f(__arg0))(mn.__pos)
    case Reflect(mn@MLio_Available(__arg0), u, es) => reflectMirrored(Reflect(MLio_Available(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MLio_Fclose(__arg0) => mlio_fclose(f(__arg0))(mn.__pos)
    case Reflect(mn@MLio_Fclose(__arg0), u, es) => reflectMirrored(Reflect(MLio_Fclose(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MLio_ReadShort(__arg0) => mlio_readshort(f(__arg0))(mn.__pos)
    case Reflect(mn@MLio_ReadShort(__arg0), u, es) => reflectMirrored(Reflect(MLio_ReadShort(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MLio_ReadInt(__arg0) => mlio_readint(f(__arg0))(mn.__pos)
    case Reflect(mn@MLio_ReadInt(__arg0), u, es) => reflectMirrored(Reflect(MLio_ReadInt(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MLio_ReadLong(__arg0) => mlio_readlong(f(__arg0))(mn.__pos)
    case Reflect(mn@MLio_ReadLong(__arg0), u, es) => reflectMirrored(Reflect(MLio_ReadLong(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MLio_ReadDouble(__arg0) => mlio_readdouble(f(__arg0))(mn.__pos)
    case Reflect(mn@MLio_ReadDouble(__arg0), u, es) => reflectMirrored(Reflect(MLio_ReadDouble(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@MLio_ReadBoolean(__arg0) => mlio_readboolean(f(__arg0))(mn.__pos)
    case Reflect(mn@MLio_ReadBoolean(__arg0), u, es) => reflectMirrored(Reflect(MLio_ReadBoolean(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Fg_read_weights(__arg0) => reflectPure(new { override val original = Some(f,mn) } with Fg_read_weights(f(__arg0))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Fg_read_weights(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Fg_read_weights(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Fg_read_variables(__arg0) => reflectPure(new { override val original = Some(f,mn) } with Fg_read_variables(f(__arg0))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Fg_read_variables(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Fg_read_variables(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Fg_read_edges(__arg0) => reflectPure(new { override val original = Some(f,mn) } with Fg_read_edges(f(__arg0))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Fg_read_edges(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Fg_read_edges(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Fg_read_factors(__arg0) => reflectPure(new { override val original = Some(f,mn) } with Fg_read_factors(f(__arg0))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Fg_read_factors(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Fg_read_factors(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


}

/**
 * Code generators
 */

trait ScalaGenMLioOps extends ScalaGenFat {
  val IR: MLioOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Datainputstream_new(path) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("new java.io.DataInputStream(new java.io.FileInputStream("+quote(path)+"))")
      stream.println("}")

    case mn@MLio_Available(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".available()")
      stream.println("}")

    case mn@MLio_Fclose(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".close()")
      stream.println("}")

    case mn@MLio_ReadShort(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".readShort()")
      stream.println("}")

    case mn@MLio_ReadInt(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".readInt()")
      stream.println("}")

    case mn@MLio_ReadLong(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".readLong()")
      stream.println("}")

    case mn@MLio_ReadDouble(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".readDouble()")
      stream.println("}")

    case mn@MLio_ReadBoolean(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".readBoolean()")
      stream.println("}")

    case _ => super.emitNode(sym, rhs)
  }
}
