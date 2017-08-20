import chap3_data_structures.{List, Cons, Nil}

val l = List(1, 2, 3, 4, 5)

val r = l match {
  case Cons(x, Cons(2, Cons(4, _))) => x
  case Nil => 42
  case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
  case Cons(h, t) => h + List.sum(t)
  case _ => 101
}