package lectures.part3fp

object CurryingFunction extends App {
  /**
   * Currying is the process of taking a function that accepts N arguments and turning it into a function that accepts N-K (N minus K) arguments
   * Missing K arguments are fixed in the resulting function
   * It’s named after Haskell Curry
   */

  /**
   * Let's consider the below example:
   */
  def someFunc(a: Int, b: String, c: Double): Unit = println(s"a: $a, b: $b, c: $c")

  someFunc(1, "str", 3.14) // a: 1, b: str, c: 3.14

  /**
   * Now, let's convert this 3 args function into 2 args function
   * Here, we have applied currying in a function
   */
  def someFuncCurried(a: Int, b: String): Double => Unit = c => println(s"a: $a, b: $b, c: $c") // a and b are remembered, only c is needed

  val f: Double => Unit = someFuncCurried(1, "str")
  f(3.14) // a: 1, b: str, c: 3.14

  /**
   * Scala has a separate syntax to ease currying
   */
  def betterWayToCurry(a: Int, b: String)(c: Double): Unit = println(s"a: $a, b: $b, c: $c")

  val f2: Double => Unit = betterWayToCurry(1, "str")
  f2(3.14) // a: 1, b: str, c: 3.14

  /**
   * We can even further increase the nesting:
   */
  def nestedCurrying(a: Int)(b: String)(c: Double): Unit = println(s"a: $a, b: $b, c: $c")

  val g1: String => Double => Unit = nestedCurrying(1) // we pass first param
  val g2: Double => Unit = g1("str") // and then second param
  g2(3.14) // and use it with third param // a: 1, b: str, c: 3.14

  /**
   * Or, you can simply call like below:
   */
  nestedCurrying(1)("str")(3.14) // a: 1, b: str, c: 3.14
}
