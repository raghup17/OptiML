import optiml.compiler._
import optiml.shared._

object ForloopCompiler extends OptiMLApplicationCompiler with Forloop

trait Forloop extends OptiMLApplication {
  def main() = {
    for (i <- 0 until 10 by 2) {
      println(i)
    }
  }
}
