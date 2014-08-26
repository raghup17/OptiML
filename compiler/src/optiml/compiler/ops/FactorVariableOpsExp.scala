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

trait FactorVariableOpsExp extends FactorVariableOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class FactorVariable17Object_Apply(id: Rep[Int],isPositive: Rep[Boolean],domain: Rep[DenseVector[Double]],position: Rep[Int])(implicit val __pos: SourceContext) extends DeliteStruct[FactorVariable] {
    val elems = copyTransformedElems(collection.Seq(("_id",id),("_isPositive",isPositive),("_domain",domain),("_position",position)))
  }



  def factorvariable_object_apply(id: Rep[Int],isPositive: Rep[Boolean],domain: Rep[DenseVector[Double]],position: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(FactorVariable17Object_Apply(id,isPositive,domain,position)(__pos))
  }
  def factorvariable_id(self: Rep[FactorVariable])(implicit __pos: SourceContext) = {
    field[Int](self,"_id")
  }
  def factorvariable_ispositive(self: Rep[FactorVariable])(implicit __pos: SourceContext) = {
    field[Boolean](self,"_isPositive")
  }
  def factorvariable_domain(self: Rep[FactorVariable])(implicit __pos: SourceContext) = {
    field[DenseVector[Double]](self,"_domain")
  }
  def factorvariable_position(self: Rep[FactorVariable])(implicit __pos: SourceContext) = {
    field[Int](self,"_position")
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@FactorVariable17Object_Apply(__arg0,__arg1,__arg2,__arg3) => reflectPure(new { override val original = Some(f,mn) } with FactorVariable17Object_Apply(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@FactorVariable17Object_Apply(__arg0,__arg1,__arg2,__arg3), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with FactorVariable17Object_Apply(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[FactorVariable]) Some((classTag(m), collection.immutable.List(("_id",manifest[Int]),("_isPositive",manifest[Boolean]),("_domain",makeManifest(classOf[DenseVector[_]], List(manifest[Double]))),("_position",manifest[Int]))))
    else super.unapplyStructType(m)
  }
}

