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
}

case object EmptyGenerics extends MyListGenerics[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyListGenerics[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyListGenerics[B] = ConsGenerics(element, EmptyGenerics)

  def printElements: String = ""

  def map[B](transformer: Nothing => B): MyListGenerics[B] = EmptyGenerics

  def flatMap[B](transformer: Nothing => MyListGenerics[B]): MyListGenerics[B] = EmptyGenerics

  def filter(predicate: Nothing => Boolean): MyListGenerics[Nothing] = EmptyGenerics

  override def ++[B >: Nothing](list: MyListGenerics[B]): MyListGenerics[B] = list
}

case class ConsGenerics[+A](h: A, t: MyListGenerics[A]) extends MyListGenerics[A] {
  def head: A = h

  def tail: MyListGenerics[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyListGenerics[B] = ConsGenerics(element, this)

  def printElements: String =
    if (t.isEmpty) "" + h
    else s"$h ${t.printElements}"

  def filter(predicate: A => Boolean): MyListGenerics[A] =
    if (predicate(h)) ConsGenerics(h, t.filter(predicate))
    else t.filter(predicate)

  def map[B](transformer: A => B): MyListGenerics[B] =
    ConsGenerics(transformer(h), t.map(transformer))

  override def ++[B >: A](list: MyListGenerics[B]): MyListGenerics[B] = ConsGenerics(h, t ++ list)

  override def flatMap[B](transformer: A => MyListGenerics[B]): MyListGenerics[B] =
    transformer(h) ++ t.flatMap(transformer)
}

object ListTestGenerics extends App {
  val listOfIntegers: MyListGenerics[Int] = new ConsGenerics[Int](1, new ConsGenerics[Int](2, new ConsGenerics[Int](3, EmptyGenerics)))
  val listOfStrings: MyListGenerics[String] = new ConsGenerics[String]("Hello", new ConsGenerics[String]("Scala", EmptyGenerics))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfIntegers.map((elem: Int) => elem * 2))

  println(listOfIntegers.filter((elem: Int) => elem % 2 == 0))

  println(listOfIntegers.flatMap((elem: Int) => new ConsGenerics[Int](elem, new ConsGenerics[Int](elem + 1, EmptyGenerics))))
}