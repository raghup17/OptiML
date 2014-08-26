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

trait UTriangleOps extends Base {
  this: OptiML => 

  def utriangle(N: Rep[Int],includeDiagonal: Rep[Boolean] = unit(true))(implicit __pos: SourceContext) = utriangle_utriangle(N,includeDiagonal)(__pos)

  implicit def repToUTriangleUTriangleOpsCls(x: Rep[UTriangle])(implicit __pos: SourceContext) = new UTriangleUTriangleOpsCls(x)(__pos)
  implicit def varToUTriangleUTriangleOpsCls(x: Var[UTriangle])(implicit __pos: SourceContext) = new UTriangleUTriangleOpsCls(readVar(x))(__pos)

  class UTriangleUTriangleOpsCls(val self: Rep[UTriangle])(implicit __pos: SourceContext) {
    def apply(n: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload13) = utriangle_apply(self,n)(__pos)
  }


  def infix_N(self: Rep[UTriangle])(implicit __pos: SourceContext) = utriangle_n(self)(__pos)
  def infix_includeDiagonal(self: Rep[UTriangle])(implicit __pos: SourceContext) = utriangle_includediagonal(self)(__pos)
  def infix_size(self: Rep[UTriangle])(implicit __pos: SourceContext,__imp1: Overload5) = utriangle_size(self)(__pos)
  def infix_contains(self: Rep[UTriangle],i: Rep[Int],j: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload4) = utriangle_contains(self,i,j)(__pos)

  def utriangle_utriangle(N: Rep[Int],includeDiagonal: Rep[Boolean] = unit(true))(implicit __pos: SourceContext): Rep[UTriangle]
  def utriangle_n(self: Rep[UTriangle])(implicit __pos: SourceContext): Rep[Int]
  def utriangle_includediagonal(self: Rep[UTriangle])(implicit __pos: SourceContext): Rep[Boolean]
  def utriangle_size(self: Rep[UTriangle])(implicit __pos: SourceContext): Rep[Int]
  def utriangle_contains(self: Rep[UTriangle],i: Rep[Int],j: Rep[Int])(implicit __pos: SourceContext): Rep[Boolean]
  def utriangle_apply(self: Rep[UTriangle],n: Rep[Int])(implicit __pos: SourceContext): Rep[Tup2[Int,Int]]
}
trait UTriangleCompilerOps extends UTriangleOps {
  this: OptiML => 

  def tri_size(n: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
}

