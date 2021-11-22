package lectures.part2oop

object OOBasics extends App {

  /**
   * Instantiate a class
   */
  val person1 = new Person1("John", 26)
  /*
  The statement "I am the body definition of Person1" gets printed on the screen
  Note - At every class instantiation, the body of the class gets evaluated
  */

  // Compilation Error: value age cannot be accessed as a member of Person1
  // println(person1.age)

  println(person1.x) // 2


  val person2 = new Person2("Harry")
  println(person2.age) // 0


  val person3 = new Person2
  println(person3.name) // John
}

/**
 * A class organises data (variables) and behaviour (methods)
 * Constructor - It tells that every instance of Person1 class can be created by passing name and age parameters only
 */


/**
 * name and age are class parameters and not class fields
 */
// Constructor
class Person1(name: String, age: Int) {
  /* Class body can include:
      variable definitions, method definitions, expressions, packages imports, etc
   */

  // The var or val definitions inside the class body are fields
  val x = 2

  println("I am the body definition of Person1")
}


/**
 * include val or var before parameters
 * name and age are now class fields
 */
class Person2(var name: String, val age: Int) {
  /**
   * Multiple Constructors / Auxiliary Constructors
   * Each auxiliary constructor must call one of the previously defined constructors, this would be primary constructor or previous auxiliary constructor.
   * The first statement of the auxiliary constructor must contain this keyword
   */
  def this(name: String) = {
    this(name, 0)
  }

  def this() = {
    this("John")
  }
}