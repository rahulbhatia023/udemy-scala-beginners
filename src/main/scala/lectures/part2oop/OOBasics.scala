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


  val person2 = new Person2("John", 26)
  println(person2.age)

  person2.greet1("Daniel")
  // Daniel says, Hi Daniel

  person2.greet2("Daniel")
  // John says, Hi Daniel

  person2.greet3()
  // Hi, I am John
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

  // The val or val definitions inside the class body are fields
  val x = 2

  println("I am the body definition of Person1")
}


/**
 * include val or var before parameters
 * name and age are now class fields
 */
class Person2(val name: String, val age: Int) {

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