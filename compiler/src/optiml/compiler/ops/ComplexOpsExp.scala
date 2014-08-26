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

trait ComplexOpsExp extends ComplexOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class Complex3Object_Apply(__arg0: Rep[Double],__arg1: Rep[Double])(implicit val __pos: SourceContext) extends DeliteStruct[Complex] {
    val elems = copyTransformedElems(collection.Seq(("_real",__arg0),("_imag",__arg1)))
  }



  def complex_object_apply(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(Complex3Object_Apply(__arg0,__arg1)(__pos))
  }
  def complex_real(self: Rep[Complex])(implicit __pos: SourceContext) = {
    field[Double](self,"_real")
  }
  def complex_imag(self: Rep[Complex])(implicit __pos: SourceContext) = {
    field[Double](self,"_imag")
  }
  def complex_conj(self: Rep[Complex])(implicit __pos: SourceContext) = {
    complex_conj_impl(self)(__pos)
  }
  def complex_pl(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext) = {
    complex_pl_impl1(self,__arg1)(__pos)
  }
  def complex_sub(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext) = {
    complex_sub_impl1(self,__arg1)(__pos)
  }
  def complex_mul(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext) = {
    complex_mul_impl1(self,__arg1)(__pos)
  }
  def complex_div(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext) = {
    complex_div_impl1(self,__arg1)(__pos)
  }
  def complex_abs(self: Rep[Complex])(implicit __pos: SourceContext) = {
    complex_abs_impl1(self)(__pos)
  }
  def complex_exp(self: Rep[Complex])(implicit __pos: SourceContext) = {
    complex_exp_impl1(self)(__pos)
  }
  def complex_log(self: Rep[Complex])(implicit __pos: SourceContext) = {
    complex_log_impl1(self)(__pos)
  }
  def complex___equal(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext) = {
    complex___equal_impl3(self,__arg1)(__pos)
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Complex3Object_Apply(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with Complex3Object_Apply(f(__arg0),f(__arg1))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Complex3Object_Apply(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Complex3Object_Apply(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[Complex]) Some((classTag(m), collection.immutable.List(("_real",manifest[Double]),("_imag",manifest[Double]))))
    else super.unapplyStructType(m)
  }
}

