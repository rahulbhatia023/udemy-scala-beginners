package lectures.part3fp

import scala.util.{Failure, Success, Try}

object HandlingFailure extends App {

  /**
   * Create Success and Failure
   */
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("Super Failure"))

  println(aSuccess) // Success(3)
  println(aFailure) // Failure(java.lang.RuntimeException: Super Failure)

  def unsafeMethod(): String = throw new RuntimeException("No String For You")

  // println(unsafeMethod())
  // java.lang.RuntimeException: No String For You

  val tryResult = Try(unsafeMethod())
  println(tryResult) // Failure(java.lang.RuntimeException: No String For You)

  def backupMethod(): String = "A valid result"

  val safeResult = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println(safeResult) // Success(A valid result)

  def betterUnsafeMethod(): Try[String] = Try(throw new RuntimeException("No String For You"))

  def betterBackupMethod(): Try[String] = Try("A valid result")

  println(betterUnsafeMethod().orElse(betterBackupMethod())) // Success(A valid result)

  /**
   * Utilities
   */
  println(tryResult.isSuccess) // false
  println(tryResult.isFailure) // true

  println(aSuccess.map(_ * 3)) // Success(9)
  println(aSuccess.flatMap(x => Success(x * 2))) // Success(6)
  println(aSuccess.filter(_ > 5)) // Failure(java.util.NoSuchElementException: Predicate does not hold for 3)
}
