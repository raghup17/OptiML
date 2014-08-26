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

trait Tup4WrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def tup4_unpack_impl7[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Rep[Tup4[A,B,C,D]])(implicit __pos: SourceContext): Tuple4[Rep[A],Rep[B],Rep[C],Rep[D]] = {
    ((tup4__1(t),tup4__2(t),tup4__3(t),tup4__4(t)))
  }

  def tup4_pack_impl10[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Tuple4[Rep[A],Rep[B],Rep[C],Rep[D]])(implicit __pos: SourceContext): Rep[Tup4[A,B,C,D]] = {
    internal_pack4(t._1,t._2,t._3,t._4)
  }

  def tup4_tostring_impl12[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Rep[Tup4[A,B,C,D]]): Rep[String] = {
    "("+t._1+","+t._2+","+t._3+","+t._4+")"
  }

}
