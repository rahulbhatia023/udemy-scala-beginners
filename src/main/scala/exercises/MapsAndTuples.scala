package exercises

import scala.annotation.tailrec

object MapsAndTuples extends App {

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    network + (person -> Set())
  }

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    @tailrec
    def removeAux(friends: Set[String], accumulator: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (friends.isEmpty) accumulator
      else removeAux(friends.tail, unfriend(accumulator, person, friends.head))
    }

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  def numFriends(network: Map[String, Set[String]], person: String): Int = {
    if (!network.contains(person)) 0
    else network(person).size
  }

  def mostFriends(network: Map[String, Set[String]]): String = {
    network.maxBy(pair => pair._2.size)._1
  }

  def numPeopleWithNoFriends(network: Map[String, Set[String]]): Int = {
    network.count(_._2.isEmpty)
  }

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    @tailrec
    def search(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) search(target, consideredPeople, discoveredPeople.tail)
        else search(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }

    search(b, Set(), network(a) + a)
  }


  val empty: Map[String, Set[String]] = Map()

  val network = add(add(empty, "Bob"), "Mary")
  println(network) // Map(Bob -> Set(), Mary -> Set())

  val friendBobMary = friend(network, "Bob", "Mary")
  println(friendBobMary) // Map(Bob -> Set(Mary), Mary -> Set(Bob))

  val unfriendBobMary = unfriend(friendBobMary, "Bob", "Mary")
  println(unfriendBobMary) // Map(Bob -> Set(), Mary -> Set())

  val removedBob = remove(friendBobMary, "Bob")
  println(removedBob) // Map(Mary -> Set())

  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Bob", "Jim")
  val testNet = friend(jimBob, "Bob", "Mary")
  println(testNet) // Map(Bob -> Set(Jim, Mary), Mary -> Set(Bob), Jim -> Set(Bob))

  println(numFriends(testNet, "Bob")) // 2
  println(numFriends(testNet, "Jim")) // 1
  println(numFriends(testNet, "Mary")) // 1

  println(mostFriends(testNet)) // Bob

  println(numPeopleWithNoFriends(testNet)) // 0

  println(socialConnection(testNet, "Jim", "Mary")) // true

  println(socialConnection(network, "Bob", "Mary")) // false
}
