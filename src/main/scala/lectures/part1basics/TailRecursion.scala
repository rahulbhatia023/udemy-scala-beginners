package lectures.part1basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

object TailRecursion extends App {

  /**
   * Factorial - Tail Recursion
   * Tail Recursion uses recursive call as the last expression
   * When you need loops, use tail recursion
   */
  def factorial(n: BigInt): BigInt = {
    @tailrec
    def factorialHelper(x: BigInt, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator)
    }

    factorialHelper(n, 1)
  }

  println(factorial(5))

  // Works Fine
  println(factorial(50000))

  /**
   * Concatenate String - Tail Recursion
   */
  def concatenateString(x: String, n: Int): String = {
    @tailrec
    def concatHelper(n: Int, accumulator: String): String = {
      if (n <= 0) accumulator
      else concatHelper(n - 1, x + accumulator)
    }

    concatHelper(n, "")
  }

  println(concatenateString("Hello", 3))

  /**
   * Fibonacci - Tail Recursion
   */
  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciHelper(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fibonacciHelper(i + 1, last + nextToLast, last)
    }

    if (n <= 2) 1
    else fibonacciHelper(2, 1, 1)
  }

  println(fibonacci(7))

  /**
   * Prime Numbers - Tail Recursion
   */
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeHelper(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeHelper(t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeHelper(n / 2, isStillPrime = true)
  }

  println(isPrime(2003))
}
