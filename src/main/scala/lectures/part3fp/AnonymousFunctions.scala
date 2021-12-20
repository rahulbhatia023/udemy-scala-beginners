package lectures.part3fp

object AnonymousFunctions extends App {

  /**
   * While we learnt Function Types, we noticed that instantiating a function is still very much tied to the object oriented way
   */
  val doubler1: Function1[Int, Int] = new Function1[Int, Int] {
    override def apply(x: Int): Int = x * 2
  }

  /**
   * In Scala, the above method can be written as below
   * This is known as anonymous function or lambda function
   */
  val doubler2: Int => Int = (x: Int) => x * 2

  /**
   * Given the fact that we have declared newDoubler to be of type 'Int => Int', we can remove the type from declaration of 'x'
   */
  val doubler3: Int => Int = x => x * 2

  /**
   * Consider below example where you have multiple params in a lambda function
   */
  val adder: (Int, Int) => Int = (x, y) => x + y

  /**
   * Consider below example where you have no params in a lambda function
   */
  val justDoSomething: () => Int = () => 3

  /**
   * Now consider below 2 statements and their outputs
   * The first statement prints the function instance itself whereas the second statement does an actual call to the function
   * In case of lambda, we should always use parenthesis while calling a function
   */
  println(justDoSomething) // lectures.part3fp.AnonymousFunctions$$$Lambda$4/2110121908@445b84c0
  println(justDoSomething()) // 3

  /**
   * More Syntactic Sugar:
   * Here, each underscore represents a separate argument
   * You cannot use multiple underscores for the same argument
   */
  val newDoubler: Int => Int = _ * 2
  val newAdder: (Int, Int) => Int = _ + _

  /**
   * Super Adder Implementation
   */
  val superAdder: Int => Int => Int = x => y => x + y
  println(superAdder(3)(4)) // 7
}
