package optiml.library.classes

import scala.reflect.{Manifest,SourceContext}
import scala.math.Ordering.Implicits._
import scala.math.Numeric.Implicits._
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._
import optiml.library._
import optiml.library.classes._

trait RandWrapper {
  this: OptiMLBase with OptiMLClasses => 

  def rand_random[A:Manifest]()(implicit __pos: SourceContext) = {
    rand_random_impl[A]()(implicitly[Manifest[A]],__pos)
  }
  def rand_randomelem[A:Manifest](__arg0: Rep[DenseVector[A]])(implicit __pos: SourceContext) = {
    rand_randomelem_impl[A](__arg0)(implicitly[Manifest[A]],__pos)
  }
  def rand_randomint(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    Global.randRef.nextInt(__arg0)
  }
  def rand_randomgaussian()(implicit __pos: SourceContext) = {
    Global.randRef.nextGaussian()
  }
  def rand_reseed()(implicit __pos: SourceContext) = {
    Global.randRef.setSeed(Global.INITIAL_SEED)
  }
  def optila_rand_double()(implicit __pos: SourceContext) = {
    Global.randRef.nextDouble()
  }
  def optila_rand_float()(implicit __pos: SourceContext) = {
    Global.randRef.nextFloat()
  }
  def optila_rand_int()(implicit __pos: SourceContext) = {
    Global.randRef.nextInt()
  }
  def optila_rand_boolean()(implicit __pos: SourceContext) = {
    Global.randRef.nextBoolean()
  }
  def rand_shuffle(__arg0: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = {
    rand_shuffle_impl1(__arg0)(__pos)
  }
  def rand_shuffle[A:Manifest](__arg0: Rep[DenseVector[A]])(implicit __pos: SourceContext,__imp1: Overload2) = {
    rand_shuffle_impl2[A](__arg0)(implicitly[Manifest[A]],__pos)
  }
  def rand_shuffle[A:Manifest](__arg0: Rep[DenseMatrix[A]])(implicit __pos: SourceContext,__imp1: Overload3) = {
    rand_shuffle_impl3[A](__arg0)(implicitly[Manifest[A]],__pos)
  }
  def optila_shuffle_array[A:Manifest](__arg0: Rep[ForgeArray[A]])(implicit __pos: SourceContext) = {
    optila_shuffle_array_impl[A](__arg0)(implicitly[Manifest[A]],__pos)
  }

}

