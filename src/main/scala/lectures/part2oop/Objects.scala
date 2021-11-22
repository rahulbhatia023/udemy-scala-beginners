package lectures.part2oop

object Objects extends App {

  /**
   * Scala does not have Class Level Functionality
   * Scala does not know the concept of static
   */
  object Person {
    // Class(static) Level Functionalities

    val N_EYES = 2

    def canFly: Boolean = false

    /**
     * Factory Method - Its sole purpose is to build instance given some parameters
     */
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  /**
   * A pattern that is often practiced is that we write a class with the same name as of object in the same file or a same scope
   * Separates instance level functionalities from class level functionalities
   * This pattern is known as Companions
   */
  class Person(val name: String) {
    // Instance Level Functionalities
  }

  println(Person.N_EYES)
  println(Person.canFly)

  /**
   * Scala object is a singleton instance
   */
  val mary = Person
  val tom = Person

  println(mary == tom) // true

  /**
   * In case of companion class, the instances are not going to be the same
   */
  val person1 = new Person("Mary")
  val person2 = new Person("Mary")

  println(person1 == person2) // false

  val bobby = Person(person1, person2)
}
