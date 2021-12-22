package lectures.part3fp

import scala.annotation.tailrec

object HigherOrderFunctions extends App {

  /**
   * Let's consider the below super function:
   * The below function expects two arguments:
   *  1. Int: An Integer
   *     2. (String, (Int => Boolean)) => Int: A function which takes below 2 arguments and returns an Integer
   *     2.1 - String: A string
   *     2.2 - (Int => Boolean): A function which takes Integer as input and returns a Boolean
   *     The below function returns (Int => Int): A function which takes an integer and returns another integer
   */
  val superFunction: (Int, (String, Int => Boolean) => Int) => (Int => Int) = null

  /**
   * The functions which take a function as an argument or returns another function are known as Higher Order Functions
   */


  /**
   * Now let's consider implementing a function that applies another function n times over a value x
   * So, the method signature should look like:
   * nTimes(f, n, x), where f is a function applied, n is the frequency by which a function is applied and x is the data on which function is applied
   * nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2, f(x))
   * So, nTimes(f, n, x) = nTimes(f, n-1, f(x))
   */
  @tailrec
  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))
  }

  val adderFunction: Int => Int = x => x + 1
  println(nTimes(adderFunction, 10, 1)) // 11


  /**
   * Better Version
   */
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
    if (n <= 0) x => x
    else x => nTimesBetter(f, n - 1)(f(x))
  }

  println(nTimesBetter(adderFunction, 10)(1)) // 11

  /**
   * Curried Functions
   */
  val superAdder: Int => Int => Int = x => y => x + y
  println(superAdder(3)(4)) // 7

  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat = curriedFormatter("%4.2f")
  val preciseFormat = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI)) // 3.14
  println(preciseFormat(Math.PI)) // 3.14159265
}
