package chap2_getting_started

import org.scalatest.{Matchers, WordSpec}

class PolymorphicSpec extends WordSpec with Matchers {

  lazy val arrIntSortAsc: Array[Int] = Array(1, 2, 3)
  lazy val arrStrSortAsc: Array[String] = Array("a", "b", "c")

  lazy val ascIntMatcher: (Int, Int) => Boolean = (h, t) => h < t
  lazy val descIntMatcher: (Int, Int) => Boolean = (h, t) => h > t
  lazy val ascStrMatcher: (String, String) => Boolean = (h, t) => h < t
  lazy val descStrMatcher: (String, String) => Boolean = (h, t) => h > t

  "Method Polymorphic.isSorted" must {
    "return true" when {
      "an array of Int sorted by ascending order is tested with a ascending matcher" in {
        withClue("Array[Int](1, 2, 3) tested with _ < _ must return true and not ") {
          Polymorphic.isSorted(arrIntSortAsc, ascIntMatcher)
        }
      }
      "an array of Int sorted by descending order is tested with a descending matcher" in {
        withClue("Array[Int](3, 2, 1) tested with _ > _ must return true and not ") {
          Polymorphic.isSorted(arrIntSortAsc.reverse, descIntMatcher)
        }
      }
      "an array of String sorted by ascending order is tested with a ascending matcher" in {
        withClue("Array[String](a, b, c) tested with _ < _ must return true and not ") {
          Polymorphic.isSorted(arrStrSortAsc, ascStrMatcher)
        }
      }
      "an array of String sorted by descending order is tested with a descending matcher" in {
        withClue("Array[Int](c, b, a) tested with _ > _ must return true and not ") {
          Polymorphic.isSorted(arrStrSortAsc.reverse, descStrMatcher)
        }
      }
    }
    "return false" when {
      "an array of Int sorted by descending order is tested with a ascending matcher" in {
        withClue("Array[Int](3, 2, 1) tested with _ < _ must return false and not ") {
          Polymorphic.isSorted(arrIntSortAsc.reverse, ascIntMatcher)
        }
      }
      "an array of Int sorted by ascending order is tested with a descending matcher" in {
        withClue("Array[Int](1, 2, 3) tested with _ > _ must return false and not ") {
          Polymorphic.isSorted(arrIntSortAsc, descIntMatcher)
        }
      }
    }
  }
}
