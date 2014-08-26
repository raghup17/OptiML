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

trait Tup3WrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def tup3_unpack_impl6[A:Manifest,B:Manifest,C:Manifest](t: Rep[Tup3[A,B,C]])(implicit __pos: SourceContext): Tuple3[Rep[A],Rep[B],Rep[C]] = {
    ((tup3__1(t),tup3__2(t),tup3__3(t)))
  }

  def tup3_pack_impl9[A:Manifest,B:Manifest,C:Manifest](t: Tuple3[Rep[A],Rep[B],Rep[C]])(implicit __pos: SourceContext): Rep[Tup3[A,B,C]] = {
    internal_pack3(t._1,t._2,t._3)
  }

  def tup3_tostring_impl10[A:Manifest,B:Manifest,C:Manifest](t: Rep[Tup3[A,B,C]]): Rep[String] = {
    "("+t._1+","+t._2+","+t._3+")"
  }

}
