package chap2_getting_started

case object Polymorphic {

  def isSorted[T](as: Array[T], ordered: (T, T) => Boolean): Boolean = {

    @annotation.tailrec
    def isNotOrdered(i: Int): Boolean = {
      if (i >= as.length) true
      else if (ordered(as(i-1), as(i))) isNotOrdered(i+1)
      else false
    }

    isNotOrdered(1)
  }

  /** Correction from https://github.com/fpinscala/fpinscala/blob/master/answers/src/main/scala/fpinscala/gettingstarted/GettingStarted.scala#L135. */
  // Exercise 2: Implement a polymorphic function to check whether
  // an `Array[A]` is sorted
  def isSortedCor[A](as: Array[A], gt: (A,A) => Boolean): Boolean = {
    @annotation.tailrec
    def go(n: Int): Boolean =
      if (n >= as.length-1) true
      else if (gt(as(n), as(n+1))) false
      else go(n+1)

    go(0)
  }
}
