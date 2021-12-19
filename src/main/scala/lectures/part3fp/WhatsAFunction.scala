package lectures.part3fp

object WhatsAFunction extends App {

  /**
   * Use functions as first class elements - Work with functions like we work with values
   * The problem is we come from object oriented world where everything is an object or instance of a class. This is how JVM was initially designed for Java.
   * So, The only way you could simulate functional programming was to use classes or instances of classes.
   */

  // In object oriented Scala, we would write a class with a method for example

  /*
  class Action {
    def execute(element: Int): String = ???
  }
  */

  /**
   * The way we can use these elements is by creating the instance of class either anonymously or non anonymously
   * The most you can do is to make the above code generic to be reused using generics
   */

  trait Action[A, B] {
    def execute(element: A): B
  }

  /**
   * This is utmost what an object oriented language would be able to do
   * This is how JVM is naturally constructed, so scala had to resort to some clever tricks to make it look like a truly functional oriented language
   * So, better design would be to:
   */

  trait MyFunction[A, B] {
    def apply(element: A): B
  }

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  /**
   * The advantage of Scala is we can call doubler like below such that it looks like a call to a function 'doubler'
   * So, the doubler which is an instance of function like class can be called like a function
   */
  println(doubler(2))

  // Scala supports these function types out of the box
  val stringToIntConverter: String => Int = new Function1[String, Int] {
    override def apply(str: String): Int = str.toInt
  }


  // Now we can actually call this converter
  println(stringToIntConverter("3") + 4)

  // By default, scala supports these function types up to 22 parameters

  // The return type of below adder could be Function2[Int, Int, Int] or '(Int, Int) => Int' as per syntactic sugar
  val adder: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // All Scala functions are objects or instances of classes derived from Function Types (Function1, Function2, Function3, etc..)
}