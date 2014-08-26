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

trait RandOps extends Base {
  this: OptiML => 

  def random[A:Manifest](implicit __pos: SourceContext) = rand_random[A]()(implicitly[Manifest[A]],__pos)
  def randomElem[A:Manifest](__arg0: Rep[DenseVector[A]])(implicit __pos: SourceContext) = rand_randomelem[A](__arg0)(implicitly[Manifest[A]],__pos)
  def randomInt(__arg0: Rep[Int])(implicit __pos: SourceContext) = rand_randomint(__arg0)(__pos)
  def randomGaussian()(implicit __pos: SourceContext) = rand_randomgaussian()(__pos)
  def reseed()(implicit __pos: SourceContext) = rand_reseed()(__pos)
  def shuffle(__arg0: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = rand_shuffle(__arg0)(__pos,overload1)
  def shuffle[A:Manifest](__arg0: Rep[DenseVector[A]])(implicit __pos: SourceContext,__imp1: Overload2) = rand_shuffle[A](__arg0)(implicitly[Manifest[A]],__pos,overload2)
  def shuffle[A:Manifest](__arg0: Rep[DenseMatrix[A]])(implicit __pos: SourceContext,__imp1: Overload3) = rand_shuffle[A](__arg0)(implicitly[Manifest[A]],__pos,overload3)


  def rand_random[A:Manifest]()(implicit __pos: SourceContext): Rep[A]
  def rand_randomelem[A:Manifest](__arg0: Rep[DenseVector[A]])(implicit __pos: SourceContext): Rep[A]
  def rand_randomint(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def rand_randomgaussian()(implicit __pos: SourceContext): Rep[Double]
  def rand_reseed()(implicit __pos: SourceContext): Rep[Unit]
  def rand_shuffle(__arg0: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1): Rep[IndexVector]
  def rand_shuffle[A:Manifest](__arg0: Rep[DenseVector[A]])(implicit __pos: SourceContext,__imp1: Overload2): Rep[DenseVector[A]]
  def rand_shuffle[A:Manifest](__arg0: Rep[DenseMatrix[A]])(implicit __pos: SourceContext,__imp1: Overload3): Rep[DenseMatrix[A]]
}
trait RandCompilerOps extends RandOps {
  this: OptiML => 

  def optila_rand_double()(implicit __pos: SourceContext): Rep[Double]
  def optila_rand_float()(implicit __pos: SourceContext): Rep[Float]
  def optila_rand_int()(implicit __pos: SourceContext): Rep[Int]
  def optila_rand_boolean()(implicit __pos: SourceContext): Rep[Boolean]
  def optila_shuffle_array[A:Manifest](__arg0: Rep[ForgeArray[A]])(implicit __pos: SourceContext): Rep[ForgeArray[A]]
}

