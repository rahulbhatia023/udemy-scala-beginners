package lectures.part1basics

object StringInterpolators extends App {

  /**
   * S - Interpolators
   */
  val name = "Mike"
  val age = 25

  var aString = s"My name is $name and I am $age years old"

  println(aString)
  // My name is Mike and I am 25 years old

  aString = s"My name is $name and I am ${age + 1} years old"

  println(aString)
  // My name is Mike and I am 26 years old


  /**
   * F - Interpolators
   */
  val speed = 1.2f
  aString = f"$name can eat $speed%2.2f burgers per minute"

  println(aString)
  // Mike can eat 1.20 burgers per minute


  // If we try to pass a Double value while formatting is done using %d specifier, compiler outputs an error. Hence f-interpolators can check for type correctness
  val x = 1.1f // Value is float
  // Compilation Error: Type Mismatch - Found float, Required Int
  //val str = f"$x%3d"


  /**
   * Raw - Interpolators
   */
  println(raw"This is a \n newline")
  // This is a \n newline

  aString = "This is a \n newline"

  println(raw"$aString")

  /**
   * This is a
   * newline
   */
}
