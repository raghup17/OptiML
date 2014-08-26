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

trait DiscreteFeatureWrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def discretefeature_object_apply_impl5(__arg0: Seq[Rep[String]])(implicit __pos: SourceContext): Rep[DiscreteFeature] = {
    val keys = array_fromseq(__arg0)
    val values = array_fromfunction(array_length(keys), i => i)
    discrete_feature_alloc(fhashmap_from_arrays(keys, values))
  }

  def discretefeature_apply_impl3(self: Rep[DiscreteFeature],__arg1: Rep[String])(implicit __pos: SourceContext): Rep[Int] = {
    val featureMap = getFeatures(self)
    if (featureMap.contains(__arg1)) featureMap(__arg1) else 0
  }

  def discretefeature_indicator_impl(self: Rep[DiscreteFeature],__arg1: Rep[String])(implicit __pos: SourceContext): Rep[DenseVector[Int]] = {
    val featureMap = getFeatures(self)
    val numKeys = fhashmap_size(featureMap)
    val e = if (featureMap.contains(__arg1)) featureMap(__arg1) else 0
    (0::numKeys) { i => if (i == e) 1 else 0 }
  }

}
