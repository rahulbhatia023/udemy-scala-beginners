package lectures.part1basics

object Recursion extends App {
  
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      val results = n * factorial(n - 1)
      results
    }
  }

  // Works Fine
  println(factorial(5)) // 120

  // StackOverflow Exception
  println(factorial(50000))
}
