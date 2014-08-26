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

trait FunctionFactorOpsExp extends FunctionFactorCompilerOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class Function_factor_alloc_helper(id: Rep[Int],vars: Rep[DenseVector[FactorVariable]],weightId: Rep[Int],funcId: Rep[Int])(implicit val __pos: SourceContext) extends DeliteStruct[FunctionFactor] {
    val elems = copyTransformedElems(collection.Seq(("_id",id),("_vars",vars),("_weightId",weightId),("_funcId",funcId)))
  }



  def functionfactor_object_apply(id: Rep[Int],vars: Rep[DenseVector[FactorVariable]],weightId: Rep[Int],func: Rep[Int])(implicit __pos: SourceContext) = {
    functionfactor_object_apply_impl14(id,vars,weightId,func)(__pos)
  }
  def function_factor_alloc_helper(id: Rep[Int],vars: Rep[DenseVector[FactorVariable]],weightId: Rep[Int],funcId: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Function_factor_alloc_helper(id,vars,weightId,funcId)(__pos))
  }
  def or_factor_func(__arg0: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    or_factor_func_impl(__arg0)(__pos)
  }
  def and_factor_func(__arg0: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    and_factor_func_impl(__arg0)(__pos)
  }
  def imply_factor_func(__arg0: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    imply_factor_func_impl(__arg0)(__pos)
  }
  def equal_factor_func(__arg0: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    equal_factor_func_impl(__arg0)(__pos)
  }
  def istrue_factor_func(__arg0: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    istrue_factor_func_impl(__arg0)(__pos)
  }
  def factor_func_to_int(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    factor_func_to_int_impl(__arg0)(__pos)
  }
  def evaluate_factor_func(funcId: Rep[Int],vals: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    evaluate_factor_func_impl(funcId,vals)(__pos)
  }
  def functionfactor_id(self: Rep[FunctionFactor])(implicit __pos: SourceContext) = {
    field[Int](self,"_id")
  }
  def functionfactor_vars(self: Rep[FunctionFactor])(implicit __pos: SourceContext) = {
    field[DenseVector[FactorVariable]](self,"_vars")
  }
  def functionfactor_weightid(self: Rep[FunctionFactor])(implicit __pos: SourceContext) = {
    field[Int](self,"_weightId")
  }
  def functionfactor_funcid(self: Rep[FunctionFactor])(implicit __pos: SourceContext) = {
    field[Int](self,"_funcId")
  }
  def functionfactor_evaluate(self: Rep[FunctionFactor],__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    functionfactor_evaluate_impl(self,__arg1)(__pos)
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Function_factor_alloc_helper(__arg0,__arg1,__arg2,__arg3) => reflectPure(new { override val original = Some(f,mn) } with Function_factor_alloc_helper(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Function_factor_alloc_helper(__arg0,__arg1,__arg2,__arg3), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Function_factor_alloc_helper(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[FunctionFactor]) Some((classTag(m), collection.immutable.List(("_id",manifest[Int]),("_vars",makeManifest(classOf[DenseVector[_]], List(manifest[FactorVariable]))),("_weightId",manifest[Int]),("_funcId",manifest[Int]))))
    else super.unapplyStructType(m)
  }
}

