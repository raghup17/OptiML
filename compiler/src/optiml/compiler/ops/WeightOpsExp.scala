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

trait WeightOpsExp extends WeightOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class Weight11Object_Apply(id: Rep[Int],value: Rep[Double],isFixed: Rep[Boolean])(implicit val __pos: SourceContext) extends DeliteStruct[Weight] {
    val elems = copyTransformedElems(collection.Seq(("_id",id),("_value",value),("_isFixed",isFixed)))
  }



  def weight_object_apply(id: Rep[Int],value: Rep[Double],isFixed: Rep[Boolean])(implicit __pos: SourceContext) = {
    reflectPure(Weight11Object_Apply(id,value,isFixed)(__pos))
  }
  def weight_id(self: Rep[Weight])(implicit __pos: SourceContext) = {
    field[Int](self,"_id")
  }
  def weight_value(self: Rep[Weight])(implicit __pos: SourceContext) = {
    field[Double](self,"_value")
  }
  def weight_isfixed(self: Rep[Weight])(implicit __pos: SourceContext) = {
    field[Boolean](self,"_isFixed")
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Weight11Object_Apply(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Weight11Object_Apply(f(__arg0),f(__arg1),f(__arg2))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Weight11Object_Apply(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Weight11Object_Apply(f(__arg0),f(__arg1),f(__arg2))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[Weight]) Some((classTag(m), collection.immutable.List(("_id",manifest[Int]),("_value",manifest[Double]),("_isFixed",manifest[Boolean]))))
    else super.unapplyStructType(m)
  }
}

