package exercises

abstract class MyList {
  def head: Int

  def tail: MyList

  def isEmpty: Boolean

  def add(element: Int): MyList

  def printElements: String

  override def toString: String = s"[$printElements]"
}

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException

  def tail: MyList = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add(element: Int): MyList = new Cons(element, Empty)

  def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = h

  def tail: MyList = t

  def isEmpty: Boolean = false

  def add(element: Int): MyList = new Cons(element, this)

  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}

object ListTest extends App {
  val list1 = new Cons(1, Empty)
  println(list1.head) // 1

  val list2 = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list2.tail.head) // 2

  println(list2.add(4).head) // 4

  println(list2.toString) // [1 2 3]
}