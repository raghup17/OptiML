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

trait CHashMapWrapper {
  this: OptiMLBase with OptiMLClasses => 

  def chashmap_chashmap[K:Manifest,V:Manifest]()(implicit __pos: SourceContext) = {
    new java.util.concurrent.ConcurrentHashMap[K,V]()
  }
  def chashmap_from_arrays[K:Manifest,V:Manifest](__arg0: Rep[ForgeArray[K]],__arg1: Rep[ForgeArray[V]])(implicit __pos: SourceContext) = {
    val map = new java.util.concurrent.ConcurrentHashMap[K,V]()
    for (i <- 0 until __arg0.length) {
      map.put(__arg0(i),__arg1(i))
    }
    map
  }
  def chashmap_keys_array[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext) = {
    scala.collection.JavaConverters.enumerationAsScalaIteratorConverter(__arg0.keys).asScala.toArray
  }
  def chashmap_values_array[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext) = {
    scala.collection.JavaConverters.collectionAsScalaIterableConverter(__arg0.values).asScala.toArray
  }
  def chashmap_apply[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]],__arg1: Rep[K])(implicit __pos: SourceContext) = {
    __arg0.get(__arg1)
  }
  def chashmap_update[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]],__arg1: Rep[K],__arg2: Rep[V])(implicit __pos: SourceContext) = {
    __arg0.put(__arg1,__arg2); ()
  }
  def chashmap_contains[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]],__arg1: Rep[K])(implicit __pos: SourceContext) = {
    __arg0.contains(__arg1)
  }
  def chashmap_keys[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext) = {
    chashmap_keys_impl1[K,V](__arg0)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  }
  def chashmap_values[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext) = {
    chashmap_values_impl1[K,V](__arg0)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  }

}

