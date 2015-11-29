package scala.compat.java8.converterImpls

import language.implicitConversions

import scala.compat.java8.collectionImpl._
import scala.compat.java8.runtime._

import Stepper._

private[java8] class StepsAnyLinearSeq[A, CC >: Null <: collection.LinearSeqLike[A, CC]](_underlying: CC, _maxN: Long)
extends StepsWithTail[A, CC, StepsAnyLinearSeq[A, CC]](_underlying, _maxN) {
  protected def myIsEmpty(cc: CC): Boolean = cc.isEmpty
  protected def myTailOf(cc: CC): CC = cc.tail
  def next() = if (hasNext()) { maxN -= 1; val ans = underlying.head; underlying = underlying.tail; ans } else throwNSEE
  def semiclone(half: Int) = new StepsAnyLinearSeq[A, CC](underlying, half)
}

private[java8] class StepsDoubleLinearSeq[CC >: Null <: collection.LinearSeqLike[Double, CC]](_underlying: CC, _maxN: Long)
extends StepsDoubleWithTail[CC, StepsDoubleLinearSeq[CC]](_underlying, _maxN) {
  protected def myIsEmpty(cc: CC): Boolean = cc.isEmpty
  protected def myTailOf(cc: CC): CC = cc.tail
  def nextDouble() = if (hasNext()) { maxN -= 1; val ans = underlying.head; underlying = underlying.tail; ans } else throwNSEE
  def semiclone(half: Int) = new StepsDoubleLinearSeq[CC](underlying, half)
}

private[java8] class StepsIntLinearSeq[CC >: Null <: collection.LinearSeqLike[Int, CC]](_underlying: CC, _maxN: Long)
extends StepsIntWithTail[CC, StepsIntLinearSeq[CC]](_underlying, _maxN) {
  protected def myIsEmpty(cc: CC): Boolean = cc.isEmpty
  protected def myTailOf(cc: CC): CC = cc.tail
  def nextInt() = if (hasNext()) { maxN -= 1; val ans = underlying.head; underlying = underlying.tail; ans } else throwNSEE
  def semiclone(half: Int) = new StepsIntLinearSeq[CC](underlying, half)
}

private[java8] class StepsLongLinearSeq[CC >: Null <: collection.LinearSeqLike[Long, CC]](_underlying: CC, _maxN: Long)
extends StepsLongWithTail[CC, StepsLongLinearSeq[CC]](_underlying, _maxN) {
  protected def myIsEmpty(cc: CC): Boolean = cc.isEmpty
  protected def myTailOf(cc: CC): CC = cc.tail
  def nextLong() = if (hasNext()) { maxN -= 1; val ans = underlying.head; underlying = underlying.tail; ans } else throwNSEE
  def semiclone(half: Int) = new StepsLongLinearSeq[CC](underlying, half)
}

