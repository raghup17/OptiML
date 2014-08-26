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

trait SHashMapOpsExp extends SHashMapCompilerOps with BaseFatExp with EffectExp {
  this: OptiMLExp => 

  case class SHashMap_SHashMap[K:Manifest,V:Manifest]()(implicit val __pos: SourceContext) extends Def[scala.collection.mutable.HashMap[K,V]] {
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]
  }

  case class Shashmap_from_arrays[K:Manifest,V:Manifest](__arg0: Rep[ForgeArray[K]],__arg1: Rep[ForgeArray[V]])(implicit val __pos: SourceContext) extends Def[scala.collection.mutable.HashMap[K,V]] {
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]
  }

  case class Shashmap_keys_array[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit val __pos: SourceContext) extends Def[scala.Array[K]] {
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]
  }

  case class Shashmap_values_array[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit val __pos: SourceContext) extends Def[scala.Array[V]] {
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]
  }

  case class SHashMap15_Apply[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]],__arg1: Rep[K])(implicit val __pos: SourceContext) extends Def[V] {
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]
  }

  case class SHashMap5_Update[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]],__arg1: Rep[K],__arg2: Rep[V])(implicit val __pos: SourceContext) extends Def[Unit] {
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]
  }

  case class SHashMap6_Contains[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]],__arg1: Rep[K])(implicit val __pos: SourceContext) extends Def[Boolean] {
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]
  }



  def shashmap_shashmap[K:Manifest,V:Manifest]()(implicit __pos: SourceContext) = {
    reflectMutable(SHashMap_SHashMap[K,V]()(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos))
  }
  def shashmap_from_arrays[K:Manifest,V:Manifest](__arg0: Rep[ForgeArray[K]],__arg1: Rep[ForgeArray[V]])(implicit __pos: SourceContext) = {
    reflectMutable(Shashmap_from_arrays[K,V](__arg0,__arg1)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos))
  }
  def shashmap_keys_array[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext) = {
    reflectPure(Shashmap_keys_array[K,V](__arg0)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos))
  }
  def shashmap_values_array[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext) = {
    reflectPure(Shashmap_values_array[K,V](__arg0)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos))
  }
  def shashmap_apply[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]],__arg1: Rep[K])(implicit __pos: SourceContext) = {
    reflectPure(SHashMap15_Apply[K,V](__arg0,__arg1)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos))
  }
  def shashmap_update[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]],__arg1: Rep[K],__arg2: Rep[V])(implicit __pos: SourceContext) = {
    reflectWrite(__arg0)(SHashMap5_Update[K,V](__arg0,__arg1,__arg2)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos))
  }
  def shashmap_contains[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]],__arg1: Rep[K])(implicit __pos: SourceContext) = {
    reflectPure(SHashMap6_Contains[K,V](__arg0,__arg1)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos))
  }
  def shashmap_keys[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext) = {
    shashmap_keys_impl2[K,V](__arg0)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  }
  def shashmap_values[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext) = {
    shashmap_values_impl2[K,V](__arg0)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@SHashMap_SHashMap() => shashmap_shashmap()(mtype(mn._mK),mtype(mn._mV),mn.__pos)
    case Reflect(mn@SHashMap_SHashMap(), u, es) => reflectMirrored(Reflect(SHashMap_SHashMap()(mtype(mn._mK),mtype(mn._mV),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Shashmap_from_arrays(__arg0,__arg1) => shashmap_from_arrays(f(__arg0),f(__arg1))(mtype(mn._mK),mtype(mn._mV),mn.__pos)
    case Reflect(mn@Shashmap_from_arrays(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Shashmap_from_arrays(f(__arg0),f(__arg1))(mtype(mn._mK),mtype(mn._mV),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Shashmap_keys_array(__arg0) => shashmap_keys_array(f(__arg0))(mtype(mn._mK),mtype(mn._mV),mn.__pos)
    case Reflect(mn@Shashmap_keys_array(__arg0), u, es) => reflectMirrored(Reflect(Shashmap_keys_array(f(__arg0))(mtype(mn._mK),mtype(mn._mV),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Shashmap_values_array(__arg0) => shashmap_values_array(f(__arg0))(mtype(mn._mK),mtype(mn._mV),mn.__pos)
    case Reflect(mn@Shashmap_values_array(__arg0), u, es) => reflectMirrored(Reflect(Shashmap_values_array(f(__arg0))(mtype(mn._mK),mtype(mn._mV),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SHashMap15_Apply(__arg0,__arg1) => shashmap_apply(f(__arg0),f(__arg1))(mtype(mn._mK),mtype(mn._mV),mn.__pos)
    case Reflect(mn@SHashMap15_Apply(__arg0,__arg1), u, es) => reflectMirrored(Reflect(SHashMap15_Apply(f(__arg0),f(__arg1))(mtype(mn._mK),mtype(mn._mV),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SHashMap5_Update(__arg0,__arg1,__arg2) => shashmap_update(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mK),mtype(mn._mV),mn.__pos)
    case Reflect(mn@SHashMap5_Update(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(SHashMap5_Update(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mK),mtype(mn._mV),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SHashMap6_Contains(__arg0,__arg1) => shashmap_contains(f(__arg0),f(__arg1))(mtype(mn._mK),mtype(mn._mV),mn.__pos)
    case Reflect(mn@SHashMap6_Contains(__arg0,__arg1), u, es) => reflectMirrored(Reflect(SHashMap6_Contains(f(__arg0),f(__arg1))(mtype(mn._mK),mtype(mn._mV),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


}

/**
 * Code generators
 */

trait ScalaGenSHashMapOps extends ScalaGenFat {
  val IR: SHashMapOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@SHashMap_SHashMap() => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("new scala.collection.mutable.HashMap["+remap(mn._mK)+","+remap(mn._mV)+"]()")
      stream.println("}")

    case mn@Shashmap_from_arrays(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("scala.collection.mutable.HashMap("+quote(__arg0)+".zip("+quote(__arg1)+"): _*)")
      stream.println("}")

    case mn@Shashmap_keys_array(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".keys.toArray")
      stream.println("}")

    case mn@Shashmap_values_array(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".values.toArray")
      stream.println("}")

    case mn@SHashMap15_Apply(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+"("+quote(__arg1)+")")
      stream.println("}")

    case mn@SHashMap5_Update(__arg0,__arg1,__arg2) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".put("+quote(__arg1)+","+quote(__arg2)+"); ()")
      stream.println("}")

    case mn@SHashMap6_Contains(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".contains("+quote(__arg1)+")")
      stream.println("}")

    case _ => super.emitNode(sym, rhs)
  }
}
