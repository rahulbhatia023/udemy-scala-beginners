package lectures.part2oop

object Generics extends App {

  /**
   * Collections are a strong use case
   * We wound want a list which can contains items of multiple data types like Int and String both
   */

  /**
   * Type A here denotes the generic type
   * Once the generic type is defined, we can use that in the class definition
   */
  class MyList[A]

  // Int here will replace A for the instance of list of integers
  val listOfIntegers = new MyList[Int]

  // String here will replace A for the instance of list of integers
  val listOfStrings = new MyList[String]


  /**
   * We can also give multiple type parameters
   * MyMap is a generic class and Key / Value are generic types
   */
  class MyMap[Key, Value]

  /**
   * Compilation Error: Scala objects cannot be type parameterized
   */
  // object MyList[A]


  object MyList {
    // Generic Method
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers: MyList[Int] = MyList.empty[Int]


  /**
   * Variance Problem
   */
  class Animal

  class Cat extends Animal

  class Dog extends Animal

  // COVARIANCE
  class CovariantList[+A]

  val covariantList: CovariantList[Animal] = new CovariantList[Cat]


  // INVARIANCE
  class InvariantList[A]

  val invariantList: InvariantList[Animal] = new InvariantList[Animal]


  // CONTRAVARIANCE
  class Trainer[-A]

  val trainer: Trainer[Cat] = new Trainer[Animal]


  /**
   * Bounded Types
   */
  class Cage[A <: Animal](animal: A)

  // Works Fine
  val cage = new Cage(new Dog)


  // Compilation Error: Found Car, Required Animal
  class Car

  // val newCage = new Cage(new Car)


  /**
   * Bounded Type solves the Covariance Problem
   */
  class MyCollection[+A] {
    def add[B >: A](element: B): MyCollection[B] = ???
  }
}
