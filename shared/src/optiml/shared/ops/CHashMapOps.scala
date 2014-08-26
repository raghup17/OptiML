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

trait CHashMapOps extends Base {
  this: OptiML => 

  def CHashMap[K:Manifest,V:Manifest]()(implicit __pos: SourceContext) = chashmap_chashmap[K,V]()(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)

  implicit def repToCHashMapjavautilconcurrentConcurrentHashMapOpsCls[K:Manifest,V:Manifest](x: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext) = new CHashMapjavautilconcurrentConcurrentHashMapOpsCls(x)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  implicit def varToCHashMapjavautilconcurrentConcurrentHashMapOpsCls[K:Manifest,V:Manifest](x: Var[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext) = new CHashMapjavautilconcurrentConcurrentHashMapOpsCls(readVar(x))(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)

  class CHashMapjavautilconcurrentConcurrentHashMapOpsCls[K:Manifest,V:Manifest](val self: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext) {
    def apply(__arg1: Rep[K])(implicit __pos: SourceContext,__imp1: Overload4) = chashmap_apply[K,V](self,__arg1)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
    def update(__arg1: Rep[K],__arg2: Rep[V])(implicit __pos: SourceContext,__imp1: Overload1) = chashmap_update[K,V](self,__arg1,__arg2)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  }


  def infix_contains[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]],__arg1: Rep[K])(implicit __pos: SourceContext,__imp1: Overload1) = chashmap_contains[K,V](__arg0,__arg1)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  def infix_keys[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext,__imp1: Overload1) = chashmap_keys[K,V](__arg0)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  def infix_values[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext,__imp1: Overload1) = chashmap_values[K,V](__arg0)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)

  def chashmap_chashmap[K:Manifest,V:Manifest]()(implicit __pos: SourceContext): Rep[java.util.concurrent.ConcurrentHashMap[K,V]]
  def chashmap_apply[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]],__arg1: Rep[K])(implicit __pos: SourceContext): Rep[V]
  def chashmap_update[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]],__arg1: Rep[K],__arg2: Rep[V])(implicit __pos: SourceContext): Rep[Unit]
  def chashmap_contains[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]],__arg1: Rep[K])(implicit __pos: SourceContext): Rep[Boolean]
  def chashmap_keys[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext): Rep[ForgeArray[K]]
  def chashmap_values[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext): Rep[ForgeArray[V]]
}
trait CHashMapCompilerOps extends CHashMapOps {
  this: OptiML => 

  def chashmap_from_arrays[K:Manifest,V:Manifest](__arg0: Rep[ForgeArray[K]],__arg1: Rep[ForgeArray[V]])(implicit __pos: SourceContext): Rep[java.util.concurrent.ConcurrentHashMap[K,V]]
  def chashmap_keys_array[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext): Rep[scala.Array[K]]
  def chashmap_values_array[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext): Rep[scala.Array[V]]
}

