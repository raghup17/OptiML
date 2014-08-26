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

trait UTriangleWrapper {
  this: OptiMLBase with OptiMLClasses => 

class UTriangle(__N: Int, ___includeDiagonal: Boolean) {
  var N = __N
  var _includeDiagonal = ___includeDiagonal

}

  def utriangle_utriangle(N: Rep[Int],includeDiagonal: Rep[Boolean] = unit(true))(implicit __pos: SourceContext) = {
    new UTriangle(N,includeDiagonal)
  }
  def tri_size(n: Rep[Int])(implicit __pos: SourceContext) = {
    tri_size_impl(n)(__pos)
  }
  def utriangle_n(self: Rep[UTriangle])(implicit __pos: SourceContext) = {
    self.N
  }
  def utriangle_includediagonal(self: Rep[UTriangle])(implicit __pos: SourceContext) = {
    self._includeDiagonal
  }
  def utriangle_size(self: Rep[UTriangle])(implicit __pos: SourceContext) = {
    utriangle_size_impl5(self)(__pos)
  }
  def utriangle_contains(self: Rep[UTriangle],i: Rep[Int],j: Rep[Int])(implicit __pos: SourceContext) = {
    utriangle_contains_impl4(self,i,j)(__pos)
  }
  def utriangle_apply(self: Rep[UTriangle],n: Rep[Int])(implicit __pos: SourceContext) = {
    utriangle_apply_impl13(self,n)(__pos)
  }

}

