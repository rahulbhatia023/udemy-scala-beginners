package lectures.part3fp

import exercises.MyList

object ForComprehension extends App {

  val numbers = List(1, 2, 3, 4, 5)
  val chars = List('A', 'B', 'C', 'D', 'E')

  /**
   * Write a function that will return all possible combinations of elements from numbers and chars lists
   * Expected Output: List(A-1, B-1, C-1, D-1, E-1, A-2, B-2, C-2, D-2, E-2, A-3, B-3, C-3, D-3, E-3, A-4, B-4, C-4,
   * D-4, E-4, A-5, B-5, C-5, D-5, E-5)
   */

  /**
   * Traditional Approach
   */
  var combinations = List.empty[String]
  numbers.foreach(number => {
    chars.foreach(char => {
      combinations = combinations :+ "" + char + "-" + number
    })
  })
  println(combinations)


  /**
   * Functional Programming Approach
   */
  println(numbers.flatMap(number => chars.map(char => "" + char + "-" + number)))

  // =======================================================================

  /**
   * Now there comes one more list of colours
   */
  val colours = List("Black", "White")

  /**
   * Write a function that will return all possible combinations of elements from numbers, chars and colours lists
   * Expected Output: List(A-1-Black, A-1-White, B-1-Black, B-1-White, C-1-Black, C-1-White, D-1-Black, D-1-White,
   * E-1-Black, E-1-White, A-2-Black, A-2-White, B-2-Black, B-2-White, C-2-Black, C-2-White, D-2-Black, D-2-White,
   * E-2-Black, E-2-White, A-3-Black, A-3-White, B-3-Black, B-3-White, C-3-Black, C-3-White, D-3-Black, D-3-White,
   * E-3-Black, E-3-White, A-4-Black, A-4-White, B-4-Black, B-4-White, C-4-Black, C-4-White, D-4-Black, D-4-White,
   * E-4-Black, E-4-White, A-5-Black, A-5-White, B-5-Black, B-5-White, C-5-Black, C-5-White, D-5-Black, D-5-White,
   * E-5-Black, E-5-White)
   */

  /**
   * Traditional Approach
   */
  var newCombinations = List.empty[String]
  numbers.foreach(number => {
    chars.foreach(char => {
      colours.foreach(colour => {
        newCombinations = newCombinations :+ "" + char + "-" + number + "-" + colour
      })
    })
  })
  println(newCombinations)


  /**
   * Functional Programming Approach
   */
  println(numbers.flatMap(number => chars.flatMap(char => colours.map(colour => "" + char + "-" + number + "-" + colour))))

  // =======================================================================

  /**
   * FOR COMPREHENSION:
   * The above code can be written in a much simpler way like below using for comprehension
   */
  val forCombinations = for {
    number <- numbers
    char <- chars
    colour <- colours
  } yield "" + char + "-" + number + "-" + colour

  println(forCombinations)

  /**
   * Now suppose we want to include only even numbers in combinations, then below are two possible solutions:
   */

  // Solution-1
  println(numbers.filter(_ % 2 == 0).flatMap(number => chars.flatMap(char => colours.map(colour => "" + char + "-" + number + "-" + colour))))

  // Solution-2
  val forEvenCombinations = for {
    number <- numbers if (number % 2 == 0)
    char <- chars
    colour <- colours
  } yield "" + char + "-" + number + "-" + colour

  println(forEvenCombinations)

  /**
   * Note: In order to work with for comprehensions, your lists should have implemented map, flatmap and filter methods as per below signature:
   *
   * def map[B](f: A => B): MyList[B]
   * def flatMap[B](f: A => MyList[B]): MyList[B]
   * def filter(f: A => Boolean): MyList[A]
   */
}
