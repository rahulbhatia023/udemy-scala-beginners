package lectures.part2oop

object MethodOverloading extends App {
  val person = new Person("John", 26)

  person.greet1("Daniel")
  // Daniel says, Hi Daniel

  person.greet2("Daniel")
  // John says, Hi Daniel

  person.greet3()
  // Hi, I am John
}

class Person(var name: String, val age: Int) {

  /**
   * Method Overloading - Different methods with same name but with different signature
   */

  def greet1(name: String): Unit = {
    println(s"$name says, Hi $name")
  }

  def greet2(name: String): Unit = {
    println(s"${this.name} says, Hi $name")
  }

  def greet3(): Unit = {
    println(s"Hi, I am $name")
  }

  /**
   * Compilation Error - greet3 is already defined
   * No method can exist with same name and same signature and have different return type
   */
  // def greet3(): Int = 23
}
