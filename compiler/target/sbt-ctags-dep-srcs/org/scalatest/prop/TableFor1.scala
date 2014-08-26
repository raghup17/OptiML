/*
 * Copyright 2001-2014 Artima, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.scalatest
package prop

import scala.collection.mutable.Builder
import scala.collection.mutable.ArrayBuffer
import scala.collection.IndexedSeqLike
import scala.collection.generic.CanBuildFrom
import exceptions.StackDepthExceptionHelper.getStackDepthFun

/**
 * A table with 1 column.
 *
 * <p>
 * For an overview of using tables, see the documentation for trait
 * <a href="TableDrivenPropertyChecks.html">TableDrivenPropertyChecks</a>.
 * </p>
 *
 * <p>
 * This table is a sequence of objects, where each object represents one row of the (one-column) table.
 * This table also carries with it a <em>heading</em> tuple that gives a string name to the
 * lone column of the table.
 * </p>
 *
 * <p>
 * A handy way to create a <code>TableFor1</code> is via an <code>apply</code> factory method in the <code>Table</code>
 * singleton object provided by the <code>Tables</code> trait. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * val examples =
 *   Table(
 *     "a",
 *       0,
 *       1,
 *       2,
 *       3,
 *       4,
 *       5,
 *       6,
 *       7,
 *       8,
 *       9
 *   )
 * </pre>
 *
 * <p>
 * Because you supplied a list of non-tuple objects, the type you'll get back will be a <code>TableFor1</code>.
 * </p>
 *
 * <p>
 * The table provides an <code>apply</code> method that takes a function with a parameter list that matches
 * the type of the objects contained in this table. The <code>apply</code> method will invoke the
 * function with the object in each row passed as the lone argument, in ascending order by index. (<em>I.e.</em>,
 * the zeroth object is checked first, then the object with index 1, then index 2, and so on until all the rows
 * have been checked (or until a failure occurs). The function represents a property of the code under test
 * that should succeed for every row of the table. If the function returns normally, that indicates the property
 * check succeeded for that row. If the function completes abruptly with an exception, that indicates the
 * property check failed and the <code>apply</code> method will complete abruptly with a
 * <code>TableDrivenPropertyCheckFailedException</code> that wraps the exception thrown by the supplied property function.
 * </p>
 * 
 * <p>
 * The usual way you'd invoke the <code>apply</code> method that checks a property is via a <code>forAll</code> method
 * provided by trait <code>TableDrivenPropertyChecks</code>. The <code>forAll</code> method takes a <code>TableFor1</code> as its
 * first argument, then in a curried argument list takes the property check function. It invokes <code>apply</code> on
 * the <code>TableFor1</code>, passing in the property check function. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * forAll (examples) { (a) =>
 *   a should equal (a * 1)
 * }
 * </pre>
 *
 * <p>
 * Because <code>TableFor1</code> is a <code>Seq[(A)]</code>, you can use it as a <code>Seq</code>. For example, here's how
 * you could get a sequence of <a href="../Outcome.html"><code>Outcome</code></a>s for each row of the table, indicating whether a property check succeeded or failed
 * on each row of the table:
 * </p>
 *
 * <pre class="stHighlight">
 * for (row <- examples) yield {
 *   outcomeOf { row._1 should not equal (7) }
 * }
 * </pre>
 *
 * <p>
 * Note: the <code>outcomeOf</code> method, contained in the <code>OutcomeOf</code> trait, will execute the supplied code (a by-name parameter) and
 * transform it to an <code>Outcome</code>. If no exception is thrown by the code, <code>outcomeOf</code> will result in a
 * <a href="../Succeeded$.html"><code>Succeeded</code></a>, indicating the "property check"
 * succeeded. If the supplied code completes abruptly in an exception that would normally cause a test to fail, <code>outcomeOf</code> will result in
 * in a <a href="../Failed.html"><code>Failed</code></a> instance containing that exception. For example, the previous for expression would give you:
 * </p>
 *
 * <pre class="stHighlight">
 * Vector(Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded,
 *     Failed(org.scalatest.TestFailedException: 7 equaled 7), Succeeded, Succeeded)
 * </pre>
 *
 * <p>
 * This shows that all the property checks succeeded, except for the one at index 7.
 * </p>
 *
 * <p>
 * One other way to use a <code>TableFor1</code> is to test subsequent return values
 * of a stateful function. Imagine, for example, you had an object named <code>FiboGen</code>
 * whose <code>next</code> method returned the <em>next</em> fibonacci number, where next
 * means the next number in the series following the number previously returned by <code>next</code>.
 * So the first time <code>next</code> was called, it would return 0. The next time it was called
 * it would return 1. Then 1. Then 2. Then 3, and so on. <code>FiboGen</code> would need to
 * be stateful, because it has to remember where it is in the series. In such a situation,
 * you could create a <code>TableFor1</code> (a table with one column, which you could alternatively
 * think of as one row), in which each row represents
 * the next value you expect.
 * </p>
 *
 * <pre class="stHighlight">
 * val first14FiboNums =
 *   Table("n", 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233)
 * </pre>
 *
 * <p>
 * Then in your <code>forAll</code> simply call the function and compare it with the
 * expected return value, like this:
 * </p>
 *
 * <pre class="stHighlight">
 *  forAll (first14FiboNums) { n =>
 *    FiboGen.next should equal (n)
 *  }
 * </pre>
 *
 * @param heading a string name for the lone column of this table
 * @param rows a variable length parameter list of objects containing the data of this table
 *
 * @author Bill Venners 
 */

class TableFor1[A](val heading: (String), rows: (A)*) extends IndexedSeq[(A)] with IndexedSeqLike[(A), TableFor1[A]] {

  /**
   * Selects a row of data by its index.
   */
  def apply(idx: Int): (A) = rows(idx)

  /**
   * The number of rows of data in the table. (This does not include the <code>heading</code> tuple)
   */
  def length: Int = rows.length

  /**
   * Creates a new <code>Builder</code> for <code>TableFor1</code>s.
   */
  override protected[this] def newBuilder: Builder[(A), TableFor1[A]] =
    new ArrayBuffer mapResult { (buf: Seq[(A)]) =>
      new TableFor1(heading, buf: _*)
    }

  /**
   * Applies the passed property check function to each row of this <code>TableFor1</code>.
   *
   * <p>
   * If the property checks for all rows succeed (the property check function returns normally when passed
   * the data for each row), this <code>apply</code> method returns normally. If the property check function
   * completes abruptly with an exception for any row, this <code>apply</code> method wraps that exception
   * in a <code>TableDrivenPropertyCheckFailedException</code> and completes abruptly with that exception. Once
   * the property check function throws an exception for a row, this <code>apply</code> method will complete
   * abruptly immediately and subsequent rows will not be checked against the function.
   * </p>
   *
   * @param fun the property check function to apply to each row of this <code>TableFor1</code>
   */
  def apply(fun: (A) => Unit) {
    for (((a), idx) <- rows.zipWithIndex) {
      try {
        fun(a)
      }
      catch {
        case _: DiscardedEvaluationException => // discard this evaluation and move on to the next
        case ex: Throwable =>
          val (aName) = heading

          throw new TableDrivenPropertyCheckFailedException(
            sde => FailureMessages("propertyException", UnquotedString(ex.getClass.getSimpleName)) + 
              ( sde.failedCodeFileNameAndLineNumberString match { case Some(s) => " (" + s + ")"; case None => "" }) + "\n" + 
              "  " + FailureMessages("thrownExceptionsMessage", if (ex.getMessage == null) "None" else UnquotedString(ex.getMessage)) + "\n" +
              (
                ex match {
                  case sd: StackDepth if sd.failedCodeFileNameAndLineNumberString.isDefined =>
                    "  " + FailureMessages("thrownExceptionsLocation", UnquotedString(sd.failedCodeFileNameAndLineNumberString.get)) + "\n"
                  case _ => ""
                }
              ) +
              "  " + FailureMessages("occurredAtRow", idx) + "\n" +
              "    " + aName + " = " + a + "\n" +

              "  )",
            Some(ex),
            getStackDepthFun("TableDrivenPropertyChecks.scala", "forAll", 2),
            FailureMessages("undecoratedPropertyCheckFailureMessage"),
            List(a),
            List(aName),
            idx
          )
      }
    }
  }

  /**
   * A string representation of this object, which includes the heading strings as well as the rows of data.
   */
  override def toString: String = stringPrefix + "(" + heading.toString + ", " +  rows.mkString(", ") + ")"
}

/**
 * Companion object for class <code>TableFor1</code> that provides an implicit <code>canBuildFrom</code> method
 * that enables higher order functions defined on <code>TableFor1</code> to return another <code>TableFor1</code>.
 *
 * @author Bill Venners 
 */
object TableFor1 {

  /**
   * Implicit method enabling higher order functions of <code>TableFor1</code> to return sequences of type <code>TableFor1</code>.
   */
  implicit def canBuildFrom[A]: CanBuildFrom[TableFor1[A], (A), TableFor1[A]] =
    new CanBuildFrom[TableFor1[A], (A), TableFor1[A]] {
      def apply(): Builder[(A), TableFor1[A]] =
        new ArrayBuffer mapResult { (buf: Seq[(A)]) =>
          new TableFor1(("arg0"))
        }
      def apply(from: TableFor1[A]): Builder[(A), TableFor1[A]] =
        new ArrayBuffer mapResult { (buf: Seq[(A)]) =>
          new TableFor1(from.heading, buf: _*)
        }
    }
}

/**
 * A table with 2 columns.
 *
 * <p>
 * For an introduction to using tables, see the documentation for trait
 * <a href="TableDrivenPropertyChecks.html">TableDrivenPropertyChecks</a>.
 * </p>
 *
 * <p>
 * This table is a sequence of <code>Tuple2</code> objects, where each tuple represents one row of the table.
 * The first element of each tuple comprise the first column of the table, the second element of 
 * each tuple comprise the second column, and so on.  This table also carries with it
 * a <em>heading</em> tuple that gives string names to the columns of the table.
 * </p>
 *
 * <p>
 * A handy way to create a <code>TableFor2</code> is via an <code>apply</code> factory method in the <code>Table</code>
 * singleton object provided by the <code>Tables</code> trait. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * val examples =
 *   Table(
 *     ("a", "b"),
 *     (  0,   0),
 *     (  1,   1),
 *     (  2,   2),
 *     (  3,   3),
 *     (  4,   4),
 *     (  5,   5),
 *     (  6,   6),
 *     (  7,   7),
 *     (  8,   8),
 *     (  9,   9)
 *   )
 * </pre>
 *
 * <p>
 * Because you supplied 2 members in each tuple, the type you'll get back will be a <code>TableFor2</code>.
 * </p>
 *
 * <p>
 * The table provides an <code>apply</code> method that takes a function with a parameter list that matches
 * the types and arity of the tuples contained in this table. The <code>apply</code> method will invoke the
 * function with the members of each row tuple passed as arguments, in ascending order by index. (<em>I.e.</em>,
 * the zeroth tuple is checked first, then the tuple with index 1, then index 2, and so on until all the rows
 * have been checked (or until a failure occurs). The function represents a property of the code under test
 * that should succeed for every row of the table. If the function returns normally, that indicates the property
 * check succeeded for that row. If the function completes abruptly with an exception, that indicates the
 * property check failed and the <code>apply</code> method will complete abruptly with a
 * <code>TableDrivenPropertyCheckFailedException</code> that wraps the exception thrown by the supplied property function.
 * </p>
 * 
 * <p>
 * The usual way you'd invoke the <code>apply</code> method that checks a property is via a <code>forAll</code> method
 * provided by trait <code>TableDrivenPropertyChecks</code>. The <code>forAll</code> method takes a <code>TableFor2</code> as its
 * first argument, then in a curried argument list takes the property check function. It invokes <code>apply</code> on
 * the <code>TableFor2</code>, passing in the property check function. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * forAll (examples) { (a, b) =>
 *   a + b should equal (a * 2)
 * }
 * </pre>
 *
 * <p>
 * Because <code>TableFor2</code> is a <code>Seq[(A, B)]</code>, you can use it as a <code>Seq</code>. For example, here's how
 * you could get a sequence of <a href="../Outcome.html"><code>Outcome</code></a>s for each row of the table, indicating whether a property check succeeded or failed
 * on each row of the table:
 * </p>
 *
 * <pre class="stHighlight">
 * for (row <- examples) yield {
 *   outcomeOf { row._1 should not equal (7) }
 * }
 * </pre>
 *
 * <p>
 * Note: the <code>outcomeOf</code> method, contained in the <code>OutcomeOf</code> trait, will execute the supplied code (a by-name parameter) and
 * transform it to an <code>Outcome</code>. If no exception is thrown by the code, <code>outcomeOf</code> will result in a
 * <a href="../Succeeded$.html"><code>Succeeded</code></a>, indicating the "property check"
 * succeeded. If the supplied code completes abruptly in an exception that would normally cause a test to fail, <code>outcomeOf</code> will result in
 * in a <a href="../Failed.html"><code>Failed</code></a> instance containing that exception. For example, the previous for expression would give you:
 * </p>
 *
 * <pre class="stHighlight">
 * Vector(Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded,
 *     Failed(org.scalatest.TestFailedException: 7 equaled 7), Succeeded, Succeeded)
 * </pre>
 *
 * <p>
 * This shows that all the property checks succeeded, except for the one at index 7.
 * </p>
 *
 * @param heading a tuple containing string names of the columns in this table
 * @param rows a variable length parameter list of <code>Tuple2</code>s containing the data of this table
 *
 * @author Bill Venners 
 */

class TableFor2[A, B](val heading: (String, String), rows: (A, B)*) extends IndexedSeq[(A, B)] with IndexedSeqLike[(A, B), TableFor2[A, B]] {

  /**
   * Selects a row of data by its index.
   */
  def apply(idx: Int): (A, B) = rows(idx)

  /**
   * The number of rows of data in the table. (This does not include the <code>heading</code> tuple)
   */
  def length: Int = rows.length

  /**
   * Creates a new <code>Builder</code> for <code>TableFor2</code>s.
   */
  override protected[this] def newBuilder: Builder[(A, B), TableFor2[A, B]] =
    new ArrayBuffer mapResult { (buf: Seq[(A, B)]) =>
      new TableFor2(heading, buf: _*)
    }

  /**
   * Applies the passed property check function to each row of this <code>TableFor2</code>.
   *
   * <p>
   * If the property checks for all rows succeed (the property check function returns normally when passed
   * the data for each row), this <code>apply</code> method returns normally. If the property check function
   * completes abruptly with an exception for any row, this <code>apply</code> method wraps that exception
   * in a <code>TableDrivenPropertyCheckFailedException</code> and completes abruptly with that exception. Once
   * the property check function throws an exception for a row, this <code>apply</code> method will complete
   * abruptly immediately and subsequent rows will not be checked against the function.
   * </p>
   *
   * @param fun the property check function to apply to each row of this <code>TableFor2</code>
   */
  def apply(fun: (A, B) => Unit) {
    for (((a, b), idx) <- rows.zipWithIndex) {
      try {
        fun(a, b)
      }
      catch {
        case _: DiscardedEvaluationException => // discard this evaluation and move on to the next
        case ex: Throwable =>
          val (aName, bName) = heading

          throw new TableDrivenPropertyCheckFailedException(
            sde => FailureMessages("propertyException", UnquotedString(ex.getClass.getSimpleName)) + 
              ( sde.failedCodeFileNameAndLineNumberString match { case Some(s) => " (" + s + ")"; case None => "" }) + "\n" + 
              "  " + FailureMessages("thrownExceptionsMessage", if (ex.getMessage == null) "None" else UnquotedString(ex.getMessage)) + "\n" +
              (
                ex match {
                  case sd: StackDepth if sd.failedCodeFileNameAndLineNumberString.isDefined =>
                    "  " + FailureMessages("thrownExceptionsLocation", UnquotedString(sd.failedCodeFileNameAndLineNumberString.get)) + "\n"
                  case _ => ""
                }
              ) +
              "  " + FailureMessages("occurredAtRow", idx) + "\n" +
              "    " + aName + " = " + a + "," + "\n" +
              "    " + bName + " = " + b + "\n" +

              "  )",
            Some(ex),
            getStackDepthFun("TableDrivenPropertyChecks.scala", "forAll", 2),
            FailureMessages("undecoratedPropertyCheckFailureMessage"),
            List(a, b),
            List(aName, bName),
            idx
          )
      }
    }
  }

  /**
   * A string representation of this object, which includes the heading strings as well as the rows of data.
   */
  override def toString: String = stringPrefix + "(" + heading.toString + ", " +  rows.mkString(", ") + ")"
}

/**
 * Companion object for class <code>TableFor2</code> that provides an implicit <code>canBuildFrom</code> method
 * that enables higher order functions defined on <code>TableFor2</code> to return another <code>TableFor2</code>.
 *
 * @author Bill Venners 
 */
object TableFor2 {

  /**
   * Implicit method enabling higher order functions of <code>TableFor2</code> to return sequences of type <code>TableFor2</code>.
   */
  implicit def canBuildFrom[A, B]: CanBuildFrom[TableFor2[A, B], (A, B), TableFor2[A, B]] =
    new CanBuildFrom[TableFor2[A, B], (A, B), TableFor2[A, B]] {
      def apply(): Builder[(A, B), TableFor2[A, B]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B)]) =>
          new TableFor2(("arg0","arg1"))
        }
      def apply(from: TableFor2[A, B]): Builder[(A, B), TableFor2[A, B]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B)]) =>
          new TableFor2(from.heading, buf: _*)
        }
    }
}

/**
 * A table with 3 columns.
 *
 * <p>
 * For an introduction to using tables, see the documentation for trait
 * <a href="TableDrivenPropertyChecks.html">TableDrivenPropertyChecks</a>.
 * </p>
 *
 * <p>
 * This table is a sequence of <code>Tuple3</code> objects, where each tuple represents one row of the table.
 * The first element of each tuple comprise the first column of the table, the second element of 
 * each tuple comprise the second column, and so on.  This table also carries with it
 * a <em>heading</em> tuple that gives string names to the columns of the table.
 * </p>
 *
 * <p>
 * A handy way to create a <code>TableFor3</code> is via an <code>apply</code> factory method in the <code>Table</code>
 * singleton object provided by the <code>Tables</code> trait. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * val examples =
 *   Table(
 *     ("a", "b", "c"),
 *     (  0,   0,   0),
 *     (  1,   1,   1),
 *     (  2,   2,   2),
 *     (  3,   3,   3),
 *     (  4,   4,   4),
 *     (  5,   5,   5),
 *     (  6,   6,   6),
 *     (  7,   7,   7),
 *     (  8,   8,   8),
 *     (  9,   9,   9)
 *   )
 * </pre>
 *
 * <p>
 * Because you supplied 3 members in each tuple, the type you'll get back will be a <code>TableFor3</code>.
 * </p>
 *
 * <p>
 * The table provides an <code>apply</code> method that takes a function with a parameter list that matches
 * the types and arity of the tuples contained in this table. The <code>apply</code> method will invoke the
 * function with the members of each row tuple passed as arguments, in ascending order by index. (<em>I.e.</em>,
 * the zeroth tuple is checked first, then the tuple with index 1, then index 2, and so on until all the rows
 * have been checked (or until a failure occurs). The function represents a property of the code under test
 * that should succeed for every row of the table. If the function returns normally, that indicates the property
 * check succeeded for that row. If the function completes abruptly with an exception, that indicates the
 * property check failed and the <code>apply</code> method will complete abruptly with a
 * <code>TableDrivenPropertyCheckFailedException</code> that wraps the exception thrown by the supplied property function.
 * </p>
 * 
 * <p>
 * The usual way you'd invoke the <code>apply</code> method that checks a property is via a <code>forAll</code> method
 * provided by trait <code>TableDrivenPropertyChecks</code>. The <code>forAll</code> method takes a <code>TableFor3</code> as its
 * first argument, then in a curried argument list takes the property check function. It invokes <code>apply</code> on
 * the <code>TableFor3</code>, passing in the property check function. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * forAll (examples) { (a, b, c) =>
 *   a + b + c should equal (a * 3)
 * }
 * </pre>
 *
 * <p>
 * Because <code>TableFor3</code> is a <code>Seq[(A, B, C)]</code>, you can use it as a <code>Seq</code>. For example, here's how
 * you could get a sequence of <a href="../Outcome.html"><code>Outcome</code></a>s for each row of the table, indicating whether a property check succeeded or failed
 * on each row of the table:
 * </p>
 *
 * <pre class="stHighlight">
 * for (row <- examples) yield {
 *   outcomeOf { row._1 should not equal (7) }
 * }
 * </pre>
 *
 * <p>
 * Note: the <code>outcomeOf</code> method, contained in the <code>OutcomeOf</code> trait, will execute the supplied code (a by-name parameter) and
 * transform it to an <code>Outcome</code>. If no exception is thrown by the code, <code>outcomeOf</code> will result in a
 * <a href="../Succeeded$.html"><code>Succeeded</code></a>, indicating the "property check"
 * succeeded. If the supplied code completes abruptly in an exception that would normally cause a test to fail, <code>outcomeOf</code> will result in
 * in a <a href="../Failed.html"><code>Failed</code></a> instance containing that exception. For example, the previous for expression would give you:
 * </p>
 *
 * <pre class="stHighlight">
 * Vector(Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded,
 *     Failed(org.scalatest.TestFailedException: 7 equaled 7), Succeeded, Succeeded)
 * </pre>
 *
 * <p>
 * This shows that all the property checks succeeded, except for the one at index 7.
 * </p>
 *
 * @param heading a tuple containing string names of the columns in this table
 * @param rows a variable length parameter list of <code>Tuple3</code>s containing the data of this table
 *
 * @author Bill Venners 
 */

class TableFor3[A, B, C](val heading: (String, String, String), rows: (A, B, C)*) extends IndexedSeq[(A, B, C)] with IndexedSeqLike[(A, B, C), TableFor3[A, B, C]] {

  /**
   * Selects a row of data by its index.
   */
  def apply(idx: Int): (A, B, C) = rows(idx)

  /**
   * The number of rows of data in the table. (This does not include the <code>heading</code> tuple)
   */
  def length: Int = rows.length

  /**
   * Creates a new <code>Builder</code> for <code>TableFor3</code>s.
   */
  override protected[this] def newBuilder: Builder[(A, B, C), TableFor3[A, B, C]] =
    new ArrayBuffer mapResult { (buf: Seq[(A, B, C)]) =>
      new TableFor3(heading, buf: _*)
    }

  /**
   * Applies the passed property check function to each row of this <code>TableFor3</code>.
   *
   * <p>
   * If the property checks for all rows succeed (the property check function returns normally when passed
   * the data for each row), this <code>apply</code> method returns normally. If the property check function
   * completes abruptly with an exception for any row, this <code>apply</code> method wraps that exception
   * in a <code>TableDrivenPropertyCheckFailedException</code> and completes abruptly with that exception. Once
   * the property check function throws an exception for a row, this <code>apply</code> method will complete
   * abruptly immediately and subsequent rows will not be checked against the function.
   * </p>
   *
   * @param fun the property check function to apply to each row of this <code>TableFor3</code>
   */
  def apply(fun: (A, B, C) => Unit) {
    for (((a, b, c), idx) <- rows.zipWithIndex) {
      try {
        fun(a, b, c)
      }
      catch {
        case _: DiscardedEvaluationException => // discard this evaluation and move on to the next
        case ex: Throwable =>
          val (aName, bName, cName) = heading

          throw new TableDrivenPropertyCheckFailedException(
            sde => FailureMessages("propertyException", UnquotedString(ex.getClass.getSimpleName)) + 
              ( sde.failedCodeFileNameAndLineNumberString match { case Some(s) => " (" + s + ")"; case None => "" }) + "\n" + 
              "  " + FailureMessages("thrownExceptionsMessage", if (ex.getMessage == null) "None" else UnquotedString(ex.getMessage)) + "\n" +
              (
                ex match {
                  case sd: StackDepth if sd.failedCodeFileNameAndLineNumberString.isDefined =>
                    "  " + FailureMessages("thrownExceptionsLocation", UnquotedString(sd.failedCodeFileNameAndLineNumberString.get)) + "\n"
                  case _ => ""
                }
              ) +
              "  " + FailureMessages("occurredAtRow", idx) + "\n" +
              "    " + aName + " = " + a + "," + "\n" +
              "    " + bName + " = " + b + "," + "\n" +
              "    " + cName + " = " + c + "\n" +

              "  )",
            Some(ex),
            getStackDepthFun("TableDrivenPropertyChecks.scala", "forAll", 2),
            FailureMessages("undecoratedPropertyCheckFailureMessage"),
            List(a, b, c),
            List(aName, bName, cName),
            idx
          )
      }
    }
  }

  /**
   * A string representation of this object, which includes the heading strings as well as the rows of data.
   */
  override def toString: String = stringPrefix + "(" + heading.toString + ", " +  rows.mkString(", ") + ")"
}

/**
 * Companion object for class <code>TableFor3</code> that provides an implicit <code>canBuildFrom</code> method
 * that enables higher order functions defined on <code>TableFor3</code> to return another <code>TableFor3</code>.
 *
 * @author Bill Venners 
 */
object TableFor3 {

  /**
   * Implicit method enabling higher order functions of <code>TableFor3</code> to return sequences of type <code>TableFor3</code>.
   */
  implicit def canBuildFrom[A, B, C]: CanBuildFrom[TableFor3[A, B, C], (A, B, C), TableFor3[A, B, C]] =
    new CanBuildFrom[TableFor3[A, B, C], (A, B, C), TableFor3[A, B, C]] {
      def apply(): Builder[(A, B, C), TableFor3[A, B, C]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C)]) =>
          new TableFor3(("arg0","arg1","arg2"))
        }
      def apply(from: TableFor3[A, B, C]): Builder[(A, B, C), TableFor3[A, B, C]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C)]) =>
          new TableFor3(from.heading, buf: _*)
        }
    }
}

/**
 * A table with 4 columns.
 *
 * <p>
 * For an introduction to using tables, see the documentation for trait
 * <a href="TableDrivenPropertyChecks.html">TableDrivenPropertyChecks</a>.
 * </p>
 *
 * <p>
 * This table is a sequence of <code>Tuple4</code> objects, where each tuple represents one row of the table.
 * The first element of each tuple comprise the first column of the table, the second element of 
 * each tuple comprise the second column, and so on.  This table also carries with it
 * a <em>heading</em> tuple that gives string names to the columns of the table.
 * </p>
 *
 * <p>
 * A handy way to create a <code>TableFor4</code> is via an <code>apply</code> factory method in the <code>Table</code>
 * singleton object provided by the <code>Tables</code> trait. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * val examples =
 *   Table(
 *     ("a", "b", "c", "d"),
 *     (  0,   0,   0,   0),
 *     (  1,   1,   1,   1),
 *     (  2,   2,   2,   2),
 *     (  3,   3,   3,   3),
 *     (  4,   4,   4,   4),
 *     (  5,   5,   5,   5),
 *     (  6,   6,   6,   6),
 *     (  7,   7,   7,   7),
 *     (  8,   8,   8,   8),
 *     (  9,   9,   9,   9)
 *   )
 * </pre>
 *
 * <p>
 * Because you supplied 4 members in each tuple, the type you'll get back will be a <code>TableFor4</code>.
 * </p>
 *
 * <p>
 * The table provides an <code>apply</code> method that takes a function with a parameter list that matches
 * the types and arity of the tuples contained in this table. The <code>apply</code> method will invoke the
 * function with the members of each row tuple passed as arguments, in ascending order by index. (<em>I.e.</em>,
 * the zeroth tuple is checked first, then the tuple with index 1, then index 2, and so on until all the rows
 * have been checked (or until a failure occurs). The function represents a property of the code under test
 * that should succeed for every row of the table. If the function returns normally, that indicates the property
 * check succeeded for that row. If the function completes abruptly with an exception, that indicates the
 * property check failed and the <code>apply</code> method will complete abruptly with a
 * <code>TableDrivenPropertyCheckFailedException</code> that wraps the exception thrown by the supplied property function.
 * </p>
 * 
 * <p>
 * The usual way you'd invoke the <code>apply</code> method that checks a property is via a <code>forAll</code> method
 * provided by trait <code>TableDrivenPropertyChecks</code>. The <code>forAll</code> method takes a <code>TableFor4</code> as its
 * first argument, then in a curried argument list takes the property check function. It invokes <code>apply</code> on
 * the <code>TableFor4</code>, passing in the property check function. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * forAll (examples) { (a, b, c, d) =>
 *   a + b + c + d should equal (a * 4)
 * }
 * </pre>
 *
 * <p>
 * Because <code>TableFor4</code> is a <code>Seq[(A, B, C, D)]</code>, you can use it as a <code>Seq</code>. For example, here's how
 * you could get a sequence of <a href="../Outcome.html"><code>Outcome</code></a>s for each row of the table, indicating whether a property check succeeded or failed
 * on each row of the table:
 * </p>
 *
 * <pre class="stHighlight">
 * for (row <- examples) yield {
 *   outcomeOf { row._1 should not equal (7) }
 * }
 * </pre>
 *
 * <p>
 * Note: the <code>outcomeOf</code> method, contained in the <code>OutcomeOf</code> trait, will execute the supplied code (a by-name parameter) and
 * transform it to an <code>Outcome</code>. If no exception is thrown by the code, <code>outcomeOf</code> will result in a
 * <a href="../Succeeded$.html"><code>Succeeded</code></a>, indicating the "property check"
 * succeeded. If the supplied code completes abruptly in an exception that would normally cause a test to fail, <code>outcomeOf</code> will result in
 * in a <a href="../Failed.html"><code>Failed</code></a> instance containing that exception. For example, the previous for expression would give you:
 * </p>
 *
 * <pre class="stHighlight">
 * Vector(Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded,
 *     Failed(org.scalatest.TestFailedException: 7 equaled 7), Succeeded, Succeeded)
 * </pre>
 *
 * <p>
 * This shows that all the property checks succeeded, except for the one at index 7.
 * </p>
 *
 * @param heading a tuple containing string names of the columns in this table
 * @param rows a variable length parameter list of <code>Tuple4</code>s containing the data of this table
 *
 * @author Bill Venners 
 */

class TableFor4[A, B, C, D](val heading: (String, String, String, String), rows: (A, B, C, D)*) extends IndexedSeq[(A, B, C, D)] with IndexedSeqLike[(A, B, C, D), TableFor4[A, B, C, D]] {

  /**
   * Selects a row of data by its index.
   */
  def apply(idx: Int): (A, B, C, D) = rows(idx)

  /**
   * The number of rows of data in the table. (This does not include the <code>heading</code> tuple)
   */
  def length: Int = rows.length

  /**
   * Creates a new <code>Builder</code> for <code>TableFor4</code>s.
   */
  override protected[this] def newBuilder: Builder[(A, B, C, D), TableFor4[A, B, C, D]] =
    new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D)]) =>
      new TableFor4(heading, buf: _*)
    }

  /**
   * Applies the passed property check function to each row of this <code>TableFor4</code>.
   *
   * <p>
   * If the property checks for all rows succeed (the property check function returns normally when passed
   * the data for each row), this <code>apply</code> method returns normally. If the property check function
   * completes abruptly with an exception for any row, this <code>apply</code> method wraps that exception
   * in a <code>TableDrivenPropertyCheckFailedException</code> and completes abruptly with that exception. Once
   * the property check function throws an exception for a row, this <code>apply</code> method will complete
   * abruptly immediately and subsequent rows will not be checked against the function.
   * </p>
   *
   * @param fun the property check function to apply to each row of this <code>TableFor4</code>
   */
  def apply(fun: (A, B, C, D) => Unit) {
    for (((a, b, c, d), idx) <- rows.zipWithIndex) {
      try {
        fun(a, b, c, d)
      }
      catch {
        case _: DiscardedEvaluationException => // discard this evaluation and move on to the next
        case ex: Throwable =>
          val (aName, bName, cName, dName) = heading

          throw new TableDrivenPropertyCheckFailedException(
            sde => FailureMessages("propertyException", UnquotedString(ex.getClass.getSimpleName)) + 
              ( sde.failedCodeFileNameAndLineNumberString match { case Some(s) => " (" + s + ")"; case None => "" }) + "\n" + 
              "  " + FailureMessages("thrownExceptionsMessage", if (ex.getMessage == null) "None" else UnquotedString(ex.getMessage)) + "\n" +
              (
                ex match {
                  case sd: StackDepth if sd.failedCodeFileNameAndLineNumberString.isDefined =>
                    "  " + FailureMessages("thrownExceptionsLocation", UnquotedString(sd.failedCodeFileNameAndLineNumberString.get)) + "\n"
                  case _ => ""
                }
              ) +
              "  " + FailureMessages("occurredAtRow", idx) + "\n" +
              "    " + aName + " = " + a + "," + "\n" +
              "    " + bName + " = " + b + "," + "\n" +
              "    " + cName + " = " + c + "," + "\n" +
              "    " + dName + " = " + d + "\n" +

              "  )",
            Some(ex),
            getStackDepthFun("TableDrivenPropertyChecks.scala", "forAll", 2),
            FailureMessages("undecoratedPropertyCheckFailureMessage"),
            List(a, b, c, d),
            List(aName, bName, cName, dName),
            idx
          )
      }
    }
  }

  /**
   * A string representation of this object, which includes the heading strings as well as the rows of data.
   */
  override def toString: String = stringPrefix + "(" + heading.toString + ", " +  rows.mkString(", ") + ")"
}

/**
 * Companion object for class <code>TableFor4</code> that provides an implicit <code>canBuildFrom</code> method
 * that enables higher order functions defined on <code>TableFor4</code> to return another <code>TableFor4</code>.
 *
 * @author Bill Venners 
 */
object TableFor4 {

  /**
   * Implicit method enabling higher order functions of <code>TableFor4</code> to return sequences of type <code>TableFor4</code>.
   */
  implicit def canBuildFrom[A, B, C, D]: CanBuildFrom[TableFor4[A, B, C, D], (A, B, C, D), TableFor4[A, B, C, D]] =
    new CanBuildFrom[TableFor4[A, B, C, D], (A, B, C, D), TableFor4[A, B, C, D]] {
      def apply(): Builder[(A, B, C, D), TableFor4[A, B, C, D]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D)]) =>
          new TableFor4(("arg0","arg1","arg2","arg3"))
        }
      def apply(from: TableFor4[A, B, C, D]): Builder[(A, B, C, D), TableFor4[A, B, C, D]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D)]) =>
          new TableFor4(from.heading, buf: _*)
        }
    }
}

/**
 * A table with 5 columns.
 *
 * <p>
 * For an introduction to using tables, see the documentation for trait
 * <a href="TableDrivenPropertyChecks.html">TableDrivenPropertyChecks</a>.
 * </p>
 *
 * <p>
 * This table is a sequence of <code>Tuple5</code> objects, where each tuple represents one row of the table.
 * The first element of each tuple comprise the first column of the table, the second element of 
 * each tuple comprise the second column, and so on.  This table also carries with it
 * a <em>heading</em> tuple that gives string names to the columns of the table.
 * </p>
 *
 * <p>
 * A handy way to create a <code>TableFor5</code> is via an <code>apply</code> factory method in the <code>Table</code>
 * singleton object provided by the <code>Tables</code> trait. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * val examples =
 *   Table(
 *     ("a", "b", "c", "d", "e"),
 *     (  0,   0,   0,   0,   0),
 *     (  1,   1,   1,   1,   1),
 *     (  2,   2,   2,   2,   2),
 *     (  3,   3,   3,   3,   3),
 *     (  4,   4,   4,   4,   4),
 *     (  5,   5,   5,   5,   5),
 *     (  6,   6,   6,   6,   6),
 *     (  7,   7,   7,   7,   7),
 *     (  8,   8,   8,   8,   8),
 *     (  9,   9,   9,   9,   9)
 *   )
 * </pre>
 *
 * <p>
 * Because you supplied 5 members in each tuple, the type you'll get back will be a <code>TableFor5</code>.
 * </p>
 *
 * <p>
 * The table provides an <code>apply</code> method that takes a function with a parameter list that matches
 * the types and arity of the tuples contained in this table. The <code>apply</code> method will invoke the
 * function with the members of each row tuple passed as arguments, in ascending order by index. (<em>I.e.</em>,
 * the zeroth tuple is checked first, then the tuple with index 1, then index 2, and so on until all the rows
 * have been checked (or until a failure occurs). The function represents a property of the code under test
 * that should succeed for every row of the table. If the function returns normally, that indicates the property
 * check succeeded for that row. If the function completes abruptly with an exception, that indicates the
 * property check failed and the <code>apply</code> method will complete abruptly with a
 * <code>TableDrivenPropertyCheckFailedException</code> that wraps the exception thrown by the supplied property function.
 * </p>
 * 
 * <p>
 * The usual way you'd invoke the <code>apply</code> method that checks a property is via a <code>forAll</code> method
 * provided by trait <code>TableDrivenPropertyChecks</code>. The <code>forAll</code> method takes a <code>TableFor5</code> as its
 * first argument, then in a curried argument list takes the property check function. It invokes <code>apply</code> on
 * the <code>TableFor5</code>, passing in the property check function. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * forAll (examples) { (a, b, c, d, e) =>
 *   a + b + c + d + e should equal (a * 5)
 * }
 * </pre>
 *
 * <p>
 * Because <code>TableFor5</code> is a <code>Seq[(A, B, C, D, E)]</code>, you can use it as a <code>Seq</code>. For example, here's how
 * you could get a sequence of <a href="../Outcome.html"><code>Outcome</code></a>s for each row of the table, indicating whether a property check succeeded or failed
 * on each row of the table:
 * </p>
 *
 * <pre class="stHighlight">
 * for (row <- examples) yield {
 *   outcomeOf { row._1 should not equal (7) }
 * }
 * </pre>
 *
 * <p>
 * Note: the <code>outcomeOf</code> method, contained in the <code>OutcomeOf</code> trait, will execute the supplied code (a by-name parameter) and
 * transform it to an <code>Outcome</code>. If no exception is thrown by the code, <code>outcomeOf</code> will result in a
 * <a href="../Succeeded$.html"><code>Succeeded</code></a>, indicating the "property check"
 * succeeded. If the supplied code completes abruptly in an exception that would normally cause a test to fail, <code>outcomeOf</code> will result in
 * in a <a href="../Failed.html"><code>Failed</code></a> instance containing that exception. For example, the previous for expression would give you:
 * </p>
 *
 * <pre class="stHighlight">
 * Vector(Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded,
 *     Failed(org.scalatest.TestFailedException: 7 equaled 7), Succeeded, Succeeded)
 * </pre>
 *
 * <p>
 * This shows that all the property checks succeeded, except for the one at index 7.
 * </p>
 *
 * @param heading a tuple containing string names of the columns in this table
 * @param rows a variable length parameter list of <code>Tuple5</code>s containing the data of this table
 *
 * @author Bill Venners 
 */

class TableFor5[A, B, C, D, E](val heading: (String, String, String, String, String), rows: (A, B, C, D, E)*) extends IndexedSeq[(A, B, C, D, E)] with IndexedSeqLike[(A, B, C, D, E), TableFor5[A, B, C, D, E]] {

  /**
   * Selects a row of data by its index.
   */
  def apply(idx: Int): (A, B, C, D, E) = rows(idx)

  /**
   * The number of rows of data in the table. (This does not include the <code>heading</code> tuple)
   */
  def length: Int = rows.length

  /**
   * Creates a new <code>Builder</code> for <code>TableFor5</code>s.
   */
  override protected[this] def newBuilder: Builder[(A, B, C, D, E), TableFor5[A, B, C, D, E]] =
    new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E)]) =>
      new TableFor5(heading, buf: _*)
    }

  /**
   * Applies the passed property check function to each row of this <code>TableFor5</code>.
   *
   * <p>
   * If the property checks for all rows succeed (the property check function returns normally when passed
   * the data for each row), this <code>apply</code> method returns normally. If the property check function
   * completes abruptly with an exception for any row, this <code>apply</code> method wraps that exception
   * in a <code>TableDrivenPropertyCheckFailedException</code> and completes abruptly with that exception. Once
   * the property check function throws an exception for a row, this <code>apply</code> method will complete
   * abruptly immediately and subsequent rows will not be checked against the function.
   * </p>
   *
   * @param fun the property check function to apply to each row of this <code>TableFor5</code>
   */
  def apply(fun: (A, B, C, D, E) => Unit) {
    for (((a, b, c, d, e), idx) <- rows.zipWithIndex) {
      try {
        fun(a, b, c, d, e)
      }
      catch {
        case _: DiscardedEvaluationException => // discard this evaluation and move on to the next
        case ex: Throwable =>
          val (aName, bName, cName, dName, eName) = heading

          throw new TableDrivenPropertyCheckFailedException(
            sde => FailureMessages("propertyException", UnquotedString(ex.getClass.getSimpleName)) + 
              ( sde.failedCodeFileNameAndLineNumberString match { case Some(s) => " (" + s + ")"; case None => "" }) + "\n" + 
              "  " + FailureMessages("thrownExceptionsMessage", if (ex.getMessage == null) "None" else UnquotedString(ex.getMessage)) + "\n" +
              (
                ex match {
                  case sd: StackDepth if sd.failedCodeFileNameAndLineNumberString.isDefined =>
                    "  " + FailureMessages("thrownExceptionsLocation", UnquotedString(sd.failedCodeFileNameAndLineNumberString.get)) + "\n"
                  case _ => ""
                }
              ) +
              "  " + FailureMessages("occurredAtRow", idx) + "\n" +
              "    " + aName + " = " + a + "," + "\n" +
              "    " + bName + " = " + b + "," + "\n" +
              "    " + cName + " = " + c + "," + "\n" +
              "    " + dName + " = " + d + "," + "\n" +
              "    " + eName + " = " + e + "\n" +

              "  )",
            Some(ex),
            getStackDepthFun("TableDrivenPropertyChecks.scala", "forAll", 2),
            FailureMessages("undecoratedPropertyCheckFailureMessage"),
            List(a, b, c, d, e),
            List(aName, bName, cName, dName, eName),
            idx
          )
      }
    }
  }

  /**
   * A string representation of this object, which includes the heading strings as well as the rows of data.
   */
  override def toString: String = stringPrefix + "(" + heading.toString + ", " +  rows.mkString(", ") + ")"
}

/**
 * Companion object for class <code>TableFor5</code> that provides an implicit <code>canBuildFrom</code> method
 * that enables higher order functions defined on <code>TableFor5</code> to return another <code>TableFor5</code>.
 *
 * @author Bill Venners 
 */
object TableFor5 {

  /**
   * Implicit method enabling higher order functions of <code>TableFor5</code> to return sequences of type <code>TableFor5</code>.
   */
  implicit def canBuildFrom[A, B, C, D, E]: CanBuildFrom[TableFor5[A, B, C, D, E], (A, B, C, D, E), TableFor5[A, B, C, D, E]] =
    new CanBuildFrom[TableFor5[A, B, C, D, E], (A, B, C, D, E), TableFor5[A, B, C, D, E]] {
      def apply(): Builder[(A, B, C, D, E), TableFor5[A, B, C, D, E]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E)]) =>
          new TableFor5(("arg0","arg1","arg2","arg3","arg4"))
        }
      def apply(from: TableFor5[A, B, C, D, E]): Builder[(A, B, C, D, E), TableFor5[A, B, C, D, E]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E)]) =>
          new TableFor5(from.heading, buf: _*)
        }
    }
}

/**
 * A table with 6 columns.
 *
 * <p>
 * For an introduction to using tables, see the documentation for trait
 * <a href="TableDrivenPropertyChecks.html">TableDrivenPropertyChecks</a>.
 * </p>
 *
 * <p>
 * This table is a sequence of <code>Tuple6</code> objects, where each tuple represents one row of the table.
 * The first element of each tuple comprise the first column of the table, the second element of 
 * each tuple comprise the second column, and so on.  This table also carries with it
 * a <em>heading</em> tuple that gives string names to the columns of the table.
 * </p>
 *
 * <p>
 * A handy way to create a <code>TableFor6</code> is via an <code>apply</code> factory method in the <code>Table</code>
 * singleton object provided by the <code>Tables</code> trait. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * val examples =
 *   Table(
 *     ("a", "b", "c", "d", "e", "f"),
 *     (  0,   0,   0,   0,   0,   0),
 *     (  1,   1,   1,   1,   1,   1),
 *     (  2,   2,   2,   2,   2,   2),
 *     (  3,   3,   3,   3,   3,   3),
 *     (  4,   4,   4,   4,   4,   4),
 *     (  5,   5,   5,   5,   5,   5),
 *     (  6,   6,   6,   6,   6,   6),
 *     (  7,   7,   7,   7,   7,   7),
 *     (  8,   8,   8,   8,   8,   8),
 *     (  9,   9,   9,   9,   9,   9)
 *   )
 * </pre>
 *
 * <p>
 * Because you supplied 6 members in each tuple, the type you'll get back will be a <code>TableFor6</code>.
 * </p>
 *
 * <p>
 * The table provides an <code>apply</code> method that takes a function with a parameter list that matches
 * the types and arity of the tuples contained in this table. The <code>apply</code> method will invoke the
 * function with the members of each row tuple passed as arguments, in ascending order by index. (<em>I.e.</em>,
 * the zeroth tuple is checked first, then the tuple with index 1, then index 2, and so on until all the rows
 * have been checked (or until a failure occurs). The function represents a property of the code under test
 * that should succeed for every row of the table. If the function returns normally, that indicates the property
 * check succeeded for that row. If the function completes abruptly with an exception, that indicates the
 * property check failed and the <code>apply</code> method will complete abruptly with a
 * <code>TableDrivenPropertyCheckFailedException</code> that wraps the exception thrown by the supplied property function.
 * </p>
 * 
 * <p>
 * The usual way you'd invoke the <code>apply</code> method that checks a property is via a <code>forAll</code> method
 * provided by trait <code>TableDrivenPropertyChecks</code>. The <code>forAll</code> method takes a <code>TableFor6</code> as its
 * first argument, then in a curried argument list takes the property check function. It invokes <code>apply</code> on
 * the <code>TableFor6</code>, passing in the property check function. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * forAll (examples) { (a, b, c, d, e, f) =>
 *   a + b + c + d + e + f should equal (a * 6)
 * }
 * </pre>
 *
 * <p>
 * Because <code>TableFor6</code> is a <code>Seq[(A, B, C, D, E, F)]</code>, you can use it as a <code>Seq</code>. For example, here's how
 * you could get a sequence of <a href="../Outcome.html"><code>Outcome</code></a>s for each row of the table, indicating whether a property check succeeded or failed
 * on each row of the table:
 * </p>
 *
 * <pre class="stHighlight">
 * for (row <- examples) yield {
 *   outcomeOf { row._1 should not equal (7) }
 * }
 * </pre>
 *
 * <p>
 * Note: the <code>outcomeOf</code> method, contained in the <code>OutcomeOf</code> trait, will execute the supplied code (a by-name parameter) and
 * transform it to an <code>Outcome</code>. If no exception is thrown by the code, <code>outcomeOf</code> will result in a
 * <a href="../Succeeded$.html"><code>Succeeded</code></a>, indicating the "property check"
 * succeeded. If the supplied code completes abruptly in an exception that would normally cause a test to fail, <code>outcomeOf</code> will result in
 * in a <a href="../Failed.html"><code>Failed</code></a> instance containing that exception. For example, the previous for expression would give you:
 * </p>
 *
 * <pre class="stHighlight">
 * Vector(Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded,
 *     Failed(org.scalatest.TestFailedException: 7 equaled 7), Succeeded, Succeeded)
 * </pre>
 *
 * <p>
 * This shows that all the property checks succeeded, except for the one at index 7.
 * </p>
 *
 * @param heading a tuple containing string names of the columns in this table
 * @param rows a variable length parameter list of <code>Tuple6</code>s containing the data of this table
 *
 * @author Bill Venners 
 */

class TableFor6[A, B, C, D, E, F](val heading: (String, String, String, String, String, String), rows: (A, B, C, D, E, F)*) extends IndexedSeq[(A, B, C, D, E, F)] with IndexedSeqLike[(A, B, C, D, E, F), TableFor6[A, B, C, D, E, F]] {

  /**
   * Selects a row of data by its index.
   */
  def apply(idx: Int): (A, B, C, D, E, F) = rows(idx)

  /**
   * The number of rows of data in the table. (This does not include the <code>heading</code> tuple)
   */
  def length: Int = rows.length

  /**
   * Creates a new <code>Builder</code> for <code>TableFor6</code>s.
   */
  override protected[this] def newBuilder: Builder[(A, B, C, D, E, F), TableFor6[A, B, C, D, E, F]] =
    new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F)]) =>
      new TableFor6(heading, buf: _*)
    }

  /**
   * Applies the passed property check function to each row of this <code>TableFor6</code>.
   *
   * <p>
   * If the property checks for all rows succeed (the property check function returns normally when passed
   * the data for each row), this <code>apply</code> method returns normally. If the property check function
   * completes abruptly with an exception for any row, this <code>apply</code> method wraps that exception
   * in a <code>TableDrivenPropertyCheckFailedException</code> and completes abruptly with that exception. Once
   * the property check function throws an exception for a row, this <code>apply</code> method will complete
   * abruptly immediately and subsequent rows will not be checked against the function.
   * </p>
   *
   * @param fun the property check function to apply to each row of this <code>TableFor6</code>
   */
  def apply(fun: (A, B, C, D, E, F) => Unit) {
    for (((a, b, c, d, e, f), idx) <- rows.zipWithIndex) {
      try {
        fun(a, b, c, d, e, f)
      }
      catch {
        case _: DiscardedEvaluationException => // discard this evaluation and move on to the next
        case ex: Throwable =>
          val (aName, bName, cName, dName, eName, fName) = heading

          throw new TableDrivenPropertyCheckFailedException(
            sde => FailureMessages("propertyException", UnquotedString(ex.getClass.getSimpleName)) + 
              ( sde.failedCodeFileNameAndLineNumberString match { case Some(s) => " (" + s + ")"; case None => "" }) + "\n" + 
              "  " + FailureMessages("thrownExceptionsMessage", if (ex.getMessage == null) "None" else UnquotedString(ex.getMessage)) + "\n" +
              (
                ex match {
                  case sd: StackDepth if sd.failedCodeFileNameAndLineNumberString.isDefined =>
                    "  " + FailureMessages("thrownExceptionsLocation", UnquotedString(sd.failedCodeFileNameAndLineNumberString.get)) + "\n"
                  case _ => ""
                }
              ) +
              "  " + FailureMessages("occurredAtRow", idx) + "\n" +
              "    " + aName + " = " + a + "," + "\n" +
              "    " + bName + " = " + b + "," + "\n" +
              "    " + cName + " = " + c + "," + "\n" +
              "    " + dName + " = " + d + "," + "\n" +
              "    " + eName + " = " + e + "," + "\n" +
              "    " + fName + " = " + f + "\n" +

              "  )",
            Some(ex),
            getStackDepthFun("TableDrivenPropertyChecks.scala", "forAll", 2),
            FailureMessages("undecoratedPropertyCheckFailureMessage"),
            List(a, b, c, d, e, f),
            List(aName, bName, cName, dName, eName, fName),
            idx
          )
      }
    }
  }

  /**
   * A string representation of this object, which includes the heading strings as well as the rows of data.
   */
  override def toString: String = stringPrefix + "(" + heading.toString + ", " +  rows.mkString(", ") + ")"
}

/**
 * Companion object for class <code>TableFor6</code> that provides an implicit <code>canBuildFrom</code> method
 * that enables higher order functions defined on <code>TableFor6</code> to return another <code>TableFor6</code>.
 *
 * @author Bill Venners 
 */
object TableFor6 {

  /**
   * Implicit method enabling higher order functions of <code>TableFor6</code> to return sequences of type <code>TableFor6</code>.
   */
  implicit def canBuildFrom[A, B, C, D, E, F]: CanBuildFrom[TableFor6[A, B, C, D, E, F], (A, B, C, D, E, F), TableFor6[A, B, C, D, E, F]] =
    new CanBuildFrom[TableFor6[A, B, C, D, E, F], (A, B, C, D, E, F), TableFor6[A, B, C, D, E, F]] {
      def apply(): Builder[(A, B, C, D, E, F), TableFor6[A, B, C, D, E, F]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F)]) =>
          new TableFor6(("arg0","arg1","arg2","arg3","arg4","arg5"))
        }
      def apply(from: TableFor6[A, B, C, D, E, F]): Builder[(A, B, C, D, E, F), TableFor6[A, B, C, D, E, F]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F)]) =>
          new TableFor6(from.heading, buf: _*)
        }
    }
}

/**
 * A table with 7 columns.
 *
 * <p>
 * For an introduction to using tables, see the documentation for trait
 * <a href="TableDrivenPropertyChecks.html">TableDrivenPropertyChecks</a>.
 * </p>
 *
 * <p>
 * This table is a sequence of <code>Tuple7</code> objects, where each tuple represents one row of the table.
 * The first element of each tuple comprise the first column of the table, the second element of 
 * each tuple comprise the second column, and so on.  This table also carries with it
 * a <em>heading</em> tuple that gives string names to the columns of the table.
 * </p>
 *
 * <p>
 * A handy way to create a <code>TableFor7</code> is via an <code>apply</code> factory method in the <code>Table</code>
 * singleton object provided by the <code>Tables</code> trait. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * val examples =
 *   Table(
 *     ("a", "b", "c", "d", "e", "f", "g"),
 *     (  0,   0,   0,   0,   0,   0,   0),
 *     (  1,   1,   1,   1,   1,   1,   1),
 *     (  2,   2,   2,   2,   2,   2,   2),
 *     (  3,   3,   3,   3,   3,   3,   3),
 *     (  4,   4,   4,   4,   4,   4,   4),
 *     (  5,   5,   5,   5,   5,   5,   5),
 *     (  6,   6,   6,   6,   6,   6,   6),
 *     (  7,   7,   7,   7,   7,   7,   7),
 *     (  8,   8,   8,   8,   8,   8,   8),
 *     (  9,   9,   9,   9,   9,   9,   9)
 *   )
 * </pre>
 *
 * <p>
 * Because you supplied 7 members in each tuple, the type you'll get back will be a <code>TableFor7</code>.
 * </p>
 *
 * <p>
 * The table provides an <code>apply</code> method that takes a function with a parameter list that matches
 * the types and arity of the tuples contained in this table. The <code>apply</code> method will invoke the
 * function with the members of each row tuple passed as arguments, in ascending order by index. (<em>I.e.</em>,
 * the zeroth tuple is checked first, then the tuple with index 1, then index 2, and so on until all the rows
 * have been checked (or until a failure occurs). The function represents a property of the code under test
 * that should succeed for every row of the table. If the function returns normally, that indicates the property
 * check succeeded for that row. If the function completes abruptly with an exception, that indicates the
 * property check failed and the <code>apply</code> method will complete abruptly with a
 * <code>TableDrivenPropertyCheckFailedException</code> that wraps the exception thrown by the supplied property function.
 * </p>
 * 
 * <p>
 * The usual way you'd invoke the <code>apply</code> method that checks a property is via a <code>forAll</code> method
 * provided by trait <code>TableDrivenPropertyChecks</code>. The <code>forAll</code> method takes a <code>TableFor7</code> as its
 * first argument, then in a curried argument list takes the property check function. It invokes <code>apply</code> on
 * the <code>TableFor7</code>, passing in the property check function. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * forAll (examples) { (a, b, c, d, e, f, g) =>
 *   a + b + c + d + e + f + g should equal (a * 7)
 * }
 * </pre>
 *
 * <p>
 * Because <code>TableFor7</code> is a <code>Seq[(A, B, C, D, E, F, G)]</code>, you can use it as a <code>Seq</code>. For example, here's how
 * you could get a sequence of <a href="../Outcome.html"><code>Outcome</code></a>s for each row of the table, indicating whether a property check succeeded or failed
 * on each row of the table:
 * </p>
 *
 * <pre class="stHighlight">
 * for (row <- examples) yield {
 *   outcomeOf { row._1 should not equal (7) }
 * }
 * </pre>
 *
 * <p>
 * Note: the <code>outcomeOf</code> method, contained in the <code>OutcomeOf</code> trait, will execute the supplied code (a by-name parameter) and
 * transform it to an <code>Outcome</code>. If no exception is thrown by the code, <code>outcomeOf</code> will result in a
 * <a href="../Succeeded$.html"><code>Succeeded</code></a>, indicating the "property check"
 * succeeded. If the supplied code completes abruptly in an exception that would normally cause a test to fail, <code>outcomeOf</code> will result in
 * in a <a href="../Failed.html"><code>Failed</code></a> instance containing that exception. For example, the previous for expression would give you:
 * </p>
 *
 * <pre class="stHighlight">
 * Vector(Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded,
 *     Failed(org.scalatest.TestFailedException: 7 equaled 7), Succeeded, Succeeded)
 * </pre>
 *
 * <p>
 * This shows that all the property checks succeeded, except for the one at index 7.
 * </p>
 *
 * @param heading a tuple containing string names of the columns in this table
 * @param rows a variable length parameter list of <code>Tuple7</code>s containing the data of this table
 *
 * @author Bill Venners 
 */

class TableFor7[A, B, C, D, E, F, G](val heading: (String, String, String, String, String, String, String), rows: (A, B, C, D, E, F, G)*) extends IndexedSeq[(A, B, C, D, E, F, G)] with IndexedSeqLike[(A, B, C, D, E, F, G), TableFor7[A, B, C, D, E, F, G]] {

  /**
   * Selects a row of data by its index.
   */
  def apply(idx: Int): (A, B, C, D, E, F, G) = rows(idx)

  /**
   * The number of rows of data in the table. (This does not include the <code>heading</code> tuple)
   */
  def length: Int = rows.length

  /**
   * Creates a new <code>Builder</code> for <code>TableFor7</code>s.
   */
  override protected[this] def newBuilder: Builder[(A, B, C, D, E, F, G), TableFor7[A, B, C, D, E, F, G]] =
    new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G)]) =>
      new TableFor7(heading, buf: _*)
    }

  /**
   * Applies the passed property check function to each row of this <code>TableFor7</code>.
   *
   * <p>
   * If the property checks for all rows succeed (the property check function returns normally when passed
   * the data for each row), this <code>apply</code> method returns normally. If the property check function
   * completes abruptly with an exception for any row, this <code>apply</code> method wraps that exception
   * in a <code>TableDrivenPropertyCheckFailedException</code> and completes abruptly with that exception. Once
   * the property check function throws an exception for a row, this <code>apply</code> method will complete
   * abruptly immediately and subsequent rows will not be checked against the function.
   * </p>
   *
   * @param fun the property check function to apply to each row of this <code>TableFor7</code>
   */
  def apply(fun: (A, B, C, D, E, F, G) => Unit) {
    for (((a, b, c, d, e, f, g), idx) <- rows.zipWithIndex) {
      try {
        fun(a, b, c, d, e, f, g)
      }
      catch {
        case _: DiscardedEvaluationException => // discard this evaluation and move on to the next
        case ex: Throwable =>
          val (aName, bName, cName, dName, eName, fName, gName) = heading

          throw new TableDrivenPropertyCheckFailedException(
            sde => FailureMessages("propertyException", UnquotedString(ex.getClass.getSimpleName)) + 
              ( sde.failedCodeFileNameAndLineNumberString match { case Some(s) => " (" + s + ")"; case None => "" }) + "\n" + 
              "  " + FailureMessages("thrownExceptionsMessage", if (ex.getMessage == null) "None" else UnquotedString(ex.getMessage)) + "\n" +
              (
                ex match {
                  case sd: StackDepth if sd.failedCodeFileNameAndLineNumberString.isDefined =>
                    "  " + FailureMessages("thrownExceptionsLocation", UnquotedString(sd.failedCodeFileNameAndLineNumberString.get)) + "\n"
                  case _ => ""
                }
              ) +
              "  " + FailureMessages("occurredAtRow", idx) + "\n" +
              "    " + aName + " = " + a + "," + "\n" +
              "    " + bName + " = " + b + "," + "\n" +
              "    " + cName + " = " + c + "," + "\n" +
              "    " + dName + " = " + d + "," + "\n" +
              "    " + eName + " = " + e + "," + "\n" +
              "    " + fName + " = " + f + "," + "\n" +
              "    " + gName + " = " + g + "\n" +

              "  )",
            Some(ex),
            getStackDepthFun("TableDrivenPropertyChecks.scala", "forAll", 2),
            FailureMessages("undecoratedPropertyCheckFailureMessage"),
            List(a, b, c, d, e, f, g),
            List(aName, bName, cName, dName, eName, fName, gName),
            idx
          )
      }
    }
  }

  /**
   * A string representation of this object, which includes the heading strings as well as the rows of data.
   */
  override def toString: String = stringPrefix + "(" + heading.toString + ", " +  rows.mkString(", ") + ")"
}

/**
 * Companion object for class <code>TableFor7</code> that provides an implicit <code>canBuildFrom</code> method
 * that enables higher order functions defined on <code>TableFor7</code> to return another <code>TableFor7</code>.
 *
 * @author Bill Venners 
 */
object TableFor7 {

  /**
   * Implicit method enabling higher order functions of <code>TableFor7</code> to return sequences of type <code>TableFor7</code>.
   */
  implicit def canBuildFrom[A, B, C, D, E, F, G]: CanBuildFrom[TableFor7[A, B, C, D, E, F, G], (A, B, C, D, E, F, G), TableFor7[A, B, C, D, E, F, G]] =
    new CanBuildFrom[TableFor7[A, B, C, D, E, F, G], (A, B, C, D, E, F, G), TableFor7[A, B, C, D, E, F, G]] {
      def apply(): Builder[(A, B, C, D, E, F, G), TableFor7[A, B, C, D, E, F, G]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G)]) =>
          new TableFor7(("arg0","arg1","arg2","arg3","arg4","arg5","arg6"))
        }
      def apply(from: TableFor7[A, B, C, D, E, F, G]): Builder[(A, B, C, D, E, F, G), TableFor7[A, B, C, D, E, F, G]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G)]) =>
          new TableFor7(from.heading, buf: _*)
        }
    }
}

/**
 * A table with 8 columns.
 *
 * <p>
 * For an introduction to using tables, see the documentation for trait
 * <a href="TableDrivenPropertyChecks.html">TableDrivenPropertyChecks</a>.
 * </p>
 *
 * <p>
 * This table is a sequence of <code>Tuple8</code> objects, where each tuple represents one row of the table.
 * The first element of each tuple comprise the first column of the table, the second element of 
 * each tuple comprise the second column, and so on.  This table also carries with it
 * a <em>heading</em> tuple that gives string names to the columns of the table.
 * </p>
 *
 * <p>
 * A handy way to create a <code>TableFor8</code> is via an <code>apply</code> factory method in the <code>Table</code>
 * singleton object provided by the <code>Tables</code> trait. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * val examples =
 *   Table(
 *     ("a", "b", "c", "d", "e", "f", "g", "h"),
 *     (  0,   0,   0,   0,   0,   0,   0,   0),
 *     (  1,   1,   1,   1,   1,   1,   1,   1),
 *     (  2,   2,   2,   2,   2,   2,   2,   2),
 *     (  3,   3,   3,   3,   3,   3,   3,   3),
 *     (  4,   4,   4,   4,   4,   4,   4,   4),
 *     (  5,   5,   5,   5,   5,   5,   5,   5),
 *     (  6,   6,   6,   6,   6,   6,   6,   6),
 *     (  7,   7,   7,   7,   7,   7,   7,   7),
 *     (  8,   8,   8,   8,   8,   8,   8,   8),
 *     (  9,   9,   9,   9,   9,   9,   9,   9)
 *   )
 * </pre>
 *
 * <p>
 * Because you supplied 8 members in each tuple, the type you'll get back will be a <code>TableFor8</code>.
 * </p>
 *
 * <p>
 * The table provides an <code>apply</code> method that takes a function with a parameter list that matches
 * the types and arity of the tuples contained in this table. The <code>apply</code> method will invoke the
 * function with the members of each row tuple passed as arguments, in ascending order by index. (<em>I.e.</em>,
 * the zeroth tuple is checked first, then the tuple with index 1, then index 2, and so on until all the rows
 * have been checked (or until a failure occurs). The function represents a property of the code under test
 * that should succeed for every row of the table. If the function returns normally, that indicates the property
 * check succeeded for that row. If the function completes abruptly with an exception, that indicates the
 * property check failed and the <code>apply</code> method will complete abruptly with a
 * <code>TableDrivenPropertyCheckFailedException</code> that wraps the exception thrown by the supplied property function.
 * </p>
 * 
 * <p>
 * The usual way you'd invoke the <code>apply</code> method that checks a property is via a <code>forAll</code> method
 * provided by trait <code>TableDrivenPropertyChecks</code>. The <code>forAll</code> method takes a <code>TableFor8</code> as its
 * first argument, then in a curried argument list takes the property check function. It invokes <code>apply</code> on
 * the <code>TableFor8</code>, passing in the property check function. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * forAll (examples) { (a, b, c, d, e, f, g, h) =>
 *   a + b + c + d + e + f + g + h should equal (a * 8)
 * }
 * </pre>
 *
 * <p>
 * Because <code>TableFor8</code> is a <code>Seq[(A, B, C, D, E, F, G, H)]</code>, you can use it as a <code>Seq</code>. For example, here's how
 * you could get a sequence of <a href="../Outcome.html"><code>Outcome</code></a>s for each row of the table, indicating whether a property check succeeded or failed
 * on each row of the table:
 * </p>
 *
 * <pre class="stHighlight">
 * for (row <- examples) yield {
 *   outcomeOf { row._1 should not equal (7) }
 * }
 * </pre>
 *
 * <p>
 * Note: the <code>outcomeOf</code> method, contained in the <code>OutcomeOf</code> trait, will execute the supplied code (a by-name parameter) and
 * transform it to an <code>Outcome</code>. If no exception is thrown by the code, <code>outcomeOf</code> will result in a
 * <a href="../Succeeded$.html"><code>Succeeded</code></a>, indicating the "property check"
 * succeeded. If the supplied code completes abruptly in an exception that would normally cause a test to fail, <code>outcomeOf</code> will result in
 * in a <a href="../Failed.html"><code>Failed</code></a> instance containing that exception. For example, the previous for expression would give you:
 * </p>
 *
 * <pre class="stHighlight">
 * Vector(Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded,
 *     Failed(org.scalatest.TestFailedException: 7 equaled 7), Succeeded, Succeeded)
 * </pre>
 *
 * <p>
 * This shows that all the property checks succeeded, except for the one at index 7.
 * </p>
 *
 * @param heading a tuple containing string names of the columns in this table
 * @param rows a variable length parameter list of <code>Tuple8</code>s containing the data of this table
 *
 * @author Bill Venners 
 */

class TableFor8[A, B, C, D, E, F, G, H](val heading: (String, String, String, String, String, String, String, String), rows: (A, B, C, D, E, F, G, H)*) extends IndexedSeq[(A, B, C, D, E, F, G, H)] with IndexedSeqLike[(A, B, C, D, E, F, G, H), TableFor8[A, B, C, D, E, F, G, H]] {

  /**
   * Selects a row of data by its index.
   */
  def apply(idx: Int): (A, B, C, D, E, F, G, H) = rows(idx)

  /**
   * The number of rows of data in the table. (This does not include the <code>heading</code> tuple)
   */
  def length: Int = rows.length

  /**
   * Creates a new <code>Builder</code> for <code>TableFor8</code>s.
   */
  override protected[this] def newBuilder: Builder[(A, B, C, D, E, F, G, H), TableFor8[A, B, C, D, E, F, G, H]] =
    new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H)]) =>
      new TableFor8(heading, buf: _*)
    }

  /**
   * Applies the passed property check function to each row of this <code>TableFor8</code>.
   *
   * <p>
   * If the property checks for all rows succeed (the property check function returns normally when passed
   * the data for each row), this <code>apply</code> method returns normally. If the property check function
   * completes abruptly with an exception for any row, this <code>apply</code> method wraps that exception
   * in a <code>TableDrivenPropertyCheckFailedException</code> and completes abruptly with that exception. Once
   * the property check function throws an exception for a row, this <code>apply</code> method will complete
   * abruptly immediately and subsequent rows will not be checked against the function.
   * </p>
   *
   * @param fun the property check function to apply to each row of this <code>TableFor8</code>
   */
  def apply(fun: (A, B, C, D, E, F, G, H) => Unit) {
    for (((a, b, c, d, e, f, g, h), idx) <- rows.zipWithIndex) {
      try {
        fun(a, b, c, d, e, f, g, h)
      }
      catch {
        case _: DiscardedEvaluationException => // discard this evaluation and move on to the next
        case ex: Throwable =>
          val (aName, bName, cName, dName, eName, fName, gName, hName) = heading

          throw new TableDrivenPropertyCheckFailedException(
            sde => FailureMessages("propertyException", UnquotedString(ex.getClass.getSimpleName)) + 
              ( sde.failedCodeFileNameAndLineNumberString match { case Some(s) => " (" + s + ")"; case None => "" }) + "\n" + 
              "  " + FailureMessages("thrownExceptionsMessage", if (ex.getMessage == null) "None" else UnquotedString(ex.getMessage)) + "\n" +
              (
                ex match {
                  case sd: StackDepth if sd.failedCodeFileNameAndLineNumberString.isDefined =>
                    "  " + FailureMessages("thrownExceptionsLocation", UnquotedString(sd.failedCodeFileNameAndLineNumberString.get)) + "\n"
                  case _ => ""
                }
              ) +
              "  " + FailureMessages("occurredAtRow", idx) + "\n" +
              "    " + aName + " = " + a + "," + "\n" +
              "    " + bName + " = " + b + "," + "\n" +
              "    " + cName + " = " + c + "," + "\n" +
              "    " + dName + " = " + d + "," + "\n" +
              "    " + eName + " = " + e + "," + "\n" +
              "    " + fName + " = " + f + "," + "\n" +
              "    " + gName + " = " + g + "," + "\n" +
              "    " + hName + " = " + h + "\n" +

              "  )",
            Some(ex),
            getStackDepthFun("TableDrivenPropertyChecks.scala", "forAll", 2),
            FailureMessages("undecoratedPropertyCheckFailureMessage"),
            List(a, b, c, d, e, f, g, h),
            List(aName, bName, cName, dName, eName, fName, gName, hName),
            idx
          )
      }
    }
  }

  /**
   * A string representation of this object, which includes the heading strings as well as the rows of data.
   */
  override def toString: String = stringPrefix + "(" + heading.toString + ", " +  rows.mkString(", ") + ")"
}

/**
 * Companion object for class <code>TableFor8</code> that provides an implicit <code>canBuildFrom</code> method
 * that enables higher order functions defined on <code>TableFor8</code> to return another <code>TableFor8</code>.
 *
 * @author Bill Venners 
 */
object TableFor8 {

  /**
   * Implicit method enabling higher order functions of <code>TableFor8</code> to return sequences of type <code>TableFor8</code>.
   */
  implicit def canBuildFrom[A, B, C, D, E, F, G, H]: CanBuildFrom[TableFor8[A, B, C, D, E, F, G, H], (A, B, C, D, E, F, G, H), TableFor8[A, B, C, D, E, F, G, H]] =
    new CanBuildFrom[TableFor8[A, B, C, D, E, F, G, H], (A, B, C, D, E, F, G, H), TableFor8[A, B, C, D, E, F, G, H]] {
      def apply(): Builder[(A, B, C, D, E, F, G, H), TableFor8[A, B, C, D, E, F, G, H]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H)]) =>
          new TableFor8(("arg0","arg1","arg2","arg3","arg4","arg5","arg6","arg7"))
        }
      def apply(from: TableFor8[A, B, C, D, E, F, G, H]): Builder[(A, B, C, D, E, F, G, H), TableFor8[A, B, C, D, E, F, G, H]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H)]) =>
          new TableFor8(from.heading, buf: _*)
        }
    }
}

/**
 * A table with 9 columns.
 *
 * <p>
 * For an introduction to using tables, see the documentation for trait
 * <a href="TableDrivenPropertyChecks.html">TableDrivenPropertyChecks</a>.
 * </p>
 *
 * <p>
 * This table is a sequence of <code>Tuple9</code> objects, where each tuple represents one row of the table.
 * The first element of each tuple comprise the first column of the table, the second element of 
 * each tuple comprise the second column, and so on.  This table also carries with it
 * a <em>heading</em> tuple that gives string names to the columns of the table.
 * </p>
 *
 * <p>
 * A handy way to create a <code>TableFor9</code> is via an <code>apply</code> factory method in the <code>Table</code>
 * singleton object provided by the <code>Tables</code> trait. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * val examples =
 *   Table(
 *     ("a", "b", "c", "d", "e", "f", "g", "h", "i"),
 *     (  0,   0,   0,   0,   0,   0,   0,   0,   0),
 *     (  1,   1,   1,   1,   1,   1,   1,   1,   1),
 *     (  2,   2,   2,   2,   2,   2,   2,   2,   2),
 *     (  3,   3,   3,   3,   3,   3,   3,   3,   3),
 *     (  4,   4,   4,   4,   4,   4,   4,   4,   4),
 *     (  5,   5,   5,   5,   5,   5,   5,   5,   5),
 *     (  6,   6,   6,   6,   6,   6,   6,   6,   6),
 *     (  7,   7,   7,   7,   7,   7,   7,   7,   7),
 *     (  8,   8,   8,   8,   8,   8,   8,   8,   8),
 *     (  9,   9,   9,   9,   9,   9,   9,   9,   9)
 *   )
 * </pre>
 *
 * <p>
 * Because you supplied 9 members in each tuple, the type you'll get back will be a <code>TableFor9</code>.
 * </p>
 *
 * <p>
 * The table provides an <code>apply</code> method that takes a function with a parameter list that matches
 * the types and arity of the tuples contained in this table. The <code>apply</code> method will invoke the
 * function with the members of each row tuple passed as arguments, in ascending order by index. (<em>I.e.</em>,
 * the zeroth tuple is checked first, then the tuple with index 1, then index 2, and so on until all the rows
 * have been checked (or until a failure occurs). The function represents a property of the code under test
 * that should succeed for every row of the table. If the function returns normally, that indicates the property
 * check succeeded for that row. If the function completes abruptly with an exception, that indicates the
 * property check failed and the <code>apply</code> method will complete abruptly with a
 * <code>TableDrivenPropertyCheckFailedException</code> that wraps the exception thrown by the supplied property function.
 * </p>
 * 
 * <p>
 * The usual way you'd invoke the <code>apply</code> method that checks a property is via a <code>forAll</code> method
 * provided by trait <code>TableDrivenPropertyChecks</code>. The <code>forAll</code> method takes a <code>TableFor9</code> as its
 * first argument, then in a curried argument list takes the property check function. It invokes <code>apply</code> on
 * the <code>TableFor9</code>, passing in the property check function. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * forAll (examples) { (a, b, c, d, e, f, g, h, i) =>
 *   a + b + c + d + e + f + g + h + i should equal (a * 9)
 * }
 * </pre>
 *
 * <p>
 * Because <code>TableFor9</code> is a <code>Seq[(A, B, C, D, E, F, G, H, I)]</code>, you can use it as a <code>Seq</code>. For example, here's how
 * you could get a sequence of <a href="../Outcome.html"><code>Outcome</code></a>s for each row of the table, indicating whether a property check succeeded or failed
 * on each row of the table:
 * </p>
 *
 * <pre class="stHighlight">
 * for (row <- examples) yield {
 *   outcomeOf { row._1 should not equal (7) }
 * }
 * </pre>
 *
 * <p>
 * Note: the <code>outcomeOf</code> method, contained in the <code>OutcomeOf</code> trait, will execute the supplied code (a by-name parameter) and
 * transform it to an <code>Outcome</code>. If no exception is thrown by the code, <code>outcomeOf</code> will result in a
 * <a href="../Succeeded$.html"><code>Succeeded</code></a>, indicating the "property check"
 * succeeded. If the supplied code completes abruptly in an exception that would normally cause a test to fail, <code>outcomeOf</code> will result in
 * in a <a href="../Failed.html"><code>Failed</code></a> instance containing that exception. For example, the previous for expression would give you:
 * </p>
 *
 * <pre class="stHighlight">
 * Vector(Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded,
 *     Failed(org.scalatest.TestFailedException: 7 equaled 7), Succeeded, Succeeded)
 * </pre>
 *
 * <p>
 * This shows that all the property checks succeeded, except for the one at index 7.
 * </p>
 *
 * @param heading a tuple containing string names of the columns in this table
 * @param rows a variable length parameter list of <code>Tuple9</code>s containing the data of this table
 *
 * @author Bill Venners 
 */

class TableFor9[A, B, C, D, E, F, G, H, I](val heading: (String, String, String, String, String, String, String, String, String), rows: (A, B, C, D, E, F, G, H, I)*) extends IndexedSeq[(A, B, C, D, E, F, G, H, I)] with IndexedSeqLike[(A, B, C, D, E, F, G, H, I), TableFor9[A, B, C, D, E, F, G, H, I]] {

  /**
   * Selects a row of data by its index.
   */
  def apply(idx: Int): (A, B, C, D, E, F, G, H, I) = rows(idx)

  /**
   * The number of rows of data in the table. (This does not include the <code>heading</code> tuple)
   */
  def length: Int = rows.length

  /**
   * Creates a new <code>Builder</code> for <code>TableFor9</code>s.
   */
  override protected[this] def newBuilder: Builder[(A, B, C, D, E, F, G, H, I), TableFor9[A, B, C, D, E, F, G, H, I]] =
    new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I)]) =>
      new TableFor9(heading, buf: _*)
    }

  /**
   * Applies the passed property check function to each row of this <code>TableFor9</code>.
   *
   * <p>
   * If the property checks for all rows succeed (the property check function returns normally when passed
   * the data for each row), this <code>apply</code> method returns normally. If the property check function
   * completes abruptly with an exception for any row, this <code>apply</code> method wraps that exception
   * in a <code>TableDrivenPropertyCheckFailedException</code> and completes abruptly with that exception. Once
   * the property check function throws an exception for a row, this <code>apply</code> method will complete
   * abruptly immediately and subsequent rows will not be checked against the function.
   * </p>
   *
   * @param fun the property check function to apply to each row of this <code>TableFor9</code>
   */
  def apply(fun: (A, B, C, D, E, F, G, H, I) => Unit) {
    for (((a, b, c, d, e, f, g, h, i), idx) <- rows.zipWithIndex) {
      try {
        fun(a, b, c, d, e, f, g, h, i)
      }
      catch {
        case _: DiscardedEvaluationException => // discard this evaluation and move on to the next
        case ex: Throwable =>
          val (aName, bName, cName, dName, eName, fName, gName, hName, iName) = heading

          throw new TableDrivenPropertyCheckFailedException(
            sde => FailureMessages("propertyException", UnquotedString(ex.getClass.getSimpleName)) + 
              ( sde.failedCodeFileNameAndLineNumberString match { case Some(s) => " (" + s + ")"; case None => "" }) + "\n" + 
              "  " + FailureMessages("thrownExceptionsMessage", if (ex.getMessage == null) "None" else UnquotedString(ex.getMessage)) + "\n" +
              (
                ex match {
                  case sd: StackDepth if sd.failedCodeFileNameAndLineNumberString.isDefined =>
                    "  " + FailureMessages("thrownExceptionsLocation", UnquotedString(sd.failedCodeFileNameAndLineNumberString.get)) + "\n"
                  case _ => ""
                }
              ) +
              "  " + FailureMessages("occurredAtRow", idx) + "\n" +
              "    " + aName + " = " + a + "," + "\n" +
              "    " + bName + " = " + b + "," + "\n" +
              "    " + cName + " = " + c + "," + "\n" +
              "    " + dName + " = " + d + "," + "\n" +
              "    " + eName + " = " + e + "," + "\n" +
              "    " + fName + " = " + f + "," + "\n" +
              "    " + gName + " = " + g + "," + "\n" +
              "    " + hName + " = " + h + "," + "\n" +
              "    " + iName + " = " + i + "\n" +

              "  )",
            Some(ex),
            getStackDepthFun("TableDrivenPropertyChecks.scala", "forAll", 2),
            FailureMessages("undecoratedPropertyCheckFailureMessage"),
            List(a, b, c, d, e, f, g, h, i),
            List(aName, bName, cName, dName, eName, fName, gName, hName, iName),
            idx
          )
      }
    }
  }

  /**
   * A string representation of this object, which includes the heading strings as well as the rows of data.
   */
  override def toString: String = stringPrefix + "(" + heading.toString + ", " +  rows.mkString(", ") + ")"
}

/**
 * Companion object for class <code>TableFor9</code> that provides an implicit <code>canBuildFrom</code> method
 * that enables higher order functions defined on <code>TableFor9</code> to return another <code>TableFor9</code>.
 *
 * @author Bill Venners 
 */
object TableFor9 {

  /**
   * Implicit method enabling higher order functions of <code>TableFor9</code> to return sequences of type <code>TableFor9</code>.
   */
  implicit def canBuildFrom[A, B, C, D, E, F, G, H, I]: CanBuildFrom[TableFor9[A, B, C, D, E, F, G, H, I], (A, B, C, D, E, F, G, H, I), TableFor9[A, B, C, D, E, F, G, H, I]] =
    new CanBuildFrom[TableFor9[A, B, C, D, E, F, G, H, I], (A, B, C, D, E, F, G, H, I), TableFor9[A, B, C, D, E, F, G, H, I]] {
      def apply(): Builder[(A, B, C, D, E, F, G, H, I), TableFor9[A, B, C, D, E, F, G, H, I]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I)]) =>
          new TableFor9(("arg0","arg1","arg2","arg3","arg4","arg5","arg6","arg7","arg8"))
        }
      def apply(from: TableFor9[A, B, C, D, E, F, G, H, I]): Builder[(A, B, C, D, E, F, G, H, I), TableFor9[A, B, C, D, E, F, G, H, I]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I)]) =>
          new TableFor9(from.heading, buf: _*)
        }
    }
}

/**
 * A table with 10 columns.
 *
 * <p>
 * For an introduction to using tables, see the documentation for trait
 * <a href="TableDrivenPropertyChecks.html">TableDrivenPropertyChecks</a>.
 * </p>
 *
 * <p>
 * This table is a sequence of <code>Tuple10</code> objects, where each tuple represents one row of the table.
 * The first element of each tuple comprise the first column of the table, the second element of 
 * each tuple comprise the second column, and so on.  This table also carries with it
 * a <em>heading</em> tuple that gives string names to the columns of the table.
 * </p>
 *
 * <p>
 * A handy way to create a <code>TableFor10</code> is via an <code>apply</code> factory method in the <code>Table</code>
 * singleton object provided by the <code>Tables</code> trait. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * val examples =
 *   Table(
 *     ("a", "b", "c", "d", "e", "f", "g", "h", "i", "j"),
 *     (  0,   0,   0,   0,   0,   0,   0,   0,   0,   0),
 *     (  1,   1,   1,   1,   1,   1,   1,   1,   1,   1),
 *     (  2,   2,   2,   2,   2,   2,   2,   2,   2,   2),
 *     (  3,   3,   3,   3,   3,   3,   3,   3,   3,   3),
 *     (  4,   4,   4,   4,   4,   4,   4,   4,   4,   4),
 *     (  5,   5,   5,   5,   5,   5,   5,   5,   5,   5),
 *     (  6,   6,   6,   6,   6,   6,   6,   6,   6,   6),
 *     (  7,   7,   7,   7,   7,   7,   7,   7,   7,   7),
 *     (  8,   8,   8,   8,   8,   8,   8,   8,   8,   8),
 *     (  9,   9,   9,   9,   9,   9,   9,   9,   9,   9)
 *   )
 * </pre>
 *
 * <p>
 * Because you supplied 10 members in each tuple, the type you'll get back will be a <code>TableFor10</code>.
 * </p>
 *
 * <p>
 * The table provides an <code>apply</code> method that takes a function with a parameter list that matches
 * the types and arity of the tuples contained in this table. The <code>apply</code> method will invoke the
 * function with the members of each row tuple passed as arguments, in ascending order by index. (<em>I.e.</em>,
 * the zeroth tuple is checked first, then the tuple with index 1, then index 2, and so on until all the rows
 * have been checked (or until a failure occurs). The function represents a property of the code under test
 * that should succeed for every row of the table. If the function returns normally, that indicates the property
 * check succeeded for that row. If the function completes abruptly with an exception, that indicates the
 * property check failed and the <code>apply</code> method will complete abruptly with a
 * <code>TableDrivenPropertyCheckFailedException</code> that wraps the exception thrown by the supplied property function.
 * </p>
 * 
 * <p>
 * The usual way you'd invoke the <code>apply</code> method that checks a property is via a <code>forAll</code> method
 * provided by trait <code>TableDrivenPropertyChecks</code>. The <code>forAll</code> method takes a <code>TableFor10</code> as its
 * first argument, then in a curried argument list takes the property check function. It invokes <code>apply</code> on
 * the <code>TableFor10</code>, passing in the property check function. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * forAll (examples) { (a, b, c, d, e, f, g, h, i, j) =>
 *   a + b + c + d + e + f + g + h + i + j should equal (a * 10)
 * }
 * </pre>
 *
 * <p>
 * Because <code>TableFor10</code> is a <code>Seq[(A, B, C, D, E, F, G, H, I, J)]</code>, you can use it as a <code>Seq</code>. For example, here's how
 * you could get a sequence of <a href="../Outcome.html"><code>Outcome</code></a>s for each row of the table, indicating whether a property check succeeded or failed
 * on each row of the table:
 * </p>
 *
 * <pre class="stHighlight">
 * for (row <- examples) yield {
 *   outcomeOf { row._1 should not equal (7) }
 * }
 * </pre>
 *
 * <p>
 * Note: the <code>outcomeOf</code> method, contained in the <code>OutcomeOf</code> trait, will execute the supplied code (a by-name parameter) and
 * transform it to an <code>Outcome</code>. If no exception is thrown by the code, <code>outcomeOf</code> will result in a
 * <a href="../Succeeded$.html"><code>Succeeded</code></a>, indicating the "property check"
 * succeeded. If the supplied code completes abruptly in an exception that would normally cause a test to fail, <code>outcomeOf</code> will result in
 * in a <a href="../Failed.html"><code>Failed</code></a> instance containing that exception. For example, the previous for expression would give you:
 * </p>
 *
 * <pre class="stHighlight">
 * Vector(Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded,
 *     Failed(org.scalatest.TestFailedException: 7 equaled 7), Succeeded, Succeeded)
 * </pre>
 *
 * <p>
 * This shows that all the property checks succeeded, except for the one at index 7.
 * </p>
 *
 * @param heading a tuple containing string names of the columns in this table
 * @param rows a variable length parameter list of <code>Tuple10</code>s containing the data of this table
 *
 * @author Bill Venners 
 */

class TableFor10[A, B, C, D, E, F, G, H, I, J](val heading: (String, String, String, String, String, String, String, String, String, String), rows: (A, B, C, D, E, F, G, H, I, J)*) extends IndexedSeq[(A, B, C, D, E, F, G, H, I, J)] with IndexedSeqLike[(A, B, C, D, E, F, G, H, I, J), TableFor10[A, B, C, D, E, F, G, H, I, J]] {

  /**
   * Selects a row of data by its index.
   */
  def apply(idx: Int): (A, B, C, D, E, F, G, H, I, J) = rows(idx)

  /**
   * The number of rows of data in the table. (This does not include the <code>heading</code> tuple)
   */
  def length: Int = rows.length

  /**
   * Creates a new <code>Builder</code> for <code>TableFor10</code>s.
   */
  override protected[this] def newBuilder: Builder[(A, B, C, D, E, F, G, H, I, J), TableFor10[A, B, C, D, E, F, G, H, I, J]] =
    new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J)]) =>
      new TableFor10(heading, buf: _*)
    }

  /**
   * Applies the passed property check function to each row of this <code>TableFor10</code>.
   *
   * <p>
   * If the property checks for all rows succeed (the property check function returns normally when passed
   * the data for each row), this <code>apply</code> method returns normally. If the property check function
   * completes abruptly with an exception for any row, this <code>apply</code> method wraps that exception
   * in a <code>TableDrivenPropertyCheckFailedException</code> and completes abruptly with that exception. Once
   * the property check function throws an exception for a row, this <code>apply</code> method will complete
   * abruptly immediately and subsequent rows will not be checked against the function.
   * </p>
   *
   * @param fun the property check function to apply to each row of this <code>TableFor10</code>
   */
  def apply(fun: (A, B, C, D, E, F, G, H, I, J) => Unit) {
    for (((a, b, c, d, e, f, g, h, i, j), idx) <- rows.zipWithIndex) {
      try {
        fun(a, b, c, d, e, f, g, h, i, j)
      }
      catch {
        case _: DiscardedEvaluationException => // discard this evaluation and move on to the next
        case ex: Throwable =>
          val (aName, bName, cName, dName, eName, fName, gName, hName, iName, jName) = heading

          throw new TableDrivenPropertyCheckFailedException(
            sde => FailureMessages("propertyException", UnquotedString(ex.getClass.getSimpleName)) + 
              ( sde.failedCodeFileNameAndLineNumberString match { case Some(s) => " (" + s + ")"; case None => "" }) + "\n" + 
              "  " + FailureMessages("thrownExceptionsMessage", if (ex.getMessage == null) "None" else UnquotedString(ex.getMessage)) + "\n" +
              (
                ex match {
                  case sd: StackDepth if sd.failedCodeFileNameAndLineNumberString.isDefined =>
                    "  " + FailureMessages("thrownExceptionsLocation", UnquotedString(sd.failedCodeFileNameAndLineNumberString.get)) + "\n"
                  case _ => ""
                }
              ) +
              "  " + FailureMessages("occurredAtRow", idx) + "\n" +
              "    " + aName + " = " + a + "," + "\n" +
              "    " + bName + " = " + b + "," + "\n" +
              "    " + cName + " = " + c + "," + "\n" +
              "    " + dName + " = " + d + "," + "\n" +
              "    " + eName + " = " + e + "," + "\n" +
              "    " + fName + " = " + f + "," + "\n" +
              "    " + gName + " = " + g + "," + "\n" +
              "    " + hName + " = " + h + "," + "\n" +
              "    " + iName + " = " + i + "," + "\n" +
              "    " + jName + " = " + j + "\n" +

              "  )",
            Some(ex),
            getStackDepthFun("TableDrivenPropertyChecks.scala", "forAll", 2),
            FailureMessages("undecoratedPropertyCheckFailureMessage"),
            List(a, b, c, d, e, f, g, h, i, j),
            List(aName, bName, cName, dName, eName, fName, gName, hName, iName, jName),
            idx
          )
      }
    }
  }

  /**
   * A string representation of this object, which includes the heading strings as well as the rows of data.
   */
  override def toString: String = stringPrefix + "(" + heading.toString + ", " +  rows.mkString(", ") + ")"
}

/**
 * Companion object for class <code>TableFor10</code> that provides an implicit <code>canBuildFrom</code> method
 * that enables higher order functions defined on <code>TableFor10</code> to return another <code>TableFor10</code>.
 *
 * @author Bill Venners 
 */
object TableFor10 {

  /**
   * Implicit method enabling higher order functions of <code>TableFor10</code> to return sequences of type <code>TableFor10</code>.
   */
  implicit def canBuildFrom[A, B, C, D, E, F, G, H, I, J]: CanBuildFrom[TableFor10[A, B, C, D, E, F, G, H, I, J], (A, B, C, D, E, F, G, H, I, J), TableFor10[A, B, C, D, E, F, G, H, I, J]] =
    new CanBuildFrom[TableFor10[A, B, C, D, E, F, G, H, I, J], (A, B, C, D, E, F, G, H, I, J), TableFor10[A, B, C, D, E, F, G, H, I, J]] {
      def apply(): Builder[(A, B, C, D, E, F, G, H, I, J), TableFor10[A, B, C, D, E, F, G, H, I, J]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J)]) =>
          new TableFor10(("arg0","arg1","arg2","arg3","arg4","arg5","arg6","arg7","arg8","arg9"))
        }
      def apply(from: TableFor10[A, B, C, D, E, F, G, H, I, J]): Builder[(A, B, C, D, E, F, G, H, I, J), TableFor10[A, B, C, D, E, F, G, H, I, J]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J)]) =>
          new TableFor10(from.heading, buf: _*)
        }
    }
}

/**
 * A table with 11 columns.
 *
 * <p>
 * For an introduction to using tables, see the documentation for trait
 * <a href="TableDrivenPropertyChecks.html">TableDrivenPropertyChecks</a>.
 * </p>
 *
 * <p>
 * This table is a sequence of <code>Tuple11</code> objects, where each tuple represents one row of the table.
 * The first element of each tuple comprise the first column of the table, the second element of 
 * each tuple comprise the second column, and so on.  This table also carries with it
 * a <em>heading</em> tuple that gives string names to the columns of the table.
 * </p>
 *
 * <p>
 * A handy way to create a <code>TableFor11</code> is via an <code>apply</code> factory method in the <code>Table</code>
 * singleton object provided by the <code>Tables</code> trait. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * val examples =
 *   Table(
 *     ("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"),
 *     (  0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0),
 *     (  1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1),
 *     (  2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2),
 *     (  3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3),
 *     (  4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4),
 *     (  5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5),
 *     (  6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6),
 *     (  7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7),
 *     (  8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8),
 *     (  9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9)
 *   )
 * </pre>
 *
 * <p>
 * Because you supplied 11 members in each tuple, the type you'll get back will be a <code>TableFor11</code>.
 * </p>
 *
 * <p>
 * The table provides an <code>apply</code> method that takes a function with a parameter list that matches
 * the types and arity of the tuples contained in this table. The <code>apply</code> method will invoke the
 * function with the members of each row tuple passed as arguments, in ascending order by index. (<em>I.e.</em>,
 * the zeroth tuple is checked first, then the tuple with index 1, then index 2, and so on until all the rows
 * have been checked (or until a failure occurs). The function represents a property of the code under test
 * that should succeed for every row of the table. If the function returns normally, that indicates the property
 * check succeeded for that row. If the function completes abruptly with an exception, that indicates the
 * property check failed and the <code>apply</code> method will complete abruptly with a
 * <code>TableDrivenPropertyCheckFailedException</code> that wraps the exception thrown by the supplied property function.
 * </p>
 * 
 * <p>
 * The usual way you'd invoke the <code>apply</code> method that checks a property is via a <code>forAll</code> method
 * provided by trait <code>TableDrivenPropertyChecks</code>. The <code>forAll</code> method takes a <code>TableFor11</code> as its
 * first argument, then in a curried argument list takes the property check function. It invokes <code>apply</code> on
 * the <code>TableFor11</code>, passing in the property check function. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * forAll (examples) { (a, b, c, d, e, f, g, h, i, j, k) =>
 *   a + b + c + d + e + f + g + h + i + j + k should equal (a * 11)
 * }
 * </pre>
 *
 * <p>
 * Because <code>TableFor11</code> is a <code>Seq[(A, B, C, D, E, F, G, H, I, J, K)]</code>, you can use it as a <code>Seq</code>. For example, here's how
 * you could get a sequence of <a href="../Outcome.html"><code>Outcome</code></a>s for each row of the table, indicating whether a property check succeeded or failed
 * on each row of the table:
 * </p>
 *
 * <pre class="stHighlight">
 * for (row <- examples) yield {
 *   outcomeOf { row._1 should not equal (7) }
 * }
 * </pre>
 *
 * <p>
 * Note: the <code>outcomeOf</code> method, contained in the <code>OutcomeOf</code> trait, will execute the supplied code (a by-name parameter) and
 * transform it to an <code>Outcome</code>. If no exception is thrown by the code, <code>outcomeOf</code> will result in a
 * <a href="../Succeeded$.html"><code>Succeeded</code></a>, indicating the "property check"
 * succeeded. If the supplied code completes abruptly in an exception that would normally cause a test to fail, <code>outcomeOf</code> will result in
 * in a <a href="../Failed.html"><code>Failed</code></a> instance containing that exception. For example, the previous for expression would give you:
 * </p>
 *
 * <pre class="stHighlight">
 * Vector(Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded,
 *     Failed(org.scalatest.TestFailedException: 7 equaled 7), Succeeded, Succeeded)
 * </pre>
 *
 * <p>
 * This shows that all the property checks succeeded, except for the one at index 7.
 * </p>
 *
 * @param heading a tuple containing string names of the columns in this table
 * @param rows a variable length parameter list of <code>Tuple11</code>s containing the data of this table
 *
 * @author Bill Venners 
 */

class TableFor11[A, B, C, D, E, F, G, H, I, J, K](val heading: (String, String, String, String, String, String, String, String, String, String, String), rows: (A, B, C, D, E, F, G, H, I, J, K)*) extends IndexedSeq[(A, B, C, D, E, F, G, H, I, J, K)] with IndexedSeqLike[(A, B, C, D, E, F, G, H, I, J, K), TableFor11[A, B, C, D, E, F, G, H, I, J, K]] {

  /**
   * Selects a row of data by its index.
   */
  def apply(idx: Int): (A, B, C, D, E, F, G, H, I, J, K) = rows(idx)

  /**
   * The number of rows of data in the table. (This does not include the <code>heading</code> tuple)
   */
  def length: Int = rows.length

  /**
   * Creates a new <code>Builder</code> for <code>TableFor11</code>s.
   */
  override protected[this] def newBuilder: Builder[(A, B, C, D, E, F, G, H, I, J, K), TableFor11[A, B, C, D, E, F, G, H, I, J, K]] =
    new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K)]) =>
      new TableFor11(heading, buf: _*)
    }

  /**
   * Applies the passed property check function to each row of this <code>TableFor11</code>.
   *
   * <p>
   * If the property checks for all rows succeed (the property check function returns normally when passed
   * the data for each row), this <code>apply</code> method returns normally. If the property check function
   * completes abruptly with an exception for any row, this <code>apply</code> method wraps that exception
   * in a <code>TableDrivenPropertyCheckFailedException</code> and completes abruptly with that exception. Once
   * the property check function throws an exception for a row, this <code>apply</code> method will complete
   * abruptly immediately and subsequent rows will not be checked against the function.
   * </p>
   *
   * @param fun the property check function to apply to each row of this <code>TableFor11</code>
   */
  def apply(fun: (A, B, C, D, E, F, G, H, I, J, K) => Unit) {
    for (((a, b, c, d, e, f, g, h, i, j, k), idx) <- rows.zipWithIndex) {
      try {
        fun(a, b, c, d, e, f, g, h, i, j, k)
      }
      catch {
        case _: DiscardedEvaluationException => // discard this evaluation and move on to the next
        case ex: Throwable =>
          val (aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName) = heading

          throw new TableDrivenPropertyCheckFailedException(
            sde => FailureMessages("propertyException", UnquotedString(ex.getClass.getSimpleName)) + 
              ( sde.failedCodeFileNameAndLineNumberString match { case Some(s) => " (" + s + ")"; case None => "" }) + "\n" + 
              "  " + FailureMessages("thrownExceptionsMessage", if (ex.getMessage == null) "None" else UnquotedString(ex.getMessage)) + "\n" +
              (
                ex match {
                  case sd: StackDepth if sd.failedCodeFileNameAndLineNumberString.isDefined =>
                    "  " + FailureMessages("thrownExceptionsLocation", UnquotedString(sd.failedCodeFileNameAndLineNumberString.get)) + "\n"
                  case _ => ""
                }
              ) +
              "  " + FailureMessages("occurredAtRow", idx) + "\n" +
              "    " + aName + " = " + a + "," + "\n" +
              "    " + bName + " = " + b + "," + "\n" +
              "    " + cName + " = " + c + "," + "\n" +
              "    " + dName + " = " + d + "," + "\n" +
              "    " + eName + " = " + e + "," + "\n" +
              "    " + fName + " = " + f + "," + "\n" +
              "    " + gName + " = " + g + "," + "\n" +
              "    " + hName + " = " + h + "," + "\n" +
              "    " + iName + " = " + i + "," + "\n" +
              "    " + jName + " = " + j + "," + "\n" +
              "    " + kName + " = " + k + "\n" +

              "  )",
            Some(ex),
            getStackDepthFun("TableDrivenPropertyChecks.scala", "forAll", 2),
            FailureMessages("undecoratedPropertyCheckFailureMessage"),
            List(a, b, c, d, e, f, g, h, i, j, k),
            List(aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName),
            idx
          )
      }
    }
  }

  /**
   * A string representation of this object, which includes the heading strings as well as the rows of data.
   */
  override def toString: String = stringPrefix + "(" + heading.toString + ", " +  rows.mkString(", ") + ")"
}

/**
 * Companion object for class <code>TableFor11</code> that provides an implicit <code>canBuildFrom</code> method
 * that enables higher order functions defined on <code>TableFor11</code> to return another <code>TableFor11</code>.
 *
 * @author Bill Venners 
 */
object TableFor11 {

  /**
   * Implicit method enabling higher order functions of <code>TableFor11</code> to return sequences of type <code>TableFor11</code>.
   */
  implicit def canBuildFrom[A, B, C, D, E, F, G, H, I, J, K]: CanBuildFrom[TableFor11[A, B, C, D, E, F, G, H, I, J, K], (A, B, C, D, E, F, G, H, I, J, K), TableFor11[A, B, C, D, E, F, G, H, I, J, K]] =
    new CanBuildFrom[TableFor11[A, B, C, D, E, F, G, H, I, J, K], (A, B, C, D, E, F, G, H, I, J, K), TableFor11[A, B, C, D, E, F, G, H, I, J, K]] {
      def apply(): Builder[(A, B, C, D, E, F, G, H, I, J, K), TableFor11[A, B, C, D, E, F, G, H, I, J, K]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K)]) =>
          new TableFor11(("arg0","arg1","arg2","arg3","arg4","arg5","arg6","arg7","arg8","arg9","arg10"))
        }
      def apply(from: TableFor11[A, B, C, D, E, F, G, H, I, J, K]): Builder[(A, B, C, D, E, F, G, H, I, J, K), TableFor11[A, B, C, D, E, F, G, H, I, J, K]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K)]) =>
          new TableFor11(from.heading, buf: _*)
        }
    }
}

/**
 * A table with 12 columns.
 *
 * <p>
 * For an introduction to using tables, see the documentation for trait
 * <a href="TableDrivenPropertyChecks.html">TableDrivenPropertyChecks</a>.
 * </p>
 *
 * <p>
 * This table is a sequence of <code>Tuple12</code> objects, where each tuple represents one row of the table.
 * The first element of each tuple comprise the first column of the table, the second element of 
 * each tuple comprise the second column, and so on.  This table also carries with it
 * a <em>heading</em> tuple that gives string names to the columns of the table.
 * </p>
 *
 * <p>
 * A handy way to create a <code>TableFor12</code> is via an <code>apply</code> factory method in the <code>Table</code>
 * singleton object provided by the <code>Tables</code> trait. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * val examples =
 *   Table(
 *     ("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l"),
 *     (  0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0),
 *     (  1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1),
 *     (  2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2),
 *     (  3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3),
 *     (  4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4),
 *     (  5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5),
 *     (  6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6),
 *     (  7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7),
 *     (  8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8),
 *     (  9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9)
 *   )
 * </pre>
 *
 * <p>
 * Because you supplied 12 members in each tuple, the type you'll get back will be a <code>TableFor12</code>.
 * </p>
 *
 * <p>
 * The table provides an <code>apply</code> method that takes a function with a parameter list that matches
 * the types and arity of the tuples contained in this table. The <code>apply</code> method will invoke the
 * function with the members of each row tuple passed as arguments, in ascending order by index. (<em>I.e.</em>,
 * the zeroth tuple is checked first, then the tuple with index 1, then index 2, and so on until all the rows
 * have been checked (or until a failure occurs). The function represents a property of the code under test
 * that should succeed for every row of the table. If the function returns normally, that indicates the property
 * check succeeded for that row. If the function completes abruptly with an exception, that indicates the
 * property check failed and the <code>apply</code> method will complete abruptly with a
 * <code>TableDrivenPropertyCheckFailedException</code> that wraps the exception thrown by the supplied property function.
 * </p>
 * 
 * <p>
 * The usual way you'd invoke the <code>apply</code> method that checks a property is via a <code>forAll</code> method
 * provided by trait <code>TableDrivenPropertyChecks</code>. The <code>forAll</code> method takes a <code>TableFor12</code> as its
 * first argument, then in a curried argument list takes the property check function. It invokes <code>apply</code> on
 * the <code>TableFor12</code>, passing in the property check function. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * forAll (examples) { (a, b, c, d, e, f, g, h, i, j, k, l) =>
 *   a + b + c + d + e + f + g + h + i + j + k + l should equal (a * 12)
 * }
 * </pre>
 *
 * <p>
 * Because <code>TableFor12</code> is a <code>Seq[(A, B, C, D, E, F, G, H, I, J, K, L)]</code>, you can use it as a <code>Seq</code>. For example, here's how
 * you could get a sequence of <a href="../Outcome.html"><code>Outcome</code></a>s for each row of the table, indicating whether a property check succeeded or failed
 * on each row of the table:
 * </p>
 *
 * <pre class="stHighlight">
 * for (row <- examples) yield {
 *   outcomeOf { row._1 should not equal (7) }
 * }
 * </pre>
 *
 * <p>
 * Note: the <code>outcomeOf</code> method, contained in the <code>OutcomeOf</code> trait, will execute the supplied code (a by-name parameter) and
 * transform it to an <code>Outcome</code>. If no exception is thrown by the code, <code>outcomeOf</code> will result in a
 * <a href="../Succeeded$.html"><code>Succeeded</code></a>, indicating the "property check"
 * succeeded. If the supplied code completes abruptly in an exception that would normally cause a test to fail, <code>outcomeOf</code> will result in
 * in a <a href="../Failed.html"><code>Failed</code></a> instance containing that exception. For example, the previous for expression would give you:
 * </p>
 *
 * <pre class="stHighlight">
 * Vector(Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded,
 *     Failed(org.scalatest.TestFailedException: 7 equaled 7), Succeeded, Succeeded)
 * </pre>
 *
 * <p>
 * This shows that all the property checks succeeded, except for the one at index 7.
 * </p>
 *
 * @param heading a tuple containing string names of the columns in this table
 * @param rows a variable length parameter list of <code>Tuple12</code>s containing the data of this table
 *
 * @author Bill Venners 
 */

class TableFor12[A, B, C, D, E, F, G, H, I, J, K, L](val heading: (String, String, String, String, String, String, String, String, String, String, String, String), rows: (A, B, C, D, E, F, G, H, I, J, K, L)*) extends IndexedSeq[(A, B, C, D, E, F, G, H, I, J, K, L)] with IndexedSeqLike[(A, B, C, D, E, F, G, H, I, J, K, L), TableFor12[A, B, C, D, E, F, G, H, I, J, K, L]] {

  /**
   * Selects a row of data by its index.
   */
  def apply(idx: Int): (A, B, C, D, E, F, G, H, I, J, K, L) = rows(idx)

  /**
   * The number of rows of data in the table. (This does not include the <code>heading</code> tuple)
   */
  def length: Int = rows.length

  /**
   * Creates a new <code>Builder</code> for <code>TableFor12</code>s.
   */
  override protected[this] def newBuilder: Builder[(A, B, C, D, E, F, G, H, I, J, K, L), TableFor12[A, B, C, D, E, F, G, H, I, J, K, L]] =
    new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L)]) =>
      new TableFor12(heading, buf: _*)
    }

  /**
   * Applies the passed property check function to each row of this <code>TableFor12</code>.
   *
   * <p>
   * If the property checks for all rows succeed (the property check function returns normally when passed
   * the data for each row), this <code>apply</code> method returns normally. If the property check function
   * completes abruptly with an exception for any row, this <code>apply</code> method wraps that exception
   * in a <code>TableDrivenPropertyCheckFailedException</code> and completes abruptly with that exception. Once
   * the property check function throws an exception for a row, this <code>apply</code> method will complete
   * abruptly immediately and subsequent rows will not be checked against the function.
   * </p>
   *
   * @param fun the property check function to apply to each row of this <code>TableFor12</code>
   */
  def apply(fun: (A, B, C, D, E, F, G, H, I, J, K, L) => Unit) {
    for (((a, b, c, d, e, f, g, h, i, j, k, l), idx) <- rows.zipWithIndex) {
      try {
        fun(a, b, c, d, e, f, g, h, i, j, k, l)
      }
      catch {
        case _: DiscardedEvaluationException => // discard this evaluation and move on to the next
        case ex: Throwable =>
          val (aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName, lName) = heading

          throw new TableDrivenPropertyCheckFailedException(
            sde => FailureMessages("propertyException", UnquotedString(ex.getClass.getSimpleName)) + 
              ( sde.failedCodeFileNameAndLineNumberString match { case Some(s) => " (" + s + ")"; case None => "" }) + "\n" + 
              "  " + FailureMessages("thrownExceptionsMessage", if (ex.getMessage == null) "None" else UnquotedString(ex.getMessage)) + "\n" +
              (
                ex match {
                  case sd: StackDepth if sd.failedCodeFileNameAndLineNumberString.isDefined =>
                    "  " + FailureMessages("thrownExceptionsLocation", UnquotedString(sd.failedCodeFileNameAndLineNumberString.get)) + "\n"
                  case _ => ""
                }
              ) +
              "  " + FailureMessages("occurredAtRow", idx) + "\n" +
              "    " + aName + " = " + a + "," + "\n" +
              "    " + bName + " = " + b + "," + "\n" +
              "    " + cName + " = " + c + "," + "\n" +
              "    " + dName + " = " + d + "," + "\n" +
              "    " + eName + " = " + e + "," + "\n" +
              "    " + fName + " = " + f + "," + "\n" +
              "    " + gName + " = " + g + "," + "\n" +
              "    " + hName + " = " + h + "," + "\n" +
              "    " + iName + " = " + i + "," + "\n" +
              "    " + jName + " = " + j + "," + "\n" +
              "    " + kName + " = " + k + "," + "\n" +
              "    " + lName + " = " + l + "\n" +

              "  )",
            Some(ex),
            getStackDepthFun("TableDrivenPropertyChecks.scala", "forAll", 2),
            FailureMessages("undecoratedPropertyCheckFailureMessage"),
            List(a, b, c, d, e, f, g, h, i, j, k, l),
            List(aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName, lName),
            idx
          )
      }
    }
  }

  /**
   * A string representation of this object, which includes the heading strings as well as the rows of data.
   */
  override def toString: String = stringPrefix + "(" + heading.toString + ", " +  rows.mkString(", ") + ")"
}

/**
 * Companion object for class <code>TableFor12</code> that provides an implicit <code>canBuildFrom</code> method
 * that enables higher order functions defined on <code>TableFor12</code> to return another <code>TableFor12</code>.
 *
 * @author Bill Venners 
 */
object TableFor12 {

  /**
   * Implicit method enabling higher order functions of <code>TableFor12</code> to return sequences of type <code>TableFor12</code>.
   */
  implicit def canBuildFrom[A, B, C, D, E, F, G, H, I, J, K, L]: CanBuildFrom[TableFor12[A, B, C, D, E, F, G, H, I, J, K, L], (A, B, C, D, E, F, G, H, I, J, K, L), TableFor12[A, B, C, D, E, F, G, H, I, J, K, L]] =
    new CanBuildFrom[TableFor12[A, B, C, D, E, F, G, H, I, J, K, L], (A, B, C, D, E, F, G, H, I, J, K, L), TableFor12[A, B, C, D, E, F, G, H, I, J, K, L]] {
      def apply(): Builder[(A, B, C, D, E, F, G, H, I, J, K, L), TableFor12[A, B, C, D, E, F, G, H, I, J, K, L]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L)]) =>
          new TableFor12(("arg0","arg1","arg2","arg3","arg4","arg5","arg6","arg7","arg8","arg9","arg10","arg11"))
        }
      def apply(from: TableFor12[A, B, C, D, E, F, G, H, I, J, K, L]): Builder[(A, B, C, D, E, F, G, H, I, J, K, L), TableFor12[A, B, C, D, E, F, G, H, I, J, K, L]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L)]) =>
          new TableFor12(from.heading, buf: _*)
        }
    }
}

/**
 * A table with 13 columns.
 *
 * <p>
 * For an introduction to using tables, see the documentation for trait
 * <a href="TableDrivenPropertyChecks.html">TableDrivenPropertyChecks</a>.
 * </p>
 *
 * <p>
 * This table is a sequence of <code>Tuple13</code> objects, where each tuple represents one row of the table.
 * The first element of each tuple comprise the first column of the table, the second element of 
 * each tuple comprise the second column, and so on.  This table also carries with it
 * a <em>heading</em> tuple that gives string names to the columns of the table.
 * </p>
 *
 * <p>
 * A handy way to create a <code>TableFor13</code> is via an <code>apply</code> factory method in the <code>Table</code>
 * singleton object provided by the <code>Tables</code> trait. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * val examples =
 *   Table(
 *     ("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m"),
 *     (  0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0),
 *     (  1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1),
 *     (  2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2),
 *     (  3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3),
 *     (  4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4),
 *     (  5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5),
 *     (  6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6),
 *     (  7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7),
 *     (  8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8),
 *     (  9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9)
 *   )
 * </pre>
 *
 * <p>
 * Because you supplied 13 members in each tuple, the type you'll get back will be a <code>TableFor13</code>.
 * </p>
 *
 * <p>
 * The table provides an <code>apply</code> method that takes a function with a parameter list that matches
 * the types and arity of the tuples contained in this table. The <code>apply</code> method will invoke the
 * function with the members of each row tuple passed as arguments, in ascending order by index. (<em>I.e.</em>,
 * the zeroth tuple is checked first, then the tuple with index 1, then index 2, and so on until all the rows
 * have been checked (or until a failure occurs). The function represents a property of the code under test
 * that should succeed for every row of the table. If the function returns normally, that indicates the property
 * check succeeded for that row. If the function completes abruptly with an exception, that indicates the
 * property check failed and the <code>apply</code> method will complete abruptly with a
 * <code>TableDrivenPropertyCheckFailedException</code> that wraps the exception thrown by the supplied property function.
 * </p>
 * 
 * <p>
 * The usual way you'd invoke the <code>apply</code> method that checks a property is via a <code>forAll</code> method
 * provided by trait <code>TableDrivenPropertyChecks</code>. The <code>forAll</code> method takes a <code>TableFor13</code> as its
 * first argument, then in a curried argument list takes the property check function. It invokes <code>apply</code> on
 * the <code>TableFor13</code>, passing in the property check function. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * forAll (examples) { (a, b, c, d, e, f, g, h, i, j, k, l, m) =>
 *   a + b + c + d + e + f + g + h + i + j + k + l + m should equal (a * 13)
 * }
 * </pre>
 *
 * <p>
 * Because <code>TableFor13</code> is a <code>Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M)]</code>, you can use it as a <code>Seq</code>. For example, here's how
 * you could get a sequence of <a href="../Outcome.html"><code>Outcome</code></a>s for each row of the table, indicating whether a property check succeeded or failed
 * on each row of the table:
 * </p>
 *
 * <pre class="stHighlight">
 * for (row <- examples) yield {
 *   outcomeOf { row._1 should not equal (7) }
 * }
 * </pre>
 *
 * <p>
 * Note: the <code>outcomeOf</code> method, contained in the <code>OutcomeOf</code> trait, will execute the supplied code (a by-name parameter) and
 * transform it to an <code>Outcome</code>. If no exception is thrown by the code, <code>outcomeOf</code> will result in a
 * <a href="../Succeeded$.html"><code>Succeeded</code></a>, indicating the "property check"
 * succeeded. If the supplied code completes abruptly in an exception that would normally cause a test to fail, <code>outcomeOf</code> will result in
 * in a <a href="../Failed.html"><code>Failed</code></a> instance containing that exception. For example, the previous for expression would give you:
 * </p>
 *
 * <pre class="stHighlight">
 * Vector(Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded,
 *     Failed(org.scalatest.TestFailedException: 7 equaled 7), Succeeded, Succeeded)
 * </pre>
 *
 * <p>
 * This shows that all the property checks succeeded, except for the one at index 7.
 * </p>
 *
 * @param heading a tuple containing string names of the columns in this table
 * @param rows a variable length parameter list of <code>Tuple13</code>s containing the data of this table
 *
 * @author Bill Venners 
 */

class TableFor13[A, B, C, D, E, F, G, H, I, J, K, L, M](val heading: (String, String, String, String, String, String, String, String, String, String, String, String, String), rows: (A, B, C, D, E, F, G, H, I, J, K, L, M)*) extends IndexedSeq[(A, B, C, D, E, F, G, H, I, J, K, L, M)] with IndexedSeqLike[(A, B, C, D, E, F, G, H, I, J, K, L, M), TableFor13[A, B, C, D, E, F, G, H, I, J, K, L, M]] {

  /**
   * Selects a row of data by its index.
   */
  def apply(idx: Int): (A, B, C, D, E, F, G, H, I, J, K, L, M) = rows(idx)

  /**
   * The number of rows of data in the table. (This does not include the <code>heading</code> tuple)
   */
  def length: Int = rows.length

  /**
   * Creates a new <code>Builder</code> for <code>TableFor13</code>s.
   */
  override protected[this] def newBuilder: Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M), TableFor13[A, B, C, D, E, F, G, H, I, J, K, L, M]] =
    new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M)]) =>
      new TableFor13(heading, buf: _*)
    }

  /**
   * Applies the passed property check function to each row of this <code>TableFor13</code>.
   *
   * <p>
   * If the property checks for all rows succeed (the property check function returns normally when passed
   * the data for each row), this <code>apply</code> method returns normally. If the property check function
   * completes abruptly with an exception for any row, this <code>apply</code> method wraps that exception
   * in a <code>TableDrivenPropertyCheckFailedException</code> and completes abruptly with that exception. Once
   * the property check function throws an exception for a row, this <code>apply</code> method will complete
   * abruptly immediately and subsequent rows will not be checked against the function.
   * </p>
   *
   * @param fun the property check function to apply to each row of this <code>TableFor13</code>
   */
  def apply(fun: (A, B, C, D, E, F, G, H, I, J, K, L, M) => Unit) {
    for (((a, b, c, d, e, f, g, h, i, j, k, l, m), idx) <- rows.zipWithIndex) {
      try {
        fun(a, b, c, d, e, f, g, h, i, j, k, l, m)
      }
      catch {
        case _: DiscardedEvaluationException => // discard this evaluation and move on to the next
        case ex: Throwable =>
          val (aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName, lName, mName) = heading

          throw new TableDrivenPropertyCheckFailedException(
            sde => FailureMessages("propertyException", UnquotedString(ex.getClass.getSimpleName)) + 
              ( sde.failedCodeFileNameAndLineNumberString match { case Some(s) => " (" + s + ")"; case None => "" }) + "\n" + 
              "  " + FailureMessages("thrownExceptionsMessage", if (ex.getMessage == null) "None" else UnquotedString(ex.getMessage)) + "\n" +
              (
                ex match {
                  case sd: StackDepth if sd.failedCodeFileNameAndLineNumberString.isDefined =>
                    "  " + FailureMessages("thrownExceptionsLocation", UnquotedString(sd.failedCodeFileNameAndLineNumberString.get)) + "\n"
                  case _ => ""
                }
              ) +
              "  " + FailureMessages("occurredAtRow", idx) + "\n" +
              "    " + aName + " = " + a + "," + "\n" +
              "    " + bName + " = " + b + "," + "\n" +
              "    " + cName + " = " + c + "," + "\n" +
              "    " + dName + " = " + d + "," + "\n" +
              "    " + eName + " = " + e + "," + "\n" +
              "    " + fName + " = " + f + "," + "\n" +
              "    " + gName + " = " + g + "," + "\n" +
              "    " + hName + " = " + h + "," + "\n" +
              "    " + iName + " = " + i + "," + "\n" +
              "    " + jName + " = " + j + "," + "\n" +
              "    " + kName + " = " + k + "," + "\n" +
              "    " + lName + " = " + l + "," + "\n" +
              "    " + mName + " = " + m + "\n" +

              "  )",
            Some(ex),
            getStackDepthFun("TableDrivenPropertyChecks.scala", "forAll", 2),
            FailureMessages("undecoratedPropertyCheckFailureMessage"),
            List(a, b, c, d, e, f, g, h, i, j, k, l, m),
            List(aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName, lName, mName),
            idx
          )
      }
    }
  }

  /**
   * A string representation of this object, which includes the heading strings as well as the rows of data.
   */
  override def toString: String = stringPrefix + "(" + heading.toString + ", " +  rows.mkString(", ") + ")"
}

/**
 * Companion object for class <code>TableFor13</code> that provides an implicit <code>canBuildFrom</code> method
 * that enables higher order functions defined on <code>TableFor13</code> to return another <code>TableFor13</code>.
 *
 * @author Bill Venners 
 */
object TableFor13 {

  /**
   * Implicit method enabling higher order functions of <code>TableFor13</code> to return sequences of type <code>TableFor13</code>.
   */
  implicit def canBuildFrom[A, B, C, D, E, F, G, H, I, J, K, L, M]: CanBuildFrom[TableFor13[A, B, C, D, E, F, G, H, I, J, K, L, M], (A, B, C, D, E, F, G, H, I, J, K, L, M), TableFor13[A, B, C, D, E, F, G, H, I, J, K, L, M]] =
    new CanBuildFrom[TableFor13[A, B, C, D, E, F, G, H, I, J, K, L, M], (A, B, C, D, E, F, G, H, I, J, K, L, M), TableFor13[A, B, C, D, E, F, G, H, I, J, K, L, M]] {
      def apply(): Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M), TableFor13[A, B, C, D, E, F, G, H, I, J, K, L, M]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M)]) =>
          new TableFor13(("arg0","arg1","arg2","arg3","arg4","arg5","arg6","arg7","arg8","arg9","arg10","arg11","arg12"))
        }
      def apply(from: TableFor13[A, B, C, D, E, F, G, H, I, J, K, L, M]): Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M), TableFor13[A, B, C, D, E, F, G, H, I, J, K, L, M]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M)]) =>
          new TableFor13(from.heading, buf: _*)
        }
    }
}

/**
 * A table with 14 columns.
 *
 * <p>
 * For an introduction to using tables, see the documentation for trait
 * <a href="TableDrivenPropertyChecks.html">TableDrivenPropertyChecks</a>.
 * </p>
 *
 * <p>
 * This table is a sequence of <code>Tuple14</code> objects, where each tuple represents one row of the table.
 * The first element of each tuple comprise the first column of the table, the second element of 
 * each tuple comprise the second column, and so on.  This table also carries with it
 * a <em>heading</em> tuple that gives string names to the columns of the table.
 * </p>
 *
 * <p>
 * A handy way to create a <code>TableFor14</code> is via an <code>apply</code> factory method in the <code>Table</code>
 * singleton object provided by the <code>Tables</code> trait. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * val examples =
 *   Table(
 *     ("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n"),
 *     (  0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0),
 *     (  1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1),
 *     (  2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2),
 *     (  3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3),
 *     (  4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4),
 *     (  5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5),
 *     (  6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6),
 *     (  7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7),
 *     (  8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8),
 *     (  9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9)
 *   )
 * </pre>
 *
 * <p>
 * Because you supplied 14 members in each tuple, the type you'll get back will be a <code>TableFor14</code>.
 * </p>
 *
 * <p>
 * The table provides an <code>apply</code> method that takes a function with a parameter list that matches
 * the types and arity of the tuples contained in this table. The <code>apply</code> method will invoke the
 * function with the members of each row tuple passed as arguments, in ascending order by index. (<em>I.e.</em>,
 * the zeroth tuple is checked first, then the tuple with index 1, then index 2, and so on until all the rows
 * have been checked (or until a failure occurs). The function represents a property of the code under test
 * that should succeed for every row of the table. If the function returns normally, that indicates the property
 * check succeeded for that row. If the function completes abruptly with an exception, that indicates the
 * property check failed and the <code>apply</code> method will complete abruptly with a
 * <code>TableDrivenPropertyCheckFailedException</code> that wraps the exception thrown by the supplied property function.
 * </p>
 * 
 * <p>
 * The usual way you'd invoke the <code>apply</code> method that checks a property is via a <code>forAll</code> method
 * provided by trait <code>TableDrivenPropertyChecks</code>. The <code>forAll</code> method takes a <code>TableFor14</code> as its
 * first argument, then in a curried argument list takes the property check function. It invokes <code>apply</code> on
 * the <code>TableFor14</code>, passing in the property check function. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * forAll (examples) { (a, b, c, d, e, f, g, h, i, j, k, l, m, n) =>
 *   a + b + c + d + e + f + g + h + i + j + k + l + m + n should equal (a * 14)
 * }
 * </pre>
 *
 * <p>
 * Because <code>TableFor14</code> is a <code>Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N)]</code>, you can use it as a <code>Seq</code>. For example, here's how
 * you could get a sequence of <a href="../Outcome.html"><code>Outcome</code></a>s for each row of the table, indicating whether a property check succeeded or failed
 * on each row of the table:
 * </p>
 *
 * <pre class="stHighlight">
 * for (row <- examples) yield {
 *   outcomeOf { row._1 should not equal (7) }
 * }
 * </pre>
 *
 * <p>
 * Note: the <code>outcomeOf</code> method, contained in the <code>OutcomeOf</code> trait, will execute the supplied code (a by-name parameter) and
 * transform it to an <code>Outcome</code>. If no exception is thrown by the code, <code>outcomeOf</code> will result in a
 * <a href="../Succeeded$.html"><code>Succeeded</code></a>, indicating the "property check"
 * succeeded. If the supplied code completes abruptly in an exception that would normally cause a test to fail, <code>outcomeOf</code> will result in
 * in a <a href="../Failed.html"><code>Failed</code></a> instance containing that exception. For example, the previous for expression would give you:
 * </p>
 *
 * <pre class="stHighlight">
 * Vector(Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded,
 *     Failed(org.scalatest.TestFailedException: 7 equaled 7), Succeeded, Succeeded)
 * </pre>
 *
 * <p>
 * This shows that all the property checks succeeded, except for the one at index 7.
 * </p>
 *
 * @param heading a tuple containing string names of the columns in this table
 * @param rows a variable length parameter list of <code>Tuple14</code>s containing the data of this table
 *
 * @author Bill Venners 
 */

class TableFor14[A, B, C, D, E, F, G, H, I, J, K, L, M, N](val heading: (String, String, String, String, String, String, String, String, String, String, String, String, String, String), rows: (A, B, C, D, E, F, G, H, I, J, K, L, M, N)*) extends IndexedSeq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N)] with IndexedSeqLike[(A, B, C, D, E, F, G, H, I, J, K, L, M, N), TableFor14[A, B, C, D, E, F, G, H, I, J, K, L, M, N]] {

  /**
   * Selects a row of data by its index.
   */
  def apply(idx: Int): (A, B, C, D, E, F, G, H, I, J, K, L, M, N) = rows(idx)

  /**
   * The number of rows of data in the table. (This does not include the <code>heading</code> tuple)
   */
  def length: Int = rows.length

  /**
   * Creates a new <code>Builder</code> for <code>TableFor14</code>s.
   */
  override protected[this] def newBuilder: Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N), TableFor14[A, B, C, D, E, F, G, H, I, J, K, L, M, N]] =
    new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N)]) =>
      new TableFor14(heading, buf: _*)
    }

  /**
   * Applies the passed property check function to each row of this <code>TableFor14</code>.
   *
   * <p>
   * If the property checks for all rows succeed (the property check function returns normally when passed
   * the data for each row), this <code>apply</code> method returns normally. If the property check function
   * completes abruptly with an exception for any row, this <code>apply</code> method wraps that exception
   * in a <code>TableDrivenPropertyCheckFailedException</code> and completes abruptly with that exception. Once
   * the property check function throws an exception for a row, this <code>apply</code> method will complete
   * abruptly immediately and subsequent rows will not be checked against the function.
   * </p>
   *
   * @param fun the property check function to apply to each row of this <code>TableFor14</code>
   */
  def apply(fun: (A, B, C, D, E, F, G, H, I, J, K, L, M, N) => Unit) {
    for (((a, b, c, d, e, f, g, h, i, j, k, l, m, n), idx) <- rows.zipWithIndex) {
      try {
        fun(a, b, c, d, e, f, g, h, i, j, k, l, m, n)
      }
      catch {
        case _: DiscardedEvaluationException => // discard this evaluation and move on to the next
        case ex: Throwable =>
          val (aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName, lName, mName, nName) = heading

          throw new TableDrivenPropertyCheckFailedException(
            sde => FailureMessages("propertyException", UnquotedString(ex.getClass.getSimpleName)) + 
              ( sde.failedCodeFileNameAndLineNumberString match { case Some(s) => " (" + s + ")"; case None => "" }) + "\n" + 
              "  " + FailureMessages("thrownExceptionsMessage", if (ex.getMessage == null) "None" else UnquotedString(ex.getMessage)) + "\n" +
              (
                ex match {
                  case sd: StackDepth if sd.failedCodeFileNameAndLineNumberString.isDefined =>
                    "  " + FailureMessages("thrownExceptionsLocation", UnquotedString(sd.failedCodeFileNameAndLineNumberString.get)) + "\n"
                  case _ => ""
                }
              ) +
              "  " + FailureMessages("occurredAtRow", idx) + "\n" +
              "    " + aName + " = " + a + "," + "\n" +
              "    " + bName + " = " + b + "," + "\n" +
              "    " + cName + " = " + c + "," + "\n" +
              "    " + dName + " = " + d + "," + "\n" +
              "    " + eName + " = " + e + "," + "\n" +
              "    " + fName + " = " + f + "," + "\n" +
              "    " + gName + " = " + g + "," + "\n" +
              "    " + hName + " = " + h + "," + "\n" +
              "    " + iName + " = " + i + "," + "\n" +
              "    " + jName + " = " + j + "," + "\n" +
              "    " + kName + " = " + k + "," + "\n" +
              "    " + lName + " = " + l + "," + "\n" +
              "    " + mName + " = " + m + "," + "\n" +
              "    " + nName + " = " + n + "\n" +

              "  )",
            Some(ex),
            getStackDepthFun("TableDrivenPropertyChecks.scala", "forAll", 2),
            FailureMessages("undecoratedPropertyCheckFailureMessage"),
            List(a, b, c, d, e, f, g, h, i, j, k, l, m, n),
            List(aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName, lName, mName, nName),
            idx
          )
      }
    }
  }

  /**
   * A string representation of this object, which includes the heading strings as well as the rows of data.
   */
  override def toString: String = stringPrefix + "(" + heading.toString + ", " +  rows.mkString(", ") + ")"
}

/**
 * Companion object for class <code>TableFor14</code> that provides an implicit <code>canBuildFrom</code> method
 * that enables higher order functions defined on <code>TableFor14</code> to return another <code>TableFor14</code>.
 *
 * @author Bill Venners 
 */
object TableFor14 {

  /**
   * Implicit method enabling higher order functions of <code>TableFor14</code> to return sequences of type <code>TableFor14</code>.
   */
  implicit def canBuildFrom[A, B, C, D, E, F, G, H, I, J, K, L, M, N]: CanBuildFrom[TableFor14[A, B, C, D, E, F, G, H, I, J, K, L, M, N], (A, B, C, D, E, F, G, H, I, J, K, L, M, N), TableFor14[A, B, C, D, E, F, G, H, I, J, K, L, M, N]] =
    new CanBuildFrom[TableFor14[A, B, C, D, E, F, G, H, I, J, K, L, M, N], (A, B, C, D, E, F, G, H, I, J, K, L, M, N), TableFor14[A, B, C, D, E, F, G, H, I, J, K, L, M, N]] {
      def apply(): Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N), TableFor14[A, B, C, D, E, F, G, H, I, J, K, L, M, N]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N)]) =>
          new TableFor14(("arg0","arg1","arg2","arg3","arg4","arg5","arg6","arg7","arg8","arg9","arg10","arg11","arg12","arg13"))
        }
      def apply(from: TableFor14[A, B, C, D, E, F, G, H, I, J, K, L, M, N]): Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N), TableFor14[A, B, C, D, E, F, G, H, I, J, K, L, M, N]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N)]) =>
          new TableFor14(from.heading, buf: _*)
        }
    }
}

/**
 * A table with 15 columns.
 *
 * <p>
 * For an introduction to using tables, see the documentation for trait
 * <a href="TableDrivenPropertyChecks.html">TableDrivenPropertyChecks</a>.
 * </p>
 *
 * <p>
 * This table is a sequence of <code>Tuple15</code> objects, where each tuple represents one row of the table.
 * The first element of each tuple comprise the first column of the table, the second element of 
 * each tuple comprise the second column, and so on.  This table also carries with it
 * a <em>heading</em> tuple that gives string names to the columns of the table.
 * </p>
 *
 * <p>
 * A handy way to create a <code>TableFor15</code> is via an <code>apply</code> factory method in the <code>Table</code>
 * singleton object provided by the <code>Tables</code> trait. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * val examples =
 *   Table(
 *     ("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o"),
 *     (  0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0),
 *     (  1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1),
 *     (  2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2),
 *     (  3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3),
 *     (  4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4),
 *     (  5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5),
 *     (  6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6),
 *     (  7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7),
 *     (  8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8),
 *     (  9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9)
 *   )
 * </pre>
 *
 * <p>
 * Because you supplied 15 members in each tuple, the type you'll get back will be a <code>TableFor15</code>.
 * </p>
 *
 * <p>
 * The table provides an <code>apply</code> method that takes a function with a parameter list that matches
 * the types and arity of the tuples contained in this table. The <code>apply</code> method will invoke the
 * function with the members of each row tuple passed as arguments, in ascending order by index. (<em>I.e.</em>,
 * the zeroth tuple is checked first, then the tuple with index 1, then index 2, and so on until all the rows
 * have been checked (or until a failure occurs). The function represents a property of the code under test
 * that should succeed for every row of the table. If the function returns normally, that indicates the property
 * check succeeded for that row. If the function completes abruptly with an exception, that indicates the
 * property check failed and the <code>apply</code> method will complete abruptly with a
 * <code>TableDrivenPropertyCheckFailedException</code> that wraps the exception thrown by the supplied property function.
 * </p>
 * 
 * <p>
 * The usual way you'd invoke the <code>apply</code> method that checks a property is via a <code>forAll</code> method
 * provided by trait <code>TableDrivenPropertyChecks</code>. The <code>forAll</code> method takes a <code>TableFor15</code> as its
 * first argument, then in a curried argument list takes the property check function. It invokes <code>apply</code> on
 * the <code>TableFor15</code>, passing in the property check function. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * forAll (examples) { (a, b, c, d, e, f, g, h, i, j, k, l, m, n, o) =>
 *   a + b + c + d + e + f + g + h + i + j + k + l + m + n + o should equal (a * 15)
 * }
 * </pre>
 *
 * <p>
 * Because <code>TableFor15</code> is a <code>Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O)]</code>, you can use it as a <code>Seq</code>. For example, here's how
 * you could get a sequence of <a href="../Outcome.html"><code>Outcome</code></a>s for each row of the table, indicating whether a property check succeeded or failed
 * on each row of the table:
 * </p>
 *
 * <pre class="stHighlight">
 * for (row <- examples) yield {
 *   outcomeOf { row._1 should not equal (7) }
 * }
 * </pre>
 *
 * <p>
 * Note: the <code>outcomeOf</code> method, contained in the <code>OutcomeOf</code> trait, will execute the supplied code (a by-name parameter) and
 * transform it to an <code>Outcome</code>. If no exception is thrown by the code, <code>outcomeOf</code> will result in a
 * <a href="../Succeeded$.html"><code>Succeeded</code></a>, indicating the "property check"
 * succeeded. If the supplied code completes abruptly in an exception that would normally cause a test to fail, <code>outcomeOf</code> will result in
 * in a <a href="../Failed.html"><code>Failed</code></a> instance containing that exception. For example, the previous for expression would give you:
 * </p>
 *
 * <pre class="stHighlight">
 * Vector(Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded,
 *     Failed(org.scalatest.TestFailedException: 7 equaled 7), Succeeded, Succeeded)
 * </pre>
 *
 * <p>
 * This shows that all the property checks succeeded, except for the one at index 7.
 * </p>
 *
 * @param heading a tuple containing string names of the columns in this table
 * @param rows a variable length parameter list of <code>Tuple15</code>s containing the data of this table
 *
 * @author Bill Venners 
 */

class TableFor15[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O](val heading: (String, String, String, String, String, String, String, String, String, String, String, String, String, String, String), rows: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O)*) extends IndexedSeq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O)] with IndexedSeqLike[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O), TableFor15[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O]] {

  /**
   * Selects a row of data by its index.
   */
  def apply(idx: Int): (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O) = rows(idx)

  /**
   * The number of rows of data in the table. (This does not include the <code>heading</code> tuple)
   */
  def length: Int = rows.length

  /**
   * Creates a new <code>Builder</code> for <code>TableFor15</code>s.
   */
  override protected[this] def newBuilder: Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O), TableFor15[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O]] =
    new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O)]) =>
      new TableFor15(heading, buf: _*)
    }

  /**
   * Applies the passed property check function to each row of this <code>TableFor15</code>.
   *
   * <p>
   * If the property checks for all rows succeed (the property check function returns normally when passed
   * the data for each row), this <code>apply</code> method returns normally. If the property check function
   * completes abruptly with an exception for any row, this <code>apply</code> method wraps that exception
   * in a <code>TableDrivenPropertyCheckFailedException</code> and completes abruptly with that exception. Once
   * the property check function throws an exception for a row, this <code>apply</code> method will complete
   * abruptly immediately and subsequent rows will not be checked against the function.
   * </p>
   *
   * @param fun the property check function to apply to each row of this <code>TableFor15</code>
   */
  def apply(fun: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O) => Unit) {
    for (((a, b, c, d, e, f, g, h, i, j, k, l, m, n, o), idx) <- rows.zipWithIndex) {
      try {
        fun(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o)
      }
      catch {
        case _: DiscardedEvaluationException => // discard this evaluation and move on to the next
        case ex: Throwable =>
          val (aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName, lName, mName, nName, oName) = heading

          throw new TableDrivenPropertyCheckFailedException(
            sde => FailureMessages("propertyException", UnquotedString(ex.getClass.getSimpleName)) + 
              ( sde.failedCodeFileNameAndLineNumberString match { case Some(s) => " (" + s + ")"; case None => "" }) + "\n" + 
              "  " + FailureMessages("thrownExceptionsMessage", if (ex.getMessage == null) "None" else UnquotedString(ex.getMessage)) + "\n" +
              (
                ex match {
                  case sd: StackDepth if sd.failedCodeFileNameAndLineNumberString.isDefined =>
                    "  " + FailureMessages("thrownExceptionsLocation", UnquotedString(sd.failedCodeFileNameAndLineNumberString.get)) + "\n"
                  case _ => ""
                }
              ) +
              "  " + FailureMessages("occurredAtRow", idx) + "\n" +
              "    " + aName + " = " + a + "," + "\n" +
              "    " + bName + " = " + b + "," + "\n" +
              "    " + cName + " = " + c + "," + "\n" +
              "    " + dName + " = " + d + "," + "\n" +
              "    " + eName + " = " + e + "," + "\n" +
              "    " + fName + " = " + f + "," + "\n" +
              "    " + gName + " = " + g + "," + "\n" +
              "    " + hName + " = " + h + "," + "\n" +
              "    " + iName + " = " + i + "," + "\n" +
              "    " + jName + " = " + j + "," + "\n" +
              "    " + kName + " = " + k + "," + "\n" +
              "    " + lName + " = " + l + "," + "\n" +
              "    " + mName + " = " + m + "," + "\n" +
              "    " + nName + " = " + n + "," + "\n" +
              "    " + oName + " = " + o + "\n" +

              "  )",
            Some(ex),
            getStackDepthFun("TableDrivenPropertyChecks.scala", "forAll", 2),
            FailureMessages("undecoratedPropertyCheckFailureMessage"),
            List(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o),
            List(aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName, lName, mName, nName, oName),
            idx
          )
      }
    }
  }

  /**
   * A string representation of this object, which includes the heading strings as well as the rows of data.
   */
  override def toString: String = stringPrefix + "(" + heading.toString + ", " +  rows.mkString(", ") + ")"
}

/**
 * Companion object for class <code>TableFor15</code> that provides an implicit <code>canBuildFrom</code> method
 * that enables higher order functions defined on <code>TableFor15</code> to return another <code>TableFor15</code>.
 *
 * @author Bill Venners 
 */
object TableFor15 {

  /**
   * Implicit method enabling higher order functions of <code>TableFor15</code> to return sequences of type <code>TableFor15</code>.
   */
  implicit def canBuildFrom[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O]: CanBuildFrom[TableFor15[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O], (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O), TableFor15[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O]] =
    new CanBuildFrom[TableFor15[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O], (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O), TableFor15[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O]] {
      def apply(): Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O), TableFor15[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O)]) =>
          new TableFor15(("arg0","arg1","arg2","arg3","arg4","arg5","arg6","arg7","arg8","arg9","arg10","arg11","arg12","arg13","arg14"))
        }
      def apply(from: TableFor15[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O]): Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O), TableFor15[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O)]) =>
          new TableFor15(from.heading, buf: _*)
        }
    }
}

/**
 * A table with 16 columns.
 *
 * <p>
 * For an introduction to using tables, see the documentation for trait
 * <a href="TableDrivenPropertyChecks.html">TableDrivenPropertyChecks</a>.
 * </p>
 *
 * <p>
 * This table is a sequence of <code>Tuple16</code> objects, where each tuple represents one row of the table.
 * The first element of each tuple comprise the first column of the table, the second element of 
 * each tuple comprise the second column, and so on.  This table also carries with it
 * a <em>heading</em> tuple that gives string names to the columns of the table.
 * </p>
 *
 * <p>
 * A handy way to create a <code>TableFor16</code> is via an <code>apply</code> factory method in the <code>Table</code>
 * singleton object provided by the <code>Tables</code> trait. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * val examples =
 *   Table(
 *     ("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"),
 *     (  0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0),
 *     (  1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1),
 *     (  2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2),
 *     (  3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3),
 *     (  4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4),
 *     (  5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5),
 *     (  6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6),
 *     (  7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7),
 *     (  8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8),
 *     (  9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9)
 *   )
 * </pre>
 *
 * <p>
 * Because you supplied 16 members in each tuple, the type you'll get back will be a <code>TableFor16</code>.
 * </p>
 *
 * <p>
 * The table provides an <code>apply</code> method that takes a function with a parameter list that matches
 * the types and arity of the tuples contained in this table. The <code>apply</code> method will invoke the
 * function with the members of each row tuple passed as arguments, in ascending order by index. (<em>I.e.</em>,
 * the zeroth tuple is checked first, then the tuple with index 1, then index 2, and so on until all the rows
 * have been checked (or until a failure occurs). The function represents a property of the code under test
 * that should succeed for every row of the table. If the function returns normally, that indicates the property
 * check succeeded for that row. If the function completes abruptly with an exception, that indicates the
 * property check failed and the <code>apply</code> method will complete abruptly with a
 * <code>TableDrivenPropertyCheckFailedException</code> that wraps the exception thrown by the supplied property function.
 * </p>
 * 
 * <p>
 * The usual way you'd invoke the <code>apply</code> method that checks a property is via a <code>forAll</code> method
 * provided by trait <code>TableDrivenPropertyChecks</code>. The <code>forAll</code> method takes a <code>TableFor16</code> as its
 * first argument, then in a curried argument list takes the property check function. It invokes <code>apply</code> on
 * the <code>TableFor16</code>, passing in the property check function. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * forAll (examples) { (a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p) =>
 *   a + b + c + d + e + f + g + h + i + j + k + l + m + n + o + p should equal (a * 16)
 * }
 * </pre>
 *
 * <p>
 * Because <code>TableFor16</code> is a <code>Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P)]</code>, you can use it as a <code>Seq</code>. For example, here's how
 * you could get a sequence of <a href="../Outcome.html"><code>Outcome</code></a>s for each row of the table, indicating whether a property check succeeded or failed
 * on each row of the table:
 * </p>
 *
 * <pre class="stHighlight">
 * for (row <- examples) yield {
 *   outcomeOf { row._1 should not equal (7) }
 * }
 * </pre>
 *
 * <p>
 * Note: the <code>outcomeOf</code> method, contained in the <code>OutcomeOf</code> trait, will execute the supplied code (a by-name parameter) and
 * transform it to an <code>Outcome</code>. If no exception is thrown by the code, <code>outcomeOf</code> will result in a
 * <a href="../Succeeded$.html"><code>Succeeded</code></a>, indicating the "property check"
 * succeeded. If the supplied code completes abruptly in an exception that would normally cause a test to fail, <code>outcomeOf</code> will result in
 * in a <a href="../Failed.html"><code>Failed</code></a> instance containing that exception. For example, the previous for expression would give you:
 * </p>
 *
 * <pre class="stHighlight">
 * Vector(Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded,
 *     Failed(org.scalatest.TestFailedException: 7 equaled 7), Succeeded, Succeeded)
 * </pre>
 *
 * <p>
 * This shows that all the property checks succeeded, except for the one at index 7.
 * </p>
 *
 * @param heading a tuple containing string names of the columns in this table
 * @param rows a variable length parameter list of <code>Tuple16</code>s containing the data of this table
 *
 * @author Bill Venners 
 */

class TableFor16[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P](val heading: (String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String), rows: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P)*) extends IndexedSeq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P)] with IndexedSeqLike[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P), TableFor16[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P]] {

  /**
   * Selects a row of data by its index.
   */
  def apply(idx: Int): (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P) = rows(idx)

  /**
   * The number of rows of data in the table. (This does not include the <code>heading</code> tuple)
   */
  def length: Int = rows.length

  /**
   * Creates a new <code>Builder</code> for <code>TableFor16</code>s.
   */
  override protected[this] def newBuilder: Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P), TableFor16[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P]] =
    new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P)]) =>
      new TableFor16(heading, buf: _*)
    }

  /**
   * Applies the passed property check function to each row of this <code>TableFor16</code>.
   *
   * <p>
   * If the property checks for all rows succeed (the property check function returns normally when passed
   * the data for each row), this <code>apply</code> method returns normally. If the property check function
   * completes abruptly with an exception for any row, this <code>apply</code> method wraps that exception
   * in a <code>TableDrivenPropertyCheckFailedException</code> and completes abruptly with that exception. Once
   * the property check function throws an exception for a row, this <code>apply</code> method will complete
   * abruptly immediately and subsequent rows will not be checked against the function.
   * </p>
   *
   * @param fun the property check function to apply to each row of this <code>TableFor16</code>
   */
  def apply(fun: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P) => Unit) {
    for (((a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p), idx) <- rows.zipWithIndex) {
      try {
        fun(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p)
      }
      catch {
        case _: DiscardedEvaluationException => // discard this evaluation and move on to the next
        case ex: Throwable =>
          val (aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName, lName, mName, nName, oName, pName) = heading

          throw new TableDrivenPropertyCheckFailedException(
            sde => FailureMessages("propertyException", UnquotedString(ex.getClass.getSimpleName)) + 
              ( sde.failedCodeFileNameAndLineNumberString match { case Some(s) => " (" + s + ")"; case None => "" }) + "\n" + 
              "  " + FailureMessages("thrownExceptionsMessage", if (ex.getMessage == null) "None" else UnquotedString(ex.getMessage)) + "\n" +
              (
                ex match {
                  case sd: StackDepth if sd.failedCodeFileNameAndLineNumberString.isDefined =>
                    "  " + FailureMessages("thrownExceptionsLocation", UnquotedString(sd.failedCodeFileNameAndLineNumberString.get)) + "\n"
                  case _ => ""
                }
              ) +
              "  " + FailureMessages("occurredAtRow", idx) + "\n" +
              "    " + aName + " = " + a + "," + "\n" +
              "    " + bName + " = " + b + "," + "\n" +
              "    " + cName + " = " + c + "," + "\n" +
              "    " + dName + " = " + d + "," + "\n" +
              "    " + eName + " = " + e + "," + "\n" +
              "    " + fName + " = " + f + "," + "\n" +
              "    " + gName + " = " + g + "," + "\n" +
              "    " + hName + " = " + h + "," + "\n" +
              "    " + iName + " = " + i + "," + "\n" +
              "    " + jName + " = " + j + "," + "\n" +
              "    " + kName + " = " + k + "," + "\n" +
              "    " + lName + " = " + l + "," + "\n" +
              "    " + mName + " = " + m + "," + "\n" +
              "    " + nName + " = " + n + "," + "\n" +
              "    " + oName + " = " + o + "," + "\n" +
              "    " + pName + " = " + p + "\n" +

              "  )",
            Some(ex),
            getStackDepthFun("TableDrivenPropertyChecks.scala", "forAll", 2),
            FailureMessages("undecoratedPropertyCheckFailureMessage"),
            List(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p),
            List(aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName, lName, mName, nName, oName, pName),
            idx
          )
      }
    }
  }

  /**
   * A string representation of this object, which includes the heading strings as well as the rows of data.
   */
  override def toString: String = stringPrefix + "(" + heading.toString + ", " +  rows.mkString(", ") + ")"
}

/**
 * Companion object for class <code>TableFor16</code> that provides an implicit <code>canBuildFrom</code> method
 * that enables higher order functions defined on <code>TableFor16</code> to return another <code>TableFor16</code>.
 *
 * @author Bill Venners 
 */
object TableFor16 {

  /**
   * Implicit method enabling higher order functions of <code>TableFor16</code> to return sequences of type <code>TableFor16</code>.
   */
  implicit def canBuildFrom[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P]: CanBuildFrom[TableFor16[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P], (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P), TableFor16[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P]] =
    new CanBuildFrom[TableFor16[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P], (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P), TableFor16[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P]] {
      def apply(): Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P), TableFor16[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P)]) =>
          new TableFor16(("arg0","arg1","arg2","arg3","arg4","arg5","arg6","arg7","arg8","arg9","arg10","arg11","arg12","arg13","arg14","arg15"))
        }
      def apply(from: TableFor16[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P]): Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P), TableFor16[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P)]) =>
          new TableFor16(from.heading, buf: _*)
        }
    }
}

/**
 * A table with 17 columns.
 *
 * <p>
 * For an introduction to using tables, see the documentation for trait
 * <a href="TableDrivenPropertyChecks.html">TableDrivenPropertyChecks</a>.
 * </p>
 *
 * <p>
 * This table is a sequence of <code>Tuple17</code> objects, where each tuple represents one row of the table.
 * The first element of each tuple comprise the first column of the table, the second element of 
 * each tuple comprise the second column, and so on.  This table also carries with it
 * a <em>heading</em> tuple that gives string names to the columns of the table.
 * </p>
 *
 * <p>
 * A handy way to create a <code>TableFor17</code> is via an <code>apply</code> factory method in the <code>Table</code>
 * singleton object provided by the <code>Tables</code> trait. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * val examples =
 *   Table(
 *     ("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q"),
 *     (  0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0),
 *     (  1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1),
 *     (  2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2),
 *     (  3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3),
 *     (  4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4),
 *     (  5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5),
 *     (  6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6),
 *     (  7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7),
 *     (  8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8),
 *     (  9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9)
 *   )
 * </pre>
 *
 * <p>
 * Because you supplied 17 members in each tuple, the type you'll get back will be a <code>TableFor17</code>.
 * </p>
 *
 * <p>
 * The table provides an <code>apply</code> method that takes a function with a parameter list that matches
 * the types and arity of the tuples contained in this table. The <code>apply</code> method will invoke the
 * function with the members of each row tuple passed as arguments, in ascending order by index. (<em>I.e.</em>,
 * the zeroth tuple is checked first, then the tuple with index 1, then index 2, and so on until all the rows
 * have been checked (or until a failure occurs). The function represents a property of the code under test
 * that should succeed for every row of the table. If the function returns normally, that indicates the property
 * check succeeded for that row. If the function completes abruptly with an exception, that indicates the
 * property check failed and the <code>apply</code> method will complete abruptly with a
 * <code>TableDrivenPropertyCheckFailedException</code> that wraps the exception thrown by the supplied property function.
 * </p>
 * 
 * <p>
 * The usual way you'd invoke the <code>apply</code> method that checks a property is via a <code>forAll</code> method
 * provided by trait <code>TableDrivenPropertyChecks</code>. The <code>forAll</code> method takes a <code>TableFor17</code> as its
 * first argument, then in a curried argument list takes the property check function. It invokes <code>apply</code> on
 * the <code>TableFor17</code>, passing in the property check function. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * forAll (examples) { (a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q) =>
 *   a + b + c + d + e + f + g + h + i + j + k + l + m + n + o + p + q should equal (a * 17)
 * }
 * </pre>
 *
 * <p>
 * Because <code>TableFor17</code> is a <code>Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q)]</code>, you can use it as a <code>Seq</code>. For example, here's how
 * you could get a sequence of <a href="../Outcome.html"><code>Outcome</code></a>s for each row of the table, indicating whether a property check succeeded or failed
 * on each row of the table:
 * </p>
 *
 * <pre class="stHighlight">
 * for (row <- examples) yield {
 *   outcomeOf { row._1 should not equal (7) }
 * }
 * </pre>
 *
 * <p>
 * Note: the <code>outcomeOf</code> method, contained in the <code>OutcomeOf</code> trait, will execute the supplied code (a by-name parameter) and
 * transform it to an <code>Outcome</code>. If no exception is thrown by the code, <code>outcomeOf</code> will result in a
 * <a href="../Succeeded$.html"><code>Succeeded</code></a>, indicating the "property check"
 * succeeded. If the supplied code completes abruptly in an exception that would normally cause a test to fail, <code>outcomeOf</code> will result in
 * in a <a href="../Failed.html"><code>Failed</code></a> instance containing that exception. For example, the previous for expression would give you:
 * </p>
 *
 * <pre class="stHighlight">
 * Vector(Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded,
 *     Failed(org.scalatest.TestFailedException: 7 equaled 7), Succeeded, Succeeded)
 * </pre>
 *
 * <p>
 * This shows that all the property checks succeeded, except for the one at index 7.
 * </p>
 *
 * @param heading a tuple containing string names of the columns in this table
 * @param rows a variable length parameter list of <code>Tuple17</code>s containing the data of this table
 *
 * @author Bill Venners 
 */

class TableFor17[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q](val heading: (String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String), rows: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q)*) extends IndexedSeq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q)] with IndexedSeqLike[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q), TableFor17[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q]] {

  /**
   * Selects a row of data by its index.
   */
  def apply(idx: Int): (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q) = rows(idx)

  /**
   * The number of rows of data in the table. (This does not include the <code>heading</code> tuple)
   */
  def length: Int = rows.length

  /**
   * Creates a new <code>Builder</code> for <code>TableFor17</code>s.
   */
  override protected[this] def newBuilder: Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q), TableFor17[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q]] =
    new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q)]) =>
      new TableFor17(heading, buf: _*)
    }

  /**
   * Applies the passed property check function to each row of this <code>TableFor17</code>.
   *
   * <p>
   * If the property checks for all rows succeed (the property check function returns normally when passed
   * the data for each row), this <code>apply</code> method returns normally. If the property check function
   * completes abruptly with an exception for any row, this <code>apply</code> method wraps that exception
   * in a <code>TableDrivenPropertyCheckFailedException</code> and completes abruptly with that exception. Once
   * the property check function throws an exception for a row, this <code>apply</code> method will complete
   * abruptly immediately and subsequent rows will not be checked against the function.
   * </p>
   *
   * @param fun the property check function to apply to each row of this <code>TableFor17</code>
   */
  def apply(fun: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q) => Unit) {
    for (((a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q), idx) <- rows.zipWithIndex) {
      try {
        fun(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q)
      }
      catch {
        case _: DiscardedEvaluationException => // discard this evaluation and move on to the next
        case ex: Throwable =>
          val (aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName, lName, mName, nName, oName, pName, qName) = heading

          throw new TableDrivenPropertyCheckFailedException(
            sde => FailureMessages("propertyException", UnquotedString(ex.getClass.getSimpleName)) + 
              ( sde.failedCodeFileNameAndLineNumberString match { case Some(s) => " (" + s + ")"; case None => "" }) + "\n" + 
              "  " + FailureMessages("thrownExceptionsMessage", if (ex.getMessage == null) "None" else UnquotedString(ex.getMessage)) + "\n" +
              (
                ex match {
                  case sd: StackDepth if sd.failedCodeFileNameAndLineNumberString.isDefined =>
                    "  " + FailureMessages("thrownExceptionsLocation", UnquotedString(sd.failedCodeFileNameAndLineNumberString.get)) + "\n"
                  case _ => ""
                }
              ) +
              "  " + FailureMessages("occurredAtRow", idx) + "\n" +
              "    " + aName + " = " + a + "," + "\n" +
              "    " + bName + " = " + b + "," + "\n" +
              "    " + cName + " = " + c + "," + "\n" +
              "    " + dName + " = " + d + "," + "\n" +
              "    " + eName + " = " + e + "," + "\n" +
              "    " + fName + " = " + f + "," + "\n" +
              "    " + gName + " = " + g + "," + "\n" +
              "    " + hName + " = " + h + "," + "\n" +
              "    " + iName + " = " + i + "," + "\n" +
              "    " + jName + " = " + j + "," + "\n" +
              "    " + kName + " = " + k + "," + "\n" +
              "    " + lName + " = " + l + "," + "\n" +
              "    " + mName + " = " + m + "," + "\n" +
              "    " + nName + " = " + n + "," + "\n" +
              "    " + oName + " = " + o + "," + "\n" +
              "    " + pName + " = " + p + "," + "\n" +
              "    " + qName + " = " + q + "\n" +

              "  )",
            Some(ex),
            getStackDepthFun("TableDrivenPropertyChecks.scala", "forAll", 2),
            FailureMessages("undecoratedPropertyCheckFailureMessage"),
            List(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q),
            List(aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName, lName, mName, nName, oName, pName, qName),
            idx
          )
      }
    }
  }

  /**
   * A string representation of this object, which includes the heading strings as well as the rows of data.
   */
  override def toString: String = stringPrefix + "(" + heading.toString + ", " +  rows.mkString(", ") + ")"
}

/**
 * Companion object for class <code>TableFor17</code> that provides an implicit <code>canBuildFrom</code> method
 * that enables higher order functions defined on <code>TableFor17</code> to return another <code>TableFor17</code>.
 *
 * @author Bill Venners 
 */
object TableFor17 {

  /**
   * Implicit method enabling higher order functions of <code>TableFor17</code> to return sequences of type <code>TableFor17</code>.
   */
  implicit def canBuildFrom[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q]: CanBuildFrom[TableFor17[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q], (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q), TableFor17[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q]] =
    new CanBuildFrom[TableFor17[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q], (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q), TableFor17[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q]] {
      def apply(): Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q), TableFor17[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q)]) =>
          new TableFor17(("arg0","arg1","arg2","arg3","arg4","arg5","arg6","arg7","arg8","arg9","arg10","arg11","arg12","arg13","arg14","arg15","arg16"))
        }
      def apply(from: TableFor17[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q]): Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q), TableFor17[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q)]) =>
          new TableFor17(from.heading, buf: _*)
        }
    }
}

/**
 * A table with 18 columns.
 *
 * <p>
 * For an introduction to using tables, see the documentation for trait
 * <a href="TableDrivenPropertyChecks.html">TableDrivenPropertyChecks</a>.
 * </p>
 *
 * <p>
 * This table is a sequence of <code>Tuple18</code> objects, where each tuple represents one row of the table.
 * The first element of each tuple comprise the first column of the table, the second element of 
 * each tuple comprise the second column, and so on.  This table also carries with it
 * a <em>heading</em> tuple that gives string names to the columns of the table.
 * </p>
 *
 * <p>
 * A handy way to create a <code>TableFor18</code> is via an <code>apply</code> factory method in the <code>Table</code>
 * singleton object provided by the <code>Tables</code> trait. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * val examples =
 *   Table(
 *     ("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r"),
 *     (  0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0),
 *     (  1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1),
 *     (  2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2),
 *     (  3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3),
 *     (  4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4),
 *     (  5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5),
 *     (  6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6),
 *     (  7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7),
 *     (  8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8),
 *     (  9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9)
 *   )
 * </pre>
 *
 * <p>
 * Because you supplied 18 members in each tuple, the type you'll get back will be a <code>TableFor18</code>.
 * </p>
 *
 * <p>
 * The table provides an <code>apply</code> method that takes a function with a parameter list that matches
 * the types and arity of the tuples contained in this table. The <code>apply</code> method will invoke the
 * function with the members of each row tuple passed as arguments, in ascending order by index. (<em>I.e.</em>,
 * the zeroth tuple is checked first, then the tuple with index 1, then index 2, and so on until all the rows
 * have been checked (or until a failure occurs). The function represents a property of the code under test
 * that should succeed for every row of the table. If the function returns normally, that indicates the property
 * check succeeded for that row. If the function completes abruptly with an exception, that indicates the
 * property check failed and the <code>apply</code> method will complete abruptly with a
 * <code>TableDrivenPropertyCheckFailedException</code> that wraps the exception thrown by the supplied property function.
 * </p>
 * 
 * <p>
 * The usual way you'd invoke the <code>apply</code> method that checks a property is via a <code>forAll</code> method
 * provided by trait <code>TableDrivenPropertyChecks</code>. The <code>forAll</code> method takes a <code>TableFor18</code> as its
 * first argument, then in a curried argument list takes the property check function. It invokes <code>apply</code> on
 * the <code>TableFor18</code>, passing in the property check function. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * forAll (examples) { (a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r) =>
 *   a + b + c + d + e + f + g + h + i + j + k + l + m + n + o + p + q + r should equal (a * 18)
 * }
 * </pre>
 *
 * <p>
 * Because <code>TableFor18</code> is a <code>Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R)]</code>, you can use it as a <code>Seq</code>. For example, here's how
 * you could get a sequence of <a href="../Outcome.html"><code>Outcome</code></a>s for each row of the table, indicating whether a property check succeeded or failed
 * on each row of the table:
 * </p>
 *
 * <pre class="stHighlight">
 * for (row <- examples) yield {
 *   outcomeOf { row._1 should not equal (7) }
 * }
 * </pre>
 *
 * <p>
 * Note: the <code>outcomeOf</code> method, contained in the <code>OutcomeOf</code> trait, will execute the supplied code (a by-name parameter) and
 * transform it to an <code>Outcome</code>. If no exception is thrown by the code, <code>outcomeOf</code> will result in a
 * <a href="../Succeeded$.html"><code>Succeeded</code></a>, indicating the "property check"
 * succeeded. If the supplied code completes abruptly in an exception that would normally cause a test to fail, <code>outcomeOf</code> will result in
 * in a <a href="../Failed.html"><code>Failed</code></a> instance containing that exception. For example, the previous for expression would give you:
 * </p>
 *
 * <pre class="stHighlight">
 * Vector(Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded,
 *     Failed(org.scalatest.TestFailedException: 7 equaled 7), Succeeded, Succeeded)
 * </pre>
 *
 * <p>
 * This shows that all the property checks succeeded, except for the one at index 7.
 * </p>
 *
 * @param heading a tuple containing string names of the columns in this table
 * @param rows a variable length parameter list of <code>Tuple18</code>s containing the data of this table
 *
 * @author Bill Venners 
 */

class TableFor18[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R](val heading: (String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String), rows: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R)*) extends IndexedSeq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R)] with IndexedSeqLike[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R), TableFor18[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R]] {

  /**
   * Selects a row of data by its index.
   */
  def apply(idx: Int): (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R) = rows(idx)

  /**
   * The number of rows of data in the table. (This does not include the <code>heading</code> tuple)
   */
  def length: Int = rows.length

  /**
   * Creates a new <code>Builder</code> for <code>TableFor18</code>s.
   */
  override protected[this] def newBuilder: Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R), TableFor18[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R]] =
    new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R)]) =>
      new TableFor18(heading, buf: _*)
    }

  /**
   * Applies the passed property check function to each row of this <code>TableFor18</code>.
   *
   * <p>
   * If the property checks for all rows succeed (the property check function returns normally when passed
   * the data for each row), this <code>apply</code> method returns normally. If the property check function
   * completes abruptly with an exception for any row, this <code>apply</code> method wraps that exception
   * in a <code>TableDrivenPropertyCheckFailedException</code> and completes abruptly with that exception. Once
   * the property check function throws an exception for a row, this <code>apply</code> method will complete
   * abruptly immediately and subsequent rows will not be checked against the function.
   * </p>
   *
   * @param fun the property check function to apply to each row of this <code>TableFor18</code>
   */
  def apply(fun: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R) => Unit) {
    for (((a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r), idx) <- rows.zipWithIndex) {
      try {
        fun(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r)
      }
      catch {
        case _: DiscardedEvaluationException => // discard this evaluation and move on to the next
        case ex: Throwable =>
          val (aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName, lName, mName, nName, oName, pName, qName, rName) = heading

          throw new TableDrivenPropertyCheckFailedException(
            sde => FailureMessages("propertyException", UnquotedString(ex.getClass.getSimpleName)) + 
              ( sde.failedCodeFileNameAndLineNumberString match { case Some(s) => " (" + s + ")"; case None => "" }) + "\n" + 
              "  " + FailureMessages("thrownExceptionsMessage", if (ex.getMessage == null) "None" else UnquotedString(ex.getMessage)) + "\n" +
              (
                ex match {
                  case sd: StackDepth if sd.failedCodeFileNameAndLineNumberString.isDefined =>
                    "  " + FailureMessages("thrownExceptionsLocation", UnquotedString(sd.failedCodeFileNameAndLineNumberString.get)) + "\n"
                  case _ => ""
                }
              ) +
              "  " + FailureMessages("occurredAtRow", idx) + "\n" +
              "    " + aName + " = " + a + "," + "\n" +
              "    " + bName + " = " + b + "," + "\n" +
              "    " + cName + " = " + c + "," + "\n" +
              "    " + dName + " = " + d + "," + "\n" +
              "    " + eName + " = " + e + "," + "\n" +
              "    " + fName + " = " + f + "," + "\n" +
              "    " + gName + " = " + g + "," + "\n" +
              "    " + hName + " = " + h + "," + "\n" +
              "    " + iName + " = " + i + "," + "\n" +
              "    " + jName + " = " + j + "," + "\n" +
              "    " + kName + " = " + k + "," + "\n" +
              "    " + lName + " = " + l + "," + "\n" +
              "    " + mName + " = " + m + "," + "\n" +
              "    " + nName + " = " + n + "," + "\n" +
              "    " + oName + " = " + o + "," + "\n" +
              "    " + pName + " = " + p + "," + "\n" +
              "    " + qName + " = " + q + "," + "\n" +
              "    " + rName + " = " + r + "\n" +

              "  )",
            Some(ex),
            getStackDepthFun("TableDrivenPropertyChecks.scala", "forAll", 2),
            FailureMessages("undecoratedPropertyCheckFailureMessage"),
            List(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r),
            List(aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName, lName, mName, nName, oName, pName, qName, rName),
            idx
          )
      }
    }
  }

  /**
   * A string representation of this object, which includes the heading strings as well as the rows of data.
   */
  override def toString: String = stringPrefix + "(" + heading.toString + ", " +  rows.mkString(", ") + ")"
}

/**
 * Companion object for class <code>TableFor18</code> that provides an implicit <code>canBuildFrom</code> method
 * that enables higher order functions defined on <code>TableFor18</code> to return another <code>TableFor18</code>.
 *
 * @author Bill Venners 
 */
object TableFor18 {

  /**
   * Implicit method enabling higher order functions of <code>TableFor18</code> to return sequences of type <code>TableFor18</code>.
   */
  implicit def canBuildFrom[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R]: CanBuildFrom[TableFor18[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R], (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R), TableFor18[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R]] =
    new CanBuildFrom[TableFor18[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R], (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R), TableFor18[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R]] {
      def apply(): Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R), TableFor18[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R)]) =>
          new TableFor18(("arg0","arg1","arg2","arg3","arg4","arg5","arg6","arg7","arg8","arg9","arg10","arg11","arg12","arg13","arg14","arg15","arg16","arg17"))
        }
      def apply(from: TableFor18[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R]): Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R), TableFor18[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R)]) =>
          new TableFor18(from.heading, buf: _*)
        }
    }
}

/**
 * A table with 19 columns.
 *
 * <p>
 * For an introduction to using tables, see the documentation for trait
 * <a href="TableDrivenPropertyChecks.html">TableDrivenPropertyChecks</a>.
 * </p>
 *
 * <p>
 * This table is a sequence of <code>Tuple19</code> objects, where each tuple represents one row of the table.
 * The first element of each tuple comprise the first column of the table, the second element of 
 * each tuple comprise the second column, and so on.  This table also carries with it
 * a <em>heading</em> tuple that gives string names to the columns of the table.
 * </p>
 *
 * <p>
 * A handy way to create a <code>TableFor19</code> is via an <code>apply</code> factory method in the <code>Table</code>
 * singleton object provided by the <code>Tables</code> trait. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * val examples =
 *   Table(
 *     ("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s"),
 *     (  0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0),
 *     (  1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1),
 *     (  2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2),
 *     (  3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3),
 *     (  4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4),
 *     (  5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5),
 *     (  6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6),
 *     (  7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7),
 *     (  8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8),
 *     (  9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9)
 *   )
 * </pre>
 *
 * <p>
 * Because you supplied 19 members in each tuple, the type you'll get back will be a <code>TableFor19</code>.
 * </p>
 *
 * <p>
 * The table provides an <code>apply</code> method that takes a function with a parameter list that matches
 * the types and arity of the tuples contained in this table. The <code>apply</code> method will invoke the
 * function with the members of each row tuple passed as arguments, in ascending order by index. (<em>I.e.</em>,
 * the zeroth tuple is checked first, then the tuple with index 1, then index 2, and so on until all the rows
 * have been checked (or until a failure occurs). The function represents a property of the code under test
 * that should succeed for every row of the table. If the function returns normally, that indicates the property
 * check succeeded for that row. If the function completes abruptly with an exception, that indicates the
 * property check failed and the <code>apply</code> method will complete abruptly with a
 * <code>TableDrivenPropertyCheckFailedException</code> that wraps the exception thrown by the supplied property function.
 * </p>
 * 
 * <p>
 * The usual way you'd invoke the <code>apply</code> method that checks a property is via a <code>forAll</code> method
 * provided by trait <code>TableDrivenPropertyChecks</code>. The <code>forAll</code> method takes a <code>TableFor19</code> as its
 * first argument, then in a curried argument list takes the property check function. It invokes <code>apply</code> on
 * the <code>TableFor19</code>, passing in the property check function. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * forAll (examples) { (a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s) =>
 *   a + b + c + d + e + f + g + h + i + j + k + l + m + n + o + p + q + r + s should equal (a * 19)
 * }
 * </pre>
 *
 * <p>
 * Because <code>TableFor19</code> is a <code>Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S)]</code>, you can use it as a <code>Seq</code>. For example, here's how
 * you could get a sequence of <a href="../Outcome.html"><code>Outcome</code></a>s for each row of the table, indicating whether a property check succeeded or failed
 * on each row of the table:
 * </p>
 *
 * <pre class="stHighlight">
 * for (row <- examples) yield {
 *   outcomeOf { row._1 should not equal (7) }
 * }
 * </pre>
 *
 * <p>
 * Note: the <code>outcomeOf</code> method, contained in the <code>OutcomeOf</code> trait, will execute the supplied code (a by-name parameter) and
 * transform it to an <code>Outcome</code>. If no exception is thrown by the code, <code>outcomeOf</code> will result in a
 * <a href="../Succeeded$.html"><code>Succeeded</code></a>, indicating the "property check"
 * succeeded. If the supplied code completes abruptly in an exception that would normally cause a test to fail, <code>outcomeOf</code> will result in
 * in a <a href="../Failed.html"><code>Failed</code></a> instance containing that exception. For example, the previous for expression would give you:
 * </p>
 *
 * <pre class="stHighlight">
 * Vector(Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded,
 *     Failed(org.scalatest.TestFailedException: 7 equaled 7), Succeeded, Succeeded)
 * </pre>
 *
 * <p>
 * This shows that all the property checks succeeded, except for the one at index 7.
 * </p>
 *
 * @param heading a tuple containing string names of the columns in this table
 * @param rows a variable length parameter list of <code>Tuple19</code>s containing the data of this table
 *
 * @author Bill Venners 
 */

class TableFor19[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S](val heading: (String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String), rows: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S)*) extends IndexedSeq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S)] with IndexedSeqLike[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S), TableFor19[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S]] {

  /**
   * Selects a row of data by its index.
   */
  def apply(idx: Int): (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S) = rows(idx)

  /**
   * The number of rows of data in the table. (This does not include the <code>heading</code> tuple)
   */
  def length: Int = rows.length

  /**
   * Creates a new <code>Builder</code> for <code>TableFor19</code>s.
   */
  override protected[this] def newBuilder: Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S), TableFor19[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S]] =
    new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S)]) =>
      new TableFor19(heading, buf: _*)
    }

  /**
   * Applies the passed property check function to each row of this <code>TableFor19</code>.
   *
   * <p>
   * If the property checks for all rows succeed (the property check function returns normally when passed
   * the data for each row), this <code>apply</code> method returns normally. If the property check function
   * completes abruptly with an exception for any row, this <code>apply</code> method wraps that exception
   * in a <code>TableDrivenPropertyCheckFailedException</code> and completes abruptly with that exception. Once
   * the property check function throws an exception for a row, this <code>apply</code> method will complete
   * abruptly immediately and subsequent rows will not be checked against the function.
   * </p>
   *
   * @param fun the property check function to apply to each row of this <code>TableFor19</code>
   */
  def apply(fun: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S) => Unit) {
    for (((a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s), idx) <- rows.zipWithIndex) {
      try {
        fun(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s)
      }
      catch {
        case _: DiscardedEvaluationException => // discard this evaluation and move on to the next
        case ex: Throwable =>
          val (aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName, lName, mName, nName, oName, pName, qName, rName, sName) = heading

          throw new TableDrivenPropertyCheckFailedException(
            sde => FailureMessages("propertyException", UnquotedString(ex.getClass.getSimpleName)) + 
              ( sde.failedCodeFileNameAndLineNumberString match { case Some(s) => " (" + s + ")"; case None => "" }) + "\n" + 
              "  " + FailureMessages("thrownExceptionsMessage", if (ex.getMessage == null) "None" else UnquotedString(ex.getMessage)) + "\n" +
              (
                ex match {
                  case sd: StackDepth if sd.failedCodeFileNameAndLineNumberString.isDefined =>
                    "  " + FailureMessages("thrownExceptionsLocation", UnquotedString(sd.failedCodeFileNameAndLineNumberString.get)) + "\n"
                  case _ => ""
                }
              ) +
              "  " + FailureMessages("occurredAtRow", idx) + "\n" +
              "    " + aName + " = " + a + "," + "\n" +
              "    " + bName + " = " + b + "," + "\n" +
              "    " + cName + " = " + c + "," + "\n" +
              "    " + dName + " = " + d + "," + "\n" +
              "    " + eName + " = " + e + "," + "\n" +
              "    " + fName + " = " + f + "," + "\n" +
              "    " + gName + " = " + g + "," + "\n" +
              "    " + hName + " = " + h + "," + "\n" +
              "    " + iName + " = " + i + "," + "\n" +
              "    " + jName + " = " + j + "," + "\n" +
              "    " + kName + " = " + k + "," + "\n" +
              "    " + lName + " = " + l + "," + "\n" +
              "    " + mName + " = " + m + "," + "\n" +
              "    " + nName + " = " + n + "," + "\n" +
              "    " + oName + " = " + o + "," + "\n" +
              "    " + pName + " = " + p + "," + "\n" +
              "    " + qName + " = " + q + "," + "\n" +
              "    " + rName + " = " + r + "," + "\n" +
              "    " + sName + " = " + s + "\n" +

              "  )",
            Some(ex),
            getStackDepthFun("TableDrivenPropertyChecks.scala", "forAll", 2),
            FailureMessages("undecoratedPropertyCheckFailureMessage"),
            List(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s),
            List(aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName, lName, mName, nName, oName, pName, qName, rName, sName),
            idx
          )
      }
    }
  }

  /**
   * A string representation of this object, which includes the heading strings as well as the rows of data.
   */
  override def toString: String = stringPrefix + "(" + heading.toString + ", " +  rows.mkString(", ") + ")"
}

/**
 * Companion object for class <code>TableFor19</code> that provides an implicit <code>canBuildFrom</code> method
 * that enables higher order functions defined on <code>TableFor19</code> to return another <code>TableFor19</code>.
 *
 * @author Bill Venners 
 */
object TableFor19 {

  /**
   * Implicit method enabling higher order functions of <code>TableFor19</code> to return sequences of type <code>TableFor19</code>.
   */
  implicit def canBuildFrom[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S]: CanBuildFrom[TableFor19[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S], (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S), TableFor19[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S]] =
    new CanBuildFrom[TableFor19[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S], (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S), TableFor19[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S]] {
      def apply(): Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S), TableFor19[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S)]) =>
          new TableFor19(("arg0","arg1","arg2","arg3","arg4","arg5","arg6","arg7","arg8","arg9","arg10","arg11","arg12","arg13","arg14","arg15","arg16","arg17","arg18"))
        }
      def apply(from: TableFor19[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S]): Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S), TableFor19[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S)]) =>
          new TableFor19(from.heading, buf: _*)
        }
    }
}

/**
 * A table with 20 columns.
 *
 * <p>
 * For an introduction to using tables, see the documentation for trait
 * <a href="TableDrivenPropertyChecks.html">TableDrivenPropertyChecks</a>.
 * </p>
 *
 * <p>
 * This table is a sequence of <code>Tuple20</code> objects, where each tuple represents one row of the table.
 * The first element of each tuple comprise the first column of the table, the second element of 
 * each tuple comprise the second column, and so on.  This table also carries with it
 * a <em>heading</em> tuple that gives string names to the columns of the table.
 * </p>
 *
 * <p>
 * A handy way to create a <code>TableFor20</code> is via an <code>apply</code> factory method in the <code>Table</code>
 * singleton object provided by the <code>Tables</code> trait. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * val examples =
 *   Table(
 *     ("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t"),
 *     (  0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0),
 *     (  1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1),
 *     (  2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2),
 *     (  3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3),
 *     (  4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4),
 *     (  5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5),
 *     (  6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6),
 *     (  7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7),
 *     (  8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8),
 *     (  9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9)
 *   )
 * </pre>
 *
 * <p>
 * Because you supplied 20 members in each tuple, the type you'll get back will be a <code>TableFor20</code>.
 * </p>
 *
 * <p>
 * The table provides an <code>apply</code> method that takes a function with a parameter list that matches
 * the types and arity of the tuples contained in this table. The <code>apply</code> method will invoke the
 * function with the members of each row tuple passed as arguments, in ascending order by index. (<em>I.e.</em>,
 * the zeroth tuple is checked first, then the tuple with index 1, then index 2, and so on until all the rows
 * have been checked (or until a failure occurs). The function represents a property of the code under test
 * that should succeed for every row of the table. If the function returns normally, that indicates the property
 * check succeeded for that row. If the function completes abruptly with an exception, that indicates the
 * property check failed and the <code>apply</code> method will complete abruptly with a
 * <code>TableDrivenPropertyCheckFailedException</code> that wraps the exception thrown by the supplied property function.
 * </p>
 * 
 * <p>
 * The usual way you'd invoke the <code>apply</code> method that checks a property is via a <code>forAll</code> method
 * provided by trait <code>TableDrivenPropertyChecks</code>. The <code>forAll</code> method takes a <code>TableFor20</code> as its
 * first argument, then in a curried argument list takes the property check function. It invokes <code>apply</code> on
 * the <code>TableFor20</code>, passing in the property check function. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * forAll (examples) { (a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t) =>
 *   a + b + c + d + e + f + g + h + i + j + k + l + m + n + o + p + q + r + s + t should equal (a * 20)
 * }
 * </pre>
 *
 * <p>
 * Because <code>TableFor20</code> is a <code>Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T)]</code>, you can use it as a <code>Seq</code>. For example, here's how
 * you could get a sequence of <a href="../Outcome.html"><code>Outcome</code></a>s for each row of the table, indicating whether a property check succeeded or failed
 * on each row of the table:
 * </p>
 *
 * <pre class="stHighlight">
 * for (row <- examples) yield {
 *   outcomeOf { row._1 should not equal (7) }
 * }
 * </pre>
 *
 * <p>
 * Note: the <code>outcomeOf</code> method, contained in the <code>OutcomeOf</code> trait, will execute the supplied code (a by-name parameter) and
 * transform it to an <code>Outcome</code>. If no exception is thrown by the code, <code>outcomeOf</code> will result in a
 * <a href="../Succeeded$.html"><code>Succeeded</code></a>, indicating the "property check"
 * succeeded. If the supplied code completes abruptly in an exception that would normally cause a test to fail, <code>outcomeOf</code> will result in
 * in a <a href="../Failed.html"><code>Failed</code></a> instance containing that exception. For example, the previous for expression would give you:
 * </p>
 *
 * <pre class="stHighlight">
 * Vector(Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded,
 *     Failed(org.scalatest.TestFailedException: 7 equaled 7), Succeeded, Succeeded)
 * </pre>
 *
 * <p>
 * This shows that all the property checks succeeded, except for the one at index 7.
 * </p>
 *
 * @param heading a tuple containing string names of the columns in this table
 * @param rows a variable length parameter list of <code>Tuple20</code>s containing the data of this table
 *
 * @author Bill Venners 
 */

class TableFor20[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T](val heading: (String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String), rows: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T)*) extends IndexedSeq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T)] with IndexedSeqLike[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T), TableFor20[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T]] {

  /**
   * Selects a row of data by its index.
   */
  def apply(idx: Int): (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T) = rows(idx)

  /**
   * The number of rows of data in the table. (This does not include the <code>heading</code> tuple)
   */
  def length: Int = rows.length

  /**
   * Creates a new <code>Builder</code> for <code>TableFor20</code>s.
   */
  override protected[this] def newBuilder: Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T), TableFor20[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T]] =
    new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T)]) =>
      new TableFor20(heading, buf: _*)
    }

  /**
   * Applies the passed property check function to each row of this <code>TableFor20</code>.
   *
   * <p>
   * If the property checks for all rows succeed (the property check function returns normally when passed
   * the data for each row), this <code>apply</code> method returns normally. If the property check function
   * completes abruptly with an exception for any row, this <code>apply</code> method wraps that exception
   * in a <code>TableDrivenPropertyCheckFailedException</code> and completes abruptly with that exception. Once
   * the property check function throws an exception for a row, this <code>apply</code> method will complete
   * abruptly immediately and subsequent rows will not be checked against the function.
   * </p>
   *
   * @param fun the property check function to apply to each row of this <code>TableFor20</code>
   */
  def apply(fun: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T) => Unit) {
    for (((a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t), idx) <- rows.zipWithIndex) {
      try {
        fun(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t)
      }
      catch {
        case _: DiscardedEvaluationException => // discard this evaluation and move on to the next
        case ex: Throwable =>
          val (aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName, lName, mName, nName, oName, pName, qName, rName, sName, tName) = heading

          throw new TableDrivenPropertyCheckFailedException(
            sde => FailureMessages("propertyException", UnquotedString(ex.getClass.getSimpleName)) + 
              ( sde.failedCodeFileNameAndLineNumberString match { case Some(s) => " (" + s + ")"; case None => "" }) + "\n" + 
              "  " + FailureMessages("thrownExceptionsMessage", if (ex.getMessage == null) "None" else UnquotedString(ex.getMessage)) + "\n" +
              (
                ex match {
                  case sd: StackDepth if sd.failedCodeFileNameAndLineNumberString.isDefined =>
                    "  " + FailureMessages("thrownExceptionsLocation", UnquotedString(sd.failedCodeFileNameAndLineNumberString.get)) + "\n"
                  case _ => ""
                }
              ) +
              "  " + FailureMessages("occurredAtRow", idx) + "\n" +
              "    " + aName + " = " + a + "," + "\n" +
              "    " + bName + " = " + b + "," + "\n" +
              "    " + cName + " = " + c + "," + "\n" +
              "    " + dName + " = " + d + "," + "\n" +
              "    " + eName + " = " + e + "," + "\n" +
              "    " + fName + " = " + f + "," + "\n" +
              "    " + gName + " = " + g + "," + "\n" +
              "    " + hName + " = " + h + "," + "\n" +
              "    " + iName + " = " + i + "," + "\n" +
              "    " + jName + " = " + j + "," + "\n" +
              "    " + kName + " = " + k + "," + "\n" +
              "    " + lName + " = " + l + "," + "\n" +
              "    " + mName + " = " + m + "," + "\n" +
              "    " + nName + " = " + n + "," + "\n" +
              "    " + oName + " = " + o + "," + "\n" +
              "    " + pName + " = " + p + "," + "\n" +
              "    " + qName + " = " + q + "," + "\n" +
              "    " + rName + " = " + r + "," + "\n" +
              "    " + sName + " = " + s + "," + "\n" +
              "    " + tName + " = " + t + "\n" +

              "  )",
            Some(ex),
            getStackDepthFun("TableDrivenPropertyChecks.scala", "forAll", 2),
            FailureMessages("undecoratedPropertyCheckFailureMessage"),
            List(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t),
            List(aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName, lName, mName, nName, oName, pName, qName, rName, sName, tName),
            idx
          )
      }
    }
  }

  /**
   * A string representation of this object, which includes the heading strings as well as the rows of data.
   */
  override def toString: String = stringPrefix + "(" + heading.toString + ", " +  rows.mkString(", ") + ")"
}

/**
 * Companion object for class <code>TableFor20</code> that provides an implicit <code>canBuildFrom</code> method
 * that enables higher order functions defined on <code>TableFor20</code> to return another <code>TableFor20</code>.
 *
 * @author Bill Venners 
 */
object TableFor20 {

  /**
   * Implicit method enabling higher order functions of <code>TableFor20</code> to return sequences of type <code>TableFor20</code>.
   */
  implicit def canBuildFrom[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T]: CanBuildFrom[TableFor20[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T], (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T), TableFor20[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T]] =
    new CanBuildFrom[TableFor20[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T], (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T), TableFor20[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T]] {
      def apply(): Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T), TableFor20[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T)]) =>
          new TableFor20(("arg0","arg1","arg2","arg3","arg4","arg5","arg6","arg7","arg8","arg9","arg10","arg11","arg12","arg13","arg14","arg15","arg16","arg17","arg18","arg19"))
        }
      def apply(from: TableFor20[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T]): Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T), TableFor20[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T)]) =>
          new TableFor20(from.heading, buf: _*)
        }
    }
}

/**
 * A table with 21 columns.
 *
 * <p>
 * For an introduction to using tables, see the documentation for trait
 * <a href="TableDrivenPropertyChecks.html">TableDrivenPropertyChecks</a>.
 * </p>
 *
 * <p>
 * This table is a sequence of <code>Tuple21</code> objects, where each tuple represents one row of the table.
 * The first element of each tuple comprise the first column of the table, the second element of 
 * each tuple comprise the second column, and so on.  This table also carries with it
 * a <em>heading</em> tuple that gives string names to the columns of the table.
 * </p>
 *
 * <p>
 * A handy way to create a <code>TableFor21</code> is via an <code>apply</code> factory method in the <code>Table</code>
 * singleton object provided by the <code>Tables</code> trait. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * val examples =
 *   Table(
 *     ("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u"),
 *     (  0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0),
 *     (  1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1),
 *     (  2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2),
 *     (  3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3),
 *     (  4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4),
 *     (  5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5),
 *     (  6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6),
 *     (  7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7),
 *     (  8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8),
 *     (  9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9)
 *   )
 * </pre>
 *
 * <p>
 * Because you supplied 21 members in each tuple, the type you'll get back will be a <code>TableFor21</code>.
 * </p>
 *
 * <p>
 * The table provides an <code>apply</code> method that takes a function with a parameter list that matches
 * the types and arity of the tuples contained in this table. The <code>apply</code> method will invoke the
 * function with the members of each row tuple passed as arguments, in ascending order by index. (<em>I.e.</em>,
 * the zeroth tuple is checked first, then the tuple with index 1, then index 2, and so on until all the rows
 * have been checked (or until a failure occurs). The function represents a property of the code under test
 * that should succeed for every row of the table. If the function returns normally, that indicates the property
 * check succeeded for that row. If the function completes abruptly with an exception, that indicates the
 * property check failed and the <code>apply</code> method will complete abruptly with a
 * <code>TableDrivenPropertyCheckFailedException</code> that wraps the exception thrown by the supplied property function.
 * </p>
 * 
 * <p>
 * The usual way you'd invoke the <code>apply</code> method that checks a property is via a <code>forAll</code> method
 * provided by trait <code>TableDrivenPropertyChecks</code>. The <code>forAll</code> method takes a <code>TableFor21</code> as its
 * first argument, then in a curried argument list takes the property check function. It invokes <code>apply</code> on
 * the <code>TableFor21</code>, passing in the property check function. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * forAll (examples) { (a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u) =>
 *   a + b + c + d + e + f + g + h + i + j + k + l + m + n + o + p + q + r + s + t + u should equal (a * 21)
 * }
 * </pre>
 *
 * <p>
 * Because <code>TableFor21</code> is a <code>Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U)]</code>, you can use it as a <code>Seq</code>. For example, here's how
 * you could get a sequence of <a href="../Outcome.html"><code>Outcome</code></a>s for each row of the table, indicating whether a property check succeeded or failed
 * on each row of the table:
 * </p>
 *
 * <pre class="stHighlight">
 * for (row <- examples) yield {
 *   outcomeOf { row._1 should not equal (7) }
 * }
 * </pre>
 *
 * <p>
 * Note: the <code>outcomeOf</code> method, contained in the <code>OutcomeOf</code> trait, will execute the supplied code (a by-name parameter) and
 * transform it to an <code>Outcome</code>. If no exception is thrown by the code, <code>outcomeOf</code> will result in a
 * <a href="../Succeeded$.html"><code>Succeeded</code></a>, indicating the "property check"
 * succeeded. If the supplied code completes abruptly in an exception that would normally cause a test to fail, <code>outcomeOf</code> will result in
 * in a <a href="../Failed.html"><code>Failed</code></a> instance containing that exception. For example, the previous for expression would give you:
 * </p>
 *
 * <pre class="stHighlight">
 * Vector(Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded,
 *     Failed(org.scalatest.TestFailedException: 7 equaled 7), Succeeded, Succeeded)
 * </pre>
 *
 * <p>
 * This shows that all the property checks succeeded, except for the one at index 7.
 * </p>
 *
 * @param heading a tuple containing string names of the columns in this table
 * @param rows a variable length parameter list of <code>Tuple21</code>s containing the data of this table
 *
 * @author Bill Venners 
 */

class TableFor21[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U](val heading: (String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String), rows: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U)*) extends IndexedSeq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U)] with IndexedSeqLike[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U), TableFor21[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U]] {

  /**
   * Selects a row of data by its index.
   */
  def apply(idx: Int): (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U) = rows(idx)

  /**
   * The number of rows of data in the table. (This does not include the <code>heading</code> tuple)
   */
  def length: Int = rows.length

  /**
   * Creates a new <code>Builder</code> for <code>TableFor21</code>s.
   */
  override protected[this] def newBuilder: Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U), TableFor21[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U]] =
    new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U)]) =>
      new TableFor21(heading, buf: _*)
    }

  /**
   * Applies the passed property check function to each row of this <code>TableFor21</code>.
   *
   * <p>
   * If the property checks for all rows succeed (the property check function returns normally when passed
   * the data for each row), this <code>apply</code> method returns normally. If the property check function
   * completes abruptly with an exception for any row, this <code>apply</code> method wraps that exception
   * in a <code>TableDrivenPropertyCheckFailedException</code> and completes abruptly with that exception. Once
   * the property check function throws an exception for a row, this <code>apply</code> method will complete
   * abruptly immediately and subsequent rows will not be checked against the function.
   * </p>
   *
   * @param fun the property check function to apply to each row of this <code>TableFor21</code>
   */
  def apply(fun: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U) => Unit) {
    for (((a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u), idx) <- rows.zipWithIndex) {
      try {
        fun(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u)
      }
      catch {
        case _: DiscardedEvaluationException => // discard this evaluation and move on to the next
        case ex: Throwable =>
          val (aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName, lName, mName, nName, oName, pName, qName, rName, sName, tName, uName) = heading

          throw new TableDrivenPropertyCheckFailedException(
            sde => FailureMessages("propertyException", UnquotedString(ex.getClass.getSimpleName)) + 
              ( sde.failedCodeFileNameAndLineNumberString match { case Some(s) => " (" + s + ")"; case None => "" }) + "\n" + 
              "  " + FailureMessages("thrownExceptionsMessage", if (ex.getMessage == null) "None" else UnquotedString(ex.getMessage)) + "\n" +
              (
                ex match {
                  case sd: StackDepth if sd.failedCodeFileNameAndLineNumberString.isDefined =>
                    "  " + FailureMessages("thrownExceptionsLocation", UnquotedString(sd.failedCodeFileNameAndLineNumberString.get)) + "\n"
                  case _ => ""
                }
              ) +
              "  " + FailureMessages("occurredAtRow", idx) + "\n" +
              "    " + aName + " = " + a + "," + "\n" +
              "    " + bName + " = " + b + "," + "\n" +
              "    " + cName + " = " + c + "," + "\n" +
              "    " + dName + " = " + d + "," + "\n" +
              "    " + eName + " = " + e + "," + "\n" +
              "    " + fName + " = " + f + "," + "\n" +
              "    " + gName + " = " + g + "," + "\n" +
              "    " + hName + " = " + h + "," + "\n" +
              "    " + iName + " = " + i + "," + "\n" +
              "    " + jName + " = " + j + "," + "\n" +
              "    " + kName + " = " + k + "," + "\n" +
              "    " + lName + " = " + l + "," + "\n" +
              "    " + mName + " = " + m + "," + "\n" +
              "    " + nName + " = " + n + "," + "\n" +
              "    " + oName + " = " + o + "," + "\n" +
              "    " + pName + " = " + p + "," + "\n" +
              "    " + qName + " = " + q + "," + "\n" +
              "    " + rName + " = " + r + "," + "\n" +
              "    " + sName + " = " + s + "," + "\n" +
              "    " + tName + " = " + t + "," + "\n" +
              "    " + uName + " = " + u + "\n" +

              "  )",
            Some(ex),
            getStackDepthFun("TableDrivenPropertyChecks.scala", "forAll", 2),
            FailureMessages("undecoratedPropertyCheckFailureMessage"),
            List(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u),
            List(aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName, lName, mName, nName, oName, pName, qName, rName, sName, tName, uName),
            idx
          )
      }
    }
  }

  /**
   * A string representation of this object, which includes the heading strings as well as the rows of data.
   */
  override def toString: String = stringPrefix + "(" + heading.toString + ", " +  rows.mkString(", ") + ")"
}

/**
 * Companion object for class <code>TableFor21</code> that provides an implicit <code>canBuildFrom</code> method
 * that enables higher order functions defined on <code>TableFor21</code> to return another <code>TableFor21</code>.
 *
 * @author Bill Venners 
 */
object TableFor21 {

  /**
   * Implicit method enabling higher order functions of <code>TableFor21</code> to return sequences of type <code>TableFor21</code>.
   */
  implicit def canBuildFrom[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U]: CanBuildFrom[TableFor21[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U], (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U), TableFor21[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U]] =
    new CanBuildFrom[TableFor21[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U], (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U), TableFor21[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U]] {
      def apply(): Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U), TableFor21[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U)]) =>
          new TableFor21(("arg0","arg1","arg2","arg3","arg4","arg5","arg6","arg7","arg8","arg9","arg10","arg11","arg12","arg13","arg14","arg15","arg16","arg17","arg18","arg19","arg20"))
        }
      def apply(from: TableFor21[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U]): Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U), TableFor21[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U)]) =>
          new TableFor21(from.heading, buf: _*)
        }
    }
}

/**
 * A table with 22 columns.
 *
 * <p>
 * For an introduction to using tables, see the documentation for trait
 * <a href="TableDrivenPropertyChecks.html">TableDrivenPropertyChecks</a>.
 * </p>
 *
 * <p>
 * This table is a sequence of <code>Tuple22</code> objects, where each tuple represents one row of the table.
 * The first element of each tuple comprise the first column of the table, the second element of 
 * each tuple comprise the second column, and so on.  This table also carries with it
 * a <em>heading</em> tuple that gives string names to the columns of the table.
 * </p>
 *
 * <p>
 * A handy way to create a <code>TableFor22</code> is via an <code>apply</code> factory method in the <code>Table</code>
 * singleton object provided by the <code>Tables</code> trait. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * val examples =
 *   Table(
 *     ("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v"),
 *     (  0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0),
 *     (  1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1),
 *     (  2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2),
 *     (  3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3,   3),
 *     (  4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4,   4),
 *     (  5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5),
 *     (  6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6,   6),
 *     (  7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7),
 *     (  8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8,   8),
 *     (  9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9,   9)
 *   )
 * </pre>
 *
 * <p>
 * Because you supplied 22 members in each tuple, the type you'll get back will be a <code>TableFor22</code>.
 * </p>
 *
 * <p>
 * The table provides an <code>apply</code> method that takes a function with a parameter list that matches
 * the types and arity of the tuples contained in this table. The <code>apply</code> method will invoke the
 * function with the members of each row tuple passed as arguments, in ascending order by index. (<em>I.e.</em>,
 * the zeroth tuple is checked first, then the tuple with index 1, then index 2, and so on until all the rows
 * have been checked (or until a failure occurs). The function represents a property of the code under test
 * that should succeed for every row of the table. If the function returns normally, that indicates the property
 * check succeeded for that row. If the function completes abruptly with an exception, that indicates the
 * property check failed and the <code>apply</code> method will complete abruptly with a
 * <code>TableDrivenPropertyCheckFailedException</code> that wraps the exception thrown by the supplied property function.
 * </p>
 * 
 * <p>
 * The usual way you'd invoke the <code>apply</code> method that checks a property is via a <code>forAll</code> method
 * provided by trait <code>TableDrivenPropertyChecks</code>. The <code>forAll</code> method takes a <code>TableFor22</code> as its
 * first argument, then in a curried argument list takes the property check function. It invokes <code>apply</code> on
 * the <code>TableFor22</code>, passing in the property check function. Here's an example:
 * </p>
 *
 * <pre class="stHighlight">
 * forAll (examples) { (a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v) =>
 *   a + b + c + d + e + f + g + h + i + j + k + l + m + n + o + p + q + r + s + t + u + v should equal (a * 22)
 * }
 * </pre>
 *
 * <p>
 * Because <code>TableFor22</code> is a <code>Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V)]</code>, you can use it as a <code>Seq</code>. For example, here's how
 * you could get a sequence of <a href="../Outcome.html"><code>Outcome</code></a>s for each row of the table, indicating whether a property check succeeded or failed
 * on each row of the table:
 * </p>
 *
 * <pre class="stHighlight">
 * for (row <- examples) yield {
 *   outcomeOf { row._1 should not equal (7) }
 * }
 * </pre>
 *
 * <p>
 * Note: the <code>outcomeOf</code> method, contained in the <code>OutcomeOf</code> trait, will execute the supplied code (a by-name parameter) and
 * transform it to an <code>Outcome</code>. If no exception is thrown by the code, <code>outcomeOf</code> will result in a
 * <a href="../Succeeded$.html"><code>Succeeded</code></a>, indicating the "property check"
 * succeeded. If the supplied code completes abruptly in an exception that would normally cause a test to fail, <code>outcomeOf</code> will result in
 * in a <a href="../Failed.html"><code>Failed</code></a> instance containing that exception. For example, the previous for expression would give you:
 * </p>
 *
 * <pre class="stHighlight">
 * Vector(Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded, Succeeded,
 *     Failed(org.scalatest.TestFailedException: 7 equaled 7), Succeeded, Succeeded)
 * </pre>
 *
 * <p>
 * This shows that all the property checks succeeded, except for the one at index 7.
 * </p>
 *
 * @param heading a tuple containing string names of the columns in this table
 * @param rows a variable length parameter list of <code>Tuple22</code>s containing the data of this table
 *
 * @author Bill Venners 
 */

class TableFor22[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V](val heading: (String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String), rows: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V)*) extends IndexedSeq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V)] with IndexedSeqLike[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V), TableFor22[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V]] {

  /**
   * Selects a row of data by its index.
   */
  def apply(idx: Int): (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V) = rows(idx)

  /**
   * The number of rows of data in the table. (This does not include the <code>heading</code> tuple)
   */
  def length: Int = rows.length

  /**
   * Creates a new <code>Builder</code> for <code>TableFor22</code>s.
   */
  override protected[this] def newBuilder: Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V), TableFor22[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V]] =
    new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V)]) =>
      new TableFor22(heading, buf: _*)
    }

  /**
   * Applies the passed property check function to each row of this <code>TableFor22</code>.
   *
   * <p>
   * If the property checks for all rows succeed (the property check function returns normally when passed
   * the data for each row), this <code>apply</code> method returns normally. If the property check function
   * completes abruptly with an exception for any row, this <code>apply</code> method wraps that exception
   * in a <code>TableDrivenPropertyCheckFailedException</code> and completes abruptly with that exception. Once
   * the property check function throws an exception for a row, this <code>apply</code> method will complete
   * abruptly immediately and subsequent rows will not be checked against the function.
   * </p>
   *
   * @param fun the property check function to apply to each row of this <code>TableFor22</code>
   */
  def apply(fun: (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V) => Unit) {
    for (((a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v), idx) <- rows.zipWithIndex) {
      try {
        fun(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v)
      }
      catch {
        case _: DiscardedEvaluationException => // discard this evaluation and move on to the next
        case ex: Throwable =>
          val (aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName, lName, mName, nName, oName, pName, qName, rName, sName, tName, uName, vName) = heading

          throw new TableDrivenPropertyCheckFailedException(
            sde => FailureMessages("propertyException", UnquotedString(ex.getClass.getSimpleName)) + 
              ( sde.failedCodeFileNameAndLineNumberString match { case Some(s) => " (" + s + ")"; case None => "" }) + "\n" + 
              "  " + FailureMessages("thrownExceptionsMessage", if (ex.getMessage == null) "None" else UnquotedString(ex.getMessage)) + "\n" +
              (
                ex match {
                  case sd: StackDepth if sd.failedCodeFileNameAndLineNumberString.isDefined =>
                    "  " + FailureMessages("thrownExceptionsLocation", UnquotedString(sd.failedCodeFileNameAndLineNumberString.get)) + "\n"
                  case _ => ""
                }
              ) +
              "  " + FailureMessages("occurredAtRow", idx) + "\n" +
              "    " + aName + " = " + a + "," + "\n" +
              "    " + bName + " = " + b + "," + "\n" +
              "    " + cName + " = " + c + "," + "\n" +
              "    " + dName + " = " + d + "," + "\n" +
              "    " + eName + " = " + e + "," + "\n" +
              "    " + fName + " = " + f + "," + "\n" +
              "    " + gName + " = " + g + "," + "\n" +
              "    " + hName + " = " + h + "," + "\n" +
              "    " + iName + " = " + i + "," + "\n" +
              "    " + jName + " = " + j + "," + "\n" +
              "    " + kName + " = " + k + "," + "\n" +
              "    " + lName + " = " + l + "," + "\n" +
              "    " + mName + " = " + m + "," + "\n" +
              "    " + nName + " = " + n + "," + "\n" +
              "    " + oName + " = " + o + "," + "\n" +
              "    " + pName + " = " + p + "," + "\n" +
              "    " + qName + " = " + q + "," + "\n" +
              "    " + rName + " = " + r + "," + "\n" +
              "    " + sName + " = " + s + "," + "\n" +
              "    " + tName + " = " + t + "," + "\n" +
              "    " + uName + " = " + u + "," + "\n" +
              "    " + vName + " = " + v + "\n" +

              "  )",
            Some(ex),
            getStackDepthFun("TableDrivenPropertyChecks.scala", "forAll", 2),
            FailureMessages("undecoratedPropertyCheckFailureMessage"),
            List(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v),
            List(aName, bName, cName, dName, eName, fName, gName, hName, iName, jName, kName, lName, mName, nName, oName, pName, qName, rName, sName, tName, uName, vName),
            idx
          )
      }
    }
  }

  /**
   * A string representation of this object, which includes the heading strings as well as the rows of data.
   */
  override def toString: String = stringPrefix + "(" + heading.toString + ", " +  rows.mkString(", ") + ")"
}

/**
 * Companion object for class <code>TableFor22</code> that provides an implicit <code>canBuildFrom</code> method
 * that enables higher order functions defined on <code>TableFor22</code> to return another <code>TableFor22</code>.
 *
 * @author Bill Venners 
 */
object TableFor22 {

  /**
   * Implicit method enabling higher order functions of <code>TableFor22</code> to return sequences of type <code>TableFor22</code>.
   */
  implicit def canBuildFrom[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V]: CanBuildFrom[TableFor22[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V], (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V), TableFor22[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V]] =
    new CanBuildFrom[TableFor22[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V], (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V), TableFor22[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V]] {
      def apply(): Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V), TableFor22[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V)]) =>
          new TableFor22(("arg0","arg1","arg2","arg3","arg4","arg5","arg6","arg7","arg8","arg9","arg10","arg11","arg12","arg13","arg14","arg15","arg16","arg17","arg18","arg19","arg20","arg21"))
        }
      def apply(from: TableFor22[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V]): Builder[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V), TableFor22[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V]] =
        new ArrayBuffer mapResult { (buf: Seq[(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V)]) =>
          new TableFor22(from.heading, buf: _*)
        }
    }
}
