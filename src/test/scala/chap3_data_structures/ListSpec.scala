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

  "Method init" must {
    "return a List" when {
      "is input is a non-empty list" in {
        withClue("the result must be List(1, 2, 3, 4) but it was ") {
          List.init(list) should be(List(1, 2, 3, 4))
        }
      }
      "is input is an empty list" in {
        withClue("the result must be Nil but it was ") {
          List.init(Nil) should be(Nil)
        }
      }
    }
  }

  "Method sum" must {
    "return an int value" when {
      "is input is a five int list" in {
        withClue("the result must be 15 but it was ") {
          List.sum(list) should be(15)
        }
      }
      "is input is an empty list" in {
        withClue("the result must be 0 but it was ") {
          List.sum(Nil) should be(0)
        }
      }
    }
  }

  "Method sumLeft" must {
    "return an int value" when {
      "is input is a five int list" in {
        withClue("the result must be 15 but it was ") {
          List.sumLeft(list) should be(15)
        }
      }
      "is input is an empty list" in {
        withClue("the result must be 0 but it was ") {
          List.sumLeft(Nil) should be(0)
        }
      }
    }
  }

  "Method product" must {
    "return a double value" when {
      "is input is a five double list" in {
        withClue("the result must be 120 but it was ") {
          List.product(List(1.0, 2.0, 3.0, 4.0, 5.0)) should be(120.0)
        }
      }
      "is input is an empty list" in {
        withClue("the result must be 1 but it was ") {
          List.product(Nil) should be(1.0)
        }
      }
      "is input is a five double list with one 0" in {
        withClue("the result must be 0 but it was ") {
          List.product(List(1.0, 2.0, 0.0, 4.0, 5.0)) should be(0.0)
        }
      }
    }
  }

  "Method productLeft" must {
    "return a double value" when {
      "is input is a five double list" in {
        withClue("the result must be 120 but it was ") {
          List.productLeft(List(1.0, 2.0, 3.0, 4.0, 5.0)) should be(120.0)
        }
      }
      "is input is an empty list" in {
        withClue("the result must be 1 but it was ") {
          List.productLeft(Nil) should be(1.0)
        }
      }
      "is input is a five double list with one 0" in {
        withClue("the result must be 0 but it was ") {
          List.productLeft(List(1.0, 2.0, 0.0, 4.0, 5.0)) should be(0.0)
        }
      }
    }
  }

  "Method foldRight" must {
    "return a list" when {
      "is input are a list and Nil and the function is Cons" in {
        withClue("the result must be List(1, 2, 3) but was ") {
          List.foldRight(List(1, 2, 3), Nil: List[Int])(Cons(_, _)) should be(List(1, 2, 3))
        }
      }
    }
  }

  "Method foldRightByLeft" must {
    "return a list" when {
      "is input are a list and Nil and the function is Cons" in {
        withClue("the result must be List(1, 2, 3) but was ") {
          List.foldRightByLeft(List(1, 2, 3), Nil: List[Int])(Cons(_, _)) should be(List(1, 2, 3))
        }
      }
    }
  }

  "Method foldLeft" must {
    "return a list" when {
      "is input are a list and Nil and the function is Cons" in {
        withClue("the result must be List(3, 2, 1) but was ") {
          List.foldLeft(List(1, 2, 3), Nil: List[Int])((t, h) => Cons(h, t)) should be(List(3, 2, 1))
        }
      }
      "is input is a five int list and 0 and the function is _ + _" in {
        withClue("the result must be 15 but it was ") {
          List.foldLeft(list, 0)(_ + _) should be(15)
        }
      }
    }
  }

  "Method foldLeftByRight" must {
    "return a list" when {
      "is input are a list and Nil and the function is Cons" in {
        withClue("the result must be List(3, 2, 1) but was ") {
          List.foldLeftByRight(List(1, 2, 3), Nil: List[Int])((t, h) => Cons(h, t)) should be(List(3, 2, 1))
        }
      }
      "is input is a five int list and 0 and the function is _ + _" in {
        withClue("the result must be 15 but it was ") {
          List.foldLeftByRight(list, 0)(_ + _) should be(15)
        }
      }
    }
  }

  "Method length" must {
    "return an int value" when {
      "is input is a five int list" in {
        withClue("the result must be 5 but it was ") {
          List.length(list) should be(5)
        }
      }
      "is input is a 3 string list" in {
        withClue("the result must be 3 but it was ") {
          List.length(List("a", "b", "c")) should be(3)
        }
      }
      "is input is a empty list" in {
        withClue("the result must be 0 but it was ") {
          List.length(Nil) should be(0)
        }
      }
    }
  }

  "Method lengthLeft" must {
    "return an int value" when {
      "is input is a five int list" in {
        withClue("the result must be 5 but it was ") {
          List.lengthLeft(list) should be(5)
        }
      }
      "is input is a 3 string list" in {
        withClue("the result must be 3 but it was ") {
          List.lengthLeft(List("a", "b", "c")) should be(3)
        }
      }
      "is input is a empty list" in {
        withClue("the result must be 0 but it was ") {
          List.lengthLeft(Nil) should be(0)
        }
      }
    }
  }

  "Method reverse" must {
    "return a list" when {
      "is input is a five int list" in {
        withClue("The result must be List(5, 4, 3, 2, 1) but was ") {
          List.reverse(list)
        }
      }
      "is input is an empty list" in {
        withClue("The result must be Nil but was ") {
          List.reverse(Nil)
        }
      }
    }
  }

  "Method append" must {
    "return a list" when {
      "is input are two non-empty list" in {
        withClue("The result must be List(1, 2, 3, 4, 5) but was ") {
          List.append(List(1, 2), List(3, 4, 5)) should be(list)
        }
      }
      "is input are a non-empty and an empty list" in {
        withClue("The result must be List(1, 2) but was ") {
          List.append(List(1, 2), Nil) should be(List(1, 2))
        }
      }
      "is input are an empty list and a non-empty list" in {
        withClue("The result must be List(1, 2, 3, 4, 5) but was ") {
          List.append(Nil, List(3, 4, 5)) should be(List(3, 4, 5))
        }
      }
      "is input are two empty list" in {
        withClue("The result must be Nil but was ") {
          List.append(Nil, Nil) should be(Nil)
        }
      }
    }
  }

  "Method appendLeft" must {
    "return a list" when {
      "is input are two non-empty list" in {
        withClue("The result must be List(1, 2, 3, 4, 5) but was ") {
          List.appendLeft(List(1, 2), List(3, 4, 5)) should be(list)
        }
      }
      "is input are a non-empty and an empty list" in {
        withClue("The result must be List(1, 2) but was ") {
          List.appendLeft(List(1, 2), Nil) should be(List(1, 2))
        }
      }
      "is input are an empty list and a non-empty list" in {
        withClue("The result must be List(1, 2, 3, 4, 5) but was ") {
          List.appendLeft(Nil, List(3, 4, 5)) should be(List(3, 4, 5))
        }
      }
      "is input are two empty list" in {
        withClue("The result must be Nil but was ") {
          List.appendLeft(Nil, Nil) should be(Nil)
        }
      }
    }
  }

  "Method flatten" must {
    "return a list" when {
      "is input is a five non-empty list list" in {
        withClue("The result must be List(1, 2, 3, 4, 5) but it was ") {
          List.flatten(List(List(1, 2), List(3), List(4, 5))) should be(list)
        }
      }
    }
  }
}
