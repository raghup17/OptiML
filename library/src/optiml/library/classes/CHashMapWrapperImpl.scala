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

trait CHashMapWrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def chashmap_keys_impl1[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext): Rep[ForgeArray[K]] = {
    farray_from_sarray(chashmap_keys_array(__arg0))
  }

  def chashmap_values_impl1[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext): Rep[ForgeArray[V]] = {
    farray_from_sarray(chashmap_values_array(__arg0))
  }

}
