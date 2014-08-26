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

trait Tup4OpsExp extends Tup4CompilerOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class Internal_pack4[A:Manifest,B:Manifest,C:Manifest,D:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C],__arg3: Rep[D])(implicit val __pos: SourceContext) extends DeliteStruct[Tup4[A,B,C,D]] {
    val _mA = implicitly[Manifest[A]]
    val _mB = implicitly[Manifest[B]]
    val _mC = implicitly[Manifest[C]]
    val _mD = implicitly[Manifest[D]]
    val elems = copyTransformedElems(collection.Seq(("_1",__arg0),("_2",__arg1),("_3",__arg2),("_4",__arg3)))
  }



  def tup4__1[A:Manifest](__arg0: Rep[Tup4[A,_,_,_]])(implicit __pos: SourceContext) = {
    field[A](__arg0,"_1")
  }
  def tup4__2[B:Manifest](__arg0: Rep[Tup4[_,B,_,_]])(implicit __pos: SourceContext) = {
    field[B](__arg0,"_2")
  }
  def tup4__3[C:Manifest](__arg0: Rep[Tup4[_,_,C,_]])(implicit __pos: SourceContext) = {
    field[C](__arg0,"_3")
  }
  def tup4__4[D:Manifest](__arg0: Rep[Tup4[_,_,_,D]])(implicit __pos: SourceContext) = {
    field[D](__arg0,"_4")
  }
  def tup4_unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Rep[Tup4[A,B,C,D]])(implicit __pos: SourceContext) = {
    tup4_unpack_impl7[A,B,C,D](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],__pos)
  }
  def tup4_pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Tuple4[Rep[A],Rep[B],Rep[C],Rep[D]])(implicit __pos: SourceContext) = {
    tup4_pack_impl10[A,B,C,D](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],__pos)
  }
  def internal_pack4[A:Manifest,B:Manifest,C:Manifest,D:Manifest](__arg0: Rep[A],__arg1: Rep[B],__arg2: Rep[C],__arg3: Rep[D])(implicit __pos: SourceContext) = {
    reflectPure(Internal_pack4[A,B,C,D](__arg0,__arg1,__arg2,__arg3)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],__pos))
  }
  def tup4_tostring[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Rep[Tup4[A,B,C,D]]) = {
    tup4_tostring_impl12[A,B,C,D](t)
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Internal_pack4(__arg0,__arg1,__arg2,__arg3) => reflectPure(new { override val original = Some(f,mn) } with Internal_pack4(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mA),mtype(mn._mB),mtype(mn._mC),mtype(mn._mD),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Internal_pack4(__arg0,__arg1,__arg2,__arg3), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Internal_pack4(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mA),mtype(mn._mB),mtype(mn._mC),mtype(mn._mD),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[Tup4[_,_,_,_]]) Some((classTag(m), collection.immutable.List(("_1",m.typeArguments(0)),("_2",m.typeArguments(1)),("_3",m.typeArguments(2)),("_4",m.typeArguments(3)))))
    else super.unapplyStructType(m)
  }
}

