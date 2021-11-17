package lectures.part1basics

object CallByValueVsCallByName extends App {

  def callByValue(x: Long): Unit = {
    println("By Value: " + x)
    println("By Value: " + x)
  }

  def callByName(x: => Long): Unit = {
    println("By Name: " + x)
    println("By Name: " + x)
  }

  callByValue(System.nanoTime())

  /**
   * By Value: 242429199205313
   * By Value: 242429199205313
   */


  callByName(System.nanoTime())

  /**
   * By Name: 242429294708940
   * By Name: 242429295456724
   */

  def infinite(): Int = 1 + infinite()

  def printFirst(x: Int, y: => Int): Unit = println(x)

  // Will fail as infinite() method will run for indefinite time and will cause stack overflow error
  // printFirst(infinite(), 34)

  // This will not fail as infinite() is called by name and since y is never used, so it will not be evaluated
  printFirst(34, infinite())
}
