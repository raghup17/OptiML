package optiml.library

import scala.annotation.unchecked.uncheckedVariance
import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common._

trait LambdaWrapper extends OptiMLBase {
  def doLambda[A:Manifest,B:Manifest](f: Rep[A] => Rep[B])(implicit pos: SourceContext): Rep[A => B] = f
  def doApply[A:Manifest,B:Manifest](f: Rep[A => B], arg: Rep[A])(implicit pos: SourceContext): Rep[B] = f(arg)
}




