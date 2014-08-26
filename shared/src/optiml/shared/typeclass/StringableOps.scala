package optiml.shared.typeclass

import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._

trait StringableOps extends Base with scala.math.Numeric.ExtraImplicits {
  this: OptiML => 

  /**
   * Type class
   */
  trait Stringable[T] {
    def makeStr(__arg0: Rep[T])(implicit __pos: SourceContext): Rep[String]
  }

  def strtype[A,B](x: Stringable[A]) = x.asInstanceOf[Stringable[B]]

  /**
   * Type class instances
   */

  implicit def canStringableTup4[A:Stringable:Manifest,B:Stringable:Manifest,C:Stringable:Manifest,D:Stringable:Manifest]: Stringable[Tup4[A,B,C,D]] = new Stringable[Tup4[A,B,C,D]] {
    def makeStr(t: Rep[Tup4[A,B,C,D]])(implicit __pos: SourceContext) = {
      "("+t._1.makeStr+","+t._2.makeStr+","+t._3.makeStr+","+t._4.makeStr+")"
    }
  }

  implicit def canStringableTup2[A:Stringable:Manifest,B:Stringable:Manifest]: Stringable[Tup2[A,B]] = new Stringable[Tup2[A,B]] {
    def makeStr(t: Rep[Tup2[A,B]])(implicit __pos: SourceContext) = {
      "("+t._1.makeStr+","+t._2.makeStr+")"
    }
  }

  implicit def canStringableSparseVector[T:Stringable:Manifest]: Stringable[SparseVector[T]] = new Stringable[SparseVector[T]] {
    def makeStr(__arg0: Rep[SparseVector[T]])(implicit __pos: SourceContext) = {
      __arg0.makeString
    }
  }

  implicit def canStringableTup7[A:Stringable:Manifest,B:Stringable:Manifest,C:Stringable:Manifest,D:Stringable:Manifest,E:Stringable:Manifest,F:Stringable:Manifest,G:Stringable:Manifest]: Stringable[Tup7[A,B,C,D,E,F,G]] = new Stringable[Tup7[A,B,C,D,E,F,G]] {
    def makeStr(t: Rep[Tup7[A,B,C,D,E,F,G]])(implicit __pos: SourceContext) = {
      "("+t._1.makeStr+","+t._2.makeStr+","+t._3.makeStr+","+t._4.makeStr+","+t._5.makeStr+","+t._6.makeStr+","+t._7.makeStr+")"
    }
  }

  implicit def canStringableTup3[A:Stringable:Manifest,B:Stringable:Manifest,C:Stringable:Manifest]: Stringable[Tup3[A,B,C]] = new Stringable[Tup3[A,B,C]] {
    def makeStr(t: Rep[Tup3[A,B,C]])(implicit __pos: SourceContext) = {
      "("+t._1.makeStr+","+t._2.makeStr+","+t._3.makeStr+")"
    }
  }

  implicit def canStringableStr: Stringable[String] = new Stringable[String] {
    def makeStr(__arg0: Rep[String])(implicit __pos: SourceContext) = {
      __arg0
    }
  }

  implicit def canStringableTup9[A:Stringable:Manifest,B:Stringable:Manifest,C:Stringable:Manifest,D:Stringable:Manifest,E:Stringable:Manifest,F:Stringable:Manifest,G:Stringable:Manifest,H:Stringable:Manifest,I:Stringable:Manifest]: Stringable[Tup9[A,B,C,D,E,F,G,H,I]] = new Stringable[Tup9[A,B,C,D,E,F,G,H,I]] {
    def makeStr(t: Rep[Tup9[A,B,C,D,E,F,G,H,I]])(implicit __pos: SourceContext) = {
      "("+t._1.makeStr+","+t._2.makeStr+","+t._3.makeStr+","+t._4.makeStr+","+t._5.makeStr+","+t._6.makeStr+","+t._7.makeStr+","+t._8.makeStr+","+t._9.makeStr+")"
    }
  }

  implicit def canStringableFloat: Stringable[Float] = new Stringable[Float] {
    def makeStr(__arg0: Rep[Float])(implicit __pos: SourceContext) = {
      optila_fmt_str(__arg0)
    }
  }

  implicit def canStringableBool: Stringable[Boolean] = new Stringable[Boolean] {
    def makeStr(__arg0: Rep[Boolean])(implicit __pos: SourceContext) = {
      optila_fmt_str(__arg0)
    }
  }

  implicit def canStringableSparseMatrixBuildable[T:Stringable:Manifest]: Stringable[SparseMatrixBuildable[T]] = new Stringable[SparseMatrixBuildable[T]] {
    def makeStr(__arg0: Rep[SparseMatrixBuildable[T]])(implicit __pos: SourceContext) = {
      __arg0.makeString
    }
  }

  implicit def canStringableTup5[A:Stringable:Manifest,B:Stringable:Manifest,C:Stringable:Manifest,D:Stringable:Manifest,E:Stringable:Manifest]: Stringable[Tup5[A,B,C,D,E]] = new Stringable[Tup5[A,B,C,D,E]] {
    def makeStr(t: Rep[Tup5[A,B,C,D,E]])(implicit __pos: SourceContext) = {
      "("+t._1.makeStr+","+t._2.makeStr+","+t._3.makeStr+","+t._4.makeStr+","+t._5.makeStr+")"
    }
  }

  implicit def canStringableTup8[A:Stringable:Manifest,B:Stringable:Manifest,C:Stringable:Manifest,D:Stringable:Manifest,E:Stringable:Manifest,F:Stringable:Manifest,G:Stringable:Manifest,H:Stringable:Manifest]: Stringable[Tup8[A,B,C,D,E,F,G,H]] = new Stringable[Tup8[A,B,C,D,E,F,G,H]] {
    def makeStr(t: Rep[Tup8[A,B,C,D,E,F,G,H]])(implicit __pos: SourceContext) = {
      "("+t._1.makeStr+","+t._2.makeStr+","+t._3.makeStr+","+t._4.makeStr+","+t._5.makeStr+","+t._6.makeStr+","+t._7.makeStr+","+t._8.makeStr+")"
    }
  }

  implicit def canStringableComplex: Stringable[Complex] = new Stringable[Complex] {
    def makeStr(__arg0: Rep[Complex])(implicit __pos: SourceContext) = {
      if (__arg0.imag < unit(0.0)) {
      	    __arg0.real.makeStr + " - " + abs(__arg0.imag) + "i"
      	  }
      	  else {
      	    __arg0.real.makeStr + " + " + abs(__arg0.imag) + "i"
      	  }
    }
  }

  implicit def canStringableDenseMatrix[T:Stringable:Manifest]: Stringable[DenseMatrix[T]] = new Stringable[DenseMatrix[T]] {
    def makeStr(__arg0: Rep[DenseMatrix[T]])(implicit __pos: SourceContext) = {
      __arg0.makeString
    }
  }

  implicit def canStringableDenseVector[T:Stringable:Manifest]: Stringable[DenseVector[T]] = new Stringable[DenseVector[T]] {
    def makeStr(__arg0: Rep[DenseVector[T]])(implicit __pos: SourceContext) = {
      __arg0.makeString
    }
  }

  implicit def canStringableSparseMatrix[T:Stringable:Manifest]: Stringable[SparseMatrix[T]] = new Stringable[SparseMatrix[T]] {
    def makeStr(__arg0: Rep[SparseMatrix[T]])(implicit __pos: SourceContext) = {
      __arg0.makeString
    }
  }

  implicit def canStringableDouble: Stringable[Double] = new Stringable[Double] {
    def makeStr(__arg0: Rep[Double])(implicit __pos: SourceContext) = {
      optila_fmt_str(__arg0)
    }
  }

  implicit def canStringableDenseVectorView[T:Stringable:Manifest]: Stringable[DenseVectorView[T]] = new Stringable[DenseVectorView[T]] {
    def makeStr(__arg0: Rep[DenseVectorView[T]])(implicit __pos: SourceContext) = {
      __arg0.makeString
    }
  }

  implicit def canStringableIndexVector: Stringable[IndexVector] = new Stringable[IndexVector] {
    def makeStr(__arg0: Rep[IndexVector])(implicit __pos: SourceContext) = {
      __arg0.makeString
    }
  }

  implicit def canStringableInt: Stringable[Int] = new Stringable[Int] {
    def makeStr(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
      optila_fmt_str(__arg0)
    }
  }

  implicit def canStringableTup6[A:Stringable:Manifest,B:Stringable:Manifest,C:Stringable:Manifest,D:Stringable:Manifest,E:Stringable:Manifest,F:Stringable:Manifest]: Stringable[Tup6[A,B,C,D,E,F]] = new Stringable[Tup6[A,B,C,D,E,F]] {
    def makeStr(t: Rep[Tup6[A,B,C,D,E,F]])(implicit __pos: SourceContext) = {
      "("+t._1.makeStr+","+t._2.makeStr+","+t._3.makeStr+","+t._4.makeStr+","+t._5.makeStr+","+t._6.makeStr+")"
    }
  }


  /**
   * Forwarders - these allow infix notation to be used when the type class is available
   */
  implicit class Stringable2StringableOps[T:Manifest:Stringable](self: Rep[T]) {
    def makeStr()(implicit __pos: SourceContext) = stringable_makestr[T](self)
  }

  def stringable_makestr[T:Manifest:Stringable](__arg0: Rep[T])(implicit __pos: SourceContext): Rep[String] = implicitly[Stringable[T]].makeStr(__arg0)
}
