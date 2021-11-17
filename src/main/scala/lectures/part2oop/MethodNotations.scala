package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def hangOutWith(person: Person) = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"${this.name}, What the heck !!"

    def isAlive: Boolean = true

    def apply() = s"Hi, my name is $name and I like $favoriteMovie"
  }

  val mary = new Person("Mary", "Inception")

  println(mary.likes("Inception")) // true

  /**
   * Infix Notation - Example of Syntactic Sugar
   * This notation works with methods only with single parameter
   */
  println(mary likes "Inception") // true

  val tom = new Person("Tom", "Fight Club")

  /**
   * Here the 'hangOutWith' is acting as an operator between mary and tom that yields a String
   * This is the reason Infix Notation is also known as Operator Notation
   */
  println(mary hangOutWith tom) // Mary is hanging out with Tom

  /**
   * All operators in scala are actually methods that we use mostly in infix notation style
   * In Scala, you can name your methods as any symbol/operator like ?, #, $, !
   */
  println(1 + 3) // 4
  println(1.+(3)) // 4


  /**
   * Prefix Notation
   */
  val x = -1

  /**
   * Unary operators are actually methods with 'unary_' prefix
   * The below example is equivalent to 'val y = -1'
   * unary_ works with only +, -, ~, !
   */
  val y = 1.unary_-

  println(!mary) // Mary, What the heck !!
  println(mary.unary_!) // Mary, What the heck !!


  /**
   * Postfix Notation
   * The usage of postfix operator notation is allowed only for methods with zero parameters
   */
  println(mary.isAlive)

  /**
   * postfix operator isAlive needs to be enabled by making the implicit value scala.language.postfixOps visible.
   * This can be achieved by adding the import clause 'import scala.language.postfixOps' or by setting the compiler option -language:postfixOps.
   * See the Scaladoc for value scala.language.postfixOps for a discussion why the feature needs to be explicitly enabled.
   */

  import scala.language.postfixOps

  println(mary isAlive)


  /**
   * apply method
   */
  println(mary.apply()) // Hi, my name is Mary and I like Inception
  println(mary()) // Hi, my name is Mary and I like Inception
}
