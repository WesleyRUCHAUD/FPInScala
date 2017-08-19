package chap2_getting_started

object FibonacciNumber {

  def getFibonacciNumber(n: Int): Int = {

    @annotation.tailrec
    def sumFibonacciNumber(index: Int, l: Int, m: Int): Int = {
      val n0 = l + m

      if (index == n) n0
      else sumFibonacciNumber(index + 1, m, n0)
    }

    n match {
      case 1 =>
        0
      case 2 =>
        1
      case v if v > 2 =>
        sumFibonacciNumber(3, 0, 1)
      case _ =>
        -1
    }
  }

}
