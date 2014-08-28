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

trait MiscOpsExp extends MiscOps with BaseFatExp with EffectExp {
  this: OptiMLExp => 

  case class Misc_Exit(__arg0: Rep[Int])(implicit val __pos: SourceContext) extends Def[Unit] {
  }

  case class Misc_Print(__arg0: Rep[Any])(implicit val __pos: SourceContext) extends Def[Unit] {
  }

  case class Misc_Fatal(__arg0: Rep[String])(implicit val __pos: SourceContext) extends Def[Nothing] {
  }

  case class Misc1_Println(__arg0: Rep[Any])(implicit val __pos: SourceContext) extends Def[Unit] {
  }

  case class Misc2_Println()(implicit val __pos: SourceContext) extends Def[Unit] {
  }

  case class Misc___whileDo(__arg0: Block[Boolean],__arg1: Block[Unit])(implicit val __pos: SourceContext) extends Def[Unit] {
  }

  case class Misc___ifThenElse[T:Manifest](__arg0: Block[Boolean],__arg1: Block[T],__arg2: Block[T])(implicit val __pos: SourceContext) extends Def[T] {
    val _mT = implicitly[Manifest[T]]
  }

  case class Misc_UnsafeImmutable[T:Manifest](__arg0: Rep[T])(implicit val __pos: SourceContext) extends Def[T] {
    val _mT = implicitly[Manifest[T]]
  }

  case class Misc_UnsafeMutable[T:Manifest](__arg0: Rep[T])(implicit val __pos: SourceContext) extends Def[T] {
    val _mT = implicitly[Manifest[T]]
  }



  def misc_exit(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    reflectEffect(Misc_Exit(__arg0)(__pos))
  }
  def misc_print(__arg0: Rep[Any])(implicit __pos: SourceContext) = {
    reflectEffect(Misc_Print(__arg0)(__pos))
  }
  def misc_fatal(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    reflectEffect(Misc_Fatal(__arg0)(__pos))
  }
  def misc_println(__arg0: Rep[Any])(implicit __pos: SourceContext,__imp1: Overload1) = {
    reflectEffect(Misc1_Println(__arg0)(__pos))
  }
  def misc_println()(implicit __pos: SourceContext,__imp1: Overload2) = {
    reflectEffect(Misc2_Println()(__pos))
  }
  def misc___whiledo(__arg0:  => Rep[Boolean],__arg1:  => Rep[Unit])(implicit __pos: SourceContext) = {

    val b___arg0 = reifyEffects(__arg0)
    val sb___arg0 = summarizeEffects(b___arg0)

    val b___arg1 = reifyEffects(__arg1)
    val sb___arg1 = summarizeEffects(b___arg1)
    reflectEffect(Misc___whileDo(b___arg0,b___arg1)(__pos), sb___arg0 andThen ((sb___arg1 andThen sb___arg0).star))
  }
  def misc___ifthenelse[T:Manifest](__arg0:  => Rep[Boolean],__arg1:  => Rep[T],__arg2:  => Rep[T])(implicit __pos: SourceContext) = {

    val b___arg0 = reifyEffects(__arg0)
    val sb___arg0 = summarizeEffects(b___arg0)

    val b___arg1 = reifyEffects(__arg1)
    val sb___arg1 = summarizeEffects(b___arg1)

    val b___arg2 = reifyEffects(__arg2)
    val sb___arg2 = summarizeEffects(b___arg2)
    reflectEffect(Misc___ifThenElse[T](b___arg0,b___arg1,b___arg2)(implicitly[Manifest[T]],__pos), sb___arg0 andThen ((sb___arg1 andThen ((sb___arg2 andThen sb___arg1).star) andThen sb___arg0).star))
  }
  def misc_unsafeimmutable[T:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = {
    reflectPure(Misc_UnsafeImmutable[T](__arg0)(implicitly[Manifest[T]],__pos))
  }
  def misc_unsafemutable[T:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = {
    reflectPure(Misc_UnsafeMutable[T](__arg0)(implicitly[Manifest[T]],__pos))
  }

  /**
   * Syms
   */
  override def syms(e: Any): List[Sym[Any]] = e match {
    case Misc___whileDo(__arg0,__arg1) => syms(__arg0):::syms(__arg1)
    case Misc___ifThenElse(__arg0,__arg1,__arg2) => syms(__arg0):::syms(__arg1):::syms(__arg2)
    case _ => super.syms(e)
  }
  override def boundSyms(e: Any): List[Sym[Any]] = e match {
    case Misc___whileDo(__arg0,__arg1) => effectSyms(__arg0):::effectSyms(__arg1) ::: List()
    case Misc___ifThenElse(__arg0,__arg1,__arg2) => effectSyms(__arg0):::effectSyms(__arg1):::effectSyms(__arg2) ::: List()
    case _ => super.boundSyms(e)
  }
  override def symsFreq(e: Any): List[(Sym[Any], Double)] = e match {
    case Misc___whileDo(__arg0,__arg1) => freqNormal(__arg0):::freqNormal(__arg1)
    case Misc___ifThenElse(__arg0,__arg1,__arg2) => freqNormal(__arg0):::freqCold(__arg1):::freqCold(__arg2)
    case _ => super.symsFreq(e)
  }

  /**
   * Aliases / Sharing
   */
  override def aliasSyms(e: Any): List[Sym[Any]] = e match {
    case Misc_UnsafeImmutable(__arg0) => Nil
    case _ => super.aliasSyms(e)
  }
  override def containSyms(e: Any): List[Sym[Any]] = e match {
    case Misc_UnsafeImmutable(__arg0) => Nil
    case _ => super.containSyms(e)
  }
  override def extractSyms(e: Any): List[Sym[Any]] = e match {
    case Misc_UnsafeImmutable(__arg0) => Nil
    case _ => super.extractSyms(e)
  }
  override def copySyms(e: Any): List[Sym[Any]] = e match {
    case Misc_UnsafeImmutable(__arg0) => syms(__arg0)
    case _ => super.copySyms(e)
  }

  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Misc_Exit(__arg0) => misc_exit(f(__arg0))(mn.__pos)
    case Reflect(mn@Misc_Exit(__arg0), u, es) => reflectMirrored(Reflect(Misc_Exit(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Misc_Print(__arg0) => misc_print(f(__arg0))(mn.__pos)
    case Reflect(mn@Misc_Print(__arg0), u, es) => reflectMirrored(Reflect(Misc_Print(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Misc_Fatal(__arg0) => misc_fatal(f(__arg0))(mn.__pos)
    case Reflect(mn@Misc_Fatal(__arg0), u, es) => reflectMirrored(Reflect(Misc_Fatal(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Misc1_Println(__arg0) => misc_println(f(__arg0))(mn.__pos,overload1)
    case Reflect(mn@Misc1_Println(__arg0), u, es) => reflectMirrored(Reflect(Misc1_Println(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Misc2_Println() => misc_println()(mn.__pos,overload2)
    case Reflect(mn@Misc2_Println(), u, es) => reflectMirrored(Reflect(Misc2_Println()(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Misc___whileDo(__arg0,__arg1) => reflectPure(Misc___whileDo(f(__arg0),f(__arg1))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Misc___whileDo(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Misc___whileDo(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Misc___ifThenElse(__arg0,__arg1,__arg2) => reflectPure(Misc___ifThenElse(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Misc___ifThenElse(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(Misc___ifThenElse(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Misc_UnsafeImmutable(__arg0) => misc_unsafeimmutable(f(__arg0))(mtype(mn._mT),mn.__pos)
    case Reflect(mn@Misc_UnsafeImmutable(__arg0), u, es) => reflectMirrored(Reflect(Misc_UnsafeImmutable(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Misc_UnsafeMutable(__arg0) => misc_unsafemutable(f(__arg0))(mtype(mn._mT),mn.__pos)
    case Reflect(mn@Misc_UnsafeMutable(__arg0), u, es) => reflectMirrored(Reflect(Misc_UnsafeMutable(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


}

/**
 * Code generators
 */

trait ScalaGenMiscOps extends ScalaGenFat {
  val IR: MiscOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Misc_Exit(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("sys.exit("+quote(__arg0)+")")
      stream.println("}")

    case mn@Misc_Print(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("print("+quote(__arg0)+")")
      stream.println("}")

    case mn@Misc_Fatal(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("throw new Exception("+quote(__arg0)+")")
      stream.println("}")

    case mn@Misc1_Println(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("println("+quote(__arg0)+")")
      stream.println("}")

    case mn@Misc2_Println() => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("println()")
      stream.println("}")

    case mn@Misc___whileDo(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("while ({ ")
      emitBlock(__arg0)
      stream.print(quote(getBlockResult(__arg0))+"\n")
      stream.print( " }\n ) {\n  { ")
      emitBlock(__arg1)
      stream.print( " }\n \n}")
      stream.println("}")

    case mn@Misc___ifThenElse(__arg0,__arg1,__arg2) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("if ({ ")
      emitBlock(__arg0)
      stream.print(quote(getBlockResult(__arg0))+"\n")
      stream.print( " }\n ) {\n  { ")
      emitBlock(__arg1)
      stream.print(quote(getBlockResult(__arg1))+"\n")
      stream.print( " }\n \n}\nelse {\n  { ")
      emitBlock(__arg2)
      stream.print(quote(getBlockResult(__arg2))+"\n")
      stream.print( " }\n \n}")
      stream.println("}")

    case mn@Misc_UnsafeImmutable(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" // unsafe immutable")
      stream.println("}")

    case mn@Misc_UnsafeMutable(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" // unsafe mutable")
      stream.println("}")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CudaGenMiscOps extends CudaGenFat {
  val IR: MiscOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Misc_Exit(__arg0) => 
      stream.print("exit("+quote(__arg0)+")")
      stream.println(";")

    case mn@Misc_Print(__arg0) => 
      stream.print("std::cout << "+quote(__arg0)+"")
      stream.println(";")

    case mn@Misc_Fatal(__arg0) => 
      stream.print("assert(0)")
      stream.println(";")

    case mn@Misc1_Println(__arg0) => 
      stream.print("std::cout << "+quote(__arg0)+" << std::endl")
      stream.println(";")

    case mn@Misc2_Println() => 
      stream.print("std::cout << std::endl")
      stream.println(";")

    case mn@Misc_UnsafeImmutable(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+"")
      stream.println(";")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CGenMiscOps extends CGenFat {
  val IR: MiscOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = {
      rhs match {
      case mn@Misc_Exit(__arg0) => 
        Console.println("CGenMiscOps::emitNode::Misc_Exit")
        stream.print("exit("+quote(__arg0)+")")
        stream.println(";")

      case mn@Misc_Print(__arg0) => 
        Console.println("CGenMiscOps::emitNode::Misc_Print")
        stream.print("std::cout << "+quote(__arg0)+"")
        stream.println(";")

      case mn@Misc_Fatal(__arg0) => 
        Console.println("CGenMiscOps::emitNode::Misc_Fatal")
        stream.print("assert(0)")
        stream.println(";")

      case mn@Misc1_Println(__arg0) => 
        Console.println("CGenMiscOps::emitNode::Misc1_Println")
        stream.print("assert(0)")
        stream.print("std::cout << "+quote(__arg0)+" << std::endl")
        stream.println(";")

      case mn@Misc2_Println() => 
        Console.println("CGenMiscOps::emitNode::Misc2_Println")
        stream.print("std::cout << std::endl")
        stream.println(";")

      case mn@Misc_UnsafeImmutable(__arg0) => 
        Console.println("CGenMiscOps::emitNode::Misc_UnsafeImmutable")
        stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
        stream.print(""+quote(__arg0)+"")
        stream.println(";")

      case _ => 
        Console.println("CGenMiscOps::emitNode - going elsewhere")
        super.emitNode(sym, rhs)
    }
  }
}
