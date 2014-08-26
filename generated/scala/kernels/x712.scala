package generated.scala
//activation record for fat loop
final class activation_x712 {
var left_act: activation_x712 = _
var x712: Array[Double] = _
var x712_data: Array[Double] = _
var x712_buf: Array[Double] = _
var x712_size: Int = _
var x712_offset: Int = _
var x712_conditionals: Int = _
def x712_data_set(xs:Array[Double],cs:Int): Unit = {
x712_data = xs
x712_conditionals = cs
if (left_act ne null)
left_act.x712_data_set(xs,cs)
}

}
object activation_x712 {
}
object kernel_x712 {
def apply(x122:Int,x121:generated.scala.io.FileStreamImpl): generated.scala.DeliteOpMultiLoop[activation_x712] = {
val x712 = new generated.scala.DeliteOpMultiLoop[activation_x712] {
def size(): Int = {
x122}

var loopStart: Int = _
var loopSize: Int = _
def alloc(): activation_x712 = {
val __act: activation_x712 = new activation_x712()
// __act.x712 stays null for now
__act}

def processRange(__act:activation_x712,start:Int,end:Int): activation_x712 = {
x121.openAtNewLine(start)
val isEmpty: Boolean = x121.end(start) - x121.pos(start) <= 0
val __act2: activation_x712 = init(__act,start,isEmpty)
while (x121.pos(start) < x121.end(start)) {
process(__act2,start)
}
x121.close(start)
__act2}

def init(__act:activation_x712,x123:Int,isEmpty:Boolean): activation_x712 = {
val __act2: activation_x712 = new activation_x712()
val x188 = 0
val x631 = new Array[Double](x188)
__act2.x712_buf = x631
if (!isEmpty) {
val x124 = x121.readLine(x123)
val x125 = {
x124.trim}
val x126 = x125.split("\\s+", 0)
val x127 = x126.length //MatMult.scala:9//LAioOpsImpl.scala:28//LAioOpsImpl.scala:47//Arrays.scala:31//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434//DeliteRestage.scala:122//SumOpsExp.scala:98//RewriteOpsExp.scala:186//LAPACKOpsExp.scala:94//BLASOpsExp.scala:86//Asserts.scala:16//IOOps.scala:113//Profiling.scala:19//DeliteFileReader.scala:107//Functions.scala:105//HashMap.scala:59//DeliteArrayBuffer.scala:349//Arrays.scala:91//BasicMathOpsExp.scala:96//FileStreamOpsExp.scala:120//LAioOpsExp.scala:108//Ordering2OpsExp.scala:114//ControlOpsExp.scala:52//GrayscaleImageOpsExp.scala:70//SparseMatrixOpsExp.scala:458//DenseVectorOpsExp.scala:900//DenseMatrixOpsExp.scala:1046//Tup5OpsExp.scala:72//RandomVariableOpsExp.scala:58//Tup4OpsExp.scala:68//DenseVectorViewOpsExp.scala:463//Tup3OpsExp.scala:64//CastOpsExp.scala:54//FactorVariableOpsExp.scala:55//RangeOpsExp.scala:129//MiscOpsExp.scala:161//SparseMatrixBuildableOpsExp.scala:261//LinAlgOpsExp.scala:55//TrainingSetOpsExp.scala:63//SHashMapOpsExp.scala:110//FStringOpsExp.scala:187//ComputeStreamOpsExp.scala:74//FunctionFactorOpsExp.scala:82//MLioOpsExp.scala:151//Tup6OpsExp.scala:76//RandOpsExp.scala:114//UTriangleOpsExp.scala:61//SparseVectorOpsExp.scala:532//FactorGraphOpsExp.scala:81//BinaryFeatureOpsExp.scala:46//WeightOpsExp.scala:52//Tup7OpsExp.scala:80//MathOpsExp.scala:226//IndexVectorOpsExp.scala:509//CHashMapOpsExp.scala:110//Primitive2OpsExp.scala:361//DiscreteFeatureOpsExp.scala:60//Tup8OpsExp.scala:84//Tup9OpsExp.scala:88//ContinuousFeatureOpsExp.scala:52//ComplexOpsExp.scala:76//Tup2OpsExp.scala:60//SparseVectorViewOpsExp.scala:144//TableFactorOpsExp.scala:55//DeliteWhile.scala:61//DeliteIfThenElse.scala:56//BooleanOps.scala:40//StaticData.scala:34//CastingOps.scala:36//Structs.scala:322//DeliteArray.scala:324//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434;MatMult.scala:9//LAioOpsImpl.scala:28//LAioOpsImpl.scala:47//Arrays.scala:31//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434
var x143: Int = x127
val x677 = new Array[Double](x143)
val x711_data: Array[Double] = x677
var x711_size: Int = 0
var x711_conditionals: Int = 0
var x128: Int = 0
while (x128 < x127) {  // begin fat loop x711
val x129 = x126(x128)
val x130 = {
x129 == "Inf"}
val x676 = {
def x676thenb(): Double = {
val x667 = {
Double.PositiveInfinity}
x667
}
def x676elseb(): Double = {
val x669 = {
x129 == "-Inf"}
val x674 = {
def x674thenb(): Double = {
val x670 = {
Double.NegativeInfinity}
x670
}
def x674elseb(): Double = {
val x672 = {
x129.toDouble}
x672
}
if (x669) {
x674thenb()
} else { 
x674elseb()
}
}
x674
}
if (x130) {
x676thenb()
} else { 
x676elseb()
}
}
val x142 = x676
val x141 = x711_data
val x681 = x141(x128) = x142
x128 = x128 + 1
} // end fat loop x711
val x141 = x711_data
val x711 = x141
val x183 = x711
val x184 = x183.length //DeliteFileReader.scala:174//DeliteArrayBuffer.scala:265//DenseVectorOpsExp.scala:911//DenseMatrixOpsExp.scala:1057//DenseVectorViewOpsExp.scala:474//IndexVectorOpsExp.scala:520//DeliteArray.scala:172//DeliteArray.scala:24//DeliteArray.scala:27//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434//DeliteRestage.scala:122//SumOpsExp.scala:98//RewriteOpsExp.scala:186//LAPACKOpsExp.scala:94//BLASOpsExp.scala:86//Asserts.scala:16//IOOps.scala:113//Profiling.scala:19//DeliteFileReader.scala:107//Functions.scala:105//HashMap.scala:59//DeliteArrayBuffer.scala:349//Arrays.scala:91//BasicMathOpsExp.scala:96//FileStreamOpsExp.scala:120//LAioOpsExp.scala:108//Ordering2OpsExp.scala:114//ControlOpsExp.scala:52//GrayscaleImageOpsExp.scala:70//SparseMatrixOpsExp.scala:458//DenseVectorOpsExp.scala:900//DenseMatrixOpsExp.scala:1046//Tup5OpsExp.scala:72//RandomVariableOpsExp.scala:58//Tup4OpsExp.scala:68//DenseVectorViewOpsExp.scala:463//Tup3OpsExp.scala:64//CastOpsExp.scala:54//FactorVariableOpsExp.scala:55//RangeOpsExp.scala:129//MiscOpsExp.scala:161//SparseMatrixBuildableOpsExp.scala:261//LinAlgOpsExp.scala:55//TrainingSetOpsExp.scala:63//SHashMapOpsExp.scala:110//FStringOpsExp.scala:187//ComputeStreamOpsExp.scala:74//FunctionFactorOpsExp.scala:82//MLioOpsExp.scala:151//Tup6OpsExp.scala:76//RandOpsExp.scala:114//UTriangleOpsExp.scala:61//SparseVectorOpsExp.scala:532//FactorGraphOpsExp.scala:81//BinaryFeatureOpsExp.scala:46//WeightOpsExp.scala:52//Tup7OpsExp.scala:80//MathOpsExp.scala:226//IndexVectorOpsExp.scala:509//CHashMapOpsExp.scala:110//Primitive2OpsExp.scala:361//DiscreteFeatureOpsExp.scala:60//Tup8OpsExp.scala:84//Tup9OpsExp.scala:88//ContinuousFeatureOpsExp.scala:52//ComplexOpsExp.scala:76//Tup2OpsExp.scala:60//SparseVectorViewOpsExp.scala:144//TableFactorOpsExp.scala:55//DeliteWhile.scala:61//DeliteIfThenElse.scala:56//BooleanOps.scala:40//StaticData.scala:34//CastingOps.scala:36//Structs.scala:322//DeliteArray.scala:324//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434;DeliteFileReader.scala:174//DeliteArrayBuffer.scala:265//DenseVectorOpsExp.scala:911//DenseMatrixOpsExp.scala:1057//DenseVectorViewOpsExp.scala:474//IndexVectorOpsExp.scala:520//DeliteArray.scala:172//DeliteArray.scala:24//DeliteArray.scala:27//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434
var x182: Int = 0
while (x182 < x184) { //flatMap loop
val x185 = x183(x182)
val x186 = __act2.x712_buf
val x187 = x185
if (true) {
val x637 = __act2.x712_size
val x638 = x186.length //DeliteFileReader.scala:160//DeliteOps.scala:385//DeliteArrayBuffer.scala:300//DenseVectorOpsExp.scala:941//DeliteArray.scala:214//DeliteArray.scala:24//DeliteArray.scala:27//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//DeliteRestage.scala:122//SumOpsExp.scala:98//RewriteOpsExp.scala:186//LAPACKOpsExp.scala:94//BLASOpsExp.scala:86//Asserts.scala:16//IOOps.scala:113//Profiling.scala:19//DeliteFileReader.scala:107//Functions.scala:105//HashMap.scala:59//DeliteArrayBuffer.scala:349//Arrays.scala:91//BasicMathOpsExp.scala:96//FileStreamOpsExp.scala:120//LAioOpsExp.scala:108//Ordering2OpsExp.scala:114//ControlOpsExp.scala:52//GrayscaleImageOpsExp.scala:70//SparseMatrixOpsExp.scala:458//DenseVectorOpsExp.scala:900//DenseMatrixOpsExp.scala:1046//Tup5OpsExp.scala:72//RandomVariableOpsExp.scala:58//Tup4OpsExp.scala:68//DenseVectorViewOpsExp.scala:463//Tup3OpsExp.scala:64//CastOpsExp.scala:54//FactorVariableOpsExp.scala:55//RangeOpsExp.scala:129//MiscOpsExp.scala:161//SparseMatrixBuildableOpsExp.scala:261//LinAlgOpsExp.scala:55//TrainingSetOpsExp.scala:63//SHashMapOpsExp.scala:110//FStringOpsExp.scala:187//ComputeStreamOpsExp.scala:74//FunctionFactorOpsExp.scala:82//MLioOpsExp.scala:151//Tup6OpsExp.scala:76//RandOpsExp.scala:114//UTriangleOpsExp.scala:61//SparseVectorOpsExp.scala:532//FactorGraphOpsExp.scala:81//BinaryFeatureOpsExp.scala:46//WeightOpsExp.scala:52//Tup7OpsExp.scala:80//MathOpsExp.scala:226//IndexVectorOpsExp.scala:509//CHashMapOpsExp.scala:110//Primitive2OpsExp.scala:361//DiscreteFeatureOpsExp.scala:60//Tup8OpsExp.scala:84//Tup9OpsExp.scala:88//ContinuousFeatureOpsExp.scala:52//ComplexOpsExp.scala:76//Tup2OpsExp.scala:60//SparseVectorViewOpsExp.scala:144//TableFactorOpsExp.scala:55//DeliteWhile.scala:61//DeliteIfThenElse.scala:56//BooleanOps.scala:40//StaticData.scala:34//CastingOps.scala:36//Structs.scala:322//DeliteOps.scala:1191
val x639 = x637 >= x638
val x651 = {
def x651thenb(): Unit = {
val x640 = x638 < 16
val x643 = {
def x643thenb(): Int = {
16
}
def x643elseb(): Int = {
val x641 = x638 * 2
x641
}
if (x640) {
x643thenb()
} else { 
x643elseb()
}
}
val x644 = new Array[Double](x643)
val x645 = System.arraycopy(x186,0,x644,0,x638)
val x646 = x644(x637) = x187
val x647 = __act2.x712_buf = x644
x647
}
def x651elseb(): Unit = {
val x649 = x186(x637) = x187
x649
}
if (x639) {
x651thenb()
} else { 
x651elseb()
}
}
__act2.x712_size = __act2.x712_size + 1
}
__act2.x712_conditionals = __act2.x712_conditionals + 1
x182 = x182 + 1
}
}
__act2}

def process(__act:activation_x712,x123:Int): Unit = {
val x124 = x121.readLine(x123)
val x125 = {
x124.trim}
val x126 = x125.split("\\s+", 0)
val x127 = x126.length //MatMult.scala:9//LAioOpsImpl.scala:28//LAioOpsImpl.scala:47//Arrays.scala:31//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434//DeliteRestage.scala:122//SumOpsExp.scala:98//RewriteOpsExp.scala:186//LAPACKOpsExp.scala:94//BLASOpsExp.scala:86//Asserts.scala:16//IOOps.scala:113//Profiling.scala:19//DeliteFileReader.scala:107//Functions.scala:105//HashMap.scala:59//DeliteArrayBuffer.scala:349//Arrays.scala:91//BasicMathOpsExp.scala:96//FileStreamOpsExp.scala:120//LAioOpsExp.scala:108//Ordering2OpsExp.scala:114//ControlOpsExp.scala:52//GrayscaleImageOpsExp.scala:70//SparseMatrixOpsExp.scala:458//DenseVectorOpsExp.scala:900//DenseMatrixOpsExp.scala:1046//Tup5OpsExp.scala:72//RandomVariableOpsExp.scala:58//Tup4OpsExp.scala:68//DenseVectorViewOpsExp.scala:463//Tup3OpsExp.scala:64//CastOpsExp.scala:54//FactorVariableOpsExp.scala:55//RangeOpsExp.scala:129//MiscOpsExp.scala:161//SparseMatrixBuildableOpsExp.scala:261//LinAlgOpsExp.scala:55//TrainingSetOpsExp.scala:63//SHashMapOpsExp.scala:110//FStringOpsExp.scala:187//ComputeStreamOpsExp.scala:74//FunctionFactorOpsExp.scala:82//MLioOpsExp.scala:151//Tup6OpsExp.scala:76//RandOpsExp.scala:114//UTriangleOpsExp.scala:61//SparseVectorOpsExp.scala:532//FactorGraphOpsExp.scala:81//BinaryFeatureOpsExp.scala:46//WeightOpsExp.scala:52//Tup7OpsExp.scala:80//MathOpsExp.scala:226//IndexVectorOpsExp.scala:509//CHashMapOpsExp.scala:110//Primitive2OpsExp.scala:361//DiscreteFeatureOpsExp.scala:60//Tup8OpsExp.scala:84//Tup9OpsExp.scala:88//ContinuousFeatureOpsExp.scala:52//ComplexOpsExp.scala:76//Tup2OpsExp.scala:60//SparseVectorViewOpsExp.scala:144//TableFactorOpsExp.scala:55//DeliteWhile.scala:61//DeliteIfThenElse.scala:56//BooleanOps.scala:40//StaticData.scala:34//CastingOps.scala:36//Structs.scala:322//DeliteArray.scala:324//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434;MatMult.scala:9//LAioOpsImpl.scala:28//LAioOpsImpl.scala:47//Arrays.scala:31//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434
var x143: Int = x127
val x677 = new Array[Double](x143)
val x711_data: Array[Double] = x677
var x711_size: Int = 0
var x711_conditionals: Int = 0
var x128: Int = 0
while (x128 < x127) {  // begin fat loop x711
val x129 = x126(x128)
val x130 = {
x129 == "Inf"}
val x676 = {
def x676thenb(): Double = {
val x667 = {
Double.PositiveInfinity}
x667
}
def x676elseb(): Double = {
val x669 = {
x129 == "-Inf"}
val x674 = {
def x674thenb(): Double = {
val x670 = {
Double.NegativeInfinity}
x670
}
def x674elseb(): Double = {
val x672 = {
x129.toDouble}
x672
}
if (x669) {
x674thenb()
} else { 
x674elseb()
}
}
x674
}
if (x130) {
x676thenb()
} else { 
x676elseb()
}
}
val x142 = x676
val x141 = x711_data
val x681 = x141(x128) = x142
x128 = x128 + 1
} // end fat loop x711
val x141 = x711_data
val x711 = x141
val x183 = x711
val x184 = x183.length //DeliteFileReader.scala:174//DeliteArrayBuffer.scala:265//DenseVectorOpsExp.scala:911//DenseMatrixOpsExp.scala:1057//DenseVectorViewOpsExp.scala:474//IndexVectorOpsExp.scala:520//DeliteArray.scala:172//DeliteArray.scala:24//DeliteArray.scala:27//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434//DeliteRestage.scala:122//SumOpsExp.scala:98//RewriteOpsExp.scala:186//LAPACKOpsExp.scala:94//BLASOpsExp.scala:86//Asserts.scala:16//IOOps.scala:113//Profiling.scala:19//DeliteFileReader.scala:107//Functions.scala:105//HashMap.scala:59//DeliteArrayBuffer.scala:349//Arrays.scala:91//BasicMathOpsExp.scala:96//FileStreamOpsExp.scala:120//LAioOpsExp.scala:108//Ordering2OpsExp.scala:114//ControlOpsExp.scala:52//GrayscaleImageOpsExp.scala:70//SparseMatrixOpsExp.scala:458//DenseVectorOpsExp.scala:900//DenseMatrixOpsExp.scala:1046//Tup5OpsExp.scala:72//RandomVariableOpsExp.scala:58//Tup4OpsExp.scala:68//DenseVectorViewOpsExp.scala:463//Tup3OpsExp.scala:64//CastOpsExp.scala:54//FactorVariableOpsExp.scala:55//RangeOpsExp.scala:129//MiscOpsExp.scala:161//SparseMatrixBuildableOpsExp.scala:261//LinAlgOpsExp.scala:55//TrainingSetOpsExp.scala:63//SHashMapOpsExp.scala:110//FStringOpsExp.scala:187//ComputeStreamOpsExp.scala:74//FunctionFactorOpsExp.scala:82//MLioOpsExp.scala:151//Tup6OpsExp.scala:76//RandOpsExp.scala:114//UTriangleOpsExp.scala:61//SparseVectorOpsExp.scala:532//FactorGraphOpsExp.scala:81//BinaryFeatureOpsExp.scala:46//WeightOpsExp.scala:52//Tup7OpsExp.scala:80//MathOpsExp.scala:226//IndexVectorOpsExp.scala:509//CHashMapOpsExp.scala:110//Primitive2OpsExp.scala:361//DiscreteFeatureOpsExp.scala:60//Tup8OpsExp.scala:84//Tup9OpsExp.scala:88//ContinuousFeatureOpsExp.scala:52//ComplexOpsExp.scala:76//Tup2OpsExp.scala:60//SparseVectorViewOpsExp.scala:144//TableFactorOpsExp.scala:55//DeliteWhile.scala:61//DeliteIfThenElse.scala:56//BooleanOps.scala:40//StaticData.scala:34//CastingOps.scala:36//Structs.scala:322//DeliteArray.scala:324//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434;DeliteFileReader.scala:174//DeliteArrayBuffer.scala:265//DenseVectorOpsExp.scala:911//DenseMatrixOpsExp.scala:1057//DenseVectorViewOpsExp.scala:474//IndexVectorOpsExp.scala:520//DeliteArray.scala:172//DeliteArray.scala:24//DeliteArray.scala:27//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//Effects.scala:434
var x182: Int = 0
while (x182 < x184) { //flatMap loop
val x185 = x183(x182)
val x186 = __act.x712_buf
val x187 = x185
if (true) {
val x637 = __act.x712_size
val x638 = x186.length //DeliteFileReader.scala:160//DeliteOps.scala:385//DeliteArrayBuffer.scala:300//DenseVectorOpsExp.scala:941//DeliteArray.scala:214//DeliteArray.scala:24//DeliteArray.scala:27//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//DeliteRestage.scala:122//SumOpsExp.scala:98//RewriteOpsExp.scala:186//LAPACKOpsExp.scala:94//BLASOpsExp.scala:86//Asserts.scala:16//IOOps.scala:113//Profiling.scala:19//DeliteFileReader.scala:107//Functions.scala:105//HashMap.scala:59//DeliteArrayBuffer.scala:349//Arrays.scala:91//BasicMathOpsExp.scala:96//FileStreamOpsExp.scala:120//LAioOpsExp.scala:108//Ordering2OpsExp.scala:114//ControlOpsExp.scala:52//GrayscaleImageOpsExp.scala:70//SparseMatrixOpsExp.scala:458//DenseVectorOpsExp.scala:900//DenseMatrixOpsExp.scala:1046//Tup5OpsExp.scala:72//RandomVariableOpsExp.scala:58//Tup4OpsExp.scala:68//DenseVectorViewOpsExp.scala:463//Tup3OpsExp.scala:64//CastOpsExp.scala:54//FactorVariableOpsExp.scala:55//RangeOpsExp.scala:129//MiscOpsExp.scala:161//SparseMatrixBuildableOpsExp.scala:261//LinAlgOpsExp.scala:55//TrainingSetOpsExp.scala:63//SHashMapOpsExp.scala:110//FStringOpsExp.scala:187//ComputeStreamOpsExp.scala:74//FunctionFactorOpsExp.scala:82//MLioOpsExp.scala:151//Tup6OpsExp.scala:76//RandOpsExp.scala:114//UTriangleOpsExp.scala:61//SparseVectorOpsExp.scala:532//FactorGraphOpsExp.scala:81//BinaryFeatureOpsExp.scala:46//WeightOpsExp.scala:52//Tup7OpsExp.scala:80//MathOpsExp.scala:226//IndexVectorOpsExp.scala:509//CHashMapOpsExp.scala:110//Primitive2OpsExp.scala:361//DiscreteFeatureOpsExp.scala:60//Tup8OpsExp.scala:84//Tup9OpsExp.scala:88//ContinuousFeatureOpsExp.scala:52//ComplexOpsExp.scala:76//Tup2OpsExp.scala:60//SparseVectorViewOpsExp.scala:144//TableFactorOpsExp.scala:55//DeliteWhile.scala:61//DeliteIfThenElse.scala:56//BooleanOps.scala:40//StaticData.scala:34//CastingOps.scala:36//Structs.scala:322//DeliteOps.scala:1191
val x639 = x637 >= x638
val x651 = {
def x651thenb(): Unit = {
val x640 = x638 < 16
val x643 = {
def x643thenb(): Int = {
16
}
def x643elseb(): Int = {
val x641 = x638 * 2
x641
}
if (x640) {
x643thenb()
} else { 
x643elseb()
}
}
val x644 = new Array[Double](x643)
val x645 = System.arraycopy(x186,0,x644,0,x638)
val x646 = x644(x637) = x187
val x647 = __act.x712_buf = x644
x647
}
def x651elseb(): Unit = {
val x649 = x186(x637) = x187
x649
}
if (x639) {
x651thenb()
} else { 
x651elseb()
}
}
__act.x712_size = __act.x712_size + 1
}
__act.x712_conditionals = __act.x712_conditionals + 1
x182 = x182 + 1
}
}

def combine(__act:activation_x712,rhs:activation_x712): Unit = {
}

def postCombine(__act:activation_x712,lhs:activation_x712): Unit = {
__act.x712_offset = lhs.x712_offset+lhs.x712_size
__act.x712_conditionals = __act.x712_conditionals+lhs.x712_conditionals
__act.left_act = lhs
}

def postProcInit(__act:activation_x712): Unit = {
if (__act.x712_offset > 0) {
val x188 = __act.x712_offset + __act.x712_size
val x186 = __act.x712_buf
val x661 = new Array[Double](x188)
__act.x712_data_set(x661,__act.x712_conditionals)
} else {
__act.x712_data_set(__act.x712_buf,__act.x712_conditionals)
}
}

def postProcess(__act:activation_x712): Unit = {
if (__act.x712_data ne __act.x712_buf) {
val x188 = __act.x712_size
val x191 = __act.x712_buf
val x186 = __act.x712_data
val x189 = 0
val x190 = __act.x712_offset
val x663 = System.arraycopy(x191,x189,x186,x190,x188)
}
__act.x712_buf = null
}

def finalize(__act:activation_x712): Unit = {
var x186: Array[Double] = __act.x712_data
__act.x712_data = null
val x188 = __act.x712_conditionals
val x653 = x186.length //DeliteFileReader.scala:160//DeliteOps.scala:385//DeliteArrayBuffer.scala:283//DenseVectorOpsExp.scala:931//DeliteArray.scala:189//DeliteArray.scala:24//DeliteArray.scala:27//DeliteArray.scala:448//DeliteArray.scala:247//DeliteOps.scala:1159//StaticData.scala:24//Effects.scala:367//DeliteOps.scala:1176//DeliteStruct.scala:39//Effects.scala:430//DeliteRestage.scala:122//SumOpsExp.scala:98//RewriteOpsExp.scala:186//LAPACKOpsExp.scala:94//BLASOpsExp.scala:86//Asserts.scala:16//IOOps.scala:113//Profiling.scala:19//DeliteFileReader.scala:107//Functions.scala:105//HashMap.scala:59//DeliteArrayBuffer.scala:349//Arrays.scala:91//BasicMathOpsExp.scala:96//FileStreamOpsExp.scala:120//LAioOpsExp.scala:108//Ordering2OpsExp.scala:114//ControlOpsExp.scala:52//GrayscaleImageOpsExp.scala:70//SparseMatrixOpsExp.scala:458//DenseVectorOpsExp.scala:900//DenseMatrixOpsExp.scala:1046//Tup5OpsExp.scala:72//RandomVariableOpsExp.scala:58//Tup4OpsExp.scala:68//DenseVectorViewOpsExp.scala:463//Tup3OpsExp.scala:64//CastOpsExp.scala:54//FactorVariableOpsExp.scala:55//RangeOpsExp.scala:129//MiscOpsExp.scala:161//SparseMatrixBuildableOpsExp.scala:261//LinAlgOpsExp.scala:55//TrainingSetOpsExp.scala:63//SHashMapOpsExp.scala:110//FStringOpsExp.scala:187//ComputeStreamOpsExp.scala:74//FunctionFactorOpsExp.scala:82//MLioOpsExp.scala:151//Tup6OpsExp.scala:76//RandOpsExp.scala:114//UTriangleOpsExp.scala:61//SparseVectorOpsExp.scala:532//FactorGraphOpsExp.scala:81//BinaryFeatureOpsExp.scala:46//WeightOpsExp.scala:52//Tup7OpsExp.scala:80//MathOpsExp.scala:226//IndexVectorOpsExp.scala:509//CHashMapOpsExp.scala:110//Primitive2OpsExp.scala:361//DiscreteFeatureOpsExp.scala:60//Tup8OpsExp.scala:84//Tup9OpsExp.scala:88//ContinuousFeatureOpsExp.scala:52//ComplexOpsExp.scala:76//Tup2OpsExp.scala:60//SparseVectorViewOpsExp.scala:144//TableFactorOpsExp.scala:55//DeliteWhile.scala:61//DeliteIfThenElse.scala:56//BooleanOps.scala:40//StaticData.scala:34//CastingOps.scala:36//Structs.scala:322//DeliteOps.scala:1191
val x654 = x653 > x188
val x659 = {
def x659thenb(): Unit = {
val x655 = new Array[Double](x188)
val x656 = System.arraycopy(x186,0,x655,0,x188)
val x657 = x186 = x655
x657
}
if (x654) {
x659thenb()
}
}
__act.x712 = x186
}

def initAct(): activation_x712 = {
val act: activation_x712 = new activation_x712
act}

}

x712
}}
