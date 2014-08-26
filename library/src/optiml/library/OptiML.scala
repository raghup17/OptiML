package optiml.library

import java.io.{BufferedWriter, FileWriter, PrintWriter}
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

trait OptiMLREPL extends OptiMLApplicationInterpreter
  with OptiMLREPLOverrides

trait OptiMLApplicationInterpreter extends OptiMLApplication with OptiMLLib {
  var args: Rep[Array[String]] = _
  final def main(argsIn: Array[String]) {
    this.args = argsIn
    main()
  }

  /**
   * Dismabiguations for interpreter mode
   */
  override def infix_vars(self: Rep[TableFactor])(implicit __pos: SourceContext,__imp1: Overload1) = tablefactor_vars(self)(__pos)
  override def infix_length[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevectorview_length[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_isRow[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevectorview_isrow[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_nnz[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevectorview_nnz[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_nz[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevectorview_nz[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_indices[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevectorview_indices[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_Clone[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[SparseVector[T]] = { self.toSparse }
  override def infix_toDense[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[DenseVector[T]] = { self.toSparse.toDense }
  override def __equal[T:Manifest](self: Rep[SparseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevectorview___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload1)
  override def __equal[T:Manifest](self: Rep[SparseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevectorview___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload2)
  override def infix_toString[T:Manifest](self: Rep[SparseVectorView[T]])(implicit __imp0: Overload1) = sparsevectorview_tostring[T](self)
  override def infix__1[A:Manifest](__arg0: Rep[Tup2[A,_]])(implicit __pos: SourceContext,__imp1: Overload1) = tup2__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  override def infix__2[B:Manifest](__arg0: Rep[Tup2[_,B]])(implicit __pos: SourceContext,__imp1: Overload1) = tup2__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  override def unpack[A:Manifest,B:Manifest](t: Rep[Tup2[A,B]])(implicit __pos: SourceContext,__imp1: Overload1) = tup2_unpack[A,B](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos)
  override def pack[A:Manifest,B:Manifest](t: Tuple2[Rep[A],Rep[B]])(implicit __pos: SourceContext,__imp1: Overload1) = tup2_pack[A,B](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos,overload1)
  override def infix_toString[A:Manifest,B:Manifest](t: Rep[Tup2[A,B]])(implicit __imp0: Overload2) = tup2_tostring[A,B](t)
  override def pack[A:Manifest,B:Manifest](__arg0: Tuple2[Var[A],Rep[B]])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Tup2[A,B]] = { tup2_pack((__arg0._1,__arg0._2)) }
  override def pack[A:Manifest,B:Manifest](__arg0: Tuple2[Rep[A],Var[B]])(implicit __pos: SourceContext,__imp1: ROverload3): Rep[Tup2[A,B]] = { tup2_pack((__arg0._1,__arg0._2)) }
  override def pack[A:Manifest,B:Manifest](__arg0: Tuple2[Var[A],Var[B]])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[Tup2[A,B]] = { tup2_pack((__arg0._1,__arg0._2)) }
  override def infix_+(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext,__imp1: Overload1) = complex_pl(self,__arg1)(__pos)
  override def infix_abs(self: Rep[Complex])(implicit __pos: SourceContext,__imp1: Overload1) = complex_abs(self)(__pos)
  override def infix_exp(self: Rep[Complex])(implicit __pos: SourceContext,__imp1: Overload1) = complex_exp(self)(__pos)
  override def infix_log(self: Rep[Complex])(implicit __pos: SourceContext,__imp1: Overload1) = complex_log(self)(__pos)
  override def __equal(self: Rep[Complex],__arg1: Rep[Complex])(implicit __pos: SourceContext,__imp1: Overload3) = complex___equal(self,__arg1)(__pos)
  override def infix_min(self: Rep[ContinuousFeature])(implicit __pos: SourceContext,__imp1: Overload1) = continuousfeature_min(self)(__pos)
  override def infix_max(self: Rep[ContinuousFeature])(implicit __pos: SourceContext,__imp1: Overload1) = continuousfeature_max(self)(__pos)
  override def infix__1[A:Manifest](__arg0: Rep[Tup9[A,_,_,_,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload2) = tup9__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  override def infix__2[B:Manifest](__arg0: Rep[Tup9[_,B,_,_,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload2) = tup9__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  override def infix__3[C:Manifest](__arg0: Rep[Tup9[_,_,C,_,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload1) = tup9__3[C](__arg0)(implicitly[Manifest[C]],__pos)
  override def infix__4[D:Manifest](__arg0: Rep[Tup9[_,_,_,D,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload1) = tup9__4[D](__arg0)(implicitly[Manifest[D]],__pos)
  override def infix__5[E:Manifest](__arg0: Rep[Tup9[_,_,_,_,E,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload1) = tup9__5[E](__arg0)(implicitly[Manifest[E]],__pos)
  override def infix__6[F:Manifest](__arg0: Rep[Tup9[_,_,_,_,_,F,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload1) = tup9__6[F](__arg0)(implicitly[Manifest[F]],__pos)
  override def infix__7[G:Manifest](__arg0: Rep[Tup9[_,_,_,_,_,_,G,_,_]])(implicit __pos: SourceContext,__imp1: Overload1) = tup9__7[G](__arg0)(implicitly[Manifest[G]],__pos)
  override def infix__8[H:Manifest](__arg0: Rep[Tup9[_,_,_,_,_,_,_,H,_]])(implicit __pos: SourceContext,__imp1: Overload1) = tup9__8[H](__arg0)(implicitly[Manifest[H]],__pos)
  override def unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest](t: Rep[Tup9[A,B,C,D,E,F,G,H,I]])(implicit __pos: SourceContext,__imp1: Overload2) = tup9_unpack[A,B,C,D,E,F,G,H,I](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],implicitly[Manifest[H]],implicitly[Manifest[I]],__pos)
  override def pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest](t: Tuple9[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G],Rep[H],Rep[I]])(implicit __pos: SourceContext,__imp1: Overload5) = tup9_pack[A,B,C,D,E,F,G,H,I](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],implicitly[Manifest[H]],implicitly[Manifest[I]],__pos)
  override def infix_toString[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest](t: Rep[Tup9[A,B,C,D,E,F,G,H,I]])(implicit __imp0: Overload3) = tup9_tostring[A,B,C,D,E,F,G,H,I](t)
  override def infix__1[A:Manifest](__arg0: Rep[Tup8[A,_,_,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload3) = tup8__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  override def infix__2[B:Manifest](__arg0: Rep[Tup8[_,B,_,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload3) = tup8__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  override def infix__3[C:Manifest](__arg0: Rep[Tup8[_,_,C,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload2) = tup8__3[C](__arg0)(implicitly[Manifest[C]],__pos)
  override def infix__4[D:Manifest](__arg0: Rep[Tup8[_,_,_,D,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload2) = tup8__4[D](__arg0)(implicitly[Manifest[D]],__pos)
  override def infix__5[E:Manifest](__arg0: Rep[Tup8[_,_,_,_,E,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload2) = tup8__5[E](__arg0)(implicitly[Manifest[E]],__pos)
  override def infix__6[F:Manifest](__arg0: Rep[Tup8[_,_,_,_,_,F,_,_]])(implicit __pos: SourceContext,__imp1: Overload2) = tup8__6[F](__arg0)(implicitly[Manifest[F]],__pos)
  override def infix__7[G:Manifest](__arg0: Rep[Tup8[_,_,_,_,_,_,G,_]])(implicit __pos: SourceContext,__imp1: Overload2) = tup8__7[G](__arg0)(implicitly[Manifest[G]],__pos)
  override def infix__8[H:Manifest](__arg0: Rep[Tup8[_,_,_,_,_,_,_,H]])(implicit __pos: SourceContext,__imp1: Overload2) = tup8__8[H](__arg0)(implicitly[Manifest[H]],__pos)
  override def unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](t: Rep[Tup8[A,B,C,D,E,F,G,H]])(implicit __pos: SourceContext,__imp1: Overload3) = tup8_unpack[A,B,C,D,E,F,G,H](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],implicitly[Manifest[H]],__pos)
  override def pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](t: Tuple8[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G],Rep[H]])(implicit __pos: SourceContext,__imp1: Overload6) = tup8_pack[A,B,C,D,E,F,G,H](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],implicitly[Manifest[H]],__pos)
  override def infix_toString[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](t: Rep[Tup8[A,B,C,D,E,F,G,H]])(implicit __imp0: Overload4) = tup8_tostring[A,B,C,D,E,F,G,H](t)
  override def infix_toInt[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext,__imp1: Overload1) = primitive2_toint[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  override def infix_toFloat[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext,__imp1: Overload1) = primitive2_tofloat[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  override def infix_toDouble[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext,__imp1: Overload1) = primitive2_todouble[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  override def infix_toLong[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext,__imp1: Overload1) = primitive2_tolong[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  override def infix_unary_~(__arg0: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = primitive2_unary_~(__arg0)(__pos,overload1)
  override def infix_unary_~(__arg0: Rep[Long])(implicit __pos: SourceContext,__imp1: Overload2) = primitive2_unary_~(__arg0)(__pos,overload2)
  override def infix_+(__arg0: Int,__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload3): Rep[Int] = { forge_int_plus(unit(__arg0),__arg1) }
  override def infix_+(__arg0: Int,__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[Float] = { forge_float_plus(unit(__arg0.toFloat),__arg1) }
  override def infix_+(__arg0: Int,__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload5): Rep[Double] = { forge_double_plus(unit(__arg0.toDouble),__arg1) }
  override def infix_+(__arg0: Float,__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload6): Rep[Float] = { forge_float_plus(unit(__arg0),__arg1.toFloat) }
  override def infix_+(__arg0: Float,__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload7): Rep[Float] = { forge_float_plus(unit(__arg0),__arg1) }
  override def infix_+(__arg0: Float,__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload8): Rep[Double] = { forge_double_plus(unit(__arg0.toDouble),__arg1) }
  override def infix_+(__arg0: Double,__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload9): Rep[Double] = { forge_double_plus(unit(__arg0),__arg1.toDouble) }
  override def infix_+(__arg0: Double,__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload10): Rep[Double] = { forge_double_plus(unit(__arg0),__arg1.toDouble) }
  override def infix_+(__arg0: Double,__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload11): Rep[Double] = { forge_double_plus(unit(__arg0),__arg1) }
  override def infix_unary_-(__arg0: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { unit(-1)*__arg0 }
  override def infix_unary_-(__arg0: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { unit(-1L)*__arg0 }
  override def infix_unary_-(__arg0: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload3): Rep[Float] = { unit(-1f)*__arg0 }
  override def infix_unary_-(__arg0: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[Double] = { unit(-1)*__arg0 }
  override def infix_+(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload30): Rep[Long] = { forge_long_plus(__arg0,__arg1) }
  override def infix_<<(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { forge_int_shift_left(__arg0,__arg1) }
  override def infix_>>(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { forge_int_shift_right(__arg0,__arg1) }
  override def infix_>>>(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { forge_int_shift_right_unsigned(__arg0,__arg1) }
  override def infix_&(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { forge_int_and(__arg0,__arg1) }
  override def infix_|(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { forge_int_or(__arg0,__arg1) }
  override def infix_&(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { forge_long_and(__arg0,__arg1) }
  override def infix_|(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { forge_long_or(__arg0,__arg1) }
  override def infix_>>>(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { forge_long_shift_right_unsigned(__arg0,__arg1) }
  override def infix_<<(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { forge_long_shift_left(__arg0,__arg1) }
  override def infix_>>(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { forge_long_shift_right(__arg0,__arg1) }
  override def infix_contains[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]],__arg1: Rep[K])(implicit __pos: SourceContext,__imp1: Overload1) = chashmap_contains[K,V](__arg0,__arg1)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  override def infix_keys[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext,__imp1: Overload1) = chashmap_keys[K,V](__arg0)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  override def infix_values[K:Manifest,V:Manifest](__arg0: Rep[java.util.concurrent.ConcurrentHashMap[K,V]])(implicit __pos: SourceContext,__imp1: Overload1) = chashmap_values[K,V](__arg0)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  override def flatten(inds: Tuple2[Rep[Int],Rep[Int]],dims: Tuple2[Rep[Int],Rep[Int]])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { inds._1*dims._2*1 + inds._2*1 }
  override def unflatten(i: Rep[Int],dims: Tuple2[Rep[Int],Rep[Int]])(implicit __pos: SourceContext,__imp1: ROverload1): Tuple2[Rep[Int],Rep[Int]] = { ((i / (dims._2*1)) % dims._1,(i / (1)) % dims._2) }
  override def flatten(inds: Tuple3[Rep[Int],Rep[Int],Rep[Int]],dims: Tuple3[Rep[Int],Rep[Int],Rep[Int]])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Int] = { inds._1*dims._2*dims._3*1 + inds._2*dims._3*1 + inds._3*1 }
  override def unflatten(i: Rep[Int],dims: Tuple3[Rep[Int],Rep[Int],Rep[Int]])(implicit __pos: SourceContext,__imp1: ROverload2): Tuple3[Rep[Int],Rep[Int],Rep[Int]] = { ((i / (dims._2*dims._3*1)) % dims._1,(i / (dims._3*1)) % dims._2,(i / (1)) % dims._3) }
  override def flatten(inds: Tuple4[Rep[Int],Rep[Int],Rep[Int],Rep[Int]],dims: Tuple4[Rep[Int],Rep[Int],Rep[Int],Rep[Int]])(implicit __pos: SourceContext,__imp1: ROverload3): Rep[Int] = { inds._1*dims._2*dims._3*dims._4*1 + inds._2*dims._3*dims._4*1 + inds._3*dims._4*1 + inds._4*1 }
  override def unflatten(i: Rep[Int],dims: Tuple4[Rep[Int],Rep[Int],Rep[Int],Rep[Int]])(implicit __pos: SourceContext,__imp1: ROverload3): Tuple4[Rep[Int],Rep[Int],Rep[Int],Rep[Int]] = { ((i / (dims._2*dims._3*dims._4*1)) % dims._1,(i / (dims._3*dims._4*1)) % dims._2,(i / (dims._4*1)) % dims._3,(i / (1)) % dims._4) }
  override def flatten(inds: Tuple5[Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int]],dims: Tuple5[Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int]])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[Int] = { inds._1*dims._2*dims._3*dims._4*dims._5*1 + inds._2*dims._3*dims._4*dims._5*1 + inds._3*dims._4*dims._5*1 + inds._4*dims._5*1 + inds._5*1 }
  override def unflatten(i: Rep[Int],dims: Tuple5[Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int]])(implicit __pos: SourceContext,__imp1: ROverload4): Tuple5[Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int]] = { ((i / (dims._2*dims._3*dims._4*dims._5*1)) % dims._1,(i / (dims._3*dims._4*dims._5*1)) % dims._2,(i / (dims._4*dims._5*1)) % dims._3,(i / (dims._5*1)) % dims._4,(i / (1)) % dims._5) }
  override def flatten(inds: Tuple6[Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int]],dims: Tuple6[Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int]])(implicit __pos: SourceContext,__imp1: ROverload5): Rep[Int] = { inds._1*dims._2*dims._3*dims._4*dims._5*dims._6*1 + inds._2*dims._3*dims._4*dims._5*dims._6*1 + inds._3*dims._4*dims._5*dims._6*1 + inds._4*dims._5*dims._6*1 + inds._5*dims._6*1 + inds._6*1 }
  override def unflatten(i: Rep[Int],dims: Tuple6[Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int]])(implicit __pos: SourceContext,__imp1: ROverload5): Tuple6[Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int],Rep[Int]] = { ((i / (dims._2*dims._3*dims._4*dims._5*dims._6*1)) % dims._1,(i / (dims._3*dims._4*dims._5*dims._6*1)) % dims._2,(i / (dims._4*dims._5*dims._6*1)) % dims._3,(i / (dims._5*dims._6*1)) % dims._4,(i / (dims._6*1)) % dims._5,(i / (1)) % dims._6) }
  override def infix_length(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload2) = indexvector_length(self)(__pos)
  override def infix_isRow(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload2) = indexvector_isrow(self)(__pos)
  override def infix_slice(self: Rep[IndexVector],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_slice(self,start,end)(__pos)
  override def infix_t(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_t(self)(__pos)
  override def infix_Clone(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload2) = indexvector_clone(self)(__pos)
  override def infix_toDense(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload2) = indexvector_todense(self)(__pos)
  override def __equal(self: Rep[IndexVector],__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload4) = indexvector___equal(self,__arg1)(__pos,overload4)
  override def __equal(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload5) = indexvector___equal(self,__arg1)(__pos,overload5)
  override def infix_indices(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload2) = indexvector_indices(self)(__pos)
  override def infix_isEmpty(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_isempty(self)(__pos)
  override def infix_first(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_first(self)(__pos)
  override def infix_last(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_last(self)(__pos)
  override def infix_drop(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_drop(self,__arg1)(__pos)
  override def infix_take(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_take(self,__arg1)(__pos)
  override def infix_contains(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = indexvector_contains(self,__arg1)(__pos)
  override def infix_distinct(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_distinct(self)(__pos)
  override def infix_mutable(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload3) = indexvector_mutable(self)(__pos)
  override def infix_replicate(self: Rep[IndexVector],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_replicate(self,__arg1,__arg2)(__pos)
  override def infix_makeString(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_makestring(self)(__pos)
  override def infix_toString(self: Rep[IndexVector])(implicit __imp0: Overload5) = indexvector_tostring(self)
  override def infix_pprint(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_pprint(self)(__pos)
  override def infix_+(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload33) = indexvector_pl(self,__arg1)(__pos,overload33)
  override def infix_*:*(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_mulclnmul(self,__arg1)(__pos,overload1)
  override def infix_**(self: Rep[IndexVector],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_mulmul(self,__arg1)(__pos,overload1)
  override def infix_+(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload34) = indexvector_pl(self,__arg1)(__pos,overload34)
  override def infix_*:*(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload2) = indexvector_mulclnmul(self,__arg1)(__pos,overload2)
  override def infix_**(self: Rep[IndexVector],__arg1: Rep[DenseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload2) = indexvector_mulmul(self,__arg1)(__pos,overload2)
  override def infix_+(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload35) = indexvector_pl(self,__arg1)(__pos,overload35)
  override def infix_*:*(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload3) = indexvector_mulclnmul(self,__arg1)(__pos,overload3)
  override def infix_**(self: Rep[IndexVector],__arg1: Rep[SparseVector[Int]])(implicit __pos: SourceContext,__imp1: Overload3) = indexvector_mulmul(self,__arg1)(__pos,overload3)
  override def infix_+(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload36) = indexvector_pl(self,__arg1)(__pos,overload36)
  override def infix_*:*(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload4) = indexvector_mulclnmul(self,__arg1)(__pos,overload4)
  override def infix_**(self: Rep[IndexVector],__arg1: Rep[SparseVectorView[Int]])(implicit __pos: SourceContext,__imp1: Overload4) = indexvector_mulmul(self,__arg1)(__pos,overload4)
  override def infix_+(self: Rep[IndexVector],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload37) = indexvector_pl(self,__arg1)(__pos,overload37)
  override def infix_abs(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload5) = indexvector_abs(self)(__pos)
  override def infix_exp(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload5) = indexvector_exp(self)(__pos)
  override def infix_log(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload5) = indexvector_log(self)(__pos)
  override def infix_sum(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_sum(self)(__pos)
  override def infix_prod(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_prod(self)(__pos)
  override def infix_min(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload2) = indexvector_min(self)(__pos)
  override def infix_max(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload2) = indexvector_max(self)(__pos)
  override def infix_minIndex(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_minindex(self)(__pos)
  override def infix_maxIndex(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_maxindex(self)(__pos)
  override def infix_prefixSum(self: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = indexvector_prefixsum(self)(__pos)
  override def infix_id(self: Rep[Weight])(implicit __pos: SourceContext,__imp1: Overload1) = weight_id(self)(__pos)
  override def infix_value(self: Rep[Weight])(implicit __pos: SourceContext,__imp1: Overload1) = weight_value(self)(__pos)
  override def infix__1[A:Manifest](__arg0: Rep[Tup7[A,_,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload4) = tup7__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  override def infix__2[B:Manifest](__arg0: Rep[Tup7[_,B,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload4) = tup7__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  override def infix__3[C:Manifest](__arg0: Rep[Tup7[_,_,C,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload3) = tup7__3[C](__arg0)(implicitly[Manifest[C]],__pos)
  override def infix__4[D:Manifest](__arg0: Rep[Tup7[_,_,_,D,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload3) = tup7__4[D](__arg0)(implicitly[Manifest[D]],__pos)
  override def infix__5[E:Manifest](__arg0: Rep[Tup7[_,_,_,_,E,_,_]])(implicit __pos: SourceContext,__imp1: Overload3) = tup7__5[E](__arg0)(implicitly[Manifest[E]],__pos)
  override def infix__6[F:Manifest](__arg0: Rep[Tup7[_,_,_,_,_,F,_]])(implicit __pos: SourceContext,__imp1: Overload3) = tup7__6[F](__arg0)(implicitly[Manifest[F]],__pos)
  override def infix__7[G:Manifest](__arg0: Rep[Tup7[_,_,_,_,_,_,G]])(implicit __pos: SourceContext,__imp1: Overload3) = tup7__7[G](__arg0)(implicitly[Manifest[G]],__pos)
  override def unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest](t: Rep[Tup7[A,B,C,D,E,F,G]])(implicit __pos: SourceContext,__imp1: Overload4) = tup7_unpack[A,B,C,D,E,F,G](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],__pos)
  override def pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest](t: Tuple7[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G]])(implicit __pos: SourceContext,__imp1: Overload7) = tup7_pack[A,B,C,D,E,F,G](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],__pos)
  override def infix_toString[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest](t: Rep[Tup7[A,B,C,D,E,F,G]])(implicit __imp0: Overload6) = tup7_tostring[A,B,C,D,E,F,G](t)
  override def infix_length[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload3) = sparsevector_length[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_isRow[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload3) = sparsevector_isrow[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_nnz[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevector_nnz[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_nz[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevector_nz[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_indices[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload3) = sparsevector_indices[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_isEmpty[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevector_isempty[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_first[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevector_first[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_last[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevector_last[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_drop[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevector_drop[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  override def infix_take[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevector_take[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  override def infix_slice[T:Manifest](self: Rep[SparseVector[T]],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[SparseVector[T]] = { self(start::end) }
  override def infix_contains[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload3) = sparsevector_contains[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  override def infix_distinct[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevector_distinct[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_t[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsevector_t[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_mt[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_mt[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_Clone[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload3) = sparsevector_clone[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_mutable[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload5) = sparsevector_mutable[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_toDense[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload3) = sparsevector_todense[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_makeString[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Stringable[T],__imp2: Overload2) = sparsevector_makestring[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_toString[T:Manifest](self: Rep[SparseVector[T]])(implicit __imp0: Overload7) = sparsevector_tostring[T](self)
  override def infix_pprint[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Stringable[T],__imp2: Overload2) = sparsevector_pprint[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_<<[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload3) = sparsevector_ltlt[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload3)
  override def infix_<<[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload4) = sparsevector_ltlt[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload4)
  override def infix_insert[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_insert[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  override def infix_insertAll[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],xs: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_insertall[T](self,pos,xs)(implicitly[Manifest[T]],__pos)
  override def infix_remove[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_remove[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  override def infix_removeAll[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_removeall[T](self,pos,len)(implicitly[Manifest[T]],__pos)
  override def infix_copyFrom[T:Manifest](self: Rep[SparseVector[T]],pos: Rep[Int],xs: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_copyfrom[T](self,pos,xs)(implicitly[Manifest[T]],__pos)
  override def infix_trim[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_trim[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_clear[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_clear[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_+[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload39) = sparsevector_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload39)
  override def infix_+[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload40) = sparsevector_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload40)
  override def infix_+[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload41) = sparsevector_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload41)
  override def infix_*:*[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload5) = sparsevector_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload5)
  override def infix_*:*[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload6) = sparsevector_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload6)
  override def infix_**[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload5) = sparsevector_mulmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_abs[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload7) = sparsevector_abs[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_sum[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = sparsevector_sum[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_min[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload3) = sparsevector_min[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_max[T:Manifest](self: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload3) = sparsevector_max[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def __equal[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload6) = sparsevector___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload6)
  override def __equal[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload7) = sparsevector___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload7)
  override def __equal[T:Manifest](self: Rep[SparseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload8) = sparsevector___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload8)
  override def dist(__arg0: Rep[SparseVector[Double]],__arg1: Rep[SparseVector[Double]],__arg2: DistanceMetric)(implicit __pos: SourceContext,__imp1: Overload1) = sparsevector_dist(__arg0,__arg1,__arg2)(__pos)
  override def infix_size(self: Rep[UTriangle])(implicit __pos: SourceContext,__imp1: Overload5) = utriangle_size(self)(__pos)
  override def infix_contains(self: Rep[UTriangle],i: Rep[Int],j: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload4) = utriangle_contains(self,i,j)(__pos)
  override def shuffle(__arg0: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = rand_shuffle(__arg0)(__pos,overload1)
  override def shuffle[A:Manifest](__arg0: Rep[DenseVector[A]])(implicit __pos: SourceContext,__imp1: Overload2) = rand_shuffle[A](__arg0)(implicitly[Manifest[A]],__pos,overload2)
  override def shuffle[A:Manifest](__arg0: Rep[DenseMatrix[A]])(implicit __pos: SourceContext,__imp1: Overload3) = rand_shuffle[A](__arg0)(implicitly[Manifest[A]],__pos,overload3)
  override def infix__1[A:Manifest](__arg0: Rep[Tup6[A,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload5) = tup6__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  override def infix__2[B:Manifest](__arg0: Rep[Tup6[_,B,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload5) = tup6__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  override def infix__3[C:Manifest](__arg0: Rep[Tup6[_,_,C,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload4) = tup6__3[C](__arg0)(implicitly[Manifest[C]],__pos)
  override def infix__4[D:Manifest](__arg0: Rep[Tup6[_,_,_,D,_,_]])(implicit __pos: SourceContext,__imp1: Overload4) = tup6__4[D](__arg0)(implicitly[Manifest[D]],__pos)
  override def infix__5[E:Manifest](__arg0: Rep[Tup6[_,_,_,_,E,_]])(implicit __pos: SourceContext,__imp1: Overload4) = tup6__5[E](__arg0)(implicitly[Manifest[E]],__pos)
  override def infix__6[F:Manifest](__arg0: Rep[Tup6[_,_,_,_,_,F]])(implicit __pos: SourceContext,__imp1: Overload4) = tup6__6[F](__arg0)(implicitly[Manifest[F]],__pos)
  override def unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Rep[Tup6[A,B,C,D,E,F]])(implicit __pos: SourceContext,__imp1: Overload5) = tup6_unpack[A,B,C,D,E,F](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],__pos)
  override def pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Tuple6[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F]])(implicit __pos: SourceContext,__imp1: Overload8) = tup6_pack[A,B,C,D,E,F](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],__pos)
  override def infix_toString[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Rep[Tup6[A,B,C,D,E,F]])(implicit __imp0: Overload8) = tup6_tostring[A,B,C,D,E,F](t)
  override def infix_id(self: Rep[FunctionFactor])(implicit __pos: SourceContext,__imp1: Overload2) = functionfactor_id(self)(__pos)
  override def infix_vars(self: Rep[FunctionFactor])(implicit __pos: SourceContext,__imp1: Overload2) = functionfactor_vars(self)(__pos)
  override def infix_weightId(self: Rep[FunctionFactor])(implicit __pos: SourceContext,__imp1: Overload1) = functionfactor_weightid(self)(__pos)
  override def infix_numRows[T:Manifest](self: Rep[ComputeStream[T]])(implicit __pos: SourceContext,__imp1: Overload1) = computestream_numrows[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_numCols[T:Manifest](self: Rep[ComputeStream[T]])(implicit __pos: SourceContext,__imp1: Overload1) = computestream_numcols[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_toInt(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload3) = fstring_toint(__arg0)(__pos)
  override def infix_toLong(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload2) = fstring_tolong(__arg0)(__pos)
  override def infix_toFloat(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload3) = fstring_tofloat(__arg0)(__pos)
  override def infix_toDouble(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload3) = fstring_todouble(__arg0)(__pos)
  override def infix_toBoolean(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload2) = fstring_toboolean(__arg0)(__pos)
  override def infix_trim(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload2) = fstring_trim(__arg0)(__pos)
  override def infix_slice(__arg0: Rep[String],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload3) = fstring_slice(__arg0,__arg1,__arg2)(__pos)
  override def infix_length(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload4) = fstring_length(__arg0)(__pos)
  override def infix_contains(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: Overload5) = fstring_contains(__arg0,__arg1)(__pos)
  override def infix_substring(__arg0: Rep[String],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = fstring_substring(__arg0,__arg1)(__pos,overload1)
  override def infix_substring(__arg0: Rep[String],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = fstring_substring(__arg0,__arg1,__arg2)(__pos,overload2)
  override def infix_+[T:Manifest](__arg0: String,__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload43) = fstring_pl[T](unit(__arg0),__arg1)(implicitly[Manifest[T]],__pos,overload43)
  override def infix_+[T:Manifest](__arg0: Rep[T],__arg1: String)(implicit __pos: SourceContext,__imp1: Overload49) = fstring_pl[T](__arg0,unit(__arg1))(implicitly[Manifest[T]],__pos,overload49)
  override def infix_+(__arg0: String,__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: Overload54) = fstring_pl(unit(__arg0),__arg1)(__pos,overload54)
  override def infix_contains[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]],__arg1: Rep[K])(implicit __pos: SourceContext,__imp1: Overload6) = shashmap_contains[K,V](__arg0,__arg1)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  override def infix_keys[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext,__imp1: Overload2) = shashmap_keys[K,V](__arg0)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  override def infix_values[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext,__imp1: Overload2) = shashmap_values[K,V](__arg0)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  override def infix_data[D:Manifest,L:Manifest](self: Rep[TrainingSet[D,L]])(implicit __pos: SourceContext,__imp1: Overload1) = trainingset_data[D,L](self)(implicitly[Manifest[D]],implicitly[Manifest[L]],__pos)
  override def infix_numRows[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrixbuildable_numrows[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_numCols[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrixbuildable_numcols[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_nnz[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext,__imp1: Overload3) = sparsematrixbuildable_nnz[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_size[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext,__imp1: Overload7) = sparsematrixbuildable_size[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_pprint[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext,__imp0: Stringable[T],__imp2: Overload3) = sparsematrixbuildable_pprint[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_makeString[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext,__imp0: Stringable[T],__imp2: Overload3) = sparsematrixbuildable_makestring[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_toString[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __imp0: Overload9) = sparsematrixbuildable_tostring[T](self)
  override def infix_mutable[T:Manifest](self: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext,__imp1: Overload8) = sparsematrixbuildable_mutable[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_insertRow[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],y: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsematrixbuildable_insertrow[T](self,pos,y)(implicitly[Manifest[T]],__pos)
  override def infix_insertCol[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],y: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = sparsematrixbuildable_insertcol[T](self,pos,y)(implicitly[Manifest[T]],__pos)
  override def infix_removeRow[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = sparsematrixbuildable_removerow[T](self,pos)(implicitly[Manifest[T]],__pos)
  override def infix_removeCol[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = sparsematrixbuildable_removecol[T](self,pos)(implicitly[Manifest[T]],__pos)
  override def infix_removeRows[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],num: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = sparsematrixbuildable_removerows[T](self,pos,num)(implicitly[Manifest[T]],__pos)
  override def infix_removeCols[T:Manifest](self: Rep[SparseMatrixBuildable[T]],pos: Rep[Int],num: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = sparsematrixbuildable_removecols[T](self,pos,num)(implicitly[Manifest[T]],__pos)
  override def println(__arg0: Rep[Any])(implicit __pos: SourceContext,__imp1: Overload1) = misc_println(__arg0)(__pos,overload1)
  override def println()(implicit __pos: SourceContext,__imp1: Overload2) = misc_println()(__pos,overload2)
  override def infix_id(self: Rep[FactorVariable])(implicit __pos: SourceContext,__imp1: Overload3) = factorvariable_id(self)(__pos)
  override def infix_domain(self: Rep[FactorVariable])(implicit __pos: SourceContext,__imp1: Overload1) = factorvariable_domain(self)(__pos)
  override def infix__1[A:Manifest](__arg0: Rep[Tup3[A,_,_]])(implicit __pos: SourceContext,__imp1: Overload6) = tup3__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  override def infix__2[B:Manifest](__arg0: Rep[Tup3[_,B,_]])(implicit __pos: SourceContext,__imp1: Overload6) = tup3__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  override def infix__3[C:Manifest](__arg0: Rep[Tup3[_,_,C]])(implicit __pos: SourceContext,__imp1: Overload5) = tup3__3[C](__arg0)(implicitly[Manifest[C]],__pos)
  override def unpack[A:Manifest,B:Manifest,C:Manifest](t: Rep[Tup3[A,B,C]])(implicit __pos: SourceContext,__imp1: Overload6) = tup3_unpack[A,B,C](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],__pos)
  override def pack[A:Manifest,B:Manifest,C:Manifest](t: Tuple3[Rep[A],Rep[B],Rep[C]])(implicit __pos: SourceContext,__imp1: Overload9) = tup3_pack[A,B,C](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],__pos)
  override def infix_toString[A:Manifest,B:Manifest,C:Manifest](t: Rep[Tup3[A,B,C]])(implicit __imp0: Overload10) = tup3_tostring[A,B,C](t)
  override def infix_length[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload5) = densevectorview_length[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_isRow[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload4) = densevectorview_isrow[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_slice[T:Manifest](self: Rep[DenseVectorView[T]],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload4) = densevectorview_slice[T](self,start,end)(implicitly[Manifest[T]],__pos)
  override def infix_Clone[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[DenseVector[T]] = { self.toDense }
  override def infix_toDense[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload4) = densevectorview_todense[T](self)(implicitly[Manifest[T]],__pos)
  override def __equal[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload9) = densevectorview___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  override def infix_indices[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload4) = densevectorview_indices[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_isEmpty[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload3) = densevectorview_isempty[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_first[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload3) = densevectorview_first[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_last[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload3) = densevectorview_last[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_drop[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload3) = densevectorview_drop[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  override def infix_take[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload3) = densevectorview_take[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  override def infix_contains[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload7) = densevectorview_contains[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  override def infix_distinct[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload3) = densevectorview_distinct[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_mutable[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload12) = densevectorview_mutable[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_replicate[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = densevectorview_replicate[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  override def infix_makeString[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Stringable[T],__imp2: Overload4) = densevectorview_makestring[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_toString[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __imp0: Overload11) = densevectorview_tostring[T](self)
  override def infix_pprint[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Stringable[T],__imp2: Overload4) = densevectorview_pprint[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_+[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload63) = densevectorview_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload63)
  override def infix_*:*[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload7) = densevectorview_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload7)
  override def infix_**[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload6) = densevectorview_mulmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload6)
  override def infix_+[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload64) = densevectorview_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload64)
  override def infix_*:*[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload8) = densevectorview_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload8)
  override def infix_**[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload7) = densevectorview_mulmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload7)
  override def infix_+[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload65) = densevectorview_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload65)
  override def infix_*:*[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload9) = densevectorview_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload9)
  override def infix_**[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload8) = densevectorview_mulmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload8)
  override def infix_+[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload66) = densevectorview_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload66)
  override def infix_*:*[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload10) = densevectorview_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload10)
  override def infix_**[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload9) = densevectorview_mulmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload9)
  override def infix_+[T:Manifest](self: Rep[DenseVectorView[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload67) = densevectorview_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload67)
  override def infix_abs[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload13) = densevectorview_abs[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_exp[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload12) = densevectorview_exp[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_log[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload12) = densevectorview_log[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_sum[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload3) = densevectorview_sum[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_prod[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = densevectorview_prod[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_min[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload4) = densevectorview_min[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_max[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload4) = densevectorview_max[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_minIndex[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp1: Arith[T],__imp3: Overload2) = densevectorview_minindex[T](self)(implicitly[Manifest[T]],__pos,__imp0,__imp1)
  override def infix_maxIndex[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp1: Arith[T],__imp3: Overload2) = densevectorview_maxindex[T](self)(implicitly[Manifest[T]],__pos,__imp0,__imp1)
  override def infix_prefixSum[T:Manifest](self: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = densevectorview_prefixsum[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def dist(__arg0: Rep[DenseVectorView[Double]],__arg1: Rep[DenseVectorView[Double]],__arg2: DistanceMetric)(implicit __pos: SourceContext,__imp1: Overload2) = densevectorview_dist(__arg0,__arg1,__arg2)(__pos)
  override def infix__1[A:Manifest](__arg0: Rep[Tup4[A,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload7) = tup4__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  override def infix__2[B:Manifest](__arg0: Rep[Tup4[_,B,_,_]])(implicit __pos: SourceContext,__imp1: Overload7) = tup4__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  override def infix__3[C:Manifest](__arg0: Rep[Tup4[_,_,C,_]])(implicit __pos: SourceContext,__imp1: Overload6) = tup4__3[C](__arg0)(implicitly[Manifest[C]],__pos)
  override def infix__4[D:Manifest](__arg0: Rep[Tup4[_,_,_,D]])(implicit __pos: SourceContext,__imp1: Overload5) = tup4__4[D](__arg0)(implicitly[Manifest[D]],__pos)
  override def unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Rep[Tup4[A,B,C,D]])(implicit __pos: SourceContext,__imp1: Overload7) = tup4_unpack[A,B,C,D](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],__pos)
  override def pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Tuple4[Rep[A],Rep[B],Rep[C],Rep[D]])(implicit __pos: SourceContext,__imp1: Overload10) = tup4_pack[A,B,C,D](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],__pos)
  override def infix_toString[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Rep[Tup4[A,B,C,D]])(implicit __imp0: Overload12) = tup4_tostring[A,B,C,D](t)
  override def infix_id(self: Rep[RandomVariable])(implicit __pos: SourceContext,__imp1: Overload4) = randomvariable_id(self)(__pos)
  override def infix_domain(self: Rep[RandomVariable])(implicit __pos: SourceContext,__imp1: Overload2) = randomvariable_domain(self)(__pos)
  override def infix_value(self: Rep[RandomVariable])(implicit __pos: SourceContext,__imp1: Overload2) = randomvariable_value(self)(__pos)
  override def infix__1[A:Manifest](__arg0: Rep[Tup5[A,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload8) = tup5__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  override def infix__2[B:Manifest](__arg0: Rep[Tup5[_,B,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload8) = tup5__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  override def infix__3[C:Manifest](__arg0: Rep[Tup5[_,_,C,_,_]])(implicit __pos: SourceContext,__imp1: Overload7) = tup5__3[C](__arg0)(implicitly[Manifest[C]],__pos)
  override def infix__4[D:Manifest](__arg0: Rep[Tup5[_,_,_,D,_]])(implicit __pos: SourceContext,__imp1: Overload6) = tup5__4[D](__arg0)(implicitly[Manifest[D]],__pos)
  override def infix__5[E:Manifest](__arg0: Rep[Tup5[_,_,_,_,E]])(implicit __pos: SourceContext,__imp1: Overload5) = tup5__5[E](__arg0)(implicitly[Manifest[E]],__pos)
  override def unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Rep[Tup5[A,B,C,D,E]])(implicit __pos: SourceContext,__imp1: Overload8) = tup5_unpack[A,B,C,D,E](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],__pos)
  override def pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Tuple5[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E]])(implicit __pos: SourceContext,__imp1: Overload11) = tup5_pack[A,B,C,D,E](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],__pos)
  override def infix_toString[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Rep[Tup5[A,B,C,D,E]])(implicit __imp0: Overload13) = tup5_tostring[A,B,C,D,E](t)
  override def infix_numRows[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload3) = densematrix_numrows[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_numCols[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload3) = densematrix_numcols[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_size[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload13) = densematrix_size[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_indices[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload5) = densematrix_indices[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_rowIndices[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_rowindices[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_colIndices[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_colindices[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_getRow[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_getrow[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  override def infix_getRows[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_getrows[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  override def infix_getCol[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_getcol[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  override def infix_getCols[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_getcols[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  override def infix_slice[T:Manifest](self: Rep[DenseMatrix[T]],startRow: Rep[Int],endRow: Rep[Int],startCol: Rep[Int],endCol: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload5): Rep[DenseMatrix[T]] = { self(startRow::endRow, startCol::endCol) }
  override def infix_sliceRows[T:Manifest](self: Rep[DenseMatrix[T]],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[DenseMatrix[T]] = { self.getRows(start::end) }
  override def infix_sliceCols[T:Manifest](self: Rep[DenseMatrix[T]],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[DenseMatrix[T]] = { self.getCols(start::end) }
  override def infix_pprint[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Stringable[T],__imp2: Overload5) = densematrix_pprint[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_makeString[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Stringable[T],__imp2: Overload5) = densematrix_makestring[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_toString[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __imp0: Overload14) = densematrix_tostring[T](self)
  override def infix_t[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload3) = densematrix_t[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_Clone[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload5) = densematrix_clone[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_mutable[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload14) = densematrix_mutable[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_replicate[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload3) = densematrix_replicate[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  override def infix_updateRow[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_updaterow[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos,overload1)
  override def infix_updateCol[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_updatecol[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos,overload1)
  override def infix_updateRow[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_updaterow[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos,overload2)
  override def infix_updateCol[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[Int],__arg2: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_updatecol[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos,overload2)
  override def infix_<<[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload5) = densematrix_ltlt[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload5)
  override def infix_<<[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload6) = densematrix_ltlt[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload6)
  override def infix_<<|[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload1) = densematrix_ltltor[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload1)
  override def infix_<<|[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_ltltor[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload2)
  override def infix_insertRow[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],y: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_insertrow[T](self,pos,y)(implicitly[Manifest[T]],__pos)
  override def infix_insertCol[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],y: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_insertcol[T](self,pos,y)(implicitly[Manifest[T]],__pos)
  override def infix_trim[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload3) = densematrix_trim[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_removeRow[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_removerow[T](self,pos)(implicitly[Manifest[T]],__pos)
  override def infix_removeCol[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_removecol[T](self,pos)(implicitly[Manifest[T]],__pos)
  override def infix_removeRows[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],num: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_removerows[T](self,pos,num)(implicitly[Manifest[T]],__pos)
  override def infix_removeCols[T:Manifest](self: Rep[DenseMatrix[T]],pos: Rep[Int],num: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = densematrix_removecols[T](self,pos,num)(implicitly[Manifest[T]],__pos)
  override def infix_+[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload74) = densematrix_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload74)
  override def infix_+[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload75) = densematrix_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload75)
  override def infix_+=[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload1) = densematrix_pleq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload1)
  override def infix_+=[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = densematrix_pleq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload2)
  override def infix_-=[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload1) = densematrix_subeq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload1)
  override def infix_-=[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = densematrix_subeq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload2)
  override def infix_*:*[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload11) = densematrix_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload11)
  override def infix_*=[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload1) = densematrix_muleq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload1)
  override def infix_*=[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = densematrix_muleq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload2)
  override def infix_/=[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload1) = densematrix_diveq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload1)
  override def infix_/=[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = densematrix_diveq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload2)
  override def infix_+[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload76) = densematrix_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload76)
  override def infix_*:*[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload12) = densematrix_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload12)
  override def infix_sum[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload4) = densematrix_sum[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_prod[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload3) = densematrix_prod[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_abs[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload20) = densematrix_abs[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_exp[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload19) = densematrix_exp[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_log[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload19) = densematrix_log[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_sumRows[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload1) = densematrix_sumrows[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_sumCols[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload1) = densematrix_sumcols[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_minRows[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload1) = densematrix_minrows[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_minCols[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload1) = densematrix_mincols[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_maxRows[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload1) = densematrix_maxrows[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_maxCols[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload1) = densematrix_maxcols[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_min[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload5) = densematrix_min[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_max[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload5) = densematrix_max[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_minIndex[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload3) = densematrix_minindex[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_maxIndex[T:Manifest](self: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload3) = densematrix_maxindex[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_:>[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload1) = densematrix_clngt[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_:<[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload1) = densematrix_clnlt[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  override def __equal[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload10) = densematrix___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload10)
  override def __equal[T:Manifest](self: Rep[DenseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload11) = densematrix___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload11)
  override def infix_+(__arg0: Rep[Int],__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload77): Rep[DenseMatrix[Int]] = { densematrix_pl[Int](__arg1,__arg0) }
  override def infix_+(__arg0: Rep[Int],__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload78): Rep[DenseMatrix[Float]] = { densematrix_pl[Float](__arg1,__arg0.toFloat) }
  override def infix_+(__arg0: Rep[Int],__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload79): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg1,__arg0.toDouble) }
  override def infix_+(__arg0: Rep[Float],__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload80): Rep[DenseMatrix[Float]] = { densematrix_pl[Float](__arg1.toFloat,__arg0) }
  override def infix_+(__arg0: Rep[Float],__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload81): Rep[DenseMatrix[Float]] = { densematrix_pl[Float](__arg1,__arg0) }
  override def infix_+(__arg0: Rep[Float],__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload82): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg1,__arg0.toDouble) }
  override def infix_+(__arg0: Rep[Double],__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload83): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg1.toDouble,__arg0) }
  override def infix_+(__arg0: Rep[Double],__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload84): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg1.toDouble,__arg0) }
  override def infix_+(__arg0: Rep[Double],__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload85): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg1,__arg0) }
  override def infix_+(__arg0: Rep[DenseMatrix[Int]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload86): Rep[DenseMatrix[Int]] = { densematrix_pl[Int](__arg0,__arg1) }
  override def infix_+(__arg0: Rep[DenseMatrix[Int]],__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload87): Rep[DenseMatrix[Float]] = { densematrix_pl[Float](__arg0.toFloat,__arg1) }
  override def infix_+(__arg0: Rep[DenseMatrix[Int]],__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload88): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg0.toDouble,__arg1) }
  override def infix_+(__arg0: Rep[DenseMatrix[Float]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload89): Rep[DenseMatrix[Float]] = { densematrix_pl[Float](__arg0,__arg1.toFloat) }
  override def infix_+(__arg0: Rep[DenseMatrix[Float]],__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload90): Rep[DenseMatrix[Float]] = { densematrix_pl[Float](__arg0,__arg1) }
  override def infix_+(__arg0: Rep[DenseMatrix[Float]],__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload91): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg0.toDouble,__arg1) }
  override def infix_+(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload92): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg0,__arg1.toDouble) }
  override def infix_+(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload93): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg0.toDouble,__arg1) }
  override def infix_+(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload94): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg0,__arg1) }
  override def infix_+(__arg0: Rep[DenseMatrix[Int]],__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload95): Rep[DenseMatrix[Int]] = { densematrix_pl[Int](__arg0,__arg1) }
  override def infix_+(__arg0: Rep[DenseMatrix[Int]],__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload96): Rep[DenseMatrix[Float]] = { densematrix_pl[Float](__arg0.toFloat,__arg1) }
  override def infix_+(__arg0: Rep[DenseMatrix[Int]],__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload97): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg0.toDouble,__arg1) }
  override def infix_+(__arg0: Rep[DenseMatrix[Float]],__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload98): Rep[DenseMatrix[Float]] = { densematrix_pl[Float](__arg0,__arg1.toFloat) }
  override def infix_+(__arg0: Rep[DenseMatrix[Float]],__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload99): Rep[DenseMatrix[Float]] = { densematrix_pl[Float](__arg0,__arg1) }
  override def infix_+(__arg0: Rep[DenseMatrix[Float]],__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload100): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg0.toDouble,__arg1) }
  override def infix_+(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload101): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg0,__arg1.toDouble) }
  override def infix_+(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload102): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg0,__arg1.toDouble) }
  override def infix_+(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload103): Rep[DenseMatrix[Double]] = { densematrix_pl[Double](__arg0,__arg1) }
  override def infix_unary_-(__arg0: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload5): Rep[DenseMatrix[Int]] = { densematrix_mul[Int](__arg0,unit(-1)) }
  override def infix_unary_-(__arg0: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload6): Rep[DenseMatrix[Float]] = { densematrix_mul[Float](__arg0,unit(-1f)) }
  override def infix_unary_-(__arg0: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload7): Rep[DenseMatrix[Double]] = { densematrix_mul[Double](__arg0,unit(-1.0)) }
  override def infix_*:*(__arg0: Rep[DenseMatrix[Int]],__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload13): Rep[DenseMatrix[Int]] = { densematrix_mulclnmul[Int](__arg0,__arg1) }
  override def infix_*:*(__arg0: Rep[DenseMatrix[Int]],__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload14): Rep[DenseMatrix[Float]] = { densematrix_mulclnmul[Float](__arg0.toFloat,__arg1) }
  override def infix_*:*(__arg0: Rep[DenseMatrix[Int]],__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload15): Rep[DenseMatrix[Double]] = { densematrix_mulclnmul[Double](__arg0.toDouble,__arg1) }
  override def infix_*:*(__arg0: Rep[DenseMatrix[Float]],__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload16): Rep[DenseMatrix[Float]] = { densematrix_mulclnmul[Float](__arg0,__arg1.toFloat) }
  override def infix_*:*(__arg0: Rep[DenseMatrix[Float]],__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload17): Rep[DenseMatrix[Float]] = { densematrix_mulclnmul[Float](__arg0,__arg1) }
  override def infix_*:*(__arg0: Rep[DenseMatrix[Float]],__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload18): Rep[DenseMatrix[Double]] = { densematrix_mulclnmul[Double](__arg0.toDouble,__arg1) }
  override def infix_*:*(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[DenseMatrix[Int]])(implicit __pos: SourceContext,__imp1: ROverload19): Rep[DenseMatrix[Double]] = { densematrix_mulclnmul[Double](__arg0,__arg1.toDouble) }
  override def infix_*:*(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[DenseMatrix[Float]])(implicit __pos: SourceContext,__imp1: ROverload20): Rep[DenseMatrix[Double]] = { densematrix_mulclnmul[Double](__arg0,__arg1.toDouble) }
  override def infix_*:*(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload21): Rep[DenseMatrix[Double]] = { densematrix_mulclnmul[Double](__arg0,__arg1) }
  override def dist(__arg0: Rep[DenseMatrix[Double]],__arg1: Rep[DenseMatrix[Double]],__arg2: DistanceMetric)(implicit __pos: SourceContext,__imp1: Overload3) = densematrix_dist(__arg0,__arg1,__arg2)(__pos)
  override def infix_length[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload6) = densevector_length[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_isRow[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload5) = densevector_isrow[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_slice[T:Manifest](self: Rep[DenseVector[T]],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload6): Rep[DenseVector[T]] = { self(start::end) }
  override def infix_t[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload4) = densevector_t[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_mt[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = densevector_mt[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_Clone[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload6) = densevector_clone[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_<<[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload7) = densevector_ltlt[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload7)
  override def infix_<<[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload8) = densevector_ltlt[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload8)
  override def infix_insert[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext,__imp1: Overload2) = densevector_insert[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  override def infix_insertAll[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = densevector_insertall[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  override def infix_remove[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = densevector_remove[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  override def infix_removeAll[T:Manifest](self: Rep[DenseVector[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = densevector_removeall[T](self,pos,len)(implicitly[Manifest[T]],__pos)
  override def infix_copyFrom[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = densevector_copyfrom[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  override def infix_trim[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload4) = densevector_trim[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_clear[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = densevector_clear[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_+=[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload3) = densevector_pleq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload3)
  override def infix_+=[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload4) = densevector_pleq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload4)
  override def infix_+=[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload5) = densevector_pleq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload5)
  override def infix_*=[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload3) = densevector_muleq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload3)
  override def infix_*=[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload4) = densevector_muleq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload4)
  override def infix_*=[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload5) = densevector_muleq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload5)
  override def infix_-=[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload3) = densevector_subeq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload3)
  override def infix_-=[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload4) = densevector_subeq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload4)
  override def infix_-=[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload5) = densevector_subeq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload5)
  override def infix_/=[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload3) = densevector_diveq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload3)
  override def infix_/=[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload4) = densevector_diveq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload4)
  override def infix_/=[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload5) = densevector_diveq[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload5)
  override def infix_:>[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload2) = densevector_clngt[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_:<[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload2) = densevector_clnlt[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  override def __equal[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload12) = densevector___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload12)
  override def __equal[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp1: Overload13) = densevector___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload13)
  override def __equal[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload14) = densevector___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload14)
  override def __equal[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp1: Overload15) = densevector___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload15)
  override def infix_+(__arg0: Rep[Int],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: ROverload104): Rep[DenseVector[Int]] = { densevector_pl[Int](__arg1,__arg0) }
  override def infix_+(__arg0: Rep[Int],__arg1: Rep[DenseVector[Float]])(implicit __pos: SourceContext,__imp1: ROverload105): Rep[DenseVector[Float]] = { densevector_pl[Float](__arg1,__arg0.toFloat) }
  override def infix_+(__arg0: Rep[Int],__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext,__imp1: ROverload106): Rep[DenseVector[Double]] = { densevector_pl[Double](__arg1,__arg0.toDouble) }
  override def infix_+(__arg0: Rep[Float],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: ROverload107): Rep[DenseVector[Float]] = { densevector_pl[Float](__arg1.toFloat,__arg0) }
  override def infix_+(__arg0: Rep[Float],__arg1: Rep[DenseVector[Float]])(implicit __pos: SourceContext,__imp1: ROverload108): Rep[DenseVector[Float]] = { densevector_pl[Float](__arg1,__arg0) }
  override def infix_+(__arg0: Rep[Float],__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext,__imp1: ROverload109): Rep[DenseVector[Double]] = { densevector_pl[Double](__arg1,__arg0.toDouble) }
  override def infix_+(__arg0: Rep[Double],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: ROverload110): Rep[DenseVector[Double]] = { densevector_pl[Double](__arg1.toDouble,__arg0) }
  override def infix_+(__arg0: Rep[Double],__arg1: Rep[DenseVector[Float]])(implicit __pos: SourceContext,__imp1: ROverload111): Rep[DenseVector[Double]] = { densevector_pl[Double](__arg1.toDouble,__arg0) }
  override def infix_+(__arg0: Rep[Double],__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext,__imp1: ROverload112): Rep[DenseVector[Double]] = { densevector_pl[Double](__arg1,__arg0) }
  override def infix_+(__arg0: Rep[DenseVector[Int]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload113): Rep[DenseVector[Int]] = { densevector_pl[Int](__arg0,__arg1) }
  override def infix_+(__arg0: Rep[DenseVector[Int]],__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload114): Rep[DenseVector[Float]] = { densevector_pl[Float](__arg0.toFloat,__arg1) }
  override def infix_+(__arg0: Rep[DenseVector[Int]],__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload115): Rep[DenseVector[Double]] = { densevector_pl[Double](__arg0.toDouble,__arg1) }
  override def infix_+(__arg0: Rep[DenseVector[Float]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload116): Rep[DenseVector[Float]] = { densevector_pl[Float](__arg0,__arg1.toFloat) }
  override def infix_+(__arg0: Rep[DenseVector[Float]],__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload117): Rep[DenseVector[Float]] = { densevector_pl[Float](__arg0,__arg1) }
  override def infix_+(__arg0: Rep[DenseVector[Float]],__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload118): Rep[DenseVector[Double]] = { densevector_pl[Double](__arg0.toDouble,__arg1) }
  override def infix_+(__arg0: Rep[DenseVector[Double]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload119): Rep[DenseVector[Double]] = { densevector_pl[Double](__arg0,__arg1.toDouble) }
  override def infix_+(__arg0: Rep[DenseVector[Double]],__arg1: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload120): Rep[DenseVector[Double]] = { densevector_pl[Double](__arg0.toDouble,__arg1) }
  override def infix_+(__arg0: Rep[DenseVector[Double]],__arg1: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload121): Rep[DenseVector[Double]] = { densevector_pl[Double](__arg0,__arg1) }
  override def infix_+(__arg0: Rep[DenseVector[Int]],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: ROverload122): Rep[DenseVector[Int]] = { densevector_pl[Int](__arg0,__arg1) }
  override def infix_+(__arg0: Rep[DenseVector[Int]],__arg1: Rep[DenseVector[Float]])(implicit __pos: SourceContext,__imp1: ROverload123): Rep[DenseVector[Float]] = { densevector_pl[Float](__arg0.toFloat,__arg1) }
  override def infix_+(__arg0: Rep[DenseVector[Int]],__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext,__imp1: ROverload124): Rep[DenseVector[Double]] = { densevector_pl[Double](__arg0.toDouble,__arg1) }
  override def infix_+(__arg0: Rep[DenseVector[Float]],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: ROverload125): Rep[DenseVector[Float]] = { densevector_pl[Float](__arg0,__arg1.toFloat) }
  override def infix_+(__arg0: Rep[DenseVector[Float]],__arg1: Rep[DenseVector[Float]])(implicit __pos: SourceContext,__imp1: ROverload126): Rep[DenseVector[Float]] = { densevector_pl[Float](__arg0,__arg1) }
  override def infix_+(__arg0: Rep[DenseVector[Float]],__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext,__imp1: ROverload127): Rep[DenseVector[Double]] = { densevector_pl[Double](__arg0.toDouble,__arg1) }
  override def infix_+(__arg0: Rep[DenseVector[Double]],__arg1: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: ROverload128): Rep[DenseVector[Double]] = { densevector_pl[Double](__arg0,__arg1.toDouble) }
  override def infix_+(__arg0: Rep[DenseVector[Double]],__arg1: Rep[DenseVector[Float]])(implicit __pos: SourceContext,__imp1: ROverload129): Rep[DenseVector[Double]] = { densevector_pl[Double](__arg0,__arg1.toDouble) }
  override def infix_+(__arg0: Rep[DenseVector[Double]],__arg1: Rep[DenseVector[Double]])(implicit __pos: SourceContext,__imp1: ROverload130): Rep[DenseVector[Double]] = { densevector_pl[Double](__arg0,__arg1) }
  override def infix_unary_-(__arg0: Rep[DenseVector[Int]])(implicit __pos: SourceContext,__imp1: ROverload8): Rep[DenseVector[Int]] = { densevector_mul[Int](__arg0,unit(-1)) }
  override def infix_unary_-(__arg0: Rep[DenseVector[Float]])(implicit __pos: SourceContext,__imp1: ROverload9): Rep[DenseVector[Float]] = { densevector_mul[Float](__arg0,unit(-1f)) }
  override def infix_unary_-(__arg0: Rep[DenseVector[Double]])(implicit __pos: SourceContext,__imp1: ROverload10): Rep[DenseVector[Double]] = { densevector_mul[Double](__arg0,unit(-1.0)) }
  override def infix_indices[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload6) = densevector_indices[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_isEmpty[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload4) = densevector_isempty[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_first[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload4) = densevector_first[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_last[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload4) = densevector_last[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_drop[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload4) = densevector_drop[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  override def infix_take[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload4) = densevector_take[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  override def infix_contains[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload9) = densevector_contains[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  override def infix_distinct[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload4) = densevector_distinct[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_mutable[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp1: Overload15) = densevector_mutable[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_replicate[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload4) = densevector_replicate[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  override def infix_makeString[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Stringable[T],__imp2: Overload6) = densevector_makestring[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_toString[T:Manifest](self: Rep[DenseVector[T]])(implicit __imp0: Overload15) = densevector_tostring[T](self)
  override def infix_pprint[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Stringable[T],__imp2: Overload6) = densevector_pprint[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_+[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload131) = densevector_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload131)
  override def infix_*:*[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload22) = densevector_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload22)
  override def infix_**[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload10) = densevector_mulmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload10)
  override def infix_+[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload132) = densevector_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload132)
  override def infix_*:*[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload23) = densevector_dot_densevectorview[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_**[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload11) = densevector_mulmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload11)
  override def infix_+[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload133) = densevector_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload133)
  override def infix_*:*[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload24) = densevector_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload24)
  override def infix_**[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload12) = densevector_mulmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload12)
  override def infix_+[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload134) = densevector_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload134)
  override def infix_*:*[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload25) = densevector_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload25)
  override def infix_**[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[SparseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload13) = densevector_mulmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload13)
  override def infix_+[T:Manifest](self: Rep[DenseVector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload135) = densevector_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload135)
  override def infix_abs[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload21) = densevector_abs[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_exp[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload20) = densevector_exp[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_log[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload20) = densevector_log[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_sum[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload5) = densevector_sum[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_prod[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload4) = densevector_prod[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_min[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload6) = densevector_min[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_max[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload6) = densevector_max[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_minIndex[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp1: Arith[T],__imp3: Overload4) = densevector_minindex[T](self)(implicitly[Manifest[T]],__pos,__imp0,__imp1)
  override def infix_maxIndex[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp1: Arith[T],__imp3: Overload4) = densevector_maxindex[T](self)(implicitly[Manifest[T]],__pos,__imp0,__imp1)
  override def infix_prefixSum[T:Manifest](self: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload3) = densevector_prefixsum[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def dist(__arg0: Rep[DenseVector[Double]],__arg1: Rep[DenseVector[Double]],__arg2: DistanceMetric)(implicit __pos: SourceContext,__imp1: Overload4) = densevector_dist(__arg0,__arg1,__arg2)(__pos)
  override def infix_data(self: Rep[GrayscaleImage])(implicit __pos: SourceContext,__imp1: Overload2) = grayscaleimage_data(self)(__pos)
  override def infix_numRows(self: Rep[GrayscaleImage])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[Int] = { self.data.numRows }
  override def infix_numCols(self: Rep[GrayscaleImage])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[Int] = { self.data.numCols }
  override def infix_numRows[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload5) = sparsematrix_numrows[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_numCols[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload5) = sparsematrix_numcols[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_size[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload15) = sparsematrix_size[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_nnz[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload4) = sparsematrix_nnz[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_nz[T:Manifest](self: Rep[SparseMatrix[T]],asRow: Rep[Boolean] = unit(true))(implicit __pos: SourceContext,__imp1: Overload3) = sparsematrix_nz[T](self,asRow)(implicitly[Manifest[T]],__pos)
  override def infix_rowIndices[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_rowindices[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_colIndices[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_colindices[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_getRow[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_getrow[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  override def infix_getRows[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_getrows[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  override def infix_getCol[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_getcol[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  override def infix_getCols[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload2) = sparsematrix_getcols[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  override def infix_slice[T:Manifest](self: Rep[SparseMatrix[T]],startRow: Rep[Int],endRow: Rep[Int],startCol: Rep[Int],endCol: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload7): Rep[SparseMatrix[T]] = { self(startRow::endRow, startCol::endCol) }
  override def infix_sliceRows[T:Manifest](self: Rep[SparseMatrix[T]],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[SparseMatrix[T]] = { self.getRows(start::end) }
  override def infix_sliceCols[T:Manifest](self: Rep[SparseMatrix[T]],start: Rep[Int],end: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[SparseMatrix[T]] = { self.getCols(start::end) }
  override def infix_t[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload5) = sparsematrix_t[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_Clone[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload7) = sparsematrix_clone[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_mutable[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload17) = sparsematrix_mutable[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_toDense[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload5) = sparsematrix_todense[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_pprint[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Stringable[T],__imp2: Overload7) = sparsematrix_pprint[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_makeString[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Stringable[T],__imp2: Overload7) = sparsematrix_makestring[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_toString[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __imp0: Overload16) = sparsematrix_tostring[T](self)
  override def infix_+[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload136) = sparsematrix_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload136)
  override def infix_+[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload137) = sparsematrix_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload137)
  override def infix_+[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload138) = sparsematrix_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload138)
  override def infix_*:*[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload26) = sparsematrix_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload26)
  override def infix_*:*[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload27) = sparsematrix_mulclnmul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0,overload27)
  override def infix_sum[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload6) = sparsematrix_sum[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_abs[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload22) = sparsematrix_abs[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_sumRows[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = sparsematrix_sumrows[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_sumCols[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = sparsematrix_sumcols[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_min[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload7) = sparsematrix_min[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_max[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload7) = sparsematrix_max[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_minRows[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload2) = sparsematrix_minrows[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_minCols[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload2) = sparsematrix_mincols[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_maxRows[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload2) = sparsematrix_maxrows[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_maxCols[T:Manifest](self: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload2) = sparsematrix_maxcols[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  override def __equal[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload16) = sparsematrix___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload16)
  override def __equal[T:Manifest](self: Rep[SparseMatrix[T]],__arg1: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp1: Overload17) = sparsematrix___equal[T](self,__arg1)(implicitly[Manifest[T]],__pos,overload17)
  override def __equal[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext,__imp1: Overload18) = ordering2___equal[A,B](__arg0,__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos,overload18)
  override def infix_!=[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext,__imp1: Overload1) = ordering2_bangeq[A,B](__arg0,__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos,overload1)
  override def infix_min[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext,__imp1: Overload8) = ordering2_min[A](__arg0,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos)
  override def infix_max[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext,__imp1: Overload8) = ordering2_max[A](__arg0,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos)
  override def readVector(path: Rep[String])(implicit __pos: SourceContext,__imp1: Overload1) = laio_readvector(path)(__pos,overload1)
  override def readMatrix(path: Rep[String])(implicit __pos: SourceContext,__imp1: Overload1) = laio_readmatrix(path)(__pos,overload1)
  override def readMatrix(path: Rep[String],delim: Rep[String])(implicit __pos: SourceContext,__imp1: Overload2) = laio_readmatrix(path,delim)(__pos,overload2)
  override def readVector[Elem:Manifest](path: Rep[String],schemaBldr: (Rep[DenseVector[String]]) => Rep[Elem],delim: Rep[String] = unit("\\s+"))(implicit __pos: SourceContext,__imp1: Overload2) = laio_readvector[Elem](path,schemaBldr,delim)(implicitly[Manifest[Elem]],__pos,overload2)
  override def readMatrix[Elem:Manifest](path: Rep[String],schemaBldr: (Rep[String]) => Rep[Elem],delim: Rep[String] = unit("\\s+"))(implicit __pos: SourceContext,__imp1: Overload3) = laio_readmatrix[Elem](path,schemaBldr,delim)(implicitly[Manifest[Elem]],__pos,overload3)
  override def abs(__arg0: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Double] = { Math.abs(__arg0) }
  override def exp(__arg0: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Double] = { Math.exp(__arg0) }
  override def log(__arg0: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Double] = { Math.log(__arg0) }
  override def square(__arg0: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Double] = { __arg0*__arg0 }
  override def max[T:Numeric:Manifest](__arg0: Rep[T],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload1) = basicmath_max[T](__arg0,__arg1)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos,overload1)
  override def min[T:Numeric:Manifest](__arg0: Rep[T],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload1) = basicmath_min[T](__arg0,__arg1)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos,overload1)
  override def normpdf(x: Rep[Double],mu: Rep[Double],sigma: Rep[Double])(implicit __pos: SourceContext,__imp1: Overload1) = basicmath_normpdf(x,mu,sigma)(__pos,overload1)
  override def normpdf(x: Rep[DenseVector[Double]],mu: Rep[DenseVector[Double]],sigma: Rep[DenseVector[Double]])(implicit __pos: SourceContext,__imp1: Overload2) = basicmath_normpdf(x,mu,sigma)(__pos,overload2)
  override def normpdf(x: Rep[DenseMatrix[Double]],mu: Rep[DenseMatrix[Double]],sigma: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: Overload3) = basicmath_normpdf(x,mu,sigma)(__pos,overload3)
  override def normpdf(x: Rep[DenseVector[Double]],mu: Rep[Double],sigma: Rep[DenseVector[Double]])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[DenseVector[Double]] = { x.zip(sigma) { (a,b) => normpdf(a, mu, b) } }
  override def normpdf(x: Rep[DenseVector[Double]],mu: Rep[DenseVector[Double]],sigma: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload5): Rep[DenseVector[Double]] = { x.zip(mu) { (a,b) => normpdf(a, b, sigma) } }
  override def normpdf(x: Rep[DenseVector[Double]],mu: Rep[Double],sigma: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload6): Rep[DenseVector[Double]] = { x.map { e => normpdf(e, mu, sigma) } }
  override def normpdf(x: Rep[DenseMatrix[Double]],mu: Rep[Double],sigma: Rep[DenseMatrix[Double]])(implicit __pos: SourceContext,__imp1: ROverload7): Rep[DenseMatrix[Double]] = { x.zip(sigma) { (a,b) => normpdf(a, mu, b) } }
  override def normpdf(x: Rep[DenseMatrix[Double]],mu: Rep[DenseMatrix[Double]],sigma: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload8): Rep[DenseMatrix[Double]] = { x.zip(mu) { (a,b) => normpdf(a, b, sigma) } }
  override def normpdf(x: Rep[DenseMatrix[Double]],mu: Rep[Double],sigma: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload9): Rep[DenseMatrix[Double]] = { x.map { e => normpdf(e, mu, sigma) } }
  override def abs[T:Manifest](__arg0: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: ROverload2): Rep[DenseVector[T]] = { __arg0.abs }
  override def exp[T:Manifest](__arg0: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: ROverload2): Rep[DenseVector[T]] = { __arg0.exp }
  override def log[T:Manifest](__arg0: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: ROverload2): Rep[DenseVector[T]] = { __arg0.log }
  override def square[T:Manifest](__arg0: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload2) = basicmath_square[T](__arg0)(implicitly[Manifest[T]],__pos,__imp0,overload2)
  override def sum[T:Manifest](__arg0: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: ROverload1): Rep[T] = { __arg0.sum }
  override def prod[T:Manifest](__arg0: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: ROverload1): Rep[T] = { __arg0.prod }
  override def mean[T:Manifest](__arg0: Rep[DenseVector[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double],__imp2: ROverload1): Rep[Double] = { __arg0.mean }
  override def min[T:Manifest](__arg0: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: ROverload2): Rep[T] = { __arg0.min }
  override def max[T:Manifest](__arg0: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: ROverload2): Rep[T] = { __arg0.max }
  override def median[T:Manifest](__arg0: Rep[DenseVector[T]])(implicit __pos: SourceContext,__imp0: Numeric[T],__imp1: Ordering[T],__imp3: ROverload1): Rep[T] = { __arg0.median }
  override def abs[T:Manifest](__arg0: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: ROverload3): Rep[DenseVector[T]] = { __arg0.abs }
  override def exp[T:Manifest](__arg0: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: ROverload3): Rep[DenseVector[T]] = { __arg0.exp }
  override def log[T:Manifest](__arg0: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: ROverload3): Rep[DenseVector[T]] = { __arg0.log }
  override def square[T:Manifest](__arg0: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload3) = basicmath_square[T](__arg0)(implicitly[Manifest[T]],__pos,__imp0,overload3)
  override def sum[T:Manifest](__arg0: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: ROverload2): Rep[T] = { __arg0.sum }
  override def prod[T:Manifest](__arg0: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: ROverload2): Rep[T] = { __arg0.prod }
  override def mean[T:Manifest](__arg0: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double],__imp2: ROverload2): Rep[Double] = { __arg0.mean }
  override def min[T:Manifest](__arg0: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: ROverload3): Rep[T] = { __arg0.min }
  override def max[T:Manifest](__arg0: Rep[DenseVectorView[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: ROverload3): Rep[T] = { __arg0.max }
  override def abs(__arg0: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[DenseVector[Int]] = { __arg0.abs }
  override def exp(__arg0: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[DenseVector[Int]] = { __arg0.exp }
  override def log(__arg0: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[DenseVector[Int]] = { __arg0.log }
  override def square(__arg0: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: Overload4) = basicmath_square(__arg0)(__pos,overload4)
  override def sum(__arg0: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: ROverload3): Rep[Int] = { __arg0.sum }
  override def prod(__arg0: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: ROverload3): Rep[Int] = { __arg0.prod }
  override def mean(__arg0: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: ROverload3): Rep[Double] = { __arg0.mean }
  override def min(__arg0: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[Int] = { __arg0.min }
  override def max(__arg0: Rep[IndexVector])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[Int] = { __arg0.max }
  override def abs[T:Manifest](__arg0: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: ROverload5): Rep[DenseMatrix[T]] = { __arg0.abs }
  override def exp[T:Manifest](__arg0: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: ROverload5): Rep[DenseMatrix[T]] = { __arg0.exp }
  override def log[T:Manifest](__arg0: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: ROverload5): Rep[DenseMatrix[T]] = { __arg0.log }
  override def square[T:Manifest](__arg0: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload5) = basicmath_square[T](__arg0)(implicitly[Manifest[T]],__pos,__imp0,overload5)
  override def sum[T:Manifest](__arg0: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: ROverload4): Rep[T] = { __arg0.sum }
  override def prod[T:Manifest](__arg0: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: ROverload4): Rep[T] = { __arg0.prod }
  override def mean[T:Manifest](__arg0: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double],__imp2: ROverload4): Rep[Double] = { __arg0.mean }
  override def min[T:Manifest](__arg0: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: ROverload5): Rep[T] = { __arg0.min }
  override def max[T:Manifest](__arg0: Rep[DenseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: ROverload5): Rep[T] = { __arg0.max }
  override def abs[T:Manifest](__arg0: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: ROverload6): Rep[SparseVector[T]] = { __arg0.abs }
  override def square[T:Manifest](__arg0: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload6) = basicmath_square[T](__arg0)(implicitly[Manifest[T]],__pos,__imp0,overload6)
  override def sum[T:Manifest](__arg0: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: ROverload5): Rep[T] = { __arg0.sum }
  override def mean[T:Manifest](__arg0: Rep[SparseVector[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double],__imp2: ROverload5): Rep[Double] = { __arg0.mean }
  override def min[T:Manifest](__arg0: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: ROverload6): Rep[T] = { __arg0.min }
  override def max[T:Manifest](__arg0: Rep[SparseVector[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: ROverload6): Rep[T] = { __arg0.max }
  override def abs[T:Manifest](__arg0: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: ROverload7): Rep[SparseMatrix[T]] = { __arg0.abs }
  override def square[T:Manifest](__arg0: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: Overload7) = basicmath_square[T](__arg0)(implicitly[Manifest[T]],__pos,__imp0,overload7)
  override def sum[T:Manifest](__arg0: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Arith[T],__imp2: ROverload6): Rep[T] = { __arg0.sum }
  override def mean[T:Manifest](__arg0: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double],__imp2: ROverload6): Rep[Double] = { __arg0.mean }
  override def min[T:Manifest](__arg0: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: ROverload7): Rep[T] = { __arg0.min }
  override def max[T:Manifest](__arg0: Rep[SparseMatrix[T]])(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: ROverload7): Rep[T] = { __arg0.max }
  override def mean[T:Manifest](__arg0: Rep[T]*)(implicit __pos: SourceContext,conv: (Rep[T]) => Rep[Double],__imp2: Overload7) = basicmath_mean[T](__arg0)(implicitly[Manifest[T]],__pos,conv,overload7)
  override def min[T:Manifest](__arg0: Rep[T]*)(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload8) = basicmath_min[T](__arg0)(implicitly[Manifest[T]],__pos,__imp0,overload8)
  override def max[T:Manifest](__arg0: Rep[T]*)(implicit __pos: SourceContext,__imp0: Ordering[T],__imp2: Overload8) = basicmath_max[T](__arg0)(implicitly[Manifest[T]],__pos,__imp0,overload8)
  override def median[T:Manifest](__arg0: Rep[T]*)(implicit __pos: SourceContext,__imp0: Numeric[T],__imp1: Ordering[T],__imp3: Overload2) = basicmath_median[T](__arg0)(implicitly[Manifest[T]],__pos,__imp0,__imp1,overload2)
  override def __newVar[T](x: T) = super.__newVar(x)
  def infix_!=(x: Int, y: Int) = ordering2_bangeq(x,y)
  def infix_!=(x: Int, y: Float) = ordering2_bangeq(x,y)
  def infix_!=(x: Int, y: Double) = ordering2_bangeq(x,y)
  def infix_!=(x: Float, y: Int) = ordering2_bangeq(x,y)
  def infix_!=(x: Float, y: Float) = ordering2_bangeq(x,y)
  def infix_!=(x: Float, y: Double) = ordering2_bangeq(x,y)
  def infix_!=(x: Double, y: Int) = ordering2_bangeq(x,y)
  def infix_!=(x: Double, y: Float) = ordering2_bangeq(x,y)
  def infix_!=(x: Double, y: Double) = ordering2_bangeq(x,y)
  def infix_!=(x: Boolean, y: Boolean) = ordering2_bangeq(x,y)
}

/**
 * dsl library definition
 */
trait OptiMLBase extends OptiMLIdentifiers {
  type Rep[+T] = T
  protected def unit[T:Manifest](x: T) = x
}

trait OptiMLCompilerOps extends OptiMLApplication
 with SparseVectorViewCompilerOps with Tup2CompilerOps with Tup9CompilerOps with Tup8CompilerOps with DiscreteFeatureCompilerOps with CHashMapCompilerOps with IndexVectorCompilerOps with FactorGraphCompilerOps with Tup7CompilerOps with SparseVectorCompilerOps with UTriangleCompilerOps with RandCompilerOps with Tup6CompilerOps with FunctionFactorCompilerOps with MLioCompilerOps with ComputeStreamCompilerOps with FStringCompilerOps with SHashMapCompilerOps with LinAlgCompilerOps with SparseMatrixBuildableCompilerOps with RangeCompilerOps with Tup3CompilerOps with DenseVectorViewCompilerOps with Tup4CompilerOps with Tup5CompilerOps with DenseMatrixCompilerOps with DenseVectorCompilerOps with SparseMatrixCompilerOps with LAioCompilerOps with FileStreamCompilerOps with ForgeArrayCompilerOps with ForgeArrayBufferCompilerOps with ForgeHashMapCompilerOps with VarCompilerOps with LambdaCompilerOps with RecordCompilerOps with InputOutputCompilerOps with ProfilingCompilerOps with ReppableCompilerOps with TestsCompilerOps with AssertsCompilerOps with BLASCompilerOps with LAPACKCompilerOps with RewriteCompilerOps with SumCompilerOps

trait OptiMLLib extends OptiMLBase with OptiMLCompilerOps with OptiMLClasses {
  this: OptiMLApplication => 

  // override required due to mix-in
  override type Rep[+T] = T

  /**
   * dsl types
   */
  def m_Tup2[A:Manifest,B:Manifest] = manifest[Tup2[A,B]]
  def m_Tup3[A:Manifest,B:Manifest,C:Manifest] = manifest[Tup3[A,B,C]]
  def m_Tup4[A:Manifest,B:Manifest,C:Manifest,D:Manifest] = manifest[Tup4[A,B,C,D]]
  def m_Tup5[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest] = manifest[Tup5[A,B,C,D,E]]
  def m_Tup6[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest] = manifest[Tup6[A,B,C,D,E,F]]
  def m_Tup7[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest] = manifest[Tup7[A,B,C,D,E,F,G]]
  def m_Tup8[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest] = manifest[Tup8[A,B,C,D,E,F,G,H]]
  def m_Tup9[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest] = manifest[Tup9[A,B,C,D,E,F,G,H,I]]
  def m_DenseVector[T:Manifest] = manifest[DenseVector[T]]
  def m_DenseVectorView[T:Manifest] = manifest[DenseVectorView[T]]
  def m_DenseMatrix[T:Manifest] = manifest[DenseMatrix[T]]
  def m_IndexVector = manifest[IndexVector]
  def m_SparseVector[T:Manifest] = manifest[SparseVector[T]]
  def m_SparseVectorView[T:Manifest] = manifest[SparseVectorView[T]]
  def m_SparseMatrix[T:Manifest] = manifest[SparseMatrix[T]]
  def m_SparseMatrixBuildable[T:Manifest] = manifest[SparseMatrixBuildable[T]]
  def m_Range = manifest[Range]
  def m_Complex = manifest[Complex]
  def m_UTriangle = manifest[UTriangle]
  def m_ContinuousFeature = manifest[ContinuousFeature]
  def m_DiscreteFeature = manifest[DiscreteFeature]
  def m_BinaryFeature = manifest[BinaryFeature]
  def m_TrainingSet[D:Manifest,L:Manifest] = manifest[TrainingSet[D,L]]
  def m_FactorVariable = manifest[FactorVariable]
  def m_TableFactor = manifest[TableFactor]
  def m_FunctionFactor = manifest[FunctionFactor]
  def m_RandomVariable = manifest[RandomVariable]
  def m_Weight = manifest[Weight]
  def m_FactorGraph[F:Factor:Manifest] = manifest[FactorGraph[F]]
  def m_FileStream = manifest[FileStream]
  def m_ComputeStream[T:Manifest] = manifest[ComputeStream[T]]
  def m_GrayscaleImage = manifest[GrayscaleImage]

}

