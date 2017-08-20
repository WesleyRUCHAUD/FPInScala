package chap3_data_structures

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]


object List {
  def init[A](l: List[A]): List[A] = {
    l match {
      case Nil => Nil
      case Cons(h, Cons(_, Nil)) => Cons(h, Nil)
      case Cons(h, t) => Cons(h, init(t))
    }
  }

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

  def foldRight[A,B](as: List[A], b: B)(f: (A, B) => B): B = {
    as match {
      case Nil => b
      case Cons(h, t) => f(h, foldRight(t, b)(f))
    }
  }

  def foldLeft[A,B](as: List[A], acc: B)(f: (B, A) => B): B = {
    as match {
      case Nil => acc
      case Cons(h, t) => foldLeft(t, f(acc, h))(f)
    }
  }

  def foldRightByLeft[A,B](as: List[A], acc: B)(f: (A, B) => B): B = {
    foldLeft(reverse(as), acc)((b: B, a: A) => f(a, b))
  }

  def foldLeftByRight[A,B](as: List[A], acc: B)(f: (B, A) => B): B = {
    foldRight(reverse(as), acc)((a: A, b: B) => f(b, a))
  }

  def sum(is: List[Int]): Int = {
    foldRight(is, 0)(_ + _)
  }

  def sumLeft(is: List[Int]): Int = {
    foldLeft(is, 0)(_ + _)
  }

  def product(ds: List[Double]): Double = {
    foldRight(ds, 1.0)(_ * _)
  }

  def productLeft(ds: List[Double]): Double = {
    foldLeft(ds, 1.0)(_ * _)
  }

  def append[A](l: List[A], r: List[A]): List[A] = {
    foldRight(l, r)(Cons(_, _))
  }

  def appendLeft[A](l: List[A], r: List[A]): List[A] = {
    foldLeft(reverse(l), r)((t, h) => Cons(h, t))
  }

  def length[A](as: List[A]): Int = {
    foldRight(as, 0)((_, b) => b + 1)
  }

  def lengthLeft[A](as: List[A]): Int = {
    foldLeft(as, 0)((acc, _) => acc + 1)
  }

  def reverse[A](as: List[A]): List[A] = {
    foldLeft(as, Nil: List[A])((t, h) => Cons(h, t))
  }

  def apply[A](as: A*): List[A] = {
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  }
}