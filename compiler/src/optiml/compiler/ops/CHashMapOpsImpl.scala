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

trait CHashMapOpsImpl {
  this: OptiMLCompiler with OptiMLLift => 

  def chashmap_keys_impl1[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext): Rep[ForgeArray[K]] = {
    farray_from_sarray(chashmap_keys_array(__arg0))
  }

  def chashmap_values_impl1[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext): Rep[ForgeArray[V]] = {
    farray_from_sarray(chashmap_values_array(__arg0))
  }

}
