package generated.scala
//activation record for fat loop
final class activation_x622 {
var left_act: activation_x622 = _
var x622: Array[Double] = _
var x622_data: Array[Double] = _
var x622_buf: Array[Double] = _
var x622_size: Int = _
var x622_offset: Int = _
var x622_conditionals: Int = _
def x622_data_set(xs:Array[Double],cs:Int): Unit = {
x622_data = xs
x622_conditionals = cs
if (left_act ne null)
left_act.x622_data_set(xs,cs)
}

}
object activation_x622 {
}
object kernel_x622 {
def apply(x3:Int,x2:generated.scala.io.FileStreamImpl): generated.scala.DeliteOpMultiLoop[activation_x622] = {
val x622 = new generated.scala.DeliteOpMultiLoop[activation_x622] {
def size(): Int = {
x3}

var loopStart: Int = _
var loopSize: Int = _
def alloc(): activation_x622 = {
val __act: activation_x622 = new activation_x622()
// __act.x622 stays null for now
__act}

def processRange(__act:activation_x622,start:Int,end:Int): activation_x622 = {
x2.openAtNewLine(start)
val isEmpty: Boolean = x2.end(start) - x2.pos(start) <= 0
val __act2: activation_x622 = init(__act,start,isEmpty)
while (x2.pos(start) < x2.end(start)) {
process(__act2,start)
}
x2.close(start)
__act2}

def init(__act:activation_x622,x4:Int,isEmpty:Boolean): activation_x622 = {
val __act2: activation_x622 = new activation_x622()
val x69 = 0
val x541 = new Array[Double](x69)
__act2.x622_buf = x541
if (!isEmpty) {
val x5 = x2.readLine(x4)
val x6 = {
x5.trim}
val x7 = x6.split("\\s+", 0)
val x8 = x7.length //MatMult.scala:8//LAioOpsImpl.scala:28//LAioOpsImpl.scala:47//Arrays.scala:31//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434//DeliteRestage.scala:122//SumOpsExp.scala:98//RewriteOpsExp.scala:186//LAPACKOpsExp.scala:94//BLASOpsExp.scala:86//Asserts.scala:16//IOOps.scala:113//Profiling.scala:19//DeliteFileReader.scala:107//Functions.scala:105//HashMap.scala:59//DeliteArrayBuffer.scala:349//Arrays.scala:91//BasicMathOpsExp.scala:96//FileStreamOpsExp.scala:120//LAioOpsExp.scala:108//Ordering2OpsExp.scala:114//ControlOpsExp.scala:52//GrayscaleImageOpsExp.scala:70//SparseMatrixOpsExp.scala:458//DenseVectorOpsExp.scala:900//DenseMatrixOpsExp.scala:1046//Tup5OpsExp.scala:72//RandomVariableOpsExp.scala:58//Tup4OpsExp.scala:68//DenseVectorViewOpsExp.scala:463//Tup3OpsExp.scala:64//CastOpsExp.scala:54//FactorVariableOpsExp.scala:55//RangeOpsExp.scala:129//MiscOpsExp.scala:161//SparseMatrixBuildableOpsExp.scala:261//LinAlgOpsExp.scala:55//TrainingSetOpsExp.scala:63//SHashMapOpsExp.scala:110//FStringOpsExp.scala:187//ComputeStreamOpsExp.scala:74//FunctionFactorOpsExp.scala:82//MLioOpsExp.scala:151//Tup6OpsExp.scala:76//RandOpsExp.scala:114//UTriangleOpsExp.scala:61//SparseVectorOpsExp.scala:532//FactorGraphOpsExp.scala:81//BinaryFeatureOpsExp.scala:46//WeightOpsExp.scala:52//Tup7OpsExp.scala:80//MathOpsExp.scala:226//IndexVectorOpsExp.scala:509//CHashMapOpsExp.scala:110//Primitive2OpsExp.scala:361//DiscreteFeatureOpsExp.scala:60//Tup8OpsExp.scala:84//Tup9OpsExp.scala:88//ContinuousFeatureOpsExp.scala:52//ComplexOpsExp.scala:76//Tup2OpsExp.scala:60//SparseVectorViewOpsExp.scala:144//TableFactorOpsExp.scala:55//DeliteWhile.scala:61//DeliteIfThenElse.scala:56//BooleanOps.scala:40//StaticData.scala:34//CastingOps.scala:36//Structs.scala:322//DeliteArray.scala:324//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434;MatMult.scala:8//LAioOpsImpl.scala:28//LAioOpsImpl.scala:47//Arrays.scala:31//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434
var x24: Int = x8
val x587 = new Array[Double](x24)
val x621_data: Array[Double] = x587
var x621_size: Int = 0
var x621_conditionals: Int = 0
var x9: Int = 0
while (x9 < x8) {  // begin fat loop x621
val x10 = x7(x9)
val x11 = {
x10 == "Inf"}
val x586 = {
def x586thenb(): Double = {
val x577 = {
Double.PositiveInfinity}
x577
}
def x586elseb(): Double = {
val x579 = {
x10 == "-Inf"}
val x584 = {
def x584thenb(): Double = {
val x580 = {
Double.NegativeInfinity}
x580
}
def x584elseb(): Double = {
val x582 = {
x10.toDouble}
x582
}
if (x579) {
x584thenb()
} else { 
x584elseb()
}
}
x584
}
if (x11) {
x586thenb()
} else { 
x586elseb()
}
}
val x23 = x586
val x22 = x621_data
val x591 = x22(x9) = x23
x9 = x9 + 1
} // end fat loop x621
val x22 = x621_data
val x621 = x22
val x64 = x621
val x65 = x64.length //DeliteFileReader.scala:174//DeliteArrayBuffer.scala:265//DenseVectorOpsExp.scala:911//DenseMatrixOpsExp.scala:1057//DenseVectorViewOpsExp.scala:474//IndexVectorOpsExp.scala:520//DeliteArray.scala:172//DeliteArray.scala:24//DeliteArray.scala:27//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434//DeliteRestage.scala:122//SumOpsExp.scala:98//RewriteOpsExp.scala:186//LAPACKOpsExp.scala:94//BLASOpsExp.scala:86//Asserts.scala:16//IOOps.scala:113//Profiling.scala:19//DeliteFileReader.scala:107//Functions.scala:105//HashMap.scala:59//DeliteArrayBuffer.scala:349//Arrays.scala:91//BasicMathOpsExp.scala:96//FileStreamOpsExp.scala:120//LAioOpsExp.scala:108//Ordering2OpsExp.scala:114//ControlOpsExp.scala:52//GrayscaleImageOpsExp.scala:70//SparseMatrixOpsExp.scala:458//DenseVectorOpsExp.scala:900//DenseMatrixOpsExp.scala:1046//Tup5OpsExp.scala:72//RandomVariableOpsExp.scala:58//Tup4OpsExp.scala:68//DenseVectorViewOpsExp.scala:463//Tup3OpsExp.scala:64//CastOpsExp.scala:54//FactorVariableOpsExp.scala:55//RangeOpsExp.scala:129//MiscOpsExp.scala:161//SparseMatrixBuildableOpsExp.scala:261//LinAlgOpsExp.scala:55//TrainingSetOpsExp.scala:63//SHashMapOpsExp.scala:110//FStringOpsExp.scala:187//ComputeStreamOpsExp.scala:74//FunctionFactorOpsExp.scala:82//MLioOpsExp.scala:151//Tup6OpsExp.scala:76//RandOpsExp.scala:114//UTriangleOpsExp.scala:61//SparseVectorOpsExp.scala:532//FactorGraphOpsExp.scala:81//BinaryFeatureOpsExp.scala:46//WeightOpsExp.scala:52//Tup7OpsExp.scala:80//MathOpsExp.scala:226//IndexVectorOpsExp.scala:509//CHashMapOpsExp.scala:110//Primitive2OpsExp.scala:361//DiscreteFeatureOpsExp.scala:60//Tup8OpsExp.scala:84//Tup9OpsExp.scala:88//ContinuousFeatureOpsExp.scala:52//ComplexOpsExp.scala:76//Tup2OpsExp.scala:60//SparseVectorViewOpsExp.scala:144//TableFactorOpsExp.scala:55//DeliteWhile.scala:61//DeliteIfThenElse.scala:56//BooleanOps.scala:40//StaticData.scala:34//CastingOps.scala:36//Structs.scala:322//DeliteArray.scala:324//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434;DeliteFileReader.scala:174//DeliteArrayBuffer.scala:265//DenseVectorOpsExp.scala:911//DenseMatrixOpsExp.scala:1057//DenseVectorViewOpsExp.scala:474//IndexVectorOpsExp.scala:520//DeliteArray.scala:172//DeliteArray.scala:24//DeliteArray.scala:27//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434
var x63: Int = 0
while (x63 < x65) { //flatMap loop
val x66 = x64(x63)
val x67 = __act2.x622_buf
val x68 = x66
if (true) {
val x547 = __act2.x622_size
val x548 = x67.length //DeliteFileReader.scala:160//DeliteOps.scala:385//DeliteArrayBuffer.scala:300//DenseVectorOpsExp.scala:941//DeliteArray.scala:214//DeliteArray.scala:24//DeliteArray.scala:27//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//DeliteRestage.scala:122//SumOpsExp.scala:98//RewriteOpsExp.scala:186//LAPACKOpsExp.scala:94//BLASOpsExp.scala:86//Asserts.scala:16//IOOps.scala:113//Profiling.scala:19//DeliteFileReader.scala:107//Functions.scala:105//HashMap.scala:59//DeliteArrayBuffer.scala:349//Arrays.scala:91//BasicMathOpsExp.scala:96//FileStreamOpsExp.scala:120//LAioOpsExp.scala:108//Ordering2OpsExp.scala:114//ControlOpsExp.scala:52//GrayscaleImageOpsExp.scala:70//SparseMatrixOpsExp.scala:458//DenseVectorOpsExp.scala:900//DenseMatrixOpsExp.scala:1046//Tup5OpsExp.scala:72//RandomVariableOpsExp.scala:58//Tup4OpsExp.scala:68//DenseVectorViewOpsExp.scala:463//Tup3OpsExp.scala:64//CastOpsExp.scala:54//FactorVariableOpsExp.scala:55//RangeOpsExp.scala:129//MiscOpsExp.scala:161//SparseMatrixBuildableOpsExp.scala:261//LinAlgOpsExp.scala:55//TrainingSetOpsExp.scala:63//SHashMapOpsExp.scala:110//FStringOpsExp.scala:187//ComputeStreamOpsExp.scala:74//FunctionFactorOpsExp.scala:82//MLioOpsExp.scala:151//Tup6OpsExp.scala:76//RandOpsExp.scala:114//UTriangleOpsExp.scala:61//SparseVectorOpsExp.scala:532//FactorGraphOpsExp.scala:81//BinaryFeatureOpsExp.scala:46//WeightOpsExp.scala:52//Tup7OpsExp.scala:80//MathOpsExp.scala:226//IndexVectorOpsExp.scala:509//CHashMapOpsExp.scala:110//Primitive2OpsExp.scala:361//DiscreteFeatureOpsExp.scala:60//Tup8OpsExp.scala:84//Tup9OpsExp.scala:88//ContinuousFeatureOpsExp.scala:52//ComplexOpsExp.scala:76//Tup2OpsExp.scala:60//SparseVectorViewOpsExp.scala:144//TableFactorOpsExp.scala:55//DeliteWhile.scala:61//DeliteIfThenElse.scala:56//BooleanOps.scala:40//StaticData.scala:34//CastingOps.scala:36//Structs.scala:322//DeliteOps.scala:1191
val x549 = x547 >= x548
val x561 = {
def x561thenb(): Unit = {
val x550 = x548 < 16
val x553 = {
def x553thenb(): Int = {
16
}
def x553elseb(): Int = {
val x551 = x548 * 2
x551
}
if (x550) {
x553thenb()
} else { 
x553elseb()
}
}
val x554 = new Array[Double](x553)
val x555 = System.arraycopy(x67,0,x554,0,x548)
val x556 = x554(x547) = x68
val x557 = __act2.x622_buf = x554
x557
}
def x561elseb(): Unit = {
val x559 = x67(x547) = x68
x559
}
if (x549) {
x561thenb()
} else { 
x561elseb()
}
}
__act2.x622_size = __act2.x622_size + 1
}
__act2.x622_conditionals = __act2.x622_conditionals + 1
x63 = x63 + 1
}
}
__act2}

def process(__act:activation_x622,x4:Int): Unit = {
val x5 = x2.readLine(x4)
val x6 = {
x5.trim}
val x7 = x6.split("\\s+", 0)
val x8 = x7.length //MatMult.scala:8//LAioOpsImpl.scala:28//LAioOpsImpl.scala:47//Arrays.scala:31//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434//DeliteRestage.scala:122//SumOpsExp.scala:98//RewriteOpsExp.scala:186//LAPACKOpsExp.scala:94//BLASOpsExp.scala:86//Asserts.scala:16//IOOps.scala:113//Profiling.scala:19//DeliteFileReader.scala:107//Functions.scala:105//HashMap.scala:59//DeliteArrayBuffer.scala:349//Arrays.scala:91//BasicMathOpsExp.scala:96//FileStreamOpsExp.scala:120//LAioOpsExp.scala:108//Ordering2OpsExp.scala:114//ControlOpsExp.scala:52//GrayscaleImageOpsExp.scala:70//SparseMatrixOpsExp.scala:458//DenseVectorOpsExp.scala:900//DenseMatrixOpsExp.scala:1046//Tup5OpsExp.scala:72//RandomVariableOpsExp.scala:58//Tup4OpsExp.scala:68//DenseVectorViewOpsExp.scala:463//Tup3OpsExp.scala:64//CastOpsExp.scala:54//FactorVariableOpsExp.scala:55//RangeOpsExp.scala:129//MiscOpsExp.scala:161//SparseMatrixBuildableOpsExp.scala:261//LinAlgOpsExp.scala:55//TrainingSetOpsExp.scala:63//SHashMapOpsExp.scala:110//FStringOpsExp.scala:187//ComputeStreamOpsExp.scala:74//FunctionFactorOpsExp.scala:82//MLioOpsExp.scala:151//Tup6OpsExp.scala:76//RandOpsExp.scala:114//UTriangleOpsExp.scala:61//SparseVectorOpsExp.scala:532//FactorGraphOpsExp.scala:81//BinaryFeatureOpsExp.scala:46//WeightOpsExp.scala:52//Tup7OpsExp.scala:80//MathOpsExp.scala:226//IndexVectorOpsExp.scala:509//CHashMapOpsExp.scala:110//Primitive2OpsExp.scala:361//DiscreteFeatureOpsExp.scala:60//Tup8OpsExp.scala:84//Tup9OpsExp.scala:88//ContinuousFeatureOpsExp.scala:52//ComplexOpsExp.scala:76//Tup2OpsExp.scala:60//SparseVectorViewOpsExp.scala:144//TableFactorOpsExp.scala:55//DeliteWhile.scala:61//DeliteIfThenElse.scala:56//BooleanOps.scala:40//StaticData.scala:34//CastingOps.scala:36//Structs.scala:322//DeliteArray.scala:324//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434;MatMult.scala:8//LAioOpsImpl.scala:28//LAioOpsImpl.scala:47//Arrays.scala:31//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434
var x24: Int = x8
val x587 = new Array[Double](x24)
val x621_data: Array[Double] = x587
var x621_size: Int = 0
var x621_conditionals: Int = 0
var x9: Int = 0
while (x9 < x8) {  // begin fat loop x621
val x10 = x7(x9)
val x11 = {
x10 == "Inf"}
val x586 = {
def x586thenb(): Double = {
val x577 = {
Double.PositiveInfinity}
x577
}
def x586elseb(): Double = {
val x579 = {
x10 == "-Inf"}
val x584 = {
def x584thenb(): Double = {
val x580 = {
Double.NegativeInfinity}
x580
}
def x584elseb(): Double = {
val x582 = {
x10.toDouble}
x582
}
if (x579) {
x584thenb()
} else { 
x584elseb()
}
}
x584
}
if (x11) {
x586thenb()
} else { 
x586elseb()
}
}
val x23 = x586
val x22 = x621_data
val x591 = x22(x9) = x23
x9 = x9 + 1
} // end fat loop x621
val x22 = x621_data
val x621 = x22
val x64 = x621
val x65 = x64.length //DeliteFileReader.scala:174//DeliteArrayBuffer.scala:265//DenseVectorOpsExp.scala:911//DenseMatrixOpsExp.scala:1057//DenseVectorViewOpsExp.scala:474//IndexVectorOpsExp.scala:520//DeliteArray.scala:172//DeliteArray.scala:24//DeliteArray.scala:27//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434//DeliteRestage.scala:122//SumOpsExp.scala:98//RewriteOpsExp.scala:186//LAPACKOpsExp.scala:94//BLASOpsExp.scala:86//Asserts.scala:16//IOOps.scala:113//Profiling.scala:19//DeliteFileReader.scala:107//Functions.scala:105//HashMap.scala:59//DeliteArrayBuffer.scala:349//Arrays.scala:91//BasicMathOpsExp.scala:96//FileStreamOpsExp.scala:120//LAioOpsExp.scala:108//Ordering2OpsExp.scala:114//ControlOpsExp.scala:52//GrayscaleImageOpsExp.scala:70//SparseMatrixOpsExp.scala:458//DenseVectorOpsExp.scala:900//DenseMatrixOpsExp.scala:1046//Tup5OpsExp.scala:72//RandomVariableOpsExp.scala:58//Tup4OpsExp.scala:68//DenseVectorViewOpsExp.scala:463//Tup3OpsExp.scala:64//CastOpsExp.scala:54//FactorVariableOpsExp.scala:55//RangeOpsExp.scala:129//MiscOpsExp.scala:161//SparseMatrixBuildableOpsExp.scala:261//LinAlgOpsExp.scala:55//TrainingSetOpsExp.scala:63//SHashMapOpsExp.scala:110//FStringOpsExp.scala:187//ComputeStreamOpsExp.scala:74//FunctionFactorOpsExp.scala:82//MLioOpsExp.scala:151//Tup6OpsExp.scala:76//RandOpsExp.scala:114//UTriangleOpsExp.scala:61//SparseVectorOpsExp.scala:532//FactorGraphOpsExp.scala:81//BinaryFeatureOpsExp.scala:46//WeightOpsExp.scala:52//Tup7OpsExp.scala:80//MathOpsExp.scala:226//IndexVectorOpsExp.scala:509//CHashMapOpsExp.scala:110//Primitive2OpsExp.scala:361//DiscreteFeatureOpsExp.scala:60//Tup8OpsExp.scala:84//Tup9OpsExp.scala:88//ContinuousFeatureOpsExp.scala:52//ComplexOpsExp.scala:76//Tup2OpsExp.scala:60//SparseVectorViewOpsExp.scala:144//TableFactorOpsExp.scala:55//DeliteWhile.scala:61//DeliteIfThenElse.scala:56//BooleanOps.scala:40//StaticData.scala:34//CastingOps.scala:36//Structs.scala:322//DeliteArray.scala:324//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434;DeliteFileReader.scala:174//DeliteArrayBuffer.scala:265//DenseVectorOpsExp.scala:911//DenseMatrixOpsExp.scala:1057//DenseVectorViewOpsExp.scala:474//IndexVectorOpsExp.scala:520//DeliteArray.scala:172//DeliteArray.scala:24//DeliteArray.scala:27//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434
var x63: Int = 0
while (x63 < x65) { //flatMap loop
val x66 = x64(x63)
val x67 = __act.x622_buf
val x68 = x66
if (true) {
val x547 = __act.x622_size
val x548 = x67.length //DeliteFileReader.scala:160//DeliteOps.scala:385//DeliteArrayBuffer.scala:300//DenseVectorOpsExp.scala:941//DeliteArray.scala:214//DeliteArray.scala:24//DeliteArray.scala:27//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//DeliteRestage.scala:122//SumOpsExp.scala:98//RewriteOpsExp.scala:186//LAPACKOpsExp.scala:94//BLASOpsExp.scala:86//Asserts.scala:16//IOOps.scala:113//Profiling.scala:19//DeliteFileReader.scala:107//Functions.scala:105//HashMap.scala:59//DeliteArrayBuffer.scala:349//Arrays.scala:91//BasicMathOpsExp.scala:96//FileStreamOpsExp.scala:120//LAioOpsExp.scala:108//Ordering2OpsExp.scala:114//ControlOpsExp.scala:52//GrayscaleImageOpsExp.scala:70//SparseMatrixOpsExp.scala:458//DenseVectorOpsExp.scala:900//DenseMatrixOpsExp.scala:1046//Tup5OpsExp.scala:72//RandomVariableOpsExp.scala:58//Tup4OpsExp.scala:68//DenseVectorViewOpsExp.scala:463//Tup3OpsExp.scala:64//CastOpsExp.scala:54//FactorVariableOpsExp.scala:55//RangeOpsExp.scala:129//MiscOpsExp.scala:161//SparseMatrixBuildableOpsExp.scala:261//LinAlgOpsExp.scala:55//TrainingSetOpsExp.scala:63//SHashMapOpsExp.scala:110//FStringOpsExp.scala:187//ComputeStreamOpsExp.scala:74//FunctionFactorOpsExp.scala:82//MLioOpsExp.scala:151//Tup6OpsExp.scala:76//RandOpsExp.scala:114//UTriangleOpsExp.scala:61//SparseVectorOpsExp.scala:532//FactorGraphOpsExp.scala:81//BinaryFeatureOpsExp.scala:46//WeightOpsExp.scala:52//Tup7OpsExp.scala:80//MathOpsExp.scala:226//IndexVectorOpsExp.scala:509//CHashMapOpsExp.scala:110//Primitive2OpsExp.scala:361//DiscreteFeatureOpsExp.scala:60//Tup8OpsExp.scala:84//Tup9OpsExp.scala:88//ContinuousFeatureOpsExp.scala:52//ComplexOpsExp.scala:76//Tup2OpsExp.scala:60//SparseVectorViewOpsExp.scala:144//TableFactorOpsExp.scala:55//DeliteWhile.scala:61//DeliteIfThenElse.scala:56//BooleanOps.scala:40//StaticData.scala:34//CastingOps.scala:36//Structs.scala:322//DeliteOps.scala:1191
val x549 = x547 >= x548
val x561 = {
def x561thenb(): Unit = {
val x550 = x548 < 16
val x553 = {
def x553thenb(): Int = {
16
}
def x553elseb(): Int = {
val x551 = x548 * 2
x551
}
if (x550) {
x553thenb()
} else { 
x553elseb()
}
}
val x554 = new Array[Double](x553)
val x555 = System.arraycopy(x67,0,x554,0,x548)
val x556 = x554(x547) = x68
val x557 = __act.x622_buf = x554
x557
}
def x561elseb(): Unit = {
val x559 = x67(x547) = x68
x559
}
if (x549) {
x561thenb()
} else { 
x561elseb()
}
}
__act.x622_size = __act.x622_size + 1
}
__act.x622_conditionals = __act.x622_conditionals + 1
x63 = x63 + 1
}
}

def combine(__act:activation_x622,rhs:activation_x622): Unit = {
}

def postCombine(__act:activation_x622,lhs:activation_x622): Unit = {
__act.x622_offset = lhs.x622_offset+lhs.x622_size
__act.x622_conditionals = __act.x622_conditionals+lhs.x622_conditionals
__act.left_act = lhs
}

def postProcInit(__act:activation_x622): Unit = {
if (__act.x622_offset > 0) {
val x69 = __act.x622_offset + __act.x622_size
val x67 = __act.x622_buf
val x571 = new Array[Double](x69)
__act.x622_data_set(x571,__act.x622_conditionals)
} else {
__act.x622_data_set(__act.x622_buf,__act.x622_conditionals)
}
}

def postProcess(__act:activation_x622): Unit = {
if (__act.x622_data ne __act.x622_buf) {
val x69 = __act.x622_size
val x72 = __act.x622_buf
val x67 = __act.x622_data
val x70 = 0
val x71 = __act.x622_offset
val x573 = System.arraycopy(x72,x70,x67,x71,x69)
}
__act.x622_buf = null
}

def finalize(__act:activation_x622): Unit = {
var x67: Array[Double] = __act.x622_data
__act.x622_data = null
val x69 = __act.x622_conditionals
val x563 = x67.length //DeliteFileReader.scala:160//DeliteOps.scala:385//DeliteArrayBuffer.scala:283//DenseVectorOpsExp.scala:931//DeliteArray.scala:189//DeliteArray.scala:24//DeliteArray.scala:27//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//DeliteRestage.scala:122//SumOpsExp.scala:98//RewriteOpsExp.scala:186//LAPACKOpsExp.scala:94//BLASOpsExp.scala:86//Asserts.scala:16//IOOps.scala:113//Profiling.scala:19//DeliteFileReader.scala:107//Functions.scala:105//HashMap.scala:59//DeliteArrayBuffer.scala:349//Arrays.scala:91//BasicMathOpsExp.scala:96//FileStreamOpsExp.scala:120//LAioOpsExp.scala:108//Ordering2OpsExp.scala:114//ControlOpsExp.scala:52//GrayscaleImageOpsExp.scala:70//SparseMatrixOpsExp.scala:458//DenseVectorOpsExp.scala:900//DenseMatrixOpsExp.scala:1046//Tup5OpsExp.scala:72//RandomVariableOpsExp.scala:58//Tup4OpsExp.scala:68//DenseVectorViewOpsExp.scala:463//Tup3OpsExp.scala:64//CastOpsExp.scala:54//FactorVariableOpsExp.scala:55//RangeOpsExp.scala:129//MiscOpsExp.scala:161//SparseMatrixBuildableOpsExp.scala:261//LinAlgOpsExp.scala:55//TrainingSetOpsExp.scala:63//SHashMapOpsExp.scala:110//FStringOpsExp.scala:187//ComputeStreamOpsExp.scala:74//FunctionFactorOpsExp.scala:82//MLioOpsExp.scala:151//Tup6OpsExp.scala:76//RandOpsExp.scala:114//UTriangleOpsExp.scala:61//SparseVectorOpsExp.scala:532//FactorGraphOpsExp.scala:81//BinaryFeatureOpsExp.scala:46//WeightOpsExp.scala:52//Tup7OpsExp.scala:80//MathOpsExp.scala:226//IndexVectorOpsExp.scala:509//CHashMapOpsExp.scala:110//Primitive2OpsExp.scala:361//DiscreteFeatureOpsExp.scala:60//Tup8OpsExp.scala:84//Tup9OpsExp.scala:88//ContinuousFeatureOpsExp.scala:52//ComplexOpsExp.scala:76//Tup2OpsExp.scala:60//SparseVectorViewOpsExp.scala:144//TableFactorOpsExp.scala:55//DeliteWhile.scala:61//DeliteIfThenElse.scala:56//BooleanOps.scala:40//StaticData.scala:34//CastingOps.scala:36//Structs.scala:322//DeliteOps.scala:1191
val x564 = x563 > x69
val x569 = {
def x569thenb(): Unit = {
val x565 = new Array[Double](x69)
val x566 = System.arraycopy(x67,0,x565,0,x69)
val x567 = x67 = x565
x567
}
if (x564) {
x569thenb()
}
}
__act.x622 = x67
}

def initAct(): activation_x622 = {
val act: activation_x622 = new activation_x622
act}

}

x622
}}
