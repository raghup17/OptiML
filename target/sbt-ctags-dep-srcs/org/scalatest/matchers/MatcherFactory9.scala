
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
 * A matcher factory that can produce a matcher given nine typeclass instances.
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
abstract class MatcherFactory9[-SC, TC1[_], TC2[_], TC3[_], TC4[_], TC5[_], TC6[_], TC7[_], TC8[_], TC9[_]] { thisMatcherFactory =>

  /**
   * Factory method that will produce a <code>Matcher[T]</code>, where <code>T</code> is a subtype of (or the same type
   * as) <code>SC</code>, given a typeclass instance for each <code>TC<em>n</em></code>
   * implicit parameter (for example, a <code>TC1[T]</code>, <code>TC2[T]</code>, <em>etc.</em>).
   */
  def matcher[T <: SC : TC1 : TC2 : TC3 : TC4 : TC5 : TC6 : TC7 : TC8 : TC9]: Matcher[T]

  /**
   * Ands this matcher factory with the passed matcher.
   */
  def and[U <: SC](rightMatcher: Matcher[U]): MatcherFactory9[U, TC1, TC2, TC3, TC4, TC5, TC6, TC7, TC8, TC9] =
    new MatcherFactory9[U, TC1, TC2, TC3, TC4, TC5, TC6, TC7, TC8, TC9] {
      def matcher[V <: U : TC1 : TC2 : TC3 : TC4 : TC5 : TC6 : TC7 : TC8 : TC9]: Matcher[V] = {
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
  def or[U <: SC](rightMatcher: Matcher[U]): MatcherFactory9[U, TC1, TC2, TC3, TC4, TC5, TC6, TC7, TC8, TC9] =
    new MatcherFactory9[U, TC1, TC2, TC3, TC4, TC5, TC6, TC7, TC8, TC9] {
      def matcher[V <: U : TC1 : TC2 : TC3 : TC4 : TC5 : TC6 : TC7 : TC8 : TC9]: Matcher[V] = {
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
  def and[U <: SC](rightMatcherFactory: MatcherFactory1[U, TC9]): MatcherFactory9[U, TC1, TC2, TC3, TC4, TC5, TC6, TC7, TC8, TC9] =
    new MatcherFactory9[U, TC1, TC2, TC3, TC4, TC5, TC6, TC7, TC8, TC9] {
      def matcher[V <: U : TC1 : TC2 : TC3 : TC4 : TC5 : TC6 : TC7 : TC8 : TC9]: Matcher[V] = {
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
  def or[U <: SC](rightMatcherFactory: MatcherFactory1[U, TC9]): MatcherFactory9[U, TC1, TC2, TC3, TC4, TC5, TC6, TC7, TC8, TC9] =
    new MatcherFactory9[U, TC1, TC2, TC3, TC4, TC5, TC6, TC7, TC8, TC9] {
      def matcher[V <: U : TC1 : TC2 : TC3 : TC4 : TC5 : TC6 : TC7 : TC8 : TC9]: Matcher[V] = {
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
                }
