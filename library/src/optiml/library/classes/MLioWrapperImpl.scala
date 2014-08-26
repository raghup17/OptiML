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

trait MLioWrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def fg_read_weights_impl(path: Rep[String])(implicit __pos: SourceContext): Rep[DenseVector[Weight]] = {
    val dis = datainputstream_new(path)
    val out = DenseVector[Weight](0, true)
    while (dis.available() > 0) {
      val weightId = dis.readLong().toInt
      val isFixed = dis.readBoolean()
      val initialValue = dis.readDouble()   
    
      out <<= Weight(weightId, initialValue, isFixed)
    }
    dis.fclose()
    out.unsafeImmutable
  }

  def fg_read_variables_impl(path: Rep[String])(implicit __pos: SourceContext): Rep[DenseVector[RandomVariable]] = {
    val dis = datainputstream_new(path)
    val out = DenseVector[RandomVariable](0, true)
    while (dis.available() > 0) {
      val variableId = dis.readLong().toInt
      val isEvidence = dis.readBoolean()
      val initialValue = dis.readDouble()
      val dataType = dis.readShort()
      val edgeCount = dis.readLong().toInt
      val cardinality = dis.readLong().toInt
      val isQuery = !isEvidence
      
      out <<= RandomVariable(variableId, DenseVector(0.0, 1.0), initialValue, isEvidence, isQuery)
    }
    dis.fclose()
    out.unsafeImmutable
  }

  def fg_read_edges_impl(path: Rep[String])(implicit __pos: SourceContext): Rep[DenseVector[Tup4[Int,Int,Boolean,Int]]] = {
    val dis = datainputstream_new(path)
    val out = DenseVector[Tup4[Int,Int,Boolean,Int]](0, true)
    while (dis.available() > 0) {
      val variableId = dis.readLong().toInt
      val factorId = dis.readLong().toInt
      val position = dis.readLong().toInt
      val isPositive = dis.readBoolean()
      val equalPredicate = dis.readLong().toInt
      
      out <<= pack((variableId, factorId, isPositive, position))
    }
    dis.fclose()
    out.unsafeImmutable
  }

  def fg_read_factors_impl(path: Rep[String])(implicit __pos: SourceContext): Rep[DenseVector[Tup3[Int,Int,Int]]] = {
    val dis = datainputstream_new(path)
    val out = DenseVector[Tup3[Int,Int,Int]](0, true)
    while (dis.available() > 0) {
      val factorId = dis.readLong().toInt
      val weightId = dis.readLong().toInt
      val factorFunction = dis.readShort().AsInstanceOf[Int]
      val edgeCount = dis.readLong().toInt
      out <<= pack((factorId, weightId, factorFunction))
    }
    dis.fclose()
    out.unsafeImmutable
  }

  def mlio_readfactorgraph_impl(factorsPath: Rep[String],variablesPath: Rep[String],weightsPath: Rep[String],edgesPath: Rep[String],delim: Rep[String] = unit("\\t"))(implicit __pos: SourceContext): Rep[FactorGraph[FunctionFactor]] = {
    val weights = fg_read_weights(weightsPath).sortBy(w => w.id)
    val variables = fg_read_variables(variablesPath).distinct.sortBy(r => r.id)
    val edges = fg_read_edges(edgesPath)
    
    val factorVariablesMap = edges.groupBy(r => r._2, r => FactorVariable(r._1, r._3, DenseVector(0.0, 1.0), r._4))
    val factorRows = fg_read_factors(factorsPath)
    val allFactors = factorRows.map { t =>
      val vars = if (factorVariablesMap.contains(t._1)) factorVariablesMap(t._1).sortBy(r => r.position) else DenseVector[FactorVariable]()
      FunctionFactor(t._1, vars, t._2, t._3)
    }
    val factors = allFactors.filter(f => f.vars.length > 0).sortBy(f => f.id)
    
    val variablesToFactors = build_variable_factors(variables, factors)
    val variableValues = variables.map(v => v.value).mutable
    val weightValues = weights.map(w => w.value).mutable
    
    FactorGraph(factors, variables, weights, variablesToFactors, variableValues, weightValues)
  }

  def build_variable_factors_impl(variables: Rep[DenseVector[RandomVariable]],factors: Rep[DenseVector[FunctionFactor]])(implicit __pos: SourceContext): Rep[DenseVector[DenseVector[Int]]] = {
    val variablesToFactors = DenseVector[DenseVector[Int]](variables.length, true) 
    
    for (i <- 0 until variablesToFactors.length) {
      variablesToFactors(i) = DenseVector[Int]()
    }
    
    val factorIds = factors.indices
    for (i <- 0 until factorIds.length) {
      val f = factors(factorIds(i))
      for (j <- 0 until f.vars.length) {
        val vId = f.vars.apply(j).id
        val curVec = variablesToFactors(vId)
        variablesToFactors.update(vId, curVec << factorIds(i))
      }
    }
       
    variablesToFactors.map(v => v.distinct)
  }

  def mlio_readarff_impl[Row:Manifest](path: Rep[String],schemaBldr: (Rep[DenseVector[String]]) => Rep[Row])(implicit __pos: SourceContext): Rep[DenseVector[Row]] = {
    val lines = densevector_fromarray(ForgeFileReader.readLines(path){ line => line.trim }, true).mutable
    	
    	
    
    	val start = lines find { _ == "@DATA" }
    	if (start.length < 1) fatal("could not find @DATA tag in ARFF file: " + path)
    	val body = lines.drop(start(0)+1).filter(!_.startsWith("%")).mutable
    	body map { s => schemaBldr(densevector_fromarray(s.fsplit(","), true)) }
  }

}
