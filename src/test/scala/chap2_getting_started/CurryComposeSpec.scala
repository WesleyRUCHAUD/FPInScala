package chap2_getting_started

import org.scalatest.{Matchers, WordSpec}

class CurryComposeSpec extends WordSpec with Matchers {

  lazy val squareAndAddN: (Int, Int) => Int = (a: Int, n: Int) => a * a + n
  lazy val addTwoSquare: Int => Int => Int = (a: Int) => (b: Int) => (a * a) + (b * b)
  lazy val square: Int => Int = (a: Int) => a * a
  lazy val addTwo: Int => Int = (a: Int) => a + 2

  "Method curry" must {
    "return a function" when {
      val addSquareAndN: Int => (Int => Int) = CurryCompose.curry(squareAndAddN)

      "Function addSquareAndN" must {
        "return an int value" when {
          "is first input is 2" in {
            val addSquare2AndN: Int => Int = addSquareAndN(2)

            "is second input is 3" in {
              withClue("the result must be 7 but is ") {
                addSquare2AndN(3) should be(7)
              }
            }
            "is second input is -4" in {
              withClue("the result must be 0 but is ") {
                addSquare2AndN(-4) should be(0)
              }
            }
          }
          "is first input is 3" in {
            val addSquare3AndN: Int => Int = addSquareAndN(3)

            "is second input is 3" in {
              withClue("the result must be 12 but is ") {
                addSquare3AndN(3) should be(12)
              }
            }
            "is second input is -4" in {
              withClue("the result must be 5 but is ") {
                addSquare3AndN(-4) should be(5)
              }
            }
          }
        }
      }
    }
  }

  "Method uncurry" must {
    "return a function" when {
      val addSquareAndSquare: (Int, Int) => Int = CurryCompose.uncurry(addTwoSquare)

      "Function addSquareAndSquare" must {
        "return an int value" when {
          "is input are 2 and 3" in {
            withClue("the result must be 13 but is ") {
              addSquareAndSquare(2, 3) should be(13)
            }
          }
          "is input are 3 and 4" in {
            withClue("the result must be 25 but is ") {
              addSquareAndSquare(3, 4) should be(25)
            }
          }
        }
      }
    }
  }

  "Method compose" must {
    "return a function who add two and square" when {
      val addTwoAndSquare: Int => Int = CurryCompose.compose(addTwo, square)

      "Function addTwoAndSquare" must {
        "return an int value" when {
          "is input is -3" in {
            withClue("the result must be 1 but is ") {
              addTwoAndSquare(-3) should be(1)
            }
          }
          "is input is 0" in {
            withClue("the result must be 4 but is ") {
              addTwoAndSquare(0) should be(4)
            }
          }
          "is input is 5" in {
            withClue("the result must be 49 but is ") {
              addTwoAndSquare(5) should be(49)
            }
          }
        }
      }
    }
    "return a function who square and add two" when {
      val squareAndAddTwo: Int => Int = CurryCompose.compose(square, addTwo)

      "Function squareAndAddTwo" must {
        "return an int value" when {
          "is input is -3" in {
            withClue("the result must be 11 but is ") {
              squareAndAddTwo(-3) should be(11)
            }
          }
          "is input is 0" in {
            withClue("the result must be 2 but is ") {
              squareAndAddTwo(0) should be(2)
            }
          }
          "is input is 5" in {
            withClue("the result must be 27 but is ") {
              squareAndAddTwo(5) should be(27)
            }
          }
        }
      }
    }
  }
}
