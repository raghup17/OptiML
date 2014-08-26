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

trait Tup8OpsExp extends Tup8CompilerOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class Internal_pack8[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C],__arg3: Rep[D],__arg4: Rep[E],__arg5: Rep[F],__arg6: Rep[G],__arg7: Rep[H])(implicit val __pos: SourceContext) extends DeliteStruct[Tup8[A,B,C,D,E,F,G,H]] {
    val _mA = implicitly[Manifest[A]]
    val _mB = implicitly[Manifest[B]]
    val _mC = implicitly[Manifest[C]]
    val _mD = implicitly[Manifest[D]]
    val _mE = implicitly[Manifest[E]]
    val _mF = implicitly[Manifest[F]]
    val _mG = implicitly[Manifest[G]]
    val _mH = implicitly[Manifest[H]]
    val elems = copyTransformedElems(collection.Seq(("_1",__arg0),("_2",__arg1),("_3",__arg2),("_4",__arg3),("_5",__arg4),("_6",__arg5),("_7",__arg6),("_8",__arg7)))
  }



  def tup8__1[A:Manifest](__arg0: Rep[Tup8[A,_,_,_,_,_,_,_]])(implicit __pos: SourceContext) = {
    field[A](__arg0,"_1")
  }
  def tup8__2[B:Manifest](__arg0: Rep[Tup8[_,B,_,_,_,_,_,_]])(implicit __pos: SourceContext) = {
    field[B](__arg0,"_2")
  }
  def tup8__3[C:Manifest](__arg0: Rep[Tup8[_,_,C,_,_,_,_,_]])(implicit __pos: SourceContext) = {
    field[C](__arg0,"_3")
  }
  def tup8__4[D:Manifest](__arg0: Rep[Tup8[_,_,_,D,_,_,_,_]])(implicit __pos: SourceContext) = {
    field[D](__arg0,"_4")
  }
  def tup8__5[E:Manifest](__arg0: Rep[Tup8[_,_,_,_,E,_,_,_]])(implicit __pos: SourceContext) = {
    field[E](__arg0,"_5")
  }
  def tup8__6[F:Manifest](__arg0: Rep[Tup8[_,_,_,_,_,F,_,_]])(implicit __pos: SourceContext) = {
    field[F](__arg0,"_6")
  }
  def tup8__7[G:Manifest](__arg0: Rep[Tup8[_,_,_,_,_,_,G,_]])(implicit __pos: SourceContext) = {
    field[G](__arg0,"_7")
  }
  def tup8__8[H:Manifest](__arg0: Rep[Tup8[_,_,_,_,_,_,_,H]])(implicit __pos: SourceContext) = {
    field[H](__arg0,"_8")
  }
  def tup8_unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](t: Rep[Tup8[A,B,C,D,E,F,G,H]])(implicit __pos: SourceContext) = {
    tup8_unpack_impl3[A,B,C,D,E,F,G,H](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],implicitly[Manifest[H]],__pos)
  }
  def tup8_pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](t: Tuple8[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G],Rep[H]])(implicit __pos: SourceContext) = {
    tup8_pack_impl6[A,B,C,D,E,F,G,H](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],implicitly[Manifest[H]],__pos)
  }
  def internal_pack8[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C],__arg3: Rep[D],__arg4: Rep[E],__arg5: Rep[F],__arg6: Rep[G],__arg7: Rep[H])(implicit __pos: SourceContext) = {
    reflectPure(Internal_pack8[A,B,C,D,E,F,G,H](__arg0,__arg1,__arg2,__arg3,__arg4,__arg5,__arg6,__arg7)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],implicitly[Manifest[H]],__pos))
  }
  def tup8_tostring[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](t: Rep[Tup8[A,B,C,D,E,F,G,H]]) = {
    tup8_tostring_impl4[A,B,C,D,E,F,G,H](t)
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Internal_pack8(__arg0,__arg1,__arg2,__arg3,__arg4,__arg5,__arg6,__arg7) => reflectPure(new { override val original = Some(f,mn) } with Internal_pack8(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4),f(__arg5),f(__arg6),f(__arg7))(mtype(mn._mA),mtype(mn._mB),mtype(mn._mC),mtype(mn._mD),mtype(mn._mE),mtype(mn._mF),mtype(mn._mG),mtype(mn._mH),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Internal_pack8(__arg0,__arg1,__arg2,__arg3,__arg4,__arg5,__arg6,__arg7), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Internal_pack8(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4),f(__arg5),f(__arg6),f(__arg7))(mtype(mn._mA),mtype(mn._mB),mtype(mn._mC),mtype(mn._mD),mtype(mn._mE),mtype(mn._mF),mtype(mn._mG),mtype(mn._mH),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[Tup8[_,_,_,_,_,_,_,_]]) Some((classTag(m), collection.immutable.List(("_1",m.typeArguments(0)),("_2",m.typeArguments(1)),("_3",m.typeArguments(2)),("_4",m.typeArguments(3)),("_5",m.typeArguments(4)),("_6",m.typeArguments(5)),("_7",m.typeArguments(6)),("_8",m.typeArguments(7)))))
    else super.unapplyStructType(m)
  }
}

