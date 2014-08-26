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

trait Tup6OpsExp extends Tup6CompilerOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class Internal_pack6[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C],__arg3: Rep[D],__arg4: Rep[E],__arg5: Rep[F])(implicit val __pos: SourceContext) extends DeliteStruct[Tup6[A,B,C,D,E,F]] {
    val _mA = implicitly[Manifest[A]]
    val _mB = implicitly[Manifest[B]]
    val _mC = implicitly[Manifest[C]]
    val _mD = implicitly[Manifest[D]]
    val _mE = implicitly[Manifest[E]]
    val _mF = implicitly[Manifest[F]]
    val elems = copyTransformedElems(collection.Seq(("_1",__arg0),("_2",__arg1),("_3",__arg2),("_4",__arg3),("_5",__arg4),("_6",__arg5)))
  }



  def tup6__1[A:Manifest](__arg0: Rep[Tup6[A,_,_,_,_,_]])(implicit __pos: SourceContext) = {
    field[A](__arg0,"_1")
  }
  def tup6__2[B:Manifest](__arg0: Rep[Tup6[_,B,_,_,_,_]])(implicit __pos: SourceContext) = {
    field[B](__arg0,"_2")
  }
  def tup6__3[C:Manifest](__arg0: Rep[Tup6[_,_,C,_,_,_]])(implicit __pos: SourceContext) = {
    field[C](__arg0,"_3")
  }
  def tup6__4[D:Manifest](__arg0: Rep[Tup6[_,_,_,D,_,_]])(implicit __pos: SourceContext) = {
    field[D](__arg0,"_4")
  }
  def tup6__5[E:Manifest](__arg0: Rep[Tup6[_,_,_,_,E,_]])(implicit __pos: SourceContext) = {
    field[E](__arg0,"_5")
  }
  def tup6__6[F:Manifest](__arg0: Rep[Tup6[_,_,_,_,_,F]])(implicit __pos: SourceContext) = {
    field[F](__arg0,"_6")
  }
  def tup6_unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Rep[Tup6[A,B,C,D,E,F]])(implicit __pos: SourceContext) = {
    tup6_unpack_impl5[A,B,C,D,E,F](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],__pos)
  }
  def tup6_pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Tuple6[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F]])(implicit __pos: SourceContext) = {
    tup6_pack_impl8[A,B,C,D,E,F](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],__pos)
  }
  def internal_pack6[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C],__arg3: Rep[D],__arg4: Rep[E],__arg5: Rep[F])(implicit __pos: SourceContext) = {
    reflectPure(Internal_pack6[A,B,C,D,E,F](__arg0,__arg1,__arg2,__arg3,__arg4,__arg5)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],__pos))
  }
  def tup6_tostring[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Rep[Tup6[A,B,C,D,E,F]]) = {
    tup6_tostring_impl8[A,B,C,D,E,F](t)
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Internal_pack6(__arg0,__arg1,__arg2,__arg3,__arg4,__arg5) => reflectPure(new { override val original = Some(f,mn) } with Internal_pack6(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4),f(__arg5))(mtype(mn._mA),mtype(mn._mB),mtype(mn._mC),mtype(mn._mD),mtype(mn._mE),mtype(mn._mF),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Internal_pack6(__arg0,__arg1,__arg2,__arg3,__arg4,__arg5), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Internal_pack6(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4),f(__arg5))(mtype(mn._mA),mtype(mn._mB),mtype(mn._mC),mtype(mn._mD),mtype(mn._mE),mtype(mn._mF),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[Tup6[_,_,_,_,_,_]]) Some((classTag(m), collection.immutable.List(("_1",m.typeArguments(0)),("_2",m.typeArguments(1)),("_3",m.typeArguments(2)),("_4",m.typeArguments(3)),("_5",m.typeArguments(4)),("_6",m.typeArguments(5)))))
    else super.unapplyStructType(m)
  }
}

