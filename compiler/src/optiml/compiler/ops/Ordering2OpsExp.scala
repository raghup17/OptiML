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

trait Ordering2OpsExp extends Ordering2Ops with BaseFatExp with EffectExp {
  this: OptiMLExp => 

  case class Ordering218___equal[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit val __pos: SourceContext) extends Def[Boolean] {
    val _mA = implicitly[Manifest[A]]
    val _mB = implicitly[Manifest[B]]
  }

  case class Ordering21_Bangeq[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit val __pos: SourceContext) extends Def[Boolean] {
    val _mA = implicitly[Manifest[A]]
    val _mB = implicitly[Manifest[B]]
  }

  case class Ordering28_Min[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit val __pos: SourceContext) extends Def[A] {
    val _ordA = implicitly[Ordering[A]]
    val _mA = implicitly[Manifest[A]]
  }

  case class Ordering28_Max[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit val __pos: SourceContext) extends Def[A] {
    val _ordA = implicitly[Ordering[A]]
    val _mA = implicitly[Manifest[A]]
  }

  case class Ordering2_Lt[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit val __pos: SourceContext) extends Def[Boolean] {
    val _ordA = implicitly[Ordering[A]]
    val _mA = implicitly[Manifest[A]]
  }

  case class Ordering2_Lteq[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit val __pos: SourceContext) extends Def[Boolean] {
    val _ordA = implicitly[Ordering[A]]
    val _mA = implicitly[Manifest[A]]
  }

  case class Ordering2_Gt[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit val __pos: SourceContext) extends Def[Boolean] {
    val _ordA = implicitly[Ordering[A]]
    val _mA = implicitly[Manifest[A]]
  }

  case class Ordering2_Gteq[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit val __pos: SourceContext) extends Def[Boolean] {
    val _ordA = implicitly[Ordering[A]]
    val _mA = implicitly[Manifest[A]]
  }



  def ordering2___equal[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext,__imp1: Overload18) = {
    reflectPure(Ordering218___equal[A,B](__arg0,__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos))
  }
  def ordering2_bangeq[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext,__imp1: Overload1) = {
    reflectPure(Ordering21_Bangeq[A,B](__arg0,__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos))
  }
  def ordering2_min[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    reflectPure(Ordering28_Min[A](__arg0,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos))
  }
  def ordering2_max[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    reflectPure(Ordering28_Max[A](__arg0,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos))
  }
  def ordering2_lt[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    reflectPure(Ordering2_Lt[A](__arg0,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos))
  }
  def ordering2_lteq[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    reflectPure(Ordering2_Lteq[A](__arg0,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos))
  }
  def ordering2_gt[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    reflectPure(Ordering2_Gt[A](__arg0,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos))
  }
  def ordering2_gteq[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    reflectPure(Ordering2_Gteq[A](__arg0,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos))
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Ordering218___equal(__arg0,__arg1) => ordering2___equal(f(__arg0),f(__arg1))(mtype(mn._mA),mtype(mn._mB),mn.__pos,overload18)
    case Reflect(mn@Ordering218___equal(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Ordering218___equal(f(__arg0),f(__arg1))(mtype(mn._mA),mtype(mn._mB),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Ordering21_Bangeq(__arg0,__arg1) => ordering2_bangeq(f(__arg0),f(__arg1))(mtype(mn._mA),mtype(mn._mB),mn.__pos,overload1)
    case Reflect(mn@Ordering21_Bangeq(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Ordering21_Bangeq(f(__arg0),f(__arg1))(mtype(mn._mA),mtype(mn._mB),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Ordering28_Min(__arg0,__arg1) => ordering2_min(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos)
    case Reflect(mn@Ordering28_Min(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Ordering28_Min(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Ordering28_Max(__arg0,__arg1) => ordering2_max(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos)
    case Reflect(mn@Ordering28_Max(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Ordering28_Max(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Ordering2_Lt(__arg0,__arg1) => ordering2_lt(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos)
    case Reflect(mn@Ordering2_Lt(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Ordering2_Lt(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Ordering2_Lteq(__arg0,__arg1) => ordering2_lteq(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos)
    case Reflect(mn@Ordering2_Lteq(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Ordering2_Lteq(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Ordering2_Gt(__arg0,__arg1) => ordering2_gt(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos)
    case Reflect(mn@Ordering2_Gt(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Ordering2_Gt(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Ordering2_Gteq(__arg0,__arg1) => ordering2_gteq(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos)
    case Reflect(mn@Ordering2_Gteq(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Ordering2_Gteq(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


}

/**
 * Code generators
 */

trait ScalaGenOrdering2Ops extends ScalaGenFat {
  val IR: Ordering2OpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Ordering218___equal(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" == "+quote(__arg1)+"")
      stream.println("}")

    case mn@Ordering21_Bangeq(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" != "+quote(__arg1)+"")
      stream.println("}")

    case mn@Ordering28_Min(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" min "+quote(__arg1)+"")
      stream.println("}")

    case mn@Ordering28_Max(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" max "+quote(__arg1)+"")
      stream.println("}")

    case mn@Ordering2_Lt(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" < "+quote(__arg1)+"")
      stream.println("}")

    case mn@Ordering2_Lteq(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" <= "+quote(__arg1)+"")
      stream.println("}")

    case mn@Ordering2_Gt(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" > "+quote(__arg1)+"")
      stream.println("}")

    case mn@Ordering2_Gteq(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" >= "+quote(__arg1)+"")
      stream.println("}")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CudaGenOrdering2Ops extends CudaGenFat {
  val IR: Ordering2OpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Ordering218___equal(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" == "+quote(__arg1)+"")
      stream.println(";")

    case mn@Ordering21_Bangeq(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" != "+quote(__arg1)+"")
      stream.println(";")

    case mn@Ordering2_Lt(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" < "+quote(__arg1)+"")
      stream.println(";")

    case mn@Ordering2_Lteq(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" <= "+quote(__arg1)+"")
      stream.println(";")

    case mn@Ordering2_Gt(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" > "+quote(__arg1)+"")
      stream.println(";")

    case mn@Ordering2_Gteq(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" >= "+quote(__arg1)+"")
      stream.println(";")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CGenOrdering2Ops extends CGenFat {
  val IR: Ordering2OpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Ordering218___equal(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" == "+quote(__arg1)+"")
      stream.println(";")

    case mn@Ordering21_Bangeq(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" != "+quote(__arg1)+"")
      stream.println(";")

    case mn@Ordering2_Lt(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" < "+quote(__arg1)+"")
      stream.println(";")

    case mn@Ordering2_Lteq(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" <= "+quote(__arg1)+"")
      stream.println(";")

    case mn@Ordering2_Gt(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" > "+quote(__arg1)+"")
      stream.println(";")

    case mn@Ordering2_Gteq(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" >= "+quote(__arg1)+"")
      stream.println(";")

    case _ => super.emitNode(sym, rhs)
  }
}
