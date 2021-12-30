package lectures.part3fp

object Tuples extends App {

  /**
   * Tuples can group at most 22 elements of different types ??
   */
  val aTuple1: (Int, String) = new Tuple2(2, "Hello Scala")
  val aTuple2: (Int, String) = new Tuple2[Int, String](2, "Hello Scala")
  val aTuple3: (Int, String) = Tuple2(2, "Hello Scala")
  val aTuple4: (Int, String) = Tuple2[Int, String](2, "Hello Scala")
  val aTuple5: (Int, String) = (2, "Hello Scala")
  val aTuple6: (Int, String) = 2 -> "Hello Scala"

  println(aTuple1) // (2,Hello Scala)
  println(aTuple1._1) // 2
  println(aTuple1.copy(_2 = "Good Bye Java")) // (2,Good Bye Java)

  // swap works only with Tuple2
  println(aTuple1.swap) // (Hello Scala,2)

  val tuple3: (String, Int, Boolean) = ("Joe", 34, true)
  val tuple4: (String, Int, Boolean, Char) = ("Joe", 34, true, 'A')

  val tuple: (String, Int) = ("Joe", 34)
  val (userName, userAge) = tuple

  println(userName) // Joe
  println(userAge) // 34

  val (_, myAge) = tuple

  tuple4.productIterator.foreach(i => print(s"$i,")) // Joe,34,true,A,
}
