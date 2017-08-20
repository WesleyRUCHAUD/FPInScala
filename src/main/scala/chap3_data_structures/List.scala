package chap3_data_structures

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]


object List {
  def sum(is: List[Int]): Int = {
    is match {
      case Nil => 0
      case Cons(h, t) => h + sum(t)
    }
  }

  def product(ds: List[Double]): Double = {
    ds match {
      case Nil => 1
      case Cons(0, _) => 0
      case Cons(h, t) => h * product(t)
    }
  }

  def apply[A](as: A*): List[A] = {
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  }
}