package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {

  /**
   * A normal function in Scala
   */
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 23)) // hello 23


  /**
   * A parameterless function
   */
  def aParameterlessFunction: Int = 42

  println(aParameterlessFunction) // 42


  /**
   * Recursive Method - A method that calls itself
   * Always use recursion instead of loops in Scala
   */
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello ", 3)) // hellohellohello


  /**
   * Scala automatically infers the return type of functions
   * Scala needs explicit return type for recursive functions
   */
  def bFunction(a: String, b: Int) = {
    a + " " + b
  }


  /**
   * Nested Methods
   */
  def aOuterFunction(n: Int): Int = {
    def anInnerFunction(a: Int, b: Int): Int = a + b

    anInnerFunction(2, 3)
  }


  /**
   * Recursive Functions
   */
  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n - 1)
  }

  println(factorial(5)) // 120

  def fibonacci(n: Int): Int = {
    if (n <= 3) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  println(fibonacci(5)) // 3

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else (n % t) != 0 && isPrimeUntil(t - 1)
    }

    isPrimeUntil(n / 2)
  }

  println("isPrime(3): " + isPrime(3)) // true
  println("isPrime(6): " + isPrime(6)) // false
}
