package lectures.part2oop

object Inheritance extends App {

  /**
   * Scala has single class level inheritance like other languages i.e you can only inherit only one class at a time
   */

  // Super Class
  class Animal {
    def eat(): Unit = println("nomnom")

    // private methods can only be accessed by the class in which the method is defined
    private def walk(): Unit = println("I am walking")

    // protected methods can be accessed by the class in which the method is defined and the sub class
    protected def run(): Unit = println("I am running")
  }

  // Sub Class of Animal Class
  class Cat extends Animal {
    def catWalk(): Unit = {
      /**
       * Compilation Error: Not found walk
       * As walk is a private method
       */
      // walk()
    }

    def catRun(): Unit = {
      run()
    }
  }

  val cat = new Cat

  cat.eat() // nomnom

  /**
   * Compilation Error: walk is not a member of Cat
   * The sub class can only inherit non private fields and methods of super class
   */
  // cat.walk()

  /**
   * Compilation Error: method run in class Animal cannot be accessed as a member of cat from module class InheritanceAndTraits
   * Access to protected method run not permitted because enclosing object InheritanceAndTraits in package lectures.part2oop is not a subclass of class Animal in object InheritanceAndTraits where target is defined
   */
  // cat.run()


  /**
   * Super Keyword
   */
  class Dog extends Animal {
    override def eat(): Unit = {
      super.eat()
      println("Crunch, Crunch")
    }
  }

  val dog = new Dog
  dog.eat()
  /*nomnom
  Crunch, Crunch*/


  class Person(name: String, age: String)

  /**
   * Compilation Error: missing argument for parameter name of constructor Person
   */
  // class Adult(name: String, age: String, id: String) extends Person

  // Works Fine
  class Adult(name: String, age: String, id: String) extends Person(name, age)


  class Person1(name: String, age: Int) {
    def this(name: String) = {
      this(name, 0)
    }
  }

  // Works Fine
  class Adult1(name: String, age: Int, id: String) extends Person1(name)


  /**
   * Use of final keyword to prevent inheritance
   */
  final class Vehicle

  // Compilation Error: class Car cannot extend final class Vehicle
  //class Car extends Vehicle


  /**
   * Use of sealed keyword to prevent inheritance - classes in the same file can inherit but not for classes present in other files
   * This can be useful when you want to limit the number of classes to inherit from the super class
   * Suppose if you think Cat and Dog can be only two subclasses of Animal, the define Animal as sealed and define Cat and Dog classes in the same file
   */
  sealed class Employee

  class Manager extends Employee
}
