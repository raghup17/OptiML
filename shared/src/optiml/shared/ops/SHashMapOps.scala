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

trait SHashMapOps extends Base {
  this: OptiML => 

  def SHashMap[K:Manifest,V:Manifest]()(implicit __pos: SourceContext) = shashmap_shashmap[K,V]()(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)

  implicit def repToSHashMapscalacollectionmutableHashMapOpsCls[K:Manifest,V:Manifest](x: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext) = new SHashMapscalacollectionmutableHashMapOpsCls(x)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  implicit def varToSHashMapscalacollectionmutableHashMapOpsCls[K:Manifest,V:Manifest](x: Var[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext) = new SHashMapscalacollectionmutableHashMapOpsCls(readVar(x))(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)

  class SHashMapscalacollectionmutableHashMapOpsCls[K:Manifest,V:Manifest](val self: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext) {
    def apply(__arg1: Rep[K])(implicit __pos: SourceContext,__imp1: Overload15) = shashmap_apply[K,V](self,__arg1)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
    def update(__arg1: Rep[K],__arg2: Rep[V])(implicit __pos: SourceContext,__imp1: Overload5) = shashmap_update[K,V](self,__arg1,__arg2)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  }


  def infix_contains[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]],__arg1: Rep[K])(implicit __pos: SourceContext,__imp1: Overload6) = shashmap_contains[K,V](__arg0,__arg1)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  def infix_keys[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext,__imp1: Overload2) = shashmap_keys[K,V](__arg0)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  def infix_values[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext,__imp1: Overload2) = shashmap_values[K,V](__arg0)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)

  def shashmap_shashmap[K:Manifest,V:Manifest]()(implicit __pos: SourceContext): Rep[scala.collection.mutable.HashMap[K,V]]
  def shashmap_apply[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]],__arg1: Rep[K])(implicit __pos: SourceContext): Rep[V]
  def shashmap_update[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]],__arg1: Rep[K],__arg2: Rep[V])(implicit __pos: SourceContext): Rep[Unit]
  def shashmap_contains[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]],__arg1: Rep[K])(implicit __pos: SourceContext): Rep[Boolean]
  def shashmap_keys[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext): Rep[ForgeArray[K]]
  def shashmap_values[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext): Rep[ForgeArray[V]]
}
trait SHashMapCompilerOps extends SHashMapOps {
  this: OptiML => 

  def shashmap_from_arrays[K:Manifest,V:Manifest](__arg0: Rep[ForgeArray[K]],__arg1: Rep[ForgeArray[V]])(implicit __pos: SourceContext): Rep[scala.collection.mutable.HashMap[K,V]]
  def shashmap_keys_array[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext): Rep[scala.Array[K]]
  def shashmap_values_array[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext): Rep[scala.Array[V]]
}

