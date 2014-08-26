package generated.scala
object kernel_x969 {
def apply(x880:generated.scala.DenseMatrixDouble,x881:Boolean): java.lang.String = {
def x969_block = { 
var x882: java.lang.String = ""
val x966 = {
def x966thenb(): Unit = {
val x883 = x882 = "null"
()
}
def x966elseb(): Unit = {
val x885 = x880._numRows
val x886 = {
x885 == 0}
val x964 = {
def x964thenb(): Unit = {
val x887 = x882 = "[ ]"
()
}
def x964elseb(): Unit = {
val x889 = x880._numRows
val x890 = x889 - 1
val x891 = x880._numCols
val x892 = {
x891 == 0}
val x926 = {
var i = 0
while (i < x890) {
  { val x451 = i
var x893: java.lang.String = ""
val x919 = {
def x919thenb(): Unit = {
val x894 = x893 = "[ ]"
()
}
def x919elseb(): Unit = {
val x896 = x891 - 1
val x897 = x880._data
val x898 = x451 * x891
val x907 = {
var i = 0
while (i < x896) {
  { val x463 = i
val x899 = x893
val x900 = x898 + x463
val x901 = x897(x900)
val x902 = {

def numericStr[A](x: A) = {
  val s = ("% ."+Global.numericPrecision+"g").format(x)
  val padPrefix = (Global.numericPrecision+6) - s.length
  if (padPrefix > 0) " "*padPrefix + s else s
}
if (x901.isInstanceOf[Double] || x901.isInstanceOf[Float]) numericStr(x901) else ("" + x901)
}
val x903 = {
"  ".toString + x902.toString}
val x904 = {
x899.toString + x903.toString}
val x905 = x893 = x904
 }
 
  i += 1
}}
val x908 = x893
val x909 = x891 - 1
val x910 = x898 + x909
val x911 = x880._data
val x912 = x911(x910)
val x913 = {

def numericStr[A](x: A) = {
  val s = ("% ."+Global.numericPrecision+"g").format(x)
  val padPrefix = (Global.numericPrecision+6) - s.length
  if (padPrefix > 0) " "*padPrefix + s else s
}
if (x912.isInstanceOf[Double] || x912.isInstanceOf[Float]) numericStr(x912) else ("" + x912)
}
val x914 = {
"  ".toString + x913.toString}
val x915 = {
x908.toString + x914.toString}
val x916 = x893 = x915
()
}
if (x892) {
x919thenb()
} else { 
x919elseb()
}
}
val x920 = x893
val x921 = x882
val x922 = {
x921.toString + x920.toString}
val x923 = {
x922.toString + "\n".toString}
val x924 = x882 = x923
 }
 
  i += 1
}}
var x927: java.lang.String = ""
val x928 = x880._numCols
val x929 = {
x928 == 0}
val x957 = {
def x957thenb(): Unit = {
val x930 = x927 = "[ ]"
()
}
def x957elseb(): Unit = {
val x932 = x928 - 1
val x897 = x880._data
val x933 = x880._numRows
val x934 = x933 - 1
val x935 = x880._numCols
val x936 = x934 * x935
val x945 = {
var i = 0
while (i < x932) {
  { val x504 = i
val x937 = x927
val x938 = x936 + x504
val x939 = x897(x938)
val x940 = {

def numericStr[A](x: A) = {
  val s = ("% ."+Global.numericPrecision+"g").format(x)
  val padPrefix = (Global.numericPrecision+6) - s.length
  if (padPrefix > 0) " "*padPrefix + s else s
}
if (x939.isInstanceOf[Double] || x939.isInstanceOf[Float]) numericStr(x939) else ("" + x939)
}
val x941 = {
"  ".toString + x940.toString}
val x942 = {
x937.toString + x941.toString}
val x943 = x927 = x942
 }
 
  i += 1
}}
val x946 = x927
val x947 = x928 - 1
val x948 = x936 + x947
val x949 = x880._data
val x950 = x949(x948)
val x951 = {

def numericStr[A](x: A) = {
  val s = ("% ."+Global.numericPrecision+"g").format(x)
  val padPrefix = (Global.numericPrecision+6) - s.length
  if (padPrefix > 0) " "*padPrefix + s else s
}
if (x950.isInstanceOf[Double] || x950.isInstanceOf[Float]) numericStr(x950) else ("" + x950)
}
val x952 = {
"  ".toString + x951.toString}
val x953 = {
x946.toString + x952.toString}
val x954 = x927 = x953
()
}
if (x929) {
x957thenb()
} else { 
x957elseb()
}
}
val x958 = x927
val x959 = x882
val x960 = {
x959.toString + x958.toString}
val x961 = x882 = x960
()
}
if (x886) {
x964thenb()
} else { 
x964elseb()
}
}
x964
}
if (x881) {
x966thenb()
} else { 
x966elseb()
}
}
val x967 = x882
x967
}
val x969 = x969_block

x969
}}
