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
   * It does not always make sense to Pattern Match everywhere
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
