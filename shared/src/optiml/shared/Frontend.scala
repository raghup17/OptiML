package optiml.shared

import java.io.{BufferedWriter, FileWriter, PrintWriter}
import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._

// the trait that all OptiML applications must extend
trait OptiMLApplication extends OptiML with OptiMLLift {
  var args: Rep[Array[String]]
  def main()
}

/**
 * dsl definition
 */
trait OptiMLLift
  extends LiftPrimitive2 with LiftFString with LiftVar {  this: OptiML =>
}


trait OptiMLIdentifiers extends Base with GenOverloadHack {
  /**
   * singleton identifiers
   */
  object * extends IndexWildcard
  object ABS extends DistanceMetric
  object SQUARE extends DistanceMetric
  object EUC extends DistanceMetric

  /**
   * types with no associated data structure
   */
  abstract class IndexWildcard
  implicit def m_IndexWildcard = manifest[IndexWildcard]
  abstract class DistanceMetric
  implicit def m_DistanceMetric = manifest[DistanceMetric]
}

trait OptiML extends OptiMLIdentifiers
 with TableFactorOps with SparseVectorViewOps with Tup2Ops with ComplexOps with ContinuousFeatureOps with Tup9Ops with Tup8Ops with DiscreteFeatureOps with Primitive2Ops with CHashMapOps with IndexVectorOps with StringableOps with MathOps with FactorGraphOps with BinaryFeatureOps with WeightOps with Tup7Ops with SparseVectorOps with UTriangleOps with RandOps with Tup6Ops with FunctionFactorOps with MLioOps with ComputeStreamOps with FStringOps with SHashMapOps with TrainingSetOps with LinAlgOps with SparseMatrixBuildableOps with MiscOps with RangeOps with FactorVariableOps with CastOps with Tup3Ops with BufferableOps with DenseVectorViewOps with Tup4Ops with ArithOps with RandomVariableOps with Tup5Ops with DenseMatrixOps with DenseVectorOps with SparseMatrixOps with GrayscaleImageOps with ControlOps with FactorOps with Ordering2Ops with LAioOps with ShapeOps with FileStreamOps with BasicMathOps with ForgeArrayOps with ForgeArrayBufferOps with ForgeHashMapOps with VarOps with LambdaOps with RecordOps with InputOutputOps with ProfilingOps with ReppableOps with TestsOps with AssertsOps with BLASOps with LAPACKOps with RewriteOps with SumOps {
  this: OptiMLApplication => 

  /**
   * abstract types
   */
  type Tup2[A,B]
  implicit def m_Tup2[A:Manifest,B:Manifest]: Manifest[Tup2[A,B]]
  type Tup3[A,B,C]
  implicit def m_Tup3[A:Manifest,B:Manifest,C:Manifest]: Manifest[Tup3[A,B,C]]
  type Tup4[A,B,C,D]
  implicit def m_Tup4[A:Manifest,B:Manifest,C:Manifest,D:Manifest]: Manifest[Tup4[A,B,C,D]]
  type Tup5[A,B,C,D,E]
  implicit def m_Tup5[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest]: Manifest[Tup5[A,B,C,D,E]]
  type Tup6[A,B,C,D,E,F]
  implicit def m_Tup6[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest]: Manifest[Tup6[A,B,C,D,E,F]]
  type Tup7[A,B,C,D,E,F,G]
  implicit def m_Tup7[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest]: Manifest[Tup7[A,B,C,D,E,F,G]]
  type Tup8[A,B,C,D,E,F,G,H]
  implicit def m_Tup8[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest]: Manifest[Tup8[A,B,C,D,E,F,G,H]]
  type Tup9[A,B,C,D,E,F,G,H,I]
  implicit def m_Tup9[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest]: Manifest[Tup9[A,B,C,D,E,F,G,H,I]]
  type DenseVector[T]
  implicit def m_DenseVector[T:Manifest]: Manifest[DenseVector[T]]
  type DenseVectorView[T]
  implicit def m_DenseVectorView[T:Manifest]: Manifest[DenseVectorView[T]]
  type DenseMatrix[T]
  implicit def m_DenseMatrix[T:Manifest]: Manifest[DenseMatrix[T]]
  type IndexVector
  implicit def m_IndexVector: Manifest[IndexVector]
  type SparseVector[T]
  implicit def m_SparseVector[T:Manifest]: Manifest[SparseVector[T]]
  type SparseVectorView[T]
  implicit def m_SparseVectorView[T:Manifest]: Manifest[SparseVectorView[T]]
  type SparseMatrix[T]
  implicit def m_SparseMatrix[T:Manifest]: Manifest[SparseMatrix[T]]
  type SparseMatrixBuildable[T]
  implicit def m_SparseMatrixBuildable[T:Manifest]: Manifest[SparseMatrixBuildable[T]]
  type Range
  implicit def m_Range: Manifest[Range]
  type Complex
  implicit def m_Complex: Manifest[Complex]
  type UTriangle
  implicit def m_UTriangle: Manifest[UTriangle]
  type ContinuousFeature
  implicit def m_ContinuousFeature: Manifest[ContinuousFeature]
  type DiscreteFeature
  implicit def m_DiscreteFeature: Manifest[DiscreteFeature]
  type BinaryFeature
  implicit def m_BinaryFeature: Manifest[BinaryFeature]
  type TrainingSet[D,L]
  implicit def m_TrainingSet[D:Manifest,L:Manifest]: Manifest[TrainingSet[D,L]]
  type FactorVariable
  implicit def m_FactorVariable: Manifest[FactorVariable]
  type TableFactor
  implicit def m_TableFactor: Manifest[TableFactor]
  type FunctionFactor
  implicit def m_FunctionFactor: Manifest[FunctionFactor]
  type RandomVariable
  implicit def m_RandomVariable: Manifest[RandomVariable]
  type Weight
  implicit def m_Weight: Manifest[Weight]
  type FactorGraph[F]
  implicit def m_FactorGraph[F:Factor:Manifest]: Manifest[FactorGraph[F]]
  type FileStream
  implicit def m_FileStream: Manifest[FileStream]
  type ComputeStream[T]
  implicit def m_ComputeStream[T:Manifest]: Manifest[ComputeStream[T]]
  type GrayscaleImage
  implicit def m_GrayscaleImage: Manifest[GrayscaleImage]

  /**
   * hacks for Scala-Virtualized
   */
  override def __ifThenElse[T](cond: => Boolean, thenp: => T, elsep: => T) = cond match {
    case true => thenp
    case false => elsep
  }

}

