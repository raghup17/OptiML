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

trait TableFactorOpsExp extends TableFactorOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class TableFactor1Object_Apply(vars: Rep[DenseVector[FactorVariable]],vals: Rep[DenseVector[Double]])(implicit val __pos: SourceContext) extends DeliteStruct[TableFactor] {
    val elems = copyTransformedElems(collection.Seq(("_vars",vars),("_vals",vals)))
  }



  def tablefactor_object_apply(vars: Rep[DenseVector[FactorVariable]],vals: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    reflectPure(TableFactor1Object_Apply(vars,vals)(__pos))
  }
  def tablefactor_assignmenttoindex(__arg0: Rep[DenseVector[Int]])(implicit __pos: SourceContext) = {
    tablefactor_assignmenttoindex_impl(__arg0)(__pos)
  }
  def tablefactor_indextoassignment(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    tablefactor_indextoassignment_impl(__arg0)(__pos)
  }
  def tablefactor_vars(self: Rep[TableFactor])(implicit __pos: SourceContext) = {
    field[DenseVector[FactorVariable]](self,"_vars")
  }
  def tablefactor_vals(self: Rep[TableFactor])(implicit __pos: SourceContext) = {
    field[DenseVector[Double]](self,"_vals")
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@TableFactor1Object_Apply(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with TableFactor1Object_Apply(f(__arg0),f(__arg1))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@TableFactor1Object_Apply(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with TableFactor1Object_Apply(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[TableFactor]) Some((classTag(m), collection.immutable.List(("_vars",makeManifest(classOf[DenseVector[_]], List(manifest[FactorVariable]))),("_vals",makeManifest(classOf[DenseVector[_]], List(manifest[Double]))))))
    else super.unapplyStructType(m)
  }
}

