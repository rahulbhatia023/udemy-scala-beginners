package lectures.part2oop

object MethodOverloading extends App {
  val person = new Person("John", 26)

  person.greet("Daniel")
  // John says, Hi Daniel

  person.greet()
  // Hi, I am John
}

class Person(var name: String, val age: Int) {

  /**
   * Method Overloading - Different methods with same name but with different signature
   */

  def greet(name: String): Unit = {
    println(s"${this.name} says, Hi $name")
  }

  def greet(): Unit = {
    println(s"Hi, I am $name")
  }

  /**
   * Compilation Error - greet3 is already defined
   * No method can exist with same name and same signature and have different return type
   */
  // def greet(): Int = 23
}
