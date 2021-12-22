package exercises

import scala.math.Fractional.Implicits.infixFractionalOps
import scala.math.Integral.Implicits.infixIntegralOps
import scala.math.Numeric.Implicits.infixNumericOps

abstract class MyListGenerics[+A] {
  def head: A

  def tail: MyListGenerics[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyListGenerics[B]

  def printElements: String

  override def toString: String = s"[$printElements]"

  def map[B](transformer: A => B): MyListGenerics[B]

  def flatMap[B](transformer: A => MyListGenerics[B]): MyListGenerics[B]

  def filter(predicate: A => Boolean): MyListGenerics[A]

  def ++[B >: A](list: MyListGenerics[B]): MyListGenerics[B]

  def foreach(f: A => Unit): Unit

  def sort(compare: (A, A) => Int): MyListGenerics[A]

  def zipWith[B, C](list: MyListGenerics[B], zip: (A, B) => C): MyListGenerics[C]

  def fold[B](start: B)(operator: (B, A) => B): B
}

case object EmptyGenerics extends MyListGenerics[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyListGenerics[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyListGenerics[B] = ConsGenerics(element, EmptyGenerics)

  override def printElements: String = ""

  override def map[B](transformer: Nothing => B): MyListGenerics[B] = EmptyGenerics

  override def flatMap[B](transformer: Nothing => MyListGenerics[B]): MyListGenerics[B] = EmptyGenerics

  override def filter(predicate: Nothing => Boolean): MyListGenerics[Nothing] = EmptyGenerics

  override def ++[B >: Nothing](list: MyListGenerics[B]): MyListGenerics[B] = list

  override def foreach(f: Nothing => Unit): Unit = ()

  override def sort(compare: (Nothing, Nothing) => Int): MyListGenerics[Nothing] = EmptyGenerics

  override def zipWith[B, C](list: MyListGenerics[B], zip: (Nothing, B) => C): MyListGenerics[C] = {
    if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else EmptyGenerics
  }

  override def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class ConsGenerics[+A](h: A, t: MyListGenerics[A]) extends MyListGenerics[A] {
  override def head: A = h

  override def tail: MyListGenerics[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyListGenerics[B] = ConsGenerics(element, this)

  override def printElements: String =
    if (t.isEmpty) "" + h
    else s"$h ${t.printElements}"

  override def filter(predicate: A => Boolean): MyListGenerics[A] =
    if (predicate(h)) ConsGenerics(h, t.filter(predicate))
    else t.filter(predicate)

  override def map[B](transformer: A => B): MyListGenerics[B] =
    ConsGenerics(transformer(h), t.map(transformer))

  override def ++[B >: A](list: MyListGenerics[B]): MyListGenerics[B] = ConsGenerics(h, t ++ list)

  override def flatMap[B](transformer: A => MyListGenerics[B]): MyListGenerics[B] =
    transformer(h) ++ t.flatMap(transformer)

  override def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  override def sort(compare: (A, A) => Int): MyListGenerics[A] = {
    def insert(x: A, sortedList: MyListGenerics[A]): MyListGenerics[A] = {
      if (sortedList.isEmpty) new ConsGenerics(x, EmptyGenerics)
      else if (compare(x, sortedList.head) <= 0) ConsGenerics(x, sortedList)
      else ConsGenerics(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  override def zipWith[B, C](list: MyListGenerics[B], zip: (A, B) => C): MyListGenerics[C] = {
    if (list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else ConsGenerics(zip(h, list.head), t.zipWith(list.tail, zip))
  }

  override def fold[B](start: B)(operator: (B, A) => B): B = {
    t.fold(operator(start, h))(operator)
  }
}

object ListTestGenerics extends App {
  val listOfIntegers: MyListGenerics[Int] = new ConsGenerics[Int](1, new ConsGenerics[Int](2, EmptyGenerics))

  val listOfStrings: MyListGenerics[String] = new ConsGenerics[String]("Hello", new ConsGenerics[String]("Scala", EmptyGenerics))

  println(listOfIntegers.toString) // [1 2]

  println(listOfStrings.toString) // [Hello Scala]

  println(listOfIntegers.map(_ * 2)) // [2 4]

  println(listOfIntegers.filter(_ % 2 == 0)) // [2]

  println(listOfIntegers.flatMap(elem => new ConsGenerics[Int](elem, new ConsGenerics[Int](elem + 1, EmptyGenerics)))) // [1 2 2 3]

  listOfIntegers.foreach(println)

  println(listOfIntegers.sort((x: Int, y: Int) => y - x).toString) // [2 1]

  println(listOfIntegers.zipWith[String, String](listOfStrings, _ + "-" + _)) // [1-Hello 2-Scala]

  println(listOfIntegers.fold(0)(_ + _)) // 3
}