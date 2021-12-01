package lectures.part2oop

object MethodOverriding extends App {
  val animal: Animal = new Animal
  animal.eat() // nomnom
  println(animal.creatureType) // Wild

  val dog: Animal = new Dog
  dog.eat() // Crunch, Crunch
  println(dog.creatureType) // Domestic

  val cat = new Cat("Pet")
  cat.eat() // Chap, Chap
  println(cat.creatureType) // Pet


  // Polymorphism
  val anyAnimal: Animal = new Dog
  anyAnimal.eat() // Crunch, Crunch
}

class Animal {
  val creatureType = "Wild"

  def eat(): Unit = println("nomnom")

  final def walk(): Unit = println("Animal is walking")
}

class Dog extends Animal {
  override val creatureType = "Domestic"

  override def eat(): Unit = println("Crunch, Crunch")

  // Compilation Error: method walk cannot override final member method walk in class Animal
  // override def walk(): Unit = println("Dog is walking")
}

class Cat(override val creatureType: String) extends Animal {
  override def eat(): Unit = println("Chap, Chap")
}

/**
 * The above Cat class is similar to below implementation
 */
/*
class Cat(val catType: String) extends Animal {
  override val creatureType: String = catType
}*/