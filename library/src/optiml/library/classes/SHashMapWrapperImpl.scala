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

trait SHashMapWrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def shashmap_keys_impl2[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext): Rep[ForgeArray[K]] = {
    farray_from_sarray(shashmap_keys_array(__arg0))
  }

  def shashmap_values_impl2[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext): Rep[ForgeArray[V]] = {
    farray_from_sarray(shashmap_values_array(__arg0))
  }

}
