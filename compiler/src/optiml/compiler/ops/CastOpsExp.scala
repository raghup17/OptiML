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

trait CastOpsExp extends CastOps with BaseFatExp with EffectExp {
  this: OptiMLExp => 

  case class Cast_AsInstanceOf[A:Manifest,B:Manifest](__arg0: Rep[A])(implicit val __pos: SourceContext) extends Def[B] {
    val _mA = implicitly[Manifest[A]]
    val _mB = implicitly[Manifest[B]]
  }

  case class Cast_IsInstanceOf[A:Manifest,B:Manifest](__arg0: Rep[A])(implicit val __pos: SourceContext) extends Def[Boolean] {
    val _mA = implicitly[Manifest[A]]
    val _mB = implicitly[Manifest[B]]
  }



  def cast_asinstanceof[A:Manifest,B:Manifest](__arg0: Rep[A])(implicit __pos: SourceContext) = {
    reflectPure(Cast_AsInstanceOf[A,B](__arg0)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos))
  }
  def cast_isinstanceof[A:Manifest,B:Manifest](__arg0: Rep[A])(implicit __pos: SourceContext) = {
    reflectPure(Cast_IsInstanceOf[A,B](__arg0)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos))
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Cast_AsInstanceOf(__arg0) => cast_asinstanceof(f(__arg0))(mtype(mn._mA),mtype(mn._mB),mn.__pos)
    case Reflect(mn@Cast_AsInstanceOf(__arg0), u, es) => reflectMirrored(Reflect(Cast_AsInstanceOf(f(__arg0))(mtype(mn._mA),mtype(mn._mB),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Cast_IsInstanceOf(__arg0) => cast_isinstanceof(f(__arg0))(mtype(mn._mA),mtype(mn._mB),mn.__pos)
    case Reflect(mn@Cast_IsInstanceOf(__arg0), u, es) => reflectMirrored(Reflect(Cast_IsInstanceOf(f(__arg0))(mtype(mn._mA),mtype(mn._mB),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


}

/**
 * Code generators
 */

trait ScalaGenCastOps extends ScalaGenFat {
  val IR: CastOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Cast_AsInstanceOf(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".asInstanceOf["+remap(mn._mB)+"]")
      stream.println("}")

    case mn@Cast_IsInstanceOf(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".isInstanceOf["+remap(mn._mB)+"]")
      stream.println("}")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CudaGenCastOps extends CudaGenFat {
  val IR: CastOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Cast_AsInstanceOf(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("("+remapWithRef(sym.tp)+")"+quote(__arg0)+"")
      stream.println(";")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CGenCastOps extends CGenFat {
  val IR: CastOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Cast_AsInstanceOf(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("("+remapWithRef(sym.tp)+")"+quote(__arg0)+"")
      stream.println(";")

    case _ => super.emitNode(sym, rhs)
  }
}
