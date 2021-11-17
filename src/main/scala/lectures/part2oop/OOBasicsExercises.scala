package lectures.part2oop

object OOBasicsExercises extends App {
  val author1 = new Writer("ABC", "XYZ", 1985)

  val novel = new Novel("DEF", 2015, author1)

  println(novel.isWrittenBy(author1)) // true

  val author2 = new Writer("ABC", "XYZ", 1985)

  /**
   * In spite of being the author object with the same data as of author1, we get false below
   */
  println(novel.isWrittenBy(author2)) // false


  val counter = new Counter
  counter.increment.print() // 1
  counter.increment.increment.increment.print() // 3
  counter.increment(5).print() // 5
}

class Writer(firstName: String, lastName: String, val year: Int) {
  def fullName(): String = s"$firstName $lastName"
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge: Int = year - author.year

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(newYear: Int) = new Novel(name, newYear, author)
}

class Counter(val count: Int = 0) {

  /**
   * In scala, we should never modify an existing instance
   * In case we need to modify an instance, then we should altogether create a new instance with modified values
   */
  def increment: Counter = {
    println("Incrementing")
    new Counter(count + 1)
  }

  def decrement: Counter = {
    println("Decrementing")
    new Counter(count - 1)
  }

  def increment(n: Int): Counter = {
    if (n <= 0) this
    else increment.increment(n - 1)
  }

  def decrement(n: Int): Counter = {
    if (n <= 0) this
    else decrement.decrement(n - 1)
  }

  def print(): Unit = println(count)
}