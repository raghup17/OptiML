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

trait Tup5OpsExp extends Tup5CompilerOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class Internal_pack5[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C],__arg3: Rep[D],__arg4: Rep[E])(implicit val __pos: SourceContext) extends DeliteStruct[Tup5[A,B,C,D,E]] {
    val _mA = implicitly[Manifest[A]]
    val _mB = implicitly[Manifest[B]]
    val _mC = implicitly[Manifest[C]]
    val _mD = implicitly[Manifest[D]]
    val _mE = implicitly[Manifest[E]]
    val elems = copyTransformedElems(collection.Seq(("_1",__arg0),("_2",__arg1),("_3",__arg2),("_4",__arg3),("_5",__arg4)))
  }



  def tup5__1[A:Manifest](__arg0: Rep[Tup5[A,_,_,_,_]])(implicit __pos: SourceContext) = {
    field[A](__arg0,"_1")
  }
  def tup5__2[B:Manifest](__arg0: Rep[Tup5[_,B,_,_,_]])(implicit __pos: SourceContext) = {
    field[B](__arg0,"_2")
  }
  def tup5__3[C:Manifest](__arg0: Rep[Tup5[_,_,C,_,_]])(implicit __pos: SourceContext) = {
    field[C](__arg0,"_3")
  }
  def tup5__4[D:Manifest](__arg0: Rep[Tup5[_,_,_,D,_]])(implicit __pos: SourceContext) = {
    field[D](__arg0,"_4")
  }
  def tup5__5[E:Manifest](__arg0: Rep[Tup5[_,_,_,_,E]])(implicit __pos: SourceContext) = {
    field[E](__arg0,"_5")
  }
  def tup5_unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Rep[Tup5[A,B,C,D,E]])(implicit __pos: SourceContext) = {
    tup5_unpack_impl8[A,B,C,D,E](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],__pos)
  }
  def tup5_pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Tuple5[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E]])(implicit __pos: SourceContext) = {
    tup5_pack_impl11[A,B,C,D,E](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],__pos)
  }
  def internal_pack5[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C],__arg3: Rep[D],__arg4: Rep[E])(implicit __pos: SourceContext) = {
    reflectPure(Internal_pack5[A,B,C,D,E](__arg0,__arg1,__arg2,__arg3,__arg4)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],__pos))
  }
  def tup5_tostring[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Rep[Tup5[A,B,C,D,E]]) = {
    tup5_tostring_impl13[A,B,C,D,E](t)
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Internal_pack5(__arg0,__arg1,__arg2,__arg3,__arg4) => reflectPure(new { override val original = Some(f,mn) } with Internal_pack5(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4))(mtype(mn._mA),mtype(mn._mB),mtype(mn._mC),mtype(mn._mD),mtype(mn._mE),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Internal_pack5(__arg0,__arg1,__arg2,__arg3,__arg4), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Internal_pack5(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4))(mtype(mn._mA),mtype(mn._mB),mtype(mn._mC),mtype(mn._mD),mtype(mn._mE),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[Tup5[_,_,_,_,_]]) Some((classTag(m), collection.immutable.List(("_1",m.typeArguments(0)),("_2",m.typeArguments(1)),("_3",m.typeArguments(2)),("_4",m.typeArguments(3)),("_5",m.typeArguments(4)))))
    else super.unapplyStructType(m)
  }
}

