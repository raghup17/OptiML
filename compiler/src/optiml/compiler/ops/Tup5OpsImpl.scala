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

trait Tup5OpsImpl {
  this: OptiMLCompiler with OptiMLLift => 

  def tup5_unpack_impl8[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Rep[Tup5[A,B,C,D,E]])(implicit __pos: SourceContext): Tuple5[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E]] = {
    ((tup5__1(t),tup5__2(t),tup5__3(t),tup5__4(t),tup5__5(t)))
  }

  def tup5_pack_impl11[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Tuple5[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E]])(implicit __pos: SourceContext): Rep[Tup5[A,B,C,D,E]] = {
    internal_pack5(t._1,t._2,t._3,t._4,t._5)
  }

  def tup5_tostring_impl13[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Rep[Tup5[A,B,C,D,E]]): Rep[String] = {
    "("+t._1+","+t._2+","+t._3+","+t._4+","+t._5+")"
  }

}
