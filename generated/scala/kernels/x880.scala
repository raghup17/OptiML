package generated.scala
object kernel_x880 {
def apply(x719:Int,x720:Int,x721:Int,x723:Int,x722:Array[Double],x725:Int,x724:Int,x726:Array[Double],x835:java.lang.String,x837:Int,x838:Boolean,x840:java.lang.String): generated.scala.DenseMatrixDouble = {
def x880_block = { 
var x727: Int = x719
var x728: Int = x720
val x729 = new Array[Double](x721)
var x730: Array[Double] = x729
val x731 = new generated.scala.DenseMatrixDouble(x727,x728,x730)
var x740: Int = x725
val x744 = new Array[Int](x740)
val x778_data: Array[Int] = x744
var x778_size: Int = 0
var x778_conditionals: Int = 0
var x255: Int = 0
while (x255 < x725) {  // begin fat loop x778
val x739 = x255
val x738 = x778_data
val x748 = x738(x255) = x739
x255 = x255 + 1
} // end fat loop x778
val x738 = x778_data
val x778 = x738
var x794: Int = x725
val x798 = new Array[Double](x794)
val x832_data: Array[Double] = x798
var x832_size: Int = 0
var x832_conditionals: Int = 0
var x333: Int = 0
while (x333 < x725) {  // begin fat loop x832
val x786 = x778(x333)
val x787 = {
x786 / x724}
val x788 = {
x786 % x724}
val x789 = x788 * x720
val x790 = x789 + x787
val x791 = x726(x790)
val x793 = x791
val x792 = x832_data
val x802 = x792(x333) = x793
x333 = x333 + 1
} // end fat loop x832
val x792 = x832_data
val x832 = x792
val x874 = {
var i = 0
while (i < x719) {
  { val x371 = i
val x841 = x371 * x723
val x842 = x722(x841)
val x426 = {
"rowIdx = ".toString + x371.toString}
val x427 = {
x426.toString + ", i = ".toString}
val x872 = {
var i = 0
while (i < x720) {
  { val x373 = i
val x843 = x373 * x724
val x844 = x832(x843)
val x845 = {
x842 * x844}
var x846: Double = x845
val x847 = {
println(x835)}
val x856 = {
var i = 1
while (i < x724) {
  { val x390 = i
val x391 = {
"iter = ".toString + x390.toString}
val x392 = {
x391.toString + ", u = ".toString}
val x393 = {
x392.toString + 0.toString}
val x394 = {
x393.toString + ", arg = ".toString}
val x395 = {
x394.toString + x390.toString}
val x848 = {
println(x395)}
val x849 = x841 + x390
val x850 = x722(x849)
val x851 = x843 + x390
val x852 = x832(x851)
val x853 = {
x850 * x852}
val x854 = x846 += x853
 }
 
  i += 1
}}
val x868 = {
def x868thenb(): Unit = {
val x857 = x724 - x837
val x865 = {
var i = x857
while (i < x724) {
  { val x410 = i
val x858 = x841 + x410
val x859 = x722(x858)
val x860 = x843 + x410
val x861 = x832(x860)
val x862 = {
x859 * x861}
val x863 = x846 += x862
 }
 
  i += 1
}}
x865
}
if (x838) {
x868thenb()
}
}
val x869 = {
println(x840)}
val x428 = {
x427.toString + x373.toString}
val x870 = {
println(x428)}
 }
 
  i += 1
}}
 }
 
  i += 1
}}
val x875 = x731._numRows
val x876 = x731._numCols
val x877 = x731._data
val x878 = new generated.scala.DenseMatrixDouble(x875,x876,x877)
x878
}
val x880 = x880_block

x880
}}
