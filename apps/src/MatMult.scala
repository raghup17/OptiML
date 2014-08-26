import optiml.compiler._
import optiml.shared._

object MatMultCompiler extends OptiMLApplicationCompiler with MatMult

trait MatMult extends OptiMLApplication {
  def main() = {
    val A = readMatrix(args(0))
    val B = readMatrix(args(1))
    val C = A * B
    C.pprint
  }
}
