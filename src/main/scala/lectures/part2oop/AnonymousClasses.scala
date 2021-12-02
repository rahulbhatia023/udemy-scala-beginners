package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat(): Unit
  }

  val funnyAnimal = new Animal {
    override def eat(): Unit = println("hahahahahaha")
  }

  println(funnyAnimal.getClass)
  // class lectures.part2oop.AnonymousClasses$$anon$1


  /**
   * Compiler does below behind the scenes
   */
  class AnonymousClasses$$anon$1 extends Animal {
    override def eat(): Unit = println("hahahahahaha")
  }

  val funnyAnimal1 = new AnonymousClasses$$anon$1


  /**
   * Anonymous CLasses works with non abstract types as well
   */
  class Person(name: String) {
    def greet(): Unit = println(s"Hi, my name is $name")
  }

  val tom = new Person("Tom") {
    override def greet(): Unit = super.greet()
  }

  println(tom.getClass) // class lectures.part2oop.AnonymousClasses$$anon$2

  tom.greet() // Hi, my name is Tom
}
