package optiml.compiler.ops

import scala.reflect.{Manifest,SourceContext}
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._
import optiml.compiler._
import optiml.compiler.ops._

/**
 * Op Impls
 */

trait UTriangleOpsImpl {
  this: OptiMLCompiler with OptiMLLift => 

  def tri_size_impl(n: Rep[Int])(implicit __pos: SourceContext): Rep[Int] = {
    n*(n+1)/2
  }

  def utriangle_size_impl5(self: Rep[UTriangle])(implicit __pos: SourceContext): Rep[Int] = {
    val total = tri_size(self.N)
    if (self.includeDiagonal) total else total - 1
  }

  def utriangle_contains_impl4(self: Rep[UTriangle],i: Rep[Int],j: Rep[Int])(implicit __pos: SourceContext): Rep[Boolean] = {
    if (self.includeDiagonal) {
      i < self.N && i <= j
    }
    else {
      i < self.N && i < j
    }
  }

  def utriangle_apply_impl13(self: Rep[UTriangle],n: Rep[Int])(implicit __pos: SourceContext): Rep[Tup2[Int,Int]] = {
    val m = if (self.includeDiagonal) self.N else self.N-1
    val off = if (self.includeDiagonal) 0 else 1
    val t = tri_size(m)-1-n
    val k = floor((sqrt(8*t+1)-1)/2)
    val row = m-1-k
    pack((row, (n+tri_size(row))%m+off))
  }

}
