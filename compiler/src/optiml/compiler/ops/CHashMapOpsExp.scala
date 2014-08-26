package optiml.compiler.ops

import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import ppl.delite.framework.ops.DeliteCollection
import ppl.delite.framework.datastructures._
import ppl.delite.framework.ops.{DeliteOpsExp, DeliteCollectionOpsExp}
import ppl.delite.framework.Util._
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._
import optiml.compiler._
import optiml.compiler.ops._

/**
 * IR Definitions
 */

trait CHashMapOpsExp extends CHashMapCompilerOps with BaseFatExp with EffectExp {
  this: OptiMLExp => 

  case class CHashMap_CHashMap[K:Manifest,V:Manifest]()(implicit val __pos: SourceContext) extends Def[java.util.concurrent.ConcurrentHashMap[K,V]] {
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]
  }

  case class Chashmap_from_arrays[K:Manifest,V:Manifest](__arg0: Rep[ForgeArray[K]],__arg1: Rep[ForgeArray[V]])(implicit val __pos: SourceContext) extends Def[java.util.concurrent.ConcurrentHashMap[K,V]] {
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]
  }

  case class Chashmap_keys_array[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit val __pos: SourceContext) extends Def[scala.Array[K]] {
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]
  }

  case class Chashmap_values_array[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit val __pos: SourceContext) extends Def[scala.Array[V]] {
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]
  }

  case class CHashMap4_Apply[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]],__arg1: Rep[K])(implicit val __pos: SourceContext) extends Def[V] {
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]
  }

  case class CHashMap1_Update[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]],__arg1: Rep[K],__arg2: Rep[V])(implicit val __pos: SourceContext) extends Def[Unit] {
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]
  }

  case class CHashMap1_Contains[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]],__arg1: Rep[K])(implicit val __pos: SourceContext) extends Def[Boolean] {
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]
  }



  def chashmap_chashmap[K:Manifest,V:Manifest]()(implicit __pos: SourceContext) = {
    reflectMutable(CHashMap_CHashMap[K,V]()(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos))
  }
  def chashmap_from_arrays[K:Manifest,V:Manifest](__arg0: Rep[ForgeArray[K]],__arg1: Rep[ForgeArray[V]])(implicit __pos: SourceContext) = {
    reflectMutable(Chashmap_from_arrays[K,V](__arg0,__arg1)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos))
  }
  def chashmap_keys_array[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext) = {
    reflectPure(Chashmap_keys_array[K,V](__arg0)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos))
  }
  def chashmap_values_array[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext) = {
    reflectPure(Chashmap_values_array[K,V](__arg0)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos))
  }
  def chashmap_apply[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]],__arg1: Rep[K])(implicit __pos: SourceContext) = {
    reflectPure(CHashMap4_Apply[K,V](__arg0,__arg1)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos))
  }
  def chashmap_update[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]],__arg1: Rep[K],__arg2: Rep[V])(implicit __pos: SourceContext) = {
    reflectWrite(__arg0)(CHashMap1_Update[K,V](__arg0,__arg1,__arg2)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos))
  }
  def chashmap_contains[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]],__arg1: Rep[K])(implicit __pos: SourceContext) = {
    reflectPure(CHashMap1_Contains[K,V](__arg0,__arg1)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos))
  }
  def chashmap_keys[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext) = {
    chashmap_keys_impl1[K,V](__arg0)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  }
  def chashmap_values[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext) = {
    chashmap_values_impl1[K,V](__arg0)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@CHashMap_CHashMap() => chashmap_chashmap()(mtype(mn._mK),mtype(mn._mV),mn.__pos)
    case Reflect(mn@CHashMap_CHashMap(), u, es) => reflectMirrored(Reflect(CHashMap_CHashMap()(mtype(mn._mK),mtype(mn._mV),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Chashmap_from_arrays(__arg0,__arg1) => chashmap_from_arrays(f(__arg0),f(__arg1))(mtype(mn._mK),mtype(mn._mV),mn.__pos)
    case Reflect(mn@Chashmap_from_arrays(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Chashmap_from_arrays(f(__arg0),f(__arg1))(mtype(mn._mK),mtype(mn._mV),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Chashmap_keys_array(__arg0) => chashmap_keys_array(f(__arg0))(mtype(mn._mK),mtype(mn._mV),mn.__pos)
    case Reflect(mn@Chashmap_keys_array(__arg0), u, es) => reflectMirrored(Reflect(Chashmap_keys_array(f(__arg0))(mtype(mn._mK),mtype(mn._mV),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Chashmap_values_array(__arg0) => chashmap_values_array(f(__arg0))(mtype(mn._mK),mtype(mn._mV),mn.__pos)
    case Reflect(mn@Chashmap_values_array(__arg0), u, es) => reflectMirrored(Reflect(Chashmap_values_array(f(__arg0))(mtype(mn._mK),mtype(mn._mV),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@CHashMap4_Apply(__arg0,__arg1) => chashmap_apply(f(__arg0),f(__arg1))(mtype(mn._mK),mtype(mn._mV),mn.__pos)
    case Reflect(mn@CHashMap4_Apply(__arg0,__arg1), u, es) => reflectMirrored(Reflect(CHashMap4_Apply(f(__arg0),f(__arg1))(mtype(mn._mK),mtype(mn._mV),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@CHashMap1_Update(__arg0,__arg1,__arg2) => chashmap_update(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mK),mtype(mn._mV),mn.__pos)
    case Reflect(mn@CHashMap1_Update(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(CHashMap1_Update(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mK),mtype(mn._mV),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@CHashMap1_Contains(__arg0,__arg1) => chashmap_contains(f(__arg0),f(__arg1))(mtype(mn._mK),mtype(mn._mV),mn.__pos)
    case Reflect(mn@CHashMap1_Contains(__arg0,__arg1), u, es) => reflectMirrored(Reflect(CHashMap1_Contains(f(__arg0),f(__arg1))(mtype(mn._mK),mtype(mn._mV),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


}

/**
 * Code generators
 */

trait ScalaGenCHashMapOps extends ScalaGenFat {
  val IR: CHashMapOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@CHashMap_CHashMap() => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("new java.util.concurrent.ConcurrentHashMap["+remap(mn._mK)+","+remap(mn._mV)+"]()")
      stream.println("}")

    case mn@Chashmap_from_arrays(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("val map = new java.util.concurrent.ConcurrentHashMap["+remap(mn._mK)+","+remap(mn._mV)+"]()\nfor (i <- 0 until "+quote(__arg0)+".length) {\n  map.put("+quote(__arg0)+"(i),"+quote(__arg1)+"(i))\n}\nmap")
      stream.println("}")

    case mn@Chashmap_keys_array(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("scala.collection.JavaConverters.enumerationAsScalaIteratorConverter("+quote(__arg0)+".keys).asScala.toArray")
      stream.println("}")

    case mn@Chashmap_values_array(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("scala.collection.JavaConverters.collectionAsScalaIterableConverter("+quote(__arg0)+".values).asScala.toArray")
      stream.println("}")

    case mn@CHashMap4_Apply(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".get("+quote(__arg1)+")")
      stream.println("}")

    case mn@CHashMap1_Update(__arg0,__arg1,__arg2) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".put("+quote(__arg1)+","+quote(__arg2)+"); ()")
      stream.println("}")

    case mn@CHashMap1_Contains(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".contains("+quote(__arg1)+")")
      stream.println("}")

    case _ => super.emitNode(sym, rhs)
  }
}
