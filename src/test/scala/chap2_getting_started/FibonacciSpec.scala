package chap2_getting_started

import org.scalatest.{Matchers, WordSpec}

class FibonacciSpec extends WordSpec with Matchers {

  "Method FibonacciNumber.getFibonacciNumber" must {
    "Return an Int value" when {
      "is input is -1" in {
        withClue("Fibonacci number minus one must be an error but was ") {
          Fibonacci.getFibonacciNumber(-1) should be(Fibonacci.ErrorFibonacciNumber)
        }
      }
      "is input is 0" in {
        withClue("Fibonacci number zero must be 0 but was ") {
          Fibonacci.getFibonacciNumber(0) should be(0)
        }
      }
      "is input is 1" in {
        withClue("Fibonacci number one must be 1 but was ") {
          Fibonacci.getFibonacciNumber(1) should be(1)
        }
      }
      "is input is 2" in {
        withClue("Fibonacci number two must be 0 + 1 = 1 but was ") {
          Fibonacci.getFibonacciNumber(2) should be(1)
        }
      }
      "is input is 3" in {
        withClue("Fibonacci number three must be 1 + 1 = 2 but was ") {
          Fibonacci.getFibonacciNumber(3) should be(2)
        }
      }
      "is input is 4" in {
        withClue("Fibonacci number four must be 1 + 2 = 3 but was ") {
          Fibonacci.getFibonacciNumber(4) should be(3)
        }
      }
      "is input is 5" in {
        withClue("Fibonacci number five must be 2 + 3 = 5 but was ") {
          Fibonacci.getFibonacciNumber(5) should be(5)
        }
      }
      "is input is 10" in {
        withClue("Fibonacci number one must be 21 + 34 = 55 but was ") {
          Fibonacci.getFibonacciNumber(10) should be(55)
        }
      }
    }
  }

  "Method FibonacciNumber.getFibonacciSuite" must {
    "Return a String" when {
      "is input is -1 with fct Fibonacci.getFibonacciNumber" in {
        withClue("Fibonacci suite must be an error if the last term is minus one but was ") {
          Fibonacci.getFibonacciSuite(-1, Fibonacci.getFibonacciNumber) should be(Fibonacci.ErrorFibonacciSuite)
        }
      }
      "is input is -1 with fct Fibonacci.fib" in {
        withClue("Fibonacci suite must be an error if the last term is minus one but was ") {
          Fibonacci.getFibonacciSuite(-1, Fibonacci.fib) should be(Fibonacci.ErrorFibonacciSuite)
        }
      }
      "is input is 0 with fct Fibonacci.getFibonacciNumber" in {
        withClue("Fibonacci suite must be 0 but was ") {
          Fibonacci.getFibonacciSuite(0, Fibonacci.getFibonacciNumber) should be("0")
        }
      }
      "is input is 1 with fct Fibonacci.getFibonacciNumber" in {
        withClue("Fibonacci suite must be 0, 1 but was ") {
          Fibonacci.getFibonacciSuite(1, Fibonacci.getFibonacciNumber) should be("0, 1")
        }
      }
      "is input is 2 with fct Fibonacci.getFibonacciNumber" in {
        withClue("Fibonacci suite must be 0, 1, 1 but was ") {
          Fibonacci.getFibonacciSuite(2, Fibonacci.getFibonacciNumber) should be("0, 1, 1")
        }
      }
      "is input is 3 with fct Fibonacci.getFibonacciNumber" in {
        withClue("Fibonacci suite must be 0, 1, 1, 2 but was ") {
          Fibonacci.getFibonacciSuite(3, Fibonacci.getFibonacciNumber) should be("0, 1, 1, 2")
        }
      }
      "is input is 4 with fct Fibonacci.getFibonacciNumber" in {
        withClue("Fibonacci suite must be 0, 1, 1, 2, 3 but was ") {
          Fibonacci.getFibonacciSuite(4, Fibonacci.getFibonacciNumber) should be("0, 1, 1, 2, 3")
        }
      }
      "is input is 5 with fct Fibonacci.getFibonacciNumber" in {
        withClue("Fibonacci suite must be 0, 1, 1, 2, 3, 5 but was ") {
          Fibonacci.getFibonacciSuite(5, Fibonacci.getFibonacciNumber) should be("0, 1, 1, 2, 3, 5")
        }
      }
      "is input is 10 with fct Fibonacci.getFibonacciNumber" in {
        withClue("Fibonacci suite must be 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 but was ") {
          Fibonacci.getFibonacciSuite(10, Fibonacci.getFibonacciNumber) should be("0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55")
        }
      }
      "is input is 10 with fct Fibonacci.fib" in {
        withClue("Fibonacci suite must be 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 but was ") {
          Fibonacci.getFibonacciSuite(10, Fibonacci.fib) should be("0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55")
        }
      }
    }
  }

  /*
   * Method FibonacciNumber.fib from Correction has not the same behaviour that FibonacciNumber.getFibonacciNumber :
   *  > She don't manage minus number
   */
  "Method FibonacciNumber.fib" must {
    "Return an Int value" when {
      "is input is -1" ignore {
        withClue("Fibonacci number minus one must be -1 but was ") {
          Fibonacci.fib(-1) should be(-1)
        }
      }
      "is input is 0" in {
        withClue("Fibonacci number zero must be 0 but was ") {
          Fibonacci.fib(0) should be(0)
        }
      }
      "is input is 1" in {
        withClue("Fibonacci number one must be 1 but was ") {
          Fibonacci.fib(1) should be(1)
        }
      }
      "is input is 2" in {
        withClue("Fibonacci number two must be 0 + 1 = 1 but was ") {
          Fibonacci.fib(2) should be(1)
        }
      }
      "is input is 3" in {
        withClue("Fibonacci number three must be 1 + 1 = 2 but was ") {
          Fibonacci.fib(3) should be(2)
        }
      }
      "is input is 4" in {
        withClue("Fibonacci number four must be 1 + 2 = 3 but was ") {
          Fibonacci.fib(4) should be(3)
        }
      }
      "is input is 5" in {
        withClue("Fibonacci number five must be 2 + 3 = 5 but was ") {
          Fibonacci.fib(5) should be(5)
        }
      }
      "is input is 10" in {
        withClue("Fibonacci number one must be 21 + 34 = 55 but was ") {
          Fibonacci.fib(10) should be(55)
        }
      }
    }
  }
}
