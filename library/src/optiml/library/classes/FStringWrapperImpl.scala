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

trait FStringWrapperImpl {
  this: OptiMLApplication with OptiMLCompilerOps => 

  def fstring_fsplit_impl(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext): Rep[ForgeArray[String]] = {
    array_string_split(__arg0,__arg1)
  }

  def optila_padspace_impl(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[String] = {
    "  " + __arg0
  }

}
