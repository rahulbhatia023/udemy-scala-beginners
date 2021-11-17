package lectures.part1basics

import scala.annotation.tailrec

object DefaultAndNamedArgs extends App {

  /**
   * Default Arguments
   */
  @tailrec
  def factorial(n: Int, accumulator: Int = 1): Int = {
    if (n <= 1) accumulator
    else factorial(n - 1, n * accumulator)
  }

  println(factorial(5)) // 120
  println(factorial(5, 2)) // 240


  /**
   * Named Arguments
   */
  def savePicture(format: String = "jpeg", width: Int, height: Int): Unit = {
    println("Saved")
  }

  /**
   * Compilation Error: Required String, found Int
   * Compiler gets confused as it thinks we are trying to override value of format with 800
   */
  // savePicture(800, 600)


  /**
   * Solution - Below statements works fine
   */
  savePicture("jpeg", 800, 600)
  savePicture(width = 800, 600)
  savePicture(width = 800, height = 600)
  savePicture(format = "bmp", width = 800, height = 600)
}
