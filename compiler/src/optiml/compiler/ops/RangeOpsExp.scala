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

import ppl.delite.framework.Config
/**
 * IR Definitions
 */

trait RangeOpsExp extends RangeCompilerOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class Infix_until(__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends DeliteStruct[Range] {
    val elems = copyTransformedElems(collection.Seq(("start",__arg0),("end",__arg1)))
  }

  case class Infix_by(__arg0: Rep[Range],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends DeliteStruct[Range] {
    val elems = copyTransformedElems(collection.Seq(("range",__arg0),("step",__arg1)))
  }

  case class Range_foreach(start: Rep[Int],end: Rep[Int], step: Int, func: Block[Unit],f_func___arg0: Rep[Int])(implicit val __pos: SourceContext) extends Def[Unit] {
  }



  def range_start(__arg0: Rep[Range])(implicit __pos: SourceContext) = {
    field[Int](__arg0,"start")
  }
  def range_end(__arg0: Rep[Range])(implicit __pos: SourceContext) = {
    field[Int](__arg0,"end")
  }

  def infix_until(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Infix_until(__arg0,__arg1)(__pos))
  }

  def infix_by(__arg0: Rep[Range],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Infix_by(__arg0,__arg1)(__pos))
  }


  def infix_foreach(__arg0: Rep[Range],__arg1: (Rep[Int]) => Rep[Unit])(implicit __pos: SourceContext) = {
    val irnode = findDefinition(__arg0.asInstanceOf[Sym[Any]]).get.rhs

    irnode match {
      case Infix_by(range, step) => 
          step match {
            case Const(x: Int) => infix_foreach_impl(range,x,__arg1)(__pos)
            case _ => throw new Exception("Infix_by must only have Const() as step")
          }
      case Infix_until(start, end) => 
          infix_foreach_impl(__arg0,1,__arg1)(__pos)
         case _ => 
          infix_foreach_impl(__arg0,1,__arg1)(__pos)
    }
  }

  def range_foreach(start: Rep[Int],end: Rep[Int], step: Int, func: (Rep[Int]) => Rep[Unit])(implicit __pos: SourceContext) = {
    if (Config.autotuneEnabled) {
      Console.println("[AUTOTUNER] Autotuner enabled, range_foreach")
    }
    val f_func___arg0 = fresh[Int]
//    (start, end) match {
//      case (Const(s:Int), Const(e:Int)) => {
//        var b_func = reifyEffects(func(f_func___arg0))
//        var sb_func = summarizeEffects(b_func)
//        var arg = f_func___arg0
//        var irNode = findDefinition(b_func.res.asInstanceOf[Sym[Any]]).get.rhs.asInstanceOf[Def[Any]]
//        for (i <- s until e) {
//          throw new Exception("Should not come here!")
//          b_func = reifyEffects(func(arg))
//          sb_func = summarizeEffects(b_func)
//          irNode = findDefinition(b_func.res.asInstanceOf[Sym[Any]]).get.rhs.asInstanceOf[Def[Any]]
//          reflectEffect(irNode, sb_func)
//        }
//      }
//
//      case _ => {
        val b_func = reifyEffects(func(f_func___arg0))
        val sb_func = summarizeEffects(b_func)
        reflectEffect(Range_foreach(start,end, step, b_func,f_func___arg0)(__pos), sb_func)
//      }
//    }

  }

  /**
   * Syms
   */
  override def syms(e: Any): List[Sym[Any]] = e match {
    case Range_foreach(start,end, step, func,f_func___arg0) => syms(start):::syms(end):::syms(func)
    case _ => super.syms(e)
  }
  override def boundSyms(e: Any): List[Sym[Any]] = e match {
    case Range_foreach(start,end, step, func,f_func___arg0) => effectSyms(start):::effectSyms(end):::effectSyms(func) ::: List(f_func___arg0.asInstanceOf[Sym[Any]])
    case _ => super.boundSyms(e)
  }
  override def symsFreq(e: Any): List[(Sym[Any], Double)] = e match {
    case Range_foreach(start,end, step, func,f_func___arg0) => freqNormal(start):::freqNormal(end):::freqNormal(func)
    case _ => super.symsFreq(e)
  }


  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Infix_until(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with Infix_until(f(__arg0),f(__arg1))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Infix_until(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Infix_until(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Range_foreach(__arg0,__arg1, step, __arg2,f___arg2___arg0) => reflectPure(Range_foreach(f(__arg0),f(__arg1), step, f(__arg2),f___arg2___arg0)(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Range_foreach(__arg0,__arg1, step, __arg2,f___arg2___arg0), u, es) => reflectMirrored(Reflect(Range_foreach(f(__arg0),f(__arg1), step, f(__arg2),f___arg2___arg0)(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[Range]) Some((classTag(m), collection.immutable.List(("start",manifest[Int]),("end",manifest[Int]))))
    else super.unapplyStructType(m)
  }
}

/**
 * Code generators
 */

trait ScalaGenRangeOps extends ScalaGenFat {
  val IR: RangeOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Range_foreach(start,end,step, func,f_func___arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("var i = "+quote(start)+"\nwhile (i < "+quote(end)+") {\n  { ")
      emitValDef(f_func___arg0.asInstanceOf[Sym[Any]],"i")
      emitBlock(func)
      stream.print( " }\n \n  i += %d\n}".format(step))
      stream.println("}")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CGenRangeOps extends CGenFat {
  val IR: RangeOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = {
      rhs match {
      case mn@Range_foreach(start,end,step, func,f_func___arg0) => 
        Console.println("CGenRangeOps::emitNode::Range_foreach")
        stream.print("for(int i="+quote(start)+" ; i<"+quote(end)+" ; i+="+ step + ") {\n  { ")
        emitValDef(f_func___arg0.asInstanceOf[Sym[Any]],"i")
        emitBlock(func)
        stream.print( " }\n \n}")
        stream.println(";")

      case _ => 
        Console.println("CGenRangeOps::emitNode - going elsewhere")
        super.emitNode(sym, rhs)

    }
  }
}
