package optiml.compiler.ops

import scala.reflect.{Manifest,SourceContext}
import optiml.shared._
import optiml.shared.ops._
import optiml.shared.typeclass._
import optiml.compiler._
import optiml.compiler.ops._

/**
 * Op Impls
 */

trait FStringOpsImpl {
  this: OptiMLCompiler with OptiMLLift => 

  def fstring_fsplit_impl(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext): Rep[ForgeArray[String]] = {
    array_string_split(__arg0,__arg1)
  }

  def optila_padspace_impl(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[String] = {
    "  " + __arg0
  }

}
