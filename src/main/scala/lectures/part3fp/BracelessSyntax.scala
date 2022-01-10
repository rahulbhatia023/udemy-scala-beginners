package lectures.part3fp

object BracelessSyntax {

  /**
   * If Else
   */
  val anIfExpression: String =
    if (2 > 3) "bigger"
    else "smaller"

  // Scala 3 Syntax - Indentation Based
  val anIfExpression_v2: String =
    if 2 > 3 then
      "bigger"
    else
      "smaller"

  val anIfExpression_v3: String =
    if 2 > 3 then
      val result = "bigger"
      result
    else
      val result = "smaller"
      result

  // Scala 3 Syntax - One liner
  val anIfExpression_v4: String = if 2 > 3 then "bigger" else "smaller"


  /**
   * For Comprehension
   */
  val forComprehension: List[String] = for {
    n <- List(1, 2, 3, 4)
    s <- List("black", "white")
  } yield s"$n$s"

  // Scala 3
  val forComprehension_v2: List[String] =
    for
      n <- List(1, 2)
      s <- List("black", "white")
    yield s"$n-$s"


  /**
   * Pattern Matching
   */
  val meaningOfLife = 42
  val patternMatch: String = meaningOfLife match {
    case 1 => "The One"
    case 2 => "Double or Nothing"
    case _ => "Something Else"
  }

  // Scala 3
  val patternMatch_v2: String =
    meaningOfLife match
      case 1 => "The One"
      case 2 => "Double or Nothing"
      case _ => "Something Else"


  /**
   * Methods
   */
  def computeMeaningOfLife(arg: Int): Int = {
    val partialResult = 40


    partialResult + 2
  }

  def computeMeaningOfLife_v2(arg: Int): Int =
    val partialResult = 40


    partialResult + 2


  /**
   * Class Definition With Indentation(Same for Trait, Object, Enum)
   */
  class Animal:

    def eat(): Unit = println("I am eating")

    def grow(): Unit = println("I am growing")

    // 3000 lines of code

  end Animal // end token can be used for all indentation structures


  /**
   * Anonymous Classes
   */
  val specialAnimal: Animal = new Animal {
    override def eat(): Unit = super.eat()

    override def grow(): Unit = super.grow()
  }

  // Scala 3
  val specialAnimal_v2: Animal = new Animal :
    override def eat(): Unit = super.eat()

    override def grow(): Unit = super.grow()


  def main(args: Array[String]): Unit = {
    println(anIfExpression_v3) // smaller
    println(forComprehension_v2) // List(1-black, 1-white, 2-black, 2-white)
    println(patternMatch_v2) // Something Else
    println(computeMeaningOfLife_v2(1)) // 42
  }
}
