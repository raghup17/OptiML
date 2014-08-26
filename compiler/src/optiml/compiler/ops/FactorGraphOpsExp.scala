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

trait FactorGraphOpsExp extends FactorGraphCompilerOps with BaseFatExp with DeliteStructsExp {
  this: OptiMLExp => 

  case class FactorGraph12Object_Apply[F:Factor:Manifest](factors: Rep[DenseVector[F]],variables: Rep[DenseVector[RandomVariable]],weights: Rep[DenseVector[Weight]],variablesToFactors: Rep[DenseVector[DenseVector[Int]]],variableValues: Rep[DenseVector[Double]],weightValues: Rep[DenseVector[Double]])(implicit val __pos: SourceContext) extends DeliteStruct[FactorGraph[F]] {
    val _factF = implicitly[Factor[F]]
    val _mF = implicitly[Manifest[F]]
    val elems = copyTransformedElems(collection.Seq(("_factors",factors),("_variables",variables),("_weights",weights),("_variablesToFactors",variablesToFactors),("_variableValues",variableValues),("_weightValues",weightValues)))
  }



  def factorgraph_object_apply[F:Factor:Manifest](factors: Rep[DenseVector[F]],variables: Rep[DenseVector[RandomVariable]],weights: Rep[DenseVector[Weight]],variablesToFactors: Rep[DenseVector[DenseVector[Int]]],variableValues: Rep[DenseVector[Double]],weightValues: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    reflectPure(FactorGraph12Object_Apply[F](factors,variables,weights,variablesToFactors,variableValues,weightValues)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos))
  }
  def factorgraph_factors[F:Factor:Manifest](self: Rep[FactorGraph[F]])(implicit __pos: SourceContext) = {
    field[DenseVector[F]](self,"_factors")
  }
  def factorgraph_variables[F:Factor:Manifest](self: Rep[FactorGraph[F]])(implicit __pos: SourceContext) = {
    field[DenseVector[RandomVariable]](self,"_variables")
  }
  def factorgraph_weights[F:Factor:Manifest](self: Rep[FactorGraph[F]])(implicit __pos: SourceContext) = {
    field[DenseVector[Weight]](self,"_weights")
  }
  def factorgraph_variablestofactors[F:Factor:Manifest](self: Rep[FactorGraph[F]])(implicit __pos: SourceContext) = {
    field[DenseVector[DenseVector[Int]]](self,"_variablesToFactors")
  }
  def infix_variableValues[F:Factor:Manifest](self: Rep[FactorGraph[F]])(implicit __pos: SourceContext) = {
    field[DenseVector[Double]](self,"_variableValues")
  }
  def infix_weightsValues[F:Factor:Manifest](self: Rep[FactorGraph[F]])(implicit __pos: SourceContext) = {
    field[DenseVector[Double]](self,"_weightValues")
  }
  def factorgraph_getvariablevalue[F:Factor:Manifest](self: Rep[FactorGraph[F]],id: Rep[Int],isPositive: Rep[Boolean] = unit(true))(implicit __pos: SourceContext) = {
    factorgraph_getvariablevalue_impl[F](self,id,isPositive)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)
  }
  def factorgraph_getweightvalue[F:Factor:Manifest](self: Rep[FactorGraph[F]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    factorgraph_getweightvalue_impl[F](self,__arg1)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)
  }
  def factorgraph_updatevariablevalue[F:Factor:Manifest](self: Rep[FactorGraph[F]],id: Rep[Int],newValue: Rep[Double])(implicit __pos: SourceContext) = {
    factorgraph_updatevariablevalue_impl[F](self,id,newValue)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)
  }
  def factorgraph_updatevariablevalues[F:Factor:Manifest](self: Rep[FactorGraph[F]],ids: Rep[DenseVector[Int]],newValues: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    factorgraph_updatevariablevalues_impl[F](self,ids,newValues)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)
  }
  def factorgraph_updateweightvalue[F:Factor:Manifest](self: Rep[FactorGraph[F]],id: Rep[Int],newValue: Rep[Double])(implicit __pos: SourceContext) = {
    factorgraph_updateweightvalue_impl[F](self,id,newValue)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)
  }
  def factorgraph_updateweightvalues[F:Factor:Manifest](self: Rep[FactorGraph[F]],ids: Rep[DenseVector[Int]],newValues: Rep[DenseVector[Double]])(implicit __pos: SourceContext) = {
    factorgraph_updateweightvalues_impl[F](self,ids,newValues)(implicitly[Factor[F]],implicitly[Manifest[F]],__pos)
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@FactorGraph12Object_Apply(__arg0,__arg1,__arg2,__arg3,__arg4,__arg5) => reflectPure(new { override val original = Some(f,mn) } with FactorGraph12Object_Apply(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4),f(__arg5))(facttype(mn._factF),mtype(mn._mF),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@FactorGraph12Object_Apply(__arg0,__arg1,__arg2,__arg3,__arg4,__arg5), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with FactorGraph12Object_Apply(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4),f(__arg5))(facttype(mn._factF),mtype(mn._mF),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[FactorGraph[_]]) Some((classTag(m), collection.immutable.List(("_factors",makeManifest(classOf[DenseVector[_]], List(m.typeArguments(0)))),("_variables",makeManifest(classOf[DenseVector[_]], List(manifest[RandomVariable]))),("_weights",makeManifest(classOf[DenseVector[_]], List(manifest[Weight]))),("_variablesToFactors",makeManifest(classOf[DenseVector[_]], List(manifest[DenseVector[Int]]))),("_variableValues",makeManifest(classOf[DenseVector[_]], List(manifest[Double]))),("_weightValues",makeManifest(classOf[DenseVector[_]], List(manifest[Double]))))))
    else super.unapplyStructType(m)
  }
}

