
package org.scalatest.matchers

import org.scalatest.enablers._
import org.scalatest.MatchersHelper.andMatchersAndApply
import org.scalatest.MatchersHelper.orMatchersAndApply
import org.scalatest.words.MatcherWords
import scala.collection.GenTraversable
import scala.util.matching.Regex
import org.scalautils.Equality
import org.scalautils.TripleEqualsSupport.Spread
import org.scalautils.TripleEqualsSupport.TripleEqualsInvocation
import org.scalautils.Prettifier
import org.scalatest.FailureMessages
import org.scalatest.Resources
import org.scalatest.words.FullyMatchWord
import org.scalatest.words.StartWithWord
import org.scalatest.words.EndWithWord
import org.scalatest.words.IncludeWord
import org.scalatest.words.HaveWord
import org.scalatest.words.BeWord
import org.scalatest.words.NotWord
import org.scalatest.words.ContainWord
import org.scalatest.words.ResultOfLengthWordApplication
import org.scalatest.words.ResultOfSizeWordApplication
import org.scalatest.words.ResultOfMessageWordApplication
import org.scalatest.words.ResultOfLessThanComparison
import org.scalatest.words.ResultOfGreaterThanComparison
import org.scalatest.words.ResultOfLessThanOrEqualToComparison
import org.scalatest.words.ResultOfGreaterThanOrEqualToComparison
import org.scalatest.words.ResultOfAWordToSymbolApplication
import org.scalatest.words.ResultOfAWordToBePropertyMatcherApplication
import org.scalatest.words.ResultOfAWordToAMatcherApplication
import org.scalatest.words.ResultOfAnWordToSymbolApplication
import org.scalatest.words.ResultOfAnWordToBePropertyMatcherApplication
import org.scalatest.words.ResultOfAnWordToAnMatcherApplication
import org.scalatest.words.ResultOfTheSameInstanceAsApplication
import org.scalatest.words.ResultOfRegexWordApplication
import org.scalatest.words.ResultOfKeyWordApplication
import org.scalatest.words.ResultOfValueWordApplication
import org.scalatest.words.RegexWithGroups
import org.scalatest.words.ResultOfDefinedAt
import org.scalatest.words.ResultOfOneOfApplication
import org.scalatest.words.ResultOfAtLeastOneOfApplication
import org.scalatest.words.ResultOfNoneOfApplication
import org.scalatest.words.ResultOfTheSameElementsAsApplication
import org.scalatest.words.ResultOfTheSameElementsInOrderAsApplication
import org.scalatest.words.ResultOfOnlyApplication
import org.scalatest.words.ResultOfAllOfApplication
import org.scalatest.words.ResultOfInOrderOnlyApplication
import org.scalatest.words.ResultOfInOrderApplication
import org.scalatest.words.ResultOfAtMostOneOfApplication
import org.scalatest.words.SortedWord
import org.scalatest.words.ResultOfATypeInvocation
import org.scalatest.words.ResultOfAnTypeInvocation
import org.scalatest.words.ExistWord
import org.scalatest.words.ResultOfNotExist
import org.scalatest.words.ReadableWord
import org.scalatest.words.WritableWord
import org.scalatest.words.EmptyWord
import org.scalatest.words.DefinedWord

import scala.language.higherKinds

/**
 * A matcher factory that can produce a matcher given six typeclass instances.
 *
 * <p>
 * In the type parameters for this class, "<code>SC</code>" means <em>superclass</em>; "<code>TC</code>"
 * (in <code>TC1</code>, <code>TC2</code>, <em>etc.</em>) means <em>typeclass</em>.
 * This class's <code>matcher</code> factory method will produce a <code>Matcher[T]</code>, where <code>T</code> is a subtype of (or the same type
 * as) <code>SC</code>, given a typeclass instance for each <code>TC<em>n</em></code>
 * implicit parameter (for example, a <code>TC1[T]</code>, <code>TC2[T]</code>, <em>etc.</em>).
 * </p>
 *
 * @author Bill Venners
 */
// Add a TYPECLASSN for each N
abstract class MatcherFactory6[-SC, TC1[_], TC2[_], TC3[_], TC4[_], TC5[_], TC6[_]] { thisMatcherFactory =>

  /**
   * Factory method that will produce a <code>Matcher[T]</code>, where <code>T</code> is a subtype of (or the same type
   * as) <code>SC</code>, given a typeclass instance for each <code>TC<em>n</em></code>
   * implicit parameter (for example, a <code>TC1[T]</code>, <code>TC2[T]</code>, <em>etc.</em>).
   */
  def matcher[T <: SC : TC1 : TC2 : TC3 : TC4 : TC5 : TC6]: Matcher[T]

  /**
   * Ands this matcher factory with the passed matcher.
   */
  def and[U <: SC](rightMatcher: Matcher[U]): MatcherFactory6[U, TC1, TC2, TC3, TC4, TC5, TC6] =
    new MatcherFactory6[U, TC1, TC2, TC3, TC4, TC5, TC6] {
      def matcher[V <: U : TC1 : TC2 : TC3 : TC4 : TC5 : TC6]: Matcher[V] = {
        new Matcher[V] {
          def apply(left: V): MatchResult = {
            val leftMatcher = thisMatcherFactory.matcher
            andMatchersAndApply(left, leftMatcher, rightMatcher)
          }
          override def toString: String = "(" + Prettifier.default(thisMatcherFactory) + ") and (" + Prettifier.default(rightMatcher) + ")"
        }
      }
      override def toString: String = "(" + Prettifier.default(thisMatcherFactory) + ") and (" + Prettifier.default(rightMatcher) + ")"
    }

  /**
   * Ors this matcher factory with the passed matcher.
   */
  def or[U <: SC](rightMatcher: Matcher[U]): MatcherFactory6[U, TC1, TC2, TC3, TC4, TC5, TC6] =
    new MatcherFactory6[U, TC1, TC2, TC3, TC4, TC5, TC6] {
      def matcher[V <: U : TC1 : TC2 : TC3 : TC4 : TC5 : TC6]: Matcher[V] = {
        new Matcher[V] {
          def apply(left: V): MatchResult = {
            val leftMatcher = thisMatcherFactory.matcher
            orMatchersAndApply(left, leftMatcher, rightMatcher)
          }
          override def toString: String = "(" + Prettifier.default(thisMatcherFactory) + ") or (" + Prettifier.default(rightMatcher) + ")"
        }
      }
      override def toString: String = "(" + Prettifier.default(thisMatcherFactory) + ") or (" + Prettifier.default(rightMatcher) + ")"
    }

  /**
   * Ands this matcher factory with the passed <code>MatcherFactory1</code> that has the same final typeclass as this one.
   */
  def and[U <: SC](rightMatcherFactory: MatcherFactory1[U, TC6]): MatcherFactory6[U, TC1, TC2, TC3, TC4, TC5, TC6] =
    new MatcherFactory6[U, TC1, TC2, TC3, TC4, TC5, TC6] {
      def matcher[V <: U : TC1 : TC2 : TC3 : TC4 : TC5 : TC6]: Matcher[V] = {
        new Matcher[V] {
          def apply(left: V): MatchResult = {
            val leftMatcher = thisMatcherFactory.matcher
            val rightMatcher = rightMatcherFactory.matcher
            andMatchersAndApply(left, leftMatcher, rightMatcher)
          }
          override def toString: String = "(" + Prettifier.default(thisMatcherFactory) + ") and (" + Prettifier.default(rightMatcherFactory) + ")"
        }
      }
      override def toString: String = "(" + Prettifier.default(thisMatcherFactory) + ") and (" + Prettifier.default(rightMatcherFactory) + ")"
    }

  /**
   * Ors this matcher factory with the passed <code>MatcherFactory1</code> that has the same final typeclass as this one.
   */
  def or[U <: SC](rightMatcherFactory: MatcherFactory1[U, TC6]): MatcherFactory6[U, TC1, TC2, TC3, TC4, TC5, TC6] =
    new MatcherFactory6[U, TC1, TC2, TC3, TC4, TC5, TC6] {
      def matcher[V <: U : TC1 : TC2 : TC3 : TC4 : TC5 : TC6]: Matcher[V] = {
        new Matcher[V] {
          def apply(left: V): MatchResult = {
            val leftMatcher = thisMatcherFactory.matcher
            val rightMatcher = rightMatcherFactory.matcher
            orMatchersAndApply(left, leftMatcher, rightMatcher)
          }
          override def toString: String = "(" + Prettifier.default(thisMatcherFactory) + ") or (" + Prettifier.default(rightMatcherFactory) + ")"
        }
      }
      override def toString: String = "(" + Prettifier.default(thisMatcherFactory) + ") or (" + Prettifier.default(rightMatcherFactory) + ")"
    }
                

  /**
   * Ands this matcher factory with the passed matcher factory.
   */
  def and[U <: SC, TC7[_]](rightMatcherFactory: MatcherFactory1[U, TC7]): MatcherFactory7[U, TC1, TC2, TC3, TC4, TC5, TC6, TC7] =
    new MatcherFactory7[U, TC1, TC2, TC3, TC4, TC5, TC6, TC7] {
      def matcher[V <: U : TC1 : TC2 : TC3 : TC4 : TC5 : TC6 : TC7]: Matcher[V] = {
        new Matcher[V] {
          def apply(left: V): MatchResult = {
            val leftMatcher = thisMatcherFactory.matcher
            val rightMatcher = rightMatcherFactory.matcher
            andMatchersAndApply(left, leftMatcher, rightMatcher)
          }
        }
      }
    }

  /**
   * Ors this matcher factory with the passed matcher factory.
   */
  def or[U <: SC, TC7[_]](rightMatcherFactory: MatcherFactory1[U, TC7]): MatcherFactory7[U, TC1, TC2, TC3, TC4, TC5, TC6, TC7] =
    new MatcherFactory7[U, TC1, TC2, TC3, TC4, TC5, TC6, TC7] {
      def matcher[V <: U : TC1 : TC2 : TC3 : TC4 : TC5 : TC6 : TC7]: Matcher[V] = {
        new Matcher[V] {
          def apply(left: V): MatchResult = {
            val leftMatcher = thisMatcherFactory.matcher
            val rightMatcher = rightMatcherFactory.matcher
            orMatchersAndApply(left, leftMatcher, rightMatcher)
          }
        }
      }
    }


  /**
   * Ands this matcher factory with the passed matcher factory.
   */
  def and[U <: SC, TC7[_], TC8[_]](rightMatcherFactory: MatcherFactory2[U, TC7, TC8]): MatcherFactory8[U, TC1, TC2, TC3, TC4, TC5, TC6, TC7, TC8] =
    new MatcherFactory8[U, TC1, TC2, TC3, TC4, TC5, TC6, TC7, TC8] {
      def matcher[V <: U : TC1 : TC2 : TC3 : TC4 : TC5 : TC6 : TC7 : TC8]: Matcher[V] = {
        new Matcher[V] {
          def apply(left: V): MatchResult = {
            val leftMatcher = thisMatcherFactory.matcher
            val rightMatcher = rightMatcherFactory.matcher
            andMatchersAndApply(left, leftMatcher, rightMatcher)
          }
        }
      }
    }

  /**
   * Ors this matcher factory with the passed matcher factory.
   */
  def or[U <: SC, TC7[_], TC8[_]](rightMatcherFactory: MatcherFactory2[U, TC7, TC8]): MatcherFactory8[U, TC1, TC2, TC3, TC4, TC5, TC6, TC7, TC8] =
    new MatcherFactory8[U, TC1, TC2, TC3, TC4, TC5, TC6, TC7, TC8] {
      def matcher[V <: U : TC1 : TC2 : TC3 : TC4 : TC5 : TC6 : TC7 : TC8]: Matcher[V] = {
        new Matcher[V] {
          def apply(left: V): MatchResult = {
            val leftMatcher = thisMatcherFactory.matcher
            val rightMatcher = rightMatcherFactory.matcher
            orMatchersAndApply(left, leftMatcher, rightMatcher)
          }
        }
      }
    }


  /**
   * Ands this matcher factory with the passed matcher factory.
   */
  def and[U <: SC, TC7[_], TC8[_], TC9[_]](rightMatcherFactory: MatcherFactory3[U, TC7, TC8, TC9]): MatcherFactory9[U, TC1, TC2, TC3, TC4, TC5, TC6, TC7, TC8, TC9] =
    new MatcherFactory9[U, TC1, TC2, TC3, TC4, TC5, TC6, TC7, TC8, TC9] {
      def matcher[V <: U : TC1 : TC2 : TC3 : TC4 : TC5 : TC6 : TC7 : TC8 : TC9]: Matcher[V] = {
        new Matcher[V] {
          def apply(left: V): MatchResult = {
            val leftMatcher = thisMatcherFactory.matcher
            val rightMatcher = rightMatcherFactory.matcher
            andMatchersAndApply(left, leftMatcher, rightMatcher)
          }
        }
      }
    }

  /**
   * Ors this matcher factory with the passed matcher factory.
   */
  def or[U <: SC, TC7[_], TC8[_], TC9[_]](rightMatcherFactory: MatcherFactory3[U, TC7, TC8, TC9]): MatcherFactory9[U, TC1, TC2, TC3, TC4, TC5, TC6, TC7, TC8, TC9] =
    new MatcherFactory9[U, TC1, TC2, TC3, TC4, TC5, TC6, TC7, TC8, TC9] {
      def matcher[V <: U : TC1 : TC2 : TC3 : TC4 : TC5 : TC6 : TC7 : TC8 : TC9]: Matcher[V] = {
        new Matcher[V] {
          def apply(left: V): MatchResult = {
            val leftMatcher = thisMatcherFactory.matcher
            val rightMatcher = rightMatcherFactory.matcher
            orMatchersAndApply(left, leftMatcher, rightMatcher)
          }
        }
      }
    }

  /**
   * This class is part of the ScalaTest matchers DSL. Please see the documentation for <a href="../Matchers.html"><code>Matchers</code></a> for an overview of
   * the matchers DSL.
   *
   * @author Bill Venners
   */
  final class AndHaveWord {

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and have length (3 - 1)
     *                          ^
     * </pre>
     */
    def length(expectedLength: Long): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Length] = and(MatcherWords.have.length(expectedLength))

    // These guys need to generate a MatcherFactory of N+1. And it needs N-1 TC's, with the last one being Length.

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and have size (3 - 1)
     *                          ^
     * </pre>
     */
    def size(expectedSize: Long): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Size] = and(MatcherWords.have.size(expectedSize))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and have message ("A message from Mars!")
     *                          ^
     * </pre>
     */
    def message(expectedMessage: String): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Messaging] = and(MatcherWords.have.message(expectedMessage))
  }

  /**
   * This method enables the following syntax given a <code>MatcherFactory6</code>:
   *
   * <pre class="stHighlight">
   * aMatcherFactory and have size (3 - 1)
   *                     ^
   * </pre>
   */
  def and(haveWord: HaveWord): AndHaveWord = new AndHaveWord

  /**
   * This class is part of the ScalaTest matchers DSL. Please see the documentation for <a href="../Matchers.html"><code>Matchers</code></a> for an overview of
   * the matchers DSL.
   *
   * @author Bill Venners
   */
  final class AndContainWord {

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and contain (3 - 1)
     *                             ^
     * </pre>
     */
    def apply(expectedElement: Any): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Containing] = thisMatcherFactory.and(MatcherWords.contain(expectedElement))

    // And some, the ones that would by themselves already generate a Matcher, just return a MatcherFactoryN where N is the same.

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and contain key ("one")
     *                             ^
     * </pre>
     */
    def key(expectedKey: Any): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, KeyMapping] = thisMatcherFactory.and(MatcherWords.contain.key(expectedKey))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and contain value (1)
     *                             ^
     * </pre>
     */
    def value(expectedValue: Any): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, ValueMapping] = thisMatcherFactory.and(MatcherWords.contain.value(expectedValue))
    
    // And some, the ones that would by themselves already generate a Matcher, just return a MatcherFactoryN where N is the same.

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and contain theSameElementsAs List(1, 2, 3)
     *                             ^
     * </pre>
     */
    def theSameElementsAs(right: GenTraversable[_]): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Aggregating] = 
      thisMatcherFactory.and(MatcherWords.contain.theSameElementsAs(right))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and contain theSameElementsInOrderAs List(1, 2, 3)
     *                             ^
     * </pre>
     */
    def theSameElementsInOrderAs(right: GenTraversable[_]): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Sequencing] = 
      thisMatcherFactory.and(MatcherWords.contain.theSameElementsInOrderAs(right))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and contain inOrderOnly (1, 2, 3)
     *                             ^
     * </pre>
     */
    def inOrderOnly(firstEle: Any, secondEle: Any, remainingEles: Any*): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Sequencing] =
      thisMatcherFactory.and(MatcherWords.contain.inOrderOnly(firstEle, secondEle, remainingEles.toList: _*))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and contain allOf (1, 2, 3)
     *                             ^
     * </pre>
     */
    def allOf(firstEle: Any, secondEle: Any, remainingEles: Any*): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Aggregating] =
      thisMatcherFactory.and(MatcherWords.contain.allOf(firstEle, secondEle, remainingEles  .toList: _*))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and contain inOrder (1, 2, 3)
     *                             ^
     * </pre>
     */
    def inOrder(firstEle: Any, secondEle: Any, remainingEles: Any*): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Sequencing] =
      thisMatcherFactory.and(MatcherWords.contain.inOrder(firstEle, secondEle, remainingEles.toList: _*))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and contain oneOf (1, 2, 3)
     *                             ^
     * </pre>
     */
    def oneOf(firstEle: Any, secondEle: Any, remainingEles: Any*): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Containing] =
      thisMatcherFactory.and(MatcherWords.contain.oneOf(firstEle, secondEle, remainingEles.toList: _*))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and contain atLeastOneOf (1, 2, 3)
     *                             ^
     * </pre>
     */
    def atLeastOneOf(firstEle: Any, secondEle: Any, remainingEles: Any*): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Aggregating] =
      thisMatcherFactory.and(MatcherWords.contain.atLeastOneOf(firstEle, secondEle, remainingEles.toList: _*))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and contain only (1, 2, 3)
     *                             ^
     * </pre>
     */
    def only(right: Any*): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Aggregating] = 
      thisMatcherFactory.and(MatcherWords.contain.only(right.toList: _*))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and contain noneOf (1, 2, 3)
     *                             ^
     * </pre>
     */
    def noneOf(firstEle: Any, secondEle: Any, remainingEles: Any*): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Containing] =
      thisMatcherFactory.and(MatcherWords.contain.noneOf(firstEle, secondEle, remainingEles.toList: _*))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and contain atMostOneOf (1, 2, 3)
     *                             ^
     * </pre>
     */
    def atMostOneOf(firstEle: Any, secondEle: Any, remainingEles: Any*): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Aggregating] =
      thisMatcherFactory.and(MatcherWords.contain.atMostOneOf(firstEle, secondEle, remainingEles.toList: _*))
  }
    
  /**
   * This method enables the following syntax given a <code>MatcherFactory6</code>:
   *
   * <pre class="stHighlight">
   * aMatcherFactory and contain key ("one")
   *                 ^
   * </pre>
   */
  def and(containWord: ContainWord): AndContainWord = new AndContainWord
    
  /**
   * This class is part of the ScalaTest matchers DSL. Please see the documentation for <a href="../Matchers.html"><code>Matchers</code></a> for an overview of
   * the matchers DSL.
   *
   * @author Bill Venners
   */
  final class AndBeWord {

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and be a ('file)
     *                        ^
     * </pre>
     */
    def a(symbol: Symbol): MatcherFactory6[SC with AnyRef, TC1, TC2, TC3, TC4, TC5, TC6] = and(MatcherWords.be.a(symbol))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>, where <code>file</code> is a <a href="BePropertyMatcher.html"><code>BePropertyMatcher</code></a>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and be a (file)
     *                        ^
     * </pre>
     */
    def a[U](bePropertyMatcher: BePropertyMatcher[U]): MatcherFactory6[SC with AnyRef with U, TC1, TC2, TC3, TC4, TC5, TC6] = and(MatcherWords.be.a(bePropertyMatcher))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>, where <code>validNumber</code> is an <a href="AMatcher.html"><code>AMatcher</code></a>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and be a (validNumber)
     *                        ^
     * </pre>
     */
    def a[U](aMatcher: AMatcher[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] = and(MatcherWords.be.a(aMatcher))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and be an ('apple)
     *                        ^
     * </pre>
     */
    def an(symbol: Symbol): MatcherFactory6[SC with AnyRef, TC1, TC2, TC3, TC4, TC5, TC6] = and(MatcherWords.be.an(symbol))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>, where <code>apple</code> is a <a href="BePropertyMatcher.html"><code>BePropertyMatcher</code></a>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and be an (apple)
     *                        ^
     * </pre>
     */
    def an[U](bePropertyMatcher: BePropertyMatcher[U]): MatcherFactory6[SC with AnyRef with U, TC1, TC2, TC3, TC4, TC5, TC6] = and(MatcherWords.be.an(bePropertyMatcher))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>, where <code>integerNumber</code> is an <a href="AnMatcher.html"><code>AnMatcher</code></a>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and be an (integerNumber)
     *                        ^
     * </pre>
     */
    def an[U](anMatcher: AnMatcher[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] = and(MatcherWords.be.an(anMatcher))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and be theSameInstanceAs (string)
     *                        ^
     * </pre>
     */
    def theSameInstanceAs(anyRef: AnyRef): MatcherFactory6[SC with AnyRef, TC1, TC2, TC3, TC4, TC5, TC6] = and(MatcherWords.be.theSameInstanceAs(anyRef))
    
    /**
     * This method enables the following syntax, where <code>fraction</code> refers to a <code>PartialFunction</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and be definedAt (8)
     *                        ^
     * </pre>
     */
    def definedAt[A, U <: PartialFunction[A, _]](right: A): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] = and(MatcherWords.be.definedAt(right))
  }

  /**
   * This method enables the following syntax given a <code>MatcherFactory6</code>:
   *
   * <pre class="stHighlight">
   * aMatcherFactory and be a ('file)
   *                 ^
   * </pre>
   */
  def and(beWord: BeWord): AndBeWord = new AndBeWord

  /**
   * This class is part of the ScalaTest matchers DSL. Please see the documentation for <a href="../Matchers.html"><code>Matchers</code></a> for an overview of
   * the matchers DSL.
   *
   * @author Bill Venners
   */
  final class AndFullyMatchWord {

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and fullyMatch regex (decimal)
     *                                ^
     * </pre>
     */
    def regex(regexString: String): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = and(MatcherWords.fullyMatch.regex(regexString))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and fullyMatch regex (("a(b*)c" withGroup "bb"))
     *                                ^
     * </pre>
     */
    def regex(regexWithGroups: RegexWithGroups): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = and(MatcherWords.fullyMatch.regex(regexWithGroups))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and fullyMatch regex (decimalRegex)
     *                                ^
     * </pre>
     */
    def regex(regex: Regex): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = and(MatcherWords.fullyMatch.regex(regex))
  }

  /**
   * This method enables the following syntax given a <code>MatcherFactory6</code>:
   *
   * <pre class="stHighlight">
   * aMatcherFactory and fullyMatch regex (decimalRegex)
   *                 ^
   * </pre>
   */
  def and(fullyMatchWord: FullyMatchWord): AndFullyMatchWord = new AndFullyMatchWord

  /**
   * This class is part of the ScalaTest matchers DSL. Please see the documentation for <a href="../Matchers.html"><code>Matchers</code></a> for an overview of
   * the matchers DSL.
   *
   * @author Bill Venners
   */
  final class AndIncludeWord {

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and include regex (decimal)
     *                             ^
     * </pre>
     */
    def regex(regexString: String): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = and(MatcherWords.include.regex(regexString))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and include regex ("a(b*)c" withGroup "bb")
     *                             ^
     * </pre>
     */
    def regex(regexWithGroups: RegexWithGroups): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = and(MatcherWords.include.regex(regexWithGroups))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and include regex (decimalRegex)
     *                             ^
     * </pre>
     */
    def regex(regex: Regex): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = and(MatcherWords.include.regex(regex))
  }

  /**
   * This method enables the following syntax given a <code>MatcherFactory6</code>:
   *
   * <pre class="stHighlight">
   * aMatcherFactory and include regex ("wor.d")
   *                 ^
   * </pre>
   */
  def and(includeWord: IncludeWord): AndIncludeWord = new AndIncludeWord

  /**
   * This class is part of the ScalaTest matchers DSL. Please see the documentation for <a href="../Matchers.html"><code>Matchers</code></a> for an overview of
   * the matchers DSL.
   *
   * @author Bill Venners
   */
  final class AndStartWithWord {

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and startWith regex (decimal)
     *                               ^
     * </pre>
     */
    def regex(regexString: String): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = and(MatcherWords.startWith.regex(regexString))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and startWith regex ("a(b*)c" withGroup "bb")
     *                               ^
     * </pre>
     */
    def regex(regexWithGroups: RegexWithGroups): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = and(MatcherWords.startWith.regex(regexWithGroups))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and startWith regex (decimalRegex)
     *                               ^
     * </pre>
     */
    def regex(regex: Regex): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = and(MatcherWords.startWith.regex(regex))
  }

  /**
   * This method enables the following syntax given a <code>MatcherFactory6</code>:
   *
   * <pre class="stHighlight">
   * aMatcherFactory and startWith regex ("1.7")
   *                 ^
   * </pre>
   */
  def and(startWithWord: StartWithWord): AndStartWithWord = new AndStartWithWord

  /**
   * This class is part of the ScalaTest matchers DSL. Please see the documentation for <a href="../Matchers.html"><code>Matchers</code></a> for an overview of
   * the matchers DSL.
   *
   * @author Bill Venners
   */
  final class AndEndWithWord {

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and endWith regex (decimal)
     *                             ^
     * </pre>
     */
    def regex(regexString: String): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = and(MatcherWords.endWith.regex(regexString))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and endWith regex ("a(b*)c" withGroup "bb")
     *                             ^
     * </pre>
     */
    def regex(regexWithGroups: RegexWithGroups): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = and(MatcherWords.endWith.regex(regexWithGroups))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and endWith regex (decimalRegex)
     *                             ^
     * </pre>
     */
    def regex(regex: Regex): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = and(MatcherWords.endWith.regex(regex))
  }

  /**
   * This method enables the following syntax given a <code>MatcherFactory6</code>:
   *
   * <pre class="stHighlight">
   * aMatcherFactory and endWith regex (decimalRegex)
   *                 ^
   * </pre>
   */
  def and(endWithWord: EndWithWord): AndEndWithWord = new AndEndWithWord

  /**
   * This class is part of the ScalaTest matchers DSL. Please see the documentation for <a href="../Matchers.html"><code>Matchers</code></a> for an overview of
   * the matchers DSL.
   *
   * @author Bill Venners
   */
  final class AndNotWord {

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not equal (3 - 1)
     *                         ^
     * </pre>
     */
    def equal(any: Any): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Equality] =
      thisMatcherFactory.and(MatcherWords.not.apply(MatcherWords.equal(any)))

    /**
     * This method enables the following syntax, for the "primitive" numeric types:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not equal (17.0 +- 0.2)
     *                         ^
     * </pre>
     */
    def equal[U](spread: Spread[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.and(MatcherWords.not.equal(spread))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not equal (null)
     *                         ^
     * </pre>
     */
    def equal(o: Null): MatcherFactory6[SC, TC1, TC2, TC3, TC4, TC5, TC6] = {
      thisMatcherFactory and {
        new Matcher[SC] {
          def apply(left: SC): MatchResult = {
            MatchResult(
              left != null,
              Resources("equaledNull"),
              Resources("didNotEqualNull"),
              Resources("midSentenceEqualedNull"),
              Resources("didNotEqualNull"), 
              Vector.empty, 
              Vector(left)
            )
          }
          override def toString: String = "not equal null"
        }
      }
    }

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be (3 - 1)
     *                         ^
     * </pre>
     */
    def be(any: Any): MatcherFactory6[SC, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.and(MatcherWords.not.apply(MatcherWords.be(any)))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not have length (3)
     *                         ^
     * </pre>
     */
    def have(resultOfLengthWordApplication: ResultOfLengthWordApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Length] =
      thisMatcherFactory.and(MatcherWords.not.apply(MatcherWords.have.length(resultOfLengthWordApplication.expectedLength)))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not have size (3)
     *                         ^
     * </pre>
     */
    def have(resultOfSizeWordApplication: ResultOfSizeWordApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Size] =
      thisMatcherFactory.and(MatcherWords.not.apply(MatcherWords.have.size(resultOfSizeWordApplication.expectedSize)))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not have message ("Message from Mars!")
     *                         ^
     * </pre>
     */
    def have(resultOfMessageWordApplication: ResultOfMessageWordApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Messaging] =
      thisMatcherFactory.and(MatcherWords.not.apply(MatcherWords.have.message(resultOfMessageWordApplication.expectedMessage)))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not have (author ("Melville"))
     *                         ^
     * </pre>
     */
    def have[U](firstPropertyMatcher: HavePropertyMatcher[U, _], propertyMatchers: HavePropertyMatcher[U, _]*): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.and(MatcherWords.not.apply(MatcherWords.have(firstPropertyMatcher, propertyMatchers: _*)))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be &lt; (6)
     *                         ^
     * </pre>
     */
    def be[U](resultOfLessThanComparison: ResultOfLessThanComparison[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.and(MatcherWords.not.be(resultOfLessThanComparison))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be (null)
     *                         ^
     * </pre>
     */
    def be(o: Null): MatcherFactory6[SC with AnyRef, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.and(MatcherWords.not.be(o))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory (8) and not be &gt; (6)
     *                             ^
     * </pre>
     */
    def be[U](resultOfGreaterThanComparison: ResultOfGreaterThanComparison[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.and(MatcherWords.not.be(resultOfGreaterThanComparison))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be &lt;= (2)
     *                         ^
     * </pre>
     */
    def be[U](resultOfLessThanOrEqualToComparison: ResultOfLessThanOrEqualToComparison[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.and(MatcherWords.not.be(resultOfLessThanOrEqualToComparison))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be &gt;= (6)
     *                         ^
     * </pre>
     */
    def be[U](resultOfGreaterThanOrEqualToComparison: ResultOfGreaterThanOrEqualToComparison[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.and(MatcherWords.not.be(resultOfGreaterThanOrEqualToComparison))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be === (6)
     *                         ^
     * </pre>
     */
    def be(tripleEqualsInvocation: TripleEqualsInvocation[_]): MatcherFactory6[SC, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.and(MatcherWords.not.be(tripleEqualsInvocation))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be ('empty)
     *                         ^
     * </pre>
     */
    def be(symbol: Symbol): MatcherFactory6[SC with AnyRef, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.and(MatcherWords.not.be(symbol))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>, where <code>odd</code> is a <a href="BeMatcher.html"><code>BeMatcher</code></a>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be (odd)
     *                         ^
     * </pre>
     */
    def be[U](beMatcher: BeMatcher[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.and(MatcherWords.not.be(beMatcher))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>, where <code>directory</code> is a <a href="BePropertyMatcher.html"><code>BePropertyMatcher</code></a>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be (directory)
     *                         ^
     * </pre>
     */
    def be[U](bePropertyMatcher: BePropertyMatcher[U]): MatcherFactory6[SC with AnyRef with U, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.and(MatcherWords.not.be(bePropertyMatcher))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be a ('file)
     *                         ^
     * </pre>
     */
    def be(resultOfAWordApplication: ResultOfAWordToSymbolApplication): MatcherFactory6[SC with AnyRef, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.and(MatcherWords.not.be(resultOfAWordApplication))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>, where <code>validMarks</code> is an <a href="AMatcher.html"><code>AMatcher</code></a>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be a (validMarks)
     *                         ^
     * </pre>
     */
    def be[U](resultOfAWordApplication: ResultOfAWordToAMatcherApplication[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.and(MatcherWords.not.be(resultOfAWordApplication))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>, where <code>directory</code> is a <a href="BePropertyMatcher.html"><code>BePropertyMatcher</code></a>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be a (directory)
     *                         ^
     * </pre>
     */
    def be[U <: AnyRef](resultOfAWordApplication: ResultOfAWordToBePropertyMatcherApplication[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.and(MatcherWords.not.be(resultOfAWordApplication))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be a primeNumber
     *                         ^
     * </pre>
     */
    def be(resultOfAnWordApplication: ResultOfAnWordToSymbolApplication): MatcherFactory6[SC with AnyRef, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.and(MatcherWords.not.be(resultOfAnWordApplication))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>, where <code>apple</code> is a <a href="BePropertyMatcher.html"><code>BePropertyMatcher</code></a>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be an (apple)
     *                         ^
     * </pre>
     */
    def be[SC <: AnyRef](resultOfAnWordApplication: ResultOfAnWordToBePropertyMatcherApplication[SC]) = thisMatcherFactory.and(MatcherWords.not.be(resultOfAnWordApplication))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>, where <code>invalidMarks</code> is a <a href="AnMatcher.html"><code>AnMatcher</code></a>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be an (invalidMarks)
     *                         ^
     * </pre>
     */
    def be[U](resultOfAnWordApplication: ResultOfAnWordToAnMatcherApplication[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.and(MatcherWords.not.be(resultOfAnWordApplication))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be a [Book]
     *                         ^
     * </pre>
     */
    def be(aType: ResultOfATypeInvocation[_]): MatcherFactory6[SC with AnyRef, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.and(MatcherWords.not.be(aType))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be an [Apple]
     *                         ^
     * </pre>
     */
    def be(anType: ResultOfAnTypeInvocation[_]): MatcherFactory6[SC with AnyRef, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.and(MatcherWords.not.be(anType))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be theSameInstanceAs (otherString)
     *                         ^
     * </pre>
     */
    def be(resultOfTheSameInstanceAsApplication: ResultOfTheSameInstanceAsApplication): MatcherFactory6[SC with AnyRef, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.and(MatcherWords.not.be(resultOfTheSameInstanceAsApplication))

    /**
     * This method enables the following syntax, for the "primitive" numeric types:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be (17.0 +- 0.2)
     *                         ^
     * </pre>
     */
    def be[U](spread: Spread[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.and(MatcherWords.not.be(spread))
    
    /**
     * This method enables the following syntax, where <code>fraction</code> is a <code>PartialFunction</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be definedAt (8)
     *                         ^
     * </pre>
     */
    def be[A, U <: PartialFunction[A, _]](resultOfDefinedAt: ResultOfDefinedAt[A]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] = 
      thisMatcherFactory.and(MatcherWords.not.be(resultOfDefinedAt))

    /**
     * This method enables the following syntax:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be sorted
     *                         ^
     * </pre>
     */
    def be(sortedWord: SortedWord) = 
      thisMatcherFactory.and(MatcherWords.not.be(sortedWord))
    
    /**
     * This method enables the following syntax:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be readable
     *                         ^
     * </pre>
     */
    def be(readableWord: ReadableWord) = 
      thisMatcherFactory.and(MatcherWords.not.be(readableWord))
    
    /**
     * This method enables the following syntax:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be writable
     *                         ^
     * </pre>
     */
    def be(writableWord: WritableWord) = 
      thisMatcherFactory.and(MatcherWords.not.be(writableWord))
    
    /**
     * This method enables the following syntax:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be empty
     *                         ^
     * </pre>
     */
    def be(emptyWord: EmptyWord) = 
      thisMatcherFactory.and(MatcherWords.not.be(emptyWord))
    
    /**
     * This method enables the following syntax:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be defined
     *                         ^
     * </pre>
     */
    def be(definedWord: DefinedWord) = 
      thisMatcherFactory.and(MatcherWords.not.be(definedWord))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not fullyMatch regex (decimal)
     *                         ^
     * </pre>
     */
    def fullyMatch(resultOfRegexWordApplication: ResultOfRegexWordApplication): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.and(MatcherWords.not.fullyMatch(resultOfRegexWordApplication))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not include regex (decimal)
     *                         ^
     * </pre>
     */
    def include(resultOfRegexWordApplication: ResultOfRegexWordApplication): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.and(MatcherWords.not.include(resultOfRegexWordApplication))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not include ("1.7")
     *                         ^
     * </pre>
     */
    def include(expectedSubstring: String): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.and(MatcherWords.not.include(expectedSubstring))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not startWith regex (decimal)
     *                         ^
     * </pre>
     */
    def startWith(resultOfRegexWordApplication: ResultOfRegexWordApplication): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.and(MatcherWords.not.startWith(resultOfRegexWordApplication))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not startWith ("1.7")
     *                         ^
     * </pre>
     */
    def startWith(expectedSubstring: String): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.and(MatcherWords.not.startWith(expectedSubstring))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not endWith regex (decimal)
     *                         ^
     * </pre>
     */
    def endWith(resultOfRegexWordApplication: ResultOfRegexWordApplication): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.and(MatcherWords.not.endWith(resultOfRegexWordApplication))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not endWith ("1.7")
     *                         ^
     * </pre>
     */
    def endWith(expectedSubstring: String): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.and(MatcherWords.not.endWith(expectedSubstring))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not contain (3)
     *                         ^
     * </pre>
     */
    def contain[U](expectedElement: U): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Containing] =
      thisMatcherFactory.and(MatcherWords.not.contain(expectedElement))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not contain key ("three")
     *                         ^
     * </pre>
     */
    def contain(resultOfKeyWordApplication: ResultOfKeyWordApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, KeyMapping] =
      thisMatcherFactory.and(MatcherWords.not.contain(resultOfKeyWordApplication))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not contain value (3)
     *                         ^
     * </pre>
     */
    def contain(resultOfValueWordApplication: ResultOfValueWordApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, ValueMapping] =
      thisMatcherFactory.and(MatcherWords.not.contain(resultOfValueWordApplication))
      
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not contain oneOf (8, 1, 2)
     *                         ^
     * </pre>
     */
    def contain(right: ResultOfOneOfApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Containing] =
      thisMatcherFactory.and(MatcherWords.not.contain(right))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not contain atLeastOneOf (8, 1, 2)
     *                         ^
     * </pre>
     */
    def contain(right: ResultOfAtLeastOneOfApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Aggregating] =
      thisMatcherFactory.and(MatcherWords.not.contain(right))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not contain noneOf (8, 1, 2)
     *                         ^
     * </pre>
     */
    def contain(right: ResultOfNoneOfApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Containing] =
      thisMatcherFactory.and(MatcherWords.not.contain(right))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not contain theSameElementsAs (List(8, 1, 2))
     *                         ^
     * </pre>
     */
    def contain(right: ResultOfTheSameElementsAsApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Aggregating] =
      thisMatcherFactory.and(MatcherWords.not.contain(right))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not contain theSameElementsInOrderAs (List(8, 1, 2))
     *                         ^
     * </pre>
     */
    def contain(right: ResultOfTheSameElementsInOrderAsApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Sequencing] =
      thisMatcherFactory.and(MatcherWords.not.contain(right))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not contain only (8, 1, 2)
     *                         ^
     * </pre>
     */
    def contain(right: ResultOfOnlyApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Aggregating] =
      thisMatcherFactory.and(MatcherWords.not.contain(right))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not contain inOrderOnly (8, 1, 2)
     *                         ^
     * </pre>
     */
    def contain(right: ResultOfInOrderOnlyApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Sequencing] =
      thisMatcherFactory.and(MatcherWords.not.contain(right))
      
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not contain allOf (8, 1, 2)
     *                         ^
     * </pre>
     */
    def contain(right: ResultOfAllOfApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Aggregating] =
      thisMatcherFactory.and(MatcherWords.not.contain(right))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not contain inOrder (8, 1, 2)
     *                         ^
     * </pre>
     */
    def contain(right: ResultOfInOrderApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Sequencing] =
      thisMatcherFactory.and(MatcherWords.not.contain(right))
    
    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not contain atMostOneOf (8, 1, 2)
     *                         ^
     * </pre>
     */
    def contain(right: ResultOfAtMostOneOfApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Aggregating] =
      thisMatcherFactory.and(MatcherWords.not.contain(right))
  }


  /**
   * This method enables the following syntax given a <code>MatcherFactory6</code>:
   *
   * <pre class="stHighlight">
   * aMatcherFactory and not contain value (3)
   *                 ^
   * </pre>
   */
  def and(notWord: NotWord): AndNotWord = new AndNotWord

  /**
   * This method enables the following syntax:
   *
   * <pre class="stHighlight">
   * aMatcherFactory and exist
   *                 ^
   * </pre>
   */
  def and(existWord: ExistWord): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Existence] = 
    thisMatcherFactory.and(MatcherWords.exist.matcherFactory)

  /**
   * This method enables the following syntax:
   *
   * <pre class="stHighlight">
   * aMatcherFactory and not (exist)
   *                 ^
   * </pre>
   */
  def and(notExist: ResultOfNotExist): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Existence] = 
    thisMatcherFactory.and(MatcherWords.not.exist)

  /**
   * This class is part of the ScalaTest matchers DSL. Please see the documentation for <a href="../Matchers.html"><code>Matchers</code></a> for an overview of
   * the matchers DSL.
   *
   * @author Bill Venners
   */
  final class OrHaveWord {

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or have length (3 - 1)
     *                         ^
     * </pre>
     */
    def length(expectedLength: Long): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Length] = or(MatcherWords.have.length(expectedLength))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or have size (3 - 1)
     *                         ^
     * </pre>
     */
    def size(expectedSize: Long): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Size] = or(MatcherWords.have.size(expectedSize))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or have message ("Message from Mars!")
     *                         ^
     * </pre>
     */
    def message(expectedMessage: String): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Messaging] = or(MatcherWords.have.message(expectedMessage))
  }

  /**
   * This method enables the following syntax given a <code>MatcherFactory6</code>:
   *
   * <pre class="stHighlight">
   * aMatcherFactory or have size (3 - 1)
   *                 ^
   * </pre>
   */
  def or(haveWord: HaveWord): OrHaveWord = new OrHaveWord

  /**
   * This class is part of the ScalaTest matchers DSL. Please see the documentation for <a href="../Matchers.html"><code>Matchers</code></a> for an overview of
   * the matchers DSL.
   *
   * @author Bill Venners
   */
  final class OrContainWord {

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or contain (3 - 1)
     *                            ^
     * </pre>
     */
    def apply(expectedElement: Any): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Containing] = thisMatcherFactory.or(MatcherWords.contain(expectedElement))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or contain key ("one")
     *                            ^
     * </pre>
     */
    def key(expectedKey: Any): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, KeyMapping] = thisMatcherFactory.or(MatcherWords.contain.key(expectedKey))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or contain value (1)
     *                            ^
     * </pre>
     */
    def value(expectedValue: Any): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, ValueMapping] = thisMatcherFactory.or(MatcherWords.contain.value(expectedValue))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or contain theSameElementsAs List(1, 2, 3)
     *                            ^
     * </pre>
     */
    def theSameElementsAs(right: GenTraversable[_]): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Aggregating] = 
      thisMatcherFactory.or(MatcherWords.contain.theSameElementsAs(right))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or contain theSameElementsInOrderAs List(1, 2, 3)
     *                            ^
     * </pre>
     */
    def theSameElementsInOrderAs(right: GenTraversable[_]): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Sequencing] = 
      thisMatcherFactory.or(MatcherWords.contain.theSameElementsInOrderAs(right))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or contain inOrderOnly (1, 2, 3)
     *                            ^
     * </pre>
     */
    def inOrderOnly(firstEle: Any, secondEle: Any, remainingEles: Any*): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Sequencing] =
      thisMatcherFactory.or(MatcherWords.contain.inOrderOnly(firstEle, secondEle, remainingEles.toList: _*))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or contain allOf (1, 2, 3)
     *                            ^
     * </pre>
     */
    def allOf(firstEle: Any, secondEle: Any, remainingEles: Any*): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Aggregating] =
      thisMatcherFactory.or(MatcherWords.contain.allOf(firstEle, secondEle, remainingEles.toList: _*))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or contain inOrder (1, 2, 3)
     *                            ^
     * </pre>
     */
    def inOrder(firstEle: Any, secondEle: Any, remainingEles: Any*): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Sequencing] =
      thisMatcherFactory.or(MatcherWords.contain.inOrder(firstEle, secondEle, remainingEles.toList: _*))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or contain oneOf (1, 2, 3)
     *                            ^
     * </pre>
     */
    def oneOf(firstEle: Any, secondEle: Any, remainingEles: Any*): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Containing] =
      thisMatcherFactory.or(MatcherWords.contain.oneOf(firstEle, secondEle, remainingEles.toList: _*))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or contain atLeastOneOf (1, 2, 3)
     *                            ^
     * </pre>
     */
    def atLeastOneOf(firstEle: Any, secondEle: Any, remainingEles: Any*): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Aggregating] =
      thisMatcherFactory.or(MatcherWords.contain.atLeastOneOf(firstEle, secondEle, remainingEles.toList: _*))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or contain only (1, 2, 3)
     *                            ^
     * </pre>
     */
    def only(right: Any*): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Aggregating] = 
      thisMatcherFactory.or(MatcherWords.contain.only(right.toList: _*))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or contain noneOf (1, 2, 3)
     *                            ^
     * </pre>
     */
    def noneOf(firstEle: Any, secondEle: Any, remainingEles: Any*): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Containing] =
      thisMatcherFactory.or(MatcherWords.contain.noneOf(firstEle, secondEle, remainingEles.toList: _*))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or contain atMostOneOf (1, 2, 3)
     *                            ^
     * </pre>
     */
    def atMostOneOf(firstEle: Any, secondEle: Any, remainingEles: Any*): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Aggregating] =
      thisMatcherFactory.or(MatcherWords.contain.atMostOneOf(firstEle, secondEle, remainingEles.toList: _*))
  }

  /**
   * This method enables the following syntax given a <code>MatcherFactory6</code>:
   *
   * <pre class="stHighlight">
   * (aMatcherFactory or contain value (1))
   *                  ^
   * </pre>
   */
  def or(containWord: ContainWord): OrContainWord = new OrContainWord

  /**
   * This class is part of the ScalaTest matchers DSL. Please see the documentation for <a href="../Matchers.html"><code>Matchers</code></a> for an overview of
   * the matchers DSL.
   *
   * @author Bill Venners
   */
  final class OrBeWord {

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or be a ('directory)
     *                       ^
     * </pre>
     */
    def a(symbol: Symbol): MatcherFactory6[SC with AnyRef, TC1, TC2, TC3, TC4, TC5, TC6] = or(MatcherWords.be.a(symbol))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or be a (directory)
     *                       ^
     * </pre>
     */
    def a[U](bePropertyMatcher: BePropertyMatcher[U]): MatcherFactory6[SC with AnyRef with U, TC1, TC2, TC3, TC4, TC5, TC6] = or(MatcherWords.be.a(bePropertyMatcher))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or be a (validNumber)
     *                       ^
     * </pre>
     */
    def a[U](aMatcher: AMatcher[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] = or(MatcherWords.be.a(aMatcher))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or be an ('apple)
     *                       ^
     * </pre>
     */
    def an(symbol: Symbol): MatcherFactory6[SC with AnyRef, TC1, TC2, TC3, TC4, TC5, TC6] = or(MatcherWords.be.an(symbol))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>, where <code>apple</code> is a <a href="BePropertyMatcher.html"><code>BePropertyMatcher</code></a>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or be an (apple)
     *                       ^
     * </pre>
     */
    def an[U](bePropertyMatcher: BePropertyMatcher[U]): MatcherFactory6[SC with AnyRef with U, TC1, TC2, TC3, TC4, TC5, TC6] = or(MatcherWords.be.an(bePropertyMatcher))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>, where <code>integerNumber</code> is a <a href="AnMatcher.html"><code>AnMatcher</code></a>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or be an (integerNumber)
     *                       ^
     * </pre>
     */
    def an[U](anMatcher: AnMatcher[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] = or(MatcherWords.be.an(anMatcher))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or be theSameInstanceAs (otherString)
     *                       ^
     * </pre>
     */
    def theSameInstanceAs(anyRef: AnyRef): MatcherFactory6[SC with AnyRef, TC1, TC2, TC3, TC4, TC5, TC6] = or(MatcherWords.be.theSameInstanceAs(anyRef))

    /**
     * This method enables the following syntax, where <code>fraction</code> refers to a <code>PartialFunction</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or be definedAt (8)
     *                       ^
     * </pre>
     */
    def definedAt[A, U <: PartialFunction[A, _]](right: A): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] = or(MatcherWords.be.definedAt(right))
  }

  /**
   * This method enables the following syntax given a <code>MatcherFactory6</code>:
   *
   * <pre class="stHighlight">
   * aMatcherFactory or be a ('directory)
   *                 ^
   * </pre>
   */
  def or(beWord: BeWord): OrBeWord = new OrBeWord

  /**
   * This class is part of the ScalaTest matchers DSL. Please see the documentation for <a href="../Matchers.html"><code>Matchers</code></a> for an overview of
   * the matchers DSL.
   *
   * @author Bill Venners
   */
  final class OrFullyMatchWord {

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or fullyMatch regex (decimal)
     *                               ^
     * </pre>
     */
    def regex(regexString: String): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = or(MatcherWords.fullyMatch.regex(regexString))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or fullyMatch regex ("a(b*)c" withGroup "bb")
     *                               ^
     * </pre>
     */
    def regex(regexWithGroups: RegexWithGroups): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = or(MatcherWords.fullyMatch.regex(regexWithGroups))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or fullyMatch regex (decimal)
     *                               ^
     * </pre>
     */
    def regex(regex: Regex): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = or(MatcherWords.fullyMatch.regex(regex))
  }

  /**
   * This method enables the following syntax given a <code>MatcherFactory6</code>:
   *
   * <pre class="stHighlight">
   * aMatcherFactory or fullyMatch regex (decimal)
   *                 ^
   * </pre>
   */
  def or(fullyMatchWord: FullyMatchWord): OrFullyMatchWord = new OrFullyMatchWord

  /**
   * This class is part of the ScalaTest matchers DSL. Please see the documentation for <a href="../Matchers.html"><code>Matchers</code></a> for an overview of
   * the matchers DSL.
   *
   * @author Bill Venners
   */
  final class OrIncludeWord {

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or include regex (decimal)
     *                            ^
     * </pre>
     */
    def regex(regexString: String): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = or(MatcherWords.include.regex(regexString))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or include regex ("a(b*)c" withGroup "bb")
     *                            ^
     * </pre>
     */
    def regex(regexWithGroups: RegexWithGroups): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = or(MatcherWords.include.regex(regexWithGroups))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or include regex (decimal)
     *                            ^
     * </pre>
     */
    def regex(regex: Regex): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = or(MatcherWords.include.regex(regex))
  }

  /**
   * This method enables the following syntax given a <code>MatcherFactory6</code>:
   *
   * <pre class="stHighlight">
   * aMatcherFactory or include regex ("1.7")
   *                 ^
   * </pre>
   */
  def or(includeWord: IncludeWord): OrIncludeWord = new OrIncludeWord

  /**
   * This class is part of the ScalaTest matchers DSL. Please see the documentation for <a href="../Matchers.html"><code>Matchers</code></a> for an overview of
   * the matchers DSL.
   *
   * @author Bill Venners
   */
  final class OrStartWithWord {

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or startWith regex (decimal)
     *                              ^
     * </pre>
     */
    def regex(regexString: String): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = or(MatcherWords.startWith.regex(regexString))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or startWith regex ("a(b*)c" withGroup "bb")
     *                              ^
     * </pre>
     */
    def regex(regexWithGroups: RegexWithGroups): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = or(MatcherWords.startWith.regex(regexWithGroups))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or startWith regex (decimal)
     *                              ^
     * </pre>
     */
    def regex(regex: Regex): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = or(MatcherWords.startWith.regex(regex))
  }

  /**
   * This method enables the following syntax given a <code>MatcherFactory6</code>:
   *
   * <pre class="stHighlight">
   * aMatcherFactory or startWith regex ("1.7")
   *                 ^
   * </pre>
   */
  def or(startWithWord: StartWithWord): OrStartWithWord = new OrStartWithWord

  /**
   * This class is part of the ScalaTest matchers DSL. Please see the documentation for <a href="../Matchers.html"><code>Matchers</code></a> for an overview of
   * the matchers DSL.
   *
   * @author Bill Venners
   */
  final class OrEndWithWord {

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or endWith regex (decimal)
     *                            ^
     * </pre>
     */
    def regex(regexString: String): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = or(MatcherWords.endWith.regex(regexString))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or endWith regex ("d(e*)f" withGroup "ee")
     *                            ^
     * </pre>
     */
    def regex(regexWithGroups: RegexWithGroups): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = or(MatcherWords.endWith.regex(regexWithGroups))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or endWith regex (decimal)
     *                            ^
     * </pre>
     */
    def regex(regex: Regex): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] = or(MatcherWords.endWith.regex(regex))
  }

  /**
   * This method enables the following syntax given a <code>MatcherFactory6</code>:
   *
   * <pre class="stHighlight">
   * aMatcherFactory or endWith regex ("7b")
   *                 ^
   * </pre>
   */
  def or(endWithWord: EndWithWord): OrEndWithWord = new OrEndWithWord

  /**
   * This class is part of the ScalaTest matchers DSL. Please see the documentation for <a href="../Matchers.html"><code>Matchers</code></a> for an overview of
   * the matchers DSL.
   *
   * @author Bill Venners
   */
  final class OrNotWord {

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not equal (3 - 1)
     *                        ^
     * </pre>
     */
    def equal(any: Any): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Equality] =
      thisMatcherFactory.or(MatcherWords.not.apply(MatcherWords.equal(any)))

    /**
     * This method enables the following syntax for the "primitive" numeric types:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not equal (17.0 +- 0.2)
     *                        ^
     * </pre>
     */
    def equal[U](spread: Spread[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.or(MatcherWords.not.equal(spread))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not equal (null)
     *                        ^
     * </pre>
     */
    def equal(o: Null): MatcherFactory6[SC, TC1, TC2, TC3, TC4, TC5, TC6] = {
      thisMatcherFactory or {
        new Matcher[SC] {
          def apply(left: SC): MatchResult = {
            MatchResult(
              left != null,
              Resources("equaledNull"),
              Resources("didNotEqualNull"),
              Resources("midSentenceEqualedNull"),
              Resources("didNotEqualNull"), 
              Vector.empty, 
              Vector(left)
            )
          }
          override def toString: String = "not equal null"
        }
      }
    }

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be (2)
     *                        ^
     * </pre>
     */
    def be(any: Any): MatcherFactory6[SC, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.or(MatcherWords.not.apply(MatcherWords.be(any)))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not have length (3)
     *                        ^
     * </pre>
     */
    def have(resultOfLengthWordApplication: ResultOfLengthWordApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Length] =
      thisMatcherFactory.or(MatcherWords.not.apply(MatcherWords.have.length(resultOfLengthWordApplication.expectedLength)))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not have size (3)
     *                        ^
     * </pre>
     */
    def have(resultOfSizeWordApplication: ResultOfSizeWordApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Size] =
      thisMatcherFactory.or(MatcherWords.not.apply(MatcherWords.have.size(resultOfSizeWordApplication.expectedSize)))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not have message ("Message from Mars!")
     *                        ^
     * </pre>
     */
    def have(resultOfMessageWordApplication: ResultOfMessageWordApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Messaging] =
      thisMatcherFactory.or(MatcherWords.not.apply(MatcherWords.have.message(resultOfMessageWordApplication.expectedMessage)))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not have (author ("Melville"))
     *                        ^
     * </pre>
     */
    def have[U](firstPropertyMatcher: HavePropertyMatcher[U, _], propertyMatchers: HavePropertyMatcher[U, _]*): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.or(MatcherWords.not.apply(MatcherWords.have(firstPropertyMatcher, propertyMatchers: _*)))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be (null)
     *                        ^
     * </pre>
     */
    def be(o: Null): MatcherFactory6[SC with AnyRef, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.or(MatcherWords.not.be(o))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be &lt; (8)
     *                        ^
     * </pre>
     */
    def be[U](resultOfLessThanComparison: ResultOfLessThanComparison[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.or(MatcherWords.not.be(resultOfLessThanComparison))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be &gt; (6)
     *                        ^
     * </pre>
     */
    def be[U](resultOfGreaterThanComparison: ResultOfGreaterThanComparison[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.or(MatcherWords.not.be(resultOfGreaterThanComparison))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be &lt;= (2)
     *                        ^
     * </pre>
     */
    def be[U](resultOfLessThanOrEqualToComparison: ResultOfLessThanOrEqualToComparison[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.or(MatcherWords.not.be(resultOfLessThanOrEqualToComparison))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be &gt;= (6)
     *                        ^
     * </pre>
     */
    def be[U](resultOfGreaterThanOrEqualToComparison: ResultOfGreaterThanOrEqualToComparison[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.or(MatcherWords.not.be(resultOfGreaterThanOrEqualToComparison))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be === (8)
     *                        ^
     * </pre>
     */
    def be(tripleEqualsInvocation: TripleEqualsInvocation[_]): MatcherFactory6[SC, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.or(MatcherWords.not.be(tripleEqualsInvocation))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be ('empty)
     *                        ^
     * </pre>
     */
    def be(symbol: Symbol): MatcherFactory6[SC with AnyRef, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.or(MatcherWords.not.be(symbol))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>, where <code>odd</code> is a <a href="BeMatcher.html"><code>BeMatcher</code></a>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be (odd)
     *                        ^
     * </pre>
     */
    def be[U](beMatcher: BeMatcher[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.or(MatcherWords.not.be(beMatcher))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>, where <code>file</code> is a <a href="BePropertyMatcher.html"><code>BePropertyMatcher</code></a>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be (file)
     *                        ^
     * </pre>
     */
    def be[U](bePropertyMatcher: BePropertyMatcher[U]): MatcherFactory6[SC with AnyRef with U, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.or(MatcherWords.not.be(bePropertyMatcher))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be a ('file)
     *                        ^
     * </pre>
     */
    def be(resultOfAWordApplication: ResultOfAWordToSymbolApplication): MatcherFactory6[SC with AnyRef, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.or(MatcherWords.not.be(resultOfAWordApplication))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>, where <code>validMarks</code> is an <a href="AMatcher.html"><code>AMatcher</code></a>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be a (validMarks)
     *                        ^
     * </pre>
     */
    def be[U](resultOfAWordApplication: ResultOfAWordToAMatcherApplication[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.or(MatcherWords.not.be(resultOfAWordApplication))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>, where <code>file</code> is a <a href="BePropertyMatcher.html"><code>BePropertyMatcher</code></a>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be a (file)
     *                        ^
     * </pre>
     */
    def be[U <: AnyRef](resultOfAWordApplication: ResultOfAWordToBePropertyMatcherApplication[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.or(MatcherWords.not.be(resultOfAWordApplication))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be an ('apple)
     *                        ^
     * </pre>
     */
    def be(resultOfAnWordApplication: ResultOfAnWordToSymbolApplication): MatcherFactory6[SC with AnyRef, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.or(MatcherWords.not.be(resultOfAnWordApplication))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>, where <code>apple</code> is a <a href="BePropertyMatcher.html"><code>BePropertyMatcher</code></a>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be an (apple)
     *                        ^
     * </pre>
     */
    def be[U <: AnyRef](resultOfAnWordApplication: ResultOfAnWordToBePropertyMatcherApplication[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.or(MatcherWords.not.be(resultOfAnWordApplication))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>, where <code>invalidMarks</code> is an <a href="AnMatcher.html"><code>AnMatcher</code></a>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory and not be an (invalidMarks)
     *                         ^
     * </pre>
     */
    def be[U](resultOfAnWordApplication: ResultOfAnWordToAnMatcherApplication[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.or(MatcherWords.not.be(resultOfAnWordApplication))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be a [Book]
     *                        ^
     * </pre>
     */
    def be(aType: ResultOfATypeInvocation[_]): MatcherFactory6[SC with AnyRef, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.or(MatcherWords.not.be(aType))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be an [Apple]
     *                        ^
     * </pre>
     */
    def be(anType: ResultOfAnTypeInvocation[_]): MatcherFactory6[SC with AnyRef, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.or(MatcherWords.not.be(anType))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be theSameInstanceAs (string)
     *                        ^
     * </pre>
     */
    def be(resultOfTheSameInstanceAsApplication: ResultOfTheSameInstanceAsApplication): MatcherFactory6[SC with AnyRef, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.or(MatcherWords.not.be(resultOfTheSameInstanceAsApplication))

    /**
     * This method enables the following syntax for the "primitive" numeric types:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be (17.0 +- 0.2)
     *                        ^
     * </pre>
     */
    def be[U](spread: Spread[U]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] = thisMatcherFactory.or(MatcherWords.not.be(spread))

    /**
     * This method enables the following syntax, where <code>fraction</code> is a <code>PartialFunction</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be definedAt (8)
     *                        ^
     * </pre>
     */
    def be[A, U <: PartialFunction[A, _]](resultOfDefinedAt: ResultOfDefinedAt[A]): MatcherFactory6[SC with U, TC1, TC2, TC3, TC4, TC5, TC6] = 
      thisMatcherFactory.or(MatcherWords.not.be(resultOfDefinedAt))

    /**
     * This method enables the following syntax, where <code>fraction</code> is a <code>PartialFunction</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be sorted
     *                        ^
     * </pre>
     */
    def be(sortedWord: SortedWord) = 
      thisMatcherFactory.or(MatcherWords.not.be(sortedWord))

    /**
     * This method enables the following syntax:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be readable
     *                        ^
     * </pre>
     */
    def be(readableWord: ReadableWord) = 
      thisMatcherFactory.or(MatcherWords.not.be(readableWord))

    /**
     * This method enables the following syntax:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be writable
     *                        ^
     * </pre>
     */
    def be(writableWord: WritableWord) = 
      thisMatcherFactory.or(MatcherWords.not.be(writableWord))

    /**
     * This method enables the following syntax:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be empty
     *                        ^
     * </pre>
     */
    def be(emptyWord: EmptyWord) = 
      thisMatcherFactory.or(MatcherWords.not.be(emptyWord))

    /**
     * This method enables the following syntax:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not be defined
     *                        ^
     * </pre>
     */
    def be(definedWord: DefinedWord) = 
      thisMatcherFactory.or(MatcherWords.not.be(definedWord))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not fullyMatch regex (decimal)
     *                        ^
     * </pre>
     */
    def fullyMatch(resultOfRegexWordApplication: ResultOfRegexWordApplication): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.or(MatcherWords.not.fullyMatch(resultOfRegexWordApplication))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not include regex (decimal)
     *                        ^
     * </pre>
     */
    def include(resultOfRegexWordApplication: ResultOfRegexWordApplication): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.or(MatcherWords.not.include(resultOfRegexWordApplication))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not include ("1.7")
     *                        ^
     * </pre>
     */
    def include(expectedSubstring: String): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.or(MatcherWords.not.include(expectedSubstring))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not startWith regex (decimal)
     *                        ^
     * </pre>
     */
    def startWith(resultOfRegexWordApplication: ResultOfRegexWordApplication): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.or(MatcherWords.not.startWith(resultOfRegexWordApplication))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not startWith ("1.7")
     *                        ^
     * </pre>
     */
    def startWith(expectedSubstring: String): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.or(MatcherWords.not.startWith(expectedSubstring))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not endWith regex (decimal)
     *                        ^
     * </pre>
     */
    def endWith(resultOfRegexWordApplication: ResultOfRegexWordApplication): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.or(MatcherWords.not.endWith(resultOfRegexWordApplication))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not endWith ("1.7")
     *                        ^
     * </pre>
     */
    def endWith(expectedSubstring: String): MatcherFactory6[SC with String, TC1, TC2, TC3, TC4, TC5, TC6] =
      thisMatcherFactory.or(MatcherWords.not.endWith(expectedSubstring))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not contain (3)
     *                        ^
     * </pre>
     */
    def contain[U](expectedElement: U): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Containing] =
      thisMatcherFactory.or(MatcherWords.not.contain(expectedElement))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not contain key ("three")
     *                        ^
     * </pre>
     */
    def contain(resultOfKeyWordApplication: ResultOfKeyWordApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, KeyMapping] =
      thisMatcherFactory.or(MatcherWords.not.contain(resultOfKeyWordApplication))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not contain value (3)
     *                        ^
     * </pre>
     */
    def contain(resultOfValueWordApplication: ResultOfValueWordApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, ValueMapping] =
      thisMatcherFactory.or(MatcherWords.not.contain(resultOfValueWordApplication))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not contain oneOf (8, 1, 2)
     *                        ^
     * </pre>
     */
    def contain(right: ResultOfOneOfApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Containing] =
      thisMatcherFactory.or(MatcherWords.not.contain(right))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not contain atLeastOneOf (8, 1, 2)
     *                        ^
     * </pre>
     */
    def contain(right: ResultOfAtLeastOneOfApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Aggregating] =
      thisMatcherFactory.or(MatcherWords.not.contain(right))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not contain noneOf (8, 1, 2)
     *                        ^
     * </pre>
     */
    def contain(right: ResultOfNoneOfApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Containing] =
      thisMatcherFactory.or(MatcherWords.not.contain(right))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not contain theSameElementsAs (List(8, 1, 2))
     *                        ^
     * </pre>
     */
    def contain(right: ResultOfTheSameElementsAsApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Aggregating] =
      thisMatcherFactory.or(MatcherWords.not.contain(right))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not contain theSameElementsInOrderAs (List(8, 1, 2))
     *                        ^
     * </pre>
     */
    def contain(right: ResultOfTheSameElementsInOrderAsApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Sequencing] =
      thisMatcherFactory.or(MatcherWords.not.contain(right))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not contain only (8, 1, 2)
     *                        ^
     * </pre>
     */
    def contain(right: ResultOfOnlyApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Aggregating] =
      thisMatcherFactory.or(MatcherWords.not.contain(right))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not contain inOrderOnly (8, 1, 2))
     *                        ^
     * </pre>
     */
    def contain(right: ResultOfInOrderOnlyApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Sequencing] =
      thisMatcherFactory.or(MatcherWords.not.contain(right))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not contain allOf (8, 1, 2)
     *                        ^
     * </pre>
     */
    def contain(right: ResultOfAllOfApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Aggregating] =
      thisMatcherFactory.or(MatcherWords.not.contain(right))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not contain inOrder (8, 1, 2)
     *                        ^
     * </pre>
     */
    def contain(right: ResultOfInOrderApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Sequencing] =
      thisMatcherFactory.or(MatcherWords.not.contain(right))

    /**
     * This method enables the following syntax given a <code>MatcherFactory6</code>:
     *
     * <pre class="stHighlight">
     * aMatcherFactory or not contain atMostOneOf (8, 1, 2)
     *                        ^
     * </pre>
     */
    def contain(right: ResultOfAtMostOneOfApplication): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Aggregating] =
      thisMatcherFactory.or(MatcherWords.not.contain(right))
  }

  /**
   * This method enables the following syntax given a <code>MatcherFactory6</code>:
   *
   * <pre class="stHighlight">
   * aMatcherFactory or not contain value (3)
   *                 ^
   * </pre>
   */
  def or(notWord: NotWord): OrNotWord = new OrNotWord

  /**
   * This method enables the following syntax:
   *
   * <pre class="stHighlight">
   * aMatcherFactory or exist
   *                 ^
   * </pre>
   */
  def or(existWord: ExistWord): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Existence] = 
    thisMatcherFactory.or(MatcherWords.exist.matcherFactory)

  /**
   * This method enables the following syntax:
   *
   * <pre class="stHighlight">
   * aMatcherFactory or not (exist)
   *                 ^
   * </pre>
   */
  def or(notExist: ResultOfNotExist): MatcherFactory7[SC, TC1, TC2, TC3, TC4, TC5, TC6, Existence] = 
    thisMatcherFactory.or(MatcherWords.not.exist)
}

/**
 * Companion object containing an implicit method that converts a <code>MatcherFactory6</code> to a <code>Matcher</code>.
 *
 * @author Bill Venners
 */
object MatcherFactory6 {

  import scala.language.implicitConversions

  /**
   * Converts a <code>MatcherFactory6</code> to a <code>Matcher</code>.
   *
   * @param matcherFactory a MatcherFactory6 to convert
   * @return a Matcher produced by the passed MatcherFactory6
   */
  implicit def produceMatcher[SC, TC1[_], TC2[_], TC3[_], TC4[_], TC5[_], TC6[_], T <: SC : TC1 : TC2 : TC3 : TC4 : TC5 : TC6](matcherFactory: MatcherFactory6[SC, TC1, TC2, TC3, TC4, TC5, TC6]): Matcher[T] =
    matcherFactory.matcher
}
                    