package lectures.part4pm

import scala.util.Random

object PatternMatching extends App {

  /**
   * Pattern Matching tries to match a value against multiple patterns
   * Each pattern is written in a case statement
   * Cases are match in an order
   * Looks like a Switch from the other languages
   */

  /**
   * Switch Use Case
   */
  val random = new Random()
  val x = random.nextInt(10)

  val description: String = x match {
    case 1 => "One"
    case 2 => "Two"
    case 3 => "Three"
    case _ => "Something Else"
  }

  println(x) // 2
  println(description) // Two

  /**
   * Pattern Matching can decompose values especially when used in conjunction with case classes
   * Case class has the ability to be deconstructed in pattern matching
   */
  case class Person(name: String, age: Int)

  def greeting(person: Person) = person match {
    case Person(n, a) if (a < 21) => s"Hello, my name is $n and I am $a years old and I cannot drink in US"
    case Person(n, a) => s"Hello, my name is $n and I am $a years old"
    case _ => "I don't know who I am"
  }

  println(greeting(Person("Bob", 25))) // Hello, my name is Bob and I am 25 years old
  println(greeting(Person("Mary", 20))) // Hello, my name is Mary and I am 20 years old and I cannot drink in US

  /**
   * What if no case matches ?
   */

  val number = 3
  lazy val numberDescription = number match {
    case 1 => "One"
    case 2 => "Two"
  }

  // println(numberDescription)
  // scala.MatchError: 3 (of class java.lang.Integer)

  /**
   * Type of Pattern Matching expression:
   * Compiler will unify the types for all cases and return the lowest common ancestor of all the types returned by all cases
   * In below example, one case is returning String and the other case is returning Int, so the type of numDescription will be Any as String and Int are totally unrelated
   */
  val num = 1
  val numDescription: Any = num match {
    case 1 => "One"
    case _ => 100
  }

  /**
   * Pattern Matching on sealed hierarchies
   */
  sealed class Animal

  case class Dog(breed: String) extends Animal

  case class Parrot(greet: String) extends Animal

  val animal: Animal = Dog("Terra Nova")

  // Compilation Warning: match may not be exhaustive. It would fail on pattern case: _: Animal
  animal match {
    case Dog(breed) => println(s"Matched a dog of $breed breed")
  }

  /**
   * It does not always make sense to Pattern Match everything
   * For example if we want to check if the number is even or not
   */

  val a = 5
  val isEven = a match {
    case n if (n % 2 == 0) => true
    case _ => false
  }

  // We don't need above implementation and neither the below one:
  val isEvenCondition = if (a % 2 == 0) true else false

  // The only basic simple implementation needed is:
  val isEvenNormal = a % 2 == 0
}
