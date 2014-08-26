package optiml.shared.ops

import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._

/**
 * Operations
 */

trait CastOps extends Base {
  this: OptiML => 

  implicit def repToCastAOpsCls[A:Manifest](x: Rep[A])(implicit __pos: SourceContext) = new CastAOpsCls(x)(implicitly[Manifest[A]],__pos)
  implicit def varToCastAOpsCls[A:Manifest](x: Var[A])(implicit __pos: SourceContext) = new CastAOpsCls(readVar(x))(implicitly[Manifest[A]],__pos)

  class CastAOpsCls[A:Manifest](val self: Rep[A])(implicit __pos: SourceContext) {
    def AsInstanceOf[B:Manifest](implicit __pos: SourceContext) = cast_asinstanceof[A,B](self)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos)
    def IsInstanceOf[B:Manifest](implicit __pos: SourceContext) = cast_isinstanceof[A,B](self)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos)
  }



  def cast_asinstanceof[A:Manifest,B:Manifest](__arg0: Rep[A])(implicit __pos: SourceContext): Rep[B]
  def cast_isinstanceof[A:Manifest,B:Manifest](__arg0: Rep[A])(implicit __pos: SourceContext): Rep[Boolean]
}
