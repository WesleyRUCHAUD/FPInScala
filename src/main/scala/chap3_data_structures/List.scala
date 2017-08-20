package chap3_data_structures

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]


object List {
  def tail[A](l: List[A]): List[A] = {
    l match {
      case Nil => Nil
      case Cons(_, t) => t
    }
  }

  def setHead[A](a: A, l: List[A]): List[A] = {
    l match {
      case Nil => Nil
      case Cons(_, t) => Cons(a, t)
    }
  }

  def drop[A](n: Int, l: List[A]): List[A] = {
    if (n <= 0) l
    else {
      l match {
        case Nil => Nil
        case Cons(_, t) => drop(n - 1, t)
      }
    }
  }

  def dropWhile[A](f: A => Boolean, l: List[A]): List[A] = {
    l match {
      case Cons(h, t) if f(h) => dropWhile(f, t)
      case _ => l
    }
  }

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