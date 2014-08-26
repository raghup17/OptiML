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

trait Tup3OpsExp extends Tup3CompilerOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class Internal_pack3[A:Manifest,B:Manifest,C:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C])(implicit val __pos: SourceContext) extends DeliteStruct[Tup3[A,B,C]] {
    val _mA = implicitly[Manifest[A]]
    val _mB = implicitly[Manifest[B]]
    val _mC = implicitly[Manifest[C]]
    val elems = copyTransformedElems(collection.Seq(("_1",__arg0),("_2",__arg1),("_3",__arg2)))
  }



  def tup3__1[A:Manifest](__arg0: Rep[Tup3[A,_,_]])(implicit __pos: SourceContext) = {
    field[A](__arg0,"_1")
  }
  def tup3__2[B:Manifest](__arg0: Rep[Tup3[_,B,_]])(implicit __pos: SourceContext) = {
    field[B](__arg0,"_2")
  }
  def tup3__3[C:Manifest](__arg0: Rep[Tup3[_,_,C]])(implicit __pos: SourceContext) = {
    field[C](__arg0,"_3")
  }
  def tup3_unpack[A:Manifest,B:Manifest,C:Manifest](t: Rep[Tup3[A,B,C]])(implicit __pos: SourceContext) = {
    tup3_unpack_impl6[A,B,C](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],__pos)
  }
  def tup3_pack[A:Manifest,B:Manifest,C:Manifest](t: Tuple3[Rep[A],Rep[B],Rep[C]])(implicit __pos: SourceContext) = {
    tup3_pack_impl9[A,B,C](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],__pos)
  }
  def internal_pack3[A:Manifest,B:Manifest,C:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C])(implicit __pos: SourceContext) = {
    reflectPure(Internal_pack3[A,B,C](__arg0,__arg1,__arg2)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],__pos))
  }
  def tup3_tostring[A:Manifest,B:Manifest,C:Manifest](t: Rep[Tup3[A,B,C]]) = {
    tup3_tostring_impl10[A,B,C](t)
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Internal_pack3(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Internal_pack3(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mA),mtype(mn._mB),mtype(mn._mC),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Internal_pack3(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Internal_pack3(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mA),mtype(mn._mB),mtype(mn._mC),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[Tup3[_,_,_]]) Some((classTag(m), collection.immutable.List(("_1",m.typeArguments(0)),("_2",m.typeArguments(1)),("_3",m.typeArguments(2)))))
    else super.unapplyStructType(m)
  }
}

