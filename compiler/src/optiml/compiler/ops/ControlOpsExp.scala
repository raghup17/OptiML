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

trait ControlOpsExp extends ControlOps with BaseFatExp with EffectExp {
  this: OptiMLExp => 



  def control_untilconverged[T:Manifest](x: Rep[T],tol: Rep[Double] = unit(.001),minIter: Rep[Int] = unit(1),maxIter: Rep[Int] = unit(1000),block: (Rep[T]) => Rep[T])(implicit __pos: SourceContext,diff: (Rep[T],Rep[T]) => Rep[Double]) = {
    control_untilconverged_impl[T](x,tol,minIter,maxIter,block)(implicitly[Manifest[T]],__pos,diff)
  }
  def control_untilconverged_buffered[T:Bufferable:Manifest](x: Rep[T],tol: Rep[Double] = unit(.001),minIter: Rep[Int] = unit(1),maxIter: Rep[Int] = unit(1000),block: (Rep[T]) => Rep[T])(implicit __pos: SourceContext,diff: (Rep[T],Rep[T]) => Rep[Double]) = {
    control_untilconverged_buffered_impl[T](x,tol,minIter,maxIter,block)(implicitly[Bufferable[T]],implicitly[Manifest[T]],__pos,diff)
  }

  /**
   * Syms
   */
  override def syms(e: Any): List[Sym[Any]] = e match {
    case _ => super.syms(e)
  }
  override def boundSyms(e: Any): List[Sym[Any]] = e match {
    case _ => super.boundSyms(e)
  }
  override def symsFreq(e: Any): List[(Sym[Any], Double)] = e match {
    case _ => super.symsFreq(e)
  }


  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


}

