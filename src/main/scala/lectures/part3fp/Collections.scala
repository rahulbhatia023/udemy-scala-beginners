package lectures.part3fp

import scala.util.Random

object Collections extends App {
  /**
   * Sequence
   */
  val aSequence: Seq[Int] = Seq(1, 2, 3, 4, 5)

  println(aSequence) // List(1, 2, 3, 4, 5)
  println(aSequence.reverse) // List(5, 4, 3, 2, 1)
  println(aSequence(2)) // 3
  println(aSequence ++ Seq(6, 7, 8)) // List(1, 2, 3, 4, 5, 6, 7, 8)
  println(Seq(2, 1, 4, 3, 5).sorted) // List(1, 2, 3, 4, 5)


  /**
   * Range
   */
  val rangeIncl: Seq[Int] = Range.inclusive(1, 10)
  println(rangeIncl.mkString(",")) // 1,2,3,4,5,6,7,8,9,10

  val rangeExcl: Seq[Int] = Range(1, 10)
  println(rangeExcl.mkString(",")) // 1,2,3,4,5,6,7,8,9

  val rangeTo: Seq[Int] = 1 to 10
  println(rangeTo.mkString(",")) // 1,2,3,4,5,6,7,8,9,10

  val rangeUntil: Seq[Int] = 1 until 10
  println(rangeUntil.mkString(",")) // 1,2,3,4,5,6,7,8,9

  val oddRange = 1 to 10 by 2
  println(oddRange.mkString(",")) // 1,3,5,7,9

  val rangeStep = Range(1, 10, 2)
  println(rangeStep.mkString(",")) // 1,3,5,7,9


  /**
   * List
   */
  val aList: Seq[Int] = List(1, 2, 3, 4, 5)
  println(aList) // List(1, 2, 3, 4, 5)

  val prependedList: Seq[Int] = 0 +: aList
  println(prependedList) // List(0, 1, 2, 3, 4, 5)

  val appendedList: Seq[Int] = prependedList :+ 6
  println(appendedList) // List(0, 1, 2, 3, 4, 5, 6)

  val fillList: Seq[String] = List.fill(5)("apple")
  println(fillList) // List(apple, apple, apple, apple, apple)

  val concatenateList: String = aList.mkString("-")
  println(concatenateList) // 1-2-3-4-5


  /**
   * Array
   */
  val numbers: Array[Int] = Array(1, 2, 3, 4, 5)
  println(numbers.mkString(",")) // 1,2,3,4,5

  val threeElementsInt = Array.ofDim[Int](3)
  println(threeElementsInt.mkString(",")) // 0,0,0

  val threeElementsString = Array.ofDim[String](3)
  println(threeElementsString.mkString(",")) // null,null,null

  numbers(2) = 0 // numbers.update(2, 0)
  println(numbers.mkString(",")) // 1,2,0,4,5

  val numbersSeq: Seq[Int] = numbers
  println(numbersSeq) // ArraySeq(1, 2, 0, 4, 5)


  /**
   * Vector
   */
  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector) // Vector(1, 2, 3)


  /**
   * Vector vs List
   */
  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  println(getWriteTime(numbersList)) // 4587091.847
  println(getWriteTime(numbersVector)) // 8222.036
}
