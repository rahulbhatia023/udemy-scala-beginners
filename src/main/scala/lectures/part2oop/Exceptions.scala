package lectures.part2oop

object Exceptions extends App {

  val aString: String = null

  // NullPointerException
  // println(aString.length)

  // throw new NullPointerException

  def getInt(withException: Boolean): Int = {
    if (withException) throw new RuntimeException("No int for you")
    else 42
  }

  /**
   * A basic way we can handle exceptions in Scala is the try/catch/finally construct
   */
  try {
    getInt(true)
  } catch {
    case e: RuntimeException => println("Caught Runtime Exception")
  } finally {
    println("Finally...")
  }

  /**
   * try/catch/finally structure is an expression
   */
  val magicChar = try {
    val scala: String = "Scala"
    scala.charAt(20)
  } catch {
    case e: StringIndexOutOfBoundsException => 'z'
  } finally {
  }

  println(magicChar) // z


  /**
   * Custom Exception
   */
  class MyException extends Exception

  throw new MyException
}
