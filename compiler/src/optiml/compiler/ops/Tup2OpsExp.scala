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

trait Tup2OpsExp extends Tup2CompilerOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class Internal_pack2[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit val __pos: SourceContext) extends DeliteStruct[Tup2[A,B]] {
    val _mA = implicitly[Manifest[A]]
    val _mB = implicitly[Manifest[B]]
    val elems = copyTransformedElems(collection.Seq(("_1",__arg0),("_2",__arg1)))
  }



  def tup2__1[A:Manifest](__arg0: Rep[Tup2[A,_]])(implicit __pos: SourceContext) = {
    field[A](__arg0,"_1")
  }
  def tup2__2[B:Manifest](__arg0: Rep[Tup2[_,B]])(implicit __pos: SourceContext) = {
    field[B](__arg0,"_2")
  }
  def tup2_unpack[A:Manifest,B:Manifest](t: Rep[Tup2[A,B]])(implicit __pos: SourceContext) = {
    tup2_unpack_impl1[A,B](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos)
  }
  def tup2_pack[A:Manifest,B:Manifest](t: Tuple2[Rep[A],Rep[B]])(implicit __pos: SourceContext,__imp1: Overload1) = {
    tup2_pack_impl1[A,B](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos)
  }
  def internal_pack2[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext) = {
    reflectPure(Internal_pack2[A,B](__arg0,__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos))
  }
  def tup2_tostring[A:Manifest,B:Manifest](t: Rep[Tup2[A,B]]) = {
    tup2_tostring_impl2[A,B](t)
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Internal_pack2(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with Internal_pack2(f(__arg0),f(__arg1))(mtype(mn._mA),mtype(mn._mB),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Internal_pack2(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Internal_pack2(f(__arg0),f(__arg1))(mtype(mn._mA),mtype(mn._mB),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[Tup2[_,_]]) Some((classTag(m), collection.immutable.List(("_1",m.typeArguments(0)),("_2",m.typeArguments(1)))))
    else super.unapplyStructType(m)
  }
}

