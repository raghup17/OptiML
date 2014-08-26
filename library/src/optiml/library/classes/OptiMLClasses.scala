package optiml.library.classes

import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._
import optiml.library._
import optiml.library.classes._

trait OptiMLClasses extends TableFactorWrapper with TableFactorWrapperImpl with SparseVectorViewWrapper with SparseVectorViewWrapperImpl with Tup2Wrapper with Tup2WrapperImpl with ComplexWrapper with ComplexWrapperImpl with ContinuousFeatureWrapper with ContinuousFeatureWrapperImpl with Tup9Wrapper with Tup9WrapperImpl with Tup8Wrapper with Tup8WrapperImpl with DiscreteFeatureWrapper with DiscreteFeatureWrapperImpl with Primitive2Wrapper with Primitive2WrapperImpl with CHashMapWrapper with CHashMapWrapperImpl with IndexVectorWrapper with IndexVectorWrapperImpl with StringableOps with MathWrapper with BinaryFeatureWrapper with BinaryFeatureWrapperImpl with WeightWrapper with FactorGraphWrapper with FactorGraphWrapperImpl with Tup7Wrapper with Tup7WrapperImpl with SparseVectorWrapper with SparseVectorWrapperImpl with UTriangleWrapper with UTriangleWrapperImpl with RandWrapper with RandWrapperImpl with Tup6Wrapper with Tup6WrapperImpl with FunctionFactorWrapper with FunctionFactorWrapperImpl with MLioWrapper with MLioWrapperImpl with ComputeStreamWrapper with ComputeStreamWrapperImpl with FStringWrapper with FStringWrapperImpl with SHashMapWrapper with SHashMapWrapperImpl with TrainingSetWrapper with TrainingSetWrapperImpl with LinAlgWrapper with LinAlgWrapperImpl with SparseMatrixBuildableWrapper with SparseMatrixBuildableWrapperImpl with MiscWrapper with RangeWrapper with RangeWrapperImpl with FactorVariableWrapper with CastWrapper with Tup3Wrapper with Tup3WrapperImpl with BufferableOps with DenseVectorViewWrapper with DenseVectorViewWrapperImpl with ArithOps with Tup4Wrapper with Tup4WrapperImpl with RandomVariableWrapper with Tup5Wrapper with Tup5WrapperImpl with DenseMatrixWrapper with DenseMatrixWrapperImpl with DenseVectorWrapper with DenseVectorWrapperImpl with GrayscaleImageWrapper with GrayscaleImageWrapperImpl with SparseMatrixWrapper with SparseMatrixWrapperImpl with ControlWrapper with ControlWrapperImpl with FactorOps with Ordering2Wrapper with LAioWrapper with LAioWrapperImpl with ShapeOps with FileStreamWrapper with FileStreamWrapperImpl with BasicMathWrapper with BasicMathWrapperImpl with ForgeArrayWrapper with ForgeArrayBufferWrapper with ForgeHashMapWrapper with VarWrapper with LambdaWrapper with RecordWrapper with InputOutputWrapper with ProfilingWrapper with ReppableWrapper with TestsWrapper with AssertsWrapper with BLASWrapper with LAPACKWrapper with RewriteWrapper with SumWrapper{
  this: OptiMLLib with OptiMLApplication => 
}

