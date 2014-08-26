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

trait RandWrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def rand_random_impl[A:Manifest]()(implicit __pos: SourceContext): Rep[A] = {
    val mA = manifest[A]
    mA match {
      case Manifest.Double => optila_rand_double.AsInstanceOf[A]
      case Manifest.Float => optila_rand_float.AsInstanceOf[A]
      case Manifest.Int => optila_rand_int.AsInstanceOf[A]
      case Manifest.Boolean => optila_rand_boolean.AsInstanceOf[A]
      case _ => sys.error("no random implementation available for type " + mA.toString)
    }
  }

  def rand_randomelem_impl[A:Manifest](__arg0: Rep[DenseVector[A]])(implicit __pos: SourceContext): Rep[A] = {
    __arg0(randomInt(__arg0.length))
  }

  def rand_shuffle_impl1(__arg0: Rep[IndexVector])(implicit __pos: SourceContext): Rep[IndexVector] = {
    indexvector_fromarray(densevector_raw_data(shuffle(__arg0.toDense)), __arg0.isRow)
  }

  def rand_shuffle_impl2[A:Manifest](__arg0: Rep[DenseVector[A]])(implicit __pos: SourceContext): Rep[DenseVector[A]] = {
    val v2 = __arg0.mutable
    v2.trim()
    val a = optila_shuffle_array(densevector_raw_data(v2))
    densevector_fromarray(a, __arg0.isRow)
  }

  def rand_shuffle_impl3[A:Manifest](__arg0: Rep[DenseMatrix[A]])(implicit __pos: SourceContext): Rep[DenseMatrix[A]] = {
    val m2 = __arg0.mutable
    m2.trim()
    val a = optila_shuffle_array(densematrix_raw_data(m2))
    densematrix_fromarray(a, __arg0.numRows, __arg0.numCols)
  }

  def optila_shuffle_array_impl[A:Manifest](__arg0: Rep[ForgeArray[A]])(implicit __pos: SourceContext): Rep[ForgeArray[A]] = {
    val len = array_length(__arg0)
    val out = array_empty[A](len)
    array_copy(__arg0, 0, out, 0, len)
    
    var i = len-1
    while (i > 1) {
      val swap = randomInt(i+1)
      val a = array_apply(out,i)
      array_update(out,i,array_apply(out,swap))
      array_update(out,swap,a)
      i -= 1
    }
    
    out.unsafeImmutable
  }

}
