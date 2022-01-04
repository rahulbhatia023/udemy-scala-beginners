package lectures.part3fp

object Options extends App {
  val map = Map("key" -> "value")

  val getConcreteValue: Option[String] = map.get("key")
  println(getConcreteValue) // Some(value)

  val getAbsentValue: Option[String] = map.get("other")
  println(getAbsentValue) // None


  /**
   * Work with unsafe API
   */
  def unsafeMethod(): String = null

  // WRONG
  // val result = Some(unsafeMethod())

  val result = Option(unsafeMethod())

  println(result) // None

  def backupMethod(): String = "A valid result"

  val safeResult: Option[String] = Option(unsafeMethod()).orElse(Option(backupMethod()))

  println(safeResult) // Some(A valid result)


  /**
   * Design good and safe API
   */
  def betterUnsafeMethod(): Option[String] = None

  def betterBackupMethod(): Option[String] = Some("A valid result")

  val betterResult: Option[String] = betterUnsafeMethod().orElse(betterBackupMethod())

  println(betterResult) // Some(A valid result)


  /**
   * Functions
   */
  println(betterResult.isEmpty) // false
  println(betterUnsafeMethod().isEmpty) // true
  println(betterBackupMethod().isEmpty) // false

  println(betterResult.nonEmpty) // true
  println(betterUnsafeMethod().nonEmpty) // false
  println(betterBackupMethod().nonEmpty) // true

  println(betterResult.isDefined) // true
  println(betterUnsafeMethod().isDefined) // false
  println(betterBackupMethod().isDefined) // true

  println(betterResult.get) // A valid result
  // println(betterUnsafeMethod().get) // java.util.NoSuchElementException: None.get

  println(betterUnsafeMethod().getOrElse("Its Null")) // Its Null

  // println(betterUnsafeMethod().getOrElse(throw new IllegalArgumentException("No connection established")))
  // java.lang.IllegalArgumentException: No connection established

  val number: Option[Int] = Some(4)

  println(number.map(_ * 2)) // Some(8)
  println(number.filter(n => n > 5)) // None
  println(number.flatMap(n => Option(n * 4))) // Some(16)
}
