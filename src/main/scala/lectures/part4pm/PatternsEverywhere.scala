package lectures.part4pm

object PatternsEverywhere extends App {

  /**
   * Try-Catch
   */
  try {
    // code
  } catch {
    case e: RuntimeException => "Runtime"
    case npe: NullPointerException => "NullPointerException"
    case _ => "Something Else"
  }

  /*
  try {
    // code
  } catch(e) {
    e match {
      case e: RuntimeException => "Runtime"
      case npe: NullPointerException => "NullPointerException"
      case _ => "Something Else"
    }
  }
   */


  /**
   * For Comprehension
   * All generators are based on Pattern Matching
   */
  val list = List(1, 2, 3, 4)
  val evenOnes = for {
    x <- list if x % 2 == 0
  } yield {
    10 * x
  }

  val tuples = List((1, 2), (3, 4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield {
    first * second
  }


  /**
   * Multiple value definitions are based on Pattern Matching
   */
  val tuple = (1, 2, 3)
  val (a, b, c) = tuple

  println(a) // 1
  println(b) // 2
  println(c) // 3

  val head :: tail = list
  println(head) // 1
  println(tail) // List(2, 3, 4)


  /**
   * Partial Functions
   */
  val mappedList = list.map {
    case x if x % 2 == 0 => "Even"
    case _ => "Odd"
  }
  println(mappedList) // List(Odd, Even, Odd, Even)

  // Equivalent Code to above implementation
  val equivalentMappedList = list.map { num =>
    num match {
      case x if x % 2 == 0 => "Even"
      case _ => "Odd"
    }
  }
}
