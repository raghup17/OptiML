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

trait Tup6OpsImpl {
  this: OptiMLCompiler with OptiMLLift => 

  def tup6_unpack_impl5[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Rep[Tup6[A,B,C,D,E,F]])(implicit __pos: SourceContext): Tuple6[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F]] = {
    ((tup6__1(t),tup6__2(t),tup6__3(t),tup6__4(t),tup6__5(t),tup6__6(t)))
  }

  def tup6_pack_impl8[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Tuple6[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F]])(implicit __pos: SourceContext): Rep[Tup6[A,B,C,D,E,F]] = {
    internal_pack6(t._1,t._2,t._3,t._4,t._5,t._6)
  }

  def tup6_tostring_impl8[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Rep[Tup6[A,B,C,D,E,F]]): Rep[String] = {
    "("+t._1+","+t._2+","+t._3+","+t._4+","+t._5+","+t._6+")"
  }

}
