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

trait SHashMapWrapper {
  this: OptiMLBase with OptiMLClasses => 

  def shashmap_shashmap[K:Manifest,V:Manifest]()(implicit __pos: SourceContext) = {
    new scala.collection.mutable.HashMap[K,V]()
  }
  def shashmap_from_arrays[K:Manifest,V:Manifest](__arg0: Rep[ForgeArray[K]],__arg1: Rep[ForgeArray[V]])(implicit __pos: SourceContext) = {
    scala.collection.mutable.HashMap(__arg0.zip(__arg1): _*)
  }
  def shashmap_keys_array[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext) = {
    __arg0.keys.toArray
  }
  def shashmap_values_array[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext) = {
    __arg0.values.toArray
  }
  def shashmap_apply[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]],__arg1: Rep[K])(implicit __pos: SourceContext) = {
    __arg0(__arg1)
  }
  def shashmap_update[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]],__arg1: Rep[K],__arg2: Rep[V])(implicit __pos: SourceContext) = {
    __arg0.put(__arg1,__arg2); ()
  }
  def shashmap_contains[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]],__arg1: Rep[K])(implicit __pos: SourceContext) = {
    __arg0.contains(__arg1)
  }
  def shashmap_keys[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext) = {
    shashmap_keys_impl2[K,V](__arg0)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  }
  def shashmap_values[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext) = {
    shashmap_values_impl2[K,V](__arg0)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  }

}

