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

trait RandomVariableOpsExp extends RandomVariableOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class RandomVariable19Object_Apply(id: Rep[Int],domain: Rep[DenseVector[Double]],value: Rep[Double],isEvidence: Rep[Boolean],isQuery: Rep[Boolean])(implicit val __pos: SourceContext) extends DeliteStruct[RandomVariable] {
    val elems = copyTransformedElems(collection.Seq(("_id",id),("_domain",domain),("_value",value),("_isEvidence",isEvidence),("_isQuery",isQuery)))
  }



  def randomvariable_object_apply(id: Rep[Int],domain: Rep[DenseVector[Double]],value: Rep[Double],isEvidence: Rep[Boolean],isQuery: Rep[Boolean])(implicit __pos: SourceContext) = {
    reflectPure(RandomVariable19Object_Apply(id,domain,value,isEvidence,isQuery)(__pos))
  }
  def randomvariable_id(self: Rep[RandomVariable])(implicit __pos: SourceContext) = {
    field[Int](self,"_id")
  }
  def randomvariable_domain(self: Rep[RandomVariable])(implicit __pos: SourceContext) = {
    field[DenseVector[Double]](self,"_domain")
  }
  def randomvariable_value(self: Rep[RandomVariable])(implicit __pos: SourceContext) = {
    field[Double](self,"_value")
  }
  def randomvariable_isevidence(self: Rep[RandomVariable])(implicit __pos: SourceContext) = {
    field[Boolean](self,"_isEvidence")
  }
  def randomvariable_isquery(self: Rep[RandomVariable])(implicit __pos: SourceContext) = {
    field[Boolean](self,"_isQuery")
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@RandomVariable19Object_Apply(__arg0,__arg1,__arg2,__arg3,__arg4) => reflectPure(new { override val original = Some(f,mn) } with RandomVariable19Object_Apply(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@RandomVariable19Object_Apply(__arg0,__arg1,__arg2,__arg3,__arg4), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with RandomVariable19Object_Apply(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[RandomVariable]) Some((classTag(m), collection.immutable.List(("_id",manifest[Int]),("_domain",makeManifest(classOf[DenseVector[_]], List(manifest[Double]))),("_value",manifest[Double]),("_isEvidence",manifest[Boolean]),("_isQuery",manifest[Boolean]))))
    else super.unapplyStructType(m)
  }
}

