package optiml.library.classes

import scala.reflect.{Manifest,SourceContext}
import scala.math.Ordering.Implicits._
import scala.math.Numeric.Implicits._
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._
import optiml.library._
import optiml.library.classes._

/**
 * SingleTask and Composite Impls
 */

trait ControlWrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def control_untilconverged_impl[T:Manifest](x: Rep[T],tol: Rep[Double] = unit(.001),minIter: Rep[Int] = unit(1),maxIter: Rep[Int] = unit(1000),block: (Rep[T]) => Rep[T])(implicit __pos: SourceContext,diff: (Rep[T],Rep[T]) => Rep[Double]): Rep[T] = {
    var delta = scala.Double.MaxValue
    var cur = x
    var iter = 0
    
    while ((abs(delta) > tol && iter < maxIter) || iter < minIter) {
      val prev = cur
      val next = block(cur)
      iter += 1
      delta = diff(prev,next)
      cur = next
    }
    
    if (iter == maxIter){
      println("Maximum iterations exceeded")
    }
    
    cur
  }

  def control_untilconverged_buffered_impl[T:Bufferable:Manifest](x: Rep[T],tol: Rep[Double] = unit(.001),minIter: Rep[Int] = unit(1),maxIter: Rep[Int] = unit(1000),block: (Rep[T]) => Rep[T])(implicit __pos: SourceContext,diff: (Rep[T],Rep[T]) => Rep[Double]): Rep[T] = {
    val bufA = x.mutable
    val bufB = x.mutable
    
    x.write(bufA)
    
    var delta = scala.Double.MaxValue
    var iter = 0
    
    while ((abs(delta) > tol && iter < maxIter) || iter < minIter) {
      
      
      val cur = block(bufA.unsafeImmutable)
    
      
      
      
      
      
    
      cur.write(bufB)
      delta = diff(bufA,bufB)
    
      
      
      
      bufB.write(bufA)
    
      iter += 1
    }
    
    if (iter == maxIter){
      println("Maximum iterations exceeded")
    }
    
    bufA
  }

}
