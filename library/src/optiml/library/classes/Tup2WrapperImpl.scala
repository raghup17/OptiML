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

trait Tup2WrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def tup2_unpack_impl1[A:Manifest,B:Manifest](t: Rep[Tup2[A,B]])(implicit __pos: SourceContext): Tuple2[Rep[A],Rep[B]] = {
    ((tup2__1(t),tup2__2(t)))
  }

  def tup2_pack_impl1[A:Manifest,B:Manifest](t: Tuple2[Rep[A],Rep[B]])(implicit __pos: SourceContext): Rep[Tup2[A,B]] = {
    internal_pack2(t._1,t._2)
  }

  def tup2_tostring_impl2[A:Manifest,B:Manifest](t: Rep[Tup2[A,B]]): Rep[String] = {
    "("+t._1+","+t._2+")"
  }

}
