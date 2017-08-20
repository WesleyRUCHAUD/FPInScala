package chap3_data_structures

import org.scalatest.{Matchers, WordSpec}

class ListSpec extends WordSpec with Matchers {

  lazy val list: List[Int] = List(1, 2, 3, 4, 5)

  "Method tail" must {
    "return a List" when {
      "is input is a non-empty list" in {
        withClue("the result must be List(2, 3, 4, 5) but it was ") {
          List.tail(list) should be(List(2, 3, 4, 5))
        }
      }
      "is input is an empty list" in {
        withClue("the result must be Nil but it was ") {
          List.tail(Nil) should be(Nil)
        }
      }
    }
  }

  "Method setHead" must {
    "return a List" when {
      "is input is a non-empty list" in {
        withClue("the result must be List(0, 2, 3, 4, 5) but it was ") {
          List.setHead(0, list) should be(List(0, 2, 3, 4, 5))
        }
      }
      "is input is an empty list" in {
        withClue("the result must be Nil but it was ") {
          List.setHead("a", Nil) should be(Nil)
        }
      }
    }
  }

  "Method drop" must {
    "return a List" when {
      "is input is 1 and a five element list" in {
        withClue("the result must be List(2, 3, 4, 5) but it was ") {
          List.drop(1, list) should be(List(2, 3, 4, 5))
        }
      }
      "is input is 5 and a five element list" in {
        withClue("the result must be Nil but it was ") {
          List.drop(5, list) should be(Nil)
        }
      }
      "is input is 10 and a five element list" in {
        withClue("the result must be Nil but it was ") {
          List.drop(10, list) should be(Nil)
        }
      }
      "is input is 0 and a five element list" in {
        withClue("the result must be List(1, 2, 3, 4, 5) but it was ") {
          List.drop(0, list) should be(list)
        }
      }
      "is input is -1 and a five element list" in {
        withClue("the result must be List(1, 2, 3, 4, 5) but it was ") {
          List.drop(-1, list) should be(list)
        }
      }
      "is input is 2 and an empty list" in {
        withClue("the result must be Nil but it was ") {
          List.drop(2, Nil) should be(Nil)
        }
      }
    }
  }

  "Method dropWhile" must {
    "return a List" when {
      "is input is _ < 3 and a five element list" in {
        withClue("the result must be List(3, 4, 5) but it was ") {
          List.dropWhile((a: Int) => a < 3, list) should be(List(3, 4, 5))
        }
      }
      "is input is _ < 5 and a five element list" in {
        withClue("the result must be List(5) but it was ") {
          List.dropWhile((a: Int) => a < 5, list) should be(List(5))
        }
      }
      "is input is _ < 10 and a five element list" in {
        withClue("the result must be Nil but it was ") {
          List.dropWhile((a: Int) => a < 10, list) should be(Nil)
        }
      }
      "is input is _ < 0 and a five element list" in {
        withClue("the result must be List(1, 2, 3, 4, 5) but it was ") {
          List.dropWhile((a: Int) => a < 0, list) should be(list)
        }
      }
      "is input is _ > 2 and a five element list" in {
        withClue("the result must be List(1, 2, 3, 4, 5) but it was ") {
          List.dropWhile((a: Int) => a > 2, list) should be(list)
        }
      }
      "is input is _ < 2 and an empty list" in {
        withClue("the result must be Nil but it was ") {
          List.dropWhile((a: Int) => a < 2, Nil) should be(Nil)
        }
      }
    }
  }
}
