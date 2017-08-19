package chap2_getting_started

object Fibonacci {

  lazy val ErrorFibonacciNumber: Int = -1
  lazy val ErrorFibonacciSuite: String = "Calculation of Fibonacci suite impossible if the last term is a minus number or 0."

  /**
   * Two first terms of Fibonacci suite are 0 and 1.
   * Next terms are the sum of the two precedent :
   *  - Third term is the sum of First and Second terms : 0 + 1 = 1
   *  - Fourth term is the sum of Second and Third terms : 1 + 1 = 2
   */
  def getFibonacciNumber(termIndex: Int): Int = {

    @annotation.tailrec
    def sumFibonacciNumber(currentTermIndex: Int, secondToLastTermValue: Int, lastTermValue: Int): Int = {
      val currentTermValue = secondToLastTermValue + lastTermValue

      if (currentTermIndex == termIndex) currentTermValue
      else sumFibonacciNumber(currentTermIndex + 1, lastTermValue, currentTermValue)
    }

    termIndex match {
      case 1 =>
        0
      case 2 =>
        1
      case v if v > 2 =>
        sumFibonacciNumber(3, 0, 1)
      case _ =>
        ErrorFibonacciNumber
    }
  }

  def getFibonacciSuite(lastTerm: Int): String = {
    lastTerm match {
      case v if v > 0 =>
        (1 to v).toList.map(getFibonacciNumber).mkString(", ")
      case _ =>
        ErrorFibonacciSuite
    }
  }

  /** Correction from https://github.com/fpinscala/fpinscala/blob/master/answers/src/main/scala/fpinscala/gettingstarted/GettingStarted.scala#L37. */
  // Exercise 1: Write a function to compute the nth fibonacci number

  // 0 and 1 are the first two numbers in the sequence,
  // so we start the accumulators with those.
  // At every iteration, we add the two numbers to get the next one.
  def fib(n: Int): Int = {
    @annotation.tailrec
    def loop(n: Int, prev: Int, cur: Int): Int =
      if (n == 0) prev
      else loop(n - 1, cur, prev + cur)
    loop(n, 0, 1)
  }

}
