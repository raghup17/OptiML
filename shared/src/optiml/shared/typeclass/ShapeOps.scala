package optiml.shared.typeclass

import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._

trait ShapeOps extends Base with scala.math.Numeric.ExtraImplicits {
  this: OptiML => 

  /**
   * Type class
   */
  trait Shape[S] {
    def contains(__arg0: Rep[S],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext): Rep[Boolean]
    def apply(__arg0: Rep[S],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Tup2[Int,Int]]
    def size(__arg0: Rep[S])(implicit __pos: SourceContext): Rep[Int]
  }

  def shtype[A,B](x: Shape[A]) = x.asInstanceOf[Shape[B]]

  /**
   * Type class instances
   */

  implicit def canShapeUTri: Shape[UTriangle] = new Shape[UTriangle] {
    def contains(__arg0: Rep[UTriangle],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext) = {
      __arg0.contains(__arg1,__arg2)
    }
    def apply(__arg0: Rep[UTriangle],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
      __arg0.apply(__arg1)
    }
    def size(__arg0: Rep[UTriangle])(implicit __pos: SourceContext) = {
      __arg0.size
    }
  }


  /**
   * Forwarders - these allow infix notation to be used when the type class is available
   */
  implicit class Shape2ShapeOps[S:Manifest:Shape](self: Rep[S]) {
    def contains(__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext) = shape_contains[S](self,__arg1,__arg2)
    def apply(__arg1: Rep[Int])(implicit __pos: SourceContext) = shape_apply[S](self,__arg1)
    def size()(implicit __pos: SourceContext) = shape_size[S](self)
  }

  def shape_contains[S:Manifest:Shape](__arg0: Rep[S],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext): Rep[Boolean] = implicitly[Shape[S]].contains(__arg0,__arg1,__arg2)
  def shape_apply[S:Manifest:Shape](__arg0: Rep[S],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Tup2[Int,Int]] = implicitly[Shape[S]].apply(__arg0,__arg1)
  def shape_size[S:Manifest:Shape](__arg0: Rep[S])(implicit __pos: SourceContext): Rep[Int] = implicitly[Shape[S]].size(__arg0)
}
