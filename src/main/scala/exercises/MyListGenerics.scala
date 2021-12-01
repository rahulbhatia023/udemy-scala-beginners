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
}

object EmptyGenerics extends MyListGenerics[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyListGenerics[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyListGenerics[B] = new ConsGenerics(element, EmptyGenerics)

  def printElements: String = ""
}

class ConsGenerics[+A](h: A, t: MyListGenerics[A]) extends MyListGenerics[A] {
  def head: A = h

  def tail: MyListGenerics[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyListGenerics[B] = new ConsGenerics(element, this)

  def printElements: String =
    if (t.isEmpty) "" + h
    else s"$h ${t.printElements}"
}

object ListTestGenerics extends App {
  val listOfIntegers: MyListGenerics[Int] = new ConsGenerics[Int](1, new ConsGenerics[Int](2, new ConsGenerics[Int](3, EmptyGenerics)))
  val listOfStrings: MyListGenerics[String] = new ConsGenerics[String]("Hello", new ConsGenerics[String]("Scala", EmptyGenerics))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
}