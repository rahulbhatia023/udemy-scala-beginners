package lectures.part4pm

import exercises.{Cons, Empty, MyList}

object AllThePatterns extends App {

  /**
   * Constants
   */
  val x: Any = "Scala"

  val matchConstants = x match {
    case 1 => "A Number"
    case "Scala" => "The Scala"
    case true => "The truth"
    case AllThePatterns => "Singleton Object"
  }
  println(matchConstants) // The Scala


  /**
   * Match Anything
   */
  // Wildcard
  val matchAnything = x match {
    case _ => "Default"
  }
  println(matchAnything) // Default

  // Variable
  val matchAVariable = x match {
    case something => s"I found $something"
  }
  println(matchAVariable) // I found Scala


  /**
   * Tuples
   */
  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 1) => "1,1 Tuple"
    case (something, 2) => s"I found $something"
  }
  println(matchATuple) // I found 1

  val aNestedTuple = (1, (2, 3))
  val matchANestedTuple = aNestedTuple match {
    case (_, (2, something)) => s"I found $something"
  }
  println(matchANestedTuple) // I found 3


  /**
   * Case Classes - Constructor Pattern
   */
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList = aList match {
    case Empty => "Empty"
    case Cons(head, Cons(subHead, subTail)) => s"Cons with $head and $subHead"
    case Cons(head, tail) => s"Cons with $head and ${tail.head}"
  }
  println(matchAList) // Cons with 1 and 2


  /**
   * List Patterns
   */
  val aStandardList = List(1, 2, 3, 42)

  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => // Extractor
    case List(1, _*) => // List of arbitrary length
    case 1 :: List(_) => // Infix Pattern
    case List(1, 2, 3) :+ 42 => // Infix Pattern
  }


  /**
   * Type Specifier Pattern
   */
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case num: String => s"String: $num"
    case num: Int => s"Int: $num"
  }
  println(unknownMatch) // Int 2


  /**
   * Name Binding
   */
  val nameBindingMatched = aList match {
    case nonEmptyList@Cons(_, _) => // You can use nonEmptyList variable here
    case Cons(1, rest@Cons(2, _)) => // Name binding inside nested pattern
  }


  /**
   * Multi Patterns
   */
  val multiPattern = aList match {
    case Empty | Cons(_, _) => // Compound Pattern
  }


  /**
   * If guards
   */
  val a = 5
  val isEven = a match {
    case n if (n % 2 == 0) => true
    case _ => false
  }
  println(isEven) // true


  /**
   * Trick Part - Type Erasure
   */
  val numbers = List(1,2,3)

  val listMatch = numbers match {
    case list: List[String] => "List of String"
    case list: List[Int] => "List of Integers"
  }
  println(listMatch) // List of String

  /**
   * JVM was designed for java language but java language was designed for backward compatibility
   * So, a java9 jvm can run a program of java1 also
   * At java1 it did not have generics parameters, generics were introduced in java5
   * To make the jvm5 compatible with java1, java5 compiler erased all generic types after type checking
   * This makes JVM oblivious to generic types
   * Scala also suffers from this post because the jvm was designed in this way
   * So basically after type checking, our pattern match looks like:
   * numbers match {
      case list: List[String] => "List of String"
      case list: List[Int] => "List of Integers"
     }
   */
}
