package lectures.part3fp

object Maps extends App {
  val emptyMap1: Map[Int, String] = Map.empty[Int, String]
  println(emptyMap1) // Map()

  val emptyMap2: Map[Int, String] = Map[Int, String]()
  println(emptyMap2) // Map()

  val emptyMap3 = Map()
  println(emptyMap3) // Map()

  val aMap1: Map[String, Int] = Map.apply("Jim" -> 555, "Daniel" -> 789)
  println(aMap1) // Map(Jim -> 555, Daniel -> 789)

  val aMap2: Map[String, Int] = Map(("Jim", 555), ("Daniel", 789))
  println(aMap2) // Map(Jim -> 555, Daniel -> 789)

  val aMap3: Map[String, Int] = Map("Jim" -> 555, "Daniel" -> 789)
  println(aMap3) // Map(Jim -> 555, Daniel -> 789)

  println(aMap1.contains("Jim")) // true
  println(aMap1.contains("Tom")) // false

  /**
   * Get Value for a Key
   */
  println(aMap1.get("Jim")) // Some(555)
  println(aMap1.apply("Jim")) // 555
  println(aMap1("Jim")) // 555

  // println(aMap1("Tom"))
  // java.util.NoSuchElementException: key not found: Tom

  /**
   * withDefaultValue
   */
  val aMap4: Map[String, Int] = Map(("Jim", 555), ("Daniel", 789)).withDefaultValue(-1)
  println(aMap4("Tom")) // -1

  /**
   * withDefault
   */
  val mapWithDefault: Map[Int, String] = Map(1 -> "first", 2 -> "second").withDefault(i => i + "th")
  println(mapWithDefault(1)) // first
  println(mapWithDefault(5)) // 5th

  /**
   * Adding a key value pair
   */
  val newPair: (String, Int) = "Tom" -> 123
  val newMap: Map[String, Int] = aMap3 + newPair
  println(newMap) // Map(Jim -> 555, Daniel -> 789, Tom -> 123)

  /**
   * Adding multiple key value pair
   */
  val pair1 = "Bob" -> 687
  val pair2 = "James" -> 598
  println(aMap3 + (pair1, pair2)) // Map(Jim -> 555, Daniel -> 789, Bob -> 687, James -> 598)

  /**
   * Remove Keys
   */
  val initialMap: Map[Int, String] = Map(1 -> "first", 2 -> "second")

  val finalMap1 = initialMap - 1
  println(finalMap1) // Map(2 -> second)

  val finalMap2 = initialMap - (1,2)
  println(finalMap2) // Map()

  val finalMap3 = initialMap -- List(1, 2)
  println(finalMap3) // Map()

  /**
   * Merge Maps
   */
  val leftMap: Map[Int, String] = Map(1 -> "first", 2 -> "second")
  val rightMap: Map[Int, String] = Map(2 -> "2nd", 3 -> "third")
  println(leftMap ++ rightMap) // Map(1 -> first, 2 -> 2nd, 3 -> third)

  /**
   * Merge Maps using list of pairs
   */
  val map = Map(1 -> "first", 2 -> "second")
  val list = List(2 -> "2nd", 3 -> "third")
  println(map ++ list) // Map(1 -> first, 2 -> 2nd, 3 -> third)

  /**
   * Functionals on Maps
   */

  // map
  println(newMap.map(pair => pair._1.toLowerCase -> pair._2)) // Map(jim -> 555, daniel -> 789, tom -> 123)

  // mapValues
  println(newMap.view.mapValues(value => value * 10).toMap) // Map(Jim -> 5550, Daniel -> 7890, Tom -> 1230)

  // filter
  val map1 = Map(1 -> "first", 2 -> "second")
  println(initialMap.filter((key, value) => key > 1 && value.length > 5)) // Map(2 -> second)

  // filterKeys
  println(newMap.view.filterKeys(key => key.startsWith("J")).toMap) // Map(Jim -> 555)

  /**
   * Conversions to other collections
   */

  // Map to List
  println(newMap.toList) // List((Jim,555), (Daniel,789), (Tom,123))

  // List to Map
  val namesList = List(("Mary", 567))
  println(list.toMap) // Map(Mary -> 567)

  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0))) // HashMap(J -> List(James, Jim), A -> List(Angela), M -> List(Mary), B -> List(Bob), D -> List(Daniel))
}
