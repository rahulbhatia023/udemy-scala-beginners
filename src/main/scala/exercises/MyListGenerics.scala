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

  def map[B](transformer: MyTransformer[A, B]): MyListGenerics[B]

  def flatMap[B](transformer: MyTransformer[A, MyListGenerics[B]]): MyListGenerics[B]

  def filter(predicate: MyPredicate[A]): MyListGenerics[A]

  def ++[B >: A](list: MyListGenerics[B]): MyListGenerics[B]
}

object EmptyGenerics extends MyListGenerics[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyListGenerics[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyListGenerics[B] = new ConsGenerics(element, EmptyGenerics)

  def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): MyListGenerics[B] = EmptyGenerics

  def flatMap[B](transformer: MyTransformer[Nothing, MyListGenerics[B]]): MyListGenerics[B] = EmptyGenerics

  def filter(predicate: MyPredicate[Nothing]): MyListGenerics[Nothing] = EmptyGenerics

  override def ++[B >: Nothing](list: MyListGenerics[B]): MyListGenerics[B] = list
}

class ConsGenerics[+A](h: A, t: MyListGenerics[A]) extends MyListGenerics[A] {
  def head: A = h

  def tail: MyListGenerics[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyListGenerics[B] = new ConsGenerics(element, this)

  def printElements: String =
    if (t.isEmpty) "" + h
    else s"$h ${t.printElements}"

  def filter(predicate: MyPredicate[A]): MyListGenerics[A] =
    if (predicate.test(h)) new ConsGenerics(h, t.filter(predicate))
    else t.filter(predicate)

  def map[B](transformer: MyTransformer[A, B]): MyListGenerics[B] =
    new ConsGenerics(transformer.transform(h), t.map(transformer))

  override def ++[B >: A](list: MyListGenerics[B]): MyListGenerics[B] = new ConsGenerics(h, t ++ list)

  override def flatMap[B](transformer: MyTransformer[A, MyListGenerics[B]]): MyListGenerics[B] =
    transformer.transform(h) ++ t.flatMap(transformer)
}

trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
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