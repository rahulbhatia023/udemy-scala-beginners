package lectures.part2oop

object CaseClasses extends App {

  /**
   * A minimal case class needs the keyword case class, an identifier, and a parameter list which may be vacant.
   */
  case class Person(name: String, age: Int)

  /**
   * The case class parameters are by default promoted to class fields.
   * You can directly access these parameters via instance of the class without adding val / var prefix to these parameters.
   */
  val tom1 = new Person("Tom", 34)
  println(tom1.age) // 34


  /**
   * Case Class has a sensible toString implementation
   */
  println(tom1.toString) // Person(Tom,34)
  println(tom1)


  /**
   * Case Classes have equals and hashCode method already implemented out of the box
   */
  val tom2 = new Person("Tom", 34)
  println(tom1 == tom2) // true


  /**
   * Case Classes have handy copy method
   */
  val tom3 = tom2.copy(age = 45)
  println(tom3) // Person(Tom,45)


  /**
   * Case Classes have companion objects predefined
   */
  val thePerson = Person


  /**
   * We can directly create the instance of Person class without new operator as the companion object has already apply method defined
   */
  val mary = Person("Mary", 23)
}
