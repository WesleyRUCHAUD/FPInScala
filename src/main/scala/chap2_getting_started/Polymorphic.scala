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

}
