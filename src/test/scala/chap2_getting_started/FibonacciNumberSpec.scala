package chap2_getting_started

import org.scalatest.{Matchers, WordSpec}

class FibonacciNumberSpec extends WordSpec with Matchers {

  "Method FibonacciNumber.getFibonacciNumber" must {
    "Return an Int value" when {
      "is input is 1" in {
        withClue("Fibonacci number one must be 0") {
          FibonacciNumber.getFibonacciNumber(1) should be(0)
        }
      }
      "is input is 2" in {
        withClue("Fibonacci number two must be 1") {
          FibonacciNumber.getFibonacciNumber(2) should be(1)
        }
      }
      "is input is 3" in {
        withClue("Fibonacci number three must be 0 + 1 = 1") {
          FibonacciNumber.getFibonacciNumber(3) should be(1)
        }
      }
      "is input is 4" in {
        withClue("Fibonacci number four must be 1 + 1 = 2") {
          FibonacciNumber.getFibonacciNumber(4) should be(2)
        }
      }
      "is input is 5" in {
        withClue("Fibonacci number five must be 1 + 2 = 3") {
          FibonacciNumber.getFibonacciNumber(5) should be(3)
        }
      }
      "is input is 10" in {
        withClue("Fibonacci number one must be 13 + 21 = 34") {
          FibonacciNumber.getFibonacciNumber(10) should be(34)
        }
      }
    }
  }
}
