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

trait UTriangleOpsExp extends UTriangleCompilerOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class UTriangle_Utriangle(N: Rep[Int],includeDiagonal: Rep[Boolean] = unit(true))(implicit val __pos: SourceContext) extends DeliteStruct[UTriangle] {
    val elems = copyTransformedElems(collection.Seq(("N",N),("_includeDiagonal",includeDiagonal)))
  }



  def utriangle_utriangle(N: Rep[Int],includeDiagonal: Rep[Boolean] = unit(true))(implicit __pos: SourceContext) = {
    reflectPure(UTriangle_Utriangle(N,includeDiagonal)(__pos))
  }
  def tri_size(n: Rep[Int])(implicit __pos: SourceContext) = {
    tri_size_impl(n)(__pos)
  }
  def utriangle_n(self: Rep[UTriangle])(implicit __pos: SourceContext) = {
    field[Int](self,"N")
  }
  def utriangle_includediagonal(self: Rep[UTriangle])(implicit __pos: SourceContext) = {
    field[Boolean](self,"_includeDiagonal")
  }
  def utriangle_size(self: Rep[UTriangle])(implicit __pos: SourceContext) = {
    utriangle_size_impl5(self)(__pos)
  }
  def utriangle_contains(self: Rep[UTriangle],i: Rep[Int],j: Rep[Int])(implicit __pos: SourceContext) = {
    utriangle_contains_impl4(self,i,j)(__pos)
  }
  def utriangle_apply(self: Rep[UTriangle],n: Rep[Int])(implicit __pos: SourceContext) = {
    utriangle_apply_impl13(self,n)(__pos)
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@UTriangle_Utriangle(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with UTriangle_Utriangle(f(__arg0),f(__arg1))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@UTriangle_Utriangle(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with UTriangle_Utriangle(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[UTriangle]) Some((classTag(m), collection.immutable.List(("N",manifest[Int]),("_includeDiagonal",manifest[Boolean]))))
    else super.unapplyStructType(m)
  }
}

