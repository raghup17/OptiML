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

trait RandOpsExp extends RandCompilerOps with BaseFatExp with EffectExp {
  this: OptiMLExp => 

  case class Rand_RandomInt(__arg0: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Rand_RandomGaussian()(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class Rand_Reseed()(implicit val __pos: SourceContext) extends Def[Unit] {
  }

  case class Optila_rand_double()(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class Optila_rand_float()(implicit val __pos: SourceContext) extends Def[Float] {
  }

  case class Optila_rand_int()(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Optila_rand_boolean()(implicit val __pos: SourceContext) extends Def[Boolean] {
  }

  case class Optila_shuffle_array[A:Manifest](__arg0: Rep[ForgeArray[A]])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[ForgeArray[A]](reifyEffectsHere(optila_shuffle_array_impl[A](__arg0)(implicitly[Manifest[A]],__pos))) {
    val _mA = implicitly[Manifest[A]]
  }



  def rand_random[A:Manifest]()(implicit __pos: SourceContext) = {
    rand_random_impl[A]()(implicitly[Manifest[A]],__pos)
  }
  def rand_randomelem[A:Manifest](__arg0: Rep[DenseVector[A]])(implicit __pos: SourceContext) = {
    rand_randomelem_impl[A](__arg0)(implicitly[Manifest[A]],__pos)
  }
  def rand_randomint(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    reflectEffect(Rand_RandomInt(__arg0)(__pos))
  }
  def rand_randomgaussian()(implicit __pos: SourceContext) = {
    reflectEffect(Rand_RandomGaussian()(__pos))
  }
  def rand_reseed()(implicit __pos: SourceContext) = {
    reflectEffect(Rand_Reseed()(__pos))
  }
  def optila_rand_double()(implicit __pos: SourceContext) = {
    reflectEffect(Optila_rand_double()(__pos))
  }
  def optila_rand_float()(implicit __pos: SourceContext) = {
    reflectEffect(Optila_rand_float()(__pos))
  }
  def optila_rand_int()(implicit __pos: SourceContext) = {
    reflectEffect(Optila_rand_int()(__pos))
  }
  def optila_rand_boolean()(implicit __pos: SourceContext) = {
    reflectEffect(Optila_rand_boolean()(__pos))
  }
  def rand_shuffle(__arg0: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = {
    rand_shuffle_impl1(__arg0)(__pos)
  }
  def rand_shuffle[A:Manifest](__arg0: Rep[DenseVector[A]])(implicit __pos: SourceContext,__imp1: Overload2) = {
    rand_shuffle_impl2[A](__arg0)(implicitly[Manifest[A]],__pos)
  }
  def rand_shuffle[A:Manifest](__arg0: Rep[DenseMatrix[A]])(implicit __pos: SourceContext,__imp1: Overload3) = {
    rand_shuffle_impl3[A](__arg0)(implicitly[Manifest[A]],__pos)
  }
  def optila_shuffle_array[A:Manifest](__arg0: Rep[ForgeArray[A]])(implicit __pos: SourceContext) = {
    reflectEffect(Optila_shuffle_array[A](__arg0)(implicitly[Manifest[A]],__pos))
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Rand_RandomInt(__arg0) => rand_randomint(f(__arg0))(mn.__pos)
    case Reflect(mn@Rand_RandomInt(__arg0), u, es) => reflectMirrored(Reflect(Rand_RandomInt(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Rand_RandomGaussian() => rand_randomgaussian()(mn.__pos)
    case Reflect(mn@Rand_RandomGaussian(), u, es) => reflectMirrored(Reflect(Rand_RandomGaussian()(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Rand_Reseed() => rand_reseed()(mn.__pos)
    case Reflect(mn@Rand_Reseed(), u, es) => reflectMirrored(Reflect(Rand_Reseed()(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Optila_rand_double() => optila_rand_double()(mn.__pos)
    case Reflect(mn@Optila_rand_double(), u, es) => reflectMirrored(Reflect(Optila_rand_double()(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Optila_rand_float() => optila_rand_float()(mn.__pos)
    case Reflect(mn@Optila_rand_float(), u, es) => reflectMirrored(Reflect(Optila_rand_float()(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Optila_rand_int() => optila_rand_int()(mn.__pos)
    case Reflect(mn@Optila_rand_int(), u, es) => reflectMirrored(Reflect(Optila_rand_int()(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Optila_rand_boolean() => optila_rand_boolean()(mn.__pos)
    case Reflect(mn@Optila_rand_boolean(), u, es) => reflectMirrored(Reflect(Optila_rand_boolean()(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Optila_shuffle_array(__arg0) => reflectPure(new { override val original = Some(f,mn) } with Optila_shuffle_array(f(__arg0))(mtype(mn._mA),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Optila_shuffle_array(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Optila_shuffle_array(f(__arg0))(mtype(mn._mA),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


}

/**
 * Code generators
 */

trait ScalaGenRandOps extends ScalaGenFat {
  val IR: RandOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Rand_RandomInt(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("Global.randRef.nextInt("+quote(__arg0)+")")
      stream.println("}")

    case mn@Rand_RandomGaussian() => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("Global.randRef.nextGaussian()")
      stream.println("}")

    case mn@Rand_Reseed() => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("Global.randRef.setSeed(Global.INITIAL_SEED)")
      stream.println("}")

    case mn@Optila_rand_double() => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("Global.randRef.nextDouble()")
      stream.println("}")

    case mn@Optila_rand_float() => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("Global.randRef.nextFloat()")
      stream.println("}")

    case mn@Optila_rand_int() => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("Global.randRef.nextInt()")
      stream.println("}")

    case mn@Optila_rand_boolean() => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("Global.randRef.nextBoolean()")
      stream.println("}")

    case _ => super.emitNode(sym, rhs)
  }
}
