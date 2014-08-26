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

trait Tup9OpsExp extends Tup9CompilerOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class Internal_pack9[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C],__arg3: Rep[D],__arg4: Rep[E],__arg5: Rep[F],__arg6: Rep[G],__arg7: Rep[H],__arg8: Rep[I])(implicit val __pos: SourceContext) extends DeliteStruct[Tup9[A,B,C,D,E,F,G,H,I]] {
    val _mA = implicitly[Manifest[A]]
    val _mB = implicitly[Manifest[B]]
    val _mC = implicitly[Manifest[C]]
    val _mD = implicitly[Manifest[D]]
    val _mE = implicitly[Manifest[E]]
    val _mF = implicitly[Manifest[F]]
    val _mG = implicitly[Manifest[G]]
    val _mH = implicitly[Manifest[H]]
    val _mI = implicitly[Manifest[I]]
    val elems = copyTransformedElems(collection.Seq(("_1",__arg0),("_2",__arg1),("_3",__arg2),("_4",__arg3),("_5",__arg4),("_6",__arg5),("_7",__arg6),("_8",__arg7),("_9",__arg8)))
  }



  def tup9__1[A:Manifest](__arg0: Rep[Tup9[A,_,_,_,_,_,_,_,_]])(implicit __pos: SourceContext) = {
    field[A](__arg0,"_1")
  }
  def tup9__2[B:Manifest](__arg0: Rep[Tup9[_,B,_,_,_,_,_,_,_]])(implicit __pos: SourceContext) = {
    field[B](__arg0,"_2")
  }
  def tup9__3[C:Manifest](__arg0: Rep[Tup9[_,_,C,_,_,_,_,_,_]])(implicit __pos: SourceContext) = {
    field[C](__arg0,"_3")
  }
  def tup9__4[D:Manifest](__arg0: Rep[Tup9[_,_,_,D,_,_,_,_,_]])(implicit __pos: SourceContext) = {
    field[D](__arg0,"_4")
  }
  def tup9__5[E:Manifest](__arg0: Rep[Tup9[_,_,_,_,E,_,_,_,_]])(implicit __pos: SourceContext) = {
    field[E](__arg0,"_5")
  }
  def tup9__6[F:Manifest](__arg0: Rep[Tup9[_,_,_,_,_,F,_,_,_]])(implicit __pos: SourceContext) = {
    field[F](__arg0,"_6")
  }
  def tup9__7[G:Manifest](__arg0: Rep[Tup9[_,_,_,_,_,_,G,_,_]])(implicit __pos: SourceContext) = {
    field[G](__arg0,"_7")
  }
  def tup9__8[H:Manifest](__arg0: Rep[Tup9[_,_,_,_,_,_,_,H,_]])(implicit __pos: SourceContext) = {
    field[H](__arg0,"_8")
  }
  def tup9__9[I:Manifest](__arg0: Rep[Tup9[_,_,_,_,_,_,_,_,I]])(implicit __pos: SourceContext) = {
    field[I](__arg0,"_9")
  }
  def tup9_unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest](t: Rep[Tup9[A,B,C,D,E,F,G,H,I]])(implicit __pos: SourceContext) = {
    tup9_unpack_impl2[A,B,C,D,E,F,G,H,I](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],implicitly[Manifest[H]],implicitly[Manifest[I]],__pos)
  }
  def tup9_pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest](t: Tuple9[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G],Rep[H],Rep[I]])(implicit __pos: SourceContext) = {
    tup9_pack_impl5[A,B,C,D,E,F,G,H,I](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],implicitly[Manifest[H]],implicitly[Manifest[I]],__pos)
  }
  def internal_pack9[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C],__arg3: Rep[D],__arg4: Rep[E],__arg5: Rep[F],__arg6: Rep[G],__arg7: Rep[H],__arg8: Rep[I])(implicit __pos: SourceContext) = {
    reflectPure(Internal_pack9[A,B,C,D,E,F,G,H,I](__arg0,__arg1,__arg2,__arg3,__arg4,__arg5,__arg6,__arg7,__arg8)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],implicitly[Manifest[H]],implicitly[Manifest[I]],__pos))
  }
  def tup9_tostring[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest](t: Rep[Tup9[A,B,C,D,E,F,G,H,I]]) = {
    tup9_tostring_impl3[A,B,C,D,E,F,G,H,I](t)
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Internal_pack9(__arg0,__arg1,__arg2,__arg3,__arg4,__arg5,__arg6,__arg7,__arg8) => reflectPure(new { override val original = Some(f,mn) } with Internal_pack9(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4),f(__arg5),f(__arg6),f(__arg7),f(__arg8))(mtype(mn._mA),mtype(mn._mB),mtype(mn._mC),mtype(mn._mD),mtype(mn._mE),mtype(mn._mF),mtype(mn._mG),mtype(mn._mH),mtype(mn._mI),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Internal_pack9(__arg0,__arg1,__arg2,__arg3,__arg4,__arg5,__arg6,__arg7,__arg8), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Internal_pack9(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4),f(__arg5),f(__arg6),f(__arg7),f(__arg8))(mtype(mn._mA),mtype(mn._mB),mtype(mn._mC),mtype(mn._mD),mtype(mn._mE),mtype(mn._mF),mtype(mn._mG),mtype(mn._mH),mtype(mn._mI),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[Tup9[_,_,_,_,_,_,_,_,_]]) Some((classTag(m), collection.immutable.List(("_1",m.typeArguments(0)),("_2",m.typeArguments(1)),("_3",m.typeArguments(2)),("_4",m.typeArguments(3)),("_5",m.typeArguments(4)),("_6",m.typeArguments(5)),("_7",m.typeArguments(6)),("_8",m.typeArguments(7)),("_9",m.typeArguments(8)))))
    else super.unapplyStructType(m)
  }
}

